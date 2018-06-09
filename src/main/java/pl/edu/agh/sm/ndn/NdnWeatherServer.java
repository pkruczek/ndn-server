package pl.edu.agh.sm.ndn;

import net.named_data.jndn.*;
import net.named_data.jndn.security.KeyChain;
import net.named_data.jndn.transport.TcpTransport;
import net.named_data.jndn.util.Blob;

import java.util.concurrent.Executors;

/**
 * Provides NDN endpoints
 * /ndn/agh/weather/
 */
public class NdnWeatherServer implements AutoCloseable {
    private final Face face;
    private final Name baseName;
    private final KeyChain keyChain;
    private final NdnWeatherController weatherController;
    private final NdnSerializer ndnSerializer;

    NdnWeatherServer(NdnWeatherController weatherController, NdnSerializer ndnSerializer) {
        try {
            this.weatherController = weatherController;
            this.ndnSerializer = ndnSerializer;

            this.face = new ThreadPoolFace(Executors.newScheduledThreadPool(1), new TcpTransport(),
                    new TcpTransport.ConnectionInfo("localhost", 6363));
            this.baseName = new Name("/ndn/agh/weather");
            this.keyChain = new KeyChain();

            this.face.setCommandSigningInfo(this.keyChain, this.keyChain.getDefaultCertificateName());
            this.face.registerPrefix(this.baseName, new OnInterestCallback() {
                @Override
                public void onInterest(Name prefix, Interest interest, Face face, long interestFilterId, InterestFilter filter) {
                    Data data = new Data(interest.getName());
                    MetaInfo meta = new MetaInfo();
                    meta.setFreshnessPeriod(5000);
                    data.setMetaInfo(meta);
                    System.out.println(String.format("Name = %s", interest.getName()));

                    String response = processRequest(interest.getName());
                    data.setContent(new Blob(response));

                    try {
                        keyChain.sign(data, keyChain.getDefaultCertificateName());
                        face.putData(data);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }, new OnRegisterFailed() {
                @Override
                public void onRegisterFailed(Name prefix) {
                    System.out.println("jNDN: failed to register prefix");
                }
            });
            System.out.println("Prefix registered");

            while (true) {
                face.processEvents();
                Thread.sleep(25);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String processRequest(Name prefix) {
        return ndnSerializer.serialize(weatherController.processRequest(prefix));
    }

    @Override
    public void close() {
        System.out.println("Closing face");
        face.shutdown();
    }
}
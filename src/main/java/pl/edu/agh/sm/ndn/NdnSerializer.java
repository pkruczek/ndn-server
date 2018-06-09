package pl.edu.agh.sm.ndn;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NdnSerializer {

    private final Gson gson;

    public String serialize(NdnResponse ndnResponse) {
        return gson.toJson(ndnResponse);
    }

}

package pl.edu.agh.sm.ndn;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;

import static pl.edu.agh.sm.ndn.NdnResponse.NdnResponseStatus.ERROR;
import static pl.edu.agh.sm.ndn.NdnResponse.NdnResponseStatus.OK;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NdnResponse {

    private final NdnResponse.NdnResponseStatus status;
    private final Map<String, Object> data;

    public static NdnResponse ok(Map<String, Object> data) {
        return new NdnResponse(OK, data);
    }

    public static NdnResponse error(String description) {
        return new NdnResponse(ERROR, Collections.singletonMap("description", description));
    }

    enum NdnResponseStatus {
        OK, ERROR
    }

}

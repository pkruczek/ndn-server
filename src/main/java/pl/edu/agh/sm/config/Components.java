package pl.edu.agh.sm.config;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Components {

    private static final Gson GSON = new Gson();

    public static Gson gson() {
        return GSON;
    }

}

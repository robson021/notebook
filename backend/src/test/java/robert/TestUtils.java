package robert;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String objectToJson(final Object obj) throws Exception {
        return mapper.writeValueAsString(obj);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);

    }
}

package untils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JsonUtils {
    private static final String USERS_FILE = "testdata/user.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {
    }

    public static User getUser(String userKey) {
        try (InputStream inputStream = JsonUtils.class.getClassLoader()
                .getResourceAsStream(USERS_FILE)) {
            if (inputStream == null) {
                throw new IllegalStateException(USERS_FILE + " not found in test resources");
            }

            Map<String, User> users = OBJECT_MAPPER.readValue(
                    inputStream,
                    new TypeReference<>() {
                    }
            );
            User user = users.get(userKey);
            if (user == null) {
                throw new IllegalArgumentException("User key not found: " + userKey);
            }
            return user;
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read user test data: " + userKey, exception);
        }
    }
}

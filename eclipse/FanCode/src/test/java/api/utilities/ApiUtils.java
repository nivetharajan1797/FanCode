package api.utilities;
import io.restassured.response.Response;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.testng.log4testng.Logger;
import api.endpoints.UserEndPoints;
import api.payload.*;

public class ApiUtils {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ApiUtils.class);

    // Method to check if user is from city "FanCode" (based on latitude and longitude)
    private boolean isFanCodeCity(double lat, double lng) {
        return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
    }

    // Fetch users from the /users endpoint and filter by "FanCode" city
    public List<Integer> getFanCodeUserIds() {
        logger.info("Fetching all users...");

        Response response = UserEndPoints.getUser();
        response.then().statusCode(200);
        

        List<User> users = response.jsonPath().getList("", User.class);
        return users.stream()
                .filter(user -> {
                    double lat = Geo.getLat();
                    double lng = Geo.getLng();
                    return isFanCodeCity(lat, lng);
                })
                .map(User::getId)
                .collect(Collectors.toList());
    }

    // Fetch todos for a given userId from the /todos endpoint
    public List<Boolean> getUserTodos(int userId) {
        logger.info("Fetching todos for user with ID: {}", userId);

        Response response = UserEndPoints.getTodos(userId);
        response.then().statusCode(200);
        // if (response.statusCode() == 404) {
        //     logger.error("User not found or todos not available for userId: " + userId);
        // } else {
        //     response.then().statusCode(200); // Continue with the expected logic
        // }
        return response.jsonPath().getList("completed", Boolean.class);
    }

}

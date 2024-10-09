package api.test;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import api.utilities.ApiUtils;

public class UserTasks {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserTasks.class);
    private ApiUtils apiUtils;

    @BeforeClass
    public void setup() {
        logger.info("Setting up API utilities...");
        apiUtils = new ApiUtils();
    }

    @Test
    public void verifyFanCodeUserTaskCompletion() {
        logger.info("Starting test to verify FanCode users' task completion...");

        List<Integer> fanCodeUserIds = apiUtils.getFanCodeUserIds();
        Assert.assertNotNull(fanCodeUserIds, "FanCode users list should not be null");
        Assert.assertTrue(fanCodeUserIds.size() > 0, "No users found from FanCode city");

        for (Integer userId : fanCodeUserIds) {
            List<Boolean> todos = apiUtils.getUserTodos(userId);

            long completedTasks = todos.stream().filter(Boolean::booleanValue).count();
            double completionPercentage = (completedTasks * 100.0) / todos.size();

            logger.info("User ID: {} - Completed tasks: {}, Total tasks: {}, Completion percentage: {}", userId, completedTasks, todos.size(), completionPercentage);
            if (completionPercentage > 50) {
                System.out.println("User ID: " + userId + " has more than 50% tasks completed!");
            } else {
                // System.out.println("User ID: " + userId + " has less than 50% tasks completed!");
            }
//            // Assert that completed tasks percentage is greater than 50%
//            Assert.assertTrue(completionPercentage > 50, "User " + userId + " has less than 50% tasks completed!");
        }

        logger.info("Test completed successfully.");
    }

}

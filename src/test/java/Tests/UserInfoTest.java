package Tests;


import Specific.UserInfoSpecification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInfoTest extends BaseTest {

    @Test
    public void getUserInfoTest() {
        String expectedLogin = "QA1";
        String user= UserInfoSpecification.userInfo(baseUrl,authToken);

        assertEquals(expectedLogin, user);


    }
}

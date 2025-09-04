package Tests;

import POJO.UserInfoPojo;
import Specific.UserInfoSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInfoTest extends BaseTest {

    @Test
    public void getUserInfoTest() {
        UserInfoPojo user = UserInfoSpecification.userInfo(baseUrl,authToken);
        String expectedLogin = "QA1";
        assertEquals(expectedLogin, user.getLogin());
    }
}

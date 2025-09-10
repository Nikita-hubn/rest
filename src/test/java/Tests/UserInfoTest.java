package Tests;

import POJO.Try;
import POJO.UserInfoPojo;
import Specific.Promezh;
import Specific.UserInfoSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInfoTest extends BaseTest {

    @Test
    public void getUserInfoTest() {
        String expectedLogin = "QA1";
        Try curent = Promezh.userInfo(baseUrl,authToken,expectedLogin);
        //assertEquals(expectedLogin, curent.getLogin());
        UserInfoPojo user= UserInfoSpecification.userInfo(baseUrl,authToken,curent.getId());
        assertEquals(user.getId(),curent.getId());
    }
}

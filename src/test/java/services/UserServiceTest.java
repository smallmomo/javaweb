package services;

import com.cmback.xncoding.services.UserService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;


public class UserServiceTest extends BaseTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testIndex() {
        assertEquals("www", "www");
    }

    @Test
    public void testLogin() {
        Map<String, Object> params = new HashMap<>();

        params.put("storeNm", "'天河区','萝岗区'");
        params.put("stTime", new Date());
        params.put("edTime", new Date());
        // params.put("inAct", "Y");
        //params.put("curDate", new Date());

        System.out.println(params);
        assertEquals(params.get("storeNm"), "'天河区','萝岗区'");
    }

    @Test
    public void testPassword() {
        String password = userService.getpassword();
        assertEquals(password, "123456");
    }

}

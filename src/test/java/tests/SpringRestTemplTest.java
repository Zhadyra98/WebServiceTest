package tests;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.util.List;


public class SpringRestTemplTest {
    @Test
    public void checkStatusCode() {
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<User[]> response = restTeampl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
        int actualStatusCode = response.getStatusCodeValue();
        Assert.assertEquals(actualStatusCode, 200);
    }
    @Test
    public void checkResponseHeader() {
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<User[]> response = restTeampl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);

        List<String> valueOfContentTypeHeader = response.getHeaders().get("content-type");
        Assert.assertTrue(valueOfContentTypeHeader.get(0).contains("application/json"));
    }

    @Test
    public void checkResponseBody() {
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<User[]> response = restTeampl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
        Assert.assertEquals(response.getBody().length, 100);
    }

}

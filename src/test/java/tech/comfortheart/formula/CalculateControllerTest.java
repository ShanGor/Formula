package tech.comfortheart.formula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(DemoApplication.class)
public class CalculateControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void testCalc() {
        int x = 12;

        String[] sourceLines = {
                "y=(x+1)^2",
                "z = y + 3"
        };
        String source =String.join("\n", sourceLines);

        CalculateRequest request = new CalculateRequest().setSource(source).addRequestValue("x", x);

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<CalculateRequest> formEntity = new HttpEntity<>(request, headers);

        Map<String, Object> result = null;

        ResponseEntity<Map> response = this.restTemplate.postForEntity("/calc", formEntity, Map.class);
        //System.out.println("response code: " + response.getStatusCode());
        // System.out.println("response body: " + response.getBody());
        result = response.getBody();

        assertEquals(result.get("z").toString(), new BigDecimal(x+1).pow(2).add(new BigDecimal(3)).toString());
        System.out.println("z is: " + result.get("z"));
    }
}

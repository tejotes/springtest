package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        {
            long startMillis = System.currentTimeMillis();
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            long durationMillis = System.currentTimeMillis() - startMillis;
            log.info(quote.toString());
            log.info(durationMillis + "[ms]");
        }

        {
            long startMillis = System.currentTimeMillis();
            Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting?name={name}", Greeting.class, "Thomas");
            long durationMillis = System.currentTimeMillis() - startMillis;
            log.info(greeting.toString());
            log.info(durationMillis + "[ms]");
        }
    }

}

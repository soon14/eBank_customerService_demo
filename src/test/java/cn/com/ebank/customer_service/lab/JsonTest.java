package cn.com.ebank.customer_service.lab;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JsonTest {


    ObjectMapper mapper = new ObjectMapper();

    @Test
    void testJava2Json() throws JsonProcessingException {
        Flow flow = new Flow();
        flow.setNow(new Date());
        flow.setAccountNumber("111");

        String s = mapper.writeValueAsString(flow);
        System.out.println("s = " + s);
    }

    @Data
    private class Flow {
        private String accountNumber;
        private Date now;

    }
}

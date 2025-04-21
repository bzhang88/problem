package org.zalando.problem.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.zalando.problem.Status;
import org.zalando.problem.StatusType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class MyTest {

    @Test
    @DisplayName("11.1 Input Status Code is in the Map")
    void TestDeserializeWithKnownStatusCode() throws IOException {
        Map<Integer, StatusType> statusMap = new HashMap<>();
        statusMap.put(400, Status.BAD_REQUEST);

        StatusTypeDeserializer deserializer = new StatusTypeDeserializer(statusMap);
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StatusType.class, deserializer);
        mapper.registerModule(module);

        StatusType result = mapper.readValue("400", StatusType.class);

        assertEquals(Status.BAD_REQUEST, result);
        assertEquals(400, result.getStatusCode());
        assertEquals("Bad Request", result.getReasonPhrase());
    }

    @Test
    @DisplayName("11.2 Multiple Input Status Code is in the Map")
    void TestDeserializeWithMultipleKnownStatusCodes() throws IOException {
        Map<Integer, StatusType> statusMap = new HashMap<>();
        statusMap.put(200, Status.OK);
        statusMap.put(402, Status.PAYMENT_REQUIRED);
        statusMap.put(500, Status.INTERNAL_SERVER_ERROR);

        StatusTypeDeserializer deserializer = new StatusTypeDeserializer(statusMap);
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StatusType.class, deserializer);
        mapper.registerModule(module);

        StatusType result200 = mapper.readValue("200", StatusType.class);
        assertEquals(Status.OK, result200);
        assertEquals(200, result200.getStatusCode());
        assertEquals("OK", result200.getReasonPhrase());

        StatusType result402 = mapper.readValue("402", StatusType.class);
        assertEquals(Status.PAYMENT_REQUIRED, result402);
        assertEquals(402, result402.getStatusCode());
        assertEquals("Payment Required", result402.getReasonPhrase());

        StatusType result500 = mapper.readValue("500", StatusType.class);
        assertEquals(Status.INTERNAL_SERVER_ERROR, result500);
        assertEquals(500, result500.getStatusCode());
        assertEquals("Internal Server Error", result500.getReasonPhrase());
    }


    @Test
    @DisplayName("11.3 Input Status Code is not in the Map")
    void TestDeserializeWithUnknownStatusCode() throws IOException {
        Map<Integer, StatusType> statusMap = new HashMap<>();
        statusMap.put(400, Status.BAD_REQUEST);

        StatusTypeDeserializer deserializer = new StatusTypeDeserializer(statusMap);
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StatusType.class, deserializer);
        mapper.registerModule(module);

        StatusType result1 = mapper.readValue("404", StatusType.class);
        StatusType result2 = mapper.readValue("500", StatusType.class);

        assertEquals(404, result1.getStatusCode());
        assertEquals("Unknown", result1.getReasonPhrase());
        assertInstanceOf(UnknownStatus.class, result1);
        assertEquals(500, result2.getStatusCode());
        assertEquals("Unknown", result2.getReasonPhrase());
        assertInstanceOf(UnknownStatus.class, result2);
    }

    @Test
    @DisplayName("11.4 The Map is empty")
    void TestDeserializeWithEmptyMap() throws IOException {
        Map<Integer, StatusType> emptyMap = new HashMap<>();

        StatusTypeDeserializer deserializer = new StatusTypeDeserializer(emptyMap);
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(StatusType.class, deserializer);
        mapper.registerModule(module);

        StatusType result = mapper.readValue("200", StatusType.class);

        assertEquals(200, result.getStatusCode());
        assertEquals("Unknown", result.getReasonPhrase());
        assertInstanceOf(UnknownStatus.class, result);
    }
}

package org.zalando.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.crypto.Data;
import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyTest {
    @Nested
    class TestCase_1_DefaultProblem_Creation {

        private static class TestStatus implements StatusType {
            @Override
            public int getStatusCode() {
                return 888;
            }

            @Override
            public String getReasonPhrase() {
                return "hello";
            }
        }

        private static final URI VALID_TYPE = URI.create("https://example.org/problems/test");
        private static final URI VALID_INSTANCE = URI.create("https://example.org/problems/instances/123");
        private static final String VALID_TITLE = "Test Problem";
        private static final String VALID_DETAIL = "This is a test problem detail";
        private static final StatusType STATUS = new TestStatus();
        private static final ThrowableProblem CAUSE = new DefaultProblem(
                URI.create("https://example.org/problems/cause"),
                "Cause Problem",
                null,
                "This is the cause",
                null,
                null);
        Map<String, Object> PARAMETERS = new HashMap<>() {{
            put("stringParam", "value");
            put("intParam", 42);
            put("boolParam", true);
        }};


        @Test
        @DisplayName("1.01 Test DefaultProblem with all null")
        public void DefaultProblemWithNull() {
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertEquals(Problem.DEFAULT_TYPE, problem.getType());
            assertNull(problem.getTitle());
            assertNull(problem.getStatus());
            assertNull(problem.getDetail());
            assertNull(problem.getInstance());
            assertNull(problem.getCause());
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("1.02 Test DefaultProblem with all valid values")
        public void DefaultProblemWithAllValid() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    VALID_TITLE,
                    STATUS,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    CAUSE,
                    PARAMETERS);

            assertEquals(VALID_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.03 Test DefaultProblem with one null type values")
        public void DefaultProblemWithTypeNull() {
            DefaultProblem problem = new DefaultProblem(
                    null,
                    VALID_TITLE,
                    STATUS,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    CAUSE,
                    PARAMETERS);

            assertEquals(Problem.DEFAULT_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.04 Test DefaultProblem with one null title values")
        public void DefaultProblemWithTitleNull() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    null,
                    STATUS,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    CAUSE,
                    PARAMETERS);

            assertEquals(VALID_TYPE, problem.getType());
            assertNull(problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.05 Test DefaultProblem with one null status values")
        public void DefaultProblemWithStatusNull() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    VALID_TITLE,
                    null,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    CAUSE,
                    PARAMETERS);

            assertEquals(VALID_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertNull(problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.06 Test DefaultProblem with one null detail values")
        public void DefaultProblemWithDetailNull() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    VALID_TITLE,
                    STATUS,
                    null,
                    VALID_INSTANCE,
                    CAUSE,
                    PARAMETERS);

            assertEquals(VALID_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertNull(problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.07 Test DefaultProblem with one null instance values")
        public void DefaultProblemWithInstanceNull() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    VALID_TITLE,
                    STATUS,
                    VALID_DETAIL,
                    null,
                    CAUSE,
                    PARAMETERS);

            assertEquals(VALID_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertNull(problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.08 Test DefaultProblem with one null cause values")
        public void DefaultProblemWithCauseNull() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    VALID_TITLE,
                    STATUS,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    null,
                    PARAMETERS);

            assertEquals(VALID_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertNull(problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }

        @Test
        @DisplayName("1.09 Test DefaultProblem with one null parameters values")
        public void DefaultProblemWithParametersNull() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    VALID_TITLE,
                    STATUS,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    CAUSE,
                    null);

            assertEquals(VALID_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("1.10.1 Test DefaultProblem with more than one null values")
        public void DefaultProblemWithMoreThanOneNull_1() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    null,
                    STATUS,
                    null,
                    VALID_INSTANCE,
                    CAUSE,
                    null);

            assertEquals(VALID_TYPE, problem.getType());
            assertNull(problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertNull(problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertTrue(problem.getParameters().isEmpty());
        }
        @Test
        @DisplayName("1.10.2 Test DefaultProblem with more than one null values")
        public void DefaultProblemWithMoreThanOneNull_2() {
            DefaultProblem problem = new DefaultProblem(
                    VALID_TYPE,
                    null,
                    STATUS,
                    null,
                    null,
                    CAUSE,
                    null);

            assertEquals(VALID_TYPE, problem.getType());
            assertNull(problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertNull(problem.getDetail());
            assertNull(problem.getInstance());
            assertEquals(CAUSE, problem.getCause());
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("1.10.3 Test DefaultProblem with more than one null values")
        public void DefaultProblemWithMoreThanOneNull_3() {
            DefaultProblem problem = new DefaultProblem(
                    null,
                    null,
                    STATUS,
                    null,
                    VALID_INSTANCE,
                    null,
                    null);

            assertEquals(Problem.DEFAULT_TYPE, problem.getType());
            assertNull(problem.getTitle());
            assertEquals(STATUS, problem.getStatus());
            assertNull(problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertNull(problem.getCause());
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("1.10.4 Test DefaultProblem with more than one null values")
        public void DefaultProblemWithMoreThanOneNull_4() {
            DefaultProblem problem = new DefaultProblem(
                    null,
                    VALID_TITLE,
                    null,
                    VALID_DETAIL,
                    VALID_INSTANCE,
                    null,
                    PARAMETERS);

            assertEquals(Problem.DEFAULT_TYPE, problem.getType());
            assertEquals(VALID_TITLE, problem.getTitle());
            assertNull(problem.getStatus());
            assertEquals(VALID_DETAIL, problem.getDetail());
            assertEquals(VALID_INSTANCE, problem.getInstance());
            assertNull(problem.getCause());
            assertEquals(PARAMETERS, problem.getParameters());
        }
    }

    @Nested
    class TestCase_2_DefaultProblem_SetParametersFunction {
        private DefaultProblem problem;

        @BeforeEach
        public void setUp() {
            problem = new DefaultProblem(null, null, null, null, null, null, null);
        }

        @Test
        @DisplayName("2.1 noInput")
        public void testGetParametersWithNoInput() {
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("2.2 input Object is null")
        public void testGetParametersWithObjectNull() {
            problem.set("null", null);

            assertEquals(1, problem.getParameters().size());
            assertNull(problem.getParameters().get("null"));
        }

        @Test
        @DisplayName("2.3 input String is null")
        public void testGetParametersWithKeyNull() {
            problem.set(null, "null");

            assertEquals(1, problem.getParameters().size());
            for (Map.Entry<String, Object> entry : problem.getParameters().entrySet()) {
                if (entry.getValue().equals("null")) {
                    assertNull(entry.getKey());
                }
            }
        }

        @Test
        @DisplayName("2.4 Both input is null")
        public void testGetParametersWithBothNull() {
            problem.set(null, null);
            assertEquals(1, problem.getParameters().size());

            Map.Entry<String, Object> firstEntry = null;
            for (Map.Entry<String, Object> entry : problem.getParameters().entrySet()) {
                firstEntry = entry;
                break;
            }
            assertNull(firstEntry.getKey());
            assertNull(firstEntry.getValue());
        }

        @Test
        @DisplayName("2.5 set (add) a parameter")
        public void testGetParametersWithDiffTypeMap() {
            problem.set("key", "value");
            assertEquals(1, problem.getParameters().size());
            assertEquals("value", problem.getParameters().get("key"));
        }

        @Test
        @DisplayName("2.6 override an existing parameter")
        public void testGetParametersWithOverride() {
            problem.set("key", "value1");
            problem.set("key", "value2");

            assertEquals(1, problem.getParameters().size());
            assertEquals("value2", problem.getParameters().get("key"));
        }

        @Test
        @DisplayName("2.7 set (add) many different type of Object parameter")
        public void testGetParametersWithMultType() {
            List<String> array = Arrays.asList("reading", "gaming", "hiking");
            Map<String, Object> someMap = new HashMap<>() {{
                put("name", "Alice");
                put("age", 30);
                put("isMember", true);
            }};
            LocalDate data = LocalDate.of(2023, 10, 15);
            problem.set("stringParam", "value");
            problem.set("intParam", 42);
            problem.set("boolParam", true);
            problem.set("hobbies", array);
            problem.set("customer", someMap);
            problem.set("eventDate", data);

            assertEquals(6, problem.getParameters().size());
            assertEquals("value", problem.getParameters().get("stringParam"));
            assertEquals(42, problem.getParameters().get("intParam"));
            assertEquals(true, problem.getParameters().get("boolParam"));
            assertEquals(array, problem.getParameters().get("hobbies"));
            assertEquals(someMap, problem.getParameters().get("customer"));
            assertEquals(data, problem.getParameters().get("eventDate"));
        }

    }

    @Nested
    class TestCase_3_DefaultProblem_GetTypeFunction {
        @Test
        @DisplayName("3.1. input type is null")
        public void testGetTypeWithNullType() {
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertEquals(Problem.DEFAULT_TYPE, problem.getType());
        }

        @Test
        @DisplayName("3.2. input type is a standard URI")
        public void testGetTypeWithStandardUri() {
            URI standardUri = URI.create("https://example.org/problems/test");
            AbstractThrowableProblem problem = new DefaultProblem(
                    standardUri, null, null, null, null, null, null);

            assertEquals(standardUri, problem.getType());
        }

        @Test
        @DisplayName("3.3. input type is a custom scheme URI")
        public void testGetTypeWithCustomSchemeUri() {
            URI customUri = URI.create("problem:out-of-stock");
            AbstractThrowableProblem problem = new DefaultProblem(
                    customUri, null, null, null, null, null, null);

            assertEquals(customUri, problem.getType());
        }

        @Test
        @DisplayName("3.4. input type is a URI with query parameters")
        public void testGetTypeWithUriWithQueryParameters() {
            URI uriWithQuery = URI.create("https://example.org/problems/test?param=value");
            AbstractThrowableProblem problem = new DefaultProblem(
                    uriWithQuery, null, null, null, null, null, null);

            assertEquals(uriWithQuery, problem.getType());
        }

        @Test
        @DisplayName("3.5. input type is a URI with fragment")
        public void testGetTypeWithUriWithFragment() {
            URI uriWithFragment = URI.create("https://example.org/problems/test#section");
            AbstractThrowableProblem problem = new DefaultProblem(
                    uriWithFragment, null, null, null, null, null, null);

            assertEquals(uriWithFragment, problem.getType());
        }
    }

    @Nested
    class TestCase_4 {
    }

    @Nested
    class TestCase_5 {
    }

    @Nested
    class TestCase_6 {
    }

    @Nested
    class TestCase_7 {
    }

    @Nested
    class TestCase_8 {
    }

    @Nested
    class TestCase_9 {
    }

    @Nested
    class TestCase_10 {
    }


}

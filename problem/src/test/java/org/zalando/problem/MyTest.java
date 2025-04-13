package org.zalando.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.crypto.Data;
import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertEquals(Problem.DEFAULT_TYPE, problem.getType());
        }

        @Test
        @DisplayName("3.2. input type is a standard URI")
        public void testGetTypeWithStandardUri() {
            URI standardUri = URI.create("https://example.org/problems/test");
            DefaultProblem problem = new DefaultProblem(
                    standardUri, null, null, null, null, null, null);

            assertEquals(standardUri, problem.getType());
        }

        @Test
        @DisplayName("3.3. input type is a custom scheme URI")
        public void testGetTypeWithCustomSchemeUri() {
            URI customUri = URI.create("problem:out-of-stock");
            DefaultProblem problem = new DefaultProblem(
                    customUri, null, null, null, null, null, null);

            assertEquals(customUri, problem.getType());
        }

        @Test
        @DisplayName("3.4. input type is a URI with query parameters")
        public void testGetTypeWithUriWithQueryParameters() {
            URI uriWithQuery = URI.create("https://example.org/problems/test?param=value");
            DefaultProblem problem = new DefaultProblem(
                    uriWithQuery, null, null, null, null, null, null);

            assertEquals(uriWithQuery, problem.getType());
        }

        @Test
        @DisplayName("3.5. input type is a URI with fragment")
        public void testGetTypeWithUriWithFragment() {
            URI uriWithFragment = URI.create("https://example.org/problems/test#section");
            DefaultProblem problem = new DefaultProblem(
                    uriWithFragment, null, null, null, null, null, null);

            assertEquals(uriWithFragment, problem.getType());
        }
    }

    @Nested
    class TestCase_4_DefaultProblem_GetTitleFunction {
        @Test
        @DisplayName("4.1 title is null")
        public void testGetTitleWithNullTitle() {
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertNull(problem.getTitle());
        }

        @Test
        @DisplayName("4.2 non-empty title")
        public void testGetTitleWithNonEmptyTitle() {
            String title = "Test Problem";
            DefaultProblem problem = new DefaultProblem(
                    null, title, null, null, null, null, null);

            assertEquals(title, problem.getTitle());
        }

        @Test
        @DisplayName("4.3 when title is empty")
        public void testGetTitleWithEmptyTitle() {
            DefaultProblem problem = new DefaultProblem(
                    null, "", null, null, null, null, null);

            assertEquals("", problem.getTitle());
        }

        @Test
        @DisplayName("4.4 title with special characters")
        public void testGetTitleWithSpecialCharacters() {
            String titleWithSpecialChars = "Problem: 特殊字符 & <symbols> 😀";
            DefaultProblem problem = new DefaultProblem(
                    null, titleWithSpecialChars, null, null, null, null, null);

            assertEquals(titleWithSpecialChars, problem.getTitle());
        }

        @Test
        @DisplayName("4.5 very long title")
        public void testGetTitleWithVeryLongTitle() {
            String longTitle = "This is a very long title that contains more than a hundred characters to test how the getTitle method handles long string values.";
            DefaultProblem problem = new DefaultProblem(
                    null, longTitle, null, null, null, null, null);

            assertEquals(longTitle, problem.getTitle());
        }
    }

    @Nested
    class TestCase_5_DefaultProblem_GetNameFunction {
        private static class TestStatus implements StatusType {
            private final int code;
            private final String reason;

            public TestStatus(int code, String reason) {
                this.code = code;
                this.reason = reason;
            }

            @Override
            public int getStatusCode() {
                return code;
            }

            @Override
            public String getReasonPhrase() {
                return reason;
            }
        }

        @Test
        @DisplayName("5.1. status is null")
        public void testGetStatusWithNullStatus() {
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertNull(problem.getStatus());
        }

        @Test
        @DisplayName("5.2. standard HTTP status")
        public void testGetStatusWithStandardHttpStatus() {
            StatusType status = new TestStatus(404, "Not Found");
            DefaultProblem problem = new DefaultProblem(
                    null, null, status, null, null, null, null);

            assertEquals(status, problem.getStatus());
            assertEquals(404, problem.getStatus().getStatusCode());
            assertEquals("Not Found", problem.getStatus().getReasonPhrase());
        }

        @Test
        @DisplayName("5.3. custom status")
        public void testGetStatusWithCustomStatus() {
            StatusType status = new TestStatus(418, "I'm a teapot");
            DefaultProblem problem = new DefaultProblem(
                    null, null, status, null, null, null, null);

            assertEquals(status, problem.getStatus());
            assertEquals(418, problem.getStatus().getStatusCode());
            assertEquals("I'm a teapot", problem.getStatus().getReasonPhrase());
        }

        @Test
        @DisplayName("5.4. error status")
        public void testGetStatusWithErrorStatus() {
            StatusType status = new TestStatus(500, "Internal Server Error");
            DefaultProblem problem = new DefaultProblem(
                    null, null, status, null, null, null, null);

            assertEquals(status, problem.getStatus());
            assertEquals(500, problem.getStatus().getStatusCode());
            assertEquals("Internal Server Error", problem.getStatus().getReasonPhrase());
        }

        @Test
        @DisplayName("5.5. redirect status")
        public void testGetStatusWithRedirectStatus() {
            StatusType status = new TestStatus(302, "Found");
            DefaultProblem problem = new DefaultProblem(
                    null, null, status, null, null, null, null);

            assertEquals(status, problem.getStatus());
            assertEquals(302, problem.getStatus().getStatusCode());
            assertEquals("Found", problem.getStatus().getReasonPhrase());
        }
    }

    @Nested
    class TestCase_6_DefaultProblem_GetDetailFunction {
        @Test
        @DisplayName("6.1. detail is null")
        public void testGetDetailWithNullDetail() {
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertNull(problem.getDetail());
        }

        @Test
        @DisplayName("6.2. non-empty detail")
        public void testGetDetailWithNonEmptyDetail() {
            String detail = "This is a test problem detail";
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, detail, null, null, null);

            assertEquals(detail, problem.getDetail());
        }

        @Test
        @DisplayName("6.3. detail is empty")
        public void testGetDetailWithEmptyDetail() {
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, "", null, null, null);

            assertEquals("", problem.getDetail());
        }

        @Test
        @DisplayName("6.4. detail with special characters")
        public void testGetDetailWithSpecialCharacters() {
            String detailWithSpecialChars = "Detail with \n newlines \t tabs and other \"special\" 'chars'";
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, detailWithSpecialChars, null, null, null);

            assertEquals(detailWithSpecialChars, problem.getDetail());
        }

        @Test
        @DisplayName("6.5. very long detail")
        public void testGetDetailWithVeryLongDetail() {
            StringBuilder longDetailBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                longDetailBuilder.append("This is a very long detail message. ");
            }
            String longDetail = longDetailBuilder.toString();

            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, longDetail, null, null, null);

            assertEquals(longDetail, problem.getDetail());
        }
    }

    @Nested
    class TestCase_7_DefaultProblem_GetParametersFunction {
        @Test
        @DisplayName("7.1. parameters is null")
        public void testGetParametersWithNullParameters() {
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertNotNull(problem.getParameters());
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("7.2. empty parameters")
        public void testGetParametersWithEmptyParameters() {
            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, new HashMap<>());

            assertNotNull(problem.getParameters());
            assertTrue(problem.getParameters().isEmpty());
        }

        @Test
        @DisplayName("7.3. parameters with string values")
        public void testGetParametersWithStringValues() {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param1", "value1");
            parameters.put("param2", "value2");

            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, parameters);

            assertEquals(2, problem.getParameters().size());
            assertEquals("value1", problem.getParameters().get("param1"));
            assertEquals("value2", problem.getParameters().get("param2"));
        }

        @Test
        @DisplayName("7.4. parameters with various value types")
        public void testGetParametersWithVariousValueTypes() {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("stringParam", "value");
            parameters.put("intParam", 42);
            parameters.put("boolParam", true);
            parameters.put("nullParam", null);

            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, parameters);

            assertEquals(4, problem.getParameters().size());
            assertEquals("value", problem.getParameters().get("stringParam"));
            assertEquals(42, problem.getParameters().get("intParam"));
            assertEquals(true, problem.getParameters().get("boolParam"));
            assertNull(problem.getParameters().get("nullParam"));
        }

        @Test
        @DisplayName("7.5. parameters with nested map")
        public void testGetParametersWithNestedMap() {
            Map<String, Object> nestedMap = new HashMap<>();
            nestedMap.put("nestedKey", "nestedValue");

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param", "value");
            parameters.put("nestedMap", nestedMap);

            AbstractThrowableProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, parameters);

            assertEquals(2, problem.getParameters().size());
            assertEquals("value", problem.getParameters().get("param"));

            Map<?, ?> returnedNestedMap = (Map<?, ?>) problem.getParameters().get("nestedMap");
            assertEquals("nestedValue", returnedNestedMap.get("nestedKey"));
        }
    }

    @Nested
    class TestCase_8_DefaultProblem_GetCauseFunction {
        @Test
        @DisplayName("8.1. cause is null")
        public void testGetCauseWithNullCause() {
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, null, null);

            assertNull(problem.getCause());
        }

        @Test
        @DisplayName("8.2. empty cause")
        public void testGetCauseWithEmptyCause() {
            DefaultProblem cause = new DefaultProblem(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, cause, null);

            assertNotNull(problem.getCause());
            assertEquals(cause, problem.getCause());
        }

        @Test
        @DisplayName("8.3. non empty cause")
        public void testGetCauseWithProvidedCause() {
            DefaultProblem cause = new DefaultProblem(
                    URI.create("https://example.org/problems/cause"),
                    "Cause Problem",
                    null,
                    "This is the cause",
                    null,
                    null,
                    null);

            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, cause, null);

            assertEquals(cause, problem.getCause());
        }

        @Test
        @DisplayName("8.4. cause with nested cause")
        public void testGetCauseWithNestedCause() {
            DefaultProblem nestedCause = new DefaultProblem(
                    URI.create("https://example.org/problems/nested-cause"),
                    "Nested Cause Problem",
                    null,
                    "This is the nested cause",
                    null,
                    null,
                    null);

            DefaultProblem cause = new DefaultProblem(
                    URI.create("https://example.org/problems/cause"),
                    "Cause Problem",
                    null,
                    "This is the cause",
                    null,
                    nestedCause,
                    null);

            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, cause, null);

            assertEquals(cause, problem.getCause());
            assertEquals(nestedCause, ((DefaultProblem) problem.getCause()).getCause());
        }
    }

    @Nested
    class TestCase_9_DefaultProblem_getMessageFunction {
        private static final String VALID_TITLE = "Test Problem";
        private static final String VALID_DETAIL = "This is a test problem detail";

        @Test
        @DisplayName("9.1. both title and detail")
        public void testGetMessageWithTitleAndDetail() {
            DefaultProblem problem = new DefaultProblem(
                    null, VALID_TITLE, null, VALID_DETAIL, null, null);

            assertEquals(VALID_TITLE + ": " + VALID_DETAIL, problem.getMessage());
        }

        @Test
        @DisplayName("9.2. only title")
        public void testGetMessageWithTitleOnly() {
            DefaultProblem problem = new DefaultProblem(
                    null, VALID_TITLE, null, null, null, null);

            assertEquals(VALID_TITLE, problem.getMessage());
        }

        @Test
        @DisplayName("9.3. only detail")
        public void testGetMessageWithDetailOnly() {
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, VALID_DETAIL, null, null);

            assertEquals(VALID_DETAIL, problem.getMessage());
        }

        @Test
        @DisplayName("9.4. title and detail are null")
        public void testGetMessageWithNullTitleAndDetail() {
            DefaultProblem problem = new DefaultProblem(
                    null, null, null, null, null, null);

            assertEquals("", problem.getMessage());
        }

        @Test
        @DisplayName("9.5. empty title and detail")
        public void testGetMessageWithEmptyTitleAndDetail() {
            DefaultProblem problem = new DefaultProblem(
                    null, "", null, "", null, null);

            assertEquals(": ", problem.getMessage());
        }
    }

    @Nested
    class TestCase_10 {
    }


}

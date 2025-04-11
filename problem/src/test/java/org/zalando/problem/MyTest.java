package org.zalando.problem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Nested
    class TestCase_1_DefaultProblem {

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
        @DisplayName("1. Test DefaultProblem with all null")
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
        @DisplayName("2. Test DefaultProblem with all valid values")
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
        @DisplayName("3. Test DefaultProblem with one null type values")
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
        @DisplayName("4. Test DefaultProblem with one null title values")
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
        @DisplayName("5. Test DefaultProblem with one null status values")
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
        @DisplayName("6. Test DefaultProblem with one null detail values")
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
        @DisplayName("7. Test DefaultProblem with one null instance values")
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
        @DisplayName("8. Test DefaultProblem with one null cause values")
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
        @DisplayName("9. Test DefaultProblem with one null parameters values")
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
        @DisplayName("10.1 Test DefaultProblem with more than one null values")
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
        @DisplayName("10.2 Test DefaultProblem with more than one null values")
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
        @DisplayName("10.3 Test DefaultProblem with more than one null values")
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
        @DisplayName("10.4 Test DefaultProblem with more than one null values")
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


}

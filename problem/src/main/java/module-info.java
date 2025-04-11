module org.zalando.problem {
    requires static org.apiguardian.api;
    requires transitive com.google.gson;
    exports org.zalando.problem;
    requires org.checkerframework.checker.qual;
    uses org.zalando.problem.spi.StackTraceProcessor;
}

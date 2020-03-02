package it.mulders.junk;

import org.openjdk.jmh.annotations.*;

/**
 * This benchmark measures different approaches to doing string concatenation:
 * <ul>
 *     <li>Using {@link StringBuilder}</li>
 *     <li>Using {@link StringBuffer}</li>
 *     <li>Using {@link String#format(String, Object...)}</li>
 *     <li>Using <pre>+</pre> (with chars)</li>
 *     <li>Using <pre>+</pre> (with Strings)</li>
 * </ul>
 * The example input formats a Maven groupId and artifactId into <pre>&lt;groupId&gt;:&lt;artifactId&gt;</pre>.
 */
public class StringFormatting {
    @State(Scope.Thread)
    public static class Params {
        public String groupId = "it.mulders.junk";
        public String artifactId = "micro-benchmarks";
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String usingStringBuilder(final Params params) {
        StringBuilder buffer = new StringBuilder(128);
        buffer.append(params.groupId).append(':').append(params.artifactId);
        return buffer.toString();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String usingStringBuffer(final Params params) {
        StringBuffer buffer = new StringBuffer(128);
        buffer.append(params.groupId).append(':').append(params.artifactId);
        return buffer.toString();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String usingStringFormat(final Params params) {
        return String.format("%s:%s", params.groupId, params.artifactId);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String usingStringPlusChar(final Params params) {
        return params.groupId + ':' + params.artifactId;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String usingStringPlusString(final Params params) {
        return params.groupId + ":" + params.artifactId;
    }
}

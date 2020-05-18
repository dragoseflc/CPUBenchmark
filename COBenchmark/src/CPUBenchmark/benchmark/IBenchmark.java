package CPUBenchmark.benchmark;

public interface IBenchmark {

	void run();
    void run(Object... options);
    void initialize (Object...params);
    void clean();
    void cancel();
    void warmUp();
}

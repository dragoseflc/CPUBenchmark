package CPUBenchmark.logging;

import java.io.IOException;

public interface ILogger {

	void write(String s) throws IOException;
	void write(long value) throws IOException;
	void write(Object...values) throws IOException;
	void close() throws IOException;
	public void writeTime(long value,TimeUnit unit);
	public void writeTime(String string, long value, TimeUnit unit);
}

package CPUBenchmark.logging;

public class ConsoleLogger implements ILogger {

	public void write(String s)
	{
		System.out.print(s);
	}

	public void write(long value)
	{
		System.out.print(value);
	}

	public void write(Object... values)
	{
		for(Object o : values)
			System.out.print(o.toString());
	}

	public void close()
	{
		
	}
	
	public void writeTime(long value, TimeUnit unit)
	{
		System.out.println(TimeUnit.toTimeUnit(value, unit)+" "+unit);
	}
	
	public void writeTime(String string, long value, TimeUnit unit)
	{
		System.out.println(string+TimeUnit.toTimeUnit(value, unit)+" "+unit);
	}

}

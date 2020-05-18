package CPUBenchmark.logging;

public enum TimeUnit {

	Nano,Micro,Mili,Sec ;

	public static double toTimeUnit(long value, TimeUnit unit)
	{
		switch(unit)
		{
			case Nano:
				return value;
			case Micro:
				return value/(double)Math.pow(10, 3);
			case Mili:
				return value/(double)Math.pow(10, 6);
			case Sec:
				return value/(double)Math.pow(10, 9);
			default:
				throw new IllegalArgumentException("Unsupported TimeUnit: "+unit);
		}
	}
}
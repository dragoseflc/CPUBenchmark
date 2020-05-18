package CPUBenchmark.benchmark;

import CPUBenchmark.benchmark.IBenchmark;

public class CPUThreadedRoots implements IBenchmark {

	private double result;
	private int size;
	private boolean running;

	@Override
	public void initialize(Object... params)
	{
		size=(Integer)params[0];
	}

	@Override
	public void warmUp()
	{
		this.run(4);
	}

	@Override
	public void run()
	{
		throw new UnsupportedOperationException("Method not implemented. Use run(Objects...) instead");
	}

	@Override
	public void run(Object... options)
	{
		int nThreads=(Integer)options[0];
		Thread[] threads = new Thread[nThreads];
		// e.g. 1 to 10,000 on 4 threads = 2500 jobs per thread
		final int jobPerThread = size/nThreads; /**/
		running = true; // flag used to stop all started threads
		// create a thread for each runnable (SquareRootTask) and start it
		for (int i = 0; i < nThreads; ++i)
		{
			threads[i]= new Thread(new SquareRootTask(i*jobPerThread+1, (i+1)*jobPerThread));
			threads[i].start();
		}
		// join threads
		try {
			for (int i = 0; i < nThreads; ++i)
			{
				threads[i].join();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void clean()
	{
		System.gc();
	}

	public String getResult()
	{
		return String.valueOf(result);
	}

	class SquareRootTask implements Runnable {

		private int from, to;
		private final double precision = 1e-4; // fixed
		public SquareRootTask(int from, int to)
		{
			this.from=from;
			this.to=to;
		}

		@Override
		public void run()
		{
			for(int i=from; i<to && CPUThreadedRoots.this.running;i++)
				this.getNewtonian(i);
		}
		
		private double getNewtonian(double x)
		{
			double s=x;
			while(Math.abs(Math.pow(s, 2)-x)>precision)
				s=(x/s+s)/2;
			return s;
		}
		
		public synchronized void addResult(double x)
		{

		}
	}
	
	@Override
	public void cancel()
	{
		// TODO Auto-generated method stub	
	}

}
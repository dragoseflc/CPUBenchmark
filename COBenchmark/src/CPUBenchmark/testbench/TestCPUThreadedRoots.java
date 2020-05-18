package CPUBenchmark.testbench;
import java.io.IOException;

import CPUBenchmark.benchmark.IBenchmark;
import CPUBenchmark.benchmark.CPUThreadedRoots;
import CPUBenchmark.logging.ConsoleLogger;
import CPUBenchmark.logging.ILogger;
import CPUBenchmark.logging.TimeUnit;
import CPUBenchmark.timing.ITimer;
import CPUBenchmark.timing.Timer;

public class TestCPUThreadedRoots {

	public static void main(String[] args) throws IOException {

		ITimer timer=new Timer();
        IBenchmark bench =new CPUThreadedRoots();
        ILogger log=new ConsoleLogger();
        
        int workload=(int) Math.pow(10, 8);
        bench.initialize(workload);
        bench.warmUp();
        
        for(int i=1;i<=32;i*=2)
        {
        	timer.start();
        	bench.run(i);
        	long time= timer.stop();
        	log.writeTime("[t="+i+"] Finished in ",time,TimeUnit.Sec);
        	double S=(double)workload/((time/Math.pow(10, 9))*i);
        	System.out.println("Score: "+S);
        }
        bench.clean();
        log.close();
	}
}

package CPUBenchmark.logging;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements ILogger {

    private FileWriter fileWriter;
    
    public FileLogger () throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String path="log_"+(dtf.format(now));
        this.fileWriter=new FileWriter(path);
    }
    
    public FileLogger (String path) throws IOException {

        this.fileWriter=new FileWriter(path);
    }

	public void write(String string) throws IOException {

		fileWriter.write(string);
	}
	
	public void write(long value) throws IOException {

		fileWriter.write(""+value);
	}

	public void write(Object... values) throws IOException {

	    for (Object o : values)
	    	fileWriter.write(o.toString());
	}

	public void close() throws IOException {

		fileWriter.close();
	}
	
	public void writeTime(long value, TimeUnit unit)
	{
		System.out.println(TimeUnit.toTimeUnit(value, unit)+" "+unit);
	}
	
	public void writeTime(String string, long value, TimeUnit unit)
	{
		System.out.print(string+TimeUnit.toTimeUnit(value, unit)+" "+unit);
	}
}

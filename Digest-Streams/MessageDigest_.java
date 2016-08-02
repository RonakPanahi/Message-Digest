/**
 * AUTHOR: RONAK PANAHI
 * Date: November 2015
 * Working with Digest Streams and Running Threads
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class MessageDigest_ {
		
	public static void main(String args[]) throws Exception {
		
		String data[] = new String[2];
		data[0] = "c:\\data.doc";
		data[1] = "c:\\data_1.doc";

		 ExecutorService threadpool = Executors.newFixedThreadPool(2);
		 Runnable msd1 = new MessageDigestThread(data[0]);
		 Runnable msd2 = new MessageDigestThread(data[1]);
		 
		 threadpool.execute(msd1);
		 threadpool.execute(msd2);
	
		 threadpool.shutdown();
		 threadpool.awaitTermination(1, TimeUnit.SECONDS);
		 System.out.println("All digesting tasks are finished!");
	}
 
}

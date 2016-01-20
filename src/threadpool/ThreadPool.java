package threadpool;

/**
 * tomDog的全局线程池
 *
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10));

}

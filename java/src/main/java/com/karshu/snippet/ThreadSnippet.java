package com.karshu.snippet;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author 叶勤勇(卡虚)
 * @date 2019/12/02
 **/
public class ThreadSnippet {
	public static final int QUEUE_SIZE = 1000;
	public static int coreSize = Runtime.getRuntime().availableProcessors();

	/**
	 * 创建线程池
	 * @return
	 */
	public static Executor newThreadPoolExecutor() {
		BlockingQueue<Runnable> priorityQueue = new LinkedBlockingQueue<Runnable>(QUEUE_SIZE);

		ThreadPoolExecutor scenePoolExecutor = new ThreadPoolExecutor(
			coreSize*2, coreSize * 20, 10, TimeUnit.MINUTES, priorityQueue,
			new ThreadFactoryBuilder().setNameFormat("scene-pool-%d").build(),
			new ThreadPoolExecutor.CallerRunsPolicy());

		return scenePoolExecutor;
	}
}

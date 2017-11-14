package httpclient;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TestHttpClient 下午5:02:31
 * <p>
 * Copyright zhaocj Inc. All rights reserved. Love ME Like Justin Bieber.
 */
public class TestHttpClient {
    private static ExecutorService executorService = new ThreadPoolExecutor(28, 35, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100000), new ThreadPoolExecutor.CallerRunsPolicy());

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++) {
            final Integer number = i;
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        System.out.println("我是第" + number + "号请求");
                        String sendGet = HttpRequest.sendGet(
                                "http://www.lukebang.com.cn/lukk/province/countTableByProvince",
                                "JSESSIONID=11b1841b-6bf9-473c-9824-fd9b328cdbf8&provinceCode=2770&offset=0");
                        System.out.println("我是返回结果：  " + sendGet);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown(); // 该方法在加入线程队列的线程执行完之前不会执行。
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("所有的子线程都结束了！");
                long end = System.currentTimeMillis();
                System.out.println("执行时长： " + (end - start));
                break;
            }
        }
    }
}

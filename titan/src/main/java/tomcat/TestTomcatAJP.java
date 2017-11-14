package tomcat;

import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 查看tomcat AJP协议端口 是否启动
 * <p>
 * SocketPort 上午10:07:13
 * <p>
 * Copyright zhaocj Inc. All rights reserved. Love ME Like Justin Bieber.
 */
public class TestTomcatAJP {

    private static final String ip = "139.129.245.200";

    private static final int nport = 8010;

    private static Boolean flag = false;

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new myTask(), 1000, 2000);// 在1秒后执行此任务,每次间隔2秒,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
        while (true) {
            if (flag == true) {
                timer.cancel();
                System.exit(0);
            }
        }
    }

    static class myTask extends TimerTask {
        Socket s;

        public myTask() throws Exception {
            s = new Socket(ip, nport);
        }

        @Override
        public void run() {
            flag = true;
            try {
                System.out.println("Connected to " + s.getInetAddress() + " on port " + s.getPort() + " from port "
                        + s.getLocalPort() + " of " + s.getLocalAddress() + "  " + new Date().getTime());
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("link failure");
            }
            // s.close();
        }
    }
}
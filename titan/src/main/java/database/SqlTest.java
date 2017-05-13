package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import database.util.DBHelp;
import database.util.DateUtils;

/**
 * 
 * SqlTest 涓嬪崍6:29:37 Copyright zhaocj Inc. All rights reserved. Love Me Like
 * Love Justin Bieber
 * 
 */
public class SqlTest {

	DBHelp db = new DBHelp();

	private static ExecutorService executorService = new ThreadPoolExecutor(
			28, 35, 0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>(100000),
			new ThreadPoolExecutor.CallerRunsPolicy());
	private static Random random = new Random();
	@Test
	public void test1() throws Exception {
		final String sql = "insert into test_order(ID,CREATE_DATE,CREATE_USER,ORDER_STATUS,SELL_GOODID,SELL_PRICE) values(?,?,?,?,?,?)";
		long start = System.currentTimeMillis();
		for (int i = 856995; i <= 1000000; i++) {
			final int num = i;
			executorService.submit(new Runnable() {
				public void run() {
					Connection con = null;
					PreparedStatement pstm = null;
					try {
						con = db.getCon();
						pstm = con.prepareStatement(sql);
						pstm.setString(1, UUID.randomUUID().toString());
						pstm.setString(2,
								DateUtils.getDate("yyyy-MM-dd HH:mm:ss"));
						pstm.setString(3, "CREATE_USER_" + num);
						pstm.setInt(4, getRandomNumber(1, 200));
						pstm.setString(5, "SELL_GOODID_" + num);
						pstm.setInt(6, getRandomNumber(1000, 20000));
						pstm.execute();
						db.closeAll(con, pstm, null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		executorService.shutdown(); // 璇ユ柟娉曞湪鍔犲叆绾跨▼闃熷垪鐨勭嚎绋嬫墽琛屽畬涔嬪墠涓嶄細鎵ц銆�
		while (true) {
			if (executorService.isTerminated()) {
				System.out.println("鎵�鏈夌殑瀛愮嚎绋嬮兘缁撴潫浜嗭紒");
				long end = System.currentTimeMillis();
				System.out.println("鎵ц鏃堕暱锛� " + (end - start));
				break;
			}
		}
	}

	@Test
	public void test2() {
	}

	public static int getRandomNumber(int min, int max) {
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}
}

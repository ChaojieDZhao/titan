package spring.timer;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext-timer.xml" })
public class AppBootstrape {
	@Test
	public void test1() throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:applicationContext-timer.xml");
		TimeUnit.MINUTES.sleep(4);
	}
	@Test
	public void test2() throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:applicationContext-timer-two.xml");
		TimeUnit.MINUTES.sleep(4);
	}

	public static void main(String[] args) throws Exception {
		
	}
}

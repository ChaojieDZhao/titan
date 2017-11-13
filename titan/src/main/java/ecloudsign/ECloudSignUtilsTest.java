package ecloudsign;

import org.junit.Test;

import com.agile.ecloud.sdk.bean.ECloudDomain;

/**
 * 
 * @author zhaocj
 *
 *         2017年9月21日
 */
public class ECloudSignUtilsTest {
	final Integer countTime = 10;

	@Test
	public void test8() {
		ECloudSignUtils.applyCert();
	}

	@Test
	public void test4() {
		for (int i = 0; i <= countTime; i++) {

		}

		ECloudSignUtils.createSeal();
	}

	@Test
	public void test5() {
		ECloudSignUtils.addHtmlTemplateHaveSignPosition("百金贷合同章");
	}

	@Test
	public void test1() {
		System.out.println(ECloudSignUtils.createContractByTemplate("EBBA36C1B398FD78"));
	}

	@Test
	public void test2() {
		ECloudSignUtils.autoSign("4E27657F87A023DA");
	}

	@Test
	public void test9() {
		ECloudSignUtils.downloadContract("4E27657F87A023DA");
	}

}

package JsonSerialize;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import pojo.Zhaochaojie;
/**
 * 
 * JsonTest 下午8:01:50
 * 
 * Copyright zhaocj Inc. All rights reserved.
 * Love ME Like Justin Bieber.
 */
public class JsonTest {
	@Test
	public void test1() {
		Zhaochaojie zcj = new Zhaochaojie();
		zcj.setAge("12");
		zcj.setName("zhaochaojie");
		String zcjJSON = JSON.toJSONString(zcj);
		System.out.println("json:" + zcjJSON);
		JSON.parseObject(zcjJSON, Zhaochaojie.class);
	}

	@Test
	public void test2() {
	}

	@Test
	public void test3() {
	}

}

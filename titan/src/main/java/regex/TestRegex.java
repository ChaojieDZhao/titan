package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRegex {
	public static final String EXTRACT_IMAGE_REGEX = "/([^a-z]*)((?i)(.jpg|.png|.gif))";

	@Test
	public void test1() {
		String regexStr = "[br][img]/upload/2017/10/19/201710191120120289.jpg[/img][br][img]/upload/2017/10/19/201710191120127319.jpg[/img][br][img]/upload/2017/10/19/201710191120122943.jpg[/img][br][img]/upload/2017/10/19/201710191120127217.jpg[/img]";
		// 邮箱验证规则
		String regEx = "[img]/upload/([\\s\\S]*?)[/img]";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(regexStr);
		matcher.find();
		int groupCount = matcher.groupCount();
		System.out.println(groupCount);
		for (int i = 0; i < groupCount; i++) {
			System.out.println(matcher.group(i));
		}
	}

	@Test
	public void test3() {
		String s = "lk;lk;lk;lk;lk;lk;[br][img]/upload/2017/10/19/201710191120120289.JpGk;lk;lk;lk;lk;lk;l[/img][br][img]upload/2017/10/19/201710191120127319.jpg[/img][br][img]/upload/2017/10/19/201710191120122943.jpgghfhgdfgfdkp[]l;lkjlkjlkj[/img][br][img]/upload/2017/10/19/201710191120127217.jpg[/img]";
		Pattern p = Pattern.compile(EXTRACT_IMAGE_REGEX);
		Matcher m = p.matcher(s);
		List<String> result = new ArrayList<String>();
		while (m.find()) {
			result.add(m.group());
		}
		for (String s1 : result) {
			System.out.println(s1);
		}
	}
}

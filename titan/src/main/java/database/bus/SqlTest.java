package database.bus;

import database.util.DBHelp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaocj
 * <p>
 * 2017年10月20日
 */
public class SqlTest {

    private static ExecutorService executorService = new ThreadPoolExecutor(28, 35, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100000), new ThreadPoolExecutor.CallerRunsPolicy());
    private static Random random = new Random();
    DBHelp db = new DBHelp();

    public static int getRandomNumber(int min, int max) {
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public static String getRandomName(Integer userType) {
        String[] firsname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦",
                "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦",
                "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
                "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐",
                "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
                "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
                "梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝",
                "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸",
                "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於", "惠", "甄", "麹", "家",
                "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷",
                "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖",
                "武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰",
                "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党",
                "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "郤", "璩", "桑", "桂", "濮", "牛", "寿", "通",
                "边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦",
                "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国",
                "文", "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖",
                "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相",
                "查", "后", "荆", "红", "游", "竺", "权", "逑", "盖", "益", "桓", "公", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人",
                "东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐",
                "锺离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "丌官", "司寇", "仉", "督", "子车", "颛孙", "端木", "巫马", "公西",
                "漆雕", "乐正", "壤驷", "公良", "拓拔", "夹谷", "宰父", "谷梁", "晋", "楚", "阎", "法", "汝", "鄢", "涂", "钦", "段干", "百里",
                "东郭", "南门", "呼延", "归", "海", "羊舌", "微生", "岳", "帅", "缑", "亢", "况", "后", "有", "琴", "梁丘", "左丘", "东门", "西门",
                "商", "牟", "佘", "佴", "伯", "赏", "南宫", "墨", "哈", "谯", "笪", "年", "爱", "阳", "佟"};
        String[] namelist = {"伟", "伟", "芳", "伟", "秀英", "秀英", "娜", "秀英", "伟", "敏", "静", "丽", "静", "丽", "强", "静", "敏",
                "敏", "磊", "军", "洋", "勇", "勇", "艳", "杰", "磊", "强", "军", "杰", "娟", "艳", "涛", "涛", "明", "艳", "超", "勇", "娟",
                "杰", "秀兰", "霞", "敏", "军", "丽", "强", "平", "刚", "杰", "桂英", "芳", "　嘉懿", "煜城", "懿轩", "烨伟", "苑博", "伟泽", "熠彤",
                "鸿煊", "博涛", "烨霖", "烨华", "煜祺", "智宸", "正豪", "昊然", "明杰", "立诚", "立轩", "立辉", "峻熙", "弘文", "熠彤", "鸿煊", "烨霖",
                "哲瀚", "鑫鹏", "致远", "俊驰", "雨泽", "烨磊", "晟睿", "天佑", "文昊", "修洁", "黎昕", "远航", "旭尧", "鸿涛", "伟祺", "荣轩", "越泽",
                "浩宇", "瑾瑜", "皓轩", "擎苍", "擎宇", "志泽", "睿渊", "楷瑞", "子轩", "弘文", "哲瀚", "雨泽", "鑫磊", "修杰", "伟诚", "建辉", "晋鹏",
                "天磊", "绍辉", "泽洋", "明轩", "健柏", "鹏煊", "昊强", "伟宸", "博超", "君浩", "子骞", "明辉", "鹏涛", "炎彬", "鹤轩", "越彬", "风华",
                "靖琪", "明诚", "高格", "光华", "国源", "冠宇", "晗昱", "涵润", "翰飞", "翰海", "昊乾", "浩博", "和安", "弘博", "宏恺", "鸿朗", "华奥",
                "华灿", "嘉慕", "坚秉", "建明", "金鑫", "锦程", "瑾瑜", "晋鹏", "经赋", "景同", "靖琪", "君昊", "俊明", "季同", "开济", "凯安", "康成",
                "乐语", "力勤", "良哲", "理群", "茂彦", "敏博", "明达", "朋义", "彭泽", "鹏举", "濮存", "溥心", "璞瑜", "浦泽", "奇邃", "祺祥", "荣轩",
                "锐达", "睿慈", "绍祺", "圣杰", "晟睿", "思源", "斯年", "泰宁", "天佑", "同巍", "奕伟", "祺温", "文虹", "向笛", "心远", "欣德", "新翰",
                "兴言", "星阑", "修为", "旭尧", "炫明", "学真", "雪风", "雅昶", "阳曦", "烨熠", "英韶", "永贞", "咏德", "宇寰", "雨泽", "玉韵", "越彬",
                "蕴和", "哲彦", "振海", "正志", "子晋", "自怡", "德赫", "君平"};
        int a = (int) Math.abs(firsname.length * Math.random());
        int b = (int) Math.abs(namelist.length * Math.random());
        // String name = firsname[a] + namelist[b];
        if (userType == 1) {
            return firsname[a];
        }
        return namelist[b];
    }

    @Test
    public void insertQQContract() throws Exception {
        // 查询出来需要添加的手机
        String querySql = "select phone from worker";
        Connection con = db.getCon();
        PreparedStatement pstm = null;
        pstm = con.prepareStatement(querySql);
        ResultSet executeQuery = pstm.executeQuery();
        while (executeQuery.next()) {
            String phone = executeQuery.getString("phone");
            System.out.println(phone);
            String sql = "INSERT INTO QQ_CONTRACT (`first_name`, `last_name`, `nick_name`, `qq_number`, `home_phone`, `work_phone`, `other_phone`, `home_mobile`, `work_mobile`, `other_mobile`, `home_fax`, `work_fax`, `depart`, `home_address`, `work_address`, `other_address`, `remark`, `personal_email`, `home_email`, `work_email`, `personal_url`, `home_url`, `work_url`, `birthday`, `duty`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, getRandomName(1));// first_name
            prepareStatement.setString(2, getRandomName(2));// last_name
            prepareStatement.setString(3, "cmyx" + String.valueOf((getRandomNumber(0, 100))));// nick_name
            prepareStatement.setString(4, null);// qq_number
            prepareStatement.setString(5, phone);// home_phone
            prepareStatement.setString(6, phone);// work_phone
            prepareStatement.setString(7, null);// other_phone
            prepareStatement.setString(8, null);// home_mobile
            prepareStatement.setString(9, null);// work_mobile
            prepareStatement.setString(10, null);// other_mobile
            prepareStatement.setString(11, null);// home_fax
            prepareStatement.setString(12, null);// work_fax
            prepareStatement.setString(13, null);// depart
            prepareStatement.setString(14, null);// home_address
            prepareStatement.setString(15, null);// work_address
            prepareStatement.setString(16, null);// other_address
            prepareStatement.setString(17, null);// remark
            prepareStatement.setString(18, null);// personal_email
            prepareStatement.setString(19, null);// home_email
            prepareStatement.setString(20, null);// work_email
            prepareStatement.setString(21, null);// personal_url
            prepareStatement.setString(22, null);// home_url
            prepareStatement.setString(23, null);// work_url
            prepareStatement.setString(24, null);// birthday
            prepareStatement.setString(25, null);// duty
            boolean execute = prepareStatement.execute();
            System.out.println(execute);
        }
        executeQuery.close();
        pstm.close();
        con.close();
    }

}

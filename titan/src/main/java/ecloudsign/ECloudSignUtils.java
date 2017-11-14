package ecloudsign;
/**
 * @author zhaocj
 * <p>
 * 2017年9月21日
 */

import com.agile.ecloud.sdk.bean.ECloudBean;
import com.agile.ecloud.sdk.bean.ECloudDomain;
import com.agile.ecloud.sdk.bean.EcloudPublicKey;
import com.agile.ecloud.sdk.http.EcloudClient;
import com.agile.ecloud.sdk.util.ClassUtil;
import com.agile.ecloud.sdk.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ECloudSignUtils {

    private static final String createSealMobile = "18888888801";
    private static final String createSealUnitName = "北京荣盛信联信息技术有限公司";
    private static final String createSealName = "合同专用章";
    private static final String createSealNumber = "1101160094267";
    private static Map<String, Object> sealPositionMap;
    private static Map<String, Object> singerInfoMap;
    private static Map<String, Object> sealInfoMap;

    static {
        // 签章的位置信息
        sealPositionMap = new HashMap<String, Object>();
        sealPositionMap.put("positionName", "seal_positon");
        sealPositionMap.put("page", 2);
        sealPositionMap.put("x", 129);
        sealPositionMap.put("y", 410);
        // 签署人的信息
        singerInfoMap = new HashMap<String, Object>();
        singerInfoMap.put("type", "1");
        singerInfoMap.put("cardType", "0");
        singerInfoMap.put("idCardNum", "110105198710408355");
        singerInfoMap.put("name", "百金贷测试证书");
        singerInfoMap.put("mobilePhone", createSealMobile);
        // 签章签署的信息
        sealInfoMap = new HashMap<String, Object>();
        sealInfoMap.put("positionName", "seal_positon");
        sealInfoMap.put("signId", "3785");
        sealInfoMap.put("signType", "2");
        // 测试账号
        String appKey = "yyz4h26q6u47ukws52";// 如需此参数，请联系公司工作人员
        String secrept = "79c4e3b5f16069145bb00fa3eb7f1607";// 如需此参数，请联系公司工作人员
        String url = "https://testapi.ecloudsign.com/";
        EcloudPublicKey.init(appKey, secrept, "1.0", url);
    }

    /**
     * 申请证书
     *
     * @return
     */
    public static ECloudDomain applyCert() {
        ECloudDomain eCloudDomain = EcloudClient.applyCert("1", "0", singerInfoMap.get("idCardNum").toString(),
                "百金贷测试证书", singerInfoMap.get("mobilePhone").toString());
        System.out.println(eCloudDomain.getData());
        System.out.println(eCloudDomain.getMessage());
        System.out.println(eCloudDomain.toJson());
        return eCloudDomain;
    }

    public static ECloudDomain createSeal() {
        ECloudDomain eCloudDomain = EcloudClient.createSeal(createSealMobile, createSealUnitName, createSealName,
                createSealNumber);
        System.out.println(eCloudDomain.getData());
        System.out.println(eCloudDomain.getMessage());
        System.out.println(eCloudDomain.toJson());
        return eCloudDomain;
    }

    /**
     * @param templateName
     *            模板名称
     */
    @Test
    public static ECloudDomain addHtmlTemplateHaveSignPosition(String templateName) {
        String testHtmlString = "C:\\Users\\Administrator\\Desktop\\工作\\新任务资料\\V1.2.7文档和例子-0914\\文档和例子\\dzht.html";
        StringBuffer sb = new StringBuffer("");
        try {
            File file = new File(testHtmlString);
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(sealPositionMap);
        System.out.println("正在执行添加模板操作。");
        ECloudDomain eCloudDomain = EcloudClient.addHtmlTemplate(templateName, sb.toString(), "",
                JSONObject.toJSONString(list));
        System.out.println(eCloudDomain.getMessage());
        System.out.println(eCloudDomain.getCode());
        System.out.println(eCloudDomain.getData());
        return eCloudDomain;
    }

    /**
     *
     * @param templateNumber
     *            模板编号
     * @return 返回合同编号
     */
    public static String createContractByTemplate(String templateNumber) {
        // 根据模板生成合同文档
        ECloudDomain eCloudDomain = EcloudClient.createContractByTemplate(templateNumber,
                JSONObject.toJSONString(ClassUtil.toMap(
                        new String[]{"{partNameA1}", "{bjdID_1}", "{partNameB1}", "{bjdID_2}", "{purposeMoney}",
                                "{repayMonth}", "{payDay}", "{partNameA2}", "{partNameB2}"},
                        "partNameA1", "bjdID_1", "partNameB1", "bjdID_2", "purposeMoney", "repayMonth", "payDay",
                        "partNameA2", "partNameB2")));

        if ("0".equals(eCloudDomain.getCode())) {
            return JSON.parseObject(eCloudDomain.getData().toString()).getString("contractNum");
        } else {
            System.out.println(eCloudDomain.getData());
            System.out.println(eCloudDomain.getMessage());
            System.out.println(eCloudDomain.toJson());
            return "ERROR:" + eCloudDomain.toJson();
        }
    }

    /**
     * 自动签约
     *
     * @param contractNumber
     *            合同编号
     */

    public static String autoSign(String contractNumber) {
        ECloudDomain eCloudDomain = EcloudClient.autoSign(JSONObject.toJSONString(singerInfoMap), contractNumber, 0,
                JSONObject.toJSONString(sealInfoMap));
        if ("0".equals(eCloudDomain.getCode())) {
            return JSON.parseObject(eCloudDomain.getData().toString()).getString("contractNum");
        } else {
            System.out.println(eCloudDomain.getData());
            System.out.println(eCloudDomain.getMessage());
            System.out.println(eCloudDomain.toJson());
            return "ERROR:" + eCloudDomain.toJson();
        }
    }

    /**
     * 下载合同
     *
     * @param contractNumber
     *            合同编号
     */
    public static void downloadContract(String contractNumber) {
        Map<String, String> map = new TreeMap();
        map.put("contractNum", contractNumber);
        ECloudBean eClioudBean = new ECloudBean("/ecs/contract/downloadContract.jspa ", "post", map);
        ECloudDomain eCloudDomain = eClioudBean.executeMethod();
        System.out.println(eCloudDomain.getMessage());
        System.out.println(eCloudDomain.getCode());
        System.out.println(eCloudDomain.getData());
        if (eCloudDomain.getCode().equals("0")) {
            JSONObject o2 = JSONObject.parseObject(eCloudDomain.getData().toString());
            JSONArray arr = (JSONArray) o2.get("bytes");
            byte[] b1 = (byte[]) JSON.parseObject(arr.toString(), byte[].class);
            FileUtil.writeFile("D:\\zcjsooooooft\\合同\\" + contractNumber + ".pdf", b1);
        }
    }
}

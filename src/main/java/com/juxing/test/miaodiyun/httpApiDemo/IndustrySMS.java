package com.juxing.test.miaodiyun.httpApiDemo;

import java.net.URLEncoder;

import com.juxing.test.miaodiyun.httpApiDemo.common.Config;
import com.juxing.test.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
//	private static String to = "1361305****";
//	private static String smsContent = "【秒嘀科技】您的验证码是345678，30分钟输入有效。";

	/**
	 * 验证码通知短信
	 */
	public static void execute(String tel,String smsContent)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + tel + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}

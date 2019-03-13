package cxp.graduate.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.junit.Test;

/**
 * 
 * @ClassName:  CodeFactory   
 * @Description:生成验证码工具类 
 * @date:   2018年9月8日 上午9:59:56
 */
public class CodeFactory {
	
	@Test
	public void demo() {
//		String code = getCode();
//		String code = "123456";
//		String str = encrypt(code);
//		System.out.println(code);
//		System.out.println(str);
//		System.out.println(authenticatePassword(str,code));
		//获取20个唯一编码
		for(int i = 0;i < 20;i++) {
			String code = getCode();
			System.out.println(code);
		}
	}
	
    private int codeCount = 6;//验证码个数
    
    static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    /*随机生成6个验证码*/
    public String getCode() {
    	//定义随机数类
        Random r = new Random();
        //定义存储验证码的类
        StringBuilder builderCode = new StringBuilder();
        for (int i = 0; i < codeCount; i++) {
            char c = codeSequence[r.nextInt(codeSequence.length)];
            builderCode.append(c);
        }
        return builderCode.toString();
    }
    
    //将字符串进行加密 
    public static String  encrypt(String str) {
        return encodeByMD5(str);
    }
    
    // 验证密码是否正确
    public static boolean authenticatePassword(String pass, String inputstr) {
        if (pass.equals((encodeByMD5(inputstr)))) {
            return true;
        } else {
            return false;
        }
    }
    
    // 对字符串进行MD5编码
    private static String encodeByMD5(String originstr) {
    	if (originstr != null) {
	        try {
	            // 创建具有指定算法名称的信息摘要
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 使用指定的字节数组对摘要进行最后的更新，然后完成摘要计算
	            byte[] results = md.digest(originstr.getBytes());
	            // 将得到的字节数组编程字符串返回
	            String resultString = byteArrayToHexString(results);
	            return resultString.toUpperCase();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
    	}
        return null;
    }
    
    // 转换字节数组为十六进制字符串
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultsb = new StringBuffer();
        int i = 0;
        for (i = 0; i < b.length; i++) {
            resultsb.append(byteToHexString(b[i]));
        }
        return resultsb.toString();
    }
    
    // 将字节转化成十六进制的字符串
    private static int byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n / 16;
        return codeSequence[d1] + codeSequence[d2];
    }
}

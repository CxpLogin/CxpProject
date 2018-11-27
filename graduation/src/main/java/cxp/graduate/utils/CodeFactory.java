package cxp.graduate.utils;

import java.util.Random;

/**
 * 
 * @ClassName:  CodeFactory   
 * @Description:生成验证码工具类 
 * @date:   2018年9月8日 上午9:59:56
 */
public class CodeFactory {
    private int codeCount = 6;//验证码个数
    
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
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
}

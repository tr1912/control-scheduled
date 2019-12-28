package com.wx.control.controlscheduled.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.binarywang.java.emoji.EmojiConverter;

public class EmojiUtil {

	private static EmojiConverter emojiConverter = EmojiConverter.getInstance();
	
	/**
	* @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
	* @param str
	* 待转换字符串
	* @return 转换后字符串
	* @throws UnsupportedEncodingException
	* exception
	*/
	/*public static String emojiConvert1(String str)
	throws UnsupportedEncodingException {
	String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";
	
	Pattern pattern = Pattern.compile(patternString);
	Matcher matcher = pattern.matcher(str);
	StringBuffer sb = new StringBuffer();
	while(matcher.find()) {
	try {
	matcher.appendReplacement(
	sb,
	"[["
	+ URLEncoder.encode(matcher.group(1),
	"UTF-8") + "]]");
	} catch(UnsupportedEncodingException e) {
	//LOG.error("emojiConvert error", e);
	throw e;
	}
	}
	matcher.appendTail(sb);
	//LOG.debug("emojiConvert " + str + " to " + sb.toString()
	//+ ", len：" + sb.length());
	return sb.toString();
	}*/

	/**
	* @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
	* @param str
	* 转换后的字符串
	* @return 转换前的字符串
	* @throws UnsupportedEncodingException
	* exception
	*/
	/*public static String emojiRecovery2(String str)
	throws UnsupportedEncodingException {
	String patternString = "\\[\\[(.*?)\\]\\]";

	Pattern pattern = Pattern.compile(patternString);
	Matcher matcher = pattern.matcher(str);

	StringBuffer sb = new StringBuffer();
	while(matcher.find()) {
	try {
	matcher.appendReplacement(sb,
	URLDecoder.decode(matcher.group(1), "UTF-8"));
	} catch(UnsupportedEncodingException e) {
	//LOG.error("emojiRecovery error", e);
	throw e;
	}
	}
	matcher.appendTail(sb);
	//LOG.debug("emojiRecovery " + str + " to " + sb.toString());
	return sb.toString();
	}*/
	
	//--------------------------------------新方式----------------------------------------------
	
	/**
     * 将str中的emoji表情转为byte数组
     *
     * @param str
     * @return
     */
    public static String emojiConvert(String str) {
        Pattern pattern = Pattern
                .compile("[^(\u2E80-\u9FFF\\w\\s`~!@#\\$%\\^&\\*\\(\\)_+-？（）——=\\[\\]{}\\|;。，、《》”：；“！……’:'\"<,>\\.?/\\\\*)]");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb2 = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb2, resolveToByte(matcher.group(0)));
        }
        matcher.appendTail(sb2);
        return sb2.toString();
    }

    /**
     * 将str中的byte数组类型的emoji表情转为正常显示的emoji表情
     *
     * @param str
     * @return
     */
    public static String emojiRecovery(String str) {
        Pattern pattern2 = Pattern.compile("<:([[-]\\d*[,]]+):>");
        Matcher matcher2 = pattern2.matcher(str);
        StringBuffer sb3 = new StringBuffer();
        while (matcher2.find()) {
            matcher2.appendReplacement(sb3, resolveToEmoji(matcher2.group(0)));
        }
        matcher2.appendTail(sb3);
        return sb3.toString();
    }

    private static String resolveToByte(String str) {
        byte[] b = str.getBytes();
        StringBuffer sb = new StringBuffer();
        sb.append("<:");
        for (int i = 0; i < b.length; i++) {
            if (i < b.length - 1) {
                sb.append(Byte.valueOf(b[i]).toString() + ",");
            } else {
                sb.append(Byte.valueOf(b[i]).toString());
            }
        }
        sb.append(":>");
        return sb.toString();
    }

    private static String resolveToEmoji(String str) {
        str = str.replaceAll("<:", "").replaceAll(":>", "");
        String[] s = str.split(",");
        byte[] b = new byte[s.length];
        for (int i = 0; i < s.length; i++) {
            b[i] = Byte.valueOf(s[i]);
        }
        return new String(b);
    }
	
	//--------------------------------------------java-emoji版本-------------------------------------------
	
	/**
     * 将str中的emoji表情转为byte数组
     *
     * @param str
     * @return
     */
    public static String emojiConvert1(String str) {
    	String result = emojiConverter.toHtml(str);
        return result;
    }

    /**
     * 将str中的byte数组类型的emoji表情转为正常显示的emoji表情
     *
     * @param str
     * @return
     */
    public static String emojiRecovery2(String str) {
    	String result=emojiConverter.toUnicode(str);
        return result;
    }
}

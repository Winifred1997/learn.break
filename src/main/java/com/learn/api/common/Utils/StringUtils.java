package com.learn.api.common.Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);

    /**
     * @param str 待转换字符串
     * @return 转换后字符串
     * @throws UnsupportedEncodingException exception
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     */
    public static String emojiConvert1(String str)
        throws UnsupportedEncodingException {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(
                    sb,
                    "[["
                        + URLEncoder.encode(matcher.group(1),
                        "UTF-8") + "]]");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("emojiConvert error", e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        LOGGER.debug("emojiConvert " + str + " to " + sb.toString()
            + ", len：" + sb.length());
        return sb.toString();
    }

    /**
     * @param str 转换后的字符串
     * @return 转换前的字符串
     * @throws UnsupportedEncodingException exception
     * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
     */
    public static String emojiRecovery2(String str)
        throws UnsupportedEncodingException {
        String patternString = "\\[\\[(.*?)\\]\\]";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(sb,
                    URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("emojiRecovery error", e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        LOGGER.debug("emojiRecovery " + str + " to " + sb.toString());
        return sb.toString();
    }

    /**
     * @param text 过滤emojy表情
     * @return 转换前的字符串
     */
    public static String filterOffUtf8Mb4(String text) {
        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        int i = 0;
        while (i < bytes.length) {
            short b = bytes[i];
            if (b > 0) {
                buffer.put(bytes[i++]);
                continue;
            }
            b += 256;
            if ((b ^ 0xC0) >> 4 == 0) {
                buffer.put(bytes, i, 2);
                i += 2;
            } else if ((b ^ 0xE0) >> 4 == 0) {
                buffer.put(bytes, i, 3);
                i += 3;
            } else if ((b ^ 0xF0) >> 4 == 0) {
                i += 4;
            }
        }
        buffer.flip();
        try {
            return new String(buffer.array(), "utf-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * @param
     * @return 转换后的字符串
     */
    public static String getStringBySZ(Object[] str) {
        StringBuffer sb = new StringBuffer();
        if (null != str && 0 < str.length) {
            for (int i = 0; i < str.length; i++) {
                sb.append(str[i]);
                sb.append(",");
            }
            if (sb.length() > 1) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } else {
            return null;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = getStringBySZ(new String[]{"1", "2", "3", "4", "5"});
        System.out.print(str);
    }

}

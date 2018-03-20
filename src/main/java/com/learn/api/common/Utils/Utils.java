package com.learn.api.common.Utils;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.DigestUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;

public class Utils {

    private final static Charset utf8Charset = Charset.forName("utf-8");
    private final static String PASSWORD_KEY = "%^&dinghuo$_";
    private static Random randGen = null;
    private static char[] numbersAndLetters = null;
    private static final Object initLock = new Object();

    private static final String PASSWORD_RANDOM = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final String SALT_RANDOM = "~!@#$%^&*()_+.,/?,.<>';0123456789abcdefghijklmnopqrstuvwxyz";

    public static String getLikePattern(String val) {
        return "%" + val + "%";
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 对密码先加密一次，主要因为以前的算法逻辑在加密时加了盐值，为了保持算法一致
     *
     * @return
     */
    public static String reEncodePassword(String rawPass, String salt) {

        if (salt != null && salt.length() != 0) {
            String md5Crypt = DigestUtils.md5DigestAsHex(salt.getBytes());
            String concat = md5Crypt.substring(0, 16).concat(rawPass)
                .concat(md5Crypt.substring(16, 32));
            return DigestUtils.md5DigestAsHex(concat.getBytes());
        } else {
            return DigestUtils
                .md5DigestAsHex(rawPass.concat(PASSWORD_KEY).getBytes())
                .toUpperCase();
        }
    }

    public static String randomString(Integer length) {

        return randomString(length, SALT_RANDOM);
    }

    public static String randomString(Integer length, String random) {

        if (length < 1) {
            return null;
        }
        if (randGen == null) {
            synchronized (initLock) {
                if (randGen == null) {
                    randGen = new Random();
                    numbersAndLetters = (random)
                        .toCharArray();
                }
            }
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(36)];
        }
        return new String(randBuffer);
    }

    public static String randomPassword(Integer length) {

        return randomString(length, PASSWORD_RANDOM);
    }

    /**
     * Object 转 Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null)
            return null;
        Map<String, Object> map = new HashMap();

        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = null;
                try {
                    value = getter != null ? getter.invoke(obj) : null;
                } catch (IllegalAccessException e) {
                    return null;
                } catch (InvocationTargetException e) {
                    return null;
                }
                map.put(key, value);
            }
            return map;
        } catch (IntrospectionException e) {

        }
        return null;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }

    public static byte[] getBytes(String str) {
        return str.getBytes(utf8Charset);
    }
}

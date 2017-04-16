package com.jp.fristandroidapp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by jipeng on 2017/3/22.
 */

public class CommonUtils {

    /**
     *
     * 将参数按照字段名的 ASCII 码从小到大排序（字典序）后，使用 URL 键值
     * 对的格式（即key1=value1&key2=value2…）拼接成字符串
     *
     * @param paraMap
     *            转换参数
     * @param isURLEncode
     *            是否对所有Value进行URLEncod转码,如果为true会进行URLEncod转码（将特殊字符变成%20），否则将保持原样
     * @return
     *
     */
    public static String formatQueryParaMap(Map<String, String> paraMap, boolean isURLEncode) {
        String returnValue = null;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(paraMap.entrySet());
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < infoIds.size(); i++) {
                Map.Entry<String, String> item = infoIds.get(i);
                if (null != item.getKey() && !"".equals(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (isURLEncode) {
                        val = URLEncoder.encode(val, "UTF-8");
						/* 空格通过URLEncoder转码后是“+”,所有要替换成“%20” */
                        val = val.replace("+","%20");
                    }
                    buff.append(key + "=" + val + "&");
                }
            }
            returnValue = buff.toString();
            if (null != returnValue && !"".equals(returnValue)) {
                returnValue = returnValue.substring(0, returnValue.length() - 1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return returnValue;
    }


    /**
     * getVersion 获取设备版本号
     * */
    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "未找到版本号";
        }
    }


    /**
     * getMD5Digest 进行MD5加密（32位）
     * */
    public static String getMD5Digest(String content) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(content.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] bytes = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            if ((Integer.toHexString(0xFF & bytes[i])).length() == 1) {
                stringBuffer.append("0").append(
                        Integer.toHexString(0xFF & bytes[i]));
            } else {
                stringBuffer.append(Integer.toHexString(0xFF & bytes[i]));
            }
        }
//        return stringBuffer.toString().toUpperCase(Locale.getDefault());//进行变成大写
        return stringBuffer.toString();
    }



}

package cn.mori.web.util;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/5/9 14:05
 */
public class checkFormUtils {
    public static boolean checkCode(String checkCode, String realCode) {
        if (realCode != null && realCode.equalsIgnoreCase(checkCode)) {
            return true;
        }
        return false;
    }
}

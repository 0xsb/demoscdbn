/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The Class StringUtil.
 *
 * @author Locust
 */
public class StringUtil {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //System.out.println( maxsubstringLength("123ldyldy", "ldyldy"));
        /*
         * String sql = "creAted";
         * 
         * System.out.println(checkSqlForselect(sql));
         */

        /*
         * String t1 = StringUtil.StringXor("1", "0"); System.out.println(t1);
         * 
         * String t2 = StringUtil.StringXor("A", "A"); System.out.println(t2);
         * 
         * String t3 = StringUtil.StringXor("64e46c9ca4a4a4ac9c6ce464e49caca4",
         * "549BE1286EB5FC4289CF165CA3E93077"); System.out.println(t3);
         * 
         * List<String> intStr = new ArrayList<String>(); intStr.add("22");
         * intStr.add("10"); intStr.add("12"); intStr.add("14");
         * intStr.add("16"); intStr.add("18"); intStr.add("20"); int[] sorted =
         * StringUtil.sortInt(intStr); for (int i = 0; i < sorted.length; i++) {
         * System.out.println(sorted[i]); }
         */

        /*
         * byte[] tb = StringUtil.str2Hex("ABCDEF"); String str =
         * StringUtil.byte2HexStr(tb); System.out.println(str);
         * 
         * String[] lv = StringUtil.getLV("00"); System.out.println(lv[0] + ";"
         * + lv[1]); lv = StringUtil.getLV("01AB"); System.out.println(lv[0] +
         * ";" + lv[1]); lv =
         * StringUtil.getLV("7FABABABABABABABABABABABABABABABAB");
         * System.out.println(lv[0] + ";" + lv[1]); lv =
         * StringUtil.getLV("8100ABABABABABABABAB"); System.out.println(lv[0] +
         * ";" + lv[1]); lv = StringUtil.getLV("81FFABABABABABABABAB");
         * System.out.println(lv[0] + ";" + lv[1]); lv =
         * StringUtil.getLV("82010081FFABABABABABABABAB");
         * System.out.println(lv[0] + ";" + lv[1]); lv =
         * StringUtil.getLV("82FFFF81FFABABABABABABABAB");
         * System.out.println(lv[0] + ";" + lv[1]); lv =
         * StringUtil.getLV("FFFF81FFABABABABABABABAB");
         * System.out.println(lv[0] + ";" + lv[1]);
         */
    }

    /** The Constant ILLEGAL_SQL_INFO. */
    // 自定义查询提示
    public static final String ILLEGAL_SQL_INFO = "请检查sql语句格式！";

    /** The Constant SELECT_WARN_INFO. */
    public static final String SELECT_WARN_INFO = "超级管理员只允许查询，请修改语句！";

    /**
     * Slice list.
     * 将一个数组分成几个同等长度的数组
     * array[分割的原数组]
     * size[每个子数组的长度]
     * @param list the list
     * @param size the size
     * @return the linked list
     */
    public static LinkedList<List<LinkedHashMap<String, String>>> sliceList(List<LinkedHashMap<String, String>> list,
                                                                            int size) {
        LinkedList<List<LinkedHashMap<String, String>>> result = new LinkedList<List<LinkedHashMap<String, String>>>();
        double ceil = Math.ceil((float) list.size() / (float) size);
        for (int x = 0; x < ceil; x++) {
            int start = x * size;
            int end = start + size;
            if (x + 1 >= ceil) {
                end = start + list.size() % size;
            }
            result.add(list.subList(start, end));
        }
        return result;
    }

    /**
     * 最大相同子串长度.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public static int maxsubstringLength(String s1, String s2) {
        String max = (s1.length() > s2.length()) ? s1 : s2;
        String min = max.equals(s1) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int m = 0, n = min.length() - i; n != min.length() + 1; m++, n++) {
                String sub = min.substring(m, n);
                if (max.contains(sub)) {
                    return sub.length();
                }
            }
        }
        return 0;
    }

    /**
     * 计算文件大小.
     *
     * @param input the input
     * @return the string
     */
    public static String chuYi(String input) {
        Double parseInt = Double.parseDouble(input);
        Double b1 = (Double) parseInt / new Double(1024);
        if (b1 > 1.0) {
            Double b = (Double) b1 / new Double(1024);
            if (b > 1.0) {
                return new BigDecimal(b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "mb";
            } else {
                return new BigDecimal(b1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()
                        + "kb";
            }
        } else {
            return input + "b";
        }
    }

    /*
     * 全角空格为12288，半角空格为32 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
     * 全角(SBC)字符转半角(DBC)字符
     */
    /**
     * To DBC.
     *
     * @param input the input
     * @return the string
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }

            if (c[i] > 65280 && c[i] < 65375) {

                c[i] = (char) (c[i] - 65248);
            }
        }

        return new String(c);

    }

    /**
     * xssCodeShow.
     *
     * @param s the s
     * @return the string
     */
    public static String xssCodeShow(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '>':
                    sb.append("＞");// 转义大于号
                    break;
                case '<':
                    sb.append("＜");// 转义小于号
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * 相关符号转换.
     *
     * @param str the str
     * @return String
     */

    public static String replaceCHToEN(String str) {
        String[] regs = { "！", "，", "。", "；", "（", "）", "‘", "’", "!", ",", ".", ";", "(", ")","'", "'" };
        for (int i = 0; i < regs.length / 2; i++) {
            str = str.replaceAll(regs[i], regs[i + regs.length / 2]);
        }
        return str;
    }

    /**
     * 检验sql语句，只允许查询.
     *
     * @param sql the sql
     * @return boolean
     */
    public static boolean checkSqlForselect(String sql) {

        boolean b = true;
        Pattern p = Pattern
                .compile(
                        "^(truncate|create|insert|update|delete|drop|alter|describe|alias|grant|rename|"
                                + "index|references|lock|process|file|replication|shutdowm|super|execute|set)$",
                        Pattern.CASE_INSENSITIVE);
        String[] splitArr = sql.split(" ");
        for (int i = 0; i < splitArr.length; i++) {

            String s = splitArr[i];
            Matcher m = p.matcher(s);
            if (m.matches()) {
                b = false;
                // System.out.println("sql不符合要求***************************************");
                break;
            }
        }
        return b;
    }

    /**
     * 二进制转换int.
     *
     * @param b the b
     * @return the int
     * @throws NumberFormatException the number format exception
     */
    public static int hex2int(byte b) throws NumberFormatException {
        int result = 0;
        if (b >= 48 && b <= 57) {
            result = b - 48;
        } else if (b >= 97 && b <= 102) {
            result = (b - 97) + 10;
        } else if (b >= 65 && b <= 70) {
            result = (b - 65) + 10;
        } else {
            throw new NumberFormatException();
        }
        return result;
    }

    /**
     * Str 2 hex.
     *
     * @param str            Hex encoded String
     * @return the byte[]
     */
    public static byte[] str2Hex(String str) {

        if (str == null || str.length() % 2 != 0) {
            return null;
        }
        int byteLen = str.length() / 2;
        byte[] result = new byte[byteLen];
        byte[] tmpBytes = str.getBytes();
        for (int i = 0; i < byteLen; i++) {
            result[i] = (byte) (hex2int(tmpBytes[i * 2]) << 4 & 0xf0 | hex2int(tmpBytes[i * 2 + 1]) & 0xf);
        }

        return result;
    }

    /**
     * 字节转字符串.
     *
     * @param b the b
     * @return the string
     */
    public static String byte2Str(byte[] b) {
        StringBuffer sb = new StringBuffer(200);
        if (b == null) {
            return null;
        }
        for (int i = 0; i < b.length; i++) {
            sb.append(Character.forDigit(b[i] >> 4 & 0xf, 16));
            sb.append(Character.forDigit(b[i] & 0xf, 16));
        }

        return sb.toString();
    }

    /**
     * 字节转Long.
     *
     * @param b the b
     * @return the long
     */
    public static long byte2Long(byte[] b) {
        return 0L;
    }

    /**
     * 字节数组比较.
     *
     * @param b1 the b 1
     * @param b2 the b 2
     * @return true, if successful
     */
    public static boolean equals(byte[] b1, byte[] b2) {
        if (b1 == b2) {
            return true;
        }
        if (b1 == null || b2 == null || b1.length != b2.length) {
            return false;
        }
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] != b2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 国标转uncode.
     *
     * @param str the str
     * @return the byte[]
     */
    public static byte[] gb2unicode(String str) {
        /*
         * if(str == null) { break MISSING_BLOCK_LABEL_75; } ByteBuffer bb; byte
         * org[] = str.getBytes("gb2312"); ByteToCharConverter converter =
         * ByteToCharConverter.getConverter("gb2312"); char c[] =
         * converter.convertAll(org); bb = new ByteBuffer(); for(int i = 0; i <
         * c.length; i++) { byte tmp[] = charToByte(c[i]); bb.appendBytes(tmp);
         * }
         * 
         * return bb.getData(); Object obj; obj; break MISSING_BLOCK_LABEL_75;
         * obj;
         */
        return null;
    }

    /**
     * char转byte.
     *
     * @param ch the ch
     * @return the byte[]
     */
    public static byte[] charToByte(char ch) {
        int tmp = ch;
        byte[] result = new byte[2];
        result[0] = (byte) (tmp >> 8 & 0xff);
        result[1] = (byte) (tmp & 0xff);
        return result;
    }

    /**
     * 字节数组转char.
     *
     * @param b the b
     * @return the char[]
     */
    public static char[] byteToChar(byte[] b) {
        if (b == null || b.length % 2 != 0) {
            return null;
        }
        char[] result = new char[b.length / 2];
        for (int i = 0; i < b.length / 2; i++) {
            int j = ((b[2 * i] & 0xff) << 8) + (b[2 * i + 1] & 0xff);
            result[i] = (char) j;
        }

        return result;
    }

    /**
     * uncode转国标.
     *
     * @param b the b
     * @return the string
     */
    public static String unicode2Gb2312(byte[] b) {
        /*
         * char chars[]; chars = byteToChar(b); if(chars == null) { break
         * MISSING_BLOCK_LABEL_43; } CharToByteConverter converter = null; byte
         * result1[]; CharToByteConverter converter =
         * CharToByteConverter.getConverter("gb2312"); result1 =
         * converter.convertAll(chars); return new String(result1, "gb2312");
         * MalformedInputException e; e; break MISSING_BLOCK_LABEL_43; e;
         * e.printStackTrace();
         */
        return null;
    }

    /**
     * 获取ADN字节数组.
     *
     * @param menuName the menu name
     * @param encoding the encoding
     * @return the ADN bytes
     */
    public static byte[] getADNBytes(String menuName, String encoding) {
        if (menuName == null) {
            return null;
        }
        if ("gb2312".equalsIgnoreCase(encoding)) {
            byte[] b = gb2unicode(menuName);
            if (b != null) {
                byte[] result = new byte[b.length + 1];
                result[0] = -128;
                System.arraycopy(b, 0, result, 1, b.length);
                return result;
            } else {
                return null;
            }
        } else {
            return menuName.getBytes();
        }
    }

    /**
     * String to ascii string.
     *
     * @param content the content
     * @return the string
     */
    public static String stringToAsciiString(String content) {
        String result = "";
        if (content != null && content.length() > 0) {
            int max = content.length();
            for (int i = 0; i < max; i++) {
                char c = content.charAt(i);
                String b = Integer.toHexString(c);
                result = result + b;
            }
        }
        return result;
    }

    /**
     * Append FF to len.
     *
     * @param src the src
     * @param maxBytesLen the max bytes len
     * @return the string
     */
    public static String appendFFToLen(String src, int maxBytesLen) {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(src);
        int strLen = maxBytesLen * 2;
        while (strBuffer.length() < strLen) {
            strBuffer.append("FF");
        }
        return strBuffer.toString();
    }

    /**
     * Byte 2 hex str.
     *
     * @param b the b
     * @return the string
     */
    public static String byte2HexStr(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;

            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    /**
     * Left append zero.
     *
     * @param hexStr the hex str
     * @param finalLen the final len
     * @return the string
     */
    public static String leftAppendZero(String hexStr, int finalLen) {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append(hexStr);

        while (strBuf.toString().length() < finalLen) {
            strBuf.insert(0, "0");
        }
        return strBuf.toString();
    }

    /**
     * Int to hex.
     *
     * @param n the n
     * @param strLen the str len
     * @return the string
     * @方法名：intToHex 
     * @描述：Convert an integer to a hex string with a specified length If the
     *             result string size is less than the length, append "0" on the
     *             left
     * @输出：String 
     * @作者：liqingsong 
     */
    public static String intToHex(int n, int strLen) {
        String instr = Integer.toHexString(n);
        StringBuilder strBuf = new StringBuilder();
        int i = strLen - instr.length();
        if (i <= 0) {
            return instr;
        } else {
            for (; i > 0; i--) {
                strBuf.append("0");
            }
        }
        strBuf.append(instr);
        return strBuf.toString();
    }

    /**
     * Gets the BERTLV len.
     *
     * @param len the len
     * @return the BERTLV len
     * @方法名：getBERTLVLen 
     * @输出：String 
     * @作者：liqingsong 
     */
    public static String getBERTLVLen(int len) {
        if (len > 255) {
            return "82" + StringUtil.intToHex(len, 4);
        } else if (len > 127) {
            return "81" + StringUtil.intToHex(len, 2);
        } else {
            return StringUtil.intToHex(len, 2);
        }
    }

    /**
     * Gets the lv.
     *
     * @param data            BER-TLV format without tag field.
     * @return @输出：String[] [0]:length, [2]:value
     * @方法名：getLV 
     * @描述：Parse the input parameter and generate a LV array
     * @作者：liqingsong 
     */
    public static String[] getLV(String data) {
        if (data == null || "".equals(data)) {
            throw new IllegalArgumentException("The parameter is invalid");
        }
        String[] lv = new String[2];
        if (Integer.parseInt(data.substring(0, 2), 16) <= 127
                && Integer.parseInt(data.substring(0, 2), 16) >= 0) {
            lv[0] = data.substring(0, 2);
            if (Integer.parseInt(data.substring(0, 2), 16) > 0) {
                lv[1] = data.substring(2);
            } else {
                lv[1] = "";
            }
        } else if (data.startsWith("81")) {
            lv[0] = data.substring(0, 4);
            lv[1] = data.substring(4);
        } else if (data.startsWith("82")) {
            lv[0] = data.substring(0, 6);
            lv[1] = data.substring(6);
        } else {
            throw new IllegalArgumentException("The parameter not belong to BER-TLV format");
        }
        return lv;
    }

    /**
     * Sort int.
     *
     * @param intStrList the int str list
     * @return @输出：int[]
     * @方法名：sortInt 
     * @描述：Sort an integer list which is decorated in a string list
     * @作者：Peter 
     */
    public static int[] sortInt(List<String> intStrList) {
        if (intStrList != null) {
            int[] sorted = new int[intStrList.size()];
            for (int i = 0; i < sorted.length; i++) {
                sorted[i] = Integer.parseInt((String) (intStrList.get(i)));
            }
            Arrays.sort(sorted);
            return sorted;
        } else {
            return null;
        }
    }

    /**
     * String xor.
     *
     * @param str1            hex string
     * @param str2            hex string
     * @return the string
     * @方法名：StringXor 
     * @描述：compute two hex string's xor
     * @输出：String 
     * @作者：Peter 
     */
    public static String stringXor(String str1, String str2) {
        BigInteger big1 = new BigInteger(str1, 16);
        BigInteger big2 = new BigInteger(str2, 16);
        return big1.xor(big2).toString(16);

    }

    /**
     * 判断字符串不能为null或者空串或者空格串 否则返回false.
     *
     * @param args the args
     * @return true, if is not N ull
     */
    public static boolean isNotNUll(String... args) {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if (null == args[i] || "".equals(args[i].trim()) || "null".equals(args[i].trim())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断手机号码是否合法.
     *
     * @param phoneNum the phone num
     * @return true, if is phone num
     */
    public static boolean isPhoneNum(String phoneNum) {

        String regex = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNum);
        return m.matches();

    }

    /**
     * 判断字符串中是否仅包含字母,汉字
     * 各种字符的unicode编码的范围：
     * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
     * 小写字母：[0x61,0x7a]（或十进制[97, 122]）
     * 大写字母：[0x41,0x5a]（或十进制[65, 90]）.
     *
     * @param str the str
     * @return true, if is name legal
     */
    public static boolean isNameLegal(String str) {
        String regex = "^[a-zA-Z\u4e00-\u9fa5]+$";
        return str.matches(regex);
    }

    /**
     * 判断是否包含连续2个以及2个以上的分号;.
     *
     * @param str the str
     * @return true, if is contain two more semicolon
     */
    public static boolean isContainTwoMoreSemicolon(String str) {
        String regex = "^.*(;)\\1{1,}.*$";
        return str.matches(regex);
    }

    /**
     * 合并数组.
     *
     * @param a the a
     * @param b the b
     * @return the string[]
     */
    public static String[] concat(String[] a, String[] b) {
        String[] c = new String[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    /** The Constant COPDEV. */
    public static final String COPDEV = PropertiesUtils.findPropertiesKey("COPDEV",
            "/resetPwdConfig.properties");

    /** The Constant ALLDEV. */
    public static final String ALLDEV = PropertiesUtils.findPropertiesKey("ALLDEV",
            "/resetPwdConfig.properties");

    /** The Constant COPPORT. */
    public static final String COPPORT = PropertiesUtils.findPropertiesKey("COPPORT",
            "/resetPwdConfig.properties");

    /** The Constant ALLPORT. */
    public static final String ALLPORT = PropertiesUtils.findPropertiesKey("ALLPORT",
            "/resetPwdConfig.properties");

    /**
     * EXL判断集合数据.
     *
     * @param value the value
     * @param type the type
     * @param flag the flag
     * @return true, if successful
     */
    public static boolean judgeExl(String value, String type, String flag) {
        boolean res = false;
        if ("driver".equals(flag)) {
            if ("国际".equals(type)) {
                String[] split = ALLDEV.split("、");
                res = doJudge(value, res, split);
            } else {
                String[] split = COPDEV.split("、");
                res = doJudge(value, res, split);
            }
        } else {
            if ("国际".equals(type)) {
                String[] split = ALLPORT.split("、");
                res = doJudge(value, res, split);
            } else {
                String[] split = COPPORT.split("、");
                res = doJudge(value, res, split);
            }
        }
        return res;

    }

    /**
     * Do judge.
     *
     * @param value the value
     * @param res the res
     * @param split the split
     * @return true, if successful
     */
    private static boolean doJudge(String value, boolean res, String[] split) {
        for (int i = 0; i < split.length; i++) {
            String string = split[i];
            if(string.equals(value)){
                res = true;
            }
        }
        return res;
    }
}

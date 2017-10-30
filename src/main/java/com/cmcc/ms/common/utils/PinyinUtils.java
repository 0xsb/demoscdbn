/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.StringUtils;


/**
 * The Class PinyinUtils.
 */
public class PinyinUtils {

    //private static final Logger logger = Logger.getLogger("devLog");  

    /** The dictionary. */
    public static Map<String, String> dictionary = new HashMap<String, String>();

    //加载多音字词典  
    static {

        BufferedReader br = null;
        try {
            ClassLoader cl = PinyinUtils.class.getClassLoader();
            String path = cl.getResource("duoyinzi_pinyin.txt").toURI().getPath();

            File file = new File(path);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] arr = line.split("#");

                if (StringUtils.isNotEmpty(arr[1])) {
                    String[] sems = arr[1].split(" ");
                    for (String sem : sems) {

                        if (StringUtils.isNotEmpty(sem)) {
                            dictionary.put(sem, arr[0]);
                        }
                    }
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Chinese to pin yin.
     *
     * @param chineseCharacter the chinese character
     * @return the string[]
     * @throws BadHanyuPinyinOutputFormatCombination the bad hanyu pinyin output format combination
     */
    public static String[] chineseToPinYin(char chineseCharacter)
            throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

        if (chineseCharacter >= 32 && chineseCharacter <= 125) { //ASCII >=33 ASCII<=125的直接返回 ,ASCII码表：http://www.asciitable.com/  
            return new String[] { String.valueOf(chineseCharacter) };
        }

        return PinyinHelper.toHanyuPinyinStringArray(chineseCharacter, outputFormat);
    }

    /**
     *  
     * 获取汉字拼音的全拼 .
     *
     * @param chineseCharacter the chinese character
     * @return the string
     * @throws BadHanyuPinyinOutputFormatCombination the bad hanyu pinyin output format combination
     */
    public static String chineseToPinYinF(String chineseCharacter)
            throws BadHanyuPinyinOutputFormatCombination {
        if (StringUtils.isEmpty(chineseCharacter)) {
            return null;
        }

        char[] chs = chineseCharacter.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chs.length; i++) {
            String[] arr = chineseToPinYin(chs[i]);
            if (arr == null) {
                result.append("");
            } else if (arr.length == 1) {
                result.append(arr[0]);
            } else if (arr[0].equals(arr[1])) {
                result.append(arr[0]);
            } else {

                String prim = chineseCharacter.substring(i, i + 1);

                String lst = null;
                String rst = null;

                if (i <= chineseCharacter.length() - 2) {
                    rst = chineseCharacter.substring(i, i + 2);
                }
                if (i >= 1 && i + 1 <= chineseCharacter.length()) {
                    lst = chineseCharacter.substring(i - 1, i + 1);
                }

                String answer = null;
                for (String py : arr) {

                    if (StringUtils.isEmpty(py)) {
                        continue;
                    }

                    if ((lst != null && py.equals(dictionary.get(lst)))
                            || (rst != null && py.equals(dictionary.get(rst)))) {
                        answer = py;
                        break;
                    }

                    if (py.equals(dictionary.get(prim))) {
                        answer = py;
                    }
                }
                if (answer != null) {
                    result.append(answer);
                } else {
                    //logger.warn("no answer ch="+chs[i]);  
                }
            }
        }

        return result.toString().toLowerCase();
    }

    /**
     * Chinese to pin yin S.
     *
     * @param chineseCharacter the chinese character
     * @return the string
     */
    public static String chineseToPinYinS(String chineseCharacter) {
        if (StringUtils.isEmpty(chineseCharacter)) {
            return null;
        }

        char[] chs = chineseCharacter.toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chs.length; i++) {
            try {
                String[] arr = chineseToPinYin(chs[i]);
                if (arr == null) {
                    result.append("");
                } else if (arr.length == 1) {
                    result.append(arr[0].charAt(0));
                } else if (arr[0].equals(arr[1])) {
                    result.append(arr[0].charAt(0));
                } else {

                    String prim = chineseCharacter.substring(i, i + 1);

                    String lst = null;
                    String rst = null;

                    if (i <= chineseCharacter.length() - 2) {
                        rst = chineseCharacter.substring(i, i + 2);
                    }
                    if (i >= 1 && i + 1 <= chineseCharacter.length()) {
                        lst = chineseCharacter.substring(i - 1, i + 1);
                    }

                    String answer = null;
                    for (String py : arr) {

                        if (StringUtils.isEmpty(py)) {
                            continue;
                        }

                        if ((lst != null && py.equals(dictionary.get(lst)))
                                || (rst != null && py.equals(dictionary.get(rst)))) {
                            answer = py;
                            break;
                        }

                        if (py.equals(dictionary.get(prim))) {
                            answer = py;
                        }
                    }
                    if (answer != null) {
                        result.append(answer.charAt(0));
                    } else {
                        //logger.warn("no answer ch="+chs[i]);  
                    }
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        }

        return result.toString().toLowerCase();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        try {

            String str = "小黄rtrtr214";

            System.out.println(str + " pyf=" + PinyinUtils.chineseToPinYinF(str));
            System.out.println(str + " pys=" + PinyinUtils.chineseToPinYinS(str));

        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
    }
}

package com.frank.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: kst
 * @date: 2024/5/10 17:31
 */
public class MTUtils {

    public static void main(String[] args) throws Exception {
//        getCountyInfoEnglish();
//        getProvinceInfoEnglish();
//        getAreaCityInfoEnglish();
        getAreaInfoEnglish();
        System.out.println("成功");
    }

    /**
     * 地区名称(英文)
     *
     * @throws Exception
     */
    private static void getAreaInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        String[] strs = new String[2];
        lineList.forEach(line -> {
            if (line.lastIndexOf("省") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("省"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Province";
            } else if (line.lastIndexOf("市") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("市"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "City";
            } else if ("城区".equals(line)) {
                strs[1] = "District";
            } else if ("矿区".equals(line)) {
                strs[1] = "MiningRegion";
            } else if (line.lastIndexOf("林区") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("林区"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "ForestRegion";
            } else if (line.lastIndexOf("新区") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("新区"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "NewRegion";
            } else if (line.lastIndexOf("矿区") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("矿区"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "MiningRegion";
            } else if (line.lastIndexOf("区") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("区"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Region";
            } else if ("县".equals(line)) {
                strs[1] = "County";
            } else if (line.lastIndexOf("自治县") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("自治县"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousCounty";
            } else if (line.lastIndexOf("县") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("县"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "County";
            } else if (line.lastIndexOf("自治区") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("自治区"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousRegion";
            } else if (line.lastIndexOf("自治旗") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("自治旗"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousBanner";
            } else if (line.lastIndexOf("旗") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("旗"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Banner";
            } else if (line.lastIndexOf("自治州") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("自治州"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousPrefecture";
            } else if ("鹰手营子矿区".equals(line)) {
                strs[1] = "YingShouYingZiMining";
            } else if ("省直辖县级行政区划".equals(line)) {
                strs[1] = "ProvincesDirectlyAdministerTheCountyAdministrativeDivisions";
            } else if ("中沙群岛的岛礁及其海域".equals(line)) {
                strs[1] = "TheIslandsAndReefsOfTheZhongshaIslandsAndTheirWaters";
            } else {
                strs[1] = transforChinseCharacterToPinyin(line);
            }
            if (line.contains("长")) {
                strs[1] = strs[1].replace("Zhang", "Chang");
            }
            list.add(strs[1]);
        });
        StringBuffer sb = new StringBuffer();
        list.forEach(str -> sb.append(str).append("\n"));
        File targetFile = new File("C:/kang/image/test.txt");
        FileUtils.writeStringToFile(targetFile, sb.toString(), "utf-8");
    }

    /**
     * 所在地市
     *
     * @throws Exception
     */
    private static void getAreaCityInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        String[] strs = new String[2];
        lineList.forEach(line -> {
            if (line.lastIndexOf("市") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("市"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "City";
                if ("重庆市".equals(line)) {
                    strs[1] = "ChongQingCity";
                } else if ("长治市".equals(line)) {
                    strs[1] = "ChangZhiCity";
                } else if ("长春市".equals(line)) {
                    strs[1] = "ChangChunCity";
                } else if ("长沙市".equals(line)) {
                    strs[1] = "ChangShaCity";
                } else if ("蚌埠市".equals(line)) {
                    strs[1] = "BengBuCity";
                } else if ("吕梁市".equals(line)) {
                    strs[1] = "LvLiangCity";
                }
            } else if (line.lastIndexOf("地区(地区所在地)") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("地区(地区所在地)"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Region(RegionalLocation)";
            } else if (line.lastIndexOf("地区") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("地区"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Region";
            } else if ("海北藏族自治州".equals(line)) {
                strs[1] = "HaibeiTibetanAutonomousPrefecture";
            } else if ("黄南藏族自治州".equals(line)) {
                strs[1] = "HuangnanTibetanAutonomousPrefecture";
            } else if ("海南藏族自治州".equals(line)) {
                strs[1] = "HainanTibetanAutonomousPrefecture";
            } else if ("果洛藏族自治州".equals(line)) {
                strs[1] = "GologTibetanAutonomousPrefecture";
            } else if ("玉树藏族自治州".equals(line)) {
                strs[1] = "YushuTibetanAutonomousPrefecture";
            } else if ("海西蒙古族藏族自治州".equals(line)) {
                strs[1] = "HaixiMongolAndTibetanAutonomousPrefecture";
            } else if ("昌吉回族自治州".equals(line)) {
                strs[1] = "ChangjiHuiAutonomousPrefecture";
            } else if ("博尔塔拉蒙古自治州".equals(line)) {
                strs[1] = "BortalaMongolAutonomousPrefecture";
            } else if ("巴音郭楞蒙古自治州".equals(line)) {
                strs[1] = "BayingolinMongolAutonomousPrefecture";
            } else if ("克孜勒苏柯尔克孜自治州".equals(line)) {
                strs[1] = "KizilsuKirghizAutonomousPrefecture";
            } else if ("伊犁哈萨克自治州".equals(line)) {
                strs[1] = "YILIKazakAutonomousPrefecture";
            } else if (line.lastIndexOf("州") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("州"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "State";
            } else {
                strs[1] = transforChinseCharacterToPinyin(line);
            }
            list.add(strs[1]);
        });
        StringBuffer sb = new StringBuffer();
        list.forEach(str -> sb.append(str).append("\n"));
        File targetFile = new File("C:/kang/image/test.txt");
        FileUtils.writeStringToFile(targetFile, sb.toString(), "utf-8");
    }

    /**
     * 所在省
     *
     * @throws Exception
     */
    private static void getProvinceInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        String[] strs = new String[2];
        lineList.forEach(line -> {
            if (line.lastIndexOf("省") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("省"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Province";
            } else if (line.lastIndexOf("市") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("市"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "City";
            } else {
                strs[1] = transforChinseCharacterToPinyin(line);
            }
            list.add(strs[1]);
        });
        StringBuffer sb = new StringBuffer();
        list.forEach(str -> sb.append(str).append("\n"));
        File targetFile = new File("C:/kang/image/test.txt");
        FileUtils.writeStringToFile(targetFile, sb.toString(), "utf-8");
    }

    /**
     * 省别处理
     *
     * @throws Exception
     */
    private static void getCountyInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        lineList.forEach(line -> {
            if ("省级".equals(line.trim())) {
                list.add("ProvincialLevel");
            } else if ("市级".equals(line.trim())) {
                list.add("CityLevel");
            } else if ("县级".equals(line.trim())) {
                list.add("CountyLevel");
            } else if ("县级市".equals(line.trim())) {
                list.add("CountyLevel");
            } else if ("地级".equals(line.trim())) {
                list.add("PrefectureLevel");
            } else {
                list.add(line);
            }
        });

        StringBuffer sb = new StringBuffer();
        list.forEach(str -> sb.append(str).append("\n"));
        File targetFile = new File("C:/kang/image/test.txt");
        FileUtils.writeStringToFile(targetFile, sb.toString(), "utf-8");
    }

    /**
     * 汉字转拼音
     *
     * @param str 符串
     * @return 拼音
     * @date kst 20240510
     */
    private static String transforChinseCharacterToPinyin(String str) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        StringBuffer sb = new StringBuffer();
        for (char c : str.toCharArray()) {
            try {
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (pinyinArray != null && pinyinArray.length > 0) {
                    sb.append(StringUtils.capitalize(pinyinArray[0]));
                } else {
                    sb.append(c).append(" ");
                }
            } catch (Exception e) {
                sb.append(c).append(" ");
            }
        }
        return sb.toString().trim();
    }
}

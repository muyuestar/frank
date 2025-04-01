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
        System.out.println("�ɹ�");
    }

    /**
     * ��������(Ӣ��)
     *
     * @throws Exception
     */
    private static void getAreaInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        String[] strs = new String[2];
        lineList.forEach(line -> {
            if (line.lastIndexOf("ʡ") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("ʡ"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Province";
            } else if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "City";
            } else if ("����".equals(line)) {
                strs[1] = "District";
            } else if ("����".equals(line)) {
                strs[1] = "MiningRegion";
            } else if (line.lastIndexOf("����") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("����"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "ForestRegion";
            } else if (line.lastIndexOf("����") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("����"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "NewRegion";
            } else if (line.lastIndexOf("����") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("����"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "MiningRegion";
            } else if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Region";
            } else if ("��".equals(line)) {
                strs[1] = "County";
            } else if (line.lastIndexOf("������") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("������"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousCounty";
            } else if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "County";
            } else if (line.lastIndexOf("������") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("������"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousRegion";
            } else if (line.lastIndexOf("������") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("������"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousBanner";
            } else if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Banner";
            } else if (line.lastIndexOf("������") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("������"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "AutonomousPrefecture";
            } else if ("ӥ��Ӫ�ӿ���".equals(line)) {
                strs[1] = "YingShouYingZiMining";
            } else if ("ʡֱϽ�ؼ���������".equals(line)) {
                strs[1] = "ProvincesDirectlyAdministerTheCountyAdministrativeDivisions";
            } else if ("��ɳȺ���ĵ������亣��".equals(line)) {
                strs[1] = "TheIslandsAndReefsOfTheZhongshaIslandsAndTheirWaters";
            } else {
                strs[1] = transforChinseCharacterToPinyin(line);
            }
            if (line.contains("��")) {
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
     * ���ڵ���
     *
     * @throws Exception
     */
    private static void getAreaCityInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        String[] strs = new String[2];
        lineList.forEach(line -> {
            if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "City";
                if ("������".equals(line)) {
                    strs[1] = "ChongQingCity";
                } else if ("������".equals(line)) {
                    strs[1] = "ChangZhiCity";
                } else if ("������".equals(line)) {
                    strs[1] = "ChangChunCity";
                } else if ("��ɳ��".equals(line)) {
                    strs[1] = "ChangShaCity";
                } else if ("������".equals(line)) {
                    strs[1] = "BengBuCity";
                } else if ("������".equals(line)) {
                    strs[1] = "LvLiangCity";
                }
            } else if (line.lastIndexOf("����(�������ڵ�)") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("����(�������ڵ�)"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Region(RegionalLocation)";
            } else if (line.lastIndexOf("����") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("����"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Region";
            } else if ("��������������".equals(line)) {
                strs[1] = "HaibeiTibetanAutonomousPrefecture";
            } else if ("���ϲ���������".equals(line)) {
                strs[1] = "HuangnanTibetanAutonomousPrefecture";
            } else if ("���ϲ���������".equals(line)) {
                strs[1] = "HainanTibetanAutonomousPrefecture";
            } else if ("�������������".equals(line)) {
                strs[1] = "GologTibetanAutonomousPrefecture";
            } else if ("��������������".equals(line)) {
                strs[1] = "YushuTibetanAutonomousPrefecture";
            } else if ("�����ɹ������������".equals(line)) {
                strs[1] = "HaixiMongolAndTibetanAutonomousPrefecture";
            } else if ("��������������".equals(line)) {
                strs[1] = "ChangjiHuiAutonomousPrefecture";
            } else if ("���������ɹ�������".equals(line)) {
                strs[1] = "BortalaMongolAutonomousPrefecture";
            } else if ("���������ɹ�������".equals(line)) {
                strs[1] = "BayingolinMongolAutonomousPrefecture";
            } else if ("�������տ¶�����������".equals(line)) {
                strs[1] = "KizilsuKirghizAutonomousPrefecture";
            } else if ("���������������".equals(line)) {
                strs[1] = "YILIKazakAutonomousPrefecture";
            } else if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
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
     * ����ʡ
     *
     * @throws Exception
     */
    private static void getProvinceInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        String[] strs = new String[2];
        lineList.forEach(line -> {
            if (line.lastIndexOf("ʡ") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("ʡ"));
                strs[1] = transforChinseCharacterToPinyin(strs[0]) + "Province";
            } else if (line.lastIndexOf("��") > 0) {
                strs[0] = line.substring(0, line.lastIndexOf("��"));
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
     * ʡ����
     *
     * @throws Exception
     */
    private static void getCountyInfoEnglish() throws Exception {
        File file = new File("C:/kang/image/demo.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        List<String> list = new ArrayList<>();
        lineList.forEach(line -> {
            if ("ʡ��".equals(line.trim())) {
                list.add("ProvincialLevel");
            } else if ("�м�".equals(line.trim())) {
                list.add("CityLevel");
            } else if ("�ؼ�".equals(line.trim())) {
                list.add("CountyLevel");
            } else if ("�ؼ���".equals(line.trim())) {
                list.add("CountyLevel");
            } else if ("�ؼ�".equals(line.trim())) {
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
     * ����תƴ��
     *
     * @param str ����
     * @return ƴ��
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

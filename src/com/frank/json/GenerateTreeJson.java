package com.frank.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成树节点JSON数据
 *
 * @author: kst
 * @date: 2023/12/8 10:40
 */
public class GenerateTreeJson {

    private static Map<String, Object> oneMap = new LinkedHashMap<>();
    private static Map<String, Object> twoMap = new LinkedHashMap<>();

    private static List<Map<String, Object>> oneList = new ArrayList<>();
    private static List<Map<String, Object>> twoList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        List<String> list = FileUtils.readLines(new File("C:/kang/demo/occupation.js"), "UTF-8");

        String occcupationCode = "";
        String occcupationValue = "";

        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("export") || list.get(i).contains("};")) {
                continue;
            }
            occcupationCode = list.get(i).split(":")[0].replace("\"", "").trim();
            occcupationValue = list.get(i).split(":")[1].replace("\"", "").replace(",", "").trim();

            // 1级
            if ("0000".equals(occcupationCode.substring(1))) {
                oneMap = new LinkedHashMap<>();
                oneMap.put("id", occcupationCode);
                oneMap.put("label", occcupationValue);
                if (i < list.size() && list.get(i + 1).contains(occcupationCode.substring(0, 1))) {
                    oneMap.put("children", oneList = new ArrayList<>());
                }
                dataList.add(oneMap);
                continue;
            }

            // 2级
            if (!"0000".equals(occcupationCode.substring(1)) && "00".equals(occcupationCode.substring(3))) {
                twoMap = new LinkedHashMap<>();
                twoMap.put("id", occcupationCode);
                twoMap.put("label", occcupationValue);
                if (i < list.size() && list.get(i + 1).contains(occcupationCode.substring(0, 3))) {
                    twoMap.put("children", twoList = new ArrayList<>());
                }
                oneList.add(twoMap);
                continue;
            }

            // 3级
            if (!"0000".equals(occcupationCode.substring(1)) && !"00".equals(occcupationCode.substring(3))) {
                Map<String, Object> threeMap = new LinkedHashMap<>();
                threeMap.put("id", occcupationCode);
                threeMap.put("label", occcupationValue);
                twoList.add(threeMap);
            }
        }
        String str = JSON.toJSONString(dataList, SerializerFeature.PrettyFormat);
        System.out.println(str);
    }

}


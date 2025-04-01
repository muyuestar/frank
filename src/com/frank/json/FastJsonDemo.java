package com.frank.json;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json��� https://blog.csdn.net/qq_29072049/article/details/89514268
 * https://www.cnblogs.com/kaixinyufeng/p/8323803.html
 *
 * @author kst 20210902
 */
public class FastJsonDemo {

    private static void parseJsonData(Map<String, Object> allmap, String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        jsonObject.entrySet().stream().forEach(item -> {
            if (item.getValue() instanceof JSONObject) {
                parseJsonData(allmap, ((JSONObject) item.getValue()).toJSONString());
            } else {
                allmap.put(item.getKey(), item.getValue());
            }
        });
    }

    public static void main(String[] args) {
        // 1.json�����ַ�������>����
//        String str = "[{'page':'0','imgInfo':'/home/afa/seal.png','coordX':'0','coordY':'200','coordType':'1','scaleVal':'0.5'},{'page':'1','imgInfo':'/home/afa/seal1.png','coordX':'10','coordY':'300','coordType':'2','scaleVal':'0.8'}]";
//        JSONArray array = JSON.parseArray(str);


//        System.out.println(array.get(0));
//        System.out.println(array.toJSONString());
//        System.out.println(array);


        // 2.map����>json
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("page", "0");
//        map.put("coordX", "10");
//        map.put("coordY", "20");
//        String json = JSON.toJSONString(map, SerializerFeature.PrettyFormat);
//        System.out.println(json);


//        Map<String, String> map = Maps.newHashMap();
//        map.put("apple", "aaa");
//        map.put("banana", "��������\�ֵ���ɽ·1000��");
//        String json = JSON.toJSONString(map);
//        System.out.println(json);
        String json = "{\"apple\":\"aaa\",\"banana\":\"��������\\�ֵ���ɽ·1000��\"}";
        Map<String, String> jsonMap = JSON.parseObject(json, new TypeReference<Map>() {
        });
        System.out.println(jsonMap);


        // 3.json����>map
        // 3.1
//		String jsonStr = "{\"coordX\":\"10\",\"coordY\":\"20\",\"page\":\"0\"}";
//		Map<String, String> map = (Map<String, String>) JSON.parse(jsonStr);
//		System.out.println(map);
//		System.out.println(map.get("coordX"));

        // 3.2
//		String jsonStr = "{\"coordX\":\"10\",\"coordY\":\"20\",\"page\":\"0\"}";
//		Map<String, Object> map = JSON.parseObject(jsonStr);
//		System.out.println(map);

        // 3.3
//		String jsonStr = "{\"coordX\":\"10\",\"coordY\":\"������		�渶����\",\"fy\":\"������\t\t�渶����\"}";
//		Map<String, String> map = JSON.parseObject(jsonStr, Map.class);
//		System.out.println(map);

        // 3.4
//		String jsonStr = "{\"coordX\":\"10\",\"coordY\":\"20\",\"page\":\"0\"}";
//		Map<String, String> map = (Map<String, String>) JSONObject.parse(jsonStr);
//		System.out.println(map);


        // 4.list����>JSONArray
//        List<User> list = Lists.newArrayList();
//        User user = new User();
//        user.setAge("10");
//        user.setName("����");
//        user.setAddress("�㽭����");
//        list.add(user);
//
//        User user1 = new User();
//        user1.setAge("12");
//        user1.setName("����");
//        user1.setAddress("�㽭����");
//        list.add(user1);
//
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
//        System.out.println(jsonArray);


        // 5.JSONArray����>list
//        List<User> userList = JSONObject.parseArray(jsonArray.toJSONString(), User.class);
//        System.out.println(userList.isEmpty());


        // 6.JSONArray����>map
//        List<Map> listMap = JSONObject.parseArray(jsonArray.toJSONString(), Map.class);
//        listMap.forEach(map -> System.out.println(map));


        // 7.���ɶ�ڵ㸴�ӵ�jsonDemo1
//		JSONObject rootObject = new JSONObject();
//		Bupps bupps = new Bupps();
//		Req req = new Req();
//		Head head = new Head();
//		head.setTeller("C02021");
//		head.setBranch("0202");
//		Body body = new Body();
//		body.setAddWord("���÷�");
//		body.setAppointFlag("1");
//		req.setHead(head);
//		req.setBody(body);
//		bupps.setReq(req);
//		rootObject.put("bupps", bupps);
//		String json = rootObject.toJSONString();
//		System.out.println(json);


        // 8.���ɶ�ڵ㸴�ӵ�jsonDemo2
//		Root root = new Root();
//		Bupps bupps = new Bupps();
//		Req req = new Req();
//		Head head = new Head();
//		head.setTeller("C02021");
//		head.setBranch("0202");
//		Body body = new Body();
//		body.setAddWord("���÷�");
//		body.setAppointFlag("1");
//		req.setHead(head);
//		req.setBody(body);
//		bupps.setReq(req);
//		root.setBupps(bupps);
//		String json = JSON.toJSONString(root,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue);
//		String json = JSON.toJSONString(root, SerializerFeature.PrettyFormat);
//		System.out.println(json);


        // 9.���ɶ�ڵ㸴�ӵ�jsonDemo3
//		Root root = new Root();
//		Bupps bupps = new Bupps();
//		Req req = new Req();
//		Head head = new Head();
//		head.setTeller("C02021");
//		head.setBranch("0202");
//		Body body = new Body();
//		body.setAddWord("���÷�");
//		body.setAppointFlag("1");
//		req.setHead(head);
//		req.setBody(body);
//		bupps.setReq(req);
//		root.setBupps(bupps);
////		String json = JSON.toJSONString(root,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue);
//		String json = JSON.toJSONString(root, SerializerFeature.PrettyFormat);
//		System.out.println(json);


        // 10.���ɶ�ڵ㸴�ӵ�jsonDemo4
//		JSONObject jsonObject = new JSONObject();
//		JSONObject reqObject = new JSONObject();
//		
//		// head
//		JSONObject headObject = new JSONObject();
//		headObject.put("branch", "0101");
//		headObject.put("channel", "202");
//		
//		// body
//		JSONObject bodyObject = new JSONObject();
//		bodyObject.put("addWord", "���÷�");
//		bodyObject.put("appointFlag", "1");
//		
//		Request request = new Request();
//		request.setHead(headObject);
//		request.setBody(bodyObject);
//		reqObject.put("req", request);
//		
//		jsonObject.put("bupps", reqObject);
//		String json = JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat);
//		System.out.println(json);


        // 11.���ɶ�ڵ㸴�ӵ�jsonDemo5
//		JSONObject jsonObject = new JSONObject();
//		JSONObject reqObject = new JSONObject();
//
//		// head
//		Map<String, String> headMap = new HashMap<>();
//		headMap.put("branch", "0101");
//		headMap.put("channel", "202");
//
//		// body
//		Map<String, String> bodyMap = new HashMap<>();
//		bodyMap.put("addWord", "���÷�");
//		bodyMap.put("appointFlag", "1");
//
//		Requ requ = new Requ();
//		requ.setHead(headMap);
//		requ.setBody(bodyMap);
//		reqObject.put("req", requ);
//
//		jsonObject.put("bupps", reqObject);
//		String json = JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat);
//		System.out.println(json);


        // 12.������ڵ㸴��json
//		Map<String, String> responseMap = new LinkedHashMap<>();
//		String[] headArray = new String[] { "channel", "branch", "teller" };
//		String[] bodyArray = new String[] { "addWord", "appointFlag" };
//		String jsonStr = "{\"bupps\":{\"req\":{\"head\":{\"channel\":\"202\",\"branch\":\"0101\"},\"body\":{\"addWord\":\"���÷�\",\"appointFlag\":\"1\"}}}}";
//		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
//		JSONObject reqObject = jsonObject.getJSONObject("bupps").getJSONObject("req");
//
//		// head
//		JSONObject headObject = reqObject.getJSONObject("head");
//		for (String headStr : headArray) {
//			responseMap.put(headStr,
//					StringUtils.isEmpty(headObject.getString(headStr)) ? "" : headObject.getString(headStr));
//		}
//
//		// body
//		JSONObject bodyObject = reqObject.getJSONObject("body");
//		for (String bodyStr : bodyArray) {
//			responseMap.put(bodyStr,
//					StringUtils.isEmpty(bodyObject.getString(bodyStr)) ? "" : bodyObject.getString(bodyStr));
//		}
//		System.out.println(responseMap);


        // 13.������װmap����>json
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("bankFlag", "1");

//		List<Map<String,String>> listMap = new ArrayList<>();
//		Map<String,String> resultMap = new HashMap<>();
//		resultMap.put("busiMode", "100");
//		resultMap.put("payChannel", "CBPS");
//		resultMap.put("payChannelName", "��������֧��ϵͳ");
//		listMap.add(resultMap);
//		jsonObject.put("resultList", listMap);

//		String json = JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat);
//		String json = JSON.toJSONString(jsonObject);
//		System.out.println(json);


        // 14.����json����>map
//		String jsonStr = "{\"bankFlag\":\"1\",\"resultList\":[{\"payChannelName\":\"��������֧��ϵͳ\",\"busiMode\":\"100\",\"payChannel\":\"CBPS\"}]}";
//		Map<String, String> map = new HashMap<>();
//		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
//		map.put("bankFlag", jsonObject.getString("bankFlag"));
//		String reusltListStr = JSON.parseArray(jsonObject.getString("resultList")).getString(0);
//		Map<String, String> resultMap = JSON.parseObject(reusltListStr, Map.class);
//		map.putAll(resultMap);
//		System.out.println(resultMap);

//		String payChannel = JSON.parseObject(JSON.parseArray(jsonObject.getString("resultList")).getString(0))
//				.getString("payChannel");
//		System.out.println(payChannel);


        // 15.����JsonArray�г�ȡ��ͬkey��valueֵ���map(string,array)
//        Map<String, List<Map<String, String>>> resultMap = new HashMap<>();
//        List<Map<String, String>> resultList = new ArrayList<>();
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("coordX", "10");
//        map.put("coordY", "20");
//        map.put("coordZ", "30");
//        map.put("fruit", "apple");
//        resultList.add(map);
//
//        Map<String, String> map1 = new HashMap<String, String>();
//        map1.put("coordX", "40");
//        map1.put("coordY", "50");
//        map1.put("coordZ", "60");
//        map1.put("fruit", "banana");
//        resultList.add(map1);
//
//        Map<String, String> map2 = new HashMap<String, String>();
//        map2.put("coordX", "70");
//        map2.put("coordY", "80");
//        map2.put("coordZ", "90");
//        map2.put("fruit", "orange");
//        resultList.add(map2);
//
//        resultMap.put("resultList", resultList);
//        String json = JSON.toJSONString(resultMap);
//        System.out.println(json);
//
//        JSONArray jsonArray = JSON.parseArray(JSONObject.parseObject(json).getString("resultList"));
//        Map<String, JSONArray> arrayMap = new HashMap<>();
//        Set<String> set = jsonArray.getJSONObject(0).keySet();
//        String[] keys = new String[set.size()];
//        set.toArray(keys);
//
//        List<List<String>> lists = new ArrayList<>();
//        Stream.of(keys).forEach(key -> lists.add(new ArrayList<>()));
//
//        for (int i = 0; i < jsonArray.size(); i++) {
//            for (int j = 0; j < keys.length; j++) {
//                lists.get(j).add(jsonArray.getJSONObject(i).getString(keys[j]));
//            }
//        }
//
//        for (int i = 0; i < keys.length; i++) {
//            arrayMap.put(keys[i], JSONArray.parseArray(JSON.toJSONString(lists.get(i))));
//        }
//
//        System.out.println(arrayMap);


        // 16.json�����ַ�������>����key��װ������
        // [0, 1]|[/home/afa/seal.png, /home/afa/seal1.png]|[0, 10]|[200, 300]|[1,2]|[0.5, 0.8]
//		String str = "[{'page':'0','imgInfo':'/home/afa/seal.png','coordX':'0','coordY':'200','coordType':'1','scaleVal':'0.5'},{'page':'1','imgInfo':'/home/afa/seal1.png','coordX':'10','coordY':'300','coordType':'2','scaleVal':'0.8'}]";
//		JSONArray array = JSON.parseArray(str);
//
//		int length = array.size();
//		String[] fields = new String[] { "page", "imgInfo", "coordX", "coordY", "coordType", "scaleVal" };
//		List<Object[]> list = new ArrayList<>();
//		for (int i = 0; i < fields.length; i++) {
//			list.add(new Object[length]);
//		}
//
//		for (int i = 0; i < length; i++) {
//			for (int j = 0; j < fields.length; j++) {
//				list.get(j)[i] = ((JSONObject) array.get(i)).get(fields[j]);
//			}
//		}
//
//		StringBuffer sb = new StringBuffer();
//		for (Object[] objArray : list) {
//			sb.append(Arrays.toString(objArray)).append("|");
//		}
//		System.out.println(sb);


        // 17.�ϲ�����JSONArray
//        Map<String, Object> map = new HashMap<>();
//        map.put("a", JSON.parseArray("['1','2','3']"));
//        map.put("b", JSON.parseArray("['4','5','6']"));
//        JSONArray aArr = (JSONArray) map.get("a");
//        JSONArray bArr = (JSONArray) map.get("b");
//        aArr.addAll(bArr);

//        map.put("c",((JSONArray) map.get("a")).addAll((JSONArray) map.get("b")));
//        System.out.println(map.get("c"));


        // 18.���սڵ���˳�����
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("id", "10");
//        map.put("label", "ˮ��");
//        map.put("children", "�㽶");
//        String str = JSON.toJSONString(map, SerializerFeature.PrettyFormat);
//        System.out.println(str);


        // 19.��ʽ���������
//        User user = new User();
//        user.setAge("28");
//        user.setName("���");
//        user.setAddress("�峣");
//        String str = JSON.toJSONString(user, SerializerFeature.PrettyFormat);
//        System.out.println(str);


        // 20.��json����ת����map
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> headmap = new HashMap<>();
//        headmap.put("haa", "111");
//        headmap.put("hbb", null);
//
//        Map<String, Object> bodymap = new HashMap<>();
//        bodymap.put("bcc", "333");
//        bodymap.put("bdd", "444");
//
//        Map<String, Object> datamap = new HashMap<>();
//        datamap.put("dee", "555");
//        datamap.put("dff", "666");
//        bodymap.put("data", datamap);
//
//        map.put("head", headmap);
//        map.put("body", bodymap);
//
//        // 21.nullֵת����""
//        Map<String, Object> allmap = new LinkedHashMap<>();
//        ValueFilter valueFilter = new ValueFilter() {
//            @Override
//            public Object process(Object o, String s, Object o1) {
//                return o1 == null ? "" : o1;
//            }
//        };
//        String json = JSON.toJSONString(map, valueFilter, SerializerFeature.PrettyFormat);
//        parseJsonData(allmap, json);
//        System.out.println(allmap);


        // 22.���˿�{}
//        JSONObject jsonObject = new JSONObject();
//        List<Map<String, String>> listMap = new ArrayList<>();
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("apple", "11");
//        map.put("banana", "22");
//        listMap.add(map);
//        listMap.add(new HashMap<>());
//        jsonObject.put("records", listMap);
//        String json = JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat);
//        JSONArray records = JSON.parseObject(json).getJSONArray("records");
//        records.forEach(item -> {
//            if ((((JSONObject) item).isEmpty())) {
//                System.out.println("��json");
//                return;
//            }
//            System.out.println(item);
//        });


        // 23.��json��ͬ�ֶ�ֵ���
//        List<List<String>> allList1 = new ArrayList<>();
//        List<List<String>> allList2 = new ArrayList<>();
//        List<String> list1 = Arrays.asList("0202", "MT02021", "C3004", "2", "2.0");
//        List<String> list2 = Arrays.asList("0202", "MT02021", "C3005", "3", "3.0");
//        List<String> list3 = Arrays.asList("0202", "MT02021", "C3006", "5", "4.0");
//
//        List<String> list4 = Arrays.asList("0202", "MT02021", "C3004", "6", "10.0");
//        List<String> list5 = Arrays.asList("0202", "MT02021", "C3005", "4", "13.0");
//        List<String> list6 = Arrays.asList("0202", "MT02021", "C3007", "9", "130.0");
//        List<String> list7 = Arrays.asList("0202", "MT02021", "C3008", "15", "100.0");
//
//        allList1.add(list1);
//        allList1.add(list2);
//        allList1.add(list3);
//
//        allList2.add(list4);
//        allList2.add(list5);
//        allList2.add(list6);
//        allList2.add(list7);
//
//        JSONArray jsonArray1 = JSONArray.parseArray(JSON.toJSONString(allList1));
//        System.out.println(jsonArray1);
//
//        JSONArray jsonArray2 = JSONArray.parseArray(JSON.toJSONString(allList2));
//        System.out.println(jsonArray2);
//
//        List<List> lists1 = JSONObject.parseArray(jsonArray1.toJSONString(), List.class);
//        List<List> lists2 = JSONObject.parseArray(jsonArray2.toJSONString(), List.class);
//
//        Map<String, String> trancountMap = Maps.newHashMap();
//        Map<String, String> sumamountMap = Maps.newHashMap();
//        String[] arr = new String[2];
//        lists2.stream().forEach(item -> {
//            arr[0] = item.get(0).toString() + item.get(1).toString() + item.get(2).toString() + "trancount";
//            arr[1] = item.get(0).toString() + item.get(1).toString() + item.get(2).toString() + "sumamount";
//            trancountMap.put(arr[0], item.get(3).toString());
//            sumamountMap.put(arr[1], item.get(4).toString());
//        });
//        lists1.stream().forEach(item -> {
//            arr[0] = item.get(0).toString() + item.get(1).toString() + item.get(2).toString() + "trancount";
//            arr[1] = item.get(0).toString() + item.get(1).toString() + item.get(2).toString() + "sumamount";
//            item.set(3, new BigDecimal("0").add(new BigDecimal(item.get(3).toString())).add(new BigDecimal(trancountMap.containsKey(arr[0]) ? trancountMap.get(arr[0]).toString() : "0")));
//            item.set(4, new BigDecimal("0.0").add(new BigDecimal(item.get(4).toString())).add(new BigDecimal(sumamountMap.containsKey(arr[1]) ? sumamountMap.get(arr[1]).toString() : "0.0")));
//            trancountMap.remove(arr[0]);
//            sumamountMap.remove(arr[1]);
//        });
//        lists2.stream().forEach(item -> {
//            arr[0] = item.get(0).toString() + item.get(1).toString() + item.get(2).toString() + "trancount";
//            if (trancountMap.containsKey(arr[0])) {
//                lists1.add(item);
//            }
//        });
//
//        lists1.stream().forEach(item -> System.out.println(item));


    }
}

package com.frank.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.springframework.beans.BeanUtils;

import com.google.common.collect.ImmutableMap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * ���������÷�
 * 
 * @author kst
 * @date 2021-07-19 17:13:13
 */
public class BaseUtils {

	/**
	 * ����ʱ��һ��
	 */
	private static final int EXPIRE_SECONDS = 1 * 24 * 3600;

	/**
	 * jwt�����ֶ�
	 */
	private static final String CLAIM_ID_KEY = "id";

	private static String jwtKey = "7890";

	/**
	 * ����JWT TOKEN
	 * 
	 * @return JWTTOKEN
	 */
	public static String generateToken() {
		String baseToken = UUID.randomUUID().toString();
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		LocalDateTime localDateTimeExpire = localDateTimeNow.plusSeconds(EXPIRE_SECONDS);
		Date from = Date.from(localDateTimeNow.atZone(ZoneId.systemDefault()).toInstant());
		Date expire = Date.from(localDateTimeExpire.atZone(ZoneId.systemDefault()).toInstant());

		Claims jwtClaims = Jwts.claims().setSubject(baseToken);
		jwtClaims.put(CLAIM_ID_KEY, 1);
		String compactJws = Jwts.builder().setClaims(jwtClaims).setNotBefore(from).setExpiration(expire)
				.signWith(SignatureAlgorithm.HS512, jwtKey).compact();
		return compactJws;
	}

	/**
	 * ���ƶ���
	 *
	 * @param source Դ Ҫ���ƵĶ���
	 * @param target Ŀ�� ���Ƶ��˶���
	 * @param <T>
	 * @return T
	 */
	public static <T> T copy(Object source, Class<T> target) {
		if (source == null || target == null) {
			return null;
		}
		try {
			T newInstance = target.newInstance();
			BeanUtils.copyProperties(source, newInstance);
			return newInstance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ����List����ȡ����
	 * 
	 * @param listA A����
	 * @param listB B����
	 * @author kst,20210808
	 */
	public static void retainList(List<String> listA, List<String> listB) {
		listA.retainAll(listB);
	}

	/**
	 * ��װ��ʱ���� ��һ��������Ҫ���������������ֶ�ʱ������һ����װ��һ����ʱ���󷵻أ���������Pair��Triple�Ͳ���Ҫ��
	 * 
	 * @return 2���ֶε���ʱ����pair
	 * @author kst 20210815
	 */
	public static ImmutablePair<Integer, String> getPair() {
		return ImmutablePair.of(1, "demo");
	}

	/**
	 * ����3���ֶε���ʱ����triple
	 * 
	 * @return 3���ֶε���ʱ����triple
	 * @author kst 20210815
	 */
	public static ImmutableTriple<Integer, String, Date> getTriple() {
		return ImmutableTriple.of(1, "demo", new Date());
	}

	/**
	 * ����keyֵ����map
	 * 
	 * @param map map
	 * @return �����map
	 * @author kst 20210818
	 */
	public static Map<String, String> sortMapByKeyAsc(Map<String, String> map) {
		Map<String, String> resultMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEachOrdered(e -> resultMap.put(e.getKey(), e.getValue()));
		return resultMap;
	}

	/**
	 * ����keyֵ����map
	 * 
	 * @param <K>  K
	 * @param <V>  V
	 * @param map
	 * @param flag true-����false-����
	 * @return �����map
	 * @author kst 20210818
	 */
	public static <K extends Comparable<? super K>, V> Map<K, V> sortMapByKeyWithFlag(Map<K, V> map, Boolean flag) {
		Map<K, V> resultMap = new LinkedHashMap<>();
		// google��д��
		// Map<K, V> resultMap = Maps.newLinkedHashMap();
		// ����
		if (flag) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
					.forEachOrdered(e -> resultMap.put(e.getKey(), e.getValue()));
		} else {
			// ����
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
					.forEachOrdered(e -> resultMap.put(e.getKey(), e.getValue()));
		}
		return resultMap;
	}

	/**
	 * ����valueֵ����map
	 * 
	 * @param map
	 * @return �����map
	 * @author kst 20210818
	 */
	public static Map<String, String> sortMapByValue(Map<String, String> map) {
		Map<String, String> resultMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> resultMap.put(x.getKey(), x.getValue()));
		return resultMap;
	}

	/**
	 * ����valueֵ����map
	 * 
	 * @param <K>  K
	 * @param <V>  V
	 * @param map  map
	 * @param flag true-����false-����
	 * @return �����map
	 * @author kst 20210818
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValueWithFlag(Map<K, V> map, Boolean flag) {
		Map<K, V> resultMap = new LinkedHashMap<>();
		// google��д��
		// Map<K, V> resultMap = Maps.newLinkedHashMap();

		// ����
		if (flag) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed())
					.forEachOrdered(e -> resultMap.put(e.getKey(), e.getValue()));
		} else {
			// ����
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue())
					.forEachOrdered(e -> resultMap.put(e.getKey(), e.getValue()));
		}
		return resultMap;
	}

	/**
	 * ����mapĳ��key����װ��map��list����
	 * 
	 * @param list    ����map�ļ���
	 * @param sortStr �����ֶ�
	 * @param flag    true-����false-����
	 * @author kst 20210820
	 */
	public static void sortListMapWithFlag(List<Map<String, String>> list, String sortStr, boolean flag) {
		Collections.sort(list, new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> map0, Map<String, String> map1) {
				// ����
				if (flag) {
					return map1.get(sortStr).compareTo(map0.get(sortStr));
				}
				// ����
				return map0.get(sortStr).compareTo(map1.get(sortStr));
			}

		});
	}

	public static void main(String[] args) {
		// ���ƶ���
//		EmployeeDTO employeeDTO = new EmployeeDTO();
//		employeeDTO.setLoginName("admin");
//		employeeDTO.setActualName("ľ��");
//		employeeDTO.setPhone("18788895678");
//		String str = employeeDTO.getLoginName() + "|" + employeeDTO.getActualName() + "|" + employeeDTO.getPhone();
//		System.out.println(str);
//
//		LoginDetailVO loginDetailVO = copy(employeeDTO, LoginDetailVO.class);
//		String detailStr = loginDetailVO.getLoginName() + "|" + loginDetailVO.getActualName() + "|"
//				+ loginDetailVO.getPhone();
//		System.out.println(detailStr);

//		List<String> listA = new ArrayList<>();
//		listA.add("a");
//		listA.add("b");
//		listA.add("c");
//		List<String> listB = new ArrayList<>();
//		listB.add("a");
//		listB.add("b");
//		listB.add("d");
//		retainList(listA, listB);
//		System.out.println(listA);
//		System.out.println(listB);

		// ��װ��ʱ����
		// ��һ��������Ҫ���������������ֶ�ʱ������һ����װ��һ����ʱ���󷵻أ���������Pair��Triple�Ͳ���Ҫ��
//		ImmutablePair<Integer, String> pair = getPair();
//		System.out.println(pair.getLeft() + "|" + pair.getRight());
		// ����3���ֶ�
//		ImmutableTriple<Integer, String, Date> triple = getTriple();
//		System.out.println(
//				triple.getLeft() + "|" + triple.getMiddle() + "|" + DateUtil.dateConvertString(triple.getRight()));

		// ����map
//		Map<String, String> map = new HashMap<>();
//		map.put("5", "e");
//		map.put("4", "d");
//		map.put("2", "b");
//		map.put("1", "a");
//		map.put("3", "d");
		// google��
//		Map<String, String> map = ImmutableMap.of("5", "e", "4", "d", "2", "b", "1", "a", "3", "c");
		// ԭʼ����
//		System.out.println(map.toString());
		// ����keyֵ����map
//		System.out.println(sortMapByKeyAsc(map));
//		System.out.println(sortMapByKeyWithFlag(map, false));
		// ����keyֵ����map
//		System.out.println(sortMapByKeyWithFlag(map, true));
		// ����valueֵ����map
//		System.out.println(sortMapByValue(map));
//		System.out.println(sortMapByValueWithFlag(map, false));
		// ����valueֵ����map
//		System.out.println(sortMapByValueWithFlag(map, true));

		// ����mapĳ��key����װ��map��list����
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map0 = ImmutableMap.of("jyrq", "20210820 11:20:15", "accName", "����", "je", "1000");
		Map<String, String> map1 = ImmutableMap.of("jyrq", "20210820 13:20:15", "accName", "����", "je", "2000");
		Map<String, String> map2 = ImmutableMap.of("jyrq", "20210820 09:20:15", "accName", "����", "je", "3000");
		Map<String, String> map3 = ImmutableMap.of("jyrq", "20210820 07:20:15", "accName", "����", "je", "4000");
		Map<String, String> map4 = ImmutableMap.of("jyrq", "20210820 20:20:15", "accName", "�´�", "je", "5000");
		Map<String, String> map5 = ImmutableMap.of("jyrq", "20210820 20:20:15", "accName", "����", "je", "7000");
		list.add(map0);
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		System.out.println(list.toString());
		
		// ����
		sortListMapWithFlag(list, "jyrq", false);
		System.out.println(list.toString());
		// ����
//		sortListMapWithFlag(list, "jyrq", true);
//		System.out.println(list.toString());
	}

}

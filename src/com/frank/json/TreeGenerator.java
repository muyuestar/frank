package com.frank.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: kst
 * @date: 2023/12/10 21:49
 */
public class TreeGenerator {

    public static void main(String[] args) throws Exception {
//        List<TreeNode> list = Lists.newArrayList();
//
//        // �������ڵ�
//        TreeNode root = new TreeNode("root");
//
//        // �����ӽڵ�
//        TreeNode node1 = new TreeNode("node1");
//        TreeNode node2 = new TreeNode("node2");
//        TreeNode node3 = new TreeNode("node3");
//
//        // ���ӽڵ���ӵ����ڵ�� children ��
//        root.addChild(node1);
//        root.addChild(node2);
//        root.addChild(node3);
//
//        list.add(node1);
//        list.add(node2);
//        list.add(node3);
//
//        // �������ӽڵ�
//        TreeNode node4 = new TreeNode("node4");
//        TreeNode node5 = new TreeNode("node5");
//        TreeNode node6 = new TreeNode("node6");
//
//        // �����ӽڵ���ӵ���һ���ӽڵ�� children ��
//        node1.addChild(node4);
//        node1.addChild(node5);
//        node1.addChild(node6);
//
//        // ʹ�� Jackson �⽫���νṹת��Ϊ JSON �ַ���
////        ObjectMapper mapper = new ObjectMapper();
////        String json = mapper.writeValueAsString(root);
////        System.out.println(json);
//
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
//        System.out.println(jsonArray);


        List<TreeNode> list = new LinkedList<>();
//        TreeNode treeNode1 = new TreeNode();
//        treeNode1.setId("10000");
//        treeNode1.setLabel("���Ļ��ء����һ��ء�Ⱥ������������֯������ҵ��λ������");

        TreeNode node1 = new TreeNode("10000", "���Ļ��ء����һ��ء�Ⱥ������������֯������ҵ��λ������");
        TreeNode node2 = new TreeNode("10100", "�й����������ظ�����");
        TreeNode node3 = new TreeNode("10200", "���һ��ظ�����");
        node1.setChildren(node2);
        node1.setChildren(node3);
        list.add(node1);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        System.out.println(jsonArray);
    }
}


package com.frank.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kst
 * @date: 2023/12/10 22:09
 */
public class TreeNode {
    private String id;
    private String label;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(String id, String label) {
        this.id = id;
        this.label = label;
        this.children = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(TreeNode treeNode) {
        this.children.add(treeNode);
    }

//    public void addChild(TreeNode treeNode) {
//        this.children.add(treeNode);
//    }

}

package com.neusoft.ui.tree.bean;

import java.util.List;

import com.neusoft.hibernate.conf.dao.Menu;

public class TreeUtil {
	private static TreeUtil treeUtil = null;
	private TreeUtil(){
		
	}
	public static TreeUtil getInstance(){
		if(treeUtil == null){
			treeUtil = new TreeUtil();
		}
		return treeUtil;
	}
	
	public TreeNode transformMenuToTreeNode(Menu menu){
		TreeNode treeNode = new TreeNode();
		treeNode.setId(String.valueOf(menu.getId()));
		treeNode.setText(menu.getName());
		treeNode.setQtip(menu.getDes());
		String loc = menu.getLocation();
		if (menu.getLeaf().equals("0")) {
			treeNode.setLeaf(false);
		}else{
			treeNode.setLeaf(true);
		}
		return treeNode;
	}
	
	public  TreeNode generateTree(List list){ 
		TreeNode root = new TreeNode();
		root.setId("0");
		root.setText("学校管理系统");
		List<TreeNode> tree = root.getChildren();
		
		TreeNode tempParent = root;
		TreeNode tempNode = null;
		String temp = "";
		int depth = 1;
		int segLength = 1;
	
		for (Object o:list){
			temp = ((Menu)o).getLocation();
			segLength = temp.split(",").length;
			if(segLength==depth){
				tempNode = this.transformMenuToTreeNode((Menu)o);
				tempNode.setParent(tempParent);
				tree.add(tempNode);
			}else if (segLength>depth){
				tempParent =  tree.get(tree.size()-1);
				tree =tempParent.getChildren();
				tempNode = this.transformMenuToTreeNode((Menu)o);
				tempNode.setParent(tempParent);
				tree.add(tempNode);
				depth++;
			}else{
				tempNode = tempNode.getParent().getParent();
				tree = tempNode.getChildren();
				tempNode = this.transformMenuToTreeNode((Menu)o);
				tempNode.setParent(tempParent);
				tree.add(tempNode);
				depth--;
			}
		}
		return root;
		
	}
}

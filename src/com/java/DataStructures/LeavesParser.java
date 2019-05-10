package com.java.DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "" + val;
	}
}

public class LeavesParser {

	LinkedList<TreeNode> list = new LinkedList<>();
	ArrayList<TreeNode> isVisited = new ArrayList<>();
	List<String> resultList = new ArrayList<>();
	StringBuilder sum = new StringBuilder();

	public void trace(TreeNode root) {

		if (root.left == null & root.right == null) {
			isVisited.add(root);
			list.add(root);
			sum.append(root);
			resultList.add(sum.toString());
			sum.setLength(0);
			System.out.println(list);
			System.out.println(resultList);
			root = list.getFirst();
			list.clear();
			trace(root);
		}

		if ((root.left != null) && !isVisited.contains(root.left)) {
			list.add(root);
			sum.append(root).append("->");
			root = root.left;
			trace(root);
		} else if (root.right != null && !isVisited.contains(root.right)) {
			list.add(root);
			sum.append(root).append("->");
			root = root.right;
			trace(root);
		} else {
			isVisited.add(root);
			list.add(root);
			sum.setLength(0);
			if (!root.equals(list.getFirst())) {
				root = list.getFirst();
				list.clear();
				trace(root);
			}
		}

	}

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.right = t5;

		new LeavesParser().trace(t1);

	}

}

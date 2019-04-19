package com.java.DataStructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Node {

	int id;
	boolean isVisited;
	List<Node> adjacents;

	public Node(int id) {
		this.id = id;
		this.isVisited = false;
		adjacents = new ArrayList();

	}

	void addadjacents(Node n) {
		this.adjacents.add(n);
	}
}

public class BFS {

	public static void bfs(Node source) {

		LinkedList<Node> nodeQ = new LinkedList<>();
		HashSet<Integer> isVisited = new HashSet<>();

		nodeQ.add(source);

		while (!nodeQ.isEmpty()) {

			Node traced = nodeQ.pop();
			System.out.println(traced.id);
			isVisited.add(traced.id);

			if (!traced.adjacents.isEmpty()) {
				nodeQ.addAll(traced.adjacents);

			}

		}

	}

	public static void main(String[] args) {
		// Creating nodes
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		// Adding adjacents to nodes
		n1.addadjacents(n2);
		n1.addadjacents(n3);
		n1.addadjacents(n4);

		n3.addadjacents(n5);

		bfs(n1);

	}

}

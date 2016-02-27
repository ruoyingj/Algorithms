package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph<T> {

	static class Node<T> {
		T val;
		List<Node<T>> neighbors;

		public Node(T val) {
			this.val = val;
			neighbors = new ArrayList<>();
		}
	}

	List<Node<T>> verticals;
	Map<T, Node<T>> verticalMap;

	public Graph() {
		verticals = new ArrayList<>();
		verticalMap = new HashMap<>();
	}

	public void addEdge(T from, T to) {
		if (!verticalMap.containsKey(from))
			verticalMap.put(from, new Node<T>(from));
		if (!verticalMap.containsKey(to))
			verticalMap.put(to, new Node<T>(to));
		verticalMap.get(from).neighbors.add(verticalMap.get(to));
	}
	
	int shortestPathLength(T from, T to) {
		Queue<Node<T>> queue = new LinkedList<>(); 
		Node<T> first = verticalMap.get(from);
		queue.add(first);
		int level = 1;
		while(!queue.isEmpty()){
			
			int num = queue.size();
			for(int i = 0; i < num; i++){
				Node<T> cur = queue.poll();
				List<Node<T>> neibor = cur.neighbors;
				for(Node<T> item: neibor){
					if(item.val == to){
						return level;
					}
					queue.offer(item);
				}
			}
			level++;
		}
		return -1;
	}
	
	List<T> shortestPath(T from, T to) {
		
	}
	
	
	
	
	@Deprecated
	public void getAdjacentMatrix(T[] verticals, boolean[][] matrix) {
		int index = 0;
		for(T v : verticalMap.keySet())
			verticals[index++] = v;
		for(int i=0; i<verticals.length; i++) {
			for(int j=0; j<verticals.length; j++) {
				matrix[i][j] = false;
				for(Node<T> n : verticalMap.get(verticals[i]).neighbors) {
					if(n.val.equals(verticals[j]))
						matrix[i][j] = true;
				}
			}
		}
			
	}

}
S
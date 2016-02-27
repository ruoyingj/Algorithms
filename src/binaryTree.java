import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class BinaryTree<T> {
	static class Node<T>{
		T val;
		Node<T> left;
		Node<T> right;
		public Node(T val){
			this.val = val;
		}
		
	}
	int size;
	Node<T> root;
	HashMap<T,Node<T>> hashmap;
	public BinaryTree(){
		this.size = 0;
		root = null;
		hashmap = new HashMap();
	}
	
	public void add(T parent,T node, int direction){
		if(parent == null){
			root = new Node<T>(node);
			hashmap.put(node, root);
		}else{	
			Node<T> p = hashmap.get(parent);
			Node<T> n = new Node(node);
			hashmap.put(node, n);
			if(direction == 0){
				p.left = n;
			}else{
				p.right = n;
			}
		
		}
		size++;
		
	}
	public T[] preOrderTriverse(){
		T[] res = (T[]) new Object[size];	
		return res;
	}
	public int preOrder(T[] res, Node<T> cur, int index){
		if(cur == null){
			return index;
		}else{
			res[index++] = cur.val;
			index = preOrder(res,cur.left,index);
			index = preOrder(res,cur.right,index);
			return index;
		}
	}
	public static void main(String[] args) {
		
	
	}
	
	
	

}

package pack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class BinarySearchTree<T extends Comparable<T>> {
	public static class Node<T extends Comparable<T>> {
		T val;
		Node<T> left;
		Node<T> right;

		public Node(T val) {
			this.val = val;
		}
	}

	public BinarySearchTree(Class<T> classInstance) {
		this.size = 0;
		this.root = null;
		this.classInstance = classInstance;
	}
	
	Class<T> classInstance;

	Node<T> root;
	int size;

	public void add(T item) {
		if (root == null)
			root = new Node<T>(item);
		else
			add(root, item);
		size++;
	}

	private void add(Node<T> cur, T item) {
		if (item.compareTo(cur.val) <= 0) {
			if (cur.left == null) {
				cur.left = new Node<T>(item);
			} else {
				add(cur.left, item);
			}
		} else {
			if (cur.right == null) {
				cur.right = new Node<T>(item);
			} else {
				add(cur.right, item);
			}
		}
	}

	public T[] inOrderTriverse() {
		@SuppressWarnings("unchecked")
		T[] res = (T[]) Array.newInstance(classInstance, size);
		inOrderTriverse(root, res, 0);
		return res;
	}

	private int inOrderTriverse(Node<T> cur, T[] res, int resIndex) {
		if (cur == null)
			return resIndex;
		resIndex = inOrderTriverse(cur.left, res, resIndex);
		res[resIndex++] = cur.val;
		resIndex = inOrderTriverse(cur.right, res, resIndex);
		return resIndex;
	}

	public static void main(String[] args) {
		int size = 30;
		int[] input = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			input[i] = rand.nextInt(size * 2);
		}

		BinarySearchTree<Integer> tree = new BinarySearchTree<>(Integer.class);
		for (int i = 0; i < size; i++) {
			tree.add(input[i]);
		}
		Integer[] inOrderTriverse = tree.inOrderTriverse();
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(inOrderTriverse));
		

	}
}

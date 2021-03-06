package com.bridgelabz.Extra;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.bridgelabz.Utility.Node1;

public class LinkedList<T extends Comparable<T>> {
	

	public Node1 head = null;
	public int size = 0;

	public void list() {
		List LinkedList = Collections.emptyList();
		System.out.println("Created an empty list");
	}

	/**
	 * @param string
	 */
	public void add(T string) {
		Node1 n1 = new Node1(string);
		if (head == null) {
			head = n1;
			size++;
			return;
		}
		Node1 temp = head;
		while (temp.next != null)
			temp = (Node1) temp.next;
		temp.next = n1;
		size++;
		return;
	}

	/**
	 * @param index
	 * @return
	 */
	public Object remove(int index) {
		if (index == 0) {
			Object temp = head.data;
			head = head.next;
			size--;
			return temp;
		}
		Node1 t = head;
		int count = 0;
		while (count < index - 1) {
			t = t.next;
			count++;
		}
		Object temp = t.next.data;
		t.next = t.next.next;
		size--;
		return temp;
	}

	/**
	 * @param data1
	 * @return
	 */
	public int search(T data) {
		if (head.data.equals(data)) {
			return 0;
		}
		Node1 temp = head;
		int count = 0;
		while (temp.next != null) {
			temp = temp.next;
			count++;
			if (temp.data.equals(data)) {
				System.out.println("word is present at : " + count);
				return count;
			}
		}
		return -1;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		LinkedList l1 = new LinkedList();
		Iterator iterator = ((List) l1).iterator();
		if (iterator.hasNext() == true)
			return false;
		else
			return true;
	}

	/**
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * @param string
	 * @return
	 */
	public int index(T string) {
		if (size == -1)
			return -1;
		Node1 temp = head;
		int position = 0;
		while (!temp.data.equals(string)) {
			temp = temp.next;
			position++;
		}
		return position;
	}

	public void append(T data1) {
		add((T) data1);
	}

	/**
	 * 
	 */
	public void display() {
		// if (size == 0) {
		// System.out.println("empty list");
		// return;
		// }
		Node1 temp = head;
		while (temp != null) {
			System.out.println("data:->" + temp.data);
			temp = temp.next;
		}
	}

	public void addAt(T data, int index) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node1 n1 = new Node1(data);
		int count = 0;
		Node1 temp = head;
		while (count < index - 1) {
			temp = temp.next;
			count++;

		}
	}

	/**
	 * @param data
	 */
	private void addFirst(T data) {
		Node1 n1 = new Node1(data);
		n1.next = head;
		head = n1;
		size++;
	}

	public T pop() {

		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");

		Node1 t = head;
		int count = 0;
		while (count < index(null) - 1) {
			t = t.next;
			count++;
		}
		Object temp = t.next.data;
		t.next = t.next.next;
		size--;
		return (T) temp;
	}

	public Comparable removeFront() {
		if (head == null) {
			return "Empty Queue";
		}
		T data = (T) head.data;
		head = head.next;
		size--;
		return (Comparable) data;
	}

}
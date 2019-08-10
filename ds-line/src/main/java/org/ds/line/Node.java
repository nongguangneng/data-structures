package org.ds.line;

/**
 * 链时存储单节点
 * @author ngn
 * 2019年8月7日
 */
public class Node<E> {
	// 当前元素
	private E ele;
	// 下一个元素
	private Node<E> next;
	
	public Node(E ele, Node<E> next) {
		super();
		this.ele = ele;
		this.next = next;
	}
	public E getEle() {
		return ele;
	}
	public void setEle(E ele) {
		this.ele = ele;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
}

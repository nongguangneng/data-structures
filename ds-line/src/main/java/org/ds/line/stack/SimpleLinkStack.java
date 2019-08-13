package org.ds.line.stack;

import org.ds.line.Node;

/**
 * 链式存储实现栈
 * 头结点为栈顶,这里第一个元素能代表头结点，所以没有头结点，直接为第一个元素
 * @author ngn
 * 2019年8月13日
 */
public class SimpleLinkStack<E> extends SimpleStack<E> {

	private Node<E> head;
	private int top = -1;
	
	/* 
	 * 创建当前结点，并将当前节点设置栈顶
	 * top + 1
	 * O(1)
	 */
	@Override
	protected void push(E e) {
		Node<E> createNode = new Node<>(e, head);
		head = createNode;
		top += 1;
	}

	/* 
	 * O(1)
	 */
	@Override
	protected E pop() {
		E e = getTop();
		head = head.getNext();
		top -= 1;
		return e;
	}

	@Override
	protected int size() {
		return top == -1 ? 0 : top + 1;
	}

	@Override
	protected E getTop() {
		return head.getEle();
	}

	@Override
	protected void clear() {
		head = null;
		top = -1;
	}
	
	protected String display() {
		StringBuilder sb = new StringBuilder();
		Node<E> tmp = head;
		for (int i = 0; i <= top; i++) {
			sb.append(tmp.getEle()).append(",");
			tmp = tmp.getNext();
		}
		return sb.toString();
	}

}

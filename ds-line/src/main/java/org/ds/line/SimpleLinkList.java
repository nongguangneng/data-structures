package org.ds.line;

/**
 * 使用链式存储实现线性表 优点 不用考虑空间问题，插入/删除时间复杂度O(1) 缺点 查找时间复杂度O(n)
 * 
 * @author ngn 2019年8月7日
 */
public class SimpleLinkList<E> extends SimpleList<E> {
	private Node<E> node;
	private int size;

	public SimpleLinkList() {
		this.node = new Node<E>(null, null);
	}

	@Override
	protected void add(E e) {
		add(e, size);
	}

	/*
	 * 超过最大限度 index不在范围 抛异常 若插入最后一位， 创建Node(e, null) new
	 * Node,并将Node的next设成index+1 将index节点next设成node size + 1
	 * 其实这里时间复杂度也是O(n)，但是对于批量插入来说，只需要查到第一次的index结点
	 * 后面的插入操作均是O(1),所以链表的插入/删除时间复杂度为O(1)体现在这里，该例子并没有体现，了解该知识即可
	 */
	@Override
	protected void add(E e, int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		// 初始指向头结点下一个结点(也就是第1个)
		Node<E> indexNode = node.getNext();
		// 用于记录上一个节点
		Node<E> preNode = node;
		// 获取index当前结点
		for (int i = 0; null != indexNode && i < index; i++) {
			preNode = indexNode;
			indexNode = indexNode.getNext();
		}
		// 若没找到，插入到最后
		if (null == indexNode) {
			preNode.setNext(new Node<>(e, null));
		} else {
			// 若找到，e结点的next指向当前结点,上一结点的next指向e
			Node<E> now = new Node<E>(e, indexNode);
			preNode.setNext(now);
		}
		size += 1;
	}

	/* 
	 * 删除第index个元素
	 * 超过下标抛异常
	 * 定义一个当前节点变量now
	 * 定义index结点
	 * 找不到返回null
	 * 找到将now的next指向index节点的next
	 * size - 1
	 */
	@Override
	protected E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		Node<E> now = node;
		Node<E> indexNode = node.getNext();
		// 获取index-1结点
		for (int i = 0; null != indexNode && i < index; i++) {
			now = indexNode;
			indexNode = indexNode.getNext();
		}
		// 找不到index结点
		if (null == indexNode) {
			return null;
		}
		now.setNext(indexNode.getNext());
		size -= 1;
		return indexNode.getEle();
	}

	/*
	 * 默认指向头结点的下一个(也就是第一个结点) 定义i = 0 若i < index 且 node != null，则遍历链表 若node ==
	 * null 则没找到，否则返回index的node 若i == 0则返回第一个
	 */
	@Override
	protected E get(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		Node<E> indexNode = node.getNext();
		// 获取index当前结点
		for (int i = 0; null != indexNode && i < index; i++) {
			indexNode = indexNode.getNext();
		}
		if (null == indexNode) {
			return null;
		}
		return indexNode.getEle();
	}

	/*
	 * 时间复杂O(n)
	 */
	@Override
	protected int index(E e) {
		if (null == e) {
			return -1;
		}
		int index = -1;
		Node<E> indexNode = node.getNext();
		// 获取index当前结点
		for (int i = 0; i <= index; i++) {
			if (e.equals(indexNode.getEle())) {
				index = i;
				break;
			}
			indexNode = indexNode.getNext();
		}
		return index;
	}

	@Override
	protected int length() {
		return size;
	}

}

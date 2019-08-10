package org.ds.line;

/**
 * 利用数组实现顺序存储
 * @author ngn
 * 2019年8月7日
 */
public class SimpleArrayList<E> extends SimpleList<E>{
	private static final int DEFAULT_LEN = 10;
	private Object[] array;
	// 线性表长度
	private int size;
	
	public SimpleArrayList() {
		this.array = new Object[DEFAULT_LEN];
	}
	
	@Override
	protected void add(E e) {
		add(e, size);
	}
	
	/**
	 * 线性表长度大于线性表长度抛异常,这里简单处理，没有做扩容
	 * 位置不正确抛异常
	 * 位置不在最后一位，则index之后所有数据后移一位
	 * 在index位置插入数据e
	 * size+1
	 */
	@Override
	protected void add(E e, int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index < 0 || index > array.length - 1) {
			throw new IllegalArgumentException("index is illegal");
		}
		// 最坏的情况时间为O(n)
		if (index != array.length - 1) {
			for (int i = array.length - 1; i > index; i--) {
				array[i] = array[i - 1];
			}
		}
		array[index] = e;
		size += 1;
	}

	/**
	 * 删除跟add是相反的过程
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected E remove(int index) {
		if (0 == size || index >= size) {
			return null;
		}
		if (index < 0 || index > array.length - 1) {
			throw new IllegalArgumentException("index is illegal");
		}
		if (index != array.length - 1) {
			for (int i = index; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}
		}
		E result = (E) array[index];
		size -= 1;
		return result;
	}

	/*
	 * 数组越界抛异常
	 * 直接返回下标元素
	 * 这里直接获取,时间复杂度O(1)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected E get(int index) {
		if (index < 0 || index > array.length - 1) {
			throw new IndexOutOfBoundsException("index is illegal");
		}
		return (E) array[index];
	}

	@Override
	protected int index(E e) {
		if (null == e) {
			return -1;
		}
		int index = -1;
		for (int i = 0;i < array.length; i++) {
			if (e.equals(array[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	protected int length() {
		return size;
	}
}

package org.ds.line.stack;

/**
 * 顺序存储栈，内部使用数组实现，选择0下标做栈低，因为变化量较小
 * 为了简化代码，数组越界异常处理，不做动态扩容
 * @author ngn
 * 2019年8月13日
 */
public class SimpleArrayStack<E> extends SimpleStack<E> {
	private final static int DEFAULT_SIZE = 10;
	// 内部元素
	private Object[] elements;
	// top下标 空栈为-1,满栈为elements.length - 1
	private int top = -1;
	
	public SimpleArrayStack() {
		this.elements = new Object[DEFAULT_SIZE];
	}
	
	public SimpleArrayStack(int size) {
		this.elements = new Object[size];
	}

	/* 
	 * 容量检查
	 * 当前size位置赋值
	 * size + 1
	 * O(1)
	 */
	@Override
	protected void push(E e) {
		if (top == elements.length - 1) {
			throw new ArrayStoreException("容量已满");
		}
		elements[++top] = e;
	}

	/* 
	 * 弹出栈顶元素
	 * O(1)
	 */
	@Override
	protected E pop() {
		if (top < 0) {
			return null;
		} 
		return (E) elements[top--];
	}

	@Override
	protected int size() {
		return top == -1 ? 0 : top + 1;
	}

	/* 
	 * 获取栈顶元素，区别pop就是元素还在栈内
	 * O(1)
	 */
	@Override
	protected E getTop() {
		return (E) elements[top];
	}

	/* 
	 * 虽然元素还存在数组中，但是栈顶已经为-1,逻辑认为被清空
	 * O(1)
	 */
	@Override
	protected void clear() {
		top = -1;
	}
	
	protected String display() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			sb.append(elements[i]).append(",");
		}
		return sb.toString();
	}

}

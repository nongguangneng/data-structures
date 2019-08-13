package org.ds.line.stack;

/**
 * 实现栈结构，只允许一端操作，LIFO
 * @author ngn
 * 2019年8月13日
 */
public abstract class SimpleStack<E> {

	protected abstract void push(E e);
	protected abstract E pop();
	protected abstract int size();
	protected abstract E getTop();
	protected abstract void clear();
}

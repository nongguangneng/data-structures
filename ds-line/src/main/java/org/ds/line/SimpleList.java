package org.ds.line;

/**
 * 抽象线性关系类
 * 包含基础CRUD操作
 * @author ngn
 * 2019年8月7日
 */
public abstract class SimpleList<E> {

	protected abstract void add(E e);
	/**
	 * 指定位置插入数据
	 * @param e
	 * @param index
	 */
	protected abstract void add(E e, int index);
	/**
	 * 删除指定位置数据，若删除成功返回被删除数据
	 * @param index
	 * @return
	 */
	protected abstract E remove(int index);
	/**
	 * 获取指定位置数据
	 * @param index
	 * @return
	 */
	protected abstract E get(int index);
	/**
	 * 查找数据对应位置
	 * @param e
	 * @return
	 */
	protected abstract int index(E e);
	/**
	 * 查看线性长度
	 * @param e
	 * @return
	 */
	protected abstract int length();
}

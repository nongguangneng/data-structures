package org.ds.line;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleArrayLIstTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testLog() {
		logger.info("test log");
	}
	
	@Test
	public void testAdd() {
		SimpleList<Integer> list = new SimpleArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Assert.assertEquals(list.length(), 3);
	}
	
	@Test
	public void testRemove() {
		SimpleList<Integer> list = new SimpleArrayList<>();
		list.add(1);
		list.add(2);
		display(list);
		list.remove(1);
		display(list);
		Assert.assertEquals(list.length(), 1);
	}
	
	@Test
	public void testGet() {
		SimpleList<Integer> list = new SimpleArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		display(list);
		Assert.assertEquals(list.get(1).intValue(), 2);
		// 数组越界请况
		try {
			list.get(list.length());
		} catch (IndexOutOfBoundsException e) {
			Assert.assertTrue(null != e);
		}
	}
	
	@Test
	public void testAddErr() {
		SimpleList<Integer> list = new SimpleArrayList<>();
		for (int i = 0; i < 15; i++) {
			list.add(i);
		}
	}
	
	private void display(SimpleList<?> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length(); i++) {
			sb.append(list.get(i)).append(",");
		}
		logger.info(sb.toString());
	}
}

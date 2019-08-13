package org.ds.line.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleArrayStackTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private SimpleArrayStack<Integer> stack;
	
	@Before
	public void init() {
		stack = new SimpleArrayStack<>(3);
	}
	
	@Test
	public void testAdd() {
		stack.push(1);
		stack.push(2);
		Assert.assertEquals(2, stack.size());
	}
	
	@Test
	public void testRemove() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int rmResult = stack.pop();
		Assert.assertEquals(2, stack.size());
		Assert.assertEquals(3, rmResult);
	}
	
	@Test
	public void testGet() {
		stack.push(1);
		stack.push(2);
		int getResult = stack.getTop();
		Assert.assertEquals(2, getResult);
		Assert.assertEquals(2, stack.size());
	}
	
	@Test
	public void testError() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		try {
			stack.push(4);
		} catch (ArrayStoreException e) {
			Assert.assertNotNull(e);
		}
	}
	
	@Test
	public void testClear() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.clear();
		Assert.assertEquals(0, stack.size());
		logger.info(stack.display());
	}
}

package org.ds.line;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLinkListTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private SimpleLinkList<Integer> list;
	
	@Before
	public void pre() {
		list = new SimpleLinkList<>();
	}
	
	@Test
	public void testAdd() {
		display(list);
		list.add(1);
		list.add(2);
		list.add(3);
		display(list);
		logger.info(list.get(1).toString());
		Assert.assertEquals(list.length(), 3);
	}
	
	@Test
	public void testRemove() {
		list.add(1);
		list.add(2);
		list.add(3);
		display(list);
		Integer removeData = list.remove(1);
		display(list);
		logger.info("删除节点为:{}", removeData);
		Assert.assertEquals(list.length(), 2);
	}
	
	private void display(SimpleList<?> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length(); i++) {
			sb.append(list.get(i)).append(",");
		}
		logger.info(sb.toString());
	}
}

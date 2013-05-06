package org.springside.examples.quickstart.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.criteria.Path;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springside.examples.quickstart.entity.User;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MySpecificationTest extends SpringTransactionalTestCase
{
	@Autowired
	private UserDao userDao;

	@Test
	public void find() throws Exception
	{
		Specification<User> spec = new MySpecification();
		List<User> all = userDao.findAll(spec);
		for (User user2 : all)
		{
			System.out.println(user2.getLoginName());
		}
		
	}
}

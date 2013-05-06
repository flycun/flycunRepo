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
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.google.common.collect.Maps;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MySpecificationTest extends SpringTransactionalTestCase
{
	@Autowired
	private UserDao userDao;

	@Test
	public void find() throws Exception
	{
//		Specification<User> spec=buildSpecification2();
//		List<User> all=userDao.findAll(spec);
		Specification<User> spec = new MySpecification();
		List<User> all = userDao.findAll(spec);
		for (User user2 : all)
		{
			System.out.println(user2.getName());
		}
		System.out.println("----end----");
	}
	
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<User> buildSpecification2() {
		Map<String, SearchFilter> filters = Maps.newHashMap();
		filters.put("name", new SearchFilter("name", Operator.LIKE, "%i%"));
//		for (Entry<String, SearchFilter> elem	 : filters.entrySet()) {
//			System.out.println("====> key="+elem.getKey()+": value="+elem.getValue().fieldName);
//		}
		Specification<User> spec = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
		return spec;
	}
}

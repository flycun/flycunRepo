package org.springside.examples.quickstart.repository;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springside.examples.quickstart.entity.User;

public class MySpecification implements Specification<User>
{
	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
	{

//		CriteriaQuery<User> cq = cb.createQuery(User.class);
//		Root<User> rt = cq.from(User.class);
//		Path<Set<String>> expression=rt.get("ss");
//		cq.select(rt).where(cb.isMember("", expression));
		
		root = query.from(User.class);
		Path nameExp = root.get("loginName");
		return cb.like(nameExp, "%ad%");

	}
}

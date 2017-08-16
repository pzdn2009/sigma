package com.l3lab.domain.service;

import com.l3lab.domain.entity.Task;
import com.l3lab.web.model.requeset.QueryTaskRequestDto;
import lombok.experimental.var;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 15:58
 * <p>
 * Desc: {描述}
 */
public class QueryTasksSpecification implements Specification<Task> {

    private QueryTaskRequestDto queryDto;

    public QueryTasksSpecification(QueryTaskRequestDto requestDTO) {
        this.queryDto = requestDTO;
    }

    @Override
    public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

        var list = new ArrayList<Predicate>();

        if (queryDto.getTitle() != null) {
            list.add(cb.like(root.get("title"), queryDto.getTitle()));
        }

        if (queryDto.getTags() != null) {
            list.add(cb.like(root.get("tags"), queryDto.getTags()));
        }

        if (queryDto.getCreateUser() != null) {
            list.add(cb.equal(root.get("createUser"), queryDto.getCreateUser()));
        }

        if (queryDto.getUpdateUser() != null) {
            list.add(cb.equal(root.get("updateUser"), queryDto.getUpdateUser()));
        }

        if (queryDto.getTaskStatus() != null) {
            list.add(cb.equal(root.get("taskStatus"), queryDto.getTaskStatus()));
        }

        Predicate[] p = new Predicate[list.size()];

        return cb.and(list.toArray(p));
    }
}

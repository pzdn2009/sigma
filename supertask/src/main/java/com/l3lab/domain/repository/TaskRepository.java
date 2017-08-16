package com.l3lab.domain.repository;

import com.l3lab.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 12:16
 * <p>
 * Desc: {描述}
 */
@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}

package com.l3lab.domain.service;

import com.l3lab.web.model.requeset.CreateTaskRequestDto;
import com.l3lab.web.model.response.TaskResponseDto;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 12:29
 * <p>
 * Desc: {描述}
 */
public interface TaskDomainService {
    TaskResponseDto getTask(Long id);
    void createTask(CreateTaskRequestDto createTaskRequestDto);
}

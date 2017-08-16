package com.l3lab.domain.service;

import com.l3lab.common.PagingResult;
import com.l3lab.web.model.requeset.CreateTaskRequestDto;
import com.l3lab.web.model.requeset.EditTaskRequestDto;
import com.l3lab.web.model.requeset.QueryTaskRequestDto;
import com.l3lab.web.model.response.TaskResponseDto;

import java.util.List;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 12:29
 * <p>
 * Desc: {描述}
 */
public interface TaskDomainService {
    List<TaskResponseDto> getAllTask();
    TaskResponseDto getTask(Long id);
    TaskResponseDto createTask(CreateTaskRequestDto createTaskRequestDto);
    TaskResponseDto editTask(EditTaskRequestDto editTaskRequestDto);
    PagingResult<List<TaskResponseDto>> getTasks(QueryTaskRequestDto queryTaskRequestDto);
}

package com.l3lab.web.controller;

import com.l3lab.common.PagingResult;
import com.l3lab.domain.service.TaskDomainService;
import com.l3lab.web.model.Response;
import com.l3lab.web.model.requeset.CreateTaskRequestDto;
import com.l3lab.web.model.requeset.EditTaskRequestDto;
import com.l3lab.web.model.requeset.QueryTaskRequestDto;
import com.l3lab.web.model.response.TaskResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 10:41
 * <p>
 * Desc: {描述}
 */
@RestController
@RequestMapping("/api/task")
@Api(description = "任務api訪問")
public class TaskController {

    private TaskDomainService taskDomainService;

    public TaskController(TaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @ApiOperation(value = "創建task")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Response<TaskResponseDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        return Response.success(taskDomainService.createTask(createTaskRequestDto));
    }

    @ApiOperation(value = "修改task")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public Response <TaskResponseDto> editTask(@Valid @RequestBody EditTaskRequestDto editTaskRequestDto) {
        return Response.success(taskDomainService.editTask(editTaskRequestDto));
    }

    @ApiOperation(value = "獲取task")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response<TaskResponseDto> getTask(@RequestParam Long id) {
        return Response.success(taskDomainService.getTask(id));
    }

    @ApiOperation(value = "獲取所有task")
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Response<List<TaskResponseDto>> getAllTask() {
        return Response.success(taskDomainService.getAllTask());
    }

    @ApiOperation(value = "按條件查詢task")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Response<PagingResult<List<TaskResponseDto>>> getTasks(@Valid @RequestBody QueryTaskRequestDto queryTaskRequestDto) {
        return Response.success(taskDomainService.getTasks(queryTaskRequestDto));
    }
}

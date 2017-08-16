package com.l3lab.web.controller;

import com.l3lab.domain.service.TaskDomainService;
import com.l3lab.web.model.requeset.CreateTaskRequestDto;
import com.l3lab.web.model.response.TaskResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

    @ApiOperation(value = "獲取task")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        taskDomainService.createTask(createTaskRequestDto);
    }

    @ApiOperation(value = "獲取task")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public TaskResponseDto getTask(@RequestParam Long id) {
        return taskDomainService.getTask(id);
    }
}

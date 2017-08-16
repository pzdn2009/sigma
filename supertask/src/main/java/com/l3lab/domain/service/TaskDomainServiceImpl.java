package com.l3lab.domain.service;

import com.l3lab.common.PagingResult;
import com.l3lab.domain.entity.Task;
import com.l3lab.domain.repository.TaskRepository;
import com.l3lab.web.model.requeset.CreateTaskRequestDto;
import com.l3lab.web.model.requeset.EditTaskRequestDto;
import com.l3lab.web.model.requeset.QueryTaskRequestDto;
import com.l3lab.web.model.response.TaskResponseDto;
import lombok.experimental.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 12:29
 * <p>
 * Desc: {描述}
 */
@Service
public class TaskDomainServiceImpl implements TaskDomainService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskDomainServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskResponseDto> getAllTask() {

        var result = new ArrayList<TaskResponseDto>();

        var tasks = taskRepository.findAll();
        for (Task task : tasks) {
            ModelMapper modelMapper = new ModelMapper();
            result.add(modelMapper.map(task, TaskResponseDto.class));
        }

        return result;
    }

    @Override
    public TaskResponseDto getTask(Long id) {
        var task = taskRepository.findOne(id);

        if (task != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(task, TaskResponseDto.class);
        }

        return null;
    }

    @Override
    public TaskResponseDto createTask(CreateTaskRequestDto createTaskRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Task task = modelMapper.map(createTaskRequestDto, Task.class);
        taskRepository.save(task);

        return modelMapper.map(task, TaskResponseDto.class);
    }

    @Override
    public TaskResponseDto editTask(EditTaskRequestDto editTaskRequestDto) {

        var task = taskRepository.findOne(editTaskRequestDto.getId());
        if (task != null) {
            task.setTitle(editTaskRequestDto.getTitle());
            task.setDetail(editTaskRequestDto.getDetail());
            task.setTags(editTaskRequestDto.getTags());
            task.setUpdateUser(editTaskRequestDto.getUpdateUser());
            task.setTaskStatus(editTaskRequestDto.getStatus());

            taskRepository.save(task);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(task, TaskResponseDto.class);
        }

        return null;
    }

    @Override
    public PagingResult<List<TaskResponseDto>> getTasks(QueryTaskRequestDto requestDTO) {

        var result = new PagingResult<List<TaskResponseDto>>();

        var page = new PageRequest(requestDTO.getPage(), requestDTO.getSize(), Sort.Direction.ASC, "id");
        if (requestDTO.getAsc() == 0) {
            page = new PageRequest(requestDTO.getPage(), requestDTO.getSize(), Sort.Direction.DESC, "id");
        }

        var query = taskRepository.findAll(new QueryTasksSpecification(requestDTO), page);

        result.setTotal(query.getTotalElements());
        result.setTotalPage(query.getTotalPages());

        var dataResult = new ArrayList<TaskResponseDto>();
        query.forEach((task) -> dataResult.add(new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDetail(),
                task.getTags()
        )));

        result.setData(dataResult);

        return result;
    }
}

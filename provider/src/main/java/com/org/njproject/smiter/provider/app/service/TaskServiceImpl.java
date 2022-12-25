package com.org.njproject.smiter.provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.njproject.smiter.provider.api.dao.TaskDAO;
import com.org.njproject.smiter.provider.api.service.TaskService;
import com.org.njproject.smiter.provider.app.model.Task;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDAO dao;

    public List<Task> getTaskList() {
        return dao.findAllTasks();
    }

    public void deleteTask(Task task) {
        dao.deleteTaskById(task.getId());
    }

    public Task addTask(Task task) {
        return dao.saveTask(task);
    }
    
}

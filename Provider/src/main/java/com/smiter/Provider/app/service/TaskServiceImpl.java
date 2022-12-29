package com.smiter.Provider.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smiter.Provider.api.dao.TaskDAO;
import com.smiter.Provider.api.service.TaskService;
import com.smiter.Provider.app.model.Task;

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

package com.smiter.Provider.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smiter.Provider.api.dao.TaskDAO;
import com.smiter.Provider.app.model.Task;
import com.smiter.Provider.app.repo.TaskRepo;

import jakarta.transaction.Transactional;

@Repository
public class TaskDAOImpl implements TaskDAO{

    @Autowired
    private TaskRepo repo;

    @Transactional
    public List<Task> findAllTasks() {
        return repo.findAll();
    }

    @Transactional
    public Task findTaskById(Long id) {
        Optional<Task> task = repo.findById(id);
        return task.get();
    }

    @Transactional
    public Task saveTask(Task task) {
        return repo.save(task);
    }

    @Transactional
    public void deleteTaskById(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public Task updateTask(Task task) {
        Task tmp = findTaskById(task.getId());
        tmp.setId(task.getId());
        tmp.setTaskItems(task.getTaskItems());
        tmp.setTaskTitle(task.getTaskTitle());
        tmp.setDueDate(task.getDueDate());

        return task;
    }
    
}

package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.Task;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    public Task saveTask(Task task)
    {
        return taskRepo.save(task);
    }

    public List<Task> getAllTask()
    {
        List<Task> taskList = new ArrayList<>();
        Streamable.of(taskRepo.findAll()).forEach(taskList::add);
        return taskList;
    }

    public Task getTaskById(int id) {
        Optional<Task> taskOptional = taskRepo.findById(id);
        if (taskOptional.isPresent()) {
            return taskOptional.get();
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    //Update Task
    public Task updateTask(int id, Task updatedTask)
    {
        Optional<Task> taskOptional = taskRepo.findById(id);
        if(taskOptional.isPresent())
        {
            Task task = taskOptional.get();
            task.setTask_name(updatedTask.getTask_name());
            task.setTask_status(updatedTask.getTask_status());
            task.setTask_deadline(updatedTask.getTask_deadline());
            task.setTaskTeam(updatedTask.getTaskTeam());
            return taskRepo.save(task);
        } else
        {
            throw new RuntimeException("Task not found");
        }
    }

}

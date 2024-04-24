package com.example.gp9assignment2.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gp9assignment2.R;
import com.example.gp9assignment2.adapter.TasksAdapter;
import com.example.gp9assignment2.model.Task;
import com.example.gp9assignment2.databinding.ActivityListtasksBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListtasksActivity extends AppCompatActivity {

    private ActivityListtasksBinding binding;
    private TasksAdapter tasksAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListtasksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize RecyclerView and layout manager
        RecyclerView recyclerViewTasks = binding.recyclerViewTasks;
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));

        // Load task list
        taskList = loadTasks();

        // Initialize TasksAdapter
        tasksAdapter = new TasksAdapter(taskList, this);

        // Set adapter to RecyclerView
        recyclerViewTasks.setAdapter(tasksAdapter);
    }

    // Method to load task list from SharedPreferences
    private List<Task> loadTasks() {
        SharedPreferences sharedPreferences = getSharedPreferences("TaskPreferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("taskList", null);
        Type type = new TypeToken<ArrayList<Task>>() {}.getType();

        if (json != null) {
            return gson.fromJson(json, type);
        } else {
            return new ArrayList<>();
        }
    }

    // Method to save task list to SharedPreferences
    private void saveTasks(List<Task> taskList) {
        SharedPreferences sharedPreferences = getSharedPreferences("TaskPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(taskList);
        editor.putString("taskList", json);
        editor.apply();
    }

    // Method to update task list and notify adapter
    public void updateTaskList(List<Task> updatedTaskList) {
        taskList.clear();
        taskList.addAll(updatedTaskList);
        tasksAdapter.notifyDataSetChanged();
        saveTasks(taskList);
    }
}

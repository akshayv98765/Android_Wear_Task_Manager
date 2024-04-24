package com.example.gp9assignment2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gp9assignment2.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddTask;
    private Button buttonListTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonListTasks = findViewById(R.id.buttonListTasks);

        // Set click listener for Add Task button
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AddTaskActivity
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for List Tasks button
        buttonListTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open ListtasksActivity
                Intent intent = new Intent(MainActivity.this, ListtasksActivity.class);
                startActivity(intent);
            }
        });
    }
}


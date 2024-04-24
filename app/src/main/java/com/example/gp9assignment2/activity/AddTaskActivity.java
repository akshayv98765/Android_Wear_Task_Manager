package com.example.gp9assignment2.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gp9assignment2.R;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextTaskID;
    private EditText editTextTaskName;
    private EditText editTextDueDateTime;
    private Button buttonAddTask;

    private Calendar calendar;

    private int taskIdCounter = 1; // Counter for task IDs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);

        // Initialize views
        editTextTaskID = findViewById(R.id.editTextTaskID);
        editTextTaskName = findViewById(R.id.editTextTaskName);
        editTextDueDateTime = findViewById(R.id.editTextDueDateTime);
        buttonAddTask = findViewById(R.id.buttonAddTask);

        // Initialize Calendar instance
        calendar = Calendar.getInstance();

        // Set initial task ID
        editTextTaskID.setText("Task" + taskIdCounter);

        // Set click listener for the Add Task button
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get task name and due date from EditText fields
                String taskName = editTextTaskName.getText().toString().trim();
                String dueDateTime = editTextDueDateTime.getText().toString().trim();

                // Validate task name and due date
                if (taskName.isEmpty() || dueDateTime.isEmpty()) {
                    Toast.makeText(AddTaskActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Increment task ID counter and update task ID field
                    taskIdCounter++;
                    editTextTaskID.setText("Task" + taskIdCounter);

                    // Add task to database or perform required action
                    // For now, just display a toast message
                    Toast.makeText(AddTaskActivity.this, "Task added successfully", Toast.LENGTH_SHORT).show();
                    // Clear EditText fields after adding task
                    editTextTaskName.setText("");
                    editTextDueDateTime.setText("");
                }
            }
        });

        // Set click listener for Due Date & Time field
        editTextDueDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Date and Time picker dialog
                showDateTimePicker();
            }
        });
    }

    // Method to show Date and Time picker dialog
    private void showDateTimePicker() {
        // Get current date and time
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show DatePicker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Update Calendar instance with selected date
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        // Show TimePicker dialog after Date is set
                        TimePickerDialog timePickerDialog = new TimePickerDialog(AddTaskActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        // Update Calendar instance with selected time
                                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                        calendar.set(Calendar.MINUTE, minute);

                                        // Update EditText field with selected date and time
                                        updateDueDateTimeEditText();
                                    }
                                }, hour, minute, true); // Use 24-hour format

                        // Show TimePicker dialog
                        timePickerDialog.show();
                    }
                }, year, month, day);

        // Show DatePicker dialog
        datePickerDialog.show();
    }

    // Method to update Due Date & Time EditText field with selected date and time
    private void updateDueDateTimeEditText() {
        // Format date and time
        String dateTimeFormat = "MM/dd/yyyy HH:mm"; // Date and time format
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(dateTimeFormat, java.util.Locale.getDefault());
        // Set formatted date and time to EditText field
        editTextDueDateTime.setText(sdf.format(calendar.getTime()));
    }
}

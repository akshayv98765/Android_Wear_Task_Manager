package com.example.gp9assignment2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gp9assignment2.R;
import com.example.gp9assignment2.model.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private List<Task> taskList;
    private Context context;

    public TasksAdapter(List<Task> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.txtTask.setText("TaskID: " + task.getTaskId() +
                " Task Name: " + task.getTaskName() +
                " Task Due: " + task.getDueDateTime());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTask = itemView.findViewById(R.id.txtTask);
        }

        /*private TextView textViewTaskId, textViewTaskName, textViewDueDateTime;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTaskId = itemView.findViewById(R.id.textViewTaskId);
            textViewTaskName = itemView.findViewById(R.id.textViewTaskName);
            textViewDueDateTime = itemView.findViewById(R.id.textViewDueDateTime);
        }

        public void bind(Task task) {
            textViewTaskId.setText(task.getTaskId());
            textViewTaskName.setText(task.getTaskName());
            textViewDueDateTime.setText(task.getDueDateTime());
        }*/
    }
}

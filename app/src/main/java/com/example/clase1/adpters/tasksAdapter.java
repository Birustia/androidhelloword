package com.example.clase1.adpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clase1.R;
import com.example.clase1.modelos.Task;

import java.util.List;

public class tasksAdapter extends BaseAdapter {

    private List<Task> tasks;

    public tasksAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        Task t = tasks.get(position);

        return t;
    }

    @Override
    public long getItemId(int position) {

        return tasks.get(position).getId();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        TextView tvTitle = v.findViewById(R.id.tv_task_title);
        TextView tvPriority = v.findViewById(R.id.tv_task_priority);
        Task task = getItem(position);

        tvTitle.setText(task.getTitle());
        tvPriority.setText(task.getPriority());


        return v;
    }
}

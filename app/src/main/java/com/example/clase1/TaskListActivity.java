package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.clase1.adpters.tasksAdapter;
import com.example.clase1.modelos.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Intent loginintent =getIntent();
        String mail = loginintent.getStringExtra("Key_Mail");
        Toast.makeText(this, mail, Toast.LENGTH_SHORT).show();

        ListView lvTasks= findViewById(R.id.lv_tasks);
        final List<Task> taskList = new ArrayList<>();
        Task t1 =new Task(0,"pasear perro","sacar pronto","alta",false);
        Task t2 =new Task(0,"pasear perro","sacar pronto","alta",false);
        Task t3 =new Task(0,"pasear perro","sacar pronto","alta",false);
        Task t4 =new Task(0,"pasear perro","sacar pronto","alta",false);

        taskList.add(t1);
        taskList.add(t2);
        taskList.add(t3);
        taskList.add(t4);

        tasksAdapter adapter = new tasksAdapter(taskList);
        lvTasks.setAdapter(adapter);

        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TaskListActivity.this, taskList.get(i).getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

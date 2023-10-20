package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TodoListApp extends AppCompatActivity {

    EditText nameInput, descInput;
    Button data;
    Button btn;
    SQLConnection con;
    List<Todo> list;
    TextView outputText;
    ListView listView;

    List<TextView> d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_app);

        nameInput = findViewById(R.id.name_id);
        descInput = findViewById(R.id.des_id);
        btn = (Button) findViewById(R.id.addTodoBtn);
//        outputText = findViewById(R.id.outputText);
        con = new SQLConnection(this);
        listView = findViewById(R.id.listItem);

        list = con.readToDo();
        readDataFromDb(list);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String desc = descInput.getText().toString();

                if(con.insertTodo(name,desc)){
                    Toast.makeText(TodoListApp.this,"Inserted successfully",Toast.LENGTH_LONG).show();
                }
                list = con.readToDo();
                readDataFromDb(list);
            }
        });
    }

    private void readDataFromDb(List<Todo> list) {
        for(int i=0;i<list.size();i++){
//            outputText.append(l.getName() + " : "+ l.getDesc()+"\n");
//            outputText.setMovementMethod(new ScrollingMovementMethod());
//        ArrayAdapter<String> arr  = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,list);
//        listView.setAdapter(arr);
        }
    }


}
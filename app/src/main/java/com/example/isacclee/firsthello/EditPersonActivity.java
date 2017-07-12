package com.example.isacclee.firsthello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);

        Button changeButton = (Button) findViewById(R.id.button);
        changeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                BackToPerson();
            }
        });
    }

    protected void BackToPerson(){
        Intent intent = new Intent();
        intent.setClass(EditPersonActivity.this,PersonInfoActivity.class);
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
}

package com.example.isacclee.firsthello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPersonActivity extends AppCompatActivity {

    private EditText oPasswordView;
    private EditText nPasswordView;
    private EditText TelView;
    private EditText emailView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);

        oPasswordView = (EditText) findViewById(R.id.editText);
        nPasswordView = (EditText) findViewById(R.id.editText2);
        TelView = (EditText) findViewById(R.id.editText3);
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

        String oPassword;
        String nPassword;
        String Email;
        String Telephone;
        oPassword =oPasswordView.getText().toString();
        nPassword =nPasswordView.getText().toString();
        Telephone =TelView.getText().toString();

        Controller controller = new Controller();
        Email = "1111@";
        int re = controller.EditInfo(Email,oPassword,nPassword,Telephone);
        if(re == 1){
            Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "修改失败！", Toast.LENGTH_SHORT).show();
        }

        startActivity(intent);
    }
}

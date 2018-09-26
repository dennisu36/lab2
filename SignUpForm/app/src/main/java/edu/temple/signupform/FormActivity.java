package edu.temple.signupform;

import android.content.Intent;
import android.service.autofill.Validator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity{

    private EditText username, email, password, passwordConf;
    private Button save;
    private String USERNAME;
    private int request_code=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        passwordConf=findViewById(R.id.passwordConf);
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!usernameInput(username.getText().toString())){
                    Toast.makeText(FormActivity.this, "Invalid username", Toast.LENGTH_SHORT).show();
                }
                else if(!emailInput(email.getText().toString())){
                    Toast.makeText(FormActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
                }
                else if(!passwordInput(password.getText().toString())){
                    Toast.makeText(FormActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
                else if(!passwordConf.getText().toString().equals(password.getText().toString())){
                    Toast.makeText(FormActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(FormActivity.this, WelcomeScreen.class);
                    intent.putExtra(USERNAME, username.getText().toString());
                    startActivityForResult(intent, request_code);

                }
            }

        });

    }
    protected boolean usernameInput(String username){
        if(username.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    protected boolean emailInput(String email){
        if(email!=null && email.contains("@")){
            return true;
        }
        else{
            return false;
        }

    }

    protected boolean passwordInput(String password){
        if(password!=null){
            return true;
        }
        else{
            return false;
        }
    }

}

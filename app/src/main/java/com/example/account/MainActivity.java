package com.example.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText etemail , etpassword,etconfirmpass;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connectcompomnents();
    }

    private void Connectcompomnents() {
        etemail=findViewById(R.id.emailmain);
        etpassword=findViewById(R.id.passmain);
        btn=findViewById(R.id.btnmain);
        etconfirmpass=findViewById(R.id.confirmpassmain);
    }


    public void go(View view) {
        String email,password,confrirmpass;
        confrirmpass=etconfirmpass.getText().toString();
        email=etemail.getText().toString();
        password=etpassword.getText().toString();
        if(email.trim().isEmpty()||password.trim().isEmpty()||confrirmpass.trim().isEmpty())
        {
            Toast.makeText(this, "some fields are missing", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isEmailValid(email))
        {
            Toast.makeText(this, "email is incorrect!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isPasswordValid())
        {
            Toast.makeText(this, "password is incorrect!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.equals(confrirmpass))
        {
            Toast.makeText(this, "is not the same!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    public boolean isEmailValid(String str)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public boolean isPasswordValid(String password)
    {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public void f(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fram, new LoginFragment());
        ft.commit();

    }
}
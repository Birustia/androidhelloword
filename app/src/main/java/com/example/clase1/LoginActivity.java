package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_Email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            iniciarSecion();


        }
    }


    public void iniciarSecion() {

        String mail = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        boolean correcto = validarLogeo(mail, password);
        if (correcto) {
            Toast.makeText(this, "inicio secion correcto", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, TaskListActivity.class);
            i.putExtra("Key_Mail",mail);
            startActivity(i);
            finish();
        }
        else
            Toast.makeText(this, "no se puedo iniciar secion", Toast.LENGTH_SHORT).show();
    }

    public boolean validarMail(String mail) {
        if (mail.trim().isEmpty()) return false;
        String regEx = "^[a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
        Pattern regCom = Pattern.compile(regEx);
        Matcher matEX = regCom.matcher(mail);

        if (matEX.find()) {
            return true;

        } else {
            return false;
        }
    }

    public boolean validarLogeo(String mail, String password) {


        if (password.length() >= 7) {
            Toast.makeText(this, "contraseña  correcta", Toast.LENGTH_SHORT).show();

        }else {
            etPassword.setError("Ingrese una contraseña valida");
            etPassword.requestFocus();
            Toast.makeText(this, "contraseña  incorrecta", Toast.LENGTH_SHORT).show();
        }

        if (validarMail(mail)) {
            Toast.makeText(this, "mail bien ingresado", Toast.LENGTH_SHORT).show();

        } else {
            etEmail.setError("Ingrese un mail valido");
            etEmail.requestFocus();
            Toast.makeText(this, "mail mal ingresado", Toast.LENGTH_SHORT).show();
        }

        if ((password.length() >= 7) && (validarMail(mail))) {

            return true;


        } else {
            return false;
        }


    }
}
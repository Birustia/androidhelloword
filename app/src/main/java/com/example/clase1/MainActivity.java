package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_Email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            iniciarSecion(view);


        }
    }


    public void iniciarSecion(View v) {

        String mail = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if ((!validarVacio(mail)) && (!validarVacio(password)) && (password.length() >= 7) && (validarMail(mail))) {

            Toast.makeText(this, "Iniciando Sesión", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "error en el logeo", Toast.LENGTH_SHORT).show();
        }

        if (validarVacio(mail)) {
            Toast.makeText(this, "mail vacio", Toast.LENGTH_SHORT).show();

        }

        if ((validarVacio(password)) && (password.length() >= 7)) {
            Toast.makeText(this, "contraseña vacia", Toast.LENGTH_SHORT).show();

        }

        if (validarMail(mail)) {
            Toast.makeText(this, "mail bien ingresado", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "mail mal ingresado", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean validarMail(String mail) {
        String regEx = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
        Pattern regCom = Pattern.compile(regEx);
        Matcher matEX = regCom.matcher(mail);

        if (matEX.find()) {
            return true;

        } else {
            return false;
        }
    }


    public boolean validarVacio(String mail) {
        return mail.trim().isEmpty();
    }
}

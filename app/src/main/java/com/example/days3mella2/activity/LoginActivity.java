package com.example.days3mella2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.days3mella2.R;

import java.util.Locale;

public class LoginActivity extends LoginActivity2 implements LoginActivity1 {

    Button login;
    EditText username, password;
    private Menu menu;

    //handle pengubahan bahsa




    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.login_relative);

        login = (Button) findViewById(R.id.btnsignin);
        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (password.getText().toString().toUpperCase(Locale.ROOT).equals("TEST1")) {
                    login_sukses();
                } else {
                    Toast.makeText(getApplicationContext(), "Salah Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected boolean onOptionItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.action_settings) {
            Intent Intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(Intent);
        }
        return onOptionItemSelected(item);
    }





    private void login_sukses() {
        String user_login = username.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("USERNAME", user_login);
        startActivity(i);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

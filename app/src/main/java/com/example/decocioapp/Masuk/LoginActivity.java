package com.example.decocioapp.Masuk;

import
        androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.decocioapp.MainActivity;
import com.example.decocioapp.Model.ResponseLogin;
import com.example.decocioapp.Network.InterfaceClient;
import com.example.decocioapp.Network.RetrofitConfig;
import com.example.decocioapp.R;
import com.example.decocioapp.SharedPreferenceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnLogin;
    ProgressDialog progressDialog;
    SharedPreferenceManager sharedPreferenceManager;
    TextView tvReg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_pass);
        sharedPreferenceManager = new SharedPreferenceManager(this);

        if (sharedPreferenceManager.getSigned()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        progressDialog = new ProgressDialog(this);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageEmail = "Email tidak boleh kosong";
                String messagePassword = "Password tidak boleh kosong";
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                if (etEmail.getText().toString().isEmpty()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, messageEmail, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etPassword.getText().toString().isEmpty()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, messagePassword, Toast.LENGTH_SHORT).show();
                    return;
                }
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                InterfaceClient interfaceClient = RetrofitConfig.createService(InterfaceClient.class);
                Call<ResponseLogin> requestLogin = interfaceClient.loginUser("user", "login", email, password);

                requestLogin.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        progressDialog.dismiss();
                        if (response.body().getHasil().equals("success")){
                            sharedPreferenceManager.saveBoolean(SharedPreferenceManager.SP_SIGNED, true);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "login Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Koneksi Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        tvReg = findViewById(R.id.tv_reg);
        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
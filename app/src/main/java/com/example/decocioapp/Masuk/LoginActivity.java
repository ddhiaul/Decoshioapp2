package com.example.decocioapp.Masuk;

import
        androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.decocioapp.Customer.HomeFragment;
import com.example.decocioapp.MainActivity;
import com.example.decocioapp.Model.ResponseLogin;
import com.example.decocioapp.Network.InterfaceClient;
import com.example.decocioapp.Network.RetrofitConfig;
import com.example.decocioapp.R;
import com.example.decocioapp.SharedPreferenceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLogin,etPassLogin;
    Button btnLogin;
    ProgressDialog loading;
    SharedPreferenceManager sharedPreferenceManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailLogin = findViewById(R.id.et_email_login);
        etPassLogin = findViewById(R.id.et_pass_login);

        sharedPreferenceManager = new SharedPreferenceManager(this);

        if (sharedPreferenceManager.getSpSigned()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        loading = new ProgressDialog(this);

        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageEmail = "Email tidak boleh kosong";
                String massangePassowrd = "Password tidak boleh kosong";

                loading.setMessage("Loading...");
                loading.show();

                if (etEmailLogin.getText().toString().isEmpty()) {
                    loading.dismiss();
                    Toast.makeText(LoginActivity.this, messageEmail, Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                if (etPassLogin.getText().toString().isEmpty()) {
                    loading.dismiss();
                    Toast.makeText(LoginActivity.this, massangePassowrd, Toast.LENGTH_SHORT)
                            .show();
                    return;
                }


                String email = etEmailLogin.getText().toString().trim();
                String password = etPassLogin.getText().toString().trim();

                InterfaceClient interfaceClient = RetrofitConfig.createService(InterfaceClient.class);

                Call<ResponseLogin> requestLogin = interfaceClient.loginUser("user", "login", email, password);

                requestLogin.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        loading.dismiss();
                        if (response.body().getHasil().equals("success")) {
                            sharedPreferenceManager.saveBoolean(SharedPreferenceManager.SP_SIGNED, true);

                            startActivity(new Intent(LoginActivity.this, HomeFragment.class));

                            finish();

                        } else {
                            Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {

                        loading.dismiss();

                        Toast.makeText(LoginActivity.this, "Koneksi Error", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
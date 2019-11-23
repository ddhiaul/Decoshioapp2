package com.example.decocioapp.Masuk;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        context = this;
//        interfaceClient = RetrofitConfig.createService(InterfaceClient.class);
//
//        data();
//    }
//
//    private void data() {
//        etUsername = findViewById(R.id.et_username);
//        etPassword = findViewById(R.id.et_pass_reg);
//        etEmail = findViewById(R.id.et_email_reg);
//        etSebagai = findViewById(R.id.et_sebagai);
//
//        btnReg = findViewById(R.id.btn_reg);
//        btnReg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loading = ProgressDialog.show(context, null, "Wait...",
//                        true, false);
//                String username = etUsername.getText().toString().trim();
//                String password = etPassword.getText().toString().trim();
//                String email = etEmail.getText().toString().trim();
//                String sebagai = etSebagai.getText().toString().trim();
//
//               Call<ResponseRegister> request = interfaceClient
//                       .registerUser("user", "insert", username, password, email, sebagai);
//               request.enqueue(new Callback<ResponseRegister>() {
//                   @Override
//                   public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
//                       if (response.isSuccessful()){
//                           Log.i("debug", "onResponse : Insert Success");
//                           loading.dismiss();
//                           startActivity(new Intent(context, HomeCustomer.class));
//                           finish();
//                       }else {
//                           Toast.makeText(context, "Register Gagal", Toast.LENGTH_SHORT).show();
//                       }
//                   }
//
//                   @Override
//                   public void onFailure(Call<ResponseRegister> call, Throwable t)
//                       {
//                           loading.dismiss();
//                           Toast.makeText(context, "Koneksi Error", Toast.LENGTH_SHORT).show();
//                       }
//
//               });
//
//            }
//        });
//    }
}

package tech.vktl.qlsotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobParameters;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername =findViewById(R.id.edt_Username);
        edtPassword = findViewById(R.id.edt_Password);
        btnLogin = findViewById(R.id.btn_Login);

        btnLogin.setOnClickListener(this::Login);
    }
    public void Login(View view)
    {
        if(edtUsername.getText().toString().equals("Admin") && edtPassword.getText().toString().equals("123456"))
        {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Sai thông tin tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }
}
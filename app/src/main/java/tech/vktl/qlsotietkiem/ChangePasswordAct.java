package tech.vktl.qlsotietkiem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChangePasswordAct extends AppCompatActivity {

    Button mBtnChangePw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đổi mật khẩu");

        mBtnChangePw = findViewById(R.id.btnChangePw);

        mBtnChangePw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomToast.makeText(getApplicationContext(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT, CustomToast.SUCCESS).show();
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
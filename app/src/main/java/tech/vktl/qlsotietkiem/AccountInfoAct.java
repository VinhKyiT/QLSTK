package tech.vktl.qlsotietkiem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AccountInfoAct extends AppCompatActivity {

    TextView mNameTv, mPhoneTv, mAddressTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thông tin tài khoản");

        mNameTv = findViewById(R.id.nameTv);
        mPhoneTv = findViewById(R.id.phoneTv);
        mAddressTv = findViewById(R.id.addressTv);


    }
}
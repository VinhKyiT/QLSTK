package tech.vktl.qlsotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PlanCreateAct extends AppCompatActivity {

    EditText mKyHanEt, mTenEt, mTanSuatEt, mSoTienEt;
    ImageView mPlanPicIv;
    CheckBox mCbPolicy;
    Button mCreateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_create);

        mKyHanEt = findViewById(R.id.kyHanEt);
        mTenEt = findViewById(R.id.tenEt);
        mSoTienEt = findViewById(R.id.soTienEt);
        mTanSuatEt = findViewById(R.id.tanSuatEt);
        mCbPolicy = findViewById(R.id.cbPolicy);
        mCreateBtn = findViewById(R.id.createBtn);
        mPlanPicIv = findViewById(R.id.planPicIv);

        Intent intent = getIntent();
        int resId = intent.getIntExtra("resId", R.drawable.img_wedding);

        try {
            Picasso.get().load(resId).placeholder(R.drawable.loading).into(mPlanPicIv);
        }catch (Exception e){
            Picasso.get().load(R.drawable.loading).into(mPlanPicIv);
        }

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mTenEt.getText().toString()) && !TextUtils.isEmpty(mSoTienEt.getText().toString())
                && !TextUtils.isEmpty(mKyHanEt.getText().toString()) && !TextUtils.isEmpty(mTanSuatEt.getText().toString())){
                    if (mCbPolicy.isChecked()){
                        CustomToast.makeText(getApplicationContext(), "Tạo gói thành công", Toast.LENGTH_SHORT,
                                CustomToast.SUCCESS).show();
                        //startActivity(new Intent(PlanCreateAct.this, MainActivity.class));
                        onBackPressed();
                    }else {
                        CustomToast.makeText(getApplicationContext(), "Hãy đồng ý với điều khoản dịch vụ", Toast.LENGTH_SHORT,
                                CustomToast.ERROR).show();
                    }
                }else {
                    CustomToast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT,
                            CustomToast.ERROR).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
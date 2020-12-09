package tech.vktl.qlsotietkiem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import tech.vktl.qlsotietkiem.models.ModelUser;

public class AccountInfoAct extends AppCompatActivity {

    TextView mNameTv, mPhoneTv, mAddressTv;
    List<ModelUser> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Thông tin tài khoản");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mNameTv = findViewById(R.id.nameTv);
        mPhoneTv = findViewById(R.id.phoneTv);
        mAddressTv = findViewById(R.id.addressTv);

        Intent intent = getIntent();
        String idUser = intent.getStringExtra("idUser");

        loadUserInfo(idUser);
    }

    private void loadUserInfo(String idUser) {
        users = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(this));
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://www.vinhkyit.tech/api/users.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject userObj = response.getJSONObject(i);
                        String id = userObj.getString("id");
                        String user = userObj.getString("username");
                        String pass = userObj.getString("password");
                        String rights = userObj.getString("rights");
                        String name = userObj.getString("hoten");
                        String tel = userObj.getString("dienthoai");
                        String address = userObj.getString("diachi");
                        String imageProfile = userObj.getString("imageProfile");
                        double amount = userObj.getDouble("amount");
                        if (!idUser.equals("none")){
                            if (idUser.equals(id)){
                                users.add(new ModelUser(id, user, pass, rights, name, tel, address, imageProfile, amount));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (users.size() != 0){
                    mNameTv.setText("Họ và tên: "+users.get(0).getHoten());
                    mPhoneTv.setText("Điện thoại: "+users.get(0).getDienthoai());
                    mAddressTv.setText("Địa chỉ: "+users.get(0).getDiachi());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CustomToast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT, CustomToast.ERROR).show();
            }
        });
        queue.add(jsonArrayRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
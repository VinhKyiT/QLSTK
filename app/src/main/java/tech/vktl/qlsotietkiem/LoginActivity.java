package tech.vktl.qlsotietkiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.job.JobParameters;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.PromoAdapter;
import tech.vktl.qlsotietkiem.models.ModelPromo;
import tech.vktl.qlsotietkiem.models.ModelUser;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;
    final String JSON_URL = "https://www.vinhkyit.tech/api/users.php";
    List<ModelUser> users;
    boolean isSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_Username);
        edtPassword = findViewById(R.id.edt_Password);
        btnLogin = findViewById(R.id.btn_Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users = new ArrayList<>();
                String tenDn = edtUsername.getText().toString().toLowerCase().trim();
                String mk = md5(md5(edtPassword.getText().toString().trim()));

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
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
                                users.add(new ModelUser(id, user, pass, rights, name, tel, address, imageProfile));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < users.size(); i++){
                            if (tenDn.equals(users.get(i).getUsername().toLowerCase().trim())){
                                if (mk.equals(users.get(i).getPassword().trim())){
                                    isSuccess = true;
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("imageProfile", users.get(i).getImageProfile());
                                intent.putExtra("id", users.get(i).getId());
                                startActivity(intent);
                                    break;
                                }else
                                    CustomToast.makeText(LoginActivity.this, "Sai mật khẩu",
                                            CustomToast.LENGTH_SHORT, CustomToast.ERROR).show();
                            }
                            else {
                                isSuccess = false;
                            }
                        }
                        if (!isSuccess)
                            CustomToast.makeText(LoginActivity.this, "Sai thông tin đăng nhập",
                                    CustomToast.LENGTH_SHORT, CustomToast.ERROR).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CustomToast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT, CustomToast.ERROR).show();
                    }
                });
                queue.add(jsonArrayRequest);

            }
        });
    }

    public static String md5(String pass) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }
}
package tech.vktl.qlsotietkiem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

import tech.vktl.qlsotietkiem.adpaters.NotificationAdapter;
import tech.vktl.qlsotietkiem.models.ModelNotification;
import tech.vktl.qlsotietkiem.models.ModelUser;


public class ProfileFragment extends Fragment {

    TextView mNameTv, mPhoneTv;
    ImageView mAvtIv, mBtnLogout;

    List<ModelUser> users;
    String idUser;
    RelativeLayout accountInfo, changePassword;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        accountInfo = view.findViewById(R.id.accountInfo);
        changePassword = view.findViewById(R.id.changePassword);
        mNameTv = view.findViewById(R.id.nameTv);
        mPhoneTv = view.findViewById(R.id.phoneTv);
        mAvtIv = view.findViewById(R.id.avtIv);
        mBtnLogout = view.findViewById(R.id.btnLogout);

        accountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AccountInfoAct.class);
                intent.putExtra("idUser", idUser);
                startActivity(intent);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChangePasswordAct.class);
                startActivity(intent);
            }
        });

        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        idUser = mainActivity.getMyId();

        loadUserInfo(idUser);

        return view;
    }

    private void loadUserInfo(String idUser) {
        users = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
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
                    mNameTv.setText(users.get(0).getHoten());
                    mPhoneTv.setText(users.get(0).getDienthoai());
                    try {
                        Picasso.get().load(users.get(0).getImageProfile()).placeholder(R.drawable.ic_user).into(mAvtIv);
                    }catch (Exception e){
                        Picasso.get().load(R.drawable.ic_user).into(mAvtIv);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CustomToast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT, CustomToast.ERROR).show();
            }
        });
        queue.add(jsonArrayRequest);

    }
}
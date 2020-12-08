package tech.vktl.qlsotietkiem;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import tech.vktl.qlsotietkiem.adpaters.NotificationAdapter;
import tech.vktl.qlsotietkiem.adpaters.PromoAdapter;
import tech.vktl.qlsotietkiem.models.ModelNotification;

public class Noti_Chung extends Fragment {

    List<ModelNotification> notifications;
    RecyclerView notiRecv;
    NotificationAdapter notificationAdapter;
    DividerItemDecoration mDividerItemDecoration;
    final String JSON_URL = "https://www.vinhkyit.tech/api/thongbao.php";

    public Noti_Chung() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noti__chung, container, false);

        notifications = new ArrayList<>();
//        notifications.add(new ModelNotification("Thông báo 1", "Nội dung thông báo 1", "26/11/2020", false));
//        notifications.add(new ModelNotification("Thông báo 1", "Nội dung thông báo 1", "26/11/2020", false));
//        notifications.add(new ModelNotification("Thông báo 1", "Nội dung thông báo 1", "26/11/2020", false));
        extractNotifications();

        notiRecv = view.findViewById(R.id.notiRecv);

        mDividerItemDecoration = new DividerItemDecoration(notiRecv.getContext(),
                LinearLayoutManager.VERTICAL);
        notiRecv.addItemDecoration(mDividerItemDecoration);

        return view;
    }

    private void extractNotifications() {
        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++){
                    try {
                        JSONObject notificationObj = response.getJSONObject(i);
                        String title = notificationObj.getString("tieude");
                        String content = notificationObj.getString("noidung");
                        notifications.add(new ModelNotification(title, content, "06/12/2020", false));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                notiRecv.setLayoutManager(new LinearLayoutManager(getContext()));
                notificationAdapter = new NotificationAdapter(getActivity(), notifications);
                notiRecv.setAdapter(notificationAdapter);
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
package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.NotificationAdapter;
import tech.vktl.qlsotietkiem.adpaters.PromoAdapter;
import tech.vktl.qlsotietkiem.models.ModelNotification;
import tech.vktl.qlsotietkiem.models.ModelPromo;

public class PromoDetailFragment extends Fragment {
    List<ModelPromo> promos;
    RecyclerView promoRecv;
    PromoAdapter adapter;
    final String JSON_URL = "https://www.vinhkyit.tech/api/uudai.php";

    public PromoDetailFragment() {
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
        View view = inflater.inflate(R.layout.fragment_promo_detail, container, false);

        promos = new ArrayList<>();
        extractPromos();
        promoRecv = view.findViewById(R.id.rcvPromoDetail);

        return view;
    }

    private void extractPromos() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject promoObj = response.getJSONObject(i);
                        String title = promoObj.getString("tieude");
                        String content = promoObj.getString("noidung");
                        String image = promoObj.getString("hinhanh");
                        promos.add(new ModelPromo(title, content, image));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                promoRecv.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new PromoAdapter(getActivity(), promos);
                promoRecv.setAdapter(adapter);
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
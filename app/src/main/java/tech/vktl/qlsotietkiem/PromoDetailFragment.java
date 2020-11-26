package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.PromoAdapter;
import tech.vktl.qlsotietkiem.models.ModelPromo;

public class PromoDetailFragment extends Fragment {
    List<ModelPromo> promos;
    RecyclerView promoRecv;
    PromoAdapter adapter;

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
        promos.add(new ModelPromo(R.drawable.img_future, "KM1", "Khuyến mãi 1"));
        promos.add(new ModelPromo(R.drawable.img_future, "KM1", "Khuyến mãi 1"));
        promos.add(new ModelPromo(R.drawable.img_future, "KM1", "Khuyến mãi 1"));
        promos.add(new ModelPromo(R.drawable.img_future, "KM1", "Khuyến mãi 1"));
        promos.add(new ModelPromo(R.drawable.img_future, "KM1", "Khuyến mãi 1"));

        promoRecv = view.findViewById(R.id.rcvPromoDetail);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //set layout vao recyclerview
        promoRecv.setLayoutManager(linearLayoutManager);
        adapter = new PromoAdapter(getActivity(), promos);
        adapter.notifyDataSetChanged();
        String item = String.valueOf(adapter.getItemCount());
        promoRecv.setAdapter(adapter);


        return view;
    }
}
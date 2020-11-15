package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tech.vktl.qlsotietkiem.adpaters.CategoryAdapter;
import tech.vktl.qlsotietkiem.models.ModelCategory;
import tech.vktl.qlsotietkiem.models.ModelMyPlan;

public class HomeFragment extends Fragment {

    private RecyclerView mPlanRecv;
    private CategoryAdapter categoryAdapter;


    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mPlanRecv = view.findViewById(R.id.myList);
        categoryAdapter = new CategoryAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mPlanRecv.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());

        return view;
    }

    private ArrayList<ModelCategory> getListCategory() {
        ArrayList<ModelCategory> list = new ArrayList<>();
        ArrayList<ModelMyPlan> myPlans = new ArrayList<>();
        myPlans.add(new ModelMyPlan("Gói của tôi", "Ăn uống", "60"));

        return list;
    }
}
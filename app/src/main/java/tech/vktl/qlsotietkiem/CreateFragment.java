package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.PlanAdapter;
import tech.vktl.qlsotietkiem.models.ModelPlan;

public class CreateFragment extends Fragment {

    TabLayout tabLayout;
    RecyclerView recyclerView;
    PlanAdapter planAdapter, planAdapter1;

    public CreateFragment() {
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
        View view = inflater.inflate(R.layout.fragment_create, container, false);

        List<ModelPlan> mPlans = new ArrayList<>();
        mPlans.add(new ModelPlan(R.drawable.img_shopping, "Mua sắm"));
        mPlans.add(new ModelPlan(R.drawable.travelling, "Du lịch"));
        mPlans.add(new ModelPlan(R.drawable.img_drinking, "Ăn uống"));
        mPlans.add(new ModelPlan(R.drawable.img_hobbies, "Sở thích"));
        mPlans.add(new ModelPlan(R.drawable.img_vehicle, "Xe cộ"));
        mPlans.add(new ModelPlan(R.drawable.img_target, "Đơn giản là tiết kiệm"));

        List<ModelPlan> mPlans1 = new ArrayList<>();
        mPlans1.add(new ModelPlan(R.drawable.img_study, "Học tập"));
        mPlans1.add(new ModelPlan(R.drawable.img_wedding, "Đám cưới"));
        mPlans1.add(new ModelPlan(R.drawable.img_home, "Mua nhà"));
        mPlans1.add(new ModelPlan(R.drawable.img_family, "Gia đình"));
        mPlans1.add(new ModelPlan(R.drawable.img_future, "Đầu tư cho tương lai"));
        mPlans1.add(new ModelPlan(R.drawable.img_others, "Mục tiêu khác"));

        recyclerView = view.findViewById(R.id.createRecv);
        planAdapter = new PlanAdapter(getContext(), mPlans);
        planAdapter1 = new PlanAdapter(getContext(), mPlans1);

        recyclerView.setAdapter(planAdapter);

        tabLayout = view.findViewById(R.id.tabLayout_Create);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tabPos = String.valueOf(tab.getPosition());
                if (tabPos.equals("0")){
                    recyclerView.setAdapter(planAdapter);
                }else if(tabPos.equals("1")){
                    recyclerView.setAdapter(planAdapter1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

}
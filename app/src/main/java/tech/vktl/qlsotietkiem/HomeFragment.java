package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.CategoryAdapter;
import tech.vktl.qlsotietkiem.adpaters.MyPlanAdapter;
import tech.vktl.qlsotietkiem.models.ModelCategory;
import tech.vktl.qlsotietkiem.models.ModelMyPlan;
import tech.vktl.qlsotietkiem.models.ModelPlan;

public class HomeFragment extends Fragment {

    private RecyclerView mPlanRecv, mMyPlan;
    private CategoryAdapter categoryAdapter;
    private MyPlanAdapter myPlanAdapter;
    private List<ModelMyPlan> myPlans;
    private TextView myPlanCountTv, mTvSoTien;
    private ImageView mAvtIv;


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

        myPlans = new ArrayList<>();
        myPlans.add(new ModelMyPlan("Gói savy", "Ăn uống", "70"));
        myPlans.add(new ModelMyPlan("Gói savy", "Ăn uống", "60"));
        myPlans.add(new ModelMyPlan("Gói savy", "Ăn uống", "70"));
        myPlans.add(new ModelMyPlan("Gói savy", "Ăn uống", "70"));
        myPlans.add(new ModelMyPlan("Gói savy", "Ăn uống", "70"));

        mPlanRecv = view.findViewById(R.id.mPlan);
        mMyPlan = view.findViewById(R.id.myPlan);
        mAvtIv = view.findViewById(R.id.avtIv);
        myPlanCountTv = view.findViewById(R.id.myPlanCountTv);
        mTvSoTien = view.findViewById(R.id.tvSoTien);

        categoryAdapter = new CategoryAdapter(getContext());
        myPlanAdapter = new MyPlanAdapter(getContext(), myPlans);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mPlanRecv.setLayoutManager(linearLayoutManager);
        mMyPlan.setLayoutManager(linearLayoutManager1);

        categoryAdapter.setData(getListCategory());
        //myPlanAdapter.setData(myPlans);
        mPlanRecv.setAdapter(categoryAdapter);
        mMyPlan.setAdapter(myPlanAdapter);

        myPlanCountTv.setText("Tiết kiệm của tôi ("+myPlans.size()+")");

        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        String image = mainActivity.getMyImage();
        double amount = mainActivity.getAmount();
        String val = String.format("%.0f", amount);
        mTvSoTien.setText(val+" VNĐ");
        try {
            Picasso.get().load(image).placeholder(R.drawable.ic_user).into(mAvtIv);
        }catch (Exception e){
            Picasso.get().load(R.drawable.ic_user).into(mAvtIv);
        }

        return view;
    }

    private List<ModelCategory> getListCategory() {
        List<ModelCategory> listCategory = new ArrayList<>();

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

        listCategory.add(new ModelCategory("Tạo gói gửi góp", mPlans));
        listCategory.add(new ModelCategory("Tạo gói TK thời hạn", mPlans1));
        return listCategory;
    }
}
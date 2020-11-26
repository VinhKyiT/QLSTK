package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.PromoPageAdapter;
import tech.vktl.qlsotietkiem.models.ModelPromo;

public class PromoFragment extends Fragment {

    TabLayout tabLayout;


    public PromoFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_promo, container, false);

        tabLayout = view.findViewById(R.id.tabLayout_2);
        ViewPager viewPager = view.findViewById(R.id.vpgPromo);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
    public void setUpViewPager(ViewPager viewPager){
        PromoPageAdapter adapter = new PromoPageAdapter(getChildFragmentManager());

        adapter.AddFragment(new PromoDetailFragment(), "Thông tin ưu đãi");
        adapter.AddFragment(new GameFragment(), "Trò chơi");

        viewPager.setAdapter(adapter);
    }
}
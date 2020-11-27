package tech.vktl.qlsotietkiem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import tech.vktl.qlsotietkiem.adpaters.NotificationAdapter;
import tech.vktl.qlsotietkiem.adpaters.NotificationPageAdapter;
import tech.vktl.qlsotietkiem.adpaters.PromoPageAdapter;

public class NotificationFragment extends Fragment {

    TabLayout tabLayout;

    public NotificationFragment() {
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
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        tabLayout = view.findViewById(R.id.tabLayout_noti);
        ViewPager viewPager = view.findViewById(R.id.vpgNoti);
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

    private void setUpViewPager(ViewPager viewPager) {
        NotificationPageAdapter adapter = new NotificationPageAdapter(getChildFragmentManager());

        adapter.AddFragment(new Noti_Chung(), "Chung");
        adapter.AddFragment(new PromoDetailFragment(), "Ưu đãi");
        adapter.AddFragment(new Noti_QuaTang(), "Quà tặng");

        viewPager.setAdapter(adapter);
    }
}
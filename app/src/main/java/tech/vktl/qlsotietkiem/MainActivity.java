package tech.vktl.qlsotietkiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import tech.vktl.qlsotietkiem.adpaters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager containerVP;
    BottomNavigationView navigationView;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        containerVP = findViewById(R.id.containerVP);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        setUpViewPager();

        //default fragment
        actionBar.setTitle("Trang chủ");
        containerVP.setCurrentItem(0);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_home:
                    actionBar.setTitle("Trang chủ");
                    containerVP.setCurrentItem(0);
                    return true;
                case R.id.nav_promo:
                    actionBar.setTitle("Ưu đãi");
                    containerVP.setCurrentItem(1);
                    return true;
                case R.id.nav_create:
                    actionBar.setTitle("Tạo gói");
                    containerVP.setCurrentItem(2);
                    return true;
                case R.id.nav_noti:
                    actionBar.setTitle("Thông báo");
                    containerVP.setCurrentItem(3);
                    return true;
                case R.id.nav_profile:
                    actionBar.setTitle("Người dùng");
                    containerVP.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        containerVP.setAdapter(viewPagerAdapter);

        containerVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.nav_promo).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.nav_create).setChecked(true);
                        break;
                    case 3:
                        navigationView.getMenu().findItem(R.id.nav_noti).setChecked(true);
                        break;
                    case 4:
                        navigationView.getMenu().findItem(R.id.nav_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
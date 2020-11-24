package tech.vktl.qlsotietkiem.adpaters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import tech.vktl.qlsotietkiem.CreateFragment;
import tech.vktl.qlsotietkiem.HomeFragment;
import tech.vktl.qlsotietkiem.NotificationFragment;
import tech.vktl.qlsotietkiem.ProfileFragment;
import tech.vktl.qlsotietkiem.PromoFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new PromoFragment();
            case 2:
                return new CreateFragment();
            case 3:
                return new NotificationFragment();
            case 4:
                return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}

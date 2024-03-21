package com.goblinvault;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.goblinvault.Fragments.FinanceFragment;
import com.goblinvault.Fragments.HomeFragment;
import com.goblinvault.Fragments.MeFragment;
import com.goblinvault.Fragments.WalletFragment;

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new FinanceFragment();
            case 2:
                return new WalletFragment();
            case 3:
                return new MeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4; // 总共有三个界面
    }
}
package cable.social.app.adadpter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cable.social.app.fragment.MyTotalSeries;
import cable.social.app.fragment.MyChannel;
import cable.social.app.fragment.MySeries;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabsAdapter(FragmentManager fm, int NoofTabs) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MySeries mySeries = new MySeries();
                return mySeries;
            case 1:
                MyChannel myChannel = new MyChannel();
                return myChannel;
            case 2:
//                MyTotalSeries myTotalSeries = new MyTotalSeries();
//                return myTotalSeries;
            default:
                return null;
        }
    }
}
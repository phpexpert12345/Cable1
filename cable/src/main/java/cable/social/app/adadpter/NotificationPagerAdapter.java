package cable.social.app.adadpter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import cable.social.app.Interface.FreindRequestInterface;
import cable.social.app.fragment.FriendRequestFragment;
import cable.social.app.fragment.NotificationFragment;

public class NotificationPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

//    FreindRequestInterface freindRequestInterface;

    public NotificationPagerAdapter(FragmentManager fm, Context context) {
        super(fm);

        mContext = context;
//        this.freindRequestInterface = freindRequestInterface;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new NotificationFragment(mContext);
        }
        else if (position == 1)
        {
            fragment = new FriendRequestFragment(mContext);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Notification";
        }
        else if (position == 1)
        {
            title = "Friend Requests";
        }

        return title;
    }
}

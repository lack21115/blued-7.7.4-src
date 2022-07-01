package com.soft.blued.ui.find.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.soft.blued.ui.find.fragment.NearbyFeedFragment;
import com.soft.blued.ui.find.fragment.NearbyPeopleFragment;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import java.util.List;

public class NearbyHomePagerAdapter extends FragmentPagerAdapter {
  private List<HomeTopTabModel> a;
  
  public NearbyHomePagerAdapter(FragmentManager paramFragmentManager, List<HomeTopTabModel> paramList) {
    super(paramFragmentManager);
    this.a = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt) {
    paramInt = ((HomeTopTabModel)this.a.get(paramInt)).tab_id;
    return (Fragment)((paramInt != 1) ? ((paramInt != 2) ? new NearbyPeopleFragment() : new NearbyFeedFragment()) : new NearbyPeopleFragment());
  }
  
  public CharSequence getPageTitle(int paramInt) {
    return ((HomeTopTabModel)this.a.get(paramInt)).tab_title;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\NearbyHomePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.discover.model;

import android.content.Context;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.ui.discover.fragment.RecommendFeedFragment;
import com.soft.blued.ui.feed.fragment.AttentionFeedFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class DiscoveryPageTabModel {
  private static List<DiscoveryPageTabModel> tabs;
  
  public int tabid;
  
  public String title;
  
  public DiscoveryPageTabModel(int paramInt, Context paramContext) {
    this.tabid = paramInt;
    if (paramInt != 2) {
      if (paramInt != 3)
        return; 
      this.title = paramContext.getResources().getString(2131756390);
      return;
    } 
    this.title = paramContext.getResources().getString(2131758532);
  }
  
  public static void clearTabs() {
    tabs = null;
  }
  
  public static List<DiscoveryPageTabModel> getDiscoveryTabs(Context paramContext) {
    List<DiscoveryPageTabModel> list = tabs;
    if (list != null && list.size() > 0)
      return tabs; 
    tabs = new ArrayList<DiscoveryPageTabModel>();
    tabs.add(new DiscoveryPageTabModel(3, paramContext));
    tabs.add(new DiscoveryPageTabModel(2, paramContext));
    return tabs;
  }
  
  public static int getTabPosition(int paramInt) {
    if (tabs != null)
      for (int i = 0; i < tabs.size(); i++) {
        if (((DiscoveryPageTabModel)tabs.get(i)).tabid == paramInt)
          return i; 
      }  
    return -1;
  }
  
  public BaseFragment getFragment() {
    return (BaseFragment)((this.tabid != 3) ? new RecommendFeedFragment() : new AttentionFeedFragment());
  }
  
  public static interface DISCOVERY_TAB_ID {
    public static final int ATTENTION_FEED = 3;
    
    public static final int SQUARE = 2;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DiscoveryTabDef {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\model\DiscoveryPageTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
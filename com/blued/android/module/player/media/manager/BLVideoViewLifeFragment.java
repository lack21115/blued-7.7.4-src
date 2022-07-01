package com.blued.android.module.player.media.manager;

import android.app.Activity;
import android.app.Fragment;
import com.blued.android.core.utils.Log;

public class BLVideoViewLifeFragment extends Fragment {
  public static final String a = BLVideoViewLifeFragment.class.getSimpleName();
  
  private BLVideoViewCache b;
  
  public static void a(BLVideoViewCache paramBLVideoViewCache, Activity paramActivity) {
    if (paramActivity == null || paramActivity.getFragmentManager() == null) {
      Log.c(a, "activity is null");
      return;
    } 
    try {
      Log.c(a, "PLVideoViewLifeFragment new instance");
      BLVideoViewLifeFragment bLVideoViewLifeFragment = new BLVideoViewLifeFragment();
      bLVideoViewLifeFragment.b = paramBLVideoViewCache;
      paramActivity.getFragmentManager().beginTransaction().add(bLVideoViewLifeFragment, a).commit();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void onDestroy() {
    Log.c(a, "onDestroy");
    BLVideoViewCache bLVideoViewCache = this.b;
    if (bLVideoViewCache != null)
      bLVideoViewCache.a(); 
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\manager\BLVideoViewLifeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
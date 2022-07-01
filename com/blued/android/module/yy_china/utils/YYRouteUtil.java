package com.blued.android.module.yy_china.utils;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment;

public class YYRouteUtil {
  public static boolean a = false;
  
  public static void a(BaseFragment paramBaseFragment, Bundle paramBundle, int paramInt) {
    if (a)
      return; 
    LiveSetPayPwdFragment liveSetPayPwdFragment = new LiveSetPayPwdFragment();
    liveSetPayPwdFragment.setTargetFragment((Fragment)paramBaseFragment, paramInt);
    liveSetPayPwdFragment.setArguments(paramBundle);
    liveSetPayPwdFragment.setCancelable(true);
    liveSetPayPwdFragment.show(paramBaseFragment.getFragmentManager(), liveSetPayPwdFragment.d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\YYRouteUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
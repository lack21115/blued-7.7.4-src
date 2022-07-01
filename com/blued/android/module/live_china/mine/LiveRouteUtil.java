package com.blued.android.module.live_china.mine;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment;
import com.blued.android.module.live_china.fragment.LiveChargeDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestErrorDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestGuideDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestInterruptDlgFragment;
import com.blued.android.module.live_china.fragment.LiveHostErrorFragment;
import com.blued.android.module.live_china.fragment.LiveHostExitDlgFragment;
import com.blued.android.module.live_china.fragment.LiveHostGuideDlgFragment;
import com.blued.android.module.live_china.manager.LiveUploadTimerManager;

public class LiveRouteUtil {
  public static boolean a = false;
  
  public static void a(Fragment paramFragment, Bundle paramBundle, int paramInt) {
    if (a)
      return; 
    LiveSetPayPwdFragment liveSetPayPwdFragment = new LiveSetPayPwdFragment();
    liveSetPayPwdFragment.setTargetFragment(paramFragment, paramInt);
    liveSetPayPwdFragment.setArguments(paramBundle);
    liveSetPayPwdFragment.setCancelable(true);
    liveSetPayPwdFragment.show(paramFragment.getFragmentManager(), liveSetPayPwdFragment.d());
  }
  
  public static void a(BaseFragment paramBaseFragment) {
    LiveGuestFinishDlgFragment liveGuestFinishDlgFragment = new LiveGuestFinishDlgFragment();
    liveGuestFinishDlgFragment.setTargetFragment((Fragment)paramBaseFragment, 100010);
    liveGuestFinishDlgFragment.show(paramBaseFragment.getFragmentManager(), liveGuestFinishDlgFragment.d());
    LiveUploadTimerManager.b();
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt) {
    LiveGuestGuideDlgFragment liveGuestGuideDlgFragment = new LiveGuestGuideDlgFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("type", paramInt);
    liveGuestGuideDlgFragment.setArguments(bundle);
    liveGuestGuideDlgFragment.setTargetFragment((Fragment)paramBaseFragment, 100013);
    liveGuestGuideDlgFragment.show(paramBaseFragment.getFragmentManager(), liveGuestGuideDlgFragment.d());
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2) {
    if (paramBaseFragment != null && paramBaseFragment.w_() != null && paramBaseFragment.w_().isActive()) {
      if (paramBaseFragment.getFragmentManager() == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("from: ");
      stringBuilder.append(paramBaseFragment.aG_());
      LogUtils.c(stringBuilder.toString());
      LiveChargeDlgFragment liveChargeDlgFragment = new LiveChargeDlgFragment();
      Bundle bundle = new Bundle();
      bundle.putInt("from", paramInt1);
      liveChargeDlgFragment.setTargetFragment((Fragment)paramBaseFragment, paramInt2);
      liveChargeDlgFragment.setArguments(bundle);
      liveChargeDlgFragment.setCancelable(false);
      liveChargeDlgFragment.show(paramBaseFragment.getFragmentManager(), liveChargeDlgFragment.d());
    } 
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt, boolean paramBoolean) {
    LiveHostGuideDlgFragment liveHostGuideDlgFragment = new LiveHostGuideDlgFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("type", paramInt);
    bundle.putBoolean("is_make_lover", paramBoolean);
    liveHostGuideDlgFragment.setArguments(bundle);
    liveHostGuideDlgFragment.setTargetFragment((Fragment)paramBaseFragment, 100013);
    liveHostGuideDlgFragment.show(paramBaseFragment.getFragmentManager(), liveHostGuideDlgFragment.d());
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString) {
    LiveGuestErrorDlgFragment liveGuestErrorDlgFragment = new LiveGuestErrorDlgFragment();
    Bundle bundle = new Bundle();
    bundle.putString("msg_text", paramString);
    liveGuestErrorDlgFragment.setArguments(bundle);
    liveGuestErrorDlgFragment.setTargetFragment((Fragment)paramBaseFragment, 100011);
    liveGuestErrorDlgFragment.show(paramBaseFragment.getFragmentManager(), liveGuestErrorDlgFragment.d());
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString1, String paramString2) {
    LiveGuestInterruptDlgFragment liveGuestInterruptDlgFragment = new LiveGuestInterruptDlgFragment();
    Bundle bundle = new Bundle();
    bundle.putString("msg_text", paramString2);
    bundle.putString("msg_title", paramString1);
    liveGuestInterruptDlgFragment.setArguments(bundle);
    liveGuestInterruptDlgFragment.setTargetFragment((Fragment)paramBaseFragment, 100012);
    liveGuestInterruptDlgFragment.show(paramBaseFragment.getFragmentManager(), liveGuestInterruptDlgFragment.d());
  }
  
  public static void b(BaseFragment paramBaseFragment) {
    LiveHostExitDlgFragment liveHostExitDlgFragment = new LiveHostExitDlgFragment();
    liveHostExitDlgFragment.setTargetFragment((Fragment)paramBaseFragment, 100014);
    liveHostExitDlgFragment.show(paramBaseFragment.getFragmentManager(), liveHostExitDlgFragment.d());
  }
  
  public static void c(BaseFragment paramBaseFragment) {
    LiveHostErrorFragment liveHostErrorFragment = new LiveHostErrorFragment();
    liveHostErrorFragment.setTargetFragment((Fragment)paramBaseFragment, 100015);
    liveHostErrorFragment.show(paramBaseFragment.getFragmentManager(), liveHostErrorFragment.d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\mine\LiveRouteUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
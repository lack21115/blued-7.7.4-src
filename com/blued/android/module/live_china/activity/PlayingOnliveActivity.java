package com.blued.android.module.live_china.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.live_interface.IDispatchTouchEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayingOnliveActivity extends TerminalActivity {
  private List<IDispatchTouchEvent> d = new ArrayList<IDispatchTouchEvent>();
  
  public static TerminalActivity.WrapIntent a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new TerminalActivity.WrapIntent(paramContext, paramClass, paramBundle, PlayingOnliveActivity.class);
  }
  
  public static void b(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    a(paramContext, paramClass, paramBundle).b();
  }
  
  public void a(IDispatchTouchEvent paramIDispatchTouchEvent) {
    this.d.add(paramIDispatchTouchEvent);
  }
  
  public void b(IDispatchTouchEvent paramIDispatchTouchEvent) {
    this.d.remove(paramIDispatchTouchEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    List<IDispatchTouchEvent> list = this.d;
    if (list != null) {
      Iterator<IDispatchTouchEvent> iterator = list.iterator();
      while (iterator.hasNext())
        ((IDispatchTouchEvent)iterator.next()).a(paramMotionEvent); 
    } 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onBackPressed() {
    boolean bool2;
    int i = getSupportFragmentManager().getFragments().size() - 1;
    boolean bool1 = false;
    while (true) {
      bool2 = bool1;
      if (i >= 0) {
        Fragment fragment = getSupportFragmentManager().getFragments().get(i);
        LogUtils.c(fragment.getClass().getSimpleName());
        if (fragment instanceof BaseFragment) {
          bool1 = ((BaseFragment)fragment).V_();
        } else if (fragment instanceof BaseDialogFragment) {
          bool1 = ((BaseDialogFragment)fragment).V_();
        } 
        if (bool1) {
          bool2 = bool1;
          break;
        } 
        i--;
        continue;
      } 
      break;
    } 
    if (!bool2)
      super.onBackPressed(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\activity\PlayingOnliveActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
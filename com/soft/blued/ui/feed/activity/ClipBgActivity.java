package com.soft.blued.ui.feed.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.ui.feed.manager.IDispatchTouchEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClipBgActivity extends TerminalActivity {
  private List<IDispatchTouchEvent> d = new ArrayList<IDispatchTouchEvent>();
  
  public static TerminalActivity.WrapIntent a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new TerminalActivity.WrapIntent(paramContext, paramClass, paramBundle, ClipBgActivity.class);
  }
  
  public static void b(Fragment paramFragment, Class<? extends Fragment> paramClass, Bundle paramBundle, int paramInt) {
    a((Context)paramFragment.getActivity(), paramClass, paramBundle).a(paramInt, paramFragment);
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\activity\ClipBgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
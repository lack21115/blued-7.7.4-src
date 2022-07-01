package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class LiveListHotFragment_ViewBinding implements Unbinder {
  private LiveListHotFragment b;
  
  public LiveListHotFragment_ViewBinding(LiveListHotFragment paramLiveListHotFragment, View paramView) {
    this.b = paramLiveListHotFragment;
    paramLiveListHotFragment.grid_view = (RecyclerView)Utils.a(paramView, 2131297289, "field 'grid_view'", RecyclerView.class);
    paramLiveListHotFragment.refresh_view = (SmartRefreshLayout)Utils.a(paramView, 2131299618, "field 'refresh_view'", SmartRefreshLayout.class);
    paramLiveListHotFragment.ll_default_empty = (LinearLayout)Utils.a(paramView, 2131298771, "field 'll_default_empty'", LinearLayout.class);
  }
  
  public void unbind() {
    LiveListHotFragment liveListHotFragment = this.b;
    if (liveListHotFragment != null) {
      this.b = null;
      liveListHotFragment.grid_view = null;
      liveListHotFragment.refresh_view = null;
      liveListHotFragment.ll_default_empty = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListHotFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
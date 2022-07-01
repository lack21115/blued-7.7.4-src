package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class LiveJoinFansFragment_ViewBinding implements Unbinder {
  private LiveJoinFansFragment b;
  
  public LiveJoinFansFragment_ViewBinding(LiveJoinFansFragment paramLiveJoinFansFragment, View paramView) {
    this.b = paramLiveJoinFansFragment;
    paramLiveJoinFansFragment.fl_main = Utils.a(paramView, 2131297133, "field 'fl_main'");
    paramLiveJoinFansFragment.top_title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'top_title'", CommonTopTitleNoTrans.class);
    paramLiveJoinFansFragment.refresh_view = (SmartRefreshLayout)Utils.a(paramView, 2131299618, "field 'refresh_view'", SmartRefreshLayout.class);
    paramLiveJoinFansFragment.recycle_view = (RecyclerView)Utils.a(paramView, 2131299598, "field 'recycle_view'", RecyclerView.class);
    paramLiveJoinFansFragment.ll_no_fans = Utils.a(paramView, 2131298983, "field 'll_no_fans'");
    paramLiveJoinFansFragment.tv_no_data = (TextView)Utils.a(paramView, 2131301108, "field 'tv_no_data'", TextView.class);
    paramLiveJoinFansFragment.tv_re_title = Utils.a(paramView, 2131301225, "field 'tv_re_title'");
    paramLiveJoinFansFragment.recycle_recommend = (RecyclerView)Utils.a(paramView, 2131299597, "field 'recycle_recommend'", RecyclerView.class);
    paramLiveJoinFansFragment.tv_fans_qa = (TextView)Utils.a(paramView, 2131300751, "field 'tv_fans_qa'", TextView.class);
  }
  
  public void unbind() {
    LiveJoinFansFragment liveJoinFansFragment = this.b;
    if (liveJoinFansFragment != null) {
      this.b = null;
      liveJoinFansFragment.fl_main = null;
      liveJoinFansFragment.top_title = null;
      liveJoinFansFragment.refresh_view = null;
      liveJoinFansFragment.recycle_view = null;
      liveJoinFansFragment.ll_no_fans = null;
      liveJoinFansFragment.tv_no_data = null;
      liveJoinFansFragment.tv_re_title = null;
      liveJoinFansFragment.recycle_recommend = null;
      liveJoinFansFragment.tv_fans_qa = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveJoinFansFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
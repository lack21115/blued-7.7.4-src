package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class LiveListFollowFragmentNew_ViewBinding implements Unbinder {
  private LiveListFollowFragmentNew b;
  
  public LiveListFollowFragmentNew_ViewBinding(LiveListFollowFragmentNew paramLiveListFollowFragmentNew, View paramView) {
    this.b = paramLiveListFollowFragmentNew;
    paramLiveListFollowFragmentNew.ivIcon = (ImageView)Utils.a(paramView, 2131297804, "field 'ivIcon'", ImageView.class);
    paramLiveListFollowFragmentNew.tvHint = (TextView)Utils.a(paramView, 2131300890, "field 'tvHint'", TextView.class);
    paramLiveListFollowFragmentNew.ivClose = (ImageView)Utils.a(paramView, 2131297729, "field 'ivClose'", ImageView.class);
    paramLiveListFollowFragmentNew.llNoInternet = (NoDataAndLoadFailView)Utils.a(paramView, 2131298984, "field 'llNoInternet'", NoDataAndLoadFailView.class);
    paramLiveListFollowFragmentNew.liveRecommendChange = (TextView)Utils.a(paramView, 2131298571, "field 'liveRecommendChange'", TextView.class);
    paramLiveListFollowFragmentNew.liveRecommendTop = (LinearLayout)Utils.a(paramView, 2131298574, "field 'liveRecommendTop'", LinearLayout.class);
    paramLiveListFollowFragmentNew.mRecyclerView = (RecyclerView)Utils.a(paramView, 2131299605, "field 'mRecyclerView'", RecyclerView.class);
    paramLiveListFollowFragmentNew.liveRecommendLayout = (LinearLayout)Utils.a(paramView, 2131298573, "field 'liveRecommendLayout'", LinearLayout.class);
    paramLiveListFollowFragmentNew.msg_toast = Utils.a(paramView, 2131299301, "field 'msg_toast'");
    paramLiveListFollowFragmentNew.refreshFollowList = (SmartRefreshLayout)Utils.a(paramView, 2131299614, "field 'refreshFollowList'", SmartRefreshLayout.class);
    paramLiveListFollowFragmentNew.refreshNewUserList = (SmartRefreshLayout)Utils.a(paramView, 2131299617, "field 'refreshNewUserList'", SmartRefreshLayout.class);
    paramLiveListFollowFragmentNew.rvFollowList = (RecyclerView)Utils.a(paramView, 2131299772, "field 'rvFollowList'", RecyclerView.class);
    paramLiveListFollowFragmentNew.live_no_follow_banner = Utils.a(paramView, 2131298477, "field 'live_no_follow_banner'");
  }
  
  public void unbind() {
    LiveListFollowFragmentNew liveListFollowFragmentNew = this.b;
    if (liveListFollowFragmentNew != null) {
      this.b = null;
      liveListFollowFragmentNew.ivIcon = null;
      liveListFollowFragmentNew.tvHint = null;
      liveListFollowFragmentNew.ivClose = null;
      liveListFollowFragmentNew.llNoInternet = null;
      liveListFollowFragmentNew.liveRecommendChange = null;
      liveListFollowFragmentNew.liveRecommendTop = null;
      liveListFollowFragmentNew.mRecyclerView = null;
      liveListFollowFragmentNew.liveRecommendLayout = null;
      liveListFollowFragmentNew.msg_toast = null;
      liveListFollowFragmentNew.refreshFollowList = null;
      liveListFollowFragmentNew.refreshNewUserList = null;
      liveListFollowFragmentNew.rvFollowList = null;
      liveListFollowFragmentNew.live_no_follow_banner = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListFollowFragmentNew_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
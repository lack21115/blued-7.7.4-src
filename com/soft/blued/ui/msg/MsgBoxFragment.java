package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.ui.msg.adapter.ChatFriendListAdapter;
import com.soft.blued.ui.msg.contract.IMsgView;
import com.soft.blued.ui.msg.presenter.MsgBoxPresent;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

public class MsgBoxFragment extends MvpFragment<MsgBoxPresent> implements View.OnClickListener, IMsgView {
  private ListView d;
  
  private View e;
  
  private Unbinder f;
  
  private HeaderHolder g;
  
  private ChatFriendListAdapter h;
  
  @BindView(2131299395)
  public NoDataAndLoadFailView nodataview;
  
  @BindView(2131297226)
  public RenrenPullToRefreshListView pullRefresh;
  
  @BindView(2131300300)
  public CommonTopTitleNoTrans title;
  
  private void k() {
    this.pullRefresh.setRefreshEnabled(false);
    this.pullRefresh.p();
    this.d = (ListView)this.pullRefresh.getRefreshableView();
    this.e = View.inflate((Context)getActivity(), 2131493771, null);
    this.d.addHeaderView(this.e);
    this.g = new HeaderHolder(this);
    this.f = ButterKnife.a(this.g, this.e);
    this.nodataview.setNoDataImg(2131233429);
    this.nodataview.setNoDataStr(2131757944);
    this.g.iv_close.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            BluedPreferences.cb();
            (MsgBoxFragment.a(this.a)).rl_hint.setVisibility(8);
            (MsgBoxFragment.a(this.a)).view_line.setVisibility(8);
          }
        });
    if (!BluedPreferences.cc()) {
      this.g.rl_hint.setVisibility(0);
      this.g.view_line.setVisibility(0);
      this.g.iv_close.setOnClickListener(this);
    } 
    this.h = new ChatFriendListAdapter((IRequestHost)w_(), this);
    this.d.setAdapter((ListAdapter)this.h);
    this.d.setOnItemClickListener(((MsgBoxPresent)s()).p());
    this.d.setOnItemLongClickListener(((MsgBoxPresent)s()).o());
    LiveEventBus.get("refresh_session_list", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            ((MsgBoxPresent)this.a.s()).q();
          }
        });
  }
  
  private void l() {
    this.title.setCenterText(getString(2131758024));
    this.title.setCenterTextColor(2131100838);
    this.title.a();
    this.title.setLeftImg(2131232743);
    this.title.setLeftClickListener(this);
    this.title.e();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    l();
    k();
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramString.equals("session_list") && paramList != null)
      MvpUtils.a(paramList, SessionModel.class, new MvpUtils.DataListHandler<SessionModel>(this) {
            public void a() {
              this.a.nodataview.setVisibility(0);
              this.a.nodataview.a();
              MsgBoxFragment.b(this.a).a(new ArrayList(), false);
              MsgBoxFragment.b(this.a).notifyDataSetChanged();
            }
            
            public void a(List<SessionModel> param1List) {
              this.a.nodataview.setVisibility(8);
              MsgBoxFragment.b(this.a).a(param1List, false);
              MsgBoxFragment.b(this.a).notifyDataSetChanged();
            }
          }); 
  }
  
  public void aL_() {
    super.aL_();
    this.d = null;
    Unbinder unbinder = this.f;
    if (unbinder != null)
      unbinder.unbind(); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131297729)
        return; 
      this.g.rl_hint.setVisibility(8);
      this.g.view_line.setVisibility(8);
      BluedPreferences.cb();
      return;
    } 
    getActivity().finish();
  }
  
  public void onStart() {
    super.onStart();
    ((MsgBoxPresent)s()).m();
  }
  
  public void onStop() {
    super.onStop();
    ((MsgBoxPresent)s()).n();
  }
  
  public int p() {
    return 2131493233;
  }
  
  public class HeaderHolder {
    @BindView(2131297729)
    public ImageView iv_close;
    
    @BindView(2131299711)
    public RelativeLayout rl_hint;
    
    @BindView(2131301313)
    public TextView secretView;
    
    @BindView(2131301657)
    public View view_line;
    
    public HeaderHolder(MsgBoxFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgBoxFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
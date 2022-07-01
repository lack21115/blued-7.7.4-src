package com.soft.blued.ui.notify.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.notify.adapter.MsgAttentionNotifyListAdapter;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.ui.notify.presenter.AttentionNotifyPresenter;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class MsgAttentionNotifyFragment extends MvpFragment<AttentionNotifyPresenter> implements View.OnClickListener {
  private String d = "MsgAttentionNotifyFragment";
  
  private MsgAttentionNotifyListAdapter e;
  
  private Dialog f;
  
  @BindView(2131298988)
  NoDataAndLoadFailView llNodataChats;
  
  @BindView(2131299400)
  ListView lv_friend;
  
  @BindView(2131299268)
  SmartRefreshLayout msgFrientPullrefresh;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  private void E() {
    this.e = new MsgAttentionNotifyListAdapter((IRequestHost)w_(), getContext());
    this.lv_friend.setAdapter((ListAdapter)this.e);
    this.msgFrientPullrefresh.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((AttentionNotifyPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((AttentionNotifyPresenter)this.a.s()).e();
          }
        });
  }
  
  private void m() {
    if (this.e.a().isEmpty()) {
      this.llNodataChats.a();
      return;
    } 
    this.llNodataChats.c();
  }
  
  private void n() {
    this.topTitle.setCenterText(getString(2131757980));
    this.topTitle.setRightImg(2131232747);
    this.topTitle.setLeftClickListener(this);
    this.topTitle.setRightClickListener(this);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    n();
    E();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b != 0) {
      if (b == 1)
        this.msgFrientPullrefresh.h(); 
    } else {
      this.msgFrientPullrefresh.g();
    } 
    m();
    FindHttpUtils.a(null, "followers", String.valueOf(this.e.b()), (IRequestHost)w_());
  }
  
  public void a(List<FeedNotice> paramList) {
    this.llNodataChats.c();
    this.e.a(paramList, ((AttentionNotifyPresenter)s()).h);
  }
  
  public void b(String paramString) {
    super.b(paramString);
    this.f = DialogUtils.a(getContext());
    this.f.show();
  }
  
  public void k() {
    Dialog dialog = this.f;
    if (dialog != null)
      dialog.cancel(); 
    AppMethods.d(2131756206);
    this.e.c();
    this.llNodataChats.a();
  }
  
  public void l() {
    this.llNodataChats.b();
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      CommonAlertDialog.a(getContext(), ((AttentionNotifyPresenter)s()).a(2131758303), ((AttentionNotifyPresenter)s()).a(2131755476), ((AttentionNotifyPresenter)s()).a(2131756086), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (MsgAttentionNotifyFragment.a(this.a) != null)
                MsgAttentionNotifyFragment.a(this.a).show(); 
              ((AttentionNotifyPresenter)this.a.s()).a(MsgAttentionNotifyFragment.b(this.a).b());
            }
          },  ((AttentionNotifyPresenter)s()).a(2131756057), null, null);
      return;
    } 
    getActivity().finish();
  }
  
  public int p() {
    return 2131493232;
  }
  
  public void x() {
    super.x();
    this.msgFrientPullrefresh.b(true);
  }
  
  public void y() {
    super.y();
    this.msgFrientPullrefresh.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\MsgAttentionNotifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
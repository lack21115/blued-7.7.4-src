package com.soft.blued.ui.msg_group.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.msg_group.adapter.GroupNoticeAdapter;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import com.soft.blued.ui.msg_group.presenter.GroupNoticePresenter;
import com.soft.blued.utils.RecyclerViewAnimUtil;
import java.util.List;

public class GroupNoticeFragment extends MvpFragment<GroupNoticePresenter> {
  private GroupNoticeAdapter d;
  
  @BindView(2131299385)
  NoDataAndLoadFailView noDataView;
  
  @BindView(2131299400)
  RecyclerView notice_list;
  
  @BindView(2131299616)
  SmartRefreshLayout refresh_layout;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.refresh_layout.c(true);
    this.refresh_layout.b(false);
    this.refresh_layout.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((GroupNoticePresenter)this.a.s()).e();
          }
        });
    RecyclerViewAnimUtil.a(this.notice_list);
    this.notice_list.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.d = new GroupNoticeAdapter((IRequestHost)w_());
    this.noDataView.c();
    this.noDataView.setNoDataImg(2131232632);
    this.noDataView.setNoDataStr(2131758227);
    this.d.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.d.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((GroupNoticePresenter)this.a.s()).f();
          }
        },  this.notice_list);
    this.notice_list.setAdapter((RecyclerView.Adapter)this.d);
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.title.setCenterText(getString(2131756749));
    this.title.setRightImg(2131232605);
    this.title.getRightImg().setVisibility(8);
    this.title.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.refresh_layout.g();
    this.d.l();
    if (!paramBoolean && ((GroupNoticePresenter)s()).h != 1)
      this.d.m(); 
    if (this.d.n().size() <= 0) {
      if (paramBoolean) {
        this.noDataView.a();
        return;
      } 
      this.noDataView.b();
      return;
    } 
    this.noDataView.c();
  }
  
  public void a(List<GroupNoticeModel> paramList) {
    this.d.c(paramList);
  }
  
  public int p() {
    return 2131493058;
  }
  
  public void x() {
    super.x();
    this.d.c(true);
  }
  
  public void y() {
    super.y();
    this.d.k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupNoticeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
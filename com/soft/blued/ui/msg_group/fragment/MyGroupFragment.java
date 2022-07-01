package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.msg_group.adapter.MyGroupAdapter;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.presenter.MyGroupPresenter;
import java.util.ArrayList;
import java.util.List;

public class MyGroupFragment extends MvpFragment<MyGroupPresenter> {
  private MyGroupAdapter d;
  
  @BindView(2131297296)
  RecyclerView group_list;
  
  @BindView(2131299385)
  NoDataAndLoadFailView noDataView;
  
  @BindView(2131299616)
  SmartRefreshLayout refresh_layout;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  private void k() {
    LiveEventBus.get("exit_group", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            this.a.u();
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.title.setCenterText(getString(2131758166));
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.refresh_layout.c(true);
    this.refresh_layout.b(false);
    this.refresh_layout.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            this.a.u();
          }
        });
    this.d = new MyGroupAdapter((IRequestHost)w_());
    this.group_list.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.group_list.setAdapter((RecyclerView.Adapter)this.d);
    this.noDataView.c();
    this.noDataView.setNoDataImg(2131232633);
    this.noDataView.setNoDataStr(2131758232);
    this.d.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.d.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            GroupInfoModel groupInfoModel = param1BaseQuickAdapter.n().get(param1Int);
            Context context = this.a.getContext();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(groupInfoModel.group_id);
            stringBuilder.append("");
            GroupInfoFragment.a(context, stringBuilder.toString(), groupInfoModel, SocialNetWorkProtos.SourceType.MYGROUP);
          }
        });
    this.d.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((MyGroupPresenter)this.a.s()).f();
          }
        },  this.group_list);
    k();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.refresh_layout.g();
    this.d.l();
    if (!paramBoolean && ((MyGroupPresenter)s()).h != 1)
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
  
  public void a(List<GroupInfoModel> paramList) {
    ArrayList<GroupInfoModel> arrayList = new ArrayList();
    arrayList.addAll(paramList);
    if (((MyGroupPresenter)s()).h == 1) {
      int m;
      int n;
      int i = 0;
      int k = -1;
      int j = -1;
      while (true) {
        m = k;
        n = j;
        if (i < arrayList.size()) {
          m = k;
          if (((GroupInfoModel)arrayList.get(i)).group_role == 1) {
            m = k;
            if (k == -1)
              m = i; 
          } 
          n = j;
          if (((GroupInfoModel)arrayList.get(i)).group_role != 1) {
            n = j;
            if (j == -1)
              n = i; 
          } 
          if (n != -1)
            break; 
          i++;
          k = m;
          j = n;
          continue;
        } 
        break;
      } 
      i = n;
      if (m != -1) {
        GroupInfoModel groupInfoModel = new GroupInfoModel();
        groupInfoModel.itemType = 1;
        arrayList.add(m, groupInfoModel);
        i = n;
        if (n != -1)
          i = n + 1; 
      } 
      if (i != -1) {
        GroupInfoModel groupInfoModel = new GroupInfoModel();
        groupInfoModel.itemType = 2;
        groupInfoModel.max_join = ((MyGroupPresenter)s()).j;
        arrayList.add(i, groupInfoModel);
      } 
    } 
    this.d.c(arrayList);
  }
  
  public int p() {
    return 2131493062;
  }
  
  public void x() {
    super.x();
    this.d.c(true);
  }
  
  public void y() {
    super.y();
    this.d.b(true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\MyGroupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
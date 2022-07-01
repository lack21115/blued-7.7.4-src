package com.soft.blued.ui.msg_group.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.msg_group.adapter.SearchMemberAdapter;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter;
import com.soft.blued.user.UserInfo;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class SearchMemberFragment extends MvpFragment<GroupMemberPresenter> implements BaseQuickAdapter.OnItemClickListener {
  private SearchMemberAdapter d;
  
  private SearchMemberAdapter e;
  
  private String f;
  
  private int g = 0;
  
  @BindView(2131299385)
  NoDataAndLoadFailView noDataView;
  
  @BindView(2131299616)
  SmartRefreshLayout refresh_layout;
  
  @BindView(2131299869)
  RecyclerView search_list;
  
  @BindView(2131299874)
  SearchView search_view;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131301578)
  RecyclerView user_list;
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("group_id", paramString);
    bundle.putInt("page_type", paramInt);
    TerminalActivity.d(paramContext, SearchMemberFragment.class, bundle);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putString("group_id", paramString);
    bundle.putInt("page_type", paramInt1);
    bundle.putInt("group_role", paramInt2);
    TerminalActivity.d(paramContext, SearchMemberFragment.class, bundle);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3) {
    Bundle bundle = new Bundle();
    bundle.putString("group_id", paramString);
    bundle.putInt("page_type", paramInt1);
    bundle.putInt("group_role", paramInt2);
    TerminalActivity.a(paramContext, SearchMemberFragment.class, bundle, paramInt3);
  }
  
  private List<GroupMemberModel> c(List<GroupMemberModel> paramList) {
    int i = this.g;
    byte b = 0;
    if (i == 0) {
      while (paramList.size() > 0 && ((GroupMemberModel)paramList.get(0)).group_role != 3)
        paramList.remove(0); 
    } else {
      int j = b;
      if (1 != i)
        if (2 == i) {
          j = b;
        } else {
          return paramList;
        }  
      while (j < paramList.size()) {
        if (((GroupMemberModel)paramList.get(j)).uid.equals((UserInfo.a().i()).uid)) {
          paramList.remove(j);
          return paramList;
        } 
        j++;
      } 
    } 
    return paramList;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (getArguments() != null) {
      this.g = getArguments().getInt("page_type");
      int i = this.g;
      if (i != 0) {
        if (i != 1) {
          if (i == 2)
            this.title.setCenterText(getString(2131756792)); 
        } else {
          this.title.setCenterText(getString(2131756640));
        } 
      } else {
        this.title.setCenterText(getString(2131756631));
      } 
    } 
    this.title.getLeftImg().setVisibility(8);
    this.title.setLeftText(getResources().getString(2131755726));
    this.title.getLeftTextView().setTextColor(getResources().getColor(2131100845));
    this.title.getLeftTextView().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.noDataView.c();
    this.noDataView.setNoDataImg(2131232633);
    this.noDataView.setNoDataStr(2131758232);
    this.search_list.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.user_list.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.d = new SearchMemberAdapter((IRequestHost)w_());
    this.e = new SearchMemberAdapter((IRequestHost)w_());
    if (this.g == 1 && (((GroupMemberPresenter)s()).m == 1 || ((GroupMemberPresenter)s()).m == 2)) {
      View view = View.inflate(getContext(), 2131493399, null);
      view.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              GroupMemberModel groupMemberModel = new GroupMemberModel();
              groupMemberModel.uid = "000000";
              groupMemberModel.name = this.a.getResources().getString(2131756638);
              LiveEventBus.get("choose_at_user", GroupMemberModel.class).post(groupMemberModel);
              this.a.C();
            }
          });
      this.e.b(view);
    } 
    this.search_list.setAdapter((RecyclerView.Adapter)this.d);
    this.user_list.setAdapter((RecyclerView.Adapter)this.e);
    this.e.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.e.b(this.user_list);
    this.e.a(this);
    this.d.a(this);
    this.refresh_layout.b(false);
    this.refresh_layout.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            SearchMemberFragment.a(this.a).c(true);
            this.a.u();
          }
        });
    this.e.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((GroupMemberPresenter)this.a.s()).f();
          }
        },  this.user_list);
    this.search_view.clearFocus();
    this.search_view.getEditView().setHint(getString(2131756783));
    this.search_view.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            this.a.k();
          }
          
          public void a(String param1String) {
            if (!TextUtils.isEmpty(param1String)) {
              this.a.refresh_layout.c(false);
              SearchMemberFragment.a(this.a, param1String);
              SearchMemberFragment.b(this.a).n().clear();
              SearchMemberFragment.b(this.a).notifyDataSetChanged();
              this.a.search_list.setVisibility(0);
              this.a.user_list.setVisibility(8);
              ((GroupMemberPresenter)this.a.s()).d(SearchMemberFragment.c(this.a));
              return;
            } 
            this.a.k();
          }
          
          public void b() {
            this.a.k();
          }
        });
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue()) {
      if (this.d.n().size() <= 0) {
        this.noDataView.a();
        return;
      } 
      this.noDataView.c();
      return;
    } 
    this.noDataView.b();
  }
  
  public void a(Integer paramInteger) {
    GroupMemberModel groupMemberModel = this.e.n().get(paramInteger.intValue());
    groupMemberModel.group_role = 2;
    LiveEventBus.get("set_manager", GroupMemberModel.class).post(groupMemberModel);
    C();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (!paramBoolean && ((GroupMemberPresenter)s()).i != 1)
      this.e.m(); 
  }
  
  public void a(List<GroupMemberModel> paramList) {
    this.d.a(c(paramList), this.f);
  }
  
  public void b(List<GroupMemberModel> paramList) {
    this.refresh_layout.g();
    this.e.l();
    this.e.c(c(paramList));
  }
  
  public void k() {
    this.f = "";
    this.d.n().clear();
    this.d.notifyDataSetChanged();
    this.search_list.setVisibility(8);
    this.refresh_layout.c(true);
    this.noDataView.c();
    this.user_list.setVisibility(0);
  }
  
  public void onItemClick(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    KeyboardUtils.a((Activity)getActivity());
    GroupMemberModel groupMemberModel = paramBaseQuickAdapter.n().get(paramInt);
    int i = this.g;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        if (((GroupMemberPresenter)s()).m == 1) {
          if (groupMemberModel.group_role == 1)
            return; 
          CommonAlertDialog.a(getContext(), getString(2131756796), String.format(getString(2131756657), new Object[] { groupMemberModel.name }), getContext().getResources().getString(2131756086), new DialogInterface.OnClickListener(this, groupMemberModel, paramInt) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  ((GroupMemberPresenter)this.c.s()).a(this.a.uid, 1, new int[] { this.b });
                }
              }getContext().getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
              },  null);
          return;
        } 
        return;
      } 
      LiveEventBus.get("choose_at_user", GroupMemberModel.class).post(groupMemberModel);
      C();
      return;
    } 
    if (groupMemberModel.group_role != 3)
      return; 
    CommonAlertDialog.a(getContext(), getString(2131756631), String.format(getString(2131756622), new Object[] { groupMemberModel.name }), getContext().getResources().getString(2131756086), new DialogInterface.OnClickListener(this, groupMemberModel, paramInt) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ((GroupMemberPresenter)this.c.s()).a(this.a.uid, 2, new int[] { this.b });
          }
        }getContext().getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null);
  }
  
  public int p() {
    return 2131493063;
  }
  
  public void y() {
    super.y();
    this.e.k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\SearchMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
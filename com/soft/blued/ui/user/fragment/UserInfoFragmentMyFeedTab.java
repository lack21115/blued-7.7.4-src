package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;

public class UserInfoFragmentMyFeedTab extends BaseFragment implements View.OnClickListener {
  public Context d;
  
  public View e;
  
  public PullToRefreshRecyclerView f;
  
  public RecyclerView g;
  
  public FeedListAdapterForRecyclerView h;
  
  BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra>>(this, (IRequestHost)w_()) {
      boolean a = false;
      
      private void a(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity, boolean param1Boolean) {
        if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
          if (param1BluedEntity.hasMore()) {
            UserInfoFragmentMyFeedTab.a(this.b, true);
            this.b.h.c(true);
          } else {
            UserInfoFragmentMyFeedTab.a(this.b, false);
            this.b.h.c(false);
          } 
          if (UserInfoFragmentMyFeedTab.a(this.b) == 1) {
            this.b.h.c(param1BluedEntity.data);
          } else {
            this.b.h.a(param1BluedEntity.data);
          } 
          this.b.h.notifyDataSetChanged();
        } 
      }
      
      public void onUICache(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity) {
        a(param1BluedEntity, true);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (UserInfoFragmentMyFeedTab.a(this.b) != 1)
          UserInfoFragmentMyFeedTab.b(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        if (this.b.h.getItemCount() == 1) {
          if (this.a) {
            UserInfoFragmentMyFeedTab.c(this.b).b();
          } else {
            UserInfoFragmentMyFeedTab.c(this.b).a();
          } 
        } else {
          UserInfoFragmentMyFeedTab.c(this.b).c();
        } 
        this.a = false;
        this.b.h.notifyDataSetChanged();
        this.b.h.l();
        this.b.f.j();
      }
      
      public void onUIStart() {
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity) {
        a(param1BluedEntity, false);
      }
      
      public BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> parseData(String param1String) {
        BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null) {
          if (!bluedEntity.hasData())
            return bluedEntity; 
          for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntity.data)
            bluedIngSelfFeed.feedParse = new FeedParse(this.b.d, bluedIngSelfFeed, 11); 
        } 
        return bluedEntity;
      }
    };
  
  private NoDataAndLoadFailView j;
  
  private int k = 1;
  
  private int l = 20;
  
  private boolean m = true;
  
  private void a() {}
  
  private void k() {
    this.j = new NoDataAndLoadFailView(this.d);
    this.j.c();
    this.j.setImageScale(0.7F);
    this.j.setTopSpace(DensityUtils.a(this.d, 58.0F));
    this.f = (PullToRefreshRecyclerView)this.e.findViewById(2131301764);
    this.f.setRefreshEnabled(true);
    this.g = (RecyclerView)this.f.getRefreshableView();
    this.h = new FeedListAdapterForRecyclerView(new ArrayList(), this.d, (IRequestHost)w_(), this.g, 11);
    this.g.setAdapter((RecyclerView.Adapter)this.h);
    this.h.e((View)this.j);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 1);
    this.g.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.h.c(true);
    this.h.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            this.a.a(false);
          }
        });
    this.f.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true);
          }
        });
    this.f.k();
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.k = 1;
    } else {
      this.k++;
    } 
    if (!this.m) {
      int i = this.k;
      if (i != 1) {
        this.k = i - 1;
        return;
      } 
    } 
    Context context = this.d;
    BluedUIHttpResponse bluedUIHttpResponse = this.i;
    String str1 = (UserInfo.a().i()).uid;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.k);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.l);
    stringBuilder2.append("");
    MineHttpUtils.b(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493345, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserInfoFragmentMyFeedTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
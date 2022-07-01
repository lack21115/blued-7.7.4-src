package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.home.HomeArgumentHelper;
import java.util.ArrayList;

public class UserInfoFragmentMyZanTab extends PreloadFragment implements View.OnClickListener {
  public Context o;
  
  public PullToRefreshRecyclerView p;
  
  public RecyclerView q;
  
  public FeedListAdapterForRecyclerView r;
  
  BluedUIHttpResponse s = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra>>(this, (IRequestHost)w_()) {
      boolean a = false;
      
      private void a(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity, boolean param1Boolean) {
        if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
          if (param1BluedEntity.hasMore()) {
            UserInfoFragmentMyZanTab.a(this.b, true);
            this.b.r.c(true);
          } else {
            UserInfoFragmentMyZanTab.a(this.b, false);
            this.b.r.c(false);
          } 
          if (UserInfoFragmentMyZanTab.a(this.b) == 1) {
            this.b.r.c(param1BluedEntity.data);
          } else {
            this.b.r.a(param1BluedEntity.data);
          } 
          this.b.r.notifyDataSetChanged();
        } 
      }
      
      public void onUICache(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity) {
        a(param1BluedEntity, true);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (UserInfoFragmentMyZanTab.a(this.b) != 1)
          UserInfoFragmentMyZanTab.b(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        if (this.b.r.getItemCount() == 1) {
          if (this.a) {
            UserInfoFragmentMyZanTab.c(this.b).b();
            Log.v("drb", "showFail");
          } else {
            UserInfoFragmentMyZanTab.c(this.b).a();
            Log.v("drb", "showNodata");
          } 
        } else {
          UserInfoFragmentMyZanTab.c(this.b).c();
        } 
        this.a = false;
        this.b.r.notifyDataSetChanged();
        this.b.r.l();
        this.b.p.j();
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
            bluedIngSelfFeed.feedParse = new FeedParse(this.b.o, bluedIngSelfFeed, 12); 
        } 
        return bluedEntity;
      }
    };
  
  private NoDataAndLoadFailView t;
  
  private int u = 1;
  
  private int v = 20;
  
  private boolean w = true;
  
  private void t() {
    this.t = new NoDataAndLoadFailView(this.o);
    this.t.c();
    this.t.setImageScale(0.7F);
    this.t.setNoDataImg(2131232638);
    this.t.setNoDataStr(2131758189);
    this.t.setBtnStr(2131758191);
    this.t.setNoDataBtnVisibility(0);
    this.t.setNoDataBtnListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.a(FeedProtos.Event.FEED_LIKE_GO_PLAZA_BTN_CLICK);
            this.a.getActivity().finish();
            HomeArgumentHelper.a(this.a.o, "feed", null);
          }
        });
    this.p = (PullToRefreshRecyclerView)this.e.findViewById(2131301764);
    this.p.setRefreshEnabled(true);
    this.q = (RecyclerView)this.p.getRefreshableView();
    this.r = new FeedListAdapterForRecyclerView(new ArrayList(), this.o, (IRequestHost)w_(), this.q, 12);
    this.q.setAdapter((RecyclerView.Adapter)this.r);
    this.r.e((View)this.t);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.o, 1);
    this.q.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.r.c(true);
    this.r.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            this.a.a(false);
          }
        });
    this.p.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true);
          }
        });
    this.p.k();
  }
  
  public void a(View paramView) {
    this.o = (Context)getActivity();
    this.e = LayoutInflater.from(this.o).inflate(2131493345, (ViewGroup)paramView, true);
    t();
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.u = 1;
    } else {
      this.u++;
    } 
    if (!this.w) {
      int i = this.u;
      if (i != 1) {
        this.u = i - 1;
        return;
      } 
    } 
    Context context = this.o;
    BluedUIHttpResponse bluedUIHttpResponse = this.s;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.u);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.v);
    stringBuilder2.append("");
    MineHttpUtils.a(context, bluedUIHttpResponse, str, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.f) {
      PullToRefreshRecyclerView pullToRefreshRecyclerView = this.p;
      if (pullToRefreshRecyclerView != null) {
        pullToRefreshRecyclerView.k();
        this.f = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserInfoFragmentMyZanTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
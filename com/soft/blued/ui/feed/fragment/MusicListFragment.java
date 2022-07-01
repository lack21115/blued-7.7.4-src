package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FlashVideoHttpUtils;
import com.soft.blued.ui.feed.adapter.MusicListAdapter;
import com.soft.blued.ui.feed.model.MusicListItem;
import com.soft.blued.utils.StringUtils;

public class MusicListFragment extends BaseFragment {
  public static String d = "CATEGORY_ID";
  
  public static String e = "KEYWORD";
  
  private Context f;
  
  private View g;
  
  private NoDataAndLoadFailView h;
  
  private RenrenPullToRefreshListView i;
  
  private ListView j;
  
  private LayoutInflater k;
  
  private MusicListAdapter l;
  
  private int m = 1;
  
  private int n = 15;
  
  private int o = 1;
  
  private String p;
  
  public static MusicListFragment a(int paramInt) {
    MusicListFragment musicListFragment = new MusicListFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(d, paramInt);
    musicListFragment.setArguments(bundle);
    return musicListFragment;
  }
  
  public static MusicListFragment a(String paramString) {
    MusicListFragment musicListFragment = new MusicListFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(d, -1);
    bundle.putString(e, paramString);
    musicListFragment.setArguments(bundle);
    return musicListFragment;
  }
  
  public boolean V_() {
    MusicChooseFragment.n();
    return super.V_();
  }
  
  public void a() {
    NoDataAndLoadFailView noDataAndLoadFailView = this.h;
    if (noDataAndLoadFailView != null)
      noDataAndLoadFailView.setVisibility(8); 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.m = 1;
      MusicListAdapter musicListAdapter = this.l;
      if (musicListAdapter != null)
        musicListAdapter.a(); 
    } else {
      this.m++;
    } 
    BluedUIHttpResponse<BluedEntityA<MusicListItem>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<MusicListItem>>(this) {
        boolean a = false;
        
        protected void a(BluedEntityA<MusicListItem> param1BluedEntityA) {
          if (param1BluedEntityA.hasMore()) {
            MusicListFragment.a(this.b).o();
          } else {
            MusicListFragment.a(this.b).p();
          } 
          if (MusicListFragment.b(this.b) == 1) {
            MusicListFragment.c(this.b).a(param1BluedEntityA.data);
          } else {
            MusicListFragment.c(this.b).b(param1BluedEntityA.data);
          } 
          MusicListFragment.c(this.b).a(MusicListFragment.d(this.b));
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          this.a = true;
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          MusicListFragment.e(this.b).setVisibility(0);
          if (this.a) {
            MusicListFragment.e(this.b).b();
          } else {
            MusicListFragment.e(this.b).a();
          } 
          MusicListFragment.c(this.b).notifyDataSetChanged();
          MusicListFragment.a(this.b).q();
          MusicListFragment.a(this.b).j();
          super.onUIFinish();
        }
      };
    if (this.o == -1) {
      FlashVideoHttpUtils.a(bluedUIHttpResponse, (IRequestHost)w_(), this.p);
      return;
    } 
    FlashVideoHttpUtils.a(bluedUIHttpResponse, (IRequestHost)w_(), this.o, this.m, this.n);
  }
  
  public void b(String paramString) {
    this.o = -1;
    this.p = paramString;
    a(true);
  }
  
  public MusicListAdapter k() {
    return this.l;
  }
  
  public void l() {
    if (getArguments() != null) {
      this.o = getArguments().getInt(d);
      this.p = getArguments().getString(e);
    } 
  }
  
  public void m() {
    this.i = (RenrenPullToRefreshListView)this.g.findViewById(2131298144);
    this.j = (ListView)this.i.getRefreshableView();
    this.h = new NoDataAndLoadFailView(this.f);
    this.l = new MusicListAdapter(this.f, this.j, (IRequestHost)w_());
    this.j.setAdapter((ListAdapter)this.l);
    this.j.setEmptyView((View)this.h);
    this.i.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            this.a.a(true);
          }
          
          public void b() {
            this.a.a(false);
          }
        });
    if (this.o == -1 && StringUtils.e(this.p)) {
      this.h.setVisibility(8);
      return;
    } 
    a(new Runnable(this) {
          public void run() {
            MusicListFragment.a(this.a).k();
          }
        },  300L);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    this.k = paramLayoutInflater;
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493239, paramViewGroup, false);
      l();
      m();
      ShortVideoProxy.e().a(getClass().getSimpleName());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  public void onDestroyView() {
    ShortVideoProxy.e().b(getClass().getSimpleName());
    super.onDestroyView();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\MusicListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
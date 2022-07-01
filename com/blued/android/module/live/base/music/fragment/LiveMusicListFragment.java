package com.blued.android.module.live.base.music.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.music.LiveMusicListPresent;
import com.blued.android.module.live.base.music.MusicLoadMoreView;
import com.blued.android.module.live.base.music.adapter.LiveMusicListAdapter;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.Collection;
import java.util.List;

public abstract class LiveMusicListFragment<P extends LiveMusicListPresent> extends MvpFragment<P> implements View.OnClickListener {
  public String d;
  
  private SmartRefreshLayout e;
  
  private RecyclerView f;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private View j;
  
  private View n;
  
  private LiveMusicListAdapter o;
  
  private String p;
  
  private int q;
  
  private boolean r;
  
  private boolean s;
  
  private String t;
  
  private boolean u;
  
  private Observer<String> v = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
        LiveMusicListFragment.a(this.a).notifyDataSetChanged();
      }
    };
  
  private Observer<String> w = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
        LiveMusicListFragment.a(this.a).notifyDataSetChanged();
      }
    };
  
  private void E() {
    LiveEventBus.get("live_music_changed", String.class).removeObserver(this.v);
    LiveEventBus.get("live_music_exit", String.class).removeObserver(this.w);
  }
  
  private void F() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initView :  sheetId:");
    stringBuilder.append(this.d);
    stringBuilder.append("  collectId:");
    stringBuilder.append(this.p);
    Log.i("==abcd", stringBuilder.toString());
    this.e = (SmartRefreshLayout)this.l.findViewById(R.id.smart_members);
    this.f = (RecyclerView)this.l.findViewById(R.id.rv_music);
    this.g = this.l.findViewById(R.id.ll_sheet_error);
    this.h = this.l.findViewById(R.id.tv_reload);
    this.i = this.l.findViewById(R.id.ll_nodata);
    this.j = this.l.findViewById(R.id.loading_view);
    this.n = this.l.findViewById(R.id.ll_search_no_data);
    ((LiveMusicListPresent)s()).a(this.d, this.q, this.r);
    this.e.b(false);
    this.e.c(false);
    this.e.a((RefreshFooter)new MusicLoadMoreView(getContext()));
    this.e.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveMusicListPresent)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.h.setOnClickListener(this);
    if (this.o == null) {
      this.o = l();
      this.o.c(false);
      this.o.a(new LiveMusicListAdapter.LiveMusicEventCallBack(this) {
            public void a(LiveMusicSongModel param1LiveMusicSongModel) {
              if (param1LiveMusicSongModel == null)
                return; 
              if (this.a.k().K().a(param1LiveMusicSongModel.music_id))
                return; 
              if (this.a.k() != null) {
                param1LiveMusicSongModel.sheetId = this.a.d;
                param1LiveMusicSongModel.fromSearchPage = LiveMusicListFragment.b(this.a);
                this.a.k().a(param1LiveMusicSongModel);
              } 
            }
            
            public boolean a(String param1String) {
              return (this.a.k() != null && this.a.k().K() != null) ? this.a.k().K().a(param1String) : false;
            }
            
            public void b(LiveMusicSongModel param1LiveMusicSongModel) {
              if (param1LiveMusicSongModel == null)
                return; 
              if (this.a.k() != null && this.a.k().K() != null)
                this.a.k().K().b(param1LiveMusicSongModel); 
            }
            
            public boolean b(String param1String) {
              return (this.a.k() != null && this.a.k().K() != null) ? this.a.k().K().b(param1String) : false;
            }
            
            public void c(LiveMusicSongModel param1LiveMusicSongModel) {
              if (param1LiveMusicSongModel == null)
                return; 
              if (this.a.k() != null) {
                int i = param1LiveMusicSongModel.is_collect;
                boolean bool = true;
                if (i == 1)
                  bool = false; 
                ((LiveMusicListPresent)this.a.s()).a(param1LiveMusicSongModel, bool);
              } 
            }
            
            public boolean c(String param1String) {
              return (this.a.k() != null && this.a.k().K() != null) ? this.a.k().K().d(param1String) : false;
            }
          });
    } 
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.f.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.f.setAdapter((RecyclerView.Adapter)this.o);
  }
  
  private void G() {
    if (!I())
      return; 
    if (this.r) {
      this.n.setVisibility(0);
    } else {
      this.i.setVisibility(0);
    } 
    this.f.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  private void H() {
    if (!I())
      return; 
    this.i.setVisibility(8);
    this.f.setVisibility(8);
    if (!this.r)
      this.g.setVisibility(0); 
  }
  
  private boolean I() {
    this.j.setVisibility(8);
    this.e.h();
    if (this.o.a() > 0) {
      Log.i("xmm", "setData 4");
      this.n.setVisibility(8);
      this.i.setVisibility(8);
      this.f.setVisibility(0);
      this.g.setVisibility(8);
      return false;
    } 
    return true;
  }
  
  private void m() {
    if (getArguments() != null) {
      this.d = getArguments().getString("sheetId");
      this.p = getArguments().getString("collectId");
      this.q = getArguments().getInt("isPersonal", 0);
      this.r = getArguments().getBoolean("searchPage", false);
    } 
  }
  
  private void n() {
    LiveEventBus.get("live_music_changed", String.class).observeForever(this.v);
    LiveEventBus.get("live_music_exit", String.class).observeForever(this.w);
  }
  
  public boolean V_() {
    if (super.V_())
      return true; 
    if (!isHidden()) {
      if (k() != null && k().K() != null)
        k().K().a(); 
      return true;
    } 
    return false;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    F();
    n();
    this.s = true;
  }
  
  public void a(String paramString, List paramList) {
    List<LiveMusicSongModel> list;
    StringBuilder stringBuilder1;
    LiveMusicSongModel liveMusicSongModel;
    byte b;
    super.a(paramString, paramList);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("showDataToUI type=");
    stringBuilder2.append(paramString);
    LogUtils.c("music", stringBuilder2.toString());
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1983753609:
        if (paramString.equals("MUSIC_NOTIFY_MUSIC")) {
          b = 0;
          break;
        } 
      case 1863829788:
        if (paramString.equals("no_data_view")) {
          b = 8;
          break;
        } 
      case 1414891673:
        if (paramString.equals("load_data_failed")) {
          b = 5;
          break;
        } 
      case -254884522:
        if (paramString.equals("no_more_data")) {
          b = 7;
          break;
        } 
      case -311507036:
        if (paramString.equals("MUSIC_SHEET_SONGS")) {
          b = 1;
          break;
        } 
      case -979972369:
        if (paramString.equals("has_more_data")) {
          b = 6;
          break;
        } 
      case -1413753758:
        if (paramString.equals("dismiss_loading_data")) {
          b = 4;
          break;
        } 
      case -1433649457:
        if (paramString.equals("show_loading_data")) {
          b = 3;
          break;
        } 
      case -2082045594:
        if (paramString.equals("MUSIC_SHEET_SONGS_ADD")) {
          b = 2;
          break;
        } 
    } 
    switch (b) {
      default:
        return;
      case 7:
      case 8:
        this.j.setVisibility(8);
        list = this.o.n();
        if (list.size() <= 0) {
          G();
          return;
        } 
        liveMusicSongModel = list.get(list.size() - 1);
        if (liveMusicSongModel != null && liveMusicSongModel.type != 1) {
          liveMusicSongModel = new LiveMusicSongModel();
          liveMusicSongModel.type = 1;
          list.add(liveMusicSongModel);
          this.o.a(list);
        } 
        this.e.b(false);
        return;
      case 6:
        this.e.b(true);
        return;
      case 5:
        H();
        return;
      case 4:
        G();
        return;
      case 3:
        this.j.setVisibility(0);
        return;
      case 2:
        if (liveMusicSongModel == null)
          return; 
        this.o.a((Collection)liveMusicSongModel);
        return;
      case 1:
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("showDataToUI list=");
        stringBuilder1.append(liveMusicSongModel.size());
        LogUtils.c("music", stringBuilder1.toString());
        if (liveMusicSongModel == null)
          return; 
        this.f.setVisibility(0);
        this.o.a((List)liveMusicSongModel);
        return;
      case 0:
        break;
    } 
    if (TextUtils.equals(this.d, this.p)) {
      LiveMusicListAdapter liveMusicListAdapter = this.o;
      if (liveMusicListAdapter != null)
        liveMusicListAdapter.n().clear(); 
      ((LiveMusicListPresent)s()).e();
      return;
    } 
    this.o.notifyDataSetChanged();
  }
  
  public void aL_() {
    super.aL_();
    E();
    this.s = false;
  }
  
  public void c(String paramString) {
    LiveMusicListAdapter liveMusicListAdapter = this.o;
    if (liveMusicListAdapter != null)
      liveMusicListAdapter.a(null); 
    ((LiveMusicListPresent)s()).d(paramString);
  }
  
  public LiveMusicFragment k() {
    return (getParentFragment() instanceof LiveMusicFragment) ? (LiveMusicFragment)getParentFragment() : null;
  }
  
  public abstract LiveMusicListAdapter l();
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    if (this.s && this.c && !this.u) {
      LogUtils.d("LiveMusicListFragment", "onActivityCreated refreshData ...");
      ((LiveMusicListPresent)s()).e();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_reload)
      ((LiveMusicListPresent)s()).e(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    m();
  }
  
  public int p() {
    return R.layout.fragment_live_music_list;
  }
  
  public String q() {
    this.t = super.q();
    return this.t;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && this.s) {
      LiveMusicListAdapter liveMusicListAdapter = this.o;
      if (liveMusicListAdapter != null)
        liveMusicListAdapter.a(null); 
      LogUtils.d("LiveMusicListFragment", "setUserVisibleHint refreshData ...");
      ((LiveMusicListPresent)s()).e();
      this.u = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\music\fragment\LiveMusicListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
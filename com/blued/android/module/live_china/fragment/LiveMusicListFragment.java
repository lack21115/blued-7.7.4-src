package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMusicListAdapter;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import com.blued.android.module.live_china.presenter.LiveMusicListPresent;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.MusicLoadMoreView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.List;

public class LiveMusicListFragment extends MvpFragment<LiveMusicListPresent> implements View.OnClickListener {
  SmartRefreshLayout d;
  
  RecyclerView e;
  
  View f;
  
  View g;
  
  View h;
  
  View i;
  
  View j;
  
  private LiveMusicListAdapter n;
  
  private String o;
  
  private String p;
  
  private int q;
  
  private boolean r;
  
  private boolean s;
  
  private Observer<String> t = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
        LiveMusicListFragment.a(this.a).notifyDataSetChanged();
      }
    };
  
  private void E() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initView :  sheetId:");
    stringBuilder.append(this.o);
    stringBuilder.append("  collectId:");
    stringBuilder.append(this.p);
    Log.i("==abcd", stringBuilder.toString());
    this.d = (SmartRefreshLayout)this.l.findViewById(R.id.smart_members);
    this.e = (RecyclerView)this.l.findViewById(R.id.rv_music);
    this.f = this.l.findViewById(R.id.ll_sheet_error);
    this.g = this.l.findViewById(R.id.tv_reload);
    this.h = this.l.findViewById(R.id.ll_nodata);
    this.i = this.l.findViewById(R.id.loading_view);
    this.j = this.l.findViewById(R.id.ll_search_no_data);
    ((LiveMusicListPresent)s()).a(this.o, this.q, this.r);
    this.d.c(false);
    this.d.a((RefreshFooter)new MusicLoadMoreView(getContext()));
    this.d.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((LiveMusicListPresent)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {}
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ((LiveMusicListPresent)this.a.s()).e();
          }
        });
    if (this.n == null) {
      this.i.setVisibility(0);
      this.n = new LiveMusicListAdapter(getContext());
      this.n.a(new LiveMusicListAdapter.LiveMusicEventCallBack(this) {
            public void a(LiveMusicSongModel param1LiveMusicSongModel) {
              if (param1LiveMusicSongModel == null)
                return; 
              if (LiveRoomManager.a().h() != null)
                if (LiveMusicListFragment.b(this.a)) {
                  EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_PLAY_CLICK, LiveRoomManager.a().c(), param1LiveMusicSongModel.music_id, "search");
                } else {
                  EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_PLAY_CLICK, LiveRoomManager.a().c(), param1LiveMusicSongModel.music_id, LiveMusicListFragment.c(this.a));
                }  
              if (this.a.k() != null) {
                param1LiveMusicSongModel.sheetId = LiveMusicListFragment.c(this.a);
                param1LiveMusicSongModel.fromSearchPage = LiveMusicListFragment.b(this.a);
                this.a.k().a(param1LiveMusicSongModel);
              } 
              if (LiveMusicListFragment.b(this.a))
                this.a.k(); 
            }
            
            public void b(LiveMusicSongModel param1LiveMusicSongModel) {
              if (param1LiveMusicSongModel == null)
                return; 
              if (param1LiveMusicSongModel.is_collect == 0 && LiveRoomManager.a().h() != null)
                if (LiveMusicListFragment.b(this.a)) {
                  EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_COLLECT_CLICK, LiveRoomManager.a().c(), param1LiveMusicSongModel.music_id, "search");
                } else {
                  EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_COLLECT_CLICK, LiveRoomManager.a().c(), param1LiveMusicSongModel.music_id, LiveMusicListFragment.c(this.a));
                }  
              if (this.a.k() != null && this.a.k().J() != null) {
                int i = param1LiveMusicSongModel.is_collect;
                boolean bool = true;
                if (i == 1)
                  bool = false; 
                LiveRoomHttpUtils.c(param1LiveMusicSongModel.music_id, bool, new BluedUIHttpResponse(this, (IRequestHost)this.a.w_(), param1LiveMusicSongModel, bool) {
                      public boolean onUIFailure(int param2Int, String param2String) {
                        AppMethods.a(param2String);
                        return true;
                      }
                      
                      public void onUIUpdate(BluedEntity param2BluedEntity) {
                        this.a.is_collect = this.b;
                        if (TextUtils.equals(LiveMusicListFragment.c(this.c.a), LiveMusicListFragment.d(this.c.a))) {
                          ((LiveMusicListPresent)this.c.a.s()).e();
                          return;
                        } 
                        LiveMusicListFragment.a(this.c.a).notifyDataSetChanged();
                      }
                    });
              } 
            }
          });
    } 
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.e.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.e.setAdapter((RecyclerView.Adapter)this.n);
    ((LiveMusicListPresent)s()).e();
  }
  
  public static LiveMusicListFragment a(long paramLong) {
    LiveMusicListFragment liveMusicListFragment = new LiveMusicListFragment();
    Bundle bundle = new Bundle();
    bundle.putLong("lid", paramLong);
    bundle.putBoolean("searchPage", true);
    liveMusicListFragment.setArguments(bundle);
    return liveMusicListFragment;
  }
  
  public static LiveMusicListFragment a(String paramString1, int paramInt, String paramString2) {
    LiveMusicListFragment liveMusicListFragment = new LiveMusicListFragment();
    Bundle bundle = new Bundle();
    bundle.putString("sheetId", paramString1);
    bundle.putInt("isPersonal", paramInt);
    bundle.putString("collectId", paramString2);
    bundle.putBoolean("searchPage", false);
    liveMusicListFragment.setArguments(bundle);
    return liveMusicListFragment;
  }
  
  private void l() {
    if (getArguments() != null) {
      this.o = getArguments().getString("sheetId");
      this.p = getArguments().getString("collectId");
      this.q = getArguments().getInt("isPersonal", 0);
      this.r = getArguments().getBoolean("searchPage", false);
    } 
  }
  
  private void m() {
    LiveEventBus.get("live_music_changed", String.class).observeForever(this.t);
  }
  
  private void n() {
    LiveEventBus.get("live_music_changed", String.class).removeObserver(this.t);
  }
  
  public boolean V_() {
    if (super.V_())
      return true; 
    if (!isHidden()) {
      if (k() != null && k().J() != null)
        k().J().bc(); 
      return true;
    } 
    return false;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    E();
    m();
    this.s = true;
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.i.setVisibility(8);
    this.d.h();
    if (this.n.a() == 0) {
      Log.i("xmm", "setData 1");
      if (paramBoolean) {
        Log.i("xmm", "setData 2");
        if (this.r) {
          this.j.setVisibility(0);
        } else {
          this.h.setVisibility(0);
        } 
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        return;
      } 
      Log.i("xmm", "setData 3");
      this.h.setVisibility(8);
      this.e.setVisibility(8);
      if (!this.r) {
        this.f.setVisibility(0);
        return;
      } 
    } else {
      Log.i("xmm", "setData 4");
      this.j.setVisibility(8);
      this.h.setVisibility(8);
      this.e.setVisibility(0);
      this.f.setVisibility(8);
    } 
  }
  
  public void a(List<LiveMusicSongModel> paramList) {
    Log.i("xmm", "setData");
    if (paramList == null)
      return; 
    this.e.setVisibility(0);
    this.n.a(paramList);
  }
  
  public void aL_() {
    super.aL_();
    n();
    this.s = false;
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void c(String paramString) {
    ((LiveMusicListPresent)s()).d(paramString);
  }
  
  public LiveMusicFragment k() {
    return (getParentFragment() instanceof LiveMusicFragment) ? (LiveMusicFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    l();
  }
  
  public int p() {
    return R.layout.fragment_live_music_list;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && this.s)
      ((LiveMusicListPresent)s()).e(); 
    if (paramBoolean && !this.r)
      EventTrackLive.c(LiveProtos.Event.LIVE_MUSIC_TAB_PAGE_SHOW, LiveRoomManager.a().c(), this.o); 
  }
  
  public void x() {
    super.x();
    Log.i("xmm", "setData 5");
    this.d.b(true);
  }
  
  public void y() {
    super.y();
    Log.i("xmm", "setData 6");
    this.d.b(false);
    List<LiveMusicSongModel> list = this.n.n();
    if (list.size() > 0) {
      LiveMusicSongModel liveMusicSongModel = list.get(list.size() - 1);
      if (liveMusicSongModel != null && liveMusicSongModel.type != 1) {
        liveMusicSongModel = new LiveMusicSongModel();
        liveMusicSongModel.type = 1;
        list.add(liveMusicSongModel);
        this.n.a(list);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMusicListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
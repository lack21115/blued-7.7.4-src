package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.view.FlowLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMusicTabAdapter;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.TabLinearLayoutManager;
import com.blued.android.module.live_china.model.LiveMusicSheetModel;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import com.blued.android.module.live_china.presenter.LiveMusicPresent;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiveMusicFragment extends MvpFragment<LiveMusicPresent> implements View.OnClickListener {
  FlowLayout A;
  
  View B;
  
  public List<LiveMusicSheetModel> C = new ArrayList<LiveMusicSheetModel>();
  
  private Context D;
  
  private MusicPageAdapter E;
  
  private LiveMusicTabAdapter F;
  
  private LiveMusicListFragment G;
  
  private boolean H;
  
  private LiveMusicSongModel I;
  
  private Observer<String> J = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
        this.a.k();
      }
    };
  
  private TextWatcher K = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {
        LiveMusicFragment liveMusicFragment = this.a;
        liveMusicFragment.e(liveMusicFragment.y.getText().toString());
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  View d;
  
  View e;
  
  View f;
  
  ImageView g;
  
  TextView h;
  
  TextView i;
  
  View j;
  
  View n;
  
  View o;
  
  View p;
  
  View q;
  
  RecyclerView r;
  
  ViewPager s;
  
  View t;
  
  View u;
  
  View v;
  
  View w;
  
  View x;
  
  EditText y;
  
  View z;
  
  private void K() {}
  
  private void L() {
    LiveEventBus.get("live_music_changed", String.class).observeForever(this.J);
  }
  
  private void M() {
    LiveEventBus.get("live_music_changed", String.class).removeObserver(this.J);
  }
  
  private void N() {
    this.d = this.l.findViewById(R.id.empty_view);
    this.e = this.l.findViewById(R.id.fl_make_lover_dialog);
    this.f = this.l.findViewById(R.id.fl_player);
    this.g = (ImageView)this.l.findViewById(R.id.iv_start);
    this.h = (TextView)this.l.findViewById(R.id.tv_time);
    this.i = (TextView)this.l.findViewById(R.id.tv_exit);
    this.j = this.l.findViewById(R.id.ll_main);
    this.n = this.l.findViewById(R.id.fl_tab_error);
    this.o = this.l.findViewById(R.id.tv_reload);
    this.p = this.l.findViewById(R.id.tv_music_title);
    this.q = this.l.findViewById(R.id.loading_view);
    this.r = (RecyclerView)this.l.findViewById(R.id.rv_tab);
    this.s = (ViewPager)this.l.findViewById(R.id.view_pager);
    this.t = this.l.findViewById(R.id.ll_search);
    this.u = this.l.findViewById(R.id.iv_search);
    this.v = this.l.findViewById(R.id.iv_search_clear);
    this.w = this.l.findViewById(R.id.tv_search_close);
    this.x = this.l.findViewById(R.id.tv_history_clear);
    this.y = (EditText)this.l.findViewById(R.id.edit_view);
    this.z = this.l.findViewById(R.id.ll_search_history);
    this.A = (FlowLayout)this.l.findViewById(R.id.music_history);
    this.B = this.l.findViewById(R.id.live_music_search_container_layout_id);
    this.C.clear();
    this.q.setVisibility(0);
    this.r.setLayoutManager((RecyclerView.LayoutManager)new TabLinearLayoutManager(getContext(), 0, false));
    this.r.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
          }
        });
    this.F = new LiveMusicTabAdapter(this.D, this.r);
    this.F.a(new LiveMusicTabAdapter.EventCallBack(this) {
          public void a(int param1Int) {
            this.a.s.setCurrentItem(param1Int);
          }
        });
    this.r.setAdapter((RecyclerView.Adapter)this.F);
    this.E = new MusicPageAdapter(this, getChildFragmentManager());
    this.s.setAdapter((PagerAdapter)this.E);
    this.s.setCurrentItem(1);
    this.s.setOffscreenPageLimit(1);
    this.s.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            LiveMusicFragment.a(this.a).a(param1Int);
          }
        });
    if (ZegoCommonHelper.b().m() != null) {
      if (ZegoCommonHelper.b().d((ZegoCommonHelper.b().m()).music_id)) {
        this.f.setVisibility(0);
        k();
      } else {
        this.f.setVisibility(8);
      } 
    } else {
      this.f.setVisibility(8);
    } 
    l();
    I();
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.y.addTextChangedListener(this.K);
    this.y.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
          public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int == 3) {
              LiveMusicFragment liveMusicFragment = this.a;
              liveMusicFragment.d(liveMusicFragment.y.getText().toString());
              liveMusicFragment = this.a;
              liveMusicFragment.e(liveMusicFragment.y.getText().toString());
            } 
            return true;
          }
        });
  }
  
  public void E() {
    this.y.setFocusableInTouchMode(true);
    this.y.setFocusable(true);
    this.y.requestFocus();
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput((View)this.y, 0);
  }
  
  public void F() {
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.y.getWindowToken(), 0);
  }
  
  public void G() {
    a(0L);
    this.f.setVisibility(0);
    this.H = true;
    this.g.setImageResource(R.drawable.live_music_pause);
  }
  
  public void H() {
    if (this.E.getCount() > 1)
      this.s.setCurrentItem(1); 
    this.r.smoothScrollToPosition(0);
    this.j.setVisibility(0);
    this.t.setVisibility(8);
  }
  
  public void I() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    LiveMusicListFragment liveMusicListFragment = this.G;
    if (liveMusicListFragment == null) {
      this.G = LiveMusicListFragment.a(0L);
      fragmentTransaction.add(R.id.live_music_search_container_layout_id, (Fragment)this.G, "SearchMusicList");
      fragmentTransaction.commitNowAllowingStateLoss();
      return;
    } 
    if (!liveMusicListFragment.isAdded()) {
      fragmentTransaction.show((Fragment)this.G);
      fragmentTransaction.commitNowAllowingStateLoss();
    } 
  }
  
  public RecordingOnliveFragment J() {
    return (getParentFragment() instanceof RecordingOnliveFragment) ? (RecordingOnliveFragment)getParentFragment() : null;
  }
  
  public boolean V_() {
    if (super.V_())
      return true; 
    if (!isHidden()) {
      if (J() != null)
        J().bc(); 
      return true;
    } 
    return false;
  }
  
  public void a(long paramLong) {
    LiveMusicSongModel liveMusicSongModel = this.I;
    if (liveMusicSongModel != null)
      liveMusicSongModel.playTime = (int)(paramLong / 1000L); 
    this.h.setText(LiveTimeAndDateUtils.a(paramLong / 1000L, false));
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    N();
    L();
  }
  
  public void a(LiveMusicSongModel paramLiveMusicSongModel) {
    if (LiveRoomManager.a().h() != null) {
      LiveMusicSongModel liveMusicSongModel = this.I;
      if (liveMusicSongModel != null)
        if (liveMusicSongModel.fromSearchPage) {
          EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_CHANGE, LiveRoomManager.a().c(), this.I.music_id, "search", this.I.playTime);
        } else {
          EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_CHANGE, LiveRoomManager.a().c(), this.I.music_id, this.I.sheetId, this.I.playTime);
        }  
    } 
    this.I = paramLiveMusicSongModel;
    if (J() != null)
      J().a(paramLiveMusicSongModel); 
  }
  
  public void a(String paramString, List<? extends LiveMusicSheetModel> paramList) {
    super.a(paramString, paramList);
    if (paramString == "LIVE_MUSIC_SHEET") {
      if (paramList == null || paramList.size() == 0) {
        this.n.setVisibility(0);
        return;
      } 
      this.n.setVisibility(8);
      this.C.clear();
      this.C.addAll(paramList);
      this.F.a(this.C, 0);
      this.E.notifyDataSetChanged();
      if (this.E.getCount() > 1) {
        this.s.setCurrentItem(1);
        return;
      } 
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.q.setVisibility(8);
  }
  
  public void aL_() {
    super.aL_();
    M();
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void c(String paramString) {
    TextView textView = (TextView)LayoutInflater.from(this.D).inflate(R.layout.live_music_search_label_view, null);
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    marginLayoutParams.rightMargin = DensityUtils.a(this.D, 10.0F);
    this.A.addView((View)textView, (ViewGroup.LayoutParams)marginLayoutParams);
    textView.setText(paramString);
    this.A.setOnItemClickListener(new FlowLayout.OnItemClickListener(this) {
          public void a(View param1View, int param1Int) {
            if (param1View instanceof TextView)
              this.a.e(((TextView)param1View).getText().toString()); 
          }
        });
  }
  
  public void d(String paramString) {
    int j;
    if (TextUtils.isEmpty(paramString))
      return; 
    List<String> list2 = m();
    List<String> list1 = list2;
    if (list2 == null)
      list1 = new ArrayList<String>(); 
    byte b = -1;
    int i = 0;
    while (true) {
      j = b;
      if (i < list1.size()) {
        if (TextUtils.equals(list1.get(i), paramString)) {
          j = i;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (j >= 0 && j < list1.size())
      list1.remove(j); 
    list2 = new ArrayList<String>();
    for (i = 0; i < list1.size(); i++) {
      if (i < 9)
        list2.add(list1.get(i)); 
    } 
    list2.add(0, paramString);
    try {
      LiveRoomPreferences.A(AppInfo.f().toJson(list2));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    l();
  }
  
  public void e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.G.c(paramString);
      this.z.setVisibility(8);
      this.B.setVisibility(0);
      return;
    } 
    this.z.setVisibility(0);
    this.B.setVisibility(8);
  }
  
  public void k() {
    boolean bool;
    Log.i("==record", "updateStartBtnStatus");
    if (ZegoCommonHelper.b().m() != null) {
      bool = ZegoCommonHelper.b().c((ZegoCommonHelper.b().m()).music_id);
    } else {
      bool = false;
    } 
    if (bool) {
      Log.i("==record", "musicStart:1");
      this.H = false;
      a(0L);
      this.g.setImageResource(R.drawable.live_music_start_gray);
      if (LiveRoomManager.a().h() != null) {
        LiveMusicSongModel liveMusicSongModel = this.I;
        if (liveMusicSongModel != null) {
          if (liveMusicSongModel.fromSearchPage) {
            EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_DONE, LiveRoomManager.a().c(), this.I.music_id, "search", this.I.playTime);
            return;
          } 
          EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_DONE, LiveRoomManager.a().c(), this.I.music_id, this.I.sheetId, this.I.playTime);
          return;
        } 
      } 
    } else {
      int i;
      Log.i("==record", "musicStart:2");
      ImageView imageView = this.g;
      if (this.H) {
        i = R.drawable.live_music_pause;
      } else {
        i = R.drawable.live_music_start;
      } 
      imageView.setImageResource(i);
    } 
  }
  
  public void l() {
    this.A.removeAllViews();
    List<String> list = m();
    if (list != null) {
      Iterator<String> iterator = list.iterator();
      while (iterator.hasNext())
        c(iterator.next()); 
    } 
  }
  
  public List<String> m() {
    String str = LiveRoomPreferences.S();
    List<String> list = (List)AppInfo.f().fromJson(str, (new TypeToken<List<String>>(this) {
        
        }).getType());
    if (list != null)
      for (String str1 : list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get:");
        stringBuilder.append(str1);
        Log.i("==abcd", stringBuilder.toString());
      }  
    return list;
  }
  
  public void n() {
    this.A.removeAllViews();
    LiveRoomPreferences.A("");
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.iv_search) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.LIVE_MUSIC_SEARCH_CLICK, LiveRoomManager.a().c()); 
      this.j.setVisibility(8);
      this.t.setVisibility(0);
      E();
      return;
    } 
    if (i == R.id.iv_search_clear) {
      this.y.setText("");
      return;
    } 
    if (i == R.id.tv_search_close) {
      this.y.setText("");
      this.j.setVisibility(0);
      this.t.setVisibility(8);
      F();
      return;
    } 
    if (i == R.id.empty_view) {
      if (J() != null)
        J().bc(); 
      F();
      return;
    } 
    if (i == R.id.iv_start) {
      if (ZegoCommonHelper.b().m() == null || ZegoCommonHelper.b().c((ZegoCommonHelper.b().m()).music_id)) {
        Log.i("==record", "play isCompleted");
        return;
      } 
      this.H ^= 0x1;
      if (LiveRoomManager.a().h() != null) {
        LiveMusicSongModel liveMusicSongModel = this.I;
        if (liveMusicSongModel != null)
          if (this.H) {
            if (liveMusicSongModel.fromSearchPage) {
              EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_PLAY_CLICK, LiveRoomManager.a().c(), this.I.music_id, "search");
            } else {
              EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_PLAY_CLICK, LiveRoomManager.a().c(), this.I.music_id, this.I.sheetId);
            } 
          } else if (liveMusicSongModel.fromSearchPage) {
            EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_STOP_CLICK, LiveRoomManager.a().c(), this.I.music_id, "search");
          } else {
            EventTrackLive.d(LiveProtos.Event.LIVE_MUSIC_STOP_CLICK, LiveRoomManager.a().c(), this.I.music_id, this.I.sheetId);
          }  
      } 
      ImageView imageView = this.g;
      if (this.H) {
        i = R.drawable.live_music_pause;
      } else {
        i = R.drawable.live_music_start;
      } 
      imageView.setImageResource(i);
      if (this.H) {
        if (J() != null) {
          J().bd();
          return;
        } 
      } else if (J() != null) {
        J().be();
        return;
      } 
    } else {
      if (i == R.id.tv_exit) {
        if (LiveRoomManager.a().h() != null) {
          LiveMusicSongModel liveMusicSongModel = this.I;
          if (liveMusicSongModel != null)
            if (liveMusicSongModel.fromSearchPage) {
              EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_EXIT_CLICK, LiveRoomManager.a().c(), this.I.music_id, "search", this.I.playTime);
            } else {
              EventTrackLive.b(LiveProtos.Event.LIVE_MUSIC_EXIT_CLICK, LiveRoomManager.a().c(), this.I.music_id, this.I.sheetId, this.I.playTime);
            }  
        } 
        this.f.setVisibility(8);
        a(0L);
        if (J() != null)
          J().bf(); 
        F();
        return;
      } 
      if (i == R.id.tv_history_clear) {
        n();
        return;
      } 
      if (i == R.id.tv_reload) {
        l();
        ((LiveMusicPresent)s()).e();
      } 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.D = getContext();
    K();
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public int p() {
    return R.layout.fragment_live_music_xpf;
  }
  
  public class MusicPageAdapter extends FragmentPagerAdapter {
    public MusicPageAdapter(LiveMusicFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.a.C.size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)LiveMusicListFragment.a(((LiveMusicSheetModel)this.a.C.get(param1Int)).sheet_id, ((LiveMusicSheetModel)this.a.C.get(param1Int)).is_personal, ((LiveMusicPresent)this.a.s()).m());
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((LiveMusicSheetModel)this.a.C.get(param1Int)).sheet_name;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
    
    public void setPrimaryItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.setPrimaryItem(param1ViewGroup, param1Int, param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMusicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
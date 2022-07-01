package com.soft.blued.ui.photo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;

public class AlbumVideoFragment extends BaseFragment {
  private static final String f = VideoDetailFragment.class.getSimpleName();
  
  ViewDragHelperLayout.OnLayoutStateListener d = new ViewDragHelperLayout.OnLayoutStateListener(this) {
      public void a() {
        if (this.a.getActivity() != null) {
          this.a.getActivity().finish();
          this.a.getActivity().overridePendingTransition(0, 0);
        } 
        EventCallbackObserver.a().b();
      }
      
      public void a(int param1Int) {
        AlbumVideoFragment.a(this.a).g();
        EventCallbackObserver.a().a(param1Int);
      }
      
      public void b() {
        if (!AlbumVideoFragment.a(this.a).i())
          AlbumVideoFragment.a(this.a).c(); 
        EventCallbackObserver.a().c();
      }
      
      public void c() {}
      
      public void d() {}
    };
  
  View.OnLongClickListener e = new View.OnLongClickListener(this) {
      public boolean onLongClick(View param1View) {
        EventCallbackObserver.a().a(new Object[] { (AlbumVideoFragment.b(this.a)).b, (AlbumVideoFragment.b(this.a)).a, Integer.valueOf(AlbumVideoFragment.b(this.a).a()), Integer.valueOf(AlbumVideoFragment.b(this.a).b()) });
        return false;
      }
    };
  
  private View g;
  
  private ViewDragHelperLayout h;
  
  private LinearLayout i;
  
  private PLVideoPageView j;
  
  private ViewGroup k;
  
  private LoadOptions l;
  
  private boolean m;
  
  private boolean n = false;
  
  private VideoPlayConfig o;
  
  private void l() {
    this.h = (ViewDragHelperLayout)this.g.findViewById(2131301640);
    this.i = (LinearLayout)this.g.findViewById(2131301608);
    this.k = (ViewGroup)this.g.findViewById(2131300142);
    LayoutInflater.from((Context)getActivity()).inflate(2131494022, this.k);
    this.j = (PLVideoPageView)this.k.findViewById(2131301607);
    this.h.setScrollDisable(this.o.r);
    if (this.o.r)
      this.h.setOnLayoutStateListener(this.d); 
  }
  
  private void m() {
    this.k.setVisibility(0);
    this.l = new LoadOptions();
    LoadOptions loadOptions = this.l;
    loadOptions.j = true;
    loadOptions.l = false;
    loadOptions.d = 2131099781;
    loadOptions.b = 2131099781;
    n();
  }
  
  private void n() {
    VideoPlayConfig videoPlayConfig1 = new VideoPlayConfig();
    videoPlayConfig1.a(this.o);
    videoPlayConfig1.h = this.e;
    videoPlayConfig1.j = true;
    videoPlayConfig1.n = true;
    VideoPlayConfig videoPlayConfig2 = this.o;
    if (videoPlayConfig2 != null)
      videoPlayConfig1.t = videoPlayConfig2.s; 
    this.j.b(videoPlayConfig1);
  }
  
  public boolean V_() {
    EventCallbackObserver.a().d();
    return true;
  }
  
  public void a() {
    if (getArguments() != null) {
      videoPlayConfig = (VideoPlayConfig)getArguments().getSerializable("video_config_data");
    } else {
      videoPlayConfig = null;
    } 
    this.o = videoPlayConfig;
    VideoPlayConfig videoPlayConfig = this.o;
    if (videoPlayConfig != null && !TextUtils.isEmpty(videoPlayConfig.b)) {
      if (!"http".contains(this.o.b)) {
        int[] arrayOfInt = Tools.c(this.o.b);
        this.o.a(arrayOfInt[0]);
        this.o.b(arrayOfInt[1]);
        return;
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(f);
      stringBuilder.append(" VideoDetailConfig is null || mConfigInfo.videoUrl == null");
      LogUtils.b(new Object[] { stringBuilder.toString() });
    } 
  }
  
  public boolean k() {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493351, paramViewGroup, false);
      StatusBarHelper.a((Activity)getActivity());
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    this.m = true;
    return this.g;
  }
  
  public void onDestroy() {
    super.onDestroy();
    PLVideoPageView pLVideoPageView = this.j;
    if (pLVideoPageView != null)
      pLVideoPageView.h(); 
  }
  
  public void onPause() {
    super.onPause();
    Log.v("drb", "onPause");
    this.j.g();
    if (k() && !this.n) {
      AudioManagerUtils.a().a(true);
      this.n = true;
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (getUserVisibleHint()) {
      if (k()) {
        this.n = false;
        AudioManagerUtils.a().b();
      } 
      this.j.f();
    } 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (this.m) {
      if (paramBoolean) {
        if (k()) {
          this.n = false;
          AudioManagerUtils.a().b();
        } 
        this.j.a(paramBoolean);
        m();
        this.j.c();
        return;
      } 
      this.j.a(paramBoolean);
      if (k() && !this.n) {
        AudioManagerUtils.a().a(true);
        this.n = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\AlbumVideoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
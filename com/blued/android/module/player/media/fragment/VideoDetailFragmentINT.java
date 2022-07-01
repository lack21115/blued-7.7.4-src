package com.blued.android.module.player.media.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.player.media.R;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.android.module.player.media.utils.Utils;
import com.blued.android.module.player.media.view.PLTextureVideoViewINT;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;

public class VideoDetailFragmentINT extends BaseFragment {
  private static final String f = VideoDetailFragmentINT.class.getSimpleName();
  
  ViewDragHelperLayout.OnLayoutStateListener d = new ViewDragHelperLayout.OnLayoutStateListener(this) {
      public void a() {
        if (this.a.getActivity() != null) {
          this.a.getActivity().finish();
          this.a.getActivity().overridePendingTransition(0, 0);
        } 
        EventCallbackObserver.a().b();
      }
      
      public void a(int param1Int) {
        VideoDetailFragmentINT.a(this.a).g();
        EventCallbackObserver.a().a(param1Int);
      }
      
      public void b() {
        if (!VideoDetailFragmentINT.a(this.a).j())
          VideoDetailFragmentINT.a(this.a).l(); 
        EventCallbackObserver.a().c();
      }
      
      public void c() {}
      
      public void d() {}
    };
  
  View.OnLongClickListener e = new View.OnLongClickListener(this) {
      public boolean onLongClick(View param1View) {
        EventCallbackObserver.a().a(new Object[] { (VideoDetailFragmentINT.b(this.a)).b, (VideoDetailFragmentINT.b(this.a)).a, Integer.valueOf(VideoDetailFragmentINT.b(this.a).a()), Integer.valueOf(VideoDetailFragmentINT.b(this.a).b()) });
        return false;
      }
    };
  
  private View g;
  
  private ViewDragHelperLayout h;
  
  private LinearLayout i;
  
  private PLTextureVideoViewINT j;
  
  private ViewGroup k;
  
  private LoadOptions l;
  
  private boolean m;
  
  private boolean n = false;
  
  private VideoPlayConfig o;
  
  private void l() {
    this.h = (ViewDragHelperLayout)this.g.findViewById(R.id.view_drag_layout);
    this.i = (LinearLayout)this.g.findViewById(R.id.video_view_layout);
    this.k = (ViewGroup)this.g.findViewById(R.id.surface_view);
    LayoutInflater.from((Context)getActivity()).inflate(R.layout.pl_media_video_int_layout, this.k);
    this.j = (PLTextureVideoViewINT)this.k.findViewById(R.id.video_view);
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
    loadOptions.d = R.color.black;
    this.l.b = R.color.black;
    n();
  }
  
  private void n() {
    if (this.o == null)
      return; 
    VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
    videoPlayConfig.a(this.o);
    videoPlayConfig.h = this.e;
    videoPlayConfig.j = true;
    videoPlayConfig.n = true;
    videoPlayConfig.t = this.o.s;
    this.j.b(videoPlayConfig);
  }
  
  public boolean V_() {
    EventCallbackObserver.a().d();
    return true;
  }
  
  protected void a() {
    if (getArguments() != null) {
      videoPlayConfig = (VideoPlayConfig)getArguments().getSerializable("video_config_data");
    } else {
      videoPlayConfig = null;
    } 
    this.o = videoPlayConfig;
    VideoPlayConfig videoPlayConfig = this.o;
    if (videoPlayConfig == null || TextUtils.isEmpty(videoPlayConfig.b)) {
      Log.b(f, " VideoDetailConfig is null || mConfigInfo.videoUrl == null");
      return;
    } 
    if (!"http".contains(this.o.b)) {
      int[] arrayOfInt = Utils.a(this.o.b);
      this.o.a(arrayOfInt[0]);
      this.o.b(arrayOfInt[1]);
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
      this.g = paramLayoutInflater.inflate(R.layout.fragment_video_detail, paramViewGroup, false);
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
    PLTextureVideoViewINT pLTextureVideoViewINT = this.j;
    if (pLTextureVideoViewINT != null)
      pLTextureVideoViewINT.h(); 
  }
  
  public void onPause() {
    super.onPause();
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\fragment\VideoDetailFragmentINT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
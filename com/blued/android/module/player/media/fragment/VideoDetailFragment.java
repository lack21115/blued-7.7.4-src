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
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.player.media.view.ViewDragHelperLayout;
import java.io.Serializable;

public class VideoDetailFragment extends BaseFragment {
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
        VideoDetailFragment.a(this.a).g();
        EventCallbackObserver.a().a(param1Int);
      }
      
      public void b() {
        if (!VideoDetailFragment.a(this.a).i())
          VideoDetailFragment.a(this.a).c(); 
        EventCallbackObserver.a().c();
      }
      
      public void c() {}
      
      public void d() {}
    };
  
  View.OnLongClickListener e = new View.OnLongClickListener(this) {
      public boolean onLongClick(View param1View) {
        EventCallbackObserver.a().a(new Object[] { (VideoDetailFragment.b(this.a)).b, (VideoDetailFragment.b(this.a)).a, Integer.valueOf(VideoDetailFragment.b(this.a).a()), Integer.valueOf(VideoDetailFragment.b(this.a).b()) });
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
  
  public static VideoDetailFragment a(VideoPlayConfig paramVideoPlayConfig) {
    if (paramVideoPlayConfig == null) {
      Log.b(f, " VideoDetailConfig is null");
      return null;
    } 
    VideoDetailFragment videoDetailFragment = new VideoDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("video_config_data", (Serializable)paramVideoPlayConfig);
    videoDetailFragment.setArguments(bundle);
    return videoDetailFragment;
  }
  
  private void m() {
    this.h = (ViewDragHelperLayout)this.g.findViewById(R.id.view_drag_layout);
    this.i = (LinearLayout)this.g.findViewById(R.id.video_view_layout);
    this.k = (ViewGroup)this.g.findViewById(R.id.surface_view);
    LayoutInflater.from((Context)getActivity()).inflate(R.layout.pl_media_video_layout_new, this.k);
    this.j = (PLVideoPageView)this.k.findViewById(R.id.video_view);
    this.h.setScrollDisable(this.o.r);
    if (this.o.r)
      this.h.setOnLayoutStateListener(this.d); 
  }
  
  private void n() {
    this.k.setVisibility(0);
    this.l = new LoadOptions();
    LoadOptions loadOptions = this.l;
    loadOptions.j = true;
    loadOptions.l = false;
    loadOptions.d = R.color.black;
    this.l.b = R.color.black;
    o();
  }
  
  private void o() {
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
  
  public PLVideoPageView k() {
    return this.j;
  }
  
  public boolean l() {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    n();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(R.layout.fragment_video_detail, paramViewGroup, false);
      StatusBarHelper.a((Activity)getActivity());
      a();
      m();
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
    this.j.g();
    if (l() && !this.n) {
      AudioManagerUtils.a().a(true);
      this.n = true;
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (getUserVisibleHint()) {
      if (l()) {
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
        if (l()) {
          this.n = false;
          AudioManagerUtils.a().b();
        } 
        this.j.a(paramBoolean);
        return;
      } 
      this.j.a(paramBoolean);
      if (l() && !this.n) {
        AudioManagerUtils.a().a(true);
        this.n = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\fragment\VideoDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
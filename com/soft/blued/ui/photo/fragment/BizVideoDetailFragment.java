package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.soft.blued.log.InstantLog;
import java.io.Serializable;

public class BizVideoDetailFragment extends VideoDetailFragment {
  public boolean f;
  
  private int g;
  
  private String h;
  
  private String i;
  
  public static BizVideoDetailFragment a(VideoPlayConfig paramVideoPlayConfig, int paramInt) {
    BizVideoDetailFragment bizVideoDetailFragment = new BizVideoDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("video_config_data", (Serializable)paramVideoPlayConfig);
    bundle.putInt("come_code", paramInt);
    bizVideoDetailFragment.setArguments(bundle);
    return bizVideoDetailFragment;
  }
  
  public static BizVideoDetailFragment a(VideoPlayConfig paramVideoPlayConfig, int paramInt, String paramString1, String paramString2) {
    BizVideoDetailFragment bizVideoDetailFragment = new BizVideoDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable("video_config_data", (Serializable)paramVideoPlayConfig);
    bundle.putString("key_feed_id", paramString1);
    bundle.putString("target_uid", paramString2);
    bundle.putInt("come_code", paramInt);
    bizVideoDetailFragment.setArguments(bundle);
    return bizVideoDetailFragment;
  }
  
  public static VideoPlayConfig m() {
    VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
    videoPlayConfig.p = true;
    videoPlayConfig.o = true;
    videoPlayConfig.q = false;
    videoPlayConfig.r = true;
    return videoPlayConfig;
  }
  
  public void a() {
    boolean bool;
    if (getArguments() != null) {
      bool = getArguments().getInt("come_code");
    } else {
      bool = false;
    } 
    this.g = bool;
    Bundle bundle = getArguments();
    String str2 = "";
    if (bundle != null) {
      str1 = getArguments().getString("key_feed_id");
    } else {
      str1 = "";
    } 
    this.h = str1;
    String str1 = str2;
    if (getArguments() != null)
      str1 = getArguments().getString("target_uid"); 
    this.i = str1;
    super.a();
  }
  
  public void n() {
    int i = this.g;
    if (i == 0 || i == 7 || i == 6 || i == 10)
      InstantLog.a("feed_video_play", Integer.valueOf(1)); 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    if (this.f)
      k().c(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    getActivity().getWindow().setFlags(128, 128);
    super.onCreate(paramBundle);
  }
  
  public void onResume() {
    n();
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.f = paramBoolean;
    if (paramBoolean && k() != null)
      k().c(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\BizVideoDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
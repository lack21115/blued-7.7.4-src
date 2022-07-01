package com.blued.android.module.player.media.model;

import android.view.View;
import com.tencent.rtmp.TXLiveBase;

public class VideoPlayConfig extends VideoBaseInfo {
  public static boolean d = false;
  
  private static int x = 1;
  
  private static int y = 1;
  
  public int e;
  
  public int f;
  
  public View.OnClickListener g;
  
  public View.OnLongClickListener h;
  
  public String i;
  
  public boolean j = false;
  
  public boolean k = true;
  
  public boolean l = false;
  
  public boolean m = true;
  
  public boolean n = false;
  
  public boolean o = false;
  
  public boolean p = true;
  
  public boolean q = false;
  
  public boolean r = true;
  
  public boolean s = true;
  
  public boolean t = true;
  
  public boolean u = false;
  
  public boolean v = false;
  
  public MediaInfo w;
  
  public VideoPlayConfig() {
    TXLiveBase.setLogLevel(0);
  }
  
  public static int c() {
    return x;
  }
  
  public static void c(int paramInt) {
    x = paramInt;
  }
  
  public void a(VideoPlayConfig paramVideoPlayConfig) {
    a(paramVideoPlayConfig);
    this.i = paramVideoPlayConfig.i;
    this.j = paramVideoPlayConfig.j;
    this.l = paramVideoPlayConfig.l;
    this.m = paramVideoPlayConfig.m;
    this.n = paramVideoPlayConfig.n;
    this.o = paramVideoPlayConfig.o;
    this.p = paramVideoPlayConfig.p;
    this.q = paramVideoPlayConfig.q;
    this.r = paramVideoPlayConfig.r;
    this.s = paramVideoPlayConfig.s;
    this.t = paramVideoPlayConfig.t;
    this.u = paramVideoPlayConfig.u;
    this.v = paramVideoPlayConfig.v;
    this.w = paramVideoPlayConfig.w;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\model\VideoPlayConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
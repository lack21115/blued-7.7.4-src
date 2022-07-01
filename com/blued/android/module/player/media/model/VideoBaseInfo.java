package com.blued.android.module.player.media.model;

import java.io.Serializable;

public class VideoBaseInfo implements Serializable {
  public String a;
  
  public String b;
  
  public long c = 0L;
  
  private int d;
  
  private int e;
  
  public int a() {
    return this.d;
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  public void a(VideoBaseInfo paramVideoBaseInfo) {
    this.a = paramVideoBaseInfo.a;
    this.b = paramVideoBaseInfo.b;
    this.d = paramVideoBaseInfo.d;
    this.e = paramVideoBaseInfo.e;
    this.c = paramVideoBaseInfo.c;
  }
  
  public int b() {
    return this.e;
  }
  
  public void b(int paramInt) {
    this.e = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\model\VideoBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.j.a;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.y.c;
import java.io.File;
import java.lang.ref.WeakReference;

class m implements a {
  private volatile WeakReference<j> a;
  
  private volatile WeakReference<l> b;
  
  private volatile String c;
  
  private volatile int d = -1;
  
  private c e;
  
  public void a() {}
  
  public void a(long paramLong1, long paramLong2, int paramInt) {
    ak.b("gdt_tag_reward_video", "onProgress(%d,%d,%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (this.b != null) {
      l l = this.b.get();
      if (l != null)
        l.a(paramLong1, paramLong2, paramInt, this.c); 
    } 
  }
  
  public void a(long paramLong, boolean paramBoolean) {
    this.d = (int)(paramLong >> 10L);
  }
  
  public void a(c paramc) {
    ak.b("gdt_tag_reward_video", "onFailed(%s)", new Object[] { paramc });
    if (this.b != null) {
      l l = this.b.get();
      if (l != null)
        l.f(); 
    } 
    if (this.a != null) {
      j j = this.a.get();
      if (j != null)
        j.a(this.c, paramc); 
    } 
  }
  
  public void a(j paramj) {
    this.a = new WeakReference<j>(paramj);
  }
  
  public void a(l paraml) {
    this.b = new WeakReference<l>(paraml);
  }
  
  public void a(c paramc) {
    this.e = paramc;
  }
  
  public void a(File paramFile, long paramLong) {
    ak.a("gdt_tag_reward_video", "onCompleted");
    if (this.b != null) {
      l l = this.b.get();
      if (l != null)
        l.d(); 
    } 
    if (this.a != null) {
      j j = this.a.get();
      if (j != null)
        j.c(); 
    } 
    bc.a(paramLong, this.d, this.c, this.e);
  }
  
  public void a(String paramString) {
    this.c = paramString;
  }
  
  public void b() {}
  
  public void c() {
    ak.a("gdt_tag_reward_video", "onCanceled");
    if (this.b != null) {
      l l = this.b.get();
      if (l != null)
        l.e(); 
    } 
    if (this.a != null) {
      j j = this.a.get();
      if (j != null)
        j.a(this.c); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
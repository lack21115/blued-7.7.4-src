package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import android.content.res.AssetFileDescriptor;
import com.qiniu.pili.droid.shortvideo.f.g;

public class a {
  private String a;
  
  private AssetFileDescriptor b;
  
  private d c = new d(0L, 0L);
  
  private c d = new c(1.0F, 1.0F);
  
  private int e = 0;
  
  private boolean f = true;
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public void a(AssetFileDescriptor paramAssetFileDescriptor) {
    this.b = paramAssetFileDescriptor;
    this.a = null;
    this.c = new d(0L, g.a(this.b));
  }
  
  public void a(c paramc) {
    this.d = paramc;
  }
  
  public void a(d paramd) {
    this.c = paramd;
  }
  
  public void a(String paramString) {
    this.a = paramString;
    this.b = null;
    this.c = new d(0L, g.a(this.a));
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public boolean b() {
    return this.f;
  }
  
  public AssetFileDescriptor c() {
    return this.b;
  }
  
  public boolean d() {
    return (this.b != null);
  }
  
  public d e() {
    return this.c;
  }
  
  public c f() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\transcoder\audio\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
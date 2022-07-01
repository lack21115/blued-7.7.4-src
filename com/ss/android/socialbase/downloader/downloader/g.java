package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.i.d;
import com.ss.android.socialbase.downloader.i.f;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class g {
  private final Context a;
  
  private k b;
  
  private l c;
  
  private int d;
  
  private i e;
  
  private ac f;
  
  private f g;
  
  private d h;
  
  private m i;
  
  private ExecutorService j;
  
  private ExecutorService k;
  
  private ExecutorService l;
  
  private ExecutorService m;
  
  private int n;
  
  private h o;
  
  private boolean p;
  
  private q q;
  
  private int r = 1023409663;
  
  private JSONObject s;
  
  public g(Context paramContext) {
    this.a = paramContext;
  }
  
  public Context a() {
    return this.a;
  }
  
  public g a(int paramInt) {
    this.r = paramInt;
    return this;
  }
  
  public g a(f paramf) {
    this.g = paramf;
    return this;
  }
  
  public g a(JSONObject paramJSONObject) {
    this.s = paramJSONObject;
    return this;
  }
  
  public k b() {
    return this.b;
  }
  
  public l c() {
    return this.c;
  }
  
  public f d() {
    return this.g;
  }
  
  public d e() {
    return this.h;
  }
  
  public m f() {
    return this.i;
  }
  
  public ExecutorService g() {
    return this.j;
  }
  
  public ExecutorService h() {
    return this.k;
  }
  
  public ExecutorService i() {
    return this.l;
  }
  
  public ExecutorService j() {
    return this.m;
  }
  
  public int k() {
    return this.d;
  }
  
  public i l() {
    return this.e;
  }
  
  public h m() {
    return this.o;
  }
  
  public int n() {
    return this.n;
  }
  
  public boolean o() {
    return this.p;
  }
  
  public q p() {
    return this.q;
  }
  
  public int q() {
    return this.r;
  }
  
  public ac r() {
    return this.f;
  }
  
  public JSONObject s() {
    return this.s;
  }
  
  public f t() {
    return new f(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
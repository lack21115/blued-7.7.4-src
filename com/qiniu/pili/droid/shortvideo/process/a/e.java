package com.qiniu.pili.droid.shortvideo.process.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoMixItem;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.gl.c.a;
import com.qiniu.pili.droid.shortvideo.gl.c.d;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import java.io.IOException;

public class e {
  private static String a = "VideoMixItemExtractor";
  
  private SurfaceTexture b;
  
  private Surface c;
  
  private int d;
  
  private b.c e;
  
  private PLVideoMixItem f;
  
  private float[] g = new float[16];
  
  private b h;
  
  private MediaExtractor i;
  
  private a j;
  
  private k k;
  
  private d l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  public e(PLVideoMixItem paramPLVideoMixItem, int paramInt1, int paramInt2) {
    this.f = paramPLVideoMixItem;
    Rect rect = paramPLVideoMixItem.getVideoRect();
    this.o = rect.width();
    this.p = rect.height();
    float f1 = rect.left / paramInt1;
    float f2 = (paramInt2 - rect.bottom) / paramInt2;
    this.l = new d(this.o, this.p);
    this.l.b(f1, f2);
    this.l.a(true);
    this.l.a(1.0F);
    this.l.b(true);
    this.l.a(paramInt1, paramInt2);
    this.l.b();
    this.m = g.b(this.f.getVideoPath());
    this.n = g.c(this.f.getVideoPath());
    this.d = d.c();
    this.b = new SurfaceTexture(this.d);
    this.c = new Surface(this.b);
    this.i = new MediaExtractor();
    try {
      this.i.setDataSource(paramPLVideoMixItem.getVideoPath());
      return;
    } catch (IOException iOException) {
      com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.g;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sample media extractor setDataSource error , path is : ");
      stringBuilder.append(paramPLVideoMixItem.getVideoPath());
      e1.e(str, stringBuilder.toString());
      return;
    } 
  }
  
  private void f() {
    if (this.j == null) {
      this.j = new a();
      this.j.a(this.m, this.n);
      this.j.b();
    } 
  }
  
  private void g() {
    if (this.k == null) {
      this.k = new k();
      this.k.a(this.o, this.p);
      int i = j.b(g.d(this.f.getVideoPath()));
      if (i == 90 || i == 270) {
        this.k.a(this.n, this.m, this.f.getDisplayMode());
        return;
      } 
      this.k.a(this.m, this.n, this.f.getDisplayMode());
      return;
    } 
  }
  
  public int a(int paramInt, boolean paramBoolean) {
    com.qiniu.pili.droid.shortvideo.f.e e1;
    int i = c();
    d d1 = this.l;
    if (d1 == null) {
      e1 = com.qiniu.pili.droid.shortvideo.f.e.g;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sticker is null : ");
      stringBuilder.append(this.f.getVideoPath());
      e1.e(str, stringBuilder.toString());
      return paramInt;
    } 
    return e1.a(paramInt, i, paramBoolean);
  }
  
  public void a() {
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.g;
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start : ");
    stringBuilder.append(this.f.getVideoPath());
    e1.c(str, stringBuilder.toString());
    int i = g.b(this.i, "video/");
    if (i >= 0) {
      this.i.selectTrack(i);
      MediaExtractor mediaExtractor = this.i;
      this.h = new b(mediaExtractor, mediaExtractor.getTrackFormat(i));
      this.h.a(this.c);
      this.h.a(this.f.isLooping());
      this.h.a(new b.b(this) {
            public void a() {
              this.a.e();
            }
          });
    } 
    this.h.a(this.e);
    this.h.a();
  }
  
  public void a(b.c paramc) {
    this.e = paramc;
  }
  
  public b.c b() {
    return this.e;
  }
  
  public int c() {
    f();
    g();
    try {
      this.b.updateTexImage();
      this.b.getTransformMatrix(this.g);
      int i = this.j.b(this.d, this.g);
      return this.k.a(i);
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public void d() {
    if (this.h != null) {
      com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.g;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stop : ");
      stringBuilder.append(this.f.getVideoPath());
      e1.c(str, stringBuilder.toString());
      this.h.c();
      this.h = null;
    } 
  }
  
  public void e() {
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.g;
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("release : ");
    stringBuilder.append(this.f.getVideoPath());
    e1.c(str, stringBuilder.toString());
    SurfaceTexture surfaceTexture = this.b;
    if (surfaceTexture != null) {
      surfaceTexture.release();
      this.b = null;
    } 
    Surface surface = this.c;
    if (surface != null) {
      surface.release();
      this.c = null;
    } 
    MediaExtractor mediaExtractor = this.i;
    if (mediaExtractor != null) {
      mediaExtractor.release();
      this.i = null;
    } 
    a a1 = this.j;
    if (a1 != null) {
      a1.f();
      this.j = null;
    } 
    k k1 = this.k;
    if (k1 != null) {
      k1.f();
      this.k = null;
    } 
    d d1 = this.l;
    if (d1 != null) {
      d1.f();
      this.l = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
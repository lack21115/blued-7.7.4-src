package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.shortvideo.PLBuiltinFilter;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLEffectPlugin;
import com.qiniu.pili.droid.shortvideo.PLGifWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.PLImageView;
import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.PLPaintView;
import com.qiniu.pili.droid.shortvideo.PLSpeedTimeRange;
import com.qiniu.pili.droid.shortvideo.PLTextView;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoPlayerListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.e.b;
import com.qiniu.pili.droid.shortvideo.e.c;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.gl.c.d;
import com.qiniu.pili.droid.shortvideo.process.a.d;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.c;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.d;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class m implements MediaPlayer.OnCompletionListener, PLVideoFilterListener {
  private List<a> A;
  
  private int B;
  
  private int C;
  
  private GLSurfaceView D;
  
  private boolean E;
  
  private int F;
  
  private int G;
  
  private int H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private boolean L;
  
  private long M;
  
  private PLVideoEncodeSetting N;
  
  private PLWatermarkSetting O;
  
  private PLWatermarkSetting P;
  
  private c Q;
  
  protected double a;
  
  List<PLSpeedTimeRange> b;
  
  private Context c;
  
  private int d;
  
  private int e;
  
  private b f;
  
  private com.qiniu.pili.droid.shortvideo.e.a g;
  
  private d h;
  
  private Object i;
  
  private PLVideoFilterListener j;
  
  private PLVideoSaveListener k;
  
  private PLVideoPlayerListener l;
  
  private PLEffectPlugin m;
  
  private PLVideoEditSetting n;
  
  private com.qiniu.pili.droid.shortvideo.transcoder.audio.a o;
  
  private volatile boolean p;
  
  private boolean q;
  
  private boolean r;
  
  private boolean s;
  
  private float t;
  
  private float u;
  
  private float v;
  
  private q w;
  
  private long x;
  
  private long y;
  
  private ViewGroup z;
  
  public m(GLSurfaceView paramGLSurfaceView) {
    this.n = new PLVideoEditSetting();
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = true;
    this.t = 1.0F;
    this.u = 1.0F;
    this.v = 1.0F;
    this.A = new LinkedList<a>();
    this.a = 1.0D;
    e.e.c("ShortVideoEditorCore", "init without PLVideoEditSetting +");
    this.c = paramGLSurfaceView.getContext().getApplicationContext();
    l.a(this.c);
    this.D = paramGLSurfaceView;
    this.f = new b(paramGLSurfaceView);
    this.h = new d(this.c);
    this.f.a(this);
    this.f.a(this);
    e.e.c("ShortVideoEditorCore", "init without PLVideoEditSetting -");
  }
  
  public m(GLSurfaceView paramGLSurfaceView, PLVideoEditSetting paramPLVideoEditSetting) {
    File file;
    this.n = new PLVideoEditSetting();
    this.p = false;
    this.q = false;
    this.r = false;
    this.s = true;
    this.t = 1.0F;
    this.u = 1.0F;
    this.v = 1.0F;
    this.A = new LinkedList<a>();
    this.a = 1.0D;
    e.e.c("ShortVideoEditorCore", "init +");
    this.c = paramGLSurfaceView.getContext().getApplicationContext();
    l.a(this.c);
    this.D = paramGLSurfaceView;
    this.n = paramPLVideoEditSetting;
    this.f = new b(paramGLSurfaceView);
    this.f.a(this.n.getSourceFilepath());
    this.f.a(this);
    this.f.a(this);
    this.h = new d(this.c);
    this.h.a(this.n.isGifPreviewEnabled());
    String str = this.n.getDestFilepath();
    if (str == null) {
      file = this.c.getFilesDir();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pl-edited-");
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(".mp4");
      file = new File(file, stringBuilder.toString());
      this.n.setDestFilepath(file.getAbsolutePath());
    } else {
      this.n.setDestFilepath(l.a(this.c, (String)file));
    } 
    this.M = g.a(this.n.getSourceFilepath());
    e.e.c("ShortVideoEditorCore", "init -");
  }
  
  private void a(Object paramObject) {
    if (this.o == null)
      this.o = new com.qiniu.pili.droid.shortvideo.transcoder.audio.a(); 
    if (paramObject instanceof String) {
      this.o.a((String)paramObject);
    } else {
      this.o.a((AssetFileDescriptor)paramObject);
    } 
    this.o.a(this.s);
    if (this.g == null)
      this.g = new com.qiniu.pili.droid.shortvideo.e.a(); 
    if (this.o.d()) {
      this.g.a(this.o.c());
    } else {
      this.g.a(this.o.a());
    } 
    this.g.a(this.s);
    this.g.a(this.u);
    this.o.a(this.g.a());
    if (this.q) {
      j();
      this.f.b(0);
    } 
    a(this.t, this.u);
  }
  
  private void b(View paramView) {
    b(paramView, 0L, this.M);
  }
  
  private void b(View paramView, long paramLong1, long paramLong2) {
    if (paramView == null) {
      e.e.d("ShortVideoEditorCore", "addView failed : view is null");
      return;
    } 
    if (this.D.getParent() instanceof ViewGroup) {
      if (this.z == null)
        this.z = (ViewGroup)this.D.getParent(); 
      a a1 = new a(this, paramView, paramLong1, paramLong2);
      if (paramView instanceof PLPaintView) {
        this.z.addView(paramView);
        this.A.add(a1);
        return;
      } 
      ViewGroup viewGroup = this.z;
      viewGroup.addView(paramView, viewGroup.getChildCount() - this.d);
      List<a> list = this.A;
      list.add(list.size() - this.d, a1);
      return;
    } 
    throw new IllegalStateException("GLSurfaceView does not have a parent, it cannot be root view!");
  }
  
  private void b(PLVideoSaveListener paramPLVideoSaveListener) {
    if (this.E)
      this.f.e(); 
    this.w.a(this.a);
    List<PLSpeedTimeRange> list = this.b;
    if (list != null)
      this.w.a(list); 
    if (this.h.e() != null) {
      int i = g.e(this.h.e());
      this.w.a(this.F, this.G, i, paramPLVideoSaveListener);
      return;
    } 
    this.w.a(paramPLVideoSaveListener);
  }
  
  private a c(View paramView) {
    for (a a1 : this.A) {
      if (a1.a() == paramView)
        return a1; 
    } 
    return null;
  }
  
  private void c(PLMixAudioFile paramPLMixAudioFile) {
    this.Q.c(paramPLMixAudioFile);
    this.f.a(paramPLMixAudioFile.getVolume());
  }
  
  private void d(View paramView) {
    if (this.z == null || paramView == null) {
      e.e.d("ShortVideoEditorCore", "group or view is null, cannot remove.");
      return;
    } 
    a a1 = c(paramView);
    if (a1 != null) {
      this.A.remove(a1);
      this.z.removeView(paramView);
      return;
    } 
    e.e.d("ShortVideoEditorCore", "removeView failed : view is not find , it must be added first!");
  }
  
  private void j() {
    e.e.c("ShortVideoEditorCore", "startAudioPlayback +");
    if (this.o == null)
      return; 
    this.g.b();
    c c1 = this.Q;
    if (c1 != null)
      c1.a(b()); 
    e.e.c("ShortVideoEditorCore", "startAudioPlayback -");
  }
  
  private void k() {
    e.e.c("ShortVideoEditorCore", "resumeAudioPlayback +");
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null)
      a1.f(); 
    c c1 = this.Q;
    if (c1 != null)
      c1.b(b()); 
    e.e.c("ShortVideoEditorCore", "resumeAudioPlayback -");
  }
  
  private void l() {
    e.e.c("ShortVideoEditorCore", "pauseAudioPlayback +");
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null)
      a1.e(); 
    c c1 = this.Q;
    if (c1 != null)
      c1.d(); 
    e.e.c("ShortVideoEditorCore", "pauseAudioPlayback -");
  }
  
  private void m() {
    e.e.c("ShortVideoEditorCore", "stopAudioPlayback +");
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null)
      a1.d(); 
    c c1 = this.Q;
    if (c1 != null)
      c1.e(); 
    e.e.c("ShortVideoEditorCore", "stopAudioPlayback -");
  }
  
  private void n() {
    Iterator<a> iterator = this.A.iterator();
    while (iterator.hasNext()) {
      View view = ((a)iterator.next()).a();
      if (view instanceof PLTextView && ((PLTextView)view).getText().toString().isEmpty()) {
        iterator.remove();
        this.z.removeView(view);
      } 
    } 
  }
  
  private boolean o() {
    c c1 = this.Q;
    return (c1 != null && c1.b() >= 2);
  }
  
  private void p() {
    for (a a1 : this.A) {
      a1.a().post(new Runnable(this, a1) {
            public void run() {
              byte b;
              if (this.a.a(m.d(this.b).i())) {
                b = 0;
              } else {
                b = 4;
              } 
              this.a.a().setVisibility(b);
            }
          });
    } 
  }
  
  public Bitmap a(View paramView) {
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    paramView.draw(canvas);
    return bitmap;
  }
  
  public void a() {
    e.e.c("ShortVideoEditorCore", "resumePlayback +");
    this.q = true;
    this.f.c();
    k();
    e.e.c("ShortVideoEditorCore", "resumePlayback -");
  }
  
  public void a(double paramDouble) {
    a(paramDouble, false);
  }
  
  public void a(double paramDouble, boolean paramBoolean) {
    if (!u.a().a(b.a.I))
      return; 
    if (j.a(paramDouble)) {
      this.a = paramDouble;
      if (this.b != null) {
        this.b = null;
        e.e.c("ShortVideoEditorCore", "reset speedTimeRanges to null! ");
      } 
      if (paramBoolean)
        this.f.a(paramDouble); 
      e e = e.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set speed to: ");
      stringBuilder.append(paramDouble);
      e.c("ShortVideoEditorCore", stringBuilder.toString());
      return;
    } 
    e.e.d("ShortVideoEditorCore", "only support multiple of 2 !!!");
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioMixVolume: ");
    stringBuilder.append(paramFloat1);
    stringBuilder.append(", ");
    stringBuilder.append(paramFloat2);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    this.t = paramFloat1;
    this.u = paramFloat2;
    com.qiniu.pili.droid.shortvideo.transcoder.audio.a a2 = this.o;
    if (a2 != null) {
      a2.a(new c(paramFloat1, paramFloat2));
    } else {
      boolean bool;
      if (paramFloat1 == 0.0F) {
        bool = true;
      } else {
        bool = false;
      } 
      this.r = bool;
    } 
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null)
      a1.a(paramFloat2); 
    this.f.a(paramFloat1);
    e.e.c("ShortVideoEditorCore", "setAudioMixVolume -");
  }
  
  public void a(int paramInt) {
    e.e.c("ShortVideoEditorCore", "seekTo +");
    this.f.b(paramInt);
    if (this.g != null) {
      com.qiniu.pili.droid.shortvideo.transcoder.audio.a a1 = this.o;
      if (a1 != null && a1.e() != null) {
        this.g.a(paramInt + this.o.e().a());
      } else {
        this.g.a(paramInt);
      } 
    } 
    c c1 = this.Q;
    if (c1 != null)
      c1.a(paramInt); 
    e.e.c("ShortVideoEditorCore", "seekTo -");
  }
  
  public void a(long paramLong1, long paramLong2) {
    if (paramLong1 < 0L || paramLong2 <= paramLong1) {
      e.e.e("ShortVideoEditorCore", "beginMs must not smaller than 0, endMs must bigger than 0 and beginMs");
      return;
    } 
    this.x = paramLong1;
    this.y = paramLong2;
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set range to: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append("-");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" duration: ");
    stringBuilder.append(paramLong2 - paramLong1);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
  }
  
  public void a(AssetFileDescriptor paramAssetFileDescriptor) {
    if (!u.a().a(b.a.M))
      return; 
    e.e.c("ShortVideoEditorCore", "setAudioMixAsset +");
    if (paramAssetFileDescriptor == null) {
      g();
      return;
    } 
    a(paramAssetFileDescriptor);
    e.e.c("ShortVideoEditorCore", "setAudioMixAsset -");
  }
  
  public void a(View paramView, long paramLong1, long paramLong2) {
    e.e.c("ShortVideoEditorCore", "setViewTimeline +");
    if (paramView == null) {
      e.e.d("ShortVideoEditorCore", "setViewTimeline failed : view is null");
      return;
    } 
    a a1 = c(paramView);
    if (a1 != null) {
      a1.b(paramLong1);
      a1.c(paramLong2);
      e e = e.h;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set view start time : ");
      stringBuilder.append(paramLong1);
      stringBuilder.append(" duration : ");
      stringBuilder.append(paramLong2);
      e.c("ShortVideoEditorCore", stringBuilder.toString());
    } else {
      e.e.d("ShortVideoEditorCore", "setViewTimeline failed : view is not find , it must be added first!");
    } 
    e.e.c("ShortVideoEditorCore", "setViewTimeline -");
  }
  
  public void a(PLDisplayMode paramPLDisplayMode) {
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setDisplayMode :");
    stringBuilder.append(paramPLDisplayMode);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    this.f.a(paramPLDisplayMode);
  }
  
  public void a(PLEffectPlugin paramPLEffectPlugin) {
    this.m = paramPLEffectPlugin;
  }
  
  public void a(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    if (!u.a().a(b.a.G))
      return; 
    e.e.c("ShortVideoEditorCore", "addGifWatermark +");
    this.h.a(paramPLGifWatermarkSetting);
    e.e.c("ShortVideoEditorCore", "addGifWatermark -");
  }
  
  public void a(PLImageView paramPLImageView) {
    if (!u.a().a(b.a.G))
      return; 
    e.e.c("ShortVideoEditorCore", "addImageView +");
    b((View)paramPLImageView);
    e.e.c("ShortVideoEditorCore", "addImageView -");
  }
  
  public void a(PLMixAudioFile paramPLMixAudioFile) {
    e.e.c("ShortVideoEditorCore", "removeMixAudioFile +");
    c c1 = this.Q;
    if (c1 != null)
      c1.b(paramPLMixAudioFile); 
    e.e.c("ShortVideoEditorCore", "removeMixAudioFile -");
  }
  
  public void a(PLPaintView paramPLPaintView) {
    if (!u.a().a(b.a.L))
      return; 
    e.e.c("ShortVideoEditorCore", "addPaintView +");
    b((View)paramPLPaintView);
    this.d++;
    e.e.c("ShortVideoEditorCore", "addPaintView -");
  }
  
  public void a(PLTextView paramPLTextView) {
    if (!u.a().a(b.a.J))
      return; 
    e.e.c("ShortVideoEditorCore", "addTextView +");
    b((View)paramPLTextView);
    e.e.c("ShortVideoEditorCore", "addTextView -");
  }
  
  public void a(PLVideoEditSetting paramPLVideoEditSetting) {
    File file;
    if (this.n != null) {
      this.f.b(paramPLVideoEditSetting.getSourceFilepath());
      e.e.c("ShortVideoEditorCore", "reset PLVideoEditSetting");
    } 
    this.n = paramPLVideoEditSetting;
    this.h.a(this.n.isGifPreviewEnabled());
    this.f.a(this.n.getSourceFilepath());
    String str = this.n.getDestFilepath();
    if (str == null) {
      file = this.c.getFilesDir();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pl-edited-");
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(".mp4");
      file = new File(file, stringBuilder.toString());
      this.n.setDestFilepath(file.getAbsolutePath());
    } else {
      this.n.setDestFilepath(l.a(this.c, (String)file));
    } 
    this.M = g.a(this.n.getSourceFilepath());
    e.e.c("ShortVideoEditorCore", "set PLVideoEditSetting success");
    if (this.q) {
      this.f.a();
      j();
    } 
  }
  
  public void a(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.N = paramPLVideoEncodeSetting;
  }
  
  public void a(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    e.e.c("ShortVideoEditorCore", "startPlayback +");
    PLVideoEditSetting pLVideoEditSetting = this.n;
    if (pLVideoEditSetting != null) {
      if (pLVideoEditSetting.getSourceFilepath() != null) {
        this.q = true;
        this.j = paramPLVideoFilterListener;
        this.f.a(paramBoolean);
        this.f.a();
        j();
        e.e.c("ShortVideoEditorCore", "startPlayback -");
        return;
      } 
      throw new IllegalStateException("not set source filepath !");
    } 
    throw new IllegalStateException("not set PLVideoEditSetting !");
  }
  
  public void a(PLVideoPlayerListener paramPLVideoPlayerListener) {
    this.l = paramPLVideoPlayerListener;
  }
  
  public void a(PLVideoSaveListener paramPLVideoSaveListener) {
    this.k = paramPLVideoSaveListener;
  }
  
  public void a(PLWatermarkSetting paramPLWatermarkSetting) {
    if (!u.a().a(b.a.H))
      return; 
    e.e.c("ShortVideoEditorCore", "setWatermark +");
    this.h.a(paramPLWatermarkSetting);
    e.e.c("ShortVideoEditorCore", "setWatermark -");
  }
  
  public void a(String paramString) {
    if (!u.a().a(b.a.M))
      return; 
    e.e.c("ShortVideoEditorCore", "setAudioMixFile +");
    if (paramString == null || paramString.isEmpty()) {
      g();
      return;
    } 
    a(paramString);
    e.e.c("ShortVideoEditorCore", "setAudioMixFile -");
  }
  
  public void a(String paramString1, String paramString2) {
    if (!u.a().a(b.a.K))
      return; 
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMVEffect mv file: ");
    stringBuilder.append(paramString1);
    stringBuilder.append(", mask file: ");
    stringBuilder.append(paramString2);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    this.I = paramString1;
    this.J = paramString2;
    this.F = 0;
    this.G = 0;
    this.H = 0;
    if (paramString1 != null) {
      this.F = g.b(paramString1);
      this.G = g.c(paramString1);
      this.H = g.d(paramString1);
    } 
    this.h.a(paramString1, paramString2, this.F, this.G);
    this.f.a(this.F, this.G);
    e.e.c("ShortVideoEditorCore", "setMVEffect -");
  }
  
  public void a(String paramString, boolean paramBoolean) {
    if (!u.a().a(b.a.Q))
      return; 
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setFilter: ");
    stringBuilder.append(paramString);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    this.K = paramString;
    this.L = paramBoolean;
    this.h.a(paramString, paramBoolean);
    e.e.c("ShortVideoEditorCore", "setFilter -");
  }
  
  public void a(List<PLSpeedTimeRange> paramList) {
    if (!u.a().a(b.a.I))
      return; 
    this.b = paramList;
    this.a = 1.0D;
    e.e.c("ShortVideoEditorCore", "setSpeedTimeRanges : reset mSpeed to 1.0 ");
  }
  
  public void a(boolean paramBoolean) {
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPlaybackLoop: ");
    stringBuilder.append(paramBoolean);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    this.f.b(paramBoolean);
  }
  
  public int b() {
    e.e.b("ShortVideoEditorCore", "getCurrentPosition");
    return this.f.i();
  }
  
  public void b(int paramInt) {
    if (!u.a().a(b.a.O))
      return; 
    if (!j.a(paramInt)) {
      e.e.e("ShortVideoEditorCore", "rotate must be 0, (-)90, (-)180, (-)270");
      return;
    } 
    if (this.e == paramInt) {
      e.e.c("ShortVideoEditorCore", "already in target rotation !");
      return;
    } 
    this.e = paramInt;
    this.f.a(paramInt);
    paramInt = this.F;
    if (paramInt != 0) {
      this.h.a(this.I, this.J, paramInt, this.G);
      this.f.a(this.F, this.G);
    } 
    String str = this.K;
    if (str != null)
      this.h.a(str, this.L); 
  }
  
  public void b(long paramLong1, long paramLong2) {
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioMixFileRange: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(", ");
    stringBuilder.append(paramLong2);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    if (this.o != null) {
      if (this.g == null)
        return; 
      d d1 = new d(paramLong1, paramLong2);
      this.o.a(d1);
      this.g.a(d1);
      if (this.q) {
        this.f.b(0);
        this.g.a(paramLong1);
      } 
      e.e.c("ShortVideoEditorCore", "setAudioMixFileRange -");
    } 
  }
  
  public void b(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    if (!u.a().a(b.a.G))
      return; 
    e.e.c("ShortVideoEditorCore", "removeGifWatermark +");
    this.h.b(paramPLGifWatermarkSetting);
    e.e.c("ShortVideoEditorCore", "removeGifWatermark -");
  }
  
  public void b(PLImageView paramPLImageView) {
    e.e.c("ShortVideoEditorCore", "removeImageView +");
    d((View)paramPLImageView);
    e.e.c("ShortVideoEditorCore", "removeImageView -");
  }
  
  public void b(PLMixAudioFile paramPLMixAudioFile) {
    boolean bool;
    if (!u.a().a(b.a.N))
      return; 
    e.e.c("ShortVideoEditorCore", "addMixAudioFile +");
    if (this.Q == null)
      this.Q = new c(); 
    if (this.n.getSourceFilepath().compareTo(paramPLMixAudioFile.getFilepath()) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      c(paramPLMixAudioFile);
    } else {
      if (this.Q.a() == null)
        try {
          c(new PLMixAudioFile(this.n.getSourceFilepath()));
          e.e.d("ShortVideoEditorCore", "no main audio file yet, create a default main audio file");
        } catch (IOException iOException) {
          e e1 = e.e;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("create main audio file failed : ");
          stringBuilder1.append(iOException.getMessage());
          e1.e("ShortVideoEditorCore", stringBuilder1.toString());
          return;
        }  
      this.Q.a((PLMixAudioFile)iOException);
    } 
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("add mix audio file : the file path is ");
    stringBuilder.append(iOException.getFilepath());
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    e.e.c("ShortVideoEditorCore", "addMixAudioFile -");
  }
  
  public void b(PLPaintView paramPLPaintView) {
    e.e.c("ShortVideoEditorCore", "removePaintView +");
    d((View)paramPLPaintView);
    this.d--;
    e.e.c("ShortVideoEditorCore", "removePaintView -");
  }
  
  public void b(PLTextView paramPLTextView) {
    e.e.c("ShortVideoEditorCore", "removeTextView +");
    d((View)paramPLTextView);
    e.e.c("ShortVideoEditorCore", "removeTextView -");
  }
  
  public void b(PLVideoFilterListener paramPLVideoFilterListener, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.e : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortVideoEditorCore'
    //   7: ldc_w 'save +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield p : Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifeq -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/u;
    //   28: invokevirtual b : ()Z
    //   31: ifne -> 72
    //   34: getstatic com/qiniu/pili/droid/shortvideo/f/e.b : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   37: ldc_w 'unauthorized !'
    //   40: invokevirtual d : (Ljava/lang/String;)V
    //   43: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   46: bipush #8
    //   48: invokevirtual a : (I)V
    //   51: aload_0
    //   52: getfield k : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   55: ifnull -> 69
    //   58: aload_0
    //   59: getfield k : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   62: bipush #8
    //   64: invokeinterface onSaveVideoFailed : (I)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield p : Z
    //   77: aload_0
    //   78: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   81: invokevirtual b : ()Z
    //   84: ifne -> 189
    //   87: aload_0
    //   88: getfield o : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/a;
    //   91: ifnonnull -> 189
    //   94: aload_1
    //   95: ifnonnull -> 189
    //   98: aload_0
    //   99: getfield A : Ljava/util/List;
    //   102: invokeinterface isEmpty : ()Z
    //   107: ifeq -> 189
    //   110: aload_0
    //   111: getfield r : Z
    //   114: ifne -> 189
    //   117: aload_0
    //   118: getfield a : D
    //   121: dconst_1
    //   122: dcmpl
    //   123: ifne -> 189
    //   126: aload_0
    //   127: invokespecial o : ()Z
    //   130: ifne -> 189
    //   133: aload_0
    //   134: getfield b : Ljava/util/List;
    //   137: ifnonnull -> 189
    //   140: aload_0
    //   141: getfield e : I
    //   144: ifne -> 189
    //   147: getstatic com/qiniu/pili/droid/shortvideo/f/e.e : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   150: ldc 'ShortVideoEditorCore'
    //   152: ldc_w 'no filter, mv, watermark, speed, mixed audio selected, text effect, rotation, and no external listener, return the original file.'
    //   155: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_0
    //   159: getfield k : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   162: ifnull -> 181
    //   165: aload_0
    //   166: getfield k : Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;
    //   169: aload_0
    //   170: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLVideoEditSetting;
    //   173: invokevirtual getSourceFilepath : ()Ljava/lang/String;
    //   176: invokeinterface onSaveVideoSuccess : (Ljava/lang/String;)V
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield p : Z
    //   186: aload_0
    //   187: monitorexit
    //   188: return
    //   189: aload_0
    //   190: new com/qiniu/pili/droid/shortvideo/core/q
    //   193: dup
    //   194: aload_0
    //   195: getfield c : Landroid/content/Context;
    //   198: aload_0
    //   199: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLVideoEditSetting;
    //   202: invokevirtual getSourceFilepath : ()Ljava/lang/String;
    //   205: aload_0
    //   206: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLVideoEditSetting;
    //   209: invokevirtual getDestFilepath : ()Ljava/lang/String;
    //   212: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   215: putfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   218: aload_0
    //   219: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   222: aload_0
    //   223: getfield N : Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;
    //   226: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;)V
    //   229: aload_0
    //   230: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   233: aload_0
    //   234: getfield o : Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/a;
    //   237: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/transcoder/audio/a;)V
    //   240: aload_0
    //   241: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   244: aload_0
    //   245: getfield r : Z
    //   248: invokevirtual a : (Z)V
    //   251: aload_0
    //   252: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   255: aload_0
    //   256: getfield e : I
    //   259: invokevirtual a : (I)V
    //   262: aload_0
    //   263: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   266: aload_0
    //   267: getfield i : Ljava/lang/Object;
    //   270: invokevirtual a : (Ljava/lang/Object;)V
    //   273: aload_0
    //   274: invokespecial o : ()Z
    //   277: ifeq -> 294
    //   280: aload_0
    //   281: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   284: aload_0
    //   285: getfield Q : Lcom/qiniu/pili/droid/shortvideo/e/c;
    //   288: invokevirtual c : ()Ljava/util/List;
    //   291: invokevirtual b : (Ljava/util/List;)V
    //   294: aload_0
    //   295: getfield y : J
    //   298: lconst_0
    //   299: lcmp
    //   300: ifle -> 326
    //   303: aload_0
    //   304: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   307: aload_0
    //   308: getfield x : J
    //   311: ldc2_w 1000
    //   314: lmul
    //   315: aload_0
    //   316: getfield y : J
    //   319: ldc2_w 1000
    //   322: lmul
    //   323: invokevirtual a : (JJ)V
    //   326: aload_0
    //   327: invokespecial n : ()V
    //   330: aload_0
    //   331: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   334: invokevirtual b : ()Z
    //   337: ifne -> 356
    //   340: aload_1
    //   341: ifnonnull -> 356
    //   344: aload_0
    //   345: getfield A : Ljava/util/List;
    //   348: invokeinterface isEmpty : ()Z
    //   353: ifne -> 494
    //   356: new com/qiniu/pili/droid/shortvideo/process/a/d
    //   359: dup
    //   360: aload_0
    //   361: getfield c : Landroid/content/Context;
    //   364: invokespecial <init> : (Landroid/content/Context;)V
    //   367: astore #4
    //   369: aload #4
    //   371: aload_0
    //   372: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   375: invokevirtual d : ()Ljava/lang/String;
    //   378: aload_0
    //   379: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   382: invokevirtual c : ()Z
    //   385: invokevirtual a : (Ljava/lang/String;Z)V
    //   388: aload #4
    //   390: aload_0
    //   391: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   394: invokevirtual e : ()Ljava/lang/String;
    //   397: aload_0
    //   398: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   401: invokevirtual f : ()Ljava/lang/String;
    //   404: aload_0
    //   405: getfield F : I
    //   408: aload_0
    //   409: getfield G : I
    //   412: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;II)V
    //   415: aload #4
    //   417: aload_0
    //   418: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   421: invokevirtual g : ()Lcom/qiniu/pili/droid/shortvideo/PLWatermarkSetting;
    //   424: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/PLWatermarkSetting;)V
    //   427: aload #4
    //   429: aload_0
    //   430: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   433: invokevirtual h : ()Ljava/util/Set;
    //   436: invokevirtual a : (Ljava/util/Set;)V
    //   439: new com/qiniu/pili/droid/shortvideo/core/m$1
    //   442: dup
    //   443: aload_0
    //   444: aload_1
    //   445: aload #4
    //   447: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/core/m;Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;Lcom/qiniu/pili/droid/shortvideo/process/a/d;)V
    //   450: astore_1
    //   451: aload_0
    //   452: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   455: invokevirtual e : ()Ljava/lang/String;
    //   458: ifnull -> 485
    //   461: aload_0
    //   462: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   465: aload_0
    //   466: getfield F : I
    //   469: aload_0
    //   470: getfield G : I
    //   473: aload_0
    //   474: getfield H : I
    //   477: aload_1
    //   478: iload_2
    //   479: invokevirtual a : (IIILcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;Z)V
    //   482: goto -> 494
    //   485: aload_0
    //   486: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   489: aload_1
    //   490: iload_2
    //   491: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;Z)V
    //   494: aload_0
    //   495: new com/qiniu/pili/droid/shortvideo/core/m$2
    //   498: dup
    //   499: aload_0
    //   500: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/core/m;)V
    //   503: invokespecial b : (Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)V
    //   506: getstatic com/qiniu/pili/droid/shortvideo/f/e.e : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   509: ldc 'ShortVideoEditorCore'
    //   511: ldc_w 'save -'
    //   514: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload_0
    //   518: monitorexit
    //   519: return
    //   520: astore_1
    //   521: aload_0
    //   522: monitorexit
    //   523: aload_1
    //   524: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	520	finally
    //   25	69	520	finally
    //   72	94	520	finally
    //   98	181	520	finally
    //   181	186	520	finally
    //   189	294	520	finally
    //   294	326	520	finally
    //   326	340	520	finally
    //   344	356	520	finally
    //   356	482	520	finally
    //   485	494	520	finally
    //   494	517	520	finally
  }
  
  public void b(PLWatermarkSetting paramPLWatermarkSetting) {
    if (!u.a().a(b.a.H))
      return; 
    this.O = paramPLWatermarkSetting;
  }
  
  public void b(boolean paramBoolean) {
    e.e.c("ShortVideoEditorCore", "setAudioMixLooping");
    this.s = paramBoolean;
    com.qiniu.pili.droid.shortvideo.transcoder.audio.a a2 = this.o;
    if (a2 != null)
      a2.a(this.s); 
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null)
      a1.a(this.s); 
  }
  
  public void c() {
    e.e.c("ShortVideoEditorCore", "pausePlayback +");
    this.q = false;
    this.f.b();
    this.h.b(true);
    l();
    e.e.c("ShortVideoEditorCore", "pausePlayback -");
  }
  
  public void c(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    if (!u.a().a(b.a.G))
      return; 
    e.e.c("ShortVideoEditorCore", "updateGifWatermark +");
    this.h.c(paramPLGifWatermarkSetting);
    e.e.c("ShortVideoEditorCore", "updateGifWatermark -");
  }
  
  public void c(PLWatermarkSetting paramPLWatermarkSetting) {
    if (!u.a().a(b.a.H))
      return; 
    this.P = paramPLWatermarkSetting;
  }
  
  public void c(boolean paramBoolean) {
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("muteOriginAudio + isMute: ");
    stringBuilder.append(paramBoolean);
    e.c("ShortVideoEditorCore", stringBuilder.toString());
    if (paramBoolean && this.t == 0.0F) {
      e.h.d("ShortVideoEditorCore", "origin audio has already muted!");
      return;
    } 
    if (paramBoolean) {
      this.v = this.t;
      a(0.0F, this.u);
    } else {
      a(this.v, this.u);
    } 
    e.e.c("ShortVideoEditorCore", "muteOriginAudio -");
  }
  
  public void d() {
    e.e.c("ShortVideoEditorCore", "stopPlayback +");
    this.q = false;
    this.f.f();
    this.j = null;
    m();
    e.e.c("ShortVideoEditorCore", "stopPlayback -");
  }
  
  public PLBuiltinFilter[] e() {
    return this.h.a();
  }
  
  public int f() {
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    return (a1 != null) ? a1.a() : 0;
  }
  
  public void g() {
    e.e.c("ShortVideoEditorCore", "clearAudioMix +");
    this.o = null;
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null)
      a1.a(new d(0L, 0L)); 
    m();
    e.e.c("ShortVideoEditorCore", "clearAudioMix -");
  }
  
  public void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.e : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ShortVideoEditorCore'
    //   7: ldc_w 'cancelSave +'
    //   10: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield E : Z
    //   17: ifeq -> 27
    //   20: aload_0
    //   21: getfield f : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   24: invokevirtual d : ()V
    //   27: aload_0
    //   28: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   31: ifnull -> 41
    //   34: aload_0
    //   35: getfield w : Lcom/qiniu/pili/droid/shortvideo/core/q;
    //   38: invokevirtual a : ()V
    //   41: getstatic com/qiniu/pili/droid/shortvideo/f/e.e : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   44: ldc 'ShortVideoEditorCore'
    //   46: ldc_w 'cancelSave -'
    //   49: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	55	finally
    //   27	41	55	finally
    //   41	52	55	finally
  }
  
  public JSONObject i() {
    byte b1;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    Set set = this.h.h();
    boolean bool6 = false;
    if (set != null) {
      b1 = set.size() + 0;
    } else {
      b1 = 0;
    } 
    if (this.h.g() == null) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    if (this.K == null) {
      bool2 = false;
    } else {
      bool2 = true;
    } 
    if (this.I == null) {
      bool3 = false;
    } else {
      bool3 = true;
    } 
    Iterator<a> iterator = this.A.iterator();
    int j = 0;
    int i = 0;
    int k = b1;
    while (iterator.hasNext()) {
      a a1 = iterator.next();
      if (a.a(a1) instanceof PLImageView) {
        k++;
        continue;
      } 
      if (a.a(a1) instanceof PLTextView) {
        j++;
        continue;
      } 
      if (a.a(a1) instanceof PLPaintView)
        i++; 
    } 
    if (this.a == 1.0D) {
      b1 = 0;
    } else {
      b1 = 1;
    } 
    List<PLSpeedTimeRange> list = this.b;
    int n = b1;
    if (list != null)
      n = b1 + list.size(); 
    if (this.e == 0) {
      b1 = 0;
    } else {
      b1 = 1;
    } 
    if (this.o == null) {
      bool4 = false;
    } else {
      bool4 = true;
    } 
    c c1 = this.Q;
    if (c1 != null) {
      bool5 = c1.b();
    } else {
      bool5 = false;
    } 
    if (this.x != 0L)
      bool6 = true; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_edit_image", k);
      jSONObject.put("operation_edit_watermark", bool1);
      jSONObject.put("operation_edit_filter", bool2);
      jSONObject.put("operation_edit_mv", bool3);
      jSONObject.put("operation_edit_text", j);
      jSONObject.put("operation_edit_paint", i);
      jSONObject.put("operation_edit_speed", n);
      jSONObject.put("operation_edit_rotate", b1);
      jSONObject.put("operation_edit_audio_mix", bool4);
      jSONObject.put("operation_edit_multi_audio_mix", bool5);
      jSONObject.put("operation_trim_video", bool6);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    PLVideoPlayerListener pLVideoPlayerListener = this.l;
    if (pLVideoPlayerListener != null)
      pLVideoPlayerListener.onCompletion(); 
    c c1 = this.Q;
    if (c1 != null)
      c1.f(); 
    com.qiniu.pili.droid.shortvideo.e.a a1 = this.g;
    if (a1 != null && this.o != null) {
      if (this.q) {
        a1.b();
      } else {
        a1.e();
      } 
      this.g.a(this.o.e().a());
    } 
  }
  
  public int onDrawFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong, float[] paramArrayOffloat) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Ljava/lang/Object;
    //   4: ifnonnull -> 14
    //   7: aload_0
    //   8: invokestatic b : ()Ljava/lang/Object;
    //   11: putfield i : Ljava/lang/Object;
    //   14: aload_0
    //   15: getfield m : Lcom/qiniu/pili/droid/shortvideo/PLEffectPlugin;
    //   18: astore #9
    //   20: iload_1
    //   21: istore #7
    //   23: aload #9
    //   25: ifnull -> 56
    //   28: aload #9
    //   30: iload_1
    //   31: iload_2
    //   32: iload_3
    //   33: lload #4
    //   35: aload #6
    //   37: invokeinterface onDrawFrame : (IIIJ[F)I
    //   42: istore #8
    //   44: iload_1
    //   45: istore #7
    //   47: iload #8
    //   49: ifle -> 56
    //   52: iload #8
    //   54: istore #7
    //   56: aload_0
    //   57: getfield j : Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;
    //   60: astore #9
    //   62: aload #9
    //   64: ifnull -> 90
    //   67: aload #9
    //   69: iload #7
    //   71: iload_2
    //   72: iload_3
    //   73: lload #4
    //   75: aload #6
    //   77: invokeinterface onDrawFrame : (IIIJ[F)I
    //   82: istore_1
    //   83: iload_1
    //   84: ifle -> 90
    //   87: goto -> 93
    //   90: iload #7
    //   92: istore_1
    //   93: aload_0
    //   94: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   97: invokevirtual i : ()Z
    //   100: ifne -> 112
    //   103: aload_0
    //   104: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   107: iload_2
    //   108: iload_3
    //   109: invokevirtual a : (II)V
    //   112: aload_0
    //   113: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   116: aload_0
    //   117: getfield P : Lcom/qiniu/pili/droid/shortvideo/PLWatermarkSetting;
    //   120: invokevirtual c : (Lcom/qiniu/pili/droid/shortvideo/PLWatermarkSetting;)V
    //   123: aload_0
    //   124: getfield h : Lcom/qiniu/pili/droid/shortvideo/process/a/d;
    //   127: iload_1
    //   128: lload #4
    //   130: ldc2_w 1000
    //   133: ldiv
    //   134: iconst_0
    //   135: aload_0
    //   136: getfield f : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   139: invokevirtual i : ()I
    //   142: i2l
    //   143: invokevirtual a : (IJZJ)I
    //   146: istore_1
    //   147: aload_0
    //   148: invokespecial p : ()V
    //   151: aload_0
    //   152: getfield Q : Lcom/qiniu/pili/droid/shortvideo/e/c;
    //   155: astore #6
    //   157: aload #6
    //   159: ifnull -> 218
    //   162: aload #6
    //   164: invokevirtual a : ()Lcom/qiniu/pili/droid/shortvideo/PLMixAudioFile;
    //   167: astore #6
    //   169: aload #6
    //   171: ifnull -> 202
    //   174: aload_0
    //   175: getfield f : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   178: invokevirtual j : ()F
    //   181: aload #6
    //   183: invokevirtual getVolume : ()F
    //   186: fcmpl
    //   187: ifeq -> 202
    //   190: aload_0
    //   191: getfield f : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   194: aload #6
    //   196: invokevirtual getVolume : ()F
    //   199: invokevirtual a : (F)V
    //   202: aload_0
    //   203: getfield D : Landroid/opengl/GLSurfaceView;
    //   206: new com/qiniu/pili/droid/shortvideo/core/m$3
    //   209: dup
    //   210: aload_0
    //   211: invokespecial <init> : (Lcom/qiniu/pili/droid/shortvideo/core/m;)V
    //   214: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   217: pop
    //   218: iload_1
    //   219: ireturn
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2) {
    this.B = paramInt1;
    this.C = paramInt2;
    PLEffectPlugin pLEffectPlugin = this.m;
    if (pLEffectPlugin != null)
      pLEffectPlugin.onSurfaceChanged(paramInt1, paramInt2); 
    PLVideoFilterListener pLVideoFilterListener = this.j;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceChanged(paramInt1, paramInt2); 
    if (this.F != 0 || this.G != 0)
      this.f.a(this.F, this.G); 
  }
  
  public void onSurfaceCreated() {
    PLEffectPlugin pLEffectPlugin = this.m;
    if (pLEffectPlugin != null)
      pLEffectPlugin.onSurfaceCreated(); 
    PLVideoFilterListener pLVideoFilterListener = this.j;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceCreated(); 
  }
  
  public void onSurfaceDestroy() {
    PLEffectPlugin pLEffectPlugin = this.m;
    if (pLEffectPlugin != null)
      pLEffectPlugin.onSurfaceDestroy(); 
    this.h.j();
    PLVideoFilterListener pLVideoFilterListener = this.j;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceDestroy(); 
    this.i = null;
  }
  
  class a {
    private long b;
    
    private long c;
    
    private View d;
    
    public a(m this$0, View param1View, long param1Long1, long param1Long2) {
      this.b = param1Long1;
      this.c = param1Long2;
      this.d = param1View;
    }
    
    public View a() {
      return this.d;
    }
    
    public boolean a(long param1Long) {
      if (this.c >= m.n(this.a))
        return (param1Long >= this.b); 
      long l = this.b;
      return (param1Long >= l && param1Long <= l + this.c);
    }
    
    public void b(long param1Long) {
      this.b = param1Long;
    }
    
    public void c(long param1Long) {
      this.c = param1Long;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
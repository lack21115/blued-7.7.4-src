package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.h.a;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.renderer.h;
import com.tencent.liteav.renderer.i;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class h extends t implements TXCRenderAndDec.a, TXCRenderAndDec.b, d, f, b, h, a.a, h {
  private int A;
  
  private int B;
  
  private i C;
  
  private i D;
  
  private float[] E;
  
  private float[] F;
  
  private String G;
  
  private int H;
  
  private boolean I;
  
  private b J;
  
  private Object K;
  
  private a L;
  
  private TXLivePlayer.ITXAudioRawDataListener M;
  
  private String N;
  
  private boolean O;
  
  private long P;
  
  private long Q;
  
  private a R;
  
  private TXCRenderAndDec a = null;
  
  private a f = null;
  
  private TXCStreamDownloader g = null;
  
  private Handler h;
  
  private TextureView i;
  
  private boolean j;
  
  private boolean k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private boolean o;
  
  private Surface p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private int w;
  
  private a x;
  
  private TXRecordCommon.ITXVideoRecordListener y;
  
  private e z;
  
  public h(Context paramContext) {
    super(paramContext);
    boolean bool = false;
    this.j = false;
    this.k = false;
    this.l = 100;
    this.m = 0;
    this.n = 0;
    this.o = false;
    this.q = 2;
    this.r = 48000;
    this.s = 16;
    this.t = false;
    this.u = false;
    this.v = false;
    this.w = 0;
    this.A = 0;
    this.B = 0;
    this.C = null;
    this.D = null;
    this.E = new float[] { 
        1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
        1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.F = new float[16];
    this.G = "";
    this.I = false;
    this.J = b.a;
    this.K = null;
    this.L = new a(this) {
        public void onError(String param1String1, int param1Int, String param1String2, String param1String3) {
          b b;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onError => id:");
          stringBuilder.append(param1String1);
          stringBuilder.append(" code:");
          stringBuilder.append(param1Int);
          stringBuilder.append(" msg:");
          stringBuilder.append(param1String2);
          stringBuilder.append(" params:");
          stringBuilder.append(param1String3);
          TXCLog.e("TXCLivePlayer", stringBuilder.toString());
          WeakReference<b> weakReference = this.a.e;
          if (weakReference == null) {
            weakReference = null;
          } else {
            b = weakReference.get();
          } 
          if (b != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", param1Int);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
            if (param1String2 != null) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(param1String2);
              if (param1String3 == null)
                param1String3 = ""; 
              stringBuilder.append(param1String3);
              bundle.putCharSequence("EVT_MSG", stringBuilder.toString());
            } 
            this.a.onNotifyEvent(param1Int, bundle);
          } 
        }
        
        public void onEvent(String param1String1, int param1Int, String param1String2, String param1String3) {
          b b;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onEvent => id:");
          stringBuilder.append(param1String1);
          stringBuilder.append(" code:");
          stringBuilder.append(param1Int);
          stringBuilder.append(" msg:");
          stringBuilder.append(param1String2);
          stringBuilder.append(" params:");
          stringBuilder.append(param1String3);
          TXCLog.i("TXCLivePlayer", stringBuilder.toString());
          WeakReference<b> weakReference = this.a.e;
          if (weakReference == null) {
            weakReference = null;
          } else {
            b = weakReference.get();
          } 
          if (b != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", param1Int);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
            if (param1String2 != null) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(param1String2);
              if (param1String3 == null)
                param1String3 = ""; 
              stringBuilder.append(param1String3);
              bundle.putCharSequence("EVT_MSG", stringBuilder.toString());
            } 
            this.a.onNotifyEvent(param1Int, bundle);
          } 
        }
        
        public void onWarning(String param1String1, int param1Int, String param1String2, String param1String3) {
          b b;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onWarning => id:");
          stringBuilder.append(param1String1);
          stringBuilder.append(" code:");
          stringBuilder.append(param1Int);
          stringBuilder.append(" msg:");
          stringBuilder.append(param1String2);
          stringBuilder.append(" params:");
          stringBuilder.append(param1String3);
          TXCLog.i("TXCLivePlayer", stringBuilder.toString());
          WeakReference<b> weakReference = this.a.e;
          if (weakReference == null) {
            weakReference = null;
          } else {
            b = weakReference.get();
          } 
          if (b != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", param1Int);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (param1String2 != null) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(param1String2);
              if (param1String3 == null)
                param1String3 = ""; 
              stringBuilder.append(param1String3);
              bundle.putCharSequence("EVT_MSG", stringBuilder.toString());
            } 
            this.a.onNotifyEvent(param1Int, bundle);
          } 
        }
      };
    this.N = "";
    this.O = false;
    this.P = 0L;
    this.Q = 0L;
    this.R = null;
    c.a().a(paramContext);
    TXCAudioEngine.CreateInstance(paramContext, c.a().c());
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference<a>(this.L));
    long l = c.a().a("Audio", "EnableAutoRestartDevice");
    TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
    if (l == 1L || l == -1L)
      bool = true; 
    tXCAudioEngine.enableAutoRestartDevice(bool);
    this.h = new Handler(Looper.getMainLooper());
    this.f = new a();
    this.f.a(this);
    this.R = new a(this);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[FirstFramePath] TXCLivePlayer: create player success. instance:");
    stringBuilder.append(hashCode());
    TXCLog.i("TXCLivePlayer", stringBuilder.toString());
  }
  
  private void a(int paramInt, String paramString) {
    if (this.e != null) {
      Bundle bundle = new Bundle();
      bundle.putInt("EVT_ID", paramInt);
      bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      bundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      if (paramString != null)
        bundle.putCharSequence("EVT_MSG", paramString); 
      Handler handler = this.h;
      if (handler != null)
        handler.post(new Runnable(this, paramInt, bundle) {
              public void run() {
                g.a(this.c.e, this.a, this.b);
              }
            }); 
    } 
  }
  
  private int b(String paramString, int paramInt) {
    boolean bool = false;
    if (paramInt == 0) {
      this.g = new TXCStreamDownloader(this.c, 1);
    } else if (paramInt == 5) {
      this.g = new TXCStreamDownloader(this.c, 4);
    } else {
      this.g = new TXCStreamDownloader(this.c, 0);
      if (!TextUtils.isEmpty(this.b.l))
        this.g.setFlvSessionKey(this.b.l); 
    } 
    this.g.setID(this.N);
    this.g.setListener(this);
    this.g.setNotifyListener(this);
    this.g.setHeaders(this.b.q);
    if (paramInt == 5)
      bool = true; 
    if (bool) {
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    } else {
      this.g.setRetryTimes(this.b.e);
      this.g.setRetryInterval(this.b.f);
    } 
    return this.g.start(paramString, this.b.i, this.b.m, this.b.j, this.b.k);
  }
  
  private void b(String paramString) {
    this.N = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    TXCRenderAndDec tXCRenderAndDec = this.a;
    if (tXCRenderAndDec != null)
      tXCRenderAndDec.setID(this.N); 
    a a1 = this.f;
    if (a1 != null)
      a1.setID(this.N); 
    TXCStreamDownloader tXCStreamDownloader = this.g;
    if (tXCStreamDownloader != null)
      tXCStreamDownloader.setID(this.N); 
    e e1 = this.z;
    if (e1 != null)
      e1.d(this.N); 
  }
  
  private void f(int paramInt) {
    TextureView textureView = this.i;
    boolean bool = false;
    if (textureView != null)
      textureView.setVisibility(0); 
    this.a = new TXCRenderAndDec(this.c);
    this.a.setNotifyListener(this);
    this.a.setVideoRender((f)this.f);
    this.a.setDecListener(this);
    this.a.setRenderAndDecDelegate(this);
    this.a.setConfig(this.b);
    this.a.setID(this.N);
    TXCRenderAndDec tXCRenderAndDec = this.a;
    if (paramInt == 5)
      bool = true; 
    tXCRenderAndDec.start(bool);
    this.a.setRenderMode(this.n);
    this.a.setRenderRotation(this.m);
  }
  
  private void j() {
    if (this.x == null) {
      this.A = this.f.h();
      this.B = this.f.i();
      a.a a1 = l();
      this.x = new a(this.c);
      this.x.a(a1);
      this.x.a(new a.b(this) {
            public void a(int param1Int, String param1String1, String param1String2, String param1String3) {
              if (h.a(this.a) != null) {
                TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                if (param1Int == 0) {
                  tXRecordResult.retCode = 0;
                } else {
                  tXRecordResult.retCode = -1;
                } 
                tXRecordResult.descMsg = param1String1;
                tXRecordResult.videoPath = param1String2;
                tXRecordResult.coverPath = param1String3;
                h.a(this.a).onRecordComplete(tXRecordResult);
              } 
              h.b(this.a).a(null);
              h.b(this.a).a(null);
            }
            
            public void a(long param1Long) {
              if (h.a(this.a) != null)
                h.a(this.a).onRecordProgress(param1Long); 
            }
          });
    } 
    if (this.C == null) {
      this.C = new i(Boolean.valueOf(true));
      this.C.b();
      this.C.b(this.A, this.B);
      this.C.a(this.A, this.B);
    } 
    if (this.D == null) {
      this.D = new i(Boolean.valueOf(false));
      this.D.b();
      this.D.b(this.f.f(), this.f.g());
      this.D.a(this.f.f(), this.f.g());
      Matrix.setIdentityM(this.F, 0);
    } 
  }
  
  private void k() {
    i i1 = this.C;
    if (i1 != null) {
      i1.c();
      this.C = null;
    } 
    i1 = this.D;
    if (i1 != null) {
      i1.c();
      this.D = null;
    } 
  }
  
  private a.a l() {
    int j = this.A;
    if (j > 0) {
      int k = this.B;
      if (k > 0) {
        a.a a2 = new a.a();
        a2.a = j;
        a2.b = k;
        a2.c = 20;
        a2.d = (int)(Math.sqrt((j * j) * 1.0D + (k * k)) * 1.2D);
        a2.h = this.q;
        a2.i = this.r;
        a2.j = this.s;
        a2.f = a.a(this.c, ".mp4");
        a2.g = a.a(this.c, ".jpg");
        a2.e = this.f.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("record config: ");
        stringBuilder1.append(a2);
        TXCLog.d("TXCLivePlayer", stringBuilder1.toString());
        return a2;
      } 
    } 
    j = 480;
    char c = 'ʀ';
    a.a a1 = new a.a();
    a1.a = j;
    a1.b = c;
    a1.c = 20;
    a1.d = (int)(Math.sqrt((j * j) * 1.0D + (c * c)) * 1.2D);
    a1.h = this.q;
    a1.i = this.r;
    a1.j = this.s;
    a1.f = a.a(this.c, ".mp4");
    a1.g = a.a(this.c, ".jpg");
    a1.e = this.f.b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("record config: ");
    stringBuilder.append(a1);
    TXCLog.d("TXCLivePlayer", stringBuilder.toString());
    return a1;
  }
  
  private void m() {
    TXCRenderAndDec tXCRenderAndDec = this.a;
    if (tXCRenderAndDec != null) {
      tXCRenderAndDec.stop();
      this.a.setVideoRender(null);
      this.a.setDecListener(null);
      this.a.setNotifyListener(null);
      this.a = null;
    } 
  }
  
  private void n() {
    boolean bool;
    if (this.H == 5) {
      bool = true;
    } else {
      bool = false;
    } 
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(this.I, 300);
    a(this.M);
    if (this.H == 5) {
      TXCAudioEngine.getInstance().setRemoteAudioCacheParams(this.N, this.b.g ^ true, (int)(a.b * 1000.0F), (int)(a.b * 1000.0F), (int)(a.c * 1000.0F));
    } else {
      TXCAudioEngine.getInstance().setRemoteAudioCacheParams(this.N, this.b.g ^ true, (int)(this.b.a * 1000.0F), (int)(this.b.c * 1000.0F), (int)(this.b.b * 1000.0F));
    } 
    TXCAudioEngine.getInstance().muteRemoteAudio(this.N, this.j);
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.N, this.k);
    TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.N, this.l);
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.N, this);
    y();
    TXCAudioEngine.getInstance().startRemoteAudio(this.N, bool);
  }
  
  private void o() {
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.N, null);
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, null);
    TXCAudioEngine.getInstance().stopRemoteAudio(this.N);
  }
  
  private void p() {
    TXCStreamDownloader tXCStreamDownloader = this.g;
    if (tXCStreamDownloader != null) {
      tXCStreamDownloader.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    } 
  }
  
  private void r() {
    boolean bool;
    this.z = new e(this.c);
    this.z.a(this.G);
    e e1 = this.z;
    if (this.H == 5) {
      bool = true;
    } else {
      bool = false;
    } 
    e1.a(bool);
    this.z.d(this.N);
    this.z.e(this.g.getRTMPProxyUserId());
    this.z.a();
  }
  
  private void s() {
    e e1 = this.z;
    if (e1 != null) {
      e1.c();
      this.z = null;
    } 
  }
  
  private void t() {
    this.O = false;
    y();
  }
  
  private void u() {
    if (this.P > 0L) {
      Bundle bundle = new Bundle();
      bundle.putInt("EVT_PLAY_PROGRESS", (int)(this.P / 1000L));
      bundle.putInt("EVT_PLAY_PROGRESS_MS", (int)this.P);
      onNotifyEvent(2005, bundle);
    } 
    Handler handler = this.h;
    if (handler != null && this.O)
      handler.postDelayed(new Runnable(this) {
            public void run() {
              if (h.c(this.a))
                h.d(this.a); 
            }
          },  1000L); 
  }
  
  private void v() {
    Handler handler = this.h;
    if (handler != null)
      handler.postDelayed(this.R, 2000L); 
  }
  
  private void w() {
    Handler handler = this.h;
    if (handler != null)
      handler.removeCallbacks(this.R); 
  }
  
  private void x() {
    ArrayList<String> arrayList = new ArrayList();
    String str = this.N;
    if (str != null)
      arrayList.add(str); 
    a.a("18446744073709551615", arrayList);
  }
  
  private void y() {
    if (this.t || this.M != null || this.O)
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, this); 
    if (!this.t && this.M == null && !this.O)
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, null); 
  }
  
  public int a(int paramInt, float[] paramArrayOffloat) {
    a a1 = this.x;
    if (this.t && a1 != null) {
      i i1 = this.C;
      if (i1 != null) {
        int j = i1.d(paramInt);
        a1.a(j, TXCTimeUtil.getTimeTick());
        this.f.a(j, this.A, this.B, false, 0);
      } 
    } 
    if (this.t) {
      j();
      return paramInt;
    } 
    k();
    return paramInt;
  }
  
  public int a(String paramString) {
    if (c()) {
      TXCStreamDownloader tXCStreamDownloader = this.g;
      if (tXCStreamDownloader != null) {
        boolean bool = tXCStreamDownloader.switchStream(paramString);
        long l1 = 0L;
        long l2 = TXCStatus.c(this.N, 2007);
        TXCRenderAndDec tXCRenderAndDec = this.a;
        if (tXCRenderAndDec != null)
          l1 = tXCRenderAndDec.getVideoCacheDuration(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[SwitchStream] current jitter size when start switch stream. video:");
        stringBuilder.append(l1);
        stringBuilder.append(" audio:");
        stringBuilder.append(l2);
        TXCLog.i("TXCLivePlayer", stringBuilder.toString());
        if (bool) {
          this.G = paramString;
          return 0;
        } 
        return -2;
      } 
    } 
    return -1;
  }
  
  public int a(String paramString, int paramInt) {
    StringBuilder stringBuilder1;
    if (c()) {
      TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
      return -2;
    } 
    if (this.b != null && this.b.c > this.b.b) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("play: can not start play while invalid cache config [minAutoAdjustCacheTime(");
      stringBuilder1.append(this.b.c);
      stringBuilder1.append(") > maxAutoAdjustCacheTime(");
      stringBuilder1.append(this.b.b);
      stringBuilder1.append(")]!!!!!!");
      TXCLog.e("TXCLivePlayer", stringBuilder1.toString());
      return -1;
    } 
    if (this.b.a > this.b.b || this.b.a < this.b.c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("play: invalid cacheTime ");
      stringBuilder.append(this.b.a);
      stringBuilder.append(", need between minAutoAdjustCacheTime ");
      stringBuilder.append(this.b.c);
      stringBuilder.append(" and maxAutoAdjustCacheTime ");
      stringBuilder.append(this.b.b);
      stringBuilder.append(" , fix to maxAutoAdjustCacheTime");
      TXCLog.w("TXCLivePlayer", stringBuilder.toString());
      this.b.a = this.b.b;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[FirstFramePath] TXCLivePlayer: start play. instance: ");
    stringBuilder2.append(hashCode());
    TXCLog.i("TXCLivePlayer", stringBuilder2.toString());
    this.G = (String)stringBuilder1;
    this.H = paramInt;
    b((String)stringBuilder1);
    this.o = true;
    this.w = 0;
    this.u = true;
    f(paramInt);
    n();
    paramInt = b((String)stringBuilder1, paramInt);
    if (paramInt != 0) {
      this.o = false;
      p();
      m();
      o();
      TextureView textureView = this.i;
      if (textureView != null) {
        textureView.setVisibility(8);
        return paramInt;
      } 
    } else {
      a(this.p);
      r();
      v();
      if (this.J == b.c && this.i == null) {
        a a1 = this.f;
        if (a1 != null)
          a1.c(this.K); 
      } 
      TXCDRApi.txReportDAU(this.c, a.bu);
      try {
        if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null)
          TXCDRApi.txReportDAU(this.c, a.bF); 
        return paramInt;
      } catch (Exception exception) {
        return paramInt;
      } 
    } 
    return paramInt;
  }
  
  public int a(boolean paramBoolean) {
    if (!c()) {
      TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
      return -2;
    } 
    TXCLog.v("TXCLivePlayer", "play: stop");
    this.o = false;
    p();
    m();
    TextureView textureView = this.i;
    if (textureView != null && paramBoolean)
      textureView.setVisibility(8); 
    a a1 = this.f;
    if (a1 != null)
      a1.a((Surface)null); 
    if (this.i == null) {
      a1 = this.f;
      if (a1 != null)
        a1.d(); 
    } 
    o();
    s();
    w();
    t();
    return 0;
  }
  
  public void a() {
    a(false);
  }
  
  public void a(int paramInt) {
    this.n = paramInt;
    TXCRenderAndDec tXCRenderAndDec = this.a;
    if (tXCRenderAndDec != null)
      tXCRenderAndDec.setRenderMode(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    a a1 = this.f;
    if (a1 != null)
      a1.d(paramInt1, paramInt2); 
  }
  
  public void a(SurfaceTexture paramSurfaceTexture) {
    k();
    e();
  }
  
  public void a(Surface paramSurface) {
    this.p = paramSurface;
    a a1 = this.f;
    if (a1 != null)
      a1.a(paramSurface); 
  }
  
  public void a(p paramp) {
    a a1 = this.f;
    if (a1 != null)
      a1.a(paramp); 
  }
  
  public void a(j paramj) {
    super.a(paramj);
    TXCRenderAndDec tXCRenderAndDec = this.a;
    if (tXCRenderAndDec != null)
      tXCRenderAndDec.setConfig(paramj); 
  }
  
  public void a(u paramu, b paramb, Object paramObject) {
    this.J = paramb;
    this.K = paramObject;
    if (c() && this.J == b.c && this.i == null && paramu != null) {
      paramObject = this.f;
      if (paramObject != null)
        paramObject.c(this.K); 
    } 
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.setVideoFrameListener(paramu, paramb);
      return;
    } 
    TXCLog.w("TXCLivePlayer", "setVideoFrameListener->enter with renderAndDec is empty");
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener) {
    this.M = paramITXAudioRawDataListener;
    y();
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView) {
    if (this.d != null && this.d != paramTXCloudVideoView) {
      TextureView textureView = this.d.getVideoView();
      if (textureView != null)
        this.d.removeView((View)textureView); 
    } 
    super.a(paramTXCloudVideoView);
    if (this.d != null) {
      this.i = this.d.getVideoView();
      if (this.i == null)
        this.i = new TextureView(this.d.getContext()); 
      this.d.addVideoView(this.i);
    } 
    a a1 = this.f;
    if (a1 != null)
      a1.a(this.i); 
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener) {
    this.y = paramITXVideoRecordListener;
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    this.I = paramBoolean;
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, paramInt);
  }
  
  public void b() {
    a(this.G, this.H);
  }
  
  public void b(int paramInt) {
    this.m = paramInt;
    TXCRenderAndDec tXCRenderAndDec = this.a;
    if (tXCRenderAndDec != null)
      tXCRenderAndDec.setRenderRotation(paramInt); 
  }
  
  public void b(boolean paramBoolean) {
    this.j = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudio(this.N, this.j);
  }
  
  public void c(int paramInt) {
    this.l = paramInt;
    TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.N, this.l);
  }
  
  public void c(boolean paramBoolean) {
    this.k = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.N, paramBoolean);
  }
  
  public boolean c() {
    return this.o;
  }
  
  public int d(int paramInt) {
    if (this.t) {
      TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
      return -1;
    } 
    this.t = true;
    this.f.a(this);
    this.f.a(this);
    y();
    TXCDRApi.txReportDAU(this.c, a.aw);
    return 0;
  }
  
  public TextureView d() {
    return this.i;
  }
  
  public int e() {
    if (!this.t) {
      TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
      return -1;
    } 
    this.t = false;
    y();
    a a1 = this.x;
    if (a1 != null) {
      a1.a();
      this.x = null;
    } 
    return 0;
  }
  
  public boolean f() {
    return true;
  }
  
  public void g() {
    this.Q = 0L;
    if (this.O)
      return; 
    this.O = true;
    y();
    Handler handler = this.h;
    if (handler != null)
      handler.postDelayed(new Runnable(this) {
            public void run() {
              if (h.c(this.a))
                h.d(this.a); 
            }
          },  1000L); 
  }
  
  public void h() {
    x();
    int[] arrayOfInt = g.a();
    int j = arrayOfInt[0] / 10;
    int k = arrayOfInt[1] / 10;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(j);
    stringBuilder1.append("/");
    stringBuilder1.append(k);
    stringBuilder1.append("%");
    String str1 = stringBuilder1.toString();
    int m = TXCStatus.c(this.N, 7102);
    int n = TXCStatus.c(this.N, 7101);
    String str2 = TXCStatus.b(this.N, 7110);
    k = (int)TXCStatus.d(this.N, 6002);
    Bundle bundle = new Bundle();
    a a1 = this.f;
    if (a1 != null) {
      bundle.putInt("VIDEO_WIDTH", a1.h());
      bundle.putInt("VIDEO_HEIGHT", this.f.i());
    } 
    TXCRenderAndDec tXCRenderAndDec2 = this.a;
    if (tXCRenderAndDec2 != null) {
      bundle.putInt("VIDEO_CACHE", (int)tXCRenderAndDec2.getVideoCacheDuration());
      bundle.putInt("V_SUM_CACHE_SIZE", (int)this.a.getVideoCacheFrameCount());
      bundle.putInt("V_DEC_CACHE_SIZE", this.a.getVideoDecCacheFrameCount());
      bundle.putInt("AV_PLAY_INTERVAL", (int)this.a.getAVPlayInterval());
      bundle.putInt("AV_RECV_INTERVAL", (int)this.a.getAVNetRecvInterval());
      if (k == 0) {
        j = 15;
      } else {
        j = k;
      } 
      bundle.putInt("VIDEO_GOP", (int)(((TXCStatus.c(this.N, 7120) * 10 / j) / 10.0F) + 0.5D));
    } 
    j = TXCAudioEngine.getInstance().getPlayAECType();
    int i1 = TXCStatus.c(this.N, 2019);
    int i2 = TXCStatus.c(this.N, 2020);
    int i3 = TXCAudioEngine.getInstance().getPlaySampleRate();
    int i4 = TXCAudioEngine.getInstance().getPlayChannels();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(j);
    stringBuilder2.append(" | ");
    stringBuilder2.append(i1);
    stringBuilder2.append(",");
    stringBuilder2.append(i2);
    stringBuilder2.append(" | ");
    stringBuilder2.append(i3);
    stringBuilder2.append(",");
    stringBuilder2.append(i4);
    bundle.putString("AUDIO_PLAY_INFO", stringBuilder2.toString());
    bundle.putInt("AUDIO_CACHE", TXCStatus.c(this.N, 2007));
    bundle.putInt("NET_JITTER", TXCStatus.c(this.N, 2018));
    bundle.putFloat("AUDIO_CACHE_THRESHOLD", TXCStatus.c(this.N, 2021) / 1000.0F);
    bundle.putInt("NET_SPEED", n + m);
    bundle.putInt("VIDEO_FPS", k);
    bundle.putInt("VIDEO_BITRATE", n);
    bundle.putInt("AUDIO_BITRATE", m);
    bundle.putCharSequence("SERVER_IP", str2);
    bundle.putCharSequence("CPU_USAGE", str1);
    this.w++;
    if (this.w == 5)
      if (this.v) {
        TXCStatus.a(this.N, 9009, Long.valueOf(0L));
      } else {
        TXCStatus.a(this.N, 9009, Long.valueOf(1L));
      }  
    g.a(this.e, 15001, bundle);
    TXCRenderAndDec tXCRenderAndDec1 = this.a;
    if (tXCRenderAndDec1 != null)
      tXCRenderAndDec1.updateLoadInfo(); 
    e e1 = this.z;
    if (e1 != null)
      e1.f(); 
  }
  
  public int i() {
    return TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(this.N);
  }
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2) {
    onNotifyEvent(paramInt, (Bundle)null);
  }
  
  public void onAudioPlayPcmData(String paramString, byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) {
    this.r = paramInt1;
    this.q = paramInt2;
    long l = paramLong;
    if (this.x != null) {
      l = paramLong;
      if (paramLong <= 0L)
        l = TXCTimeUtil.getTimeTick(); 
      this.x.a(paramArrayOfbyte, l);
    } 
    if (this.Q <= 0L) {
      TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener1 = this.M;
      if (iTXAudioRawDataListener1 != null)
        iTXAudioRawDataListener1.onAudioInfoChanged(paramInt1, paramInt2, 16); 
    } 
    TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.M;
    if (iTXAudioRawDataListener != null)
      iTXAudioRawDataListener.onPcmDataAvailable(paramArrayOfbyte, l); 
    paramLong = this.Q;
    if (paramLong <= 0L) {
      this.Q = l;
      return;
    } 
    this.P = l - paramLong;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle) {
    if (2003 == paramInt && !this.v)
      this.v = true; 
    if (2003 == paramInt || 2026 == paramInt) {
      if (this.u) {
        a(2004, "Video play started");
        this.u = false;
      } 
      if (2026 == paramInt) {
        TXCStatus.a(this.N, 2033, Long.valueOf(TXCTimeUtil.getTimeTick()));
        return;
      } 
    } 
    if (2025 == paramInt) {
      a(2004, "Video play started");
      return;
    } 
    if (2023 == paramInt || 2024 == paramInt) {
      a(2007, "Video play loading");
      return;
    } 
    Handler handler = this.h;
    if (handler != null)
      handler.post(new Runnable(this, paramInt, paramBundle) {
            public void run() {
              g.a(this.c.e, this.a, this.b);
              if (this.a == 2103 && h.f(this.c) != null)
                h.f(this.c).restartDecoder(); 
            }
          }); 
  }
  
  public void onPullAudio(a parama) {}
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket) {
    if (!this.o)
      return; 
    try {
      if (this.a != null) {
        this.a.decVideo(paramTXSNALPacket);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("decode video failed.");
      stringBuilder.append(exception.getMessage());
      TXCLog.e("TXCLivePlayer", stringBuilder.toString());
    } 
  }
  
  public void onRequestKeyFrame(String paramString, int paramInt) {
    if (this.o) {
      TXCStreamDownloader tXCStreamDownloader = this.g;
      if (tXCStreamDownloader != null)
        tXCStreamDownloader.requestKeyFrame(this.G); 
    } 
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a a1 = this.x;
    if (this.t && a1 != null) {
      i i1 = this.D;
      if (i1 != null) {
        i1.a(this.E);
        a1.a(this.D.d(paramInt1), TXCTimeUtil.getTimeTick());
        this.D.a(this.F);
        this.D.c(paramInt1);
      } 
    } 
    if (this.t) {
      j();
      return;
    } 
    k();
  }
  
  static class a implements Runnable {
    private WeakReference<h> a;
    
    a(h param1h) {
      this.a = new WeakReference<h>(param1h);
    }
    
    public void run() {
      h h = this.a.get();
      if (h == null)
        return; 
      h.h();
      h.e(h);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
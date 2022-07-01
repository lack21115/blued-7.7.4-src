package com.tencent.liteav;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.ijk.media.player.IjkBitrateItem;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.d;
import com.tencent.liteav.txcvodplayer.e;
import com.tencent.rtmp.TXBitrateItem;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

public class p extends t {
  protected boolean a;
  
  private TXCVodVideoView f;
  
  private d g;
  
  private n h = null;
  
  private boolean i;
  
  private boolean j = true;
  
  private boolean k = true;
  
  private boolean l = true;
  
  private float m = 1.0F;
  
  private Surface n;
  
  private e o = new e(this) {
      public void a(int param1Int, Bundle param1Bundle) {
        StringBuilder stringBuilder;
        Bundle bundle = new Bundle(param1Bundle);
        short s = -2304;
        if (param1Int != -2301) {
          if (param1Int != 2011) {
            if (param1Int != 2103) {
              if (param1Int != 2106) {
                if (param1Int != 2013) {
                  if (param1Int != 2014) {
                    boolean bool;
                    MediaInfo mediaInfo;
                    Bundle bundle1;
                    switch (param1Int) {
                      default:
                        bool = true;
                        switch (param1Int) {
                          default:
                            switch (param1Int) {
                              default:
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("miss match event ");
                                stringBuilder.append(param1Int);
                                TXCLog.d("TXVodPlayer", stringBuilder.toString());
                              case 2019:
                                return;
                              case 2018:
                                TXCLog.i("TXVodPlayer", "vod play dns resolved");
                                p.a(this.a).h();
                                return;
                              case 2017:
                                TXCLog.i("TXVodPlayer", "vod play first video packet");
                                p.a(this.a).i();
                                return;
                              case 2016:
                                break;
                            } 
                            TXCLog.i("TXVodPlayer", "vod play tcp connect success");
                            p.a(this.a).g();
                            return;
                          case 2009:
                            param1Int = 2009;
                            break;
                          case 2008:
                            param1Int = 2008;
                            break;
                          case 2007:
                            param1Int = 2007;
                            p.a(this.a).j();
                            break;
                          case 2006:
                            p.a(this.a).b();
                            if (this.a.a) {
                              p.c(this.a).b();
                              p.a(this.a).a(true);
                              TXCLog.d("TXVodPlayer", "loop play");
                              return;
                            } 
                            param1Int = 2006;
                            break;
                          case 2005:
                            param1Int = 2005;
                            p.a(this.a).a(stringBuilder.getInt("EVT_PLAY_DURATION", 0), stringBuilder.getInt("EVT_PLAY_PROGRESS", 0));
                            break;
                          case 2004:
                            param1Int = 2004;
                            p.a(this.a).e();
                            break;
                          case 2003:
                            break;
                        } 
                        if (p.b(this.a))
                          return; 
                        p.a(this.a, true);
                        p.a(this.a).f();
                        bundle1 = new Bundle();
                        bundle1.putInt("EVT_ID", 2008);
                        bundle1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                        bundle1.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
                        mediaInfo = p.c(this.a).getMediaInfo();
                        if (mediaInfo != null && mediaInfo.mVideoDecoderImpl != null && mediaInfo.mVideoDecoderImpl.contains("hevc")) {
                          param1Int = 1;
                        } else {
                          param1Int = 0;
                        } 
                        if (p.c(this.a).getPlayerType() == 0) {
                          if (param1Int == 0) {
                            String str;
                            if (p.d(this.a).a()) {
                              str = "Enables hardware decoding";
                            } else {
                              str = "Enables software decoding";
                            } 
                            bundle1.putCharSequence("description", str);
                          } else {
                            String str;
                            if (p.d(this.a).a()) {
                              str = "Enables hardware decoding H265";
                            } else {
                              str = "Enables software decoding h265";
                            } 
                            bundle1.putCharSequence("description", str);
                          } 
                          if (p.d(this.a).a()) {
                            s = 1;
                          } else {
                            s = 2;
                          } 
                          bundle1.putInt("EVT_PARAM1", s);
                          bundle1.putInt("hevc", param1Int);
                        } else {
                          bundle1.putCharSequence("description", "Enables hardware decoding");
                          bundle1.putInt("EVT_PARAM1", 2);
                        } 
                        if (p.d(this.a).a()) {
                          if (param1Int == 0) {
                            param1Int = bool;
                          } else {
                            param1Int = 3;
                          } 
                        } else if (param1Int == 0) {
                          param1Int = 0;
                        } else {
                          param1Int = 2;
                        } 
                        p.a(this.a).b(param1Int);
                        a(2008, bundle1);
                        param1Int = 2003;
                        break;
                      case -2303:
                        param1Int = -2303;
                        p.a(this.a).a(-2303, "file not found");
                        break;
                      case -2304:
                        p.a(this.a).a(-2304, "h265 decode failed");
                        param1Int = s;
                        if (!p.b(this.a)) {
                          p.d(this.a).a(false);
                          param1Int = s;
                        } 
                        break;
                      case -2305:
                        p.a(this.a).a(-2305, "HLS decrypt key error");
                        param1Int = -2305;
                        break;
                    } 
                  } else {
                    param1Int = 2014;
                  } 
                } else {
                  p.a(this.a).e();
                  param1Int = 2013;
                } 
              } else {
                if (!p.b(this.a))
                  p.d(this.a).a(false); 
                param1Int = 2106;
              } 
            } else {
              param1Int = 2103;
            } 
          } else {
            bundle.putInt("EVT_PARAM1", p.c(this.a).getMetaRotationDegree());
            param1Int = 2011;
          } 
        } else {
          p.a(this.a).a(-2301, "network disconnect, has retry reconnect, but still failed!");
          param1Int = -2301;
        } 
        bundle.putString("EVT_MSG", stringBuilder.getString("description", ""));
        if (this.a.e != null) {
          b b = this.a.e.get();
          if (b != null)
            b.onNotifyEvent(param1Int, bundle); 
        } 
      }
      
      public void a(Bundle param1Bundle) {
        Bundle bundle = new Bundle();
        int[] arrayOfInt = g.a();
        int i = Integer.valueOf(arrayOfInt[0]).intValue() / 10;
        int j = Integer.valueOf(arrayOfInt[1]).intValue() / 10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("/");
        stringBuilder.append(j);
        stringBuilder.append("%");
        bundle.putCharSequence("CPU_USAGE", stringBuilder.toString());
        bundle.putInt("VIDEO_FPS", (int)param1Bundle.getFloat("fps"));
        bundle.putInt("VIDEO_DPS", (int)param1Bundle.getFloat("dps"));
        bundle.putInt("NET_SPEED", (int)param1Bundle.getLong("tcpSpeed") / 1000);
        bundle.putInt("AUDIO_CACHE", (int)param1Bundle.getLong("cachedBytes") / 1000);
        bundle.putInt("VIDEO_WIDTH", p.c(this.a).getVideoWidth());
        bundle.putInt("VIDEO_HEIGHT", p.c(this.a).getVideoHeight());
        bundle.putString("SERVER_IP", p.c(this.a).getServerIp());
        p.a(this.a).e(p.c(this.a).getServerIp());
        if (this.a.e != null) {
          b b = this.a.e.get();
          if (b != null)
            b.onNotifyEvent(15001, bundle); 
        } 
      }
    };
  
  public p(Context paramContext) {
    super(paramContext);
    this.f = new TXCVodVideoView(paramContext);
    this.f.setListener(this.o);
  }
  
  private String b(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   4: astore #12
    //   6: aload #12
    //   8: invokevirtual getQuery : ()Ljava/lang/String;
    //   11: astore #5
    //   13: ldc ''
    //   15: astore #8
    //   17: aload #5
    //   19: ifnull -> 409
    //   22: aload #5
    //   24: invokevirtual isEmpty : ()Z
    //   27: ifne -> 409
    //   30: aload #5
    //   32: ldc '&'
    //   34: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   37: astore #9
    //   39: aload #9
    //   41: arraylength
    //   42: istore_2
    //   43: ldc '0'
    //   45: astore #11
    //   47: iload_2
    //   48: ifle -> 281
    //   51: aload #9
    //   53: arraylength
    //   54: istore #4
    //   56: ldc ''
    //   58: astore #7
    //   60: aload #7
    //   62: astore #6
    //   64: aload #6
    //   66: astore #5
    //   68: aload #5
    //   70: astore #8
    //   72: iconst_0
    //   73: istore_2
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_2
    //   77: iload #4
    //   79: if_icmpge -> 264
    //   82: aload #9
    //   84: iload_2
    //   85: aaload
    //   86: astore #13
    //   88: aload #13
    //   90: ldc '='
    //   92: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore #10
    //   97: aload #10
    //   99: arraylength
    //   100: iconst_2
    //   101: if_icmpne -> 250
    //   104: ldc 'spfileid'
    //   106: aload #10
    //   108: iconst_0
    //   109: aaload
    //   110: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   113: ifeq -> 129
    //   116: aload #10
    //   118: iconst_1
    //   119: aaload
    //   120: astore #7
    //   122: iload_3
    //   123: iconst_1
    //   124: iadd
    //   125: istore_3
    //   126: goto -> 257
    //   129: ldc 'spdrmtype'
    //   131: aload #10
    //   133: iconst_0
    //   134: aaload
    //   135: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   138: ifeq -> 150
    //   141: aload #10
    //   143: iconst_1
    //   144: aaload
    //   145: astore #6
    //   147: goto -> 122
    //   150: ldc 'spappid'
    //   152: aload #10
    //   154: iconst_0
    //   155: aaload
    //   156: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   159: ifeq -> 171
    //   162: aload #10
    //   164: iconst_1
    //   165: aaload
    //   166: astore #5
    //   168: goto -> 122
    //   171: aload #8
    //   173: astore #10
    //   175: aload #8
    //   177: invokevirtual isEmpty : ()Z
    //   180: ifne -> 215
    //   183: new java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial <init> : ()V
    //   190: astore #10
    //   192: aload #10
    //   194: aload #8
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #10
    //   202: ldc '&'
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #10
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: astore #10
    //   215: new java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial <init> : ()V
    //   222: astore #8
    //   224: aload #8
    //   226: aload #10
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #8
    //   234: aload #13
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #8
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: astore #8
    //   247: goto -> 257
    //   250: ldc 'TXVodPlayer'
    //   252: ldc 'fieldIds.length != 2'
    //   254: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   257: iload_2
    //   258: iconst_1
    //   259: iadd
    //   260: istore_2
    //   261: goto -> 76
    //   264: iload_3
    //   265: iconst_3
    //   266: if_icmpne -> 278
    //   269: ldc '1'
    //   271: astore #9
    //   273: iconst_1
    //   274: istore_2
    //   275: goto -> 299
    //   278: goto -> 293
    //   281: ldc ''
    //   283: astore #7
    //   285: aload #7
    //   287: astore #6
    //   289: aload #6
    //   291: astore #5
    //   293: iconst_0
    //   294: istore_2
    //   295: aload #11
    //   297: astore #9
    //   299: iload_2
    //   300: ifeq -> 406
    //   303: new java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial <init> : ()V
    //   310: astore #10
    //   312: aload #10
    //   314: ldc 'spfileid, '
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload #10
    //   322: aload #7
    //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload #10
    //   330: ldc ', spdrmtype= '
    //   332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload #10
    //   338: aload #6
    //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #10
    //   346: ldc ', spappid='
    //   348: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload #10
    //   354: aload #5
    //   356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: ldc 'TXVodPlayer'
    //   362: aload #10
    //   364: invokevirtual toString : ()Ljava/lang/String;
    //   367: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_0
    //   371: getfield h : Lcom/tencent/liteav/n;
    //   374: aload #7
    //   376: invokevirtual d : (Ljava/lang/String;)V
    //   379: aload_0
    //   380: getfield h : Lcom/tencent/liteav/n;
    //   383: aload #6
    //   385: invokevirtual c : (Ljava/lang/String;)V
    //   388: aload_0
    //   389: getfield h : Lcom/tencent/liteav/n;
    //   392: aload #5
    //   394: invokevirtual f : (Ljava/lang/String;)V
    //   397: aload_0
    //   398: getfield h : Lcom/tencent/liteav/n;
    //   401: aload #9
    //   403: invokevirtual b : (Ljava/lang/String;)V
    //   406: goto -> 411
    //   409: iconst_0
    //   410: istore_2
    //   411: iload_2
    //   412: ifeq -> 464
    //   415: aload #12
    //   417: invokevirtual buildUpon : ()Landroid/net/Uri$Builder;
    //   420: invokevirtual clearQuery : ()Landroid/net/Uri$Builder;
    //   423: invokevirtual build : ()Landroid/net/Uri;
    //   426: invokevirtual toString : ()Ljava/lang/String;
    //   429: astore_1
    //   430: aload #8
    //   432: invokevirtual isEmpty : ()Z
    //   435: ifne -> 461
    //   438: aload #12
    //   440: invokevirtual buildUpon : ()Landroid/net/Uri$Builder;
    //   443: invokevirtual clearQuery : ()Landroid/net/Uri$Builder;
    //   446: aload #8
    //   448: invokevirtual query : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   451: invokevirtual build : ()Landroid/net/Uri;
    //   454: invokevirtual toString : ()Ljava/lang/String;
    //   457: astore_1
    //   458: goto -> 464
    //   461: goto -> 464
    //   464: new java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial <init> : ()V
    //   471: astore #5
    //   473: aload #5
    //   475: ldc 'parsePlayUrl url: '
    //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload #5
    //   483: aload_1
    //   484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: ldc 'TXVodPlayer'
    //   490: aload #5
    //   492: invokevirtual toString : ()Ljava/lang/String;
    //   495: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload_1
    //   499: areturn
  }
  
  public int a(String paramString, int paramInt) {
    if (this.d != null) {
      this.d.setVisibility(0);
      if (this.d.getVideoView() == null) {
        TextureRenderView textureRenderView = new TextureRenderView(this.d.getContext());
        this.d.addVideoView((TextureView)textureRenderView);
        this.f.setTextureRenderView(textureRenderView);
      } 
      this.d.getVideoView().setVisibility(0);
    } else {
      Surface surface = this.n;
      if (surface != null)
        this.f.setRenderSurface(surface); 
    } 
    this.h = new n(this.c);
    paramString = b(paramString);
    this.h.a(paramString);
    this.h.a(this.k);
    this.i = false;
    this.f.setPlayerType(this.g.b());
    this.f.b(this.j);
    this.f.setVideoPath(paramString);
    this.f.setAutoPlay(this.k);
    this.f.setRate(this.m);
    this.f.setAutoRotate(this.l);
    this.f.b();
    this.h.a(1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startPlay ");
    stringBuilder.append(paramString);
    TXCLog.d("TXVodPlayer", stringBuilder.toString());
    TXCDRApi.txReportDAU(this.c, a.bt);
    try {
      if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null)
        TXCDRApi.txReportDAU(this.c, a.bE); 
      return 0;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public int a(boolean paramBoolean) {
    this.f.c();
    if (this.d != null && this.d.getVideoView() != null && paramBoolean)
      this.d.getVideoView().setVisibility(8); 
    n n1 = this.h;
    if (n1 != null)
      n1.b(); 
    return 0;
  }
  
  public void a() {
    this.f.d();
    n n1 = this.h;
    if (n1 != null)
      n1.c(); 
  }
  
  public void a(float paramFloat) {
    this.f.a((int)(paramFloat * 1000.0F));
    if (this.i) {
      n n1 = this.h;
      if (n1 != null)
        n1.k(); 
    } 
  }
  
  public void a(int paramInt) {
    if (paramInt == 1) {
      this.f.setRenderMode(0);
      return;
    } 
    this.f.setRenderMode(1);
  }
  
  public void a(Surface paramSurface) {
    this.n = paramSurface;
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null)
      tXCVodVideoView.setRenderSurface(this.n); 
  }
  
  public void a(p paramp) {}
  
  public void a(j paramj) {
    super.a(paramj);
    if (this.g == null)
      this.g = new d(); 
    this.g.a(this.b.e);
    this.g.b(this.b.f);
    this.g.c(this.b.r);
    this.g.a(this.b.h);
    this.g.a(this.b.n);
    this.g.a(this.b.o);
    this.g.b(this.b.p);
    this.g.a(this.b.q);
    this.g.b(this.b.s);
    this.g.c(this.b.u);
    this.g.b(this.b.v);
    this.g.c(this.b.w);
    this.g.d(this.b.x);
    this.f.setConfig(this.g);
    this.l = paramj.t;
  }
  
  public void a(TextureRenderView paramTextureRenderView) {
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null)
      tXCVodVideoView.setRenderView((a)paramTextureRenderView); 
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView) {
    if (paramTXCloudVideoView != this.d) {
      if (this.d != null)
        this.d.removeVideoView(); 
      if (paramTXCloudVideoView != null)
        paramTXCloudVideoView.removeVideoView(); 
    } 
    if (paramTXCloudVideoView != null) {
      paramTXCloudVideoView.setVisibility(0);
      if (paramTXCloudVideoView.getVideoView() == null) {
        TextureRenderView textureRenderView = new TextureRenderView(paramTXCloudVideoView.getContext());
        paramTXCloudVideoView.addVideoView((TextureView)textureRenderView);
        this.f.setTextureRenderView(textureRenderView);
      } 
      paramTXCloudVideoView.getVideoView().setVisibility(0);
    } 
    super.a(paramTXCloudVideoView);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b() {
    this.f.b();
    n n1 = this.h;
    if (n1 != null)
      n1.d(); 
  }
  
  public void b(float paramFloat) {
    this.m = paramFloat;
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null)
      tXCVodVideoView.setRate(paramFloat); 
    n n1 = this.h;
    if (n1 != null)
      n1.a(paramFloat); 
  }
  
  public void b(int paramInt) {
    this.f.setVideoRotationDegree(360 - paramInt);
  }
  
  public void b(boolean paramBoolean) {
    this.f.setMute(paramBoolean);
  }
  
  public void c(float paramFloat) {
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null)
      tXCVodVideoView.setStartTime(paramFloat); 
  }
  
  public void c(int paramInt) {
    this.f.setVolume(paramInt);
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c() {
    return this.f.e();
  }
  
  public int d(int paramInt) {
    return 0;
  }
  
  public TextureView d() {
    return (this.d != null) ? this.d.getVideoView() : null;
  }
  
  public boolean d(boolean paramBoolean) {
    this.j = paramBoolean;
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? tXCVodVideoView.b(paramBoolean) : true;
  }
  
  public int e() {
    return 0;
  }
  
  public void e(int paramInt) {
    this.f.a(paramInt * 1000);
    if (this.i) {
      n n1 = this.h;
      if (n1 != null)
        n1.k(); 
    } 
  }
  
  public void e(boolean paramBoolean) {
    this.k = paramBoolean;
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null)
      tXCVodVideoView.setAutoPlay(paramBoolean); 
  }
  
  public void f(int paramInt) {
    this.f.setAudioPlayoutVolume(paramInt);
  }
  
  public void f(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void g(int paramInt) {
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null)
      tXCVodVideoView.setBitrateIndex(paramInt); 
    if (this.i) {
      n n1 = this.h;
      if (n1 != null)
        n1.l(); 
    } 
  }
  
  public void g(boolean paramBoolean) {
    TextureView textureView = d();
    if (textureView != null) {
      boolean bool = this.b.t;
      float f = -1.0F;
      if (bool && (this.f.getMetaRotationDegree() == 90 || this.f.getMetaRotationDegree() == 270)) {
        if (!paramBoolean)
          f = 1.0F; 
        textureView.setScaleY(f);
      } else {
        if (!paramBoolean)
          f = 1.0F; 
        textureView.setScaleX(f);
      } 
    } 
    n n1 = this.h;
    if (n1 != null)
      n1.b(paramBoolean); 
  }
  
  public float h() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? (tXCVodVideoView.getCurrentPosition() / 1000.0F) : 0.0F;
  }
  
  public int i() {
    return 0;
  }
  
  public float j() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? (tXCVodVideoView.getBufferDuration() / 1000.0F) : 0.0F;
  }
  
  public float k() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? (tXCVodVideoView.getDuration() / 1000.0F) : 0.0F;
  }
  
  public float l() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? (tXCVodVideoView.getBufferDuration() / 1000.0F) : 0.0F;
  }
  
  public int m() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? tXCVodVideoView.getVideoWidth() : 0;
  }
  
  public int n() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? tXCVodVideoView.getVideoHeight() : 0;
  }
  
  public int o() {
    TXCVodVideoView tXCVodVideoView = this.f;
    return (tXCVodVideoView != null) ? tXCVodVideoView.getBitrateIndex() : 0;
  }
  
  public ArrayList<TXBitrateItem> p() {
    ArrayList<TXBitrateItem> arrayList = new ArrayList();
    TXCVodVideoView tXCVodVideoView = this.f;
    if (tXCVodVideoView != null) {
      ArrayList arrayList1 = tXCVodVideoView.getSupportedBitrates();
      if (arrayList1 != null)
        for (IjkBitrateItem ijkBitrateItem : arrayList1) {
          TXBitrateItem tXBitrateItem = new TXBitrateItem();
          tXBitrateItem.index = ijkBitrateItem.index;
          tXBitrateItem.width = ijkBitrateItem.width;
          tXBitrateItem.height = ijkBitrateItem.height;
          tXBitrateItem.bitrate = ijkBitrateItem.bitrate;
          arrayList.add(tXBitrateItem);
        }  
    } 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.tencent.avroom;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.avprotocol.TXCAVProtocol;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.renderer.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class a {
  private static String c = "DataCollectionPlayer";
  
  private long a;
  
  private Handler b = new Handler(Looper.getMainLooper());
  
  private HashMap d = new HashMap<Object, Object>(100);
  
  private HashMap e = new HashMap<Object, Object>(100);
  
  private HashMap f = new HashMap<Object, Object>(100);
  
  private boolean g = false;
  
  private long h = 0L;
  
  private long i = 0L;
  
  private long j = 0L;
  
  private long k = 0L;
  
  private int l = 0;
  
  private int m = 0;
  
  private TXCAVRoomLisenter n;
  
  private WeakReference<f> o;
  
  private WeakReference<TXCAVProtocol> p;
  
  private WeakReference<TXCRenderAndDec> q;
  
  private TimerTask r = null;
  
  private Timer s;
  
  public a(long paramLong) {
    this.a = paramLong;
  }
  
  private int a(String paramString) {
    Number number = (Number)this.d.get(paramString);
    return (number != null) ? number.intValue() : 0;
  }
  
  private long a(String paramString, long paramLong) {
    boolean bool = this.f.containsKey(paramString);
    Long long_ = Long.valueOf(0L);
    if (!bool)
      this.f.put(paramString, long_); 
    if (!this.e.containsKey(paramString))
      this.e.put(paramString, long_); 
    if (((Long)this.e.get(paramString)).longValue() > paramLong) {
      HashMap<String, Long> hashMap = this.f;
      hashMap.put(paramString, Long.valueOf(((Long)hashMap.get(paramString)).longValue() + paramLong));
      this.e.put(paramString, Long.valueOf(paramLong));
      return paramLong;
    } 
    long l = ((Long)this.e.get(paramString)).longValue();
    this.e.put(paramString, Long.valueOf(paramLong));
    return paramLong - l;
  }
  
  private void a(TXCAVProtocol.DownloadStats paramDownloadStats, long paramLong) {
    if (paramDownloadStats != null) {
      if (paramLong == 0L)
        return; 
      String str = c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateNetStats: diff_a raw ");
      stringBuilder.append(paramDownloadStats.afterParseAudioBytes);
      TXCLog.i(str, stringBuilder.toString());
      str = c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("updateNetStats: diff_v raw ");
      stringBuilder.append(paramDownloadStats.afterParseVideoBytes);
      TXCLog.i(str, stringBuilder.toString());
      paramDownloadStats.afterParseAudioBytes = this.l;
      paramDownloadStats.afterParseVideoBytes = this.m;
      long l1 = a("u32_avg_audio_bitrate", paramDownloadStats.afterParseAudioBytes);
      str = c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("updateNetStats: kAvgAudioBitrate ");
      paramLong = 1024L * paramLong;
      long l2 = l1 * 8L * 1000L / paramLong;
      stringBuilder.append(Long.valueOf(l2));
      TXCLog.i(str, stringBuilder.toString());
      this.d.put("u32_avg_audio_bitrate", Long.valueOf(l2));
      l2 = a("u32_avg_video_bitrate", paramDownloadStats.afterParseVideoBytes);
      str = c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("updateNetStats: diff_v ");
      stringBuilder.append(l2);
      TXCLog.i(str, stringBuilder.toString());
      str = c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("updateNetStats: kAvgVideoBitrate ");
      long l3 = l2 * 8L * 1000L / paramLong;
      stringBuilder.append(Long.valueOf(l3));
      TXCLog.i(str, stringBuilder.toString());
      this.d.put("u32_avg_video_bitrate", Long.valueOf(l3));
      str = c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("updateNetStats: kAvgNetSpeed ");
      paramLong = (l1 + l2) * 8L * 1000L / paramLong;
      stringBuilder.append(Long.valueOf(paramLong));
      Log.i(str, stringBuilder.toString());
      this.d.put("u32_avg_net_speed", Long.valueOf(paramLong));
      this.d.put("u32_server_ip", paramDownloadStats.serverIP);
      this.d.put("u32_dns_time", Long.valueOf(paramDownloadStats.dnsTS));
      this.d.put("u32_connect_server_time", Long.valueOf(paramDownloadStats.connTS));
      this.d.put("u64_timestamp", Long.valueOf(paramDownloadStats.startTS));
      this.d.put("u32_first_frame_down", Long.valueOf(paramDownloadStats.firstVideoTS));
    } 
  }
  
  private void a(f.a parama, long paramLong) {
    if (parama != null) {
      if (paramLong == 0L)
        return; 
      long l = a("u32_fps", parama.c);
      this.d.put("u32_fps", Long.valueOf(l * 10000L / paramLong));
      this.d.put("u32_first_i_frame", Long.valueOf(parama.k));
      this.d.put("u32_avg_block_count", Long.valueOf(parama.g));
      this.d.put("u32_avg_block_time", Long.valueOf(parama.f));
      this.d.put("VIDEO_WIDTH", Long.valueOf(parama.m));
      this.d.put("VIDEO_HEIGHT", Long.valueOf(parama.n));
    } 
  }
  
  private Bundle d() {
    Bundle bundle = new Bundle();
    int i = ((Long)this.d.get("u32_app_cpu_usage")).intValue() / 10;
    int j = ((Long)this.d.get("u32_cpu_usage")).intValue() / 10;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("/");
    stringBuilder.append(j);
    stringBuilder.append("%");
    String str = stringBuilder.toString();
    bundle.putLong("myid", 16842960L);
    bundle.putCharSequence("CPU_USAGE", str);
    bundle.putInt("VIDEO_WIDTH", a("VIDEO_WIDTH"));
    bundle.putInt("VIDEO_HEIGHT", a("VIDEO_HEIGHT"));
    bundle.putInt("NET_SPEED", a("u32_avg_net_speed"));
    bundle.putInt("VIDEO_FPS", a("u32_fps") / 10);
    bundle.putInt("VIDEO_DROP", a("video_drop"));
    bundle.putInt("VIDEO_BITRATE", a("u32_avg_video_bitrate"));
    bundle.putInt("AUDIO_BITRATE", a("u32_avg_audio_bitrate"));
    bundle.putInt("AUDIO_CACHE", a("AUDIO_CACHE"));
    bundle.putInt("VIDEO_CACHE", a("VIDEO_CACHE"));
    bundle.putInt("V_SUM_CACHE_SIZE", a("VIDEO_CACHE_CNT"));
    bundle.putInt("V_DEC_CACHE_SIZE", a("V_DEC_CACHE_CNT"));
    bundle.putInt("AV_PLAY_INTERVAL", a("AV_INTERVAL"));
    bundle.putString("AUDIO_PLAY_INFO", (String)this.d.get("AUDIO_INFO"));
    bundle.putCharSequence("SERVER_IP", (String)this.d.get("u32_server_ip"));
    bundle.putInt("NET_JITTER", a("AUDIO_JITTER"));
    bundle.putInt("AV_RECV_INTERVAL", a("AV_NET_RECV_INTERVAL"));
    bundle.putFloat("AUDIO_CACHE_THRESHOLD", a("AUDIO_SPEED"));
    j = a("u32_fps") / 10;
    i = j;
    if (j == 0)
      i = 15; 
    bundle.putInt("VIDEO_GOP", (int)(((a("VIDEO_GOP") * 10 / i) / 10.0F) + 0.5D));
    return bundle;
  }
  
  public void a() {
    TimerTask timerTask = this.r;
    if (timerTask != null)
      timerTask.cancel(); 
    this.s = new Timer(true);
    this.r = new TimerTask(this) {
        public void run() {
          TXCLog.i(a.c(), "dataCollectingStart run: ");
          if (a.a(this.a) != null) {
            TXCAVProtocol tXCAVProtocol = a.a(this.a).get();
            if (tXCAVProtocol != null) {
              TXCAVProtocol.DownloadStats downloadStats = tXCAVProtocol.getDownloadStats();
              a.a(this.a, downloadStats, 2000L);
            } 
          } 
          if (a.b(this.a) != null) {
            f f = a.b(this.a).get();
            if (f != null) {
              f.a a1 = f.l();
              a.a(this.a, a1, 2000L);
            } 
          } 
          long l = ((TXCRenderAndDec)a.c(this.a).get()).getVideoCacheFrameCount();
          if (a.d(this.a)) {
            a.e(this.a);
            a a1 = this.a;
            a.a(a1, a.f(a1) + l);
            if (l > a.g(this.a))
              a.b(this.a, l); 
          } 
          if (a.c(this.a) != null && a.c(this.a).get() != null) {
            a.h(this.a).put("VIDEO_CACHE", Integer.valueOf((int)((TXCRenderAndDec)a.c(this.a).get()).getVideoCacheDuration()));
            a.h(this.a).put("VIDEO_CACHE_CNT", Integer.valueOf((int)((TXCRenderAndDec)a.c(this.a).get()).getVideoCacheFrameCount()));
            a.h(this.a).put("V_DEC_CACHE_CNT", Integer.valueOf(((TXCRenderAndDec)a.c(this.a).get()).getVideoDecCacheFrameCount()));
            a.h(this.a).put("AV_INTERVAL", Integer.valueOf((int)((TXCRenderAndDec)a.c(this.a).get()).getAVPlayInterval()));
            a.h(this.a).put("AV_NET_RECV_INTERVAL", Long.valueOf(((TXCRenderAndDec)a.c(this.a).get()).getAVNetRecvInterval()));
            a.h(this.a).put("VIDEO_GOP", Integer.valueOf(((TXCRenderAndDec)a.c(this.a).get()).getVideoGop()));
          } 
          int i = TXCAudioEngine.getInstance().getPlayAECType();
          int j = TXCStatus.c(String.valueOf(a.i(this.a)), 2019);
          int k = TXCStatus.c(String.valueOf(a.i(this.a)), 2020);
          int m = TXCAudioEngine.getInstance().getPlaySampleRate();
          int n = TXCAudioEngine.getInstance().getPlayChannels();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append(" | ");
          stringBuilder.append(j);
          stringBuilder.append(",");
          stringBuilder.append(k);
          stringBuilder.append(" | ");
          stringBuilder.append(m);
          stringBuilder.append(",");
          stringBuilder.append(n);
          String str = stringBuilder.toString();
          a.h(this.a).put("AUDIO_INFO", str);
          a.h(this.a).put("AUDIO_CACHE", Integer.valueOf(TXCStatus.c(String.valueOf(a.i(this.a)), 2007)));
          a.h(this.a).put("AUDIO_JITTER", Integer.valueOf(TXCStatus.c(String.valueOf(a.i(this.a)), 2018)));
          a.h(this.a).put("AUDIO_SPEED", Integer.valueOf(TXCStatus.c(String.valueOf(a.i(this.a)), 2021)));
          int[] arrayOfInt = g.a();
          a.h(this.a).put("u32_app_cpu_usage", Long.valueOf(arrayOfInt[0]));
          a.h(this.a).put("u32_cpu_usage", Long.valueOf(arrayOfInt[1]));
          Bundle bundle = a.j(this.a);
          a.l(this.a).post(new Runnable(this, bundle) {
                public void run() {
                  if (a.k(this.b.a) != null)
                    a.k(this.b.a).onAVRoomStatus(a.i(this.b.a), this.a); 
                }
              });
        }
      };
    this.s.schedule(this.r, 0L, 2000L);
  }
  
  public void a(int paramInt) {
    this.m += paramInt;
  }
  
  public void a(TXCAVRoomLisenter paramTXCAVRoomLisenter) {
    this.n = paramTXCAVRoomLisenter;
  }
  
  public void a(TXCRenderAndDec paramTXCRenderAndDec) {
    this.q = new WeakReference<TXCRenderAndDec>(paramTXCRenderAndDec);
  }
  
  public void a(TXCAVProtocol paramTXCAVProtocol) {
    this.p = new WeakReference<TXCAVProtocol>(paramTXCAVProtocol);
  }
  
  public void a(f paramf) {
    if (paramf != null)
      paramf.setID(String.format("%d", new Object[] { Long.valueOf(this.a) })); 
    this.o = new WeakReference<f>(paramf);
  }
  
  public void b() {
    Timer timer = this.s;
    if (timer != null) {
      timer.cancel();
      this.s = null;
    } 
    HashMap hashMap = this.d;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  public void b(int paramInt) {
    this.l += paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
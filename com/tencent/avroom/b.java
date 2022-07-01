package com.tencent.avroom;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.liteav.avprotocol.TXCAVProtocol;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.d;
import com.tencent.liteav.e;
import com.tencent.liteav.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class b extends a {
  private static String d = "DataCollectionPusher";
  
  private Context a;
  
  private long b;
  
  private Handler c = new Handler(Looper.getMainLooper());
  
  private e e = null;
  
  private TXCAVRoomLisenter f;
  
  private TimerTask g = null;
  
  private Timer h;
  
  private WeakReference<d> i = null;
  
  private WeakReference<TXCAVProtocol> j;
  
  private HashMap k = new HashMap<Object, Object>(100);
  
  private HashMap l = new HashMap<Object, Object>(100);
  
  private HashMap m = new HashMap<Object, Object>(100);
  
  public b(int paramInt, long paramLong, Context paramContext, i parami) {
    this.a = paramContext.getApplicationContext();
    this.b = paramLong;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(paramLong);
    setID(stringBuilder2.toString());
    this.e = new e(this.a);
    this.e.a(parami.c);
    this.e.b(parami.s);
    this.e.a(parami.a, parami.b);
    e e1 = this.e;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("");
    stringBuilder4.append(paramLong);
    e1.d(stringBuilder4.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("");
    stringBuilder1.append(paramInt);
    stringBuilder1.append("_");
    stringBuilder1.append(paramLong);
    String str = stringBuilder1.toString();
    e e2 = this.e;
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append("rtmp://0.livepush.myqcloud.com/live/");
    stringBuilder5.append(str);
    e2.a(stringBuilder5.toString());
    str = d;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("stream_id = ");
    stringBuilder3.append(paramLong);
    TXCLog.w(str, stringBuilder3.toString());
  }
  
  private int a(String paramString) {
    Number number = (Number)this.k.get(paramString);
    return (number != null) ? number.intValue() : 0;
  }
  
  private long a(String paramString, long paramLong) {
    boolean bool = this.m.containsKey(paramString);
    Long long_ = Long.valueOf(0L);
    if (!bool)
      this.m.put(paramString, long_); 
    if (!this.l.containsKey(paramString))
      this.l.put(paramString, long_); 
    if (((Long)this.l.get(paramString)).longValue() > paramLong) {
      HashMap<String, Long> hashMap = this.m;
      hashMap.put(paramString, Long.valueOf(((Long)hashMap.get(paramString)).longValue() + paramLong));
      this.l.put(paramString, Long.valueOf(paramLong));
      return paramLong;
    } 
    long l = ((Long)this.l.get(paramString)).longValue();
    this.l.put(paramString, Long.valueOf(paramLong));
    return paramLong - l;
  }
  
  private void a(TXCAVProtocol.UploadStats paramUploadStats, long paramLong) {
    if (paramUploadStats != null) {
      if (paramLong == 0L)
        return; 
      long l1 = a("u32_avg_video_bitrate", paramUploadStats.inVideoBytes);
      HashMap<String, Long> hashMap = this.k;
      paramLong *= 1024L;
      hashMap.put("u32_avg_video_bitrate", Long.valueOf(l1 * 8L * 1000L / paramLong));
      l1 = a("u32_avg_audio_bitrate", paramUploadStats.inAudioBytes);
      this.k.put("u32_avg_audio_bitrate", Long.valueOf(l1 * 8L * 1000L / paramLong));
      l1 = a("VIDEO_BITRATE", paramUploadStats.outVideoBytes);
      long l2 = a("AUDIO_BITRATE", paramUploadStats.outAudioBytes);
      this.k.put("u32_avg_net_speed_video", Long.valueOf(l1 * 8L * 1000L / paramLong));
      this.k.put("u32_avg_net_speed_audio", Long.valueOf(l2 * 8L * 1000L / paramLong));
      this.k.put("u32_avg_net_speed", Long.valueOf((l2 + l1) * 8L * 1000L / paramLong));
      this.k.put("u32_avg_cache_size", Long.valueOf(paramUploadStats.videoCacheLen));
      this.k.put("video_drop", Long.valueOf(paramUploadStats.videoDropCount));
      this.k.put("u32_server_ip", paramUploadStats.serverIP);
      if (paramUploadStats.dnsTS != -1L) {
        this.k.put("u32_dns_time", Long.valueOf(paramUploadStats.dnsTS - paramUploadStats.startTS));
      } else {
        this.k.put("u32_dns_time", Long.valueOf(paramUploadStats.dnsTS));
      } 
      if (paramUploadStats.connTS != -1L) {
        this.k.put("u32_connect_server_time", Long.valueOf(paramUploadStats.connTS - paramUploadStats.startTS));
      } else {
        this.k.put("u32_connect_server_time", Long.valueOf(paramUploadStats.connTS));
      } 
      this.k.put("u32_channel_type", Long.valueOf(paramUploadStats.channelType));
      this.k.put("u64_timestamp", Long.valueOf(paramUploadStats.startTS));
    } 
  }
  
  private Bundle d() {
    Bundle bundle = new Bundle();
    int i = ((Long)this.k.get("u32_app_cpu_usage")).intValue() / 10;
    int j = ((Long)this.k.get("u32_cpu_usage")).intValue() / 10;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("/");
    stringBuilder.append(j);
    stringBuilder.append("%");
    String str = stringBuilder.toString();
    bundle.putLong("myid", this.b);
    bundle.putCharSequence("CPU_USAGE", str);
    bundle.putInt("VIDEO_WIDTH", a("VIDEO_WIDTH"));
    bundle.putInt("VIDEO_HEIGHT", a("VIDEO_HEIGHT"));
    bundle.putInt("NET_SPEED", a("u32_avg_net_speed"));
    bundle.putInt("VIDEO_FPS", a("u32_fps"));
    bundle.putInt("VIDEO_DROP", a("video_drop"));
    bundle.putInt("VIDEO_BITRATE", a("u32_avg_video_bitrate"));
    bundle.putInt("AUDIO_BITRATE", a("u32_avg_audio_bitrate"));
    bundle.putInt("AUDIO_CACHE", a("u32_avg_cache_size"));
    bundle.putString("AUDIO_PLAY_INFO", (String)this.k.get("AUDIO_INFO"));
    bundle.putCharSequence("SERVER_IP", (String)this.k.get("u32_server_ip"));
    bundle.putInt("qos_video_bitrate", a("qos_video_bitrate"));
    j = a("u32_fps");
    i = j;
    if (j == 0)
      i = 15; 
    bundle.putInt("VIDEO_GOP", (int)(((a("VIDEO_GOP") * 10 / i) / 10.0F) + 0.5D));
    return bundle;
  }
  
  public void a() {
    TimerTask timerTask = this.g;
    if (timerTask != null)
      timerTask.cancel(); 
    this.e.a();
    this.h = new Timer(true);
    this.g = new TimerTask(this) {
        public void run() {
          if (b.a(this.a) != null) {
            TXCAVProtocol tXCAVProtocol = b.a(this.a).get();
            if (tXCAVProtocol != null) {
              TXCAVProtocol.UploadStats uploadStats = tXCAVProtocol.getUploadStats();
              b.a(this.a, uploadStats, 2000L);
              this.a.setStatusValue(7012, String.valueOf(uploadStats.serverIP));
            } 
          } 
          if (b.b(this.a) != null) {
            d d1 = b.b(this.a).get();
            if (d1 != null) {
              b.c(this.a).put("VIDEO_WIDTH", Long.valueOf(d1.d()));
              b.c(this.a).put("VIDEO_HEIGHT", Long.valueOf(d1.e()));
            } 
          } 
          if (b.b(this.a) != null && b.b(this.a).get() != null)
            b.c(this.a).put("VIDEO_GOP", Integer.valueOf(TXCStatus.c(((d)b.b(this.a).get()).getID(), 4006))); 
          int[] arrayOfInt = g.a();
          b.c(this.a).put("u32_app_cpu_usage", Long.valueOf(arrayOfInt[0]));
          b.c(this.a).put("u32_cpu_usage", Long.valueOf(arrayOfInt[1]));
          double d = TXCStatus.d(this.a.getID(), 4001);
          b.c(this.a).put("u32_fps", Long.valueOf((long)d));
          String str = b.c();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("run: kAvgVideoBitrate");
          stringBuilder.append(Long.valueOf(TXCStatus.c(this.a.getID(), 4002)));
          Log.i(str, stringBuilder.toString());
          Bundle bundle = b.d(this.a);
          b.g(this.a).post(new Runnable(this, bundle) {
                public void run() {
                  if (b.e(this.b.a) != null)
                    b.e(this.b.a).onAVRoomStatus(b.f(this.b.a), this.a); 
                }
              });
          b b1 = this.a;
          b1.setStatusValue(7002, b.c(b1).get("u32_avg_audio_bitrate"));
          b1 = this.a;
          b1.setStatusValue(7001, b.c(b1).get("u32_avg_video_bitrate"));
          b1 = this.a;
          b1.setStatusValue(7004, b.c(b1).get("u32_avg_net_speed_audio"));
          b1 = this.a;
          b1.setStatusValue(7003, b.c(b1).get("u32_avg_net_speed_video"));
          b1 = this.a;
          b1.setStatusValue(7005, b.c(b1).get("u32_avg_cache_size"));
          b1 = this.a;
          b1.setStatusValue(7007, b.c(b1).get("video_drop"));
          b1 = this.a;
          b1.setStatusValue(7007, b.c(b1).get("video_drop"));
          if (b.h(this.a) != null)
            b.h(this.a).e(); 
        }
      };
    this.h.schedule(this.g, 0L, 2000L);
  }
  
  public void a(TXCAVRoomLisenter paramTXCAVRoomLisenter) {
    this.f = paramTXCAVRoomLisenter;
  }
  
  public void a(TXCAVProtocol paramTXCAVProtocol) {
    this.j = new WeakReference<TXCAVProtocol>(paramTXCAVProtocol);
  }
  
  public void a(d paramd) {
    this.i = new WeakReference<d>(paramd);
  }
  
  public void b() {
    Timer timer = this.h;
    if (timer != null) {
      timer.cancel();
      this.h = null;
    } 
    e e1 = this.e;
    if (e1 != null)
      e1.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
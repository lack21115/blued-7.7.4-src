package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.network.a.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class e {
  private static HashMap<String, a> D = new HashMap<String, a>();
  
  private static String a = "TXCDataReport";
  
  private long A = 0L;
  
  private int B = 0;
  
  private String C;
  
  private String E = "";
  
  private String F = "";
  
  private HashMap b = new HashMap<Object, Object>(100);
  
  private String c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private Context h;
  
  private String i;
  
  private long j;
  
  private long k;
  
  private long l;
  
  private long m;
  
  private long n;
  
  private long o;
  
  private boolean p;
  
  private long q;
  
  private int r;
  
  private long s = 0L;
  
  private long t = 0L;
  
  private boolean u = false;
  
  private long v = 0L;
  
  private long w = 0L;
  
  private long x = 0L;
  
  private long y = 0L;
  
  private long z = 0L;
  
  public e(Context paramContext) {
    this.h = paramContext.getApplicationContext();
    this.i = TXCCommonUtil.getAppVersion();
    this.r = 5000;
    this.z = 0L;
  }
  
  private void a(int paramInt, String paramString) {
    String str2 = TXCStatus.b(this.E, 7121);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = paramString; 
    this.b.put("str_session_id", str1);
    this.b.put("u32_server_ip", TXCStatus.b(this.E, 7110));
    if (this.u) {
      this.b.put("str_stream_url", TXCStatus.b(this.E, 7116));
      f((String)this.b.get("str_stream_url"));
    } else {
      this.b.put("str_stream_url", TXCStatus.b(this.E, 7119));
    } 
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_session_id", (String)this.b.get("str_session_id"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_os_info", (String)this.b.get("str_os_info"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(paramString, paramInt, "u32_network_type", g("u32_network_type"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "u32_server_ip", (String)this.b.get("u32_server_ip"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_stream_url", (String)this.b.get("str_stream_url"));
  }
  
  private void c(int paramInt) {
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.url = this.c;
    tXCDRExtInfo.report_common = false;
    tXCDRExtInfo.report_status = false;
    String str1 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str1, paramInt, a.an, tXCDRExtInfo);
    a(paramInt, str1);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u64_timestamp", ((Long)this.b.get("u64_timestamp")).longValue());
    long l7 = TXCStatus.a(this.E, 7107);
    long l2 = TXCStatus.a(this.E, 7108);
    long l3 = -1L;
    long l1 = l2;
    if (l2 != -1L)
      l1 = l2 - l7; 
    if (l1 < 0L) {
      l2 = -1L;
    } else {
      l2 = l1;
    } 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_dns_time", l2);
    long l4 = TXCStatus.a(this.E, 7109);
    l2 = l4;
    if (l4 != -1L)
      l2 = l4 - l7; 
    if (l2 >= 0L)
      l3 = l2; 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_connect_server_time", l3);
    int i = TXCStatus.c(this.E, 5004);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_decode_type", i);
    this.j = TXCStatus.a(this.E, 6001) - l7;
    l3 = this.j;
    if (l3 < 0L)
      l3 = -1L; 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_first_i_frame", l3);
    l4 = TXCStatus.a(this.E, 7103) - l7;
    if (l4 < 0L) {
      l3 = -1L;
    } else {
      l3 = l4;
    } 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_first_frame_down", l3);
    long l5 = TXCStatus.a(this.E, 5005) - l7;
    if (l5 < 0L) {
      l3 = -1L;
    } else {
      l3 = l5;
    } 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_first_video_decode_time", l3);
    long l6 = TXCStatus.a(this.E, 7104) - l7;
    if (l6 < 0L) {
      l3 = -1L;
    } else {
      l3 = l6;
    } 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_first_audio_frame_down", l3);
    l7 = TXCStatus.a(this.E, 2033) - l7;
    if (l7 < 0L) {
      l3 = -1L;
    } else {
      l3 = l7;
    } 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_first_audio_render_time", l3);
    int j = TXCStatus.c(this.E, 7105);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u64_err_code", j);
    int k = TXCStatus.c(this.E, 7106);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "str_err_info", k);
    int m = TXCStatus.c(this.E, 7112);
    TXCDRApi.txSetEventValue(str1, paramInt, "u32_link_type", String.valueOf(m));
    int n = TXCStatus.c(this.E, 7111);
    TXCDRApi.txSetEventValue(str1, paramInt, "u32_channel_type", String.valueOf(n));
    TXCDRApi.txSetEventValue(str1, paramInt, "str_app_version", this.i);
    TXCDRApi.nativeReportEvent(str1, paramInt);
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report evt ");
    stringBuilder.append(paramInt);
    stringBuilder.append(": token=");
    stringBuilder.append(str1);
    stringBuilder.append("\n");
    stringBuilder.append("str_user_id");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_user_id"));
    stringBuilder.append("\n");
    stringBuilder.append("dev_uuid");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("dev_uuid"));
    stringBuilder.append("\n");
    stringBuilder.append("str_session_id");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_session_id"));
    stringBuilder.append("\n");
    stringBuilder.append("str_device_type");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_device_type"));
    stringBuilder.append("\n");
    stringBuilder.append("str_os_info");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_os_info"));
    stringBuilder.append("\n");
    stringBuilder.append("str_package_name");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_package_name"));
    stringBuilder.append("\n");
    stringBuilder.append("u32_network_type");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("u32_network_type"));
    stringBuilder.append("\n");
    stringBuilder.append("u32_server_ip");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("u32_server_ip"));
    stringBuilder.append("\n");
    stringBuilder.append("str_stream_url");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_stream_url"));
    stringBuilder.append("\n");
    stringBuilder.append("u64_timestamp");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("u64_timestamp"));
    stringBuilder.append("\n");
    stringBuilder.append("u32_dns_time");
    stringBuilder.append("=");
    stringBuilder.append(l1);
    stringBuilder.append("\n");
    stringBuilder.append("u32_connect_server_time");
    stringBuilder.append("=");
    stringBuilder.append(l2);
    stringBuilder.append("\n");
    stringBuilder.append("u32_video_decode_type");
    stringBuilder.append("=");
    stringBuilder.append(i);
    stringBuilder.append("\n");
    stringBuilder.append("u32_first_frame_down");
    stringBuilder.append("=");
    stringBuilder.append(l4);
    stringBuilder.append("\n");
    stringBuilder.append("u32_first_video_decode_time");
    stringBuilder.append("=");
    stringBuilder.append(l5);
    stringBuilder.append("\n");
    stringBuilder.append("u32_first_i_frame");
    stringBuilder.append("=");
    stringBuilder.append(this.j);
    stringBuilder.append("\n");
    stringBuilder.append("u32_first_audio_frame_down");
    stringBuilder.append("=");
    stringBuilder.append(l6);
    stringBuilder.append("\n");
    stringBuilder.append("u32_first_audio_render_time");
    stringBuilder.append("=");
    stringBuilder.append(l7);
    stringBuilder.append("\n");
    stringBuilder.append("u64_err_code");
    stringBuilder.append("=");
    stringBuilder.append(j);
    stringBuilder.append("\n");
    stringBuilder.append("str_err_info");
    stringBuilder.append("=");
    stringBuilder.append(k);
    stringBuilder.append("\n");
    stringBuilder.append("u32_link_type");
    stringBuilder.append("=");
    stringBuilder.append(m);
    stringBuilder.append("\n");
    stringBuilder.append("u32_channel_type");
    stringBuilder.append("=");
    stringBuilder.append(n);
    stringBuilder.append("\n");
    stringBuilder.append("str_app_version");
    stringBuilder.append("=");
    stringBuilder.append(this.i);
    TXCLog.d(str2, stringBuilder.toString());
  }
  
  protected static boolean c(String paramString) {
    return (paramString != null && paramString.contains("myqcloud")) ? true : c.a().a(paramString);
  }
  
  private void d(int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e(int paramInt) {
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.url = this.c;
    tXCDRExtInfo.report_common = false;
    tXCDRExtInfo.report_status = true;
    String str1 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str1, paramInt, a.an, tXCDRExtInfo);
    a(paramInt, str1);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    int[] arrayOfInt = g.a();
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_cpu_usage", arrayOfInt[1]);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_app_cpu_usage", arrayOfInt[0]);
    TXCDRApi.txSetEventValue(str1, paramInt, "u32_avg_cpu_usage", String.valueOf(TXCStatus.d(this.E, 9002)));
    TXCDRApi.txSetEventValue(str1, paramInt, "u32_avg_memory", String.valueOf(TXCStatus.d(this.E, 9005)));
    String str2 = this.E;
    int i = 2;
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_recv_av_diff_time", TXCStatus.a(str2, 6014, 2));
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_play_av_diff_time", TXCStatus.a(this.E, 6013, 2));
    TXCDRApi.txSetEventValue(str1, paramInt, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.z) / 1000L));
    if (TXCStatus.c(this.E, 2015) != 0)
      i = 1; 
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_decode_type", i);
    long l1 = TXCStatus.a(this.E, 2002);
    long l2 = this.o;
    if (l2 == -1L) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_block_count", Long.valueOf(0L).longValue());
    } else if (l1 >= l2) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_block_count", l1 - l2);
    } else {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_block_count", Long.valueOf(-1L).longValue());
    } 
    this.o = l1;
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_cache_time", TXCStatus.c(this.E, 2010));
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_drop", TXCStatus.c(this.E, 2014));
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_decode_type", TXCStatus.c(this.E, 5004));
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_recv_fps", j());
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_fps", (int)TXCStatus.d(this.E, 6002));
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_cache_time", TXCStatus.c(this.E, 6007));
    l1 = TXCStatus.a(this.E, 6008);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_cache_count", l1);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_avg_cache_count", l1);
    l2 = TXCStatus.a(this.E, 6004);
    long l3 = this.k;
    if (l3 == -1L) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_block_count", 0L);
    } else if (l2 >= l3) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_block_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_block_count", 0L);
    } 
    this.k = l2;
    i = TXCStatus.c(this.E, 7102);
    int j = TXCStatus.c(this.E, 7101);
    l2 = (i + j);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_net_speed", l2);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_avg_net_speed", l2);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_avg_audio_bitrate", i);
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_avg_video_bitrate", j);
    TXCDRApi.txSetEventValue(str1, paramInt, "u32_link_type", String.valueOf(TXCStatus.c(this.E, 7112)));
    TXCDRApi.txSetEventValue(str1, paramInt, "u32_channel_type", String.valueOf(TXCStatus.c(this.E, 7111)));
    TXCDRApi.txSetEventValue(str1, paramInt, "str_app_version", this.i);
    l2 = TXCStatus.a(this.E, 6021);
    l3 = this.l;
    if (l2 > l3) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_light_block_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_light_block_count", 0L);
    } 
    this.l = l2;
    l2 = TXCStatus.a(this.E, 6003);
    l3 = this.m;
    if (l2 > l3) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_large_block_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_large_block_count", 0L);
    } 
    this.m = l2;
    l2 = TXCStatus.c(this.E, 2034);
    l3 = this.n;
    if (l2 > l3) {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_jitter_60ms_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_jitter_60ms_count", 0L);
    } 
    this.n = l2;
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_video_decode_fail", TXCStatus.c(this.E, 9007));
    TXCDRApi.txSetEventIntValue(str1, paramInt, "u32_audio_decode_fail", TXCStatus.c(this.E, 2035));
    TXCDRApi.nativeReportEvent(str1, paramInt);
    if (this.u) {
      this.y++;
      this.x += l1;
      if (l1 > this.w)
        this.w = l1; 
    } 
  }
  
  private void f(String paramString) {
    if (!TextUtils.isEmpty(paramString) && paramString.startsWith("room://")) {
      String[] arrayOfString = paramString.split("/");
      arrayOfString[arrayOfString.length - 1].split("_");
      TXCStatus.a(this.E, 7112, Long.valueOf(3L));
    } 
  }
  
  private int g(String paramString) {
    Number number = (Number)this.b.get(paramString);
    return (number != null) ? number.intValue() : 0;
  }
  
  private void i() {
    a(6002, 6017, 6018);
    int[] arrayOfInt = g.a();
    TXCStatus.a(this.E, 9001, Integer.valueOf(arrayOfInt[0]));
    a(9001, 9002, 9003);
    TXCStatus.a(this.E, 9004, Integer.valueOf(g.b()));
    a(9004, 9005, 9006);
  }
  
  private int j() {
    int i;
    long l1 = TXCTimeUtil.getTimeTick();
    long l2 = TXCStatus.c(this.E, 6019);
    long l3 = this.s;
    if (l3 != 0L) {
      i = (int)((l2 - this.t) * 1000L / (l1 - l3));
    } else {
      i = (int)(1000L * l2 / (l1 - this.A));
    } 
    this.s = l1;
    this.t = l2;
    return i;
  }
  
  private void k() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String str1 = TXCStatus.b(this.E, 7116);
    String str3 = TXCStatus.b(this.E, 7117);
    String str4 = TXCStatus.b(this.E, 7118);
    int i = TXCStatus.c(this.E, 7105);
    String str5 = TXCStatus.b(this.E, 7106);
    int j = TXCStatus.c(this.E, 7111);
    hashMap.put("stream_url", str1);
    hashMap.put("stream_id", str3);
    hashMap.put("bizid", str4);
    hashMap.put("err_code", String.valueOf(i));
    hashMap.put("err_info", str5);
    hashMap.put("channel_type", String.valueOf(j));
    long l1 = System.currentTimeMillis();
    long l2 = this.v;
    hashMap.put("start_time", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date(this.v)));
    hashMap.put("end_time", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date(l1)));
    hashMap.put("total_time", String.valueOf(l1 - l2));
    l2 = TXCStatus.a(this.E, 6003);
    l1 = TXCStatus.a(this.E, 6006);
    long l3 = TXCStatus.a(this.E, 6005);
    if (l2 != 0L) {
      l1 /= l2;
    } else {
      l1 = 0L;
    } 
    hashMap.put("block_count", String.valueOf(l2));
    hashMap.put("block_duration_max", String.valueOf(l3));
    hashMap.put("block_duration_avg", String.valueOf(l1));
    l1 = this.y;
    if (l1 != 0L) {
      l1 = this.x / l1;
    } else {
      l1 = 0L;
    } 
    hashMap.put("jitter_cache_max", String.valueOf(this.w));
    hashMap.put("jitter_cache_avg", String.valueOf(l1));
    str1 = TXCDRApi.txCreateToken();
    i = a.ag;
    j = a.am;
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.command_id_comment = "LINKMIC";
    TXCDRApi.InitEvent(this.h, str1, i, j, tXCDRExtInfo);
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report evt 40402: token=");
    stringBuilder.append(str1);
    TXCLog.d(str2, stringBuilder.toString());
    for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
      str2 = (String)entry.getKey();
      String str = (String)entry.getValue();
      str5 = a;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("RealTimePlayStatisticInfo: ");
      stringBuilder1.append(str2);
      stringBuilder1.append(" = ");
      stringBuilder1.append(str);
      TXCLog.e(str5, stringBuilder1.toString());
      if (str2 != null && str2.length() > 0 && str != null)
        TXCDRApi.txSetEventValue(str1, i, str2, str); 
    } 
    TXCDRApi.nativeReportEvent(str1, i);
    this.u = false;
    this.v = 0L;
    this.y = 0L;
    this.x = 0L;
    this.w = 0L;
  }
  
  private void l() {
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.report_common = false;
    tXCDRExtInfo.report_status = false;
    tXCDRExtInfo.url = this.c;
    long l1 = TXCStatus.a(this.E, 7013);
    String str1 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str1, a.P, a.am, tXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str1, a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    TXCDRApi.txSetEventValue(str1, a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_network_type", g("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_dns_time", -1L);
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_connect_server_time", -1L);
    TXCDRApi.txSetEventValue(str1, a.P, "u32_server_ip", "");
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_video_resolution", (this.d << 16 | this.e));
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_audio_samplerate", this.g);
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_video_bitrate", this.f);
    TXCDRApi.txSetEventValue(str1, a.P, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str1, a.P, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str1, a.P, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str1, a.P, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str1, a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.nativeReportEvent(str1, a.P);
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report evt 40001: token=");
    stringBuilder.append(str1);
    stringBuilder.append(" ");
    stringBuilder.append("str_stream_url");
    stringBuilder.append("=");
    stringBuilder.append(this.c);
    stringBuilder.append(" ");
    stringBuilder.append("u64_timestamp");
    stringBuilder.append("=");
    stringBuilder.append(l2);
    stringBuilder.append(" ");
    stringBuilder.append("str_device_type");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_device_type"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_network_type");
    stringBuilder.append("=");
    stringBuilder.append(g("u32_network_type"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_dns_time");
    stringBuilder.append("=-1 ");
    stringBuilder.append("u32_connect_server_time");
    stringBuilder.append("=-1 ");
    stringBuilder.append("u32_server_ip");
    stringBuilder.append("= ");
    stringBuilder.append("u32_video_resolution");
    stringBuilder.append("=");
    stringBuilder.append(this.d << 16 | this.e);
    stringBuilder.append(" ");
    stringBuilder.append("u32_audio_samplerate");
    stringBuilder.append("=");
    stringBuilder.append(this.g);
    stringBuilder.append(" ");
    stringBuilder.append("u32_video_bitrate");
    stringBuilder.append("=");
    stringBuilder.append(this.f);
    stringBuilder.append(" ");
    stringBuilder.append("str_user_id");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_user_id"));
    stringBuilder.append(" ");
    stringBuilder.append("str_package_name");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_package_name"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_channel_type");
    stringBuilder.append("=");
    stringBuilder.append(l1);
    stringBuilder.append(" ");
    stringBuilder.append("str_app_version");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("dev_uuid"));
    stringBuilder.append(" ");
    stringBuilder.append("dev_uuid");
    stringBuilder.append("=");
    stringBuilder.append(g("u32_max_load"));
    TXCLog.d(str2, stringBuilder.toString());
  }
  
  private void m() {
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.report_common = false;
    tXCDRExtInfo.report_status = false;
    tXCDRExtInfo.url = this.c;
    String str1 = TXCStatus.b(this.E, 7012);
    long l4 = TXCStatus.a(this.E, 7009);
    long l2 = TXCStatus.a(this.E, 7010);
    long l1 = l2;
    if (l2 != -1L)
      l1 = l2 - l4; 
    long l3 = TXCStatus.a(this.E, 7011);
    l2 = l3;
    if (l3 != -1L)
      l2 = l3 - l4; 
    l3 = TXCStatus.a(this.E, 7013);
    String str2 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str2, a.P, a.am, tXCDRExtInfo);
    l4 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str2, a.P, "u64_timestamp", l4);
    TXCDRApi.txSetEventValue(str2, a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_network_type", g("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_dns_time", l1);
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_connect_server_time", l2);
    TXCDRApi.txSetEventValue(str2, a.P, "u32_server_ip", str1);
    int i = a.P;
    int j = this.d;
    TXCDRApi.txSetEventIntValue(str2, i, "u32_video_resolution", (this.e | j << 16));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_audio_samplerate", this.g);
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_video_bitrate", this.f);
    TXCDRApi.txSetEventValue(str2, a.P, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str2, a.P, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_channel_type", l3);
    TXCDRApi.txSetEventValue(str2, a.P, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str2, a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
    String str3 = TXCStatus.b(this.E, 7019);
    TXCDRApi.txSetEventValue(str2, a.P, "str_nearest_ip_list", str3);
    TXCDRApi.nativeReportEvent(str2, a.P);
    str3 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report evt 40001: token=");
    stringBuilder.append(str2);
    stringBuilder.append(" ");
    stringBuilder.append("str_stream_url");
    stringBuilder.append("=");
    stringBuilder.append(this.c);
    stringBuilder.append(" ");
    stringBuilder.append("u64_timestamp");
    stringBuilder.append("=");
    stringBuilder.append(l4);
    stringBuilder.append(" ");
    stringBuilder.append("str_device_type");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_device_type"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_network_type");
    stringBuilder.append("=");
    stringBuilder.append(g("u32_network_type"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_dns_time");
    stringBuilder.append("=");
    stringBuilder.append(l1);
    stringBuilder.append(" ");
    stringBuilder.append("u32_connect_server_time");
    stringBuilder.append("=");
    stringBuilder.append(l2);
    stringBuilder.append(" ");
    stringBuilder.append("u32_server_ip");
    stringBuilder.append("=");
    stringBuilder.append(str1);
    stringBuilder.append(" ");
    stringBuilder.append("u32_video_resolution");
    stringBuilder.append("=");
    stringBuilder.append(this.d << 16 | this.e);
    stringBuilder.append(" ");
    stringBuilder.append("u32_audio_samplerate");
    stringBuilder.append("=");
    stringBuilder.append(this.g);
    stringBuilder.append(" ");
    stringBuilder.append("u32_video_bitrate");
    stringBuilder.append("=");
    stringBuilder.append(this.f);
    stringBuilder.append(" ");
    stringBuilder.append("str_user_id");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_user_id"));
    stringBuilder.append(" ");
    stringBuilder.append("str_package_name");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_package_name"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_channel_type");
    stringBuilder.append("=");
    stringBuilder.append(l3);
    stringBuilder.append(" ");
    stringBuilder.append("str_app_version");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("dev_uuid"));
    stringBuilder.append(" ");
    stringBuilder.append("dev_uuid");
    stringBuilder.append("=");
    stringBuilder.append(g("u32_max_load"));
    TXCLog.d(str3, stringBuilder.toString());
  }
  
  private void n() {
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.report_common = false;
    tXCDRExtInfo.report_status = false;
    tXCDRExtInfo.url = this.c;
    long l3 = TXCStatus.a(this.E, 7009);
    long l1 = TXCStatus.a(this.E, 7013);
    String str1 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str1, a.R, a.am, tXCDRExtInfo);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str1, a.R, "u64_timestamp", l2);
    l3 = (TXCTimeUtil.getTimeTick() - l3) / 1000L;
    TXCDRApi.txSetEventIntValue(str1, a.R, "u32_result", l3);
    TXCDRApi.txSetEventValue(str1, a.R, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str1, a.R, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str1, a.R, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str1, a.R, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str1, a.R, "dev_uuid", (String)this.b.get("dev_uuid"));
    int i = TXCStatus.c(this.E, 7016);
    TXCDRApi.txSetEventValue(str1, a.R, "u32_ip_count_quic", String.valueOf(i));
    i = TXCStatus.c(this.E, 7017);
    TXCDRApi.txSetEventValue(str1, a.R, "u32_connect_count_quic", String.valueOf(i));
    i = TXCStatus.c(this.E, 7018);
    TXCDRApi.txSetEventValue(str1, a.R, "u32_connect_count_tcp", String.valueOf(i));
    TXCDRApi.nativeReportEvent(str1, a.R);
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report evt 40002: token=");
    stringBuilder.append(str1);
    stringBuilder.append(" ");
    stringBuilder.append("str_stream_url");
    stringBuilder.append("=");
    stringBuilder.append(this.c);
    stringBuilder.append(" ");
    stringBuilder.append("u64_timestamp");
    stringBuilder.append("=");
    stringBuilder.append(l2);
    stringBuilder.append(" ");
    stringBuilder.append("u32_result");
    stringBuilder.append("=");
    stringBuilder.append(l3);
    stringBuilder.append(" ");
    stringBuilder.append("str_user_id");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_user_id"));
    stringBuilder.append(" ");
    stringBuilder.append("str_package_name");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("str_package_name"));
    stringBuilder.append(" ");
    stringBuilder.append("u32_channel_type");
    stringBuilder.append("=");
    stringBuilder.append(l1);
    stringBuilder.append(" ");
    stringBuilder.append("str_app_version");
    stringBuilder.append("=");
    stringBuilder.append(this.i);
    stringBuilder.append(" ");
    stringBuilder.append("dev_uuid");
    stringBuilder.append("=");
    stringBuilder.append(this.b.get("dev_uuid"));
    TXCLog.d(str2, stringBuilder.toString());
  }
  
  private void o() {
    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
    tXCDRExtInfo.report_common = false;
    tXCDRExtInfo.report_status = true;
    tXCDRExtInfo.url = this.c;
    int[] arrayOfInt = g.a();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = g.b();
    long l1 = TXCStatus.a(this.E, 7013);
    int m = TXCStatus.c(this.E, 7004);
    int n = TXCStatus.c(this.E, 7003);
    double d1 = TXCStatus.d(this.E, 4001);
    int i1 = TXCStatus.c(this.E, 7005);
    int i2 = TXCStatus.c(this.E, 7002);
    int i3 = TXCStatus.c(this.E, 7001);
    int i4 = TXCStatus.c(this.E, 4007);
    String str1 = TXCStatus.b(this.E, 7012);
    String str2 = TXCStatus.b(this.E, 7014);
    String str3 = TXCStatus.b(this.E, 7015);
    String str4 = TXCStatus.b(this.E, 3001);
    long l2 = TXCStatus.a(this.E, 3002);
    double d2 = TXCStatus.d(this.E, 3003);
    int i5 = TXCStatus.c(this.E, 7020);
    String str5 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str5, a.Q, a.am, tXCDRExtInfo);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_avg_audio_bitrate", i2);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_avg_video_bitrate", i3);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_avg_net_speed", (n + m));
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_fps", (int)d1);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_avg_cache_size", i1);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_cpu_usage", j);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_app_cpu_usage", i);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_avg_memory", k);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str5, a.Q, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str5, a.Q, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_hw_enc", i4);
    TXCDRApi.txSetEventValue(str5, a.Q, "str_server_ip", str1);
    TXCDRApi.txSetEventValue(str5, a.Q, "str_quic_connection_id", str2);
    TXCDRApi.txSetEventValue(str5, a.Q, "str_quic_connection_stats", str3);
    TXCDRApi.txSetEventValue(str5, a.Q, "str_beauty_stats", str4);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_send_strategy", i5);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_preprocess_timecost", l2);
    TXCDRApi.txSetEventIntValue(str5, a.Q, "u32_preprocess_fps_out", (int)d2);
    TXCDRApi.nativeReportEvent(str5, a.Q);
  }
  
  private void p() {
    this.p = false;
    this.q = 0L;
    this.B = 0;
    String str2 = this.F;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = TXCCommonUtil.getUserId(); 
    str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = g.b(this.h); 
    this.b.put("str_user_id", str2);
    this.b.put("str_device_type", g.c());
    this.b.put("str_device_type", g.c());
    this.b.put("u32_network_type", Integer.valueOf(g.e(this.h)));
    this.b.put("token", g.e());
    this.b.put("str_package_name", g.c(this.h));
    this.b.put("dev_uuid", g.f(this.h));
    this.b.put("str_os_info", g.d());
    this.z = TXCTimeUtil.getUtcTimeTick();
    this.b.put("u64_timestamp", Long.valueOf(this.z));
    this.A = TXCTimeUtil.getTimeTick();
  }
  
  public void a() {
    p();
    this.k = -1L;
    this.o = -1L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.v = System.currentTimeMillis();
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 6002) {
      double d4 = TXCStatus.d(this.E, paramInt1);
      if (d4 < 0.001D)
        return; 
      double d3 = TXCStatus.d(this.E, paramInt2);
      paramInt1 = TXCStatus.c(this.E, paramInt3) + 1;
      d4 = (d4 - d3) / paramInt1;
      TXCStatus.a(this.E, paramInt2, Double.valueOf(d3 + d4));
      TXCStatus.a(this.E, paramInt3, Integer.valueOf(paramInt1));
      return;
    } 
    double d2 = TXCStatus.c(this.E, paramInt1);
    if (d2 < 0.001D)
      return; 
    double d1 = TXCStatus.d(this.E, paramInt2);
    paramInt1 = TXCStatus.c(this.E, paramInt3) + 1;
    d2 = (d2 - d1) / paramInt1;
    TXCStatus.a(this.E, paramInt2, Double.valueOf(d1 + d2));
    TXCStatus.a(this.E, paramInt3, Integer.valueOf(paramInt1));
  }
  
  public void a(String paramString) {
    this.c = paramString;
    b(paramString);
  }
  
  public void a(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void b() {
    if (this.p) {
      n();
      return;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("push ");
    stringBuilder.append(this.c);
    stringBuilder.append(" failed!");
    TXCLog.e(str, stringBuilder.toString());
    l();
  }
  
  public void b(int paramInt) {
    this.g = paramInt;
  }
  
  public void b(String paramString) {
    if (paramString == null)
      return; 
    this.C = paramString;
  }
  
  public void c() {
    if (this.p) {
      if (this.u) {
        e(a.Y);
      } else if (d() != a.c) {
        e(a.V);
      } 
      if (this.u) {
        d(a.Z);
      } else {
        d(a.W);
      } 
    } else {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("play ");
      stringBuilder.append(this.c);
      stringBuilder.append(" failed");
      TXCLog.e(str, stringBuilder.toString());
      if (this.u) {
        c(a.X);
      } else {
        c(a.U);
      } 
    } 
    if (this.u)
      k(); 
    TXCStatus.a(this.E, 7107, Long.valueOf(0L));
    TXCStatus.a(this.E, 2033, Long.valueOf(0L));
    TXCStatus.a(this.E, 6001, Long.valueOf(0L));
    TXCStatus.a(this.E, 7104, Long.valueOf(0L));
    TXCStatus.a(this.E, 7108, Long.valueOf(0L));
  }
  
  protected a d() {
    try {
      Uri uri = Uri.parse(this.C);
      if (uri == null)
        return a.a; 
      String str1 = uri.getHost();
      if (TextUtils.isEmpty(str1))
        return a.a; 
      String str2 = uri.getScheme();
      if (str2 == null)
        return a.a; 
      if (!str2.equals("rtmp") && !str2.equals("http") && !str2.equals("https"))
        return a.a; 
      if (c(str1))
        return a.b; 
      Set set = uri.getQueryParameterNames();
      if (set != null && (set.contains("bizid") || set.contains("txTime") || set.contains("txSecret")))
        return a.b; 
      if (D.containsKey(str1))
        return D.get(str1); 
      D.put(str1, a.a);
      (new Thread(new Runnable(this, str1) {
            public void run() {
              try {
                e[] arrayOfE = a.c().a(new b(this.a, true), null);
                int j = arrayOfE.length;
                boolean bool = false;
                int i = 0;
                while (true) {
                  e.a a;
                  boolean bool1 = bool;
                  if (i < j) {
                    e e1 = arrayOfE[i];
                    if (e1.a() && e.c(e1.a)) {
                      bool1 = true;
                    } else {
                      i++;
                      continue;
                    } 
                  } 
                  HashMap<String, e.a> hashMap = e.g();
                  String str2 = this.a;
                  if (bool1) {
                    a = e.a.b;
                  } else {
                    a = e.a.c;
                  } 
                  hashMap.put(str2, a);
                  String str1 = e.h();
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(this.a);
                  stringBuilder.append(" isTencent ");
                  stringBuilder.append(bool1);
                  TXCLog.d(str1, stringBuilder.toString());
                  return;
                } 
              } catch (Exception exception) {
                TXCLog.e(e.h(), "check dns failed.", exception);
                return;
              } 
            }
          })).start();
    } catch (Exception exception) {
      TXCLog.e(a, "check stream failed.", exception);
    } 
    return a.a;
  }
  
  public void d(String paramString) {
    this.E = paramString;
  }
  
  public void e() {
    if (!this.p && !TextUtils.isEmpty(TXCStatus.b(this.E, 7012))) {
      m();
      this.p = true;
    } 
    if (this.q <= 0L)
      this.q = TXCTimeUtil.getTimeTick(); 
    if (this.p && TXCTimeUtil.getTimeTick() - this.q > 5000L) {
      o();
      this.q = TXCTimeUtil.getTimeTick();
    } 
  }
  
  public void e(String paramString) {
    this.F = paramString;
  }
  
  public void f() {
    i();
    if (!this.p) {
      long l1 = TXCStatus.a(this.E, 6001);
      long l2 = TXCStatus.a(this.E, 7104);
      long l3 = TXCStatus.a(this.E, 2033);
      long l4 = TXCStatus.a(this.E, 7108);
      if (l1 > 0L && l2 > 0L && l4 > 0L && l3 > 0L) {
        int i;
        if (this.u) {
          i = a.X;
        } else {
          i = a.U;
        } 
        c(i);
        this.r = 5000;
        this.p = true;
      } 
      String str = TXCStatus.b(this.E, 7119);
      if (str != null)
        b(str); 
    } 
    if (this.B >= 3 && !this.p) {
      int i;
      if (this.u) {
        i = a.X;
      } else {
        i = a.U;
      } 
      c(i);
      this.r = 5000;
      this.p = true;
    } 
    this.B++;
    if (this.q <= 0L)
      this.q = TXCTimeUtil.getTimeTick(); 
    if (TXCTimeUtil.getTimeTick() > this.q + this.r) {
      if (this.u) {
        e(a.Y);
        this.r = 5000;
      } else {
        if (d() == a.c)
          return; 
        e(a.V);
        this.r = TXCDRApi.getStatusReportInterval();
        if (this.r < 5000)
          this.r = 5000; 
        if (this.r > 300000)
          this.r = 300000; 
      } 
      this.k = TXCStatus.a(this.E, 6004);
      this.o = TXCStatus.c(this.E, 2002);
      this.q = TXCTimeUtil.getTimeTick();
    } 
  }
  
  enum a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
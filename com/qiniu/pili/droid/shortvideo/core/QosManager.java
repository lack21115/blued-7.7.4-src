package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.qiniu.pili.droid.shortvideo.f.j;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QosManager {
  private static boolean n = false;
  
  private static boolean o = true;
  
  private Context a;
  
  private SharedPreferences b;
  
  private SharedPreferences.Editor c;
  
  private SharedPreferences d;
  
  private SharedPreferences.Editor e;
  
  private SharedPreferences f;
  
  private SharedPreferences.Editor g;
  
  private SharedPreferences h;
  
  private SharedPreferences.Editor i;
  
  private SharedPreferences j;
  
  private SharedPreferences.Editor k;
  
  private SharedPreferences l;
  
  private SharedPreferences.Editor m;
  
  private QosManager() {}
  
  public static QosManager a() {
    return b.a;
  }
  
  public static QosManager a(Context paramContext) {
    // Byte code:
    //   0: ldc com/qiniu/pili/droid/shortvideo/core/QosManager
    //   2: monitorenter
    //   3: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager$b.a : Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   6: aload_0
    //   7: invokevirtual b : (Landroid/content/Context;)V
    //   10: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager$b.a : Lcom/qiniu/pili/droid/shortvideo/core/QosManager;
    //   13: astore_0
    //   14: ldc com/qiniu/pili/droid/shortvideo/core/QosManager
    //   16: monitorexit
    //   17: aload_0
    //   18: areturn
    //   19: astore_0
    //   20: ldc com/qiniu/pili/droid/shortvideo/core/QosManager
    //   22: monitorexit
    //   23: aload_0
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	19	finally
  }
  
  private String a(a parama) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    JSONArray jSONArray = new JSONArray();
    if (parama == a.a) {
      try {
        JSONObject jSONObject1 = i();
        jSONObject1.put("error_info", Base64.encodeToString(j().toString().getBytes(), 0));
        jSONObject1.put("data_type", a.a);
        jSONArray.put(jSONObject1);
      } catch (Exception exception) {}
    } else {
      Iterator<Map.Entry> iterator = this.j.getAll().entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          try {
            JSONObject jSONObject1 = a(entry.getValue().toString());
            if (jSONObject1 != null)
              jSONArray.put(jSONObject1); 
          } catch (Exception exception) {}
          continue;
        } 
        jSONObject.put("__logs__", jSONArray);
        return jSONObject.toString();
      } 
    } 
    jSONObject.put("__logs__", jSONArray);
    return jSONObject.toString();
  }
  
  private JSONObject a(String paramString) throws JSONException {
    JSONObject jSONObject2 = h();
    JSONObject jSONObject1 = new JSONObject(paramString);
    Iterator<String> iterator = jSONObject1.keys();
    while (iterator.hasNext()) {
      String str = iterator.next();
      jSONObject2.put(str, jSONObject1.getString(str));
    } 
    return jSONObject2;
  }
  
  private String b(int paramInt) {
    return (paramInt == 0) ? "error_io_exception" : ((paramInt == 1) ? "error_wrong_status" : ((paramInt == 2) ? "error_empty_sections" : ((paramInt == 3) ? "error_muxer_stop_failed" : ((paramInt == 4) ? "error_setup_camera_failed" : ((paramInt == 5) ? "error_setup_microphone_failed" : ((paramInt == 6) ? "error_setup_video_encoder_failed" : ((paramInt == 7) ? "error_setup_audio_encoder_failed" : ((paramInt == 8) ? "error_unauthorized" : ((paramInt == 9) ? "error_unsupported_android_version" : ((paramInt == 10) ? "error_invalid_arg" : ((paramInt == 11) ? "error_different_audio_params" : ((paramInt == 12) ? "error_missing_dynamic_library" : ((paramInt == 13) ? "error_no_video_track" : ((paramInt == 14) ? "error_src_dst_same_file_path" : ((paramInt == 15) ? "error_low_memory" : ((paramInt == 16) ? "error_multi_codec_wrong" : ((paramInt == 17) ? "error_setup_video_decoder_failed" : ((paramInt == 18) ? "error_muxer_start_failed" : ((paramInt == 19) ? "error_video_encoder_exceptional_stop" : ((paramInt == 20) ? "error_video_decode_failed" : "error_unknown"))))))))))))))))))));
  }
  
  private void e() {
    this.b = this.a.getSharedPreferences("ReportData_BaseInfo", 0);
    this.c = this.b.edit();
    this.d = this.a.getSharedPreferences("ReportData_FunctionPart1", 0);
    this.e = this.d.edit();
    this.f = this.a.getSharedPreferences("ReportData_FunctionPart2", 0);
    this.g = this.f.edit();
    this.h = this.a.getSharedPreferences("ReportData_Error", 0);
    this.i = this.h.edit();
    this.j = this.a.getSharedPreferences("ReportData_Config", 0);
    this.k = this.j.edit();
    this.l = this.a.getSharedPreferences("Other", 0);
    this.m = this.l.edit();
    if ("null".equals(this.l.getString("uuid", "null"))) {
      String str = UUID.randomUUID().toString().replaceAll("-", "");
      this.m.putString("uuid", str);
      this.m.apply();
    } 
  }
  
  private void f() {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    long l = this.l.getLong("last_report_config", 0L);
    if (l == 0L) {
      g();
      this.m.putLong("last_report_method", j.c(System.currentTimeMillis()));
      this.m.putLong("last_report_config", j.c(System.currentTimeMillis()));
      this.m.apply();
      scheduledExecutorService.scheduleWithFixedDelay(new c(this, a.c), 60L, 60L, TimeUnit.MINUTES);
      scheduledExecutorService.scheduleWithFixedDelay(new c(this, a.a), 1440L, 1440L, TimeUnit.MINUTES);
      return;
    } 
    l = j.c(System.currentTimeMillis()) - l;
    if (l >= 60L) {
      scheduledExecutorService.scheduleWithFixedDelay(new c(this, a.c), 0L, 60L, TimeUnit.MINUTES);
    } else {
      scheduledExecutorService.scheduleWithFixedDelay(new c(this, a.c), 60L - l, 60L, TimeUnit.MINUTES);
    } 
    l = this.l.getLong("last_report_method", 0L);
    l = j.c(System.currentTimeMillis()) - l;
    if (l >= 1440L) {
      scheduledExecutorService.scheduleWithFixedDelay(new c(this, a.a), 0L, 1440L, TimeUnit.MINUTES);
      return;
    } 
    scheduledExecutorService.scheduleWithFixedDelay(new c(this, a.a), 1440L - l, 1440L, TimeUnit.MINUTES);
  }
  
  private void g() {
    this.c.clear();
    String str2 = Settings.System.getString(this.a.getContentResolver(), "android_id");
    String str1 = str2;
    if (str2 == null)
      str1 = this.l.getString("uuid", "null"); 
    this.c.putString("start_time", String.valueOf(System.currentTimeMillis() / 1000L));
    this.c.putString("os_platform", "android");
    this.c.putString("bundle_id", this.a.getPackageName());
    this.c.putString("app_name", j.i(this.a));
    this.c.putString("app_version", j.h(this.a));
    this.c.putString("device_id", str1);
    this.c.putString("device_model", j.b());
    this.c.putString("os_version", Build.VERSION.RELEASE);
    this.c.putString("sdk_version", "3.1.1");
    this.c.putString("gl_version", Integer.toString(j.d(this.a)));
    this.c.putString("qos_version", "2.0");
    this.c.apply();
  }
  
  private JSONObject h() {
    JSONObject jSONObject = new JSONObject();
    if (this.b.getAll().isEmpty())
      g(); 
    Map map = this.b.getAll();
    try {
      for (Map.Entry entry : map.entrySet())
        jSONObject.put((String)entry.getKey(), entry.getValue().toString()); 
    } catch (JSONException jSONException) {
      this.c.clear();
      this.c.apply();
    } 
    return jSONObject;
  }
  
  private JSONObject i() {
    JSONObject jSONObject1 = h();
    JSONObject jSONObject2 = new JSONObject();
    Map map = this.d.getAll();
    try {
      for (Map.Entry entry : map.entrySet())
        jSONObject2.put((String)entry.getKey(), entry.getValue().toString()); 
      jSONObject1.put("function_part1", Base64.encodeToString(jSONObject2.toString().getBytes(), 0));
    } catch (JSONException jSONException) {
      this.e.clear();
      this.e.apply();
    } 
    jSONObject2 = new JSONObject();
    map = this.f.getAll();
    try {
      for (Map.Entry entry : map.entrySet())
        jSONObject2.put((String)entry.getKey(), entry.getValue().toString()); 
      jSONObject1.put("function_part2", Base64.encodeToString(jSONObject2.toString().getBytes(), 0));
      return jSONObject1;
    } catch (JSONException jSONException) {}
    this.g.clear();
    this.g.apply();
    return jSONObject1;
  }
  
  private JSONObject j() {
    JSONObject jSONObject = new JSONObject();
    Map map = this.h.getAll();
    try {
      for (Map.Entry entry : map.entrySet())
        jSONObject.put((String)entry.getKey(), entry.getValue().toString()); 
    } catch (JSONException jSONException) {
      this.i.clear();
      this.i.apply();
    } 
    return jSONObject;
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager.o : Z
    //   5: ifeq -> 47
    //   8: aload_0
    //   9: iload_1
    //   10: invokespecial b : (I)Ljava/lang/String;
    //   13: astore_2
    //   14: aload_0
    //   15: getfield i : Landroid/content/SharedPreferences$Editor;
    //   18: aload_2
    //   19: aload_0
    //   20: getfield h : Landroid/content/SharedPreferences;
    //   23: aload_2
    //   24: iconst_0
    //   25: invokeinterface getInt : (Ljava/lang/String;I)I
    //   30: iconst_1
    //   31: iadd
    //   32: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   37: pop
    //   38: aload_0
    //   39: getfield i : Landroid/content/SharedPreferences$Editor;
    //   42: invokeinterface apply : ()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	47	50	finally
  }
  
  public void a(KeyPoint paramKeyPoint) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager.o : Z
    //   5: ifeq -> 98
    //   8: aload_1
    //   9: invokevirtual id : ()I
    //   12: bipush #51
    //   14: if_icmpge -> 59
    //   17: aload_0
    //   18: getfield e : Landroid/content/SharedPreferences$Editor;
    //   21: aload_1
    //   22: invokevirtual name : ()Ljava/lang/String;
    //   25: aload_0
    //   26: getfield d : Landroid/content/SharedPreferences;
    //   29: aload_1
    //   30: invokevirtual name : ()Ljava/lang/String;
    //   33: iconst_0
    //   34: invokeinterface getInt : (Ljava/lang/String;I)I
    //   39: iconst_1
    //   40: iadd
    //   41: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   46: pop
    //   47: aload_0
    //   48: getfield e : Landroid/content/SharedPreferences$Editor;
    //   51: invokeinterface apply : ()V
    //   56: goto -> 98
    //   59: aload_0
    //   60: getfield g : Landroid/content/SharedPreferences$Editor;
    //   63: aload_1
    //   64: invokevirtual name : ()Ljava/lang/String;
    //   67: aload_0
    //   68: getfield f : Landroid/content/SharedPreferences;
    //   71: aload_1
    //   72: invokevirtual name : ()Ljava/lang/String;
    //   75: iconst_0
    //   76: invokeinterface getInt : (Ljava/lang/String;I)I
    //   81: iconst_1
    //   82: iadd
    //   83: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   88: pop
    //   89: aload_0
    //   90: getfield g : Landroid/content/SharedPreferences$Editor;
    //   93: invokeinterface apply : ()V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   2	56	101	finally
    //   59	98	101	finally
  }
  
  public void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager.o : Z
    //   5: ifeq -> 160
    //   8: aload_1
    //   9: ifnull -> 160
    //   12: aload_1
    //   13: invokevirtual keys : ()Ljava/util/Iterator;
    //   16: astore #5
    //   18: new java/util/ArrayList
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore #6
    //   27: aload #5
    //   29: invokeinterface hasNext : ()Z
    //   34: ifeq -> 96
    //   37: aload #5
    //   39: invokeinterface next : ()Ljava/lang/Object;
    //   44: checkcast java/lang/String
    //   47: astore #7
    //   49: aload #7
    //   51: ldc 'data_type'
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: istore #4
    //   58: iload #4
    //   60: ifeq -> 66
    //   63: goto -> 27
    //   66: iconst_0
    //   67: istore_2
    //   68: aload_1
    //   69: aload #7
    //   71: iconst_0
    //   72: invokevirtual optInt : (Ljava/lang/String;I)I
    //   75: istore_3
    //   76: iload_3
    //   77: istore_2
    //   78: goto -> 81
    //   81: iload_2
    //   82: ifne -> 27
    //   85: aload #6
    //   87: aload #7
    //   89: invokevirtual add : (Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -> 27
    //   96: aload #6
    //   98: invokevirtual iterator : ()Ljava/util/Iterator;
    //   101: astore #5
    //   103: aload #5
    //   105: invokeinterface hasNext : ()Z
    //   110: ifeq -> 131
    //   113: aload_1
    //   114: aload #5
    //   116: invokeinterface next : ()Ljava/lang/Object;
    //   121: checkcast java/lang/String
    //   124: invokevirtual remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   127: pop
    //   128: goto -> 103
    //   131: aload_0
    //   132: getfield k : Landroid/content/SharedPreferences$Editor;
    //   135: invokestatic randomUUID : ()Ljava/util/UUID;
    //   138: invokevirtual toString : ()Ljava/lang/String;
    //   141: aload_1
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   150: pop
    //   151: aload_0
    //   152: getfield k : Landroid/content/SharedPreferences$Editor;
    //   155: invokeinterface apply : ()V
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    //   168: astore #8
    //   170: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   2	8	163	finally
    //   12	27	163	finally
    //   27	58	163	finally
    //   68	76	168	java/lang/Exception
    //   68	76	163	finally
    //   85	93	163	finally
    //   96	103	163	finally
    //   103	128	163	finally
    //   131	160	163	finally
  }
  
  public void b() {
    o = true;
  }
  
  public void b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/core/QosManager.n : Z
    //   5: istore #4
    //   7: iload #4
    //   9: ifeq -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic com/qiniu/pili/droid/shortvideo/core/QosManager.n : Z
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   24: putfield a : Landroid/content/Context;
    //   27: getstatic com/qiniu/pili/droid/shortvideo/core/c.a : [Ljava/lang/String;
    //   30: astore #5
    //   32: aload #5
    //   34: arraylength
    //   35: istore_3
    //   36: iconst_0
    //   37: istore_2
    //   38: iload_2
    //   39: iload_3
    //   40: if_icmpge -> 68
    //   43: aload #5
    //   45: iload_2
    //   46: aaload
    //   47: astore #6
    //   49: aload_1
    //   50: invokestatic g : (Landroid/content/Context;)Ljava/lang/String;
    //   53: aload #6
    //   55: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   58: ifeq -> 84
    //   61: iconst_0
    //   62: putstatic com/qiniu/pili/droid/shortvideo/core/QosManager.o : Z
    //   65: goto -> 68
    //   68: aload_0
    //   69: invokespecial e : ()V
    //   72: aload_0
    //   73: invokespecial f : ()V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: iload_2
    //   85: iconst_1
    //   86: iadd
    //   87: istore_2
    //   88: goto -> 38
    // Exception table:
    //   from	to	target	type
    //   2	7	79	finally
    //   15	36	79	finally
    //   49	65	79	finally
    //   68	76	79	finally
  }
  
  public void c() {
    o = false;
  }
  
  public enum KeyPoint {
    compose_gif,
    compose_image,
    compose_item,
    compose_trim_video,
    compose_video,
    draftbox,
    edit_audio_mix,
    edit_filter,
    edit_image,
    edit_multi_audio_mix,
    edit_mv,
    edit_paint,
    edit_preview,
    edit_rotate,
    edit_speed,
    edit_text,
    edit_watermark,
    editor_init,
    filter_init,
    h265_video,
    mix_video,
    record_audio_encode_setting,
    record_audio_microphone_setting,
    record_audio_mix,
    record_audio_only,
    record_beauty,
    record_camera_capture(1),
    record_capture_frame(1),
    record_custom_effect(1),
    record_duration_setting(1),
    record_exposure(1),
    record_external_media(1),
    record_filter(1),
    record_flash(1),
    record_focus(1),
    record_horizontal(1),
    record_image_rotate(1),
    record_init(1),
    record_microphone_capture(2),
    record_mirror(2),
    record_mute(2),
    record_preview(2),
    record_screen(2),
    record_section(2),
    record_speed(2),
    record_stop_resume(2),
    record_switch_camera(2),
    record_video_camera_setting(3),
    record_video_encode_setting(3),
    record_video_mix(3),
    record_view(3),
    record_watermark(3),
    record_zoom(3),
    reverse_video(3),
    transcode_clip_video(3),
    transcode_init(3),
    transcode_rotate(3),
    transcode_video(3),
    transition_make(3),
    trim_init(3),
    trim_video(3),
    upload_init(3),
    upload_resume(3),
    upload_speed_up(3),
    upload_video(3);
    
    private int id;
    
    static {
      record_audio_encode_setting = new KeyPoint("record_audio_encode_setting", 5, 6);
      record_duration_setting = new KeyPoint("record_duration_setting", 6, 7);
      record_switch_camera = new KeyPoint("record_switch_camera", 7, 8);
      record_flash = new KeyPoint("record_flash", 8, 9);
      record_exposure = new KeyPoint("record_exposure", 9, 10);
      record_focus = new KeyPoint("record_focus", 10, 11);
      record_zoom = new KeyPoint("record_zoom", 11, 12);
      record_mirror = new KeyPoint("record_mirror", 12, 13);
      record_horizontal = new KeyPoint("record_horizontal", 13, 14);
      record_section = new KeyPoint("record_section", 14, 15);
      record_speed = new KeyPoint("record_speed", 15, 16);
      record_audio_only = new KeyPoint("record_audio_only", 16, 17);
      record_image_rotate = new KeyPoint("record_image_rotate", 17, 18);
      record_audio_mix = new KeyPoint("record_audio_mix", 18, 19);
      record_capture_frame = new KeyPoint("record_capture_frame", 19, 20);
      record_mute = new KeyPoint("record_mute", 20, 21);
      record_video_mix = new KeyPoint("record_video_mix", 21, 22);
      record_screen = new KeyPoint("record_screen", 22, 23);
      record_view = new KeyPoint("record_view", 23, 24);
      record_external_media = new KeyPoint("record_external_media", 24, 25);
      record_stop_resume = new KeyPoint("record_stop_resume", 25, 26);
      record_watermark = new KeyPoint("record_watermark", 26, 27);
      record_beauty = new KeyPoint("record_beauty", 27, 28);
      record_preview = new KeyPoint("record_preview", 28, 29);
      record_custom_effect = new KeyPoint("record_custom_effect", 29, 30);
      record_filter = new KeyPoint("record_filter", 30, 31);
      edit_preview = new KeyPoint("edit_preview", 31, 32);
      edit_image = new KeyPoint("edit_image", 32, 33);
      edit_watermark = new KeyPoint("edit_watermark", 33, 34);
      edit_speed = new KeyPoint("edit_speed", 34, 35);
      edit_text = new KeyPoint("edit_text", 35, 36);
      edit_mv = new KeyPoint("edit_mv", 36, 37);
      edit_paint = new KeyPoint("edit_paint", 37, 38);
      edit_audio_mix = new KeyPoint("edit_audio_mix", 38, 39);
      edit_multi_audio_mix = new KeyPoint("edit_multi_audio_mix", 39, 40);
      edit_rotate = new KeyPoint("edit_rotate", 40, 41);
      edit_filter = new KeyPoint("edit_filter", 41, 42);
      compose_video = new KeyPoint("compose_video", 42, 43);
      compose_trim_video = new KeyPoint("compose_trim_video", 43, 44);
      compose_gif = new KeyPoint("compose_gif", 44, 45);
      compose_image = new KeyPoint("compose_image", 45, 46);
      compose_item = new KeyPoint("compose_item", 46, 47);
      transcode_clip_video = new KeyPoint("transcode_clip_video", 47, 48);
      transcode_video = new KeyPoint("transcode_video", 48, 49);
      transcode_rotate = new KeyPoint("transcode_rotate", 49, 50);
      trim_video = new KeyPoint("trim_video", 50, 51);
      upload_video = new KeyPoint("upload_video", 51, 52);
      upload_resume = new KeyPoint("upload_resume", 52, 53);
      upload_speed_up = new KeyPoint("upload_speed_up", 53, 54);
      mix_video = new KeyPoint("mix_video", 54, 55);
      draftbox = new KeyPoint("draftbox", 55, 56);
      reverse_video = new KeyPoint("reverse_video", 56, 57);
      transition_make = new KeyPoint("transition_make", 57, 58);
      filter_init = new KeyPoint("filter_init", 58, 59);
      editor_init = new KeyPoint("editor_init", 59, 60);
      record_init = new KeyPoint("record_init", 60, 61);
      trim_init = new KeyPoint("trim_init", 61, 62);
      transcode_init = new KeyPoint("transcode_init", 62, 63);
      upload_init = new KeyPoint("upload_init", 63, 64);
      h265_video = new KeyPoint("h265_video", 64, 65);
      $VALUES = new KeyPoint[] { 
          record_camera_capture, record_microphone_capture, record_video_camera_setting, record_audio_microphone_setting, record_video_encode_setting, record_audio_encode_setting, record_duration_setting, record_switch_camera, record_flash, record_exposure, 
          record_focus, record_zoom, record_mirror, record_horizontal, record_section, record_speed, record_audio_only, record_image_rotate, record_audio_mix, record_capture_frame, 
          record_mute, record_video_mix, record_screen, record_view, record_external_media, record_stop_resume, record_watermark, record_beauty, record_preview, record_custom_effect, 
          record_filter, edit_preview, edit_image, edit_watermark, edit_speed, edit_text, edit_mv, edit_paint, edit_audio_mix, edit_multi_audio_mix, 
          edit_rotate, edit_filter, compose_video, compose_trim_video, compose_gif, compose_image, compose_item, transcode_clip_video, transcode_video, transcode_rotate, 
          trim_video, upload_video, upload_resume, upload_speed_up, mix_video, draftbox, reverse_video, transition_make, filter_init, editor_init, 
          record_init, trim_init, transcode_init, upload_init, h265_video };
    }
    
    KeyPoint(int param1Int1) {
      this.id = param1Int1;
    }
    
    public int id() {
      return this.id;
    }
  }
  
  public enum a {
    a, b, c;
  }
  
  static class b {
    static final QosManager a = new QosManager();
  }
  
  class c implements Runnable {
    private QosManager.a b;
    
    c(QosManager this$0, QosManager.a param1a) {
      this.b = param1a;
    }
    
    public void run() {
      if (!QosManager.d())
        return; 
      int j = 0;
      int i = j;
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL("https://sdk-dau.cn-shanghai.log.aliyuncs.com/logstores/deal_data/track")).openConnection();
        i = j;
        httpURLConnection.setDoOutput(true);
        i = j;
        httpURLConnection.setRequestMethod("POST");
        i = j;
        httpURLConnection.setRequestProperty("x-log-apiversion", "0.6.0");
        i = j;
        httpURLConnection.setRequestProperty("x-log-bodyrawsize", "1234");
        i = j;
        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));
        i = j;
        printWriter.write(QosManager.a(this.a, this.b));
        i = j;
        printWriter.flush();
        i = j;
        printWriter.close();
        i = j;
        j = httpURLConnection.getResponseCode();
        i = j;
        httpURLConnection.disconnect();
        i = j;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      if (i == 200) {
        QosManager.a(this.a);
        if (this.b == QosManager.a.a) {
          QosManager.b(this.a).clear();
          QosManager.b(this.a).apply();
          QosManager.c(this.a).clear();
          QosManager.c(this.a).apply();
          QosManager.d(this.a).clear();
          QosManager.d(this.a).apply();
          QosManager.e(this.a).putLong("last_report_method", System.currentTimeMillis() / 1000L);
          QosManager.e(this.a).apply();
          return;
        } 
        QosManager.f(this.a).clear();
        QosManager.f(this.a).apply();
        QosManager.e(this.a).putLong("last_report_config", System.currentTimeMillis() / 1000L);
        QosManager.e(this.a).apply();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\QosManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
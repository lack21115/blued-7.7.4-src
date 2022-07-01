package com.ss.android.downloadlib;

import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.downloadad.a.a;
import com.ss.android.downloadlib.a.a;
import com.ss.android.downloadlib.a.a.a;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.b.e;
import com.ss.android.downloadlib.a.c.d;
import com.ss.android.downloadlib.a.d.a;
import com.ss.android.downloadlib.a.f;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d.a;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.m.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements a, b.c, a.a {
  private static String a = a.class.getSimpleName();
  
  private static volatile a d;
  
  private volatile boolean b = false;
  
  private long c;
  
  private a() {
    b.a(this);
    if (com.ss.android.socialbase.downloader.k.a.b().a("check_event_when_app_switch", 0) == 1)
      a.a().a(this); 
  }
  
  private int a(String paramString1, String paramString2) {
    if (j.i().optInt("check_hijack", 0) == 0)
      return 0; 
    paramString1 = j.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(paramString1, null);
    paramString2 = a.b(paramString2);
    return (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) ? (paramString1.equals(paramString2) ? 2 : 1) : 0;
  }
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a.d : Lcom/ss/android/downloadlib/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/a
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/a.d : Lcom/ss/android/downloadlib/a;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/a.d : Lcom/ss/android/downloadlib/a;
    //   25: ldc com/ss/android/downloadlib/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/a.d : Lcom/ss/android/downloadlib/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static c a(List<c> paramList, String paramString) {
    if (paramList != null && !paramList.isEmpty()) {
      if (TextUtils.isEmpty(paramString))
        return null; 
      for (c c1 : paramList) {
        if (c1 == null)
          continue; 
        if (paramString.equals(c1.z()))
          return c1; 
        String str = c1.n();
        if (g.a(j.a(), str, paramString))
          return c1; 
      } 
    } 
    return null;
  }
  
  private JSONObject a(int paramInt1, int paramInt2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("scene", Integer.valueOf(paramInt2));
      jSONObject.put("hijack", paramInt1);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONObject;
    } 
  }
  
  public static JSONObject a(JSONObject paramJSONObject, c paramc) {
    if (paramJSONObject != null) {
      if (paramc == null)
        return paramJSONObject; 
      if (com.ss.android.socialbase.downloader.k.a.a(paramc.g()).a("download_event_opt", 0) == 0)
        return paramJSONObject; 
      try {
        long l1 = f.c(Environment.getExternalStorageDirectory().toString());
        double d = l1;
        paramJSONObject.put("available_space", d / 1048576.0D);
        long l2 = paramc.ab();
      } finally {
        paramc = null;
      } 
    } 
    return paramJSONObject;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, c paramc, boolean paramBoolean) {
    if (paramJSONObject != null) {
      if (paramc == null)
        return paramJSONObject; 
      com.ss.android.socialbase.downloader.k.a a1 = com.ss.android.socialbase.downloader.k.a.a(paramc.g());
      boolean bool = false;
      if (a1.a("download_event_opt", 0) == 0)
        return paramJSONObject; 
      try {
        String str;
        paramJSONObject.put("download_id", paramc.g());
        paramJSONObject.put("name", paramc.h());
        paramJSONObject.put("url", paramc.j());
        paramJSONObject.put("download_time", paramc.aw());
        paramJSONObject.put("cur_bytes", paramc.Z());
        paramJSONObject.put("total_bytes", paramc.ab());
        paramJSONObject.put("network_quality", paramc.ad());
        paramJSONObject.put("current_network_quality", g.a().b().name());
        if (paramc.x()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("only_wifi", bool1);
        if (paramc.ai()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("need_https_degrade", bool1);
        if (paramc.t()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("https_degrade_retry_used", bool1);
        paramJSONObject.put("chunk_count", paramc.aV());
        paramJSONObject.put("retry_count", paramc.D());
        paramJSONObject.put("cur_retry_time", paramc.al());
        if (paramc.aj()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("need_retry_delay", bool1);
        if (paramc.J()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("backup_url_used", bool1);
        if (paramc.c() != null) {
          str = paramc.c();
        } else {
          str = "";
        } 
        paramJSONObject.put("head_connection_error_msg", str);
        if (paramc.T()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("need_independent_process", bool1);
        paramJSONObject.put("total_retry_count", paramc.F());
        paramJSONObject.put("cur_retry_time_in_total", paramc.G());
        paramJSONObject.put("real_download_time", paramc.ax());
        if (paramc.ap()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("chunk_downgrade_retry_used", bool1);
        if (paramc.ao()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("need_chunk_downgrade_retry", bool1);
        paramJSONObject.put("failed_resume_count", paramc.aZ());
        paramJSONObject.put("preconnect_level", paramc.bf());
        paramJSONObject.put("retry_schedule_count", paramc.N());
        if (paramc.O()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        paramJSONObject.put("rw_concurrent", bool1);
        if (!paramBoolean) {
          double d1 = paramc.Z() / 1048576.0D;
          long l = paramc.ax();
          double d2 = l / 1000.0D;
          if (d1 > 0.0D && d2 > 0.0D) {
            d1 /= d2;
            try {
              paramJSONObject.put("download_speed", d1);
            } catch (Exception exception) {}
            str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("download speed : ");
            stringBuilder.append(d1);
            stringBuilder.append("MB/s");
            com.ss.android.socialbase.downloader.f.a.b(str, stringBuilder.toString());
          } 
        } 
        boolean bool1 = bool;
        try {
          if (f.a(j.a()).m(paramc.g()))
            bool1 = true; 
          paramJSONObject.put("is_download_service_foreground", bool1);
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        if (paramc.aC() != null) {
          paramJSONObject.put("backup_url_count", paramc.aC().size());
          paramJSONObject.put("cur_backup_url_index", paramc.s());
        } 
        paramJSONObject.put("clear_space_restart_times", d.a().b(paramc.j()));
        paramJSONObject.put("mime_type", paramc.ah());
        a(paramJSONObject, paramc);
        return paramJSONObject;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    return paramJSONObject;
  }
  
  private static void a(com.ss.android.downloadad.a.b.a parama) {
    if (parama == null)
      return; 
    String str = (String)d.a().b().get(parama.k());
    JSONObject jSONObject = parama.h();
    if (!TextUtils.isEmpty(str)) {
      d.a().b().remove(parama.k());
      JSONObject jSONObject1 = jSONObject;
      if (jSONObject == null)
        jSONObject1 = new JSONObject(); 
      try {
        jSONObject1.putOpt("finish_reason", str);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    c c1 = f.a(j.a()).h(parama.k());
    jSONObject = a(new JSONObject(), c1, false);
    a(jSONObject, c1.g());
    a.a().a(jSONObject, parama);
  }
  
  public static void a(c paramc, com.ss.android.downloadad.a.b.a parama) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/ss/android/downloadlib/a}} */
    if (paramc == null || parama == null) {
      g.b();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ss/android/downloadlib/a}} */
      return;
    } 
    try {
      int i = parama.c();
      if (i != 1) {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ss/android/downloadlib/a}} */
        return;
      } 
      String str = b(paramc, parama);
      a(parama);
      parama.c(System.currentTimeMillis());
      parama.a(2);
      c.a().a(parama, paramc, str);
      g.a().a(paramc, str);
      if ("application/vnd.android.package-archive".equals(paramc.ah())) {
        a().b(str);
        long l = parama.a();
        a().a(paramc.n(), l);
        if (parama.n())
          a.a().a(paramc.g(), parama.a(), parama.b(), str, paramc.i(), parama.f(), paramc.n()); 
        a.a(paramc, parama.a(), parama.f(), str);
      } 
    } catch (Exception exception) {
      g.a(exception);
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ss/android/downloadlib/a}} */
  }
  
  private void a(ConcurrentHashMap<Long, com.ss.android.downloadad.a.b.a> paramConcurrentHashMap, int paramInt) {
    ArrayList<Long> arrayList = new ArrayList();
    long l = System.currentTimeMillis();
    Iterator<com.ss.android.downloadad.a.b.a> iterator = paramConcurrentHashMap.values().iterator();
    while (true) {
      if (iterator.hasNext()) {
        com.ss.android.downloadad.a.b.a a1 = iterator.next();
        if (a1.a.get()) {
          arrayList.add(Long.valueOf(a1.a()));
          continue;
        } 
        if (a1.c() == 1) {
          if (l - a1.e() >= 259200000L)
            arrayList.add(Long.valueOf(a1.a())); 
          continue;
        } 
        if (a1.c() == 2) {
          if (l - a1.e() >= 604800000L) {
            arrayList.add(Long.valueOf(a1.a()));
            continue;
          } 
          if (TextUtils.isEmpty(a1.d())) {
            arrayList.add(Long.valueOf(a1.a()));
            continue;
          } 
          if (g.a(a1)) {
            if (a1.m() == 4)
              paramInt = a1.m(); 
            JSONObject jSONObject = a(a(String.valueOf(a1.a()), a1.d()), paramInt);
            a(jSONObject, a1.k());
            c c1 = f.a(j.a()).h(a1.k());
            if (c1 != null)
              try {
                jSONObject.put("uninstall_resume_count", c1.bb());
              } finally {} 
            a.a().b(jSONObject, a1);
            arrayList.add(Long.valueOf(a1.a()));
            d.a(a1);
          } 
          continue;
        } 
        arrayList.add(Long.valueOf(a1.a()));
        continue;
      } 
      c.a().a(arrayList);
      return;
    } 
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt) {
    if (paramJSONObject == null)
      return; 
    com.ss.android.socialbase.downloader.k.a a1 = com.ss.android.socialbase.downloader.k.a.a(paramInt);
    JSONObject jSONObject = a1.d("anti_hijack_report_config");
    if (jSONObject != null)
      try {
        com.ss.android.socialbase.downloader.m.a.a a3 = b.a(jSONObject.optString("report_installer_pkg_name"));
        if (a3 != null) {
          paramJSONObject.put("installer_package_name", a3.c());
          paramJSONObject.put("installer_version_code", a3.f());
          paramJSONObject.put("installer_version_name", a3.g());
        } 
        com.ss.android.socialbase.downloader.m.a.a a2 = b.a(jSONObject.optString("report_file_manager_pkg_name"));
        if (a2 != null) {
          paramJSONObject.put("file_manager_package_name", a2.c());
          paramJSONObject.put("file_manager_version_code", a2.f());
          paramJSONObject.put("file_manager_version_name", a2.g());
        } 
      } finally {
        jSONObject = null;
      }  
    paramInt = 0;
    if (a1.a("report_unknown_source", 0) == 1)
      try {
        if (b.a(com.ss.android.socialbase.downloader.downloader.b.B()))
          paramInt = 1; 
        return;
      } finally {
        paramJSONObject = null;
      }  
  }
  
  public static String b(c paramc, com.ss.android.downloadad.a.b.a parama) {
    File file = new File(paramc.k(), paramc.h());
    boolean bool = file.exists();
    String str2 = null;
    String str1 = str2;
    if (bool)
      try {
        PackageInfo packageInfo = j.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), c.a());
        str1 = str2;
        if (packageInfo != null)
          str1 = packageInfo.packageName; 
      } catch (Exception exception) {
        exception.printStackTrace();
        str1 = str2;
      }  
    if (!TextUtils.isEmpty(str1) && !str1.equals(paramc.z())) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("real_package_name", str1);
        jSONObject.put("input_package_name", paramc.z());
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      a.a().a("embeded_ad", "package_name_error", jSONObject, parama);
      return str1;
    } 
    return jSONException.z();
  }
  
  private void b(c paramc, com.ss.android.socialbase.appdownloader.a parama) {
    com.ss.android.downloadad.a.b.a a1 = c.a().a(paramc);
    if (a1 == null)
      return; 
    JSONObject jSONObject = new JSONObject();
    parama.a(jSONObject);
    try {
      jSONObject.put("download_id", paramc.g());
      jSONObject.put("name", paramc.h());
      jSONObject.put("url", paramc.j());
    } finally {
      parama = null;
    } 
    a.a().a("embeded_ad", "anti_hijack_result", jSONObject, a1);
  }
  
  private void c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    int i = 15;
    SystemClock.sleep(20000L);
    while (i > 0) {
      if (g.c(j.a(), paramString)) {
        a(paramString);
        return;
      } 
      if (--i == 0)
        return; 
      SystemClock.sleep(20000L);
    } 
  }
  
  public void a(int paramInt) {
    if (!this.b) {
      long l = System.currentTimeMillis();
      if (l - this.c < 180000L)
        return; 
      this.c = l;
      d.a().a(new a(this, paramInt));
    } 
  }
  
  public void a(c paramc, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean) {
    com.ss.android.downloadad.a.b.a a1 = c.a().a(paramc);
    if (a1 == null) {
      g.b();
      return;
    } 
    try {
      boolean bool;
      JSONObject jSONObject = new JSONObject();
      jSONObject.putOpt("space_before", Double.valueOf(paramLong1 / 1048576.0D));
      jSONObject.putOpt("space_cleaned", Double.valueOf((paramLong2 - paramLong1) / 1048576.0D));
      jSONObject.putOpt("clean_up_time_cost", Long.valueOf(paramLong4));
      if (paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.putOpt("is_download_restarted", Integer.valueOf(bool));
      jSONObject.putOpt("byte_required", Long.valueOf(paramLong3));
      jSONObject.putOpt("clear_sleep_time", Long.valueOf(paramLong5));
      a.a().a(paramc, jSONObject);
      a.a().a("embeded_ad", "cleanup", jSONObject, a1);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a(c paramc, com.ss.android.socialbase.appdownloader.a parama) {
    if (paramc != null) {
      if (parama == null)
        return; 
      if (com.ss.android.socialbase.downloader.k.a.a(paramc.g()).d("anti_hijack_report_config") != null)
        b(paramc, parama); 
    } 
  }
  
  public void a(String paramString) {
    /* monitor enter ThisExpression{ObjectType{com/ss/android/downloadlib/a}} */
    try {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        /* monitor exit ThisExpression{ObjectType{com/ss/android/downloadlib/a}} */
        return;
      } 
      if (!g.a()) {
        com.ss.android.downloadad.a.b.a a1 = c.a().a(paramString);
        if (a1 == null || a1.a.get()) {
          /* monitor exit ThisExpression{ObjectType{com/ss/android/downloadlib/a}} */
          return;
        } 
        a(paramString, a1);
        if (!a.a().a(paramString, a1))
          a.a().a(paramString); 
        f f = g.a().a(a1.q());
        if (f != null)
          f.e(); 
        a.a().b(paramString);
        c c1 = a(f.a(j.a()).b("application/vnd.android.package-archive"), paramString);
        if (c1 != null) {
          com.ss.android.socialbase.downloader.notification.b.a().a(c1.g());
          g.a().b(c1, paramString);
          d.a(c1);
        } else {
          g.a().b(null, paramString);
        } 
      } else {
        throw new RuntimeException("handleAppInstalled in main thread.");
      } 
    } catch (Exception exception) {
      g.a(exception);
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/ss/android/downloadlib/a}} */
  }
  
  public void a(String paramString, long paramLong) {
    if (j.i().optInt("check_hijack", 0) == 0)
      return; 
    if (!TextUtils.isEmpty(paramString)) {
      if (paramLong <= 0L)
        return; 
      d.a().a(new Runnable(this, paramString, paramLong) {
            public void run() {
              String str = a.a(this.a);
              if (TextUtils.isEmpty(str))
                return; 
              j.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(this.b), str).apply();
            }
          });
    } 
  }
  
  public void a(String paramString, com.ss.android.downloadad.a.b.a parama) {
    if (parama == null)
      return; 
    if (!g.a(parama))
      return; 
    if (parama.a.compareAndSet(false, true)) {
      int i = parama.m();
      byte b = 4;
      if (i != 4)
        b = 3; 
      JSONObject jSONObject = a(a(String.valueOf(parama.a()), paramString), b);
      a(jSONObject, parama.k());
      c c1 = f.a(j.a()).h(parama.k());
      if (c1 != null) {
        try {
          jSONObject.put("uninstall_resume_count", c1.bb());
        } finally {
          Exception exception;
        } 
        String str = c1.bg().getString("anti_hijack_attempt");
        if (!TextUtils.isEmpty(str)) {
          com.ss.android.socialbase.appdownloader.a a1 = com.ss.android.socialbase.appdownloader.a.a(str);
          if (a1 != null)
            a1.a(jSONObject); 
        } 
      } 
      a.a().a(parama.o(), "install_finish", jSONObject, parama);
      e.a().a(parama);
    } 
  }
  
  public void b() {
    a(5);
  }
  
  public void b(String paramString) {
    d.a().a(new b(this, paramString));
  }
  
  public void c() {
    a(6);
  }
  
  class a implements Runnable {
    private final int b;
    
    public a(a this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void run() {
      try {
        c.a().b();
        ConcurrentHashMap concurrentHashMap = c.a().c();
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
          a.a(this.a, concurrentHashMap, this.b);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    }
  }
  
  class b implements Runnable {
    private final String b;
    
    public b(a this$0, String param1String) {
      this.b = param1String;
    }
    
    public void run() {
      try {
        a.a(this.a, true);
        a.a(this.a, this.b);
      } catch (Exception exception) {
        exception.printStackTrace();
      } finally {
        Exception exception;
      } 
      a.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
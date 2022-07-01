package com.bytedance.tea.crash.g;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.tea.crash.upload.CrashUploadService;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  private static String a;
  
  private static String b;
  
  private static Class<?> c;
  
  private static Field d;
  
  private static Field e;
  
  private static boolean f = false;
  
  private static long a(int paramInt) {
    return (paramInt < 0) ? 0L : (paramInt * 1024L);
  }
  
  public static ActivityManager.ProcessErrorStateInfo a(Context paramContext, int paramInt) {
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    if (activityManager == null)
      return null; 
    for (int i = 0; i < paramInt; i++) {
      SystemClock.sleep(200L);
      List list = activityManager.getProcessesInErrorState();
      if (list != null)
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
          if (processErrorStateInfo.condition != 2)
            continue; 
          return processErrorStateInfo;
        }  
    } 
    return null;
  }
  
  private static String a() {
    Exception exception;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/proc/");
      stringBuilder.append(Process.myPid());
      stringBuilder.append("/cmdline");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(stringBuilder.toString()), "iso-8859-1"));
    } finally {
      exception = null;
    } 
    f.a((Closeable)exception);
    return null;
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject) {
    try {
      a(paramJSONObject);
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager != null)
        b(paramJSONObject, activityManager); 
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void a(JSONObject paramJSONObject) throws JSONException {
    Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
    Debug.getMemoryInfo(memoryInfo);
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
    jSONObject.put("dalvikPss", a(memoryInfo.dalvikPss));
    jSONObject.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
    jSONObject.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
    jSONObject.put("nativePss", a(memoryInfo.nativePss));
    jSONObject.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
    jSONObject.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
    jSONObject.put("otherPss", a(memoryInfo.otherPss));
    jSONObject.put("otherSharedDirty", memoryInfo.otherSharedDirty);
    jSONObject.put("totalPrivateClean", b.a(memoryInfo));
    jSONObject.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
    jSONObject.put("totalPss", a(memoryInfo.getTotalPss()));
    jSONObject.put("totalSharedClean", b.b(memoryInfo));
    jSONObject.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
    jSONObject.put("totalSwappablePss", a(b.c(memoryInfo)));
    paramJSONObject.put("memory_info", jSONObject);
  }
  
  private static void a(JSONObject paramJSONObject, ActivityManager paramActivityManager) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("native_heap_size", Debug.getNativeHeapSize());
    jSONObject.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
    jSONObject.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
    Runtime runtime = Runtime.getRuntime();
    jSONObject.put("max_memory", runtime.maxMemory());
    jSONObject.put("free_memory", runtime.freeMemory());
    jSONObject.put("total_memory", runtime.totalMemory());
    if (paramActivityManager != null) {
      jSONObject.put("memory_class", paramActivityManager.getMemoryClass());
      jSONObject.put("large_memory_class", paramActivityManager.getLargeMemoryClass());
    } 
    paramJSONObject.put("app_memory_info", jSONObject);
  }
  
  public static boolean a(Context paramContext) {
    if (paramContext == null)
      return false; 
    String str = paramContext.getPackageName();
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager == null)
        return false; 
      return false;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void b(JSONObject paramJSONObject, ActivityManager paramActivityManager) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
    paramActivityManager.getMemoryInfo(memoryInfo);
    jSONObject.put("availMem", memoryInfo.availMem);
    jSONObject.put("lowMemory", memoryInfo.lowMemory);
    jSONObject.put("threshold", memoryInfo.threshold);
    jSONObject.put("totalMem", g.a(memoryInfo));
    paramJSONObject.put("sys_memory_info", jSONObject);
  }
  
  public static boolean b(Context paramContext) {
    String str = d(paramContext);
    boolean bool2 = false;
    if (str != null && str.contains(":"))
      return false; 
    if (str != null && str.equals(paramContext.getPackageName()))
      return true; 
    boolean bool1 = bool2;
    if (str != null) {
      bool1 = bool2;
      if (str.equals((paramContext.getApplicationInfo()).processName))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean c(Context paramContext) {
    String str = d(paramContext);
    if (b == null)
      try {
        b = (paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, CrashUploadService.class), 65536)).processName;
        b = b.substring(b.lastIndexOf(":"));
      } finally {
        paramContext = null;
        paramContext.printStackTrace();
      }  
    return (str != null && str.endsWith(b));
  }
  
  public static String d(Context paramContext) {
    String str2 = a;
    if (!TextUtils.isEmpty(str2))
      return str2; 
    try {
      int i = Process.myPid();
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    } finally {
      paramContext = null;
    } 
    a = a();
    str2 = a;
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public static String e(Context paramContext) {
    Class<?> clazz = g(paramContext);
    if (d == null && clazz != null)
      try {
        d = clazz.getDeclaredField("VERSION_NAME");
      } catch (NoSuchFieldException noSuchFieldException) {} 
    Field field = d;
    if (field != null)
      try {
        return (String)field.get(null);
      } finally {} 
    return "";
  }
  
  public static int f(Context paramContext) {
    Class<?> clazz = g(paramContext);
    if (e == null && clazz != null)
      try {
        e = clazz.getDeclaredField("VERSION_CODE");
      } catch (NoSuchFieldException noSuchFieldException) {} 
    Field field = e;
    if (field != null)
      try {
        return ((Integer)field.get(null)).intValue();
      } finally {} 
    return -1;
  }
  
  private static Class<?> g(Context paramContext) {
    if (c == null && !f) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getPackageName());
        stringBuilder.append(".BuildConfig");
        c = Class.forName(stringBuilder.toString());
      } catch (ClassNotFoundException classNotFoundException) {}
      f = true;
    } 
    return c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
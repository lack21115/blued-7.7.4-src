package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embed_device_register.b;
import com.bytedance.embedapplog.a.e;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.collector.a;
import com.bytedance.embedapplog.d.a;
import com.bytedance.embedapplog.d.c;
import com.bytedance.embedapplog.d.d;
import com.bytedance.embedapplog.d.e;
import com.bytedance.embedapplog.d.i;
import com.bytedance.embedapplog.util.a;
import com.bytedance.embedapplog.util.h;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class AppLog {
  public static final String UMENG_CATEGORY = "umeng";
  
  private static volatile h a;
  
  private static boolean b = true;
  
  private static boolean c = false;
  
  private static a d = new a();
  
  private static volatile IExtraParams e;
  
  public static ConcurrentHashMap<String, String> sCustomNetParams = new ConcurrentHashMap<String, String>(4);
  
  public static i sDevice;
  
  public static IAppParam sIAppParam;
  
  private AppLog() {
    h.a(null);
  }
  
  private static <T> T a(Object paramObject, T paramT) {
    if (paramObject == null)
      paramObject = null; 
    Object object = paramObject;
    if (paramObject == null)
      object = paramT; 
    return (T)object;
  }
  
  public static void addDataObserver(IDataObserver paramIDataObserver) {
    d.a(paramIDataObserver);
  }
  
  public static void flush() {
    e.a();
  }
  
  public static <T> T getAbConfig(String paramString, T paramT) {
    if (a != null) {
      JSONObject jSONObject = a.c(paramString);
      if (jSONObject != null) {
        paramString = jSONObject.optString("vid");
        Object object = jSONObject.opt("val");
        sDevice.f(paramString);
        return a(object, paramT);
      } 
      return paramT;
    } 
    return null;
  }
  
  public static JSONObject getAbConfig() {
    return (a != null) ? a.x() : null;
  }
  
  public static String getAbConfigVersion() {
    return (a != null) ? a.w() : null;
  }
  
  public static String getAbSDKVersion() {
    i i1 = sDevice;
    return (i1 != null) ? i1.q() : null;
  }
  
  public static String getAid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.h() : "";
  }
  
  public static boolean getAutoActiveState() {
    return b;
  }
  
  public static String getClientUdid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.m() : "";
  }
  
  public static ConcurrentHashMap<String, String> getCustomNetParams() {
    return sCustomNetParams;
  }
  
  public static IDataObserver getDataObserver() {
    return (IDataObserver)d;
  }
  
  public static String getDid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.g() : "";
  }
  
  public static boolean getEncryptAndCompress() {
    return true;
  }
  
  public static IExtraParams getExtraParams() {
    return e;
  }
  
  public static <T> T getHeaderValue(String paramString, T paramT) {
    i i1 = sDevice;
    return (T)((i1 != null) ? i1.a(paramString, paramT) : null);
  }
  
  public static IAppParam getIAppParam() {
    return sIAppParam;
  }
  
  public static String getIid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.j() : "";
  }
  
  public static InitConfig getInitConfig() {
    return (a != null) ? a.S() : null;
  }
  
  public static String getOpenUdid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.n() : "";
  }
  
  public static String getSsid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.k() : "";
  }
  
  public static int getSuccRate() {
    return (a != null) ? a.l() : 0;
  }
  
  public static String getUdid() {
    i i1 = sDevice;
    return (i1 != null) ? i1.i() : "";
  }
  
  public static String getUserUniqueID() {
    i i1 = sDevice;
    return (i1 != null) ? i1.l() : "";
  }
  
  public static void init(Context paramContext, InitConfig paramInitConfig) {
    if (!h.b && Looper.myLooper() != Looper.getMainLooper()) {
      h.a(new RuntimeException("Wrong thread!"));
    } else {
      if (a != null) {
        h.a(new RuntimeException("Init Twice!"));
        return;
      } 
      if (paramInitConfig.getSensitiveInfoProvider() == null) {
        h.a(new RuntimeException("need to involve setSensitiveInfoProvider!"));
        return;
      } 
    } 
    Application application = (Application)paramContext.getApplicationContext();
    e e = e.b();
    h h1 = new h((Context)application, paramInitConfig);
    i i1 = new i((Context)application, h1);
    e.a(application, h1, i1, new a(paramInitConfig.getPicker()));
    a = h1;
    sDevice = i1;
    h.d("Inited", null);
  }
  
  public static boolean manualActivate() {
    return (sDevice != null) ? e.b().e() : false;
  }
  
  public static void onEvent(String paramString) {
    onEvent("umeng", paramString, null, 0L, 0L, null);
  }
  
  public static void onEvent(String paramString1, String paramString2) {
    onEvent("umeng", paramString1, paramString2, 0L, 0L, null);
  }
  
  public static void onEvent(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2) {
    onEvent(paramString1, paramString2, paramString3, paramLong1, paramLong2, null);
  }
  
  public static void onEvent(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject) {
    StringBuilder stringBuilder;
    boolean bool = TextUtils.isEmpty(paramString1);
    String str = null;
    if (bool || TextUtils.isEmpty(paramString3)) {
      if (h.b)
        h.a("category or label is empty", null); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(paramString2);
      stringBuilder.append(paramString3);
      e.a((a)new i(stringBuilder.toString(), "2", 1));
      return;
    } 
    if (paramJSONObject != null)
      str = paramJSONObject.toString(); 
    e.a((a)new c((String)stringBuilder, paramString2, paramString3, paramLong1, paramLong2, str));
  }
  
  public static void onEventV3(String paramString, Bundle paramBundle) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 83
    //   4: aload_1
    //   5: invokevirtual isEmpty : ()Z
    //   8: ifne -> 83
    //   11: new org/json/JSONObject
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore_3
    //   19: aload_1
    //   20: invokevirtual keySet : ()Ljava/util/Set;
    //   23: invokeinterface iterator : ()Ljava/util/Iterator;
    //   28: astore #4
    //   30: aload_3
    //   31: astore_2
    //   32: aload #4
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 85
    //   42: aload #4
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast java/lang/String
    //   52: astore_2
    //   53: aload_3
    //   54: aload_2
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   60: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: goto -> 30
    //   67: astore_1
    //   68: aload_3
    //   69: astore_2
    //   70: goto -> 76
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_1
    //   77: invokestatic a : (Ljava/lang/Throwable;)V
    //   80: goto -> 85
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_0
    //   86: aload_2
    //   87: invokestatic onEventV3 : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   90: return
    // Exception table:
    //   from	to	target	type
    //   4	19	73	finally
    //   19	30	67	finally
    //   32	64	67	finally
  }
  
  public static void onEventV3(String paramString, JSONObject paramJSONObject) {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool) {
      h.a("eventName is empty", null);
      e.a((a)new i("", "2", 1));
    } 
    if (paramJSONObject != null)
      str = paramJSONObject.toString(); 
    e.a((a)new e(paramString, false, str));
  }
  
  public static void onInternalEventV3(String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 22
    //   7: aload_3
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifeq -> 22
    //   14: ldc_w 'both second appid and second app name is empty, return'
    //   17: aconst_null
    //   18: invokestatic b : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   21: return
    //   22: new java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore #5
    //   31: aload #5
    //   33: ldc_w 'second_app_'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #5
    //   42: aload_0
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #5
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: astore #5
    //   54: aload_1
    //   55: ifnull -> 178
    //   58: aload_1
    //   59: invokevirtual isEmpty : ()Z
    //   62: ifne -> 178
    //   65: new org/json/JSONObject
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual keySet : ()Ljava/util/Set;
    //   77: invokeinterface iterator : ()Ljava/util/Iterator;
    //   82: astore #6
    //   84: aload #6
    //   86: invokeinterface hasNext : ()Z
    //   91: ifeq -> 122
    //   94: aload #6
    //   96: invokeinterface next : ()Ljava/lang/Object;
    //   101: checkcast java/lang/String
    //   104: astore #7
    //   106: aload_0
    //   107: aload #7
    //   109: aload_1
    //   110: aload #7
    //   112: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   115: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: goto -> 84
    //   122: aload_0
    //   123: ldc_w 'params_for_special'
    //   126: ldc_w 'second_app'
    //   129: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: pop
    //   133: aload_0
    //   134: ldc_w 'second_appid'
    //   137: aload_2
    //   138: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload_0
    //   143: ldc_w 'second_appname'
    //   146: aload_3
    //   147: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_0
    //   152: ldc_w 'product_type'
    //   155: aload #4
    //   157: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: pop
    //   161: goto -> 180
    //   164: astore_1
    //   165: goto -> 171
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_1
    //   172: invokestatic a : (Ljava/lang/Throwable;)V
    //   175: goto -> 180
    //   178: aconst_null
    //   179: astore_0
    //   180: aload #5
    //   182: aload_0
    //   183: invokestatic onEventV3 : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   186: return
    // Exception table:
    //   from	to	target	type
    //   58	73	168	finally
    //   73	84	164	finally
    //   84	119	164	finally
    //   122	161	164	finally
  }
  
  public static void onInternalEventV3(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, String paramString4) {
    if (TextUtils.isEmpty(paramString2) && TextUtils.isEmpty(paramString3)) {
      h.b("both second appid and second app name is empty, return", null);
      return;
    } 
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("second_app_");
    stringBuilder.append(paramString1);
    paramString1 = stringBuilder.toString();
    try {
      jSONObject.put("params_for_special", "second_app");
      jSONObject.put("second_appid", paramString2);
      jSONObject.put("second_appname", paramString3);
      jSONObject.put("product_type", paramString4);
    } finally {
      stringBuilder = null;
    } 
  }
  
  public static void onMiscEvent(String paramString, JSONObject paramJSONObject) {
    if (TextUtils.isEmpty(paramString) || paramJSONObject == null || paramJSONObject.length() <= 0) {
      h.b("call onEventData with invalid params, return", null);
      return;
    } 
    try {
      e.a((a)new d(paramString, paramJSONObject));
      return;
    } catch (Exception exception) {
      h.c("call onEventData get exception: ", exception);
      return;
    } 
  }
  
  public static void removeDataObserver(IDataObserver paramIDataObserver) {
    d.b(paramIDataObserver);
  }
  
  public static void setAbSDKVersion(String paramString) {
    i i1 = sDevice;
    if (i1 != null)
      i1.a(paramString); 
  }
  
  public static void setAutoActiveState(boolean paramBoolean) {
    b = paramBoolean;
  }
  
  public static void setCustomNetParams(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString2)) {
      sCustomNetParams.remove(paramString1);
      return;
    } 
    sCustomNetParams.put(paramString1, paramString2);
  }
  
  public static void setEnableLog(boolean paramBoolean) {
    h.b = paramBoolean;
  }
  
  public static void setEncryptAndCompress(boolean paramBoolean) {}
  
  public static void setExtraParams(IExtraParams paramIExtraParams) {
    if (e == null && paramIExtraParams != null)
      e = paramIExtraParams; 
  }
  
  public static void setHeaderInfo(HashMap<String, Object> paramHashMap) {
    i i1 = sDevice;
    if (i1 != null)
      i1.a(paramHashMap); 
  }
  
  public static void setIAppParam(IAppParam paramIAppParam) {
    sIAppParam = paramIAppParam;
  }
  
  public static void setOaidObserver(IOaidObserver paramIOaidObserver) {
    b.a(paramIOaidObserver);
  }
  
  public static void setUserUniqueID(String paramString) {
    i i1 = sDevice;
    if (i1 != null)
      i1.c(paramString); 
  }
  
  public static byte[] toEncryptByte(String paramString) {
    // Byte code:
    //   0: new java/io/ByteArrayOutputStream
    //   3: dup
    //   4: sipush #8192
    //   7: invokespecial <init> : (I)V
    //   10: astore #4
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: invokestatic getEncryptAndCompress : ()Z
    //   19: istore_1
    //   20: iload_1
    //   21: ifeq -> 56
    //   24: new java/util/zip/GZIPOutputStream
    //   27: dup
    //   28: aload #4
    //   30: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   33: astore_2
    //   34: aload_2
    //   35: aload_0
    //   36: ldc_w 'UTF-8'
    //   39: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   42: invokevirtual write : ([B)V
    //   45: goto -> 68
    //   48: astore_3
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: astore_2
    //   53: goto -> 82
    //   56: aload #4
    //   58: aload_0
    //   59: ldc_w 'UTF-8'
    //   62: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   65: invokevirtual write : ([B)V
    //   68: aload_2
    //   69: ifnull -> 102
    //   72: aload_2
    //   73: invokevirtual close : ()V
    //   76: goto -> 102
    //   79: astore_2
    //   80: aload_3
    //   81: astore_0
    //   82: aload_2
    //   83: invokestatic a : (Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: ifnull -> 102
    //   90: aload_0
    //   91: invokevirtual close : ()V
    //   94: goto -> 102
    //   97: astore_0
    //   98: aload_0
    //   99: invokestatic a : (Ljava/lang/Throwable;)V
    //   102: aload #4
    //   104: invokevirtual toByteArray : ()[B
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: invokestatic getEncryptAndCompress : ()Z
    //   113: ifeq -> 123
    //   116: aload_2
    //   117: aload_2
    //   118: arraylength
    //   119: invokestatic a : ([BI)[B
    //   122: astore_0
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: aload_0
    //   127: ifnull -> 142
    //   130: aload_0
    //   131: invokevirtual close : ()V
    //   134: goto -> 142
    //   137: astore_0
    //   138: aload_0
    //   139: invokestatic a : (Ljava/lang/Throwable;)V
    //   142: aload_2
    //   143: athrow
    // Exception table:
    //   from	to	target	type
    //   16	20	79	finally
    //   24	34	79	finally
    //   34	45	48	finally
    //   56	68	79	finally
    //   72	76	97	java/io/IOException
    //   82	86	125	finally
    //   90	94	97	java/io/IOException
    //   130	134	137	java/io/IOException
  }
  
  public void setUserAgent(String paramString) {
    i i1 = sDevice;
    if (i1 != null)
      i1.b(paramString); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\AppLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.qq.e.comm.services;

import android.content.Context;
import android.os.Build;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static final a a = new a();
  
  private volatile Boolean b = Boolean.FALSE;
  
  public static a a() {
    return a;
  }
  
  private static String a(SM paramSM, PM paramPM, DeviceStatus paramDeviceStatus, APPStatus paramAPPStatus, long paramLong) {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject3 = com.qq.e.comm.net.a.a(paramSM);
      jSONObject = jSONObject3;
      JSONObject jSONObject4 = new JSONObject();
      if (paramSM != null) {
        jSONObject = jSONObject3;
        jSONObject4.putOpt("app", paramSM.getDevCloudSettingSig());
        jSONObject = jSONObject3;
        jSONObject4.putOpt("sdk", paramSM.getSdkCloudSettingSig());
      } 
      if (paramPM != null) {
        jSONObject = jSONObject3;
        jSONObject4.putOpt("jar", paramPM.getLocalSig());
        jSONObject = jSONObject3;
        jSONObject4.putOpt("plugin_version", Integer.valueOf(paramPM.getPluginVersion()));
      } 
      jSONObject = jSONObject3;
      jSONObject3.put("sig", jSONObject4);
      jSONObject = jSONObject3;
      JSONObject jSONObject1 = new JSONObject();
      if (paramDeviceStatus != null) {
        jSONObject = jSONObject3;
        jSONObject1.putOpt("did", paramDeviceStatus.getPlainDid());
        jSONObject = jSONObject3;
        jSONObject1.putOpt("md", paramDeviceStatus.model);
        jSONObject = jSONObject3;
        jSONObject1.putOpt("lg", paramDeviceStatus.getLanguage());
        jSONObject = jSONObject3;
        jSONObject1.putOpt("w", Integer.valueOf(paramDeviceStatus.getDeviceWidth()));
        jSONObject = jSONObject3;
        jSONObject1.putOpt("h", Integer.valueOf(paramDeviceStatus.getDeviceHeight()));
        jSONObject = jSONObject3;
        jSONObject1.putOpt("dd", Integer.valueOf(paramDeviceStatus.getDeviceDensity()));
        jSONObject = jSONObject3;
        jSONObject1.putOpt("apil", Integer.valueOf(paramDeviceStatus.getVersion()));
        jSONObject = jSONObject3;
        jSONObject1.putOpt("os", "android");
        jSONObject = jSONObject3;
        jSONObject1.putOpt("op", paramDeviceStatus.getOperator());
        jSONObject = jSONObject3;
        jSONObject1.putOpt("mf", Build.MANUFACTURER);
      } 
      jSONObject = jSONObject3;
      jSONObject3.put("dev", jSONObject1);
      jSONObject = jSONObject3;
      jSONObject3.put("app", com.qq.e.comm.net.a.a(paramAPPStatus));
      jSONObject = jSONObject3;
      jSONObject3.put("c", com.qq.e.comm.net.a.a(paramDeviceStatus));
      jSONObject = jSONObject3;
      jSONObject3.put("sdk", com.qq.e.comm.net.a.a(paramPM));
      jSONObject = jSONObject3;
      jSONObject1 = new JSONObject();
      jSONObject = jSONObject3;
      JSONObject jSONObject2 = new JSONObject();
      jSONObject = jSONObject3;
      jSONObject2.put("sdk_init_time", (System.nanoTime() - paramLong) / 1000000L);
      jSONObject = jSONObject3;
      jSONObject1.put("performance", jSONObject2);
      jSONObject = jSONObject3;
      jSONObject3.put("biz", jSONObject1);
      jSONObject = jSONObject3;
    } catch (JSONException jSONException) {
      GDTLogger.e("JSONException while build init req", (Throwable)jSONException);
    } 
    return jSONObject.toString();
  }
  
  public static void a(String paramString, Throwable paramThrowable) {
    if (GDTADManager.getInstance() != null && GDTADManager.getInstance().isInitialized())
      try {
        JSONObject jSONObject = com.qq.e.comm.net.a.a(GDTADManager.getInstance().getSM());
        jSONObject.put("c", com.qq.e.comm.net.a.a(GDTADManager.getInstance().getDeviceStatus()));
        jSONObject.put("app", com.qq.e.comm.net.a.a(GDTADManager.getInstance().getAppStatus()));
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (paramThrowable != null) {
          hashMap.put("extype", paramThrowable.getClass().getName());
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString);
          stringBuilder.append("\r");
          stringBuilder.append(paramThrowable.getMessage());
          stringBuilder.append("\r");
          stringBuilder.append(Arrays.toString((Object[])paramThrowable.getStackTrace()));
          hashMap.put("ext", stringBuilder.toString());
        } else {
          hashMap.put("extype", "");
          hashMap.put("ex", paramString);
        } 
        jSONObject.put("biz", new JSONObject(hashMap));
        return;
      } finally {
        paramString = null;
        GDTLogger.w("Exception While build s2ss error report req", (Throwable)paramString);
      }  
    GDTLogger.w("Report Not Work while  ADManager  not Inited");
  }
  
  public final void a(Context paramContext, SM paramSM, PM paramPM, DeviceStatus paramDeviceStatus, APPStatus paramAPPStatus, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/lang/Boolean;
    //   4: invokevirtual booleanValue : ()Z
    //   7: ifeq -> 11
    //   10: return
    //   11: ldc com/qq/e/comm/services/a
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield b : Ljava/lang/Boolean;
    //   18: invokevirtual booleanValue : ()Z
    //   21: ifeq -> 28
    //   24: ldc com/qq/e/comm/services/a
    //   26: monitorexit
    //   27: return
    //   28: aload_2
    //   29: aload_3
    //   30: aload #4
    //   32: aload #5
    //   34: lload #6
    //   36: invokestatic a : (Lcom/qq/e/comm/managers/setting/SM;Lcom/qq/e/comm/managers/plugin/PM;Lcom/qq/e/comm/managers/status/DeviceStatus;Lcom/qq/e/comm/managers/status/APPStatus;J)Ljava/lang/String;
    //   39: astore #4
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: ldc_w 'launch request: '
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: aload #4
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_1
    //   60: invokevirtual toString : ()Ljava/lang/String;
    //   63: invokestatic d : (Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokevirtual getSuid : ()Ljava/lang/String;
    //   70: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   73: istore #8
    //   75: iload #8
    //   77: ifne -> 87
    //   80: ldc_w 'http://sdk.e.qq.com/launch'
    //   83: astore_1
    //   84: goto -> 91
    //   87: ldc_w 'http://sdk.e.qq.com/activate'
    //   90: astore_1
    //   91: new com/qq/e/comm/services/a$1
    //   94: dup
    //   95: aload_0
    //   96: aload_3
    //   97: invokestatic currentTimeMillis : ()J
    //   100: invokespecial <init> : (Lcom/qq/e/comm/services/a;Lcom/qq/e/comm/managers/plugin/PM;J)V
    //   103: astore_2
    //   104: new com/qq/e/comm/net/rr/S2SSRequest
    //   107: dup
    //   108: aload_1
    //   109: aload #4
    //   111: ldc 'UTF-8'
    //   113: invokestatic forName : (Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   116: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   119: invokespecial <init> : (Ljava/lang/String;[B)V
    //   122: astore_1
    //   123: invokestatic getInstance : ()Lcom/qq/e/comm/net/NetworkClient;
    //   126: aload_1
    //   127: getstatic com/qq/e/comm/net/NetworkClient$Priority.High : Lcom/qq/e/comm/net/NetworkClient$Priority;
    //   130: aload_2
    //   131: invokeinterface submit : (Lcom/qq/e/comm/net/rr/Request;Lcom/qq/e/comm/net/NetworkClient$Priority;Lcom/qq/e/comm/net/NetworkCallBack;)V
    //   136: aload_0
    //   137: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   140: putfield b : Ljava/lang/Boolean;
    //   143: goto -> 24
    //   146: astore_1
    //   147: ldc com/qq/e/comm/services/a
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Exception table:
    //   from	to	target	type
    //   14	24	146	finally
    //   24	27	146	finally
    //   28	75	146	finally
    //   91	143	146	finally
    //   147	150	146	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\services\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
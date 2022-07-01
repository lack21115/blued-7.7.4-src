package com.qq.e.comm.managers;

import android.content.Context;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class GDTADManager {
  public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();
  
  private volatile Boolean a = Boolean.FALSE;
  
  private volatile Context b;
  
  private volatile SM c;
  
  private volatile PM d;
  
  private volatile DevTools e;
  
  private volatile APPStatus f;
  
  private volatile DeviceStatus g;
  
  private volatile String h;
  
  private PM.a.a i;
  
  private GDTADManager() {}
  
  public static GDTADManager getInstance() {
    return a.a();
  }
  
  public JSONObject buildS2SSBaseInfo() throws JSONException {
    if (isInitialized()) {
      JSONObject jSONObject = com.qq.e.comm.net.a.a(this.c);
      jSONObject.put("app", com.qq.e.comm.net.a.a(this.f));
      jSONObject.put("c", com.qq.e.comm.net.a.a(this.g));
      jSONObject.put("sdk", com.qq.e.comm.net.a.a(this.d));
      return jSONObject;
    } 
    return null;
  }
  
  public String getADActivityClazz() {
    return CustomPkgConstants.getADActivityName();
  }
  
  public Context getAppContext() {
    return this.b;
  }
  
  public APPStatus getAppStatus() {
    return this.f;
  }
  
  public DevTools getDevTools() {
    if (this.e == null)
      this.e = new DevTools(); 
    return this.e;
  }
  
  public DeviceStatus getDeviceStatus() {
    return this.g;
  }
  
  public String getDownLoadClazz() {
    return CustomPkgConstants.getDownLoadServiceName();
  }
  
  public String getLandscapeADActivityClazz() {
    return CustomPkgConstants.getLandscapeADActivityName();
  }
  
  public PM getPM() {
    return this.d;
  }
  
  public String getPortraitADActivityClazz() {
    return CustomPkgConstants.getPortraitADActivityName();
  }
  
  public String getProcessName() {
    return this.h;
  }
  
  public String getRewardvideoLandscapeADActivityClazz() {
    return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
  }
  
  public String getRewardvideoPortraitADActivityClazz() {
    return CustomPkgConstants.getRewardvideoPortraitADActivityName();
  }
  
  public SM getSM() {
    return this.c;
  }
  
  public boolean initWith(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic android/os/Build$VERSION.SDK_INT : I
    //   5: istore_3
    //   6: iconst_0
    //   7: istore #4
    //   9: iload_3
    //   10: bipush #14
    //   12: if_icmpge -> 25
    //   15: ldc 'system version not support !'
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic e : (Ljava/lang/String;)V
    //   22: goto -> 204
    //   25: aload_0
    //   26: getfield a : Ljava/lang/Boolean;
    //   29: invokevirtual booleanValue : ()Z
    //   32: ifeq -> 38
    //   35: goto -> 214
    //   38: aload_1
    //   39: ifnull -> 198
    //   42: aload_2
    //   43: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   46: istore #5
    //   48: iload #5
    //   50: ifeq -> 56
    //   53: goto -> 198
    //   56: invokestatic nanoTime : ()J
    //   59: lstore #6
    //   61: aload_0
    //   62: aload_1
    //   63: invokestatic getProcessName : (Landroid/content/Context;)Ljava/lang/String;
    //   66: putfield h : Ljava/lang/String;
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   74: putfield b : Landroid/content/Context;
    //   77: aload_0
    //   78: new com/qq/e/comm/managers/setting/SM
    //   81: dup
    //   82: aload_0
    //   83: getfield b : Landroid/content/Context;
    //   86: invokespecial <init> : (Landroid/content/Context;)V
    //   89: putfield c : Lcom/qq/e/comm/managers/setting/SM;
    //   92: aload_0
    //   93: new com/qq/e/comm/managers/plugin/PM
    //   96: dup
    //   97: aload_0
    //   98: getfield b : Landroid/content/Context;
    //   101: aload_0
    //   102: getfield i : Lcom/qq/e/comm/managers/plugin/PM$a$a;
    //   105: invokespecial <init> : (Landroid/content/Context;Lcom/qq/e/comm/managers/plugin/PM$a$a;)V
    //   108: putfield d : Lcom/qq/e/comm/managers/plugin/PM;
    //   111: aload_0
    //   112: new com/qq/e/comm/managers/status/APPStatus
    //   115: dup
    //   116: aload_2
    //   117: aload_0
    //   118: getfield b : Landroid/content/Context;
    //   121: invokespecial <init> : (Ljava/lang/String;Landroid/content/Context;)V
    //   124: putfield f : Lcom/qq/e/comm/managers/status/APPStatus;
    //   127: aload_0
    //   128: new com/qq/e/comm/managers/status/DeviceStatus
    //   131: dup
    //   132: aload_0
    //   133: getfield b : Landroid/content/Context;
    //   136: invokespecial <init> : (Landroid/content/Context;)V
    //   139: putfield g : Lcom/qq/e/comm/managers/status/DeviceStatus;
    //   142: getstatic android/os/Build$VERSION.SDK_INT : I
    //   145: bipush #7
    //   147: if_icmple -> 178
    //   150: invokestatic a : ()Lcom/qq/e/comm/services/a;
    //   153: aload_0
    //   154: getfield b : Landroid/content/Context;
    //   157: aload_0
    //   158: getfield c : Lcom/qq/e/comm/managers/setting/SM;
    //   161: aload_0
    //   162: getfield d : Lcom/qq/e/comm/managers/plugin/PM;
    //   165: aload_0
    //   166: getfield g : Lcom/qq/e/comm/managers/status/DeviceStatus;
    //   169: aload_0
    //   170: getfield f : Lcom/qq/e/comm/managers/status/APPStatus;
    //   173: lload #6
    //   175: invokevirtual a : (Landroid/content/Context;Lcom/qq/e/comm/managers/setting/SM;Lcom/qq/e/comm/managers/plugin/PM;Lcom/qq/e/comm/managers/status/DeviceStatus;Lcom/qq/e/comm/managers/status/APPStatus;J)V
    //   178: aload_0
    //   179: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   182: putfield a : Ljava/lang/Boolean;
    //   185: goto -> 214
    //   188: astore_1
    //   189: ldc 'ADManager init error'
    //   191: aload_1
    //   192: invokestatic report : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: goto -> 204
    //   198: ldc 'Context And APPID should Never Be NULL while init GDTADManager'
    //   200: astore_1
    //   201: goto -> 18
    //   204: aload_0
    //   205: monitorexit
    //   206: iload #4
    //   208: ireturn
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: iconst_1
    //   215: istore #4
    //   217: goto -> 204
    // Exception table:
    //   from	to	target	type
    //   2	6	209	finally
    //   18	22	209	finally
    //   25	35	209	finally
    //   42	48	209	finally
    //   56	178	188	finally
    //   178	185	188	finally
    //   189	195	209	finally
  }
  
  public boolean isInitialized() {
    return (this.a == null) ? false : this.a.booleanValue();
  }
  
  public void setPluginLoadListener(PM.a.a parama) {
    this.i = parama;
  }
  
  static final class a {
    private static GDTADManager a = new GDTADManager((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\GDTADManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
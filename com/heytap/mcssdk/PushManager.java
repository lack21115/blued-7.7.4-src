package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.heytap.mcssdk.a.d;
import com.heytap.mcssdk.b.c;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.MessageStat;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.mcssdk.utils.Utils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PushManager implements b {
  private static final int[] a = new int[] { 
      99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 
      115, 46, 109, 99, 115 };
  
  private static final int[] b = new int[] { 
      99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 
      115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 
      99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 
      73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 
      83, 83, 65, 71, 69 };
  
  private static int c = 0;
  
  private static String d;
  
  private static boolean e;
  
  private final Object f;
  
  private Context g;
  
  private List<c> h;
  
  private List<d> i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private PushCallback m;
  
  private PushManager() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: new java/lang/Object
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: putfield f : Ljava/lang/Object;
    //   15: aload_0
    //   16: new java/util/ArrayList
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: putfield h : Ljava/util/List;
    //   26: aload_0
    //   27: new java/util/ArrayList
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: putfield i : Ljava/util/List;
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield l : Ljava/lang/String;
    //   42: ldc com/heytap/mcssdk/PushManager
    //   44: monitorenter
    //   45: getstatic com/heytap/mcssdk/PushManager.c : I
    //   48: ifgt -> 129
    //   51: getstatic com/heytap/mcssdk/PushManager.c : I
    //   54: iconst_1
    //   55: iadd
    //   56: putstatic com/heytap/mcssdk/PushManager.c : I
    //   59: ldc com/heytap/mcssdk/PushManager
    //   61: monitorexit
    //   62: aload_0
    //   63: new com/heytap/mcssdk/a/a
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: invokespecial a : (Lcom/heytap/mcssdk/a/d;)V
    //   73: aload_0
    //   74: new com/heytap/mcssdk/a/e
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: invokespecial a : (Lcom/heytap/mcssdk/a/d;)V
    //   84: aload_0
    //   85: new com/heytap/mcssdk/a/b
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: invokespecial a : (Lcom/heytap/mcssdk/a/d;)V
    //   95: aload_0
    //   96: new com/heytap/mcssdk/b/a
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: invokespecial a : (Lcom/heytap/mcssdk/b/c;)V
    //   106: aload_0
    //   107: new com/heytap/mcssdk/b/d
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: invokespecial a : (Lcom/heytap/mcssdk/b/c;)V
    //   117: aload_0
    //   118: new com/heytap/mcssdk/b/b
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: invokespecial a : (Lcom/heytap/mcssdk/b/c;)V
    //   128: return
    //   129: new java/lang/RuntimeException
    //   132: dup
    //   133: ldc 'PushManager can't create again!'
    //   135: invokespecial <init> : (Ljava/lang/String;)V
    //   138: athrow
    //   139: astore_1
    //   140: ldc com/heytap/mcssdk/PushManager
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Exception table:
    //   from	to	target	type
    //   45	62	139	finally
    //   129	139	139	finally
    //   140	143	139	finally
  }
  
  public static PushManager a() {
    return e.a();
  }
  
  public static String a(Context paramContext) {
    if (d == null) {
      boolean bool;
      String str = d(paramContext);
      if (str == null) {
        d = Utils.a(a);
        bool = false;
      } else {
        d = str;
        bool = true;
      } 
      e = bool;
    } 
    return d;
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject) {
    synchronized (this.f) {
      Intent intent = b(paramInt, paramString, paramJSONObject);
      this.g.startService(intent);
      return;
    } 
  }
  
  private void a(int paramInt, JSONObject paramJSONObject) {
    a(paramInt, "", paramJSONObject);
  }
  
  public static void a(Context paramContext, AppMessage paramAppMessage, String paramString) {
    try {
      Intent intent = new Intent();
      intent.setAction(b(paramContext));
      intent.setPackage(a(paramContext));
      intent.putExtra("type", 12291);
      intent.putExtra("taskID", paramAppMessage.e());
      intent.putExtra("appPackage", paramAppMessage.f());
      intent.putExtra("messageID", String.valueOf(paramAppMessage.g()));
      intent.putExtra("globalID", String.valueOf(paramAppMessage.g()));
      intent.putExtra("messageType", paramAppMessage.b());
      intent.putExtra("eventID", paramString);
      paramContext.startService(intent);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("statisticMessage--Exception");
      stringBuilder.append(exception.getMessage());
      LogUtil.b(stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(Context paramContext, MessageStat paramMessageStat) {
    StatUtil.a(paramContext, paramMessageStat);
  }
  
  public static void a(Context paramContext, SptDataMessage paramSptDataMessage, String paramString) {
    try {
      Intent intent = new Intent();
      intent.setAction(b(paramContext));
      intent.setPackage(a(paramContext));
      intent.putExtra("type", 12291);
      intent.putExtra("taskID", paramSptDataMessage.e());
      intent.putExtra("appPackage", paramSptDataMessage.f());
      intent.putExtra("messageID", paramSptDataMessage.g());
      intent.putExtra("globalID", paramSptDataMessage.a());
      intent.putExtra("messageType", paramSptDataMessage.b());
      intent.putExtra("eventID", paramString);
      paramContext.startService(intent);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("statisticMessage--Exception");
      stringBuilder.append(exception.getMessage());
      LogUtil.b(stringBuilder.toString());
      return;
    } 
  }
  
  private void a(d paramd) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 25
    //   6: aload_0
    //   7: getfield i : Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: goto -> 25
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    // Exception table:
    //   from	to	target	type
    //   6	17	20	finally
  }
  
  private void a(c paramc) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 25
    //   6: aload_0
    //   7: getfield h : Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: goto -> 25
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    // Exception table:
    //   from	to	target	type
    //   6	17	20	finally
  }
  
  private Intent b(int paramInt, String paramString, JSONObject paramJSONObject) {
    Intent intent = new Intent();
    intent.setAction(b(this.g));
    intent.setPackage(a(this.g));
    intent.putExtra("type", paramInt);
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("versionName", Utils.c(this.g, this.g.getPackageName()));
      jSONObject.putOpt("versionCode", Integer.valueOf(Utils.b(this.g, this.g.getPackageName())));
    } catch (Exception exception) {
    
    } finally {
      intent.putExtra("extra", jSONObject.toString());
    } 
    intent.putExtra("extra", jSONObject.toString());
    intent.putExtra("params", paramString);
    intent.putExtra("appPackage", this.g.getPackageName());
    intent.putExtra("appKey", this.j);
    intent.putExtra("appSecret", this.k);
    intent.putExtra("registerID", this.l);
    intent.putExtra("sdkVersion", i());
    return intent;
  }
  
  public static String b(Context paramContext) {
    if (d == null)
      d(paramContext); 
    return e ? "com.mcs.action.RECEIVE_SDK_MESSAGE" : Utils.a(b);
  }
  
  public static boolean c(Context paramContext) {
    String str = a(paramContext);
    return (Utils.a(paramContext, str) && Utils.b(paramContext, str) >= 1012 && Utils.a(paramContext, str, "supportOpenPush"));
  }
  
  private static String d(Context paramContext) {
    Intent intent = new Intent("com.mcs.action.RECEIVE_SDK_MESSAGE");
    List list = paramContext.getPackageManager().queryIntentServices(intent, 8192);
    if (Build.VERSION.SDK_INT >= 24) {
      Iterator iterator = list.iterator();
      while (true) {
        if (iterator.hasNext()) {
          String str = ((ResolveInfo)iterator.next()).serviceInfo.packageName;
          try {
            boolean bool1;
            PackageManager packageManager = paramContext.getPackageManager();
            boolean bool2 = false;
            if (((packageManager.getApplicationInfo(str, 0)).flags & 0x1) == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            int i = paramContext.getPackageManager().getPackageUid(str, 0);
            int j = paramContext.getPackageManager().getPackageUid("android", 0);
            if (i == j)
              bool2 = true; 
            if (bool1 || bool2)
              return str; 
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
          continue;
        } 
        return null;
      } 
    } 
    return null;
  }
  
  public static String i() {
    return "2.0.2";
  }
  
  private void k() {
    if (this.g != null)
      return; 
    throw new IllegalArgumentException("please call the register first!");
  }
  
  private void l() {
    if (this.l != null)
      return; 
    throw new IllegalArgumentException("please call the register until get the registerID!");
  }
  
  private void m() {
    k();
    l();
  }
  
  public void a(int paramInt) {
    Intent intent = b(paramInt, "", null);
    this.g.bindService(intent, new d(this, intent), 1);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, PushCallback paramPushCallback) {
    a(paramContext, paramString1, paramString2, (JSONObject)null, paramPushCallback);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, PushCallback paramPushCallback) {
    if (paramContext != null)
      try {
        a(paramContext, new MessageStat(paramContext.getPackageName(), "push_register", null));
        if (c(paramContext)) {
          this.j = paramString1;
          this.k = paramString2;
          this.g = paramContext.getApplicationContext();
          this.m = paramPushCallback;
          a(12289, paramJSONObject);
          return;
        } 
        throw new IllegalArgumentException("the phone is not support push!");
      } catch (Exception exception) {
        if (e() != null)
          e().a(-2, null); 
        return;
      }  
    throw new IllegalArgumentException("context is null !");
  }
  
  public void a(String paramString) {
    this.l = paramString;
  }
  
  public void a(List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a(paramList, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public void a(List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JSONObject paramJSONObject) {
    try {
      m();
      if (paramList != null) {
        int i = paramList.size();
        if (i > 0 && paramInt1 >= 0 && paramInt1 <= 23 && paramInt2 >= 0 && paramInt2 <= 59 && paramInt3 >= paramInt1 && paramInt3 <= 23 && paramInt4 >= paramInt2 && paramInt4 <= 59)
          try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("weekDays", CommandMessage.a(paramList));
            jSONObject.put("startHour", paramInt1);
            jSONObject.put("startMin", paramInt2);
            jSONObject.put("endHour", paramInt3);
            jSONObject.put("endMin", paramInt4);
            a(12298, jSONObject.toString(), paramJSONObject);
            return;
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
          }  
      } 
      throw new IllegalArgumentException("params are not all right,please check params");
    } catch (Exception exception) {
      if (e() != null)
        e().b(-2, exception.getMessage()); 
      return;
    } 
  }
  
  public void a(JSONObject paramJSONObject) {
    try {
      k();
      a(12289, paramJSONObject);
      return;
    } catch (Exception exception) {
      if (e() != null)
        e().a(-2, null); 
      return;
    } 
  }
  
  public List<d> b() {
    return this.i;
  }
  
  public void b(JSONObject paramJSONObject) {
    try {
      m();
      a(12299, paramJSONObject);
      return;
    } catch (Exception exception) {
      LogUtil.a("mcssdk---", exception);
      return;
    } 
  }
  
  public List<c> c() {
    return this.h;
  }
  
  public void c(JSONObject paramJSONObject) {
    try {
      m();
      a(12300, paramJSONObject);
      return;
    } catch (Exception exception) {
      LogUtil.a("mcssdk---", exception);
      return;
    } 
  }
  
  public String d() {
    return this.l;
  }
  
  public PushCallback e() {
    return this.m;
  }
  
  public void f() {
    a((JSONObject)null);
  }
  
  public void g() {
    b((JSONObject)null);
  }
  
  public void h() {
    c((JSONObject)null);
  }
  
  public void j() {
    try {
      k();
      a(12313);
      return;
    } catch (Exception exception) {
      LogUtil.a("mcssdk---", exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\PushManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
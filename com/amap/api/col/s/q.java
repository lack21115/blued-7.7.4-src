package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import org.json.JSONObject;

public final class q {
  public static br a;
  
  private static q b;
  
  private static Context c;
  
  private a d;
  
  private HandlerThread e = new HandlerThread(this, "manifestThread") {
      public final void run() {
        Thread.currentThread().setName("ManifestConfigThread");
        br br = h.a(false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("11K");
        stringBuilder.append(";");
        stringBuilder.append("001");
        stringBuilder.append(";");
        stringBuilder.append("184");
        stringBuilder.append(";");
        stringBuilder.append("185");
        q.b(q.a());
        bj.a(q.a(), br, stringBuilder.toString(), new bj.a(this) {
              public final void a(bj.b param2b) {
                Message message = new Message();
                if (param2b != null)
                  try {
                    if (param2b.g != null)
                      message.obj = new r(param2b.g.b, param2b.g.a); 
                  } finally {} 
                if (param2b != null && param2b.f != null) {
                  JSONObject jSONObject = param2b.f.optJSONObject("184");
                  if (jSONObject != null) {
                    q.a(jSONObject);
                    al.a(q.a(), "amap_search", "cache_control", jSONObject.toString());
                  } 
                } 
                if (param2b != null && param2b.f != null) {
                  JSONObject jSONObject = param2b.f.optJSONObject("185");
                  if (jSONObject != null) {
                    q.b(jSONObject);
                    al.a(q.a(), "amap_search", "parm_control", jSONObject.toString());
                  } 
                } 
                message.what = 3;
                if (q.a(this.a.a) != null) {
                  q.a(this.a.a).sendMessage(message);
                  return;
                } 
              }
            });
        try {
          Thread.sleep(10000L);
          return;
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
          return;
        } 
      }
    };
  
  private q(Context paramContext) {
    c = paramContext;
    a = h.a(false);
    try {
      ac.a();
      return;
    } finally {
      paramContext = null;
      i.a((Throwable)paramContext, "ManifestConfig", "ManifestConfig");
    } 
  }
  
  private static ad.a a(JSONObject paramJSONObject, boolean paramBoolean, ad.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 189
    //   4: new com/amap/api/col/s/ad$a
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore #9
    //   13: iconst_0
    //   14: istore #8
    //   16: iconst_0
    //   17: istore #7
    //   19: iload_1
    //   20: ifeq -> 58
    //   23: aload_0
    //   24: ldc 'able'
    //   26: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   29: astore #10
    //   31: aload_2
    //   32: ifnull -> 191
    //   35: iload #7
    //   37: istore_1
    //   38: aload_2
    //   39: invokevirtual a : ()Z
    //   42: ifeq -> 48
    //   45: goto -> 191
    //   48: aload #10
    //   50: iload_1
    //   51: invokestatic a : (Ljava/lang/String;Z)Z
    //   54: istore_1
    //   55: goto -> 83
    //   58: aload_2
    //   59: ifnull -> 203
    //   62: iload #8
    //   64: istore_1
    //   65: aload_2
    //   66: invokevirtual a : ()Z
    //   69: ifeq -> 75
    //   72: goto -> 203
    //   75: aload_0
    //   76: ldc 'able'
    //   78: iload_1
    //   79: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   82: istore_1
    //   83: aload_2
    //   84: ifnull -> 208
    //   87: aload_2
    //   88: invokevirtual b : ()J
    //   91: l2i
    //   92: istore #5
    //   94: goto -> 97
    //   97: aload_0
    //   98: ldc 'timeoffset'
    //   100: iload #5
    //   102: invokevirtual optInt : (Ljava/lang/String;I)I
    //   105: istore #6
    //   107: aload_2
    //   108: ifnull -> 215
    //   111: aload_2
    //   112: invokevirtual c : ()I
    //   115: istore #5
    //   117: goto -> 120
    //   120: aload_0
    //   121: ldc 'num'
    //   123: iload #5
    //   125: invokevirtual optInt : (Ljava/lang/String;I)I
    //   128: istore #5
    //   130: aload_2
    //   131: ifnull -> 222
    //   134: aload_2
    //   135: invokevirtual d : ()D
    //   138: dstore_3
    //   139: goto -> 142
    //   142: aload_0
    //   143: ldc 'limitDistance'
    //   145: dload_3
    //   146: invokevirtual optDouble : (Ljava/lang/String;D)D
    //   149: dstore_3
    //   150: aload #9
    //   152: iload_1
    //   153: invokevirtual a : (Z)V
    //   156: aload #9
    //   158: iload #6
    //   160: i2l
    //   161: invokevirtual a : (J)V
    //   164: aload #9
    //   166: iload #5
    //   168: invokevirtual a : (I)V
    //   171: aload #9
    //   173: dload_3
    //   174: invokevirtual a : (D)V
    //   177: aload #9
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_2
    //   184: invokevirtual printStackTrace : ()V
    //   187: aload_0
    //   188: areturn
    //   189: aconst_null
    //   190: areturn
    //   191: iconst_1
    //   192: istore_1
    //   193: goto -> 48
    //   196: astore_2
    //   197: aload #9
    //   199: astore_0
    //   200: goto -> 183
    //   203: iconst_1
    //   204: istore_1
    //   205: goto -> 75
    //   208: ldc 86400
    //   210: istore #5
    //   212: goto -> 97
    //   215: bipush #10
    //   217: istore #5
    //   219: goto -> 120
    //   222: dconst_0
    //   223: dstore_3
    //   224: goto -> 142
    // Exception table:
    //   from	to	target	type
    //   4	13	180	finally
    //   23	31	196	finally
    //   38	45	196	finally
    //   48	55	196	finally
    //   65	72	196	finally
    //   75	83	196	finally
    //   87	94	196	finally
    //   97	107	196	finally
    //   111	117	196	finally
    //   120	130	196	finally
    //   134	139	196	finally
    //   142	177	196	finally
  }
  
  public static q a(Context paramContext) {
    if (b == null)
      b = new q(paramContext); 
    return b;
  }
  
  private static void a(String paramString, JSONObject paramJSONObject, ad.a parama) {
    if (paramJSONObject == null)
      return; 
    if (paramJSONObject.has(paramString)) {
      ad.a a1 = a(paramJSONObject.optJSONObject(paramString), false, parama);
      ad.a().a(paramString, a1);
    } 
  }
  
  private static void c(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        boolean bool1 = bj.a(paramJSONObject.optString("passAreaAble"), true);
        boolean bool2 = bj.a(paramJSONObject.optString("truckAble"), true);
        boolean bool3 = bj.a(paramJSONObject.optString("poiPageAble"), true);
        boolean bool4 = bj.a(paramJSONObject.optString("rideAble"), true);
        boolean bool5 = bj.a(paramJSONObject.optString("walkAble"), true);
        boolean bool6 = bj.a(paramJSONObject.optString("passPointAble"), true);
        boolean bool7 = bj.a(paramJSONObject.optString("keyWordLenAble"), true);
        int i = paramJSONObject.optInt("poiPageMaxSize", 25);
        int j = paramJSONObject.optInt("passAreaMaxCount", 100);
        int k = paramJSONObject.optInt("walkMaxLength", 100);
        int m = paramJSONObject.optInt("passPointMaxCount", 6);
        int n = paramJSONObject.optInt("poiPageMaxNum", 100);
        int i1 = paramJSONObject.optInt("truckMaxLength", 5000);
        int i2 = paramJSONObject.optInt("rideMaxLength", 1200);
        int i3 = paramJSONObject.optInt("passAreaMaxArea", 100000000);
        int i4 = paramJSONObject.optInt("passAreaPointCount", 16);
        int i5 = paramJSONObject.optInt("keyWordLenMaxNum", 100);
        (ag.a()).a = bool1;
        (ag.a()).j = j;
        (ag.a()).p = i3;
        (ag.a()).q = i4;
        (ag.a()).c = bool2;
        (ag.a()).n = i1;
        (ag.a()).d = bool3;
        (ag.a()).m = n;
        (ag.a()).h = i;
        (ag.a()).i = i5;
        (ag.a()).b = bool7;
        (ag.a()).e = bool4;
        (ag.a()).o = i2;
        (ag.a()).f = bool5;
        (ag.a()).k = k;
        (ag.a()).g = bool6;
        return;
      } finally {
        paramJSONObject = null;
      }  
  }
  
  private static void d(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        if (paramJSONObject.has("able")) {
          ad.a a1 = a(paramJSONObject, true, (ad.a)null);
          ad.a().a(a1);
          if (!a1.a())
            return; 
          a("regeo", paramJSONObject, a1);
          a("geo", paramJSONObject, a1);
          a("placeText", paramJSONObject, a1);
          return;
        } 
      } finally {
        paramJSONObject = null;
      }  
  }
  
  final class a extends Handler {
    String a = "handleMessage";
    
    public a(q this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      if (param1Message == null)
        return; 
      if (param1Message.what != 3)
        return; 
      try {
        r r2 = (r)param1Message.obj;
        r r1 = r2;
        if (r2 == null)
          r1 = new r(false, false); 
        return;
      } finally {
        param1Message = null;
        i.a((Throwable)param1Message, "ManifestConfig", this.a);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
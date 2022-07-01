package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends b {
  private String A;
  
  private JSONObject B;
  
  private JSONObject C;
  
  private final int b = 1;
  
  private final int c = 2;
  
  private final int d = 4;
  
  private final int e = 8;
  
  private final int f = 16;
  
  private final int g = 32;
  
  private final int h = 64;
  
  private final int i = 128;
  
  private final int j = 256;
  
  private final int k = 512;
  
  private final int l = 1024;
  
  private final int m = 2048;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private String v;
  
  private String w;
  
  private String x;
  
  private String y;
  
  private JSONArray z;
  
  private JSONArray a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore_3
    //   4: aload_1
    //   5: ldc 'android.permission.READ_PHONE_STATE'
    //   7: invokevirtual checkCallingOrSelfPermission : (Ljava/lang/String;)I
    //   10: ifeq -> 22
    //   13: ldc 'no read_phone_state permission'
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic d : (Ljava/lang/String;)V
    //   20: aconst_null
    //   21: areturn
    //   22: aload_1
    //   23: ldc 'phone'
    //   25: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast android/telephony/TelephonyManager
    //   31: astore #7
    //   33: aload #7
    //   35: ifnonnull -> 44
    //   38: ldc 'tm is null'
    //   40: astore_1
    //   41: goto -> 16
    //   44: aload_0
    //   45: aload #7
    //   47: invokevirtual getDeviceId : ()Ljava/lang/String;
    //   50: putfield n : Ljava/lang/String;
    //   53: iload_2
    //   54: ifeq -> 82
    //   57: aload_0
    //   58: aload #7
    //   60: invokevirtual getSubscriberId : ()Ljava/lang/String;
    //   63: putfield w : Ljava/lang/String;
    //   66: aload_0
    //   67: getfield w : Ljava/lang/String;
    //   70: ifnonnull -> 87
    //   73: aload_0
    //   74: ldc ''
    //   76: putfield w : Ljava/lang/String;
    //   79: goto -> 87
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield w : Ljava/lang/String;
    //   87: getstatic android/os/Build$VERSION.SDK_INT : I
    //   90: bipush #21
    //   92: if_icmplt -> 312
    //   95: getstatic android/os/Build$VERSION.SDK_INT : I
    //   98: bipush #23
    //   100: if_icmplt -> 128
    //   103: aload_0
    //   104: aload #7
    //   106: iconst_0
    //   107: invokevirtual getDeviceId : (I)Ljava/lang/String;
    //   110: putfield o : Ljava/lang/String;
    //   113: aload #7
    //   115: iconst_1
    //   116: invokevirtual getDeviceId : (I)Ljava/lang/String;
    //   119: astore_1
    //   120: aload_0
    //   121: aload_1
    //   122: putfield p : Ljava/lang/String;
    //   125: goto -> 155
    //   128: aload_0
    //   129: aload #7
    //   131: ldc 'getDeviceId'
    //   133: invokespecial a : (Landroid/telephony/TelephonyManager;Ljava/lang/String;)[Ljava/lang/String;
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull -> 155
    //   141: aload_0
    //   142: aload_1
    //   143: iconst_1
    //   144: aaload
    //   145: putfield o : Ljava/lang/String;
    //   148: aload_1
    //   149: iconst_2
    //   150: aaload
    //   151: astore_1
    //   152: goto -> 120
    //   155: getstatic android/os/Build$VERSION.SDK_INT : I
    //   158: bipush #26
    //   160: if_icmplt -> 197
    //   163: aload_0
    //   164: aload #7
    //   166: invokevirtual getImei : ()Ljava/lang/String;
    //   169: putfield q : Ljava/lang/String;
    //   172: aload_0
    //   173: aload #7
    //   175: iconst_0
    //   176: invokevirtual getImei : (I)Ljava/lang/String;
    //   179: putfield r : Ljava/lang/String;
    //   182: aload #7
    //   184: iconst_1
    //   185: invokevirtual getImei : (I)Ljava/lang/String;
    //   188: astore_1
    //   189: aload_0
    //   190: aload_1
    //   191: putfield s : Ljava/lang/String;
    //   194: goto -> 231
    //   197: aload_0
    //   198: aload #7
    //   200: ldc 'getImei'
    //   202: invokespecial a : (Landroid/telephony/TelephonyManager;Ljava/lang/String;)[Ljava/lang/String;
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull -> 231
    //   210: aload_0
    //   211: aload_1
    //   212: iconst_0
    //   213: aaload
    //   214: putfield q : Ljava/lang/String;
    //   217: aload_0
    //   218: aload_1
    //   219: iconst_1
    //   220: aaload
    //   221: putfield r : Ljava/lang/String;
    //   224: aload_1
    //   225: iconst_2
    //   226: aaload
    //   227: astore_1
    //   228: goto -> 189
    //   231: iload_2
    //   232: ifeq -> 265
    //   235: aload_0
    //   236: aload #7
    //   238: ldc 'getSubscriberId'
    //   240: invokespecial a : (Landroid/telephony/TelephonyManager;Ljava/lang/String;)[Ljava/lang/String;
    //   243: astore_1
    //   244: aload_1
    //   245: ifnull -> 275
    //   248: aload_0
    //   249: aload_1
    //   250: iconst_1
    //   251: aaload
    //   252: putfield x : Ljava/lang/String;
    //   255: aload_0
    //   256: aload_1
    //   257: iconst_2
    //   258: aaload
    //   259: putfield y : Ljava/lang/String;
    //   262: goto -> 275
    //   265: aload_0
    //   266: aconst_null
    //   267: putfield x : Ljava/lang/String;
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield y : Ljava/lang/String;
    //   275: getstatic android/os/Build$VERSION.SDK_INT : I
    //   278: bipush #26
    //   280: if_icmplt -> 312
    //   283: aload_0
    //   284: aload #7
    //   286: invokevirtual getMeid : ()Ljava/lang/String;
    //   289: putfield t : Ljava/lang/String;
    //   292: aload_0
    //   293: aload #7
    //   295: iconst_0
    //   296: invokevirtual getMeid : (I)Ljava/lang/String;
    //   299: putfield u : Ljava/lang/String;
    //   302: aload_0
    //   303: aload #7
    //   305: iconst_1
    //   306: invokevirtual getMeid : (I)Ljava/lang/String;
    //   309: putfield v : Ljava/lang/String;
    //   312: invokestatic currentTimeMillis : ()J
    //   315: lstore #5
    //   317: new java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial <init> : ()V
    //   324: astore_1
    //   325: aload_1
    //   326: ldc 'get ids, time = '
    //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_1
    //   333: lload #5
    //   335: lload_3
    //   336: lsub
    //   337: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: ldc ' ms'
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_1
    //   349: invokevirtual toString : ()Ljava/lang/String;
    //   352: invokestatic d : (Ljava/lang/String;)V
    //   355: aload_0
    //   356: invokespecial b : ()Lorg/json/JSONArray;
    //   359: areturn
  }
  
  private String[] a(TelephonyManager paramTelephonyManager, String paramString) {
    Class<?> clazz = paramTelephonyManager.getClass();
    try {
      Method method1 = clazz.getDeclaredMethod(paramString, new Class[0]);
      method1.setAccessible(true);
      String str2 = (String)method1.invoke(paramTelephonyManager, new Object[0]);
      Method method2 = clazz.getDeclaredMethod(paramString, new Class[] { int.class });
      method2.setAccessible(true);
      String str3 = (String)method2.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(0) });
      String str1 = (String)method2.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(1) });
      return new String[] { str2, str3, str1 };
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(", exception = ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      exception.printStackTrace();
      return null;
    } 
  }
  
  private JSONArray b() {
    JSONException jSONException;
    long l1 = System.currentTimeMillis();
    String[] arrayOfString = new String[12];
    arrayOfString[0] = this.n;
    arrayOfString[1] = this.o;
    arrayOfString[2] = this.p;
    arrayOfString[3] = this.q;
    arrayOfString[4] = this.r;
    arrayOfString[5] = this.s;
    arrayOfString[6] = this.t;
    arrayOfString[7] = this.u;
    arrayOfString[8] = this.v;
    arrayOfString[9] = this.w;
    arrayOfString[10] = this.x;
    arrayOfString[11] = this.y;
    int j = arrayOfString.length;
    int[] arrayOfInt = new int[j];
    int i;
    for (i = 0; i < j; i++)
      arrayOfInt[i] = 1 << i; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (i = 0; i < j; i++) {
      String str = arrayOfString[i];
      int k = arrayOfInt[i];
      if (!TextUtils.isEmpty(str)) {
        ArrayList<Integer> arrayList2 = (ArrayList)hashMap.get(str);
        ArrayList<Integer> arrayList1 = arrayList2;
        if (arrayList2 == null) {
          arrayList1 = new ArrayList();
          hashMap.put(str, arrayList1);
        } 
        arrayList1.add(Integer.valueOf(k));
      } 
    } 
    i = hashMap.size();
    JSONArray jSONArray = null;
    Iterator<String> iterator = null;
    if (i > 0) {
      try {
        jSONArray = new JSONArray();
        try {
          for (String str : hashMap.keySet()) {
            JSONObject jSONObject = new JSONObject();
            Iterator<Integer> iterator1 = ((ArrayList)hashMap.get(str)).iterator();
            for (i = 0; iterator1.hasNext(); i |= ((Integer)iterator1.next()).intValue());
            jSONObject.put("id_h", Md5Util.encode(str.toLowerCase()));
            jSONObject.put("bitmap", i);
            jSONArray.put(jSONObject);
          } 
        } catch (JSONException jSONException1) {}
      } catch (JSONException jSONException2) {
        jSONException = jSONException1;
        jSONException1 = jSONException2;
      } 
      jSONException1.printStackTrace();
    } 
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("assemble idInfo, time = ");
    stringBuilder.append(l2 - l1);
    stringBuilder.append(" ms");
    GDTLogger.d(stringBuilder.toString());
    return (JSONArray)jSONException;
  }
  
  private JSONObject c() {
    JSONObject jSONObject2 = new JSONObject();
    try {
      if (this.z != null && this.z.length() > 0)
        jSONObject2.put("id_info", this.z); 
      if (!TextUtils.isEmpty(this.A))
        jSONObject2.put("wm_h", this.A); 
      if (this.B != null && this.B.length() > 0)
        jSONObject2.put("uuid", this.B); 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    JSONObject jSONObject1 = null;
    if (jSONObject2.length() > 0) {
      jSONObject1 = new JSONObject();
      try {
        jSONObject1.put("attri_info", jSONObject2);
        return jSONObject1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    return jSONObject1;
  }
  
  private void e(Context paramContext) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   3: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   6: ldc_w 'tdson'
    //   9: iconst_1
    //   10: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   13: iconst_1
    //   14: if_icmpne -> 94
    //   17: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   20: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   23: ldc_w 'imsion'
    //   26: iconst_1
    //   27: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   30: iconst_1
    //   31: if_icmpne -> 39
    //   34: iconst_1
    //   35: istore_3
    //   36: goto -> 41
    //   39: iconst_0
    //   40: istore_3
    //   41: aload_0
    //   42: getfield w : Ljava/lang/String;
    //   45: ifnonnull -> 52
    //   48: iload_3
    //   49: ifne -> 63
    //   52: aload_0
    //   53: getfield w : Ljava/lang/String;
    //   56: ifnull -> 68
    //   59: iload_3
    //   60: ifne -> 68
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: aload_0
    //   71: getfield z : Lorg/json/JSONArray;
    //   74: ifnull -> 81
    //   77: iload_2
    //   78: ifeq -> 99
    //   81: aload_0
    //   82: aload_0
    //   83: aload_1
    //   84: iload_3
    //   85: invokespecial a : (Landroid/content/Context;Z)Lorg/json/JSONArray;
    //   88: putfield z : Lorg/json/JSONArray;
    //   91: goto -> 99
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield z : Lorg/json/JSONArray;
    //   99: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   102: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   105: ldc_w 'bdon'
    //   108: iconst_1
    //   109: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   112: iconst_1
    //   113: if_icmpne -> 128
    //   116: aload_0
    //   117: aload_0
    //   118: aload_1
    //   119: invokespecial f : (Landroid/content/Context;)Ljava/lang/String;
    //   122: putfield A : Ljava/lang/String;
    //   125: goto -> 133
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield A : Ljava/lang/String;
    //   133: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   136: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   139: ldc_w 'udon'
    //   142: iconst_1
    //   143: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   146: iconst_1
    //   147: if_icmpne -> 316
    //   150: aload_0
    //   151: getfield B : Lorg/json/JSONObject;
    //   154: ifnonnull -> 279
    //   157: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   160: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   163: ldc_w 'ud_salt'
    //   166: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   169: astore #4
    //   171: aload #4
    //   173: astore_1
    //   174: aload #4
    //   176: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   179: ifeq -> 186
    //   182: ldc_w '[{"v":1,"s":"CB6;8PHJtpsNJwTW"}]'
    //   185: astore_1
    //   186: new java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: astore #4
    //   195: aload #4
    //   197: ldc_w 'read uuid use salt:'
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload #4
    //   206: aload_1
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #4
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: iconst_0
    //   217: anewarray java/lang/Object
    //   220: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aload_0
    //   224: aload_1
    //   225: invokestatic a : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   228: putfield B : Lorg/json/JSONObject;
    //   231: goto -> 242
    //   234: astore_1
    //   235: ldc_w 'read uuid error'
    //   238: aload_1
    //   239: invokestatic a : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   242: new java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial <init> : ()V
    //   249: astore_1
    //   250: aload_1
    //   251: ldc_w 'read uuid from file:'
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: aload_0
    //   260: getfield B : Lorg/json/JSONObject;
    //   263: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: invokevirtual toString : ()Ljava/lang/String;
    //   271: iconst_0
    //   272: anewarray java/lang/Object
    //   275: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: return
    //   279: new java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial <init> : ()V
    //   286: astore_1
    //   287: aload_1
    //   288: ldc_w 'read uuid from cached:'
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_1
    //   296: aload_0
    //   297: getfield B : Lorg/json/JSONObject;
    //   300: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: invokevirtual toString : ()Ljava/lang/String;
    //   308: iconst_0
    //   309: anewarray java/lang/Object
    //   312: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: return
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield B : Lorg/json/JSONObject;
    //   321: return
    //   322: astore #4
    //   324: goto -> 94
    //   327: astore_1
    //   328: goto -> 128
    // Exception table:
    //   from	to	target	type
    //   81	91	322	finally
    //   116	125	327	finally
    //   223	231	234	java/lang/Exception
  }
  
  private String f(Context paramContext) {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
      str = "no access_wifi_state permission";
      GDTLogger.d(str);
      return null;
    } 
    NetworkInfo networkInfo = ((ConnectivityManager)str.getSystemService("connectivity")).getNetworkInfo(1);
    if (networkInfo != null && networkInfo.isConnected()) {
      WifiManager wifiManager = (WifiManager)str.getSystemService("wifi");
      if (wifiManager != null) {
        String str2 = wifiManager.getConnectionInfo().getBSSID();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bssid = ");
        stringBuilder.append(str2);
        GDTLogger.d(stringBuilder.toString());
        if (!TextUtils.isEmpty(str2) && !"02:00:00:00:00:00".equals(str2))
          return Md5Util.encode(str2.replaceAll(":", "").toUpperCase()); 
        str2 = "bssid is empty";
        GDTLogger.d(str2);
        return null;
      } 
      String str1 = "wm is null";
      GDTLogger.d(str1);
      return null;
    } 
    String str = "wifi not connected";
    GDTLogger.d(str);
    return null;
  }
  
  public String a(Context paramContext) {
    return b(paramContext);
  }
  
  public String b(Context paramContext) {
    if (TextUtils.isEmpty(this.a))
      this.a = c(paramContext); 
    return this.a;
  }
  
  protected String c(Context paramContext) {
    JSONObject jSONObject = d(paramContext);
    return (jSONObject != null) ? jSONObject.toString() : null;
  }
  
  public JSONObject d(Context paramContext) {
    JSONArray jSONArray = this.z;
    String str1 = this.A;
    JSONObject jSONObject = this.B;
    String str2 = this.w;
    e(paramContext);
    if (this.C == null || (!TextUtils.isEmpty(str1) && !str1.equals(this.A)) || (!TextUtils.isEmpty(this.A) && !this.A.equals(str1)) || (jSONArray == null && this.z != null) || (this.z == null && jSONArray != null) || jSONObject != this.B || !TextUtils.equals(str2, this.w))
      this.C = c(); 
    return this.C;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
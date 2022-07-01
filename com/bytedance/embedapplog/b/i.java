package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.embed_device_register.b;
import com.bytedance.embedapplog.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  private static final String[] f = new String[] { "channel", "package", "app_version" };
  
  private boolean a;
  
  private final Context b;
  
  private final h c;
  
  private JSONObject d;
  
  private final ArrayList<c> e = new ArrayList<c>(32);
  
  private final SharedPreferences g;
  
  private int h = 0;
  
  public i(Context paramContext, h paramh) {
    this.b = paramContext;
    this.c = paramh;
    this.g = paramh.d();
    this.d = new JSONObject();
    b.a(this.b, this.g);
  }
  
  private String a(Set<String> paramSet) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramSet.iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next());
      if (iterator.hasNext())
        stringBuilder.append(","); 
    } 
    return stringBuilder.toString();
  }
  
  static void a(JSONObject paramJSONObject, String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString2))
      paramJSONObject.put(paramString1, paramString2); 
  }
  
  private boolean a(c paramc) {
    boolean bool;
    if (!this.c.u() && paramc.d) {
      bool = true;
    } else {
      bool = false;
    } 
    if (h.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("needSyncFromSub ");
      stringBuilder.append(paramc);
      stringBuilder.append(" ");
      stringBuilder.append(bool);
      h.a(stringBuilder.toString(), null);
    } 
    return bool;
  }
  
  private void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 15
    //   6: ldc 'null abconfig'
    //   8: aconst_null
    //   9: invokestatic b : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokespecial r : ()Lorg/json/JSONObject;
    //   19: ldc 'ab_version'
    //   21: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   24: astore #5
    //   26: aload #5
    //   28: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   31: ifne -> 206
    //   34: aload #5
    //   36: ldc ','
    //   38: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore #6
    //   43: new java/util/HashSet
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: astore #5
    //   52: aload #6
    //   54: arraylength
    //   55: istore_3
    //   56: iconst_0
    //   57: istore_2
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpge -> 90
    //   63: aload #6
    //   65: iload_2
    //   66: aaload
    //   67: astore #7
    //   69: aload #7
    //   71: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   74: ifne -> 214
    //   77: aload #5
    //   79: aload #7
    //   81: invokeinterface add : (Ljava/lang/Object;)Z
    //   86: pop
    //   87: goto -> 214
    //   90: aload_1
    //   91: invokevirtual keys : ()Ljava/util/Iterator;
    //   94: astore #6
    //   96: new java/util/HashSet
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #7
    //   105: aload #6
    //   107: invokeinterface hasNext : ()Z
    //   112: ifeq -> 183
    //   115: aload #6
    //   117: invokeinterface next : ()Ljava/lang/Object;
    //   122: astore #8
    //   124: aload #8
    //   126: instanceof java/lang/String
    //   129: ifeq -> 105
    //   132: aload #8
    //   134: checkcast java/lang/String
    //   137: astore #8
    //   139: aload #8
    //   141: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   144: istore #4
    //   146: iload #4
    //   148: ifne -> 105
    //   151: aload #7
    //   153: aload_1
    //   154: aload #8
    //   156: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   159: ldc 'vid'
    //   161: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   164: invokeinterface add : (Ljava/lang/Object;)Z
    //   169: pop
    //   170: goto -> 105
    //   173: astore #8
    //   175: aload #8
    //   177: invokestatic a : (Ljava/lang/Throwable;)V
    //   180: goto -> 105
    //   183: aload #5
    //   185: aload #7
    //   187: invokeinterface retainAll : (Ljava/util/Collection;)Z
    //   192: pop
    //   193: aload_0
    //   194: ldc 'ab_version'
    //   196: aload_0
    //   197: aload #5
    //   199: invokespecial a : (Ljava/util/Set;)Ljava/lang/String;
    //   202: invokespecial b : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   205: pop
    //   206: aload_0
    //   207: monitorexit
    //   208: return
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: iload_2
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   6	12	209	finally
    //   15	56	209	finally
    //   69	87	209	finally
    //   90	105	209	finally
    //   105	146	209	finally
    //   151	170	173	org/json/JSONException
    //   151	170	209	finally
    //   175	180	209	finally
    //   183	206	209	finally
  }
  
  private boolean b(String paramString, Object paramObject) {
    boolean bool;
    Object object = r().opt(paramString);
    /* monitor enter ThisExpression{ObjectType{com/bytedance/embedapplog/b/i}} */
    if ((paramObject != null && !paramObject.equals(object)) || (paramObject == null && object != null)) {
      try {
        JSONObject jSONObject1 = this.d;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.embedapplog.util.i.b(jSONObject2, jSONObject1);
        jSONObject2.put(paramString, paramObject);
        this.d = jSONObject2;
      } catch (JSONException jSONException) {
        h.a((Throwable)jSONException);
      } finally {}
      /* monitor exit ThisExpression{ObjectType{com/bytedance/embedapplog/b/i}} */
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateHeader, ");
    stringBuilder.append(paramString);
    stringBuilder.append(", ");
    stringBuilder.append(object);
    stringBuilder.append(", ");
    stringBuilder.append(paramObject);
    h.a(stringBuilder.toString(), null);
    return bool;
  }
  
  static boolean d(String paramString) {
    byte b;
    if (paramString != null) {
      b = paramString.length();
    } else {
      b = 0;
    } 
    if (b >= 13) {
      if (b > '')
        return false; 
      int j = 0;
      while (j < b) {
        char c = paramString.charAt(j);
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || c == '-') {
          j++;
          continue;
        } 
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  public static boolean e(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    byte b = 0;
    if (!bool && !"unknown".equalsIgnoreCase(paramString) && !"Null".equalsIgnoreCase(paramString)) {
      int j = 0;
      while (true) {
        if (j < paramString.length()) {
          if (paramString.charAt(j) != '0') {
            j = b;
            break;
          } 
          j++;
          continue;
        } 
        j = 1;
        break;
      } 
      return j ^ 0x1;
    } 
    return false;
  }
  
  private JSONObject r() {
    return this.d;
  }
  
  public <T> T a(String paramString, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial r : ()Lorg/json/JSONObject;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull -> 22
    //   9: aload_3
    //   10: aload_1
    //   11: invokevirtual opt : (Ljava/lang/String;)Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull -> 22
    //   19: goto -> 24
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_1
    //   25: astore_3
    //   26: aload_1
    //   27: ifnonnull -> 32
    //   30: aload_2
    //   31: astore_3
    //   32: aload_3
    //   33: areturn
  }
  
  public JSONObject a() {
    return this.a ? r() : null;
  }
  
  public void a(String paramString) {
    if (b("ab_sdk_version", paramString))
      this.c.a(paramString); 
  }
  
  public void a(HashMap<String, Object> paramHashMap) {
    JSONObject jSONObject2 = null;
    JSONObject jSONObject1 = null;
    JSONObject jSONObject3 = jSONObject2;
    if (paramHashMap != null) {
      jSONObject3 = jSONObject2;
      if (!paramHashMap.isEmpty())
        try {
          jSONObject3 = r().optJSONObject("custom");
          jSONObject2 = jSONObject3;
          if (jSONObject3 == null) {
            jSONObject1 = jSONObject3;
            jSONObject2 = new JSONObject();
          } 
          jSONObject1 = jSONObject2;
          Iterator<Map.Entry> iterator = paramHashMap.entrySet().iterator();
          while (true) {
            jSONObject1 = jSONObject2;
            jSONObject3 = jSONObject2;
            if (iterator.hasNext()) {
              jSONObject1 = jSONObject2;
              Map.Entry entry = iterator.next();
              jSONObject1 = jSONObject2;
              if (!TextUtils.isEmpty((CharSequence)entry.getKey())) {
                jSONObject1 = jSONObject2;
                jSONObject2.put((String)entry.getKey(), entry.getValue());
              } 
              continue;
            } 
            break;
          } 
        } catch (JSONException jSONException) {
          h.a((Throwable)jSONException);
          jSONObject3 = jSONObject1;
        }  
    } 
    if (b("custom", jSONObject3))
      this.c.a(jSONObject3); 
  }
  
  public void a(JSONObject paramJSONObject) {
    this.c.b(paramJSONObject);
    b(paramJSONObject);
  }
  
  public boolean a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   3: ifeq -> 86
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #14
    //   15: aload #14
    //   17: ldc_w 'saveRegisterInfo, '
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #14
    //   26: aload_2
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #14
    //   33: ldc ', '
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #14
    //   41: aload_3
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #14
    //   48: ldc ', '
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #14
    //   56: aload #4
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload #14
    //   64: ldc ', '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #14
    //   72: aload_1
    //   73: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #14
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: aconst_null
    //   83: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: invokestatic e : (Ljava/lang/String;)Z
    //   90: istore #9
    //   92: aload_3
    //   93: invokestatic e : (Ljava/lang/String;)Z
    //   96: istore #10
    //   98: aload #4
    //   100: invokestatic e : (Ljava/lang/String;)Z
    //   103: istore #11
    //   105: aload_0
    //   106: getfield g : Landroid/content/SharedPreferences;
    //   109: ldc_w 'version_code'
    //   112: iconst_0
    //   113: invokeinterface getInt : (Ljava/lang/String;I)I
    //   118: istore #5
    //   120: aload_0
    //   121: invokespecial r : ()Lorg/json/JSONObject;
    //   124: ldc_w 'version_code'
    //   127: iconst_0
    //   128: invokevirtual optInt : (Ljava/lang/String;I)I
    //   131: istore #6
    //   133: aload_0
    //   134: getfield g : Landroid/content/SharedPreferences;
    //   137: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   142: astore #14
    //   144: iload #5
    //   146: iload #6
    //   148: if_icmpeq -> 164
    //   151: aload #14
    //   153: ldc_w 'version_code'
    //   156: iload #6
    //   158: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   163: pop
    //   164: iload #9
    //   166: ifeq -> 203
    //   169: invokestatic currentTimeMillis : ()J
    //   172: lstore #12
    //   174: aload #14
    //   176: ldc_w 'register_time'
    //   179: lload #12
    //   181: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   186: pop
    //   187: aload_0
    //   188: ldc_w 'register_time'
    //   191: lload #12
    //   193: invokestatic valueOf : (J)Ljava/lang/Long;
    //   196: invokespecial b : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   199: pop
    //   200: goto -> 235
    //   203: iload #9
    //   205: ifne -> 235
    //   208: new org/json/JSONObject
    //   211: dup
    //   212: invokespecial <init> : ()V
    //   215: astore #15
    //   217: aload #15
    //   219: ldc_w 'response'
    //   222: aload_1
    //   223: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: ldc_w 'tt_fetch_did_error'
    //   230: aload #15
    //   232: invokestatic onEventV3 : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   235: aload_0
    //   236: invokespecial r : ()Lorg/json/JSONObject;
    //   239: ldc_w 'device_id'
    //   242: ldc_w ''
    //   245: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: astore_1
    //   249: iload #9
    //   251: ifeq -> 453
    //   254: aload_0
    //   255: ldc_w 'device_id'
    //   258: aload_2
    //   259: invokespecial b : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   262: ifeq -> 453
    //   265: aload #14
    //   267: ldc_w 'device_id'
    //   270: aload_2
    //   271: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   276: pop
    //   277: iconst_1
    //   278: istore #7
    //   280: goto -> 283
    //   283: aload_0
    //   284: invokespecial r : ()Lorg/json/JSONObject;
    //   287: ldc_w 'install_id'
    //   290: ldc_w ''
    //   293: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: astore #15
    //   298: iload #7
    //   300: istore #8
    //   302: iload #10
    //   304: ifeq -> 337
    //   307: iload #7
    //   309: istore #8
    //   311: aload_0
    //   312: ldc_w 'install_id'
    //   315: aload_3
    //   316: invokespecial b : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   319: ifeq -> 337
    //   322: aload #14
    //   324: ldc_w 'install_id'
    //   327: aload_3
    //   328: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   333: pop
    //   334: iconst_1
    //   335: istore #8
    //   337: aload_0
    //   338: invokespecial r : ()Lorg/json/JSONObject;
    //   341: ldc_w 'ssid'
    //   344: ldc_w ''
    //   347: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   350: astore #16
    //   352: iload #11
    //   354: ifeq -> 459
    //   357: aload_0
    //   358: ldc_w 'ssid'
    //   361: aload #4
    //   363: invokespecial b : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   366: ifeq -> 459
    //   369: aload #14
    //   371: ldc_w 'ssid'
    //   374: aload #4
    //   376: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   381: pop
    //   382: iconst_1
    //   383: istore #7
    //   385: goto -> 388
    //   388: invokestatic getDataObserver : ()Lcom/bytedance/embedapplog/IDataObserver;
    //   391: iload #7
    //   393: aload_1
    //   394: aload_2
    //   395: aload #15
    //   397: aload_3
    //   398: aload #16
    //   400: aload #4
    //   402: invokeinterface onRemoteIdGet : (ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload #14
    //   409: invokeinterface apply : ()V
    //   414: goto -> 426
    //   417: astore_1
    //   418: goto -> 422
    //   421: astore_1
    //   422: aload_1
    //   423: invokestatic a : (Ljava/lang/Throwable;)V
    //   426: iconst_0
    //   427: istore #8
    //   429: iload #8
    //   431: istore #7
    //   433: iload #9
    //   435: ifeq -> 450
    //   438: iload #8
    //   440: istore #7
    //   442: iload #10
    //   444: ifeq -> 450
    //   447: iconst_1
    //   448: istore #7
    //   450: iload #7
    //   452: ireturn
    //   453: iconst_0
    //   454: istore #7
    //   456: goto -> 283
    //   459: iload #8
    //   461: istore #7
    //   463: goto -> 388
    // Exception table:
    //   from	to	target	type
    //   98	144	421	org/json/JSONException
    //   151	164	421	org/json/JSONException
    //   169	200	421	org/json/JSONException
    //   208	235	421	org/json/JSONException
    //   235	249	421	org/json/JSONException
    //   254	277	421	org/json/JSONException
    //   283	298	421	org/json/JSONException
    //   311	334	421	org/json/JSONException
    //   337	352	421	org/json/JSONException
    //   357	382	417	org/json/JSONException
    //   388	414	417	org/json/JSONException
  }
  
  public JSONObject b() {
    JSONObject jSONObject = a();
    if (jSONObject != null)
      try {
        String str = b.a(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(str)) {
          JSONObject jSONObject1 = new JSONObject();
          com.bytedance.embedapplog.util.i.b(jSONObject1, jSONObject);
          jSONObject1.put("oaid", str);
          return jSONObject1;
        } 
      } catch (Exception exception) {
        h.a(exception);
      }  
    return jSONObject;
  }
  
  public void b(String paramString) {
    if (b("user_agent", paramString))
      this.c.d(paramString); 
  }
  
  public int c() {
    int j;
    if (this.a) {
      j = r().optInt("version_code", -1);
    } else {
      j = -1;
    } 
    for (int k = 0; k < 3 && j == -1; k++) {
      e();
      if (this.a) {
        j = r().optInt("version_code", -1);
      } else {
        j = -1;
      } 
    } 
    return j;
  }
  
  public void c(String paramString) {
    if (b("user_unique_id", paramString))
      this.c.b(paramString); 
  }
  
  public String d() {
    String str;
    if (this.a) {
      str = r().optString("app_version", null);
    } else {
      str = null;
    } 
    for (int j = 0; j < 3 && str == null; j++) {
      e();
      if (this.a) {
        str = r().optString("app_version", null);
      } else {
        str = null;
      } 
    } 
    return str;
  }
  
  public boolean e() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Ljava/util/ArrayList;
    //   4: astore #9
    //   6: aload #9
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield e : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifne -> 362
    //   19: aload_0
    //   20: getfield e : Ljava/util/ArrayList;
    //   23: new com/bytedance/embedapplog/b/d
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: invokevirtual add : (Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_0
    //   35: getfield e : Ljava/util/ArrayList;
    //   38: new com/bytedance/embedapplog/b/f
    //   41: dup
    //   42: aload_0
    //   43: getfield b : Landroid/content/Context;
    //   46: invokespecial <init> : (Landroid/content/Context;)V
    //   49: invokevirtual add : (Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield e : Ljava/util/ArrayList;
    //   57: new com/bytedance/embedapplog/b/g
    //   60: dup
    //   61: aload_0
    //   62: getfield b : Landroid/content/Context;
    //   65: aload_0
    //   66: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   69: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   72: invokevirtual add : (Ljava/lang/Object;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield e : Ljava/util/ArrayList;
    //   80: new com/bytedance/embedapplog/b/j
    //   83: dup
    //   84: aload_0
    //   85: getfield b : Landroid/content/Context;
    //   88: invokespecial <init> : (Landroid/content/Context;)V
    //   91: invokevirtual add : (Ljava/lang/Object;)Z
    //   94: pop
    //   95: aload_0
    //   96: getfield e : Ljava/util/ArrayList;
    //   99: new com/bytedance/embedapplog/b/k
    //   102: dup
    //   103: aload_0
    //   104: getfield b : Landroid/content/Context;
    //   107: invokespecial <init> : (Landroid/content/Context;)V
    //   110: invokevirtual add : (Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload_0
    //   115: getfield e : Ljava/util/ArrayList;
    //   118: new com/bytedance/embedapplog/b/l
    //   121: dup
    //   122: aload_0
    //   123: getfield b : Landroid/content/Context;
    //   126: aload_0
    //   127: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   130: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   133: invokevirtual add : (Ljava/lang/Object;)Z
    //   136: pop
    //   137: aload_0
    //   138: getfield e : Ljava/util/ArrayList;
    //   141: new com/bytedance/embedapplog/b/m
    //   144: dup
    //   145: aload_0
    //   146: getfield b : Landroid/content/Context;
    //   149: invokespecial <init> : (Landroid/content/Context;)V
    //   152: invokevirtual add : (Ljava/lang/Object;)Z
    //   155: pop
    //   156: aload_0
    //   157: getfield e : Ljava/util/ArrayList;
    //   160: new com/bytedance/embedapplog/b/o
    //   163: dup
    //   164: aload_0
    //   165: getfield b : Landroid/content/Context;
    //   168: invokespecial <init> : (Landroid/content/Context;)V
    //   171: invokevirtual add : (Ljava/lang/Object;)Z
    //   174: pop
    //   175: aload_0
    //   176: getfield e : Ljava/util/ArrayList;
    //   179: new com/bytedance/embedapplog/b/p
    //   182: dup
    //   183: aload_0
    //   184: getfield b : Landroid/content/Context;
    //   187: aload_0
    //   188: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   191: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   194: invokevirtual add : (Ljava/lang/Object;)Z
    //   197: pop
    //   198: aload_0
    //   199: getfield e : Ljava/util/ArrayList;
    //   202: new com/bytedance/embedapplog/b/q
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: invokevirtual add : (Ljava/lang/Object;)Z
    //   212: pop
    //   213: aload_0
    //   214: getfield e : Ljava/util/ArrayList;
    //   217: new com/bytedance/embedapplog/b/r
    //   220: dup
    //   221: aload_0
    //   222: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   225: invokespecial <init> : (Lcom/bytedance/embedapplog/b/h;)V
    //   228: invokevirtual add : (Ljava/lang/Object;)Z
    //   231: pop
    //   232: aload_0
    //   233: getfield e : Ljava/util/ArrayList;
    //   236: new com/bytedance/embedapplog/b/s
    //   239: dup
    //   240: aload_0
    //   241: getfield b : Landroid/content/Context;
    //   244: invokespecial <init> : (Landroid/content/Context;)V
    //   247: invokevirtual add : (Ljava/lang/Object;)Z
    //   250: pop
    //   251: aload_0
    //   252: getfield e : Ljava/util/ArrayList;
    //   255: new com/bytedance/embedapplog/b/t
    //   258: dup
    //   259: aload_0
    //   260: getfield b : Landroid/content/Context;
    //   263: invokespecial <init> : (Landroid/content/Context;)V
    //   266: invokevirtual add : (Ljava/lang/Object;)Z
    //   269: pop
    //   270: aload_0
    //   271: getfield e : Ljava/util/ArrayList;
    //   274: new com/bytedance/embedapplog/b/u
    //   277: dup
    //   278: aload_0
    //   279: getfield b : Landroid/content/Context;
    //   282: aload_0
    //   283: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   286: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   289: invokevirtual add : (Ljava/lang/Object;)Z
    //   292: pop
    //   293: aload_0
    //   294: getfield e : Ljava/util/ArrayList;
    //   297: new com/bytedance/embedapplog/b/a
    //   300: dup
    //   301: aload_0
    //   302: getfield b : Landroid/content/Context;
    //   305: aload_0
    //   306: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   309: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   312: invokevirtual add : (Ljava/lang/Object;)Z
    //   315: pop
    //   316: aload_0
    //   317: getfield e : Ljava/util/ArrayList;
    //   320: new com/bytedance/embedapplog/b/n
    //   323: dup
    //   324: aload_0
    //   325: getfield b : Landroid/content/Context;
    //   328: aload_0
    //   329: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   332: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   335: invokevirtual add : (Ljava/lang/Object;)Z
    //   338: pop
    //   339: aload_0
    //   340: getfield e : Ljava/util/ArrayList;
    //   343: new com/bytedance/embedapplog/b/e
    //   346: dup
    //   347: aload_0
    //   348: getfield b : Landroid/content/Context;
    //   351: aload_0
    //   352: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   355: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/embedapplog/b/h;)V
    //   358: invokevirtual add : (Ljava/lang/Object;)Z
    //   361: pop
    //   362: aload #9
    //   364: monitorexit
    //   365: aload_0
    //   366: invokespecial r : ()Lorg/json/JSONObject;
    //   369: astore #10
    //   371: new org/json/JSONObject
    //   374: dup
    //   375: invokespecial <init> : ()V
    //   378: astore #9
    //   380: aload #9
    //   382: aload #10
    //   384: invokestatic b : (Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   387: pop
    //   388: aload_0
    //   389: getfield e : Ljava/util/ArrayList;
    //   392: invokevirtual iterator : ()Ljava/util/Iterator;
    //   395: astore #10
    //   397: iconst_0
    //   398: istore #6
    //   400: iconst_1
    //   401: istore #7
    //   403: iconst_0
    //   404: istore_1
    //   405: iconst_0
    //   406: istore_3
    //   407: aload #10
    //   409: invokeinterface hasNext : ()Z
    //   414: ifeq -> 649
    //   417: aload #10
    //   419: invokeinterface next : ()Ljava/lang/Object;
    //   424: checkcast com/bytedance/embedapplog/b/c
    //   427: astore #11
    //   429: aload #11
    //   431: getfield a : Z
    //   434: ifeq -> 460
    //   437: aload #11
    //   439: getfield c : Z
    //   442: ifne -> 460
    //   445: iload_1
    //   446: istore #4
    //   448: iload_3
    //   449: istore #5
    //   451: aload_0
    //   452: aload #11
    //   454: invokespecial a : (Lcom/bytedance/embedapplog/b/c;)Z
    //   457: ifeq -> 608
    //   460: aload #11
    //   462: aload #11
    //   464: aload #9
    //   466: invokevirtual a : (Lorg/json/JSONObject;)Z
    //   469: putfield a : Z
    //   472: iload_1
    //   473: istore_2
    //   474: goto -> 572
    //   477: astore #12
    //   479: iload_1
    //   480: istore_2
    //   481: aload #11
    //   483: getfield b : Z
    //   486: ifne -> 572
    //   489: iload_1
    //   490: iconst_1
    //   491: iadd
    //   492: istore_1
    //   493: new java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial <init> : ()V
    //   500: astore #13
    //   502: aload #13
    //   504: ldc_w 'loadHeader, '
    //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload #13
    //   513: aload_0
    //   514: getfield h : I
    //   517: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload #13
    //   523: invokevirtual toString : ()Ljava/lang/String;
    //   526: aload #12
    //   528: invokestatic b : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   531: iload_1
    //   532: istore_2
    //   533: aload #11
    //   535: getfield a : Z
    //   538: ifne -> 572
    //   541: iload_1
    //   542: istore_2
    //   543: aload_0
    //   544: getfield h : I
    //   547: bipush #10
    //   549: if_icmple -> 572
    //   552: aload #11
    //   554: iconst_1
    //   555: putfield a : Z
    //   558: iload_1
    //   559: istore_2
    //   560: goto -> 572
    //   563: astore #12
    //   565: aload #12
    //   567: invokestatic a : (Ljava/lang/Throwable;)V
    //   570: iload_1
    //   571: istore_2
    //   572: iload_2
    //   573: istore #4
    //   575: iload_3
    //   576: istore #5
    //   578: aload #11
    //   580: getfield a : Z
    //   583: ifne -> 608
    //   586: iload_2
    //   587: istore #4
    //   589: iload_3
    //   590: istore #5
    //   592: aload #11
    //   594: getfield b : Z
    //   597: ifne -> 608
    //   600: iload_3
    //   601: iconst_1
    //   602: iadd
    //   603: istore #5
    //   605: iload_2
    //   606: istore #4
    //   608: aload #11
    //   610: getfield a : Z
    //   613: ifne -> 632
    //   616: aload #11
    //   618: getfield b : Z
    //   621: ifeq -> 627
    //   624: goto -> 632
    //   627: iconst_0
    //   628: istore_1
    //   629: goto -> 634
    //   632: iconst_1
    //   633: istore_1
    //   634: iload #7
    //   636: iload_1
    //   637: iand
    //   638: istore #7
    //   640: iload #4
    //   642: istore_1
    //   643: iload #5
    //   645: istore_3
    //   646: goto -> 407
    //   649: iload #7
    //   651: istore #8
    //   653: iload #7
    //   655: ifeq -> 744
    //   658: getstatic com/bytedance/embedapplog/b/i.f : [Ljava/lang/String;
    //   661: astore #10
    //   663: aload #10
    //   665: arraylength
    //   666: istore #4
    //   668: iload #6
    //   670: istore_2
    //   671: iload_2
    //   672: iload #4
    //   674: if_icmpge -> 703
    //   677: iload #7
    //   679: aload #9
    //   681: aload #10
    //   683: iload_2
    //   684: aaload
    //   685: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   688: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   691: iconst_1
    //   692: ixor
    //   693: iand
    //   694: istore #7
    //   696: iload_2
    //   697: iconst_1
    //   698: iadd
    //   699: istore_2
    //   700: goto -> 671
    //   703: aload #9
    //   705: ldc_w 'user_unique_id'
    //   708: aconst_null
    //   709: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   712: astore #10
    //   714: iload #7
    //   716: istore #8
    //   718: aload #10
    //   720: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   723: ifne -> 744
    //   726: aload #9
    //   728: ldc_w 'user_unique_id'
    //   731: aload #10
    //   733: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   736: pop
    //   737: iload #7
    //   739: istore #8
    //   741: goto -> 744
    //   744: aload_0
    //   745: aload #9
    //   747: putfield d : Lorg/json/JSONObject;
    //   750: aload_0
    //   751: iload #8
    //   753: putfield a : Z
    //   756: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   759: ifeq -> 841
    //   762: new java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial <init> : ()V
    //   769: astore #9
    //   771: aload #9
    //   773: ldc_w 'loadHeader, '
    //   776: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload #9
    //   782: aload_0
    //   783: getfield a : Z
    //   786: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload #9
    //   792: ldc ', '
    //   794: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload #9
    //   800: aload_0
    //   801: getfield h : I
    //   804: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload #9
    //   810: ldc ', '
    //   812: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload #9
    //   818: aload_0
    //   819: getfield d : Lorg/json/JSONObject;
    //   822: invokevirtual toString : ()Ljava/lang/String;
    //   825: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload #9
    //   831: invokevirtual toString : ()Ljava/lang/String;
    //   834: aconst_null
    //   835: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   838: goto -> 896
    //   841: new java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial <init> : ()V
    //   848: astore #9
    //   850: aload #9
    //   852: ldc_w 'loadHeader, '
    //   855: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload #9
    //   861: aload_0
    //   862: getfield a : Z
    //   865: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload #9
    //   871: ldc ', '
    //   873: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload #9
    //   879: aload_0
    //   880: getfield h : I
    //   883: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload #9
    //   889: invokevirtual toString : ()Ljava/lang/String;
    //   892: aconst_null
    //   893: invokestatic d : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   896: iload_1
    //   897: ifle -> 933
    //   900: iload_1
    //   901: iload_3
    //   902: if_icmpne -> 933
    //   905: aload_0
    //   906: aload_0
    //   907: getfield h : I
    //   910: iconst_1
    //   911: iadd
    //   912: putfield h : I
    //   915: aload_0
    //   916: invokevirtual o : ()I
    //   919: ifeq -> 933
    //   922: aload_0
    //   923: aload_0
    //   924: getfield h : I
    //   927: bipush #10
    //   929: iadd
    //   930: putfield h : I
    //   933: aload_0
    //   934: getfield a : Z
    //   937: ifeq -> 960
    //   940: invokestatic getDataObserver : ()Lcom/bytedance/embedapplog/IDataObserver;
    //   943: aload_0
    //   944: invokevirtual g : ()Ljava/lang/String;
    //   947: aload_0
    //   948: invokevirtual j : ()Ljava/lang/String;
    //   951: aload_0
    //   952: invokevirtual k : ()Ljava/lang/String;
    //   955: invokeinterface onIdLoaded : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   960: aload_0
    //   961: getfield a : Z
    //   964: ireturn
    //   965: astore #10
    //   967: aload #9
    //   969: monitorexit
    //   970: aload #10
    //   972: athrow
    //   973: astore #10
    //   975: iload #7
    //   977: istore #8
    //   979: goto -> 744
    // Exception table:
    //   from	to	target	type
    //   9	362	965	finally
    //   362	365	965	finally
    //   460	472	563	org/json/JSONException
    //   460	472	477	java/lang/SecurityException
    //   726	737	973	org/json/JSONException
    //   967	970	965	finally
  }
  
  public String f() {
    return r().optString("user_unique_id", "");
  }
  
  public void f(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial r : ()Lorg/json/JSONObject;
    //   6: ldc 'ab_version'
    //   8: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   11: astore #4
    //   13: aload #4
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifeq -> 24
    //   21: goto -> 152
    //   24: aload #4
    //   26: ldc ','
    //   28: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   31: astore #5
    //   33: aload #5
    //   35: arraylength
    //   36: istore_3
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: iload_3
    //   41: if_icmpge -> 114
    //   44: aload #5
    //   46: iload_2
    //   47: aaload
    //   48: astore #6
    //   50: aload #6
    //   52: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   55: ifne -> 107
    //   58: aload #6
    //   60: aload_1
    //   61: invokevirtual equals : (Ljava/lang/Object;)Z
    //   64: ifeq -> 107
    //   67: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   70: ifeq -> 104
    //   73: new java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial <init> : ()V
    //   80: astore_1
    //   81: aload_1
    //   82: ldc_w 'addExposedVid ready added '
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: aload #4
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: aconst_null
    //   101: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: iload_2
    //   108: iconst_1
    //   109: iadd
    //   110: istore_2
    //   111: goto -> 39
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore #5
    //   123: aload #5
    //   125: aload #4
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #5
    //   133: ldc ','
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload #5
    //   141: aload_1
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload #5
    //   148: invokevirtual toString : ()Ljava/lang/String;
    //   151: astore_1
    //   152: aload_0
    //   153: ldc 'ab_version'
    //   155: aload_1
    //   156: invokespecial b : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   159: pop
    //   160: aload_0
    //   161: getfield c : Lcom/bytedance/embedapplog/b/h;
    //   164: aload_1
    //   165: invokevirtual e : (Ljava/lang/String;)V
    //   168: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   171: ifeq -> 208
    //   174: new java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: astore #4
    //   183: aload #4
    //   185: ldc_w 'addExposedVid '
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #4
    //   194: aload_1
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload #4
    //   201: invokevirtual toString : ()Ljava/lang/String;
    //   204: aconst_null
    //   205: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_0
    //   209: monitorexit
    //   210: return
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	211	finally
    //   24	37	211	finally
    //   50	104	211	finally
    //   114	152	211	finally
    //   152	208	211	finally
  }
  
  public String g() {
    return r().optString("device_id", "");
  }
  
  public String h() {
    return r().optString("aid", "");
  }
  
  public String i() {
    return r().optString("udid", "");
  }
  
  public String j() {
    return r().optString("install_id", "");
  }
  
  public String k() {
    return r().optString("ssid", "");
  }
  
  public String l() {
    return r().optString("user_unique_id", "");
  }
  
  public String m() {
    return r().optString("clientudid", "");
  }
  
  public String n() {
    return r().optString("openudid", "");
  }
  
  public int o() {
    String str = r().optString("device_id", "");
    r().optString("install_id", "");
    return e(str) ? ((this.g.getInt("version_code", 0) == r().optInt("version_code", -1)) ? 1 : 2) : 0;
  }
  
  public long p() {
    return r().optLong("register_time", 0L);
  }
  
  public String q() {
    return r().optString("ab_sdk_version", "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
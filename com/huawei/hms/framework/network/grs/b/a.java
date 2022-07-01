package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.d.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.c;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {
  protected com.huawei.hms.framework.network.grs.local.model.a a;
  
  protected List<b> b;
  
  protected Map<String, String> c = new ConcurrentHashMap<String, String>(16);
  
  protected boolean d = false;
  
  protected Set<String> e = new HashSet<String>(16);
  
  private int a(Context paramContext) {
    AssetManager assetManager = paramContext.getAssets();
    byte b = -1;
    try {
      String[] arrayOfString = assetManager.list("");
      int i = b;
      if (arrayOfString != null) {
        i = b;
        if (arrayOfString.length > 0) {
          int j = arrayOfString.length;
          i = 0;
          b = -1;
          while (true) {
            if (i < j) {
              String str = arrayOfString[i];
              byte b1 = b;
              try {
                if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                  int k = g(c.a(str, paramContext));
                  b1 = b;
                  if (k == 0) {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE sucess.");
                    b1 = 0;
                  } 
                } 
                i++;
                b = b1;
                continue;
              } catch (IOException iOException) {}
            } else {
              return b;
            } 
            Logger.w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
            return b;
          } 
        } 
      } 
      return i;
    } catch (IOException iOException) {}
    Logger.w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
    return b;
  }
  
  private int a(String paramString, Context paramContext) {
    if (f(c.a(paramString, paramContext)) == 0) {
      Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success.");
      return 0;
    } 
    return -1;
  }
  
  private Map<String, String> a(List<b> paramList, GrsBaseInfo paramGrsBaseInfo) {
    ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>(16);
    concurrentHashMap.put("no_route_country", "no-country");
    for (b b : paramList) {
      if (b.a().contains(paramGrsBaseInfo.getIssueCountry()))
        concurrentHashMap.put(paramGrsBaseInfo.getIssueCountry(), b.b()); 
      if (b.a().contains(paramGrsBaseInfo.getRegCountry()))
        concurrentHashMap.put(paramGrsBaseInfo.getRegCountry(), b.b()); 
      if (b.a().contains(paramGrsBaseInfo.getSerCountry()))
        concurrentHashMap.put(paramGrsBaseInfo.getSerCountry(), b.b()); 
    } 
    return (Map)concurrentHashMap;
  }
  
  private int f(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return -1; 
    int i = b(paramString);
    if (i != 0)
      return i; 
    i = a(paramString);
    return (i != 0) ? i : e(paramString);
  }
  
  private int g(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return -1; 
    List<b> list = this.b;
    if (list == null || list.isEmpty()) {
      int i = c(paramString);
      if (i != 0)
        return i; 
    } 
    return d(paramString);
  }
  
  public abstract int a(String paramString);
  
  int a(String paramString, Context paramContext, boolean paramBoolean) {
    if (a(paramString, paramContext) != 0 && paramBoolean)
      return -1; 
    a(paramContext);
    return 0;
  }
  
  public com.huawei.hms.framework.network.grs.local.model.a a() {
    return this.a;
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2) {
    Map<String, String> map = a(paramGrsBaseInfo, paramString1);
    if (map == null) {
      Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", new Object[] { paramString1 });
      return null;
    } 
    return map.get(paramString2);
  }
  
  public abstract List<b> a(JSONArray paramJSONArray, JSONObject paramJSONObject);
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString) {
    Map<String, String> map;
    if (!this.d)
      return null; 
    com.huawei.hms.framework.network.grs.local.model.a a1 = this.a;
    if (a1 == null) {
      Logger.w("AbstractLocalManager", "application data is null.");
      return null;
    } 
    c c = a1.a(paramString);
    if (c == null) {
      Logger.w("AbstractLocalManager", "service not found in local config{%s}", new Object[] { paramString });
      return null;
    } 
    paramString = f.a(c.c(), paramGrsBaseInfo);
    if (paramString == null) {
      Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", new Object[] { c.c() });
      return null;
    } 
    List<b> list = c.a();
    if (list != null && list.size() != 0) {
      map = a(list, paramGrsBaseInfo);
    } else {
      map = this.c;
    } 
    d d = c.a(map.get(paramString));
    return (d == null) ? null : d.a();
  }
  
  protected void a(JSONArray paramJSONArray) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 411
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifne -> 12
    //   11: return
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: aload_1
    //   16: invokevirtual length : ()I
    //   19: if_icmpge -> 411
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   27: astore #9
    //   29: new com/huawei/hms/framework/network/grs/local/model/c
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #7
    //   38: aload #9
    //   40: ldc 'name'
    //   42: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   45: astore #8
    //   47: aload #7
    //   49: aload #8
    //   51: invokevirtual b : (Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield e : Ljava/util/Set;
    //   58: aload #8
    //   60: invokeinterface contains : (Ljava/lang/Object;)Z
    //   65: ifne -> 404
    //   68: aload_0
    //   69: getfield e : Ljava/util/Set;
    //   72: aload #8
    //   74: invokeinterface add : (Ljava/lang/Object;)Z
    //   79: pop
    //   80: aload #7
    //   82: aload #9
    //   84: ldc 'routeBy'
    //   86: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   89: invokevirtual c : (Ljava/lang/String;)V
    //   92: aload #9
    //   94: ldc_w 'servings'
    //   97: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   100: astore #6
    //   102: iconst_0
    //   103: istore_3
    //   104: iload_3
    //   105: aload #6
    //   107: invokevirtual length : ()I
    //   110: if_icmpge -> 293
    //   113: aload #6
    //   115: iload_3
    //   116: invokevirtual get : (I)Ljava/lang/Object;
    //   119: checkcast org/json/JSONObject
    //   122: astore #11
    //   124: new com/huawei/hms/framework/network/grs/local/model/d
    //   127: dup
    //   128: invokespecial <init> : ()V
    //   131: astore #10
    //   133: ldc_w 'countryOrAreaGroup'
    //   136: astore #5
    //   138: aload #11
    //   140: ldc_w 'countryOrAreaGroup'
    //   143: invokevirtual has : (Ljava/lang/String;)Z
    //   146: ifeq -> 161
    //   149: aload #11
    //   151: aload #5
    //   153: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   156: astore #5
    //   158: goto -> 192
    //   161: ldc_w 'countryGroup'
    //   164: astore #5
    //   166: aload #11
    //   168: ldc_w 'countryGroup'
    //   171: invokevirtual has : (Ljava/lang/String;)Z
    //   174: ifeq -> 180
    //   177: goto -> 149
    //   180: ldc 'AbstractLocalManager'
    //   182: ldc_w 'maybe this service routeBy is unconditional.'
    //   185: invokestatic v : (Ljava/lang/String;Ljava/lang/Object;)V
    //   188: ldc 'no-country'
    //   190: astore #5
    //   192: aload #10
    //   194: aload #5
    //   196: invokevirtual a : (Ljava/lang/String;)V
    //   199: aload #11
    //   201: ldc_w 'addresses'
    //   204: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   207: astore #5
    //   209: new java/util/HashMap
    //   212: dup
    //   213: bipush #16
    //   215: invokespecial <init> : (I)V
    //   218: astore #11
    //   220: aload #5
    //   222: invokevirtual keys : ()Ljava/util/Iterator;
    //   225: astore #12
    //   227: aload #12
    //   229: invokeinterface hasNext : ()Z
    //   234: ifeq -> 267
    //   237: aload #12
    //   239: invokeinterface next : ()Ljava/lang/Object;
    //   244: checkcast java/lang/String
    //   247: astore #13
    //   249: aload #11
    //   251: aload #13
    //   253: aload #5
    //   255: aload #13
    //   257: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   260: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: pop
    //   264: goto -> 227
    //   267: aload #10
    //   269: aload #11
    //   271: invokevirtual a : (Ljava/util/Map;)V
    //   274: aload #7
    //   276: aload #10
    //   278: invokevirtual b : ()Ljava/lang/String;
    //   281: aload #10
    //   283: invokevirtual a : (Ljava/lang/String;Lcom/huawei/hms/framework/network/grs/local/model/d;)V
    //   286: iload_3
    //   287: iconst_1
    //   288: iadd
    //   289: istore_3
    //   290: goto -> 104
    //   293: ldc_w 'countryOrAreaGroups'
    //   296: astore #6
    //   298: aload #9
    //   300: ldc_w 'countryOrAreaGroups'
    //   303: invokevirtual has : (Ljava/lang/String;)Z
    //   306: istore #4
    //   308: aconst_null
    //   309: astore #5
    //   311: iload #4
    //   313: ifeq -> 337
    //   316: aload #6
    //   318: astore #5
    //   320: aload_0
    //   321: aload #9
    //   323: aload #5
    //   325: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   328: aconst_null
    //   329: invokevirtual a : (Lorg/json/JSONArray;Lorg/json/JSONObject;)Ljava/util/List;
    //   332: astore #5
    //   334: goto -> 368
    //   337: ldc_w 'countryGroups'
    //   340: astore #6
    //   342: aload #9
    //   344: ldc_w 'countryGroups'
    //   347: invokevirtual has : (Ljava/lang/String;)Z
    //   350: ifeq -> 360
    //   353: aload #6
    //   355: astore #5
    //   357: goto -> 320
    //   360: ldc 'AbstractLocalManager'
    //   362: ldc_w 'service use default countryOrAreaGroup'
    //   365: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   368: aload #7
    //   370: aload #5
    //   372: invokevirtual a : (Ljava/util/List;)V
    //   375: aload_0
    //   376: getfield a : Lcom/huawei/hms/framework/network/grs/local/model/a;
    //   379: ifnonnull -> 393
    //   382: aload_0
    //   383: new com/huawei/hms/framework/network/grs/local/model/a
    //   386: dup
    //   387: invokespecial <init> : ()V
    //   390: putfield a : Lcom/huawei/hms/framework/network/grs/local/model/a;
    //   393: aload_0
    //   394: getfield a : Lcom/huawei/hms/framework/network/grs/local/model/a;
    //   397: aload #8
    //   399: aload #7
    //   401: invokevirtual a : (Ljava/lang/String;Lcom/huawei/hms/framework/network/grs/local/model/c;)V
    //   404: iload_2
    //   405: iconst_1
    //   406: iadd
    //   407: istore_2
    //   408: goto -> 14
    //   411: return
  }
  
  public boolean a(GrsBaseInfo paramGrsBaseInfo) {
    List<b> list = this.b;
    if (list == null || list.isEmpty())
      return false; 
    this.c.put("no_route_country", "no-country");
    for (b b : this.b) {
      if (b.a().contains(paramGrsBaseInfo.getIssueCountry()))
        this.c.put(paramGrsBaseInfo.getIssueCountry(), b.b()); 
      if (b.a().contains(paramGrsBaseInfo.getRegCountry()))
        this.c.put(paramGrsBaseInfo.getRegCountry(), b.b()); 
      if (b.a().contains(paramGrsBaseInfo.getSerCountry()))
        this.c.put(paramGrsBaseInfo.getSerCountry(), b.b()); 
    } 
    return true;
  }
  
  public abstract int b(String paramString);
  
  public boolean b() {
    return this.d;
  }
  
  public int c(String paramString) {
    // Byte code:
    //   0: ldc_w 'countryOrAreaGroups'
    //   3: astore #5
    //   5: aload_0
    //   6: new java/util/ArrayList
    //   9: dup
    //   10: bipush #16
    //   12: invokespecial <init> : (I)V
    //   15: putfield b : Ljava/util/List;
    //   18: new org/json/JSONObject
    //   21: dup
    //   22: aload_1
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: astore #6
    //   28: aload #6
    //   30: ldc_w 'countryOrAreaGroups'
    //   33: invokevirtual has : (Ljava/lang/String;)Z
    //   36: istore #4
    //   38: iload #4
    //   40: ifeq -> 49
    //   43: aload #5
    //   45: astore_1
    //   46: goto -> 64
    //   49: aload #6
    //   51: ldc_w 'countryGroups'
    //   54: invokevirtual has : (Ljava/lang/String;)Z
    //   57: ifeq -> 74
    //   60: ldc_w 'countryGroups'
    //   63: astore_1
    //   64: aload #6
    //   66: aload_1
    //   67: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore_1
    //   71: goto -> 321
    //   74: ldc 'AbstractLocalManager'
    //   76: ldc_w 'maybe local config json is wrong because the default countryOrAreaGroups isn't config.'
    //   79: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   82: aconst_null
    //   83: astore_1
    //   84: goto -> 321
    //   87: aload_1
    //   88: invokevirtual length : ()I
    //   91: ifeq -> 307
    //   94: iconst_0
    //   95: istore_2
    //   96: iload_2
    //   97: aload_1
    //   98: invokevirtual length : ()I
    //   101: if_icmpge -> 307
    //   104: aload_1
    //   105: iload_2
    //   106: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   109: astore #7
    //   111: new com/huawei/hms/framework/network/grs/local/model/b
    //   114: dup
    //   115: invokespecial <init> : ()V
    //   118: astore #6
    //   120: aload #6
    //   122: aload #7
    //   124: ldc_w 'id'
    //   127: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual b : (Ljava/lang/String;)V
    //   133: aload #6
    //   135: aload #7
    //   137: ldc 'name'
    //   139: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   142: invokevirtual c : (Ljava/lang/String;)V
    //   145: aload #6
    //   147: aload #7
    //   149: ldc_w 'description'
    //   152: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual a : (Ljava/lang/String;)V
    //   158: aload #7
    //   160: ldc_w 'countriesOrAreas'
    //   163: invokevirtual has : (Ljava/lang/String;)Z
    //   166: istore #4
    //   168: ldc_w 'countries'
    //   171: astore #5
    //   173: iload #4
    //   175: ifeq -> 186
    //   178: ldc_w 'countriesOrAreas'
    //   181: astore #5
    //   183: goto -> 197
    //   186: aload #7
    //   188: ldc_w 'countries'
    //   191: invokevirtual has : (Ljava/lang/String;)Z
    //   194: ifeq -> 209
    //   197: aload #7
    //   199: aload #5
    //   201: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore #5
    //   206: goto -> 220
    //   209: ldc 'AbstractLocalManager'
    //   211: ldc_w 'current country or area group has not config countries or areas.'
    //   214: invokestatic w : (Ljava/lang/String;Ljava/lang/Object;)V
    //   217: aconst_null
    //   218: astore #5
    //   220: new java/util/HashSet
    //   223: dup
    //   224: bipush #16
    //   226: invokespecial <init> : (I)V
    //   229: astore #7
    //   231: aload #5
    //   233: ifnull -> 305
    //   236: aload #5
    //   238: invokevirtual length : ()I
    //   241: ifne -> 327
    //   244: iconst_m1
    //   245: ireturn
    //   246: iload_3
    //   247: aload #5
    //   249: invokevirtual length : ()I
    //   252: if_icmpge -> 279
    //   255: aload #7
    //   257: aload #5
    //   259: iload_3
    //   260: invokevirtual get : (I)Ljava/lang/Object;
    //   263: checkcast java/lang/String
    //   266: invokeinterface add : (Ljava/lang/Object;)Z
    //   271: pop
    //   272: iload_3
    //   273: iconst_1
    //   274: iadd
    //   275: istore_3
    //   276: goto -> 246
    //   279: aload #6
    //   281: aload #7
    //   283: invokevirtual a : (Ljava/util/Set;)V
    //   286: aload_0
    //   287: getfield b : Ljava/util/List;
    //   290: aload #6
    //   292: invokeinterface add : (Ljava/lang/Object;)Z
    //   297: pop
    //   298: iload_2
    //   299: iconst_1
    //   300: iadd
    //   301: istore_2
    //   302: goto -> 96
    //   305: iconst_m1
    //   306: ireturn
    //   307: iconst_0
    //   308: ireturn
    //   309: astore_1
    //   310: ldc 'AbstractLocalManager'
    //   312: ldc_w 'parse countrygroup failed maybe json style is wrong.'
    //   315: aload_1
    //   316: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   319: iconst_m1
    //   320: ireturn
    //   321: aload_1
    //   322: ifnonnull -> 87
    //   325: iconst_m1
    //   326: ireturn
    //   327: iconst_0
    //   328: istore_3
    //   329: goto -> 246
    // Exception table:
    //   from	to	target	type
    //   18	38	309	org/json/JSONException
    //   49	60	309	org/json/JSONException
    //   64	71	309	org/json/JSONException
    //   74	82	309	org/json/JSONException
    //   87	94	309	org/json/JSONException
    //   96	120	309	org/json/JSONException
    //   120	133	309	org/json/JSONException
    //   133	145	309	org/json/JSONException
    //   145	168	309	org/json/JSONException
    //   186	197	309	org/json/JSONException
    //   197	206	309	org/json/JSONException
    //   209	217	309	org/json/JSONException
    //   220	231	309	org/json/JSONException
    //   236	244	309	org/json/JSONException
    //   246	272	309	org/json/JSONException
    //   279	298	309	org/json/JSONException
  }
  
  public int d(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      a(jSONObject.getJSONArray("services"));
      return 0;
    } catch (JSONException jSONException) {
      Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check!", (Throwable)jSONException);
      return -1;
    } 
  }
  
  public abstract int e(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {
  public c(Context paramContext) {
    if (a("grs_sdk_global_route_config.json", paramContext, false) == 0)
      this.d = true; 
  }
  
  public int a(String paramString) {
    this.a = new a();
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      JSONObject jSONObject2 = jSONObject1.getJSONObject("application");
      String str = jSONObject2.getString("name");
      long l = jSONObject2.getLong("cacheControl");
      JSONArray jSONArray = jSONObject2.getJSONArray("services");
      this.a.b(str);
      this.a.a(l);
      if (jSONArray != null) {
        int i = jSONArray.length();
        return (i == 0) ? -1 : 0;
      } 
      return -1;
    } catch (JSONException jSONException) {
      Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", (Throwable)jSONException);
      return -1;
    } 
  }
  
  public List<b> a(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    if (paramJSONObject == null || paramJSONObject.length() == 0)
      return new ArrayList<b>(); 
    try {
      ArrayList<b> arrayList = new ArrayList(16);
      Iterator<String> iterator = paramJSONObject.keys();
      while (true) {
        if (iterator.hasNext()) {
          String str1 = iterator.next();
          b b = new b();
          b.b(str1);
          JSONObject jSONObject = paramJSONObject.getJSONObject(str1);
          b.c(jSONObject.getString("name"));
          b.a(jSONObject.getString("description"));
          str1 = null;
          boolean bool = jSONObject.has("countriesOrAreas");
          String str2 = "countries";
          if (bool) {
            str1 = "countriesOrAreas";
          } else if (jSONObject.has("countries")) {
            str1 = str2;
          } else {
            Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
            HashSet hashSet1 = new HashSet(16);
          } 
          JSONArray jSONArray = jSONObject.getJSONArray(str1);
        } else {
          return arrayList;
        } 
        HashSet hashSet = new HashSet(16);
      } 
    } catch (JSONException jSONException) {
      Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong.", (Throwable)jSONException);
      return new ArrayList<b>();
    } 
  }
  
  public int b(String paramString) {
    // Byte code:
    //   0: ldc 'countryOrAreaGroups'
    //   2: astore #4
    //   4: aload_0
    //   5: new java/util/ArrayList
    //   8: dup
    //   9: bipush #16
    //   11: invokespecial <init> : (I)V
    //   14: putfield b : Ljava/util/List;
    //   17: new org/json/JSONObject
    //   20: dup
    //   21: aload_1
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: astore #5
    //   27: aload #5
    //   29: ldc 'countryOrAreaGroups'
    //   31: invokevirtual has : (Ljava/lang/String;)Z
    //   34: istore_3
    //   35: iload_3
    //   36: ifeq -> 45
    //   39: aload #4
    //   41: astore_1
    //   42: goto -> 58
    //   45: aload #5
    //   47: ldc 'countryGroups'
    //   49: invokevirtual has : (Ljava/lang/String;)Z
    //   52: ifeq -> 68
    //   55: ldc 'countryGroups'
    //   57: astore_1
    //   58: aload #5
    //   60: aload_1
    //   61: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   64: astore_1
    //   65: goto -> 314
    //   68: ldc 'LocalManagerV1'
    //   70: ldc 'maybe local config json is wrong because the default countryOrAreaGroups isn't config.'
    //   72: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -> 314
    //   80: aload_1
    //   81: invokevirtual length : ()I
    //   84: ifeq -> 301
    //   87: aload_1
    //   88: invokevirtual keys : ()Ljava/util/Iterator;
    //   91: astore #5
    //   93: aload #5
    //   95: invokeinterface hasNext : ()Z
    //   100: ifeq -> 301
    //   103: aload #5
    //   105: invokeinterface next : ()Ljava/lang/Object;
    //   110: checkcast java/lang/String
    //   113: astore #4
    //   115: new com/huawei/hms/framework/network/grs/local/model/b
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: astore #6
    //   124: aload #6
    //   126: aload #4
    //   128: invokevirtual b : (Ljava/lang/String;)V
    //   131: aload_1
    //   132: aload #4
    //   134: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   137: astore #7
    //   139: aload #6
    //   141: aload #7
    //   143: ldc 'name'
    //   145: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   148: invokevirtual c : (Ljava/lang/String;)V
    //   151: aload #6
    //   153: aload #7
    //   155: ldc 'description'
    //   157: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   160: invokevirtual a : (Ljava/lang/String;)V
    //   163: aload #7
    //   165: ldc 'countriesOrAreas'
    //   167: invokevirtual has : (Ljava/lang/String;)Z
    //   170: istore_3
    //   171: ldc 'countries'
    //   173: astore #4
    //   175: iload_3
    //   176: ifeq -> 186
    //   179: ldc 'countriesOrAreas'
    //   181: astore #4
    //   183: goto -> 196
    //   186: aload #7
    //   188: ldc 'countries'
    //   190: invokevirtual has : (Ljava/lang/String;)Z
    //   193: ifeq -> 208
    //   196: aload #7
    //   198: aload #4
    //   200: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   203: astore #4
    //   205: goto -> 218
    //   208: ldc 'LocalManagerV1'
    //   210: ldc 'current country or area group has not config countries or areas.'
    //   212: invokestatic w : (Ljava/lang/String;Ljava/lang/Object;)V
    //   215: aconst_null
    //   216: astore #4
    //   218: new java/util/HashSet
    //   221: dup
    //   222: bipush #16
    //   224: invokespecial <init> : (I)V
    //   227: astore #7
    //   229: aload #4
    //   231: ifnull -> 299
    //   234: aload #4
    //   236: invokevirtual length : ()I
    //   239: ifne -> 320
    //   242: iconst_m1
    //   243: ireturn
    //   244: iload_2
    //   245: aload #4
    //   247: invokevirtual length : ()I
    //   250: if_icmpge -> 277
    //   253: aload #7
    //   255: aload #4
    //   257: iload_2
    //   258: invokevirtual get : (I)Ljava/lang/Object;
    //   261: checkcast java/lang/String
    //   264: invokeinterface add : (Ljava/lang/Object;)Z
    //   269: pop
    //   270: iload_2
    //   271: iconst_1
    //   272: iadd
    //   273: istore_2
    //   274: goto -> 244
    //   277: aload #6
    //   279: aload #7
    //   281: invokevirtual a : (Ljava/util/Set;)V
    //   284: aload_0
    //   285: getfield b : Ljava/util/List;
    //   288: aload #6
    //   290: invokeinterface add : (Ljava/lang/Object;)Z
    //   295: pop
    //   296: goto -> 93
    //   299: iconst_m1
    //   300: ireturn
    //   301: iconst_0
    //   302: ireturn
    //   303: astore_1
    //   304: ldc 'LocalManagerV1'
    //   306: ldc 'parse countrygroup failed maybe json style is wrong.'
    //   308: aload_1
    //   309: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   312: iconst_m1
    //   313: ireturn
    //   314: aload_1
    //   315: ifnonnull -> 80
    //   318: iconst_m1
    //   319: ireturn
    //   320: iconst_0
    //   321: istore_2
    //   322: goto -> 244
    // Exception table:
    //   from	to	target	type
    //   17	35	303	org/json/JSONException
    //   45	55	303	org/json/JSONException
    //   58	65	303	org/json/JSONException
    //   68	75	303	org/json/JSONException
    //   80	93	303	org/json/JSONException
    //   93	139	303	org/json/JSONException
    //   139	151	303	org/json/JSONException
    //   151	171	303	org/json/JSONException
    //   186	196	303	org/json/JSONException
    //   196	205	303	org/json/JSONException
    //   208	215	303	org/json/JSONException
    //   218	229	303	org/json/JSONException
    //   234	242	303	org/json/JSONException
    //   244	270	303	org/json/JSONException
    //   277	296	303	org/json/JSONException
  }
  
  public int e(String paramString) {
    String str = "countryOrAreaGroup";
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      JSONObject jSONObject2 = jSONObject1.getJSONObject("services");
      Iterator<String> iterator = jSONObject2.keys();
      String str1 = str;
      while (true) {
        List<b> list;
        com.huawei.hms.framework.network.grs.local.model.c c1;
        boolean bool = iterator.hasNext();
        int i = 0;
        if (bool) {
          String str2 = iterator.next();
          c1 = new com.huawei.hms.framework.network.grs.local.model.c();
          c1.b(str2);
          if (!this.e.contains(str2)) {
            JSONObject jSONObject3;
            this.e.add(str2);
            JSONObject jSONObject4 = jSONObject2.getJSONObject(str2);
            c1.c(jSONObject4.getString("routeBy"));
            JSONArray jSONArray = jSONObject4.getJSONArray("servings");
            while (true) {
              SYNTHETIC_LOCAL_VARIABLE_11.a((Map)SYNTHETIC_LOCAL_VARIABLE_12);
              c1.a(SYNTHETIC_LOCAL_VARIABLE_11.b(), (d)SYNTHETIC_LOCAL_VARIABLE_11);
              i++;
            } 
            bool = jSONObject4.has("countryOrAreaGroups");
            str = null;
            if (bool) {
              jSONObject3 = jSONObject4.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject4.has("countryGroups")) {
              jSONObject3 = jSONObject4.getJSONObject("countryGroups");
            } else {
              Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
              c1.a((List)jSONObject3);
            } 
            list = a(null, jSONObject3);
          } else {
            continue;
          } 
        } else {
          return 0;
        } 
        c1.a(list);
      } 
    } catch (JSONException jSONException) {
      Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check!", (Throwable)jSONException);
      return -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
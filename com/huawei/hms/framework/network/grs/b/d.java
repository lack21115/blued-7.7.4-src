package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
  public d(Context paramContext) {
    String str2 = GrsApp.getInstance().getAppConfigName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("appConfigName is");
    stringBuilder.append(str2);
    Logger.i("LocalManagerV2", stringBuilder.toString());
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "grs_app_global_route_config.json"; 
    if (a(str1, paramContext, true) == 0)
      this.d = true; 
  }
  
  public int a(String paramString) {
    this.a = new a();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      jSONObject = jSONObject.getJSONArray("applications").getJSONObject(0);
      String str = jSONObject.getString("name");
      this.a.b(str);
      JSONArray jSONArray = jSONObject.getJSONArray("services");
      if (jSONArray != null) {
        if (jSONArray.length() == 0)
          return -1; 
        if (jSONObject.has("customservices"))
          a(jSONObject.getJSONArray("customservices")); 
        return 0;
      } 
      return -1;
    } catch (JSONException jSONException) {
      Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", (Throwable)jSONException);
      return -1;
    } 
  }
  
  public List<b> a(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    if (paramJSONArray == null || paramJSONArray.length() == 0)
      return new ArrayList<b>(); 
    try {
      ArrayList<b> arrayList = new ArrayList(16);
      byte b = 0;
      while (true) {
        if (b < paramJSONArray.length()) {
          String str1;
          JSONObject jSONObject = paramJSONArray.getJSONObject(b);
          b b1 = new b();
          b1.b(jSONObject.getString("id"));
          b1.c(jSONObject.getString("name"));
          b1.a(jSONObject.getString("description"));
          paramJSONObject = null;
          boolean bool = jSONObject.has("countriesOrAreas");
          String str2 = "countries";
          if (bool) {
            str1 = "countriesOrAreas";
          } else if (jSONObject.has("countries")) {
            str1 = str2;
          } else {
            Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
            HashSet hashSet1 = new HashSet(16);
          } 
          JSONArray jSONArray = jSONObject.getJSONArray(str1);
        } else {
          return arrayList;
        } 
        HashSet hashSet = new HashSet(16);
      } 
    } catch (JSONException jSONException) {
      Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", (Throwable)jSONException);
      return new ArrayList<b>();
    } 
  }
  
  public int b(String paramString) {
    // Byte code:
    //   0: ldc 'countryOrAreaGroups'
    //   2: astore #5
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
    //   25: astore #6
    //   27: aload #6
    //   29: ldc 'countryOrAreaGroups'
    //   31: invokevirtual has : (Ljava/lang/String;)Z
    //   34: istore #4
    //   36: iload #4
    //   38: ifeq -> 47
    //   41: aload #5
    //   43: astore_1
    //   44: goto -> 60
    //   47: aload #6
    //   49: ldc 'countryGroups'
    //   51: invokevirtual has : (Ljava/lang/String;)Z
    //   54: ifeq -> 70
    //   57: ldc 'countryGroups'
    //   59: astore_1
    //   60: aload #6
    //   62: aload_1
    //   63: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   66: astore_1
    //   67: goto -> 308
    //   70: ldc 'LocalManagerV2'
    //   72: ldc 'maybe local config json is wrong because the default countryOrAreaGroups isn't config.'
    //   74: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -> 308
    //   82: aload_1
    //   83: invokevirtual length : ()I
    //   86: ifeq -> 295
    //   89: iconst_0
    //   90: istore_2
    //   91: iload_2
    //   92: aload_1
    //   93: invokevirtual length : ()I
    //   96: if_icmpge -> 295
    //   99: aload_1
    //   100: iload_2
    //   101: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   104: astore #7
    //   106: new com/huawei/hms/framework/network/grs/local/model/b
    //   109: dup
    //   110: invokespecial <init> : ()V
    //   113: astore #6
    //   115: aload #6
    //   117: aload #7
    //   119: ldc 'id'
    //   121: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   124: invokevirtual b : (Ljava/lang/String;)V
    //   127: aload #6
    //   129: aload #7
    //   131: ldc 'name'
    //   133: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   136: invokevirtual c : (Ljava/lang/String;)V
    //   139: aload #6
    //   141: aload #7
    //   143: ldc 'description'
    //   145: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   148: invokevirtual a : (Ljava/lang/String;)V
    //   151: aload #7
    //   153: ldc 'countriesOrAreas'
    //   155: invokevirtual has : (Ljava/lang/String;)Z
    //   158: istore #4
    //   160: ldc 'countries'
    //   162: astore #5
    //   164: iload #4
    //   166: ifeq -> 176
    //   169: ldc 'countriesOrAreas'
    //   171: astore #5
    //   173: goto -> 186
    //   176: aload #7
    //   178: ldc 'countries'
    //   180: invokevirtual has : (Ljava/lang/String;)Z
    //   183: ifeq -> 198
    //   186: aload #7
    //   188: aload #5
    //   190: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   193: astore #5
    //   195: goto -> 208
    //   198: ldc 'LocalManagerV2'
    //   200: ldc 'current country or area group has not config countries or areas.'
    //   202: invokestatic w : (Ljava/lang/String;Ljava/lang/Object;)V
    //   205: aconst_null
    //   206: astore #5
    //   208: new java/util/HashSet
    //   211: dup
    //   212: bipush #16
    //   214: invokespecial <init> : (I)V
    //   217: astore #7
    //   219: aload #5
    //   221: ifnull -> 293
    //   224: aload #5
    //   226: invokevirtual length : ()I
    //   229: ifne -> 314
    //   232: iconst_m1
    //   233: ireturn
    //   234: iload_3
    //   235: aload #5
    //   237: invokevirtual length : ()I
    //   240: if_icmpge -> 267
    //   243: aload #7
    //   245: aload #5
    //   247: iload_3
    //   248: invokevirtual get : (I)Ljava/lang/Object;
    //   251: checkcast java/lang/String
    //   254: invokeinterface add : (Ljava/lang/Object;)Z
    //   259: pop
    //   260: iload_3
    //   261: iconst_1
    //   262: iadd
    //   263: istore_3
    //   264: goto -> 234
    //   267: aload #6
    //   269: aload #7
    //   271: invokevirtual a : (Ljava/util/Set;)V
    //   274: aload_0
    //   275: getfield b : Ljava/util/List;
    //   278: aload #6
    //   280: invokeinterface add : (Ljava/lang/Object;)Z
    //   285: pop
    //   286: iload_2
    //   287: iconst_1
    //   288: iadd
    //   289: istore_2
    //   290: goto -> 91
    //   293: iconst_m1
    //   294: ireturn
    //   295: iconst_0
    //   296: ireturn
    //   297: astore_1
    //   298: ldc 'LocalManagerV2'
    //   300: ldc 'parse countrygroup failed maybe json style is wrong.'
    //   302: aload_1
    //   303: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: iconst_m1
    //   307: ireturn
    //   308: aload_1
    //   309: ifnonnull -> 82
    //   312: iconst_m1
    //   313: ireturn
    //   314: iconst_0
    //   315: istore_3
    //   316: goto -> 234
    // Exception table:
    //   from	to	target	type
    //   17	36	297	org/json/JSONException
    //   47	57	297	org/json/JSONException
    //   60	67	297	org/json/JSONException
    //   70	77	297	org/json/JSONException
    //   82	89	297	org/json/JSONException
    //   91	115	297	org/json/JSONException
    //   115	127	297	org/json/JSONException
    //   127	139	297	org/json/JSONException
    //   139	160	297	org/json/JSONException
    //   176	186	297	org/json/JSONException
    //   186	195	297	org/json/JSONException
    //   198	205	297	org/json/JSONException
    //   208	219	297	org/json/JSONException
    //   224	232	297	org/json/JSONException
    //   234	260	297	org/json/JSONException
    //   267	286	297	org/json/JSONException
  }
  
  public int e(String paramString) {
    return d(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
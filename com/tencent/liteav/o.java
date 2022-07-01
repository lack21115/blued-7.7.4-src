package com.tencent.liteav;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
  private static volatile o d;
  
  private Context a;
  
  private Map<String, List<b>> b = new HashMap<String, List<b>>();
  
  private Map<String, Long> c = new HashMap<String, Long>();
  
  private o(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    a();
  }
  
  public static o a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/tencent/liteav/o.d : Lcom/tencent/liteav/o;
    //   3: ifnonnull -> 38
    //   6: ldc com/tencent/liteav/o
    //   8: monitorenter
    //   9: getstatic com/tencent/liteav/o.d : Lcom/tencent/liteav/o;
    //   12: ifnonnull -> 26
    //   15: new com/tencent/liteav/o
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/tencent/liteav/o.d : Lcom/tencent/liteav/o;
    //   26: ldc com/tencent/liteav/o
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/tencent/liteav/o
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/tencent/liteav/o.d : Lcom/tencent/liteav/o;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private String a(List<b> paramList) {
    if (paramList == null)
      return ""; 
    JSONArray jSONArray = new JSONArray();
    int i = 0;
    for (b b : paramList) {
      JSONObject jSONObject = new JSONObject();
      if ("40302".equals(b.b)) {
        b = b;
        try {
          jSONObject.put("appid", ((a)b).a);
          jSONObject.put("eventid", ((a)b).b);
          jSONObject.put("40302", b.toString());
        } catch (JSONException jSONException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("controlDataListToString jsonObject.put：");
          stringBuilder.append(jSONException.toString());
          TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
          continue;
        } 
      } 
      try {
        jSONArray.put(i, jSONException);
      } catch (JSONException jSONException1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jsonArray.put： ");
        stringBuilder.append(jSONException1.toString());
        TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
      } 
      i++;
    } 
    return jSONArray.toString();
  }
  
  private void a() {
    SharedPreferences sharedPreferences = this.a.getSharedPreferences("vod_report_config", 0);
    if (sharedPreferences != null) {
      String str = sharedPreferences.getString("value", "");
      if (str.isEmpty())
        return; 
      try {
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
          List<b> list = h(jSONArray.optString(i));
          if (list != null && list.size() > 0) {
            String str1 = ((b)list.get(0)).a;
            this.b.put(str1, list);
          } 
        } 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(jSONException.toString());
        TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
      } 
    } 
  }
  
  private void a(String paramString, long paramLong) {
    this.c.put(paramString, Long.valueOf(paramLong));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SetReportExpireTime in mem appid= ");
    stringBuilder.append(paramString);
    stringBuilder.append(" , time=");
    stringBuilder.append(paramLong);
    TXCLog.i("TXCVodPlayReportControl", stringBuilder.toString());
  }
  
  private void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'controlInfos'
    //   3: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   6: astore #8
    //   8: aload_1
    //   9: ldc 'appId'
    //   11: invokevirtual optInt : (Ljava/lang/String;)I
    //   14: istore #4
    //   16: iload #4
    //   18: ifne -> 29
    //   21: ldc 'TXCVodPlayReportControl'
    //   23: ldc 'response appid is zero!'
    //   25: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   28: return
    //   29: aload #8
    //   31: ifnull -> 290
    //   34: aload #8
    //   36: invokevirtual length : ()I
    //   39: ifeq -> 290
    //   42: new java/util/ArrayList
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_1
    //   50: iconst_0
    //   51: istore_2
    //   52: iload_2
    //   53: aload #8
    //   55: invokevirtual length : ()I
    //   58: if_icmpge -> 211
    //   61: aload #8
    //   63: iload_2
    //   64: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   67: astore #9
    //   69: aload #9
    //   71: ifnonnull -> 77
    //   74: goto -> 204
    //   77: ldc '40302'
    //   79: aload #9
    //   81: ldc 'eventId'
    //   83: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   86: invokevirtual equals : (Ljava/lang/Object;)Z
    //   89: ifeq -> 204
    //   92: aload #9
    //   94: ldc 'expireTime'
    //   96: lconst_0
    //   97: invokevirtual optLong : (Ljava/lang/String;J)J
    //   100: lstore #5
    //   102: lload #5
    //   104: invokestatic currentTimeMillis : ()J
    //   107: ldc2_w 1000
    //   110: ldiv
    //   111: lcmp
    //   112: ifle -> 204
    //   115: aload #9
    //   117: ldc 'switch'
    //   119: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   122: astore #10
    //   124: aload #9
    //   126: ldc 'frequency'
    //   128: bipush #60
    //   130: invokevirtual optInt : (Ljava/lang/String;I)I
    //   133: istore_3
    //   134: iload_3
    //   135: bipush #60
    //   137: if_icmpge -> 146
    //   140: bipush #60
    //   142: istore_3
    //   143: goto -> 146
    //   146: ldc 'on'
    //   148: aload #10
    //   150: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   153: istore #7
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #9
    //   164: aload #9
    //   166: ldc ''
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #9
    //   174: iload #4
    //   176: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: new com/tencent/liteav/o$a
    //   184: dup
    //   185: iload_3
    //   186: iload #7
    //   188: lload #5
    //   190: aload #9
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: invokespecial <init> : (IZJLjava/lang/String;)V
    //   198: invokeinterface add : (Ljava/lang/Object;)Z
    //   203: pop
    //   204: iload_2
    //   205: iconst_1
    //   206: iadd
    //   207: istore_2
    //   208: goto -> 52
    //   211: aload_0
    //   212: monitorenter
    //   213: aload_1
    //   214: invokeinterface size : ()I
    //   219: ifeq -> 282
    //   222: aload_0
    //   223: getfield b : Ljava/util/Map;
    //   226: astore #8
    //   228: new java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial <init> : ()V
    //   235: astore #9
    //   237: aload #9
    //   239: ldc ''
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #9
    //   247: iload #4
    //   249: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #8
    //   255: aload #9
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: aload_1
    //   261: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload_0
    //   268: getfield c : Ljava/util/Map;
    //   271: iload #4
    //   273: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   276: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: aload_0
    //   283: monitorexit
    //   284: return
    //   285: astore_1
    //   286: aload_0
    //   287: monitorexit
    //   288: aload_1
    //   289: athrow
    //   290: return
    // Exception table:
    //   from	to	target	type
    //   213	282	285	finally
    //   282	284	285	finally
    //   286	288	285	finally
  }
  
  private void b() {
    Context context = this.a;
    int i = 0;
    SharedPreferences sharedPreferences = context.getSharedPreferences("vod_report_config", 0);
    if (sharedPreferences != null) {
      SharedPreferences.Editor editor = sharedPreferences.edit();
      if (editor != null && this.b.size() > 0) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, List<b>> entry : this.b.entrySet()) {
          try {
            jSONArray.put(i, a((List<b>)entry.getValue()));
          } catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(jSONException.toString());
            TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
          } 
          i++;
        } 
        editor.putString("value", jSONArray.toString());
        editor.apply();
      } 
    } 
  }
  
  private long d(String paramString) {
    if (paramString == null || paramString.isEmpty())
      return System.currentTimeMillis() / 1000L + 3600L; 
    if (this.c.containsKey(paramString))
      return ((Long)this.c.get(paramString)).longValue(); 
    List list = this.b.get(paramString);
    if (list != null)
      for (b b : list) {
        if ("40302".equals(b.b) && paramString.equalsIgnoreCase(b.a))
          return a.a((a)b); 
      }  
    return 0L;
  }
  
  private void e(String paramString) {
    StringBuilder stringBuilder;
    MalformedURLException malformedURLException2 = null;
    MalformedURLException malformedURLException4 = null;
    MalformedURLException malformedURLException3 = null;
    try {
      URL uRL = new URL(g(paramString));
    } catch (MalformedURLException malformedURLException1) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("URL :");
      stringBuilder.append(malformedURLException1.toString());
      TXCLog.i("TXCVodPlayReportControl", stringBuilder.toString());
      malformedURLException1 = null;
    } 
    if (malformedURLException1 == null)
      return; 
    try {
      HttpURLConnection httpURLConnection = (HttpURLConnection)malformedURLException1.openConnection();
    } catch (IOException iOException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("openConnection :");
      stringBuilder.append(iOException.toString());
      TXCLog.i("TXCVodPlayReportControl", stringBuilder.toString());
      stringBuilder = null;
    } 
    if (stringBuilder != null) {
      StringBuilder stringBuilder1;
      MalformedURLException malformedURLException;
      StringBuilder stringBuilder2;
      malformedURLException1 = malformedURLException2;
      try {
        stringBuilder.setConnectTimeout(8000);
        malformedURLException1 = malformedURLException2;
        stringBuilder.setReadTimeout(8000);
        malformedURLException1 = malformedURLException2;
        stringBuilder.setRequestProperty("Accept-Encoding", "identity");
        malformedURLException1 = malformedURLException2;
        stringBuilder.setInstanceFollowRedirects(true);
        malformedURLException1 = malformedURLException2;
        stringBuilder.connect();
        malformedURLException1 = malformedURLException2;
        int i = stringBuilder.getResponseCode();
        malformedURLException1 = malformedURLException2;
        StringBuilder stringBuilder3 = new StringBuilder();
        malformedURLException1 = malformedURLException2;
        stringBuilder3.append("request report control response code : ");
        malformedURLException1 = malformedURLException2;
        stringBuilder3.append(i);
        malformedURLException1 = malformedURLException2;
        TXCLog.i("TXCVodPlayReportControl", stringBuilder3.toString());
        malformedURLException1 = malformedURLException3;
        if (200 == i) {
          malformedURLException1 = malformedURLException2;
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stringBuilder.getInputStream()));
          try {
            stringBuilder1 = new StringBuilder();
            while (true) {
              String str = bufferedReader.readLine();
              if (str != null) {
                stringBuilder1.append(str);
                continue;
              } 
              f(stringBuilder1.toString());
              BufferedReader bufferedReader1 = bufferedReader;
              break;
            } 
          } catch (IOException iOException) {
          
          } finally {}
        } 
      } catch (IOException iOException) {
        malformedURLException2 = malformedURLException4;
        malformedURLException1 = malformedURLException2;
        StringBuilder stringBuilder3 = new StringBuilder();
        malformedURLException1 = malformedURLException2;
        stringBuilder3.append("connect or read: ");
        malformedURLException1 = malformedURLException2;
        stringBuilder3.append(iOException.toString());
        malformedURLException1 = malformedURLException2;
        TXCLog.i("TXCVodPlayReportControl", stringBuilder3.toString());
      } finally {
        malformedURLException3 = null;
        stringBuilder2 = stringBuilder1;
      } 
      malformedURLException.append("bufferedReader.close :");
      malformedURLException.append(stringBuilder2.toString());
      TXCLog.i("TXCVodPlayReportControl", malformedURLException.toString());
      return;
    } 
  }
  
  private void f(String paramString) {
    if (paramString == null || paramString.isEmpty()) {
      TXCLog.i("TXCVodPlayReportControl", "response msg is empty");
      return;
    } 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      int i = jSONObject.getInt("code");
      String str1 = jSONObject.optString("message");
      String str2 = jSONObject.optString("requestId");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("code = ");
      stringBuilder.append(i);
      stringBuilder.append(" ,message = ");
      stringBuilder.append(str1);
      stringBuilder.append(" , requestID= ");
      stringBuilder.append(str2);
      TXCLog.i("TXCVodPlayReportControl", stringBuilder.toString());
      if (i == 0 && jSONObject.getInt("version") == 1) {
        a(jSONObject);
        return;
      } 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("parseJson err: ");
      stringBuilder.append(jSONException.toString());
      TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
    } 
  }
  
  private String g(String paramString) {
    String str = TXCCommonUtil.getSDKVersionStr();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("https://vodreport.qcloud.com/describeControlInfos/v1/");
    stringBuilder2.append(paramString);
    stringBuilder2.append("?sdkVersion=");
    stringBuilder2.append(str);
    paramString = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("makeUrl: ");
    stringBuilder1.append(paramString);
    TXCLog.i("TXCVodPlayReportControl", stringBuilder1.toString());
    return paramString;
  }
  
  private List<b> h(String paramString) {
    ArrayList<a> arrayList = new ArrayList();
    try {
      JSONArray jSONArray = new JSONArray(paramString);
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          jSONObject.optString("appid", "");
          if (jSONObject.optString("eventid", "").equalsIgnoreCase("40302")) {
            String str = jSONObject.optString("40302", "");
            if (!str.isEmpty())
              arrayList.add(new a(str)); 
          } 
        } 
      } 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("controlDataListParseFormString :");
      stringBuilder.append(jSONException.toString());
      TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
    } 
    return (List)arrayList;
  }
  
  public int a(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 134
    //   4: aload_1
    //   5: invokevirtual isEmpty : ()Z
    //   8: ifeq -> 14
    //   11: bipush #60
    //   13: ireturn
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield b : Ljava/util/Map;
    //   20: aload_1
    //   21: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast java/util/List
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull -> 124
    //   34: aload_3
    //   35: invokeinterface iterator : ()Ljava/util/Iterator;
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface hasNext : ()Z
    //   47: ifeq -> 124
    //   50: aload_3
    //   51: invokeinterface next : ()Ljava/lang/Object;
    //   56: checkcast com/tencent/liteav/o$b
    //   59: astore #4
    //   61: ldc '40302'
    //   63: aload #4
    //   65: getfield b : Ljava/lang/String;
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 41
    //   74: aload_1
    //   75: aload #4
    //   77: getfield a : Ljava/lang/String;
    //   80: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   83: ifeq -> 41
    //   86: aload #4
    //   88: checkcast com/tencent/liteav/o$a
    //   91: astore #4
    //   93: aload #4
    //   95: ifnull -> 41
    //   98: aload #4
    //   100: invokestatic a : (Lcom/tencent/liteav/o$a;)J
    //   103: invokestatic currentTimeMillis : ()J
    //   106: ldc2_w 1000
    //   109: ldiv
    //   110: lcmp
    //   111: ifle -> 41
    //   114: aload #4
    //   116: invokestatic b : (Lcom/tencent/liteav/o$a;)I
    //   119: istore_2
    //   120: aload_0
    //   121: monitorexit
    //   122: iload_2
    //   123: ireturn
    //   124: aload_0
    //   125: monitorexit
    //   126: bipush #60
    //   128: ireturn
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: bipush #60
    //   136: ireturn
    // Exception table:
    //   from	to	target	type
    //   16	30	129	finally
    //   34	41	129	finally
    //   41	93	129	finally
    //   98	122	129	finally
    //   124	126	129	finally
    //   130	132	129	finally
  }
  
  public boolean b(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 132
    //   4: aload_1
    //   5: invokevirtual isEmpty : ()Z
    //   8: ifeq -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield b : Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast java/util/List
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 123
    //   33: aload_3
    //   34: invokeinterface iterator : ()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface hasNext : ()Z
    //   46: ifeq -> 123
    //   49: aload_3
    //   50: invokeinterface next : ()Ljava/lang/Object;
    //   55: checkcast com/tencent/liteav/o$b
    //   58: astore #4
    //   60: ldc '40302'
    //   62: aload #4
    //   64: getfield b : Ljava/lang/String;
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifeq -> 40
    //   73: aload_1
    //   74: aload #4
    //   76: getfield a : Ljava/lang/String;
    //   79: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   82: ifeq -> 40
    //   85: aload #4
    //   87: checkcast com/tencent/liteav/o$a
    //   90: astore #4
    //   92: aload #4
    //   94: ifnull -> 40
    //   97: aload #4
    //   99: invokestatic a : (Lcom/tencent/liteav/o$a;)J
    //   102: invokestatic currentTimeMillis : ()J
    //   105: ldc2_w 1000
    //   108: ldiv
    //   109: lcmp
    //   110: ifle -> 40
    //   113: aload #4
    //   115: invokestatic c : (Lcom/tencent/liteav/o$a;)Z
    //   118: istore_2
    //   119: aload_0
    //   120: monitorexit
    //   121: iload_2
    //   122: ireturn
    //   123: aload_0
    //   124: monitorexit
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: iconst_0
    //   133: ireturn
    // Exception table:
    //   from	to	target	type
    //   15	29	127	finally
    //   33	40	127	finally
    //   40	92	127	finally
    //   97	121	127	finally
    //   123	125	127	finally
    //   128	130	127	finally
  }
  
  public void c(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 84
    //   4: aload_1
    //   5: invokevirtual isEmpty : ()Z
    //   8: ifeq -> 12
    //   11: return
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial d : (Ljava/lang/String;)J
    //   19: invokestatic currentTimeMillis : ()J
    //   22: ldc2_w 1000
    //   25: ldiv
    //   26: lcmp
    //   27: ifge -> 76
    //   30: ldc 'TXCVodPlayReportControl'
    //   32: ldc_w 'RequestReportControl'
    //   35: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokestatic currentTimeMillis : ()J
    //   43: ldc2_w 1000
    //   46: ldiv
    //   47: ldc2_w 3600
    //   50: ladd
    //   51: invokespecial a : (Ljava/lang/String;J)V
    //   54: new java/lang/Thread
    //   57: dup
    //   58: new com/tencent/liteav/o$1
    //   61: dup
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial <init> : (Lcom/tencent/liteav/o;Ljava/lang/String;)V
    //   67: ldc_w 'report_control'
    //   70: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/String;)V
    //   73: invokevirtual start : ()V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: return
    // Exception table:
    //   from	to	target	type
    //   14	76	79	finally
    //   76	78	79	finally
    //   80	82	79	finally
  }
  
  static class a extends b {
    private int c = 60;
    
    private boolean d = false;
    
    private long e = 0L;
    
    public a(int param1Int, boolean param1Boolean, long param1Long, String param1String) {
      super(param1String, "40302");
      this.c = param1Int;
      this.d = param1Boolean;
      this.e = param1Long;
    }
    
    public a(String param1String) {
      a(param1String);
    }
    
    private JSONObject a() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("SengmentDuration", this.c);
        jSONObject.put("ReportSwitch", this.d);
        jSONObject.put("ExpireTime", this.e);
        jSONObject.put("appid", this.a);
        jSONObject.put("eventid", this.b);
        return jSONObject;
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toJsonObject jsonexception: ");
        stringBuilder.append(jSONException.toString());
        TXCLog.e("TXCVodPlayReportControl", stringBuilder.toString());
        return jSONObject;
      } 
    }
    
    public void a(String param1String) {
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        this.c = jSONObject.optInt("SengmentDuration", 60);
        this.d = jSONObject.optBoolean("ReportSwitch", false);
        this.e = jSONObject.optLong("ExpireTime", System.currentTimeMillis() / 1000L + 3600L);
        this.a = jSONObject.optString("appid", "");
        this.b = jSONObject.optString("eventid", "");
        return;
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseFromString: ");
        stringBuilder.append(jSONException.toString());
        TXCLog.i("TXCVodPlayReportControl", stringBuilder.toString());
        this.c = 60;
        this.d = false;
        this.e = 0L;
        this.a = "";
        this.b = "40302";
        return;
      } 
    }
    
    public String toString() {
      return a().toString();
    }
  }
  
  static class b {
    protected String a = "";
    
    protected String b = "";
    
    public b() {}
    
    public b(String param1String1, String param1String2) {
      this.a = param1String1;
      this.b = param1String2;
    }
    
    public void a(String param1String) {
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        this.a = jSONObject.optString("appid", "");
        this.b = jSONObject.optString("eventid", "");
        return;
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseFromString: ");
        stringBuilder.append(jSONException.toString());
        TXCLog.i("TXCVodPlayReportControl", stringBuilder.toString());
        this.a = "";
        this.b = "";
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
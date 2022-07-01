package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.a.c;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
  private Network a;
  
  private String b;
  
  private String c = "";
  
  private int d = 1;
  
  private String e = null;
  
  private Bundle f;
  
  private void a(c paramc, Bundle paramBundle) {
    String str1 = y.a(true);
    String str2 = y.a(true, "1".equals(paramBundle.getString("operatorType", "")));
    paramBundle.putString("ipv4_list", str1);
    paramBundle.putString("ipv6_list", str2);
    c.a a = paramc.b();
    if (!paramBundle.getBoolean("isCloseIpv4", false))
      a.a(str1); 
    if (!paramBundle.getBoolean("isCloseIpv6", false))
      a.b(str2); 
    a.v(a.w(paramBundle.getString("appkey")));
    paramc.a(a);
  }
  
  private void a(String paramString1, int paramInt, a parama, HttpURLConnection paramHttpURLConnection, Network paramNetwork, String paramString2, String paramString3, String paramString4) {
    Bundle bundle;
    StringBuilder stringBuilder;
    String str = paramString1;
    if (paramInt == 302 || paramInt == 301) {
      paramString2 = this.f.getString("interfacecode", "");
      Bundle bundle1 = this.f;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(paramInt);
      stringBuilder.append(";");
      bundle1.putString("interfacecode", stringBuilder.toString());
      paramString2 = paramHttpURLConnection.getHeaderField("Location");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Location head =");
      stringBuilder1.append(paramString2);
      f.b("HttpUtils", stringBuilder1.toString());
      if (this.e == null)
        this.e = paramHttpURLConnection.getHeaderField("pplocation"); 
      if (!TextUtils.isEmpty(paramString2) && this.e != null) {
        String str1 = this.f.getString("interfacetype", "");
        if ("2".equals(this.f.getString("operatorType", "0"))) {
          bundle = this.f;
          stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append("getUnicomMobile;");
          bundle.putString("interfacetype", stringBuilder.toString());
        } else {
          bundle = this.f;
          stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append("getTelecomMobile;");
          bundle.putString("interfacetype", stringBuilder.toString());
        } 
        a(paramString2, "", parama, paramNetwork, "POST");
        return;
      } 
      parama.a("200021", "数据解析异常", this.c);
      return;
    } 
    if (paramInt != 200)
      try {
        String str1;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("http response code is not 200 ---");
        stringBuilder1.append(paramInt);
        f.a("HttpUtils", stringBuilder1.toString());
        this.d++;
        if (this.d <= 3 && (!i.a(this.b) || bundle.contains("logReport"))) {
          a((String)bundle, paramString2, parama, paramNetwork, (String)stringBuilder);
          return;
        } 
        if (paramInt == 0) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramInt);
          stringBuilder1.append("");
          parama.a(stringBuilder1.toString(), "请求出错", this.c);
          return;
        } 
        if (paramInt == Integer.valueOf("200050").intValue()) {
          parama.a("200050", "EOF异常", this.c);
          return;
        } 
        if (paramInt == Integer.valueOf("200072").intValue()) {
          parama.a("200072", "ca根证书校验失败", this.c);
          return;
        } 
        if (paramInt == Integer.valueOf("102507").intValue()) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramInt);
          stringBuilder1.append("");
          parama.a(stringBuilder1.toString(), str, this.c);
          return;
        } 
        if (TextUtils.isEmpty(paramString1)) {
          str1 = "网络异常";
        } else {
          str1 = str;
        } 
        parama.a("200028", str1, this.c);
        return;
      } catch (Exception exception) {
        com.cmic.sso.sdk.c.a.a.add(exception);
        if (TextUtils.isEmpty(paramString1))
          str = "网络异常"; 
        parama.a("200028", str, this.c);
        return;
      }  
    boolean bool = TextUtils.isEmpty(this.e);
    if (!bool) {
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("异网取号结果 = ");
        stringBuilder1.append(str);
        f.c("HttpUtils", stringBuilder1.toString());
        JSONObject jSONObject = new JSONObject(str);
        paramString2 = jSONObject.optString("result", "0");
        String str2 = this.f.getString("interfacecode", "");
        Bundle bundle1 = this.f;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(paramString2);
        stringBuilder2.append(";");
        bundle1.putString("interfacecode", stringBuilder2.toString());
        if (!TextUtils.isEmpty(jSONObject.getString("result")) && "0".equals(jSONObject.getString("result"))) {
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("pplocation=");
          stringBuilder3.append(this.e);
          f.c("HttpUtils", stringBuilder3.toString());
          paramString2 = this.e.substring(this.e.indexOf("?") + 1);
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put(paramString2.split("=")[0], paramString2.split("=")[1]);
          jSONObject1.put("data", str);
          this.e = this.e.substring(1, this.e.lastIndexOf("?"));
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append("http://onekey.cmpassport.com/unisdk/");
          stringBuilder4.append(this.e);
          String str3 = stringBuilder4.toString();
          str2 = this.f.getString("interfacetype", "");
          bundle1 = this.f;
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str2);
          stringBuilder2.append("getNewTelecomPhoneNumberNotify;");
          bundle1.putString("interfacetype", stringBuilder2.toString());
          this.e = null;
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append("location");
          stringBuilder5.append(str3);
          f.c("HttpUtils", stringBuilder5.toString());
          a(str3, jSONObject1.toString(), parama, paramNetwork, "POST");
          return;
        } 
        String str1 = this.c;
        try {
          parama.a("200039", "取号接口失败", str1);
          return;
        } catch (JSONException null) {}
      } catch (JSONException jSONException) {}
      com.cmic.sso.sdk.c.a.a.add(jSONException);
      parama.a("200039", "取号接口失败", this.c);
      return;
    } 
    parama.a(str, this.c);
  }
  
  private <T extends com.cmic.sso.sdk.b.a.f> void a(String paramString1, T paramT, a parama, String paramString2) {
    f.b("HttpUtils", "in  wifiNetwork");
    aa aa = aa.a((Context)null);
    int k = Build.VERSION.SDK_INT;
    int j = 0;
    int i = 0;
    if (k >= 21) {
      this.a = null;
      aa.a(new aa.a(this) {
            public void a(Network param1Network) {
              d.a(this.a, param1Network);
              f.b("HttpUtils", "onAvailable");
            }
          });
      while (this.a == null) {
        j = i + 1;
        SystemClock.sleep(50L);
        f.b("HttpUtils", "waiting for newtwork");
        i = j;
        if (j > 60) {
          parama.a("200024", "数据网络切换失败", this.c);
          return;
        } 
      } 
      this.c = v.a();
      if (paramString1.contains("getPrePhonescrip"))
        a((c)paramT, this.f); 
      a(paramString1, paramT.a().toString(), parama, this.a, paramString2);
      return;
    } 
    aa.a.startUsingNetworkFeature(0, "enableHIPRI");
    i = j;
    while (i < 30) {
      try {
        if (aa.a.getNetworkInfo(5).getState().compareTo((Enum)NetworkInfo.State.CONNECTED) == 0)
          break; 
        SystemClock.sleep(1000L);
        i++;
      } catch (Exception exception) {
        com.cmic.sso.sdk.c.a.a.add(exception);
        f.a("HttpUtils", "check hipri failed");
        parama.a("200024", "数据网络切换失败", this.c);
        return;
      } 
    } 
    i = aa.a(aa.b((String)exception));
    boolean bool = aa.a.requestRouteToHost(5, i);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("切换数据网络结果 >>> ");
    stringBuilder.append(bool);
    f.a("HttpUtils", stringBuilder.toString());
    if (bool) {
      f.a("HttpUtils", "切换网络成功");
      this.c = v.a();
      if (exception.contains("getPrePhonescrip"))
        a((c)paramT, this.f); 
      a((String)exception, paramT.a().toString(), parama, null, paramString2);
      return;
    } 
    f.a("HttpUtils", "切换网络失败or无数据网络");
    parama.a("200024", "数据网络切换失败", this.c);
  }
  
  private void a(String paramString1, String paramString2, a parama, Network paramNetwork, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/lang/String;
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifeq -> 30
    //   10: aload_1
    //   11: ldc 'logReport'
    //   13: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   16: ifne -> 30
    //   19: aload_1
    //   20: ldc_w 'Config'
    //   23: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   26: ifne -> 30
    //   29: return
    //   30: aconst_null
    //   31: astore #8
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore #7
    //   42: aload #7
    //   44: ldc_w 'try '
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #7
    //   53: aload_0
    //   54: getfield d : I
    //   57: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #7
    //   63: ldc_w ' http reqeust, url: '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #7
    //   72: aload_1
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: ldc 'HttpUtils'
    //   79: aload #7
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   87: new java/net/URL
    //   90: dup
    //   91: aload_1
    //   92: invokespecial <init> : (Ljava/lang/String;)V
    //   95: astore #7
    //   97: getstatic android/os/Build$VERSION.SDK_INT : I
    //   100: bipush #21
    //   102: if_icmplt -> 133
    //   105: aload #4
    //   107: ifnull -> 133
    //   110: aload #4
    //   112: aload #7
    //   114: invokevirtual openConnection : (Ljava/net/URL;)Ljava/net/URLConnection;
    //   117: checkcast java/net/HttpURLConnection
    //   120: astore #10
    //   122: ldc 'HttpUtils'
    //   124: ldc_w 'is network null?不为空'
    //   127: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -> 151
    //   133: aload #7
    //   135: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   138: checkcast java/net/HttpURLConnection
    //   141: astore #10
    //   143: ldc 'HttpUtils'
    //   145: ldc_w 'is network null?为空'
    //   148: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: ldc_w 'https'
    //   155: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   158: ifeq -> 174
    //   161: aload #10
    //   163: checkcast javax/net/ssl/HttpsURLConnection
    //   166: aload_0
    //   167: getfield f : Landroid/os/Bundle;
    //   170: aload_1
    //   171: invokestatic a : (Ljavax/net/ssl/HttpsURLConnection;Landroid/os/Bundle;Ljava/lang/String;)V
    //   174: aload #10
    //   176: sipush #15000
    //   179: invokevirtual setConnectTimeout : (I)V
    //   182: aload #10
    //   184: sipush #19000
    //   187: invokevirtual setReadTimeout : (I)V
    //   190: aload #10
    //   192: ldc_w 'traceId'
    //   195: aload_0
    //   196: getfield b : Ljava/lang/String;
    //   199: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield f : Landroid/os/Bundle;
    //   206: astore #7
    //   208: aload #7
    //   210: ifnull -> 253
    //   213: aload #10
    //   215: ldc_w 'appid'
    //   218: aload_0
    //   219: getfield f : Landroid/os/Bundle;
    //   222: ldc_w 'appid'
    //   225: ldc ''
    //   227: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload #10
    //   235: ldc_w 'interfaceVersion'
    //   238: aload_0
    //   239: getfield f : Landroid/os/Bundle;
    //   242: ldc_w 'interfaceVersion'
    //   245: ldc ''
    //   247: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   250: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload #10
    //   255: ldc_w 'sdkVersion'
    //   258: ldc_w 'quick_login_android_5.7.2'
    //   261: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload #10
    //   266: iconst_0
    //   267: invokevirtual setUseCaches : (Z)V
    //   270: aload #10
    //   272: ldc_w 'Content-Type'
    //   275: ldc_w 'application/json'
    //   278: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_1
    //   282: ldc_w 'preGetMobile'
    //   285: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   288: ifeq -> 302
    //   291: aload #10
    //   293: ldc_w 'Content-Type'
    //   296: ldc_w 'application/x-www-form-urlencoded'
    //   299: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_1
    //   303: ldc_w 'getPrePhonescrip'
    //   306: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   309: ifeq -> 322
    //   312: aload #10
    //   314: ldc_w 'defendEOF'
    //   317: ldc '1'
    //   319: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload #10
    //   324: ldc_w 'Charset'
    //   327: ldc_w 'UTF-8'
    //   330: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload #10
    //   335: iconst_1
    //   336: invokevirtual setDoInput : (Z)V
    //   339: aload #10
    //   341: iconst_0
    //   342: invokevirtual setInstanceFollowRedirects : (Z)V
    //   345: aload #5
    //   347: ldc 'POST'
    //   349: invokevirtual equals : (Ljava/lang/Object;)Z
    //   352: ifeq -> 434
    //   355: aload #10
    //   357: ldc 'POST'
    //   359: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   362: aload #10
    //   364: iconst_1
    //   365: invokevirtual setDoOutput : (Z)V
    //   368: new java/io/DataOutputStream
    //   371: dup
    //   372: aload #10
    //   374: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   377: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   380: astore #7
    //   382: aload #7
    //   384: astore #8
    //   386: aload #7
    //   388: astore #9
    //   390: aload_2
    //   391: ldc_w 'UTF-8'
    //   394: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   397: astore #11
    //   399: aload #7
    //   401: astore #8
    //   403: aload #7
    //   405: astore #9
    //   407: aload #7
    //   409: aload #11
    //   411: iconst_0
    //   412: aload #11
    //   414: arraylength
    //   415: invokevirtual write : ([BII)V
    //   418: aload #7
    //   420: astore #8
    //   422: aload #7
    //   424: astore #9
    //   426: aload #7
    //   428: invokevirtual flush : ()V
    //   431: goto -> 456
    //   434: aload #5
    //   436: ldc_w 'GET'
    //   439: invokevirtual equals : (Ljava/lang/Object;)Z
    //   442: ifeq -> 453
    //   445: aload #10
    //   447: ldc_w 'GET'
    //   450: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   453: aconst_null
    //   454: astore #7
    //   456: aload #7
    //   458: astore #8
    //   460: aload #7
    //   462: astore #9
    //   464: aload #10
    //   466: invokevirtual getResponseCode : ()I
    //   469: istore #6
    //   471: aload #7
    //   473: astore #8
    //   475: aload #7
    //   477: astore #9
    //   479: new java/io/BufferedReader
    //   482: dup
    //   483: new java/io/InputStreamReader
    //   486: dup
    //   487: aload #10
    //   489: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   492: invokespecial <init> : (Ljava/io/InputStream;)V
    //   495: invokespecial <init> : (Ljava/io/Reader;)V
    //   498: astore #11
    //   500: new java/lang/StringBuilder
    //   503: dup
    //   504: ldc ''
    //   506: invokespecial <init> : (Ljava/lang/String;)V
    //   509: astore #8
    //   511: aload #11
    //   513: invokevirtual readLine : ()Ljava/lang/String;
    //   516: astore #9
    //   518: aload #9
    //   520: ifnull -> 547
    //   523: aload #8
    //   525: new java/lang/String
    //   528: dup
    //   529: aload #9
    //   531: invokevirtual getBytes : ()[B
    //   534: ldc_w 'utf-8'
    //   537: invokespecial <init> : ([BLjava/lang/String;)V
    //   540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: goto -> 511
    //   547: aload #8
    //   549: invokevirtual toString : ()Ljava/lang/String;
    //   552: astore #8
    //   554: aload #7
    //   556: ifnull -> 567
    //   559: aload #7
    //   561: invokevirtual close : ()V
    //   564: goto -> 567
    //   567: aload #11
    //   569: invokevirtual close : ()V
    //   572: goto -> 589
    //   575: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   578: aload #7
    //   580: invokevirtual add : (Ljava/lang/Object;)Z
    //   583: pop
    //   584: aload #7
    //   586: invokevirtual printStackTrace : ()V
    //   589: aload_0
    //   590: aload #8
    //   592: iload #6
    //   594: aload_3
    //   595: aload #10
    //   597: aload #4
    //   599: aload_2
    //   600: aload_1
    //   601: aload #5
    //   603: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/d$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   606: return
    //   607: astore_2
    //   608: aload #7
    //   610: astore_3
    //   611: aload #11
    //   613: astore_1
    //   614: goto -> 636
    //   617: astore #9
    //   619: aload #7
    //   621: astore #8
    //   623: aload #11
    //   625: astore #7
    //   627: goto -> 682
    //   630: astore_2
    //   631: aconst_null
    //   632: astore_1
    //   633: aload #8
    //   635: astore_3
    //   636: goto -> 860
    //   639: astore #7
    //   641: aload #9
    //   643: astore #8
    //   645: aconst_null
    //   646: astore #10
    //   648: aload #7
    //   650: astore #9
    //   652: aload #10
    //   654: astore #7
    //   656: goto -> 682
    //   659: astore #9
    //   661: goto -> 675
    //   664: astore_2
    //   665: aconst_null
    //   666: astore_1
    //   667: aload #8
    //   669: astore_3
    //   670: goto -> 860
    //   673: astore #9
    //   675: aconst_null
    //   676: astore #7
    //   678: aload #7
    //   680: astore #8
    //   682: aload #9
    //   684: invokevirtual printStackTrace : ()V
    //   687: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   690: aload #9
    //   692: invokevirtual add : (Ljava/lang/Object;)Z
    //   695: pop
    //   696: aload #9
    //   698: instanceof javax/net/ssl/SSLHandshakeException
    //   701: ifeq -> 736
    //   704: aload_0
    //   705: getfield f : Landroid/os/Bundle;
    //   708: ldc_w 'isNeedToGetCert'
    //   711: iconst_1
    //   712: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   715: aload_0
    //   716: aconst_null
    //   717: ldc '200072'
    //   719: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   722: invokevirtual intValue : ()I
    //   725: aload_3
    //   726: aconst_null
    //   727: aload #4
    //   729: aload_2
    //   730: aload_1
    //   731: aload #5
    //   733: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/d$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   736: aload #9
    //   738: instanceof java/io/EOFException
    //   741: ifeq -> 802
    //   744: aload_0
    //   745: aconst_null
    //   746: ldc '200050'
    //   748: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   751: invokevirtual intValue : ()I
    //   754: aload_3
    //   755: aconst_null
    //   756: aload #4
    //   758: aload_2
    //   759: aload_1
    //   760: aload #5
    //   762: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/d$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   765: aload #8
    //   767: ifnull -> 778
    //   770: aload #8
    //   772: invokevirtual close : ()V
    //   775: goto -> 778
    //   778: aload #7
    //   780: ifnull -> 801
    //   783: aload #7
    //   785: invokevirtual close : ()V
    //   788: return
    //   789: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   792: aload_1
    //   793: invokevirtual add : (Ljava/lang/Object;)Z
    //   796: pop
    //   797: aload_1
    //   798: invokevirtual printStackTrace : ()V
    //   801: return
    //   802: aload_0
    //   803: aconst_null
    //   804: iconst_m1
    //   805: aload_3
    //   806: aconst_null
    //   807: aload #4
    //   809: aload_2
    //   810: aload_1
    //   811: aload #5
    //   813: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/d$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: aload #8
    //   818: ifnull -> 829
    //   821: aload #8
    //   823: invokevirtual close : ()V
    //   826: goto -> 829
    //   829: aload #7
    //   831: ifnull -> 852
    //   834: aload #7
    //   836: invokevirtual close : ()V
    //   839: return
    //   840: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   843: aload_1
    //   844: invokevirtual add : (Ljava/lang/Object;)Z
    //   847: pop
    //   848: aload_1
    //   849: invokevirtual printStackTrace : ()V
    //   852: return
    //   853: astore_2
    //   854: aload #8
    //   856: astore_3
    //   857: aload #7
    //   859: astore_1
    //   860: aload_3
    //   861: ifnull -> 871
    //   864: aload_3
    //   865: invokevirtual close : ()V
    //   868: goto -> 871
    //   871: aload_1
    //   872: ifnull -> 894
    //   875: aload_1
    //   876: invokevirtual close : ()V
    //   879: goto -> 894
    //   882: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   885: aload_1
    //   886: invokevirtual add : (Ljava/lang/Object;)Z
    //   889: pop
    //   890: aload_1
    //   891: invokevirtual printStackTrace : ()V
    //   894: aload_2
    //   895: athrow
    //   896: astore #7
    //   898: goto -> 575
    //   901: astore_1
    //   902: goto -> 789
    //   905: astore_1
    //   906: goto -> 840
    //   909: astore_1
    //   910: goto -> 882
    // Exception table:
    //   from	to	target	type
    //   33	105	673	java/lang/Exception
    //   33	105	664	finally
    //   110	130	673	java/lang/Exception
    //   110	130	664	finally
    //   133	151	673	java/lang/Exception
    //   133	151	664	finally
    //   151	174	673	java/lang/Exception
    //   151	174	664	finally
    //   174	208	673	java/lang/Exception
    //   174	208	664	finally
    //   213	253	673	java/lang/Exception
    //   213	253	664	finally
    //   253	302	673	java/lang/Exception
    //   253	302	664	finally
    //   302	322	673	java/lang/Exception
    //   302	322	664	finally
    //   322	382	673	java/lang/Exception
    //   322	382	664	finally
    //   390	399	639	java/lang/Exception
    //   390	399	630	finally
    //   407	418	639	java/lang/Exception
    //   407	418	630	finally
    //   426	431	639	java/lang/Exception
    //   426	431	630	finally
    //   434	453	659	java/lang/Exception
    //   434	453	664	finally
    //   464	471	639	java/lang/Exception
    //   464	471	630	finally
    //   479	500	639	java/lang/Exception
    //   479	500	630	finally
    //   500	511	617	java/lang/Exception
    //   500	511	607	finally
    //   511	518	617	java/lang/Exception
    //   511	518	607	finally
    //   523	544	617	java/lang/Exception
    //   523	544	607	finally
    //   547	554	617	java/lang/Exception
    //   547	554	607	finally
    //   559	564	896	java/io/IOException
    //   567	572	896	java/io/IOException
    //   682	736	853	finally
    //   736	765	853	finally
    //   770	775	901	java/io/IOException
    //   783	788	901	java/io/IOException
    //   802	816	853	finally
    //   821	826	905	java/io/IOException
    //   834	839	905	java/io/IOException
    //   864	868	909	java/io/IOException
    //   875	879	909	java/io/IOException
  }
  
  private static void a(HttpsURLConnection paramHttpsURLConnection, Bundle paramBundle, String paramString) {
    if (!paramBundle.getBoolean("CLOSE_CERT_VERIFY", true) && !paramString.contains("https://config.cmpassport.com/client/uniConfig"))
      paramHttpsURLConnection.setSSLSocketFactory((new com.cmic.sso.sdk.b.c.a(paramBundle)).a().getSocketFactory()); 
  }
  
  public <T extends com.cmic.sso.sdk.b.a.f> void a(String paramString1, T paramT, boolean paramBoolean, a parama, String paramString2, String paramString3, Bundle paramBundle) {
    this.f = paramBundle;
    this.b = paramString3;
    if (i.a(paramString3) && !paramString1.contains("logReport") && !paramString1.contains("Config"))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("使用wifi下取号？？？？？？？");
    stringBuilder.append(paramBoolean);
    f.c("HttpUtils", stringBuilder.toString());
    if (paramBoolean) {
      a(paramString1, paramT, parama, paramString2);
      return;
    } 
    if (paramString1.contains("getPrePhonescrip"))
      a((c)paramT, paramBundle); 
    a(paramString1, paramT.a().toString(), parama, null, paramString2);
  }
  
  public static interface a {
    void a(String param1String1, String param1String2);
    
    void a(String param1String1, String param1String2, String param1String3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
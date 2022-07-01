package com.taobao.tao.remotebusiness.listener;

import android.content.Context;
import com.alibaba.wireless.security.jaq.SecurityVerification;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Closeable;
import java.lang.reflect.Proxy;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.b.a;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.global.SDKConfig;

public class c {
  private SecurityGuardManager a = null;
  
  private SDKConfig b = null;
  
  private SecurityVerification c;
  
  public static String a(String paramString1, MtopBusiness paramMtopBusiness, boolean paramBoolean, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(" [");
    if (paramMtopBusiness != null) {
      stringBuilder.append("apiName=");
      stringBuilder.append(paramMtopBusiness.request.a());
      stringBuilder.append(";version=");
      stringBuilder.append(paramMtopBusiness.request.b());
      stringBuilder.append(";requestType=");
      stringBuilder.append(paramMtopBusiness.getRequestType());
      if (paramBoolean) {
        stringBuilder.append(";clazz=");
        stringBuilder.append(paramMtopBusiness.clazz);
      } 
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static String a(Map paramMap, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 83
    //   4: aload_0
    //   5: invokeinterface isEmpty : ()Z
    //   10: ifne -> 83
    //   13: aload_1
    //   14: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   17: ifeq -> 23
    //   20: goto -> 83
    //   23: aload_0
    //   24: invokeinterface entrySet : ()Ljava/util/Set;
    //   29: invokeinterface iterator : ()Ljava/util/Iterator;
    //   34: astore_0
    //   35: aload_0
    //   36: invokeinterface hasNext : ()Z
    //   41: ifeq -> 83
    //   44: aload_0
    //   45: invokeinterface next : ()Ljava/lang/Object;
    //   50: checkcast java/util/Map$Entry
    //   53: astore_2
    //   54: aload_1
    //   55: aload_2
    //   56: invokeinterface getKey : ()Ljava/lang/Object;
    //   61: checkcast java/lang/String
    //   64: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   67: ifeq -> 35
    //   70: aload_2
    //   71: invokeinterface getValue : ()Ljava/lang/Object;
    //   76: checkcast java/util/List
    //   79: astore_0
    //   80: goto -> 85
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull -> 111
    //   89: aload_0
    //   90: invokeinterface isEmpty : ()Z
    //   95: ifeq -> 100
    //   98: aconst_null
    //   99: areturn
    //   100: aload_0
    //   101: iconst_0
    //   102: invokeinterface get : (I)Ljava/lang/Object;
    //   107: checkcast java/lang/String
    //   110: areturn
    //   111: aconst_null
    //   112: areturn
  }
  
  public static MtopListener a(MtopBusiness paramMtopBusiness, MtopListener paramMtopListener) {
    ArrayList<Class<MtopCallback.MtopFinishListener>> arrayList = new ArrayList();
    arrayList.add(MtopCallback.MtopFinishListener.class);
    if (paramMtopListener instanceof com.taobao.tao.remotebusiness.IRemoteProcessListener) {
      arrayList.add(MtopCallback.MtopProgressListener.class);
      arrayList.add(MtopCallback.MtopHeaderListener.class);
    } 
    if (paramMtopListener instanceof com.taobao.tao.remotebusiness.IRemoteCacheListener || paramMtopBusiness.mtopProp.h)
      arrayList.add(MtopCallback.MtopCacheListener.class); 
    Class[] arrayOfClass = (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()]);
    return (MtopListener)Proxy.newProxyInstance(MtopListener.class.getClassLoader(), arrayOfClass, new a(paramMtopBusiness, paramMtopListener));
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean a(String paramString) {
    return (paramString.equals("POST") || paramString.equals("PUT") || paramString.equals("PATCH"));
  }
  
  public static boolean a(Map paramMap) {
    try {
      boolean bool = "gzip".equalsIgnoreCase(a(paramMap, "Content-Encoding"));
      if (bool)
        return true; 
    } catch (Exception exception) {}
    return false;
  }
  
  public static String b(String paramString) {
    if (StringUtils.b(paramString))
      return paramString; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes("utf-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfByte.length; i++) {
        String str;
        for (str = Integer.toHexString(arrayOfByte[i] & 0xFF); str.length() < 2; str = stringBuilder.toString()) {
          StringBuilder stringBuilder = new StringBuilder("0");
          stringBuilder.append(str);
        } 
        stringBuffer.append(str);
      } 
      return stringBuffer.toString();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("[getMd5] compute md5 value failed for source str=");
      stringBuilder.append(paramString);
      TBSdkLog.b("mtopsdk.SecurityUtils", stringBuilder.toString(), exception);
      return null;
    } 
  }
  
  private static String c(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public String a() {
    try {
      if (this.c != null)
        return this.c.doJAQVerfificationSync(null, 20); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public String a(HashMap paramHashMap, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 545
    //   4: aload_2
    //   5: ifnonnull -> 11
    //   8: goto -> 545
    //   11: aload_0
    //   12: getfield a : Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   15: ifnonnull -> 29
    //   18: ldc_w 'mtopsdk.SecuritySignImpl'
    //   21: ldc_w '[getMtopApiWBSign]SecurityGuardManager is null,please call ISign init()'
    //   24: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: new com/alibaba/wireless/security/open/SecurityGuardParamContext
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore_3
    //   37: aload_3
    //   38: aload_2
    //   39: putfield appKey : Ljava/lang/String;
    //   42: aload_3
    //   43: bipush #7
    //   45: putfield requestType : I
    //   48: aload_1
    //   49: ifnull -> 578
    //   52: aload_1
    //   53: invokeinterface size : ()I
    //   58: ifgt -> 64
    //   61: goto -> 578
    //   64: aload_1
    //   65: ldc_w 'api'
    //   68: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast java/lang/String
    //   76: astore #4
    //   78: aload_1
    //   79: ldc_w 'v'
    //   82: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast java/lang/String
    //   90: astore #5
    //   92: aload_1
    //   93: ldc_w 'data'
    //   96: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   101: checkcast java/lang/String
    //   104: astore #6
    //   106: aload_1
    //   107: ldc_w 'accessToken'
    //   110: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast java/lang/String
    //   118: astore #7
    //   120: aload_1
    //   121: ldc_w 't'
    //   124: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast java/lang/String
    //   132: astore #8
    //   134: aload_1
    //   135: ldc_w 'utdid'
    //   138: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast java/lang/String
    //   146: astore #9
    //   148: aload_1
    //   149: ldc_w 'pv'
    //   152: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast java/lang/String
    //   160: astore #10
    //   162: aload_1
    //   163: ldc_w 'x-features'
    //   166: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast java/lang/String
    //   174: astore #11
    //   176: aload_1
    //   177: ldc_w 'ttid'
    //   180: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast java/lang/String
    //   188: astore #12
    //   190: aload_1
    //   191: ldc_w 'sid'
    //   194: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast java/lang/String
    //   202: astore #13
    //   204: aload_1
    //   205: ldc_w 'wua'
    //   208: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   213: checkcast java/lang/String
    //   216: astore_1
    //   217: new java/lang/StringBuilder
    //   220: dup
    //   221: bipush #64
    //   223: invokespecial <init> : (I)V
    //   226: astore #14
    //   228: aload #14
    //   230: aload #4
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload #14
    //   238: ldc_w '&'
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #14
    //   247: aload #5
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #14
    //   255: ldc_w '&'
    //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload #14
    //   264: aload #6
    //   266: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #14
    //   275: ldc_w '&'
    //   278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload #14
    //   284: aload_2
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload #14
    //   291: ldc_w '&'
    //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload #14
    //   300: aload #7
    //   302: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload #14
    //   311: ldc_w '&'
    //   314: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload #14
    //   320: aload #8
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload #14
    //   328: ldc_w '&'
    //   331: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload #14
    //   337: aload #9
    //   339: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload #14
    //   348: ldc_w '&'
    //   351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload #14
    //   357: aload #10
    //   359: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload #14
    //   368: ldc_w '&'
    //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload #14
    //   377: aload #11
    //   379: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   382: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload #14
    //   388: ldc_w '&'
    //   391: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload #14
    //   397: aload #12
    //   399: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload #14
    //   408: ldc_w '&'
    //   411: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload #14
    //   417: aload #13
    //   419: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload #14
    //   428: ldc_w '&'
    //   431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload #14
    //   437: aload_1
    //   438: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: new java/util/HashMap
    //   448: dup
    //   449: iconst_2
    //   450: invokespecial <init> : (I)V
    //   453: astore_1
    //   454: aload_1
    //   455: ldc_w 'INPUT'
    //   458: aload #14
    //   460: invokevirtual toString : ()Ljava/lang/String;
    //   463: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: goto -> 472
    //   472: aload_1
    //   473: ldc_w 'ATLAS'
    //   476: ldc_w 'a'
    //   479: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload_3
    //   486: aload_1
    //   487: putfield paramMap : Ljava/util/Map;
    //   490: aload_0
    //   491: getfield a : Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   494: invokevirtual getSecureSignatureComp : ()Lcom/alibaba/wireless/security/open/securesignature/ISecureSignatureComponent;
    //   497: astore_2
    //   498: aload_0
    //   499: getfield b : Lmtopsdk/mtop/global/SDKConfig;
    //   502: invokevirtual i : ()Ljava/lang/String;
    //   505: astore_1
    //   506: aload_1
    //   507: ifnull -> 583
    //   510: goto -> 513
    //   513: aload_2
    //   514: aload_3
    //   515: aload_1
    //   516: invokeinterface signRequest : (Lcom/alibaba/wireless/security/open/SecurityGuardParamContext;Ljava/lang/String;)Ljava/lang/String;
    //   521: astore_1
    //   522: aload_1
    //   523: areturn
    //   524: astore_1
    //   525: goto -> 533
    //   528: astore_1
    //   529: goto -> 575
    //   532: astore_1
    //   533: ldc_w 'mtopsdk.SecuritySignImpl'
    //   536: ldc_w '[getMtopApiWBSign] ISecureSignatureComponent signRequest error'
    //   539: aload_1
    //   540: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   543: aconst_null
    //   544: areturn
    //   545: new java/lang/StringBuilder
    //   548: dup
    //   549: ldc_w '[getMtopApiWBSign] appkey or params is null.appkey='
    //   552: invokespecial <init> : (Ljava/lang/String;)V
    //   555: astore_1
    //   556: aload_1
    //   557: aload_2
    //   558: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: ldc_w 'mtopsdk.SecuritySignImpl'
    //   565: aload_1
    //   566: invokevirtual toString : ()Ljava/lang/String;
    //   569: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   572: aconst_null
    //   573: areturn
    //   574: astore_1
    //   575: goto -> 533
    //   578: aconst_null
    //   579: astore_1
    //   580: goto -> 472
    //   583: ldc_w ''
    //   586: astore_1
    //   587: goto -> 513
    // Exception table:
    //   from	to	target	type
    //   29	48	532	finally
    //   52	61	574	finally
    //   64	204	574	finally
    //   204	469	528	finally
    //   472	490	528	finally
    //   490	506	524	finally
    //   513	522	524	finally
  }
  
  public String a(a parama) {
    int i;
    if (parama == null)
      return null; 
    if (parama.b != null)
      return parama.b; 
    IStaticDataStoreComponent iStaticDataStoreComponent = this.a.getStaticDataStoreComp();
    try {
      String str = this.b.i();
      i = parama.a;
      if (str != null) {
        null = str;
        return iStaticDataStoreComponent.getAppKeyByIndex(i, null);
      } 
    } catch (Exception exception) {
      TBSdkLog.b("mtopsdk.SecuritySignImpl", "[getAppkey]getAppKeyByIndex error.", exception);
      return null;
    } 
    null = "";
    return iStaticDataStoreComponent.getAppKeyByIndex(i, null);
  }
  
  public void a(Context paramContext, int paramInt) {
    String str;
    if (paramContext == null) {
      str = "[init]SecuritySignImpl init.context is null";
    } else {
      try {
        long l = System.currentTimeMillis();
        this.b = SDKConfig.a();
        this.a = SecurityGuardManager.getInstance((Context)str);
        IStaticDataStoreComponent iStaticDataStoreComponent = this.a.getStaticDataStoreComp();
        String str1 = this.b.i();
        if (str1 == null)
          str1 = ""; 
        str1 = iStaticDataStoreComponent.getAppKeyByIndex(paramInt, str1);
        return;
      } finally {
        str = null;
        StringBuilder stringBuilder = new StringBuilder("[init]SecuritySignImpl init securityguard error.---");
        stringBuilder.append(str.toString());
      } 
    } 
    TBSdkLog.d("mtopsdk.SecuritySignImpl", str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\listener\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
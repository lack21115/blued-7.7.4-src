package com.baidu.mobads.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.mobads.a.a;
import com.baidu.mobads.command.a;
import com.baidu.mobads.constants.a;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.e.e;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class h implements IXAdCommonUtils {
  private static String a;
  
  private static String b;
  
  private static String c;
  
  private static String d;
  
  private static String h = "";
  
  private final String e = "_cpr";
  
  private final AtomicLong f = new AtomicLong(1L);
  
  private Method g = null;
  
  private HashMap<String, Object> i = new HashMap<String, Object>();
  
  public static Class<?> a(Object<?> paramObject) {
    try {
      return Class.forName(paramObject.getClass().getName());
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return null;
    } 
  }
  
  public static Object a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      return a(paramClass, paramString, paramArrayOfClass) ? paramClass.getMethod(paramString, paramArrayOfClass).invoke((Object)null, paramArrayOfObject) : null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private String a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      String str = paramContext.getFilesDir().toString();
      stringBuilder.append(str.toString().substring(0, str.toString().lastIndexOf(File.separator)));
    } catch (Exception exception) {}
    stringBuilder.append(File.separator);
    stringBuilder.append("bddownload");
    return stringBuilder.toString();
  }
  
  public static Method a(Object paramObject, String paramString, Class<?>... paramVarArgs) {
    try {
      paramObject = a(paramObject).getDeclaredMethod(paramString, paramVarArgs);
      paramObject.setAccessible(true);
      return (Method)paramObject;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return null;
    } 
  }
  
  private void a(Context paramContext, Intent paramIntent) {
    try {
      if (Build.VERSION.SDK_INT < 19) {
        paramContext.startActivity(paramIntent);
        return;
      } 
      (new Handler(paramContext.getMainLooper())).post(new i(this, paramContext, paramIntent));
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      if (i == 0)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      q.a().e(exception);
      return false;
    } 
  }
  
  public static boolean a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
    boolean bool = false;
    try {
      Method method = paramClass.getMethod(paramString, paramVarArgs);
      if (method != null)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static String b(Context paramContext) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   3: invokevirtual getAdConstants : ()Lcom/baidu/mobads/utils/l;
    //   6: invokevirtual getSupportedBrowsers : ()[Ljava/lang/String;
    //   9: astore #5
    //   11: aload_0
    //   12: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   15: astore #6
    //   17: new java/util/ArrayList
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #7
    //   26: new java/util/ArrayList
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore #8
    //   35: aload #6
    //   37: aload #7
    //   39: aload #8
    //   41: aconst_null
    //   42: invokevirtual getPreferredActivities : (Ljava/util/List;Ljava/util/List;Ljava/lang/String;)I
    //   45: pop
    //   46: aload #8
    //   48: invokeinterface iterator : ()Ljava/util/Iterator;
    //   53: astore #7
    //   55: aload #7
    //   57: invokeinterface hasNext : ()Z
    //   62: istore #4
    //   64: iconst_0
    //   65: istore_1
    //   66: iload #4
    //   68: ifeq -> 135
    //   71: aload #7
    //   73: invokeinterface next : ()Ljava/lang/Object;
    //   78: checkcast android/content/ComponentName
    //   81: astore #8
    //   83: iload_1
    //   84: aload #5
    //   86: arraylength
    //   87: if_icmpge -> 55
    //   90: aload #5
    //   92: iload_1
    //   93: aaload
    //   94: astore #9
    //   96: aload #9
    //   98: aload #8
    //   100: invokevirtual getPackageName : ()Ljava/lang/String;
    //   103: invokevirtual equals : (Ljava/lang/Object;)Z
    //   106: ifeq -> 128
    //   109: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   112: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   115: aload #9
    //   117: ldc '规则1 hit!'
    //   119: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   124: pop
    //   125: aload #9
    //   127: areturn
    //   128: iload_1
    //   129: iconst_1
    //   130: iadd
    //   131: istore_1
    //   132: goto -> 83
    //   135: aload_0
    //   136: ldc 'activity'
    //   138: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast android/app/ActivityManager
    //   144: invokevirtual getRunningAppProcesses : ()Ljava/util/List;
    //   147: invokeinterface iterator : ()Ljava/util/Iterator;
    //   152: astore_0
    //   153: iconst_m1
    //   154: istore_1
    //   155: iload_1
    //   156: istore_2
    //   157: aload_0
    //   158: invokeinterface hasNext : ()Z
    //   163: ifeq -> 281
    //   166: aload_0
    //   167: invokeinterface next : ()Ljava/lang/Object;
    //   172: checkcast android/app/ActivityManager$RunningAppProcessInfo
    //   175: astore #7
    //   177: aload #6
    //   179: aload #7
    //   181: getfield processName : Ljava/lang/String;
    //   184: invokevirtual getLaunchIntentForPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   187: ifnull -> 155
    //   190: aload #6
    //   192: aload #7
    //   194: getfield processName : Ljava/lang/String;
    //   197: sipush #128
    //   200: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   203: astore #8
    //   205: aload #8
    //   207: ifnull -> 155
    //   210: iconst_0
    //   211: istore_2
    //   212: iload_2
    //   213: aload #5
    //   215: arraylength
    //   216: if_icmpge -> 266
    //   219: aload #7
    //   221: getfield processName : Ljava/lang/String;
    //   224: aload #5
    //   226: iload_2
    //   227: aaload
    //   228: invokevirtual equals : (Ljava/lang/Object;)Z
    //   231: istore #4
    //   233: iload_1
    //   234: istore_3
    //   235: iload #4
    //   237: ifeq -> 257
    //   240: iload_1
    //   241: iconst_m1
    //   242: if_icmpne -> 248
    //   245: goto -> 255
    //   248: iload_1
    //   249: istore_3
    //   250: iload_2
    //   251: iload_1
    //   252: if_icmpge -> 257
    //   255: iload_2
    //   256: istore_3
    //   257: iload_2
    //   258: iconst_1
    //   259: iadd
    //   260: istore_2
    //   261: iload_3
    //   262: istore_1
    //   263: goto -> 212
    //   266: goto -> 155
    //   269: iload_1
    //   270: istore_2
    //   271: goto -> 281
    //   274: iload_1
    //   275: istore_2
    //   276: goto -> 281
    //   279: iconst_m1
    //   280: istore_2
    //   281: iload_2
    //   282: iconst_m1
    //   283: if_icmpeq -> 291
    //   286: aload #5
    //   288: iload_2
    //   289: aaload
    //   290: areturn
    //   291: new android/content/Intent
    //   294: dup
    //   295: ldc_w 'android.intent.action.VIEW'
    //   298: invokespecial <init> : (Ljava/lang/String;)V
    //   301: astore_0
    //   302: aload_0
    //   303: ldc_w 'http://m.baidu.com'
    //   306: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   309: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   312: pop
    //   313: aload #6
    //   315: aload_0
    //   316: bipush #64
    //   318: invokevirtual queryIntentActivities : (Landroid/content/Intent;I)Ljava/util/List;
    //   321: astore_0
    //   322: aload_0
    //   323: ifnull -> 401
    //   326: iconst_0
    //   327: istore_1
    //   328: iload_1
    //   329: aload #5
    //   331: arraylength
    //   332: if_icmpge -> 401
    //   335: iconst_0
    //   336: istore_2
    //   337: iload_2
    //   338: aload_0
    //   339: invokeinterface size : ()I
    //   344: if_icmpge -> 499
    //   347: aload_0
    //   348: iload_2
    //   349: invokeinterface get : (I)Ljava/lang/Object;
    //   354: checkcast android/content/pm/ResolveInfo
    //   357: getfield activityInfo : Landroid/content/pm/ActivityInfo;
    //   360: getfield packageName : Ljava/lang/String;
    //   363: astore #6
    //   365: aload #5
    //   367: iload_1
    //   368: aaload
    //   369: astore #7
    //   371: aload #7
    //   373: aload #6
    //   375: invokevirtual equals : (Ljava/lang/Object;)Z
    //   378: ifeq -> 492
    //   381: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   384: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   387: aload #7
    //   389: ldc_w '规则2 hit!'
    //   392: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   397: pop
    //   398: aload #7
    //   400: areturn
    //   401: aload_0
    //   402: ifnull -> 477
    //   405: aload_0
    //   406: invokeinterface size : ()I
    //   411: ifle -> 477
    //   414: aload_0
    //   415: iconst_0
    //   416: invokeinterface get : (I)Ljava/lang/Object;
    //   421: checkcast android/content/pm/ResolveInfo
    //   424: getfield activityInfo : Landroid/content/pm/ActivityInfo;
    //   427: getfield packageName : Ljava/lang/String;
    //   430: astore_0
    //   431: aload_0
    //   432: areturn
    //   433: astore_0
    //   434: invokestatic a : ()Lcom/baidu/mobads/b/a;
    //   437: astore #5
    //   439: new java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial <init> : ()V
    //   446: astore #6
    //   448: aload #6
    //   450: ldc_w 'open browser outside failed: '
    //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload #6
    //   459: aload_0
    //   460: invokevirtual toString : ()Ljava/lang/String;
    //   463: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload #5
    //   469: aload #6
    //   471: invokevirtual toString : ()Ljava/lang/String;
    //   474: invokevirtual a : (Ljava/lang/String;)V
    //   477: ldc ''
    //   479: areturn
    //   480: astore_0
    //   481: goto -> 279
    //   484: astore_0
    //   485: goto -> 274
    //   488: astore_0
    //   489: goto -> 269
    //   492: iload_2
    //   493: iconst_1
    //   494: iadd
    //   495: istore_2
    //   496: goto -> 337
    //   499: iload_1
    //   500: iconst_1
    //   501: iadd
    //   502: istore_1
    //   503: goto -> 328
    // Exception table:
    //   from	to	target	type
    //   11	55	433	java/lang/Exception
    //   55	64	433	java/lang/Exception
    //   71	83	433	java/lang/Exception
    //   83	90	433	java/lang/Exception
    //   96	125	433	java/lang/Exception
    //   135	153	480	java/lang/Exception
    //   157	205	484	java/lang/Exception
    //   212	233	488	java/lang/Exception
    //   291	322	433	java/lang/Exception
    //   328	335	433	java/lang/Exception
    //   337	365	433	java/lang/Exception
    //   371	398	433	java/lang/Exception
    //   405	431	433	java/lang/Exception
  }
  
  public static boolean b(Context paramContext, String paramString) {
    return (Build.VERSION.SDK_INT >= 23) ? c(paramContext, paramString) : a(paramContext, paramString);
  }
  
  public static boolean c(Context paramContext, String paramString) {
    try {
      int i = ((Integer)Context.class.getMethod("checkSelfPermission", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString })).intValue();
      return (i == 0);
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return true;
    } 
  }
  
  private String d(Context paramContext, String paramString) {
    String str = "error";
    Object object = str;
    try {
      Object object1 = (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get(paramString);
      object = str;
      StringBuilder stringBuilder = new StringBuilder();
      object = str;
      stringBuilder.append(object1);
      object = str;
      stringBuilder.append("");
      object = str;
      object1 = stringBuilder.toString();
      object = object1;
      if (!object1.trim().equals(""))
        return (String)object1; 
      object = object1;
      throw new Exception();
    } catch (Exception exception) {
      String.format("Could not read %s meta-data from AndroidManifest.xml", new Object[] { paramString });
      return (String)object;
    } 
  }
  
  private String d(String paramString) {
    return getMD5(paramString);
  }
  
  public Object a(Object paramObject, String paramString, Object... paramVarArgs) {
    try {
      Class[] arrayOfClass = new Class[paramVarArgs.length];
      int i;
      for (i = 0; i < arrayOfClass.length; i++)
        arrayOfClass[i] = paramVarArgs[i].getClass(); 
      return a(paramObject, paramString, arrayOfClass).invoke(paramObject, paramVarArgs);
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return null;
    } 
  }
  
  public Object a(String paramString) {
    if (a())
      return null; 
    try {
      HashMap<String, Object> hashMap = this.i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("_E");
      hashMap = (HashMap<String, Object>)hashMap.get(stringBuilder.toString());
      if (hashMap != null) {
        long l = ((Long)hashMap).longValue();
        if (System.currentTimeMillis() < l) {
          hashMap = this.i;
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString);
          stringBuilder.append("_V");
          return hashMap.get(stringBuilder.toString());
        } 
      } 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
    return null;
  }
  
  public String a(List<String> paramList) {
    if (paramList == null || paramList.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramList.size() - 1; i++) {
      stringBuilder.append(paramList.get(i));
      stringBuilder.append(",");
    } 
    stringBuilder.append(paramList.get(paramList.size() - 1));
    return stringBuilder.toString();
  }
  
  public void a(View paramView) {
    if (paramView != null)
      try {
        if (paramView.getParent() != null) {
          ((ViewGroup)paramView.getParent()).removeView(paramView);
          return;
        } 
      } catch (Exception exception) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      }  
  }
  
  public void a(Runnable paramRunnable) {
    if (paramRunnable == null)
      return; 
    try {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramRunnable.run();
        return;
      } 
      (new Handler(Looper.getMainLooper())).post(new k(this, paramRunnable));
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return;
    } 
  }
  
  public void a(String paramString, Object paramObject) {
    if (a())
      return; 
    HashMap<String, Object> hashMap = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("_E");
    hashMap.put(stringBuilder.toString(), Long.valueOf(System.currentTimeMillis() + 5000L));
    hashMap = this.i;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("_V");
    hashMap.put(stringBuilder.toString(), paramObject);
  }
  
  public boolean a() {
    return (Build.VERSION.SDK_INT >= 24);
  }
  
  public JSONArray array2Json(double[] paramArrayOfdouble) {
    JSONArray jSONArray;
    if (paramArrayOfdouble != null) {
      try {
        JSONArray jSONArray1 = new JSONArray();
        int i = 0;
        while (true) {
          jSONArray = jSONArray1;
          try {
            if (i < paramArrayOfdouble.length) {
              jSONArray1.put(paramArrayOfdouble[i]);
              i++;
              continue;
            } 
          } catch (Exception exception) {
            // Byte code: goto -> 45
          } 
          break;
        } 
      } catch (Exception exception) {
        JSONArray jSONArray1 = null;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
        return jSONArray1;
      } 
    } else {
      jSONArray = null;
    } 
    return jSONArray;
  }
  
  public String b() {
    return "android_8.8283_4.0.0";
  }
  
  public String b(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public String base64Encode(String paramString) {
    return XAdSDKFoundationFacade.getInstance().getBase64().encode(paramString);
  }
  
  public boolean bitMaskContainsFlag(int paramInt1, int paramInt2) {
    return ((paramInt1 & paramInt2) != 0);
  }
  
  public void browserOutside(Context paramContext, String paramString) {
    String str = paramString;
    if (paramString.startsWith("wtai://wp/mc;")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("tel:");
      stringBuilder.append(paramString.substring(13));
      str = stringBuilder.toString();
    } 
    try {
      Intent intent1;
      Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
      boolean bool = XAdSDKFoundationFacade.getInstance().getURIUitls().isHttpProtocol(str).booleanValue();
      String str1 = "";
      if (bool) {
        str1 = b(paramContext);
        IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdUtil.browserOutside pkgOfBrowser=");
        stringBuilder.append(str1);
        iXAdLogger.d("Utils", stringBuilder.toString());
        intent1 = intent2;
        if (!str1.equals("")) {
          intent1 = paramContext.getPackageManager().getLaunchIntentForPackage(str1);
          intent1.setData(Uri.parse(str));
          intent1.setAction("android.intent.action.VIEW");
        } 
      } else {
        intent1 = intent2;
        if (((aa)XAdSDKFoundationFacade.getInstance().getURIUitls()).a(str).booleanValue()) {
          int i;
          intent2.setType("vnd.android-dir/mms-sms");
          if (str.indexOf('?') > 0) {
            i = str.indexOf('?');
          } else {
            i = str.length();
          } 
          String str3 = str.substring(4, i);
          intent2.putExtra("address", str3);
          int j = str.indexOf("body=") + 5;
          String str2 = str1;
          if (j > 5) {
            i = str.indexOf('&', j);
            if (i <= 0)
              i = str.length(); 
            str2 = str.substring(j, i);
            intent2.putExtra("sms_body", Uri.decode(str2));
          } 
          XAdSDKFoundationFacade.getInstance().getAdLogger().d(str3, str2);
          intent1 = intent2;
        } 
      } 
      if (paramContext.getPackageManager().resolveActivity(intent1, 65536) != null) {
        paramContext.startActivity(intent1);
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(new Object[] { "XAdCommonUtils.browserOutside 1", str, exception });
      try {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        paramContext.startActivity(intent);
        return;
      } catch (Exception exception1) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d(new Object[] { "XAdCommonUtils.browserOutside 2", str, exception1 });
      } 
    } 
  }
  
  public boolean checkSelfPermission(Context paramContext, String paramString) {
    return c(paramContext, paramString);
  }
  
  public String createRequestId(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(XAdSDKFoundationFacade.getInstance().getSystemUtils().getIMEI(paramContext));
    stringBuilder.append(getAppId(paramContext));
    stringBuilder.append(paramString);
    stringBuilder.append(System.currentTimeMillis());
    return getMD5(stringBuilder.toString());
  }
  
  public String decodeURIComponent(String paramString) {
    if (paramString == null)
      return null; 
    try {
      return URLDecoder.decode(paramString, "UTF-8");
    } catch (Exception exception) {
      return paramString;
    } 
  }
  
  public String encodeURIComponent(String paramString) {
    try {
      return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
    } catch (Exception exception) {
      return paramString;
    } 
  }
  
  public long generateUniqueId() {
    while (true) {
      long l3 = this.f.get();
      long l1 = 1L;
      long l2 = l3 + 1L;
      if (l2 <= 9223372036854775806L)
        l1 = l2; 
      if (this.f.compareAndSet(l3, l1))
        return l3; 
    } 
  }
  
  public int getApkDownloadStatus(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   3: invokevirtual getIoUtils : ()Lcom/baidu/mobads/interfaces/utils/IXAdIOUtils;
    //   6: pop
    //   7: iconst_m1
    //   8: istore #4
    //   10: iload #4
    //   12: istore #5
    //   14: aload_2
    //   15: ifnull -> 416
    //   18: iload #4
    //   20: istore #5
    //   22: ldc ''
    //   24: aload_2
    //   25: invokevirtual equals : (Ljava/lang/Object;)Z
    //   28: ifne -> 416
    //   31: new org/json/JSONObject
    //   34: dup
    //   35: aload_1
    //   36: ldc_w '__sdk_pasys_pkgs_2'
    //   39: iconst_0
    //   40: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   43: ldc_w 'pkgs'
    //   46: ldc_w '{}'
    //   49: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: invokespecial <init> : (Ljava/lang/String;)V
    //   57: aload_2
    //   58: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: astore_3
    //   62: aload_3
    //   63: ifnull -> 96
    //   66: aload_3
    //   67: ldc_w 'a'
    //   70: iconst_0
    //   71: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   74: istore #7
    //   76: iload #7
    //   78: ifeq -> 96
    //   81: bipush #100
    //   83: ireturn
    //   84: astore_3
    //   85: ldc_w 'XAdCommonUtils'
    //   88: aload_3
    //   89: invokevirtual getMessage : ()Ljava/lang/String;
    //   92: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: aload_1
    //   97: ldc_w '__sdk_remote_dl_2'
    //   100: iconst_0
    //   101: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   104: astore_3
    //   105: new java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore #10
    //   114: aload #10
    //   116: aload_2
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload #10
    //   123: ldc_w '#$#'
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #10
    //   132: invokestatic b : ()Ljava/lang/String;
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: new org/json/JSONObject
    //   142: dup
    //   143: aload_3
    //   144: aload #10
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: ldc_w '{}'
    //   152: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: invokespecial <init> : (Ljava/lang/String;)V
    //   160: astore #10
    //   162: aload #10
    //   164: ldc_w 'dl'
    //   167: iconst_m1
    //   168: invokevirtual optInt : (Ljava/lang/String;I)I
    //   171: istore #5
    //   173: aload #10
    //   175: ldc_w 'filename'
    //   178: aconst_null
    //   179: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore #11
    //   184: aload #11
    //   186: ifnull -> 389
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore #12
    //   198: aload #12
    //   200: aload_1
    //   201: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #12
    //   210: aload #11
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: new java/io/File
    //   219: dup
    //   220: aload #12
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokespecial <init> : (Ljava/lang/String;)V
    //   228: astore_1
    //   229: iload #5
    //   231: iconst_3
    //   232: if_icmpne -> 389
    //   235: aload_1
    //   236: invokevirtual exists : ()Z
    //   239: istore #7
    //   241: iconst_1
    //   242: istore #6
    //   244: iload #6
    //   246: istore #4
    //   248: iload #7
    //   250: ifeq -> 322
    //   253: aload_1
    //   254: invokevirtual length : ()J
    //   257: lconst_0
    //   258: lcmp
    //   259: ifne -> 269
    //   262: iload #6
    //   264: istore #4
    //   266: goto -> 322
    //   269: aload #10
    //   271: ldc_w 'contentLength'
    //   274: ldc2_w -1
    //   277: invokevirtual optLong : (Ljava/lang/String;J)J
    //   280: lstore #8
    //   282: lload #8
    //   284: ldc2_w -1
    //   287: lcmp
    //   288: ifeq -> 319
    //   291: lload #8
    //   293: aload_1
    //   294: invokevirtual length : ()J
    //   297: lsub
    //   298: invokestatic abs : (J)J
    //   301: lstore #8
    //   303: lload #8
    //   305: ldc2_w 2
    //   308: lcmp
    //   309: iflt -> 319
    //   312: iload #6
    //   314: istore #4
    //   316: goto -> 322
    //   319: iconst_0
    //   320: istore #4
    //   322: iload #4
    //   324: ifeq -> 389
    //   327: aload #10
    //   329: ldc_w 'dl'
    //   332: iconst_5
    //   333: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   336: pop
    //   337: aload_3
    //   338: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   343: astore_1
    //   344: aload_1
    //   345: aload_2
    //   346: aload #10
    //   348: invokevirtual toString : ()Ljava/lang/String;
    //   351: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   356: pop
    //   357: getstatic android/os/Build$VERSION.SDK_INT : I
    //   360: bipush #9
    //   362: if_icmplt -> 373
    //   365: aload_1
    //   366: invokeinterface apply : ()V
    //   371: iconst_5
    //   372: ireturn
    //   373: aload_1
    //   374: invokeinterface commit : ()Z
    //   379: pop
    //   380: iconst_5
    //   381: ireturn
    //   382: astore_1
    //   383: iconst_5
    //   384: istore #4
    //   386: goto -> 401
    //   389: iload #5
    //   391: ireturn
    //   392: astore_1
    //   393: iload #5
    //   395: istore #4
    //   397: goto -> 401
    //   400: astore_1
    //   401: ldc_w 'XAdCommonUtils'
    //   404: aload_1
    //   405: invokevirtual getMessage : ()Ljava/lang/String;
    //   408: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: iload #4
    //   414: istore #5
    //   416: iload #5
    //   418: ireturn
    // Exception table:
    //   from	to	target	type
    //   31	62	84	java/lang/Exception
    //   66	76	84	java/lang/Exception
    //   96	173	400	java/lang/Exception
    //   173	184	392	java/lang/Exception
    //   189	229	392	java/lang/Exception
    //   235	241	392	java/lang/Exception
    //   253	262	392	java/lang/Exception
    //   269	282	392	java/lang/Exception
    //   291	303	392	java/lang/Exception
    //   327	371	382	java/lang/Exception
    //   373	380	382	java/lang/Exception
  }
  
  public String getApkFileLocalPath(Context paramContext, String paramString) {
    try {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("__sdk_remote_dl_2", 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("#$#");
      stringBuilder.append(a.b());
      String str = sharedPreferences.getString(stringBuilder.toString(), "");
      if (!TextUtils.isEmpty(str)) {
        JSONObject jSONObject = new JSONObject(str);
        str = jSONObject.optString("folder");
        String str1 = jSONObject.optString("filename");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str1)) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append(str1);
          return stringBuilder.toString();
        } 
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
    } 
    return "";
  }
  
  public String getAppId(Context paramContext) {
    try {
      if (a == null)
        a = d(paramContext, "BaiduMobAd_APP_ID"); 
      return a;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getAppPackage(Context paramContext) {
    return paramContext.getPackageName();
  }
  
  public String getAppSec(Context paramContext) {
    String str = c;
    if (str == null || str.length() == 0 || c.startsWith("null"))
      setAppSec(getAppId(paramContext)); 
    return c;
  }
  
  public String getBaiduMapsInfo(Context paramContext) {
    if (paramContext != null) {
      String str = paramContext.getApplicationContext().getPackageName();
    } else {
      paramContext = null;
    } 
    if (TextUtils.isEmpty(h))
      e.a((e.c)new j(this, (String)paramContext)); 
    return h;
  }
  
  public String getChannelId() {
    return d;
  }
  
  public String getDebugToken(Context paramContext) {
    try {
      if (b == null)
        b = d(paramContext, "BaiduMobAd_DEBUG_TOKEN"); 
      return b;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public DisplayMetrics getDisplayMetrics(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
      return displayMetrics;
    } 
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics;
  }
  
  public String getFileLocalFullPath(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a(paramContext));
      stringBuilder.append(File.separator);
      stringBuilder.append(d(paramString));
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public String getLocationInfo(Context paramContext) {
    return getBaiduMapsInfo(paramContext);
  }
  
  public int getLogicalPixel(Context paramContext, int paramInt) {
    float f = paramInt;
    try {
      float f1 = getScreenDensity(paramContext);
      return (int)(f / f1);
    } catch (Exception exception) {
      return paramInt;
    } 
  }
  
  public String getMD5(String paramString) {
    int i;
    int j;
    char[] arrayOfChar2;
    byte[] arrayOfByte = paramString.getBytes();
    char[] arrayOfChar1 = new char[16];
    arrayOfChar1[0] = '0';
    arrayOfChar1[1] = '1';
    arrayOfChar1[2] = '2';
    arrayOfChar1[3] = '3';
    arrayOfChar1[4] = '4';
    arrayOfChar1[5] = '5';
    arrayOfChar1[6] = '6';
    arrayOfChar1[7] = '7';
    arrayOfChar1[8] = '8';
    arrayOfChar1[9] = '9';
    arrayOfChar1[10] = 'a';
    arrayOfChar1[11] = 'b';
    arrayOfChar1[12] = 'c';
    arrayOfChar1[13] = 'd';
    arrayOfChar1[14] = 'e';
    arrayOfChar1[15] = 'f';
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(arrayOfByte);
      arrayOfByte = messageDigest.digest();
      arrayOfChar2 = new char[32];
      i = 0;
      j = 0;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "AdUtil.getMD5", "", noSuchAlgorithmException });
      return null;
    } 
    while (true) {
      if (i < 16) {
        byte b = arrayOfByte[i];
        int k = j + 1;
        arrayOfChar2[j] = noSuchAlgorithmException[b >>> 4 & 0xF];
        j = k + 1;
        arrayOfChar2[k] = noSuchAlgorithmException[b & 0xF];
        i++;
        continue;
      } 
      return new String(arrayOfChar2);
    } 
  }
  
  public int getPixel(Context paramContext, int paramInt) {
    float f = paramInt;
    try {
      float f1 = getScreenDensity(paramContext);
      return (int)(f * f1);
    } catch (Exception exception) {
      return paramInt;
    } 
  }
  
  public float getScreenDensity(Context paramContext) {
    return (getDisplayMetrics(paramContext)).density;
  }
  
  public Rect getScreenRect(Context paramContext) {
    DisplayMetrics displayMetrics = getDisplayMetrics(paramContext);
    try {
      return (displayMetrics.widthPixels > displayMetrics.heightPixels) ? new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels) : new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String getStatusStr(Context paramContext, String paramString1, String paramString2) {
    boolean bool;
    r r = XAdSDKFoundationFacade.getInstance().getPackageUtils();
    try {
      int i = getApkDownloadStatus(paramContext, paramString1, paramString2);
      bool = r.isInstalled(paramContext, paramString1);
      if (i != 0 && i != 1) {
        if (i != 2)
          if (i != 3) {
            if (i != 4) {
              if (i != 5) {
                if (i != 100)
                  return bool ? "INSTALLED_BY_OTHER" : "NONE"; 
              } else {
                return bool ? "DONE" : "NONE";
              } 
              return "DONE";
            } 
          } else {
            String str;
            if (bool) {
              str = "INSTALLED";
            } else {
              str = "DOWNLOADED";
            } 
            return str;
          }  
        return bool ? "INSTALLED_BY_OTHER" : "DOWNLOAD_FAILED";
      } 
    } catch (Exception exception) {
      return "NONE";
    } 
    return bool ? "INSTALLED_BY_OTHER" : "DOWNLOADING";
  }
  
  public String getSubscriberId(Context paramContext) {
    return "";
  }
  
  public String getTextEncoder(String paramString) {
    if (paramString != null) {
      if ("".equals(paramString))
        return ""; 
      try {
        return URLEncoder.encode(paramString, "UTF-8");
      } catch (UnsupportedEncodingException|NullPointerException unsupportedEncodingException) {
        return paramString;
      } 
    } 
    return "";
  }
  
  public Rect getWindowRect(Context paramContext) {
    DisplayMetrics displayMetrics = getDisplayMetrics(paramContext);
    return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
  }
  
  public boolean hasPermission(Context paramContext, String paramString) {
    return a(paramContext, paramString);
  }
  
  public boolean hasSupportedApps(Context paramContext, int paramInt) {
    try {
      Intent intent;
      IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              if (paramInt != 4)
                return false; 
              intent = new Intent("android.intent.action.EDIT");
              intent.setType("vnd.android.cursor.item/event");
            } else {
              if (intent.canSupportSdcardStroage(paramContext)) {
                XAdSDKFoundationFacade.getInstance().getPackageUtils();
                if (r.b(paramContext))
                  return true; 
              } 
              return false;
            } 
          } else {
            return (XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(paramContext, "android.permission.ACCESS_WIFI_STATE") && XAdSDKFoundationFacade.getInstance().getCommonUtils().hasPermission(paramContext, "android.permission.CHANGE_WIFI_STATE"));
          } 
        } else {
          intent = new Intent("android.intent.action.SENDTO");
          intent.setData(Uri.parse("sms:12345678"));
        } 
      } else {
        intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:baidumobadstest@baidu.com"));
      } 
      new ArrayList();
      List list = paramContext.getPackageManager().queryIntentActivities(intent, 64);
      if (list != null && list.size() > 0) {
        boolean bool = ((ResolveInfo)list.get(0)).activityInfo.packageName.equals("com.android.fallback");
        if (!bool)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void installApp(Context paramContext, String paramString, File paramFile, boolean paramBoolean) {
    try {
      XAdSDKFoundationFacade.getInstance().getPackageUtils().b(paramContext, paramFile);
      if (paramBoolean && paramString != null && paramString != null && !paramString.equals("")) {
        a a1 = new a(paramString, "");
        a1.l = true;
        a a = new a(a1);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        paramContext.registerReceiver((BroadcastReceiver)a, intentFilter);
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
    } 
  }
  
  public boolean isOldPermissionModel() {
    return (Build.VERSION.SDK_INT < 23);
  }
  
  public boolean isStringAvailable(String paramString) {
    return (paramString != null && paramString.length() > 0);
  }
  
  public JSONArray list2Json(List<String[]> paramList) {
    JSONArray jSONArray = new JSONArray();
    int i = 0;
    try {
      while (i < paramList.size()) {
        JSONArray jSONArray1 = new JSONArray();
        for (int j = 0; j < ((String[])paramList.get(i)).length; j++)
          jSONArray1.put(((String[])paramList.get(i))[j]); 
        jSONArray.put(jSONArray1);
        i++;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
    } 
    return jSONArray;
  }
  
  public String md5(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = messageDigest.digest();
      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfByte.length; i++) {
        for (paramString = Integer.toHexString(arrayOfByte[i] & 0xFF); paramString.length() < 2; paramString = stringBuilder.toString()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("0");
          stringBuilder.append(paramString);
        } 
        stringBuffer.append(paramString);
      } 
      return stringBuffer.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return "";
    } 
  }
  
  public void sendDownloadAdLog(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2) {
    try {
      IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
      IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
      IBase64 iBase64 = XAdSDKFoundationFacade.getInstance().getBase64();
      StringBuilder stringBuilder3 = new StringBuilder();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("msg=");
      stringBuilder4.append(paramString1);
      stringBuilder3.append(stringBuilder4.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&prod=");
      stringBuilder2.append(paramString2);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&pk=");
      stringBuilder2.append(paramString3);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&appid=");
      stringBuilder2.append(paramString4);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&apid=");
      stringBuilder2.append(paramString5);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&brand=");
      stringBuilder2.append(paramString6);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&tp=");
      stringBuilder2.append(paramString7);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&osv=");
      stringBuilder2.append(paramString8);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&bdr=");
      stringBuilder2.append(paramInt2);
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&sn=");
      stringBuilder2.append(iXAdSystemUtils.getEncodedSN(paramContext));
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&mac=");
      stringBuilder2.append(iBase64.encode(iXAdSystemUtils.getMacAddress(paramContext)));
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&cuid=");
      stringBuilder2.append(iBase64.encode(iXAdSystemUtils.getCUID(paramContext)));
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&pack=");
      stringBuilder2.append(paramContext.getPackageName());
      stringBuilder3.append(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("&v=");
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("android_");
      stringBuilder2.append(a.c);
      stringBuilder2.append("_");
      stringBuilder2.append("4.1.30");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder3.append(stringBuilder1.toString());
      String str = stringBuilder3.toString();
      try {
        b b = new b(iXAdURIUitls.addParameters(vdUrl(str, paramInt1), null), "");
        b.e = 1;
        (new a()).a(b);
        return;
      } catch (Exception null) {}
    } catch (Exception exception) {}
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
  }
  
  public void sendDownloadAdLog(Context paramContext, String paramString1, int paramInt, String paramString2) {}
  
  public void sendSMS(Context paramContext, String paramString1, String paramString2) {
    try {
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.putExtra("address", paramString1);
      intent.putExtra("sms_body", paramString2);
      intent.setType("vnd.android-dir/mms-sms");
      intent.addFlags(268435456);
      a(paramContext, intent);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return;
    } 
  }
  
  public void setAppId(String paramString) {
    a = paramString;
  }
  
  public void setAppSec(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("_cpr");
    c = stringBuilder.toString();
  }
  
  public void setChannelId(String paramString) {
    d = paramString;
  }
  
  public String vdUrl(String paramString, int paramInt) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   3: invokevirtual getURIUitls : ()Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   6: pop
    //   7: new org/json/JSONObject
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore #5
    //   16: aload_1
    //   17: aload_1
    //   18: ldc_w '?'
    //   21: invokevirtual indexOf : (Ljava/lang/String;)I
    //   24: iconst_1
    //   25: iadd
    //   26: invokevirtual substring : (I)Ljava/lang/String;
    //   29: ldc_w '&'
    //   32: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore_1
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: aload_1
    //   40: arraylength
    //   41: if_icmpge -> 119
    //   44: aload_1
    //   45: iload_3
    //   46: aaload
    //   47: ldc_w '='
    //   50: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   53: astore #6
    //   55: aload #6
    //   57: iconst_0
    //   58: aaload
    //   59: ldc_w 'type'
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifne -> 112
    //   68: aload #6
    //   70: arraylength
    //   71: iconst_1
    //   72: if_icmple -> 92
    //   75: aload #5
    //   77: aload #6
    //   79: iconst_0
    //   80: aaload
    //   81: aload #6
    //   83: iconst_1
    //   84: aaload
    //   85: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: goto -> 112
    //   92: aload #6
    //   94: arraylength
    //   95: iconst_1
    //   96: if_icmpne -> 112
    //   99: aload #5
    //   101: aload #6
    //   103: iconst_0
    //   104: aaload
    //   105: ldc_w 'null'
    //   108: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: iload_3
    //   113: iconst_1
    //   114: iadd
    //   115: istore_3
    //   116: goto -> 38
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore_1
    //   127: aload_1
    //   128: ldc_w 'type='
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: iload_2
    //   137: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc_w '&'
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: aload_1
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: invokespecial <init> : (Ljava/lang/String;)V
    //   160: astore #8
    //   162: new java/util/TreeMap
    //   165: dup
    //   166: invokespecial <init> : ()V
    //   169: astore #9
    //   171: new java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial <init> : ()V
    //   178: astore #10
    //   180: aload #5
    //   182: invokevirtual keys : ()Ljava/util/Iterator;
    //   185: astore_1
    //   186: aload_1
    //   187: invokeinterface hasNext : ()Z
    //   192: istore #4
    //   194: iload #4
    //   196: ifeq -> 248
    //   199: aload_1
    //   200: invokeinterface next : ()Ljava/lang/Object;
    //   205: checkcast java/lang/String
    //   208: astore #6
    //   210: aload #6
    //   212: ifnull -> 186
    //   215: aload #6
    //   217: ldc ''
    //   219: invokevirtual equals : (Ljava/lang/Object;)Z
    //   222: ifeq -> 228
    //   225: goto -> 186
    //   228: aload #9
    //   230: aload #6
    //   232: aload #5
    //   234: aload #6
    //   236: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   239: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: goto -> 186
    //   248: new java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial <init> : ()V
    //   255: astore_1
    //   256: aload_1
    //   257: invokestatic currentTimeMillis : ()J
    //   260: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_1
    //   265: ldc ''
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #9
    //   273: ldc_w 'ts'
    //   276: aload_1
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: aload #9
    //   288: invokeinterface keySet : ()Ljava/util/Set;
    //   293: invokeinterface iterator : ()Ljava/util/Iterator;
    //   298: astore #11
    //   300: aload #11
    //   302: invokeinterface hasNext : ()Z
    //   307: ifeq -> 471
    //   310: aload #11
    //   312: invokeinterface next : ()Ljava/lang/Object;
    //   317: checkcast java/lang/String
    //   320: astore #7
    //   322: aload #9
    //   324: aload #7
    //   326: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast java/lang/String
    //   334: astore #6
    //   336: aload #7
    //   338: ifnull -> 300
    //   341: aload #6
    //   343: ifnull -> 300
    //   346: aload #7
    //   348: astore #5
    //   350: aload #6
    //   352: astore_1
    //   353: aload #7
    //   355: ldc_w 'targetscheme'
    //   358: invokevirtual equals : (Ljava/lang/Object;)Z
    //   361: ifne -> 379
    //   364: aload_0
    //   365: aload #7
    //   367: invokevirtual encodeURIComponent : (Ljava/lang/String;)Ljava/lang/String;
    //   370: astore #5
    //   372: aload_0
    //   373: aload #6
    //   375: invokevirtual encodeURIComponent : (Ljava/lang/String;)Ljava/lang/String;
    //   378: astore_1
    //   379: new java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial <init> : ()V
    //   386: astore #6
    //   388: aload #6
    //   390: aload #5
    //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload #6
    //   398: ldc_w '='
    //   401: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload #6
    //   407: aload_1
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload #6
    //   414: ldc_w '&'
    //   417: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload #8
    //   423: aload #6
    //   425: invokevirtual toString : ()Ljava/lang/String;
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: new java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: astore #5
    //   441: aload #5
    //   443: aload_1
    //   444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload #5
    //   450: ldc_w ','
    //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload #10
    //   459: aload #5
    //   461: invokevirtual toString : ()Ljava/lang/String;
    //   464: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: goto -> 300
    //   471: aload #10
    //   473: ldc_w 'mobads,'
    //   476: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_0
    //   481: aload #10
    //   483: invokevirtual toString : ()Ljava/lang/String;
    //   486: invokevirtual getMD5 : (Ljava/lang/String;)Ljava/lang/String;
    //   489: astore_1
    //   490: new java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial <init> : ()V
    //   497: astore #5
    //   499: aload #5
    //   501: ldc_w 'vd='
    //   504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload #5
    //   510: aload_1
    //   511: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload #5
    //   517: ldc_w '&'
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload #8
    //   526: aload #5
    //   528: invokevirtual toString : ()Ljava/lang/String;
    //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: new java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial <init> : ()V
    //   542: astore_1
    //   543: aload_1
    //   544: ldc_w 'https://mobads-logs.baidu.com/dz.zb?'
    //   547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_1
    //   552: aload #8
    //   554: invokevirtual toString : ()Ljava/lang/String;
    //   557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_1
    //   562: invokevirtual toString : ()Ljava/lang/String;
    //   565: areturn
    //   566: astore #6
    //   568: goto -> 112
    //   571: astore_1
    //   572: goto -> 248
    //   575: astore #6
    //   577: goto -> 186
    // Exception table:
    //   from	to	target	type
    //   44	89	566	java/lang/Exception
    //   92	112	566	java/lang/Exception
    //   180	186	571	java/lang/Exception
    //   186	194	571	java/lang/Exception
    //   199	210	575	java/lang/Exception
    //   215	225	575	java/lang/Exception
    //   228	245	575	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
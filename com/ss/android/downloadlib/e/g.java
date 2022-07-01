package com.ss.android.downloadlib.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.a.a.a.l;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a.b.b;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.e.a;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
  static final char[] a;
  
  private static Object[] b = new Object[0];
  
  private static Object[] c = new Object[73];
  
  private static String d;
  
  static {
    a = new char[] { 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f' };
    d = null;
  }
  
  public static int a(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).applicationInfo.targetSdkVersion;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return 0;
    } 
  }
  
  public static int a(String paramString1, String paramString2) {
    String[] arrayOfString;
    int j;
    try {
      if (!TextUtils.isEmpty(paramString1)) {
        if (TextUtils.isEmpty(paramString2))
          return -2; 
        if (paramString1.equals(paramString2))
          return 0; 
        String[] arrayOfString1 = paramString1.split("\\.");
        arrayOfString = paramString2.split("\\.");
        int m = Math.min(arrayOfString1.length, arrayOfString.length);
        i = 0;
        j = 0;
        while (i < m) {
          int n = Integer.parseInt(arrayOfString1[i]) - Integer.parseInt(arrayOfString[i]);
          j = n;
          if (n == 0) {
            i++;
            j = n;
          } 
        } 
      } else {
        return -2;
      } 
    } catch (Exception exception) {
      return -2;
    } 
    int k = -1;
    if (j == 0)
      for (k = i;; k++) {
        j = i;
        if (k < exception.length) {
          if (Integer.parseInt((String)exception[k]) > 0)
            return 1; 
        } else {
          while (j < arrayOfString.length) {
            i = Integer.parseInt(arrayOfString[j]);
            if (i > 0)
              return -1; 
            j++;
          } 
          return 0;
        } 
      }  
    int i = k;
    if (j > 0)
      i = 1; 
    return i;
  }
  
  public static long a(JSONObject paramJSONObject, String paramString) {
    if (paramJSONObject == null)
      return 0L; 
    try {
      return Long.valueOf(paramJSONObject.optString(paramString)).longValue();
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  public static Drawable a(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return null; 
      PackageManager packageManager = paramContext.getPackageManager();
      PackageInfo packageInfo = packageManager.getPackageArchiveInfo(paramString, 0);
      if (packageInfo != null) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = paramString;
        applicationInfo.publicSourceDir = paramString;
        try {
          return applicationInfo.loadIcon(packageManager);
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
    return null;
  }
  
  public static b a(String paramString1, int paramInt, String paramString2) {
    b b = new b();
    if (TextUtils.isEmpty(paramString1))
      return b; 
    try {
      PackageInfo packageInfo = j.a().getPackageManager().getPackageInfo(paramString1, 0);
      if (packageInfo != null) {
        b.a(b.b);
        l l = j.h();
        if (l != null && l.a() && !a(packageInfo.versionCode, paramInt, packageInfo.versionName, paramString2))
          b.a(b.c); 
      } 
      return b;
    } catch (Exception exception) {
      return b;
    } 
  }
  
  public static <T> T a(T... paramVarArgs) {
    if (paramVarArgs != null) {
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        T t = paramVarArgs[i];
        if (t != null)
          return t; 
      } 
      throw new IllegalArgumentException("args is null");
    } 
    throw new IllegalArgumentException("args is null");
  }
  
  public static String a(File paramFile) {
    // Byte code:
    //   0: ldc 'MD5'
    //   2: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/io/File;)V
    //   20: astore_0
    //   21: sipush #8192
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: iconst_0
    //   30: aload_3
    //   31: arraylength
    //   32: invokevirtual read : ([BII)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle -> 50
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: iload_1
    //   44: invokevirtual update : ([BII)V
    //   47: goto -> 27
    //   50: aload_2
    //   51: invokevirtual digest : ()[B
    //   54: invokestatic a : ([B)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_0
    //   59: invokevirtual close : ()V
    //   62: aload_2
    //   63: areturn
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual printStackTrace : ()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_3
    //   72: aload_0
    //   73: astore_2
    //   74: aload_3
    //   75: astore_0
    //   76: goto -> 82
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull -> 98
    //   86: aload_2
    //   87: invokevirtual close : ()V
    //   90: goto -> 98
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual printStackTrace : ()V
    //   98: aload_0
    //   99: athrow
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull -> 117
    //   106: aload_0
    //   107: invokevirtual close : ()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual printStackTrace : ()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: goto -> 100
    //   123: astore_2
    //   124: goto -> 102
    // Exception table:
    //   from	to	target	type
    //   0	6	119	java/lang/Exception
    //   0	6	79	finally
    //   12	21	119	java/lang/Exception
    //   12	21	79	finally
    //   21	27	123	java/lang/Exception
    //   21	27	71	finally
    //   27	36	123	java/lang/Exception
    //   27	36	71	finally
    //   40	47	123	java/lang/Exception
    //   40	47	71	finally
    //   50	58	123	java/lang/Exception
    //   50	58	71	finally
    //   58	62	64	java/io/IOException
    //   86	90	93	java/io/IOException
    //   106	110	112	java/io/IOException
  }
  
  public static String a(String paramString, int paramInt) {
    if (paramInt == 0)
      return ""; 
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.length() <= paramInt)
        return paramString; 
      str = paramString.substring(0, paramInt);
    } 
    return str;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null)
      return a(paramArrayOfbyte, 0, paramArrayOfbyte.length); 
    throw new NullPointerException("bytes is null");
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      if (paramInt1 >= 0 && paramInt1 + paramInt2 <= paramArrayOfbyte.length) {
        int k = paramInt2 * 2;
        char[] arrayOfChar = new char[k];
        int i = 0;
        int j = 0;
        while (i < paramInt2) {
          int m = paramArrayOfbyte[i + paramInt1] & 0xFF;
          int n = j + 1;
          char[] arrayOfChar1 = a;
          arrayOfChar[j] = arrayOfChar1[m >> 4];
          j = n + 1;
          arrayOfChar[n] = arrayOfChar1[m & 0xF];
          i++;
        } 
        return new String(arrayOfChar, 0, k);
      } 
      throw new IndexOutOfBoundsException();
    } 
    throw new NullPointerException("bytes is null");
  }
  
  public static String a(String... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str))
        return str; 
    } 
    return "ERROR";
  }
  
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    if (paramJSONObject1 != null && paramJSONObject2 != null)
      try {
        Iterator<String> iterator = paramJSONObject1.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          paramJSONObject2.put(str, paramJSONObject1.get(str));
        } 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
    return paramJSONObject2;
  }
  
  public static JSONObject a(JSONObject... paramVarArgs) {
    JSONObject jSONObject = new JSONObject();
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0)
        return jSONObject; 
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        JSONObject jSONObject1 = paramVarArgs[i];
        if (jSONObject1 != null)
          a(jSONObject1, jSONObject); 
      } 
    } 
    return jSONObject;
  }
  
  public static void a(Activity paramActivity) {
    if (paramActivity != null && !paramActivity.isFinishing())
      paramActivity.finish(); 
  }
  
  public static void a(Throwable paramThrowable) {
    a a = new a(1, b(paramThrowable));
    j.g().a(null, a, 1);
  }
  
  public static boolean a() {
    return (Looper.myLooper() == Looper.getMainLooper());
  }
  
  private static boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2) {
    return (paramInt2 == 0 && TextUtils.isEmpty(paramString2)) ? true : ((paramInt2 > 0 && paramInt1 >= paramInt2) ? true : ((a(paramString1, paramString2) >= 0)));
  }
  
  public static boolean a(Context paramContext, Intent paramIntent) {
    boolean bool = false;
    try {
      List list = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
      boolean bool1 = bool;
      if (list != null) {
        boolean bool2 = list.isEmpty();
        bool1 = bool;
        if (!bool2)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return false; 
      try {
        File file = new File(paramString1);
        if (file.exists()) {
          PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0);
          if (packageInfo == null)
            return false; 
          if (!packageInfo.packageName.equals(paramString2))
            return false; 
          int i = packageInfo.versionCode;
          try {
            PackageInfo packageInfo1 = paramContext.getPackageManager().getPackageInfo(paramString2, 0);
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException = null;
          } 
          if (nameNotFoundException == null)
            return false; 
          int j = ((PackageInfo)nameNotFoundException).versionCode;
          if (i == j)
            return true; 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return false;
  }
  
  public static boolean a(c paramc) {
    return (paramc == null) ? false : a(paramc.t(), paramc.p(), paramc.q()).a();
  }
  
  public static boolean a(a parama) {
    return (parama == null) ? false : a(parama.d(), parama.i(), parama.j()).a();
  }
  
  public static boolean a(a parama) {
    if (parama == null)
      return false; 
    int i = parama.a();
    String str = parama.getMessage();
    return (i == 1006 || i == 1052 || ((i == 1023 || i == 1039 || i == 1040 || i == 1036) && !TextUtils.isEmpty(str) && str.contains("ENOSPC (No space left on device)")));
  }
  
  public static boolean a(String paramString) {
    return !TextUtils.isEmpty(paramString) ? (new File(paramString)).exists() : false;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, String paramString) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte2, paramString);
    Mac mac = Mac.getInstance(paramString);
    mac.init(secretKeySpec);
    return mac.doFinal(paramArrayOfbyte1);
  }
  
  public static Drawable b(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        PackageManager packageManager = paramContext.getPackageManager();
        return packageManager.getApplicationInfo(paramString, 0).loadIcon(packageManager);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {} 
    return null;
  }
  
  public static String b(Throwable paramThrowable) {
    if (paramThrowable == null)
      return null; 
    try {
      StringWriter stringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(stringWriter));
      return stringWriter.toString();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static void b() {
    a(new Throwable());
  }
  
  public static boolean b(Context paramContext, Intent paramIntent) {
    boolean bool2 = false;
    if (paramIntent == null)
      return false; 
    Context context = paramContext;
    if (paramContext == null)
      context = j.a(); 
    List list = context.getPackageManager().queryIntentActivities(paramIntent, 65536);
    boolean bool1 = bool2;
    if (list != null) {
      bool1 = bool2;
      if (list.size() > 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean b(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ((new File(paramString)).exists());
  }
  
  public static boolean c(Context paramContext, String paramString) {
    Context context = paramContext;
    if (paramContext == null)
      context = j.a(); 
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (context != null) {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString)) {
        PackageManager packageManager = context.getPackageManager();
        try {
          PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 0);
          bool1 = bool2;
          if (packageInfo != null)
            bool1 = true; 
          return bool1;
        } catch (Exception exception) {
          return false;
        } 
      } 
    } 
    return bool1;
  }
  
  public static boolean c(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : (paramString.startsWith("http://ad.toutiao.com/advertiser_package/") ? true : (paramString.startsWith("https://ad.toutiao.com/advertiser_package/") ? true : d(paramString)));
  }
  
  public static boolean d(Context paramContext, String paramString) {
    if (paramContext != null && paramString != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        File file = new File(paramString);
        if (file.exists()) {
          PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0);
          if (packageInfo == null)
            return false; 
          String str = packageInfo.packageName;
          int i = packageInfo.versionCode;
          try {
            PackageInfo packageInfo1 = paramContext.getPackageManager().getPackageInfo(str, 0);
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException = null;
          } 
          if (nameNotFoundException == null)
            return false; 
          int j = ((PackageInfo)nameNotFoundException).versionCode;
          if (i <= j)
            return true; 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return false;
  }
  
  public static boolean d(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : (paramString.startsWith("http://lf3-ttcdn-tos.pstatp.com/") ? true : (paramString.startsWith("https://lf3-ttcdn-tos.pstatp.com/")));
  }
  
  public static Intent e(Context paramContext, String paramString) {
    Intent intent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (intent == null)
      return null; 
    if (!intent.hasCategory("android.intent.category.LAUNCHER"))
      intent.addCategory("android.intent.category.LAUNCHER"); 
    intent.setPackage(null);
    intent.addFlags(2097152);
    intent.addFlags(268435456);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.tencent.tbs.sdk.extension.partner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import com.tencent.tbs.sdk.extension.a;
import com.tencent.tbs.sdk.extension.b;
import com.tencent.tbs.sdk.extension.c;
import com.tencent.tbs.sdk.extension.f;
import com.tencent.tbs.sdk.extension.partner.a.a;
import com.tencent.tbs.sdk.extension.partner.c.b;
import com.tencent.tbs.sdk.extension.partner.c.c;
import com.tencent.tbs.sdk.extension.partner.c.e;
import com.tencent.tbs.sdk.extension.partner.c.g;
import com.tencent.tbs.sdk.extension.partner.debugtbs.a;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a;
import com.tencent.tbs.sdk.extension.partner.lzma.a;
import com.tencent.tbs.sdk.extension.partner.precheck.TbsCrashHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class PartnerSDKExtensionServiceImpl implements b, c {
  private static final Lock b = new ReentrantLock();
  
  private static final Lock c = new ReentrantLock();
  
  boolean a = true;
  
  private final boolean d = true;
  
  private Context e;
  
  private Context f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private long i = 0L;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private int l = -1;
  
  private TbsCrashHandler m = null;
  
  private int n = -1;
  
  private String o = "";
  
  private String p = null;
  
  private String q = null;
  
  private boolean r = false;
  
  private boolean s = false;
  
  private String t;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public PartnerSDKExtensionServiceImpl(Context paramContext1, Context paramContext2, String paramString) {
    if (paramContext1 != null)
      if (paramContext1.getApplicationContext() != null) {
        this.e = paramContext1.getApplicationContext();
      } else {
        this.e = paramContext1;
      }  
    if (paramContext2 != null) {
      Context context = paramContext2;
      if (paramContext2.getApplicationContext() != null)
        context = paramContext2.getApplicationContext(); 
      this.f = context;
    } 
    this.t = paramString;
    try {
      StringBuilder stringBuilder;
      if (d(this.e)) {
        this.s = true;
        boolean bool = e(this.e);
        if (this.a) {
          a.a().b(paramContext1);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("processCommandFromTbsSuitIfNeed:");
          stringBuilder1.append(a.a().c());
          stringBuilder1.append(",");
          stringBuilder1.append(a.a().d());
          g.a("TbsSDKExtension", stringBuilder1.toString());
        } 
        if (!bool) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("disable CrashHandler for ");
          stringBuilder.append(this.e);
          stringBuilder.toString();
          return;
        } 
      } 
      if (Build.VERSION.SDK_INT <= 28)
        f(); 
      e();
      c((Context)stringBuilder);
      return;
    } catch (Throwable null) {
      if (!(throwable instanceof f))
        try {
          g(510);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("510, TbsCrashHandler.getInstance exception: ");
          stringBuilder.append(Log.getStackTraceString(throwable));
          b(stringBuilder.toString());
          return;
        } catch (Throwable throwable) {
          throwable.printStackTrace();
          return;
        }  
      try {
        g(512);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("512, TbsCrashHandler exception: ");
        stringBuilder.append(throwable);
        b(stringBuilder.toString());
        a.c(this.e);
      } catch (Throwable throwable1) {
        throwable1.printStackTrace();
      } 
      throw (f)throwable;
    } 
  }
  
  static File a(Context paramContext) {
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "core_private");
    return (!file.isDirectory() && !file.mkdir()) ? null : file;
  }
  
  private File a(Context paramContext, String paramString) {
    File file = b(paramContext);
    if (file == null)
      return null; 
    file = new File(file, paramString);
    if (file.exists())
      return file; 
    try {
      file.createNewFile();
      return file;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return null;
    } 
  }
  
  public static void a(File paramFile) {
    if (paramFile != null) {
      if (!paramFile.exists())
        return; 
      if (paramFile.isFile()) {
        paramFile.delete();
        return;
      } 
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
        return; 
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++)
        a(arrayOfFile[i]); 
      paramFile.delete();
    } 
  }
  
  private void a(String paramString, int paramInt) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[TbsSDKExtension.readResponse] response=");
    stringBuilder2.append(paramString);
    stringBuilder2.toString();
    if (TextUtils.isEmpty(paramString))
      return; 
    JSONObject jSONObject = new JSONObject(paramString);
    if (jSONObject.getInt("RET") != 0)
      return; 
    c c1 = c.a(this.e);
    int k = jSONObject.getInt("USEX5");
    if (2 == k)
      return; 
    a(jSONObject);
    int m = jSONObject.getInt("TBSAPKSERVERVERSION");
    byte b1 = -1;
    stringBuilder2 = null;
    int j = b1;
    StringBuilder stringBuilder1 = stringBuilder2;
    int i = b1;
    try {
      if (jSONObject.opt("CMD_ID") != null) {
        j = b1;
        stringBuilder1 = stringBuilder2;
        i = b1;
        if (jSONObject.opt("CMD_ARGS") != null) {
          i = b1;
          j = jSONObject.getInt("CMD_ID");
          i = j;
          String str = jSONObject.getString("CMD_ARGS");
        } 
      } 
    } catch (Exception exception) {
      j = i;
      stringBuilder1 = stringBuilder2;
    } 
    b(j, (String)stringBuilder1);
    if (d(this.e) && m > paramInt) {
      c1.a(m, Boolean.valueOf(false));
      this.g = false;
    } else {
      boolean bool = true;
      if (k == 1)
        bool = false; 
      this.g = bool;
      c1.a(paramInt, Boolean.valueOf(this.g));
    } 
    m();
    if (this.g)
      d("044800"); 
    c1.o();
  }
  
  private void a(JSONObject paramJSONObject) {
    try {
      if (paramJSONObject.has("USEVIDEO")) {
        int i = paramJSONObject.getInt("USEVIDEO");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("USEVIDEO :");
        stringBuilder.append(i);
        stringBuilder.toString();
        c c1 = c.a(this.e);
        boolean bool = true;
        if (i == 1)
          bool = false; 
        c1.a(Boolean.valueOf(bool));
      } 
      return;
    } catch (Throwable throwable) {
      return;
    } 
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3) {
    Pattern pattern1 = Pattern.compile("^([A-Z]|\\d+)(\\.([A-Z]|\\d+))*");
    Pattern pattern2 = Pattern.compile("^\\d+(\\.\\d+)*");
    boolean bool = pattern1.matcher(Build.VERSION.RELEASE).matches();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool) {
      bool1 = bool2;
      if (pattern2.matcher("11").matches()) {
        if (!pattern2.matcher("4").matches())
          return true; 
        int i = (paramString1.split("\\.")).length;
        int k = (paramString2.split("\\.")).length;
        int j = (paramString3.split("\\.")).length;
        int m = Math.max(i, Math.max(k, j));
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("buildVersion = ");
        stringBuilder3.append(paramString1);
        stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append("minSupportedVer = ");
        stringBuilder3.append(paramString2);
        stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append("maxSupportedVer = ");
        stringBuilder3.append(paramString3);
        stringBuilder3.toString();
        String[] arrayOfString1 = new String[m];
        String[] arrayOfString2 = new String[m];
        String[] arrayOfString3 = new String[m];
        System.arraycopy(paramString1.split("\\."), 0, arrayOfString1, 0, i);
        while (i < m) {
          arrayOfString1[i] = "0";
          i++;
        } 
        System.arraycopy(paramString2.split("\\."), 0, arrayOfString2, 0, k);
        for (i = k; i < m; i++)
          arrayOfString2[i] = "0"; 
        System.arraycopy(paramString3.split("\\."), 0, arrayOfString3, 0, j);
        for (i = j; i < m; i++)
          arrayOfString3[i] = "0"; 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("isBuildRelease: maxLengthinReleasever = ");
        stringBuilder2.append(m);
        stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("isBuildRelease: buildVersionSplit_length = ");
        stringBuilder2.append(arrayOfString1.length);
        stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("isBuildRelease: minSupportedVerPart_length = ");
        stringBuilder2.append(arrayOfString2.length);
        stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("isBuildRelease: maxSupportedVerPart_length = ");
        stringBuilder2.append(arrayOfString3.length);
        stringBuilder2.toString();
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        j = 0;
        for (i = 0; j < m; i = 0) {
          if (!pattern.matcher(arrayOfString1[j]).matches()) {
            i = arrayOfString1[j].charAt(0) - 65 - 6;
          } else {
            i = Integer.parseInt(arrayOfString1[j]);
          } 
          if (i > Integer.parseInt(arrayOfString2[j])) {
            i = 1;
            break;
          } 
          if (i == Integer.parseInt(arrayOfString2[j])) {
            j++;
            i = 1;
            continue;
          } 
        } 
        k = 0;
        for (j = 0; k < m; j = 0) {
          if (!pattern.matcher(arrayOfString1[k]).matches()) {
            j = arrayOfString1[k].charAt(0) - 65 - 6;
          } else {
            j = Integer.parseInt(arrayOfString1[k]);
          } 
          if (j < Integer.parseInt(arrayOfString3[k])) {
            j = 1;
            break;
          } 
          if (j == Integer.parseInt(arrayOfString3[k])) {
            k++;
            j = 1;
            continue;
          } 
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("isBuildRelease: isBuildReleaseSupported");
        if (i != 0 && j != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        stringBuilder1.append(bool1);
        stringBuilder1.toString();
        if (i != 0 && j != 0)
          return true; 
        bool1 = false;
      } 
    } 
    return bool1;
  }
  
  private void b(int paramInt, String paramString) {
    Runnable runnable = new Runnable(this, paramInt, paramString) {
        public void run() {
          this.c.a(this.a, this.b);
        }
      };
    try {
      (new Thread(runnable, "exec_cmd_thread")).start();
      return;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      return;
    } 
  }
  
  private void b(String paramString) {
    this.o = paramString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setErrorCodeForLogReport msg: ");
    stringBuilder.append(this.o);
    g.a("TbsSDKExtension", stringBuilder.toString());
    k();
  }
  
  private void c(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[TbsSDKExtension.sendRequest] - tbsVersion:");
    stringBuilder.append(paramInt1);
    stringBuilder.append("; tbsSdkVersion:");
    stringBuilder.append(paramInt2);
    stringBuilder.toString();
    c c1 = c.a(this.e);
    long l = System.currentTimeMillis();
    c1.a(Long.valueOf(l));
    this.i = l;
    c1.b(b.a(this.e));
    c1.a(Integer.valueOf(b.b(this.e)));
    c1.c(b.a(this.e, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
    c1.o();
    JSONObject jSONObject = d(paramInt1, paramInt2);
    try {
      paramInt1 = jSONObject.getInt("TBSV");
    } catch (Exception exception) {
      paramInt1 = 0;
    } 
    try {
      a(e.a(b.a(this.e).a(), jSONObject.toString().getBytes("utf-8"), new e.a(this) {
              public void a(int param1Int) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[TbsSDKExtension.sendRequest] httpResponseCode=");
                stringBuilder.append(param1Int);
                stringBuilder.toString();
              }
            },  true), paramInt1);
      return;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      return;
    } 
  }
  
  private void c(Context paramContext) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
    editor.putString("8dfa7c9b9e", "045618");
    editor.commit();
  }
  
  private boolean c(String paramString) {
    File file = l();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tbs_crash_disable_");
    stringBuilder.append(paramString);
    return (new File(file, stringBuilder.toString())).exists();
  }
  
  private JSONObject d(int paramInt1, int paramInt2) {
    String str1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[TbsSDKExtension.postJsonData] - tbsVersion:");
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("; tbsSdkVersion:");
    stringBuilder2.append(paramInt2);
    stringBuilder2.toString();
    c c1 = c.a(this.e);
    String str5 = g(this.e);
    String str2 = "";
    String str4 = "";
    String str3 = TimeZone.getDefault().getID();
    if (str3 != null)
      str2 = str3; 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)this.e.getSystemService("phone");
      str1 = str3;
      if (telephonyManager != null)
        str1 = telephonyManager.getSimCountryIso(); 
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = str3;
    } 
    str3 = str4;
    if (str1 != null)
      str3 = str1; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("TIMEZONEID", str2);
      jSONObject.put("COUNTRYISO", str3);
      jSONObject.put("PROTOCOLVERSION", 2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[TbsSDKExtension.postJsonData] - mCallerContext:");
      stringBuilder.append(this.e);
      stringBuilder.toString();
      if (d(this.e))
        paramInt1 = c1.h(); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("[TbsSDKExtension.postJsonData] - tbsLocalVersion:");
      stringBuilder.append(paramInt1);
      stringBuilder.toString();
      jSONObject.put("FUNCTION", 3);
      jSONObject.put("APPN", this.e.getPackageName());
      String str = b.c(this.e);
      if (str == null) {
        jSONObject.put("SIGNATURE", "0");
      } else {
        jSONObject.put("SIGNATURE", str);
      } 
      jSONObject.put("APPVN", e(c1.j()));
      jSONObject.put("APPVC", c1.k());
      jSONObject.put("APPMETA", e(c1.l()));
      jSONObject.put("TBSSDKV", paramInt2);
      jSONObject.put("TBSV", paramInt1);
      str = b.a();
      if (str.contains("x86")) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("abi x86:  ");
        stringBuilder3.append(str);
        stringBuilder3.toString();
        str = "i686";
      } else {
        str = System.getProperty("os.arch");
      } 
      jSONObject.put("CPU", e(str));
      jSONObject.put("UA", str5);
      jSONObject.put("IMSI", e("imsi"));
      jSONObject.put("IMEI", e("imei"));
      if (c1.d(paramInt1)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      } 
      jSONObject.put("STATUS", paramInt1);
    } catch (Exception exception) {}
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("[TbsSDKExtension.postJsonData] jsonData=");
    stringBuilder1.append(jSONObject.toString());
    stringBuilder1.toString();
    return jSONObject;
  }
  
  private void d(String paramString) {
    File file2 = a(this.e);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tbs_switch_disable_");
    stringBuilder.append(paramString);
    File file1 = new File(file2, stringBuilder.toString());
    if (!file1.exists())
      try {
        file1.createNewFile();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
  }
  
  private boolean d(Context paramContext) {
    try {
      String str = paramContext.getApplicationContext().getPackageName();
      if (!str.equals("com.tencent.mm") && !str.equals("com.tencent.mtt") && !str.equals("com.tencent.mobileqq") && !str.equals("com.tencent.tbs") && !str.equals("com.tencent.mtt.sdk.test")) {
        boolean bool = str.equals("com.qzone");
        if (bool)
          return false; 
      } else {
        return false;
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return true;
  }
  
  private String e(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  private boolean e(Context paramContext) {
    boolean bool1;
    if ("com.tencent.qqlive".equals(paramContext.getPackageName())) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    boolean bool2 = bool1;
    try {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences(g(), 0);
      bool2 = bool1;
      bool1 = sharedPreferences.getBoolean("CRASH_INSPECTION_ENABLED", bool1);
      bool2 = bool1;
      this.a = sharedPreferences.getBoolean("OPEN_DEBUGTBS_ENABLED", true);
      bool2 = bool1;
      StringBuilder stringBuilder = new StringBuilder();
      bool2 = bool1;
      stringBuilder.append("isOpenDebugtbsFuncEnabled from WUP:");
      bool2 = bool1;
      stringBuilder.append(this.a);
      bool2 = bool1;
      g.a("TbsSDKExtension", stringBuilder.toString());
      bool2 = bool1;
      stringBuilder = new StringBuilder();
      bool2 = bool1;
      stringBuilder.append("isOpenDebugtbsFuncEnabled from WUP:");
      bool2 = bool1;
      stringBuilder.append(this.a);
      bool2 = bool1;
      stringBuilder.toString();
      return bool1;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      return bool2;
    } 
  }
  
  private String f(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield s : Z
    //   6: ifne -> 14
    //   9: aload_0
    //   10: monitorexit
    //   11: ldc ''
    //   13: areturn
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore_2
    //   18: aconst_null
    //   19: astore #6
    //   21: aload_0
    //   22: aload_1
    //   23: ldc_w 'core_info'
    //   26: invokespecial a : (Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnonnull -> 39
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc ''
    //   38: areturn
    //   39: new java/io/FileInputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial <init> : (Ljava/io/File;)V
    //   47: astore_1
    //   48: aload_3
    //   49: astore_2
    //   50: aload_1
    //   51: astore_3
    //   52: new java/io/BufferedInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial <init> : (Ljava/io/InputStream;)V
    //   60: astore #4
    //   62: new java/util/Properties
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore_2
    //   70: aload_2
    //   71: aload #4
    //   73: invokevirtual load : (Ljava/io/InputStream;)V
    //   76: aload_2
    //   77: ldc_w 'core_path'
    //   80: ldc ''
    //   82: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnonnull -> 120
    //   90: aload #4
    //   92: invokevirtual close : ()V
    //   95: goto -> 103
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual printStackTrace : ()V
    //   103: aload_1
    //   104: invokevirtual close : ()V
    //   107: goto -> 115
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual printStackTrace : ()V
    //   115: aload_0
    //   116: monitorexit
    //   117: ldc ''
    //   119: areturn
    //   120: aload #4
    //   122: invokevirtual close : ()V
    //   125: goto -> 133
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual printStackTrace : ()V
    //   133: aload_1
    //   134: invokevirtual close : ()V
    //   137: goto -> 145
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual printStackTrace : ()V
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: areturn
    //   149: astore_3
    //   150: aload #4
    //   152: astore_2
    //   153: aload_3
    //   154: astore #4
    //   156: goto -> 241
    //   159: astore #5
    //   161: goto -> 188
    //   164: astore #5
    //   166: aload #6
    //   168: astore #4
    //   170: goto -> 188
    //   173: astore #4
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -> 241
    //   180: astore #5
    //   182: aconst_null
    //   183: astore_1
    //   184: aload #6
    //   186: astore #4
    //   188: aload #4
    //   190: astore_2
    //   191: aload_1
    //   192: astore_3
    //   193: aload #5
    //   195: invokevirtual printStackTrace : ()V
    //   198: aload #4
    //   200: ifnull -> 216
    //   203: aload #4
    //   205: invokevirtual close : ()V
    //   208: goto -> 216
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual printStackTrace : ()V
    //   216: aload_1
    //   217: ifnull -> 232
    //   220: aload_1
    //   221: invokevirtual close : ()V
    //   224: goto -> 232
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual printStackTrace : ()V
    //   232: aload_0
    //   233: monitorexit
    //   234: ldc ''
    //   236: areturn
    //   237: astore #4
    //   239: aload_3
    //   240: astore_1
    //   241: aload_2
    //   242: ifnull -> 257
    //   245: aload_2
    //   246: invokevirtual close : ()V
    //   249: goto -> 257
    //   252: astore_2
    //   253: aload_2
    //   254: invokevirtual printStackTrace : ()V
    //   257: aload_1
    //   258: ifnull -> 273
    //   261: aload_1
    //   262: invokevirtual close : ()V
    //   265: goto -> 273
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual printStackTrace : ()V
    //   273: aload #4
    //   275: athrow
    //   276: astore_1
    //   277: aload_0
    //   278: monitorexit
    //   279: aload_1
    //   280: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	276	finally
    //   21	30	180	java/lang/Throwable
    //   21	30	173	finally
    //   39	48	180	java/lang/Throwable
    //   39	48	173	finally
    //   52	62	164	java/lang/Throwable
    //   52	62	237	finally
    //   62	86	159	java/lang/Throwable
    //   62	86	149	finally
    //   90	95	98	java/lang/Exception
    //   90	95	276	finally
    //   99	103	276	finally
    //   103	107	110	java/io/IOException
    //   103	107	276	finally
    //   111	115	276	finally
    //   120	125	128	java/lang/Exception
    //   120	125	276	finally
    //   129	133	276	finally
    //   133	137	140	java/io/IOException
    //   133	137	276	finally
    //   141	145	276	finally
    //   193	198	237	finally
    //   203	208	211	java/lang/Exception
    //   203	208	276	finally
    //   212	216	276	finally
    //   220	224	227	java/io/IOException
    //   220	224	276	finally
    //   228	232	276	finally
    //   245	249	252	java/lang/Exception
    //   245	249	276	finally
    //   253	257	276	finally
    //   261	265	268	java/io/IOException
    //   261	265	276	finally
    //   269	273	276	finally
    //   273	276	276	finally
  }
  
  private void f() {
    boolean bool;
    c c1 = c.a(this.e);
    String str = j();
    this.m = TbsCrashHandler.a(this.e, str, "044800");
    TbsCrashHandler tbsCrashHandler = this.m;
    if (tbsCrashHandler != null && tbsCrashHandler instanceof TbsCrashHandler) {
      bool = tbsCrashHandler.b(this.e, str);
    } else {
      g(509);
      b("509, TbsCrashHandler.getInstance null!");
      bool = false;
    } 
    if (!bool && c1.f() != 0L && str != null)
      a.a(this.e, str, false, "TBS_PRECHECK_REPORT_RESTORE"); 
  }
  
  private void f(String paramString) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #29
    //   5: if_icmpge -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield e : Landroid/content/Context;
    //   13: ldc_w 'tbs_oat_status'
    //   16: iconst_0
    //   17: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   20: astore #5
    //   22: new java/io/File
    //   25: dup
    //   26: aload_1
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: astore #6
    //   32: new java/io/File
    //   35: dup
    //   36: aload #6
    //   38: invokevirtual getParent : ()Ljava/lang/String;
    //   41: ldc 'core_private'
    //   43: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: astore #8
    //   48: aload #5
    //   50: ldc_w 'core_oat_status_system_build_display'
    //   53: ldc ''
    //   55: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore #9
    //   62: aload #5
    //   64: ldc_w 'core_oat_status_app_version_code'
    //   67: iconst_m1
    //   68: invokeinterface getInt : (Ljava/lang/String;I)I
    //   73: istore_3
    //   74: aload #5
    //   76: ldc_w 'core_oat_status_app_version_name'
    //   79: ldc ''
    //   81: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore #10
    //   88: getstatic android/os/Build.DISPLAY : Ljava/lang/String;
    //   91: astore #4
    //   93: aload_0
    //   94: getfield e : Landroid/content/Context;
    //   97: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   100: aload_0
    //   101: getfield e : Landroid/content/Context;
    //   104: invokevirtual getPackageName : ()Ljava/lang/String;
    //   107: iconst_0
    //   108: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   111: astore #7
    //   113: aload #7
    //   115: getfield versionCode : I
    //   118: istore_2
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore #11
    //   128: aload #11
    //   130: aload #7
    //   132: getfield versionName : Ljava/lang/String;
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload #11
    //   141: invokestatic random : ()D
    //   144: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #11
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: astore #7
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #11
    //   164: aload #11
    //   166: ldc_w 'cleanOatFileIfNeed,oldSystemBuildDisplay='
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload #11
    //   175: aload #9
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #11
    //   183: ldc_w ';newSystemBuildDisplay='
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload #11
    //   192: aload #4
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #11
    //   200: ldc_w ';oldAppVersionCode='
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #11
    //   209: iload_3
    //   210: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #11
    //   216: ldc_w ';newVersionCode='
    //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload #11
    //   225: iload_2
    //   226: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #11
    //   232: ldc_w ';oldAppVersionName='
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload #11
    //   241: aload #10
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #11
    //   249: ldc_w ';newVersionName='
    //   252: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload #11
    //   258: aload #7
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #11
    //   266: invokevirtual toString : ()Ljava/lang/String;
    //   269: pop
    //   270: aload #4
    //   272: aload #9
    //   274: invokevirtual equals : (Ljava/lang/Object;)Z
    //   277: ifeq -> 298
    //   280: iload_3
    //   281: iload_2
    //   282: if_icmpne -> 298
    //   285: aload #7
    //   287: aload #10
    //   289: invokevirtual equals : (Ljava/lang/Object;)Z
    //   292: ifne -> 555
    //   295: goto -> 298
    //   298: new java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial <init> : ()V
    //   305: astore #9
    //   307: aload #9
    //   309: ldc_w 'version updated!,clear oat file coreSharePath:'
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload #9
    //   318: aload_1
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 'TbsSDKExtension'
    //   325: aload #9
    //   327: invokevirtual toString : ()Ljava/lang/String;
    //   330: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   333: pop
    //   334: new com/tencent/tbs/sdk/extension/e
    //   337: dup
    //   338: aload #8
    //   340: ldc_w 'core_share_oat_status_check.lock'
    //   343: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   346: astore_1
    //   347: aload_1
    //   348: invokevirtual b : ()V
    //   351: aload #5
    //   353: ldc_w 'core_oat_status_system_build_display'
    //   356: ldc ''
    //   358: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   363: astore #8
    //   365: aload #5
    //   367: ldc_w 'core_oat_status_app_version_code'
    //   370: iconst_m1
    //   371: invokeinterface getInt : (Ljava/lang/String;I)I
    //   376: istore_3
    //   377: aload #5
    //   379: ldc_w 'core_oat_status_app_version_name'
    //   382: ldc ''
    //   384: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   389: astore #9
    //   391: aload #4
    //   393: aload #8
    //   395: invokevirtual equals : (Ljava/lang/Object;)Z
    //   398: ifeq -> 416
    //   401: iload_3
    //   402: iload_2
    //   403: if_icmpne -> 416
    //   406: aload #7
    //   408: aload #9
    //   410: invokevirtual equals : (Ljava/lang/Object;)Z
    //   413: ifne -> 485
    //   416: new java/io/File
    //   419: dup
    //   420: aload #6
    //   422: ldc_w 'oat'
    //   425: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   428: invokestatic a : (Ljava/io/File;)V
    //   431: aload #5
    //   433: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   438: astore #5
    //   440: aload #5
    //   442: ldc_w 'core_oat_status_system_build_display'
    //   445: aload #4
    //   447: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   452: pop
    //   453: aload #5
    //   455: ldc_w 'core_oat_status_app_version_code'
    //   458: iload_2
    //   459: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   464: pop
    //   465: aload #5
    //   467: ldc_w 'core_oat_status_app_version_name'
    //   470: aload #7
    //   472: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   477: pop
    //   478: aload #5
    //   480: invokeinterface apply : ()V
    //   485: aload_1
    //   486: ifnull -> 534
    //   489: aload_1
    //   490: invokevirtual e : ()V
    //   493: return
    //   494: astore #5
    //   496: aload_1
    //   497: astore #4
    //   499: aload #5
    //   501: astore_1
    //   502: goto -> 543
    //   505: astore #4
    //   507: goto -> 521
    //   510: astore_1
    //   511: aconst_null
    //   512: astore #4
    //   514: goto -> 543
    //   517: astore #4
    //   519: aconst_null
    //   520: astore_1
    //   521: aload #4
    //   523: invokevirtual printStackTrace : ()V
    //   526: aload_1
    //   527: ifnull -> 534
    //   530: aload_1
    //   531: invokevirtual e : ()V
    //   534: return
    //   535: astore #5
    //   537: aload_1
    //   538: astore #4
    //   540: aload #5
    //   542: astore_1
    //   543: aload #4
    //   545: ifnull -> 553
    //   548: aload #4
    //   550: invokevirtual e : ()V
    //   553: aload_1
    //   554: athrow
    //   555: aconst_null
    //   556: astore_1
    //   557: goto -> 485
    // Exception table:
    //   from	to	target	type
    //   48	280	517	java/lang/Exception
    //   48	280	510	finally
    //   285	295	517	java/lang/Exception
    //   285	295	510	finally
    //   298	347	517	java/lang/Exception
    //   298	347	510	finally
    //   347	401	505	java/lang/Exception
    //   347	401	494	finally
    //   406	416	505	java/lang/Exception
    //   406	416	494	finally
    //   416	485	505	java/lang/Exception
    //   416	485	494	finally
    //   521	526	535	finally
  }
  
  private String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h());
    stringBuilder.append("_");
    stringBuilder.append("tbs_public_settings");
    return stringBuilder.toString();
  }
  
  private String g(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: getfield q : Ljava/lang/String;
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: ifne -> 15
    //   10: aload_0
    //   11: getfield q : Ljava/lang/String;
    //   14: areturn
    //   15: invokestatic getDefault : ()Ljava/util/Locale;
    //   18: astore #4
    //   20: new java/lang/StringBuffer
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore_3
    //   28: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   31: astore_1
    //   32: new java/lang/String
    //   35: dup
    //   36: aload_1
    //   37: ldc_w 'UTF-8'
    //   40: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   43: ldc_w 'ISO8859-1'
    //   46: invokespecial <init> : ([BLjava/lang/String;)V
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual length : ()I
    //   56: ifle -> 62
    //   59: goto -> 66
    //   62: ldc_w '1.0'
    //   65: astore_1
    //   66: aload_3
    //   67: aload_1
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: pop
    //   72: aload_3
    //   73: ldc_w '; '
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   79: pop
    //   80: aload #4
    //   82: invokevirtual getLanguage : ()Ljava/lang/String;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull -> 125
    //   90: aload_3
    //   91: aload_1
    //   92: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   98: pop
    //   99: aload #4
    //   101: invokevirtual getCountry : ()Ljava/lang/String;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull -> 135
    //   109: aload_3
    //   110: ldc_w '-'
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: pop
    //   117: aload_1
    //   118: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   121: astore_1
    //   122: goto -> 129
    //   125: ldc_w 'en'
    //   128: astore_1
    //   129: aload_3
    //   130: aload_1
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: pop
    //   135: ldc_w 'REL'
    //   138: getstatic android/os/Build$VERSION.CODENAME : Ljava/lang/String;
    //   141: invokevirtual equals : (Ljava/lang/Object;)Z
    //   144: ifeq -> 192
    //   147: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   150: astore_1
    //   151: new java/lang/String
    //   154: dup
    //   155: aload_1
    //   156: ldc_w 'UTF-8'
    //   159: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   162: ldc_w 'ISO8859-1'
    //   165: invokespecial <init> : ([BLjava/lang/String;)V
    //   168: astore_2
    //   169: aload_2
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual length : ()I
    //   175: ifle -> 192
    //   178: aload_3
    //   179: ldc_w '; '
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   185: pop
    //   186: aload_3
    //   187: aload_1
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   191: pop
    //   192: getstatic android/os/Build.ID : Ljava/lang/String;
    //   195: ldc_w '[一-龥]'
    //   198: ldc ''
    //   200: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual length : ()I
    //   208: ifle -> 225
    //   211: aload_3
    //   212: ldc_w ' Build/'
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   224: pop
    //   225: ldc_w 'Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1'
    //   228: iconst_1
    //   229: anewarray java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload_3
    //   235: aastore
    //   236: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   239: astore_1
    //   240: aload_0
    //   241: aload_1
    //   242: putfield q : Ljava/lang/String;
    //   245: aload_1
    //   246: areturn
    //   247: astore_2
    //   248: goto -> 52
    //   251: astore_2
    //   252: goto -> 171
    // Exception table:
    //   from	to	target	type
    //   32	50	247	java/lang/Exception
    //   151	169	251	java/lang/Exception
  }
  
  private void g(int paramInt) {
    this.n = paramInt;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setErrorCodeForLogReport ");
    stringBuilder.append(paramInt);
    g.a("TbsSDKExtension", stringBuilder.toString());
  }
  
  private String h() {
    String str = i();
    return TextUtils.isEmpty(str) ? "" : str.replace(":", "_");
  }
  
  private String i() {
    if (!TextUtils.isEmpty(this.p))
      return this.p; 
    BufferedReader bufferedReader = null;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/proc/");
      stringBuilder.append(Process.myPid());
      stringBuilder.append("/");
      stringBuilder.append("cmdline");
    } catch (Throwable null) {
    
    } finally {
      BufferedReader bufferedReader1 = bufferedReader;
      if (bufferedReader1 != null)
        try {
          bufferedReader1.close();
        } catch (IOException throwable) {
          throwable.printStackTrace();
        }  
    } 
    if (throwable != null)
      try {
        throwable.close();
        return null;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  private String j() {
    String str = this.t;
    if (str != null)
      return str; 
    File file = TbsSDKExtension.getTbsFolderDir(this.f);
    if (this.s) {
      if (f(this.e).contains("core_share_decouple")) {
        file = new File(file, "core_share_decouple");
      } else {
        String[] arrayOfString = getClass().getClassLoader().toString().split(",");
        int j = arrayOfString.length;
        int i = 0;
        boolean bool;
        for (bool = false; i < j; bool = bool1) {
          String str1 = arrayOfString[i];
          boolean bool1 = bool;
          if (str1.contains("zip file")) {
            bool1 = bool;
            if (str1.contains("core_share_decouple"))
              bool1 = true; 
          } 
          i++;
        } 
        if (bool) {
          file = new File(file, "core_share_decouple");
        } else {
          file = new File(file, "core_share");
        } 
      } 
    } else {
      file = new File(file, "core_share");
    } 
    return file.exists() ? file.getAbsolutePath() : null;
  }
  
  private void k() {
    try {
      Context context = this.e.getApplicationContext();
      int k = Integer.parseInt("044800");
      StringBuilder stringBuilder1 = new StringBuilder("tbs_sdk_ver: ");
      stringBuilder1.append(this.l);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("; mErrorCode: ");
      stringBuilder2.append(this.n);
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("; mErrorMsg: ");
      stringBuilder2.append(this.o);
      stringBuilder1.append(stringBuilder2.toString());
      int j = this.n;
      int i = j;
      if (-1 == j)
        i = 800; 
      a.a(context).a(i, stringBuilder1.toString(), k);
      return;
    } catch (Throwable throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("report load error exception: ");
      stringBuilder.append(throwable);
      g.c("TbsSDKExtension", stringBuilder.toString());
      return;
    } 
  }
  
  private File l() {
    File file = new File(TbsSDKExtension.getTbsFolderDir(this.e), "crash_record");
    if (!file.exists())
      file.mkdir(); 
    return file;
  }
  
  private void m() {
    File[] arrayOfFile = a(this.e).listFiles();
    Pattern pattern = Pattern.compile("tbs_switch_disable_(.*)");
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      File file = arrayOfFile[i];
      if (pattern.matcher(file.getName()).find() && file.isFile() && file.exists() && file.canRead()) {
        file.delete();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("clearTbsCoreDisableFlagFiles: ");
        stringBuilder.append(file.getName());
        stringBuilder.toString();
      } 
    } 
  }
  
  public Bundle a(Context paramContext, Bundle paramBundle) {
    paramBundle = a.a(paramContext, paramBundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("after incurUpdate,code:");
    stringBuilder.append(paramBundle);
    a.a(stringBuilder.toString());
    a.a(paramContext.getApplicationContext());
    return paramBundle;
  }
  
  public Object a(String paramString, Bundle paramBundle) {
    if ("unlzma".equals(paramString)) {
      boolean bool = a.a(paramBundle);
      return Boolean.valueOf(bool);
    } 
    if ("can_unlzma".equals(paramString)) {
      boolean bool = true;
      return Boolean.valueOf(bool);
    } 
    return paramBundle;
  }
  
  public String a(Context paramContext1, Context paramContext2) {
    StringBuffer stringBuffer = new StringBuffer();
    File file = TbsSDKExtension.getTbsFolderDir(paramContext2);
    stringBuffer.append((new File(file, "core_share")).getAbsolutePath());
    file = new File(new File(new File(file, "share"), "plugins"), "com.tencent.qb.plugin.videodecode");
    stringBuffer.append(File.pathSeparator);
    stringBuffer.append(file.getAbsolutePath());
    return stringBuffer.toString();
  }
  
  @SuppressLint({"SdCardPath"})
  @TargetApi(9)
  public void a(int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: astore #31
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #23
    //   12: aload #23
    //   14: ldc_w '['
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload #23
    //   23: aload_0
    //   24: invokevirtual getClass : ()Ljava/lang/Class;
    //   27: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #23
    //   36: ldc_w '] -- '
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #23
    //   45: invokestatic currentThread : ()Ljava/lang/Thread;
    //   48: invokevirtual getStackTrace : ()[Ljava/lang/StackTraceElement;
    //   51: iconst_2
    //   52: aaload
    //   53: invokevirtual getMethodName : ()Ljava/lang/String;
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 'TbsSDKExtension'
    //   62: aload #23
    //   64: invokevirtual toString : ()Ljava/lang/String;
    //   67: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   70: getstatic android/os/Build$VERSION.SDK_INT : I
    //   73: bipush #9
    //   75: if_icmpge -> 79
    //   78: return
    //   79: aload #31
    //   81: iconst_0
    //   82: putfield r : Z
    //   85: aload #31
    //   87: getfield e : Landroid/content/Context;
    //   90: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/c;
    //   93: astore #32
    //   95: aload #32
    //   97: invokevirtual a : ()I
    //   100: istore #7
    //   102: aload #32
    //   104: invokevirtual b : ()Ljava/lang/String;
    //   107: astore #23
    //   109: iload_1
    //   110: iflt -> 168
    //   113: aload_2
    //   114: ifnull -> 168
    //   117: aload_2
    //   118: invokevirtual isEmpty : ()Z
    //   121: ifne -> 168
    //   124: iload_1
    //   125: iload #7
    //   127: if_icmpne -> 139
    //   130: aload_2
    //   131: aload #23
    //   133: invokevirtual equals : (Ljava/lang/Object;)Z
    //   136: ifne -> 168
    //   139: aload #32
    //   141: iload_1
    //   142: invokevirtual a : (I)V
    //   145: aload #32
    //   147: aload_2
    //   148: invokevirtual a : (Ljava/lang/String;)V
    //   151: aload #32
    //   153: iconst_0
    //   154: invokevirtual b : (I)V
    //   157: aload #32
    //   159: iconst_0
    //   160: invokevirtual a : (Z)V
    //   163: aload #32
    //   165: invokevirtual o : ()V
    //   168: iload_1
    //   169: iconst_m1
    //   170: if_icmpne -> 176
    //   173: goto -> 182
    //   176: iload_1
    //   177: istore #7
    //   179: aload_2
    //   180: astore #23
    //   182: aload #32
    //   184: invokevirtual c : ()I
    //   187: istore #11
    //   189: ldc_w 2147483647
    //   192: iload #11
    //   194: if_icmpne -> 206
    //   197: ldc 'TbsSDKExtension'
    //   199: ldc_w 'CMD file completed! -- no need to execute!'
    //   202: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   205: return
    //   206: aload #23
    //   208: ifnull -> 3464
    //   211: aload #23
    //   213: invokevirtual isEmpty : ()Z
    //   216: ifne -> 3464
    //   219: iload #7
    //   221: iconst_m1
    //   222: if_icmpne -> 228
    //   225: goto -> 3464
    //   228: iload #7
    //   230: bipush #100
    //   232: if_icmpeq -> 283
    //   235: iload #7
    //   237: bipush #101
    //   239: if_icmpeq -> 283
    //   242: new java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial <init> : ()V
    //   249: astore_2
    //   250: aload_2
    //   251: ldc_w 'CMD('
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_2
    //   259: iload #7
    //   261: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_2
    //   266: ldc_w ') is not supported!'
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: ldc 'TbsSDKExtension'
    //   275: aload_2
    //   276: invokevirtual toString : ()Ljava/lang/String;
    //   279: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   282: return
    //   283: aload #31
    //   285: getfield e : Landroid/content/Context;
    //   288: invokestatic a : (Landroid/content/Context;)I
    //   291: iconst_3
    //   292: if_icmpeq -> 296
    //   295: return
    //   296: aload #23
    //   298: astore #24
    //   300: aload #23
    //   302: ldc_w '/sdcard/'
    //   305: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   308: ifeq -> 392
    //   311: new java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial <init> : ()V
    //   318: astore #24
    //   320: aload #24
    //   322: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   325: invokevirtual getPath : ()Ljava/lang/String;
    //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload #24
    //   334: getstatic java/io/File.separator : Ljava/lang/String;
    //   337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload #23
    //   343: ldc_w '/sdcard/'
    //   346: aload #24
    //   348: invokevirtual toString : ()Ljava/lang/String;
    //   351: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   354: astore #24
    //   356: new java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial <init> : ()V
    //   363: astore #23
    //   365: aload #23
    //   367: ldc_w 'CMD sdcard:'
    //   370: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload #23
    //   376: aload #24
    //   378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 'TbsSDKExtension'
    //   384: aload #23
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   392: iload #7
    //   394: bipush #101
    //   396: if_icmpne -> 2141
    //   399: ldc 'TbsSDKExtension'
    //   401: ldc_w 'Begin downloading...'
    //   404: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   407: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.b : Ljava/util/concurrent/locks/Lock;
    //   410: invokeinterface tryLock : ()Z
    //   415: ifne -> 427
    //   418: ldc 'TbsSDKExtension'
    //   420: ldc_w 'cmdDownloadLock failed --> return!'
    //   423: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   426: return
    //   427: aload #32
    //   429: invokevirtual d : ()Z
    //   432: ifeq -> 444
    //   435: ldc 'TbsSDKExtension'
    //   437: ldc_w 'File is already replaced --> return!'
    //   440: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   443: return
    //   444: aload #24
    //   446: ldc_w ';'
    //   449: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   452: astore_2
    //   453: aload_2
    //   454: arraylength
    //   455: iconst_3
    //   456: if_icmpge -> 468
    //   459: ldc 'TbsSDKExtension'
    //   461: ldc_w 'Cmd args are invalid --> return!'
    //   464: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   467: return
    //   468: aload_2
    //   469: iconst_0
    //   470: aaload
    //   471: astore #26
    //   473: aload_2
    //   474: iconst_1
    //   475: aaload
    //   476: astore #36
    //   478: aload_2
    //   479: iconst_2
    //   480: aaload
    //   481: astore #35
    //   483: aload #31
    //   485: getfield e : Landroid/content/Context;
    //   488: invokestatic b : (Landroid/content/Context;)Ljava/io/File;
    //   491: astore_2
    //   492: ldc_w 'tbs_cmd_download.tmp'
    //   495: astore #23
    //   497: new java/io/File
    //   500: dup
    //   501: aload_2
    //   502: ldc_w 'tbs_cmd_download.tmp'
    //   505: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   508: astore #27
    //   510: ldc2_w -1
    //   513: lstore #12
    //   515: sipush #30000
    //   518: istore_1
    //   519: aconst_null
    //   520: astore #24
    //   522: iconst_0
    //   523: istore #7
    //   525: aload #32
    //   527: astore #25
    //   529: iload #7
    //   531: bipush #8
    //   533: if_icmple -> 543
    //   536: aload #25
    //   538: astore #24
    //   540: goto -> 1414
    //   543: aload_2
    //   544: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   547: invokestatic a : (Ljava/lang/String;)J
    //   550: aload #31
    //   552: getfield e : Landroid/content/Context;
    //   555: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/c;
    //   558: invokevirtual q : ()J
    //   561: lcmp
    //   562: ifge -> 3508
    //   565: goto -> 536
    //   568: new java/net/URL
    //   571: dup
    //   572: aload #28
    //   574: invokespecial <init> : (Ljava/lang/String;)V
    //   577: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   580: checkcast java/net/HttpURLConnection
    //   583: astore #32
    //   585: aload #32
    //   587: ldc_w 'User-Agent'
    //   590: aload #31
    //   592: aload #31
    //   594: getfield e : Landroid/content/Context;
    //   597: invokespecial g : (Landroid/content/Context;)Ljava/lang/String;
    //   600: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload #32
    //   605: ldc_w 'Accept-Encoding'
    //   608: ldc_w 'identity'
    //   611: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload #32
    //   616: ldc_w 'GET'
    //   619: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   622: aload #32
    //   624: ldc_w 'Range'
    //   627: ldc_w 'close'
    //   630: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload #32
    //   635: iconst_0
    //   636: invokevirtual setInstanceFollowRedirects : (Z)V
    //   639: aload #32
    //   641: sipush #20000
    //   644: invokevirtual setConnectTimeout : (I)V
    //   647: aload #32
    //   649: iload_1
    //   650: invokevirtual setReadTimeout : (I)V
    //   653: new java/io/File
    //   656: dup
    //   657: aload_2
    //   658: aload #23
    //   660: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   663: astore #26
    //   665: aload #26
    //   667: invokevirtual exists : ()Z
    //   670: ifeq -> 3527
    //   673: aload #26
    //   675: invokevirtual length : ()J
    //   678: lstore #14
    //   680: goto -> 683
    //   683: lload #12
    //   685: lconst_0
    //   686: lcmp
    //   687: ifgt -> 752
    //   690: new java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial <init> : ()V
    //   697: astore #26
    //   699: aload #26
    //   701: ldc_w 'bytes='
    //   704: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload #26
    //   710: lload #14
    //   712: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload #26
    //   718: ldc_w '-'
    //   721: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload #26
    //   727: invokevirtual toString : ()Ljava/lang/String;
    //   730: astore #26
    //   732: aload #23
    //   734: astore #29
    //   736: aload_2
    //   737: astore #30
    //   739: aload #32
    //   741: ldc_w 'Range'
    //   744: aload #26
    //   746: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   749: goto -> 805
    //   752: new java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial <init> : ()V
    //   759: astore #26
    //   761: aload #26
    //   763: ldc_w 'bytes='
    //   766: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload #26
    //   772: lload #14
    //   774: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload #26
    //   780: ldc_w '-'
    //   783: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload #26
    //   789: lload #12
    //   791: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload #26
    //   797: invokevirtual toString : ()Ljava/lang/String;
    //   800: astore #26
    //   802: goto -> 732
    //   805: aload #32
    //   807: invokevirtual getResponseCode : ()I
    //   810: istore #8
    //   812: iload #8
    //   814: sipush #200
    //   817: if_icmpeq -> 879
    //   820: iload #8
    //   822: sipush #206
    //   825: if_icmpne -> 831
    //   828: goto -> 879
    //   831: iload #8
    //   833: sipush #300
    //   836: if_icmplt -> 3543
    //   839: iload #8
    //   841: sipush #307
    //   844: if_icmpgt -> 3543
    //   847: aload #32
    //   849: ldc_w 'Location'
    //   852: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   855: astore_2
    //   856: aload_2
    //   857: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   860: ifne -> 3551
    //   863: iload #7
    //   865: iconst_1
    //   866: iadd
    //   867: istore #7
    //   869: aload #28
    //   871: astore #26
    //   873: aload_2
    //   874: astore #24
    //   876: goto -> 3533
    //   879: aload #32
    //   881: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   884: pop
    //   885: aload #32
    //   887: invokevirtual getContentLength : ()I
    //   890: istore #8
    //   892: iload #8
    //   894: i2l
    //   895: lload #14
    //   897: ladd
    //   898: lstore #16
    //   900: aload #32
    //   902: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   905: astore #33
    //   907: aload #33
    //   909: astore #23
    //   911: aload #23
    //   913: ifnull -> 1373
    //   916: aload #32
    //   918: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   921: astore_2
    //   922: aload_2
    //   923: ifnull -> 949
    //   926: aload_2
    //   927: ldc_w 'gzip'
    //   930: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   933: ifeq -> 949
    //   936: new java/util/zip/GZIPInputStream
    //   939: dup
    //   940: aload #23
    //   942: invokespecial <init> : (Ljava/io/InputStream;)V
    //   945: astore_2
    //   946: goto -> 987
    //   949: aload_2
    //   950: ifnull -> 984
    //   953: aload_2
    //   954: ldc_w 'deflate'
    //   957: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   960: ifeq -> 984
    //   963: new java/util/zip/InflaterInputStream
    //   966: dup
    //   967: aload #23
    //   969: new java/util/zip/Inflater
    //   972: dup
    //   973: iconst_1
    //   974: invokespecial <init> : (Z)V
    //   977: invokespecial <init> : (Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   980: astore_2
    //   981: goto -> 987
    //   984: aload #23
    //   986: astore_2
    //   987: sipush #8192
    //   990: newarray byte
    //   992: astore #34
    //   994: new java/io/FileOutputStream
    //   997: dup
    //   998: aload #27
    //   1000: iconst_1
    //   1001: invokespecial <init> : (Ljava/io/File;Z)V
    //   1004: astore #26
    //   1006: aload_2
    //   1007: astore #32
    //   1009: aload #26
    //   1011: astore #31
    //   1013: invokestatic currentTimeMillis : ()J
    //   1016: lstore #20
    //   1018: lload #14
    //   1020: lstore #12
    //   1022: lload #14
    //   1024: lstore #18
    //   1026: lload #20
    //   1028: lstore #14
    //   1030: aload_2
    //   1031: astore #32
    //   1033: aload #26
    //   1035: astore #31
    //   1037: aload_2
    //   1038: aload #34
    //   1040: iconst_0
    //   1041: sipush #8192
    //   1044: invokevirtual read : ([BII)I
    //   1047: istore #8
    //   1049: iload #8
    //   1051: ifgt -> 1057
    //   1054: goto -> 1378
    //   1057: aload_2
    //   1058: astore #32
    //   1060: aload #26
    //   1062: astore #31
    //   1064: aload #26
    //   1066: aload #34
    //   1068: iconst_0
    //   1069: iload #8
    //   1071: invokevirtual write : ([BII)V
    //   1074: aload_2
    //   1075: astore #32
    //   1077: aload #26
    //   1079: astore #31
    //   1081: aload #26
    //   1083: invokevirtual flush : ()V
    //   1086: aload_2
    //   1087: astore #32
    //   1089: aload #26
    //   1091: astore #31
    //   1093: invokestatic currentTimeMillis : ()J
    //   1096: lstore #20
    //   1098: aload #26
    //   1100: astore #31
    //   1102: lload #18
    //   1104: iload #8
    //   1106: i2l
    //   1107: ladd
    //   1108: lstore #18
    //   1110: lload #20
    //   1112: lload #14
    //   1114: lsub
    //   1115: ldc2_w 1000
    //   1118: lcmp
    //   1119: ifle -> 1241
    //   1122: lload #18
    //   1124: l2d
    //   1125: dstore_3
    //   1126: aload_2
    //   1127: astore #32
    //   1129: lload #16
    //   1131: l2d
    //   1132: dstore #5
    //   1134: dload_3
    //   1135: invokestatic isNaN : (D)Z
    //   1138: pop
    //   1139: dload #5
    //   1141: invokestatic isNaN : (D)Z
    //   1144: pop
    //   1145: dload_3
    //   1146: dload #5
    //   1148: ddiv
    //   1149: ldc2_w 100.0
    //   1152: dmul
    //   1153: d2i
    //   1154: istore #8
    //   1156: new java/lang/StringBuilder
    //   1159: dup
    //   1160: invokespecial <init> : ()V
    //   1163: astore #37
    //   1165: aload #37
    //   1167: ldc_w '#file downloading -- current/total='
    //   1170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload #37
    //   1176: iload #8
    //   1178: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: aload #37
    //   1184: ldc_w '%'
    //   1187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: pop
    //   1191: ldc 'TbsSDKExtension'
    //   1193: aload #37
    //   1195: invokevirtual toString : ()Ljava/lang/String;
    //   1198: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1201: lload #12
    //   1203: lstore #14
    //   1205: lload #18
    //   1207: lload #12
    //   1209: lsub
    //   1210: ldc2_w 1048576
    //   1213: lcmp
    //   1214: ifle -> 1221
    //   1217: lload #18
    //   1219: lstore #14
    //   1221: lload #14
    //   1223: lstore #12
    //   1225: goto -> 1245
    //   1228: astore_2
    //   1229: aload #32
    //   1231: astore #26
    //   1233: goto -> 1280
    //   1236: astore #23
    //   1238: goto -> 1258
    //   1241: lload #14
    //   1243: lstore #20
    //   1245: aload #31
    //   1247: astore #26
    //   1249: lload #20
    //   1251: lstore #14
    //   1253: goto -> 1030
    //   1256: astore #23
    //   1258: aload_2
    //   1259: astore #32
    //   1261: aload #26
    //   1263: astore_2
    //   1264: aload #23
    //   1266: astore #31
    //   1268: aload #32
    //   1270: astore #26
    //   1272: goto -> 1303
    //   1275: astore_2
    //   1276: aload #32
    //   1278: astore #26
    //   1280: aload #23
    //   1282: astore #24
    //   1284: aload #31
    //   1286: astore #23
    //   1288: goto -> 2047
    //   1291: astore #31
    //   1293: aload #26
    //   1295: astore #23
    //   1297: aload_2
    //   1298: astore #26
    //   1300: aload #23
    //   1302: astore_2
    //   1303: aload_2
    //   1304: astore #23
    //   1306: aload #33
    //   1308: astore_2
    //   1309: goto -> 1916
    //   1312: astore #26
    //   1314: goto -> 1341
    //   1317: astore #24
    //   1319: aload_2
    //   1320: astore #26
    //   1322: aload #24
    //   1324: astore_2
    //   1325: aconst_null
    //   1326: astore #25
    //   1328: aload #23
    //   1330: astore #24
    //   1332: aload #25
    //   1334: astore #23
    //   1336: goto -> 2047
    //   1339: astore #26
    //   1341: aload_2
    //   1342: astore #32
    //   1344: aload #23
    //   1346: astore_2
    //   1347: aconst_null
    //   1348: astore #23
    //   1350: aload #26
    //   1352: astore #31
    //   1354: aload #32
    //   1356: astore #26
    //   1358: goto -> 1916
    //   1361: astore_2
    //   1362: goto -> 1889
    //   1365: astore #31
    //   1367: aload #23
    //   1369: astore_2
    //   1370: goto -> 1910
    //   1373: aconst_null
    //   1374: astore_2
    //   1375: aconst_null
    //   1376: astore #26
    //   1378: aload #26
    //   1380: ifnull -> 1388
    //   1383: aload #26
    //   1385: invokevirtual close : ()V
    //   1388: aload_2
    //   1389: ifnull -> 1396
    //   1392: aload_2
    //   1393: invokevirtual close : ()V
    //   1396: aload #25
    //   1398: astore #24
    //   1400: aload #23
    //   1402: ifnull -> 1414
    //   1405: aload #23
    //   1407: invokevirtual close : ()V
    //   1410: aload #25
    //   1412: astore #24
    //   1414: ldc 'TbsSDKExtension'
    //   1416: ldc_w 'checkMd5Value...'
    //   1419: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1422: aload #27
    //   1424: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   1427: astore_2
    //   1428: aload #36
    //   1430: aload_2
    //   1431: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1434: ifne -> 1521
    //   1437: ldc 'TbsSDKExtension'
    //   1439: ldc_w 'Md5 check failed!'
    //   1442: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1445: new java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial <init> : ()V
    //   1452: astore #23
    //   1454: aload #23
    //   1456: ldc_w 'Md5 check failed: cmd_file_md5('
    //   1459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: pop
    //   1463: aload #23
    //   1465: aload #36
    //   1467: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: aload #23
    //   1473: ldc_w '); calc_md5('
    //   1476: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: aload #23
    //   1482: aload_2
    //   1483: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: pop
    //   1487: aload #23
    //   1489: ldc_w ')!'
    //   1492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: pop
    //   1496: ldc 'TbsSDKExtension'
    //   1498: aload #23
    //   1500: invokevirtual toString : ()Ljava/lang/String;
    //   1503: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1506: aload #27
    //   1508: invokevirtual delete : ()Z
    //   1511: pop
    //   1512: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.b : Ljava/util/concurrent/locks/Lock;
    //   1515: invokeinterface unlock : ()V
    //   1520: return
    //   1521: new java/lang/StringBuilder
    //   1524: dup
    //   1525: invokespecial <init> : ()V
    //   1528: astore_2
    //   1529: aload_2
    //   1530: ldc_w 'replace to '
    //   1533: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload_2
    //   1538: aload #35
    //   1540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: aload_2
    //   1545: ldc_w '...'
    //   1548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: ldc 'TbsSDKExtension'
    //   1554: aload_2
    //   1555: invokevirtual toString : ()Ljava/lang/String;
    //   1558: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1561: aload #35
    //   1563: astore_2
    //   1564: aload #35
    //   1566: ldc_w '/sdcard/'
    //   1569: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   1572: ifeq -> 1650
    //   1575: new java/lang/StringBuilder
    //   1578: dup
    //   1579: invokespecial <init> : ()V
    //   1582: astore_2
    //   1583: aload_2
    //   1584: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   1587: invokevirtual getPath : ()Ljava/lang/String;
    //   1590: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: aload_2
    //   1595: getstatic java/io/File.separator : Ljava/lang/String;
    //   1598: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: pop
    //   1602: aload #35
    //   1604: ldc_w '/sdcard/'
    //   1607: aload_2
    //   1608: invokevirtual toString : ()Ljava/lang/String;
    //   1611: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1614: astore_2
    //   1615: new java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial <init> : ()V
    //   1622: astore #23
    //   1624: aload #23
    //   1626: ldc_w 'file sdcard:'
    //   1629: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload #23
    //   1635: aload_2
    //   1636: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: pop
    //   1640: ldc 'TbsSDKExtension'
    //   1642: aload #23
    //   1644: invokevirtual toString : ()Ljava/lang/String;
    //   1647: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1650: new java/io/FileOutputStream
    //   1653: dup
    //   1654: new java/io/File
    //   1657: dup
    //   1658: aload_2
    //   1659: invokespecial <init> : (Ljava/lang/String;)V
    //   1662: invokespecial <init> : (Ljava/io/File;)V
    //   1665: astore_2
    //   1666: new java/io/FileInputStream
    //   1669: dup
    //   1670: aload #27
    //   1672: invokespecial <init> : (Ljava/io/File;)V
    //   1675: astore #23
    //   1677: aload #23
    //   1679: aload_2
    //   1680: invokestatic b : (Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   1683: istore_1
    //   1684: iload_1
    //   1685: iconst_m1
    //   1686: if_icmpne -> 1700
    //   1689: ldc 'TbsSDKExtension'
    //   1691: ldc_w 'replace failed!'
    //   1694: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1697: goto -> 1752
    //   1700: aload #27
    //   1702: invokevirtual delete : ()Z
    //   1705: pop
    //   1706: new java/lang/StringBuilder
    //   1709: dup
    //   1710: invokespecial <init> : ()V
    //   1713: astore #25
    //   1715: aload #25
    //   1717: ldc_w 'replace completed: '
    //   1720: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: pop
    //   1724: aload #25
    //   1726: iload_1
    //   1727: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1730: pop
    //   1731: ldc 'TbsSDKExtension'
    //   1733: aload #25
    //   1735: invokevirtual toString : ()Ljava/lang/String;
    //   1738: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1741: aload #24
    //   1743: iconst_1
    //   1744: invokevirtual a : (Z)V
    //   1747: aload #24
    //   1749: invokevirtual o : ()V
    //   1752: aload #23
    //   1754: invokevirtual close : ()V
    //   1757: aload_2
    //   1758: invokevirtual close : ()V
    //   1761: goto -> 2122
    //   1764: astore #25
    //   1766: aload #23
    //   1768: astore #24
    //   1770: aload #25
    //   1772: astore #23
    //   1774: goto -> 1850
    //   1777: astore #24
    //   1779: aload_2
    //   1780: astore #25
    //   1782: aload #23
    //   1784: astore_2
    //   1785: aload #25
    //   1787: astore #23
    //   1789: goto -> 1824
    //   1792: astore #23
    //   1794: goto -> 1811
    //   1797: astore #24
    //   1799: aload_2
    //   1800: astore #23
    //   1802: aconst_null
    //   1803: astore_2
    //   1804: goto -> 1824
    //   1807: astore #23
    //   1809: aconst_null
    //   1810: astore_2
    //   1811: aconst_null
    //   1812: astore #24
    //   1814: goto -> 1850
    //   1817: astore #24
    //   1819: aconst_null
    //   1820: astore_2
    //   1821: aconst_null
    //   1822: astore #23
    //   1824: aload #24
    //   1826: invokevirtual printStackTrace : ()V
    //   1829: aload_2
    //   1830: ifnull -> 1837
    //   1833: aload_2
    //   1834: invokevirtual close : ()V
    //   1837: aload #23
    //   1839: ifnull -> 2122
    //   1842: aload #23
    //   1844: invokevirtual close : ()V
    //   1847: goto -> 2122
    //   1850: aload #24
    //   1852: ifnull -> 1860
    //   1855: aload #24
    //   1857: invokevirtual close : ()V
    //   1860: aload_2
    //   1861: ifnull -> 1868
    //   1864: aload_2
    //   1865: invokevirtual close : ()V
    //   1868: aload #23
    //   1870: athrow
    //   1871: astore_2
    //   1872: aload_2
    //   1873: invokevirtual printStackTrace : ()V
    //   1876: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.b : Ljava/util/concurrent/locks/Lock;
    //   1879: invokeinterface unlock : ()V
    //   1884: return
    //   1885: astore_2
    //   1886: aconst_null
    //   1887: astore #23
    //   1889: aconst_null
    //   1890: astore #25
    //   1892: aconst_null
    //   1893: astore #26
    //   1895: aload #23
    //   1897: astore #24
    //   1899: aload #25
    //   1901: astore #23
    //   1903: goto -> 2047
    //   1906: astore #31
    //   1908: aconst_null
    //   1909: astore_2
    //   1910: aconst_null
    //   1911: astore #23
    //   1913: aconst_null
    //   1914: astore #26
    //   1916: aload #31
    //   1918: invokevirtual printStackTrace : ()V
    //   1921: aload #31
    //   1923: instanceof java/net/SocketTimeoutException
    //   1926: ifne -> 1986
    //   1929: aload #31
    //   1931: instanceof java/net/SocketException
    //   1934: istore #22
    //   1936: iload #22
    //   1938: ifeq -> 1944
    //   1941: goto -> 1986
    //   1944: aload #23
    //   1946: ifnull -> 1954
    //   1949: aload #23
    //   1951: invokevirtual close : ()V
    //   1954: aload #26
    //   1956: ifnull -> 1964
    //   1959: aload #26
    //   1961: invokevirtual close : ()V
    //   1964: aload_2
    //   1965: ifnull -> 1972
    //   1968: aload_2
    //   1969: invokevirtual close : ()V
    //   1972: aload #28
    //   1974: astore #26
    //   1976: aload_0
    //   1977: astore #31
    //   1979: lload #16
    //   1981: lstore #12
    //   1983: goto -> 3533
    //   1986: aload #23
    //   1988: ifnull -> 1996
    //   1991: aload #23
    //   1993: invokevirtual close : ()V
    //   1996: aload #26
    //   1998: ifnull -> 2006
    //   2001: aload #26
    //   2003: invokevirtual close : ()V
    //   2006: aload_2
    //   2007: ifnull -> 2014
    //   2010: aload_2
    //   2011: invokevirtual close : ()V
    //   2014: aload #30
    //   2016: astore_2
    //   2017: aload #29
    //   2019: astore #23
    //   2021: aload #28
    //   2023: astore #26
    //   2025: aload_0
    //   2026: astore #31
    //   2028: ldc_w 100000
    //   2031: istore_1
    //   2032: lload #16
    //   2034: lstore #12
    //   2036: goto -> 529
    //   2039: astore #25
    //   2041: aload_2
    //   2042: astore #24
    //   2044: aload #25
    //   2046: astore_2
    //   2047: aload #23
    //   2049: ifnull -> 2057
    //   2052: aload #23
    //   2054: invokevirtual close : ()V
    //   2057: aload #26
    //   2059: ifnull -> 2067
    //   2062: aload #26
    //   2064: invokevirtual close : ()V
    //   2067: aload #24
    //   2069: ifnull -> 2077
    //   2072: aload #24
    //   2074: invokevirtual close : ()V
    //   2077: aload_2
    //   2078: athrow
    //   2079: astore_2
    //   2080: goto -> 2131
    //   2083: astore_2
    //   2084: new java/lang/StringBuilder
    //   2087: dup
    //   2088: invokespecial <init> : ()V
    //   2091: astore #23
    //   2093: aload #23
    //   2095: ldc_w 'exception#1: '
    //   2098: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: pop
    //   2102: aload #23
    //   2104: aload_2
    //   2105: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   2108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: pop
    //   2112: ldc 'TbsSDKExtension'
    //   2114: aload #23
    //   2116: invokevirtual toString : ()Ljava/lang/String;
    //   2119: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   2122: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.b : Ljava/util/concurrent/locks/Lock;
    //   2125: invokeinterface unlock : ()V
    //   2130: return
    //   2131: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.b : Ljava/util/concurrent/locks/Lock;
    //   2134: invokeinterface unlock : ()V
    //   2139: aload_2
    //   2140: athrow
    //   2141: ldc 'TbsSDKExtension'
    //   2143: ldc_w 'Begin uploading...'
    //   2146: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   2149: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.c : Ljava/util/concurrent/locks/Lock;
    //   2152: invokeinterface tryLock : ()Z
    //   2157: ifne -> 2169
    //   2160: ldc 'TbsSDKExtension'
    //   2162: ldc_w 'cmdUploadLock failed --> return!'
    //   2165: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   2168: return
    //   2169: invokestatic a : ()Lcom/tencent/tbs/sdk/extension/partner/c/f;
    //   2172: invokevirtual b : ()Ljava/lang/String;
    //   2175: astore #26
    //   2177: ldc_w 'imei'
    //   2180: astore #23
    //   2182: ldc_w 'imei'
    //   2185: invokevirtual getBytes : ()[B
    //   2188: astore #25
    //   2190: invokestatic a : ()Lcom/tencent/tbs/sdk/extension/partner/c/f;
    //   2193: aload #25
    //   2195: invokevirtual a : ([B)[B
    //   2198: invokestatic b : ([B)Ljava/lang/String;
    //   2201: astore #25
    //   2203: aload #25
    //   2205: astore #23
    //   2207: aload #23
    //   2209: ifnull -> 3449
    //   2212: aload #23
    //   2214: invokevirtual isEmpty : ()Z
    //   2217: ifeq -> 2223
    //   2220: goto -> 3449
    //   2223: new java/lang/StringBuilder
    //   2226: dup
    //   2227: invokespecial <init> : ()V
    //   2230: astore #25
    //   2232: aload #25
    //   2234: aload_0
    //   2235: getfield e : Landroid/content/Context;
    //   2238: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/b;
    //   2241: invokevirtual b : ()Ljava/lang/String;
    //   2244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2247: pop
    //   2248: aload #25
    //   2250: aload #23
    //   2252: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: pop
    //   2256: aload #25
    //   2258: invokevirtual toString : ()Ljava/lang/String;
    //   2261: astore #23
    //   2263: new java/lang/StringBuilder
    //   2266: dup
    //   2267: invokespecial <init> : ()V
    //   2270: astore #25
    //   2272: aload #25
    //   2274: aload #23
    //   2276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: pop
    //   2280: aload #25
    //   2282: ldc_w '&ek='
    //   2285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: pop
    //   2289: aload #25
    //   2291: aload #26
    //   2293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: pop
    //   2297: aload #25
    //   2299: invokevirtual toString : ()Ljava/lang/String;
    //   2302: astore #26
    //   2304: new java/util/HashMap
    //   2307: dup
    //   2308: invokespecial <init> : ()V
    //   2311: astore #31
    //   2313: aload #31
    //   2315: ldc_w 'Content-Type'
    //   2318: ldc_w 'application/octet-stream'
    //   2321: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2326: pop
    //   2327: aload #31
    //   2329: ldc_w 'Content-Encoding'
    //   2332: ldc_w 'gzip'
    //   2335: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2340: pop
    //   2341: aload #31
    //   2343: ldc_w 'Charset'
    //   2346: ldc_w 'UTF-8'
    //   2349: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2354: pop
    //   2355: aload_2
    //   2356: aload_2
    //   2357: getstatic java/io/File.separator : Ljava/lang/String;
    //   2360: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   2363: iconst_1
    //   2364: iadd
    //   2365: invokevirtual substring : (I)Ljava/lang/String;
    //   2368: astore #25
    //   2370: new java/io/FileInputStream
    //   2373: dup
    //   2374: new java/io/File
    //   2377: dup
    //   2378: aload #24
    //   2380: invokespecial <init> : (Ljava/lang/String;)V
    //   2383: invokespecial <init> : (Ljava/io/File;)V
    //   2386: astore #23
    //   2388: sipush #8192
    //   2391: newarray byte
    //   2393: astore #29
    //   2395: new java/io/ByteArrayOutputStream
    //   2398: dup
    //   2399: invokespecial <init> : ()V
    //   2402: astore_2
    //   2403: iconst_0
    //   2404: istore #7
    //   2406: iconst_0
    //   2407: istore #8
    //   2409: aload_2
    //   2410: astore #28
    //   2412: aload_2
    //   2413: astore #24
    //   2415: aload #23
    //   2417: astore #27
    //   2419: aload #23
    //   2421: aload #29
    //   2423: invokevirtual read : ([B)I
    //   2426: istore #9
    //   2428: aload_2
    //   2429: astore #24
    //   2431: iload #9
    //   2433: iconst_m1
    //   2434: if_icmpeq -> 3262
    //   2437: iload #7
    //   2439: iload #11
    //   2441: if_icmplt -> 3252
    //   2444: aload_2
    //   2445: astore #28
    //   2447: aload_2
    //   2448: astore #24
    //   2450: aload #23
    //   2452: astore #27
    //   2454: aload_2
    //   2455: aload #29
    //   2457: iconst_0
    //   2458: iload #9
    //   2460: invokevirtual write : ([BII)V
    //   2463: iload #8
    //   2465: iload #9
    //   2467: iadd
    //   2468: istore #10
    //   2470: iload #9
    //   2472: ifle -> 3601
    //   2475: iload #9
    //   2477: sipush #8192
    //   2480: if_icmpge -> 3601
    //   2483: iconst_1
    //   2484: istore #8
    //   2486: goto -> 3604
    //   2489: aload_2
    //   2490: astore #28
    //   2492: aload_2
    //   2493: astore #24
    //   2495: aload #23
    //   2497: astore #27
    //   2499: aload_2
    //   2500: invokevirtual flush : ()V
    //   2503: aload_2
    //   2504: astore #28
    //   2506: aload_2
    //   2507: astore #24
    //   2509: aload #23
    //   2511: astore #27
    //   2513: invokestatic a : ()Lcom/tencent/tbs/sdk/extension/partner/c/f;
    //   2516: aload_2
    //   2517: invokevirtual toByteArray : ()[B
    //   2520: invokevirtual a : ([B)[B
    //   2523: astore #33
    //   2525: aload_2
    //   2526: astore #28
    //   2528: aload_2
    //   2529: astore #24
    //   2531: aload #23
    //   2533: astore #27
    //   2535: new java/lang/StringBuilder
    //   2538: dup
    //   2539: invokespecial <init> : ()V
    //   2542: astore #30
    //   2544: aload_2
    //   2545: astore #28
    //   2547: aload_2
    //   2548: astore #24
    //   2550: aload #23
    //   2552: astore #27
    //   2554: aload #30
    //   2556: aload #25
    //   2558: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: pop
    //   2562: aload_2
    //   2563: astore #28
    //   2565: aload_2
    //   2566: astore #24
    //   2568: aload #23
    //   2570: astore #27
    //   2572: aload #30
    //   2574: ldc_w '_'
    //   2577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: pop
    //   2581: aload_2
    //   2582: astore #28
    //   2584: aload_2
    //   2585: astore #24
    //   2587: aload #23
    //   2589: astore #27
    //   2591: aload #30
    //   2593: iload #7
    //   2595: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2598: pop
    //   2599: aload_2
    //   2600: astore #28
    //   2602: aload_2
    //   2603: astore #24
    //   2605: aload #23
    //   2607: astore #27
    //   2609: aload #30
    //   2611: invokevirtual toString : ()Ljava/lang/String;
    //   2614: astore #34
    //   2616: iload #8
    //   2618: ifeq -> 2697
    //   2621: aload_2
    //   2622: astore #28
    //   2624: aload_2
    //   2625: astore #24
    //   2627: aload #23
    //   2629: astore #27
    //   2631: new java/lang/StringBuilder
    //   2634: dup
    //   2635: invokespecial <init> : ()V
    //   2638: astore #30
    //   2640: aload_2
    //   2641: astore #28
    //   2643: aload_2
    //   2644: astore #24
    //   2646: aload #23
    //   2648: astore #27
    //   2650: aload #30
    //   2652: aload #34
    //   2654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2657: pop
    //   2658: aload_2
    //   2659: astore #28
    //   2661: aload_2
    //   2662: astore #24
    //   2664: aload #23
    //   2666: astore #27
    //   2668: aload #30
    //   2670: ldc_w '_end'
    //   2673: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2676: pop
    //   2677: aload_2
    //   2678: astore #28
    //   2680: aload_2
    //   2681: astore #24
    //   2683: aload #23
    //   2685: astore #27
    //   2687: aload #30
    //   2689: invokevirtual toString : ()Ljava/lang/String;
    //   2692: astore #30
    //   2694: goto -> 2756
    //   2697: aload_2
    //   2698: astore #28
    //   2700: aload_2
    //   2701: astore #24
    //   2703: aload #23
    //   2705: astore #27
    //   2707: new java/lang/StringBuilder
    //   2710: dup
    //   2711: invokespecial <init> : ()V
    //   2714: astore #30
    //   2716: aload_2
    //   2717: astore #28
    //   2719: aload_2
    //   2720: astore #24
    //   2722: aload #23
    //   2724: astore #27
    //   2726: aload #30
    //   2728: aload #34
    //   2730: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2733: pop
    //   2734: aload_2
    //   2735: astore #28
    //   2737: aload_2
    //   2738: astore #24
    //   2740: aload #23
    //   2742: astore #27
    //   2744: aload #30
    //   2746: ldc_w '_204800'
    //   2749: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: pop
    //   2753: goto -> 2677
    //   2756: aload_2
    //   2757: astore #28
    //   2759: aload_2
    //   2760: astore #24
    //   2762: aload #23
    //   2764: astore #27
    //   2766: new java/lang/StringBuilder
    //   2769: dup
    //   2770: aload #26
    //   2772: invokespecial <init> : (Ljava/lang/String;)V
    //   2775: astore #34
    //   2777: aload_2
    //   2778: astore #28
    //   2780: aload_2
    //   2781: astore #24
    //   2783: aload #23
    //   2785: astore #27
    //   2787: new java/lang/StringBuilder
    //   2790: dup
    //   2791: invokespecial <init> : ()V
    //   2794: astore #35
    //   2796: aload_2
    //   2797: astore #28
    //   2799: aload_2
    //   2800: astore #24
    //   2802: aload #23
    //   2804: astore #27
    //   2806: aload #35
    //   2808: ldc_w '&file_name='
    //   2811: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: pop
    //   2815: aload_2
    //   2816: astore #28
    //   2818: aload_2
    //   2819: astore #24
    //   2821: aload #23
    //   2823: astore #27
    //   2825: aload #35
    //   2827: aload #30
    //   2829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: pop
    //   2833: aload_2
    //   2834: astore #28
    //   2836: aload_2
    //   2837: astore #24
    //   2839: aload #23
    //   2841: astore #27
    //   2843: aload #34
    //   2845: aload #35
    //   2847: invokevirtual toString : ()Ljava/lang/String;
    //   2850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2853: pop
    //   2854: aload_2
    //   2855: astore #28
    //   2857: aload_2
    //   2858: astore #24
    //   2860: aload #23
    //   2862: astore #27
    //   2864: new java/lang/StringBuilder
    //   2867: dup
    //   2868: invokespecial <init> : ()V
    //   2871: astore #35
    //   2873: aload_2
    //   2874: astore #28
    //   2876: aload_2
    //   2877: astore #24
    //   2879: aload #23
    //   2881: astore #27
    //   2883: aload #35
    //   2885: ldc_w '&cmdid='
    //   2888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2891: pop
    //   2892: aload_2
    //   2893: astore #28
    //   2895: aload_2
    //   2896: astore #24
    //   2898: aload #23
    //   2900: astore #27
    //   2902: aload #35
    //   2904: iload_1
    //   2905: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2908: pop
    //   2909: aload_2
    //   2910: astore #28
    //   2912: aload_2
    //   2913: astore #24
    //   2915: aload #23
    //   2917: astore #27
    //   2919: aload #34
    //   2921: aload #35
    //   2923: invokevirtual toString : ()Ljava/lang/String;
    //   2926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: pop
    //   2930: iconst_0
    //   2931: istore #9
    //   2933: iload #9
    //   2935: iconst_1
    //   2936: iadd
    //   2937: istore #9
    //   2939: iload #9
    //   2941: iconst_3
    //   2942: if_icmpgt -> 2998
    //   2945: aload_2
    //   2946: astore #28
    //   2948: aload_2
    //   2949: astore #24
    //   2951: aload #23
    //   2953: astore #27
    //   2955: aload_0
    //   2956: getfield r : Z
    //   2959: ifne -> 3627
    //   2962: aload_2
    //   2963: astore #28
    //   2965: aload_2
    //   2966: astore #24
    //   2968: aload #23
    //   2970: astore #27
    //   2972: aload #34
    //   2974: invokevirtual toString : ()Ljava/lang/String;
    //   2977: aload #31
    //   2979: aload #33
    //   2981: new com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl$5
    //   2984: dup
    //   2985: aload_0
    //   2986: invokespecial <init> : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;)V
    //   2989: iconst_1
    //   2990: iconst_1
    //   2991: invokestatic a : (Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/tbs/sdk/extension/partner/c/e$a;ZZ)Ljava/lang/String;
    //   2994: pop
    //   2995: goto -> 2933
    //   2998: iload #9
    //   3000: iconst_3
    //   3001: if_icmple -> 3045
    //   3004: aload_2
    //   3005: astore #28
    //   3007: aload_2
    //   3008: astore #24
    //   3010: aload #23
    //   3012: astore #27
    //   3014: aload_0
    //   3015: getfield r : Z
    //   3018: ifne -> 3045
    //   3021: aload_2
    //   3022: astore #28
    //   3024: aload_2
    //   3025: astore #24
    //   3027: aload #23
    //   3029: astore #27
    //   3031: ldc 'TbsSDKExtension'
    //   3033: ldc_w 'uploadFile failed: post_cnt > max_post_try!'
    //   3036: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   3039: aload_2
    //   3040: astore #24
    //   3042: goto -> 3262
    //   3045: aload_2
    //   3046: astore #28
    //   3048: aload_2
    //   3049: astore #24
    //   3051: aload #23
    //   3053: astore #27
    //   3055: aload_0
    //   3056: getfield r : Z
    //   3059: ifeq -> 3620
    //   3062: aload_2
    //   3063: astore #28
    //   3065: aload_2
    //   3066: astore #24
    //   3068: aload #23
    //   3070: astore #27
    //   3072: new java/lang/StringBuilder
    //   3075: dup
    //   3076: invokespecial <init> : ()V
    //   3079: astore #33
    //   3081: aload_2
    //   3082: astore #28
    //   3084: aload_2
    //   3085: astore #24
    //   3087: aload #23
    //   3089: astore #27
    //   3091: aload #33
    //   3093: aload #30
    //   3095: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3098: pop
    //   3099: aload_2
    //   3100: astore #28
    //   3102: aload_2
    //   3103: astore #24
    //   3105: aload #23
    //   3107: astore #27
    //   3109: aload #33
    //   3111: ldc_w ' post successful!'
    //   3114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3117: pop
    //   3118: aload_2
    //   3119: astore #28
    //   3121: aload_2
    //   3122: astore #24
    //   3124: aload #23
    //   3126: astore #27
    //   3128: ldc 'TbsSDKExtension'
    //   3130: aload #33
    //   3132: invokevirtual toString : ()Ljava/lang/String;
    //   3135: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   3138: aload_2
    //   3139: astore #28
    //   3141: aload_2
    //   3142: astore #24
    //   3144: aload #23
    //   3146: astore #27
    //   3148: new java/io/ByteArrayOutputStream
    //   3151: dup
    //   3152: invokespecial <init> : ()V
    //   3155: astore_2
    //   3156: iload #7
    //   3158: iload #10
    //   3160: iadd
    //   3161: istore #7
    //   3163: aload_0
    //   3164: iconst_0
    //   3165: putfield r : Z
    //   3168: iload #8
    //   3170: ifne -> 3183
    //   3173: aload #32
    //   3175: iload #7
    //   3177: invokevirtual b : (I)V
    //   3180: goto -> 3191
    //   3183: aload #32
    //   3185: ldc_w 2147483647
    //   3188: invokevirtual b : (I)V
    //   3191: aload #32
    //   3193: invokevirtual o : ()V
    //   3196: iconst_0
    //   3197: istore #8
    //   3199: goto -> 3218
    //   3202: astore #25
    //   3204: aload_2
    //   3205: astore #24
    //   3207: aload #25
    //   3209: astore_2
    //   3210: goto -> 3419
    //   3213: astore #24
    //   3215: goto -> 3283
    //   3218: aload_2
    //   3219: astore #28
    //   3221: aload_2
    //   3222: astore #24
    //   3224: aload #23
    //   3226: astore #27
    //   3228: aload_0
    //   3229: getfield e : Landroid/content/Context;
    //   3232: invokestatic a : (Landroid/content/Context;)I
    //   3235: istore #9
    //   3237: iload #9
    //   3239: iconst_3
    //   3240: if_icmpeq -> 3249
    //   3243: aload_2
    //   3244: astore #24
    //   3246: goto -> 3262
    //   3249: goto -> 3259
    //   3252: iload #7
    //   3254: iload #9
    //   3256: iadd
    //   3257: istore #7
    //   3259: goto -> 2409
    //   3262: aload #23
    //   3264: invokevirtual close : ()V
    //   3267: aload #24
    //   3269: ifnull -> 3405
    //   3272: aload #24
    //   3274: astore_2
    //   3275: goto -> 3401
    //   3278: astore #24
    //   3280: aload #28
    //   3282: astore_2
    //   3283: aload #24
    //   3285: astore #25
    //   3287: goto -> 3321
    //   3290: astore_2
    //   3291: aconst_null
    //   3292: astore #24
    //   3294: goto -> 3419
    //   3297: astore #25
    //   3299: aconst_null
    //   3300: astore_2
    //   3301: goto -> 3321
    //   3304: astore_2
    //   3305: aconst_null
    //   3306: astore #24
    //   3308: aconst_null
    //   3309: astore #23
    //   3311: goto -> 3419
    //   3314: astore #25
    //   3316: aconst_null
    //   3317: astore_2
    //   3318: aconst_null
    //   3319: astore #23
    //   3321: aload_2
    //   3322: astore #24
    //   3324: aload #23
    //   3326: astore #27
    //   3328: new java/lang/StringBuilder
    //   3331: dup
    //   3332: invokespecial <init> : ()V
    //   3335: astore #26
    //   3337: aload_2
    //   3338: astore #24
    //   3340: aload #23
    //   3342: astore #27
    //   3344: aload #26
    //   3346: ldc_w 'exception#2: '
    //   3349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3352: pop
    //   3353: aload_2
    //   3354: astore #24
    //   3356: aload #23
    //   3358: astore #27
    //   3360: aload #26
    //   3362: aload #25
    //   3364: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   3367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3370: pop
    //   3371: aload_2
    //   3372: astore #24
    //   3374: aload #23
    //   3376: astore #27
    //   3378: ldc 'TbsSDKExtension'
    //   3380: aload #26
    //   3382: invokevirtual toString : ()Ljava/lang/String;
    //   3385: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   3388: aload #23
    //   3390: ifnull -> 3630
    //   3393: aload #23
    //   3395: invokevirtual close : ()V
    //   3398: goto -> 3630
    //   3401: aload_2
    //   3402: invokevirtual close : ()V
    //   3405: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.c : Ljava/util/concurrent/locks/Lock;
    //   3408: invokeinterface unlock : ()V
    //   3413: return
    //   3414: astore_2
    //   3415: aload #27
    //   3417: astore #23
    //   3419: aload #23
    //   3421: ifnull -> 3429
    //   3424: aload #23
    //   3426: invokevirtual close : ()V
    //   3429: aload #24
    //   3431: ifnull -> 3439
    //   3434: aload #24
    //   3436: invokevirtual close : ()V
    //   3439: getstatic com/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl.c : Ljava/util/concurrent/locks/Lock;
    //   3442: invokeinterface unlock : ()V
    //   3447: aload_2
    //   3448: athrow
    //   3449: ldc 'TbsSDKExtension'
    //   3451: ldc_w 'local IMEI invalid -- no need to execute!'
    //   3454: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   3457: return
    //   3458: astore_2
    //   3459: aload_2
    //   3460: invokevirtual printStackTrace : ()V
    //   3463: return
    //   3464: ldc 'TbsSDKExtension'
    //   3466: ldc_w 'CMD invalid -- no need to execute!'
    //   3469: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   3472: return
    //   3473: astore_2
    //   3474: aload #25
    //   3476: astore #24
    //   3478: goto -> 1414
    //   3481: astore_2
    //   3482: goto -> 1972
    //   3485: astore_2
    //   3486: goto -> 2014
    //   3489: astore #23
    //   3491: goto -> 2077
    //   3494: astore #25
    //   3496: goto -> 2207
    //   3499: astore_2
    //   3500: goto -> 3405
    //   3503: astore #23
    //   3505: goto -> 3439
    //   3508: aload #24
    //   3510: ifnull -> 3520
    //   3513: aload #24
    //   3515: astore #28
    //   3517: goto -> 568
    //   3520: aload #26
    //   3522: astore #28
    //   3524: goto -> 568
    //   3527: lconst_0
    //   3528: lstore #14
    //   3530: goto -> 683
    //   3533: aload #29
    //   3535: astore #23
    //   3537: aload #30
    //   3539: astore_2
    //   3540: goto -> 529
    //   3543: iload #8
    //   3545: sipush #202
    //   3548: if_icmpne -> 3565
    //   3551: aload #30
    //   3553: astore_2
    //   3554: aload #29
    //   3556: astore #23
    //   3558: aload #28
    //   3560: astore #26
    //   3562: goto -> 529
    //   3565: aload #25
    //   3567: astore #24
    //   3569: goto -> 1414
    //   3572: astore #31
    //   3574: aload #23
    //   3576: astore_2
    //   3577: aconst_null
    //   3578: astore #23
    //   3580: aconst_null
    //   3581: astore #26
    //   3583: goto -> 1916
    //   3586: astore #25
    //   3588: aload_2
    //   3589: astore #24
    //   3591: aload #23
    //   3593: astore_2
    //   3594: aload #25
    //   3596: astore #23
    //   3598: goto -> 1850
    //   3601: iconst_0
    //   3602: istore #8
    //   3604: iload #10
    //   3606: ldc_w 204800
    //   3609: if_icmpeq -> 2489
    //   3612: iload #8
    //   3614: ifeq -> 3620
    //   3617: goto -> 2489
    //   3620: iload #10
    //   3622: istore #8
    //   3624: goto -> 3218
    //   3627: goto -> 2998
    //   3630: aload_2
    //   3631: ifnull -> 3405
    //   3634: goto -> 3401
    // Exception table:
    //   from	to	target	type
    //   300	392	3458	java/lang/Exception
    //   543	565	2083	java/lang/Exception
    //   543	565	2079	finally
    //   568	680	2083	java/lang/Exception
    //   568	680	2079	finally
    //   690	732	2083	java/lang/Exception
    //   690	732	2079	finally
    //   739	749	2083	java/lang/Exception
    //   739	749	2079	finally
    //   752	802	2083	java/lang/Exception
    //   752	802	2079	finally
    //   805	812	2083	java/lang/Exception
    //   805	812	2079	finally
    //   847	863	2083	java/lang/Exception
    //   847	863	2079	finally
    //   879	892	2083	java/lang/Exception
    //   879	892	2079	finally
    //   900	907	1906	java/io/IOException
    //   900	907	1885	finally
    //   916	922	1365	java/io/IOException
    //   916	922	1361	finally
    //   926	946	3572	java/io/IOException
    //   926	946	1361	finally
    //   953	981	3572	java/io/IOException
    //   953	981	1361	finally
    //   987	994	1339	java/io/IOException
    //   987	994	1317	finally
    //   994	1006	1312	java/io/IOException
    //   994	1006	1317	finally
    //   1013	1018	1291	java/io/IOException
    //   1013	1018	1275	finally
    //   1037	1049	1256	java/io/IOException
    //   1037	1049	1275	finally
    //   1064	1074	1256	java/io/IOException
    //   1064	1074	1275	finally
    //   1081	1086	1256	java/io/IOException
    //   1081	1086	1275	finally
    //   1093	1098	1256	java/io/IOException
    //   1093	1098	1275	finally
    //   1156	1201	1236	java/io/IOException
    //   1156	1201	1228	finally
    //   1383	1388	3473	java/io/IOException
    //   1383	1388	2083	java/lang/Exception
    //   1383	1388	2079	finally
    //   1392	1396	3473	java/io/IOException
    //   1392	1396	2083	java/lang/Exception
    //   1392	1396	2079	finally
    //   1405	1410	3473	java/io/IOException
    //   1405	1410	2083	java/lang/Exception
    //   1405	1410	2079	finally
    //   1414	1512	2083	java/lang/Exception
    //   1414	1512	2079	finally
    //   1521	1561	1871	java/lang/Exception
    //   1521	1561	2079	finally
    //   1564	1650	1871	java/lang/Exception
    //   1564	1650	2079	finally
    //   1650	1666	1817	java/lang/Exception
    //   1650	1666	1807	finally
    //   1666	1677	1797	java/lang/Exception
    //   1666	1677	1792	finally
    //   1677	1684	1777	java/lang/Exception
    //   1677	1684	1764	finally
    //   1689	1697	1777	java/lang/Exception
    //   1689	1697	1764	finally
    //   1700	1752	1777	java/lang/Exception
    //   1700	1752	1764	finally
    //   1752	1761	2083	java/lang/Exception
    //   1752	1761	2079	finally
    //   1824	1829	3586	finally
    //   1833	1837	2083	java/lang/Exception
    //   1833	1837	2079	finally
    //   1842	1847	2083	java/lang/Exception
    //   1842	1847	2079	finally
    //   1855	1860	2083	java/lang/Exception
    //   1855	1860	2079	finally
    //   1864	1868	2083	java/lang/Exception
    //   1864	1868	2079	finally
    //   1868	1871	2083	java/lang/Exception
    //   1868	1871	2079	finally
    //   1872	1876	2083	java/lang/Exception
    //   1872	1876	2079	finally
    //   1916	1936	2039	finally
    //   1949	1954	3481	java/io/IOException
    //   1949	1954	2083	java/lang/Exception
    //   1949	1954	2079	finally
    //   1959	1964	3481	java/io/IOException
    //   1959	1964	2083	java/lang/Exception
    //   1959	1964	2079	finally
    //   1968	1972	3481	java/io/IOException
    //   1968	1972	2083	java/lang/Exception
    //   1968	1972	2079	finally
    //   1991	1996	3485	java/io/IOException
    //   1991	1996	2083	java/lang/Exception
    //   1991	1996	2079	finally
    //   2001	2006	3485	java/io/IOException
    //   2001	2006	2083	java/lang/Exception
    //   2001	2006	2079	finally
    //   2010	2014	3485	java/io/IOException
    //   2010	2014	2083	java/lang/Exception
    //   2010	2014	2079	finally
    //   2052	2057	3489	java/io/IOException
    //   2052	2057	2083	java/lang/Exception
    //   2052	2057	2079	finally
    //   2062	2067	3489	java/io/IOException
    //   2062	2067	2083	java/lang/Exception
    //   2062	2067	2079	finally
    //   2072	2077	3489	java/io/IOException
    //   2072	2077	2083	java/lang/Exception
    //   2072	2077	2079	finally
    //   2077	2079	2083	java/lang/Exception
    //   2077	2079	2079	finally
    //   2084	2122	2079	finally
    //   2182	2203	3494	java/lang/Exception
    //   2355	2388	3314	java/lang/Exception
    //   2355	2388	3304	finally
    //   2388	2403	3297	java/lang/Exception
    //   2388	2403	3290	finally
    //   2419	2428	3278	java/lang/Exception
    //   2419	2428	3414	finally
    //   2454	2463	3278	java/lang/Exception
    //   2454	2463	3414	finally
    //   2499	2503	3278	java/lang/Exception
    //   2499	2503	3414	finally
    //   2513	2525	3278	java/lang/Exception
    //   2513	2525	3414	finally
    //   2535	2544	3278	java/lang/Exception
    //   2535	2544	3414	finally
    //   2554	2562	3278	java/lang/Exception
    //   2554	2562	3414	finally
    //   2572	2581	3278	java/lang/Exception
    //   2572	2581	3414	finally
    //   2591	2599	3278	java/lang/Exception
    //   2591	2599	3414	finally
    //   2609	2616	3278	java/lang/Exception
    //   2609	2616	3414	finally
    //   2631	2640	3278	java/lang/Exception
    //   2631	2640	3414	finally
    //   2650	2658	3278	java/lang/Exception
    //   2650	2658	3414	finally
    //   2668	2677	3278	java/lang/Exception
    //   2668	2677	3414	finally
    //   2687	2694	3278	java/lang/Exception
    //   2687	2694	3414	finally
    //   2707	2716	3278	java/lang/Exception
    //   2707	2716	3414	finally
    //   2726	2734	3278	java/lang/Exception
    //   2726	2734	3414	finally
    //   2744	2753	3278	java/lang/Exception
    //   2744	2753	3414	finally
    //   2766	2777	3278	java/lang/Exception
    //   2766	2777	3414	finally
    //   2787	2796	3278	java/lang/Exception
    //   2787	2796	3414	finally
    //   2806	2815	3278	java/lang/Exception
    //   2806	2815	3414	finally
    //   2825	2833	3278	java/lang/Exception
    //   2825	2833	3414	finally
    //   2843	2854	3278	java/lang/Exception
    //   2843	2854	3414	finally
    //   2864	2873	3278	java/lang/Exception
    //   2864	2873	3414	finally
    //   2883	2892	3278	java/lang/Exception
    //   2883	2892	3414	finally
    //   2902	2909	3278	java/lang/Exception
    //   2902	2909	3414	finally
    //   2919	2930	3278	java/lang/Exception
    //   2919	2930	3414	finally
    //   2955	2962	3278	java/lang/Exception
    //   2955	2962	3414	finally
    //   2972	2995	3278	java/lang/Exception
    //   2972	2995	3414	finally
    //   3014	3021	3278	java/lang/Exception
    //   3014	3021	3414	finally
    //   3031	3039	3278	java/lang/Exception
    //   3031	3039	3414	finally
    //   3055	3062	3278	java/lang/Exception
    //   3055	3062	3414	finally
    //   3072	3081	3278	java/lang/Exception
    //   3072	3081	3414	finally
    //   3091	3099	3278	java/lang/Exception
    //   3091	3099	3414	finally
    //   3109	3118	3278	java/lang/Exception
    //   3109	3118	3414	finally
    //   3128	3138	3278	java/lang/Exception
    //   3128	3138	3414	finally
    //   3148	3156	3278	java/lang/Exception
    //   3148	3156	3414	finally
    //   3163	3168	3213	java/lang/Exception
    //   3163	3168	3202	finally
    //   3173	3180	3213	java/lang/Exception
    //   3173	3180	3202	finally
    //   3183	3191	3213	java/lang/Exception
    //   3183	3191	3202	finally
    //   3191	3196	3213	java/lang/Exception
    //   3191	3196	3202	finally
    //   3228	3237	3278	java/lang/Exception
    //   3228	3237	3414	finally
    //   3262	3267	3499	java/lang/Exception
    //   3328	3337	3414	finally
    //   3344	3353	3414	finally
    //   3360	3371	3414	finally
    //   3378	3388	3414	finally
    //   3393	3398	3499	java/lang/Exception
    //   3401	3405	3499	java/lang/Exception
    //   3424	3429	3503	java/lang/Exception
    //   3434	3439	3503	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    b.a = paramString1;
    b.b = paramString2;
    b.c = paramString3;
    b.d = paramString4;
  }
  
  public boolean a() {
    return (Build.VERSION.SDK_INT < 11 || c.a(this.e).m() < 600);
  }
  
  public boolean a(int paramInt) {
    return (Build.VERSION.SDK_INT < 11 || paramInt < 600);
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    return a(paramInt1, paramInt2, 20000);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[TbsSDKExtension.isX5Disabled] tbsVersion=");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" tbsSdkVersion=");
    stringBuilder.append(paramInt2);
    stringBuilder.toString();
    if (this.h && System.currentTimeMillis() - this.i <= 86400000L) {
      if (this.g) {
        g(506);
        stringBuilder = new StringBuilder();
        stringBuilder.append("506, HasSyncX5Switch; tbsVersion=");
        stringBuilder.append(paramInt1);
        stringBuilder.append(" tbsSdkVersion=");
        stringBuilder.append(paramInt2);
        b(stringBuilder.toString());
      } 
      return this.g;
    } 
    try {
      this.g = a("044800");
      if (this.g) {
        g(507);
        stringBuilder = new StringBuilder();
        stringBuilder.append("507, flag from tbsDownloadConfig;tbsVersion=");
        stringBuilder.append(paramInt1);
        stringBuilder.append(" tbsSdkVersion=");
        stringBuilder.append(paramInt2);
        b(stringBuilder.toString());
      } 
      (new Timer()).schedule(new TimerTask(this, paramInt1, paramInt2) {
            public void run() {
              // Byte code:
              //   0: aload_0
              //   1: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   4: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;)Landroid/content/Context;
              //   7: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/c;
              //   10: astore #9
              //   12: aload #9
              //   14: invokevirtual j : ()Ljava/lang/String;
              //   17: astore #10
              //   19: aload #9
              //   21: invokevirtual k : ()I
              //   24: istore_3
              //   25: aload #9
              //   27: invokevirtual l : ()Ljava/lang/String;
              //   30: astore #11
              //   32: aload_0
              //   33: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   36: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;)Landroid/content/Context;
              //   39: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
              //   42: astore #12
              //   44: aload_0
              //   45: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   48: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;)Landroid/content/Context;
              //   51: invokestatic b : (Landroid/content/Context;)I
              //   54: istore #4
              //   56: aload_0
              //   57: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   60: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;)Landroid/content/Context;
              //   63: ldc 'com.tencent.mm.BuildInfo.CLIENT_VERSION'
              //   65: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
              //   68: astore #13
              //   70: invokestatic currentTimeMillis : ()J
              //   73: lstore #5
              //   75: aload_0
              //   76: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   79: aload #9
              //   81: invokevirtual i : ()J
              //   84: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;J)J
              //   87: pop2
              //   88: aload_0
              //   89: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   92: invokestatic b : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;)J
              //   95: lstore #7
              //   97: iconst_1
              //   98: istore_2
              //   99: lload #5
              //   101: lload #7
              //   103: lsub
              //   104: ldc2_w 86400000
              //   107: lcmp
              //   108: ifle -> 116
              //   111: iload_2
              //   112: istore_1
              //   113: goto -> 168
              //   116: aload #12
              //   118: ifnull -> 166
              //   121: iload #4
              //   123: ifeq -> 166
              //   126: aload #13
              //   128: ifnull -> 166
              //   131: iload_2
              //   132: istore_1
              //   133: aload #12
              //   135: aload #10
              //   137: invokevirtual equals : (Ljava/lang/Object;)Z
              //   140: ifeq -> 168
              //   143: iload_2
              //   144: istore_1
              //   145: iload #4
              //   147: iload_3
              //   148: if_icmpne -> 168
              //   151: aload #13
              //   153: aload #11
              //   155: invokevirtual equals : (Ljava/lang/Object;)Z
              //   158: ifne -> 166
              //   161: iload_2
              //   162: istore_1
              //   163: goto -> 168
              //   166: iconst_0
              //   167: istore_1
              //   168: iload_1
              //   169: ifeq -> 188
              //   172: aload_0
              //   173: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   176: aload_0
              //   177: getfield a : I
              //   180: aload_0
              //   181: getfield b : I
              //   184: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;II)V
              //   187: return
              //   188: aload_0
              //   189: getfield c : Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;
              //   192: iconst_m1
              //   193: aconst_null
              //   194: invokestatic a : (Lcom/tencent/tbs/sdk/extension/partner/PartnerSDKExtensionServiceImpl;ILjava/lang/String;)V
              //   197: return
            }
          }paramInt3);
    } catch (Exception exception) {}
    this.h = true;
    return this.g;
  }
  
  public boolean a(String paramString) {
    File file = a(this.e);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tbs_switch_disable_");
    stringBuilder.append(paramString);
    return (new File(file, stringBuilder.toString())).exists();
  }
  
  public String[] a(Context paramContext1, Context paramContext2, String paramString) {
    if (Build.VERSION.SDK_INT >= 28 && (paramContext1.getApplicationInfo()).targetSdkVersion >= 28) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("/apache_dex.jar");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString);
      stringBuilder2.append("/tbs_jars_fusion_dex.jar");
      return new String[] { str, stringBuilder2.toString() };
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("/tbs_jars_fusion_dex.jar");
    return new String[] { stringBuilder.toString() };
  }
  
  public int b() {
    return this.n;
  }
  
  File b(Context paramContext) {
    File file = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "share");
    return (!file.isDirectory() && !file.mkdir()) ? null : file;
  }
  
  public boolean b(int paramInt) {
    int i = c.a(this.e).g() ^ true;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("canLoadVideo :");
    stringBuilder.append(i);
    stringBuilder.toString();
    return i;
  }
  
  public boolean b(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #9
    //   9: aload #9
    //   11: ldc_w '[TbsSDKExtension.isX5DisabledSync] tbsVersion='
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload #9
    //   20: iload_1
    //   21: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #9
    //   27: ldc_w ' tbsSdkVersion='
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #9
    //   36: iload_2
    //   37: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #9
    //   43: invokevirtual toString : ()Ljava/lang/String;
    //   46: pop
    //   47: aload_0
    //   48: getfield h : Z
    //   51: ifeq -> 74
    //   54: invokestatic currentTimeMillis : ()J
    //   57: aload_0
    //   58: getfield i : J
    //   61: lsub
    //   62: ldc2_w 86400000
    //   65: lcmp
    //   66: ifgt -> 74
    //   69: aload_0
    //   70: getfield g : Z
    //   73: ireturn
    //   74: aload_0
    //   75: getfield e : Landroid/content/Context;
    //   78: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/c;
    //   81: astore #9
    //   83: aload_0
    //   84: aload #9
    //   86: iload_1
    //   87: invokevirtual d : (I)Z
    //   90: putfield g : Z
    //   93: iconst_0
    //   94: istore #4
    //   96: aload #9
    //   98: invokevirtual j : ()Ljava/lang/String;
    //   101: astore #10
    //   103: aload #9
    //   105: invokevirtual k : ()I
    //   108: istore #5
    //   110: aload #9
    //   112: invokevirtual l : ()Ljava/lang/String;
    //   115: astore #11
    //   117: aload_0
    //   118: getfield e : Landroid/content/Context;
    //   121: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   124: astore #12
    //   126: aload_0
    //   127: getfield e : Landroid/content/Context;
    //   130: invokestatic b : (Landroid/content/Context;)I
    //   133: istore #6
    //   135: aload_0
    //   136: getfield e : Landroid/content/Context;
    //   139: ldc_w 'com.tencent.mm.BuildInfo.CLIENT_VERSION'
    //   142: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   145: astore #13
    //   147: invokestatic currentTimeMillis : ()J
    //   150: lstore #7
    //   152: aload_0
    //   153: aload #9
    //   155: invokevirtual i : ()J
    //   158: putfield i : J
    //   161: lload #7
    //   163: aload_0
    //   164: getfield i : J
    //   167: lsub
    //   168: ldc2_w 86400000
    //   171: lcmp
    //   172: ifle -> 178
    //   175: goto -> 260
    //   178: iload #4
    //   180: istore_3
    //   181: aload #12
    //   183: ifnull -> 235
    //   186: iload #4
    //   188: istore_3
    //   189: iload #6
    //   191: ifeq -> 235
    //   194: iload #4
    //   196: istore_3
    //   197: aload #13
    //   199: ifnull -> 235
    //   202: aload #12
    //   204: aload #10
    //   206: invokevirtual equals : (Ljava/lang/Object;)Z
    //   209: ifeq -> 260
    //   212: iload #6
    //   214: iload #5
    //   216: if_icmpne -> 260
    //   219: iload #4
    //   221: istore_3
    //   222: aload #13
    //   224: aload #11
    //   226: invokevirtual equals : (Ljava/lang/Object;)Z
    //   229: ifne -> 235
    //   232: goto -> 260
    //   235: iload_3
    //   236: ifeq -> 245
    //   239: aload_0
    //   240: iload_1
    //   241: iload_2
    //   242: invokespecial c : (II)V
    //   245: aload_0
    //   246: iconst_1
    //   247: putfield h : Z
    //   250: aload_0
    //   251: getfield g : Z
    //   254: ireturn
    //   255: astore #9
    //   257: goto -> 245
    //   260: iconst_1
    //   261: istore_3
    //   262: goto -> 235
    // Exception table:
    //   from	to	target	type
    //   74	93	255	java/lang/Exception
    //   96	175	255	java/lang/Exception
    //   202	212	255	java/lang/Exception
    //   222	232	255	java/lang/Exception
    //   239	245	255	java/lang/Exception
  }
  
  public boolean c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("canUseGamePlayer :");
    stringBuilder.append(true);
    stringBuilder.toString();
    return true;
  }
  
  public boolean c(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("canLoadX5 - totalRAM: ");
    stringBuilder.append(paramInt);
    g.b("TbsSDKExtension", stringBuilder.toString());
    if (this.k) {
      if (paramInt < 170) {
        this.j = false;
        int i = c.a();
        g(500);
        stringBuilder = new StringBuilder();
        stringBuilder.append("500, ram(");
        stringBuilder.append(paramInt);
        stringBuilder.append(") is less than ");
        stringBuilder.append(170);
        paramInt = i;
      } else {
        if (!this.j) {
          g(505);
          b("505, HasSyncCanLoadX5!");
        } 
        return this.j;
      } 
    } else if (Build.VERSION.SDK_INT < 7 || paramInt < 170) {
      this.j = false;
      this.k = true;
      g(501);
      int i = c.a();
      stringBuilder = new StringBuilder();
      stringBuilder.append("501, ram(");
      stringBuilder.append(paramInt);
      stringBuilder.append(") is less than ");
      stringBuilder.append(170);
      stringBuilder.append("; sdk_int: ");
      stringBuilder.append(Build.VERSION.SDK_INT);
      paramInt = i;
    } else {
      StringBuilder stringBuilder1;
      if (!a(Build.VERSION.RELEASE, "4", "11")) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("510, has not support Android ");
        stringBuilder.append(Build.VERSION.RELEASE);
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("canLoadX5: Build.VERSION.RELEASE=");
        stringBuilder.append(Build.VERSION.RELEASE);
        stringBuilder.toString();
        if (this.f == null) {
          this.j = false;
          this.k = true;
          g(502);
          String str1 = "502, mHostContext is null";
          b(str1);
          return false;
        } 
        try {
          paramInt = Build.VERSION.SDK_INT;
          if (paramInt > 30 || paramInt < 14) {
            this.j = false;
            this.k = true;
            g(503);
            stringBuilder = new StringBuilder();
            stringBuilder.append("503, sdk_int: ");
            stringBuilder.append(paramInt);
            stringBuilder.append("; range(");
            stringBuilder.append(14);
            stringBuilder.append(",");
            stringBuilder.append(30);
            stringBuilder.append(")");
            b(stringBuilder.toString());
            return false;
          } 
          f(j());
          this.j = true;
          this.k = true;
          return true;
        } catch (Exception exception) {
          exception.printStackTrace();
          this.j = false;
          this.k = true;
          g(504);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("504, mCanLoadX5: ");
          stringBuilder1.append(this.j);
          stringBuilder1.append(", mHasSyncCanLoadX5: ");
          stringBuilder1.append(this.k);
        } 
      } 
      str = stringBuilder1.toString();
      b(str);
      return false;
    } 
    str.append("; totalRam2: ");
    str.append(paramInt);
    String str = str.toString();
    b(str);
    return false;
  }
  
  public Bundle d(int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("canLoadX5Core - tbsSdkVersion:");
    stringBuilder1.append(paramInt);
    stringBuilder1.toString();
    this.l = paramInt;
    Bundle bundle = new Bundle();
    if (this.a && a.a().e()) {
      bundle.putInt("result_code", -3);
      g.a("TbsSDKExtension", "enter debugtbs, disable x5 by debug!!");
      return bundle;
    } 
    if (this.f == null) {
      bundle.putInt("result_code", -1);
      g(511);
      b("511, host context is null!");
      return bundle;
    } 
    String str = c.a(this.e).n();
    bundle.putString("tbs_core_version", str);
    bundle.putStringArray("tbs_jarfiles", a(this.e, this.f, ""));
    bundle.putString("tbs_librarypath", a(this.e, this.f));
    boolean bool = c(c.a(this.e).m());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("canLoadX5Core-afterEnter canLoadX5 = ");
    stringBuilder2.append(bool);
    stringBuilder2.toString();
    if (!bool) {
      bundle.putInt("result_code", -1);
      return bundle;
    } 
    if (c(str)) {
      g(508);
      b("508, disabled by crash detection!");
      try {
        Context context = this.e;
        String str1 = j();
        if (str1 != null)
          a.a(context, str1, false, "TBS_PRECHECK_REPORT_DISABLE"); 
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      } 
      bundle.putInt("result_code", -1);
      return bundle;
    } 
    if (a(Integer.parseInt((String)throwable), paramInt)) {
      bundle.putInt("result_code", -2);
      return bundle;
    } 
    bundle.putInt("result_code", 0);
    return bundle;
  }
  
  public void d() {
    a.a().b(this.e);
  }
  
  public Bundle e(int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putStringArray("tbs_jarfiles", a(this.e, this.f, ""));
    bundle.putString("tbs_librarypath", a(this.e, this.f));
    return bundle;
  }
  
  public void e() {
    c c1 = c.a(this.e);
    a.a().a(this.e, Integer.valueOf(3000), new a.a(this, c1) {
          public void a(String param1String) {
            Log.e("EmergenceQueryPublisher", "Execute command force x5 disable request");
            this.a.a(Long.valueOf(0L));
            this.a.o();
          }
        });
  }
  
  public boolean f(int paramInt) {
    return (paramInt == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\PartnerSDKExtensionServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
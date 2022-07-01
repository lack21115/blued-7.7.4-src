package com.tencent.bugly.yaq.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import com.tencent.bugly.yaq.BuglyStrategy;
import com.tencent.bugly.yaq.CrashModule;
import com.tencent.bugly.yaq.a;
import com.tencent.bugly.yaq.b;
import com.tencent.bugly.yaq.crashreport.biz.b;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrashReport {
  private static Context a;
  
  public CrashReport() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void closeBugly() {
    if (!b.a) {
      Log.w(x.a, "Can not close bugly because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void closeCrashReport() {
    if (!b.a) {
      Log.w(x.a, "Can not close crash report because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void closeNativeReport() {
    if (!b.a) {
      Log.w(x.a, "Can not close native report because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void enableBugly(boolean paramBoolean) {
    b.a = paramBoolean;
    throw new VerifyError("bad dex opcode");
  }
  
  public static void enableObtainId(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set DB name because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.w(x.a, "enableObtainId args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    String str = x.a;
    new StringBuilder("Enable identification obtaining? ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static Set<String> getAllUserDataKeys(Context paramContext) {
    if (!b.a) {
      Log.w(x.a, "Can not get all keys of user data because bugly is disable.");
      return new HashSet<String>();
    } 
    if (paramContext == null) {
      Log.e(x.a, "getAllUserDataKeys args context should not be null");
      return new HashSet<String>();
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getAppChannel() {
    if (!b.a) {
      Log.w(x.a, "Can not get App channel because bugly is disable.");
      return "unknown";
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getAppID() {
    if (!b.a) {
      Log.w(x.a, "Can not get App ID because bugly is disable.");
      return "unknown";
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getAppVer() {
    if (!b.a) {
      Log.w(x.a, "Can not get app version because bugly is disable.");
      return "unknown";
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getBuglyVersion(Context paramContext) {
    if (paramContext == null) {
      x.d("Please call with context.", new Object[0]);
      return "unknown";
    } 
    a.a(paramContext);
    return a.c();
  }
  
  public static Map<String, String> getSdkExtraData() {
    if (!b.a) {
      Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
      return new HashMap<String, String>();
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Map<String, String> getSdkExtraData(Context paramContext) {
    if (!b.a) {
      Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
      return new HashMap<String, String>();
    } 
    if (paramContext == null) {
      x.d("Context should not be null.", new Object[0]);
      return null;
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getUserData(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not get user data because bugly is disable.");
      return "unknown";
    } 
    if (paramContext == null) {
      Log.e(x.a, "getUserDataValue args context should not be null");
      return "unknown";
    } 
    if (z.a(paramString))
      return null; 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static int getUserDatasSize(Context paramContext) {
    if (!b.a) {
      Log.w(x.a, "Can not get size of user data because bugly is disable.");
      return -1;
    } 
    if (paramContext == null) {
      Log.e(x.a, "getUserDatasSize args context should not be null");
      return -1;
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getUserId() {
    if (!b.a) {
      Log.w(x.a, "Can not get user ID because bugly is disable.");
      return "unknown";
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static int getUserSceneTagId(Context paramContext) {
    if (!b.a) {
      Log.w(x.a, "Can not get user scene tag because bugly is disable.");
      return -1;
    } 
    if (paramContext == null) {
      Log.e(x.a, "getUserSceneTagId args context should not be null");
      return -1;
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void initCrashReport(Context paramContext) {
    a = paramContext;
    b.a((a)CrashModule.getInstance());
    b.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void initCrashReport(Context paramContext, UserStrategy paramUserStrategy) {
    a = paramContext;
    b.a((a)CrashModule.getInstance());
    b.a(paramContext, paramUserStrategy);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean) {
    if (paramContext != null) {
      a = paramContext;
      b.a((a)CrashModule.getInstance());
      b.a(paramContext, paramString, paramBoolean, null);
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean, UserStrategy paramUserStrategy) {
    if (paramContext != null) {
      a = paramContext;
      b.a((a)CrashModule.getInstance());
      b.a(paramContext, paramString, paramBoolean, paramUserStrategy);
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean isLastSessionCrash() {
    if (!b.a) {
      Log.w(x.a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
      return false;
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void postCatchedException(Throwable paramThrowable) {
    postCatchedException(paramThrowable, Thread.currentThread(), false);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void postCatchedException(Throwable paramThrowable, Thread paramThread) {
    postCatchedException(paramThrowable, paramThread, false);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void postCatchedException(Throwable paramThrowable, Thread paramThread, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not post crash caught because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void postException(int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    postException(Thread.currentThread(), paramInt, paramString1, paramString2, paramString3, paramMap);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void postException(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    if (!b.a) {
      Log.w(x.a, "Can not post crash caught because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  private static void putSdkData(Context paramContext, String paramString1, String paramString2) {
    if (paramContext == null || z.a(paramString1) || z.a(paramString2))
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void putUserData(Context paramContext, String paramString1, String paramString2) {
    if (!b.a) {
      Log.w(x.a, "Can not put user data because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.w(x.a, "putUserData args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramString1 == null) {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramString2 == null) {
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static String removeUserData(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not remove user data because bugly is disable.");
      return "unknown";
    } 
    if (paramContext == null) {
      Log.e(x.a, "removeUserData args context should not be null");
      return "unknown";
    } 
    if (z.a(paramString))
      return null; 
    x.b("[param] remove user data: %s", new Object[] { paramString });
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setAppChannel(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App channel because Bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppChannel args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramString == null) {
      Log.w(x.a, "App channel is null, will not set");
      throw new VerifyError("bad dex opcode");
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setAppPackage(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppPackage args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramString == null) {
      Log.w(x.a, "App package is null, will not set");
      throw new VerifyError("bad dex opcode");
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setAppVersion(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App version because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppVersion args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramString == null) {
      Log.w(x.a, "App version is null, will not set");
      throw new VerifyError("bad dex opcode");
    } 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setAuditEnable(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppPackage args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    String str = x.a;
    new StringBuilder("Set audit enable: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setBuglyDbName(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set DB name because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    paramString = x.a;
    new StringBuilder("Set Bugly DB name: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setContext(Context paramContext) {
    a = paramContext;
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setCrashFilter(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    paramString = x.a;
    new StringBuilder("Set crash stack filter: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setCrashRegularFilter(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    paramString = x.a;
    new StringBuilder("Set crash stack filter: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setHandleNativeCrashInJava(boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    String str = x.a;
    new StringBuilder("Should handle native crash in Java profile after handled in native profile: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setIsAppForeground(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set 'isAppForeground' because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      x.d("Context should not be null.", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean) {
      x.c("App is in foreground.", new Object[0]);
      a.a(paramContext);
      throw new VerifyError("bad dex opcode");
    } 
    x.c("App is in background.", new Object[0]);
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setIsDevelopmentDevice(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      x.d("Context should not be null.", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean) {
      x.c("This is a development device.", new Object[0]);
      a.a(paramContext);
      throw new VerifyError("bad dex opcode");
    } 
    x.c("This is not a development device.", new Object[0]);
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean) {
    return setJavascriptMonitor(paramWebView, paramBoolean, false);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramWebView == null) {
      Log.w(x.a, "WebView is null.");
      return false;
    } 
    return setJavascriptMonitor(new WebViewInterface(paramWebView) {
          public final void addJavascriptInterface(H5JavaScriptInterface param1H5JavaScriptInterface, String param1String) {
            throw new VerifyError("bad dex opcode");
          }
          
          public final CharSequence getContentDescription() {
            throw new VerifyError("bad dex opcode");
          }
          
          public final String getUrl() {
            throw new VerifyError("bad dex opcode");
          }
          
          public final void loadUrl(String param1String) {
            throw new VerifyError("bad dex opcode");
          }
          
          public final void setJavaScriptEnabled(boolean param1Boolean) {
            throw new VerifyError("bad dex opcode");
          }
        },  paramBoolean1, paramBoolean2);
  }
  
  public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean) {
    return setJavascriptMonitor(paramWebViewInterface, paramBoolean, false);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramWebViewInterface == null) {
      Log.w(x.a, "WebViewInterface is null.");
      return false;
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setSdkExtraData(Context paramContext, String paramString1, String paramString2) {
    if (!b.a) {
      Log.w(x.a, "Can not put SDK extra data because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext != null && !z.a(paramString1) && !z.a(paramString2)) {
      a.a(paramContext);
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setServerUrl(String paramString) {
    if (z.a(paramString) || !z.c(paramString)) {
      Log.i(x.a, "URL is invalid.");
      throw new VerifyError("bad dex opcode");
    } 
    a.a(paramString);
    StrategyBean.b = paramString;
    StrategyBean.c = paramString;
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setSessionIntervalMills(long paramLong) {
    if (!b.a) {
      Log.w(x.a, "Can not set 'SessionIntervalMills' because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    b.a(paramLong);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setUserId(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set user ID because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.e(x.a, "Context should not be null when bugly has not been initialed!");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramString == null) {
      x.d("userId should not be null", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setUserId(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set user ID because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setUserSceneTag(Context paramContext, int paramInt) {
    if (!b.a) {
      Log.w(x.a, "Can not set tag caught because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramContext == null) {
      Log.e(x.a, "setTag args context should not be null");
      throw new VerifyError("bad dex opcode");
    } 
    if (paramInt <= 0)
      x.d("setTag args tagId should > 0", new Object[0]); 
    a.a(paramContext);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void startCrashReport() {
    if (!b.a) {
      Log.w(x.a, "Can not start crash report because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void testANRCrash() {
    if (!b.a) {
      Log.w(x.a, "Can not test ANR crash because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void testJavaCrash() {
    if (!b.a) {
      Log.w(x.a, "Can not test Java crash because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static void testNativeCrash() {
    testNativeCrash(false, false, false);
    throw new VerifyError("bad dex opcode");
  }
  
  public static void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (!b.a) {
      Log.w(x.a, "Can not test native crash because bugly is disable.");
      throw new VerifyError("bad dex opcode");
    } 
    CrashModule.getInstance();
    throw new VerifyError("bad dex opcode");
  }
  
  public static class CrashHandleCallback extends BuglyStrategy.a {
    public CrashHandleCallback() {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static class UserStrategy extends BuglyStrategy {
    private CrashReport.CrashHandleCallback a;
    
    public UserStrategy(Context param1Context) {
      throw new VerifyError("bad dex opcode");
    }
    
    public CrashReport.CrashHandleCallback getCrashHandleCallback() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/VerifyError
      //   5: dup
      //   6: ldc 'bad dex opcode'
      //   8: invokespecial <init> : (Ljava/lang/String;)V
      //   11: athrow
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	12	finally
    }
    
    public void setCrashHandleCallback(CrashReport.CrashHandleCallback param1CrashHandleCallback) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/VerifyError
      //   5: dup
      //   6: ldc 'bad dex opcode'
      //   8: invokespecial <init> : (Ljava/lang/String;)V
      //   11: athrow
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	12	finally
    }
  }
  
  public static interface WebViewInterface {
    void addJavascriptInterface(H5JavaScriptInterface param1H5JavaScriptInterface, String param1String);
    
    CharSequence getContentDescription();
    
    String getUrl();
    
    void loadUrl(String param1String);
    
    void setJavaScriptEnabled(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\CrashReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
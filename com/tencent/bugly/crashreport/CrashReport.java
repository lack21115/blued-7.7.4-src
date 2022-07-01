package com.tencent.bugly.crashreport;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.a;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.h5.b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrashReport {
  private static Context a;
  
  public static void closeBugly() {
    if (!b.a) {
      Log.w(x.a, "Can not close bugly because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    if (a == null)
      return; 
    BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
    if (buglyBroadcastReceiver != null)
      buglyBroadcastReceiver.unregister(a); 
    closeCrashReport();
    b.a(a);
    w w = w.a();
    if (w != null)
      w.b(); 
  }
  
  public static void closeCrashReport() {
    if (!b.a) {
      Log.w(x.a, "Can not close crash report because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    c.a().d();
  }
  
  public static void closeNativeReport() {
    if (!b.a) {
      Log.w(x.a, "Can not close native report because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    c.a().f();
  }
  
  public static void enableBugly(boolean paramBoolean) {
    b.a = paramBoolean;
  }
  
  public static void enableObtainId(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set DB name because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.w(x.a, "enableObtainId args context should not be null");
      return;
    } 
    String str = x.a;
    StringBuilder stringBuilder = new StringBuilder("Enable identification obtaining? ");
    stringBuilder.append(paramBoolean);
    Log.i(str, stringBuilder.toString());
    a.a(paramContext).b(paramBoolean);
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
    return a.a(paramContext).E();
  }
  
  public static String getAppChannel() {
    if (!b.a) {
      Log.w(x.a, "Can not get App channel because bugly is disable.");
      return "unknown";
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    } 
    return (a.a(a)).m;
  }
  
  public static String getAppID() {
    if (!b.a) {
      Log.w(x.a, "Can not get App ID because bugly is disable.");
      return "unknown";
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    } 
    return a.a(a).f();
  }
  
  public static String getAppVer() {
    if (!b.a) {
      Log.w(x.a, "Can not get app version because bugly is disable.");
      return "unknown";
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    } 
    return (a.a(a)).k;
  }
  
  public static String getBuglyVersion(Context paramContext) {
    if (paramContext == null) {
      x.d("Please call with context.", new Object[0]);
      return "unknown";
    } 
    return a.a(paramContext).c();
  }
  
  public static Proxy getHttpProxy() {
    return a.b();
  }
  
  public static Map<String, String> getSdkExtraData() {
    if (!b.a) {
      Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
      return new HashMap<String, String>();
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return null;
    } 
    return (a.a(a)).C;
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
    return (a.a(paramContext)).C;
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
    return z.a(paramString) ? null : a.a(paramContext).g(paramString);
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
    return a.a(paramContext).D();
  }
  
  public static String getUserId() {
    if (!b.a) {
      Log.w(x.a, "Can not get user ID because bugly is disable.");
      return "unknown";
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    } 
    return a.a(a).g();
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
    return a.a(paramContext).H();
  }
  
  public static void initCrashReport(Context paramContext) {
    if (paramContext == null)
      return; 
    a = paramContext;
    b.a((a)CrashModule.getInstance());
    b.a(paramContext);
  }
  
  public static void initCrashReport(Context paramContext, UserStrategy paramUserStrategy) {
    if (paramContext == null)
      return; 
    a = paramContext;
    b.a((a)CrashModule.getInstance());
    b.a(paramContext, paramUserStrategy);
  }
  
  public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean) {
    if (paramContext != null) {
      a = paramContext;
      b.a((a)CrashModule.getInstance());
      b.a(paramContext, paramString, paramBoolean, null);
    } 
  }
  
  public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean, UserStrategy paramUserStrategy) {
    if (paramContext == null)
      return; 
    a = paramContext;
    b.a((a)CrashModule.getInstance());
    b.a(paramContext, paramString, paramBoolean, paramUserStrategy);
  }
  
  public static boolean isLastSessionCrash() {
    if (!b.a) {
      Log.w(x.a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
      return false;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return false;
    } 
    return c.a().b();
  }
  
  public static void postCatchedException(Throwable paramThrowable) {
    postCatchedException(paramThrowable, Thread.currentThread(), false);
  }
  
  public static void postCatchedException(Throwable paramThrowable, Thread paramThread) {
    postCatchedException(paramThrowable, paramThread, false);
  }
  
  public static void postCatchedException(Throwable paramThrowable, Thread paramThread, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not post crash caught because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    if (paramThrowable == null) {
      x.d("throwable is null, just return", new Object[0]);
      return;
    } 
    Thread thread = paramThread;
    if (paramThread == null)
      thread = Thread.currentThread(); 
    c.a().a(thread, paramThrowable, false, null, null, paramBoolean);
  }
  
  public static void postException(int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    postException(Thread.currentThread(), paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  public static void postException(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    if (!b.a) {
      Log.w(x.a, "Can not post crash caught because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    d.a(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  private static void putSdkData(Context paramContext, String paramString1, String paramString2) {
    if (paramContext != null && !z.a(paramString1)) {
      if (z.a(paramString2))
        return; 
      String str = paramString1.replace("[a-zA-Z[0-9]]+", "");
      paramString1 = str;
      if (str.length() > 100) {
        Log.w(x.a, String.format("putSdkData key length over limit %d, will be cutted.", new Object[] { Integer.valueOf(50) }));
        paramString1 = str.substring(0, 50);
      } 
      str = paramString2;
      if (paramString2.length() > 500) {
        Log.w(x.a, String.format("putSdkData value length over limit %d, will be cutted!", new Object[] { Integer.valueOf(200) }));
        str = paramString2.substring(0, 200);
      } 
      a.a(paramContext).c(paramString1, str);
      x.b(String.format("[param] putSdkData data: %s - %s", new Object[] { paramString1, str }), new Object[0]);
    } 
  }
  
  public static void putUserData(Context paramContext, String paramString1, String paramString2) {
    StringBuilder stringBuilder;
    NativeCrashHandler nativeCrashHandler2;
    if (!b.a) {
      Log.w(x.a, "Can not put user data because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.w(x.a, "putUserData args context should not be null");
      return;
    } 
    if (paramString1 == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.toString();
      x.d("putUserData args key should not be null or empty", new Object[0]);
      return;
    } 
    if (paramString2 == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.toString();
      x.d("putUserData args value should not be null", new Object[0]);
      return;
    } 
    String str2 = paramString2;
    if (paramString2.length() > 200) {
      x.d("user data value length over limit %d, it will be cutted!", new Object[] { Integer.valueOf(200) });
      str2 = paramString2.substring(0, 200);
    } 
    a a = a.a((Context)stringBuilder);
    if (a.E().contains(paramString1)) {
      nativeCrashHandler2 = NativeCrashHandler.getInstance();
      if (nativeCrashHandler2 != null)
        nativeCrashHandler2.putKeyValueToNative(paramString1, str2); 
      a.a((Context)stringBuilder).b(paramString1, str2);
      x.c("replace KV %s %s", new Object[] { paramString1, str2 });
      return;
    } 
    if (nativeCrashHandler2.D() >= 50) {
      x.d("user data size is over limit %d, it will be cutted!", new Object[] { Integer.valueOf(50) });
      return;
    } 
    String str1 = paramString1;
    if (paramString1.length() > 50) {
      x.d("user data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      str1 = paramString1.substring(0, 50);
    } 
    NativeCrashHandler nativeCrashHandler1 = NativeCrashHandler.getInstance();
    if (nativeCrashHandler1 != null)
      nativeCrashHandler1.putKeyValueToNative(str1, str2); 
    a.a((Context)stringBuilder).b(str1, str2);
    x.b("[param] set user data: %s - %s", new Object[] { str1, str2 });
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
    return a.a(paramContext).f(paramString);
  }
  
  public static void setAppChannel(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App channel because Bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppChannel args context should not be null");
      return;
    } 
    if (paramString == null) {
      Log.w(x.a, "App channel is null, will not set");
      return;
    } 
    (a.a(paramContext)).m = paramString;
    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
    if (nativeCrashHandler != null)
      nativeCrashHandler.setNativeAppChannel(paramString); 
  }
  
  public static void setAppPackage(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppPackage args context should not be null");
      return;
    } 
    if (paramString == null) {
      Log.w(x.a, "App package is null, will not set");
      return;
    } 
    (a.a(paramContext)).c = paramString;
    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
    if (nativeCrashHandler != null)
      nativeCrashHandler.setNativeAppPackage(paramString); 
  }
  
  public static void setAppVersion(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App version because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppVersion args context should not be null");
      return;
    } 
    if (paramString == null) {
      Log.w(x.a, "App version is null, will not set");
      return;
    } 
    (a.a(paramContext)).k = paramString;
    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
    if (nativeCrashHandler != null)
      nativeCrashHandler.setNativeAppVersion(paramString); 
  }
  
  public static void setAuditEnable(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.w(x.a, "setAppPackage args context should not be null");
      return;
    } 
    String str = x.a;
    StringBuilder stringBuilder = new StringBuilder("Set audit enable: ");
    stringBuilder.append(paramBoolean);
    Log.i(str, stringBuilder.toString());
    (a.a(paramContext)).D = paramBoolean;
  }
  
  public static void setBuglyDbName(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set DB name because bugly is disable.");
      return;
    } 
    String str = x.a;
    StringBuilder stringBuilder = new StringBuilder("Set Bugly DB name: ");
    stringBuilder.append(paramString);
    Log.i(str, stringBuilder.toString());
    q.a = paramString;
  }
  
  public static void setContext(Context paramContext) {
    a = paramContext;
  }
  
  public static void setCrashFilter(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    } 
    String str = x.a;
    StringBuilder stringBuilder = new StringBuilder("Set crash stack filter: ");
    stringBuilder.append(paramString);
    Log.i(str, stringBuilder.toString());
    c.n = paramString;
  }
  
  public static void setCrashRegularFilter(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    } 
    String str = x.a;
    StringBuilder stringBuilder = new StringBuilder("Set crash stack filter: ");
    stringBuilder.append(paramString);
    Log.i(str, stringBuilder.toString());
    c.o = paramString;
  }
  
  public static void setHandleNativeCrashInJava(boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    } 
    String str = x.a;
    StringBuilder stringBuilder = new StringBuilder("Should handle native crash in Java profile after handled in native profile: ");
    stringBuilder.append(paramBoolean);
    Log.i(str, stringBuilder.toString());
    NativeCrashHandler.setShouldHandleInJava(paramBoolean);
  }
  
  public static void setHttpProxy(String paramString, int paramInt) {
    a.a(paramString, paramInt);
  }
  
  public static void setHttpProxy(InetAddress paramInetAddress, int paramInt) {
    a.a(paramInetAddress, paramInt);
  }
  
  public static void setIsAppForeground(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set 'isAppForeground' because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      x.d("Context should not be null.", new Object[0]);
      return;
    } 
    if (paramBoolean) {
      x.c("App is in foreground.", new Object[0]);
    } else {
      x.c("App is in background.", new Object[0]);
    } 
    a.a(paramContext).a(paramBoolean);
  }
  
  public static void setIsDevelopmentDevice(Context paramContext, boolean paramBoolean) {
    if (!b.a) {
      Log.w(x.a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      x.d("Context should not be null.", new Object[0]);
      return;
    } 
    if (paramBoolean) {
      x.c("This is a development device.", new Object[0]);
    } else {
      x.c("This is not a development device.", new Object[0]);
    } 
    (a.a(paramContext)).A = paramBoolean;
  }
  
  public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean) {
    return setJavascriptMonitor(paramWebView, paramBoolean, false);
  }
  
  public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramWebView == null) {
      Log.w(x.a, "WebView is null.");
      return false;
    } 
    return setJavascriptMonitor(new WebViewInterface(paramWebView) {
          public final void addJavascriptInterface(H5JavaScriptInterface param1H5JavaScriptInterface, String param1String) {
            this.a.addJavascriptInterface(param1H5JavaScriptInterface, param1String);
          }
          
          public final CharSequence getContentDescription() {
            return this.a.getContentDescription();
          }
          
          public final String getUrl() {
            return this.a.getUrl();
          }
          
          public final void loadUrl(String param1String) {
            this.a.loadUrl(param1String);
          }
          
          public final void setJavaScriptEnabled(boolean param1Boolean) {
            WebSettings webSettings = this.a.getSettings();
            if (!webSettings.getJavaScriptEnabled())
              webSettings.setJavaScriptEnabled(true); 
          }
        }paramBoolean1, paramBoolean2);
  }
  
  public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean) {
    return setJavascriptMonitor(paramWebViewInterface, paramBoolean, false);
  }
  
  public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramWebViewInterface == null) {
      Log.w(x.a, "WebViewInterface is null.");
      return false;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
      return false;
    } 
    x.a("Set Javascript exception monitor of webview.", new Object[0]);
    if (!b.a) {
      Log.w(x.a, "Can not set JavaScript monitor because bugly is disable.");
      return false;
    } 
    x.c("URL of webview is %s", new Object[] { paramWebViewInterface.getUrl() });
    if (!paramBoolean2 && Build.VERSION.SDK_INT < 19) {
      x.e("This interface is only available for Android 4.4 or later.", new Object[0]);
      return false;
    } 
    x.a("Enable the javascript needed by webview monitor.", new Object[0]);
    paramWebViewInterface.setJavaScriptEnabled(true);
    H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(paramWebViewInterface);
    if (h5JavaScriptInterface != null) {
      x.a("Add a secure javascript interface to the webview.", new Object[0]);
      paramWebViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
    } 
    if (paramBoolean1) {
      x.a("Inject bugly.js(v%s) to the webview.", new Object[] { b.b() });
      String str = b.a();
      if (str == null) {
        x.e("Failed to inject Bugly.js.", new Object[] { b.b() });
        return false;
      } 
      StringBuilder stringBuilder = new StringBuilder("javascript:");
      stringBuilder.append(str);
      paramWebViewInterface.loadUrl(stringBuilder.toString());
    } 
    return true;
  }
  
  public static void setSdkExtraData(Context paramContext, String paramString1, String paramString2) {
    if (!b.a) {
      Log.w(x.a, "Can not put SDK extra data because bugly is disable.");
      return;
    } 
    if (paramContext != null && !z.a(paramString1)) {
      if (z.a(paramString2))
        return; 
      a.a(paramContext).a(paramString1, paramString2);
    } 
  }
  
  public static void setServerUrl(String paramString) {
    if (z.a(paramString) || !z.c(paramString)) {
      Log.i(x.a, "URL is invalid.");
      return;
    } 
    a.a(paramString);
    StrategyBean.b = paramString;
    StrategyBean.c = paramString;
  }
  
  public static void setSessionIntervalMills(long paramLong) {
    if (!b.a) {
      Log.w(x.a, "Can not set 'SessionIntervalMills' because bugly is disable.");
      return;
    } 
    b.a(paramLong);
  }
  
  public static void setUserId(Context paramContext, String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set user ID because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.e(x.a, "Context should not be null when bugly has not been initialed!");
      return;
    } 
    if (TextUtils.isEmpty(paramString)) {
      x.d("userId should not be null", new Object[0]);
      return;
    } 
    String str = paramString;
    if (paramString.length() > 100) {
      str = paramString.substring(0, 100);
      x.d("userId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), str });
    } 
    if (str.equals(a.a(paramContext).g()))
      return; 
    a.a(paramContext).b(str);
    x.b("[user] set userId : %s", new Object[] { str });
    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
    if (nativeCrashHandler != null)
      nativeCrashHandler.setNativeUserId(str); 
    if (CrashModule.getInstance().hasInitialized())
      b.a(); 
  }
  
  public static void setUserId(String paramString) {
    if (!b.a) {
      Log.w(x.a, "Can not set user ID because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    setUserId(a, paramString);
  }
  
  public static void setUserSceneTag(Context paramContext, int paramInt) {
    if (!b.a) {
      Log.w(x.a, "Can not set tag caught because bugly is disable.");
      return;
    } 
    if (paramContext == null) {
      Log.e(x.a, "setTag args context should not be null");
      return;
    } 
    if (paramInt <= 0)
      x.d("setTag args tagId should > 0", new Object[0]); 
    a.a(paramContext).a(paramInt);
    x.b("[param] set user scene tag: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void startCrashReport() {
    if (!b.a) {
      Log.w(x.a, "Can not start crash report because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    c.a().c();
  }
  
  public static void testANRCrash() {
    if (!b.a) {
      Log.w(x.a, "Can not test ANR crash because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    x.a("start to create a anr crash for test!", new Object[0]);
    c.a().j();
  }
  
  public static void testJavaCrash() {
    if (!b.a) {
      Log.w(x.a, "Can not test Java crash because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    a a = a.b();
    if (a != null)
      a.b(24096); 
    throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
  }
  
  public static void testNativeCrash() {
    testNativeCrash(false, false, false);
  }
  
  public static void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (!b.a) {
      Log.w(x.a, "Can not test native crash because bugly is disable.");
      return;
    } 
    if (!CrashModule.getInstance().hasInitialized()) {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    } 
    x.a("start to create a native crash for test!", new Object[0]);
    c.a().a(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public static class CrashHandleCallback extends BuglyStrategy.a {}
  
  public static class UserStrategy extends BuglyStrategy {
    private CrashReport.CrashHandleCallback c;
    
    public UserStrategy(Context param1Context) {}
    
    public int getCallBackType() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : I
      //   6: istore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: iload_1
      //   10: ireturn
      //   11: astore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	11	finally
    }
    
    public boolean getCloseErrorCallback() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Z
      //   6: istore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: iload_1
      //   10: ireturn
      //   11: astore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	11	finally
    }
    
    public CrashReport.CrashHandleCallback getCrashHandleCallback() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Lcom/tencent/bugly/crashreport/CrashReport$CrashHandleCallback;
      //   6: astore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_1
      //   10: areturn
      //   11: astore_1
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_1
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	11	finally
    }
    
    public void setCallBackType(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield a : I
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_2
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_2
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	10	finally
    }
    
    public void setCloseErrorCallback(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield b : Z
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_2
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_2
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	10	finally
    }
    
    public void setCrashHandleCallback(CrashReport.CrashHandleCallback param1CrashHandleCallback) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_1
      //   4: putfield c : Lcom/tencent/bugly/crashreport/CrashReport$CrashHandleCallback;
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	10	finally
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\CrashReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
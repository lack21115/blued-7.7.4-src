package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.b.a;
import cn.com.chinatelecom.account.api.c.c;
import cn.com.chinatelecom.account.api.d.b;
import cn.com.chinatelecom.account.api.d.g;
import cn.com.chinatelecom.account.api.d.j;

public class CtAuth {
  private static final String TAG = CtAuth.class.getSimpleName();
  
  private static volatile CtAuth instance;
  
  public static boolean isInit;
  
  public static String mAppId = "";
  
  public static String mAppSecret = "";
  
  public static Context mContext;
  
  public static Handler mHandler;
  
  public static TraceLogger mTraceLogger;
  
  static {
    isInit = false;
    mHandler = new Handler(Looper.getMainLooper());
  }
  
  public static CtAuth getInstance() {
    // Byte code:
    //   0: getstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   3: ifnonnull -> 37
    //   6: ldc cn/com/chinatelecom/account/api/CtAuth
    //   8: monitorenter
    //   9: getstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   12: ifnonnull -> 25
    //   15: new cn/com/chinatelecom/account/api/CtAuth
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   25: ldc cn/com/chinatelecom/account/api/CtAuth
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc cn/com/chinatelecom/account/api/CtAuth
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static void info(String paramString1, String paramString2) {
    if (mTraceLogger != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CT_");
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      mTraceLogger.info(paramString1, paramString2);
    } 
  }
  
  public static void postResultOnMainThread(String paramString1, String paramString2, ResultListener paramResultListener) {
    Runnable runnable = new Runnable(paramResultListener, paramString1, paramString2) {
        public void run() {
          if (this.a != null)
            if (TextUtils.isEmpty(this.b)) {
              this.a.onResult(this.c);
              return;
            }  
        }
      };
    mHandler.post(runnable);
  }
  
  public static void warn(String paramString1, String paramString2, Throwable paramThrowable) {
    if (mTraceLogger != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CT_");
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      mTraceLogger.warn(paramString1, paramString2, paramThrowable);
    } 
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, TraceLogger paramTraceLogger) {
    if (paramContext != null) {
      if (paramString1 != null) {
        if (paramString2 != null) {
          if (!(paramContext instanceof android.app.Application))
            paramContext = paramContext.getApplicationContext(); 
          mContext = paramContext;
          c.a(mContext);
          mAppId = paramString1;
          mAppSecret = paramString2;
          mTraceLogger = paramTraceLogger;
          return;
        } 
        throw new IllegalArgumentException("appSecret must not be null!");
      } 
      throw new IllegalArgumentException("appId must not be null!");
    } 
    throw new IllegalArgumentException("context must not be null!");
  }
  
  @Deprecated
  public void requestPreCode(CtSetting paramCtSetting, ResultListener paramResultListener) {
    requestPreLogin(paramCtSetting, paramResultListener);
  }
  
  public void requestPreLogin(CtSetting paramCtSetting, ResultListener paramResultListener) {
    String str;
    info(TAG, "called requestPreLogin()");
    if (paramResultListener == null)
      return; 
    if (mContext == null || TextUtils.isEmpty(mAppId) || TextUtils.isEmpty(mAppSecret)) {
      str = j.e();
    } else if (!g.b(mContext)) {
      str = j.a();
    } else {
      if (g.c(mContext)) {
        (new a(mContext, mAppId, mAppSecret)).a(d.a(b.d), (CtSetting)str, paramResultListener);
        return;
      } 
      if (g.d(mContext)) {
        (new a(mContext, mAppId, mAppSecret)).b(d.a(b.d), (CtSetting)str, paramResultListener);
        return;
      } 
      postResultOnMainThread(null, j.d(), paramResultListener);
      return;
    } 
    postResultOnMainThread(null, str, paramResultListener);
  }
  
  public void setDomainName(String paramString1, String paramString2, String paramString3) {
    g.a = paramString1;
    g.b = paramString2;
    g.c = paramString3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\CtAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
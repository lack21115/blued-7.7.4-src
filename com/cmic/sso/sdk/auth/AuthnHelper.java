package com.cmic.sso.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.cmic.sso.sdk.AuthThemeConfig;
import com.cmic.sso.sdk.a.b;
import com.cmic.sso.sdk.utils.e;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.g;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.k;
import com.cmic.sso.sdk.utils.l;
import com.cmic.sso.sdk.utils.o;
import com.cmic.sso.sdk.utils.p;
import com.cmic.sso.sdk.utils.t;
import com.cmic.sso.sdk.utils.u;
import com.cmic.sso.sdk.utils.v;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthnHelper {
  private static final int DEFAULT_BUNDLE_SIZE = 64;
  
  public static final String SDK_VERSION = "quick_login_android_5.7.2";
  
  private static final String TAG = "AuthnHelper";
  
  private static AuthThemeConfig mAuthThemeConfig;
  
  private static AuthnHelper mInstance;
  
  private a mAuthBusiness;
  
  private Context mContext;
  
  private Handler mHandler;
  
  private long mOverTime = 8000L;
  
  private LoginPageInListener pageInListener = null;
  
  private AuthnHelper(Context paramContext) {
    this.mHandler = new Handler(paramContext.getMainLooper());
    this.mContext = paramContext.getApplicationContext();
    this.mAuthBusiness = a.a(this.mContext);
    p.a(this.mContext);
    u.a(new u.a(this) {
          public void a() {
            String str = p.b("AID", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("aid = ");
            stringBuilder.append(str);
            f.b("AuthnHelper", stringBuilder.toString());
            if (TextUtils.isEmpty(str))
              this.a.generateAID(); 
            if (e.a(this.a.mContext)) {
              f.b("AuthnHelper", "生成androidkeystore成功");
              return;
            } 
            f.b("AuthnHelper", "生成androidkeystore失败");
          }
        });
  }
  
  private boolean commonInit(Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt, TokenListener paramTokenListener) {
    String str2 = z.b();
    paramBundle.putString("traceId", str2);
    i.a(str2, paramTokenListener);
    long l = System.currentTimeMillis();
    paramBundle.putString("starttime", v.a(l));
    paramBundle.putLong("starttimemills", l);
    paramBundle.putString("loginMethod", paramString3);
    paramBundle.putString("appkey", paramString2);
    paramBundle.putString("appid", paramString1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.mOverTime);
    paramString3 = "";
    stringBuilder1.append("");
    paramBundle.putString("timeOut", stringBuilder1.toString());
    paramBundle.putInt("logintype", paramInt);
    paramBundle.putBoolean("CLOSE_CERT_VERIFY", x.h());
    boolean bool = k.a(this.mContext, "android.permission.READ_PHONE_STATE");
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("有READ_PHONE_STATE权限？");
    stringBuilder1.append(bool);
    f.a("AuthnHelper", stringBuilder1.toString());
    paramBundle.putBoolean("hsaReadPhoneStatePermission", bool);
    b.a().a(this.mContext, bool);
    paramBundle.putString("networkClass", b.a().a(this.mContext));
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(b.a().b().i());
    stringBuilder1.append("");
    paramBundle.putString("simCardNum", stringBuilder1.toString());
    paramInt = t.a(this.mContext);
    paramBundle.putInt("startnetworkType", paramInt);
    String str3 = o.a(this.mContext).a();
    String str5 = o.a(this.mContext).c();
    String str4 = o.a(this.mContext).e();
    String str1 = o.a(this.mContext).a(false);
    paramBundle.putString("imei", str5);
    paramBundle.putString("iccid", str4);
    paramBundle.putString("operatorType", str1);
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("iccid=");
    stringBuilder4.append(str4);
    f.b("AuthnHelper", stringBuilder4.toString());
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("imsi=");
    stringBuilder3.append(str3);
    f.b("AuthnHelper", stringBuilder3.toString());
    if (TextUtils.isEmpty(str3)) {
      f.a("AuthnHelper", "使用iccid作为缓存key");
      paramBundle.putBoolean("keyIsSimKeyICCID", true);
    } 
    paramBundle.putString("imsi", str3);
    bool = l.a(paramBundle);
    paramBundle.putBoolean("isCacheScrip", bool);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("isCachePhoneScrip = ");
    stringBuilder2.append(bool);
    f.b("AuthnHelper", stringBuilder2.toString());
    if (paramTokenListener == null) {
      callBackResult("200026", "listener不能为空", paramBundle, null, null);
      return false;
    } 
    if (x.d()) {
      callBackResult("200082", "服务器繁忙，请稍后重试", paramBundle, null, null);
      return false;
    } 
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      paramString1 = paramString1.trim();
    } 
    if (TextUtils.isEmpty(paramString1)) {
      callBackResult("200026", "appId 不能为空", paramBundle, null, null);
      return false;
    } 
    if (paramString2 == null) {
      paramString1 = paramString3;
    } else {
      paramString1 = paramString2.trim();
    } 
    if (TextUtils.isEmpty(paramString1)) {
      callBackResult("200026", "appkey不能为空", paramBundle, null, null);
      return false;
    } 
    if (paramInt == 0) {
      callBackResult("200022", "未检测到网络", paramBundle, null, null);
      return false;
    } 
    if (TextUtils.isEmpty(str1)) {
      paramBundle.putString("authtype", "0");
      callBackResult("200002", "无法识别sim卡或没有sim卡", paramBundle, null, null);
      return false;
    } 
    if ("2".equals(str1) && x.i()) {
      callBackResult("200082", "服务器繁忙，请稍后重试", paramBundle, null, null);
      return false;
    } 
    if ("3".equals(str1) && x.j()) {
      callBackResult("200082", "服务器繁忙，请稍后重试", paramBundle, null, null);
      return false;
    } 
    if (paramInt == 2 && !bool) {
      callBackResult("200027", "无数据网络", paramBundle, null, null);
      return false;
    } 
    return true;
  }
  
  private void generateAID() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("%");
    stringBuilder1.append(z.a());
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("generate aid = ");
    stringBuilder2.append(str);
    f.b("AuthnHelper", stringBuilder2.toString());
    p.a("AID", str);
  }
  
  private String getCallActivity() {
    try {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      int k = arrayOfStackTraceElement.length;
      int j = 0;
      int i = 0;
      while (true) {
        if (j < k) {
          String str = arrayOfStackTraceElement[j].getClassName();
          if (TextUtils.isEmpty(str) || !str.contains("AuthnHelper")) {
            i++;
            j++;
            continue;
          } 
        } 
        j = i + 2;
        k = arrayOfStackTraceElement.length;
        if (j < k) {
          stringBuilder.append(arrayOfStackTraceElement[j].getClassName());
          stringBuilder.append(";");
        } 
        i += 3;
        if (i < arrayOfStackTraceElement.length) {
          stringBuilder.append(arrayOfStackTraceElement[i].getClassName());
          stringBuilder.append(";");
        } 
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static AuthnHelper getInstance(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   3: ifnonnull -> 38
    //   6: ldc com/cmic/sso/sdk/auth/AuthnHelper
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   12: ifnonnull -> 26
    //   15: new com/cmic/sso/sdk/auth/AuthnHelper
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   26: ldc com/cmic/sso/sdk/auth/AuthnHelper
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/cmic/sso/sdk/auth/AuthnHelper
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/cmic/sso/sdk/auth/AuthnHelper.mInstance : Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public static void setDebugMode(boolean paramBoolean) {
    f.a(paramBoolean);
  }
  
  private void startGetPrePhonescript(String paramString, Bundle paramBundle) {
    a a1 = new a(this, paramBundle);
    this.mHandler.postDelayed(a1, this.mOverTime);
    paramBundle.putString("authTypeInput", paramString);
    this.mAuthBusiness.a(paramString, paramBundle, new b(this, a1) {
          public void a(String param1String1, String param1String2, Bundle param1Bundle, JSONObject param1JSONObject) {
            f.b("onBusinessComplete", "onBusinessComplete");
            if (AuthnHelper.a.a(this.a)) {
              this.b.mHandler.removeCallbacks(this.a);
              if (1 == param1Bundle.getInt("logintype") && "显示登录取号成功".equals(param1String2) && !i.a(param1Bundle.getString("traceId"))) {
                z.a(this.b.mContext, param1Bundle, AuthnHelper.mAuthThemeConfig.getAuthPageActIn(), AuthnHelper.mAuthThemeConfig.getActivityOut());
                return;
              } 
              this.b.callBackResult(param1String1, param1String2, param1Bundle, param1JSONObject, null);
            } 
          }
        });
  }
  
  public void callBackResult(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject, Throwable paramThrowable) {
    callBackResult(paramString1, paramString2, paramBundle, paramJSONObject, paramThrowable, false);
  }
  
  public void callBackResult(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject, Throwable paramThrowable, boolean paramBoolean) {
    // Byte code:
    //   0: aload_3
    //   1: ldc 'traceId'
    //   3: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   6: astore #10
    //   8: aload_3
    //   9: ldc_w 'SDKRequestCode'
    //   12: iconst_m1
    //   13: invokevirtual getInt : (Ljava/lang/String;I)I
    //   16: istore #7
    //   18: aload #10
    //   20: invokestatic a : (Ljava/lang/String;)Z
    //   23: ifne -> 181
    //   26: aload_0
    //   27: monitorenter
    //   28: aload #10
    //   30: invokestatic c : (Ljava/lang/String;)Lcom/cmic/sso/sdk/auth/TokenListener;
    //   33: astore #11
    //   35: iload #6
    //   37: ifne -> 45
    //   40: aload #10
    //   42: invokestatic b : (Ljava/lang/String;)V
    //   45: aload #11
    //   47: ifnonnull -> 53
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: ldc 'logintype'
    //   58: iconst_m1
    //   59: invokevirtual getInt : (Ljava/lang/String;I)I
    //   62: istore #8
    //   64: aload #4
    //   66: astore #9
    //   68: aload #4
    //   70: ifnonnull -> 80
    //   73: aload_1
    //   74: aload_2
    //   75: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: astore #9
    //   80: aload #9
    //   82: astore #4
    //   84: iload #8
    //   86: iconst_3
    //   87: if_icmpeq -> 100
    //   90: aload_1
    //   91: aload_2
    //   92: aload_3
    //   93: aload #9
    //   95: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   98: astore #4
    //   100: aload #4
    //   102: ldc 'traceId'
    //   104: aload #10
    //   106: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload_0
    //   111: getfield mHandler : Landroid/os/Handler;
    //   114: new com/cmic/sso/sdk/auth/AuthnHelper$6
    //   117: dup
    //   118: aload_0
    //   119: aload #11
    //   121: iload #7
    //   123: aload #4
    //   125: invokespecial <init> : (Lcom/cmic/sso/sdk/auth/AuthnHelper;Lcom/cmic/sso/sdk/auth/TokenListener;ILorg/json/JSONObject;)V
    //   128: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   131: pop
    //   132: invokestatic k : ()Z
    //   135: ifne -> 156
    //   138: new com/cmic/sso/sdk/c/b
    //   141: dup
    //   142: invokespecial <init> : ()V
    //   145: aload_0
    //   146: getfield mContext : Landroid/content/Context;
    //   149: aload_1
    //   150: aload_3
    //   151: aload #5
    //   153: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Throwable;)V
    //   156: new com/cmic/sso/sdk/auth/AuthnHelper$7
    //   159: dup
    //   160: aload_0
    //   161: aload_0
    //   162: getfield mContext : Landroid/content/Context;
    //   165: aload_3
    //   166: aload_3
    //   167: invokespecial <init> : (Lcom/cmic/sso/sdk/auth/AuthnHelper;Landroid/content/Context;Landroid/os/Bundle;Landroid/os/Bundle;)V
    //   170: invokestatic a : (Lcom/cmic/sso/sdk/utils/u$a;)V
    //   173: goto -> 181
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: invokestatic a : ()Z
    //   184: ifeq -> 203
    //   187: aload_0
    //   188: getfield mContext : Landroid/content/Context;
    //   191: invokestatic a : (Landroid/content/Context;)Lcom/cmic/sso/sdk/utils/aa;
    //   194: invokevirtual a : ()V
    //   197: return
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual printStackTrace : ()V
    //   203: return
    // Exception table:
    //   from	to	target	type
    //   0	28	198	java/lang/Exception
    //   28	35	176	finally
    //   40	45	176	finally
    //   50	52	176	finally
    //   53	55	176	finally
    //   55	64	198	java/lang/Exception
    //   73	80	198	java/lang/Exception
    //   90	100	198	java/lang/Exception
    //   100	156	198	java/lang/Exception
    //   156	173	198	java/lang/Exception
    //   177	179	176	finally
    //   179	181	198	java/lang/Exception
    //   181	197	198	java/lang/Exception
  }
  
  public void delScrip() {
    try {
      l.a(true);
      return;
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
      return;
    } 
  }
  
  public AuthThemeConfig getAuthThemeConfig() {
    if (mAuthThemeConfig == null)
      mAuthThemeConfig = (new AuthThemeConfig.Builder()).build(); 
    return mAuthThemeConfig;
  }
  
  public JSONObject getNetworkType(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      b.a().a(paramContext, k.a(paramContext, "android.permission.READ_PHONE_STATE"));
      String str = o.a(paramContext).a(true);
      int i = t.a(paramContext);
      jSONObject.put("operatorType", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      jSONObject.put("networkType", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("网络类型: ");
      stringBuilder.append(i);
      f.c("AuthnHelper", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("运营商类型: ");
      stringBuilder.append(str);
      f.c("AuthnHelper", stringBuilder.toString());
      return jSONObject;
    } catch (Exception exception) {
      try {
        jSONObject.put("errorDes", "发生未知错误");
        return jSONObject;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        return jSONObject;
      } 
    } 
  }
  
  public long getOverTime() {
    return this.mOverTime;
  }
  
  public void getPhoneInfo(String paramString1, String paramString2, TokenListener paramTokenListener) {
    getPhoneInfo(paramString1, paramString2, paramTokenListener, -1);
  }
  
  public void getPhoneInfo(String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle(64);
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "general");
    bundle.putString("caller", getCallActivity());
    bundle.putLong("methodTimes", System.currentTimeMillis());
    u.a(new u.a(this, this.mContext, bundle, bundle, paramString1, paramString2, paramTokenListener) {
          public void a() {
            if (this.e.commonInit(this.a, this.b, this.c, "preGetMobile", 3, this.d)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("超时时间：");
              stringBuilder.append(this.e.mOverTime);
              f.a("AuthnHelper", stringBuilder.toString());
              this.e.startGetPrePhonescript(String.valueOf(3), this.a);
            } 
          }
        });
  }
  
  public void loginAuth(String paramString1, String paramString2, TokenListener paramTokenListener) {
    loginAuth(paramString1, paramString2, paramTokenListener, -1);
  }
  
  public void loginAuth(String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle(64);
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "login");
    bundle.putString("caller", getCallActivity());
    bundle.putLong("methodTimes", System.currentTimeMillis());
    u.a(new u.a(this, this.mContext, bundle, bundle, paramString1, paramString2, paramTokenListener) {
          public void a() {
            if (this.e.commonInit(this.a, this.b, this.c, "loginAuth", 1, this.d)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("超时时间：");
              stringBuilder.append(this.e.mOverTime);
              f.a("AuthnHelper", stringBuilder.toString());
              this.e.startGetPrePhonescript(String.valueOf(3), this.a);
            } 
          }
        });
  }
  
  public void loginPageInCallBack(String paramString, JSONObject paramJSONObject) {
    LoginPageInListener loginPageInListener = this.pageInListener;
    if (loginPageInListener != null)
      loginPageInListener.onLoginPageInComplete(paramString, paramJSONObject); 
  }
  
  public void mobileAuth(String paramString1, String paramString2, TokenListener paramTokenListener) {
    mobileAuth(paramString1, paramString2, paramTokenListener, -1);
  }
  
  public void mobileAuth(String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle(64);
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "authentication");
    bundle.putLong("methodTimes", System.currentTimeMillis());
    u.a(new u.a(this, this.mContext, bundle, bundle, paramString1, paramString2, paramTokenListener) {
          public void a() {
            if (this.e.commonInit(this.a, this.b, this.c, "mobileAuth", 0, this.d)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("超时时间：");
              stringBuilder.append(this.e.mOverTime);
              f.a("AuthnHelper", stringBuilder.toString());
              this.e.startGetPrePhonescript(String.valueOf(3), this.a);
            } 
          }
        });
  }
  
  public void quitAuthActivity() {
    try {
      if (g.a().b() != null) {
        g.a().b().a();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      f.a("AuthnHelper", "关闭授权页失败");
    } 
  }
  
  public void setAuthThemeConfig(AuthThemeConfig paramAuthThemeConfig) {
    mAuthThemeConfig = paramAuthThemeConfig;
  }
  
  public void setOverTime(long paramLong) {
    this.mOverTime = paramLong;
  }
  
  public void setPageInListener(LoginPageInListener paramLoginPageInListener) {
    this.pageInListener = paramLoginPageInListener;
  }
  
  class a implements Runnable {
    private Bundle b;
    
    private volatile boolean c = false;
    
    a(AuthnHelper this$0, Bundle param1Bundle) {
      this.b = param1Bundle;
    }
    
    private boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Z
      //   6: istore_1
      //   7: aload_0
      //   8: iconst_1
      //   9: putfield c : Z
      //   12: aload_0
      //   13: monitorexit
      //   14: iload_1
      //   15: iconst_1
      //   16: ixor
      //   17: ireturn
      //   18: astore_2
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_2
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	18	finally
    }
    
    public void run() {
      if (a()) {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("resultCode", "200023");
          jSONObject.put("resultString", "登录超时");
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        this.a.callBackResult("200023", "登录超时", this.b, jSONObject, null);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\auth\AuthnHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
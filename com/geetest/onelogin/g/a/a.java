package com.geetest.onelogin.g.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.cmic.sso.sdk.auth.b;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.u;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static Method a;
  
  private static Handler b;
  
  private static com.cmic.sso.sdk.auth.a c;
  
  private static Method d;
  
  public static void a(Context paramContext, AuthnHelper paramAuthnHelper, String paramString1, String paramString2, TokenListener paramTokenListener) {
    a(paramContext, paramAuthnHelper, paramString1, paramString2, paramTokenListener, -1);
  }
  
  public static void a(Context paramContext, AuthnHelper paramAuthnHelper, String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    a(paramAuthnHelper);
    Bundle bundle = new Bundle(64);
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "general");
    bundle.putString("caller", "com.cmic.sso.sdk.auth.AuthnHelper");
    bundle.putLong("methodTimes", System.currentTimeMillis());
    u.a(new u.a(paramContext, bundle, paramAuthnHelper, bundle, paramString1, paramString2, paramTokenListener, paramContext) {
          public void a() {
            try {
              a.a().setAccessible(true);
              if (((Boolean)a.a().invoke(this.a, new Object[] { this.b, this.c, this.d, "preGetMobile", Integer.valueOf(3), this.e })).booleanValue()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("超时时间: ");
                stringBuilder.append(this.a.getOverTime());
                f.a("AuthnHelper", stringBuilder.toString());
                a.a(this.f, this.a, String.valueOf(3), this.b);
                return;
              } 
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getPhoneInfo Exception: ");
              stringBuilder.append(exception.toString());
              h.c(stringBuilder.toString());
              exception.printStackTrace();
            } 
          }
        });
  }
  
  private static void a(AuthnHelper paramAuthnHelper) {
    try {
      a = AuthnHelper.class.getDeclaredMethod("commonInit", new Class[] { Bundle.class, String.class, String.class, String.class, int.class, TokenListener.class });
      a.setAccessible(true);
      Field field = AuthnHelper.class.getDeclaredField("mHandler");
      field.setAccessible(true);
      b = (Handler)field.get(paramAuthnHelper);
      field = AuthnHelper.class.getDeclaredField("mAuthBusiness");
      field.setAccessible(true);
      c = (com.cmic.sso.sdk.auth.a)field.get(paramAuthnHelper);
      d = c.getClass().getDeclaredMethod("a", new Class[] { String.class, Bundle.class, b.class });
      d.setAccessible(true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CmAuthHelper init:commonInit=");
      stringBuilder.append(a);
      stringBuilder.append(", mHandler=");
      stringBuilder.append(b);
      stringBuilder.append(", mAuthBusiness=");
      stringBuilder.append(c);
      c.a(stringBuilder.toString());
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CmAuthHelper init Exception: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  private static void b(Context paramContext, Bundle paramBundle) {
    u.a(new u.a(com.cmic.sso.sdk.auth.a.a(paramContext), paramBundle, paramContext) {
          public void a() {
            this.a.a(this.b, new b(this) {
                  public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
                    AuthnHelper.getInstance(this.a.c).callBackResult(param2String1, param2String2, param2Bundle, param2JSONObject, (Throwable)null);
                  }
                });
          }
        });
  }
  
  private static void b(Context paramContext, AuthnHelper paramAuthnHelper, String paramString, Bundle paramBundle) {
    a a1 = new a(paramBundle, paramContext, paramAuthnHelper);
    b.postDelayed(a1, paramAuthnHelper.getOverTime());
    paramBundle.putString("authTypeInput", paramString);
    try {
      d.invoke(c, new Object[] { paramString, paramBundle, new b(a1, paramContext, paramAuthnHelper) {
              public void a(String param1String1, String param1String2, Bundle param1Bundle, JSONObject param1JSONObject) {
                f.b("onBusinessComplete", "onBusinessComplete");
                if (a.a.a(this.a)) {
                  a.b().removeCallbacks(this.a);
                  if (1 == param1Bundle.getInt("logintype") && "显示登录取号成功".equals(param1String2) && !i.a(param1Bundle.getString("traceId"))) {
                    a.a(this.b, param1Bundle);
                    return;
                  } 
                  this.c.callBackResult(param1String1, param1String2, param1Bundle, param1JSONObject, (Throwable)null);
                } 
              }
            } });
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startGetPrePhonescript Exception: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void b(Context paramContext, AuthnHelper paramAuthnHelper, String paramString1, String paramString2, TokenListener paramTokenListener) {
    b(paramContext, paramAuthnHelper, paramString1, paramString2, paramTokenListener, -1);
  }
  
  public static void b(Context paramContext, AuthnHelper paramAuthnHelper, String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt) {
    Bundle bundle = new Bundle(64);
    bundle.putInt("SDKRequestCode", paramInt);
    bundle.putString("serviceType", "login");
    bundle.putString("caller", "com.cmic.sso.sdk.auth.AuthnHelper");
    bundle.putLong("methodTimes", System.currentTimeMillis());
    u.a(new u.a(paramContext, bundle, paramAuthnHelper, bundle, paramString1, paramString2, paramTokenListener, paramContext) {
          public void a() {
            try {
              a.a().setAccessible(true);
              if (((Boolean)a.a().invoke(this.a, new Object[] { this.b, this.c, this.d, "loginAuth", Integer.valueOf(1), this.e })).booleanValue()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("超时时间: ");
                stringBuilder.append(this.a.getOverTime());
                f.a("AuthnHelper", stringBuilder.toString());
                a.a(this.f, this.a, String.valueOf(3), this.b);
                return;
              } 
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loginAuth Exception: ");
              stringBuilder.append(exception.toString());
              h.c(stringBuilder.toString());
              exception.printStackTrace();
            } 
          }
        });
  }
  
  static class a implements Runnable {
    private Bundle a;
    
    private volatile boolean b = false;
    
    private Context c;
    
    private AuthnHelper d;
    
    a(Bundle param1Bundle, Context param1Context, AuthnHelper param1AuthnHelper) {
      this.a = param1Bundle;
      this.c = param1Context;
      this.d = param1AuthnHelper;
    }
    
    private boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Z
      //   6: istore_1
      //   7: aload_0
      //   8: iconst_1
      //   9: putfield b : Z
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
      if (a())
        try {
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("resultCode", "200023");
          jSONObject.put("resultString", "登录超时");
          this.d.callBackResult("200023", "登录超时", this.a, jSONObject, (Throwable)null);
          return;
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
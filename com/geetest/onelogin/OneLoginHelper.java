package com.geetest.onelogin;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebViewClient;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.geetest.onelogin.config.AuthRegisterViewConfig;
import com.geetest.onelogin.config.OneLoginThemeConfig;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.listener.AbstractOneLoginListener;
import com.geetest.onelogin.listener.SecurityPhoneListener;

public class OneLoginHelper {
  private static volatile OneLoginHelper oneLoginHelper;
  
  public static OneLoginHelper with() {
    // Byte code:
    //   0: getstatic com/geetest/onelogin/OneLoginHelper.oneLoginHelper : Lcom/geetest/onelogin/OneLoginHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onelogin/OneLoginHelper
    //   8: monitorenter
    //   9: getstatic com/geetest/onelogin/OneLoginHelper.oneLoginHelper : Lcom/geetest/onelogin/OneLoginHelper;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onelogin/OneLoginHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onelogin/OneLoginHelper.oneLoginHelper : Lcom/geetest/onelogin/OneLoginHelper;
    //   25: ldc com/geetest/onelogin/OneLoginHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onelogin/OneLoginHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onelogin/OneLoginHelper.oneLoginHelper : Lcom/geetest/onelogin/OneLoginHelper;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  @Deprecated
  public OneLoginHelper addOneLoginRegisterViewConfig(String paramString, AuthRegisterViewConfig paramAuthRegisterViewConfig) {
    b.w().a(paramString, paramAuthRegisterViewConfig);
    return this;
  }
  
  public OneLoginHelper addOneLoginRegisterViewConfig(String paramString, AuthRegisterViewConfig paramAuthRegisterViewConfig) {
    b.w().a(paramString, paramAuthRegisterViewConfig);
    return this;
  }
  
  public OneLoginHelper addOpAppInfo(String paramString1, String paramString2, String paramString3, int paramInt) {
    b.w().a(paramString1, paramString2, paramString3, paramInt);
    return this;
  }
  
  public OneLoginHelper appOpAppInfoFinished() {
    b.w().r();
    return this;
  }
  
  public void cancel() {
    b.w().R();
  }
  
  public void dismissAuthActivity() {
    b.w().C();
  }
  
  public String getSecurityPhone() {
    return b.w().K();
  }
  
  public String getSimOperator(Context paramContext) {
    return b.w().b(paramContext);
  }
  
  public OneLoginHelper init(Context paramContext) {
    b.w().a(paramContext);
    return this;
  }
  
  public OneLoginHelper init(Context paramContext, String paramString) {
    b.w().a(paramContext, paramString);
    return this;
  }
  
  public boolean isAccessCodeExpired() {
    return b.w().J();
  }
  
  public boolean isInitSuccess() {
    return b.w().D();
  }
  
  public boolean isPreGetTokenComplete() {
    return b.w().G();
  }
  
  public boolean isPreGetTokenResultValidate() {
    return b.w().E();
  }
  
  public boolean isPreGetTokenSuccess() {
    return b.w().F();
  }
  
  public boolean isPrivacyChecked() {
    return b.w().t();
  }
  
  public boolean isRequestTokenComplete() {
    return b.w().I();
  }
  
  public boolean isRequestTokenSuccess() {
    return b.w().H();
  }
  
  public void preGetToken(String paramString, int paramInt, AbstractOneLoginListener paramAbstractOneLoginListener) {
    b.w().a(paramString, paramInt, paramAbstractOneLoginListener);
  }
  
  public void register(String paramString) {
    b.w().a(paramString, 10000);
  }
  
  public void register(String paramString, int paramInt) {
    b.w().a(paramString, paramInt);
  }
  
  public void removeCallbacksAndMessages() {
    b.w().P();
  }
  
  public void removeOneLoginListener() {
    b.w().M();
  }
  
  public void requestSecurityPhone(SecurityPhoneListener paramSecurityPhoneListener) {
    b.w().requestSecurityPhone(paramSecurityPhoneListener);
  }
  
  public void requestToken(OneLoginThemeConfig paramOneLoginThemeConfig, AbstractOneLoginListener paramAbstractOneLoginListener) {
    b.w().a(paramOneLoginThemeConfig, paramAbstractOneLoginListener);
  }
  
  public void requestToken(AbstractOneLoginListener paramAbstractOneLoginListener) {
    b.w().a(null, paramAbstractOneLoginListener);
  }
  
  public void requestTokenDelay() {
    b.w().y();
  }
  
  public String sdkVersion() {
    return b.w().x();
  }
  
  public OneLoginHelper setCaptchaApi(String paramString1, String paramString2, int paramInt) {
    b.w().a(paramString1, paramString2, paramInt);
    return this;
  }
  
  public OneLoginHelper setCustomMode() {
    b.w().c();
    return this;
  }
  
  public OneLoginHelper setLogEnable(boolean paramBoolean) {
    b.w().c(paramBoolean);
    return this;
  }
  
  public OneLoginHelper setLogEnable(boolean paramBoolean, String paramString) {
    b.w().a(paramBoolean, paramString);
    return this;
  }
  
  public OneLoginHelper setOperator(String paramString) {
    b.w().b(paramString);
    return this;
  }
  
  public OneLoginHelper setRequestedOrientation(Activity paramActivity, boolean paramBoolean) {
    b.w().a(paramActivity, paramBoolean);
    return this;
  }
  
  public OneLoginHelper setServerURL(String paramString) {
    b.w().a(paramString);
    return this;
  }
  
  public OneLoginHelper setWebViewClient(WebViewClient paramWebViewClient) {
    b.w().a(paramWebViewClient);
    return this;
  }
  
  public void stopLoading() {
    b.w().L();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\OneLoginHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.das.login.LoginAndRegisterProtos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CardDialog;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.model.BluedLoginResultVerBinding;
import com.soft.blued.ui.login_register.model.BluedCheckResult;
import com.soft.blued.ui.login_register.model.RemindSettingModel;
import com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LoginRegisterTools {
  public static String a;
  
  public static String b;
  
  public static String c;
  
  public static String d;
  
  public static String e;
  
  public static String f;
  
  public static String g;
  
  public static String h;
  
  public static String i;
  
  public static String j;
  
  public static String k;
  
  public static String l;
  
  public static String m;
  
  public static String n;
  
  public static String o;
  
  private static String p = LoginRegisterTools.class.getSimpleName();
  
  static {
    a = "re_type";
    b = "re_type_three";
    c = "re_captcha";
    d = "re_token";
    e = "re_phone";
    f = "re_email";
    g = "re_phone_areacode";
    h = "re_password";
    i = "re_nickname";
    j = "re_account";
    k = "link_mobile_type";
    l = "link_mobile_change_mobile";
    m = "link_mobile_thr_password";
    n = "link_mobile_change_pay";
    o = "link_mobile_change_pay_bind";
  }
  
  public static AlertDialog a(Context paramContext, SmCaptchaWebView.ResultListener paramResultListener) {
    View view = LayoutInflater.from(paramContext).inflate(2131493032, null, false);
    AlertDialog alertDialog = (new AlertDialog.Builder(paramContext)).setView(view).create();
    String str = paramContext.getString(2131755574);
    SmCaptchaWebView smCaptchaWebView = (SmCaptchaWebView)view.findViewById(2131299983);
    SmCaptchaWebView.SmOption smOption = new SmCaptchaWebView.SmOption();
    smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
    smOption.setMode("slide");
    smOption.setAppId("1");
    smOption.setChannel(AppInfo.c);
    if (!BlueAppLocal.d()) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("lang", "en");
      smOption.setExtOption(hashMap);
    } 
    if (!TextUtils.isEmpty(str))
      smOption.setTipMessage(str); 
    smCaptchaWebView.setBackgroundColor(0);
    smCaptchaWebView.initWithOption(smOption, new SmCaptchaWebView.ResultListener(paramResultListener, alertDialog) {
          public void onError(int param1Int) {
            SmCaptchaWebView.ResultListener resultListener = this.a;
            if (resultListener != null)
              resultListener.onError(param1Int); 
          }
          
          public void onReady() {
            SmCaptchaWebView.ResultListener resultListener = this.a;
            if (resultListener != null)
              resultListener.onReady(); 
          }
          
          public void onSuccess(CharSequence param1CharSequence, boolean param1Boolean) {
            SmCaptchaWebView.ResultListener resultListener = this.a;
            if (resultListener != null)
              resultListener.onSuccess(param1CharSequence, param1Boolean); 
            if (param1Boolean) {
              AlertDialog alertDialog = this.b;
              if (alertDialog != null)
                alertDialog.dismiss(); 
            } 
          }
        });
    int i = SmCaptchaWebView.SMCAPTCHA_SUCCESS;
    alertDialog.setCancelable(false);
    alertDialog.setCanceledOnTouchOutside(false);
    alertDialog.show();
    if (alertDialog.getWindow() != null)
      alertDialog.getWindow().setBackgroundDrawableResource(2131100897); 
    return alertDialog;
  }
  
  public static String a(String paramString) {
    try {
      Gson gson = AppInfo.f();
      BluedEntityA bluedEntityA = (BluedEntityA)gson.fromJson(paramString, (new TypeToken<BluedEntityA<BluedCheckResult>>() {
          
          }).getType());
      if (bluedEntityA != null && bluedEntityA.hasData()) {
        String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
        Logger.b(p, new Object[] { "解密：deData===", str });
        BluedCheckResult bluedCheckResult = (BluedCheckResult)gson.fromJson(str, BluedCheckResult.class);
        if (bluedCheckResult != null)
          return bluedCheckResult.getCaptcha(); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("-");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    Gson gson = AppInfo.f();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("access_token", paramString1);
    arrayMap.put("user_id", paramString2);
    arrayMap.put("three_type", paramString3);
    return gson.toJson(arrayMap);
  }
  
  public static void a() {
    int i = BluedPreferences.bm();
    Logger.a("Start_count", new Object[] { "start one time" });
    BluedPreferences.h(i + 1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2) {
    if (BluedPreferences.bm() >= BluedPreferences.bi) {
      CardDialog.Builder builder = new CardDialog.Builder(paramContext);
      builder.a().b(new DialogInterface.OnClickListener(builder) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (this.a.b() != null)
                this.a.b().dismiss(); 
            }
          }).a(new DialogInterface.OnClickListener(builder, paramContext) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (this.a.d() == 1) {
                String str = LoginRegisterTools.d();
                Bundle bundle = new Bundle();
                bundle.putString(LoginRegisterTools.f, str);
                bundle.putInt(LoginRegisterTools.a, 0);
                if (TextUtils.isEmpty(str)) {
                  bundle.putString("binding_type", "add");
                  TerminalActivity.d(this.b, BindingSecureEmailFragment.class, bundle);
                  return;
                } 
                TerminalActivity.d(this.b, LinkMobileSuccessFragment.class, bundle);
                return;
              } 
              if (this.a.d() == 0) {
                String str = LoginRegisterTools.b();
                if (!StringUtils.e(str)) {
                  String[] arrayOfString = LoginRegisterTools.h(str);
                  LoginRegisterTools.a(this.b, arrayOfString[0], arrayOfString[1]);
                  return;
                } 
                TerminalActivity.d(this.b, LinkMobileFragment.class, null);
              } 
            }
          }).a(paramInt1, paramInt2).e().f();
      if (paramContext instanceof Activity && !((Activity)paramContext).isFinishing())
        builder.b().show(); 
      BluedPreferences.h(0);
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putInt(a, 1);
    bundle.putString(g, paramString1);
    bundle.putString(e, paramString2);
    TerminalActivity.d(paramContext, LinkMobileSuccessFragment.class, bundle);
  }
  
  public static void a(View paramView) {
    if (UserInfo.a().e() == 2 && paramView != null)
      paramView.setVisibility(8); 
  }
  
  public static void a(FragmentActivity paramFragmentActivity) {
    String str = paramFragmentActivity.getResources().getString(2131755520);
    CommonShowBottomWindow.a(paramFragmentActivity, paramFragmentActivity.getResources().getStringArray(2130903093), new ActionSheet.ActionSheetListener(str) {
          public void a(ActionSheet param1ActionSheet, int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1) {
                if (param1Int != 2)
                  return; 
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.FIND_PWD_BY_SAFE_EMAIL);
                WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.d(), this.a, 1);
                return;
              } 
              EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.FIND_PWD_BY_REG_EMAIL);
              WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.c(), this.a, 1);
              return;
            } 
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.FIND_PWD_BY_PHONE);
            WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.b(), this.a, 1);
          }
          
          public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
        });
  }
  
  public static void a(FragmentActivity paramFragmentActivity, int paramInt) {
    CommonAlertDialog.a((Context)paramFragmentActivity, "", paramFragmentActivity.getResources().getString(2131757813), paramFragmentActivity.getResources().getString(2131755520), new DialogInterface.OnClickListener(paramFragmentActivity, paramInt) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LoginRegisterTools.a((Context)this.a, this.b);
          }
        }paramFragmentActivity.getResources().getString(2131755576), null, null);
  }
  
  public static void a(IRequestHost paramIRequestHost, ImageView paramImageView, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("?");
    stringBuilder.append(UUID.randomUUID());
    ImageLoader.a(paramIRequestHost, stringBuilder.toString()).a().a(paramImageView);
  }
  
  public static String b() {
    if (!StringUtils.e(UserInfo.a().f()))
      return i(UserInfo.a().f()); 
    if (UserInfo.a().i() != null) {
      BluedLoginResultVerBinding bluedLoginResultVerBinding = UserInfo.a().i().getVerified_bindings();
      if (bluedLoginResultVerBinding != null)
        return bluedLoginResultVerBinding.mobile; 
    } 
    return "";
  }
  
  private static void b(Context paramContext, int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.c(), paramContext.getResources().getString(2131755520), 1);
      return;
    } 
    WebViewShowInfoFragment.a(AppInfo.d(), BluedHttpUrl.b(), paramContext.getResources().getString(2131755520), 1);
  }
  
  public static String[] b(String paramString) {
    String[] arrayOfString = new String[2];
    try {
      Gson gson = AppInfo.f();
      BluedEntityA bluedEntityA = (BluedEntityA)gson.fromJson(paramString, (new TypeToken<BluedEntityA<BluedCheckResult>>() {
          
          }).getType());
      if (bluedEntityA != null && bluedEntityA.hasData()) {
        String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
        Logger.b(p, new Object[] { "解密：deData===", str });
        BluedCheckResult bluedCheckResult = (BluedCheckResult)gson.fromJson(str, BluedCheckResult.class);
        if (bluedCheckResult != null) {
          arrayOfString[0] = bluedCheckResult.getToken();
          arrayOfString[1] = bluedCheckResult.getCaptcha();
          return arrayOfString;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return arrayOfString;
  }
  
  public static String c() {
    String str = UserInfo.a().h();
    if (!TextUtils.isEmpty(str))
      return str; 
    if (UserInfo.a().i() != null) {
      BluedLoginResultVerBinding bluedLoginResultVerBinding = UserInfo.a().i().getVerified_bindings();
      if (bluedLoginResultVerBinding != null)
        return bluedLoginResultVerBinding.third_weixin; 
    } 
    return "";
  }
  
  public static boolean c(String paramString) {
    try {
      Gson gson = AppInfo.f();
      BluedEntityA bluedEntityA = (BluedEntityA)gson.fromJson(paramString, (new TypeToken<BluedEntityA<BluedCheckResult>>() {
          
          }).getType());
      if (bluedEntityA != null && bluedEntityA.hasData()) {
        String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
        Logger.b(p, new Object[] { "解密：deData===", str });
        BluedCheckResult bluedCheckResult = (BluedCheckResult)gson.fromJson(str, BluedCheckResult.class);
        if (bluedCheckResult != null) {
          int i = bluedCheckResult.getIs_sm_captcha();
          if (i == 1)
            return true; 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  public static BluedCheckResult d(String paramString) {
    try {
      Gson gson = AppInfo.f();
      BluedEntityA bluedEntityA = (BluedEntityA)gson.fromJson(paramString, (new TypeToken<BluedEntityA<BluedCheckResult>>() {
          
          }).getType());
      if (bluedEntityA != null && bluedEntityA.hasData()) {
        String str = AesCrypto.c(((BluedCheckResult)bluedEntityA.data.get(0)).get_());
        Logger.b(p, new Object[] { "解密：deData===", str });
        return (BluedCheckResult)gson.fromJson(str, BluedCheckResult.class);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return new BluedCheckResult();
  }
  
  public static String d() {
    String str = UserInfo.a().g();
    if (!TextUtils.isEmpty(str))
      return str; 
    if (UserInfo.a().i() != null) {
      BluedLoginResultVerBinding bluedLoginResultVerBinding = UserInfo.a().i().getVerified_bindings();
      if (bluedLoginResultVerBinding != null)
        return bluedLoginResultVerBinding.safe_email; 
    } 
    return "";
  }
  
  public static String e(String paramString) {
    try {
      if (StringUtils.e(paramString))
        return ""; 
      StringBuffer stringBuffer1 = new StringBuffer(paramString);
      if (stringBuffer1.length() <= 7)
        return paramString; 
      int i = 0;
      paramString = stringBuffer1.substring(0, 3);
      String str = stringBuffer1.substring(stringBuffer1.length() - 4, stringBuffer1.length());
      StringBuffer stringBuffer2 = new StringBuffer();
      while (i < stringBuffer1.length() - 7) {
        stringBuffer2.append("*");
        i++;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(stringBuffer2.toString());
      stringBuilder.append(str);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static void e() {
    ChatManager.getInstance().getSessionSettingModel((short)1, 2L, new FetchDataListener<SessionSettingBaseModel>() {
          public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
            LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<RemindSettingModel>>(this) {
                  public void a(BluedEntityA<RemindSettingModel> param2BluedEntityA) {
                    if (param2BluedEntityA != null)
                      try {
                        if (param2BluedEntityA.hasData()) {
                          List<RemindSettingModel> list = param2BluedEntityA.data;
                          boolean bool = false;
                          RemindSettingModel remindSettingModel = list.get(0);
                          BluedPreferences.l("1".equals(remindSettingModel.is_other_message_push));
                          BluedPreferences.i("1".equals(remindSettingModel.getIs_push_content()));
                          BluedPreferences.g("1".equals(remindSettingModel.getIs_open_sound()));
                          BluedPreferences.f("1".equals(remindSettingModel.getIs_bluedtone()));
                          BluedPreferences.h("1".equals(remindSettingModel.getIs_open_shake()));
                          BluedPreferences.j("1".equals(remindSettingModel.getIs_system_push()));
                          BluedPreferences.k("0".equals(remindSettingModel.getIs_live_push()));
                          BluedPreferences.m("1".equals(remindSettingModel.getIs_private_msg_push()));
                          BluedPreferences.n("1".equals(remindSettingModel.getIs_followed_push()));
                          BluedPreferences.o("1".equals(remindSettingModel.getIs_groups_notify()));
                          if ("2".equals(remindSettingModel.getIs_comment_push()) || "1".equals(remindSettingModel.getIs_comment_push()))
                            bool = true; 
                          BluedPreferences.p(bool);
                          BluedPreferences.t("1".equals(remindSettingModel.is_recall_live_push));
                          BluedPreferences.q("1".equals(remindSettingModel.is_like_push));
                          BluedPreferences.r("1".equals(remindSettingModel.is_at_push));
                          BluedPreferences.s("1".equals(remindSettingModel.is_visited_push));
                          BluedPreferences.u("1".equals(remindSettingModel.is_push_posting_post));
                          BluedPreferences.L("1".equals(remindSettingModel.is_verify_mobile_push));
                          BluedPreferences.M("1".equals(remindSettingModel.is_used_mobile_push));
                          return;
                        } 
                      } catch (Exception exception) {
                        exception.printStackTrace();
                      }  
                  }
                },  UserInfo.a().i().getUid(), null);
          }
        });
  }
  
  public static String f(String paramString) {
    try {
      if (!StringUtils.e(paramString))
        return AesCrypto.b(paramString); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
  
  public static String g(String paramString) {
    try {
      if (!StringUtils.e(paramString))
        return AesCrypto.c(paramString); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
  
  public static String[] h(String paramString) {
    String[] arrayOfString = new String[2];
    if (!StringUtils.e(paramString) && paramString.contains("-")) {
      String[] arrayOfString1 = paramString.split("-");
      if (arrayOfString1.length == 2)
        return arrayOfString1; 
    } 
    return arrayOfString;
  }
  
  public static String i(String paramString) {
    String[] arrayOfString = h(paramString);
    String str = e(arrayOfString[1]);
    return a(arrayOfString[0], str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\LoginRegisterTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
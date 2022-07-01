package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.das.login.LoginAndRegisterProtos;
import com.qq.e.comm.managers.GDTADManager;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;

public class ClausePermissionFragment extends BaseFragment {
  private Context d;
  
  private BluedAlertDialog e;
  
  private BluedAlertDialog f;
  
  private View g;
  
  private void a() {
    if (getActivity() != null)
      getActivity().finish(); 
    AppUtils.a(this.d);
  }
  
  public static void a(Context paramContext) {
    if (!CommonConstants.d) {
      CommonConstants.d = true;
      TerminalActivity.d(paramContext, ClausePermissionFragment.class, null);
    } 
  }
  
  private void b(Context paramContext) {
    String str;
    if (BluedPreferences.aA() != 1 && !BluedPreferences.aB()) {
      EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_SHOW);
      this.e = CommonAlertDialog.a(paramContext, 0, getString(2131759169), getString(2131759168), getString(2131759167), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              try {
                BluedPreferences.aC();
                BluedDeviceIdentity bluedDeviceIdentity = BluedDeviceIdentity.a();
                Context context = AppInfo.d();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(BluedHttpUrl.n());
                stringBuilder.append("/blued/device");
                bluedDeviceIdentity.a(context, stringBuilder.toString(), "com.bluecity.blued-KPiA1xP30QYJy", "3UOTFs6sc6mC8ZTmjKckn3cWfnk7hIbS");
                InitTaskUtil.initMap();
                AppInfo.q();
                InitTaskUtil.initTTAdSDK();
                InitTaskUtil.initGeeTestSDK();
                InitTaskUtil.initYouZanSDK();
                InitTaskUtil.initYouMeng();
                InitTaskUtil.initZego();
                Logger.c("ljx_init", new Object[] { "guang dian tong" });
                GDTADManager.getInstance().initWith(AppInfo.d(), BluedConstant.a());
                Logger.c("ljx_init", new Object[] { "guang dian tong" });
                GDTADManager.getInstance().initWith(AppInfo.d(), BluedConstant.a());
                return;
              } catch (Exception exception) {
                return;
              } 
            }
          }getString(2131759166), null, new DialogInterface.OnDismissListener(this, paramContext) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              if (BluedPreferences.aB()) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_AGREE_CLICK);
                ClausePermissionFragment.a(this.b, this.a);
                return;
              } 
              EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_DISAGREE_CLICK);
              ClausePermissionFragment.a(this.b);
            }
          }3);
      this.e.a(false);
      TextView textView = this.e.e();
      TypefaceUtils.a(paramContext, textView, new View.OnClickListener(this, paramContext) {
            public void onClick(View param1View) {
              String str = H5Url.a(20);
              WebViewShowInfoFragment.show(this.a, str, 0);
            }
          }new TypefaceUtils.SpannIndex(26, 40), new TypefaceUtils.SpannIndex(46, 58));
      TypefaceUtils.a(paramContext, textView, new View.OnClickListener(this, paramContext) {
            public void onClick(View param1View) {
              WebViewShowInfoFragment.show(this.a, H5Url.a(21), 0);
            }
          }new TypefaceUtils.SpannIndex(41, 51), new TypefaceUtils.SpannIndex(63, 77));
      str = BlueAppLocal.c().getLanguage();
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getText());
      if ("zh".equals(str)) {
        if (26 < spannableStringBuilder.length() && 51 <= spannableStringBuilder.length()) {
          spannableStringBuilder.setSpan(new StyleSpan(1), 26, 40, 17);
          spannableStringBuilder.setSpan(new StyleSpan(1), 41, 51, 17);
        } 
      } else if (46 < spannableStringBuilder.length() && 77 <= spannableStringBuilder.length()) {
        spannableStringBuilder.setSpan(new StyleSpan(1), 46, 58, 17);
        spannableStringBuilder.setSpan(new StyleSpan(1), 63, 77, 17);
      } 
      textView.setText((CharSequence)spannableStringBuilder);
      return;
    } 
    c((Context)str);
  }
  
  private void c(Context paramContext) {
    if (!BluedApplicationLike.checkLaunchPermission || PermissionHelper.a()) {
      FirstActivity.a(paramContext, false);
      return;
    } 
    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_AUTHORITY_POP_SHOW);
    this.f = CommonAlertDialog.a(paramContext, getString(2131756608), getString(2131756607), getString(2131756606), new DialogInterface.OnClickListener(this, paramContext) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_AUTHORITY_POP_OPEN_CLICK);
            ClausePermissionFragment.b(this.b, this.a);
          }
        }null, 1);
    this.f.a(false);
    this.f.setOnCancelListener(new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            ClausePermissionFragment.a(this.a);
          }
        });
    this.f.c().setGravity(4);
  }
  
  private void d(Context paramContext) {
    PermissionHelper.h(new PermissionCallbacks(this, paramContext) {
          public void a(String[] param1ArrayOfString) {
            BluedApplicationLike.checkLaunchPermission = false;
            BluedPreferences.ex();
            FirstActivity.a(this.a, false);
          }
          
          public void aa_() {
            FirstActivity.a(this.a, false);
          }
        });
  }
  
  public boolean j() {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = getContext();
    b(this.d);
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493103, paramViewGroup, false);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    ActivityChangeAnimationUtils.i((Activity)getActivity());
    return this.g;
  }
  
  public void onDestroy() {
    BluedAlertDialog bluedAlertDialog = this.e;
    if (bluedAlertDialog != null && bluedAlertDialog.isShowing())
      this.e.dismiss(); 
    bluedAlertDialog = this.f;
    if (bluedAlertDialog != null && bluedAlertDialog.isShowing())
      this.f.dismiss(); 
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\ClausePermissionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
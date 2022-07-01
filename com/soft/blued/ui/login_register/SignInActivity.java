package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.soft.blued.ui.login_register.View.LoginFragment;
import com.soft.blued.user.UserInfo;
import com.umeng.analytics.MobclickAgent;

public class SignInActivity extends BaseFragmentActivity {
  public static boolean c = false;
  
  public static String d;
  
  public static String e;
  
  public static void a(Context paramContext, Bundle... paramVarArgs) {
    if (paramContext == null)
      return; 
    Intent intent = new Intent(paramContext, SignInActivity.class);
    if (paramVarArgs != null && paramVarArgs.length > 0)
      intent.putExtra("fragment_args", paramVarArgs[0]); 
    paramContext.startActivity(intent);
    if (paramVarArgs.length == 0 && paramContext instanceof Activity && !(paramContext instanceof SignInActivity) && paramVarArgs.length <= 0)
      ((Activity)paramContext).finish(); 
  }
  
  public AppCompatDelegate getDelegate() {
    return SkinAppCompatDelegateImpl.get((Activity)this, (AppCompatCallback)this);
  }
  
  public void onCreate(Bundle paramBundle) {
    boolean bool;
    if (AppInfo.p()) {
      bool = StatusBarHelper.a((Activity)this);
    } else {
      bool = false;
    } 
    super.onCreate(paramBundle);
    if (UserInfo.a().j() && getIntent().getBundleExtra("fragment_args") == null) {
      finish();
      return;
    } 
    setContentView(2131492917);
    if (bool) {
      View view = findViewById(2131296834);
      if (view != null)
        view.setFitsSystemWindows(true); 
    } 
    if (paramBundle == null) {
      LoginFragment loginFragment = new LoginFragment();
      if (getIntent().getBundleExtra("fragment_args") != null)
        loginFragment.setArguments(getIntent().getBundleExtra("fragment_args")); 
      FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
      fragmentTransaction.replace(2131296834, (Fragment)loginFragment, "signin");
      fragmentTransaction.commitAllowingStateLoss();
    } 
    c = false;
  }
  
  public void onPause() {
    super.onPause();
    MobclickAgent.onPageEnd(getClass().getSimpleName());
    MobclickAgent.onPause((Context)this);
  }
  
  public void onResume() {
    super.onResume();
    MobclickAgent.onPageStart(getClass().getSimpleName());
    MobclickAgent.onResume((Context)this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\SignInActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
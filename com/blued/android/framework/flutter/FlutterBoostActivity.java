package com.blued.android.framework.flutter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.swipeback.SwipeBackActivityHelper;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.utils.BluedPreferences;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;

public class FlutterBoostActivity extends BoostFlutterActivity implements PageTimeUtils.APMInterface {
  public String a;
  
  private FlutterSplashView c;
  
  private SwipeBackActivityHelper d;
  
  private String e = null;
  
  public static BoostFlutterActivity.NewEngineIntentBuilder e() {
    return new BoostFlutterActivity.NewEngineIntentBuilder(FlutterBoostActivity.class);
  }
  
  private void k() {
    if (TextUtils.isEmpty(this.a))
      if (TextUtils.isEmpty(BaseActivity.a)) {
        this.a = l();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BaseActivity.a);
        stringBuilder.append(",");
        stringBuilder.append(l());
        this.a = stringBuilder.toString();
      }  
    BaseActivity.a = this.a;
    Page page = BluedStatistics.d();
    String str1 = c();
    String str2 = Integer.toHexString(hashCode());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[");
    stringBuilder2.append(this.a);
    stringBuilder2.append("]");
    page.a(str1, str2, stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("curPageRouterName: ");
    stringBuilder1.append(this.a);
    LogUtils.a(stringBuilder1.toString());
  }
  
  private String l() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[\"");
    stringBuilder.append(c());
    stringBuilder.append("\",");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private String m() {
    return this.e;
  }
  
  public String X_() {
    return null;
  }
  
  public boolean a() {
    return false;
  }
  
  protected void attachBaseContext(Context paramContext) {
    if (AppInfo.b() != null) {
      super.attachBaseContext(AppInfo.b().a(paramContext));
      return;
    } 
    super.attachBaseContext(paramContext);
  }
  
  protected String c() {
    return PageTimeUtils.d(m());
  }
  
  public View d() {
    this.c = (FlutterSplashView)super.d();
    return (View)this.c;
  }
  
  public <T extends View> T findViewById(int paramInt) {
    View view = super.findViewById(paramInt);
    if (view == null) {
      SwipeBackActivityHelper swipeBackActivityHelper = this.d;
      if (swipeBackActivityHelper != null)
        return (T)swipeBackActivityHelper.a(paramInt); 
    } 
    return (T)view;
  }
  
  public void onBackPressed() {
    finish();
    LogUtils.c("onBackPressed");
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.d = new SwipeBackActivityHelper();
    this.d.a((Activity)this);
    this.e = getIntent().getStringExtra("url");
    if (BluedSkinUtils.a((Activity)this)) {
      StatusBarHelper.b((Activity)this, false);
    } else {
      StatusBarHelper.b((Activity)this, true);
    } 
    LiveEventBus.get("close_flutter", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.f().finish();
          }
        });
  }
  
  protected void onPostCreate(Bundle paramBundle) {
    super.onPostCreate(paramBundle);
    SwipeBackActivityHelper swipeBackActivityHelper = this.d;
    if (swipeBackActivityHelper != null)
      swipeBackActivityHelper.b((Activity)this); 
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (AppInfo.b() != null)
      AppInfo.b().a((Context)this, paramInt, paramArrayOfString, paramArrayOfint); 
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle) {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
      this.a = paramBundle.getString("router_name"); 
    if (AppInfo.b() != null)
      AppInfo.b().a((Context)this, paramBundle); 
  }
  
  public void onResume() {
    super.onResume();
    k();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putString("router_name", this.a);
    super.onSaveInstanceState(bundle);
    if (AppInfo.b() != null)
      AppInfo.b().a(bundle); 
  }
  
  public void onStart() {
    super.onStart();
    if (!a())
      PageTimeUtils.a(this); 
  }
  
  public void onStop() {
    super.onStop();
    if (!a())
      PageTimeUtils.b(this); 
  }
  
  public SplashScreen provideSplashScreen() {
    int i;
    if (BluedPreferences.cZ()) {
      i = Color.parseColor("#FF000000");
    } else {
      i = Color.parseColor("#FFFFFFFF");
    } 
    return (SplashScreen)new DrawableSplashScreen((Drawable)new ColorDrawable(i));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\flutter\FlutterBoostActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
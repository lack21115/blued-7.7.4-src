package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class c extends a {
  private void a(Intent paramIntent) {
    // Byte code:
    //   0: new android/content/Intent
    //   3: dup
    //   4: ldc 'com.apptouch.intent.action.update_hms'
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual b : ()Landroid/app/Activity;
    //   14: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   17: aload_2
    //   18: iconst_0
    //   19: invokevirtual queryIntentServices : (Landroid/content/Intent;I)Ljava/util/List;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull -> 84
    //   27: aload_2
    //   28: invokeinterface isEmpty : ()Z
    //   33: ifne -> 84
    //   36: aload_2
    //   37: invokeinterface iterator : ()Ljava/util/Iterator;
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface hasNext : ()Z
    //   49: ifeq -> 84
    //   52: aload_3
    //   53: invokeinterface next : ()Ljava/lang/Object;
    //   58: checkcast android/content/pm/ResolveInfo
    //   61: getfield serviceInfo : Landroid/content/pm/ServiceInfo;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull -> 43
    //   69: aload_2
    //   70: getfield packageName : Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   78: ifne -> 43
    //   81: goto -> 86
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   90: ifne -> 99
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   98: pop
    //   99: return
  }
  
  private boolean d() {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return false; 
      if (TextUtils.isEmpty(this.g))
        return false; 
      try {
        Intent intent = new Intent();
        intent.setAction("com.huawei.appmarket.intent.action.AppDetail");
        intent.putExtra("APP_PACKAGENAME", this.g);
        a(intent);
        activity.startActivityForResult(intent, getRequestCode());
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        HMSLog.e("AppTouchWizard", "can not open AppTouch detail page");
      } 
    } 
    return false;
  }
  
  void a() {
    b(13, this.f);
  }
  
  public void a(b paramb) {
    HMSLog.i("AppTouchWizard", "Enter onCancel.");
    if (paramb instanceof i)
      a(); 
  }
  
  void a(Class<? extends b> paramClass) {
    c();
    try {
      b b = paramClass.newInstance();
      if (!TextUtils.isEmpty(this.h) && b instanceof i) {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((i)b).a(this.h);
      } 
      b.a(this);
      this.d = b;
      return;
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalStateException illegalStateException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In showDialog, Failed to show the dialog.");
    stringBuilder.append(illegalStateException.getMessage());
    HMSLog.e("AppTouchWizard", stringBuilder.toString());
  }
  
  public void b(b paramb) {
    HMSLog.i("AppTouchWizard", "Enter onDoWork.");
    if (paramb instanceof i) {
      paramb.c();
      if (!d())
        a(8, this.f); 
    } 
  }
  
  public int getRequestCode() {
    return 2007;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null)
      return; 
    this.f = 7;
    if (this.c.isNeedConfirm() && !TextUtils.isEmpty(this.h)) {
      a((Class)i.class);
      return;
    } 
    if (!d())
      a(8, this.f); 
  }
  
  public void onBridgeActivityDestroy() {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.e && this.b != null)
      return this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent); 
    if (this.f == 7 && paramInt1 == getRequestCode()) {
      if (a(this.g, this.i)) {
        b(0, this.f);
      } else {
        b(8, this.f);
      } 
      return true;
    } 
    return false;
  }
  
  public void onBridgeConfigurationChanged() {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (this.e && this.b != null) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
      return;
    } 
    if (4 == paramInt) {
      HMSLog.i("AppTouchWizard", "In onKeyUp, Call finish.");
      Activity activity = b();
      if (activity != null && !activity.isFinishing()) {
        activity.setResult(0, null);
        activity.finish();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
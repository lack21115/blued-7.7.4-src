package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;

public class BridgeActivity extends Activity {
  public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
  
  public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
  
  public static final String EXTRA_INTENT = "intent.extra.intent";
  
  public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
  
  public static final String EXTRA_RESULT = "intent.extra.RESULT";
  
  private static final int b = a("ro.build.hw_emui_api_level", 0);
  
  private IBridgeActivityDelegate a;
  
  private static int a(String paramString, int paramInt) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return ((Integer)clazz.getDeclaredMethod("getInt", new Class[] { String.class, int.class }).invoke(clazz, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
    } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|InvocationTargetException|ClassCastException classNotFoundException) {
      HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
      return paramInt;
    } 
  }
  
  private void a() {
    requestWindowFeature(1);
    Window window = getWindow();
    if (b >= 9) {
      window.addFlags(67108864);
      a(window, true);
    } 
    window.getDecorView().setSystemUiVisibility(0);
  }
  
  private static void a(Window paramWindow, boolean paramBoolean) {
    try {
      paramWindow.getClass().getMethod("setHwFloating", new Class[] { boolean.class }).invoke(paramWindow, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In setHwFloating, Failed to call Window.setHwFloating().");
    stringBuilder.append(invocationTargetException.getMessage());
    HMSLog.e("BridgeActivity", stringBuilder.toString());
  }
  
  private boolean b() {
    Intent intent = getIntent();
    if (intent == null) {
      HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
      return false;
    } 
    if (intent.getBooleanExtra("intent.extra.isfullscreen", false))
      getWindow().setFlags(1024, 1024); 
    String str = intent.getStringExtra("intent.extra.DELEGATE_CLASS_OBJECT");
    if (str == null) {
      HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
      return false;
    } 
    try {
      this.a = Class.forName(str).<IBridgeActivityDelegate>asSubclass(IBridgeActivityDelegate.class).newInstance();
      try {
        this.a.onBridgeActivityCreate(this);
        return true;
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Run time Exception.");
        stringBuilder1.append(runtimeException.getMessage());
        HMSLog.e("BridgeActivity", stringBuilder1.toString());
        return false;
      } 
    } catch (ClassCastException classCastException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (ClassNotFoundException classNotFoundException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In initialize, Failed to create 'IUpdateWizard' instance.");
    stringBuilder.append(classNotFoundException.getMessage());
    HMSLog.e("BridgeActivity", stringBuilder.toString());
    return false;
  }
  
  public static Intent getIntentStartBridgeActivity(Activity paramActivity, String paramString) {
    Intent intent = new Intent((Context)paramActivity, BridgeActivity.class);
    intent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(paramActivity));
    return intent;
  }
  
  public static Intent getIntentStartBridgeActivity(Context paramContext, String paramString) {
    Intent intent = new Intent(paramContext, BridgeActivity.class);
    intent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", paramString);
    intent.putExtra("intent.extra.isfullscreen", false);
    return intent;
  }
  
  public void finish() {
    HMSLog.i("BridgeActivity", "Enter finish.");
    super.finish();
  }
  
  public Intent getIntent() {
    Intent intent = super.getIntent();
    return (Intent)((intent != null) ? new SafeIntent(intent) : intent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    SafeIntent safeIntent = new SafeIntent(paramIntent);
    super.onActivityResult(paramInt1, paramInt2, (Intent)safeIntent);
    IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
    if (iBridgeActivityDelegate != null && !iBridgeActivityDelegate.onBridgeActivityResult(paramInt1, paramInt2, (Intent)safeIntent) && !isFinishing()) {
      setResult(paramInt2, (Intent)safeIntent);
      finish();
    } 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
    if (iBridgeActivityDelegate != null)
      iBridgeActivityDelegate.onBridgeConfigurationChanged(); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getIntent() == null)
      return; 
    a();
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(getApplicationContext()); 
    if (!b()) {
      setResult(1, null);
      finish();
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
    if (iBridgeActivityDelegate != null)
      iBridgeActivityDelegate.onBridgeActivityDestroy(); 
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
    if (iBridgeActivityDelegate != null)
      iBridgeActivityDelegate.onKeyUp(paramInt, paramKeyEvent); 
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\BridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
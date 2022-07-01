package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.NetWorkUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class a implements IBridgeActivityDelegate {
  public WeakReference<Activity> a;
  
  public IBridgeActivityDelegate b;
  
  protected UpdateBean c = null;
  
  protected b d = null;
  
  protected boolean e = false;
  
  protected int f = -1;
  
  protected String g = null;
  
  protected String h = null;
  
  protected int i = 0;
  
  protected String j = null;
  
  public static String a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 4) ? ((paramInt != 5) ? ((paramInt != 6) ? ((paramInt != 7) ? "" : c.class.getName()) : l.class.getName()) : h.class.getName()) : g.class.getName()) : k.class.getName();
  }
  
  private void a(UpdateBean paramUpdateBean) {
    this.c = paramUpdateBean;
  }
  
  private void a(ArrayList<Integer> paramArrayList) {
    if (paramArrayList != null && paramArrayList.size() > 0) {
      String str = a(((Integer)paramArrayList.get(0)).intValue());
    } else {
      paramArrayList = null;
    } 
    if (paramArrayList == null)
      return; 
    try {
      this.b = Class.forName((String)paramArrayList).<IBridgeActivityDelegate>asSubclass(IBridgeActivityDelegate.class).newInstance();
      return;
    } catch (ClassCastException classCastException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (ClassNotFoundException classNotFoundException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getBridgeActivityDelegate error");
    stringBuilder.append(classNotFoundException.getMessage());
    HMSLog.e("AbsUpdateWizard", stringBuilder.toString());
  }
  
  private String c(int paramInt1, int paramInt2) {
    String str = String.valueOf(paramInt1);
    if (paramInt2 != 0) {
      if (paramInt2 != 4) {
        if (paramInt2 != 5) {
          if (paramInt2 != 6)
            return str; 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("4000");
          stringBuilder3.append(str);
          return stringBuilder3.toString();
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("5000");
        stringBuilder2.append(str);
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("6000");
      stringBuilder1.append(str);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("0000");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  abstract void a();
  
  protected void a(int paramInt1, int paramInt2) {
    if (!SystemUtils.isChinaROM()) {
      HMSLog.i("AbsUpdateWizard", "not ChinaROM ");
      return;
    } 
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      int i = (new PackageManagerHelper((Context)activity)).getPackageVersionCode(this.g);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("package", activity.getPackageName());
      hashMap.put("target_package", this.g);
      hashMap.put("target_ver", String.valueOf(i));
      hashMap.put("sdk_ver", String.valueOf(50004301));
      hashMap.put("app_id", AGCUtils.getAppId((Context)activity));
      hashMap.put("trigger_api", "core.connnect");
      hashMap.put("update_type", String.valueOf(paramInt2));
      hashMap.put("net_type", String.valueOf(NetWorkUtil.getNetworkType((Context)activity)));
      hashMap.put("result", c(paramInt1, paramInt2));
      HiAnalyticsUtils.getInstance().onEvent((Context)activity, "HMS_SDK_UPDATE", hashMap);
    } 
  }
  
  public void a(b paramb) {}
  
  abstract void a(Class<? extends b> paramClass);
  
  protected boolean a(String paramString, int paramInt) {
    boolean bool = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool)
      return false; 
    Activity activity = b();
    bool = bool1;
    if (activity != null) {
      if (activity.isFinishing())
        return false; 
      bool = bool1;
      if ((new PackageManagerHelper((Context)activity)).getPackageVersionCode(paramString) >= paramInt)
        bool = true; 
    } 
    return bool;
  }
  
  protected boolean a(boolean paramBoolean) {
    Activity activity = b();
    boolean bool = false;
    if (activity == null)
      return false; 
    ArrayList arrayList = this.c.getTypeList();
    if (arrayList.size() > 0)
      arrayList.remove(0); 
    if (this.b == null)
      a(arrayList); 
    if (this.b != null) {
      bool = true;
      this.e = true;
      this.c.setTypeList(arrayList);
      this.c.setNeedConfirm(paramBoolean);
      IBridgeActivityDelegate iBridgeActivityDelegate = this.b;
      if (iBridgeActivityDelegate instanceof a)
        ((a)iBridgeActivityDelegate).a(this.c); 
      this.b.onBridgeActivityCreate(activity);
    } 
    return bool;
  }
  
  protected Activity b() {
    WeakReference<Activity> weakReference = this.a;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  protected void b(int paramInt1, int paramInt2) {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      a(paramInt1, paramInt2);
      Intent intent = new Intent();
      intent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", getClass().getName());
      intent.putExtra("intent.extra.RESULT", paramInt1);
      activity.setResult(-1, intent);
      activity.finish();
    } 
  }
  
  public void b(b paramb) {}
  
  protected void c() {
    b b1 = this.d;
    if (b1 == null)
      return; 
    try {
      b1.c();
      this.d = null;
      return;
    } catch (IllegalStateException illegalStateException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("In dismissDialog, Failed to dismiss the dialog.");
      stringBuilder.append(illegalStateException.getMessage());
      HMSLog.e("AbsUpdateWizard", stringBuilder.toString());
      return;
    } 
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    this.a = new WeakReference<Activity>(paramActivity);
    if (this.c == null) {
      Intent intent = paramActivity.getIntent();
      if (intent == null)
        return; 
      this.c = (UpdateBean)intent.getSerializableExtra("intent.extra.update.info");
      if (this.c == null)
        return; 
    } 
    this.g = this.c.b();
    this.h = this.c.getClientAppName();
    this.i = this.c.c();
    this.j = this.c.d();
    this.b = null;
    this.e = false;
    this.f = -1;
  }
  
  public void onBridgeActivityDestroy() {
    this.a = null;
    c();
    if (this.e) {
      IBridgeActivityDelegate iBridgeActivityDelegate = this.b;
      if (iBridgeActivityDelegate != null)
        iBridgeActivityDelegate.onBridgeActivityDestroy(); 
    } 
  }
  
  public void onBridgeConfigurationChanged() {
    if (this.e) {
      IBridgeActivityDelegate iBridgeActivityDelegate = this.b;
      if (iBridgeActivityDelegate != null) {
        iBridgeActivityDelegate.onBridgeConfigurationChanged();
        return;
      } 
    } 
    b b1 = this.d;
    if (b1 == null)
      return; 
    Class<?> clazz = b1.getClass();
    this.d.c();
    this.d = null;
    a((Class)clazz);
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (this.e) {
      IBridgeActivityDelegate iBridgeActivityDelegate = this.b;
      if (iBridgeActivityDelegate != null)
        iBridgeActivityDelegate.onKeyUp(paramInt, paramKeyEvent); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
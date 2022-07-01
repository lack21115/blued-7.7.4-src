package com.alibaba.mtl.log;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.e.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.io.UnsupportedEncodingException;

public class b {
  private static b a = new b();
  
  private String C = null;
  
  private String D = null;
  
  private String E = null;
  
  private String F = null;
  
  private String G = null;
  
  private Application a;
  
  private IUTRequestAuthentication a = null;
  
  private Context mContext = null;
  
  private boolean s;
  
  private boolean t;
  
  private b() {
    this.a = null;
    this.s = false;
    this.t = false;
  }
  
  public static b a() {
    return (b)a;
  }
  
  private void c(String paramString) {
    this.C = paramString;
    if (!TextUtils.isEmpty(paramString))
      this.D = paramString; 
    if (!TextUtils.isEmpty(paramString)) {
      Context context = this.mContext;
      if (context != null)
        try {
          SharedPreferences.Editor editor = context.getSharedPreferences("UTCommon", 0).edit();
          editor.putString("_lun", new String(c.encode(paramString.getBytes("UTF-8"), 2)));
          editor.commit();
          return;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        }  
    } 
  }
  
  private void d(String paramString) {
    this.E = paramString;
    if (!TextUtils.isEmpty(paramString))
      this.F = paramString; 
    if (!TextUtils.isEmpty(paramString)) {
      Context context = this.mContext;
      if (context != null)
        try {
          SharedPreferences.Editor editor = context.getSharedPreferences("UTCommon", 0).edit();
          editor.putString("_luid", new String(c.encode(paramString.getBytes("UTF-8"), 2)));
          editor.commit();
          return;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        }  
    } 
  }
  
  private void o() {
    if (!this.s && Build.VERSION.SDK_INT >= 14)
      try {
        if (a().a() != null) {
          UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(a().a());
          this.s = true;
          return;
        } 
        UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application)a().getContext().getApplicationContext());
        this.s = true;
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        Log.e("UTEngine", "You need set a application instance for UT.");
      }  
  }
  
  public Application a() {
    return (Application)this.a;
  }
  
  public String getAppVersion() {
    return this.G;
  }
  
  public Context getContext() {
    return this.mContext;
  }
  
  public void setAppApplicationInstance(Application paramApplication) {
    this.a = (IUTRequestAuthentication)paramApplication;
    o();
  }
  
  public void setAppVersion(String paramString) {
    this.G = paramString;
  }
  
  public void setContext(Context paramContext) {
    if (paramContext != null) {
      this.mContext = paramContext;
      SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("UTCommon", 0);
      String str2 = sharedPreferences.getString("_lun", "");
      if (!TextUtils.isEmpty(str2))
        try {
          this.D = new String(c.decode(str2.getBytes(), 2), "UTF-8");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        }  
      String str1 = sharedPreferences.getString("_luid", "");
      if (!TextUtils.isEmpty(str1))
        try {
          this.F = new String(c.decode(str1.getBytes(), 2), "UTF-8");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        }  
    } 
    o();
  }
  
  public void turnOnDebug() {
    i.d(true);
  }
  
  public void updateUserAccount(String paramString1, String paramString2) {
    c(paramString1);
    d(paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1007, paramString1, paramString2, null, null);
      UTAnalytics.getInstance().getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
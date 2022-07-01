package com.blued.android.module.im.biz;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.im.CommonOuterClass;
import java.util.TimeZone;

public class Common {
  private CommonOuterClass.Common.Builder a = CommonOuterClass.Common.newBuilder();
  
  private CommonOuterClass.Common b = null;
  
  private String c = "";
  
  private String d = "";
  
  private TimeZone e = TimeZone.getDefault();
  
  private String f = "";
  
  private boolean g = false;
  
  private Common() {
    c();
  }
  
  public static Common a() {
    return InstanceHolder.a();
  }
  
  private void c() {
    if (TextUtils.isEmpty(this.c)) {
      this.c = DeviceUtils.a();
      this.a.setDevice(e(this.c));
    } 
    if (TextUtils.isEmpty(this.d)) {
      this.d = Build.VERSION.RELEASE;
      this.a.setOsVersion(e(this.d));
    } 
    if (TextUtils.isEmpty(this.f)) {
      try {
        StringBuilder stringBuilder = new StringBuilder(this.e.getID());
        stringBuilder.append(",");
        stringBuilder.append(this.e.getDisplayName(false, 0));
        this.f = stringBuilder.toString();
      } catch (AssertionError|Exception assertionError) {}
      this.a.setTimezone(e(this.f));
    } 
  }
  
  private String e(String paramString) {
    this.g = true;
    return Utils.b(paramString);
  }
  
  public Common a(int paramInt) {
    this.g = true;
    this.a.setAppVersionCode(paramInt);
    return this;
  }
  
  public Common a(String paramString) {
    this.a.setChannel(e(paramString));
    return this;
  }
  
  public Common b(String paramString) {
    this.a.setPlatform(e(paramString));
    return this;
  }
  
  public CommonOuterClass.Common b() {
    if (this.b == null || this.g) {
      this.b = this.a.build();
      this.g = false;
    } 
    return this.b;
  }
  
  public Common c(String paramString) {
    this.a.setAppVersion(e(paramString));
    return this;
  }
  
  public Common d(String paramString) {
    this.a.setLanguage(e(paramString));
    return this;
  }
  
  static class InstanceHolder {
    private static final Common a = new Common();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
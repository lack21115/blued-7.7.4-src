package com.blued.android.statistics.biz;

import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.das.CommonProtos;
import java.util.Locale;
import java.util.TimeZone;

public class Common {
  private CommonProtos.Common.Builder a = CommonProtos.Common.newBuilder();
  
  private CommonProtos.Common b = null;
  
  private String c = "";
  
  private String d = "";
  
  private TimeZone e = TimeZone.getDefault();
  
  private String f = "";
  
  private Locale g = Locale.getDefault();
  
  private String h = "";
  
  private String i = "";
  
  private boolean j = false;
  
  private Common() {
    c();
  }
  
  public static Common a() {
    return InstanceHolder.a();
  }
  
  private void c() {
    if (TextUtils.isEmpty(this.c)) {
      this.c = DeviceUtils.a();
      this.a.setDevice(m(this.c));
    } 
    if (TextUtils.isEmpty(this.d)) {
      this.d = Build.VERSION.RELEASE;
      this.a.setOsVersion(m(this.d));
    } 
    if (TextUtils.isEmpty(this.f)) {
      try {
        StringBuilder stringBuilder = new StringBuilder(this.e.getID());
        stringBuilder.append(",");
        stringBuilder.append(this.e.getDisplayName(false, 0));
        this.f = stringBuilder.toString();
      } catch (AssertionError|Exception assertionError) {}
      this.a.setTimezone(m(this.f));
    } 
    if (TextUtils.isEmpty(this.h)) {
      this.h = this.g.getLanguage();
      this.a.setLanguage(m(this.h));
    } 
    if (TextUtils.isEmpty(this.i)) {
      this.i = this.g.getCountry();
      this.a.setRegion(m(this.i));
    } 
  }
  
  private String m(String paramString) {
    this.j = true;
    return Utils.b(paramString);
  }
  
  public Common a(int paramInt) {
    this.j = true;
    this.a.setAppVersionCode(paramInt);
    return this;
  }
  
  public Common a(Point paramPoint) {
    int i;
    this.j = true;
    CommonProtos.Common.Builder builder = this.a;
    boolean bool = false;
    if (paramPoint == null) {
      i = 0;
    } else {
      i = paramPoint.x;
    } 
    builder.setScreenWidth(i);
    builder = this.a;
    if (paramPoint == null) {
      i = bool;
    } else {
      i = paramPoint.y;
    } 
    builder.setScreenHigh(i);
    return this;
  }
  
  public Common a(String paramString) {
    this.a.setNetOp(m(paramString));
    return this;
  }
  
  public Common b(String paramString) {
    this.a.setNet(m(paramString));
    return this;
  }
  
  public CommonProtos.Common b() {
    if (this.b == null || this.j) {
      this.b = this.a.build();
      this.j = false;
    } 
    return this.b;
  }
  
  public Common c(String paramString) {
    this.a.setLat(m(paramString));
    return this;
  }
  
  public Common d(String paramString) {
    this.a.setLon(m(paramString));
    return this;
  }
  
  public Common e(String paramString) {
    this.a.setChannel(m(paramString));
    return this;
  }
  
  public Common f(String paramString) {
    this.j = true;
    if (!TextUtils.isEmpty(paramString) && TextUtils.isDigitsOnly(paramString)) {
      this.a.setUid(Long.parseLong(paramString));
      return this;
    } 
    this.a.setUid(0L);
    return this;
  }
  
  public Common g(String paramString) {
    this.a.setPlatform(m(paramString));
    return this;
  }
  
  public Common h(String paramString) {
    this.a.setAppVersion(m(paramString));
    return this;
  }
  
  public Common i(String paramString) {
    this.a.setImei(m(paramString));
    return this;
  }
  
  public Common j(String paramString) {
    this.a.setBoxId(m(paramString));
    return this;
  }
  
  public Common k(String paramString) {
    this.a.setDevDna(m(paramString));
    return this;
  }
  
  public Common l(String paramString) {
    this.a.setVipType(m(paramString));
    return this;
  }
  
  static class InstanceHolder {
    private static final Common a = new Common();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\biz\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.huawei.updatesdk.a.b.d.c.b;
import com.huawei.updatesdk.b.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends c {
  public static final String APIMETHOD = "client.updateCheck";
  
  public static final int DEFAULT_UPGRADE_RESULT = 0;
  
  public static final int FULL_UPGRADE_RESULT = 1;
  
  public static final int INSTALL_CHECK_DEFAULT = 0;
  
  private String agVersion_;
  
  private String buildNumber_;
  
  private String density_;
  
  private com.huawei.updatesdk.a.a.c.h.a deviceSpecParams_;
  
  private int emuiApiLevel_;
  
  private String firmwareVersion_;
  
  private int getSafeGame_;
  
  private int gmsSupport_;
  
  private int installCheck_;
  
  private int isFullUpgrade_;
  
  private int mapleVer_;
  
  private String packageName_;
  
  private String phoneType_;
  
  private a pkgInfo_;
  
  private String resolution_;
  
  private String serviceCountry_;
  
  private int supportMaple_;
  
  private int versionCode_;
  
  private String version_;
  
  public a() {}
  
  public a(List<Param> paramList) {
    this();
    a a1 = new a();
    a1.a(paramList);
    a(a1);
  }
  
  public static a a(List<PackageInfo> paramList) {
    a a1 = new a();
    a a2 = new a();
    a1.a(a2);
    ArrayList<Param> arrayList = new ArrayList();
    a2.a(arrayList);
    Iterator<PackageInfo> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(new Param(iterator.next())); 
    return a1;
  }
  
  public static a n(String paramString) {
    PackageInfo packageInfo = new PackageInfo();
    packageInfo.packageName = paramString;
    packageInfo.versionName = "1.0";
    packageInfo.versionCode = 1;
    ApplicationInfo applicationInfo = new ApplicationInfo();
    applicationInfo.targetSdkVersion = 19;
    packageInfo.applicationInfo = applicationInfo;
    ArrayList<PackageInfo> arrayList = new ArrayList();
    arrayList.add(packageInfo);
    a a1 = a(arrayList);
    a1.e(1);
    return a1;
  }
  
  public void a(a parama) {
    this.pkgInfo_ = parama;
  }
  
  public void b(int paramInt) {
    this.emuiApiLevel_ = paramInt;
  }
  
  public void c(int paramInt) {
    this.gmsSupport_ = paramInt;
  }
  
  public void d(int paramInt) {
    this.installCheck_ = paramInt;
  }
  
  public void e(int paramInt) {
    this.isFullUpgrade_ = paramInt;
  }
  
  public void e(String paramString) {
    this.agVersion_ = paramString;
  }
  
  public void f(int paramInt) {
    this.mapleVer_ = paramInt;
  }
  
  public void f(String paramString) {
    this.buildNumber_ = paramString;
  }
  
  public void g(int paramInt) {
    this.supportMaple_ = paramInt;
  }
  
  public void g(String paramString) {
    this.density_ = paramString;
  }
  
  public void h(int paramInt) {
    this.versionCode_ = paramInt;
  }
  
  public void h(String paramString) {
    this.firmwareVersion_ = paramString;
  }
  
  public void i(String paramString) {
    this.packageName_ = paramString;
  }
  
  public void j(String paramString) {
    this.phoneType_ = paramString;
  }
  
  public void k(String paramString) {
    this.resolution_ = paramString;
  }
  
  public void l(String paramString) {
    this.serviceCountry_ = paramString;
  }
  
  public void m(String paramString) {
    this.version_ = paramString;
  }
  
  public static class a extends b {
    private List<Param> params_;
    
    public void a(List<Param> param1List) {
      this.params_ = param1List;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\appmgr\bean\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
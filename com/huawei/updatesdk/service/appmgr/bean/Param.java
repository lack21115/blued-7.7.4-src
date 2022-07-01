package com.huawei.updatesdk.service.appmgr.bean;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.a;
import com.huawei.updatesdk.a.a.c.g;
import com.huawei.updatesdk.a.b.d.c.b;
import com.huawei.updatesdk.b.a.a.b;
import com.huawei.updatesdk.b.a.b.b;
import com.huawei.updatesdk.b.f.b;
import java.util.List;
import java.util.Locale;

public class Param extends b {
  private String fSha2_;
  
  private int isPre_;
  
  private List<String> keySets_;
  
  private int maple_;
  
  private String oldVersion_;
  
  private String package_;
  
  private String sSha2_;
  
  private int targetSdkVersion_;
  
  private int versionCode_;
  
  public Param() {}
  
  public Param(PackageInfo paramPackageInfo) {
    this.package_ = paramPackageInfo.packageName;
    this.versionCode_ = paramPackageInfo.versionCode;
    String str2 = paramPackageInfo.versionName;
    String str1 = str2;
    if (str2 == null)
      str1 = "null"; 
    this.oldVersion_ = str1;
    this.targetSdkVersion_ = paramPackageInfo.applicationInfo.targetSdkVersion;
    this.isPre_ = b.a(paramPackageInfo);
    this.maple_ = b.a(this.package_);
    this.keySets_ = b.a().a(paramPackageInfo);
    Signature[] arrayOfSignature = paramPackageInfo.signatures;
    if (arrayOfSignature != null && arrayOfSignature.length > 0)
      setApkSignature(arrayOfSignature[0].toCharsString()); 
    this.fSha2_ = b.a().a(paramPackageInfo);
  }
  
  public void setApkFileSha256(String paramString) {
    this.fSha2_ = paramString;
  }
  
  public void setApkSignature(String paramString) {
    paramString = g.b(a.a(g.c(paramString)));
    if (!TextUtils.isEmpty(paramString))
      this.sSha2_ = paramString.toLowerCase(Locale.getDefault()); 
  }
  
  public void setMapleState(int paramInt) {
    this.maple_ = paramInt;
  }
  
  public void setPackageName(String paramString) {
    this.package_ = paramString;
  }
  
  public void setTargetSdkVersion(int paramInt) {
    this.targetSdkVersion_ = paramInt;
  }
  
  public void setVersionCode(int paramInt) {
    this.versionCode_ = paramInt;
  }
  
  public void setVersionName(String paramString) {
    this.oldVersion_ = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\appmgr\bean\Param.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
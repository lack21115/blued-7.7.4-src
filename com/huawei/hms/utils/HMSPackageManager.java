package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.a.a;
import java.security.cert.X509Certificate;
import java.util.List;

public class HMSPackageManager {
  private static HMSPackageManager a;
  
  private static final Object b = new Object();
  
  private static final Object c = new Object();
  
  private final Context d;
  
  private final PackageManagerHelper e;
  
  private String f;
  
  private String g;
  
  private int h;
  
  private HMSPackageManager(Context paramContext) {
    this.d = paramContext;
    this.e = new PackageManagerHelper(paramContext);
  }
  
  private void a() {
    synchronized (c) {
      Pair<String, String> pair = b();
      if (pair == null) {
        HMSLog.e("HMSPackageManager", "Failed to find HMS apk");
        this.f = null;
        this.g = null;
        this.h = 0;
        return;
      } 
      this.f = (String)pair.first;
      this.g = (String)pair.second;
      this.h = this.e.getPackageVersionCode(getHMSPackageName());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Succeed to find HMS apk: ");
      stringBuilder.append(this.f);
      stringBuilder.append(" version: ");
      stringBuilder.append(this.h);
      HMSLog.i("HMSPackageManager", stringBuilder.toString());
      return;
    } 
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString3)) {
      HMSLog.e("HMSPackageManager", "args is invalid");
      return false;
    } 
    List<X509Certificate> list = a.b(paramString3);
    if (list.size() == 0) {
      HMSLog.e("HMSPackageManager", "certChain is empty");
      return false;
    } 
    if (!a.a(a.a(this.d), list)) {
      HMSLog.e("HMSPackageManager", "failed to verify cert chain");
      return false;
    } 
    X509Certificate x509Certificate = list.get(list.size() - 1);
    if (!a.a(x509Certificate, "Huawei CBG HMS")) {
      HMSLog.e("HMSPackageManager", "CN is invalid");
      return false;
    } 
    if (!a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
      HMSLog.e("HMSPackageManager", "OU is invalid");
      return false;
    } 
    if (!a.b(x509Certificate, paramString1, paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("signature is invalid: ");
      stringBuilder.append(paramString1);
      HMSLog.e("HMSPackageManager", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private Pair<String, String> b() {
    List list = this.d.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
    if (list.size() == 0)
      return null; 
    for (ResolveInfo resolveInfo : list) {
      StringBuilder stringBuilder1;
      String str1 = resolveInfo.serviceInfo.applicationInfo.packageName;
      Bundle bundle = resolveInfo.serviceInfo.metaData;
      if (bundle == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("skip package ");
        stringBuilder1.append(str1);
        stringBuilder1.append(" for metadata is null");
        HMSLog.e("HMSPackageManager", stringBuilder1.toString());
        continue;
      } 
      if (!stringBuilder1.containsKey("hms_app_signer")) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("skip package ");
        stringBuilder1.append(str1);
        stringBuilder1.append(" for no signer");
        HMSLog.e("HMSPackageManager", stringBuilder1.toString());
        continue;
      } 
      if (!stringBuilder1.containsKey("hms_app_cert_chain")) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("skip package ");
        stringBuilder1.append(str1);
        stringBuilder1.append(" for no cert chain");
        HMSLog.e("HMSPackageManager", stringBuilder1.toString());
        continue;
      } 
      String str2 = this.e.getPackageSignature(str1);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append("&");
      stringBuilder2.append(str2);
      if (!a(stringBuilder2.toString(), stringBuilder1.getString("hms_app_signer"), stringBuilder1.getString("hms_app_cert_chain"))) {
        HMSLog.e("HMSPackageManager", "checkSinger failed");
        continue;
      } 
      return new Pair(str1, str2);
    } 
    return null;
  }
  
  private boolean c() {
    PackageManager packageManager = this.d.getPackageManager();
    if (packageManager == null) {
      HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
      return true;
    } 
    try {
      ApplicationInfo applicationInfo = (packageManager.getPackageInfo(getHMSPackageName(), 128)).applicationInfo;
      if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
        HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
        return false;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
    } 
    return true;
  }
  
  public static HMSPackageManager getInstance(Context paramContext) {
    synchronized (b) {
      if (a == null) {
        if (paramContext.getApplicationContext() != null) {
          a = new HMSPackageManager(paramContext.getApplicationContext());
        } else {
          a = new HMSPackageManager(paramContext);
        } 
        a.a();
      } 
      return a;
    } 
  }
  
  public String getHMSFingerprint() {
    String str2 = this.g;
    String str1 = str2;
    if (str2 == null)
      str1 = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05"; 
    return str1;
  }
  
  public String getHMSPackageName() {
    refresh();
    String str = this.f;
    if (str != null) {
      PackageManagerHelper.PackageStates packageStates1 = this.e.getPackageStates(str);
      if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates1)) {
        HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
        a();
      } 
      String str1 = this.f;
      if (str1 != null)
        return str1; 
    } 
    PackageManagerHelper.PackageStates packageStates = this.e.getPackageStates("com.huawei.hwid");
    return (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates) && this.e.getPackageSignature("com.huawei.hwid").equalsIgnoreCase("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05")) ? "com.huawei.hwid" : "com.huawei.hms";
  }
  
  public PackageManagerHelper.PackageStates getHMSPackageStates() {
    if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
      a();
      return this.e.getPackageStates(this.f);
    } 
    PackageManagerHelper.PackageStates packageStates2 = this.e.getPackageStates(this.f);
    PackageManagerHelper.PackageStates packageStates1 = packageStates2;
    if (packageStates2 == PackageManagerHelper.PackageStates.ENABLED) {
      packageStates1 = packageStates2;
      if (!this.g.equals(this.e.getPackageSignature(this.f)))
        packageStates1 = PackageManagerHelper.PackageStates.NOT_INSTALLED; 
    } 
    return packageStates1;
  }
  
  public int getHmsVersionCode() {
    return this.e.getPackageVersionCode(getHMSPackageName());
  }
  
  public boolean hmsVerHigherThan(int paramInt) {
    int i = this.h;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i < paramInt) {
      bool1 = bool2;
      if (c()) {
        this.h = this.e.getPackageVersionCode(getHMSPackageName());
        if (this.h >= paramInt)
          return true; 
        bool1 = false;
      } 
    } 
    return bool1;
  }
  
  public boolean isApkUpdateNecessary(int paramInt) {
    int i = getHmsVersionCode();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("current versionCode:");
    stringBuilder.append(i);
    stringBuilder.append(", minimum version requirements: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HMSPackageManager", stringBuilder.toString());
    return (c() && i < paramInt);
  }
  
  public void refresh() {
    if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g))
      a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\HMSPackageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
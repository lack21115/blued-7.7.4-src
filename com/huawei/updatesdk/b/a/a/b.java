package com.huawei.updatesdk.b.a.a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.b.b.a;
import java.util.HashMap;
import java.util.Map;

public class b {
  private static b b;
  
  private final Map<String, a> a = new HashMap<String, a>();
  
  public static b a() {
    // Byte code:
    //   0: ldc com/huawei/updatesdk/b/a/a/b
    //   2: monitorenter
    //   3: getstatic com/huawei/updatesdk/b/a/a/b.b : Lcom/huawei/updatesdk/b/a/a/b;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/updatesdk/b/a/a/b
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/updatesdk/b/a/a/b.b : Lcom/huawei/updatesdk/b/a/a/b;
    //   19: getstatic com/huawei/updatesdk/b/a/a/b.b : Lcom/huawei/updatesdk/b/a/a/b;
    //   22: astore_0
    //   23: ldc com/huawei/updatesdk/b/a/a/b
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/huawei/updatesdk/b/a/a/b
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public String a(PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null || paramPackageInfo.packageName == null || TextUtils.isEmpty(paramPackageInfo.applicationInfo.sourceDir))
      return null; 
    a a1 = this.a.get(paramPackageInfo.packageName);
    if (a1 != null && a1.b() == paramPackageInfo.lastUpdateTime && a1.c() == paramPackageInfo.versionCode)
      return a1.a(); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramPackageInfo.lastUpdateTime);
    stringBuilder1.append(paramPackageInfo.versionCode);
    stringBuilder1.append(paramPackageInfo.packageName);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("packagekey");
    stringBuilder2.append(paramPackageInfo.packageName);
    String str3 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("fileshakey");
    stringBuilder2.append(paramPackageInfo.packageName);
    String str2 = stringBuilder2.toString();
    int i = TextUtils.equals(stringBuilder1.toString(), a.c().c(str3)) ^ true;
    if (i != 0)
      a.c().a(str3, stringBuilder1.toString()); 
    String str1 = a.c().c(str2);
    if (TextUtils.isEmpty(str1) || i != 0) {
      str1 = d.a(paramPackageInfo.applicationInfo.sourceDir, "SHA-256");
      a.c().a(str2, str1);
    } 
    a a2 = new a();
    a2.a(str1);
    a2.a(paramPackageInfo.lastUpdateTime);
    a2.a(paramPackageInfo.versionCode);
    this.a.put(paramPackageInfo.packageName, a2);
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
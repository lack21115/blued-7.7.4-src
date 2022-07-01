package com.huawei.updatesdk.b.a.b;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.a.a.c.g;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b {
  private static b b;
  
  private final Map<String, a> a = new HashMap<String, a>();
  
  public static b a() {
    // Byte code:
    //   0: ldc com/huawei/updatesdk/b/a/b/b
    //   2: monitorenter
    //   3: getstatic com/huawei/updatesdk/b/a/b/b.b : Lcom/huawei/updatesdk/b/a/b/b;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/updatesdk/b/a/b/b
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/updatesdk/b/a/b/b.b : Lcom/huawei/updatesdk/b/a/b/b;
    //   19: getstatic com/huawei/updatesdk/b/a/b/b.b : Lcom/huawei/updatesdk/b/a/b/b;
    //   22: astore_0
    //   23: ldc com/huawei/updatesdk/b/a/b/b
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/huawei/updatesdk/b/a/b/b
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private static void a(a parama) {
    (a()).a.put(parama.c(), parama);
  }
  
  private static ArrayList<String> b(PackageInfo paramPackageInfo) {
    a a1 = new a();
    a1.a(paramPackageInfo.packageName);
    File file = new File(paramPackageInfo.applicationInfo.sourceDir);
    if (!file.exists())
      return null; 
    a1.a(file.lastModified());
    c.a a = c.a(file);
    ArrayMap<String, ArraySet<PublicKey>> arrayMap = a.a;
    if (arrayMap != null && !arrayMap.isEmpty()) {
      ArraySet<String> arraySet = a.b;
      if (arraySet != null && !arraySet.isEmpty()) {
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry entry : a.a.entrySet()) {
          String str = (String)entry.getKey();
          if (!a.b.contains(str))
            continue; 
          Iterator<PublicKey> iterator = ((ArraySet)entry.getValue()).iterator();
          while (iterator.hasNext())
            arrayList.add(g.a(((PublicKey)iterator.next()).getEncoded())); 
        } 
        a.a a2 = new a.a();
        a2.a(arrayList);
        a1.a(a2);
        a(a1);
        return arrayList;
      } 
    } 
    a(a1);
    return null;
  }
  
  public List<String> a(PackageInfo paramPackageInfo) {
    if (Build.VERSION.SDK_INT >= 21 && paramPackageInfo != null) {
      String str = paramPackageInfo.applicationInfo.sourceDir;
      if (str == null)
        return null; 
      long l = (new File(str)).lastModified();
      a a = (a()).a.get(paramPackageInfo.packageName);
      return (a != null && a.b() == l) ? ((a.a() == null) ? null : a.a().a()) : b(paramPackageInfo);
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
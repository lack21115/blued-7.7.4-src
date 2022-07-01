package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.a.b.d.c.c;
import com.huawei.updatesdk.a.b.d.c.d;
import com.huawei.updatesdk.b.b.c;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f {
  private static String a = "com.huawei.appmarket";
  
  private static b b;
  
  public static void a(b paramb) {
    b = paramb;
  }
  
  public static void a(String paramString) {
    boolean bool;
    a = paramString;
    com.huawei.updatesdk.service.appmgr.bean.a a = com.huawei.updatesdk.service.appmgr.bean.a.n(a);
    if (h.g().e()) {
      bool = true;
    } else {
      bool = false;
    } 
    a.a(bool);
    com.huawei.updatesdk.b.e.a.b.a((c)a, new b(null));
  }
  
  private static ApkUpgradeInfo b(List<ApkUpgradeInfo> paramList) {
    ApkUpgradeInfo apkUpgradeInfo;
    List list = null;
    if (paramList == null)
      return null; 
    Iterator<ApkUpgradeInfo> iterator = paramList.iterator();
    while (true) {
      paramList = list;
      if (iterator.hasNext()) {
        apkUpgradeInfo = iterator.next();
        String str = a;
        if (str != null && str.equals(apkUpgradeInfo.getPackage_()))
          break; 
        continue;
      } 
      break;
    } 
    return apkUpgradeInfo;
  }
  
  static class b implements com.huawei.updatesdk.a.b.d.c.a {
    private b() {}
    
    public void a(c param1c, d param1d) {}
    
    public void b(c param1c, d param1d) {
      if (param1d instanceof com.huawei.updatesdk.service.appmgr.bean.b) {
        com.huawei.updatesdk.service.appmgr.bean.b b1 = (com.huawei.updatesdk.service.appmgr.bean.b)param1d;
        if (param1d.d() != 0 || param1d.e() != 0) {
          if (f.a() != null) {
            f.a().b(param1d.d());
            return;
          } 
          return;
        } 
        ArrayList arrayList = b1.list_;
        if (arrayList == null || arrayList.size() == 0) {
          List list = b1.notRcmList_;
          if (list == null || list.size() == 0) {
            if (f.a() != null)
              f.a().a(param1d.d()); 
            return;
          } 
        } 
        ApkUpgradeInfo apkUpgradeInfo = f.a(b1.list_);
        if (f.a() != null) {
          f.a().a(apkUpgradeInfo);
          return;
        } 
      } else if (f.a() != null) {
        f.a().a(param1d.d());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.cd;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.kl.bc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ab {
  private List<de> ab;
  
  private String bc;
  
  private String cd;
  
  private String de;
  
  public ab(List<de> paramList, String paramString1, String paramString2, String paramString3) {
    this.ab = paramList;
    this.bc = paramString1;
    this.cd = paramString2;
    this.de = paramString3;
  }
  
  private void ab(List<de> paramList, String paramString1, String paramString2) {
    if (paramList.isEmpty())
      return; 
    int j = paramList.size() / 500;
    int i;
    for (i = 0; i < j + 1; i++) {
      int k = i * 500;
      List<de> list = paramList.subList(k, Math.min(paramList.size(), k + 500));
      String str = UUID.randomUUID().toString().replace("-", "");
      long l1 = System.currentTimeMillis();
      long l2 = cd.ab(paramString2, paramString1);
      ArrayList<de> arrayList = new ArrayList();
      for (de de : list) {
        if (!bc.ab(de.bc(), l1, l2 * 86400000L))
          arrayList.add(de); 
      } 
      if (arrayList.size() > 0) {
        (new bc(paramString2, paramString1, this.de, arrayList, str)).ab();
      } else {
        com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "No data to report handler");
      } 
    } 
  }
  
  public void ab() {
    if ("_default_config_tag".equals(this.cd)) {
      ArrayList<de> arrayList1 = new ArrayList();
      ArrayList<de> arrayList2 = new ArrayList();
      ArrayList<de> arrayList3 = new ArrayList();
      ArrayList<de> arrayList4 = new ArrayList();
      for (de de : this.ab) {
        String str = de.cd();
        if (TextUtils.isEmpty(str) || "oper".equals(str)) {
          arrayList4.add(de);
          continue;
        } 
        if ("maint".equals(str)) {
          arrayList1.add(de);
          continue;
        } 
        if ("preins".equals(str)) {
          arrayList2.add(de);
          continue;
        } 
        if ("diffprivacy".equals(str))
          arrayList3.add(de); 
      } 
      ab(arrayList4, "oper", "_default_config_tag");
      ab(arrayList1, "maint", "_default_config_tag");
      ab(arrayList2, "preins", "_default_config_tag");
      ab(arrayList3, "diffprivacy", "_default_config_tag");
      return;
    } 
    ab(this.ab, this.cd, this.bc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\de\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
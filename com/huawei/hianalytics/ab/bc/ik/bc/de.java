package com.huawei.hianalytics.ab.bc.ik.bc;

import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.ij.ab;
import com.huawei.hianalytics.ab.bc.ik.cd.ab;
import com.huawei.hianalytics.ab.bc.kl.bc;
import com.huawei.hianalytics.ab.bc.kl.ef;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class de implements ab {
  private String ab;
  
  private String bc;
  
  private String cd;
  
  private List<com.huawei.hianalytics.ab.bc.cd.bc.de> de;
  
  public de(List<com.huawei.hianalytics.ab.bc.cd.bc.de> paramList, String paramString1, String paramString2, String paramString3) {
    this.ab = paramString1;
    this.bc = paramString2;
    this.cd = paramString3;
    this.de = paramList;
  }
  
  private void ab() {
    String str = ef.ab(this.ab, this.cd, this.bc);
    ab.ab(bc.fg(), "backup_event", new String[] { str });
  }
  
  public void run() {
    List<com.huawei.hianalytics.ab.bc.cd.bc.de> list = this.de;
    if (list == null || list.size() == 0) {
      ab.de("hmsSdk", "failed events is empty");
      return;
    } 
    int i = bc.hi();
    if (bc.ab(bc.fg(), "cached_v2_1", i * 1048576)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The cacheFile is full,Can not writing data! reqID:");
      stringBuilder.append(this.bc);
      ab.ef("hmsSdk", stringBuilder.toString());
      return;
    } 
    String str = ef.ab(this.ab, this.cd);
    List<? extends com.huawei.hianalytics.ab.bc.cd.bc.de> list1 = (List)com.huawei.hianalytics.ab.bc.de.de.bc(bc.fg(), "cached_v2_1", str).get(str);
    if (list1 != null && list1.size() != 0)
      this.de.addAll(list1); 
    JSONArray jSONArray = new JSONArray();
    Iterator<com.huawei.hianalytics.ab.bc.cd.bc.de> iterator = this.de.iterator();
    while (true) {
      if (iterator.hasNext()) {
        com.huawei.hianalytics.ab.bc.cd.bc.de de1 = iterator.next();
        try {
          jSONArray.put(de1.de());
        } catch (JSONException jSONException) {
          ab.ef("hmsSdk", "event to json error");
        } 
        continue;
      } 
      String str1 = jSONArray.toString();
      i = bc.ef();
      if (str1.length() > i * 1048576) {
        ab.ef("hmsSdk", "this failed data is too long,can not writing it");
        this.de = null;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("data send failed, write to cache file...reqID:");
      stringBuilder.append(this.bc);
      ab.de("hmsSdk", stringBuilder.toString());
      ab.bc(bc.fg(), "cached_v2_1", str, str1);
      ab();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ik\bc\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
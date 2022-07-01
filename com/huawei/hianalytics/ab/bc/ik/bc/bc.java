package com.huawei.hianalytics.ab.bc.ik.bc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.ab;
import com.huawei.hianalytics.ab.ab.cd;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.hi.ab;
import com.huawei.hianalytics.ab.bc.ij.ab;
import com.huawei.hianalytics.ab.bc.ik.ab.ab;
import com.huawei.hianalytics.ab.bc.ik.cd.ab;
import com.huawei.hianalytics.ab.bc.kl.ef;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bc implements ab {
  private Context ab = com.huawei.hianalytics.ab.ab.bc.fg();
  
  private String bc;
  
  private JSONObject cd;
  
  private String de;
  
  private String ef;
  
  private String fg;
  
  private String gh;
  
  private Boolean hi;
  
  public bc(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, long paramLong) {
    this.bc = paramString1;
    this.cd = paramJSONObject;
    this.de = paramString2;
    this.ef = paramString3;
    this.fg = String.valueOf(paramLong);
    if (ab.ij(paramString2, "oper")) {
      com.huawei.hianalytics.ab.bc.hi.bc bc1 = ab.ab().ab(paramString2, paramLong);
      this.gh = bc1.bc();
      this.hi = Boolean.valueOf(bc1.cd());
    } 
  }
  
  public void run() {
    String str;
    ab.cd("hmsSdk", "Begin to run EventRecordTask...");
    int i = com.huawei.hianalytics.ab.ab.bc.ef();
    int j = cd.hi(this.de, this.ef);
    if (com.huawei.hianalytics.ab.bc.kl.bc.ab(this.ab, "stat_v2_1", i * 1048576)) {
      ab.cd("hmsSdk", "stat sp file reach max limited size, discard new event");
      ab.ab().ab("", "alltype");
      return;
    } 
    de de = new de();
    de.bc(this.bc);
    de.ab(this.cd.toString());
    de.de(this.ef);
    de.cd(this.fg);
    de.fg(this.gh);
    Boolean bool = this.hi;
    if (bool == null) {
      bool = null;
    } else {
      str = String.valueOf(bool);
    } 
    de.ef(str);
    try {
      JSONArray jSONArray;
      JSONObject jSONObject = de.de();
      String str1 = ef.ab(this.de, this.ef);
      str = ab.ab(this.ab, "stat_v2_1", str1, "");
      try {
        if (!TextUtils.isEmpty(str)) {
          jSONArray = new JSONArray(str);
        } else {
          jSONArray = new JSONArray();
        } 
      } catch (JSONException jSONException) {
        ab.de("hmsSdk", "Cached data corrupted: stat_v2_1");
        jSONArray = new JSONArray();
      } 
      jSONArray.put(jSONObject);
      ab.bc(this.ab, "stat_v2_1", str1, jSONArray.toString());
      if (jSONArray.toString().length() > j * 1024)
        ab.ab().ab(this.de, this.ef); 
      return;
    } catch (JSONException jSONException) {
      ab.ef("hmsSdk", "eventRecord toJson error! The record failed.");
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ik\bc\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
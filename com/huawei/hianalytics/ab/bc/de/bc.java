package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.cd;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.cd.bc.ef;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.ij.ab;
import com.huawei.hianalytics.ab.bc.ik.bc.ab;
import com.huawei.hianalytics.ab.bc.ik.bc.de;
import com.huawei.hianalytics.ab.bc.ik.cd.ab;
import com.huawei.hianalytics.ab.bc.kl.de;
import com.huawei.hianalytics.ab.bc.kl.ef;
import com.huawei.hianalytics.ab.de.ab;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bc {
  private String ab;
  
  private String bc;
  
  private String cd;
  
  private List<de> de;
  
  private String ef;
  
  public bc(String paramString1, String paramString2, String paramString3, List<de> paramList, String paramString4) {
    this.ab = paramString1;
    this.bc = paramString2;
    this.cd = paramString3;
    this.de = paramList;
    this.ef = paramString4;
  }
  
  private String ab(String paramString1, String paramString2) {
    String str = cd.cd(paramString1, paramString2);
    if (TextUtils.isEmpty(str)) {
      ab.ab("hmsSdk", "No report address,TAG : %s,TYPE: %s ", new Object[] { paramString1, paramString2 });
      return "";
    } 
    if ("oper".equals(paramString2)) {
      paramString1 = "{url}/common/hmshioperqrt";
      return paramString1.replace("{url}", str);
    } 
    if ("maint".equals(paramString2)) {
      paramString1 = "{url}/common/hmshimaintqrt";
      return paramString1.replace("{url}", str);
    } 
    if ("diffprivacy".equals(paramString2)) {
      paramString1 = "{url}/common/common2";
      return paramString1.replace("{url}", str);
    } 
    return "";
  }
  
  private byte[] ab(ef paramef) {
    String str;
    try {
      JSONObject jSONObject = paramef.ab();
      if (jSONObject == null) {
        ab.ef("hmsSdk", "uploadEvents is null");
        return new byte[0];
      } 
      return de.ab(jSONObject.toString().getBytes("UTF-8"));
    } catch (JSONException jSONException) {
      str = "uploadEvents to json error";
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str = "sendData(): getBytes - Unsupported coding format!!";
    } 
    ab.ef("hmsSdk", str);
    return new byte[0];
  }
  
  private void bc() {
    if (com.huawei.hianalytics.ab.bc.kl.bc.ab(com.huawei.hianalytics.ab.ab.bc.fg(), "backup_event", 5242880)) {
      ab.de("hmsSdk", "backup file reach max limited size, discard new event ");
      return;
    } 
    JSONArray jSONArray = cd();
    String str = ef.ab(this.ab, this.bc, this.ef);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Update data cached into backup,spKey: ");
    stringBuilder.append(str);
    ab.cd("hmsSdk", stringBuilder.toString());
    ab.bc(com.huawei.hianalytics.ab.ab.bc.fg(), "backup_event", str, jSONArray.toString());
  }
  
  private JSONArray cd() {
    JSONArray jSONArray = new JSONArray();
    Iterator<de> iterator = this.de.iterator();
    while (true) {
      if (iterator.hasNext()) {
        de de = iterator.next();
        try {
          JSONObject jSONObject = de.de();
          jSONArray.put(jSONObject);
        } catch (JSONException jSONException) {
          ab.cd("hmsSdk", "handleEvents: json error,Abandon this data");
        } 
        continue;
      } 
      return jSONArray;
    } 
  }
  
  private ef de() {
    return ab.ab(this.de, this.ab, this.bc, this.ef, this.cd);
  }
  
  public void ab() {
    de de;
    String str = ab(this.ab, this.bc);
    if (TextUtils.isEmpty(str) && !"preins".equals(this.bc)) {
      str = "collectUrl is empty";
    } else {
      if (!"_hms_config_tag".equals(this.ab) && !"_openness_config_tag".equals(this.ab))
        bc(); 
      ef ef = de();
      if (ef != null) {
        byte[] arrayOfByte = ab(ef);
        if (arrayOfByte.length == 0) {
          str = "request body is empty";
        } else {
          ab ab = new ab(arrayOfByte, str, this.ab, this.bc, this.ef, this.de);
          com.huawei.hianalytics.ab.bc.ik.cd.bc bc1 = com.huawei.hianalytics.ab.bc.ik.cd.bc.ab();
          bc1.ab((ab)ab);
        } 
      } else {
        de = new de(this.de, this.ab, this.ef, this.bc);
        com.huawei.hianalytics.ab.bc.ik.cd.bc bc1 = com.huawei.hianalytics.ab.bc.ik.cd.bc.bc();
        bc1.ab((ab)de);
      } 
    } 
    ab.ef("hmsSdk", (String)de);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\de\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.huawei.hianalytics.ab.bc.cd.bc;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.kl.de;
import com.huawei.hianalytics.ab.ef.ab;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ef implements fg {
  private List<de> ab;
  
  private bc bc;
  
  private cd cd;
  
  private fg de;
  
  private String ef = "";
  
  private String fg;
  
  public ef(String paramString) {
    this.fg = paramString;
  }
  
  public JSONObject ab() {
    List<de> list = this.ab;
    if (list == null || list.size() == 0) {
      String str1 = "Not have actionEvent to send";
      ab.ef("hmsSdk", str1);
      return null;
    } 
    if (this.bc == null || this.cd == null || this.de == null) {
      String str1 = "model in wrong format";
      ab.ef("hmsSdk", str1);
      return null;
    } 
    JSONObject jSONObject1 = new JSONObject();
    jSONObject1.put("header", this.bc.ab());
    JSONObject jSONObject2 = new JSONObject();
    JSONObject jSONObject3 = this.de.ab();
    jSONObject3.put("properties", this.cd.ab());
    try {
      jSONObject3.put("events_global_properties", new JSONObject(this.ef));
    } catch (JSONException jSONException) {
      jSONObject3.put("events_global_properties", this.ef);
    } 
    jSONObject2.put("events_common", jSONObject3);
    JSONArray jSONArray = new JSONArray();
    Iterator<de> iterator = this.ab.iterator();
    while (iterator.hasNext()) {
      JSONObject jSONObject = ((de)iterator.next()).ab();
      if (jSONObject != null) {
        jSONArray.put(jSONObject);
        continue;
      } 
      ab.ef("hmsSdk", "custom event is empty,delete this event");
    } 
    jSONObject2.put("events", jSONArray);
    String str = jSONObject2.toString();
    try {
      str = HexUtil.a(AesCbc.a(de.ab(str.getBytes("UTF-8")), HexUtil.a(this.fg)));
      if (TextUtils.isEmpty(str)) {
        ab.ef("hmsSdk", "eventInfo encrypt failed,report over!");
        return null;
      } 
      jSONObject1.put("event", str);
      return jSONObject1;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      String str1 = "getBitZip(): Unsupported coding : utf-8";
    } 
  }
  
  public void ab(bc parambc) {
    this.bc = parambc;
  }
  
  public void ab(cd paramcd) {
    this.cd = paramcd;
  }
  
  public void ab(ab paramab) {
    this.de = (fg)paramab;
  }
  
  public void ab(String paramString) {
    if (paramString != null)
      this.ef = paramString; 
  }
  
  public void ab(List<de> paramList) {
    this.ab = paramList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\cd\bc\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
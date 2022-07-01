package com.huawei.hianalytics.ab.ef;

import com.huawei.hianalytics.ab.bc.cd.bc.bc;
import org.json.JSONObject;

public class bc extends bc {
  private String gh = "";
  
  public JSONObject ab() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("protocol_version", "1");
    jSONObject.put("compress_mode", "1");
    jSONObject.put("serviceid", this.de);
    jSONObject.put("appid", this.ab);
    jSONObject.put("hmac", this.gh);
    jSONObject.put("chifer", this.fg);
    jSONObject.put("timestamp", this.bc);
    jSONObject.put("servicetag", this.cd);
    jSONObject.put("requestid", this.ef);
    return jSONObject;
  }
  
  public void gh(String paramString) {
    this.gh = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\ef\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
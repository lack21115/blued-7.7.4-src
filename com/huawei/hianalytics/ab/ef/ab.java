package com.huawei.hianalytics.ab.ef;

import com.huawei.hianalytics.ab.bc.cd.bc.ab;
import org.json.JSONObject;

public class ab extends ab {
  private String bc = "";
  
  private String cd = "";
  
  private String de = "";
  
  private String ef = "";
  
  protected String fg = "";
  
  private String gh;
  
  public JSONObject ab() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("androidid", this.ab);
    jSONObject.put("oaid", this.gh);
    jSONObject.put("uuid", this.fg);
    jSONObject.put("upid", this.ef);
    jSONObject.put("imei", this.bc);
    jSONObject.put("sn", this.cd);
    jSONObject.put("udid", this.de);
    return jSONObject;
  }
  
  public void bc(String paramString) {
    this.bc = paramString;
  }
  
  public void cd(String paramString) {
    this.gh = paramString;
  }
  
  public void de(String paramString) {
    this.cd = paramString;
  }
  
  public void ef(String paramString) {
    this.de = paramString;
  }
  
  public void fg(String paramString) {
    this.ef = paramString;
  }
  
  public void gh(String paramString) {
    this.fg = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\ef\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
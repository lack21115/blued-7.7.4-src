package com.huawei.hianalytics.ab.ef;

import android.os.Build;
import com.huawei.hianalytics.ab.bc.cd.bc.cd;
import org.json.JSONObject;

public class cd extends cd {
  String fg;
  
  String gh;
  
  private String hi;
  
  public JSONObject ab() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("_rom_ver", this.hi);
    jSONObject.put("_emui_ver", this.ab);
    jSONObject.put("_model", Build.MODEL);
    jSONObject.put("_mcc", this.fg);
    jSONObject.put("_mnc", this.gh);
    jSONObject.put("_package_name", this.bc);
    jSONObject.put("_app_ver", this.cd);
    jSONObject.put("_lib_ver", "2.2.0.308");
    jSONObject.put("_channel", this.de);
    jSONObject.put("_lib_name", "hianalytics");
    jSONObject.put("_oaid_tracking_flag", this.ef);
    return jSONObject;
  }
  
  public void fg(String paramString) {
    this.fg = paramString;
  }
  
  public void gh(String paramString) {
    this.gh = paramString;
  }
  
  public void hi(String paramString) {
    this.hi = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\ef\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
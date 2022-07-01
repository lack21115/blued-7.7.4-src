package com.qiniu.android.storage;

import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.utils.UrlSafeBase64;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpToken {
  public static UpToken NULL = new UpToken("", "", "");
  
  public final String accessKey;
  
  private String returnUrl = null;
  
  public final String token;
  
  private UpToken(String paramString1, String paramString2, String paramString3) {
    this.returnUrl = paramString1;
    this.token = paramString2;
    this.accessKey = paramString3;
  }
  
  public static boolean isInvalid(UpToken paramUpToken) {
    return (paramUpToken == null || paramUpToken == NULL);
  }
  
  public static UpToken parse(String paramString) {
    try {
      String[] arrayOfString = paramString.split(":");
      if (arrayOfString.length != 3)
        return NULL; 
      byte[] arrayOfByte = UrlSafeBase64.decode(arrayOfString[2]);
      try {
        JSONObject jSONObject = new JSONObject(new String(arrayOfByte));
        return jSONObject.optString("scope").equals("") ? NULL : ((jSONObject.optInt("deadline") == 0) ? NULL : new UpToken(jSONObject.optString("returnUrl"), paramString, arrayOfString[0]));
      } catch (JSONException jSONException) {}
      return NULL;
    } catch (Exception exception) {
      return NULL;
    } 
  }
  
  public static void setCurrent_region_id(LogHandler paramLogHandler, String paramString) {
    if (paramString != null) {
      String str;
      if (paramString == "")
        return; 
      String[] arrayOfString = paramString.split("//");
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      } else {
        str = str[0];
      } 
      if (Arrays.<String>asList(FixedZone.arrayzone0).contains(str)) {
        if (paramLogHandler != null) {
          paramLogHandler.send("current_region_id", "z0");
          return;
        } 
      } else if (Arrays.<String>asList(FixedZone.arrayzone1).contains(str)) {
        if (paramLogHandler != null) {
          paramLogHandler.send("current_region_id", "z1");
          return;
        } 
      } else if (Arrays.<String>asList(FixedZone.arrayzone2).contains(str)) {
        if (paramLogHandler != null) {
          paramLogHandler.send("current_region_id", "z2");
          return;
        } 
      } else if (Arrays.<String>asList(FixedZone.arrayzoneNa0).contains(str)) {
        if (paramLogHandler != null) {
          paramLogHandler.send("current_region_id", "na0");
          return;
        } 
      } else if (Arrays.<String>asList(FixedZone.arrayZoneAs0).contains(str) && paramLogHandler != null) {
        paramLogHandler.send("current_region_id", "as0");
      } 
    } 
  }
  
  public boolean hasReturnUrl() {
    return this.returnUrl.equals("") ^ true;
  }
  
  public String toString() {
    return this.token;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\UpToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
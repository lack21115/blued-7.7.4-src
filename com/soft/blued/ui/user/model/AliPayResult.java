package com.soft.blued.ui.user.model;

import android.text.TextUtils;
import java.util.Map;

public class AliPayResult {
  private String memo;
  
  private String result;
  
  private String resultStatus;
  
  public AliPayResult(Map<String, String> paramMap) {
    if (paramMap == null)
      return; 
    for (String str : paramMap.keySet()) {
      if (TextUtils.equals(str, "resultStatus")) {
        this.resultStatus = paramMap.get(str);
        continue;
      } 
      if (TextUtils.equals(str, "result")) {
        this.result = paramMap.get(str);
        continue;
      } 
      if (TextUtils.equals(str, "memo"))
        this.memo = paramMap.get(str); 
    } 
  }
  
  public String getMemo() {
    return this.memo;
  }
  
  public String getResult() {
    return this.result;
  }
  
  public String getResultStatus() {
    return this.resultStatus;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resultStatus={");
    stringBuilder.append(this.resultStatus);
    stringBuilder.append("};memo={");
    stringBuilder.append(this.memo);
    stringBuilder.append("};result={");
    stringBuilder.append(this.result);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\AliPayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
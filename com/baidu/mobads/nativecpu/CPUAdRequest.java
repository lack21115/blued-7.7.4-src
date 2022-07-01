package com.baidu.mobads.nativecpu;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class CPUAdRequest {
  private Map<String, Object> a = new HashMap<String, Object>();
  
  private CPUAdRequest(Builder paramBuilder) {
    if (paramBuilder != null && Builder.a(paramBuilder) != null)
      this.a.putAll(Builder.a(paramBuilder)); 
  }
  
  public Map<String, Object> getExtras() {
    return this.a;
  }
  
  public static class Builder {
    private HashMap<String, Object> a = new HashMap<String, Object>();
    
    public Builder addExtra(String param1String1, String param1String2) {
      if (!TextUtils.isEmpty(param1String1))
        this.a.put(param1String1, param1String2); 
      return this;
    }
    
    public CPUAdRequest build() {
      return new CPUAdRequest(this, null);
    }
    
    public Builder setAccessType(int param1Int) {
      this.a.put("accessType", Integer.valueOf(param1Int));
      return this;
    }
    
    public Builder setDownloadAppConfirmPolicy(int param1Int) {
      this.a.put("downloadAppConfirmPolicy", Integer.valueOf(param1Int));
      return this;
    }
    
    public Builder setListScene(int param1Int) {
      this.a.put("listScene", Integer.valueOf(param1Int));
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\CPUAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
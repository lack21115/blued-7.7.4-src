package com.baidu.mobad.feeds;

import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;
import java.util.Map;

public final class RequestParameters implements IXAdFeedsRequestParameters {
  public static final int ADS_TYPE_DOWNLOAD = 2;
  
  public static final int ADS_TYPE_OPENPAGE = 1;
  
  public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
  
  public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
  
  public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
  
  public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
  
  public static final int MAX_ASSETS_RESERVED = 15;
  
  public static final String TAG = "RequestParameters";
  
  private final String a;
  
  private int b;
  
  private boolean c;
  
  private Map<String, String> d;
  
  private int e = 0;
  
  private int f = 0;
  
  private int g;
  
  protected String mPlacementId;
  
  private RequestParameters(Builder paramBuilder) {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.e = Builder.c(paramBuilder);
    this.f = Builder.d(paramBuilder);
    this.c = Builder.e(paramBuilder);
    this.g = Builder.f(paramBuilder);
    setExtras(Builder.g(paramBuilder));
  }
  
  public int getAPPConfirmPolicy() {
    return this.g;
  }
  
  public String getAdPlacementId() {
    return this.mPlacementId;
  }
  
  public int getAdsType() {
    return this.b;
  }
  
  public Map<String, String> getExtras() {
    return this.d;
  }
  
  public int getHeight() {
    return this.f;
  }
  
  public final String getKeywords() {
    return this.a;
  }
  
  public int getWidth() {
    return this.e;
  }
  
  public boolean isConfirmDownloading() {
    return this.c;
  }
  
  public void setAdsType(int paramInt) {
    this.b = paramInt;
  }
  
  public void setExtras(Map<String, String> paramMap) {
    this.d = paramMap;
  }
  
  public HashMap<String, Object> toHashMap() {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    hashMap1.put("mKeywords", this.a);
    hashMap1.put("adsType", Integer.valueOf(this.b));
    hashMap1.put("confirmDownloading", Boolean.valueOf(this.c));
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    Map<String, String> map = this.d;
    if (map != null)
      for (Map.Entry<String, String> entry : map.entrySet())
        hashMap2.put(entry.getKey(), entry.getValue());  
    hashMap1.put("extras", hashMap2);
    return (HashMap)hashMap1;
  }
  
  public static class Builder {
    private String a;
    
    private Map<String, String> b = new HashMap<String, String>();
    
    private int c = 3;
    
    private boolean d = false;
    
    private int e = 640;
    
    private int f = 480;
    
    private int g = 1;
    
    public final Builder addExtra(String param1String1, String param1String2) {
      if ("page_title".equals(param1String1))
        this.b.put("mpt", String.valueOf(1)); 
      this.b.put(param1String1, param1String2);
      return this;
    }
    
    public final RequestParameters build() {
      return new RequestParameters(this, null);
    }
    
    @Deprecated
    public final Builder confirmDownloading(boolean param1Boolean) {
      if (param1Boolean) {
        downloadAppConfirmPolicy(2);
        return this;
      } 
      downloadAppConfirmPolicy(3);
      return this;
    }
    
    public final Builder downloadAppConfirmPolicy(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public final Builder setHeight(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public final Builder setWidth(int param1Int) {
      this.e = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\RequestParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
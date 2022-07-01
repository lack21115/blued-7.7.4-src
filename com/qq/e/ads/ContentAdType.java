package com.qq.e.ads;

public enum ContentAdType {
  AD, INFORMATION;
  
  public static ContentAdType fromString(String paramString) {
    return "ad".equals(paramString) ? AD : ("information".equals(paramString) ? INFORMATION : null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\ContentAdType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
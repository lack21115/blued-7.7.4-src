package com.qq.e.comm.util;

public enum VideoAdValidity {
  NONE_CACHE,
  OVERDUE,
  SHOWED,
  VALID("有效且可展示的广告");
  
  private String a;
  
  static {
    OVERDUE = new VideoAdValidity("OVERDUE", 1, "过期的广告");
    SHOWED = new VideoAdValidity("SHOWED", 2, "已经展示的广告");
    NONE_CACHE = new VideoAdValidity("NONE_CACHE", 3, "视频未缓存的广告");
    b = new VideoAdValidity[] { VALID, OVERDUE, SHOWED, NONE_CACHE };
  }
  
  VideoAdValidity(String paramString1) {
    this.a = paramString1;
  }
  
  public final String getMessage() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\VideoAdValidity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
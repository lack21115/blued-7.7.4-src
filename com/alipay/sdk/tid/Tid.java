package com.alipay.sdk.tid;

import android.text.TextUtils;

public final class Tid {
  private final String key;
  
  private final String tid;
  
  private final long time;
  
  public Tid(String paramString1, String paramString2, long paramLong) {
    this.tid = paramString1;
    this.key = paramString2;
    this.time = paramLong;
  }
  
  public static boolean isEmpty(Tid paramTid) {
    return (paramTid == null || TextUtils.isEmpty(paramTid.tid));
  }
  
  public String getTid() {
    return this.tid;
  }
  
  public String getTidSeed() {
    return this.key;
  }
  
  public long getTimestamp() {
    return this.time;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\tid\Tid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
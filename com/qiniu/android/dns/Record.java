package com.qiniu.android.dns;

public final class Record {
  public static final int TTL_MIN_SECONDS = 600;
  
  public static final int TYPE_A = 1;
  
  public static final int TYPE_CNAME = 5;
  
  public final long timeStamp;
  
  public final int ttl;
  
  public final int type;
  
  public final String value;
  
  public Record(String paramString, int paramInt1, int paramInt2, long paramLong) {
    this.value = paramString;
    this.type = paramInt1;
    paramInt1 = 600;
    if (paramInt2 < 600)
      paramInt2 = paramInt1; 
    this.ttl = paramInt2;
    this.timeStamp = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (!(paramObject instanceof Record))
        return false; 
      paramObject = paramObject;
      return (this.value.equals(((Record)paramObject).value) && this.type == ((Record)paramObject).type && this.ttl == ((Record)paramObject).ttl && this.timeStamp == ((Record)paramObject).timeStamp);
    } 
    return false;
  }
  
  public boolean isA() {
    return (this.type == 1);
  }
  
  public boolean isCname() {
    return (this.type == 5);
  }
  
  public boolean isExpired() {
    return isExpired(System.currentTimeMillis() / 1000L);
  }
  
  public boolean isExpired(long paramLong) {
    return (this.timeStamp + this.ttl < paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
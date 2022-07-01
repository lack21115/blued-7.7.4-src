package com.ss.android.socialbase.downloader.e;

public class e extends a {
  private final long a;
  
  private final long b;
  
  public e(long paramLong1, long paramLong2) {
    super(1006, String.format("space is not enough required space is : %s but available space is :%s", new Object[] { String.valueOf(paramLong2), String.valueOf(paramLong1) }));
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public long c() {
    return this.a;
  }
  
  public long d() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
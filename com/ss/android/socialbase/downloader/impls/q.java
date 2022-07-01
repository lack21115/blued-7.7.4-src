package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.r;

public class q implements r {
  private final long[] a;
  
  public q(String paramString) {
    this.a = a(paramString);
  }
  
  private long[] a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      int i;
      String[] arrayOfString = paramString.split(",");
      if (arrayOfString.length == 0)
        return null; 
      return arrayOfLong;
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  public long a(int paramInt1, int paramInt2) {
    long[] arrayOfLong = this.a;
    if (arrayOfLong != null && arrayOfLong.length > 0) {
      paramInt2 = paramInt1 - 1;
      paramInt1 = paramInt2;
      if (paramInt2 < 0)
        paramInt1 = 0; 
      arrayOfLong = this.a;
      paramInt2 = paramInt1;
      if (paramInt1 > arrayOfLong.length - 1)
        paramInt2 = arrayOfLong.length - 1; 
      return this.a[paramInt2];
    } 
    return 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
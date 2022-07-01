package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.i;

public class c implements i {
  public int a(long paramLong) {
    return (paramLong < 10485760L) ? 1 : ((paramLong < 52428800L) ? 2 : ((paramLong < 104857600L) ? 3 : 4));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
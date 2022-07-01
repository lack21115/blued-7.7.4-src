package com.blued.android.core.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;

public class StorageUtils {
  public static long a() {
    if (b()) {
      StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      return a(statFs) * b(statFs);
    } 
    return -1L;
  }
  
  private static long a(StatFs paramStatFs) {
    return (Build.VERSION.SDK_INT < 18) ? paramStatFs.getBlockSize() : paramStatFs.getBlockSizeLong();
  }
  
  private static long b(StatFs paramStatFs) {
    return (Build.VERSION.SDK_INT < 18) ? paramStatFs.getAvailableBlocks() : paramStatFs.getAvailableBlocksLong();
  }
  
  public static boolean b() {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static long c() {
    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
    return a(statFs) * b(statFs);
  }
  
  public static interface OnDiskFullListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\StorageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
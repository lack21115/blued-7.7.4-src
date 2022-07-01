package com.baidu.mobads.interfaces.utils;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

public interface IXAdIOUtils {
  public static final int BUFFER_SIZE = 1024;
  
  public static final String DEFAULT_CACHE_PATH = "/bddownload/";
  
  public static final String DEFAULT_SD_CARD_PATH = "/mnt/sdcard";
  
  void copyFileFromAssetsTo(Context paramContext, String paramString1, String paramString2);
  
  void copyFileInputStream(InputStream paramInputStream, String paramString);
  
  File deleteFileRecursive(File paramFile);
  
  File deleteFileRecursive(String paramString);
  
  File getExternalFilesDir(Context paramContext);
  
  String getStoreagePath(Context paramContext);
  
  @Deprecated
  String getStoreagePath(Context paramContext, String paramString1, String paramString2);
  
  boolean renameFile(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdIOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
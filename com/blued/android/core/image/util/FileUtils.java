package com.blued.android.core.image.util;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import java.io.File;

public class FileUtils {
  public static File a(String paramString) {
    File file = b(AppInfo.d());
    if (file != null) {
      file = new File(file, "img");
      if (file.exists()) {
        File file1 = new File(file, Md5.a(paramString.toLowerCase().trim()));
        if (file1.exists())
          return file1; 
      } 
    } 
    return null;
  }
  
  public static String a(Context paramContext) {
    File file = b(paramContext);
    if (file != null) {
      file = new File(file, "image");
      if (file.exists() || file.mkdirs())
        return file.getAbsolutePath(); 
    } 
    return null;
  }
  
  private static File b(Context paramContext) {
    File file2 = paramContext.getExternalFilesDir(null);
    File file1 = file2;
    if (file2 == null)
      file1 = paramContext.getCacheDir(); 
    return file1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imag\\util\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
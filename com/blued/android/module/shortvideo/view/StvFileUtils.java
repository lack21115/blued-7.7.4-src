package com.blued.android.module.shortvideo.view;

import android.graphics.Bitmap;
import com.blued.android.module.shortvideo.utils.StvTools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StvFileUtils {
  public static String a(Bitmap paramBitmap, String paramString1, String paramString2) {
    if (paramBitmap == null)
      return ""; 
    File file = new File(paramString1);
    if (!file.exists())
      file.mkdir(); 
    StvTools.c(file.getAbsolutePath());
    file = new File(file, paramString2);
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return file.getAbsolutePath();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\StvFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
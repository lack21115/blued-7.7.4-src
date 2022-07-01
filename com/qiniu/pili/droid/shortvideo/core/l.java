package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import com.qiniu.pili.droid.crash.c;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.j;
import java.io.File;

public class l {
  static {
    System.loadLibrary("pldroid_shortvideo_core");
  }
  
  public static String a(Context paramContext, String paramString) {
    File file1;
    File file2 = new File(paramString);
    File file3 = file2.getParentFile();
    if (file3.exists())
      return file2.getAbsolutePath(); 
    if (!file3.mkdirs()) {
      e e = e.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to mkdirs: ");
      stringBuilder.append(file3);
      stringBuilder.append(" use default: ");
      stringBuilder.append(paramContext.getFilesDir());
      e.e("ShortVideoCore", stringBuilder.toString());
      file1 = new File(paramContext.getFilesDir(), file2.getName());
    } else {
      file1 = file2;
    } 
    return file1.getAbsolutePath();
  }
  
  public static void a(Context paramContext) {
    e.b.b(j.j(paramContext));
    u.a().a(paramContext);
    QosManager.a().b(paramContext);
    c.a(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
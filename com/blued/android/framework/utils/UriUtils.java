package com.blued.android.framework.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;

public class UriUtils {
  public static Uri a(File paramFile) {
    if (Build.VERSION.SDK_INT < 24)
      return Uri.fromFile(paramFile); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AppUtils.a().getPackageName());
    stringBuilder.append(".fileprovider");
    String str = stringBuilder.toString();
    return FileProvider.getUriForFile((Context)AppUtils.a(), str, paramFile);
  }
  
  public static Uri a(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : a(new File(paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\UriUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.blued.android.core.imagecache;

import android.content.Context;
import android.text.TextUtils;
import com.blued.blued_core.R;
import java.io.IOException;

public class FailReason {
  private final FailType a;
  
  private final Throwable b;
  
  public FailReason(FailType paramFailType, Throwable paramThrowable) {
    this.a = paramFailType;
    this.b = paramThrowable;
  }
  
  public static String a(Context paramContext, FailReason paramFailReason, boolean paramBoolean) {
    String str;
    if (paramFailReason != null) {
      FailType failType = paramFailReason.a();
      if (failType == FailType.e) {
        str = paramContext.getString(R.string.imageloader_network_exception);
      } else if (failType == FailType.c) {
        str = str.getString(R.string.disk_no_space_exception);
      } else {
        str = str.getString(R.string.imageloader_error_other);
      } 
      String str1 = str;
      if (paramBoolean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(", detail:");
        stringBuilder.append(paramFailReason.b());
        str1 = stringBuilder.toString();
      } 
      return str1;
    } 
    return str.getString(R.string.imageloader_error_other);
  }
  
  public static boolean a(Throwable paramThrowable) {
    if (paramThrowable instanceof IOException) {
      String str = ((IOException)paramThrowable).getMessage();
      if (!TextUtils.isEmpty(str) && (str.contains("ENOSPC") || str.contains("No space left on device")))
        return true; 
    } 
    return false;
  }
  
  public FailType a() {
    return this.a;
  }
  
  public Throwable b() {
    return this.b;
  }
  
  public enum FailType {
    a, b, c, d, e, f, g, h, i, j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\FailReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
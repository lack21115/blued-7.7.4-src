package com.bytedance.sdk.openadsdk.multipro;

import android.text.TextUtils;
import android.util.Base64;

public class c {
  public static String a(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : Base64.encodeToString(paramString.getBytes(), 10);
  }
  
  public static String b(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : new String(Base64.decode(paramString, 10));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
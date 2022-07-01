package com.loc;

import android.net.Uri;
import android.text.TextUtils;

public abstract class q extends av {
  public String d() {
    if (TextUtils.isEmpty(c()))
      return c(); 
    String str = c();
    Uri uri = Uri.parse(str);
    if (uri.getAuthority().startsWith("dualstack-"))
      return str; 
    Uri.Builder builder = uri.buildUpon();
    StringBuilder stringBuilder = new StringBuilder("dualstack-");
    stringBuilder.append(uri.getAuthority());
    return builder.authority(stringBuilder.toString()).build().toString();
  }
  
  public final boolean i() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
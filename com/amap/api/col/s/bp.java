package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;

public abstract class bp extends cy {
  public String b() {
    if (TextUtils.isEmpty(g()))
      return g(); 
    String str = g();
    Uri uri = Uri.parse(str);
    if (uri.getAuthority().startsWith("dualstack-"))
      return str; 
    Uri.Builder builder = uri.buildUpon();
    StringBuilder stringBuilder = new StringBuilder("dualstack-");
    stringBuilder.append(uri.getAuthority());
    return builder.authority(stringBuilder.toString()).build().toString();
  }
  
  public final boolean k() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
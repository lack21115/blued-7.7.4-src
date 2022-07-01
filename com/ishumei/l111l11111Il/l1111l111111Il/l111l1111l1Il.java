package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

public final class l111l1111l1Il extends l111l1111lI1l {
  private final Context l1111l111111Il;
  
  l111l1111l1Il(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    String str = "";
    Uri uri = Uri.parse("content://cn.nubia.identity/identity");
    try {
      ContentProviderClient contentProviderClient;
      int i = Build.VERSION.SDK_INT;
      Bundle bundle = null;
      if (i > 17) {
        contentProviderClient = this.l1111l111111Il.getContentResolver().acquireContentProviderClient(uri);
        if (contentProviderClient != null) {
          bundle = contentProviderClient.call("getOAID", null, null);
          if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
          } else {
            contentProviderClient.release();
          } 
        } 
      } else {
        bundle = this.l1111l111111Il.getContentResolver().call((Uri)contentProviderClient, "getOAID", null, null);
      } 
      i = -1;
      if (bundle != null)
        i = bundle.getInt("code", -1); 
      if (i == 0)
        str = bundle.getString("id"); 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l1111l1Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
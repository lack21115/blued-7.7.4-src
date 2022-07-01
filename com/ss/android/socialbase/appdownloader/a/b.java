package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class b extends a {
  public b(Context paramContext) {
    super(paramContext, null);
  }
  
  public Intent b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("package:");
    stringBuilder.append(this.a.getPackageName());
    Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse(stringBuilder.toString()));
    intent.addFlags(1073741824);
    intent.addFlags(8388608);
    intent.addFlags(268435456);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
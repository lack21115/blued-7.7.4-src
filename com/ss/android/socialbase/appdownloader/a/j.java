package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;

public class j extends a {
  public j(Context paramContext) {
    super(paramContext, null);
  }
  
  public Intent b() {
    Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
    intent.addFlags(268435456);
    intent.addFlags(1073741824);
    intent.addFlags(8388608);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
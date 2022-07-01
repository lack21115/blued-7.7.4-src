package com.ss.android.socialbase.appdownloader.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public abstract class a implements e {
  protected final Context a;
  
  protected final String b;
  
  public a(Context paramContext, String paramString) {
    this.a = paramContext;
    this.b = paramString;
  }
  
  public boolean a() {
    if (this.a == null)
      return false; 
    Intent intent = b();
    try {
      ComponentName componentName = intent.resolveActivity(this.a.getPackageManager());
    } finally {
      intent = null;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
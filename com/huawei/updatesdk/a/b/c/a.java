package com.huawei.updatesdk.a.b.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class a extends BroadcastReceiver {
  public abstract void a(Context paramContext, b paramb);
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    a(paramContext, b.a(paramIntent));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
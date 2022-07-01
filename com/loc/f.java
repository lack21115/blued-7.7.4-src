package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;

public final class f {
  e a = null;
  
  Context b = null;
  
  Messenger c = null;
  
  public f(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    this.a = new e(this.b);
  }
  
  public final IBinder a(Intent paramIntent) {
    e e2 = this.a;
    String str2 = paramIntent.getStringExtra("a");
    if (!TextUtils.isEmpty(str2))
      l.a(e2.e, str2); 
    e2.a = paramIntent.getStringExtra("b");
    k.a(e2.a);
    String str1 = paramIntent.getStringExtra("d");
    if (!TextUtils.isEmpty(str1))
      n.a(str1); 
    e e1 = this.a;
    if ("true".equals(paramIntent.getStringExtra("as")) && e1.d != null)
      e1.d.sendEmptyMessageDelayed(9, 100L); 
    this.c = new Messenger(this.a.d);
    return this.c.getBinder();
  }
  
  public final void a() {
    try {
      e.d();
      this.a.j = ep.b();
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ApsServiceCore", "onCreate");
    } 
  }
  
  public final void b() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ApsServiceCore", "onDestroy");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
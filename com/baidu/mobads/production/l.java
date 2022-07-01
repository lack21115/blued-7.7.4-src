package com.baidu.mobads.production;

import android.content.Context;
import android.net.Uri;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.q;
import dalvik.system.DexClassLoader;

class l implements Runnable {
  l(b paramb, String paramString, Uri paramUri) {}
  
  public void run() {
    try {
      DexClassLoader dexClassLoader = a.a(this.c.f);
      Class<?> clazz1 = Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, (ClassLoader)dexClassLoader);
      Class<?> clazz2 = Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBoostListener", false, (ClassLoader)dexClassLoader);
      Context context = this.c.getApplicationContext();
      String str = this.a;
      Uri uri = this.b;
      h.a(clazz1, "boost", new Class[] { Context.class, String.class, Uri.class, clazz2 }, new Object[] { context, str, uri, null });
      return;
    } catch (Exception exception) {
      q.a().d(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
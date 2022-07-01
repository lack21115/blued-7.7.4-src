package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.m.c;

public class h extends a {
  private static final String e = h.class.getSimpleName();
  
  public void a(Context paramContext, ServiceConnection paramServiceConnection) {
    try {
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2) {
    if (a.a())
      a.b(e, "onStartCommand"); 
    if (!c.a(262144))
      this.b = true; 
    e();
  }
  
  public void c() {
    if (c.a(262144)) {
      this.b = true;
      this.d = false;
      if (a.a())
        a.b(e, "onStartCommandOnMainThread"); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
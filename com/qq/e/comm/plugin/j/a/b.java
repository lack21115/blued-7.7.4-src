package com.qq.e.comm.plugin.j.a;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.j.d;
import com.qq.e.comm.plugin.util.ad;

public class b implements c {
  private int a;
  
  private int b;
  
  public b(int paramInt) {
    this.b = paramInt;
  }
  
  private boolean a(Context paramContext) {
    return ad.a(paramContext);
  }
  
  public long a() {
    return 3000L;
  }
  
  public boolean a(int paramInt) {
    int i = this.a + 1;
    this.a = i;
    return (i < 30 && d.a(paramInt) && !d.c(paramInt) && !d.d(paramInt));
  }
  
  public boolean b() {
    NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
    return (a(GDTADManager.getInstance().getAppContext()) && this.b < networkType.getConnValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
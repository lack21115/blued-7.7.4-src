package com.qq.e.comm.plugin.a;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;

class i implements a {
  public int a() {
    return (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI) ? 3 : 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.d;
import dalvik.system.DexClassLoader;
import java.util.HashMap;

public class d extends d {
  l a = XAdSDKFoundationFacade.getInstance().getAdConstants();
  
  public d(Context paramContext, IXAdConstants4PDK.SlotType paramSlotType) {
    super(paramContext, null, paramSlotType);
    g(1);
    i(this.a.getAdCreativeTypeImage() + this.a.getAdCreativeTypeVideo() + this.a.getAdCreativeTypeRichmedia());
    f(8);
    h(0);
  }
  
  private boolean c() {
    boolean bool1 = a.b();
    boolean bool = false;
    if (!bool1)
      return false; 
    try {
      DexClassLoader dexClassLoader = a.a(this.d);
      Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, (ClassLoader)dexClassLoader);
      Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnGestureListener", false, (ClassLoader)dexClassLoader);
      Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBitmapLoadedListener", false, (ClassLoader)dexClassLoader);
      int i = Build.VERSION.SDK_INT;
      if (i >= 16)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      q.a().d(exception);
      return false;
    } 
  }
  
  public HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("fet", "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
    if (c()) {
      hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png,rm/3d,rm/vr");
      return (HashMap)hashMap;
    } 
    hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png,rm/3d");
    return (HashMap)hashMap;
  }
  
  public String b() {
    return super.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
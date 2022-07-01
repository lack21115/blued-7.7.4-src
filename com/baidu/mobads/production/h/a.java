package com.baidu.mobads.production.h;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class a extends d {
  protected IXAdProd a;
  
  public a(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType, IXAdProd paramIXAdProd) {
    super(paramContext, paramActivity, paramSlotType);
    this.a = paramIXAdProd;
  }
  
  public HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
    hashMap.put("prod", "video");
    hashMap.put("fet", "ANTI,HTML,MSSP,VIDEO,NMON");
    hashMap.put("at", "10");
    hashMap.put("n", "1");
    if (this.a.getProdBase() == null && getApt() != AdSize.PrerollVideoNative.getValue()) {
      hashMap.put("lw", "640");
      hashMap.put("lh", "480");
    } 
    return (HashMap)hashMap;
  }
  
  public String b() {
    return super.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
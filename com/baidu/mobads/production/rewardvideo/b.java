package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends d {
  public b(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType) {
    super(paramContext, paramActivity, paramSlotType);
  }
  
  public HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("fet", "ANTI,MSSP,VIDEO,NMON");
    return (HashMap)hashMap;
  }
  
  public String b() {
    return super.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\rewardvideo\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
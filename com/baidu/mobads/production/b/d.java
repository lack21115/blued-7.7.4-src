package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class d extends d {
  public d(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType, String paramString, int paramInt) {
    super(paramContext, paramActivity, paramSlotType);
    this.b = (new c(paramContext.getApplicationContext(), paramInt, paramString)).a();
  }
  
  public d(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType, String paramString1, String paramString2) {
    super(paramContext, paramActivity, paramSlotType);
    this.b = (new c(paramContext.getApplicationContext(), paramString2, paramString1)).a();
  }
  
  public HashMap<String, String> a() {
    return new HashMap<String, String>();
  }
  
  public String b() {
    return "http://127.0.0.1";
  }
  
  public String c() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
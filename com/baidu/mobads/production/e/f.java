package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class f extends d {
  private Boolean a;
  
  public f(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType, Boolean paramBoolean) {
    super(paramContext, paramActivity, paramSlotType);
    this.a = paramBoolean;
    if (c().booleanValue())
      this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm"); 
  }
  
  public HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("xyz", "hihihi");
    return (HashMap)hashMap;
  }
  
  public String b() {
    return c().booleanValue() ? super.b() : "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
  }
  
  public Boolean c() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
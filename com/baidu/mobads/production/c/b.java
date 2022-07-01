package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends d {
  private int a = 1;
  
  private int l = 1;
  
  private int m = 1;
  
  public b(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType) {
    super(paramContext, paramActivity, paramSlotType);
    a("androidfeed");
  }
  
  public HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.j) {
      hashMap.put("fet", "ANTI,MSSP,NMON,HTML,VIDEO");
    } else {
      hashMap.put("fet", "ANTI,MSSP,NMON,HTML,CLICK2VIDEO,PAUSE,VIDEO");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.l);
    hashMap.put("pos", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.m);
    hashMap.put("seq", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.a);
    hashMap.put("viewid", stringBuilder.toString());
    return (HashMap)hashMap;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public String b() {
    return super.b();
  }
  
  public void b(int paramInt) {
    this.l = paramInt;
  }
  
  public void c(int paramInt) {
    this.m = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
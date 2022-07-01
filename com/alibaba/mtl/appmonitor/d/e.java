package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.log.e.i;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class e extends i {
  private int o;
  
  private int p;
  
  public e(String paramString, int paramInt1, int paramInt2) {
    super(paramString, 0);
    this.o = paramInt1;
    this.p = paramInt2;
  }
  
  public boolean a(int paramInt, Boolean paramBoolean, Map<String, String> paramMap) {
    i.a("AlarmMonitorPointSampling", new Object[] { "samplingSeed:", Integer.valueOf(paramInt), "isSuccess:", paramBoolean, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p) });
    if (this.e != null && paramMap != null) {
      Iterator<c> iterator = this.e.iterator();
      while (iterator.hasNext()) {
        Boolean bool = ((c)iterator.next()).a(paramInt, paramMap);
        if (bool != null)
          return bool.booleanValue(); 
      } 
    } 
    return a(paramInt, paramBoolean.booleanValue());
  }
  
  protected boolean a(int paramInt, boolean paramBoolean) {
    return paramBoolean ? ((paramInt < this.o)) : ((paramInt < this.p));
  }
  
  public void b(JSONObject paramJSONObject) {
    super.b(paramJSONObject);
    this.o = this.n;
    this.p = this.n;
    try {
      Integer integer1 = Integer.valueOf(paramJSONObject.getInt("successSampling"));
      if (integer1 != null)
        this.o = integer1.intValue(); 
      Integer integer2 = Integer.valueOf(paramJSONObject.getInt("failSampling"));
      if (integer2 != null)
        this.p = integer2.intValue(); 
      i.a("AlarmMonitorPointSampling", new Object[] { "[updateSelfSampling]", paramJSONObject, "successSampling:", integer1, "failSampling", integer2 });
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
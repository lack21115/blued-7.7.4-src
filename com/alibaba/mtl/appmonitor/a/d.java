package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.c.e;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d implements b {
  public int e;
  
  public String o;
  
  public String p;
  
  public String s;
  
  public JSONObject a() {
    JSONObject jSONObject = (JSONObject)a.a().a(e.class, new Object[0]);
    try {
      jSONObject.put("page", this.o);
      jSONObject.put("monitorPoint", this.p);
      if (this.s != null)
        jSONObject.put("arg", this.s); 
      return jSONObject;
    } catch (JSONException jSONException) {
      return jSONObject;
    } 
  }
  
  public void clean() {
    this.e = 0;
    this.o = null;
    this.p = null;
    this.s = null;
  }
  
  public void fill(Object... paramVarArgs) {
    this.e = ((Integer)paramVarArgs[0]).intValue();
    this.o = (String)paramVarArgs[1];
    this.p = (String)paramVarArgs[2];
    if (paramVarArgs.length > 3 && paramVarArgs[3] != null)
      this.s = (String)paramVarArgs[3]; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
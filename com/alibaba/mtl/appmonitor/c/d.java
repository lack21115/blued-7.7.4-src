package com.alibaba.mtl.appmonitor.c;

import org.json.JSONArray;

public class d extends JSONArray implements b {
  public void clean() {
    for (int i = 0; i < length(); i++) {
      Object object = opt(i);
      if (object != null && object instanceof b)
        a.a().a((b)object); 
    } 
  }
  
  public void fill(Object... paramVarArgs) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
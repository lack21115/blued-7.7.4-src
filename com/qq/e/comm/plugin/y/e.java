package com.qq.e.comm.plugin.y;

import org.json.JSONObject;

public class e extends b {
  private int a;
  
  private int b;
  
  public e(int paramInt) {
    a("ei", Integer.valueOf(paramInt));
    this.a = paramInt;
  }
  
  public e b(int paramInt) {
    a("vl", Integer.valueOf(paramInt));
    this.b = paramInt;
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ei=");
    stringBuilder.append(this.a);
    stringBuilder.append(" , ");
    stringBuilder.append("vl");
    stringBuilder.append("=");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
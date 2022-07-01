package com.qq.e.comm.plugin.ad;

import java.util.Arrays;

public class k {
  public String a;
  
  public String b;
  
  public String[] c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DpaFloatingZone{imageUrl='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", tags=");
    stringBuilder.append(Arrays.toString((Object[])this.c));
    stringBuilder.append(", discount='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", price='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append(", buttonTxt='");
    stringBuilder.append(this.f);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
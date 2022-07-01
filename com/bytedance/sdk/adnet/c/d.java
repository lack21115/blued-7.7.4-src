package com.bytedance.sdk.adnet.c;

import java.util.Map;

public class d {
  public boolean a = false;
  
  public boolean b = true;
  
  public Map<String, Integer> c = null;
  
  public Map<String, String> d = null;
  
  public int e = 10;
  
  public int f = 3;
  
  public int g = 3;
  
  public int h = 10;
  
  public int i = 3;
  
  public int j = 3;
  
  public int k = 900;
  
  public int l = 120;
  
  public String m = null;
  
  public int n = 0;
  
  public long o = 0L;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" localEnable: ");
    stringBuilder.append(this.a);
    stringBuilder.append(" probeEnable: ");
    stringBuilder.append(this.b);
    stringBuilder.append(" hostFilter: ");
    Map<String, Integer> map1 = this.c;
    byte b = 0;
    if (map1 != null) {
      i = map1.size();
    } else {
      i = 0;
    } 
    stringBuilder.append(i);
    stringBuilder.append(" hostMap: ");
    Map<String, String> map = this.d;
    int i = b;
    if (map != null)
      i = map.size(); 
    stringBuilder.append(i);
    stringBuilder.append(" reqTo: ");
    stringBuilder.append(this.e);
    stringBuilder.append("#");
    stringBuilder.append(this.f);
    stringBuilder.append("#");
    stringBuilder.append(this.g);
    stringBuilder.append(" reqErr: ");
    stringBuilder.append(this.h);
    stringBuilder.append("#");
    stringBuilder.append(this.i);
    stringBuilder.append("#");
    stringBuilder.append(this.j);
    stringBuilder.append(" updateInterval: ");
    stringBuilder.append(this.k);
    stringBuilder.append(" updateRandom: ");
    stringBuilder.append(this.l);
    stringBuilder.append(" httpBlack: ");
    stringBuilder.append(this.m);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
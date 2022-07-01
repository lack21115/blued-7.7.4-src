package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class ao extends k implements Cloneable {
  private static ArrayList<an> b;
  
  public ArrayList<an> a = null;
  
  public final void a(i parami) {
    if (b == null) {
      b = new ArrayList<an>();
      an an = new an();
      b.add(an);
    } 
    this.a = (ArrayList<an>)parami.<ArrayList<an>>a(b, 0, true);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
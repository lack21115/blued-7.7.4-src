package com.github.mikephil.charting.data;

import android.util.Log;

public class PieEntry extends Entry {
  private String a;
  
  public String a() {
    return this.a;
  }
  
  @Deprecated
  public float i() {
    Log.i("DEPRECATED", "Pie entries do not have x values");
    return super.i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\PieEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
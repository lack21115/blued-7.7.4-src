package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

public abstract class ComponentBase {
  protected float A = Utils.a(10.0F);
  
  protected int B = -16777216;
  
  protected boolean w = true;
  
  protected float x = 5.0F;
  
  protected float y = 5.0F;
  
  protected Typeface z = null;
  
  public void d(boolean paramBoolean) {
    this.w = paramBoolean;
  }
  
  public float u() {
    return this.x;
  }
  
  public float v() {
    return this.y;
  }
  
  public Typeface w() {
    return this.z;
  }
  
  public float x() {
    return this.A;
  }
  
  public int y() {
    return this.B;
  }
  
  public boolean z() {
    return this.w;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\ComponentBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
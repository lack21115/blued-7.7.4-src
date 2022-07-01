package com.amap.api.mapcore2d;

import android.content.Context;

public class fv extends fu {
  private Context b;
  
  private boolean c = false;
  
  public fv(Context paramContext, boolean paramBoolean) {
    this.b = paramContext;
    this.c = paramBoolean;
  }
  
  protected boolean a() {
    int i = cu.r(this.b);
    boolean bool = true;
    if (i != 1) {
      if (this.c)
        return true; 
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
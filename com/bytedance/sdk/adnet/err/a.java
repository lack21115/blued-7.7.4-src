package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.j;

public class a extends VAdError {
  private Intent b;
  
  public a() {}
  
  public a(j paramj) {
    super(paramj);
  }
  
  public String getMessage() {
    return (this.b != null) ? "User needs to (re)enter credentials." : super.getMessage();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\err\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;

public class ft extends fu {
  private int b;
  
  private long c;
  
  private String d;
  
  private Context e;
  
  public ft(Context paramContext, int paramInt, String paramString, fu paramfu) {
    super(paramfu);
    this.b = paramInt;
    this.d = paramString;
    this.e = paramContext;
  }
  
  private long a(String paramString) {
    paramString = dm.a(this.e, paramString);
    return TextUtils.isEmpty(paramString) ? 0L : Long.parseLong(paramString);
  }
  
  private void a(String paramString, long paramLong) {
    this.c = paramLong;
    dm.a(this.e, paramString, String.valueOf(paramLong));
  }
  
  public void a(boolean paramBoolean) {
    super.a(paramBoolean);
    if (paramBoolean)
      a(this.d, System.currentTimeMillis()); 
  }
  
  protected boolean a() {
    if (this.c == 0L)
      this.c = a(this.d); 
    return !(System.currentTimeMillis() - this.c < this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
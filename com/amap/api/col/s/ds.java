package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

public final class ds extends dt {
  protected int a;
  
  protected long b;
  
  private String d;
  
  private Context e;
  
  public ds(Context paramContext, int paramInt, String paramString, dt paramdt) {
    super(paramdt);
    this.a = paramInt;
    this.d = paramString;
    this.e = paramContext;
  }
  
  public final void a(boolean paramBoolean) {
    super.a(paramBoolean);
    if (paramBoolean) {
      String str = this.d;
      long l = System.currentTimeMillis();
      this.b = l;
      ce.a(this.e, str, String.valueOf(l));
    } 
  }
  
  protected final boolean a() {
    long l2 = this.b;
    long l1 = 0L;
    if (l2 == 0L) {
      String str = this.d;
      str = ce.a(this.e, str);
      if (!TextUtils.isEmpty(str))
        l1 = Long.parseLong(str); 
      this.b = l1;
    } 
    return !(System.currentTimeMillis() - this.b < this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
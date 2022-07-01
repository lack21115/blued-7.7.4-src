package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

public final class dq extends dt {
  private String a = "iKey";
  
  private Context b;
  
  private boolean d;
  
  private int e;
  
  private int f;
  
  private int g = 0;
  
  public dq(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, int paramInt3) {
    this.b = paramContext;
    this.d = paramBoolean;
    this.e = paramInt1;
    this.f = paramInt2;
    this.a = paramString;
    this.g = paramInt3;
  }
  
  public final void a(int paramInt) {
    if (bm.p(this.b) == 1)
      return; 
    String str1 = bs.a(System.currentTimeMillis(), "yyyyMMdd");
    String str2 = ce.a(this.b, this.a);
    int i = paramInt;
    if (!TextUtils.isEmpty(str2)) {
      String[] arrayOfString = str2.split("\\|");
      if (arrayOfString == null || arrayOfString.length < 2) {
        ce.b(this.b, this.a);
        i = paramInt;
      } else {
        i = paramInt;
        if (str1.equals(arrayOfString[0]))
          i = paramInt + Integer.parseInt(arrayOfString[1]); 
      } 
    } 
    Context context = this.b;
    String str3 = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("|");
    stringBuilder.append(i);
    ce.a(context, str3, stringBuilder.toString());
  }
  
  protected final boolean a() {
    if (bm.p(this.b) == 1)
      return true; 
    if (!this.d)
      return false; 
    String str1 = ce.a(this.b, this.a);
    if (TextUtils.isEmpty(str1))
      return true; 
    String[] arrayOfString = str1.split("\\|");
    if (arrayOfString == null || arrayOfString.length < 2) {
      ce.b(this.b, this.a);
      return true;
    } 
    String str2 = arrayOfString[0];
    return !(bs.a(System.currentTimeMillis(), "yyyyMMdd").equals(str2) && Integer.parseInt(arrayOfString[1]) >= this.f);
  }
  
  public final int b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: invokestatic p : (Landroid/content/Context;)I
    //   7: iconst_1
    //   8: if_icmpeq -> 22
    //   11: aload_0
    //   12: getfield e : I
    //   15: istore_2
    //   16: iload_2
    //   17: istore_1
    //   18: iload_2
    //   19: ifgt -> 43
    //   22: aload_0
    //   23: getfield g : I
    //   26: istore_1
    //   27: iload_1
    //   28: ifle -> 40
    //   31: iload_1
    //   32: ldc 2147483647
    //   34: if_icmpge -> 40
    //   37: goto -> 43
    //   40: ldc 2147483647
    //   42: istore_1
    //   43: iload_1
    //   44: istore_2
    //   45: aload_0
    //   46: getfield c : Lcom/amap/api/col/s/dt;
    //   49: ifnull -> 64
    //   52: iload_1
    //   53: aload_0
    //   54: getfield c : Lcom/amap/api/col/s/dt;
    //   57: invokevirtual b : ()I
    //   60: invokestatic max : (II)I
    //   63: istore_2
    //   64: iload_2
    //   65: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
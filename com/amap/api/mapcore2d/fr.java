package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;

public class fr extends fu {
  private Context b;
  
  private boolean c;
  
  private int d;
  
  private int e;
  
  public fr(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2) {
    this.b = paramContext;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(int paramInt) {
    int i;
    if (cu.r(this.b) == 1)
      return; 
    String str1 = db.a(System.currentTimeMillis(), "yyyyMMdd");
    String str2 = dm.a(this.b, "iKey");
    if (TextUtils.isEmpty(str2)) {
      i = paramInt;
    } else {
      String[] arrayOfString = str2.split("\\|");
      if (arrayOfString == null || arrayOfString.length < 2) {
        dm.b(this.b, "iKey");
        i = paramInt;
      } else {
        i = paramInt;
        if (str1.equals(arrayOfString[0]))
          i = paramInt + Integer.parseInt(arrayOfString[1]); 
      } 
    } 
    Context context = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("|");
    stringBuilder.append(i);
    dm.a(context, "iKey", stringBuilder.toString());
  }
  
  protected boolean a() {
    if (cu.r(this.b) == 1)
      return true; 
    if (!this.c)
      return false; 
    String str1 = dm.a(this.b, "iKey");
    if (TextUtils.isEmpty(str1))
      return true; 
    String[] arrayOfString = str1.split("\\|");
    if (arrayOfString == null || arrayOfString.length < 2) {
      dm.b(this.b, "iKey");
      return true;
    } 
    String str2 = arrayOfString[0];
    return !(db.a(System.currentTimeMillis(), "yyyyMMdd").equals(str2) && Integer.parseInt(arrayOfString[1]) >= this.e);
  }
  
  public int b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: invokestatic r : (Landroid/content/Context;)I
    //   7: iconst_1
    //   8: if_icmpeq -> 22
    //   11: aload_0
    //   12: getfield d : I
    //   15: istore_2
    //   16: iload_2
    //   17: istore_1
    //   18: iload_2
    //   19: ifgt -> 25
    //   22: ldc 2147483647
    //   24: istore_1
    //   25: iload_1
    //   26: istore_2
    //   27: aload_0
    //   28: getfield a : Lcom/amap/api/mapcore2d/fu;
    //   31: ifnull -> 46
    //   34: iload_1
    //   35: aload_0
    //   36: getfield a : Lcom/amap/api/mapcore2d/fu;
    //   39: invokevirtual b : ()I
    //   42: invokestatic max : (II)I
    //   45: istore_2
    //   46: iload_2
    //   47: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
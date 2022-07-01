package com.loc;

public final class cf extends es {
  public static int a(er paramer, int paramInt1, byte paramByte, int paramInt2, int paramInt3) {
    paramer.b(4);
    paramer.b(3, paramInt3);
    paramer.b(2, paramInt2);
    paramer.b(0, paramInt1);
    paramer.a(1, paramByte);
    return paramer.b();
  }
  
  public static int a(er paramer, int[] paramArrayOfint) {
    paramer.a(4, paramArrayOfint.length, 4);
    for (int i = paramArrayOfint.length - 1; i >= 0; i--)
      paramer.a(paramArrayOfint[i]); 
    return paramer.a();
  }
  
  public static int b(er paramer, int[] paramArrayOfint) {
    paramer.a(4, paramArrayOfint.length, 4);
    for (int i = paramArrayOfint.length - 1; i >= 0; i--)
      paramer.a(paramArrayOfint[i]); 
    return paramer.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
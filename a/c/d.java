package a.c;

public class d {
  public static final int[] a = new int[0];
  
  public static final long[] b = new long[0];
  
  public static final Object[] c = new Object[0];
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int a(int paramInt) {
    for (int i = 4; i < 32; i++) {
      int j = (1 << i) - 12;
      if (paramInt <= j)
        return j; 
    } 
    return paramInt;
  }
  
  public static int a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    paramInt1--;
    int i = 0;
    while (i <= paramInt1) {
      int j = i + paramInt1 >>> 1;
      int k = paramArrayOfint[j];
      if (k < paramInt2) {
        i = j + 1;
        continue;
      } 
      if (k > paramInt2) {
        paramInt1 = j - 1;
        continue;
      } 
      return j;
    } 
    return i ^ 0xFFFFFFFF;
  }
  
  public static int a(long[] paramArrayOflong, int paramInt, long paramLong) {
    paramInt--;
    int i = 0;
    while (i <= paramInt) {
      int j = i + paramInt >>> 1;
      long l = paramArrayOflong[j];
      if (l < paramLong) {
        i = j + 1;
        continue;
      } 
      if (l > paramLong) {
        paramInt = j - 1;
        continue;
      } 
      return j;
    } 
    return i ^ 0xFFFFFFFF;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) {
    if (paramObject1 != paramObject2) {
      if (paramObject1 != null)
        throw new VerifyError("bad dex opcode"); 
      return false;
    } 
    return true;
  }
  
  public static int b(int paramInt) {
    return a(paramInt * 4) / 4;
  }
  
  public static int c(int paramInt) {
    return a(paramInt * 8) / 8;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
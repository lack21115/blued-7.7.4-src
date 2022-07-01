package com.google.zxing.qrcode.decoder;

public enum Mode {
  a(new int[] { 0, 0, 0 }, 0),
  b(new int[] { 10, 12, 14 }, 1),
  c(new int[] { 9, 11, 13 }, 2),
  d(new int[] { 0, 0, 0 }, 3),
  e(new int[] { 8, 16, 16 }, 4),
  f(new int[] { 0, 0, 0 }, 7),
  g(new int[] { 8, 10, 12 }, 8),
  h(new int[] { 0, 0, 0 }, 5),
  i(new int[] { 0, 0, 0 }, 9),
  j(new int[] { 8, 10, 12 }, 13);
  
  private final int[] k;
  
  private final int l;
  
  Mode(int[] paramArrayOfint, int paramInt1) {
    this.k = paramArrayOfint;
    this.l = paramInt1;
  }
  
  public static Mode a(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4) {
              if (paramInt != 5) {
                if (paramInt != 7) {
                  if (paramInt != 8) {
                    if (paramInt != 9) {
                      if (paramInt == 13)
                        return j; 
                      throw new IllegalArgumentException();
                    } 
                    return i;
                  } 
                  return g;
                } 
                return f;
              } 
              return h;
            } 
            return e;
          } 
          return d;
        } 
        return c;
      } 
      return b;
    } 
    return a;
  }
  
  public int a(Version paramVersion) {
    int i = paramVersion.a();
    if (i <= 9) {
      i = 0;
    } else if (i <= 26) {
      i = 1;
    } else {
      i = 2;
    } 
    return this.k[i];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\Mode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
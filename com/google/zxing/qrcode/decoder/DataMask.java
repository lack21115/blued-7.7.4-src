package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

enum DataMask {
  a {
    boolean a(int param1Int1, int param1Int2) {
      return ((param1Int1 + param1Int2 & 0x1) == 0);
    }
  },
  b {
    boolean a(int param1Int1, int param1Int2) {
      return ((param1Int1 & 0x1) == 0);
    }
  },
  c {
    boolean a(int param1Int1, int param1Int2) {
      return (param1Int2 % 3 == 0);
    }
  },
  d {
    boolean a(int param1Int1, int param1Int2) {
      return ((param1Int1 + param1Int2) % 3 == 0);
    }
  },
  e {
    boolean a(int param1Int1, int param1Int2) {
      return ((param1Int1 / 2 + param1Int2 / 3 & 0x1) == 0);
    }
  },
  f {
    boolean a(int param1Int1, int param1Int2) {
      return (param1Int1 * param1Int2 % 6 == 0);
    }
  },
  g {
    boolean a(int param1Int1, int param1Int2) {
      return (param1Int1 * param1Int2 % 6 < 3);
    }
  },
  h {
    boolean a(int param1Int1, int param1Int2) {
      return ((param1Int1 + param1Int2 + param1Int1 * param1Int2 % 3 & 0x1) == 0);
    }
  };
  
  final void a(BitMatrix paramBitMatrix, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      int j;
      for (j = 0; j < paramInt; j++) {
        if (a(i, j))
          paramBitMatrix.c(j, i); 
      } 
    } 
  }
  
  abstract boolean a(int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\DataMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
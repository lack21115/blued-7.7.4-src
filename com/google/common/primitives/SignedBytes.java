package com.google.common.primitives;

import java.util.Comparator;

public final class SignedBytes {
  public static int a(byte paramByte1, byte paramByte2) {
    return paramByte1 - paramByte2;
  }
  
  enum LexicographicalComparator implements Comparator<byte[]> {
    a;
    
    public int a(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
      int j = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
      for (int i = 0; i < j; i++) {
        int k = SignedBytes.a(param1ArrayOfbyte1[i], param1ArrayOfbyte2[i]);
        if (k != 0)
          return k; 
      } 
      return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
    }
    
    public String toString() {
      return "SignedBytes.lexicographicalComparator()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\SignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
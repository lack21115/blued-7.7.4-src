package com.google.zxing.aztec.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public final class HighLevelEncoder {
  static final String[] a = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
  
  static final int[][] b;
  
  static final int[][] c;
  
  private static final int[][] d;
  
  static {
    int[] arrayOfInt4 = { 327709, 327708, 656318, 0, 327710 };
    b = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, arrayOfInt4, { 327711, 656380, 656382, 656381, 0 } };
    int[][] arrayOfInt3 = (int[][])Array.newInstance(int.class, new int[] { 5, 256 });
    d = arrayOfInt3;
    arrayOfInt3[0][32] = 1;
    int i;
    for (i = 65; i <= 90; i++)
      d[0][i] = i - 65 + 2; 
    d[1][32] = 1;
    for (i = 97; i <= 122; i++)
      d[1][i] = i - 97 + 2; 
    d[2][32] = 1;
    for (i = 48; i <= 57; i++)
      d[2][i] = i - 48 + 2; 
    arrayOfInt3 = d;
    arrayOfInt3[2][44] = 12;
    arrayOfInt3[2][46] = 13;
    for (i = 0; i < 28; i++) {
      (new int[28])[0] = 0;
      (new int[28])[1] = 32;
      (new int[28])[2] = 1;
      (new int[28])[3] = 2;
      (new int[28])[4] = 3;
      (new int[28])[5] = 4;
      (new int[28])[6] = 5;
      (new int[28])[7] = 6;
      (new int[28])[8] = 7;
      (new int[28])[9] = 8;
      (new int[28])[10] = 9;
      (new int[28])[11] = 10;
      (new int[28])[12] = 11;
      (new int[28])[13] = 12;
      (new int[28])[14] = 13;
      (new int[28])[15] = 27;
      (new int[28])[16] = 28;
      (new int[28])[17] = 29;
      (new int[28])[18] = 30;
      (new int[28])[19] = 31;
      (new int[28])[20] = 64;
      (new int[28])[21] = 92;
      (new int[28])[22] = 94;
      (new int[28])[23] = 95;
      (new int[28])[24] = 96;
      (new int[28])[25] = 124;
      (new int[28])[26] = 126;
      (new int[28])[27] = 127;
      d[3][(new int[28])[i]] = i;
    } 
    int[] arrayOfInt2 = new int[31];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 13;
    arrayOfInt2[2] = 0;
    arrayOfInt2[3] = 0;
    arrayOfInt2[4] = 0;
    arrayOfInt2[5] = 0;
    arrayOfInt2[6] = 33;
    arrayOfInt2[7] = 39;
    arrayOfInt2[8] = 35;
    arrayOfInt2[9] = 36;
    arrayOfInt2[10] = 37;
    arrayOfInt2[11] = 38;
    arrayOfInt2[12] = 39;
    arrayOfInt2[13] = 40;
    arrayOfInt2[14] = 41;
    arrayOfInt2[15] = 42;
    arrayOfInt2[16] = 43;
    arrayOfInt2[17] = 44;
    arrayOfInt2[18] = 45;
    arrayOfInt2[19] = 46;
    arrayOfInt2[20] = 47;
    arrayOfInt2[21] = 58;
    arrayOfInt2[22] = 59;
    arrayOfInt2[23] = 60;
    arrayOfInt2[24] = 61;
    arrayOfInt2[25] = 62;
    arrayOfInt2[26] = 63;
    arrayOfInt2[27] = 91;
    arrayOfInt2[28] = 93;
    arrayOfInt2[29] = 123;
    arrayOfInt2[30] = 125;
    for (i = 0; i < 31; i++) {
      if (arrayOfInt2[i] > 0)
        d[4][arrayOfInt2[i]] = i; 
    } 
    int[][] arrayOfInt1 = (int[][])Array.newInstance(int.class, new int[] { 6, 6 });
    c = arrayOfInt1;
    int j = arrayOfInt1.length;
    for (i = 0; i < j; i++)
      Arrays.fill(arrayOfInt1[i], -1); 
    arrayOfInt1 = c;
    arrayOfInt1[0][4] = 0;
    arrayOfInt1[1][4] = 0;
    arrayOfInt1[1][0] = 28;
    arrayOfInt1[3][4] = 0;
    arrayOfInt1[2][4] = 0;
    arrayOfInt1[2][0] = 15;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\encoder\HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
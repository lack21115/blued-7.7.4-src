package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler extends GridSampler {
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) throws NotFoundException {
    return a(paramBitMatrix, paramInt1, paramInt2, PerspectiveTransform.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16));
  }
  
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform) throws NotFoundException {
    if (paramInt1 > 0 && paramInt2 > 0) {
      BitMatrix bitMatrix = new BitMatrix(paramInt1, paramInt2);
      float[] arrayOfFloat = new float[paramInt1 * 2];
      paramInt1 = 0;
      label26: while (true) {
        if (paramInt1 < paramInt2) {
          int j = arrayOfFloat.length;
          float f = paramInt1;
          int i;
          for (i = 0; i < j; i += 2) {
            arrayOfFloat[i] = (i / 2) + 0.5F;
            arrayOfFloat[i + 1] = f + 0.5F;
          } 
          paramPerspectiveTransform.a(arrayOfFloat);
          a(paramBitMatrix, arrayOfFloat);
          i = 0;
          while (true) {
            if (i < j) {
              try {
                if (paramBitMatrix.a((int)arrayOfFloat[i], (int)arrayOfFloat[i + 1]))
                  bitMatrix.b(i / 2, paramInt1); 
                i += 2;
              } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw NotFoundException.a();
              } 
              continue;
            } 
            paramInt1++;
            continue label26;
          } 
          break;
        } 
        return bitMatrix;
      } 
    } 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\DefaultGridSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
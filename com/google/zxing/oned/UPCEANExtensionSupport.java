package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;

final class UPCEANExtensionSupport {
  private static final int[] a = new int[] { 1, 1, 2 };
  
  private final UPCEANExtension2Support b = new UPCEANExtension2Support();
  
  private final UPCEANExtension5Support c = new UPCEANExtension5Support();
  
  Result a(int paramInt1, BitArray paramBitArray, int paramInt2) throws NotFoundException {
    int[] arrayOfInt = UPCEANReader.a(paramBitArray, paramInt2, false, a);
    try {
      return this.c.a(paramInt1, paramBitArray, arrayOfInt);
    } catch (ReaderException readerException) {
      return this.b.a(paramInt1, paramBitArray, arrayOfInt);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\UPCEANExtensionSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
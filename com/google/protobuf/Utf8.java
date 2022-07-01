package com.google.protobuf;

final class Utf8 {
  private static final Utf8$Processor processor;
  
  static {
    boolean bool;
    Utf8$SafeProcessor utf8$SafeProcessor;
    if (UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      Utf8$UnsafeProcessor utf8$UnsafeProcessor = new Utf8$UnsafeProcessor();
    } else {
      utf8$SafeProcessor = new Utf8$SafeProcessor();
    } 
    processor = utf8$SafeProcessor;
    throw new VerifyError("bad dex opcode");
  }
  
  static int encode(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return processor.encodeUtf8(paramCharSequence, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static int encodedLength(CharSequence paramCharSequence) {
    int k;
    int n = paramCharSequence.length();
    int m = 0;
    int j;
    for (j = 0; j < n && paramCharSequence.charAt(j) < ''; j++);
    int i = n;
    while (true) {
      k = i;
      if (j < n) {
        k = paramCharSequence.charAt(j);
        if (k < 2048) {
          i += 127 - k >>> 31;
          j++;
          continue;
        } 
        int i1 = paramCharSequence.length();
        k = m;
        while (j < i1) {
          char c = paramCharSequence.charAt(j);
          if (c < 'ࠀ') {
            k += 127 - c >>> 31;
            m = j;
          } else {
            int i2 = k + 2;
            k = i2;
            m = j;
            if ('?' <= c) {
              k = i2;
              m = j;
              if (c <= '?')
                if (Character.codePointAt(paramCharSequence, j) >= 65536) {
                  m = j + 1;
                  k = i2;
                } else {
                  throw new Utf8$UnpairedSurrogateException(j, i1);
                }  
            } 
          } 
          j = m + 1;
        } 
        k = i + k;
      } 
      break;
    } 
    if (k >= n)
      return k; 
    paramCharSequence = new StringBuilder("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

final class Utf8$SafeProcessor extends Utf8$Processor {
  final int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    int j = paramCharSequence.length();
    int k = paramInt2 + paramInt1;
    paramInt2 = 0;
    while (paramInt2 < j) {
      int m = paramInt2 + paramInt1;
      if (m < k) {
        char c = paramCharSequence.charAt(paramInt2);
        if (c < '') {
          paramArrayOfbyte[m] = (byte)c;
          paramInt2++;
        } 
      } 
    } 
    if (paramInt2 == j)
      return paramInt1 + j; 
    int i = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    while (paramInt1 < j) {
      char c = paramCharSequence.charAt(paramInt1);
      if (c < '' && i < k) {
        paramInt2 = i + 1;
        paramArrayOfbyte[i] = (byte)c;
      } else if (c < 'ࠀ' && i <= k - 2) {
        int m = i + 1;
        paramArrayOfbyte[i] = (byte)(c >>> 6 | 0x3C0);
        paramInt2 = m + 1;
        paramArrayOfbyte[m] = (byte)(c & 0x3F | 0x80);
      } else if ((c < '?' || '?' < c) && i <= k - 3) {
        paramInt2 = i + 1;
        paramArrayOfbyte[i] = (byte)(c >>> 12 | 0x1E0);
        i = paramInt2 + 1;
        paramArrayOfbyte[paramInt2] = (byte)(c >>> 6 & 0x3F | 0x80);
        paramInt2 = i + 1;
        paramArrayOfbyte[i] = (byte)(c & 0x3F | 0x80);
      } else if (i <= k - 4) {
        paramInt2 = paramInt1 + 1;
        if (paramInt2 != paramCharSequence.length()) {
          char c1 = paramCharSequence.charAt(paramInt2);
          if (Character.isSurrogatePair(c, c1)) {
            paramInt1 = Character.toCodePoint(c, c1);
            int m = i + 1;
            paramArrayOfbyte[i] = (byte)(paramInt1 >>> 18 | 0xF0);
            i = m + 1;
            paramArrayOfbyte[m] = (byte)(paramInt1 >>> 12 & 0x3F | 0x80);
            m = i + 1;
            paramArrayOfbyte[i] = (byte)(paramInt1 >>> 6 & 0x3F | 0x80);
            i = m + 1;
            paramArrayOfbyte[m] = (byte)(paramInt1 & 0x3F | 0x80);
            paramInt1 = paramInt2;
            paramInt2 = i;
          } else {
            paramInt1 = paramInt2;
            throw new Utf8$UnpairedSurrogateException(paramInt1 - 1, j);
          } 
        } else {
          throw new Utf8$UnpairedSurrogateException(paramInt1 - 1, j);
        } 
      } else {
        if ('?' <= c && c <= '?') {
          paramInt2 = paramInt1 + 1;
          if (paramInt2 == paramCharSequence.length() || !Character.isSurrogatePair(c, paramCharSequence.charAt(paramInt2)))
            throw new Utf8$UnpairedSurrogateException(paramInt1, j); 
        } 
        paramCharSequence = new StringBuilder("Failed writing ");
        paramCharSequence.append(c);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(i);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      } 
      paramInt1++;
      i = paramInt2;
    } 
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\Utf8$SafeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
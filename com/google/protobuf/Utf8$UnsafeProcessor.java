package com.google.protobuf;

final class Utf8$UnsafeProcessor extends Utf8$Processor {
  final int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    long l1 = UnsafeUtil.getArrayBaseOffset() + paramInt1;
    long l2 = paramInt2 + l1;
    int i = paramCharSequence.length();
    if (i <= paramInt2 && paramArrayOfbyte.length - paramInt2 >= paramInt1) {
      paramInt2 = 0;
      while (paramInt2 < i) {
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 < 128) {
          UnsafeUtil.putByte(paramArrayOfbyte, l1, (byte)paramInt1);
          paramInt2++;
          l1 = 1L + l1;
        } 
      } 
      paramInt1 = paramInt2;
      long l = l1;
      if (paramInt2 == i)
        return (int)(l1 - UnsafeUtil.getArrayBaseOffset()); 
      while (paramInt1 < i) {
        char c = paramCharSequence.charAt(paramInt1);
        if (c < '' && l < l2) {
          l1 = l + 1L;
          UnsafeUtil.putByte(paramArrayOfbyte, l, (byte)c);
        } else if (c < 'ࠀ' && l <= l2 - 2L) {
          long l3 = l + 1L;
          UnsafeUtil.putByte(paramArrayOfbyte, l, (byte)(c >>> 6 | 0x3C0));
          l1 = l3 + 1L;
          UnsafeUtil.putByte(paramArrayOfbyte, l3, (byte)(c & 0x3F | 0x80));
        } else if ((c < '?' || '?' < c) && l <= l2 - 3L) {
          l1 = l + 1L;
          UnsafeUtil.putByte(paramArrayOfbyte, l, (byte)(c >>> 12 | 0x1E0));
          l = l1 + 1L;
          UnsafeUtil.putByte(paramArrayOfbyte, l1, (byte)(c >>> 6 & 0x3F | 0x80));
          l1 = l + 1L;
          UnsafeUtil.putByte(paramArrayOfbyte, l, (byte)(c & 0x3F | 0x80));
        } else if (l <= l2 - 4L) {
          paramInt2 = paramInt1 + 1;
          if (paramInt2 != i) {
            char c1 = paramCharSequence.charAt(paramInt2);
            paramInt1 = paramInt2;
            if (Character.isSurrogatePair(c, c1)) {
              paramInt1 = Character.toCodePoint(c, c1);
              l1 = l + 1L;
              UnsafeUtil.putByte(paramArrayOfbyte, l, (byte)(paramInt1 >>> 18 | 0xF0));
              l = l1 + 1L;
              UnsafeUtil.putByte(paramArrayOfbyte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
              long l3 = l + 1L;
              UnsafeUtil.putByte(paramArrayOfbyte, l, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
              l1 = l3 + 1L;
              UnsafeUtil.putByte(paramArrayOfbyte, l3, (byte)(paramInt1 & 0x3F | 0x80));
              paramInt1 = paramInt2;
            } else {
              throw new Utf8$UnpairedSurrogateException(paramInt1 - 1, i);
            } 
          } else {
            throw new Utf8$UnpairedSurrogateException(paramInt1 - 1, i);
          } 
        } else {
          if ('?' <= c && c <= '?') {
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == i || !Character.isSurrogatePair(c, paramCharSequence.charAt(paramInt2)))
              throw new Utf8$UnpairedSurrogateException(paramInt1, i); 
          } 
          paramCharSequence = new StringBuilder("Failed writing ");
          paramCharSequence.append(c);
          paramCharSequence.append(" at index ");
          paramCharSequence.append(l);
          throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
        } 
        paramInt1++;
        l = l1;
      } 
      return (int)(l - UnsafeUtil.getArrayBaseOffset());
    } 
    StringBuilder stringBuilder = new StringBuilder("Failed writing ");
    stringBuilder.append(paramCharSequence.charAt(i - 1));
    stringBuilder.append(" at index ");
    stringBuilder.append(paramInt1 + paramInt2);
    throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\Utf8$UnsafeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
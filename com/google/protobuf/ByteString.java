package com.google.protobuf;

import java.io.Serializable;
import java.util.Iterator;

public abstract class ByteString implements Serializable, Iterable {
  static {
    try {
      Class.forName("android.content.Context");
      bool = true;
    } catch (ClassNotFoundException classNotFoundException) {
      bool = false;
    } 
    if (bool) {
      ByteString$SystemByteArrayCopier byteString$SystemByteArrayCopier = new ByteString$SystemByteArrayCopier((byte)0);
    } else {
      byteString$ArraysByteArrayCopier = new ByteString$ArraysByteArrayCopier((byte)0);
    } 
    byteArrayCopier = byteString$ArraysByteArrayCopier;
    throw new VerifyError("bad dex opcode");
  }
  
  static int checkRange(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0) {
      if (paramInt1 >= 0) {
        if (paramInt2 < paramInt1) {
          StringBuilder stringBuilder2 = new StringBuilder("Beginning index larger than ending index: ");
          stringBuilder2.append(paramInt1);
          stringBuilder2.append(", ");
          stringBuilder2.append(paramInt2);
          throw new IndexOutOfBoundsException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder("End index: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" >= ");
        stringBuilder1.append(paramInt3);
        throw new IndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder("Beginning index: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    } 
    return i;
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfbyte) {
    return copyFrom(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new ByteString$LiteralByteString(byteArrayCopier.copyFrom(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  public static ByteString copyFromUtf8(String paramString) {
    return new ByteString$LiteralByteString(paramString.getBytes(Internal.UTF_8));
  }
  
  static ByteString$CodedBuilder newCodedBuilder(int paramInt) {
    return new ByteString$CodedBuilder(paramInt, (byte)0);
  }
  
  static ByteString wrap(byte[] paramArrayOfbyte) {
    return new ByteString$LiteralByteString(paramArrayOfbyte);
  }
  
  static ByteString wrap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new ByteString$BoundedByteString(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public abstract byte byteAt(int paramInt);
  
  protected abstract void copyToInternal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode() {
    int j = this.hash;
    int i = j;
    if (j == 0) {
      i = size();
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0)
        i = 1; 
      this.hash = i;
    } 
    return i;
  }
  
  public final ByteString$ByteIterator iterator() {
    return new ByteString$1(this);
  }
  
  public abstract CodedInputStream newCodedInput();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int size();
  
  public abstract ByteString substring(int paramInt1, int paramInt2);
  
  public final byte[] toByteArray() {
    int i = size();
    if (i == 0)
      return Internal.EMPTY_BYTE_ARRAY; 
    byte[] arrayOfByte = new byte[i];
    copyToInternal(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString() {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  abstract void writeTo(ByteOutput paramByteOutput);
  
  static {
    boolean bool;
    ByteString$ArraysByteArrayCopier byteString$ArraysByteArrayCopier;
  }
  
  public static final ByteString EMPTY = new ByteString$LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
  
  private static final ByteString$ByteArrayCopier byteArrayCopier;
  
  int hash = 0;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
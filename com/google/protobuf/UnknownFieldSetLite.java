package com.google.protobuf;

import java.util.Arrays;

public final class UnknownFieldSetLite {
  private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  
  private int count;
  
  boolean isMutable;
  
  private int memoizedSerializedSize = -1;
  
  private Object[] objects;
  
  private int[] tags;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private UnknownFieldSetLite() {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfint, Object[] paramArrayOfObject, boolean paramBoolean) {
    this.count = paramInt;
    this.tags = paramArrayOfint;
    this.objects = paramArrayOfObject;
    this.isMutable = paramBoolean;
  }
  
  public static UnknownFieldSetLite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private UnknownFieldSetLite mergeFrom(CodedInputStream paramCodedInputStream) {
    int i;
    do {
      i = paramCodedInputStream.readTag();
    } while (i != 0 && mergeFieldFrom(i, paramCodedInputStream));
    return this;
  }
  
  static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    int i = paramUnknownFieldSetLite1.count + paramUnknownFieldSetLite2.count;
    int[] arrayOfInt = Arrays.copyOf(paramUnknownFieldSetLite1.tags, i);
    System.arraycopy(paramUnknownFieldSetLite2.tags, 0, arrayOfInt, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramUnknownFieldSetLite1.objects, i);
    System.arraycopy(paramUnknownFieldSetLite2.objects, 0, arrayOfObject, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    return new UnknownFieldSetLite(i, arrayOfInt, arrayOfObject, true);
  }
  
  public static UnknownFieldSetLite newInstance() {
    return new UnknownFieldSetLite();
  }
  
  private void storeField(int paramInt, Object paramObject) {
    if (this.count == this.tags.length) {
      if (this.count < 4) {
        i = 8;
      } else {
        i = this.count >> 1;
      } 
      int i = this.count + i;
      this.tags = Arrays.copyOf(this.tags, i);
      this.objects = Arrays.copyOf(this.objects, i);
    } 
    this.tags[this.count] = paramInt;
    this.objects[this.count] = paramObject;
    this.count++;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof UnknownFieldSetLite))
      return false; 
    paramObject = paramObject;
    if (this.count == ((UnknownFieldSetLite)paramObject).count) {
      int[] arrayOfInt1 = this.tags;
      int[] arrayOfInt2 = ((UnknownFieldSetLite)paramObject).tags;
      int j = this.count;
      int i = 0;
      while (true) {
        if (i < j) {
          if (arrayOfInt1[i] != arrayOfInt2[i]) {
            i = 0;
            break;
          } 
          i++;
          continue;
        } 
        i = 1;
        break;
      } 
      if (i != 0) {
        Object[] arrayOfObject = this.objects;
        paramObject = ((UnknownFieldSetLite)paramObject).objects;
        j = this.count;
        i = 0;
        while (true) {
          if (i < j) {
            if (!arrayOfObject[i].equals(paramObject[i])) {
              i = 0;
              break;
            } 
            i++;
            continue;
          } 
          i = 1;
          break;
        } 
        return !(i == 0);
      } 
    } 
    return false;
  }
  
  public final int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.count) {
      int m = this.tags[j];
      int k = m >>> 3;
      m &= 0x7;
      if (m != 5) {
        switch (m) {
          default:
            throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
          case 3:
            i += (CodedOutputStream.computeTagSize(k) << 1) + ((UnknownFieldSetLite)this.objects[j]).getSerializedSize();
            break;
          case 2:
            i += CodedOutputStream.computeBytesSize(k, (ByteString)this.objects[j]);
            break;
          case 1:
            ((Long)this.objects[j]).longValue();
            i += CodedOutputStream.computeFixed64Size$255f649(k);
            break;
          case 0:
            i += CodedOutputStream.computeUInt64Size(k, ((Long)this.objects[j]).longValue());
            break;
        } 
      } else {
        ((Integer)this.objects[j]).intValue();
        i += CodedOutputStream.computeFixed32Size$255f288(k);
      } 
      j++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public final int hashCode() {
    return ((this.count + 527) * 31 + Arrays.hashCode(this.tags)) * 31 + Arrays.deepHashCode(this.objects);
  }
  
  public final boolean mergeFieldFrom(int paramInt, CodedInputStream paramCodedInputStream) {
    if (this.isMutable) {
      UnknownFieldSetLite unknownFieldSetLite;
      switch (paramInt & 0x7) {
        default:
          throw InvalidProtocolBufferException.invalidWireType();
        case 5:
          storeField(paramInt, Integer.valueOf(paramCodedInputStream.readFixed32()));
          return true;
        case 4:
          return false;
        case 3:
          unknownFieldSetLite = new UnknownFieldSetLite();
          unknownFieldSetLite.mergeFrom(paramCodedInputStream);
          paramCodedInputStream.checkLastTagWas(paramInt >>> 3 << 3 | 0x4);
          storeField(paramInt, unknownFieldSetLite);
          return true;
        case 2:
          storeField(paramInt, paramCodedInputStream.readBytes());
          return true;
        case 1:
          storeField(paramInt, Long.valueOf(paramCodedInputStream.readFixed64()));
          return true;
        case 0:
          break;
      } 
      storeField(paramInt, Long.valueOf(paramCodedInputStream.readInt64()));
      return true;
    } 
    throw new UnsupportedOperationException();
  }
  
  final void printWithIndent(StringBuilder paramStringBuilder, int paramInt) {
    for (int i = 0; i < this.count; i++)
      MessageLiteToString.printField(paramStringBuilder, paramInt, String.valueOf(this.tags[i] >>> 3), this.objects[i]); 
  }
  
  public final void writeTo(CodedOutputStream paramCodedOutputStream) {
    for (int i = 0; i < this.count; i++) {
      int k = this.tags[i];
      int j = k >>> 3;
      k &= 0x7;
      if (k != 5) {
        switch (k) {
          default:
            throw InvalidProtocolBufferException.invalidWireType();
          case 3:
            paramCodedOutputStream.writeTag(j, 3);
            ((UnknownFieldSetLite)this.objects[i]).writeTo(paramCodedOutputStream);
            paramCodedOutputStream.writeTag(j, 4);
            break;
          case 2:
            paramCodedOutputStream.writeBytes(j, (ByteString)this.objects[i]);
            break;
          case 1:
            paramCodedOutputStream.writeFixed64(j, ((Long)this.objects[i]).longValue());
            break;
          case 0:
            paramCodedOutputStream.writeUInt64(j, ((Long)this.objects[i]).longValue());
            break;
        } 
      } else {
        paramCodedOutputStream.writeFixed32(j, ((Integer)this.objects[i]).intValue());
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\UnknownFieldSetLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
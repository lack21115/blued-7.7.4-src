package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite {
  private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  
  private static final int MIN_CAPACITY = 8;
  
  private int count;
  
  private boolean isMutable;
  
  private int memoizedSerializedSize = -1;
  
  private Object[] objects;
  
  private int[] tags;
  
  private UnknownFieldSetLite() {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfint, Object[] paramArrayOfObject, boolean paramBoolean) {
    this.count = paramInt;
    this.tags = paramArrayOfint;
    this.objects = paramArrayOfObject;
    this.isMutable = paramBoolean;
  }
  
  private void ensureCapacity() {
    int i = this.count;
    if (i == this.tags.length) {
      if (i < 4) {
        i = 8;
      } else {
        i >>= 1;
      } 
      i = this.count + i;
      this.tags = Arrays.copyOf(this.tags, i);
      this.objects = Arrays.copyOf(this.objects, i);
    } 
  }
  
  public static UnknownFieldSetLite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private static int hashCode(int[] paramArrayOfint, int paramInt) {
    int j = 17;
    for (int i = 0; i < paramInt; i++)
      j = j * 31 + paramArrayOfint[i]; 
    return j;
  }
  
  private static int hashCode(Object[] paramArrayOfObject, int paramInt) {
    int j = 17;
    for (int i = 0; i < paramInt; i++)
      j = j * 31 + paramArrayOfObject[i].hashCode(); 
    return j;
  }
  
  private UnknownFieldSetLite mergeFrom(CodedInputStream paramCodedInputStream) throws IOException {
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
  
  static UnknownFieldSetLite newInstance() {
    return new UnknownFieldSetLite();
  }
  
  private static boolean objectsEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      if (!paramArrayOfObject1[i].equals(paramArrayOfObject2[i]))
        return false; 
    } 
    return true;
  }
  
  private static boolean tagsEquals(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      if (paramArrayOfint1[i] != paramArrayOfint2[i])
        return false; 
    } 
    return true;
  }
  
  private static void writeField(int paramInt, Object paramObject, Writer paramWriter) throws IOException {
    int i = WireFormat.getTagFieldNumber(paramInt);
    paramInt = WireFormat.getTagWireType(paramInt);
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt == 5) {
              paramWriter.writeFixed32(i, ((Integer)paramObject).intValue());
              return;
            } 
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
          } 
          if (paramWriter.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            paramWriter.writeStartGroup(i);
            ((UnknownFieldSetLite)paramObject).writeTo(paramWriter);
            paramWriter.writeEndGroup(i);
            return;
          } 
          paramWriter.writeEndGroup(i);
          ((UnknownFieldSetLite)paramObject).writeTo(paramWriter);
          paramWriter.writeStartGroup(i);
          return;
        } 
        paramWriter.writeBytes(i, (ByteString)paramObject);
        return;
      } 
      paramWriter.writeFixed64(i, ((Long)paramObject).longValue());
      return;
    } 
    paramWriter.writeInt64(i, ((Long)paramObject).longValue());
  }
  
  void checkMutable() {
    if (this.isMutable)
      return; 
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof UnknownFieldSetLite))
      return false; 
    paramObject = paramObject;
    int i = this.count;
    return (i == ((UnknownFieldSetLite)paramObject).count && tagsEquals(this.tags, ((UnknownFieldSetLite)paramObject).tags, i)) ? (!!objectsEquals(this.objects, ((UnknownFieldSetLite)paramObject).objects, this.count)) : false;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    int k = 0;
    while (j < this.count) {
      int m = this.tags[j];
      i = WireFormat.getTagFieldNumber(m);
      m = WireFormat.getTagWireType(m);
      if (m != 0) {
        if (m != 1) {
          if (m != 2) {
            if (m != 3) {
              if (m == 5) {
                i = CodedOutputStream.computeFixed32Size(i, ((Integer)this.objects[j]).intValue());
              } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
              } 
            } else {
              i = CodedOutputStream.computeTagSize(i) * 2 + ((UnknownFieldSetLite)this.objects[j]).getSerializedSize();
            } 
          } else {
            i = CodedOutputStream.computeBytesSize(i, (ByteString)this.objects[j]);
          } 
        } else {
          i = CodedOutputStream.computeFixed64Size(i, ((Long)this.objects[j]).longValue());
        } 
      } else {
        i = CodedOutputStream.computeUInt64Size(i, ((Long)this.objects[j]).longValue());
      } 
      k += i;
      j++;
    } 
    this.memoizedSerializedSize = k;
    return k;
  }
  
  public int getSerializedSizeAsMessageSet() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.count) {
      j += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i]), (ByteString)this.objects[i]);
      i++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int hashCode() {
    int i = this.count;
    return ((527 + i) * 31 + hashCode(this.tags, i)) * 31 + hashCode(this.objects, this.count);
  }
  
  public void makeImmutable() {
    this.isMutable = false;
  }
  
  boolean mergeFieldFrom(int paramInt, CodedInputStream paramCodedInputStream) throws IOException {
    checkMutable();
    int i = WireFormat.getTagFieldNumber(paramInt);
    int j = WireFormat.getTagWireType(paramInt);
    if (j != 0) {
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            if (j != 4) {
              if (j == 5) {
                storeField(paramInt, Integer.valueOf(paramCodedInputStream.readFixed32()));
                return true;
              } 
              throw InvalidProtocolBufferException.invalidWireType();
            } 
            return false;
          } 
          UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
          unknownFieldSetLite.mergeFrom(paramCodedInputStream);
          paramCodedInputStream.checkLastTagWas(WireFormat.makeTag(i, 4));
          storeField(paramInt, unknownFieldSetLite);
          return true;
        } 
        storeField(paramInt, paramCodedInputStream.readBytes());
        return true;
      } 
      storeField(paramInt, Long.valueOf(paramCodedInputStream.readFixed64()));
      return true;
    } 
    storeField(paramInt, Long.valueOf(paramCodedInputStream.readInt64()));
    return true;
  }
  
  UnknownFieldSetLite mergeLengthDelimitedField(int paramInt, ByteString paramByteString) {
    checkMutable();
    if (paramInt != 0) {
      storeField(WireFormat.makeTag(paramInt, 2), paramByteString);
      return this;
    } 
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  UnknownFieldSetLite mergeVarintField(int paramInt1, int paramInt2) {
    checkMutable();
    if (paramInt1 != 0) {
      storeField(WireFormat.makeTag(paramInt1, 0), Long.valueOf(paramInt2));
      return this;
    } 
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  final void printWithIndent(StringBuilder paramStringBuilder, int paramInt) {
    for (int i = 0; i < this.count; i++)
      MessageLiteToString.printField(paramStringBuilder, paramInt, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i])), this.objects[i]); 
  }
  
  void storeField(int paramInt, Object paramObject) {
    checkMutable();
    ensureCapacity();
    int[] arrayOfInt = this.tags;
    int i = this.count;
    arrayOfInt[i] = paramInt;
    this.objects[i] = paramObject;
    this.count = i + 1;
  }
  
  public void writeAsMessageSetTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (int i = 0; i < this.count; i++)
      paramCodedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[i]), (ByteString)this.objects[i]); 
  }
  
  void writeAsMessageSetTo(Writer paramWriter) throws IOException {
    if (paramWriter.fieldOrder() == Writer.FieldOrder.DESCENDING) {
      for (int i = this.count - 1; i >= 0; i--)
        paramWriter.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i]), this.objects[i]); 
    } else {
      for (int i = 0; i < this.count; i++)
        paramWriter.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i]), this.objects[i]); 
    } 
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (int i = 0; i < this.count; i++) {
      int k = this.tags[i];
      int j = WireFormat.getTagFieldNumber(k);
      k = WireFormat.getTagWireType(k);
      if (k != 0) {
        if (k != 1) {
          if (k != 2) {
            if (k != 3) {
              if (k == 5) {
                paramCodedOutputStream.writeFixed32(j, ((Integer)this.objects[i]).intValue());
              } else {
                throw InvalidProtocolBufferException.invalidWireType();
              } 
            } else {
              paramCodedOutputStream.writeTag(j, 3);
              ((UnknownFieldSetLite)this.objects[i]).writeTo(paramCodedOutputStream);
              paramCodedOutputStream.writeTag(j, 4);
            } 
          } else {
            paramCodedOutputStream.writeBytes(j, (ByteString)this.objects[i]);
          } 
        } else {
          paramCodedOutputStream.writeFixed64(j, ((Long)this.objects[i]).longValue());
        } 
      } else {
        paramCodedOutputStream.writeUInt64(j, ((Long)this.objects[i]).longValue());
      } 
    } 
  }
  
  public void writeTo(Writer paramWriter) throws IOException {
    if (this.count == 0)
      return; 
    if (paramWriter.fieldOrder() == Writer.FieldOrder.ASCENDING) {
      for (int i = 0; i < this.count; i++)
        writeField(this.tags[i], this.objects[i], paramWriter); 
    } else {
      for (int i = this.count - 1; i >= 0; i--)
        writeField(this.tags[i], this.objects[i], paramWriter); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnknownFieldSetLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

import java.io.IOException;

abstract class UnknownFieldSchema<T, B> {
  abstract void addFixed32(B paramB, int paramInt1, int paramInt2);
  
  abstract void addFixed64(B paramB, int paramInt, long paramLong);
  
  abstract void addGroup(B paramB, int paramInt, T paramT);
  
  abstract void addLengthDelimited(B paramB, int paramInt, ByteString paramByteString);
  
  abstract void addVarint(B paramB, int paramInt, long paramLong);
  
  abstract B getBuilderFromMessage(Object paramObject);
  
  abstract T getFromMessage(Object paramObject);
  
  abstract int getSerializedSize(T paramT);
  
  abstract int getSerializedSizeAsMessageSet(T paramT);
  
  abstract void makeImmutable(Object paramObject);
  
  abstract T merge(T paramT1, T paramT2);
  
  final void mergeFrom(B paramB, Reader paramReader) throws IOException {
    do {
    
    } while (paramReader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(paramB, paramReader));
  }
  
  final boolean mergeOneFieldFrom(B paramB, Reader paramReader) throws IOException {
    int j = paramReader.getTag();
    int i = WireFormat.getTagFieldNumber(j);
    j = WireFormat.getTagWireType(j);
    if (j != 0) {
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            if (j != 4) {
              if (j == 5) {
                addFixed32(paramB, i, paramReader.readFixed32());
                return true;
              } 
              throw InvalidProtocolBufferException.invalidWireType();
            } 
            return false;
          } 
          B b = newBuilder();
          j = WireFormat.makeTag(i, 4);
          mergeFrom(b, paramReader);
          if (j == paramReader.getTag()) {
            addGroup(paramB, i, toImmutable(b));
            return true;
          } 
          throw InvalidProtocolBufferException.invalidEndTag();
        } 
        addLengthDelimited(paramB, i, paramReader.readBytes());
        return true;
      } 
      addFixed64(paramB, i, paramReader.readFixed64());
      return true;
    } 
    addVarint(paramB, i, paramReader.readInt64());
    return true;
  }
  
  abstract B newBuilder();
  
  abstract void setBuilderToMessage(Object paramObject, B paramB);
  
  abstract void setToMessage(Object paramObject, T paramT);
  
  abstract boolean shouldDiscardUnknownFields(Reader paramReader);
  
  abstract T toImmutable(B paramB);
  
  abstract void writeAsMessageSetTo(T paramT, Writer paramWriter) throws IOException;
  
  abstract void writeTo(T paramT, Writer paramWriter) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnknownFieldSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

import java.io.IOException;

class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
  void addFixed32(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt1, int paramInt2) {
    paramUnknownFieldSetLite.storeField(WireFormat.makeTag(paramInt1, 5), Integer.valueOf(paramInt2));
  }
  
  void addFixed64(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt, long paramLong) {
    paramUnknownFieldSetLite.storeField(WireFormat.makeTag(paramInt, 1), Long.valueOf(paramLong));
  }
  
  void addGroup(UnknownFieldSetLite paramUnknownFieldSetLite1, int paramInt, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    paramUnknownFieldSetLite1.storeField(WireFormat.makeTag(paramInt, 3), paramUnknownFieldSetLite2);
  }
  
  void addLengthDelimited(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt, ByteString paramByteString) {
    paramUnknownFieldSetLite.storeField(WireFormat.makeTag(paramInt, 2), paramByteString);
  }
  
  void addVarint(UnknownFieldSetLite paramUnknownFieldSetLite, int paramInt, long paramLong) {
    paramUnknownFieldSetLite.storeField(WireFormat.makeTag(paramInt, 0), Long.valueOf(paramLong));
  }
  
  UnknownFieldSetLite getBuilderFromMessage(Object paramObject) {
    UnknownFieldSetLite unknownFieldSetLite2 = getFromMessage(paramObject);
    UnknownFieldSetLite unknownFieldSetLite1 = unknownFieldSetLite2;
    if (unknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance()) {
      unknownFieldSetLite1 = UnknownFieldSetLite.newInstance();
      setToMessage(paramObject, unknownFieldSetLite1);
    } 
    return unknownFieldSetLite1;
  }
  
  UnknownFieldSetLite getFromMessage(Object paramObject) {
    return ((GeneratedMessageLite)paramObject).unknownFields;
  }
  
  int getSerializedSize(UnknownFieldSetLite paramUnknownFieldSetLite) {
    return paramUnknownFieldSetLite.getSerializedSize();
  }
  
  int getSerializedSizeAsMessageSet(UnknownFieldSetLite paramUnknownFieldSetLite) {
    return paramUnknownFieldSetLite.getSerializedSizeAsMessageSet();
  }
  
  void makeImmutable(Object paramObject) {
    getFromMessage(paramObject).makeImmutable();
  }
  
  UnknownFieldSetLite merge(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    return paramUnknownFieldSetLite2.equals(UnknownFieldSetLite.getDefaultInstance()) ? paramUnknownFieldSetLite1 : UnknownFieldSetLite.mutableCopyOf(paramUnknownFieldSetLite1, paramUnknownFieldSetLite2);
  }
  
  UnknownFieldSetLite newBuilder() {
    return UnknownFieldSetLite.newInstance();
  }
  
  void setBuilderToMessage(Object paramObject, UnknownFieldSetLite paramUnknownFieldSetLite) {
    setToMessage(paramObject, paramUnknownFieldSetLite);
  }
  
  void setToMessage(Object paramObject, UnknownFieldSetLite paramUnknownFieldSetLite) {
    ((GeneratedMessageLite)paramObject).unknownFields = paramUnknownFieldSetLite;
  }
  
  boolean shouldDiscardUnknownFields(Reader paramReader) {
    return false;
  }
  
  UnknownFieldSetLite toImmutable(UnknownFieldSetLite paramUnknownFieldSetLite) {
    paramUnknownFieldSetLite.makeImmutable();
    return paramUnknownFieldSetLite;
  }
  
  void writeAsMessageSetTo(UnknownFieldSetLite paramUnknownFieldSetLite, Writer paramWriter) throws IOException {
    paramUnknownFieldSetLite.writeAsMessageSetTo(paramWriter);
  }
  
  void writeTo(UnknownFieldSetLite paramUnknownFieldSetLite, Writer paramWriter) throws IOException {
    paramUnknownFieldSetLite.writeTo(paramWriter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnknownFieldSetLiteSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

import java.io.IOException;

class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {
  private final boolean proto3;
  
  public UnknownFieldSetSchema(boolean paramBoolean) {
    this.proto3 = paramBoolean;
  }
  
  void addFixed32(UnknownFieldSet.Builder paramBuilder, int paramInt1, int paramInt2) {
    paramBuilder.mergeField(paramInt1, UnknownFieldSet.Field.newBuilder().addFixed32(paramInt2).build());
  }
  
  void addFixed64(UnknownFieldSet.Builder paramBuilder, int paramInt, long paramLong) {
    paramBuilder.mergeField(paramInt, UnknownFieldSet.Field.newBuilder().addFixed64(paramLong).build());
  }
  
  void addGroup(UnknownFieldSet.Builder paramBuilder, int paramInt, UnknownFieldSet paramUnknownFieldSet) {
    paramBuilder.mergeField(paramInt, UnknownFieldSet.Field.newBuilder().addGroup(paramUnknownFieldSet).build());
  }
  
  void addLengthDelimited(UnknownFieldSet.Builder paramBuilder, int paramInt, ByteString paramByteString) {
    paramBuilder.mergeField(paramInt, UnknownFieldSet.Field.newBuilder().addLengthDelimited(paramByteString).build());
  }
  
  void addVarint(UnknownFieldSet.Builder paramBuilder, int paramInt, long paramLong) {
    paramBuilder.mergeField(paramInt, UnknownFieldSet.Field.newBuilder().addVarint(paramLong).build());
  }
  
  UnknownFieldSet.Builder getBuilderFromMessage(Object paramObject) {
    return ((GeneratedMessageV3)paramObject).unknownFields.toBuilder();
  }
  
  UnknownFieldSet getFromMessage(Object paramObject) {
    return ((GeneratedMessageV3)paramObject).unknownFields;
  }
  
  int getSerializedSize(UnknownFieldSet paramUnknownFieldSet) {
    return paramUnknownFieldSet.getSerializedSize();
  }
  
  int getSerializedSizeAsMessageSet(UnknownFieldSet paramUnknownFieldSet) {
    return paramUnknownFieldSet.getSerializedSizeAsMessageSet();
  }
  
  void makeImmutable(Object paramObject) {}
  
  UnknownFieldSet merge(UnknownFieldSet paramUnknownFieldSet1, UnknownFieldSet paramUnknownFieldSet2) {
    return paramUnknownFieldSet1.toBuilder().mergeFrom(paramUnknownFieldSet2).build();
  }
  
  UnknownFieldSet.Builder newBuilder() {
    return UnknownFieldSet.newBuilder();
  }
  
  void setBuilderToMessage(Object paramObject, UnknownFieldSet.Builder paramBuilder) {
    ((GeneratedMessageV3)paramObject).unknownFields = paramBuilder.build();
  }
  
  void setToMessage(Object paramObject, UnknownFieldSet paramUnknownFieldSet) {
    ((GeneratedMessageV3)paramObject).unknownFields = paramUnknownFieldSet;
  }
  
  boolean shouldDiscardUnknownFields(Reader paramReader) {
    return paramReader.shouldDiscardUnknownFields();
  }
  
  UnknownFieldSet toImmutable(UnknownFieldSet.Builder paramBuilder) {
    return paramBuilder.build();
  }
  
  void writeAsMessageSetTo(UnknownFieldSet paramUnknownFieldSet, Writer paramWriter) throws IOException {
    paramUnknownFieldSet.writeAsMessageSetTo(paramWriter);
  }
  
  void writeTo(UnknownFieldSet paramUnknownFieldSet, Writer paramWriter) throws IOException {
    paramUnknownFieldSet.writeTo(paramWriter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnknownFieldSetSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface Reader {
  public static final int READ_DONE = 2147483647;
  
  public static final int TAG_UNKNOWN = 0;
  
  int getFieldNumber() throws IOException;
  
  int getTag();
  
  boolean readBool() throws IOException;
  
  void readBoolList(List<Boolean> paramList) throws IOException;
  
  ByteString readBytes() throws IOException;
  
  void readBytesList(List<ByteString> paramList) throws IOException;
  
  double readDouble() throws IOException;
  
  void readDoubleList(List<Double> paramList) throws IOException;
  
  int readEnum() throws IOException;
  
  void readEnumList(List<Integer> paramList) throws IOException;
  
  int readFixed32() throws IOException;
  
  void readFixed32List(List<Integer> paramList) throws IOException;
  
  long readFixed64() throws IOException;
  
  void readFixed64List(List<Long> paramList) throws IOException;
  
  float readFloat() throws IOException;
  
  void readFloatList(List<Float> paramList) throws IOException;
  
  @Deprecated
  <T> T readGroup(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  @Deprecated
  <T> T readGroupBySchemaWithCheck(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  @Deprecated
  <T> void readGroupList(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  @Deprecated
  <T> void readGroupList(List<T> paramList, Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  int readInt32() throws IOException;
  
  void readInt32List(List<Integer> paramList) throws IOException;
  
  long readInt64() throws IOException;
  
  void readInt64List(List<Long> paramList) throws IOException;
  
  <K, V> void readMap(Map<K, V> paramMap, MapEntryLite.Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  <T> T readMessage(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  <T> T readMessageBySchemaWithCheck(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  <T> void readMessageList(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  <T> void readMessageList(List<T> paramList, Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  int readSFixed32() throws IOException;
  
  void readSFixed32List(List<Integer> paramList) throws IOException;
  
  long readSFixed64() throws IOException;
  
  void readSFixed64List(List<Long> paramList) throws IOException;
  
  int readSInt32() throws IOException;
  
  void readSInt32List(List<Integer> paramList) throws IOException;
  
  long readSInt64() throws IOException;
  
  void readSInt64List(List<Long> paramList) throws IOException;
  
  String readString() throws IOException;
  
  void readStringList(List<String> paramList) throws IOException;
  
  void readStringListRequireUtf8(List<String> paramList) throws IOException;
  
  String readStringRequireUtf8() throws IOException;
  
  int readUInt32() throws IOException;
  
  void readUInt32List(List<Integer> paramList) throws IOException;
  
  long readUInt64() throws IOException;
  
  void readUInt64List(List<Long> paramList) throws IOException;
  
  boolean shouldDiscardUnknownFields();
  
  boolean skipField() throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
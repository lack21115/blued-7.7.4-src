package com.google.protobuf;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class MapEntryLite<K, V> {
  private static final int KEY_FIELD_NUMBER = 1;
  
  private static final int VALUE_FIELD_NUMBER = 2;
  
  private final K key;
  
  private final Metadata<K, V> metadata;
  
  private final V value;
  
  private MapEntryLite(Metadata<K, V> paramMetadata, K paramK, V paramV) {
    this.metadata = paramMetadata;
    this.key = paramK;
    this.value = paramV;
  }
  
  private MapEntryLite(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV) {
    this.metadata = new Metadata<K, V>(paramFieldType1, paramK, paramFieldType2, paramV);
    this.key = paramK;
    this.value = paramV;
  }
  
  static <K, V> int computeSerializedSize(Metadata<K, V> paramMetadata, K paramK, V paramV) {
    return FieldSet.computeElementSize(paramMetadata.keyType, 1, paramK) + FieldSet.computeElementSize(paramMetadata.valueType, 2, paramV);
  }
  
  public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV) {
    return new MapEntryLite<K, V>(paramFieldType1, paramK, paramFieldType2, paramV);
  }
  
  static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream paramCodedInputStream, Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    K k = paramMetadata.defaultKey;
    V v = paramMetadata.defaultValue;
    while (true) {
      int i = paramCodedInputStream.readTag();
      if (i == 0)
        break; 
      if (i == WireFormat.makeTag(1, paramMetadata.keyType.getWireType())) {
        k = parseField(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.keyType, k);
        continue;
      } 
      if (i == WireFormat.makeTag(2, paramMetadata.valueType.getWireType())) {
        v = parseField(paramCodedInputStream, paramExtensionRegistryLite, paramMetadata.valueType, v);
        continue;
      } 
      if (!paramCodedInputStream.skipField(i))
        break; 
    } 
    return new AbstractMap.SimpleImmutableEntry<K, V>(k, v);
  }
  
  static <T> T parseField(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, WireFormat.FieldType paramFieldType, T paramT) throws IOException {
    int i = null.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return (T)FieldSet.readPrimitiveField(paramCodedInputStream, paramFieldType, true); 
        throw new RuntimeException("Groups are not allowed in maps.");
      } 
      return (T)Integer.valueOf(paramCodedInputStream.readEnum());
    } 
    MessageLite.Builder builder = ((MessageLite)paramT).toBuilder();
    paramCodedInputStream.readMessage(builder, paramExtensionRegistryLite);
    return (T)builder.buildPartial();
  }
  
  static <K, V> void writeTo(CodedOutputStream paramCodedOutputStream, Metadata<K, V> paramMetadata, K paramK, V paramV) throws IOException {
    FieldSet.writeElement(paramCodedOutputStream, paramMetadata.keyType, 1, paramK);
    FieldSet.writeElement(paramCodedOutputStream, paramMetadata.valueType, 2, paramV);
  }
  
  public int computeMessageSize(int paramInt, K paramK, V paramV) {
    return CodedOutputStream.computeTagSize(paramInt) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, paramK, paramV));
  }
  
  public K getKey() {
    return this.key;
  }
  
  Metadata<K, V> getMetadata() {
    return this.metadata;
  }
  
  public V getValue() {
    return this.value;
  }
  
  public Map.Entry<K, V> parseEntry(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return parseEntry(paramByteString.newCodedInput(), this.metadata, paramExtensionRegistryLite);
  }
  
  public void parseInto(MapFieldLite<K, V> paramMapFieldLite, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
    K k = this.metadata.defaultKey;
    V v = this.metadata.defaultValue;
    while (true) {
      int j = paramCodedInputStream.readTag();
      if (j == 0)
        break; 
      if (j == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) {
        k = parseField(paramCodedInputStream, paramExtensionRegistryLite, this.metadata.keyType, k);
        continue;
      } 
      if (j == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
        v = parseField(paramCodedInputStream, paramExtensionRegistryLite, this.metadata.valueType, v);
        continue;
      } 
      if (!paramCodedInputStream.skipField(j))
        break; 
    } 
    paramCodedInputStream.checkLastTagWas(0);
    paramCodedInputStream.popLimit(i);
    paramMapFieldLite.put(k, v);
  }
  
  public void serializeTo(CodedOutputStream paramCodedOutputStream, int paramInt, K paramK, V paramV) throws IOException {
    paramCodedOutputStream.writeTag(paramInt, 2);
    paramCodedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, paramK, paramV));
    writeTo(paramCodedOutputStream, this.metadata, paramK, paramV);
  }
  
  static class Metadata<K, V> {
    public final K defaultKey;
    
    public final V defaultValue;
    
    public final WireFormat.FieldType keyType;
    
    public final WireFormat.FieldType valueType;
    
    public Metadata(WireFormat.FieldType param1FieldType1, K param1K, WireFormat.FieldType param1FieldType2, V param1V) {
      this.keyType = param1FieldType1;
      this.defaultKey = param1K;
      this.valueType = param1FieldType2;
      this.defaultValue = param1V;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MapEntryLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
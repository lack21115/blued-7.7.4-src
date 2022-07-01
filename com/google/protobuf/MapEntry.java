package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class MapEntry<K, V> extends AbstractMessage {
  private volatile int cachedSerializedSize = -1;
  
  private final K key;
  
  private final Metadata<K, V> metadata;
  
  private final V value;
  
  private MapEntry(Descriptors.Descriptor paramDescriptor, WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV) {
    this.key = paramK;
    this.value = paramV;
    this.metadata = new Metadata<K, V>(paramDescriptor, this, paramFieldType1, paramFieldType2);
  }
  
  private MapEntry(Metadata<K, V> paramMetadata, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      this.metadata = paramMetadata;
      Map.Entry<K, V> entry = MapEntryLite.parseEntry(paramCodedInputStream, paramMetadata, paramExtensionRegistryLite);
      this.key = entry.getKey();
      this.value = entry.getValue();
      return;
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.setUnfinishedMessage(this);
    } catch (IOException iOException) {
      throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
    } 
  }
  
  private MapEntry(Metadata<K, V> paramMetadata, K paramK, V paramV) {
    this.key = paramK;
    this.value = paramV;
    this.metadata = paramMetadata;
  }
  
  private void checkFieldDescriptor(Descriptors.FieldDescriptor paramFieldDescriptor) {
    if (paramFieldDescriptor.getContainingType() == this.metadata.descriptor)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Wrong FieldDescriptor \"");
    stringBuilder.append(paramFieldDescriptor.getFullName());
    stringBuilder.append("\" used in message \"");
    stringBuilder.append(this.metadata.descriptor.getFullName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private static <V> boolean isInitialized(Metadata paramMetadata, V paramV) {
    return (paramMetadata.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) ? ((MessageLite)paramV).isInitialized() : true;
  }
  
  public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor paramDescriptor, WireFormat.FieldType paramFieldType1, K paramK, WireFormat.FieldType paramFieldType2, V paramV) {
    return new MapEntry<K, V>(paramDescriptor, paramFieldType1, paramK, paramFieldType2, paramV);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    for (Descriptors.FieldDescriptor fieldDescriptor : this.metadata.descriptor.getFields()) {
      if (hasField(fieldDescriptor))
        treeMap.put(fieldDescriptor, getField(fieldDescriptor)); 
    } 
    return (Map)Collections.unmodifiableMap(treeMap);
  }
  
  public MapEntry<K, V> getDefaultInstanceForType() {
    Metadata<K, V> metadata = this.metadata;
    return new MapEntry(metadata, metadata.defaultKey, this.metadata.defaultValue);
  }
  
  public Descriptors.Descriptor getDescriptorForType() {
    return this.metadata.descriptor;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor) {
    V v1;
    Descriptors.EnumValueDescriptor enumValueDescriptor;
    checkFieldDescriptor(paramFieldDescriptor);
    if (paramFieldDescriptor.getNumber() == 1) {
      K k = getKey();
    } else {
      v1 = getValue();
    } 
    V v2 = v1;
    if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM)
      enumValueDescriptor = paramFieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((Integer)v1).intValue()); 
    return enumValueDescriptor;
  }
  
  public K getKey() {
    return this.key;
  }
  
  final Metadata<K, V> getMetadata() {
    return this.metadata;
  }
  
  public Parser<MapEntry<K, V>> getParserForType() {
    return this.metadata.parser;
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt) {
    throw new RuntimeException("There is no repeated field in a map entry message.");
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor) {
    throw new RuntimeException("There is no repeated field in a map entry message.");
  }
  
  public int getSerializedSize() {
    if (this.cachedSerializedSize != -1)
      return this.cachedSerializedSize; 
    int i = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
    this.cachedSerializedSize = i;
    return i;
  }
  
  public UnknownFieldSet getUnknownFields() {
    return UnknownFieldSet.getDefaultInstance();
  }
  
  public V getValue() {
    return this.value;
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor) {
    checkFieldDescriptor(paramFieldDescriptor);
    return true;
  }
  
  public boolean isInitialized() {
    return isInitialized(this.metadata, this.value);
  }
  
  public Builder<K, V> newBuilderForType() {
    return new Builder<K, V>(this.metadata);
  }
  
  public Builder<K, V> toBuilder() {
    return new Builder<K, V>(this.metadata, this.key, this.value, true, true);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    MapEntryLite.writeTo(paramCodedOutputStream, this.metadata, this.key, this.value);
  }
  
  public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
    private boolean hasKey;
    
    private boolean hasValue;
    
    private K key;
    
    private final MapEntry.Metadata<K, V> metadata;
    
    private V value;
    
    private Builder(MapEntry.Metadata<K, V> param1Metadata) {
      this(param1Metadata, param1Metadata.defaultKey, param1Metadata.defaultValue, false, false);
    }
    
    private Builder(MapEntry.Metadata<K, V> param1Metadata, K param1K, V param1V, boolean param1Boolean1, boolean param1Boolean2) {
      this.metadata = param1Metadata;
      this.key = param1K;
      this.value = param1V;
      this.hasKey = param1Boolean1;
      this.hasValue = param1Boolean2;
    }
    
    private void checkFieldDescriptor(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.getContainingType() == this.metadata.descriptor)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Wrong FieldDescriptor \"");
      stringBuilder.append(param1FieldDescriptor.getFullName());
      stringBuilder.append("\" used in message \"");
      stringBuilder.append(this.metadata.descriptor.getFullName());
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public MapEntry<K, V> build() {
      MapEntry<K, V> mapEntry = buildPartial();
      if (mapEntry.isInitialized())
        return mapEntry; 
      throw newUninitializedMessageException(mapEntry);
    }
    
    public MapEntry<K, V> buildPartial() {
      return new MapEntry<K, V>(this.metadata, this.key, this.value);
    }
    
    public Builder<K, V> clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      checkFieldDescriptor(param1FieldDescriptor);
      if (param1FieldDescriptor.getNumber() == 1) {
        clearKey();
        return this;
      } 
      clearValue();
      return this;
    }
    
    public Builder<K, V> clearKey() {
      this.key = this.metadata.defaultKey;
      this.hasKey = false;
      return this;
    }
    
    public Builder<K, V> clearValue() {
      this.value = this.metadata.defaultValue;
      this.hasValue = false;
      return this;
    }
    
    public Builder<K, V> clone() {
      return new Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
      TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
      for (Descriptors.FieldDescriptor fieldDescriptor : this.metadata.descriptor.getFields()) {
        if (hasField(fieldDescriptor))
          treeMap.put(fieldDescriptor, getField(fieldDescriptor)); 
      } 
      return (Map)Collections.unmodifiableMap(treeMap);
    }
    
    public MapEntry<K, V> getDefaultInstanceForType() {
      MapEntry.Metadata<K, V> metadata = this.metadata;
      return new MapEntry<K, V>(metadata, metadata.defaultKey, this.metadata.defaultValue);
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return this.metadata.descriptor;
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      V v1;
      Descriptors.EnumValueDescriptor enumValueDescriptor;
      checkFieldDescriptor(param1FieldDescriptor);
      if (param1FieldDescriptor.getNumber() == 1) {
        K k = getKey();
      } else {
        v1 = getValue();
      } 
      V v2 = v1;
      if (param1FieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM)
        enumValueDescriptor = param1FieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((Integer)v1).intValue()); 
      return enumValueDescriptor;
    }
    
    public K getKey() {
      return this.key;
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor param1FieldDescriptor) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
    }
    
    public V getValue() {
      return this.value;
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      checkFieldDescriptor(param1FieldDescriptor);
      return (param1FieldDescriptor.getNumber() == 1) ? this.hasKey : this.hasValue;
    }
    
    public boolean isInitialized() {
      return MapEntry.isInitialized(this.metadata, this.value);
    }
    
    public Message.Builder newBuilderForField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      checkFieldDescriptor(param1FieldDescriptor);
      if (param1FieldDescriptor.getNumber() == 2 && param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        return ((Message)this.value).newBuilderForType(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\"");
      stringBuilder.append(param1FieldDescriptor.getFullName());
      stringBuilder.append("\" is not a message value field.");
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public Builder<K, V> setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      Object object;
      checkFieldDescriptor(param1FieldDescriptor);
      if (param1FieldDescriptor.getNumber() == 1) {
        setKey((K)param1Object);
        return this;
      } 
      if (param1FieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
        object = Integer.valueOf(((Descriptors.EnumValueDescriptor)param1Object).getNumber());
      } else {
        object = param1Object;
        if (param1FieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) {
          object = param1Object;
          if (param1Object != null) {
            object = param1Object;
            if (!this.metadata.defaultValue.getClass().isInstance(param1Object))
              object = ((Message)this.metadata.defaultValue).toBuilder().mergeFrom((Message)param1Object).build(); 
          } 
        } 
      } 
      setValue((V)object);
      return this;
    }
    
    public Builder<K, V> setKey(K param1K) {
      this.key = param1K;
      this.hasKey = true;
      return this;
    }
    
    public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public Builder<K, V> setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return this;
    }
    
    public Builder<K, V> setValue(V param1V) {
      this.value = param1V;
      this.hasValue = true;
      return this;
    }
  }
  
  static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
    public final Descriptors.Descriptor descriptor;
    
    public final Parser<MapEntry<K, V>> parser;
    
    public Metadata(Descriptors.Descriptor param1Descriptor, MapEntry<K, V> param1MapEntry, WireFormat.FieldType param1FieldType1, WireFormat.FieldType param1FieldType2) {
      super(param1FieldType1, param1MapEntry.key, param1FieldType2, param1MapEntry.value);
      this.descriptor = param1Descriptor;
      this.parser = new AbstractParser<MapEntry<K, V>>() {
          public MapEntry<K, V> parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
            return new MapEntry<K, V>(MapEntry.Metadata.this, param2CodedInputStream, param2ExtensionRegistryLite);
          }
        };
    }
  }
  
  class null extends AbstractParser<MapEntry<K, V>> {
    public MapEntry<K, V> parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new MapEntry<K, V>(this.this$0, param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
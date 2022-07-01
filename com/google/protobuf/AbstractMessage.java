package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractMessage extends AbstractMessageLite implements Message {
  protected int memoizedSize = -1;
  
  private static boolean compareBytes(Object paramObject1, Object paramObject2) {
    return (paramObject1 instanceof byte[] && paramObject2 instanceof byte[]) ? Arrays.equals((byte[])paramObject1, (byte[])paramObject2) : toByteString(paramObject1).equals(toByteString(paramObject2));
  }
  
  static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> paramMap1, Map<Descriptors.FieldDescriptor, Object> paramMap2) {
    if (paramMap1.size() != paramMap2.size())
      return false; 
    for (Descriptors.FieldDescriptor fieldDescriptor : paramMap1.keySet()) {
      List list;
      if (!paramMap2.containsKey(fieldDescriptor))
        return false; 
      Object object2 = paramMap1.get(fieldDescriptor);
      Object object1 = paramMap2.get(fieldDescriptor);
      if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
        if (fieldDescriptor.isRepeated()) {
          list = (List)object2;
          object1 = object1;
          if (list.size() != object1.size())
            return false; 
          for (int i = 0; i < list.size(); i++) {
            if (!compareBytes(list.get(i), object1.get(i)))
              return false; 
          } 
          continue;
        } 
        if (!compareBytes(object2, object1))
          return false; 
        continue;
      } 
      if (list.isMapField()) {
        if (!compareMapField(object2, object1))
          return false; 
        continue;
      } 
      if (!object2.equals(object1))
        return false; 
    } 
    return true;
  }
  
  private static boolean compareMapField(Object paramObject1, Object paramObject2) {
    return MapFieldLite.equals(convertMapEntryListToMap((List)paramObject1), convertMapEntryListToMap((List)paramObject2));
  }
  
  private static Map convertMapEntryListToMap(List paramList) {
    if (paramList.isEmpty())
      return Collections.emptyMap(); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<Message> iterator = paramList.iterator();
    Message message = iterator.next();
    Descriptors.Descriptor descriptor = message.getDescriptorForType();
    Descriptors.FieldDescriptor fieldDescriptor1 = descriptor.findFieldByName("key");
    Descriptors.FieldDescriptor fieldDescriptor2 = descriptor.findFieldByName("value");
    Object object2 = message.getField(fieldDescriptor2);
    Object object1 = object2;
    if (object2 instanceof Descriptors.EnumValueDescriptor)
      object1 = Integer.valueOf(((Descriptors.EnumValueDescriptor)object2).getNumber()); 
    hashMap.put(message.getField(fieldDescriptor1), object1);
    while (iterator.hasNext()) {
      message = iterator.next();
      object2 = message.getField(fieldDescriptor2);
      object1 = object2;
      if (object2 instanceof Descriptors.EnumValueDescriptor)
        object1 = Integer.valueOf(((Descriptors.EnumValueDescriptor)object2).getNumber()); 
      hashMap.put(message.getField(fieldDescriptor1), object1);
    } 
    return hashMap;
  }
  
  @Deprecated
  protected static int hashBoolean(boolean paramBoolean) {
    return paramBoolean ? 1231 : 1237;
  }
  
  @Deprecated
  protected static int hashEnum(Internal.EnumLite paramEnumLite) {
    return paramEnumLite.getNumber();
  }
  
  @Deprecated
  protected static int hashEnumList(List<? extends Internal.EnumLite> paramList) {
    Iterator<? extends Internal.EnumLite> iterator = paramList.iterator();
    int i;
    for (i = 1; iterator.hasNext(); i = i * 31 + hashEnum(iterator.next()));
    return i;
  }
  
  protected static int hashFields(int paramInt, Map<Descriptors.FieldDescriptor, Object> paramMap) {
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : paramMap.entrySet()) {
      int i;
      Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)entry.getKey();
      entry = (Map.Entry<Descriptors.FieldDescriptor, Object>)entry.getValue();
      paramInt = paramInt * 37 + fieldDescriptor.getNumber();
      if (fieldDescriptor.isMapField()) {
        i = paramInt * 53;
        paramInt = hashMapField(entry);
      } else if (fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
        i = paramInt * 53;
        paramInt = entry.hashCode();
      } else if (fieldDescriptor.isRepeated()) {
        List<? extends Internal.EnumLite> list = (List)entry;
        i = paramInt * 53;
        paramInt = Internal.hashEnumList(list);
      } else {
        i = paramInt * 53;
        paramInt = Internal.hashEnum((Internal.EnumLite)entry);
      } 
      paramInt = i + paramInt;
    } 
    return paramInt;
  }
  
  @Deprecated
  protected static int hashLong(long paramLong) {
    return (int)(paramLong ^ paramLong >>> 32L);
  }
  
  private static int hashMapField(Object paramObject) {
    return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List)paramObject));
  }
  
  private static ByteString toByteString(Object paramObject) {
    return (paramObject instanceof byte[]) ? ByteString.copyFrom((byte[])paramObject) : (ByteString)paramObject;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Message))
      return false; 
    paramObject = paramObject;
    return (getDescriptorForType() != paramObject.getDescriptorForType()) ? false : ((compareFields(getAllFields(), paramObject.getAllFields()) && getUnknownFields().equals(paramObject.getUnknownFields())));
  }
  
  public List<String> findInitializationErrors() {
    return MessageReflection.findMissingFields(this);
  }
  
  public String getInitializationErrorString() {
    return MessageReflection.delimitWithCommas(findInitializationErrors());
  }
  
  int getMemoizedSerializedSize() {
    return this.memoizedSize;
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor) {
    throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFields());
    return this.memoizedSize;
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor) {
    throw new UnsupportedOperationException("hasOneof() is not implemented.");
  }
  
  public int hashCode() {
    int j = this.memoizedHashCode;
    int i = j;
    if (j == 0) {
      i = hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29 + getUnknownFields().hashCode();
      this.memoizedHashCode = i;
    } 
    return i;
  }
  
  public boolean isInitialized() {
    return MessageReflection.isInitialized(this);
  }
  
  protected Message.Builder newBuilderForType(BuilderParent paramBuilderParent) {
    throw new UnsupportedOperationException("Nested builder is not supported for this type.");
  }
  
  UninitializedMessageException newUninitializedMessageException() {
    return Builder.newUninitializedMessageException(this);
  }
  
  void setMemoizedSerializedSize(int paramInt) {
    this.memoizedSize = paramInt;
  }
  
  public final String toString() {
    return TextFormat.printer().printToString(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    MessageReflection.writeMessageTo(this, getAllFields(), paramCodedOutputStream, false);
  }
  
  public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
    protected static UninitializedMessageException newUninitializedMessageException(Message param1Message) {
      return new UninitializedMessageException(MessageReflection.findMissingFields(param1Message));
    }
    
    public BuilderType clear() {
      Iterator<Map.Entry> iterator = getAllFields().entrySet().iterator();
      while (iterator.hasNext())
        clearField((Descriptors.FieldDescriptor)((Map.Entry)iterator.next()).getKey()); 
      return (BuilderType)this;
    }
    
    public BuilderType clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      throw new UnsupportedOperationException("clearOneof() is not implemented.");
    }
    
    public BuilderType clone() {
      throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
    }
    
    void dispose() {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
    
    public List<String> findInitializationErrors() {
      return MessageReflection.findMissingFields(this);
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor) {
      throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }
    
    public String getInitializationErrorString() {
      return MessageReflection.delimitWithCommas(findInitializationErrors());
    }
    
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor param1OneofDescriptor) {
      throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }
    
    public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
    }
    
    public boolean hasOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }
    
    protected BuilderType internalMergeFrom(AbstractMessageLite param1AbstractMessageLite) {
      return mergeFrom((Message)param1AbstractMessageLite);
    }
    
    void markClean() {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream) throws IOException {
      return super.mergeDelimitedFrom(param1InputStream);
    }
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return super.mergeDelimitedFrom(param1InputStream, param1ExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (BuilderType)super.mergeFrom(param1ByteString);
    }
    
    public BuilderType mergeFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BuilderType)super.mergeFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return mergeFrom(param1CodedInputStream, ExtensionRegistry.getEmptyRegistry());
    }
    
    public BuilderType mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i;
      UnknownFieldSet.Builder builder;
      MessageReflection.BuilderAdapter builderAdapter;
      if (param1CodedInputStream.shouldDiscardUnknownFields()) {
        builder = null;
      } else {
        builder = UnknownFieldSet.newBuilder(getUnknownFields());
      } 
      do {
        i = param1CodedInputStream.readTag();
        if (i == 0)
          break; 
        builderAdapter = new MessageReflection.BuilderAdapter(this);
      } while (MessageReflection.mergeFieldFrom(param1CodedInputStream, builder, param1ExtensionRegistryLite, getDescriptorForType(), builderAdapter, i));
      if (builder != null)
        setUnknownFields(builder.build()); 
      return (BuilderType)this;
    }
    
    public BuilderType mergeFrom(Message param1Message) {
      return mergeFrom(param1Message, param1Message.getAllFields());
    }
    
    BuilderType mergeFrom(Message param1Message, Map<Descriptors.FieldDescriptor, Object> param1Map) {
      if (param1Message.getDescriptorForType() == getDescriptorForType()) {
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : param1Map.entrySet()) {
          Iterator iterator;
          Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)entry.getKey();
          if (fieldDescriptor.isRepeated()) {
            iterator = ((List)entry.getValue()).iterator();
            while (iterator.hasNext())
              addRepeatedField(fieldDescriptor, iterator.next()); 
            continue;
          } 
          if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            Message message = (Message)getField(fieldDescriptor);
            if (message == message.getDefaultInstanceForType()) {
              setField(fieldDescriptor, iterator.getValue());
              continue;
            } 
            setField(fieldDescriptor, message.newBuilderForType().mergeFrom(message).mergeFrom((Message)iterator.getValue()).build());
            continue;
          } 
          setField(fieldDescriptor, iterator.getValue());
        } 
        mergeUnknownFields(param1Message.getUnknownFields());
        return (BuilderType)this;
      } 
      throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
    }
    
    public BuilderType mergeFrom(InputStream param1InputStream) throws IOException {
      return (BuilderType)super.mergeFrom(param1InputStream);
    }
    
    public BuilderType mergeFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BuilderType)super.mergeFrom(param1InputStream, param1ExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (BuilderType)super.mergeFrom(param1ArrayOfbyte);
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      return (BuilderType)super.mergeFrom(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BuilderType)super.mergeFrom(param1ArrayOfbyte, param1Int1, param1Int2, param1ExtensionRegistryLite);
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BuilderType)super.mergeFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public BuilderType mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(param1UnknownFieldSet).build());
      return (BuilderType)this;
    }
    
    public String toString() {
      return TextFormat.printer().printToString(this);
    }
  }
  
  public static interface BuilderParent {
    void markDirty();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\AbstractMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
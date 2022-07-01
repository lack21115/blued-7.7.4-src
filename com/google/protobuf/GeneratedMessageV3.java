package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessageV3 extends AbstractMessage implements Serializable {
  public static boolean alwaysUseFieldBuilders = false;
  
  private static final long serialVersionUID = 1L;
  
  public UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();
  
  public GeneratedMessageV3() {}
  
  public GeneratedMessageV3(Builder<?> paramBuilder) {}
  
  protected static boolean canUseUnsafe() {
    return (UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations());
  }
  
  private static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(ExtensionLite<MessageType, T> paramExtensionLite) {
    if (!paramExtensionLite.isLite())
      return (Extension<MessageType, T>)paramExtensionLite; 
    throw new IllegalArgumentException("Expected non-lite extension.");
  }
  
  public static int computeStringSize(int paramInt, Object paramObject) {
    return (paramObject instanceof String) ? CodedOutputStream.computeStringSize(paramInt, (String)paramObject) : CodedOutputStream.computeBytesSize(paramInt, (ByteString)paramObject);
  }
  
  protected static int computeStringSizeNoTag(Object paramObject) {
    return (paramObject instanceof String) ? CodedOutputStream.computeStringSizeNoTag((String)paramObject) : CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
  }
  
  protected static Internal.BooleanList emptyBooleanList() {
    return BooleanArrayList.emptyList();
  }
  
  public static Internal.DoubleList emptyDoubleList() {
    return DoubleArrayList.emptyList();
  }
  
  protected static Internal.FloatList emptyFloatList() {
    return FloatArrayList.emptyList();
  }
  
  public static Internal.IntList emptyIntList() {
    return IntArrayList.emptyList();
  }
  
  public static Internal.LongList emptyLongList() {
    return LongArrayList.emptyList();
  }
  
  static void enableAlwaysUseFieldBuildersForTesting() {
    setAlwaysUseFieldBuildersForTesting(true);
  }
  
  private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean paramBoolean) {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    List<Descriptors.FieldDescriptor> list = (internalGetFieldAccessorTable()).descriptor.getFields();
    for (int i = 0; i < list.size(); i = SYNTHETIC_LOCAL_VARIABLE_3 + 1) {
      Descriptors.FieldDescriptor fieldDescriptor1;
      Descriptors.FieldDescriptor fieldDescriptor2 = list.get(i);
      Descriptors.OneofDescriptor oneofDescriptor = fieldDescriptor2.getContainingOneof();
      if (oneofDescriptor != null) {
        int j = i + oneofDescriptor.getFieldCount() - 1;
        if (!hasOneof(oneofDescriptor))
          continue; 
        fieldDescriptor1 = getOneofFieldDescriptor(oneofDescriptor);
      } else {
        if (fieldDescriptor2.isRepeated()) {
          List list1 = (List)getField(fieldDescriptor2);
          int k = i;
          if (!list1.isEmpty()) {
            treeMap.put(fieldDescriptor2, list1);
            k = i;
          } 
          continue;
        } 
        int j = i;
        fieldDescriptor1 = fieldDescriptor2;
        if (!hasField(fieldDescriptor2)) {
          j = i;
          continue;
        } 
      } 
      if (paramBoolean && fieldDescriptor1.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
        treeMap.put(fieldDescriptor1, getFieldRaw(fieldDescriptor1));
      } else {
        treeMap.put(fieldDescriptor1, getField(fieldDescriptor1));
      } 
      continue;
    } 
    return (Map)treeMap;
  }
  
  private static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs) {
    try {
      return paramClass.getMethod(paramString, paramVarArgs);
    } catch (NoSuchMethodException noSuchMethodException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Generated message class \"");
      stringBuilder.append(paramClass.getName());
      stringBuilder.append("\" missing method \"");
      stringBuilder.append(paramString);
      stringBuilder.append("\".");
      throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
    } 
  }
  
  private static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getCause();
      if (!(throwable instanceof RuntimeException)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
      } 
      throw (RuntimeException)throwable;
    } 
  }
  
  private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream paramCodedOutputStream, Map<Boolean, V> paramMap, MapEntry<Boolean, V> paramMapEntry, int paramInt, boolean paramBoolean) throws IOException {
    if (paramMap.containsKey(Boolean.valueOf(paramBoolean)))
      paramCodedOutputStream.writeMessage(paramInt, paramMapEntry.newBuilderForType().setKey(Boolean.valueOf(paramBoolean)).setValue(paramMap.get(Boolean.valueOf(paramBoolean))).build()); 
  }
  
  protected static Internal.BooleanList mutableCopy(Internal.BooleanList paramBooleanList) {
    int i = paramBooleanList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramBooleanList.mutableCopyWithCapacity(i);
  }
  
  public static Internal.DoubleList mutableCopy(Internal.DoubleList paramDoubleList) {
    int i = paramDoubleList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramDoubleList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.FloatList mutableCopy(Internal.FloatList paramFloatList) {
    int i = paramFloatList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramFloatList.mutableCopyWithCapacity(i);
  }
  
  public static Internal.IntList mutableCopy(Internal.IntList paramIntList) {
    int i = paramIntList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramIntList.mutableCopyWithCapacity(i);
  }
  
  public static Internal.LongList mutableCopy(Internal.LongList paramLongList) {
    int i = paramLongList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramLongList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.BooleanList newBooleanList() {
    return new BooleanArrayList();
  }
  
  protected static Internal.DoubleList newDoubleList() {
    return new DoubleArrayList();
  }
  
  protected static Internal.FloatList newFloatList() {
    return new FloatArrayList();
  }
  
  protected static Internal.IntList newIntList() {
    return new IntArrayList();
  }
  
  protected static Internal.LongList newLongList() {
    return new LongArrayList();
  }
  
  public static <M extends Message> M parseDelimitedWithIOException(Parser<M> paramParser, InputStream paramInputStream) throws IOException {
    try {
      return paramParser.parseDelimitedFrom(paramInputStream);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.unwrapIOException();
    } 
  }
  
  public static <M extends Message> M parseDelimitedWithIOException(Parser<M> paramParser, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    try {
      return paramParser.parseDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.unwrapIOException();
    } 
  }
  
  public static <M extends Message> M parseWithIOException(Parser<M> paramParser, CodedInputStream paramCodedInputStream) throws IOException {
    try {
      return paramParser.parseFrom(paramCodedInputStream);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.unwrapIOException();
    } 
  }
  
  public static <M extends Message> M parseWithIOException(Parser<M> paramParser, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    try {
      return paramParser.parseFrom(paramCodedInputStream, paramExtensionRegistryLite);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.unwrapIOException();
    } 
  }
  
  public static <M extends Message> M parseWithIOException(Parser<M> paramParser, InputStream paramInputStream) throws IOException {
    try {
      return paramParser.parseFrom(paramInputStream);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.unwrapIOException();
    } 
  }
  
  public static <M extends Message> M parseWithIOException(Parser<M> paramParser, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    try {
      return paramParser.parseFrom(paramInputStream, paramExtensionRegistryLite);
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.unwrapIOException();
    } 
  }
  
  protected static <V> void serializeBooleanMapTo(CodedOutputStream paramCodedOutputStream, MapField<Boolean, V> paramMapField, MapEntry<Boolean, V> paramMapEntry, int paramInt) throws IOException {
    Map<Boolean, V> map = paramMapField.getMap();
    if (!paramCodedOutputStream.isSerializationDeterministic()) {
      serializeMapTo(paramCodedOutputStream, map, paramMapEntry, paramInt);
      return;
    } 
    maybeSerializeBooleanEntryTo(paramCodedOutputStream, map, paramMapEntry, paramInt, false);
    maybeSerializeBooleanEntryTo(paramCodedOutputStream, map, paramMapEntry, paramInt, true);
  }
  
  protected static <V> void serializeIntegerMapTo(CodedOutputStream paramCodedOutputStream, MapField<Integer, V> paramMapField, MapEntry<Integer, V> paramMapEntry, int paramInt) throws IOException {
    Map<Integer, V> map = paramMapField.getMap();
    if (!paramCodedOutputStream.isSerializationDeterministic()) {
      serializeMapTo(paramCodedOutputStream, map, paramMapEntry, paramInt);
      return;
    } 
    int[] arrayOfInt = new int[map.size()];
    Iterator iterator = map.keySet().iterator();
    int j = 0;
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfInt[i] = ((Integer)iterator.next()).intValue(); 
    Arrays.sort(arrayOfInt);
    int k = arrayOfInt.length;
    for (i = j; i < k; i++) {
      j = arrayOfInt[i];
      paramCodedOutputStream.writeMessage(paramInt, paramMapEntry.newBuilderForType().setKey(Integer.valueOf(j)).setValue(map.get(Integer.valueOf(j))).build());
    } 
  }
  
  protected static <V> void serializeLongMapTo(CodedOutputStream paramCodedOutputStream, MapField<Long, V> paramMapField, MapEntry<Long, V> paramMapEntry, int paramInt) throws IOException {
    Map<Long, V> map = paramMapField.getMap();
    if (!paramCodedOutputStream.isSerializationDeterministic()) {
      serializeMapTo(paramCodedOutputStream, map, paramMapEntry, paramInt);
      return;
    } 
    long[] arrayOfLong = new long[map.size()];
    Iterator iterator = map.keySet().iterator();
    boolean bool = false;
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfLong[i] = ((Long)iterator.next()).longValue(); 
    Arrays.sort(arrayOfLong);
    int j = arrayOfLong.length;
    for (i = bool; i < j; i++) {
      long l = arrayOfLong[i];
      paramCodedOutputStream.writeMessage(paramInt, paramMapEntry.newBuilderForType().setKey(Long.valueOf(l)).setValue(map.get(Long.valueOf(l))).build());
    } 
  }
  
  private static <K, V> void serializeMapTo(CodedOutputStream paramCodedOutputStream, Map<K, V> paramMap, MapEntry<K, V> paramMapEntry, int paramInt) throws IOException {
    for (Map.Entry<K, V> entry : paramMap.entrySet())
      paramCodedOutputStream.writeMessage(paramInt, paramMapEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build()); 
  }
  
  public static <V> void serializeStringMapTo(CodedOutputStream paramCodedOutputStream, MapField<String, V> paramMapField, MapEntry<String, V> paramMapEntry, int paramInt) throws IOException {
    Map<String, V> map = paramMapField.getMap();
    if (!paramCodedOutputStream.isSerializationDeterministic()) {
      serializeMapTo(paramCodedOutputStream, map, paramMapEntry, paramInt);
      return;
    } 
    String[] arrayOfString = new String[map.size()];
    arrayOfString = (String[])map.keySet().toArray((Object[])arrayOfString);
    Arrays.sort((Object[])arrayOfString);
    int j = arrayOfString.length;
    int i;
    for (i = 0; i < j; i++) {
      String str = arrayOfString[i];
      paramCodedOutputStream.writeMessage(paramInt, paramMapEntry.newBuilderForType().setKey(str).setValue(map.get(str)).build());
    } 
  }
  
  static void setAlwaysUseFieldBuildersForTesting(boolean paramBoolean) {
    alwaysUseFieldBuilders = paramBoolean;
  }
  
  public static void writeString(CodedOutputStream paramCodedOutputStream, int paramInt, Object paramObject) throws IOException {
    if (paramObject instanceof String) {
      paramCodedOutputStream.writeString(paramInt, (String)paramObject);
      return;
    } 
    paramCodedOutputStream.writeBytes(paramInt, (ByteString)paramObject);
  }
  
  protected static void writeStringNoTag(CodedOutputStream paramCodedOutputStream, Object paramObject) throws IOException {
    if (paramObject instanceof String) {
      paramCodedOutputStream.writeStringNoTag((String)paramObject);
      return;
    } 
    paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
    return Collections.unmodifiableMap(getAllFieldsMutable(false));
  }
  
  Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
    return Collections.unmodifiableMap(getAllFieldsMutable(true));
  }
  
  public Descriptors.Descriptor getDescriptorForType() {
    return (internalGetFieldAccessorTable()).descriptor;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor) {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).get(this);
  }
  
  Object getFieldRaw(Descriptors.FieldDescriptor paramFieldDescriptor) {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).getRaw(this);
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor) {
    return internalGetFieldAccessorTable().getOneof(paramOneofDescriptor).get(this);
  }
  
  public Parser<? extends GeneratedMessageV3> getParserForType() {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt) {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).getRepeated(this, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor) {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).getRepeatedCount(this);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
    return this.memoizedSize;
  }
  
  public UnknownFieldSet getUnknownFields() {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor) {
    return internalGetFieldAccessorTable().getField(paramFieldDescriptor).has(this);
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor) {
    return internalGetFieldAccessorTable().getOneof(paramOneofDescriptor).has(this);
  }
  
  protected abstract FieldAccessorTable internalGetFieldAccessorTable();
  
  protected MapField internalGetMapField(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No map fields found in ");
    stringBuilder.append(getClass().getName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public boolean isInitialized() {
    for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
      if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor))
        return false; 
      if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        Iterator<Message> iterator;
        if (fieldDescriptor.isRepeated()) {
          iterator = ((List)getField(fieldDescriptor)).iterator();
          while (iterator.hasNext()) {
            if (!((Message)iterator.next()).isInitialized())
              return false; 
          } 
          continue;
        } 
        if (hasField((Descriptors.FieldDescriptor)iterator) && !((Message)getField((Descriptors.FieldDescriptor)iterator)).isInitialized())
          return false; 
      } 
    } 
    return true;
  }
  
  protected void makeExtensionsImmutable() {}
  
  protected void mergeFromAndMakeImmutableInternal(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    Schema<GeneratedMessageV3> schema = Protobuf.getInstance().schemaFor(this);
    try {
      schema.mergeFrom(this, CodedInputStreamReader.forCodedInput(paramCodedInputStream), paramExtensionRegistryLite);
      schema.makeImmutable(this);
      return;
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.setUnfinishedMessage(this);
    } catch (IOException iOException) {
      throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
    } 
  }
  
  protected Message.Builder newBuilderForType(final AbstractMessage.BuilderParent parent) {
    return newBuilderForType(new BuilderParent() {
          public void markDirty() {
            parent.markDirty();
          }
        });
  }
  
  protected abstract Message.Builder newBuilderForType(BuilderParent paramBuilderParent);
  
  protected Object newInstance(UnusedPrivateParameter paramUnusedPrivateParameter) {
    throw new UnsupportedOperationException("This method must be overridden by the subclass.");
  }
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt) throws IOException {
    return paramCodedInputStream.shouldDiscardUnknownFields() ? paramCodedInputStream.skipField(paramInt) : paramBuilder.mergeFieldFrom(paramInt, paramCodedInputStream);
  }
  
  protected boolean parseUnknownFieldProto3(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt) throws IOException {
    return parseUnknownField(paramCodedInputStream, paramBuilder, paramExtensionRegistryLite, paramInt);
  }
  
  protected Object writeReplace() throws ObjectStreamException {
    return new GeneratedMessageLite.SerializedForm(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    MessageReflection.writeMessageTo(this, getAllFieldsRaw(), paramCodedOutputStream, false);
  }
  
  public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {
    private GeneratedMessageV3.BuilderParent builderParent;
    
    private boolean isClean;
    
    private BuilderParentImpl meAsParent;
    
    private UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();
    
    public Builder() {
      this((GeneratedMessageV3.BuilderParent)null);
    }
    
    public Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      this.builderParent = param1BuilderParent;
    }
    
    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
      TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
      List<Descriptors.FieldDescriptor> list = (internalGetFieldAccessorTable()).descriptor.getFields();
      for (int i = 0; i < list.size(); i = SYNTHETIC_LOCAL_VARIABLE_2 + 1) {
        Descriptors.FieldDescriptor fieldDescriptor1;
        Descriptors.FieldDescriptor fieldDescriptor2 = list.get(i);
        Descriptors.OneofDescriptor oneofDescriptor = fieldDescriptor2.getContainingOneof();
        if (oneofDescriptor != null) {
          int j = i + oneofDescriptor.getFieldCount() - 1;
          if (!hasOneof(oneofDescriptor))
            continue; 
          fieldDescriptor1 = getOneofFieldDescriptor(oneofDescriptor);
        } else {
          if (fieldDescriptor2.isRepeated()) {
            List list1 = (List)getField(fieldDescriptor2);
            int k = i;
            if (!list1.isEmpty()) {
              treeMap.put(fieldDescriptor2, list1);
              k = i;
            } 
            continue;
          } 
          int j = i;
          fieldDescriptor1 = fieldDescriptor2;
          if (!hasField(fieldDescriptor2)) {
            j = i;
            continue;
          } 
        } 
        treeMap.put(fieldDescriptor1, getField(fieldDescriptor1));
        continue;
      } 
      return (Map)treeMap;
    }
    
    private BuilderType setUnknownFieldsInternal(UnknownFieldSet param1UnknownFieldSet) {
      this.unknownFields = param1UnknownFieldSet;
      onChanged();
      return (BuilderType)this;
    }
    
    public BuilderType addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      internalGetFieldAccessorTable().getField(param1FieldDescriptor).addRepeated(this, param1Object);
      return (BuilderType)this;
    }
    
    public BuilderType clear() {
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      onChanged();
      return (BuilderType)this;
    }
    
    public BuilderType clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      internalGetFieldAccessorTable().getField(param1FieldDescriptor).clear(this);
      return (BuilderType)this;
    }
    
    public BuilderType clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      internalGetFieldAccessorTable().getOneof(param1OneofDescriptor).clear(this);
      return (BuilderType)this;
    }
    
    public BuilderType clone() {
      Builder builder = (Builder)getDefaultInstanceForType().newBuilderForType();
      builder.mergeFrom(buildPartial());
      return (BuilderType)builder;
    }
    
    void dispose() {
      this.builderParent = null;
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
      return Collections.unmodifiableMap(getAllFieldsMutable());
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return (internalGetFieldAccessorTable()).descriptor;
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      Object object = internalGetFieldAccessorTable().getField(param1FieldDescriptor).get(this);
      return param1FieldDescriptor.isRepeated() ? Collections.unmodifiableList((List)object) : object;
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return internalGetFieldAccessorTable().getField(param1FieldDescriptor).getBuilder(this);
    }
    
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return internalGetFieldAccessorTable().getOneof(param1OneofDescriptor).get(this);
    }
    
    protected GeneratedMessageV3.BuilderParent getParentForChildren() {
      if (this.meAsParent == null)
        this.meAsParent = new BuilderParentImpl(); 
      return this.meAsParent;
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      return internalGetFieldAccessorTable().getField(param1FieldDescriptor).getRepeated(this, param1Int);
    }
    
    public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      return internalGetFieldAccessorTable().getField(param1FieldDescriptor).getRepeatedBuilder(this, param1Int);
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return internalGetFieldAccessorTable().getField(param1FieldDescriptor).getRepeatedCount(this);
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return internalGetFieldAccessorTable().getField(param1FieldDescriptor).has(this);
    }
    
    public boolean hasOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return internalGetFieldAccessorTable().getOneof(param1OneofDescriptor).has(this);
    }
    
    protected abstract GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable();
    
    protected MapField internalGetMapField(int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No map fields found in ");
      stringBuilder.append(getClass().getName());
      throw new RuntimeException(stringBuilder.toString());
    }
    
    protected MapField internalGetMutableMapField(int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No map fields found in ");
      stringBuilder.append(getClass().getName());
      throw new RuntimeException(stringBuilder.toString());
    }
    
    protected boolean isClean() {
      return this.isClean;
    }
    
    public boolean isInitialized() {
      for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
        if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor))
          return false; 
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          Iterator<Message> iterator;
          if (fieldDescriptor.isRepeated()) {
            iterator = ((List)getField(fieldDescriptor)).iterator();
            while (iterator.hasNext()) {
              if (!((Message)iterator.next()).isInitialized())
                return false; 
            } 
            continue;
          } 
          if (hasField((Descriptors.FieldDescriptor)iterator) && !((Message)getField((Descriptors.FieldDescriptor)iterator)).isInitialized())
            return false; 
        } 
      } 
      return true;
    }
    
    protected void markClean() {
      this.isClean = true;
    }
    
    public BuilderType mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return setUnknownFields(UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(param1UnknownFieldSet).build());
    }
    
    public Message.Builder newBuilderForField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return internalGetFieldAccessorTable().getField(param1FieldDescriptor).newBuilder();
    }
    
    protected void onBuilt() {
      if (this.builderParent != null)
        markClean(); 
    }
    
    protected final void onChanged() {
      if (this.isClean) {
        GeneratedMessageV3.BuilderParent builderParent = this.builderParent;
        if (builderParent != null) {
          builderParent.markDirty();
          this.isClean = false;
        } 
      } 
    }
    
    public BuilderType setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      internalGetFieldAccessorTable().getField(param1FieldDescriptor).set(this, param1Object);
      return (BuilderType)this;
    }
    
    public BuilderType setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      internalGetFieldAccessorTable().getField(param1FieldDescriptor).setRepeated(this, param1Int, param1Object);
      return (BuilderType)this;
    }
    
    public BuilderType setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return setUnknownFieldsInternal(param1UnknownFieldSet);
    }
    
    protected BuilderType setUnknownFieldsProto3(UnknownFieldSet param1UnknownFieldSet) {
      return setUnknownFieldsInternal(param1UnknownFieldSet);
    }
    
    class BuilderParentImpl implements GeneratedMessageV3.BuilderParent {
      private BuilderParentImpl() {}
      
      public void markDirty() {
        GeneratedMessageV3.Builder.this.onChanged();
      }
    }
  }
  
  class BuilderParentImpl implements BuilderParent {
    private BuilderParentImpl() {}
    
    public void markDirty() {
      GeneratedMessageV3.Builder.this.onChanged();
    }
  }
  
  public static interface BuilderParent extends AbstractMessage.BuilderParent {}
  
  public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
    private FieldSet.Builder<Descriptors.FieldDescriptor> extensions;
    
    protected ExtendableBuilder() {}
    
    protected ExtendableBuilder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
    }
    
    private FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
      FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
      return (builder == null) ? FieldSet.emptySet() : builder.build();
    }
    
    private void ensureExtensionsIsMutable() {
      if (this.extensions == null)
        this.extensions = FieldSet.newBuilder(); 
    }
    
    private void verifyContainingType(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.getContainingType() == getDescriptorForType())
        return; 
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
    
    private void verifyExtensionContainingType(Extension<MessageType, ?> param1Extension) {
      if (param1Extension.getDescriptor().getContainingType() == getDescriptorForType())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Extension is for type \"");
      stringBuilder.append(param1Extension.getDescriptor().getContainingType().getFullName());
      stringBuilder.append("\" which does not match message type \"");
      stringBuilder.append(getDescriptorForType().getFullName());
      stringBuilder.append("\".");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public final <Type> BuilderType addExtension(Extension<MessageType, List<Type>> param1Extension, Type param1Type) {
      return addExtension(param1Extension, param1Type);
    }
    
    public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, Type param1Type) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      ensureExtensionsIsMutable();
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      this.extensions.addRepeatedField(fieldDescriptor, param1ExtensionLite.singularToReflectionType(param1Type));
      onChanged();
      return (BuilderType)this;
    }
    
    public <Type> BuilderType addExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension, Type param1Type) {
      return addExtension(param1GeneratedExtension, param1Type);
    }
    
    public BuilderType addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        ensureExtensionsIsMutable();
        this.extensions.addRepeatedField(param1FieldDescriptor, param1Object);
        onChanged();
        return (BuilderType)this;
      } 
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public BuilderType clear() {
      this.extensions = null;
      return super.clear();
    }
    
    public final <Type> BuilderType clearExtension(Extension<MessageType, ?> param1Extension) {
      return clearExtension(param1Extension);
    }
    
    public final BuilderType clearExtension(ExtensionLite<MessageType, ?> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      ensureExtensionsIsMutable();
      this.extensions.clearField(param1ExtensionLite.getDescriptor());
      onChanged();
      return (BuilderType)this;
    }
    
    public <Type> BuilderType clearExtension(GeneratedMessage.GeneratedExtension<MessageType, ?> param1GeneratedExtension) {
      return clearExtension(param1GeneratedExtension);
    }
    
    public BuilderType clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        ensureExtensionsIsMutable();
        this.extensions.clearField(param1FieldDescriptor);
        onChanged();
        return (BuilderType)this;
      } 
      return super.clearField(param1FieldDescriptor);
    }
    
    protected boolean extensionsAreInitialized() {
      FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
      return (builder == null) ? true : builder.isInitialized();
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
      Map<? extends Descriptors.FieldDescriptor, ?> map = getAllFieldsMutable();
      FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
      if (builder != null)
        map.putAll(builder.getAllFields()); 
      return Collections.unmodifiableMap(map);
    }
    
    public final <Type> Type getExtension(Extension<MessageType, Type> param1Extension) {
      return getExtension(param1Extension);
    }
    
    public final <Type> Type getExtension(Extension<MessageType, List<Type>> param1Extension, int param1Int) {
      return getExtension(param1Extension, param1Int);
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      Extension<MessageType, ?> extension = GeneratedMessageV3.checkNotLite(param1ExtensionLite);
      verifyExtensionContainingType(extension);
      Descriptors.FieldDescriptor fieldDescriptor = extension.getDescriptor();
      Object object = this.extensions;
      if (object == null) {
        object = null;
      } else {
        object = object.getField(fieldDescriptor);
      } 
      return (Type)((object == null) ? (fieldDescriptor.isRepeated() ? Collections.emptyList() : ((fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) ? extension.getMessageDefaultInstance() : extension.fromReflectionType(fieldDescriptor.getDefaultValue()))) : extension.fromReflectionType(object));
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
      if (builder != null)
        return (Type)param1ExtensionLite.singularFromReflectionType(builder.getRepeatedField(fieldDescriptor, param1Int)); 
      throw new IndexOutOfBoundsException();
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension) {
      return getExtension(param1GeneratedExtension);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension, int param1Int) {
      return getExtension(param1GeneratedExtension, param1Int);
    }
    
    public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> param1Extension) {
      return getExtensionCount(param1Extension);
    }
    
    public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> param1ExtensionLite) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
      return (builder == null) ? 0 : builder.getRepeatedFieldCount(fieldDescriptor);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension) {
      return getExtensionCount(param1GeneratedExtension);
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        Object object = this.extensions;
        if (object == null) {
          object = null;
        } else {
          object = object.getField(param1FieldDescriptor);
        } 
        return (object == null) ? ((param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) ? DynamicMessage.getDefaultInstance(param1FieldDescriptor.getMessageType()) : param1FieldDescriptor.getDefaultValue()) : object;
      } 
      return super.getField(param1FieldDescriptor);
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          ensureExtensionsIsMutable();
          Object object = this.extensions.getFieldAllowBuilders(param1FieldDescriptor);
          if (object == null) {
            object = DynamicMessage.newBuilder(param1FieldDescriptor.getMessageType());
            this.extensions.setField(param1FieldDescriptor, object);
            onChanged();
            return (Message.Builder)object;
          } 
          if (object instanceof Message.Builder)
            return (Message.Builder)object; 
          if (object instanceof Message) {
            object = ((Message)object).toBuilder();
            this.extensions.setField(param1FieldDescriptor, object);
            onChanged();
            return (Message.Builder)object;
          } 
          throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        } 
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      } 
      return super.getFieldBuilder(param1FieldDescriptor);
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
        if (builder != null)
          return builder.getRepeatedField(param1FieldDescriptor, param1Int); 
        throw new IndexOutOfBoundsException();
      } 
      return super.getRepeatedField(param1FieldDescriptor, param1Int);
    }
    
    public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        ensureExtensionsIsMutable();
        if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          Object object = this.extensions.getRepeatedFieldAllowBuilders(param1FieldDescriptor, param1Int);
          if (object instanceof Message.Builder)
            return (Message.Builder)object; 
          if (object instanceof Message) {
            object = ((Message)object).toBuilder();
            this.extensions.setRepeatedField(param1FieldDescriptor, param1Int, object);
            onChanged();
            return (Message.Builder)object;
          } 
          throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        } 
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
      } 
      return super.getRepeatedFieldBuilder(param1FieldDescriptor, param1Int);
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
        return (builder == null) ? 0 : builder.getRepeatedFieldCount(param1FieldDescriptor);
      } 
      return super.getRepeatedFieldCount(param1FieldDescriptor);
    }
    
    public final <Type> boolean hasExtension(Extension<MessageType, Type> param1Extension) {
      return hasExtension(param1Extension);
    }
    
    public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageV3.checkNotLite(param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
      return (builder == null) ? false : builder.hasField(param1ExtensionLite.getDescriptor());
    }
    
    public final <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension) {
      return hasExtension(param1GeneratedExtension);
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
        return (builder == null) ? false : builder.hasField(param1FieldDescriptor);
      } 
      return super.hasField(param1FieldDescriptor);
    }
    
    void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> param1FieldSet) {
      this.extensions = FieldSet.Builder.fromFieldSet(param1FieldSet);
    }
    
    public boolean isInitialized() {
      return (super.isInitialized() && extensionsAreInitialized());
    }
    
    protected final void mergeExtensionFields(GeneratedMessageV3.ExtendableMessage param1ExtendableMessage) {
      if (param1ExtendableMessage.extensions != null) {
        ensureExtensionsIsMutable();
        this.extensions.mergeFrom(param1ExtendableMessage.extensions);
        onChanged();
      } 
    }
    
    public Message.Builder newBuilderForField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return param1FieldDescriptor.isExtension() ? DynamicMessage.newBuilder(param1FieldDescriptor.getMessageType()) : super.newBuilderForField(param1FieldDescriptor);
    }
    
    public final <Type> BuilderType setExtension(Extension<MessageType, List<Type>> param1Extension, int param1Int, Type param1Type) {
      return setExtension(param1Extension, param1Int, param1Type);
    }
    
    public final <Type> BuilderType setExtension(Extension<MessageType, Type> param1Extension, Type param1Type) {
      return setExtension(param1Extension, param1Type);
    }
    
    public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int, Type param1Type) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      ensureExtensionsIsMutable();
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      this.extensions.setRepeatedField(fieldDescriptor, param1Int, param1ExtensionLite.singularToReflectionType(param1Type));
      onChanged();
      return (BuilderType)this;
    }
    
    public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> param1ExtensionLite, Type param1Type) {
      param1ExtensionLite = GeneratedMessageV3.checkNotLite(param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      ensureExtensionsIsMutable();
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      this.extensions.setField(fieldDescriptor, param1ExtensionLite.toReflectionType(param1Type));
      onChanged();
      return (BuilderType)this;
    }
    
    public <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension, int param1Int, Type param1Type) {
      return setExtension(param1GeneratedExtension, param1Int, param1Type);
    }
    
    public <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension, Type param1Type) {
      return setExtension(param1GeneratedExtension, param1Type);
    }
    
    public BuilderType setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        ensureExtensionsIsMutable();
        this.extensions.setField(param1FieldDescriptor, param1Object);
        onChanged();
        return (BuilderType)this;
      } 
      return super.setField(param1FieldDescriptor, param1Object);
    }
    
    public BuilderType setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        ensureExtensionsIsMutable();
        this.extensions.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
        onChanged();
        return (BuilderType)this;
      } 
      return super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessageV3 implements ExtendableMessageOrBuilder<MessageType> {
    private static final long serialVersionUID = 1L;
    
    final FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.newFieldSet();
    
    protected ExtendableMessage() {}
    
    protected ExtendableMessage(GeneratedMessageV3.ExtendableBuilder<MessageType, ?> param1ExtendableBuilder) {
      super(param1ExtendableBuilder);
    }
    
    private void verifyContainingType(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.getContainingType() == getDescriptorForType())
        return; 
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
    
    private void verifyExtensionContainingType(Extension<MessageType, ?> param1Extension) {
      if (param1Extension.getDescriptor().getContainingType() == getDescriptorForType())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Extension is for type \"");
      stringBuilder.append(param1Extension.getDescriptor().getContainingType().getFullName());
      stringBuilder.append("\" which does not match message type \"");
      stringBuilder.append(getDescriptorForType().getFullName());
      stringBuilder.append("\".");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    protected boolean extensionsAreInitialized() {
      return this.extensions.isInitialized();
    }
    
    protected int extensionsSerializedSize() {
      return this.extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet() {
      return this.extensions.getMessageSetSerializedSize();
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
      Map<Descriptors.FieldDescriptor, Object> map = getAllFieldsMutable(false);
      map.putAll(getExtensionFields());
      return Collections.unmodifiableMap(map);
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
      Map<Descriptors.FieldDescriptor, Object> map = getAllFieldsMutable(false);
      map.putAll(getExtensionFields());
      return Collections.unmodifiableMap(map);
    }
    
    public final <Type> Type getExtension(Extension<MessageType, Type> param1Extension) {
      return getExtension(param1Extension);
    }
    
    public final <Type> Type getExtension(Extension<MessageType, List<Type>> param1Extension, int param1Int) {
      return getExtension(param1Extension, param1Int);
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageV3.checkNotLite(param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      Object object = this.extensions.getField(fieldDescriptor);
      return (Type)((object == null) ? (fieldDescriptor.isRepeated() ? Collections.emptyList() : ((fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) ? param1ExtensionLite.getMessageDefaultInstance() : param1ExtensionLite.fromReflectionType(fieldDescriptor.getDefaultValue()))) : param1ExtensionLite.fromReflectionType(object));
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      return (Type)param1ExtensionLite.singularFromReflectionType(this.extensions.getRepeatedField(fieldDescriptor, param1Int));
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension) {
      return getExtension(param1GeneratedExtension);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension, int param1Int) {
      return getExtension(param1GeneratedExtension, param1Int);
    }
    
    public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> param1Extension) {
      return getExtensionCount(param1Extension);
    }
    
    public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> param1ExtensionLite) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageV3.checkNotLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      Descriptors.FieldDescriptor fieldDescriptor = param1ExtensionLite.getDescriptor();
      return this.extensions.getRepeatedFieldCount(fieldDescriptor);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension) {
      return getExtensionCount(param1GeneratedExtension);
    }
    
    protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
      return this.extensions.getAllFields();
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        Object object = this.extensions.getField(param1FieldDescriptor);
        return (object == null) ? (param1FieldDescriptor.isRepeated() ? Collections.emptyList() : ((param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) ? DynamicMessage.getDefaultInstance(param1FieldDescriptor.getMessageType()) : param1FieldDescriptor.getDefaultValue())) : object;
      } 
      return super.getField(param1FieldDescriptor);
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        return this.extensions.getRepeatedField(param1FieldDescriptor, param1Int);
      } 
      return super.getRepeatedField(param1FieldDescriptor, param1Int);
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        return this.extensions.getRepeatedFieldCount(param1FieldDescriptor);
      } 
      return super.getRepeatedFieldCount(param1FieldDescriptor);
    }
    
    public final <Type> boolean hasExtension(Extension<MessageType, Type> param1Extension) {
      return hasExtension(param1Extension);
    }
    
    public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageV3.checkNotLite(param1ExtensionLite);
      verifyExtensionContainingType((Extension<MessageType, ?>)param1ExtensionLite);
      return this.extensions.hasField(param1ExtensionLite.getDescriptor());
    }
    
    public final <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension) {
      return hasExtension(param1GeneratedExtension);
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.isExtension()) {
        verifyContainingType(param1FieldDescriptor);
        return this.extensions.hasField(param1FieldDescriptor);
      } 
      return super.hasField(param1FieldDescriptor);
    }
    
    public boolean isInitialized() {
      return (super.isInitialized() && extensionsAreInitialized());
    }
    
    protected void makeExtensionsImmutable() {
      this.extensions.makeImmutable();
    }
    
    protected ExtensionWriter newExtensionWriter() {
      return new ExtensionWriter(false);
    }
    
    protected ExtensionWriter newMessageSetExtensionWriter() {
      return new ExtensionWriter(true);
    }
    
    protected boolean parseUnknownField(CodedInputStream param1CodedInputStream, UnknownFieldSet.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite, int param1Int) throws IOException {
      if (param1CodedInputStream.shouldDiscardUnknownFields())
        param1Builder = null; 
      return MessageReflection.mergeFieldFrom(param1CodedInputStream, param1Builder, param1ExtensionRegistryLite, getDescriptorForType(), new MessageReflection.ExtensionAdapter(this.extensions), param1Int);
    }
    
    protected boolean parseUnknownFieldProto3(CodedInputStream param1CodedInputStream, UnknownFieldSet.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite, int param1Int) throws IOException {
      return parseUnknownField(param1CodedInputStream, param1Builder, param1ExtensionRegistryLite, param1Int);
    }
    
    public class ExtensionWriter {
      private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter = GeneratedMessageV3.ExtendableMessage.this.extensions.iterator();
      
      private final boolean messageSetWireFormat;
      
      private Map.Entry<Descriptors.FieldDescriptor, Object> next;
      
      private ExtensionWriter(boolean param2Boolean) {
        if (this.iter.hasNext())
          this.next = this.iter.next(); 
        this.messageSetWireFormat = param2Boolean;
      }
      
      public void writeUntil(int param2Int, CodedOutputStream param2CodedOutputStream) throws IOException {
        while (true) {
          Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.next;
          if (entry != null && ((Descriptors.FieldDescriptor)entry.getKey()).getNumber() < param2Int) {
            Descriptors.FieldDescriptor fieldDescriptor = this.next.getKey();
            if (this.messageSetWireFormat && fieldDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fieldDescriptor.isRepeated()) {
              if (this.next instanceof LazyField.LazyEntry) {
                param2CodedOutputStream.writeRawMessageSetExtension(fieldDescriptor.getNumber(), ((LazyField.LazyEntry)this.next).getField().toByteString());
              } else {
                param2CodedOutputStream.writeMessageSetExtension(fieldDescriptor.getNumber(), (Message)this.next.getValue());
              } 
            } else {
              FieldSet.writeField(fieldDescriptor, this.next.getValue(), param2CodedOutputStream);
            } 
            if (this.iter.hasNext()) {
              this.next = this.iter.next();
              continue;
            } 
            this.next = null;
            continue;
          } 
          break;
        } 
      }
    }
  }
  
  public class ExtensionWriter {
    private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter = GeneratedMessageV3.ExtendableMessage.this.extensions.iterator();
    
    private final boolean messageSetWireFormat;
    
    private Map.Entry<Descriptors.FieldDescriptor, Object> next;
    
    private ExtensionWriter(boolean param1Boolean) {
      if (this.iter.hasNext())
        this.next = this.iter.next(); 
      this.messageSetWireFormat = param1Boolean;
    }
    
    public void writeUntil(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      while (true) {
        Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.next;
        if (entry != null && ((Descriptors.FieldDescriptor)entry.getKey()).getNumber() < param1Int) {
          Descriptors.FieldDescriptor fieldDescriptor = this.next.getKey();
          if (this.messageSetWireFormat && fieldDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fieldDescriptor.isRepeated()) {
            if (this.next instanceof LazyField.LazyEntry) {
              param1CodedOutputStream.writeRawMessageSetExtension(fieldDescriptor.getNumber(), ((LazyField.LazyEntry)this.next).getField().toByteString());
            } else {
              param1CodedOutputStream.writeMessageSetExtension(fieldDescriptor.getNumber(), (Message)this.next.getValue());
            } 
          } else {
            FieldSet.writeField(fieldDescriptor, this.next.getValue(), param1CodedOutputStream);
          } 
          if (this.iter.hasNext()) {
            this.next = this.iter.next();
            continue;
          } 
          this.next = null;
          continue;
        } 
        break;
      } 
    }
  }
  
  public static interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
    Message getDefaultInstanceForType();
    
    <Type> Type getExtension(Extension<MessageType, Type> param1Extension);
    
    <Type> Type getExtension(Extension<MessageType, List<Type>> param1Extension, int param1Int);
    
    <Type> Type getExtension(ExtensionLite<MessageType, Type> param1ExtensionLite);
    
    <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int);
    
    <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension);
    
    <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension, int param1Int);
    
    <Type> int getExtensionCount(Extension<MessageType, List<Type>> param1Extension);
    
    <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> param1ExtensionLite);
    
    <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> param1GeneratedExtension);
    
    <Type> boolean hasExtension(Extension<MessageType, Type> param1Extension);
    
    <Type> boolean hasExtension(ExtensionLite<MessageType, Type> param1ExtensionLite);
    
    <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> param1GeneratedExtension);
  }
  
  static interface ExtensionDescriptorRetriever {
    Descriptors.FieldDescriptor getDescriptor();
  }
  
  public static final class FieldAccessorTable {
    private String[] camelCaseNames;
    
    private final Descriptors.Descriptor descriptor;
    
    private final FieldAccessor[] fields;
    
    private volatile boolean initialized;
    
    private final OneofAccessor[] oneofs;
    
    public FieldAccessorTable(Descriptors.Descriptor param1Descriptor, String[] param1ArrayOfString) {
      this.descriptor = param1Descriptor;
      this.camelCaseNames = param1ArrayOfString;
      this.fields = new FieldAccessor[param1Descriptor.getFields().size()];
      this.oneofs = new OneofAccessor[param1Descriptor.getOneofs().size()];
      this.initialized = false;
    }
    
    public FieldAccessorTable(Descriptors.Descriptor param1Descriptor, String[] param1ArrayOfString, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      this(param1Descriptor, param1ArrayOfString);
      ensureFieldAccessorsInitialized(param1Class, param1Class1);
    }
    
    private FieldAccessor getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.getContainingType() == this.descriptor) {
        if (!param1FieldDescriptor.isExtension())
          return this.fields[param1FieldDescriptor.getIndex()]; 
        throw new IllegalArgumentException("This type does not have extensions.");
      } 
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
    
    private OneofAccessor getOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      if (param1OneofDescriptor.getContainingType() == this.descriptor)
        return this.oneofs[param1OneofDescriptor.getIndex()]; 
      throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }
    
    public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      // Byte code:
      //   0: aload_0
      //   1: getfield initialized : Z
      //   4: ifeq -> 9
      //   7: aload_0
      //   8: areturn
      //   9: aload_0
      //   10: monitorenter
      //   11: aload_0
      //   12: getfield initialized : Z
      //   15: ifeq -> 22
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_0
      //   21: areturn
      //   22: aload_0
      //   23: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   26: arraylength
      //   27: istore #5
      //   29: iconst_0
      //   30: istore #4
      //   32: iconst_0
      //   33: istore_3
      //   34: aconst_null
      //   35: astore #7
      //   37: iload_3
      //   38: iload #5
      //   40: if_icmpge -> 374
      //   43: aload_0
      //   44: getfield descriptor : Lcom/google/protobuf/Descriptors$Descriptor;
      //   47: invokevirtual getFields : ()Ljava/util/List;
      //   50: iload_3
      //   51: invokeinterface get : (I)Ljava/lang/Object;
      //   56: checkcast com/google/protobuf/Descriptors$FieldDescriptor
      //   59: astore #8
      //   61: aload #8
      //   63: invokevirtual getContainingOneof : ()Lcom/google/protobuf/Descriptors$OneofDescriptor;
      //   66: ifnull -> 87
      //   69: aload_0
      //   70: getfield camelCaseNames : [Ljava/lang/String;
      //   73: aload #8
      //   75: invokevirtual getContainingOneof : ()Lcom/google/protobuf/Descriptors$OneofDescriptor;
      //   78: invokevirtual getIndex : ()I
      //   81: iload #5
      //   83: iadd
      //   84: aaload
      //   85: astore #7
      //   87: aload #8
      //   89: invokevirtual isRepeated : ()Z
      //   92: ifeq -> 229
      //   95: aload #8
      //   97: invokevirtual getJavaType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   100: getstatic com/google/protobuf/Descriptors$FieldDescriptor$JavaType.MESSAGE : Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   103: if_acmpne -> 166
      //   106: aload #8
      //   108: invokevirtual isMapField : ()Z
      //   111: ifeq -> 140
      //   114: aload_0
      //   115: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   118: iload_3
      //   119: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor
      //   122: dup
      //   123: aload #8
      //   125: aload_0
      //   126: getfield camelCaseNames : [Ljava/lang/String;
      //   129: iload_3
      //   130: aaload
      //   131: aload_1
      //   132: aload_2
      //   133: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V
      //   136: aastore
      //   137: goto -> 445
      //   140: aload_0
      //   141: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   144: iload_3
      //   145: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor
      //   148: dup
      //   149: aload #8
      //   151: aload_0
      //   152: getfield camelCaseNames : [Ljava/lang/String;
      //   155: iload_3
      //   156: aaload
      //   157: aload_1
      //   158: aload_2
      //   159: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V
      //   162: aastore
      //   163: goto -> 445
      //   166: aload #8
      //   168: invokevirtual getJavaType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   171: getstatic com/google/protobuf/Descriptors$FieldDescriptor$JavaType.ENUM : Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   174: if_acmpne -> 203
      //   177: aload_0
      //   178: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   181: iload_3
      //   182: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$RepeatedEnumFieldAccessor
      //   185: dup
      //   186: aload #8
      //   188: aload_0
      //   189: getfield camelCaseNames : [Ljava/lang/String;
      //   192: iload_3
      //   193: aaload
      //   194: aload_1
      //   195: aload_2
      //   196: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V
      //   199: aastore
      //   200: goto -> 445
      //   203: aload_0
      //   204: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   207: iload_3
      //   208: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor
      //   211: dup
      //   212: aload #8
      //   214: aload_0
      //   215: getfield camelCaseNames : [Ljava/lang/String;
      //   218: iload_3
      //   219: aaload
      //   220: aload_1
      //   221: aload_2
      //   222: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V
      //   225: aastore
      //   226: goto -> 445
      //   229: aload #8
      //   231: invokevirtual getJavaType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   234: getstatic com/google/protobuf/Descriptors$FieldDescriptor$JavaType.MESSAGE : Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   237: if_acmpne -> 268
      //   240: aload_0
      //   241: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   244: iload_3
      //   245: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$SingularMessageFieldAccessor
      //   248: dup
      //   249: aload #8
      //   251: aload_0
      //   252: getfield camelCaseNames : [Ljava/lang/String;
      //   255: iload_3
      //   256: aaload
      //   257: aload_1
      //   258: aload_2
      //   259: aload #7
      //   261: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V
      //   264: aastore
      //   265: goto -> 445
      //   268: aload #8
      //   270: invokevirtual getJavaType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   273: getstatic com/google/protobuf/Descriptors$FieldDescriptor$JavaType.ENUM : Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   276: if_acmpne -> 307
      //   279: aload_0
      //   280: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   283: iload_3
      //   284: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor
      //   287: dup
      //   288: aload #8
      //   290: aload_0
      //   291: getfield camelCaseNames : [Ljava/lang/String;
      //   294: iload_3
      //   295: aaload
      //   296: aload_1
      //   297: aload_2
      //   298: aload #7
      //   300: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V
      //   303: aastore
      //   304: goto -> 445
      //   307: aload #8
      //   309: invokevirtual getJavaType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   312: getstatic com/google/protobuf/Descriptors$FieldDescriptor$JavaType.STRING : Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
      //   315: if_acmpne -> 346
      //   318: aload_0
      //   319: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   322: iload_3
      //   323: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor
      //   326: dup
      //   327: aload #8
      //   329: aload_0
      //   330: getfield camelCaseNames : [Ljava/lang/String;
      //   333: iload_3
      //   334: aaload
      //   335: aload_1
      //   336: aload_2
      //   337: aload #7
      //   339: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V
      //   342: aastore
      //   343: goto -> 445
      //   346: aload_0
      //   347: getfield fields : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
      //   350: iload_3
      //   351: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor
      //   354: dup
      //   355: aload #8
      //   357: aload_0
      //   358: getfield camelCaseNames : [Ljava/lang/String;
      //   361: iload_3
      //   362: aaload
      //   363: aload_1
      //   364: aload_2
      //   365: aload #7
      //   367: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V
      //   370: aastore
      //   371: goto -> 445
      //   374: aload_0
      //   375: getfield oneofs : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$OneofAccessor;
      //   378: arraylength
      //   379: istore #6
      //   381: iload #4
      //   383: istore_3
      //   384: iload_3
      //   385: iload #6
      //   387: if_icmpge -> 426
      //   390: aload_0
      //   391: getfield oneofs : [Lcom/google/protobuf/GeneratedMessageV3$FieldAccessorTable$OneofAccessor;
      //   394: iload_3
      //   395: new com/google/protobuf/GeneratedMessageV3$FieldAccessorTable$OneofAccessor
      //   398: dup
      //   399: aload_0
      //   400: getfield descriptor : Lcom/google/protobuf/Descriptors$Descriptor;
      //   403: iload_3
      //   404: aload_0
      //   405: getfield camelCaseNames : [Ljava/lang/String;
      //   408: iload_3
      //   409: iload #5
      //   411: iadd
      //   412: aaload
      //   413: aload_1
      //   414: aload_2
      //   415: invokespecial <init> : (Lcom/google/protobuf/Descriptors$Descriptor;ILjava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V
      //   418: aastore
      //   419: iload_3
      //   420: iconst_1
      //   421: iadd
      //   422: istore_3
      //   423: goto -> 384
      //   426: aload_0
      //   427: iconst_1
      //   428: putfield initialized : Z
      //   431: aload_0
      //   432: aconst_null
      //   433: putfield camelCaseNames : [Ljava/lang/String;
      //   436: aload_0
      //   437: monitorexit
      //   438: aload_0
      //   439: areturn
      //   440: astore_1
      //   441: aload_0
      //   442: monitorexit
      //   443: aload_1
      //   444: athrow
      //   445: iload_3
      //   446: iconst_1
      //   447: iadd
      //   448: istore_3
      //   449: goto -> 34
      // Exception table:
      //   from	to	target	type
      //   11	20	440	finally
      //   22	29	440	finally
      //   43	61	440	finally
      //   61	87	440	finally
      //   87	137	440	finally
      //   140	163	440	finally
      //   166	200	440	finally
      //   203	226	440	finally
      //   229	265	440	finally
      //   268	304	440	finally
      //   307	343	440	finally
      //   346	371	440	finally
      //   374	381	440	finally
      //   390	419	440	finally
      //   426	438	440	finally
      //   441	443	440	finally
    }
    
    static interface FieldAccessor {
      void addRepeated(GeneratedMessageV3.Builder param2Builder, Object param2Object);
      
      void clear(GeneratedMessageV3.Builder param2Builder);
      
      Object get(GeneratedMessageV3.Builder param2Builder);
      
      Object get(GeneratedMessageV3 param2GeneratedMessageV3);
      
      Message.Builder getBuilder(GeneratedMessageV3.Builder param2Builder);
      
      Object getRaw(GeneratedMessageV3.Builder param2Builder);
      
      Object getRaw(GeneratedMessageV3 param2GeneratedMessageV3);
      
      Object getRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int);
      
      Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int);
      
      Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param2Builder, int param2Int);
      
      int getRepeatedCount(GeneratedMessageV3.Builder param2Builder);
      
      int getRepeatedCount(GeneratedMessageV3 param2GeneratedMessageV3);
      
      Object getRepeatedRaw(GeneratedMessageV3.Builder param2Builder, int param2Int);
      
      Object getRepeatedRaw(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int);
      
      boolean has(GeneratedMessageV3.Builder param2Builder);
      
      boolean has(GeneratedMessageV3 param2GeneratedMessageV3);
      
      Message.Builder newBuilder();
      
      void set(GeneratedMessageV3.Builder param2Builder, Object param2Object);
      
      void setRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int, Object param2Object);
    }
    
    static class MapFieldAccessor implements FieldAccessor {
      private final Descriptors.FieldDescriptor field;
      
      private final Message mapEntryMessageDefaultInstance;
      
      MapFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1) {
        this.field = param2FieldDescriptor;
        this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessageV3)GeneratedMessageV3.invokeOrDie(GeneratedMessageV3.getMethodOrDie(param2Class, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
      }
      
      private Message coerceType(Message param2Message) {
        return (param2Message == null) ? null : (this.mapEntryMessageDefaultInstance.getClass().isInstance(param2Message) ? param2Message : this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(param2Message).build());
      }
      
      private MapField<?, ?> getMapField(GeneratedMessageV3.Builder param2Builder) {
        return param2Builder.internalGetMapField(this.field.getNumber());
      }
      
      private MapField<?, ?> getMapField(GeneratedMessageV3 param2GeneratedMessageV3) {
        return param2GeneratedMessageV3.internalGetMapField(this.field.getNumber());
      }
      
      private MapField<?, ?> getMutableMapField(GeneratedMessageV3.Builder param2Builder) {
        return param2Builder.internalGetMutableMapField(this.field.getNumber());
      }
      
      public void addRepeated(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        getMutableMapField(param2Builder).getMutableList().add(coerceType((Message)param2Object));
      }
      
      public void clear(GeneratedMessageV3.Builder param2Builder) {
        getMutableMapField(param2Builder).getMutableList().clear();
      }
      
      public Object get(GeneratedMessageV3.Builder param2Builder) {
        ArrayList<Object> arrayList = new ArrayList();
        for (int i = 0; i < getRepeatedCount(param2Builder); i++)
          arrayList.add(getRepeated(param2Builder, i)); 
        return Collections.unmodifiableList(arrayList);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        ArrayList<Object> arrayList = new ArrayList();
        for (int i = 0; i < getRepeatedCount(param2GeneratedMessageV3); i++)
          arrayList.add(getRepeated(param2GeneratedMessageV3, i)); 
        return Collections.unmodifiableList(arrayList);
      }
      
      public Message.Builder getBuilder(GeneratedMessageV3.Builder param2Builder) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
      }
      
      public Object getRaw(GeneratedMessageV3.Builder param2Builder) {
        return get(param2Builder);
      }
      
      public Object getRaw(GeneratedMessageV3 param2GeneratedMessageV3) {
        return get(param2GeneratedMessageV3);
      }
      
      public Object getRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        return getMapField(param2Builder).getList().get(param2Int);
      }
      
      public Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        return getMapField(param2GeneratedMessageV3).getList().get(param2Int);
      }
      
      public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
      }
      
      public int getRepeatedCount(GeneratedMessageV3.Builder param2Builder) {
        return getMapField(param2Builder).getList().size();
      }
      
      public int getRepeatedCount(GeneratedMessageV3 param2GeneratedMessageV3) {
        return getMapField(param2GeneratedMessageV3).getList().size();
      }
      
      public Object getRepeatedRaw(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        return getRepeated(param2Builder, param2Int);
      }
      
      public Object getRepeatedRaw(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        return getRepeated(param2GeneratedMessageV3, param2Int);
      }
      
      public boolean has(GeneratedMessageV3.Builder param2Builder) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
      
      public boolean has(GeneratedMessageV3 param2GeneratedMessageV3) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
      
      public Message.Builder newBuilder() {
        return this.mapEntryMessageDefaultInstance.newBuilderForType();
      }
      
      public void set(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        clear(param2Builder);
        param2Object = ((List)param2Object).iterator();
        while (param2Object.hasNext())
          addRepeated(param2Builder, param2Object.next()); 
      }
      
      public void setRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int, Object param2Object) {
        getMutableMapField(param2Builder).getMutableList().set(param2Int, coerceType((Message)param2Object));
      }
    }
    
    static class OneofAccessor {
      private final Method caseMethod;
      
      private final Method caseMethodBuilder;
      
      private final Method clearMethod;
      
      private final Descriptors.Descriptor descriptor;
      
      private final Descriptors.FieldDescriptor fieldDescriptor;
      
      OneofAccessor(Descriptors.Descriptor param2Descriptor, int param2Int, String param2String, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1) {
        this.descriptor = param2Descriptor;
        Descriptors.OneofDescriptor oneofDescriptor = param2Descriptor.getOneofs().get(param2Int);
        if (oneofDescriptor.isSynthetic()) {
          this.caseMethod = null;
          this.caseMethodBuilder = null;
          this.fieldDescriptor = oneofDescriptor.getFields().get(0);
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param2String);
          stringBuilder1.append("Case");
          this.caseMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder1.toString(), new Class[0]);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param2String);
          stringBuilder1.append("Case");
          this.caseMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder1.toString(), new Class[0]);
          this.fieldDescriptor = null;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("clear");
        stringBuilder.append(param2String);
        this.clearMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[0]);
      }
      
      public void clear(GeneratedMessageV3.Builder param2Builder) {
        GeneratedMessageV3.invokeOrDie(this.clearMethod, param2Builder, new Object[0]);
      }
      
      public Descriptors.FieldDescriptor get(GeneratedMessageV3.Builder param2Builder) {
        Descriptors.FieldDescriptor fieldDescriptor2 = this.fieldDescriptor;
        Descriptors.FieldDescriptor fieldDescriptor1 = null;
        if (fieldDescriptor2 != null) {
          if (param2Builder.hasField(fieldDescriptor2))
            fieldDescriptor1 = this.fieldDescriptor; 
          return fieldDescriptor1;
        } 
        int i = ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param2Builder, new Object[0])).getNumber();
        return (i > 0) ? this.descriptor.findFieldByNumber(i) : null;
      }
      
      public Descriptors.FieldDescriptor get(GeneratedMessageV3 param2GeneratedMessageV3) {
        Descriptors.FieldDescriptor fieldDescriptor2 = this.fieldDescriptor;
        Descriptors.FieldDescriptor fieldDescriptor1 = null;
        if (fieldDescriptor2 != null) {
          if (param2GeneratedMessageV3.hasField(fieldDescriptor2))
            fieldDescriptor1 = this.fieldDescriptor; 
          return fieldDescriptor1;
        } 
        int i = ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param2GeneratedMessageV3, new Object[0])).getNumber();
        return (i > 0) ? this.descriptor.findFieldByNumber(i) : null;
      }
      
      public boolean has(GeneratedMessageV3.Builder param2Builder) {
        Descriptors.FieldDescriptor fieldDescriptor = this.fieldDescriptor;
        return (fieldDescriptor != null) ? param2Builder.hasField(fieldDescriptor) : (!(((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param2Builder, new Object[0])).getNumber() == 0));
      }
      
      public boolean has(GeneratedMessageV3 param2GeneratedMessageV3) {
        Descriptors.FieldDescriptor fieldDescriptor = this.fieldDescriptor;
        return (fieldDescriptor != null) ? param2GeneratedMessageV3.hasField(fieldDescriptor) : (!(((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param2GeneratedMessageV3, new Object[0])).getNumber() == 0));
      }
    }
    
    static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
      private Method addRepeatedValueMethod;
      
      private Descriptors.EnumDescriptor enumDescriptor;
      
      private Method getRepeatedValueMethod;
      
      private Method getRepeatedValueMethodBuilder;
      
      private final Method getValueDescriptorMethod;
      
      private Method setRepeatedValueMethod;
      
      private boolean supportUnknownEnumValue;
      
      private final Method valueOfMethod;
      
      RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1) {
        super(param2FieldDescriptor, param2String, param2Class, param2Class1);
        this.enumDescriptor = param2FieldDescriptor.getEnumType();
        this.valueOfMethod = GeneratedMessageV3.getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
        this.getValueDescriptorMethod = GeneratedMessageV3.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
        this.supportUnknownEnumValue = param2FieldDescriptor.getFile().supportsUnknownEnumValue();
        if (this.supportUnknownEnumValue) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("get");
          stringBuilder.append(param2String);
          stringBuilder.append("Value");
          this.getRepeatedValueMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder.toString(), new Class[] { int.class });
          stringBuilder = new StringBuilder();
          stringBuilder.append("get");
          stringBuilder.append(param2String);
          stringBuilder.append("Value");
          this.getRepeatedValueMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[] { int.class });
          stringBuilder = new StringBuilder();
          stringBuilder.append("set");
          stringBuilder.append(param2String);
          stringBuilder.append("Value");
          this.setRepeatedValueMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[] { int.class, int.class });
          stringBuilder = new StringBuilder();
          stringBuilder.append("add");
          stringBuilder.append(param2String);
          stringBuilder.append("Value");
          this.addRepeatedValueMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[] { int.class });
        } 
      }
      
      public void addRepeated(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        if (this.supportUnknownEnumValue) {
          GeneratedMessageV3.invokeOrDie(this.addRepeatedValueMethod, param2Builder, new Object[] { Integer.valueOf(((Descriptors.EnumValueDescriptor)param2Object).getNumber()) });
          return;
        } 
        super.addRepeated(param2Builder, GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, new Object[] { param2Object }));
      }
      
      public Object get(GeneratedMessageV3.Builder param2Builder) {
        ArrayList<Object> arrayList = new ArrayList();
        int j = getRepeatedCount(param2Builder);
        for (int i = 0; i < j; i++)
          arrayList.add(getRepeated(param2Builder, i)); 
        return Collections.unmodifiableList(arrayList);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        ArrayList<Object> arrayList = new ArrayList();
        int j = getRepeatedCount(param2GeneratedMessageV3);
        for (int i = 0; i < j; i++)
          arrayList.add(getRepeated(param2GeneratedMessageV3, i)); 
        return Collections.unmodifiableList(arrayList);
      }
      
      public Object getRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        if (this.supportUnknownEnumValue) {
          param2Int = ((Integer)GeneratedMessageV3.invokeOrDie(this.getRepeatedValueMethodBuilder, param2Builder, new Object[] { Integer.valueOf(param2Int) })).intValue();
          return this.enumDescriptor.findValueByNumberCreatingIfUnknown(param2Int);
        } 
        return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(param2Builder, param2Int), new Object[0]);
      }
      
      public Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        if (this.supportUnknownEnumValue) {
          param2Int = ((Integer)GeneratedMessageV3.invokeOrDie(this.getRepeatedValueMethod, param2GeneratedMessageV3, new Object[] { Integer.valueOf(param2Int) })).intValue();
          return this.enumDescriptor.findValueByNumberCreatingIfUnknown(param2Int);
        } 
        return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(param2GeneratedMessageV3, param2Int), new Object[0]);
      }
      
      public void setRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int, Object param2Object) {
        if (this.supportUnknownEnumValue) {
          GeneratedMessageV3.invokeOrDie(this.setRepeatedValueMethod, param2Builder, new Object[] { Integer.valueOf(param2Int), Integer.valueOf(((Descriptors.EnumValueDescriptor)param2Object).getNumber()) });
          return;
        } 
        super.setRepeated(param2Builder, param2Int, GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, new Object[] { param2Object }));
      }
    }
    
    static class RepeatedFieldAccessor implements FieldAccessor {
      protected final MethodInvoker invoker;
      
      protected final Class type;
      
      RepeatedFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1) {
        ReflectionInvoker reflectionInvoker = new ReflectionInvoker(param2FieldDescriptor, param2String, param2Class, param2Class1);
        this.type = reflectionInvoker.getRepeatedMethod.getReturnType();
        this.invoker = getMethodInvoker(reflectionInvoker);
      }
      
      static MethodInvoker getMethodInvoker(ReflectionInvoker param2ReflectionInvoker) {
        return param2ReflectionInvoker;
      }
      
      public void addRepeated(GeneratedMessageV3.Builder<?> param2Builder, Object param2Object) {
        this.invoker.addRepeated(param2Builder, param2Object);
      }
      
      public void clear(GeneratedMessageV3.Builder<?> param2Builder) {
        this.invoker.clear(param2Builder);
      }
      
      public Object get(GeneratedMessageV3.Builder<?> param2Builder) {
        return this.invoker.get(param2Builder);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        return this.invoker.get(param2GeneratedMessageV3);
      }
      
      public Message.Builder getBuilder(GeneratedMessageV3.Builder param2Builder) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
      
      public Object getRaw(GeneratedMessageV3.Builder param2Builder) {
        return get(param2Builder);
      }
      
      public Object getRaw(GeneratedMessageV3 param2GeneratedMessageV3) {
        return get(param2GeneratedMessageV3);
      }
      
      public Object getRepeated(GeneratedMessageV3.Builder<?> param2Builder, int param2Int) {
        return this.invoker.getRepeated(param2Builder, param2Int);
      }
      
      public Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        return this.invoker.getRepeated(param2GeneratedMessageV3, param2Int);
      }
      
      public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
      }
      
      public int getRepeatedCount(GeneratedMessageV3.Builder<?> param2Builder) {
        return this.invoker.getRepeatedCount(param2Builder);
      }
      
      public int getRepeatedCount(GeneratedMessageV3 param2GeneratedMessageV3) {
        return this.invoker.getRepeatedCount(param2GeneratedMessageV3);
      }
      
      public Object getRepeatedRaw(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        return getRepeated(param2Builder, param2Int);
      }
      
      public Object getRepeatedRaw(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        return getRepeated(param2GeneratedMessageV3, param2Int);
      }
      
      public boolean has(GeneratedMessageV3.Builder param2Builder) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public boolean has(GeneratedMessageV3 param2GeneratedMessageV3) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public Message.Builder newBuilder() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public void set(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        clear(param2Builder);
        param2Object = ((List)param2Object).iterator();
        while (param2Object.hasNext())
          addRepeated(param2Builder, param2Object.next()); 
      }
      
      public void setRepeated(GeneratedMessageV3.Builder<?> param2Builder, int param2Int, Object param2Object) {
        this.invoker.setRepeated(param2Builder, param2Int, param2Object);
      }
      
      static interface MethodInvoker {
        void addRepeated(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object);
        
        void clear(GeneratedMessageV3.Builder<?> param3Builder);
        
        Object get(GeneratedMessageV3.Builder<?> param3Builder);
        
        Object get(GeneratedMessageV3 param3GeneratedMessageV3);
        
        Object getRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int);
        
        Object getRepeated(GeneratedMessageV3 param3GeneratedMessageV3, int param3Int);
        
        int getRepeatedCount(GeneratedMessageV3.Builder<?> param3Builder);
        
        int getRepeatedCount(GeneratedMessageV3 param3GeneratedMessageV3);
        
        void setRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int, Object param3Object);
      }
      
      static final class ReflectionInvoker implements MethodInvoker {
        protected final Method addRepeatedMethod;
        
        protected final Method clearMethod;
        
        protected final Method getCountMethod;
        
        protected final Method getCountMethodBuilder;
        
        protected final Method getMethod;
        
        protected final Method getMethodBuilder;
        
        protected final Method getRepeatedMethod;
        
        protected final Method getRepeatedMethodBuilder;
        
        protected final Method setRepeatedMethod;
        
        ReflectionInvoker(Descriptors.FieldDescriptor param3FieldDescriptor, String param3String, Class<? extends GeneratedMessageV3> param3Class, Class<? extends GeneratedMessageV3.Builder> param3Class1) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("get");
          stringBuilder2.append(param3String);
          stringBuilder2.append("List");
          this.getMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder2.toString(), new Class[0]);
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("get");
          stringBuilder2.append(param3String);
          stringBuilder2.append("List");
          this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder2.toString(), new Class[0]);
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("get");
          stringBuilder2.append(param3String);
          this.getRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder2.toString(), new Class[] { int.class });
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("get");
          stringBuilder2.append(param3String);
          this.getRepeatedMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder2.toString(), new Class[] { int.class });
          Class<?> clazz = this.getRepeatedMethod.getReturnType();
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("set");
          stringBuilder3.append(param3String);
          this.setRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder3.toString(), new Class[] { int.class, clazz });
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append("add");
          stringBuilder3.append(param3String);
          this.addRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder3.toString(), new Class[] { clazz });
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param3String);
          stringBuilder1.append("Count");
          this.getCountMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder1.toString(), new Class[0]);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param3String);
          stringBuilder1.append("Count");
          this.getCountMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("clear");
          stringBuilder1.append(param3String);
          this.clearMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
        }
        
        public void addRepeated(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object) {
          GeneratedMessageV3.invokeOrDie(this.addRepeatedMethod, param3Builder, new Object[] { param3Object });
        }
        
        public void clear(GeneratedMessageV3.Builder<?> param3Builder) {
          GeneratedMessageV3.invokeOrDie(this.clearMethod, param3Builder, new Object[0]);
        }
        
        public Object get(GeneratedMessageV3.Builder<?> param3Builder) {
          return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param3Builder, new Object[0]);
        }
        
        public Object get(GeneratedMessageV3 param3GeneratedMessageV3) {
          return GeneratedMessageV3.invokeOrDie(this.getMethod, param3GeneratedMessageV3, new Object[0]);
        }
        
        public Object getRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int) {
          return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethodBuilder, param3Builder, new Object[] { Integer.valueOf(param3Int) });
        }
        
        public Object getRepeated(GeneratedMessageV3 param3GeneratedMessageV3, int param3Int) {
          return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethod, param3GeneratedMessageV3, new Object[] { Integer.valueOf(param3Int) });
        }
        
        public int getRepeatedCount(GeneratedMessageV3.Builder<?> param3Builder) {
          return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethodBuilder, param3Builder, new Object[0])).intValue();
        }
        
        public int getRepeatedCount(GeneratedMessageV3 param3GeneratedMessageV3) {
          return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethod, param3GeneratedMessageV3, new Object[0])).intValue();
        }
        
        public void setRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int, Object param3Object) {
          GeneratedMessageV3.invokeOrDie(this.setRepeatedMethod, param3Builder, new Object[] { Integer.valueOf(param3Int), param3Object });
        }
      }
    }
    
    static interface MethodInvoker {
      void addRepeated(GeneratedMessageV3.Builder<?> param2Builder, Object param2Object);
      
      void clear(GeneratedMessageV3.Builder<?> param2Builder);
      
      Object get(GeneratedMessageV3.Builder<?> param2Builder);
      
      Object get(GeneratedMessageV3 param2GeneratedMessageV3);
      
      Object getRepeated(GeneratedMessageV3.Builder<?> param2Builder, int param2Int);
      
      Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int);
      
      int getRepeatedCount(GeneratedMessageV3.Builder<?> param2Builder);
      
      int getRepeatedCount(GeneratedMessageV3 param2GeneratedMessageV3);
      
      void setRepeated(GeneratedMessageV3.Builder<?> param2Builder, int param2Int, Object param2Object);
    }
    
    static final class ReflectionInvoker implements RepeatedFieldAccessor.MethodInvoker {
      protected final Method addRepeatedMethod;
      
      protected final Method clearMethod;
      
      protected final Method getCountMethod;
      
      protected final Method getCountMethodBuilder;
      
      protected final Method getMethod;
      
      protected final Method getMethodBuilder;
      
      protected final Method getRepeatedMethod;
      
      protected final Method getRepeatedMethodBuilder;
      
      protected final Method setRepeatedMethod;
      
      ReflectionInvoker(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param2String);
        stringBuilder2.append("List");
        this.getMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder2.toString(), new Class[0]);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param2String);
        stringBuilder2.append("List");
        this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder2.toString(), new Class[0]);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param2String);
        this.getRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder2.toString(), new Class[] { int.class });
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param2String);
        this.getRepeatedMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder2.toString(), new Class[] { int.class });
        Class<?> clazz = this.getRepeatedMethod.getReturnType();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("set");
        stringBuilder3.append(param2String);
        this.setRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder3.toString(), new Class[] { int.class, clazz });
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append("add");
        stringBuilder3.append(param2String);
        this.addRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder3.toString(), new Class[] { clazz });
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param2String);
        stringBuilder1.append("Count");
        this.getCountMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder1.toString(), new Class[0]);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param2String);
        stringBuilder1.append("Count");
        this.getCountMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder1.toString(), new Class[0]);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("clear");
        stringBuilder1.append(param2String);
        this.clearMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder1.toString(), new Class[0]);
      }
      
      public void addRepeated(GeneratedMessageV3.Builder<?> param2Builder, Object param2Object) {
        GeneratedMessageV3.invokeOrDie(this.addRepeatedMethod, param2Builder, new Object[] { param2Object });
      }
      
      public void clear(GeneratedMessageV3.Builder<?> param2Builder) {
        GeneratedMessageV3.invokeOrDie(this.clearMethod, param2Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3.Builder<?> param2Builder) {
        return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param2Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        return GeneratedMessageV3.invokeOrDie(this.getMethod, param2GeneratedMessageV3, new Object[0]);
      }
      
      public Object getRepeated(GeneratedMessageV3.Builder<?> param2Builder, int param2Int) {
        return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethodBuilder, param2Builder, new Object[] { Integer.valueOf(param2Int) });
      }
      
      public Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethod, param2GeneratedMessageV3, new Object[] { Integer.valueOf(param2Int) });
      }
      
      public int getRepeatedCount(GeneratedMessageV3.Builder<?> param2Builder) {
        return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethodBuilder, param2Builder, new Object[0])).intValue();
      }
      
      public int getRepeatedCount(GeneratedMessageV3 param2GeneratedMessageV3) {
        return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethod, param2GeneratedMessageV3, new Object[0])).intValue();
      }
      
      public void setRepeated(GeneratedMessageV3.Builder<?> param2Builder, int param2Int, Object param2Object) {
        GeneratedMessageV3.invokeOrDie(this.setRepeatedMethod, param2Builder, new Object[] { Integer.valueOf(param2Int), param2Object });
      }
    }
    
    static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
      private final Method getBuilderMethodBuilder;
      
      private final Method newBuilderMethod = GeneratedMessageV3.getMethodOrDie(this.type, "newBuilder", new Class[0]);
      
      RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1) {
        super(param2FieldDescriptor, param2String, param2Class, param2Class1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param2String);
        stringBuilder.append("Builder");
        this.getBuilderMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[] { int.class });
      }
      
      private Object coerceType(Object param2Object) {
        return this.type.isInstance(param2Object) ? param2Object : ((Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)param2Object).build();
      }
      
      public void addRepeated(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        super.addRepeated(param2Builder, coerceType(param2Object));
      }
      
      public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.getBuilderMethodBuilder, param2Builder, new Object[] { Integer.valueOf(param2Int) });
      }
      
      public Message.Builder newBuilder() {
        return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
      }
      
      public void setRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int, Object param2Object) {
        super.setRepeated(param2Builder, param2Int, coerceType(param2Object));
      }
    }
    
    static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
      private Descriptors.EnumDescriptor enumDescriptor;
      
      private Method getValueDescriptorMethod;
      
      private Method getValueMethod;
      
      private Method getValueMethodBuilder;
      
      private Method setValueMethod;
      
      private boolean supportUnknownEnumValue;
      
      private Method valueOfMethod;
      
      SingularEnumFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String1, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1, String param2String2) {
        super(param2FieldDescriptor, param2String1, param2Class, param2Class1, param2String2);
        this.enumDescriptor = param2FieldDescriptor.getEnumType();
        this.valueOfMethod = GeneratedMessageV3.getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
        this.getValueDescriptorMethod = GeneratedMessageV3.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
        this.supportUnknownEnumValue = param2FieldDescriptor.getFile().supportsUnknownEnumValue();
        if (this.supportUnknownEnumValue) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("get");
          stringBuilder.append(param2String1);
          stringBuilder.append("Value");
          this.getValueMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder.toString(), new Class[0]);
          stringBuilder = new StringBuilder();
          stringBuilder.append("get");
          stringBuilder.append(param2String1);
          stringBuilder.append("Value");
          this.getValueMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[0]);
          stringBuilder = new StringBuilder();
          stringBuilder.append("set");
          stringBuilder.append(param2String1);
          stringBuilder.append("Value");
          this.setValueMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[] { int.class });
        } 
      }
      
      public Object get(GeneratedMessageV3.Builder param2Builder) {
        if (this.supportUnknownEnumValue) {
          int i = ((Integer)GeneratedMessageV3.invokeOrDie(this.getValueMethodBuilder, param2Builder, new Object[0])).intValue();
          return this.enumDescriptor.findValueByNumberCreatingIfUnknown(i);
        } 
        return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.get(param2Builder), new Object[0]);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        if (this.supportUnknownEnumValue) {
          int i = ((Integer)GeneratedMessageV3.invokeOrDie(this.getValueMethod, param2GeneratedMessageV3, new Object[0])).intValue();
          return this.enumDescriptor.findValueByNumberCreatingIfUnknown(i);
        } 
        return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.get(param2GeneratedMessageV3), new Object[0]);
      }
      
      public void set(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        if (this.supportUnknownEnumValue) {
          GeneratedMessageV3.invokeOrDie(this.setValueMethod, param2Builder, new Object[] { Integer.valueOf(((Descriptors.EnumValueDescriptor)param2Object).getNumber()) });
          return;
        } 
        super.set(param2Builder, GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, new Object[] { param2Object }));
      }
    }
    
    static class SingularFieldAccessor implements FieldAccessor {
      protected final Descriptors.FieldDescriptor field;
      
      protected final boolean hasHasMethod;
      
      protected final MethodInvoker invoker;
      
      protected final boolean isOneofField;
      
      protected final Class<?> type;
      
      SingularFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String1, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1, String param2String2) {
        Descriptors.OneofDescriptor oneofDescriptor = param2FieldDescriptor.getContainingOneof();
        boolean bool2 = true;
        if (oneofDescriptor != null && !param2FieldDescriptor.getContainingOneof().isSynthetic()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.isOneofField = bool1;
        boolean bool1 = bool2;
        if (param2FieldDescriptor.getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO2) {
          bool1 = bool2;
          if (!param2FieldDescriptor.hasOptionalKeyword())
            if (!this.isOneofField && param2FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }  
        } 
        this.hasHasMethod = bool1;
        ReflectionInvoker reflectionInvoker = new ReflectionInvoker(param2FieldDescriptor, param2String1, param2Class, param2Class1, param2String2, this.isOneofField, this.hasHasMethod);
        this.field = param2FieldDescriptor;
        this.type = reflectionInvoker.getMethod.getReturnType();
        this.invoker = getMethodInvoker(reflectionInvoker);
      }
      
      static MethodInvoker getMethodInvoker(ReflectionInvoker param2ReflectionInvoker) {
        return param2ReflectionInvoker;
      }
      
      public void addRepeated(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }
      
      public void clear(GeneratedMessageV3.Builder<?> param2Builder) {
        this.invoker.clear(param2Builder);
      }
      
      public Object get(GeneratedMessageV3.Builder<?> param2Builder) {
        return this.invoker.get(param2Builder);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        return this.invoker.get(param2GeneratedMessageV3);
      }
      
      public Message.Builder getBuilder(GeneratedMessageV3.Builder param2Builder) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
      
      public Object getRaw(GeneratedMessageV3.Builder param2Builder) {
        return get(param2Builder);
      }
      
      public Object getRaw(GeneratedMessageV3 param2GeneratedMessageV3) {
        return get(param2GeneratedMessageV3);
      }
      
      public Object getRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public Object getRepeated(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
      }
      
      public int getRepeatedCount(GeneratedMessageV3.Builder param2Builder) {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public int getRepeatedCount(GeneratedMessageV3 param2GeneratedMessageV3) {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public Object getRepeatedRaw(GeneratedMessageV3.Builder param2Builder, int param2Int) {
        throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
      }
      
      public Object getRepeatedRaw(GeneratedMessageV3 param2GeneratedMessageV3, int param2Int) {
        throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
      }
      
      public boolean has(GeneratedMessageV3.Builder<?> param2Builder) {
        return !this.hasHasMethod ? (this.isOneofField ? ((this.invoker.getOneofFieldNumber(param2Builder) == this.field.getNumber())) : (get(param2Builder).equals(this.field.getDefaultValue()) ^ true)) : this.invoker.has(param2Builder);
      }
      
      public boolean has(GeneratedMessageV3 param2GeneratedMessageV3) {
        return !this.hasHasMethod ? (this.isOneofField ? ((this.invoker.getOneofFieldNumber(param2GeneratedMessageV3) == this.field.getNumber())) : (get(param2GeneratedMessageV3).equals(this.field.getDefaultValue()) ^ true)) : this.invoker.has(param2GeneratedMessageV3);
      }
      
      public Message.Builder newBuilder() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public void set(GeneratedMessageV3.Builder<?> param2Builder, Object param2Object) {
        this.invoker.set(param2Builder, param2Object);
      }
      
      public void setRepeated(GeneratedMessageV3.Builder param2Builder, int param2Int, Object param2Object) {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
      }
      
      static interface MethodInvoker {
        void clear(GeneratedMessageV3.Builder<?> param3Builder);
        
        Object get(GeneratedMessageV3.Builder<?> param3Builder);
        
        Object get(GeneratedMessageV3 param3GeneratedMessageV3);
        
        int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param3Builder);
        
        int getOneofFieldNumber(GeneratedMessageV3 param3GeneratedMessageV3);
        
        boolean has(GeneratedMessageV3.Builder<?> param3Builder);
        
        boolean has(GeneratedMessageV3 param3GeneratedMessageV3);
        
        void set(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object);
      }
      
      static final class ReflectionInvoker implements MethodInvoker {
        protected final Method caseMethod;
        
        protected final Method caseMethodBuilder;
        
        protected final Method clearMethod;
        
        protected final Method getMethod;
        
        protected final Method getMethodBuilder;
        
        protected final Method hasMethod;
        
        protected final Method hasMethodBuilder;
        
        protected final Method setMethod;
        
        ReflectionInvoker(Descriptors.FieldDescriptor param3FieldDescriptor, String param3String1, Class<? extends GeneratedMessageV3> param3Class, Class<? extends GeneratedMessageV3.Builder> param3Class1, String param3String2, boolean param3Boolean1, boolean param3Boolean2) {
          Method method;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("get");
          stringBuilder2.append(param3String1);
          this.getMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder2.toString(), new Class[0]);
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("get");
          stringBuilder2.append(param3String1);
          this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder2.toString(), new Class[0]);
          Class<?> clazz = this.getMethod.getReturnType();
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("set");
          stringBuilder3.append(param3String1);
          this.setMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder3.toString(), new Class[] { clazz });
          stringBuilder3 = null;
          if (param3Boolean2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("has");
            stringBuilder.append(param3String1);
            method = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder.toString(), new Class[0]);
          } else {
            clazz = null;
          } 
          this.hasMethod = (Method)clazz;
          if (param3Boolean2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("has");
            stringBuilder.append(param3String1);
            method = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder.toString(), new Class[0]);
          } else {
            clazz = null;
          } 
          this.hasMethodBuilder = (Method)clazz;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("clear");
          stringBuilder1.append(param3String1);
          this.clearMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
          if (param3Boolean1) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("get");
            stringBuilder1.append(param3String2);
            stringBuilder1.append("Case");
            method = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder1.toString(), new Class[0]);
          } else {
            stringBuilder1 = null;
          } 
          this.caseMethod = (Method)stringBuilder1;
          stringBuilder1 = stringBuilder3;
          if (param3Boolean1) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("get");
            stringBuilder1.append(param3String2);
            stringBuilder1.append("Case");
            method = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
          } 
          this.caseMethodBuilder = method;
        }
        
        public void clear(GeneratedMessageV3.Builder<?> param3Builder) {
          GeneratedMessageV3.invokeOrDie(this.clearMethod, param3Builder, new Object[0]);
        }
        
        public Object get(GeneratedMessageV3.Builder<?> param3Builder) {
          return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param3Builder, new Object[0]);
        }
        
        public Object get(GeneratedMessageV3 param3GeneratedMessageV3) {
          return GeneratedMessageV3.invokeOrDie(this.getMethod, param3GeneratedMessageV3, new Object[0]);
        }
        
        public int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param3Builder) {
          return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param3Builder, new Object[0])).getNumber();
        }
        
        public int getOneofFieldNumber(GeneratedMessageV3 param3GeneratedMessageV3) {
          return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param3GeneratedMessageV3, new Object[0])).getNumber();
        }
        
        public boolean has(GeneratedMessageV3.Builder<?> param3Builder) {
          return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethodBuilder, param3Builder, new Object[0])).booleanValue();
        }
        
        public boolean has(GeneratedMessageV3 param3GeneratedMessageV3) {
          return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethod, param3GeneratedMessageV3, new Object[0])).booleanValue();
        }
        
        public void set(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object) {
          GeneratedMessageV3.invokeOrDie(this.setMethod, param3Builder, new Object[] { param3Object });
        }
      }
    }
    
    static interface MethodInvoker {
      void clear(GeneratedMessageV3.Builder<?> param2Builder);
      
      Object get(GeneratedMessageV3.Builder<?> param2Builder);
      
      Object get(GeneratedMessageV3 param2GeneratedMessageV3);
      
      int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param2Builder);
      
      int getOneofFieldNumber(GeneratedMessageV3 param2GeneratedMessageV3);
      
      boolean has(GeneratedMessageV3.Builder<?> param2Builder);
      
      boolean has(GeneratedMessageV3 param2GeneratedMessageV3);
      
      void set(GeneratedMessageV3.Builder<?> param2Builder, Object param2Object);
    }
    
    static final class ReflectionInvoker implements SingularFieldAccessor.MethodInvoker {
      protected final Method caseMethod;
      
      protected final Method caseMethodBuilder;
      
      protected final Method clearMethod;
      
      protected final Method getMethod;
      
      protected final Method getMethodBuilder;
      
      protected final Method hasMethod;
      
      protected final Method hasMethodBuilder;
      
      protected final Method setMethod;
      
      ReflectionInvoker(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String1, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1, String param2String2, boolean param2Boolean1, boolean param2Boolean2) {
        Method method;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param2String1);
        this.getMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder2.toString(), new Class[0]);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param2String1);
        this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder2.toString(), new Class[0]);
        Class<?> clazz = this.getMethod.getReturnType();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("set");
        stringBuilder3.append(param2String1);
        this.setMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder3.toString(), new Class[] { clazz });
        stringBuilder3 = null;
        if (param2Boolean2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("has");
          stringBuilder.append(param2String1);
          method = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder.toString(), new Class[0]);
        } else {
          clazz = null;
        } 
        this.hasMethod = (Method)clazz;
        if (param2Boolean2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("has");
          stringBuilder.append(param2String1);
          method = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[0]);
        } else {
          clazz = null;
        } 
        this.hasMethodBuilder = (Method)clazz;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("clear");
        stringBuilder1.append(param2String1);
        this.clearMethod = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder1.toString(), new Class[0]);
        if (param2Boolean1) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param2String2);
          stringBuilder1.append("Case");
          method = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder1.toString(), new Class[0]);
        } else {
          stringBuilder1 = null;
        } 
        this.caseMethod = (Method)stringBuilder1;
        stringBuilder1 = stringBuilder3;
        if (param2Boolean1) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param2String2);
          stringBuilder1.append("Case");
          method = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder1.toString(), new Class[0]);
        } 
        this.caseMethodBuilder = method;
      }
      
      public void clear(GeneratedMessageV3.Builder<?> param2Builder) {
        GeneratedMessageV3.invokeOrDie(this.clearMethod, param2Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3.Builder<?> param2Builder) {
        return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param2Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3 param2GeneratedMessageV3) {
        return GeneratedMessageV3.invokeOrDie(this.getMethod, param2GeneratedMessageV3, new Object[0]);
      }
      
      public int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param2Builder) {
        return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param2Builder, new Object[0])).getNumber();
      }
      
      public int getOneofFieldNumber(GeneratedMessageV3 param2GeneratedMessageV3) {
        return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param2GeneratedMessageV3, new Object[0])).getNumber();
      }
      
      public boolean has(GeneratedMessageV3.Builder<?> param2Builder) {
        return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethodBuilder, param2Builder, new Object[0])).booleanValue();
      }
      
      public boolean has(GeneratedMessageV3 param2GeneratedMessageV3) {
        return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethod, param2GeneratedMessageV3, new Object[0])).booleanValue();
      }
      
      public void set(GeneratedMessageV3.Builder<?> param2Builder, Object param2Object) {
        GeneratedMessageV3.invokeOrDie(this.setMethod, param2Builder, new Object[] { param2Object });
      }
    }
    
    static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
      private final Method getBuilderMethodBuilder;
      
      private final Method newBuilderMethod = GeneratedMessageV3.getMethodOrDie(this.type, "newBuilder", new Class[0]);
      
      SingularMessageFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String1, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1, String param2String2) {
        super(param2FieldDescriptor, param2String1, param2Class, param2Class1, param2String2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param2String1);
        stringBuilder.append("Builder");
        this.getBuilderMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[0]);
      }
      
      private Object coerceType(Object param2Object) {
        return this.type.isInstance(param2Object) ? param2Object : ((Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)param2Object).buildPartial();
      }
      
      public Message.Builder getBuilder(GeneratedMessageV3.Builder param2Builder) {
        return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.getBuilderMethodBuilder, param2Builder, new Object[0]);
      }
      
      public Message.Builder newBuilder() {
        return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
      }
      
      public void set(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        super.set(param2Builder, coerceType(param2Object));
      }
    }
    
    static final class SingularStringFieldAccessor extends SingularFieldAccessor {
      private final Method getBytesMethod;
      
      private final Method getBytesMethodBuilder;
      
      private final Method setBytesMethodBuilder;
      
      SingularStringFieldAccessor(Descriptors.FieldDescriptor param2FieldDescriptor, String param2String1, Class<? extends GeneratedMessageV3> param2Class, Class<? extends GeneratedMessageV3.Builder> param2Class1, String param2String2) {
        super(param2FieldDescriptor, param2String1, param2Class, param2Class1, param2String2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param2String1);
        stringBuilder.append("Bytes");
        this.getBytesMethod = GeneratedMessageV3.getMethodOrDie(param2Class, stringBuilder.toString(), new Class[0]);
        stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param2String1);
        stringBuilder.append("Bytes");
        this.getBytesMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[0]);
        stringBuilder = new StringBuilder();
        stringBuilder.append("set");
        stringBuilder.append(param2String1);
        stringBuilder.append("Bytes");
        this.setBytesMethodBuilder = GeneratedMessageV3.getMethodOrDie(param2Class1, stringBuilder.toString(), new Class[] { ByteString.class });
      }
      
      public Object getRaw(GeneratedMessageV3.Builder param2Builder) {
        return GeneratedMessageV3.invokeOrDie(this.getBytesMethodBuilder, param2Builder, new Object[0]);
      }
      
      public Object getRaw(GeneratedMessageV3 param2GeneratedMessageV3) {
        return GeneratedMessageV3.invokeOrDie(this.getBytesMethod, param2GeneratedMessageV3, new Object[0]);
      }
      
      public void set(GeneratedMessageV3.Builder param2Builder, Object param2Object) {
        if (param2Object instanceof ByteString) {
          GeneratedMessageV3.invokeOrDie(this.setBytesMethodBuilder, param2Builder, new Object[] { param2Object });
          return;
        } 
        super.set(param2Builder, param2Object);
      }
    }
  }
  
  static interface FieldAccessor {
    void addRepeated(GeneratedMessageV3.Builder param1Builder, Object param1Object);
    
    void clear(GeneratedMessageV3.Builder param1Builder);
    
    Object get(GeneratedMessageV3.Builder param1Builder);
    
    Object get(GeneratedMessageV3 param1GeneratedMessageV3);
    
    Message.Builder getBuilder(GeneratedMessageV3.Builder param1Builder);
    
    Object getRaw(GeneratedMessageV3.Builder param1Builder);
    
    Object getRaw(GeneratedMessageV3 param1GeneratedMessageV3);
    
    Object getRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int);
    
    Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int);
    
    Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param1Builder, int param1Int);
    
    int getRepeatedCount(GeneratedMessageV3.Builder param1Builder);
    
    int getRepeatedCount(GeneratedMessageV3 param1GeneratedMessageV3);
    
    Object getRepeatedRaw(GeneratedMessageV3.Builder param1Builder, int param1Int);
    
    Object getRepeatedRaw(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int);
    
    boolean has(GeneratedMessageV3.Builder param1Builder);
    
    boolean has(GeneratedMessageV3 param1GeneratedMessageV3);
    
    Message.Builder newBuilder();
    
    void set(GeneratedMessageV3.Builder param1Builder, Object param1Object);
    
    void setRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int, Object param1Object);
  }
  
  static class MapFieldAccessor implements FieldAccessorTable.FieldAccessor {
    private final Descriptors.FieldDescriptor field;
    
    private final Message mapEntryMessageDefaultInstance;
    
    MapFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      this.field = param1FieldDescriptor;
      this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessageV3)GeneratedMessageV3.invokeOrDie(GeneratedMessageV3.getMethodOrDie(param1Class, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
    }
    
    private Message coerceType(Message param1Message) {
      return (param1Message == null) ? null : (this.mapEntryMessageDefaultInstance.getClass().isInstance(param1Message) ? param1Message : this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(param1Message).build());
    }
    
    private MapField<?, ?> getMapField(GeneratedMessageV3.Builder param1Builder) {
      return param1Builder.internalGetMapField(this.field.getNumber());
    }
    
    private MapField<?, ?> getMapField(GeneratedMessageV3 param1GeneratedMessageV3) {
      return param1GeneratedMessageV3.internalGetMapField(this.field.getNumber());
    }
    
    private MapField<?, ?> getMutableMapField(GeneratedMessageV3.Builder param1Builder) {
      return param1Builder.internalGetMutableMapField(this.field.getNumber());
    }
    
    public void addRepeated(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      getMutableMapField(param1Builder).getMutableList().add(coerceType((Message)param1Object));
    }
    
    public void clear(GeneratedMessageV3.Builder param1Builder) {
      getMutableMapField(param1Builder).getMutableList().clear();
    }
    
    public Object get(GeneratedMessageV3.Builder param1Builder) {
      ArrayList<Object> arrayList = new ArrayList();
      for (int i = 0; i < getRepeatedCount(param1Builder); i++)
        arrayList.add(getRepeated(param1Builder, i)); 
      return Collections.unmodifiableList(arrayList);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      ArrayList<Object> arrayList = new ArrayList();
      for (int i = 0; i < getRepeatedCount(param1GeneratedMessageV3); i++)
        arrayList.add(getRepeated(param1GeneratedMessageV3, i)); 
      return Collections.unmodifiableList(arrayList);
    }
    
    public Message.Builder getBuilder(GeneratedMessageV3.Builder param1Builder) {
      throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }
    
    public Object getRaw(GeneratedMessageV3.Builder param1Builder) {
      return get(param1Builder);
    }
    
    public Object getRaw(GeneratedMessageV3 param1GeneratedMessageV3) {
      return get(param1GeneratedMessageV3);
    }
    
    public Object getRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      return getMapField(param1Builder).getList().get(param1Int);
    }
    
    public Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      return getMapField(param1GeneratedMessageV3).getList().get(param1Int);
    }
    
    public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }
    
    public int getRepeatedCount(GeneratedMessageV3.Builder param1Builder) {
      return getMapField(param1Builder).getList().size();
    }
    
    public int getRepeatedCount(GeneratedMessageV3 param1GeneratedMessageV3) {
      return getMapField(param1GeneratedMessageV3).getList().size();
    }
    
    public Object getRepeatedRaw(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      return getRepeated(param1Builder, param1Int);
    }
    
    public Object getRepeatedRaw(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      return getRepeated(param1GeneratedMessageV3, param1Int);
    }
    
    public boolean has(GeneratedMessageV3.Builder param1Builder) {
      throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }
    
    public boolean has(GeneratedMessageV3 param1GeneratedMessageV3) {
      throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }
    
    public Message.Builder newBuilder() {
      return this.mapEntryMessageDefaultInstance.newBuilderForType();
    }
    
    public void set(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      clear(param1Builder);
      param1Object = ((List)param1Object).iterator();
      while (param1Object.hasNext())
        addRepeated(param1Builder, param1Object.next()); 
    }
    
    public void setRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int, Object param1Object) {
      getMutableMapField(param1Builder).getMutableList().set(param1Int, coerceType((Message)param1Object));
    }
  }
  
  static class OneofAccessor {
    private final Method caseMethod;
    
    private final Method caseMethodBuilder;
    
    private final Method clearMethod;
    
    private final Descriptors.Descriptor descriptor;
    
    private final Descriptors.FieldDescriptor fieldDescriptor;
    
    OneofAccessor(Descriptors.Descriptor param1Descriptor, int param1Int, String param1String, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      this.descriptor = param1Descriptor;
      Descriptors.OneofDescriptor oneofDescriptor = param1Descriptor.getOneofs().get(param1Int);
      if (oneofDescriptor.isSynthetic()) {
        this.caseMethod = null;
        this.caseMethodBuilder = null;
        this.fieldDescriptor = oneofDescriptor.getFields().get(0);
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param1String);
        stringBuilder1.append("Case");
        this.caseMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder1.toString(), new Class[0]);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param1String);
        stringBuilder1.append("Case");
        this.caseMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder1.toString(), new Class[0]);
        this.fieldDescriptor = null;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("clear");
      stringBuilder.append(param1String);
      this.clearMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[0]);
    }
    
    public void clear(GeneratedMessageV3.Builder param1Builder) {
      GeneratedMessageV3.invokeOrDie(this.clearMethod, param1Builder, new Object[0]);
    }
    
    public Descriptors.FieldDescriptor get(GeneratedMessageV3.Builder param1Builder) {
      Descriptors.FieldDescriptor fieldDescriptor2 = this.fieldDescriptor;
      Descriptors.FieldDescriptor fieldDescriptor1 = null;
      if (fieldDescriptor2 != null) {
        if (param1Builder.hasField(fieldDescriptor2))
          fieldDescriptor1 = this.fieldDescriptor; 
        return fieldDescriptor1;
      } 
      int i = ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param1Builder, new Object[0])).getNumber();
      return (i > 0) ? this.descriptor.findFieldByNumber(i) : null;
    }
    
    public Descriptors.FieldDescriptor get(GeneratedMessageV3 param1GeneratedMessageV3) {
      Descriptors.FieldDescriptor fieldDescriptor2 = this.fieldDescriptor;
      Descriptors.FieldDescriptor fieldDescriptor1 = null;
      if (fieldDescriptor2 != null) {
        if (param1GeneratedMessageV3.hasField(fieldDescriptor2))
          fieldDescriptor1 = this.fieldDescriptor; 
        return fieldDescriptor1;
      } 
      int i = ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param1GeneratedMessageV3, new Object[0])).getNumber();
      return (i > 0) ? this.descriptor.findFieldByNumber(i) : null;
    }
    
    public boolean has(GeneratedMessageV3.Builder param1Builder) {
      Descriptors.FieldDescriptor fieldDescriptor = this.fieldDescriptor;
      return (fieldDescriptor != null) ? param1Builder.hasField(fieldDescriptor) : (!(((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param1Builder, new Object[0])).getNumber() == 0));
    }
    
    public boolean has(GeneratedMessageV3 param1GeneratedMessageV3) {
      Descriptors.FieldDescriptor fieldDescriptor = this.fieldDescriptor;
      return (fieldDescriptor != null) ? param1GeneratedMessageV3.hasField(fieldDescriptor) : (!(((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param1GeneratedMessageV3, new Object[0])).getNumber() == 0));
    }
  }
  
  static final class RepeatedEnumFieldAccessor extends FieldAccessorTable.RepeatedFieldAccessor {
    private Method addRepeatedValueMethod;
    
    private Descriptors.EnumDescriptor enumDescriptor;
    
    private Method getRepeatedValueMethod;
    
    private Method getRepeatedValueMethodBuilder;
    
    private final Method getValueDescriptorMethod;
    
    private Method setRepeatedValueMethod;
    
    private boolean supportUnknownEnumValue;
    
    private final Method valueOfMethod;
    
    RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      super(param1FieldDescriptor, param1String, param1Class, param1Class1);
      this.enumDescriptor = param1FieldDescriptor.getEnumType();
      this.valueOfMethod = GeneratedMessageV3.getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      this.getValueDescriptorMethod = GeneratedMessageV3.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
      this.supportUnknownEnumValue = param1FieldDescriptor.getFile().supportsUnknownEnumValue();
      if (this.supportUnknownEnumValue) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param1String);
        stringBuilder.append("Value");
        this.getRepeatedValueMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder.toString(), new Class[] { int.class });
        stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param1String);
        stringBuilder.append("Value");
        this.getRepeatedValueMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[] { int.class });
        stringBuilder = new StringBuilder();
        stringBuilder.append("set");
        stringBuilder.append(param1String);
        stringBuilder.append("Value");
        this.setRepeatedValueMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[] { int.class, int.class });
        stringBuilder = new StringBuilder();
        stringBuilder.append("add");
        stringBuilder.append(param1String);
        stringBuilder.append("Value");
        this.addRepeatedValueMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[] { int.class });
      } 
    }
    
    public void addRepeated(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      if (this.supportUnknownEnumValue) {
        GeneratedMessageV3.invokeOrDie(this.addRepeatedValueMethod, param1Builder, new Object[] { Integer.valueOf(((Descriptors.EnumValueDescriptor)param1Object).getNumber()) });
        return;
      } 
      super.addRepeated(param1Builder, GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, new Object[] { param1Object }));
    }
    
    public Object get(GeneratedMessageV3.Builder param1Builder) {
      ArrayList<Object> arrayList = new ArrayList();
      int j = getRepeatedCount(param1Builder);
      for (int i = 0; i < j; i++)
        arrayList.add(getRepeated(param1Builder, i)); 
      return Collections.unmodifiableList(arrayList);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      ArrayList<Object> arrayList = new ArrayList();
      int j = getRepeatedCount(param1GeneratedMessageV3);
      for (int i = 0; i < j; i++)
        arrayList.add(getRepeated(param1GeneratedMessageV3, i)); 
      return Collections.unmodifiableList(arrayList);
    }
    
    public Object getRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      if (this.supportUnknownEnumValue) {
        param1Int = ((Integer)GeneratedMessageV3.invokeOrDie(this.getRepeatedValueMethodBuilder, param1Builder, new Object[] { Integer.valueOf(param1Int) })).intValue();
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(param1Int);
      } 
      return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(param1Builder, param1Int), new Object[0]);
    }
    
    public Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      if (this.supportUnknownEnumValue) {
        param1Int = ((Integer)GeneratedMessageV3.invokeOrDie(this.getRepeatedValueMethod, param1GeneratedMessageV3, new Object[] { Integer.valueOf(param1Int) })).intValue();
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(param1Int);
      } 
      return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(param1GeneratedMessageV3, param1Int), new Object[0]);
    }
    
    public void setRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int, Object param1Object) {
      if (this.supportUnknownEnumValue) {
        GeneratedMessageV3.invokeOrDie(this.setRepeatedValueMethod, param1Builder, new Object[] { Integer.valueOf(param1Int), Integer.valueOf(((Descriptors.EnumValueDescriptor)param1Object).getNumber()) });
        return;
      } 
      super.setRepeated(param1Builder, param1Int, GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, new Object[] { param1Object }));
    }
  }
  
  static class RepeatedFieldAccessor implements FieldAccessorTable.FieldAccessor {
    protected final MethodInvoker invoker;
    
    protected final Class type;
    
    RepeatedFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      ReflectionInvoker reflectionInvoker = new ReflectionInvoker(param1FieldDescriptor, param1String, param1Class, param1Class1);
      this.type = reflectionInvoker.getRepeatedMethod.getReturnType();
      this.invoker = getMethodInvoker(reflectionInvoker);
    }
    
    static MethodInvoker getMethodInvoker(ReflectionInvoker param1ReflectionInvoker) {
      return param1ReflectionInvoker;
    }
    
    public void addRepeated(GeneratedMessageV3.Builder<?> param1Builder, Object param1Object) {
      this.invoker.addRepeated(param1Builder, param1Object);
    }
    
    public void clear(GeneratedMessageV3.Builder<?> param1Builder) {
      this.invoker.clear(param1Builder);
    }
    
    public Object get(GeneratedMessageV3.Builder<?> param1Builder) {
      return this.invoker.get(param1Builder);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      return this.invoker.get(param1GeneratedMessageV3);
    }
    
    public Message.Builder getBuilder(GeneratedMessageV3.Builder param1Builder) {
      throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }
    
    public Object getRaw(GeneratedMessageV3.Builder param1Builder) {
      return get(param1Builder);
    }
    
    public Object getRaw(GeneratedMessageV3 param1GeneratedMessageV3) {
      return get(param1GeneratedMessageV3);
    }
    
    public Object getRepeated(GeneratedMessageV3.Builder<?> param1Builder, int param1Int) {
      return this.invoker.getRepeated(param1Builder, param1Int);
    }
    
    public Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      return this.invoker.getRepeated(param1GeneratedMessageV3, param1Int);
    }
    
    public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
    }
    
    public int getRepeatedCount(GeneratedMessageV3.Builder<?> param1Builder) {
      return this.invoker.getRepeatedCount(param1Builder);
    }
    
    public int getRepeatedCount(GeneratedMessageV3 param1GeneratedMessageV3) {
      return this.invoker.getRepeatedCount(param1GeneratedMessageV3);
    }
    
    public Object getRepeatedRaw(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      return getRepeated(param1Builder, param1Int);
    }
    
    public Object getRepeatedRaw(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      return getRepeated(param1GeneratedMessageV3, param1Int);
    }
    
    public boolean has(GeneratedMessageV3.Builder param1Builder) {
      throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }
    
    public boolean has(GeneratedMessageV3 param1GeneratedMessageV3) {
      throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }
    
    public Message.Builder newBuilder() {
      throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }
    
    public void set(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      clear(param1Builder);
      param1Object = ((List)param1Object).iterator();
      while (param1Object.hasNext())
        addRepeated(param1Builder, param1Object.next()); 
    }
    
    public void setRepeated(GeneratedMessageV3.Builder<?> param1Builder, int param1Int, Object param1Object) {
      this.invoker.setRepeated(param1Builder, param1Int, param1Object);
    }
    
    static interface MethodInvoker {
      void addRepeated(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object);
      
      void clear(GeneratedMessageV3.Builder<?> param3Builder);
      
      Object get(GeneratedMessageV3.Builder<?> param3Builder);
      
      Object get(GeneratedMessageV3 param3GeneratedMessageV3);
      
      Object getRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int);
      
      Object getRepeated(GeneratedMessageV3 param3GeneratedMessageV3, int param3Int);
      
      int getRepeatedCount(GeneratedMessageV3.Builder<?> param3Builder);
      
      int getRepeatedCount(GeneratedMessageV3 param3GeneratedMessageV3);
      
      void setRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int, Object param3Object);
    }
    
    static final class ReflectionInvoker implements MethodInvoker {
      protected final Method addRepeatedMethod;
      
      protected final Method clearMethod;
      
      protected final Method getCountMethod;
      
      protected final Method getCountMethodBuilder;
      
      protected final Method getMethod;
      
      protected final Method getMethodBuilder;
      
      protected final Method getRepeatedMethod;
      
      protected final Method getRepeatedMethodBuilder;
      
      protected final Method setRepeatedMethod;
      
      ReflectionInvoker(Descriptors.FieldDescriptor param3FieldDescriptor, String param3String, Class<? extends GeneratedMessageV3> param3Class, Class<? extends GeneratedMessageV3.Builder> param3Class1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param3String);
        stringBuilder2.append("List");
        this.getMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder2.toString(), new Class[0]);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param3String);
        stringBuilder2.append("List");
        this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder2.toString(), new Class[0]);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param3String);
        this.getRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder2.toString(), new Class[] { int.class });
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param3String);
        this.getRepeatedMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder2.toString(), new Class[] { int.class });
        Class<?> clazz = this.getRepeatedMethod.getReturnType();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("set");
        stringBuilder3.append(param3String);
        this.setRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder3.toString(), new Class[] { int.class, clazz });
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append("add");
        stringBuilder3.append(param3String);
        this.addRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder3.toString(), new Class[] { clazz });
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param3String);
        stringBuilder1.append("Count");
        this.getCountMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder1.toString(), new Class[0]);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param3String);
        stringBuilder1.append("Count");
        this.getCountMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("clear");
        stringBuilder1.append(param3String);
        this.clearMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
      }
      
      public void addRepeated(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object) {
        GeneratedMessageV3.invokeOrDie(this.addRepeatedMethod, param3Builder, new Object[] { param3Object });
      }
      
      public void clear(GeneratedMessageV3.Builder<?> param3Builder) {
        GeneratedMessageV3.invokeOrDie(this.clearMethod, param3Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3.Builder<?> param3Builder) {
        return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param3Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3 param3GeneratedMessageV3) {
        return GeneratedMessageV3.invokeOrDie(this.getMethod, param3GeneratedMessageV3, new Object[0]);
      }
      
      public Object getRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int) {
        return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethodBuilder, param3Builder, new Object[] { Integer.valueOf(param3Int) });
      }
      
      public Object getRepeated(GeneratedMessageV3 param3GeneratedMessageV3, int param3Int) {
        return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethod, param3GeneratedMessageV3, new Object[] { Integer.valueOf(param3Int) });
      }
      
      public int getRepeatedCount(GeneratedMessageV3.Builder<?> param3Builder) {
        return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethodBuilder, param3Builder, new Object[0])).intValue();
      }
      
      public int getRepeatedCount(GeneratedMessageV3 param3GeneratedMessageV3) {
        return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethod, param3GeneratedMessageV3, new Object[0])).intValue();
      }
      
      public void setRepeated(GeneratedMessageV3.Builder<?> param3Builder, int param3Int, Object param3Object) {
        GeneratedMessageV3.invokeOrDie(this.setRepeatedMethod, param3Builder, new Object[] { Integer.valueOf(param3Int), param3Object });
      }
    }
  }
  
  static interface MethodInvoker {
    void addRepeated(GeneratedMessageV3.Builder<?> param1Builder, Object param1Object);
    
    void clear(GeneratedMessageV3.Builder<?> param1Builder);
    
    Object get(GeneratedMessageV3.Builder<?> param1Builder);
    
    Object get(GeneratedMessageV3 param1GeneratedMessageV3);
    
    Object getRepeated(GeneratedMessageV3.Builder<?> param1Builder, int param1Int);
    
    Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int);
    
    int getRepeatedCount(GeneratedMessageV3.Builder<?> param1Builder);
    
    int getRepeatedCount(GeneratedMessageV3 param1GeneratedMessageV3);
    
    void setRepeated(GeneratedMessageV3.Builder<?> param1Builder, int param1Int, Object param1Object);
  }
  
  static final class ReflectionInvoker implements FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker {
    protected final Method addRepeatedMethod;
    
    protected final Method clearMethod;
    
    protected final Method getCountMethod;
    
    protected final Method getCountMethodBuilder;
    
    protected final Method getMethod;
    
    protected final Method getMethodBuilder;
    
    protected final Method getRepeatedMethod;
    
    protected final Method getRepeatedMethodBuilder;
    
    protected final Method setRepeatedMethod;
    
    ReflectionInvoker(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(param1String);
      stringBuilder2.append("List");
      this.getMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder2.toString(), new Class[0]);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(param1String);
      stringBuilder2.append("List");
      this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder2.toString(), new Class[0]);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(param1String);
      this.getRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder2.toString(), new Class[] { int.class });
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(param1String);
      this.getRepeatedMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder2.toString(), new Class[] { int.class });
      Class<?> clazz = this.getRepeatedMethod.getReturnType();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("set");
      stringBuilder3.append(param1String);
      this.setRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder3.toString(), new Class[] { int.class, clazz });
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("add");
      stringBuilder3.append(param1String);
      this.addRepeatedMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder3.toString(), new Class[] { clazz });
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("get");
      stringBuilder1.append(param1String);
      stringBuilder1.append("Count");
      this.getCountMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder1.toString(), new Class[0]);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("get");
      stringBuilder1.append(param1String);
      stringBuilder1.append("Count");
      this.getCountMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder1.toString(), new Class[0]);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("clear");
      stringBuilder1.append(param1String);
      this.clearMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder1.toString(), new Class[0]);
    }
    
    public void addRepeated(GeneratedMessageV3.Builder<?> param1Builder, Object param1Object) {
      GeneratedMessageV3.invokeOrDie(this.addRepeatedMethod, param1Builder, new Object[] { param1Object });
    }
    
    public void clear(GeneratedMessageV3.Builder<?> param1Builder) {
      GeneratedMessageV3.invokeOrDie(this.clearMethod, param1Builder, new Object[0]);
    }
    
    public Object get(GeneratedMessageV3.Builder<?> param1Builder) {
      return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param1Builder, new Object[0]);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      return GeneratedMessageV3.invokeOrDie(this.getMethod, param1GeneratedMessageV3, new Object[0]);
    }
    
    public Object getRepeated(GeneratedMessageV3.Builder<?> param1Builder, int param1Int) {
      return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethodBuilder, param1Builder, new Object[] { Integer.valueOf(param1Int) });
    }
    
    public Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      return GeneratedMessageV3.invokeOrDie(this.getRepeatedMethod, param1GeneratedMessageV3, new Object[] { Integer.valueOf(param1Int) });
    }
    
    public int getRepeatedCount(GeneratedMessageV3.Builder<?> param1Builder) {
      return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethodBuilder, param1Builder, new Object[0])).intValue();
    }
    
    public int getRepeatedCount(GeneratedMessageV3 param1GeneratedMessageV3) {
      return ((Integer)GeneratedMessageV3.invokeOrDie(this.getCountMethod, param1GeneratedMessageV3, new Object[0])).intValue();
    }
    
    public void setRepeated(GeneratedMessageV3.Builder<?> param1Builder, int param1Int, Object param1Object) {
      GeneratedMessageV3.invokeOrDie(this.setRepeatedMethod, param1Builder, new Object[] { Integer.valueOf(param1Int), param1Object });
    }
  }
  
  static final class RepeatedMessageFieldAccessor extends FieldAccessorTable.RepeatedFieldAccessor {
    private final Method getBuilderMethodBuilder;
    
    private final Method newBuilderMethod = GeneratedMessageV3.getMethodOrDie(this.type, "newBuilder", new Class[0]);
    
    RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1) {
      super(param1FieldDescriptor, param1String, param1Class, param1Class1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get");
      stringBuilder.append(param1String);
      stringBuilder.append("Builder");
      this.getBuilderMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[] { int.class });
    }
    
    private Object coerceType(Object param1Object) {
      return this.type.isInstance(param1Object) ? param1Object : ((Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)param1Object).build();
    }
    
    public void addRepeated(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      super.addRepeated(param1Builder, coerceType(param1Object));
    }
    
    public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.getBuilderMethodBuilder, param1Builder, new Object[] { Integer.valueOf(param1Int) });
    }
    
    public Message.Builder newBuilder() {
      return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
    }
    
    public void setRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int, Object param1Object) {
      super.setRepeated(param1Builder, param1Int, coerceType(param1Object));
    }
  }
  
  static final class SingularEnumFieldAccessor extends FieldAccessorTable.SingularFieldAccessor {
    private Descriptors.EnumDescriptor enumDescriptor;
    
    private Method getValueDescriptorMethod;
    
    private Method getValueMethod;
    
    private Method getValueMethodBuilder;
    
    private Method setValueMethod;
    
    private boolean supportUnknownEnumValue;
    
    private Method valueOfMethod;
    
    SingularEnumFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String1, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1, String param1String2) {
      super(param1FieldDescriptor, param1String1, param1Class, param1Class1, param1String2);
      this.enumDescriptor = param1FieldDescriptor.getEnumType();
      this.valueOfMethod = GeneratedMessageV3.getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      this.getValueDescriptorMethod = GeneratedMessageV3.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
      this.supportUnknownEnumValue = param1FieldDescriptor.getFile().supportsUnknownEnumValue();
      if (this.supportUnknownEnumValue) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param1String1);
        stringBuilder.append("Value");
        this.getValueMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder.toString(), new Class[0]);
        stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(param1String1);
        stringBuilder.append("Value");
        this.getValueMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[0]);
        stringBuilder = new StringBuilder();
        stringBuilder.append("set");
        stringBuilder.append(param1String1);
        stringBuilder.append("Value");
        this.setValueMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[] { int.class });
      } 
    }
    
    public Object get(GeneratedMessageV3.Builder param1Builder) {
      if (this.supportUnknownEnumValue) {
        int i = ((Integer)GeneratedMessageV3.invokeOrDie(this.getValueMethodBuilder, param1Builder, new Object[0])).intValue();
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(i);
      } 
      return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.get(param1Builder), new Object[0]);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      if (this.supportUnknownEnumValue) {
        int i = ((Integer)GeneratedMessageV3.invokeOrDie(this.getValueMethod, param1GeneratedMessageV3, new Object[0])).intValue();
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(i);
      } 
      return GeneratedMessageV3.invokeOrDie(this.getValueDescriptorMethod, super.get(param1GeneratedMessageV3), new Object[0]);
    }
    
    public void set(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      if (this.supportUnknownEnumValue) {
        GeneratedMessageV3.invokeOrDie(this.setValueMethod, param1Builder, new Object[] { Integer.valueOf(((Descriptors.EnumValueDescriptor)param1Object).getNumber()) });
        return;
      } 
      super.set(param1Builder, GeneratedMessageV3.invokeOrDie(this.valueOfMethod, null, new Object[] { param1Object }));
    }
  }
  
  static class SingularFieldAccessor implements FieldAccessorTable.FieldAccessor {
    protected final Descriptors.FieldDescriptor field;
    
    protected final boolean hasHasMethod;
    
    protected final MethodInvoker invoker;
    
    protected final boolean isOneofField;
    
    protected final Class<?> type;
    
    SingularFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String1, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1, String param1String2) {
      Descriptors.OneofDescriptor oneofDescriptor = param1FieldDescriptor.getContainingOneof();
      boolean bool2 = true;
      if (oneofDescriptor != null && !param1FieldDescriptor.getContainingOneof().isSynthetic()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.isOneofField = bool1;
      boolean bool1 = bool2;
      if (param1FieldDescriptor.getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO2) {
        bool1 = bool2;
        if (!param1FieldDescriptor.hasOptionalKeyword())
          if (!this.isOneofField && param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }  
      } 
      this.hasHasMethod = bool1;
      ReflectionInvoker reflectionInvoker = new ReflectionInvoker(param1FieldDescriptor, param1String1, param1Class, param1Class1, param1String2, this.isOneofField, this.hasHasMethod);
      this.field = param1FieldDescriptor;
      this.type = reflectionInvoker.getMethod.getReturnType();
      this.invoker = getMethodInvoker(reflectionInvoker);
    }
    
    static MethodInvoker getMethodInvoker(ReflectionInvoker param1ReflectionInvoker) {
      return param1ReflectionInvoker;
    }
    
    public void addRepeated(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }
    
    public void clear(GeneratedMessageV3.Builder<?> param1Builder) {
      this.invoker.clear(param1Builder);
    }
    
    public Object get(GeneratedMessageV3.Builder<?> param1Builder) {
      return this.invoker.get(param1Builder);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      return this.invoker.get(param1GeneratedMessageV3);
    }
    
    public Message.Builder getBuilder(GeneratedMessageV3.Builder param1Builder) {
      throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }
    
    public Object getRaw(GeneratedMessageV3.Builder param1Builder) {
      return get(param1Builder);
    }
    
    public Object getRaw(GeneratedMessageV3 param1GeneratedMessageV3) {
      return get(param1GeneratedMessageV3);
    }
    
    public Object getRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }
    
    public Object getRepeated(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }
    
    public Message.Builder getRepeatedBuilder(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
    }
    
    public int getRepeatedCount(GeneratedMessageV3.Builder param1Builder) {
      throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }
    
    public int getRepeatedCount(GeneratedMessageV3 param1GeneratedMessageV3) {
      throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }
    
    public Object getRepeatedRaw(GeneratedMessageV3.Builder param1Builder, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
    }
    
    public Object getRepeatedRaw(GeneratedMessageV3 param1GeneratedMessageV3, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
    }
    
    public boolean has(GeneratedMessageV3.Builder<?> param1Builder) {
      return !this.hasHasMethod ? (this.isOneofField ? ((this.invoker.getOneofFieldNumber(param1Builder) == this.field.getNumber())) : (get(param1Builder).equals(this.field.getDefaultValue()) ^ true)) : this.invoker.has(param1Builder);
    }
    
    public boolean has(GeneratedMessageV3 param1GeneratedMessageV3) {
      return !this.hasHasMethod ? (this.isOneofField ? ((this.invoker.getOneofFieldNumber(param1GeneratedMessageV3) == this.field.getNumber())) : (get(param1GeneratedMessageV3).equals(this.field.getDefaultValue()) ^ true)) : this.invoker.has(param1GeneratedMessageV3);
    }
    
    public Message.Builder newBuilder() {
      throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }
    
    public void set(GeneratedMessageV3.Builder<?> param1Builder, Object param1Object) {
      this.invoker.set(param1Builder, param1Object);
    }
    
    public void setRepeated(GeneratedMessageV3.Builder param1Builder, int param1Int, Object param1Object) {
      throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
    }
    
    static interface MethodInvoker {
      void clear(GeneratedMessageV3.Builder<?> param3Builder);
      
      Object get(GeneratedMessageV3.Builder<?> param3Builder);
      
      Object get(GeneratedMessageV3 param3GeneratedMessageV3);
      
      int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param3Builder);
      
      int getOneofFieldNumber(GeneratedMessageV3 param3GeneratedMessageV3);
      
      boolean has(GeneratedMessageV3.Builder<?> param3Builder);
      
      boolean has(GeneratedMessageV3 param3GeneratedMessageV3);
      
      void set(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object);
    }
    
    static final class ReflectionInvoker implements MethodInvoker {
      protected final Method caseMethod;
      
      protected final Method caseMethodBuilder;
      
      protected final Method clearMethod;
      
      protected final Method getMethod;
      
      protected final Method getMethodBuilder;
      
      protected final Method hasMethod;
      
      protected final Method hasMethodBuilder;
      
      protected final Method setMethod;
      
      ReflectionInvoker(Descriptors.FieldDescriptor param3FieldDescriptor, String param3String1, Class<? extends GeneratedMessageV3> param3Class, Class<? extends GeneratedMessageV3.Builder> param3Class1, String param3String2, boolean param3Boolean1, boolean param3Boolean2) {
        Method method;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param3String1);
        this.getMethod = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder2.toString(), new Class[0]);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get");
        stringBuilder2.append(param3String1);
        this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder2.toString(), new Class[0]);
        Class<?> clazz = this.getMethod.getReturnType();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("set");
        stringBuilder3.append(param3String1);
        this.setMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder3.toString(), new Class[] { clazz });
        stringBuilder3 = null;
        if (param3Boolean2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("has");
          stringBuilder.append(param3String1);
          method = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder.toString(), new Class[0]);
        } else {
          clazz = null;
        } 
        this.hasMethod = (Method)clazz;
        if (param3Boolean2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("has");
          stringBuilder.append(param3String1);
          method = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder.toString(), new Class[0]);
        } else {
          clazz = null;
        } 
        this.hasMethodBuilder = (Method)clazz;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("clear");
        stringBuilder1.append(param3String1);
        this.clearMethod = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
        if (param3Boolean1) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param3String2);
          stringBuilder1.append("Case");
          method = GeneratedMessageV3.getMethodOrDie(param3Class, stringBuilder1.toString(), new Class[0]);
        } else {
          stringBuilder1 = null;
        } 
        this.caseMethod = (Method)stringBuilder1;
        stringBuilder1 = stringBuilder3;
        if (param3Boolean1) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("get");
          stringBuilder1.append(param3String2);
          stringBuilder1.append("Case");
          method = GeneratedMessageV3.getMethodOrDie(param3Class1, stringBuilder1.toString(), new Class[0]);
        } 
        this.caseMethodBuilder = method;
      }
      
      public void clear(GeneratedMessageV3.Builder<?> param3Builder) {
        GeneratedMessageV3.invokeOrDie(this.clearMethod, param3Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3.Builder<?> param3Builder) {
        return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param3Builder, new Object[0]);
      }
      
      public Object get(GeneratedMessageV3 param3GeneratedMessageV3) {
        return GeneratedMessageV3.invokeOrDie(this.getMethod, param3GeneratedMessageV3, new Object[0]);
      }
      
      public int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param3Builder) {
        return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param3Builder, new Object[0])).getNumber();
      }
      
      public int getOneofFieldNumber(GeneratedMessageV3 param3GeneratedMessageV3) {
        return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param3GeneratedMessageV3, new Object[0])).getNumber();
      }
      
      public boolean has(GeneratedMessageV3.Builder<?> param3Builder) {
        return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethodBuilder, param3Builder, new Object[0])).booleanValue();
      }
      
      public boolean has(GeneratedMessageV3 param3GeneratedMessageV3) {
        return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethod, param3GeneratedMessageV3, new Object[0])).booleanValue();
      }
      
      public void set(GeneratedMessageV3.Builder<?> param3Builder, Object param3Object) {
        GeneratedMessageV3.invokeOrDie(this.setMethod, param3Builder, new Object[] { param3Object });
      }
    }
  }
  
  static interface MethodInvoker {
    void clear(GeneratedMessageV3.Builder<?> param1Builder);
    
    Object get(GeneratedMessageV3.Builder<?> param1Builder);
    
    Object get(GeneratedMessageV3 param1GeneratedMessageV3);
    
    int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param1Builder);
    
    int getOneofFieldNumber(GeneratedMessageV3 param1GeneratedMessageV3);
    
    boolean has(GeneratedMessageV3.Builder<?> param1Builder);
    
    boolean has(GeneratedMessageV3 param1GeneratedMessageV3);
    
    void set(GeneratedMessageV3.Builder<?> param1Builder, Object param1Object);
  }
  
  static final class ReflectionInvoker implements FieldAccessorTable.SingularFieldAccessor.MethodInvoker {
    protected final Method caseMethod;
    
    protected final Method caseMethodBuilder;
    
    protected final Method clearMethod;
    
    protected final Method getMethod;
    
    protected final Method getMethodBuilder;
    
    protected final Method hasMethod;
    
    protected final Method hasMethodBuilder;
    
    protected final Method setMethod;
    
    ReflectionInvoker(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String1, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1, String param1String2, boolean param1Boolean1, boolean param1Boolean2) {
      Method method;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(param1String1);
      this.getMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder2.toString(), new Class[0]);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(param1String1);
      this.getMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder2.toString(), new Class[0]);
      Class<?> clazz = this.getMethod.getReturnType();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("set");
      stringBuilder3.append(param1String1);
      this.setMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder3.toString(), new Class[] { clazz });
      stringBuilder3 = null;
      if (param1Boolean2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("has");
        stringBuilder.append(param1String1);
        method = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder.toString(), new Class[0]);
      } else {
        clazz = null;
      } 
      this.hasMethod = (Method)clazz;
      if (param1Boolean2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("has");
        stringBuilder.append(param1String1);
        method = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[0]);
      } else {
        clazz = null;
      } 
      this.hasMethodBuilder = (Method)clazz;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("clear");
      stringBuilder1.append(param1String1);
      this.clearMethod = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder1.toString(), new Class[0]);
      if (param1Boolean1) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param1String2);
        stringBuilder1.append("Case");
        method = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder1.toString(), new Class[0]);
      } else {
        stringBuilder1 = null;
      } 
      this.caseMethod = (Method)stringBuilder1;
      stringBuilder1 = stringBuilder3;
      if (param1Boolean1) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(param1String2);
        stringBuilder1.append("Case");
        method = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder1.toString(), new Class[0]);
      } 
      this.caseMethodBuilder = method;
    }
    
    public void clear(GeneratedMessageV3.Builder<?> param1Builder) {
      GeneratedMessageV3.invokeOrDie(this.clearMethod, param1Builder, new Object[0]);
    }
    
    public Object get(GeneratedMessageV3.Builder<?> param1Builder) {
      return GeneratedMessageV3.invokeOrDie(this.getMethodBuilder, param1Builder, new Object[0]);
    }
    
    public Object get(GeneratedMessageV3 param1GeneratedMessageV3) {
      return GeneratedMessageV3.invokeOrDie(this.getMethod, param1GeneratedMessageV3, new Object[0]);
    }
    
    public int getOneofFieldNumber(GeneratedMessageV3.Builder<?> param1Builder) {
      return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethodBuilder, param1Builder, new Object[0])).getNumber();
    }
    
    public int getOneofFieldNumber(GeneratedMessageV3 param1GeneratedMessageV3) {
      return ((Internal.EnumLite)GeneratedMessageV3.invokeOrDie(this.caseMethod, param1GeneratedMessageV3, new Object[0])).getNumber();
    }
    
    public boolean has(GeneratedMessageV3.Builder<?> param1Builder) {
      return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethodBuilder, param1Builder, new Object[0])).booleanValue();
    }
    
    public boolean has(GeneratedMessageV3 param1GeneratedMessageV3) {
      return ((Boolean)GeneratedMessageV3.invokeOrDie(this.hasMethod, param1GeneratedMessageV3, new Object[0])).booleanValue();
    }
    
    public void set(GeneratedMessageV3.Builder<?> param1Builder, Object param1Object) {
      GeneratedMessageV3.invokeOrDie(this.setMethod, param1Builder, new Object[] { param1Object });
    }
  }
  
  static final class SingularMessageFieldAccessor extends FieldAccessorTable.SingularFieldAccessor {
    private final Method getBuilderMethodBuilder;
    
    private final Method newBuilderMethod = GeneratedMessageV3.getMethodOrDie(this.type, "newBuilder", new Class[0]);
    
    SingularMessageFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String1, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1, String param1String2) {
      super(param1FieldDescriptor, param1String1, param1Class, param1Class1, param1String2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get");
      stringBuilder.append(param1String1);
      stringBuilder.append("Builder");
      this.getBuilderMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[0]);
    }
    
    private Object coerceType(Object param1Object) {
      return this.type.isInstance(param1Object) ? param1Object : ((Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)param1Object).buildPartial();
    }
    
    public Message.Builder getBuilder(GeneratedMessageV3.Builder param1Builder) {
      return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.getBuilderMethodBuilder, param1Builder, new Object[0]);
    }
    
    public Message.Builder newBuilder() {
      return (Message.Builder)GeneratedMessageV3.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
    }
    
    public void set(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      super.set(param1Builder, coerceType(param1Object));
    }
  }
  
  static final class SingularStringFieldAccessor extends FieldAccessorTable.SingularFieldAccessor {
    private final Method getBytesMethod;
    
    private final Method getBytesMethodBuilder;
    
    private final Method setBytesMethodBuilder;
    
    SingularStringFieldAccessor(Descriptors.FieldDescriptor param1FieldDescriptor, String param1String1, Class<? extends GeneratedMessageV3> param1Class, Class<? extends GeneratedMessageV3.Builder> param1Class1, String param1String2) {
      super(param1FieldDescriptor, param1String1, param1Class, param1Class1, param1String2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get");
      stringBuilder.append(param1String1);
      stringBuilder.append("Bytes");
      this.getBytesMethod = GeneratedMessageV3.getMethodOrDie(param1Class, stringBuilder.toString(), new Class[0]);
      stringBuilder = new StringBuilder();
      stringBuilder.append("get");
      stringBuilder.append(param1String1);
      stringBuilder.append("Bytes");
      this.getBytesMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[0]);
      stringBuilder = new StringBuilder();
      stringBuilder.append("set");
      stringBuilder.append(param1String1);
      stringBuilder.append("Bytes");
      this.setBytesMethodBuilder = GeneratedMessageV3.getMethodOrDie(param1Class1, stringBuilder.toString(), new Class[] { ByteString.class });
    }
    
    public Object getRaw(GeneratedMessageV3.Builder param1Builder) {
      return GeneratedMessageV3.invokeOrDie(this.getBytesMethodBuilder, param1Builder, new Object[0]);
    }
    
    public Object getRaw(GeneratedMessageV3 param1GeneratedMessageV3) {
      return GeneratedMessageV3.invokeOrDie(this.getBytesMethod, param1GeneratedMessageV3, new Object[0]);
    }
    
    public void set(GeneratedMessageV3.Builder param1Builder, Object param1Object) {
      if (param1Object instanceof ByteString) {
        GeneratedMessageV3.invokeOrDie(this.setBytesMethodBuilder, param1Builder, new Object[] { param1Object });
        return;
      } 
      super.set(param1Builder, param1Object);
    }
  }
  
  public static final class UnusedPrivateParameter {
    static final UnusedPrivateParameter INSTANCE = new UnusedPrivateParameter();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\GeneratedMessageV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
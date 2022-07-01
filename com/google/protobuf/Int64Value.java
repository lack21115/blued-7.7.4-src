package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Int64Value extends GeneratedMessageV3 implements Int64ValueOrBuilder {
  private static final Int64Value DEFAULT_INSTANCE = new Int64Value();
  
  private static final Parser<Int64Value> PARSER = new AbstractParser<Int64Value>() {
      public Int64Value parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Int64Value(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private long value_;
  
  private Int64Value() {}
  
  private Int64Value(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 8) {
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                continue; 
              continue;
            } 
            this.value_ = paramCodedInputStream.readInt64();
            continue;
          } 
          continue;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          throw invalidProtocolBufferException.setUnfinishedMessage(this);
        } catch (IOException iOException) {
          throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
        } finally {}
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Int64Value(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Int64Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Int64Value paramInt64Value) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramInt64Value);
  }
  
  public static Int64Value of(long paramLong) {
    return newBuilder().setValue(paramLong).build();
  }
  
  public static Int64Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Int64Value>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Int64Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Int64Value>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static Int64Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<Int64Value>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Int64Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Int64Value>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Int64Value>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Int64Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Int64Value>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Int64Value parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Int64Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Int64Value> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Int64Value))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getValue() != paramObject.getValue()) ? false : (!!this.unknownFields.equals(((Int64Value)paramObject).unknownFields));
  }
  
  public Int64Value getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Int64Value> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.value_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public long getValue() {
    return this.value_;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getValue())) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Int64Value.class, (Class)Builder.class);
  }
  
  public final boolean isInitialized() {
    byte b = this.memoizedIsInitialized;
    if (b == 1)
      return true; 
    if (b == 0)
      return false; 
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public Builder newBuilderForType() {
    return newBuilder();
  }
  
  protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent) {
    return new Builder(paramBuilderParent);
  }
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter) {
    return new Int64Value();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.value_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Int64ValueOrBuilder {
    private long value_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Int64Value build() {
      Int64Value int64Value = buildPartial();
      if (int64Value.isInitialized())
        return int64Value; 
      throw newUninitializedMessageException(int64Value);
    }
    
    public Int64Value buildPartial() {
      Int64Value int64Value = new Int64Value(this);
      Int64Value.access$302(int64Value, this.value_);
      onBuilt();
      return int64Value;
    }
    
    public Builder clear() {
      super.clear();
      this.value_ = 0L;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearValue() {
      this.value_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return super.clone();
    }
    
    public Int64Value getDefaultInstanceForType() {
      return Int64Value.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }
    
    public long getValue() {
      return this.value_;
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Int64Value.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Int64Value int64Value = Int64Value.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Int64Value int64Value = (Int64Value)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Int64Value)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Int64Value param1Int64Value) {
      if (param1Int64Value == Int64Value.getDefaultInstance())
        return this; 
      if (param1Int64Value.getValue() != 0L)
        setValue(param1Int64Value.getValue()); 
      mergeUnknownFields(param1Int64Value.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Int64Value)
        return mergeFrom((Int64Value)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setValue(long param1Long) {
      this.value_ = param1Long;
      onChanged();
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Int64Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
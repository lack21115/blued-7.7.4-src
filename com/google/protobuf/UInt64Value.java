package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UInt64Value extends GeneratedMessageV3 implements UInt64ValueOrBuilder {
  private static final UInt64Value DEFAULT_INSTANCE = new UInt64Value();
  
  private static final Parser<UInt64Value> PARSER = new AbstractParser<UInt64Value>() {
      public UInt64Value parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new UInt64Value(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private long value_;
  
  private UInt64Value() {}
  
  private UInt64Value(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.value_ = paramCodedInputStream.readUInt64();
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
  
  private UInt64Value(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static UInt64Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UInt64Value paramUInt64Value) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramUInt64Value);
  }
  
  public static UInt64Value of(long paramLong) {
    return newBuilder().setValue(paramLong).build();
  }
  
  public static UInt64Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<UInt64Value>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static UInt64Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<UInt64Value>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static UInt64Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<UInt64Value>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static UInt64Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<UInt64Value>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<UInt64Value>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static UInt64Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<UInt64Value>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static UInt64Value parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static UInt64Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UInt64Value> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof UInt64Value))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getValue() != paramObject.getValue()) ? false : (!!this.unknownFields.equals(((UInt64Value)paramObject).unknownFields));
  }
  
  public UInt64Value getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<UInt64Value> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.value_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeUInt64Size(1, l); 
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
    return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)UInt64Value.class, (Class)Builder.class);
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
    return new UInt64Value();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.value_;
    if (l != 0L)
      paramCodedOutputStream.writeUInt64(1, l); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UInt64ValueOrBuilder {
    private long value_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public UInt64Value build() {
      UInt64Value uInt64Value = buildPartial();
      if (uInt64Value.isInitialized())
        return uInt64Value; 
      throw newUninitializedMessageException(uInt64Value);
    }
    
    public UInt64Value buildPartial() {
      UInt64Value uInt64Value = new UInt64Value(this);
      UInt64Value.access$302(uInt64Value, this.value_);
      onBuilt();
      return uInt64Value;
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
    
    public UInt64Value getDefaultInstanceForType() {
      return UInt64Value.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }
    
    public long getValue() {
      return this.value_;
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)UInt64Value.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        UInt64Value uInt64Value = UInt64Value.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        UInt64Value uInt64Value = (UInt64Value)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((UInt64Value)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof UInt64Value)
        return mergeFrom((UInt64Value)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(UInt64Value param1UInt64Value) {
      if (param1UInt64Value == UInt64Value.getDefaultInstance())
        return this; 
      if (param1UInt64Value.getValue() != 0L)
        setValue(param1UInt64Value.getValue()); 
      mergeUnknownFields(param1UInt64Value.unknownFields);
      onChanged();
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UInt64Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
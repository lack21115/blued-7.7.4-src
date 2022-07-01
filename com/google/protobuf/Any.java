package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Any extends GeneratedMessageV3 implements AnyOrBuilder {
  private static final Any DEFAULT_INSTANCE = new Any();
  
  private static final Parser<Any> PARSER = new AbstractParser<Any>() {
      public Any parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Any(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_URL_FIELD_NUMBER = 1;
  
  public static final int VALUE_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Message cachedUnpackValue;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object typeUrl_;
  
  private ByteString value_;
  
  private Any() {
    this.typeUrl_ = "";
    this.value_ = ByteString.EMPTY;
  }
  
  private Any(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.value_ = paramCodedInputStream.readBytes();
              continue;
            } 
            this.typeUrl_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private Any(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Any getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AnyProto.internal_static_google_protobuf_Any_descriptor;
  }
  
  private static String getTypeNameFromTypeUrl(String paramString) {
    int i = paramString.lastIndexOf('/');
    return (i == -1) ? "" : paramString.substring(i + 1);
  }
  
  private static String getTypeUrl(String paramString, Descriptors.Descriptor paramDescriptor) {
    if (paramString.endsWith("/")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append(paramDescriptor.getFullName());
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("/");
    stringBuilder.append(paramDescriptor.getFullName());
    return stringBuilder.toString();
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Any paramAny) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAny);
  }
  
  public static <T extends Message> Any pack(T paramT) {
    return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", paramT.getDescriptorForType())).setValue(paramT.toByteString()).build();
  }
  
  public static <T extends Message> Any pack(T paramT, String paramString) {
    return newBuilder().setTypeUrl(getTypeUrl(paramString, paramT.getDescriptorForType())).setValue(paramT.toByteString()).build();
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Any>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Any>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static Any parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<Any>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Any>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Any>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Any parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Any>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Any parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Any parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Any> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Any))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getTypeUrl().equals(paramObject.getTypeUrl()) ? false : (!getValue().equals(paramObject.getValue()) ? false : (!!this.unknownFields.equals(((Any)paramObject).unknownFields)));
  }
  
  public Any getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Any> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getTypeUrlBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.typeUrl_); 
    int j = i;
    if (!this.value_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(2, this.value_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getTypeUrl() {
    Object object = this.typeUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.typeUrl_ = object;
    return (String)object;
  }
  
  public ByteString getTypeUrlBytes() {
    Object object = this.typeUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.typeUrl_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public ByteString getValue() {
    return this.value_;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getTypeUrl().hashCode()) * 37 + 2) * 53 + getValue().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Any.class, (Class)Builder.class);
  }
  
  public <T extends Message> boolean is(Class<T> paramClass) {
    Message message = Internal.<Message>getDefaultInstance(paramClass);
    return getTypeNameFromTypeUrl(getTypeUrl()).equals(message.getDescriptorForType().getFullName());
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
    return new Any();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public <T extends Message> T unpack(Class<T> paramClass) throws InvalidProtocolBufferException {
    boolean bool;
    if (this.cachedUnpackValue != null) {
      if (this.cachedUnpackValue.getClass() == paramClass)
        return (T)this.cachedUnpackValue; 
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool && is(paramClass)) {
      Message message = ((Message)Internal.<Message>getDefaultInstance(paramClass)).getParserForType().parseFrom(getValue());
      this.cachedUnpackValue = message;
      return (T)message;
    } 
    throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!getTypeUrlBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.typeUrl_); 
    if (!this.value_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.value_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnyOrBuilder {
    private Object typeUrl_ = "";
    
    private ByteString value_ = ByteString.EMPTY;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Any build() {
      Any any = buildPartial();
      if (any.isInitialized())
        return any; 
      throw newUninitializedMessageException(any);
    }
    
    public Any buildPartial() {
      Any any = new Any(this);
      Any.access$302(any, this.typeUrl_);
      Any.access$402(any, this.value_);
      onBuilt();
      return any;
    }
    
    public Builder clear() {
      super.clear();
      this.typeUrl_ = "";
      this.value_ = ByteString.EMPTY;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTypeUrl() {
      this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
      onChanged();
      return this;
    }
    
    public Builder clearValue() {
      this.value_ = Any.getDefaultInstance().getValue();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return super.clone();
    }
    
    public Any getDefaultInstanceForType() {
      return Any.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }
    
    public String getTypeUrl() {
      Object object = this.typeUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.typeUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTypeUrlBytes() {
      Object object = this.typeUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.typeUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public ByteString getValue() {
      return this.value_;
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Any.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Any param1Any) {
      if (param1Any == Any.getDefaultInstance())
        return this; 
      if (!param1Any.getTypeUrl().isEmpty()) {
        this.typeUrl_ = param1Any.typeUrl_;
        onChanged();
      } 
      if (param1Any.getValue() != ByteString.EMPTY)
        setValue(param1Any.getValue()); 
      mergeUnknownFields(param1Any.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Any any = Any.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Any any = (Any)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Any)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Any)
        return mergeFrom((Any)param1Message); 
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
    
    public Builder setTypeUrl(String param1String) {
      if (param1String != null) {
        this.typeUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.typeUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setValue(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.value_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Any.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SourceContext extends GeneratedMessageV3 implements SourceContextOrBuilder {
  private static final SourceContext DEFAULT_INSTANCE = new SourceContext();
  
  public static final int FILE_NAME_FIELD_NUMBER = 1;
  
  private static final Parser<SourceContext> PARSER = new AbstractParser<SourceContext>() {
      public SourceContext parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new SourceContext(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object fileName_;
  
  private byte memoizedIsInitialized = -1;
  
  private SourceContext() {
    this.fileName_ = "";
  }
  
  private SourceContext(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                continue; 
              continue;
            } 
            this.fileName_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private SourceContext(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static SourceContext getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SourceContext paramSourceContext) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSourceContext);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<SourceContext>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<SourceContext>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<SourceContext>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<SourceContext>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<SourceContext>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<SourceContext>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static SourceContext parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceContext> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SourceContext))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getFileName().equals(paramObject.getFileName()) ? false : (!!this.unknownFields.equals(((SourceContext)paramObject).unknownFields));
  }
  
  public SourceContext getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getFileName() {
    Object object = this.fileName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.fileName_ = object;
    return (String)object;
  }
  
  public ByteString getFileNameBytes() {
    Object object = this.fileName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.fileName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<SourceContext> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getFileNameBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.fileName_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getFileName().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)SourceContext.class, (Class)Builder.class);
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
    return new SourceContext();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!getFileNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.fileName_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SourceContextOrBuilder {
    private Object fileName_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SourceContext build() {
      SourceContext sourceContext = buildPartial();
      if (sourceContext.isInitialized())
        return sourceContext; 
      throw newUninitializedMessageException(sourceContext);
    }
    
    public SourceContext buildPartial() {
      SourceContext sourceContext = new SourceContext(this);
      SourceContext.access$302(sourceContext, this.fileName_);
      onBuilt();
      return sourceContext;
    }
    
    public Builder clear() {
      super.clear();
      this.fileName_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFileName() {
      this.fileName_ = SourceContext.getDefaultInstance().getFileName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return super.clone();
    }
    
    public SourceContext getDefaultInstanceForType() {
      return SourceContext.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }
    
    public String getFileName() {
      Object object = this.fileName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.fileName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFileNameBytes() {
      Object object = this.fileName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.fileName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)SourceContext.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SourceContext sourceContext = SourceContext.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SourceContext sourceContext = (SourceContext)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SourceContext)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SourceContext)
        return mergeFrom((SourceContext)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(SourceContext param1SourceContext) {
      if (param1SourceContext == SourceContext.getDefaultInstance())
        return this; 
      if (!param1SourceContext.getFileName().isEmpty()) {
        this.fileName_ = param1SourceContext.fileName_;
        onChanged();
      } 
      mergeUnknownFields(param1SourceContext.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFileName(String param1String) {
      if (param1String != null) {
        this.fileName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFileNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.fileName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\SourceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
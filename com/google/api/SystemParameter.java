package com.google.api;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SystemParameter extends GeneratedMessageV3 implements SystemParameterOrBuilder {
  private static final SystemParameter DEFAULT_INSTANCE = new SystemParameter();
  
  public static final int HTTP_HEADER_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<SystemParameter> PARSER = (Parser<SystemParameter>)new AbstractParser<SystemParameter>() {
      public SystemParameter a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new SystemParameter(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int URL_QUERY_PARAMETER_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object httpHeader_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private volatile Object urlQueryParameter_;
  
  private SystemParameter() {
    this.name_ = "";
    this.httpHeader_ = "";
    this.urlQueryParameter_ = "";
  }
  
  private SystemParameter(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 26) {
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.urlQueryParameter_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.httpHeader_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.name_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private SystemParameter(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static SystemParameter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return SystemParameterProto.e;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SystemParameter paramSystemParameter) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSystemParameter);
  }
  
  public static SystemParameter parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameter)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static SystemParameter parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameter)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameter parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (SystemParameter)PARSER.parseFrom(paramByteString);
  }
  
  public static SystemParameter parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameter)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static SystemParameter parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (SystemParameter)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static SystemParameter parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameter)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameter parseFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameter)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static SystemParameter parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameter)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameter parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (SystemParameter)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static SystemParameter parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameter)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static SystemParameter parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (SystemParameter)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static SystemParameter parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameter)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SystemParameter> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SystemParameter))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getHttpHeader().equals(paramObject.getHttpHeader()) ? false : (!getUrlQueryParameter().equals(paramObject.getUrlQueryParameter()) ? false : (!!this.unknownFields.equals(((SystemParameter)paramObject).unknownFields))));
  }
  
  public SystemParameter getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getHttpHeader() {
    Object object = this.httpHeader_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.httpHeader_ = object;
    return (String)object;
  }
  
  public ByteString getHttpHeaderBytes() {
    Object object = this.httpHeader_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.httpHeader_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getName() {
    Object object = this.name_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.name_ = object;
    return (String)object;
  }
  
  public ByteString getNameBytes() {
    Object object = this.name_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.name_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<SystemParameter> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getNameBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
    i = j;
    if (!getHttpHeaderBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.httpHeader_); 
    j = i;
    if (!getUrlQueryParameterBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.urlQueryParameter_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public String getUrlQueryParameter() {
    Object object = this.urlQueryParameter_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.urlQueryParameter_ = object;
    return (String)object;
  }
  
  public ByteString getUrlQueryParameterBytes() {
    Object object = this.urlQueryParameter_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.urlQueryParameter_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getHttpHeader().hashCode()) * 37 + 3) * 53 + getUrlQueryParameter().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return SystemParameterProto.f.ensureFieldAccessorsInitialized(SystemParameter.class, Builder.class);
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
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    if (!getHttpHeaderBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.httpHeader_); 
    if (!getUrlQueryParameterBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.urlQueryParameter_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemParameterOrBuilder {
    private Object httpHeader_ = "";
    
    private Object name_ = "";
    
    private Object urlQueryParameter_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SystemParameterProto.e;
    }
    
    private void maybeForceBuilderInitialization() {
      SystemParameter.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SystemParameter build() {
      SystemParameter systemParameter = buildPartial();
      if (systemParameter.isInitialized())
        return systemParameter; 
      throw newUninitializedMessageException(systemParameter);
    }
    
    public SystemParameter buildPartial() {
      SystemParameter systemParameter = new SystemParameter(this);
      SystemParameter.access$402(systemParameter, this.name_);
      SystemParameter.access$502(systemParameter, this.httpHeader_);
      SystemParameter.access$602(systemParameter, this.urlQueryParameter_);
      onBuilt();
      return systemParameter;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.httpHeader_ = "";
      this.urlQueryParameter_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHttpHeader() {
      this.httpHeader_ = SystemParameter.getDefaultInstance().getHttpHeader();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = SystemParameter.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearUrlQueryParameter() {
      this.urlQueryParameter_ = SystemParameter.getDefaultInstance().getUrlQueryParameter();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public SystemParameter getDefaultInstanceForType() {
      return SystemParameter.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SystemParameterProto.e;
    }
    
    public String getHttpHeader() {
      Object object = this.httpHeader_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.httpHeader_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getHttpHeaderBytes() {
      Object object = this.httpHeader_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.httpHeader_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.name_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getUrlQueryParameter() {
      Object object = this.urlQueryParameter_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.urlQueryParameter_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUrlQueryParameterBytes() {
      Object object = this.urlQueryParameter_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.urlQueryParameter_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SystemParameterProto.f.ensureFieldAccessorsInitialized(SystemParameter.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SystemParameter param1SystemParameter) {
      if (param1SystemParameter == SystemParameter.getDefaultInstance())
        return this; 
      if (!param1SystemParameter.getName().isEmpty()) {
        this.name_ = param1SystemParameter.name_;
        onChanged();
      } 
      if (!param1SystemParameter.getHttpHeader().isEmpty()) {
        this.httpHeader_ = param1SystemParameter.httpHeader_;
        onChanged();
      } 
      if (!param1SystemParameter.getUrlQueryParameter().isEmpty()) {
        this.urlQueryParameter_ = param1SystemParameter.urlQueryParameter_;
        onChanged();
      } 
      mergeUnknownFields(param1SystemParameter.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SystemParameter systemParameter = (SystemParameter)SystemParameter.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SystemParameter systemParameter = (SystemParameter)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SystemParameter)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SystemParameter)
        return mergeFrom((SystemParameter)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHttpHeader(String param1String) {
      if (param1String != null) {
        this.httpHeader_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHttpHeaderBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SystemParameter.checkByteStringIsUtf8(param1ByteString);
        this.httpHeader_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SystemParameter.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUrlQueryParameter(String param1String) {
      if (param1String != null) {
        this.urlQueryParameter_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUrlQueryParameterBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SystemParameter.checkByteStringIsUtf8(param1ByteString);
        this.urlQueryParameter_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.longrunning;

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

public final class OperationInfo extends GeneratedMessageV3 implements OperationInfoOrBuilder {
  private static final OperationInfo DEFAULT_INSTANCE = new OperationInfo();
  
  public static final int METADATA_TYPE_FIELD_NUMBER = 2;
  
  private static final Parser<OperationInfo> PARSER = (Parser<OperationInfo>)new AbstractParser<OperationInfo>() {
      public OperationInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new OperationInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RESPONSE_TYPE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object metadataType_;
  
  private volatile Object responseType_;
  
  private OperationInfo() {
    this.responseType_ = "";
    this.metadataType_ = "";
  }
  
  private OperationInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.metadataType_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.responseType_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private OperationInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static OperationInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return OperationsProto.p;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(OperationInfo paramOperationInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramOperationInfo);
  }
  
  public static OperationInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (OperationInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static OperationInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (OperationInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OperationInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (OperationInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static OperationInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (OperationInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static OperationInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (OperationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static OperationInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (OperationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static OperationInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (OperationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static OperationInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (OperationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OperationInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (OperationInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static OperationInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (OperationInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static OperationInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (OperationInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static OperationInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (OperationInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<OperationInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof OperationInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getResponseType().equals(paramObject.getResponseType()) ? false : (!getMetadataType().equals(paramObject.getMetadataType()) ? false : (!!this.unknownFields.equals(((OperationInfo)paramObject).unknownFields)));
  }
  
  public OperationInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getMetadataType() {
    Object object = this.metadataType_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.metadataType_ = object;
    return (String)object;
  }
  
  public ByteString getMetadataTypeBytes() {
    Object object = this.metadataType_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.metadataType_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<OperationInfo> getParserForType() {
    return PARSER;
  }
  
  public String getResponseType() {
    Object object = this.responseType_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.responseType_ = object;
    return (String)object;
  }
  
  public ByteString getResponseTypeBytes() {
    Object object = this.responseType_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.responseType_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getResponseTypeBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.responseType_); 
    int j = i;
    if (!getMetadataTypeBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.metadataType_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getResponseType().hashCode()) * 37 + 2) * 53 + getMetadataType().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return OperationsProto.q.ensureFieldAccessorsInitialized(OperationInfo.class, Builder.class);
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
    if (!getResponseTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.responseType_); 
    if (!getMetadataTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.metadataType_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OperationInfoOrBuilder {
    private Object metadataType_ = "";
    
    private Object responseType_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return OperationsProto.p;
    }
    
    private void maybeForceBuilderInitialization() {
      OperationInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public OperationInfo build() {
      OperationInfo operationInfo = buildPartial();
      if (operationInfo.isInitialized())
        return operationInfo; 
      throw newUninitializedMessageException(operationInfo);
    }
    
    public OperationInfo buildPartial() {
      OperationInfo operationInfo = new OperationInfo(this);
      OperationInfo.access$402(operationInfo, this.responseType_);
      OperationInfo.access$502(operationInfo, this.metadataType_);
      onBuilt();
      return operationInfo;
    }
    
    public Builder clear() {
      super.clear();
      this.responseType_ = "";
      this.metadataType_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMetadataType() {
      this.metadataType_ = OperationInfo.getDefaultInstance().getMetadataType();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearResponseType() {
      this.responseType_ = OperationInfo.getDefaultInstance().getResponseType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public OperationInfo getDefaultInstanceForType() {
      return OperationInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return OperationsProto.p;
    }
    
    public String getMetadataType() {
      Object object = this.metadataType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.metadataType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMetadataTypeBytes() {
      Object object = this.metadataType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.metadataType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getResponseType() {
      Object object = this.responseType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.responseType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResponseTypeBytes() {
      Object object = this.responseType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.responseType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return OperationsProto.q.ensureFieldAccessorsInitialized(OperationInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(OperationInfo param1OperationInfo) {
      if (param1OperationInfo == OperationInfo.getDefaultInstance())
        return this; 
      if (!param1OperationInfo.getResponseType().isEmpty()) {
        this.responseType_ = param1OperationInfo.responseType_;
        onChanged();
      } 
      if (!param1OperationInfo.getMetadataType().isEmpty()) {
        this.metadataType_ = param1OperationInfo.metadataType_;
        onChanged();
      } 
      mergeUnknownFields(param1OperationInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        OperationInfo operationInfo = (OperationInfo)OperationInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        OperationInfo operationInfo = (OperationInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((OperationInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof OperationInfo)
        return mergeFrom((OperationInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMetadataType(String param1String) {
      if (param1String != null) {
        this.metadataType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMetadataTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        OperationInfo.checkByteStringIsUtf8(param1ByteString);
        this.metadataType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setResponseType(String param1String) {
      if (param1String != null) {
        this.responseType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponseTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        OperationInfo.checkByteStringIsUtf8(param1ByteString);
        this.responseType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\OperationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
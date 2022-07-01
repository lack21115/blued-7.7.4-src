package com.google.rpc;

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

public final class RequestInfo extends GeneratedMessageV3 implements RequestInfoOrBuilder {
  private static final RequestInfo DEFAULT_INSTANCE = new RequestInfo();
  
  private static final Parser<RequestInfo> PARSER = (Parser<RequestInfo>)new AbstractParser<RequestInfo>() {
      public RequestInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new RequestInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int REQUEST_ID_FIELD_NUMBER = 1;
  
  public static final int SERVING_DATA_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object requestId_;
  
  private volatile Object servingData_;
  
  private RequestInfo() {
    this.requestId_ = "";
    this.servingData_ = "";
  }
  
  private RequestInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.servingData_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.requestId_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private RequestInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static RequestInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.q;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RequestInfo paramRequestInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramRequestInfo);
  }
  
  public static RequestInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RequestInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static RequestInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RequestInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static RequestInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RequestInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static RequestInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (RequestInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static RequestInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (RequestInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static RequestInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RequestInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static RequestInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RequestInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof RequestInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRequestId().equals(paramObject.getRequestId()) ? false : (!getServingData().equals(paramObject.getServingData()) ? false : (!!this.unknownFields.equals(((RequestInfo)paramObject).unknownFields)));
  }
  
  public RequestInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<RequestInfo> getParserForType() {
    return PARSER;
  }
  
  public String getRequestId() {
    Object object = this.requestId_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.requestId_ = object;
    return (String)object;
  }
  
  public ByteString getRequestIdBytes() {
    Object object = this.requestId_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.requestId_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getRequestIdBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.requestId_); 
    int j = i;
    if (!getServingDataBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.servingData_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getServingData() {
    Object object = this.servingData_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.servingData_ = object;
    return (String)object;
  }
  
  public ByteString getServingDataBytes() {
    Object object = this.servingData_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.servingData_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getRequestId().hashCode()) * 37 + 2) * 53 + getServingData().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.r.ensureFieldAccessorsInitialized(RequestInfo.class, Builder.class);
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
    if (!getRequestIdBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.requestId_); 
    if (!getServingDataBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.servingData_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestInfoOrBuilder {
    private Object requestId_ = "";
    
    private Object servingData_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.q;
    }
    
    private void maybeForceBuilderInitialization() {
      RequestInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public RequestInfo build() {
      RequestInfo requestInfo = buildPartial();
      if (requestInfo.isInitialized())
        return requestInfo; 
      throw newUninitializedMessageException(requestInfo);
    }
    
    public RequestInfo buildPartial() {
      RequestInfo requestInfo = new RequestInfo(this);
      RequestInfo.access$402(requestInfo, this.requestId_);
      RequestInfo.access$502(requestInfo, this.servingData_);
      onBuilt();
      return requestInfo;
    }
    
    public Builder clear() {
      super.clear();
      this.requestId_ = "";
      this.servingData_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRequestId() {
      this.requestId_ = RequestInfo.getDefaultInstance().getRequestId();
      onChanged();
      return this;
    }
    
    public Builder clearServingData() {
      this.servingData_ = RequestInfo.getDefaultInstance().getServingData();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public RequestInfo getDefaultInstanceForType() {
      return RequestInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.q;
    }
    
    public String getRequestId() {
      Object object = this.requestId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.requestId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRequestIdBytes() {
      Object object = this.requestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getServingData() {
      Object object = this.servingData_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.servingData_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getServingDataBytes() {
      Object object = this.servingData_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.servingData_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.r.ensureFieldAccessorsInitialized(RequestInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        RequestInfo requestInfo = (RequestInfo)RequestInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        RequestInfo requestInfo = (RequestInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((RequestInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof RequestInfo)
        return mergeFrom((RequestInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(RequestInfo param1RequestInfo) {
      if (param1RequestInfo == RequestInfo.getDefaultInstance())
        return this; 
      if (!param1RequestInfo.getRequestId().isEmpty()) {
        this.requestId_ = param1RequestInfo.requestId_;
        onChanged();
      } 
      if (!param1RequestInfo.getServingData().isEmpty()) {
        this.servingData_ = param1RequestInfo.servingData_;
        onChanged();
      } 
      mergeUnknownFields(param1RequestInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequestId(String param1String) {
      if (param1String != null) {
        this.requestId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        RequestInfo.checkByteStringIsUtf8(param1ByteString);
        this.requestId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setServingData(String param1String) {
      if (param1String != null) {
        this.servingData_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setServingDataBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        RequestInfo.checkByteStringIsUtf8(param1ByteString);
        this.servingData_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\RequestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
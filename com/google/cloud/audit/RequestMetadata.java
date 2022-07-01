package com.google.cloud.audit;

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

public final class RequestMetadata extends GeneratedMessageV3 implements RequestMetadataOrBuilder {
  public static final int CALLER_IP_FIELD_NUMBER = 1;
  
  public static final int CALLER_SUPPLIED_USER_AGENT_FIELD_NUMBER = 2;
  
  private static final RequestMetadata DEFAULT_INSTANCE = new RequestMetadata();
  
  private static final Parser<RequestMetadata> PARSER = (Parser<RequestMetadata>)new AbstractParser<RequestMetadata>() {
      public RequestMetadata a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new RequestMetadata(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object callerIp_;
  
  private volatile Object callerSuppliedUserAgent_;
  
  private byte memoizedIsInitialized = -1;
  
  private RequestMetadata() {
    this.callerIp_ = "";
    this.callerSuppliedUserAgent_ = "";
  }
  
  private RequestMetadata(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.callerSuppliedUserAgent_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.callerIp_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private RequestMetadata(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static RequestMetadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuditLogProto.g;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RequestMetadata paramRequestMetadata) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramRequestMetadata);
  }
  
  public static RequestMetadata parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RequestMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static RequestMetadata parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestMetadata parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RequestMetadata)PARSER.parseFrom(paramByteString);
  }
  
  public static RequestMetadata parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestMetadata)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static RequestMetadata parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RequestMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static RequestMetadata parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestMetadata parseFrom(InputStream paramInputStream) throws IOException {
    return (RequestMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static RequestMetadata parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestMetadata parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (RequestMetadata)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static RequestMetadata parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestMetadata)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static RequestMetadata parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RequestMetadata)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static RequestMetadata parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestMetadata)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RequestMetadata> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof RequestMetadata))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getCallerIp().equals(paramObject.getCallerIp()) ? false : (!getCallerSuppliedUserAgent().equals(paramObject.getCallerSuppliedUserAgent()) ? false : (!!this.unknownFields.equals(((RequestMetadata)paramObject).unknownFields)));
  }
  
  public String getCallerIp() {
    Object object = this.callerIp_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.callerIp_ = object;
    return (String)object;
  }
  
  public ByteString getCallerIpBytes() {
    Object object = this.callerIp_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.callerIp_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getCallerSuppliedUserAgent() {
    Object object = this.callerSuppliedUserAgent_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.callerSuppliedUserAgent_ = object;
    return (String)object;
  }
  
  public ByteString getCallerSuppliedUserAgentBytes() {
    Object object = this.callerSuppliedUserAgent_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.callerSuppliedUserAgent_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public RequestMetadata getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<RequestMetadata> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getCallerIpBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.callerIp_); 
    int j = i;
    if (!getCallerSuppliedUserAgentBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.callerSuppliedUserAgent_); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getCallerIp().hashCode()) * 37 + 2) * 53 + getCallerSuppliedUserAgent().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuditLogProto.h.ensureFieldAccessorsInitialized(RequestMetadata.class, Builder.class);
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
    if (!getCallerIpBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.callerIp_); 
    if (!getCallerSuppliedUserAgentBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.callerSuppliedUserAgent_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestMetadataOrBuilder {
    private Object callerIp_ = "";
    
    private Object callerSuppliedUserAgent_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuditLogProto.g;
    }
    
    private void maybeForceBuilderInitialization() {
      RequestMetadata.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public RequestMetadata build() {
      RequestMetadata requestMetadata = buildPartial();
      if (requestMetadata.isInitialized())
        return requestMetadata; 
      throw newUninitializedMessageException(requestMetadata);
    }
    
    public RequestMetadata buildPartial() {
      RequestMetadata requestMetadata = new RequestMetadata(this);
      RequestMetadata.access$402(requestMetadata, this.callerIp_);
      RequestMetadata.access$502(requestMetadata, this.callerSuppliedUserAgent_);
      onBuilt();
      return requestMetadata;
    }
    
    public Builder clear() {
      super.clear();
      this.callerIp_ = "";
      this.callerSuppliedUserAgent_ = "";
      return this;
    }
    
    public Builder clearCallerIp() {
      this.callerIp_ = RequestMetadata.getDefaultInstance().getCallerIp();
      onChanged();
      return this;
    }
    
    public Builder clearCallerSuppliedUserAgent() {
      this.callerSuppliedUserAgent_ = RequestMetadata.getDefaultInstance().getCallerSuppliedUserAgent();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getCallerIp() {
      Object object = this.callerIp_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.callerIp_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCallerIpBytes() {
      Object object = this.callerIp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.callerIp_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getCallerSuppliedUserAgent() {
      Object object = this.callerSuppliedUserAgent_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.callerSuppliedUserAgent_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCallerSuppliedUserAgentBytes() {
      Object object = this.callerSuppliedUserAgent_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.callerSuppliedUserAgent_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public RequestMetadata getDefaultInstanceForType() {
      return RequestMetadata.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuditLogProto.g;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuditLogProto.h.ensureFieldAccessorsInitialized(RequestMetadata.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(RequestMetadata param1RequestMetadata) {
      if (param1RequestMetadata == RequestMetadata.getDefaultInstance())
        return this; 
      if (!param1RequestMetadata.getCallerIp().isEmpty()) {
        this.callerIp_ = param1RequestMetadata.callerIp_;
        onChanged();
      } 
      if (!param1RequestMetadata.getCallerSuppliedUserAgent().isEmpty()) {
        this.callerSuppliedUserAgent_ = param1RequestMetadata.callerSuppliedUserAgent_;
        onChanged();
      } 
      mergeUnknownFields(param1RequestMetadata.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        RequestMetadata requestMetadata = (RequestMetadata)RequestMetadata.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        RequestMetadata requestMetadata = (RequestMetadata)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((RequestMetadata)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof RequestMetadata)
        return mergeFrom((RequestMetadata)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCallerIp(String param1String) {
      if (param1String != null) {
        this.callerIp_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCallerIpBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        RequestMetadata.checkByteStringIsUtf8(param1ByteString);
        this.callerIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCallerSuppliedUserAgent(String param1String) {
      if (param1String != null) {
        this.callerSuppliedUserAgent_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCallerSuppliedUserAgentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        RequestMetadata.checkByteStringIsUtf8(param1ByteString);
        this.callerSuppliedUserAgent_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\RequestMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
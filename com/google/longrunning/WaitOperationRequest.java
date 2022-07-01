package com.google.longrunning;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class WaitOperationRequest extends GeneratedMessageV3 implements WaitOperationRequestOrBuilder {
  private static final WaitOperationRequest DEFAULT_INSTANCE = new WaitOperationRequest();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<WaitOperationRequest> PARSER = (Parser<WaitOperationRequest>)new AbstractParser<WaitOperationRequest>() {
      public WaitOperationRequest a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new WaitOperationRequest(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TIMEOUT_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private Duration timeout_;
  
  private WaitOperationRequest() {
    this.name_ = "";
  }
  
  private WaitOperationRequest(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              Duration.Builder builder1 = null;
              if (this.timeout_ != null)
                builder1 = this.timeout_.toBuilder(); 
              this.timeout_ = (Duration)paramCodedInputStream.readMessage(Duration.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom(this.timeout_);
                this.timeout_ = builder1.buildPartial();
              } 
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
  
  private WaitOperationRequest(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static WaitOperationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return OperationsProto.n;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(WaitOperationRequest paramWaitOperationRequest) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramWaitOperationRequest);
  }
  
  public static WaitOperationRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (WaitOperationRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static WaitOperationRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WaitOperationRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WaitOperationRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (WaitOperationRequest)PARSER.parseFrom(paramByteString);
  }
  
  public static WaitOperationRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WaitOperationRequest)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static WaitOperationRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (WaitOperationRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static WaitOperationRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WaitOperationRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static WaitOperationRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (WaitOperationRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static WaitOperationRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WaitOperationRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WaitOperationRequest parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (WaitOperationRequest)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static WaitOperationRequest parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WaitOperationRequest)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static WaitOperationRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (WaitOperationRequest)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static WaitOperationRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WaitOperationRequest)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<WaitOperationRequest> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof WaitOperationRequest))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : ((hasTimeout() != paramObject.hasTimeout()) ? false : ((hasTimeout() && !getTimeout().equals(paramObject.getTimeout())) ? false : (!!this.unknownFields.equals(((WaitOperationRequest)paramObject).unknownFields))));
  }
  
  public WaitOperationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
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
  
  public Parser<WaitOperationRequest> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getNameBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
    int j = i;
    if (this.timeout_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getTimeout()); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public Duration getTimeout() {
    Duration duration2 = this.timeout_;
    Duration duration1 = duration2;
    if (duration2 == null)
      duration1 = Duration.getDefaultInstance(); 
    return duration1;
  }
  
  public DurationOrBuilder getTimeoutOrBuilder() {
    return (DurationOrBuilder)getTimeout();
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasTimeout() {
    return (this.timeout_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (hasTimeout())
      i = (j * 37 + 2) * 53 + getTimeout().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return OperationsProto.o.ensureFieldAccessorsInitialized(WaitOperationRequest.class, Builder.class);
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
    if (this.timeout_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getTimeout()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WaitOperationRequestOrBuilder {
    private Object name_ = "";
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> timeoutBuilder_;
    
    private Duration timeout_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return OperationsProto.n;
    }
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getTimeoutFieldBuilder() {
      if (this.timeoutBuilder_ == null) {
        this.timeoutBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTimeout(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.timeout_ = null;
      } 
      return this.timeoutBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      WaitOperationRequest.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public WaitOperationRequest build() {
      WaitOperationRequest waitOperationRequest = buildPartial();
      if (waitOperationRequest.isInitialized())
        return waitOperationRequest; 
      throw newUninitializedMessageException(waitOperationRequest);
    }
    
    public WaitOperationRequest buildPartial() {
      WaitOperationRequest waitOperationRequest = new WaitOperationRequest(this);
      WaitOperationRequest.access$402(waitOperationRequest, this.name_);
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.timeoutBuilder_;
      if (singleFieldBuilderV3 == null) {
        WaitOperationRequest.access$502(waitOperationRequest, this.timeout_);
      } else {
        WaitOperationRequest.access$502(waitOperationRequest, (Duration)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return waitOperationRequest;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      if (this.timeoutBuilder_ == null) {
        this.timeout_ = null;
        return this;
      } 
      this.timeout_ = null;
      this.timeoutBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = WaitOperationRequest.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTimeout() {
      if (this.timeoutBuilder_ == null) {
        this.timeout_ = null;
        onChanged();
        return this;
      } 
      this.timeout_ = null;
      this.timeoutBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public WaitOperationRequest getDefaultInstanceForType() {
      return WaitOperationRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return OperationsProto.n;
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
    
    public Duration getTimeout() {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.timeoutBuilder_;
      if (singleFieldBuilderV3 == null) {
        Duration duration1 = this.timeout_;
        duration = duration1;
        if (duration1 == null)
          duration = Duration.getDefaultInstance(); 
        return duration;
      } 
      return (Duration)duration.getMessage();
    }
    
    public Duration.Builder getTimeoutBuilder() {
      onChanged();
      return (Duration.Builder)getTimeoutFieldBuilder().getBuilder();
    }
    
    public DurationOrBuilder getTimeoutOrBuilder() {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.timeoutBuilder_;
      if (singleFieldBuilderV3 != null)
        return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Duration duration2 = this.timeout_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return (DurationOrBuilder)duration1;
    }
    
    public boolean hasTimeout() {
      return (this.timeoutBuilder_ != null || this.timeout_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return OperationsProto.o.ensureFieldAccessorsInitialized(WaitOperationRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(WaitOperationRequest param1WaitOperationRequest) {
      if (param1WaitOperationRequest == WaitOperationRequest.getDefaultInstance())
        return this; 
      if (!param1WaitOperationRequest.getName().isEmpty()) {
        this.name_ = param1WaitOperationRequest.name_;
        onChanged();
      } 
      if (param1WaitOperationRequest.hasTimeout())
        mergeTimeout(param1WaitOperationRequest.getTimeout()); 
      mergeUnknownFields(param1WaitOperationRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        WaitOperationRequest waitOperationRequest = (WaitOperationRequest)WaitOperationRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        WaitOperationRequest waitOperationRequest = (WaitOperationRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((WaitOperationRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof WaitOperationRequest)
        return mergeFrom((WaitOperationRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeTimeout(Duration param1Duration) {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.timeoutBuilder_;
      if (singleFieldBuilderV3 == null) {
        duration = this.timeout_;
        if (duration != null) {
          this.timeout_ = Duration.newBuilder(duration).mergeFrom(param1Duration).buildPartial();
        } else {
          this.timeout_ = param1Duration;
        } 
        onChanged();
        return this;
      } 
      duration.mergeFrom((AbstractMessage)param1Duration);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
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
        WaitOperationRequest.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTimeout(Duration.Builder param1Builder) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.timeoutBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.timeout_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setTimeout(Duration param1Duration) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.timeoutBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Duration != null) {
          this.timeout_ = param1Duration;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Duration);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\WaitOperationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
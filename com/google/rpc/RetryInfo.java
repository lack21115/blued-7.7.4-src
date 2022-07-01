package com.google.rpc;

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

public final class RetryInfo extends GeneratedMessageV3 implements RetryInfoOrBuilder {
  private static final RetryInfo DEFAULT_INSTANCE = new RetryInfo();
  
  private static final Parser<RetryInfo> PARSER = (Parser<RetryInfo>)new AbstractParser<RetryInfo>() {
      public RetryInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new RetryInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RETRY_DELAY_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private Duration retryDelay_;
  
  private RetryInfo() {}
  
  private RetryInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            Duration.Builder builder1 = null;
            if (this.retryDelay_ != null)
              builder1 = this.retryDelay_.toBuilder(); 
            this.retryDelay_ = (Duration)paramCodedInputStream.readMessage(Duration.parser(), paramExtensionRegistryLite);
            if (builder1 != null) {
              builder1.mergeFrom(this.retryDelay_);
              this.retryDelay_ = builder1.buildPartial();
            } 
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
  
  private RetryInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static RetryInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RetryInfo paramRetryInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramRetryInfo);
  }
  
  public static RetryInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static RetryInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RetryInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static RetryInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static RetryInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static RetryInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (RetryInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static RetryInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RetryInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static RetryInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RetryInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof RetryInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (hasRetryDelay() != paramObject.hasRetryDelay()) ? false : ((hasRetryDelay() && !getRetryDelay().equals(paramObject.getRetryDelay())) ? false : (!!this.unknownFields.equals(((RetryInfo)paramObject).unknownFields)));
  }
  
  public RetryInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<RetryInfo> getParserForType() {
    return PARSER;
  }
  
  public Duration getRetryDelay() {
    Duration duration2 = this.retryDelay_;
    Duration duration1 = duration2;
    if (duration2 == null)
      duration1 = Duration.getDefaultInstance(); 
    return duration1;
  }
  
  public DurationOrBuilder getRetryDelayOrBuilder() {
    return (DurationOrBuilder)getRetryDelay();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.retryDelay_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getRetryDelay()); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasRetryDelay() {
    return (this.retryDelay_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasRetryDelay())
      i = (j * 37 + 1) * 53 + getRetryDelay().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.b.ensureFieldAccessorsInitialized(RetryInfo.class, Builder.class);
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
    if (this.retryDelay_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getRetryDelay()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RetryInfoOrBuilder {
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> retryDelayBuilder_;
    
    private Duration retryDelay_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.a;
    }
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getRetryDelayFieldBuilder() {
      if (this.retryDelayBuilder_ == null) {
        this.retryDelayBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getRetryDelay(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.retryDelay_ = null;
      } 
      return this.retryDelayBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      RetryInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public RetryInfo build() {
      RetryInfo retryInfo = buildPartial();
      if (retryInfo.isInitialized())
        return retryInfo; 
      throw newUninitializedMessageException(retryInfo);
    }
    
    public RetryInfo buildPartial() {
      RetryInfo retryInfo = new RetryInfo(this);
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.retryDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        RetryInfo.access$402(retryInfo, this.retryDelay_);
      } else {
        RetryInfo.access$402(retryInfo, (Duration)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return retryInfo;
    }
    
    public Builder clear() {
      super.clear();
      if (this.retryDelayBuilder_ == null) {
        this.retryDelay_ = null;
        return this;
      } 
      this.retryDelay_ = null;
      this.retryDelayBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRetryDelay() {
      if (this.retryDelayBuilder_ == null) {
        this.retryDelay_ = null;
        onChanged();
        return this;
      } 
      this.retryDelay_ = null;
      this.retryDelayBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public RetryInfo getDefaultInstanceForType() {
      return RetryInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.a;
    }
    
    public Duration getRetryDelay() {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.retryDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        Duration duration1 = this.retryDelay_;
        duration = duration1;
        if (duration1 == null)
          duration = Duration.getDefaultInstance(); 
        return duration;
      } 
      return (Duration)duration.getMessage();
    }
    
    public Duration.Builder getRetryDelayBuilder() {
      onChanged();
      return (Duration.Builder)getRetryDelayFieldBuilder().getBuilder();
    }
    
    public DurationOrBuilder getRetryDelayOrBuilder() {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.retryDelayBuilder_;
      if (singleFieldBuilderV3 != null)
        return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Duration duration2 = this.retryDelay_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return (DurationOrBuilder)duration1;
    }
    
    public boolean hasRetryDelay() {
      return (this.retryDelayBuilder_ != null || this.retryDelay_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.b.ensureFieldAccessorsInitialized(RetryInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        RetryInfo retryInfo = (RetryInfo)RetryInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        RetryInfo retryInfo = (RetryInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((RetryInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof RetryInfo)
        return mergeFrom((RetryInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(RetryInfo param1RetryInfo) {
      if (param1RetryInfo == RetryInfo.getDefaultInstance())
        return this; 
      if (param1RetryInfo.hasRetryDelay())
        mergeRetryDelay(param1RetryInfo.getRetryDelay()); 
      mergeUnknownFields(param1RetryInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeRetryDelay(Duration param1Duration) {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.retryDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        duration = this.retryDelay_;
        if (duration != null) {
          this.retryDelay_ = Duration.newBuilder(duration).mergeFrom(param1Duration).buildPartial();
        } else {
          this.retryDelay_ = param1Duration;
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
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRetryDelay(Duration.Builder param1Builder) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.retryDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.retryDelay_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRetryDelay(Duration param1Duration) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.retryDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Duration != null) {
          this.retryDelay_ = param1Duration;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\RetryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
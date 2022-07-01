package com.blued.das.client;

import com.blued.das.CommonProtos;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClientProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_Request_descriptor, new String[] { "Time", "Extra", "Common", "ClientTime", "Uid" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_Requests_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_Requests_descriptor, new String[] { "Common", "Request" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_Response_descriptor = getDescriptor().getMessageTypes().get(2);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_Response_descriptor, new String[] { "Code" });
  
  static {
    AnyProto.getDescriptor();
    CommonProtos.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor1 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = CommonProtos.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\022ClientProtos.proto\022\024com.blued.das.client\032\031google/protobuf/any.proto\032\022CommonProtos.proto\"\001\n\007Request\022\f\n\004time\030\001 \001(\003\022#\n\005extra\030\002 \001(\0132\024.google.protobuf.Any\022%\n\006common\030\003 \001(\0132\025.com.blued.das.Common\022\023\n\013client_time\030\004 \001(\003\022\013\n\003uid\030\005 \001(\003\"a\n\bRequests\022%\n\006common\030\001 \001(\0132\025.com.blued.das.Common\022.\n\007request\030\002 \003(\0132\035.com.blued.das.client.Request\"\030\n\bResponse\022\f\n\004code\030\001 \001(\0052`\n\rReportService\022O\n\013BatchReport\022\036.com.blued.das.client.Requests\032\036.com.blued.das.client.Response\"\000B\t¢\002\006CLIENTb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 });
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int CLIENT_TIME_FIELD_NUMBER = 4;
    
    public static final int COMMON_FIELD_NUMBER = 3;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int EXTRA_FIELD_NUMBER = 2;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public ClientProtos.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ClientProtos.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TIME_FIELD_NUMBER = 1;
    
    public static final int UID_FIELD_NUMBER = 5;
    
    private static final long serialVersionUID = 0L;
    
    private long clientTime_;
    
    private CommonProtos.Common common_;
    
    private Any extra_;
    
    private byte memoizedIsInitialized = -1;
    
    private long time_;
    
    private long uid_;
    
    private Request() {}
    
    private Request(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                Any.Builder builder1;
                CommonProtos.Common.Builder builder3 = null;
                CommonProtos.Common.Builder builder2 = null;
                if (i != 18) {
                  if (i != 26) {
                    if (i != 32) {
                      if (i != 40) {
                        if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                          continue; 
                        continue;
                      } 
                      this.uid_ = param1CodedInputStream.readInt64();
                      continue;
                    } 
                    this.clientTime_ = param1CodedInputStream.readInt64();
                    continue;
                  } 
                  if (this.common_ != null)
                    builder2 = this.common_.toBuilder(); 
                  this.common_ = (CommonProtos.Common)param1CodedInputStream.readMessage(CommonProtos.Common.parser(), param1ExtensionRegistryLite);
                  if (builder2 != null) {
                    builder2.mergeFrom(this.common_);
                    this.common_ = builder2.buildPartial();
                  } 
                  continue;
                } 
                builder2 = builder3;
                if (this.extra_ != null)
                  builder1 = this.extra_.toBuilder(); 
                this.extra_ = (Any)param1CodedInputStream.readMessage(Any.parser(), param1ExtensionRegistryLite);
                if (builder1 != null) {
                  builder1.mergeFrom(this.extra_);
                  this.extra_ = builder1.buildPartial();
                } 
                continue;
              } 
              this.time_ = param1CodedInputStream.readInt64();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Request(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Request getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ClientProtos.internal_static_com_blued_das_client_Request_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Request param1Request) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Request);
    }
    
    public static Request parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Request)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Request parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Request)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteString);
    }
    
    public static Request parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Request parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(InputStream param1InputStream) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Request parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Request parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Request parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Request> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Request))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getTime() != param1Object.getTime()) ? false : ((hasExtra() != param1Object.hasExtra()) ? false : ((hasExtra() && !getExtra().equals(param1Object.getExtra())) ? false : ((hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getClientTime() != param1Object.getClientTime()) ? false : ((getUid() != param1Object.getUid()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields))))))));
    }
    
    public long getClientTime() {
      return this.clientTime_;
    }
    
    public CommonProtos.Common getCommon() {
      CommonProtos.Common common2 = this.common_;
      CommonProtos.Common common1 = common2;
      if (common2 == null)
        common1 = CommonProtos.Common.getDefaultInstance(); 
      return common1;
    }
    
    public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
      return (CommonProtos.CommonOrBuilder)getCommon();
    }
    
    public Request getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Any getExtra() {
      Any any2 = this.extra_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return any1;
    }
    
    public AnyOrBuilder getExtraOrBuilder() {
      return (AnyOrBuilder)getExtra();
    }
    
    public Parser<Request> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      long l = this.time_;
      if (l != 0L)
        j = 0 + CodedOutputStream.computeInt64Size(1, l); 
      i = j;
      if (this.extra_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getExtra()); 
      j = i;
      if (this.common_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getCommon()); 
      l = this.clientTime_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(4, l); 
      l = this.uid_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(5, l); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public long getTime() {
      return this.time_;
    }
    
    public long getUid() {
      return this.uid_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasCommon() {
      return (this.common_ != null);
    }
    
    public boolean hasExtra() {
      return (this.extra_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getTime());
      int i = j;
      if (hasExtra())
        i = (j * 37 + 2) * 53 + getExtra().hashCode(); 
      j = i;
      if (hasCommon())
        j = (i * 37 + 3) * 53 + getCommon().hashCode(); 
      i = ((((j * 37 + 4) * 53 + Internal.hashLong(getClientTime())) * 37 + 5) * 53 + Internal.hashLong(getUid())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ClientProtos.internal_static_com_blued_das_client_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new Request();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.time_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(1, l); 
      if (this.extra_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getExtra()); 
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getCommon()); 
      l = this.clientTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      l = this.uid_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientProtos.RequestOrBuilder {
      private long clientTime_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
      
      private Any extra_;
      
      private long time_;
      
      private long uid_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
        if (this.commonBuilder_ == null) {
          this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.common_ = null;
        } 
        return this.commonBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ClientProtos.internal_static_com_blued_das_client_Request_descriptor;
      }
      
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
        if (this.extraBuilder_ == null) {
          this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.extra_ = null;
        } 
        return this.extraBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        ClientProtos.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ClientProtos.Request build() {
        ClientProtos.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public ClientProtos.Request buildPartial() {
        ClientProtos.Request request = new ClientProtos.Request(this);
        ClientProtos.Request.access$602(request, this.time_);
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV31 = this.extraBuilder_;
        if (singleFieldBuilderV31 == null) {
          ClientProtos.Request.access$702(request, this.extra_);
        } else {
          ClientProtos.Request.access$702(request, (Any)singleFieldBuilderV31.build());
        } 
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          ClientProtos.Request.access$802(request, this.common_);
        } else {
          ClientProtos.Request.access$802(request, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        ClientProtos.Request.access$902(request, this.clientTime_);
        ClientProtos.Request.access$1002(request, this.uid_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        this.time_ = 0L;
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
        } else {
          this.extra_ = null;
          this.extraBuilder_ = null;
        } 
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        this.clientTime_ = 0L;
        this.uid_ = 0L;
        return this;
      }
      
      public Builder clearClientTime() {
        this.clientTime_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearCommon() {
        if (this.commonBuilder_ == null) {
          this.common_ = null;
          onChanged();
          return this;
        } 
        this.common_ = null;
        this.commonBuilder_ = null;
        return this;
      }
      
      public Builder clearExtra() {
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
          onChanged();
          return this;
        } 
        this.extra_ = null;
        this.extraBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearTime() {
        this.time_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearUid() {
        this.uid_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public long getClientTime() {
        return this.clientTime_;
      }
      
      public CommonProtos.Common getCommon() {
        CommonProtos.Common common;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          CommonProtos.Common common1 = this.common_;
          common = common1;
          if (common1 == null)
            common = CommonProtos.Common.getDefaultInstance(); 
          return common;
        } 
        return (CommonProtos.Common)common.getMessage();
      }
      
      public CommonProtos.Common.Builder getCommonBuilder() {
        onChanged();
        return (CommonProtos.Common.Builder)getCommonFieldBuilder().getBuilder();
      }
      
      public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 != null)
          return (CommonProtos.CommonOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        CommonProtos.Common common2 = this.common_;
        CommonProtos.Common common1 = common2;
        if (common2 == null)
          common1 = CommonProtos.Common.getDefaultInstance(); 
        return (CommonProtos.CommonOrBuilder)common1;
      }
      
      public ClientProtos.Request getDefaultInstanceForType() {
        return ClientProtos.Request.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ClientProtos.internal_static_com_blued_das_client_Request_descriptor;
      }
      
      public Any getExtra() {
        Any any;
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          Any any1 = this.extra_;
          any = any1;
          if (any1 == null)
            any = Any.getDefaultInstance(); 
          return any;
        } 
        return (Any)any.getMessage();
      }
      
      public Any.Builder getExtraBuilder() {
        onChanged();
        return (Any.Builder)getExtraFieldBuilder().getBuilder();
      }
      
      public AnyOrBuilder getExtraOrBuilder() {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        Any any2 = this.extra_;
        Any any1 = any2;
        if (any2 == null)
          any1 = Any.getDefaultInstance(); 
        return (AnyOrBuilder)any1;
      }
      
      public long getTime() {
        return this.time_;
      }
      
      public long getUid() {
        return this.uid_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public boolean hasExtra() {
        return (this.extraBuilder_ != null || this.extra_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ClientProtos.internal_static_com_blued_das_client_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientProtos.Request.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeCommon(CommonProtos.Common param2Common) {
        CommonProtos.Common common;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          common = this.common_;
          if (common != null) {
            this.common_ = CommonProtos.Common.newBuilder(common).mergeFrom(param2Common).buildPartial();
          } else {
            this.common_ = param2Common;
          } 
          onChanged();
          return this;
        } 
        common.mergeFrom((AbstractMessage)param2Common);
        return this;
      }
      
      public Builder mergeExtra(Any param2Any) {
        Any any;
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          any = this.extra_;
          if (any != null) {
            this.extra_ = Any.newBuilder(any).mergeFrom(param2Any).buildPartial();
          } else {
            this.extra_ = param2Any;
          } 
          onChanged();
          return this;
        } 
        any.mergeFrom((AbstractMessage)param2Any);
        return this;
      }
      
      public Builder mergeFrom(ClientProtos.Request param2Request) {
        if (param2Request == ClientProtos.Request.getDefaultInstance())
          return this; 
        if (param2Request.getTime() != 0L)
          setTime(param2Request.getTime()); 
        if (param2Request.hasExtra())
          mergeExtra(param2Request.getExtra()); 
        if (param2Request.hasCommon())
          mergeCommon(param2Request.getCommon()); 
        if (param2Request.getClientTime() != 0L)
          setClientTime(param2Request.getClientTime()); 
        if (param2Request.getUid() != 0L)
          setUid(param2Request.getUid()); 
        mergeUnknownFields(param2Request.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ClientProtos.Request request = (ClientProtos.Request)ClientProtos.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ClientProtos.Request request = (ClientProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ClientProtos.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ClientProtos.Request)
          return mergeFrom((ClientProtos.Request)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setClientTime(long param2Long) {
        this.clientTime_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setCommon(CommonProtos.Common.Builder param2Builder) {
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.common_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setCommon(CommonProtos.Common param2Common) {
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Common != null) {
            this.common_ = param2Common;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Common);
        return this;
      }
      
      public Builder setExtra(Any.Builder param2Builder) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.extra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setExtra(Any param2Any) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Any != null) {
            this.extra_ = param2Any;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Any);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTime(long param2Long) {
        this.time_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setUid(long param2Long) {
        this.uid_ = param2Long;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Request> {
    public ClientProtos.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ClientProtos.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private long clientTime_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
    
    private Any extra_;
    
    private long time_;
    
    private long uid_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
      if (this.commonBuilder_ == null) {
        this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.common_ = null;
      } 
      return this.commonBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ClientProtos.internal_static_com_blued_das_client_Request_descriptor;
    }
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
      if (this.extraBuilder_ == null) {
        this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.extra_ = null;
      } 
      return this.extraBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      ClientProtos.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ClientProtos.Request build() {
      ClientProtos.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public ClientProtos.Request buildPartial() {
      ClientProtos.Request request = new ClientProtos.Request(this);
      ClientProtos.Request.access$602(request, this.time_);
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV31 = this.extraBuilder_;
      if (singleFieldBuilderV31 == null) {
        ClientProtos.Request.access$702(request, this.extra_);
      } else {
        ClientProtos.Request.access$702(request, (Any)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        ClientProtos.Request.access$802(request, this.common_);
      } else {
        ClientProtos.Request.access$802(request, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      ClientProtos.Request.access$902(request, this.clientTime_);
      ClientProtos.Request.access$1002(request, this.uid_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      this.time_ = 0L;
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
      } else {
        this.extra_ = null;
        this.extraBuilder_ = null;
      } 
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      this.clientTime_ = 0L;
      this.uid_ = 0L;
      return this;
    }
    
    public Builder clearClientTime() {
      this.clientTime_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearCommon() {
      if (this.commonBuilder_ == null) {
        this.common_ = null;
        onChanged();
        return this;
      } 
      this.common_ = null;
      this.commonBuilder_ = null;
      return this;
    }
    
    public Builder clearExtra() {
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
        onChanged();
        return this;
      } 
      this.extra_ = null;
      this.extraBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTime() {
      this.time_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearUid() {
      this.uid_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public long getClientTime() {
      return this.clientTime_;
    }
    
    public CommonProtos.Common getCommon() {
      CommonProtos.Common common;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        CommonProtos.Common common1 = this.common_;
        common = common1;
        if (common1 == null)
          common = CommonProtos.Common.getDefaultInstance(); 
        return common;
      } 
      return (CommonProtos.Common)common.getMessage();
    }
    
    public CommonProtos.Common.Builder getCommonBuilder() {
      onChanged();
      return (CommonProtos.Common.Builder)getCommonFieldBuilder().getBuilder();
    }
    
    public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 != null)
        return (CommonProtos.CommonOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      CommonProtos.Common common2 = this.common_;
      CommonProtos.Common common1 = common2;
      if (common2 == null)
        common1 = CommonProtos.Common.getDefaultInstance(); 
      return (CommonProtos.CommonOrBuilder)common1;
    }
    
    public ClientProtos.Request getDefaultInstanceForType() {
      return ClientProtos.Request.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ClientProtos.internal_static_com_blued_das_client_Request_descriptor;
    }
    
    public Any getExtra() {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        Any any1 = this.extra_;
        any = any1;
        if (any1 == null)
          any = Any.getDefaultInstance(); 
        return any;
      } 
      return (Any)any.getMessage();
    }
    
    public Any.Builder getExtraBuilder() {
      onChanged();
      return (Any.Builder)getExtraFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getExtraOrBuilder() {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Any any2 = this.extra_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return (AnyOrBuilder)any1;
    }
    
    public long getTime() {
      return this.time_;
    }
    
    public long getUid() {
      return this.uid_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public boolean hasExtra() {
      return (this.extraBuilder_ != null || this.extra_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ClientProtos.internal_static_com_blued_das_client_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientProtos.Request.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeCommon(CommonProtos.Common param1Common) {
      CommonProtos.Common common;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        common = this.common_;
        if (common != null) {
          this.common_ = CommonProtos.Common.newBuilder(common).mergeFrom(param1Common).buildPartial();
        } else {
          this.common_ = param1Common;
        } 
        onChanged();
        return this;
      } 
      common.mergeFrom((AbstractMessage)param1Common);
      return this;
    }
    
    public Builder mergeExtra(Any param1Any) {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        any = this.extra_;
        if (any != null) {
          this.extra_ = Any.newBuilder(any).mergeFrom(param1Any).buildPartial();
        } else {
          this.extra_ = param1Any;
        } 
        onChanged();
        return this;
      } 
      any.mergeFrom((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder mergeFrom(ClientProtos.Request param1Request) {
      if (param1Request == ClientProtos.Request.getDefaultInstance())
        return this; 
      if (param1Request.getTime() != 0L)
        setTime(param1Request.getTime()); 
      if (param1Request.hasExtra())
        mergeExtra(param1Request.getExtra()); 
      if (param1Request.hasCommon())
        mergeCommon(param1Request.getCommon()); 
      if (param1Request.getClientTime() != 0L)
        setClientTime(param1Request.getClientTime()); 
      if (param1Request.getUid() != 0L)
        setUid(param1Request.getUid()); 
      mergeUnknownFields(param1Request.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ClientProtos.Request request = (ClientProtos.Request)ClientProtos.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ClientProtos.Request request = (ClientProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ClientProtos.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ClientProtos.Request)
        return mergeFrom((ClientProtos.Request)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setClientTime(long param1Long) {
      this.clientTime_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setCommon(CommonProtos.Common.Builder param1Builder) {
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.common_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setCommon(CommonProtos.Common param1Common) {
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Common != null) {
          this.common_ = param1Common;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Common);
      return this;
    }
    
    public Builder setExtra(Any.Builder param1Builder) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.extra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExtra(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Any != null) {
          this.extra_ = param1Any;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTime(long param1Long) {
      this.time_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setUid(long param1Long) {
      this.uid_ = param1Long;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface RequestOrBuilder extends MessageOrBuilder {
    long getClientTime();
    
    CommonProtos.Common getCommon();
    
    CommonProtos.CommonOrBuilder getCommonOrBuilder();
    
    Any getExtra();
    
    AnyOrBuilder getExtraOrBuilder();
    
    long getTime();
    
    long getUid();
    
    boolean hasCommon();
    
    boolean hasExtra();
  }
  
  public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final Requests DEFAULT_INSTANCE = new Requests();
    
    private static final Parser<Requests> PARSER = (Parser<Requests>)new AbstractParser<Requests>() {
        public ClientProtos.Requests parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ClientProtos.Requests(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private CommonProtos.Common common_;
    
    private byte memoizedIsInitialized = -1;
    
    private List<ClientProtos.Request> request_;
    
    private Requests() {
      this.request_ = Collections.emptyList();
    }
    
    private Requests(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        int i = 0;
        while (!bool) {
          int j = i;
          int k = i;
          int m = i;
          try {
            int n = param1CodedInputStream.readTag();
            if (n != 0) {
              if (n != 10) {
                if (n != 18) {
                  j = i;
                  k = i;
                  m = i;
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, n))
                    continue; 
                  continue;
                } 
                n = i;
                if ((i & 0x1) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.request_ = new ArrayList<ClientProtos.Request>();
                  n = i | 0x1;
                } 
                j = n;
                k = n;
                m = n;
                this.request_.add(param1CodedInputStream.readMessage(ClientProtos.Request.parser(), param1ExtensionRegistryLite));
                i = n;
                continue;
              } 
              CommonProtos.Common.Builder builder1 = null;
              j = i;
              k = i;
              m = i;
              if (this.common_ != null) {
                j = i;
                k = i;
                m = i;
                builder1 = this.common_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.common_ = (CommonProtos.Common)param1CodedInputStream.readMessage(CommonProtos.Common.parser(), param1ExtensionRegistryLite);
              if (builder1 != null) {
                j = i;
                k = i;
                m = i;
                builder1.mergeFrom(this.common_);
                j = i;
                k = i;
                m = i;
                this.common_ = builder1.buildPartial();
              } 
              continue;
            } 
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            j = m;
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            j = k;
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          if ((j & 0x1) != 0)
            this.request_ = Collections.unmodifiableList(this.request_); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x1) != 0)
          this.request_ = Collections.unmodifiableList(this.request_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Requests(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Requests getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ClientProtos.internal_static_com_blued_das_client_Requests_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Requests param1Requests) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Requests);
    }
    
    public static Requests parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Requests)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Requests parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Requests)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Requests parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Requests)PARSER.parseFrom(param1ByteString);
    }
    
    public static Requests parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Requests)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Requests parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Requests)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Requests parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Requests)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Requests parseFrom(InputStream param1InputStream) throws IOException {
      return (Requests)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Requests parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Requests)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Requests parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Requests)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Requests parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Requests)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Requests parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Requests)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Requests parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Requests)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Requests> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Requests))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : (!getRequestList().equals(param1Object.getRequestList()) ? false : (!!this.unknownFields.equals(((Requests)param1Object).unknownFields))));
    }
    
    public CommonProtos.Common getCommon() {
      CommonProtos.Common common2 = this.common_;
      CommonProtos.Common common1 = common2;
      if (common2 == null)
        common1 = CommonProtos.Common.getDefaultInstance(); 
      return common1;
    }
    
    public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
      return (CommonProtos.CommonOrBuilder)getCommon();
    }
    
    public Requests getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<Requests> getParserForType() {
      return PARSER;
    }
    
    public ClientProtos.Request getRequest(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public int getRequestCount() {
      return this.request_.size();
    }
    
    public List<ClientProtos.Request> getRequestList() {
      return this.request_;
    }
    
    public ClientProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public List<? extends ClientProtos.RequestOrBuilder> getRequestOrBuilderList() {
      return (List)this.request_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      CommonProtos.Common common = this.common_;
      int j = 0;
      if (common != null) {
        i = CodedOutputStream.computeMessageSize(1, (MessageLite)getCommon()) + 0;
      } else {
        i = 0;
      } 
      while (j < this.request_.size()) {
        i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.request_.get(j));
        j++;
      } 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasCommon() {
      return (this.common_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasCommon())
        i = (j * 37 + 1) * 53 + getCommon().hashCode(); 
      j = i;
      if (getRequestCount() > 0)
        j = (i * 37 + 2) * 53 + getRequestList().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ClientProtos.internal_static_com_blued_das_client_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new Requests();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getCommon()); 
      for (int i = 0; i < this.request_.size(); i++)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.request_.get(i)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientProtos.RequestsOrBuilder {
      private int bitField0_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> requestBuilder_;
      
      private List<ClientProtos.Request> request_ = Collections.emptyList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureRequestIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.request_ = new ArrayList<ClientProtos.Request>(this.request_);
          this.bitField0_ |= 0x1;
        } 
      }
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
        if (this.commonBuilder_ == null) {
          this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.common_ = null;
        } 
        return this.commonBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ClientProtos.internal_static_com_blued_das_client_Requests_descriptor;
      }
      
      private RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> getRequestFieldBuilder() {
        if (this.requestBuilder_ == null) {
          List<ClientProtos.Request> list = this.request_;
          int i = this.bitField0_;
          boolean bool = true;
          if ((i & 0x1) == 0)
            bool = false; 
          this.requestBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.request_ = null;
        } 
        return this.requestBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        if (ClientProtos.Requests.alwaysUseFieldBuilders)
          getRequestFieldBuilder(); 
      }
      
      public Builder addAllRequest(Iterable<? extends ClientProtos.Request> param2Iterable) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          AbstractMessageLite.Builder.addAll(param2Iterable, this.request_);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addAllMessages(param2Iterable);
        return this;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Builder addRequest(int param2Int, ClientProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(int param2Int, ClientProtos.Request param2Request) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2Request != null) {
            ensureRequestIsMutable();
            this.request_.add(param2Int, param2Request);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Request);
        return this;
      }
      
      public Builder addRequest(ClientProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(ClientProtos.Request param2Request) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2Request != null) {
            ensureRequestIsMutable();
            this.request_.add(param2Request);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Request);
        return this;
      }
      
      public ClientProtos.Request.Builder addRequestBuilder() {
        return (ClientProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)ClientProtos.Request.getDefaultInstance());
      }
      
      public ClientProtos.Request.Builder addRequestBuilder(int param2Int) {
        return (ClientProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param2Int, (AbstractMessage)ClientProtos.Request.getDefaultInstance());
      }
      
      public ClientProtos.Requests build() {
        ClientProtos.Requests requests = buildPartial();
        if (requests.isInitialized())
          return requests; 
        throw newUninitializedMessageException(requests);
      }
      
      public ClientProtos.Requests buildPartial() {
        ClientProtos.Requests requests = new ClientProtos.Requests(this);
        int i = this.bitField0_;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          ClientProtos.Requests.access$2002(requests, this.common_);
        } else {
          ClientProtos.Requests.access$2002(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x1) != 0) {
            this.request_ = Collections.unmodifiableList(this.request_);
            this.bitField0_ &= 0xFFFFFFFE;
          } 
          ClientProtos.Requests.access$2102(requests, this.request_);
        } else {
          ClientProtos.Requests.access$2102(requests, repeatedFieldBuilderV3.build());
        } 
        onBuilt();
        return requests;
      }
      
      public Builder clear() {
        super.clear();
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.request_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFE;
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clearCommon() {
        if (this.commonBuilder_ == null) {
          this.common_ = null;
          onChanged();
          return this;
        } 
        this.common_ = null;
        this.commonBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearRequest() {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.request_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFE;
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public CommonProtos.Common getCommon() {
        CommonProtos.Common common;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          CommonProtos.Common common1 = this.common_;
          common = common1;
          if (common1 == null)
            common = CommonProtos.Common.getDefaultInstance(); 
          return common;
        } 
        return (CommonProtos.Common)common.getMessage();
      }
      
      public CommonProtos.Common.Builder getCommonBuilder() {
        onChanged();
        return (CommonProtos.Common.Builder)getCommonFieldBuilder().getBuilder();
      }
      
      public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 != null)
          return (CommonProtos.CommonOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        CommonProtos.Common common2 = this.common_;
        CommonProtos.Common common1 = common2;
        if (common2 == null)
          common1 = CommonProtos.Common.getDefaultInstance(); 
        return (CommonProtos.CommonOrBuilder)common1;
      }
      
      public ClientProtos.Requests getDefaultInstanceForType() {
        return ClientProtos.Requests.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ClientProtos.internal_static_com_blued_das_client_Requests_descriptor;
      }
      
      public ClientProtos.Request getRequest(int param2Int) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (ClientProtos.Request)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public ClientProtos.Request.Builder getRequestBuilder(int param2Int) {
        return (ClientProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param2Int);
      }
      
      public List<ClientProtos.Request.Builder> getRequestBuilderList() {
        return getRequestFieldBuilder().getBuilderList();
      }
      
      public int getRequestCount() {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<ClientProtos.Request> getRequestList() {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public ClientProtos.RequestOrBuilder getRequestOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (ClientProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends ClientProtos.RequestOrBuilder> getRequestOrBuilderList() {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ClientProtos.internal_static_com_blued_das_client_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientProtos.Requests.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeCommon(CommonProtos.Common param2Common) {
        CommonProtos.Common common;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          common = this.common_;
          if (common != null) {
            this.common_ = CommonProtos.Common.newBuilder(common).mergeFrom(param2Common).buildPartial();
          } else {
            this.common_ = param2Common;
          } 
          onChanged();
          return this;
        } 
        common.mergeFrom((AbstractMessage)param2Common);
        return this;
      }
      
      public Builder mergeFrom(ClientProtos.Requests param2Requests) {
        if (param2Requests == ClientProtos.Requests.getDefaultInstance())
          return this; 
        if (param2Requests.hasCommon())
          mergeCommon(param2Requests.getCommon()); 
        if (this.requestBuilder_ == null) {
          if (!param2Requests.request_.isEmpty()) {
            if (this.request_.isEmpty()) {
              this.request_ = param2Requests.request_;
              this.bitField0_ &= 0xFFFFFFFE;
            } else {
              ensureRequestIsMutable();
              this.request_.addAll(param2Requests.request_);
            } 
            onChanged();
          } 
        } else if (!param2Requests.request_.isEmpty()) {
          if (this.requestBuilder_.isEmpty()) {
            this.requestBuilder_.dispose();
            RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
            this.requestBuilder_ = null;
            this.request_ = param2Requests.request_;
            this.bitField0_ &= 0xFFFFFFFE;
            if (ClientProtos.Requests.alwaysUseFieldBuilders)
              repeatedFieldBuilderV3 = getRequestFieldBuilder(); 
            this.requestBuilder_ = repeatedFieldBuilderV3;
          } else {
            this.requestBuilder_.addAllMessages(param2Requests.request_);
          } 
        } 
        mergeUnknownFields(param2Requests.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ClientProtos.Requests requests = (ClientProtos.Requests)ClientProtos.Requests.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ClientProtos.Requests requests = (ClientProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ClientProtos.Requests)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ClientProtos.Requests)
          return mergeFrom((ClientProtos.Requests)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeRequest(int param2Int) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.remove(param2Int);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.remove(param2Int);
        return this;
      }
      
      public Builder setCommon(CommonProtos.Common.Builder param2Builder) {
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.common_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setCommon(CommonProtos.Common param2Common) {
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Common != null) {
            this.common_ = param2Common;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Common);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setRequest(int param2Int, ClientProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setRequest(int param2Int, ClientProtos.Request param2Request) {
        RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2Request != null) {
            ensureRequestIsMutable();
            this.request_.set(param2Int, param2Request);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Request);
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Requests> {
    public ClientProtos.Requests parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ClientProtos.Requests(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Requests.Builder> implements RequestsOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> requestBuilder_;
    
    private List<ClientProtos.Request> request_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRequestIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.request_ = new ArrayList<ClientProtos.Request>(this.request_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
      if (this.commonBuilder_ == null) {
        this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.common_ = null;
      } 
      return this.commonBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ClientProtos.internal_static_com_blued_das_client_Requests_descriptor;
    }
    
    private RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> getRequestFieldBuilder() {
      if (this.requestBuilder_ == null) {
        List<ClientProtos.Request> list = this.request_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.requestBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.request_ = null;
      } 
      return this.requestBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (ClientProtos.Requests.alwaysUseFieldBuilders)
        getRequestFieldBuilder(); 
    }
    
    public Builder addAllRequest(Iterable<? extends ClientProtos.Request> param1Iterable) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.request_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRequest(int param1Int, ClientProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(int param1Int, ClientProtos.Request param1Request) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Request != null) {
          ensureRequestIsMutable();
          this.request_.add(param1Int, param1Request);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Request);
      return this;
    }
    
    public Builder addRequest(ClientProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(ClientProtos.Request param1Request) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Request != null) {
          ensureRequestIsMutable();
          this.request_.add(param1Request);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Request);
      return this;
    }
    
    public ClientProtos.Request.Builder addRequestBuilder() {
      return (ClientProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)ClientProtos.Request.getDefaultInstance());
    }
    
    public ClientProtos.Request.Builder addRequestBuilder(int param1Int) {
      return (ClientProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param1Int, (AbstractMessage)ClientProtos.Request.getDefaultInstance());
    }
    
    public ClientProtos.Requests build() {
      ClientProtos.Requests requests = buildPartial();
      if (requests.isInitialized())
        return requests; 
      throw newUninitializedMessageException(requests);
    }
    
    public ClientProtos.Requests buildPartial() {
      ClientProtos.Requests requests = new ClientProtos.Requests(this);
      int i = this.bitField0_;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        ClientProtos.Requests.access$2002(requests, this.common_);
      } else {
        ClientProtos.Requests.access$2002(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.request_ = Collections.unmodifiableList(this.request_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        ClientProtos.Requests.access$2102(requests, this.request_);
      } else {
        ClientProtos.Requests.access$2102(requests, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return requests;
    }
    
    public Builder clear() {
      super.clear();
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.request_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearCommon() {
      if (this.commonBuilder_ == null) {
        this.common_ = null;
        onChanged();
        return this;
      } 
      this.common_ = null;
      this.commonBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRequest() {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.request_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public CommonProtos.Common getCommon() {
      CommonProtos.Common common;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        CommonProtos.Common common1 = this.common_;
        common = common1;
        if (common1 == null)
          common = CommonProtos.Common.getDefaultInstance(); 
        return common;
      } 
      return (CommonProtos.Common)common.getMessage();
    }
    
    public CommonProtos.Common.Builder getCommonBuilder() {
      onChanged();
      return (CommonProtos.Common.Builder)getCommonFieldBuilder().getBuilder();
    }
    
    public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 != null)
        return (CommonProtos.CommonOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      CommonProtos.Common common2 = this.common_;
      CommonProtos.Common common1 = common2;
      if (common2 == null)
        common1 = CommonProtos.Common.getDefaultInstance(); 
      return (CommonProtos.CommonOrBuilder)common1;
    }
    
    public ClientProtos.Requests getDefaultInstanceForType() {
      return ClientProtos.Requests.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ClientProtos.internal_static_com_blued_das_client_Requests_descriptor;
    }
    
    public ClientProtos.Request getRequest(int param1Int) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (ClientProtos.Request)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public ClientProtos.Request.Builder getRequestBuilder(int param1Int) {
      return (ClientProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param1Int);
    }
    
    public List<ClientProtos.Request.Builder> getRequestBuilderList() {
      return getRequestFieldBuilder().getBuilderList();
    }
    
    public int getRequestCount() {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<ClientProtos.Request> getRequestList() {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public ClientProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (ClientProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends ClientProtos.RequestOrBuilder> getRequestOrBuilderList() {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ClientProtos.internal_static_com_blued_das_client_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientProtos.Requests.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeCommon(CommonProtos.Common param1Common) {
      CommonProtos.Common common;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        common = this.common_;
        if (common != null) {
          this.common_ = CommonProtos.Common.newBuilder(common).mergeFrom(param1Common).buildPartial();
        } else {
          this.common_ = param1Common;
        } 
        onChanged();
        return this;
      } 
      common.mergeFrom((AbstractMessage)param1Common);
      return this;
    }
    
    public Builder mergeFrom(ClientProtos.Requests param1Requests) {
      if (param1Requests == ClientProtos.Requests.getDefaultInstance())
        return this; 
      if (param1Requests.hasCommon())
        mergeCommon(param1Requests.getCommon()); 
      if (this.requestBuilder_ == null) {
        if (!param1Requests.request_.isEmpty()) {
          if (this.request_.isEmpty()) {
            this.request_ = param1Requests.request_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureRequestIsMutable();
            this.request_.addAll(param1Requests.request_);
          } 
          onChanged();
        } 
      } else if (!param1Requests.request_.isEmpty()) {
        if (this.requestBuilder_.isEmpty()) {
          this.requestBuilder_.dispose();
          RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
          this.requestBuilder_ = null;
          this.request_ = param1Requests.request_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (ClientProtos.Requests.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getRequestFieldBuilder(); 
          this.requestBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.requestBuilder_.addAllMessages(param1Requests.request_);
        } 
      } 
      mergeUnknownFields(param1Requests.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ClientProtos.Requests requests = (ClientProtos.Requests)ClientProtos.Requests.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ClientProtos.Requests requests = (ClientProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ClientProtos.Requests)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ClientProtos.Requests)
        return mergeFrom((ClientProtos.Requests)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRequest(int param1Int) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setCommon(CommonProtos.Common.Builder param1Builder) {
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.common_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setCommon(CommonProtos.Common param1Common) {
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Common != null) {
          this.common_ = param1Common;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Common);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequest(int param1Int, ClientProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequest(int param1Int, ClientProtos.Request param1Request) {
      RepeatedFieldBuilderV3<ClientProtos.Request, ClientProtos.Request.Builder, ClientProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Request != null) {
          ensureRequestIsMutable();
          this.request_.set(param1Int, param1Request);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Request);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface RequestsOrBuilder extends MessageOrBuilder {
    CommonProtos.Common getCommon();
    
    CommonProtos.CommonOrBuilder getCommonOrBuilder();
    
    ClientProtos.Request getRequest(int param1Int);
    
    int getRequestCount();
    
    List<ClientProtos.Request> getRequestList();
    
    ClientProtos.RequestOrBuilder getRequestOrBuilder(int param1Int);
    
    List<? extends ClientProtos.RequestOrBuilder> getRequestOrBuilderList();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public ClientProtos.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ClientProtos.Response(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int code_;
    
    private byte memoizedIsInitialized = -1;
    
    private Response() {}
    
    private Response(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.code_ = param1CodedInputStream.readInt32();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Response(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Response getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ClientProtos.internal_static_com_blued_das_client_Response_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Response param1Response) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Response);
    }
    
    public static Response parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Response)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Response parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Response)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteString);
    }
    
    public static Response parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Response parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(InputStream param1InputStream) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Response parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Response parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Response parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Response> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Response))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getCode() != param1Object.getCode()) ? false : (!!this.unknownFields.equals(((Response)param1Object).unknownFields));
    }
    
    public int getCode() {
      return this.code_;
    }
    
    public Response getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<Response> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.code_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeInt32Size(1, j); 
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
      int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ClientProtos.internal_static_com_blued_das_client_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new Response();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = this.code_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientProtos.ResponseOrBuilder {
      private int code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ClientProtos.internal_static_com_blued_das_client_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ClientProtos.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ClientProtos.Response build() {
        ClientProtos.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public ClientProtos.Response buildPartial() {
        ClientProtos.Response response = new ClientProtos.Response(this);
        ClientProtos.Response.access$3202(response, this.code_);
        onBuilt();
        return response;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0;
        return this;
      }
      
      public Builder clearCode() {
        this.code_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public int getCode() {
        return this.code_;
      }
      
      public ClientProtos.Response getDefaultInstanceForType() {
        return ClientProtos.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ClientProtos.internal_static_com_blued_das_client_Response_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ClientProtos.internal_static_com_blued_das_client_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientProtos.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ClientProtos.Response param2Response) {
        if (param2Response == ClientProtos.Response.getDefaultInstance())
          return this; 
        if (param2Response.getCode() != 0)
          setCode(param2Response.getCode()); 
        mergeUnknownFields(param2Response.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ClientProtos.Response response = (ClientProtos.Response)ClientProtos.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ClientProtos.Response response = (ClientProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ClientProtos.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ClientProtos.Response)
          return mergeFrom((ClientProtos.Response)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCode(int param2Int) {
        this.code_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Response> {
    public ClientProtos.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ClientProtos.Response(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Response.Builder> implements ResponseOrBuilder {
    private int code_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ClientProtos.internal_static_com_blued_das_client_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ClientProtos.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ClientProtos.Response build() {
      ClientProtos.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public ClientProtos.Response buildPartial() {
      ClientProtos.Response response = new ClientProtos.Response(this);
      ClientProtos.Response.access$3202(response, this.code_);
      onBuilt();
      return response;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      return this;
    }
    
    public Builder clearCode() {
      this.code_ = 0;
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
    
    public int getCode() {
      return this.code_;
    }
    
    public ClientProtos.Response getDefaultInstanceForType() {
      return ClientProtos.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ClientProtos.internal_static_com_blued_das_client_Response_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ClientProtos.internal_static_com_blued_das_client_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientProtos.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ClientProtos.Response param1Response) {
      if (param1Response == ClientProtos.Response.getDefaultInstance())
        return this; 
      if (param1Response.getCode() != 0)
        setCode(param1Response.getCode()); 
      mergeUnknownFields(param1Response.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ClientProtos.Response response = (ClientProtos.Response)ClientProtos.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ClientProtos.Response response = (ClientProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ClientProtos.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ClientProtos.Response)
        return mergeFrom((ClientProtos.Response)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCode(int param1Int) {
      this.code_ = param1Int;
      onChanged();
      return this;
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
  
  public static interface ResponseOrBuilder extends MessageOrBuilder {
    int getCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\ClientProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
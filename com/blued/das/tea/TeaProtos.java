package com.blued.das.tea;

import com.blued.das.CommonProtos;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class TeaProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_tea_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_tea_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_tea_Request_descriptor, new String[] { "Common", "Event", "Params", "Time", "ClientTime" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_tea_Response_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_tea_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_tea_Response_descriptor, new String[] { "Code" });
  
  static {
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
    Descriptors.FileDescriptor fileDescriptor = CommonProtos.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\017TeaProtos.proto\022\021com.blued.das.tea\032\022CommonProtos.proto\"r\n\007Request\022%\n\006common\030\001 \001(\0132\025.com.blued.das.Common\022\r\n\005event\030\002 \001(\t\022\016\n\006params\030\003 \001(\t\022\f\n\004time\030\004 \001(\003\022\023\n\013client_time\030\005 \001(\003\"\030\n\bResponse\022\f\n\004code\030\001 \001(\0052T\n\rReportService\022C\n\006Report\022\032.com.blued.das.tea.Request\032\033.com.blued.das.tea.Response\"\000B\006¢\002\003TEAb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int CLIENT_TIME_FIELD_NUMBER = 5;
    
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int EVENT_FIELD_NUMBER = 2;
    
    public static final int PARAMS_FIELD_NUMBER = 3;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public TeaProtos.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new TeaProtos.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TIME_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private long clientTime_;
    
    private CommonProtos.Common common_;
    
    private volatile Object event_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object params_;
    
    private long time_;
    
    private Request() {
      this.event_ = "";
      this.params_ = "";
    }
    
    private Request(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 26) {
                    if (i != 32) {
                      if (i != 40) {
                        if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                          continue; 
                        continue;
                      } 
                      this.clientTime_ = param1CodedInputStream.readInt64();
                      continue;
                    } 
                    this.time_ = param1CodedInputStream.readInt64();
                    continue;
                  } 
                  this.params_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.event_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              CommonProtos.Common.Builder builder1 = null;
              if (this.common_ != null)
                builder1 = this.common_.toBuilder(); 
              this.common_ = (CommonProtos.Common)param1CodedInputStream.readMessage(CommonProtos.Common.parser(), param1ExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom(this.common_);
                this.common_ = builder1.buildPartial();
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
      return TeaProtos.internal_static_com_blued_das_tea_Request_descriptor;
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
      return (hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : (!getEvent().equals(param1Object.getEvent()) ? false : (!getParams().equals(param1Object.getParams()) ? false : ((getTime() != param1Object.getTime()) ? false : ((getClientTime() != param1Object.getClientTime()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields)))))));
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
    
    public String getEvent() {
      Object object = this.event_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.event_ = object;
      return (String)object;
    }
    
    public ByteString getEventBytes() {
      Object object = this.event_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.event_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getParams() {
      Object object = this.params_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.params_ = object;
      return (String)object;
    }
    
    public ByteString getParamsBytes() {
      Object object = this.params_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.params_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<Request> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.common_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getCommon()); 
      i = j;
      if (!getEventBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.event_); 
      j = i;
      if (!getParamsBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.params_); 
      long l = this.time_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(4, l); 
      l = this.clientTime_;
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
      i = ((((((((i * 37 + 2) * 53 + getEvent().hashCode()) * 37 + 3) * 53 + getParams().hashCode()) * 37 + 4) * 53 + Internal.hashLong(getTime())) * 37 + 5) * 53 + Internal.hashLong(getClientTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TeaProtos.internal_static_com_blued_das_tea_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getCommon()); 
      if (!getEventBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.event_); 
      if (!getParamsBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.params_); 
      long l = this.time_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      l = this.clientTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TeaProtos.RequestOrBuilder {
      private long clientTime_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private Object event_ = "";
      
      private Object params_ = "";
      
      private long time_;
      
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
        return TeaProtos.internal_static_com_blued_das_tea_Request_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        TeaProtos.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public TeaProtos.Request build() {
        TeaProtos.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public TeaProtos.Request buildPartial() {
        TeaProtos.Request request = new TeaProtos.Request(this);
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          TeaProtos.Request.access$602(request, this.common_);
        } else {
          TeaProtos.Request.access$602(request, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        TeaProtos.Request.access$702(request, this.event_);
        TeaProtos.Request.access$802(request, this.params_);
        TeaProtos.Request.access$902(request, this.time_);
        TeaProtos.Request.access$1002(request, this.clientTime_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        this.event_ = "";
        this.params_ = "";
        this.time_ = 0L;
        this.clientTime_ = 0L;
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
      
      public Builder clearEvent() {
        this.event_ = TeaProtos.Request.getDefaultInstance().getEvent();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearParams() {
        this.params_ = TeaProtos.Request.getDefaultInstance().getParams();
        onChanged();
        return this;
      }
      
      public Builder clearTime() {
        this.time_ = 0L;
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
      
      public TeaProtos.Request getDefaultInstanceForType() {
        return TeaProtos.Request.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return TeaProtos.internal_static_com_blued_das_tea_Request_descriptor;
      }
      
      public String getEvent() {
        Object object = this.event_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.event_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getEventBytes() {
        Object object = this.event_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.event_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getParams() {
        Object object = this.params_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.params_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getParamsBytes() {
        Object object = this.params_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.params_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public long getTime() {
        return this.time_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TeaProtos.internal_static_com_blued_das_tea_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(TeaProtos.Request.class, Builder.class);
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
      
      public Builder mergeFrom(TeaProtos.Request param2Request) {
        if (param2Request == TeaProtos.Request.getDefaultInstance())
          return this; 
        if (param2Request.hasCommon())
          mergeCommon(param2Request.getCommon()); 
        if (!param2Request.getEvent().isEmpty()) {
          this.event_ = param2Request.event_;
          onChanged();
        } 
        if (!param2Request.getParams().isEmpty()) {
          this.params_ = param2Request.params_;
          onChanged();
        } 
        if (param2Request.getTime() != 0L)
          setTime(param2Request.getTime()); 
        if (param2Request.getClientTime() != 0L)
          setClientTime(param2Request.getClientTime()); 
        mergeUnknownFields(param2Request.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          TeaProtos.Request request = (TeaProtos.Request)TeaProtos.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          TeaProtos.Request request = (TeaProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((TeaProtos.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof TeaProtos.Request)
          return mergeFrom((TeaProtos.Request)param2Message); 
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
      
      public Builder setEvent(String param2String) {
        if (param2String != null) {
          this.event_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEventBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          TeaProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.event_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setParams(String param2String) {
        if (param2String != null) {
          this.params_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setParamsBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          TeaProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.params_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTime(long param2Long) {
        this.time_ = param2Long;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Request> {
    public TeaProtos.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new TeaProtos.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private long clientTime_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private Object event_ = "";
    
    private Object params_ = "";
    
    private long time_;
    
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
      return TeaProtos.internal_static_com_blued_das_tea_Request_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      TeaProtos.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public TeaProtos.Request build() {
      TeaProtos.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public TeaProtos.Request buildPartial() {
      TeaProtos.Request request = new TeaProtos.Request(this);
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        TeaProtos.Request.access$602(request, this.common_);
      } else {
        TeaProtos.Request.access$602(request, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      TeaProtos.Request.access$702(request, this.event_);
      TeaProtos.Request.access$802(request, this.params_);
      TeaProtos.Request.access$902(request, this.time_);
      TeaProtos.Request.access$1002(request, this.clientTime_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      this.event_ = "";
      this.params_ = "";
      this.time_ = 0L;
      this.clientTime_ = 0L;
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
    
    public Builder clearEvent() {
      this.event_ = TeaProtos.Request.getDefaultInstance().getEvent();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearParams() {
      this.params_ = TeaProtos.Request.getDefaultInstance().getParams();
      onChanged();
      return this;
    }
    
    public Builder clearTime() {
      this.time_ = 0L;
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
    
    public TeaProtos.Request getDefaultInstanceForType() {
      return TeaProtos.Request.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return TeaProtos.internal_static_com_blued_das_tea_Request_descriptor;
    }
    
    public String getEvent() {
      Object object = this.event_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.event_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getEventBytes() {
      Object object = this.event_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.event_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getParams() {
      Object object = this.params_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.params_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getParamsBytes() {
      Object object = this.params_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.params_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getTime() {
      return this.time_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TeaProtos.internal_static_com_blued_das_tea_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(TeaProtos.Request.class, Builder.class);
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
    
    public Builder mergeFrom(TeaProtos.Request param1Request) {
      if (param1Request == TeaProtos.Request.getDefaultInstance())
        return this; 
      if (param1Request.hasCommon())
        mergeCommon(param1Request.getCommon()); 
      if (!param1Request.getEvent().isEmpty()) {
        this.event_ = param1Request.event_;
        onChanged();
      } 
      if (!param1Request.getParams().isEmpty()) {
        this.params_ = param1Request.params_;
        onChanged();
      } 
      if (param1Request.getTime() != 0L)
        setTime(param1Request.getTime()); 
      if (param1Request.getClientTime() != 0L)
        setClientTime(param1Request.getClientTime()); 
      mergeUnknownFields(param1Request.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        TeaProtos.Request request = (TeaProtos.Request)TeaProtos.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        TeaProtos.Request request = (TeaProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((TeaProtos.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof TeaProtos.Request)
        return mergeFrom((TeaProtos.Request)param1Message); 
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
    
    public Builder setEvent(String param1String) {
      if (param1String != null) {
        this.event_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEventBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        TeaProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.event_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setParams(String param1String) {
      if (param1String != null) {
        this.params_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setParamsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        TeaProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.params_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTime(long param1Long) {
      this.time_ = param1Long;
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
    
    String getEvent();
    
    ByteString getEventBytes();
    
    String getParams();
    
    ByteString getParamsBytes();
    
    long getTime();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public TeaProtos.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new TeaProtos.Response(param2CodedInputStream, param2ExtensionRegistryLite);
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
      return TeaProtos.internal_static_com_blued_das_tea_Response_descriptor;
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
      return TeaProtos.internal_static_com_blued_das_tea_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TeaProtos.ResponseOrBuilder {
      private int code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return TeaProtos.internal_static_com_blued_das_tea_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        TeaProtos.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public TeaProtos.Response build() {
        TeaProtos.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public TeaProtos.Response buildPartial() {
        TeaProtos.Response response = new TeaProtos.Response(this);
        TeaProtos.Response.access$2202(response, this.code_);
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
      
      public TeaProtos.Response getDefaultInstanceForType() {
        return TeaProtos.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return TeaProtos.internal_static_com_blued_das_tea_Response_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TeaProtos.internal_static_com_blued_das_tea_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(TeaProtos.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(TeaProtos.Response param2Response) {
        if (param2Response == TeaProtos.Response.getDefaultInstance())
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
          TeaProtos.Response response = (TeaProtos.Response)TeaProtos.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          TeaProtos.Response response = (TeaProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((TeaProtos.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof TeaProtos.Response)
          return mergeFrom((TeaProtos.Response)param2Message); 
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
    public TeaProtos.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new TeaProtos.Response(param1CodedInputStream, param1ExtensionRegistryLite);
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
      return TeaProtos.internal_static_com_blued_das_tea_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      TeaProtos.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public TeaProtos.Response build() {
      TeaProtos.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public TeaProtos.Response buildPartial() {
      TeaProtos.Response response = new TeaProtos.Response(this);
      TeaProtos.Response.access$2202(response, this.code_);
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
    
    public TeaProtos.Response getDefaultInstanceForType() {
      return TeaProtos.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return TeaProtos.internal_static_com_blued_das_tea_Response_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TeaProtos.internal_static_com_blued_das_tea_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(TeaProtos.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(TeaProtos.Response param1Response) {
      if (param1Response == TeaProtos.Response.getDefaultInstance())
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
        TeaProtos.Response response = (TeaProtos.Response)TeaProtos.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        TeaProtos.Response response = (TeaProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((TeaProtos.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof TeaProtos.Response)
        return mergeFrom((TeaProtos.Response)param1Message); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\tea\TeaProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
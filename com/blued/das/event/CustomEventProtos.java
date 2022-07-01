package com.blued.das.event;

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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CustomEventProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_event_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_event_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_event_Request_descriptor, new String[] { "Time", "Takes", "Code", "Description", "Name", "Common", "ClientTime" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_event_Requests_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_event_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_event_Requests_descriptor, new String[] { "Common", "Request" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_event_Response_descriptor = getDescriptor().getMessageTypes().get(2);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_event_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_event_Response_descriptor, new String[] { "Code" });
  
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
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\027CustomEventProtos.proto\022\023com.blued.das.event\032\022CommonProtos.proto\"\001\n\007Request\022\f\n\004time\030\001 \001(\003\022\r\n\005takes\030\002 \001(\005\022\f\n\004code\030\003 \001(\005\022\023\n\013description\030\004 \001(\t\022\f\n\004name\030\005 \001(\t\022%\n\006common\030\006 \001(\0132\025.com.blued.das.Common\022\023\n\013client_time\030\007 \001(\003\"`\n\bRequests\022%\n\006common\030\001 \001(\0132\025.com.blued.das.Common\022-\n\007request\030\002 \003(\0132\034.com.blued.das.event.Request\"\030\n\bResponse\022\f\n\004code\030\001 \001(\0052^\n\rReportService\022M\n\013BatchReport\022\035.com.blued.das.event.Requests\032\035.com.blued.das.event.Response\"\000B\b¢\002\005EVENTb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int CLIENT_TIME_FIELD_NUMBER = 7;
    
    public static final int CODE_FIELD_NUMBER = 3;
    
    public static final int COMMON_FIELD_NUMBER = 6;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    
    public static final int NAME_FIELD_NUMBER = 5;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public CustomEventProtos.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CustomEventProtos.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TAKES_FIELD_NUMBER = 2;
    
    public static final int TIME_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private long clientTime_;
    
    private int code_;
    
    private CommonProtos.Common common_;
    
    private volatile Object description_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object name_;
    
    private int takes_;
    
    private long time_;
    
    private Request() {
      this.description_ = "";
      this.name_ = "";
    }
    
    private Request(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 16) {
                  if (i != 24) {
                    if (i != 34) {
                      if (i != 42) {
                        if (i != 50) {
                          if (i != 56) {
                            if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                              continue; 
                            continue;
                          } 
                          this.clientTime_ = param1CodedInputStream.readInt64();
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
                      this.name_ = param1CodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    this.description_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.code_ = param1CodedInputStream.readInt32();
                  continue;
                } 
                this.takes_ = param1CodedInputStream.readInt32();
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
      return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
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
      return (getTime() != param1Object.getTime()) ? false : ((getTakes() != param1Object.getTakes()) ? false : ((getCode() != param1Object.getCode()) ? false : (!getDescription().equals(param1Object.getDescription()) ? false : (!getName().equals(param1Object.getName()) ? false : ((hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getClientTime() != param1Object.getClientTime()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields)))))))));
    }
    
    public long getClientTime() {
      return this.clientTime_;
    }
    
    public int getCode() {
      return this.code_;
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
    
    public String getDescription() {
      Object object = this.description_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.description_ = object;
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
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
      int k = this.takes_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(2, k); 
      k = this.code_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(3, k); 
      i = j;
      if (!getDescriptionBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.description_); 
      j = i;
      if (!getNameBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.name_); 
      i = j;
      if (this.common_ != null)
        i = j + CodedOutputStream.computeMessageSize(6, (MessageLite)getCommon()); 
      l = this.clientTime_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(7, l); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public int getTakes() {
      return this.takes_;
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
      int j = ((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getTime())) * 37 + 2) * 53 + getTakes()) * 37 + 3) * 53 + getCode()) * 37 + 4) * 53 + getDescription().hashCode()) * 37 + 5) * 53 + getName().hashCode();
      int i = j;
      if (hasCommon())
        i = (j * 37 + 6) * 53 + getCommon().hashCode(); 
      i = ((i * 37 + 7) * 53 + Internal.hashLong(getClientTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CustomEventProtos.internal_static_com_blued_das_event_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      int i = this.takes_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      i = this.code_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      if (!getDescriptionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.description_); 
      if (!getNameBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.name_); 
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getCommon()); 
      l = this.clientTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(7, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomEventProtos.RequestOrBuilder {
      private long clientTime_;
      
      private int code_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private Object description_ = "";
      
      private Object name_ = "";
      
      private int takes_;
      
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
        return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        CustomEventProtos.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public CustomEventProtos.Request build() {
        CustomEventProtos.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public CustomEventProtos.Request buildPartial() {
        CustomEventProtos.Request request = new CustomEventProtos.Request(this);
        CustomEventProtos.Request.access$602(request, this.time_);
        CustomEventProtos.Request.access$702(request, this.takes_);
        CustomEventProtos.Request.access$802(request, this.code_);
        CustomEventProtos.Request.access$902(request, this.description_);
        CustomEventProtos.Request.access$1002(request, this.name_);
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          CustomEventProtos.Request.access$1102(request, this.common_);
        } else {
          CustomEventProtos.Request.access$1102(request, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        CustomEventProtos.Request.access$1202(request, this.clientTime_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        this.time_ = 0L;
        this.takes_ = 0;
        this.code_ = 0;
        this.description_ = "";
        this.name_ = "";
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        this.clientTime_ = 0L;
        return this;
      }
      
      public Builder clearClientTime() {
        this.clientTime_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearCode() {
        this.code_ = 0;
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
      
      public Builder clearDescription() {
        this.description_ = CustomEventProtos.Request.getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearName() {
        this.name_ = CustomEventProtos.Request.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearTakes() {
        this.takes_ = 0;
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
      
      public int getCode() {
        return this.code_;
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
      
      public CustomEventProtos.Request getDefaultInstanceForType() {
        return CustomEventProtos.Request.getDefaultInstance();
      }
      
      public String getDescription() {
        Object object = this.description_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.description_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDescriptionBytes() {
        Object object = this.description_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.description_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
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
      
      public int getTakes() {
        return this.takes_;
      }
      
      public long getTime() {
        return this.time_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CustomEventProtos.internal_static_com_blued_das_event_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomEventProtos.Request.class, Builder.class);
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
      
      public Builder mergeFrom(CustomEventProtos.Request param2Request) {
        if (param2Request == CustomEventProtos.Request.getDefaultInstance())
          return this; 
        if (param2Request.getTime() != 0L)
          setTime(param2Request.getTime()); 
        if (param2Request.getTakes() != 0)
          setTakes(param2Request.getTakes()); 
        if (param2Request.getCode() != 0)
          setCode(param2Request.getCode()); 
        if (!param2Request.getDescription().isEmpty()) {
          this.description_ = param2Request.description_;
          onChanged();
        } 
        if (!param2Request.getName().isEmpty()) {
          this.name_ = param2Request.name_;
          onChanged();
        } 
        if (param2Request.hasCommon())
          mergeCommon(param2Request.getCommon()); 
        if (param2Request.getClientTime() != 0L)
          setClientTime(param2Request.getClientTime()); 
        mergeUnknownFields(param2Request.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          CustomEventProtos.Request request = (CustomEventProtos.Request)CustomEventProtos.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CustomEventProtos.Request request = (CustomEventProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CustomEventProtos.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CustomEventProtos.Request)
          return mergeFrom((CustomEventProtos.Request)param2Message); 
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
      
      public Builder setCode(int param2Int) {
        this.code_ = param2Int;
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
      
      public Builder setDescription(String param2String) {
        if (param2String != null) {
          this.description_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CustomEventProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.description_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setName(String param2String) {
        if (param2String != null) {
          this.name_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CustomEventProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.name_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTakes(int param2Int) {
        this.takes_ = param2Int;
        onChanged();
        return this;
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
    public CustomEventProtos.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CustomEventProtos.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private long clientTime_;
    
    private int code_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private Object description_ = "";
    
    private Object name_ = "";
    
    private int takes_;
    
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
      return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      CustomEventProtos.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CustomEventProtos.Request build() {
      CustomEventProtos.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public CustomEventProtos.Request buildPartial() {
      CustomEventProtos.Request request = new CustomEventProtos.Request(this);
      CustomEventProtos.Request.access$602(request, this.time_);
      CustomEventProtos.Request.access$702(request, this.takes_);
      CustomEventProtos.Request.access$802(request, this.code_);
      CustomEventProtos.Request.access$902(request, this.description_);
      CustomEventProtos.Request.access$1002(request, this.name_);
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        CustomEventProtos.Request.access$1102(request, this.common_);
      } else {
        CustomEventProtos.Request.access$1102(request, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      CustomEventProtos.Request.access$1202(request, this.clientTime_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      this.time_ = 0L;
      this.takes_ = 0;
      this.code_ = 0;
      this.description_ = "";
      this.name_ = "";
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      this.clientTime_ = 0L;
      return this;
    }
    
    public Builder clearClientTime() {
      this.clientTime_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearCode() {
      this.code_ = 0;
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
    
    public Builder clearDescription() {
      this.description_ = CustomEventProtos.Request.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = CustomEventProtos.Request.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTakes() {
      this.takes_ = 0;
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
    
    public int getCode() {
      return this.code_;
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
    
    public CustomEventProtos.Request getDefaultInstanceForType() {
      return CustomEventProtos.Request.getDefaultInstance();
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.description_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
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
    
    public int getTakes() {
      return this.takes_;
    }
    
    public long getTime() {
      return this.time_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CustomEventProtos.internal_static_com_blued_das_event_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomEventProtos.Request.class, Builder.class);
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
    
    public Builder mergeFrom(CustomEventProtos.Request param1Request) {
      if (param1Request == CustomEventProtos.Request.getDefaultInstance())
        return this; 
      if (param1Request.getTime() != 0L)
        setTime(param1Request.getTime()); 
      if (param1Request.getTakes() != 0)
        setTakes(param1Request.getTakes()); 
      if (param1Request.getCode() != 0)
        setCode(param1Request.getCode()); 
      if (!param1Request.getDescription().isEmpty()) {
        this.description_ = param1Request.description_;
        onChanged();
      } 
      if (!param1Request.getName().isEmpty()) {
        this.name_ = param1Request.name_;
        onChanged();
      } 
      if (param1Request.hasCommon())
        mergeCommon(param1Request.getCommon()); 
      if (param1Request.getClientTime() != 0L)
        setClientTime(param1Request.getClientTime()); 
      mergeUnknownFields(param1Request.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        CustomEventProtos.Request request = (CustomEventProtos.Request)CustomEventProtos.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CustomEventProtos.Request request = (CustomEventProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CustomEventProtos.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CustomEventProtos.Request)
        return mergeFrom((CustomEventProtos.Request)param1Message); 
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
    
    public Builder setCode(int param1Int) {
      this.code_ = param1Int;
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
    
    public Builder setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CustomEventProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        CustomEventProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTakes(int param1Int) {
      this.takes_ = param1Int;
      onChanged();
      return this;
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
    
    int getCode();
    
    CommonProtos.Common getCommon();
    
    CommonProtos.CommonOrBuilder getCommonOrBuilder();
    
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getName();
    
    ByteString getNameBytes();
    
    int getTakes();
    
    long getTime();
    
    boolean hasCommon();
  }
  
  public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final Requests DEFAULT_INSTANCE = new Requests();
    
    private static final Parser<Requests> PARSER = (Parser<Requests>)new AbstractParser<Requests>() {
        public CustomEventProtos.Requests parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CustomEventProtos.Requests(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private CommonProtos.Common common_;
    
    private byte memoizedIsInitialized = -1;
    
    private List<CustomEventProtos.Request> request_;
    
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
                  this.request_ = new ArrayList<CustomEventProtos.Request>();
                  n = i | 0x1;
                } 
                j = n;
                k = n;
                m = n;
                this.request_.add(param1CodedInputStream.readMessage(CustomEventProtos.Request.parser(), param1ExtensionRegistryLite));
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
      return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
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
    
    public CustomEventProtos.Request getRequest(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public int getRequestCount() {
      return this.request_.size();
    }
    
    public List<CustomEventProtos.Request> getRequestList() {
      return this.request_;
    }
    
    public CustomEventProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public List<? extends CustomEventProtos.RequestOrBuilder> getRequestOrBuilderList() {
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
      return CustomEventProtos.internal_static_com_blued_das_event_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomEventProtos.RequestsOrBuilder {
      private int bitField0_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> requestBuilder_;
      
      private List<CustomEventProtos.Request> request_ = Collections.emptyList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureRequestIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.request_ = new ArrayList<CustomEventProtos.Request>(this.request_);
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
        return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
      }
      
      private RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> getRequestFieldBuilder() {
        if (this.requestBuilder_ == null) {
          List<CustomEventProtos.Request> list = this.request_;
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
        if (CustomEventProtos.Requests.alwaysUseFieldBuilders)
          getRequestFieldBuilder(); 
      }
      
      public Builder addAllRequest(Iterable<? extends CustomEventProtos.Request> param2Iterable) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder addRequest(int param2Int, CustomEventProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(int param2Int, CustomEventProtos.Request param2Request) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder addRequest(CustomEventProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(CustomEventProtos.Request param2Request) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public CustomEventProtos.Request.Builder addRequestBuilder() {
        return (CustomEventProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)CustomEventProtos.Request.getDefaultInstance());
      }
      
      public CustomEventProtos.Request.Builder addRequestBuilder(int param2Int) {
        return (CustomEventProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param2Int, (AbstractMessage)CustomEventProtos.Request.getDefaultInstance());
      }
      
      public CustomEventProtos.Requests build() {
        CustomEventProtos.Requests requests = buildPartial();
        if (requests.isInitialized())
          return requests; 
        throw newUninitializedMessageException(requests);
      }
      
      public CustomEventProtos.Requests buildPartial() {
        CustomEventProtos.Requests requests = new CustomEventProtos.Requests(this);
        int i = this.bitField0_;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          CustomEventProtos.Requests.access$2402(requests, this.common_);
        } else {
          CustomEventProtos.Requests.access$2402(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x1) != 0) {
            this.request_ = Collections.unmodifiableList(this.request_);
            this.bitField0_ &= 0xFFFFFFFE;
          } 
          CustomEventProtos.Requests.access$2502(requests, this.request_);
        } else {
          CustomEventProtos.Requests.access$2502(requests, repeatedFieldBuilderV3.build());
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
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public CustomEventProtos.Requests getDefaultInstanceForType() {
        return CustomEventProtos.Requests.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
      }
      
      public CustomEventProtos.Request getRequest(int param2Int) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (CustomEventProtos.Request)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public CustomEventProtos.Request.Builder getRequestBuilder(int param2Int) {
        return (CustomEventProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param2Int);
      }
      
      public List<CustomEventProtos.Request.Builder> getRequestBuilderList() {
        return getRequestFieldBuilder().getBuilderList();
      }
      
      public int getRequestCount() {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<CustomEventProtos.Request> getRequestList() {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public CustomEventProtos.RequestOrBuilder getRequestOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (CustomEventProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends CustomEventProtos.RequestOrBuilder> getRequestOrBuilderList() {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CustomEventProtos.internal_static_com_blued_das_event_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomEventProtos.Requests.class, Builder.class);
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
      
      public Builder mergeFrom(CustomEventProtos.Requests param2Requests) {
        if (param2Requests == CustomEventProtos.Requests.getDefaultInstance())
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
            RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
            this.requestBuilder_ = null;
            this.request_ = param2Requests.request_;
            this.bitField0_ &= 0xFFFFFFFE;
            if (CustomEventProtos.Requests.alwaysUseFieldBuilders)
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
          CustomEventProtos.Requests requests = (CustomEventProtos.Requests)CustomEventProtos.Requests.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CustomEventProtos.Requests requests = (CustomEventProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CustomEventProtos.Requests)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CustomEventProtos.Requests)
          return mergeFrom((CustomEventProtos.Requests)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeRequest(int param2Int) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder setRequest(int param2Int, CustomEventProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setRequest(int param2Int, CustomEventProtos.Request param2Request) {
        RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    public CustomEventProtos.Requests parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CustomEventProtos.Requests(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Requests.Builder> implements RequestsOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> requestBuilder_;
    
    private List<CustomEventProtos.Request> request_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRequestIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.request_ = new ArrayList<CustomEventProtos.Request>(this.request_);
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
      return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
    }
    
    private RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> getRequestFieldBuilder() {
      if (this.requestBuilder_ == null) {
        List<CustomEventProtos.Request> list = this.request_;
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
      if (CustomEventProtos.Requests.alwaysUseFieldBuilders)
        getRequestFieldBuilder(); 
    }
    
    public Builder addAllRequest(Iterable<? extends CustomEventProtos.Request> param1Iterable) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder addRequest(int param1Int, CustomEventProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(int param1Int, CustomEventProtos.Request param1Request) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder addRequest(CustomEventProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(CustomEventProtos.Request param1Request) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public CustomEventProtos.Request.Builder addRequestBuilder() {
      return (CustomEventProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)CustomEventProtos.Request.getDefaultInstance());
    }
    
    public CustomEventProtos.Request.Builder addRequestBuilder(int param1Int) {
      return (CustomEventProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param1Int, (AbstractMessage)CustomEventProtos.Request.getDefaultInstance());
    }
    
    public CustomEventProtos.Requests build() {
      CustomEventProtos.Requests requests = buildPartial();
      if (requests.isInitialized())
        return requests; 
      throw newUninitializedMessageException(requests);
    }
    
    public CustomEventProtos.Requests buildPartial() {
      CustomEventProtos.Requests requests = new CustomEventProtos.Requests(this);
      int i = this.bitField0_;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        CustomEventProtos.Requests.access$2402(requests, this.common_);
      } else {
        CustomEventProtos.Requests.access$2402(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.request_ = Collections.unmodifiableList(this.request_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        CustomEventProtos.Requests.access$2502(requests, this.request_);
      } else {
        CustomEventProtos.Requests.access$2502(requests, repeatedFieldBuilderV3.build());
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
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public CustomEventProtos.Requests getDefaultInstanceForType() {
      return CustomEventProtos.Requests.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
    }
    
    public CustomEventProtos.Request getRequest(int param1Int) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (CustomEventProtos.Request)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public CustomEventProtos.Request.Builder getRequestBuilder(int param1Int) {
      return (CustomEventProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param1Int);
    }
    
    public List<CustomEventProtos.Request.Builder> getRequestBuilderList() {
      return getRequestFieldBuilder().getBuilderList();
    }
    
    public int getRequestCount() {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<CustomEventProtos.Request> getRequestList() {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public CustomEventProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (CustomEventProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends CustomEventProtos.RequestOrBuilder> getRequestOrBuilderList() {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CustomEventProtos.internal_static_com_blued_das_event_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomEventProtos.Requests.class, Builder.class);
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
    
    public Builder mergeFrom(CustomEventProtos.Requests param1Requests) {
      if (param1Requests == CustomEventProtos.Requests.getDefaultInstance())
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
          RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
          this.requestBuilder_ = null;
          this.request_ = param1Requests.request_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (CustomEventProtos.Requests.alwaysUseFieldBuilders)
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
        CustomEventProtos.Requests requests = (CustomEventProtos.Requests)CustomEventProtos.Requests.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CustomEventProtos.Requests requests = (CustomEventProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CustomEventProtos.Requests)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CustomEventProtos.Requests)
        return mergeFrom((CustomEventProtos.Requests)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRequest(int param1Int) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder setRequest(int param1Int, CustomEventProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequest(int param1Int, CustomEventProtos.Request param1Request) {
      RepeatedFieldBuilderV3<CustomEventProtos.Request, CustomEventProtos.Request.Builder, CustomEventProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    CustomEventProtos.Request getRequest(int param1Int);
    
    int getRequestCount();
    
    List<CustomEventProtos.Request> getRequestList();
    
    CustomEventProtos.RequestOrBuilder getRequestOrBuilder(int param1Int);
    
    List<? extends CustomEventProtos.RequestOrBuilder> getRequestOrBuilderList();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public CustomEventProtos.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CustomEventProtos.Response(param2CodedInputStream, param2ExtensionRegistryLite);
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
      return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
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
      return CustomEventProtos.internal_static_com_blued_das_event_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomEventProtos.ResponseOrBuilder {
      private int code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        CustomEventProtos.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public CustomEventProtos.Response build() {
        CustomEventProtos.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public CustomEventProtos.Response buildPartial() {
        CustomEventProtos.Response response = new CustomEventProtos.Response(this);
        CustomEventProtos.Response.access$3602(response, this.code_);
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
      
      public CustomEventProtos.Response getDefaultInstanceForType() {
        return CustomEventProtos.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CustomEventProtos.internal_static_com_blued_das_event_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomEventProtos.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CustomEventProtos.Response param2Response) {
        if (param2Response == CustomEventProtos.Response.getDefaultInstance())
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
          CustomEventProtos.Response response = (CustomEventProtos.Response)CustomEventProtos.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CustomEventProtos.Response response = (CustomEventProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CustomEventProtos.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CustomEventProtos.Response)
          return mergeFrom((CustomEventProtos.Response)param2Message); 
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
    public CustomEventProtos.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CustomEventProtos.Response(param1CodedInputStream, param1ExtensionRegistryLite);
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
      return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      CustomEventProtos.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CustomEventProtos.Response build() {
      CustomEventProtos.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public CustomEventProtos.Response buildPartial() {
      CustomEventProtos.Response response = new CustomEventProtos.Response(this);
      CustomEventProtos.Response.access$3602(response, this.code_);
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
    
    public CustomEventProtos.Response getDefaultInstanceForType() {
      return CustomEventProtos.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CustomEventProtos.internal_static_com_blued_das_event_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomEventProtos.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CustomEventProtos.Response param1Response) {
      if (param1Response == CustomEventProtos.Response.getDefaultInstance())
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
        CustomEventProtos.Response response = (CustomEventProtos.Response)CustomEventProtos.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CustomEventProtos.Response response = (CustomEventProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CustomEventProtos.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CustomEventProtos.Response)
        return mergeFrom((CustomEventProtos.Response)param1Message); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\event\CustomEventProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
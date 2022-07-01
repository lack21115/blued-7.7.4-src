package com.blued.das.perf;

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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PerfProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_perf_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_perf_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_perf_Request_descriptor, new String[] { "Type", "Takes", "Code", "Description", "Time", "Common", "ClientTime" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_perf_Requests_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_perf_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_perf_Requests_descriptor, new String[] { "Common", "Request" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_perf_Response_descriptor = getDescriptor().getMessageTypes().get(2);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_perf_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_perf_Response_descriptor, new String[] { "Code" });
  
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
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\020PerfProtos.proto\022\022com.blued.das.perf\032\022CommonProtos.proto\"­\001\n\007Request\022&\n\004type\030\001 \001(\0162\030.com.blued.das.perf.Type\022\r\n\005takes\030\002 \001(\005\022\f\n\004code\030\003 \001(\005\022\023\n\013description\030\004 \001(\t\022\f\n\004time\030\005 \001(\003\022%\n\006common\030\006 \001(\0132\025.com.blued.das.Common\022\023\n\013client_time\030\007 \001(\003\"_\n\bRequests\022%\n\006common\030\001 \001(\0132\025.com.blued.das.Common\022,\n\007request\030\002 \003(\0132\033.com.blued.das.perf.Request\"\030\n\bResponse\022\f\n\004code\030\001 \001(\005*w\n\004Type\022\013\n\007UNKNOWN\020\000\022\007\n\003APM\020\001\022\020\n\fCUSTOM_EVENT\020\002\022\021\n\rPAGE_DURATION\020\003\022\023\n\017DAY_ACTIVE_USER\020\004\022\n\n\006CLIENT\020\005\022\n\n\006SERVER\020\006\022\007\n\003TEA\020\0072\\\n\rReportService\022K\n\013BatchReport\022\034.com.blued.das.perf.Requests\032\034.com.blued.das.perf.Response\"\000B\007¢\002\004PERFb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int CLIENT_TIME_FIELD_NUMBER = 7;
    
    public static final int CODE_FIELD_NUMBER = 3;
    
    public static final int COMMON_FIELD_NUMBER = 6;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public PerfProtos.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PerfProtos.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TAKES_FIELD_NUMBER = 2;
    
    public static final int TIME_FIELD_NUMBER = 5;
    
    public static final int TYPE_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private long clientTime_;
    
    private int code_;
    
    private CommonProtos.Common common_;
    
    private volatile Object description_;
    
    private byte memoizedIsInitialized = -1;
    
    private int takes_;
    
    private long time_;
    
    private int type_;
    
    private Request() {
      this.type_ = 0;
      this.description_ = "";
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
                      if (i != 40) {
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
                      this.time_ = param1CodedInputStream.readInt64();
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
              this.type_ = param1CodedInputStream.readEnum();
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
      return PerfProtos.internal_static_com_blued_das_perf_Request_descriptor;
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
      return (this.type_ != ((Request)param1Object).type_) ? false : ((getTakes() != param1Object.getTakes()) ? false : ((getCode() != param1Object.getCode()) ? false : (!getDescription().equals(param1Object.getDescription()) ? false : ((getTime() != param1Object.getTime()) ? false : ((hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getClientTime() != param1Object.getClientTime()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields)))))))));
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
    
    public Parser<Request> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.type_ != PerfProtos.Type.UNKNOWN.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.type_); 
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
      long l = this.time_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(5, l); 
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
    
    public PerfProtos.Type getType() {
      PerfProtos.Type type2 = PerfProtos.Type.valueOf(this.type_);
      PerfProtos.Type type1 = type2;
      if (type2 == null)
        type1 = PerfProtos.Type.UNRECOGNIZED; 
      return type1;
    }
    
    public int getTypeValue() {
      return this.type_;
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
      int j = ((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.type_) * 37 + 2) * 53 + getTakes()) * 37 + 3) * 53 + getCode()) * 37 + 4) * 53 + getDescription().hashCode()) * 37 + 5) * 53 + Internal.hashLong(getTime());
      int i = j;
      if (hasCommon())
        i = (j * 37 + 6) * 53 + getCommon().hashCode(); 
      i = ((i * 37 + 7) * 53 + Internal.hashLong(getClientTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PerfProtos.internal_static_com_blued_das_perf_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      if (this.type_ != PerfProtos.Type.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.type_); 
      int i = this.takes_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      i = this.code_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      if (!getDescriptionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.description_); 
      long l = this.time_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getCommon()); 
      l = this.clientTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(7, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PerfProtos.RequestOrBuilder {
      private long clientTime_;
      
      private int code_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private Object description_ = "";
      
      private int takes_;
      
      private long time_;
      
      private int type_ = 0;
      
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
        return PerfProtos.internal_static_com_blued_das_perf_Request_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PerfProtos.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PerfProtos.Request build() {
        PerfProtos.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public PerfProtos.Request buildPartial() {
        PerfProtos.Request request = new PerfProtos.Request(this);
        PerfProtos.Request.access$602(request, this.type_);
        PerfProtos.Request.access$702(request, this.takes_);
        PerfProtos.Request.access$802(request, this.code_);
        PerfProtos.Request.access$902(request, this.description_);
        PerfProtos.Request.access$1002(request, this.time_);
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          PerfProtos.Request.access$1102(request, this.common_);
        } else {
          PerfProtos.Request.access$1102(request, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        PerfProtos.Request.access$1202(request, this.clientTime_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        this.type_ = 0;
        this.takes_ = 0;
        this.code_ = 0;
        this.description_ = "";
        this.time_ = 0L;
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
        this.description_ = PerfProtos.Request.getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
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
      
      public Builder clearType() {
        this.type_ = 0;
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
      
      public PerfProtos.Request getDefaultInstanceForType() {
        return PerfProtos.Request.getDefaultInstance();
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
        return PerfProtos.internal_static_com_blued_das_perf_Request_descriptor;
      }
      
      public int getTakes() {
        return this.takes_;
      }
      
      public long getTime() {
        return this.time_;
      }
      
      public PerfProtos.Type getType() {
        PerfProtos.Type type2 = PerfProtos.Type.valueOf(this.type_);
        PerfProtos.Type type1 = type2;
        if (type2 == null)
          type1 = PerfProtos.Type.UNRECOGNIZED; 
        return type1;
      }
      
      public int getTypeValue() {
        return this.type_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PerfProtos.internal_static_com_blued_das_perf_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(PerfProtos.Request.class, Builder.class);
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
      
      public Builder mergeFrom(PerfProtos.Request param2Request) {
        if (param2Request == PerfProtos.Request.getDefaultInstance())
          return this; 
        if (param2Request.type_ != 0)
          setTypeValue(param2Request.getTypeValue()); 
        if (param2Request.getTakes() != 0)
          setTakes(param2Request.getTakes()); 
        if (param2Request.getCode() != 0)
          setCode(param2Request.getCode()); 
        if (!param2Request.getDescription().isEmpty()) {
          this.description_ = param2Request.description_;
          onChanged();
        } 
        if (param2Request.getTime() != 0L)
          setTime(param2Request.getTime()); 
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
          PerfProtos.Request request = (PerfProtos.Request)PerfProtos.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PerfProtos.Request request = (PerfProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PerfProtos.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PerfProtos.Request)
          return mergeFrom((PerfProtos.Request)param2Message); 
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
          PerfProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.description_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
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
      
      public Builder setType(PerfProtos.Type param2Type) {
        if (param2Type != null) {
          this.type_ = param2Type.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTypeValue(int param2Int) {
        this.type_ = param2Int;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Request> {
    public PerfProtos.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PerfProtos.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private long clientTime_;
    
    private int code_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private Object description_ = "";
    
    private int takes_;
    
    private long time_;
    
    private int type_ = 0;
    
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
      return PerfProtos.internal_static_com_blued_das_perf_Request_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PerfProtos.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PerfProtos.Request build() {
      PerfProtos.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public PerfProtos.Request buildPartial() {
      PerfProtos.Request request = new PerfProtos.Request(this);
      PerfProtos.Request.access$602(request, this.type_);
      PerfProtos.Request.access$702(request, this.takes_);
      PerfProtos.Request.access$802(request, this.code_);
      PerfProtos.Request.access$902(request, this.description_);
      PerfProtos.Request.access$1002(request, this.time_);
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        PerfProtos.Request.access$1102(request, this.common_);
      } else {
        PerfProtos.Request.access$1102(request, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      PerfProtos.Request.access$1202(request, this.clientTime_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = 0;
      this.takes_ = 0;
      this.code_ = 0;
      this.description_ = "";
      this.time_ = 0L;
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
      this.description_ = PerfProtos.Request.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
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
    
    public Builder clearType() {
      this.type_ = 0;
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
    
    public PerfProtos.Request getDefaultInstanceForType() {
      return PerfProtos.Request.getDefaultInstance();
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
      return PerfProtos.internal_static_com_blued_das_perf_Request_descriptor;
    }
    
    public int getTakes() {
      return this.takes_;
    }
    
    public long getTime() {
      return this.time_;
    }
    
    public PerfProtos.Type getType() {
      PerfProtos.Type type2 = PerfProtos.Type.valueOf(this.type_);
      PerfProtos.Type type1 = type2;
      if (type2 == null)
        type1 = PerfProtos.Type.UNRECOGNIZED; 
      return type1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PerfProtos.internal_static_com_blued_das_perf_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(PerfProtos.Request.class, Builder.class);
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
    
    public Builder mergeFrom(PerfProtos.Request param1Request) {
      if (param1Request == PerfProtos.Request.getDefaultInstance())
        return this; 
      if (param1Request.type_ != 0)
        setTypeValue(param1Request.getTypeValue()); 
      if (param1Request.getTakes() != 0)
        setTakes(param1Request.getTakes()); 
      if (param1Request.getCode() != 0)
        setCode(param1Request.getCode()); 
      if (!param1Request.getDescription().isEmpty()) {
        this.description_ = param1Request.description_;
        onChanged();
      } 
      if (param1Request.getTime() != 0L)
        setTime(param1Request.getTime()); 
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
        PerfProtos.Request request = (PerfProtos.Request)PerfProtos.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PerfProtos.Request request = (PerfProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PerfProtos.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PerfProtos.Request)
        return mergeFrom((PerfProtos.Request)param1Message); 
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
        PerfProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
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
    
    public Builder setType(PerfProtos.Type param1Type) {
      if (param1Type != null) {
        this.type_ = param1Type.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeValue(int param1Int) {
      this.type_ = param1Int;
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
    
    int getTakes();
    
    long getTime();
    
    PerfProtos.Type getType();
    
    int getTypeValue();
    
    boolean hasCommon();
  }
  
  public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final Requests DEFAULT_INSTANCE = new Requests();
    
    private static final Parser<Requests> PARSER = (Parser<Requests>)new AbstractParser<Requests>() {
        public PerfProtos.Requests parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PerfProtos.Requests(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private CommonProtos.Common common_;
    
    private byte memoizedIsInitialized = -1;
    
    private List<PerfProtos.Request> request_;
    
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
                  this.request_ = new ArrayList<PerfProtos.Request>();
                  n = i | 0x1;
                } 
                j = n;
                k = n;
                m = n;
                this.request_.add(param1CodedInputStream.readMessage(PerfProtos.Request.parser(), param1ExtensionRegistryLite));
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
      return PerfProtos.internal_static_com_blued_das_perf_Requests_descriptor;
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
    
    public PerfProtos.Request getRequest(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public int getRequestCount() {
      return this.request_.size();
    }
    
    public List<PerfProtos.Request> getRequestList() {
      return this.request_;
    }
    
    public PerfProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public List<? extends PerfProtos.RequestOrBuilder> getRequestOrBuilderList() {
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
      return PerfProtos.internal_static_com_blued_das_perf_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PerfProtos.RequestsOrBuilder {
      private int bitField0_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> requestBuilder_;
      
      private List<PerfProtos.Request> request_ = Collections.emptyList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureRequestIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.request_ = new ArrayList<PerfProtos.Request>(this.request_);
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
        return PerfProtos.internal_static_com_blued_das_perf_Requests_descriptor;
      }
      
      private RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> getRequestFieldBuilder() {
        if (this.requestBuilder_ == null) {
          List<PerfProtos.Request> list = this.request_;
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
        if (PerfProtos.Requests.alwaysUseFieldBuilders)
          getRequestFieldBuilder(); 
      }
      
      public Builder addAllRequest(Iterable<? extends PerfProtos.Request> param2Iterable) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder addRequest(int param2Int, PerfProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(int param2Int, PerfProtos.Request param2Request) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder addRequest(PerfProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(PerfProtos.Request param2Request) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public PerfProtos.Request.Builder addRequestBuilder() {
        return (PerfProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)PerfProtos.Request.getDefaultInstance());
      }
      
      public PerfProtos.Request.Builder addRequestBuilder(int param2Int) {
        return (PerfProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param2Int, (AbstractMessage)PerfProtos.Request.getDefaultInstance());
      }
      
      public PerfProtos.Requests build() {
        PerfProtos.Requests requests = buildPartial();
        if (requests.isInitialized())
          return requests; 
        throw newUninitializedMessageException(requests);
      }
      
      public PerfProtos.Requests buildPartial() {
        PerfProtos.Requests requests = new PerfProtos.Requests(this);
        int i = this.bitField0_;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          PerfProtos.Requests.access$2302(requests, this.common_);
        } else {
          PerfProtos.Requests.access$2302(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x1) != 0) {
            this.request_ = Collections.unmodifiableList(this.request_);
            this.bitField0_ &= 0xFFFFFFFE;
          } 
          PerfProtos.Requests.access$2402(requests, this.request_);
        } else {
          PerfProtos.Requests.access$2402(requests, repeatedFieldBuilderV3.build());
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
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public PerfProtos.Requests getDefaultInstanceForType() {
        return PerfProtos.Requests.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PerfProtos.internal_static_com_blued_das_perf_Requests_descriptor;
      }
      
      public PerfProtos.Request getRequest(int param2Int) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (PerfProtos.Request)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public PerfProtos.Request.Builder getRequestBuilder(int param2Int) {
        return (PerfProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param2Int);
      }
      
      public List<PerfProtos.Request.Builder> getRequestBuilderList() {
        return getRequestFieldBuilder().getBuilderList();
      }
      
      public int getRequestCount() {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<PerfProtos.Request> getRequestList() {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public PerfProtos.RequestOrBuilder getRequestOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (PerfProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends PerfProtos.RequestOrBuilder> getRequestOrBuilderList() {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PerfProtos.internal_static_com_blued_das_perf_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(PerfProtos.Requests.class, Builder.class);
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
      
      public Builder mergeFrom(PerfProtos.Requests param2Requests) {
        if (param2Requests == PerfProtos.Requests.getDefaultInstance())
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
            RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
            this.requestBuilder_ = null;
            this.request_ = param2Requests.request_;
            this.bitField0_ &= 0xFFFFFFFE;
            if (PerfProtos.Requests.alwaysUseFieldBuilders)
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
          PerfProtos.Requests requests = (PerfProtos.Requests)PerfProtos.Requests.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PerfProtos.Requests requests = (PerfProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PerfProtos.Requests)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PerfProtos.Requests)
          return mergeFrom((PerfProtos.Requests)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeRequest(int param2Int) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder setRequest(int param2Int, PerfProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setRequest(int param2Int, PerfProtos.Request param2Request) {
        RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    public PerfProtos.Requests parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PerfProtos.Requests(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Requests.Builder> implements RequestsOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> requestBuilder_;
    
    private List<PerfProtos.Request> request_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRequestIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.request_ = new ArrayList<PerfProtos.Request>(this.request_);
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
      return PerfProtos.internal_static_com_blued_das_perf_Requests_descriptor;
    }
    
    private RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> getRequestFieldBuilder() {
      if (this.requestBuilder_ == null) {
        List<PerfProtos.Request> list = this.request_;
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
      if (PerfProtos.Requests.alwaysUseFieldBuilders)
        getRequestFieldBuilder(); 
    }
    
    public Builder addAllRequest(Iterable<? extends PerfProtos.Request> param1Iterable) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder addRequest(int param1Int, PerfProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(int param1Int, PerfProtos.Request param1Request) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder addRequest(PerfProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(PerfProtos.Request param1Request) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public PerfProtos.Request.Builder addRequestBuilder() {
      return (PerfProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)PerfProtos.Request.getDefaultInstance());
    }
    
    public PerfProtos.Request.Builder addRequestBuilder(int param1Int) {
      return (PerfProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param1Int, (AbstractMessage)PerfProtos.Request.getDefaultInstance());
    }
    
    public PerfProtos.Requests build() {
      PerfProtos.Requests requests = buildPartial();
      if (requests.isInitialized())
        return requests; 
      throw newUninitializedMessageException(requests);
    }
    
    public PerfProtos.Requests buildPartial() {
      PerfProtos.Requests requests = new PerfProtos.Requests(this);
      int i = this.bitField0_;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        PerfProtos.Requests.access$2302(requests, this.common_);
      } else {
        PerfProtos.Requests.access$2302(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.request_ = Collections.unmodifiableList(this.request_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        PerfProtos.Requests.access$2402(requests, this.request_);
      } else {
        PerfProtos.Requests.access$2402(requests, repeatedFieldBuilderV3.build());
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
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public PerfProtos.Requests getDefaultInstanceForType() {
      return PerfProtos.Requests.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PerfProtos.internal_static_com_blued_das_perf_Requests_descriptor;
    }
    
    public PerfProtos.Request getRequest(int param1Int) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (PerfProtos.Request)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public PerfProtos.Request.Builder getRequestBuilder(int param1Int) {
      return (PerfProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param1Int);
    }
    
    public List<PerfProtos.Request.Builder> getRequestBuilderList() {
      return getRequestFieldBuilder().getBuilderList();
    }
    
    public int getRequestCount() {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<PerfProtos.Request> getRequestList() {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public PerfProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (PerfProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends PerfProtos.RequestOrBuilder> getRequestOrBuilderList() {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PerfProtos.internal_static_com_blued_das_perf_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(PerfProtos.Requests.class, Builder.class);
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
    
    public Builder mergeFrom(PerfProtos.Requests param1Requests) {
      if (param1Requests == PerfProtos.Requests.getDefaultInstance())
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
          RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
          this.requestBuilder_ = null;
          this.request_ = param1Requests.request_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (PerfProtos.Requests.alwaysUseFieldBuilders)
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
        PerfProtos.Requests requests = (PerfProtos.Requests)PerfProtos.Requests.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PerfProtos.Requests requests = (PerfProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PerfProtos.Requests)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PerfProtos.Requests)
        return mergeFrom((PerfProtos.Requests)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRequest(int param1Int) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder setRequest(int param1Int, PerfProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequest(int param1Int, PerfProtos.Request param1Request) {
      RepeatedFieldBuilderV3<PerfProtos.Request, PerfProtos.Request.Builder, PerfProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    PerfProtos.Request getRequest(int param1Int);
    
    int getRequestCount();
    
    List<PerfProtos.Request> getRequestList();
    
    PerfProtos.RequestOrBuilder getRequestOrBuilder(int param1Int);
    
    List<? extends PerfProtos.RequestOrBuilder> getRequestOrBuilderList();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public PerfProtos.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PerfProtos.Response(param2CodedInputStream, param2ExtensionRegistryLite);
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
      return PerfProtos.internal_static_com_blued_das_perf_Response_descriptor;
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
      return PerfProtos.internal_static_com_blued_das_perf_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PerfProtos.ResponseOrBuilder {
      private int code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PerfProtos.internal_static_com_blued_das_perf_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PerfProtos.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PerfProtos.Response build() {
        PerfProtos.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public PerfProtos.Response buildPartial() {
        PerfProtos.Response response = new PerfProtos.Response(this);
        PerfProtos.Response.access$3502(response, this.code_);
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
      
      public PerfProtos.Response getDefaultInstanceForType() {
        return PerfProtos.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PerfProtos.internal_static_com_blued_das_perf_Response_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PerfProtos.internal_static_com_blued_das_perf_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(PerfProtos.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(PerfProtos.Response param2Response) {
        if (param2Response == PerfProtos.Response.getDefaultInstance())
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
          PerfProtos.Response response = (PerfProtos.Response)PerfProtos.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PerfProtos.Response response = (PerfProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PerfProtos.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PerfProtos.Response)
          return mergeFrom((PerfProtos.Response)param2Message); 
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
    public PerfProtos.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PerfProtos.Response(param1CodedInputStream, param1ExtensionRegistryLite);
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
      return PerfProtos.internal_static_com_blued_das_perf_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PerfProtos.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PerfProtos.Response build() {
      PerfProtos.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public PerfProtos.Response buildPartial() {
      PerfProtos.Response response = new PerfProtos.Response(this);
      PerfProtos.Response.access$3502(response, this.code_);
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
    
    public PerfProtos.Response getDefaultInstanceForType() {
      return PerfProtos.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PerfProtos.internal_static_com_blued_das_perf_Response_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PerfProtos.internal_static_com_blued_das_perf_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(PerfProtos.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(PerfProtos.Response param1Response) {
      if (param1Response == PerfProtos.Response.getDefaultInstance())
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
        PerfProtos.Response response = (PerfProtos.Response)PerfProtos.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PerfProtos.Response response = (PerfProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PerfProtos.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PerfProtos.Response)
        return mergeFrom((PerfProtos.Response)param1Message); 
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
  
  public enum Type implements ProtocolMessageEnum {
    APM,
    CLIENT,
    CUSTOM_EVENT,
    DAY_ACTIVE_USER,
    PAGE_DURATION,
    SERVER,
    TEA,
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int APM_VALUE = 1;
    
    public static final int CLIENT_VALUE = 5;
    
    public static final int CUSTOM_EVENT_VALUE = 2;
    
    public static final int DAY_ACTIVE_USER_VALUE = 4;
    
    public static final int PAGE_DURATION_VALUE = 3;
    
    public static final int SERVER_VALUE = 6;
    
    public static final int TEA_VALUE = 7;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Type[] VALUES;
    
    private static final Internal.EnumLiteMap<Type> internalValueMap;
    
    private final int value;
    
    static {
      DAY_ACTIVE_USER = new Type("DAY_ACTIVE_USER", 4, 4);
      CLIENT = new Type("CLIENT", 5, 5);
      SERVER = new Type("SERVER", 6, 6);
      TEA = new Type("TEA", 7, 7);
      UNRECOGNIZED = new Type("UNRECOGNIZED", 8, -1);
      $VALUES = new Type[] { UNKNOWN, APM, CUSTOM_EVENT, PAGE_DURATION, DAY_ACTIVE_USER, CLIENT, SERVER, TEA, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Type>() {
          public PerfProtos.Type findValueByNumber(int param2Int) {
            return PerfProtos.Type.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Type(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Type forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 7:
          return TEA;
        case 6:
          return SERVER;
        case 5:
          return CLIENT;
        case 4:
          return DAY_ACTIVE_USER;
        case 3:
          return PAGE_DURATION;
        case 2:
          return CUSTOM_EVENT;
        case 1:
          return APM;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PerfProtos.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<Type> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public final int getNumber() {
      if (this != UNRECOGNIZED)
        return this.value; 
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      if (this != UNRECOGNIZED)
        return getDescriptor().getValues().get(ordinal()); 
      throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
  }
  
  static final class null implements Internal.EnumLiteMap<Type> {
    public PerfProtos.Type findValueByNumber(int param1Int) {
      return PerfProtos.Type.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\perf\PerfProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
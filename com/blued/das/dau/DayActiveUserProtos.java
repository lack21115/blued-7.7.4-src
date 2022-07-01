package com.blued.das.dau;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DayActiveUserProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_dau_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_dau_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_dau_Request_descriptor, new String[] { "Time", "Name", "Common", "ClientTime" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_dau_Response_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_dau_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_dau_Response_descriptor, new String[] { "Code" });
  
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
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\031DayActiveUserProtos.proto\022\021com.blued.das.dau\032\022CommonProtos.proto\"z\n\007Request\022\f\n\004time\030\001 \001(\003\022%\n\004name\030\002 \001(\0162\027.com.blued.das.dau.NAME\022%\n\006common\030\003 \001(\0132\025.com.blued.das.Common\022\023\n\013client_time\030\004 \001(\003\"\030\n\bResponse\022\f\n\004code\030\001 \001(\005*`\n\004NAME\022\013\n\007UNKNOWN\020\000\022\t\n\005LOGIN\020\001\022\023\n\017SWITCH_TO_FRONT\020\002\022\022\n\016SWITCH_TO_BACK\020\003\022\013\n\007REGULAR\020\004\022\n\n\006LOGOUT\020\0052T\n\rReportService\022C\n\006Report\022\032.com.blued.das.dau.Request\032\033.com.blued.das.dau.Response\"\000B\022¢\002\017DAY_ACTIVE_USERb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public enum NAME implements ProtocolMessageEnum {
    LOGIN,
    LOGOUT,
    REGULAR,
    SWITCH_TO_BACK,
    SWITCH_TO_FRONT,
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int LOGIN_VALUE = 1;
    
    public static final int LOGOUT_VALUE = 5;
    
    public static final int REGULAR_VALUE = 4;
    
    public static final int SWITCH_TO_BACK_VALUE = 3;
    
    public static final int SWITCH_TO_FRONT_VALUE = 2;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final NAME[] VALUES;
    
    private static final Internal.EnumLiteMap<NAME> internalValueMap;
    
    private final int value;
    
    static {
      SWITCH_TO_BACK = new NAME("SWITCH_TO_BACK", 3, 3);
      REGULAR = new NAME("REGULAR", 4, 4);
      LOGOUT = new NAME("LOGOUT", 5, 5);
      UNRECOGNIZED = new NAME("UNRECOGNIZED", 6, -1);
      $VALUES = new NAME[] { UNKNOWN, LOGIN, SWITCH_TO_FRONT, SWITCH_TO_BACK, REGULAR, LOGOUT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<NAME>() {
          public DayActiveUserProtos.NAME findValueByNumber(int param2Int) {
            return DayActiveUserProtos.NAME.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    NAME(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static NAME forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : LOGOUT) : REGULAR) : SWITCH_TO_BACK) : SWITCH_TO_FRONT) : LOGIN) : UNKNOWN;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return DayActiveUserProtos.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<NAME> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<NAME> {
    public DayActiveUserProtos.NAME findValueByNumber(int param1Int) {
      return DayActiveUserProtos.NAME.forNumber(param1Int);
    }
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int CLIENT_TIME_FIELD_NUMBER = 4;
    
    public static final int COMMON_FIELD_NUMBER = 3;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int NAME_FIELD_NUMBER = 2;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public DayActiveUserProtos.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new DayActiveUserProtos.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TIME_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private long clientTime_;
    
    private CommonProtos.Common common_;
    
    private byte memoizedIsInitialized = -1;
    
    private int name_;
    
    private long time_;
    
    private Request() {
      this.name_ = 0;
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
                  if (i != 26) {
                    if (i != 32) {
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
                this.name_ = param1CodedInputStream.readEnum();
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
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
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
      return (getTime() != param1Object.getTime()) ? false : ((this.name_ != ((Request)param1Object).name_) ? false : ((hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getClientTime() != param1Object.getClientTime()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields))))));
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
    
    public DayActiveUserProtos.NAME getName() {
      DayActiveUserProtos.NAME nAME2 = DayActiveUserProtos.NAME.valueOf(this.name_);
      DayActiveUserProtos.NAME nAME1 = nAME2;
      if (nAME2 == null)
        nAME1 = DayActiveUserProtos.NAME.UNRECOGNIZED; 
      return nAME1;
    }
    
    public int getNameValue() {
      return this.name_;
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
      if (this.name_ != DayActiveUserProtos.NAME.UNKNOWN.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.name_); 
      j = i;
      if (this.common_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getCommon()); 
      l = this.clientTime_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(4, l); 
      i += this.unknownFields.getSerializedSize();
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
      int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getTime())) * 37 + 2) * 53 + this.name_;
      int i = j;
      if (hasCommon())
        i = (j * 37 + 3) * 53 + getCommon().hashCode(); 
      i = ((i * 37 + 4) * 53 + Internal.hashLong(getClientTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      if (this.name_ != DayActiveUserProtos.NAME.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(2, this.name_); 
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getCommon()); 
      l = this.clientTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DayActiveUserProtos.RequestOrBuilder {
      private long clientTime_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private int name_ = 0;
      
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
        return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        DayActiveUserProtos.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public DayActiveUserProtos.Request build() {
        DayActiveUserProtos.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public DayActiveUserProtos.Request buildPartial() {
        DayActiveUserProtos.Request request = new DayActiveUserProtos.Request(this);
        DayActiveUserProtos.Request.access$602(request, this.time_);
        DayActiveUserProtos.Request.access$702(request, this.name_);
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          DayActiveUserProtos.Request.access$802(request, this.common_);
        } else {
          DayActiveUserProtos.Request.access$802(request, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        DayActiveUserProtos.Request.access$902(request, this.clientTime_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        this.time_ = 0L;
        this.name_ = 0;
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
      
      public Builder clearName() {
        this.name_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
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
      
      public DayActiveUserProtos.Request getDefaultInstanceForType() {
        return DayActiveUserProtos.Request.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
      }
      
      public DayActiveUserProtos.NAME getName() {
        DayActiveUserProtos.NAME nAME2 = DayActiveUserProtos.NAME.valueOf(this.name_);
        DayActiveUserProtos.NAME nAME1 = nAME2;
        if (nAME2 == null)
          nAME1 = DayActiveUserProtos.NAME.UNRECOGNIZED; 
        return nAME1;
      }
      
      public int getNameValue() {
        return this.name_;
      }
      
      public long getTime() {
        return this.time_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(DayActiveUserProtos.Request.class, Builder.class);
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
      
      public Builder mergeFrom(DayActiveUserProtos.Request param2Request) {
        if (param2Request == DayActiveUserProtos.Request.getDefaultInstance())
          return this; 
        if (param2Request.getTime() != 0L)
          setTime(param2Request.getTime()); 
        if (param2Request.name_ != 0)
          setNameValue(param2Request.getNameValue()); 
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
          DayActiveUserProtos.Request request = (DayActiveUserProtos.Request)DayActiveUserProtos.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          DayActiveUserProtos.Request request = (DayActiveUserProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((DayActiveUserProtos.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof DayActiveUserProtos.Request)
          return mergeFrom((DayActiveUserProtos.Request)param2Message); 
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
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setName(DayActiveUserProtos.NAME param2NAME) {
        if (param2NAME != null) {
          this.name_ = param2NAME.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameValue(int param2Int) {
        this.name_ = param2Int;
        onChanged();
        return this;
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
    public DayActiveUserProtos.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new DayActiveUserProtos.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private long clientTime_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private int name_ = 0;
    
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
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      DayActiveUserProtos.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public DayActiveUserProtos.Request build() {
      DayActiveUserProtos.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public DayActiveUserProtos.Request buildPartial() {
      DayActiveUserProtos.Request request = new DayActiveUserProtos.Request(this);
      DayActiveUserProtos.Request.access$602(request, this.time_);
      DayActiveUserProtos.Request.access$702(request, this.name_);
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        DayActiveUserProtos.Request.access$802(request, this.common_);
      } else {
        DayActiveUserProtos.Request.access$802(request, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      DayActiveUserProtos.Request.access$902(request, this.clientTime_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      this.time_ = 0L;
      this.name_ = 0;
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
    
    public Builder clearName() {
      this.name_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
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
    
    public DayActiveUserProtos.Request getDefaultInstanceForType() {
      return DayActiveUserProtos.Request.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
    }
    
    public DayActiveUserProtos.NAME getName() {
      DayActiveUserProtos.NAME nAME2 = DayActiveUserProtos.NAME.valueOf(this.name_);
      DayActiveUserProtos.NAME nAME1 = nAME2;
      if (nAME2 == null)
        nAME1 = DayActiveUserProtos.NAME.UNRECOGNIZED; 
      return nAME1;
    }
    
    public int getNameValue() {
      return this.name_;
    }
    
    public long getTime() {
      return this.time_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(DayActiveUserProtos.Request.class, Builder.class);
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
    
    public Builder mergeFrom(DayActiveUserProtos.Request param1Request) {
      if (param1Request == DayActiveUserProtos.Request.getDefaultInstance())
        return this; 
      if (param1Request.getTime() != 0L)
        setTime(param1Request.getTime()); 
      if (param1Request.name_ != 0)
        setNameValue(param1Request.getNameValue()); 
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
        DayActiveUserProtos.Request request = (DayActiveUserProtos.Request)DayActiveUserProtos.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        DayActiveUserProtos.Request request = (DayActiveUserProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((DayActiveUserProtos.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof DayActiveUserProtos.Request)
        return mergeFrom((DayActiveUserProtos.Request)param1Message); 
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
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setName(DayActiveUserProtos.NAME param1NAME) {
      if (param1NAME != null) {
        this.name_ = param1NAME.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameValue(int param1Int) {
      this.name_ = param1Int;
      onChanged();
      return this;
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
    
    DayActiveUserProtos.NAME getName();
    
    int getNameValue();
    
    long getTime();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public DayActiveUserProtos.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new DayActiveUserProtos.Response(param2CodedInputStream, param2ExtensionRegistryLite);
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
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
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
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DayActiveUserProtos.ResponseOrBuilder {
      private int code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        DayActiveUserProtos.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public DayActiveUserProtos.Response build() {
        DayActiveUserProtos.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public DayActiveUserProtos.Response buildPartial() {
        DayActiveUserProtos.Response response = new DayActiveUserProtos.Response(this);
        DayActiveUserProtos.Response.access$1902(response, this.code_);
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
      
      public DayActiveUserProtos.Response getDefaultInstanceForType() {
        return DayActiveUserProtos.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(DayActiveUserProtos.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(DayActiveUserProtos.Response param2Response) {
        if (param2Response == DayActiveUserProtos.Response.getDefaultInstance())
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
          DayActiveUserProtos.Response response = (DayActiveUserProtos.Response)DayActiveUserProtos.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          DayActiveUserProtos.Response response = (DayActiveUserProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((DayActiveUserProtos.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof DayActiveUserProtos.Response)
          return mergeFrom((DayActiveUserProtos.Response)param2Message); 
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
    public DayActiveUserProtos.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new DayActiveUserProtos.Response(param1CodedInputStream, param1ExtensionRegistryLite);
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
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      DayActiveUserProtos.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public DayActiveUserProtos.Response build() {
      DayActiveUserProtos.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public DayActiveUserProtos.Response buildPartial() {
      DayActiveUserProtos.Response response = new DayActiveUserProtos.Response(this);
      DayActiveUserProtos.Response.access$1902(response, this.code_);
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
    
    public DayActiveUserProtos.Response getDefaultInstanceForType() {
      return DayActiveUserProtos.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(DayActiveUserProtos.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(DayActiveUserProtos.Response param1Response) {
      if (param1Response == DayActiveUserProtos.Response.getDefaultInstance())
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
        DayActiveUserProtos.Response response = (DayActiveUserProtos.Response)DayActiveUserProtos.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        DayActiveUserProtos.Response response = (DayActiveUserProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((DayActiveUserProtos.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof DayActiveUserProtos.Response)
        return mergeFrom((DayActiveUserProtos.Response)param1Message); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\dau\DayActiveUserProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
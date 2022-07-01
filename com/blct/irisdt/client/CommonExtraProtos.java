package com.blct.irisdt.client;

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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CommonExtraProtos {
  private static final Descriptors.Descriptor a;
  
  private static final GeneratedMessageV3.FieldAccessorTable b;
  
  private static Descriptors.FileDescriptor c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\027CommonExtraProtos.proto\022\026com.blct.irisdt.client\"6\n\020CommonExtraProto\022\020\n\bvip_type\030\001 \001(\t\022\020\n\bapp_type\030\002 \001(\tB\017¢\002\fCOMMON_EXTRAb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  static {
    a = a().getMessageTypes().get(0);
    b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "VipType", "AppType" });
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  public static final class CommonExtraProto extends GeneratedMessageV3 implements CommonExtraProtoOrBuilder {
    public static final int APP_TYPE_FIELD_NUMBER = 2;
    
    private static final CommonExtraProto DEFAULT_INSTANCE = new CommonExtraProto();
    
    private static final Parser<CommonExtraProto> PARSER = (Parser<CommonExtraProto>)new AbstractParser<CommonExtraProto>() {
        public CommonExtraProtos.CommonExtraProto a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CommonExtraProtos.CommonExtraProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int VIP_TYPE_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object appType_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object vipType_;
    
    private CommonExtraProto() {
      this.vipType_ = "";
      this.appType_ = "";
    }
    
    private CommonExtraProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.appType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.vipType_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private CommonExtraProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static CommonExtraProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommonExtraProtos.b();
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CommonExtraProto param1CommonExtraProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1CommonExtraProto);
    }
    
    public static CommonExtraProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CommonExtraProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static CommonExtraProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CommonExtraProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CommonExtraProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CommonExtraProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static CommonExtraProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CommonExtraProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CommonExtraProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CommonExtraProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static CommonExtraProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CommonExtraProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CommonExtraProto parseFrom(InputStream param1InputStream) throws IOException {
      return (CommonExtraProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static CommonExtraProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CommonExtraProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CommonExtraProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (CommonExtraProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static CommonExtraProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CommonExtraProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static CommonExtraProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CommonExtraProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static CommonExtraProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CommonExtraProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CommonExtraProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof CommonExtraProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getVipType().equals(param1Object.getVipType()) ? false : (!getAppType().equals(param1Object.getAppType()) ? false : (!!this.unknownFields.equals(((CommonExtraProto)param1Object).unknownFields)));
    }
    
    public String getAppType() {
      Object object = this.appType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.appType_ = object;
      return (String)object;
    }
    
    public ByteString getAppTypeBytes() {
      Object object = this.appType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.appType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public CommonExtraProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<CommonExtraProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!getVipTypeBytes().isEmpty())
        i = 0 + GeneratedMessageV3.computeStringSize(1, this.vipType_); 
      int j = i;
      if (!getAppTypeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.appType_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public String getVipType() {
      Object object = this.vipType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.vipType_ = object;
      return (String)object;
    }
    
    public ByteString getVipTypeBytes() {
      Object object = this.vipType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.vipType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getVipType().hashCode()) * 37 + 2) * 53 + getAppType().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommonExtraProtos.c().ensureFieldAccessorsInitialized(CommonExtraProto.class, Builder.class);
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
      return new CommonExtraProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getVipTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.vipType_); 
      if (!getAppTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.appType_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonExtraProtos.CommonExtraProtoOrBuilder {
      private Object appType_ = "";
      
      private Object vipType_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return CommonExtraProtos.b();
      }
      
      private void maybeForceBuilderInitialization() {
        CommonExtraProtos.CommonExtraProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public CommonExtraProtos.CommonExtraProto build() {
        CommonExtraProtos.CommonExtraProto commonExtraProto = buildPartial();
        if (commonExtraProto.isInitialized())
          return commonExtraProto; 
        throw newUninitializedMessageException(commonExtraProto);
      }
      
      public CommonExtraProtos.CommonExtraProto buildPartial() {
        CommonExtraProtos.CommonExtraProto commonExtraProto = new CommonExtraProtos.CommonExtraProto(this);
        CommonExtraProtos.CommonExtraProto.access$602(commonExtraProto, this.vipType_);
        CommonExtraProtos.CommonExtraProto.access$702(commonExtraProto, this.appType_);
        onBuilt();
        return commonExtraProto;
      }
      
      public Builder clear() {
        super.clear();
        this.vipType_ = "";
        this.appType_ = "";
        return this;
      }
      
      public Builder clearAppType() {
        this.appType_ = CommonExtraProtos.CommonExtraProto.getDefaultInstance().getAppType();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearVipType() {
        this.vipType_ = CommonExtraProtos.CommonExtraProto.getDefaultInstance().getVipType();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getAppType() {
        Object object = this.appType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.appType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getAppTypeBytes() {
        Object object = this.appType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.appType_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public CommonExtraProtos.CommonExtraProto getDefaultInstanceForType() {
        return CommonExtraProtos.CommonExtraProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CommonExtraProtos.b();
      }
      
      public String getVipType() {
        Object object = this.vipType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.vipType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getVipTypeBytes() {
        Object object = this.vipType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.vipType_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CommonExtraProtos.c().ensureFieldAccessorsInitialized(CommonExtraProtos.CommonExtraProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CommonExtraProtos.CommonExtraProto param2CommonExtraProto) {
        if (param2CommonExtraProto == CommonExtraProtos.CommonExtraProto.getDefaultInstance())
          return this; 
        if (!param2CommonExtraProto.getVipType().isEmpty()) {
          this.vipType_ = param2CommonExtraProto.vipType_;
          onChanged();
        } 
        if (!param2CommonExtraProto.getAppType().isEmpty()) {
          this.appType_ = param2CommonExtraProto.appType_;
          onChanged();
        } 
        mergeUnknownFields(param2CommonExtraProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          CommonExtraProtos.CommonExtraProto commonExtraProto = (CommonExtraProtos.CommonExtraProto)CommonExtraProtos.CommonExtraProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CommonExtraProtos.CommonExtraProto commonExtraProto = (CommonExtraProtos.CommonExtraProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CommonExtraProtos.CommonExtraProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CommonExtraProtos.CommonExtraProto)
          return mergeFrom((CommonExtraProtos.CommonExtraProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAppType(String param2String) {
        if (param2String != null) {
          this.appType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAppTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonExtraProtos.CommonExtraProto.checkByteStringIsUtf8(param2ByteString);
          this.appType_ = param2ByteString;
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
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setVipType(String param2String) {
        if (param2String != null) {
          this.vipType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setVipTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonExtraProtos.CommonExtraProto.checkByteStringIsUtf8(param2ByteString);
          this.vipType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
    }
  }
  
  static final class null extends AbstractParser<CommonExtraProto> {
    public CommonExtraProtos.CommonExtraProto a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CommonExtraProtos.CommonExtraProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<CommonExtraProto.Builder> implements CommonExtraProtoOrBuilder {
    private Object appType_ = "";
    
    private Object vipType_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommonExtraProtos.b();
    }
    
    private void maybeForceBuilderInitialization() {
      CommonExtraProtos.CommonExtraProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CommonExtraProtos.CommonExtraProto build() {
      CommonExtraProtos.CommonExtraProto commonExtraProto = buildPartial();
      if (commonExtraProto.isInitialized())
        return commonExtraProto; 
      throw newUninitializedMessageException(commonExtraProto);
    }
    
    public CommonExtraProtos.CommonExtraProto buildPartial() {
      CommonExtraProtos.CommonExtraProto commonExtraProto = new CommonExtraProtos.CommonExtraProto(this);
      CommonExtraProtos.CommonExtraProto.access$602(commonExtraProto, this.vipType_);
      CommonExtraProtos.CommonExtraProto.access$702(commonExtraProto, this.appType_);
      onBuilt();
      return commonExtraProto;
    }
    
    public Builder clear() {
      super.clear();
      this.vipType_ = "";
      this.appType_ = "";
      return this;
    }
    
    public Builder clearAppType() {
      this.appType_ = CommonExtraProtos.CommonExtraProto.getDefaultInstance().getAppType();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearVipType() {
      this.vipType_ = CommonExtraProtos.CommonExtraProto.getDefaultInstance().getVipType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAppType() {
      Object object = this.appType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.appType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAppTypeBytes() {
      Object object = this.appType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.appType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public CommonExtraProtos.CommonExtraProto getDefaultInstanceForType() {
      return CommonExtraProtos.CommonExtraProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CommonExtraProtos.b();
    }
    
    public String getVipType() {
      Object object = this.vipType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.vipType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getVipTypeBytes() {
      Object object = this.vipType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.vipType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommonExtraProtos.c().ensureFieldAccessorsInitialized(CommonExtraProtos.CommonExtraProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CommonExtraProtos.CommonExtraProto param1CommonExtraProto) {
      if (param1CommonExtraProto == CommonExtraProtos.CommonExtraProto.getDefaultInstance())
        return this; 
      if (!param1CommonExtraProto.getVipType().isEmpty()) {
        this.vipType_ = param1CommonExtraProto.vipType_;
        onChanged();
      } 
      if (!param1CommonExtraProto.getAppType().isEmpty()) {
        this.appType_ = param1CommonExtraProto.appType_;
        onChanged();
      } 
      mergeUnknownFields(param1CommonExtraProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        CommonExtraProtos.CommonExtraProto commonExtraProto = (CommonExtraProtos.CommonExtraProto)CommonExtraProtos.CommonExtraProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CommonExtraProtos.CommonExtraProto commonExtraProto = (CommonExtraProtos.CommonExtraProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CommonExtraProtos.CommonExtraProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CommonExtraProtos.CommonExtraProto)
        return mergeFrom((CommonExtraProtos.CommonExtraProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAppType(String param1String) {
      if (param1String != null) {
        this.appType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAppTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonExtraProtos.CommonExtraProto.checkByteStringIsUtf8(param1ByteString);
        this.appType_ = param1ByteString;
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
    
    public Builder setVipType(String param1String) {
      if (param1String != null) {
        this.vipType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setVipTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonExtraProtos.CommonExtraProto.checkByteStringIsUtf8(param1ByteString);
        this.vipType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  public static interface CommonExtraProtoOrBuilder extends MessageOrBuilder {
    String getAppType();
    
    ByteString getAppTypeBytes();
    
    String getVipType();
    
    ByteString getVipTypeBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blct\irisdt\client\CommonExtraProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
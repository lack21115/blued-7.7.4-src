package com.blued.im;

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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CommonOuterClass {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\fCommon.proto\022\fcom.blued.im\"¢\001\n\006Common\022\023\n\013app_version\030\001 \001(\t\022\030\n\020app_version_code\030\002 \001(\005\022\020\n\bplatform\030\003 \001(\t\022\020\n\blanguage\030\004 \001(\t\022\020\n\btimezone\030\005 \001(\t\022\022\n\nos_version\030\006 \001(\t\022\016\n\006device\030\007 \001(\t\022\017\n\007channel\030\b \001(\tB\013¢\002\bImCommonb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_Common_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_Common_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_Common_descriptor, new String[] { "AppVersion", "AppVersionCode", "Platform", "Language", "Timezone", "OsVersion", "Device", "Channel" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Common extends GeneratedMessageV3 implements CommonOrBuilder {
    public static final int APP_VERSION_CODE_FIELD_NUMBER = 2;
    
    public static final int APP_VERSION_FIELD_NUMBER = 1;
    
    public static final int CHANNEL_FIELD_NUMBER = 8;
    
    private static final Common DEFAULT_INSTANCE = new Common();
    
    public static final int DEVICE_FIELD_NUMBER = 7;
    
    public static final int LANGUAGE_FIELD_NUMBER = 4;
    
    public static final int OS_VERSION_FIELD_NUMBER = 6;
    
    private static final Parser<Common> PARSER = (Parser<Common>)new AbstractParser<Common>() {
        public CommonOuterClass.Common parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CommonOuterClass.Common(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PLATFORM_FIELD_NUMBER = 3;
    
    public static final int TIMEZONE_FIELD_NUMBER = 5;
    
    private static final long serialVersionUID = 0L;
    
    private int appVersionCode_;
    
    private volatile Object appVersion_;
    
    private volatile Object channel_;
    
    private volatile Object device_;
    
    private volatile Object language_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object osVersion_;
    
    private volatile Object platform_;
    
    private volatile Object timezone_;
    
    private Common() {
      this.appVersion_ = "";
      this.platform_ = "";
      this.language_ = "";
      this.timezone_ = "";
      this.osVersion_ = "";
      this.device_ = "";
      this.channel_ = "";
    }
    
    private Common(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 16) {
                  if (i != 26) {
                    if (i != 34) {
                      if (i != 42) {
                        if (i != 50) {
                          if (i != 58) {
                            if (i != 66) {
                              if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                                continue; 
                              continue;
                            } 
                            this.channel_ = param1CodedInputStream.readStringRequireUtf8();
                            continue;
                          } 
                          this.device_ = param1CodedInputStream.readStringRequireUtf8();
                          continue;
                        } 
                        this.osVersion_ = param1CodedInputStream.readStringRequireUtf8();
                        continue;
                      } 
                      this.timezone_ = param1CodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    this.language_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.platform_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.appVersionCode_ = param1CodedInputStream.readInt32();
                continue;
              } 
              this.appVersion_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private Common(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Common getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Common param1Common) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Common);
    }
    
    public static Common parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Common)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Common parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Common)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Common parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Common)PARSER.parseFrom(param1ByteString);
    }
    
    public static Common parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Common)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Common parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Common)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Common parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Common)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Common parseFrom(InputStream param1InputStream) throws IOException {
      return (Common)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Common parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Common)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Common parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Common)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Common parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Common)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Common parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Common)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Common parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Common)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Common> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Common))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getAppVersion().equals(param1Object.getAppVersion()) ? false : ((getAppVersionCode() != param1Object.getAppVersionCode()) ? false : (!getPlatform().equals(param1Object.getPlatform()) ? false : (!getLanguage().equals(param1Object.getLanguage()) ? false : (!getTimezone().equals(param1Object.getTimezone()) ? false : (!getOsVersion().equals(param1Object.getOsVersion()) ? false : (!getDevice().equals(param1Object.getDevice()) ? false : (!getChannel().equals(param1Object.getChannel()) ? false : (!!this.unknownFields.equals(((Common)param1Object).unknownFields)))))))));
    }
    
    public String getAppVersion() {
      Object object = this.appVersion_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.appVersion_ = object;
      return (String)object;
    }
    
    public ByteString getAppVersionBytes() {
      Object object = this.appVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.appVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getAppVersionCode() {
      return this.appVersionCode_;
    }
    
    public String getChannel() {
      Object object = this.channel_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.channel_ = object;
      return (String)object;
    }
    
    public ByteString getChannelBytes() {
      Object object = this.channel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.channel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Common getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDevice() {
      Object object = this.device_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.device_ = object;
      return (String)object;
    }
    
    public ByteString getDeviceBytes() {
      Object object = this.device_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.device_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLanguage() {
      Object object = this.language_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.language_ = object;
      return (String)object;
    }
    
    public ByteString getLanguageBytes() {
      Object object = this.language_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.language_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOsVersion() {
      Object object = this.osVersion_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.osVersion_ = object;
      return (String)object;
    }
    
    public ByteString getOsVersionBytes() {
      Object object = this.osVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.osVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<Common> getParserForType() {
      return PARSER;
    }
    
    public String getPlatform() {
      Object object = this.platform_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.platform_ = object;
      return (String)object;
    }
    
    public ByteString getPlatformBytes() {
      Object object = this.platform_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.platform_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getAppVersionBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.appVersion_); 
      int k = this.appVersionCode_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(2, k); 
      j = i;
      if (!getPlatformBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.platform_); 
      i = j;
      if (!getLanguageBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.language_); 
      j = i;
      if (!getTimezoneBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.timezone_); 
      i = j;
      if (!getOsVersionBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(6, this.osVersion_); 
      j = i;
      if (!getDeviceBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(7, this.device_); 
      i = j;
      if (!getChannelBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(8, this.channel_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getTimezone() {
      Object object = this.timezone_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.timezone_ = object;
      return (String)object;
    }
    
    public ByteString getTimezoneBytes() {
      Object object = this.timezone_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.timezone_ = object;
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
      int i = (((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getAppVersion().hashCode()) * 37 + 2) * 53 + getAppVersionCode()) * 37 + 3) * 53 + getPlatform().hashCode()) * 37 + 4) * 53 + getLanguage().hashCode()) * 37 + 5) * 53 + getTimezone().hashCode()) * 37 + 6) * 53 + getOsVersion().hashCode()) * 37 + 7) * 53 + getDevice().hashCode()) * 37 + 8) * 53 + getChannel().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommonOuterClass.internal_static_com_blued_im_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
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
      return new Common();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getAppVersionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.appVersion_); 
      int i = this.appVersionCode_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      if (!getPlatformBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.platform_); 
      if (!getLanguageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.language_); 
      if (!getTimezoneBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.timezone_); 
      if (!getOsVersionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.osVersion_); 
      if (!getDeviceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 7, this.device_); 
      if (!getChannelBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 8, this.channel_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonOuterClass.CommonOrBuilder {
      private int appVersionCode_;
      
      private Object appVersion_ = "";
      
      private Object channel_ = "";
      
      private Object device_ = "";
      
      private Object language_ = "";
      
      private Object osVersion_ = "";
      
      private Object platform_ = "";
      
      private Object timezone_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        CommonOuterClass.Common.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public CommonOuterClass.Common build() {
        CommonOuterClass.Common common = buildPartial();
        if (common.isInitialized())
          return common; 
        throw newUninitializedMessageException(common);
      }
      
      public CommonOuterClass.Common buildPartial() {
        CommonOuterClass.Common common = new CommonOuterClass.Common(this);
        CommonOuterClass.Common.access$602(common, this.appVersion_);
        CommonOuterClass.Common.access$702(common, this.appVersionCode_);
        CommonOuterClass.Common.access$802(common, this.platform_);
        CommonOuterClass.Common.access$902(common, this.language_);
        CommonOuterClass.Common.access$1002(common, this.timezone_);
        CommonOuterClass.Common.access$1102(common, this.osVersion_);
        CommonOuterClass.Common.access$1202(common, this.device_);
        CommonOuterClass.Common.access$1302(common, this.channel_);
        onBuilt();
        return common;
      }
      
      public Builder clear() {
        super.clear();
        this.appVersion_ = "";
        this.appVersionCode_ = 0;
        this.platform_ = "";
        this.language_ = "";
        this.timezone_ = "";
        this.osVersion_ = "";
        this.device_ = "";
        this.channel_ = "";
        return this;
      }
      
      public Builder clearAppVersion() {
        this.appVersion_ = CommonOuterClass.Common.getDefaultInstance().getAppVersion();
        onChanged();
        return this;
      }
      
      public Builder clearAppVersionCode() {
        this.appVersionCode_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearChannel() {
        this.channel_ = CommonOuterClass.Common.getDefaultInstance().getChannel();
        onChanged();
        return this;
      }
      
      public Builder clearDevice() {
        this.device_ = CommonOuterClass.Common.getDefaultInstance().getDevice();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearLanguage() {
        this.language_ = CommonOuterClass.Common.getDefaultInstance().getLanguage();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOsVersion() {
        this.osVersion_ = CommonOuterClass.Common.getDefaultInstance().getOsVersion();
        onChanged();
        return this;
      }
      
      public Builder clearPlatform() {
        this.platform_ = CommonOuterClass.Common.getDefaultInstance().getPlatform();
        onChanged();
        return this;
      }
      
      public Builder clearTimezone() {
        this.timezone_ = CommonOuterClass.Common.getDefaultInstance().getTimezone();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getAppVersion() {
        Object object = this.appVersion_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.appVersion_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getAppVersionBytes() {
        Object object = this.appVersion_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.appVersion_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getAppVersionCode() {
        return this.appVersionCode_;
      }
      
      public String getChannel() {
        Object object = this.channel_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.channel_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getChannelBytes() {
        Object object = this.channel_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.channel_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public CommonOuterClass.Common getDefaultInstanceForType() {
        return CommonOuterClass.Common.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
      }
      
      public String getDevice() {
        Object object = this.device_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.device_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDeviceBytes() {
        Object object = this.device_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.device_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getLanguage() {
        Object object = this.language_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.language_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLanguageBytes() {
        Object object = this.language_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.language_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getOsVersion() {
        Object object = this.osVersion_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.osVersion_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getOsVersionBytes() {
        Object object = this.osVersion_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.osVersion_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getPlatform() {
        Object object = this.platform_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.platform_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getPlatformBytes() {
        Object object = this.platform_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.platform_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getTimezone() {
        Object object = this.timezone_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.timezone_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTimezoneBytes() {
        Object object = this.timezone_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.timezone_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CommonOuterClass.internal_static_com_blued_im_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonOuterClass.Common.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CommonOuterClass.Common param2Common) {
        if (param2Common == CommonOuterClass.Common.getDefaultInstance())
          return this; 
        if (!param2Common.getAppVersion().isEmpty()) {
          this.appVersion_ = param2Common.appVersion_;
          onChanged();
        } 
        if (param2Common.getAppVersionCode() != 0)
          setAppVersionCode(param2Common.getAppVersionCode()); 
        if (!param2Common.getPlatform().isEmpty()) {
          this.platform_ = param2Common.platform_;
          onChanged();
        } 
        if (!param2Common.getLanguage().isEmpty()) {
          this.language_ = param2Common.language_;
          onChanged();
        } 
        if (!param2Common.getTimezone().isEmpty()) {
          this.timezone_ = param2Common.timezone_;
          onChanged();
        } 
        if (!param2Common.getOsVersion().isEmpty()) {
          this.osVersion_ = param2Common.osVersion_;
          onChanged();
        } 
        if (!param2Common.getDevice().isEmpty()) {
          this.device_ = param2Common.device_;
          onChanged();
        } 
        if (!param2Common.getChannel().isEmpty()) {
          this.channel_ = param2Common.channel_;
          onChanged();
        } 
        mergeUnknownFields(param2Common.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          CommonOuterClass.Common common = (CommonOuterClass.Common)CommonOuterClass.Common.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CommonOuterClass.Common common = (CommonOuterClass.Common)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CommonOuterClass.Common)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CommonOuterClass.Common)
          return mergeFrom((CommonOuterClass.Common)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAppVersion(String param2String) {
        if (param2String != null) {
          this.appVersion_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAppVersionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.appVersion_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAppVersionCode(int param2Int) {
        this.appVersionCode_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setChannel(String param2String) {
        if (param2String != null) {
          this.channel_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setChannelBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.channel_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDevice(String param2String) {
        if (param2String != null) {
          this.device_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDeviceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.device_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setLanguage(String param2String) {
        if (param2String != null) {
          this.language_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLanguageBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.language_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOsVersion(String param2String) {
        if (param2String != null) {
          this.osVersion_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOsVersionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.osVersion_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPlatform(String param2String) {
        if (param2String != null) {
          this.platform_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPlatformBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.platform_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTimezone(String param2String) {
        if (param2String != null) {
          this.timezone_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTimezoneBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonOuterClass.Common.checkByteStringIsUtf8(param2ByteString);
          this.timezone_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Common> {
    public CommonOuterClass.Common parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CommonOuterClass.Common(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Common.Builder> implements CommonOrBuilder {
    private int appVersionCode_;
    
    private Object appVersion_ = "";
    
    private Object channel_ = "";
    
    private Object device_ = "";
    
    private Object language_ = "";
    
    private Object osVersion_ = "";
    
    private Object platform_ = "";
    
    private Object timezone_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      CommonOuterClass.Common.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CommonOuterClass.Common build() {
      CommonOuterClass.Common common = buildPartial();
      if (common.isInitialized())
        return common; 
      throw newUninitializedMessageException(common);
    }
    
    public CommonOuterClass.Common buildPartial() {
      CommonOuterClass.Common common = new CommonOuterClass.Common(this);
      CommonOuterClass.Common.access$602(common, this.appVersion_);
      CommonOuterClass.Common.access$702(common, this.appVersionCode_);
      CommonOuterClass.Common.access$802(common, this.platform_);
      CommonOuterClass.Common.access$902(common, this.language_);
      CommonOuterClass.Common.access$1002(common, this.timezone_);
      CommonOuterClass.Common.access$1102(common, this.osVersion_);
      CommonOuterClass.Common.access$1202(common, this.device_);
      CommonOuterClass.Common.access$1302(common, this.channel_);
      onBuilt();
      return common;
    }
    
    public Builder clear() {
      super.clear();
      this.appVersion_ = "";
      this.appVersionCode_ = 0;
      this.platform_ = "";
      this.language_ = "";
      this.timezone_ = "";
      this.osVersion_ = "";
      this.device_ = "";
      this.channel_ = "";
      return this;
    }
    
    public Builder clearAppVersion() {
      this.appVersion_ = CommonOuterClass.Common.getDefaultInstance().getAppVersion();
      onChanged();
      return this;
    }
    
    public Builder clearAppVersionCode() {
      this.appVersionCode_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearChannel() {
      this.channel_ = CommonOuterClass.Common.getDefaultInstance().getChannel();
      onChanged();
      return this;
    }
    
    public Builder clearDevice() {
      this.device_ = CommonOuterClass.Common.getDefaultInstance().getDevice();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLanguage() {
      this.language_ = CommonOuterClass.Common.getDefaultInstance().getLanguage();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOsVersion() {
      this.osVersion_ = CommonOuterClass.Common.getDefaultInstance().getOsVersion();
      onChanged();
      return this;
    }
    
    public Builder clearPlatform() {
      this.platform_ = CommonOuterClass.Common.getDefaultInstance().getPlatform();
      onChanged();
      return this;
    }
    
    public Builder clearTimezone() {
      this.timezone_ = CommonOuterClass.Common.getDefaultInstance().getTimezone();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAppVersion() {
      Object object = this.appVersion_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.appVersion_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAppVersionBytes() {
      Object object = this.appVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.appVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getAppVersionCode() {
      return this.appVersionCode_;
    }
    
    public String getChannel() {
      Object object = this.channel_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.channel_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getChannelBytes() {
      Object object = this.channel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.channel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public CommonOuterClass.Common getDefaultInstanceForType() {
      return CommonOuterClass.Common.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
    }
    
    public String getDevice() {
      Object object = this.device_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.device_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDeviceBytes() {
      Object object = this.device_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.device_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLanguage() {
      Object object = this.language_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.language_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLanguageBytes() {
      Object object = this.language_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.language_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOsVersion() {
      Object object = this.osVersion_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.osVersion_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOsVersionBytes() {
      Object object = this.osVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.osVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPlatform() {
      Object object = this.platform_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.platform_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPlatformBytes() {
      Object object = this.platform_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.platform_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getTimezone() {
      Object object = this.timezone_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.timezone_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTimezoneBytes() {
      Object object = this.timezone_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.timezone_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommonOuterClass.internal_static_com_blued_im_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonOuterClass.Common.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CommonOuterClass.Common param1Common) {
      if (param1Common == CommonOuterClass.Common.getDefaultInstance())
        return this; 
      if (!param1Common.getAppVersion().isEmpty()) {
        this.appVersion_ = param1Common.appVersion_;
        onChanged();
      } 
      if (param1Common.getAppVersionCode() != 0)
        setAppVersionCode(param1Common.getAppVersionCode()); 
      if (!param1Common.getPlatform().isEmpty()) {
        this.platform_ = param1Common.platform_;
        onChanged();
      } 
      if (!param1Common.getLanguage().isEmpty()) {
        this.language_ = param1Common.language_;
        onChanged();
      } 
      if (!param1Common.getTimezone().isEmpty()) {
        this.timezone_ = param1Common.timezone_;
        onChanged();
      } 
      if (!param1Common.getOsVersion().isEmpty()) {
        this.osVersion_ = param1Common.osVersion_;
        onChanged();
      } 
      if (!param1Common.getDevice().isEmpty()) {
        this.device_ = param1Common.device_;
        onChanged();
      } 
      if (!param1Common.getChannel().isEmpty()) {
        this.channel_ = param1Common.channel_;
        onChanged();
      } 
      mergeUnknownFields(param1Common.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        CommonOuterClass.Common common = (CommonOuterClass.Common)CommonOuterClass.Common.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CommonOuterClass.Common common = (CommonOuterClass.Common)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CommonOuterClass.Common)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CommonOuterClass.Common)
        return mergeFrom((CommonOuterClass.Common)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAppVersion(String param1String) {
      if (param1String != null) {
        this.appVersion_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAppVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.appVersion_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAppVersionCode(int param1Int) {
      this.appVersionCode_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setChannel(String param1String) {
      if (param1String != null) {
        this.channel_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setChannelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.channel_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDevice(String param1String) {
      if (param1String != null) {
        this.device_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDeviceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.device_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLanguage(String param1String) {
      if (param1String != null) {
        this.language_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLanguageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.language_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOsVersion(String param1String) {
      if (param1String != null) {
        this.osVersion_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOsVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.osVersion_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPlatform(String param1String) {
      if (param1String != null) {
        this.platform_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPlatformBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.platform_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTimezone(String param1String) {
      if (param1String != null) {
        this.timezone_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTimezoneBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonOuterClass.Common.checkByteStringIsUtf8(param1ByteString);
        this.timezone_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface CommonOrBuilder extends MessageOrBuilder {
    String getAppVersion();
    
    ByteString getAppVersionBytes();
    
    int getAppVersionCode();
    
    String getChannel();
    
    ByteString getChannelBytes();
    
    String getDevice();
    
    ByteString getDeviceBytes();
    
    String getLanguage();
    
    ByteString getLanguageBytes();
    
    String getOsVersion();
    
    ByteString getOsVersionBytes();
    
    String getPlatform();
    
    ByteString getPlatformBytes();
    
    String getTimezone();
    
    ByteString getTimezoneBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\CommonOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
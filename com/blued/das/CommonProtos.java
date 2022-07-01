package com.blued.das;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CommonProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\022CommonProtos.proto\022\rcom.blued.das\"é\003\n\006Common\022\016\n\006net_op\030\001 \001(\t\022\013\n\003net\030\002 \001(\t\022\013\n\003lat\030\003 \001(\t\022\013\n\003lon\030\004 \001(\t\022\017\n\007channel\030\005 \001(\t\022\013\n\003uid\030\006 \001(\003\022\020\n\bplatform\030\007 \001(\t\022\023\n\013app_version\030\b \001(\t\022\024\n\fscreen_width\030\t \001(\005\022\023\n\013screen_high\030\n \001(\005\022\022\n\nos_version\030\013 \001(\t\022\016\n\006device\030\f \001(\t\022\021\n\tclient_ip\030\r \001(\t\022\f\n\004imei\030\016 \001(\t\022\f\n\004idfa\030\017 \001(\t\022\f\n\004smid\030\020 \001(\t\022\017\n\007dev_dna\030\021 \001(\t\022\020\n\btimezone\030\022 \001(\t\022\022\n\nrequest_id\030\023 \001(\t\022\021\n\tserver_ip\030\024 \001(\t\022\017\n\007uid_str\030\025 \001(\t\022\020\n\blanguage\030\026 \001(\t\022\016\n\006region\030\027 \001(\t\022\f\n\004idfv\030\030 \001(\t\022\020\n\bvip_type\030\031 \001(\t\022\030\n\020app_version_code\030\032 \001(\005\022\020\n\bapp_type\030\033 \001(\t\022\016\n\006box_id\030\034 \001(\tB\t¢\002\006Commonb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_Common_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_Common_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_Common_descriptor, new String[] { 
        "NetOp", "Net", "Lat", "Lon", "Channel", "Uid", "Platform", "AppVersion", "ScreenWidth", "ScreenHigh", 
        "OsVersion", "Device", "ClientIp", "Imei", "Idfa", "Smid", "DevDna", "Timezone", "RequestId", "ServerIp", 
        "UidStr", "Language", "Region", "Idfv", "VipType", "AppVersionCode", "AppType", "BoxId" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Common extends GeneratedMessageV3 implements CommonOrBuilder {
    public static final int APP_TYPE_FIELD_NUMBER = 27;
    
    public static final int APP_VERSION_CODE_FIELD_NUMBER = 26;
    
    public static final int APP_VERSION_FIELD_NUMBER = 8;
    
    public static final int BOX_ID_FIELD_NUMBER = 28;
    
    public static final int CHANNEL_FIELD_NUMBER = 5;
    
    public static final int CLIENT_IP_FIELD_NUMBER = 13;
    
    private static final Common DEFAULT_INSTANCE = new Common();
    
    public static final int DEVICE_FIELD_NUMBER = 12;
    
    public static final int DEV_DNA_FIELD_NUMBER = 17;
    
    public static final int IDFA_FIELD_NUMBER = 15;
    
    public static final int IDFV_FIELD_NUMBER = 24;
    
    public static final int IMEI_FIELD_NUMBER = 14;
    
    public static final int LANGUAGE_FIELD_NUMBER = 22;
    
    public static final int LAT_FIELD_NUMBER = 3;
    
    public static final int LON_FIELD_NUMBER = 4;
    
    public static final int NET_FIELD_NUMBER = 2;
    
    public static final int NET_OP_FIELD_NUMBER = 1;
    
    public static final int OS_VERSION_FIELD_NUMBER = 11;
    
    private static final Parser<Common> PARSER = (Parser<Common>)new AbstractParser<Common>() {
        public CommonProtos.Common parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CommonProtos.Common(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PLATFORM_FIELD_NUMBER = 7;
    
    public static final int REGION_FIELD_NUMBER = 23;
    
    public static final int REQUEST_ID_FIELD_NUMBER = 19;
    
    public static final int SCREEN_HIGH_FIELD_NUMBER = 10;
    
    public static final int SCREEN_WIDTH_FIELD_NUMBER = 9;
    
    public static final int SERVER_IP_FIELD_NUMBER = 20;
    
    public static final int SMID_FIELD_NUMBER = 16;
    
    public static final int TIMEZONE_FIELD_NUMBER = 18;
    
    public static final int UID_FIELD_NUMBER = 6;
    
    public static final int UID_STR_FIELD_NUMBER = 21;
    
    public static final int VIP_TYPE_FIELD_NUMBER = 25;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object appType_;
    
    private int appVersionCode_;
    
    private volatile Object appVersion_;
    
    private volatile Object boxId_;
    
    private volatile Object channel_;
    
    private volatile Object clientIp_;
    
    private volatile Object devDna_;
    
    private volatile Object device_;
    
    private volatile Object idfa_;
    
    private volatile Object idfv_;
    
    private volatile Object imei_;
    
    private volatile Object language_;
    
    private volatile Object lat_;
    
    private volatile Object lon_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object netOp_;
    
    private volatile Object net_;
    
    private volatile Object osVersion_;
    
    private volatile Object platform_;
    
    private volatile Object region_;
    
    private volatile Object requestId_;
    
    private int screenHigh_;
    
    private int screenWidth_;
    
    private volatile Object serverIp_;
    
    private volatile Object smid_;
    
    private volatile Object timezone_;
    
    private volatile Object uidStr_;
    
    private long uid_;
    
    private volatile Object vipType_;
    
    private Common() {
      this.netOp_ = "";
      this.net_ = "";
      this.lat_ = "";
      this.lon_ = "";
      this.channel_ = "";
      this.platform_ = "";
      this.appVersion_ = "";
      this.osVersion_ = "";
      this.device_ = "";
      this.clientIp_ = "";
      this.imei_ = "";
      this.idfa_ = "";
      this.smid_ = "";
      this.devDna_ = "";
      this.timezone_ = "";
      this.requestId_ = "";
      this.serverIp_ = "";
      this.uidStr_ = "";
      this.language_ = "";
      this.region_ = "";
      this.idfv_ = "";
      this.vipType_ = "";
      this.appType_ = "";
      this.boxId_ = "";
    }
    
    private Common(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 226:
                this.boxId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 218:
                this.appType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 208:
                this.appVersionCode_ = param1CodedInputStream.readInt32();
                continue;
              case 202:
                this.vipType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 194:
                this.idfv_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 186:
                this.region_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 178:
                this.language_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 170:
                this.uidStr_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 162:
                this.serverIp_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 154:
                this.requestId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 146:
                this.timezone_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 138:
                this.devDna_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 130:
                this.smid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 122:
                this.idfa_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 114:
                this.imei_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 106:
                this.clientIp_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 98:
                this.device_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 90:
                this.osVersion_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 80:
                this.screenHigh_ = param1CodedInputStream.readInt32();
                continue;
              case 72:
                this.screenWidth_ = param1CodedInputStream.readInt32();
                continue;
              case 66:
                this.appVersion_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 58:
                this.platform_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 48:
                this.uid_ = param1CodedInputStream.readInt64();
                continue;
              case 42:
                this.channel_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 34:
                this.lon_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 26:
                this.lat_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 18:
                this.net_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 10:
                this.netOp_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 0:
                bool = true;
                continue;
            } 
            boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
            if (!bool1);
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
      return CommonProtos.internal_static_com_blued_das_Common_descriptor;
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
      return !getNetOp().equals(param1Object.getNetOp()) ? false : (!getNet().equals(param1Object.getNet()) ? false : (!getLat().equals(param1Object.getLat()) ? false : (!getLon().equals(param1Object.getLon()) ? false : (!getChannel().equals(param1Object.getChannel()) ? false : ((getUid() != param1Object.getUid()) ? false : (!getPlatform().equals(param1Object.getPlatform()) ? false : (!getAppVersion().equals(param1Object.getAppVersion()) ? false : ((getScreenWidth() != param1Object.getScreenWidth()) ? false : ((getScreenHigh() != param1Object.getScreenHigh()) ? false : (!getOsVersion().equals(param1Object.getOsVersion()) ? false : (!getDevice().equals(param1Object.getDevice()) ? false : (!getClientIp().equals(param1Object.getClientIp()) ? false : (!getImei().equals(param1Object.getImei()) ? false : (!getIdfa().equals(param1Object.getIdfa()) ? false : (!getSmid().equals(param1Object.getSmid()) ? false : (!getDevDna().equals(param1Object.getDevDna()) ? false : (!getTimezone().equals(param1Object.getTimezone()) ? false : (!getRequestId().equals(param1Object.getRequestId()) ? false : (!getServerIp().equals(param1Object.getServerIp()) ? false : (!getUidStr().equals(param1Object.getUidStr()) ? false : (!getLanguage().equals(param1Object.getLanguage()) ? false : (!getRegion().equals(param1Object.getRegion()) ? false : (!getIdfv().equals(param1Object.getIdfv()) ? false : (!getVipType().equals(param1Object.getVipType()) ? false : ((getAppVersionCode() != param1Object.getAppVersionCode()) ? false : (!getAppType().equals(param1Object.getAppType()) ? false : (!getBoxId().equals(param1Object.getBoxId()) ? false : (!!this.unknownFields.equals(((Common)param1Object).unknownFields)))))))))))))))))))))))))))));
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
    
    public String getBoxId() {
      Object object = this.boxId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.boxId_ = object;
      return (String)object;
    }
    
    public ByteString getBoxIdBytes() {
      Object object = this.boxId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.boxId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getClientIp() {
      Object object = this.clientIp_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.clientIp_ = object;
      return (String)object;
    }
    
    public ByteString getClientIpBytes() {
      Object object = this.clientIp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.clientIp_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Common getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDevDna() {
      Object object = this.devDna_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.devDna_ = object;
      return (String)object;
    }
    
    public ByteString getDevDnaBytes() {
      Object object = this.devDna_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.devDna_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getIdfa() {
      Object object = this.idfa_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.idfa_ = object;
      return (String)object;
    }
    
    public ByteString getIdfaBytes() {
      Object object = this.idfa_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.idfa_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getIdfv() {
      Object object = this.idfv_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.idfv_ = object;
      return (String)object;
    }
    
    public ByteString getIdfvBytes() {
      Object object = this.idfv_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.idfv_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getImei() {
      Object object = this.imei_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.imei_ = object;
      return (String)object;
    }
    
    public ByteString getImeiBytes() {
      Object object = this.imei_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.imei_ = object;
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
    
    public String getLat() {
      Object object = this.lat_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.lat_ = object;
      return (String)object;
    }
    
    public ByteString getLatBytes() {
      Object object = this.lat_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.lat_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLon() {
      Object object = this.lon_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.lon_ = object;
      return (String)object;
    }
    
    public ByteString getLonBytes() {
      Object object = this.lon_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.lon_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNet() {
      Object object = this.net_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.net_ = object;
      return (String)object;
    }
    
    public ByteString getNetBytes() {
      Object object = this.net_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.net_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNetOp() {
      Object object = this.netOp_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.netOp_ = object;
      return (String)object;
    }
    
    public ByteString getNetOpBytes() {
      Object object = this.netOp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.netOp_ = object;
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
    
    public String getRegion() {
      Object object = this.region_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.region_ = object;
      return (String)object;
    }
    
    public ByteString getRegionBytes() {
      Object object = this.region_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.region_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRequestId() {
      Object object = this.requestId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.requestId_ = object;
      return (String)object;
    }
    
    public ByteString getRequestIdBytes() {
      Object object = this.requestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getScreenHigh() {
      return this.screenHigh_;
    }
    
    public int getScreenWidth() {
      return this.screenWidth_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getNetOpBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.netOp_); 
      i = j;
      if (!getNetBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.net_); 
      j = i;
      if (!getLatBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.lat_); 
      i = j;
      if (!getLonBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.lon_); 
      j = i;
      if (!getChannelBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.channel_); 
      long l = this.uid_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(6, l); 
      int k = i;
      if (!getPlatformBytes().isEmpty())
        k = i + GeneratedMessageV3.computeStringSize(7, this.platform_); 
      j = k;
      if (!getAppVersionBytes().isEmpty())
        j = k + GeneratedMessageV3.computeStringSize(8, this.appVersion_); 
      k = this.screenWidth_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(9, k); 
      k = this.screenHigh_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(10, k); 
      i = j;
      if (!getOsVersionBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(11, this.osVersion_); 
      j = i;
      if (!getDeviceBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(12, this.device_); 
      i = j;
      if (!getClientIpBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(13, this.clientIp_); 
      j = i;
      if (!getImeiBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(14, this.imei_); 
      i = j;
      if (!getIdfaBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(15, this.idfa_); 
      j = i;
      if (!getSmidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(16, this.smid_); 
      i = j;
      if (!getDevDnaBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(17, this.devDna_); 
      j = i;
      if (!getTimezoneBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(18, this.timezone_); 
      i = j;
      if (!getRequestIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(19, this.requestId_); 
      j = i;
      if (!getServerIpBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(20, this.serverIp_); 
      i = j;
      if (!getUidStrBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(21, this.uidStr_); 
      j = i;
      if (!getLanguageBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(22, this.language_); 
      i = j;
      if (!getRegionBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(23, this.region_); 
      j = i;
      if (!getIdfvBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(24, this.idfv_); 
      i = j;
      if (!getVipTypeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(25, this.vipType_); 
      k = this.appVersionCode_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(26, k); 
      i = j;
      if (!getAppTypeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(27, this.appType_); 
      j = i;
      if (!getBoxIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(28, this.boxId_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getServerIp() {
      Object object = this.serverIp_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.serverIp_ = object;
      return (String)object;
    }
    
    public ByteString getServerIpBytes() {
      Object object = this.serverIp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.serverIp_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getSmid() {
      Object object = this.smid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.smid_ = object;
      return (String)object;
    }
    
    public ByteString getSmidBytes() {
      Object object = this.smid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.smid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public long getUid() {
      return this.uid_;
    }
    
    public String getUidStr() {
      Object object = this.uidStr_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.uidStr_ = object;
      return (String)object;
    }
    
    public ByteString getUidStrBytes() {
      Object object = this.uidStr_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.uidStr_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getNetOp().hashCode()) * 37 + 2) * 53 + getNet().hashCode()) * 37 + 3) * 53 + getLat().hashCode()) * 37 + 4) * 53 + getLon().hashCode()) * 37 + 5) * 53 + getChannel().hashCode()) * 37 + 6) * 53 + Internal.hashLong(getUid())) * 37 + 7) * 53 + getPlatform().hashCode()) * 37 + 8) * 53 + getAppVersion().hashCode()) * 37 + 9) * 53 + getScreenWidth()) * 37 + 10) * 53 + getScreenHigh()) * 37 + 11) * 53 + getOsVersion().hashCode()) * 37 + 12) * 53 + getDevice().hashCode()) * 37 + 13) * 53 + getClientIp().hashCode()) * 37 + 14) * 53 + getImei().hashCode()) * 37 + 15) * 53 + getIdfa().hashCode()) * 37 + 16) * 53 + getSmid().hashCode()) * 37 + 17) * 53 + getDevDna().hashCode()) * 37 + 18) * 53 + getTimezone().hashCode()) * 37 + 19) * 53 + getRequestId().hashCode()) * 37 + 20) * 53 + getServerIp().hashCode()) * 37 + 21) * 53 + getUidStr().hashCode()) * 37 + 22) * 53 + getLanguage().hashCode()) * 37 + 23) * 53 + getRegion().hashCode()) * 37 + 24) * 53 + getIdfv().hashCode()) * 37 + 25) * 53 + getVipType().hashCode()) * 37 + 26) * 53 + getAppVersionCode()) * 37 + 27) * 53 + getAppType().hashCode()) * 37 + 28) * 53 + getBoxId().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommonProtos.internal_static_com_blued_das_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
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
      if (!getNetOpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.netOp_); 
      if (!getNetBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.net_); 
      if (!getLatBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.lat_); 
      if (!getLonBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.lon_); 
      if (!getChannelBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.channel_); 
      long l = this.uid_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(6, l); 
      if (!getPlatformBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 7, this.platform_); 
      if (!getAppVersionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 8, this.appVersion_); 
      int i = this.screenWidth_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(9, i); 
      i = this.screenHigh_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(10, i); 
      if (!getOsVersionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 11, this.osVersion_); 
      if (!getDeviceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 12, this.device_); 
      if (!getClientIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 13, this.clientIp_); 
      if (!getImeiBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 14, this.imei_); 
      if (!getIdfaBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 15, this.idfa_); 
      if (!getSmidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 16, this.smid_); 
      if (!getDevDnaBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 17, this.devDna_); 
      if (!getTimezoneBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 18, this.timezone_); 
      if (!getRequestIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 19, this.requestId_); 
      if (!getServerIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 20, this.serverIp_); 
      if (!getUidStrBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 21, this.uidStr_); 
      if (!getLanguageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 22, this.language_); 
      if (!getRegionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 23, this.region_); 
      if (!getIdfvBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 24, this.idfv_); 
      if (!getVipTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 25, this.vipType_); 
      i = this.appVersionCode_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(26, i); 
      if (!getAppTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 27, this.appType_); 
      if (!getBoxIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 28, this.boxId_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonProtos.CommonOrBuilder {
      private Object appType_ = "";
      
      private int appVersionCode_;
      
      private Object appVersion_ = "";
      
      private Object boxId_ = "";
      
      private Object channel_ = "";
      
      private Object clientIp_ = "";
      
      private Object devDna_ = "";
      
      private Object device_ = "";
      
      private Object idfa_ = "";
      
      private Object idfv_ = "";
      
      private Object imei_ = "";
      
      private Object language_ = "";
      
      private Object lat_ = "";
      
      private Object lon_ = "";
      
      private Object netOp_ = "";
      
      private Object net_ = "";
      
      private Object osVersion_ = "";
      
      private Object platform_ = "";
      
      private Object region_ = "";
      
      private Object requestId_ = "";
      
      private int screenHigh_;
      
      private int screenWidth_;
      
      private Object serverIp_ = "";
      
      private Object smid_ = "";
      
      private Object timezone_ = "";
      
      private Object uidStr_ = "";
      
      private long uid_;
      
      private Object vipType_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return CommonProtos.internal_static_com_blued_das_Common_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        CommonProtos.Common.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public CommonProtos.Common build() {
        CommonProtos.Common common = buildPartial();
        if (common.isInitialized())
          return common; 
        throw newUninitializedMessageException(common);
      }
      
      public CommonProtos.Common buildPartial() {
        CommonProtos.Common common = new CommonProtos.Common(this);
        CommonProtos.Common.access$602(common, this.netOp_);
        CommonProtos.Common.access$702(common, this.net_);
        CommonProtos.Common.access$802(common, this.lat_);
        CommonProtos.Common.access$902(common, this.lon_);
        CommonProtos.Common.access$1002(common, this.channel_);
        CommonProtos.Common.access$1102(common, this.uid_);
        CommonProtos.Common.access$1202(common, this.platform_);
        CommonProtos.Common.access$1302(common, this.appVersion_);
        CommonProtos.Common.access$1402(common, this.screenWidth_);
        CommonProtos.Common.access$1502(common, this.screenHigh_);
        CommonProtos.Common.access$1602(common, this.osVersion_);
        CommonProtos.Common.access$1702(common, this.device_);
        CommonProtos.Common.access$1802(common, this.clientIp_);
        CommonProtos.Common.access$1902(common, this.imei_);
        CommonProtos.Common.access$2002(common, this.idfa_);
        CommonProtos.Common.access$2102(common, this.smid_);
        CommonProtos.Common.access$2202(common, this.devDna_);
        CommonProtos.Common.access$2302(common, this.timezone_);
        CommonProtos.Common.access$2402(common, this.requestId_);
        CommonProtos.Common.access$2502(common, this.serverIp_);
        CommonProtos.Common.access$2602(common, this.uidStr_);
        CommonProtos.Common.access$2702(common, this.language_);
        CommonProtos.Common.access$2802(common, this.region_);
        CommonProtos.Common.access$2902(common, this.idfv_);
        CommonProtos.Common.access$3002(common, this.vipType_);
        CommonProtos.Common.access$3102(common, this.appVersionCode_);
        CommonProtos.Common.access$3202(common, this.appType_);
        CommonProtos.Common.access$3302(common, this.boxId_);
        onBuilt();
        return common;
      }
      
      public Builder clear() {
        super.clear();
        this.netOp_ = "";
        this.net_ = "";
        this.lat_ = "";
        this.lon_ = "";
        this.channel_ = "";
        this.uid_ = 0L;
        this.platform_ = "";
        this.appVersion_ = "";
        this.screenWidth_ = 0;
        this.screenHigh_ = 0;
        this.osVersion_ = "";
        this.device_ = "";
        this.clientIp_ = "";
        this.imei_ = "";
        this.idfa_ = "";
        this.smid_ = "";
        this.devDna_ = "";
        this.timezone_ = "";
        this.requestId_ = "";
        this.serverIp_ = "";
        this.uidStr_ = "";
        this.language_ = "";
        this.region_ = "";
        this.idfv_ = "";
        this.vipType_ = "";
        this.appVersionCode_ = 0;
        this.appType_ = "";
        this.boxId_ = "";
        return this;
      }
      
      public Builder clearAppType() {
        this.appType_ = CommonProtos.Common.getDefaultInstance().getAppType();
        onChanged();
        return this;
      }
      
      public Builder clearAppVersion() {
        this.appVersion_ = CommonProtos.Common.getDefaultInstance().getAppVersion();
        onChanged();
        return this;
      }
      
      public Builder clearAppVersionCode() {
        this.appVersionCode_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearBoxId() {
        this.boxId_ = CommonProtos.Common.getDefaultInstance().getBoxId();
        onChanged();
        return this;
      }
      
      public Builder clearChannel() {
        this.channel_ = CommonProtos.Common.getDefaultInstance().getChannel();
        onChanged();
        return this;
      }
      
      public Builder clearClientIp() {
        this.clientIp_ = CommonProtos.Common.getDefaultInstance().getClientIp();
        onChanged();
        return this;
      }
      
      public Builder clearDevDna() {
        this.devDna_ = CommonProtos.Common.getDefaultInstance().getDevDna();
        onChanged();
        return this;
      }
      
      public Builder clearDevice() {
        this.device_ = CommonProtos.Common.getDefaultInstance().getDevice();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearIdfa() {
        this.idfa_ = CommonProtos.Common.getDefaultInstance().getIdfa();
        onChanged();
        return this;
      }
      
      public Builder clearIdfv() {
        this.idfv_ = CommonProtos.Common.getDefaultInstance().getIdfv();
        onChanged();
        return this;
      }
      
      public Builder clearImei() {
        this.imei_ = CommonProtos.Common.getDefaultInstance().getImei();
        onChanged();
        return this;
      }
      
      public Builder clearLanguage() {
        this.language_ = CommonProtos.Common.getDefaultInstance().getLanguage();
        onChanged();
        return this;
      }
      
      public Builder clearLat() {
        this.lat_ = CommonProtos.Common.getDefaultInstance().getLat();
        onChanged();
        return this;
      }
      
      public Builder clearLon() {
        this.lon_ = CommonProtos.Common.getDefaultInstance().getLon();
        onChanged();
        return this;
      }
      
      public Builder clearNet() {
        this.net_ = CommonProtos.Common.getDefaultInstance().getNet();
        onChanged();
        return this;
      }
      
      public Builder clearNetOp() {
        this.netOp_ = CommonProtos.Common.getDefaultInstance().getNetOp();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOsVersion() {
        this.osVersion_ = CommonProtos.Common.getDefaultInstance().getOsVersion();
        onChanged();
        return this;
      }
      
      public Builder clearPlatform() {
        this.platform_ = CommonProtos.Common.getDefaultInstance().getPlatform();
        onChanged();
        return this;
      }
      
      public Builder clearRegion() {
        this.region_ = CommonProtos.Common.getDefaultInstance().getRegion();
        onChanged();
        return this;
      }
      
      public Builder clearRequestId() {
        this.requestId_ = CommonProtos.Common.getDefaultInstance().getRequestId();
        onChanged();
        return this;
      }
      
      public Builder clearScreenHigh() {
        this.screenHigh_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearScreenWidth() {
        this.screenWidth_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearServerIp() {
        this.serverIp_ = CommonProtos.Common.getDefaultInstance().getServerIp();
        onChanged();
        return this;
      }
      
      public Builder clearSmid() {
        this.smid_ = CommonProtos.Common.getDefaultInstance().getSmid();
        onChanged();
        return this;
      }
      
      public Builder clearTimezone() {
        this.timezone_ = CommonProtos.Common.getDefaultInstance().getTimezone();
        onChanged();
        return this;
      }
      
      public Builder clearUid() {
        this.uid_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearUidStr() {
        this.uidStr_ = CommonProtos.Common.getDefaultInstance().getUidStr();
        onChanged();
        return this;
      }
      
      public Builder clearVipType() {
        this.vipType_ = CommonProtos.Common.getDefaultInstance().getVipType();
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
      
      public String getBoxId() {
        Object object = this.boxId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.boxId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getBoxIdBytes() {
        Object object = this.boxId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.boxId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public String getClientIp() {
        Object object = this.clientIp_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.clientIp_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getClientIpBytes() {
        Object object = this.clientIp_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.clientIp_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public CommonProtos.Common getDefaultInstanceForType() {
        return CommonProtos.Common.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CommonProtos.internal_static_com_blued_das_Common_descriptor;
      }
      
      public String getDevDna() {
        Object object = this.devDna_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.devDna_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDevDnaBytes() {
        Object object = this.devDna_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.devDna_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public String getIdfa() {
        Object object = this.idfa_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.idfa_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getIdfaBytes() {
        Object object = this.idfa_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.idfa_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getIdfv() {
        Object object = this.idfv_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.idfv_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getIdfvBytes() {
        Object object = this.idfv_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.idfv_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getImei() {
        Object object = this.imei_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.imei_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getImeiBytes() {
        Object object = this.imei_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.imei_ = object;
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
      
      public String getLat() {
        Object object = this.lat_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.lat_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLatBytes() {
        Object object = this.lat_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.lat_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getLon() {
        Object object = this.lon_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.lon_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLonBytes() {
        Object object = this.lon_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.lon_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getNet() {
        Object object = this.net_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.net_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getNetBytes() {
        Object object = this.net_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.net_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getNetOp() {
        Object object = this.netOp_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.netOp_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getNetOpBytes() {
        Object object = this.netOp_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.netOp_ = object;
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
      
      public String getRegion() {
        Object object = this.region_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.region_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRegionBytes() {
        Object object = this.region_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.region_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRequestId() {
        Object object = this.requestId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.requestId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRequestIdBytes() {
        Object object = this.requestId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.requestId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getScreenHigh() {
        return this.screenHigh_;
      }
      
      public int getScreenWidth() {
        return this.screenWidth_;
      }
      
      public String getServerIp() {
        Object object = this.serverIp_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.serverIp_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getServerIpBytes() {
        Object object = this.serverIp_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.serverIp_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getSmid() {
        Object object = this.smid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.smid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getSmidBytes() {
        Object object = this.smid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.smid_ = object;
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
      
      public long getUid() {
        return this.uid_;
      }
      
      public String getUidStr() {
        Object object = this.uidStr_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.uidStr_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getUidStrBytes() {
        Object object = this.uidStr_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.uidStr_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
        return CommonProtos.internal_static_com_blued_das_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonProtos.Common.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CommonProtos.Common param2Common) {
        if (param2Common == CommonProtos.Common.getDefaultInstance())
          return this; 
        if (!param2Common.getNetOp().isEmpty()) {
          this.netOp_ = param2Common.netOp_;
          onChanged();
        } 
        if (!param2Common.getNet().isEmpty()) {
          this.net_ = param2Common.net_;
          onChanged();
        } 
        if (!param2Common.getLat().isEmpty()) {
          this.lat_ = param2Common.lat_;
          onChanged();
        } 
        if (!param2Common.getLon().isEmpty()) {
          this.lon_ = param2Common.lon_;
          onChanged();
        } 
        if (!param2Common.getChannel().isEmpty()) {
          this.channel_ = param2Common.channel_;
          onChanged();
        } 
        if (param2Common.getUid() != 0L)
          setUid(param2Common.getUid()); 
        if (!param2Common.getPlatform().isEmpty()) {
          this.platform_ = param2Common.platform_;
          onChanged();
        } 
        if (!param2Common.getAppVersion().isEmpty()) {
          this.appVersion_ = param2Common.appVersion_;
          onChanged();
        } 
        if (param2Common.getScreenWidth() != 0)
          setScreenWidth(param2Common.getScreenWidth()); 
        if (param2Common.getScreenHigh() != 0)
          setScreenHigh(param2Common.getScreenHigh()); 
        if (!param2Common.getOsVersion().isEmpty()) {
          this.osVersion_ = param2Common.osVersion_;
          onChanged();
        } 
        if (!param2Common.getDevice().isEmpty()) {
          this.device_ = param2Common.device_;
          onChanged();
        } 
        if (!param2Common.getClientIp().isEmpty()) {
          this.clientIp_ = param2Common.clientIp_;
          onChanged();
        } 
        if (!param2Common.getImei().isEmpty()) {
          this.imei_ = param2Common.imei_;
          onChanged();
        } 
        if (!param2Common.getIdfa().isEmpty()) {
          this.idfa_ = param2Common.idfa_;
          onChanged();
        } 
        if (!param2Common.getSmid().isEmpty()) {
          this.smid_ = param2Common.smid_;
          onChanged();
        } 
        if (!param2Common.getDevDna().isEmpty()) {
          this.devDna_ = param2Common.devDna_;
          onChanged();
        } 
        if (!param2Common.getTimezone().isEmpty()) {
          this.timezone_ = param2Common.timezone_;
          onChanged();
        } 
        if (!param2Common.getRequestId().isEmpty()) {
          this.requestId_ = param2Common.requestId_;
          onChanged();
        } 
        if (!param2Common.getServerIp().isEmpty()) {
          this.serverIp_ = param2Common.serverIp_;
          onChanged();
        } 
        if (!param2Common.getUidStr().isEmpty()) {
          this.uidStr_ = param2Common.uidStr_;
          onChanged();
        } 
        if (!param2Common.getLanguage().isEmpty()) {
          this.language_ = param2Common.language_;
          onChanged();
        } 
        if (!param2Common.getRegion().isEmpty()) {
          this.region_ = param2Common.region_;
          onChanged();
        } 
        if (!param2Common.getIdfv().isEmpty()) {
          this.idfv_ = param2Common.idfv_;
          onChanged();
        } 
        if (!param2Common.getVipType().isEmpty()) {
          this.vipType_ = param2Common.vipType_;
          onChanged();
        } 
        if (param2Common.getAppVersionCode() != 0)
          setAppVersionCode(param2Common.getAppVersionCode()); 
        if (!param2Common.getAppType().isEmpty()) {
          this.appType_ = param2Common.appType_;
          onChanged();
        } 
        if (!param2Common.getBoxId().isEmpty()) {
          this.boxId_ = param2Common.boxId_;
          onChanged();
        } 
        mergeUnknownFields(param2Common.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          CommonProtos.Common common = (CommonProtos.Common)CommonProtos.Common.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CommonProtos.Common common = (CommonProtos.Common)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CommonProtos.Common)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CommonProtos.Common)
          return mergeFrom((CommonProtos.Common)param2Message); 
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.appType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
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
      
      public Builder setBoxId(String param2String) {
        if (param2String != null) {
          this.boxId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBoxIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.boxId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.channel_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setClientIp(String param2String) {
        if (param2String != null) {
          this.clientIp_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setClientIpBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.clientIp_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDevDna(String param2String) {
        if (param2String != null) {
          this.devDna_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDevDnaBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.devDna_ = param2ByteString;
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.device_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setIdfa(String param2String) {
        if (param2String != null) {
          this.idfa_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdfaBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.idfa_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdfv(String param2String) {
        if (param2String != null) {
          this.idfv_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdfvBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.idfv_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setImei(String param2String) {
        if (param2String != null) {
          this.imei_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setImeiBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.imei_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.language_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLat(String param2String) {
        if (param2String != null) {
          this.lat_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLatBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.lat_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLon(String param2String) {
        if (param2String != null) {
          this.lon_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLonBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.lon_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNet(String param2String) {
        if (param2String != null) {
          this.net_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNetBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.net_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNetOp(String param2String) {
        if (param2String != null) {
          this.netOp_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNetOpBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.netOp_ = param2ByteString;
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.platform_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRegion(String param2String) {
        if (param2String != null) {
          this.region_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRegionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.region_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setRequestId(String param2String) {
        if (param2String != null) {
          this.requestId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRequestIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.requestId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setScreenHigh(int param2Int) {
        this.screenHigh_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setScreenWidth(int param2Int) {
        this.screenWidth_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setServerIp(String param2String) {
        if (param2String != null) {
          this.serverIp_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setServerIpBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.serverIp_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSmid(String param2String) {
        if (param2String != null) {
          this.smid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSmidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.smid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.timezone_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUid(long param2Long) {
        this.uid_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setUidStr(String param2String) {
        if (param2String != null) {
          this.uidStr_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUidStrBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.uidStr_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          CommonProtos.Common.checkByteStringIsUtf8(param2ByteString);
          this.vipType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
    }
  }
  
  static final class null extends AbstractParser<Common> {
    public CommonProtos.Common parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CommonProtos.Common(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Common.Builder> implements CommonOrBuilder {
    private Object appType_ = "";
    
    private int appVersionCode_;
    
    private Object appVersion_ = "";
    
    private Object boxId_ = "";
    
    private Object channel_ = "";
    
    private Object clientIp_ = "";
    
    private Object devDna_ = "";
    
    private Object device_ = "";
    
    private Object idfa_ = "";
    
    private Object idfv_ = "";
    
    private Object imei_ = "";
    
    private Object language_ = "";
    
    private Object lat_ = "";
    
    private Object lon_ = "";
    
    private Object netOp_ = "";
    
    private Object net_ = "";
    
    private Object osVersion_ = "";
    
    private Object platform_ = "";
    
    private Object region_ = "";
    
    private Object requestId_ = "";
    
    private int screenHigh_;
    
    private int screenWidth_;
    
    private Object serverIp_ = "";
    
    private Object smid_ = "";
    
    private Object timezone_ = "";
    
    private Object uidStr_ = "";
    
    private long uid_;
    
    private Object vipType_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommonProtos.internal_static_com_blued_das_Common_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      CommonProtos.Common.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CommonProtos.Common build() {
      CommonProtos.Common common = buildPartial();
      if (common.isInitialized())
        return common; 
      throw newUninitializedMessageException(common);
    }
    
    public CommonProtos.Common buildPartial() {
      CommonProtos.Common common = new CommonProtos.Common(this);
      CommonProtos.Common.access$602(common, this.netOp_);
      CommonProtos.Common.access$702(common, this.net_);
      CommonProtos.Common.access$802(common, this.lat_);
      CommonProtos.Common.access$902(common, this.lon_);
      CommonProtos.Common.access$1002(common, this.channel_);
      CommonProtos.Common.access$1102(common, this.uid_);
      CommonProtos.Common.access$1202(common, this.platform_);
      CommonProtos.Common.access$1302(common, this.appVersion_);
      CommonProtos.Common.access$1402(common, this.screenWidth_);
      CommonProtos.Common.access$1502(common, this.screenHigh_);
      CommonProtos.Common.access$1602(common, this.osVersion_);
      CommonProtos.Common.access$1702(common, this.device_);
      CommonProtos.Common.access$1802(common, this.clientIp_);
      CommonProtos.Common.access$1902(common, this.imei_);
      CommonProtos.Common.access$2002(common, this.idfa_);
      CommonProtos.Common.access$2102(common, this.smid_);
      CommonProtos.Common.access$2202(common, this.devDna_);
      CommonProtos.Common.access$2302(common, this.timezone_);
      CommonProtos.Common.access$2402(common, this.requestId_);
      CommonProtos.Common.access$2502(common, this.serverIp_);
      CommonProtos.Common.access$2602(common, this.uidStr_);
      CommonProtos.Common.access$2702(common, this.language_);
      CommonProtos.Common.access$2802(common, this.region_);
      CommonProtos.Common.access$2902(common, this.idfv_);
      CommonProtos.Common.access$3002(common, this.vipType_);
      CommonProtos.Common.access$3102(common, this.appVersionCode_);
      CommonProtos.Common.access$3202(common, this.appType_);
      CommonProtos.Common.access$3302(common, this.boxId_);
      onBuilt();
      return common;
    }
    
    public Builder clear() {
      super.clear();
      this.netOp_ = "";
      this.net_ = "";
      this.lat_ = "";
      this.lon_ = "";
      this.channel_ = "";
      this.uid_ = 0L;
      this.platform_ = "";
      this.appVersion_ = "";
      this.screenWidth_ = 0;
      this.screenHigh_ = 0;
      this.osVersion_ = "";
      this.device_ = "";
      this.clientIp_ = "";
      this.imei_ = "";
      this.idfa_ = "";
      this.smid_ = "";
      this.devDna_ = "";
      this.timezone_ = "";
      this.requestId_ = "";
      this.serverIp_ = "";
      this.uidStr_ = "";
      this.language_ = "";
      this.region_ = "";
      this.idfv_ = "";
      this.vipType_ = "";
      this.appVersionCode_ = 0;
      this.appType_ = "";
      this.boxId_ = "";
      return this;
    }
    
    public Builder clearAppType() {
      this.appType_ = CommonProtos.Common.getDefaultInstance().getAppType();
      onChanged();
      return this;
    }
    
    public Builder clearAppVersion() {
      this.appVersion_ = CommonProtos.Common.getDefaultInstance().getAppVersion();
      onChanged();
      return this;
    }
    
    public Builder clearAppVersionCode() {
      this.appVersionCode_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearBoxId() {
      this.boxId_ = CommonProtos.Common.getDefaultInstance().getBoxId();
      onChanged();
      return this;
    }
    
    public Builder clearChannel() {
      this.channel_ = CommonProtos.Common.getDefaultInstance().getChannel();
      onChanged();
      return this;
    }
    
    public Builder clearClientIp() {
      this.clientIp_ = CommonProtos.Common.getDefaultInstance().getClientIp();
      onChanged();
      return this;
    }
    
    public Builder clearDevDna() {
      this.devDna_ = CommonProtos.Common.getDefaultInstance().getDevDna();
      onChanged();
      return this;
    }
    
    public Builder clearDevice() {
      this.device_ = CommonProtos.Common.getDefaultInstance().getDevice();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearIdfa() {
      this.idfa_ = CommonProtos.Common.getDefaultInstance().getIdfa();
      onChanged();
      return this;
    }
    
    public Builder clearIdfv() {
      this.idfv_ = CommonProtos.Common.getDefaultInstance().getIdfv();
      onChanged();
      return this;
    }
    
    public Builder clearImei() {
      this.imei_ = CommonProtos.Common.getDefaultInstance().getImei();
      onChanged();
      return this;
    }
    
    public Builder clearLanguage() {
      this.language_ = CommonProtos.Common.getDefaultInstance().getLanguage();
      onChanged();
      return this;
    }
    
    public Builder clearLat() {
      this.lat_ = CommonProtos.Common.getDefaultInstance().getLat();
      onChanged();
      return this;
    }
    
    public Builder clearLon() {
      this.lon_ = CommonProtos.Common.getDefaultInstance().getLon();
      onChanged();
      return this;
    }
    
    public Builder clearNet() {
      this.net_ = CommonProtos.Common.getDefaultInstance().getNet();
      onChanged();
      return this;
    }
    
    public Builder clearNetOp() {
      this.netOp_ = CommonProtos.Common.getDefaultInstance().getNetOp();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOsVersion() {
      this.osVersion_ = CommonProtos.Common.getDefaultInstance().getOsVersion();
      onChanged();
      return this;
    }
    
    public Builder clearPlatform() {
      this.platform_ = CommonProtos.Common.getDefaultInstance().getPlatform();
      onChanged();
      return this;
    }
    
    public Builder clearRegion() {
      this.region_ = CommonProtos.Common.getDefaultInstance().getRegion();
      onChanged();
      return this;
    }
    
    public Builder clearRequestId() {
      this.requestId_ = CommonProtos.Common.getDefaultInstance().getRequestId();
      onChanged();
      return this;
    }
    
    public Builder clearScreenHigh() {
      this.screenHigh_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearScreenWidth() {
      this.screenWidth_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = CommonProtos.Common.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clearSmid() {
      this.smid_ = CommonProtos.Common.getDefaultInstance().getSmid();
      onChanged();
      return this;
    }
    
    public Builder clearTimezone() {
      this.timezone_ = CommonProtos.Common.getDefaultInstance().getTimezone();
      onChanged();
      return this;
    }
    
    public Builder clearUid() {
      this.uid_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearUidStr() {
      this.uidStr_ = CommonProtos.Common.getDefaultInstance().getUidStr();
      onChanged();
      return this;
    }
    
    public Builder clearVipType() {
      this.vipType_ = CommonProtos.Common.getDefaultInstance().getVipType();
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
    
    public String getBoxId() {
      Object object = this.boxId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.boxId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getBoxIdBytes() {
      Object object = this.boxId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.boxId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getClientIp() {
      Object object = this.clientIp_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.clientIp_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getClientIpBytes() {
      Object object = this.clientIp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.clientIp_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public CommonProtos.Common getDefaultInstanceForType() {
      return CommonProtos.Common.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CommonProtos.internal_static_com_blued_das_Common_descriptor;
    }
    
    public String getDevDna() {
      Object object = this.devDna_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.devDna_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDevDnaBytes() {
      Object object = this.devDna_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.devDna_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getIdfa() {
      Object object = this.idfa_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.idfa_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIdfaBytes() {
      Object object = this.idfa_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.idfa_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getIdfv() {
      Object object = this.idfv_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.idfv_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIdfvBytes() {
      Object object = this.idfv_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.idfv_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getImei() {
      Object object = this.imei_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.imei_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getImeiBytes() {
      Object object = this.imei_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.imei_ = object;
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
    
    public String getLat() {
      Object object = this.lat_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.lat_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLatBytes() {
      Object object = this.lat_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.lat_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLon() {
      Object object = this.lon_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.lon_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLonBytes() {
      Object object = this.lon_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.lon_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNet() {
      Object object = this.net_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.net_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNetBytes() {
      Object object = this.net_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.net_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNetOp() {
      Object object = this.netOp_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.netOp_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNetOpBytes() {
      Object object = this.netOp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.netOp_ = object;
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
    
    public String getRegion() {
      Object object = this.region_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.region_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRegionBytes() {
      Object object = this.region_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.region_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRequestId() {
      Object object = this.requestId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.requestId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRequestIdBytes() {
      Object object = this.requestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getScreenHigh() {
      return this.screenHigh_;
    }
    
    public int getScreenWidth() {
      return this.screenWidth_;
    }
    
    public String getServerIp() {
      Object object = this.serverIp_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.serverIp_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getServerIpBytes() {
      Object object = this.serverIp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.serverIp_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getSmid() {
      Object object = this.smid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.smid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSmidBytes() {
      Object object = this.smid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.smid_ = object;
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
    
    public long getUid() {
      return this.uid_;
    }
    
    public String getUidStr() {
      Object object = this.uidStr_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.uidStr_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUidStrBytes() {
      Object object = this.uidStr_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.uidStr_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
      return CommonProtos.internal_static_com_blued_das_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonProtos.Common.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CommonProtos.Common param1Common) {
      if (param1Common == CommonProtos.Common.getDefaultInstance())
        return this; 
      if (!param1Common.getNetOp().isEmpty()) {
        this.netOp_ = param1Common.netOp_;
        onChanged();
      } 
      if (!param1Common.getNet().isEmpty()) {
        this.net_ = param1Common.net_;
        onChanged();
      } 
      if (!param1Common.getLat().isEmpty()) {
        this.lat_ = param1Common.lat_;
        onChanged();
      } 
      if (!param1Common.getLon().isEmpty()) {
        this.lon_ = param1Common.lon_;
        onChanged();
      } 
      if (!param1Common.getChannel().isEmpty()) {
        this.channel_ = param1Common.channel_;
        onChanged();
      } 
      if (param1Common.getUid() != 0L)
        setUid(param1Common.getUid()); 
      if (!param1Common.getPlatform().isEmpty()) {
        this.platform_ = param1Common.platform_;
        onChanged();
      } 
      if (!param1Common.getAppVersion().isEmpty()) {
        this.appVersion_ = param1Common.appVersion_;
        onChanged();
      } 
      if (param1Common.getScreenWidth() != 0)
        setScreenWidth(param1Common.getScreenWidth()); 
      if (param1Common.getScreenHigh() != 0)
        setScreenHigh(param1Common.getScreenHigh()); 
      if (!param1Common.getOsVersion().isEmpty()) {
        this.osVersion_ = param1Common.osVersion_;
        onChanged();
      } 
      if (!param1Common.getDevice().isEmpty()) {
        this.device_ = param1Common.device_;
        onChanged();
      } 
      if (!param1Common.getClientIp().isEmpty()) {
        this.clientIp_ = param1Common.clientIp_;
        onChanged();
      } 
      if (!param1Common.getImei().isEmpty()) {
        this.imei_ = param1Common.imei_;
        onChanged();
      } 
      if (!param1Common.getIdfa().isEmpty()) {
        this.idfa_ = param1Common.idfa_;
        onChanged();
      } 
      if (!param1Common.getSmid().isEmpty()) {
        this.smid_ = param1Common.smid_;
        onChanged();
      } 
      if (!param1Common.getDevDna().isEmpty()) {
        this.devDna_ = param1Common.devDna_;
        onChanged();
      } 
      if (!param1Common.getTimezone().isEmpty()) {
        this.timezone_ = param1Common.timezone_;
        onChanged();
      } 
      if (!param1Common.getRequestId().isEmpty()) {
        this.requestId_ = param1Common.requestId_;
        onChanged();
      } 
      if (!param1Common.getServerIp().isEmpty()) {
        this.serverIp_ = param1Common.serverIp_;
        onChanged();
      } 
      if (!param1Common.getUidStr().isEmpty()) {
        this.uidStr_ = param1Common.uidStr_;
        onChanged();
      } 
      if (!param1Common.getLanguage().isEmpty()) {
        this.language_ = param1Common.language_;
        onChanged();
      } 
      if (!param1Common.getRegion().isEmpty()) {
        this.region_ = param1Common.region_;
        onChanged();
      } 
      if (!param1Common.getIdfv().isEmpty()) {
        this.idfv_ = param1Common.idfv_;
        onChanged();
      } 
      if (!param1Common.getVipType().isEmpty()) {
        this.vipType_ = param1Common.vipType_;
        onChanged();
      } 
      if (param1Common.getAppVersionCode() != 0)
        setAppVersionCode(param1Common.getAppVersionCode()); 
      if (!param1Common.getAppType().isEmpty()) {
        this.appType_ = param1Common.appType_;
        onChanged();
      } 
      if (!param1Common.getBoxId().isEmpty()) {
        this.boxId_ = param1Common.boxId_;
        onChanged();
      } 
      mergeUnknownFields(param1Common.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        CommonProtos.Common common = (CommonProtos.Common)CommonProtos.Common.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CommonProtos.Common common = (CommonProtos.Common)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CommonProtos.Common)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CommonProtos.Common)
        return mergeFrom((CommonProtos.Common)param1Message); 
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.appType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
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
    
    public Builder setBoxId(String param1String) {
      if (param1String != null) {
        this.boxId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBoxIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.boxId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.channel_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setClientIp(String param1String) {
      if (param1String != null) {
        this.clientIp_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setClientIpBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.clientIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDevDna(String param1String) {
      if (param1String != null) {
        this.devDna_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDevDnaBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.devDna_ = param1ByteString;
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.device_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setIdfa(String param1String) {
      if (param1String != null) {
        this.idfa_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdfaBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.idfa_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdfv(String param1String) {
      if (param1String != null) {
        this.idfv_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdfvBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.idfv_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setImei(String param1String) {
      if (param1String != null) {
        this.imei_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setImeiBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.imei_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.language_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLat(String param1String) {
      if (param1String != null) {
        this.lat_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLatBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.lat_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLon(String param1String) {
      if (param1String != null) {
        this.lon_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLonBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.lon_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNet(String param1String) {
      if (param1String != null) {
        this.net_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNetBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.net_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNetOp(String param1String) {
      if (param1String != null) {
        this.netOp_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNetOpBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.netOp_ = param1ByteString;
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.platform_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRegion(String param1String) {
      if (param1String != null) {
        this.region_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRegionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.region_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequestId(String param1String) {
      if (param1String != null) {
        this.requestId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.requestId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setScreenHigh(int param1Int) {
      this.screenHigh_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setScreenWidth(int param1Int) {
      this.screenWidth_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setServerIp(String param1String) {
      if (param1String != null) {
        this.serverIp_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setServerIpBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSmid(String param1String) {
      if (param1String != null) {
        this.smid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSmidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.smid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.timezone_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUid(long param1Long) {
      this.uid_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setUidStr(String param1String) {
      if (param1String != null) {
        this.uidStr_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUidStrBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.uidStr_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        CommonProtos.Common.checkByteStringIsUtf8(param1ByteString);
        this.vipType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  public static interface CommonOrBuilder extends MessageOrBuilder {
    String getAppType();
    
    ByteString getAppTypeBytes();
    
    String getAppVersion();
    
    ByteString getAppVersionBytes();
    
    int getAppVersionCode();
    
    String getBoxId();
    
    ByteString getBoxIdBytes();
    
    String getChannel();
    
    ByteString getChannelBytes();
    
    String getClientIp();
    
    ByteString getClientIpBytes();
    
    String getDevDna();
    
    ByteString getDevDnaBytes();
    
    String getDevice();
    
    ByteString getDeviceBytes();
    
    String getIdfa();
    
    ByteString getIdfaBytes();
    
    String getIdfv();
    
    ByteString getIdfvBytes();
    
    String getImei();
    
    ByteString getImeiBytes();
    
    String getLanguage();
    
    ByteString getLanguageBytes();
    
    String getLat();
    
    ByteString getLatBytes();
    
    String getLon();
    
    ByteString getLonBytes();
    
    String getNet();
    
    ByteString getNetBytes();
    
    String getNetOp();
    
    ByteString getNetOpBytes();
    
    String getOsVersion();
    
    ByteString getOsVersionBytes();
    
    String getPlatform();
    
    ByteString getPlatformBytes();
    
    String getRegion();
    
    ByteString getRegionBytes();
    
    String getRequestId();
    
    ByteString getRequestIdBytes();
    
    int getScreenHigh();
    
    int getScreenWidth();
    
    String getServerIp();
    
    ByteString getServerIpBytes();
    
    String getSmid();
    
    ByteString getSmidBytes();
    
    String getTimezone();
    
    ByteString getTimezoneBytes();
    
    long getUid();
    
    String getUidStr();
    
    ByteString getUidStrBytes();
    
    String getVipType();
    
    ByteString getVipTypeBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\CommonProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
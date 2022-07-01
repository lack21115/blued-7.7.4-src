package com.google.api;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Service extends GeneratedMessageV3 implements ServiceOrBuilder {
  public static final int APIS_FIELD_NUMBER = 3;
  
  public static final int AUTHENTICATION_FIELD_NUMBER = 11;
  
  public static final int BACKEND_FIELD_NUMBER = 8;
  
  public static final int BILLING_FIELD_NUMBER = 26;
  
  public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
  
  public static final int CONTEXT_FIELD_NUMBER = 12;
  
  public static final int CONTROL_FIELD_NUMBER = 21;
  
  private static final Service DEFAULT_INSTANCE = new Service();
  
  public static final int DOCUMENTATION_FIELD_NUMBER = 6;
  
  public static final int ENDPOINTS_FIELD_NUMBER = 18;
  
  public static final int ENUMS_FIELD_NUMBER = 5;
  
  public static final int HTTP_FIELD_NUMBER = 9;
  
  public static final int ID_FIELD_NUMBER = 33;
  
  public static final int LOGGING_FIELD_NUMBER = 27;
  
  public static final int LOGS_FIELD_NUMBER = 23;
  
  public static final int METRICS_FIELD_NUMBER = 24;
  
  public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
  
  public static final int MONITORING_FIELD_NUMBER = 28;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<Service> PARSER = (Parser<Service>)new AbstractParser<Service>() {
      public Service a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Service(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
  
  public static final int QUOTA_FIELD_NUMBER = 10;
  
  public static final int SOURCE_INFO_FIELD_NUMBER = 37;
  
  public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
  
  public static final int TITLE_FIELD_NUMBER = 2;
  
  public static final int TYPES_FIELD_NUMBER = 4;
  
  public static final int USAGE_FIELD_NUMBER = 15;
  
  private static final long serialVersionUID = 0L;
  
  private List<Api> apis_;
  
  private Authentication authentication_;
  
  private Backend backend_;
  
  private Billing billing_;
  
  private int bitField0_;
  
  private UInt32Value configVersion_;
  
  private Context context_;
  
  private Control control_;
  
  private Documentation documentation_;
  
  private List<Endpoint> endpoints_;
  
  private List<Enum> enums_;
  
  private Http http_;
  
  private volatile Object id_;
  
  private Logging logging_;
  
  private List<LogDescriptor> logs_;
  
  private byte memoizedIsInitialized = -1;
  
  private List<MetricDescriptor> metrics_;
  
  private List<MonitoredResourceDescriptor> monitoredResources_;
  
  private Monitoring monitoring_;
  
  private volatile Object name_;
  
  private volatile Object producerProjectId_;
  
  private Quota quota_;
  
  private SourceInfo sourceInfo_;
  
  private SystemParameters systemParameters_;
  
  private volatile Object title_;
  
  private List<Type> types_;
  
  private Usage usage_;
  
  private Service() {
    this.name_ = "";
    this.id_ = "";
    this.title_ = "";
    this.producerProjectId_ = "";
    this.apis_ = Collections.emptyList();
    this.types_ = Collections.emptyList();
    this.enums_ = Collections.emptyList();
    this.endpoints_ = Collections.emptyList();
    this.logs_ = Collections.emptyList();
    this.metrics_ = Collections.emptyList();
    this.monitoredResources_ = Collections.emptyList();
  }
  
  private Service(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      boolean bool = false;
      int i = 0;
      while (!bool) {
        int j = i;
        int k = i;
        int m = i;
        try {
          SystemParameters.Builder builder13;
          Monitoring.Builder builder12;
          Logging.Builder builder11;
          Billing.Builder builder10;
          Control.Builder builder9;
          UInt32Value.Builder builder8;
          Usage.Builder builder7;
          Context.Builder builder6;
          Authentication.Builder builder5;
          Quota.Builder builder4;
          Http.Builder builder3;
          Backend.Builder builder2;
          Documentation.Builder builder1;
          int n = paramCodedInputStream.readTag();
          SourceInfo.Builder builder15 = null;
          SystemParameters.Builder builder16 = null;
          Monitoring.Builder builder17 = null;
          Logging.Builder builder18 = null;
          Billing.Builder builder19 = null;
          Control.Builder builder20 = null;
          UInt32Value.Builder builder21 = null;
          Usage.Builder builder22 = null;
          Context.Builder builder23 = null;
          Authentication.Builder builder24 = null;
          Quota.Builder builder25 = null;
          Http.Builder builder26 = null;
          Backend.Builder builder27 = null;
          SourceInfo.Builder builder14 = null;
          switch (n) {
            case 298:
              j = i;
              k = i;
              m = i;
              if (this.sourceInfo_ != null) {
                j = i;
                k = i;
                m = i;
                builder14 = this.sourceInfo_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.sourceInfo_ = (SourceInfo)paramCodedInputStream.readMessage(SourceInfo.parser(), paramExtensionRegistryLite);
              if (builder14 != null) {
                j = i;
                k = i;
                m = i;
                builder14.mergeFrom(this.sourceInfo_);
                j = i;
                k = i;
                m = i;
                this.sourceInfo_ = builder14.buildPartial();
              } 
              continue;
            case 266:
              j = i;
              k = i;
              m = i;
              this.id_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 234:
              builder14 = builder15;
              j = i;
              k = i;
              m = i;
              if (this.systemParameters_ != null) {
                j = i;
                k = i;
                m = i;
                builder13 = this.systemParameters_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.systemParameters_ = (SystemParameters)paramCodedInputStream.readMessage(SystemParameters.parser(), paramExtensionRegistryLite);
              if (builder13 != null) {
                j = i;
                k = i;
                m = i;
                builder13.mergeFrom(this.systemParameters_);
                j = i;
                k = i;
                m = i;
                this.systemParameters_ = builder13.buildPartial();
              } 
              continue;
            case 226:
              builder13 = builder16;
              j = i;
              k = i;
              m = i;
              if (this.monitoring_ != null) {
                j = i;
                k = i;
                m = i;
                builder12 = this.monitoring_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.monitoring_ = (Monitoring)paramCodedInputStream.readMessage(Monitoring.parser(), paramExtensionRegistryLite);
              if (builder12 != null) {
                j = i;
                k = i;
                m = i;
                builder12.mergeFrom(this.monitoring_);
                j = i;
                k = i;
                m = i;
                this.monitoring_ = builder12.buildPartial();
              } 
              continue;
            case 218:
              builder12 = builder17;
              j = i;
              k = i;
              m = i;
              if (this.logging_ != null) {
                j = i;
                k = i;
                m = i;
                builder11 = this.logging_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.logging_ = (Logging)paramCodedInputStream.readMessage(Logging.parser(), paramExtensionRegistryLite);
              if (builder11 != null) {
                j = i;
                k = i;
                m = i;
                builder11.mergeFrom(this.logging_);
                j = i;
                k = i;
                m = i;
                this.logging_ = builder11.buildPartial();
              } 
              continue;
            case 210:
              builder11 = builder18;
              j = i;
              k = i;
              m = i;
              if (this.billing_ != null) {
                j = i;
                k = i;
                m = i;
                builder10 = this.billing_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.billing_ = (Billing)paramCodedInputStream.readMessage(Billing.parser(), paramExtensionRegistryLite);
              if (builder10 != null) {
                j = i;
                k = i;
                m = i;
                builder10.mergeFrom(this.billing_);
                j = i;
                k = i;
                m = i;
                this.billing_ = builder10.buildPartial();
              } 
              continue;
            case 202:
              n = i;
              if ((i & 0x80000) == 0) {
                j = i;
                k = i;
                m = i;
                this.monitoredResources_ = new ArrayList<MonitoredResourceDescriptor>();
                n = i | 0x80000;
              } 
              j = n;
              k = n;
              m = n;
              this.monitoredResources_.add(paramCodedInputStream.readMessage(MonitoredResourceDescriptor.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 194:
              n = i;
              if ((i & 0x40000) == 0) {
                j = i;
                k = i;
                m = i;
                this.metrics_ = new ArrayList<MetricDescriptor>();
                n = i | 0x40000;
              } 
              j = n;
              k = n;
              m = n;
              this.metrics_.add(paramCodedInputStream.readMessage(MetricDescriptor.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 186:
              n = i;
              if ((i & 0x20000) == 0) {
                j = i;
                k = i;
                m = i;
                this.logs_ = new ArrayList<LogDescriptor>();
                n = i | 0x20000;
              } 
              j = n;
              k = n;
              m = n;
              this.logs_.add(paramCodedInputStream.readMessage(LogDescriptor.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 178:
              j = i;
              k = i;
              m = i;
              this.producerProjectId_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 170:
              builder10 = builder19;
              j = i;
              k = i;
              m = i;
              if (this.control_ != null) {
                j = i;
                k = i;
                m = i;
                builder9 = this.control_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.control_ = (Control)paramCodedInputStream.readMessage(Control.parser(), paramExtensionRegistryLite);
              if (builder9 != null) {
                j = i;
                k = i;
                m = i;
                builder9.mergeFrom(this.control_);
                j = i;
                k = i;
                m = i;
                this.control_ = builder9.buildPartial();
              } 
              continue;
            case 162:
              builder9 = builder20;
              j = i;
              k = i;
              m = i;
              if (this.configVersion_ != null) {
                j = i;
                k = i;
                m = i;
                builder8 = this.configVersion_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.configVersion_ = (UInt32Value)paramCodedInputStream.readMessage(UInt32Value.parser(), paramExtensionRegistryLite);
              if (builder8 != null) {
                j = i;
                k = i;
                m = i;
                builder8.mergeFrom(this.configVersion_);
                j = i;
                k = i;
                m = i;
                this.configVersion_ = builder8.buildPartial();
              } 
              continue;
            case 146:
              n = i;
              if ((i & 0x8000) == 0) {
                j = i;
                k = i;
                m = i;
                this.endpoints_ = new ArrayList<Endpoint>();
                n = i | 0x8000;
              } 
              j = n;
              k = n;
              m = n;
              this.endpoints_.add(paramCodedInputStream.readMessage(Endpoint.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 122:
              builder8 = builder21;
              j = i;
              k = i;
              m = i;
              if (this.usage_ != null) {
                j = i;
                k = i;
                m = i;
                builder7 = this.usage_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.usage_ = (Usage)paramCodedInputStream.readMessage(Usage.parser(), paramExtensionRegistryLite);
              if (builder7 != null) {
                j = i;
                k = i;
                m = i;
                builder7.mergeFrom(this.usage_);
                j = i;
                k = i;
                m = i;
                this.usage_ = builder7.buildPartial();
              } 
              continue;
            case 98:
              builder7 = builder22;
              j = i;
              k = i;
              m = i;
              if (this.context_ != null) {
                j = i;
                k = i;
                m = i;
                builder6 = this.context_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.context_ = (Context)paramCodedInputStream.readMessage(Context.parser(), paramExtensionRegistryLite);
              if (builder6 != null) {
                j = i;
                k = i;
                m = i;
                builder6.mergeFrom(this.context_);
                j = i;
                k = i;
                m = i;
                this.context_ = builder6.buildPartial();
              } 
              continue;
            case 90:
              builder6 = builder23;
              j = i;
              k = i;
              m = i;
              if (this.authentication_ != null) {
                j = i;
                k = i;
                m = i;
                builder5 = this.authentication_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.authentication_ = (Authentication)paramCodedInputStream.readMessage(Authentication.parser(), paramExtensionRegistryLite);
              if (builder5 != null) {
                j = i;
                k = i;
                m = i;
                builder5.mergeFrom(this.authentication_);
                j = i;
                k = i;
                m = i;
                this.authentication_ = builder5.buildPartial();
              } 
              continue;
            case 82:
              builder5 = builder24;
              j = i;
              k = i;
              m = i;
              if (this.quota_ != null) {
                j = i;
                k = i;
                m = i;
                builder4 = this.quota_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.quota_ = (Quota)paramCodedInputStream.readMessage(Quota.parser(), paramExtensionRegistryLite);
              if (builder4 != null) {
                j = i;
                k = i;
                m = i;
                builder4.mergeFrom(this.quota_);
                j = i;
                k = i;
                m = i;
                this.quota_ = builder4.buildPartial();
              } 
              continue;
            case 74:
              builder4 = builder25;
              j = i;
              k = i;
              m = i;
              if (this.http_ != null) {
                j = i;
                k = i;
                m = i;
                builder3 = this.http_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.http_ = (Http)paramCodedInputStream.readMessage(Http.parser(), paramExtensionRegistryLite);
              if (builder3 != null) {
                j = i;
                k = i;
                m = i;
                builder3.mergeFrom(this.http_);
                j = i;
                k = i;
                m = i;
                this.http_ = builder3.buildPartial();
              } 
              continue;
            case 66:
              builder3 = builder26;
              j = i;
              k = i;
              m = i;
              if (this.backend_ != null) {
                j = i;
                k = i;
                m = i;
                builder2 = this.backend_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.backend_ = (Backend)paramCodedInputStream.readMessage(Backend.parser(), paramExtensionRegistryLite);
              if (builder2 != null) {
                j = i;
                k = i;
                m = i;
                builder2.mergeFrom(this.backend_);
                j = i;
                k = i;
                m = i;
                this.backend_ = builder2.buildPartial();
              } 
              continue;
            case 50:
              builder2 = builder27;
              j = i;
              k = i;
              m = i;
              if (this.documentation_ != null) {
                j = i;
                k = i;
                m = i;
                builder1 = this.documentation_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.documentation_ = (Documentation)paramCodedInputStream.readMessage(Documentation.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                j = i;
                k = i;
                m = i;
                builder1.mergeFrom(this.documentation_);
                j = i;
                k = i;
                m = i;
                this.documentation_ = builder1.buildPartial();
              } 
              continue;
            case 42:
              n = i;
              if ((i & 0x80) == 0) {
                j = i;
                k = i;
                m = i;
                this.enums_ = new ArrayList<Enum>();
                n = i | 0x80;
              } 
              j = n;
              k = n;
              m = n;
              this.enums_.add(paramCodedInputStream.readMessage(Enum.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 34:
              n = i;
              if ((i & 0x40) == 0) {
                j = i;
                k = i;
                m = i;
                this.types_ = new ArrayList<Type>();
                n = i | 0x40;
              } 
              j = n;
              k = n;
              m = n;
              this.types_.add(paramCodedInputStream.readMessage(Type.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 26:
              n = i;
              if ((i & 0x20) == 0) {
                j = i;
                k = i;
                m = i;
                this.apis_ = new ArrayList<Api>();
                n = i | 0x20;
              } 
              j = n;
              k = n;
              m = n;
              this.apis_.add(paramCodedInputStream.readMessage(Api.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 18:
              j = i;
              k = i;
              m = i;
              this.title_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 10:
              j = i;
              k = i;
              m = i;
              this.name_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 0:
              bool = true;
              continue;
          } 
          j = i;
          k = i;
          m = i;
          boolean bool1 = parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n);
          if (!bool1);
          continue;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          j = m;
          throw invalidProtocolBufferException.setUnfinishedMessage(this);
        } catch (IOException iOException) {
          j = k;
          throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
        } finally {}
        if ((j & 0x20) != 0)
          this.apis_ = Collections.unmodifiableList(this.apis_); 
        if ((j & 0x40) != 0)
          this.types_ = Collections.unmodifiableList(this.types_); 
        if ((j & 0x80) != 0)
          this.enums_ = Collections.unmodifiableList(this.enums_); 
        if ((j & 0x8000) != 0)
          this.endpoints_ = Collections.unmodifiableList(this.endpoints_); 
        if ((j & 0x20000) != 0)
          this.logs_ = Collections.unmodifiableList(this.logs_); 
        if ((j & 0x40000) != 0)
          this.metrics_ = Collections.unmodifiableList(this.metrics_); 
        if ((j & 0x80000) != 0)
          this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      if ((i & 0x20) != 0)
        this.apis_ = Collections.unmodifiableList(this.apis_); 
      if ((i & 0x40) != 0)
        this.types_ = Collections.unmodifiableList(this.types_); 
      if ((i & 0x80) != 0)
        this.enums_ = Collections.unmodifiableList(this.enums_); 
      if ((i & 0x8000) != 0)
        this.endpoints_ = Collections.unmodifiableList(this.endpoints_); 
      if ((i & 0x20000) != 0)
        this.logs_ = Collections.unmodifiableList(this.logs_); 
      if ((i & 0x40000) != 0)
        this.metrics_ = Collections.unmodifiableList(this.metrics_); 
      if ((i & 0x80000) != 0)
        this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Service(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Service getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ServiceProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Service paramService) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramService);
  }
  
  public static Service parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Service)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Service parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Service)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Service)PARSER.parseFrom(paramByteString);
  }
  
  public static Service parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Service)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Service)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Service parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Service)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(InputStream paramInputStream) throws IOException {
    return (Service)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Service parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Service)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Service)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Service parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Service)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Service)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Service parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Service)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Service> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Service))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (hasConfigVersion() != paramObject.hasConfigVersion()) ? false : ((hasConfigVersion() && !getConfigVersion().equals(paramObject.getConfigVersion())) ? false : (!getName().equals(paramObject.getName()) ? false : (!getId().equals(paramObject.getId()) ? false : (!getTitle().equals(paramObject.getTitle()) ? false : (!getProducerProjectId().equals(paramObject.getProducerProjectId()) ? false : (!getApisList().equals(paramObject.getApisList()) ? false : (!getTypesList().equals(paramObject.getTypesList()) ? false : (!getEnumsList().equals(paramObject.getEnumsList()) ? false : ((hasDocumentation() != paramObject.hasDocumentation()) ? false : ((hasDocumentation() && !getDocumentation().equals(paramObject.getDocumentation())) ? false : ((hasBackend() != paramObject.hasBackend()) ? false : ((hasBackend() && !getBackend().equals(paramObject.getBackend())) ? false : ((hasHttp() != paramObject.hasHttp()) ? false : ((hasHttp() && !getHttp().equals(paramObject.getHttp())) ? false : ((hasQuota() != paramObject.hasQuota()) ? false : ((hasQuota() && !getQuota().equals(paramObject.getQuota())) ? false : ((hasAuthentication() != paramObject.hasAuthentication()) ? false : ((hasAuthentication() && !getAuthentication().equals(paramObject.getAuthentication())) ? false : ((hasContext() != paramObject.hasContext()) ? false : ((hasContext() && !getContext().equals(paramObject.getContext())) ? false : ((hasUsage() != paramObject.hasUsage()) ? false : ((hasUsage() && !getUsage().equals(paramObject.getUsage())) ? false : (!getEndpointsList().equals(paramObject.getEndpointsList()) ? false : ((hasControl() != paramObject.hasControl()) ? false : ((hasControl() && !getControl().equals(paramObject.getControl())) ? false : (!getLogsList().equals(paramObject.getLogsList()) ? false : (!getMetricsList().equals(paramObject.getMetricsList()) ? false : (!getMonitoredResourcesList().equals(paramObject.getMonitoredResourcesList()) ? false : ((hasBilling() != paramObject.hasBilling()) ? false : ((hasBilling() && !getBilling().equals(paramObject.getBilling())) ? false : ((hasLogging() != paramObject.hasLogging()) ? false : ((hasLogging() && !getLogging().equals(paramObject.getLogging())) ? false : ((hasMonitoring() != paramObject.hasMonitoring()) ? false : ((hasMonitoring() && !getMonitoring().equals(paramObject.getMonitoring())) ? false : ((hasSystemParameters() != paramObject.hasSystemParameters()) ? false : ((hasSystemParameters() && !getSystemParameters().equals(paramObject.getSystemParameters())) ? false : ((hasSourceInfo() != paramObject.hasSourceInfo()) ? false : ((hasSourceInfo() && !getSourceInfo().equals(paramObject.getSourceInfo())) ? false : (!!this.unknownFields.equals(((Service)paramObject).unknownFields))))))))))))))))))))))))))))))))))))))));
  }
  
  public Api getApis(int paramInt) {
    return this.apis_.get(paramInt);
  }
  
  public int getApisCount() {
    return this.apis_.size();
  }
  
  public List<Api> getApisList() {
    return this.apis_;
  }
  
  public ApiOrBuilder getApisOrBuilder(int paramInt) {
    return (ApiOrBuilder)this.apis_.get(paramInt);
  }
  
  public List<? extends ApiOrBuilder> getApisOrBuilderList() {
    return (List)this.apis_;
  }
  
  public Authentication getAuthentication() {
    Authentication authentication2 = this.authentication_;
    Authentication authentication1 = authentication2;
    if (authentication2 == null)
      authentication1 = Authentication.getDefaultInstance(); 
    return authentication1;
  }
  
  public AuthenticationOrBuilder getAuthenticationOrBuilder() {
    return getAuthentication();
  }
  
  public Backend getBackend() {
    Backend backend2 = this.backend_;
    Backend backend1 = backend2;
    if (backend2 == null)
      backend1 = Backend.getDefaultInstance(); 
    return backend1;
  }
  
  public BackendOrBuilder getBackendOrBuilder() {
    return getBackend();
  }
  
  public Billing getBilling() {
    Billing billing2 = this.billing_;
    Billing billing1 = billing2;
    if (billing2 == null)
      billing1 = Billing.getDefaultInstance(); 
    return billing1;
  }
  
  public BillingOrBuilder getBillingOrBuilder() {
    return getBilling();
  }
  
  public UInt32Value getConfigVersion() {
    UInt32Value uInt32Value2 = this.configVersion_;
    UInt32Value uInt32Value1 = uInt32Value2;
    if (uInt32Value2 == null)
      uInt32Value1 = UInt32Value.getDefaultInstance(); 
    return uInt32Value1;
  }
  
  public UInt32ValueOrBuilder getConfigVersionOrBuilder() {
    return (UInt32ValueOrBuilder)getConfigVersion();
  }
  
  public Context getContext() {
    Context context2 = this.context_;
    Context context1 = context2;
    if (context2 == null)
      context1 = Context.getDefaultInstance(); 
    return context1;
  }
  
  public ContextOrBuilder getContextOrBuilder() {
    return getContext();
  }
  
  public Control getControl() {
    Control control2 = this.control_;
    Control control1 = control2;
    if (control2 == null)
      control1 = Control.getDefaultInstance(); 
    return control1;
  }
  
  public ControlOrBuilder getControlOrBuilder() {
    return getControl();
  }
  
  public Service getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Documentation getDocumentation() {
    Documentation documentation2 = this.documentation_;
    Documentation documentation1 = documentation2;
    if (documentation2 == null)
      documentation1 = Documentation.getDefaultInstance(); 
    return documentation1;
  }
  
  public DocumentationOrBuilder getDocumentationOrBuilder() {
    return getDocumentation();
  }
  
  public Endpoint getEndpoints(int paramInt) {
    return this.endpoints_.get(paramInt);
  }
  
  public int getEndpointsCount() {
    return this.endpoints_.size();
  }
  
  public List<Endpoint> getEndpointsList() {
    return this.endpoints_;
  }
  
  public EndpointOrBuilder getEndpointsOrBuilder(int paramInt) {
    return this.endpoints_.get(paramInt);
  }
  
  public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
    return (List)this.endpoints_;
  }
  
  public Enum getEnums(int paramInt) {
    return this.enums_.get(paramInt);
  }
  
  public int getEnumsCount() {
    return this.enums_.size();
  }
  
  public List<Enum> getEnumsList() {
    return this.enums_;
  }
  
  public EnumOrBuilder getEnumsOrBuilder(int paramInt) {
    return (EnumOrBuilder)this.enums_.get(paramInt);
  }
  
  public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
    return (List)this.enums_;
  }
  
  public Http getHttp() {
    Http http2 = this.http_;
    Http http1 = http2;
    if (http2 == null)
      http1 = Http.getDefaultInstance(); 
    return http1;
  }
  
  public HttpOrBuilder getHttpOrBuilder() {
    return getHttp();
  }
  
  public String getId() {
    Object object = this.id_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.id_ = object;
    return (String)object;
  }
  
  public ByteString getIdBytes() {
    Object object = this.id_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.id_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Logging getLogging() {
    Logging logging2 = this.logging_;
    Logging logging1 = logging2;
    if (logging2 == null)
      logging1 = Logging.getDefaultInstance(); 
    return logging1;
  }
  
  public LoggingOrBuilder getLoggingOrBuilder() {
    return getLogging();
  }
  
  public LogDescriptor getLogs(int paramInt) {
    return this.logs_.get(paramInt);
  }
  
  public int getLogsCount() {
    return this.logs_.size();
  }
  
  public List<LogDescriptor> getLogsList() {
    return this.logs_;
  }
  
  public LogDescriptorOrBuilder getLogsOrBuilder(int paramInt) {
    return this.logs_.get(paramInt);
  }
  
  public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
    return (List)this.logs_;
  }
  
  public MetricDescriptor getMetrics(int paramInt) {
    return this.metrics_.get(paramInt);
  }
  
  public int getMetricsCount() {
    return this.metrics_.size();
  }
  
  public List<MetricDescriptor> getMetricsList() {
    return this.metrics_;
  }
  
  public MetricDescriptorOrBuilder getMetricsOrBuilder(int paramInt) {
    return this.metrics_.get(paramInt);
  }
  
  public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
    return (List)this.metrics_;
  }
  
  public MonitoredResourceDescriptor getMonitoredResources(int paramInt) {
    return this.monitoredResources_.get(paramInt);
  }
  
  public int getMonitoredResourcesCount() {
    return this.monitoredResources_.size();
  }
  
  public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
    return this.monitoredResources_;
  }
  
  public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int paramInt) {
    return this.monitoredResources_.get(paramInt);
  }
  
  public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
    return (List)this.monitoredResources_;
  }
  
  public Monitoring getMonitoring() {
    Monitoring monitoring2 = this.monitoring_;
    Monitoring monitoring1 = monitoring2;
    if (monitoring2 == null)
      monitoring1 = Monitoring.getDefaultInstance(); 
    return monitoring1;
  }
  
  public MonitoringOrBuilder getMonitoringOrBuilder() {
    return getMonitoring();
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
  
  public Parser<Service> getParserForType() {
    return PARSER;
  }
  
  public String getProducerProjectId() {
    Object object = this.producerProjectId_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.producerProjectId_ = object;
    return (String)object;
  }
  
  public ByteString getProducerProjectIdBytes() {
    Object object = this.producerProjectId_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.producerProjectId_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Quota getQuota() {
    Quota quota2 = this.quota_;
    Quota quota1 = quota2;
    if (quota2 == null)
      quota1 = Quota.getDefaultInstance(); 
    return quota1;
  }
  
  public QuotaOrBuilder getQuotaOrBuilder() {
    return getQuota();
  }
  
  public int getSerializedSize() {
    int m;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getNameBytes().isEmpty();
    byte b = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!getTitleBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.title_); 
    i = j;
    for (j = 0; j < this.apis_.size(); j++)
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.apis_.get(j)); 
    for (j = 0; j < this.types_.size(); j++)
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.types_.get(j)); 
    for (j = 0; j < this.enums_.size(); j++)
      i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.enums_.get(j)); 
    j = i;
    if (this.documentation_ != null)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)getDocumentation()); 
    i = j;
    if (this.backend_ != null)
      i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)getBackend()); 
    j = i;
    if (this.http_ != null)
      j = i + CodedOutputStream.computeMessageSize(9, (MessageLite)getHttp()); 
    i = j;
    if (this.quota_ != null)
      i = j + CodedOutputStream.computeMessageSize(10, (MessageLite)getQuota()); 
    j = i;
    if (this.authentication_ != null)
      j = i + CodedOutputStream.computeMessageSize(11, (MessageLite)getAuthentication()); 
    i = j;
    if (this.context_ != null)
      i = j + CodedOutputStream.computeMessageSize(12, (MessageLite)getContext()); 
    j = i;
    if (this.usage_ != null)
      j = i + CodedOutputStream.computeMessageSize(15, (MessageLite)getUsage()); 
    int k = 0;
    i = j;
    for (j = k; j < this.endpoints_.size(); j++)
      i += CodedOutputStream.computeMessageSize(18, (MessageLite)this.endpoints_.get(j)); 
    j = i;
    if (this.configVersion_ != null)
      j = i + CodedOutputStream.computeMessageSize(20, (MessageLite)getConfigVersion()); 
    i = j;
    if (this.control_ != null)
      i = j + CodedOutputStream.computeMessageSize(21, (MessageLite)getControl()); 
    j = i;
    if (!getProducerProjectIdBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(22, this.producerProjectId_); 
    k = 0;
    i = j;
    for (j = k; j < this.logs_.size(); j++)
      i += CodedOutputStream.computeMessageSize(23, (MessageLite)this.logs_.get(j)); 
    k = 0;
    while (true) {
      m = b;
      j = i;
      if (k < this.metrics_.size()) {
        i += CodedOutputStream.computeMessageSize(24, (MessageLite)this.metrics_.get(k));
        k++;
        continue;
      } 
      break;
    } 
    while (m < this.monitoredResources_.size()) {
      j += CodedOutputStream.computeMessageSize(25, (MessageLite)this.monitoredResources_.get(m));
      m++;
    } 
    i = j;
    if (this.billing_ != null)
      i = j + CodedOutputStream.computeMessageSize(26, (MessageLite)getBilling()); 
    j = i;
    if (this.logging_ != null)
      j = i + CodedOutputStream.computeMessageSize(27, (MessageLite)getLogging()); 
    i = j;
    if (this.monitoring_ != null)
      i = j + CodedOutputStream.computeMessageSize(28, (MessageLite)getMonitoring()); 
    j = i;
    if (this.systemParameters_ != null)
      j = i + CodedOutputStream.computeMessageSize(29, (MessageLite)getSystemParameters()); 
    i = j;
    if (!getIdBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(33, this.id_); 
    j = i;
    if (this.sourceInfo_ != null)
      j = i + CodedOutputStream.computeMessageSize(37, (MessageLite)getSourceInfo()); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public SourceInfo getSourceInfo() {
    SourceInfo sourceInfo2 = this.sourceInfo_;
    SourceInfo sourceInfo1 = sourceInfo2;
    if (sourceInfo2 == null)
      sourceInfo1 = SourceInfo.getDefaultInstance(); 
    return sourceInfo1;
  }
  
  public SourceInfoOrBuilder getSourceInfoOrBuilder() {
    return getSourceInfo();
  }
  
  public SystemParameters getSystemParameters() {
    SystemParameters systemParameters2 = this.systemParameters_;
    SystemParameters systemParameters1 = systemParameters2;
    if (systemParameters2 == null)
      systemParameters1 = SystemParameters.getDefaultInstance(); 
    return systemParameters1;
  }
  
  public SystemParametersOrBuilder getSystemParametersOrBuilder() {
    return getSystemParameters();
  }
  
  public String getTitle() {
    Object object = this.title_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.title_ = object;
    return (String)object;
  }
  
  public ByteString getTitleBytes() {
    Object object = this.title_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.title_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Type getTypes(int paramInt) {
    return this.types_.get(paramInt);
  }
  
  public int getTypesCount() {
    return this.types_.size();
  }
  
  public List<Type> getTypesList() {
    return this.types_;
  }
  
  public TypeOrBuilder getTypesOrBuilder(int paramInt) {
    return (TypeOrBuilder)this.types_.get(paramInt);
  }
  
  public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
    return (List)this.types_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public Usage getUsage() {
    Usage usage2 = this.usage_;
    Usage usage1 = usage2;
    if (usage2 == null)
      usage1 = Usage.getDefaultInstance(); 
    return usage1;
  }
  
  public UsageOrBuilder getUsageOrBuilder() {
    return getUsage();
  }
  
  public boolean hasAuthentication() {
    return (this.authentication_ != null);
  }
  
  public boolean hasBackend() {
    return (this.backend_ != null);
  }
  
  public boolean hasBilling() {
    return (this.billing_ != null);
  }
  
  public boolean hasConfigVersion() {
    return (this.configVersion_ != null);
  }
  
  public boolean hasContext() {
    return (this.context_ != null);
  }
  
  public boolean hasControl() {
    return (this.control_ != null);
  }
  
  public boolean hasDocumentation() {
    return (this.documentation_ != null);
  }
  
  public boolean hasHttp() {
    return (this.http_ != null);
  }
  
  public boolean hasLogging() {
    return (this.logging_ != null);
  }
  
  public boolean hasMonitoring() {
    return (this.monitoring_ != null);
  }
  
  public boolean hasQuota() {
    return (this.quota_ != null);
  }
  
  public boolean hasSourceInfo() {
    return (this.sourceInfo_ != null);
  }
  
  public boolean hasSystemParameters() {
    return (this.systemParameters_ != null);
  }
  
  public boolean hasUsage() {
    return (this.usage_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasConfigVersion())
      i = (j * 37 + 20) * 53 + getConfigVersion().hashCode(); 
    j = (((((((i * 37 + 1) * 53 + getName().hashCode()) * 37 + 33) * 53 + getId().hashCode()) * 37 + 2) * 53 + getTitle().hashCode()) * 37 + 22) * 53 + getProducerProjectId().hashCode();
    i = j;
    if (getApisCount() > 0)
      i = (j * 37 + 3) * 53 + getApisList().hashCode(); 
    j = i;
    if (getTypesCount() > 0)
      j = (i * 37 + 4) * 53 + getTypesList().hashCode(); 
    i = j;
    if (getEnumsCount() > 0)
      i = (j * 37 + 5) * 53 + getEnumsList().hashCode(); 
    j = i;
    if (hasDocumentation())
      j = (i * 37 + 6) * 53 + getDocumentation().hashCode(); 
    i = j;
    if (hasBackend())
      i = (j * 37 + 8) * 53 + getBackend().hashCode(); 
    j = i;
    if (hasHttp())
      j = (i * 37 + 9) * 53 + getHttp().hashCode(); 
    i = j;
    if (hasQuota())
      i = (j * 37 + 10) * 53 + getQuota().hashCode(); 
    j = i;
    if (hasAuthentication())
      j = (i * 37 + 11) * 53 + getAuthentication().hashCode(); 
    i = j;
    if (hasContext())
      i = (j * 37 + 12) * 53 + getContext().hashCode(); 
    j = i;
    if (hasUsage())
      j = (i * 37 + 15) * 53 + getUsage().hashCode(); 
    i = j;
    if (getEndpointsCount() > 0)
      i = (j * 37 + 18) * 53 + getEndpointsList().hashCode(); 
    j = i;
    if (hasControl())
      j = (i * 37 + 21) * 53 + getControl().hashCode(); 
    i = j;
    if (getLogsCount() > 0)
      i = (j * 37 + 23) * 53 + getLogsList().hashCode(); 
    j = i;
    if (getMetricsCount() > 0)
      j = (i * 37 + 24) * 53 + getMetricsList().hashCode(); 
    i = j;
    if (getMonitoredResourcesCount() > 0)
      i = (j * 37 + 25) * 53 + getMonitoredResourcesList().hashCode(); 
    j = i;
    if (hasBilling())
      j = (i * 37 + 26) * 53 + getBilling().hashCode(); 
    i = j;
    if (hasLogging())
      i = (j * 37 + 27) * 53 + getLogging().hashCode(); 
    j = i;
    if (hasMonitoring())
      j = (i * 37 + 28) * 53 + getMonitoring().hashCode(); 
    i = j;
    if (hasSystemParameters())
      i = (j * 37 + 29) * 53 + getSystemParameters().hashCode(); 
    j = i;
    if (hasSourceInfo())
      j = (i * 37 + 37) * 53 + getSourceInfo().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ServiceProto.b.ensureFieldAccessorsInitialized(Service.class, Builder.class);
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
    int j;
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    if (!getTitleBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.title_); 
    byte b = 0;
    int i;
    for (i = 0; i < this.apis_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.apis_.get(i)); 
    for (i = 0; i < this.types_.size(); i++)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.types_.get(i)); 
    for (i = 0; i < this.enums_.size(); i++)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.enums_.get(i)); 
    if (this.documentation_ != null)
      paramCodedOutputStream.writeMessage(6, (MessageLite)getDocumentation()); 
    if (this.backend_ != null)
      paramCodedOutputStream.writeMessage(8, (MessageLite)getBackend()); 
    if (this.http_ != null)
      paramCodedOutputStream.writeMessage(9, (MessageLite)getHttp()); 
    if (this.quota_ != null)
      paramCodedOutputStream.writeMessage(10, (MessageLite)getQuota()); 
    if (this.authentication_ != null)
      paramCodedOutputStream.writeMessage(11, (MessageLite)getAuthentication()); 
    if (this.context_ != null)
      paramCodedOutputStream.writeMessage(12, (MessageLite)getContext()); 
    if (this.usage_ != null)
      paramCodedOutputStream.writeMessage(15, (MessageLite)getUsage()); 
    for (i = 0; i < this.endpoints_.size(); i++)
      paramCodedOutputStream.writeMessage(18, (MessageLite)this.endpoints_.get(i)); 
    if (this.configVersion_ != null)
      paramCodedOutputStream.writeMessage(20, (MessageLite)getConfigVersion()); 
    if (this.control_ != null)
      paramCodedOutputStream.writeMessage(21, (MessageLite)getControl()); 
    if (!getProducerProjectIdBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 22, this.producerProjectId_); 
    for (i = 0; i < this.logs_.size(); i++)
      paramCodedOutputStream.writeMessage(23, (MessageLite)this.logs_.get(i)); 
    i = 0;
    while (true) {
      j = b;
      if (i < this.metrics_.size()) {
        paramCodedOutputStream.writeMessage(24, (MessageLite)this.metrics_.get(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.monitoredResources_.size()) {
      paramCodedOutputStream.writeMessage(25, (MessageLite)this.monitoredResources_.get(j));
      j++;
    } 
    if (this.billing_ != null)
      paramCodedOutputStream.writeMessage(26, (MessageLite)getBilling()); 
    if (this.logging_ != null)
      paramCodedOutputStream.writeMessage(27, (MessageLite)getLogging()); 
    if (this.monitoring_ != null)
      paramCodedOutputStream.writeMessage(28, (MessageLite)getMonitoring()); 
    if (this.systemParameters_ != null)
      paramCodedOutputStream.writeMessage(29, (MessageLite)getSystemParameters()); 
    if (!getIdBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 33, this.id_); 
    if (this.sourceInfo_ != null)
      paramCodedOutputStream.writeMessage(37, (MessageLite)getSourceInfo()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServiceOrBuilder {
    private RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> apisBuilder_;
    
    private List<Api> apis_ = Collections.emptyList();
    
    private SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> authenticationBuilder_;
    
    private Authentication authentication_;
    
    private SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> backendBuilder_;
    
    private Backend backend_;
    
    private SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> billingBuilder_;
    
    private Billing billing_;
    
    private int bitField0_;
    
    private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> configVersionBuilder_;
    
    private UInt32Value configVersion_;
    
    private SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> contextBuilder_;
    
    private Context context_;
    
    private SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> controlBuilder_;
    
    private Control control_;
    
    private SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> documentationBuilder_;
    
    private Documentation documentation_;
    
    private RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> endpointsBuilder_;
    
    private List<Endpoint> endpoints_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> enumsBuilder_;
    
    private List<Enum> enums_ = Collections.emptyList();
    
    private SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> httpBuilder_;
    
    private Http http_;
    
    private Object id_ = "";
    
    private SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> loggingBuilder_;
    
    private Logging logging_;
    
    private RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> logsBuilder_;
    
    private List<LogDescriptor> logs_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> metricsBuilder_;
    
    private List<MetricDescriptor> metrics_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> monitoredResourcesBuilder_;
    
    private List<MonitoredResourceDescriptor> monitoredResources_ = Collections.emptyList();
    
    private SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> monitoringBuilder_;
    
    private Monitoring monitoring_;
    
    private Object name_ = "";
    
    private Object producerProjectId_ = "";
    
    private SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> quotaBuilder_;
    
    private Quota quota_;
    
    private SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> sourceInfoBuilder_;
    
    private SourceInfo sourceInfo_;
    
    private SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> systemParametersBuilder_;
    
    private SystemParameters systemParameters_;
    
    private Object title_ = "";
    
    private RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> typesBuilder_;
    
    private List<Type> types_ = Collections.emptyList();
    
    private SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> usageBuilder_;
    
    private Usage usage_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureApisIsMutable() {
      if ((this.bitField0_ & 0x20) == 0) {
        this.apis_ = new ArrayList<Api>(this.apis_);
        this.bitField0_ |= 0x20;
      } 
    }
    
    private void ensureEndpointsIsMutable() {
      if ((this.bitField0_ & 0x8000) == 0) {
        this.endpoints_ = new ArrayList<Endpoint>(this.endpoints_);
        this.bitField0_ |= 0x8000;
      } 
    }
    
    private void ensureEnumsIsMutable() {
      if ((this.bitField0_ & 0x80) == 0) {
        this.enums_ = new ArrayList<Enum>(this.enums_);
        this.bitField0_ |= 0x80;
      } 
    }
    
    private void ensureLogsIsMutable() {
      if ((this.bitField0_ & 0x20000) == 0) {
        this.logs_ = new ArrayList<LogDescriptor>(this.logs_);
        this.bitField0_ |= 0x20000;
      } 
    }
    
    private void ensureMetricsIsMutable() {
      if ((this.bitField0_ & 0x40000) == 0) {
        this.metrics_ = new ArrayList<MetricDescriptor>(this.metrics_);
        this.bitField0_ |= 0x40000;
      } 
    }
    
    private void ensureMonitoredResourcesIsMutable() {
      if ((this.bitField0_ & 0x80000) == 0) {
        this.monitoredResources_ = new ArrayList<MonitoredResourceDescriptor>(this.monitoredResources_);
        this.bitField0_ |= 0x80000;
      } 
    }
    
    private void ensureTypesIsMutable() {
      if ((this.bitField0_ & 0x40) == 0) {
        this.types_ = new ArrayList<Type>(this.types_);
        this.bitField0_ |= 0x40;
      } 
    }
    
    private RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> getApisFieldBuilder() {
      if (this.apisBuilder_ == null) {
        boolean bool;
        List<Api> list = this.apis_;
        if ((this.bitField0_ & 0x20) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.apisBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.apis_ = null;
      } 
      return this.apisBuilder_;
    }
    
    private SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> getAuthenticationFieldBuilder() {
      if (this.authenticationBuilder_ == null) {
        this.authenticationBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getAuthentication(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.authentication_ = null;
      } 
      return this.authenticationBuilder_;
    }
    
    private SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> getBackendFieldBuilder() {
      if (this.backendBuilder_ == null) {
        this.backendBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBackend(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.backend_ = null;
      } 
      return this.backendBuilder_;
    }
    
    private SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> getBillingFieldBuilder() {
      if (this.billingBuilder_ == null) {
        this.billingBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBilling(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.billing_ = null;
      } 
      return this.billingBuilder_;
    }
    
    private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> getConfigVersionFieldBuilder() {
      if (this.configVersionBuilder_ == null) {
        this.configVersionBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getConfigVersion(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.configVersion_ = null;
      } 
      return this.configVersionBuilder_;
    }
    
    private SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> getContextFieldBuilder() {
      if (this.contextBuilder_ == null) {
        this.contextBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getContext(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.context_ = null;
      } 
      return this.contextBuilder_;
    }
    
    private SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> getControlFieldBuilder() {
      if (this.controlBuilder_ == null) {
        this.controlBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getControl(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.control_ = null;
      } 
      return this.controlBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ServiceProto.a;
    }
    
    private SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> getDocumentationFieldBuilder() {
      if (this.documentationBuilder_ == null) {
        this.documentationBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getDocumentation(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.documentation_ = null;
      } 
      return this.documentationBuilder_;
    }
    
    private RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> getEndpointsFieldBuilder() {
      if (this.endpointsBuilder_ == null) {
        boolean bool;
        List<Endpoint> list = this.endpoints_;
        if ((this.bitField0_ & 0x8000) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.endpointsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.endpoints_ = null;
      } 
      return this.endpointsBuilder_;
    }
    
    private RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> getEnumsFieldBuilder() {
      if (this.enumsBuilder_ == null) {
        boolean bool;
        List<Enum> list = this.enums_;
        if ((this.bitField0_ & 0x80) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.enumsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.enums_ = null;
      } 
      return this.enumsBuilder_;
    }
    
    private SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> getHttpFieldBuilder() {
      if (this.httpBuilder_ == null) {
        this.httpBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getHttp(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.http_ = null;
      } 
      return this.httpBuilder_;
    }
    
    private SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> getLoggingFieldBuilder() {
      if (this.loggingBuilder_ == null) {
        this.loggingBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLogging(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.logging_ = null;
      } 
      return this.loggingBuilder_;
    }
    
    private RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> getLogsFieldBuilder() {
      if (this.logsBuilder_ == null) {
        boolean bool;
        List<LogDescriptor> list = this.logs_;
        if ((this.bitField0_ & 0x20000) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.logsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.logs_ = null;
      } 
      return this.logsBuilder_;
    }
    
    private RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> getMetricsFieldBuilder() {
      if (this.metricsBuilder_ == null) {
        boolean bool;
        List<MetricDescriptor> list = this.metrics_;
        if ((this.bitField0_ & 0x40000) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.metricsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.metrics_ = null;
      } 
      return this.metricsBuilder_;
    }
    
    private RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesFieldBuilder() {
      if (this.monitoredResourcesBuilder_ == null) {
        boolean bool;
        List<MonitoredResourceDescriptor> list = this.monitoredResources_;
        if ((this.bitField0_ & 0x80000) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.monitoredResourcesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.monitoredResources_ = null;
      } 
      return this.monitoredResourcesBuilder_;
    }
    
    private SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> getMonitoringFieldBuilder() {
      if (this.monitoringBuilder_ == null) {
        this.monitoringBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getMonitoring(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.monitoring_ = null;
      } 
      return this.monitoringBuilder_;
    }
    
    private SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> getQuotaFieldBuilder() {
      if (this.quotaBuilder_ == null) {
        this.quotaBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getQuota(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.quota_ = null;
      } 
      return this.quotaBuilder_;
    }
    
    private SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> getSourceInfoFieldBuilder() {
      if (this.sourceInfoBuilder_ == null) {
        this.sourceInfoBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSourceInfo(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.sourceInfo_ = null;
      } 
      return this.sourceInfoBuilder_;
    }
    
    private SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> getSystemParametersFieldBuilder() {
      if (this.systemParametersBuilder_ == null) {
        this.systemParametersBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSystemParameters(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.systemParameters_ = null;
      } 
      return this.systemParametersBuilder_;
    }
    
    private RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> getTypesFieldBuilder() {
      if (this.typesBuilder_ == null) {
        boolean bool;
        List<Type> list = this.types_;
        if ((this.bitField0_ & 0x40) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.typesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.types_ = null;
      } 
      return this.typesBuilder_;
    }
    
    private SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> getUsageFieldBuilder() {
      if (this.usageBuilder_ == null) {
        this.usageBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getUsage(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.usage_ = null;
      } 
      return this.usageBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Service.alwaysUseFieldBuilders) {
        getApisFieldBuilder();
        getTypesFieldBuilder();
        getEnumsFieldBuilder();
        getEndpointsFieldBuilder();
        getLogsFieldBuilder();
        getMetricsFieldBuilder();
        getMonitoredResourcesFieldBuilder();
      } 
    }
    
    public Builder addAllApis(Iterable<? extends Api> param1Iterable) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureApisIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.apis_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllEndpoints(Iterable<? extends Endpoint> param1Iterable) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEndpointsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.endpoints_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllEnums(Iterable<? extends Enum> param1Iterable) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEnumsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.enums_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllLogs(Iterable<? extends LogDescriptor> param1Iterable) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLogsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.logs_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllMetrics(Iterable<? extends MetricDescriptor> param1Iterable) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.metrics_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> param1Iterable) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMonitoredResourcesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.monitoredResources_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllTypes(Iterable<? extends Type> param1Iterable) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureTypesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.types_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addApis(int param1Int, Api.Builder param1Builder) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureApisIsMutable();
        this.apis_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addApis(int param1Int, Api param1Api) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Api != null) {
          ensureApisIsMutable();
          this.apis_.add(param1Int, param1Api);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Api);
      return this;
    }
    
    public Builder addApis(Api.Builder param1Builder) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureApisIsMutable();
        this.apis_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addApis(Api param1Api) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Api != null) {
          ensureApisIsMutable();
          this.apis_.add(param1Api);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Api);
      return this;
    }
    
    public Api.Builder addApisBuilder() {
      return (Api.Builder)getApisFieldBuilder().addBuilder((AbstractMessage)Api.getDefaultInstance());
    }
    
    public Api.Builder addApisBuilder(int param1Int) {
      return (Api.Builder)getApisFieldBuilder().addBuilder(param1Int, (AbstractMessage)Api.getDefaultInstance());
    }
    
    public Builder addEndpoints(int param1Int, Endpoint.Builder param1Builder) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addEndpoints(int param1Int, Endpoint param1Endpoint) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Endpoint != null) {
          ensureEndpointsIsMutable();
          this.endpoints_.add(param1Int, param1Endpoint);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Endpoint);
      return this;
    }
    
    public Builder addEndpoints(Endpoint.Builder param1Builder) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addEndpoints(Endpoint param1Endpoint) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Endpoint != null) {
          ensureEndpointsIsMutable();
          this.endpoints_.add(param1Endpoint);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Endpoint);
      return this;
    }
    
    public Endpoint.Builder addEndpointsBuilder() {
      return (Endpoint.Builder)getEndpointsFieldBuilder().addBuilder((AbstractMessage)Endpoint.getDefaultInstance());
    }
    
    public Endpoint.Builder addEndpointsBuilder(int param1Int) {
      return (Endpoint.Builder)getEndpointsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Endpoint.getDefaultInstance());
    }
    
    public Builder addEnums(int param1Int, Enum.Builder param1Builder) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEnumsIsMutable();
        this.enums_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addEnums(int param1Int, Enum param1Enum) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Enum != null) {
          ensureEnumsIsMutable();
          this.enums_.add(param1Int, param1Enum);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Enum);
      return this;
    }
    
    public Builder addEnums(Enum.Builder param1Builder) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEnumsIsMutable();
        this.enums_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addEnums(Enum param1Enum) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Enum != null) {
          ensureEnumsIsMutable();
          this.enums_.add(param1Enum);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Enum);
      return this;
    }
    
    public Enum.Builder addEnumsBuilder() {
      return (Enum.Builder)getEnumsFieldBuilder().addBuilder((AbstractMessage)Enum.getDefaultInstance());
    }
    
    public Enum.Builder addEnumsBuilder(int param1Int) {
      return (Enum.Builder)getEnumsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Enum.getDefaultInstance());
    }
    
    public Builder addLogs(int param1Int, LogDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLogsIsMutable();
        this.logs_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLogs(int param1Int, LogDescriptor param1LogDescriptor) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LogDescriptor != null) {
          ensureLogsIsMutable();
          this.logs_.add(param1Int, param1LogDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1LogDescriptor);
      return this;
    }
    
    public Builder addLogs(LogDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLogsIsMutable();
        this.logs_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLogs(LogDescriptor param1LogDescriptor) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LogDescriptor != null) {
          ensureLogsIsMutable();
          this.logs_.add(param1LogDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1LogDescriptor);
      return this;
    }
    
    public LogDescriptor.Builder addLogsBuilder() {
      return (LogDescriptor.Builder)getLogsFieldBuilder().addBuilder((AbstractMessage)LogDescriptor.getDefaultInstance());
    }
    
    public LogDescriptor.Builder addLogsBuilder(int param1Int) {
      return (LogDescriptor.Builder)getLogsFieldBuilder().addBuilder(param1Int, (AbstractMessage)LogDescriptor.getDefaultInstance());
    }
    
    public Builder addMetrics(int param1Int, MetricDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricsIsMutable();
        this.metrics_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addMetrics(int param1Int, MetricDescriptor param1MetricDescriptor) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MetricDescriptor != null) {
          ensureMetricsIsMutable();
          this.metrics_.add(param1Int, param1MetricDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1MetricDescriptor);
      return this;
    }
    
    public Builder addMetrics(MetricDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricsIsMutable();
        this.metrics_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addMetrics(MetricDescriptor param1MetricDescriptor) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MetricDescriptor != null) {
          ensureMetricsIsMutable();
          this.metrics_.add(param1MetricDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1MetricDescriptor);
      return this;
    }
    
    public MetricDescriptor.Builder addMetricsBuilder() {
      return (MetricDescriptor.Builder)getMetricsFieldBuilder().addBuilder((AbstractMessage)MetricDescriptor.getDefaultInstance());
    }
    
    public MetricDescriptor.Builder addMetricsBuilder(int param1Int) {
      return (MetricDescriptor.Builder)getMetricsFieldBuilder().addBuilder(param1Int, (AbstractMessage)MetricDescriptor.getDefaultInstance());
    }
    
    public Builder addMonitoredResources(int param1Int, MonitoredResourceDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addMonitoredResources(int param1Int, MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoredResourceDescriptor != null) {
          ensureMonitoredResourcesIsMutable();
          this.monitoredResources_.add(param1Int, param1MonitoredResourceDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1MonitoredResourceDescriptor);
      return this;
    }
    
    public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addMonitoredResources(MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoredResourceDescriptor != null) {
          ensureMonitoredResourcesIsMutable();
          this.monitoredResources_.add(param1MonitoredResourceDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1MonitoredResourceDescriptor);
      return this;
    }
    
    public MonitoredResourceDescriptor.Builder addMonitoredResourcesBuilder() {
      return (MonitoredResourceDescriptor.Builder)getMonitoredResourcesFieldBuilder().addBuilder((AbstractMessage)MonitoredResourceDescriptor.getDefaultInstance());
    }
    
    public MonitoredResourceDescriptor.Builder addMonitoredResourcesBuilder(int param1Int) {
      return (MonitoredResourceDescriptor.Builder)getMonitoredResourcesFieldBuilder().addBuilder(param1Int, (AbstractMessage)MonitoredResourceDescriptor.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addTypes(int param1Int, Type.Builder param1Builder) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureTypesIsMutable();
        this.types_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addTypes(int param1Int, Type param1Type) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Type != null) {
          ensureTypesIsMutable();
          this.types_.add(param1Int, param1Type);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Type);
      return this;
    }
    
    public Builder addTypes(Type.Builder param1Builder) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureTypesIsMutable();
        this.types_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addTypes(Type param1Type) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Type != null) {
          ensureTypesIsMutable();
          this.types_.add(param1Type);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Type);
      return this;
    }
    
    public Type.Builder addTypesBuilder() {
      return (Type.Builder)getTypesFieldBuilder().addBuilder((AbstractMessage)Type.getDefaultInstance());
    }
    
    public Type.Builder addTypesBuilder(int param1Int) {
      return (Type.Builder)getTypesFieldBuilder().addBuilder(param1Int, (AbstractMessage)Type.getDefaultInstance());
    }
    
    public Service build() {
      Service service = buildPartial();
      if (service.isInitialized())
        return service; 
      throw newUninitializedMessageException(service);
    }
    
    public Service buildPartial() {
      Service service = new Service(this);
      int i = this.bitField0_;
      SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV313 = this.configVersionBuilder_;
      if (singleFieldBuilderV313 == null) {
        Service.access$402(service, this.configVersion_);
      } else {
        Service.access$402(service, (UInt32Value)singleFieldBuilderV313.build());
      } 
      Service.access$502(service, this.name_);
      Service.access$602(service, this.id_);
      Service.access$702(service, this.title_);
      Service.access$802(service, this.producerProjectId_);
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV36 = this.apisBuilder_;
      if (repeatedFieldBuilderV36 == null) {
        if ((this.bitField0_ & 0x20) != 0) {
          this.apis_ = Collections.unmodifiableList(this.apis_);
          this.bitField0_ &= 0xFFFFFFDF;
        } 
        Service.access$902(service, this.apis_);
      } else {
        Service.access$902(service, repeatedFieldBuilderV36.build());
      } 
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV35 = this.typesBuilder_;
      if (repeatedFieldBuilderV35 == null) {
        if ((this.bitField0_ & 0x40) != 0) {
          this.types_ = Collections.unmodifiableList(this.types_);
          this.bitField0_ &= 0xFFFFFFBF;
        } 
        Service.access$1002(service, this.types_);
      } else {
        Service.access$1002(service, repeatedFieldBuilderV35.build());
      } 
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV34 = this.enumsBuilder_;
      if (repeatedFieldBuilderV34 == null) {
        if ((this.bitField0_ & 0x80) != 0) {
          this.enums_ = Collections.unmodifiableList(this.enums_);
          this.bitField0_ &= 0xFFFFFF7F;
        } 
        Service.access$1102(service, this.enums_);
      } else {
        Service.access$1102(service, repeatedFieldBuilderV34.build());
      } 
      SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV312 = this.documentationBuilder_;
      if (singleFieldBuilderV312 == null) {
        Service.access$1202(service, this.documentation_);
      } else {
        Service.access$1202(service, (Documentation)singleFieldBuilderV312.build());
      } 
      SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV311 = this.backendBuilder_;
      if (singleFieldBuilderV311 == null) {
        Service.access$1302(service, this.backend_);
      } else {
        Service.access$1302(service, (Backend)singleFieldBuilderV311.build());
      } 
      SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV310 = this.httpBuilder_;
      if (singleFieldBuilderV310 == null) {
        Service.access$1402(service, this.http_);
      } else {
        Service.access$1402(service, (Http)singleFieldBuilderV310.build());
      } 
      SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV39 = this.quotaBuilder_;
      if (singleFieldBuilderV39 == null) {
        Service.access$1502(service, this.quota_);
      } else {
        Service.access$1502(service, (Quota)singleFieldBuilderV39.build());
      } 
      SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV38 = this.authenticationBuilder_;
      if (singleFieldBuilderV38 == null) {
        Service.access$1602(service, this.authentication_);
      } else {
        Service.access$1602(service, (Authentication)singleFieldBuilderV38.build());
      } 
      SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV37 = this.contextBuilder_;
      if (singleFieldBuilderV37 == null) {
        Service.access$1702(service, this.context_);
      } else {
        Service.access$1702(service, (Context)singleFieldBuilderV37.build());
      } 
      SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV36 = this.usageBuilder_;
      if (singleFieldBuilderV36 == null) {
        Service.access$1802(service, this.usage_);
      } else {
        Service.access$1802(service, (Usage)singleFieldBuilderV36.build());
      } 
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV33 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV33 == null) {
        if ((this.bitField0_ & 0x8000) != 0) {
          this.endpoints_ = Collections.unmodifiableList(this.endpoints_);
          this.bitField0_ &= 0xFFFF7FFF;
        } 
        Service.access$1902(service, this.endpoints_);
      } else {
        Service.access$1902(service, repeatedFieldBuilderV33.build());
      } 
      SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV35 = this.controlBuilder_;
      if (singleFieldBuilderV35 == null) {
        Service.access$2002(service, this.control_);
      } else {
        Service.access$2002(service, (Control)singleFieldBuilderV35.build());
      } 
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV32 = this.logsBuilder_;
      if (repeatedFieldBuilderV32 == null) {
        if ((this.bitField0_ & 0x20000) != 0) {
          this.logs_ = Collections.unmodifiableList(this.logs_);
          this.bitField0_ &= 0xFFFDFFFF;
        } 
        Service.access$2102(service, this.logs_);
      } else {
        Service.access$2102(service, repeatedFieldBuilderV32.build());
      } 
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV31 = this.metricsBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        if ((this.bitField0_ & 0x40000) != 0) {
          this.metrics_ = Collections.unmodifiableList(this.metrics_);
          this.bitField0_ &= 0xFFFBFFFF;
        } 
        Service.access$2202(service, this.metrics_);
      } else {
        Service.access$2202(service, repeatedFieldBuilderV31.build());
      } 
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x80000) != 0) {
          this.monitoredResources_ = Collections.unmodifiableList(this.monitoredResources_);
          this.bitField0_ &= 0xFFF7FFFF;
        } 
        Service.access$2302(service, this.monitoredResources_);
      } else {
        Service.access$2302(service, repeatedFieldBuilderV3.build());
      } 
      SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV34 = this.billingBuilder_;
      if (singleFieldBuilderV34 == null) {
        Service.access$2402(service, this.billing_);
      } else {
        Service.access$2402(service, (Billing)singleFieldBuilderV34.build());
      } 
      SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV33 = this.loggingBuilder_;
      if (singleFieldBuilderV33 == null) {
        Service.access$2502(service, this.logging_);
      } else {
        Service.access$2502(service, (Logging)singleFieldBuilderV33.build());
      } 
      SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV32 = this.monitoringBuilder_;
      if (singleFieldBuilderV32 == null) {
        Service.access$2602(service, this.monitoring_);
      } else {
        Service.access$2602(service, (Monitoring)singleFieldBuilderV32.build());
      } 
      SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV31 = this.systemParametersBuilder_;
      if (singleFieldBuilderV31 == null) {
        Service.access$2702(service, this.systemParameters_);
      } else {
        Service.access$2702(service, (SystemParameters)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        Service.access$2802(service, this.sourceInfo_);
      } else {
        Service.access$2802(service, (SourceInfo)singleFieldBuilderV3.build());
      } 
      Service.access$2902(service, 0);
      onBuilt();
      return service;
    }
    
    public Builder clear() {
      super.clear();
      if (this.configVersionBuilder_ == null) {
        this.configVersion_ = null;
      } else {
        this.configVersion_ = null;
        this.configVersionBuilder_ = null;
      } 
      this.name_ = "";
      this.id_ = "";
      this.title_ = "";
      this.producerProjectId_ = "";
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV36 = this.apisBuilder_;
      if (repeatedFieldBuilderV36 == null) {
        this.apis_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFDF;
      } else {
        repeatedFieldBuilderV36.clear();
      } 
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV35 = this.typesBuilder_;
      if (repeatedFieldBuilderV35 == null) {
        this.types_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
      } else {
        repeatedFieldBuilderV35.clear();
      } 
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV34 = this.enumsBuilder_;
      if (repeatedFieldBuilderV34 == null) {
        this.enums_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFF7F;
      } else {
        repeatedFieldBuilderV34.clear();
      } 
      if (this.documentationBuilder_ == null) {
        this.documentation_ = null;
      } else {
        this.documentation_ = null;
        this.documentationBuilder_ = null;
      } 
      if (this.backendBuilder_ == null) {
        this.backend_ = null;
      } else {
        this.backend_ = null;
        this.backendBuilder_ = null;
      } 
      if (this.httpBuilder_ == null) {
        this.http_ = null;
      } else {
        this.http_ = null;
        this.httpBuilder_ = null;
      } 
      if (this.quotaBuilder_ == null) {
        this.quota_ = null;
      } else {
        this.quota_ = null;
        this.quotaBuilder_ = null;
      } 
      if (this.authenticationBuilder_ == null) {
        this.authentication_ = null;
      } else {
        this.authentication_ = null;
        this.authenticationBuilder_ = null;
      } 
      if (this.contextBuilder_ == null) {
        this.context_ = null;
      } else {
        this.context_ = null;
        this.contextBuilder_ = null;
      } 
      if (this.usageBuilder_ == null) {
        this.usage_ = null;
      } else {
        this.usage_ = null;
        this.usageBuilder_ = null;
      } 
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV33 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV33 == null) {
        this.endpoints_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFF7FFF;
      } else {
        repeatedFieldBuilderV33.clear();
      } 
      if (this.controlBuilder_ == null) {
        this.control_ = null;
      } else {
        this.control_ = null;
        this.controlBuilder_ = null;
      } 
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV32 = this.logsBuilder_;
      if (repeatedFieldBuilderV32 == null) {
        this.logs_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFDFFFF;
      } else {
        repeatedFieldBuilderV32.clear();
      } 
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV31 = this.metricsBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        this.metrics_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFBFFFF;
      } else {
        repeatedFieldBuilderV31.clear();
      } 
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.monitoredResources_ = Collections.emptyList();
        this.bitField0_ &= 0xFFF7FFFF;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      if (this.billingBuilder_ == null) {
        this.billing_ = null;
      } else {
        this.billing_ = null;
        this.billingBuilder_ = null;
      } 
      if (this.loggingBuilder_ == null) {
        this.logging_ = null;
      } else {
        this.logging_ = null;
        this.loggingBuilder_ = null;
      } 
      if (this.monitoringBuilder_ == null) {
        this.monitoring_ = null;
      } else {
        this.monitoring_ = null;
        this.monitoringBuilder_ = null;
      } 
      if (this.systemParametersBuilder_ == null) {
        this.systemParameters_ = null;
      } else {
        this.systemParameters_ = null;
        this.systemParametersBuilder_ = null;
      } 
      if (this.sourceInfoBuilder_ == null) {
        this.sourceInfo_ = null;
        return this;
      } 
      this.sourceInfo_ = null;
      this.sourceInfoBuilder_ = null;
      return this;
    }
    
    public Builder clearApis() {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.apis_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFDF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearAuthentication() {
      if (this.authenticationBuilder_ == null) {
        this.authentication_ = null;
        onChanged();
        return this;
      } 
      this.authentication_ = null;
      this.authenticationBuilder_ = null;
      return this;
    }
    
    public Builder clearBackend() {
      if (this.backendBuilder_ == null) {
        this.backend_ = null;
        onChanged();
        return this;
      } 
      this.backend_ = null;
      this.backendBuilder_ = null;
      return this;
    }
    
    public Builder clearBilling() {
      if (this.billingBuilder_ == null) {
        this.billing_ = null;
        onChanged();
        return this;
      } 
      this.billing_ = null;
      this.billingBuilder_ = null;
      return this;
    }
    
    public Builder clearConfigVersion() {
      if (this.configVersionBuilder_ == null) {
        this.configVersion_ = null;
        onChanged();
        return this;
      } 
      this.configVersion_ = null;
      this.configVersionBuilder_ = null;
      return this;
    }
    
    public Builder clearContext() {
      if (this.contextBuilder_ == null) {
        this.context_ = null;
        onChanged();
        return this;
      } 
      this.context_ = null;
      this.contextBuilder_ = null;
      return this;
    }
    
    public Builder clearControl() {
      if (this.controlBuilder_ == null) {
        this.control_ = null;
        onChanged();
        return this;
      } 
      this.control_ = null;
      this.controlBuilder_ = null;
      return this;
    }
    
    public Builder clearDocumentation() {
      if (this.documentationBuilder_ == null) {
        this.documentation_ = null;
        onChanged();
        return this;
      } 
      this.documentation_ = null;
      this.documentationBuilder_ = null;
      return this;
    }
    
    public Builder clearEndpoints() {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.endpoints_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFF7FFF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearEnums() {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.enums_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFF7F;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHttp() {
      if (this.httpBuilder_ == null) {
        this.http_ = null;
        onChanged();
        return this;
      } 
      this.http_ = null;
      this.httpBuilder_ = null;
      return this;
    }
    
    public Builder clearId() {
      this.id_ = Service.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearLogging() {
      if (this.loggingBuilder_ == null) {
        this.logging_ = null;
        onChanged();
        return this;
      } 
      this.logging_ = null;
      this.loggingBuilder_ = null;
      return this;
    }
    
    public Builder clearLogs() {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.logs_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFDFFFF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearMetrics() {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.metrics_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFBFFFF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearMonitoredResources() {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.monitoredResources_ = Collections.emptyList();
        this.bitField0_ &= 0xFFF7FFFF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearMonitoring() {
      if (this.monitoringBuilder_ == null) {
        this.monitoring_ = null;
        onChanged();
        return this;
      } 
      this.monitoring_ = null;
      this.monitoringBuilder_ = null;
      return this;
    }
    
    public Builder clearName() {
      this.name_ = Service.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProducerProjectId() {
      this.producerProjectId_ = Service.getDefaultInstance().getProducerProjectId();
      onChanged();
      return this;
    }
    
    public Builder clearQuota() {
      if (this.quotaBuilder_ == null) {
        this.quota_ = null;
        onChanged();
        return this;
      } 
      this.quota_ = null;
      this.quotaBuilder_ = null;
      return this;
    }
    
    public Builder clearSourceInfo() {
      if (this.sourceInfoBuilder_ == null) {
        this.sourceInfo_ = null;
        onChanged();
        return this;
      } 
      this.sourceInfo_ = null;
      this.sourceInfoBuilder_ = null;
      return this;
    }
    
    public Builder clearSystemParameters() {
      if (this.systemParametersBuilder_ == null) {
        this.systemParameters_ = null;
        onChanged();
        return this;
      } 
      this.systemParameters_ = null;
      this.systemParametersBuilder_ = null;
      return this;
    }
    
    public Builder clearTitle() {
      this.title_ = Service.getDefaultInstance().getTitle();
      onChanged();
      return this;
    }
    
    public Builder clearTypes() {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.types_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearUsage() {
      if (this.usageBuilder_ == null) {
        this.usage_ = null;
        onChanged();
        return this;
      } 
      this.usage_ = null;
      this.usageBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Api getApis(int param1Int) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.apis_.get(param1Int) : (Api)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Api.Builder getApisBuilder(int param1Int) {
      return (Api.Builder)getApisFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Api.Builder> getApisBuilderList() {
      return getApisFieldBuilder().getBuilderList();
    }
    
    public int getApisCount() {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.apis_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Api> getApisList() {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.apis_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public ApiOrBuilder getApisOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (ApiOrBuilder)this.apis_.get(param1Int) : (ApiOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.apis_);
    }
    
    public Authentication getAuthentication() {
      Authentication authentication;
      SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
      if (singleFieldBuilderV3 == null) {
        Authentication authentication1 = this.authentication_;
        authentication = authentication1;
        if (authentication1 == null)
          authentication = Authentication.getDefaultInstance(); 
        return authentication;
      } 
      return (Authentication)authentication.getMessage();
    }
    
    public Authentication.Builder getAuthenticationBuilder() {
      onChanged();
      return (Authentication.Builder)getAuthenticationFieldBuilder().getBuilder();
    }
    
    public AuthenticationOrBuilder getAuthenticationOrBuilder() {
      SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AuthenticationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Authentication authentication2 = this.authentication_;
      Authentication authentication1 = authentication2;
      if (authentication2 == null)
        authentication1 = Authentication.getDefaultInstance(); 
      return authentication1;
    }
    
    public Backend getBackend() {
      Backend backend;
      SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
      if (singleFieldBuilderV3 == null) {
        Backend backend1 = this.backend_;
        backend = backend1;
        if (backend1 == null)
          backend = Backend.getDefaultInstance(); 
        return backend;
      } 
      return (Backend)backend.getMessage();
    }
    
    public Backend.Builder getBackendBuilder() {
      onChanged();
      return (Backend.Builder)getBackendFieldBuilder().getBuilder();
    }
    
    public BackendOrBuilder getBackendOrBuilder() {
      SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
      if (singleFieldBuilderV3 != null)
        return (BackendOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Backend backend2 = this.backend_;
      Backend backend1 = backend2;
      if (backend2 == null)
        backend1 = Backend.getDefaultInstance(); 
      return backend1;
    }
    
    public Billing getBilling() {
      Billing billing;
      SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
      if (singleFieldBuilderV3 == null) {
        Billing billing1 = this.billing_;
        billing = billing1;
        if (billing1 == null)
          billing = Billing.getDefaultInstance(); 
        return billing;
      } 
      return (Billing)billing.getMessage();
    }
    
    public Billing.Builder getBillingBuilder() {
      onChanged();
      return (Billing.Builder)getBillingFieldBuilder().getBuilder();
    }
    
    public BillingOrBuilder getBillingOrBuilder() {
      SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
      if (singleFieldBuilderV3 != null)
        return (BillingOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Billing billing2 = this.billing_;
      Billing billing1 = billing2;
      if (billing2 == null)
        billing1 = Billing.getDefaultInstance(); 
      return billing1;
    }
    
    public UInt32Value getConfigVersion() {
      UInt32Value uInt32Value;
      SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        UInt32Value uInt32Value1 = this.configVersion_;
        uInt32Value = uInt32Value1;
        if (uInt32Value1 == null)
          uInt32Value = UInt32Value.getDefaultInstance(); 
        return uInt32Value;
      } 
      return (UInt32Value)uInt32Value.getMessage();
    }
    
    public UInt32Value.Builder getConfigVersionBuilder() {
      onChanged();
      return (UInt32Value.Builder)getConfigVersionFieldBuilder().getBuilder();
    }
    
    public UInt32ValueOrBuilder getConfigVersionOrBuilder() {
      SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
      if (singleFieldBuilderV3 != null)
        return (UInt32ValueOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      UInt32Value uInt32Value2 = this.configVersion_;
      UInt32Value uInt32Value1 = uInt32Value2;
      if (uInt32Value2 == null)
        uInt32Value1 = UInt32Value.getDefaultInstance(); 
      return (UInt32ValueOrBuilder)uInt32Value1;
    }
    
    public Context getContext() {
      Context context;
      SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
      if (singleFieldBuilderV3 == null) {
        Context context1 = this.context_;
        context = context1;
        if (context1 == null)
          context = Context.getDefaultInstance(); 
        return context;
      } 
      return (Context)context.getMessage();
    }
    
    public Context.Builder getContextBuilder() {
      onChanged();
      return (Context.Builder)getContextFieldBuilder().getBuilder();
    }
    
    public ContextOrBuilder getContextOrBuilder() {
      SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
      if (singleFieldBuilderV3 != null)
        return (ContextOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Context context2 = this.context_;
      Context context1 = context2;
      if (context2 == null)
        context1 = Context.getDefaultInstance(); 
      return context1;
    }
    
    public Control getControl() {
      Control control;
      SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
      if (singleFieldBuilderV3 == null) {
        Control control1 = this.control_;
        control = control1;
        if (control1 == null)
          control = Control.getDefaultInstance(); 
        return control;
      } 
      return (Control)control.getMessage();
    }
    
    public Control.Builder getControlBuilder() {
      onChanged();
      return (Control.Builder)getControlFieldBuilder().getBuilder();
    }
    
    public ControlOrBuilder getControlOrBuilder() {
      SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
      if (singleFieldBuilderV3 != null)
        return (ControlOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Control control2 = this.control_;
      Control control1 = control2;
      if (control2 == null)
        control1 = Control.getDefaultInstance(); 
      return control1;
    }
    
    public Service getDefaultInstanceForType() {
      return Service.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ServiceProto.a;
    }
    
    public Documentation getDocumentation() {
      Documentation documentation;
      SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
      if (singleFieldBuilderV3 == null) {
        Documentation documentation1 = this.documentation_;
        documentation = documentation1;
        if (documentation1 == null)
          documentation = Documentation.getDefaultInstance(); 
        return documentation;
      } 
      return (Documentation)documentation.getMessage();
    }
    
    public Documentation.Builder getDocumentationBuilder() {
      onChanged();
      return (Documentation.Builder)getDocumentationFieldBuilder().getBuilder();
    }
    
    public DocumentationOrBuilder getDocumentationOrBuilder() {
      SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
      if (singleFieldBuilderV3 != null)
        return (DocumentationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Documentation documentation2 = this.documentation_;
      Documentation documentation1 = documentation2;
      if (documentation2 == null)
        documentation1 = Documentation.getDefaultInstance(); 
      return documentation1;
    }
    
    public Endpoint getEndpoints(int param1Int) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.endpoints_.get(param1Int) : (Endpoint)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Endpoint.Builder getEndpointsBuilder(int param1Int) {
      return (Endpoint.Builder)getEndpointsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Endpoint.Builder> getEndpointsBuilderList() {
      return getEndpointsFieldBuilder().getBuilderList();
    }
    
    public int getEndpointsCount() {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.endpoints_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Endpoint> getEndpointsList() {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.endpoints_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public EndpointOrBuilder getEndpointsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.endpoints_.get(param1Int) : (EndpointOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.endpoints_);
    }
    
    public Enum getEnums(int param1Int) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.enums_.get(param1Int) : (Enum)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Enum.Builder getEnumsBuilder(int param1Int) {
      return (Enum.Builder)getEnumsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Enum.Builder> getEnumsBuilderList() {
      return getEnumsFieldBuilder().getBuilderList();
    }
    
    public int getEnumsCount() {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.enums_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Enum> getEnumsList() {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.enums_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public EnumOrBuilder getEnumsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (EnumOrBuilder)this.enums_.get(param1Int) : (EnumOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.enums_);
    }
    
    public Http getHttp() {
      Http http;
      SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
      if (singleFieldBuilderV3 == null) {
        Http http1 = this.http_;
        http = http1;
        if (http1 == null)
          http = Http.getDefaultInstance(); 
        return http;
      } 
      return (Http)http.getMessage();
    }
    
    public Http.Builder getHttpBuilder() {
      onChanged();
      return (Http.Builder)getHttpFieldBuilder().getBuilder();
    }
    
    public HttpOrBuilder getHttpOrBuilder() {
      SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
      if (singleFieldBuilderV3 != null)
        return (HttpOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Http http2 = this.http_;
      Http http1 = http2;
      if (http2 == null)
        http1 = Http.getDefaultInstance(); 
      return http1;
    }
    
    public String getId() {
      Object object = this.id_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.id_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIdBytes() {
      Object object = this.id_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.id_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Logging getLogging() {
      Logging logging;
      SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
      if (singleFieldBuilderV3 == null) {
        Logging logging1 = this.logging_;
        logging = logging1;
        if (logging1 == null)
          logging = Logging.getDefaultInstance(); 
        return logging;
      } 
      return (Logging)logging.getMessage();
    }
    
    public Logging.Builder getLoggingBuilder() {
      onChanged();
      return (Logging.Builder)getLoggingFieldBuilder().getBuilder();
    }
    
    public LoggingOrBuilder getLoggingOrBuilder() {
      SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
      if (singleFieldBuilderV3 != null)
        return (LoggingOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Logging logging2 = this.logging_;
      Logging logging1 = logging2;
      if (logging2 == null)
        logging1 = Logging.getDefaultInstance(); 
      return logging1;
    }
    
    public LogDescriptor getLogs(int param1Int) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.logs_.get(param1Int) : (LogDescriptor)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public LogDescriptor.Builder getLogsBuilder(int param1Int) {
      return (LogDescriptor.Builder)getLogsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<LogDescriptor.Builder> getLogsBuilderList() {
      return getLogsFieldBuilder().getBuilderList();
    }
    
    public int getLogsCount() {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.logs_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<LogDescriptor> getLogsList() {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.logs_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public LogDescriptorOrBuilder getLogsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.logs_.get(param1Int) : (LogDescriptorOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.logs_);
    }
    
    public MetricDescriptor getMetrics(int param1Int) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.metrics_.get(param1Int) : (MetricDescriptor)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public MetricDescriptor.Builder getMetricsBuilder(int param1Int) {
      return (MetricDescriptor.Builder)getMetricsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<MetricDescriptor.Builder> getMetricsBuilderList() {
      return getMetricsFieldBuilder().getBuilderList();
    }
    
    public int getMetricsCount() {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.metrics_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<MetricDescriptor> getMetricsList() {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.metrics_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public MetricDescriptorOrBuilder getMetricsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.metrics_.get(param1Int) : (MetricDescriptorOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.metrics_);
    }
    
    public MonitoredResourceDescriptor getMonitoredResources(int param1Int) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.monitoredResources_.get(param1Int) : (MonitoredResourceDescriptor)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public MonitoredResourceDescriptor.Builder getMonitoredResourcesBuilder(int param1Int) {
      return (MonitoredResourceDescriptor.Builder)getMonitoredResourcesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<MonitoredResourceDescriptor.Builder> getMonitoredResourcesBuilderList() {
      return getMonitoredResourcesFieldBuilder().getBuilderList();
    }
    
    public int getMonitoredResourcesCount() {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.monitoredResources_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.monitoredResources_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.monitoredResources_.get(param1Int) : (MonitoredResourceDescriptorOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.monitoredResources_);
    }
    
    public Monitoring getMonitoring() {
      Monitoring monitoring;
      SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
      if (singleFieldBuilderV3 == null) {
        Monitoring monitoring1 = this.monitoring_;
        monitoring = monitoring1;
        if (monitoring1 == null)
          monitoring = Monitoring.getDefaultInstance(); 
        return monitoring;
      } 
      return (Monitoring)monitoring.getMessage();
    }
    
    public Monitoring.Builder getMonitoringBuilder() {
      onChanged();
      return (Monitoring.Builder)getMonitoringFieldBuilder().getBuilder();
    }
    
    public MonitoringOrBuilder getMonitoringOrBuilder() {
      SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MonitoringOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Monitoring monitoring2 = this.monitoring_;
      Monitoring monitoring1 = monitoring2;
      if (monitoring2 == null)
        monitoring1 = Monitoring.getDefaultInstance(); 
      return monitoring1;
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
    
    public String getProducerProjectId() {
      Object object = this.producerProjectId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.producerProjectId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getProducerProjectIdBytes() {
      Object object = this.producerProjectId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.producerProjectId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Quota getQuota() {
      Quota quota;
      SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
      if (singleFieldBuilderV3 == null) {
        Quota quota1 = this.quota_;
        quota = quota1;
        if (quota1 == null)
          quota = Quota.getDefaultInstance(); 
        return quota;
      } 
      return (Quota)quota.getMessage();
    }
    
    public Quota.Builder getQuotaBuilder() {
      onChanged();
      return (Quota.Builder)getQuotaFieldBuilder().getBuilder();
    }
    
    public QuotaOrBuilder getQuotaOrBuilder() {
      SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
      if (singleFieldBuilderV3 != null)
        return (QuotaOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Quota quota2 = this.quota_;
      Quota quota1 = quota2;
      if (quota2 == null)
        quota1 = Quota.getDefaultInstance(); 
      return quota1;
    }
    
    public SourceInfo getSourceInfo() {
      SourceInfo sourceInfo;
      SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        SourceInfo sourceInfo1 = this.sourceInfo_;
        sourceInfo = sourceInfo1;
        if (sourceInfo1 == null)
          sourceInfo = SourceInfo.getDefaultInstance(); 
        return sourceInfo;
      } 
      return (SourceInfo)sourceInfo.getMessage();
    }
    
    public SourceInfo.Builder getSourceInfoBuilder() {
      onChanged();
      return (SourceInfo.Builder)getSourceInfoFieldBuilder().getBuilder();
    }
    
    public SourceInfoOrBuilder getSourceInfoOrBuilder() {
      SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
      if (singleFieldBuilderV3 != null)
        return (SourceInfoOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      SourceInfo sourceInfo2 = this.sourceInfo_;
      SourceInfo sourceInfo1 = sourceInfo2;
      if (sourceInfo2 == null)
        sourceInfo1 = SourceInfo.getDefaultInstance(); 
      return sourceInfo1;
    }
    
    public SystemParameters getSystemParameters() {
      SystemParameters systemParameters;
      SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
      if (singleFieldBuilderV3 == null) {
        SystemParameters systemParameters1 = this.systemParameters_;
        systemParameters = systemParameters1;
        if (systemParameters1 == null)
          systemParameters = SystemParameters.getDefaultInstance(); 
        return systemParameters;
      } 
      return (SystemParameters)systemParameters.getMessage();
    }
    
    public SystemParameters.Builder getSystemParametersBuilder() {
      onChanged();
      return (SystemParameters.Builder)getSystemParametersFieldBuilder().getBuilder();
    }
    
    public SystemParametersOrBuilder getSystemParametersOrBuilder() {
      SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
      if (singleFieldBuilderV3 != null)
        return (SystemParametersOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      SystemParameters systemParameters2 = this.systemParameters_;
      SystemParameters systemParameters1 = systemParameters2;
      if (systemParameters2 == null)
        systemParameters1 = SystemParameters.getDefaultInstance(); 
      return systemParameters1;
    }
    
    public String getTitle() {
      Object object = this.title_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.title_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTitleBytes() {
      Object object = this.title_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.title_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Type getTypes(int param1Int) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.types_.get(param1Int) : (Type)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Type.Builder getTypesBuilder(int param1Int) {
      return (Type.Builder)getTypesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Type.Builder> getTypesBuilderList() {
      return getTypesFieldBuilder().getBuilderList();
    }
    
    public int getTypesCount() {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.types_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Type> getTypesList() {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.types_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public TypeOrBuilder getTypesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (TypeOrBuilder)this.types_.get(param1Int) : (TypeOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.types_);
    }
    
    public Usage getUsage() {
      Usage usage;
      SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
      if (singleFieldBuilderV3 == null) {
        Usage usage1 = this.usage_;
        usage = usage1;
        if (usage1 == null)
          usage = Usage.getDefaultInstance(); 
        return usage;
      } 
      return (Usage)usage.getMessage();
    }
    
    public Usage.Builder getUsageBuilder() {
      onChanged();
      return (Usage.Builder)getUsageFieldBuilder().getBuilder();
    }
    
    public UsageOrBuilder getUsageOrBuilder() {
      SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
      if (singleFieldBuilderV3 != null)
        return (UsageOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Usage usage2 = this.usage_;
      Usage usage1 = usage2;
      if (usage2 == null)
        usage1 = Usage.getDefaultInstance(); 
      return usage1;
    }
    
    public boolean hasAuthentication() {
      return (this.authenticationBuilder_ != null || this.authentication_ != null);
    }
    
    public boolean hasBackend() {
      return (this.backendBuilder_ != null || this.backend_ != null);
    }
    
    public boolean hasBilling() {
      return (this.billingBuilder_ != null || this.billing_ != null);
    }
    
    public boolean hasConfigVersion() {
      return (this.configVersionBuilder_ != null || this.configVersion_ != null);
    }
    
    public boolean hasContext() {
      return (this.contextBuilder_ != null || this.context_ != null);
    }
    
    public boolean hasControl() {
      return (this.controlBuilder_ != null || this.control_ != null);
    }
    
    public boolean hasDocumentation() {
      return (this.documentationBuilder_ != null || this.documentation_ != null);
    }
    
    public boolean hasHttp() {
      return (this.httpBuilder_ != null || this.http_ != null);
    }
    
    public boolean hasLogging() {
      return (this.loggingBuilder_ != null || this.logging_ != null);
    }
    
    public boolean hasMonitoring() {
      return (this.monitoringBuilder_ != null || this.monitoring_ != null);
    }
    
    public boolean hasQuota() {
      return (this.quotaBuilder_ != null || this.quota_ != null);
    }
    
    public boolean hasSourceInfo() {
      return (this.sourceInfoBuilder_ != null || this.sourceInfo_ != null);
    }
    
    public boolean hasSystemParameters() {
      return (this.systemParametersBuilder_ != null || this.systemParameters_ != null);
    }
    
    public boolean hasUsage() {
      return (this.usageBuilder_ != null || this.usage_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ServiceProto.b.ensureFieldAccessorsInitialized(Service.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeAuthentication(Authentication param1Authentication) {
      Authentication authentication;
      SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
      if (singleFieldBuilderV3 == null) {
        authentication = this.authentication_;
        if (authentication != null) {
          this.authentication_ = Authentication.newBuilder(authentication).mergeFrom(param1Authentication).buildPartial();
        } else {
          this.authentication_ = param1Authentication;
        } 
        onChanged();
        return this;
      } 
      authentication.mergeFrom((AbstractMessage)param1Authentication);
      return this;
    }
    
    public Builder mergeBackend(Backend param1Backend) {
      Backend backend;
      SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
      if (singleFieldBuilderV3 == null) {
        backend = this.backend_;
        if (backend != null) {
          this.backend_ = Backend.newBuilder(backend).mergeFrom(param1Backend).buildPartial();
        } else {
          this.backend_ = param1Backend;
        } 
        onChanged();
        return this;
      } 
      backend.mergeFrom((AbstractMessage)param1Backend);
      return this;
    }
    
    public Builder mergeBilling(Billing param1Billing) {
      Billing billing;
      SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
      if (singleFieldBuilderV3 == null) {
        billing = this.billing_;
        if (billing != null) {
          this.billing_ = Billing.newBuilder(billing).mergeFrom(param1Billing).buildPartial();
        } else {
          this.billing_ = param1Billing;
        } 
        onChanged();
        return this;
      } 
      billing.mergeFrom((AbstractMessage)param1Billing);
      return this;
    }
    
    public Builder mergeConfigVersion(UInt32Value param1UInt32Value) {
      UInt32Value uInt32Value;
      SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        uInt32Value = this.configVersion_;
        if (uInt32Value != null) {
          this.configVersion_ = UInt32Value.newBuilder(uInt32Value).mergeFrom(param1UInt32Value).buildPartial();
        } else {
          this.configVersion_ = param1UInt32Value;
        } 
        onChanged();
        return this;
      } 
      uInt32Value.mergeFrom((AbstractMessage)param1UInt32Value);
      return this;
    }
    
    public Builder mergeContext(Context param1Context) {
      Context context;
      SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
      if (singleFieldBuilderV3 == null) {
        context = this.context_;
        if (context != null) {
          this.context_ = Context.newBuilder(context).mergeFrom(param1Context).buildPartial();
        } else {
          this.context_ = param1Context;
        } 
        onChanged();
        return this;
      } 
      context.mergeFrom((AbstractMessage)param1Context);
      return this;
    }
    
    public Builder mergeControl(Control param1Control) {
      Control control;
      SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
      if (singleFieldBuilderV3 == null) {
        control = this.control_;
        if (control != null) {
          this.control_ = Control.newBuilder(control).mergeFrom(param1Control).buildPartial();
        } else {
          this.control_ = param1Control;
        } 
        onChanged();
        return this;
      } 
      control.mergeFrom((AbstractMessage)param1Control);
      return this;
    }
    
    public Builder mergeDocumentation(Documentation param1Documentation) {
      Documentation documentation;
      SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
      if (singleFieldBuilderV3 == null) {
        documentation = this.documentation_;
        if (documentation != null) {
          this.documentation_ = Documentation.newBuilder(documentation).mergeFrom(param1Documentation).buildPartial();
        } else {
          this.documentation_ = param1Documentation;
        } 
        onChanged();
        return this;
      } 
      documentation.mergeFrom((AbstractMessage)param1Documentation);
      return this;
    }
    
    public Builder mergeFrom(Service param1Service) {
      if (param1Service == Service.getDefaultInstance())
        return this; 
      if (param1Service.hasConfigVersion())
        mergeConfigVersion(param1Service.getConfigVersion()); 
      if (!param1Service.getName().isEmpty()) {
        this.name_ = param1Service.name_;
        onChanged();
      } 
      if (!param1Service.getId().isEmpty()) {
        this.id_ = param1Service.id_;
        onChanged();
      } 
      if (!param1Service.getTitle().isEmpty()) {
        this.title_ = param1Service.title_;
        onChanged();
      } 
      if (!param1Service.getProducerProjectId().isEmpty()) {
        this.producerProjectId_ = param1Service.producerProjectId_;
        onChanged();
      } 
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Service.apis_.isEmpty()) {
          if (this.apis_.isEmpty()) {
            this.apis_ = param1Service.apis_;
            this.bitField0_ &= 0xFFFFFFDF;
          } else {
            ensureApisIsMutable();
            this.apis_.addAll(param1Service.apis_);
          } 
          onChanged();
        } 
      } else if (!param1Service.apis_.isEmpty()) {
        if (this.apisBuilder_.isEmpty()) {
          this.apisBuilder_.dispose();
          this.apisBuilder_ = null;
          this.apis_ = param1Service.apis_;
          this.bitField0_ &= 0xFFFFFFDF;
          if (Service.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getApisFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.apisBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.apisBuilder_.addAllMessages(param1Service.apis_);
        } 
      } 
      if (this.typesBuilder_ == null) {
        if (!param1Service.types_.isEmpty()) {
          if (this.types_.isEmpty()) {
            this.types_ = param1Service.types_;
            this.bitField0_ &= 0xFFFFFFBF;
          } else {
            ensureTypesIsMutable();
            this.types_.addAll(param1Service.types_);
          } 
          onChanged();
        } 
      } else if (!param1Service.types_.isEmpty()) {
        if (this.typesBuilder_.isEmpty()) {
          this.typesBuilder_.dispose();
          this.typesBuilder_ = null;
          this.types_ = param1Service.types_;
          this.bitField0_ &= 0xFFFFFFBF;
          if (Service.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getTypesFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.typesBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.typesBuilder_.addAllMessages(param1Service.types_);
        } 
      } 
      if (this.enumsBuilder_ == null) {
        if (!param1Service.enums_.isEmpty()) {
          if (this.enums_.isEmpty()) {
            this.enums_ = param1Service.enums_;
            this.bitField0_ &= 0xFFFFFF7F;
          } else {
            ensureEnumsIsMutable();
            this.enums_.addAll(param1Service.enums_);
          } 
          onChanged();
        } 
      } else if (!param1Service.enums_.isEmpty()) {
        if (this.enumsBuilder_.isEmpty()) {
          this.enumsBuilder_.dispose();
          this.enumsBuilder_ = null;
          this.enums_ = param1Service.enums_;
          this.bitField0_ &= 0xFFFFFF7F;
          if (Service.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getEnumsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.enumsBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.enumsBuilder_.addAllMessages(param1Service.enums_);
        } 
      } 
      if (param1Service.hasDocumentation())
        mergeDocumentation(param1Service.getDocumentation()); 
      if (param1Service.hasBackend())
        mergeBackend(param1Service.getBackend()); 
      if (param1Service.hasHttp())
        mergeHttp(param1Service.getHttp()); 
      if (param1Service.hasQuota())
        mergeQuota(param1Service.getQuota()); 
      if (param1Service.hasAuthentication())
        mergeAuthentication(param1Service.getAuthentication()); 
      if (param1Service.hasContext())
        mergeContext(param1Service.getContext()); 
      if (param1Service.hasUsage())
        mergeUsage(param1Service.getUsage()); 
      if (this.endpointsBuilder_ == null) {
        if (!param1Service.endpoints_.isEmpty()) {
          if (this.endpoints_.isEmpty()) {
            this.endpoints_ = param1Service.endpoints_;
            this.bitField0_ &= 0xFFFF7FFF;
          } else {
            ensureEndpointsIsMutable();
            this.endpoints_.addAll(param1Service.endpoints_);
          } 
          onChanged();
        } 
      } else if (!param1Service.endpoints_.isEmpty()) {
        if (this.endpointsBuilder_.isEmpty()) {
          this.endpointsBuilder_.dispose();
          this.endpointsBuilder_ = null;
          this.endpoints_ = param1Service.endpoints_;
          this.bitField0_ &= 0xFFFF7FFF;
          if (Service.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getEndpointsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.endpointsBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.endpointsBuilder_.addAllMessages(param1Service.endpoints_);
        } 
      } 
      if (param1Service.hasControl())
        mergeControl(param1Service.getControl()); 
      if (this.logsBuilder_ == null) {
        if (!param1Service.logs_.isEmpty()) {
          if (this.logs_.isEmpty()) {
            this.logs_ = param1Service.logs_;
            this.bitField0_ &= 0xFFFDFFFF;
          } else {
            ensureLogsIsMutable();
            this.logs_.addAll(param1Service.logs_);
          } 
          onChanged();
        } 
      } else if (!param1Service.logs_.isEmpty()) {
        if (this.logsBuilder_.isEmpty()) {
          this.logsBuilder_.dispose();
          this.logsBuilder_ = null;
          this.logs_ = param1Service.logs_;
          this.bitField0_ &= 0xFFFDFFFF;
          if (Service.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getLogsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.logsBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.logsBuilder_.addAllMessages(param1Service.logs_);
        } 
      } 
      if (this.metricsBuilder_ == null) {
        if (!param1Service.metrics_.isEmpty()) {
          if (this.metrics_.isEmpty()) {
            this.metrics_ = param1Service.metrics_;
            this.bitField0_ &= 0xFFFBFFFF;
          } else {
            ensureMetricsIsMutable();
            this.metrics_.addAll(param1Service.metrics_);
          } 
          onChanged();
        } 
      } else if (!param1Service.metrics_.isEmpty()) {
        if (this.metricsBuilder_.isEmpty()) {
          this.metricsBuilder_.dispose();
          this.metricsBuilder_ = null;
          this.metrics_ = param1Service.metrics_;
          this.bitField0_ &= 0xFFFBFFFF;
          if (Service.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getMetricsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.metricsBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.metricsBuilder_.addAllMessages(param1Service.metrics_);
        } 
      } 
      if (this.monitoredResourcesBuilder_ == null) {
        if (!param1Service.monitoredResources_.isEmpty()) {
          if (this.monitoredResources_.isEmpty()) {
            this.monitoredResources_ = param1Service.monitoredResources_;
            this.bitField0_ &= 0xFFF7FFFF;
          } else {
            ensureMonitoredResourcesIsMutable();
            this.monitoredResources_.addAll(param1Service.monitoredResources_);
          } 
          onChanged();
        } 
      } else if (!param1Service.monitoredResources_.isEmpty()) {
        if (this.monitoredResourcesBuilder_.isEmpty()) {
          this.monitoredResourcesBuilder_.dispose();
          this.monitoredResourcesBuilder_ = null;
          this.monitoredResources_ = param1Service.monitoredResources_;
          this.bitField0_ &= 0xFFF7FFFF;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (Service.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getMonitoredResourcesFieldBuilder(); 
          this.monitoredResourcesBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.monitoredResourcesBuilder_.addAllMessages(param1Service.monitoredResources_);
        } 
      } 
      if (param1Service.hasBilling())
        mergeBilling(param1Service.getBilling()); 
      if (param1Service.hasLogging())
        mergeLogging(param1Service.getLogging()); 
      if (param1Service.hasMonitoring())
        mergeMonitoring(param1Service.getMonitoring()); 
      if (param1Service.hasSystemParameters())
        mergeSystemParameters(param1Service.getSystemParameters()); 
      if (param1Service.hasSourceInfo())
        mergeSourceInfo(param1Service.getSourceInfo()); 
      mergeUnknownFields(param1Service.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Service service = (Service)Service.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Service service = (Service)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Service)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Service)
        return mergeFrom((Service)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeHttp(Http param1Http) {
      Http http;
      SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
      if (singleFieldBuilderV3 == null) {
        http = this.http_;
        if (http != null) {
          this.http_ = Http.newBuilder(http).mergeFrom(param1Http).buildPartial();
        } else {
          this.http_ = param1Http;
        } 
        onChanged();
        return this;
      } 
      http.mergeFrom((AbstractMessage)param1Http);
      return this;
    }
    
    public Builder mergeLogging(Logging param1Logging) {
      Logging logging;
      SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
      if (singleFieldBuilderV3 == null) {
        logging = this.logging_;
        if (logging != null) {
          this.logging_ = Logging.newBuilder(logging).mergeFrom(param1Logging).buildPartial();
        } else {
          this.logging_ = param1Logging;
        } 
        onChanged();
        return this;
      } 
      logging.mergeFrom((AbstractMessage)param1Logging);
      return this;
    }
    
    public Builder mergeMonitoring(Monitoring param1Monitoring) {
      Monitoring monitoring;
      SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
      if (singleFieldBuilderV3 == null) {
        monitoring = this.monitoring_;
        if (monitoring != null) {
          this.monitoring_ = Monitoring.newBuilder(monitoring).mergeFrom(param1Monitoring).buildPartial();
        } else {
          this.monitoring_ = param1Monitoring;
        } 
        onChanged();
        return this;
      } 
      monitoring.mergeFrom((AbstractMessage)param1Monitoring);
      return this;
    }
    
    public Builder mergeQuota(Quota param1Quota) {
      Quota quota;
      SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
      if (singleFieldBuilderV3 == null) {
        quota = this.quota_;
        if (quota != null) {
          this.quota_ = Quota.newBuilder(quota).mergeFrom(param1Quota).buildPartial();
        } else {
          this.quota_ = param1Quota;
        } 
        onChanged();
        return this;
      } 
      quota.mergeFrom((AbstractMessage)param1Quota);
      return this;
    }
    
    public Builder mergeSourceInfo(SourceInfo param1SourceInfo) {
      SourceInfo sourceInfo;
      SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        sourceInfo = this.sourceInfo_;
        if (sourceInfo != null) {
          this.sourceInfo_ = SourceInfo.newBuilder(sourceInfo).mergeFrom(param1SourceInfo).buildPartial();
        } else {
          this.sourceInfo_ = param1SourceInfo;
        } 
        onChanged();
        return this;
      } 
      sourceInfo.mergeFrom((AbstractMessage)param1SourceInfo);
      return this;
    }
    
    public Builder mergeSystemParameters(SystemParameters param1SystemParameters) {
      SystemParameters systemParameters;
      SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
      if (singleFieldBuilderV3 == null) {
        systemParameters = this.systemParameters_;
        if (systemParameters != null) {
          this.systemParameters_ = SystemParameters.newBuilder(systemParameters).mergeFrom(param1SystemParameters).buildPartial();
        } else {
          this.systemParameters_ = param1SystemParameters;
        } 
        onChanged();
        return this;
      } 
      systemParameters.mergeFrom((AbstractMessage)param1SystemParameters);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder mergeUsage(Usage param1Usage) {
      Usage usage;
      SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
      if (singleFieldBuilderV3 == null) {
        usage = this.usage_;
        if (usage != null) {
          this.usage_ = Usage.newBuilder(usage).mergeFrom(param1Usage).buildPartial();
        } else {
          this.usage_ = param1Usage;
        } 
        onChanged();
        return this;
      } 
      usage.mergeFrom((AbstractMessage)param1Usage);
      return this;
    }
    
    public Builder removeApis(int param1Int) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureApisIsMutable();
        this.apis_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeEndpoints(int param1Int) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEndpointsIsMutable();
        this.endpoints_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeEnums(int param1Int) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEnumsIsMutable();
        this.enums_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeLogs(int param1Int) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLogsIsMutable();
        this.logs_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeMetrics(int param1Int) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricsIsMutable();
        this.metrics_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeMonitoredResources(int param1Int) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeTypes(int param1Int) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureTypesIsMutable();
        this.types_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setApis(int param1Int, Api.Builder param1Builder) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureApisIsMutable();
        this.apis_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setApis(int param1Int, Api param1Api) {
      RepeatedFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> repeatedFieldBuilderV3 = this.apisBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Api != null) {
          ensureApisIsMutable();
          this.apis_.set(param1Int, param1Api);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Api);
      return this;
    }
    
    public Builder setAuthentication(Authentication.Builder param1Builder) {
      SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.authentication_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAuthentication(Authentication param1Authentication) {
      SingleFieldBuilderV3<Authentication, Authentication.Builder, AuthenticationOrBuilder> singleFieldBuilderV3 = this.authenticationBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Authentication != null) {
          this.authentication_ = param1Authentication;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Authentication);
      return this;
    }
    
    public Builder setBackend(Backend.Builder param1Builder) {
      SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.backend_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setBackend(Backend param1Backend) {
      SingleFieldBuilderV3<Backend, Backend.Builder, BackendOrBuilder> singleFieldBuilderV3 = this.backendBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Backend != null) {
          this.backend_ = param1Backend;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Backend);
      return this;
    }
    
    public Builder setBilling(Billing.Builder param1Builder) {
      SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.billing_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setBilling(Billing param1Billing) {
      SingleFieldBuilderV3<Billing, Billing.Builder, BillingOrBuilder> singleFieldBuilderV3 = this.billingBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Billing != null) {
          this.billing_ = param1Billing;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Billing);
      return this;
    }
    
    public Builder setConfigVersion(UInt32Value.Builder param1Builder) {
      SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.configVersion_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setConfigVersion(UInt32Value param1UInt32Value) {
      SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.configVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1UInt32Value != null) {
          this.configVersion_ = param1UInt32Value;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1UInt32Value);
      return this;
    }
    
    public Builder setContext(Context.Builder param1Builder) {
      SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.context_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setContext(Context param1Context) {
      SingleFieldBuilderV3<Context, Context.Builder, ContextOrBuilder> singleFieldBuilderV3 = this.contextBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Context != null) {
          this.context_ = param1Context;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Context);
      return this;
    }
    
    public Builder setControl(Control.Builder param1Builder) {
      SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.control_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setControl(Control param1Control) {
      SingleFieldBuilderV3<Control, Control.Builder, ControlOrBuilder> singleFieldBuilderV3 = this.controlBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Control != null) {
          this.control_ = param1Control;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Control);
      return this;
    }
    
    public Builder setDocumentation(Documentation.Builder param1Builder) {
      SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.documentation_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setDocumentation(Documentation param1Documentation) {
      SingleFieldBuilderV3<Documentation, Documentation.Builder, DocumentationOrBuilder> singleFieldBuilderV3 = this.documentationBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Documentation != null) {
          this.documentation_ = param1Documentation;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Documentation);
      return this;
    }
    
    public Builder setEndpoints(int param1Int, Endpoint.Builder param1Builder) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEndpointsIsMutable();
        this.endpoints_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setEndpoints(int param1Int, Endpoint param1Endpoint) {
      RepeatedFieldBuilderV3<Endpoint, Endpoint.Builder, EndpointOrBuilder> repeatedFieldBuilderV3 = this.endpointsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Endpoint != null) {
          ensureEndpointsIsMutable();
          this.endpoints_.set(param1Int, param1Endpoint);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Endpoint);
      return this;
    }
    
    public Builder setEnums(int param1Int, Enum.Builder param1Builder) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureEnumsIsMutable();
        this.enums_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setEnums(int param1Int, Enum param1Enum) {
      RepeatedFieldBuilderV3<Enum, Enum.Builder, EnumOrBuilder> repeatedFieldBuilderV3 = this.enumsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Enum != null) {
          ensureEnumsIsMutable();
          this.enums_.set(param1Int, param1Enum);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Enum);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHttp(Http.Builder param1Builder) {
      SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.http_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setHttp(Http param1Http) {
      SingleFieldBuilderV3<Http, Http.Builder, HttpOrBuilder> singleFieldBuilderV3 = this.httpBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Http != null) {
          this.http_ = param1Http;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Http);
      return this;
    }
    
    public Builder setId(String param1String) {
      if (param1String != null) {
        this.id_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Service.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLogging(Logging.Builder param1Builder) {
      SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.logging_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLogging(Logging param1Logging) {
      SingleFieldBuilderV3<Logging, Logging.Builder, LoggingOrBuilder> singleFieldBuilderV3 = this.loggingBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Logging != null) {
          this.logging_ = param1Logging;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Logging);
      return this;
    }
    
    public Builder setLogs(int param1Int, LogDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLogsIsMutable();
        this.logs_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLogs(int param1Int, LogDescriptor param1LogDescriptor) {
      RepeatedFieldBuilderV3<LogDescriptor, LogDescriptor.Builder, LogDescriptorOrBuilder> repeatedFieldBuilderV3 = this.logsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LogDescriptor != null) {
          ensureLogsIsMutable();
          this.logs_.set(param1Int, param1LogDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1LogDescriptor);
      return this;
    }
    
    public Builder setMetrics(int param1Int, MetricDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricsIsMutable();
        this.metrics_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMetrics(int param1Int, MetricDescriptor param1MetricDescriptor) {
      RepeatedFieldBuilderV3<MetricDescriptor, MetricDescriptor.Builder, MetricDescriptorOrBuilder> repeatedFieldBuilderV3 = this.metricsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MetricDescriptor != null) {
          ensureMetricsIsMutable();
          this.metrics_.set(param1Int, param1MetricDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1MetricDescriptor);
      return this;
    }
    
    public Builder setMonitoredResources(int param1Int, MonitoredResourceDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMonitoredResources(int param1Int, MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      RepeatedFieldBuilderV3<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder, MonitoredResourceDescriptorOrBuilder> repeatedFieldBuilderV3 = this.monitoredResourcesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoredResourceDescriptor != null) {
          ensureMonitoredResourcesIsMutable();
          this.monitoredResources_.set(param1Int, param1MonitoredResourceDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1MonitoredResourceDescriptor);
      return this;
    }
    
    public Builder setMonitoring(Monitoring.Builder param1Builder) {
      SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.monitoring_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMonitoring(Monitoring param1Monitoring) {
      SingleFieldBuilderV3<Monitoring, Monitoring.Builder, MonitoringOrBuilder> singleFieldBuilderV3 = this.monitoringBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Monitoring != null) {
          this.monitoring_ = param1Monitoring;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Monitoring);
      return this;
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
        Service.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setProducerProjectId(String param1String) {
      if (param1String != null) {
        this.producerProjectId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setProducerProjectIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Service.checkByteStringIsUtf8(param1ByteString);
        this.producerProjectId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setQuota(Quota.Builder param1Builder) {
      SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.quota_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setQuota(Quota param1Quota) {
      SingleFieldBuilderV3<Quota, Quota.Builder, QuotaOrBuilder> singleFieldBuilderV3 = this.quotaBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Quota != null) {
          this.quota_ = param1Quota;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Quota);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSourceInfo(SourceInfo.Builder param1Builder) {
      SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.sourceInfo_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSourceInfo(SourceInfo param1SourceInfo) {
      SingleFieldBuilderV3<SourceInfo, SourceInfo.Builder, SourceInfoOrBuilder> singleFieldBuilderV3 = this.sourceInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1SourceInfo != null) {
          this.sourceInfo_ = param1SourceInfo;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1SourceInfo);
      return this;
    }
    
    public Builder setSystemParameters(SystemParameters.Builder param1Builder) {
      SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.systemParameters_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSystemParameters(SystemParameters param1SystemParameters) {
      SingleFieldBuilderV3<SystemParameters, SystemParameters.Builder, SystemParametersOrBuilder> singleFieldBuilderV3 = this.systemParametersBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1SystemParameters != null) {
          this.systemParameters_ = param1SystemParameters;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1SystemParameters);
      return this;
    }
    
    public Builder setTitle(String param1String) {
      if (param1String != null) {
        this.title_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTitleBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Service.checkByteStringIsUtf8(param1ByteString);
        this.title_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypes(int param1Int, Type.Builder param1Builder) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureTypesIsMutable();
        this.types_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setTypes(int param1Int, Type param1Type) {
      RepeatedFieldBuilderV3<Type, Type.Builder, TypeOrBuilder> repeatedFieldBuilderV3 = this.typesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Type != null) {
          ensureTypesIsMutable();
          this.types_.set(param1Int, param1Type);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Type);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUsage(Usage.Builder param1Builder) {
      SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.usage_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setUsage(Usage param1Usage) {
      SingleFieldBuilderV3<Usage, Usage.Builder, UsageOrBuilder> singleFieldBuilderV3 = this.usageBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Usage != null) {
          this.usage_ = param1Usage;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Usage);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
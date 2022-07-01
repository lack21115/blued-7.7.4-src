package com.google.logging.type;

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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class HttpRequest extends GeneratedMessageV3 implements HttpRequestOrBuilder {
  public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
  
  public static final int CACHE_HIT_FIELD_NUMBER = 9;
  
  public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
  
  public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
  
  private static final HttpRequest DEFAULT_INSTANCE = new HttpRequest();
  
  public static final int LATENCY_FIELD_NUMBER = 14;
  
  private static final Parser<HttpRequest> PARSER = (Parser<HttpRequest>)new AbstractParser<HttpRequest>() {
      public HttpRequest a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new HttpRequest(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PROTOCOL_FIELD_NUMBER = 15;
  
  public static final int REFERER_FIELD_NUMBER = 8;
  
  public static final int REMOTE_IP_FIELD_NUMBER = 7;
  
  public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
  
  public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
  
  public static final int REQUEST_URL_FIELD_NUMBER = 2;
  
  public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
  
  public static final int SERVER_IP_FIELD_NUMBER = 13;
  
  public static final int STATUS_FIELD_NUMBER = 4;
  
  public static final int USER_AGENT_FIELD_NUMBER = 6;
  
  private static final long serialVersionUID = 0L;
  
  private long cacheFillBytes_;
  
  private boolean cacheHit_;
  
  private boolean cacheLookup_;
  
  private boolean cacheValidatedWithOriginServer_;
  
  private Duration latency_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object protocol_;
  
  private volatile Object referer_;
  
  private volatile Object remoteIp_;
  
  private volatile Object requestMethod_;
  
  private long requestSize_;
  
  private volatile Object requestUrl_;
  
  private long responseSize_;
  
  private volatile Object serverIp_;
  
  private int status_;
  
  private volatile Object userAgent_;
  
  private HttpRequest() {
    this.requestMethod_ = "";
    this.requestUrl_ = "";
    this.userAgent_ = "";
    this.remoteIp_ = "";
    this.serverIp_ = "";
    this.referer_ = "";
    this.protocol_ = "";
  }
  
  private HttpRequest(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      boolean bool = false;
      while (!bool) {
        try {
          Duration.Builder builder1;
          int i = paramCodedInputStream.readTag();
          switch (i) {
            case 122:
              this.protocol_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 114:
              builder1 = null;
              if (this.latency_ != null)
                builder1 = this.latency_.toBuilder(); 
              this.latency_ = (Duration)paramCodedInputStream.readMessage(Duration.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom(this.latency_);
                this.latency_ = builder1.buildPartial();
              } 
              continue;
            case 106:
              this.serverIp_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 96:
              this.cacheFillBytes_ = paramCodedInputStream.readInt64();
              continue;
            case 88:
              this.cacheLookup_ = paramCodedInputStream.readBool();
              continue;
            case 80:
              this.cacheValidatedWithOriginServer_ = paramCodedInputStream.readBool();
              continue;
            case 72:
              this.cacheHit_ = paramCodedInputStream.readBool();
              continue;
            case 66:
              this.referer_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 58:
              this.remoteIp_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 50:
              this.userAgent_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 40:
              this.responseSize_ = paramCodedInputStream.readInt64();
              continue;
            case 32:
              this.status_ = paramCodedInputStream.readInt32();
              continue;
            case 24:
              this.requestSize_ = paramCodedInputStream.readInt64();
              continue;
            case 18:
              this.requestUrl_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 10:
              this.requestMethod_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 0:
              bool = true;
              continue;
          } 
          boolean bool1 = parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i);
          if (!bool1);
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
  
  private HttpRequest(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static HttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return HttpRequestProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpRequest paramHttpRequest) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramHttpRequest);
  }
  
  public static HttpRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static HttpRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpRequest)PARSER.parseFrom(paramByteString);
  }
  
  public static HttpRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static HttpRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static HttpRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (HttpRequest)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static HttpRequest parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpRequest)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static HttpRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpRequest> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof HttpRequest))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRequestMethod().equals(paramObject.getRequestMethod()) ? false : (!getRequestUrl().equals(paramObject.getRequestUrl()) ? false : ((getRequestSize() != paramObject.getRequestSize()) ? false : ((getStatus() != paramObject.getStatus()) ? false : ((getResponseSize() != paramObject.getResponseSize()) ? false : (!getUserAgent().equals(paramObject.getUserAgent()) ? false : (!getRemoteIp().equals(paramObject.getRemoteIp()) ? false : (!getServerIp().equals(paramObject.getServerIp()) ? false : (!getReferer().equals(paramObject.getReferer()) ? false : ((hasLatency() != paramObject.hasLatency()) ? false : ((hasLatency() && !getLatency().equals(paramObject.getLatency())) ? false : ((getCacheLookup() != paramObject.getCacheLookup()) ? false : ((getCacheHit() != paramObject.getCacheHit()) ? false : ((getCacheValidatedWithOriginServer() != paramObject.getCacheValidatedWithOriginServer()) ? false : ((getCacheFillBytes() != paramObject.getCacheFillBytes()) ? false : (!getProtocol().equals(paramObject.getProtocol()) ? false : (!!this.unknownFields.equals(((HttpRequest)paramObject).unknownFields)))))))))))))))));
  }
  
  public long getCacheFillBytes() {
    return this.cacheFillBytes_;
  }
  
  public boolean getCacheHit() {
    return this.cacheHit_;
  }
  
  public boolean getCacheLookup() {
    return this.cacheLookup_;
  }
  
  public boolean getCacheValidatedWithOriginServer() {
    return this.cacheValidatedWithOriginServer_;
  }
  
  public HttpRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Duration getLatency() {
    Duration duration2 = this.latency_;
    Duration duration1 = duration2;
    if (duration2 == null)
      duration1 = Duration.getDefaultInstance(); 
    return duration1;
  }
  
  public DurationOrBuilder getLatencyOrBuilder() {
    return (DurationOrBuilder)getLatency();
  }
  
  public Parser<HttpRequest> getParserForType() {
    return PARSER;
  }
  
  public String getProtocol() {
    Object object = this.protocol_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.protocol_ = object;
    return (String)object;
  }
  
  public ByteString getProtocolBytes() {
    Object object = this.protocol_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.protocol_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getReferer() {
    Object object = this.referer_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.referer_ = object;
    return (String)object;
  }
  
  public ByteString getRefererBytes() {
    Object object = this.referer_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.referer_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getRemoteIp() {
    Object object = this.remoteIp_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.remoteIp_ = object;
    return (String)object;
  }
  
  public ByteString getRemoteIpBytes() {
    Object object = this.remoteIp_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.remoteIp_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getRequestMethod() {
    Object object = this.requestMethod_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.requestMethod_ = object;
    return (String)object;
  }
  
  public ByteString getRequestMethodBytes() {
    Object object = this.requestMethod_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.requestMethod_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public long getRequestSize() {
    return this.requestSize_;
  }
  
  public String getRequestUrl() {
    Object object = this.requestUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.requestUrl_ = object;
    return (String)object;
  }
  
  public ByteString getRequestUrlBytes() {
    Object object = this.requestUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.requestUrl_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public long getResponseSize() {
    return this.responseSize_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getRequestMethodBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.requestMethod_); 
    int j = i;
    if (!getRequestUrlBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.requestUrl_); 
    long l = this.requestSize_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(3, l); 
    int k = this.status_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(4, k); 
    l = this.responseSize_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(5, l); 
    j = i;
    if (!getUserAgentBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(6, this.userAgent_); 
    i = j;
    if (!getRemoteIpBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(7, this.remoteIp_); 
    j = i;
    if (!getRefererBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(8, this.referer_); 
    boolean bool = this.cacheHit_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(9, bool); 
    bool = this.cacheValidatedWithOriginServer_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(10, bool); 
    bool = this.cacheLookup_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(11, bool); 
    l = this.cacheFillBytes_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(12, l); 
    i = j;
    if (!getServerIpBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(13, this.serverIp_); 
    j = i;
    if (this.latency_ != null)
      j = i + CodedOutputStream.computeMessageSize(14, (MessageLite)getLatency()); 
    i = j;
    if (!getProtocolBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(15, this.protocol_); 
    i += this.unknownFields.getSerializedSize();
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
  
  public int getStatus() {
    return this.status_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public String getUserAgent() {
    Object object = this.userAgent_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.userAgent_ = object;
    return (String)object;
  }
  
  public ByteString getUserAgentBytes() {
    Object object = this.userAgent_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.userAgent_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public boolean hasLatency() {
    return (this.latency_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getRequestMethod().hashCode()) * 37 + 2) * 53 + getRequestUrl().hashCode()) * 37 + 3) * 53 + Internal.hashLong(getRequestSize())) * 37 + 4) * 53 + getStatus()) * 37 + 5) * 53 + Internal.hashLong(getResponseSize())) * 37 + 6) * 53 + getUserAgent().hashCode()) * 37 + 7) * 53 + getRemoteIp().hashCode()) * 37 + 13) * 53 + getServerIp().hashCode()) * 37 + 8) * 53 + getReferer().hashCode();
    int i = j;
    if (hasLatency())
      i = (j * 37 + 14) * 53 + getLatency().hashCode(); 
    i = ((((((((((i * 37 + 11) * 53 + Internal.hashBoolean(getCacheLookup())) * 37 + 9) * 53 + Internal.hashBoolean(getCacheHit())) * 37 + 10) * 53 + Internal.hashBoolean(getCacheValidatedWithOriginServer())) * 37 + 12) * 53 + Internal.hashLong(getCacheFillBytes())) * 37 + 15) * 53 + getProtocol().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return HttpRequestProto.b.ensureFieldAccessorsInitialized(HttpRequest.class, Builder.class);
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
    if (!getRequestMethodBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.requestMethod_); 
    if (!getRequestUrlBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.requestUrl_); 
    long l = this.requestSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(3, l); 
    int i = this.status_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
    l = this.responseSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(5, l); 
    if (!getUserAgentBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.userAgent_); 
    if (!getRemoteIpBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.remoteIp_); 
    if (!getRefererBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.referer_); 
    boolean bool = this.cacheHit_;
    if (bool)
      paramCodedOutputStream.writeBool(9, bool); 
    bool = this.cacheValidatedWithOriginServer_;
    if (bool)
      paramCodedOutputStream.writeBool(10, bool); 
    bool = this.cacheLookup_;
    if (bool)
      paramCodedOutputStream.writeBool(11, bool); 
    l = this.cacheFillBytes_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(12, l); 
    if (!getServerIpBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 13, this.serverIp_); 
    if (this.latency_ != null)
      paramCodedOutputStream.writeMessage(14, (MessageLite)getLatency()); 
    if (!getProtocolBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 15, this.protocol_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpRequestOrBuilder {
    private long cacheFillBytes_;
    
    private boolean cacheHit_;
    
    private boolean cacheLookup_;
    
    private boolean cacheValidatedWithOriginServer_;
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> latencyBuilder_;
    
    private Duration latency_;
    
    private Object protocol_ = "";
    
    private Object referer_ = "";
    
    private Object remoteIp_ = "";
    
    private Object requestMethod_ = "";
    
    private long requestSize_;
    
    private Object requestUrl_ = "";
    
    private long responseSize_;
    
    private Object serverIp_ = "";
    
    private int status_;
    
    private Object userAgent_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return HttpRequestProto.a;
    }
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getLatencyFieldBuilder() {
      if (this.latencyBuilder_ == null) {
        this.latencyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLatency(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.latency_ = null;
      } 
      return this.latencyBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      HttpRequest.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public HttpRequest build() {
      HttpRequest httpRequest = buildPartial();
      if (httpRequest.isInitialized())
        return httpRequest; 
      throw newUninitializedMessageException(httpRequest);
    }
    
    public HttpRequest buildPartial() {
      HttpRequest httpRequest = new HttpRequest(this);
      HttpRequest.access$402(httpRequest, this.requestMethod_);
      HttpRequest.access$502(httpRequest, this.requestUrl_);
      HttpRequest.access$602(httpRequest, this.requestSize_);
      HttpRequest.access$702(httpRequest, this.status_);
      HttpRequest.access$802(httpRequest, this.responseSize_);
      HttpRequest.access$902(httpRequest, this.userAgent_);
      HttpRequest.access$1002(httpRequest, this.remoteIp_);
      HttpRequest.access$1102(httpRequest, this.serverIp_);
      HttpRequest.access$1202(httpRequest, this.referer_);
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
      if (singleFieldBuilderV3 == null) {
        HttpRequest.access$1302(httpRequest, this.latency_);
      } else {
        HttpRequest.access$1302(httpRequest, (Duration)singleFieldBuilderV3.build());
      } 
      HttpRequest.access$1402(httpRequest, this.cacheLookup_);
      HttpRequest.access$1502(httpRequest, this.cacheHit_);
      HttpRequest.access$1602(httpRequest, this.cacheValidatedWithOriginServer_);
      HttpRequest.access$1702(httpRequest, this.cacheFillBytes_);
      HttpRequest.access$1802(httpRequest, this.protocol_);
      onBuilt();
      return httpRequest;
    }
    
    public Builder clear() {
      super.clear();
      this.requestMethod_ = "";
      this.requestUrl_ = "";
      this.requestSize_ = 0L;
      this.status_ = 0;
      this.responseSize_ = 0L;
      this.userAgent_ = "";
      this.remoteIp_ = "";
      this.serverIp_ = "";
      this.referer_ = "";
      if (this.latencyBuilder_ == null) {
        this.latency_ = null;
      } else {
        this.latency_ = null;
        this.latencyBuilder_ = null;
      } 
      this.cacheLookup_ = false;
      this.cacheHit_ = false;
      this.cacheValidatedWithOriginServer_ = false;
      this.cacheFillBytes_ = 0L;
      this.protocol_ = "";
      return this;
    }
    
    public Builder clearCacheFillBytes() {
      this.cacheFillBytes_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearCacheHit() {
      this.cacheHit_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearCacheLookup() {
      this.cacheLookup_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearCacheValidatedWithOriginServer() {
      this.cacheValidatedWithOriginServer_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLatency() {
      if (this.latencyBuilder_ == null) {
        this.latency_ = null;
        onChanged();
        return this;
      } 
      this.latency_ = null;
      this.latencyBuilder_ = null;
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProtocol() {
      this.protocol_ = HttpRequest.getDefaultInstance().getProtocol();
      onChanged();
      return this;
    }
    
    public Builder clearReferer() {
      this.referer_ = HttpRequest.getDefaultInstance().getReferer();
      onChanged();
      return this;
    }
    
    public Builder clearRemoteIp() {
      this.remoteIp_ = HttpRequest.getDefaultInstance().getRemoteIp();
      onChanged();
      return this;
    }
    
    public Builder clearRequestMethod() {
      this.requestMethod_ = HttpRequest.getDefaultInstance().getRequestMethod();
      onChanged();
      return this;
    }
    
    public Builder clearRequestSize() {
      this.requestSize_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearRequestUrl() {
      this.requestUrl_ = HttpRequest.getDefaultInstance().getRequestUrl();
      onChanged();
      return this;
    }
    
    public Builder clearResponseSize() {
      this.responseSize_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = HttpRequest.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clearStatus() {
      this.status_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearUserAgent() {
      this.userAgent_ = HttpRequest.getDefaultInstance().getUserAgent();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public long getCacheFillBytes() {
      return this.cacheFillBytes_;
    }
    
    public boolean getCacheHit() {
      return this.cacheHit_;
    }
    
    public boolean getCacheLookup() {
      return this.cacheLookup_;
    }
    
    public boolean getCacheValidatedWithOriginServer() {
      return this.cacheValidatedWithOriginServer_;
    }
    
    public HttpRequest getDefaultInstanceForType() {
      return HttpRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return HttpRequestProto.a;
    }
    
    public Duration getLatency() {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
      if (singleFieldBuilderV3 == null) {
        Duration duration1 = this.latency_;
        duration = duration1;
        if (duration1 == null)
          duration = Duration.getDefaultInstance(); 
        return duration;
      } 
      return (Duration)duration.getMessage();
    }
    
    public Duration.Builder getLatencyBuilder() {
      onChanged();
      return (Duration.Builder)getLatencyFieldBuilder().getBuilder();
    }
    
    public DurationOrBuilder getLatencyOrBuilder() {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
      if (singleFieldBuilderV3 != null)
        return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Duration duration2 = this.latency_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return (DurationOrBuilder)duration1;
    }
    
    public String getProtocol() {
      Object object = this.protocol_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.protocol_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getProtocolBytes() {
      Object object = this.protocol_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.protocol_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getReferer() {
      Object object = this.referer_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.referer_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRefererBytes() {
      Object object = this.referer_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.referer_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRemoteIp() {
      Object object = this.remoteIp_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.remoteIp_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRemoteIpBytes() {
      Object object = this.remoteIp_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.remoteIp_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRequestMethod() {
      Object object = this.requestMethod_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.requestMethod_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRequestMethodBytes() {
      Object object = this.requestMethod_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestMethod_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getRequestSize() {
      return this.requestSize_;
    }
    
    public String getRequestUrl() {
      Object object = this.requestUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.requestUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRequestUrlBytes() {
      Object object = this.requestUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getResponseSize() {
      return this.responseSize_;
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
    
    public int getStatus() {
      return this.status_;
    }
    
    public String getUserAgent() {
      Object object = this.userAgent_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.userAgent_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUserAgentBytes() {
      Object object = this.userAgent_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.userAgent_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean hasLatency() {
      return (this.latencyBuilder_ != null || this.latency_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return HttpRequestProto.b.ensureFieldAccessorsInitialized(HttpRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(HttpRequest param1HttpRequest) {
      if (param1HttpRequest == HttpRequest.getDefaultInstance())
        return this; 
      if (!param1HttpRequest.getRequestMethod().isEmpty()) {
        this.requestMethod_ = param1HttpRequest.requestMethod_;
        onChanged();
      } 
      if (!param1HttpRequest.getRequestUrl().isEmpty()) {
        this.requestUrl_ = param1HttpRequest.requestUrl_;
        onChanged();
      } 
      if (param1HttpRequest.getRequestSize() != 0L)
        setRequestSize(param1HttpRequest.getRequestSize()); 
      if (param1HttpRequest.getStatus() != 0)
        setStatus(param1HttpRequest.getStatus()); 
      if (param1HttpRequest.getResponseSize() != 0L)
        setResponseSize(param1HttpRequest.getResponseSize()); 
      if (!param1HttpRequest.getUserAgent().isEmpty()) {
        this.userAgent_ = param1HttpRequest.userAgent_;
        onChanged();
      } 
      if (!param1HttpRequest.getRemoteIp().isEmpty()) {
        this.remoteIp_ = param1HttpRequest.remoteIp_;
        onChanged();
      } 
      if (!param1HttpRequest.getServerIp().isEmpty()) {
        this.serverIp_ = param1HttpRequest.serverIp_;
        onChanged();
      } 
      if (!param1HttpRequest.getReferer().isEmpty()) {
        this.referer_ = param1HttpRequest.referer_;
        onChanged();
      } 
      if (param1HttpRequest.hasLatency())
        mergeLatency(param1HttpRequest.getLatency()); 
      if (param1HttpRequest.getCacheLookup())
        setCacheLookup(param1HttpRequest.getCacheLookup()); 
      if (param1HttpRequest.getCacheHit())
        setCacheHit(param1HttpRequest.getCacheHit()); 
      if (param1HttpRequest.getCacheValidatedWithOriginServer())
        setCacheValidatedWithOriginServer(param1HttpRequest.getCacheValidatedWithOriginServer()); 
      if (param1HttpRequest.getCacheFillBytes() != 0L)
        setCacheFillBytes(param1HttpRequest.getCacheFillBytes()); 
      if (!param1HttpRequest.getProtocol().isEmpty()) {
        this.protocol_ = param1HttpRequest.protocol_;
        onChanged();
      } 
      mergeUnknownFields(param1HttpRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        HttpRequest httpRequest = (HttpRequest)HttpRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        HttpRequest httpRequest = (HttpRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((HttpRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof HttpRequest)
        return mergeFrom((HttpRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeLatency(Duration param1Duration) {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
      if (singleFieldBuilderV3 == null) {
        duration = this.latency_;
        if (duration != null) {
          this.latency_ = Duration.newBuilder(duration).mergeFrom(param1Duration).buildPartial();
        } else {
          this.latency_ = param1Duration;
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
    
    public Builder setCacheFillBytes(long param1Long) {
      this.cacheFillBytes_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setCacheHit(boolean param1Boolean) {
      this.cacheHit_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setCacheLookup(boolean param1Boolean) {
      this.cacheLookup_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setCacheValidatedWithOriginServer(boolean param1Boolean) {
      this.cacheValidatedWithOriginServer_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLatency(Duration.Builder param1Builder) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.latency_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLatency(Duration param1Duration) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.latencyBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Duration != null) {
          this.latency_ = param1Duration;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Duration);
      return this;
    }
    
    public Builder setProtocol(String param1String) {
      if (param1String != null) {
        this.protocol_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setProtocolBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.protocol_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setReferer(String param1String) {
      if (param1String != null) {
        this.referer_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRefererBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.referer_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRemoteIp(String param1String) {
      if (param1String != null) {
        this.remoteIp_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRemoteIpBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.remoteIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequestMethod(String param1String) {
      if (param1String != null) {
        this.requestMethod_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestMethodBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.requestMethod_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestSize(long param1Long) {
      this.requestSize_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setRequestUrl(String param1String) {
      if (param1String != null) {
        this.requestUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.requestUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponseSize(long param1Long) {
      this.responseSize_ = param1Long;
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
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setStatus(int param1Int) {
      this.status_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUserAgent(String param1String) {
      if (param1String != null) {
        this.userAgent_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUserAgentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRequest.checkByteStringIsUtf8(param1ByteString);
        this.userAgent_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\logging\type\HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
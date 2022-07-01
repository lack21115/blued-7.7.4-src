package com.google.cloud.audit;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AuditLog extends GeneratedMessageV3 implements AuditLogOrBuilder {
  public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
  
  public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
  
  private static final AuditLog DEFAULT_INSTANCE = new AuditLog();
  
  public static final int METHOD_NAME_FIELD_NUMBER = 8;
  
  public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
  
  private static final Parser<AuditLog> PARSER = (Parser<AuditLog>)new AbstractParser<AuditLog>() {
      public AuditLog a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new AuditLog(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int REQUEST_FIELD_NUMBER = 16;
  
  public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
  
  public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
  
  public static final int RESPONSE_FIELD_NUMBER = 17;
  
  public static final int SERVICE_DATA_FIELD_NUMBER = 15;
  
  public static final int SERVICE_NAME_FIELD_NUMBER = 7;
  
  public static final int STATUS_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private AuthenticationInfo authenticationInfo_;
  
  private List<AuthorizationInfo> authorizationInfo_;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object methodName_;
  
  private long numResponseItems_;
  
  private RequestMetadata requestMetadata_;
  
  private Struct request_;
  
  private volatile Object resourceName_;
  
  private Struct response_;
  
  private Any serviceData_;
  
  private volatile Object serviceName_;
  
  private Status status_;
  
  private AuditLog() {
    this.serviceName_ = "";
    this.methodName_ = "";
    this.resourceName_ = "";
    this.authorizationInfo_ = Collections.emptyList();
  }
  
  private AuditLog(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
          Any.Builder builder4;
          RequestMetadata.Builder builder3;
          AuthenticationInfo.Builder builder2;
          Status.Builder builder1;
          int n = paramCodedInputStream.readTag();
          Struct.Builder builder6 = null;
          Struct.Builder builder7 = null;
          Any.Builder builder8 = null;
          RequestMetadata.Builder builder9 = null;
          AuthenticationInfo.Builder builder10 = null;
          Struct.Builder builder5 = null;
          switch (n) {
            case 138:
              j = i;
              k = i;
              m = i;
              if (this.response_ != null) {
                j = i;
                k = i;
                m = i;
                builder5 = this.response_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.response_ = (Struct)paramCodedInputStream.readMessage(Struct.parser(), paramExtensionRegistryLite);
              if (builder5 != null) {
                j = i;
                k = i;
                m = i;
                builder5.mergeFrom(this.response_);
                j = i;
                k = i;
                m = i;
                this.response_ = builder5.buildPartial();
              } 
              continue;
            case 130:
              builder5 = builder6;
              j = i;
              k = i;
              m = i;
              if (this.request_ != null) {
                j = i;
                k = i;
                m = i;
                builder5 = this.request_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.request_ = (Struct)paramCodedInputStream.readMessage(Struct.parser(), paramExtensionRegistryLite);
              if (builder5 != null) {
                j = i;
                k = i;
                m = i;
                builder5.mergeFrom(this.request_);
                j = i;
                k = i;
                m = i;
                this.request_ = builder5.buildPartial();
              } 
              continue;
            case 122:
              builder5 = builder7;
              j = i;
              k = i;
              m = i;
              if (this.serviceData_ != null) {
                j = i;
                k = i;
                m = i;
                builder4 = this.serviceData_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.serviceData_ = (Any)paramCodedInputStream.readMessage(Any.parser(), paramExtensionRegistryLite);
              if (builder4 != null) {
                j = i;
                k = i;
                m = i;
                builder4.mergeFrom(this.serviceData_);
                j = i;
                k = i;
                m = i;
                this.serviceData_ = builder4.buildPartial();
              } 
              continue;
            case 96:
              j = i;
              k = i;
              m = i;
              this.numResponseItems_ = paramCodedInputStream.readInt64();
              continue;
            case 90:
              j = i;
              k = i;
              m = i;
              this.resourceName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 74:
              n = i;
              if ((i & 0x40) == 0) {
                j = i;
                k = i;
                m = i;
                this.authorizationInfo_ = new ArrayList<AuthorizationInfo>();
                n = i | 0x40;
              } 
              j = n;
              k = n;
              m = n;
              this.authorizationInfo_.add(paramCodedInputStream.readMessage(AuthorizationInfo.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 66:
              j = i;
              k = i;
              m = i;
              this.methodName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 58:
              j = i;
              k = i;
              m = i;
              this.serviceName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 34:
              builder4 = builder8;
              j = i;
              k = i;
              m = i;
              if (this.requestMetadata_ != null) {
                j = i;
                k = i;
                m = i;
                builder3 = this.requestMetadata_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.requestMetadata_ = (RequestMetadata)paramCodedInputStream.readMessage(RequestMetadata.parser(), paramExtensionRegistryLite);
              if (builder3 != null) {
                j = i;
                k = i;
                m = i;
                builder3.mergeFrom(this.requestMetadata_);
                j = i;
                k = i;
                m = i;
                this.requestMetadata_ = builder3.buildPartial();
              } 
              continue;
            case 26:
              builder3 = builder9;
              j = i;
              k = i;
              m = i;
              if (this.authenticationInfo_ != null) {
                j = i;
                k = i;
                m = i;
                builder2 = this.authenticationInfo_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.authenticationInfo_ = (AuthenticationInfo)paramCodedInputStream.readMessage(AuthenticationInfo.parser(), paramExtensionRegistryLite);
              if (builder2 != null) {
                j = i;
                k = i;
                m = i;
                builder2.mergeFrom(this.authenticationInfo_);
                j = i;
                k = i;
                m = i;
                this.authenticationInfo_ = builder2.buildPartial();
              } 
              continue;
            case 18:
              builder2 = builder10;
              j = i;
              k = i;
              m = i;
              if (this.status_ != null) {
                j = i;
                k = i;
                m = i;
                builder1 = this.status_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.status_ = (Status)paramCodedInputStream.readMessage(Status.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                j = i;
                k = i;
                m = i;
                builder1.mergeFrom(this.status_);
                j = i;
                k = i;
                m = i;
                this.status_ = builder1.buildPartial();
              } 
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
        if ((j & 0x40) != 0)
          this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      if ((i & 0x40) != 0)
        this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private AuditLog(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static AuditLog getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuditLogProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuditLog paramAuditLog) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuditLog);
  }
  
  public static AuditLog parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuditLog)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static AuditLog parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuditLog)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuditLog)PARSER.parseFrom(paramByteString);
  }
  
  public static AuditLog parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuditLog)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuditLog)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static AuditLog parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuditLog)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(InputStream paramInputStream) throws IOException {
    return (AuditLog)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static AuditLog parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuditLog)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (AuditLog)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static AuditLog parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuditLog)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuditLog)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static AuditLog parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuditLog)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuditLog> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof AuditLog))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getServiceName().equals(paramObject.getServiceName()) ? false : (!getMethodName().equals(paramObject.getMethodName()) ? false : (!getResourceName().equals(paramObject.getResourceName()) ? false : ((getNumResponseItems() != paramObject.getNumResponseItems()) ? false : ((hasStatus() != paramObject.hasStatus()) ? false : ((hasStatus() && !getStatus().equals(paramObject.getStatus())) ? false : ((hasAuthenticationInfo() != paramObject.hasAuthenticationInfo()) ? false : ((hasAuthenticationInfo() && !getAuthenticationInfo().equals(paramObject.getAuthenticationInfo())) ? false : (!getAuthorizationInfoList().equals(paramObject.getAuthorizationInfoList()) ? false : ((hasRequestMetadata() != paramObject.hasRequestMetadata()) ? false : ((hasRequestMetadata() && !getRequestMetadata().equals(paramObject.getRequestMetadata())) ? false : ((hasRequest() != paramObject.hasRequest()) ? false : ((hasRequest() && !getRequest().equals(paramObject.getRequest())) ? false : ((hasResponse() != paramObject.hasResponse()) ? false : ((hasResponse() && !getResponse().equals(paramObject.getResponse())) ? false : ((hasServiceData() != paramObject.hasServiceData()) ? false : ((hasServiceData() && !getServiceData().equals(paramObject.getServiceData())) ? false : (!!this.unknownFields.equals(((AuditLog)paramObject).unknownFields))))))))))))))))));
  }
  
  public AuthenticationInfo getAuthenticationInfo() {
    AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
    AuthenticationInfo authenticationInfo1 = authenticationInfo2;
    if (authenticationInfo2 == null)
      authenticationInfo1 = AuthenticationInfo.getDefaultInstance(); 
    return authenticationInfo1;
  }
  
  public AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder() {
    return getAuthenticationInfo();
  }
  
  public AuthorizationInfo getAuthorizationInfo(int paramInt) {
    return this.authorizationInfo_.get(paramInt);
  }
  
  public int getAuthorizationInfoCount() {
    return this.authorizationInfo_.size();
  }
  
  public List<AuthorizationInfo> getAuthorizationInfoList() {
    return this.authorizationInfo_;
  }
  
  public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int paramInt) {
    return this.authorizationInfo_.get(paramInt);
  }
  
  public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
    return (List)this.authorizationInfo_;
  }
  
  public AuditLog getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getMethodName() {
    Object object = this.methodName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.methodName_ = object;
    return (String)object;
  }
  
  public ByteString getMethodNameBytes() {
    Object object = this.methodName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.methodName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public long getNumResponseItems() {
    return this.numResponseItems_;
  }
  
  public Parser<AuditLog> getParserForType() {
    return PARSER;
  }
  
  public Struct getRequest() {
    Struct struct2 = this.request_;
    Struct struct1 = struct2;
    if (struct2 == null)
      struct1 = Struct.getDefaultInstance(); 
    return struct1;
  }
  
  public RequestMetadata getRequestMetadata() {
    RequestMetadata requestMetadata2 = this.requestMetadata_;
    RequestMetadata requestMetadata1 = requestMetadata2;
    if (requestMetadata2 == null)
      requestMetadata1 = RequestMetadata.getDefaultInstance(); 
    return requestMetadata1;
  }
  
  public RequestMetadataOrBuilder getRequestMetadataOrBuilder() {
    return getRequestMetadata();
  }
  
  public StructOrBuilder getRequestOrBuilder() {
    return (StructOrBuilder)getRequest();
  }
  
  public String getResourceName() {
    Object object = this.resourceName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.resourceName_ = object;
    return (String)object;
  }
  
  public ByteString getResourceNameBytes() {
    Object object = this.resourceName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.resourceName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Struct getResponse() {
    Struct struct2 = this.response_;
    Struct struct1 = struct2;
    if (struct2 == null)
      struct1 = Struct.getDefaultInstance(); 
    return struct1;
  }
  
  public StructOrBuilder getResponseOrBuilder() {
    return (StructOrBuilder)getResponse();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    Status status = this.status_;
    boolean bool = false;
    if (status != null) {
      j = CodedOutputStream.computeMessageSize(2, (MessageLite)getStatus()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (this.authenticationInfo_ != null)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)getAuthenticationInfo()); 
    int k = i;
    if (this.requestMetadata_ != null)
      k = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getRequestMetadata()); 
    int j = k;
    if (!getServiceNameBytes().isEmpty())
      j = k + GeneratedMessageV3.computeStringSize(7, this.serviceName_); 
    i = j;
    k = bool;
    if (!getMethodNameBytes().isEmpty()) {
      i = j + GeneratedMessageV3.computeStringSize(8, this.methodName_);
      k = bool;
    } 
    while (k < this.authorizationInfo_.size()) {
      i += CodedOutputStream.computeMessageSize(9, (MessageLite)this.authorizationInfo_.get(k));
      k++;
    } 
    j = i;
    if (!getResourceNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(11, this.resourceName_); 
    long l = this.numResponseItems_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(12, l); 
    j = i;
    if (this.serviceData_ != null)
      j = i + CodedOutputStream.computeMessageSize(15, (MessageLite)getServiceData()); 
    i = j;
    if (this.request_ != null)
      i = j + CodedOutputStream.computeMessageSize(16, (MessageLite)getRequest()); 
    j = i;
    if (this.response_ != null)
      j = i + CodedOutputStream.computeMessageSize(17, (MessageLite)getResponse()); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public Any getServiceData() {
    Any any2 = this.serviceData_;
    Any any1 = any2;
    if (any2 == null)
      any1 = Any.getDefaultInstance(); 
    return any1;
  }
  
  public AnyOrBuilder getServiceDataOrBuilder() {
    return (AnyOrBuilder)getServiceData();
  }
  
  public String getServiceName() {
    Object object = this.serviceName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.serviceName_ = object;
    return (String)object;
  }
  
  public ByteString getServiceNameBytes() {
    Object object = this.serviceName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.serviceName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Status getStatus() {
    Status status2 = this.status_;
    Status status1 = status2;
    if (status2 == null)
      status1 = Status.getDefaultInstance(); 
    return status1;
  }
  
  public StatusOrBuilder getStatusOrBuilder() {
    return (StatusOrBuilder)getStatus();
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasAuthenticationInfo() {
    return (this.authenticationInfo_ != null);
  }
  
  public boolean hasRequest() {
    return (this.request_ != null);
  }
  
  public boolean hasRequestMetadata() {
    return (this.requestMetadata_ != null);
  }
  
  public boolean hasResponse() {
    return (this.response_ != null);
  }
  
  public boolean hasServiceData() {
    return (this.serviceData_ != null);
  }
  
  public boolean hasStatus() {
    return (this.status_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((((779 + getDescriptor().hashCode()) * 37 + 7) * 53 + getServiceName().hashCode()) * 37 + 8) * 53 + getMethodName().hashCode()) * 37 + 11) * 53 + getResourceName().hashCode()) * 37 + 12) * 53 + Internal.hashLong(getNumResponseItems());
    int i = j;
    if (hasStatus())
      i = (j * 37 + 2) * 53 + getStatus().hashCode(); 
    j = i;
    if (hasAuthenticationInfo())
      j = (i * 37 + 3) * 53 + getAuthenticationInfo().hashCode(); 
    i = j;
    if (getAuthorizationInfoCount() > 0)
      i = (j * 37 + 9) * 53 + getAuthorizationInfoList().hashCode(); 
    j = i;
    if (hasRequestMetadata())
      j = (i * 37 + 4) * 53 + getRequestMetadata().hashCode(); 
    i = j;
    if (hasRequest())
      i = (j * 37 + 16) * 53 + getRequest().hashCode(); 
    j = i;
    if (hasResponse())
      j = (i * 37 + 17) * 53 + getResponse().hashCode(); 
    i = j;
    if (hasServiceData())
      i = (j * 37 + 15) * 53 + getServiceData().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuditLogProto.b.ensureFieldAccessorsInitialized(AuditLog.class, Builder.class);
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
    if (this.status_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getStatus()); 
    if (this.authenticationInfo_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getAuthenticationInfo()); 
    if (this.requestMetadata_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getRequestMetadata()); 
    if (!getServiceNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.serviceName_); 
    if (!getMethodNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.methodName_); 
    for (int i = 0; i < this.authorizationInfo_.size(); i++)
      paramCodedOutputStream.writeMessage(9, (MessageLite)this.authorizationInfo_.get(i)); 
    if (!getResourceNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 11, this.resourceName_); 
    long l = this.numResponseItems_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(12, l); 
    if (this.serviceData_ != null)
      paramCodedOutputStream.writeMessage(15, (MessageLite)getServiceData()); 
    if (this.request_ != null)
      paramCodedOutputStream.writeMessage(16, (MessageLite)getRequest()); 
    if (this.response_ != null)
      paramCodedOutputStream.writeMessage(17, (MessageLite)getResponse()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuditLogOrBuilder {
    private SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> authenticationInfoBuilder_;
    
    private AuthenticationInfo authenticationInfo_;
    
    private RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> authorizationInfoBuilder_;
    
    private List<AuthorizationInfo> authorizationInfo_ = Collections.emptyList();
    
    private int bitField0_;
    
    private Object methodName_ = "";
    
    private long numResponseItems_;
    
    private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> requestBuilder_;
    
    private SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> requestMetadataBuilder_;
    
    private RequestMetadata requestMetadata_;
    
    private Struct request_;
    
    private Object resourceName_ = "";
    
    private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> responseBuilder_;
    
    private Struct response_;
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> serviceDataBuilder_;
    
    private Any serviceData_;
    
    private Object serviceName_ = "";
    
    private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> statusBuilder_;
    
    private Status status_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAuthorizationInfoIsMutable() {
      if ((this.bitField0_ & 0x40) == 0) {
        this.authorizationInfo_ = new ArrayList<AuthorizationInfo>(this.authorizationInfo_);
        this.bitField0_ |= 0x40;
      } 
    }
    
    private SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> getAuthenticationInfoFieldBuilder() {
      if (this.authenticationInfoBuilder_ == null) {
        this.authenticationInfoBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getAuthenticationInfo(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.authenticationInfo_ = null;
      } 
      return this.authenticationInfoBuilder_;
    }
    
    private RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> getAuthorizationInfoFieldBuilder() {
      if (this.authorizationInfoBuilder_ == null) {
        boolean bool;
        List<AuthorizationInfo> list = this.authorizationInfo_;
        if ((this.bitField0_ & 0x40) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.authorizationInfoBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.authorizationInfo_ = null;
      } 
      return this.authorizationInfoBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuditLogProto.a;
    }
    
    private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getRequestFieldBuilder() {
      if (this.requestBuilder_ == null) {
        this.requestBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getRequest(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.request_ = null;
      } 
      return this.requestBuilder_;
    }
    
    private SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> getRequestMetadataFieldBuilder() {
      if (this.requestMetadataBuilder_ == null) {
        this.requestMetadataBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getRequestMetadata(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.requestMetadata_ = null;
      } 
      return this.requestMetadataBuilder_;
    }
    
    private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getResponseFieldBuilder() {
      if (this.responseBuilder_ == null) {
        this.responseBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getResponse(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.response_ = null;
      } 
      return this.responseBuilder_;
    }
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getServiceDataFieldBuilder() {
      if (this.serviceDataBuilder_ == null) {
        this.serviceDataBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getServiceData(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.serviceData_ = null;
      } 
      return this.serviceDataBuilder_;
    }
    
    private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> getStatusFieldBuilder() {
      if (this.statusBuilder_ == null) {
        this.statusBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getStatus(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.status_ = null;
      } 
      return this.statusBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (AuditLog.alwaysUseFieldBuilders)
        getAuthorizationInfoFieldBuilder(); 
    }
    
    public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> param1Iterable) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAuthorizationInfoIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.authorizationInfo_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAuthorizationInfo(int param1Int, AuthorizationInfo.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAuthorizationInfo(int param1Int, AuthorizationInfo param1AuthorizationInfo) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthorizationInfo != null) {
          ensureAuthorizationInfoIsMutable();
          this.authorizationInfo_.add(param1Int, param1AuthorizationInfo);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1AuthorizationInfo);
      return this;
    }
    
    public Builder addAuthorizationInfo(AuthorizationInfo.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAuthorizationInfo(AuthorizationInfo param1AuthorizationInfo) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthorizationInfo != null) {
          ensureAuthorizationInfoIsMutable();
          this.authorizationInfo_.add(param1AuthorizationInfo);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1AuthorizationInfo);
      return this;
    }
    
    public AuthorizationInfo.Builder addAuthorizationInfoBuilder() {
      return (AuthorizationInfo.Builder)getAuthorizationInfoFieldBuilder().addBuilder((AbstractMessage)AuthorizationInfo.getDefaultInstance());
    }
    
    public AuthorizationInfo.Builder addAuthorizationInfoBuilder(int param1Int) {
      return (AuthorizationInfo.Builder)getAuthorizationInfoFieldBuilder().addBuilder(param1Int, (AbstractMessage)AuthorizationInfo.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AuditLog build() {
      AuditLog auditLog = buildPartial();
      if (auditLog.isInitialized())
        return auditLog; 
      throw newUninitializedMessageException(auditLog);
    }
    
    public AuditLog buildPartial() {
      AuditLog auditLog = new AuditLog(this);
      int i = this.bitField0_;
      AuditLog.access$402(auditLog, this.serviceName_);
      AuditLog.access$502(auditLog, this.methodName_);
      AuditLog.access$602(auditLog, this.resourceName_);
      AuditLog.access$702(auditLog, this.numResponseItems_);
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV34 = this.statusBuilder_;
      if (singleFieldBuilderV34 == null) {
        AuditLog.access$802(auditLog, this.status_);
      } else {
        AuditLog.access$802(auditLog, (Status)singleFieldBuilderV34.build());
      } 
      SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV33 = this.authenticationInfoBuilder_;
      if (singleFieldBuilderV33 == null) {
        AuditLog.access$902(auditLog, this.authenticationInfo_);
      } else {
        AuditLog.access$902(auditLog, (AuthenticationInfo)singleFieldBuilderV33.build());
      } 
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x40) != 0) {
          this.authorizationInfo_ = Collections.unmodifiableList(this.authorizationInfo_);
          this.bitField0_ &= 0xFFFFFFBF;
        } 
        AuditLog.access$1002(auditLog, this.authorizationInfo_);
      } else {
        AuditLog.access$1002(auditLog, repeatedFieldBuilderV3.build());
      } 
      SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV32 = this.requestMetadataBuilder_;
      if (singleFieldBuilderV32 == null) {
        AuditLog.access$1102(auditLog, this.requestMetadata_);
      } else {
        AuditLog.access$1102(auditLog, (RequestMetadata)singleFieldBuilderV32.build());
      } 
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV31 = this.requestBuilder_;
      if (singleFieldBuilderV31 == null) {
        AuditLog.access$1202(auditLog, this.request_);
      } else {
        AuditLog.access$1202(auditLog, (Struct)singleFieldBuilderV31.build());
      } 
      singleFieldBuilderV31 = this.responseBuilder_;
      if (singleFieldBuilderV31 == null) {
        AuditLog.access$1302(auditLog, this.response_);
      } else {
        AuditLog.access$1302(auditLog, (Struct)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
      if (singleFieldBuilderV3 == null) {
        AuditLog.access$1402(auditLog, this.serviceData_);
      } else {
        AuditLog.access$1402(auditLog, (Any)singleFieldBuilderV3.build());
      } 
      AuditLog.access$1502(auditLog, 0);
      onBuilt();
      return auditLog;
    }
    
    public Builder clear() {
      super.clear();
      this.serviceName_ = "";
      this.methodName_ = "";
      this.resourceName_ = "";
      this.numResponseItems_ = 0L;
      if (this.statusBuilder_ == null) {
        this.status_ = null;
      } else {
        this.status_ = null;
        this.statusBuilder_ = null;
      } 
      if (this.authenticationInfoBuilder_ == null) {
        this.authenticationInfo_ = null;
      } else {
        this.authenticationInfo_ = null;
        this.authenticationInfoBuilder_ = null;
      } 
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.authorizationInfo_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      if (this.requestMetadataBuilder_ == null) {
        this.requestMetadata_ = null;
      } else {
        this.requestMetadata_ = null;
        this.requestMetadataBuilder_ = null;
      } 
      if (this.requestBuilder_ == null) {
        this.request_ = null;
      } else {
        this.request_ = null;
        this.requestBuilder_ = null;
      } 
      if (this.responseBuilder_ == null) {
        this.response_ = null;
      } else {
        this.response_ = null;
        this.responseBuilder_ = null;
      } 
      if (this.serviceDataBuilder_ == null) {
        this.serviceData_ = null;
        return this;
      } 
      this.serviceData_ = null;
      this.serviceDataBuilder_ = null;
      return this;
    }
    
    public Builder clearAuthenticationInfo() {
      if (this.authenticationInfoBuilder_ == null) {
        this.authenticationInfo_ = null;
        onChanged();
        return this;
      } 
      this.authenticationInfo_ = null;
      this.authenticationInfoBuilder_ = null;
      return this;
    }
    
    public Builder clearAuthorizationInfo() {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.authorizationInfo_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMethodName() {
      this.methodName_ = AuditLog.getDefaultInstance().getMethodName();
      onChanged();
      return this;
    }
    
    public Builder clearNumResponseItems() {
      this.numResponseItems_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRequest() {
      if (this.requestBuilder_ == null) {
        this.request_ = null;
        onChanged();
        return this;
      } 
      this.request_ = null;
      this.requestBuilder_ = null;
      return this;
    }
    
    public Builder clearRequestMetadata() {
      if (this.requestMetadataBuilder_ == null) {
        this.requestMetadata_ = null;
        onChanged();
        return this;
      } 
      this.requestMetadata_ = null;
      this.requestMetadataBuilder_ = null;
      return this;
    }
    
    public Builder clearResourceName() {
      this.resourceName_ = AuditLog.getDefaultInstance().getResourceName();
      onChanged();
      return this;
    }
    
    public Builder clearResponse() {
      if (this.responseBuilder_ == null) {
        this.response_ = null;
        onChanged();
        return this;
      } 
      this.response_ = null;
      this.responseBuilder_ = null;
      return this;
    }
    
    public Builder clearServiceData() {
      if (this.serviceDataBuilder_ == null) {
        this.serviceData_ = null;
        onChanged();
        return this;
      } 
      this.serviceData_ = null;
      this.serviceDataBuilder_ = null;
      return this;
    }
    
    public Builder clearServiceName() {
      this.serviceName_ = AuditLog.getDefaultInstance().getServiceName();
      onChanged();
      return this;
    }
    
    public Builder clearStatus() {
      if (this.statusBuilder_ == null) {
        this.status_ = null;
        onChanged();
        return this;
      } 
      this.status_ = null;
      this.statusBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public AuthenticationInfo getAuthenticationInfo() {
      AuthenticationInfo authenticationInfo;
      SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        AuthenticationInfo authenticationInfo1 = this.authenticationInfo_;
        authenticationInfo = authenticationInfo1;
        if (authenticationInfo1 == null)
          authenticationInfo = AuthenticationInfo.getDefaultInstance(); 
        return authenticationInfo;
      } 
      return (AuthenticationInfo)authenticationInfo.getMessage();
    }
    
    public AuthenticationInfo.Builder getAuthenticationInfoBuilder() {
      onChanged();
      return (AuthenticationInfo.Builder)getAuthenticationInfoFieldBuilder().getBuilder();
    }
    
    public AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder() {
      SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AuthenticationInfoOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
      AuthenticationInfo authenticationInfo1 = authenticationInfo2;
      if (authenticationInfo2 == null)
        authenticationInfo1 = AuthenticationInfo.getDefaultInstance(); 
      return authenticationInfo1;
    }
    
    public AuthorizationInfo getAuthorizationInfo(int param1Int) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.authorizationInfo_.get(param1Int) : (AuthorizationInfo)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public AuthorizationInfo.Builder getAuthorizationInfoBuilder(int param1Int) {
      return (AuthorizationInfo.Builder)getAuthorizationInfoFieldBuilder().getBuilder(param1Int);
    }
    
    public List<AuthorizationInfo.Builder> getAuthorizationInfoBuilderList() {
      return getAuthorizationInfoFieldBuilder().getBuilderList();
    }
    
    public int getAuthorizationInfoCount() {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.authorizationInfo_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<AuthorizationInfo> getAuthorizationInfoList() {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.authorizationInfo_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.authorizationInfo_.get(param1Int) : (AuthorizationInfoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.authorizationInfo_);
    }
    
    public AuditLog getDefaultInstanceForType() {
      return AuditLog.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuditLogProto.a;
    }
    
    public String getMethodName() {
      Object object = this.methodName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.methodName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMethodNameBytes() {
      Object object = this.methodName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.methodName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getNumResponseItems() {
      return this.numResponseItems_;
    }
    
    public Struct getRequest() {
      Struct struct;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
      if (singleFieldBuilderV3 == null) {
        Struct struct1 = this.request_;
        struct = struct1;
        if (struct1 == null)
          struct = Struct.getDefaultInstance(); 
        return struct;
      } 
      return (Struct)struct.getMessage();
    }
    
    public Struct.Builder getRequestBuilder() {
      onChanged();
      return (Struct.Builder)getRequestFieldBuilder().getBuilder();
    }
    
    public RequestMetadata getRequestMetadata() {
      RequestMetadata requestMetadata;
      SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        RequestMetadata requestMetadata1 = this.requestMetadata_;
        requestMetadata = requestMetadata1;
        if (requestMetadata1 == null)
          requestMetadata = RequestMetadata.getDefaultInstance(); 
        return requestMetadata;
      } 
      return (RequestMetadata)requestMetadata.getMessage();
    }
    
    public RequestMetadata.Builder getRequestMetadataBuilder() {
      onChanged();
      return (RequestMetadata.Builder)getRequestMetadataFieldBuilder().getBuilder();
    }
    
    public RequestMetadataOrBuilder getRequestMetadataOrBuilder() {
      SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
      if (singleFieldBuilderV3 != null)
        return (RequestMetadataOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      RequestMetadata requestMetadata2 = this.requestMetadata_;
      RequestMetadata requestMetadata1 = requestMetadata2;
      if (requestMetadata2 == null)
        requestMetadata1 = RequestMetadata.getDefaultInstance(); 
      return requestMetadata1;
    }
    
    public StructOrBuilder getRequestOrBuilder() {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
      if (singleFieldBuilderV3 != null)
        return (StructOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Struct struct2 = this.request_;
      Struct struct1 = struct2;
      if (struct2 == null)
        struct1 = Struct.getDefaultInstance(); 
      return (StructOrBuilder)struct1;
    }
    
    public String getResourceName() {
      Object object = this.resourceName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.resourceName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResourceNameBytes() {
      Object object = this.resourceName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.resourceName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Struct getResponse() {
      Struct struct;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        Struct struct1 = this.response_;
        struct = struct1;
        if (struct1 == null)
          struct = Struct.getDefaultInstance(); 
        return struct;
      } 
      return (Struct)struct.getMessage();
    }
    
    public Struct.Builder getResponseBuilder() {
      onChanged();
      return (Struct.Builder)getResponseFieldBuilder().getBuilder();
    }
    
    public StructOrBuilder getResponseOrBuilder() {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 != null)
        return (StructOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Struct struct2 = this.response_;
      Struct struct1 = struct2;
      if (struct2 == null)
        struct1 = Struct.getDefaultInstance(); 
      return (StructOrBuilder)struct1;
    }
    
    public Any getServiceData() {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
      if (singleFieldBuilderV3 == null) {
        Any any1 = this.serviceData_;
        any = any1;
        if (any1 == null)
          any = Any.getDefaultInstance(); 
        return any;
      } 
      return (Any)any.getMessage();
    }
    
    public Any.Builder getServiceDataBuilder() {
      onChanged();
      return (Any.Builder)getServiceDataFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getServiceDataOrBuilder() {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Any any2 = this.serviceData_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return (AnyOrBuilder)any1;
    }
    
    public String getServiceName() {
      Object object = this.serviceName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.serviceName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getServiceNameBytes() {
      Object object = this.serviceName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.serviceName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Status getStatus() {
      Status status;
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
      if (singleFieldBuilderV3 == null) {
        Status status1 = this.status_;
        status = status1;
        if (status1 == null)
          status = Status.getDefaultInstance(); 
        return status;
      } 
      return (Status)status.getMessage();
    }
    
    public Status.Builder getStatusBuilder() {
      onChanged();
      return (Status.Builder)getStatusFieldBuilder().getBuilder();
    }
    
    public StatusOrBuilder getStatusOrBuilder() {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
      if (singleFieldBuilderV3 != null)
        return (StatusOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Status status2 = this.status_;
      Status status1 = status2;
      if (status2 == null)
        status1 = Status.getDefaultInstance(); 
      return (StatusOrBuilder)status1;
    }
    
    public boolean hasAuthenticationInfo() {
      return (this.authenticationInfoBuilder_ != null || this.authenticationInfo_ != null);
    }
    
    public boolean hasRequest() {
      return (this.requestBuilder_ != null || this.request_ != null);
    }
    
    public boolean hasRequestMetadata() {
      return (this.requestMetadataBuilder_ != null || this.requestMetadata_ != null);
    }
    
    public boolean hasResponse() {
      return (this.responseBuilder_ != null || this.response_ != null);
    }
    
    public boolean hasServiceData() {
      return (this.serviceDataBuilder_ != null || this.serviceData_ != null);
    }
    
    public boolean hasStatus() {
      return (this.statusBuilder_ != null || this.status_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuditLogProto.b.ensureFieldAccessorsInitialized(AuditLog.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeAuthenticationInfo(AuthenticationInfo param1AuthenticationInfo) {
      AuthenticationInfo authenticationInfo;
      SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        authenticationInfo = this.authenticationInfo_;
        if (authenticationInfo != null) {
          this.authenticationInfo_ = AuthenticationInfo.newBuilder(authenticationInfo).mergeFrom(param1AuthenticationInfo).buildPartial();
        } else {
          this.authenticationInfo_ = param1AuthenticationInfo;
        } 
        onChanged();
        return this;
      } 
      authenticationInfo.mergeFrom((AbstractMessage)param1AuthenticationInfo);
      return this;
    }
    
    public Builder mergeFrom(AuditLog param1AuditLog) {
      if (param1AuditLog == AuditLog.getDefaultInstance())
        return this; 
      if (!param1AuditLog.getServiceName().isEmpty()) {
        this.serviceName_ = param1AuditLog.serviceName_;
        onChanged();
      } 
      if (!param1AuditLog.getMethodName().isEmpty()) {
        this.methodName_ = param1AuditLog.methodName_;
        onChanged();
      } 
      if (!param1AuditLog.getResourceName().isEmpty()) {
        this.resourceName_ = param1AuditLog.resourceName_;
        onChanged();
      } 
      if (param1AuditLog.getNumResponseItems() != 0L)
        setNumResponseItems(param1AuditLog.getNumResponseItems()); 
      if (param1AuditLog.hasStatus())
        mergeStatus(param1AuditLog.getStatus()); 
      if (param1AuditLog.hasAuthenticationInfo())
        mergeAuthenticationInfo(param1AuditLog.getAuthenticationInfo()); 
      if (this.authorizationInfoBuilder_ == null) {
        if (!param1AuditLog.authorizationInfo_.isEmpty()) {
          if (this.authorizationInfo_.isEmpty()) {
            this.authorizationInfo_ = param1AuditLog.authorizationInfo_;
            this.bitField0_ &= 0xFFFFFFBF;
          } else {
            ensureAuthorizationInfoIsMutable();
            this.authorizationInfo_.addAll(param1AuditLog.authorizationInfo_);
          } 
          onChanged();
        } 
      } else if (!param1AuditLog.authorizationInfo_.isEmpty()) {
        if (this.authorizationInfoBuilder_.isEmpty()) {
          this.authorizationInfoBuilder_.dispose();
          RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = null;
          this.authorizationInfoBuilder_ = null;
          this.authorizationInfo_ = param1AuditLog.authorizationInfo_;
          this.bitField0_ &= 0xFFFFFFBF;
          if (AuditLog.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getAuthorizationInfoFieldBuilder(); 
          this.authorizationInfoBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.authorizationInfoBuilder_.addAllMessages(param1AuditLog.authorizationInfo_);
        } 
      } 
      if (param1AuditLog.hasRequestMetadata())
        mergeRequestMetadata(param1AuditLog.getRequestMetadata()); 
      if (param1AuditLog.hasRequest())
        mergeRequest(param1AuditLog.getRequest()); 
      if (param1AuditLog.hasResponse())
        mergeResponse(param1AuditLog.getResponse()); 
      if (param1AuditLog.hasServiceData())
        mergeServiceData(param1AuditLog.getServiceData()); 
      mergeUnknownFields(param1AuditLog.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AuditLog auditLog = (AuditLog)AuditLog.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AuditLog auditLog = (AuditLog)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AuditLog)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AuditLog)
        return mergeFrom((AuditLog)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeRequest(Struct param1Struct) {
      Struct struct;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
      if (singleFieldBuilderV3 == null) {
        struct = this.request_;
        if (struct != null) {
          this.request_ = Struct.newBuilder(struct).mergeFrom(param1Struct).buildPartial();
        } else {
          this.request_ = param1Struct;
        } 
        onChanged();
        return this;
      } 
      struct.mergeFrom((AbstractMessage)param1Struct);
      return this;
    }
    
    public Builder mergeRequestMetadata(RequestMetadata param1RequestMetadata) {
      RequestMetadata requestMetadata;
      SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        requestMetadata = this.requestMetadata_;
        if (requestMetadata != null) {
          this.requestMetadata_ = RequestMetadata.newBuilder(requestMetadata).mergeFrom(param1RequestMetadata).buildPartial();
        } else {
          this.requestMetadata_ = param1RequestMetadata;
        } 
        onChanged();
        return this;
      } 
      requestMetadata.mergeFrom((AbstractMessage)param1RequestMetadata);
      return this;
    }
    
    public Builder mergeResponse(Struct param1Struct) {
      Struct struct;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        struct = this.response_;
        if (struct != null) {
          this.response_ = Struct.newBuilder(struct).mergeFrom(param1Struct).buildPartial();
        } else {
          this.response_ = param1Struct;
        } 
        onChanged();
        return this;
      } 
      struct.mergeFrom((AbstractMessage)param1Struct);
      return this;
    }
    
    public Builder mergeServiceData(Any param1Any) {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
      if (singleFieldBuilderV3 == null) {
        any = this.serviceData_;
        if (any != null) {
          this.serviceData_ = Any.newBuilder(any).mergeFrom(param1Any).buildPartial();
        } else {
          this.serviceData_ = param1Any;
        } 
        onChanged();
        return this;
      } 
      any.mergeFrom((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder mergeStatus(Status param1Status) {
      Status status;
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
      if (singleFieldBuilderV3 == null) {
        status = this.status_;
        if (status != null) {
          this.status_ = Status.newBuilder(status).mergeFrom(param1Status).buildPartial();
        } else {
          this.status_ = param1Status;
        } 
        onChanged();
        return this;
      } 
      status.mergeFrom((AbstractMessage)param1Status);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeAuthorizationInfo(int param1Int) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setAuthenticationInfo(AuthenticationInfo.Builder param1Builder) {
      SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.authenticationInfo_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAuthenticationInfo(AuthenticationInfo param1AuthenticationInfo) {
      SingleFieldBuilderV3<AuthenticationInfo, AuthenticationInfo.Builder, AuthenticationInfoOrBuilder> singleFieldBuilderV3 = this.authenticationInfoBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1AuthenticationInfo != null) {
          this.authenticationInfo_ = param1AuthenticationInfo;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1AuthenticationInfo);
      return this;
    }
    
    public Builder setAuthorizationInfo(int param1Int, AuthorizationInfo.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAuthorizationInfo(int param1Int, AuthorizationInfo param1AuthorizationInfo) {
      RepeatedFieldBuilderV3<AuthorizationInfo, AuthorizationInfo.Builder, AuthorizationInfoOrBuilder> repeatedFieldBuilderV3 = this.authorizationInfoBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthorizationInfo != null) {
          ensureAuthorizationInfoIsMutable();
          this.authorizationInfo_.set(param1Int, param1AuthorizationInfo);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1AuthorizationInfo);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMethodName(String param1String) {
      if (param1String != null) {
        this.methodName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMethodNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuditLog.checkByteStringIsUtf8(param1ByteString);
        this.methodName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNumResponseItems(long param1Long) {
      this.numResponseItems_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequest(Struct.Builder param1Builder) {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.request_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequest(Struct param1Struct) {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Struct != null) {
          this.request_ = param1Struct;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Struct);
      return this;
    }
    
    public Builder setRequestMetadata(RequestMetadata.Builder param1Builder) {
      SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.requestMetadata_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequestMetadata(RequestMetadata param1RequestMetadata) {
      SingleFieldBuilderV3<RequestMetadata, RequestMetadata.Builder, RequestMetadataOrBuilder> singleFieldBuilderV3 = this.requestMetadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1RequestMetadata != null) {
          this.requestMetadata_ = param1RequestMetadata;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1RequestMetadata);
      return this;
    }
    
    public Builder setResourceName(String param1String) {
      if (param1String != null) {
        this.resourceName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResourceNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuditLog.checkByteStringIsUtf8(param1ByteString);
        this.resourceName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponse(Struct.Builder param1Builder) {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.response_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setResponse(Struct param1Struct) {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Struct != null) {
          this.response_ = param1Struct;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Struct);
      return this;
    }
    
    public Builder setServiceData(Any.Builder param1Builder) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.serviceData_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setServiceData(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.serviceDataBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Any != null) {
          this.serviceData_ = param1Any;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setServiceName(String param1String) {
      if (param1String != null) {
        this.serviceName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setServiceNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuditLog.checkByteStringIsUtf8(param1ByteString);
        this.serviceName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setStatus(Status.Builder param1Builder) {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.status_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setStatus(Status param1Status) {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.statusBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Status != null) {
          this.status_ = param1Status;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Status);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuditLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
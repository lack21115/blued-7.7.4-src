package com.blued.das.apm;

import com.blued.das.CommonProtos;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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

public final class ApmProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_ImTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_Request_descriptor, new String[] { "Type", "Time", "Takes", "Code", "Description", "Extra", "Common", "ClientTime", "ServerRequestId" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_Requests_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_Requests_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_Response_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_Response_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_apm_WebTypeProto_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable;
  
  static {
    internal_static_com_blued_das_apm_HttpTypeProto_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_HttpTypeProto_descriptor, new String[] { "Url", "ResponseType", "ResponseLength", "ServerIp" });
    internal_static_com_blued_das_apm_ImTypeProto_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_ImTypeProto_descriptor, new String[] { "Name", "Host", "Port", "ServerIp" });
    internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor, new String[] { "Name", "Host", "Port", "ServerIp", "Business" });
    internal_static_com_blued_das_apm_SocketTypeProto_descriptor = getDescriptor().getMessageTypes().get(4);
    internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_SocketTypeProto_descriptor, new String[] { "Host", "Port", "ServerIp" });
    internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor = getDescriptor().getMessageTypes().get(5);
    internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor, new String[] { "Host", "Port", "ServerIp", "Business" });
    internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor = getDescriptor().getMessageTypes().get(6);
    internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor, new String[] { "Type" });
    internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor = getDescriptor().getMessageTypes().get(7);
    internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor, new String[] { "Type" });
    internal_static_com_blued_das_apm_WebTypeProto_descriptor = getDescriptor().getMessageTypes().get(8);
    internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_WebTypeProto_descriptor, new String[] { "Url" });
    internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor = getDescriptor().getMessageTypes().get(9);
    internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor, new String[0]);
    internal_static_com_blued_das_apm_Requests_descriptor = getDescriptor().getMessageTypes().get(10);
    internal_static_com_blued_das_apm_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_Requests_descriptor, new String[] { "Common", "Request" });
    internal_static_com_blued_das_apm_Response_descriptor = getDescriptor().getMessageTypes().get(11);
    internal_static_com_blued_das_apm_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_apm_Response_descriptor, new String[] { "Code" });
    AnyProto.getDescriptor();
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
    Descriptors.FileDescriptor fileDescriptor1 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = CommonProtos.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\017ApmProtos.proto\022\021com.blued.das.apm\032\031google/protobuf/any.proto\032\022CommonProtos.proto\"ì\001\n\007Request\022%\n\004type\030\001 \001(\0162\027.com.blued.das.apm.Type\022\f\n\004time\030\002 \001(\003\022\r\n\005takes\030\003 \001(\005\022\f\n\004code\030\004 \001(\005\022\023\n\013description\030\005 \001(\t\022#\n\005extra\030\006 \001(\0132\024.google.protobuf.Any\022%\n\006common\030\007 \001(\0132\025.com.blued.das.Common\022\023\n\013client_time\030\b \001(\003\022\031\n\021server_request_id\030\t \001(\t\"_\n\rHttpTypeProto\022\013\n\003url\030\001 \001(\t\022\025\n\rresponse_type\030\002 \001(\t\022\027\n\017response_length\030\003 \001(\005\022\021\n\tserver_ip\030\004 \001(\t\"J\n\013ImTypeProto\022\f\n\004name\030\001 \001(\t\022\f\n\004host\030\002 \001(\t\022\f\n\004port\030\003 \001(\005\022\021\n\tserver_ip\030\004 \001(\t\"ò\001\n\024GrpcRequestTypeProto\022\f\n\004name\030\001 \001(\t\022\f\n\004host\030\002 \001(\t\022\f\n\004port\030\003 \001(\005\022\021\n\tserver_ip\030\004 \001(\t\022B\n\bbusiness\030\005 \001(\01620.com.blued.das.apm.GrpcRequestTypeProto.BUSINESS\"Y\n\bBUSINESS\022\024\n\020UNKNOWN_BUSINESS\020\000\022\020\n\fPRIVATE_CHAT\020\001\022\006\n\002YY\020\002\022\r\n\tLIVE_CHAT\020\003\022\016\n\nGROUP_CHAT\020\004\"@\n\017SocketTypeProto\022\f\n\004host\030\001 \001(\t\022\f\n\004port\030\002 \001(\005\022\021\n\tserver_ip\030\003 \001(\t\"Ô\001\n\024GrpcConnectTypeProto\022\f\n\004host\030\001 \001(\t\022\f\n\004port\030\002 \001(\005\022\021\n\tserver_ip\030\003 \001(\t\022B\n\bbusiness\030\004 \001(\01620.com.blued.das.apm.GrpcConnectTypeProto.BUSINESS\"I\n\bBUSINESS\022\024\n\020UNKNOWN_BUSINESS\020\000\022\020\n\fPRIVATE_CHAT\020\001\022\006\n\002YY\020\002\022\r\n\tLIVE_CHAT\020\003\"\001\n\021ErosGrpcTypeProto\022?\n\004type\030\004 \001(\01621.com.blued.das.apm.ErosGrpcTypeProto.ErosGrpcType\"9\n\fErosGrpcType\022\025\n\021UNKNOWN_EROS_TYPE\020\000\022\b\n\004AUTH\020\001\022\b\n\004SEND\020\002\"\001\n\023ErosSocketTypeProto\022C\n\004type\030\004 \001(\01625.com.blued.das.apm.ErosSocketTypeProto.ErosSocketType\";\n\016ErosSocketType\022\025\n\021UNKNOWN_EROS_TYPE\020\000\022\b\n\004AUTH\020\001\022\b\n\004SEND\020\002\"\033\n\fWebTypeProto\022\013\n\003url\030\001 \001(\t\"\023\n\021OpenTimeTypeProto\"^\n\bRequests\022%\n\006common\030\001 \001(\0132\025.com.blued.das.Common\022+\n\007request\030\002 \003(\0132\032.com.blued.das.apm.Request\"\030\n\bResponse\022\f\n\004code\030\001 \001(\005*\001\n\004Type\022\013\n\007UNKNOWN\020\000\022\b\n\004HTTP\020\001\022\006\n\002IM\020\002\022\n\n\006SOCKET\020\003\022\007\n\003WEB\020\004\022\r\n\tEROS_GRPC\020\005\022\017\n\013EROS_SOCKET\020\006\022\r\n\tOPEN_TIME\020\007\022\020\n\fGRPC_CONNECT\020\b\022\020\n\fGRPC_REQUEST\020\t2Z\n\rReportService\022I\n\013BatchReport\022\033.com.blued.das.apm.Requests\032\033.com.blued.das.apm.Response\"\000B\006¢\002\003APMb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 });
  }
  
  public static final class ErosGrpcTypeProto extends GeneratedMessageV3 implements ErosGrpcTypeProtoOrBuilder {
    private static final ErosGrpcTypeProto DEFAULT_INSTANCE = new ErosGrpcTypeProto();
    
    private static final Parser<ErosGrpcTypeProto> PARSER = (Parser<ErosGrpcTypeProto>)new AbstractParser<ErosGrpcTypeProto>() {
        public ApmProtos.ErosGrpcTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.ErosGrpcTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TYPE_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private int type_;
    
    private ErosGrpcTypeProto() {
      this.type_ = 0;
    }
    
    private ErosGrpcTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 32) {
                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                  continue; 
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
    
    private ErosGrpcTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ErosGrpcTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ErosGrpcTypeProto param1ErosGrpcTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ErosGrpcTypeProto);
    }
    
    public static ErosGrpcTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ErosGrpcTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ErosGrpcTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ErosGrpcTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ErosGrpcTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ErosGrpcTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static ErosGrpcTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ErosGrpcTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ErosGrpcTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ErosGrpcTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ErosGrpcTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ErosGrpcTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ErosGrpcTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (ErosGrpcTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ErosGrpcTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ErosGrpcTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ErosGrpcTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ErosGrpcTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ErosGrpcTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ErosGrpcTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ErosGrpcTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ErosGrpcTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ErosGrpcTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ErosGrpcTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ErosGrpcTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ErosGrpcTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.type_ != ((ErosGrpcTypeProto)param1Object).type_) ? false : (!!this.unknownFields.equals(((ErosGrpcTypeProto)param1Object).unknownFields));
    }
    
    public ErosGrpcTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<ErosGrpcTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.type_ != ErosGrpcType.UNKNOWN_EROS_TYPE.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(4, this.type_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public ErosGrpcType getType() {
      ErosGrpcType erosGrpcType2 = ErosGrpcType.valueOf(this.type_);
      ErosGrpcType erosGrpcType1 = erosGrpcType2;
      if (erosGrpcType2 == null)
        erosGrpcType1 = ErosGrpcType.UNRECOGNIZED; 
      return erosGrpcType1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((779 + getDescriptor().hashCode()) * 37 + 4) * 53 + this.type_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ErosGrpcTypeProto.class, Builder.class);
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
      return new ErosGrpcTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.type_ != ErosGrpcType.UNKNOWN_EROS_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(4, this.type_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.ErosGrpcTypeProtoOrBuilder {
      private int type_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.ErosGrpcTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.ErosGrpcTypeProto build() {
        ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = buildPartial();
        if (erosGrpcTypeProto.isInitialized())
          return erosGrpcTypeProto; 
        throw newUninitializedMessageException(erosGrpcTypeProto);
      }
      
      public ApmProtos.ErosGrpcTypeProto buildPartial() {
        ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = new ApmProtos.ErosGrpcTypeProto(this);
        ApmProtos.ErosGrpcTypeProto.access$10402(erosGrpcTypeProto, this.type_);
        onBuilt();
        return erosGrpcTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.type_ = 0;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearType() {
        this.type_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.ErosGrpcTypeProto getDefaultInstanceForType() {
        return ApmProtos.ErosGrpcTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
      }
      
      public ApmProtos.ErosGrpcTypeProto.ErosGrpcType getType() {
        ApmProtos.ErosGrpcTypeProto.ErosGrpcType erosGrpcType2 = ApmProtos.ErosGrpcTypeProto.ErosGrpcType.valueOf(this.type_);
        ApmProtos.ErosGrpcTypeProto.ErosGrpcType erosGrpcType1 = erosGrpcType2;
        if (erosGrpcType2 == null)
          erosGrpcType1 = ApmProtos.ErosGrpcTypeProto.ErosGrpcType.UNRECOGNIZED; 
        return erosGrpcType1;
      }
      
      public int getTypeValue() {
        return this.type_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.ErosGrpcTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.ErosGrpcTypeProto param2ErosGrpcTypeProto) {
        if (param2ErosGrpcTypeProto == ApmProtos.ErosGrpcTypeProto.getDefaultInstance())
          return this; 
        if (param2ErosGrpcTypeProto.type_ != 0)
          setTypeValue(param2ErosGrpcTypeProto.getTypeValue()); 
        mergeUnknownFields(param2ErosGrpcTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = (ApmProtos.ErosGrpcTypeProto)ApmProtos.ErosGrpcTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = (ApmProtos.ErosGrpcTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.ErosGrpcTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.ErosGrpcTypeProto)
          return mergeFrom((ApmProtos.ErosGrpcTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setType(ApmProtos.ErosGrpcTypeProto.ErosGrpcType param2ErosGrpcType) {
        if (param2ErosGrpcType != null) {
          this.type_ = param2ErosGrpcType.getNumber();
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
    
    public enum ErosGrpcType implements ProtocolMessageEnum {
      AUTH,
      SEND,
      UNKNOWN_EROS_TYPE(0),
      UNRECOGNIZED(0);
      
      public static final int AUTH_VALUE = 1;
      
      public static final int SEND_VALUE = 2;
      
      public static final int UNKNOWN_EROS_TYPE_VALUE = 0;
      
      private static final ErosGrpcType[] VALUES;
      
      private static final Internal.EnumLiteMap<ErosGrpcType> internalValueMap = new Internal.EnumLiteMap<ErosGrpcType>() {
          public ApmProtos.ErosGrpcTypeProto.ErosGrpcType findValueByNumber(int param3Int) {
            return ApmProtos.ErosGrpcTypeProto.ErosGrpcType.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
        VALUES = values();
      }
      
      ErosGrpcType(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ErosGrpcType forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? ((param2Int != 2) ? null : SEND) : AUTH) : UNKNOWN_EROS_TYPE;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor() {
        return ApmProtos.ErosGrpcTypeProto.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<ErosGrpcType> internalGetValueMap() {
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
    
    static final class null implements Internal.EnumLiteMap<ErosGrpcType> {
      public ApmProtos.ErosGrpcTypeProto.ErosGrpcType findValueByNumber(int param2Int) {
        return ApmProtos.ErosGrpcTypeProto.ErosGrpcType.forNumber(param2Int);
      }
    }
  }
  
  static final class null extends AbstractParser<ErosGrpcTypeProto> {
    public ApmProtos.ErosGrpcTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.ErosGrpcTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ErosGrpcTypeProto.Builder> implements ErosGrpcTypeProtoOrBuilder {
    private int type_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.ErosGrpcTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.ErosGrpcTypeProto build() {
      ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = buildPartial();
      if (erosGrpcTypeProto.isInitialized())
        return erosGrpcTypeProto; 
      throw newUninitializedMessageException(erosGrpcTypeProto);
    }
    
    public ApmProtos.ErosGrpcTypeProto buildPartial() {
      ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = new ApmProtos.ErosGrpcTypeProto(this);
      ApmProtos.ErosGrpcTypeProto.access$10402(erosGrpcTypeProto, this.type_);
      onBuilt();
      return erosGrpcTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = 0;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.ErosGrpcTypeProto getDefaultInstanceForType() {
      return ApmProtos.ErosGrpcTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_descriptor;
    }
    
    public ApmProtos.ErosGrpcTypeProto.ErosGrpcType getType() {
      ApmProtos.ErosGrpcTypeProto.ErosGrpcType erosGrpcType2 = ApmProtos.ErosGrpcTypeProto.ErosGrpcType.valueOf(this.type_);
      ApmProtos.ErosGrpcTypeProto.ErosGrpcType erosGrpcType1 = erosGrpcType2;
      if (erosGrpcType2 == null)
        erosGrpcType1 = ApmProtos.ErosGrpcTypeProto.ErosGrpcType.UNRECOGNIZED; 
      return erosGrpcType1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosGrpcTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.ErosGrpcTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.ErosGrpcTypeProto param1ErosGrpcTypeProto) {
      if (param1ErosGrpcTypeProto == ApmProtos.ErosGrpcTypeProto.getDefaultInstance())
        return this; 
      if (param1ErosGrpcTypeProto.type_ != 0)
        setTypeValue(param1ErosGrpcTypeProto.getTypeValue()); 
      mergeUnknownFields(param1ErosGrpcTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = (ApmProtos.ErosGrpcTypeProto)ApmProtos.ErosGrpcTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.ErosGrpcTypeProto erosGrpcTypeProto = (ApmProtos.ErosGrpcTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.ErosGrpcTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.ErosGrpcTypeProto)
        return mergeFrom((ApmProtos.ErosGrpcTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setType(ApmProtos.ErosGrpcTypeProto.ErosGrpcType param1ErosGrpcType) {
      if (param1ErosGrpcType != null) {
        this.type_ = param1ErosGrpcType.getNumber();
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
  
  public enum ErosGrpcType implements ProtocolMessageEnum {
    AUTH(0),
    SEND(0),
    UNKNOWN_EROS_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int AUTH_VALUE = 1;
    
    public static final int SEND_VALUE = 2;
    
    public static final int UNKNOWN_EROS_TYPE_VALUE = 0;
    
    private static final ErosGrpcType[] VALUES;
    
    private static final Internal.EnumLiteMap<ErosGrpcType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new ErosGrpcType[] { UNKNOWN_EROS_TYPE, AUTH, SEND, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ErosGrpcType>() {
          public ApmProtos.ErosGrpcTypeProto.ErosGrpcType findValueByNumber(int param3Int) {
            return ApmProtos.ErosGrpcTypeProto.ErosGrpcType.forNumber(param3Int);
          }
        };
      VALUES = values();
    }
    
    ErosGrpcType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ErosGrpcType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : SEND) : AUTH) : UNKNOWN_EROS_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ApmProtos.ErosGrpcTypeProto.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<ErosGrpcType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<ErosGrpcTypeProto.ErosGrpcType> {
    public ApmProtos.ErosGrpcTypeProto.ErosGrpcType findValueByNumber(int param1Int) {
      return ApmProtos.ErosGrpcTypeProto.ErosGrpcType.forNumber(param1Int);
    }
  }
  
  public static interface ErosGrpcTypeProtoOrBuilder extends MessageOrBuilder {
    ApmProtos.ErosGrpcTypeProto.ErosGrpcType getType();
    
    int getTypeValue();
  }
  
  public static final class ErosSocketTypeProto extends GeneratedMessageV3 implements ErosSocketTypeProtoOrBuilder {
    private static final ErosSocketTypeProto DEFAULT_INSTANCE = new ErosSocketTypeProto();
    
    private static final Parser<ErosSocketTypeProto> PARSER = (Parser<ErosSocketTypeProto>)new AbstractParser<ErosSocketTypeProto>() {
        public ApmProtos.ErosSocketTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.ErosSocketTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TYPE_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private int type_;
    
    private ErosSocketTypeProto() {
      this.type_ = 0;
    }
    
    private ErosSocketTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 32) {
                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                  continue; 
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
    
    private ErosSocketTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ErosSocketTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ErosSocketTypeProto param1ErosSocketTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ErosSocketTypeProto);
    }
    
    public static ErosSocketTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ErosSocketTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ErosSocketTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ErosSocketTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ErosSocketTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ErosSocketTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static ErosSocketTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ErosSocketTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ErosSocketTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ErosSocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ErosSocketTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ErosSocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ErosSocketTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (ErosSocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ErosSocketTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ErosSocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ErosSocketTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ErosSocketTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ErosSocketTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ErosSocketTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ErosSocketTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ErosSocketTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ErosSocketTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ErosSocketTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ErosSocketTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ErosSocketTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.type_ != ((ErosSocketTypeProto)param1Object).type_) ? false : (!!this.unknownFields.equals(((ErosSocketTypeProto)param1Object).unknownFields));
    }
    
    public ErosSocketTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<ErosSocketTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.type_ != ErosSocketType.UNKNOWN_EROS_TYPE.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(4, this.type_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public ErosSocketType getType() {
      ErosSocketType erosSocketType2 = ErosSocketType.valueOf(this.type_);
      ErosSocketType erosSocketType1 = erosSocketType2;
      if (erosSocketType2 == null)
        erosSocketType1 = ErosSocketType.UNRECOGNIZED; 
      return erosSocketType1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((779 + getDescriptor().hashCode()) * 37 + 4) * 53 + this.type_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ErosSocketTypeProto.class, Builder.class);
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
      return new ErosSocketTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.type_ != ErosSocketType.UNKNOWN_EROS_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(4, this.type_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.ErosSocketTypeProtoOrBuilder {
      private int type_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.ErosSocketTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.ErosSocketTypeProto build() {
        ApmProtos.ErosSocketTypeProto erosSocketTypeProto = buildPartial();
        if (erosSocketTypeProto.isInitialized())
          return erosSocketTypeProto; 
        throw newUninitializedMessageException(erosSocketTypeProto);
      }
      
      public ApmProtos.ErosSocketTypeProto buildPartial() {
        ApmProtos.ErosSocketTypeProto erosSocketTypeProto = new ApmProtos.ErosSocketTypeProto(this);
        ApmProtos.ErosSocketTypeProto.access$11402(erosSocketTypeProto, this.type_);
        onBuilt();
        return erosSocketTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.type_ = 0;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearType() {
        this.type_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.ErosSocketTypeProto getDefaultInstanceForType() {
        return ApmProtos.ErosSocketTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
      }
      
      public ApmProtos.ErosSocketTypeProto.ErosSocketType getType() {
        ApmProtos.ErosSocketTypeProto.ErosSocketType erosSocketType2 = ApmProtos.ErosSocketTypeProto.ErosSocketType.valueOf(this.type_);
        ApmProtos.ErosSocketTypeProto.ErosSocketType erosSocketType1 = erosSocketType2;
        if (erosSocketType2 == null)
          erosSocketType1 = ApmProtos.ErosSocketTypeProto.ErosSocketType.UNRECOGNIZED; 
        return erosSocketType1;
      }
      
      public int getTypeValue() {
        return this.type_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.ErosSocketTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.ErosSocketTypeProto param2ErosSocketTypeProto) {
        if (param2ErosSocketTypeProto == ApmProtos.ErosSocketTypeProto.getDefaultInstance())
          return this; 
        if (param2ErosSocketTypeProto.type_ != 0)
          setTypeValue(param2ErosSocketTypeProto.getTypeValue()); 
        mergeUnknownFields(param2ErosSocketTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.ErosSocketTypeProto erosSocketTypeProto = (ApmProtos.ErosSocketTypeProto)ApmProtos.ErosSocketTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.ErosSocketTypeProto erosSocketTypeProto = (ApmProtos.ErosSocketTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.ErosSocketTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.ErosSocketTypeProto)
          return mergeFrom((ApmProtos.ErosSocketTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setType(ApmProtos.ErosSocketTypeProto.ErosSocketType param2ErosSocketType) {
        if (param2ErosSocketType != null) {
          this.type_ = param2ErosSocketType.getNumber();
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
    
    public enum ErosSocketType implements ProtocolMessageEnum {
      AUTH(0),
      SEND(0),
      UNKNOWN_EROS_TYPE(0),
      UNRECOGNIZED(0);
      
      public static final int AUTH_VALUE = 1;
      
      public static final int SEND_VALUE = 2;
      
      public static final int UNKNOWN_EROS_TYPE_VALUE = 0;
      
      private static final ErosSocketType[] VALUES;
      
      private static final Internal.EnumLiteMap<ErosSocketType> internalValueMap = new Internal.EnumLiteMap<ErosSocketType>() {
          public ApmProtos.ErosSocketTypeProto.ErosSocketType findValueByNumber(int param3Int) {
            return ApmProtos.ErosSocketTypeProto.ErosSocketType.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
        VALUES = values();
      }
      
      ErosSocketType(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ErosSocketType forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? ((param2Int != 2) ? null : SEND) : AUTH) : UNKNOWN_EROS_TYPE;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor() {
        return ApmProtos.ErosSocketTypeProto.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<ErosSocketType> internalGetValueMap() {
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
    
    static final class null implements Internal.EnumLiteMap<ErosSocketType> {
      public ApmProtos.ErosSocketTypeProto.ErosSocketType findValueByNumber(int param2Int) {
        return ApmProtos.ErosSocketTypeProto.ErosSocketType.forNumber(param2Int);
      }
    }
  }
  
  static final class null extends AbstractParser<ErosSocketTypeProto> {
    public ApmProtos.ErosSocketTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.ErosSocketTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ErosSocketTypeProto.Builder> implements ErosSocketTypeProtoOrBuilder {
    private int type_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.ErosSocketTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.ErosSocketTypeProto build() {
      ApmProtos.ErosSocketTypeProto erosSocketTypeProto = buildPartial();
      if (erosSocketTypeProto.isInitialized())
        return erosSocketTypeProto; 
      throw newUninitializedMessageException(erosSocketTypeProto);
    }
    
    public ApmProtos.ErosSocketTypeProto buildPartial() {
      ApmProtos.ErosSocketTypeProto erosSocketTypeProto = new ApmProtos.ErosSocketTypeProto(this);
      ApmProtos.ErosSocketTypeProto.access$11402(erosSocketTypeProto, this.type_);
      onBuilt();
      return erosSocketTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = 0;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.ErosSocketTypeProto getDefaultInstanceForType() {
      return ApmProtos.ErosSocketTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_descriptor;
    }
    
    public ApmProtos.ErosSocketTypeProto.ErosSocketType getType() {
      ApmProtos.ErosSocketTypeProto.ErosSocketType erosSocketType2 = ApmProtos.ErosSocketTypeProto.ErosSocketType.valueOf(this.type_);
      ApmProtos.ErosSocketTypeProto.ErosSocketType erosSocketType1 = erosSocketType2;
      if (erosSocketType2 == null)
        erosSocketType1 = ApmProtos.ErosSocketTypeProto.ErosSocketType.UNRECOGNIZED; 
      return erosSocketType1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_ErosSocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.ErosSocketTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.ErosSocketTypeProto param1ErosSocketTypeProto) {
      if (param1ErosSocketTypeProto == ApmProtos.ErosSocketTypeProto.getDefaultInstance())
        return this; 
      if (param1ErosSocketTypeProto.type_ != 0)
        setTypeValue(param1ErosSocketTypeProto.getTypeValue()); 
      mergeUnknownFields(param1ErosSocketTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.ErosSocketTypeProto erosSocketTypeProto = (ApmProtos.ErosSocketTypeProto)ApmProtos.ErosSocketTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.ErosSocketTypeProto erosSocketTypeProto = (ApmProtos.ErosSocketTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.ErosSocketTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.ErosSocketTypeProto)
        return mergeFrom((ApmProtos.ErosSocketTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setType(ApmProtos.ErosSocketTypeProto.ErosSocketType param1ErosSocketType) {
      if (param1ErosSocketType != null) {
        this.type_ = param1ErosSocketType.getNumber();
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
  
  public enum ErosSocketType implements ProtocolMessageEnum {
    AUTH(0),
    SEND(0),
    UNKNOWN_EROS_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int AUTH_VALUE = 1;
    
    public static final int SEND_VALUE = 2;
    
    public static final int UNKNOWN_EROS_TYPE_VALUE = 0;
    
    private static final ErosSocketType[] VALUES;
    
    private static final Internal.EnumLiteMap<ErosSocketType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new ErosSocketType[] { UNKNOWN_EROS_TYPE, AUTH, SEND, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ErosSocketType>() {
          public ApmProtos.ErosSocketTypeProto.ErosSocketType findValueByNumber(int param3Int) {
            return ApmProtos.ErosSocketTypeProto.ErosSocketType.forNumber(param3Int);
          }
        };
      VALUES = values();
    }
    
    ErosSocketType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ErosSocketType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : SEND) : AUTH) : UNKNOWN_EROS_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ApmProtos.ErosSocketTypeProto.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<ErosSocketType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<ErosSocketTypeProto.ErosSocketType> {
    public ApmProtos.ErosSocketTypeProto.ErosSocketType findValueByNumber(int param1Int) {
      return ApmProtos.ErosSocketTypeProto.ErosSocketType.forNumber(param1Int);
    }
  }
  
  public static interface ErosSocketTypeProtoOrBuilder extends MessageOrBuilder {
    ApmProtos.ErosSocketTypeProto.ErosSocketType getType();
    
    int getTypeValue();
  }
  
  public static final class GrpcConnectTypeProto extends GeneratedMessageV3 implements GrpcConnectTypeProtoOrBuilder {
    public static final int BUSINESS_FIELD_NUMBER = 4;
    
    private static final GrpcConnectTypeProto DEFAULT_INSTANCE = new GrpcConnectTypeProto();
    
    public static final int HOST_FIELD_NUMBER = 1;
    
    private static final Parser<GrpcConnectTypeProto> PARSER = (Parser<GrpcConnectTypeProto>)new AbstractParser<GrpcConnectTypeProto>() {
        public ApmProtos.GrpcConnectTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.GrpcConnectTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PORT_FIELD_NUMBER = 2;
    
    public static final int SERVER_IP_FIELD_NUMBER = 3;
    
    private static final long serialVersionUID = 0L;
    
    private int business_;
    
    private volatile Object host_;
    
    private byte memoizedIsInitialized = -1;
    
    private int port_;
    
    private volatile Object serverIp_;
    
    private GrpcConnectTypeProto() {
      this.host_ = "";
      this.serverIp_ = "";
      this.business_ = 0;
    }
    
    private GrpcConnectTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    if (i != 32) {
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.business_ = param1CodedInputStream.readEnum();
                    continue;
                  } 
                  this.serverIp_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.port_ = param1CodedInputStream.readInt32();
                continue;
              } 
              this.host_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private GrpcConnectTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static GrpcConnectTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(GrpcConnectTypeProto param1GrpcConnectTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1GrpcConnectTypeProto);
    }
    
    public static GrpcConnectTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (GrpcConnectTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static GrpcConnectTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GrpcConnectTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static GrpcConnectTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (GrpcConnectTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static GrpcConnectTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GrpcConnectTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static GrpcConnectTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (GrpcConnectTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static GrpcConnectTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GrpcConnectTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static GrpcConnectTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (GrpcConnectTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static GrpcConnectTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GrpcConnectTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static GrpcConnectTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (GrpcConnectTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static GrpcConnectTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GrpcConnectTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static GrpcConnectTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (GrpcConnectTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static GrpcConnectTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GrpcConnectTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<GrpcConnectTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof GrpcConnectTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getHost().equals(param1Object.getHost()) ? false : ((getPort() != param1Object.getPort()) ? false : (!getServerIp().equals(param1Object.getServerIp()) ? false : ((this.business_ != ((GrpcConnectTypeProto)param1Object).business_) ? false : (!!this.unknownFields.equals(((GrpcConnectTypeProto)param1Object).unknownFields)))));
    }
    
    public BUSINESS getBusiness() {
      BUSINESS bUSINESS2 = BUSINESS.valueOf(this.business_);
      BUSINESS bUSINESS1 = bUSINESS2;
      if (bUSINESS2 == null)
        bUSINESS1 = BUSINESS.UNRECOGNIZED; 
      return bUSINESS1;
    }
    
    public int getBusinessValue() {
      return this.business_;
    }
    
    public GrpcConnectTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.host_ = object;
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<GrpcConnectTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getPort() {
      return this.port_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getHostBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.host_); 
      int k = this.port_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(2, k); 
      j = i;
      if (!getServerIpBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.serverIp_); 
      i = j;
      if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(4, this.business_); 
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
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getHost().hashCode()) * 37 + 2) * 53 + getPort()) * 37 + 3) * 53 + getServerIp().hashCode()) * 37 + 4) * 53 + this.business_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(GrpcConnectTypeProto.class, Builder.class);
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
      return new GrpcConnectTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getHostBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.host_); 
      int i = this.port_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      if (!getServerIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.serverIp_); 
      if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber())
        param1CodedOutputStream.writeEnum(4, this.business_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public enum BUSINESS implements ProtocolMessageEnum {
      LIVE_CHAT(0),
      PRIVATE_CHAT(0),
      UNKNOWN_BUSINESS(0),
      UNRECOGNIZED(0),
      YY(0);
      
      public static final int LIVE_CHAT_VALUE = 3;
      
      public static final int PRIVATE_CHAT_VALUE = 1;
      
      public static final int UNKNOWN_BUSINESS_VALUE = 0;
      
      private static final BUSINESS[] VALUES;
      
      public static final int YY_VALUE = 2;
      
      private static final Internal.EnumLiteMap<BUSINESS> internalValueMap;
      
      private final int value;
      
      static {
        $VALUES = new BUSINESS[] { UNKNOWN_BUSINESS, PRIVATE_CHAT, YY, LIVE_CHAT, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<BUSINESS>() {
            public ApmProtos.GrpcConnectTypeProto.BUSINESS findValueByNumber(int param3Int) {
              return ApmProtos.GrpcConnectTypeProto.BUSINESS.forNumber(param3Int);
            }
          };
        VALUES = values();
      }
      
      BUSINESS(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static BUSINESS forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? ((param2Int != 2) ? ((param2Int != 3) ? null : LIVE_CHAT) : YY) : PRIVATE_CHAT) : UNKNOWN_BUSINESS;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor() {
        return ApmProtos.GrpcConnectTypeProto.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<BUSINESS> internalGetValueMap() {
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
    
    static final class null implements Internal.EnumLiteMap<BUSINESS> {
      public ApmProtos.GrpcConnectTypeProto.BUSINESS findValueByNumber(int param2Int) {
        return ApmProtos.GrpcConnectTypeProto.BUSINESS.forNumber(param2Int);
      }
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.GrpcConnectTypeProtoOrBuilder {
      private int business_ = 0;
      
      private Object host_ = "";
      
      private int port_;
      
      private Object serverIp_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.GrpcConnectTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.GrpcConnectTypeProto build() {
        ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = buildPartial();
        if (grpcConnectTypeProto.isInitialized())
          return grpcConnectTypeProto; 
        throw newUninitializedMessageException(grpcConnectTypeProto);
      }
      
      public ApmProtos.GrpcConnectTypeProto buildPartial() {
        ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = new ApmProtos.GrpcConnectTypeProto(this);
        ApmProtos.GrpcConnectTypeProto.access$8902(grpcConnectTypeProto, this.host_);
        ApmProtos.GrpcConnectTypeProto.access$9002(grpcConnectTypeProto, this.port_);
        ApmProtos.GrpcConnectTypeProto.access$9102(grpcConnectTypeProto, this.serverIp_);
        ApmProtos.GrpcConnectTypeProto.access$9202(grpcConnectTypeProto, this.business_);
        onBuilt();
        return grpcConnectTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.host_ = "";
        this.port_ = 0;
        this.serverIp_ = "";
        this.business_ = 0;
        return this;
      }
      
      public Builder clearBusiness() {
        this.business_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearHost() {
        this.host_ = ApmProtos.GrpcConnectTypeProto.getDefaultInstance().getHost();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPort() {
        this.port_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearServerIp() {
        this.serverIp_ = ApmProtos.GrpcConnectTypeProto.getDefaultInstance().getServerIp();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.GrpcConnectTypeProto.BUSINESS getBusiness() {
        ApmProtos.GrpcConnectTypeProto.BUSINESS bUSINESS2 = ApmProtos.GrpcConnectTypeProto.BUSINESS.valueOf(this.business_);
        ApmProtos.GrpcConnectTypeProto.BUSINESS bUSINESS1 = bUSINESS2;
        if (bUSINESS2 == null)
          bUSINESS1 = ApmProtos.GrpcConnectTypeProto.BUSINESS.UNRECOGNIZED; 
        return bUSINESS1;
      }
      
      public int getBusinessValue() {
        return this.business_;
      }
      
      public ApmProtos.GrpcConnectTypeProto getDefaultInstanceForType() {
        return ApmProtos.GrpcConnectTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
      }
      
      public String getHost() {
        Object object = this.host_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.host_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getHostBytes() {
        Object object = this.host_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.host_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getPort() {
        return this.port_;
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
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.GrpcConnectTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.GrpcConnectTypeProto param2GrpcConnectTypeProto) {
        if (param2GrpcConnectTypeProto == ApmProtos.GrpcConnectTypeProto.getDefaultInstance())
          return this; 
        if (!param2GrpcConnectTypeProto.getHost().isEmpty()) {
          this.host_ = param2GrpcConnectTypeProto.host_;
          onChanged();
        } 
        if (param2GrpcConnectTypeProto.getPort() != 0)
          setPort(param2GrpcConnectTypeProto.getPort()); 
        if (!param2GrpcConnectTypeProto.getServerIp().isEmpty()) {
          this.serverIp_ = param2GrpcConnectTypeProto.serverIp_;
          onChanged();
        } 
        if (param2GrpcConnectTypeProto.business_ != 0)
          setBusinessValue(param2GrpcConnectTypeProto.getBusinessValue()); 
        mergeUnknownFields(param2GrpcConnectTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = (ApmProtos.GrpcConnectTypeProto)ApmProtos.GrpcConnectTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = (ApmProtos.GrpcConnectTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.GrpcConnectTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.GrpcConnectTypeProto)
          return mergeFrom((ApmProtos.GrpcConnectTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBusiness(ApmProtos.GrpcConnectTypeProto.BUSINESS param2BUSINESS) {
        if (param2BUSINESS != null) {
          this.business_ = param2BUSINESS.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBusinessValue(int param2Int) {
        this.business_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setHost(String param2String) {
        if (param2String != null) {
          this.host_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setHostBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.GrpcConnectTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.host_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPort(int param2Int) {
        this.port_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
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
          ApmProtos.GrpcConnectTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.serverIp_ = param2ByteString;
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
  
  static final class null extends AbstractParser<GrpcConnectTypeProto> {
    public ApmProtos.GrpcConnectTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.GrpcConnectTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public enum BUSINESS implements ProtocolMessageEnum {
    LIVE_CHAT(0),
    PRIVATE_CHAT(0),
    UNKNOWN_BUSINESS(0),
    UNRECOGNIZED(0),
    YY(0);
    
    public static final int LIVE_CHAT_VALUE = 3;
    
    public static final int PRIVATE_CHAT_VALUE = 1;
    
    public static final int UNKNOWN_BUSINESS_VALUE = 0;
    
    private static final BUSINESS[] VALUES;
    
    public static final int YY_VALUE = 2;
    
    private static final Internal.EnumLiteMap<BUSINESS> internalValueMap;
    
    private final int value;
    
    static {
      LIVE_CHAT = new BUSINESS("LIVE_CHAT", 3, 3);
      UNRECOGNIZED = new BUSINESS("UNRECOGNIZED", 4, -1);
      $VALUES = new BUSINESS[] { UNKNOWN_BUSINESS, PRIVATE_CHAT, YY, LIVE_CHAT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<BUSINESS>() {
          public ApmProtos.GrpcConnectTypeProto.BUSINESS findValueByNumber(int param3Int) {
            return ApmProtos.GrpcConnectTypeProto.BUSINESS.forNumber(param3Int);
          }
        };
      VALUES = values();
    }
    
    BUSINESS(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static BUSINESS forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : LIVE_CHAT) : YY) : PRIVATE_CHAT) : UNKNOWN_BUSINESS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ApmProtos.GrpcConnectTypeProto.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<BUSINESS> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<GrpcConnectTypeProto.BUSINESS> {
    public ApmProtos.GrpcConnectTypeProto.BUSINESS findValueByNumber(int param1Int) {
      return ApmProtos.GrpcConnectTypeProto.BUSINESS.forNumber(param1Int);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<GrpcConnectTypeProto.Builder> implements GrpcConnectTypeProtoOrBuilder {
    private int business_ = 0;
    
    private Object host_ = "";
    
    private int port_;
    
    private Object serverIp_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.GrpcConnectTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.GrpcConnectTypeProto build() {
      ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = buildPartial();
      if (grpcConnectTypeProto.isInitialized())
        return grpcConnectTypeProto; 
      throw newUninitializedMessageException(grpcConnectTypeProto);
    }
    
    public ApmProtos.GrpcConnectTypeProto buildPartial() {
      ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = new ApmProtos.GrpcConnectTypeProto(this);
      ApmProtos.GrpcConnectTypeProto.access$8902(grpcConnectTypeProto, this.host_);
      ApmProtos.GrpcConnectTypeProto.access$9002(grpcConnectTypeProto, this.port_);
      ApmProtos.GrpcConnectTypeProto.access$9102(grpcConnectTypeProto, this.serverIp_);
      ApmProtos.GrpcConnectTypeProto.access$9202(grpcConnectTypeProto, this.business_);
      onBuilt();
      return grpcConnectTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.host_ = "";
      this.port_ = 0;
      this.serverIp_ = "";
      this.business_ = 0;
      return this;
    }
    
    public Builder clearBusiness() {
      this.business_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHost() {
      this.host_ = ApmProtos.GrpcConnectTypeProto.getDefaultInstance().getHost();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPort() {
      this.port_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = ApmProtos.GrpcConnectTypeProto.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.GrpcConnectTypeProto.BUSINESS getBusiness() {
      ApmProtos.GrpcConnectTypeProto.BUSINESS bUSINESS2 = ApmProtos.GrpcConnectTypeProto.BUSINESS.valueOf(this.business_);
      ApmProtos.GrpcConnectTypeProto.BUSINESS bUSINESS1 = bUSINESS2;
      if (bUSINESS2 == null)
        bUSINESS1 = ApmProtos.GrpcConnectTypeProto.BUSINESS.UNRECOGNIZED; 
      return bUSINESS1;
    }
    
    public int getBusinessValue() {
      return this.business_;
    }
    
    public ApmProtos.GrpcConnectTypeProto getDefaultInstanceForType() {
      return ApmProtos.GrpcConnectTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_descriptor;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.host_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getPort() {
      return this.port_;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcConnectTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.GrpcConnectTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.GrpcConnectTypeProto param1GrpcConnectTypeProto) {
      if (param1GrpcConnectTypeProto == ApmProtos.GrpcConnectTypeProto.getDefaultInstance())
        return this; 
      if (!param1GrpcConnectTypeProto.getHost().isEmpty()) {
        this.host_ = param1GrpcConnectTypeProto.host_;
        onChanged();
      } 
      if (param1GrpcConnectTypeProto.getPort() != 0)
        setPort(param1GrpcConnectTypeProto.getPort()); 
      if (!param1GrpcConnectTypeProto.getServerIp().isEmpty()) {
        this.serverIp_ = param1GrpcConnectTypeProto.serverIp_;
        onChanged();
      } 
      if (param1GrpcConnectTypeProto.business_ != 0)
        setBusinessValue(param1GrpcConnectTypeProto.getBusinessValue()); 
      mergeUnknownFields(param1GrpcConnectTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = (ApmProtos.GrpcConnectTypeProto)ApmProtos.GrpcConnectTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.GrpcConnectTypeProto grpcConnectTypeProto = (ApmProtos.GrpcConnectTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.GrpcConnectTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.GrpcConnectTypeProto)
        return mergeFrom((ApmProtos.GrpcConnectTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBusiness(ApmProtos.GrpcConnectTypeProto.BUSINESS param1BUSINESS) {
      if (param1BUSINESS != null) {
        this.business_ = param1BUSINESS.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBusinessValue(int param1Int) {
      this.business_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHost(String param1String) {
      if (param1String != null) {
        this.host_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHostBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.GrpcConnectTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.host_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPort(int param1Int) {
      this.port_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
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
        ApmProtos.GrpcConnectTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface GrpcConnectTypeProtoOrBuilder extends MessageOrBuilder {
    ApmProtos.GrpcConnectTypeProto.BUSINESS getBusiness();
    
    int getBusinessValue();
    
    String getHost();
    
    ByteString getHostBytes();
    
    int getPort();
    
    String getServerIp();
    
    ByteString getServerIpBytes();
  }
  
  public static final class GrpcRequestTypeProto extends GeneratedMessageV3 implements GrpcRequestTypeProtoOrBuilder {
    public static final int BUSINESS_FIELD_NUMBER = 5;
    
    private static final GrpcRequestTypeProto DEFAULT_INSTANCE = new GrpcRequestTypeProto();
    
    public static final int HOST_FIELD_NUMBER = 2;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static final Parser<GrpcRequestTypeProto> PARSER = (Parser<GrpcRequestTypeProto>)new AbstractParser<GrpcRequestTypeProto>() {
        public ApmProtos.GrpcRequestTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.GrpcRequestTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PORT_FIELD_NUMBER = 3;
    
    public static final int SERVER_IP_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private int business_;
    
    private volatile Object host_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object name_;
    
    private int port_;
    
    private volatile Object serverIp_;
    
    private GrpcRequestTypeProto() {
      this.name_ = "";
      this.host_ = "";
      this.serverIp_ = "";
      this.business_ = 0;
    }
    
    private GrpcRequestTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 24) {
                    if (i != 34) {
                      if (i != 40) {
                        if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                          continue; 
                        continue;
                      } 
                      this.business_ = param1CodedInputStream.readEnum();
                      continue;
                    } 
                    this.serverIp_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.port_ = param1CodedInputStream.readInt32();
                  continue;
                } 
                this.host_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.name_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private GrpcRequestTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static GrpcRequestTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(GrpcRequestTypeProto param1GrpcRequestTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1GrpcRequestTypeProto);
    }
    
    public static GrpcRequestTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (GrpcRequestTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static GrpcRequestTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GrpcRequestTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static GrpcRequestTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (GrpcRequestTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static GrpcRequestTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GrpcRequestTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static GrpcRequestTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (GrpcRequestTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static GrpcRequestTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GrpcRequestTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static GrpcRequestTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (GrpcRequestTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static GrpcRequestTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GrpcRequestTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static GrpcRequestTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (GrpcRequestTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static GrpcRequestTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GrpcRequestTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static GrpcRequestTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (GrpcRequestTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static GrpcRequestTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GrpcRequestTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<GrpcRequestTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof GrpcRequestTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getName().equals(param1Object.getName()) ? false : (!getHost().equals(param1Object.getHost()) ? false : ((getPort() != param1Object.getPort()) ? false : (!getServerIp().equals(param1Object.getServerIp()) ? false : ((this.business_ != ((GrpcRequestTypeProto)param1Object).business_) ? false : (!!this.unknownFields.equals(((GrpcRequestTypeProto)param1Object).unknownFields))))));
    }
    
    public BUSINESS getBusiness() {
      BUSINESS bUSINESS2 = BUSINESS.valueOf(this.business_);
      BUSINESS bUSINESS1 = bUSINESS2;
      if (bUSINESS2 == null)
        bUSINESS1 = BUSINESS.UNRECOGNIZED; 
      return bUSINESS1;
    }
    
    public int getBusinessValue() {
      return this.business_;
    }
    
    public GrpcRequestTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.host_ = object;
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
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
    
    public Parser<GrpcRequestTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getPort() {
      return this.port_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getNameBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
      i = j;
      if (!getHostBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.host_); 
      int k = this.port_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(3, k); 
      i = j;
      if (!getServerIpBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.serverIp_); 
      j = i;
      if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber())
        j = i + CodedOutputStream.computeEnumSize(5, this.business_); 
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
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getHost().hashCode()) * 37 + 3) * 53 + getPort()) * 37 + 4) * 53 + getServerIp().hashCode()) * 37 + 5) * 53 + this.business_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(GrpcRequestTypeProto.class, Builder.class);
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
      return new GrpcRequestTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getNameBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.name_); 
      if (!getHostBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.host_); 
      int i = this.port_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      if (!getServerIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.serverIp_); 
      if (this.business_ != BUSINESS.UNKNOWN_BUSINESS.getNumber())
        param1CodedOutputStream.writeEnum(5, this.business_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public enum BUSINESS implements ProtocolMessageEnum {
      GROUP_CHAT(0),
      LIVE_CHAT(0),
      PRIVATE_CHAT(0),
      UNKNOWN_BUSINESS(0),
      UNRECOGNIZED(0),
      YY(0);
      
      public static final int GROUP_CHAT_VALUE = 4;
      
      public static final int LIVE_CHAT_VALUE = 3;
      
      public static final int PRIVATE_CHAT_VALUE = 1;
      
      public static final int UNKNOWN_BUSINESS_VALUE = 0;
      
      private static final BUSINESS[] VALUES;
      
      public static final int YY_VALUE = 2;
      
      private static final Internal.EnumLiteMap<BUSINESS> internalValueMap;
      
      private final int value;
      
      static {
        GROUP_CHAT = new BUSINESS("GROUP_CHAT", 4, 4);
        UNRECOGNIZED = new BUSINESS("UNRECOGNIZED", 5, -1);
        $VALUES = new BUSINESS[] { UNKNOWN_BUSINESS, PRIVATE_CHAT, YY, LIVE_CHAT, GROUP_CHAT, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<BUSINESS>() {
            public ApmProtos.GrpcRequestTypeProto.BUSINESS findValueByNumber(int param3Int) {
              return ApmProtos.GrpcRequestTypeProto.BUSINESS.forNumber(param3Int);
            }
          };
        VALUES = values();
      }
      
      BUSINESS(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static BUSINESS forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? ((param2Int != 2) ? ((param2Int != 3) ? ((param2Int != 4) ? null : GROUP_CHAT) : LIVE_CHAT) : YY) : PRIVATE_CHAT) : UNKNOWN_BUSINESS;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor() {
        return ApmProtos.GrpcRequestTypeProto.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<BUSINESS> internalGetValueMap() {
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
    
    static final class null implements Internal.EnumLiteMap<BUSINESS> {
      public ApmProtos.GrpcRequestTypeProto.BUSINESS findValueByNumber(int param2Int) {
        return ApmProtos.GrpcRequestTypeProto.BUSINESS.forNumber(param2Int);
      }
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.GrpcRequestTypeProtoOrBuilder {
      private int business_ = 0;
      
      private Object host_ = "";
      
      private Object name_ = "";
      
      private int port_;
      
      private Object serverIp_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.GrpcRequestTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.GrpcRequestTypeProto build() {
        ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = buildPartial();
        if (grpcRequestTypeProto.isInitialized())
          return grpcRequestTypeProto; 
        throw newUninitializedMessageException(grpcRequestTypeProto);
      }
      
      public ApmProtos.GrpcRequestTypeProto buildPartial() {
        ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = new ApmProtos.GrpcRequestTypeProto(this);
        ApmProtos.GrpcRequestTypeProto.access$5802(grpcRequestTypeProto, this.name_);
        ApmProtos.GrpcRequestTypeProto.access$5902(grpcRequestTypeProto, this.host_);
        ApmProtos.GrpcRequestTypeProto.access$6002(grpcRequestTypeProto, this.port_);
        ApmProtos.GrpcRequestTypeProto.access$6102(grpcRequestTypeProto, this.serverIp_);
        ApmProtos.GrpcRequestTypeProto.access$6202(grpcRequestTypeProto, this.business_);
        onBuilt();
        return grpcRequestTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.name_ = "";
        this.host_ = "";
        this.port_ = 0;
        this.serverIp_ = "";
        this.business_ = 0;
        return this;
      }
      
      public Builder clearBusiness() {
        this.business_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearHost() {
        this.host_ = ApmProtos.GrpcRequestTypeProto.getDefaultInstance().getHost();
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.name_ = ApmProtos.GrpcRequestTypeProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPort() {
        this.port_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearServerIp() {
        this.serverIp_ = ApmProtos.GrpcRequestTypeProto.getDefaultInstance().getServerIp();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.GrpcRequestTypeProto.BUSINESS getBusiness() {
        ApmProtos.GrpcRequestTypeProto.BUSINESS bUSINESS2 = ApmProtos.GrpcRequestTypeProto.BUSINESS.valueOf(this.business_);
        ApmProtos.GrpcRequestTypeProto.BUSINESS bUSINESS1 = bUSINESS2;
        if (bUSINESS2 == null)
          bUSINESS1 = ApmProtos.GrpcRequestTypeProto.BUSINESS.UNRECOGNIZED; 
        return bUSINESS1;
      }
      
      public int getBusinessValue() {
        return this.business_;
      }
      
      public ApmProtos.GrpcRequestTypeProto getDefaultInstanceForType() {
        return ApmProtos.GrpcRequestTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
      }
      
      public String getHost() {
        Object object = this.host_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.host_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getHostBytes() {
        Object object = this.host_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.host_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public int getPort() {
        return this.port_;
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
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.GrpcRequestTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.GrpcRequestTypeProto param2GrpcRequestTypeProto) {
        if (param2GrpcRequestTypeProto == ApmProtos.GrpcRequestTypeProto.getDefaultInstance())
          return this; 
        if (!param2GrpcRequestTypeProto.getName().isEmpty()) {
          this.name_ = param2GrpcRequestTypeProto.name_;
          onChanged();
        } 
        if (!param2GrpcRequestTypeProto.getHost().isEmpty()) {
          this.host_ = param2GrpcRequestTypeProto.host_;
          onChanged();
        } 
        if (param2GrpcRequestTypeProto.getPort() != 0)
          setPort(param2GrpcRequestTypeProto.getPort()); 
        if (!param2GrpcRequestTypeProto.getServerIp().isEmpty()) {
          this.serverIp_ = param2GrpcRequestTypeProto.serverIp_;
          onChanged();
        } 
        if (param2GrpcRequestTypeProto.business_ != 0)
          setBusinessValue(param2GrpcRequestTypeProto.getBusinessValue()); 
        mergeUnknownFields(param2GrpcRequestTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = (ApmProtos.GrpcRequestTypeProto)ApmProtos.GrpcRequestTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = (ApmProtos.GrpcRequestTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.GrpcRequestTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.GrpcRequestTypeProto)
          return mergeFrom((ApmProtos.GrpcRequestTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBusiness(ApmProtos.GrpcRequestTypeProto.BUSINESS param2BUSINESS) {
        if (param2BUSINESS != null) {
          this.business_ = param2BUSINESS.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBusinessValue(int param2Int) {
        this.business_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setHost(String param2String) {
        if (param2String != null) {
          this.host_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setHostBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.GrpcRequestTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.host_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          ApmProtos.GrpcRequestTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.name_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPort(int param2Int) {
        this.port_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
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
          ApmProtos.GrpcRequestTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.serverIp_ = param2ByteString;
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
  
  static final class null extends AbstractParser<GrpcRequestTypeProto> {
    public ApmProtos.GrpcRequestTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.GrpcRequestTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public enum BUSINESS implements ProtocolMessageEnum {
    GROUP_CHAT(0),
    LIVE_CHAT(0),
    PRIVATE_CHAT(0),
    UNKNOWN_BUSINESS(0),
    UNRECOGNIZED(0),
    YY(0);
    
    public static final int GROUP_CHAT_VALUE = 4;
    
    public static final int LIVE_CHAT_VALUE = 3;
    
    public static final int PRIVATE_CHAT_VALUE = 1;
    
    public static final int UNKNOWN_BUSINESS_VALUE = 0;
    
    private static final BUSINESS[] VALUES;
    
    public static final int YY_VALUE = 2;
    
    private static final Internal.EnumLiteMap<BUSINESS> internalValueMap;
    
    private final int value;
    
    static {
      LIVE_CHAT = new BUSINESS("LIVE_CHAT", 3, 3);
      GROUP_CHAT = new BUSINESS("GROUP_CHAT", 4, 4);
      UNRECOGNIZED = new BUSINESS("UNRECOGNIZED", 5, -1);
      $VALUES = new BUSINESS[] { UNKNOWN_BUSINESS, PRIVATE_CHAT, YY, LIVE_CHAT, GROUP_CHAT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<BUSINESS>() {
          public ApmProtos.GrpcRequestTypeProto.BUSINESS findValueByNumber(int param3Int) {
            return ApmProtos.GrpcRequestTypeProto.BUSINESS.forNumber(param3Int);
          }
        };
      VALUES = values();
    }
    
    BUSINESS(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static BUSINESS forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : GROUP_CHAT) : LIVE_CHAT) : YY) : PRIVATE_CHAT) : UNKNOWN_BUSINESS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ApmProtos.GrpcRequestTypeProto.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<BUSINESS> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<GrpcRequestTypeProto.BUSINESS> {
    public ApmProtos.GrpcRequestTypeProto.BUSINESS findValueByNumber(int param1Int) {
      return ApmProtos.GrpcRequestTypeProto.BUSINESS.forNumber(param1Int);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<GrpcRequestTypeProto.Builder> implements GrpcRequestTypeProtoOrBuilder {
    private int business_ = 0;
    
    private Object host_ = "";
    
    private Object name_ = "";
    
    private int port_;
    
    private Object serverIp_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.GrpcRequestTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.GrpcRequestTypeProto build() {
      ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = buildPartial();
      if (grpcRequestTypeProto.isInitialized())
        return grpcRequestTypeProto; 
      throw newUninitializedMessageException(grpcRequestTypeProto);
    }
    
    public ApmProtos.GrpcRequestTypeProto buildPartial() {
      ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = new ApmProtos.GrpcRequestTypeProto(this);
      ApmProtos.GrpcRequestTypeProto.access$5802(grpcRequestTypeProto, this.name_);
      ApmProtos.GrpcRequestTypeProto.access$5902(grpcRequestTypeProto, this.host_);
      ApmProtos.GrpcRequestTypeProto.access$6002(grpcRequestTypeProto, this.port_);
      ApmProtos.GrpcRequestTypeProto.access$6102(grpcRequestTypeProto, this.serverIp_);
      ApmProtos.GrpcRequestTypeProto.access$6202(grpcRequestTypeProto, this.business_);
      onBuilt();
      return grpcRequestTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.host_ = "";
      this.port_ = 0;
      this.serverIp_ = "";
      this.business_ = 0;
      return this;
    }
    
    public Builder clearBusiness() {
      this.business_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHost() {
      this.host_ = ApmProtos.GrpcRequestTypeProto.getDefaultInstance().getHost();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = ApmProtos.GrpcRequestTypeProto.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPort() {
      this.port_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = ApmProtos.GrpcRequestTypeProto.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.GrpcRequestTypeProto.BUSINESS getBusiness() {
      ApmProtos.GrpcRequestTypeProto.BUSINESS bUSINESS2 = ApmProtos.GrpcRequestTypeProto.BUSINESS.valueOf(this.business_);
      ApmProtos.GrpcRequestTypeProto.BUSINESS bUSINESS1 = bUSINESS2;
      if (bUSINESS2 == null)
        bUSINESS1 = ApmProtos.GrpcRequestTypeProto.BUSINESS.UNRECOGNIZED; 
      return bUSINESS1;
    }
    
    public int getBusinessValue() {
      return this.business_;
    }
    
    public ApmProtos.GrpcRequestTypeProto getDefaultInstanceForType() {
      return ApmProtos.GrpcRequestTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_descriptor;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.host_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public int getPort() {
      return this.port_;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_GrpcRequestTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.GrpcRequestTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.GrpcRequestTypeProto param1GrpcRequestTypeProto) {
      if (param1GrpcRequestTypeProto == ApmProtos.GrpcRequestTypeProto.getDefaultInstance())
        return this; 
      if (!param1GrpcRequestTypeProto.getName().isEmpty()) {
        this.name_ = param1GrpcRequestTypeProto.name_;
        onChanged();
      } 
      if (!param1GrpcRequestTypeProto.getHost().isEmpty()) {
        this.host_ = param1GrpcRequestTypeProto.host_;
        onChanged();
      } 
      if (param1GrpcRequestTypeProto.getPort() != 0)
        setPort(param1GrpcRequestTypeProto.getPort()); 
      if (!param1GrpcRequestTypeProto.getServerIp().isEmpty()) {
        this.serverIp_ = param1GrpcRequestTypeProto.serverIp_;
        onChanged();
      } 
      if (param1GrpcRequestTypeProto.business_ != 0)
        setBusinessValue(param1GrpcRequestTypeProto.getBusinessValue()); 
      mergeUnknownFields(param1GrpcRequestTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = (ApmProtos.GrpcRequestTypeProto)ApmProtos.GrpcRequestTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.GrpcRequestTypeProto grpcRequestTypeProto = (ApmProtos.GrpcRequestTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.GrpcRequestTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.GrpcRequestTypeProto)
        return mergeFrom((ApmProtos.GrpcRequestTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBusiness(ApmProtos.GrpcRequestTypeProto.BUSINESS param1BUSINESS) {
      if (param1BUSINESS != null) {
        this.business_ = param1BUSINESS.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBusinessValue(int param1Int) {
      this.business_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHost(String param1String) {
      if (param1String != null) {
        this.host_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHostBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.GrpcRequestTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.host_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ApmProtos.GrpcRequestTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPort(int param1Int) {
      this.port_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
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
        ApmProtos.GrpcRequestTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface GrpcRequestTypeProtoOrBuilder extends MessageOrBuilder {
    ApmProtos.GrpcRequestTypeProto.BUSINESS getBusiness();
    
    int getBusinessValue();
    
    String getHost();
    
    ByteString getHostBytes();
    
    String getName();
    
    ByteString getNameBytes();
    
    int getPort();
    
    String getServerIp();
    
    ByteString getServerIpBytes();
  }
  
  public static final class HttpTypeProto extends GeneratedMessageV3 implements HttpTypeProtoOrBuilder {
    private static final HttpTypeProto DEFAULT_INSTANCE = new HttpTypeProto();
    
    private static final Parser<HttpTypeProto> PARSER = (Parser<HttpTypeProto>)new AbstractParser<HttpTypeProto>() {
        public ApmProtos.HttpTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.HttpTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int RESPONSE_LENGTH_FIELD_NUMBER = 3;
    
    public static final int RESPONSE_TYPE_FIELD_NUMBER = 2;
    
    public static final int SERVER_IP_FIELD_NUMBER = 4;
    
    public static final int URL_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private int responseLength_;
    
    private volatile Object responseType_;
    
    private volatile Object serverIp_;
    
    private volatile Object url_;
    
    private HttpTypeProto() {
      this.url_ = "";
      this.responseType_ = "";
      this.serverIp_ = "";
    }
    
    private HttpTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 24) {
                    if (i != 34) {
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.serverIp_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.responseLength_ = param1CodedInputStream.readInt32();
                  continue;
                } 
                this.responseType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.url_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private HttpTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static HttpTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(HttpTypeProto param1HttpTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1HttpTypeProto);
    }
    
    public static HttpTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (HttpTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static HttpTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (HttpTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static HttpTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (HttpTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static HttpTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (HttpTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static HttpTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (HttpTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static HttpTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (HttpTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static HttpTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (HttpTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static HttpTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (HttpTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static HttpTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (HttpTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static HttpTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (HttpTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static HttpTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (HttpTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static HttpTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (HttpTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<HttpTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof HttpTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getUrl().equals(param1Object.getUrl()) ? false : (!getResponseType().equals(param1Object.getResponseType()) ? false : ((getResponseLength() != param1Object.getResponseLength()) ? false : (!getServerIp().equals(param1Object.getServerIp()) ? false : (!!this.unknownFields.equals(((HttpTypeProto)param1Object).unknownFields)))));
    }
    
    public HttpTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<HttpTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getResponseLength() {
      return this.responseLength_;
    }
    
    public String getResponseType() {
      Object object = this.responseType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.responseType_ = object;
      return (String)object;
    }
    
    public ByteString getResponseTypeBytes() {
      Object object = this.responseType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.responseType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getUrlBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.url_); 
      i = j;
      if (!getResponseTypeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.responseType_); 
      int k = this.responseLength_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(3, k); 
      i = j;
      if (!getServerIpBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.serverIp_); 
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
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.url_ = object;
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getUrl().hashCode()) * 37 + 2) * 53 + getResponseType().hashCode()) * 37 + 3) * 53 + getResponseLength()) * 37 + 4) * 53 + getServerIp().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpTypeProto.class, Builder.class);
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
      return new HttpTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.url_); 
      if (!getResponseTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.responseType_); 
      int i = this.responseLength_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      if (!getServerIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.serverIp_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.HttpTypeProtoOrBuilder {
      private int responseLength_;
      
      private Object responseType_ = "";
      
      private Object serverIp_ = "";
      
      private Object url_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.HttpTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.HttpTypeProto build() {
        ApmProtos.HttpTypeProto httpTypeProto = buildPartial();
        if (httpTypeProto.isInitialized())
          return httpTypeProto; 
        throw newUninitializedMessageException(httpTypeProto);
      }
      
      public ApmProtos.HttpTypeProto buildPartial() {
        ApmProtos.HttpTypeProto httpTypeProto = new ApmProtos.HttpTypeProto(this);
        ApmProtos.HttpTypeProto.access$2602(httpTypeProto, this.url_);
        ApmProtos.HttpTypeProto.access$2702(httpTypeProto, this.responseType_);
        ApmProtos.HttpTypeProto.access$2802(httpTypeProto, this.responseLength_);
        ApmProtos.HttpTypeProto.access$2902(httpTypeProto, this.serverIp_);
        onBuilt();
        return httpTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.url_ = "";
        this.responseType_ = "";
        this.responseLength_ = 0;
        this.serverIp_ = "";
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearResponseLength() {
        this.responseLength_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearResponseType() {
        this.responseType_ = ApmProtos.HttpTypeProto.getDefaultInstance().getResponseType();
        onChanged();
        return this;
      }
      
      public Builder clearServerIp() {
        this.serverIp_ = ApmProtos.HttpTypeProto.getDefaultInstance().getServerIp();
        onChanged();
        return this;
      }
      
      public Builder clearUrl() {
        this.url_ = ApmProtos.HttpTypeProto.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.HttpTypeProto getDefaultInstanceForType() {
        return ApmProtos.HttpTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
      }
      
      public int getResponseLength() {
        return this.responseLength_;
      }
      
      public String getResponseType() {
        Object object = this.responseType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.responseType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getResponseTypeBytes() {
        Object object = this.responseType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.responseType_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public String getUrl() {
        Object object = this.url_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.url_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getUrlBytes() {
        Object object = this.url_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.url_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.HttpTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.HttpTypeProto param2HttpTypeProto) {
        if (param2HttpTypeProto == ApmProtos.HttpTypeProto.getDefaultInstance())
          return this; 
        if (!param2HttpTypeProto.getUrl().isEmpty()) {
          this.url_ = param2HttpTypeProto.url_;
          onChanged();
        } 
        if (!param2HttpTypeProto.getResponseType().isEmpty()) {
          this.responseType_ = param2HttpTypeProto.responseType_;
          onChanged();
        } 
        if (param2HttpTypeProto.getResponseLength() != 0)
          setResponseLength(param2HttpTypeProto.getResponseLength()); 
        if (!param2HttpTypeProto.getServerIp().isEmpty()) {
          this.serverIp_ = param2HttpTypeProto.serverIp_;
          onChanged();
        } 
        mergeUnknownFields(param2HttpTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.HttpTypeProto httpTypeProto = (ApmProtos.HttpTypeProto)ApmProtos.HttpTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.HttpTypeProto httpTypeProto = (ApmProtos.HttpTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.HttpTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.HttpTypeProto)
          return mergeFrom((ApmProtos.HttpTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setResponseLength(int param2Int) {
        this.responseLength_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setResponseType(String param2String) {
        if (param2String != null) {
          this.responseType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setResponseTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.HttpTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.responseType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          ApmProtos.HttpTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.serverIp_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setUrl(String param2String) {
        if (param2String != null) {
          this.url_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUrlBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.HttpTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
    }
  }
  
  static final class null extends AbstractParser<HttpTypeProto> {
    public ApmProtos.HttpTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.HttpTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<HttpTypeProto.Builder> implements HttpTypeProtoOrBuilder {
    private int responseLength_;
    
    private Object responseType_ = "";
    
    private Object serverIp_ = "";
    
    private Object url_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.HttpTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.HttpTypeProto build() {
      ApmProtos.HttpTypeProto httpTypeProto = buildPartial();
      if (httpTypeProto.isInitialized())
        return httpTypeProto; 
      throw newUninitializedMessageException(httpTypeProto);
    }
    
    public ApmProtos.HttpTypeProto buildPartial() {
      ApmProtos.HttpTypeProto httpTypeProto = new ApmProtos.HttpTypeProto(this);
      ApmProtos.HttpTypeProto.access$2602(httpTypeProto, this.url_);
      ApmProtos.HttpTypeProto.access$2702(httpTypeProto, this.responseType_);
      ApmProtos.HttpTypeProto.access$2802(httpTypeProto, this.responseLength_);
      ApmProtos.HttpTypeProto.access$2902(httpTypeProto, this.serverIp_);
      onBuilt();
      return httpTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.url_ = "";
      this.responseType_ = "";
      this.responseLength_ = 0;
      this.serverIp_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearResponseLength() {
      this.responseLength_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearResponseType() {
      this.responseType_ = ApmProtos.HttpTypeProto.getDefaultInstance().getResponseType();
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = ApmProtos.HttpTypeProto.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clearUrl() {
      this.url_ = ApmProtos.HttpTypeProto.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.HttpTypeProto getDefaultInstanceForType() {
      return ApmProtos.HttpTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_descriptor;
    }
    
    public int getResponseLength() {
      return this.responseLength_;
    }
    
    public String getResponseType() {
      Object object = this.responseType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.responseType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResponseTypeBytes() {
      Object object = this.responseType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.responseType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getUrl() {
      Object object = this.url_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.url_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_HttpTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.HttpTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.HttpTypeProto param1HttpTypeProto) {
      if (param1HttpTypeProto == ApmProtos.HttpTypeProto.getDefaultInstance())
        return this; 
      if (!param1HttpTypeProto.getUrl().isEmpty()) {
        this.url_ = param1HttpTypeProto.url_;
        onChanged();
      } 
      if (!param1HttpTypeProto.getResponseType().isEmpty()) {
        this.responseType_ = param1HttpTypeProto.responseType_;
        onChanged();
      } 
      if (param1HttpTypeProto.getResponseLength() != 0)
        setResponseLength(param1HttpTypeProto.getResponseLength()); 
      if (!param1HttpTypeProto.getServerIp().isEmpty()) {
        this.serverIp_ = param1HttpTypeProto.serverIp_;
        onChanged();
      } 
      mergeUnknownFields(param1HttpTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.HttpTypeProto httpTypeProto = (ApmProtos.HttpTypeProto)ApmProtos.HttpTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.HttpTypeProto httpTypeProto = (ApmProtos.HttpTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.HttpTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.HttpTypeProto)
        return mergeFrom((ApmProtos.HttpTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setResponseLength(int param1Int) {
      this.responseLength_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setResponseType(String param1String) {
      if (param1String != null) {
        this.responseType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponseTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.HttpTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.responseType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ApmProtos.HttpTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUrl(String param1String) {
      if (param1String != null) {
        this.url_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.HttpTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  public static interface HttpTypeProtoOrBuilder extends MessageOrBuilder {
    int getResponseLength();
    
    String getResponseType();
    
    ByteString getResponseTypeBytes();
    
    String getServerIp();
    
    ByteString getServerIpBytes();
    
    String getUrl();
    
    ByteString getUrlBytes();
  }
  
  public static final class ImTypeProto extends GeneratedMessageV3 implements ImTypeProtoOrBuilder {
    private static final ImTypeProto DEFAULT_INSTANCE = new ImTypeProto();
    
    public static final int HOST_FIELD_NUMBER = 2;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static final Parser<ImTypeProto> PARSER = (Parser<ImTypeProto>)new AbstractParser<ImTypeProto>() {
        public ApmProtos.ImTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.ImTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PORT_FIELD_NUMBER = 3;
    
    public static final int SERVER_IP_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object host_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object name_;
    
    private int port_;
    
    private volatile Object serverIp_;
    
    private ImTypeProto() {
      this.name_ = "";
      this.host_ = "";
      this.serverIp_ = "";
    }
    
    private ImTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 24) {
                    if (i != 34) {
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.serverIp_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.port_ = param1CodedInputStream.readInt32();
                  continue;
                } 
                this.host_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.name_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private ImTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ImTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ImTypeProto param1ImTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ImTypeProto);
    }
    
    public static ImTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ImTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ImTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ImTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ImTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ImTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static ImTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ImTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ImTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ImTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ImTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ImTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ImTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (ImTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ImTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ImTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ImTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ImTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ImTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ImTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ImTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ImTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ImTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ImTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ImTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ImTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getName().equals(param1Object.getName()) ? false : (!getHost().equals(param1Object.getHost()) ? false : ((getPort() != param1Object.getPort()) ? false : (!getServerIp().equals(param1Object.getServerIp()) ? false : (!!this.unknownFields.equals(((ImTypeProto)param1Object).unknownFields)))));
    }
    
    public ImTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.host_ = object;
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
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
    
    public Parser<ImTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getPort() {
      return this.port_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getNameBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
      i = j;
      if (!getHostBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.host_); 
      int k = this.port_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(3, k); 
      i = j;
      if (!getServerIpBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.serverIp_); 
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
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getHost().hashCode()) * 37 + 3) * 53 + getPort()) * 37 + 4) * 53 + getServerIp().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ImTypeProto.class, Builder.class);
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
      return new ImTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getNameBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.name_); 
      if (!getHostBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.host_); 
      int i = this.port_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      if (!getServerIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.serverIp_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.ImTypeProtoOrBuilder {
      private Object host_ = "";
      
      private Object name_ = "";
      
      private int port_;
      
      private Object serverIp_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.ImTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.ImTypeProto build() {
        ApmProtos.ImTypeProto imTypeProto = buildPartial();
        if (imTypeProto.isInitialized())
          return imTypeProto; 
        throw newUninitializedMessageException(imTypeProto);
      }
      
      public ApmProtos.ImTypeProto buildPartial() {
        ApmProtos.ImTypeProto imTypeProto = new ApmProtos.ImTypeProto(this);
        ApmProtos.ImTypeProto.access$4202(imTypeProto, this.name_);
        ApmProtos.ImTypeProto.access$4302(imTypeProto, this.host_);
        ApmProtos.ImTypeProto.access$4402(imTypeProto, this.port_);
        ApmProtos.ImTypeProto.access$4502(imTypeProto, this.serverIp_);
        onBuilt();
        return imTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.name_ = "";
        this.host_ = "";
        this.port_ = 0;
        this.serverIp_ = "";
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearHost() {
        this.host_ = ApmProtos.ImTypeProto.getDefaultInstance().getHost();
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.name_ = ApmProtos.ImTypeProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPort() {
        this.port_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearServerIp() {
        this.serverIp_ = ApmProtos.ImTypeProto.getDefaultInstance().getServerIp();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.ImTypeProto getDefaultInstanceForType() {
        return ApmProtos.ImTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
      }
      
      public String getHost() {
        Object object = this.host_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.host_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getHostBytes() {
        Object object = this.host_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.host_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public int getPort() {
        return this.port_;
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
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.ImTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.ImTypeProto param2ImTypeProto) {
        if (param2ImTypeProto == ApmProtos.ImTypeProto.getDefaultInstance())
          return this; 
        if (!param2ImTypeProto.getName().isEmpty()) {
          this.name_ = param2ImTypeProto.name_;
          onChanged();
        } 
        if (!param2ImTypeProto.getHost().isEmpty()) {
          this.host_ = param2ImTypeProto.host_;
          onChanged();
        } 
        if (param2ImTypeProto.getPort() != 0)
          setPort(param2ImTypeProto.getPort()); 
        if (!param2ImTypeProto.getServerIp().isEmpty()) {
          this.serverIp_ = param2ImTypeProto.serverIp_;
          onChanged();
        } 
        mergeUnknownFields(param2ImTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.ImTypeProto imTypeProto = (ApmProtos.ImTypeProto)ApmProtos.ImTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.ImTypeProto imTypeProto = (ApmProtos.ImTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.ImTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.ImTypeProto)
          return mergeFrom((ApmProtos.ImTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setHost(String param2String) {
        if (param2String != null) {
          this.host_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setHostBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.ImTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.host_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          ApmProtos.ImTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.name_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPort(int param2Int) {
        this.port_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
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
          ApmProtos.ImTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.serverIp_ = param2ByteString;
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
  
  static final class null extends AbstractParser<ImTypeProto> {
    public ApmProtos.ImTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.ImTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ImTypeProto.Builder> implements ImTypeProtoOrBuilder {
    private Object host_ = "";
    
    private Object name_ = "";
    
    private int port_;
    
    private Object serverIp_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.ImTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.ImTypeProto build() {
      ApmProtos.ImTypeProto imTypeProto = buildPartial();
      if (imTypeProto.isInitialized())
        return imTypeProto; 
      throw newUninitializedMessageException(imTypeProto);
    }
    
    public ApmProtos.ImTypeProto buildPartial() {
      ApmProtos.ImTypeProto imTypeProto = new ApmProtos.ImTypeProto(this);
      ApmProtos.ImTypeProto.access$4202(imTypeProto, this.name_);
      ApmProtos.ImTypeProto.access$4302(imTypeProto, this.host_);
      ApmProtos.ImTypeProto.access$4402(imTypeProto, this.port_);
      ApmProtos.ImTypeProto.access$4502(imTypeProto, this.serverIp_);
      onBuilt();
      return imTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.host_ = "";
      this.port_ = 0;
      this.serverIp_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHost() {
      this.host_ = ApmProtos.ImTypeProto.getDefaultInstance().getHost();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = ApmProtos.ImTypeProto.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPort() {
      this.port_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = ApmProtos.ImTypeProto.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.ImTypeProto getDefaultInstanceForType() {
      return ApmProtos.ImTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_descriptor;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.host_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public int getPort() {
      return this.port_;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_ImTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.ImTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.ImTypeProto param1ImTypeProto) {
      if (param1ImTypeProto == ApmProtos.ImTypeProto.getDefaultInstance())
        return this; 
      if (!param1ImTypeProto.getName().isEmpty()) {
        this.name_ = param1ImTypeProto.name_;
        onChanged();
      } 
      if (!param1ImTypeProto.getHost().isEmpty()) {
        this.host_ = param1ImTypeProto.host_;
        onChanged();
      } 
      if (param1ImTypeProto.getPort() != 0)
        setPort(param1ImTypeProto.getPort()); 
      if (!param1ImTypeProto.getServerIp().isEmpty()) {
        this.serverIp_ = param1ImTypeProto.serverIp_;
        onChanged();
      } 
      mergeUnknownFields(param1ImTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.ImTypeProto imTypeProto = (ApmProtos.ImTypeProto)ApmProtos.ImTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.ImTypeProto imTypeProto = (ApmProtos.ImTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.ImTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.ImTypeProto)
        return mergeFrom((ApmProtos.ImTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHost(String param1String) {
      if (param1String != null) {
        this.host_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHostBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.ImTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.host_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ApmProtos.ImTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPort(int param1Int) {
      this.port_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
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
        ApmProtos.ImTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface ImTypeProtoOrBuilder extends MessageOrBuilder {
    String getHost();
    
    ByteString getHostBytes();
    
    String getName();
    
    ByteString getNameBytes();
    
    int getPort();
    
    String getServerIp();
    
    ByteString getServerIpBytes();
  }
  
  public static final class OpenTimeTypeProto extends GeneratedMessageV3 implements OpenTimeTypeProtoOrBuilder {
    private static final OpenTimeTypeProto DEFAULT_INSTANCE = new OpenTimeTypeProto();
    
    private static final Parser<OpenTimeTypeProto> PARSER = (Parser<OpenTimeTypeProto>)new AbstractParser<OpenTimeTypeProto>() {
        public ApmProtos.OpenTimeTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.OpenTimeTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private OpenTimeTypeProto() {}
    
    private OpenTimeTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
              if (!bool1)
                continue; 
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
    
    private OpenTimeTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static OpenTimeTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(OpenTimeTypeProto param1OpenTimeTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1OpenTimeTypeProto);
    }
    
    public static OpenTimeTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (OpenTimeTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static OpenTimeTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OpenTimeTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static OpenTimeTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (OpenTimeTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static OpenTimeTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OpenTimeTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static OpenTimeTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (OpenTimeTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static OpenTimeTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OpenTimeTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static OpenTimeTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (OpenTimeTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static OpenTimeTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OpenTimeTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static OpenTimeTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (OpenTimeTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static OpenTimeTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OpenTimeTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static OpenTimeTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (OpenTimeTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static OpenTimeTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OpenTimeTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<OpenTimeTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof OpenTimeTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !!this.unknownFields.equals(((OpenTimeTypeProto)param1Object).unknownFields);
    }
    
    public OpenTimeTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<OpenTimeTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = this.unknownFields.getSerializedSize() + 0;
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (779 + getDescriptor().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenTimeTypeProto.class, Builder.class);
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
      return new OpenTimeTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.OpenTimeTypeProtoOrBuilder {
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.OpenTimeTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.OpenTimeTypeProto build() {
        ApmProtos.OpenTimeTypeProto openTimeTypeProto = buildPartial();
        if (openTimeTypeProto.isInitialized())
          return openTimeTypeProto; 
        throw newUninitializedMessageException(openTimeTypeProto);
      }
      
      public ApmProtos.OpenTimeTypeProto buildPartial() {
        ApmProtos.OpenTimeTypeProto openTimeTypeProto = new ApmProtos.OpenTimeTypeProto(this);
        onBuilt();
        return openTimeTypeProto;
      }
      
      public Builder clear() {
        super.clear();
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
      
      public ApmProtos.OpenTimeTypeProto getDefaultInstanceForType() {
        return ApmProtos.OpenTimeTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.OpenTimeTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.OpenTimeTypeProto param2OpenTimeTypeProto) {
        if (param2OpenTimeTypeProto == ApmProtos.OpenTimeTypeProto.getDefaultInstance())
          return this; 
        mergeUnknownFields(param2OpenTimeTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.OpenTimeTypeProto openTimeTypeProto = (ApmProtos.OpenTimeTypeProto)ApmProtos.OpenTimeTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.OpenTimeTypeProto openTimeTypeProto = (ApmProtos.OpenTimeTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.OpenTimeTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.OpenTimeTypeProto)
          return mergeFrom((ApmProtos.OpenTimeTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
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
  
  static final class null extends AbstractParser<OpenTimeTypeProto> {
    public ApmProtos.OpenTimeTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.OpenTimeTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<OpenTimeTypeProto.Builder> implements OpenTimeTypeProtoOrBuilder {
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.OpenTimeTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.OpenTimeTypeProto build() {
      ApmProtos.OpenTimeTypeProto openTimeTypeProto = buildPartial();
      if (openTimeTypeProto.isInitialized())
        return openTimeTypeProto; 
      throw newUninitializedMessageException(openTimeTypeProto);
    }
    
    public ApmProtos.OpenTimeTypeProto buildPartial() {
      ApmProtos.OpenTimeTypeProto openTimeTypeProto = new ApmProtos.OpenTimeTypeProto(this);
      onBuilt();
      return openTimeTypeProto;
    }
    
    public Builder clear() {
      super.clear();
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
    
    public ApmProtos.OpenTimeTypeProto getDefaultInstanceForType() {
      return ApmProtos.OpenTimeTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_OpenTimeTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.OpenTimeTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.OpenTimeTypeProto param1OpenTimeTypeProto) {
      if (param1OpenTimeTypeProto == ApmProtos.OpenTimeTypeProto.getDefaultInstance())
        return this; 
      mergeUnknownFields(param1OpenTimeTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.OpenTimeTypeProto openTimeTypeProto = (ApmProtos.OpenTimeTypeProto)ApmProtos.OpenTimeTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.OpenTimeTypeProto openTimeTypeProto = (ApmProtos.OpenTimeTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.OpenTimeTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.OpenTimeTypeProto)
        return mergeFrom((ApmProtos.OpenTimeTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
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
  
  public static interface OpenTimeTypeProtoOrBuilder extends MessageOrBuilder {}
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int CLIENT_TIME_FIELD_NUMBER = 8;
    
    public static final int CODE_FIELD_NUMBER = 4;
    
    public static final int COMMON_FIELD_NUMBER = 7;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    
    public static final int EXTRA_FIELD_NUMBER = 6;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public ApmProtos.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SERVER_REQUEST_ID_FIELD_NUMBER = 9;
    
    public static final int TAKES_FIELD_NUMBER = 3;
    
    public static final int TIME_FIELD_NUMBER = 2;
    
    public static final int TYPE_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private long clientTime_;
    
    private int code_;
    
    private CommonProtos.Common common_;
    
    private volatile Object description_;
    
    private Any extra_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object serverRequestId_;
    
    private int takes_;
    
    private long time_;
    
    private int type_;
    
    private Request() {
      this.type_ = 0;
      this.description_ = "";
      this.serverRequestId_ = "";
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
                    if (i != 32) {
                      if (i != 42) {
                        Any.Builder builder1;
                        CommonProtos.Common.Builder builder3 = null;
                        CommonProtos.Common.Builder builder2 = null;
                        if (i != 50) {
                          if (i != 58) {
                            if (i != 64) {
                              if (i != 74) {
                                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                                  continue; 
                                continue;
                              } 
                              this.serverRequestId_ = param1CodedInputStream.readStringRequireUtf8();
                              continue;
                            } 
                            this.clientTime_ = param1CodedInputStream.readInt64();
                            continue;
                          } 
                          if (this.common_ != null)
                            builder2 = this.common_.toBuilder(); 
                          this.common_ = (CommonProtos.Common)param1CodedInputStream.readMessage(CommonProtos.Common.parser(), param1ExtensionRegistryLite);
                          if (builder2 != null) {
                            builder2.mergeFrom(this.common_);
                            this.common_ = builder2.buildPartial();
                          } 
                          continue;
                        } 
                        builder2 = builder3;
                        if (this.extra_ != null)
                          builder1 = this.extra_.toBuilder(); 
                        this.extra_ = (Any)param1CodedInputStream.readMessage(Any.parser(), param1ExtensionRegistryLite);
                        if (builder1 != null) {
                          builder1.mergeFrom(this.extra_);
                          this.extra_ = builder1.buildPartial();
                        } 
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
      return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
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
      return (this.type_ != ((Request)param1Object).type_) ? false : ((getTime() != param1Object.getTime()) ? false : ((getTakes() != param1Object.getTakes()) ? false : ((getCode() != param1Object.getCode()) ? false : (!getDescription().equals(param1Object.getDescription()) ? false : ((hasExtra() != param1Object.hasExtra()) ? false : ((hasExtra() && !getExtra().equals(param1Object.getExtra())) ? false : ((hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getClientTime() != param1Object.getClientTime()) ? false : (!getServerRequestId().equals(param1Object.getServerRequestId()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields))))))))))));
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
    
    public Any getExtra() {
      Any any2 = this.extra_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return any1;
    }
    
    public AnyOrBuilder getExtraOrBuilder() {
      return (AnyOrBuilder)getExtra();
    }
    
    public Parser<Request> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.type_ != ApmProtos.Type.UNKNOWN.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.type_); 
      long l = this.time_;
      int j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(2, l); 
      int k = this.takes_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(3, k); 
      k = this.code_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(4, k); 
      i = j;
      if (!getDescriptionBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(5, this.description_); 
      j = i;
      if (this.extra_ != null)
        j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)getExtra()); 
      i = j;
      if (this.common_ != null)
        i = j + CodedOutputStream.computeMessageSize(7, (MessageLite)getCommon()); 
      l = this.clientTime_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(8, l); 
      i = j;
      if (!getServerRequestIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(9, this.serverRequestId_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getServerRequestId() {
      Object object = this.serverRequestId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.serverRequestId_ = object;
      return (String)object;
    }
    
    public ByteString getServerRequestIdBytes() {
      Object object = this.serverRequestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.serverRequestId_ = object;
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
    
    public ApmProtos.Type getType() {
      ApmProtos.Type type2 = ApmProtos.Type.valueOf(this.type_);
      ApmProtos.Type type1 = type2;
      if (type2 == null)
        type1 = ApmProtos.Type.UNRECOGNIZED; 
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
    
    public boolean hasExtra() {
      return (this.extra_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.type_) * 37 + 2) * 53 + Internal.hashLong(getTime())) * 37 + 3) * 53 + getTakes()) * 37 + 4) * 53 + getCode()) * 37 + 5) * 53 + getDescription().hashCode();
      int i = j;
      if (hasExtra())
        i = (j * 37 + 6) * 53 + getExtra().hashCode(); 
      j = i;
      if (hasCommon())
        j = (i * 37 + 7) * 53 + getCommon().hashCode(); 
      i = ((((j * 37 + 8) * 53 + Internal.hashLong(getClientTime())) * 37 + 9) * 53 + getServerRequestId().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      if (this.type_ != ApmProtos.Type.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.type_); 
      long l = this.time_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(2, l); 
      int i = this.takes_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      i = this.code_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(4, i); 
      if (!getDescriptionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.description_); 
      if (this.extra_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getExtra()); 
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(7, (MessageLite)getCommon()); 
      l = this.clientTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(8, l); 
      if (!getServerRequestIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 9, this.serverRequestId_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.RequestOrBuilder {
      private long clientTime_;
      
      private int code_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private Object description_ = "";
      
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
      
      private Any extra_;
      
      private Object serverRequestId_ = "";
      
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
        return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
      }
      
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
        if (this.extraBuilder_ == null) {
          this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.extra_ = null;
        } 
        return this.extraBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.Request build() {
        ApmProtos.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public ApmProtos.Request buildPartial() {
        ApmProtos.Request request = new ApmProtos.Request(this);
        ApmProtos.Request.access$602(request, this.type_);
        ApmProtos.Request.access$702(request, this.time_);
        ApmProtos.Request.access$802(request, this.takes_);
        ApmProtos.Request.access$902(request, this.code_);
        ApmProtos.Request.access$1002(request, this.description_);
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV31 = this.extraBuilder_;
        if (singleFieldBuilderV31 == null) {
          ApmProtos.Request.access$1102(request, this.extra_);
        } else {
          ApmProtos.Request.access$1102(request, (Any)singleFieldBuilderV31.build());
        } 
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          ApmProtos.Request.access$1202(request, this.common_);
        } else {
          ApmProtos.Request.access$1202(request, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        ApmProtos.Request.access$1302(request, this.clientTime_);
        ApmProtos.Request.access$1402(request, this.serverRequestId_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        this.type_ = 0;
        this.time_ = 0L;
        this.takes_ = 0;
        this.code_ = 0;
        this.description_ = "";
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
        } else {
          this.extra_ = null;
          this.extraBuilder_ = null;
        } 
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        this.clientTime_ = 0L;
        this.serverRequestId_ = "";
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
        this.description_ = ApmProtos.Request.getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      
      public Builder clearExtra() {
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
          onChanged();
          return this;
        } 
        this.extra_ = null;
        this.extraBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearServerRequestId() {
        this.serverRequestId_ = ApmProtos.Request.getDefaultInstance().getServerRequestId();
        onChanged();
        return this;
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
      
      public ApmProtos.Request getDefaultInstanceForType() {
        return ApmProtos.Request.getDefaultInstance();
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
        return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
      }
      
      public Any getExtra() {
        Any any;
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          Any any1 = this.extra_;
          any = any1;
          if (any1 == null)
            any = Any.getDefaultInstance(); 
          return any;
        } 
        return (Any)any.getMessage();
      }
      
      public Any.Builder getExtraBuilder() {
        onChanged();
        return (Any.Builder)getExtraFieldBuilder().getBuilder();
      }
      
      public AnyOrBuilder getExtraOrBuilder() {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        Any any2 = this.extra_;
        Any any1 = any2;
        if (any2 == null)
          any1 = Any.getDefaultInstance(); 
        return (AnyOrBuilder)any1;
      }
      
      public String getServerRequestId() {
        Object object = this.serverRequestId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.serverRequestId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getServerRequestIdBytes() {
        Object object = this.serverRequestId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.serverRequestId_ = object;
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
      
      public ApmProtos.Type getType() {
        ApmProtos.Type type2 = ApmProtos.Type.valueOf(this.type_);
        ApmProtos.Type type1 = type2;
        if (type2 == null)
          type1 = ApmProtos.Type.UNRECOGNIZED; 
        return type1;
      }
      
      public int getTypeValue() {
        return this.type_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public boolean hasExtra() {
        return (this.extraBuilder_ != null || this.extra_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.Request.class, Builder.class);
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
      
      public Builder mergeExtra(Any param2Any) {
        Any any;
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          any = this.extra_;
          if (any != null) {
            this.extra_ = Any.newBuilder(any).mergeFrom(param2Any).buildPartial();
          } else {
            this.extra_ = param2Any;
          } 
          onChanged();
          return this;
        } 
        any.mergeFrom((AbstractMessage)param2Any);
        return this;
      }
      
      public Builder mergeFrom(ApmProtos.Request param2Request) {
        if (param2Request == ApmProtos.Request.getDefaultInstance())
          return this; 
        if (param2Request.type_ != 0)
          setTypeValue(param2Request.getTypeValue()); 
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
        if (param2Request.hasExtra())
          mergeExtra(param2Request.getExtra()); 
        if (param2Request.hasCommon())
          mergeCommon(param2Request.getCommon()); 
        if (param2Request.getClientTime() != 0L)
          setClientTime(param2Request.getClientTime()); 
        if (!param2Request.getServerRequestId().isEmpty()) {
          this.serverRequestId_ = param2Request.serverRequestId_;
          onChanged();
        } 
        mergeUnknownFields(param2Request.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.Request request = (ApmProtos.Request)ApmProtos.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.Request request = (ApmProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.Request)
          return mergeFrom((ApmProtos.Request)param2Message); 
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
          ApmProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.description_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setExtra(Any.Builder param2Builder) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.extra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setExtra(Any param2Any) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Any != null) {
            this.extra_ = param2Any;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Any);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setServerRequestId(String param2String) {
        if (param2String != null) {
          this.serverRequestId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setServerRequestIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.Request.checkByteStringIsUtf8(param2ByteString);
          this.serverRequestId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
      
      public Builder setType(ApmProtos.Type param2Type) {
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
    public ApmProtos.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private long clientTime_;
    
    private int code_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private Object description_ = "";
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extraBuilder_;
    
    private Any extra_;
    
    private Object serverRequestId_ = "";
    
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
      return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
    }
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtraFieldBuilder() {
      if (this.extraBuilder_ == null) {
        this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.extra_ = null;
      } 
      return this.extraBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.Request build() {
      ApmProtos.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public ApmProtos.Request buildPartial() {
      ApmProtos.Request request = new ApmProtos.Request(this);
      ApmProtos.Request.access$602(request, this.type_);
      ApmProtos.Request.access$702(request, this.time_);
      ApmProtos.Request.access$802(request, this.takes_);
      ApmProtos.Request.access$902(request, this.code_);
      ApmProtos.Request.access$1002(request, this.description_);
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV31 = this.extraBuilder_;
      if (singleFieldBuilderV31 == null) {
        ApmProtos.Request.access$1102(request, this.extra_);
      } else {
        ApmProtos.Request.access$1102(request, (Any)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        ApmProtos.Request.access$1202(request, this.common_);
      } else {
        ApmProtos.Request.access$1202(request, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      ApmProtos.Request.access$1302(request, this.clientTime_);
      ApmProtos.Request.access$1402(request, this.serverRequestId_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = 0;
      this.time_ = 0L;
      this.takes_ = 0;
      this.code_ = 0;
      this.description_ = "";
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
      } else {
        this.extra_ = null;
        this.extraBuilder_ = null;
      } 
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      this.clientTime_ = 0L;
      this.serverRequestId_ = "";
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
      this.description_ = ApmProtos.Request.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearExtra() {
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
        onChanged();
        return this;
      } 
      this.extra_ = null;
      this.extraBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearServerRequestId() {
      this.serverRequestId_ = ApmProtos.Request.getDefaultInstance().getServerRequestId();
      onChanged();
      return this;
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
    
    public ApmProtos.Request getDefaultInstanceForType() {
      return ApmProtos.Request.getDefaultInstance();
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
      return ApmProtos.internal_static_com_blued_das_apm_Request_descriptor;
    }
    
    public Any getExtra() {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        Any any1 = this.extra_;
        any = any1;
        if (any1 == null)
          any = Any.getDefaultInstance(); 
        return any;
      } 
      return (Any)any.getMessage();
    }
    
    public Any.Builder getExtraBuilder() {
      onChanged();
      return (Any.Builder)getExtraFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getExtraOrBuilder() {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Any any2 = this.extra_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return (AnyOrBuilder)any1;
    }
    
    public String getServerRequestId() {
      Object object = this.serverRequestId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.serverRequestId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getServerRequestIdBytes() {
      Object object = this.serverRequestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.serverRequestId_ = object;
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
    
    public ApmProtos.Type getType() {
      ApmProtos.Type type2 = ApmProtos.Type.valueOf(this.type_);
      ApmProtos.Type type1 = type2;
      if (type2 == null)
        type1 = ApmProtos.Type.UNRECOGNIZED; 
      return type1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public boolean hasExtra() {
      return (this.extraBuilder_ != null || this.extra_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.Request.class, Builder.class);
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
    
    public Builder mergeExtra(Any param1Any) {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        any = this.extra_;
        if (any != null) {
          this.extra_ = Any.newBuilder(any).mergeFrom(param1Any).buildPartial();
        } else {
          this.extra_ = param1Any;
        } 
        onChanged();
        return this;
      } 
      any.mergeFrom((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder mergeFrom(ApmProtos.Request param1Request) {
      if (param1Request == ApmProtos.Request.getDefaultInstance())
        return this; 
      if (param1Request.type_ != 0)
        setTypeValue(param1Request.getTypeValue()); 
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
      if (param1Request.hasExtra())
        mergeExtra(param1Request.getExtra()); 
      if (param1Request.hasCommon())
        mergeCommon(param1Request.getCommon()); 
      if (param1Request.getClientTime() != 0L)
        setClientTime(param1Request.getClientTime()); 
      if (!param1Request.getServerRequestId().isEmpty()) {
        this.serverRequestId_ = param1Request.serverRequestId_;
        onChanged();
      } 
      mergeUnknownFields(param1Request.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.Request request = (ApmProtos.Request)ApmProtos.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.Request request = (ApmProtos.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.Request)
        return mergeFrom((ApmProtos.Request)param1Message); 
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
        ApmProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExtra(Any.Builder param1Builder) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.extra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExtra(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Any != null) {
          this.extra_ = param1Any;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setServerRequestId(String param1String) {
      if (param1String != null) {
        this.serverRequestId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setServerRequestIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.Request.checkByteStringIsUtf8(param1ByteString);
        this.serverRequestId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
    
    public Builder setType(ApmProtos.Type param1Type) {
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
    
    Any getExtra();
    
    AnyOrBuilder getExtraOrBuilder();
    
    String getServerRequestId();
    
    ByteString getServerRequestIdBytes();
    
    int getTakes();
    
    long getTime();
    
    ApmProtos.Type getType();
    
    int getTypeValue();
    
    boolean hasCommon();
    
    boolean hasExtra();
  }
  
  public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final Requests DEFAULT_INSTANCE = new Requests();
    
    private static final Parser<Requests> PARSER = (Parser<Requests>)new AbstractParser<Requests>() {
        public ApmProtos.Requests parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.Requests(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private CommonProtos.Common common_;
    
    private byte memoizedIsInitialized = -1;
    
    private List<ApmProtos.Request> request_;
    
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
                  this.request_ = new ArrayList<ApmProtos.Request>();
                  n = i | 0x1;
                } 
                j = n;
                k = n;
                m = n;
                this.request_.add(param1CodedInputStream.readMessage(ApmProtos.Request.parser(), param1ExtensionRegistryLite));
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
      return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
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
    
    public ApmProtos.Request getRequest(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public int getRequestCount() {
      return this.request_.size();
    }
    
    public List<ApmProtos.Request> getRequestList() {
      return this.request_;
    }
    
    public ApmProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      return this.request_.get(param1Int);
    }
    
    public List<? extends ApmProtos.RequestOrBuilder> getRequestOrBuilderList() {
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
      return ApmProtos.internal_static_com_blued_das_apm_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.RequestsOrBuilder {
      private int bitField0_;
      
      private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
      
      private CommonProtos.Common common_;
      
      private RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> requestBuilder_;
      
      private List<ApmProtos.Request> request_ = Collections.emptyList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureRequestIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.request_ = new ArrayList<ApmProtos.Request>(this.request_);
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
        return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
      }
      
      private RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> getRequestFieldBuilder() {
        if (this.requestBuilder_ == null) {
          List<ApmProtos.Request> list = this.request_;
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
        if (ApmProtos.Requests.alwaysUseFieldBuilders)
          getRequestFieldBuilder(); 
      }
      
      public Builder addAllRequest(Iterable<? extends ApmProtos.Request> param2Iterable) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder addRequest(int param2Int, ApmProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(int param2Int, ApmProtos.Request param2Request) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder addRequest(ApmProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addRequest(ApmProtos.Request param2Request) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public ApmProtos.Request.Builder addRequestBuilder() {
        return (ApmProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)ApmProtos.Request.getDefaultInstance());
      }
      
      public ApmProtos.Request.Builder addRequestBuilder(int param2Int) {
        return (ApmProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param2Int, (AbstractMessage)ApmProtos.Request.getDefaultInstance());
      }
      
      public ApmProtos.Requests build() {
        ApmProtos.Requests requests = buildPartial();
        if (requests.isInitialized())
          return requests; 
        throw newUninitializedMessageException(requests);
      }
      
      public ApmProtos.Requests buildPartial() {
        ApmProtos.Requests requests = new ApmProtos.Requests(this);
        int i = this.bitField0_;
        SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          ApmProtos.Requests.access$14402(requests, this.common_);
        } else {
          ApmProtos.Requests.access$14402(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
        } 
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x1) != 0) {
            this.request_ = Collections.unmodifiableList(this.request_);
            this.bitField0_ &= 0xFFFFFFFE;
          } 
          ApmProtos.Requests.access$14502(requests, this.request_);
        } else {
          ApmProtos.Requests.access$14502(requests, repeatedFieldBuilderV3.build());
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
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public ApmProtos.Requests getDefaultInstanceForType() {
        return ApmProtos.Requests.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
      }
      
      public ApmProtos.Request getRequest(int param2Int) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (ApmProtos.Request)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public ApmProtos.Request.Builder getRequestBuilder(int param2Int) {
        return (ApmProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param2Int);
      }
      
      public List<ApmProtos.Request.Builder> getRequestBuilderList() {
        return getRequestFieldBuilder().getBuilderList();
      }
      
      public int getRequestCount() {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<ApmProtos.Request> getRequestList() {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public ApmProtos.RequestOrBuilder getRequestOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.request_.get(param2Int) : (ApmProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends ApmProtos.RequestOrBuilder> getRequestOrBuilderList() {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.Requests.class, Builder.class);
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
      
      public Builder mergeFrom(ApmProtos.Requests param2Requests) {
        if (param2Requests == ApmProtos.Requests.getDefaultInstance())
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
            RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
            this.requestBuilder_ = null;
            this.request_ = param2Requests.request_;
            this.bitField0_ &= 0xFFFFFFFE;
            if (ApmProtos.Requests.alwaysUseFieldBuilders)
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
          ApmProtos.Requests requests = (ApmProtos.Requests)ApmProtos.Requests.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.Requests requests = (ApmProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.Requests)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.Requests)
          return mergeFrom((ApmProtos.Requests)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeRequest(int param2Int) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      
      public Builder setRequest(int param2Int, ApmProtos.Request.Builder param2Builder) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureRequestIsMutable();
          this.request_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setRequest(int param2Int, ApmProtos.Request param2Request) {
        RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    public ApmProtos.Requests parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.Requests(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Requests.Builder> implements RequestsOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
    
    private CommonProtos.Common common_;
    
    private RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> requestBuilder_;
    
    private List<ApmProtos.Request> request_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRequestIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.request_ = new ArrayList<ApmProtos.Request>(this.request_);
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
      return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
    }
    
    private RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> getRequestFieldBuilder() {
      if (this.requestBuilder_ == null) {
        List<ApmProtos.Request> list = this.request_;
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
      if (ApmProtos.Requests.alwaysUseFieldBuilders)
        getRequestFieldBuilder(); 
    }
    
    public Builder addAllRequest(Iterable<? extends ApmProtos.Request> param1Iterable) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder addRequest(int param1Int, ApmProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(int param1Int, ApmProtos.Request param1Request) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder addRequest(ApmProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequest(ApmProtos.Request param1Request) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public ApmProtos.Request.Builder addRequestBuilder() {
      return (ApmProtos.Request.Builder)getRequestFieldBuilder().addBuilder((AbstractMessage)ApmProtos.Request.getDefaultInstance());
    }
    
    public ApmProtos.Request.Builder addRequestBuilder(int param1Int) {
      return (ApmProtos.Request.Builder)getRequestFieldBuilder().addBuilder(param1Int, (AbstractMessage)ApmProtos.Request.getDefaultInstance());
    }
    
    public ApmProtos.Requests build() {
      ApmProtos.Requests requests = buildPartial();
      if (requests.isInitialized())
        return requests; 
      throw newUninitializedMessageException(requests);
    }
    
    public ApmProtos.Requests buildPartial() {
      ApmProtos.Requests requests = new ApmProtos.Requests(this);
      int i = this.bitField0_;
      SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        ApmProtos.Requests.access$14402(requests, this.common_);
      } else {
        ApmProtos.Requests.access$14402(requests, (CommonProtos.Common)singleFieldBuilderV3.build());
      } 
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.request_ = Collections.unmodifiableList(this.request_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        ApmProtos.Requests.access$14502(requests, this.request_);
      } else {
        ApmProtos.Requests.access$14502(requests, repeatedFieldBuilderV3.build());
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
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public ApmProtos.Requests getDefaultInstanceForType() {
      return ApmProtos.Requests.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_Requests_descriptor;
    }
    
    public ApmProtos.Request getRequest(int param1Int) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (ApmProtos.Request)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public ApmProtos.Request.Builder getRequestBuilder(int param1Int) {
      return (ApmProtos.Request.Builder)getRequestFieldBuilder().getBuilder(param1Int);
    }
    
    public List<ApmProtos.Request.Builder> getRequestBuilderList() {
      return getRequestFieldBuilder().getBuilderList();
    }
    
    public int getRequestCount() {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<ApmProtos.Request> getRequestList() {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public ApmProtos.RequestOrBuilder getRequestOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.request_.get(param1Int) : (ApmProtos.RequestOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends ApmProtos.RequestOrBuilder> getRequestOrBuilderList() {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.request_);
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.Requests.class, Builder.class);
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
    
    public Builder mergeFrom(ApmProtos.Requests param1Requests) {
      if (param1Requests == ApmProtos.Requests.getDefaultInstance())
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
          RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = null;
          this.requestBuilder_ = null;
          this.request_ = param1Requests.request_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (ApmProtos.Requests.alwaysUseFieldBuilders)
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
        ApmProtos.Requests requests = (ApmProtos.Requests)ApmProtos.Requests.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.Requests requests = (ApmProtos.Requests)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.Requests)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.Requests)
        return mergeFrom((ApmProtos.Requests)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRequest(int param1Int) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    public Builder setRequest(int param1Int, ApmProtos.Request.Builder param1Builder) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequestIsMutable();
        this.request_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequest(int param1Int, ApmProtos.Request param1Request) {
      RepeatedFieldBuilderV3<ApmProtos.Request, ApmProtos.Request.Builder, ApmProtos.RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
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
    
    ApmProtos.Request getRequest(int param1Int);
    
    int getRequestCount();
    
    List<ApmProtos.Request> getRequestList();
    
    ApmProtos.RequestOrBuilder getRequestOrBuilder(int param1Int);
    
    List<? extends ApmProtos.RequestOrBuilder> getRequestOrBuilderList();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public ApmProtos.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.Response(param2CodedInputStream, param2ExtensionRegistryLite);
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
      return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
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
      return ApmProtos.internal_static_com_blued_das_apm_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.ResponseOrBuilder {
      private int code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.Response build() {
        ApmProtos.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public ApmProtos.Response buildPartial() {
        ApmProtos.Response response = new ApmProtos.Response(this);
        ApmProtos.Response.access$15602(response, this.code_);
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
      
      public ApmProtos.Response getDefaultInstanceForType() {
        return ApmProtos.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.Response param2Response) {
        if (param2Response == ApmProtos.Response.getDefaultInstance())
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
          ApmProtos.Response response = (ApmProtos.Response)ApmProtos.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.Response response = (ApmProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.Response)
          return mergeFrom((ApmProtos.Response)param2Message); 
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
    public ApmProtos.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.Response(param1CodedInputStream, param1ExtensionRegistryLite);
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
      return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.Response build() {
      ApmProtos.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public ApmProtos.Response buildPartial() {
      ApmProtos.Response response = new ApmProtos.Response(this);
      ApmProtos.Response.access$15602(response, this.code_);
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
    
    public ApmProtos.Response getDefaultInstanceForType() {
      return ApmProtos.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_Response_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.Response param1Response) {
      if (param1Response == ApmProtos.Response.getDefaultInstance())
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
        ApmProtos.Response response = (ApmProtos.Response)ApmProtos.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.Response response = (ApmProtos.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.Response)
        return mergeFrom((ApmProtos.Response)param1Message); 
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
  
  public static final class SocketTypeProto extends GeneratedMessageV3 implements SocketTypeProtoOrBuilder {
    private static final SocketTypeProto DEFAULT_INSTANCE = new SocketTypeProto();
    
    public static final int HOST_FIELD_NUMBER = 1;
    
    private static final Parser<SocketTypeProto> PARSER = (Parser<SocketTypeProto>)new AbstractParser<SocketTypeProto>() {
        public ApmProtos.SocketTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.SocketTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PORT_FIELD_NUMBER = 2;
    
    public static final int SERVER_IP_FIELD_NUMBER = 3;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object host_;
    
    private byte memoizedIsInitialized = -1;
    
    private int port_;
    
    private volatile Object serverIp_;
    
    private SocketTypeProto() {
      this.host_ = "";
      this.serverIp_ = "";
    }
    
    private SocketTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.serverIp_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.port_ = param1CodedInputStream.readInt32();
                continue;
              } 
              this.host_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private SocketTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static SocketTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SocketTypeProto param1SocketTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1SocketTypeProto);
    }
    
    public static SocketTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (SocketTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static SocketTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SocketTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SocketTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (SocketTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static SocketTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SocketTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static SocketTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (SocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static SocketTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static SocketTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (SocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static SocketTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SocketTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SocketTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (SocketTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static SocketTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SocketTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static SocketTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (SocketTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static SocketTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SocketTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<SocketTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof SocketTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getHost().equals(param1Object.getHost()) ? false : ((getPort() != param1Object.getPort()) ? false : (!getServerIp().equals(param1Object.getServerIp()) ? false : (!!this.unknownFields.equals(((SocketTypeProto)param1Object).unknownFields))));
    }
    
    public SocketTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.host_ = object;
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<SocketTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getPort() {
      return this.port_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getHostBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.host_); 
      int k = this.port_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(2, k); 
      j = i;
      if (!getServerIpBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.serverIp_); 
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
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getHost().hashCode()) * 37 + 2) * 53 + getPort()) * 37 + 3) * 53 + getServerIp().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocketTypeProto.class, Builder.class);
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
      return new SocketTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getHostBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.host_); 
      int i = this.port_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      if (!getServerIpBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.serverIp_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.SocketTypeProtoOrBuilder {
      private Object host_ = "";
      
      private int port_;
      
      private Object serverIp_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.SocketTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.SocketTypeProto build() {
        ApmProtos.SocketTypeProto socketTypeProto = buildPartial();
        if (socketTypeProto.isInitialized())
          return socketTypeProto; 
        throw newUninitializedMessageException(socketTypeProto);
      }
      
      public ApmProtos.SocketTypeProto buildPartial() {
        ApmProtos.SocketTypeProto socketTypeProto = new ApmProtos.SocketTypeProto(this);
        ApmProtos.SocketTypeProto.access$7502(socketTypeProto, this.host_);
        ApmProtos.SocketTypeProto.access$7602(socketTypeProto, this.port_);
        ApmProtos.SocketTypeProto.access$7702(socketTypeProto, this.serverIp_);
        onBuilt();
        return socketTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.host_ = "";
        this.port_ = 0;
        this.serverIp_ = "";
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearHost() {
        this.host_ = ApmProtos.SocketTypeProto.getDefaultInstance().getHost();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPort() {
        this.port_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearServerIp() {
        this.serverIp_ = ApmProtos.SocketTypeProto.getDefaultInstance().getServerIp();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.SocketTypeProto getDefaultInstanceForType() {
        return ApmProtos.SocketTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
      }
      
      public String getHost() {
        Object object = this.host_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.host_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getHostBytes() {
        Object object = this.host_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.host_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getPort() {
        return this.port_;
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
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.SocketTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.SocketTypeProto param2SocketTypeProto) {
        if (param2SocketTypeProto == ApmProtos.SocketTypeProto.getDefaultInstance())
          return this; 
        if (!param2SocketTypeProto.getHost().isEmpty()) {
          this.host_ = param2SocketTypeProto.host_;
          onChanged();
        } 
        if (param2SocketTypeProto.getPort() != 0)
          setPort(param2SocketTypeProto.getPort()); 
        if (!param2SocketTypeProto.getServerIp().isEmpty()) {
          this.serverIp_ = param2SocketTypeProto.serverIp_;
          onChanged();
        } 
        mergeUnknownFields(param2SocketTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.SocketTypeProto socketTypeProto = (ApmProtos.SocketTypeProto)ApmProtos.SocketTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.SocketTypeProto socketTypeProto = (ApmProtos.SocketTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.SocketTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.SocketTypeProto)
          return mergeFrom((ApmProtos.SocketTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setHost(String param2String) {
        if (param2String != null) {
          this.host_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setHostBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.SocketTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.host_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPort(int param2Int) {
        this.port_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
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
          ApmProtos.SocketTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.serverIp_ = param2ByteString;
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
  
  static final class null extends AbstractParser<SocketTypeProto> {
    public ApmProtos.SocketTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.SocketTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<SocketTypeProto.Builder> implements SocketTypeProtoOrBuilder {
    private Object host_ = "";
    
    private int port_;
    
    private Object serverIp_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.SocketTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.SocketTypeProto build() {
      ApmProtos.SocketTypeProto socketTypeProto = buildPartial();
      if (socketTypeProto.isInitialized())
        return socketTypeProto; 
      throw newUninitializedMessageException(socketTypeProto);
    }
    
    public ApmProtos.SocketTypeProto buildPartial() {
      ApmProtos.SocketTypeProto socketTypeProto = new ApmProtos.SocketTypeProto(this);
      ApmProtos.SocketTypeProto.access$7502(socketTypeProto, this.host_);
      ApmProtos.SocketTypeProto.access$7602(socketTypeProto, this.port_);
      ApmProtos.SocketTypeProto.access$7702(socketTypeProto, this.serverIp_);
      onBuilt();
      return socketTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.host_ = "";
      this.port_ = 0;
      this.serverIp_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHost() {
      this.host_ = ApmProtos.SocketTypeProto.getDefaultInstance().getHost();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPort() {
      this.port_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearServerIp() {
      this.serverIp_ = ApmProtos.SocketTypeProto.getDefaultInstance().getServerIp();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.SocketTypeProto getDefaultInstanceForType() {
      return ApmProtos.SocketTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_descriptor;
    }
    
    public String getHost() {
      Object object = this.host_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.host_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getHostBytes() {
      Object object = this.host_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.host_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getPort() {
      return this.port_;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_SocketTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.SocketTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.SocketTypeProto param1SocketTypeProto) {
      if (param1SocketTypeProto == ApmProtos.SocketTypeProto.getDefaultInstance())
        return this; 
      if (!param1SocketTypeProto.getHost().isEmpty()) {
        this.host_ = param1SocketTypeProto.host_;
        onChanged();
      } 
      if (param1SocketTypeProto.getPort() != 0)
        setPort(param1SocketTypeProto.getPort()); 
      if (!param1SocketTypeProto.getServerIp().isEmpty()) {
        this.serverIp_ = param1SocketTypeProto.serverIp_;
        onChanged();
      } 
      mergeUnknownFields(param1SocketTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.SocketTypeProto socketTypeProto = (ApmProtos.SocketTypeProto)ApmProtos.SocketTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.SocketTypeProto socketTypeProto = (ApmProtos.SocketTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.SocketTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.SocketTypeProto)
        return mergeFrom((ApmProtos.SocketTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHost(String param1String) {
      if (param1String != null) {
        this.host_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHostBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.SocketTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.host_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPort(int param1Int) {
      this.port_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
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
        ApmProtos.SocketTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.serverIp_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface SocketTypeProtoOrBuilder extends MessageOrBuilder {
    String getHost();
    
    ByteString getHostBytes();
    
    int getPort();
    
    String getServerIp();
    
    ByteString getServerIpBytes();
  }
  
  public enum Type implements ProtocolMessageEnum {
    EROS_GRPC(0),
    EROS_SOCKET(0),
    GRPC_CONNECT(0),
    GRPC_REQUEST(0),
    HTTP(0),
    IM(0),
    OPEN_TIME(0),
    SOCKET(0),
    UNKNOWN(0),
    UNRECOGNIZED(0),
    WEB(0);
    
    public static final int EROS_GRPC_VALUE = 5;
    
    public static final int EROS_SOCKET_VALUE = 6;
    
    public static final int GRPC_CONNECT_VALUE = 8;
    
    public static final int GRPC_REQUEST_VALUE = 9;
    
    public static final int HTTP_VALUE = 1;
    
    public static final int IM_VALUE = 2;
    
    public static final int OPEN_TIME_VALUE = 7;
    
    public static final int SOCKET_VALUE = 3;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Type[] VALUES;
    
    public static final int WEB_VALUE = 4;
    
    private static final Internal.EnumLiteMap<Type> internalValueMap;
    
    private final int value;
    
    static {
      EROS_GRPC = new Type("EROS_GRPC", 5, 5);
      EROS_SOCKET = new Type("EROS_SOCKET", 6, 6);
      OPEN_TIME = new Type("OPEN_TIME", 7, 7);
      GRPC_CONNECT = new Type("GRPC_CONNECT", 8, 8);
      GRPC_REQUEST = new Type("GRPC_REQUEST", 9, 9);
      UNRECOGNIZED = new Type("UNRECOGNIZED", 10, -1);
      $VALUES = new Type[] { 
          UNKNOWN, HTTP, IM, SOCKET, WEB, EROS_GRPC, EROS_SOCKET, OPEN_TIME, GRPC_CONNECT, GRPC_REQUEST, 
          UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Type>() {
          public ApmProtos.Type findValueByNumber(int param2Int) {
            return ApmProtos.Type.forNumber(param2Int);
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
        case 9:
          return GRPC_REQUEST;
        case 8:
          return GRPC_CONNECT;
        case 7:
          return OPEN_TIME;
        case 6:
          return EROS_SOCKET;
        case 5:
          return EROS_GRPC;
        case 4:
          return WEB;
        case 3:
          return SOCKET;
        case 2:
          return IM;
        case 1:
          return HTTP;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ApmProtos.getDescriptor().getEnumTypes().get(0);
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
    public ApmProtos.Type findValueByNumber(int param1Int) {
      return ApmProtos.Type.forNumber(param1Int);
    }
  }
  
  public static final class WebTypeProto extends GeneratedMessageV3 implements WebTypeProtoOrBuilder {
    private static final WebTypeProto DEFAULT_INSTANCE = new WebTypeProto();
    
    private static final Parser<WebTypeProto> PARSER = (Parser<WebTypeProto>)new AbstractParser<WebTypeProto>() {
        public ApmProtos.WebTypeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ApmProtos.WebTypeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int URL_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object url_;
    
    private WebTypeProto() {
      this.url_ = "";
    }
    
    private WebTypeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.url_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private WebTypeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static WebTypeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(WebTypeProto param1WebTypeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1WebTypeProto);
    }
    
    public static WebTypeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (WebTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static WebTypeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (WebTypeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static WebTypeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (WebTypeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static WebTypeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (WebTypeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static WebTypeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (WebTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static WebTypeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (WebTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static WebTypeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (WebTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static WebTypeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (WebTypeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static WebTypeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (WebTypeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static WebTypeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (WebTypeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static WebTypeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (WebTypeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static WebTypeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (WebTypeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<WebTypeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof WebTypeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getUrl().equals(param1Object.getUrl()) ? false : (!!this.unknownFields.equals(((WebTypeProto)param1Object).unknownFields));
    }
    
    public WebTypeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<WebTypeProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!getUrlBytes().isEmpty())
        i = 0 + GeneratedMessageV3.computeStringSize(1, this.url_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.url_ = object;
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getUrl().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(WebTypeProto.class, Builder.class);
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
      return new WebTypeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.url_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApmProtos.WebTypeProtoOrBuilder {
      private Object url_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ApmProtos.WebTypeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ApmProtos.WebTypeProto build() {
        ApmProtos.WebTypeProto webTypeProto = buildPartial();
        if (webTypeProto.isInitialized())
          return webTypeProto; 
        throw newUninitializedMessageException(webTypeProto);
      }
      
      public ApmProtos.WebTypeProto buildPartial() {
        ApmProtos.WebTypeProto webTypeProto = new ApmProtos.WebTypeProto(this);
        ApmProtos.WebTypeProto.access$12402(webTypeProto, this.url_);
        onBuilt();
        return webTypeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.url_ = "";
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearUrl() {
        this.url_ = ApmProtos.WebTypeProto.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ApmProtos.WebTypeProto getDefaultInstanceForType() {
        return ApmProtos.WebTypeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
      }
      
      public String getUrl() {
        Object object = this.url_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.url_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getUrlBytes() {
        Object object = this.url_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.url_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.WebTypeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ApmProtos.WebTypeProto param2WebTypeProto) {
        if (param2WebTypeProto == ApmProtos.WebTypeProto.getDefaultInstance())
          return this; 
        if (!param2WebTypeProto.getUrl().isEmpty()) {
          this.url_ = param2WebTypeProto.url_;
          onChanged();
        } 
        mergeUnknownFields(param2WebTypeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ApmProtos.WebTypeProto webTypeProto = (ApmProtos.WebTypeProto)ApmProtos.WebTypeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ApmProtos.WebTypeProto webTypeProto = (ApmProtos.WebTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ApmProtos.WebTypeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ApmProtos.WebTypeProto)
          return mergeFrom((ApmProtos.WebTypeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
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
      
      public Builder setUrl(String param2String) {
        if (param2String != null) {
          this.url_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUrlBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ApmProtos.WebTypeProto.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
    }
  }
  
  static final class null extends AbstractParser<WebTypeProto> {
    public ApmProtos.WebTypeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ApmProtos.WebTypeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<WebTypeProto.Builder> implements WebTypeProtoOrBuilder {
    private Object url_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ApmProtos.WebTypeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ApmProtos.WebTypeProto build() {
      ApmProtos.WebTypeProto webTypeProto = buildPartial();
      if (webTypeProto.isInitialized())
        return webTypeProto; 
      throw newUninitializedMessageException(webTypeProto);
    }
    
    public ApmProtos.WebTypeProto buildPartial() {
      ApmProtos.WebTypeProto webTypeProto = new ApmProtos.WebTypeProto(this);
      ApmProtos.WebTypeProto.access$12402(webTypeProto, this.url_);
      onBuilt();
      return webTypeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.url_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearUrl() {
      this.url_ = ApmProtos.WebTypeProto.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ApmProtos.WebTypeProto getDefaultInstanceForType() {
      return ApmProtos.WebTypeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_descriptor;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.url_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApmProtos.internal_static_com_blued_das_apm_WebTypeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ApmProtos.WebTypeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ApmProtos.WebTypeProto param1WebTypeProto) {
      if (param1WebTypeProto == ApmProtos.WebTypeProto.getDefaultInstance())
        return this; 
      if (!param1WebTypeProto.getUrl().isEmpty()) {
        this.url_ = param1WebTypeProto.url_;
        onChanged();
      } 
      mergeUnknownFields(param1WebTypeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ApmProtos.WebTypeProto webTypeProto = (ApmProtos.WebTypeProto)ApmProtos.WebTypeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ApmProtos.WebTypeProto webTypeProto = (ApmProtos.WebTypeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ApmProtos.WebTypeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ApmProtos.WebTypeProto)
        return mergeFrom((ApmProtos.WebTypeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
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
    
    public Builder setUrl(String param1String) {
      if (param1String != null) {
        this.url_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ApmProtos.WebTypeProto.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  public static interface WebTypeProtoOrBuilder extends MessageOrBuilder {
    String getUrl();
    
    ByteString getUrlBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\apm\ApmProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
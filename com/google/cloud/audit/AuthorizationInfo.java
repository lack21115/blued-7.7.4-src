package com.google.cloud.audit;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AuthorizationInfo extends GeneratedMessageV3 implements AuthorizationInfoOrBuilder {
  private static final AuthorizationInfo DEFAULT_INSTANCE = new AuthorizationInfo();
  
  public static final int GRANTED_FIELD_NUMBER = 3;
  
  private static final Parser<AuthorizationInfo> PARSER = (Parser<AuthorizationInfo>)new AbstractParser<AuthorizationInfo>() {
      public AuthorizationInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new AuthorizationInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PERMISSION_FIELD_NUMBER = 2;
  
  public static final int RESOURCE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private boolean granted_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object permission_;
  
  private volatile Object resource_;
  
  private AuthorizationInfo() {
    this.resource_ = "";
    this.permission_ = "";
  }
  
  private AuthorizationInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 24) {
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.granted_ = paramCodedInputStream.readBool();
                continue;
              } 
              this.permission_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.resource_ = paramCodedInputStream.readStringRequireUtf8();
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
        throw paramCodedInputStream;
      } 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private AuthorizationInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static AuthorizationInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuditLogProto.e;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthorizationInfo paramAuthorizationInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuthorizationInfo);
  }
  
  public static AuthorizationInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthorizationInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthorizationInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static AuthorizationInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthorizationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static AuthorizationInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthorizationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthorizationInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static AuthorizationInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static AuthorizationInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthorizationInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof AuthorizationInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getResource().equals(paramObject.getResource()) ? false : (!getPermission().equals(paramObject.getPermission()) ? false : ((getGranted() != paramObject.getGranted()) ? false : (!!this.unknownFields.equals(((AuthorizationInfo)paramObject).unknownFields))));
  }
  
  public AuthorizationInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public boolean getGranted() {
    return this.granted_;
  }
  
  public Parser<AuthorizationInfo> getParserForType() {
    return PARSER;
  }
  
  public String getPermission() {
    Object object = this.permission_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.permission_ = object;
    return (String)object;
  }
  
  public ByteString getPermissionBytes() {
    Object object = this.permission_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.permission_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getResource() {
    Object object = this.resource_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.resource_ = object;
    return (String)object;
  }
  
  public ByteString getResourceBytes() {
    Object object = this.resource_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.resource_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getResourceBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.resource_); 
    i = j;
    if (!getPermissionBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.permission_); 
    boolean bool = this.granted_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getResource().hashCode()) * 37 + 2) * 53 + getPermission().hashCode()) * 37 + 3) * 53 + Internal.hashBoolean(getGranted())) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuditLogProto.f.ensureFieldAccessorsInitialized(AuthorizationInfo.class, Builder.class);
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
    if (!getResourceBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.resource_); 
    if (!getPermissionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.permission_); 
    boolean bool = this.granted_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthorizationInfoOrBuilder {
    private boolean granted_;
    
    private Object permission_ = "";
    
    private Object resource_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuditLogProto.e;
    }
    
    private void maybeForceBuilderInitialization() {
      AuthorizationInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AuthorizationInfo build() {
      AuthorizationInfo authorizationInfo = buildPartial();
      if (authorizationInfo.isInitialized())
        return authorizationInfo; 
      throw newUninitializedMessageException(authorizationInfo);
    }
    
    public AuthorizationInfo buildPartial() {
      AuthorizationInfo authorizationInfo = new AuthorizationInfo(this);
      AuthorizationInfo.access$402(authorizationInfo, this.resource_);
      AuthorizationInfo.access$502(authorizationInfo, this.permission_);
      AuthorizationInfo.access$602(authorizationInfo, this.granted_);
      onBuilt();
      return authorizationInfo;
    }
    
    public Builder clear() {
      super.clear();
      this.resource_ = "";
      this.permission_ = "";
      this.granted_ = false;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearGranted() {
      this.granted_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPermission() {
      this.permission_ = AuthorizationInfo.getDefaultInstance().getPermission();
      onChanged();
      return this;
    }
    
    public Builder clearResource() {
      this.resource_ = AuthorizationInfo.getDefaultInstance().getResource();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public AuthorizationInfo getDefaultInstanceForType() {
      return AuthorizationInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuditLogProto.e;
    }
    
    public boolean getGranted() {
      return this.granted_;
    }
    
    public String getPermission() {
      Object object = this.permission_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.permission_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPermissionBytes() {
      Object object = this.permission_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.permission_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getResource() {
      Object object = this.resource_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.resource_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResourceBytes() {
      Object object = this.resource_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.resource_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuditLogProto.f.ensureFieldAccessorsInitialized(AuthorizationInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(AuthorizationInfo param1AuthorizationInfo) {
      if (param1AuthorizationInfo == AuthorizationInfo.getDefaultInstance())
        return this; 
      if (!param1AuthorizationInfo.getResource().isEmpty()) {
        this.resource_ = param1AuthorizationInfo.resource_;
        onChanged();
      } 
      if (!param1AuthorizationInfo.getPermission().isEmpty()) {
        this.permission_ = param1AuthorizationInfo.permission_;
        onChanged();
      } 
      if (param1AuthorizationInfo.getGranted())
        setGranted(param1AuthorizationInfo.getGranted()); 
      mergeUnknownFields(param1AuthorizationInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AuthorizationInfo authorizationInfo = (AuthorizationInfo)AuthorizationInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AuthorizationInfo authorizationInfo = (AuthorizationInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AuthorizationInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AuthorizationInfo)
        return mergeFrom((AuthorizationInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setGranted(boolean param1Boolean) {
      this.granted_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setPermission(String param1String) {
      if (param1String != null) {
        this.permission_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPermissionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthorizationInfo.checkByteStringIsUtf8(param1ByteString);
        this.permission_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setResource(String param1String) {
      if (param1String != null) {
        this.resource_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResourceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthorizationInfo.checkByteStringIsUtf8(param1ByteString);
        this.resource_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuthorizationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
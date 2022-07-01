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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AuthenticationInfo extends GeneratedMessageV3 implements AuthenticationInfoOrBuilder {
  private static final AuthenticationInfo DEFAULT_INSTANCE = new AuthenticationInfo();
  
  private static final Parser<AuthenticationInfo> PARSER = (Parser<AuthenticationInfo>)new AbstractParser<AuthenticationInfo>() {
      public AuthenticationInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new AuthenticationInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PRINCIPAL_EMAIL_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object principalEmail_;
  
  private AuthenticationInfo() {
    this.principalEmail_ = "";
  }
  
  private AuthenticationInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                continue; 
              continue;
            } 
            this.principalEmail_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private AuthenticationInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static AuthenticationInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuditLogProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthenticationInfo paramAuthenticationInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuthenticationInfo);
  }
  
  public static AuthenticationInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthenticationInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthenticationInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthenticationInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static AuthenticationInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthenticationInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthenticationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static AuthenticationInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthenticationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthenticationInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (AuthenticationInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static AuthenticationInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static AuthenticationInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthenticationInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static AuthenticationInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthenticationInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof AuthenticationInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getPrincipalEmail().equals(paramObject.getPrincipalEmail()) ? false : (!!this.unknownFields.equals(((AuthenticationInfo)paramObject).unknownFields));
  }
  
  public AuthenticationInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<AuthenticationInfo> getParserForType() {
    return PARSER;
  }
  
  public String getPrincipalEmail() {
    Object object = this.principalEmail_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.principalEmail_ = object;
    return (String)object;
  }
  
  public ByteString getPrincipalEmailBytes() {
    Object object = this.principalEmail_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.principalEmail_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getPrincipalEmailBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.principalEmail_); 
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
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getPrincipalEmail().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuditLogProto.d.ensureFieldAccessorsInitialized(AuthenticationInfo.class, Builder.class);
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
    if (!getPrincipalEmailBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.principalEmail_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationInfoOrBuilder {
    private Object principalEmail_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuditLogProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      AuthenticationInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AuthenticationInfo build() {
      AuthenticationInfo authenticationInfo = buildPartial();
      if (authenticationInfo.isInitialized())
        return authenticationInfo; 
      throw newUninitializedMessageException(authenticationInfo);
    }
    
    public AuthenticationInfo buildPartial() {
      AuthenticationInfo authenticationInfo = new AuthenticationInfo(this);
      AuthenticationInfo.access$402(authenticationInfo, this.principalEmail_);
      onBuilt();
      return authenticationInfo;
    }
    
    public Builder clear() {
      super.clear();
      this.principalEmail_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPrincipalEmail() {
      this.principalEmail_ = AuthenticationInfo.getDefaultInstance().getPrincipalEmail();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public AuthenticationInfo getDefaultInstanceForType() {
      return AuthenticationInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuditLogProto.c;
    }
    
    public String getPrincipalEmail() {
      Object object = this.principalEmail_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.principalEmail_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPrincipalEmailBytes() {
      Object object = this.principalEmail_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.principalEmail_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuditLogProto.d.ensureFieldAccessorsInitialized(AuthenticationInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(AuthenticationInfo param1AuthenticationInfo) {
      if (param1AuthenticationInfo == AuthenticationInfo.getDefaultInstance())
        return this; 
      if (!param1AuthenticationInfo.getPrincipalEmail().isEmpty()) {
        this.principalEmail_ = param1AuthenticationInfo.principalEmail_;
        onChanged();
      } 
      mergeUnknownFields(param1AuthenticationInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AuthenticationInfo authenticationInfo = (AuthenticationInfo)AuthenticationInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AuthenticationInfo authenticationInfo = (AuthenticationInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AuthenticationInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AuthenticationInfo)
        return mergeFrom((AuthenticationInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setPrincipalEmail(String param1String) {
      if (param1String != null) {
        this.principalEmail_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPrincipalEmailBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthenticationInfo.checkByteStringIsUtf8(param1ByteString);
        this.principalEmail_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuthenticationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
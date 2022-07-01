package com.google.api;

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

public final class AuthProvider extends GeneratedMessageV3 implements AuthProviderOrBuilder {
  public static final int AUDIENCES_FIELD_NUMBER = 4;
  
  public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
  
  private static final AuthProvider DEFAULT_INSTANCE = new AuthProvider();
  
  public static final int ID_FIELD_NUMBER = 1;
  
  public static final int ISSUER_FIELD_NUMBER = 2;
  
  public static final int JWKS_URI_FIELD_NUMBER = 3;
  
  private static final Parser<AuthProvider> PARSER = (Parser<AuthProvider>)new AbstractParser<AuthProvider>() {
      public AuthProvider a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new AuthProvider(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object audiences_;
  
  private volatile Object authorizationUrl_;
  
  private volatile Object id_;
  
  private volatile Object issuer_;
  
  private volatile Object jwksUri_;
  
  private byte memoizedIsInitialized = -1;
  
  private AuthProvider() {
    this.id_ = "";
    this.issuer_ = "";
    this.jwksUri_ = "";
    this.audiences_ = "";
    this.authorizationUrl_ = "";
  }
  
  private AuthProvider(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 26) {
                  if (i != 34) {
                    if (i != 42) {
                      if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.authorizationUrl_ = paramCodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.audiences_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.jwksUri_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.issuer_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.id_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private AuthProvider(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static AuthProvider getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuthProto.e;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthProvider paramAuthProvider) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuthProvider);
  }
  
  public static AuthProvider parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthProvider)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthProvider parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthProvider)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthProvider)PARSER.parseFrom(paramByteString);
  }
  
  public static AuthProvider parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthProvider)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthProvider)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static AuthProvider parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthProvider)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthProvider)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthProvider parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthProvider)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (AuthProvider)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static AuthProvider parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthProvider)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthProvider)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static AuthProvider parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthProvider)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthProvider> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof AuthProvider))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getId().equals(paramObject.getId()) ? false : (!getIssuer().equals(paramObject.getIssuer()) ? false : (!getJwksUri().equals(paramObject.getJwksUri()) ? false : (!getAudiences().equals(paramObject.getAudiences()) ? false : (!getAuthorizationUrl().equals(paramObject.getAuthorizationUrl()) ? false : (!!this.unknownFields.equals(((AuthProvider)paramObject).unknownFields))))));
  }
  
  public String getAudiences() {
    Object object = this.audiences_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.audiences_ = object;
    return (String)object;
  }
  
  public ByteString getAudiencesBytes() {
    Object object = this.audiences_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.audiences_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getAuthorizationUrl() {
    Object object = this.authorizationUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.authorizationUrl_ = object;
    return (String)object;
  }
  
  public ByteString getAuthorizationUrlBytes() {
    Object object = this.authorizationUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.authorizationUrl_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public AuthProvider getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
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
  
  public String getIssuer() {
    Object object = this.issuer_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.issuer_ = object;
    return (String)object;
  }
  
  public ByteString getIssuerBytes() {
    Object object = this.issuer_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.issuer_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getJwksUri() {
    Object object = this.jwksUri_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.jwksUri_ = object;
    return (String)object;
  }
  
  public ByteString getJwksUriBytes() {
    Object object = this.jwksUri_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.jwksUri_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<AuthProvider> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getIdBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.id_); 
    i = j;
    if (!getIssuerBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.issuer_); 
    j = i;
    if (!getJwksUriBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.jwksUri_); 
    i = j;
    if (!getAudiencesBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(4, this.audiences_); 
    j = i;
    if (!getAuthorizationUrlBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(5, this.authorizationUrl_); 
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
    int i = (((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getId().hashCode()) * 37 + 2) * 53 + getIssuer().hashCode()) * 37 + 3) * 53 + getJwksUri().hashCode()) * 37 + 4) * 53 + getAudiences().hashCode()) * 37 + 5) * 53 + getAuthorizationUrl().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuthProto.f.ensureFieldAccessorsInitialized(AuthProvider.class, Builder.class);
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
    if (!getIdBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.id_); 
    if (!getIssuerBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.issuer_); 
    if (!getJwksUriBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.jwksUri_); 
    if (!getAudiencesBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.audiences_); 
    if (!getAuthorizationUrlBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.authorizationUrl_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthProviderOrBuilder {
    private Object audiences_ = "";
    
    private Object authorizationUrl_ = "";
    
    private Object id_ = "";
    
    private Object issuer_ = "";
    
    private Object jwksUri_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuthProto.e;
    }
    
    private void maybeForceBuilderInitialization() {
      AuthProvider.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AuthProvider build() {
      AuthProvider authProvider = buildPartial();
      if (authProvider.isInitialized())
        return authProvider; 
      throw newUninitializedMessageException(authProvider);
    }
    
    public AuthProvider buildPartial() {
      AuthProvider authProvider = new AuthProvider(this);
      AuthProvider.access$402(authProvider, this.id_);
      AuthProvider.access$502(authProvider, this.issuer_);
      AuthProvider.access$602(authProvider, this.jwksUri_);
      AuthProvider.access$702(authProvider, this.audiences_);
      AuthProvider.access$802(authProvider, this.authorizationUrl_);
      onBuilt();
      return authProvider;
    }
    
    public Builder clear() {
      super.clear();
      this.id_ = "";
      this.issuer_ = "";
      this.jwksUri_ = "";
      this.audiences_ = "";
      this.authorizationUrl_ = "";
      return this;
    }
    
    public Builder clearAudiences() {
      this.audiences_ = AuthProvider.getDefaultInstance().getAudiences();
      onChanged();
      return this;
    }
    
    public Builder clearAuthorizationUrl() {
      this.authorizationUrl_ = AuthProvider.getDefaultInstance().getAuthorizationUrl();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearId() {
      this.id_ = AuthProvider.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearIssuer() {
      this.issuer_ = AuthProvider.getDefaultInstance().getIssuer();
      onChanged();
      return this;
    }
    
    public Builder clearJwksUri() {
      this.jwksUri_ = AuthProvider.getDefaultInstance().getJwksUri();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAudiences() {
      Object object = this.audiences_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.audiences_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAudiencesBytes() {
      Object object = this.audiences_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.audiences_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getAuthorizationUrl() {
      Object object = this.authorizationUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.authorizationUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAuthorizationUrlBytes() {
      Object object = this.authorizationUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.authorizationUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public AuthProvider getDefaultInstanceForType() {
      return AuthProvider.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuthProto.e;
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
    
    public String getIssuer() {
      Object object = this.issuer_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.issuer_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIssuerBytes() {
      Object object = this.issuer_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.issuer_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getJwksUri() {
      Object object = this.jwksUri_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.jwksUri_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getJwksUriBytes() {
      Object object = this.jwksUri_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.jwksUri_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuthProto.f.ensureFieldAccessorsInitialized(AuthProvider.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(AuthProvider param1AuthProvider) {
      if (param1AuthProvider == AuthProvider.getDefaultInstance())
        return this; 
      if (!param1AuthProvider.getId().isEmpty()) {
        this.id_ = param1AuthProvider.id_;
        onChanged();
      } 
      if (!param1AuthProvider.getIssuer().isEmpty()) {
        this.issuer_ = param1AuthProvider.issuer_;
        onChanged();
      } 
      if (!param1AuthProvider.getJwksUri().isEmpty()) {
        this.jwksUri_ = param1AuthProvider.jwksUri_;
        onChanged();
      } 
      if (!param1AuthProvider.getAudiences().isEmpty()) {
        this.audiences_ = param1AuthProvider.audiences_;
        onChanged();
      } 
      if (!param1AuthProvider.getAuthorizationUrl().isEmpty()) {
        this.authorizationUrl_ = param1AuthProvider.authorizationUrl_;
        onChanged();
      } 
      mergeUnknownFields(param1AuthProvider.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AuthProvider authProvider = (AuthProvider)AuthProvider.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AuthProvider authProvider = (AuthProvider)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AuthProvider)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AuthProvider)
        return mergeFrom((AuthProvider)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAudiences(String param1String) {
      if (param1String != null) {
        this.audiences_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAudiencesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthProvider.checkByteStringIsUtf8(param1ByteString);
        this.audiences_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAuthorizationUrl(String param1String) {
      if (param1String != null) {
        this.authorizationUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAuthorizationUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthProvider.checkByteStringIsUtf8(param1ByteString);
        this.authorizationUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
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
        AuthProvider.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIssuer(String param1String) {
      if (param1String != null) {
        this.issuer_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIssuerBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthProvider.checkByteStringIsUtf8(param1ByteString);
        this.issuer_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setJwksUri(String param1String) {
      if (param1String != null) {
        this.jwksUri_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setJwksUriBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthProvider.checkByteStringIsUtf8(param1ByteString);
        this.jwksUri_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
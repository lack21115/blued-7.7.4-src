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

public final class AuthRequirement extends GeneratedMessageV3 implements AuthRequirementOrBuilder {
  public static final int AUDIENCES_FIELD_NUMBER = 2;
  
  private static final AuthRequirement DEFAULT_INSTANCE = new AuthRequirement();
  
  private static final Parser<AuthRequirement> PARSER = (Parser<AuthRequirement>)new AbstractParser<AuthRequirement>() {
      public AuthRequirement a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new AuthRequirement(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PROVIDER_ID_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object audiences_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object providerId_;
  
  private AuthRequirement() {
    this.providerId_ = "";
    this.audiences_ = "";
  }
  
  private AuthRequirement(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.audiences_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.providerId_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private AuthRequirement(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static AuthRequirement getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuthProto.i;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthRequirement paramAuthRequirement) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuthRequirement);
  }
  
  public static AuthRequirement parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthRequirement)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthRequirement parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthRequirement)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthRequirement)PARSER.parseFrom(paramByteString);
  }
  
  public static AuthRequirement parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthRequirement)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthRequirement)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static AuthRequirement parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthRequirement)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthRequirement)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthRequirement parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthRequirement)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (AuthRequirement)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static AuthRequirement parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthRequirement)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthRequirement)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static AuthRequirement parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthRequirement)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthRequirement> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof AuthRequirement))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getProviderId().equals(paramObject.getProviderId()) ? false : (!getAudiences().equals(paramObject.getAudiences()) ? false : (!!this.unknownFields.equals(((AuthRequirement)paramObject).unknownFields)));
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
  
  public AuthRequirement getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<AuthRequirement> getParserForType() {
    return PARSER;
  }
  
  public String getProviderId() {
    Object object = this.providerId_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.providerId_ = object;
    return (String)object;
  }
  
  public ByteString getProviderIdBytes() {
    Object object = this.providerId_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.providerId_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getProviderIdBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.providerId_); 
    int j = i;
    if (!getAudiencesBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.audiences_); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getProviderId().hashCode()) * 37 + 2) * 53 + getAudiences().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuthProto.j.ensureFieldAccessorsInitialized(AuthRequirement.class, Builder.class);
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
    if (!getProviderIdBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.providerId_); 
    if (!getAudiencesBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.audiences_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthRequirementOrBuilder {
    private Object audiences_ = "";
    
    private Object providerId_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuthProto.i;
    }
    
    private void maybeForceBuilderInitialization() {
      AuthRequirement.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AuthRequirement build() {
      AuthRequirement authRequirement = buildPartial();
      if (authRequirement.isInitialized())
        return authRequirement; 
      throw newUninitializedMessageException(authRequirement);
    }
    
    public AuthRequirement buildPartial() {
      AuthRequirement authRequirement = new AuthRequirement(this);
      AuthRequirement.access$402(authRequirement, this.providerId_);
      AuthRequirement.access$502(authRequirement, this.audiences_);
      onBuilt();
      return authRequirement;
    }
    
    public Builder clear() {
      super.clear();
      this.providerId_ = "";
      this.audiences_ = "";
      return this;
    }
    
    public Builder clearAudiences() {
      this.audiences_ = AuthRequirement.getDefaultInstance().getAudiences();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProviderId() {
      this.providerId_ = AuthRequirement.getDefaultInstance().getProviderId();
      onChanged();
      return this;
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
    
    public AuthRequirement getDefaultInstanceForType() {
      return AuthRequirement.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuthProto.i;
    }
    
    public String getProviderId() {
      Object object = this.providerId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.providerId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getProviderIdBytes() {
      Object object = this.providerId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.providerId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuthProto.j.ensureFieldAccessorsInitialized(AuthRequirement.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(AuthRequirement param1AuthRequirement) {
      if (param1AuthRequirement == AuthRequirement.getDefaultInstance())
        return this; 
      if (!param1AuthRequirement.getProviderId().isEmpty()) {
        this.providerId_ = param1AuthRequirement.providerId_;
        onChanged();
      } 
      if (!param1AuthRequirement.getAudiences().isEmpty()) {
        this.audiences_ = param1AuthRequirement.audiences_;
        onChanged();
      } 
      mergeUnknownFields(param1AuthRequirement.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AuthRequirement authRequirement = (AuthRequirement)AuthRequirement.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AuthRequirement authRequirement = (AuthRequirement)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AuthRequirement)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AuthRequirement)
        return mergeFrom((AuthRequirement)param1Message); 
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
        AuthRequirement.checkByteStringIsUtf8(param1ByteString);
        this.audiences_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProviderId(String param1String) {
      if (param1String != null) {
        this.providerId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setProviderIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthRequirement.checkByteStringIsUtf8(param1ByteString);
        this.providerId_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
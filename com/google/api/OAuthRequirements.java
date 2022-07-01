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

public final class OAuthRequirements extends GeneratedMessageV3 implements OAuthRequirementsOrBuilder {
  public static final int CANONICAL_SCOPES_FIELD_NUMBER = 1;
  
  private static final OAuthRequirements DEFAULT_INSTANCE = new OAuthRequirements();
  
  private static final Parser<OAuthRequirements> PARSER = (Parser<OAuthRequirements>)new AbstractParser<OAuthRequirements>() {
      public OAuthRequirements a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new OAuthRequirements(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object canonicalScopes_;
  
  private byte memoizedIsInitialized = -1;
  
  private OAuthRequirements() {
    this.canonicalScopes_ = "";
  }
  
  private OAuthRequirements(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            this.canonicalScopes_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private OAuthRequirements(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static OAuthRequirements getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuthProto.g;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(OAuthRequirements paramOAuthRequirements) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramOAuthRequirements);
  }
  
  public static OAuthRequirements parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (OAuthRequirements)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static OAuthRequirements parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (OAuthRequirements)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OAuthRequirements parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (OAuthRequirements)PARSER.parseFrom(paramByteString);
  }
  
  public static OAuthRequirements parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (OAuthRequirements)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static OAuthRequirements parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (OAuthRequirements)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static OAuthRequirements parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (OAuthRequirements)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static OAuthRequirements parseFrom(InputStream paramInputStream) throws IOException {
    return (OAuthRequirements)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static OAuthRequirements parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (OAuthRequirements)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static OAuthRequirements parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (OAuthRequirements)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static OAuthRequirements parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (OAuthRequirements)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static OAuthRequirements parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (OAuthRequirements)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static OAuthRequirements parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (OAuthRequirements)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<OAuthRequirements> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof OAuthRequirements))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getCanonicalScopes().equals(paramObject.getCanonicalScopes()) ? false : (!!this.unknownFields.equals(((OAuthRequirements)paramObject).unknownFields));
  }
  
  public String getCanonicalScopes() {
    Object object = this.canonicalScopes_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.canonicalScopes_ = object;
    return (String)object;
  }
  
  public ByteString getCanonicalScopesBytes() {
    Object object = this.canonicalScopes_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.canonicalScopes_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public OAuthRequirements getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<OAuthRequirements> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getCanonicalScopesBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.canonicalScopes_); 
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
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getCanonicalScopes().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuthProto.h.ensureFieldAccessorsInitialized(OAuthRequirements.class, Builder.class);
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
    if (!getCanonicalScopesBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.canonicalScopes_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OAuthRequirementsOrBuilder {
    private Object canonicalScopes_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuthProto.g;
    }
    
    private void maybeForceBuilderInitialization() {
      OAuthRequirements.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public OAuthRequirements build() {
      OAuthRequirements oAuthRequirements = buildPartial();
      if (oAuthRequirements.isInitialized())
        return oAuthRequirements; 
      throw newUninitializedMessageException(oAuthRequirements);
    }
    
    public OAuthRequirements buildPartial() {
      OAuthRequirements oAuthRequirements = new OAuthRequirements(this);
      OAuthRequirements.access$402(oAuthRequirements, this.canonicalScopes_);
      onBuilt();
      return oAuthRequirements;
    }
    
    public Builder clear() {
      super.clear();
      this.canonicalScopes_ = "";
      return this;
    }
    
    public Builder clearCanonicalScopes() {
      this.canonicalScopes_ = OAuthRequirements.getDefaultInstance().getCanonicalScopes();
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
    
    public String getCanonicalScopes() {
      Object object = this.canonicalScopes_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.canonicalScopes_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCanonicalScopesBytes() {
      Object object = this.canonicalScopes_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.canonicalScopes_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public OAuthRequirements getDefaultInstanceForType() {
      return OAuthRequirements.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuthProto.g;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuthProto.h.ensureFieldAccessorsInitialized(OAuthRequirements.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(OAuthRequirements param1OAuthRequirements) {
      if (param1OAuthRequirements == OAuthRequirements.getDefaultInstance())
        return this; 
      if (!param1OAuthRequirements.getCanonicalScopes().isEmpty()) {
        this.canonicalScopes_ = param1OAuthRequirements.canonicalScopes_;
        onChanged();
      } 
      mergeUnknownFields(param1OAuthRequirements.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        OAuthRequirements oAuthRequirements = (OAuthRequirements)OAuthRequirements.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        OAuthRequirements oAuthRequirements = (OAuthRequirements)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((OAuthRequirements)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof OAuthRequirements)
        return mergeFrom((OAuthRequirements)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCanonicalScopes(String param1String) {
      if (param1String != null) {
        this.canonicalScopes_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCanonicalScopesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        OAuthRequirements.checkByteStringIsUtf8(param1ByteString);
        this.canonicalScopes_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\OAuthRequirements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AuthenticationRule extends GeneratedMessageV3 implements AuthenticationRuleOrBuilder {
  public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
  
  private static final AuthenticationRule DEFAULT_INSTANCE = new AuthenticationRule();
  
  public static final int OAUTH_FIELD_NUMBER = 2;
  
  private static final Parser<AuthenticationRule> PARSER = (Parser<AuthenticationRule>)new AbstractParser<AuthenticationRule>() {
      public AuthenticationRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new AuthenticationRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int REQUIREMENTS_FIELD_NUMBER = 7;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private boolean allowWithoutCredential_;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private OAuthRequirements oauth_;
  
  private List<AuthRequirement> requirements_;
  
  private volatile Object selector_;
  
  private AuthenticationRule() {
    this.selector_ = "";
    this.requirements_ = Collections.emptyList();
  }
  
  private AuthenticationRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
          int n = paramCodedInputStream.readTag();
          if (n != 0) {
            if (n != 10) {
              if (n != 18) {
                if (n != 40) {
                  if (n != 58) {
                    j = i;
                    k = i;
                    m = i;
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                      continue; 
                    continue;
                  } 
                  n = i;
                  if ((i & 0x8) == 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.requirements_ = new ArrayList<AuthRequirement>();
                    n = i | 0x8;
                  } 
                  j = n;
                  k = n;
                  m = n;
                  this.requirements_.add(paramCodedInputStream.readMessage(AuthRequirement.parser(), paramExtensionRegistryLite));
                  i = n;
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.allowWithoutCredential_ = paramCodedInputStream.readBool();
                continue;
              } 
              OAuthRequirements.Builder builder1 = null;
              j = i;
              k = i;
              m = i;
              if (this.oauth_ != null) {
                j = i;
                k = i;
                m = i;
                builder1 = this.oauth_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.oauth_ = (OAuthRequirements)paramCodedInputStream.readMessage(OAuthRequirements.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                j = i;
                k = i;
                m = i;
                builder1.mergeFrom(this.oauth_);
                j = i;
                k = i;
                m = i;
                this.oauth_ = builder1.buildPartial();
              } 
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.selector_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x8) != 0)
          this.requirements_ = Collections.unmodifiableList(this.requirements_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x8) != 0)
        this.requirements_ = Collections.unmodifiableList(this.requirements_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private AuthenticationRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static AuthenticationRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuthProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthenticationRule paramAuthenticationRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuthenticationRule);
  }
  
  public static AuthenticationRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthenticationRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthenticationRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthenticationRule)PARSER.parseFrom(paramByteString);
  }
  
  public static AuthenticationRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthenticationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static AuthenticationRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthenticationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static AuthenticationRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (AuthenticationRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static AuthenticationRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthenticationRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static AuthenticationRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthenticationRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof AuthenticationRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : ((hasOauth() != paramObject.hasOauth()) ? false : ((hasOauth() && !getOauth().equals(paramObject.getOauth())) ? false : ((getAllowWithoutCredential() != paramObject.getAllowWithoutCredential()) ? false : (!getRequirementsList().equals(paramObject.getRequirementsList()) ? false : (!!this.unknownFields.equals(((AuthenticationRule)paramObject).unknownFields))))));
  }
  
  public boolean getAllowWithoutCredential() {
    return this.allowWithoutCredential_;
  }
  
  public AuthenticationRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public OAuthRequirements getOauth() {
    OAuthRequirements oAuthRequirements2 = this.oauth_;
    OAuthRequirements oAuthRequirements1 = oAuthRequirements2;
    if (oAuthRequirements2 == null)
      oAuthRequirements1 = OAuthRequirements.getDefaultInstance(); 
    return oAuthRequirements1;
  }
  
  public OAuthRequirementsOrBuilder getOauthOrBuilder() {
    return getOauth();
  }
  
  public Parser<AuthenticationRule> getParserForType() {
    return PARSER;
  }
  
  public AuthRequirement getRequirements(int paramInt) {
    return this.requirements_.get(paramInt);
  }
  
  public int getRequirementsCount() {
    return this.requirements_.size();
  }
  
  public List<AuthRequirement> getRequirementsList() {
    return this.requirements_;
  }
  
  public AuthRequirementOrBuilder getRequirementsOrBuilder(int paramInt) {
    return this.requirements_.get(paramInt);
  }
  
  public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
    return (List)this.requirements_;
  }
  
  public String getSelector() {
    Object object = this.selector_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.selector_ = object;
    return (String)object;
  }
  
  public ByteString getSelectorBytes() {
    Object object = this.selector_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.selector_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getSelectorBytes().isEmpty();
    byte b = 0;
    if (!bool) {
      j = GeneratedMessageV3.computeStringSize(1, this.selector_) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (this.oauth_ != null)
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getOauth()); 
    bool = this.allowWithoutCredential_;
    int j = i;
    int k = b;
    if (bool) {
      j = i + CodedOutputStream.computeBoolSize(5, bool);
      k = b;
    } 
    while (k < this.requirements_.size()) {
      j += CodedOutputStream.computeMessageSize(7, (MessageLite)this.requirements_.get(k));
      k++;
    } 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasOauth() {
    return (this.oauth_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode();
    int i = j;
    if (hasOauth())
      i = (j * 37 + 2) * 53 + getOauth().hashCode(); 
    j = (i * 37 + 5) * 53 + Internal.hashBoolean(getAllowWithoutCredential());
    i = j;
    if (getRequirementsCount() > 0)
      i = (j * 37 + 7) * 53 + getRequirementsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuthProto.d.ensureFieldAccessorsInitialized(AuthenticationRule.class, Builder.class);
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
    if (!getSelectorBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.selector_); 
    if (this.oauth_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getOauth()); 
    boolean bool = this.allowWithoutCredential_;
    if (bool)
      paramCodedOutputStream.writeBool(5, bool); 
    for (int i = 0; i < this.requirements_.size(); i++)
      paramCodedOutputStream.writeMessage(7, (MessageLite)this.requirements_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationRuleOrBuilder {
    private boolean allowWithoutCredential_;
    
    private int bitField0_;
    
    private SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> oauthBuilder_;
    
    private OAuthRequirements oauth_;
    
    private RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> requirementsBuilder_;
    
    private List<AuthRequirement> requirements_ = Collections.emptyList();
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRequirementsIsMutable() {
      if ((this.bitField0_ & 0x8) == 0) {
        this.requirements_ = new ArrayList<AuthRequirement>(this.requirements_);
        this.bitField0_ |= 0x8;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuthProto.c;
    }
    
    private SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> getOauthFieldBuilder() {
      if (this.oauthBuilder_ == null) {
        this.oauthBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getOauth(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.oauth_ = null;
      } 
      return this.oauthBuilder_;
    }
    
    private RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> getRequirementsFieldBuilder() {
      if (this.requirementsBuilder_ == null) {
        boolean bool;
        List<AuthRequirement> list = this.requirements_;
        if ((this.bitField0_ & 0x8) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.requirementsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.requirements_ = null;
      } 
      return this.requirementsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (AuthenticationRule.alwaysUseFieldBuilders)
        getRequirementsFieldBuilder(); 
    }
    
    public Builder addAllRequirements(Iterable<? extends AuthRequirement> param1Iterable) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.requirements_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRequirements(int param1Int, AuthRequirement.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequirementsIsMutable();
        this.requirements_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequirements(int param1Int, AuthRequirement param1AuthRequirement) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthRequirement != null) {
          ensureRequirementsIsMutable();
          this.requirements_.add(param1Int, param1AuthRequirement);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1AuthRequirement);
      return this;
    }
    
    public Builder addRequirements(AuthRequirement.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequirementsIsMutable();
        this.requirements_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRequirements(AuthRequirement param1AuthRequirement) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthRequirement != null) {
          ensureRequirementsIsMutable();
          this.requirements_.add(param1AuthRequirement);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1AuthRequirement);
      return this;
    }
    
    public AuthRequirement.Builder addRequirementsBuilder() {
      return (AuthRequirement.Builder)getRequirementsFieldBuilder().addBuilder((AbstractMessage)AuthRequirement.getDefaultInstance());
    }
    
    public AuthRequirement.Builder addRequirementsBuilder(int param1Int) {
      return (AuthRequirement.Builder)getRequirementsFieldBuilder().addBuilder(param1Int, (AbstractMessage)AuthRequirement.getDefaultInstance());
    }
    
    public AuthenticationRule build() {
      AuthenticationRule authenticationRule = buildPartial();
      if (authenticationRule.isInitialized())
        return authenticationRule; 
      throw newUninitializedMessageException(authenticationRule);
    }
    
    public AuthenticationRule buildPartial() {
      AuthenticationRule authenticationRule = new AuthenticationRule(this);
      int i = this.bitField0_;
      AuthenticationRule.access$402(authenticationRule, this.selector_);
      SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
      if (singleFieldBuilderV3 == null) {
        AuthenticationRule.access$502(authenticationRule, this.oauth_);
      } else {
        AuthenticationRule.access$502(authenticationRule, (OAuthRequirements)singleFieldBuilderV3.build());
      } 
      AuthenticationRule.access$602(authenticationRule, this.allowWithoutCredential_);
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x8) != 0) {
          this.requirements_ = Collections.unmodifiableList(this.requirements_);
          this.bitField0_ &= 0xFFFFFFF7;
        } 
        AuthenticationRule.access$702(authenticationRule, this.requirements_);
      } else {
        AuthenticationRule.access$702(authenticationRule, repeatedFieldBuilderV3.build());
      } 
      AuthenticationRule.access$802(authenticationRule, 0);
      onBuilt();
      return authenticationRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      if (this.oauthBuilder_ == null) {
        this.oauth_ = null;
      } else {
        this.oauth_ = null;
        this.oauthBuilder_ = null;
      } 
      this.allowWithoutCredential_ = false;
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.requirements_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFF7;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearAllowWithoutCredential() {
      this.allowWithoutCredential_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOauth() {
      if (this.oauthBuilder_ == null) {
        this.oauth_ = null;
        onChanged();
        return this;
      } 
      this.oauth_ = null;
      this.oauthBuilder_ = null;
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRequirements() {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.requirements_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFF7;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearSelector() {
      this.selector_ = AuthenticationRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public boolean getAllowWithoutCredential() {
      return this.allowWithoutCredential_;
    }
    
    public AuthenticationRule getDefaultInstanceForType() {
      return AuthenticationRule.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuthProto.c;
    }
    
    public OAuthRequirements getOauth() {
      OAuthRequirements oAuthRequirements;
      SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
      if (singleFieldBuilderV3 == null) {
        OAuthRequirements oAuthRequirements1 = this.oauth_;
        oAuthRequirements = oAuthRequirements1;
        if (oAuthRequirements1 == null)
          oAuthRequirements = OAuthRequirements.getDefaultInstance(); 
        return oAuthRequirements;
      } 
      return (OAuthRequirements)oAuthRequirements.getMessage();
    }
    
    public OAuthRequirements.Builder getOauthBuilder() {
      onChanged();
      return (OAuthRequirements.Builder)getOauthFieldBuilder().getBuilder();
    }
    
    public OAuthRequirementsOrBuilder getOauthOrBuilder() {
      SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
      if (singleFieldBuilderV3 != null)
        return (OAuthRequirementsOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      OAuthRequirements oAuthRequirements2 = this.oauth_;
      OAuthRequirements oAuthRequirements1 = oAuthRequirements2;
      if (oAuthRequirements2 == null)
        oAuthRequirements1 = OAuthRequirements.getDefaultInstance(); 
      return oAuthRequirements1;
    }
    
    public AuthRequirement getRequirements(int param1Int) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.requirements_.get(param1Int) : (AuthRequirement)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public AuthRequirement.Builder getRequirementsBuilder(int param1Int) {
      return (AuthRequirement.Builder)getRequirementsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<AuthRequirement.Builder> getRequirementsBuilderList() {
      return getRequirementsFieldBuilder().getBuilderList();
    }
    
    public int getRequirementsCount() {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.requirements_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<AuthRequirement> getRequirementsList() {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.requirements_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AuthRequirementOrBuilder getRequirementsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.requirements_.get(param1Int) : (AuthRequirementOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.requirements_);
    }
    
    public String getSelector() {
      Object object = this.selector_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.selector_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSelectorBytes() {
      Object object = this.selector_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.selector_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean hasOauth() {
      return (this.oauthBuilder_ != null || this.oauth_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuthProto.d.ensureFieldAccessorsInitialized(AuthenticationRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(AuthenticationRule param1AuthenticationRule) {
      if (param1AuthenticationRule == AuthenticationRule.getDefaultInstance())
        return this; 
      if (!param1AuthenticationRule.getSelector().isEmpty()) {
        this.selector_ = param1AuthenticationRule.selector_;
        onChanged();
      } 
      if (param1AuthenticationRule.hasOauth())
        mergeOauth(param1AuthenticationRule.getOauth()); 
      if (param1AuthenticationRule.getAllowWithoutCredential())
        setAllowWithoutCredential(param1AuthenticationRule.getAllowWithoutCredential()); 
      if (this.requirementsBuilder_ == null) {
        if (!param1AuthenticationRule.requirements_.isEmpty()) {
          if (this.requirements_.isEmpty()) {
            this.requirements_ = param1AuthenticationRule.requirements_;
            this.bitField0_ &= 0xFFFFFFF7;
          } else {
            ensureRequirementsIsMutable();
            this.requirements_.addAll(param1AuthenticationRule.requirements_);
          } 
          onChanged();
        } 
      } else if (!param1AuthenticationRule.requirements_.isEmpty()) {
        if (this.requirementsBuilder_.isEmpty()) {
          this.requirementsBuilder_.dispose();
          RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = null;
          this.requirementsBuilder_ = null;
          this.requirements_ = param1AuthenticationRule.requirements_;
          this.bitField0_ &= 0xFFFFFFF7;
          if (AuthenticationRule.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getRequirementsFieldBuilder(); 
          this.requirementsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.requirementsBuilder_.addAllMessages(param1AuthenticationRule.requirements_);
        } 
      } 
      mergeUnknownFields(param1AuthenticationRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AuthenticationRule authenticationRule = (AuthenticationRule)AuthenticationRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AuthenticationRule authenticationRule = (AuthenticationRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AuthenticationRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AuthenticationRule)
        return mergeFrom((AuthenticationRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeOauth(OAuthRequirements param1OAuthRequirements) {
      OAuthRequirements oAuthRequirements;
      SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
      if (singleFieldBuilderV3 == null) {
        oAuthRequirements = this.oauth_;
        if (oAuthRequirements != null) {
          this.oauth_ = OAuthRequirements.newBuilder(oAuthRequirements).mergeFrom(param1OAuthRequirements).buildPartial();
        } else {
          this.oauth_ = param1OAuthRequirements;
        } 
        onChanged();
        return this;
      } 
      oAuthRequirements.mergeFrom((AbstractMessage)param1OAuthRequirements);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRequirements(int param1Int) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequirementsIsMutable();
        this.requirements_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setAllowWithoutCredential(boolean param1Boolean) {
      this.allowWithoutCredential_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setOauth(OAuthRequirements.Builder param1Builder) {
      SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.oauth_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setOauth(OAuthRequirements param1OAuthRequirements) {
      SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1OAuthRequirements != null) {
          this.oauth_ = param1OAuthRequirements;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1OAuthRequirements);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequirements(int param1Int, AuthRequirement.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRequirementsIsMutable();
        this.requirements_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRequirements(int param1Int, AuthRequirement param1AuthRequirement) {
      RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthRequirement != null) {
          ensureRequirementsIsMutable();
          this.requirements_.set(param1Int, param1AuthRequirement);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1AuthRequirement);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      if (param1String != null) {
        this.selector_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AuthenticationRule.checkByteStringIsUtf8(param1ByteString);
        this.selector_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthenticationRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
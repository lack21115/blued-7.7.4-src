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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Authentication extends GeneratedMessageV3 implements AuthenticationOrBuilder {
  private static final Authentication DEFAULT_INSTANCE = new Authentication();
  
  private static final Parser<Authentication> PARSER = (Parser<Authentication>)new AbstractParser<Authentication>() {
      public Authentication a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Authentication(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PROVIDERS_FIELD_NUMBER = 4;
  
  public static final int RULES_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private List<AuthProvider> providers_;
  
  private List<AuthenticationRule> rules_;
  
  private Authentication() {
    this.rules_ = Collections.emptyList();
    this.providers_ = Collections.emptyList();
  }
  
  private Authentication(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            if (n != 26) {
              if (n != 34) {
                j = i;
                k = i;
                m = i;
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                  continue; 
                continue;
              } 
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.providers_ = new ArrayList<AuthProvider>();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.providers_.add(paramCodedInputStream.readMessage(AuthProvider.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.rules_ = new ArrayList<AuthenticationRule>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.rules_.add(paramCodedInputStream.readMessage(AuthenticationRule.parser(), paramExtensionRegistryLite));
            i = n;
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
          this.rules_ = Collections.unmodifiableList(this.rules_); 
        if ((j & 0x2) != 0)
          this.providers_ = Collections.unmodifiableList(this.providers_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.rules_ = Collections.unmodifiableList(this.rules_); 
      if ((i & 0x2) != 0)
        this.providers_ = Collections.unmodifiableList(this.providers_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Authentication(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Authentication getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return AuthProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Authentication paramAuthentication) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAuthentication);
  }
  
  public static Authentication parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Authentication)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Authentication parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Authentication)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Authentication)PARSER.parseFrom(paramByteString);
  }
  
  public static Authentication parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Authentication)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Authentication)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Authentication parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Authentication)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(InputStream paramInputStream) throws IOException {
    return (Authentication)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Authentication parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Authentication)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Authentication)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Authentication parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Authentication)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Authentication)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Authentication parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Authentication)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Authentication> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Authentication))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRulesList().equals(paramObject.getRulesList()) ? false : (!getProvidersList().equals(paramObject.getProvidersList()) ? false : (!!this.unknownFields.equals(((Authentication)paramObject).unknownFields)));
  }
  
  public Authentication getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Authentication> getParserForType() {
    return PARSER;
  }
  
  public AuthProvider getProviders(int paramInt) {
    return this.providers_.get(paramInt);
  }
  
  public int getProvidersCount() {
    return this.providers_.size();
  }
  
  public List<AuthProvider> getProvidersList() {
    return this.providers_;
  }
  
  public AuthProviderOrBuilder getProvidersOrBuilder(int paramInt) {
    return this.providers_.get(paramInt);
  }
  
  public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
    return (List)this.providers_;
  }
  
  public AuthenticationRule getRules(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<AuthenticationRule> getRulesList() {
    return this.rules_;
  }
  
  public AuthenticationRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int k;
    int m;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    int j = 0;
    i = 0;
    while (true) {
      k = b;
      m = i;
      if (j < this.rules_.size()) {
        i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.rules_.get(j));
        j++;
        continue;
      } 
      break;
    } 
    while (k < this.providers_.size()) {
      m += CodedOutputStream.computeMessageSize(4, (MessageLite)this.providers_.get(k));
      k++;
    } 
    i = m + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getRulesCount() > 0)
      i = (j * 37 + 3) * 53 + getRulesList().hashCode(); 
    j = i;
    if (getProvidersCount() > 0)
      j = (i * 37 + 4) * 53 + getProvidersList().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return AuthProto.b.ensureFieldAccessorsInitialized(Authentication.class, Builder.class);
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
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < this.rules_.size()) {
        paramCodedOutputStream.writeMessage(3, (MessageLite)this.rules_.get(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.providers_.size()) {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.providers_.get(j));
      j++;
    } 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> providersBuilder_;
    
    private List<AuthProvider> providers_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> rulesBuilder_;
    
    private List<AuthenticationRule> rules_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureProvidersIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.providers_ = new ArrayList<AuthProvider>(this.providers_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    private void ensureRulesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.rules_ = new ArrayList<AuthenticationRule>(this.rules_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AuthProto.a;
    }
    
    private RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> getProvidersFieldBuilder() {
      if (this.providersBuilder_ == null) {
        boolean bool;
        List<AuthProvider> list = this.providers_;
        if ((this.bitField0_ & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.providersBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.providers_ = null;
      } 
      return this.providersBuilder_;
    }
    
    private RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> getRulesFieldBuilder() {
      if (this.rulesBuilder_ == null) {
        List<AuthenticationRule> list = this.rules_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.rulesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.rules_ = null;
      } 
      return this.rulesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Authentication.alwaysUseFieldBuilders) {
        getRulesFieldBuilder();
        getProvidersFieldBuilder();
      } 
    }
    
    public Builder addAllProviders(Iterable<? extends AuthProvider> param1Iterable) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProvidersIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.providers_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllRules(Iterable<? extends AuthenticationRule> param1Iterable) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.rules_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addProviders(int param1Int, AuthProvider.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProvidersIsMutable();
        this.providers_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProviders(int param1Int, AuthProvider param1AuthProvider) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthProvider != null) {
          ensureProvidersIsMutable();
          this.providers_.add(param1Int, param1AuthProvider);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1AuthProvider);
      return this;
    }
    
    public Builder addProviders(AuthProvider.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProvidersIsMutable();
        this.providers_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProviders(AuthProvider param1AuthProvider) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthProvider != null) {
          ensureProvidersIsMutable();
          this.providers_.add(param1AuthProvider);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1AuthProvider);
      return this;
    }
    
    public AuthProvider.Builder addProvidersBuilder() {
      return (AuthProvider.Builder)getProvidersFieldBuilder().addBuilder((AbstractMessage)AuthProvider.getDefaultInstance());
    }
    
    public AuthProvider.Builder addProvidersBuilder(int param1Int) {
      return (AuthProvider.Builder)getProvidersFieldBuilder().addBuilder(param1Int, (AbstractMessage)AuthProvider.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRules(int param1Int, AuthenticationRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(int param1Int, AuthenticationRule param1AuthenticationRule) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthenticationRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1Int, param1AuthenticationRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1AuthenticationRule);
      return this;
    }
    
    public Builder addRules(AuthenticationRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(AuthenticationRule param1AuthenticationRule) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthenticationRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1AuthenticationRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1AuthenticationRule);
      return this;
    }
    
    public AuthenticationRule.Builder addRulesBuilder() {
      return (AuthenticationRule.Builder)getRulesFieldBuilder().addBuilder((AbstractMessage)AuthenticationRule.getDefaultInstance());
    }
    
    public AuthenticationRule.Builder addRulesBuilder(int param1Int) {
      return (AuthenticationRule.Builder)getRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)AuthenticationRule.getDefaultInstance());
    }
    
    public Authentication build() {
      Authentication authentication = buildPartial();
      if (authentication.isInitialized())
        return authentication; 
      throw newUninitializedMessageException(authentication);
    }
    
    public Authentication buildPartial() {
      Authentication authentication = new Authentication(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV31 = this.rulesBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        if ((i & 0x1) != 0) {
          this.rules_ = Collections.unmodifiableList(this.rules_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Authentication.access$402(authentication, this.rules_);
      } else {
        Authentication.access$402(authentication, repeatedFieldBuilderV31.build());
      } 
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.providers_ = Collections.unmodifiableList(this.providers_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Authentication.access$502(authentication, this.providers_);
      } else {
        Authentication.access$502(authentication, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return authentication;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV31 = this.rulesBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV31.clear();
      } 
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.providers_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProviders() {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.providers_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearRules() {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
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
    
    public Authentication getDefaultInstanceForType() {
      return Authentication.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AuthProto.a;
    }
    
    public AuthProvider getProviders(int param1Int) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.providers_.get(param1Int) : (AuthProvider)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public AuthProvider.Builder getProvidersBuilder(int param1Int) {
      return (AuthProvider.Builder)getProvidersFieldBuilder().getBuilder(param1Int);
    }
    
    public List<AuthProvider.Builder> getProvidersBuilderList() {
      return getProvidersFieldBuilder().getBuilderList();
    }
    
    public int getProvidersCount() {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.providers_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<AuthProvider> getProvidersList() {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.providers_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AuthProviderOrBuilder getProvidersOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.providers_.get(param1Int) : (AuthProviderOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.providers_);
    }
    
    public AuthenticationRule getRules(int param1Int) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (AuthenticationRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public AuthenticationRule.Builder getRulesBuilder(int param1Int) {
      return (AuthenticationRule.Builder)getRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<AuthenticationRule.Builder> getRulesBuilderList() {
      return getRulesFieldBuilder().getBuilderList();
    }
    
    public int getRulesCount() {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<AuthenticationRule> getRulesList() {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AuthenticationRuleOrBuilder getRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (AuthenticationRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.rules_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AuthProto.b.ensureFieldAccessorsInitialized(Authentication.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Authentication param1Authentication) {
      if (param1Authentication == Authentication.getDefaultInstance())
        return this; 
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Authentication.rules_.isEmpty()) {
          if (this.rules_.isEmpty()) {
            this.rules_ = param1Authentication.rules_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureRulesIsMutable();
            this.rules_.addAll(param1Authentication.rules_);
          } 
          onChanged();
        } 
      } else if (!param1Authentication.rules_.isEmpty()) {
        if (this.rulesBuilder_.isEmpty()) {
          this.rulesBuilder_.dispose();
          this.rulesBuilder_ = null;
          this.rules_ = param1Authentication.rules_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Authentication.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getRulesFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.rulesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.rulesBuilder_.addAllMessages(param1Authentication.rules_);
        } 
      } 
      if (this.providersBuilder_ == null) {
        if (!param1Authentication.providers_.isEmpty()) {
          if (this.providers_.isEmpty()) {
            this.providers_ = param1Authentication.providers_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureProvidersIsMutable();
            this.providers_.addAll(param1Authentication.providers_);
          } 
          onChanged();
        } 
      } else if (!param1Authentication.providers_.isEmpty()) {
        if (this.providersBuilder_.isEmpty()) {
          this.providersBuilder_.dispose();
          this.providersBuilder_ = null;
          this.providers_ = param1Authentication.providers_;
          this.bitField0_ &= 0xFFFFFFFD;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (Authentication.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getProvidersFieldBuilder(); 
          this.providersBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.providersBuilder_.addAllMessages(param1Authentication.providers_);
        } 
      } 
      mergeUnknownFields(param1Authentication.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Authentication authentication = (Authentication)Authentication.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Authentication authentication = (Authentication)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Authentication)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Authentication)
        return mergeFrom((Authentication)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeProviders(int param1Int) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProvidersIsMutable();
        this.providers_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeRules(int param1Int) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProviders(int param1Int, AuthProvider.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProvidersIsMutable();
        this.providers_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setProviders(int param1Int, AuthProvider param1AuthProvider) {
      RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthProvider != null) {
          ensureProvidersIsMutable();
          this.providers_.set(param1Int, param1AuthProvider);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1AuthProvider);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRules(int param1Int, AuthenticationRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRules(int param1Int, AuthenticationRule param1AuthenticationRule) {
      RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1AuthenticationRule != null) {
          ensureRulesIsMutable();
          this.rules_.set(param1Int, param1AuthenticationRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1AuthenticationRule);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Authentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
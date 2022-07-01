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

public final class SystemParameters extends GeneratedMessageV3 implements SystemParametersOrBuilder {
  private static final SystemParameters DEFAULT_INSTANCE = new SystemParameters();
  
  private static final Parser<SystemParameters> PARSER = (Parser<SystemParameters>)new AbstractParser<SystemParameters>() {
      public SystemParameters a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new SystemParameters(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RULES_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private List<SystemParameterRule> rules_;
  
  private SystemParameters() {
    this.rules_ = Collections.emptyList();
  }
  
  private SystemParameters(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              j = i;
              k = i;
              m = i;
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                continue; 
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.rules_ = new ArrayList<SystemParameterRule>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.rules_.add(paramCodedInputStream.readMessage(SystemParameterRule.parser(), paramExtensionRegistryLite));
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
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.rules_ = Collections.unmodifiableList(this.rules_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private SystemParameters(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static SystemParameters getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return SystemParameterProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SystemParameters paramSystemParameters) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSystemParameters);
  }
  
  public static SystemParameters parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameters)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static SystemParameters parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameters)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameters parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (SystemParameters)PARSER.parseFrom(paramByteString);
  }
  
  public static SystemParameters parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameters)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static SystemParameters parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (SystemParameters)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static SystemParameters parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameters)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameters parseFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameters)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static SystemParameters parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameters)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameters parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (SystemParameters)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static SystemParameters parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameters)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static SystemParameters parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (SystemParameters)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static SystemParameters parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameters)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SystemParameters> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SystemParameters))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRulesList().equals(paramObject.getRulesList()) ? false : (!!this.unknownFields.equals(((SystemParameters)paramObject).unknownFields));
  }
  
  public SystemParameters getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<SystemParameters> getParserForType() {
    return PARSER;
  }
  
  public SystemParameterRule getRules(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<SystemParameterRule> getRulesList() {
    return this.rules_;
  }
  
  public SystemParameterRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.rules_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.rules_.get(i));
      i++;
    } 
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
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getRulesCount() > 0)
      i = (j * 37 + 1) * 53 + getRulesList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return SystemParameterProto.b.ensureFieldAccessorsInitialized(SystemParameters.class, Builder.class);
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
    for (int i = 0; i < this.rules_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.rules_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemParametersOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> rulesBuilder_;
    
    private List<SystemParameterRule> rules_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRulesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.rules_ = new ArrayList<SystemParameterRule>(this.rules_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SystemParameterProto.a;
    }
    
    private RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> getRulesFieldBuilder() {
      if (this.rulesBuilder_ == null) {
        List<SystemParameterRule> list = this.rules_;
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
      if (SystemParameters.alwaysUseFieldBuilders)
        getRulesFieldBuilder(); 
    }
    
    public Builder addAllRules(Iterable<? extends SystemParameterRule> param1Iterable) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.rules_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRules(int param1Int, SystemParameterRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(int param1Int, SystemParameterRule param1SystemParameterRule) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1SystemParameterRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1Int, param1SystemParameterRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1SystemParameterRule);
      return this;
    }
    
    public Builder addRules(SystemParameterRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(SystemParameterRule param1SystemParameterRule) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1SystemParameterRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1SystemParameterRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1SystemParameterRule);
      return this;
    }
    
    public SystemParameterRule.Builder addRulesBuilder() {
      return (SystemParameterRule.Builder)getRulesFieldBuilder().addBuilder((AbstractMessage)SystemParameterRule.getDefaultInstance());
    }
    
    public SystemParameterRule.Builder addRulesBuilder(int param1Int) {
      return (SystemParameterRule.Builder)getRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)SystemParameterRule.getDefaultInstance());
    }
    
    public SystemParameters build() {
      SystemParameters systemParameters = buildPartial();
      if (systemParameters.isInitialized())
        return systemParameters; 
      throw newUninitializedMessageException(systemParameters);
    }
    
    public SystemParameters buildPartial() {
      SystemParameters systemParameters = new SystemParameters(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.rules_ = Collections.unmodifiableList(this.rules_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        SystemParameters.access$402(systemParameters, this.rules_);
      } else {
        SystemParameters.access$402(systemParameters, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return systemParameters;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
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
    
    public Builder clearRules() {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public SystemParameters getDefaultInstanceForType() {
      return SystemParameters.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SystemParameterProto.a;
    }
    
    public SystemParameterRule getRules(int param1Int) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (SystemParameterRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public SystemParameterRule.Builder getRulesBuilder(int param1Int) {
      return (SystemParameterRule.Builder)getRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<SystemParameterRule.Builder> getRulesBuilderList() {
      return getRulesFieldBuilder().getBuilderList();
    }
    
    public int getRulesCount() {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<SystemParameterRule> getRulesList() {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public SystemParameterRuleOrBuilder getRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (SystemParameterRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList() {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.rules_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SystemParameterProto.b.ensureFieldAccessorsInitialized(SystemParameters.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SystemParameters param1SystemParameters) {
      if (param1SystemParameters == SystemParameters.getDefaultInstance())
        return this; 
      if (this.rulesBuilder_ == null) {
        if (!param1SystemParameters.rules_.isEmpty()) {
          if (this.rules_.isEmpty()) {
            this.rules_ = param1SystemParameters.rules_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureRulesIsMutable();
            this.rules_.addAll(param1SystemParameters.rules_);
          } 
          onChanged();
        } 
      } else if (!param1SystemParameters.rules_.isEmpty()) {
        if (this.rulesBuilder_.isEmpty()) {
          this.rulesBuilder_.dispose();
          RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = null;
          this.rulesBuilder_ = null;
          this.rules_ = param1SystemParameters.rules_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (SystemParameters.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getRulesFieldBuilder(); 
          this.rulesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.rulesBuilder_.addAllMessages(param1SystemParameters.rules_);
        } 
      } 
      mergeUnknownFields(param1SystemParameters.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SystemParameters systemParameters = (SystemParameters)SystemParameters.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SystemParameters systemParameters = (SystemParameters)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SystemParameters)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SystemParameters)
        return mergeFrom((SystemParameters)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRules(int param1Int) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRules(int param1Int, SystemParameterRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRules(int param1Int, SystemParameterRule param1SystemParameterRule) {
      RepeatedFieldBuilderV3<SystemParameterRule, SystemParameterRule.Builder, SystemParameterRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1SystemParameterRule != null) {
          ensureRulesIsMutable();
          this.rules_.set(param1Int, param1SystemParameterRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1SystemParameterRule);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
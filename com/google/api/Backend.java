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

public final class Backend extends GeneratedMessageV3 implements BackendOrBuilder {
  private static final Backend DEFAULT_INSTANCE = new Backend();
  
  private static final Parser<Backend> PARSER = (Parser<Backend>)new AbstractParser<Backend>() {
      public Backend a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Backend(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RULES_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private List<BackendRule> rules_;
  
  private Backend() {
    this.rules_ = Collections.emptyList();
  }
  
  private Backend(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.rules_ = new ArrayList<BackendRule>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.rules_.add(paramCodedInputStream.readMessage(BackendRule.parser(), paramExtensionRegistryLite));
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
  
  private Backend(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Backend getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return BackendProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Backend paramBackend) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBackend);
  }
  
  public static Backend parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Backend)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Backend parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Backend)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Backend)PARSER.parseFrom(paramByteString);
  }
  
  public static Backend parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Backend)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Backend)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Backend parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Backend)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(InputStream paramInputStream) throws IOException {
    return (Backend)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Backend parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Backend)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Backend)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Backend parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Backend)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Backend)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Backend parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Backend)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Backend> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Backend))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRulesList().equals(paramObject.getRulesList()) ? false : (!!this.unknownFields.equals(((Backend)paramObject).unknownFields));
  }
  
  public Backend getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Backend> getParserForType() {
    return PARSER;
  }
  
  public BackendRule getRules(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<BackendRule> getRulesList() {
    return this.rules_;
  }
  
  public BackendRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public List<? extends BackendRuleOrBuilder> getRulesOrBuilderList() {
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
    return BackendProto.b.ensureFieldAccessorsInitialized(Backend.class, Builder.class);
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
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BackendOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> rulesBuilder_;
    
    private List<BackendRule> rules_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRulesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.rules_ = new ArrayList<BackendRule>(this.rules_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return BackendProto.a;
    }
    
    private RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> getRulesFieldBuilder() {
      if (this.rulesBuilder_ == null) {
        List<BackendRule> list = this.rules_;
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
      if (Backend.alwaysUseFieldBuilders)
        getRulesFieldBuilder(); 
    }
    
    public Builder addAllRules(Iterable<? extends BackendRule> param1Iterable) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public Builder addRules(int param1Int, BackendRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(int param1Int, BackendRule param1BackendRule) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1BackendRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1Int, param1BackendRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1BackendRule);
      return this;
    }
    
    public Builder addRules(BackendRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(BackendRule param1BackendRule) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1BackendRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1BackendRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1BackendRule);
      return this;
    }
    
    public BackendRule.Builder addRulesBuilder() {
      return (BackendRule.Builder)getRulesFieldBuilder().addBuilder((AbstractMessage)BackendRule.getDefaultInstance());
    }
    
    public BackendRule.Builder addRulesBuilder(int param1Int) {
      return (BackendRule.Builder)getRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)BackendRule.getDefaultInstance());
    }
    
    public Backend build() {
      Backend backend = buildPartial();
      if (backend.isInitialized())
        return backend; 
      throw newUninitializedMessageException(backend);
    }
    
    public Backend buildPartial() {
      Backend backend = new Backend(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.rules_ = Collections.unmodifiableList(this.rules_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Backend.access$402(backend, this.rules_);
      } else {
        Backend.access$402(backend, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return backend;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public Backend getDefaultInstanceForType() {
      return Backend.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return BackendProto.a;
    }
    
    public BackendRule getRules(int param1Int) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (BackendRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public BackendRule.Builder getRulesBuilder(int param1Int) {
      return (BackendRule.Builder)getRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<BackendRule.Builder> getRulesBuilderList() {
      return getRulesFieldBuilder().getBuilderList();
    }
    
    public int getRulesCount() {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<BackendRule> getRulesList() {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public BackendRuleOrBuilder getRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (BackendRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends BackendRuleOrBuilder> getRulesOrBuilderList() {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.rules_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return BackendProto.b.ensureFieldAccessorsInitialized(Backend.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Backend param1Backend) {
      if (param1Backend == Backend.getDefaultInstance())
        return this; 
      if (this.rulesBuilder_ == null) {
        if (!param1Backend.rules_.isEmpty()) {
          if (this.rules_.isEmpty()) {
            this.rules_ = param1Backend.rules_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureRulesIsMutable();
            this.rules_.addAll(param1Backend.rules_);
          } 
          onChanged();
        } 
      } else if (!param1Backend.rules_.isEmpty()) {
        if (this.rulesBuilder_.isEmpty()) {
          this.rulesBuilder_.dispose();
          RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = null;
          this.rulesBuilder_ = null;
          this.rules_ = param1Backend.rules_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Backend.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getRulesFieldBuilder(); 
          this.rulesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.rulesBuilder_.addAllMessages(param1Backend.rules_);
        } 
      } 
      mergeUnknownFields(param1Backend.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Backend backend = (Backend)Backend.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Backend backend = (Backend)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Backend)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Backend)
        return mergeFrom((Backend)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRules(int param1Int) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public Builder setRules(int param1Int, BackendRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRules(int param1Int, BackendRule param1BackendRule) {
      RepeatedFieldBuilderV3<BackendRule, BackendRule.Builder, BackendRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1BackendRule != null) {
          ensureRulesIsMutable();
          this.rules_.set(param1Int, param1BackendRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1BackendRule);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Backend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
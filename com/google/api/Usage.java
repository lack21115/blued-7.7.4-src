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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Usage extends GeneratedMessageV3 implements UsageOrBuilder {
  private static final Usage DEFAULT_INSTANCE = new Usage();
  
  private static final Parser<Usage> PARSER = (Parser<Usage>)new AbstractParser<Usage>() {
      public Usage a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Usage(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PRODUCER_NOTIFICATION_CHANNEL_FIELD_NUMBER = 7;
  
  public static final int REQUIREMENTS_FIELD_NUMBER = 1;
  
  public static final int RULES_FIELD_NUMBER = 6;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object producerNotificationChannel_;
  
  private LazyStringList requirements_;
  
  private List<UsageRule> rules_;
  
  private Usage() {
    this.requirements_ = LazyStringArrayList.EMPTY;
    this.rules_ = Collections.emptyList();
    this.producerNotificationChannel_ = "";
  }
  
  private Usage(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              if (n != 50) {
                if (n != 58) {
                  j = i;
                  k = i;
                  m = i;
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                    continue; 
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.producerNotificationChannel_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.rules_ = new ArrayList<UsageRule>();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.rules_.add(paramCodedInputStream.readMessage(UsageRule.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            } 
            j = i;
            k = i;
            m = i;
            String str = paramCodedInputStream.readStringRequireUtf8();
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.requirements_ = (LazyStringList)new LazyStringArrayList();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.requirements_.add(str);
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
          this.requirements_ = this.requirements_.getUnmodifiableView(); 
        if ((j & 0x2) != 0)
          this.rules_ = Collections.unmodifiableList(this.rules_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.requirements_ = this.requirements_.getUnmodifiableView(); 
      if ((i & 0x2) != 0)
        this.rules_ = Collections.unmodifiableList(this.rules_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Usage(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Usage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return UsageProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Usage paramUsage) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramUsage);
  }
  
  public static Usage parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Usage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Usage parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Usage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Usage)PARSER.parseFrom(paramByteString);
  }
  
  public static Usage parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Usage)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Usage)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Usage parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Usage)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(InputStream paramInputStream) throws IOException {
    return (Usage)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Usage parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Usage)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Usage)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Usage parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Usage)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Usage)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Usage parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Usage)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Usage> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Usage))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRequirementsList().equals(paramObject.getRequirementsList()) ? false : (!getRulesList().equals(paramObject.getRulesList()) ? false : (!getProducerNotificationChannel().equals(paramObject.getProducerNotificationChannel()) ? false : (!!this.unknownFields.equals(((Usage)paramObject).unknownFields))));
  }
  
  public Usage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Usage> getParserForType() {
    return PARSER;
  }
  
  public String getProducerNotificationChannel() {
    Object object = this.producerNotificationChannel_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.producerNotificationChannel_ = object;
    return (String)object;
  }
  
  public ByteString getProducerNotificationChannelBytes() {
    Object object = this.producerNotificationChannel_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.producerNotificationChannel_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getRequirements(int paramInt) {
    return (String)this.requirements_.get(paramInt);
  }
  
  public ByteString getRequirementsBytes(int paramInt) {
    return this.requirements_.getByteString(paramInt);
  }
  
  public int getRequirementsCount() {
    return this.requirements_.size();
  }
  
  public ProtocolStringList getRequirementsList() {
    return (ProtocolStringList)this.requirements_;
  }
  
  public UsageRule getRules(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<UsageRule> getRulesList() {
    return this.rules_;
  }
  
  public UsageRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public List<? extends UsageRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = false;
    i = 0;
    int j = 0;
    while (i < this.requirements_.size()) {
      j += computeStringSizeNoTag(this.requirements_.getRaw(i));
      i++;
    } 
    i = j + 0 + getRequirementsList().size() * 1;
    for (j = bool; j < this.rules_.size(); j++)
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.rules_.get(j)); 
    j = i;
    if (!getProducerNotificationChannelBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(7, this.producerNotificationChannel_); 
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
    if (getRequirementsCount() > 0)
      i = (j * 37 + 1) * 53 + getRequirementsList().hashCode(); 
    j = i;
    if (getRulesCount() > 0)
      j = (i * 37 + 6) * 53 + getRulesList().hashCode(); 
    i = ((j * 37 + 7) * 53 + getProducerNotificationChannel().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return UsageProto.b.ensureFieldAccessorsInitialized(Usage.class, Builder.class);
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
      if (i < this.requirements_.size()) {
        GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.requirements_.getRaw(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.rules_.size()) {
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.rules_.get(j));
      j++;
    } 
    if (!getProducerNotificationChannelBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.producerNotificationChannel_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UsageOrBuilder {
    private int bitField0_;
    
    private Object producerNotificationChannel_ = "";
    
    private LazyStringList requirements_ = LazyStringArrayList.EMPTY;
    
    private RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> rulesBuilder_;
    
    private List<UsageRule> rules_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRequirementsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.requirements_ = (LazyStringList)new LazyStringArrayList(this.requirements_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private void ensureRulesIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.rules_ = new ArrayList<UsageRule>(this.rules_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return UsageProto.a;
    }
    
    private RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> getRulesFieldBuilder() {
      if (this.rulesBuilder_ == null) {
        boolean bool;
        List<UsageRule> list = this.rules_;
        if ((this.bitField0_ & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.rulesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.rules_ = null;
      } 
      return this.rulesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Usage.alwaysUseFieldBuilders)
        getRulesFieldBuilder(); 
    }
    
    public Builder addAllRequirements(Iterable<String> param1Iterable) {
      ensureRequirementsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.requirements_);
      onChanged();
      return this;
    }
    
    public Builder addAllRules(Iterable<? extends UsageRule> param1Iterable) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public Builder addRequirements(String param1String) {
      if (param1String != null) {
        ensureRequirementsIsMutable();
        this.requirements_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRequirementsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Usage.checkByteStringIsUtf8(param1ByteString);
        ensureRequirementsIsMutable();
        this.requirements_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRules(int param1Int, UsageRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(int param1Int, UsageRule param1UsageRule) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1UsageRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1Int, param1UsageRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1UsageRule);
      return this;
    }
    
    public Builder addRules(UsageRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(UsageRule param1UsageRule) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1UsageRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1UsageRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1UsageRule);
      return this;
    }
    
    public UsageRule.Builder addRulesBuilder() {
      return (UsageRule.Builder)getRulesFieldBuilder().addBuilder((AbstractMessage)UsageRule.getDefaultInstance());
    }
    
    public UsageRule.Builder addRulesBuilder(int param1Int) {
      return (UsageRule.Builder)getRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)UsageRule.getDefaultInstance());
    }
    
    public Usage build() {
      Usage usage = buildPartial();
      if (usage.isInitialized())
        return usage; 
      throw newUninitializedMessageException(usage);
    }
    
    public Usage buildPartial() {
      Usage usage = new Usage(this);
      if ((this.bitField0_ & 0x1) != 0) {
        this.requirements_ = this.requirements_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFE;
      } 
      Usage.access$402(usage, this.requirements_);
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.rules_ = Collections.unmodifiableList(this.rules_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Usage.access$502(usage, this.rules_);
      } else {
        Usage.access$502(usage, repeatedFieldBuilderV3.build());
      } 
      Usage.access$602(usage, this.producerNotificationChannel_);
      Usage.access$702(usage, 0);
      onBuilt();
      return usage;
    }
    
    public Builder clear() {
      super.clear();
      this.requirements_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFE;
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.producerNotificationChannel_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProducerNotificationChannel() {
      this.producerNotificationChannel_ = Usage.getDefaultInstance().getProducerNotificationChannel();
      onChanged();
      return this;
    }
    
    public Builder clearRequirements() {
      this.requirements_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFE;
      onChanged();
      return this;
    }
    
    public Builder clearRules() {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Usage getDefaultInstanceForType() {
      return Usage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return UsageProto.a;
    }
    
    public String getProducerNotificationChannel() {
      Object object = this.producerNotificationChannel_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.producerNotificationChannel_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getProducerNotificationChannelBytes() {
      Object object = this.producerNotificationChannel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.producerNotificationChannel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRequirements(int param1Int) {
      return (String)this.requirements_.get(param1Int);
    }
    
    public ByteString getRequirementsBytes(int param1Int) {
      return this.requirements_.getByteString(param1Int);
    }
    
    public int getRequirementsCount() {
      return this.requirements_.size();
    }
    
    public ProtocolStringList getRequirementsList() {
      return (ProtocolStringList)this.requirements_.getUnmodifiableView();
    }
    
    public UsageRule getRules(int param1Int) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (UsageRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public UsageRule.Builder getRulesBuilder(int param1Int) {
      return (UsageRule.Builder)getRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<UsageRule.Builder> getRulesBuilderList() {
      return getRulesFieldBuilder().getBuilderList();
    }
    
    public int getRulesCount() {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<UsageRule> getRulesList() {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public UsageRuleOrBuilder getRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (UsageRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends UsageRuleOrBuilder> getRulesOrBuilderList() {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.rules_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return UsageProto.b.ensureFieldAccessorsInitialized(Usage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Usage param1Usage) {
      if (param1Usage == Usage.getDefaultInstance())
        return this; 
      if (!param1Usage.requirements_.isEmpty()) {
        if (this.requirements_.isEmpty()) {
          this.requirements_ = param1Usage.requirements_;
          this.bitField0_ &= 0xFFFFFFFE;
        } else {
          ensureRequirementsIsMutable();
          this.requirements_.addAll((Collection)param1Usage.requirements_);
        } 
        onChanged();
      } 
      if (this.rulesBuilder_ == null) {
        if (!param1Usage.rules_.isEmpty()) {
          if (this.rules_.isEmpty()) {
            this.rules_ = param1Usage.rules_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureRulesIsMutable();
            this.rules_.addAll(param1Usage.rules_);
          } 
          onChanged();
        } 
      } else if (!param1Usage.rules_.isEmpty()) {
        if (this.rulesBuilder_.isEmpty()) {
          this.rulesBuilder_.dispose();
          RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = null;
          this.rulesBuilder_ = null;
          this.rules_ = param1Usage.rules_;
          this.bitField0_ &= 0xFFFFFFFD;
          if (Usage.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getRulesFieldBuilder(); 
          this.rulesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.rulesBuilder_.addAllMessages(param1Usage.rules_);
        } 
      } 
      if (!param1Usage.getProducerNotificationChannel().isEmpty()) {
        this.producerNotificationChannel_ = param1Usage.producerNotificationChannel_;
        onChanged();
      } 
      mergeUnknownFields(param1Usage.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Usage usage = (Usage)Usage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Usage usage = (Usage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Usage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Usage)
        return mergeFrom((Usage)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRules(int param1Int) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
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
    
    public Builder setProducerNotificationChannel(String param1String) {
      if (param1String != null) {
        this.producerNotificationChannel_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setProducerNotificationChannelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Usage.checkByteStringIsUtf8(param1ByteString);
        this.producerNotificationChannel_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequirements(int param1Int, String param1String) {
      if (param1String != null) {
        ensureRequirementsIsMutable();
        this.requirements_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRules(int param1Int, UsageRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRules(int param1Int, UsageRule param1UsageRule) {
      RepeatedFieldBuilderV3<UsageRule, UsageRule.Builder, UsageRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1UsageRule != null) {
          ensureRulesIsMutable();
          this.rules_.set(param1Int, param1UsageRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1UsageRule);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Usage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
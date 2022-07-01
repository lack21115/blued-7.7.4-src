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

public final class Quota extends GeneratedMessageV3 implements QuotaOrBuilder {
  private static final Quota DEFAULT_INSTANCE = new Quota();
  
  public static final int LIMITS_FIELD_NUMBER = 3;
  
  public static final int METRIC_RULES_FIELD_NUMBER = 4;
  
  private static final Parser<Quota> PARSER = (Parser<Quota>)new AbstractParser<Quota>() {
      public Quota a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Quota(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private List<QuotaLimit> limits_;
  
  private byte memoizedIsInitialized = -1;
  
  private List<MetricRule> metricRules_;
  
  private Quota() {
    this.limits_ = Collections.emptyList();
    this.metricRules_ = Collections.emptyList();
  }
  
  private Quota(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                this.metricRules_ = new ArrayList<MetricRule>();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.metricRules_.add(paramCodedInputStream.readMessage(MetricRule.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.limits_ = new ArrayList<QuotaLimit>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.limits_.add(paramCodedInputStream.readMessage(QuotaLimit.parser(), paramExtensionRegistryLite));
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
          this.limits_ = Collections.unmodifiableList(this.limits_); 
        if ((j & 0x2) != 0)
          this.metricRules_ = Collections.unmodifiableList(this.metricRules_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.limits_ = Collections.unmodifiableList(this.limits_); 
      if ((i & 0x2) != 0)
        this.metricRules_ = Collections.unmodifiableList(this.metricRules_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Quota(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Quota getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return QuotaProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Quota paramQuota) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramQuota);
  }
  
  public static Quota parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Quota)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Quota parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quota)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Quota)PARSER.parseFrom(paramByteString);
  }
  
  public static Quota parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quota)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Quota)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Quota parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quota)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(InputStream paramInputStream) throws IOException {
    return (Quota)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Quota parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quota)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Quota)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Quota parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quota)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Quota)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Quota parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quota)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Quota> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Quota))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getLimitsList().equals(paramObject.getLimitsList()) ? false : (!getMetricRulesList().equals(paramObject.getMetricRulesList()) ? false : (!!this.unknownFields.equals(((Quota)paramObject).unknownFields)));
  }
  
  public Quota getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public QuotaLimit getLimits(int paramInt) {
    return this.limits_.get(paramInt);
  }
  
  public int getLimitsCount() {
    return this.limits_.size();
  }
  
  public List<QuotaLimit> getLimitsList() {
    return this.limits_;
  }
  
  public QuotaLimitOrBuilder getLimitsOrBuilder(int paramInt) {
    return this.limits_.get(paramInt);
  }
  
  public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
    return (List)this.limits_;
  }
  
  public MetricRule getMetricRules(int paramInt) {
    return this.metricRules_.get(paramInt);
  }
  
  public int getMetricRulesCount() {
    return this.metricRules_.size();
  }
  
  public List<MetricRule> getMetricRulesList() {
    return this.metricRules_;
  }
  
  public MetricRuleOrBuilder getMetricRulesOrBuilder(int paramInt) {
    return this.metricRules_.get(paramInt);
  }
  
  public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
    return (List)this.metricRules_;
  }
  
  public Parser<Quota> getParserForType() {
    return PARSER;
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
      if (j < this.limits_.size()) {
        i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.limits_.get(j));
        j++;
        continue;
      } 
      break;
    } 
    while (k < this.metricRules_.size()) {
      m += CodedOutputStream.computeMessageSize(4, (MessageLite)this.metricRules_.get(k));
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
    if (getLimitsCount() > 0)
      i = (j * 37 + 3) * 53 + getLimitsList().hashCode(); 
    j = i;
    if (getMetricRulesCount() > 0)
      j = (i * 37 + 4) * 53 + getMetricRulesList().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return QuotaProto.b.ensureFieldAccessorsInitialized(Quota.class, Builder.class);
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
      if (i < this.limits_.size()) {
        paramCodedOutputStream.writeMessage(3, (MessageLite)this.limits_.get(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.metricRules_.size()) {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.metricRules_.get(j));
      j++;
    } 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuotaOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> limitsBuilder_;
    
    private List<QuotaLimit> limits_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> metricRulesBuilder_;
    
    private List<MetricRule> metricRules_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureLimitsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.limits_ = new ArrayList<QuotaLimit>(this.limits_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private void ensureMetricRulesIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.metricRules_ = new ArrayList<MetricRule>(this.metricRules_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return QuotaProto.a;
    }
    
    private RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> getLimitsFieldBuilder() {
      if (this.limitsBuilder_ == null) {
        List<QuotaLimit> list = this.limits_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.limitsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.limits_ = null;
      } 
      return this.limitsBuilder_;
    }
    
    private RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> getMetricRulesFieldBuilder() {
      if (this.metricRulesBuilder_ == null) {
        boolean bool;
        List<MetricRule> list = this.metricRules_;
        if ((this.bitField0_ & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.metricRulesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.metricRules_ = null;
      } 
      return this.metricRulesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Quota.alwaysUseFieldBuilders) {
        getLimitsFieldBuilder();
        getMetricRulesFieldBuilder();
      } 
    }
    
    public Builder addAllLimits(Iterable<? extends QuotaLimit> param1Iterable) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLimitsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.limits_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllMetricRules(Iterable<? extends MetricRule> param1Iterable) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricRulesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.metricRules_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addLimits(int param1Int, QuotaLimit.Builder param1Builder) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLimitsIsMutable();
        this.limits_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLimits(int param1Int, QuotaLimit param1QuotaLimit) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1QuotaLimit != null) {
          ensureLimitsIsMutable();
          this.limits_.add(param1Int, param1QuotaLimit);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1QuotaLimit);
      return this;
    }
    
    public Builder addLimits(QuotaLimit.Builder param1Builder) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLimitsIsMutable();
        this.limits_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLimits(QuotaLimit param1QuotaLimit) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1QuotaLimit != null) {
          ensureLimitsIsMutable();
          this.limits_.add(param1QuotaLimit);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1QuotaLimit);
      return this;
    }
    
    public QuotaLimit.Builder addLimitsBuilder() {
      return (QuotaLimit.Builder)getLimitsFieldBuilder().addBuilder((AbstractMessage)QuotaLimit.getDefaultInstance());
    }
    
    public QuotaLimit.Builder addLimitsBuilder(int param1Int) {
      return (QuotaLimit.Builder)getLimitsFieldBuilder().addBuilder(param1Int, (AbstractMessage)QuotaLimit.getDefaultInstance());
    }
    
    public Builder addMetricRules(int param1Int, MetricRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricRulesIsMutable();
        this.metricRules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addMetricRules(int param1Int, MetricRule param1MetricRule) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MetricRule != null) {
          ensureMetricRulesIsMutable();
          this.metricRules_.add(param1Int, param1MetricRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1MetricRule);
      return this;
    }
    
    public Builder addMetricRules(MetricRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricRulesIsMutable();
        this.metricRules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addMetricRules(MetricRule param1MetricRule) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MetricRule != null) {
          ensureMetricRulesIsMutable();
          this.metricRules_.add(param1MetricRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1MetricRule);
      return this;
    }
    
    public MetricRule.Builder addMetricRulesBuilder() {
      return (MetricRule.Builder)getMetricRulesFieldBuilder().addBuilder((AbstractMessage)MetricRule.getDefaultInstance());
    }
    
    public MetricRule.Builder addMetricRulesBuilder(int param1Int) {
      return (MetricRule.Builder)getMetricRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)MetricRule.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Quota build() {
      Quota quota = buildPartial();
      if (quota.isInitialized())
        return quota; 
      throw newUninitializedMessageException(quota);
    }
    
    public Quota buildPartial() {
      Quota quota = new Quota(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV31 = this.limitsBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        if ((i & 0x1) != 0) {
          this.limits_ = Collections.unmodifiableList(this.limits_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Quota.access$402(quota, this.limits_);
      } else {
        Quota.access$402(quota, repeatedFieldBuilderV31.build());
      } 
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.metricRules_ = Collections.unmodifiableList(this.metricRules_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Quota.access$502(quota, this.metricRules_);
      } else {
        Quota.access$502(quota, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return quota;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV31 = this.limitsBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        this.limits_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV31.clear();
      } 
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.metricRules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLimits() {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.limits_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearMetricRules() {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.metricRules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Quota getDefaultInstanceForType() {
      return Quota.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return QuotaProto.a;
    }
    
    public QuotaLimit getLimits(int param1Int) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.limits_.get(param1Int) : (QuotaLimit)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public QuotaLimit.Builder getLimitsBuilder(int param1Int) {
      return (QuotaLimit.Builder)getLimitsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<QuotaLimit.Builder> getLimitsBuilderList() {
      return getLimitsFieldBuilder().getBuilderList();
    }
    
    public int getLimitsCount() {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.limits_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<QuotaLimit> getLimitsList() {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.limits_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public QuotaLimitOrBuilder getLimitsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.limits_.get(param1Int) : (QuotaLimitOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.limits_);
    }
    
    public MetricRule getMetricRules(int param1Int) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.metricRules_.get(param1Int) : (MetricRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public MetricRule.Builder getMetricRulesBuilder(int param1Int) {
      return (MetricRule.Builder)getMetricRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<MetricRule.Builder> getMetricRulesBuilderList() {
      return getMetricRulesFieldBuilder().getBuilderList();
    }
    
    public int getMetricRulesCount() {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.metricRules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<MetricRule> getMetricRulesList() {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.metricRules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public MetricRuleOrBuilder getMetricRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.metricRules_.get(param1Int) : (MetricRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.metricRules_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return QuotaProto.b.ensureFieldAccessorsInitialized(Quota.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Quota param1Quota) {
      if (param1Quota == Quota.getDefaultInstance())
        return this; 
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Quota.limits_.isEmpty()) {
          if (this.limits_.isEmpty()) {
            this.limits_ = param1Quota.limits_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureLimitsIsMutable();
            this.limits_.addAll(param1Quota.limits_);
          } 
          onChanged();
        } 
      } else if (!param1Quota.limits_.isEmpty()) {
        if (this.limitsBuilder_.isEmpty()) {
          this.limitsBuilder_.dispose();
          this.limitsBuilder_ = null;
          this.limits_ = param1Quota.limits_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Quota.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getLimitsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.limitsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.limitsBuilder_.addAllMessages(param1Quota.limits_);
        } 
      } 
      if (this.metricRulesBuilder_ == null) {
        if (!param1Quota.metricRules_.isEmpty()) {
          if (this.metricRules_.isEmpty()) {
            this.metricRules_ = param1Quota.metricRules_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureMetricRulesIsMutable();
            this.metricRules_.addAll(param1Quota.metricRules_);
          } 
          onChanged();
        } 
      } else if (!param1Quota.metricRules_.isEmpty()) {
        if (this.metricRulesBuilder_.isEmpty()) {
          this.metricRulesBuilder_.dispose();
          this.metricRulesBuilder_ = null;
          this.metricRules_ = param1Quota.metricRules_;
          this.bitField0_ &= 0xFFFFFFFD;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (Quota.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getMetricRulesFieldBuilder(); 
          this.metricRulesBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.metricRulesBuilder_.addAllMessages(param1Quota.metricRules_);
        } 
      } 
      mergeUnknownFields(param1Quota.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Quota quota = (Quota)Quota.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Quota quota = (Quota)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Quota)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Quota)
        return mergeFrom((Quota)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeLimits(int param1Int) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLimitsIsMutable();
        this.limits_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeMetricRules(int param1Int) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricRulesIsMutable();
        this.metricRules_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLimits(int param1Int, QuotaLimit.Builder param1Builder) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLimitsIsMutable();
        this.limits_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLimits(int param1Int, QuotaLimit param1QuotaLimit) {
      RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1QuotaLimit != null) {
          ensureLimitsIsMutable();
          this.limits_.set(param1Int, param1QuotaLimit);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1QuotaLimit);
      return this;
    }
    
    public Builder setMetricRules(int param1Int, MetricRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureMetricRulesIsMutable();
        this.metricRules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMetricRules(int param1Int, MetricRule param1MetricRule) {
      RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MetricRule != null) {
          ensureMetricRulesIsMutable();
          this.metricRules_.set(param1Int, param1MetricRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1MetricRule);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Quota.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
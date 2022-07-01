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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public final class MetricRule extends GeneratedMessageV3 implements MetricRuleOrBuilder {
  private static final MetricRule DEFAULT_INSTANCE = new MetricRule();
  
  public static final int METRIC_COSTS_FIELD_NUMBER = 2;
  
  private static final Parser<MetricRule> PARSER = (Parser<MetricRule>)new AbstractParser<MetricRule>() {
      public MetricRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new MetricRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private MapField<String, Long> metricCosts_;
  
  private volatile Object selector_;
  
  private MetricRule() {
    this.selector_ = "";
  }
  
  private MetricRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      boolean bool = false;
      int i = 0;
      while (!bool) {
        try {
          int j = paramCodedInputStream.readTag();
          if (j != 0) {
            if (j != 10) {
              if (j != 18) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, j))
                  continue; 
                continue;
              } 
              j = i;
              if ((i & 0x2) == 0) {
                this.metricCosts_ = MapField.newMapField(MetricCostsDefaultEntryHolder.a);
                j = i | 0x2;
              } 
              MapEntry mapEntry = (MapEntry)paramCodedInputStream.readMessage(MetricCostsDefaultEntryHolder.a.getParserForType(), paramExtensionRegistryLite);
              this.metricCosts_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
              i = j;
              continue;
            } 
            this.selector_ = paramCodedInputStream.readStringRequireUtf8();
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
        bool = true;
      } 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private MetricRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static MetricRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return QuotaProto.c;
  }
  
  private MapField<String, Long> internalGetMetricCosts() {
    MapField<String, Long> mapField2 = this.metricCosts_;
    MapField<String, Long> mapField1 = mapField2;
    if (mapField2 == null)
      mapField1 = MapField.emptyMapField(MetricCostsDefaultEntryHolder.a); 
    return mapField1;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MetricRule paramMetricRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMetricRule);
  }
  
  public static MetricRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MetricRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MetricRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MetricRule)PARSER.parseFrom(paramByteString);
  }
  
  public static MetricRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MetricRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MetricRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(InputStream paramInputStream) throws IOException {
    return (MetricRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MetricRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (MetricRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MetricRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MetricRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static MetricRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MetricRule> parser() {
    return PARSER;
  }
  
  public boolean containsMetricCosts(String paramString) {
    if (paramString != null)
      return internalGetMetricCosts().getMap().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MetricRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : (!internalGetMetricCosts().equals(paramObject.internalGetMetricCosts()) ? false : (!!this.unknownFields.equals(((MetricRule)paramObject).unknownFields)));
  }
  
  public MetricRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  @Deprecated
  public Map<String, Long> getMetricCosts() {
    return getMetricCostsMap();
  }
  
  public int getMetricCostsCount() {
    return internalGetMetricCosts().getMap().size();
  }
  
  public Map<String, Long> getMetricCostsMap() {
    return internalGetMetricCosts().getMap();
  }
  
  public long getMetricCostsOrDefault(String paramString, long paramLong) {
    if (paramString != null) {
      Map map = internalGetMetricCosts().getMap();
      if (map.containsKey(paramString))
        paramLong = ((Long)map.get(paramString)).longValue(); 
      return paramLong;
    } 
    throw new NullPointerException();
  }
  
  public long getMetricCostsOrThrow(String paramString) {
    if (paramString != null) {
      Map map = internalGetMetricCosts().getMap();
      if (map.containsKey(paramString))
        return ((Long)map.get(paramString)).longValue(); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public Parser<MetricRule> getParserForType() {
    return PARSER;
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
    i = 0;
    if (!getSelectorBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.selector_); 
    for (Map.Entry entry : internalGetMetricCosts().getMap().entrySet())
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)MetricCostsDefaultEntryHolder.a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build()); 
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
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode();
    int i = j;
    if (!internalGetMetricCosts().getMap().isEmpty())
      i = (j * 37 + 2) * 53 + internalGetMetricCosts().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return QuotaProto.d.ensureFieldAccessorsInitialized(MetricRule.class, Builder.class);
  }
  
  public MapField internalGetMapField(int paramInt) {
    if (paramInt == 2)
      return internalGetMetricCosts(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid map field number: ");
    stringBuilder.append(paramInt);
    throw new RuntimeException(stringBuilder.toString());
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
    GeneratedMessageV3.serializeStringMapTo(paramCodedOutputStream, internalGetMetricCosts(), MetricCostsDefaultEntryHolder.a, 2);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MetricRuleOrBuilder {
    private int bitField0_;
    
    private MapField<String, Long> metricCosts_;
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return QuotaProto.c;
    }
    
    private MapField<String, Long> internalGetMetricCosts() {
      MapField<String, Long> mapField2 = this.metricCosts_;
      MapField<String, Long> mapField1 = mapField2;
      if (mapField2 == null)
        mapField1 = MapField.emptyMapField(MetricRule.MetricCostsDefaultEntryHolder.a); 
      return mapField1;
    }
    
    private MapField<String, Long> internalGetMutableMetricCosts() {
      onChanged();
      if (this.metricCosts_ == null)
        this.metricCosts_ = MapField.newMapField(MetricRule.MetricCostsDefaultEntryHolder.a); 
      if (!this.metricCosts_.isMutable())
        this.metricCosts_ = this.metricCosts_.copy(); 
      return this.metricCosts_;
    }
    
    private void maybeForceBuilderInitialization() {
      MetricRule.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MetricRule build() {
      MetricRule metricRule = buildPartial();
      if (metricRule.isInitialized())
        return metricRule; 
      throw newUninitializedMessageException(metricRule);
    }
    
    public MetricRule buildPartial() {
      MetricRule metricRule = new MetricRule(this);
      int i = this.bitField0_;
      MetricRule.access$402(metricRule, this.selector_);
      MetricRule.access$502(metricRule, internalGetMetricCosts());
      metricRule.metricCosts_.makeImmutable();
      MetricRule.access$602(metricRule, 0);
      onBuilt();
      return metricRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      internalGetMutableMetricCosts().clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMetricCosts() {
      internalGetMutableMetricCosts().getMutableMap().clear();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSelector() {
      this.selector_ = MetricRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public boolean containsMetricCosts(String param1String) {
      if (param1String != null)
        return internalGetMetricCosts().getMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public MetricRule getDefaultInstanceForType() {
      return MetricRule.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return QuotaProto.c;
    }
    
    @Deprecated
    public Map<String, Long> getMetricCosts() {
      return getMetricCostsMap();
    }
    
    public int getMetricCostsCount() {
      return internalGetMetricCosts().getMap().size();
    }
    
    public Map<String, Long> getMetricCostsMap() {
      return internalGetMetricCosts().getMap();
    }
    
    public long getMetricCostsOrDefault(String param1String, long param1Long) {
      if (param1String != null) {
        Map map = internalGetMetricCosts().getMap();
        if (map.containsKey(param1String))
          param1Long = ((Long)map.get(param1String)).longValue(); 
        return param1Long;
      } 
      throw new NullPointerException();
    }
    
    public long getMetricCostsOrThrow(String param1String) {
      if (param1String != null) {
        Map map = internalGetMetricCosts().getMap();
        if (map.containsKey(param1String))
          return ((Long)map.get(param1String)).longValue(); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, Long> getMutableMetricCosts() {
      return internalGetMutableMetricCosts().getMutableMap();
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return QuotaProto.d.ensureFieldAccessorsInitialized(MetricRule.class, Builder.class);
    }
    
    public MapField internalGetMapField(int param1Int) {
      if (param1Int == 2)
        return internalGetMetricCosts(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public MapField internalGetMutableMapField(int param1Int) {
      if (param1Int == 2)
        return internalGetMutableMetricCosts(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MetricRule param1MetricRule) {
      if (param1MetricRule == MetricRule.getDefaultInstance())
        return this; 
      if (!param1MetricRule.getSelector().isEmpty()) {
        this.selector_ = param1MetricRule.selector_;
        onChanged();
      } 
      internalGetMutableMetricCosts().mergeFrom(param1MetricRule.internalGetMetricCosts());
      mergeUnknownFields(param1MetricRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MetricRule metricRule = (MetricRule)MetricRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MetricRule metricRule = (MetricRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MetricRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MetricRule)
        return mergeFrom((MetricRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder putAllMetricCosts(Map<String, Long> param1Map) {
      internalGetMutableMetricCosts().getMutableMap().putAll(param1Map);
      return this;
    }
    
    public Builder putMetricCosts(String param1String, long param1Long) {
      if (param1String != null) {
        internalGetMutableMetricCosts().getMutableMap().put(param1String, Long.valueOf(param1Long));
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder removeMetricCosts(String param1String) {
      if (param1String != null) {
        internalGetMutableMetricCosts().getMutableMap().remove(param1String);
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
        MetricRule.checkByteStringIsUtf8(param1ByteString);
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
  
  static final class MetricCostsDefaultEntryHolder {
    static final MapEntry<String, Long> a = MapEntry.newDefaultInstance(QuotaProto.e, WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, Long.valueOf(0L));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MetricRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
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

public final class QuotaLimit extends GeneratedMessageV3 implements QuotaLimitOrBuilder {
  private static final QuotaLimit DEFAULT_INSTANCE = new QuotaLimit();
  
  public static final int DEFAULT_LIMIT_FIELD_NUMBER = 3;
  
  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 12;
  
  public static final int DURATION_FIELD_NUMBER = 5;
  
  public static final int FREE_TIER_FIELD_NUMBER = 7;
  
  public static final int MAX_LIMIT_FIELD_NUMBER = 4;
  
  public static final int METRIC_FIELD_NUMBER = 8;
  
  public static final int NAME_FIELD_NUMBER = 6;
  
  private static final Parser<QuotaLimit> PARSER = (Parser<QuotaLimit>)new AbstractParser<QuotaLimit>() {
      public QuotaLimit a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new QuotaLimit(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int UNIT_FIELD_NUMBER = 9;
  
  public static final int VALUES_FIELD_NUMBER = 10;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private long defaultLimit_;
  
  private volatile Object description_;
  
  private volatile Object displayName_;
  
  private volatile Object duration_;
  
  private long freeTier_;
  
  private long maxLimit_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object metric_;
  
  private volatile Object name_;
  
  private volatile Object unit_;
  
  private MapField<String, Long> values_;
  
  private QuotaLimit() {
    this.name_ = "";
    this.description_ = "";
    this.duration_ = "";
    this.metric_ = "";
    this.unit_ = "";
    this.displayName_ = "";
  }
  
  private QuotaLimit(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      boolean bool = false;
      int i = 0;
      while (!bool) {
        try {
          MapEntry mapEntry;
          int j = paramCodedInputStream.readTag();
          switch (j) {
            case 98:
              this.displayName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 82:
              j = i;
              if ((i & 0x100) == 0) {
                this.values_ = MapField.newMapField(ValuesDefaultEntryHolder.a);
                j = i | 0x100;
              } 
              mapEntry = (MapEntry)paramCodedInputStream.readMessage(ValuesDefaultEntryHolder.a.getParserForType(), paramExtensionRegistryLite);
              this.values_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
              i = j;
              continue;
            case 74:
              this.unit_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 66:
              this.metric_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 56:
              this.freeTier_ = paramCodedInputStream.readInt64();
              continue;
            case 50:
              this.name_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 42:
              this.duration_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 32:
              this.maxLimit_ = paramCodedInputStream.readInt64();
              continue;
            case 24:
              this.defaultLimit_ = paramCodedInputStream.readInt64();
              continue;
            case 18:
              this.description_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 0:
              bool = true;
              continue;
          } 
          boolean bool1 = parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, j);
          if (!bool1);
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
  
  private QuotaLimit(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static QuotaLimit getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return QuotaProto.g;
  }
  
  private MapField<String, Long> internalGetValues() {
    MapField<String, Long> mapField2 = this.values_;
    MapField<String, Long> mapField1 = mapField2;
    if (mapField2 == null)
      mapField1 = MapField.emptyMapField(ValuesDefaultEntryHolder.a); 
    return mapField1;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(QuotaLimit paramQuotaLimit) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramQuotaLimit);
  }
  
  public static QuotaLimit parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (QuotaLimit)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static QuotaLimit parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaLimit)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (QuotaLimit)PARSER.parseFrom(paramByteString);
  }
  
  public static QuotaLimit parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaLimit)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (QuotaLimit)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static QuotaLimit parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaLimit)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(InputStream paramInputStream) throws IOException {
    return (QuotaLimit)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static QuotaLimit parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaLimit)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (QuotaLimit)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static QuotaLimit parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaLimit)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (QuotaLimit)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static QuotaLimit parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaLimit)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<QuotaLimit> parser() {
    return PARSER;
  }
  
  public boolean containsValues(String paramString) {
    if (paramString != null)
      return internalGetValues().getMap().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof QuotaLimit))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : ((getDefaultLimit() != paramObject.getDefaultLimit()) ? false : ((getMaxLimit() != paramObject.getMaxLimit()) ? false : ((getFreeTier() != paramObject.getFreeTier()) ? false : (!getDuration().equals(paramObject.getDuration()) ? false : (!getMetric().equals(paramObject.getMetric()) ? false : (!getUnit().equals(paramObject.getUnit()) ? false : (!internalGetValues().equals(paramObject.internalGetValues()) ? false : (!getDisplayName().equals(paramObject.getDisplayName()) ? false : (!!this.unknownFields.equals(((QuotaLimit)paramObject).unknownFields)))))))))));
  }
  
  public QuotaLimit getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public long getDefaultLimit() {
    return this.defaultLimit_;
  }
  
  public String getDescription() {
    Object object = this.description_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.description_ = object;
    return (String)object;
  }
  
  public ByteString getDescriptionBytes() {
    Object object = this.description_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.description_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getDisplayName() {
    Object object = this.displayName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.displayName_ = object;
    return (String)object;
  }
  
  public ByteString getDisplayNameBytes() {
    Object object = this.displayName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.displayName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getDuration() {
    Object object = this.duration_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.duration_ = object;
    return (String)object;
  }
  
  public ByteString getDurationBytes() {
    Object object = this.duration_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.duration_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public long getFreeTier() {
    return this.freeTier_;
  }
  
  public long getMaxLimit() {
    return this.maxLimit_;
  }
  
  public String getMetric() {
    Object object = this.metric_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.metric_ = object;
    return (String)object;
  }
  
  public ByteString getMetricBytes() {
    Object object = this.metric_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.metric_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getName() {
    Object object = this.name_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.name_ = object;
    return (String)object;
  }
  
  public ByteString getNameBytes() {
    Object object = this.name_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.name_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<QuotaLimit> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getDescriptionBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(2, this.description_); 
    long l = this.defaultLimit_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(3, l); 
    l = this.maxLimit_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(4, l); 
    i = j;
    if (!getDurationBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(5, this.duration_); 
    j = i;
    if (!getNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(6, this.name_); 
    l = this.freeTier_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(7, l); 
    j = i;
    if (!getMetricBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(8, this.metric_); 
    i = j;
    if (!getUnitBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(9, this.unit_); 
    for (Map.Entry entry : internalGetValues().getMap().entrySet())
      i += CodedOutputStream.computeMessageSize(10, (MessageLite)ValuesDefaultEntryHolder.a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build()); 
    j = i;
    if (!getDisplayNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(12, this.displayName_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getUnit() {
    Object object = this.unit_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.unit_ = object;
    return (String)object;
  }
  
  public ByteString getUnitBytes() {
    Object object = this.unit_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.unit_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  @Deprecated
  public Map<String, Long> getValues() {
    return getValuesMap();
  }
  
  public int getValuesCount() {
    return internalGetValues().getMap().size();
  }
  
  public Map<String, Long> getValuesMap() {
    return internalGetValues().getMap();
  }
  
  public long getValuesOrDefault(String paramString, long paramLong) {
    if (paramString != null) {
      Map map = internalGetValues().getMap();
      if (map.containsKey(paramString))
        paramLong = ((Long)map.get(paramString)).longValue(); 
      return paramLong;
    } 
    throw new NullPointerException();
  }
  
  public long getValuesOrThrow(String paramString) {
    if (paramString != null) {
      Map map = internalGetValues().getMap();
      if (map.containsKey(paramString))
        return ((Long)map.get(paramString)).longValue(); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 6) * 53 + getName().hashCode()) * 37 + 2) * 53 + getDescription().hashCode()) * 37 + 3) * 53 + Internal.hashLong(getDefaultLimit())) * 37 + 4) * 53 + Internal.hashLong(getMaxLimit())) * 37 + 7) * 53 + Internal.hashLong(getFreeTier())) * 37 + 5) * 53 + getDuration().hashCode()) * 37 + 8) * 53 + getMetric().hashCode()) * 37 + 9) * 53 + getUnit().hashCode();
    int i = j;
    if (!internalGetValues().getMap().isEmpty())
      i = (j * 37 + 10) * 53 + internalGetValues().hashCode(); 
    i = ((i * 37 + 12) * 53 + getDisplayName().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return QuotaProto.h.ensureFieldAccessorsInitialized(QuotaLimit.class, Builder.class);
  }
  
  public MapField internalGetMapField(int paramInt) {
    if (paramInt == 10)
      return internalGetValues(); 
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
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.description_); 
    long l = this.defaultLimit_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(3, l); 
    l = this.maxLimit_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(4, l); 
    if (!getDurationBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.duration_); 
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.name_); 
    l = this.freeTier_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(7, l); 
    if (!getMetricBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.metric_); 
    if (!getUnitBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 9, this.unit_); 
    GeneratedMessageV3.serializeStringMapTo(paramCodedOutputStream, internalGetValues(), ValuesDefaultEntryHolder.a, 10);
    if (!getDisplayNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 12, this.displayName_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuotaLimitOrBuilder {
    private int bitField0_;
    
    private long defaultLimit_;
    
    private Object description_ = "";
    
    private Object displayName_ = "";
    
    private Object duration_ = "";
    
    private long freeTier_;
    
    private long maxLimit_;
    
    private Object metric_ = "";
    
    private Object name_ = "";
    
    private Object unit_ = "";
    
    private MapField<String, Long> values_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return QuotaProto.g;
    }
    
    private MapField<String, Long> internalGetMutableValues() {
      onChanged();
      if (this.values_ == null)
        this.values_ = MapField.newMapField(QuotaLimit.ValuesDefaultEntryHolder.a); 
      if (!this.values_.isMutable())
        this.values_ = this.values_.copy(); 
      return this.values_;
    }
    
    private MapField<String, Long> internalGetValues() {
      MapField<String, Long> mapField2 = this.values_;
      MapField<String, Long> mapField1 = mapField2;
      if (mapField2 == null)
        mapField1 = MapField.emptyMapField(QuotaLimit.ValuesDefaultEntryHolder.a); 
      return mapField1;
    }
    
    private void maybeForceBuilderInitialization() {
      QuotaLimit.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public QuotaLimit build() {
      QuotaLimit quotaLimit = buildPartial();
      if (quotaLimit.isInitialized())
        return quotaLimit; 
      throw newUninitializedMessageException(quotaLimit);
    }
    
    public QuotaLimit buildPartial() {
      QuotaLimit quotaLimit = new QuotaLimit(this);
      int i = this.bitField0_;
      QuotaLimit.access$402(quotaLimit, this.name_);
      QuotaLimit.access$502(quotaLimit, this.description_);
      QuotaLimit.access$602(quotaLimit, this.defaultLimit_);
      QuotaLimit.access$702(quotaLimit, this.maxLimit_);
      QuotaLimit.access$802(quotaLimit, this.freeTier_);
      QuotaLimit.access$902(quotaLimit, this.duration_);
      QuotaLimit.access$1002(quotaLimit, this.metric_);
      QuotaLimit.access$1102(quotaLimit, this.unit_);
      QuotaLimit.access$1202(quotaLimit, internalGetValues());
      quotaLimit.values_.makeImmutable();
      QuotaLimit.access$1302(quotaLimit, this.displayName_);
      QuotaLimit.access$1402(quotaLimit, 0);
      onBuilt();
      return quotaLimit;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.description_ = "";
      this.defaultLimit_ = 0L;
      this.maxLimit_ = 0L;
      this.freeTier_ = 0L;
      this.duration_ = "";
      this.metric_ = "";
      this.unit_ = "";
      internalGetMutableValues().clear();
      this.displayName_ = "";
      return this;
    }
    
    public Builder clearDefaultLimit() {
      this.defaultLimit_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = QuotaLimit.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearDisplayName() {
      this.displayName_ = QuotaLimit.getDefaultInstance().getDisplayName();
      onChanged();
      return this;
    }
    
    public Builder clearDuration() {
      this.duration_ = QuotaLimit.getDefaultInstance().getDuration();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFreeTier() {
      this.freeTier_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearMaxLimit() {
      this.maxLimit_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearMetric() {
      this.metric_ = QuotaLimit.getDefaultInstance().getMetric();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = QuotaLimit.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearUnit() {
      this.unit_ = QuotaLimit.getDefaultInstance().getUnit();
      onChanged();
      return this;
    }
    
    public Builder clearValues() {
      internalGetMutableValues().getMutableMap().clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public boolean containsValues(String param1String) {
      if (param1String != null)
        return internalGetValues().getMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public QuotaLimit getDefaultInstanceForType() {
      return QuotaLimit.getDefaultInstance();
    }
    
    public long getDefaultLimit() {
      return this.defaultLimit_;
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.description_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return QuotaProto.g;
    }
    
    public String getDisplayName() {
      Object object = this.displayName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.displayName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDisplayNameBytes() {
      Object object = this.displayName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.displayName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getDuration() {
      Object object = this.duration_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.duration_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDurationBytes() {
      Object object = this.duration_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.duration_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getFreeTier() {
      return this.freeTier_;
    }
    
    public long getMaxLimit() {
      return this.maxLimit_;
    }
    
    public String getMetric() {
      Object object = this.metric_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.metric_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMetricBytes() {
      Object object = this.metric_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.metric_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    @Deprecated
    public Map<String, Long> getMutableValues() {
      return internalGetMutableValues().getMutableMap();
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.name_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getUnit() {
      Object object = this.unit_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.unit_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUnitBytes() {
      Object object = this.unit_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.unit_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    @Deprecated
    public Map<String, Long> getValues() {
      return getValuesMap();
    }
    
    public int getValuesCount() {
      return internalGetValues().getMap().size();
    }
    
    public Map<String, Long> getValuesMap() {
      return internalGetValues().getMap();
    }
    
    public long getValuesOrDefault(String param1String, long param1Long) {
      if (param1String != null) {
        Map map = internalGetValues().getMap();
        if (map.containsKey(param1String))
          param1Long = ((Long)map.get(param1String)).longValue(); 
        return param1Long;
      } 
      throw new NullPointerException();
    }
    
    public long getValuesOrThrow(String param1String) {
      if (param1String != null) {
        Map map = internalGetValues().getMap();
        if (map.containsKey(param1String))
          return ((Long)map.get(param1String)).longValue(); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return QuotaProto.h.ensureFieldAccessorsInitialized(QuotaLimit.class, Builder.class);
    }
    
    public MapField internalGetMapField(int param1Int) {
      if (param1Int == 10)
        return internalGetValues(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public MapField internalGetMutableMapField(int param1Int) {
      if (param1Int == 10)
        return internalGetMutableValues(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(QuotaLimit param1QuotaLimit) {
      if (param1QuotaLimit == QuotaLimit.getDefaultInstance())
        return this; 
      if (!param1QuotaLimit.getName().isEmpty()) {
        this.name_ = param1QuotaLimit.name_;
        onChanged();
      } 
      if (!param1QuotaLimit.getDescription().isEmpty()) {
        this.description_ = param1QuotaLimit.description_;
        onChanged();
      } 
      if (param1QuotaLimit.getDefaultLimit() != 0L)
        setDefaultLimit(param1QuotaLimit.getDefaultLimit()); 
      if (param1QuotaLimit.getMaxLimit() != 0L)
        setMaxLimit(param1QuotaLimit.getMaxLimit()); 
      if (param1QuotaLimit.getFreeTier() != 0L)
        setFreeTier(param1QuotaLimit.getFreeTier()); 
      if (!param1QuotaLimit.getDuration().isEmpty()) {
        this.duration_ = param1QuotaLimit.duration_;
        onChanged();
      } 
      if (!param1QuotaLimit.getMetric().isEmpty()) {
        this.metric_ = param1QuotaLimit.metric_;
        onChanged();
      } 
      if (!param1QuotaLimit.getUnit().isEmpty()) {
        this.unit_ = param1QuotaLimit.unit_;
        onChanged();
      } 
      internalGetMutableValues().mergeFrom(param1QuotaLimit.internalGetValues());
      if (!param1QuotaLimit.getDisplayName().isEmpty()) {
        this.displayName_ = param1QuotaLimit.displayName_;
        onChanged();
      } 
      mergeUnknownFields(param1QuotaLimit.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        QuotaLimit quotaLimit = (QuotaLimit)QuotaLimit.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        QuotaLimit quotaLimit = (QuotaLimit)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((QuotaLimit)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof QuotaLimit)
        return mergeFrom((QuotaLimit)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder putAllValues(Map<String, Long> param1Map) {
      internalGetMutableValues().getMutableMap().putAll(param1Map);
      return this;
    }
    
    public Builder putValues(String param1String, long param1Long) {
      if (param1String != null) {
        internalGetMutableValues().getMutableMap().put(param1String, Long.valueOf(param1Long));
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder removeValues(String param1String) {
      if (param1String != null) {
        internalGetMutableValues().getMutableMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDefaultLimit(long param1Long) {
      this.defaultLimit_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        QuotaLimit.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisplayName(String param1String) {
      if (param1String != null) {
        this.displayName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        QuotaLimit.checkByteStringIsUtf8(param1ByteString);
        this.displayName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDuration(String param1String) {
      if (param1String != null) {
        this.duration_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDurationBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        QuotaLimit.checkByteStringIsUtf8(param1ByteString);
        this.duration_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFreeTier(long param1Long) {
      this.freeTier_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setMaxLimit(long param1Long) {
      this.maxLimit_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setMetric(String param1String) {
      if (param1String != null) {
        this.metric_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMetricBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        QuotaLimit.checkByteStringIsUtf8(param1ByteString);
        this.metric_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        QuotaLimit.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setUnit(String param1String) {
      if (param1String != null) {
        this.unit_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUnitBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        QuotaLimit.checkByteStringIsUtf8(param1ByteString);
        this.unit_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  static final class ValuesDefaultEntryHolder {
    static final MapEntry<String, Long> a = MapEntry.newDefaultInstance(QuotaProto.i, WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, Long.valueOf(0L));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\QuotaLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
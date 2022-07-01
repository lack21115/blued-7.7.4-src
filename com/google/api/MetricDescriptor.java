package com.google.api;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MetricDescriptor extends GeneratedMessageV3 implements MetricDescriptorOrBuilder {
  private static final MetricDescriptor DEFAULT_INSTANCE = new MetricDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 6;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
  
  public static final int LABELS_FIELD_NUMBER = 2;
  
  public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
  
  public static final int METADATA_FIELD_NUMBER = 10;
  
  public static final int METRIC_KIND_FIELD_NUMBER = 3;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<MetricDescriptor> PARSER = (Parser<MetricDescriptor>)new AbstractParser<MetricDescriptor>() {
      public MetricDescriptor a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new MetricDescriptor(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_FIELD_NUMBER = 8;
  
  public static final int UNIT_FIELD_NUMBER = 5;
  
  public static final int VALUE_TYPE_FIELD_NUMBER = 4;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object description_;
  
  private volatile Object displayName_;
  
  private List<LabelDescriptor> labels_;
  
  private int launchStage_;
  
  private byte memoizedIsInitialized = -1;
  
  private MetricDescriptorMetadata metadata_;
  
  private int metricKind_;
  
  private volatile Object name_;
  
  private volatile Object type_;
  
  private volatile Object unit_;
  
  private int valueType_;
  
  private MetricDescriptor() {
    this.name_ = "";
    this.type_ = "";
    this.labels_ = Collections.emptyList();
    this.metricKind_ = 0;
    this.valueType_ = 0;
    this.unit_ = "";
    this.description_ = "";
    this.displayName_ = "";
    this.launchStage_ = 0;
  }
  
  private MetricDescriptor(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
          MetricDescriptorMetadata.Builder builder1;
          int n = paramCodedInputStream.readTag();
          switch (n) {
            case 96:
              j = i;
              k = i;
              m = i;
              this.launchStage_ = paramCodedInputStream.readEnum();
              continue;
            case 82:
              builder1 = null;
              j = i;
              k = i;
              m = i;
              if (this.metadata_ != null) {
                j = i;
                k = i;
                m = i;
                builder1 = this.metadata_.toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.metadata_ = (MetricDescriptorMetadata)paramCodedInputStream.readMessage(MetricDescriptorMetadata.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                j = i;
                k = i;
                m = i;
                builder1.mergeFrom(this.metadata_);
                j = i;
                k = i;
                m = i;
                this.metadata_ = builder1.buildPartial();
              } 
              continue;
            case 66:
              j = i;
              k = i;
              m = i;
              this.type_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 58:
              j = i;
              k = i;
              m = i;
              this.displayName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 50:
              j = i;
              k = i;
              m = i;
              this.description_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 42:
              j = i;
              k = i;
              m = i;
              this.unit_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 32:
              j = i;
              k = i;
              m = i;
              this.valueType_ = paramCodedInputStream.readEnum();
              continue;
            case 24:
              j = i;
              k = i;
              m = i;
              this.metricKind_ = paramCodedInputStream.readEnum();
              continue;
            case 18:
              n = i;
              if ((i & 0x4) == 0) {
                j = i;
                k = i;
                m = i;
                this.labels_ = new ArrayList<LabelDescriptor>();
                n = i | 0x4;
              } 
              j = n;
              k = n;
              m = n;
              this.labels_.add(paramCodedInputStream.readMessage(LabelDescriptor.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 10:
              j = i;
              k = i;
              m = i;
              this.name_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 0:
              bool = true;
              continue;
          } 
          j = i;
          k = i;
          m = i;
          boolean bool1 = parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n);
          if (!bool1);
          continue;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          j = m;
          throw invalidProtocolBufferException.setUnfinishedMessage(this);
        } catch (IOException iOException) {
          j = k;
          throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
        } finally {}
        if ((j & 0x4) != 0)
          this.labels_ = Collections.unmodifiableList(this.labels_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      if ((i & 0x4) != 0)
        this.labels_ = Collections.unmodifiableList(this.labels_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private MetricDescriptor(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static MetricDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return MetricProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MetricDescriptor paramMetricDescriptor) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMetricDescriptor);
  }
  
  public static MetricDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MetricDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MetricDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MetricDescriptor)PARSER.parseFrom(paramByteString);
  }
  
  public static MetricDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricDescriptor)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MetricDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MetricDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (MetricDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MetricDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (MetricDescriptor)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MetricDescriptor parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricDescriptor)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MetricDescriptor)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static MetricDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricDescriptor)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MetricDescriptor> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MetricDescriptor))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getType().equals(paramObject.getType()) ? false : (!getLabelsList().equals(paramObject.getLabelsList()) ? false : ((this.metricKind_ != ((MetricDescriptor)paramObject).metricKind_) ? false : ((this.valueType_ != ((MetricDescriptor)paramObject).valueType_) ? false : (!getUnit().equals(paramObject.getUnit()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!getDisplayName().equals(paramObject.getDisplayName()) ? false : ((hasMetadata() != paramObject.hasMetadata()) ? false : ((hasMetadata() && !getMetadata().equals(paramObject.getMetadata())) ? false : ((this.launchStage_ != ((MetricDescriptor)paramObject).launchStage_) ? false : (!!this.unknownFields.equals(((MetricDescriptor)paramObject).unknownFields))))))))))));
  }
  
  public MetricDescriptor getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
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
  
  public LabelDescriptor getLabels(int paramInt) {
    return this.labels_.get(paramInt);
  }
  
  public int getLabelsCount() {
    return this.labels_.size();
  }
  
  public List<LabelDescriptor> getLabelsList() {
    return this.labels_;
  }
  
  public LabelDescriptorOrBuilder getLabelsOrBuilder(int paramInt) {
    return this.labels_.get(paramInt);
  }
  
  public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
    return (List)this.labels_;
  }
  
  public LaunchStage getLaunchStage() {
    LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
    LaunchStage launchStage1 = launchStage2;
    if (launchStage2 == null)
      launchStage1 = LaunchStage.UNRECOGNIZED; 
    return launchStage1;
  }
  
  public int getLaunchStageValue() {
    return this.launchStage_;
  }
  
  public MetricDescriptorMetadata getMetadata() {
    MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
    MetricDescriptorMetadata metricDescriptorMetadata1 = metricDescriptorMetadata2;
    if (metricDescriptorMetadata2 == null)
      metricDescriptorMetadata1 = MetricDescriptorMetadata.getDefaultInstance(); 
    return metricDescriptorMetadata1;
  }
  
  public MetricDescriptorMetadataOrBuilder getMetadataOrBuilder() {
    return getMetadata();
  }
  
  public MetricKind getMetricKind() {
    MetricKind metricKind2 = MetricKind.valueOf(this.metricKind_);
    MetricKind metricKind1 = metricKind2;
    if (metricKind2 == null)
      metricKind1 = MetricKind.UNRECOGNIZED; 
    return metricKind1;
  }
  
  public int getMetricKindValue() {
    return this.metricKind_;
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
  
  public Parser<MetricDescriptor> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getNameBytes().isEmpty();
    int j = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    } 
    while (j < this.labels_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.labels_.get(j));
      j++;
    } 
    j = i;
    if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber())
      j = i + CodedOutputStream.computeEnumSize(3, this.metricKind_); 
    i = j;
    if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(4, this.valueType_); 
    j = i;
    if (!getUnitBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(5, this.unit_); 
    i = j;
    if (!getDescriptionBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(6, this.description_); 
    j = i;
    if (!getDisplayNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(7, this.displayName_); 
    i = j;
    if (!getTypeBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(8, this.type_); 
    j = i;
    if (this.metadata_ != null)
      j = i + CodedOutputStream.computeMessageSize(10, (MessageLite)getMetadata()); 
    i = j;
    if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(12, this.launchStage_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getType() {
    Object object = this.type_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.type_ = object;
    return (String)object;
  }
  
  public ByteString getTypeBytes() {
    Object object = this.type_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.type_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
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
  
  public ValueType getValueType() {
    ValueType valueType2 = ValueType.valueOf(this.valueType_);
    ValueType valueType1 = valueType2;
    if (valueType2 == null)
      valueType1 = ValueType.UNRECOGNIZED; 
    return valueType1;
  }
  
  public int getValueTypeValue() {
    return this.valueType_;
  }
  
  public boolean hasMetadata() {
    return (this.metadata_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 8) * 53 + getType().hashCode();
    int i = j;
    if (getLabelsCount() > 0)
      i = (j * 37 + 2) * 53 + getLabelsList().hashCode(); 
    j = (((((((((i * 37 + 3) * 53 + this.metricKind_) * 37 + 4) * 53 + this.valueType_) * 37 + 5) * 53 + getUnit().hashCode()) * 37 + 6) * 53 + getDescription().hashCode()) * 37 + 7) * 53 + getDisplayName().hashCode();
    i = j;
    if (hasMetadata())
      i = (j * 37 + 10) * 53 + getMetadata().hashCode(); 
    i = ((i * 37 + 12) * 53 + this.launchStage_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return MetricProto.b.ensureFieldAccessorsInitialized(MetricDescriptor.class, Builder.class);
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
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    for (int i = 0; i < this.labels_.size(); i++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.labels_.get(i)); 
    if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(3, this.metricKind_); 
    if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(4, this.valueType_); 
    if (!getUnitBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.unit_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.description_); 
    if (!getDisplayNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.displayName_); 
    if (!getTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.type_); 
    if (this.metadata_ != null)
      paramCodedOutputStream.writeMessage(10, (MessageLite)getMetadata()); 
    if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(12, this.launchStage_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MetricDescriptorOrBuilder {
    private int bitField0_;
    
    private Object description_ = "";
    
    private Object displayName_ = "";
    
    private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> labelsBuilder_;
    
    private List<LabelDescriptor> labels_ = Collections.emptyList();
    
    private int launchStage_ = 0;
    
    private SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> metadataBuilder_;
    
    private MetricDescriptor.MetricDescriptorMetadata metadata_;
    
    private int metricKind_ = 0;
    
    private Object name_ = "";
    
    private Object type_ = "";
    
    private Object unit_ = "";
    
    private int valueType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureLabelsIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.labels_ = new ArrayList<LabelDescriptor>(this.labels_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MetricProto.a;
    }
    
    private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> getLabelsFieldBuilder() {
      if (this.labelsBuilder_ == null) {
        boolean bool;
        List<LabelDescriptor> list = this.labels_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.labelsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.labels_ = null;
      } 
      return this.labelsBuilder_;
    }
    
    private SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> getMetadataFieldBuilder() {
      if (this.metadataBuilder_ == null) {
        this.metadataBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getMetadata(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.metadata_ = null;
      } 
      return this.metadataBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (MetricDescriptor.alwaysUseFieldBuilders)
        getLabelsFieldBuilder(); 
    }
    
    public Builder addAllLabels(Iterable<? extends LabelDescriptor> param1Iterable) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.labels_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LabelDescriptor != null) {
          ensureLabelsIsMutable();
          this.labels_.add(param1Int, param1LabelDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1LabelDescriptor);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLabels(LabelDescriptor param1LabelDescriptor) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LabelDescriptor != null) {
          ensureLabelsIsMutable();
          this.labels_.add(param1LabelDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1LabelDescriptor);
      return this;
    }
    
    public LabelDescriptor.Builder addLabelsBuilder() {
      return (LabelDescriptor.Builder)getLabelsFieldBuilder().addBuilder((AbstractMessage)LabelDescriptor.getDefaultInstance());
    }
    
    public LabelDescriptor.Builder addLabelsBuilder(int param1Int) {
      return (LabelDescriptor.Builder)getLabelsFieldBuilder().addBuilder(param1Int, (AbstractMessage)LabelDescriptor.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MetricDescriptor build() {
      MetricDescriptor metricDescriptor = buildPartial();
      if (metricDescriptor.isInitialized())
        return metricDescriptor; 
      throw newUninitializedMessageException(metricDescriptor);
    }
    
    public MetricDescriptor buildPartial() {
      MetricDescriptor metricDescriptor = new MetricDescriptor(this);
      int i = this.bitField0_;
      MetricDescriptor.access$1402(metricDescriptor, this.name_);
      MetricDescriptor.access$1502(metricDescriptor, this.type_);
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.labels_ = Collections.unmodifiableList(this.labels_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        MetricDescriptor.access$1602(metricDescriptor, this.labels_);
      } else {
        MetricDescriptor.access$1602(metricDescriptor, repeatedFieldBuilderV3.build());
      } 
      MetricDescriptor.access$1702(metricDescriptor, this.metricKind_);
      MetricDescriptor.access$1802(metricDescriptor, this.valueType_);
      MetricDescriptor.access$1902(metricDescriptor, this.unit_);
      MetricDescriptor.access$2002(metricDescriptor, this.description_);
      MetricDescriptor.access$2102(metricDescriptor, this.displayName_);
      SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        MetricDescriptor.access$2202(metricDescriptor, this.metadata_);
      } else {
        MetricDescriptor.access$2202(metricDescriptor, (MetricDescriptor.MetricDescriptorMetadata)singleFieldBuilderV3.build());
      } 
      MetricDescriptor.access$2302(metricDescriptor, this.launchStage_);
      MetricDescriptor.access$2402(metricDescriptor, 0);
      onBuilt();
      return metricDescriptor;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.type_ = "";
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.labels_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.metricKind_ = 0;
      this.valueType_ = 0;
      this.unit_ = "";
      this.description_ = "";
      this.displayName_ = "";
      if (this.metadataBuilder_ == null) {
        this.metadata_ = null;
      } else {
        this.metadata_ = null;
        this.metadataBuilder_ = null;
      } 
      this.launchStage_ = 0;
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = MetricDescriptor.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearDisplayName() {
      this.displayName_ = MetricDescriptor.getDefaultInstance().getDisplayName();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLabels() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.labels_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearLaunchStage() {
      this.launchStage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearMetadata() {
      if (this.metadataBuilder_ == null) {
        this.metadata_ = null;
        onChanged();
        return this;
      } 
      this.metadata_ = null;
      this.metadataBuilder_ = null;
      return this;
    }
    
    public Builder clearMetricKind() {
      this.metricKind_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = MetricDescriptor.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = MetricDescriptor.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clearUnit() {
      this.unit_ = MetricDescriptor.getDefaultInstance().getUnit();
      onChanged();
      return this;
    }
    
    public Builder clearValueType() {
      this.valueType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public MetricDescriptor getDefaultInstanceForType() {
      return MetricDescriptor.getDefaultInstance();
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
      return MetricProto.a;
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
    
    public LabelDescriptor getLabels(int param1Int) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.labels_.get(param1Int) : (LabelDescriptor)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public LabelDescriptor.Builder getLabelsBuilder(int param1Int) {
      return (LabelDescriptor.Builder)getLabelsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<LabelDescriptor.Builder> getLabelsBuilderList() {
      return getLabelsFieldBuilder().getBuilderList();
    }
    
    public int getLabelsCount() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.labels_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<LabelDescriptor> getLabelsList() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.labels_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public LabelDescriptorOrBuilder getLabelsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.labels_.get(param1Int) : (LabelDescriptorOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.labels_);
    }
    
    public LaunchStage getLaunchStage() {
      LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
      LaunchStage launchStage1 = launchStage2;
      if (launchStage2 == null)
        launchStage1 = LaunchStage.UNRECOGNIZED; 
      return launchStage1;
    }
    
    public int getLaunchStageValue() {
      return this.launchStage_;
    }
    
    public MetricDescriptor.MetricDescriptorMetadata getMetadata() {
      MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata;
      SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata1 = this.metadata_;
        metricDescriptorMetadata = metricDescriptorMetadata1;
        if (metricDescriptorMetadata1 == null)
          metricDescriptorMetadata = MetricDescriptor.MetricDescriptorMetadata.getDefaultInstance(); 
        return metricDescriptorMetadata;
      } 
      return (MetricDescriptor.MetricDescriptorMetadata)metricDescriptorMetadata.getMessage();
    }
    
    public MetricDescriptor.MetricDescriptorMetadata.Builder getMetadataBuilder() {
      onChanged();
      return (MetricDescriptor.MetricDescriptorMetadata.Builder)getMetadataFieldBuilder().getBuilder();
    }
    
    public MetricDescriptor.MetricDescriptorMetadataOrBuilder getMetadataOrBuilder() {
      SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MetricDescriptor.MetricDescriptorMetadataOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
      MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata1 = metricDescriptorMetadata2;
      if (metricDescriptorMetadata2 == null)
        metricDescriptorMetadata1 = MetricDescriptor.MetricDescriptorMetadata.getDefaultInstance(); 
      return metricDescriptorMetadata1;
    }
    
    public MetricDescriptor.MetricKind getMetricKind() {
      MetricDescriptor.MetricKind metricKind2 = MetricDescriptor.MetricKind.valueOf(this.metricKind_);
      MetricDescriptor.MetricKind metricKind1 = metricKind2;
      if (metricKind2 == null)
        metricKind1 = MetricDescriptor.MetricKind.UNRECOGNIZED; 
      return metricKind1;
    }
    
    public int getMetricKindValue() {
      return this.metricKind_;
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
    
    public String getType() {
      Object object = this.type_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.type_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTypeBytes() {
      Object object = this.type_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.type_ = object;
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
    
    public MetricDescriptor.ValueType getValueType() {
      MetricDescriptor.ValueType valueType2 = MetricDescriptor.ValueType.valueOf(this.valueType_);
      MetricDescriptor.ValueType valueType1 = valueType2;
      if (valueType2 == null)
        valueType1 = MetricDescriptor.ValueType.UNRECOGNIZED; 
      return valueType1;
    }
    
    public int getValueTypeValue() {
      return this.valueType_;
    }
    
    public boolean hasMetadata() {
      return (this.metadataBuilder_ != null || this.metadata_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MetricProto.b.ensureFieldAccessorsInitialized(MetricDescriptor.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MetricDescriptor param1MetricDescriptor) {
      if (param1MetricDescriptor == MetricDescriptor.getDefaultInstance())
        return this; 
      if (!param1MetricDescriptor.getName().isEmpty()) {
        this.name_ = param1MetricDescriptor.name_;
        onChanged();
      } 
      if (!param1MetricDescriptor.getType().isEmpty()) {
        this.type_ = param1MetricDescriptor.type_;
        onChanged();
      } 
      if (this.labelsBuilder_ == null) {
        if (!param1MetricDescriptor.labels_.isEmpty()) {
          if (this.labels_.isEmpty()) {
            this.labels_ = param1MetricDescriptor.labels_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureLabelsIsMutable();
            this.labels_.addAll(param1MetricDescriptor.labels_);
          } 
          onChanged();
        } 
      } else if (!param1MetricDescriptor.labels_.isEmpty()) {
        if (this.labelsBuilder_.isEmpty()) {
          this.labelsBuilder_.dispose();
          RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = null;
          this.labelsBuilder_ = null;
          this.labels_ = param1MetricDescriptor.labels_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (MetricDescriptor.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getLabelsFieldBuilder(); 
          this.labelsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.labelsBuilder_.addAllMessages(param1MetricDescriptor.labels_);
        } 
      } 
      if (param1MetricDescriptor.metricKind_ != 0)
        setMetricKindValue(param1MetricDescriptor.getMetricKindValue()); 
      if (param1MetricDescriptor.valueType_ != 0)
        setValueTypeValue(param1MetricDescriptor.getValueTypeValue()); 
      if (!param1MetricDescriptor.getUnit().isEmpty()) {
        this.unit_ = param1MetricDescriptor.unit_;
        onChanged();
      } 
      if (!param1MetricDescriptor.getDescription().isEmpty()) {
        this.description_ = param1MetricDescriptor.description_;
        onChanged();
      } 
      if (!param1MetricDescriptor.getDisplayName().isEmpty()) {
        this.displayName_ = param1MetricDescriptor.displayName_;
        onChanged();
      } 
      if (param1MetricDescriptor.hasMetadata())
        mergeMetadata(param1MetricDescriptor.getMetadata()); 
      if (param1MetricDescriptor.launchStage_ != 0)
        setLaunchStageValue(param1MetricDescriptor.getLaunchStageValue()); 
      mergeUnknownFields(param1MetricDescriptor.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MetricDescriptor metricDescriptor = (MetricDescriptor)MetricDescriptor.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MetricDescriptor metricDescriptor = (MetricDescriptor)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MetricDescriptor)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MetricDescriptor)
        return mergeFrom((MetricDescriptor)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeMetadata(MetricDescriptor.MetricDescriptorMetadata param1MetricDescriptorMetadata) {
      MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata;
      SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        metricDescriptorMetadata = this.metadata_;
        if (metricDescriptorMetadata != null) {
          this.metadata_ = MetricDescriptor.MetricDescriptorMetadata.newBuilder(metricDescriptorMetadata).mergeFrom(param1MetricDescriptorMetadata).buildPartial();
        } else {
          this.metadata_ = param1MetricDescriptorMetadata;
        } 
        onChanged();
        return this;
      } 
      metricDescriptorMetadata.mergeFrom((AbstractMessage)param1MetricDescriptorMetadata);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeLabels(int param1Int) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
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
        MetricDescriptor.checkByteStringIsUtf8(param1ByteString);
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
        MetricDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.displayName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LabelDescriptor != null) {
          ensureLabelsIsMutable();
          this.labels_.set(param1Int, param1LabelDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1LabelDescriptor);
      return this;
    }
    
    public Builder setLaunchStage(LaunchStage param1LaunchStage) {
      if (param1LaunchStage != null) {
        this.launchStage_ = param1LaunchStage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLaunchStageValue(int param1Int) {
      this.launchStage_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setMetadata(MetricDescriptor.MetricDescriptorMetadata.Builder param1Builder) {
      SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.metadata_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMetadata(MetricDescriptor.MetricDescriptorMetadata param1MetricDescriptorMetadata) {
      SingleFieldBuilderV3<MetricDescriptor.MetricDescriptorMetadata, MetricDescriptor.MetricDescriptorMetadata.Builder, MetricDescriptor.MetricDescriptorMetadataOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1MetricDescriptorMetadata != null) {
          this.metadata_ = param1MetricDescriptorMetadata;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1MetricDescriptorMetadata);
      return this;
    }
    
    public Builder setMetricKind(MetricDescriptor.MetricKind param1MetricKind) {
      if (param1MetricKind != null) {
        this.metricKind_ = param1MetricKind.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMetricKindValue(int param1Int) {
      this.metricKind_ = param1Int;
      onChanged();
      return this;
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
        MetricDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setType(String param1String) {
      if (param1String != null) {
        this.type_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MetricDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.type_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        MetricDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.unit_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setValueType(MetricDescriptor.ValueType param1ValueType) {
      if (param1ValueType != null) {
        this.valueType_ = param1ValueType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setValueTypeValue(int param1Int) {
      this.valueType_ = param1Int;
      onChanged();
      return this;
    }
  }
  
  public static final class MetricDescriptorMetadata extends GeneratedMessageV3 implements MetricDescriptorMetadataOrBuilder {
    private static final MetricDescriptorMetadata DEFAULT_INSTANCE = new MetricDescriptorMetadata();
    
    public static final int INGEST_DELAY_FIELD_NUMBER = 3;
    
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
    
    private static final Parser<MetricDescriptorMetadata> PARSER = (Parser<MetricDescriptorMetadata>)new AbstractParser<MetricDescriptorMetadata>() {
        public MetricDescriptor.MetricDescriptorMetadata a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new MetricDescriptor.MetricDescriptorMetadata(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private Duration ingestDelay_;
    
    private int launchStage_;
    
    private byte memoizedIsInitialized = -1;
    
    private Duration samplePeriod_;
    
    private MetricDescriptorMetadata() {
      this.launchStage_ = 0;
    }
    
    private MetricDescriptorMetadata(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                Duration.Builder builder2 = null;
                Duration.Builder builder1 = null;
                if (i != 18) {
                  if (i != 26) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  if (this.ingestDelay_ != null)
                    builder1 = this.ingestDelay_.toBuilder(); 
                  this.ingestDelay_ = (Duration)param1CodedInputStream.readMessage(Duration.parser(), param1ExtensionRegistryLite);
                  if (builder1 != null) {
                    builder1.mergeFrom(this.ingestDelay_);
                    this.ingestDelay_ = builder1.buildPartial();
                  } 
                  continue;
                } 
                builder1 = builder2;
                if (this.samplePeriod_ != null)
                  builder1 = this.samplePeriod_.toBuilder(); 
                this.samplePeriod_ = (Duration)param1CodedInputStream.readMessage(Duration.parser(), param1ExtensionRegistryLite);
                if (builder1 != null) {
                  builder1.mergeFrom(this.samplePeriod_);
                  this.samplePeriod_ = builder1.buildPartial();
                } 
                continue;
              } 
              this.launchStage_ = param1CodedInputStream.readEnum();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private MetricDescriptorMetadata(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static MetricDescriptorMetadata getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MetricProto.c;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MetricDescriptorMetadata param1MetricDescriptorMetadata) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1MetricDescriptorMetadata);
    }
    
    public static MetricDescriptorMetadata parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MetricDescriptorMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static MetricDescriptorMetadata parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MetricDescriptorMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MetricDescriptorMetadata parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MetricDescriptorMetadata)PARSER.parseFrom(param1ByteString);
    }
    
    public static MetricDescriptorMetadata parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MetricDescriptorMetadata)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MetricDescriptorMetadata parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MetricDescriptorMetadata)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static MetricDescriptorMetadata parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MetricDescriptorMetadata)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MetricDescriptorMetadata parseFrom(InputStream param1InputStream) throws IOException {
      return (MetricDescriptorMetadata)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static MetricDescriptorMetadata parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MetricDescriptorMetadata)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MetricDescriptorMetadata parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (MetricDescriptorMetadata)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static MetricDescriptorMetadata parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MetricDescriptorMetadata)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static MetricDescriptorMetadata parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MetricDescriptorMetadata)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static MetricDescriptorMetadata parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MetricDescriptorMetadata)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MetricDescriptorMetadata> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof MetricDescriptorMetadata))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.launchStage_ != ((MetricDescriptorMetadata)param1Object).launchStage_) ? false : ((hasSamplePeriod() != param1Object.hasSamplePeriod()) ? false : ((hasSamplePeriod() && !getSamplePeriod().equals(param1Object.getSamplePeriod())) ? false : ((hasIngestDelay() != param1Object.hasIngestDelay()) ? false : ((hasIngestDelay() && !getIngestDelay().equals(param1Object.getIngestDelay())) ? false : (!!this.unknownFields.equals(((MetricDescriptorMetadata)param1Object).unknownFields))))));
    }
    
    public MetricDescriptorMetadata getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Duration getIngestDelay() {
      Duration duration2 = this.ingestDelay_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return duration1;
    }
    
    public DurationOrBuilder getIngestDelayOrBuilder() {
      return (DurationOrBuilder)getIngestDelay();
    }
    
    @Deprecated
    public LaunchStage getLaunchStage() {
      LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
      LaunchStage launchStage1 = launchStage2;
      if (launchStage2 == null)
        launchStage1 = LaunchStage.UNRECOGNIZED; 
      return launchStage1;
    }
    
    @Deprecated
    public int getLaunchStageValue() {
      return this.launchStage_;
    }
    
    public Parser<MetricDescriptorMetadata> getParserForType() {
      return PARSER;
    }
    
    public Duration getSamplePeriod() {
      Duration duration2 = this.samplePeriod_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return duration1;
    }
    
    public DurationOrBuilder getSamplePeriodOrBuilder() {
      return (DurationOrBuilder)getSamplePeriod();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.launchStage_); 
      i = j;
      if (this.samplePeriod_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getSamplePeriod()); 
      j = i;
      if (this.ingestDelay_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getIngestDelay()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasIngestDelay() {
      return (this.ingestDelay_ != null);
    }
    
    public boolean hasSamplePeriod() {
      return (this.samplePeriod_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.launchStage_;
      int i = j;
      if (hasSamplePeriod())
        i = (j * 37 + 2) * 53 + getSamplePeriod().hashCode(); 
      j = i;
      if (hasIngestDelay())
        j = (i * 37 + 3) * 53 + getIngestDelay().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MetricProto.d.ensureFieldAccessorsInitialized(MetricDescriptorMetadata.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber())
        param1CodedOutputStream.writeEnum(1, this.launchStage_); 
      if (this.samplePeriod_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getSamplePeriod()); 
      if (this.ingestDelay_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getIngestDelay()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MetricDescriptor.MetricDescriptorMetadataOrBuilder {
      private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> ingestDelayBuilder_;
      
      private Duration ingestDelay_;
      
      private int launchStage_ = 0;
      
      private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> samplePeriodBuilder_;
      
      private Duration samplePeriod_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return MetricProto.c;
      }
      
      private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getIngestDelayFieldBuilder() {
        if (this.ingestDelayBuilder_ == null) {
          this.ingestDelayBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getIngestDelay(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.ingestDelay_ = null;
        } 
        return this.ingestDelayBuilder_;
      }
      
      private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getSamplePeriodFieldBuilder() {
        if (this.samplePeriodBuilder_ == null) {
          this.samplePeriodBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSamplePeriod(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.samplePeriod_ = null;
        } 
        return this.samplePeriodBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        MetricDescriptor.MetricDescriptorMetadata.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public MetricDescriptor.MetricDescriptorMetadata build() {
        MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = buildPartial();
        if (metricDescriptorMetadata.isInitialized())
          return metricDescriptorMetadata; 
        throw newUninitializedMessageException(metricDescriptorMetadata);
      }
      
      public MetricDescriptor.MetricDescriptorMetadata buildPartial() {
        MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptor.MetricDescriptorMetadata(this);
        MetricDescriptor.MetricDescriptorMetadata.access$402(metricDescriptorMetadata, this.launchStage_);
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
        if (singleFieldBuilderV3 == null) {
          MetricDescriptor.MetricDescriptorMetadata.access$502(metricDescriptorMetadata, this.samplePeriod_);
        } else {
          MetricDescriptor.MetricDescriptorMetadata.access$502(metricDescriptorMetadata, (Duration)singleFieldBuilderV3.build());
        } 
        singleFieldBuilderV3 = this.ingestDelayBuilder_;
        if (singleFieldBuilderV3 == null) {
          MetricDescriptor.MetricDescriptorMetadata.access$602(metricDescriptorMetadata, this.ingestDelay_);
        } else {
          MetricDescriptor.MetricDescriptorMetadata.access$602(metricDescriptorMetadata, (Duration)singleFieldBuilderV3.build());
        } 
        onBuilt();
        return metricDescriptorMetadata;
      }
      
      public Builder clear() {
        super.clear();
        this.launchStage_ = 0;
        if (this.samplePeriodBuilder_ == null) {
          this.samplePeriod_ = null;
        } else {
          this.samplePeriod_ = null;
          this.samplePeriodBuilder_ = null;
        } 
        if (this.ingestDelayBuilder_ == null) {
          this.ingestDelay_ = null;
          return this;
        } 
        this.ingestDelay_ = null;
        this.ingestDelayBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearIngestDelay() {
        if (this.ingestDelayBuilder_ == null) {
          this.ingestDelay_ = null;
          onChanged();
          return this;
        } 
        this.ingestDelay_ = null;
        this.ingestDelayBuilder_ = null;
        return this;
      }
      
      @Deprecated
      public Builder clearLaunchStage() {
        this.launchStage_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearSamplePeriod() {
        if (this.samplePeriodBuilder_ == null) {
          this.samplePeriod_ = null;
          onChanged();
          return this;
        } 
        this.samplePeriod_ = null;
        this.samplePeriodBuilder_ = null;
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public MetricDescriptor.MetricDescriptorMetadata getDefaultInstanceForType() {
        return MetricDescriptor.MetricDescriptorMetadata.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return MetricProto.c;
      }
      
      public Duration getIngestDelay() {
        Duration duration;
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
        if (singleFieldBuilderV3 == null) {
          Duration duration1 = this.ingestDelay_;
          duration = duration1;
          if (duration1 == null)
            duration = Duration.getDefaultInstance(); 
          return duration;
        } 
        return (Duration)duration.getMessage();
      }
      
      public Duration.Builder getIngestDelayBuilder() {
        onChanged();
        return (Duration.Builder)getIngestDelayFieldBuilder().getBuilder();
      }
      
      public DurationOrBuilder getIngestDelayOrBuilder() {
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
        if (singleFieldBuilderV3 != null)
          return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        Duration duration2 = this.ingestDelay_;
        Duration duration1 = duration2;
        if (duration2 == null)
          duration1 = Duration.getDefaultInstance(); 
        return (DurationOrBuilder)duration1;
      }
      
      @Deprecated
      public LaunchStage getLaunchStage() {
        LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
        LaunchStage launchStage1 = launchStage2;
        if (launchStage2 == null)
          launchStage1 = LaunchStage.UNRECOGNIZED; 
        return launchStage1;
      }
      
      @Deprecated
      public int getLaunchStageValue() {
        return this.launchStage_;
      }
      
      public Duration getSamplePeriod() {
        Duration duration;
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
        if (singleFieldBuilderV3 == null) {
          Duration duration1 = this.samplePeriod_;
          duration = duration1;
          if (duration1 == null)
            duration = Duration.getDefaultInstance(); 
          return duration;
        } 
        return (Duration)duration.getMessage();
      }
      
      public Duration.Builder getSamplePeriodBuilder() {
        onChanged();
        return (Duration.Builder)getSamplePeriodFieldBuilder().getBuilder();
      }
      
      public DurationOrBuilder getSamplePeriodOrBuilder() {
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
        if (singleFieldBuilderV3 != null)
          return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        Duration duration2 = this.samplePeriod_;
        Duration duration1 = duration2;
        if (duration2 == null)
          duration1 = Duration.getDefaultInstance(); 
        return (DurationOrBuilder)duration1;
      }
      
      public boolean hasIngestDelay() {
        return (this.ingestDelayBuilder_ != null || this.ingestDelay_ != null);
      }
      
      public boolean hasSamplePeriod() {
        return (this.samplePeriodBuilder_ != null || this.samplePeriod_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MetricProto.d.ensureFieldAccessorsInitialized(MetricDescriptor.MetricDescriptorMetadata.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(MetricDescriptor.MetricDescriptorMetadata param2MetricDescriptorMetadata) {
        if (param2MetricDescriptorMetadata == MetricDescriptor.MetricDescriptorMetadata.getDefaultInstance())
          return this; 
        if (param2MetricDescriptorMetadata.launchStage_ != 0)
          setLaunchStageValue(param2MetricDescriptorMetadata.getLaunchStageValue()); 
        if (param2MetricDescriptorMetadata.hasSamplePeriod())
          mergeSamplePeriod(param2MetricDescriptorMetadata.getSamplePeriod()); 
        if (param2MetricDescriptorMetadata.hasIngestDelay())
          mergeIngestDelay(param2MetricDescriptorMetadata.getIngestDelay()); 
        mergeUnknownFields(param2MetricDescriptorMetadata.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = (MetricDescriptor.MetricDescriptorMetadata)MetricDescriptor.MetricDescriptorMetadata.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = (MetricDescriptor.MetricDescriptorMetadata)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((MetricDescriptor.MetricDescriptorMetadata)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof MetricDescriptor.MetricDescriptorMetadata)
          return mergeFrom((MetricDescriptor.MetricDescriptorMetadata)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeIngestDelay(Duration param2Duration) {
        Duration duration;
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
        if (singleFieldBuilderV3 == null) {
          duration = this.ingestDelay_;
          if (duration != null) {
            this.ingestDelay_ = Duration.newBuilder(duration).mergeFrom(param2Duration).buildPartial();
          } else {
            this.ingestDelay_ = param2Duration;
          } 
          onChanged();
          return this;
        } 
        duration.mergeFrom((AbstractMessage)param2Duration);
        return this;
      }
      
      public Builder mergeSamplePeriod(Duration param2Duration) {
        Duration duration;
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
        if (singleFieldBuilderV3 == null) {
          duration = this.samplePeriod_;
          if (duration != null) {
            this.samplePeriod_ = Duration.newBuilder(duration).mergeFrom(param2Duration).buildPartial();
          } else {
            this.samplePeriod_ = param2Duration;
          } 
          onChanged();
          return this;
        } 
        duration.mergeFrom((AbstractMessage)param2Duration);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setIngestDelay(Duration.Builder param2Builder) {
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.ingestDelay_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setIngestDelay(Duration param2Duration) {
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Duration != null) {
            this.ingestDelay_ = param2Duration;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Duration);
        return this;
      }
      
      @Deprecated
      public Builder setLaunchStage(LaunchStage param2LaunchStage) {
        if (param2LaunchStage != null) {
          this.launchStage_ = param2LaunchStage.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      @Deprecated
      public Builder setLaunchStageValue(int param2Int) {
        this.launchStage_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSamplePeriod(Duration.Builder param2Builder) {
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.samplePeriod_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setSamplePeriod(Duration param2Duration) {
        SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Duration != null) {
            this.samplePeriod_ = param2Duration;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Duration);
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<MetricDescriptorMetadata> {
    public MetricDescriptor.MetricDescriptorMetadata a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new MetricDescriptor.MetricDescriptorMetadata(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<MetricDescriptorMetadata.Builder> implements MetricDescriptorMetadataOrBuilder {
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> ingestDelayBuilder_;
    
    private Duration ingestDelay_;
    
    private int launchStage_ = 0;
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> samplePeriodBuilder_;
    
    private Duration samplePeriod_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MetricProto.c;
    }
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getIngestDelayFieldBuilder() {
      if (this.ingestDelayBuilder_ == null) {
        this.ingestDelayBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getIngestDelay(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.ingestDelay_ = null;
      } 
      return this.ingestDelayBuilder_;
    }
    
    private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getSamplePeriodFieldBuilder() {
      if (this.samplePeriodBuilder_ == null) {
        this.samplePeriodBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSamplePeriod(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.samplePeriod_ = null;
      } 
      return this.samplePeriodBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      MetricDescriptor.MetricDescriptorMetadata.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MetricDescriptor.MetricDescriptorMetadata build() {
      MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = buildPartial();
      if (metricDescriptorMetadata.isInitialized())
        return metricDescriptorMetadata; 
      throw newUninitializedMessageException(metricDescriptorMetadata);
    }
    
    public MetricDescriptor.MetricDescriptorMetadata buildPartial() {
      MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptor.MetricDescriptorMetadata(this);
      MetricDescriptor.MetricDescriptorMetadata.access$402(metricDescriptorMetadata, this.launchStage_);
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
      if (singleFieldBuilderV3 == null) {
        MetricDescriptor.MetricDescriptorMetadata.access$502(metricDescriptorMetadata, this.samplePeriod_);
      } else {
        MetricDescriptor.MetricDescriptorMetadata.access$502(metricDescriptorMetadata, (Duration)singleFieldBuilderV3.build());
      } 
      singleFieldBuilderV3 = this.ingestDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        MetricDescriptor.MetricDescriptorMetadata.access$602(metricDescriptorMetadata, this.ingestDelay_);
      } else {
        MetricDescriptor.MetricDescriptorMetadata.access$602(metricDescriptorMetadata, (Duration)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return metricDescriptorMetadata;
    }
    
    public Builder clear() {
      super.clear();
      this.launchStage_ = 0;
      if (this.samplePeriodBuilder_ == null) {
        this.samplePeriod_ = null;
      } else {
        this.samplePeriod_ = null;
        this.samplePeriodBuilder_ = null;
      } 
      if (this.ingestDelayBuilder_ == null) {
        this.ingestDelay_ = null;
        return this;
      } 
      this.ingestDelay_ = null;
      this.ingestDelayBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearIngestDelay() {
      if (this.ingestDelayBuilder_ == null) {
        this.ingestDelay_ = null;
        onChanged();
        return this;
      } 
      this.ingestDelay_ = null;
      this.ingestDelayBuilder_ = null;
      return this;
    }
    
    @Deprecated
    public Builder clearLaunchStage() {
      this.launchStage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSamplePeriod() {
      if (this.samplePeriodBuilder_ == null) {
        this.samplePeriod_ = null;
        onChanged();
        return this;
      } 
      this.samplePeriod_ = null;
      this.samplePeriodBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public MetricDescriptor.MetricDescriptorMetadata getDefaultInstanceForType() {
      return MetricDescriptor.MetricDescriptorMetadata.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MetricProto.c;
    }
    
    public Duration getIngestDelay() {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        Duration duration1 = this.ingestDelay_;
        duration = duration1;
        if (duration1 == null)
          duration = Duration.getDefaultInstance(); 
        return duration;
      } 
      return (Duration)duration.getMessage();
    }
    
    public Duration.Builder getIngestDelayBuilder() {
      onChanged();
      return (Duration.Builder)getIngestDelayFieldBuilder().getBuilder();
    }
    
    public DurationOrBuilder getIngestDelayOrBuilder() {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
      if (singleFieldBuilderV3 != null)
        return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Duration duration2 = this.ingestDelay_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return (DurationOrBuilder)duration1;
    }
    
    @Deprecated
    public LaunchStage getLaunchStage() {
      LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
      LaunchStage launchStage1 = launchStage2;
      if (launchStage2 == null)
        launchStage1 = LaunchStage.UNRECOGNIZED; 
      return launchStage1;
    }
    
    @Deprecated
    public int getLaunchStageValue() {
      return this.launchStage_;
    }
    
    public Duration getSamplePeriod() {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
      if (singleFieldBuilderV3 == null) {
        Duration duration1 = this.samplePeriod_;
        duration = duration1;
        if (duration1 == null)
          duration = Duration.getDefaultInstance(); 
        return duration;
      } 
      return (Duration)duration.getMessage();
    }
    
    public Duration.Builder getSamplePeriodBuilder() {
      onChanged();
      return (Duration.Builder)getSamplePeriodFieldBuilder().getBuilder();
    }
    
    public DurationOrBuilder getSamplePeriodOrBuilder() {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
      if (singleFieldBuilderV3 != null)
        return (DurationOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Duration duration2 = this.samplePeriod_;
      Duration duration1 = duration2;
      if (duration2 == null)
        duration1 = Duration.getDefaultInstance(); 
      return (DurationOrBuilder)duration1;
    }
    
    public boolean hasIngestDelay() {
      return (this.ingestDelayBuilder_ != null || this.ingestDelay_ != null);
    }
    
    public boolean hasSamplePeriod() {
      return (this.samplePeriodBuilder_ != null || this.samplePeriod_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MetricProto.d.ensureFieldAccessorsInitialized(MetricDescriptor.MetricDescriptorMetadata.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MetricDescriptor.MetricDescriptorMetadata param1MetricDescriptorMetadata) {
      if (param1MetricDescriptorMetadata == MetricDescriptor.MetricDescriptorMetadata.getDefaultInstance())
        return this; 
      if (param1MetricDescriptorMetadata.launchStage_ != 0)
        setLaunchStageValue(param1MetricDescriptorMetadata.getLaunchStageValue()); 
      if (param1MetricDescriptorMetadata.hasSamplePeriod())
        mergeSamplePeriod(param1MetricDescriptorMetadata.getSamplePeriod()); 
      if (param1MetricDescriptorMetadata.hasIngestDelay())
        mergeIngestDelay(param1MetricDescriptorMetadata.getIngestDelay()); 
      mergeUnknownFields(param1MetricDescriptorMetadata.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = (MetricDescriptor.MetricDescriptorMetadata)MetricDescriptor.MetricDescriptorMetadata.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MetricDescriptor.MetricDescriptorMetadata metricDescriptorMetadata = (MetricDescriptor.MetricDescriptorMetadata)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MetricDescriptor.MetricDescriptorMetadata)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MetricDescriptor.MetricDescriptorMetadata)
        return mergeFrom((MetricDescriptor.MetricDescriptorMetadata)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeIngestDelay(Duration param1Duration) {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        duration = this.ingestDelay_;
        if (duration != null) {
          this.ingestDelay_ = Duration.newBuilder(duration).mergeFrom(param1Duration).buildPartial();
        } else {
          this.ingestDelay_ = param1Duration;
        } 
        onChanged();
        return this;
      } 
      duration.mergeFrom((AbstractMessage)param1Duration);
      return this;
    }
    
    public Builder mergeSamplePeriod(Duration param1Duration) {
      Duration duration;
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
      if (singleFieldBuilderV3 == null) {
        duration = this.samplePeriod_;
        if (duration != null) {
          this.samplePeriod_ = Duration.newBuilder(duration).mergeFrom(param1Duration).buildPartial();
        } else {
          this.samplePeriod_ = param1Duration;
        } 
        onChanged();
        return this;
      } 
      duration.mergeFrom((AbstractMessage)param1Duration);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setIngestDelay(Duration.Builder param1Builder) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.ingestDelay_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setIngestDelay(Duration param1Duration) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.ingestDelayBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Duration != null) {
          this.ingestDelay_ = param1Duration;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Duration);
      return this;
    }
    
    @Deprecated
    public Builder setLaunchStage(LaunchStage param1LaunchStage) {
      if (param1LaunchStage != null) {
        this.launchStage_ = param1LaunchStage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Builder setLaunchStageValue(int param1Int) {
      this.launchStage_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSamplePeriod(Duration.Builder param1Builder) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.samplePeriod_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSamplePeriod(Duration param1Duration) {
      SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.samplePeriodBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Duration != null) {
          this.samplePeriod_ = param1Duration;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Duration);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface MetricDescriptorMetadataOrBuilder extends MessageOrBuilder {
    Duration getIngestDelay();
    
    DurationOrBuilder getIngestDelayOrBuilder();
    
    @Deprecated
    LaunchStage getLaunchStage();
    
    @Deprecated
    int getLaunchStageValue();
    
    Duration getSamplePeriod();
    
    DurationOrBuilder getSamplePeriodOrBuilder();
    
    boolean hasIngestDelay();
    
    boolean hasSamplePeriod();
  }
  
  public enum MetricKind implements ProtocolMessageEnum {
    CUMULATIVE,
    DELTA,
    GAUGE,
    METRIC_KIND_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int CUMULATIVE_VALUE = 3;
    
    public static final int DELTA_VALUE = 2;
    
    public static final int GAUGE_VALUE = 1;
    
    public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
    
    private static final MetricKind[] VALUES;
    
    private static final Internal.EnumLiteMap<MetricKind> internalValueMap;
    
    private final int value;
    
    static {
      DELTA = new MetricKind("DELTA", 2, 2);
      CUMULATIVE = new MetricKind("CUMULATIVE", 3, 3);
      UNRECOGNIZED = new MetricKind("UNRECOGNIZED", 4, -1);
      $VALUES = new MetricKind[] { METRIC_KIND_UNSPECIFIED, GAUGE, DELTA, CUMULATIVE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<MetricKind>() {
          public MetricDescriptor.MetricKind a(int param2Int) {
            return MetricDescriptor.MetricKind.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    MetricKind(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static MetricKind forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : CUMULATIVE) : DELTA) : GAUGE) : METRIC_KIND_UNSPECIFIED;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MetricDescriptor.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public final int getNumber() {
      if (this != UNRECOGNIZED)
        return this.value; 
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
  }
  
  static final class null implements Internal.EnumLiteMap<MetricKind> {
    public MetricDescriptor.MetricKind a(int param1Int) {
      return MetricDescriptor.MetricKind.forNumber(param1Int);
    }
  }
  
  public enum ValueType implements ProtocolMessageEnum {
    BOOL(0),
    DISTRIBUTION(0),
    DOUBLE(0),
    INT64(0),
    MONEY(0),
    STRING(0),
    UNRECOGNIZED(0),
    VALUE_TYPE_UNSPECIFIED(0);
    
    public static final int BOOL_VALUE = 1;
    
    public static final int DISTRIBUTION_VALUE = 5;
    
    public static final int DOUBLE_VALUE = 3;
    
    public static final int INT64_VALUE = 2;
    
    public static final int MONEY_VALUE = 6;
    
    public static final int STRING_VALUE = 4;
    
    private static final ValueType[] VALUES;
    
    public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<ValueType> internalValueMap;
    
    private final int value;
    
    static {
      DOUBLE = new ValueType("DOUBLE", 3, 3);
      STRING = new ValueType("STRING", 4, 4);
      DISTRIBUTION = new ValueType("DISTRIBUTION", 5, 5);
      MONEY = new ValueType("MONEY", 6, 6);
      UNRECOGNIZED = new ValueType("UNRECOGNIZED", 7, -1);
      $VALUES = new ValueType[] { VALUE_TYPE_UNSPECIFIED, BOOL, INT64, DOUBLE, STRING, DISTRIBUTION, MONEY, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ValueType>() {
          public MetricDescriptor.ValueType a(int param2Int) {
            return MetricDescriptor.ValueType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    ValueType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ValueType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return MONEY;
        case 5:
          return DISTRIBUTION;
        case 4:
          return STRING;
        case 3:
          return DOUBLE;
        case 2:
          return INT64;
        case 1:
          return BOOL;
        case 0:
          break;
      } 
      return VALUE_TYPE_UNSPECIFIED;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MetricDescriptor.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public final int getNumber() {
      if (this != UNRECOGNIZED)
        return this.value; 
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
  }
  
  static final class null implements Internal.EnumLiteMap<ValueType> {
    public MetricDescriptor.ValueType a(int param1Int) {
      return MetricDescriptor.ValueType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MetricDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
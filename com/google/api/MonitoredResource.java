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

public final class MonitoredResource extends GeneratedMessageV3 implements MonitoredResourceOrBuilder {
  private static final MonitoredResource DEFAULT_INSTANCE = new MonitoredResource();
  
  public static final int LABELS_FIELD_NUMBER = 2;
  
  private static final Parser<MonitoredResource> PARSER = (Parser<MonitoredResource>)new AbstractParser<MonitoredResource>() {
      public MonitoredResource a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new MonitoredResource(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private MapField<String, String> labels_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object type_;
  
  private MonitoredResource() {
    this.type_ = "";
  }
  
  private MonitoredResource(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                this.labels_ = MapField.newMapField(LabelsDefaultEntryHolder.a);
                j = i | 0x2;
              } 
              MapEntry mapEntry = (MapEntry)paramCodedInputStream.readMessage(LabelsDefaultEntryHolder.a.getParserForType(), paramExtensionRegistryLite);
              this.labels_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
              i = j;
              continue;
            } 
            this.type_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private MonitoredResource(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static MonitoredResource getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return MonitoredResourceProto.c;
  }
  
  private MapField<String, String> internalGetLabels() {
    MapField<String, String> mapField2 = this.labels_;
    MapField<String, String> mapField1 = mapField2;
    if (mapField2 == null)
      mapField1 = MapField.emptyMapField(LabelsDefaultEntryHolder.a); 
    return mapField1;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MonitoredResource paramMonitoredResource) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMonitoredResource);
  }
  
  public static MonitoredResource parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResource)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MonitoredResource parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResource)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MonitoredResource)PARSER.parseFrom(paramByteString);
  }
  
  public static MonitoredResource parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResource)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MonitoredResource)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MonitoredResource parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResource)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResource)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MonitoredResource parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResource)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (MonitoredResource)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MonitoredResource parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResource)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MonitoredResource)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static MonitoredResource parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResource)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MonitoredResource> parser() {
    return PARSER;
  }
  
  public boolean containsLabels(String paramString) {
    if (paramString != null)
      return internalGetLabels().getMap().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MonitoredResource))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getType().equals(paramObject.getType()) ? false : (!internalGetLabels().equals(paramObject.internalGetLabels()) ? false : (!!this.unknownFields.equals(((MonitoredResource)paramObject).unknownFields)));
  }
  
  public MonitoredResource getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  @Deprecated
  public Map<String, String> getLabels() {
    return getLabelsMap();
  }
  
  public int getLabelsCount() {
    return internalGetLabels().getMap().size();
  }
  
  public Map<String, String> getLabelsMap() {
    return internalGetLabels().getMap();
  }
  
  public String getLabelsOrDefault(String paramString1, String paramString2) {
    if (paramString1 != null) {
      Map map = internalGetLabels().getMap();
      if (map.containsKey(paramString1))
        paramString2 = (String)map.get(paramString1); 
      return paramString2;
    } 
    throw new NullPointerException();
  }
  
  public String getLabelsOrThrow(String paramString) {
    if (paramString != null) {
      Map map = internalGetLabels().getMap();
      if (map.containsKey(paramString))
        return (String)map.get(paramString); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public Parser<MonitoredResource> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getTypeBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.type_); 
    for (Map.Entry entry : internalGetLabels().getMap().entrySet())
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)LabelsDefaultEntryHolder.a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build()); 
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
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getType().hashCode();
    int i = j;
    if (!internalGetLabels().getMap().isEmpty())
      i = (j * 37 + 2) * 53 + internalGetLabels().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return MonitoredResourceProto.d.ensureFieldAccessorsInitialized(MonitoredResource.class, Builder.class);
  }
  
  public MapField internalGetMapField(int paramInt) {
    if (paramInt == 2)
      return internalGetLabels(); 
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
    if (!getTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.type_); 
    GeneratedMessageV3.serializeStringMapTo(paramCodedOutputStream, internalGetLabels(), LabelsDefaultEntryHolder.a, 2);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoredResourceOrBuilder {
    private int bitField0_;
    
    private MapField<String, String> labels_;
    
    private Object type_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MonitoredResourceProto.c;
    }
    
    private MapField<String, String> internalGetLabels() {
      MapField<String, String> mapField2 = this.labels_;
      MapField<String, String> mapField1 = mapField2;
      if (mapField2 == null)
        mapField1 = MapField.emptyMapField(MonitoredResource.LabelsDefaultEntryHolder.a); 
      return mapField1;
    }
    
    private MapField<String, String> internalGetMutableLabels() {
      onChanged();
      if (this.labels_ == null)
        this.labels_ = MapField.newMapField(MonitoredResource.LabelsDefaultEntryHolder.a); 
      if (!this.labels_.isMutable())
        this.labels_ = this.labels_.copy(); 
      return this.labels_;
    }
    
    private void maybeForceBuilderInitialization() {
      MonitoredResource.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MonitoredResource build() {
      MonitoredResource monitoredResource = buildPartial();
      if (monitoredResource.isInitialized())
        return monitoredResource; 
      throw newUninitializedMessageException(monitoredResource);
    }
    
    public MonitoredResource buildPartial() {
      MonitoredResource monitoredResource = new MonitoredResource(this);
      int i = this.bitField0_;
      MonitoredResource.access$402(monitoredResource, this.type_);
      MonitoredResource.access$502(monitoredResource, internalGetLabels());
      monitoredResource.labels_.makeImmutable();
      MonitoredResource.access$602(monitoredResource, 0);
      onBuilt();
      return monitoredResource;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = "";
      internalGetMutableLabels().clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLabels() {
      internalGetMutableLabels().getMutableMap().clear();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = MonitoredResource.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public boolean containsLabels(String param1String) {
      if (param1String != null)
        return internalGetLabels().getMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public MonitoredResource getDefaultInstanceForType() {
      return MonitoredResource.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MonitoredResourceProto.c;
    }
    
    @Deprecated
    public Map<String, String> getLabels() {
      return getLabelsMap();
    }
    
    public int getLabelsCount() {
      return internalGetLabels().getMap().size();
    }
    
    public Map<String, String> getLabelsMap() {
      return internalGetLabels().getMap();
    }
    
    public String getLabelsOrDefault(String param1String1, String param1String2) {
      if (param1String1 != null) {
        Map map = internalGetLabels().getMap();
        if (map.containsKey(param1String1))
          param1String2 = (String)map.get(param1String1); 
        return param1String2;
      } 
      throw new NullPointerException();
    }
    
    public String getLabelsOrThrow(String param1String) {
      if (param1String != null) {
        Map map = internalGetLabels().getMap();
        if (map.containsKey(param1String))
          return (String)map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, String> getMutableLabels() {
      return internalGetMutableLabels().getMutableMap();
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MonitoredResourceProto.d.ensureFieldAccessorsInitialized(MonitoredResource.class, Builder.class);
    }
    
    public MapField internalGetMapField(int param1Int) {
      if (param1Int == 2)
        return internalGetLabels(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public MapField internalGetMutableMapField(int param1Int) {
      if (param1Int == 2)
        return internalGetMutableLabels(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MonitoredResource param1MonitoredResource) {
      if (param1MonitoredResource == MonitoredResource.getDefaultInstance())
        return this; 
      if (!param1MonitoredResource.getType().isEmpty()) {
        this.type_ = param1MonitoredResource.type_;
        onChanged();
      } 
      internalGetMutableLabels().mergeFrom(param1MonitoredResource.internalGetLabels());
      mergeUnknownFields(param1MonitoredResource.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MonitoredResource monitoredResource = (MonitoredResource)MonitoredResource.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MonitoredResource monitoredResource = (MonitoredResource)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MonitoredResource)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MonitoredResource)
        return mergeFrom((MonitoredResource)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder putAllLabels(Map<String, String> param1Map) {
      internalGetMutableLabels().getMutableMap().putAll(param1Map);
      return this;
    }
    
    public Builder putLabels(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (param1String2 != null) {
          internalGetMutableLabels().getMutableMap().put(param1String1, param1String2);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeLabels(String param1String) {
      if (param1String != null) {
        internalGetMutableLabels().getMutableMap().remove(param1String);
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
        MonitoredResource.checkByteStringIsUtf8(param1ByteString);
        this.type_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  static final class LabelsDefaultEntryHolder {
    static final MapEntry<String, String> a = MapEntry.newDefaultInstance(MonitoredResourceProto.e, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
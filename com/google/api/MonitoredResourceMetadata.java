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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

public final class MonitoredResourceMetadata extends GeneratedMessageV3 implements MonitoredResourceMetadataOrBuilder {
  private static final MonitoredResourceMetadata DEFAULT_INSTANCE = new MonitoredResourceMetadata();
  
  private static final Parser<MonitoredResourceMetadata> PARSER = (Parser<MonitoredResourceMetadata>)new AbstractParser<MonitoredResourceMetadata>() {
      public MonitoredResourceMetadata a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new MonitoredResourceMetadata(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SYSTEM_LABELS_FIELD_NUMBER = 1;
  
  public static final int USER_LABELS_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private Struct systemLabels_;
  
  private MapField<String, String> userLabels_;
  
  private MonitoredResourceMetadata() {}
  
  private MonitoredResourceMetadata(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                this.userLabels_ = MapField.newMapField(UserLabelsDefaultEntryHolder.a);
                j = i | 0x2;
              } 
              MapEntry mapEntry = (MapEntry)paramCodedInputStream.readMessage(UserLabelsDefaultEntryHolder.a.getParserForType(), paramExtensionRegistryLite);
              this.userLabels_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
              i = j;
              continue;
            } 
            Struct.Builder builder1 = null;
            if (this.systemLabels_ != null)
              builder1 = this.systemLabels_.toBuilder(); 
            this.systemLabels_ = (Struct)paramCodedInputStream.readMessage(Struct.parser(), paramExtensionRegistryLite);
            if (builder1 != null) {
              builder1.mergeFrom(this.systemLabels_);
              this.systemLabels_ = builder1.buildPartial();
            } 
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
  
  private MonitoredResourceMetadata(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static MonitoredResourceMetadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return MonitoredResourceProto.g;
  }
  
  private MapField<String, String> internalGetUserLabels() {
    MapField<String, String> mapField2 = this.userLabels_;
    MapField<String, String> mapField1 = mapField2;
    if (mapField2 == null)
      mapField1 = MapField.emptyMapField(UserLabelsDefaultEntryHolder.a); 
    return mapField1;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MonitoredResourceMetadata paramMonitoredResourceMetadata) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMonitoredResourceMetadata);
  }
  
  public static MonitoredResourceMetadata parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResourceMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MonitoredResourceMetadata parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceMetadata parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MonitoredResourceMetadata)PARSER.parseFrom(paramByteString);
  }
  
  public static MonitoredResourceMetadata parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceMetadata)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceMetadata parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MonitoredResourceMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MonitoredResourceMetadata parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceMetadata parseFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResourceMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MonitoredResourceMetadata parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceMetadata)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceMetadata parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (MonitoredResourceMetadata)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MonitoredResourceMetadata parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceMetadata)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceMetadata parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MonitoredResourceMetadata)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static MonitoredResourceMetadata parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceMetadata)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MonitoredResourceMetadata> parser() {
    return PARSER;
  }
  
  public boolean containsUserLabels(String paramString) {
    if (paramString != null)
      return internalGetUserLabels().getMap().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MonitoredResourceMetadata))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (hasSystemLabels() != paramObject.hasSystemLabels()) ? false : ((hasSystemLabels() && !getSystemLabels().equals(paramObject.getSystemLabels())) ? false : (!internalGetUserLabels().equals(paramObject.internalGetUserLabels()) ? false : (!!this.unknownFields.equals(((MonitoredResourceMetadata)paramObject).unknownFields))));
  }
  
  public MonitoredResourceMetadata getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<MonitoredResourceMetadata> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.systemLabels_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getSystemLabels()); 
    for (Map.Entry entry : internalGetUserLabels().getMap().entrySet())
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)UserLabelsDefaultEntryHolder.a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build()); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public Struct getSystemLabels() {
    Struct struct2 = this.systemLabels_;
    Struct struct1 = struct2;
    if (struct2 == null)
      struct1 = Struct.getDefaultInstance(); 
    return struct1;
  }
  
  public StructOrBuilder getSystemLabelsOrBuilder() {
    return (StructOrBuilder)getSystemLabels();
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  @Deprecated
  public Map<String, String> getUserLabels() {
    return getUserLabelsMap();
  }
  
  public int getUserLabelsCount() {
    return internalGetUserLabels().getMap().size();
  }
  
  public Map<String, String> getUserLabelsMap() {
    return internalGetUserLabels().getMap();
  }
  
  public String getUserLabelsOrDefault(String paramString1, String paramString2) {
    if (paramString1 != null) {
      Map map = internalGetUserLabels().getMap();
      if (map.containsKey(paramString1))
        paramString2 = (String)map.get(paramString1); 
      return paramString2;
    } 
    throw new NullPointerException();
  }
  
  public String getUserLabelsOrThrow(String paramString) {
    if (paramString != null) {
      Map map = internalGetUserLabels().getMap();
      if (map.containsKey(paramString))
        return (String)map.get(paramString); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public boolean hasSystemLabels() {
    return (this.systemLabels_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasSystemLabels())
      i = (j * 37 + 1) * 53 + getSystemLabels().hashCode(); 
    j = i;
    if (!internalGetUserLabels().getMap().isEmpty())
      j = (i * 37 + 2) * 53 + internalGetUserLabels().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return MonitoredResourceProto.h.ensureFieldAccessorsInitialized(MonitoredResourceMetadata.class, Builder.class);
  }
  
  public MapField internalGetMapField(int paramInt) {
    if (paramInt == 2)
      return internalGetUserLabels(); 
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
    if (this.systemLabels_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getSystemLabels()); 
    GeneratedMessageV3.serializeStringMapTo(paramCodedOutputStream, internalGetUserLabels(), UserLabelsDefaultEntryHolder.a, 2);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoredResourceMetadataOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> systemLabelsBuilder_;
    
    private Struct systemLabels_;
    
    private MapField<String, String> userLabels_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MonitoredResourceProto.g;
    }
    
    private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getSystemLabelsFieldBuilder() {
      if (this.systemLabelsBuilder_ == null) {
        this.systemLabelsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSystemLabels(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.systemLabels_ = null;
      } 
      return this.systemLabelsBuilder_;
    }
    
    private MapField<String, String> internalGetMutableUserLabels() {
      onChanged();
      if (this.userLabels_ == null)
        this.userLabels_ = MapField.newMapField(MonitoredResourceMetadata.UserLabelsDefaultEntryHolder.a); 
      if (!this.userLabels_.isMutable())
        this.userLabels_ = this.userLabels_.copy(); 
      return this.userLabels_;
    }
    
    private MapField<String, String> internalGetUserLabels() {
      MapField<String, String> mapField2 = this.userLabels_;
      MapField<String, String> mapField1 = mapField2;
      if (mapField2 == null)
        mapField1 = MapField.emptyMapField(MonitoredResourceMetadata.UserLabelsDefaultEntryHolder.a); 
      return mapField1;
    }
    
    private void maybeForceBuilderInitialization() {
      MonitoredResourceMetadata.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MonitoredResourceMetadata build() {
      MonitoredResourceMetadata monitoredResourceMetadata = buildPartial();
      if (monitoredResourceMetadata.isInitialized())
        return monitoredResourceMetadata; 
      throw newUninitializedMessageException(monitoredResourceMetadata);
    }
    
    public MonitoredResourceMetadata buildPartial() {
      MonitoredResourceMetadata monitoredResourceMetadata = new MonitoredResourceMetadata(this);
      int i = this.bitField0_;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
      if (singleFieldBuilderV3 == null) {
        MonitoredResourceMetadata.access$402(monitoredResourceMetadata, this.systemLabels_);
      } else {
        MonitoredResourceMetadata.access$402(monitoredResourceMetadata, (Struct)singleFieldBuilderV3.build());
      } 
      MonitoredResourceMetadata.access$502(monitoredResourceMetadata, internalGetUserLabels());
      monitoredResourceMetadata.userLabels_.makeImmutable();
      MonitoredResourceMetadata.access$602(monitoredResourceMetadata, 0);
      onBuilt();
      return monitoredResourceMetadata;
    }
    
    public Builder clear() {
      super.clear();
      if (this.systemLabelsBuilder_ == null) {
        this.systemLabels_ = null;
      } else {
        this.systemLabels_ = null;
        this.systemLabelsBuilder_ = null;
      } 
      internalGetMutableUserLabels().clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSystemLabels() {
      if (this.systemLabelsBuilder_ == null) {
        this.systemLabels_ = null;
        onChanged();
        return this;
      } 
      this.systemLabels_ = null;
      this.systemLabelsBuilder_ = null;
      return this;
    }
    
    public Builder clearUserLabels() {
      internalGetMutableUserLabels().getMutableMap().clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public boolean containsUserLabels(String param1String) {
      if (param1String != null)
        return internalGetUserLabels().getMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public MonitoredResourceMetadata getDefaultInstanceForType() {
      return MonitoredResourceMetadata.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MonitoredResourceProto.g;
    }
    
    @Deprecated
    public Map<String, String> getMutableUserLabels() {
      return internalGetMutableUserLabels().getMutableMap();
    }
    
    public Struct getSystemLabels() {
      Struct struct;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
      if (singleFieldBuilderV3 == null) {
        Struct struct1 = this.systemLabels_;
        struct = struct1;
        if (struct1 == null)
          struct = Struct.getDefaultInstance(); 
        return struct;
      } 
      return (Struct)struct.getMessage();
    }
    
    public Struct.Builder getSystemLabelsBuilder() {
      onChanged();
      return (Struct.Builder)getSystemLabelsFieldBuilder().getBuilder();
    }
    
    public StructOrBuilder getSystemLabelsOrBuilder() {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
      if (singleFieldBuilderV3 != null)
        return (StructOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Struct struct2 = this.systemLabels_;
      Struct struct1 = struct2;
      if (struct2 == null)
        struct1 = Struct.getDefaultInstance(); 
      return (StructOrBuilder)struct1;
    }
    
    @Deprecated
    public Map<String, String> getUserLabels() {
      return getUserLabelsMap();
    }
    
    public int getUserLabelsCount() {
      return internalGetUserLabels().getMap().size();
    }
    
    public Map<String, String> getUserLabelsMap() {
      return internalGetUserLabels().getMap();
    }
    
    public String getUserLabelsOrDefault(String param1String1, String param1String2) {
      if (param1String1 != null) {
        Map map = internalGetUserLabels().getMap();
        if (map.containsKey(param1String1))
          param1String2 = (String)map.get(param1String1); 
        return param1String2;
      } 
      throw new NullPointerException();
    }
    
    public String getUserLabelsOrThrow(String param1String) {
      if (param1String != null) {
        Map map = internalGetUserLabels().getMap();
        if (map.containsKey(param1String))
          return (String)map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public boolean hasSystemLabels() {
      return (this.systemLabelsBuilder_ != null || this.systemLabels_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MonitoredResourceProto.h.ensureFieldAccessorsInitialized(MonitoredResourceMetadata.class, Builder.class);
    }
    
    public MapField internalGetMapField(int param1Int) {
      if (param1Int == 2)
        return internalGetUserLabels(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public MapField internalGetMutableMapField(int param1Int) {
      if (param1Int == 2)
        return internalGetMutableUserLabels(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid map field number: ");
      stringBuilder.append(param1Int);
      throw new RuntimeException(stringBuilder.toString());
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MonitoredResourceMetadata param1MonitoredResourceMetadata) {
      if (param1MonitoredResourceMetadata == MonitoredResourceMetadata.getDefaultInstance())
        return this; 
      if (param1MonitoredResourceMetadata.hasSystemLabels())
        mergeSystemLabels(param1MonitoredResourceMetadata.getSystemLabels()); 
      internalGetMutableUserLabels().mergeFrom(param1MonitoredResourceMetadata.internalGetUserLabels());
      mergeUnknownFields(param1MonitoredResourceMetadata.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MonitoredResourceMetadata monitoredResourceMetadata = (MonitoredResourceMetadata)MonitoredResourceMetadata.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MonitoredResourceMetadata monitoredResourceMetadata = (MonitoredResourceMetadata)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MonitoredResourceMetadata)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MonitoredResourceMetadata)
        return mergeFrom((MonitoredResourceMetadata)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeSystemLabels(Struct param1Struct) {
      Struct struct;
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
      if (singleFieldBuilderV3 == null) {
        struct = this.systemLabels_;
        if (struct != null) {
          this.systemLabels_ = Struct.newBuilder(struct).mergeFrom(param1Struct).buildPartial();
        } else {
          this.systemLabels_ = param1Struct;
        } 
        onChanged();
        return this;
      } 
      struct.mergeFrom((AbstractMessage)param1Struct);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder putAllUserLabels(Map<String, String> param1Map) {
      internalGetMutableUserLabels().getMutableMap().putAll(param1Map);
      return this;
    }
    
    public Builder putUserLabels(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (param1String2 != null) {
          internalGetMutableUserLabels().getMutableMap().put(param1String1, param1String2);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeUserLabels(String param1String) {
      if (param1String != null) {
        internalGetMutableUserLabels().getMutableMap().remove(param1String);
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
    
    public Builder setSystemLabels(Struct.Builder param1Builder) {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.systemLabels_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSystemLabels(Struct param1Struct) {
      SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.systemLabelsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Struct != null) {
          this.systemLabels_ = param1Struct;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Struct);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  static final class UserLabelsDefaultEntryHolder {
    static final MapEntry<String, String> a = MapEntry.newDefaultInstance(MonitoredResourceProto.i, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResourceMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
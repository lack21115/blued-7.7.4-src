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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LabelDescriptor extends GeneratedMessageV3 implements LabelDescriptorOrBuilder {
  private static final LabelDescriptor DEFAULT_INSTANCE = new LabelDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int KEY_FIELD_NUMBER = 1;
  
  private static final Parser<LabelDescriptor> PARSER = (Parser<LabelDescriptor>)new AbstractParser<LabelDescriptor>() {
      public LabelDescriptor a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new LabelDescriptor(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int VALUE_TYPE_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object description_;
  
  private volatile Object key_;
  
  private byte memoizedIsInitialized = -1;
  
  private int valueType_;
  
  private LabelDescriptor() {
    this.key_ = "";
    this.valueType_ = 0;
    this.description_ = "";
  }
  
  private LabelDescriptor(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 16) {
                if (i != 26) {
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.description_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.valueType_ = paramCodedInputStream.readEnum();
              continue;
            } 
            this.key_ = paramCodedInputStream.readStringRequireUtf8();
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
      } 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private LabelDescriptor(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static LabelDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return LabelProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LabelDescriptor paramLabelDescriptor) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramLabelDescriptor);
  }
  
  public static LabelDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LabelDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static LabelDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LabelDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LabelDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LabelDescriptor)PARSER.parseFrom(paramByteString);
  }
  
  public static LabelDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LabelDescriptor)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static LabelDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LabelDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static LabelDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LabelDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LabelDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (LabelDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static LabelDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LabelDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LabelDescriptor parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (LabelDescriptor)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static LabelDescriptor parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LabelDescriptor)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static LabelDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LabelDescriptor)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static LabelDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LabelDescriptor)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LabelDescriptor> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof LabelDescriptor))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getKey().equals(paramObject.getKey()) ? false : ((this.valueType_ != ((LabelDescriptor)paramObject).valueType_) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!!this.unknownFields.equals(((LabelDescriptor)paramObject).unknownFields))));
  }
  
  public LabelDescriptor getDefaultInstanceForType() {
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
  
  public String getKey() {
    Object object = this.key_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.key_ = object;
    return (String)object;
  }
  
  public ByteString getKeyBytes() {
    Object object = this.key_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.key_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<LabelDescriptor> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getKeyBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.key_); 
    i = j;
    if (this.valueType_ != ValueType.STRING.getNumber())
      i = j + CodedOutputStream.computeEnumSize(2, this.valueType_); 
    j = i;
    if (!getDescriptionBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.description_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
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
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getKey().hashCode()) * 37 + 2) * 53 + this.valueType_) * 37 + 3) * 53 + getDescription().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return LabelProto.b.ensureFieldAccessorsInitialized(LabelDescriptor.class, Builder.class);
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
    if (!getKeyBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.key_); 
    if (this.valueType_ != ValueType.STRING.getNumber())
      paramCodedOutputStream.writeEnum(2, this.valueType_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.description_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LabelDescriptorOrBuilder {
    private Object description_ = "";
    
    private Object key_ = "";
    
    private int valueType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LabelProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      LabelDescriptor.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LabelDescriptor build() {
      LabelDescriptor labelDescriptor = buildPartial();
      if (labelDescriptor.isInitialized())
        return labelDescriptor; 
      throw newUninitializedMessageException(labelDescriptor);
    }
    
    public LabelDescriptor buildPartial() {
      LabelDescriptor labelDescriptor = new LabelDescriptor(this);
      LabelDescriptor.access$402(labelDescriptor, this.key_);
      LabelDescriptor.access$502(labelDescriptor, this.valueType_);
      LabelDescriptor.access$602(labelDescriptor, this.description_);
      onBuilt();
      return labelDescriptor;
    }
    
    public Builder clear() {
      super.clear();
      this.key_ = "";
      this.valueType_ = 0;
      this.description_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = LabelDescriptor.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearKey() {
      this.key_ = LabelDescriptor.getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearValueType() {
      this.valueType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LabelDescriptor getDefaultInstanceForType() {
      return LabelDescriptor.getDefaultInstance();
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
      return LabelProto.a;
    }
    
    public String getKey() {
      Object object = this.key_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.key_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getKeyBytes() {
      Object object = this.key_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.key_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LabelDescriptor.ValueType getValueType() {
      LabelDescriptor.ValueType valueType2 = LabelDescriptor.ValueType.valueOf(this.valueType_);
      LabelDescriptor.ValueType valueType1 = valueType2;
      if (valueType2 == null)
        valueType1 = LabelDescriptor.ValueType.UNRECOGNIZED; 
      return valueType1;
    }
    
    public int getValueTypeValue() {
      return this.valueType_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LabelProto.b.ensureFieldAccessorsInitialized(LabelDescriptor.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LabelDescriptor param1LabelDescriptor) {
      if (param1LabelDescriptor == LabelDescriptor.getDefaultInstance())
        return this; 
      if (!param1LabelDescriptor.getKey().isEmpty()) {
        this.key_ = param1LabelDescriptor.key_;
        onChanged();
      } 
      if (param1LabelDescriptor.valueType_ != 0)
        setValueTypeValue(param1LabelDescriptor.getValueTypeValue()); 
      if (!param1LabelDescriptor.getDescription().isEmpty()) {
        this.description_ = param1LabelDescriptor.description_;
        onChanged();
      } 
      mergeUnknownFields(param1LabelDescriptor.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LabelDescriptor labelDescriptor = (LabelDescriptor)LabelDescriptor.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LabelDescriptor labelDescriptor = (LabelDescriptor)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LabelDescriptor)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LabelDescriptor)
        return mergeFrom((LabelDescriptor)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
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
        LabelDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setKey(String param1String) {
      if (param1String != null) {
        this.key_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setKeyBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LabelDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.key_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setValueType(LabelDescriptor.ValueType param1ValueType) {
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
  
  public enum ValueType implements ProtocolMessageEnum {
    BOOL,
    INT64,
    STRING(0),
    UNRECOGNIZED(0);
    
    public static final int BOOL_VALUE = 1;
    
    public static final int INT64_VALUE = 2;
    
    public static final int STRING_VALUE = 0;
    
    private static final ValueType[] VALUES;
    
    private static final Internal.EnumLiteMap<ValueType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new ValueType[] { STRING, BOOL, INT64, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ValueType>() {
          public LabelDescriptor.ValueType a(int param2Int) {
            return LabelDescriptor.ValueType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    ValueType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ValueType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : INT64) : BOOL) : STRING;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LabelDescriptor.getDescriptor().getEnumTypes().get(0);
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
    public LabelDescriptor.ValueType a(int param1Int) {
      return LabelDescriptor.ValueType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LabelDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
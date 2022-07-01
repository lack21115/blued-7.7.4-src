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

public final class Property extends GeneratedMessageV3 implements PropertyOrBuilder {
  private static final Property DEFAULT_INSTANCE = new Property();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<Property> PARSER = (Parser<Property>)new AbstractParser<Property>() {
      public Property a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Property(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object description_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private int type_;
  
  private Property() {
    this.name_ = "";
    this.type_ = 0;
    this.description_ = "";
  }
  
  private Property(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.type_ = paramCodedInputStream.readEnum();
              continue;
            } 
            this.name_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private Property(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Property getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ConsumerProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Property paramProperty) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramProperty);
  }
  
  public static Property parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Property)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Property parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Property)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Property)PARSER.parseFrom(paramByteString);
  }
  
  public static Property parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Property)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Property)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Property parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Property)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(InputStream paramInputStream) throws IOException {
    return (Property)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Property parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Property)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Property)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Property parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Property)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Property)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Property parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Property)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Property> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Property))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : ((this.type_ != ((Property)paramObject).type_) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!!this.unknownFields.equals(((Property)paramObject).unknownFields))));
  }
  
  public Property getDefaultInstanceForType() {
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
  
  public Parser<Property> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getNameBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
    i = j;
    if (this.type_ != PropertyType.UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(2, this.type_); 
    j = i;
    if (!getDescriptionBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.description_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public PropertyType getType() {
    PropertyType propertyType2 = PropertyType.valueOf(this.type_);
    PropertyType propertyType1 = propertyType2;
    if (propertyType2 == null)
      propertyType1 = PropertyType.UNRECOGNIZED; 
    return propertyType1;
  }
  
  public int getTypeValue() {
    return this.type_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + this.type_) * 37 + 3) * 53 + getDescription().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ConsumerProto.d.ensureFieldAccessorsInitialized(Property.class, Builder.class);
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
    if (this.type_ != PropertyType.UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(2, this.type_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.description_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PropertyOrBuilder {
    private Object description_ = "";
    
    private Object name_ = "";
    
    private int type_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConsumerProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      Property.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Property build() {
      Property property = buildPartial();
      if (property.isInitialized())
        return property; 
      throw newUninitializedMessageException(property);
    }
    
    public Property buildPartial() {
      Property property = new Property(this);
      Property.access$402(property, this.name_);
      Property.access$502(property, this.type_);
      Property.access$602(property, this.description_);
      onBuilt();
      return property;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.type_ = 0;
      this.description_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = Property.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = Property.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Property getDefaultInstanceForType() {
      return Property.getDefaultInstance();
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
      return ConsumerProto.c;
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
    
    public Property.PropertyType getType() {
      Property.PropertyType propertyType2 = Property.PropertyType.valueOf(this.type_);
      Property.PropertyType propertyType1 = propertyType2;
      if (propertyType2 == null)
        propertyType1 = Property.PropertyType.UNRECOGNIZED; 
      return propertyType1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConsumerProto.d.ensureFieldAccessorsInitialized(Property.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Property param1Property) {
      if (param1Property == Property.getDefaultInstance())
        return this; 
      if (!param1Property.getName().isEmpty()) {
        this.name_ = param1Property.name_;
        onChanged();
      } 
      if (param1Property.type_ != 0)
        setTypeValue(param1Property.getTypeValue()); 
      if (!param1Property.getDescription().isEmpty()) {
        this.description_ = param1Property.description_;
        onChanged();
      } 
      mergeUnknownFields(param1Property.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Property property = (Property)Property.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Property property = (Property)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Property)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Property)
        return mergeFrom((Property)param1Message); 
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
        Property.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
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
        Property.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setType(Property.PropertyType param1PropertyType) {
      if (param1PropertyType != null) {
        this.type_ = param1PropertyType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeValue(int param1Int) {
      this.type_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public enum PropertyType implements ProtocolMessageEnum {
    BOOL,
    DOUBLE,
    INT64,
    STRING,
    UNRECOGNIZED,
    UNSPECIFIED(0);
    
    public static final int BOOL_VALUE = 2;
    
    public static final int DOUBLE_VALUE = 4;
    
    public static final int INT64_VALUE = 1;
    
    public static final int STRING_VALUE = 3;
    
    public static final int UNSPECIFIED_VALUE = 0;
    
    private static final PropertyType[] VALUES;
    
    private static final Internal.EnumLiteMap<PropertyType> internalValueMap;
    
    private final int value;
    
    static {
      BOOL = new PropertyType("BOOL", 2, 2);
      STRING = new PropertyType("STRING", 3, 3);
      DOUBLE = new PropertyType("DOUBLE", 4, 4);
      UNRECOGNIZED = new PropertyType("UNRECOGNIZED", 5, -1);
      $VALUES = new PropertyType[] { UNSPECIFIED, INT64, BOOL, STRING, DOUBLE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PropertyType>() {
          public Property.PropertyType a(int param2Int) {
            return Property.PropertyType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PropertyType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PropertyType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : DOUBLE) : STRING) : BOOL) : INT64) : UNSPECIFIED;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return Property.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<PropertyType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PropertyType> {
    public Property.PropertyType a(int param1Int) {
      return Property.PropertyType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
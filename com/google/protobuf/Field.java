package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Field extends GeneratedMessageV3 implements FieldOrBuilder {
  public static final int CARDINALITY_FIELD_NUMBER = 2;
  
  private static final Field DEFAULT_INSTANCE = new Field();
  
  public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
  
  public static final int JSON_NAME_FIELD_NUMBER = 10;
  
  public static final int KIND_FIELD_NUMBER = 1;
  
  public static final int NAME_FIELD_NUMBER = 4;
  
  public static final int NUMBER_FIELD_NUMBER = 3;
  
  public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
  
  public static final int OPTIONS_FIELD_NUMBER = 9;
  
  public static final int PACKED_FIELD_NUMBER = 8;
  
  private static final Parser<Field> PARSER = new AbstractParser<Field>() {
      public Field parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Field(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_URL_FIELD_NUMBER = 6;
  
  private static final long serialVersionUID = 0L;
  
  private int cardinality_;
  
  private volatile Object defaultValue_;
  
  private volatile Object jsonName_;
  
  private int kind_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private int number_;
  
  private int oneofIndex_;
  
  private List<Option> options_;
  
  private boolean packed_;
  
  private volatile Object typeUrl_;
  
  private Field() {
    this.kind_ = 0;
    this.cardinality_ = 0;
    this.name_ = "";
    this.typeUrl_ = "";
    this.options_ = Collections.emptyList();
    this.jsonName_ = "";
    this.defaultValue_ = "";
  }
  
  private Field(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
          switch (n) {
            case 90:
              j = i;
              k = i;
              m = i;
              this.defaultValue_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 82:
              j = i;
              k = i;
              m = i;
              this.jsonName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 74:
              n = i;
              if ((i & 0x1) == 0) {
                j = i;
                k = i;
                m = i;
                this.options_ = new ArrayList<Option>();
                n = i | 0x1;
              } 
              j = n;
              k = n;
              m = n;
              this.options_.add(paramCodedInputStream.readMessage(Option.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 64:
              j = i;
              k = i;
              m = i;
              this.packed_ = paramCodedInputStream.readBool();
              continue;
            case 56:
              j = i;
              k = i;
              m = i;
              this.oneofIndex_ = paramCodedInputStream.readInt32();
              continue;
            case 50:
              j = i;
              k = i;
              m = i;
              this.typeUrl_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 34:
              j = i;
              k = i;
              m = i;
              this.name_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 24:
              j = i;
              k = i;
              m = i;
              this.number_ = paramCodedInputStream.readInt32();
              continue;
            case 16:
              j = i;
              k = i;
              m = i;
              this.cardinality_ = paramCodedInputStream.readEnum();
              continue;
            case 8:
              j = i;
              k = i;
              m = i;
              this.kind_ = paramCodedInputStream.readEnum();
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
        if ((j & 0x1) != 0)
          this.options_ = Collections.unmodifiableList(this.options_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      if ((i & 0x1) != 0)
        this.options_ = Collections.unmodifiableList(this.options_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Field(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Field getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return TypeProto.internal_static_google_protobuf_Field_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Field paramField) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramField);
  }
  
  public static Field parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Field>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Field parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Field>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static Field parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<Field>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Field parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Field>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Field>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Field parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Field>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Field parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Field parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Field> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Field))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (this.kind_ != ((Field)paramObject).kind_) ? false : ((this.cardinality_ != ((Field)paramObject).cardinality_) ? false : ((getNumber() != paramObject.getNumber()) ? false : (!getName().equals(paramObject.getName()) ? false : (!getTypeUrl().equals(paramObject.getTypeUrl()) ? false : ((getOneofIndex() != paramObject.getOneofIndex()) ? false : ((getPacked() != paramObject.getPacked()) ? false : (!getOptionsList().equals(paramObject.getOptionsList()) ? false : (!getJsonName().equals(paramObject.getJsonName()) ? false : (!getDefaultValue().equals(paramObject.getDefaultValue()) ? false : (!!this.unknownFields.equals(((Field)paramObject).unknownFields)))))))))));
  }
  
  public Cardinality getCardinality() {
    Cardinality cardinality2 = Cardinality.valueOf(this.cardinality_);
    Cardinality cardinality1 = cardinality2;
    if (cardinality2 == null)
      cardinality1 = Cardinality.UNRECOGNIZED; 
    return cardinality1;
  }
  
  public int getCardinalityValue() {
    return this.cardinality_;
  }
  
  public Field getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getDefaultValue() {
    Object object = this.defaultValue_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.defaultValue_ = object;
    return (String)object;
  }
  
  public ByteString getDefaultValueBytes() {
    Object object = this.defaultValue_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.defaultValue_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getJsonName() {
    Object object = this.jsonName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.jsonName_ = object;
    return (String)object;
  }
  
  public ByteString getJsonNameBytes() {
    Object object = this.jsonName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.jsonName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Kind getKind() {
    Kind kind2 = Kind.valueOf(this.kind_);
    Kind kind1 = kind2;
    if (kind2 == null)
      kind1 = Kind.UNRECOGNIZED; 
    return kind1;
  }
  
  public int getKindValue() {
    return this.kind_;
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
  
  public int getNumber() {
    return this.number_;
  }
  
  public int getOneofIndex() {
    return this.oneofIndex_;
  }
  
  public Option getOptions(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public int getOptionsCount() {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList() {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
    return (List)this.options_;
  }
  
  public boolean getPacked() {
    return this.packed_;
  }
  
  public Parser<Field> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = this.kind_;
    int j = Kind.TYPE_UNKNOWN.getNumber();
    boolean bool = false;
    if (i != j) {
      j = CodedOutputStream.computeEnumSize(1, this.kind_) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber())
      i = j + CodedOutputStream.computeEnumSize(2, this.cardinality_); 
    int k = this.number_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    k = j;
    if (!getNameBytes().isEmpty())
      k = j + GeneratedMessageV3.computeStringSize(4, this.name_); 
    i = k;
    if (!getTypeUrlBytes().isEmpty())
      i = k + GeneratedMessageV3.computeStringSize(6, this.typeUrl_); 
    k = this.oneofIndex_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(7, k); 
    boolean bool1 = this.packed_;
    i = j;
    k = bool;
    if (bool1) {
      i = j + CodedOutputStream.computeBoolSize(8, bool1);
      k = bool;
    } 
    while (k < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(9, this.options_.get(k));
      k++;
    } 
    j = i;
    if (!getJsonNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(10, this.jsonName_); 
    i = j;
    if (!getDefaultValueBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(11, this.defaultValue_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getTypeUrl() {
    Object object = this.typeUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.typeUrl_ = object;
    return (String)object;
  }
  
  public ByteString getTypeUrlBytes() {
    Object object = this.typeUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.typeUrl_ = object;
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
    int j = ((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.kind_) * 37 + 2) * 53 + this.cardinality_) * 37 + 3) * 53 + getNumber()) * 37 + 4) * 53 + getName().hashCode()) * 37 + 6) * 53 + getTypeUrl().hashCode()) * 37 + 7) * 53 + getOneofIndex()) * 37 + 8) * 53 + Internal.hashBoolean(getPacked());
    int i = j;
    if (getOptionsCount() > 0)
      i = (j * 37 + 9) * 53 + getOptionsList().hashCode(); 
    i = ((((i * 37 + 10) * 53 + getJsonName().hashCode()) * 37 + 11) * 53 + getDefaultValue().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Field.class, (Class)Builder.class);
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
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter) {
    return new Field();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber())
      paramCodedOutputStream.writeEnum(1, this.kind_); 
    if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber())
      paramCodedOutputStream.writeEnum(2, this.cardinality_); 
    int i = this.number_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.name_); 
    if (!getTypeUrlBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.typeUrl_); 
    i = this.oneofIndex_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(7, i); 
    boolean bool = this.packed_;
    if (bool)
      paramCodedOutputStream.writeBool(8, bool); 
    for (i = 0; i < this.options_.size(); i++)
      paramCodedOutputStream.writeMessage(9, this.options_.get(i)); 
    if (!getJsonNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.jsonName_); 
    if (!getDefaultValueBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 11, this.defaultValue_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldOrBuilder {
    private int bitField0_;
    
    private int cardinality_ = 0;
    
    private Object defaultValue_ = "";
    
    private Object jsonName_ = "";
    
    private int kind_ = 0;
    
    private Object name_ = "";
    
    private int number_;
    
    private int oneofIndex_;
    
    private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
    
    private List<Option> options_ = Collections.emptyList();
    
    private boolean packed_;
    
    private Object typeUrl_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureOptionsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.options_ = new ArrayList<Option>(this.options_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }
    
    private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
      if (this.optionsBuilder_ == null) {
        List<Option> list = this.options_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.optionsBuilder_ = new RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder>(list, bool, getParentForChildren(), isClean());
        this.options_ = null;
      } 
      return this.optionsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (GeneratedMessageV3.alwaysUseFieldBuilders)
        getOptionsFieldBuilder(); 
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOptionsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.options_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option.Builder param1Builder) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOptionsIsMutable();
        this.options_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, param1Builder.build());
      return this;
    }
    
    public Builder addOptions(int param1Int, Option param1Option) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Option != null) {
          ensureOptionsIsMutable();
          this.options_.add(param1Int, param1Option);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, param1Option);
      return this;
    }
    
    public Builder addOptions(Option.Builder param1Builder) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOptionsIsMutable();
        this.options_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Builder.build());
      return this;
    }
    
    public Builder addOptions(Option param1Option) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Option != null) {
          ensureOptionsIsMutable();
          this.options_.add(param1Option);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Option);
      return this;
    }
    
    public Option.Builder addOptionsBuilder() {
      return getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
    }
    
    public Option.Builder addOptionsBuilder(int param1Int) {
      return getOptionsFieldBuilder().addBuilder(param1Int, Option.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Field build() {
      Field field = buildPartial();
      if (field.isInitialized())
        return field; 
      throw newUninitializedMessageException(field);
    }
    
    public Field buildPartial() {
      Field field = new Field(this);
      int i = this.bitField0_;
      Field.access$302(field, this.kind_);
      Field.access$402(field, this.cardinality_);
      Field.access$502(field, this.number_);
      Field.access$602(field, this.name_);
      Field.access$702(field, this.typeUrl_);
      Field.access$802(field, this.oneofIndex_);
      Field.access$902(field, this.packed_);
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.options_ = Collections.unmodifiableList(this.options_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Field.access$1002(field, this.options_);
      } else {
        Field.access$1002(field, repeatedFieldBuilderV3.build());
      } 
      Field.access$1102(field, this.jsonName_);
      Field.access$1202(field, this.defaultValue_);
      onBuilt();
      return field;
    }
    
    public Builder clear() {
      super.clear();
      this.kind_ = 0;
      this.cardinality_ = 0;
      this.number_ = 0;
      this.name_ = "";
      this.typeUrl_ = "";
      this.oneofIndex_ = 0;
      this.packed_ = false;
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.options_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.jsonName_ = "";
      this.defaultValue_ = "";
      return this;
    }
    
    public Builder clearCardinality() {
      this.cardinality_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearDefaultValue() {
      this.defaultValue_ = Field.getDefaultInstance().getDefaultValue();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearJsonName() {
      this.jsonName_ = Field.getDefaultInstance().getJsonName();
      onChanged();
      return this;
    }
    
    public Builder clearKind() {
      this.kind_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = Field.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearNumber() {
      this.number_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOneofIndex() {
      this.oneofIndex_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOptions() {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.options_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearPacked() {
      this.packed_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearTypeUrl() {
      this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return super.clone();
    }
    
    public Field.Cardinality getCardinality() {
      Field.Cardinality cardinality2 = Field.Cardinality.valueOf(this.cardinality_);
      Field.Cardinality cardinality1 = cardinality2;
      if (cardinality2 == null)
        cardinality1 = Field.Cardinality.UNRECOGNIZED; 
      return cardinality1;
    }
    
    public int getCardinalityValue() {
      return this.cardinality_;
    }
    
    public Field getDefaultInstanceForType() {
      return Field.getDefaultInstance();
    }
    
    public String getDefaultValue() {
      Object object = this.defaultValue_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.defaultValue_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDefaultValueBytes() {
      Object object = this.defaultValue_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.defaultValue_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }
    
    public String getJsonName() {
      Object object = this.jsonName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.jsonName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getJsonNameBytes() {
      Object object = this.jsonName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.jsonName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Field.Kind getKind() {
      Field.Kind kind2 = Field.Kind.valueOf(this.kind_);
      Field.Kind kind1 = kind2;
      if (kind2 == null)
        kind1 = Field.Kind.UNRECOGNIZED; 
      return kind1;
    }
    
    public int getKindValue() {
      return this.kind_;
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
    
    public int getNumber() {
      return this.number_;
    }
    
    public int getOneofIndex() {
      return this.oneofIndex_;
    }
    
    public Option getOptions(int param1Int) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.options_.get(param1Int) : repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Option.Builder getOptionsBuilder(int param1Int) {
      return getOptionsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Option.Builder> getOptionsBuilderList() {
      return getOptionsFieldBuilder().getBuilderList();
    }
    
    public int getOptionsCount() {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.options_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Option> getOptionsList() {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.options_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public OptionOrBuilder getOptionsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.options_.get(param1Int) : repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.options_);
    }
    
    public boolean getPacked() {
      return this.packed_;
    }
    
    public String getTypeUrl() {
      Object object = this.typeUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.typeUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTypeUrlBytes() {
      Object object = this.typeUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.typeUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Field.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Field field = Field.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Field field = (Field)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Field)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Field param1Field) {
      if (param1Field == Field.getDefaultInstance())
        return this; 
      if (param1Field.kind_ != 0)
        setKindValue(param1Field.getKindValue()); 
      if (param1Field.cardinality_ != 0)
        setCardinalityValue(param1Field.getCardinalityValue()); 
      if (param1Field.getNumber() != 0)
        setNumber(param1Field.getNumber()); 
      if (!param1Field.getName().isEmpty()) {
        this.name_ = param1Field.name_;
        onChanged();
      } 
      if (!param1Field.getTypeUrl().isEmpty()) {
        this.typeUrl_ = param1Field.typeUrl_;
        onChanged();
      } 
      if (param1Field.getOneofIndex() != 0)
        setOneofIndex(param1Field.getOneofIndex()); 
      if (param1Field.getPacked())
        setPacked(param1Field.getPacked()); 
      if (this.optionsBuilder_ == null) {
        if (!param1Field.options_.isEmpty()) {
          if (this.options_.isEmpty()) {
            this.options_ = param1Field.options_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureOptionsIsMutable();
            this.options_.addAll(param1Field.options_);
          } 
          onChanged();
        } 
      } else if (!param1Field.options_.isEmpty()) {
        if (this.optionsBuilder_.isEmpty()) {
          this.optionsBuilder_.dispose();
          RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = null;
          this.optionsBuilder_ = null;
          this.options_ = param1Field.options_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (GeneratedMessageV3.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getOptionsFieldBuilder(); 
          this.optionsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.optionsBuilder_.addAllMessages(param1Field.options_);
        } 
      } 
      if (!param1Field.getJsonName().isEmpty()) {
        this.jsonName_ = param1Field.jsonName_;
        onChanged();
      } 
      if (!param1Field.getDefaultValue().isEmpty()) {
        this.defaultValue_ = param1Field.defaultValue_;
        onChanged();
      } 
      mergeUnknownFields(param1Field.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Field)
        return mergeFrom((Field)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeOptions(int param1Int) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOptionsIsMutable();
        this.options_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setCardinality(Field.Cardinality param1Cardinality) {
      if (param1Cardinality != null) {
        this.cardinality_ = param1Cardinality.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCardinalityValue(int param1Int) {
      this.cardinality_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setDefaultValue(String param1String) {
      if (param1String != null) {
        this.defaultValue_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDefaultValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.defaultValue_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setJsonName(String param1String) {
      if (param1String != null) {
        this.jsonName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setJsonNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.jsonName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setKind(Field.Kind param1Kind) {
      if (param1Kind != null) {
        this.kind_ = param1Kind.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setKindValue(int param1Int) {
      this.kind_ = param1Int;
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
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNumber(int param1Int) {
      this.number_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOneofIndex(int param1Int) {
      this.oneofIndex_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOptions(int param1Int, Option.Builder param1Builder) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOptionsIsMutable();
        this.options_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, param1Builder.build());
      return this;
    }
    
    public Builder setOptions(int param1Int, Option param1Option) {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Option != null) {
          ensureOptionsIsMutable();
          this.options_.set(param1Int, param1Option);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, param1Option);
      return this;
    }
    
    public Builder setPacked(boolean param1Boolean) {
      this.packed_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTypeUrl(String param1String) {
      if (param1String != null) {
        this.typeUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.typeUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public enum Cardinality implements ProtocolMessageEnum {
    CARDINALITY_OPTIONAL,
    CARDINALITY_REPEATED,
    CARDINALITY_REQUIRED,
    CARDINALITY_UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    
    private static final Cardinality[] VALUES;
    
    private static final Internal.EnumLiteMap<Cardinality> internalValueMap;
    
    private final int value;
    
    static {
      CARDINALITY_REPEATED = new Cardinality("CARDINALITY_REPEATED", 3, 3);
      UNRECOGNIZED = new Cardinality("UNRECOGNIZED", 4, -1);
      $VALUES = new Cardinality[] { CARDINALITY_UNKNOWN, CARDINALITY_OPTIONAL, CARDINALITY_REQUIRED, CARDINALITY_REPEATED, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Cardinality>() {
          public Field.Cardinality findValueByNumber(int param2Int) {
            return Field.Cardinality.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Cardinality(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Cardinality forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : CARDINALITY_REPEATED) : CARDINALITY_REQUIRED) : CARDINALITY_OPTIONAL) : CARDINALITY_UNKNOWN;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return Field.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
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
      if (this != UNRECOGNIZED)
        return getDescriptor().getValues().get(ordinal()); 
      throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
  }
  
  static final class null implements Internal.EnumLiteMap<Cardinality> {
    public Field.Cardinality findValueByNumber(int param1Int) {
      return Field.Cardinality.forNumber(param1Int);
    }
  }
  
  public enum Kind implements ProtocolMessageEnum {
    TYPE_BOOL(0),
    TYPE_BYTES(0),
    TYPE_DOUBLE(0),
    TYPE_ENUM(0),
    TYPE_FIXED32(0),
    TYPE_FIXED64(0),
    TYPE_FLOAT(0),
    TYPE_GROUP(0),
    TYPE_INT32(0),
    TYPE_INT64(0),
    TYPE_MESSAGE(0),
    TYPE_SFIXED32(0),
    TYPE_SFIXED64(0),
    TYPE_SINT32(0),
    TYPE_SINT64(0),
    TYPE_STRING(0),
    TYPE_UINT32(0),
    TYPE_UINT64(0),
    TYPE_UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int TYPE_BOOL_VALUE = 8;
    
    public static final int TYPE_BYTES_VALUE = 12;
    
    public static final int TYPE_DOUBLE_VALUE = 1;
    
    public static final int TYPE_ENUM_VALUE = 14;
    
    public static final int TYPE_FIXED32_VALUE = 7;
    
    public static final int TYPE_FIXED64_VALUE = 6;
    
    public static final int TYPE_FLOAT_VALUE = 2;
    
    public static final int TYPE_GROUP_VALUE = 10;
    
    public static final int TYPE_INT32_VALUE = 5;
    
    public static final int TYPE_INT64_VALUE = 3;
    
    public static final int TYPE_MESSAGE_VALUE = 11;
    
    public static final int TYPE_SFIXED32_VALUE = 15;
    
    public static final int TYPE_SFIXED64_VALUE = 16;
    
    public static final int TYPE_SINT32_VALUE = 17;
    
    public static final int TYPE_SINT64_VALUE = 18;
    
    public static final int TYPE_STRING_VALUE = 9;
    
    public static final int TYPE_UINT32_VALUE = 13;
    
    public static final int TYPE_UINT64_VALUE = 4;
    
    public static final int TYPE_UNKNOWN_VALUE = 0;
    
    private static final Kind[] VALUES;
    
    private static final Internal.EnumLiteMap<Kind> internalValueMap;
    
    private final int value;
    
    static {
      TYPE_INT32 = new Kind("TYPE_INT32", 5, 5);
      TYPE_FIXED64 = new Kind("TYPE_FIXED64", 6, 6);
      TYPE_FIXED32 = new Kind("TYPE_FIXED32", 7, 7);
      TYPE_BOOL = new Kind("TYPE_BOOL", 8, 8);
      TYPE_STRING = new Kind("TYPE_STRING", 9, 9);
      TYPE_GROUP = new Kind("TYPE_GROUP", 10, 10);
      TYPE_MESSAGE = new Kind("TYPE_MESSAGE", 11, 11);
      TYPE_BYTES = new Kind("TYPE_BYTES", 12, 12);
      TYPE_UINT32 = new Kind("TYPE_UINT32", 13, 13);
      TYPE_ENUM = new Kind("TYPE_ENUM", 14, 14);
      TYPE_SFIXED32 = new Kind("TYPE_SFIXED32", 15, 15);
      TYPE_SFIXED64 = new Kind("TYPE_SFIXED64", 16, 16);
      TYPE_SINT32 = new Kind("TYPE_SINT32", 17, 17);
      TYPE_SINT64 = new Kind("TYPE_SINT64", 18, 18);
      UNRECOGNIZED = new Kind("UNRECOGNIZED", 19, -1);
      $VALUES = new Kind[] { 
          TYPE_UNKNOWN, TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, 
          TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Kind>() {
          public Field.Kind findValueByNumber(int param2Int) {
            return Field.Kind.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Kind(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Kind forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 18:
          return TYPE_SINT64;
        case 17:
          return TYPE_SINT32;
        case 16:
          return TYPE_SFIXED64;
        case 15:
          return TYPE_SFIXED32;
        case 14:
          return TYPE_ENUM;
        case 13:
          return TYPE_UINT32;
        case 12:
          return TYPE_BYTES;
        case 11:
          return TYPE_MESSAGE;
        case 10:
          return TYPE_GROUP;
        case 9:
          return TYPE_STRING;
        case 8:
          return TYPE_BOOL;
        case 7:
          return TYPE_FIXED32;
        case 6:
          return TYPE_FIXED64;
        case 5:
          return TYPE_INT32;
        case 4:
          return TYPE_UINT64;
        case 3:
          return TYPE_INT64;
        case 2:
          return TYPE_FLOAT;
        case 1:
          return TYPE_DOUBLE;
        case 0:
          break;
      } 
      return TYPE_UNKNOWN;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return Field.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
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
      if (this != UNRECOGNIZED)
        return getDescriptor().getValues().get(ordinal()); 
      throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
  }
  
  static final class null implements Internal.EnumLiteMap<Kind> {
    public Field.Kind findValueByNumber(int param1Int) {
      return Field.Kind.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
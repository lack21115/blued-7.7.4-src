package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessageV3 implements EnumValueOrBuilder {
  private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int NUMBER_FIELD_NUMBER = 2;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static final Parser<EnumValue> PARSER = new AbstractParser<EnumValue>() {
      public EnumValue parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new EnumValue(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private int number_;
  
  private List<Option> options_;
  
  private EnumValue() {
    this.name_ = "";
    this.options_ = Collections.emptyList();
  }
  
  private EnumValue(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              if (n != 16) {
                if (n != 26) {
                  j = i;
                  k = i;
                  m = i;
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                    continue; 
                  continue;
                } 
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
              } 
              j = i;
              k = i;
              m = i;
              this.number_ = paramCodedInputStream.readInt32();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.name_ = paramCodedInputStream.readStringRequireUtf8();
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
          this.options_ = Collections.unmodifiableList(this.options_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.options_ = Collections.unmodifiableList(this.options_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private EnumValue(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static EnumValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(EnumValue paramEnumValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEnumValue);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<EnumValue>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<EnumValue>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<EnumValue>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<EnumValue>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<EnumValue>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<EnumValue>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static EnumValue parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValue> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof EnumValue))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : ((getNumber() != paramObject.getNumber()) ? false : (!getOptionsList().equals(paramObject.getOptionsList()) ? false : (!!this.unknownFields.equals(((EnumValue)paramObject).unknownFields))));
  }
  
  public EnumValue getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
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
  
  public Parser<EnumValue> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    byte b1;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getNameBytes().isEmpty();
    byte b2 = 0;
    if (!bool) {
      b1 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      b1 = 0;
    } 
    int k = this.number_;
    i = b1;
    int j = b2;
    if (k != 0) {
      i = b1 + CodedOutputStream.computeInt32Size(2, k);
      j = b2;
    } 
    while (j < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(j));
      j++;
    } 
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
    int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getNumber();
    int i = j;
    if (getOptionsCount() > 0)
      i = (j * 37 + 3) * 53 + getOptionsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)EnumValue.class, (Class)Builder.class);
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
    return new EnumValue();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    int i = this.number_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    for (i = 0; i < this.options_.size(); i++)
      paramCodedOutputStream.writeMessage(3, this.options_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumValueOrBuilder {
    private int bitField0_;
    
    private Object name_ = "";
    
    private int number_;
    
    private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
    
    private List<Option> options_ = Collections.emptyList();
    
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
      return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
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
    
    public EnumValue build() {
      EnumValue enumValue = buildPartial();
      if (enumValue.isInitialized())
        return enumValue; 
      throw newUninitializedMessageException(enumValue);
    }
    
    public EnumValue buildPartial() {
      EnumValue enumValue = new EnumValue(this);
      int i = this.bitField0_;
      EnumValue.access$302(enumValue, this.name_);
      EnumValue.access$402(enumValue, this.number_);
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.options_ = Collections.unmodifiableList(this.options_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        EnumValue.access$502(enumValue, this.options_);
      } else {
        EnumValue.access$502(enumValue, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return enumValue;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.number_ = 0;
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.options_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = EnumValue.getDefaultInstance().getName();
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
    
    public Builder clone() {
      return super.clone();
    }
    
    public EnumValue getDefaultInstanceForType() {
      return EnumValue.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
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
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)EnumValue.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        EnumValue enumValue = EnumValue.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        EnumValue enumValue = (EnumValue)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((EnumValue)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(EnumValue param1EnumValue) {
      if (param1EnumValue == EnumValue.getDefaultInstance())
        return this; 
      if (!param1EnumValue.getName().isEmpty()) {
        this.name_ = param1EnumValue.name_;
        onChanged();
      } 
      if (param1EnumValue.getNumber() != 0)
        setNumber(param1EnumValue.getNumber()); 
      if (this.optionsBuilder_ == null) {
        if (!param1EnumValue.options_.isEmpty()) {
          if (this.options_.isEmpty()) {
            this.options_ = param1EnumValue.options_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureOptionsIsMutable();
            this.options_.addAll(param1EnumValue.options_);
          } 
          onChanged();
        } 
      } else if (!param1EnumValue.options_.isEmpty()) {
        if (this.optionsBuilder_.isEmpty()) {
          this.optionsBuilder_.dispose();
          RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = null;
          this.optionsBuilder_ = null;
          this.options_ = param1EnumValue.options_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (GeneratedMessageV3.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getOptionsFieldBuilder(); 
          this.optionsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.optionsBuilder_.addAllMessages(param1EnumValue.options_);
        } 
      } 
      mergeUnknownFields(param1EnumValue.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof EnumValue)
        return mergeFrom((EnumValue)param1Message); 
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
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.setField(param1FieldDescriptor, param1Object);
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
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\EnumValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessageV3 implements TypeOrBuilder {
  private static final Type DEFAULT_INSTANCE = new Type();
  
  public static final int FIELDS_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int ONEOFS_FIELD_NUMBER = 3;
  
  public static final int OPTIONS_FIELD_NUMBER = 4;
  
  private static final Parser<Type> PARSER = new AbstractParser<Type>() {
      public Type parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Type(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  
  public static final int SYNTAX_FIELD_NUMBER = 6;
  
  private static final long serialVersionUID = 0L;
  
  private List<Field> fields_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private LazyStringList oneofs_;
  
  private List<Option> options_;
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  private Type() {
    this.name_ = "";
    this.fields_ = Collections.emptyList();
    this.oneofs_ = LazyStringArrayList.EMPTY;
    this.options_ = Collections.emptyList();
    this.syntax_ = 0;
  }
  
  private Type(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              if (n != 18) {
                if (n != 26) {
                  if (n != 34) {
                    if (n != 42) {
                      if (n != 48) {
                        j = i;
                        k = i;
                        m = i;
                        if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                          continue; 
                        continue;
                      } 
                      j = i;
                      k = i;
                      m = i;
                      this.syntax_ = paramCodedInputStream.readEnum();
                      continue;
                    } 
                    SourceContext.Builder builder1 = null;
                    j = i;
                    k = i;
                    m = i;
                    if (this.sourceContext_ != null) {
                      j = i;
                      k = i;
                      m = i;
                      builder1 = this.sourceContext_.toBuilder();
                    } 
                    j = i;
                    k = i;
                    m = i;
                    this.sourceContext_ = paramCodedInputStream.<SourceContext>readMessage(SourceContext.parser(), paramExtensionRegistryLite);
                    if (builder1 != null) {
                      j = i;
                      k = i;
                      m = i;
                      builder1.mergeFrom(this.sourceContext_);
                      j = i;
                      k = i;
                      m = i;
                      this.sourceContext_ = builder1.buildPartial();
                    } 
                    continue;
                  } 
                  n = i;
                  if ((i & 0x4) == 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.options_ = new ArrayList<Option>();
                    n = i | 0x4;
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
                String str = paramCodedInputStream.readStringRequireUtf8();
                n = i;
                if ((i & 0x2) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.oneofs_ = new LazyStringArrayList();
                  n = i | 0x2;
                } 
                j = n;
                k = n;
                m = n;
                this.oneofs_.add(str);
                i = n;
                continue;
              } 
              n = i;
              if ((i & 0x1) == 0) {
                j = i;
                k = i;
                m = i;
                this.fields_ = new ArrayList<Field>();
                n = i | 0x1;
              } 
              j = n;
              k = n;
              m = n;
              this.fields_.add(paramCodedInputStream.readMessage(Field.parser(), paramExtensionRegistryLite));
              i = n;
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
          this.fields_ = Collections.unmodifiableList(this.fields_); 
        if ((j & 0x2) != 0)
          this.oneofs_ = this.oneofs_.getUnmodifiableView(); 
        if ((j & 0x4) != 0)
          this.options_ = Collections.unmodifiableList(this.options_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.fields_ = Collections.unmodifiableList(this.fields_); 
      if ((i & 0x2) != 0)
        this.oneofs_ = this.oneofs_.getUnmodifiableView(); 
      if ((i & 0x4) != 0)
        this.options_ = Collections.unmodifiableList(this.options_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Type(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Type getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return TypeProto.internal_static_google_protobuf_Type_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Type paramType) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramType);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Type>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Type>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static Type parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<Type>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Type>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Type>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Type parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Type>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Type parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Type parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Type> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Type))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getFieldsList().equals(paramObject.getFieldsList()) ? false : (!getOneofsList().equals(paramObject.getOneofsList()) ? false : (!getOptionsList().equals(paramObject.getOptionsList()) ? false : ((hasSourceContext() != paramObject.hasSourceContext()) ? false : ((hasSourceContext() && !getSourceContext().equals(paramObject.getSourceContext())) ? false : ((this.syntax_ != ((Type)paramObject).syntax_) ? false : (!!this.unknownFields.equals(((Type)paramObject).unknownFields))))))));
  }
  
  public Type getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Field getFields(int paramInt) {
    return this.fields_.get(paramInt);
  }
  
  public int getFieldsCount() {
    return this.fields_.size();
  }
  
  public List<Field> getFieldsList() {
    return this.fields_;
  }
  
  public FieldOrBuilder getFieldsOrBuilder(int paramInt) {
    return this.fields_.get(paramInt);
  }
  
  public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
    return (List)this.fields_;
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
  
  public String getOneofs(int paramInt) {
    return this.oneofs_.get(paramInt);
  }
  
  public ByteString getOneofsBytes(int paramInt) {
    return this.oneofs_.getByteString(paramInt);
  }
  
  public int getOneofsCount() {
    return this.oneofs_.size();
  }
  
  public ProtocolStringList getOneofsList() {
    return this.oneofs_;
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
  
  public Parser<Type> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool1 = getNameBytes().isEmpty();
    boolean bool = false;
    if (!bool1) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    } 
    int j;
    for (j = 0; j < this.fields_.size(); j++)
      i += CodedOutputStream.computeMessageSize(2, this.fields_.get(j)); 
    j = 0;
    int k = 0;
    while (j < this.oneofs_.size()) {
      k += computeStringSizeNoTag(this.oneofs_.getRaw(j));
      j++;
    } 
    i = i + k + getOneofsList().size() * 1;
    for (j = bool; j < this.options_.size(); j++)
      i += CodedOutputStream.computeMessageSize(4, this.options_.get(j)); 
    j = i;
    if (this.sourceContext_ != null)
      j = i + CodedOutputStream.computeMessageSize(5, getSourceContext()); 
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      i = j + CodedOutputStream.computeEnumSize(6, this.syntax_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public SourceContext getSourceContext() {
    SourceContext sourceContext2 = this.sourceContext_;
    SourceContext sourceContext1 = sourceContext2;
    if (sourceContext2 == null)
      sourceContext1 = SourceContext.getDefaultInstance(); 
    return sourceContext1;
  }
  
  public SourceContextOrBuilder getSourceContextOrBuilder() {
    return getSourceContext();
  }
  
  public Syntax getSyntax() {
    Syntax syntax2 = Syntax.valueOf(this.syntax_);
    Syntax syntax1 = syntax2;
    if (syntax2 == null)
      syntax1 = Syntax.UNRECOGNIZED; 
    return syntax1;
  }
  
  public int getSyntaxValue() {
    return this.syntax_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasSourceContext() {
    return (this.sourceContext_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (getFieldsCount() > 0)
      i = (j * 37 + 2) * 53 + getFieldsList().hashCode(); 
    j = i;
    if (getOneofsCount() > 0)
      j = (i * 37 + 3) * 53 + getOneofsList().hashCode(); 
    i = j;
    if (getOptionsCount() > 0)
      i = (j * 37 + 4) * 53 + getOptionsList().hashCode(); 
    j = i;
    if (hasSourceContext())
      j = (i * 37 + 5) * 53 + getSourceContext().hashCode(); 
    i = ((j * 37 + 6) * 53 + this.syntax_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Type.class, (Class)Builder.class);
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
    return new Type();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int j;
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    byte b = 0;
    int i;
    for (i = 0; i < this.fields_.size(); i++)
      paramCodedOutputStream.writeMessage(2, this.fields_.get(i)); 
    i = 0;
    while (true) {
      j = b;
      if (i < this.oneofs_.size()) {
        GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.oneofs_.getRaw(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.options_.size()) {
      paramCodedOutputStream.writeMessage(4, this.options_.get(j));
      j++;
    } 
    if (this.sourceContext_ != null)
      paramCodedOutputStream.writeMessage(5, getSourceContext()); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(6, this.syntax_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TypeOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> fieldsBuilder_;
    
    private List<Field> fields_ = Collections.emptyList();
    
    private Object name_ = "";
    
    private LazyStringList oneofs_ = LazyStringArrayList.EMPTY;
    
    private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
    
    private List<Option> options_ = Collections.emptyList();
    
    private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
    
    private SourceContext sourceContext_;
    
    private int syntax_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureFieldsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.fields_ = new ArrayList<Field>(this.fields_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private void ensureOneofsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.oneofs_ = new LazyStringArrayList(this.oneofs_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    private void ensureOptionsIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.options_ = new ArrayList<Option>(this.options_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }
    
    private RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> getFieldsFieldBuilder() {
      if (this.fieldsBuilder_ == null) {
        List<Field> list = this.fields_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.fieldsBuilder_ = new RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder>(list, bool, getParentForChildren(), isClean());
        this.fields_ = null;
      } 
      return this.fieldsBuilder_;
    }
    
    private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
      if (this.optionsBuilder_ == null) {
        boolean bool;
        List<Option> list = this.options_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.optionsBuilder_ = new RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder>(list, bool, getParentForChildren(), isClean());
        this.options_ = null;
      } 
      return this.optionsBuilder_;
    }
    
    private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> getSourceContextFieldBuilder() {
      if (this.sourceContextBuilder_ == null) {
        this.sourceContextBuilder_ = new SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder>(getSourceContext(), getParentForChildren(), isClean());
        this.sourceContext_ = null;
      } 
      return this.sourceContextBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (GeneratedMessageV3.alwaysUseFieldBuilders) {
        getFieldsFieldBuilder();
        getOptionsFieldBuilder();
      } 
    }
    
    public Builder addAllFields(Iterable<? extends Field> param1Iterable) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.fields_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllOneofs(Iterable<String> param1Iterable) {
      ensureOneofsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, this.oneofs_);
      onChanged();
      return this;
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
    
    public Builder addFields(int param1Int, Field.Builder param1Builder) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldsIsMutable();
        this.fields_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, param1Builder.build());
      return this;
    }
    
    public Builder addFields(int param1Int, Field param1Field) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Field != null) {
          ensureFieldsIsMutable();
          this.fields_.add(param1Int, param1Field);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, param1Field);
      return this;
    }
    
    public Builder addFields(Field.Builder param1Builder) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldsIsMutable();
        this.fields_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Builder.build());
      return this;
    }
    
    public Builder addFields(Field param1Field) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Field != null) {
          ensureFieldsIsMutable();
          this.fields_.add(param1Field);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Field);
      return this;
    }
    
    public Field.Builder addFieldsBuilder() {
      return getFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
    }
    
    public Field.Builder addFieldsBuilder(int param1Int) {
      return getFieldsFieldBuilder().addBuilder(param1Int, Field.getDefaultInstance());
    }
    
    public Builder addOneofs(String param1String) {
      if (param1String != null) {
        ensureOneofsIsMutable();
        this.oneofs_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addOneofsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        ensureOneofsIsMutable();
        this.oneofs_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
    
    public Type build() {
      Type type = buildPartial();
      if (type.isInitialized())
        return type; 
      throw newUninitializedMessageException(type);
    }
    
    public Type buildPartial() {
      Type type = new Type(this);
      int i = this.bitField0_;
      Type.access$302(type, this.name_);
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV31 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.fields_ = Collections.unmodifiableList(this.fields_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Type.access$402(type, this.fields_);
      } else {
        Type.access$402(type, repeatedFieldBuilderV31.build());
      } 
      if ((this.bitField0_ & 0x2) != 0) {
        this.oneofs_ = this.oneofs_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      Type.access$502(type, this.oneofs_);
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.options_ = Collections.unmodifiableList(this.options_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        Type.access$602(type, this.options_);
      } else {
        Type.access$602(type, repeatedFieldBuilderV3.build());
      } 
      SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
      if (singleFieldBuilderV3 == null) {
        Type.access$702(type, this.sourceContext_);
      } else {
        Type.access$702(type, singleFieldBuilderV3.build());
      } 
      Type.access$802(type, this.syntax_);
      onBuilt();
      return type;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV31 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        this.fields_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV31.clear();
      } 
      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.options_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      if (this.sourceContextBuilder_ == null) {
        this.sourceContext_ = null;
      } else {
        this.sourceContext_ = null;
        this.sourceContextBuilder_ = null;
      } 
      this.syntax_ = 0;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFields() {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.fields_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = Type.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOneofs() {
      this.oneofs_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearOptions() {
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.options_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearSourceContext() {
      if (this.sourceContextBuilder_ == null) {
        this.sourceContext_ = null;
        onChanged();
        return this;
      } 
      this.sourceContext_ = null;
      this.sourceContextBuilder_ = null;
      return this;
    }
    
    public Builder clearSyntax() {
      this.syntax_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return super.clone();
    }
    
    public Type getDefaultInstanceForType() {
      return Type.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }
    
    public Field getFields(int param1Int) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.fields_.get(param1Int) : repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Field.Builder getFieldsBuilder(int param1Int) {
      return getFieldsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Field.Builder> getFieldsBuilderList() {
      return getFieldsFieldBuilder().getBuilderList();
    }
    
    public int getFieldsCount() {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.fields_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Field> getFieldsList() {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.fields_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public FieldOrBuilder getFieldsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.fields_.get(param1Int) : repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.fields_);
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
    
    public String getOneofs(int param1Int) {
      return this.oneofs_.get(param1Int);
    }
    
    public ByteString getOneofsBytes(int param1Int) {
      return this.oneofs_.getByteString(param1Int);
    }
    
    public int getOneofsCount() {
      return this.oneofs_.size();
    }
    
    public ProtocolStringList getOneofsList() {
      return this.oneofs_.getUnmodifiableView();
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
    
    public SourceContext getSourceContext() {
      SourceContext sourceContext;
      SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
      if (singleFieldBuilderV3 == null) {
        SourceContext sourceContext1 = this.sourceContext_;
        sourceContext = sourceContext1;
        if (sourceContext1 == null)
          sourceContext = SourceContext.getDefaultInstance(); 
        return sourceContext;
      } 
      return (SourceContext)sourceContext.getMessage();
    }
    
    public SourceContext.Builder getSourceContextBuilder() {
      onChanged();
      return getSourceContextFieldBuilder().getBuilder();
    }
    
    public SourceContextOrBuilder getSourceContextOrBuilder() {
      SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
      if (singleFieldBuilderV3 != null)
        return singleFieldBuilderV3.getMessageOrBuilder(); 
      SourceContext sourceContext2 = this.sourceContext_;
      SourceContext sourceContext1 = sourceContext2;
      if (sourceContext2 == null)
        sourceContext1 = SourceContext.getDefaultInstance(); 
      return sourceContext1;
    }
    
    public Syntax getSyntax() {
      Syntax syntax2 = Syntax.valueOf(this.syntax_);
      Syntax syntax1 = syntax2;
      if (syntax2 == null)
        syntax1 = Syntax.UNRECOGNIZED; 
      return syntax1;
    }
    
    public int getSyntaxValue() {
      return this.syntax_;
    }
    
    public boolean hasSourceContext() {
      return (this.sourceContextBuilder_ != null || this.sourceContext_ != null);
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Type.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Type type = Type.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Type type = (Type)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Type)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Type)
        return mergeFrom((Type)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Type param1Type) {
      if (param1Type == Type.getDefaultInstance())
        return this; 
      if (!param1Type.getName().isEmpty()) {
        this.name_ = param1Type.name_;
        onChanged();
      } 
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Type.fields_.isEmpty()) {
          if (this.fields_.isEmpty()) {
            this.fields_ = param1Type.fields_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureFieldsIsMutable();
            this.fields_.addAll(param1Type.fields_);
          } 
          onChanged();
        } 
      } else if (!param1Type.fields_.isEmpty()) {
        if (this.fieldsBuilder_.isEmpty()) {
          this.fieldsBuilder_.dispose();
          this.fieldsBuilder_ = null;
          this.fields_ = param1Type.fields_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (GeneratedMessageV3.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getFieldsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.fieldsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.fieldsBuilder_.addAllMessages(param1Type.fields_);
        } 
      } 
      if (!param1Type.oneofs_.isEmpty()) {
        if (this.oneofs_.isEmpty()) {
          this.oneofs_ = param1Type.oneofs_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureOneofsIsMutable();
          this.oneofs_.addAll(param1Type.oneofs_);
        } 
        onChanged();
      } 
      if (this.optionsBuilder_ == null) {
        if (!param1Type.options_.isEmpty()) {
          if (this.options_.isEmpty()) {
            this.options_ = param1Type.options_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureOptionsIsMutable();
            this.options_.addAll(param1Type.options_);
          } 
          onChanged();
        } 
      } else if (!param1Type.options_.isEmpty()) {
        if (this.optionsBuilder_.isEmpty()) {
          this.optionsBuilder_.dispose();
          this.optionsBuilder_ = null;
          this.options_ = param1Type.options_;
          this.bitField0_ &= 0xFFFFFFFB;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (GeneratedMessageV3.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getOptionsFieldBuilder(); 
          this.optionsBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.optionsBuilder_.addAllMessages(param1Type.options_);
        } 
      } 
      if (param1Type.hasSourceContext())
        mergeSourceContext(param1Type.getSourceContext()); 
      if (param1Type.syntax_ != 0)
        setSyntaxValue(param1Type.getSyntaxValue()); 
      mergeUnknownFields(param1Type.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeSourceContext(SourceContext param1SourceContext) {
      SourceContext sourceContext;
      SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
      if (singleFieldBuilderV3 == null) {
        sourceContext = this.sourceContext_;
        if (sourceContext != null) {
          this.sourceContext_ = SourceContext.newBuilder(sourceContext).mergeFrom(param1SourceContext).buildPartial();
        } else {
          this.sourceContext_ = param1SourceContext;
        } 
        onChanged();
        return this;
      } 
      sourceContext.mergeFrom(param1SourceContext);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeFields(int param1Int) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldsIsMutable();
        this.fields_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
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
    
    public Builder setFields(int param1Int, Field.Builder param1Builder) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldsIsMutable();
        this.fields_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, param1Builder.build());
      return this;
    }
    
    public Builder setFields(int param1Int, Field param1Field) {
      RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Field != null) {
          ensureFieldsIsMutable();
          this.fields_.set(param1Int, param1Field);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, param1Field);
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
    
    public Builder setOneofs(int param1Int, String param1String) {
      if (param1String != null) {
        ensureOneofsIsMutable();
        this.oneofs_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
    
    public Builder setSourceContext(SourceContext.Builder param1Builder) {
      SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.sourceContext_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage(param1Builder.build());
      return this;
    }
    
    public Builder setSourceContext(SourceContext param1SourceContext) {
      SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1SourceContext != null) {
          this.sourceContext_ = param1SourceContext;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage(param1SourceContext);
      return this;
    }
    
    public Builder setSyntax(Syntax param1Syntax) {
      if (param1Syntax != null) {
        this.syntax_ = param1Syntax.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSyntaxValue(int param1Int) {
      this.syntax_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
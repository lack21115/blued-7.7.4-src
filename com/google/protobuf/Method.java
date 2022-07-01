package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessageV3 implements MethodOrBuilder {
  private static final Method DEFAULT_INSTANCE = new Method();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 6;
  
  private static final Parser<Method> PARSER = new AbstractParser<Method>() {
      public Method parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Method(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
  
  public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
  
  public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
  
  public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
  
  public static final int SYNTAX_FIELD_NUMBER = 7;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private List<Option> options_;
  
  private boolean requestStreaming_;
  
  private volatile Object requestTypeUrl_;
  
  private boolean responseStreaming_;
  
  private volatile Object responseTypeUrl_;
  
  private int syntax_;
  
  private Method() {
    this.name_ = "";
    this.requestTypeUrl_ = "";
    this.responseTypeUrl_ = "";
    this.options_ = Collections.emptyList();
    this.syntax_ = 0;
  }
  
  private Method(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                if (n != 24) {
                  if (n != 34) {
                    if (n != 40) {
                      if (n != 50) {
                        if (n != 56) {
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
                    this.responseStreaming_ = paramCodedInputStream.readBool();
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.responseTypeUrl_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.requestStreaming_ = paramCodedInputStream.readBool();
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.requestTypeUrl_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private Method(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Method getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ApiProto.internal_static_google_protobuf_Method_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Method paramMethod) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMethod);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Method>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Method>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static Method parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<Method>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Method>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Method>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Method parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Method>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Method parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Method parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Method> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Method))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getRequestTypeUrl().equals(paramObject.getRequestTypeUrl()) ? false : ((getRequestStreaming() != paramObject.getRequestStreaming()) ? false : (!getResponseTypeUrl().equals(paramObject.getResponseTypeUrl()) ? false : ((getResponseStreaming() != paramObject.getResponseStreaming()) ? false : (!getOptionsList().equals(paramObject.getOptionsList()) ? false : ((this.syntax_ != ((Method)paramObject).syntax_) ? false : (!!this.unknownFields.equals(((Method)paramObject).unknownFields))))))));
  }
  
  public Method getDefaultInstanceForType() {
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
  
  public Parser<Method> getParserForType() {
    return PARSER;
  }
  
  public boolean getRequestStreaming() {
    return this.requestStreaming_;
  }
  
  public String getRequestTypeUrl() {
    Object object = this.requestTypeUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.requestTypeUrl_ = object;
    return (String)object;
  }
  
  public ByteString getRequestTypeUrlBytes() {
    Object object = this.requestTypeUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.requestTypeUrl_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public boolean getResponseStreaming() {
    return this.responseStreaming_;
  }
  
  public String getResponseTypeUrl() {
    Object object = this.responseTypeUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.responseTypeUrl_ = object;
    return (String)object;
  }
  
  public ByteString getResponseTypeUrlBytes() {
    Object object = this.responseTypeUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.responseTypeUrl_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool1 = getNameBytes().isEmpty();
    boolean bool = false;
    if (!bool1) {
      j = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (!getRequestTypeUrlBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.requestTypeUrl_); 
    bool1 = this.requestStreaming_;
    int k = i;
    if (bool1)
      k = i + CodedOutputStream.computeBoolSize(3, bool1); 
    int j = k;
    if (!getResponseTypeUrlBytes().isEmpty())
      j = k + GeneratedMessageV3.computeStringSize(4, this.responseTypeUrl_); 
    bool1 = this.responseStreaming_;
    i = j;
    k = bool;
    if (bool1) {
      i = j + CodedOutputStream.computeBoolSize(5, bool1);
      k = bool;
    } 
    while (k < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(6, this.options_.get(k));
      k++;
    } 
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
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
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getRequestTypeUrl().hashCode()) * 37 + 3) * 53 + Internal.hashBoolean(getRequestStreaming())) * 37 + 4) * 53 + getResponseTypeUrl().hashCode()) * 37 + 5) * 53 + Internal.hashBoolean(getResponseStreaming());
    int i = j;
    if (getOptionsCount() > 0)
      i = (j * 37 + 6) * 53 + getOptionsList().hashCode(); 
    i = ((i * 37 + 7) * 53 + this.syntax_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Method.class, (Class)Builder.class);
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
    return new Method();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    if (!getRequestTypeUrlBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.requestTypeUrl_); 
    boolean bool = this.requestStreaming_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    if (!getResponseTypeUrlBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.responseTypeUrl_); 
    bool = this.responseStreaming_;
    if (bool)
      paramCodedOutputStream.writeBool(5, bool); 
    for (int i = 0; i < this.options_.size(); i++)
      paramCodedOutputStream.writeMessage(6, this.options_.get(i)); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(7, this.syntax_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MethodOrBuilder {
    private int bitField0_;
    
    private Object name_ = "";
    
    private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
    
    private List<Option> options_ = Collections.emptyList();
    
    private boolean requestStreaming_;
    
    private Object requestTypeUrl_ = "";
    
    private boolean responseStreaming_;
    
    private Object responseTypeUrl_ = "";
    
    private int syntax_ = 0;
    
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
      return ApiProto.internal_static_google_protobuf_Method_descriptor;
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
    
    public Method build() {
      Method method = buildPartial();
      if (method.isInitialized())
        return method; 
      throw newUninitializedMessageException(method);
    }
    
    public Method buildPartial() {
      Method method = new Method(this);
      int i = this.bitField0_;
      Method.access$302(method, this.name_);
      Method.access$402(method, this.requestTypeUrl_);
      Method.access$502(method, this.requestStreaming_);
      Method.access$602(method, this.responseTypeUrl_);
      Method.access$702(method, this.responseStreaming_);
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x1) != 0) {
          this.options_ = Collections.unmodifiableList(this.options_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Method.access$802(method, this.options_);
      } else {
        Method.access$802(method, repeatedFieldBuilderV3.build());
      } 
      Method.access$902(method, this.syntax_);
      onBuilt();
      return method;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.requestTypeUrl_ = "";
      this.requestStreaming_ = false;
      this.responseTypeUrl_ = "";
      this.responseStreaming_ = false;
      RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.options_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.syntax_ = 0;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = Method.getDefaultInstance().getName();
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
    
    public Builder clearRequestStreaming() {
      this.requestStreaming_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearRequestTypeUrl() {
      this.requestTypeUrl_ = Method.getDefaultInstance().getRequestTypeUrl();
      onChanged();
      return this;
    }
    
    public Builder clearResponseStreaming() {
      this.responseStreaming_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearResponseTypeUrl() {
      this.responseTypeUrl_ = Method.getDefaultInstance().getResponseTypeUrl();
      onChanged();
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
    
    public Method getDefaultInstanceForType() {
      return Method.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ApiProto.internal_static_google_protobuf_Method_descriptor;
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
    
    public boolean getRequestStreaming() {
      return this.requestStreaming_;
    }
    
    public String getRequestTypeUrl() {
      Object object = this.requestTypeUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.requestTypeUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRequestTypeUrlBytes() {
      Object object = this.requestTypeUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestTypeUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean getResponseStreaming() {
      return this.responseStreaming_;
    }
    
    public String getResponseTypeUrl() {
      Object object = this.responseTypeUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.responseTypeUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResponseTypeUrlBytes() {
      Object object = this.responseTypeUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.responseTypeUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Method.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Method method = Method.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Method method = (Method)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Method)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Method)
        return mergeFrom((Method)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Method param1Method) {
      if (param1Method == Method.getDefaultInstance())
        return this; 
      if (!param1Method.getName().isEmpty()) {
        this.name_ = param1Method.name_;
        onChanged();
      } 
      if (!param1Method.getRequestTypeUrl().isEmpty()) {
        this.requestTypeUrl_ = param1Method.requestTypeUrl_;
        onChanged();
      } 
      if (param1Method.getRequestStreaming())
        setRequestStreaming(param1Method.getRequestStreaming()); 
      if (!param1Method.getResponseTypeUrl().isEmpty()) {
        this.responseTypeUrl_ = param1Method.responseTypeUrl_;
        onChanged();
      } 
      if (param1Method.getResponseStreaming())
        setResponseStreaming(param1Method.getResponseStreaming()); 
      if (this.optionsBuilder_ == null) {
        if (!param1Method.options_.isEmpty()) {
          if (this.options_.isEmpty()) {
            this.options_ = param1Method.options_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureOptionsIsMutable();
            this.options_.addAll(param1Method.options_);
          } 
          onChanged();
        } 
      } else if (!param1Method.options_.isEmpty()) {
        if (this.optionsBuilder_.isEmpty()) {
          this.optionsBuilder_.dispose();
          RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilderV3 = null;
          this.optionsBuilder_ = null;
          this.options_ = param1Method.options_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (GeneratedMessageV3.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getOptionsFieldBuilder(); 
          this.optionsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.optionsBuilder_.addAllMessages(param1Method.options_);
        } 
      } 
      if (param1Method.syntax_ != 0)
        setSyntaxValue(param1Method.getSyntaxValue()); 
      mergeUnknownFields(param1Method.unknownFields);
      onChanged();
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
    
    public Builder setRequestStreaming(boolean param1Boolean) {
      this.requestStreaming_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setRequestTypeUrl(String param1String) {
      if (param1String != null) {
        this.requestTypeUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestTypeUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.requestTypeUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponseStreaming(boolean param1Boolean) {
      this.responseStreaming_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setResponseTypeUrl(String param1String) {
      if (param1String != null) {
        this.responseTypeUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponseTypeUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        AbstractMessageLite.checkByteStringIsUtf8(param1ByteString);
        this.responseTypeUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
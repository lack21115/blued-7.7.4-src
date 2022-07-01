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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

public final class ResourceDescriptor extends GeneratedMessageV3 implements ResourceDescriptorOrBuilder {
  private static final ResourceDescriptor DEFAULT_INSTANCE = new ResourceDescriptor();
  
  public static final int HISTORY_FIELD_NUMBER = 4;
  
  public static final int NAME_FIELD_FIELD_NUMBER = 3;
  
  private static final Parser<ResourceDescriptor> PARSER = (Parser<ResourceDescriptor>)new AbstractParser<ResourceDescriptor>() {
      public ResourceDescriptor a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ResourceDescriptor(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PATTERN_FIELD_NUMBER = 2;
  
  public static final int PLURAL_FIELD_NUMBER = 5;
  
  public static final int SINGULAR_FIELD_NUMBER = 6;
  
  public static final int TYPE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private int history_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object nameField_;
  
  private LazyStringList pattern_;
  
  private volatile Object plural_;
  
  private volatile Object singular_;
  
  private volatile Object type_;
  
  private ResourceDescriptor() {
    this.type_ = "";
    this.pattern_ = LazyStringArrayList.EMPTY;
    this.nameField_ = "";
    this.history_ = 0;
    this.plural_ = "";
    this.singular_ = "";
  }
  
  private ResourceDescriptor(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                  if (n != 32) {
                    if (n != 42) {
                      if (n != 50) {
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
                      this.singular_ = paramCodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    j = i;
                    k = i;
                    m = i;
                    this.plural_ = paramCodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.history_ = paramCodedInputStream.readEnum();
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.nameField_ = paramCodedInputStream.readStringRequireUtf8();
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
                this.pattern_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.pattern_.add(str);
              i = n;
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.type_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x2) != 0)
          this.pattern_ = this.pattern_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x2) != 0)
        this.pattern_ = this.pattern_.getUnmodifiableView(); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private ResourceDescriptor(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ResourceDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ResourceProto.d;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ResourceDescriptor paramResourceDescriptor) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramResourceDescriptor);
  }
  
  public static ResourceDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ResourceDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ResourceDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ResourceDescriptor)PARSER.parseFrom(paramByteString);
  }
  
  public static ResourceDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceDescriptor)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ResourceDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ResourceDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (ResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ResourceDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceDescriptor parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ResourceDescriptor)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ResourceDescriptor parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceDescriptor)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ResourceDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ResourceDescriptor)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ResourceDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceDescriptor)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ResourceDescriptor> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ResourceDescriptor))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getType().equals(paramObject.getType()) ? false : (!getPatternList().equals(paramObject.getPatternList()) ? false : (!getNameField().equals(paramObject.getNameField()) ? false : ((this.history_ != ((ResourceDescriptor)paramObject).history_) ? false : (!getPlural().equals(paramObject.getPlural()) ? false : (!getSingular().equals(paramObject.getSingular()) ? false : (!!this.unknownFields.equals(((ResourceDescriptor)paramObject).unknownFields)))))));
  }
  
  public ResourceDescriptor getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public History getHistory() {
    History history2 = History.valueOf(this.history_);
    History history1 = history2;
    if (history2 == null)
      history1 = History.UNRECOGNIZED; 
    return history1;
  }
  
  public int getHistoryValue() {
    return this.history_;
  }
  
  public String getNameField() {
    Object object = this.nameField_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.nameField_ = object;
    return (String)object;
  }
  
  public ByteString getNameFieldBytes() {
    Object object = this.nameField_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.nameField_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<ResourceDescriptor> getParserForType() {
    return PARSER;
  }
  
  public String getPattern(int paramInt) {
    return (String)this.pattern_.get(paramInt);
  }
  
  public ByteString getPatternBytes(int paramInt) {
    return this.pattern_.getByteString(paramInt);
  }
  
  public int getPatternCount() {
    return this.pattern_.size();
  }
  
  public ProtocolStringList getPatternList() {
    return (ProtocolStringList)this.pattern_;
  }
  
  public String getPlural() {
    Object object = this.plural_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.plural_ = object;
    return (String)object;
  }
  
  public ByteString getPluralBytes() {
    Object object = this.plural_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.plural_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getTypeBytes().isEmpty();
    int j = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.type_) + 0;
    } else {
      i = 0;
    } 
    int k = 0;
    while (j < this.pattern_.size()) {
      k += computeStringSizeNoTag(this.pattern_.getRaw(j));
      j++;
    } 
    j = i + k + getPatternList().size() * 1;
    i = j;
    if (!getNameFieldBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(3, this.nameField_); 
    j = i;
    if (this.history_ != History.HISTORY_UNSPECIFIED.getNumber())
      j = i + CodedOutputStream.computeEnumSize(4, this.history_); 
    i = j;
    if (!getPluralBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(5, this.plural_); 
    j = i;
    if (!getSingularBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(6, this.singular_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getSingular() {
    Object object = this.singular_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.singular_ = object;
    return (String)object;
  }
  
  public ByteString getSingularBytes() {
    Object object = this.singular_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.singular_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
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
    if (getPatternCount() > 0)
      i = (j * 37 + 2) * 53 + getPatternList().hashCode(); 
    i = ((((((((i * 37 + 3) * 53 + getNameField().hashCode()) * 37 + 4) * 53 + this.history_) * 37 + 5) * 53 + getPlural().hashCode()) * 37 + 6) * 53 + getSingular().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ResourceProto.e.ensureFieldAccessorsInitialized(ResourceDescriptor.class, Builder.class);
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
    for (int i = 0; i < this.pattern_.size(); i++)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.pattern_.getRaw(i)); 
    if (!getNameFieldBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.nameField_); 
    if (this.history_ != History.HISTORY_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(4, this.history_); 
    if (!getPluralBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.plural_); 
    if (!getSingularBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.singular_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResourceDescriptorOrBuilder {
    private int bitField0_;
    
    private int history_ = 0;
    
    private Object nameField_ = "";
    
    private LazyStringList pattern_ = LazyStringArrayList.EMPTY;
    
    private Object plural_ = "";
    
    private Object singular_ = "";
    
    private Object type_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensurePatternIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.pattern_ = (LazyStringList)new LazyStringArrayList(this.pattern_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ResourceProto.d;
    }
    
    private void maybeForceBuilderInitialization() {
      ResourceDescriptor.alwaysUseFieldBuilders;
    }
    
    public Builder addAllPattern(Iterable<String> param1Iterable) {
      ensurePatternIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.pattern_);
      onChanged();
      return this;
    }
    
    public Builder addPattern(String param1String) {
      if (param1String != null) {
        ensurePatternIsMutable();
        this.pattern_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addPatternBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        ensurePatternIsMutable();
        this.pattern_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ResourceDescriptor build() {
      ResourceDescriptor resourceDescriptor = buildPartial();
      if (resourceDescriptor.isInitialized())
        return resourceDescriptor; 
      throw newUninitializedMessageException(resourceDescriptor);
    }
    
    public ResourceDescriptor buildPartial() {
      ResourceDescriptor resourceDescriptor = new ResourceDescriptor(this);
      int i = this.bitField0_;
      ResourceDescriptor.access$402(resourceDescriptor, this.type_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.pattern_ = this.pattern_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      ResourceDescriptor.access$502(resourceDescriptor, this.pattern_);
      ResourceDescriptor.access$602(resourceDescriptor, this.nameField_);
      ResourceDescriptor.access$702(resourceDescriptor, this.history_);
      ResourceDescriptor.access$802(resourceDescriptor, this.plural_);
      ResourceDescriptor.access$902(resourceDescriptor, this.singular_);
      ResourceDescriptor.access$1002(resourceDescriptor, 0);
      onBuilt();
      return resourceDescriptor;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = "";
      this.pattern_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      this.nameField_ = "";
      this.history_ = 0;
      this.plural_ = "";
      this.singular_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHistory() {
      this.history_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearNameField() {
      this.nameField_ = ResourceDescriptor.getDefaultInstance().getNameField();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPattern() {
      this.pattern_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearPlural() {
      this.plural_ = ResourceDescriptor.getDefaultInstance().getPlural();
      onChanged();
      return this;
    }
    
    public Builder clearSingular() {
      this.singular_ = ResourceDescriptor.getDefaultInstance().getSingular();
      onChanged();
      return this;
    }
    
    public Builder clearType() {
      this.type_ = ResourceDescriptor.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ResourceDescriptor getDefaultInstanceForType() {
      return ResourceDescriptor.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ResourceProto.d;
    }
    
    public ResourceDescriptor.History getHistory() {
      ResourceDescriptor.History history2 = ResourceDescriptor.History.valueOf(this.history_);
      ResourceDescriptor.History history1 = history2;
      if (history2 == null)
        history1 = ResourceDescriptor.History.UNRECOGNIZED; 
      return history1;
    }
    
    public int getHistoryValue() {
      return this.history_;
    }
    
    public String getNameField() {
      Object object = this.nameField_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.nameField_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNameFieldBytes() {
      Object object = this.nameField_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.nameField_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPattern(int param1Int) {
      return (String)this.pattern_.get(param1Int);
    }
    
    public ByteString getPatternBytes(int param1Int) {
      return this.pattern_.getByteString(param1Int);
    }
    
    public int getPatternCount() {
      return this.pattern_.size();
    }
    
    public ProtocolStringList getPatternList() {
      return (ProtocolStringList)this.pattern_.getUnmodifiableView();
    }
    
    public String getPlural() {
      Object object = this.plural_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.plural_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPluralBytes() {
      Object object = this.plural_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.plural_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getSingular() {
      Object object = this.singular_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.singular_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSingularBytes() {
      Object object = this.singular_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.singular_ = object;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ResourceProto.e.ensureFieldAccessorsInitialized(ResourceDescriptor.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ResourceDescriptor param1ResourceDescriptor) {
      if (param1ResourceDescriptor == ResourceDescriptor.getDefaultInstance())
        return this; 
      if (!param1ResourceDescriptor.getType().isEmpty()) {
        this.type_ = param1ResourceDescriptor.type_;
        onChanged();
      } 
      if (!param1ResourceDescriptor.pattern_.isEmpty()) {
        if (this.pattern_.isEmpty()) {
          this.pattern_ = param1ResourceDescriptor.pattern_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensurePatternIsMutable();
          this.pattern_.addAll((Collection)param1ResourceDescriptor.pattern_);
        } 
        onChanged();
      } 
      if (!param1ResourceDescriptor.getNameField().isEmpty()) {
        this.nameField_ = param1ResourceDescriptor.nameField_;
        onChanged();
      } 
      if (param1ResourceDescriptor.history_ != 0)
        setHistoryValue(param1ResourceDescriptor.getHistoryValue()); 
      if (!param1ResourceDescriptor.getPlural().isEmpty()) {
        this.plural_ = param1ResourceDescriptor.plural_;
        onChanged();
      } 
      if (!param1ResourceDescriptor.getSingular().isEmpty()) {
        this.singular_ = param1ResourceDescriptor.singular_;
        onChanged();
      } 
      mergeUnknownFields(param1ResourceDescriptor.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ResourceDescriptor resourceDescriptor = (ResourceDescriptor)ResourceDescriptor.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ResourceDescriptor resourceDescriptor = (ResourceDescriptor)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ResourceDescriptor)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ResourceDescriptor)
        return mergeFrom((ResourceDescriptor)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHistory(ResourceDescriptor.History param1History) {
      if (param1History != null) {
        this.history_ = param1History.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHistoryValue(int param1Int) {
      this.history_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setNameField(String param1String) {
      if (param1String != null) {
        this.nameField_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameFieldBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.nameField_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPattern(int param1Int, String param1String) {
      if (param1String != null) {
        ensurePatternIsMutable();
        this.pattern_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPlural(String param1String) {
      if (param1String != null) {
        this.plural_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPluralBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.plural_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSingular(String param1String) {
      if (param1String != null) {
        this.singular_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSingularBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.singular_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
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
  
  public enum History implements ProtocolMessageEnum {
    FUTURE_MULTI_PATTERN,
    HISTORY_UNSPECIFIED(0),
    ORIGINALLY_SINGLE_PATTERN(1),
    UNRECOGNIZED(1);
    
    public static final int FUTURE_MULTI_PATTERN_VALUE = 2;
    
    public static final int HISTORY_UNSPECIFIED_VALUE = 0;
    
    public static final int ORIGINALLY_SINGLE_PATTERN_VALUE = 1;
    
    private static final History[] VALUES;
    
    private static final Internal.EnumLiteMap<History> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new History[] { HISTORY_UNSPECIFIED, ORIGINALLY_SINGLE_PATTERN, FUTURE_MULTI_PATTERN, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<History>() {
          public ResourceDescriptor.History a(int param2Int) {
            return ResourceDescriptor.History.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    History(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static History forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : FUTURE_MULTI_PATTERN) : ORIGINALLY_SINGLE_PATTERN) : HISTORY_UNSPECIFIED;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ResourceDescriptor.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<History> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<History> {
    public ResourceDescriptor.History a(int param1Int) {
      return ResourceDescriptor.History.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ResourceDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
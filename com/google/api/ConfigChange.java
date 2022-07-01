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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ConfigChange extends GeneratedMessageV3 implements ConfigChangeOrBuilder {
  public static final int ADVICES_FIELD_NUMBER = 5;
  
  public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
  
  private static final ConfigChange DEFAULT_INSTANCE = new ConfigChange();
  
  public static final int ELEMENT_FIELD_NUMBER = 1;
  
  public static final int NEW_VALUE_FIELD_NUMBER = 3;
  
  public static final int OLD_VALUE_FIELD_NUMBER = 2;
  
  private static final Parser<ConfigChange> PARSER = (Parser<ConfigChange>)new AbstractParser<ConfigChange>() {
      public ConfigChange a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ConfigChange(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private List<Advice> advices_;
  
  private int bitField0_;
  
  private int changeType_;
  
  private volatile Object element_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object newValue_;
  
  private volatile Object oldValue_;
  
  private ConfigChange() {
    this.element_ = "";
    this.oldValue_ = "";
    this.newValue_ = "";
    this.changeType_ = 0;
    this.advices_ = Collections.emptyList();
  }
  
  private ConfigChange(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                      j = i;
                      k = i;
                      m = i;
                      if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                        continue; 
                      continue;
                    } 
                    n = i;
                    if ((i & 0x10) == 0) {
                      j = i;
                      k = i;
                      m = i;
                      this.advices_ = new ArrayList<Advice>();
                      n = i | 0x10;
                    } 
                    j = n;
                    k = n;
                    m = n;
                    this.advices_.add(paramCodedInputStream.readMessage(Advice.parser(), paramExtensionRegistryLite));
                    i = n;
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.changeType_ = paramCodedInputStream.readEnum();
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.newValue_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.oldValue_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.element_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x10) != 0)
          this.advices_ = Collections.unmodifiableList(this.advices_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x10) != 0)
        this.advices_ = Collections.unmodifiableList(this.advices_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private ConfigChange(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ConfigChange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ConfigChangeProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ConfigChange paramConfigChange) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramConfigChange);
  }
  
  public static ConfigChange parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ConfigChange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ConfigChange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ConfigChange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ConfigChange)PARSER.parseFrom(paramByteString);
  }
  
  public static ConfigChange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ConfigChange)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ConfigChange)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ConfigChange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ConfigChange)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(InputStream paramInputStream) throws IOException {
    return (ConfigChange)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ConfigChange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ConfigChange)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ConfigChange)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ConfigChange parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ConfigChange)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ConfigChange)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ConfigChange parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ConfigChange)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ConfigChange> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ConfigChange))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getElement().equals(paramObject.getElement()) ? false : (!getOldValue().equals(paramObject.getOldValue()) ? false : (!getNewValue().equals(paramObject.getNewValue()) ? false : ((this.changeType_ != ((ConfigChange)paramObject).changeType_) ? false : (!getAdvicesList().equals(paramObject.getAdvicesList()) ? false : (!!this.unknownFields.equals(((ConfigChange)paramObject).unknownFields))))));
  }
  
  public Advice getAdvices(int paramInt) {
    return this.advices_.get(paramInt);
  }
  
  public int getAdvicesCount() {
    return this.advices_.size();
  }
  
  public List<Advice> getAdvicesList() {
    return this.advices_;
  }
  
  public AdviceOrBuilder getAdvicesOrBuilder(int paramInt) {
    return this.advices_.get(paramInt);
  }
  
  public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
    return (List)this.advices_;
  }
  
  public ChangeType getChangeType() {
    ChangeType changeType2 = ChangeType.valueOf(this.changeType_);
    ChangeType changeType1 = changeType2;
    if (changeType2 == null)
      changeType1 = ChangeType.UNRECOGNIZED; 
    return changeType1;
  }
  
  public int getChangeTypeValue() {
    return this.changeType_;
  }
  
  public ConfigChange getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getElement() {
    Object object = this.element_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.element_ = object;
    return (String)object;
  }
  
  public ByteString getElementBytes() {
    Object object = this.element_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.element_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getNewValue() {
    Object object = this.newValue_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.newValue_ = object;
    return (String)object;
  }
  
  public ByteString getNewValueBytes() {
    Object object = this.newValue_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.newValue_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getOldValue() {
    Object object = this.oldValue_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.oldValue_ = object;
    return (String)object;
  }
  
  public ByteString getOldValueBytes() {
    Object object = this.oldValue_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.oldValue_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<ConfigChange> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getElementBytes().isEmpty();
    byte b = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.element_) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!getOldValueBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.oldValue_); 
    i = j;
    if (!getNewValueBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(3, this.newValue_); 
    j = i;
    int k = b;
    if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
      j = i + CodedOutputStream.computeEnumSize(4, this.changeType_);
      k = b;
    } 
    while (k < this.advices_.size()) {
      j += CodedOutputStream.computeMessageSize(5, (MessageLite)this.advices_.get(k));
      k++;
    } 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getElement().hashCode()) * 37 + 2) * 53 + getOldValue().hashCode()) * 37 + 3) * 53 + getNewValue().hashCode()) * 37 + 4) * 53 + this.changeType_;
    int i = j;
    if (getAdvicesCount() > 0)
      i = (j * 37 + 5) * 53 + getAdvicesList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ConfigChangeProto.b.ensureFieldAccessorsInitialized(ConfigChange.class, Builder.class);
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
    if (!getElementBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.element_); 
    if (!getOldValueBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.oldValue_); 
    if (!getNewValueBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.newValue_); 
    if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(4, this.changeType_); 
    for (int i = 0; i < this.advices_.size(); i++)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.advices_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConfigChangeOrBuilder {
    private RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> advicesBuilder_;
    
    private List<Advice> advices_ = Collections.emptyList();
    
    private int bitField0_;
    
    private int changeType_ = 0;
    
    private Object element_ = "";
    
    private Object newValue_ = "";
    
    private Object oldValue_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAdvicesIsMutable() {
      if ((this.bitField0_ & 0x10) == 0) {
        this.advices_ = new ArrayList<Advice>(this.advices_);
        this.bitField0_ |= 0x10;
      } 
    }
    
    private RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> getAdvicesFieldBuilder() {
      if (this.advicesBuilder_ == null) {
        boolean bool;
        List<Advice> list = this.advices_;
        if ((this.bitField0_ & 0x10) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.advicesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.advices_ = null;
      } 
      return this.advicesBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConfigChangeProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      if (ConfigChange.alwaysUseFieldBuilders)
        getAdvicesFieldBuilder(); 
    }
    
    public Builder addAdvices(int param1Int, Advice.Builder param1Builder) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdvicesIsMutable();
        this.advices_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAdvices(int param1Int, Advice param1Advice) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Advice != null) {
          ensureAdvicesIsMutable();
          this.advices_.add(param1Int, param1Advice);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Advice);
      return this;
    }
    
    public Builder addAdvices(Advice.Builder param1Builder) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdvicesIsMutable();
        this.advices_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAdvices(Advice param1Advice) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Advice != null) {
          ensureAdvicesIsMutable();
          this.advices_.add(param1Advice);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Advice);
      return this;
    }
    
    public Advice.Builder addAdvicesBuilder() {
      return (Advice.Builder)getAdvicesFieldBuilder().addBuilder((AbstractMessage)Advice.getDefaultInstance());
    }
    
    public Advice.Builder addAdvicesBuilder(int param1Int) {
      return (Advice.Builder)getAdvicesFieldBuilder().addBuilder(param1Int, (AbstractMessage)Advice.getDefaultInstance());
    }
    
    public Builder addAllAdvices(Iterable<? extends Advice> param1Iterable) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdvicesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.advices_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ConfigChange build() {
      ConfigChange configChange = buildPartial();
      if (configChange.isInitialized())
        return configChange; 
      throw newUninitializedMessageException(configChange);
    }
    
    public ConfigChange buildPartial() {
      ConfigChange configChange = new ConfigChange(this);
      int i = this.bitField0_;
      ConfigChange.access$402(configChange, this.element_);
      ConfigChange.access$502(configChange, this.oldValue_);
      ConfigChange.access$602(configChange, this.newValue_);
      ConfigChange.access$702(configChange, this.changeType_);
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x10) != 0) {
          this.advices_ = Collections.unmodifiableList(this.advices_);
          this.bitField0_ &= 0xFFFFFFEF;
        } 
        ConfigChange.access$802(configChange, this.advices_);
      } else {
        ConfigChange.access$802(configChange, repeatedFieldBuilderV3.build());
      } 
      ConfigChange.access$902(configChange, 0);
      onBuilt();
      return configChange;
    }
    
    public Builder clear() {
      super.clear();
      this.element_ = "";
      this.oldValue_ = "";
      this.newValue_ = "";
      this.changeType_ = 0;
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.advices_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFEF;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearAdvices() {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.advices_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFEF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearChangeType() {
      this.changeType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearElement() {
      this.element_ = ConfigChange.getDefaultInstance().getElement();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNewValue() {
      this.newValue_ = ConfigChange.getDefaultInstance().getNewValue();
      onChanged();
      return this;
    }
    
    public Builder clearOldValue() {
      this.oldValue_ = ConfigChange.getDefaultInstance().getOldValue();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Advice getAdvices(int param1Int) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.advices_.get(param1Int) : (Advice)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Advice.Builder getAdvicesBuilder(int param1Int) {
      return (Advice.Builder)getAdvicesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Advice.Builder> getAdvicesBuilderList() {
      return getAdvicesFieldBuilder().getBuilderList();
    }
    
    public int getAdvicesCount() {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.advices_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Advice> getAdvicesList() {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.advices_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AdviceOrBuilder getAdvicesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.advices_.get(param1Int) : (AdviceOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.advices_);
    }
    
    public ChangeType getChangeType() {
      ChangeType changeType2 = ChangeType.valueOf(this.changeType_);
      ChangeType changeType1 = changeType2;
      if (changeType2 == null)
        changeType1 = ChangeType.UNRECOGNIZED; 
      return changeType1;
    }
    
    public int getChangeTypeValue() {
      return this.changeType_;
    }
    
    public ConfigChange getDefaultInstanceForType() {
      return ConfigChange.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ConfigChangeProto.a;
    }
    
    public String getElement() {
      Object object = this.element_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.element_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getElementBytes() {
      Object object = this.element_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.element_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNewValue() {
      Object object = this.newValue_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.newValue_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNewValueBytes() {
      Object object = this.newValue_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.newValue_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOldValue() {
      Object object = this.oldValue_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.oldValue_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOldValueBytes() {
      Object object = this.oldValue_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.oldValue_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConfigChangeProto.b.ensureFieldAccessorsInitialized(ConfigChange.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ConfigChange param1ConfigChange) {
      if (param1ConfigChange == ConfigChange.getDefaultInstance())
        return this; 
      if (!param1ConfigChange.getElement().isEmpty()) {
        this.element_ = param1ConfigChange.element_;
        onChanged();
      } 
      if (!param1ConfigChange.getOldValue().isEmpty()) {
        this.oldValue_ = param1ConfigChange.oldValue_;
        onChanged();
      } 
      if (!param1ConfigChange.getNewValue().isEmpty()) {
        this.newValue_ = param1ConfigChange.newValue_;
        onChanged();
      } 
      if (param1ConfigChange.changeType_ != 0)
        setChangeTypeValue(param1ConfigChange.getChangeTypeValue()); 
      if (this.advicesBuilder_ == null) {
        if (!param1ConfigChange.advices_.isEmpty()) {
          if (this.advices_.isEmpty()) {
            this.advices_ = param1ConfigChange.advices_;
            this.bitField0_ &= 0xFFFFFFEF;
          } else {
            ensureAdvicesIsMutable();
            this.advices_.addAll(param1ConfigChange.advices_);
          } 
          onChanged();
        } 
      } else if (!param1ConfigChange.advices_.isEmpty()) {
        if (this.advicesBuilder_.isEmpty()) {
          this.advicesBuilder_.dispose();
          RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = null;
          this.advicesBuilder_ = null;
          this.advices_ = param1ConfigChange.advices_;
          this.bitField0_ &= 0xFFFFFFEF;
          if (ConfigChange.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getAdvicesFieldBuilder(); 
          this.advicesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.advicesBuilder_.addAllMessages(param1ConfigChange.advices_);
        } 
      } 
      mergeUnknownFields(param1ConfigChange.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ConfigChange configChange = (ConfigChange)ConfigChange.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ConfigChange configChange = (ConfigChange)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ConfigChange)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ConfigChange)
        return mergeFrom((ConfigChange)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeAdvices(int param1Int) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdvicesIsMutable();
        this.advices_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setAdvices(int param1Int, Advice.Builder param1Builder) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdvicesIsMutable();
        this.advices_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAdvices(int param1Int, Advice param1Advice) {
      RepeatedFieldBuilderV3<Advice, Advice.Builder, AdviceOrBuilder> repeatedFieldBuilderV3 = this.advicesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Advice != null) {
          ensureAdvicesIsMutable();
          this.advices_.set(param1Int, param1Advice);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Advice);
      return this;
    }
    
    public Builder setChangeType(ChangeType param1ChangeType) {
      if (param1ChangeType != null) {
        this.changeType_ = param1ChangeType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setChangeTypeValue(int param1Int) {
      this.changeType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setElement(String param1String) {
      if (param1String != null) {
        this.element_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setElementBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ConfigChange.checkByteStringIsUtf8(param1ByteString);
        this.element_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNewValue(String param1String) {
      if (param1String != null) {
        this.newValue_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNewValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ConfigChange.checkByteStringIsUtf8(param1ByteString);
        this.newValue_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOldValue(String param1String) {
      if (param1String != null) {
        this.oldValue_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOldValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ConfigChange.checkByteStringIsUtf8(param1ByteString);
        this.oldValue_ = param1ByteString;
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
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ConfigChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
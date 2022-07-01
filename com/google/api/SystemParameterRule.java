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

public final class SystemParameterRule extends GeneratedMessageV3 implements SystemParameterRuleOrBuilder {
  private static final SystemParameterRule DEFAULT_INSTANCE = new SystemParameterRule();
  
  public static final int PARAMETERS_FIELD_NUMBER = 2;
  
  private static final Parser<SystemParameterRule> PARSER = (Parser<SystemParameterRule>)new AbstractParser<SystemParameterRule>() {
      public SystemParameterRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new SystemParameterRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private List<SystemParameter> parameters_;
  
  private volatile Object selector_;
  
  private SystemParameterRule() {
    this.selector_ = "";
    this.parameters_ = Collections.emptyList();
  }
  
  private SystemParameterRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                j = i;
                k = i;
                m = i;
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                  continue; 
                continue;
              } 
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.parameters_ = new ArrayList<SystemParameter>();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.parameters_.add(paramCodedInputStream.readMessage(SystemParameter.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.selector_ = paramCodedInputStream.readStringRequireUtf8();
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
          this.parameters_ = Collections.unmodifiableList(this.parameters_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x2) != 0)
        this.parameters_ = Collections.unmodifiableList(this.parameters_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private SystemParameterRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static SystemParameterRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return SystemParameterProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SystemParameterRule paramSystemParameterRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSystemParameterRule);
  }
  
  public static SystemParameterRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameterRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static SystemParameterRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameterRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (SystemParameterRule)PARSER.parseFrom(paramByteString);
  }
  
  public static SystemParameterRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameterRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (SystemParameterRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static SystemParameterRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameterRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameterRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static SystemParameterRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameterRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (SystemParameterRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static SystemParameterRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameterRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (SystemParameterRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static SystemParameterRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameterRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SystemParameterRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SystemParameterRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : (!getParametersList().equals(paramObject.getParametersList()) ? false : (!!this.unknownFields.equals(((SystemParameterRule)paramObject).unknownFields)));
  }
  
  public SystemParameterRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public SystemParameter getParameters(int paramInt) {
    return this.parameters_.get(paramInt);
  }
  
  public int getParametersCount() {
    return this.parameters_.size();
  }
  
  public List<SystemParameter> getParametersList() {
    return this.parameters_;
  }
  
  public SystemParameterOrBuilder getParametersOrBuilder(int paramInt) {
    return this.parameters_.get(paramInt);
  }
  
  public List<? extends SystemParameterOrBuilder> getParametersOrBuilderList() {
    return (List)this.parameters_;
  }
  
  public Parser<SystemParameterRule> getParserForType() {
    return PARSER;
  }
  
  public String getSelector() {
    Object object = this.selector_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.selector_ = object;
    return (String)object;
  }
  
  public ByteString getSelectorBytes() {
    Object object = this.selector_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.selector_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getSelectorBytes().isEmpty();
    int j = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.selector_) + 0;
    } else {
      i = 0;
    } 
    while (j < this.parameters_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.parameters_.get(j));
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
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode();
    int i = j;
    if (getParametersCount() > 0)
      i = (j * 37 + 2) * 53 + getParametersList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return SystemParameterProto.d.ensureFieldAccessorsInitialized(SystemParameterRule.class, Builder.class);
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
    if (!getSelectorBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.selector_); 
    for (int i = 0; i < this.parameters_.size(); i++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.parameters_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemParameterRuleOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> parametersBuilder_;
    
    private List<SystemParameter> parameters_ = Collections.emptyList();
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureParametersIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.parameters_ = new ArrayList<SystemParameter>(this.parameters_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SystemParameterProto.c;
    }
    
    private RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> getParametersFieldBuilder() {
      if (this.parametersBuilder_ == null) {
        boolean bool;
        List<SystemParameter> list = this.parameters_;
        if ((this.bitField0_ & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.parametersBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.parameters_ = null;
      } 
      return this.parametersBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (SystemParameterRule.alwaysUseFieldBuilders)
        getParametersFieldBuilder(); 
    }
    
    public Builder addAllParameters(Iterable<? extends SystemParameter> param1Iterable) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureParametersIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.parameters_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addParameters(int param1Int, SystemParameter.Builder param1Builder) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureParametersIsMutable();
        this.parameters_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addParameters(int param1Int, SystemParameter param1SystemParameter) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1SystemParameter != null) {
          ensureParametersIsMutable();
          this.parameters_.add(param1Int, param1SystemParameter);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1SystemParameter);
      return this;
    }
    
    public Builder addParameters(SystemParameter.Builder param1Builder) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureParametersIsMutable();
        this.parameters_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addParameters(SystemParameter param1SystemParameter) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1SystemParameter != null) {
          ensureParametersIsMutable();
          this.parameters_.add(param1SystemParameter);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1SystemParameter);
      return this;
    }
    
    public SystemParameter.Builder addParametersBuilder() {
      return (SystemParameter.Builder)getParametersFieldBuilder().addBuilder((AbstractMessage)SystemParameter.getDefaultInstance());
    }
    
    public SystemParameter.Builder addParametersBuilder(int param1Int) {
      return (SystemParameter.Builder)getParametersFieldBuilder().addBuilder(param1Int, (AbstractMessage)SystemParameter.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SystemParameterRule build() {
      SystemParameterRule systemParameterRule = buildPartial();
      if (systemParameterRule.isInitialized())
        return systemParameterRule; 
      throw newUninitializedMessageException(systemParameterRule);
    }
    
    public SystemParameterRule buildPartial() {
      SystemParameterRule systemParameterRule = new SystemParameterRule(this);
      int i = this.bitField0_;
      SystemParameterRule.access$402(systemParameterRule, this.selector_);
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.parameters_ = Collections.unmodifiableList(this.parameters_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        SystemParameterRule.access$502(systemParameterRule, this.parameters_);
      } else {
        SystemParameterRule.access$502(systemParameterRule, repeatedFieldBuilderV3.build());
      } 
      SystemParameterRule.access$602(systemParameterRule, 0);
      onBuilt();
      return systemParameterRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.parameters_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearParameters() {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.parameters_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearSelector() {
      this.selector_ = SystemParameterRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public SystemParameterRule getDefaultInstanceForType() {
      return SystemParameterRule.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SystemParameterProto.c;
    }
    
    public SystemParameter getParameters(int param1Int) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.parameters_.get(param1Int) : (SystemParameter)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public SystemParameter.Builder getParametersBuilder(int param1Int) {
      return (SystemParameter.Builder)getParametersFieldBuilder().getBuilder(param1Int);
    }
    
    public List<SystemParameter.Builder> getParametersBuilderList() {
      return getParametersFieldBuilder().getBuilderList();
    }
    
    public int getParametersCount() {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.parameters_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<SystemParameter> getParametersList() {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.parameters_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public SystemParameterOrBuilder getParametersOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.parameters_.get(param1Int) : (SystemParameterOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends SystemParameterOrBuilder> getParametersOrBuilderList() {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.parameters_);
    }
    
    public String getSelector() {
      Object object = this.selector_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.selector_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSelectorBytes() {
      Object object = this.selector_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.selector_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SystemParameterProto.d.ensureFieldAccessorsInitialized(SystemParameterRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SystemParameterRule param1SystemParameterRule) {
      if (param1SystemParameterRule == SystemParameterRule.getDefaultInstance())
        return this; 
      if (!param1SystemParameterRule.getSelector().isEmpty()) {
        this.selector_ = param1SystemParameterRule.selector_;
        onChanged();
      } 
      if (this.parametersBuilder_ == null) {
        if (!param1SystemParameterRule.parameters_.isEmpty()) {
          if (this.parameters_.isEmpty()) {
            this.parameters_ = param1SystemParameterRule.parameters_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureParametersIsMutable();
            this.parameters_.addAll(param1SystemParameterRule.parameters_);
          } 
          onChanged();
        } 
      } else if (!param1SystemParameterRule.parameters_.isEmpty()) {
        if (this.parametersBuilder_.isEmpty()) {
          this.parametersBuilder_.dispose();
          RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = null;
          this.parametersBuilder_ = null;
          this.parameters_ = param1SystemParameterRule.parameters_;
          this.bitField0_ &= 0xFFFFFFFD;
          if (SystemParameterRule.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getParametersFieldBuilder(); 
          this.parametersBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.parametersBuilder_.addAllMessages(param1SystemParameterRule.parameters_);
        } 
      } 
      mergeUnknownFields(param1SystemParameterRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SystemParameterRule systemParameterRule = (SystemParameterRule)SystemParameterRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SystemParameterRule systemParameterRule = (SystemParameterRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SystemParameterRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SystemParameterRule)
        return mergeFrom((SystemParameterRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeParameters(int param1Int) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureParametersIsMutable();
        this.parameters_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setParameters(int param1Int, SystemParameter.Builder param1Builder) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureParametersIsMutable();
        this.parameters_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setParameters(int param1Int, SystemParameter param1SystemParameter) {
      RepeatedFieldBuilderV3<SystemParameter, SystemParameter.Builder, SystemParameterOrBuilder> repeatedFieldBuilderV3 = this.parametersBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1SystemParameter != null) {
          ensureParametersIsMutable();
          this.parameters_.set(param1Int, param1SystemParameter);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1SystemParameter);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSelector(String param1String) {
      if (param1String != null) {
        this.selector_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SystemParameterRule.checkByteStringIsUtf8(param1ByteString);
        this.selector_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParameterRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
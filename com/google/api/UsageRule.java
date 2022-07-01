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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UsageRule extends GeneratedMessageV3 implements UsageRuleOrBuilder {
  public static final int ALLOW_UNREGISTERED_CALLS_FIELD_NUMBER = 2;
  
  private static final UsageRule DEFAULT_INSTANCE = new UsageRule();
  
  private static final Parser<UsageRule> PARSER = (Parser<UsageRule>)new AbstractParser<UsageRule>() {
      public UsageRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new UsageRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  public static final int SKIP_SERVICE_CONTROL_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private boolean allowUnregisteredCalls_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object selector_;
  
  private boolean skipServiceControl_;
  
  private UsageRule() {
    this.selector_ = "";
  }
  
  private UsageRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 16) {
                if (i != 24) {
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.skipServiceControl_ = paramCodedInputStream.readBool();
                continue;
              } 
              this.allowUnregisteredCalls_ = paramCodedInputStream.readBool();
              continue;
            } 
            this.selector_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private UsageRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static UsageRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return UsageProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UsageRule paramUsageRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramUsageRule);
  }
  
  public static UsageRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (UsageRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static UsageRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UsageRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (UsageRule)PARSER.parseFrom(paramByteString);
  }
  
  public static UsageRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UsageRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (UsageRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static UsageRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UsageRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(InputStream paramInputStream) throws IOException {
    return (UsageRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static UsageRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UsageRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (UsageRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static UsageRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UsageRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (UsageRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static UsageRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UsageRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UsageRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof UsageRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : ((getAllowUnregisteredCalls() != paramObject.getAllowUnregisteredCalls()) ? false : ((getSkipServiceControl() != paramObject.getSkipServiceControl()) ? false : (!!this.unknownFields.equals(((UsageRule)paramObject).unknownFields))));
  }
  
  public boolean getAllowUnregisteredCalls() {
    return this.allowUnregisteredCalls_;
  }
  
  public UsageRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<UsageRule> getParserForType() {
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
    int j = 0;
    if (!getSelectorBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.selector_); 
    boolean bool = this.allowUnregisteredCalls_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(2, bool); 
    bool = this.skipServiceControl_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public boolean getSkipServiceControl() {
    return this.skipServiceControl_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode()) * 37 + 2) * 53 + Internal.hashBoolean(getAllowUnregisteredCalls())) * 37 + 3) * 53 + Internal.hashBoolean(getSkipServiceControl())) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return UsageProto.d.ensureFieldAccessorsInitialized(UsageRule.class, Builder.class);
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
    boolean bool = this.allowUnregisteredCalls_;
    if (bool)
      paramCodedOutputStream.writeBool(2, bool); 
    bool = this.skipServiceControl_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UsageRuleOrBuilder {
    private boolean allowUnregisteredCalls_;
    
    private Object selector_ = "";
    
    private boolean skipServiceControl_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return UsageProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      UsageRule.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public UsageRule build() {
      UsageRule usageRule = buildPartial();
      if (usageRule.isInitialized())
        return usageRule; 
      throw newUninitializedMessageException(usageRule);
    }
    
    public UsageRule buildPartial() {
      UsageRule usageRule = new UsageRule(this);
      UsageRule.access$402(usageRule, this.selector_);
      UsageRule.access$502(usageRule, this.allowUnregisteredCalls_);
      UsageRule.access$602(usageRule, this.skipServiceControl_);
      onBuilt();
      return usageRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      this.allowUnregisteredCalls_ = false;
      this.skipServiceControl_ = false;
      return this;
    }
    
    public Builder clearAllowUnregisteredCalls() {
      this.allowUnregisteredCalls_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSelector() {
      this.selector_ = UsageRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clearSkipServiceControl() {
      this.skipServiceControl_ = false;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public boolean getAllowUnregisteredCalls() {
      return this.allowUnregisteredCalls_;
    }
    
    public UsageRule getDefaultInstanceForType() {
      return UsageRule.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return UsageProto.c;
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
    
    public boolean getSkipServiceControl() {
      return this.skipServiceControl_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return UsageProto.d.ensureFieldAccessorsInitialized(UsageRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(UsageRule param1UsageRule) {
      if (param1UsageRule == UsageRule.getDefaultInstance())
        return this; 
      if (!param1UsageRule.getSelector().isEmpty()) {
        this.selector_ = param1UsageRule.selector_;
        onChanged();
      } 
      if (param1UsageRule.getAllowUnregisteredCalls())
        setAllowUnregisteredCalls(param1UsageRule.getAllowUnregisteredCalls()); 
      if (param1UsageRule.getSkipServiceControl())
        setSkipServiceControl(param1UsageRule.getSkipServiceControl()); 
      mergeUnknownFields(param1UsageRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        UsageRule usageRule = (UsageRule)UsageRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        UsageRule usageRule = (UsageRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((UsageRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof UsageRule)
        return mergeFrom((UsageRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAllowUnregisteredCalls(boolean param1Boolean) {
      this.allowUnregisteredCalls_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
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
        UsageRule.checkByteStringIsUtf8(param1ByteString);
        this.selector_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSkipServiceControl(boolean param1Boolean) {
      this.skipServiceControl_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\UsageRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
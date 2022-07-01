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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Http extends GeneratedMessageV3 implements HttpOrBuilder {
  private static final Http DEFAULT_INSTANCE = new Http();
  
  public static final int FULLY_DECODE_RESERVED_EXPANSION_FIELD_NUMBER = 2;
  
  private static final Parser<Http> PARSER = (Parser<Http>)new AbstractParser<Http>() {
      public Http a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Http(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RULES_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private boolean fullyDecodeReservedExpansion_;
  
  private byte memoizedIsInitialized = -1;
  
  private List<HttpRule> rules_;
  
  private Http() {
    this.rules_ = Collections.emptyList();
  }
  
  private Http(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.fullyDecodeReservedExpansion_ = paramCodedInputStream.readBool();
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.rules_ = new ArrayList<HttpRule>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.rules_.add(paramCodedInputStream.readMessage(HttpRule.parser(), paramExtensionRegistryLite));
            i = n;
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
          this.rules_ = Collections.unmodifiableList(this.rules_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.rules_ = Collections.unmodifiableList(this.rules_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Http(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Http getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return HttpProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Http paramHttp) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramHttp);
  }
  
  public static Http parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Http)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Http parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Http)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Http)PARSER.parseFrom(paramByteString);
  }
  
  public static Http parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Http)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Http)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Http parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Http)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(InputStream paramInputStream) throws IOException {
    return (Http)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Http parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Http)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Http)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Http parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Http)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Http)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Http parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Http)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Http> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Http))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getRulesList().equals(paramObject.getRulesList()) ? false : ((getFullyDecodeReservedExpansion() != paramObject.getFullyDecodeReservedExpansion()) ? false : (!!this.unknownFields.equals(((Http)paramObject).unknownFields)));
  }
  
  public Http getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public boolean getFullyDecodeReservedExpansion() {
    return this.fullyDecodeReservedExpansion_;
  }
  
  public Parser<Http> getParserForType() {
    return PARSER;
  }
  
  public HttpRule getRules(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<HttpRule> getRulesList() {
    return this.rules_;
  }
  
  public HttpRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public List<? extends HttpRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.rules_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.rules_.get(j));
      j++;
    } 
    boolean bool = this.fullyDecodeReservedExpansion_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(2, bool); 
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
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getRulesCount() > 0)
      i = (j * 37 + 1) * 53 + getRulesList().hashCode(); 
    i = ((i * 37 + 2) * 53 + Internal.hashBoolean(getFullyDecodeReservedExpansion())) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return HttpProto.b.ensureFieldAccessorsInitialized(Http.class, Builder.class);
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
    for (int i = 0; i < this.rules_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.rules_.get(i)); 
    boolean bool = this.fullyDecodeReservedExpansion_;
    if (bool)
      paramCodedOutputStream.writeBool(2, bool); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpOrBuilder {
    private int bitField0_;
    
    private boolean fullyDecodeReservedExpansion_;
    
    private RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> rulesBuilder_;
    
    private List<HttpRule> rules_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureRulesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.rules_ = new ArrayList<HttpRule>(this.rules_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return HttpProto.a;
    }
    
    private RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> getRulesFieldBuilder() {
      if (this.rulesBuilder_ == null) {
        List<HttpRule> list = this.rules_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.rulesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.rules_ = null;
      } 
      return this.rulesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Http.alwaysUseFieldBuilders)
        getRulesFieldBuilder(); 
    }
    
    public Builder addAllRules(Iterable<? extends HttpRule> param1Iterable) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.rules_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRules(int param1Int, HttpRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(int param1Int, HttpRule param1HttpRule) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1HttpRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1Int, param1HttpRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1HttpRule);
      return this;
    }
    
    public Builder addRules(HttpRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(HttpRule param1HttpRule) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1HttpRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1HttpRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1HttpRule);
      return this;
    }
    
    public HttpRule.Builder addRulesBuilder() {
      return (HttpRule.Builder)getRulesFieldBuilder().addBuilder((AbstractMessage)HttpRule.getDefaultInstance());
    }
    
    public HttpRule.Builder addRulesBuilder(int param1Int) {
      return (HttpRule.Builder)getRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)HttpRule.getDefaultInstance());
    }
    
    public Http build() {
      Http http = buildPartial();
      if (http.isInitialized())
        return http; 
      throw newUninitializedMessageException(http);
    }
    
    public Http buildPartial() {
      Http http = new Http(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.rules_ = Collections.unmodifiableList(this.rules_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Http.access$402(http, this.rules_);
      } else {
        Http.access$402(http, repeatedFieldBuilderV3.build());
      } 
      Http.access$502(http, this.fullyDecodeReservedExpansion_);
      Http.access$602(http, 0);
      onBuilt();
      return http;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.fullyDecodeReservedExpansion_ = false;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFullyDecodeReservedExpansion() {
      this.fullyDecodeReservedExpansion_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRules() {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Http getDefaultInstanceForType() {
      return Http.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return HttpProto.a;
    }
    
    public boolean getFullyDecodeReservedExpansion() {
      return this.fullyDecodeReservedExpansion_;
    }
    
    public HttpRule getRules(int param1Int) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (HttpRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public HttpRule.Builder getRulesBuilder(int param1Int) {
      return (HttpRule.Builder)getRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<HttpRule.Builder> getRulesBuilderList() {
      return getRulesFieldBuilder().getBuilderList();
    }
    
    public int getRulesCount() {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<HttpRule> getRulesList() {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public HttpRuleOrBuilder getRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (HttpRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends HttpRuleOrBuilder> getRulesOrBuilderList() {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.rules_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return HttpProto.b.ensureFieldAccessorsInitialized(Http.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Http param1Http) {
      if (param1Http == Http.getDefaultInstance())
        return this; 
      if (this.rulesBuilder_ == null) {
        if (!param1Http.rules_.isEmpty()) {
          if (this.rules_.isEmpty()) {
            this.rules_ = param1Http.rules_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureRulesIsMutable();
            this.rules_.addAll(param1Http.rules_);
          } 
          onChanged();
        } 
      } else if (!param1Http.rules_.isEmpty()) {
        if (this.rulesBuilder_.isEmpty()) {
          this.rulesBuilder_.dispose();
          RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = null;
          this.rulesBuilder_ = null;
          this.rules_ = param1Http.rules_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Http.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getRulesFieldBuilder(); 
          this.rulesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.rulesBuilder_.addAllMessages(param1Http.rules_);
        } 
      } 
      if (param1Http.getFullyDecodeReservedExpansion())
        setFullyDecodeReservedExpansion(param1Http.getFullyDecodeReservedExpansion()); 
      mergeUnknownFields(param1Http.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Http http = (Http)Http.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Http http = (Http)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Http)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Http)
        return mergeFrom((Http)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeRules(int param1Int) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFullyDecodeReservedExpansion(boolean param1Boolean) {
      this.fullyDecodeReservedExpansion_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRules(int param1Int, HttpRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRules(int param1Int, HttpRule param1HttpRule) {
      RepeatedFieldBuilderV3<HttpRule, HttpRule.Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1HttpRule != null) {
          ensureRulesIsMutable();
          this.rules_.set(param1Int, param1HttpRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1HttpRule);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Http.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
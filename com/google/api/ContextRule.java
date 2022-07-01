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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

public final class ContextRule extends GeneratedMessageV3 implements ContextRuleOrBuilder {
  public static final int ALLOWED_REQUEST_EXTENSIONS_FIELD_NUMBER = 4;
  
  public static final int ALLOWED_RESPONSE_EXTENSIONS_FIELD_NUMBER = 5;
  
  private static final ContextRule DEFAULT_INSTANCE = new ContextRule();
  
  private static final Parser<ContextRule> PARSER = (Parser<ContextRule>)new AbstractParser<ContextRule>() {
      public ContextRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ContextRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PROVIDED_FIELD_NUMBER = 3;
  
  public static final int REQUESTED_FIELD_NUMBER = 2;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private LazyStringList allowedRequestExtensions_;
  
  private LazyStringList allowedResponseExtensions_;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private LazyStringList provided_;
  
  private LazyStringList requested_;
  
  private volatile Object selector_;
  
  private ContextRule() {
    this.selector_ = "";
    this.requested_ = LazyStringArrayList.EMPTY;
    this.provided_ = LazyStringArrayList.EMPTY;
    this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
    this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
  }
  
  private ContextRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    String str3 = paramCodedInputStream.readStringRequireUtf8();
                    n = i;
                    if ((i & 0x10) == 0) {
                      j = i;
                      k = i;
                      m = i;
                      this.allowedResponseExtensions_ = (LazyStringList)new LazyStringArrayList();
                      n = i | 0x10;
                    } 
                    j = n;
                    k = n;
                    m = n;
                    this.allowedResponseExtensions_.add(str3);
                    i = n;
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  String str2 = paramCodedInputStream.readStringRequireUtf8();
                  n = i;
                  if ((i & 0x8) == 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.allowedRequestExtensions_ = (LazyStringList)new LazyStringArrayList();
                    n = i | 0x8;
                  } 
                  j = n;
                  k = n;
                  m = n;
                  this.allowedRequestExtensions_.add(str2);
                  i = n;
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                String str1 = paramCodedInputStream.readStringRequireUtf8();
                n = i;
                if ((i & 0x4) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.provided_ = (LazyStringList)new LazyStringArrayList();
                  n = i | 0x4;
                } 
                j = n;
                k = n;
                m = n;
                this.provided_.add(str1);
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
                this.requested_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.requested_.add(str);
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
          this.requested_ = this.requested_.getUnmodifiableView(); 
        if ((j & 0x4) != 0)
          this.provided_ = this.provided_.getUnmodifiableView(); 
        if ((j & 0x8) != 0)
          this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView(); 
        if ((j & 0x10) != 0)
          this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x2) != 0)
        this.requested_ = this.requested_.getUnmodifiableView(); 
      if ((i & 0x4) != 0)
        this.provided_ = this.provided_.getUnmodifiableView(); 
      if ((i & 0x8) != 0)
        this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView(); 
      if ((i & 0x10) != 0)
        this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView(); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private ContextRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ContextRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ContextProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ContextRule paramContextRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramContextRule);
  }
  
  public static ContextRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ContextRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ContextRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ContextRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ContextRule)PARSER.parseFrom(paramByteString);
  }
  
  public static ContextRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ContextRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ContextRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ContextRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ContextRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(InputStream paramInputStream) throws IOException {
    return (ContextRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ContextRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ContextRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ContextRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ContextRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ContextRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ContextRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ContextRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ContextRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ContextRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ContextRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : (!getRequestedList().equals(paramObject.getRequestedList()) ? false : (!getProvidedList().equals(paramObject.getProvidedList()) ? false : (!getAllowedRequestExtensionsList().equals(paramObject.getAllowedRequestExtensionsList()) ? false : (!getAllowedResponseExtensionsList().equals(paramObject.getAllowedResponseExtensionsList()) ? false : (!!this.unknownFields.equals(((ContextRule)paramObject).unknownFields))))));
  }
  
  public String getAllowedRequestExtensions(int paramInt) {
    return (String)this.allowedRequestExtensions_.get(paramInt);
  }
  
  public ByteString getAllowedRequestExtensionsBytes(int paramInt) {
    return this.allowedRequestExtensions_.getByteString(paramInt);
  }
  
  public int getAllowedRequestExtensionsCount() {
    return this.allowedRequestExtensions_.size();
  }
  
  public ProtocolStringList getAllowedRequestExtensionsList() {
    return (ProtocolStringList)this.allowedRequestExtensions_;
  }
  
  public String getAllowedResponseExtensions(int paramInt) {
    return (String)this.allowedResponseExtensions_.get(paramInt);
  }
  
  public ByteString getAllowedResponseExtensionsBytes(int paramInt) {
    return this.allowedResponseExtensions_.getByteString(paramInt);
  }
  
  public int getAllowedResponseExtensionsCount() {
    return this.allowedResponseExtensions_.size();
  }
  
  public ProtocolStringList getAllowedResponseExtensionsList() {
    return (ProtocolStringList)this.allowedResponseExtensions_;
  }
  
  public ContextRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<ContextRule> getParserForType() {
    return PARSER;
  }
  
  public String getProvided(int paramInt) {
    return (String)this.provided_.get(paramInt);
  }
  
  public ByteString getProvidedBytes(int paramInt) {
    return this.provided_.getByteString(paramInt);
  }
  
  public int getProvidedCount() {
    return this.provided_.size();
  }
  
  public ProtocolStringList getProvidedList() {
    return (ProtocolStringList)this.provided_;
  }
  
  public String getRequested(int paramInt) {
    return (String)this.requested_.get(paramInt);
  }
  
  public ByteString getRequestedBytes(int paramInt) {
    return this.requested_.getByteString(paramInt);
  }
  
  public int getRequestedCount() {
    return this.requested_.size();
  }
  
  public ProtocolStringList getRequestedList() {
    return (ProtocolStringList)this.requested_;
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
    boolean bool1 = getSelectorBytes().isEmpty();
    boolean bool = false;
    if (!bool1) {
      i = GeneratedMessageV3.computeStringSize(1, this.selector_) + 0;
    } else {
      i = 0;
    } 
    int k = 0;
    int j = 0;
    while (k < this.requested_.size()) {
      j += computeStringSizeNoTag(this.requested_.getRaw(k));
      k++;
    } 
    int i2 = getRequestedList().size();
    int m = 0;
    k = 0;
    while (m < this.provided_.size()) {
      k += computeStringSizeNoTag(this.provided_.getRaw(m));
      m++;
    } 
    int i3 = getProvidedList().size();
    int n = 0;
    m = 0;
    while (n < this.allowedRequestExtensions_.size()) {
      m += computeStringSizeNoTag(this.allowedRequestExtensions_.getRaw(n));
      n++;
    } 
    int i4 = getAllowedRequestExtensionsList().size();
    int i1 = 0;
    for (n = bool; n < this.allowedResponseExtensions_.size(); n++)
      i1 += computeStringSizeNoTag(this.allowedResponseExtensions_.getRaw(n)); 
    i = i + j + i2 * 1 + k + i3 * 1 + m + i4 * 1 + i1 + getAllowedResponseExtensionsList().size() * 1 + this.unknownFields.getSerializedSize();
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
    if (getRequestedCount() > 0)
      i = (j * 37 + 2) * 53 + getRequestedList().hashCode(); 
    j = i;
    if (getProvidedCount() > 0)
      j = (i * 37 + 3) * 53 + getProvidedList().hashCode(); 
    i = j;
    if (getAllowedRequestExtensionsCount() > 0)
      i = (j * 37 + 4) * 53 + getAllowedRequestExtensionsList().hashCode(); 
    j = i;
    if (getAllowedResponseExtensionsCount() > 0)
      j = (i * 37 + 5) * 53 + getAllowedResponseExtensionsList().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ContextProto.d.ensureFieldAccessorsInitialized(ContextRule.class, Builder.class);
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
    int j;
    if (!getSelectorBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.selector_); 
    byte b = 0;
    int i;
    for (i = 0; i < this.requested_.size(); i++)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.requested_.getRaw(i)); 
    for (i = 0; i < this.provided_.size(); i++)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.provided_.getRaw(i)); 
    i = 0;
    while (true) {
      j = b;
      if (i < this.allowedRequestExtensions_.size()) {
        GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.allowedRequestExtensions_.getRaw(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.allowedResponseExtensions_.size()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.allowedResponseExtensions_.getRaw(j));
      j++;
    } 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ContextRuleOrBuilder {
    private LazyStringList allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
    
    private LazyStringList allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
    
    private int bitField0_;
    
    private LazyStringList provided_ = LazyStringArrayList.EMPTY;
    
    private LazyStringList requested_ = LazyStringArrayList.EMPTY;
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAllowedRequestExtensionsIsMutable() {
      if ((this.bitField0_ & 0x8) == 0) {
        this.allowedRequestExtensions_ = (LazyStringList)new LazyStringArrayList(this.allowedRequestExtensions_);
        this.bitField0_ |= 0x8;
      } 
    }
    
    private void ensureAllowedResponseExtensionsIsMutable() {
      if ((this.bitField0_ & 0x10) == 0) {
        this.allowedResponseExtensions_ = (LazyStringList)new LazyStringArrayList(this.allowedResponseExtensions_);
        this.bitField0_ |= 0x10;
      } 
    }
    
    private void ensureProvidedIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.provided_ = (LazyStringList)new LazyStringArrayList(this.provided_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    private void ensureRequestedIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.requested_ = (LazyStringList)new LazyStringArrayList(this.requested_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ContextProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      ContextRule.alwaysUseFieldBuilders;
    }
    
    public Builder addAllAllowedRequestExtensions(Iterable<String> param1Iterable) {
      ensureAllowedRequestExtensionsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.allowedRequestExtensions_);
      onChanged();
      return this;
    }
    
    public Builder addAllAllowedResponseExtensions(Iterable<String> param1Iterable) {
      ensureAllowedResponseExtensionsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.allowedResponseExtensions_);
      onChanged();
      return this;
    }
    
    public Builder addAllProvided(Iterable<String> param1Iterable) {
      ensureProvidedIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.provided_);
      onChanged();
      return this;
    }
    
    public Builder addAllRequested(Iterable<String> param1Iterable) {
      ensureRequestedIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.requested_);
      onChanged();
      return this;
    }
    
    public Builder addAllowedRequestExtensions(String param1String) {
      if (param1String != null) {
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addAllowedRequestExtensionsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ContextRule.checkByteStringIsUtf8(param1ByteString);
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addAllowedResponseExtensions(String param1String) {
      if (param1String != null) {
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addAllowedResponseExtensionsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ContextRule.checkByteStringIsUtf8(param1ByteString);
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addProvided(String param1String) {
      if (param1String != null) {
        ensureProvidedIsMutable();
        this.provided_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addProvidedBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ContextRule.checkByteStringIsUtf8(param1ByteString);
        ensureProvidedIsMutable();
        this.provided_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRequested(String param1String) {
      if (param1String != null) {
        ensureRequestedIsMutable();
        this.requested_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRequestedBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ContextRule.checkByteStringIsUtf8(param1ByteString);
        ensureRequestedIsMutable();
        this.requested_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public ContextRule build() {
      ContextRule contextRule = buildPartial();
      if (contextRule.isInitialized())
        return contextRule; 
      throw newUninitializedMessageException(contextRule);
    }
    
    public ContextRule buildPartial() {
      ContextRule contextRule = new ContextRule(this);
      int i = this.bitField0_;
      ContextRule.access$402(contextRule, this.selector_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.requested_ = this.requested_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      ContextRule.access$502(contextRule, this.requested_);
      if ((this.bitField0_ & 0x4) != 0) {
        this.provided_ = this.provided_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFB;
      } 
      ContextRule.access$602(contextRule, this.provided_);
      if ((this.bitField0_ & 0x8) != 0) {
        this.allowedRequestExtensions_ = this.allowedRequestExtensions_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFF7;
      } 
      ContextRule.access$702(contextRule, this.allowedRequestExtensions_);
      if ((this.bitField0_ & 0x10) != 0) {
        this.allowedResponseExtensions_ = this.allowedResponseExtensions_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFEF;
      } 
      ContextRule.access$802(contextRule, this.allowedResponseExtensions_);
      ContextRule.access$902(contextRule, 0);
      onBuilt();
      return contextRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      this.requested_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      this.provided_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFB;
      this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFF7;
      this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFEF;
      return this;
    }
    
    public Builder clearAllowedRequestExtensions() {
      this.allowedRequestExtensions_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFF7;
      onChanged();
      return this;
    }
    
    public Builder clearAllowedResponseExtensions() {
      this.allowedResponseExtensions_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFEF;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProvided() {
      this.provided_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFB;
      onChanged();
      return this;
    }
    
    public Builder clearRequested() {
      this.requested_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearSelector() {
      this.selector_ = ContextRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAllowedRequestExtensions(int param1Int) {
      return (String)this.allowedRequestExtensions_.get(param1Int);
    }
    
    public ByteString getAllowedRequestExtensionsBytes(int param1Int) {
      return this.allowedRequestExtensions_.getByteString(param1Int);
    }
    
    public int getAllowedRequestExtensionsCount() {
      return this.allowedRequestExtensions_.size();
    }
    
    public ProtocolStringList getAllowedRequestExtensionsList() {
      return (ProtocolStringList)this.allowedRequestExtensions_.getUnmodifiableView();
    }
    
    public String getAllowedResponseExtensions(int param1Int) {
      return (String)this.allowedResponseExtensions_.get(param1Int);
    }
    
    public ByteString getAllowedResponseExtensionsBytes(int param1Int) {
      return this.allowedResponseExtensions_.getByteString(param1Int);
    }
    
    public int getAllowedResponseExtensionsCount() {
      return this.allowedResponseExtensions_.size();
    }
    
    public ProtocolStringList getAllowedResponseExtensionsList() {
      return (ProtocolStringList)this.allowedResponseExtensions_.getUnmodifiableView();
    }
    
    public ContextRule getDefaultInstanceForType() {
      return ContextRule.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ContextProto.c;
    }
    
    public String getProvided(int param1Int) {
      return (String)this.provided_.get(param1Int);
    }
    
    public ByteString getProvidedBytes(int param1Int) {
      return this.provided_.getByteString(param1Int);
    }
    
    public int getProvidedCount() {
      return this.provided_.size();
    }
    
    public ProtocolStringList getProvidedList() {
      return (ProtocolStringList)this.provided_.getUnmodifiableView();
    }
    
    public String getRequested(int param1Int) {
      return (String)this.requested_.get(param1Int);
    }
    
    public ByteString getRequestedBytes(int param1Int) {
      return this.requested_.getByteString(param1Int);
    }
    
    public int getRequestedCount() {
      return this.requested_.size();
    }
    
    public ProtocolStringList getRequestedList() {
      return (ProtocolStringList)this.requested_.getUnmodifiableView();
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
      return ContextProto.d.ensureFieldAccessorsInitialized(ContextRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ContextRule param1ContextRule) {
      if (param1ContextRule == ContextRule.getDefaultInstance())
        return this; 
      if (!param1ContextRule.getSelector().isEmpty()) {
        this.selector_ = param1ContextRule.selector_;
        onChanged();
      } 
      if (!param1ContextRule.requested_.isEmpty()) {
        if (this.requested_.isEmpty()) {
          this.requested_ = param1ContextRule.requested_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureRequestedIsMutable();
          this.requested_.addAll((Collection)param1ContextRule.requested_);
        } 
        onChanged();
      } 
      if (!param1ContextRule.provided_.isEmpty()) {
        if (this.provided_.isEmpty()) {
          this.provided_ = param1ContextRule.provided_;
          this.bitField0_ &= 0xFFFFFFFB;
        } else {
          ensureProvidedIsMutable();
          this.provided_.addAll((Collection)param1ContextRule.provided_);
        } 
        onChanged();
      } 
      if (!param1ContextRule.allowedRequestExtensions_.isEmpty()) {
        if (this.allowedRequestExtensions_.isEmpty()) {
          this.allowedRequestExtensions_ = param1ContextRule.allowedRequestExtensions_;
          this.bitField0_ &= 0xFFFFFFF7;
        } else {
          ensureAllowedRequestExtensionsIsMutable();
          this.allowedRequestExtensions_.addAll((Collection)param1ContextRule.allowedRequestExtensions_);
        } 
        onChanged();
      } 
      if (!param1ContextRule.allowedResponseExtensions_.isEmpty()) {
        if (this.allowedResponseExtensions_.isEmpty()) {
          this.allowedResponseExtensions_ = param1ContextRule.allowedResponseExtensions_;
          this.bitField0_ &= 0xFFFFFFEF;
        } else {
          ensureAllowedResponseExtensionsIsMutable();
          this.allowedResponseExtensions_.addAll((Collection)param1ContextRule.allowedResponseExtensions_);
        } 
        onChanged();
      } 
      mergeUnknownFields(param1ContextRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ContextRule contextRule = (ContextRule)ContextRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ContextRule contextRule = (ContextRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ContextRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ContextRule)
        return mergeFrom((ContextRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAllowedRequestExtensions(int param1Int, String param1String) {
      if (param1String != null) {
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAllowedResponseExtensions(int param1Int, String param1String) {
      if (param1String != null) {
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProvided(int param1Int, String param1String) {
      if (param1String != null) {
        ensureProvidedIsMutable();
        this.provided_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequested(int param1Int, String param1String) {
      if (param1String != null) {
        ensureRequestedIsMutable();
        this.requested_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ContextRule.checkByteStringIsUtf8(param1ByteString);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ContextRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
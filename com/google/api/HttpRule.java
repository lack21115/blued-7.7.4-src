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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HttpRule extends GeneratedMessageV3 implements HttpRuleOrBuilder {
  public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
  
  public static final int BODY_FIELD_NUMBER = 7;
  
  public static final int CUSTOM_FIELD_NUMBER = 8;
  
  private static final HttpRule DEFAULT_INSTANCE = new HttpRule();
  
  public static final int DELETE_FIELD_NUMBER = 5;
  
  public static final int GET_FIELD_NUMBER = 2;
  
  private static final Parser<HttpRule> PARSER = (Parser<HttpRule>)new AbstractParser<HttpRule>() {
      public HttpRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new HttpRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PATCH_FIELD_NUMBER = 6;
  
  public static final int POST_FIELD_NUMBER = 4;
  
  public static final int PUT_FIELD_NUMBER = 3;
  
  public static final int RESPONSE_BODY_FIELD_NUMBER = 12;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private List<HttpRule> additionalBindings_;
  
  private int bitField0_;
  
  private volatile Object body_;
  
  private byte memoizedIsInitialized = -1;
  
  private int patternCase_ = 0;
  
  private Object pattern_;
  
  private volatile Object responseBody_;
  
  private volatile Object selector_;
  
  private HttpRule() {
    this.selector_ = "";
    this.body_ = "";
    this.responseBody_ = "";
    this.additionalBindings_ = Collections.emptyList();
  }
  
  private HttpRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
          CustomHttpPattern.Builder builder1;
          String str;
          int n = paramCodedInputStream.readTag();
          switch (n) {
            case 98:
              j = i;
              k = i;
              m = i;
              this.responseBody_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 90:
              n = i;
              if ((i & 0x200) == 0) {
                j = i;
                k = i;
                m = i;
                this.additionalBindings_ = new ArrayList<HttpRule>();
                n = i | 0x200;
              } 
              j = n;
              k = n;
              m = n;
              this.additionalBindings_.add(paramCodedInputStream.readMessage(parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            case 66:
              builder1 = null;
              j = i;
              k = i;
              m = i;
              if (this.patternCase_ == 8) {
                j = i;
                k = i;
                m = i;
                builder1 = ((CustomHttpPattern)this.pattern_).toBuilder();
              } 
              j = i;
              k = i;
              m = i;
              this.pattern_ = paramCodedInputStream.readMessage(CustomHttpPattern.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                j = i;
                k = i;
                m = i;
                builder1.mergeFrom((CustomHttpPattern)this.pattern_);
                j = i;
                k = i;
                m = i;
                this.pattern_ = builder1.buildPartial();
              } 
              j = i;
              k = i;
              m = i;
              this.patternCase_ = 8;
              continue;
            case 58:
              j = i;
              k = i;
              m = i;
              this.body_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 50:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              j = i;
              k = i;
              m = i;
              this.patternCase_ = 6;
              j = i;
              k = i;
              m = i;
              this.pattern_ = str;
              continue;
            case 42:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              j = i;
              k = i;
              m = i;
              this.patternCase_ = 5;
              j = i;
              k = i;
              m = i;
              this.pattern_ = str;
              continue;
            case 34:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              j = i;
              k = i;
              m = i;
              this.patternCase_ = 4;
              j = i;
              k = i;
              m = i;
              this.pattern_ = str;
              continue;
            case 26:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              j = i;
              k = i;
              m = i;
              this.patternCase_ = 3;
              j = i;
              k = i;
              m = i;
              this.pattern_ = str;
              continue;
            case 18:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              j = i;
              k = i;
              m = i;
              this.patternCase_ = 2;
              j = i;
              k = i;
              m = i;
              this.pattern_ = str;
              continue;
            case 10:
              j = i;
              k = i;
              m = i;
              this.selector_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x200) != 0)
          this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      if ((i & 0x200) != 0)
        this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private HttpRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static HttpRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return HttpProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpRule paramHttpRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramHttpRule);
  }
  
  public static HttpRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static HttpRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpRule)PARSER.parseFrom(paramByteString);
  }
  
  public static HttpRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static HttpRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static HttpRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (HttpRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static HttpRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static HttpRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof HttpRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (!getSelector().equals(paramObject.getSelector()))
      return false; 
    if (!getBody().equals(paramObject.getBody()))
      return false; 
    if (!getResponseBody().equals(paramObject.getResponseBody()))
      return false; 
    if (!getAdditionalBindingsList().equals(paramObject.getAdditionalBindingsList()))
      return false; 
    if (!getPatternCase().equals(paramObject.getPatternCase()))
      return false; 
    int i = this.patternCase_;
    if (i != 2) {
      if (i != 3) {
        if (i != 4) {
          if (i != 5) {
            if (i != 6) {
              if (i == 8 && !getCustom().equals(paramObject.getCustom()))
                return false; 
            } else if (!getPatch().equals(paramObject.getPatch())) {
              return false;
            } 
          } else if (!getDelete().equals(paramObject.getDelete())) {
            return false;
          } 
        } else if (!getPost().equals(paramObject.getPost())) {
          return false;
        } 
      } else if (!getPut().equals(paramObject.getPut())) {
        return false;
      } 
    } else if (!getGet().equals(paramObject.getGet())) {
      return false;
    } 
    return !!this.unknownFields.equals(((HttpRule)paramObject).unknownFields);
  }
  
  public HttpRule getAdditionalBindings(int paramInt) {
    return this.additionalBindings_.get(paramInt);
  }
  
  public int getAdditionalBindingsCount() {
    return this.additionalBindings_.size();
  }
  
  public List<HttpRule> getAdditionalBindingsList() {
    return this.additionalBindings_;
  }
  
  public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int paramInt) {
    return this.additionalBindings_.get(paramInt);
  }
  
  public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
    return (List)this.additionalBindings_;
  }
  
  public String getBody() {
    Object object = this.body_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.body_ = object;
    return (String)object;
  }
  
  public ByteString getBodyBytes() {
    Object object = this.body_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.body_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public CustomHttpPattern getCustom() {
    return (this.patternCase_ == 8) ? (CustomHttpPattern)this.pattern_ : CustomHttpPattern.getDefaultInstance();
  }
  
  public CustomHttpPatternOrBuilder getCustomOrBuilder() {
    return (this.patternCase_ == 8) ? (CustomHttpPattern)this.pattern_ : CustomHttpPattern.getDefaultInstance();
  }
  
  public HttpRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getDelete() {
    if (this.patternCase_ == 5) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String)
      return (String)object; 
    Object object = ((ByteString)object).toStringUtf8();
    if (this.patternCase_ == 5)
      this.pattern_ = object; 
    return (String)object;
  }
  
  public ByteString getDeleteBytes() {
    Object object;
    if (this.patternCase_ == 5) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      if (this.patternCase_ == 5)
        this.pattern_ = object; 
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getGet() {
    if (this.patternCase_ == 2) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String)
      return (String)object; 
    Object object = ((ByteString)object).toStringUtf8();
    if (this.patternCase_ == 2)
      this.pattern_ = object; 
    return (String)object;
  }
  
  public ByteString getGetBytes() {
    Object object;
    if (this.patternCase_ == 2) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      if (this.patternCase_ == 2)
        this.pattern_ = object; 
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<HttpRule> getParserForType() {
    return PARSER;
  }
  
  public String getPatch() {
    if (this.patternCase_ == 6) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String)
      return (String)object; 
    Object object = ((ByteString)object).toStringUtf8();
    if (this.patternCase_ == 6)
      this.pattern_ = object; 
    return (String)object;
  }
  
  public ByteString getPatchBytes() {
    Object object;
    if (this.patternCase_ == 6) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      if (this.patternCase_ == 6)
        this.pattern_ = object; 
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public PatternCase getPatternCase() {
    return PatternCase.forNumber(this.patternCase_);
  }
  
  public String getPost() {
    if (this.patternCase_ == 4) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String)
      return (String)object; 
    Object object = ((ByteString)object).toStringUtf8();
    if (this.patternCase_ == 4)
      this.pattern_ = object; 
    return (String)object;
  }
  
  public ByteString getPostBytes() {
    Object object;
    if (this.patternCase_ == 4) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      if (this.patternCase_ == 4)
        this.pattern_ = object; 
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getPut() {
    if (this.patternCase_ == 3) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String)
      return (String)object; 
    Object object = ((ByteString)object).toStringUtf8();
    if (this.patternCase_ == 3)
      this.pattern_ = object; 
    return (String)object;
  }
  
  public ByteString getPutBytes() {
    Object object;
    if (this.patternCase_ == 3) {
      object = this.pattern_;
    } else {
      object = "";
    } 
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      if (this.patternCase_ == 3)
        this.pattern_ = object; 
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getResponseBody() {
    Object object = this.responseBody_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.responseBody_ = object;
    return (String)object;
  }
  
  public ByteString getResponseBodyBytes() {
    Object object = this.responseBody_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.responseBody_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
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
    byte b = 0;
    if (!bool) {
      j = GeneratedMessageV3.computeStringSize(1, this.selector_) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (this.patternCase_ == 2)
      i = j + GeneratedMessageV3.computeStringSize(2, this.pattern_); 
    int j = i;
    if (this.patternCase_ == 3)
      j = i + GeneratedMessageV3.computeStringSize(3, this.pattern_); 
    i = j;
    if (this.patternCase_ == 4)
      i = j + GeneratedMessageV3.computeStringSize(4, this.pattern_); 
    j = i;
    if (this.patternCase_ == 5)
      j = i + GeneratedMessageV3.computeStringSize(5, this.pattern_); 
    i = j;
    if (this.patternCase_ == 6)
      i = j + GeneratedMessageV3.computeStringSize(6, this.pattern_); 
    j = i;
    if (!getBodyBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(7, this.body_); 
    i = j;
    int k = b;
    if (this.patternCase_ == 8) {
      i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)this.pattern_);
      k = b;
    } 
    while (k < this.additionalBindings_.size()) {
      i += CodedOutputStream.computeMessageSize(11, (MessageLite)this.additionalBindings_.get(k));
      k++;
    } 
    j = i;
    if (!getResponseBodyBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(12, this.responseBody_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasCustom() {
    return (this.patternCase_ == 8);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode()) * 37 + 7) * 53 + getBody().hashCode()) * 37 + 12) * 53 + getResponseBody().hashCode();
    int i = j;
    if (getAdditionalBindingsCount() > 0)
      i = (j * 37 + 11) * 53 + getAdditionalBindingsList().hashCode(); 
    j = this.patternCase_;
    if (j != 2) {
      if (j != 3) {
        if (j != 4) {
          if (j != 5) {
            if (j != 6) {
              if (j != 8) {
                i = i * 29 + this.unknownFields.hashCode();
                this.memoizedHashCode = i;
                return i;
              } 
              i = (i * 37 + 8) * 53;
              j = getCustom().hashCode();
            } else {
              i = (i * 37 + 6) * 53;
              j = getPatch().hashCode();
            } 
          } else {
            i = (i * 37 + 5) * 53;
            j = getDelete().hashCode();
          } 
        } else {
          i = (i * 37 + 4) * 53;
          j = getPost().hashCode();
        } 
      } else {
        i = (i * 37 + 3) * 53;
        j = getPut().hashCode();
      } 
    } else {
      i = (i * 37 + 2) * 53;
      j = getGet().hashCode();
    } 
    i += j;
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return HttpProto.d.ensureFieldAccessorsInitialized(HttpRule.class, Builder.class);
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
    if (this.patternCase_ == 2)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.pattern_); 
    if (this.patternCase_ == 3)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.pattern_); 
    if (this.patternCase_ == 4)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.pattern_); 
    if (this.patternCase_ == 5)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.pattern_); 
    if (this.patternCase_ == 6)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.pattern_); 
    if (!getBodyBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.body_); 
    if (this.patternCase_ == 8)
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.pattern_); 
    for (int i = 0; i < this.additionalBindings_.size(); i++)
      paramCodedOutputStream.writeMessage(11, (MessageLite)this.additionalBindings_.get(i)); 
    if (!getResponseBodyBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 12, this.responseBody_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpRuleOrBuilder {
    private RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> additionalBindingsBuilder_;
    
    private List<HttpRule> additionalBindings_ = Collections.emptyList();
    
    private int bitField0_;
    
    private Object body_ = "";
    
    private SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> customBuilder_;
    
    private int patternCase_ = 0;
    
    private Object pattern_;
    
    private Object responseBody_ = "";
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAdditionalBindingsIsMutable() {
      if ((this.bitField0_ & 0x200) == 0) {
        this.additionalBindings_ = new ArrayList<HttpRule>(this.additionalBindings_);
        this.bitField0_ |= 0x200;
      } 
    }
    
    private RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> getAdditionalBindingsFieldBuilder() {
      if (this.additionalBindingsBuilder_ == null) {
        boolean bool;
        List<HttpRule> list = this.additionalBindings_;
        if ((this.bitField0_ & 0x200) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.additionalBindingsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.additionalBindings_ = null;
      } 
      return this.additionalBindingsBuilder_;
    }
    
    private SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> getCustomFieldBuilder() {
      if (this.customBuilder_ == null) {
        if (this.patternCase_ != 8)
          this.pattern_ = CustomHttpPattern.getDefaultInstance(); 
        this.customBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.pattern_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.pattern_ = null;
      } 
      this.patternCase_ = 8;
      onChanged();
      return this.customBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return HttpProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      if (HttpRule.alwaysUseFieldBuilders)
        getAdditionalBindingsFieldBuilder(); 
    }
    
    public Builder addAdditionalBindings(int param1Int, Builder param1Builder) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAdditionalBindings(int param1Int, HttpRule param1HttpRule) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1HttpRule != null) {
          ensureAdditionalBindingsIsMutable();
          this.additionalBindings_.add(param1Int, param1HttpRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1HttpRule);
      return this;
    }
    
    public Builder addAdditionalBindings(Builder param1Builder) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAdditionalBindings(HttpRule param1HttpRule) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1HttpRule != null) {
          ensureAdditionalBindingsIsMutable();
          this.additionalBindings_.add(param1HttpRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1HttpRule);
      return this;
    }
    
    public Builder addAdditionalBindingsBuilder() {
      return (Builder)getAdditionalBindingsFieldBuilder().addBuilder((AbstractMessage)HttpRule.getDefaultInstance());
    }
    
    public Builder addAdditionalBindingsBuilder(int param1Int) {
      return (Builder)getAdditionalBindingsFieldBuilder().addBuilder(param1Int, (AbstractMessage)HttpRule.getDefaultInstance());
    }
    
    public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> param1Iterable) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdditionalBindingsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.additionalBindings_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public HttpRule build() {
      HttpRule httpRule = buildPartial();
      if (httpRule.isInitialized())
        return httpRule; 
      throw newUninitializedMessageException(httpRule);
    }
    
    public HttpRule buildPartial() {
      HttpRule httpRule = new HttpRule(this);
      int i = this.bitField0_;
      HttpRule.access$402(httpRule, this.selector_);
      if (this.patternCase_ == 2)
        HttpRule.access$502(httpRule, this.pattern_); 
      if (this.patternCase_ == 3)
        HttpRule.access$502(httpRule, this.pattern_); 
      if (this.patternCase_ == 4)
        HttpRule.access$502(httpRule, this.pattern_); 
      if (this.patternCase_ == 5)
        HttpRule.access$502(httpRule, this.pattern_); 
      if (this.patternCase_ == 6)
        HttpRule.access$502(httpRule, this.pattern_); 
      if (this.patternCase_ == 8) {
        SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
        if (singleFieldBuilderV3 == null) {
          HttpRule.access$502(httpRule, this.pattern_);
        } else {
          HttpRule.access$502(httpRule, singleFieldBuilderV3.build());
        } 
      } 
      HttpRule.access$602(httpRule, this.body_);
      HttpRule.access$702(httpRule, this.responseBody_);
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x200) != 0) {
          this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_);
          this.bitField0_ &= 0xFFFFFDFF;
        } 
        HttpRule.access$802(httpRule, this.additionalBindings_);
      } else {
        HttpRule.access$802(httpRule, repeatedFieldBuilderV3.build());
      } 
      HttpRule.access$902(httpRule, 0);
      HttpRule.access$1002(httpRule, this.patternCase_);
      onBuilt();
      return httpRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      this.body_ = "";
      this.responseBody_ = "";
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.additionalBindings_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFDFF;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.patternCase_ = 0;
      this.pattern_ = null;
      return this;
    }
    
    public Builder clearAdditionalBindings() {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.additionalBindings_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFDFF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearBody() {
      this.body_ = HttpRule.getDefaultInstance().getBody();
      onChanged();
      return this;
    }
    
    public Builder clearCustom() {
      if (this.customBuilder_ == null) {
        if (this.patternCase_ == 8) {
          this.patternCase_ = 0;
          this.pattern_ = null;
          onChanged();
          return this;
        } 
      } else {
        if (this.patternCase_ == 8) {
          this.patternCase_ = 0;
          this.pattern_ = null;
        } 
        this.customBuilder_.clear();
      } 
      return this;
    }
    
    public Builder clearDelete() {
      if (this.patternCase_ == 5) {
        this.patternCase_ = 0;
        this.pattern_ = null;
        onChanged();
      } 
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearGet() {
      if (this.patternCase_ == 2) {
        this.patternCase_ = 0;
        this.pattern_ = null;
        onChanged();
      } 
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPatch() {
      if (this.patternCase_ == 6) {
        this.patternCase_ = 0;
        this.pattern_ = null;
        onChanged();
      } 
      return this;
    }
    
    public Builder clearPattern() {
      this.patternCase_ = 0;
      this.pattern_ = null;
      onChanged();
      return this;
    }
    
    public Builder clearPost() {
      if (this.patternCase_ == 4) {
        this.patternCase_ = 0;
        this.pattern_ = null;
        onChanged();
      } 
      return this;
    }
    
    public Builder clearPut() {
      if (this.patternCase_ == 3) {
        this.patternCase_ = 0;
        this.pattern_ = null;
        onChanged();
      } 
      return this;
    }
    
    public Builder clearResponseBody() {
      this.responseBody_ = HttpRule.getDefaultInstance().getResponseBody();
      onChanged();
      return this;
    }
    
    public Builder clearSelector() {
      this.selector_ = HttpRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public HttpRule getAdditionalBindings(int param1Int) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.additionalBindings_.get(param1Int) : (HttpRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Builder getAdditionalBindingsBuilder(int param1Int) {
      return (Builder)getAdditionalBindingsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Builder> getAdditionalBindingsBuilderList() {
      return getAdditionalBindingsFieldBuilder().getBuilderList();
    }
    
    public int getAdditionalBindingsCount() {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.additionalBindings_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<HttpRule> getAdditionalBindingsList() {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.additionalBindings_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.additionalBindings_.get(param1Int) : (HttpRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.additionalBindings_);
    }
    
    public String getBody() {
      Object object = this.body_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.body_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getBodyBytes() {
      Object object = this.body_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.body_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public CustomHttpPattern getCustom() {
      SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
      return (singleFieldBuilderV3 == null) ? ((this.patternCase_ == 8) ? (CustomHttpPattern)this.pattern_ : CustomHttpPattern.getDefaultInstance()) : ((this.patternCase_ == 8) ? (CustomHttpPattern)singleFieldBuilderV3.getMessage() : CustomHttpPattern.getDefaultInstance());
    }
    
    public CustomHttpPattern.Builder getCustomBuilder() {
      return (CustomHttpPattern.Builder)getCustomFieldBuilder().getBuilder();
    }
    
    public CustomHttpPatternOrBuilder getCustomOrBuilder() {
      if (this.patternCase_ == 8) {
        SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
        if (singleFieldBuilderV3 != null)
          return (CustomHttpPatternOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      } 
      return (this.patternCase_ == 8) ? (CustomHttpPattern)this.pattern_ : CustomHttpPattern.getDefaultInstance();
    }
    
    public HttpRule getDefaultInstanceForType() {
      return HttpRule.getDefaultInstance();
    }
    
    public String getDelete() {
      Object object;
      if (this.patternCase_ == 5) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        if (this.patternCase_ == 5)
          this.pattern_ = object; 
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDeleteBytes() {
      Object object;
      if (this.patternCase_ == 5) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        if (this.patternCase_ == 5)
          this.pattern_ = object; 
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return HttpProto.c;
    }
    
    public String getGet() {
      Object object;
      if (this.patternCase_ == 2) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        if (this.patternCase_ == 2)
          this.pattern_ = object; 
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getGetBytes() {
      Object object;
      if (this.patternCase_ == 2) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        if (this.patternCase_ == 2)
          this.pattern_ = object; 
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPatch() {
      Object object;
      if (this.patternCase_ == 6) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        if (this.patternCase_ == 6)
          this.pattern_ = object; 
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPatchBytes() {
      Object object;
      if (this.patternCase_ == 6) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        if (this.patternCase_ == 6)
          this.pattern_ = object; 
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public HttpRule.PatternCase getPatternCase() {
      return HttpRule.PatternCase.forNumber(this.patternCase_);
    }
    
    public String getPost() {
      Object object;
      if (this.patternCase_ == 4) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        if (this.patternCase_ == 4)
          this.pattern_ = object; 
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPostBytes() {
      Object object;
      if (this.patternCase_ == 4) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        if (this.patternCase_ == 4)
          this.pattern_ = object; 
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPut() {
      Object object;
      if (this.patternCase_ == 3) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        if (this.patternCase_ == 3)
          this.pattern_ = object; 
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPutBytes() {
      Object object;
      if (this.patternCase_ == 3) {
        object = this.pattern_;
      } else {
        object = "";
      } 
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        if (this.patternCase_ == 3)
          this.pattern_ = object; 
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getResponseBody() {
      Object object = this.responseBody_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.responseBody_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResponseBodyBytes() {
      Object object = this.responseBody_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.responseBody_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public boolean hasCustom() {
      return (this.patternCase_ == 8);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return HttpProto.d.ensureFieldAccessorsInitialized(HttpRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeCustom(CustomHttpPattern param1CustomHttpPattern) {
      SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (this.patternCase_ == 8 && this.pattern_ != CustomHttpPattern.getDefaultInstance()) {
          this.pattern_ = CustomHttpPattern.newBuilder((CustomHttpPattern)this.pattern_).mergeFrom(param1CustomHttpPattern).buildPartial();
        } else {
          this.pattern_ = param1CustomHttpPattern;
        } 
        onChanged();
      } else {
        if (this.patternCase_ == 8)
          singleFieldBuilderV3.mergeFrom((AbstractMessage)param1CustomHttpPattern); 
        this.customBuilder_.setMessage((AbstractMessage)param1CustomHttpPattern);
      } 
      this.patternCase_ = 8;
      return this;
    }
    
    public Builder mergeFrom(HttpRule param1HttpRule) {
      if (param1HttpRule == HttpRule.getDefaultInstance())
        return this; 
      if (!param1HttpRule.getSelector().isEmpty()) {
        this.selector_ = param1HttpRule.selector_;
        onChanged();
      } 
      if (!param1HttpRule.getBody().isEmpty()) {
        this.body_ = param1HttpRule.body_;
        onChanged();
      } 
      if (!param1HttpRule.getResponseBody().isEmpty()) {
        this.responseBody_ = param1HttpRule.responseBody_;
        onChanged();
      } 
      if (this.additionalBindingsBuilder_ == null) {
        if (!param1HttpRule.additionalBindings_.isEmpty()) {
          if (this.additionalBindings_.isEmpty()) {
            this.additionalBindings_ = param1HttpRule.additionalBindings_;
            this.bitField0_ &= 0xFFFFFDFF;
          } else {
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.addAll(param1HttpRule.additionalBindings_);
          } 
          onChanged();
        } 
      } else if (!param1HttpRule.additionalBindings_.isEmpty()) {
        if (this.additionalBindingsBuilder_.isEmpty()) {
          this.additionalBindingsBuilder_.dispose();
          RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = null;
          this.additionalBindingsBuilder_ = null;
          this.additionalBindings_ = param1HttpRule.additionalBindings_;
          this.bitField0_ &= 0xFFFFFDFF;
          if (HttpRule.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getAdditionalBindingsFieldBuilder(); 
          this.additionalBindingsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.additionalBindingsBuilder_.addAllMessages(param1HttpRule.additionalBindings_);
        } 
      } 
      switch (HttpRule.null.a[param1HttpRule.getPatternCase().ordinal()]) {
        default:
          mergeUnknownFields(param1HttpRule.unknownFields);
          onChanged();
          return this;
        case 6:
          mergeCustom(param1HttpRule.getCustom());
        case 5:
          this.patternCase_ = 6;
          this.pattern_ = param1HttpRule.pattern_;
          onChanged();
        case 4:
          this.patternCase_ = 5;
          this.pattern_ = param1HttpRule.pattern_;
          onChanged();
        case 3:
          this.patternCase_ = 4;
          this.pattern_ = param1HttpRule.pattern_;
          onChanged();
        case 2:
          this.patternCase_ = 3;
          this.pattern_ = param1HttpRule.pattern_;
          onChanged();
        case 1:
          break;
      } 
      this.patternCase_ = 2;
      this.pattern_ = param1HttpRule.pattern_;
      onChanged();
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        HttpRule httpRule = (HttpRule)HttpRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        HttpRule httpRule = (HttpRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((HttpRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof HttpRule)
        return mergeFrom((HttpRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeAdditionalBindings(int param1Int) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setAdditionalBindings(int param1Int, Builder param1Builder) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAdditionalBindingsIsMutable();
        this.additionalBindings_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAdditionalBindings(int param1Int, HttpRule param1HttpRule) {
      RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1HttpRule != null) {
          ensureAdditionalBindingsIsMutable();
          this.additionalBindings_.set(param1Int, param1HttpRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1HttpRule);
      return this;
    }
    
    public Builder setBody(String param1String) {
      if (param1String != null) {
        this.body_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBodyBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.body_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCustom(CustomHttpPattern.Builder param1Builder) {
      SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.pattern_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.patternCase_ = 8;
      return this;
    }
    
    public Builder setCustom(CustomHttpPattern param1CustomHttpPattern) {
      SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1CustomHttpPattern != null) {
          this.pattern_ = param1CustomHttpPattern;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1CustomHttpPattern);
      } 
      this.patternCase_ = 8;
      return this;
    }
    
    public Builder setDelete(String param1String) {
      if (param1String != null) {
        this.patternCase_ = 5;
        this.pattern_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDeleteBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.patternCase_ = 5;
        this.pattern_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setGet(String param1String) {
      if (param1String != null) {
        this.patternCase_ = 2;
        this.pattern_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGetBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.patternCase_ = 2;
        this.pattern_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPatch(String param1String) {
      if (param1String != null) {
        this.patternCase_ = 6;
        this.pattern_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPatchBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.patternCase_ = 6;
        this.pattern_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPost(String param1String) {
      if (param1String != null) {
        this.patternCase_ = 4;
        this.pattern_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPostBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.patternCase_ = 4;
        this.pattern_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPut(String param1String) {
      if (param1String != null) {
        this.patternCase_ = 3;
        this.pattern_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPutBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.patternCase_ = 3;
        this.pattern_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setResponseBody(String param1String) {
      if (param1String != null) {
        this.responseBody_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResponseBodyBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpRule.checkByteStringIsUtf8(param1ByteString);
        this.responseBody_ = param1ByteString;
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
        HttpRule.checkByteStringIsUtf8(param1ByteString);
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
  
  public enum PatternCase implements Internal.EnumLite {
    CUSTOM,
    DELETE,
    GET(2),
    PATCH(2),
    PATTERN_NOT_SET(2),
    POST(2),
    PUT(3);
    
    private final int value;
    
    static {
      DELETE = new PatternCase("DELETE", 3, 5);
      PATCH = new PatternCase("PATCH", 4, 6);
      CUSTOM = new PatternCase("CUSTOM", 5, 8);
      PATTERN_NOT_SET = new PatternCase("PATTERN_NOT_SET", 6, 0);
      $VALUES = new PatternCase[] { GET, PUT, POST, DELETE, PATCH, CUSTOM, PATTERN_NOT_SET };
    }
    
    PatternCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PatternCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 8) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? ((param1Int != 6) ? null : PATCH) : DELETE) : POST) : PUT) : GET) : CUSTOM) : PATTERN_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
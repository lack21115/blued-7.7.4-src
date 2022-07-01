package com.google.api;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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

public final class HttpBody extends GeneratedMessageV3 implements HttpBodyOrBuilder {
  public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
  
  public static final int DATA_FIELD_NUMBER = 2;
  
  private static final HttpBody DEFAULT_INSTANCE = new HttpBody();
  
  public static final int EXTENSIONS_FIELD_NUMBER = 3;
  
  private static final Parser<HttpBody> PARSER = (Parser<HttpBody>)new AbstractParser<HttpBody>() {
      public HttpBody a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new HttpBody(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object contentType_;
  
  private ByteString data_;
  
  private List<Any> extensions_;
  
  private byte memoizedIsInitialized = -1;
  
  private HttpBody() {
    this.contentType_ = "";
    this.data_ = ByteString.EMPTY;
    this.extensions_ = Collections.emptyList();
  }
  
  private HttpBody(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                  j = i;
                  k = i;
                  m = i;
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                    continue; 
                  continue;
                } 
                n = i;
                if ((i & 0x4) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.extensions_ = new ArrayList<Any>();
                  n = i | 0x4;
                } 
                j = n;
                k = n;
                m = n;
                this.extensions_.add(paramCodedInputStream.readMessage(Any.parser(), paramExtensionRegistryLite));
                i = n;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.data_ = paramCodedInputStream.readBytes();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.contentType_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x4) != 0)
          this.extensions_ = Collections.unmodifiableList(this.extensions_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x4) != 0)
        this.extensions_ = Collections.unmodifiableList(this.extensions_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private HttpBody(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static HttpBody getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return HttpBodyProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpBody paramHttpBody) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramHttpBody);
  }
  
  public static HttpBody parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpBody)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static HttpBody parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpBody)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpBody)PARSER.parseFrom(paramByteString);
  }
  
  public static HttpBody parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpBody)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpBody)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static HttpBody parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpBody)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpBody)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static HttpBody parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpBody)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (HttpBody)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static HttpBody parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpBody)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpBody)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static HttpBody parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpBody)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpBody> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof HttpBody))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getContentType().equals(paramObject.getContentType()) ? false : (!getData().equals(paramObject.getData()) ? false : (!getExtensionsList().equals(paramObject.getExtensionsList()) ? false : (!!this.unknownFields.equals(((HttpBody)paramObject).unknownFields))));
  }
  
  public String getContentType() {
    Object object = this.contentType_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.contentType_ = object;
    return (String)object;
  }
  
  public ByteString getContentTypeBytes() {
    Object object = this.contentType_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.contentType_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public ByteString getData() {
    return this.data_;
  }
  
  public HttpBody getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Any getExtensions(int paramInt) {
    return this.extensions_.get(paramInt);
  }
  
  public int getExtensionsCount() {
    return this.extensions_.size();
  }
  
  public List<Any> getExtensionsList() {
    return this.extensions_;
  }
  
  public AnyOrBuilder getExtensionsOrBuilder(int paramInt) {
    return (AnyOrBuilder)this.extensions_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getExtensionsOrBuilderList() {
    return (List)this.extensions_;
  }
  
  public Parser<HttpBody> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    byte b1;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getContentTypeBytes().isEmpty();
    byte b2 = 0;
    if (!bool) {
      b1 = GeneratedMessageV3.computeStringSize(1, this.contentType_) + 0;
    } else {
      b1 = 0;
    } 
    i = b1;
    int j = b2;
    if (!this.data_.isEmpty()) {
      i = b1 + CodedOutputStream.computeBytesSize(2, this.data_);
      j = b2;
    } 
    while (j < this.extensions_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.extensions_.get(j));
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
    int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getContentType().hashCode()) * 37 + 2) * 53 + getData().hashCode();
    int i = j;
    if (getExtensionsCount() > 0)
      i = (j * 37 + 3) * 53 + getExtensionsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return HttpBodyProto.b.ensureFieldAccessorsInitialized(HttpBody.class, Builder.class);
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
    if (!getContentTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.contentType_); 
    if (!this.data_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.data_); 
    for (int i = 0; i < this.extensions_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.extensions_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpBodyOrBuilder {
    private int bitField0_;
    
    private Object contentType_ = "";
    
    private ByteString data_ = ByteString.EMPTY;
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extensionsBuilder_;
    
    private List<Any> extensions_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureExtensionsIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.extensions_ = new ArrayList<Any>(this.extensions_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return HttpBodyProto.a;
    }
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtensionsFieldBuilder() {
      if (this.extensionsBuilder_ == null) {
        boolean bool;
        List<Any> list = this.extensions_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.extensionsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.extensions_ = null;
      } 
      return this.extensionsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (HttpBody.alwaysUseFieldBuilders)
        getExtensionsFieldBuilder(); 
    }
    
    public Builder addAllExtensions(Iterable<? extends Any> param1Iterable) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExtensionsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.extensions_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addExtensions(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExtensionsIsMutable();
        this.extensions_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addExtensions(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureExtensionsIsMutable();
          this.extensions_.add(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public Builder addExtensions(Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExtensionsIsMutable();
        this.extensions_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addExtensions(Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureExtensionsIsMutable();
          this.extensions_.add(param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Any.Builder addExtensionsBuilder() {
      return (Any.Builder)getExtensionsFieldBuilder().addBuilder((AbstractMessage)Any.getDefaultInstance());
    }
    
    public Any.Builder addExtensionsBuilder(int param1Int) {
      return (Any.Builder)getExtensionsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Any.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public HttpBody build() {
      HttpBody httpBody = buildPartial();
      if (httpBody.isInitialized())
        return httpBody; 
      throw newUninitializedMessageException(httpBody);
    }
    
    public HttpBody buildPartial() {
      HttpBody httpBody = new HttpBody(this);
      int i = this.bitField0_;
      HttpBody.access$402(httpBody, this.contentType_);
      HttpBody.access$502(httpBody, this.data_);
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.extensions_ = Collections.unmodifiableList(this.extensions_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        HttpBody.access$602(httpBody, this.extensions_);
      } else {
        HttpBody.access$602(httpBody, repeatedFieldBuilderV3.build());
      } 
      HttpBody.access$702(httpBody, 0);
      onBuilt();
      return httpBody;
    }
    
    public Builder clear() {
      super.clear();
      this.contentType_ = "";
      this.data_ = ByteString.EMPTY;
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.extensions_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearContentType() {
      this.contentType_ = HttpBody.getDefaultInstance().getContentType();
      onChanged();
      return this;
    }
    
    public Builder clearData() {
      this.data_ = HttpBody.getDefaultInstance().getData();
      onChanged();
      return this;
    }
    
    public Builder clearExtensions() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.extensions_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        onChanged();
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
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getContentType() {
      Object object = this.contentType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.contentType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getContentTypeBytes() {
      Object object = this.contentType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.contentType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public ByteString getData() {
      return this.data_;
    }
    
    public HttpBody getDefaultInstanceForType() {
      return HttpBody.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return HttpBodyProto.a;
    }
    
    public Any getExtensions(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.extensions_.get(param1Int) : (Any)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Any.Builder getExtensionsBuilder(int param1Int) {
      return (Any.Builder)getExtensionsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Any.Builder> getExtensionsBuilderList() {
      return getExtensionsFieldBuilder().getBuilderList();
    }
    
    public int getExtensionsCount() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.extensions_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Any> getExtensionsList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.extensions_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AnyOrBuilder getExtensionsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (AnyOrBuilder)this.extensions_.get(param1Int) : (AnyOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AnyOrBuilder> getExtensionsOrBuilderList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.extensions_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return HttpBodyProto.b.ensureFieldAccessorsInitialized(HttpBody.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(HttpBody param1HttpBody) {
      if (param1HttpBody == HttpBody.getDefaultInstance())
        return this; 
      if (!param1HttpBody.getContentType().isEmpty()) {
        this.contentType_ = param1HttpBody.contentType_;
        onChanged();
      } 
      if (param1HttpBody.getData() != ByteString.EMPTY)
        setData(param1HttpBody.getData()); 
      if (this.extensionsBuilder_ == null) {
        if (!param1HttpBody.extensions_.isEmpty()) {
          if (this.extensions_.isEmpty()) {
            this.extensions_ = param1HttpBody.extensions_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureExtensionsIsMutable();
            this.extensions_.addAll(param1HttpBody.extensions_);
          } 
          onChanged();
        } 
      } else if (!param1HttpBody.extensions_.isEmpty()) {
        if (this.extensionsBuilder_.isEmpty()) {
          this.extensionsBuilder_.dispose();
          RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = null;
          this.extensionsBuilder_ = null;
          this.extensions_ = param1HttpBody.extensions_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (HttpBody.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getExtensionsFieldBuilder(); 
          this.extensionsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.extensionsBuilder_.addAllMessages(param1HttpBody.extensions_);
        } 
      } 
      mergeUnknownFields(param1HttpBody.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        HttpBody httpBody = (HttpBody)HttpBody.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        HttpBody httpBody = (HttpBody)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((HttpBody)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof HttpBody)
        return mergeFrom((HttpBody)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeExtensions(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExtensionsIsMutable();
        this.extensions_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setContentType(String param1String) {
      if (param1String != null) {
        this.contentType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setContentTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        HttpBody.checkByteStringIsUtf8(param1ByteString);
        this.contentType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setData(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.data_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExtensions(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExtensionsIsMutable();
        this.extensions_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExtensions(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureExtensionsIsMutable();
          this.extensions_.set(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
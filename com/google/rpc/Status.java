package com.google.rpc;

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

public final class Status extends GeneratedMessageV3 implements StatusOrBuilder {
  public static final int CODE_FIELD_NUMBER = 1;
  
  private static final Status DEFAULT_INSTANCE = new Status();
  
  public static final int DETAILS_FIELD_NUMBER = 3;
  
  public static final int MESSAGE_FIELD_NUMBER = 2;
  
  private static final Parser<Status> PARSER = (Parser<Status>)new AbstractParser<Status>() {
      public Status a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Status(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private int code_;
  
  private List<Any> details_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object message_;
  
  private Status() {
    this.message_ = "";
    this.details_ = Collections.emptyList();
  }
  
  private Status(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            if (n != 8) {
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
                  this.details_ = new ArrayList<Any>();
                  n = i | 0x4;
                } 
                j = n;
                k = n;
                m = n;
                this.details_.add(paramCodedInputStream.readMessage(Any.parser(), paramExtensionRegistryLite));
                i = n;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.message_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.code_ = paramCodedInputStream.readInt32();
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
          this.details_ = Collections.unmodifiableList(this.details_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x4) != 0)
        this.details_ = Collections.unmodifiableList(this.details_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Status(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Status getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return StatusProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Status paramStatus) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramStatus);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Status)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Status)PARSER.parseFrom(paramByteString);
  }
  
  public static Status parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Status)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(InputStream paramInputStream) throws IOException {
    return (Status)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Status parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Status)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Status parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Status)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Status parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Status> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Status))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getCode() != paramObject.getCode()) ? false : (!getMessage().equals(paramObject.getMessage()) ? false : (!getDetailsList().equals(paramObject.getDetailsList()) ? false : (!!this.unknownFields.equals(((Status)paramObject).unknownFields))));
  }
  
  public int getCode() {
    return this.code_;
  }
  
  public Status getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Any getDetails(int paramInt) {
    return this.details_.get(paramInt);
  }
  
  public int getDetailsCount() {
    return this.details_.size();
  }
  
  public List<Any> getDetailsList() {
    return this.details_;
  }
  
  public AnyOrBuilder getDetailsOrBuilder(int paramInt) {
    return (AnyOrBuilder)this.details_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
    return (List)this.details_;
  }
  
  public String getMessage() {
    Object object = this.message_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.message_ = object;
    return (String)object;
  }
  
  public ByteString getMessageBytes() {
    Object object = this.message_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.message_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<Status> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    byte b1;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = this.code_;
    byte b2 = 0;
    if (i != 0) {
      b1 = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      b1 = 0;
    } 
    i = b1;
    int j = b2;
    if (!getMessageBytes().isEmpty()) {
      i = b1 + GeneratedMessageV3.computeStringSize(2, this.message_);
      j = b2;
    } 
    while (j < this.details_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.details_.get(j));
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
    int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getCode()) * 37 + 2) * 53 + getMessage().hashCode();
    int i = j;
    if (getDetailsCount() > 0)
      i = (j * 37 + 3) * 53 + getDetailsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return StatusProto.b.ensureFieldAccessorsInitialized(Status.class, Builder.class);
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
    int i = this.code_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!getMessageBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.message_); 
    for (i = 0; i < this.details_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.details_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StatusOrBuilder {
    private int bitField0_;
    
    private int code_;
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> detailsBuilder_;
    
    private List<Any> details_ = Collections.emptyList();
    
    private Object message_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureDetailsIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.details_ = new ArrayList<Any>(this.details_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return StatusProto.a;
    }
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getDetailsFieldBuilder() {
      if (this.detailsBuilder_ == null) {
        boolean bool;
        List<Any> list = this.details_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.detailsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.details_ = null;
      } 
      return this.detailsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Status.alwaysUseFieldBuilders)
        getDetailsFieldBuilder(); 
    }
    
    public Builder addAllDetails(Iterable<? extends Any> param1Iterable) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureDetailsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.details_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addDetails(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureDetailsIsMutable();
        this.details_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addDetails(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureDetailsIsMutable();
          this.details_.add(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public Builder addDetails(Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureDetailsIsMutable();
        this.details_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addDetails(Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureDetailsIsMutable();
          this.details_.add(param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Any.Builder addDetailsBuilder() {
      return (Any.Builder)getDetailsFieldBuilder().addBuilder((AbstractMessage)Any.getDefaultInstance());
    }
    
    public Any.Builder addDetailsBuilder(int param1Int) {
      return (Any.Builder)getDetailsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Any.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Status build() {
      Status status = buildPartial();
      if (status.isInitialized())
        return status; 
      throw newUninitializedMessageException(status);
    }
    
    public Status buildPartial() {
      Status status = new Status(this);
      int i = this.bitField0_;
      Status.access$402(status, this.code_);
      Status.access$502(status, this.message_);
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.details_ = Collections.unmodifiableList(this.details_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        Status.access$602(status, this.details_);
      } else {
        Status.access$602(status, repeatedFieldBuilderV3.build());
      } 
      Status.access$702(status, 0);
      onBuilt();
      return status;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      this.message_ = "";
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.details_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearCode() {
      this.code_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearDetails() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.details_ = Collections.emptyList();
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
    
    public Builder clearMessage() {
      this.message_ = Status.getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public int getCode() {
      return this.code_;
    }
    
    public Status getDefaultInstanceForType() {
      return Status.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return StatusProto.a;
    }
    
    public Any getDetails(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.details_.get(param1Int) : (Any)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Any.Builder getDetailsBuilder(int param1Int) {
      return (Any.Builder)getDetailsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Any.Builder> getDetailsBuilderList() {
      return getDetailsFieldBuilder().getBuilderList();
    }
    
    public int getDetailsCount() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.details_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Any> getDetailsList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.details_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AnyOrBuilder getDetailsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (AnyOrBuilder)this.details_.get(param1Int) : (AnyOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.details_);
    }
    
    public String getMessage() {
      Object object = this.message_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.message_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMessageBytes() {
      Object object = this.message_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.message_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return StatusProto.b.ensureFieldAccessorsInitialized(Status.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Status status = (Status)Status.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Status status = (Status)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Status)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Status)
        return mergeFrom((Status)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Status param1Status) {
      if (param1Status == Status.getDefaultInstance())
        return this; 
      if (param1Status.getCode() != 0)
        setCode(param1Status.getCode()); 
      if (!param1Status.getMessage().isEmpty()) {
        this.message_ = param1Status.message_;
        onChanged();
      } 
      if (this.detailsBuilder_ == null) {
        if (!param1Status.details_.isEmpty()) {
          if (this.details_.isEmpty()) {
            this.details_ = param1Status.details_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureDetailsIsMutable();
            this.details_.addAll(param1Status.details_);
          } 
          onChanged();
        } 
      } else if (!param1Status.details_.isEmpty()) {
        if (this.detailsBuilder_.isEmpty()) {
          this.detailsBuilder_.dispose();
          RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = null;
          this.detailsBuilder_ = null;
          this.details_ = param1Status.details_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (Status.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getDetailsFieldBuilder(); 
          this.detailsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.detailsBuilder_.addAllMessages(param1Status.details_);
        } 
      } 
      mergeUnknownFields(param1Status.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeDetails(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureDetailsIsMutable();
        this.details_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setCode(int param1Int) {
      this.code_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setDetails(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureDetailsIsMutable();
        this.details_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setDetails(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.detailsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureDetailsIsMutable();
          this.details_.set(param1Int, param1Any);
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
    
    public Builder setMessage(String param1String) {
      if (param1String != null) {
        this.message_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMessageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Status.checkByteStringIsUtf8(param1ByteString);
        this.message_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.rpc;

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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BadRequest extends GeneratedMessageV3 implements BadRequestOrBuilder {
  private static final BadRequest DEFAULT_INSTANCE = new BadRequest();
  
  public static final int FIELD_VIOLATIONS_FIELD_NUMBER = 1;
  
  private static final Parser<BadRequest> PARSER = (Parser<BadRequest>)new AbstractParser<BadRequest>() {
      public BadRequest a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new BadRequest(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private List<FieldViolation> fieldViolations_;
  
  private byte memoizedIsInitialized = -1;
  
  private BadRequest() {
    this.fieldViolations_ = Collections.emptyList();
  }
  
  private BadRequest(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              j = i;
              k = i;
              m = i;
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                continue; 
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.fieldViolations_ = new ArrayList<FieldViolation>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.fieldViolations_.add(paramCodedInputStream.readMessage(FieldViolation.parser(), paramExtensionRegistryLite));
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
          this.fieldViolations_ = Collections.unmodifiableList(this.fieldViolations_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.fieldViolations_ = Collections.unmodifiableList(this.fieldViolations_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private BadRequest(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static BadRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.m;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BadRequest paramBadRequest) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBadRequest);
  }
  
  public static BadRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BadRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static BadRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BadRequest)PARSER.parseFrom(paramByteString);
  }
  
  public static BadRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BadRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static BadRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (BadRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static BadRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (BadRequest)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static BadRequest parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BadRequest)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static BadRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BadRequest> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof BadRequest))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getFieldViolationsList().equals(paramObject.getFieldViolationsList()) ? false : (!!this.unknownFields.equals(((BadRequest)paramObject).unknownFields));
  }
  
  public BadRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public FieldViolation getFieldViolations(int paramInt) {
    return this.fieldViolations_.get(paramInt);
  }
  
  public int getFieldViolationsCount() {
    return this.fieldViolations_.size();
  }
  
  public List<FieldViolation> getFieldViolationsList() {
    return this.fieldViolations_;
  }
  
  public FieldViolationOrBuilder getFieldViolationsOrBuilder(int paramInt) {
    return this.fieldViolations_.get(paramInt);
  }
  
  public List<? extends FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
    return (List)this.fieldViolations_;
  }
  
  public Parser<BadRequest> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.fieldViolations_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.fieldViolations_.get(i));
      i++;
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
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getFieldViolationsCount() > 0)
      i = (j * 37 + 1) * 53 + getFieldViolationsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.n.ensureFieldAccessorsInitialized(BadRequest.class, Builder.class);
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
    for (int i = 0; i < this.fieldViolations_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.fieldViolations_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BadRequestOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> fieldViolationsBuilder_;
    
    private List<BadRequest.FieldViolation> fieldViolations_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureFieldViolationsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.fieldViolations_ = new ArrayList<BadRequest.FieldViolation>(this.fieldViolations_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.m;
    }
    
    private RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> getFieldViolationsFieldBuilder() {
      if (this.fieldViolationsBuilder_ == null) {
        List<BadRequest.FieldViolation> list = this.fieldViolations_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.fieldViolationsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.fieldViolations_ = null;
      } 
      return this.fieldViolationsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (BadRequest.alwaysUseFieldBuilders)
        getFieldViolationsFieldBuilder(); 
    }
    
    public Builder addAllFieldViolations(Iterable<? extends BadRequest.FieldViolation> param1Iterable) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldViolationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.fieldViolations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addFieldViolations(int param1Int, BadRequest.FieldViolation.Builder param1Builder) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addFieldViolations(int param1Int, BadRequest.FieldViolation param1FieldViolation) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1FieldViolation != null) {
          ensureFieldViolationsIsMutable();
          this.fieldViolations_.add(param1Int, param1FieldViolation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1FieldViolation);
      return this;
    }
    
    public Builder addFieldViolations(BadRequest.FieldViolation.Builder param1Builder) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addFieldViolations(BadRequest.FieldViolation param1FieldViolation) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1FieldViolation != null) {
          ensureFieldViolationsIsMutable();
          this.fieldViolations_.add(param1FieldViolation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1FieldViolation);
      return this;
    }
    
    public BadRequest.FieldViolation.Builder addFieldViolationsBuilder() {
      return (BadRequest.FieldViolation.Builder)getFieldViolationsFieldBuilder().addBuilder((AbstractMessage)BadRequest.FieldViolation.getDefaultInstance());
    }
    
    public BadRequest.FieldViolation.Builder addFieldViolationsBuilder(int param1Int) {
      return (BadRequest.FieldViolation.Builder)getFieldViolationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)BadRequest.FieldViolation.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public BadRequest build() {
      BadRequest badRequest = buildPartial();
      if (badRequest.isInitialized())
        return badRequest; 
      throw newUninitializedMessageException(badRequest);
    }
    
    public BadRequest buildPartial() {
      BadRequest badRequest = new BadRequest(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.fieldViolations_ = Collections.unmodifiableList(this.fieldViolations_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        BadRequest.access$1502(badRequest, this.fieldViolations_);
      } else {
        BadRequest.access$1502(badRequest, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return badRequest;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.fieldViolations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFieldViolations() {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.fieldViolations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public BadRequest getDefaultInstanceForType() {
      return BadRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.m;
    }
    
    public BadRequest.FieldViolation getFieldViolations(int param1Int) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.fieldViolations_.get(param1Int) : (BadRequest.FieldViolation)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public BadRequest.FieldViolation.Builder getFieldViolationsBuilder(int param1Int) {
      return (BadRequest.FieldViolation.Builder)getFieldViolationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<BadRequest.FieldViolation.Builder> getFieldViolationsBuilderList() {
      return getFieldViolationsFieldBuilder().getBuilderList();
    }
    
    public int getFieldViolationsCount() {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.fieldViolations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<BadRequest.FieldViolation> getFieldViolationsList() {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.fieldViolations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public BadRequest.FieldViolationOrBuilder getFieldViolationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.fieldViolations_.get(param1Int) : (BadRequest.FieldViolationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends BadRequest.FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.fieldViolations_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.n.ensureFieldAccessorsInitialized(BadRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        BadRequest badRequest = (BadRequest)BadRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        BadRequest badRequest = (BadRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((BadRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof BadRequest)
        return mergeFrom((BadRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(BadRequest param1BadRequest) {
      if (param1BadRequest == BadRequest.getDefaultInstance())
        return this; 
      if (this.fieldViolationsBuilder_ == null) {
        if (!param1BadRequest.fieldViolations_.isEmpty()) {
          if (this.fieldViolations_.isEmpty()) {
            this.fieldViolations_ = param1BadRequest.fieldViolations_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureFieldViolationsIsMutable();
            this.fieldViolations_.addAll(param1BadRequest.fieldViolations_);
          } 
          onChanged();
        } 
      } else if (!param1BadRequest.fieldViolations_.isEmpty()) {
        if (this.fieldViolationsBuilder_.isEmpty()) {
          this.fieldViolationsBuilder_.dispose();
          RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = null;
          this.fieldViolationsBuilder_ = null;
          this.fieldViolations_ = param1BadRequest.fieldViolations_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (BadRequest.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getFieldViolationsFieldBuilder(); 
          this.fieldViolationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.fieldViolationsBuilder_.addAllMessages(param1BadRequest.fieldViolations_);
        } 
      } 
      mergeUnknownFields(param1BadRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeFieldViolations(int param1Int) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFieldViolations(int param1Int, BadRequest.FieldViolation.Builder param1Builder) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setFieldViolations(int param1Int, BadRequest.FieldViolation param1FieldViolation) {
      RepeatedFieldBuilderV3<BadRequest.FieldViolation, BadRequest.FieldViolation.Builder, BadRequest.FieldViolationOrBuilder> repeatedFieldBuilderV3 = this.fieldViolationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1FieldViolation != null) {
          ensureFieldViolationsIsMutable();
          this.fieldViolations_.set(param1Int, param1FieldViolation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1FieldViolation);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static final class FieldViolation extends GeneratedMessageV3 implements FieldViolationOrBuilder {
    private static final FieldViolation DEFAULT_INSTANCE = new FieldViolation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    
    public static final int FIELD_FIELD_NUMBER = 1;
    
    private static final Parser<FieldViolation> PARSER = (Parser<FieldViolation>)new AbstractParser<FieldViolation>() {
        public BadRequest.FieldViolation a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new BadRequest.FieldViolation(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object description_;
    
    private volatile Object field_;
    
    private byte memoizedIsInitialized = -1;
    
    private FieldViolation() {
      this.field_ = "";
      this.description_ = "";
    }
    
    private FieldViolation(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.description_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.field_ = param1CodedInputStream.readStringRequireUtf8();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private FieldViolation(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static FieldViolation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.o;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldViolation param1FieldViolation) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1FieldViolation);
    }
    
    public static FieldViolation parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldViolation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static FieldViolation parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldViolation)PARSER.parseFrom(param1ByteString);
    }
    
    public static FieldViolation parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldViolation)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static FieldViolation parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldViolation)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static FieldViolation parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (FieldViolation)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static FieldViolation parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldViolation)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static FieldViolation parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldViolation> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof FieldViolation))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getField().equals(param1Object.getField()) ? false : (!getDescription().equals(param1Object.getDescription()) ? false : (!!this.unknownFields.equals(((FieldViolation)param1Object).unknownFields)));
    }
    
    public FieldViolation getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.description_ = object;
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getField() {
      Object object = this.field_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.field_ = object;
      return (String)object;
    }
    
    public ByteString getFieldBytes() {
      Object object = this.field_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.field_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<FieldViolation> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!getFieldBytes().isEmpty())
        i = 0 + GeneratedMessageV3.computeStringSize(1, this.field_); 
      int j = i;
      if (!getDescriptionBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.description_); 
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
      int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getField().hashCode()) * 37 + 2) * 53 + getDescription().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.p.ensureFieldAccessorsInitialized(FieldViolation.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getFieldBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.field_); 
      if (!getDescriptionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.description_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BadRequest.FieldViolationOrBuilder {
      private Object description_ = "";
      
      private Object field_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ErrorDetailsProto.o;
      }
      
      private void maybeForceBuilderInitialization() {
        BadRequest.FieldViolation.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public BadRequest.FieldViolation build() {
        BadRequest.FieldViolation fieldViolation = buildPartial();
        if (fieldViolation.isInitialized())
          return fieldViolation; 
        throw newUninitializedMessageException(fieldViolation);
      }
      
      public BadRequest.FieldViolation buildPartial() {
        BadRequest.FieldViolation fieldViolation = new BadRequest.FieldViolation(this);
        BadRequest.FieldViolation.access$402(fieldViolation, this.field_);
        BadRequest.FieldViolation.access$502(fieldViolation, this.description_);
        onBuilt();
        return fieldViolation;
      }
      
      public Builder clear() {
        super.clear();
        this.field_ = "";
        this.description_ = "";
        return this;
      }
      
      public Builder clearDescription() {
        this.description_ = BadRequest.FieldViolation.getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      
      public Builder clearField() {
        this.field_ = BadRequest.FieldViolation.getDefaultInstance().getField();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public BadRequest.FieldViolation getDefaultInstanceForType() {
        return BadRequest.FieldViolation.getDefaultInstance();
      }
      
      public String getDescription() {
        Object object = this.description_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.description_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDescriptionBytes() {
        Object object = this.description_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.description_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ErrorDetailsProto.o;
      }
      
      public String getField() {
        Object object = this.field_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.field_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getFieldBytes() {
        Object object = this.field_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.field_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ErrorDetailsProto.p.ensureFieldAccessorsInitialized(BadRequest.FieldViolation.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          BadRequest.FieldViolation fieldViolation = (BadRequest.FieldViolation)BadRequest.FieldViolation.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          BadRequest.FieldViolation fieldViolation = (BadRequest.FieldViolation)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((BadRequest.FieldViolation)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof BadRequest.FieldViolation)
          return mergeFrom((BadRequest.FieldViolation)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(BadRequest.FieldViolation param2FieldViolation) {
        if (param2FieldViolation == BadRequest.FieldViolation.getDefaultInstance())
          return this; 
        if (!param2FieldViolation.getField().isEmpty()) {
          this.field_ = param2FieldViolation.field_;
          onChanged();
        } 
        if (!param2FieldViolation.getDescription().isEmpty()) {
          this.description_ = param2FieldViolation.description_;
          onChanged();
        } 
        mergeUnknownFields(param2FieldViolation.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setDescription(String param2String) {
        if (param2String != null) {
          this.description_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          BadRequest.FieldViolation.checkByteStringIsUtf8(param2ByteString);
          this.description_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setField(String param2String) {
        if (param2String != null) {
          this.field_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFieldBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          BadRequest.FieldViolation.checkByteStringIsUtf8(param2ByteString);
          this.field_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<FieldViolation> {
    public BadRequest.FieldViolation a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new BadRequest.FieldViolation(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<FieldViolation.Builder> implements FieldViolationOrBuilder {
    private Object description_ = "";
    
    private Object field_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.o;
    }
    
    private void maybeForceBuilderInitialization() {
      BadRequest.FieldViolation.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public BadRequest.FieldViolation build() {
      BadRequest.FieldViolation fieldViolation = buildPartial();
      if (fieldViolation.isInitialized())
        return fieldViolation; 
      throw newUninitializedMessageException(fieldViolation);
    }
    
    public BadRequest.FieldViolation buildPartial() {
      BadRequest.FieldViolation fieldViolation = new BadRequest.FieldViolation(this);
      BadRequest.FieldViolation.access$402(fieldViolation, this.field_);
      BadRequest.FieldViolation.access$502(fieldViolation, this.description_);
      onBuilt();
      return fieldViolation;
    }
    
    public Builder clear() {
      super.clear();
      this.field_ = "";
      this.description_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = BadRequest.FieldViolation.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField() {
      this.field_ = BadRequest.FieldViolation.getDefaultInstance().getField();
      onChanged();
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
    
    public BadRequest.FieldViolation getDefaultInstanceForType() {
      return BadRequest.FieldViolation.getDefaultInstance();
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.description_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.o;
    }
    
    public String getField() {
      Object object = this.field_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.field_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFieldBytes() {
      Object object = this.field_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.field_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.p.ensureFieldAccessorsInitialized(BadRequest.FieldViolation.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        BadRequest.FieldViolation fieldViolation = (BadRequest.FieldViolation)BadRequest.FieldViolation.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        BadRequest.FieldViolation fieldViolation = (BadRequest.FieldViolation)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((BadRequest.FieldViolation)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof BadRequest.FieldViolation)
        return mergeFrom((BadRequest.FieldViolation)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(BadRequest.FieldViolation param1FieldViolation) {
      if (param1FieldViolation == BadRequest.FieldViolation.getDefaultInstance())
        return this; 
      if (!param1FieldViolation.getField().isEmpty()) {
        this.field_ = param1FieldViolation.field_;
        onChanged();
      } 
      if (!param1FieldViolation.getDescription().isEmpty()) {
        this.description_ = param1FieldViolation.description_;
        onChanged();
      } 
      mergeUnknownFields(param1FieldViolation.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        BadRequest.FieldViolation.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setField(String param1String) {
      if (param1String != null) {
        this.field_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFieldBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        BadRequest.FieldViolation.checkByteStringIsUtf8(param1ByteString);
        this.field_ = param1ByteString;
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
  
  public static interface FieldViolationOrBuilder extends MessageOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getField();
    
    ByteString getFieldBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\BadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
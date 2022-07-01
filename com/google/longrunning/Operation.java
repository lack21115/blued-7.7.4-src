package com.google.longrunning;

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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Operation extends GeneratedMessageV3 implements OperationOrBuilder {
  private static final Operation DEFAULT_INSTANCE = new Operation();
  
  public static final int DONE_FIELD_NUMBER = 3;
  
  public static final int ERROR_FIELD_NUMBER = 4;
  
  public static final int METADATA_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<Operation> PARSER = (Parser<Operation>)new AbstractParser<Operation>() {
      public Operation a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Operation(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RESPONSE_FIELD_NUMBER = 5;
  
  private static final long serialVersionUID = 0L;
  
  private boolean done_;
  
  private byte memoizedIsInitialized = -1;
  
  private Any metadata_;
  
  private volatile Object name_;
  
  private int resultCase_ = 0;
  
  private Object result_;
  
  private Operation() {
    this.name_ = "";
  }
  
  private Operation(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              Any.Builder builder2 = null;
              Any.Builder builder3 = null;
              Any.Builder builder1 = null;
              if (i != 18) {
                if (i != 24) {
                  Status.Builder builder4;
                  if (i != 34) {
                    if (i != 42) {
                      if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    if (this.resultCase_ == 5)
                      builder1 = ((Any)this.result_).toBuilder(); 
                    this.result_ = paramCodedInputStream.readMessage(Any.parser(), paramExtensionRegistryLite);
                    if (builder1 != null) {
                      builder1.mergeFrom((Any)this.result_);
                      this.result_ = builder1.buildPartial();
                    } 
                    this.resultCase_ = 5;
                    continue;
                  } 
                  builder1 = builder2;
                  if (this.resultCase_ == 4)
                    builder4 = ((Status)this.result_).toBuilder(); 
                  this.result_ = paramCodedInputStream.readMessage(Status.parser(), paramExtensionRegistryLite);
                  if (builder4 != null) {
                    builder4.mergeFrom((Status)this.result_);
                    this.result_ = builder4.buildPartial();
                  } 
                  this.resultCase_ = 4;
                  continue;
                } 
                this.done_ = paramCodedInputStream.readBool();
                continue;
              } 
              builder1 = builder3;
              if (this.metadata_ != null)
                builder1 = this.metadata_.toBuilder(); 
              this.metadata_ = (Any)paramCodedInputStream.readMessage(Any.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom(this.metadata_);
                this.metadata_ = builder1.buildPartial();
              } 
              continue;
            } 
            this.name_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private Operation(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Operation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return OperationsProto.b;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Operation paramOperation) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramOperation);
  }
  
  public static Operation parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Operation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Operation parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Operation)PARSER.parseFrom(paramByteString);
  }
  
  public static Operation parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Operation)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Operation parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(InputStream paramInputStream) throws IOException {
    return (Operation)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Operation parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Operation)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Operation parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Operation)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Operation parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Operation> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Operation))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (!getName().equals(paramObject.getName()))
      return false; 
    if (hasMetadata() != paramObject.hasMetadata())
      return false; 
    if (hasMetadata() && !getMetadata().equals(paramObject.getMetadata()))
      return false; 
    if (getDone() != paramObject.getDone())
      return false; 
    if (!getResultCase().equals(paramObject.getResultCase()))
      return false; 
    int i = this.resultCase_;
    if (i != 4) {
      if (i == 5 && !getResponse().equals(paramObject.getResponse()))
        return false; 
    } else if (!getError().equals(paramObject.getError())) {
      return false;
    } 
    return !!this.unknownFields.equals(((Operation)paramObject).unknownFields);
  }
  
  public Operation getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public boolean getDone() {
    return this.done_;
  }
  
  public Status getError() {
    return (this.resultCase_ == 4) ? (Status)this.result_ : Status.getDefaultInstance();
  }
  
  public StatusOrBuilder getErrorOrBuilder() {
    return (StatusOrBuilder)((this.resultCase_ == 4) ? (Status)this.result_ : Status.getDefaultInstance());
  }
  
  public Any getMetadata() {
    Any any2 = this.metadata_;
    Any any1 = any2;
    if (any2 == null)
      any1 = Any.getDefaultInstance(); 
    return any1;
  }
  
  public AnyOrBuilder getMetadataOrBuilder() {
    return (AnyOrBuilder)getMetadata();
  }
  
  public String getName() {
    Object object = this.name_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.name_ = object;
    return (String)object;
  }
  
  public ByteString getNameBytes() {
    Object object = this.name_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.name_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<Operation> getParserForType() {
    return PARSER;
  }
  
  public Any getResponse() {
    return (this.resultCase_ == 5) ? (Any)this.result_ : Any.getDefaultInstance();
  }
  
  public AnyOrBuilder getResponseOrBuilder() {
    return (AnyOrBuilder)((this.resultCase_ == 5) ? (Any)this.result_ : Any.getDefaultInstance());
  }
  
  public ResultCase getResultCase() {
    return ResultCase.forNumber(this.resultCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getNameBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
    i = j;
    if (this.metadata_ != null)
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getMetadata()); 
    boolean bool = this.done_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    i = j;
    if (this.resultCase_ == 4)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)this.result_); 
    j = i;
    if (this.resultCase_ == 5)
      j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)this.result_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasError() {
    return (this.resultCase_ == 4);
  }
  
  public boolean hasMetadata() {
    return (this.metadata_ != null);
  }
  
  public boolean hasResponse() {
    return (this.resultCase_ == 5);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (hasMetadata())
      i = (j * 37 + 2) * 53 + getMetadata().hashCode(); 
    i = (i * 37 + 3) * 53 + Internal.hashBoolean(getDone());
    j = this.resultCase_;
    if (j != 4) {
      if (j != 5) {
        i = i * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      } 
      i = (i * 37 + 5) * 53;
      j = getResponse().hashCode();
    } else {
      i = (i * 37 + 4) * 53;
      j = getError().hashCode();
    } 
    i += j;
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return OperationsProto.c.ensureFieldAccessorsInitialized(Operation.class, Builder.class);
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
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    if (this.metadata_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getMetadata()); 
    boolean bool = this.done_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    if (this.resultCase_ == 4)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.result_); 
    if (this.resultCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.result_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OperationOrBuilder {
    private boolean done_;
    
    private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> errorBuilder_;
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> metadataBuilder_;
    
    private Any metadata_;
    
    private Object name_ = "";
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> responseBuilder_;
    
    private int resultCase_ = 0;
    
    private Object result_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return OperationsProto.b;
    }
    
    private SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> getErrorFieldBuilder() {
      if (this.errorBuilder_ == null) {
        if (this.resultCase_ != 4)
          this.result_ = Status.getDefaultInstance(); 
        this.errorBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.result_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.result_ = null;
      } 
      this.resultCase_ = 4;
      onChanged();
      return this.errorBuilder_;
    }
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getMetadataFieldBuilder() {
      if (this.metadataBuilder_ == null) {
        this.metadataBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getMetadata(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.metadata_ = null;
      } 
      return this.metadataBuilder_;
    }
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getResponseFieldBuilder() {
      if (this.responseBuilder_ == null) {
        if (this.resultCase_ != 5)
          this.result_ = Any.getDefaultInstance(); 
        this.responseBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.result_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.result_ = null;
      } 
      this.resultCase_ = 5;
      onChanged();
      return this.responseBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      Operation.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Operation build() {
      Operation operation = buildPartial();
      if (operation.isInitialized())
        return operation; 
      throw newUninitializedMessageException(operation);
    }
    
    public Operation buildPartial() {
      Operation operation = new Operation(this);
      Operation.access$402(operation, this.name_);
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        Operation.access$502(operation, this.metadata_);
      } else {
        Operation.access$502(operation, (Any)singleFieldBuilderV3.build());
      } 
      Operation.access$602(operation, this.done_);
      if (this.resultCase_ == 4) {
        SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV31 = this.errorBuilder_;
        if (singleFieldBuilderV31 == null) {
          Operation.access$702(operation, this.result_);
        } else {
          Operation.access$702(operation, singleFieldBuilderV31.build());
        } 
      } 
      if (this.resultCase_ == 5) {
        singleFieldBuilderV3 = this.responseBuilder_;
        if (singleFieldBuilderV3 == null) {
          Operation.access$702(operation, this.result_);
        } else {
          Operation.access$702(operation, singleFieldBuilderV3.build());
        } 
      } 
      Operation.access$802(operation, this.resultCase_);
      onBuilt();
      return operation;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      if (this.metadataBuilder_ == null) {
        this.metadata_ = null;
      } else {
        this.metadata_ = null;
        this.metadataBuilder_ = null;
      } 
      this.done_ = false;
      this.resultCase_ = 0;
      this.result_ = null;
      return this;
    }
    
    public Builder clearDone() {
      this.done_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearError() {
      if (this.errorBuilder_ == null) {
        if (this.resultCase_ == 4) {
          this.resultCase_ = 0;
          this.result_ = null;
          onChanged();
          return this;
        } 
      } else {
        if (this.resultCase_ == 4) {
          this.resultCase_ = 0;
          this.result_ = null;
        } 
        this.errorBuilder_.clear();
      } 
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMetadata() {
      if (this.metadataBuilder_ == null) {
        this.metadata_ = null;
        onChanged();
        return this;
      } 
      this.metadata_ = null;
      this.metadataBuilder_ = null;
      return this;
    }
    
    public Builder clearName() {
      this.name_ = Operation.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearResponse() {
      if (this.responseBuilder_ == null) {
        if (this.resultCase_ == 5) {
          this.resultCase_ = 0;
          this.result_ = null;
          onChanged();
          return this;
        } 
      } else {
        if (this.resultCase_ == 5) {
          this.resultCase_ = 0;
          this.result_ = null;
        } 
        this.responseBuilder_.clear();
      } 
      return this;
    }
    
    public Builder clearResult() {
      this.resultCase_ = 0;
      this.result_ = null;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Operation getDefaultInstanceForType() {
      return Operation.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return OperationsProto.b;
    }
    
    public boolean getDone() {
      return this.done_;
    }
    
    public Status getError() {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
      return (singleFieldBuilderV3 == null) ? ((this.resultCase_ == 4) ? (Status)this.result_ : Status.getDefaultInstance()) : ((this.resultCase_ == 4) ? (Status)singleFieldBuilderV3.getMessage() : Status.getDefaultInstance());
    }
    
    public Status.Builder getErrorBuilder() {
      return (Status.Builder)getErrorFieldBuilder().getBuilder();
    }
    
    public StatusOrBuilder getErrorOrBuilder() {
      if (this.resultCase_ == 4) {
        SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
        if (singleFieldBuilderV3 != null)
          return (StatusOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      } 
      return (StatusOrBuilder)((this.resultCase_ == 4) ? (Status)this.result_ : Status.getDefaultInstance());
    }
    
    public Any getMetadata() {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        Any any1 = this.metadata_;
        any = any1;
        if (any1 == null)
          any = Any.getDefaultInstance(); 
        return any;
      } 
      return (Any)any.getMessage();
    }
    
    public Any.Builder getMetadataBuilder() {
      onChanged();
      return (Any.Builder)getMetadataFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getMetadataOrBuilder() {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Any any2 = this.metadata_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return (AnyOrBuilder)any1;
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.name_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Any getResponse() {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      return (singleFieldBuilderV3 == null) ? ((this.resultCase_ == 5) ? (Any)this.result_ : Any.getDefaultInstance()) : ((this.resultCase_ == 5) ? (Any)singleFieldBuilderV3.getMessage() : Any.getDefaultInstance());
    }
    
    public Any.Builder getResponseBuilder() {
      return (Any.Builder)getResponseFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getResponseOrBuilder() {
      if (this.resultCase_ == 5) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      } 
      return (AnyOrBuilder)((this.resultCase_ == 5) ? (Any)this.result_ : Any.getDefaultInstance());
    }
    
    public Operation.ResultCase getResultCase() {
      return Operation.ResultCase.forNumber(this.resultCase_);
    }
    
    public boolean hasError() {
      return (this.resultCase_ == 4);
    }
    
    public boolean hasMetadata() {
      return (this.metadataBuilder_ != null || this.metadata_ != null);
    }
    
    public boolean hasResponse() {
      return (this.resultCase_ == 5);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return OperationsProto.c.ensureFieldAccessorsInitialized(Operation.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeError(Status param1Status) {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
          this.result_ = Status.newBuilder((Status)this.result_).mergeFrom(param1Status).buildPartial();
        } else {
          this.result_ = param1Status;
        } 
        onChanged();
      } else {
        if (this.resultCase_ == 4)
          singleFieldBuilderV3.mergeFrom((AbstractMessage)param1Status); 
        this.errorBuilder_.setMessage((AbstractMessage)param1Status);
      } 
      this.resultCase_ = 4;
      return this;
    }
    
    public Builder mergeFrom(Operation param1Operation) {
      if (param1Operation == Operation.getDefaultInstance())
        return this; 
      if (!param1Operation.getName().isEmpty()) {
        this.name_ = param1Operation.name_;
        onChanged();
      } 
      if (param1Operation.hasMetadata())
        mergeMetadata(param1Operation.getMetadata()); 
      if (param1Operation.getDone())
        setDone(param1Operation.getDone()); 
      int i = Operation.null.a[param1Operation.getResultCase().ordinal()];
      if (i != 1) {
        if (i == 2)
          mergeResponse(param1Operation.getResponse()); 
      } else {
        mergeError(param1Operation.getError());
      } 
      mergeUnknownFields(param1Operation.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Operation operation = (Operation)Operation.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Operation operation = (Operation)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Operation)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Operation)
        return mergeFrom((Operation)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeMetadata(Any param1Any) {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        any = this.metadata_;
        if (any != null) {
          this.metadata_ = Any.newBuilder(any).mergeFrom(param1Any).buildPartial();
        } else {
          this.metadata_ = param1Any;
        } 
        onChanged();
        return this;
      } 
      any.mergeFrom((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder mergeResponse(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
          this.result_ = Any.newBuilder((Any)this.result_).mergeFrom(param1Any).buildPartial();
        } else {
          this.result_ = param1Any;
        } 
        onChanged();
      } else {
        if (this.resultCase_ == 5)
          singleFieldBuilderV3.mergeFrom((AbstractMessage)param1Any); 
        this.responseBuilder_.setMessage((AbstractMessage)param1Any);
      } 
      this.resultCase_ = 5;
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDone(boolean param1Boolean) {
      this.done_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setError(Status.Builder param1Builder) {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.result_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.resultCase_ = 4;
      return this;
    }
    
    public Builder setError(Status param1Status) {
      SingleFieldBuilderV3<Status, Status.Builder, StatusOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Status != null) {
          this.result_ = param1Status;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Status);
      } 
      this.resultCase_ = 4;
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMetadata(Any.Builder param1Builder) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.metadata_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMetadata(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.metadataBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Any != null) {
          this.metadata_ = param1Any;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Operation.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setResponse(Any.Builder param1Builder) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.result_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.resultCase_ = 5;
      return this;
    }
    
    public Builder setResponse(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Any != null) {
          this.result_ = param1Any;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Any);
      } 
      this.resultCase_ = 5;
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public enum ResultCase implements Internal.EnumLite {
    ERROR(4),
    RESPONSE(5),
    RESULT_NOT_SET(0);
    
    private final int value;
    
    static {
    
    }
    
    ResultCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ResultCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 4) ? ((param1Int != 5) ? null : RESPONSE) : ERROR) : RESULT_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\Operation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.longrunning;

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

public final class ListOperationsResponse extends GeneratedMessageV3 implements ListOperationsResponseOrBuilder {
  private static final ListOperationsResponse DEFAULT_INSTANCE = new ListOperationsResponse();
  
  public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
  
  public static final int OPERATIONS_FIELD_NUMBER = 1;
  
  private static final Parser<ListOperationsResponse> PARSER = (Parser<ListOperationsResponse>)new AbstractParser<ListOperationsResponse>() {
      public ListOperationsResponse a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ListOperationsResponse(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object nextPageToken_;
  
  private List<Operation> operations_;
  
  private ListOperationsResponse() {
    this.operations_ = Collections.emptyList();
    this.nextPageToken_ = "";
  }
  
  private ListOperationsResponse(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              j = i;
              k = i;
              m = i;
              this.nextPageToken_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.operations_ = new ArrayList<Operation>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.operations_.add(paramCodedInputStream.readMessage(Operation.parser(), paramExtensionRegistryLite));
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
          this.operations_ = Collections.unmodifiableList(this.operations_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.operations_ = Collections.unmodifiableList(this.operations_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private ListOperationsResponse(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ListOperationsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return OperationsProto.h;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListOperationsResponse paramListOperationsResponse) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramListOperationsResponse);
  }
  
  public static ListOperationsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ListOperationsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)PARSER.parseFrom(paramByteString);
  }
  
  public static ListOperationsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListOperationsResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ListOperationsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ListOperationsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsResponse)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ListOperationsResponse parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ListOperationsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListOperationsResponse> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ListOperationsResponse))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getOperationsList().equals(paramObject.getOperationsList()) ? false : (!getNextPageToken().equals(paramObject.getNextPageToken()) ? false : (!!this.unknownFields.equals(((ListOperationsResponse)paramObject).unknownFields)));
  }
  
  public ListOperationsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getNextPageToken() {
    Object object = this.nextPageToken_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.nextPageToken_ = object;
    return (String)object;
  }
  
  public ByteString getNextPageTokenBytes() {
    Object object = this.nextPageToken_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.nextPageToken_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Operation getOperations(int paramInt) {
    return this.operations_.get(paramInt);
  }
  
  public int getOperationsCount() {
    return this.operations_.size();
  }
  
  public List<Operation> getOperationsList() {
    return this.operations_;
  }
  
  public OperationOrBuilder getOperationsOrBuilder(int paramInt) {
    return this.operations_.get(paramInt);
  }
  
  public List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
    return (List)this.operations_;
  }
  
  public Parser<ListOperationsResponse> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.operations_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.operations_.get(j));
      j++;
    } 
    j = i;
    if (!getNextPageTokenBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.nextPageToken_); 
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
    if (getOperationsCount() > 0)
      i = (j * 37 + 1) * 53 + getOperationsList().hashCode(); 
    i = ((i * 37 + 2) * 53 + getNextPageToken().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return OperationsProto.i.ensureFieldAccessorsInitialized(ListOperationsResponse.class, Builder.class);
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
    for (int i = 0; i < this.operations_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.operations_.get(i)); 
    if (!getNextPageTokenBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.nextPageToken_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ListOperationsResponseOrBuilder {
    private int bitField0_;
    
    private Object nextPageToken_ = "";
    
    private RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> operationsBuilder_;
    
    private List<Operation> operations_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureOperationsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.operations_ = new ArrayList<Operation>(this.operations_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return OperationsProto.h;
    }
    
    private RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> getOperationsFieldBuilder() {
      if (this.operationsBuilder_ == null) {
        List<Operation> list = this.operations_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.operationsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.operations_ = null;
      } 
      return this.operationsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (ListOperationsResponse.alwaysUseFieldBuilders)
        getOperationsFieldBuilder(); 
    }
    
    public Builder addAllOperations(Iterable<? extends Operation> param1Iterable) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOperationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.operations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addOperations(int param1Int, Operation.Builder param1Builder) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOperationsIsMutable();
        this.operations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addOperations(int param1Int, Operation param1Operation) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Operation != null) {
          ensureOperationsIsMutable();
          this.operations_.add(param1Int, param1Operation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Operation);
      return this;
    }
    
    public Builder addOperations(Operation.Builder param1Builder) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOperationsIsMutable();
        this.operations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addOperations(Operation param1Operation) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Operation != null) {
          ensureOperationsIsMutable();
          this.operations_.add(param1Operation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Operation);
      return this;
    }
    
    public Operation.Builder addOperationsBuilder() {
      return (Operation.Builder)getOperationsFieldBuilder().addBuilder((AbstractMessage)Operation.getDefaultInstance());
    }
    
    public Operation.Builder addOperationsBuilder(int param1Int) {
      return (Operation.Builder)getOperationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Operation.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ListOperationsResponse build() {
      ListOperationsResponse listOperationsResponse = buildPartial();
      if (listOperationsResponse.isInitialized())
        return listOperationsResponse; 
      throw newUninitializedMessageException(listOperationsResponse);
    }
    
    public ListOperationsResponse buildPartial() {
      ListOperationsResponse listOperationsResponse = new ListOperationsResponse(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.operations_ = Collections.unmodifiableList(this.operations_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        ListOperationsResponse.access$402(listOperationsResponse, this.operations_);
      } else {
        ListOperationsResponse.access$402(listOperationsResponse, repeatedFieldBuilderV3.build());
      } 
      ListOperationsResponse.access$502(listOperationsResponse, this.nextPageToken_);
      ListOperationsResponse.access$602(listOperationsResponse, 0);
      onBuilt();
      return listOperationsResponse;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.operations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.nextPageToken_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNextPageToken() {
      this.nextPageToken_ = ListOperationsResponse.getDefaultInstance().getNextPageToken();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOperations() {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.operations_ = Collections.emptyList();
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
    
    public ListOperationsResponse getDefaultInstanceForType() {
      return ListOperationsResponse.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return OperationsProto.h;
    }
    
    public String getNextPageToken() {
      Object object = this.nextPageToken_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.nextPageToken_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNextPageTokenBytes() {
      Object object = this.nextPageToken_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.nextPageToken_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Operation getOperations(int param1Int) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.operations_.get(param1Int) : (Operation)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Operation.Builder getOperationsBuilder(int param1Int) {
      return (Operation.Builder)getOperationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Operation.Builder> getOperationsBuilderList() {
      return getOperationsFieldBuilder().getBuilderList();
    }
    
    public int getOperationsCount() {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.operations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Operation> getOperationsList() {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.operations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public OperationOrBuilder getOperationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.operations_.get(param1Int) : (OperationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.operations_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return OperationsProto.i.ensureFieldAccessorsInitialized(ListOperationsResponse.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ListOperationsResponse param1ListOperationsResponse) {
      if (param1ListOperationsResponse == ListOperationsResponse.getDefaultInstance())
        return this; 
      if (this.operationsBuilder_ == null) {
        if (!param1ListOperationsResponse.operations_.isEmpty()) {
          if (this.operations_.isEmpty()) {
            this.operations_ = param1ListOperationsResponse.operations_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureOperationsIsMutable();
            this.operations_.addAll(param1ListOperationsResponse.operations_);
          } 
          onChanged();
        } 
      } else if (!param1ListOperationsResponse.operations_.isEmpty()) {
        if (this.operationsBuilder_.isEmpty()) {
          this.operationsBuilder_.dispose();
          RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = null;
          this.operationsBuilder_ = null;
          this.operations_ = param1ListOperationsResponse.operations_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (ListOperationsResponse.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getOperationsFieldBuilder(); 
          this.operationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.operationsBuilder_.addAllMessages(param1ListOperationsResponse.operations_);
        } 
      } 
      if (!param1ListOperationsResponse.getNextPageToken().isEmpty()) {
        this.nextPageToken_ = param1ListOperationsResponse.nextPageToken_;
        onChanged();
      } 
      mergeUnknownFields(param1ListOperationsResponse.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ListOperationsResponse listOperationsResponse = (ListOperationsResponse)ListOperationsResponse.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ListOperationsResponse listOperationsResponse = (ListOperationsResponse)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ListOperationsResponse)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ListOperationsResponse)
        return mergeFrom((ListOperationsResponse)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeOperations(int param1Int) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOperationsIsMutable();
        this.operations_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNextPageToken(String param1String) {
      if (param1String != null) {
        this.nextPageToken_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNextPageTokenBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ListOperationsResponse.checkByteStringIsUtf8(param1ByteString);
        this.nextPageToken_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOperations(int param1Int, Operation.Builder param1Builder) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureOperationsIsMutable();
        this.operations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setOperations(int param1Int, Operation param1Operation) {
      RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> repeatedFieldBuilderV3 = this.operationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Operation != null) {
          ensureOperationsIsMutable();
          this.operations_.set(param1Int, param1Operation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Operation);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\ListOperationsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
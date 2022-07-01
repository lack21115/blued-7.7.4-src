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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ListOperationsRequest extends GeneratedMessageV3 implements ListOperationsRequestOrBuilder {
  private static final ListOperationsRequest DEFAULT_INSTANCE = new ListOperationsRequest();
  
  public static final int FILTER_FIELD_NUMBER = 1;
  
  public static final int NAME_FIELD_NUMBER = 4;
  
  public static final int PAGE_SIZE_FIELD_NUMBER = 2;
  
  public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
  
  private static final Parser<ListOperationsRequest> PARSER = (Parser<ListOperationsRequest>)new AbstractParser<ListOperationsRequest>() {
      public ListOperationsRequest a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ListOperationsRequest(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object filter_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private int pageSize_;
  
  private volatile Object pageToken_;
  
  private ListOperationsRequest() {
    this.name_ = "";
    this.filter_ = "";
    this.pageToken_ = "";
  }
  
  private ListOperationsRequest(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 16) {
                if (i != 26) {
                  if (i != 34) {
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.name_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.pageToken_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.pageSize_ = paramCodedInputStream.readInt32();
              continue;
            } 
            this.filter_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private ListOperationsRequest(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ListOperationsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return OperationsProto.f;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListOperationsRequest paramListOperationsRequest) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramListOperationsRequest);
  }
  
  public static ListOperationsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ListOperationsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)PARSER.parseFrom(paramByteString);
  }
  
  public static ListOperationsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ListOperationsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ListOperationsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ListOperationsRequest parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ListOperationsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListOperationsRequest> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ListOperationsRequest))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getFilter().equals(paramObject.getFilter()) ? false : ((getPageSize() != paramObject.getPageSize()) ? false : (!getPageToken().equals(paramObject.getPageToken()) ? false : (!!this.unknownFields.equals(((ListOperationsRequest)paramObject).unknownFields)))));
  }
  
  public ListOperationsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getFilter() {
    Object object = this.filter_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.filter_ = object;
    return (String)object;
  }
  
  public ByteString getFilterBytes() {
    Object object = this.filter_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.filter_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
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
  
  public int getPageSize() {
    return this.pageSize_;
  }
  
  public String getPageToken() {
    Object object = this.pageToken_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.pageToken_ = object;
    return (String)object;
  }
  
  public ByteString getPageTokenBytes() {
    Object object = this.pageToken_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.pageToken_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<ListOperationsRequest> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getFilterBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.filter_); 
    int k = this.pageSize_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    j = i;
    if (!getPageTokenBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.pageToken_); 
    i = j;
    if (!getNameBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(4, this.name_); 
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
    int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 4) * 53 + getName().hashCode()) * 37 + 1) * 53 + getFilter().hashCode()) * 37 + 2) * 53 + getPageSize()) * 37 + 3) * 53 + getPageToken().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return OperationsProto.g.ensureFieldAccessorsInitialized(ListOperationsRequest.class, Builder.class);
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
    if (!getFilterBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.filter_); 
    int i = this.pageSize_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    if (!getPageTokenBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.pageToken_); 
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.name_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ListOperationsRequestOrBuilder {
    private Object filter_ = "";
    
    private Object name_ = "";
    
    private int pageSize_;
    
    private Object pageToken_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return OperationsProto.f;
    }
    
    private void maybeForceBuilderInitialization() {
      ListOperationsRequest.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ListOperationsRequest build() {
      ListOperationsRequest listOperationsRequest = buildPartial();
      if (listOperationsRequest.isInitialized())
        return listOperationsRequest; 
      throw newUninitializedMessageException(listOperationsRequest);
    }
    
    public ListOperationsRequest buildPartial() {
      ListOperationsRequest listOperationsRequest = new ListOperationsRequest(this);
      ListOperationsRequest.access$402(listOperationsRequest, this.name_);
      ListOperationsRequest.access$502(listOperationsRequest, this.filter_);
      ListOperationsRequest.access$602(listOperationsRequest, this.pageSize_);
      ListOperationsRequest.access$702(listOperationsRequest, this.pageToken_);
      onBuilt();
      return listOperationsRequest;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.filter_ = "";
      this.pageSize_ = 0;
      this.pageToken_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFilter() {
      this.filter_ = ListOperationsRequest.getDefaultInstance().getFilter();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = ListOperationsRequest.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPageSize() {
      this.pageSize_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPageToken() {
      this.pageToken_ = ListOperationsRequest.getDefaultInstance().getPageToken();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ListOperationsRequest getDefaultInstanceForType() {
      return ListOperationsRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return OperationsProto.f;
    }
    
    public String getFilter() {
      Object object = this.filter_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.filter_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFilterBytes() {
      Object object = this.filter_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.filter_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public int getPageSize() {
      return this.pageSize_;
    }
    
    public String getPageToken() {
      Object object = this.pageToken_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.pageToken_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPageTokenBytes() {
      Object object = this.pageToken_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.pageToken_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return OperationsProto.g.ensureFieldAccessorsInitialized(ListOperationsRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ListOperationsRequest param1ListOperationsRequest) {
      if (param1ListOperationsRequest == ListOperationsRequest.getDefaultInstance())
        return this; 
      if (!param1ListOperationsRequest.getName().isEmpty()) {
        this.name_ = param1ListOperationsRequest.name_;
        onChanged();
      } 
      if (!param1ListOperationsRequest.getFilter().isEmpty()) {
        this.filter_ = param1ListOperationsRequest.filter_;
        onChanged();
      } 
      if (param1ListOperationsRequest.getPageSize() != 0)
        setPageSize(param1ListOperationsRequest.getPageSize()); 
      if (!param1ListOperationsRequest.getPageToken().isEmpty()) {
        this.pageToken_ = param1ListOperationsRequest.pageToken_;
        onChanged();
      } 
      mergeUnknownFields(param1ListOperationsRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ListOperationsRequest listOperationsRequest = (ListOperationsRequest)ListOperationsRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ListOperationsRequest listOperationsRequest = (ListOperationsRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ListOperationsRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ListOperationsRequest)
        return mergeFrom((ListOperationsRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFilter(String param1String) {
      if (param1String != null) {
        this.filter_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFilterBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ListOperationsRequest.checkByteStringIsUtf8(param1ByteString);
        this.filter_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ListOperationsRequest.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPageSize(int param1Int) {
      this.pageSize_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPageToken(String param1String) {
      if (param1String != null) {
        this.pageToken_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPageTokenBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ListOperationsRequest.checkByteStringIsUtf8(param1ByteString);
        this.pageToken_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\ListOperationsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
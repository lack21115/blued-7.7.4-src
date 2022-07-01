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

public final class DebugInfo extends GeneratedMessageV3 implements DebugInfoOrBuilder {
  private static final DebugInfo DEFAULT_INSTANCE = new DebugInfo();
  
  public static final int DETAIL_FIELD_NUMBER = 2;
  
  private static final Parser<DebugInfo> PARSER = (Parser<DebugInfo>)new AbstractParser<DebugInfo>() {
      public DebugInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new DebugInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object detail_;
  
  private byte memoizedIsInitialized = -1;
  
  private LazyStringList stackEntries_;
  
  private DebugInfo() {
    this.stackEntries_ = LazyStringArrayList.EMPTY;
    this.detail_ = "";
  }
  
  private DebugInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.detail_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            String str = paramCodedInputStream.readStringRequireUtf8();
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.stackEntries_ = (LazyStringList)new LazyStringArrayList();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.stackEntries_.add(str);
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
          this.stackEntries_ = this.stackEntries_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.stackEntries_ = this.stackEntries_.getUnmodifiableView(); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private DebugInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static DebugInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DebugInfo paramDebugInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDebugInfo);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DebugInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (DebugInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static DebugInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DebugInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DebugInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof DebugInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getStackEntriesList().equals(paramObject.getStackEntriesList()) ? false : (!getDetail().equals(paramObject.getDetail()) ? false : (!!this.unknownFields.equals(((DebugInfo)paramObject).unknownFields)));
  }
  
  public DebugInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getDetail() {
    Object object = this.detail_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.detail_ = object;
    return (String)object;
  }
  
  public ByteString getDetailBytes() {
    Object object = this.detail_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.detail_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<DebugInfo> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.stackEntries_.size()) {
      j += computeStringSizeNoTag(this.stackEntries_.getRaw(i));
      i++;
    } 
    j = 0 + j + getStackEntriesList().size() * 1;
    i = j;
    if (!getDetailBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.detail_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getStackEntries(int paramInt) {
    return (String)this.stackEntries_.get(paramInt);
  }
  
  public ByteString getStackEntriesBytes(int paramInt) {
    return this.stackEntries_.getByteString(paramInt);
  }
  
  public int getStackEntriesCount() {
    return this.stackEntries_.size();
  }
  
  public ProtocolStringList getStackEntriesList() {
    return (ProtocolStringList)this.stackEntries_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getStackEntriesCount() > 0)
      i = (j * 37 + 1) * 53 + getStackEntriesList().hashCode(); 
    i = ((i * 37 + 2) * 53 + getDetail().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.d.ensureFieldAccessorsInitialized(DebugInfo.class, Builder.class);
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
    for (int i = 0; i < this.stackEntries_.size(); i++)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.stackEntries_.getRaw(i)); 
    if (!getDetailBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.detail_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DebugInfoOrBuilder {
    private int bitField0_;
    
    private Object detail_ = "";
    
    private LazyStringList stackEntries_ = LazyStringArrayList.EMPTY;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureStackEntriesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.stackEntries_ = (LazyStringList)new LazyStringArrayList(this.stackEntries_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      DebugInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addAllStackEntries(Iterable<String> param1Iterable) {
      ensureStackEntriesIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.stackEntries_);
      onChanged();
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addStackEntries(String param1String) {
      if (param1String != null) {
        ensureStackEntriesIsMutable();
        this.stackEntries_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addStackEntriesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        DebugInfo.checkByteStringIsUtf8(param1ByteString);
        ensureStackEntriesIsMutable();
        this.stackEntries_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public DebugInfo build() {
      DebugInfo debugInfo = buildPartial();
      if (debugInfo.isInitialized())
        return debugInfo; 
      throw newUninitializedMessageException(debugInfo);
    }
    
    public DebugInfo buildPartial() {
      DebugInfo debugInfo = new DebugInfo(this);
      if ((this.bitField0_ & 0x1) != 0) {
        this.stackEntries_ = this.stackEntries_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFE;
      } 
      DebugInfo.access$402(debugInfo, this.stackEntries_);
      DebugInfo.access$502(debugInfo, this.detail_);
      DebugInfo.access$602(debugInfo, 0);
      onBuilt();
      return debugInfo;
    }
    
    public Builder clear() {
      super.clear();
      this.stackEntries_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFE;
      this.detail_ = "";
      return this;
    }
    
    public Builder clearDetail() {
      this.detail_ = DebugInfo.getDefaultInstance().getDetail();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearStackEntries() {
      this.stackEntries_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFE;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public DebugInfo getDefaultInstanceForType() {
      return DebugInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.c;
    }
    
    public String getDetail() {
      Object object = this.detail_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.detail_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDetailBytes() {
      Object object = this.detail_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.detail_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getStackEntries(int param1Int) {
      return (String)this.stackEntries_.get(param1Int);
    }
    
    public ByteString getStackEntriesBytes(int param1Int) {
      return this.stackEntries_.getByteString(param1Int);
    }
    
    public int getStackEntriesCount() {
      return this.stackEntries_.size();
    }
    
    public ProtocolStringList getStackEntriesList() {
      return (ProtocolStringList)this.stackEntries_.getUnmodifiableView();
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.d.ensureFieldAccessorsInitialized(DebugInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        DebugInfo debugInfo = (DebugInfo)DebugInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        DebugInfo debugInfo = (DebugInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((DebugInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof DebugInfo)
        return mergeFrom((DebugInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(DebugInfo param1DebugInfo) {
      if (param1DebugInfo == DebugInfo.getDefaultInstance())
        return this; 
      if (!param1DebugInfo.stackEntries_.isEmpty()) {
        if (this.stackEntries_.isEmpty()) {
          this.stackEntries_ = param1DebugInfo.stackEntries_;
          this.bitField0_ &= 0xFFFFFFFE;
        } else {
          ensureStackEntriesIsMutable();
          this.stackEntries_.addAll((Collection)param1DebugInfo.stackEntries_);
        } 
        onChanged();
      } 
      if (!param1DebugInfo.getDetail().isEmpty()) {
        this.detail_ = param1DebugInfo.detail_;
        onChanged();
      } 
      mergeUnknownFields(param1DebugInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDetail(String param1String) {
      if (param1String != null) {
        this.detail_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDetailBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        DebugInfo.checkByteStringIsUtf8(param1ByteString);
        this.detail_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setStackEntries(int param1Int, String param1String) {
      if (param1String != null) {
        ensureStackEntriesIsMutable();
        this.stackEntries_.set(param1Int, param1String);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\DebugInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
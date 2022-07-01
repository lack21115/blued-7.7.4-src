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

public final class SourceInfo extends GeneratedMessageV3 implements SourceInfoOrBuilder {
  private static final SourceInfo DEFAULT_INSTANCE = new SourceInfo();
  
  private static final Parser<SourceInfo> PARSER = (Parser<SourceInfo>)new AbstractParser<SourceInfo>() {
      public SourceInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new SourceInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SOURCE_FILES_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private List<Any> sourceFiles_;
  
  private SourceInfo() {
    this.sourceFiles_ = Collections.emptyList();
  }
  
  private SourceInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.sourceFiles_ = new ArrayList<Any>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.sourceFiles_.add(paramCodedInputStream.readMessage(Any.parser(), paramExtensionRegistryLite));
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
          this.sourceFiles_ = Collections.unmodifiableList(this.sourceFiles_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.sourceFiles_ = Collections.unmodifiableList(this.sourceFiles_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private SourceInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static SourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return SourceInfoProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SourceInfo paramSourceInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSourceInfo);
  }
  
  public static SourceInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SourceInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static SourceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (SourceInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static SourceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SourceInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (SourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static SourceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (SourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static SourceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (SourceInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static SourceInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SourceInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (SourceInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static SourceInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SourceInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SourceInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSourceFilesList().equals(paramObject.getSourceFilesList()) ? false : (!!this.unknownFields.equals(((SourceInfo)paramObject).unknownFields));
  }
  
  public SourceInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<SourceInfo> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.sourceFiles_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.sourceFiles_.get(i));
      i++;
    } 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public Any getSourceFiles(int paramInt) {
    return this.sourceFiles_.get(paramInt);
  }
  
  public int getSourceFilesCount() {
    return this.sourceFiles_.size();
  }
  
  public List<Any> getSourceFilesList() {
    return this.sourceFiles_;
  }
  
  public AnyOrBuilder getSourceFilesOrBuilder(int paramInt) {
    return (AnyOrBuilder)this.sourceFiles_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
    return (List)this.sourceFiles_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getSourceFilesCount() > 0)
      i = (j * 37 + 1) * 53 + getSourceFilesList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return SourceInfoProto.b.ensureFieldAccessorsInitialized(SourceInfo.class, Builder.class);
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
    for (int i = 0; i < this.sourceFiles_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.sourceFiles_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SourceInfoOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> sourceFilesBuilder_;
    
    private List<Any> sourceFiles_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureSourceFilesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.sourceFiles_ = new ArrayList<Any>(this.sourceFiles_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SourceInfoProto.a;
    }
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getSourceFilesFieldBuilder() {
      if (this.sourceFilesBuilder_ == null) {
        List<Any> list = this.sourceFiles_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.sourceFilesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.sourceFiles_ = null;
      } 
      return this.sourceFilesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (SourceInfo.alwaysUseFieldBuilders)
        getSourceFilesFieldBuilder(); 
    }
    
    public Builder addAllSourceFiles(Iterable<? extends Any> param1Iterable) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSourceFilesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.sourceFiles_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addSourceFiles(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addSourceFiles(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureSourceFilesIsMutable();
          this.sourceFiles_.add(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public Builder addSourceFiles(Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addSourceFiles(Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureSourceFilesIsMutable();
          this.sourceFiles_.add(param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Any.Builder addSourceFilesBuilder() {
      return (Any.Builder)getSourceFilesFieldBuilder().addBuilder((AbstractMessage)Any.getDefaultInstance());
    }
    
    public Any.Builder addSourceFilesBuilder(int param1Int) {
      return (Any.Builder)getSourceFilesFieldBuilder().addBuilder(param1Int, (AbstractMessage)Any.getDefaultInstance());
    }
    
    public SourceInfo build() {
      SourceInfo sourceInfo = buildPartial();
      if (sourceInfo.isInitialized())
        return sourceInfo; 
      throw newUninitializedMessageException(sourceInfo);
    }
    
    public SourceInfo buildPartial() {
      SourceInfo sourceInfo = new SourceInfo(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.sourceFiles_ = Collections.unmodifiableList(this.sourceFiles_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        SourceInfo.access$402(sourceInfo, this.sourceFiles_);
      } else {
        SourceInfo.access$402(sourceInfo, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return sourceInfo;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.sourceFiles_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
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
    
    public Builder clearSourceFiles() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.sourceFiles_ = Collections.emptyList();
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
    
    public SourceInfo getDefaultInstanceForType() {
      return SourceInfo.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SourceInfoProto.a;
    }
    
    public Any getSourceFiles(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.sourceFiles_.get(param1Int) : (Any)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Any.Builder getSourceFilesBuilder(int param1Int) {
      return (Any.Builder)getSourceFilesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Any.Builder> getSourceFilesBuilderList() {
      return getSourceFilesFieldBuilder().getBuilderList();
    }
    
    public int getSourceFilesCount() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.sourceFiles_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Any> getSourceFilesList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.sourceFiles_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AnyOrBuilder getSourceFilesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (AnyOrBuilder)this.sourceFiles_.get(param1Int) : (AnyOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.sourceFiles_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SourceInfoProto.b.ensureFieldAccessorsInitialized(SourceInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SourceInfo param1SourceInfo) {
      if (param1SourceInfo == SourceInfo.getDefaultInstance())
        return this; 
      if (this.sourceFilesBuilder_ == null) {
        if (!param1SourceInfo.sourceFiles_.isEmpty()) {
          if (this.sourceFiles_.isEmpty()) {
            this.sourceFiles_ = param1SourceInfo.sourceFiles_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.addAll(param1SourceInfo.sourceFiles_);
          } 
          onChanged();
        } 
      } else if (!param1SourceInfo.sourceFiles_.isEmpty()) {
        if (this.sourceFilesBuilder_.isEmpty()) {
          this.sourceFilesBuilder_.dispose();
          RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = null;
          this.sourceFilesBuilder_ = null;
          this.sourceFiles_ = param1SourceInfo.sourceFiles_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (SourceInfo.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getSourceFilesFieldBuilder(); 
          this.sourceFilesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.sourceFilesBuilder_.addAllMessages(param1SourceInfo.sourceFiles_);
        } 
      } 
      mergeUnknownFields(param1SourceInfo.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SourceInfo sourceInfo = (SourceInfo)SourceInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SourceInfo sourceInfo = (SourceInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SourceInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SourceInfo)
        return mergeFrom((SourceInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeSourceFiles(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSourceFiles(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSourceFiles(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.sourceFilesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureSourceFilesIsMutable();
          this.sourceFiles_.set(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
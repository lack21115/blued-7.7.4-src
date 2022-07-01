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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CustomHttpPattern extends GeneratedMessageV3 implements CustomHttpPatternOrBuilder {
  private static final CustomHttpPattern DEFAULT_INSTANCE = new CustomHttpPattern();
  
  public static final int KIND_FIELD_NUMBER = 1;
  
  private static final Parser<CustomHttpPattern> PARSER = (Parser<CustomHttpPattern>)new AbstractParser<CustomHttpPattern>() {
      public CustomHttpPattern a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new CustomHttpPattern(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PATH_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object kind_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object path_;
  
  private CustomHttpPattern() {
    this.kind_ = "";
    this.path_ = "";
  }
  
  private CustomHttpPattern(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.path_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.kind_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private CustomHttpPattern(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static CustomHttpPattern getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return HttpProto.e;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CustomHttpPattern paramCustomHttpPattern) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramCustomHttpPattern);
  }
  
  public static CustomHttpPattern parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CustomHttpPattern)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static CustomHttpPattern parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CustomHttpPattern)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CustomHttpPattern parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CustomHttpPattern)PARSER.parseFrom(paramByteString);
  }
  
  public static CustomHttpPattern parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CustomHttpPattern)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static CustomHttpPattern parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CustomHttpPattern)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static CustomHttpPattern parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CustomHttpPattern)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CustomHttpPattern parseFrom(InputStream paramInputStream) throws IOException {
    return (CustomHttpPattern)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static CustomHttpPattern parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CustomHttpPattern)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CustomHttpPattern parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (CustomHttpPattern)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static CustomHttpPattern parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CustomHttpPattern)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static CustomHttpPattern parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CustomHttpPattern)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static CustomHttpPattern parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CustomHttpPattern)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CustomHttpPattern> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof CustomHttpPattern))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getKind().equals(paramObject.getKind()) ? false : (!getPath().equals(paramObject.getPath()) ? false : (!!this.unknownFields.equals(((CustomHttpPattern)paramObject).unknownFields)));
  }
  
  public CustomHttpPattern getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getKind() {
    Object object = this.kind_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.kind_ = object;
    return (String)object;
  }
  
  public ByteString getKindBytes() {
    Object object = this.kind_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.kind_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<CustomHttpPattern> getParserForType() {
    return PARSER;
  }
  
  public String getPath() {
    Object object = this.path_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.path_ = object;
    return (String)object;
  }
  
  public ByteString getPathBytes() {
    Object object = this.path_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.path_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getKindBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.kind_); 
    int j = i;
    if (!getPathBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.path_); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getKind().hashCode()) * 37 + 2) * 53 + getPath().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return HttpProto.f.ensureFieldAccessorsInitialized(CustomHttpPattern.class, Builder.class);
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
    if (!getKindBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.kind_); 
    if (!getPathBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.path_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomHttpPatternOrBuilder {
    private Object kind_ = "";
    
    private Object path_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return HttpProto.e;
    }
    
    private void maybeForceBuilderInitialization() {
      CustomHttpPattern.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CustomHttpPattern build() {
      CustomHttpPattern customHttpPattern = buildPartial();
      if (customHttpPattern.isInitialized())
        return customHttpPattern; 
      throw newUninitializedMessageException(customHttpPattern);
    }
    
    public CustomHttpPattern buildPartial() {
      CustomHttpPattern customHttpPattern = new CustomHttpPattern(this);
      CustomHttpPattern.access$402(customHttpPattern, this.kind_);
      CustomHttpPattern.access$502(customHttpPattern, this.path_);
      onBuilt();
      return customHttpPattern;
    }
    
    public Builder clear() {
      super.clear();
      this.kind_ = "";
      this.path_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearKind() {
      this.kind_ = CustomHttpPattern.getDefaultInstance().getKind();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPath() {
      this.path_ = CustomHttpPattern.getDefaultInstance().getPath();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public CustomHttpPattern getDefaultInstanceForType() {
      return CustomHttpPattern.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return HttpProto.e;
    }
    
    public String getKind() {
      Object object = this.kind_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.kind_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getKindBytes() {
      Object object = this.kind_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.kind_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPath() {
      Object object = this.path_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.path_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPathBytes() {
      Object object = this.path_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.path_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return HttpProto.f.ensureFieldAccessorsInitialized(CustomHttpPattern.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CustomHttpPattern param1CustomHttpPattern) {
      if (param1CustomHttpPattern == CustomHttpPattern.getDefaultInstance())
        return this; 
      if (!param1CustomHttpPattern.getKind().isEmpty()) {
        this.kind_ = param1CustomHttpPattern.kind_;
        onChanged();
      } 
      if (!param1CustomHttpPattern.getPath().isEmpty()) {
        this.path_ = param1CustomHttpPattern.path_;
        onChanged();
      } 
      mergeUnknownFields(param1CustomHttpPattern.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        CustomHttpPattern customHttpPattern = (CustomHttpPattern)CustomHttpPattern.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CustomHttpPattern customHttpPattern = (CustomHttpPattern)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CustomHttpPattern)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CustomHttpPattern)
        return mergeFrom((CustomHttpPattern)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setKind(String param1String) {
      if (param1String != null) {
        this.kind_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setKindBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CustomHttpPattern.checkByteStringIsUtf8(param1ByteString);
        this.kind_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPath(String param1String) {
      if (param1String != null) {
        this.path_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPathBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CustomHttpPattern.checkByteStringIsUtf8(param1ByteString);
        this.path_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\CustomHttpPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
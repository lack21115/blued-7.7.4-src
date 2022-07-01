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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ResourceInfo extends GeneratedMessageV3 implements ResourceInfoOrBuilder {
  private static final ResourceInfo DEFAULT_INSTANCE = new ResourceInfo();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  
  public static final int OWNER_FIELD_NUMBER = 3;
  
  private static final Parser<ResourceInfo> PARSER = (Parser<ResourceInfo>)new AbstractParser<ResourceInfo>() {
      public ResourceInfo a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ResourceInfo(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RESOURCE_NAME_FIELD_NUMBER = 2;
  
  public static final int RESOURCE_TYPE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object description_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object owner_;
  
  private volatile Object resourceName_;
  
  private volatile Object resourceType_;
  
  private ResourceInfo() {
    this.resourceType_ = "";
    this.resourceName_ = "";
    this.owner_ = "";
    this.description_ = "";
  }
  
  private ResourceInfo(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 26) {
                  if (i != 34) {
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.description_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.owner_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.resourceName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.resourceType_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private ResourceInfo(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ResourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.s;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ResourceInfo paramResourceInfo) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramResourceInfo);
  }
  
  public static ResourceInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ResourceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ResourceInfo)PARSER.parseFrom(paramByteString);
  }
  
  public static ResourceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ResourceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ResourceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ResourceInfo)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ResourceInfo parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ResourceInfo)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ResourceInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ResourceInfo> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ResourceInfo))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getResourceType().equals(paramObject.getResourceType()) ? false : (!getResourceName().equals(paramObject.getResourceName()) ? false : (!getOwner().equals(paramObject.getOwner()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!!this.unknownFields.equals(((ResourceInfo)paramObject).unknownFields)))));
  }
  
  public ResourceInfo getDefaultInstanceForType() {
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
  
  public String getOwner() {
    Object object = this.owner_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.owner_ = object;
    return (String)object;
  }
  
  public ByteString getOwnerBytes() {
    Object object = this.owner_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.owner_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<ResourceInfo> getParserForType() {
    return PARSER;
  }
  
  public String getResourceName() {
    Object object = this.resourceName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.resourceName_ = object;
    return (String)object;
  }
  
  public ByteString getResourceNameBytes() {
    Object object = this.resourceName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.resourceName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getResourceType() {
    Object object = this.resourceType_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.resourceType_ = object;
    return (String)object;
  }
  
  public ByteString getResourceTypeBytes() {
    Object object = this.resourceType_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.resourceType_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getResourceTypeBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.resourceType_); 
    i = j;
    if (!getResourceNameBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.resourceName_); 
    j = i;
    if (!getOwnerBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.owner_); 
    i = j;
    if (!getDescriptionBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(4, this.description_); 
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
    int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getResourceType().hashCode()) * 37 + 2) * 53 + getResourceName().hashCode()) * 37 + 3) * 53 + getOwner().hashCode()) * 37 + 4) * 53 + getDescription().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.t.ensureFieldAccessorsInitialized(ResourceInfo.class, Builder.class);
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
    if (!getResourceTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.resourceType_); 
    if (!getResourceNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.resourceName_); 
    if (!getOwnerBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.owner_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.description_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResourceInfoOrBuilder {
    private Object description_ = "";
    
    private Object owner_ = "";
    
    private Object resourceName_ = "";
    
    private Object resourceType_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.s;
    }
    
    private void maybeForceBuilderInitialization() {
      ResourceInfo.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ResourceInfo build() {
      ResourceInfo resourceInfo = buildPartial();
      if (resourceInfo.isInitialized())
        return resourceInfo; 
      throw newUninitializedMessageException(resourceInfo);
    }
    
    public ResourceInfo buildPartial() {
      ResourceInfo resourceInfo = new ResourceInfo(this);
      ResourceInfo.access$402(resourceInfo, this.resourceType_);
      ResourceInfo.access$502(resourceInfo, this.resourceName_);
      ResourceInfo.access$602(resourceInfo, this.owner_);
      ResourceInfo.access$702(resourceInfo, this.description_);
      onBuilt();
      return resourceInfo;
    }
    
    public Builder clear() {
      super.clear();
      this.resourceType_ = "";
      this.resourceName_ = "";
      this.owner_ = "";
      this.description_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = ResourceInfo.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOwner() {
      this.owner_ = ResourceInfo.getDefaultInstance().getOwner();
      onChanged();
      return this;
    }
    
    public Builder clearResourceName() {
      this.resourceName_ = ResourceInfo.getDefaultInstance().getResourceName();
      onChanged();
      return this;
    }
    
    public Builder clearResourceType() {
      this.resourceType_ = ResourceInfo.getDefaultInstance().getResourceType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public ResourceInfo getDefaultInstanceForType() {
      return ResourceInfo.getDefaultInstance();
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
      return ErrorDetailsProto.s;
    }
    
    public String getOwner() {
      Object object = this.owner_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.owner_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOwnerBytes() {
      Object object = this.owner_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.owner_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getResourceName() {
      Object object = this.resourceName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.resourceName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResourceNameBytes() {
      Object object = this.resourceName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.resourceName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getResourceType() {
      Object object = this.resourceType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.resourceType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getResourceTypeBytes() {
      Object object = this.resourceType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.resourceType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.t.ensureFieldAccessorsInitialized(ResourceInfo.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ResourceInfo resourceInfo = (ResourceInfo)ResourceInfo.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ResourceInfo resourceInfo = (ResourceInfo)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ResourceInfo)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ResourceInfo)
        return mergeFrom((ResourceInfo)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(ResourceInfo param1ResourceInfo) {
      if (param1ResourceInfo == ResourceInfo.getDefaultInstance())
        return this; 
      if (!param1ResourceInfo.getResourceType().isEmpty()) {
        this.resourceType_ = param1ResourceInfo.resourceType_;
        onChanged();
      } 
      if (!param1ResourceInfo.getResourceName().isEmpty()) {
        this.resourceName_ = param1ResourceInfo.resourceName_;
        onChanged();
      } 
      if (!param1ResourceInfo.getOwner().isEmpty()) {
        this.owner_ = param1ResourceInfo.owner_;
        onChanged();
      } 
      if (!param1ResourceInfo.getDescription().isEmpty()) {
        this.description_ = param1ResourceInfo.description_;
        onChanged();
      } 
      mergeUnknownFields(param1ResourceInfo.unknownFields);
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
        ResourceInfo.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setOwner(String param1String) {
      if (param1String != null) {
        this.owner_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOwnerBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceInfo.checkByteStringIsUtf8(param1ByteString);
        this.owner_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setResourceName(String param1String) {
      if (param1String != null) {
        this.resourceName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResourceNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceInfo.checkByteStringIsUtf8(param1ByteString);
        this.resourceName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResourceType(String param1String) {
      if (param1String != null) {
        this.resourceType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setResourceTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceInfo.checkByteStringIsUtf8(param1ByteString);
        this.resourceType_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\ResourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
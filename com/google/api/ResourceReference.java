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

public final class ResourceReference extends GeneratedMessageV3 implements ResourceReferenceOrBuilder {
  public static final int CHILD_TYPE_FIELD_NUMBER = 2;
  
  private static final ResourceReference DEFAULT_INSTANCE = new ResourceReference();
  
  private static final Parser<ResourceReference> PARSER = (Parser<ResourceReference>)new AbstractParser<ResourceReference>() {
      public ResourceReference a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ResourceReference(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object childType_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object type_;
  
  private ResourceReference() {
    this.type_ = "";
    this.childType_ = "";
  }
  
  private ResourceReference(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.childType_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.type_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private ResourceReference(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ResourceReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ResourceProto.f;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ResourceReference paramResourceReference) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramResourceReference);
  }
  
  public static ResourceReference parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ResourceReference)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ResourceReference parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceReference)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceReference parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ResourceReference)PARSER.parseFrom(paramByteString);
  }
  
  public static ResourceReference parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceReference)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ResourceReference parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ResourceReference)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ResourceReference parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceReference)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceReference parseFrom(InputStream paramInputStream) throws IOException {
    return (ResourceReference)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ResourceReference parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceReference)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceReference parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ResourceReference)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ResourceReference parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceReference)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ResourceReference parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ResourceReference)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ResourceReference parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceReference)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ResourceReference> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ResourceReference))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getType().equals(paramObject.getType()) ? false : (!getChildType().equals(paramObject.getChildType()) ? false : (!!this.unknownFields.equals(((ResourceReference)paramObject).unknownFields)));
  }
  
  public String getChildType() {
    Object object = this.childType_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.childType_ = object;
    return (String)object;
  }
  
  public ByteString getChildTypeBytes() {
    Object object = this.childType_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.childType_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public ResourceReference getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<ResourceReference> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getTypeBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.type_); 
    int j = i;
    if (!getChildTypeBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.childType_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getType() {
    Object object = this.type_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.type_ = object;
    return (String)object;
  }
  
  public ByteString getTypeBytes() {
    Object object = this.type_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.type_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getType().hashCode()) * 37 + 2) * 53 + getChildType().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ResourceProto.g.ensureFieldAccessorsInitialized(ResourceReference.class, Builder.class);
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
    if (!getTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.type_); 
    if (!getChildTypeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.childType_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResourceReferenceOrBuilder {
    private Object childType_ = "";
    
    private Object type_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ResourceProto.f;
    }
    
    private void maybeForceBuilderInitialization() {
      ResourceReference.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ResourceReference build() {
      ResourceReference resourceReference = buildPartial();
      if (resourceReference.isInitialized())
        return resourceReference; 
      throw newUninitializedMessageException(resourceReference);
    }
    
    public ResourceReference buildPartial() {
      ResourceReference resourceReference = new ResourceReference(this);
      ResourceReference.access$402(resourceReference, this.type_);
      ResourceReference.access$502(resourceReference, this.childType_);
      onBuilt();
      return resourceReference;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = "";
      this.childType_ = "";
      return this;
    }
    
    public Builder clearChildType() {
      this.childType_ = ResourceReference.getDefaultInstance().getChildType();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = ResourceReference.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getChildType() {
      Object object = this.childType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.childType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getChildTypeBytes() {
      Object object = this.childType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.childType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public ResourceReference getDefaultInstanceForType() {
      return ResourceReference.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ResourceProto.f;
    }
    
    public String getType() {
      Object object = this.type_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.type_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTypeBytes() {
      Object object = this.type_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.type_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ResourceProto.g.ensureFieldAccessorsInitialized(ResourceReference.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ResourceReference param1ResourceReference) {
      if (param1ResourceReference == ResourceReference.getDefaultInstance())
        return this; 
      if (!param1ResourceReference.getType().isEmpty()) {
        this.type_ = param1ResourceReference.type_;
        onChanged();
      } 
      if (!param1ResourceReference.getChildType().isEmpty()) {
        this.childType_ = param1ResourceReference.childType_;
        onChanged();
      } 
      mergeUnknownFields(param1ResourceReference.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ResourceReference resourceReference = (ResourceReference)ResourceReference.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ResourceReference resourceReference = (ResourceReference)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ResourceReference)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ResourceReference)
        return mergeFrom((ResourceReference)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setChildType(String param1String) {
      if (param1String != null) {
        this.childType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setChildTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceReference.checkByteStringIsUtf8(param1ByteString);
        this.childType_ = param1ByteString;
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
    
    public Builder setType(String param1String) {
      if (param1String != null) {
        this.type_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ResourceReference.checkByteStringIsUtf8(param1ByteString);
        this.type_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ResourceReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
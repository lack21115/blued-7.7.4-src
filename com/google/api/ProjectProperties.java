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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ProjectProperties extends GeneratedMessageV3 implements ProjectPropertiesOrBuilder {
  private static final ProjectProperties DEFAULT_INSTANCE = new ProjectProperties();
  
  private static final Parser<ProjectProperties> PARSER = (Parser<ProjectProperties>)new AbstractParser<ProjectProperties>() {
      public ProjectProperties a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new ProjectProperties(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PROPERTIES_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private List<Property> properties_;
  
  private ProjectProperties() {
    this.properties_ = Collections.emptyList();
  }
  
  private ProjectProperties(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.properties_ = new ArrayList<Property>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.properties_.add(paramCodedInputStream.readMessage(Property.parser(), paramExtensionRegistryLite));
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
          this.properties_ = Collections.unmodifiableList(this.properties_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.properties_ = Collections.unmodifiableList(this.properties_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private ProjectProperties(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static ProjectProperties getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ConsumerProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ProjectProperties paramProjectProperties) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramProjectProperties);
  }
  
  public static ProjectProperties parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ProjectProperties)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static ProjectProperties parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ProjectProperties)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ProjectProperties)PARSER.parseFrom(paramByteString);
  }
  
  public static ProjectProperties parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ProjectProperties)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ProjectProperties)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static ProjectProperties parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ProjectProperties)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(InputStream paramInputStream) throws IOException {
    return (ProjectProperties)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static ProjectProperties parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ProjectProperties)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (ProjectProperties)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static ProjectProperties parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ProjectProperties)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ProjectProperties)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static ProjectProperties parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ProjectProperties)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ProjectProperties> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ProjectProperties))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getPropertiesList().equals(paramObject.getPropertiesList()) ? false : (!!this.unknownFields.equals(((ProjectProperties)paramObject).unknownFields));
  }
  
  public ProjectProperties getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<ProjectProperties> getParserForType() {
    return PARSER;
  }
  
  public Property getProperties(int paramInt) {
    return this.properties_.get(paramInt);
  }
  
  public int getPropertiesCount() {
    return this.properties_.size();
  }
  
  public List<Property> getPropertiesList() {
    return this.properties_;
  }
  
  public PropertyOrBuilder getPropertiesOrBuilder(int paramInt) {
    return this.properties_.get(paramInt);
  }
  
  public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
    return (List)this.properties_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.properties_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.properties_.get(i));
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
    if (getPropertiesCount() > 0)
      i = (j * 37 + 1) * 53 + getPropertiesList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ConsumerProto.b.ensureFieldAccessorsInitialized(ProjectProperties.class, Builder.class);
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
    for (int i = 0; i < this.properties_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.properties_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProjectPropertiesOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> propertiesBuilder_;
    
    private List<Property> properties_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensurePropertiesIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.properties_ = new ArrayList<Property>(this.properties_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConsumerProto.a;
    }
    
    private RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> getPropertiesFieldBuilder() {
      if (this.propertiesBuilder_ == null) {
        List<Property> list = this.properties_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.propertiesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.properties_ = null;
      } 
      return this.propertiesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (ProjectProperties.alwaysUseFieldBuilders)
        getPropertiesFieldBuilder(); 
    }
    
    public Builder addAllProperties(Iterable<? extends Property> param1Iterable) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePropertiesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.properties_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addProperties(int param1Int, Property.Builder param1Builder) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePropertiesIsMutable();
        this.properties_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProperties(int param1Int, Property param1Property) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Property != null) {
          ensurePropertiesIsMutable();
          this.properties_.add(param1Int, param1Property);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Property);
      return this;
    }
    
    public Builder addProperties(Property.Builder param1Builder) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePropertiesIsMutable();
        this.properties_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProperties(Property param1Property) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Property != null) {
          ensurePropertiesIsMutable();
          this.properties_.add(param1Property);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Property);
      return this;
    }
    
    public Property.Builder addPropertiesBuilder() {
      return (Property.Builder)getPropertiesFieldBuilder().addBuilder((AbstractMessage)Property.getDefaultInstance());
    }
    
    public Property.Builder addPropertiesBuilder(int param1Int) {
      return (Property.Builder)getPropertiesFieldBuilder().addBuilder(param1Int, (AbstractMessage)Property.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ProjectProperties build() {
      ProjectProperties projectProperties = buildPartial();
      if (projectProperties.isInitialized())
        return projectProperties; 
      throw newUninitializedMessageException(projectProperties);
    }
    
    public ProjectProperties buildPartial() {
      ProjectProperties projectProperties = new ProjectProperties(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.properties_ = Collections.unmodifiableList(this.properties_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        ProjectProperties.access$402(projectProperties, this.properties_);
      } else {
        ProjectProperties.access$402(projectProperties, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return projectProperties;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.properties_ = Collections.emptyList();
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
    
    public Builder clearProperties() {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.properties_ = Collections.emptyList();
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
    
    public ProjectProperties getDefaultInstanceForType() {
      return ProjectProperties.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ConsumerProto.a;
    }
    
    public Property getProperties(int param1Int) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.properties_.get(param1Int) : (Property)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Property.Builder getPropertiesBuilder(int param1Int) {
      return (Property.Builder)getPropertiesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Property.Builder> getPropertiesBuilderList() {
      return getPropertiesFieldBuilder().getBuilderList();
    }
    
    public int getPropertiesCount() {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.properties_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Property> getPropertiesList() {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.properties_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public PropertyOrBuilder getPropertiesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.properties_.get(param1Int) : (PropertyOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.properties_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConsumerProto.b.ensureFieldAccessorsInitialized(ProjectProperties.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ProjectProperties param1ProjectProperties) {
      if (param1ProjectProperties == ProjectProperties.getDefaultInstance())
        return this; 
      if (this.propertiesBuilder_ == null) {
        if (!param1ProjectProperties.properties_.isEmpty()) {
          if (this.properties_.isEmpty()) {
            this.properties_ = param1ProjectProperties.properties_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensurePropertiesIsMutable();
            this.properties_.addAll(param1ProjectProperties.properties_);
          } 
          onChanged();
        } 
      } else if (!param1ProjectProperties.properties_.isEmpty()) {
        if (this.propertiesBuilder_.isEmpty()) {
          this.propertiesBuilder_.dispose();
          RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = null;
          this.propertiesBuilder_ = null;
          this.properties_ = param1ProjectProperties.properties_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (ProjectProperties.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getPropertiesFieldBuilder(); 
          this.propertiesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.propertiesBuilder_.addAllMessages(param1ProjectProperties.properties_);
        } 
      } 
      mergeUnknownFields(param1ProjectProperties.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ProjectProperties projectProperties = (ProjectProperties)ProjectProperties.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ProjectProperties projectProperties = (ProjectProperties)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ProjectProperties)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ProjectProperties)
        return mergeFrom((ProjectProperties)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeProperties(int param1Int) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePropertiesIsMutable();
        this.properties_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProperties(int param1Int, Property.Builder param1Builder) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePropertiesIsMutable();
        this.properties_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setProperties(int param1Int, Property param1Property) {
      RepeatedFieldBuilderV3<Property, Property.Builder, PropertyOrBuilder> repeatedFieldBuilderV3 = this.propertiesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Property != null) {
          ensurePropertiesIsMutable();
          this.properties_.set(param1Int, param1Property);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Property);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ProjectProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
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
import com.google.protobuf.Internal;
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

public final class Endpoint extends GeneratedMessageV3 implements EndpointOrBuilder {
  public static final int ALIASES_FIELD_NUMBER = 2;
  
  public static final int ALLOW_CORS_FIELD_NUMBER = 5;
  
  private static final Endpoint DEFAULT_INSTANCE = new Endpoint();
  
  public static final int FEATURES_FIELD_NUMBER = 4;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<Endpoint> PARSER = (Parser<Endpoint>)new AbstractParser<Endpoint>() {
      public Endpoint a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Endpoint(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TARGET_FIELD_NUMBER = 101;
  
  private static final long serialVersionUID = 0L;
  
  private LazyStringList aliases_;
  
  private boolean allowCors_;
  
  private int bitField0_;
  
  private LazyStringList features_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private volatile Object target_;
  
  private Endpoint() {
    this.name_ = "";
    this.aliases_ = LazyStringArrayList.EMPTY;
    this.features_ = LazyStringArrayList.EMPTY;
    this.target_ = "";
  }
  
  private Endpoint(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                if (n != 34) {
                  if (n != 40) {
                    if (n != 810) {
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
                    this.target_ = paramCodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.allowCors_ = paramCodedInputStream.readBool();
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                String str1 = paramCodedInputStream.readStringRequireUtf8();
                n = i;
                if ((i & 0x4) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.features_ = (LazyStringList)new LazyStringArrayList();
                  n = i | 0x4;
                } 
                j = n;
                k = n;
                m = n;
                this.features_.add(str1);
                i = n;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              String str = paramCodedInputStream.readStringRequireUtf8();
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.aliases_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.aliases_.add(str);
              i = n;
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.name_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x2) != 0)
          this.aliases_ = this.aliases_.getUnmodifiableView(); 
        if ((j & 0x4) != 0)
          this.features_ = this.features_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x2) != 0)
        this.aliases_ = this.aliases_.getUnmodifiableView(); 
      if ((i & 0x4) != 0)
        this.features_ = this.features_.getUnmodifiableView(); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Endpoint(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Endpoint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return EndpointProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Endpoint paramEndpoint) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEndpoint);
  }
  
  public static Endpoint parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Endpoint)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Endpoint parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Endpoint)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Endpoint)PARSER.parseFrom(paramByteString);
  }
  
  public static Endpoint parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Endpoint)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Endpoint)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Endpoint parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Endpoint)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(InputStream paramInputStream) throws IOException {
    return (Endpoint)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Endpoint parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Endpoint)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Endpoint)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Endpoint parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Endpoint)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Endpoint)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Endpoint parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Endpoint)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Endpoint> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Endpoint))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getAliasesList().equals(paramObject.getAliasesList()) ? false : (!getFeaturesList().equals(paramObject.getFeaturesList()) ? false : (!getTarget().equals(paramObject.getTarget()) ? false : ((getAllowCors() != paramObject.getAllowCors()) ? false : (!!this.unknownFields.equals(((Endpoint)paramObject).unknownFields))))));
  }
  
  @Deprecated
  public String getAliases(int paramInt) {
    return (String)this.aliases_.get(paramInt);
  }
  
  @Deprecated
  public ByteString getAliasesBytes(int paramInt) {
    return this.aliases_.getByteString(paramInt);
  }
  
  @Deprecated
  public int getAliasesCount() {
    return this.aliases_.size();
  }
  
  @Deprecated
  public ProtocolStringList getAliasesList() {
    return (ProtocolStringList)this.aliases_;
  }
  
  public boolean getAllowCors() {
    return this.allowCors_;
  }
  
  public Endpoint getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getFeatures(int paramInt) {
    return (String)this.features_.get(paramInt);
  }
  
  public ByteString getFeaturesBytes(int paramInt) {
    return this.features_.getByteString(paramInt);
  }
  
  public int getFeaturesCount() {
    return this.features_.size();
  }
  
  public ProtocolStringList getFeaturesList() {
    return (ProtocolStringList)this.features_;
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
  
  public Parser<Endpoint> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool1 = getNameBytes().isEmpty();
    boolean bool = false;
    if (!bool1) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    } 
    int k = 0;
    int j = 0;
    while (k < this.aliases_.size()) {
      j += computeStringSizeNoTag(this.aliases_.getRaw(k));
      k++;
    } 
    int n = getAliasesList().size();
    int m = 0;
    for (k = bool; k < this.features_.size(); k++)
      m += computeStringSizeNoTag(this.features_.getRaw(k)); 
    j = i + j + n * 1 + m + getFeaturesList().size() * 1;
    bool1 = this.allowCors_;
    i = j;
    if (bool1)
      i = j + CodedOutputStream.computeBoolSize(5, bool1); 
    j = i;
    if (!getTargetBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(101, this.target_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getTarget() {
    Object object = this.target_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.target_ = object;
    return (String)object;
  }
  
  public ByteString getTargetBytes() {
    Object object = this.target_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.target_ = object;
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
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (getAliasesCount() > 0)
      i = (j * 37 + 2) * 53 + getAliasesList().hashCode(); 
    j = i;
    if (getFeaturesCount() > 0)
      j = (i * 37 + 4) * 53 + getFeaturesList().hashCode(); 
    i = ((((j * 37 + 101) * 53 + getTarget().hashCode()) * 37 + 5) * 53 + Internal.hashBoolean(getAllowCors())) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return EndpointProto.b.ensureFieldAccessorsInitialized(Endpoint.class, Builder.class);
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
    int j;
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < this.aliases_.size()) {
        GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.aliases_.getRaw(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.features_.size()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.features_.getRaw(j));
      j++;
    } 
    boolean bool = this.allowCors_;
    if (bool)
      paramCodedOutputStream.writeBool(5, bool); 
    if (!getTargetBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 101, this.target_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EndpointOrBuilder {
    private LazyStringList aliases_ = LazyStringArrayList.EMPTY;
    
    private boolean allowCors_;
    
    private int bitField0_;
    
    private LazyStringList features_ = LazyStringArrayList.EMPTY;
    
    private Object name_ = "";
    
    private Object target_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAliasesIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.aliases_ = (LazyStringList)new LazyStringArrayList(this.aliases_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    private void ensureFeaturesIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.features_ = (LazyStringList)new LazyStringArrayList(this.features_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return EndpointProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Endpoint.alwaysUseFieldBuilders;
    }
    
    @Deprecated
    public Builder addAliases(String param1String) {
      if (param1String != null) {
        ensureAliasesIsMutable();
        this.aliases_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Builder addAliasesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Endpoint.checkByteStringIsUtf8(param1ByteString);
        ensureAliasesIsMutable();
        this.aliases_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Builder addAllAliases(Iterable<String> param1Iterable) {
      ensureAliasesIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.aliases_);
      onChanged();
      return this;
    }
    
    public Builder addAllFeatures(Iterable<String> param1Iterable) {
      ensureFeaturesIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.features_);
      onChanged();
      return this;
    }
    
    public Builder addFeatures(String param1String) {
      if (param1String != null) {
        ensureFeaturesIsMutable();
        this.features_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addFeaturesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Endpoint.checkByteStringIsUtf8(param1ByteString);
        ensureFeaturesIsMutable();
        this.features_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Endpoint build() {
      Endpoint endpoint = buildPartial();
      if (endpoint.isInitialized())
        return endpoint; 
      throw newUninitializedMessageException(endpoint);
    }
    
    public Endpoint buildPartial() {
      Endpoint endpoint = new Endpoint(this);
      int i = this.bitField0_;
      Endpoint.access$402(endpoint, this.name_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.aliases_ = this.aliases_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      Endpoint.access$502(endpoint, this.aliases_);
      if ((this.bitField0_ & 0x4) != 0) {
        this.features_ = this.features_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFB;
      } 
      Endpoint.access$602(endpoint, this.features_);
      Endpoint.access$702(endpoint, this.target_);
      Endpoint.access$802(endpoint, this.allowCors_);
      Endpoint.access$902(endpoint, 0);
      onBuilt();
      return endpoint;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.aliases_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      this.features_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFB;
      this.target_ = "";
      this.allowCors_ = false;
      return this;
    }
    
    @Deprecated
    public Builder clearAliases() {
      this.aliases_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearAllowCors() {
      this.allowCors_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearFeatures() {
      this.features_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFB;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = Endpoint.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTarget() {
      this.target_ = Endpoint.getDefaultInstance().getTarget();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    @Deprecated
    public String getAliases(int param1Int) {
      return (String)this.aliases_.get(param1Int);
    }
    
    @Deprecated
    public ByteString getAliasesBytes(int param1Int) {
      return this.aliases_.getByteString(param1Int);
    }
    
    @Deprecated
    public int getAliasesCount() {
      return this.aliases_.size();
    }
    
    @Deprecated
    public ProtocolStringList getAliasesList() {
      return (ProtocolStringList)this.aliases_.getUnmodifiableView();
    }
    
    public boolean getAllowCors() {
      return this.allowCors_;
    }
    
    public Endpoint getDefaultInstanceForType() {
      return Endpoint.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return EndpointProto.a;
    }
    
    public String getFeatures(int param1Int) {
      return (String)this.features_.get(param1Int);
    }
    
    public ByteString getFeaturesBytes(int param1Int) {
      return this.features_.getByteString(param1Int);
    }
    
    public int getFeaturesCount() {
      return this.features_.size();
    }
    
    public ProtocolStringList getFeaturesList() {
      return (ProtocolStringList)this.features_.getUnmodifiableView();
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
    
    public String getTarget() {
      Object object = this.target_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.target_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTargetBytes() {
      Object object = this.target_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.target_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return EndpointProto.b.ensureFieldAccessorsInitialized(Endpoint.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Endpoint param1Endpoint) {
      if (param1Endpoint == Endpoint.getDefaultInstance())
        return this; 
      if (!param1Endpoint.getName().isEmpty()) {
        this.name_ = param1Endpoint.name_;
        onChanged();
      } 
      if (!param1Endpoint.aliases_.isEmpty()) {
        if (this.aliases_.isEmpty()) {
          this.aliases_ = param1Endpoint.aliases_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureAliasesIsMutable();
          this.aliases_.addAll((Collection)param1Endpoint.aliases_);
        } 
        onChanged();
      } 
      if (!param1Endpoint.features_.isEmpty()) {
        if (this.features_.isEmpty()) {
          this.features_ = param1Endpoint.features_;
          this.bitField0_ &= 0xFFFFFFFB;
        } else {
          ensureFeaturesIsMutable();
          this.features_.addAll((Collection)param1Endpoint.features_);
        } 
        onChanged();
      } 
      if (!param1Endpoint.getTarget().isEmpty()) {
        this.target_ = param1Endpoint.target_;
        onChanged();
      } 
      if (param1Endpoint.getAllowCors())
        setAllowCors(param1Endpoint.getAllowCors()); 
      mergeUnknownFields(param1Endpoint.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Endpoint endpoint = (Endpoint)Endpoint.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Endpoint endpoint = (Endpoint)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Endpoint)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Endpoint)
        return mergeFrom((Endpoint)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    @Deprecated
    public Builder setAliases(int param1Int, String param1String) {
      if (param1String != null) {
        ensureAliasesIsMutable();
        this.aliases_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAllowCors(boolean param1Boolean) {
      this.allowCors_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setFeatures(int param1Int, String param1String) {
      if (param1String != null) {
        ensureFeaturesIsMutable();
        this.features_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
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
        Endpoint.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTarget(String param1String) {
      if (param1String != null) {
        this.target_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTargetBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Endpoint.checkByteStringIsUtf8(param1ByteString);
        this.target_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Endpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
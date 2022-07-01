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

public final class MonitoredResourceDescriptor extends GeneratedMessageV3 implements MonitoredResourceDescriptorOrBuilder {
  private static final MonitoredResourceDescriptor DEFAULT_INSTANCE = new MonitoredResourceDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
  
  public static final int LABELS_FIELD_NUMBER = 4;
  
  public static final int LAUNCH_STAGE_FIELD_NUMBER = 7;
  
  public static final int NAME_FIELD_NUMBER = 5;
  
  private static final Parser<MonitoredResourceDescriptor> PARSER = (Parser<MonitoredResourceDescriptor>)new AbstractParser<MonitoredResourceDescriptor>() {
      public MonitoredResourceDescriptor a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new MonitoredResourceDescriptor(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TYPE_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object description_;
  
  private volatile Object displayName_;
  
  private List<LabelDescriptor> labels_;
  
  private int launchStage_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private volatile Object type_;
  
  private MonitoredResourceDescriptor() {
    this.name_ = "";
    this.type_ = "";
    this.displayName_ = "";
    this.description_ = "";
    this.labels_ = Collections.emptyList();
    this.launchStage_ = 0;
  }
  
  private MonitoredResourceDescriptor(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                if (n != 26) {
                  if (n != 34) {
                    if (n != 42) {
                      if (n != 56) {
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
                      this.launchStage_ = paramCodedInputStream.readEnum();
                      continue;
                    } 
                    j = i;
                    k = i;
                    m = i;
                    this.name_ = paramCodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  n = i;
                  if ((i & 0x10) == 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.labels_ = new ArrayList<LabelDescriptor>();
                    n = i | 0x10;
                  } 
                  j = n;
                  k = n;
                  m = n;
                  this.labels_.add(paramCodedInputStream.readMessage(LabelDescriptor.parser(), paramExtensionRegistryLite));
                  i = n;
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.description_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.displayName_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.type_ = paramCodedInputStream.readStringRequireUtf8();
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
        if ((j & 0x10) != 0)
          this.labels_ = Collections.unmodifiableList(this.labels_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x10) != 0)
        this.labels_ = Collections.unmodifiableList(this.labels_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private MonitoredResourceDescriptor(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static MonitoredResourceDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return MonitoredResourceProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MonitoredResourceDescriptor paramMonitoredResourceDescriptor) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMonitoredResourceDescriptor);
  }
  
  public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)PARSER.parseFrom(paramByteString);
  }
  
  public static MonitoredResourceDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static MonitoredResourceDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static MonitoredResourceDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static MonitoredResourceDescriptor parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static MonitoredResourceDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MonitoredResourceDescriptor> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MonitoredResourceDescriptor))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getType().equals(paramObject.getType()) ? false : (!getDisplayName().equals(paramObject.getDisplayName()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!getLabelsList().equals(paramObject.getLabelsList()) ? false : ((this.launchStage_ != ((MonitoredResourceDescriptor)paramObject).launchStage_) ? false : (!!this.unknownFields.equals(((MonitoredResourceDescriptor)paramObject).unknownFields)))))));
  }
  
  public MonitoredResourceDescriptor getDefaultInstanceForType() {
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
  
  public String getDisplayName() {
    Object object = this.displayName_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.displayName_ = object;
    return (String)object;
  }
  
  public ByteString getDisplayNameBytes() {
    Object object = this.displayName_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.displayName_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public LabelDescriptor getLabels(int paramInt) {
    return this.labels_.get(paramInt);
  }
  
  public int getLabelsCount() {
    return this.labels_.size();
  }
  
  public List<LabelDescriptor> getLabelsList() {
    return this.labels_;
  }
  
  public LabelDescriptorOrBuilder getLabelsOrBuilder(int paramInt) {
    return this.labels_.get(paramInt);
  }
  
  public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
    return (List)this.labels_;
  }
  
  public LaunchStage getLaunchStage() {
    LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
    LaunchStage launchStage1 = launchStage2;
    if (launchStage2 == null)
      launchStage1 = LaunchStage.UNRECOGNIZED; 
    return launchStage1;
  }
  
  public int getLaunchStageValue() {
    return this.launchStage_;
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
  
  public Parser<MonitoredResourceDescriptor> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getTypeBytes().isEmpty();
    byte b = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.type_) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!getDisplayNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.displayName_); 
    i = j;
    int k = b;
    if (!getDescriptionBytes().isEmpty()) {
      i = j + GeneratedMessageV3.computeStringSize(3, this.description_);
      k = b;
    } 
    while (k < this.labels_.size()) {
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.labels_.get(k));
      k++;
    } 
    j = i;
    if (!getNameBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(5, this.name_); 
    i = j;
    if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(7, this.launchStage_); 
    i += this.unknownFields.getSerializedSize();
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
    int j = ((((((((779 + getDescriptor().hashCode()) * 37 + 5) * 53 + getName().hashCode()) * 37 + 1) * 53 + getType().hashCode()) * 37 + 2) * 53 + getDisplayName().hashCode()) * 37 + 3) * 53 + getDescription().hashCode();
    int i = j;
    if (getLabelsCount() > 0)
      i = (j * 37 + 4) * 53 + getLabelsList().hashCode(); 
    i = ((i * 37 + 7) * 53 + this.launchStage_) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return MonitoredResourceProto.b.ensureFieldAccessorsInitialized(MonitoredResourceDescriptor.class, Builder.class);
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
    if (!getDisplayNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.displayName_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.description_); 
    for (int i = 0; i < this.labels_.size(); i++)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.labels_.get(i)); 
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.name_); 
    if (this.launchStage_ != LaunchStage.LAUNCH_STAGE_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(7, this.launchStage_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoredResourceDescriptorOrBuilder {
    private int bitField0_;
    
    private Object description_ = "";
    
    private Object displayName_ = "";
    
    private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> labelsBuilder_;
    
    private List<LabelDescriptor> labels_ = Collections.emptyList();
    
    private int launchStage_ = 0;
    
    private Object name_ = "";
    
    private Object type_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureLabelsIsMutable() {
      if ((this.bitField0_ & 0x10) == 0) {
        this.labels_ = new ArrayList<LabelDescriptor>(this.labels_);
        this.bitField0_ |= 0x10;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MonitoredResourceProto.a;
    }
    
    private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> getLabelsFieldBuilder() {
      if (this.labelsBuilder_ == null) {
        boolean bool;
        List<LabelDescriptor> list = this.labels_;
        if ((this.bitField0_ & 0x10) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.labelsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.labels_ = null;
      } 
      return this.labelsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (MonitoredResourceDescriptor.alwaysUseFieldBuilders)
        getLabelsFieldBuilder(); 
    }
    
    public Builder addAllLabels(Iterable<? extends LabelDescriptor> param1Iterable) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.labels_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LabelDescriptor != null) {
          ensureLabelsIsMutable();
          this.labels_.add(param1Int, param1LabelDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1LabelDescriptor);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLabels(LabelDescriptor param1LabelDescriptor) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LabelDescriptor != null) {
          ensureLabelsIsMutable();
          this.labels_.add(param1LabelDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1LabelDescriptor);
      return this;
    }
    
    public LabelDescriptor.Builder addLabelsBuilder() {
      return (LabelDescriptor.Builder)getLabelsFieldBuilder().addBuilder((AbstractMessage)LabelDescriptor.getDefaultInstance());
    }
    
    public LabelDescriptor.Builder addLabelsBuilder(int param1Int) {
      return (LabelDescriptor.Builder)getLabelsFieldBuilder().addBuilder(param1Int, (AbstractMessage)LabelDescriptor.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MonitoredResourceDescriptor build() {
      MonitoredResourceDescriptor monitoredResourceDescriptor = buildPartial();
      if (monitoredResourceDescriptor.isInitialized())
        return monitoredResourceDescriptor; 
      throw newUninitializedMessageException(monitoredResourceDescriptor);
    }
    
    public MonitoredResourceDescriptor buildPartial() {
      MonitoredResourceDescriptor monitoredResourceDescriptor = new MonitoredResourceDescriptor(this);
      int i = this.bitField0_;
      MonitoredResourceDescriptor.access$402(monitoredResourceDescriptor, this.name_);
      MonitoredResourceDescriptor.access$502(monitoredResourceDescriptor, this.type_);
      MonitoredResourceDescriptor.access$602(monitoredResourceDescriptor, this.displayName_);
      MonitoredResourceDescriptor.access$702(monitoredResourceDescriptor, this.description_);
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x10) != 0) {
          this.labels_ = Collections.unmodifiableList(this.labels_);
          this.bitField0_ &= 0xFFFFFFEF;
        } 
        MonitoredResourceDescriptor.access$802(monitoredResourceDescriptor, this.labels_);
      } else {
        MonitoredResourceDescriptor.access$802(monitoredResourceDescriptor, repeatedFieldBuilderV3.build());
      } 
      MonitoredResourceDescriptor.access$902(monitoredResourceDescriptor, this.launchStage_);
      MonitoredResourceDescriptor.access$1002(monitoredResourceDescriptor, 0);
      onBuilt();
      return monitoredResourceDescriptor;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.type_ = "";
      this.displayName_ = "";
      this.description_ = "";
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.labels_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFEF;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.launchStage_ = 0;
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = MonitoredResourceDescriptor.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearDisplayName() {
      this.displayName_ = MonitoredResourceDescriptor.getDefaultInstance().getDisplayName();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLabels() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.labels_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFEF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearLaunchStage() {
      this.launchStage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = MonitoredResourceDescriptor.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = MonitoredResourceDescriptor.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public MonitoredResourceDescriptor getDefaultInstanceForType() {
      return MonitoredResourceDescriptor.getDefaultInstance();
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
      return MonitoredResourceProto.a;
    }
    
    public String getDisplayName() {
      Object object = this.displayName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.displayName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDisplayNameBytes() {
      Object object = this.displayName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.displayName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LabelDescriptor getLabels(int param1Int) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.labels_.get(param1Int) : (LabelDescriptor)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public LabelDescriptor.Builder getLabelsBuilder(int param1Int) {
      return (LabelDescriptor.Builder)getLabelsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<LabelDescriptor.Builder> getLabelsBuilderList() {
      return getLabelsFieldBuilder().getBuilderList();
    }
    
    public int getLabelsCount() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.labels_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<LabelDescriptor> getLabelsList() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.labels_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public LabelDescriptorOrBuilder getLabelsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.labels_.get(param1Int) : (LabelDescriptorOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.labels_);
    }
    
    public LaunchStage getLaunchStage() {
      LaunchStage launchStage2 = LaunchStage.valueOf(this.launchStage_);
      LaunchStage launchStage1 = launchStage2;
      if (launchStage2 == null)
        launchStage1 = LaunchStage.UNRECOGNIZED; 
      return launchStage1;
    }
    
    public int getLaunchStageValue() {
      return this.launchStage_;
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
      return MonitoredResourceProto.b.ensureFieldAccessorsInitialized(MonitoredResourceDescriptor.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      if (param1MonitoredResourceDescriptor == MonitoredResourceDescriptor.getDefaultInstance())
        return this; 
      if (!param1MonitoredResourceDescriptor.getName().isEmpty()) {
        this.name_ = param1MonitoredResourceDescriptor.name_;
        onChanged();
      } 
      if (!param1MonitoredResourceDescriptor.getType().isEmpty()) {
        this.type_ = param1MonitoredResourceDescriptor.type_;
        onChanged();
      } 
      if (!param1MonitoredResourceDescriptor.getDisplayName().isEmpty()) {
        this.displayName_ = param1MonitoredResourceDescriptor.displayName_;
        onChanged();
      } 
      if (!param1MonitoredResourceDescriptor.getDescription().isEmpty()) {
        this.description_ = param1MonitoredResourceDescriptor.description_;
        onChanged();
      } 
      if (this.labelsBuilder_ == null) {
        if (!param1MonitoredResourceDescriptor.labels_.isEmpty()) {
          if (this.labels_.isEmpty()) {
            this.labels_ = param1MonitoredResourceDescriptor.labels_;
            this.bitField0_ &= 0xFFFFFFEF;
          } else {
            ensureLabelsIsMutable();
            this.labels_.addAll(param1MonitoredResourceDescriptor.labels_);
          } 
          onChanged();
        } 
      } else if (!param1MonitoredResourceDescriptor.labels_.isEmpty()) {
        if (this.labelsBuilder_.isEmpty()) {
          this.labelsBuilder_.dispose();
          RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = null;
          this.labelsBuilder_ = null;
          this.labels_ = param1MonitoredResourceDescriptor.labels_;
          this.bitField0_ &= 0xFFFFFFEF;
          if (MonitoredResourceDescriptor.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getLabelsFieldBuilder(); 
          this.labelsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.labelsBuilder_.addAllMessages(param1MonitoredResourceDescriptor.labels_);
        } 
      } 
      if (param1MonitoredResourceDescriptor.launchStage_ != 0)
        setLaunchStageValue(param1MonitoredResourceDescriptor.getLaunchStageValue()); 
      mergeUnknownFields(param1MonitoredResourceDescriptor.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MonitoredResourceDescriptor monitoredResourceDescriptor = (MonitoredResourceDescriptor)MonitoredResourceDescriptor.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MonitoredResourceDescriptor monitoredResourceDescriptor = (MonitoredResourceDescriptor)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MonitoredResourceDescriptor)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MonitoredResourceDescriptor)
        return mergeFrom((MonitoredResourceDescriptor)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeLabels(int param1Int) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
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
        MonitoredResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisplayName(String param1String) {
      if (param1String != null) {
        this.displayName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MonitoredResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.displayName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLabelsIsMutable();
        this.labels_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LabelDescriptor != null) {
          ensureLabelsIsMutable();
          this.labels_.set(param1Int, param1LabelDescriptor);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1LabelDescriptor);
      return this;
    }
    
    public Builder setLaunchStage(LaunchStage param1LaunchStage) {
      if (param1LaunchStage != null) {
        this.launchStage_ = param1LaunchStage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLaunchStageValue(int param1Int) {
      this.launchStage_ = param1Int;
      onChanged();
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
        MonitoredResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        MonitoredResourceDescriptor.checkByteStringIsUtf8(param1ByteString);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResourceDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
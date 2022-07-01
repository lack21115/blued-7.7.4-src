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

public final class LogDescriptor extends GeneratedMessageV3 implements LogDescriptorOrBuilder {
  private static final LogDescriptor DEFAULT_INSTANCE = new LogDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 4;
  
  public static final int LABELS_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<LogDescriptor> PARSER = (Parser<LogDescriptor>)new AbstractParser<LogDescriptor>() {
      public LogDescriptor a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new LogDescriptor(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object description_;
  
  private volatile Object displayName_;
  
  private List<LabelDescriptor> labels_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private LogDescriptor() {
    this.name_ = "";
    this.labels_ = Collections.emptyList();
    this.description_ = "";
    this.displayName_ = "";
  }
  
  private LogDescriptor(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                  this.displayName_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.description_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.labels_ = new ArrayList<LabelDescriptor>();
                n = i | 0x2;
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
          this.labels_ = Collections.unmodifiableList(this.labels_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x2) != 0)
        this.labels_ = Collections.unmodifiableList(this.labels_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private LogDescriptor(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static LogDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return LogProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LogDescriptor paramLogDescriptor) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramLogDescriptor);
  }
  
  public static LogDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LogDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static LogDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LogDescriptor)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LogDescriptor)PARSER.parseFrom(paramByteString);
  }
  
  public static LogDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LogDescriptor)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LogDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static LogDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LogDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (LogDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static LogDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LogDescriptor)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (LogDescriptor)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static LogDescriptor parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LogDescriptor)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LogDescriptor)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static LogDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LogDescriptor)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LogDescriptor> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof LogDescriptor))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getLabelsList().equals(paramObject.getLabelsList()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!getDisplayName().equals(paramObject.getDisplayName()) ? false : (!!this.unknownFields.equals(((LogDescriptor)paramObject).unknownFields)))));
  }
  
  public LogDescriptor getDefaultInstanceForType() {
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
  
  public Parser<LogDescriptor> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getNameBytes().isEmpty();
    int j = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      i = 0;
    } 
    while (j < this.labels_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.labels_.get(j));
      j++;
    } 
    j = i;
    if (!getDescriptionBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.description_); 
    i = j;
    if (!getDisplayNameBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(4, this.displayName_); 
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
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode();
    int i = j;
    if (getLabelsCount() > 0)
      i = (j * 37 + 2) * 53 + getLabelsList().hashCode(); 
    i = ((((i * 37 + 3) * 53 + getDescription().hashCode()) * 37 + 4) * 53 + getDisplayName().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return LogProto.b.ensureFieldAccessorsInitialized(LogDescriptor.class, Builder.class);
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
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    for (int i = 0; i < this.labels_.size(); i++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.labels_.get(i)); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.description_); 
    if (!getDisplayNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.displayName_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LogDescriptorOrBuilder {
    private int bitField0_;
    
    private Object description_ = "";
    
    private Object displayName_ = "";
    
    private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> labelsBuilder_;
    
    private List<LabelDescriptor> labels_ = Collections.emptyList();
    
    private Object name_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureLabelsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.labels_ = new ArrayList<LabelDescriptor>(this.labels_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LogProto.a;
    }
    
    private RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> getLabelsFieldBuilder() {
      if (this.labelsBuilder_ == null) {
        boolean bool;
        List<LabelDescriptor> list = this.labels_;
        if ((this.bitField0_ & 0x2) != 0) {
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
      if (LogDescriptor.alwaysUseFieldBuilders)
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
    
    public LogDescriptor build() {
      LogDescriptor logDescriptor = buildPartial();
      if (logDescriptor.isInitialized())
        return logDescriptor; 
      throw newUninitializedMessageException(logDescriptor);
    }
    
    public LogDescriptor buildPartial() {
      LogDescriptor logDescriptor = new LogDescriptor(this);
      int i = this.bitField0_;
      LogDescriptor.access$402(logDescriptor, this.name_);
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.labels_ = Collections.unmodifiableList(this.labels_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        LogDescriptor.access$502(logDescriptor, this.labels_);
      } else {
        LogDescriptor.access$502(logDescriptor, repeatedFieldBuilderV3.build());
      } 
      LogDescriptor.access$602(logDescriptor, this.description_);
      LogDescriptor.access$702(logDescriptor, this.displayName_);
      LogDescriptor.access$802(logDescriptor, 0);
      onBuilt();
      return logDescriptor;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = this.labelsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.labels_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.description_ = "";
      this.displayName_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = LogDescriptor.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearDisplayName() {
      this.displayName_ = LogDescriptor.getDefaultInstance().getDisplayName();
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
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = LogDescriptor.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LogDescriptor getDefaultInstanceForType() {
      return LogDescriptor.getDefaultInstance();
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
      return LogProto.a;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LogProto.b.ensureFieldAccessorsInitialized(LogDescriptor.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LogDescriptor param1LogDescriptor) {
      if (param1LogDescriptor == LogDescriptor.getDefaultInstance())
        return this; 
      if (!param1LogDescriptor.getName().isEmpty()) {
        this.name_ = param1LogDescriptor.name_;
        onChanged();
      } 
      if (this.labelsBuilder_ == null) {
        if (!param1LogDescriptor.labels_.isEmpty()) {
          if (this.labels_.isEmpty()) {
            this.labels_ = param1LogDescriptor.labels_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureLabelsIsMutable();
            this.labels_.addAll(param1LogDescriptor.labels_);
          } 
          onChanged();
        } 
      } else if (!param1LogDescriptor.labels_.isEmpty()) {
        if (this.labelsBuilder_.isEmpty()) {
          this.labelsBuilder_.dispose();
          RepeatedFieldBuilderV3<LabelDescriptor, LabelDescriptor.Builder, LabelDescriptorOrBuilder> repeatedFieldBuilderV3 = null;
          this.labelsBuilder_ = null;
          this.labels_ = param1LogDescriptor.labels_;
          this.bitField0_ &= 0xFFFFFFFD;
          if (LogDescriptor.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getLabelsFieldBuilder(); 
          this.labelsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.labelsBuilder_.addAllMessages(param1LogDescriptor.labels_);
        } 
      } 
      if (!param1LogDescriptor.getDescription().isEmpty()) {
        this.description_ = param1LogDescriptor.description_;
        onChanged();
      } 
      if (!param1LogDescriptor.getDisplayName().isEmpty()) {
        this.displayName_ = param1LogDescriptor.displayName_;
        onChanged();
      } 
      mergeUnknownFields(param1LogDescriptor.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LogDescriptor logDescriptor = (LogDescriptor)LogDescriptor.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LogDescriptor logDescriptor = (LogDescriptor)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LogDescriptor)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LogDescriptor)
        return mergeFrom((LogDescriptor)param1Message); 
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
        LogDescriptor.checkByteStringIsUtf8(param1ByteString);
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
        LogDescriptor.checkByteStringIsUtf8(param1ByteString);
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
        LogDescriptor.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LogDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
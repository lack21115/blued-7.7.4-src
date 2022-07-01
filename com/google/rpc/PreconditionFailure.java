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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PreconditionFailure extends GeneratedMessageV3 implements PreconditionFailureOrBuilder {
  private static final PreconditionFailure DEFAULT_INSTANCE = new PreconditionFailure();
  
  private static final Parser<PreconditionFailure> PARSER = (Parser<PreconditionFailure>)new AbstractParser<PreconditionFailure>() {
      public PreconditionFailure a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new PreconditionFailure(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int VIOLATIONS_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private List<Violation> violations_;
  
  private PreconditionFailure() {
    this.violations_ = Collections.emptyList();
  }
  
  private PreconditionFailure(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.violations_ = new ArrayList<Violation>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.violations_.add(paramCodedInputStream.readMessage(Violation.parser(), paramExtensionRegistryLite));
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
          this.violations_ = Collections.unmodifiableList(this.violations_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.violations_ = Collections.unmodifiableList(this.violations_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private PreconditionFailure(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static PreconditionFailure getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.i;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(PreconditionFailure paramPreconditionFailure) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramPreconditionFailure);
  }
  
  public static PreconditionFailure parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static PreconditionFailure parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (PreconditionFailure)PARSER.parseFrom(paramByteString);
  }
  
  public static PreconditionFailure parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static PreconditionFailure parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(InputStream paramInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static PreconditionFailure parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (PreconditionFailure)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static PreconditionFailure parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (PreconditionFailure)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static PreconditionFailure parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<PreconditionFailure> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof PreconditionFailure))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getViolationsList().equals(paramObject.getViolationsList()) ? false : (!!this.unknownFields.equals(((PreconditionFailure)paramObject).unknownFields));
  }
  
  public PreconditionFailure getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<PreconditionFailure> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.violations_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.violations_.get(i));
      i++;
    } 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public Violation getViolations(int paramInt) {
    return this.violations_.get(paramInt);
  }
  
  public int getViolationsCount() {
    return this.violations_.size();
  }
  
  public List<Violation> getViolationsList() {
    return this.violations_;
  }
  
  public ViolationOrBuilder getViolationsOrBuilder(int paramInt) {
    return this.violations_.get(paramInt);
  }
  
  public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
    return (List)this.violations_;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getViolationsCount() > 0)
      i = (j * 37 + 1) * 53 + getViolationsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.j.ensureFieldAccessorsInitialized(PreconditionFailure.class, Builder.class);
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
    for (int i = 0; i < this.violations_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.violations_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PreconditionFailureOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> violationsBuilder_;
    
    private List<PreconditionFailure.Violation> violations_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureViolationsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.violations_ = new ArrayList<PreconditionFailure.Violation>(this.violations_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.i;
    }
    
    private RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> getViolationsFieldBuilder() {
      if (this.violationsBuilder_ == null) {
        List<PreconditionFailure.Violation> list = this.violations_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.violationsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.violations_ = null;
      } 
      return this.violationsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (PreconditionFailure.alwaysUseFieldBuilders)
        getViolationsFieldBuilder(); 
    }
    
    public Builder addAllViolations(Iterable<? extends PreconditionFailure.Violation> param1Iterable) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureViolationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.violations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addViolations(int param1Int, PreconditionFailure.Violation.Builder param1Builder) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureViolationsIsMutable();
        this.violations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addViolations(int param1Int, PreconditionFailure.Violation param1Violation) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Violation != null) {
          ensureViolationsIsMutable();
          this.violations_.add(param1Int, param1Violation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Violation);
      return this;
    }
    
    public Builder addViolations(PreconditionFailure.Violation.Builder param1Builder) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureViolationsIsMutable();
        this.violations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addViolations(PreconditionFailure.Violation param1Violation) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Violation != null) {
          ensureViolationsIsMutable();
          this.violations_.add(param1Violation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Violation);
      return this;
    }
    
    public PreconditionFailure.Violation.Builder addViolationsBuilder() {
      return (PreconditionFailure.Violation.Builder)getViolationsFieldBuilder().addBuilder((AbstractMessage)PreconditionFailure.Violation.getDefaultInstance());
    }
    
    public PreconditionFailure.Violation.Builder addViolationsBuilder(int param1Int) {
      return (PreconditionFailure.Violation.Builder)getViolationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)PreconditionFailure.Violation.getDefaultInstance());
    }
    
    public PreconditionFailure build() {
      PreconditionFailure preconditionFailure = buildPartial();
      if (preconditionFailure.isInitialized())
        return preconditionFailure; 
      throw newUninitializedMessageException(preconditionFailure);
    }
    
    public PreconditionFailure buildPartial() {
      PreconditionFailure preconditionFailure = new PreconditionFailure(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.violations_ = Collections.unmodifiableList(this.violations_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        PreconditionFailure.access$1702(preconditionFailure, this.violations_);
      } else {
        PreconditionFailure.access$1702(preconditionFailure, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return preconditionFailure;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.violations_ = Collections.emptyList();
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
    
    public Builder clearViolations() {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.violations_ = Collections.emptyList();
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
    
    public PreconditionFailure getDefaultInstanceForType() {
      return PreconditionFailure.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.i;
    }
    
    public PreconditionFailure.Violation getViolations(int param1Int) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.violations_.get(param1Int) : (PreconditionFailure.Violation)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public PreconditionFailure.Violation.Builder getViolationsBuilder(int param1Int) {
      return (PreconditionFailure.Violation.Builder)getViolationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<PreconditionFailure.Violation.Builder> getViolationsBuilderList() {
      return getViolationsFieldBuilder().getBuilderList();
    }
    
    public int getViolationsCount() {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.violations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<PreconditionFailure.Violation> getViolationsList() {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.violations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public PreconditionFailure.ViolationOrBuilder getViolationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.violations_.get(param1Int) : (PreconditionFailure.ViolationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends PreconditionFailure.ViolationOrBuilder> getViolationsOrBuilderList() {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.violations_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.j.ensureFieldAccessorsInitialized(PreconditionFailure.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PreconditionFailure preconditionFailure = (PreconditionFailure)PreconditionFailure.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PreconditionFailure preconditionFailure = (PreconditionFailure)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PreconditionFailure)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PreconditionFailure)
        return mergeFrom((PreconditionFailure)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PreconditionFailure param1PreconditionFailure) {
      if (param1PreconditionFailure == PreconditionFailure.getDefaultInstance())
        return this; 
      if (this.violationsBuilder_ == null) {
        if (!param1PreconditionFailure.violations_.isEmpty()) {
          if (this.violations_.isEmpty()) {
            this.violations_ = param1PreconditionFailure.violations_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureViolationsIsMutable();
            this.violations_.addAll(param1PreconditionFailure.violations_);
          } 
          onChanged();
        } 
      } else if (!param1PreconditionFailure.violations_.isEmpty()) {
        if (this.violationsBuilder_.isEmpty()) {
          this.violationsBuilder_.dispose();
          RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = null;
          this.violationsBuilder_ = null;
          this.violations_ = param1PreconditionFailure.violations_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (PreconditionFailure.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getViolationsFieldBuilder(); 
          this.violationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.violationsBuilder_.addAllMessages(param1PreconditionFailure.violations_);
        } 
      } 
      mergeUnknownFields(param1PreconditionFailure.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeViolations(int param1Int) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureViolationsIsMutable();
        this.violations_.remove(param1Int);
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
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setViolations(int param1Int, PreconditionFailure.Violation.Builder param1Builder) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureViolationsIsMutable();
        this.violations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setViolations(int param1Int, PreconditionFailure.Violation param1Violation) {
      RepeatedFieldBuilderV3<PreconditionFailure.Violation, PreconditionFailure.Violation.Builder, PreconditionFailure.ViolationOrBuilder> repeatedFieldBuilderV3 = this.violationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Violation != null) {
          ensureViolationsIsMutable();
          this.violations_.set(param1Int, param1Violation);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Violation);
      return this;
    }
  }
  
  public static final class Violation extends GeneratedMessageV3 implements ViolationOrBuilder {
    private static final Violation DEFAULT_INSTANCE = new Violation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    
    private static final Parser<Violation> PARSER = (Parser<Violation>)new AbstractParser<Violation>() {
        public PreconditionFailure.Violation a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PreconditionFailure.Violation(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SUBJECT_FIELD_NUMBER = 2;
    
    public static final int TYPE_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object description_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object subject_;
    
    private volatile Object type_;
    
    private Violation() {
      this.type_ = "";
      this.subject_ = "";
      this.description_ = "";
    }
    
    private Violation(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 26) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.description_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.subject_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.type_ = param1CodedInputStream.readStringRequireUtf8();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Violation(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Violation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.k;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Violation param1Violation) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Violation);
    }
    
    public static Violation parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Violation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Violation parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Violation)PARSER.parseFrom(param1ByteString);
    }
    
    public static Violation parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Violation)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Violation parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(InputStream param1InputStream) throws IOException {
      return (Violation)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Violation parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Violation)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Violation parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Violation)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Violation parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Violation> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Violation))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getType().equals(param1Object.getType()) ? false : (!getSubject().equals(param1Object.getSubject()) ? false : (!getDescription().equals(param1Object.getDescription()) ? false : (!!this.unknownFields.equals(((Violation)param1Object).unknownFields))));
    }
    
    public Violation getDefaultInstanceForType() {
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
    
    public Parser<Violation> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getTypeBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.type_); 
      i = j;
      if (!getSubjectBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.subject_); 
      j = i;
      if (!getDescriptionBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.description_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getSubject() {
      Object object = this.subject_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.subject_ = object;
      return (String)object;
    }
    
    public ByteString getSubjectBytes() {
      Object object = this.subject_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.subject_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getType().hashCode()) * 37 + 2) * 53 + getSubject().hashCode()) * 37 + 3) * 53 + getDescription().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.l.ensureFieldAccessorsInitialized(Violation.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.type_); 
      if (!getSubjectBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.subject_); 
      if (!getDescriptionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.description_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PreconditionFailure.ViolationOrBuilder {
      private Object description_ = "";
      
      private Object subject_ = "";
      
      private Object type_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ErrorDetailsProto.k;
      }
      
      private void maybeForceBuilderInitialization() {
        PreconditionFailure.Violation.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PreconditionFailure.Violation build() {
        PreconditionFailure.Violation violation = buildPartial();
        if (violation.isInitialized())
          return violation; 
        throw newUninitializedMessageException(violation);
      }
      
      public PreconditionFailure.Violation buildPartial() {
        PreconditionFailure.Violation violation = new PreconditionFailure.Violation(this);
        PreconditionFailure.Violation.access$402(violation, this.type_);
        PreconditionFailure.Violation.access$502(violation, this.subject_);
        PreconditionFailure.Violation.access$602(violation, this.description_);
        onBuilt();
        return violation;
      }
      
      public Builder clear() {
        super.clear();
        this.type_ = "";
        this.subject_ = "";
        this.description_ = "";
        return this;
      }
      
      public Builder clearDescription() {
        this.description_ = PreconditionFailure.Violation.getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearSubject() {
        this.subject_ = PreconditionFailure.Violation.getDefaultInstance().getSubject();
        onChanged();
        return this;
      }
      
      public Builder clearType() {
        this.type_ = PreconditionFailure.Violation.getDefaultInstance().getType();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public PreconditionFailure.Violation getDefaultInstanceForType() {
        return PreconditionFailure.Violation.getDefaultInstance();
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
        return ErrorDetailsProto.k;
      }
      
      public String getSubject() {
        Object object = this.subject_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.subject_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getSubjectBytes() {
        Object object = this.subject_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.subject_ = object;
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
        return ErrorDetailsProto.l.ensureFieldAccessorsInitialized(PreconditionFailure.Violation.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PreconditionFailure.Violation violation = (PreconditionFailure.Violation)PreconditionFailure.Violation.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PreconditionFailure.Violation violation = (PreconditionFailure.Violation)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PreconditionFailure.Violation)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PreconditionFailure.Violation)
          return mergeFrom((PreconditionFailure.Violation)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(PreconditionFailure.Violation param2Violation) {
        if (param2Violation == PreconditionFailure.Violation.getDefaultInstance())
          return this; 
        if (!param2Violation.getType().isEmpty()) {
          this.type_ = param2Violation.type_;
          onChanged();
        } 
        if (!param2Violation.getSubject().isEmpty()) {
          this.subject_ = param2Violation.subject_;
          onChanged();
        } 
        if (!param2Violation.getDescription().isEmpty()) {
          this.description_ = param2Violation.description_;
          onChanged();
        } 
        mergeUnknownFields(param2Violation.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setDescription(String param2String) {
        if (param2String != null) {
          this.description_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PreconditionFailure.Violation.checkByteStringIsUtf8(param2ByteString);
          this.description_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSubject(String param2String) {
        if (param2String != null) {
          this.subject_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSubjectBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PreconditionFailure.Violation.checkByteStringIsUtf8(param2ByteString);
          this.subject_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setType(String param2String) {
        if (param2String != null) {
          this.type_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PreconditionFailure.Violation.checkByteStringIsUtf8(param2ByteString);
          this.type_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Violation> {
    public PreconditionFailure.Violation a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PreconditionFailure.Violation(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Violation.Builder> implements ViolationOrBuilder {
    private Object description_ = "";
    
    private Object subject_ = "";
    
    private Object type_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.k;
    }
    
    private void maybeForceBuilderInitialization() {
      PreconditionFailure.Violation.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PreconditionFailure.Violation build() {
      PreconditionFailure.Violation violation = buildPartial();
      if (violation.isInitialized())
        return violation; 
      throw newUninitializedMessageException(violation);
    }
    
    public PreconditionFailure.Violation buildPartial() {
      PreconditionFailure.Violation violation = new PreconditionFailure.Violation(this);
      PreconditionFailure.Violation.access$402(violation, this.type_);
      PreconditionFailure.Violation.access$502(violation, this.subject_);
      PreconditionFailure.Violation.access$602(violation, this.description_);
      onBuilt();
      return violation;
    }
    
    public Builder clear() {
      super.clear();
      this.type_ = "";
      this.subject_ = "";
      this.description_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = PreconditionFailure.Violation.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSubject() {
      this.subject_ = PreconditionFailure.Violation.getDefaultInstance().getSubject();
      onChanged();
      return this;
    }
    
    public Builder clearType() {
      this.type_ = PreconditionFailure.Violation.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public PreconditionFailure.Violation getDefaultInstanceForType() {
      return PreconditionFailure.Violation.getDefaultInstance();
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
      return ErrorDetailsProto.k;
    }
    
    public String getSubject() {
      Object object = this.subject_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.subject_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSubjectBytes() {
      Object object = this.subject_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.subject_ = object;
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
      return ErrorDetailsProto.l.ensureFieldAccessorsInitialized(PreconditionFailure.Violation.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PreconditionFailure.Violation violation = (PreconditionFailure.Violation)PreconditionFailure.Violation.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PreconditionFailure.Violation violation = (PreconditionFailure.Violation)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PreconditionFailure.Violation)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PreconditionFailure.Violation)
        return mergeFrom((PreconditionFailure.Violation)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PreconditionFailure.Violation param1Violation) {
      if (param1Violation == PreconditionFailure.Violation.getDefaultInstance())
        return this; 
      if (!param1Violation.getType().isEmpty()) {
        this.type_ = param1Violation.type_;
        onChanged();
      } 
      if (!param1Violation.getSubject().isEmpty()) {
        this.subject_ = param1Violation.subject_;
        onChanged();
      } 
      if (!param1Violation.getDescription().isEmpty()) {
        this.description_ = param1Violation.description_;
        onChanged();
      } 
      mergeUnknownFields(param1Violation.unknownFields);
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
        PreconditionFailure.Violation.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
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
    
    public Builder setSubject(String param1String) {
      if (param1String != null) {
        this.subject_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSubjectBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PreconditionFailure.Violation.checkByteStringIsUtf8(param1ByteString);
        this.subject_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        PreconditionFailure.Violation.checkByteStringIsUtf8(param1ByteString);
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
  
  public static interface ViolationOrBuilder extends MessageOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getSubject();
    
    ByteString getSubjectBytes();
    
    String getType();
    
    ByteString getTypeBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\PreconditionFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
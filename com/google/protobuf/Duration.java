package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Duration extends GeneratedMessageV3 implements DurationOrBuilder {
  private static final Duration DEFAULT_INSTANCE = new Duration();
  
  public static final int NANOS_FIELD_NUMBER = 2;
  
  private static final Parser<Duration> PARSER = new AbstractParser<Duration>() {
      public Duration parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Duration(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SECONDS_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private int nanos_;
  
  private long seconds_;
  
  private Duration() {}
  
  private Duration(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 8) {
              if (i != 16) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.nanos_ = paramCodedInputStream.readInt32();
              continue;
            } 
            this.seconds_ = paramCodedInputStream.readInt64();
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
  
  private Duration(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Duration getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return DurationProto.internal_static_google_protobuf_Duration_descriptor;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Duration paramDuration) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDuration);
  }
  
  public static Duration parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Duration>parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Duration parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Duration>parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Duration parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString);
  }
  
  public static Duration parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Duration parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageV3.<Duration>parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Duration parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Duration>parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Duration parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageV3.<Duration>parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Duration parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageV3.<Duration>parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Duration parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Duration parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Duration parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Duration parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Duration> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Duration))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getSeconds() != paramObject.getSeconds()) ? false : ((getNanos() != paramObject.getNanos()) ? false : (!!this.unknownFields.equals(((Duration)paramObject).unknownFields)));
  }
  
  public Duration getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public Parser<Duration> getParserForType() {
    return PARSER;
  }
  
  public long getSeconds() {
    return this.seconds_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.seconds_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    int k = this.nanos_;
    int j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(2, k); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getSeconds())) * 37 + 2) * 53 + getNanos()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Duration.class, (Class)Builder.class);
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
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter) {
    return new Duration();
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.seconds_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    int i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DurationOrBuilder {
    private int nanos_;
    
    private long seconds_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Duration build() {
      Duration duration = buildPartial();
      if (duration.isInitialized())
        return duration; 
      throw newUninitializedMessageException(duration);
    }
    
    public Duration buildPartial() {
      Duration duration = new Duration(this);
      Duration.access$302(duration, this.seconds_);
      Duration.access$402(duration, this.nanos_);
      onBuilt();
      return duration;
    }
    
    public Builder clear() {
      super.clear();
      this.seconds_ = 0L;
      this.nanos_ = 0;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNanos() {
      this.nanos_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSeconds() {
      this.seconds_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return super.clone();
    }
    
    public Duration getDefaultInstanceForType() {
      return Duration.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DurationProto.internal_static_google_protobuf_Duration_descriptor;
    }
    
    public int getNanos() {
      return this.nanos_;
    }
    
    public long getSeconds() {
      return this.seconds_;
    }
    
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized((Class)Duration.class, (Class)Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Duration duration = Duration.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Duration duration = (Duration)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Duration)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Duration param1Duration) {
      if (param1Duration == Duration.getDefaultInstance())
        return this; 
      if (param1Duration.getSeconds() != 0L)
        setSeconds(param1Duration.getSeconds()); 
      if (param1Duration.getNanos() != 0)
        setNanos(param1Duration.getNanos()); 
      mergeUnknownFields(param1Duration.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Duration)
        return mergeFrom((Duration)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNanos(int param1Int) {
      this.nanos_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSeconds(long param1Long) {
      this.seconds_ = param1Long;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Duration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
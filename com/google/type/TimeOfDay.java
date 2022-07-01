package com.google.type;

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

public final class TimeOfDay extends GeneratedMessageV3 implements TimeOfDayOrBuilder {
  private static final TimeOfDay DEFAULT_INSTANCE = new TimeOfDay();
  
  public static final int HOURS_FIELD_NUMBER = 1;
  
  public static final int MINUTES_FIELD_NUMBER = 2;
  
  public static final int NANOS_FIELD_NUMBER = 4;
  
  private static final Parser<TimeOfDay> PARSER = (Parser<TimeOfDay>)new AbstractParser<TimeOfDay>() {
      public TimeOfDay a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new TimeOfDay(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SECONDS_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private int hours_;
  
  private byte memoizedIsInitialized = -1;
  
  private int minutes_;
  
  private int nanos_;
  
  private int seconds_;
  
  private TimeOfDay() {}
  
  private TimeOfDay(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 8) {
              if (i != 16) {
                if (i != 24) {
                  if (i != 32) {
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.nanos_ = paramCodedInputStream.readInt32();
                  continue;
                } 
                this.seconds_ = paramCodedInputStream.readInt32();
                continue;
              } 
              this.minutes_ = paramCodedInputStream.readInt32();
              continue;
            } 
            this.hours_ = paramCodedInputStream.readInt32();
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
  
  private TimeOfDay(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static TimeOfDay getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return TimeOfDayProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TimeOfDay paramTimeOfDay) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramTimeOfDay);
  }
  
  public static TimeOfDay parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static TimeOfDay parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TimeOfDay)PARSER.parseFrom(paramByteString);
  }
  
  public static TimeOfDay parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static TimeOfDay parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(InputStream paramInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static TimeOfDay parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (TimeOfDay)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static TimeOfDay parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TimeOfDay)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static TimeOfDay parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TimeOfDay> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof TimeOfDay))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getHours() != paramObject.getHours()) ? false : ((getMinutes() != paramObject.getMinutes()) ? false : ((getSeconds() != paramObject.getSeconds()) ? false : ((getNanos() != paramObject.getNanos()) ? false : (!!this.unknownFields.equals(((TimeOfDay)paramObject).unknownFields)))));
  }
  
  public TimeOfDay getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public int getHours() {
    return this.hours_;
  }
  
  public int getMinutes() {
    return this.minutes_;
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public Parser<TimeOfDay> getParserForType() {
    return PARSER;
  }
  
  public int getSeconds() {
    return this.seconds_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = this.hours_;
    if (i != 0)
      j = 0 + CodedOutputStream.computeInt32Size(1, i); 
    int k = this.minutes_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    k = this.seconds_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    k = this.nanos_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(4, k); 
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
    int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getHours()) * 37 + 2) * 53 + getMinutes()) * 37 + 3) * 53 + getSeconds()) * 37 + 4) * 53 + getNanos()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return TimeOfDayProto.b.ensureFieldAccessorsInitialized(TimeOfDay.class, Builder.class);
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
    int i = this.hours_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.minutes_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    i = this.seconds_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TimeOfDayOrBuilder {
    private int hours_;
    
    private int minutes_;
    
    private int nanos_;
    
    private int seconds_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return TimeOfDayProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      TimeOfDay.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public TimeOfDay build() {
      TimeOfDay timeOfDay = buildPartial();
      if (timeOfDay.isInitialized())
        return timeOfDay; 
      throw newUninitializedMessageException(timeOfDay);
    }
    
    public TimeOfDay buildPartial() {
      TimeOfDay timeOfDay = new TimeOfDay(this);
      TimeOfDay.access$402(timeOfDay, this.hours_);
      TimeOfDay.access$502(timeOfDay, this.minutes_);
      TimeOfDay.access$602(timeOfDay, this.seconds_);
      TimeOfDay.access$702(timeOfDay, this.nanos_);
      onBuilt();
      return timeOfDay;
    }
    
    public Builder clear() {
      super.clear();
      this.hours_ = 0;
      this.minutes_ = 0;
      this.seconds_ = 0;
      this.nanos_ = 0;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHours() {
      this.hours_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearMinutes() {
      this.minutes_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearNanos() {
      this.nanos_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSeconds() {
      this.seconds_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public TimeOfDay getDefaultInstanceForType() {
      return TimeOfDay.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return TimeOfDayProto.a;
    }
    
    public int getHours() {
      return this.hours_;
    }
    
    public int getMinutes() {
      return this.minutes_;
    }
    
    public int getNanos() {
      return this.nanos_;
    }
    
    public int getSeconds() {
      return this.seconds_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return TimeOfDayProto.b.ensureFieldAccessorsInitialized(TimeOfDay.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        TimeOfDay timeOfDay = (TimeOfDay)TimeOfDay.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        TimeOfDay timeOfDay = (TimeOfDay)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((TimeOfDay)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof TimeOfDay)
        return mergeFrom((TimeOfDay)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(TimeOfDay param1TimeOfDay) {
      if (param1TimeOfDay == TimeOfDay.getDefaultInstance())
        return this; 
      if (param1TimeOfDay.getHours() != 0)
        setHours(param1TimeOfDay.getHours()); 
      if (param1TimeOfDay.getMinutes() != 0)
        setMinutes(param1TimeOfDay.getMinutes()); 
      if (param1TimeOfDay.getSeconds() != 0)
        setSeconds(param1TimeOfDay.getSeconds()); 
      if (param1TimeOfDay.getNanos() != 0)
        setNanos(param1TimeOfDay.getNanos()); 
      mergeUnknownFields(param1TimeOfDay.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHours(int param1Int) {
      this.hours_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setMinutes(int param1Int) {
      this.minutes_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setNanos(int param1Int) {
      this.nanos_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSeconds(int param1Int) {
      this.seconds_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\TimeOfDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
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

public final class Date extends GeneratedMessageV3 implements DateOrBuilder {
  public static final int DAY_FIELD_NUMBER = 3;
  
  private static final Date DEFAULT_INSTANCE = new Date();
  
  public static final int MONTH_FIELD_NUMBER = 2;
  
  private static final Parser<Date> PARSER = (Parser<Date>)new AbstractParser<Date>() {
      public Date a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Date(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int YEAR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int day_;
  
  private byte memoizedIsInitialized = -1;
  
  private int month_;
  
  private int year_;
  
  private Date() {}
  
  private Date(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.day_ = paramCodedInputStream.readInt32();
                continue;
              } 
              this.month_ = paramCodedInputStream.readInt32();
              continue;
            } 
            this.year_ = paramCodedInputStream.readInt32();
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
  
  private Date(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Date getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return DateProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Date paramDate) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDate);
  }
  
  public static Date parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Date)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Date parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Date)PARSER.parseFrom(paramByteString);
  }
  
  public static Date parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Date)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Date parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(InputStream paramInputStream) throws IOException {
    return (Date)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Date parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Date)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Date parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Date)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Date parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Date> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Date))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getYear() != paramObject.getYear()) ? false : ((getMonth() != paramObject.getMonth()) ? false : ((getDay() != paramObject.getDay()) ? false : (!!this.unknownFields.equals(((Date)paramObject).unknownFields))));
  }
  
  public int getDay() {
    return this.day_;
  }
  
  public Date getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public int getMonth() {
    return this.month_;
  }
  
  public Parser<Date> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = this.year_;
    if (i != 0)
      j = 0 + CodedOutputStream.computeInt32Size(1, i); 
    int k = this.month_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    k = this.day_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int getYear() {
    return this.year_;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getYear()) * 37 + 2) * 53 + getMonth()) * 37 + 3) * 53 + getDay()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return DateProto.b.ensureFieldAccessorsInitialized(Date.class, Builder.class);
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
    int i = this.year_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.month_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    i = this.day_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DateOrBuilder {
    private int day_;
    
    private int month_;
    
    private int year_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DateProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Date.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Date build() {
      Date date = buildPartial();
      if (date.isInitialized())
        return date; 
      throw newUninitializedMessageException(date);
    }
    
    public Date buildPartial() {
      Date date = new Date(this);
      Date.access$402(date, this.year_);
      Date.access$502(date, this.month_);
      Date.access$602(date, this.day_);
      onBuilt();
      return date;
    }
    
    public Builder clear() {
      super.clear();
      this.year_ = 0;
      this.month_ = 0;
      this.day_ = 0;
      return this;
    }
    
    public Builder clearDay() {
      this.day_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMonth() {
      this.month_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearYear() {
      this.year_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public int getDay() {
      return this.day_;
    }
    
    public Date getDefaultInstanceForType() {
      return Date.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DateProto.a;
    }
    
    public int getMonth() {
      return this.month_;
    }
    
    public int getYear() {
      return this.year_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DateProto.b.ensureFieldAccessorsInitialized(Date.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Date date = (Date)Date.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Date date = (Date)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Date)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Date)
        return mergeFrom((Date)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Date param1Date) {
      if (param1Date == Date.getDefaultInstance())
        return this; 
      if (param1Date.getYear() != 0)
        setYear(param1Date.getYear()); 
      if (param1Date.getMonth() != 0)
        setMonth(param1Date.getMonth()); 
      if (param1Date.getDay() != 0)
        setDay(param1Date.getDay()); 
      mergeUnknownFields(param1Date.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDay(int param1Int) {
      this.day_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMonth(int param1Int) {
      this.month_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setYear(int param1Int) {
      this.year_ = param1Int;
      onChanged();
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\Date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
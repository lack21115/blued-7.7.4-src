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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Fraction extends GeneratedMessageV3 implements FractionOrBuilder {
  private static final Fraction DEFAULT_INSTANCE = new Fraction();
  
  public static final int DENOMINATOR_FIELD_NUMBER = 2;
  
  public static final int NUMERATOR_FIELD_NUMBER = 1;
  
  private static final Parser<Fraction> PARSER = (Parser<Fraction>)new AbstractParser<Fraction>() {
      public Fraction a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Fraction(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private long denominator_;
  
  private byte memoizedIsInitialized = -1;
  
  private long numerator_;
  
  private Fraction() {}
  
  private Fraction(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.denominator_ = paramCodedInputStream.readInt64();
              continue;
            } 
            this.numerator_ = paramCodedInputStream.readInt64();
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
  
  private Fraction(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Fraction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return FractionProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Fraction paramFraction) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramFraction);
  }
  
  public static Fraction parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Fraction)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Fraction parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Fraction)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Fraction parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Fraction)PARSER.parseFrom(paramByteString);
  }
  
  public static Fraction parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Fraction)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Fraction parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Fraction)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Fraction parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Fraction)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Fraction parseFrom(InputStream paramInputStream) throws IOException {
    return (Fraction)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Fraction parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Fraction)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Fraction parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Fraction)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Fraction parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Fraction)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Fraction parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Fraction)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Fraction parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Fraction)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Fraction> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Fraction))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getNumerator() != paramObject.getNumerator()) ? false : ((getDenominator() != paramObject.getDenominator()) ? false : (!!this.unknownFields.equals(((Fraction)paramObject).unknownFields)));
  }
  
  public Fraction getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public long getDenominator() {
    return this.denominator_;
  }
  
  public long getNumerator() {
    return this.numerator_;
  }
  
  public Parser<Fraction> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.numerator_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    l = this.denominator_;
    int j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(2, l); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getNumerator())) * 37 + 2) * 53 + Internal.hashLong(getDenominator())) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return FractionProto.b.ensureFieldAccessorsInitialized(Fraction.class, Builder.class);
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
    long l = this.numerator_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    l = this.denominator_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FractionOrBuilder {
    private long denominator_;
    
    private long numerator_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return FractionProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Fraction.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Fraction build() {
      Fraction fraction = buildPartial();
      if (fraction.isInitialized())
        return fraction; 
      throw newUninitializedMessageException(fraction);
    }
    
    public Fraction buildPartial() {
      Fraction fraction = new Fraction(this);
      Fraction.access$402(fraction, this.numerator_);
      Fraction.access$502(fraction, this.denominator_);
      onBuilt();
      return fraction;
    }
    
    public Builder clear() {
      super.clear();
      this.numerator_ = 0L;
      this.denominator_ = 0L;
      return this;
    }
    
    public Builder clearDenominator() {
      this.denominator_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNumerator() {
      this.numerator_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Fraction getDefaultInstanceForType() {
      return Fraction.getDefaultInstance();
    }
    
    public long getDenominator() {
      return this.denominator_;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return FractionProto.a;
    }
    
    public long getNumerator() {
      return this.numerator_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return FractionProto.b.ensureFieldAccessorsInitialized(Fraction.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Fraction fraction = (Fraction)Fraction.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Fraction fraction = (Fraction)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Fraction)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Fraction)
        return mergeFrom((Fraction)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Fraction param1Fraction) {
      if (param1Fraction == Fraction.getDefaultInstance())
        return this; 
      if (param1Fraction.getNumerator() != 0L)
        setNumerator(param1Fraction.getNumerator()); 
      if (param1Fraction.getDenominator() != 0L)
        setDenominator(param1Fraction.getDenominator()); 
      mergeUnknownFields(param1Fraction.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDenominator(long param1Long) {
      this.denominator_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNumerator(long param1Long) {
      this.numerator_ = param1Long;
      onChanged();
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\Fraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
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

public final class Quaternion extends GeneratedMessageV3 implements QuaternionOrBuilder {
  private static final Quaternion DEFAULT_INSTANCE = new Quaternion();
  
  private static final Parser<Quaternion> PARSER = (Parser<Quaternion>)new AbstractParser<Quaternion>() {
      public Quaternion a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Quaternion(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int W_FIELD_NUMBER = 4;
  
  public static final int X_FIELD_NUMBER = 1;
  
  public static final int Y_FIELD_NUMBER = 2;
  
  public static final int Z_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private byte memoizedIsInitialized = -1;
  
  private double w_;
  
  private double x_;
  
  private double y_;
  
  private double z_;
  
  private Quaternion() {}
  
  private Quaternion(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 9) {
              if (i != 17) {
                if (i != 25) {
                  if (i != 33) {
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.w_ = paramCodedInputStream.readDouble();
                  continue;
                } 
                this.z_ = paramCodedInputStream.readDouble();
                continue;
              } 
              this.y_ = paramCodedInputStream.readDouble();
              continue;
            } 
            this.x_ = paramCodedInputStream.readDouble();
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
  
  private Quaternion(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Quaternion getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return QuaternionProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Quaternion paramQuaternion) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramQuaternion);
  }
  
  public static Quaternion parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Quaternion)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Quaternion parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quaternion)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Quaternion parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Quaternion)PARSER.parseFrom(paramByteString);
  }
  
  public static Quaternion parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quaternion)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Quaternion parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Quaternion)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Quaternion parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quaternion)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Quaternion parseFrom(InputStream paramInputStream) throws IOException {
    return (Quaternion)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Quaternion parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quaternion)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Quaternion parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Quaternion)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Quaternion parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quaternion)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Quaternion parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Quaternion)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Quaternion parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quaternion)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Quaternion> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Quaternion))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (Double.doubleToLongBits(getX()) != Double.doubleToLongBits(paramObject.getX())) ? false : ((Double.doubleToLongBits(getY()) != Double.doubleToLongBits(paramObject.getY())) ? false : ((Double.doubleToLongBits(getZ()) != Double.doubleToLongBits(paramObject.getZ())) ? false : ((Double.doubleToLongBits(getW()) != Double.doubleToLongBits(paramObject.getW())) ? false : (!!this.unknownFields.equals(((Quaternion)paramObject).unknownFields)))));
  }
  
  public Quaternion getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Quaternion> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    double d = this.x_;
    if (d != 0.0D)
      j = 0 + CodedOutputStream.computeDoubleSize(1, d); 
    d = this.y_;
    i = j;
    if (d != 0.0D)
      i = j + CodedOutputStream.computeDoubleSize(2, d); 
    d = this.z_;
    j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(3, d); 
    d = this.w_;
    i = j;
    if (d != 0.0D)
      i = j + CodedOutputStream.computeDoubleSize(4, d); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public double getW() {
    return this.w_;
  }
  
  public double getX() {
    return this.x_;
  }
  
  public double getY() {
    return this.y_;
  }
  
  public double getZ() {
    return this.z_;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(Double.doubleToLongBits(getX()))) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getY()))) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getZ()))) * 37 + 4) * 53 + Internal.hashLong(Double.doubleToLongBits(getW()))) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return QuaternionProto.b.ensureFieldAccessorsInitialized(Quaternion.class, Builder.class);
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
    double d = this.x_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(1, d); 
    d = this.y_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(2, d); 
    d = this.z_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(3, d); 
    d = this.w_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(4, d); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuaternionOrBuilder {
    private double w_;
    
    private double x_;
    
    private double y_;
    
    private double z_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return QuaternionProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Quaternion.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Quaternion build() {
      Quaternion quaternion = buildPartial();
      if (quaternion.isInitialized())
        return quaternion; 
      throw newUninitializedMessageException(quaternion);
    }
    
    public Quaternion buildPartial() {
      Quaternion quaternion = new Quaternion(this);
      Quaternion.access$402(quaternion, this.x_);
      Quaternion.access$502(quaternion, this.y_);
      Quaternion.access$602(quaternion, this.z_);
      Quaternion.access$702(quaternion, this.w_);
      onBuilt();
      return quaternion;
    }
    
    public Builder clear() {
      super.clear();
      this.x_ = 0.0D;
      this.y_ = 0.0D;
      this.z_ = 0.0D;
      this.w_ = 0.0D;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearW() {
      this.w_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearX() {
      this.x_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearY() {
      this.y_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearZ() {
      this.z_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Quaternion getDefaultInstanceForType() {
      return Quaternion.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return QuaternionProto.a;
    }
    
    public double getW() {
      return this.w_;
    }
    
    public double getX() {
      return this.x_;
    }
    
    public double getY() {
      return this.y_;
    }
    
    public double getZ() {
      return this.z_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return QuaternionProto.b.ensureFieldAccessorsInitialized(Quaternion.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Quaternion quaternion = (Quaternion)Quaternion.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Quaternion quaternion = (Quaternion)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Quaternion)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Quaternion)
        return mergeFrom((Quaternion)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Quaternion param1Quaternion) {
      if (param1Quaternion == Quaternion.getDefaultInstance())
        return this; 
      if (param1Quaternion.getX() != 0.0D)
        setX(param1Quaternion.getX()); 
      if (param1Quaternion.getY() != 0.0D)
        setY(param1Quaternion.getY()); 
      if (param1Quaternion.getZ() != 0.0D)
        setZ(param1Quaternion.getZ()); 
      if (param1Quaternion.getW() != 0.0D)
        setW(param1Quaternion.getW()); 
      mergeUnknownFields(param1Quaternion.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
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
    
    public Builder setW(double param1Double) {
      this.w_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setX(double param1Double) {
      this.x_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setY(double param1Double) {
      this.y_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setZ(double param1Double) {
      this.z_ = param1Double;
      onChanged();
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\Quaternion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
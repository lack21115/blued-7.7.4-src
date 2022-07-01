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

public final class LatLng extends GeneratedMessageV3 implements LatLngOrBuilder {
  private static final LatLng DEFAULT_INSTANCE = new LatLng();
  
  public static final int LATITUDE_FIELD_NUMBER = 1;
  
  public static final int LONGITUDE_FIELD_NUMBER = 2;
  
  private static final Parser<LatLng> PARSER = (Parser<LatLng>)new AbstractParser<LatLng>() {
      public LatLng a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new LatLng(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private double latitude_;
  
  private double longitude_;
  
  private byte memoizedIsInitialized = -1;
  
  private LatLng() {}
  
  private LatLng(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 9) {
              if (i != 17) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.longitude_ = paramCodedInputStream.readDouble();
              continue;
            } 
            this.latitude_ = paramCodedInputStream.readDouble();
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
  
  private LatLng(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static LatLng getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return LatLngProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LatLng paramLatLng) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramLatLng);
  }
  
  public static LatLng parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LatLng)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static LatLng parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LatLng)PARSER.parseFrom(paramByteString);
  }
  
  public static LatLng parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LatLng)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static LatLng parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(InputStream paramInputStream) throws IOException {
    return (LatLng)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static LatLng parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (LatLng)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static LatLng parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LatLng)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static LatLng parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LatLng> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof LatLng))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (Double.doubleToLongBits(getLatitude()) != Double.doubleToLongBits(paramObject.getLatitude())) ? false : ((Double.doubleToLongBits(getLongitude()) != Double.doubleToLongBits(paramObject.getLongitude())) ? false : (!!this.unknownFields.equals(((LatLng)paramObject).unknownFields)));
  }
  
  public LatLng getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public double getLatitude() {
    return this.latitude_;
  }
  
  public double getLongitude() {
    return this.longitude_;
  }
  
  public Parser<LatLng> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    double d = this.latitude_;
    if (d != 0.0D)
      i = 0 + CodedOutputStream.computeDoubleSize(1, d); 
    d = this.longitude_;
    int j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(2, d); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(Double.doubleToLongBits(getLatitude()))) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getLongitude()))) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return LatLngProto.b.ensureFieldAccessorsInitialized(LatLng.class, Builder.class);
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
    double d = this.latitude_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(1, d); 
    d = this.longitude_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(2, d); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LatLngOrBuilder {
    private double latitude_;
    
    private double longitude_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LatLngProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      LatLng.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LatLng build() {
      LatLng latLng = buildPartial();
      if (latLng.isInitialized())
        return latLng; 
      throw newUninitializedMessageException(latLng);
    }
    
    public LatLng buildPartial() {
      LatLng latLng = new LatLng(this);
      LatLng.access$402(latLng, this.latitude_);
      LatLng.access$502(latLng, this.longitude_);
      onBuilt();
      return latLng;
    }
    
    public Builder clear() {
      super.clear();
      this.latitude_ = 0.0D;
      this.longitude_ = 0.0D;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLatitude() {
      this.latitude_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearLongitude() {
      this.longitude_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LatLng getDefaultInstanceForType() {
      return LatLng.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LatLngProto.a;
    }
    
    public double getLatitude() {
      return this.latitude_;
    }
    
    public double getLongitude() {
      return this.longitude_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LatLngProto.b.ensureFieldAccessorsInitialized(LatLng.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LatLng latLng = (LatLng)LatLng.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LatLng latLng = (LatLng)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LatLng)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LatLng)
        return mergeFrom((LatLng)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(LatLng param1LatLng) {
      if (param1LatLng == LatLng.getDefaultInstance())
        return this; 
      if (param1LatLng.getLatitude() != 0.0D)
        setLatitude(param1LatLng.getLatitude()); 
      if (param1LatLng.getLongitude() != 0.0D)
        setLongitude(param1LatLng.getLongitude()); 
      mergeUnknownFields(param1LatLng.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLatitude(double param1Double) {
      this.latitude_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setLongitude(double param1Double) {
      this.longitude_ = param1Double;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
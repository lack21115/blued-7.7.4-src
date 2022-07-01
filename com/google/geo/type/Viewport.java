package com.google.geo.type;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.type.LatLng;
import com.google.type.LatLngOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Viewport extends GeneratedMessageV3 implements ViewportOrBuilder {
  private static final Viewport DEFAULT_INSTANCE = new Viewport();
  
  public static final int HIGH_FIELD_NUMBER = 2;
  
  public static final int LOW_FIELD_NUMBER = 1;
  
  private static final Parser<Viewport> PARSER = (Parser<Viewport>)new AbstractParser<Viewport>() {
      public Viewport a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Viewport(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private LatLng high_;
  
  private LatLng low_;
  
  private byte memoizedIsInitialized = -1;
  
  private Viewport() {}
  
  private Viewport(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            LatLng.Builder builder2 = null;
            LatLng.Builder builder1 = null;
            if (i != 10) {
              if (i != 18) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              if (this.high_ != null)
                builder1 = this.high_.toBuilder(); 
              this.high_ = (LatLng)paramCodedInputStream.readMessage(LatLng.parser(), paramExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom(this.high_);
                this.high_ = builder1.buildPartial();
              } 
              continue;
            } 
            builder1 = builder2;
            if (this.low_ != null)
              builder1 = this.low_.toBuilder(); 
            this.low_ = (LatLng)paramCodedInputStream.readMessage(LatLng.parser(), paramExtensionRegistryLite);
            if (builder1 != null) {
              builder1.mergeFrom(this.low_);
              this.low_ = builder1.buildPartial();
            } 
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
  
  private Viewport(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Viewport getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ViewportProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Viewport paramViewport) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramViewport);
  }
  
  public static Viewport parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Viewport)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Viewport parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Viewport)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Viewport parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Viewport)PARSER.parseFrom(paramByteString);
  }
  
  public static Viewport parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Viewport)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Viewport parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Viewport)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Viewport parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Viewport)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Viewport parseFrom(InputStream paramInputStream) throws IOException {
    return (Viewport)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Viewport parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Viewport)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Viewport parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Viewport)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Viewport parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Viewport)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Viewport parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Viewport)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Viewport parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Viewport)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Viewport> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Viewport))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (hasLow() != paramObject.hasLow()) ? false : ((hasLow() && !getLow().equals(paramObject.getLow())) ? false : ((hasHigh() != paramObject.hasHigh()) ? false : ((hasHigh() && !getHigh().equals(paramObject.getHigh())) ? false : (!!this.unknownFields.equals(((Viewport)paramObject).unknownFields)))));
  }
  
  public Viewport getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public LatLng getHigh() {
    LatLng latLng2 = this.high_;
    LatLng latLng1 = latLng2;
    if (latLng2 == null)
      latLng1 = LatLng.getDefaultInstance(); 
    return latLng1;
  }
  
  public LatLngOrBuilder getHighOrBuilder() {
    return (LatLngOrBuilder)getHigh();
  }
  
  public LatLng getLow() {
    LatLng latLng2 = this.low_;
    LatLng latLng1 = latLng2;
    if (latLng2 == null)
      latLng1 = LatLng.getDefaultInstance(); 
    return latLng1;
  }
  
  public LatLngOrBuilder getLowOrBuilder() {
    return (LatLngOrBuilder)getLow();
  }
  
  public Parser<Viewport> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.low_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getLow()); 
    int j = i;
    if (this.high_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getHigh()); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasHigh() {
    return (this.high_ != null);
  }
  
  public boolean hasLow() {
    return (this.low_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (hasLow())
      i = (j * 37 + 1) * 53 + getLow().hashCode(); 
    j = i;
    if (hasHigh())
      j = (i * 37 + 2) * 53 + getHigh().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ViewportProto.b.ensureFieldAccessorsInitialized(Viewport.class, Builder.class);
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
    if (this.low_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getLow()); 
    if (this.high_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getHigh()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ViewportOrBuilder {
    private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> highBuilder_;
    
    private LatLng high_;
    
    private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> lowBuilder_;
    
    private LatLng low_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ViewportProto.a;
    }
    
    private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> getHighFieldBuilder() {
      if (this.highBuilder_ == null) {
        this.highBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getHigh(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.high_ = null;
      } 
      return this.highBuilder_;
    }
    
    private SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> getLowFieldBuilder() {
      if (this.lowBuilder_ == null) {
        this.lowBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLow(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.low_ = null;
      } 
      return this.lowBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      Viewport.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Viewport build() {
      Viewport viewport = buildPartial();
      if (viewport.isInitialized())
        return viewport; 
      throw newUninitializedMessageException(viewport);
    }
    
    public Viewport buildPartial() {
      Viewport viewport = new Viewport(this);
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
      if (singleFieldBuilderV3 == null) {
        Viewport.access$402(viewport, this.low_);
      } else {
        Viewport.access$402(viewport, (LatLng)singleFieldBuilderV3.build());
      } 
      singleFieldBuilderV3 = this.highBuilder_;
      if (singleFieldBuilderV3 == null) {
        Viewport.access$502(viewport, this.high_);
      } else {
        Viewport.access$502(viewport, (LatLng)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return viewport;
    }
    
    public Builder clear() {
      super.clear();
      if (this.lowBuilder_ == null) {
        this.low_ = null;
      } else {
        this.low_ = null;
        this.lowBuilder_ = null;
      } 
      if (this.highBuilder_ == null) {
        this.high_ = null;
        return this;
      } 
      this.high_ = null;
      this.highBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHigh() {
      if (this.highBuilder_ == null) {
        this.high_ = null;
        onChanged();
        return this;
      } 
      this.high_ = null;
      this.highBuilder_ = null;
      return this;
    }
    
    public Builder clearLow() {
      if (this.lowBuilder_ == null) {
        this.low_ = null;
        onChanged();
        return this;
      } 
      this.low_ = null;
      this.lowBuilder_ = null;
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Viewport getDefaultInstanceForType() {
      return Viewport.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ViewportProto.a;
    }
    
    public LatLng getHigh() {
      LatLng latLng;
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
      if (singleFieldBuilderV3 == null) {
        LatLng latLng1 = this.high_;
        latLng = latLng1;
        if (latLng1 == null)
          latLng = LatLng.getDefaultInstance(); 
        return latLng;
      } 
      return (LatLng)latLng.getMessage();
    }
    
    public LatLng.Builder getHighBuilder() {
      onChanged();
      return (LatLng.Builder)getHighFieldBuilder().getBuilder();
    }
    
    public LatLngOrBuilder getHighOrBuilder() {
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
      if (singleFieldBuilderV3 != null)
        return (LatLngOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      LatLng latLng2 = this.high_;
      LatLng latLng1 = latLng2;
      if (latLng2 == null)
        latLng1 = LatLng.getDefaultInstance(); 
      return (LatLngOrBuilder)latLng1;
    }
    
    public LatLng getLow() {
      LatLng latLng;
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
      if (singleFieldBuilderV3 == null) {
        LatLng latLng1 = this.low_;
        latLng = latLng1;
        if (latLng1 == null)
          latLng = LatLng.getDefaultInstance(); 
        return latLng;
      } 
      return (LatLng)latLng.getMessage();
    }
    
    public LatLng.Builder getLowBuilder() {
      onChanged();
      return (LatLng.Builder)getLowFieldBuilder().getBuilder();
    }
    
    public LatLngOrBuilder getLowOrBuilder() {
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
      if (singleFieldBuilderV3 != null)
        return (LatLngOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      LatLng latLng2 = this.low_;
      LatLng latLng1 = latLng2;
      if (latLng2 == null)
        latLng1 = LatLng.getDefaultInstance(); 
      return (LatLngOrBuilder)latLng1;
    }
    
    public boolean hasHigh() {
      return (this.highBuilder_ != null || this.high_ != null);
    }
    
    public boolean hasLow() {
      return (this.lowBuilder_ != null || this.low_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ViewportProto.b.ensureFieldAccessorsInitialized(Viewport.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Viewport param1Viewport) {
      if (param1Viewport == Viewport.getDefaultInstance())
        return this; 
      if (param1Viewport.hasLow())
        mergeLow(param1Viewport.getLow()); 
      if (param1Viewport.hasHigh())
        mergeHigh(param1Viewport.getHigh()); 
      mergeUnknownFields(param1Viewport.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Viewport viewport = (Viewport)Viewport.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Viewport viewport = (Viewport)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Viewport)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Viewport)
        return mergeFrom((Viewport)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeHigh(LatLng param1LatLng) {
      LatLng latLng;
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
      if (singleFieldBuilderV3 == null) {
        latLng = this.high_;
        if (latLng != null) {
          this.high_ = LatLng.newBuilder(latLng).mergeFrom(param1LatLng).buildPartial();
        } else {
          this.high_ = param1LatLng;
        } 
        onChanged();
        return this;
      } 
      latLng.mergeFrom((AbstractMessage)param1LatLng);
      return this;
    }
    
    public Builder mergeLow(LatLng param1LatLng) {
      LatLng latLng;
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
      if (singleFieldBuilderV3 == null) {
        latLng = this.low_;
        if (latLng != null) {
          this.low_ = LatLng.newBuilder(latLng).mergeFrom(param1LatLng).buildPartial();
        } else {
          this.low_ = param1LatLng;
        } 
        onChanged();
        return this;
      } 
      latLng.mergeFrom((AbstractMessage)param1LatLng);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHigh(LatLng.Builder param1Builder) {
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.high_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setHigh(LatLng param1LatLng) {
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.highBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1LatLng != null) {
          this.high_ = param1LatLng;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1LatLng);
      return this;
    }
    
    public Builder setLow(LatLng.Builder param1Builder) {
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.low_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLow(LatLng param1LatLng) {
      SingleFieldBuilderV3<LatLng, LatLng.Builder, LatLngOrBuilder> singleFieldBuilderV3 = this.lowBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1LatLng != null) {
          this.low_ = param1LatLng;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1LatLng);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\geo\type\Viewport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
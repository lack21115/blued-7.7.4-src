package com.google.type;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.FloatValueOrBuilder;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Color extends GeneratedMessageV3 implements ColorOrBuilder {
  public static final int ALPHA_FIELD_NUMBER = 4;
  
  public static final int BLUE_FIELD_NUMBER = 3;
  
  private static final Color DEFAULT_INSTANCE = new Color();
  
  public static final int GREEN_FIELD_NUMBER = 2;
  
  private static final Parser<Color> PARSER = (Parser<Color>)new AbstractParser<Color>() {
      public Color a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Color(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RED_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private FloatValue alpha_;
  
  private float blue_;
  
  private float green_;
  
  private byte memoizedIsInitialized = -1;
  
  private float red_;
  
  private Color() {}
  
  private Color(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 13) {
              if (i != 21) {
                if (i != 29) {
                  if (i != 34) {
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  FloatValue.Builder builder1 = null;
                  if (this.alpha_ != null)
                    builder1 = this.alpha_.toBuilder(); 
                  this.alpha_ = (FloatValue)paramCodedInputStream.readMessage(FloatValue.parser(), paramExtensionRegistryLite);
                  if (builder1 != null) {
                    builder1.mergeFrom(this.alpha_);
                    this.alpha_ = builder1.buildPartial();
                  } 
                  continue;
                } 
                this.blue_ = paramCodedInputStream.readFloat();
                continue;
              } 
              this.green_ = paramCodedInputStream.readFloat();
              continue;
            } 
            this.red_ = paramCodedInputStream.readFloat();
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
  
  private Color(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Color getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ColorProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Color paramColor) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramColor);
  }
  
  public static Color parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Color)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Color parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Color)PARSER.parseFrom(paramByteString);
  }
  
  public static Color parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Color)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Color parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(InputStream paramInputStream) throws IOException {
    return (Color)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Color parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Color)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Color parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Color)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Color parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Color> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Color))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (Float.floatToIntBits(getRed()) != Float.floatToIntBits(paramObject.getRed())) ? false : ((Float.floatToIntBits(getGreen()) != Float.floatToIntBits(paramObject.getGreen())) ? false : ((Float.floatToIntBits(getBlue()) != Float.floatToIntBits(paramObject.getBlue())) ? false : ((hasAlpha() != paramObject.hasAlpha()) ? false : ((hasAlpha() && !getAlpha().equals(paramObject.getAlpha())) ? false : (!!this.unknownFields.equals(((Color)paramObject).unknownFields))))));
  }
  
  public FloatValue getAlpha() {
    FloatValue floatValue2 = this.alpha_;
    FloatValue floatValue1 = floatValue2;
    if (floatValue2 == null)
      floatValue1 = FloatValue.getDefaultInstance(); 
    return floatValue1;
  }
  
  public FloatValueOrBuilder getAlphaOrBuilder() {
    return (FloatValueOrBuilder)getAlpha();
  }
  
  public float getBlue() {
    return this.blue_;
  }
  
  public Color getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public float getGreen() {
    return this.green_;
  }
  
  public Parser<Color> getParserForType() {
    return PARSER;
  }
  
  public float getRed() {
    return this.red_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    float f = this.red_;
    if (f != 0.0F)
      j = 0 + CodedOutputStream.computeFloatSize(1, f); 
    f = this.green_;
    i = j;
    if (f != 0.0F)
      i = j + CodedOutputStream.computeFloatSize(2, f); 
    f = this.blue_;
    j = i;
    if (f != 0.0F)
      j = i + CodedOutputStream.computeFloatSize(3, f); 
    i = j;
    if (this.alpha_ != null)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getAlpha()); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasAlpha() {
    return (this.alpha_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Float.floatToIntBits(getRed())) * 37 + 2) * 53 + Float.floatToIntBits(getGreen())) * 37 + 3) * 53 + Float.floatToIntBits(getBlue());
    int i = j;
    if (hasAlpha())
      i = (j * 37 + 4) * 53 + getAlpha().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ColorProto.b.ensureFieldAccessorsInitialized(Color.class, Builder.class);
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
    float f = this.red_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(1, f); 
    f = this.green_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(2, f); 
    f = this.blue_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(3, f); 
    if (this.alpha_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getAlpha()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ColorOrBuilder {
    private SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> alphaBuilder_;
    
    private FloatValue alpha_;
    
    private float blue_;
    
    private float green_;
    
    private float red_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> getAlphaFieldBuilder() {
      if (this.alphaBuilder_ == null) {
        this.alphaBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getAlpha(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.alpha_ = null;
      } 
      return this.alphaBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ColorProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Color.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Color build() {
      Color color = buildPartial();
      if (color.isInitialized())
        return color; 
      throw newUninitializedMessageException(color);
    }
    
    public Color buildPartial() {
      Color color = new Color(this);
      Color.access$402(color, this.red_);
      Color.access$502(color, this.green_);
      Color.access$602(color, this.blue_);
      SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> singleFieldBuilderV3 = this.alphaBuilder_;
      if (singleFieldBuilderV3 == null) {
        Color.access$702(color, this.alpha_);
      } else {
        Color.access$702(color, (FloatValue)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return color;
    }
    
    public Builder clear() {
      super.clear();
      this.red_ = 0.0F;
      this.green_ = 0.0F;
      this.blue_ = 0.0F;
      if (this.alphaBuilder_ == null) {
        this.alpha_ = null;
        return this;
      } 
      this.alpha_ = null;
      this.alphaBuilder_ = null;
      return this;
    }
    
    public Builder clearAlpha() {
      if (this.alphaBuilder_ == null) {
        this.alpha_ = null;
        onChanged();
        return this;
      } 
      this.alpha_ = null;
      this.alphaBuilder_ = null;
      return this;
    }
    
    public Builder clearBlue() {
      this.blue_ = 0.0F;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearGreen() {
      this.green_ = 0.0F;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRed() {
      this.red_ = 0.0F;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public FloatValue getAlpha() {
      FloatValue floatValue;
      SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> singleFieldBuilderV3 = this.alphaBuilder_;
      if (singleFieldBuilderV3 == null) {
        FloatValue floatValue1 = this.alpha_;
        floatValue = floatValue1;
        if (floatValue1 == null)
          floatValue = FloatValue.getDefaultInstance(); 
        return floatValue;
      } 
      return (FloatValue)floatValue.getMessage();
    }
    
    public FloatValue.Builder getAlphaBuilder() {
      onChanged();
      return (FloatValue.Builder)getAlphaFieldBuilder().getBuilder();
    }
    
    public FloatValueOrBuilder getAlphaOrBuilder() {
      SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> singleFieldBuilderV3 = this.alphaBuilder_;
      if (singleFieldBuilderV3 != null)
        return (FloatValueOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      FloatValue floatValue2 = this.alpha_;
      FloatValue floatValue1 = floatValue2;
      if (floatValue2 == null)
        floatValue1 = FloatValue.getDefaultInstance(); 
      return (FloatValueOrBuilder)floatValue1;
    }
    
    public float getBlue() {
      return this.blue_;
    }
    
    public Color getDefaultInstanceForType() {
      return Color.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ColorProto.a;
    }
    
    public float getGreen() {
      return this.green_;
    }
    
    public float getRed() {
      return this.red_;
    }
    
    public boolean hasAlpha() {
      return (this.alphaBuilder_ != null || this.alpha_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ColorProto.b.ensureFieldAccessorsInitialized(Color.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeAlpha(FloatValue param1FloatValue) {
      FloatValue floatValue;
      SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> singleFieldBuilderV3 = this.alphaBuilder_;
      if (singleFieldBuilderV3 == null) {
        floatValue = this.alpha_;
        if (floatValue != null) {
          this.alpha_ = FloatValue.newBuilder(floatValue).mergeFrom(param1FloatValue).buildPartial();
        } else {
          this.alpha_ = param1FloatValue;
        } 
        onChanged();
        return this;
      } 
      floatValue.mergeFrom((AbstractMessage)param1FloatValue);
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Color color = (Color)Color.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Color color = (Color)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Color)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Color)
        return mergeFrom((Color)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Color param1Color) {
      if (param1Color == Color.getDefaultInstance())
        return this; 
      if (param1Color.getRed() != 0.0F)
        setRed(param1Color.getRed()); 
      if (param1Color.getGreen() != 0.0F)
        setGreen(param1Color.getGreen()); 
      if (param1Color.getBlue() != 0.0F)
        setBlue(param1Color.getBlue()); 
      if (param1Color.hasAlpha())
        mergeAlpha(param1Color.getAlpha()); 
      mergeUnknownFields(param1Color.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAlpha(FloatValue.Builder param1Builder) {
      SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> singleFieldBuilderV3 = this.alphaBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.alpha_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAlpha(FloatValue param1FloatValue) {
      SingleFieldBuilderV3<FloatValue, FloatValue.Builder, FloatValueOrBuilder> singleFieldBuilderV3 = this.alphaBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1FloatValue != null) {
          this.alpha_ = param1FloatValue;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1FloatValue);
      return this;
    }
    
    public Builder setBlue(float param1Float) {
      this.blue_ = param1Float;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setGreen(float param1Float) {
      this.green_ = param1Float;
      onChanged();
      return this;
    }
    
    public Builder setRed(float param1Float) {
      this.red_ = param1Float;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\Color.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
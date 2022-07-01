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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Control extends GeneratedMessageV3 implements ControlOrBuilder {
  private static final Control DEFAULT_INSTANCE = new Control();
  
  public static final int ENVIRONMENT_FIELD_NUMBER = 1;
  
  private static final Parser<Control> PARSER = (Parser<Control>)new AbstractParser<Control>() {
      public Control a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Control(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object environment_;
  
  private byte memoizedIsInitialized = -1;
  
  private Control() {
    this.environment_ = "";
  }
  
  private Control(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                continue; 
              continue;
            } 
            this.environment_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private Control(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Control getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ControlProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Control paramControl) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramControl);
  }
  
  public static Control parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Control)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Control parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Control)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Control parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Control)PARSER.parseFrom(paramByteString);
  }
  
  public static Control parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Control)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Control parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Control)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Control parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Control)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Control parseFrom(InputStream paramInputStream) throws IOException {
    return (Control)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Control parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Control)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Control parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Control)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Control parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Control)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Control parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Control)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Control parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Control)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Control> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Control))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getEnvironment().equals(paramObject.getEnvironment()) ? false : (!!this.unknownFields.equals(((Control)paramObject).unknownFields));
  }
  
  public Control getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getEnvironment() {
    Object object = this.environment_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.environment_ = object;
    return (String)object;
  }
  
  public ByteString getEnvironmentBytes() {
    Object object = this.environment_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.environment_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<Control> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getEnvironmentBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.environment_); 
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
    int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getEnvironment().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ControlProto.b.ensureFieldAccessorsInitialized(Control.class, Builder.class);
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
    if (!getEnvironmentBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.environment_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ControlOrBuilder {
    private Object environment_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ControlProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Control.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Control build() {
      Control control = buildPartial();
      if (control.isInitialized())
        return control; 
      throw newUninitializedMessageException(control);
    }
    
    public Control buildPartial() {
      Control control = new Control(this);
      Control.access$402(control, this.environment_);
      onBuilt();
      return control;
    }
    
    public Builder clear() {
      super.clear();
      this.environment_ = "";
      return this;
    }
    
    public Builder clearEnvironment() {
      this.environment_ = Control.getDefaultInstance().getEnvironment();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Control getDefaultInstanceForType() {
      return Control.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ControlProto.a;
    }
    
    public String getEnvironment() {
      Object object = this.environment_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.environment_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getEnvironmentBytes() {
      Object object = this.environment_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.environment_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ControlProto.b.ensureFieldAccessorsInitialized(Control.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Control param1Control) {
      if (param1Control == Control.getDefaultInstance())
        return this; 
      if (!param1Control.getEnvironment().isEmpty()) {
        this.environment_ = param1Control.environment_;
        onChanged();
      } 
      mergeUnknownFields(param1Control.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Control control = (Control)Control.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Control control = (Control)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Control)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Control)
        return mergeFrom((Control)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setEnvironment(String param1String) {
      if (param1String != null) {
        this.environment_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEnvironmentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Control.checkByteStringIsUtf8(param1ByteString);
        this.environment_ = param1ByteString;
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
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Control.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
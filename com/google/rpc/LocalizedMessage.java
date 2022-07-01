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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LocalizedMessage extends GeneratedMessageV3 implements LocalizedMessageOrBuilder {
  private static final LocalizedMessage DEFAULT_INSTANCE = new LocalizedMessage();
  
  public static final int LOCALE_FIELD_NUMBER = 1;
  
  public static final int MESSAGE_FIELD_NUMBER = 2;
  
  private static final Parser<LocalizedMessage> PARSER = (Parser<LocalizedMessage>)new AbstractParser<LocalizedMessage>() {
      public LocalizedMessage a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new LocalizedMessage(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object locale_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object message_;
  
  private LocalizedMessage() {
    this.locale_ = "";
    this.message_ = "";
  }
  
  private LocalizedMessage(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.message_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.locale_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private LocalizedMessage(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static LocalizedMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.y;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LocalizedMessage paramLocalizedMessage) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramLocalizedMessage);
  }
  
  public static LocalizedMessage parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LocalizedMessage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static LocalizedMessage parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LocalizedMessage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LocalizedMessage)PARSER.parseFrom(paramByteString);
  }
  
  public static LocalizedMessage parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LocalizedMessage)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LocalizedMessage)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static LocalizedMessage parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LocalizedMessage)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(InputStream paramInputStream) throws IOException {
    return (LocalizedMessage)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static LocalizedMessage parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LocalizedMessage)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (LocalizedMessage)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static LocalizedMessage parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LocalizedMessage)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LocalizedMessage)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static LocalizedMessage parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LocalizedMessage)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LocalizedMessage> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof LocalizedMessage))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getLocale().equals(paramObject.getLocale()) ? false : (!getMessage().equals(paramObject.getMessage()) ? false : (!!this.unknownFields.equals(((LocalizedMessage)paramObject).unknownFields)));
  }
  
  public LocalizedMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getLocale() {
    Object object = this.locale_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.locale_ = object;
    return (String)object;
  }
  
  public ByteString getLocaleBytes() {
    Object object = this.locale_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.locale_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getMessage() {
    Object object = this.message_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.message_ = object;
    return (String)object;
  }
  
  public ByteString getMessageBytes() {
    Object object = this.message_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.message_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<LocalizedMessage> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!getLocaleBytes().isEmpty())
      i = 0 + GeneratedMessageV3.computeStringSize(1, this.locale_); 
    int j = i;
    if (!getMessageBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.message_); 
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
    int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getLocale().hashCode()) * 37 + 2) * 53 + getMessage().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.z.ensureFieldAccessorsInitialized(LocalizedMessage.class, Builder.class);
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
    if (!getLocaleBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.locale_); 
    if (!getMessageBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.message_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LocalizedMessageOrBuilder {
    private Object locale_ = "";
    
    private Object message_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.y;
    }
    
    private void maybeForceBuilderInitialization() {
      LocalizedMessage.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LocalizedMessage build() {
      LocalizedMessage localizedMessage = buildPartial();
      if (localizedMessage.isInitialized())
        return localizedMessage; 
      throw newUninitializedMessageException(localizedMessage);
    }
    
    public LocalizedMessage buildPartial() {
      LocalizedMessage localizedMessage = new LocalizedMessage(this);
      LocalizedMessage.access$402(localizedMessage, this.locale_);
      LocalizedMessage.access$502(localizedMessage, this.message_);
      onBuilt();
      return localizedMessage;
    }
    
    public Builder clear() {
      super.clear();
      this.locale_ = "";
      this.message_ = "";
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLocale() {
      this.locale_ = LocalizedMessage.getDefaultInstance().getLocale();
      onChanged();
      return this;
    }
    
    public Builder clearMessage() {
      this.message_ = LocalizedMessage.getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LocalizedMessage getDefaultInstanceForType() {
      return LocalizedMessage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.y;
    }
    
    public String getLocale() {
      Object object = this.locale_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.locale_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLocaleBytes() {
      Object object = this.locale_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.locale_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getMessage() {
      Object object = this.message_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.message_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMessageBytes() {
      Object object = this.message_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.message_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.z.ensureFieldAccessorsInitialized(LocalizedMessage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LocalizedMessage localizedMessage = (LocalizedMessage)LocalizedMessage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LocalizedMessage localizedMessage = (LocalizedMessage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LocalizedMessage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LocalizedMessage)
        return mergeFrom((LocalizedMessage)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(LocalizedMessage param1LocalizedMessage) {
      if (param1LocalizedMessage == LocalizedMessage.getDefaultInstance())
        return this; 
      if (!param1LocalizedMessage.getLocale().isEmpty()) {
        this.locale_ = param1LocalizedMessage.locale_;
        onChanged();
      } 
      if (!param1LocalizedMessage.getMessage().isEmpty()) {
        this.message_ = param1LocalizedMessage.message_;
        onChanged();
      } 
      mergeUnknownFields(param1LocalizedMessage.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLocale(String param1String) {
      if (param1String != null) {
        this.locale_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLocaleBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LocalizedMessage.checkByteStringIsUtf8(param1ByteString);
        this.locale_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMessage(String param1String) {
      if (param1String != null) {
        this.message_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMessageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LocalizedMessage.checkByteStringIsUtf8(param1ByteString);
        this.message_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\LocalizedMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
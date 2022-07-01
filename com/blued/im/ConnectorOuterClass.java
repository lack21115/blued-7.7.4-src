package com.blued.im;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.AnyProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ConnectorOuterClass {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_KickPackage_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_KickPackage_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_PingPackage_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_PingPackage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_PingPackage_descriptor, new String[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_PongPackage_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_PongPackage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_PongPackage_descriptor, new String[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_ResponsePackage_descriptor = getDescriptor().getMessageTypes().get(2);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_ResponsePackage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_ResponsePackage_descriptor, new String[] { "Code" });
  
  static {
    internal_static_com_blued_im_KickPackage_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_com_blued_im_KickPackage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_KickPackage_descriptor, new String[0]);
    AnyProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor = AnyProto.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\017Connector.proto\022\fcom.blued.im\032\031google/protobuf/any.proto\"\r\n\013PingPackage\"\r\n\013PongPackage\"\037\n\017ResponsePackage\022\f\n\004code\030\001 \001(\003\"\r\n\013KickPackage2´\001\n\tConnector\022;\n\007Connect\022\024.google.protobuf.Any\032\024.google.protobuf.Any\"\000(\0010\001\0224\n\004Send\022\024.google.protobuf.Any\032\024.google.protobuf.Any\"\000\0224\n\004Kick\022\024.google.protobuf.Any\032\024.google.protobuf.Any\"\000B\f¢\002\tConnectorb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class KickPackage extends GeneratedMessageV3 implements KickPackageOrBuilder {
    private static final KickPackage DEFAULT_INSTANCE = new KickPackage();
    
    private static final Parser<KickPackage> PARSER = (Parser<KickPackage>)new AbstractParser<KickPackage>() {
        public ConnectorOuterClass.KickPackage parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ConnectorOuterClass.KickPackage(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private KickPackage() {}
    
    private KickPackage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
              if (!bool1)
                continue; 
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private KickPackage(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static KickPackage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(KickPackage param1KickPackage) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1KickPackage);
    }
    
    public static KickPackage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (KickPackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static KickPackage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (KickPackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static KickPackage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (KickPackage)PARSER.parseFrom(param1ByteString);
    }
    
    public static KickPackage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (KickPackage)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static KickPackage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (KickPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static KickPackage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (KickPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static KickPackage parseFrom(InputStream param1InputStream) throws IOException {
      return (KickPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static KickPackage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (KickPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static KickPackage parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (KickPackage)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static KickPackage parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (KickPackage)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static KickPackage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (KickPackage)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static KickPackage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (KickPackage)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<KickPackage> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof KickPackage))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !!this.unknownFields.equals(((KickPackage)param1Object).unknownFields);
    }
    
    public KickPackage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<KickPackage> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = this.unknownFields.getSerializedSize() + 0;
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (779 + getDescriptor().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(KickPackage.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new KickPackage();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConnectorOuterClass.KickPackageOrBuilder {
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ConnectorOuterClass.KickPackage.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ConnectorOuterClass.KickPackage build() {
        ConnectorOuterClass.KickPackage kickPackage = buildPartial();
        if (kickPackage.isInitialized())
          return kickPackage; 
        throw newUninitializedMessageException(kickPackage);
      }
      
      public ConnectorOuterClass.KickPackage buildPartial() {
        ConnectorOuterClass.KickPackage kickPackage = new ConnectorOuterClass.KickPackage(this);
        onBuilt();
        return kickPackage;
      }
      
      public Builder clear() {
        super.clear();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ConnectorOuterClass.KickPackage getDefaultInstanceForType() {
        return ConnectorOuterClass.KickPackage.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.KickPackage.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ConnectorOuterClass.KickPackage param2KickPackage) {
        if (param2KickPackage == ConnectorOuterClass.KickPackage.getDefaultInstance())
          return this; 
        mergeUnknownFields(param2KickPackage.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ConnectorOuterClass.KickPackage kickPackage = (ConnectorOuterClass.KickPackage)ConnectorOuterClass.KickPackage.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ConnectorOuterClass.KickPackage kickPackage = (ConnectorOuterClass.KickPackage)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ConnectorOuterClass.KickPackage)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ConnectorOuterClass.KickPackage)
          return mergeFrom((ConnectorOuterClass.KickPackage)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<KickPackage> {
    public ConnectorOuterClass.KickPackage parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ConnectorOuterClass.KickPackage(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<KickPackage.Builder> implements KickPackageOrBuilder {
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ConnectorOuterClass.KickPackage.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ConnectorOuterClass.KickPackage build() {
      ConnectorOuterClass.KickPackage kickPackage = buildPartial();
      if (kickPackage.isInitialized())
        return kickPackage; 
      throw newUninitializedMessageException(kickPackage);
    }
    
    public ConnectorOuterClass.KickPackage buildPartial() {
      ConnectorOuterClass.KickPackage kickPackage = new ConnectorOuterClass.KickPackage(this);
      onBuilt();
      return kickPackage;
    }
    
    public Builder clear() {
      super.clear();
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
    
    public ConnectorOuterClass.KickPackage getDefaultInstanceForType() {
      return ConnectorOuterClass.KickPackage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_KickPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.KickPackage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ConnectorOuterClass.KickPackage param1KickPackage) {
      if (param1KickPackage == ConnectorOuterClass.KickPackage.getDefaultInstance())
        return this; 
      mergeUnknownFields(param1KickPackage.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ConnectorOuterClass.KickPackage kickPackage = (ConnectorOuterClass.KickPackage)ConnectorOuterClass.KickPackage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ConnectorOuterClass.KickPackage kickPackage = (ConnectorOuterClass.KickPackage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ConnectorOuterClass.KickPackage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ConnectorOuterClass.KickPackage)
        return mergeFrom((ConnectorOuterClass.KickPackage)param1Message); 
      super.mergeFrom(param1Message);
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
  }
  
  public static interface KickPackageOrBuilder extends MessageOrBuilder {}
  
  public static final class PingPackage extends GeneratedMessageV3 implements PingPackageOrBuilder {
    private static final PingPackage DEFAULT_INSTANCE = new PingPackage();
    
    private static final Parser<PingPackage> PARSER = (Parser<PingPackage>)new AbstractParser<PingPackage>() {
        public ConnectorOuterClass.PingPackage parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ConnectorOuterClass.PingPackage(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private PingPackage() {}
    
    private PingPackage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
              if (!bool1)
                continue; 
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private PingPackage(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static PingPackage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PingPackage param1PingPackage) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1PingPackage);
    }
    
    public static PingPackage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PingPackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static PingPackage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PingPackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PingPackage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PingPackage)PARSER.parseFrom(param1ByteString);
    }
    
    public static PingPackage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PingPackage)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PingPackage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PingPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static PingPackage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PingPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PingPackage parseFrom(InputStream param1InputStream) throws IOException {
      return (PingPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static PingPackage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PingPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PingPackage parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (PingPackage)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static PingPackage parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PingPackage)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static PingPackage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PingPackage)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static PingPackage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PingPackage)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PingPackage> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof PingPackage))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !!this.unknownFields.equals(((PingPackage)param1Object).unknownFields);
    }
    
    public PingPackage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<PingPackage> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = this.unknownFields.getSerializedSize() + 0;
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (779 + getDescriptor().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(PingPackage.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new PingPackage();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConnectorOuterClass.PingPackageOrBuilder {
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ConnectorOuterClass.PingPackage.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ConnectorOuterClass.PingPackage build() {
        ConnectorOuterClass.PingPackage pingPackage = buildPartial();
        if (pingPackage.isInitialized())
          return pingPackage; 
        throw newUninitializedMessageException(pingPackage);
      }
      
      public ConnectorOuterClass.PingPackage buildPartial() {
        ConnectorOuterClass.PingPackage pingPackage = new ConnectorOuterClass.PingPackage(this);
        onBuilt();
        return pingPackage;
      }
      
      public Builder clear() {
        super.clear();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ConnectorOuterClass.PingPackage getDefaultInstanceForType() {
        return ConnectorOuterClass.PingPackage.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.PingPackage.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ConnectorOuterClass.PingPackage param2PingPackage) {
        if (param2PingPackage == ConnectorOuterClass.PingPackage.getDefaultInstance())
          return this; 
        mergeUnknownFields(param2PingPackage.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ConnectorOuterClass.PingPackage pingPackage = (ConnectorOuterClass.PingPackage)ConnectorOuterClass.PingPackage.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ConnectorOuterClass.PingPackage pingPackage = (ConnectorOuterClass.PingPackage)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ConnectorOuterClass.PingPackage)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ConnectorOuterClass.PingPackage)
          return mergeFrom((ConnectorOuterClass.PingPackage)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<PingPackage> {
    public ConnectorOuterClass.PingPackage parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ConnectorOuterClass.PingPackage(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<PingPackage.Builder> implements PingPackageOrBuilder {
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ConnectorOuterClass.PingPackage.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ConnectorOuterClass.PingPackage build() {
      ConnectorOuterClass.PingPackage pingPackage = buildPartial();
      if (pingPackage.isInitialized())
        return pingPackage; 
      throw newUninitializedMessageException(pingPackage);
    }
    
    public ConnectorOuterClass.PingPackage buildPartial() {
      ConnectorOuterClass.PingPackage pingPackage = new ConnectorOuterClass.PingPackage(this);
      onBuilt();
      return pingPackage;
    }
    
    public Builder clear() {
      super.clear();
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
    
    public ConnectorOuterClass.PingPackage getDefaultInstanceForType() {
      return ConnectorOuterClass.PingPackage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_PingPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.PingPackage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ConnectorOuterClass.PingPackage param1PingPackage) {
      if (param1PingPackage == ConnectorOuterClass.PingPackage.getDefaultInstance())
        return this; 
      mergeUnknownFields(param1PingPackage.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ConnectorOuterClass.PingPackage pingPackage = (ConnectorOuterClass.PingPackage)ConnectorOuterClass.PingPackage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ConnectorOuterClass.PingPackage pingPackage = (ConnectorOuterClass.PingPackage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ConnectorOuterClass.PingPackage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ConnectorOuterClass.PingPackage)
        return mergeFrom((ConnectorOuterClass.PingPackage)param1Message); 
      super.mergeFrom(param1Message);
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
  }
  
  public static interface PingPackageOrBuilder extends MessageOrBuilder {}
  
  public static final class PongPackage extends GeneratedMessageV3 implements PongPackageOrBuilder {
    private static final PongPackage DEFAULT_INSTANCE = new PongPackage();
    
    private static final Parser<PongPackage> PARSER = (Parser<PongPackage>)new AbstractParser<PongPackage>() {
        public ConnectorOuterClass.PongPackage parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ConnectorOuterClass.PongPackage(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private PongPackage() {}
    
    private PongPackage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
              if (!bool1)
                continue; 
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private PongPackage(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static PongPackage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PongPackage param1PongPackage) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1PongPackage);
    }
    
    public static PongPackage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PongPackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static PongPackage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PongPackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PongPackage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PongPackage)PARSER.parseFrom(param1ByteString);
    }
    
    public static PongPackage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PongPackage)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PongPackage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PongPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static PongPackage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PongPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PongPackage parseFrom(InputStream param1InputStream) throws IOException {
      return (PongPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static PongPackage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PongPackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PongPackage parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (PongPackage)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static PongPackage parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PongPackage)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static PongPackage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PongPackage)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static PongPackage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PongPackage)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PongPackage> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof PongPackage))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !!this.unknownFields.equals(((PongPackage)param1Object).unknownFields);
    }
    
    public PongPackage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<PongPackage> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = this.unknownFields.getSerializedSize() + 0;
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (779 + getDescriptor().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(PongPackage.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new PongPackage();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConnectorOuterClass.PongPackageOrBuilder {
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ConnectorOuterClass.PongPackage.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ConnectorOuterClass.PongPackage build() {
        ConnectorOuterClass.PongPackage pongPackage = buildPartial();
        if (pongPackage.isInitialized())
          return pongPackage; 
        throw newUninitializedMessageException(pongPackage);
      }
      
      public ConnectorOuterClass.PongPackage buildPartial() {
        ConnectorOuterClass.PongPackage pongPackage = new ConnectorOuterClass.PongPackage(this);
        onBuilt();
        return pongPackage;
      }
      
      public Builder clear() {
        super.clear();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public ConnectorOuterClass.PongPackage getDefaultInstanceForType() {
        return ConnectorOuterClass.PongPackage.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.PongPackage.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ConnectorOuterClass.PongPackage param2PongPackage) {
        if (param2PongPackage == ConnectorOuterClass.PongPackage.getDefaultInstance())
          return this; 
        mergeUnknownFields(param2PongPackage.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ConnectorOuterClass.PongPackage pongPackage = (ConnectorOuterClass.PongPackage)ConnectorOuterClass.PongPackage.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ConnectorOuterClass.PongPackage pongPackage = (ConnectorOuterClass.PongPackage)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ConnectorOuterClass.PongPackage)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ConnectorOuterClass.PongPackage)
          return mergeFrom((ConnectorOuterClass.PongPackage)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<PongPackage> {
    public ConnectorOuterClass.PongPackage parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ConnectorOuterClass.PongPackage(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<PongPackage.Builder> implements PongPackageOrBuilder {
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ConnectorOuterClass.PongPackage.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ConnectorOuterClass.PongPackage build() {
      ConnectorOuterClass.PongPackage pongPackage = buildPartial();
      if (pongPackage.isInitialized())
        return pongPackage; 
      throw newUninitializedMessageException(pongPackage);
    }
    
    public ConnectorOuterClass.PongPackage buildPartial() {
      ConnectorOuterClass.PongPackage pongPackage = new ConnectorOuterClass.PongPackage(this);
      onBuilt();
      return pongPackage;
    }
    
    public Builder clear() {
      super.clear();
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
    
    public ConnectorOuterClass.PongPackage getDefaultInstanceForType() {
      return ConnectorOuterClass.PongPackage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_PongPackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.PongPackage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ConnectorOuterClass.PongPackage param1PongPackage) {
      if (param1PongPackage == ConnectorOuterClass.PongPackage.getDefaultInstance())
        return this; 
      mergeUnknownFields(param1PongPackage.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ConnectorOuterClass.PongPackage pongPackage = (ConnectorOuterClass.PongPackage)ConnectorOuterClass.PongPackage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ConnectorOuterClass.PongPackage pongPackage = (ConnectorOuterClass.PongPackage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ConnectorOuterClass.PongPackage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ConnectorOuterClass.PongPackage)
        return mergeFrom((ConnectorOuterClass.PongPackage)param1Message); 
      super.mergeFrom(param1Message);
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
  }
  
  public static interface PongPackageOrBuilder extends MessageOrBuilder {}
  
  public static final class ResponsePackage extends GeneratedMessageV3 implements ResponsePackageOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final ResponsePackage DEFAULT_INSTANCE = new ResponsePackage();
    
    private static final Parser<ResponsePackage> PARSER = (Parser<ResponsePackage>)new AbstractParser<ResponsePackage>() {
        public ConnectorOuterClass.ResponsePackage parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ConnectorOuterClass.ResponsePackage(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private long code_;
    
    private byte memoizedIsInitialized = -1;
    
    private ResponsePackage() {}
    
    private ResponsePackage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.code_ = param1CodedInputStream.readInt64();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private ResponsePackage(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ResponsePackage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ResponsePackage param1ResponsePackage) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ResponsePackage);
    }
    
    public static ResponsePackage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ResponsePackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ResponsePackage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ResponsePackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ResponsePackage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ResponsePackage)PARSER.parseFrom(param1ByteString);
    }
    
    public static ResponsePackage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ResponsePackage)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ResponsePackage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ResponsePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ResponsePackage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ResponsePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ResponsePackage parseFrom(InputStream param1InputStream) throws IOException {
      return (ResponsePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ResponsePackage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ResponsePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ResponsePackage parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ResponsePackage)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ResponsePackage parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ResponsePackage)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ResponsePackage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ResponsePackage)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ResponsePackage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ResponsePackage)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ResponsePackage> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ResponsePackage))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getCode() != param1Object.getCode()) ? false : (!!this.unknownFields.equals(((ResponsePackage)param1Object).unknownFields));
    }
    
    public long getCode() {
      return this.code_;
    }
    
    public ResponsePackage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<ResponsePackage> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      long l = this.code_;
      if (l != 0L)
        i = 0 + CodedOutputStream.computeInt64Size(1, l); 
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
      int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getCode())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponsePackage.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new ResponsePackage();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.code_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(1, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConnectorOuterClass.ResponsePackageOrBuilder {
      private long code_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ConnectorOuterClass.ResponsePackage.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ConnectorOuterClass.ResponsePackage build() {
        ConnectorOuterClass.ResponsePackage responsePackage = buildPartial();
        if (responsePackage.isInitialized())
          return responsePackage; 
        throw newUninitializedMessageException(responsePackage);
      }
      
      public ConnectorOuterClass.ResponsePackage buildPartial() {
        ConnectorOuterClass.ResponsePackage responsePackage = new ConnectorOuterClass.ResponsePackage(this);
        ConnectorOuterClass.ResponsePackage.access$2402(responsePackage, this.code_);
        onBuilt();
        return responsePackage;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0L;
        return this;
      }
      
      public Builder clearCode() {
        this.code_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public long getCode() {
        return this.code_;
      }
      
      public ConnectorOuterClass.ResponsePackage getDefaultInstanceForType() {
        return ConnectorOuterClass.ResponsePackage.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.ResponsePackage.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ConnectorOuterClass.ResponsePackage param2ResponsePackage) {
        if (param2ResponsePackage == ConnectorOuterClass.ResponsePackage.getDefaultInstance())
          return this; 
        if (param2ResponsePackage.getCode() != 0L)
          setCode(param2ResponsePackage.getCode()); 
        mergeUnknownFields(param2ResponsePackage.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ConnectorOuterClass.ResponsePackage responsePackage = (ConnectorOuterClass.ResponsePackage)ConnectorOuterClass.ResponsePackage.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ConnectorOuterClass.ResponsePackage responsePackage = (ConnectorOuterClass.ResponsePackage)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ConnectorOuterClass.ResponsePackage)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ConnectorOuterClass.ResponsePackage)
          return mergeFrom((ConnectorOuterClass.ResponsePackage)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCode(long param2Long) {
        this.code_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<ResponsePackage> {
    public ConnectorOuterClass.ResponsePackage parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ConnectorOuterClass.ResponsePackage(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ResponsePackage.Builder> implements ResponsePackageOrBuilder {
    private long code_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ConnectorOuterClass.ResponsePackage.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ConnectorOuterClass.ResponsePackage build() {
      ConnectorOuterClass.ResponsePackage responsePackage = buildPartial();
      if (responsePackage.isInitialized())
        return responsePackage; 
      throw newUninitializedMessageException(responsePackage);
    }
    
    public ConnectorOuterClass.ResponsePackage buildPartial() {
      ConnectorOuterClass.ResponsePackage responsePackage = new ConnectorOuterClass.ResponsePackage(this);
      ConnectorOuterClass.ResponsePackage.access$2402(responsePackage, this.code_);
      onBuilt();
      return responsePackage;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0L;
      return this;
    }
    
    public Builder clearCode() {
      this.code_ = 0L;
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
    
    public long getCode() {
      return this.code_;
    }
    
    public ConnectorOuterClass.ResponsePackage getDefaultInstanceForType() {
      return ConnectorOuterClass.ResponsePackage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ConnectorOuterClass.internal_static_com_blued_im_ResponsePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectorOuterClass.ResponsePackage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ConnectorOuterClass.ResponsePackage param1ResponsePackage) {
      if (param1ResponsePackage == ConnectorOuterClass.ResponsePackage.getDefaultInstance())
        return this; 
      if (param1ResponsePackage.getCode() != 0L)
        setCode(param1ResponsePackage.getCode()); 
      mergeUnknownFields(param1ResponsePackage.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ConnectorOuterClass.ResponsePackage responsePackage = (ConnectorOuterClass.ResponsePackage)ConnectorOuterClass.ResponsePackage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ConnectorOuterClass.ResponsePackage responsePackage = (ConnectorOuterClass.ResponsePackage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ConnectorOuterClass.ResponsePackage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ConnectorOuterClass.ResponsePackage)
        return mergeFrom((ConnectorOuterClass.ResponsePackage)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCode(long param1Long) {
      this.code_ = param1Long;
      onChanged();
      return this;
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
  
  public static interface ResponsePackageOrBuilder extends MessageOrBuilder {
    long getCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\ConnectorOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
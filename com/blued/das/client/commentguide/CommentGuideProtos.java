package com.blued.das.client.commentguide;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CommentGuideProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\030CommentGuideProtos.proto\022!com.blued.das.client.commentguide\"c\n\021CommentGuideProto\0227\n\005event\030\001 \001(\0162(.com.blued.das.client.commentguide.Event\022\025\n\rshow_occasion\030\002 \001(\t*\001\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\027\n\023COMMENT_WINDOW_SHOW\020\001\022!\n\035COMMENT_WINDOW_FEEDBACK_CLICK\020\002\022\035\n\031COMMENT_WINDOW_RATE_CLICK\020\003\022\036\n\032COMMENT_WINDOW_CLOSE_CLICK\020\004B\020¢\002\rCOMMENT_GUIDEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor, new String[] { "Event", "ShowOccasion" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class CommentGuideProto extends GeneratedMessageV3 implements CommentGuideProtoOrBuilder {
    private static final CommentGuideProto DEFAULT_INSTANCE = new CommentGuideProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    private static final Parser<CommentGuideProto> PARSER = (Parser<CommentGuideProto>)new AbstractParser<CommentGuideProto>() {
        public CommentGuideProtos.CommentGuideProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new CommentGuideProtos.CommentGuideProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SHOW_OCCASION_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private int event_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object showOccasion_;
    
    private CommentGuideProto() {
      this.event_ = 0;
      this.showOccasion_ = "";
    }
    
    private CommentGuideProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 18) {
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.showOccasion_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.event_ = param1CodedInputStream.readEnum();
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
    
    private CommentGuideProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static CommentGuideProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CommentGuideProto param1CommentGuideProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1CommentGuideProto);
    }
    
    public static CommentGuideProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CommentGuideProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static CommentGuideProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CommentGuideProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CommentGuideProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CommentGuideProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static CommentGuideProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CommentGuideProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CommentGuideProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CommentGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static CommentGuideProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CommentGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CommentGuideProto parseFrom(InputStream param1InputStream) throws IOException {
      return (CommentGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static CommentGuideProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CommentGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CommentGuideProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (CommentGuideProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static CommentGuideProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CommentGuideProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static CommentGuideProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CommentGuideProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static CommentGuideProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CommentGuideProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CommentGuideProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof CommentGuideProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((CommentGuideProto)param1Object).event_) ? false : (!getShowOccasion().equals(param1Object.getShowOccasion()) ? false : (!!this.unknownFields.equals(((CommentGuideProto)param1Object).unknownFields)));
    }
    
    public CommentGuideProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public CommentGuideProtos.Event getEvent() {
      CommentGuideProtos.Event event2 = CommentGuideProtos.Event.valueOf(this.event_);
      CommentGuideProtos.Event event1 = event2;
      if (event2 == null)
        event1 = CommentGuideProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public Parser<CommentGuideProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.event_ != CommentGuideProtos.Event.UNKNOWN_EVENT.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      int j = i;
      if (!getShowOccasionBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.showOccasion_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getShowOccasion() {
      Object object = this.showOccasion_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.showOccasion_ = object;
      return (String)object;
    }
    
    public ByteString getShowOccasionBytes() {
      Object object = this.showOccasion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.showOccasion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getShowOccasion().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommentGuideProto.class, Builder.class);
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
      return new CommentGuideProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != CommentGuideProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getShowOccasionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.showOccasion_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommentGuideProtos.CommentGuideProtoOrBuilder {
      private int event_ = 0;
      
      private Object showOccasion_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        CommentGuideProtos.CommentGuideProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public CommentGuideProtos.CommentGuideProto build() {
        CommentGuideProtos.CommentGuideProto commentGuideProto = buildPartial();
        if (commentGuideProto.isInitialized())
          return commentGuideProto; 
        throw newUninitializedMessageException(commentGuideProto);
      }
      
      public CommentGuideProtos.CommentGuideProto buildPartial() {
        CommentGuideProtos.CommentGuideProto commentGuideProto = new CommentGuideProtos.CommentGuideProto(this);
        CommentGuideProtos.CommentGuideProto.access$602(commentGuideProto, this.event_);
        CommentGuideProtos.CommentGuideProto.access$702(commentGuideProto, this.showOccasion_);
        onBuilt();
        return commentGuideProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.showOccasion_ = "";
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearShowOccasion() {
        this.showOccasion_ = CommentGuideProtos.CommentGuideProto.getDefaultInstance().getShowOccasion();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public CommentGuideProtos.CommentGuideProto getDefaultInstanceForType() {
        return CommentGuideProtos.CommentGuideProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
      }
      
      public CommentGuideProtos.Event getEvent() {
        CommentGuideProtos.Event event2 = CommentGuideProtos.Event.valueOf(this.event_);
        CommentGuideProtos.Event event1 = event2;
        if (event2 == null)
          event1 = CommentGuideProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public String getShowOccasion() {
        Object object = this.showOccasion_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.showOccasion_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getShowOccasionBytes() {
        Object object = this.showOccasion_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.showOccasion_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommentGuideProtos.CommentGuideProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CommentGuideProtos.CommentGuideProto param2CommentGuideProto) {
        if (param2CommentGuideProto == CommentGuideProtos.CommentGuideProto.getDefaultInstance())
          return this; 
        if (param2CommentGuideProto.event_ != 0)
          setEventValue(param2CommentGuideProto.getEventValue()); 
        if (!param2CommentGuideProto.getShowOccasion().isEmpty()) {
          this.showOccasion_ = param2CommentGuideProto.showOccasion_;
          onChanged();
        } 
        mergeUnknownFields(param2CommentGuideProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          CommentGuideProtos.CommentGuideProto commentGuideProto = (CommentGuideProtos.CommentGuideProto)CommentGuideProtos.CommentGuideProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          CommentGuideProtos.CommentGuideProto commentGuideProto = (CommentGuideProtos.CommentGuideProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((CommentGuideProtos.CommentGuideProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof CommentGuideProtos.CommentGuideProto)
          return mergeFrom((CommentGuideProtos.CommentGuideProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setEvent(CommentGuideProtos.Event param2Event) {
        if (param2Event != null) {
          this.event_ = param2Event.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEventValue(int param2Int) {
        this.event_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setShowOccasion(String param2String) {
        if (param2String != null) {
          this.showOccasion_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setShowOccasionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          CommentGuideProtos.CommentGuideProto.checkByteStringIsUtf8(param2ByteString);
          this.showOccasion_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<CommentGuideProto> {
    public CommentGuideProtos.CommentGuideProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new CommentGuideProtos.CommentGuideProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<CommentGuideProto.Builder> implements CommentGuideProtoOrBuilder {
    private int event_ = 0;
    
    private Object showOccasion_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      CommentGuideProtos.CommentGuideProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public CommentGuideProtos.CommentGuideProto build() {
      CommentGuideProtos.CommentGuideProto commentGuideProto = buildPartial();
      if (commentGuideProto.isInitialized())
        return commentGuideProto; 
      throw newUninitializedMessageException(commentGuideProto);
    }
    
    public CommentGuideProtos.CommentGuideProto buildPartial() {
      CommentGuideProtos.CommentGuideProto commentGuideProto = new CommentGuideProtos.CommentGuideProto(this);
      CommentGuideProtos.CommentGuideProto.access$602(commentGuideProto, this.event_);
      CommentGuideProtos.CommentGuideProto.access$702(commentGuideProto, this.showOccasion_);
      onBuilt();
      return commentGuideProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.showOccasion_ = "";
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearShowOccasion() {
      this.showOccasion_ = CommentGuideProtos.CommentGuideProto.getDefaultInstance().getShowOccasion();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public CommentGuideProtos.CommentGuideProto getDefaultInstanceForType() {
      return CommentGuideProtos.CommentGuideProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_descriptor;
    }
    
    public CommentGuideProtos.Event getEvent() {
      CommentGuideProtos.Event event2 = CommentGuideProtos.Event.valueOf(this.event_);
      CommentGuideProtos.Event event1 = event2;
      if (event2 == null)
        event1 = CommentGuideProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getShowOccasion() {
      Object object = this.showOccasion_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.showOccasion_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getShowOccasionBytes() {
      Object object = this.showOccasion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.showOccasion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return CommentGuideProtos.internal_static_com_blued_das_client_commentguide_CommentGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(CommentGuideProtos.CommentGuideProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CommentGuideProtos.CommentGuideProto param1CommentGuideProto) {
      if (param1CommentGuideProto == CommentGuideProtos.CommentGuideProto.getDefaultInstance())
        return this; 
      if (param1CommentGuideProto.event_ != 0)
        setEventValue(param1CommentGuideProto.getEventValue()); 
      if (!param1CommentGuideProto.getShowOccasion().isEmpty()) {
        this.showOccasion_ = param1CommentGuideProto.showOccasion_;
        onChanged();
      } 
      mergeUnknownFields(param1CommentGuideProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        CommentGuideProtos.CommentGuideProto commentGuideProto = (CommentGuideProtos.CommentGuideProto)CommentGuideProtos.CommentGuideProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        CommentGuideProtos.CommentGuideProto commentGuideProto = (CommentGuideProtos.CommentGuideProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((CommentGuideProtos.CommentGuideProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof CommentGuideProtos.CommentGuideProto)
        return mergeFrom((CommentGuideProtos.CommentGuideProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setEvent(CommentGuideProtos.Event param1Event) {
      if (param1Event != null) {
        this.event_ = param1Event.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEventValue(int param1Int) {
      this.event_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setShowOccasion(String param1String) {
      if (param1String != null) {
        this.showOccasion_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setShowOccasionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        CommentGuideProtos.CommentGuideProto.checkByteStringIsUtf8(param1ByteString);
        this.showOccasion_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface CommentGuideProtoOrBuilder extends MessageOrBuilder {
    CommentGuideProtos.Event getEvent();
    
    int getEventValue();
    
    String getShowOccasion();
    
    ByteString getShowOccasionBytes();
  }
  
  public enum Event implements ProtocolMessageEnum {
    COMMENT_WINDOW_CLOSE_CLICK,
    COMMENT_WINDOW_FEEDBACK_CLICK,
    COMMENT_WINDOW_RATE_CLICK,
    COMMENT_WINDOW_SHOW,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int COMMENT_WINDOW_CLOSE_CLICK_VALUE = 4;
    
    public static final int COMMENT_WINDOW_FEEDBACK_CLICK_VALUE = 2;
    
    public static final int COMMENT_WINDOW_RATE_CLICK_VALUE = 3;
    
    public static final int COMMENT_WINDOW_SHOW_VALUE = 1;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      COMMENT_WINDOW_FEEDBACK_CLICK = new Event("COMMENT_WINDOW_FEEDBACK_CLICK", 2, 2);
      COMMENT_WINDOW_RATE_CLICK = new Event("COMMENT_WINDOW_RATE_CLICK", 3, 3);
      COMMENT_WINDOW_CLOSE_CLICK = new Event("COMMENT_WINDOW_CLOSE_CLICK", 4, 4);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 5, -1);
      $VALUES = new Event[] { UNKNOWN_EVENT, COMMENT_WINDOW_SHOW, COMMENT_WINDOW_FEEDBACK_CLICK, COMMENT_WINDOW_RATE_CLICK, COMMENT_WINDOW_CLOSE_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public CommentGuideProtos.Event findValueByNumber(int param2Int) {
            return CommentGuideProtos.Event.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Event(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Event forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : COMMENT_WINDOW_CLOSE_CLICK) : COMMENT_WINDOW_RATE_CLICK) : COMMENT_WINDOW_FEEDBACK_CLICK) : COMMENT_WINDOW_SHOW) : UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return CommentGuideProtos.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<Event> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public final int getNumber() {
      if (this != UNRECOGNIZED)
        return this.value; 
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      if (this != UNRECOGNIZED)
        return getDescriptor().getValues().get(ordinal()); 
      throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
  }
  
  static final class null implements Internal.EnumLiteMap<Event> {
    public CommentGuideProtos.Event findValueByNumber(int param1Int) {
      return CommentGuideProtos.Event.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\commentguide\CommentGuideProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
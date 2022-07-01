package com.blued.das.client.socialnet;

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

public final class SocialNetWorkProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\031SocialNetWorkProtos.proto\022\036com.blued.das.client.socialnet\"\001\n\022SocialNetWorkProto\0224\n\005event\030\001 \001(\0162%.com.blued.das.client.socialnet.Event\022\020\n\bgroup_id\030\002 \001(\t\022:\n\006source\030\003 \001(\0162*.com.blued.das.client.socialnet.SourceType*]\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\024\n\020GROUP_JOIN_CLICK\020\001\022\023\n\017GROUP_CHAT_SHOW\020\002\022\026\n\022GROUP_PROFILE_SHOW\020\003*Z\n\nSourceType\022\027\n\023UNKNOWN_SOURCE_TYPE\020\000\022\013\n\007MESSAGE\020\001\022\n\n\006CIRCLE\020\002\022\013\n\007MYGROUP\020\003\022\r\n\tGROUPINFO\020\004B\006¢\002\003SNSb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor, new String[] { "Event", "GroupId", "Source" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    GROUP_CHAT_SHOW,
    GROUP_JOIN_CLICK,
    GROUP_PROFILE_SHOW,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int GROUP_CHAT_SHOW_VALUE = 2;
    
    public static final int GROUP_JOIN_CLICK_VALUE = 1;
    
    public static final int GROUP_PROFILE_SHOW_VALUE = 3;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      GROUP_CHAT_SHOW = new Event("GROUP_CHAT_SHOW", 2, 2);
      GROUP_PROFILE_SHOW = new Event("GROUP_PROFILE_SHOW", 3, 3);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 4, -1);
      $VALUES = new Event[] { UNKNOWN_EVENT, GROUP_JOIN_CLICK, GROUP_CHAT_SHOW, GROUP_PROFILE_SHOW, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public SocialNetWorkProtos.Event findValueByNumber(int param2Int) {
            return SocialNetWorkProtos.Event.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Event(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Event forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : GROUP_PROFILE_SHOW) : GROUP_CHAT_SHOW) : GROUP_JOIN_CLICK) : UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SocialNetWorkProtos.getDescriptor().getEnumTypes().get(0);
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
    public SocialNetWorkProtos.Event findValueByNumber(int param1Int) {
      return SocialNetWorkProtos.Event.forNumber(param1Int);
    }
  }
  
  public static final class SocialNetWorkProto extends GeneratedMessageV3 implements SocialNetWorkProtoOrBuilder {
    private static final SocialNetWorkProto DEFAULT_INSTANCE = new SocialNetWorkProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int GROUP_ID_FIELD_NUMBER = 2;
    
    private static final Parser<SocialNetWorkProto> PARSER = (Parser<SocialNetWorkProto>)new AbstractParser<SocialNetWorkProto>() {
        public SocialNetWorkProtos.SocialNetWorkProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new SocialNetWorkProtos.SocialNetWorkProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SOURCE_FIELD_NUMBER = 3;
    
    private static final long serialVersionUID = 0L;
    
    private int event_;
    
    private volatile Object groupId_;
    
    private byte memoizedIsInitialized = -1;
    
    private int source_;
    
    private SocialNetWorkProto() {
      this.event_ = 0;
      this.groupId_ = "";
      this.source_ = 0;
    }
    
    private SocialNetWorkProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 18) {
                  if (i != 24) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.source_ = param1CodedInputStream.readEnum();
                  continue;
                } 
                this.groupId_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private SocialNetWorkProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static SocialNetWorkProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SocialNetWorkProto param1SocialNetWorkProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1SocialNetWorkProto);
    }
    
    public static SocialNetWorkProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (SocialNetWorkProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static SocialNetWorkProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SocialNetWorkProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SocialNetWorkProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (SocialNetWorkProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static SocialNetWorkProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SocialNetWorkProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static SocialNetWorkProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (SocialNetWorkProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static SocialNetWorkProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SocialNetWorkProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static SocialNetWorkProto parseFrom(InputStream param1InputStream) throws IOException {
      return (SocialNetWorkProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static SocialNetWorkProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SocialNetWorkProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SocialNetWorkProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (SocialNetWorkProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static SocialNetWorkProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SocialNetWorkProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static SocialNetWorkProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (SocialNetWorkProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static SocialNetWorkProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SocialNetWorkProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<SocialNetWorkProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof SocialNetWorkProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((SocialNetWorkProto)param1Object).event_) ? false : (!getGroupId().equals(param1Object.getGroupId()) ? false : ((this.source_ != ((SocialNetWorkProto)param1Object).source_) ? false : (!!this.unknownFields.equals(((SocialNetWorkProto)param1Object).unknownFields))));
    }
    
    public SocialNetWorkProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public SocialNetWorkProtos.Event getEvent() {
      SocialNetWorkProtos.Event event2 = SocialNetWorkProtos.Event.valueOf(this.event_);
      SocialNetWorkProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SocialNetWorkProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getGroupId() {
      Object object = this.groupId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.groupId_ = object;
      return (String)object;
    }
    
    public ByteString getGroupIdBytes() {
      Object object = this.groupId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.groupId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<SocialNetWorkProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != SocialNetWorkProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (!getGroupIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.groupId_); 
      j = i;
      if (this.source_ != SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.source_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public SocialNetWorkProtos.SourceType getSource() {
      SocialNetWorkProtos.SourceType sourceType2 = SocialNetWorkProtos.SourceType.valueOf(this.source_);
      SocialNetWorkProtos.SourceType sourceType1 = sourceType2;
      if (sourceType2 == null)
        sourceType1 = SocialNetWorkProtos.SourceType.UNRECOGNIZED; 
      return sourceType1;
    }
    
    public int getSourceValue() {
      return this.source_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getGroupId().hashCode()) * 37 + 3) * 53 + this.source_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialNetWorkProto.class, Builder.class);
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
      return new SocialNetWorkProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != SocialNetWorkProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getGroupIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.groupId_); 
      if (this.source_ != SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.source_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SocialNetWorkProtos.SocialNetWorkProtoOrBuilder {
      private int event_ = 0;
      
      private Object groupId_ = "";
      
      private int source_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        SocialNetWorkProtos.SocialNetWorkProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public SocialNetWorkProtos.SocialNetWorkProto build() {
        SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = buildPartial();
        if (socialNetWorkProto.isInitialized())
          return socialNetWorkProto; 
        throw newUninitializedMessageException(socialNetWorkProto);
      }
      
      public SocialNetWorkProtos.SocialNetWorkProto buildPartial() {
        SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = new SocialNetWorkProtos.SocialNetWorkProto(this);
        SocialNetWorkProtos.SocialNetWorkProto.access$602(socialNetWorkProto, this.event_);
        SocialNetWorkProtos.SocialNetWorkProto.access$702(socialNetWorkProto, this.groupId_);
        SocialNetWorkProtos.SocialNetWorkProto.access$802(socialNetWorkProto, this.source_);
        onBuilt();
        return socialNetWorkProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.groupId_ = "";
        this.source_ = 0;
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
      
      public Builder clearGroupId() {
        this.groupId_ = SocialNetWorkProtos.SocialNetWorkProto.getDefaultInstance().getGroupId();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearSource() {
        this.source_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public SocialNetWorkProtos.SocialNetWorkProto getDefaultInstanceForType() {
        return SocialNetWorkProtos.SocialNetWorkProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
      }
      
      public SocialNetWorkProtos.Event getEvent() {
        SocialNetWorkProtos.Event event2 = SocialNetWorkProtos.Event.valueOf(this.event_);
        SocialNetWorkProtos.Event event1 = event2;
        if (event2 == null)
          event1 = SocialNetWorkProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public String getGroupId() {
        Object object = this.groupId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.groupId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getGroupIdBytes() {
        Object object = this.groupId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.groupId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public SocialNetWorkProtos.SourceType getSource() {
        SocialNetWorkProtos.SourceType sourceType2 = SocialNetWorkProtos.SourceType.valueOf(this.source_);
        SocialNetWorkProtos.SourceType sourceType1 = sourceType2;
        if (sourceType2 == null)
          sourceType1 = SocialNetWorkProtos.SourceType.UNRECOGNIZED; 
        return sourceType1;
      }
      
      public int getSourceValue() {
        return this.source_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialNetWorkProtos.SocialNetWorkProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(SocialNetWorkProtos.SocialNetWorkProto param2SocialNetWorkProto) {
        if (param2SocialNetWorkProto == SocialNetWorkProtos.SocialNetWorkProto.getDefaultInstance())
          return this; 
        if (param2SocialNetWorkProto.event_ != 0)
          setEventValue(param2SocialNetWorkProto.getEventValue()); 
        if (!param2SocialNetWorkProto.getGroupId().isEmpty()) {
          this.groupId_ = param2SocialNetWorkProto.groupId_;
          onChanged();
        } 
        if (param2SocialNetWorkProto.source_ != 0)
          setSourceValue(param2SocialNetWorkProto.getSourceValue()); 
        mergeUnknownFields(param2SocialNetWorkProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = (SocialNetWorkProtos.SocialNetWorkProto)SocialNetWorkProtos.SocialNetWorkProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = (SocialNetWorkProtos.SocialNetWorkProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((SocialNetWorkProtos.SocialNetWorkProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof SocialNetWorkProtos.SocialNetWorkProto)
          return mergeFrom((SocialNetWorkProtos.SocialNetWorkProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setEvent(SocialNetWorkProtos.Event param2Event) {
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
      
      public Builder setGroupId(String param2String) {
        if (param2String != null) {
          this.groupId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGroupIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SocialNetWorkProtos.SocialNetWorkProto.checkByteStringIsUtf8(param2ByteString);
          this.groupId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSource(SocialNetWorkProtos.SourceType param2SourceType) {
        if (param2SourceType != null) {
          this.source_ = param2SourceType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSourceValue(int param2Int) {
        this.source_ = param2Int;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<SocialNetWorkProto> {
    public SocialNetWorkProtos.SocialNetWorkProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new SocialNetWorkProtos.SocialNetWorkProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<SocialNetWorkProto.Builder> implements SocialNetWorkProtoOrBuilder {
    private int event_ = 0;
    
    private Object groupId_ = "";
    
    private int source_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      SocialNetWorkProtos.SocialNetWorkProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SocialNetWorkProtos.SocialNetWorkProto build() {
      SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = buildPartial();
      if (socialNetWorkProto.isInitialized())
        return socialNetWorkProto; 
      throw newUninitializedMessageException(socialNetWorkProto);
    }
    
    public SocialNetWorkProtos.SocialNetWorkProto buildPartial() {
      SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = new SocialNetWorkProtos.SocialNetWorkProto(this);
      SocialNetWorkProtos.SocialNetWorkProto.access$602(socialNetWorkProto, this.event_);
      SocialNetWorkProtos.SocialNetWorkProto.access$702(socialNetWorkProto, this.groupId_);
      SocialNetWorkProtos.SocialNetWorkProto.access$802(socialNetWorkProto, this.source_);
      onBuilt();
      return socialNetWorkProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.groupId_ = "";
      this.source_ = 0;
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
    
    public Builder clearGroupId() {
      this.groupId_ = SocialNetWorkProtos.SocialNetWorkProto.getDefaultInstance().getGroupId();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSource() {
      this.source_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public SocialNetWorkProtos.SocialNetWorkProto getDefaultInstanceForType() {
      return SocialNetWorkProtos.SocialNetWorkProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
    }
    
    public SocialNetWorkProtos.Event getEvent() {
      SocialNetWorkProtos.Event event2 = SocialNetWorkProtos.Event.valueOf(this.event_);
      SocialNetWorkProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SocialNetWorkProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getGroupId() {
      Object object = this.groupId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.groupId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getGroupIdBytes() {
      Object object = this.groupId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.groupId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public SocialNetWorkProtos.SourceType getSource() {
      SocialNetWorkProtos.SourceType sourceType2 = SocialNetWorkProtos.SourceType.valueOf(this.source_);
      SocialNetWorkProtos.SourceType sourceType1 = sourceType2;
      if (sourceType2 == null)
        sourceType1 = SocialNetWorkProtos.SourceType.UNRECOGNIZED; 
      return sourceType1;
    }
    
    public int getSourceValue() {
      return this.source_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialNetWorkProtos.SocialNetWorkProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SocialNetWorkProtos.SocialNetWorkProto param1SocialNetWorkProto) {
      if (param1SocialNetWorkProto == SocialNetWorkProtos.SocialNetWorkProto.getDefaultInstance())
        return this; 
      if (param1SocialNetWorkProto.event_ != 0)
        setEventValue(param1SocialNetWorkProto.getEventValue()); 
      if (!param1SocialNetWorkProto.getGroupId().isEmpty()) {
        this.groupId_ = param1SocialNetWorkProto.groupId_;
        onChanged();
      } 
      if (param1SocialNetWorkProto.source_ != 0)
        setSourceValue(param1SocialNetWorkProto.getSourceValue()); 
      mergeUnknownFields(param1SocialNetWorkProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = (SocialNetWorkProtos.SocialNetWorkProto)SocialNetWorkProtos.SocialNetWorkProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SocialNetWorkProtos.SocialNetWorkProto socialNetWorkProto = (SocialNetWorkProtos.SocialNetWorkProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SocialNetWorkProtos.SocialNetWorkProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SocialNetWorkProtos.SocialNetWorkProto)
        return mergeFrom((SocialNetWorkProtos.SocialNetWorkProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setEvent(SocialNetWorkProtos.Event param1Event) {
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
    
    public Builder setGroupId(String param1String) {
      if (param1String != null) {
        this.groupId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGroupIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SocialNetWorkProtos.SocialNetWorkProto.checkByteStringIsUtf8(param1ByteString);
        this.groupId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSource(SocialNetWorkProtos.SourceType param1SourceType) {
      if (param1SourceType != null) {
        this.source_ = param1SourceType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSourceValue(int param1Int) {
      this.source_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface SocialNetWorkProtoOrBuilder extends MessageOrBuilder {
    SocialNetWorkProtos.Event getEvent();
    
    int getEventValue();
    
    String getGroupId();
    
    ByteString getGroupIdBytes();
    
    SocialNetWorkProtos.SourceType getSource();
    
    int getSourceValue();
  }
  
  public enum SourceType implements ProtocolMessageEnum {
    CIRCLE(0),
    GROUPINFO(0),
    MESSAGE(0),
    MYGROUP(0),
    UNKNOWN_SOURCE_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_VALUE = 2;
    
    public static final int GROUPINFO_VALUE = 4;
    
    public static final int MESSAGE_VALUE = 1;
    
    public static final int MYGROUP_VALUE = 3;
    
    public static final int UNKNOWN_SOURCE_TYPE_VALUE = 0;
    
    private static final SourceType[] VALUES;
    
    private static final Internal.EnumLiteMap<SourceType> internalValueMap;
    
    private final int value;
    
    static {
      CIRCLE = new SourceType("CIRCLE", 2, 2);
      MYGROUP = new SourceType("MYGROUP", 3, 3);
      GROUPINFO = new SourceType("GROUPINFO", 4, 4);
      UNRECOGNIZED = new SourceType("UNRECOGNIZED", 5, -1);
      $VALUES = new SourceType[] { UNKNOWN_SOURCE_TYPE, MESSAGE, CIRCLE, MYGROUP, GROUPINFO, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<SourceType>() {
          public SocialNetWorkProtos.SourceType findValueByNumber(int param2Int) {
            return SocialNetWorkProtos.SourceType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    SourceType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static SourceType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : GROUPINFO) : MYGROUP) : CIRCLE) : MESSAGE) : UNKNOWN_SOURCE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SocialNetWorkProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<SourceType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<SourceType> {
    public SocialNetWorkProtos.SourceType findValueByNumber(int param1Int) {
      return SocialNetWorkProtos.SourceType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\socialnet\SocialNetWorkProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
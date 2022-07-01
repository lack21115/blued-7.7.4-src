package com.blued.das.client.featured;

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

public final class FeaturedProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\024FeaturedProtos.proto\022\035com.blued.das.client.featured\"w\n\rFeaturedProto\0223\n\005event\030\001 \001(\0162$.com.blued.das.client.featured.Event\022\022\n\ntarget_uid\030\002 \001(\t\022\016\n\006reason\030\003 \001(\005\022\r\n\005label\030\004 \001(\t*[\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\036\n\032NEARBY_FEATURED_PHOTO_DRAW\020\001\022\037\n\033NEARBY_FEATURED_PHOTO_CLICK\020\002B\013¢\002\bFEATUREDb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_featured_FeaturedProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_featured_FeaturedProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_featured_FeaturedProto_descriptor, new String[] { "Event", "TargetUid", "Reason", "Label" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    NEARBY_FEATURED_PHOTO_CLICK,
    NEARBY_FEATURED_PHOTO_DRAW,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int NEARBY_FEATURED_PHOTO_CLICK_VALUE = 2;
    
    public static final int NEARBY_FEATURED_PHOTO_DRAW_VALUE = 1;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      NEARBY_FEATURED_PHOTO_CLICK = new Event("NEARBY_FEATURED_PHOTO_CLICK", 2, 2);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 3, -1);
      $VALUES = new Event[] { UNKNOWN_EVENT, NEARBY_FEATURED_PHOTO_DRAW, NEARBY_FEATURED_PHOTO_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public FeaturedProtos.Event findValueByNumber(int param2Int) {
            return FeaturedProtos.Event.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Event(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Event forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : NEARBY_FEATURED_PHOTO_CLICK) : NEARBY_FEATURED_PHOTO_DRAW) : UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeaturedProtos.getDescriptor().getEnumTypes().get(0);
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
    public FeaturedProtos.Event findValueByNumber(int param1Int) {
      return FeaturedProtos.Event.forNumber(param1Int);
    }
  }
  
  public static final class FeaturedProto extends GeneratedMessageV3 implements FeaturedProtoOrBuilder {
    private static final FeaturedProto DEFAULT_INSTANCE = new FeaturedProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int LABEL_FIELD_NUMBER = 4;
    
    private static final Parser<FeaturedProto> PARSER = (Parser<FeaturedProto>)new AbstractParser<FeaturedProto>() {
        public FeaturedProtos.FeaturedProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new FeaturedProtos.FeaturedProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REASON_FIELD_NUMBER = 3;
    
    public static final int TARGET_UID_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private int event_;
    
    private volatile Object label_;
    
    private byte memoizedIsInitialized = -1;
    
    private int reason_;
    
    private volatile Object targetUid_;
    
    private FeaturedProto() {
      this.event_ = 0;
      this.targetUid_ = "";
      this.label_ = "";
    }
    
    private FeaturedProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    if (i != 34) {
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.label_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.reason_ = param1CodedInputStream.readInt32();
                  continue;
                } 
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private FeaturedProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static FeaturedProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FeaturedProto param1FeaturedProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1FeaturedProto);
    }
    
    public static FeaturedProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FeaturedProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static FeaturedProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FeaturedProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FeaturedProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FeaturedProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static FeaturedProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FeaturedProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FeaturedProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FeaturedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static FeaturedProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FeaturedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FeaturedProto parseFrom(InputStream param1InputStream) throws IOException {
      return (FeaturedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static FeaturedProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FeaturedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FeaturedProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (FeaturedProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static FeaturedProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FeaturedProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static FeaturedProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FeaturedProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static FeaturedProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FeaturedProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FeaturedProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof FeaturedProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((FeaturedProto)param1Object).event_) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : ((getReason() != param1Object.getReason()) ? false : (!getLabel().equals(param1Object.getLabel()) ? false : (!!this.unknownFields.equals(((FeaturedProto)param1Object).unknownFields)))));
    }
    
    public FeaturedProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public FeaturedProtos.Event getEvent() {
      FeaturedProtos.Event event2 = FeaturedProtos.Event.valueOf(this.event_);
      FeaturedProtos.Event event1 = event2;
      if (event2 == null)
        event1 = FeaturedProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getLabel() {
      Object object = this.label_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.label_ = object;
      return (String)object;
    }
    
    public ByteString getLabelBytes() {
      Object object = this.label_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.label_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<FeaturedProto> getParserForType() {
      return PARSER;
    }
    
    public int getReason() {
      return this.reason_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != FeaturedProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (!getTargetUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.targetUid_); 
      int k = this.reason_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(3, k); 
      i = j;
      if (!getLabelBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.label_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getTargetUid() {
      Object object = this.targetUid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.targetUid_ = object;
      return (String)object;
    }
    
    public ByteString getTargetUidBytes() {
      Object object = this.targetUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.targetUid_ = object;
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
      int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getTargetUid().hashCode()) * 37 + 3) * 53 + getReason()) * 37 + 4) * 53 + getLabel().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FeaturedProto.class, Builder.class);
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
      return new FeaturedProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != FeaturedProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.targetUid_); 
      int i = this.reason_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      if (!getLabelBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.label_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FeaturedProtos.FeaturedProtoOrBuilder {
      private int event_ = 0;
      
      private Object label_ = "";
      
      private int reason_;
      
      private Object targetUid_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        FeaturedProtos.FeaturedProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public FeaturedProtos.FeaturedProto build() {
        FeaturedProtos.FeaturedProto featuredProto = buildPartial();
        if (featuredProto.isInitialized())
          return featuredProto; 
        throw newUninitializedMessageException(featuredProto);
      }
      
      public FeaturedProtos.FeaturedProto buildPartial() {
        FeaturedProtos.FeaturedProto featuredProto = new FeaturedProtos.FeaturedProto(this);
        FeaturedProtos.FeaturedProto.access$602(featuredProto, this.event_);
        FeaturedProtos.FeaturedProto.access$702(featuredProto, this.targetUid_);
        FeaturedProtos.FeaturedProto.access$802(featuredProto, this.reason_);
        FeaturedProtos.FeaturedProto.access$902(featuredProto, this.label_);
        onBuilt();
        return featuredProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.targetUid_ = "";
        this.reason_ = 0;
        this.label_ = "";
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
      
      public Builder clearLabel() {
        this.label_ = FeaturedProtos.FeaturedProto.getDefaultInstance().getLabel();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearReason() {
        this.reason_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = FeaturedProtos.FeaturedProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public FeaturedProtos.FeaturedProto getDefaultInstanceForType() {
        return FeaturedProtos.FeaturedProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_descriptor;
      }
      
      public FeaturedProtos.Event getEvent() {
        FeaturedProtos.Event event2 = FeaturedProtos.Event.valueOf(this.event_);
        FeaturedProtos.Event event1 = event2;
        if (event2 == null)
          event1 = FeaturedProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public String getLabel() {
        Object object = this.label_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.label_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLabelBytes() {
        Object object = this.label_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.label_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getReason() {
        return this.reason_;
      }
      
      public String getTargetUid() {
        Object object = this.targetUid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.targetUid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTargetUidBytes() {
        Object object = this.targetUid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.targetUid_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FeaturedProtos.FeaturedProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(FeaturedProtos.FeaturedProto param2FeaturedProto) {
        if (param2FeaturedProto == FeaturedProtos.FeaturedProto.getDefaultInstance())
          return this; 
        if (param2FeaturedProto.event_ != 0)
          setEventValue(param2FeaturedProto.getEventValue()); 
        if (!param2FeaturedProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2FeaturedProto.targetUid_;
          onChanged();
        } 
        if (param2FeaturedProto.getReason() != 0)
          setReason(param2FeaturedProto.getReason()); 
        if (!param2FeaturedProto.getLabel().isEmpty()) {
          this.label_ = param2FeaturedProto.label_;
          onChanged();
        } 
        mergeUnknownFields(param2FeaturedProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          FeaturedProtos.FeaturedProto featuredProto = (FeaturedProtos.FeaturedProto)FeaturedProtos.FeaturedProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          FeaturedProtos.FeaturedProto featuredProto = (FeaturedProtos.FeaturedProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((FeaturedProtos.FeaturedProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof FeaturedProtos.FeaturedProto)
          return mergeFrom((FeaturedProtos.FeaturedProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setEvent(FeaturedProtos.Event param2Event) {
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
      
      public Builder setLabel(String param2String) {
        if (param2String != null) {
          this.label_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLabelBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeaturedProtos.FeaturedProto.checkByteStringIsUtf8(param2ByteString);
          this.label_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setReason(int param2Int) {
        this.reason_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTargetUid(String param2String) {
        if (param2String != null) {
          this.targetUid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTargetUidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeaturedProtos.FeaturedProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUid_ = param2ByteString;
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
  
  static final class null extends AbstractParser<FeaturedProto> {
    public FeaturedProtos.FeaturedProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new FeaturedProtos.FeaturedProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<FeaturedProto.Builder> implements FeaturedProtoOrBuilder {
    private int event_ = 0;
    
    private Object label_ = "";
    
    private int reason_;
    
    private Object targetUid_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      FeaturedProtos.FeaturedProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public FeaturedProtos.FeaturedProto build() {
      FeaturedProtos.FeaturedProto featuredProto = buildPartial();
      if (featuredProto.isInitialized())
        return featuredProto; 
      throw newUninitializedMessageException(featuredProto);
    }
    
    public FeaturedProtos.FeaturedProto buildPartial() {
      FeaturedProtos.FeaturedProto featuredProto = new FeaturedProtos.FeaturedProto(this);
      FeaturedProtos.FeaturedProto.access$602(featuredProto, this.event_);
      FeaturedProtos.FeaturedProto.access$702(featuredProto, this.targetUid_);
      FeaturedProtos.FeaturedProto.access$802(featuredProto, this.reason_);
      FeaturedProtos.FeaturedProto.access$902(featuredProto, this.label_);
      onBuilt();
      return featuredProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.targetUid_ = "";
      this.reason_ = 0;
      this.label_ = "";
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
    
    public Builder clearLabel() {
      this.label_ = FeaturedProtos.FeaturedProto.getDefaultInstance().getLabel();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearReason() {
      this.reason_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = FeaturedProtos.FeaturedProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public FeaturedProtos.FeaturedProto getDefaultInstanceForType() {
      return FeaturedProtos.FeaturedProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_descriptor;
    }
    
    public FeaturedProtos.Event getEvent() {
      FeaturedProtos.Event event2 = FeaturedProtos.Event.valueOf(this.event_);
      FeaturedProtos.Event event1 = event2;
      if (event2 == null)
        event1 = FeaturedProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getLabel() {
      Object object = this.label_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.label_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLabelBytes() {
      Object object = this.label_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.label_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getReason() {
      return this.reason_;
    }
    
    public String getTargetUid() {
      Object object = this.targetUid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.targetUid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTargetUidBytes() {
      Object object = this.targetUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.targetUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return FeaturedProtos.internal_static_com_blued_das_client_featured_FeaturedProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FeaturedProtos.FeaturedProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(FeaturedProtos.FeaturedProto param1FeaturedProto) {
      if (param1FeaturedProto == FeaturedProtos.FeaturedProto.getDefaultInstance())
        return this; 
      if (param1FeaturedProto.event_ != 0)
        setEventValue(param1FeaturedProto.getEventValue()); 
      if (!param1FeaturedProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1FeaturedProto.targetUid_;
        onChanged();
      } 
      if (param1FeaturedProto.getReason() != 0)
        setReason(param1FeaturedProto.getReason()); 
      if (!param1FeaturedProto.getLabel().isEmpty()) {
        this.label_ = param1FeaturedProto.label_;
        onChanged();
      } 
      mergeUnknownFields(param1FeaturedProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        FeaturedProtos.FeaturedProto featuredProto = (FeaturedProtos.FeaturedProto)FeaturedProtos.FeaturedProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        FeaturedProtos.FeaturedProto featuredProto = (FeaturedProtos.FeaturedProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((FeaturedProtos.FeaturedProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof FeaturedProtos.FeaturedProto)
        return mergeFrom((FeaturedProtos.FeaturedProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setEvent(FeaturedProtos.Event param1Event) {
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
    
    public Builder setLabel(String param1String) {
      if (param1String != null) {
        this.label_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLabelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeaturedProtos.FeaturedProto.checkByteStringIsUtf8(param1ByteString);
        this.label_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setReason(int param1Int) {
      this.reason_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTargetUid(String param1String) {
      if (param1String != null) {
        this.targetUid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTargetUidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeaturedProtos.FeaturedProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface FeaturedProtoOrBuilder extends MessageOrBuilder {
    FeaturedProtos.Event getEvent();
    
    int getEventValue();
    
    String getLabel();
    
    ByteString getLabelBytes();
    
    int getReason();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\featured\FeaturedProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
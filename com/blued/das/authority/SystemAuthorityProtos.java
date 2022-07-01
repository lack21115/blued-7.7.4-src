package com.blued.das.authority;

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

public final class SystemAuthorityProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033SystemAuthorityProtos.proto\022\027com.blued.das.authority\"¡\001\n\024SystemAuthorityProto\022-\n\005event\030\001 \001(\0162\036.com.blued.das.authority.Event\022+\n\004type\030\002 \001(\0162\035.com.blued.das.authority.Type\022\017\n\007is_open\030\003 \001(\b\022\013\n\003url\030\004 \001(\t\022\017\n\007content\030\005 \001(\t*ô\001\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\024\n\020SYSTEM_AUTHORITY\020\001\022\027\n\023IOS_SCREENSHOT_SHOW\020\002\022\026\n\022IOS_AUTHENTICATION\020\003\022\032\n\026PHONE_CONFIRM_POP_SHOW\020\004\022\033\n\027PHONE_CONFIRM_USE_CLICK\020\005\022\036\n\032PHONE_CONFIRM_CHANGE_CLICK\020\006\022\021\n\rPUSH_RECEIVED\020\007\022\016\n\nPUSH_CLICK\020\b\022\025\n\021PUSH_MSG_NAVIGATE\020\t*0\n\004Type\022\020\n\fUNKNOWN_TYPE\020\000\022\b\n\004PUSH\020\001\022\f\n\bLOCATION\020\002B\023¢\002\020SYSTEM_AUTHORITYb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor, new String[] { "Event", "Type", "IsOpen", "Url", "Content" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    IOS_AUTHENTICATION,
    IOS_SCREENSHOT_SHOW,
    PHONE_CONFIRM_CHANGE_CLICK,
    PHONE_CONFIRM_POP_SHOW,
    PHONE_CONFIRM_USE_CLICK,
    PUSH_CLICK,
    PUSH_MSG_NAVIGATE,
    PUSH_RECEIVED,
    SYSTEM_AUTHORITY,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int IOS_AUTHENTICATION_VALUE = 3;
    
    public static final int IOS_SCREENSHOT_SHOW_VALUE = 2;
    
    public static final int PHONE_CONFIRM_CHANGE_CLICK_VALUE = 6;
    
    public static final int PHONE_CONFIRM_POP_SHOW_VALUE = 4;
    
    public static final int PHONE_CONFIRM_USE_CLICK_VALUE = 5;
    
    public static final int PUSH_CLICK_VALUE = 8;
    
    public static final int PUSH_MSG_NAVIGATE_VALUE = 9;
    
    public static final int PUSH_RECEIVED_VALUE = 7;
    
    public static final int SYSTEM_AUTHORITY_VALUE = 1;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      IOS_SCREENSHOT_SHOW = new Event("IOS_SCREENSHOT_SHOW", 2, 2);
      IOS_AUTHENTICATION = new Event("IOS_AUTHENTICATION", 3, 3);
      PHONE_CONFIRM_POP_SHOW = new Event("PHONE_CONFIRM_POP_SHOW", 4, 4);
      PHONE_CONFIRM_USE_CLICK = new Event("PHONE_CONFIRM_USE_CLICK", 5, 5);
      PHONE_CONFIRM_CHANGE_CLICK = new Event("PHONE_CONFIRM_CHANGE_CLICK", 6, 6);
      PUSH_RECEIVED = new Event("PUSH_RECEIVED", 7, 7);
      PUSH_CLICK = new Event("PUSH_CLICK", 8, 8);
      PUSH_MSG_NAVIGATE = new Event("PUSH_MSG_NAVIGATE", 9, 9);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 10, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, SYSTEM_AUTHORITY, IOS_SCREENSHOT_SHOW, IOS_AUTHENTICATION, PHONE_CONFIRM_POP_SHOW, PHONE_CONFIRM_USE_CLICK, PHONE_CONFIRM_CHANGE_CLICK, PUSH_RECEIVED, PUSH_CLICK, PUSH_MSG_NAVIGATE, 
          UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public SystemAuthorityProtos.Event findValueByNumber(int param2Int) {
            return SystemAuthorityProtos.Event.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Event(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Event forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 9:
          return PUSH_MSG_NAVIGATE;
        case 8:
          return PUSH_CLICK;
        case 7:
          return PUSH_RECEIVED;
        case 6:
          return PHONE_CONFIRM_CHANGE_CLICK;
        case 5:
          return PHONE_CONFIRM_USE_CLICK;
        case 4:
          return PHONE_CONFIRM_POP_SHOW;
        case 3:
          return IOS_AUTHENTICATION;
        case 2:
          return IOS_SCREENSHOT_SHOW;
        case 1:
          return SYSTEM_AUTHORITY;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SystemAuthorityProtos.getDescriptor().getEnumTypes().get(0);
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
    public SystemAuthorityProtos.Event findValueByNumber(int param1Int) {
      return SystemAuthorityProtos.Event.forNumber(param1Int);
    }
  }
  
  public static final class SystemAuthorityProto extends GeneratedMessageV3 implements SystemAuthorityProtoOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 5;
    
    private static final SystemAuthorityProto DEFAULT_INSTANCE = new SystemAuthorityProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int IS_OPEN_FIELD_NUMBER = 3;
    
    private static final Parser<SystemAuthorityProto> PARSER = (Parser<SystemAuthorityProto>)new AbstractParser<SystemAuthorityProto>() {
        public SystemAuthorityProtos.SystemAuthorityProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new SystemAuthorityProtos.SystemAuthorityProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TYPE_FIELD_NUMBER = 2;
    
    public static final int URL_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object content_;
    
    private int event_;
    
    private boolean isOpen_;
    
    private byte memoizedIsInitialized = -1;
    
    private int type_;
    
    private volatile Object url_;
    
    private SystemAuthorityProto() {
      this.event_ = 0;
      this.type_ = 0;
      this.url_ = "";
      this.content_ = "";
    }
    
    private SystemAuthorityProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 16) {
                  if (i != 24) {
                    if (i != 34) {
                      if (i != 42) {
                        if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                          continue; 
                        continue;
                      } 
                      this.content_ = param1CodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    this.url_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.isOpen_ = param1CodedInputStream.readBool();
                  continue;
                } 
                this.type_ = param1CodedInputStream.readEnum();
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
    
    private SystemAuthorityProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static SystemAuthorityProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SystemAuthorityProto param1SystemAuthorityProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1SystemAuthorityProto);
    }
    
    public static SystemAuthorityProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (SystemAuthorityProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static SystemAuthorityProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SystemAuthorityProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SystemAuthorityProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (SystemAuthorityProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static SystemAuthorityProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SystemAuthorityProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static SystemAuthorityProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (SystemAuthorityProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static SystemAuthorityProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SystemAuthorityProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static SystemAuthorityProto parseFrom(InputStream param1InputStream) throws IOException {
      return (SystemAuthorityProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static SystemAuthorityProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SystemAuthorityProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SystemAuthorityProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (SystemAuthorityProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static SystemAuthorityProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SystemAuthorityProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static SystemAuthorityProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (SystemAuthorityProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static SystemAuthorityProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SystemAuthorityProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<SystemAuthorityProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof SystemAuthorityProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((SystemAuthorityProto)param1Object).event_) ? false : ((this.type_ != ((SystemAuthorityProto)param1Object).type_) ? false : ((getIsOpen() != param1Object.getIsOpen()) ? false : (!getUrl().equals(param1Object.getUrl()) ? false : (!getContent().equals(param1Object.getContent()) ? false : (!!this.unknownFields.equals(((SystemAuthorityProto)param1Object).unknownFields))))));
    }
    
    public String getContent() {
      Object object = this.content_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.content_ = object;
      return (String)object;
    }
    
    public ByteString getContentBytes() {
      Object object = this.content_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.content_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public SystemAuthorityProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public SystemAuthorityProtos.Event getEvent() {
      SystemAuthorityProtos.Event event2 = SystemAuthorityProtos.Event.valueOf(this.event_);
      SystemAuthorityProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SystemAuthorityProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public Parser<SystemAuthorityProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != SystemAuthorityProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.type_ != SystemAuthorityProtos.Type.UNKNOWN_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.type_); 
      boolean bool = this.isOpen_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(3, bool); 
      i = j;
      if (!getUrlBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.url_); 
      j = i;
      if (!getContentBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.content_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public SystemAuthorityProtos.Type getType() {
      SystemAuthorityProtos.Type type2 = SystemAuthorityProtos.Type.valueOf(this.type_);
      SystemAuthorityProtos.Type type1 = type2;
      if (type2 == null)
        type1 = SystemAuthorityProtos.Type.UNRECOGNIZED; 
      return type1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.url_ = object;
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.type_) * 37 + 3) * 53 + Internal.hashBoolean(getIsOpen())) * 37 + 4) * 53 + getUrl().hashCode()) * 37 + 5) * 53 + getContent().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemAuthorityProto.class, Builder.class);
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
      return new SystemAuthorityProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != SystemAuthorityProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.type_ != SystemAuthorityProtos.Type.UNKNOWN_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.type_); 
      boolean bool = this.isOpen_;
      if (bool)
        param1CodedOutputStream.writeBool(3, bool); 
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.url_); 
      if (!getContentBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.content_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemAuthorityProtos.SystemAuthorityProtoOrBuilder {
      private Object content_ = "";
      
      private int event_ = 0;
      
      private boolean isOpen_;
      
      private int type_ = 0;
      
      private Object url_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        SystemAuthorityProtos.SystemAuthorityProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public SystemAuthorityProtos.SystemAuthorityProto build() {
        SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = buildPartial();
        if (systemAuthorityProto.isInitialized())
          return systemAuthorityProto; 
        throw newUninitializedMessageException(systemAuthorityProto);
      }
      
      public SystemAuthorityProtos.SystemAuthorityProto buildPartial() {
        SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = new SystemAuthorityProtos.SystemAuthorityProto(this);
        SystemAuthorityProtos.SystemAuthorityProto.access$602(systemAuthorityProto, this.event_);
        SystemAuthorityProtos.SystemAuthorityProto.access$702(systemAuthorityProto, this.type_);
        SystemAuthorityProtos.SystemAuthorityProto.access$802(systemAuthorityProto, this.isOpen_);
        SystemAuthorityProtos.SystemAuthorityProto.access$902(systemAuthorityProto, this.url_);
        SystemAuthorityProtos.SystemAuthorityProto.access$1002(systemAuthorityProto, this.content_);
        onBuilt();
        return systemAuthorityProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.type_ = 0;
        this.isOpen_ = false;
        this.url_ = "";
        this.content_ = "";
        return this;
      }
      
      public Builder clearContent() {
        this.content_ = SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance().getContent();
        onChanged();
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
      
      public Builder clearIsOpen() {
        this.isOpen_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearType() {
        this.type_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearUrl() {
        this.url_ = SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getContent() {
        Object object = this.content_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.content_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getContentBytes() {
        Object object = this.content_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.content_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public SystemAuthorityProtos.SystemAuthorityProto getDefaultInstanceForType() {
        return SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
      }
      
      public SystemAuthorityProtos.Event getEvent() {
        SystemAuthorityProtos.Event event2 = SystemAuthorityProtos.Event.valueOf(this.event_);
        SystemAuthorityProtos.Event event1 = event2;
        if (event2 == null)
          event1 = SystemAuthorityProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public boolean getIsOpen() {
        return this.isOpen_;
      }
      
      public SystemAuthorityProtos.Type getType() {
        SystemAuthorityProtos.Type type2 = SystemAuthorityProtos.Type.valueOf(this.type_);
        SystemAuthorityProtos.Type type1 = type2;
        if (type2 == null)
          type1 = SystemAuthorityProtos.Type.UNRECOGNIZED; 
        return type1;
      }
      
      public int getTypeValue() {
        return this.type_;
      }
      
      public String getUrl() {
        Object object = this.url_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.url_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getUrlBytes() {
        Object object = this.url_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.url_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemAuthorityProtos.SystemAuthorityProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(SystemAuthorityProtos.SystemAuthorityProto param2SystemAuthorityProto) {
        if (param2SystemAuthorityProto == SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance())
          return this; 
        if (param2SystemAuthorityProto.event_ != 0)
          setEventValue(param2SystemAuthorityProto.getEventValue()); 
        if (param2SystemAuthorityProto.type_ != 0)
          setTypeValue(param2SystemAuthorityProto.getTypeValue()); 
        if (param2SystemAuthorityProto.getIsOpen())
          setIsOpen(param2SystemAuthorityProto.getIsOpen()); 
        if (!param2SystemAuthorityProto.getUrl().isEmpty()) {
          this.url_ = param2SystemAuthorityProto.url_;
          onChanged();
        } 
        if (!param2SystemAuthorityProto.getContent().isEmpty()) {
          this.content_ = param2SystemAuthorityProto.content_;
          onChanged();
        } 
        mergeUnknownFields(param2SystemAuthorityProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = (SystemAuthorityProtos.SystemAuthorityProto)SystemAuthorityProtos.SystemAuthorityProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = (SystemAuthorityProtos.SystemAuthorityProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((SystemAuthorityProtos.SystemAuthorityProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof SystemAuthorityProtos.SystemAuthorityProto)
          return mergeFrom((SystemAuthorityProtos.SystemAuthorityProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setContent(String param2String) {
        if (param2String != null) {
          this.content_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setContentBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SystemAuthorityProtos.SystemAuthorityProto.checkByteStringIsUtf8(param2ByteString);
          this.content_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEvent(SystemAuthorityProtos.Event param2Event) {
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
      
      public Builder setIsOpen(boolean param2Boolean) {
        this.isOpen_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setType(SystemAuthorityProtos.Type param2Type) {
        if (param2Type != null) {
          this.type_ = param2Type.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTypeValue(int param2Int) {
        this.type_ = param2Int;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setUrl(String param2String) {
        if (param2String != null) {
          this.url_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUrlBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SystemAuthorityProtos.SystemAuthorityProto.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
    }
  }
  
  static final class null extends AbstractParser<SystemAuthorityProto> {
    public SystemAuthorityProtos.SystemAuthorityProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new SystemAuthorityProtos.SystemAuthorityProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<SystemAuthorityProto.Builder> implements SystemAuthorityProtoOrBuilder {
    private Object content_ = "";
    
    private int event_ = 0;
    
    private boolean isOpen_;
    
    private int type_ = 0;
    
    private Object url_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      SystemAuthorityProtos.SystemAuthorityProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SystemAuthorityProtos.SystemAuthorityProto build() {
      SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = buildPartial();
      if (systemAuthorityProto.isInitialized())
        return systemAuthorityProto; 
      throw newUninitializedMessageException(systemAuthorityProto);
    }
    
    public SystemAuthorityProtos.SystemAuthorityProto buildPartial() {
      SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = new SystemAuthorityProtos.SystemAuthorityProto(this);
      SystemAuthorityProtos.SystemAuthorityProto.access$602(systemAuthorityProto, this.event_);
      SystemAuthorityProtos.SystemAuthorityProto.access$702(systemAuthorityProto, this.type_);
      SystemAuthorityProtos.SystemAuthorityProto.access$802(systemAuthorityProto, this.isOpen_);
      SystemAuthorityProtos.SystemAuthorityProto.access$902(systemAuthorityProto, this.url_);
      SystemAuthorityProtos.SystemAuthorityProto.access$1002(systemAuthorityProto, this.content_);
      onBuilt();
      return systemAuthorityProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.type_ = 0;
      this.isOpen_ = false;
      this.url_ = "";
      this.content_ = "";
      return this;
    }
    
    public Builder clearContent() {
      this.content_ = SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance().getContent();
      onChanged();
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
    
    public Builder clearIsOpen() {
      this.isOpen_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearType() {
      this.type_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearUrl() {
      this.url_ = SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getContent() {
      Object object = this.content_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.content_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getContentBytes() {
      Object object = this.content_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.content_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public SystemAuthorityProtos.SystemAuthorityProto getDefaultInstanceForType() {
      return SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
    }
    
    public SystemAuthorityProtos.Event getEvent() {
      SystemAuthorityProtos.Event event2 = SystemAuthorityProtos.Event.valueOf(this.event_);
      SystemAuthorityProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SystemAuthorityProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public SystemAuthorityProtos.Type getType() {
      SystemAuthorityProtos.Type type2 = SystemAuthorityProtos.Type.valueOf(this.type_);
      SystemAuthorityProtos.Type type1 = type2;
      if (type2 == null)
        type1 = SystemAuthorityProtos.Type.UNRECOGNIZED; 
      return type1;
    }
    
    public int getTypeValue() {
      return this.type_;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.url_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemAuthorityProtos.SystemAuthorityProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SystemAuthorityProtos.SystemAuthorityProto param1SystemAuthorityProto) {
      if (param1SystemAuthorityProto == SystemAuthorityProtos.SystemAuthorityProto.getDefaultInstance())
        return this; 
      if (param1SystemAuthorityProto.event_ != 0)
        setEventValue(param1SystemAuthorityProto.getEventValue()); 
      if (param1SystemAuthorityProto.type_ != 0)
        setTypeValue(param1SystemAuthorityProto.getTypeValue()); 
      if (param1SystemAuthorityProto.getIsOpen())
        setIsOpen(param1SystemAuthorityProto.getIsOpen()); 
      if (!param1SystemAuthorityProto.getUrl().isEmpty()) {
        this.url_ = param1SystemAuthorityProto.url_;
        onChanged();
      } 
      if (!param1SystemAuthorityProto.getContent().isEmpty()) {
        this.content_ = param1SystemAuthorityProto.content_;
        onChanged();
      } 
      mergeUnknownFields(param1SystemAuthorityProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = (SystemAuthorityProtos.SystemAuthorityProto)SystemAuthorityProtos.SystemAuthorityProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SystemAuthorityProtos.SystemAuthorityProto systemAuthorityProto = (SystemAuthorityProtos.SystemAuthorityProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SystemAuthorityProtos.SystemAuthorityProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SystemAuthorityProtos.SystemAuthorityProto)
        return mergeFrom((SystemAuthorityProtos.SystemAuthorityProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setContent(String param1String) {
      if (param1String != null) {
        this.content_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setContentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SystemAuthorityProtos.SystemAuthorityProto.checkByteStringIsUtf8(param1ByteString);
        this.content_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEvent(SystemAuthorityProtos.Event param1Event) {
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
    
    public Builder setIsOpen(boolean param1Boolean) {
      this.isOpen_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setType(SystemAuthorityProtos.Type param1Type) {
      if (param1Type != null) {
        this.type_ = param1Type.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeValue(int param1Int) {
      this.type_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUrl(String param1String) {
      if (param1String != null) {
        this.url_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SystemAuthorityProtos.SystemAuthorityProto.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  public static interface SystemAuthorityProtoOrBuilder extends MessageOrBuilder {
    String getContent();
    
    ByteString getContentBytes();
    
    SystemAuthorityProtos.Event getEvent();
    
    int getEventValue();
    
    boolean getIsOpen();
    
    SystemAuthorityProtos.Type getType();
    
    int getTypeValue();
    
    String getUrl();
    
    ByteString getUrlBytes();
  }
  
  public enum Type implements ProtocolMessageEnum {
    LOCATION(0),
    PUSH(0),
    UNKNOWN_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int LOCATION_VALUE = 2;
    
    public static final int PUSH_VALUE = 1;
    
    public static final int UNKNOWN_TYPE_VALUE = 0;
    
    private static final Type[] VALUES;
    
    private static final Internal.EnumLiteMap<Type> internalValueMap;
    
    private final int value;
    
    static {
      LOCATION = new Type("LOCATION", 2, 2);
      UNRECOGNIZED = new Type("UNRECOGNIZED", 3, -1);
      $VALUES = new Type[] { UNKNOWN_TYPE, PUSH, LOCATION, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Type>() {
          public SystemAuthorityProtos.Type findValueByNumber(int param2Int) {
            return SystemAuthorityProtos.Type.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Type(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Type forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : LOCATION) : PUSH) : UNKNOWN_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SystemAuthorityProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<Type> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<Type> {
    public SystemAuthorityProtos.Type findValueByNumber(int param1Int) {
      return SystemAuthorityProtos.Type.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\authority\SystemAuthorityProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
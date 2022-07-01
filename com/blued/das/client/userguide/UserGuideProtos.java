package com.blued.das.client.userguide;

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

public final class UserGuideProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\025UserGuideProtos.proto\022\036com.blued.das.client.userguide\"Ä\001\n\016UserGuideProto\0224\n\005event\030\001 \001(\0162%.com.blued.das.client.userguide.Event\0229\n\bpage_num\030\002 \001(\0162'.com.blued.das.client.userguide.PageNum\022A\n\ffeature_type\030\003 \001(\0162+.com.blued.das.client.userguide.FeatureType*4\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\030\n\024USER_GUIDE_APGE_SHOW\020\001*>\n\007PageNum\022\024\n\020UNKNOWN_PAGE_NUM\020\000\022\016\n\nFIRST_PAGE\020\001\022\r\n\tLAST_PAGE\020\002*:\n\013FeatureType\022\030\n\024UNKNOWN_FEATURE_TYPE\020\000\022\021\n\rHOME_FEATURED\020\001B\r¢\002\nUSER_GUIDEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor, new String[] { "Event", "PageNum", "FeatureType" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0),
    USER_GUIDE_APGE_SHOW(1);
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    public static final int USER_GUIDE_APGE_SHOW_VALUE = 1;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Event[] { UNKNOWN_EVENT, USER_GUIDE_APGE_SHOW, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public UserGuideProtos.Event findValueByNumber(int param2Int) {
            return UserGuideProtos.Event.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Event(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Event forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : USER_GUIDE_APGE_SHOW) : UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return UserGuideProtos.getDescriptor().getEnumTypes().get(0);
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
    public UserGuideProtos.Event findValueByNumber(int param1Int) {
      return UserGuideProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum FeatureType implements ProtocolMessageEnum {
    UNKNOWN_FEATURE_TYPE(0),
    UNRECOGNIZED(0),
    HOME_FEATURED(1);
    
    public static final int HOME_FEATURED_VALUE = 1;
    
    public static final int UNKNOWN_FEATURE_TYPE_VALUE = 0;
    
    private static final FeatureType[] VALUES;
    
    private static final Internal.EnumLiteMap<FeatureType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new FeatureType[] { UNKNOWN_FEATURE_TYPE, HOME_FEATURED, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeatureType>() {
          public UserGuideProtos.FeatureType findValueByNumber(int param2Int) {
            return UserGuideProtos.FeatureType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeatureType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeatureType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : HOME_FEATURED) : UNKNOWN_FEATURE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return UserGuideProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<FeatureType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeatureType> {
    public UserGuideProtos.FeatureType findValueByNumber(int param1Int) {
      return UserGuideProtos.FeatureType.forNumber(param1Int);
    }
  }
  
  public enum PageNum implements ProtocolMessageEnum {
    FIRST_PAGE(0),
    LAST_PAGE(0),
    UNKNOWN_PAGE_NUM(0),
    UNRECOGNIZED(0);
    
    public static final int FIRST_PAGE_VALUE = 1;
    
    public static final int LAST_PAGE_VALUE = 2;
    
    public static final int UNKNOWN_PAGE_NUM_VALUE = 0;
    
    private static final PageNum[] VALUES;
    
    private static final Internal.EnumLiteMap<PageNum> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new PageNum[] { UNKNOWN_PAGE_NUM, FIRST_PAGE, LAST_PAGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PageNum>() {
          public UserGuideProtos.PageNum findValueByNumber(int param2Int) {
            return UserGuideProtos.PageNum.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PageNum(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PageNum forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : LAST_PAGE) : FIRST_PAGE) : UNKNOWN_PAGE_NUM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return UserGuideProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<PageNum> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PageNum> {
    public UserGuideProtos.PageNum findValueByNumber(int param1Int) {
      return UserGuideProtos.PageNum.forNumber(param1Int);
    }
  }
  
  public static final class UserGuideProto extends GeneratedMessageV3 implements UserGuideProtoOrBuilder {
    private static final UserGuideProto DEFAULT_INSTANCE = new UserGuideProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FEATURE_TYPE_FIELD_NUMBER = 3;
    
    public static final int PAGE_NUM_FIELD_NUMBER = 2;
    
    private static final Parser<UserGuideProto> PARSER = (Parser<UserGuideProto>)new AbstractParser<UserGuideProto>() {
        public UserGuideProtos.UserGuideProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new UserGuideProtos.UserGuideProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int event_;
    
    private int featureType_;
    
    private byte memoizedIsInitialized = -1;
    
    private int pageNum_;
    
    private UserGuideProto() {
      this.event_ = 0;
      this.pageNum_ = 0;
      this.featureType_ = 0;
    }
    
    private UserGuideProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.featureType_ = param1CodedInputStream.readEnum();
                  continue;
                } 
                this.pageNum_ = param1CodedInputStream.readEnum();
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
    
    private UserGuideProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static UserGuideProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(UserGuideProto param1UserGuideProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1UserGuideProto);
    }
    
    public static UserGuideProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (UserGuideProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static UserGuideProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UserGuideProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static UserGuideProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (UserGuideProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static UserGuideProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UserGuideProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static UserGuideProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (UserGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static UserGuideProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UserGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static UserGuideProto parseFrom(InputStream param1InputStream) throws IOException {
      return (UserGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static UserGuideProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UserGuideProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static UserGuideProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (UserGuideProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static UserGuideProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UserGuideProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static UserGuideProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (UserGuideProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static UserGuideProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UserGuideProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<UserGuideProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof UserGuideProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((UserGuideProto)param1Object).event_) ? false : ((this.pageNum_ != ((UserGuideProto)param1Object).pageNum_) ? false : ((this.featureType_ != ((UserGuideProto)param1Object).featureType_) ? false : (!!this.unknownFields.equals(((UserGuideProto)param1Object).unknownFields))));
    }
    
    public UserGuideProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public UserGuideProtos.Event getEvent() {
      UserGuideProtos.Event event2 = UserGuideProtos.Event.valueOf(this.event_);
      UserGuideProtos.Event event1 = event2;
      if (event2 == null)
        event1 = UserGuideProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public UserGuideProtos.FeatureType getFeatureType() {
      UserGuideProtos.FeatureType featureType2 = UserGuideProtos.FeatureType.valueOf(this.featureType_);
      UserGuideProtos.FeatureType featureType1 = featureType2;
      if (featureType2 == null)
        featureType1 = UserGuideProtos.FeatureType.UNRECOGNIZED; 
      return featureType1;
    }
    
    public int getFeatureTypeValue() {
      return this.featureType_;
    }
    
    public UserGuideProtos.PageNum getPageNum() {
      UserGuideProtos.PageNum pageNum2 = UserGuideProtos.PageNum.valueOf(this.pageNum_);
      UserGuideProtos.PageNum pageNum1 = pageNum2;
      if (pageNum2 == null)
        pageNum1 = UserGuideProtos.PageNum.UNRECOGNIZED; 
      return pageNum1;
    }
    
    public int getPageNumValue() {
      return this.pageNum_;
    }
    
    public Parser<UserGuideProto> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != UserGuideProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.pageNum_ != UserGuideProtos.PageNum.UNKNOWN_PAGE_NUM.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.pageNum_); 
      j = i;
      if (this.featureType_ != UserGuideProtos.FeatureType.UNKNOWN_FEATURE_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.featureType_); 
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
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.pageNum_) * 37 + 3) * 53 + this.featureType_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(UserGuideProto.class, Builder.class);
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
      return new UserGuideProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != UserGuideProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.pageNum_ != UserGuideProtos.PageNum.UNKNOWN_PAGE_NUM.getNumber())
        param1CodedOutputStream.writeEnum(2, this.pageNum_); 
      if (this.featureType_ != UserGuideProtos.FeatureType.UNKNOWN_FEATURE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.featureType_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserGuideProtos.UserGuideProtoOrBuilder {
      private int event_ = 0;
      
      private int featureType_ = 0;
      
      private int pageNum_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        UserGuideProtos.UserGuideProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public UserGuideProtos.UserGuideProto build() {
        UserGuideProtos.UserGuideProto userGuideProto = buildPartial();
        if (userGuideProto.isInitialized())
          return userGuideProto; 
        throw newUninitializedMessageException(userGuideProto);
      }
      
      public UserGuideProtos.UserGuideProto buildPartial() {
        UserGuideProtos.UserGuideProto userGuideProto = new UserGuideProtos.UserGuideProto(this);
        UserGuideProtos.UserGuideProto.access$602(userGuideProto, this.event_);
        UserGuideProtos.UserGuideProto.access$702(userGuideProto, this.pageNum_);
        UserGuideProtos.UserGuideProto.access$802(userGuideProto, this.featureType_);
        onBuilt();
        return userGuideProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.pageNum_ = 0;
        this.featureType_ = 0;
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeatureType() {
        this.featureType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPageNum() {
        this.pageNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public UserGuideProtos.UserGuideProto getDefaultInstanceForType() {
        return UserGuideProtos.UserGuideProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
      }
      
      public UserGuideProtos.Event getEvent() {
        UserGuideProtos.Event event2 = UserGuideProtos.Event.valueOf(this.event_);
        UserGuideProtos.Event event1 = event2;
        if (event2 == null)
          event1 = UserGuideProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public UserGuideProtos.FeatureType getFeatureType() {
        UserGuideProtos.FeatureType featureType2 = UserGuideProtos.FeatureType.valueOf(this.featureType_);
        UserGuideProtos.FeatureType featureType1 = featureType2;
        if (featureType2 == null)
          featureType1 = UserGuideProtos.FeatureType.UNRECOGNIZED; 
        return featureType1;
      }
      
      public int getFeatureTypeValue() {
        return this.featureType_;
      }
      
      public UserGuideProtos.PageNum getPageNum() {
        UserGuideProtos.PageNum pageNum2 = UserGuideProtos.PageNum.valueOf(this.pageNum_);
        UserGuideProtos.PageNum pageNum1 = pageNum2;
        if (pageNum2 == null)
          pageNum1 = UserGuideProtos.PageNum.UNRECOGNIZED; 
        return pageNum1;
      }
      
      public int getPageNumValue() {
        return this.pageNum_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(UserGuideProtos.UserGuideProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(UserGuideProtos.UserGuideProto param2UserGuideProto) {
        if (param2UserGuideProto == UserGuideProtos.UserGuideProto.getDefaultInstance())
          return this; 
        if (param2UserGuideProto.event_ != 0)
          setEventValue(param2UserGuideProto.getEventValue()); 
        if (param2UserGuideProto.pageNum_ != 0)
          setPageNumValue(param2UserGuideProto.getPageNumValue()); 
        if (param2UserGuideProto.featureType_ != 0)
          setFeatureTypeValue(param2UserGuideProto.getFeatureTypeValue()); 
        mergeUnknownFields(param2UserGuideProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          UserGuideProtos.UserGuideProto userGuideProto = (UserGuideProtos.UserGuideProto)UserGuideProtos.UserGuideProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          UserGuideProtos.UserGuideProto userGuideProto = (UserGuideProtos.UserGuideProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((UserGuideProtos.UserGuideProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof UserGuideProtos.UserGuideProto)
          return mergeFrom((UserGuideProtos.UserGuideProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setEvent(UserGuideProtos.Event param2Event) {
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
      
      public Builder setFeatureType(UserGuideProtos.FeatureType param2FeatureType) {
        if (param2FeatureType != null) {
          this.featureType_ = param2FeatureType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeatureTypeValue(int param2Int) {
        this.featureType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setPageNum(UserGuideProtos.PageNum param2PageNum) {
        if (param2PageNum != null) {
          this.pageNum_ = param2PageNum.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPageNumValue(int param2Int) {
        this.pageNum_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<UserGuideProto> {
    public UserGuideProtos.UserGuideProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new UserGuideProtos.UserGuideProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<UserGuideProto.Builder> implements UserGuideProtoOrBuilder {
    private int event_ = 0;
    
    private int featureType_ = 0;
    
    private int pageNum_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      UserGuideProtos.UserGuideProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public UserGuideProtos.UserGuideProto build() {
      UserGuideProtos.UserGuideProto userGuideProto = buildPartial();
      if (userGuideProto.isInitialized())
        return userGuideProto; 
      throw newUninitializedMessageException(userGuideProto);
    }
    
    public UserGuideProtos.UserGuideProto buildPartial() {
      UserGuideProtos.UserGuideProto userGuideProto = new UserGuideProtos.UserGuideProto(this);
      UserGuideProtos.UserGuideProto.access$602(userGuideProto, this.event_);
      UserGuideProtos.UserGuideProto.access$702(userGuideProto, this.pageNum_);
      UserGuideProtos.UserGuideProto.access$802(userGuideProto, this.featureType_);
      onBuilt();
      return userGuideProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.pageNum_ = 0;
      this.featureType_ = 0;
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeatureType() {
      this.featureType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPageNum() {
      this.pageNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public UserGuideProtos.UserGuideProto getDefaultInstanceForType() {
      return UserGuideProtos.UserGuideProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
    }
    
    public UserGuideProtos.Event getEvent() {
      UserGuideProtos.Event event2 = UserGuideProtos.Event.valueOf(this.event_);
      UserGuideProtos.Event event1 = event2;
      if (event2 == null)
        event1 = UserGuideProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public UserGuideProtos.FeatureType getFeatureType() {
      UserGuideProtos.FeatureType featureType2 = UserGuideProtos.FeatureType.valueOf(this.featureType_);
      UserGuideProtos.FeatureType featureType1 = featureType2;
      if (featureType2 == null)
        featureType1 = UserGuideProtos.FeatureType.UNRECOGNIZED; 
      return featureType1;
    }
    
    public int getFeatureTypeValue() {
      return this.featureType_;
    }
    
    public UserGuideProtos.PageNum getPageNum() {
      UserGuideProtos.PageNum pageNum2 = UserGuideProtos.PageNum.valueOf(this.pageNum_);
      UserGuideProtos.PageNum pageNum1 = pageNum2;
      if (pageNum2 == null)
        pageNum1 = UserGuideProtos.PageNum.UNRECOGNIZED; 
      return pageNum1;
    }
    
    public int getPageNumValue() {
      return this.pageNum_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(UserGuideProtos.UserGuideProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(UserGuideProtos.UserGuideProto param1UserGuideProto) {
      if (param1UserGuideProto == UserGuideProtos.UserGuideProto.getDefaultInstance())
        return this; 
      if (param1UserGuideProto.event_ != 0)
        setEventValue(param1UserGuideProto.getEventValue()); 
      if (param1UserGuideProto.pageNum_ != 0)
        setPageNumValue(param1UserGuideProto.getPageNumValue()); 
      if (param1UserGuideProto.featureType_ != 0)
        setFeatureTypeValue(param1UserGuideProto.getFeatureTypeValue()); 
      mergeUnknownFields(param1UserGuideProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        UserGuideProtos.UserGuideProto userGuideProto = (UserGuideProtos.UserGuideProto)UserGuideProtos.UserGuideProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        UserGuideProtos.UserGuideProto userGuideProto = (UserGuideProtos.UserGuideProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((UserGuideProtos.UserGuideProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof UserGuideProtos.UserGuideProto)
        return mergeFrom((UserGuideProtos.UserGuideProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setEvent(UserGuideProtos.Event param1Event) {
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
    
    public Builder setFeatureType(UserGuideProtos.FeatureType param1FeatureType) {
      if (param1FeatureType != null) {
        this.featureType_ = param1FeatureType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeatureTypeValue(int param1Int) {
      this.featureType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setPageNum(UserGuideProtos.PageNum param1PageNum) {
      if (param1PageNum != null) {
        this.pageNum_ = param1PageNum.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPageNumValue(int param1Int) {
      this.pageNum_ = param1Int;
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
  
  public static interface UserGuideProtoOrBuilder extends MessageOrBuilder {
    UserGuideProtos.Event getEvent();
    
    int getEventValue();
    
    UserGuideProtos.FeatureType getFeatureType();
    
    int getFeatureTypeValue();
    
    UserGuideProtos.PageNum getPageNum();
    
    int getPageNumValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\clien\\userguide\UserGuideProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
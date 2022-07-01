package com.blued.das.client.vote;

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

public final class VoteProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\020VoteProtos.proto\022\031com.blued.das.client.vote\"×\001\n\tVoteProto\022/\n\005event\030\001 \001(\0162 .com.blued.das.client.vote.Event\0226\n\tfeed_type\030\002 \001(\0162#.com.blued.das.client.vote.FeedType\022<\n\fphoto_option\030\003 \001(\0162&.com.blued.das.client.vote.PhotoOption\022\022\n\ntarget_uid\030\004 \001(\t\022\017\n\007feed_id\030\005 \001(\t*þ\002\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\022\n\016VOTE_BTN_CLICK\020\001\022\027\n\023VOTE_EDIT_PAGE_SHOW\020\002\022\037\n\033VOTE_EDIT_PAGE_UPLOAD_CLICK\020\003\022%\n!VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK\020\004\022 \n\034VOTE_EDIT_PAGE_BIG_BTN_CLICK\020\005\022\"\n\036VOTE_EDIT_PAGE_SMALL_BTN_CLICK\020\006\022!\n\035VOTE_EDIT_PAGE_TURN_BTN_CLICK\020\007\022#\n\037VOTE_EDIT_PAGE_CHANGE_BTN_CLICK\020\b\022\032\n\026VOTE_PUBLISH_BTN_CLICK\020\t\022 \n\034VOTE_FEED_CHOOSE_PHOTO_CLICK\020\n\022!\n\035VOTE_FEED_ENLARGE_PHOTO_CLICK\020\013*7\n\bFeedType\022\025\n\021UNKNOWN_FEED_TYPE\020\000\022\n\n\006COMMON\020\001\022\b\n\004VOTE\020\002*A\n\013PhotoOption\022\030\n\024UNKNOWN_PHOTO_OPTION\020\000\022\013\n\007PHOTO_A\020\001\022\013\n\007PHOTO_B\020\002B\007¢\002\004VOTEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_vote_VoteProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_vote_VoteProto_descriptor, new String[] { "Event", "FeedType", "PhotoOption", "TargetUid", "FeedId" });
  
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
    VOTE_BTN_CLICK(1),
    VOTE_EDIT_PAGE_BIG_BTN_CLICK(1),
    VOTE_EDIT_PAGE_CHANGE_BTN_CLICK(1),
    VOTE_EDIT_PAGE_SHOW(2),
    VOTE_EDIT_PAGE_SMALL_BTN_CLICK(2),
    VOTE_EDIT_PAGE_TURN_BTN_CLICK(2),
    VOTE_EDIT_PAGE_UPLOAD_CLICK(3),
    VOTE_FEED_CHOOSE_PHOTO_CLICK(3),
    VOTE_FEED_ENLARGE_PHOTO_CLICK(3),
    VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK(4),
    VOTE_PUBLISH_BTN_CLICK(4);
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    public static final int VOTE_BTN_CLICK_VALUE = 1;
    
    public static final int VOTE_EDIT_PAGE_BIG_BTN_CLICK_VALUE = 5;
    
    public static final int VOTE_EDIT_PAGE_CHANGE_BTN_CLICK_VALUE = 8;
    
    public static final int VOTE_EDIT_PAGE_SHOW_VALUE = 2;
    
    public static final int VOTE_EDIT_PAGE_SMALL_BTN_CLICK_VALUE = 6;
    
    public static final int VOTE_EDIT_PAGE_TURN_BTN_CLICK_VALUE = 7;
    
    public static final int VOTE_EDIT_PAGE_UPLOAD_CLICK_VALUE = 3;
    
    public static final int VOTE_FEED_CHOOSE_PHOTO_CLICK_VALUE = 10;
    
    public static final int VOTE_FEED_ENLARGE_PHOTO_CLICK_VALUE = 11;
    
    public static final int VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK_VALUE = 4;
    
    public static final int VOTE_PUBLISH_BTN_CLICK_VALUE = 9;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      VOTE_EDIT_PAGE_CHANGE_BTN_CLICK = new Event("VOTE_EDIT_PAGE_CHANGE_BTN_CLICK", 8, 8);
      VOTE_PUBLISH_BTN_CLICK = new Event("VOTE_PUBLISH_BTN_CLICK", 9, 9);
      VOTE_FEED_CHOOSE_PHOTO_CLICK = new Event("VOTE_FEED_CHOOSE_PHOTO_CLICK", 10, 10);
      VOTE_FEED_ENLARGE_PHOTO_CLICK = new Event("VOTE_FEED_ENLARGE_PHOTO_CLICK", 11, 11);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 12, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, VOTE_BTN_CLICK, VOTE_EDIT_PAGE_SHOW, VOTE_EDIT_PAGE_UPLOAD_CLICK, VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK, VOTE_EDIT_PAGE_BIG_BTN_CLICK, VOTE_EDIT_PAGE_SMALL_BTN_CLICK, VOTE_EDIT_PAGE_TURN_BTN_CLICK, VOTE_EDIT_PAGE_CHANGE_BTN_CLICK, VOTE_PUBLISH_BTN_CLICK, 
          VOTE_FEED_CHOOSE_PHOTO_CLICK, VOTE_FEED_ENLARGE_PHOTO_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public VoteProtos.Event findValueByNumber(int param2Int) {
            return VoteProtos.Event.forNumber(param2Int);
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
        case 11:
          return VOTE_FEED_ENLARGE_PHOTO_CLICK;
        case 10:
          return VOTE_FEED_CHOOSE_PHOTO_CLICK;
        case 9:
          return VOTE_PUBLISH_BTN_CLICK;
        case 8:
          return VOTE_EDIT_PAGE_CHANGE_BTN_CLICK;
        case 7:
          return VOTE_EDIT_PAGE_TURN_BTN_CLICK;
        case 6:
          return VOTE_EDIT_PAGE_SMALL_BTN_CLICK;
        case 5:
          return VOTE_EDIT_PAGE_BIG_BTN_CLICK;
        case 4:
          return VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK;
        case 3:
          return VOTE_EDIT_PAGE_UPLOAD_CLICK;
        case 2:
          return VOTE_EDIT_PAGE_SHOW;
        case 1:
          return VOTE_BTN_CLICK;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VoteProtos.getDescriptor().getEnumTypes().get(0);
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
    public VoteProtos.Event findValueByNumber(int param1Int) {
      return VoteProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum FeedType implements ProtocolMessageEnum {
    UNKNOWN_FEED_TYPE(0),
    UNRECOGNIZED(0),
    VOTE(0),
    COMMON(4);
    
    public static final int COMMON_VALUE = 1;
    
    public static final int UNKNOWN_FEED_TYPE_VALUE = 0;
    
    private static final FeedType[] VALUES;
    
    public static final int VOTE_VALUE = 2;
    
    private static final Internal.EnumLiteMap<FeedType> internalValueMap;
    
    private final int value;
    
    static {
      UNRECOGNIZED = new FeedType("UNRECOGNIZED", 3, -1);
      $VALUES = new FeedType[] { UNKNOWN_FEED_TYPE, COMMON, VOTE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedType>() {
          public VoteProtos.FeedType findValueByNumber(int param2Int) {
            return VoteProtos.FeedType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : VOTE) : COMMON) : UNKNOWN_FEED_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VoteProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<FeedType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeedType> {
    public VoteProtos.FeedType findValueByNumber(int param1Int) {
      return VoteProtos.FeedType.forNumber(param1Int);
    }
  }
  
  public enum PhotoOption implements ProtocolMessageEnum {
    PHOTO_A(0),
    PHOTO_B(0),
    UNKNOWN_PHOTO_OPTION(0),
    UNRECOGNIZED(0);
    
    public static final int PHOTO_A_VALUE = 1;
    
    public static final int PHOTO_B_VALUE = 2;
    
    public static final int UNKNOWN_PHOTO_OPTION_VALUE = 0;
    
    private static final PhotoOption[] VALUES;
    
    private static final Internal.EnumLiteMap<PhotoOption> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new PhotoOption[] { UNKNOWN_PHOTO_OPTION, PHOTO_A, PHOTO_B, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PhotoOption>() {
          public VoteProtos.PhotoOption findValueByNumber(int param2Int) {
            return VoteProtos.PhotoOption.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PhotoOption(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PhotoOption forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : PHOTO_B) : PHOTO_A) : UNKNOWN_PHOTO_OPTION;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VoteProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<PhotoOption> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PhotoOption> {
    public VoteProtos.PhotoOption findValueByNumber(int param1Int) {
      return VoteProtos.PhotoOption.forNumber(param1Int);
    }
  }
  
  public static final class VoteProto extends GeneratedMessageV3 implements VoteProtoOrBuilder {
    private static final VoteProto DEFAULT_INSTANCE = new VoteProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FEED_ID_FIELD_NUMBER = 5;
    
    public static final int FEED_TYPE_FIELD_NUMBER = 2;
    
    private static final Parser<VoteProto> PARSER = (Parser<VoteProto>)new AbstractParser<VoteProto>() {
        public VoteProtos.VoteProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new VoteProtos.VoteProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PHOTO_OPTION_FIELD_NUMBER = 3;
    
    public static final int TARGET_UID_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private int event_;
    
    private volatile Object feedId_;
    
    private int feedType_;
    
    private byte memoizedIsInitialized = -1;
    
    private int photoOption_;
    
    private volatile Object targetUid_;
    
    private VoteProto() {
      this.event_ = 0;
      this.feedType_ = 0;
      this.photoOption_ = 0;
      this.targetUid_ = "";
      this.feedId_ = "";
    }
    
    private VoteProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                      this.feedId_ = param1CodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.photoOption_ = param1CodedInputStream.readEnum();
                  continue;
                } 
                this.feedType_ = param1CodedInputStream.readEnum();
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
    
    private VoteProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static VoteProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(VoteProto param1VoteProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1VoteProto);
    }
    
    public static VoteProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (VoteProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static VoteProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VoteProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static VoteProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (VoteProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static VoteProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VoteProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static VoteProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (VoteProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static VoteProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VoteProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static VoteProto parseFrom(InputStream param1InputStream) throws IOException {
      return (VoteProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static VoteProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VoteProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static VoteProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (VoteProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static VoteProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VoteProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static VoteProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (VoteProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static VoteProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VoteProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<VoteProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof VoteProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((VoteProto)param1Object).event_) ? false : ((this.feedType_ != ((VoteProto)param1Object).feedType_) ? false : ((this.photoOption_ != ((VoteProto)param1Object).photoOption_) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : (!getFeedId().equals(param1Object.getFeedId()) ? false : (!!this.unknownFields.equals(((VoteProto)param1Object).unknownFields))))));
    }
    
    public VoteProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public VoteProtos.Event getEvent() {
      VoteProtos.Event event2 = VoteProtos.Event.valueOf(this.event_);
      VoteProtos.Event event1 = event2;
      if (event2 == null)
        event1 = VoteProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getFeedId() {
      Object object = this.feedId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.feedId_ = object;
      return (String)object;
    }
    
    public ByteString getFeedIdBytes() {
      Object object = this.feedId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.feedId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VoteProtos.FeedType getFeedType() {
      VoteProtos.FeedType feedType2 = VoteProtos.FeedType.valueOf(this.feedType_);
      VoteProtos.FeedType feedType1 = feedType2;
      if (feedType2 == null)
        feedType1 = VoteProtos.FeedType.UNRECOGNIZED; 
      return feedType1;
    }
    
    public int getFeedTypeValue() {
      return this.feedType_;
    }
    
    public Parser<VoteProto> getParserForType() {
      return PARSER;
    }
    
    public VoteProtos.PhotoOption getPhotoOption() {
      VoteProtos.PhotoOption photoOption2 = VoteProtos.PhotoOption.valueOf(this.photoOption_);
      VoteProtos.PhotoOption photoOption1 = photoOption2;
      if (photoOption2 == null)
        photoOption1 = VoteProtos.PhotoOption.UNRECOGNIZED; 
      return photoOption1;
    }
    
    public int getPhotoOptionValue() {
      return this.photoOption_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != VoteProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.feedType_ != VoteProtos.FeedType.UNKNOWN_FEED_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.feedType_); 
      j = i;
      if (this.photoOption_ != VoteProtos.PhotoOption.UNKNOWN_PHOTO_OPTION.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.photoOption_); 
      i = j;
      if (!getTargetUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.targetUid_); 
      j = i;
      if (!getFeedIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.feedId_); 
      i = j + this.unknownFields.getSerializedSize();
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
      int i = (((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.feedType_) * 37 + 3) * 53 + this.photoOption_) * 37 + 4) * 53 + getTargetUid().hashCode()) * 37 + 5) * 53 + getFeedId().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VoteProto.class, Builder.class);
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
      return new VoteProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != VoteProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.feedType_ != VoteProtos.FeedType.UNKNOWN_FEED_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.feedType_); 
      if (this.photoOption_ != VoteProtos.PhotoOption.UNKNOWN_PHOTO_OPTION.getNumber())
        param1CodedOutputStream.writeEnum(3, this.photoOption_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.targetUid_); 
      if (!getFeedIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.feedId_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VoteProtos.VoteProtoOrBuilder {
      private int event_ = 0;
      
      private Object feedId_ = "";
      
      private int feedType_ = 0;
      
      private int photoOption_ = 0;
      
      private Object targetUid_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        VoteProtos.VoteProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public VoteProtos.VoteProto build() {
        VoteProtos.VoteProto voteProto = buildPartial();
        if (voteProto.isInitialized())
          return voteProto; 
        throw newUninitializedMessageException(voteProto);
      }
      
      public VoteProtos.VoteProto buildPartial() {
        VoteProtos.VoteProto voteProto = new VoteProtos.VoteProto(this);
        VoteProtos.VoteProto.access$602(voteProto, this.event_);
        VoteProtos.VoteProto.access$702(voteProto, this.feedType_);
        VoteProtos.VoteProto.access$802(voteProto, this.photoOption_);
        VoteProtos.VoteProto.access$902(voteProto, this.targetUid_);
        VoteProtos.VoteProto.access$1002(voteProto, this.feedId_);
        onBuilt();
        return voteProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.feedType_ = 0;
        this.photoOption_ = 0;
        this.targetUid_ = "";
        this.feedId_ = "";
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedId() {
        this.feedId_ = VoteProtos.VoteProto.getDefaultInstance().getFeedId();
        onChanged();
        return this;
      }
      
      public Builder clearFeedType() {
        this.feedType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPhotoOption() {
        this.photoOption_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = VoteProtos.VoteProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public VoteProtos.VoteProto getDefaultInstanceForType() {
        return VoteProtos.VoteProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
      }
      
      public VoteProtos.Event getEvent() {
        VoteProtos.Event event2 = VoteProtos.Event.valueOf(this.event_);
        VoteProtos.Event event1 = event2;
        if (event2 == null)
          event1 = VoteProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public String getFeedId() {
        Object object = this.feedId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.feedId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getFeedIdBytes() {
        Object object = this.feedId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.feedId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public VoteProtos.FeedType getFeedType() {
        VoteProtos.FeedType feedType2 = VoteProtos.FeedType.valueOf(this.feedType_);
        VoteProtos.FeedType feedType1 = feedType2;
        if (feedType2 == null)
          feedType1 = VoteProtos.FeedType.UNRECOGNIZED; 
        return feedType1;
      }
      
      public int getFeedTypeValue() {
        return this.feedType_;
      }
      
      public VoteProtos.PhotoOption getPhotoOption() {
        VoteProtos.PhotoOption photoOption2 = VoteProtos.PhotoOption.valueOf(this.photoOption_);
        VoteProtos.PhotoOption photoOption1 = photoOption2;
        if (photoOption2 == null)
          photoOption1 = VoteProtos.PhotoOption.UNRECOGNIZED; 
        return photoOption1;
      }
      
      public int getPhotoOptionValue() {
        return this.photoOption_;
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
        return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VoteProtos.VoteProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(VoteProtos.VoteProto param2VoteProto) {
        if (param2VoteProto == VoteProtos.VoteProto.getDefaultInstance())
          return this; 
        if (param2VoteProto.event_ != 0)
          setEventValue(param2VoteProto.getEventValue()); 
        if (param2VoteProto.feedType_ != 0)
          setFeedTypeValue(param2VoteProto.getFeedTypeValue()); 
        if (param2VoteProto.photoOption_ != 0)
          setPhotoOptionValue(param2VoteProto.getPhotoOptionValue()); 
        if (!param2VoteProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2VoteProto.targetUid_;
          onChanged();
        } 
        if (!param2VoteProto.getFeedId().isEmpty()) {
          this.feedId_ = param2VoteProto.feedId_;
          onChanged();
        } 
        mergeUnknownFields(param2VoteProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          VoteProtos.VoteProto voteProto = (VoteProtos.VoteProto)VoteProtos.VoteProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          VoteProtos.VoteProto voteProto = (VoteProtos.VoteProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((VoteProtos.VoteProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof VoteProtos.VoteProto)
          return mergeFrom((VoteProtos.VoteProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setEvent(VoteProtos.Event param2Event) {
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
      
      public Builder setFeedId(String param2String) {
        if (param2String != null) {
          this.feedId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VoteProtos.VoteProto.checkByteStringIsUtf8(param2ByteString);
          this.feedId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedType(VoteProtos.FeedType param2FeedType) {
        if (param2FeedType != null) {
          this.feedType_ = param2FeedType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedTypeValue(int param2Int) {
        this.feedType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setPhotoOption(VoteProtos.PhotoOption param2PhotoOption) {
        if (param2PhotoOption != null) {
          this.photoOption_ = param2PhotoOption.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPhotoOptionValue(int param2Int) {
        this.photoOption_ = param2Int;
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
          VoteProtos.VoteProto.checkByteStringIsUtf8(param2ByteString);
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
  
  static final class null extends AbstractParser<VoteProto> {
    public VoteProtos.VoteProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new VoteProtos.VoteProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<VoteProto.Builder> implements VoteProtoOrBuilder {
    private int event_ = 0;
    
    private Object feedId_ = "";
    
    private int feedType_ = 0;
    
    private int photoOption_ = 0;
    
    private Object targetUid_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      VoteProtos.VoteProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public VoteProtos.VoteProto build() {
      VoteProtos.VoteProto voteProto = buildPartial();
      if (voteProto.isInitialized())
        return voteProto; 
      throw newUninitializedMessageException(voteProto);
    }
    
    public VoteProtos.VoteProto buildPartial() {
      VoteProtos.VoteProto voteProto = new VoteProtos.VoteProto(this);
      VoteProtos.VoteProto.access$602(voteProto, this.event_);
      VoteProtos.VoteProto.access$702(voteProto, this.feedType_);
      VoteProtos.VoteProto.access$802(voteProto, this.photoOption_);
      VoteProtos.VoteProto.access$902(voteProto, this.targetUid_);
      VoteProtos.VoteProto.access$1002(voteProto, this.feedId_);
      onBuilt();
      return voteProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.feedType_ = 0;
      this.photoOption_ = 0;
      this.targetUid_ = "";
      this.feedId_ = "";
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedId() {
      this.feedId_ = VoteProtos.VoteProto.getDefaultInstance().getFeedId();
      onChanged();
      return this;
    }
    
    public Builder clearFeedType() {
      this.feedType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPhotoOption() {
      this.photoOption_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = VoteProtos.VoteProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public VoteProtos.VoteProto getDefaultInstanceForType() {
      return VoteProtos.VoteProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
    }
    
    public VoteProtos.Event getEvent() {
      VoteProtos.Event event2 = VoteProtos.Event.valueOf(this.event_);
      VoteProtos.Event event1 = event2;
      if (event2 == null)
        event1 = VoteProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getFeedId() {
      Object object = this.feedId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.feedId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFeedIdBytes() {
      Object object = this.feedId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.feedId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VoteProtos.FeedType getFeedType() {
      VoteProtos.FeedType feedType2 = VoteProtos.FeedType.valueOf(this.feedType_);
      VoteProtos.FeedType feedType1 = feedType2;
      if (feedType2 == null)
        feedType1 = VoteProtos.FeedType.UNRECOGNIZED; 
      return feedType1;
    }
    
    public int getFeedTypeValue() {
      return this.feedType_;
    }
    
    public VoteProtos.PhotoOption getPhotoOption() {
      VoteProtos.PhotoOption photoOption2 = VoteProtos.PhotoOption.valueOf(this.photoOption_);
      VoteProtos.PhotoOption photoOption1 = photoOption2;
      if (photoOption2 == null)
        photoOption1 = VoteProtos.PhotoOption.UNRECOGNIZED; 
      return photoOption1;
    }
    
    public int getPhotoOptionValue() {
      return this.photoOption_;
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
      return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VoteProtos.VoteProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(VoteProtos.VoteProto param1VoteProto) {
      if (param1VoteProto == VoteProtos.VoteProto.getDefaultInstance())
        return this; 
      if (param1VoteProto.event_ != 0)
        setEventValue(param1VoteProto.getEventValue()); 
      if (param1VoteProto.feedType_ != 0)
        setFeedTypeValue(param1VoteProto.getFeedTypeValue()); 
      if (param1VoteProto.photoOption_ != 0)
        setPhotoOptionValue(param1VoteProto.getPhotoOptionValue()); 
      if (!param1VoteProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1VoteProto.targetUid_;
        onChanged();
      } 
      if (!param1VoteProto.getFeedId().isEmpty()) {
        this.feedId_ = param1VoteProto.feedId_;
        onChanged();
      } 
      mergeUnknownFields(param1VoteProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        VoteProtos.VoteProto voteProto = (VoteProtos.VoteProto)VoteProtos.VoteProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        VoteProtos.VoteProto voteProto = (VoteProtos.VoteProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((VoteProtos.VoteProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof VoteProtos.VoteProto)
        return mergeFrom((VoteProtos.VoteProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setEvent(VoteProtos.Event param1Event) {
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
    
    public Builder setFeedId(String param1String) {
      if (param1String != null) {
        this.feedId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VoteProtos.VoteProto.checkByteStringIsUtf8(param1ByteString);
        this.feedId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedType(VoteProtos.FeedType param1FeedType) {
      if (param1FeedType != null) {
        this.feedType_ = param1FeedType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedTypeValue(int param1Int) {
      this.feedType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setPhotoOption(VoteProtos.PhotoOption param1PhotoOption) {
      if (param1PhotoOption != null) {
        this.photoOption_ = param1PhotoOption.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPhotoOptionValue(int param1Int) {
      this.photoOption_ = param1Int;
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
        VoteProtos.VoteProto.checkByteStringIsUtf8(param1ByteString);
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
  
  public static interface VoteProtoOrBuilder extends MessageOrBuilder {
    VoteProtos.Event getEvent();
    
    int getEventValue();
    
    String getFeedId();
    
    ByteString getFeedIdBytes();
    
    VoteProtos.FeedType getFeedType();
    
    int getFeedTypeValue();
    
    VoteProtos.PhotoOption getPhotoOption();
    
    int getPhotoOptionValue();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\vote\VoteProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
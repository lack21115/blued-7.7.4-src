package com.blued.das.client.chatroom;

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

public final class ChatRoomProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\024ChatRoomProtos.proto\022\035com.blued.das.client.chatroom\"\005\n\rChatRoomProto\0223\n\005event\030\001 \001(\0162$.com.blued.das.client.chatroom.Event\022\017\n\007room_id\030\002 \001(\t\022\021\n\troom_name\030\003 \001(\t\022\020\n\broom_uid\030\004 \001(\t\022\021\n\troom_type\030\005 \001(\t\022\016\n\006source\030\006 \001(\t\022\016\n\006tab_id\030\007 \001(\t\022:\n\tuser_type\030\b \001(\0162'.com.blued.das.client.chatroom.UserType\022\021\n\tbanner_id\030\t \001(\t\022\022\n\ntarget_uid\030\n \001(\t\022\021\n\tis_follow\030\013 \001(\b\022\016\n\006sku_id\030\f \001(\t\022B\n\rshare_channel\030\r \001(\0162+.com.blued.das.client.chatroom.ShareChannel\022:\n\twarn_type\030\016 \001(\0162'.com.blued.das.client.chatroom.WarnType\022\013\n\003num\030\017 \001(\005\022\020\n\bgoods_id\030\020 \001(\t\022\r\n\005count\030\021 \001(\005\022\017\n\007content\030\022 \001(\t\022\n\n\002id\030\023 \001(\t\0221\n\004from\030\024 \001(\0162#.com.blued.das.client.chatroom.From\022\020\n\bposition\030\025 \001(\005\022\017\n\007tab_num\030\026 \001(\005\022\020\n\bpage_num\030\027 \001(\005\022\020\n\bmusic_id\030\030 \001(\t\022\020\n\bduration\030\031 \001(\005\022\r\n\005range\030\032 \001(\t*«\035\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022 \n\034CHAT_ROOM_PROFILE_ENTER_SHOW\020\001\022!\n\035CHAT_ROOM_PROFILE_ENTER_CLICK\020\002\022\036\n\032CHAT_ROOM_MINE_REPORT_SHOW\020\003\022\037\n\033CHAT_ROOM_MINE_REPORT_CLICK\020\004\022\035\n\031CHAT_ROOM_MINE_ENTER_SHOW\020\005\022\031\n\025CHAT_ROOM_ENTER_CLICK\020\006\022 \n\034CHAT_ROOM_HOME_PAGE_TAB_SHOW\020\007\022 \n\034CHAT_ROOM_TAB_PAGE_ROOM_DRAW\020\b\022!\n\035CHAT_ROOM_TAB_PAGE_ROOM_CLICK\020\t\022\031\n\025CHAT_ROOM_CREATE_SHOW\020\n\022\032\n\026CHAT_ROOM_CREATE_CLICK\020\013\022\"\n\036CHAT_ROOM_CREATE_CONFIRM_CLICK\020\f\022 \n\034CHAT_ROOM_NAME_INVALITE_SHOW\020\r\022 \n\034CHAT_ROOM_APPROVE_GUIDE_SHOW\020\032\022!\n\035CHAT_ROOM_APPROVE_GUIDE_CLICK\020\033\022\031\n\025CHAT_ROOM_BANNER_SHOW\020\034\022\032\n\026CHAT_ROOM_BANNER_CLICK\020\035\022\032\n\026CHAT_ROOM_INVITE_CLICK\020\036\022\034\n\030CHAT_ROOM_KICK_OUT_CLICK\020\037\022$\n CHAT_ROOM_KICK_OUT_CONFIRM_CLICK\020 \022\030\n\024CHAT_ROOM_MUTE_CLICK\020!\022\035\n\031CHAT_ROOM_INVITE_POP_SHOW\020\"\022\032\n\026CHAT_ROOM_REFUSE_CLICK\020#\022\032\n\026CHAT_ROOM_ACCEPT_CLICK\020$\022\026\n\022CHAT_ROOM_OUT_MIKE\020%\022\037\n\033CHAT_ROOM_SET_MANAGER_CLICK\020&\022\036\n\032CHAT_ROOM_MANAGER_MAX_SHOW\020'\022\034\n\030CHAT_ROOM_EXIT_BTN_CLICK\020(\022\037\n\033CHAT_ROOM_REPORT_ROOM_CLICK\020)\022\032\n\026CHAT_ROOM_FOLLOW_CLICK\020*\022\026\n\022CHAT_ROOM_UNFOLLOW\020,\022\037\n\033CHAT_ROOM_FOLLOW_GUIDE_SHOW\020-\022'\n#CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK\020.\022\034\n\030CHAT_ROOM_SEND_GIFT_SHOW\020/\022\035\n\031CHAT_ROOM_SEND_GIFT_CLICK\0200\022\034\n\030CHAT_ROOM_RECHARGE_CLICK\0201\022\031\n\025CHAT_ROOM_SHARE_CLICK\0203\022!\n\035CHAT_ROOM_SHARE_CHANNEL_CLICK\0204\022\030\n\024CHAT_ROOM_MIKE_CLICK\0205\022 \n\034CHAT_ROOM_PROFILE_MIKE_CLICK\0206\022 \n\034CHAT_ROOM_MIKE_CONFIRM_CLICK\0207\022\037\n\033CHAT_ROOM_MIKE_SUCCESS_SHOW\0208\022\036\n\032CHAT_ROOM_MIKE_REFUSE_SHOW\0209\022\033\n\027CHAT_ROOM_MIKE_POP_SHOW\020:\022#\n\037CHAT_ROOM_MIKE_POP_REFUSE_CLICK\020;\022#\n\037CHAT_ROOM_MIKE_POP_ACCEPT_CLICK\020<\022#\n\037CHAT_ROOM_MIKE_POP_AUTO_SUCCESS\020=\022$\n CHAT_ROOM_MIKE_USER_REFUSE_CLICK\020>\022$\n CHAT_ROOM_MIKE_USER_ACCEPT_CLICK\020?\022\034\n\030CHAT_ROOM_SEND_MSG_CLICK\020@\022\036\n\032CHAT_ROOM_PROFILE_GO_CLICK\020A\022'\n#CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK\020B\022\036\n\032CHAT_ROOM_PROFILE_AT_CLICK\020C\022\037\n\033CHAT_ROOM_PROFILE_MSG_CLICK\020D\022 \n\034CHAT_ROOM_PROFILE_GIFT_CLICK\020E\022\"\n\036CHAT_ROOM_PROFILE_REPORT_CLICK\020F\022!\n\035CHAT_ROOM_PROFILE_BLACK_CLICK\020G\022\030\n\024CHAT_ROOM_LIST_CLICK\020H\022 \n\034CHAT_ROOM_LIST_PAGE_GET_SHOW\020I\022!\n\035CHAT_ROOM_LIST_PAGE_SEND_SHOW\020J\022\033\n\027CHAT_ROOM_WARN_POP_SHOW\020K\022&\n\"CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW\020L\022'\n#CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW\020M\022\030\n\024CHAT_ROOM_LIKE_CLICK\020P\022\030\n\024CHAT_ROOM_GIFT_CLICK\020Q\022\033\n\027CHAT_ROOM_GIFT_POP_SHOW\020T\022!\n\035CHAT_ROOM_GIFT_POP_SEND_CLICK\020U\022\025\n\021NO_MONEY_POP_SHOW\020V\022\037\n\033NO_MONEY_POP_RECHARGE_CLICK\020W\022\037\n\033CHAT_ROOM_NAME_CHANGE_CLICK\020X\022\036\n\032CHAT_ROOM_PHONE_BIND_CLICK\020Y\022!\n\035CHAT_ROOM_ENTER_APPROVE_CLICK\020Z\022\032\n\026CHAT_ROOM_NOTICE_CLICK\020[\022\037\n\033CHAT_ROOM_NOTICE_SAVE_CLICK\020\\\022!\n\035CHAT_ROOM_NOTICE_CANCEL_CLICK\020]\022\033\n\027CHAT_ROOM_TOOLBOX_CLICK\020^\022!\n\035CHAT_ROOM_TOOLBOX_EMOJI_CLICK\020_\022\"\n\036CHAT_ROOM_PROFILE_FORBID_CLICK\020`\022)\n%CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK\020a\022!\n\035CHAT_ROOM_PROFILE_BLOCK_CLICK\020c\022\037\n\033CHAT_ROOM_FOLLOW_MORE_CLICK\020d\022\036\n\032CHAT_ROOM_FOLLOW_ROOM_SHOW\020e\022\037\n\033CHAT_ROOM_FOLLOW_ROOM_CLICK\020f\022\037\n\033CHAT_ROOM_EMOJI_ENTER_CLICK\020g\022)\n%CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK\020j\022\037\n\033CHAT_ROOM_USER_INVITE_CLICK\020k\022\034\n\030CHAT_ROOM_BG_ENTER_CLICK\020m\022\036\n\032CHAT_ROOM_BG_SOMEONE_CLICK\020n\022$\n CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW\020o\022%\n!CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK\020p\022&\n\"CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK\020q\022%\n!CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW\020r\022-\n)CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK\020s\022&\n\"CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK\020t\022'\n#CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK\020u\022&\n\"CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK\020v\022&\n\"CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK\020x\022$\n CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW\020y\022$\n CHAT_ROOM_MINIMIZED_WINDOW_CLICK\020z\022\035\n\031CHAT_ROOM_VOTE_ICON_CLICK\020{\022\037\n\033CHAT_ROOM_VOTE_LAUNCH_CLICK\020|\022\037\n\033CHAT_ROOM_VOTE_WINDOW_CLICK\020}\022\035\n\031CHAT_ROOM_VOTE_USER_CLICK\020~\022\031\n\025CHAT_ROOM_INSTRUCTION\020\022\035\n\030CHAT_ROOM_CP_MATCH_START\020\001\022\037\n\032CHAT_ROOM_CP_MATCH_SUCCEED\020\001\022*\n%CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK\020\001\022\035\n\030CHAT_ROOM_MUTE_BTN_CLICK\020\001\022\037\n\032CHAT_ROOM_UNMUTE_BTN_CLICK\020\001\022#\n\036CHAT_ROOM_CHANGE_MIC_BTN_CLICK\020\001\022\036\n\031CHAT_ROOM_PHONE_BIND_SHOW\020\001\022'\n\"CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK\020\001*]\n\bUserType\022\025\n\021UNKNOWN_USER_TYPE\020\000\022\017\n\013COMMON_USER\020\001\022\026\n\022APPLY_SUCCESS_USER\020\002\022\021\n\rAPPLYING_USER\020\003*\001\n\fShareChannel\022\031\n\025UNKNOWN_SHARE_CHANNEL\020\000\022\021\n\rSHARE_FORWARD\020\001\022\020\n\fSHARE_FRIEND\020\002\022\020\n\fSHARE_WECHAT\020\003\022\f\n\bSHARE_QQ\020\004\022\017\n\013SHARE_WEIBO\020\005\022\025\n\021SHARE_FRIEND_CLUB\020\006*Ò\001\n\bWarnType\022\025\n\021UNKNOWN_WARN_TYPE\020\000\022\f\n\bADS_WARN\020\001\022\022\n\016POLITICAL_WARN\020\002\022\r\n\tHINT_WARN\020\003\022\r\n\tDRUG_WARN\020\004\022\017\n\013SPEECH_WARN\020\005\022\020\n\fPRIVACY_WARN\020\006\022\025\n\021INVALID_LIVE_WARN\020\007\022\022\n\016CUSTOMIZE_WARN\020\b\022\022\n\016COPYRIGHT_WARN\020\t\022\r\n\tMUTE_WARN\020\n*P\n\004From\022\020\n\fUNKNOWN_FROM\020\000\022\024\n\020FOLLOW_ROOM_LIST\020\001\022 \n\034FOLLOW_ROOM_LIST_SECOND_PAGE\020\002B\013¢\002\bchatroomb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor, new String[] { 
        "Event", "RoomId", "RoomName", "RoomUid", "RoomType", "Source", "TabId", "UserType", "BannerId", "TargetUid", 
        "IsFollow", "SkuId", "ShareChannel", "WarnType", "Num", "GoodsId", "Count", "Content", "Id", "From", 
        "Position", "TabNum", "PageNum", "MusicId", "Duration", "Range" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class ChatRoomProto extends GeneratedMessageV3 implements ChatRoomProtoOrBuilder {
    public static final int BANNER_ID_FIELD_NUMBER = 9;
    
    public static final int CONTENT_FIELD_NUMBER = 18;
    
    public static final int COUNT_FIELD_NUMBER = 17;
    
    private static final ChatRoomProto DEFAULT_INSTANCE = new ChatRoomProto();
    
    public static final int DURATION_FIELD_NUMBER = 25;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FROM_FIELD_NUMBER = 20;
    
    public static final int GOODS_ID_FIELD_NUMBER = 16;
    
    public static final int ID_FIELD_NUMBER = 19;
    
    public static final int IS_FOLLOW_FIELD_NUMBER = 11;
    
    public static final int MUSIC_ID_FIELD_NUMBER = 24;
    
    public static final int NUM_FIELD_NUMBER = 15;
    
    public static final int PAGE_NUM_FIELD_NUMBER = 23;
    
    private static final Parser<ChatRoomProto> PARSER = (Parser<ChatRoomProto>)new AbstractParser<ChatRoomProto>() {
        public ChatRoomProtos.ChatRoomProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ChatRoomProtos.ChatRoomProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int POSITION_FIELD_NUMBER = 21;
    
    public static final int RANGE_FIELD_NUMBER = 26;
    
    public static final int ROOM_ID_FIELD_NUMBER = 2;
    
    public static final int ROOM_NAME_FIELD_NUMBER = 3;
    
    public static final int ROOM_TYPE_FIELD_NUMBER = 5;
    
    public static final int ROOM_UID_FIELD_NUMBER = 4;
    
    public static final int SHARE_CHANNEL_FIELD_NUMBER = 13;
    
    public static final int SKU_ID_FIELD_NUMBER = 12;
    
    public static final int SOURCE_FIELD_NUMBER = 6;
    
    public static final int TAB_ID_FIELD_NUMBER = 7;
    
    public static final int TAB_NUM_FIELD_NUMBER = 22;
    
    public static final int TARGET_UID_FIELD_NUMBER = 10;
    
    public static final int USER_TYPE_FIELD_NUMBER = 8;
    
    public static final int WARN_TYPE_FIELD_NUMBER = 14;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object bannerId_;
    
    private volatile Object content_;
    
    private int count_;
    
    private int duration_;
    
    private int event_;
    
    private int from_;
    
    private volatile Object goodsId_;
    
    private volatile Object id_;
    
    private boolean isFollow_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object musicId_;
    
    private int num_;
    
    private int pageNum_;
    
    private int position_;
    
    private volatile Object range_;
    
    private volatile Object roomId_;
    
    private volatile Object roomName_;
    
    private volatile Object roomType_;
    
    private volatile Object roomUid_;
    
    private int shareChannel_;
    
    private volatile Object skuId_;
    
    private volatile Object source_;
    
    private volatile Object tabId_;
    
    private int tabNum_;
    
    private volatile Object targetUid_;
    
    private int userType_;
    
    private int warnType_;
    
    private ChatRoomProto() {
      this.event_ = 0;
      this.roomId_ = "";
      this.roomName_ = "";
      this.roomUid_ = "";
      this.roomType_ = "";
      this.source_ = "";
      this.tabId_ = "";
      this.userType_ = 0;
      this.bannerId_ = "";
      this.targetUid_ = "";
      this.skuId_ = "";
      this.shareChannel_ = 0;
      this.warnType_ = 0;
      this.goodsId_ = "";
      this.content_ = "";
      this.id_ = "";
      this.from_ = 0;
      this.musicId_ = "";
      this.range_ = "";
    }
    
    private ChatRoomProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 210:
                this.range_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 200:
                this.duration_ = param1CodedInputStream.readInt32();
                continue;
              case 194:
                this.musicId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 184:
                this.pageNum_ = param1CodedInputStream.readInt32();
                continue;
              case 176:
                this.tabNum_ = param1CodedInputStream.readInt32();
                continue;
              case 168:
                this.position_ = param1CodedInputStream.readInt32();
                continue;
              case 160:
                this.from_ = param1CodedInputStream.readEnum();
                continue;
              case 154:
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 146:
                this.content_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 136:
                this.count_ = param1CodedInputStream.readInt32();
                continue;
              case 130:
                this.goodsId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 120:
                this.num_ = param1CodedInputStream.readInt32();
                continue;
              case 112:
                this.warnType_ = param1CodedInputStream.readEnum();
                continue;
              case 104:
                this.shareChannel_ = param1CodedInputStream.readEnum();
                continue;
              case 98:
                this.skuId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 88:
                this.isFollow_ = param1CodedInputStream.readBool();
                continue;
              case 82:
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 74:
                this.bannerId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 64:
                this.userType_ = param1CodedInputStream.readEnum();
                continue;
              case 58:
                this.tabId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 50:
                this.source_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 42:
                this.roomType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 34:
                this.roomUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 26:
                this.roomName_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 18:
                this.roomId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 8:
                this.event_ = param1CodedInputStream.readEnum();
                continue;
              case 0:
                bool = true;
                continue;
            } 
            boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
            if (!bool1);
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
    
    private ChatRoomProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ChatRoomProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ChatRoomProto param1ChatRoomProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ChatRoomProto);
    }
    
    public static ChatRoomProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ChatRoomProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ChatRoomProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ChatRoomProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ChatRoomProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ChatRoomProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static ChatRoomProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ChatRoomProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ChatRoomProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ChatRoomProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ChatRoomProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ChatRoomProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ChatRoomProto parseFrom(InputStream param1InputStream) throws IOException {
      return (ChatRoomProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ChatRoomProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ChatRoomProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ChatRoomProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ChatRoomProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ChatRoomProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ChatRoomProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ChatRoomProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ChatRoomProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ChatRoomProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ChatRoomProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ChatRoomProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ChatRoomProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((ChatRoomProto)param1Object).event_) ? false : (!getRoomId().equals(param1Object.getRoomId()) ? false : (!getRoomName().equals(param1Object.getRoomName()) ? false : (!getRoomUid().equals(param1Object.getRoomUid()) ? false : (!getRoomType().equals(param1Object.getRoomType()) ? false : (!getSource().equals(param1Object.getSource()) ? false : (!getTabId().equals(param1Object.getTabId()) ? false : ((this.userType_ != ((ChatRoomProto)param1Object).userType_) ? false : (!getBannerId().equals(param1Object.getBannerId()) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : ((getIsFollow() != param1Object.getIsFollow()) ? false : (!getSkuId().equals(param1Object.getSkuId()) ? false : ((this.shareChannel_ != ((ChatRoomProto)param1Object).shareChannel_) ? false : ((this.warnType_ != ((ChatRoomProto)param1Object).warnType_) ? false : ((getNum() != param1Object.getNum()) ? false : (!getGoodsId().equals(param1Object.getGoodsId()) ? false : ((getCount() != param1Object.getCount()) ? false : (!getContent().equals(param1Object.getContent()) ? false : (!getId().equals(param1Object.getId()) ? false : ((this.from_ != ((ChatRoomProto)param1Object).from_) ? false : ((getPosition() != param1Object.getPosition()) ? false : ((getTabNum() != param1Object.getTabNum()) ? false : ((getPageNum() != param1Object.getPageNum()) ? false : (!getMusicId().equals(param1Object.getMusicId()) ? false : ((getDuration() != param1Object.getDuration()) ? false : (!getRange().equals(param1Object.getRange()) ? false : (!!this.unknownFields.equals(((ChatRoomProto)param1Object).unknownFields)))))))))))))))))))))))))));
    }
    
    public String getBannerId() {
      Object object = this.bannerId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.bannerId_ = object;
      return (String)object;
    }
    
    public ByteString getBannerIdBytes() {
      Object object = this.bannerId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.bannerId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public int getCount() {
      return this.count_;
    }
    
    public ChatRoomProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getDuration() {
      return this.duration_;
    }
    
    public ChatRoomProtos.Event getEvent() {
      ChatRoomProtos.Event event2 = ChatRoomProtos.Event.valueOf(this.event_);
      ChatRoomProtos.Event event1 = event2;
      if (event2 == null)
        event1 = ChatRoomProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public ChatRoomProtos.From getFrom() {
      ChatRoomProtos.From from2 = ChatRoomProtos.From.valueOf(this.from_);
      ChatRoomProtos.From from1 = from2;
      if (from2 == null)
        from1 = ChatRoomProtos.From.UNRECOGNIZED; 
      return from1;
    }
    
    public int getFromValue() {
      return this.from_;
    }
    
    public String getGoodsId() {
      Object object = this.goodsId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.goodsId_ = object;
      return (String)object;
    }
    
    public ByteString getGoodsIdBytes() {
      Object object = this.goodsId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.goodsId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getId() {
      Object object = this.id_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.id_ = object;
      return (String)object;
    }
    
    public ByteString getIdBytes() {
      Object object = this.id_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.id_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean getIsFollow() {
      return this.isFollow_;
    }
    
    public String getMusicId() {
      Object object = this.musicId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.musicId_ = object;
      return (String)object;
    }
    
    public ByteString getMusicIdBytes() {
      Object object = this.musicId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.musicId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public int getPageNum() {
      return this.pageNum_;
    }
    
    public Parser<ChatRoomProto> getParserForType() {
      return PARSER;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public String getRange() {
      Object object = this.range_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.range_ = object;
      return (String)object;
    }
    
    public ByteString getRangeBytes() {
      Object object = this.range_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.range_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomId() {
      Object object = this.roomId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.roomId_ = object;
      return (String)object;
    }
    
    public ByteString getRoomIdBytes() {
      Object object = this.roomId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomName() {
      Object object = this.roomName_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.roomName_ = object;
      return (String)object;
    }
    
    public ByteString getRoomNameBytes() {
      Object object = this.roomName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomType() {
      Object object = this.roomType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.roomType_ = object;
      return (String)object;
    }
    
    public ByteString getRoomTypeBytes() {
      Object object = this.roomType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomUid() {
      Object object = this.roomUid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.roomUid_ = object;
      return (String)object;
    }
    
    public ByteString getRoomUidBytes() {
      Object object = this.roomUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != ChatRoomProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (!getRoomIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.roomId_); 
      j = i;
      if (!getRoomNameBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.roomName_); 
      i = j;
      if (!getRoomUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.roomUid_); 
      j = i;
      if (!getRoomTypeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.roomType_); 
      i = j;
      if (!getSourceBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(6, this.source_); 
      j = i;
      if (!getTabIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(7, this.tabId_); 
      i = j;
      if (this.userType_ != ChatRoomProtos.UserType.UNKNOWN_USER_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(8, this.userType_); 
      j = i;
      if (!getBannerIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(9, this.bannerId_); 
      i = j;
      if (!getTargetUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(10, this.targetUid_); 
      boolean bool = this.isFollow_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(11, bool); 
      i = j;
      if (!getSkuIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(12, this.skuId_); 
      j = i;
      if (this.shareChannel_ != ChatRoomProtos.ShareChannel.UNKNOWN_SHARE_CHANNEL.getNumber())
        j = i + CodedOutputStream.computeEnumSize(13, this.shareChannel_); 
      i = j;
      if (this.warnType_ != ChatRoomProtos.WarnType.UNKNOWN_WARN_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(14, this.warnType_); 
      int k = this.num_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(15, k); 
      i = j;
      if (!getGoodsIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(16, this.goodsId_); 
      k = this.count_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(17, k); 
      i = j;
      if (!getContentBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(18, this.content_); 
      k = i;
      if (!getIdBytes().isEmpty())
        k = i + GeneratedMessageV3.computeStringSize(19, this.id_); 
      j = k;
      if (this.from_ != ChatRoomProtos.From.UNKNOWN_FROM.getNumber())
        j = k + CodedOutputStream.computeEnumSize(20, this.from_); 
      k = this.position_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(21, k); 
      k = this.tabNum_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(22, k); 
      k = this.pageNum_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(23, k); 
      j = i;
      if (!getMusicIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(24, this.musicId_); 
      k = this.duration_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(25, k); 
      j = i;
      if (!getRangeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(26, this.range_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public ChatRoomProtos.ShareChannel getShareChannel() {
      ChatRoomProtos.ShareChannel shareChannel2 = ChatRoomProtos.ShareChannel.valueOf(this.shareChannel_);
      ChatRoomProtos.ShareChannel shareChannel1 = shareChannel2;
      if (shareChannel2 == null)
        shareChannel1 = ChatRoomProtos.ShareChannel.UNRECOGNIZED; 
      return shareChannel1;
    }
    
    public int getShareChannelValue() {
      return this.shareChannel_;
    }
    
    public String getSkuId() {
      Object object = this.skuId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.skuId_ = object;
      return (String)object;
    }
    
    public ByteString getSkuIdBytes() {
      Object object = this.skuId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.skuId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getSource() {
      Object object = this.source_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.source_ = object;
      return (String)object;
    }
    
    public ByteString getSourceBytes() {
      Object object = this.source_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.source_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getTabId() {
      Object object = this.tabId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.tabId_ = object;
      return (String)object;
    }
    
    public ByteString getTabIdBytes() {
      Object object = this.tabId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.tabId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getTabNum() {
      return this.tabNum_;
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
    
    public ChatRoomProtos.UserType getUserType() {
      ChatRoomProtos.UserType userType2 = ChatRoomProtos.UserType.valueOf(this.userType_);
      ChatRoomProtos.UserType userType1 = userType2;
      if (userType2 == null)
        userType1 = ChatRoomProtos.UserType.UNRECOGNIZED; 
      return userType1;
    }
    
    public int getUserTypeValue() {
      return this.userType_;
    }
    
    public ChatRoomProtos.WarnType getWarnType() {
      ChatRoomProtos.WarnType warnType2 = ChatRoomProtos.WarnType.valueOf(this.warnType_);
      ChatRoomProtos.WarnType warnType1 = warnType2;
      if (warnType2 == null)
        warnType1 = ChatRoomProtos.WarnType.UNRECOGNIZED; 
      return warnType1;
    }
    
    public int getWarnTypeValue() {
      return this.warnType_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getRoomId().hashCode()) * 37 + 3) * 53 + getRoomName().hashCode()) * 37 + 4) * 53 + getRoomUid().hashCode()) * 37 + 5) * 53 + getRoomType().hashCode()) * 37 + 6) * 53 + getSource().hashCode()) * 37 + 7) * 53 + getTabId().hashCode()) * 37 + 8) * 53 + this.userType_) * 37 + 9) * 53 + getBannerId().hashCode()) * 37 + 10) * 53 + getTargetUid().hashCode()) * 37 + 11) * 53 + Internal.hashBoolean(getIsFollow())) * 37 + 12) * 53 + getSkuId().hashCode()) * 37 + 13) * 53 + this.shareChannel_) * 37 + 14) * 53 + this.warnType_) * 37 + 15) * 53 + getNum()) * 37 + 16) * 53 + getGoodsId().hashCode()) * 37 + 17) * 53 + getCount()) * 37 + 18) * 53 + getContent().hashCode()) * 37 + 19) * 53 + getId().hashCode()) * 37 + 20) * 53 + this.from_) * 37 + 21) * 53 + getPosition()) * 37 + 22) * 53 + getTabNum()) * 37 + 23) * 53 + getPageNum()) * 37 + 24) * 53 + getMusicId().hashCode()) * 37 + 25) * 53 + getDuration()) * 37 + 26) * 53 + getRange().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatRoomProto.class, Builder.class);
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
      return new ChatRoomProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != ChatRoomProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getRoomIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.roomId_); 
      if (!getRoomNameBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.roomName_); 
      if (!getRoomUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.roomUid_); 
      if (!getRoomTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.roomType_); 
      if (!getSourceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.source_); 
      if (!getTabIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 7, this.tabId_); 
      if (this.userType_ != ChatRoomProtos.UserType.UNKNOWN_USER_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(8, this.userType_); 
      if (!getBannerIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 9, this.bannerId_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 10, this.targetUid_); 
      boolean bool = this.isFollow_;
      if (bool)
        param1CodedOutputStream.writeBool(11, bool); 
      if (!getSkuIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 12, this.skuId_); 
      if (this.shareChannel_ != ChatRoomProtos.ShareChannel.UNKNOWN_SHARE_CHANNEL.getNumber())
        param1CodedOutputStream.writeEnum(13, this.shareChannel_); 
      if (this.warnType_ != ChatRoomProtos.WarnType.UNKNOWN_WARN_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(14, this.warnType_); 
      int i = this.num_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(15, i); 
      if (!getGoodsIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 16, this.goodsId_); 
      i = this.count_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(17, i); 
      if (!getContentBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 18, this.content_); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 19, this.id_); 
      if (this.from_ != ChatRoomProtos.From.UNKNOWN_FROM.getNumber())
        param1CodedOutputStream.writeEnum(20, this.from_); 
      i = this.position_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(21, i); 
      i = this.tabNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(22, i); 
      i = this.pageNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(23, i); 
      if (!getMusicIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 24, this.musicId_); 
      i = this.duration_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(25, i); 
      if (!getRangeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 26, this.range_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChatRoomProtos.ChatRoomProtoOrBuilder {
      private Object bannerId_ = "";
      
      private Object content_ = "";
      
      private int count_;
      
      private int duration_;
      
      private int event_ = 0;
      
      private int from_ = 0;
      
      private Object goodsId_ = "";
      
      private Object id_ = "";
      
      private boolean isFollow_;
      
      private Object musicId_ = "";
      
      private int num_;
      
      private int pageNum_;
      
      private int position_;
      
      private Object range_ = "";
      
      private Object roomId_ = "";
      
      private Object roomName_ = "";
      
      private Object roomType_ = "";
      
      private Object roomUid_ = "";
      
      private int shareChannel_ = 0;
      
      private Object skuId_ = "";
      
      private Object source_ = "";
      
      private Object tabId_ = "";
      
      private int tabNum_;
      
      private Object targetUid_ = "";
      
      private int userType_ = 0;
      
      private int warnType_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ChatRoomProtos.ChatRoomProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ChatRoomProtos.ChatRoomProto build() {
        ChatRoomProtos.ChatRoomProto chatRoomProto = buildPartial();
        if (chatRoomProto.isInitialized())
          return chatRoomProto; 
        throw newUninitializedMessageException(chatRoomProto);
      }
      
      public ChatRoomProtos.ChatRoomProto buildPartial() {
        ChatRoomProtos.ChatRoomProto chatRoomProto = new ChatRoomProtos.ChatRoomProto(this);
        ChatRoomProtos.ChatRoomProto.access$602(chatRoomProto, this.event_);
        ChatRoomProtos.ChatRoomProto.access$702(chatRoomProto, this.roomId_);
        ChatRoomProtos.ChatRoomProto.access$802(chatRoomProto, this.roomName_);
        ChatRoomProtos.ChatRoomProto.access$902(chatRoomProto, this.roomUid_);
        ChatRoomProtos.ChatRoomProto.access$1002(chatRoomProto, this.roomType_);
        ChatRoomProtos.ChatRoomProto.access$1102(chatRoomProto, this.source_);
        ChatRoomProtos.ChatRoomProto.access$1202(chatRoomProto, this.tabId_);
        ChatRoomProtos.ChatRoomProto.access$1302(chatRoomProto, this.userType_);
        ChatRoomProtos.ChatRoomProto.access$1402(chatRoomProto, this.bannerId_);
        ChatRoomProtos.ChatRoomProto.access$1502(chatRoomProto, this.targetUid_);
        ChatRoomProtos.ChatRoomProto.access$1602(chatRoomProto, this.isFollow_);
        ChatRoomProtos.ChatRoomProto.access$1702(chatRoomProto, this.skuId_);
        ChatRoomProtos.ChatRoomProto.access$1802(chatRoomProto, this.shareChannel_);
        ChatRoomProtos.ChatRoomProto.access$1902(chatRoomProto, this.warnType_);
        ChatRoomProtos.ChatRoomProto.access$2002(chatRoomProto, this.num_);
        ChatRoomProtos.ChatRoomProto.access$2102(chatRoomProto, this.goodsId_);
        ChatRoomProtos.ChatRoomProto.access$2202(chatRoomProto, this.count_);
        ChatRoomProtos.ChatRoomProto.access$2302(chatRoomProto, this.content_);
        ChatRoomProtos.ChatRoomProto.access$2402(chatRoomProto, this.id_);
        ChatRoomProtos.ChatRoomProto.access$2502(chatRoomProto, this.from_);
        ChatRoomProtos.ChatRoomProto.access$2602(chatRoomProto, this.position_);
        ChatRoomProtos.ChatRoomProto.access$2702(chatRoomProto, this.tabNum_);
        ChatRoomProtos.ChatRoomProto.access$2802(chatRoomProto, this.pageNum_);
        ChatRoomProtos.ChatRoomProto.access$2902(chatRoomProto, this.musicId_);
        ChatRoomProtos.ChatRoomProto.access$3002(chatRoomProto, this.duration_);
        ChatRoomProtos.ChatRoomProto.access$3102(chatRoomProto, this.range_);
        onBuilt();
        return chatRoomProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.roomId_ = "";
        this.roomName_ = "";
        this.roomUid_ = "";
        this.roomType_ = "";
        this.source_ = "";
        this.tabId_ = "";
        this.userType_ = 0;
        this.bannerId_ = "";
        this.targetUid_ = "";
        this.isFollow_ = false;
        this.skuId_ = "";
        this.shareChannel_ = 0;
        this.warnType_ = 0;
        this.num_ = 0;
        this.goodsId_ = "";
        this.count_ = 0;
        this.content_ = "";
        this.id_ = "";
        this.from_ = 0;
        this.position_ = 0;
        this.tabNum_ = 0;
        this.pageNum_ = 0;
        this.musicId_ = "";
        this.duration_ = 0;
        this.range_ = "";
        return this;
      }
      
      public Builder clearBannerId() {
        this.bannerId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getBannerId();
        onChanged();
        return this;
      }
      
      public Builder clearContent() {
        this.content_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      
      public Builder clearCount() {
        this.count_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearDuration() {
        this.duration_ = 0;
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
      
      public Builder clearFrom() {
        this.from_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearGoodsId() {
        this.goodsId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getGoodsId();
        onChanged();
        return this;
      }
      
      public Builder clearId() {
        this.id_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearIsFollow() {
        this.isFollow_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearMusicId() {
        this.musicId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getMusicId();
        onChanged();
        return this;
      }
      
      public Builder clearNum() {
        this.num_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPageNum() {
        this.pageNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPosition() {
        this.position_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearRange() {
        this.range_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRange();
        onChanged();
        return this;
      }
      
      public Builder clearRoomId() {
        this.roomId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomId();
        onChanged();
        return this;
      }
      
      public Builder clearRoomName() {
        this.roomName_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomName();
        onChanged();
        return this;
      }
      
      public Builder clearRoomType() {
        this.roomType_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomType();
        onChanged();
        return this;
      }
      
      public Builder clearRoomUid() {
        this.roomUid_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomUid();
        onChanged();
        return this;
      }
      
      public Builder clearShareChannel() {
        this.shareChannel_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSkuId() {
        this.skuId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getSkuId();
        onChanged();
        return this;
      }
      
      public Builder clearSource() {
        this.source_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getSource();
        onChanged();
        return this;
      }
      
      public Builder clearTabId() {
        this.tabId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getTabId();
        onChanged();
        return this;
      }
      
      public Builder clearTabNum() {
        this.tabNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clearUserType() {
        this.userType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearWarnType() {
        this.warnType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getBannerId() {
        Object object = this.bannerId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.bannerId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getBannerIdBytes() {
        Object object = this.bannerId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.bannerId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public int getCount() {
        return this.count_;
      }
      
      public ChatRoomProtos.ChatRoomProto getDefaultInstanceForType() {
        return ChatRoomProtos.ChatRoomProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
      }
      
      public int getDuration() {
        return this.duration_;
      }
      
      public ChatRoomProtos.Event getEvent() {
        ChatRoomProtos.Event event2 = ChatRoomProtos.Event.valueOf(this.event_);
        ChatRoomProtos.Event event1 = event2;
        if (event2 == null)
          event1 = ChatRoomProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public ChatRoomProtos.From getFrom() {
        ChatRoomProtos.From from2 = ChatRoomProtos.From.valueOf(this.from_);
        ChatRoomProtos.From from1 = from2;
        if (from2 == null)
          from1 = ChatRoomProtos.From.UNRECOGNIZED; 
        return from1;
      }
      
      public int getFromValue() {
        return this.from_;
      }
      
      public String getGoodsId() {
        Object object = this.goodsId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.goodsId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getGoodsIdBytes() {
        Object object = this.goodsId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.goodsId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getId() {
        Object object = this.id_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.id_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getIdBytes() {
        Object object = this.id_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.id_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public boolean getIsFollow() {
        return this.isFollow_;
      }
      
      public String getMusicId() {
        Object object = this.musicId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.musicId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getMusicIdBytes() {
        Object object = this.musicId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.musicId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getNum() {
        return this.num_;
      }
      
      public int getPageNum() {
        return this.pageNum_;
      }
      
      public int getPosition() {
        return this.position_;
      }
      
      public String getRange() {
        Object object = this.range_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.range_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRangeBytes() {
        Object object = this.range_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.range_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRoomId() {
        Object object = this.roomId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.roomId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRoomIdBytes() {
        Object object = this.roomId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.roomId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRoomName() {
        Object object = this.roomName_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.roomName_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRoomNameBytes() {
        Object object = this.roomName_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.roomName_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRoomType() {
        Object object = this.roomType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.roomType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRoomTypeBytes() {
        Object object = this.roomType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.roomType_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRoomUid() {
        Object object = this.roomUid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.roomUid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRoomUidBytes() {
        Object object = this.roomUid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.roomUid_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public ChatRoomProtos.ShareChannel getShareChannel() {
        ChatRoomProtos.ShareChannel shareChannel2 = ChatRoomProtos.ShareChannel.valueOf(this.shareChannel_);
        ChatRoomProtos.ShareChannel shareChannel1 = shareChannel2;
        if (shareChannel2 == null)
          shareChannel1 = ChatRoomProtos.ShareChannel.UNRECOGNIZED; 
        return shareChannel1;
      }
      
      public int getShareChannelValue() {
        return this.shareChannel_;
      }
      
      public String getSkuId() {
        Object object = this.skuId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.skuId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getSkuIdBytes() {
        Object object = this.skuId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.skuId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getSource() {
        Object object = this.source_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.source_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getSourceBytes() {
        Object object = this.source_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.source_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getTabId() {
        Object object = this.tabId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.tabId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTabIdBytes() {
        Object object = this.tabId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.tabId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getTabNum() {
        return this.tabNum_;
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
      
      public ChatRoomProtos.UserType getUserType() {
        ChatRoomProtos.UserType userType2 = ChatRoomProtos.UserType.valueOf(this.userType_);
        ChatRoomProtos.UserType userType1 = userType2;
        if (userType2 == null)
          userType1 = ChatRoomProtos.UserType.UNRECOGNIZED; 
        return userType1;
      }
      
      public int getUserTypeValue() {
        return this.userType_;
      }
      
      public ChatRoomProtos.WarnType getWarnType() {
        ChatRoomProtos.WarnType warnType2 = ChatRoomProtos.WarnType.valueOf(this.warnType_);
        ChatRoomProtos.WarnType warnType1 = warnType2;
        if (warnType2 == null)
          warnType1 = ChatRoomProtos.WarnType.UNRECOGNIZED; 
        return warnType1;
      }
      
      public int getWarnTypeValue() {
        return this.warnType_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatRoomProtos.ChatRoomProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ChatRoomProtos.ChatRoomProto param2ChatRoomProto) {
        if (param2ChatRoomProto == ChatRoomProtos.ChatRoomProto.getDefaultInstance())
          return this; 
        if (param2ChatRoomProto.event_ != 0)
          setEventValue(param2ChatRoomProto.getEventValue()); 
        if (!param2ChatRoomProto.getRoomId().isEmpty()) {
          this.roomId_ = param2ChatRoomProto.roomId_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getRoomName().isEmpty()) {
          this.roomName_ = param2ChatRoomProto.roomName_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getRoomUid().isEmpty()) {
          this.roomUid_ = param2ChatRoomProto.roomUid_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getRoomType().isEmpty()) {
          this.roomType_ = param2ChatRoomProto.roomType_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getSource().isEmpty()) {
          this.source_ = param2ChatRoomProto.source_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getTabId().isEmpty()) {
          this.tabId_ = param2ChatRoomProto.tabId_;
          onChanged();
        } 
        if (param2ChatRoomProto.userType_ != 0)
          setUserTypeValue(param2ChatRoomProto.getUserTypeValue()); 
        if (!param2ChatRoomProto.getBannerId().isEmpty()) {
          this.bannerId_ = param2ChatRoomProto.bannerId_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2ChatRoomProto.targetUid_;
          onChanged();
        } 
        if (param2ChatRoomProto.getIsFollow())
          setIsFollow(param2ChatRoomProto.getIsFollow()); 
        if (!param2ChatRoomProto.getSkuId().isEmpty()) {
          this.skuId_ = param2ChatRoomProto.skuId_;
          onChanged();
        } 
        if (param2ChatRoomProto.shareChannel_ != 0)
          setShareChannelValue(param2ChatRoomProto.getShareChannelValue()); 
        if (param2ChatRoomProto.warnType_ != 0)
          setWarnTypeValue(param2ChatRoomProto.getWarnTypeValue()); 
        if (param2ChatRoomProto.getNum() != 0)
          setNum(param2ChatRoomProto.getNum()); 
        if (!param2ChatRoomProto.getGoodsId().isEmpty()) {
          this.goodsId_ = param2ChatRoomProto.goodsId_;
          onChanged();
        } 
        if (param2ChatRoomProto.getCount() != 0)
          setCount(param2ChatRoomProto.getCount()); 
        if (!param2ChatRoomProto.getContent().isEmpty()) {
          this.content_ = param2ChatRoomProto.content_;
          onChanged();
        } 
        if (!param2ChatRoomProto.getId().isEmpty()) {
          this.id_ = param2ChatRoomProto.id_;
          onChanged();
        } 
        if (param2ChatRoomProto.from_ != 0)
          setFromValue(param2ChatRoomProto.getFromValue()); 
        if (param2ChatRoomProto.getPosition() != 0)
          setPosition(param2ChatRoomProto.getPosition()); 
        if (param2ChatRoomProto.getTabNum() != 0)
          setTabNum(param2ChatRoomProto.getTabNum()); 
        if (param2ChatRoomProto.getPageNum() != 0)
          setPageNum(param2ChatRoomProto.getPageNum()); 
        if (!param2ChatRoomProto.getMusicId().isEmpty()) {
          this.musicId_ = param2ChatRoomProto.musicId_;
          onChanged();
        } 
        if (param2ChatRoomProto.getDuration() != 0)
          setDuration(param2ChatRoomProto.getDuration()); 
        if (!param2ChatRoomProto.getRange().isEmpty()) {
          this.range_ = param2ChatRoomProto.range_;
          onChanged();
        } 
        mergeUnknownFields(param2ChatRoomProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ChatRoomProtos.ChatRoomProto chatRoomProto = (ChatRoomProtos.ChatRoomProto)ChatRoomProtos.ChatRoomProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ChatRoomProtos.ChatRoomProto chatRoomProto = (ChatRoomProtos.ChatRoomProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ChatRoomProtos.ChatRoomProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ChatRoomProtos.ChatRoomProto)
          return mergeFrom((ChatRoomProtos.ChatRoomProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBannerId(String param2String) {
        if (param2String != null) {
          this.bannerId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBannerIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.bannerId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.content_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCount(int param2Int) {
        this.count_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setDuration(int param2Int) {
        this.duration_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setEvent(ChatRoomProtos.Event param2Event) {
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
      
      public Builder setFrom(ChatRoomProtos.From param2From) {
        if (param2From != null) {
          this.from_ = param2From.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFromValue(int param2Int) {
        this.from_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setGoodsId(String param2String) {
        if (param2String != null) {
          this.goodsId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGoodsIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.goodsId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setId(String param2String) {
        if (param2String != null) {
          this.id_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.id_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIsFollow(boolean param2Boolean) {
        this.isFollow_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setMusicId(String param2String) {
        if (param2String != null) {
          this.musicId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMusicIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.musicId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNum(int param2Int) {
        this.num_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPageNum(int param2Int) {
        this.pageNum_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPosition(int param2Int) {
        this.position_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRange(String param2String) {
        if (param2String != null) {
          this.range_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRangeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.range_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setRoomId(String param2String) {
        if (param2String != null) {
          this.roomId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.roomId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomName(String param2String) {
        if (param2String != null) {
          this.roomName_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.roomName_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomType(String param2String) {
        if (param2String != null) {
          this.roomType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.roomType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomUid(String param2String) {
        if (param2String != null) {
          this.roomUid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoomUidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.roomUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setShareChannel(ChatRoomProtos.ShareChannel param2ShareChannel) {
        if (param2ShareChannel != null) {
          this.shareChannel_ = param2ShareChannel.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setShareChannelValue(int param2Int) {
        this.shareChannel_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSkuId(String param2String) {
        if (param2String != null) {
          this.skuId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSkuIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.skuId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSource(String param2String) {
        if (param2String != null) {
          this.source_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSourceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.source_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTabId(String param2String) {
        if (param2String != null) {
          this.tabId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTabIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.tabId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTabNum(int param2Int) {
        this.tabNum_ = param2Int;
        onChanged();
        return this;
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
          ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setUserType(ChatRoomProtos.UserType param2UserType) {
        if (param2UserType != null) {
          this.userType_ = param2UserType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUserTypeValue(int param2Int) {
        this.userType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setWarnType(ChatRoomProtos.WarnType param2WarnType) {
        if (param2WarnType != null) {
          this.warnType_ = param2WarnType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setWarnTypeValue(int param2Int) {
        this.warnType_ = param2Int;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<ChatRoomProto> {
    public ChatRoomProtos.ChatRoomProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ChatRoomProtos.ChatRoomProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ChatRoomProto.Builder> implements ChatRoomProtoOrBuilder {
    private Object bannerId_ = "";
    
    private Object content_ = "";
    
    private int count_;
    
    private int duration_;
    
    private int event_ = 0;
    
    private int from_ = 0;
    
    private Object goodsId_ = "";
    
    private Object id_ = "";
    
    private boolean isFollow_;
    
    private Object musicId_ = "";
    
    private int num_;
    
    private int pageNum_;
    
    private int position_;
    
    private Object range_ = "";
    
    private Object roomId_ = "";
    
    private Object roomName_ = "";
    
    private Object roomType_ = "";
    
    private Object roomUid_ = "";
    
    private int shareChannel_ = 0;
    
    private Object skuId_ = "";
    
    private Object source_ = "";
    
    private Object tabId_ = "";
    
    private int tabNum_;
    
    private Object targetUid_ = "";
    
    private int userType_ = 0;
    
    private int warnType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ChatRoomProtos.ChatRoomProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ChatRoomProtos.ChatRoomProto build() {
      ChatRoomProtos.ChatRoomProto chatRoomProto = buildPartial();
      if (chatRoomProto.isInitialized())
        return chatRoomProto; 
      throw newUninitializedMessageException(chatRoomProto);
    }
    
    public ChatRoomProtos.ChatRoomProto buildPartial() {
      ChatRoomProtos.ChatRoomProto chatRoomProto = new ChatRoomProtos.ChatRoomProto(this);
      ChatRoomProtos.ChatRoomProto.access$602(chatRoomProto, this.event_);
      ChatRoomProtos.ChatRoomProto.access$702(chatRoomProto, this.roomId_);
      ChatRoomProtos.ChatRoomProto.access$802(chatRoomProto, this.roomName_);
      ChatRoomProtos.ChatRoomProto.access$902(chatRoomProto, this.roomUid_);
      ChatRoomProtos.ChatRoomProto.access$1002(chatRoomProto, this.roomType_);
      ChatRoomProtos.ChatRoomProto.access$1102(chatRoomProto, this.source_);
      ChatRoomProtos.ChatRoomProto.access$1202(chatRoomProto, this.tabId_);
      ChatRoomProtos.ChatRoomProto.access$1302(chatRoomProto, this.userType_);
      ChatRoomProtos.ChatRoomProto.access$1402(chatRoomProto, this.bannerId_);
      ChatRoomProtos.ChatRoomProto.access$1502(chatRoomProto, this.targetUid_);
      ChatRoomProtos.ChatRoomProto.access$1602(chatRoomProto, this.isFollow_);
      ChatRoomProtos.ChatRoomProto.access$1702(chatRoomProto, this.skuId_);
      ChatRoomProtos.ChatRoomProto.access$1802(chatRoomProto, this.shareChannel_);
      ChatRoomProtos.ChatRoomProto.access$1902(chatRoomProto, this.warnType_);
      ChatRoomProtos.ChatRoomProto.access$2002(chatRoomProto, this.num_);
      ChatRoomProtos.ChatRoomProto.access$2102(chatRoomProto, this.goodsId_);
      ChatRoomProtos.ChatRoomProto.access$2202(chatRoomProto, this.count_);
      ChatRoomProtos.ChatRoomProto.access$2302(chatRoomProto, this.content_);
      ChatRoomProtos.ChatRoomProto.access$2402(chatRoomProto, this.id_);
      ChatRoomProtos.ChatRoomProto.access$2502(chatRoomProto, this.from_);
      ChatRoomProtos.ChatRoomProto.access$2602(chatRoomProto, this.position_);
      ChatRoomProtos.ChatRoomProto.access$2702(chatRoomProto, this.tabNum_);
      ChatRoomProtos.ChatRoomProto.access$2802(chatRoomProto, this.pageNum_);
      ChatRoomProtos.ChatRoomProto.access$2902(chatRoomProto, this.musicId_);
      ChatRoomProtos.ChatRoomProto.access$3002(chatRoomProto, this.duration_);
      ChatRoomProtos.ChatRoomProto.access$3102(chatRoomProto, this.range_);
      onBuilt();
      return chatRoomProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.roomId_ = "";
      this.roomName_ = "";
      this.roomUid_ = "";
      this.roomType_ = "";
      this.source_ = "";
      this.tabId_ = "";
      this.userType_ = 0;
      this.bannerId_ = "";
      this.targetUid_ = "";
      this.isFollow_ = false;
      this.skuId_ = "";
      this.shareChannel_ = 0;
      this.warnType_ = 0;
      this.num_ = 0;
      this.goodsId_ = "";
      this.count_ = 0;
      this.content_ = "";
      this.id_ = "";
      this.from_ = 0;
      this.position_ = 0;
      this.tabNum_ = 0;
      this.pageNum_ = 0;
      this.musicId_ = "";
      this.duration_ = 0;
      this.range_ = "";
      return this;
    }
    
    public Builder clearBannerId() {
      this.bannerId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getBannerId();
      onChanged();
      return this;
    }
    
    public Builder clearContent() {
      this.content_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    
    public Builder clearCount() {
      this.count_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearDuration() {
      this.duration_ = 0;
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
    
    public Builder clearFrom() {
      this.from_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearGoodsId() {
      this.goodsId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getGoodsId();
      onChanged();
      return this;
    }
    
    public Builder clearId() {
      this.id_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearIsFollow() {
      this.isFollow_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearMusicId() {
      this.musicId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getMusicId();
      onChanged();
      return this;
    }
    
    public Builder clearNum() {
      this.num_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPageNum() {
      this.pageNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPosition() {
      this.position_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearRange() {
      this.range_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRange();
      onChanged();
      return this;
    }
    
    public Builder clearRoomId() {
      this.roomId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomId();
      onChanged();
      return this;
    }
    
    public Builder clearRoomName() {
      this.roomName_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomName();
      onChanged();
      return this;
    }
    
    public Builder clearRoomType() {
      this.roomType_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomType();
      onChanged();
      return this;
    }
    
    public Builder clearRoomUid() {
      this.roomUid_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getRoomUid();
      onChanged();
      return this;
    }
    
    public Builder clearShareChannel() {
      this.shareChannel_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSkuId() {
      this.skuId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getSkuId();
      onChanged();
      return this;
    }
    
    public Builder clearSource() {
      this.source_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getSource();
      onChanged();
      return this;
    }
    
    public Builder clearTabId() {
      this.tabId_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getTabId();
      onChanged();
      return this;
    }
    
    public Builder clearTabNum() {
      this.tabNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = ChatRoomProtos.ChatRoomProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clearUserType() {
      this.userType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearWarnType() {
      this.warnType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getBannerId() {
      Object object = this.bannerId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.bannerId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getBannerIdBytes() {
      Object object = this.bannerId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.bannerId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public int getCount() {
      return this.count_;
    }
    
    public ChatRoomProtos.ChatRoomProto getDefaultInstanceForType() {
      return ChatRoomProtos.ChatRoomProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
    }
    
    public int getDuration() {
      return this.duration_;
    }
    
    public ChatRoomProtos.Event getEvent() {
      ChatRoomProtos.Event event2 = ChatRoomProtos.Event.valueOf(this.event_);
      ChatRoomProtos.Event event1 = event2;
      if (event2 == null)
        event1 = ChatRoomProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public ChatRoomProtos.From getFrom() {
      ChatRoomProtos.From from2 = ChatRoomProtos.From.valueOf(this.from_);
      ChatRoomProtos.From from1 = from2;
      if (from2 == null)
        from1 = ChatRoomProtos.From.UNRECOGNIZED; 
      return from1;
    }
    
    public int getFromValue() {
      return this.from_;
    }
    
    public String getGoodsId() {
      Object object = this.goodsId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.goodsId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getGoodsIdBytes() {
      Object object = this.goodsId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.goodsId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getId() {
      Object object = this.id_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.id_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIdBytes() {
      Object object = this.id_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.id_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean getIsFollow() {
      return this.isFollow_;
    }
    
    public String getMusicId() {
      Object object = this.musicId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.musicId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMusicIdBytes() {
      Object object = this.musicId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.musicId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public int getPageNum() {
      return this.pageNum_;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public String getRange() {
      Object object = this.range_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.range_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRangeBytes() {
      Object object = this.range_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.range_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomId() {
      Object object = this.roomId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.roomId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRoomIdBytes() {
      Object object = this.roomId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomName() {
      Object object = this.roomName_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.roomName_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRoomNameBytes() {
      Object object = this.roomName_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomName_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomType() {
      Object object = this.roomType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.roomType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRoomTypeBytes() {
      Object object = this.roomType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRoomUid() {
      Object object = this.roomUid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.roomUid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRoomUidBytes() {
      Object object = this.roomUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.roomUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public ChatRoomProtos.ShareChannel getShareChannel() {
      ChatRoomProtos.ShareChannel shareChannel2 = ChatRoomProtos.ShareChannel.valueOf(this.shareChannel_);
      ChatRoomProtos.ShareChannel shareChannel1 = shareChannel2;
      if (shareChannel2 == null)
        shareChannel1 = ChatRoomProtos.ShareChannel.UNRECOGNIZED; 
      return shareChannel1;
    }
    
    public int getShareChannelValue() {
      return this.shareChannel_;
    }
    
    public String getSkuId() {
      Object object = this.skuId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.skuId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSkuIdBytes() {
      Object object = this.skuId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.skuId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getSource() {
      Object object = this.source_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.source_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSourceBytes() {
      Object object = this.source_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.source_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getTabId() {
      Object object = this.tabId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.tabId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTabIdBytes() {
      Object object = this.tabId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.tabId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getTabNum() {
      return this.tabNum_;
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
    
    public ChatRoomProtos.UserType getUserType() {
      ChatRoomProtos.UserType userType2 = ChatRoomProtos.UserType.valueOf(this.userType_);
      ChatRoomProtos.UserType userType1 = userType2;
      if (userType2 == null)
        userType1 = ChatRoomProtos.UserType.UNRECOGNIZED; 
      return userType1;
    }
    
    public int getUserTypeValue() {
      return this.userType_;
    }
    
    public ChatRoomProtos.WarnType getWarnType() {
      ChatRoomProtos.WarnType warnType2 = ChatRoomProtos.WarnType.valueOf(this.warnType_);
      ChatRoomProtos.WarnType warnType1 = warnType2;
      if (warnType2 == null)
        warnType1 = ChatRoomProtos.WarnType.UNRECOGNIZED; 
      return warnType1;
    }
    
    public int getWarnTypeValue() {
      return this.warnType_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatRoomProtos.ChatRoomProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ChatRoomProtos.ChatRoomProto param1ChatRoomProto) {
      if (param1ChatRoomProto == ChatRoomProtos.ChatRoomProto.getDefaultInstance())
        return this; 
      if (param1ChatRoomProto.event_ != 0)
        setEventValue(param1ChatRoomProto.getEventValue()); 
      if (!param1ChatRoomProto.getRoomId().isEmpty()) {
        this.roomId_ = param1ChatRoomProto.roomId_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getRoomName().isEmpty()) {
        this.roomName_ = param1ChatRoomProto.roomName_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getRoomUid().isEmpty()) {
        this.roomUid_ = param1ChatRoomProto.roomUid_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getRoomType().isEmpty()) {
        this.roomType_ = param1ChatRoomProto.roomType_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getSource().isEmpty()) {
        this.source_ = param1ChatRoomProto.source_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getTabId().isEmpty()) {
        this.tabId_ = param1ChatRoomProto.tabId_;
        onChanged();
      } 
      if (param1ChatRoomProto.userType_ != 0)
        setUserTypeValue(param1ChatRoomProto.getUserTypeValue()); 
      if (!param1ChatRoomProto.getBannerId().isEmpty()) {
        this.bannerId_ = param1ChatRoomProto.bannerId_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1ChatRoomProto.targetUid_;
        onChanged();
      } 
      if (param1ChatRoomProto.getIsFollow())
        setIsFollow(param1ChatRoomProto.getIsFollow()); 
      if (!param1ChatRoomProto.getSkuId().isEmpty()) {
        this.skuId_ = param1ChatRoomProto.skuId_;
        onChanged();
      } 
      if (param1ChatRoomProto.shareChannel_ != 0)
        setShareChannelValue(param1ChatRoomProto.getShareChannelValue()); 
      if (param1ChatRoomProto.warnType_ != 0)
        setWarnTypeValue(param1ChatRoomProto.getWarnTypeValue()); 
      if (param1ChatRoomProto.getNum() != 0)
        setNum(param1ChatRoomProto.getNum()); 
      if (!param1ChatRoomProto.getGoodsId().isEmpty()) {
        this.goodsId_ = param1ChatRoomProto.goodsId_;
        onChanged();
      } 
      if (param1ChatRoomProto.getCount() != 0)
        setCount(param1ChatRoomProto.getCount()); 
      if (!param1ChatRoomProto.getContent().isEmpty()) {
        this.content_ = param1ChatRoomProto.content_;
        onChanged();
      } 
      if (!param1ChatRoomProto.getId().isEmpty()) {
        this.id_ = param1ChatRoomProto.id_;
        onChanged();
      } 
      if (param1ChatRoomProto.from_ != 0)
        setFromValue(param1ChatRoomProto.getFromValue()); 
      if (param1ChatRoomProto.getPosition() != 0)
        setPosition(param1ChatRoomProto.getPosition()); 
      if (param1ChatRoomProto.getTabNum() != 0)
        setTabNum(param1ChatRoomProto.getTabNum()); 
      if (param1ChatRoomProto.getPageNum() != 0)
        setPageNum(param1ChatRoomProto.getPageNum()); 
      if (!param1ChatRoomProto.getMusicId().isEmpty()) {
        this.musicId_ = param1ChatRoomProto.musicId_;
        onChanged();
      } 
      if (param1ChatRoomProto.getDuration() != 0)
        setDuration(param1ChatRoomProto.getDuration()); 
      if (!param1ChatRoomProto.getRange().isEmpty()) {
        this.range_ = param1ChatRoomProto.range_;
        onChanged();
      } 
      mergeUnknownFields(param1ChatRoomProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ChatRoomProtos.ChatRoomProto chatRoomProto = (ChatRoomProtos.ChatRoomProto)ChatRoomProtos.ChatRoomProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ChatRoomProtos.ChatRoomProto chatRoomProto = (ChatRoomProtos.ChatRoomProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ChatRoomProtos.ChatRoomProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ChatRoomProtos.ChatRoomProto)
        return mergeFrom((ChatRoomProtos.ChatRoomProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBannerId(String param1String) {
      if (param1String != null) {
        this.bannerId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBannerIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.bannerId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.content_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCount(int param1Int) {
      this.count_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setDuration(int param1Int) {
      this.duration_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setEvent(ChatRoomProtos.Event param1Event) {
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
    
    public Builder setFrom(ChatRoomProtos.From param1From) {
      if (param1From != null) {
        this.from_ = param1From.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFromValue(int param1Int) {
      this.from_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setGoodsId(String param1String) {
      if (param1String != null) {
        this.goodsId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGoodsIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.goodsId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setId(String param1String) {
      if (param1String != null) {
        this.id_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIsFollow(boolean param1Boolean) {
      this.isFollow_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setMusicId(String param1String) {
      if (param1String != null) {
        this.musicId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMusicIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.musicId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNum(int param1Int) {
      this.num_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPageNum(int param1Int) {
      this.pageNum_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPosition(int param1Int) {
      this.position_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRange(String param1String) {
      if (param1String != null) {
        this.range_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRangeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.range_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRoomId(String param1String) {
      if (param1String != null) {
        this.roomId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.roomId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomName(String param1String) {
      if (param1String != null) {
        this.roomName_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.roomName_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomType(String param1String) {
      if (param1String != null) {
        this.roomType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.roomType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomUid(String param1String) {
      if (param1String != null) {
        this.roomUid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoomUidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.roomUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setShareChannel(ChatRoomProtos.ShareChannel param1ShareChannel) {
      if (param1ShareChannel != null) {
        this.shareChannel_ = param1ShareChannel.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setShareChannelValue(int param1Int) {
      this.shareChannel_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSkuId(String param1String) {
      if (param1String != null) {
        this.skuId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSkuIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.skuId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSource(String param1String) {
      if (param1String != null) {
        this.source_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSourceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.source_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTabId(String param1String) {
      if (param1String != null) {
        this.tabId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTabIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.tabId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTabNum(int param1Int) {
      this.tabNum_ = param1Int;
      onChanged();
      return this;
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
        ChatRoomProtos.ChatRoomProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUserType(ChatRoomProtos.UserType param1UserType) {
      if (param1UserType != null) {
        this.userType_ = param1UserType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUserTypeValue(int param1Int) {
      this.userType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setWarnType(ChatRoomProtos.WarnType param1WarnType) {
      if (param1WarnType != null) {
        this.warnType_ = param1WarnType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setWarnTypeValue(int param1Int) {
      this.warnType_ = param1Int;
      onChanged();
      return this;
    }
  }
  
  public static interface ChatRoomProtoOrBuilder extends MessageOrBuilder {
    String getBannerId();
    
    ByteString getBannerIdBytes();
    
    String getContent();
    
    ByteString getContentBytes();
    
    int getCount();
    
    int getDuration();
    
    ChatRoomProtos.Event getEvent();
    
    int getEventValue();
    
    ChatRoomProtos.From getFrom();
    
    int getFromValue();
    
    String getGoodsId();
    
    ByteString getGoodsIdBytes();
    
    String getId();
    
    ByteString getIdBytes();
    
    boolean getIsFollow();
    
    String getMusicId();
    
    ByteString getMusicIdBytes();
    
    int getNum();
    
    int getPageNum();
    
    int getPosition();
    
    String getRange();
    
    ByteString getRangeBytes();
    
    String getRoomId();
    
    ByteString getRoomIdBytes();
    
    String getRoomName();
    
    ByteString getRoomNameBytes();
    
    String getRoomType();
    
    ByteString getRoomTypeBytes();
    
    String getRoomUid();
    
    ByteString getRoomUidBytes();
    
    ChatRoomProtos.ShareChannel getShareChannel();
    
    int getShareChannelValue();
    
    String getSkuId();
    
    ByteString getSkuIdBytes();
    
    String getSource();
    
    ByteString getSourceBytes();
    
    String getTabId();
    
    ByteString getTabIdBytes();
    
    int getTabNum();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
    
    ChatRoomProtos.UserType getUserType();
    
    int getUserTypeValue();
    
    ChatRoomProtos.WarnType getWarnType();
    
    int getWarnTypeValue();
  }
  
  public enum Event implements ProtocolMessageEnum {
    CHAT_ROOM_ACCEPT_CLICK,
    CHAT_ROOM_APPROVE_GUIDE_CLICK,
    CHAT_ROOM_APPROVE_GUIDE_SHOW,
    CHAT_ROOM_BANNER_CLICK,
    CHAT_ROOM_BANNER_SHOW,
    CHAT_ROOM_BG_ENTER_CLICK,
    CHAT_ROOM_BG_SOMEONE_CLICK,
    CHAT_ROOM_CHANGE_MIC_BTN_CLICK,
    CHAT_ROOM_CP_MATCH_START,
    CHAT_ROOM_CP_MATCH_SUCCEED,
    CHAT_ROOM_CREATE_CLICK,
    CHAT_ROOM_CREATE_CONFIRM_CLICK,
    CHAT_ROOM_CREATE_SHOW,
    CHAT_ROOM_EMOJI_ENTER_CLICK,
    CHAT_ROOM_ENTER_APPROVE_CLICK,
    CHAT_ROOM_ENTER_CLICK,
    CHAT_ROOM_EXIT_BTN_CLICK,
    CHAT_ROOM_FOLLOW_CLICK,
    CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK,
    CHAT_ROOM_FOLLOW_GUIDE_SHOW,
    CHAT_ROOM_FOLLOW_MORE_CLICK,
    CHAT_ROOM_FOLLOW_ROOM_CLICK,
    CHAT_ROOM_FOLLOW_ROOM_SHOW,
    CHAT_ROOM_GIFT_CLICK,
    CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK,
    CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW,
    CHAT_ROOM_GIFT_POP_SEND_CLICK,
    CHAT_ROOM_GIFT_POP_SHOW,
    CHAT_ROOM_HOME_PAGE_TAB_SHOW,
    CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK,
    CHAT_ROOM_INSTRUCTION,
    CHAT_ROOM_INVITE_CLICK,
    CHAT_ROOM_INVITE_POP_SHOW,
    CHAT_ROOM_KICK_OUT_CLICK,
    CHAT_ROOM_KICK_OUT_CONFIRM_CLICK,
    CHAT_ROOM_LIKE_CLICK,
    CHAT_ROOM_LIST_CLICK,
    CHAT_ROOM_LIST_PAGE_GET_SHOW,
    CHAT_ROOM_LIST_PAGE_SEND_SHOW,
    CHAT_ROOM_MANAGER_MAX_SHOW,
    CHAT_ROOM_MIKE_CLICK,
    CHAT_ROOM_MIKE_CONFIRM_CLICK,
    CHAT_ROOM_MIKE_POP_ACCEPT_CLICK,
    CHAT_ROOM_MIKE_POP_AUTO_SUCCESS,
    CHAT_ROOM_MIKE_POP_REFUSE_CLICK,
    CHAT_ROOM_MIKE_POP_SHOW,
    CHAT_ROOM_MIKE_REFUSE_SHOW,
    CHAT_ROOM_MIKE_SUCCESS_SHOW,
    CHAT_ROOM_MIKE_USER_ACCEPT_CLICK,
    CHAT_ROOM_MIKE_USER_REFUSE_CLICK,
    CHAT_ROOM_MINE_ENTER_SHOW,
    CHAT_ROOM_MINE_REPORT_CLICK,
    CHAT_ROOM_MINE_REPORT_SHOW,
    CHAT_ROOM_MINIMIZED_WINDOW_CLICK,
    CHAT_ROOM_MUTE_BTN_CLICK,
    CHAT_ROOM_MUTE_CLICK,
    CHAT_ROOM_NAME_CHANGE_CLICK,
    CHAT_ROOM_NAME_INVALITE_SHOW,
    CHAT_ROOM_NOTICE_CANCEL_CLICK,
    CHAT_ROOM_NOTICE_CLICK,
    CHAT_ROOM_NOTICE_SAVE_CLICK,
    CHAT_ROOM_OUT_MIKE,
    CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW,
    CHAT_ROOM_PHONE_BIND_CLICK,
    CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK,
    CHAT_ROOM_PHONE_BIND_SHOW,
    CHAT_ROOM_PROFILE_AT_CLICK,
    CHAT_ROOM_PROFILE_BLACK_CLICK,
    CHAT_ROOM_PROFILE_BLOCK_CLICK,
    CHAT_ROOM_PROFILE_ENTER_CLICK,
    CHAT_ROOM_PROFILE_ENTER_SHOW,
    CHAT_ROOM_PROFILE_FORBID_CLICK,
    CHAT_ROOM_PROFILE_GIFT_CLICK,
    CHAT_ROOM_PROFILE_GO_CLICK,
    CHAT_ROOM_PROFILE_MIKE_CLICK,
    CHAT_ROOM_PROFILE_MSG_CLICK,
    CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK,
    CHAT_ROOM_PROFILE_REPORT_CLICK,
    CHAT_ROOM_RECHARGE_CLICK,
    CHAT_ROOM_REFUSE_CLICK,
    CHAT_ROOM_REPORT_ROOM_CLICK,
    CHAT_ROOM_SEND_GIFT_CLICK,
    CHAT_ROOM_SEND_GIFT_SHOW,
    CHAT_ROOM_SEND_MSG_CLICK,
    CHAT_ROOM_SET_MANAGER_CLICK,
    CHAT_ROOM_SHARE_CHANNEL_CLICK,
    CHAT_ROOM_SHARE_CLICK,
    CHAT_ROOM_TAB_PAGE_ROOM_CLICK,
    CHAT_ROOM_TAB_PAGE_ROOM_DRAW,
    CHAT_ROOM_TOOLBOX_CLICK,
    CHAT_ROOM_TOOLBOX_EMOJI_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW,
    CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK,
    CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW,
    CHAT_ROOM_UNFOLLOW,
    CHAT_ROOM_UNMUTE_BTN_CLICK,
    CHAT_ROOM_USER_INVITE_CLICK,
    CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW,
    CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK,
    CHAT_ROOM_VOTE_ICON_CLICK,
    CHAT_ROOM_VOTE_LAUNCH_CLICK,
    CHAT_ROOM_VOTE_USER_CLICK,
    CHAT_ROOM_VOTE_WINDOW_CLICK,
    CHAT_ROOM_WARN_POP_SHOW,
    NO_MONEY_POP_RECHARGE_CLICK,
    NO_MONEY_POP_SHOW,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int CHAT_ROOM_ACCEPT_CLICK_VALUE = 36;
    
    public static final int CHAT_ROOM_APPROVE_GUIDE_CLICK_VALUE = 27;
    
    public static final int CHAT_ROOM_APPROVE_GUIDE_SHOW_VALUE = 26;
    
    public static final int CHAT_ROOM_BANNER_CLICK_VALUE = 29;
    
    public static final int CHAT_ROOM_BANNER_SHOW_VALUE = 28;
    
    public static final int CHAT_ROOM_BG_ENTER_CLICK_VALUE = 109;
    
    public static final int CHAT_ROOM_BG_SOMEONE_CLICK_VALUE = 110;
    
    public static final int CHAT_ROOM_CHANGE_MIC_BTN_CLICK_VALUE = 137;
    
    public static final int CHAT_ROOM_CP_MATCH_START_VALUE = 128;
    
    public static final int CHAT_ROOM_CP_MATCH_SUCCEED_VALUE = 129;
    
    public static final int CHAT_ROOM_CREATE_CLICK_VALUE = 11;
    
    public static final int CHAT_ROOM_CREATE_CONFIRM_CLICK_VALUE = 12;
    
    public static final int CHAT_ROOM_CREATE_SHOW_VALUE = 10;
    
    public static final int CHAT_ROOM_EMOJI_ENTER_CLICK_VALUE = 103;
    
    public static final int CHAT_ROOM_ENTER_APPROVE_CLICK_VALUE = 90;
    
    public static final int CHAT_ROOM_ENTER_CLICK_VALUE = 6;
    
    public static final int CHAT_ROOM_EXIT_BTN_CLICK_VALUE = 40;
    
    public static final int CHAT_ROOM_FOLLOW_CLICK_VALUE = 42;
    
    public static final int CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK_VALUE = 46;
    
    public static final int CHAT_ROOM_FOLLOW_GUIDE_SHOW_VALUE = 45;
    
    public static final int CHAT_ROOM_FOLLOW_MORE_CLICK_VALUE = 100;
    
    public static final int CHAT_ROOM_FOLLOW_ROOM_CLICK_VALUE = 102;
    
    public static final int CHAT_ROOM_FOLLOW_ROOM_SHOW_VALUE = 101;
    
    public static final int CHAT_ROOM_GIFT_CLICK_VALUE = 81;
    
    public static final int CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK_VALUE = 112;
    
    public static final int CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW_VALUE = 111;
    
    public static final int CHAT_ROOM_GIFT_POP_SEND_CLICK_VALUE = 85;
    
    public static final int CHAT_ROOM_GIFT_POP_SHOW_VALUE = 84;
    
    public static final int CHAT_ROOM_HOME_PAGE_TAB_SHOW_VALUE = 7;
    
    public static final int CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK_VALUE = 134;
    
    public static final int CHAT_ROOM_INSTRUCTION_VALUE = 127;
    
    public static final int CHAT_ROOM_INVITE_CLICK_VALUE = 30;
    
    public static final int CHAT_ROOM_INVITE_POP_SHOW_VALUE = 34;
    
    public static final int CHAT_ROOM_KICK_OUT_CLICK_VALUE = 31;
    
    public static final int CHAT_ROOM_KICK_OUT_CONFIRM_CLICK_VALUE = 32;
    
    public static final int CHAT_ROOM_LIKE_CLICK_VALUE = 80;
    
    public static final int CHAT_ROOM_LIST_CLICK_VALUE = 72;
    
    public static final int CHAT_ROOM_LIST_PAGE_GET_SHOW_VALUE = 73;
    
    public static final int CHAT_ROOM_LIST_PAGE_SEND_SHOW_VALUE = 74;
    
    public static final int CHAT_ROOM_MANAGER_MAX_SHOW_VALUE = 39;
    
    public static final int CHAT_ROOM_MIKE_CLICK_VALUE = 53;
    
    public static final int CHAT_ROOM_MIKE_CONFIRM_CLICK_VALUE = 55;
    
    public static final int CHAT_ROOM_MIKE_POP_ACCEPT_CLICK_VALUE = 60;
    
    public static final int CHAT_ROOM_MIKE_POP_AUTO_SUCCESS_VALUE = 61;
    
    public static final int CHAT_ROOM_MIKE_POP_REFUSE_CLICK_VALUE = 59;
    
    public static final int CHAT_ROOM_MIKE_POP_SHOW_VALUE = 58;
    
    public static final int CHAT_ROOM_MIKE_REFUSE_SHOW_VALUE = 57;
    
    public static final int CHAT_ROOM_MIKE_SUCCESS_SHOW_VALUE = 56;
    
    public static final int CHAT_ROOM_MIKE_USER_ACCEPT_CLICK_VALUE = 63;
    
    public static final int CHAT_ROOM_MIKE_USER_REFUSE_CLICK_VALUE = 62;
    
    public static final int CHAT_ROOM_MINE_ENTER_SHOW_VALUE = 5;
    
    public static final int CHAT_ROOM_MINE_REPORT_CLICK_VALUE = 4;
    
    public static final int CHAT_ROOM_MINE_REPORT_SHOW_VALUE = 3;
    
    public static final int CHAT_ROOM_MINIMIZED_WINDOW_CLICK_VALUE = 122;
    
    public static final int CHAT_ROOM_MUTE_BTN_CLICK_VALUE = 135;
    
    public static final int CHAT_ROOM_MUTE_CLICK_VALUE = 33;
    
    public static final int CHAT_ROOM_NAME_CHANGE_CLICK_VALUE = 88;
    
    public static final int CHAT_ROOM_NAME_INVALITE_SHOW_VALUE = 13;
    
    public static final int CHAT_ROOM_NOTICE_CANCEL_CLICK_VALUE = 93;
    
    public static final int CHAT_ROOM_NOTICE_CLICK_VALUE = 91;
    
    public static final int CHAT_ROOM_NOTICE_SAVE_CLICK_VALUE = 92;
    
    public static final int CHAT_ROOM_OUT_MIKE_VALUE = 37;
    
    public static final int CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW_VALUE = 77;
    
    public static final int CHAT_ROOM_PHONE_BIND_CLICK_VALUE = 89;
    
    public static final int CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK_VALUE = 139;
    
    public static final int CHAT_ROOM_PHONE_BIND_SHOW_VALUE = 138;
    
    public static final int CHAT_ROOM_PROFILE_AT_CLICK_VALUE = 67;
    
    public static final int CHAT_ROOM_PROFILE_BLACK_CLICK_VALUE = 71;
    
    public static final int CHAT_ROOM_PROFILE_BLOCK_CLICK_VALUE = 99;
    
    public static final int CHAT_ROOM_PROFILE_ENTER_CLICK_VALUE = 2;
    
    public static final int CHAT_ROOM_PROFILE_ENTER_SHOW_VALUE = 1;
    
    public static final int CHAT_ROOM_PROFILE_FORBID_CLICK_VALUE = 96;
    
    public static final int CHAT_ROOM_PROFILE_GIFT_CLICK_VALUE = 69;
    
    public static final int CHAT_ROOM_PROFILE_GO_CLICK_VALUE = 65;
    
    public static final int CHAT_ROOM_PROFILE_MIKE_CLICK_VALUE = 54;
    
    public static final int CHAT_ROOM_PROFILE_MSG_CLICK_VALUE = 68;
    
    public static final int CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK_VALUE = 97;
    
    public static final int CHAT_ROOM_PROFILE_REPORT_CLICK_VALUE = 70;
    
    public static final int CHAT_ROOM_RECHARGE_CLICK_VALUE = 49;
    
    public static final int CHAT_ROOM_REFUSE_CLICK_VALUE = 35;
    
    public static final int CHAT_ROOM_REPORT_ROOM_CLICK_VALUE = 41;
    
    public static final int CHAT_ROOM_SEND_GIFT_CLICK_VALUE = 48;
    
    public static final int CHAT_ROOM_SEND_GIFT_SHOW_VALUE = 47;
    
    public static final int CHAT_ROOM_SEND_MSG_CLICK_VALUE = 64;
    
    public static final int CHAT_ROOM_SET_MANAGER_CLICK_VALUE = 38;
    
    public static final int CHAT_ROOM_SHARE_CHANNEL_CLICK_VALUE = 52;
    
    public static final int CHAT_ROOM_SHARE_CLICK_VALUE = 51;
    
    public static final int CHAT_ROOM_TAB_PAGE_ROOM_CLICK_VALUE = 9;
    
    public static final int CHAT_ROOM_TAB_PAGE_ROOM_DRAW_VALUE = 8;
    
    public static final int CHAT_ROOM_TOOLBOX_CLICK_VALUE = 94;
    
    public static final int CHAT_ROOM_TOOLBOX_EMOJI_CLICK_VALUE = 95;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK_VALUE = 120;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK_VALUE = 118;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK_VALUE = 116;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK_VALUE = 117;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK_VALUE = 113;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK_VALUE = 115;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW_VALUE = 114;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK_VALUE = 106;
    
    public static final int CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW_VALUE = 121;
    
    public static final int CHAT_ROOM_UNFOLLOW_VALUE = 44;
    
    public static final int CHAT_ROOM_UNMUTE_BTN_CLICK_VALUE = 136;
    
    public static final int CHAT_ROOM_USER_INVITE_CLICK_VALUE = 107;
    
    public static final int CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW_VALUE = 76;
    
    public static final int CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK_VALUE = 66;
    
    public static final int CHAT_ROOM_VOTE_ICON_CLICK_VALUE = 123;
    
    public static final int CHAT_ROOM_VOTE_LAUNCH_CLICK_VALUE = 124;
    
    public static final int CHAT_ROOM_VOTE_USER_CLICK_VALUE = 126;
    
    public static final int CHAT_ROOM_VOTE_WINDOW_CLICK_VALUE = 125;
    
    public static final int CHAT_ROOM_WARN_POP_SHOW_VALUE = 75;
    
    public static final int NO_MONEY_POP_RECHARGE_CLICK_VALUE = 87;
    
    public static final int NO_MONEY_POP_SHOW_VALUE = 86;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      CHAT_ROOM_PROFILE_ENTER_CLICK = new Event("CHAT_ROOM_PROFILE_ENTER_CLICK", 2, 2);
      CHAT_ROOM_MINE_REPORT_SHOW = new Event("CHAT_ROOM_MINE_REPORT_SHOW", 3, 3);
      CHAT_ROOM_MINE_REPORT_CLICK = new Event("CHAT_ROOM_MINE_REPORT_CLICK", 4, 4);
      CHAT_ROOM_MINE_ENTER_SHOW = new Event("CHAT_ROOM_MINE_ENTER_SHOW", 5, 5);
      CHAT_ROOM_ENTER_CLICK = new Event("CHAT_ROOM_ENTER_CLICK", 6, 6);
      CHAT_ROOM_HOME_PAGE_TAB_SHOW = new Event("CHAT_ROOM_HOME_PAGE_TAB_SHOW", 7, 7);
      CHAT_ROOM_TAB_PAGE_ROOM_DRAW = new Event("CHAT_ROOM_TAB_PAGE_ROOM_DRAW", 8, 8);
      CHAT_ROOM_TAB_PAGE_ROOM_CLICK = new Event("CHAT_ROOM_TAB_PAGE_ROOM_CLICK", 9, 9);
      CHAT_ROOM_CREATE_SHOW = new Event("CHAT_ROOM_CREATE_SHOW", 10, 10);
      CHAT_ROOM_CREATE_CLICK = new Event("CHAT_ROOM_CREATE_CLICK", 11, 11);
      CHAT_ROOM_CREATE_CONFIRM_CLICK = new Event("CHAT_ROOM_CREATE_CONFIRM_CLICK", 12, 12);
      CHAT_ROOM_NAME_INVALITE_SHOW = new Event("CHAT_ROOM_NAME_INVALITE_SHOW", 13, 13);
      CHAT_ROOM_APPROVE_GUIDE_SHOW = new Event("CHAT_ROOM_APPROVE_GUIDE_SHOW", 14, 26);
      CHAT_ROOM_APPROVE_GUIDE_CLICK = new Event("CHAT_ROOM_APPROVE_GUIDE_CLICK", 15, 27);
      CHAT_ROOM_BANNER_SHOW = new Event("CHAT_ROOM_BANNER_SHOW", 16, 28);
      CHAT_ROOM_BANNER_CLICK = new Event("CHAT_ROOM_BANNER_CLICK", 17, 29);
      CHAT_ROOM_INVITE_CLICK = new Event("CHAT_ROOM_INVITE_CLICK", 18, 30);
      CHAT_ROOM_KICK_OUT_CLICK = new Event("CHAT_ROOM_KICK_OUT_CLICK", 19, 31);
      CHAT_ROOM_KICK_OUT_CONFIRM_CLICK = new Event("CHAT_ROOM_KICK_OUT_CONFIRM_CLICK", 20, 32);
      CHAT_ROOM_MUTE_CLICK = new Event("CHAT_ROOM_MUTE_CLICK", 21, 33);
      CHAT_ROOM_INVITE_POP_SHOW = new Event("CHAT_ROOM_INVITE_POP_SHOW", 22, 34);
      CHAT_ROOM_REFUSE_CLICK = new Event("CHAT_ROOM_REFUSE_CLICK", 23, 35);
      CHAT_ROOM_ACCEPT_CLICK = new Event("CHAT_ROOM_ACCEPT_CLICK", 24, 36);
      CHAT_ROOM_OUT_MIKE = new Event("CHAT_ROOM_OUT_MIKE", 25, 37);
      CHAT_ROOM_SET_MANAGER_CLICK = new Event("CHAT_ROOM_SET_MANAGER_CLICK", 26, 38);
      CHAT_ROOM_MANAGER_MAX_SHOW = new Event("CHAT_ROOM_MANAGER_MAX_SHOW", 27, 39);
      CHAT_ROOM_EXIT_BTN_CLICK = new Event("CHAT_ROOM_EXIT_BTN_CLICK", 28, 40);
      CHAT_ROOM_REPORT_ROOM_CLICK = new Event("CHAT_ROOM_REPORT_ROOM_CLICK", 29, 41);
      CHAT_ROOM_FOLLOW_CLICK = new Event("CHAT_ROOM_FOLLOW_CLICK", 30, 42);
      CHAT_ROOM_UNFOLLOW = new Event("CHAT_ROOM_UNFOLLOW", 31, 44);
      CHAT_ROOM_FOLLOW_GUIDE_SHOW = new Event("CHAT_ROOM_FOLLOW_GUIDE_SHOW", 32, 45);
      CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK = new Event("CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK", 33, 46);
      CHAT_ROOM_SEND_GIFT_SHOW = new Event("CHAT_ROOM_SEND_GIFT_SHOW", 34, 47);
      CHAT_ROOM_SEND_GIFT_CLICK = new Event("CHAT_ROOM_SEND_GIFT_CLICK", 35, 48);
      CHAT_ROOM_RECHARGE_CLICK = new Event("CHAT_ROOM_RECHARGE_CLICK", 36, 49);
      CHAT_ROOM_SHARE_CLICK = new Event("CHAT_ROOM_SHARE_CLICK", 37, 51);
      CHAT_ROOM_SHARE_CHANNEL_CLICK = new Event("CHAT_ROOM_SHARE_CHANNEL_CLICK", 38, 52);
      CHAT_ROOM_MIKE_CLICK = new Event("CHAT_ROOM_MIKE_CLICK", 39, 53);
      CHAT_ROOM_PROFILE_MIKE_CLICK = new Event("CHAT_ROOM_PROFILE_MIKE_CLICK", 40, 54);
      CHAT_ROOM_MIKE_CONFIRM_CLICK = new Event("CHAT_ROOM_MIKE_CONFIRM_CLICK", 41, 55);
      CHAT_ROOM_MIKE_SUCCESS_SHOW = new Event("CHAT_ROOM_MIKE_SUCCESS_SHOW", 42, 56);
      CHAT_ROOM_MIKE_REFUSE_SHOW = new Event("CHAT_ROOM_MIKE_REFUSE_SHOW", 43, 57);
      CHAT_ROOM_MIKE_POP_SHOW = new Event("CHAT_ROOM_MIKE_POP_SHOW", 44, 58);
      CHAT_ROOM_MIKE_POP_REFUSE_CLICK = new Event("CHAT_ROOM_MIKE_POP_REFUSE_CLICK", 45, 59);
      CHAT_ROOM_MIKE_POP_ACCEPT_CLICK = new Event("CHAT_ROOM_MIKE_POP_ACCEPT_CLICK", 46, 60);
      CHAT_ROOM_MIKE_POP_AUTO_SUCCESS = new Event("CHAT_ROOM_MIKE_POP_AUTO_SUCCESS", 47, 61);
      CHAT_ROOM_MIKE_USER_REFUSE_CLICK = new Event("CHAT_ROOM_MIKE_USER_REFUSE_CLICK", 48, 62);
      CHAT_ROOM_MIKE_USER_ACCEPT_CLICK = new Event("CHAT_ROOM_MIKE_USER_ACCEPT_CLICK", 49, 63);
      CHAT_ROOM_SEND_MSG_CLICK = new Event("CHAT_ROOM_SEND_MSG_CLICK", 50, 64);
      CHAT_ROOM_PROFILE_GO_CLICK = new Event("CHAT_ROOM_PROFILE_GO_CLICK", 51, 65);
      CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK = new Event("CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK", 52, 66);
      CHAT_ROOM_PROFILE_AT_CLICK = new Event("CHAT_ROOM_PROFILE_AT_CLICK", 53, 67);
      CHAT_ROOM_PROFILE_MSG_CLICK = new Event("CHAT_ROOM_PROFILE_MSG_CLICK", 54, 68);
      CHAT_ROOM_PROFILE_GIFT_CLICK = new Event("CHAT_ROOM_PROFILE_GIFT_CLICK", 55, 69);
      CHAT_ROOM_PROFILE_REPORT_CLICK = new Event("CHAT_ROOM_PROFILE_REPORT_CLICK", 56, 70);
      CHAT_ROOM_PROFILE_BLACK_CLICK = new Event("CHAT_ROOM_PROFILE_BLACK_CLICK", 57, 71);
      CHAT_ROOM_LIST_CLICK = new Event("CHAT_ROOM_LIST_CLICK", 58, 72);
      CHAT_ROOM_LIST_PAGE_GET_SHOW = new Event("CHAT_ROOM_LIST_PAGE_GET_SHOW", 59, 73);
      CHAT_ROOM_LIST_PAGE_SEND_SHOW = new Event("CHAT_ROOM_LIST_PAGE_SEND_SHOW", 60, 74);
      CHAT_ROOM_WARN_POP_SHOW = new Event("CHAT_ROOM_WARN_POP_SHOW", 61, 75);
      CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW = new Event("CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW", 62, 76);
      CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW = new Event("CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW", 63, 77);
      CHAT_ROOM_LIKE_CLICK = new Event("CHAT_ROOM_LIKE_CLICK", 64, 80);
      CHAT_ROOM_GIFT_CLICK = new Event("CHAT_ROOM_GIFT_CLICK", 65, 81);
      CHAT_ROOM_GIFT_POP_SHOW = new Event("CHAT_ROOM_GIFT_POP_SHOW", 66, 84);
      CHAT_ROOM_GIFT_POP_SEND_CLICK = new Event("CHAT_ROOM_GIFT_POP_SEND_CLICK", 67, 85);
      NO_MONEY_POP_SHOW = new Event("NO_MONEY_POP_SHOW", 68, 86);
      NO_MONEY_POP_RECHARGE_CLICK = new Event("NO_MONEY_POP_RECHARGE_CLICK", 69, 87);
      CHAT_ROOM_NAME_CHANGE_CLICK = new Event("CHAT_ROOM_NAME_CHANGE_CLICK", 70, 88);
      CHAT_ROOM_PHONE_BIND_CLICK = new Event("CHAT_ROOM_PHONE_BIND_CLICK", 71, 89);
      CHAT_ROOM_ENTER_APPROVE_CLICK = new Event("CHAT_ROOM_ENTER_APPROVE_CLICK", 72, 90);
      CHAT_ROOM_NOTICE_CLICK = new Event("CHAT_ROOM_NOTICE_CLICK", 73, 91);
      CHAT_ROOM_NOTICE_SAVE_CLICK = new Event("CHAT_ROOM_NOTICE_SAVE_CLICK", 74, 92);
      CHAT_ROOM_NOTICE_CANCEL_CLICK = new Event("CHAT_ROOM_NOTICE_CANCEL_CLICK", 75, 93);
      CHAT_ROOM_TOOLBOX_CLICK = new Event("CHAT_ROOM_TOOLBOX_CLICK", 76, 94);
      CHAT_ROOM_TOOLBOX_EMOJI_CLICK = new Event("CHAT_ROOM_TOOLBOX_EMOJI_CLICK", 77, 95);
      CHAT_ROOM_PROFILE_FORBID_CLICK = new Event("CHAT_ROOM_PROFILE_FORBID_CLICK", 78, 96);
      CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK = new Event("CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK", 79, 97);
      CHAT_ROOM_PROFILE_BLOCK_CLICK = new Event("CHAT_ROOM_PROFILE_BLOCK_CLICK", 80, 99);
      CHAT_ROOM_FOLLOW_MORE_CLICK = new Event("CHAT_ROOM_FOLLOW_MORE_CLICK", 81, 100);
      CHAT_ROOM_FOLLOW_ROOM_SHOW = new Event("CHAT_ROOM_FOLLOW_ROOM_SHOW", 82, 101);
      CHAT_ROOM_FOLLOW_ROOM_CLICK = new Event("CHAT_ROOM_FOLLOW_ROOM_CLICK", 83, 102);
      CHAT_ROOM_EMOJI_ENTER_CLICK = new Event("CHAT_ROOM_EMOJI_ENTER_CLICK", 84, 103);
      CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK", 85, 106);
      CHAT_ROOM_USER_INVITE_CLICK = new Event("CHAT_ROOM_USER_INVITE_CLICK", 86, 107);
      CHAT_ROOM_BG_ENTER_CLICK = new Event("CHAT_ROOM_BG_ENTER_CLICK", 87, 109);
      CHAT_ROOM_BG_SOMEONE_CLICK = new Event("CHAT_ROOM_BG_SOMEONE_CLICK", 88, 110);
      CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW = new Event("CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW", 89, 111);
      CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK = new Event("CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK", 90, 112);
      CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK", 91, 113);
      CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW = new Event("CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW", 92, 114);
      CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK", 93, 115);
      CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK", 94, 116);
      CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK", 95, 117);
      CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK", 96, 118);
      CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK = new Event("CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK", 97, 120);
      CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW = new Event("CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW", 98, 121);
      CHAT_ROOM_MINIMIZED_WINDOW_CLICK = new Event("CHAT_ROOM_MINIMIZED_WINDOW_CLICK", 99, 122);
      CHAT_ROOM_VOTE_ICON_CLICK = new Event("CHAT_ROOM_VOTE_ICON_CLICK", 100, 123);
      CHAT_ROOM_VOTE_LAUNCH_CLICK = new Event("CHAT_ROOM_VOTE_LAUNCH_CLICK", 101, 124);
      CHAT_ROOM_VOTE_WINDOW_CLICK = new Event("CHAT_ROOM_VOTE_WINDOW_CLICK", 102, 125);
      CHAT_ROOM_VOTE_USER_CLICK = new Event("CHAT_ROOM_VOTE_USER_CLICK", 103, 126);
      CHAT_ROOM_INSTRUCTION = new Event("CHAT_ROOM_INSTRUCTION", 104, 127);
      CHAT_ROOM_CP_MATCH_START = new Event("CHAT_ROOM_CP_MATCH_START", 105, 128);
      CHAT_ROOM_CP_MATCH_SUCCEED = new Event("CHAT_ROOM_CP_MATCH_SUCCEED", 106, 129);
      CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK = new Event("CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK", 107, 134);
      CHAT_ROOM_MUTE_BTN_CLICK = new Event("CHAT_ROOM_MUTE_BTN_CLICK", 108, 135);
      CHAT_ROOM_UNMUTE_BTN_CLICK = new Event("CHAT_ROOM_UNMUTE_BTN_CLICK", 109, 136);
      CHAT_ROOM_CHANGE_MIC_BTN_CLICK = new Event("CHAT_ROOM_CHANGE_MIC_BTN_CLICK", 110, 137);
      CHAT_ROOM_PHONE_BIND_SHOW = new Event("CHAT_ROOM_PHONE_BIND_SHOW", 111, 138);
      CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK = new Event("CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK", 112, 139);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 113, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, CHAT_ROOM_PROFILE_ENTER_SHOW, CHAT_ROOM_PROFILE_ENTER_CLICK, CHAT_ROOM_MINE_REPORT_SHOW, CHAT_ROOM_MINE_REPORT_CLICK, CHAT_ROOM_MINE_ENTER_SHOW, CHAT_ROOM_ENTER_CLICK, CHAT_ROOM_HOME_PAGE_TAB_SHOW, CHAT_ROOM_TAB_PAGE_ROOM_DRAW, CHAT_ROOM_TAB_PAGE_ROOM_CLICK, 
          CHAT_ROOM_CREATE_SHOW, CHAT_ROOM_CREATE_CLICK, CHAT_ROOM_CREATE_CONFIRM_CLICK, CHAT_ROOM_NAME_INVALITE_SHOW, CHAT_ROOM_APPROVE_GUIDE_SHOW, CHAT_ROOM_APPROVE_GUIDE_CLICK, CHAT_ROOM_BANNER_SHOW, CHAT_ROOM_BANNER_CLICK, CHAT_ROOM_INVITE_CLICK, CHAT_ROOM_KICK_OUT_CLICK, 
          CHAT_ROOM_KICK_OUT_CONFIRM_CLICK, CHAT_ROOM_MUTE_CLICK, CHAT_ROOM_INVITE_POP_SHOW, CHAT_ROOM_REFUSE_CLICK, CHAT_ROOM_ACCEPT_CLICK, CHAT_ROOM_OUT_MIKE, CHAT_ROOM_SET_MANAGER_CLICK, CHAT_ROOM_MANAGER_MAX_SHOW, CHAT_ROOM_EXIT_BTN_CLICK, CHAT_ROOM_REPORT_ROOM_CLICK, 
          CHAT_ROOM_FOLLOW_CLICK, CHAT_ROOM_UNFOLLOW, CHAT_ROOM_FOLLOW_GUIDE_SHOW, CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK, CHAT_ROOM_SEND_GIFT_SHOW, CHAT_ROOM_SEND_GIFT_CLICK, CHAT_ROOM_RECHARGE_CLICK, CHAT_ROOM_SHARE_CLICK, CHAT_ROOM_SHARE_CHANNEL_CLICK, CHAT_ROOM_MIKE_CLICK, 
          CHAT_ROOM_PROFILE_MIKE_CLICK, CHAT_ROOM_MIKE_CONFIRM_CLICK, CHAT_ROOM_MIKE_SUCCESS_SHOW, CHAT_ROOM_MIKE_REFUSE_SHOW, CHAT_ROOM_MIKE_POP_SHOW, CHAT_ROOM_MIKE_POP_REFUSE_CLICK, CHAT_ROOM_MIKE_POP_ACCEPT_CLICK, CHAT_ROOM_MIKE_POP_AUTO_SUCCESS, CHAT_ROOM_MIKE_USER_REFUSE_CLICK, CHAT_ROOM_MIKE_USER_ACCEPT_CLICK, 
          CHAT_ROOM_SEND_MSG_CLICK, CHAT_ROOM_PROFILE_GO_CLICK, CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK, CHAT_ROOM_PROFILE_AT_CLICK, CHAT_ROOM_PROFILE_MSG_CLICK, CHAT_ROOM_PROFILE_GIFT_CLICK, CHAT_ROOM_PROFILE_REPORT_CLICK, CHAT_ROOM_PROFILE_BLACK_CLICK, CHAT_ROOM_LIST_CLICK, CHAT_ROOM_LIST_PAGE_GET_SHOW, 
          CHAT_ROOM_LIST_PAGE_SEND_SHOW, CHAT_ROOM_WARN_POP_SHOW, CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW, CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW, CHAT_ROOM_LIKE_CLICK, CHAT_ROOM_GIFT_CLICK, CHAT_ROOM_GIFT_POP_SHOW, CHAT_ROOM_GIFT_POP_SEND_CLICK, NO_MONEY_POP_SHOW, NO_MONEY_POP_RECHARGE_CLICK, 
          CHAT_ROOM_NAME_CHANGE_CLICK, CHAT_ROOM_PHONE_BIND_CLICK, CHAT_ROOM_ENTER_APPROVE_CLICK, CHAT_ROOM_NOTICE_CLICK, CHAT_ROOM_NOTICE_SAVE_CLICK, CHAT_ROOM_NOTICE_CANCEL_CLICK, CHAT_ROOM_TOOLBOX_CLICK, CHAT_ROOM_TOOLBOX_EMOJI_CLICK, CHAT_ROOM_PROFILE_FORBID_CLICK, CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK, 
          CHAT_ROOM_PROFILE_BLOCK_CLICK, CHAT_ROOM_FOLLOW_MORE_CLICK, CHAT_ROOM_FOLLOW_ROOM_SHOW, CHAT_ROOM_FOLLOW_ROOM_CLICK, CHAT_ROOM_EMOJI_ENTER_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK, CHAT_ROOM_USER_INVITE_CLICK, CHAT_ROOM_BG_ENTER_CLICK, CHAT_ROOM_BG_SOMEONE_CLICK, CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW, 
          CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW, CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK, CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW, CHAT_ROOM_MINIMIZED_WINDOW_CLICK, 
          CHAT_ROOM_VOTE_ICON_CLICK, CHAT_ROOM_VOTE_LAUNCH_CLICK, CHAT_ROOM_VOTE_WINDOW_CLICK, CHAT_ROOM_VOTE_USER_CLICK, CHAT_ROOM_INSTRUCTION, CHAT_ROOM_CP_MATCH_START, CHAT_ROOM_CP_MATCH_SUCCEED, CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK, CHAT_ROOM_MUTE_BTN_CLICK, CHAT_ROOM_UNMUTE_BTN_CLICK, 
          CHAT_ROOM_CHANGE_MIC_BTN_CLICK, CHAT_ROOM_PHONE_BIND_SHOW, CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public ChatRoomProtos.Event findValueByNumber(int param2Int) {
            return ChatRoomProtos.Event.forNumber(param2Int);
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
        case 139:
          return CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK;
        case 138:
          return CHAT_ROOM_PHONE_BIND_SHOW;
        case 137:
          return CHAT_ROOM_CHANGE_MIC_BTN_CLICK;
        case 136:
          return CHAT_ROOM_UNMUTE_BTN_CLICK;
        case 135:
          return CHAT_ROOM_MUTE_BTN_CLICK;
        case 134:
          return CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK;
        case 129:
          return CHAT_ROOM_CP_MATCH_SUCCEED;
        case 128:
          return CHAT_ROOM_CP_MATCH_START;
        case 127:
          return CHAT_ROOM_INSTRUCTION;
        case 126:
          return CHAT_ROOM_VOTE_USER_CLICK;
        case 125:
          return CHAT_ROOM_VOTE_WINDOW_CLICK;
        case 124:
          return CHAT_ROOM_VOTE_LAUNCH_CLICK;
        case 123:
          return CHAT_ROOM_VOTE_ICON_CLICK;
        case 122:
          return CHAT_ROOM_MINIMIZED_WINDOW_CLICK;
        case 121:
          return CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW;
        case 120:
          return CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK;
        case 118:
          return CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK;
        case 117:
          return CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK;
        case 116:
          return CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK;
        case 115:
          return CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK;
        case 114:
          return CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW;
        case 113:
          return CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK;
        case 112:
          return CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK;
        case 111:
          return CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW;
        case 110:
          return CHAT_ROOM_BG_SOMEONE_CLICK;
        case 109:
          return CHAT_ROOM_BG_ENTER_CLICK;
        case 107:
          return CHAT_ROOM_USER_INVITE_CLICK;
        case 106:
          return CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK;
        case 103:
          return CHAT_ROOM_EMOJI_ENTER_CLICK;
        case 102:
          return CHAT_ROOM_FOLLOW_ROOM_CLICK;
        case 101:
          return CHAT_ROOM_FOLLOW_ROOM_SHOW;
        case 100:
          return CHAT_ROOM_FOLLOW_MORE_CLICK;
        case 99:
          return CHAT_ROOM_PROFILE_BLOCK_CLICK;
        case 97:
          return CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK;
        case 96:
          return CHAT_ROOM_PROFILE_FORBID_CLICK;
        case 95:
          return CHAT_ROOM_TOOLBOX_EMOJI_CLICK;
        case 94:
          return CHAT_ROOM_TOOLBOX_CLICK;
        case 93:
          return CHAT_ROOM_NOTICE_CANCEL_CLICK;
        case 92:
          return CHAT_ROOM_NOTICE_SAVE_CLICK;
        case 91:
          return CHAT_ROOM_NOTICE_CLICK;
        case 90:
          return CHAT_ROOM_ENTER_APPROVE_CLICK;
        case 89:
          return CHAT_ROOM_PHONE_BIND_CLICK;
        case 88:
          return CHAT_ROOM_NAME_CHANGE_CLICK;
        case 87:
          return NO_MONEY_POP_RECHARGE_CLICK;
        case 86:
          return NO_MONEY_POP_SHOW;
        case 85:
          return CHAT_ROOM_GIFT_POP_SEND_CLICK;
        case 84:
          return CHAT_ROOM_GIFT_POP_SHOW;
        case 81:
          return CHAT_ROOM_GIFT_CLICK;
        case 80:
          return CHAT_ROOM_LIKE_CLICK;
        case 77:
          return CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW;
        case 76:
          return CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW;
        case 75:
          return CHAT_ROOM_WARN_POP_SHOW;
        case 74:
          return CHAT_ROOM_LIST_PAGE_SEND_SHOW;
        case 73:
          return CHAT_ROOM_LIST_PAGE_GET_SHOW;
        case 72:
          return CHAT_ROOM_LIST_CLICK;
        case 71:
          return CHAT_ROOM_PROFILE_BLACK_CLICK;
        case 70:
          return CHAT_ROOM_PROFILE_REPORT_CLICK;
        case 69:
          return CHAT_ROOM_PROFILE_GIFT_CLICK;
        case 68:
          return CHAT_ROOM_PROFILE_MSG_CLICK;
        case 67:
          return CHAT_ROOM_PROFILE_AT_CLICK;
        case 66:
          return CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK;
        case 65:
          return CHAT_ROOM_PROFILE_GO_CLICK;
        case 64:
          return CHAT_ROOM_SEND_MSG_CLICK;
        case 63:
          return CHAT_ROOM_MIKE_USER_ACCEPT_CLICK;
        case 62:
          return CHAT_ROOM_MIKE_USER_REFUSE_CLICK;
        case 61:
          return CHAT_ROOM_MIKE_POP_AUTO_SUCCESS;
        case 60:
          return CHAT_ROOM_MIKE_POP_ACCEPT_CLICK;
        case 59:
          return CHAT_ROOM_MIKE_POP_REFUSE_CLICK;
        case 58:
          return CHAT_ROOM_MIKE_POP_SHOW;
        case 57:
          return CHAT_ROOM_MIKE_REFUSE_SHOW;
        case 56:
          return CHAT_ROOM_MIKE_SUCCESS_SHOW;
        case 55:
          return CHAT_ROOM_MIKE_CONFIRM_CLICK;
        case 54:
          return CHAT_ROOM_PROFILE_MIKE_CLICK;
        case 53:
          return CHAT_ROOM_MIKE_CLICK;
        case 52:
          return CHAT_ROOM_SHARE_CHANNEL_CLICK;
        case 51:
          return CHAT_ROOM_SHARE_CLICK;
        case 49:
          return CHAT_ROOM_RECHARGE_CLICK;
        case 48:
          return CHAT_ROOM_SEND_GIFT_CLICK;
        case 47:
          return CHAT_ROOM_SEND_GIFT_SHOW;
        case 46:
          return CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK;
        case 45:
          return CHAT_ROOM_FOLLOW_GUIDE_SHOW;
        case 44:
          return CHAT_ROOM_UNFOLLOW;
        case 42:
          return CHAT_ROOM_FOLLOW_CLICK;
        case 41:
          return CHAT_ROOM_REPORT_ROOM_CLICK;
        case 40:
          return CHAT_ROOM_EXIT_BTN_CLICK;
        case 39:
          return CHAT_ROOM_MANAGER_MAX_SHOW;
        case 38:
          return CHAT_ROOM_SET_MANAGER_CLICK;
        case 37:
          return CHAT_ROOM_OUT_MIKE;
        case 36:
          return CHAT_ROOM_ACCEPT_CLICK;
        case 35:
          return CHAT_ROOM_REFUSE_CLICK;
        case 34:
          return CHAT_ROOM_INVITE_POP_SHOW;
        case 33:
          return CHAT_ROOM_MUTE_CLICK;
        case 32:
          return CHAT_ROOM_KICK_OUT_CONFIRM_CLICK;
        case 31:
          return CHAT_ROOM_KICK_OUT_CLICK;
        case 30:
          return CHAT_ROOM_INVITE_CLICK;
        case 29:
          return CHAT_ROOM_BANNER_CLICK;
        case 28:
          return CHAT_ROOM_BANNER_SHOW;
        case 27:
          return CHAT_ROOM_APPROVE_GUIDE_CLICK;
        case 26:
          return CHAT_ROOM_APPROVE_GUIDE_SHOW;
        case 13:
          return CHAT_ROOM_NAME_INVALITE_SHOW;
        case 12:
          return CHAT_ROOM_CREATE_CONFIRM_CLICK;
        case 11:
          return CHAT_ROOM_CREATE_CLICK;
        case 10:
          return CHAT_ROOM_CREATE_SHOW;
        case 9:
          return CHAT_ROOM_TAB_PAGE_ROOM_CLICK;
        case 8:
          return CHAT_ROOM_TAB_PAGE_ROOM_DRAW;
        case 7:
          return CHAT_ROOM_HOME_PAGE_TAB_SHOW;
        case 6:
          return CHAT_ROOM_ENTER_CLICK;
        case 5:
          return CHAT_ROOM_MINE_ENTER_SHOW;
        case 4:
          return CHAT_ROOM_MINE_REPORT_CLICK;
        case 3:
          return CHAT_ROOM_MINE_REPORT_SHOW;
        case 2:
          return CHAT_ROOM_PROFILE_ENTER_CLICK;
        case 1:
          return CHAT_ROOM_PROFILE_ENTER_SHOW;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ChatRoomProtos.getDescriptor().getEnumTypes().get(0);
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
    public ChatRoomProtos.Event findValueByNumber(int param1Int) {
      return ChatRoomProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum From implements ProtocolMessageEnum {
    FOLLOW_ROOM_LIST(0),
    FOLLOW_ROOM_LIST_SECOND_PAGE(0),
    UNKNOWN_FROM(0),
    UNRECOGNIZED(0);
    
    public static final int FOLLOW_ROOM_LIST_SECOND_PAGE_VALUE = 2;
    
    public static final int FOLLOW_ROOM_LIST_VALUE = 1;
    
    public static final int UNKNOWN_FROM_VALUE = 0;
    
    private static final From[] VALUES;
    
    private static final Internal.EnumLiteMap<From> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new From[] { UNKNOWN_FROM, FOLLOW_ROOM_LIST, FOLLOW_ROOM_LIST_SECOND_PAGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<From>() {
          public ChatRoomProtos.From findValueByNumber(int param2Int) {
            return ChatRoomProtos.From.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    From(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static From forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : FOLLOW_ROOM_LIST_SECOND_PAGE) : FOLLOW_ROOM_LIST) : UNKNOWN_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ChatRoomProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<From> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<From> {
    public ChatRoomProtos.From findValueByNumber(int param1Int) {
      return ChatRoomProtos.From.forNumber(param1Int);
    }
  }
  
  public enum ShareChannel implements ProtocolMessageEnum {
    SHARE_FORWARD(0),
    SHARE_FRIEND(0),
    SHARE_FRIEND_CLUB(0),
    SHARE_QQ(0),
    SHARE_WECHAT(0),
    SHARE_WEIBO(0),
    UNKNOWN_SHARE_CHANNEL(0),
    UNRECOGNIZED(0);
    
    public static final int SHARE_FORWARD_VALUE = 1;
    
    public static final int SHARE_FRIEND_CLUB_VALUE = 6;
    
    public static final int SHARE_FRIEND_VALUE = 2;
    
    public static final int SHARE_QQ_VALUE = 4;
    
    public static final int SHARE_WECHAT_VALUE = 3;
    
    public static final int SHARE_WEIBO_VALUE = 5;
    
    public static final int UNKNOWN_SHARE_CHANNEL_VALUE = 0;
    
    private static final ShareChannel[] VALUES;
    
    private static final Internal.EnumLiteMap<ShareChannel> internalValueMap;
    
    private final int value;
    
    static {
      SHARE_QQ = new ShareChannel("SHARE_QQ", 4, 4);
      SHARE_WEIBO = new ShareChannel("SHARE_WEIBO", 5, 5);
      SHARE_FRIEND_CLUB = new ShareChannel("SHARE_FRIEND_CLUB", 6, 6);
      UNRECOGNIZED = new ShareChannel("UNRECOGNIZED", 7, -1);
      $VALUES = new ShareChannel[] { UNKNOWN_SHARE_CHANNEL, SHARE_FORWARD, SHARE_FRIEND, SHARE_WECHAT, SHARE_QQ, SHARE_WEIBO, SHARE_FRIEND_CLUB, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ShareChannel>() {
          public ChatRoomProtos.ShareChannel findValueByNumber(int param2Int) {
            return ChatRoomProtos.ShareChannel.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    ShareChannel(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ShareChannel forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return SHARE_FRIEND_CLUB;
        case 5:
          return SHARE_WEIBO;
        case 4:
          return SHARE_QQ;
        case 3:
          return SHARE_WECHAT;
        case 2:
          return SHARE_FRIEND;
        case 1:
          return SHARE_FORWARD;
        case 0:
          break;
      } 
      return UNKNOWN_SHARE_CHANNEL;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ChatRoomProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<ShareChannel> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<ShareChannel> {
    public ChatRoomProtos.ShareChannel findValueByNumber(int param1Int) {
      return ChatRoomProtos.ShareChannel.forNumber(param1Int);
    }
  }
  
  public enum UserType implements ProtocolMessageEnum {
    APPLYING_USER(0),
    APPLY_SUCCESS_USER(0),
    COMMON_USER(0),
    UNKNOWN_USER_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int APPLYING_USER_VALUE = 3;
    
    public static final int APPLY_SUCCESS_USER_VALUE = 2;
    
    public static final int COMMON_USER_VALUE = 1;
    
    public static final int UNKNOWN_USER_TYPE_VALUE = 0;
    
    private static final UserType[] VALUES;
    
    private static final Internal.EnumLiteMap<UserType> internalValueMap;
    
    private final int value;
    
    static {
      APPLY_SUCCESS_USER = new UserType("APPLY_SUCCESS_USER", 2, 2);
      APPLYING_USER = new UserType("APPLYING_USER", 3, 3);
      UNRECOGNIZED = new UserType("UNRECOGNIZED", 4, -1);
      $VALUES = new UserType[] { UNKNOWN_USER_TYPE, COMMON_USER, APPLY_SUCCESS_USER, APPLYING_USER, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<UserType>() {
          public ChatRoomProtos.UserType findValueByNumber(int param2Int) {
            return ChatRoomProtos.UserType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    UserType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static UserType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : APPLYING_USER) : APPLY_SUCCESS_USER) : COMMON_USER) : UNKNOWN_USER_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ChatRoomProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<UserType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<UserType> {
    public ChatRoomProtos.UserType findValueByNumber(int param1Int) {
      return ChatRoomProtos.UserType.forNumber(param1Int);
    }
  }
  
  public enum WarnType implements ProtocolMessageEnum {
    ADS_WARN(0),
    COPYRIGHT_WARN(0),
    CUSTOMIZE_WARN(0),
    DRUG_WARN(0),
    HINT_WARN(0),
    INVALID_LIVE_WARN(0),
    MUTE_WARN(0),
    POLITICAL_WARN(0),
    PRIVACY_WARN(0),
    SPEECH_WARN(0),
    UNKNOWN_WARN_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int ADS_WARN_VALUE = 1;
    
    public static final int COPYRIGHT_WARN_VALUE = 9;
    
    public static final int CUSTOMIZE_WARN_VALUE = 8;
    
    public static final int DRUG_WARN_VALUE = 4;
    
    public static final int HINT_WARN_VALUE = 3;
    
    public static final int INVALID_LIVE_WARN_VALUE = 7;
    
    public static final int MUTE_WARN_VALUE = 10;
    
    public static final int POLITICAL_WARN_VALUE = 2;
    
    public static final int PRIVACY_WARN_VALUE = 6;
    
    public static final int SPEECH_WARN_VALUE = 5;
    
    public static final int UNKNOWN_WARN_TYPE_VALUE = 0;
    
    private static final WarnType[] VALUES;
    
    private static final Internal.EnumLiteMap<WarnType> internalValueMap;
    
    private final int value;
    
    static {
      HINT_WARN = new WarnType("HINT_WARN", 3, 3);
      DRUG_WARN = new WarnType("DRUG_WARN", 4, 4);
      SPEECH_WARN = new WarnType("SPEECH_WARN", 5, 5);
      PRIVACY_WARN = new WarnType("PRIVACY_WARN", 6, 6);
      INVALID_LIVE_WARN = new WarnType("INVALID_LIVE_WARN", 7, 7);
      CUSTOMIZE_WARN = new WarnType("CUSTOMIZE_WARN", 8, 8);
      COPYRIGHT_WARN = new WarnType("COPYRIGHT_WARN", 9, 9);
      MUTE_WARN = new WarnType("MUTE_WARN", 10, 10);
      UNRECOGNIZED = new WarnType("UNRECOGNIZED", 11, -1);
      $VALUES = new WarnType[] { 
          UNKNOWN_WARN_TYPE, ADS_WARN, POLITICAL_WARN, HINT_WARN, DRUG_WARN, SPEECH_WARN, PRIVACY_WARN, INVALID_LIVE_WARN, CUSTOMIZE_WARN, COPYRIGHT_WARN, 
          MUTE_WARN, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<WarnType>() {
          public ChatRoomProtos.WarnType findValueByNumber(int param2Int) {
            return ChatRoomProtos.WarnType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    WarnType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static WarnType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 10:
          return MUTE_WARN;
        case 9:
          return COPYRIGHT_WARN;
        case 8:
          return CUSTOMIZE_WARN;
        case 7:
          return INVALID_LIVE_WARN;
        case 6:
          return PRIVACY_WARN;
        case 5:
          return SPEECH_WARN;
        case 4:
          return DRUG_WARN;
        case 3:
          return HINT_WARN;
        case 2:
          return POLITICAL_WARN;
        case 1:
          return ADS_WARN;
        case 0:
          break;
      } 
      return UNKNOWN_WARN_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return ChatRoomProtos.getDescriptor().getEnumTypes().get(3);
    }
    
    public static Internal.EnumLiteMap<WarnType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<WarnType> {
    public ChatRoomProtos.WarnType findValueByNumber(int param1Int) {
      return ChatRoomProtos.WarnType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\chatroom\ChatRoomProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
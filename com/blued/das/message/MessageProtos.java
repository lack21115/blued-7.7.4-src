package com.blued.das.message;

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

public final class MessageProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\023MessageProtos.proto\022\025com.blued.das.message\"Ì\007\n\fMessageProto\022+\n\005event\030\001 \001(\0162\034.com.blued.das.message.Event\022H\n\025msg_screen_click_type\030\002 \001(\0162).com.blued.das.message.MsgScreenClickType\022\022\n\ntarget_uid\030\003 \001(\t\0227\n\fphoto_source\030\005 \001(\0162!.com.blued.das.message.SourceType\0224\n\nphoto_type\030\006 \001(\0162 .com.blued.das.message.PhotoType\022>\n\017stranger_source\030\007 \001(\0162%.com.blued.das.message.StrangerSource\022\021\n\tphoto_num\030\b \001(\005\022\026\n\016disturb_source\030\t \001(\t\022\025\n\rdisturb_range\030\n \001(\t\022\017\n\007is_open\030\013 \001(\b\0222\n\twarn_type\030\f \001(\0162\037.com.blued.das.message.WarnType\022\023\n\013is_map_find\030\r \001(\b\0222\n\twarn_time\030\016 \001(\0162\037.com.blued.das.message.WarnTime\022\032\n\022is_appreciate_call\030\017 \001(\b\022\025\n\ris_quiet_call\030\020 \001(\b\022\031\n\021is_super_exposure\030\021 \001(\b\022\021\n\tis_shadow\030\022 \001(\b\0222\n\tshow_type\030\023 \001(\0162\037.com.blued.das.message.ShowType\022\020\n\bimage_id\030\024 \001(\t\022\020\n\bis_valid\030\025 \001(\b\022\023\n\013call_filter\030\026 \001(\t\0222\n\tsort_type\030\027 \001(\0162\037.com.blued.das.message.SortType\022\013\n\003url\030\030 \001(\t\022\020\n\bposition\030\031 \001(\005\022\n\n\002id\030\032 \001(\t\022\017\n\007keyword\030\033 \001(\t\022\017\n\007live_id\030\034 \001(\t\022\023\n\013destination\030\035 \001(\t\022\f\n\004type\030\036 \001(\t\022\r\n\005is_ai\030\037 \001(\b\022\017\n\007room_id\030  \001(\t\022\020\n\broom_uid\030! \001(\t\022\016\n\006is_buy\030\" \001(\b*Ã\017\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\025\n\021MSG_SCREEN_UNFOLD\020\001\022\023\n\017MSG_SCREEN_FOLD\020\002\022 \n\034MSG_SCREEN_STARTED_BTN_CLICK\020\003\022!\n\035MSG_SCREEN_FOLLOWED_BTN_CLICK\020\004\022\037\n\033MSG_SCREEN_NEARBY_BTN_CLICK\020\005\022%\n!MSG_SCREEN_UNFOLD_RESET_BTN_CLICK\020\006\022#\n\037MSG_SCREEN_FOLD_CLOSE_BTN_CLICK\020\007\022\032\n\026MSG_UNREAD_DRAG_REMOVE\020\b\022\037\n\033MSG_SCREEN_SEARCH_BOX_CLICK\020\t\022&\n\"MSG_PRIVATE_STRANGER_SOURCE_PROMPT\020\n\022\022\n\016MSG_SEND_PHOTO\020\013\022\031\n\025MSG_NO_DISTURB_FILTER\020\f\022\031\n\025MSG_DELETE_POINT_SHOW\020\r\022\035\n\031MSG_PHOTO_CLEAR_BTN_CLICK\020\016\022\027\n\023MSG_TO_UP_BTN_CLICK\020\017\022\026\n\022MSG_TO_UP_MAX_SHOW\020\020\022\032\n\026MSG_MORE_IGNORE_UNREAD\020\021\022\022\n\016MSG_MORE_CLEAR\020\022\022\032\n\026MSG_MORE_VIDEO_SETTING\020\023\022\036\n\032MSG_MORE_ATTENTION_SETTING\020\024\022\034\n\030MSG_MORE_OPEN_LOOK_QUIET\020\025\022\025\n\021MSG_ADD_BTN_CLICK\020\026\022\030\n\024MSG_VOCATIV_BTN_SHOW\020\027\022\031\n\025MSG_VOCATIV_BTN_CLICK\020\030\022\026\n\022MSG_MORE_BTN_CLICK\020\031\022%\n!MSG_CHAT_SET_BACKGROUND_BTN_CLICK\020\032\022\026\n\022MSG_PUSH_WARN_SHOW\020\033\022\027\n\023MSG_PUSH_WARN_CLICK\020\034\022\027\n\023MSG_PUSH_WARN_CLOSE\020\035\022\035\n\031MSG_MORE_NO_DISTURB_CLICK\020\036\022\031\n\025MSG_VOCATIV_USER_SHOW\020\037\022\032\n\026MSG_VOCATIV_USER_CLICK\020 \022\030\n\024MSG_SAVE_VIDEO_CLICK\020!\022\023\n\017MSG_EMOJI_CLICK\020\"\022\021\n\rCHAT_SEND_MSG\020#\022\035\n\031MSG_SETTINGS_BUBBLE_CLICK\020$\022\032\n\026MSG_CLICK_BUBBLE_CLICK\020%\022\031\n\025MSG_BUBBLE_SAVE_CLICK\020&\022\027\n\023CALL_PAGE_USER_SHOW\020'\022\030\n\024CALL_PAGE_USER_CLICK\020(\022\033\n\027MSG_SETTINGS_ICON_CLICK\020)\022\031\n\025MSG_LIST_OPERATE_SHOW\020+\022'\n#MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK\020,\022\034\n\030MSG_SETTINGS_LIVE_NOTICE\020-\022\023\n\017BLUED_MSG_CLICK\020.\022\034\n\030PRIVATE_CHAT_OPTION_SHOW\020/\022\024\n\020CHAT_VIDEO_CLICK\0200\022\035\n\031PRIVATE_CHAT_REPORT_CLICK\0201\022\030\n\024MSG_SAY_HI_LIST_SHOW\0202\022\030\n\024MSG_SAY_HI_ONE_CLICK\0203\022\021\n\rMSG_LIVE_SHOW\0204\022\022\n\016MSG_LIVE_CLICK\0205\022\022\n\016NAVIGATION_BTN\0206\022\f\n\bMSG_PUSH\0207\022\020\n\fMESSAGE_PAGE\0208\022\r\n\tMSG_CLICK\0209\022\030\n\024MSG_BUBBLE_VIP_CLICK\020:\022!\n\035MSG_SCREEN_SEARCH_BOX_SUCCESS\020;\022#\n\037CHAT_ROOM_INVITE_MSG_JOIN_CLICK\020<\022!\n\035MSG_VOICE_TRANSFER_WORD_CLICK\020=\022\027\n\023GIFT_CARD_PAGE_SHOW\020>\022\035\n\031GIFT_CARD_PAGE_SEND_CLICK\020?\022\037\n\033GIFT_CARD_PAGE_CANCEL_CLICK\020@\022+\n'GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK\020A\022*\n&GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK\020B\022\027\n\023MSG_VOICE_BTN_CLICK\020C\022\033\n\027MSG_VOICE_TALK_BTN_SHOW\020D\022\034\n\030MSG_VOICE_TALK_BTN_CLICK\020E\022\036\n\032MSG_VOICE_DELETE_BTN_CLICK\020F\022\032\n\026MSG_YY_ROOM_JOIN_CLICK\020G*x\n\022MsgScreenClickType\022!\n\035UNKNOWN_MSG_SCREEN_CLICK_TYPE\020\000\022\036\n\032MSG_SCREEN_CLICK_TYPE_OPEN\020\001\022\037\n\033MSG_SCREEN_CLICK_TYPE_CLOSE\020\002*\t\n\016StrangerSource\022\033\n\027UNKNOWN_STRANGER_SOURCE\020\000\022\027\n\023FRIEND_NEARBY_VISIT\020\001\022\026\n\022FRIEND_NEARBY_VIEW\020\002\022\030\n\024FRIEND_NEARBY_NEARBY\020\003\022\030\n\024FRIEND_NEARBY_ONLINE\020\004\022\032\n\026FRIEND_NEARBY_NEW_FACE\020\005\022!\n\035FRIEND_NEARBY_PERSONAL_NEARBY\020\006\022\024\n\020FOLLOW_ATTENTION\020\007\022\017\n\013FEED_NEARBY\020\b\022\023\n\017FEED_FIND_PHOTO\020\t\022\023\n\017FEED_FIND_PLAZA\020\n\022\027\n\023FEED_PERSONAL_TOPIC\020\013\022\033\n\027FEED_NOT_SUPER_EXPOSURE\020\f\022\031\n\025APPRECIATE_CALL_SHORT\020\r\022\031\n\025APPRECIATE_CALL_TOTAL\020\016\022\025\n\021APPRECIATE_NEARBY\020\017\022\023\n\017APPRECIATE_FIND\020\020\022\035\n\031APPRECIATE_SUPER_EXPOSURE\020\021\022\b\n\004LIVE\020\022\022\017\n\013MINE_FOLLOW\020\023\022\f\n\bMINE_FAN\020\024\022\f\n\bMAP_FIND\020\025\022\033\n\027APPRECIATE_CALL_COMPLEX\020\026\022\032\n\026APPRECIATE_CALL_ONLINE\020\027\022\021\n\rSHADOW_SOURCE\020\030\022\017\n\013MINE_FRIEND\020\031\022\020\n\fCOMPLEX_SORT\020\032\022\024\n\020ONLINE_TIME_SORT\020\033\022\021\n\rDISTANCE_SORT\020\034\022\023\n\017NEARBY_FEATURED\020\035\022\020\n\fFEED_COMMENT\020\036\022\f\n\bNEW_FACE\020\037\022\026\n\022SUPER_TOPIC_DETAIL\020 \022\035\n\031FIND_PLAZA_RECOMMEND_USER\020!\022\030\n\024FIND_PLAZA_RECOMMEND\020\"\022\025\n\021FIND_PLAZA_FOLLOW\020#\022\025\n\021FIND_PLAZA_NEARBY\020$\022\024\n\020FIND_PLAZA_IMAGE\020%\022\024\n\020FIND_PLAZA_FLASH\020&\022\033\n\027FIND_PLAZA_FLASH_DETAIL\020'\022\017\n\013FEED_DETAIL\020(\022\022\n\016PAGE_FEED_MINE\020)\022\022\n\016PAGE_FEED_LIKE\020*\022\031\n\025PAGE_FEED_DETAIL_MORE\020+\022\026\n\022CIRCLE_NOTE_DETAIL\020,\022\032\n\026CIRCLE_DETAIL_NOTE_NEW\020-\022\032\n\026CIRCLE_DETAIL_NOTE_HOT\020.\022\020\n\fCIRCLE_USERS\020/\022\f\n\bONE_CITY\0200\022\016\n\nGROUP_CHAT\0201\022\r\n\tCHAT_ROOM\0202*K\n\nSourceType\022\027\n\023UNKNOWN_SOURCE_TYPE\020\000\022\020\n\fRECENT_PHOTO\020\001\022\022\n\016COMPLETE_PHOTO\020\002*J\n\tPhotoType\022\026\n\022UNKNOWN_PHOTO_TYPE\020\000\022\020\n\fNORMAL_PHOTO\020\001\022\023\n\017BURN_AFTER_READ\020\002*Y\n\bWarnType\022\025\n\021UNKNOWN_WARN_TYPE\020\000\022\016\n\nTOAST_PUSH\020\001\022\f\n\bPOP_PUSH\020\002\022\030\n\024TOAST_PUSH_PERMANENT\020\003*r\n\bWarnTime\022\025\n\021UNKNOWN_WARN_TIME\020\000\022\020\n\fUNREAD_FIRST\020\001\022\016\n\nCHAT_FIRST\020\002\022\016\n\nLIVE_FIRST\020\003\022\r\n\tTOAST_MSG\020\004\022\016\n\nTOAST_LIVE\020\005*A\n\bShowType\022\025\n\021UNKNOWN_SHOW_TYPE\020\000\022\017\n\013PALACE_SHOW\020\001\022\r\n\tLIST_SHOW\020\002*K\n\bSortType\022\025\n\021UNKNOWN_SORT_TYPE\020\000\022\020\n\fAI_SORT_TYPE\020\001\022\026\n\022DISTANCE_SORT_TYPE\020\002B\n¢\002\007MESSAGEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_message_MessageProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_message_MessageProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_message_MessageProto_descriptor, new String[] { 
        "Event", "MsgScreenClickType", "TargetUid", "PhotoSource", "PhotoType", "StrangerSource", "PhotoNum", "DisturbSource", "DisturbRange", "IsOpen", 
        "WarnType", "IsMapFind", "WarnTime", "IsAppreciateCall", "IsQuietCall", "IsSuperExposure", "IsShadow", "ShowType", "ImageId", "IsValid", 
        "CallFilter", "SortType", "Url", "Position", "Id", "Keyword", "LiveId", "Destination", "Type", "IsAi", 
        "RoomId", "RoomUid", "IsBuy" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    BLUED_MSG_CLICK,
    CALL_PAGE_USER_CLICK,
    CALL_PAGE_USER_SHOW,
    CHAT_ROOM_INVITE_MSG_JOIN_CLICK,
    CHAT_SEND_MSG,
    CHAT_VIDEO_CLICK,
    GIFT_CARD_PAGE_CANCEL_CLICK,
    GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK,
    GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK,
    GIFT_CARD_PAGE_SEND_CLICK,
    GIFT_CARD_PAGE_SHOW,
    MESSAGE_PAGE,
    MSG_ADD_BTN_CLICK,
    MSG_BUBBLE_SAVE_CLICK,
    MSG_BUBBLE_VIP_CLICK,
    MSG_CHAT_SET_BACKGROUND_BTN_CLICK,
    MSG_CLICK,
    MSG_CLICK_BUBBLE_CLICK,
    MSG_DELETE_POINT_SHOW,
    MSG_EMOJI_CLICK,
    MSG_LIST_OPERATE_SHOW,
    MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK,
    MSG_LIVE_CLICK,
    MSG_LIVE_SHOW,
    MSG_MORE_ATTENTION_SETTING,
    MSG_MORE_BTN_CLICK,
    MSG_MORE_CLEAR,
    MSG_MORE_IGNORE_UNREAD,
    MSG_MORE_NO_DISTURB_CLICK,
    MSG_MORE_OPEN_LOOK_QUIET,
    MSG_MORE_VIDEO_SETTING,
    MSG_NO_DISTURB_FILTER,
    MSG_PHOTO_CLEAR_BTN_CLICK,
    MSG_PRIVATE_STRANGER_SOURCE_PROMPT,
    MSG_PUSH,
    MSG_PUSH_WARN_CLICK,
    MSG_PUSH_WARN_CLOSE,
    MSG_PUSH_WARN_SHOW,
    MSG_SAVE_VIDEO_CLICK,
    MSG_SAY_HI_LIST_SHOW,
    MSG_SAY_HI_ONE_CLICK,
    MSG_SCREEN_FOLD,
    MSG_SCREEN_FOLD_CLOSE_BTN_CLICK,
    MSG_SCREEN_FOLLOWED_BTN_CLICK,
    MSG_SCREEN_NEARBY_BTN_CLICK,
    MSG_SCREEN_SEARCH_BOX_CLICK,
    MSG_SCREEN_SEARCH_BOX_SUCCESS,
    MSG_SCREEN_STARTED_BTN_CLICK,
    MSG_SCREEN_UNFOLD,
    MSG_SCREEN_UNFOLD_RESET_BTN_CLICK,
    MSG_SEND_PHOTO,
    MSG_SETTINGS_BUBBLE_CLICK,
    MSG_SETTINGS_ICON_CLICK,
    MSG_SETTINGS_LIVE_NOTICE,
    MSG_TO_UP_BTN_CLICK,
    MSG_TO_UP_MAX_SHOW,
    MSG_UNREAD_DRAG_REMOVE,
    MSG_VOCATIV_BTN_CLICK,
    MSG_VOCATIV_BTN_SHOW,
    MSG_VOCATIV_USER_CLICK,
    MSG_VOCATIV_USER_SHOW,
    MSG_VOICE_BTN_CLICK,
    MSG_VOICE_DELETE_BTN_CLICK,
    MSG_VOICE_TALK_BTN_CLICK,
    MSG_VOICE_TALK_BTN_SHOW,
    MSG_VOICE_TRANSFER_WORD_CLICK,
    MSG_YY_ROOM_JOIN_CLICK,
    NAVIGATION_BTN,
    PRIVATE_CHAT_OPTION_SHOW,
    PRIVATE_CHAT_REPORT_CLICK,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int BLUED_MSG_CLICK_VALUE = 46;
    
    public static final int CALL_PAGE_USER_CLICK_VALUE = 40;
    
    public static final int CALL_PAGE_USER_SHOW_VALUE = 39;
    
    public static final int CHAT_ROOM_INVITE_MSG_JOIN_CLICK_VALUE = 60;
    
    public static final int CHAT_SEND_MSG_VALUE = 35;
    
    public static final int CHAT_VIDEO_CLICK_VALUE = 48;
    
    public static final int GIFT_CARD_PAGE_CANCEL_CLICK_VALUE = 64;
    
    public static final int GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK_VALUE = 66;
    
    public static final int GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK_VALUE = 65;
    
    public static final int GIFT_CARD_PAGE_SEND_CLICK_VALUE = 63;
    
    public static final int GIFT_CARD_PAGE_SHOW_VALUE = 62;
    
    public static final int MESSAGE_PAGE_VALUE = 56;
    
    public static final int MSG_ADD_BTN_CLICK_VALUE = 22;
    
    public static final int MSG_BUBBLE_SAVE_CLICK_VALUE = 38;
    
    public static final int MSG_BUBBLE_VIP_CLICK_VALUE = 58;
    
    public static final int MSG_CHAT_SET_BACKGROUND_BTN_CLICK_VALUE = 26;
    
    public static final int MSG_CLICK_BUBBLE_CLICK_VALUE = 37;
    
    public static final int MSG_CLICK_VALUE = 57;
    
    public static final int MSG_DELETE_POINT_SHOW_VALUE = 13;
    
    public static final int MSG_EMOJI_CLICK_VALUE = 34;
    
    public static final int MSG_LIST_OPERATE_SHOW_VALUE = 43;
    
    public static final int MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK_VALUE = 44;
    
    public static final int MSG_LIVE_CLICK_VALUE = 53;
    
    public static final int MSG_LIVE_SHOW_VALUE = 52;
    
    public static final int MSG_MORE_ATTENTION_SETTING_VALUE = 20;
    
    public static final int MSG_MORE_BTN_CLICK_VALUE = 25;
    
    public static final int MSG_MORE_CLEAR_VALUE = 18;
    
    public static final int MSG_MORE_IGNORE_UNREAD_VALUE = 17;
    
    public static final int MSG_MORE_NO_DISTURB_CLICK_VALUE = 30;
    
    public static final int MSG_MORE_OPEN_LOOK_QUIET_VALUE = 21;
    
    public static final int MSG_MORE_VIDEO_SETTING_VALUE = 19;
    
    public static final int MSG_NO_DISTURB_FILTER_VALUE = 12;
    
    public static final int MSG_PHOTO_CLEAR_BTN_CLICK_VALUE = 14;
    
    public static final int MSG_PRIVATE_STRANGER_SOURCE_PROMPT_VALUE = 10;
    
    public static final int MSG_PUSH_VALUE = 55;
    
    public static final int MSG_PUSH_WARN_CLICK_VALUE = 28;
    
    public static final int MSG_PUSH_WARN_CLOSE_VALUE = 29;
    
    public static final int MSG_PUSH_WARN_SHOW_VALUE = 27;
    
    public static final int MSG_SAVE_VIDEO_CLICK_VALUE = 33;
    
    public static final int MSG_SAY_HI_LIST_SHOW_VALUE = 50;
    
    public static final int MSG_SAY_HI_ONE_CLICK_VALUE = 51;
    
    public static final int MSG_SCREEN_FOLD_CLOSE_BTN_CLICK_VALUE = 7;
    
    public static final int MSG_SCREEN_FOLD_VALUE = 2;
    
    public static final int MSG_SCREEN_FOLLOWED_BTN_CLICK_VALUE = 4;
    
    public static final int MSG_SCREEN_NEARBY_BTN_CLICK_VALUE = 5;
    
    public static final int MSG_SCREEN_SEARCH_BOX_CLICK_VALUE = 9;
    
    public static final int MSG_SCREEN_SEARCH_BOX_SUCCESS_VALUE = 59;
    
    public static final int MSG_SCREEN_STARTED_BTN_CLICK_VALUE = 3;
    
    public static final int MSG_SCREEN_UNFOLD_RESET_BTN_CLICK_VALUE = 6;
    
    public static final int MSG_SCREEN_UNFOLD_VALUE = 1;
    
    public static final int MSG_SEND_PHOTO_VALUE = 11;
    
    public static final int MSG_SETTINGS_BUBBLE_CLICK_VALUE = 36;
    
    public static final int MSG_SETTINGS_ICON_CLICK_VALUE = 41;
    
    public static final int MSG_SETTINGS_LIVE_NOTICE_VALUE = 45;
    
    public static final int MSG_TO_UP_BTN_CLICK_VALUE = 15;
    
    public static final int MSG_TO_UP_MAX_SHOW_VALUE = 16;
    
    public static final int MSG_UNREAD_DRAG_REMOVE_VALUE = 8;
    
    public static final int MSG_VOCATIV_BTN_CLICK_VALUE = 24;
    
    public static final int MSG_VOCATIV_BTN_SHOW_VALUE = 23;
    
    public static final int MSG_VOCATIV_USER_CLICK_VALUE = 32;
    
    public static final int MSG_VOCATIV_USER_SHOW_VALUE = 31;
    
    public static final int MSG_VOICE_BTN_CLICK_VALUE = 67;
    
    public static final int MSG_VOICE_DELETE_BTN_CLICK_VALUE = 70;
    
    public static final int MSG_VOICE_TALK_BTN_CLICK_VALUE = 69;
    
    public static final int MSG_VOICE_TALK_BTN_SHOW_VALUE = 68;
    
    public static final int MSG_VOICE_TRANSFER_WORD_CLICK_VALUE = 61;
    
    public static final int MSG_YY_ROOM_JOIN_CLICK_VALUE = 71;
    
    public static final int NAVIGATION_BTN_VALUE = 54;
    
    public static final int PRIVATE_CHAT_OPTION_SHOW_VALUE = 47;
    
    public static final int PRIVATE_CHAT_REPORT_CLICK_VALUE = 49;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      MSG_SCREEN_FOLD = new Event("MSG_SCREEN_FOLD", 2, 2);
      MSG_SCREEN_STARTED_BTN_CLICK = new Event("MSG_SCREEN_STARTED_BTN_CLICK", 3, 3);
      MSG_SCREEN_FOLLOWED_BTN_CLICK = new Event("MSG_SCREEN_FOLLOWED_BTN_CLICK", 4, 4);
      MSG_SCREEN_NEARBY_BTN_CLICK = new Event("MSG_SCREEN_NEARBY_BTN_CLICK", 5, 5);
      MSG_SCREEN_UNFOLD_RESET_BTN_CLICK = new Event("MSG_SCREEN_UNFOLD_RESET_BTN_CLICK", 6, 6);
      MSG_SCREEN_FOLD_CLOSE_BTN_CLICK = new Event("MSG_SCREEN_FOLD_CLOSE_BTN_CLICK", 7, 7);
      MSG_UNREAD_DRAG_REMOVE = new Event("MSG_UNREAD_DRAG_REMOVE", 8, 8);
      MSG_SCREEN_SEARCH_BOX_CLICK = new Event("MSG_SCREEN_SEARCH_BOX_CLICK", 9, 9);
      MSG_PRIVATE_STRANGER_SOURCE_PROMPT = new Event("MSG_PRIVATE_STRANGER_SOURCE_PROMPT", 10, 10);
      MSG_SEND_PHOTO = new Event("MSG_SEND_PHOTO", 11, 11);
      MSG_NO_DISTURB_FILTER = new Event("MSG_NO_DISTURB_FILTER", 12, 12);
      MSG_DELETE_POINT_SHOW = new Event("MSG_DELETE_POINT_SHOW", 13, 13);
      MSG_PHOTO_CLEAR_BTN_CLICK = new Event("MSG_PHOTO_CLEAR_BTN_CLICK", 14, 14);
      MSG_TO_UP_BTN_CLICK = new Event("MSG_TO_UP_BTN_CLICK", 15, 15);
      MSG_TO_UP_MAX_SHOW = new Event("MSG_TO_UP_MAX_SHOW", 16, 16);
      MSG_MORE_IGNORE_UNREAD = new Event("MSG_MORE_IGNORE_UNREAD", 17, 17);
      MSG_MORE_CLEAR = new Event("MSG_MORE_CLEAR", 18, 18);
      MSG_MORE_VIDEO_SETTING = new Event("MSG_MORE_VIDEO_SETTING", 19, 19);
      MSG_MORE_ATTENTION_SETTING = new Event("MSG_MORE_ATTENTION_SETTING", 20, 20);
      MSG_MORE_OPEN_LOOK_QUIET = new Event("MSG_MORE_OPEN_LOOK_QUIET", 21, 21);
      MSG_ADD_BTN_CLICK = new Event("MSG_ADD_BTN_CLICK", 22, 22);
      MSG_VOCATIV_BTN_SHOW = new Event("MSG_VOCATIV_BTN_SHOW", 23, 23);
      MSG_VOCATIV_BTN_CLICK = new Event("MSG_VOCATIV_BTN_CLICK", 24, 24);
      MSG_MORE_BTN_CLICK = new Event("MSG_MORE_BTN_CLICK", 25, 25);
      MSG_CHAT_SET_BACKGROUND_BTN_CLICK = new Event("MSG_CHAT_SET_BACKGROUND_BTN_CLICK", 26, 26);
      MSG_PUSH_WARN_SHOW = new Event("MSG_PUSH_WARN_SHOW", 27, 27);
      MSG_PUSH_WARN_CLICK = new Event("MSG_PUSH_WARN_CLICK", 28, 28);
      MSG_PUSH_WARN_CLOSE = new Event("MSG_PUSH_WARN_CLOSE", 29, 29);
      MSG_MORE_NO_DISTURB_CLICK = new Event("MSG_MORE_NO_DISTURB_CLICK", 30, 30);
      MSG_VOCATIV_USER_SHOW = new Event("MSG_VOCATIV_USER_SHOW", 31, 31);
      MSG_VOCATIV_USER_CLICK = new Event("MSG_VOCATIV_USER_CLICK", 32, 32);
      MSG_SAVE_VIDEO_CLICK = new Event("MSG_SAVE_VIDEO_CLICK", 33, 33);
      MSG_EMOJI_CLICK = new Event("MSG_EMOJI_CLICK", 34, 34);
      CHAT_SEND_MSG = new Event("CHAT_SEND_MSG", 35, 35);
      MSG_SETTINGS_BUBBLE_CLICK = new Event("MSG_SETTINGS_BUBBLE_CLICK", 36, 36);
      MSG_CLICK_BUBBLE_CLICK = new Event("MSG_CLICK_BUBBLE_CLICK", 37, 37);
      MSG_BUBBLE_SAVE_CLICK = new Event("MSG_BUBBLE_SAVE_CLICK", 38, 38);
      CALL_PAGE_USER_SHOW = new Event("CALL_PAGE_USER_SHOW", 39, 39);
      CALL_PAGE_USER_CLICK = new Event("CALL_PAGE_USER_CLICK", 40, 40);
      MSG_SETTINGS_ICON_CLICK = new Event("MSG_SETTINGS_ICON_CLICK", 41, 41);
      MSG_LIST_OPERATE_SHOW = new Event("MSG_LIST_OPERATE_SHOW", 42, 43);
      MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK = new Event("MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK", 43, 44);
      MSG_SETTINGS_LIVE_NOTICE = new Event("MSG_SETTINGS_LIVE_NOTICE", 44, 45);
      BLUED_MSG_CLICK = new Event("BLUED_MSG_CLICK", 45, 46);
      PRIVATE_CHAT_OPTION_SHOW = new Event("PRIVATE_CHAT_OPTION_SHOW", 46, 47);
      CHAT_VIDEO_CLICK = new Event("CHAT_VIDEO_CLICK", 47, 48);
      PRIVATE_CHAT_REPORT_CLICK = new Event("PRIVATE_CHAT_REPORT_CLICK", 48, 49);
      MSG_SAY_HI_LIST_SHOW = new Event("MSG_SAY_HI_LIST_SHOW", 49, 50);
      MSG_SAY_HI_ONE_CLICK = new Event("MSG_SAY_HI_ONE_CLICK", 50, 51);
      MSG_LIVE_SHOW = new Event("MSG_LIVE_SHOW", 51, 52);
      MSG_LIVE_CLICK = new Event("MSG_LIVE_CLICK", 52, 53);
      NAVIGATION_BTN = new Event("NAVIGATION_BTN", 53, 54);
      MSG_PUSH = new Event("MSG_PUSH", 54, 55);
      MESSAGE_PAGE = new Event("MESSAGE_PAGE", 55, 56);
      MSG_CLICK = new Event("MSG_CLICK", 56, 57);
      MSG_BUBBLE_VIP_CLICK = new Event("MSG_BUBBLE_VIP_CLICK", 57, 58);
      MSG_SCREEN_SEARCH_BOX_SUCCESS = new Event("MSG_SCREEN_SEARCH_BOX_SUCCESS", 58, 59);
      CHAT_ROOM_INVITE_MSG_JOIN_CLICK = new Event("CHAT_ROOM_INVITE_MSG_JOIN_CLICK", 59, 60);
      MSG_VOICE_TRANSFER_WORD_CLICK = new Event("MSG_VOICE_TRANSFER_WORD_CLICK", 60, 61);
      GIFT_CARD_PAGE_SHOW = new Event("GIFT_CARD_PAGE_SHOW", 61, 62);
      GIFT_CARD_PAGE_SEND_CLICK = new Event("GIFT_CARD_PAGE_SEND_CLICK", 62, 63);
      GIFT_CARD_PAGE_CANCEL_CLICK = new Event("GIFT_CARD_PAGE_CANCEL_CLICK", 63, 64);
      GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK = new Event("GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK", 64, 65);
      GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK = new Event("GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK", 65, 66);
      MSG_VOICE_BTN_CLICK = new Event("MSG_VOICE_BTN_CLICK", 66, 67);
      MSG_VOICE_TALK_BTN_SHOW = new Event("MSG_VOICE_TALK_BTN_SHOW", 67, 68);
      MSG_VOICE_TALK_BTN_CLICK = new Event("MSG_VOICE_TALK_BTN_CLICK", 68, 69);
      MSG_VOICE_DELETE_BTN_CLICK = new Event("MSG_VOICE_DELETE_BTN_CLICK", 69, 70);
      MSG_YY_ROOM_JOIN_CLICK = new Event("MSG_YY_ROOM_JOIN_CLICK", 70, 71);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 71, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, MSG_SCREEN_UNFOLD, MSG_SCREEN_FOLD, MSG_SCREEN_STARTED_BTN_CLICK, MSG_SCREEN_FOLLOWED_BTN_CLICK, MSG_SCREEN_NEARBY_BTN_CLICK, MSG_SCREEN_UNFOLD_RESET_BTN_CLICK, MSG_SCREEN_FOLD_CLOSE_BTN_CLICK, MSG_UNREAD_DRAG_REMOVE, MSG_SCREEN_SEARCH_BOX_CLICK, 
          MSG_PRIVATE_STRANGER_SOURCE_PROMPT, MSG_SEND_PHOTO, MSG_NO_DISTURB_FILTER, MSG_DELETE_POINT_SHOW, MSG_PHOTO_CLEAR_BTN_CLICK, MSG_TO_UP_BTN_CLICK, MSG_TO_UP_MAX_SHOW, MSG_MORE_IGNORE_UNREAD, MSG_MORE_CLEAR, MSG_MORE_VIDEO_SETTING, 
          MSG_MORE_ATTENTION_SETTING, MSG_MORE_OPEN_LOOK_QUIET, MSG_ADD_BTN_CLICK, MSG_VOCATIV_BTN_SHOW, MSG_VOCATIV_BTN_CLICK, MSG_MORE_BTN_CLICK, MSG_CHAT_SET_BACKGROUND_BTN_CLICK, MSG_PUSH_WARN_SHOW, MSG_PUSH_WARN_CLICK, MSG_PUSH_WARN_CLOSE, 
          MSG_MORE_NO_DISTURB_CLICK, MSG_VOCATIV_USER_SHOW, MSG_VOCATIV_USER_CLICK, MSG_SAVE_VIDEO_CLICK, MSG_EMOJI_CLICK, CHAT_SEND_MSG, MSG_SETTINGS_BUBBLE_CLICK, MSG_CLICK_BUBBLE_CLICK, MSG_BUBBLE_SAVE_CLICK, CALL_PAGE_USER_SHOW, 
          CALL_PAGE_USER_CLICK, MSG_SETTINGS_ICON_CLICK, MSG_LIST_OPERATE_SHOW, MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK, MSG_SETTINGS_LIVE_NOTICE, BLUED_MSG_CLICK, PRIVATE_CHAT_OPTION_SHOW, CHAT_VIDEO_CLICK, PRIVATE_CHAT_REPORT_CLICK, MSG_SAY_HI_LIST_SHOW, 
          MSG_SAY_HI_ONE_CLICK, MSG_LIVE_SHOW, MSG_LIVE_CLICK, NAVIGATION_BTN, MSG_PUSH, MESSAGE_PAGE, MSG_CLICK, MSG_BUBBLE_VIP_CLICK, MSG_SCREEN_SEARCH_BOX_SUCCESS, CHAT_ROOM_INVITE_MSG_JOIN_CLICK, 
          MSG_VOICE_TRANSFER_WORD_CLICK, GIFT_CARD_PAGE_SHOW, GIFT_CARD_PAGE_SEND_CLICK, GIFT_CARD_PAGE_CANCEL_CLICK, GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK, GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK, MSG_VOICE_BTN_CLICK, MSG_VOICE_TALK_BTN_SHOW, MSG_VOICE_TALK_BTN_CLICK, MSG_VOICE_DELETE_BTN_CLICK, 
          MSG_YY_ROOM_JOIN_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public MessageProtos.Event findValueByNumber(int param2Int) {
            return MessageProtos.Event.forNumber(param2Int);
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
        case 71:
          return MSG_YY_ROOM_JOIN_CLICK;
        case 70:
          return MSG_VOICE_DELETE_BTN_CLICK;
        case 69:
          return MSG_VOICE_TALK_BTN_CLICK;
        case 68:
          return MSG_VOICE_TALK_BTN_SHOW;
        case 67:
          return MSG_VOICE_BTN_CLICK;
        case 66:
          return GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK;
        case 65:
          return GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK;
        case 64:
          return GIFT_CARD_PAGE_CANCEL_CLICK;
        case 63:
          return GIFT_CARD_PAGE_SEND_CLICK;
        case 62:
          return GIFT_CARD_PAGE_SHOW;
        case 61:
          return MSG_VOICE_TRANSFER_WORD_CLICK;
        case 60:
          return CHAT_ROOM_INVITE_MSG_JOIN_CLICK;
        case 59:
          return MSG_SCREEN_SEARCH_BOX_SUCCESS;
        case 58:
          return MSG_BUBBLE_VIP_CLICK;
        case 57:
          return MSG_CLICK;
        case 56:
          return MESSAGE_PAGE;
        case 55:
          return MSG_PUSH;
        case 54:
          return NAVIGATION_BTN;
        case 53:
          return MSG_LIVE_CLICK;
        case 52:
          return MSG_LIVE_SHOW;
        case 51:
          return MSG_SAY_HI_ONE_CLICK;
        case 50:
          return MSG_SAY_HI_LIST_SHOW;
        case 49:
          return PRIVATE_CHAT_REPORT_CLICK;
        case 48:
          return CHAT_VIDEO_CLICK;
        case 47:
          return PRIVATE_CHAT_OPTION_SHOW;
        case 46:
          return BLUED_MSG_CLICK;
        case 45:
          return MSG_SETTINGS_LIVE_NOTICE;
        case 44:
          return MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK;
        case 43:
          return MSG_LIST_OPERATE_SHOW;
        case 41:
          return MSG_SETTINGS_ICON_CLICK;
        case 40:
          return CALL_PAGE_USER_CLICK;
        case 39:
          return CALL_PAGE_USER_SHOW;
        case 38:
          return MSG_BUBBLE_SAVE_CLICK;
        case 37:
          return MSG_CLICK_BUBBLE_CLICK;
        case 36:
          return MSG_SETTINGS_BUBBLE_CLICK;
        case 35:
          return CHAT_SEND_MSG;
        case 34:
          return MSG_EMOJI_CLICK;
        case 33:
          return MSG_SAVE_VIDEO_CLICK;
        case 32:
          return MSG_VOCATIV_USER_CLICK;
        case 31:
          return MSG_VOCATIV_USER_SHOW;
        case 30:
          return MSG_MORE_NO_DISTURB_CLICK;
        case 29:
          return MSG_PUSH_WARN_CLOSE;
        case 28:
          return MSG_PUSH_WARN_CLICK;
        case 27:
          return MSG_PUSH_WARN_SHOW;
        case 26:
          return MSG_CHAT_SET_BACKGROUND_BTN_CLICK;
        case 25:
          return MSG_MORE_BTN_CLICK;
        case 24:
          return MSG_VOCATIV_BTN_CLICK;
        case 23:
          return MSG_VOCATIV_BTN_SHOW;
        case 22:
          return MSG_ADD_BTN_CLICK;
        case 21:
          return MSG_MORE_OPEN_LOOK_QUIET;
        case 20:
          return MSG_MORE_ATTENTION_SETTING;
        case 19:
          return MSG_MORE_VIDEO_SETTING;
        case 18:
          return MSG_MORE_CLEAR;
        case 17:
          return MSG_MORE_IGNORE_UNREAD;
        case 16:
          return MSG_TO_UP_MAX_SHOW;
        case 15:
          return MSG_TO_UP_BTN_CLICK;
        case 14:
          return MSG_PHOTO_CLEAR_BTN_CLICK;
        case 13:
          return MSG_DELETE_POINT_SHOW;
        case 12:
          return MSG_NO_DISTURB_FILTER;
        case 11:
          return MSG_SEND_PHOTO;
        case 10:
          return MSG_PRIVATE_STRANGER_SOURCE_PROMPT;
        case 9:
          return MSG_SCREEN_SEARCH_BOX_CLICK;
        case 8:
          return MSG_UNREAD_DRAG_REMOVE;
        case 7:
          return MSG_SCREEN_FOLD_CLOSE_BTN_CLICK;
        case 6:
          return MSG_SCREEN_UNFOLD_RESET_BTN_CLICK;
        case 5:
          return MSG_SCREEN_NEARBY_BTN_CLICK;
        case 4:
          return MSG_SCREEN_FOLLOWED_BTN_CLICK;
        case 3:
          return MSG_SCREEN_STARTED_BTN_CLICK;
        case 2:
          return MSG_SCREEN_FOLD;
        case 1:
          return MSG_SCREEN_UNFOLD;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(0);
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
    public MessageProtos.Event findValueByNumber(int param1Int) {
      return MessageProtos.Event.forNumber(param1Int);
    }
  }
  
  public static final class MessageProto extends GeneratedMessageV3 implements MessageProtoOrBuilder {
    public static final int CALL_FILTER_FIELD_NUMBER = 22;
    
    private static final MessageProto DEFAULT_INSTANCE = new MessageProto();
    
    public static final int DESTINATION_FIELD_NUMBER = 29;
    
    public static final int DISTURB_RANGE_FIELD_NUMBER = 10;
    
    public static final int DISTURB_SOURCE_FIELD_NUMBER = 9;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int ID_FIELD_NUMBER = 26;
    
    public static final int IMAGE_ID_FIELD_NUMBER = 20;
    
    public static final int IS_AI_FIELD_NUMBER = 31;
    
    public static final int IS_APPRECIATE_CALL_FIELD_NUMBER = 15;
    
    public static final int IS_BUY_FIELD_NUMBER = 34;
    
    public static final int IS_MAP_FIND_FIELD_NUMBER = 13;
    
    public static final int IS_OPEN_FIELD_NUMBER = 11;
    
    public static final int IS_QUIET_CALL_FIELD_NUMBER = 16;
    
    public static final int IS_SHADOW_FIELD_NUMBER = 18;
    
    public static final int IS_SUPER_EXPOSURE_FIELD_NUMBER = 17;
    
    public static final int IS_VALID_FIELD_NUMBER = 21;
    
    public static final int KEYWORD_FIELD_NUMBER = 27;
    
    public static final int LIVE_ID_FIELD_NUMBER = 28;
    
    public static final int MSG_SCREEN_CLICK_TYPE_FIELD_NUMBER = 2;
    
    private static final Parser<MessageProto> PARSER = (Parser<MessageProto>)new AbstractParser<MessageProto>() {
        public MessageProtos.MessageProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new MessageProtos.MessageProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PHOTO_NUM_FIELD_NUMBER = 8;
    
    public static final int PHOTO_SOURCE_FIELD_NUMBER = 5;
    
    public static final int PHOTO_TYPE_FIELD_NUMBER = 6;
    
    public static final int POSITION_FIELD_NUMBER = 25;
    
    public static final int ROOM_ID_FIELD_NUMBER = 32;
    
    public static final int ROOM_UID_FIELD_NUMBER = 33;
    
    public static final int SHOW_TYPE_FIELD_NUMBER = 19;
    
    public static final int SORT_TYPE_FIELD_NUMBER = 23;
    
    public static final int STRANGER_SOURCE_FIELD_NUMBER = 7;
    
    public static final int TARGET_UID_FIELD_NUMBER = 3;
    
    public static final int TYPE_FIELD_NUMBER = 30;
    
    public static final int URL_FIELD_NUMBER = 24;
    
    public static final int WARN_TIME_FIELD_NUMBER = 14;
    
    public static final int WARN_TYPE_FIELD_NUMBER = 12;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object callFilter_;
    
    private volatile Object destination_;
    
    private volatile Object disturbRange_;
    
    private volatile Object disturbSource_;
    
    private int event_;
    
    private volatile Object id_;
    
    private volatile Object imageId_;
    
    private boolean isAi_;
    
    private boolean isAppreciateCall_;
    
    private boolean isBuy_;
    
    private boolean isMapFind_;
    
    private boolean isOpen_;
    
    private boolean isQuietCall_;
    
    private boolean isShadow_;
    
    private boolean isSuperExposure_;
    
    private boolean isValid_;
    
    private volatile Object keyword_;
    
    private volatile Object liveId_;
    
    private byte memoizedIsInitialized = -1;
    
    private int msgScreenClickType_;
    
    private int photoNum_;
    
    private int photoSource_;
    
    private int photoType_;
    
    private int position_;
    
    private volatile Object roomId_;
    
    private volatile Object roomUid_;
    
    private int showType_;
    
    private int sortType_;
    
    private int strangerSource_;
    
    private volatile Object targetUid_;
    
    private volatile Object type_;
    
    private volatile Object url_;
    
    private int warnTime_;
    
    private int warnType_;
    
    private MessageProto() {
      this.event_ = 0;
      this.msgScreenClickType_ = 0;
      this.targetUid_ = "";
      this.photoSource_ = 0;
      this.photoType_ = 0;
      this.strangerSource_ = 0;
      this.disturbSource_ = "";
      this.disturbRange_ = "";
      this.warnType_ = 0;
      this.warnTime_ = 0;
      this.showType_ = 0;
      this.imageId_ = "";
      this.callFilter_ = "";
      this.sortType_ = 0;
      this.url_ = "";
      this.id_ = "";
      this.keyword_ = "";
      this.liveId_ = "";
      this.destination_ = "";
      this.type_ = "";
      this.roomId_ = "";
      this.roomUid_ = "";
    }
    
    private MessageProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 272:
                this.isBuy_ = param1CodedInputStream.readBool();
                continue;
              case 266:
                this.roomUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 258:
                this.roomId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 248:
                this.isAi_ = param1CodedInputStream.readBool();
                continue;
              case 242:
                this.type_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 234:
                this.destination_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 226:
                this.liveId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 218:
                this.keyword_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 210:
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 200:
                this.position_ = param1CodedInputStream.readInt32();
                continue;
              case 194:
                this.url_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 184:
                this.sortType_ = param1CodedInputStream.readEnum();
                continue;
              case 178:
                this.callFilter_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 168:
                this.isValid_ = param1CodedInputStream.readBool();
                continue;
              case 162:
                this.imageId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 152:
                this.showType_ = param1CodedInputStream.readEnum();
                continue;
              case 144:
                this.isShadow_ = param1CodedInputStream.readBool();
                continue;
              case 136:
                this.isSuperExposure_ = param1CodedInputStream.readBool();
                continue;
              case 128:
                this.isQuietCall_ = param1CodedInputStream.readBool();
                continue;
              case 120:
                this.isAppreciateCall_ = param1CodedInputStream.readBool();
                continue;
              case 112:
                this.warnTime_ = param1CodedInputStream.readEnum();
                continue;
              case 104:
                this.isMapFind_ = param1CodedInputStream.readBool();
                continue;
              case 96:
                this.warnType_ = param1CodedInputStream.readEnum();
                continue;
              case 88:
                this.isOpen_ = param1CodedInputStream.readBool();
                continue;
              case 82:
                this.disturbRange_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 74:
                this.disturbSource_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 64:
                this.photoNum_ = param1CodedInputStream.readInt32();
                continue;
              case 56:
                this.strangerSource_ = param1CodedInputStream.readEnum();
                continue;
              case 48:
                this.photoType_ = param1CodedInputStream.readEnum();
                continue;
              case 40:
                this.photoSource_ = param1CodedInputStream.readEnum();
                continue;
              case 26:
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 16:
                this.msgScreenClickType_ = param1CodedInputStream.readEnum();
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
    
    private MessageProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static MessageProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MessageProto param1MessageProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1MessageProto);
    }
    
    public static MessageProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MessageProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static MessageProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MessageProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MessageProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MessageProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static MessageProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MessageProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MessageProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MessageProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static MessageProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MessageProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MessageProto parseFrom(InputStream param1InputStream) throws IOException {
      return (MessageProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static MessageProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MessageProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MessageProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (MessageProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static MessageProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MessageProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static MessageProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MessageProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static MessageProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MessageProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MessageProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof MessageProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((MessageProto)param1Object).event_) ? false : ((this.msgScreenClickType_ != ((MessageProto)param1Object).msgScreenClickType_) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : ((this.photoSource_ != ((MessageProto)param1Object).photoSource_) ? false : ((this.photoType_ != ((MessageProto)param1Object).photoType_) ? false : ((this.strangerSource_ != ((MessageProto)param1Object).strangerSource_) ? false : ((getPhotoNum() != param1Object.getPhotoNum()) ? false : (!getDisturbSource().equals(param1Object.getDisturbSource()) ? false : (!getDisturbRange().equals(param1Object.getDisturbRange()) ? false : ((getIsOpen() != param1Object.getIsOpen()) ? false : ((this.warnType_ != ((MessageProto)param1Object).warnType_) ? false : ((getIsMapFind() != param1Object.getIsMapFind()) ? false : ((this.warnTime_ != ((MessageProto)param1Object).warnTime_) ? false : ((getIsAppreciateCall() != param1Object.getIsAppreciateCall()) ? false : ((getIsQuietCall() != param1Object.getIsQuietCall()) ? false : ((getIsSuperExposure() != param1Object.getIsSuperExposure()) ? false : ((getIsShadow() != param1Object.getIsShadow()) ? false : ((this.showType_ != ((MessageProto)param1Object).showType_) ? false : (!getImageId().equals(param1Object.getImageId()) ? false : ((getIsValid() != param1Object.getIsValid()) ? false : (!getCallFilter().equals(param1Object.getCallFilter()) ? false : ((this.sortType_ != ((MessageProto)param1Object).sortType_) ? false : (!getUrl().equals(param1Object.getUrl()) ? false : ((getPosition() != param1Object.getPosition()) ? false : (!getId().equals(param1Object.getId()) ? false : (!getKeyword().equals(param1Object.getKeyword()) ? false : (!getLiveId().equals(param1Object.getLiveId()) ? false : (!getDestination().equals(param1Object.getDestination()) ? false : (!getType().equals(param1Object.getType()) ? false : ((getIsAi() != param1Object.getIsAi()) ? false : (!getRoomId().equals(param1Object.getRoomId()) ? false : (!getRoomUid().equals(param1Object.getRoomUid()) ? false : ((getIsBuy() != param1Object.getIsBuy()) ? false : (!!this.unknownFields.equals(((MessageProto)param1Object).unknownFields))))))))))))))))))))))))))))))))));
    }
    
    public String getCallFilter() {
      Object object = this.callFilter_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.callFilter_ = object;
      return (String)object;
    }
    
    public ByteString getCallFilterBytes() {
      Object object = this.callFilter_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.callFilter_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public MessageProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDestination() {
      Object object = this.destination_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.destination_ = object;
      return (String)object;
    }
    
    public ByteString getDestinationBytes() {
      Object object = this.destination_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.destination_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getDisturbRange() {
      Object object = this.disturbRange_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.disturbRange_ = object;
      return (String)object;
    }
    
    public ByteString getDisturbRangeBytes() {
      Object object = this.disturbRange_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.disturbRange_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getDisturbSource() {
      Object object = this.disturbSource_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.disturbSource_ = object;
      return (String)object;
    }
    
    public ByteString getDisturbSourceBytes() {
      Object object = this.disturbSource_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.disturbSource_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public MessageProtos.Event getEvent() {
      MessageProtos.Event event2 = MessageProtos.Event.valueOf(this.event_);
      MessageProtos.Event event1 = event2;
      if (event2 == null)
        event1 = MessageProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
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
    
    public String getImageId() {
      Object object = this.imageId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.imageId_ = object;
      return (String)object;
    }
    
    public ByteString getImageIdBytes() {
      Object object = this.imageId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.imageId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean getIsAi() {
      return this.isAi_;
    }
    
    public boolean getIsAppreciateCall() {
      return this.isAppreciateCall_;
    }
    
    public boolean getIsBuy() {
      return this.isBuy_;
    }
    
    public boolean getIsMapFind() {
      return this.isMapFind_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsQuietCall() {
      return this.isQuietCall_;
    }
    
    public boolean getIsShadow() {
      return this.isShadow_;
    }
    
    public boolean getIsSuperExposure() {
      return this.isSuperExposure_;
    }
    
    public boolean getIsValid() {
      return this.isValid_;
    }
    
    public String getKeyword() {
      Object object = this.keyword_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.keyword_ = object;
      return (String)object;
    }
    
    public ByteString getKeywordBytes() {
      Object object = this.keyword_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.keyword_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLiveId() {
      Object object = this.liveId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.liveId_ = object;
      return (String)object;
    }
    
    public ByteString getLiveIdBytes() {
      Object object = this.liveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public MessageProtos.MsgScreenClickType getMsgScreenClickType() {
      MessageProtos.MsgScreenClickType msgScreenClickType2 = MessageProtos.MsgScreenClickType.valueOf(this.msgScreenClickType_);
      MessageProtos.MsgScreenClickType msgScreenClickType1 = msgScreenClickType2;
      if (msgScreenClickType2 == null)
        msgScreenClickType1 = MessageProtos.MsgScreenClickType.UNRECOGNIZED; 
      return msgScreenClickType1;
    }
    
    public int getMsgScreenClickTypeValue() {
      return this.msgScreenClickType_;
    }
    
    public Parser<MessageProto> getParserForType() {
      return PARSER;
    }
    
    public int getPhotoNum() {
      return this.photoNum_;
    }
    
    public MessageProtos.SourceType getPhotoSource() {
      MessageProtos.SourceType sourceType2 = MessageProtos.SourceType.valueOf(this.photoSource_);
      MessageProtos.SourceType sourceType1 = sourceType2;
      if (sourceType2 == null)
        sourceType1 = MessageProtos.SourceType.UNRECOGNIZED; 
      return sourceType1;
    }
    
    public int getPhotoSourceValue() {
      return this.photoSource_;
    }
    
    public MessageProtos.PhotoType getPhotoType() {
      MessageProtos.PhotoType photoType2 = MessageProtos.PhotoType.valueOf(this.photoType_);
      MessageProtos.PhotoType photoType1 = photoType2;
      if (photoType2 == null)
        photoType1 = MessageProtos.PhotoType.UNRECOGNIZED; 
      return photoType1;
    }
    
    public int getPhotoTypeValue() {
      return this.photoType_;
    }
    
    public int getPosition() {
      return this.position_;
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
      if (this.event_ != MessageProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.msgScreenClickType_ != MessageProtos.MsgScreenClickType.UNKNOWN_MSG_SCREEN_CLICK_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.msgScreenClickType_); 
      j = i;
      if (!getTargetUidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.targetUid_); 
      i = j;
      if (this.photoSource_ != MessageProtos.SourceType.UNKNOWN_SOURCE_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(5, this.photoSource_); 
      j = i;
      if (this.photoType_ != MessageProtos.PhotoType.UNKNOWN_PHOTO_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(6, this.photoType_); 
      i = j;
      if (this.strangerSource_ != MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(7, this.strangerSource_); 
      int k = this.photoNum_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(8, k); 
      i = j;
      if (!getDisturbSourceBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(9, this.disturbSource_); 
      j = i;
      if (!getDisturbRangeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(10, this.disturbRange_); 
      boolean bool = this.isOpen_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(11, bool); 
      j = i;
      if (this.warnType_ != MessageProtos.WarnType.UNKNOWN_WARN_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(12, this.warnType_); 
      bool = this.isMapFind_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(13, bool); 
      j = i;
      if (this.warnTime_ != MessageProtos.WarnTime.UNKNOWN_WARN_TIME.getNumber())
        j = i + CodedOutputStream.computeEnumSize(14, this.warnTime_); 
      bool = this.isAppreciateCall_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(15, bool); 
      bool = this.isQuietCall_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(16, bool); 
      bool = this.isSuperExposure_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(17, bool); 
      bool = this.isShadow_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(18, bool); 
      i = j;
      if (this.showType_ != MessageProtos.ShowType.UNKNOWN_SHOW_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(19, this.showType_); 
      j = i;
      if (!getImageIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(20, this.imageId_); 
      bool = this.isValid_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(21, bool); 
      j = i;
      if (!getCallFilterBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(22, this.callFilter_); 
      k = j;
      if (this.sortType_ != MessageProtos.SortType.UNKNOWN_SORT_TYPE.getNumber())
        k = j + CodedOutputStream.computeEnumSize(23, this.sortType_); 
      i = k;
      if (!getUrlBytes().isEmpty())
        i = k + GeneratedMessageV3.computeStringSize(24, this.url_); 
      k = this.position_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(25, k); 
      i = j;
      if (!getIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(26, this.id_); 
      j = i;
      if (!getKeywordBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(27, this.keyword_); 
      i = j;
      if (!getLiveIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(28, this.liveId_); 
      j = i;
      if (!getDestinationBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(29, this.destination_); 
      i = j;
      if (!getTypeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(30, this.type_); 
      bool = this.isAi_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(31, bool); 
      i = j;
      if (!getRoomIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(32, this.roomId_); 
      j = i;
      if (!getRoomUidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(33, this.roomUid_); 
      bool = this.isBuy_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(34, bool); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public MessageProtos.ShowType getShowType() {
      MessageProtos.ShowType showType2 = MessageProtos.ShowType.valueOf(this.showType_);
      MessageProtos.ShowType showType1 = showType2;
      if (showType2 == null)
        showType1 = MessageProtos.ShowType.UNRECOGNIZED; 
      return showType1;
    }
    
    public int getShowTypeValue() {
      return this.showType_;
    }
    
    public MessageProtos.SortType getSortType() {
      MessageProtos.SortType sortType2 = MessageProtos.SortType.valueOf(this.sortType_);
      MessageProtos.SortType sortType1 = sortType2;
      if (sortType2 == null)
        sortType1 = MessageProtos.SortType.UNRECOGNIZED; 
      return sortType1;
    }
    
    public int getSortTypeValue() {
      return this.sortType_;
    }
    
    public MessageProtos.StrangerSource getStrangerSource() {
      MessageProtos.StrangerSource strangerSource2 = MessageProtos.StrangerSource.valueOf(this.strangerSource_);
      MessageProtos.StrangerSource strangerSource1 = strangerSource2;
      if (strangerSource2 == null)
        strangerSource1 = MessageProtos.StrangerSource.UNRECOGNIZED; 
      return strangerSource1;
    }
    
    public int getStrangerSourceValue() {
      return this.strangerSource_;
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
    
    public String getType() {
      Object object = this.type_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.type_ = object;
      return (String)object;
    }
    
    public ByteString getTypeBytes() {
      Object object = this.type_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.type_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public MessageProtos.WarnTime getWarnTime() {
      MessageProtos.WarnTime warnTime2 = MessageProtos.WarnTime.valueOf(this.warnTime_);
      MessageProtos.WarnTime warnTime1 = warnTime2;
      if (warnTime2 == null)
        warnTime1 = MessageProtos.WarnTime.UNRECOGNIZED; 
      return warnTime1;
    }
    
    public int getWarnTimeValue() {
      return this.warnTime_;
    }
    
    public MessageProtos.WarnType getWarnType() {
      MessageProtos.WarnType warnType2 = MessageProtos.WarnType.valueOf(this.warnType_);
      MessageProtos.WarnType warnType1 = warnType2;
      if (warnType2 == null)
        warnType1 = MessageProtos.WarnType.UNRECOGNIZED; 
      return warnType1;
    }
    
    public int getWarnTypeValue() {
      return this.warnType_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.msgScreenClickType_) * 37 + 3) * 53 + getTargetUid().hashCode()) * 37 + 5) * 53 + this.photoSource_) * 37 + 6) * 53 + this.photoType_) * 37 + 7) * 53 + this.strangerSource_) * 37 + 8) * 53 + getPhotoNum()) * 37 + 9) * 53 + getDisturbSource().hashCode()) * 37 + 10) * 53 + getDisturbRange().hashCode()) * 37 + 11) * 53 + Internal.hashBoolean(getIsOpen())) * 37 + 12) * 53 + this.warnType_) * 37 + 13) * 53 + Internal.hashBoolean(getIsMapFind())) * 37 + 14) * 53 + this.warnTime_) * 37 + 15) * 53 + Internal.hashBoolean(getIsAppreciateCall())) * 37 + 16) * 53 + Internal.hashBoolean(getIsQuietCall())) * 37 + 17) * 53 + Internal.hashBoolean(getIsSuperExposure())) * 37 + 18) * 53 + Internal.hashBoolean(getIsShadow())) * 37 + 19) * 53 + this.showType_) * 37 + 20) * 53 + getImageId().hashCode()) * 37 + 21) * 53 + Internal.hashBoolean(getIsValid())) * 37 + 22) * 53 + getCallFilter().hashCode()) * 37 + 23) * 53 + this.sortType_) * 37 + 24) * 53 + getUrl().hashCode()) * 37 + 25) * 53 + getPosition()) * 37 + 26) * 53 + getId().hashCode()) * 37 + 27) * 53 + getKeyword().hashCode()) * 37 + 28) * 53 + getLiveId().hashCode()) * 37 + 29) * 53 + getDestination().hashCode()) * 37 + 30) * 53 + getType().hashCode()) * 37 + 31) * 53 + Internal.hashBoolean(getIsAi())) * 37 + 32) * 53 + getRoomId().hashCode()) * 37 + 33) * 53 + getRoomUid().hashCode()) * 37 + 34) * 53 + Internal.hashBoolean(getIsBuy())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MessageProtos.internal_static_com_blued_das_message_MessageProto_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageProto.class, Builder.class);
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
      return new MessageProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != MessageProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.msgScreenClickType_ != MessageProtos.MsgScreenClickType.UNKNOWN_MSG_SCREEN_CLICK_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.msgScreenClickType_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.targetUid_); 
      if (this.photoSource_ != MessageProtos.SourceType.UNKNOWN_SOURCE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(5, this.photoSource_); 
      if (this.photoType_ != MessageProtos.PhotoType.UNKNOWN_PHOTO_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(6, this.photoType_); 
      if (this.strangerSource_ != MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(7, this.strangerSource_); 
      int i = this.photoNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(8, i); 
      if (!getDisturbSourceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 9, this.disturbSource_); 
      if (!getDisturbRangeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 10, this.disturbRange_); 
      boolean bool = this.isOpen_;
      if (bool)
        param1CodedOutputStream.writeBool(11, bool); 
      if (this.warnType_ != MessageProtos.WarnType.UNKNOWN_WARN_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(12, this.warnType_); 
      bool = this.isMapFind_;
      if (bool)
        param1CodedOutputStream.writeBool(13, bool); 
      if (this.warnTime_ != MessageProtos.WarnTime.UNKNOWN_WARN_TIME.getNumber())
        param1CodedOutputStream.writeEnum(14, this.warnTime_); 
      bool = this.isAppreciateCall_;
      if (bool)
        param1CodedOutputStream.writeBool(15, bool); 
      bool = this.isQuietCall_;
      if (bool)
        param1CodedOutputStream.writeBool(16, bool); 
      bool = this.isSuperExposure_;
      if (bool)
        param1CodedOutputStream.writeBool(17, bool); 
      bool = this.isShadow_;
      if (bool)
        param1CodedOutputStream.writeBool(18, bool); 
      if (this.showType_ != MessageProtos.ShowType.UNKNOWN_SHOW_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(19, this.showType_); 
      if (!getImageIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 20, this.imageId_); 
      bool = this.isValid_;
      if (bool)
        param1CodedOutputStream.writeBool(21, bool); 
      if (!getCallFilterBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 22, this.callFilter_); 
      if (this.sortType_ != MessageProtos.SortType.UNKNOWN_SORT_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(23, this.sortType_); 
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 24, this.url_); 
      i = this.position_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(25, i); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 26, this.id_); 
      if (!getKeywordBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 27, this.keyword_); 
      if (!getLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 28, this.liveId_); 
      if (!getDestinationBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 29, this.destination_); 
      if (!getTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 30, this.type_); 
      bool = this.isAi_;
      if (bool)
        param1CodedOutputStream.writeBool(31, bool); 
      if (!getRoomIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 32, this.roomId_); 
      if (!getRoomUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 33, this.roomUid_); 
      bool = this.isBuy_;
      if (bool)
        param1CodedOutputStream.writeBool(34, bool); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MessageProtos.MessageProtoOrBuilder {
      private Object callFilter_ = "";
      
      private Object destination_ = "";
      
      private Object disturbRange_ = "";
      
      private Object disturbSource_ = "";
      
      private int event_ = 0;
      
      private Object id_ = "";
      
      private Object imageId_ = "";
      
      private boolean isAi_;
      
      private boolean isAppreciateCall_;
      
      private boolean isBuy_;
      
      private boolean isMapFind_;
      
      private boolean isOpen_;
      
      private boolean isQuietCall_;
      
      private boolean isShadow_;
      
      private boolean isSuperExposure_;
      
      private boolean isValid_;
      
      private Object keyword_ = "";
      
      private Object liveId_ = "";
      
      private int msgScreenClickType_ = 0;
      
      private int photoNum_;
      
      private int photoSource_ = 0;
      
      private int photoType_ = 0;
      
      private int position_;
      
      private Object roomId_ = "";
      
      private Object roomUid_ = "";
      
      private int showType_ = 0;
      
      private int sortType_ = 0;
      
      private int strangerSource_ = 0;
      
      private Object targetUid_ = "";
      
      private Object type_ = "";
      
      private Object url_ = "";
      
      private int warnTime_ = 0;
      
      private int warnType_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        MessageProtos.MessageProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public MessageProtos.MessageProto build() {
        MessageProtos.MessageProto messageProto = buildPartial();
        if (messageProto.isInitialized())
          return messageProto; 
        throw newUninitializedMessageException(messageProto);
      }
      
      public MessageProtos.MessageProto buildPartial() {
        MessageProtos.MessageProto messageProto = new MessageProtos.MessageProto(this);
        MessageProtos.MessageProto.access$602(messageProto, this.event_);
        MessageProtos.MessageProto.access$702(messageProto, this.msgScreenClickType_);
        MessageProtos.MessageProto.access$802(messageProto, this.targetUid_);
        MessageProtos.MessageProto.access$902(messageProto, this.photoSource_);
        MessageProtos.MessageProto.access$1002(messageProto, this.photoType_);
        MessageProtos.MessageProto.access$1102(messageProto, this.strangerSource_);
        MessageProtos.MessageProto.access$1202(messageProto, this.photoNum_);
        MessageProtos.MessageProto.access$1302(messageProto, this.disturbSource_);
        MessageProtos.MessageProto.access$1402(messageProto, this.disturbRange_);
        MessageProtos.MessageProto.access$1502(messageProto, this.isOpen_);
        MessageProtos.MessageProto.access$1602(messageProto, this.warnType_);
        MessageProtos.MessageProto.access$1702(messageProto, this.isMapFind_);
        MessageProtos.MessageProto.access$1802(messageProto, this.warnTime_);
        MessageProtos.MessageProto.access$1902(messageProto, this.isAppreciateCall_);
        MessageProtos.MessageProto.access$2002(messageProto, this.isQuietCall_);
        MessageProtos.MessageProto.access$2102(messageProto, this.isSuperExposure_);
        MessageProtos.MessageProto.access$2202(messageProto, this.isShadow_);
        MessageProtos.MessageProto.access$2302(messageProto, this.showType_);
        MessageProtos.MessageProto.access$2402(messageProto, this.imageId_);
        MessageProtos.MessageProto.access$2502(messageProto, this.isValid_);
        MessageProtos.MessageProto.access$2602(messageProto, this.callFilter_);
        MessageProtos.MessageProto.access$2702(messageProto, this.sortType_);
        MessageProtos.MessageProto.access$2802(messageProto, this.url_);
        MessageProtos.MessageProto.access$2902(messageProto, this.position_);
        MessageProtos.MessageProto.access$3002(messageProto, this.id_);
        MessageProtos.MessageProto.access$3102(messageProto, this.keyword_);
        MessageProtos.MessageProto.access$3202(messageProto, this.liveId_);
        MessageProtos.MessageProto.access$3302(messageProto, this.destination_);
        MessageProtos.MessageProto.access$3402(messageProto, this.type_);
        MessageProtos.MessageProto.access$3502(messageProto, this.isAi_);
        MessageProtos.MessageProto.access$3602(messageProto, this.roomId_);
        MessageProtos.MessageProto.access$3702(messageProto, this.roomUid_);
        MessageProtos.MessageProto.access$3802(messageProto, this.isBuy_);
        onBuilt();
        return messageProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.msgScreenClickType_ = 0;
        this.targetUid_ = "";
        this.photoSource_ = 0;
        this.photoType_ = 0;
        this.strangerSource_ = 0;
        this.photoNum_ = 0;
        this.disturbSource_ = "";
        this.disturbRange_ = "";
        this.isOpen_ = false;
        this.warnType_ = 0;
        this.isMapFind_ = false;
        this.warnTime_ = 0;
        this.isAppreciateCall_ = false;
        this.isQuietCall_ = false;
        this.isSuperExposure_ = false;
        this.isShadow_ = false;
        this.showType_ = 0;
        this.imageId_ = "";
        this.isValid_ = false;
        this.callFilter_ = "";
        this.sortType_ = 0;
        this.url_ = "";
        this.position_ = 0;
        this.id_ = "";
        this.keyword_ = "";
        this.liveId_ = "";
        this.destination_ = "";
        this.type_ = "";
        this.isAi_ = false;
        this.roomId_ = "";
        this.roomUid_ = "";
        this.isBuy_ = false;
        return this;
      }
      
      public Builder clearCallFilter() {
        this.callFilter_ = MessageProtos.MessageProto.getDefaultInstance().getCallFilter();
        onChanged();
        return this;
      }
      
      public Builder clearDestination() {
        this.destination_ = MessageProtos.MessageProto.getDefaultInstance().getDestination();
        onChanged();
        return this;
      }
      
      public Builder clearDisturbRange() {
        this.disturbRange_ = MessageProtos.MessageProto.getDefaultInstance().getDisturbRange();
        onChanged();
        return this;
      }
      
      public Builder clearDisturbSource() {
        this.disturbSource_ = MessageProtos.MessageProto.getDefaultInstance().getDisturbSource();
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
      
      public Builder clearId() {
        this.id_ = MessageProtos.MessageProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearImageId() {
        this.imageId_ = MessageProtos.MessageProto.getDefaultInstance().getImageId();
        onChanged();
        return this;
      }
      
      public Builder clearIsAi() {
        this.isAi_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsAppreciateCall() {
        this.isAppreciateCall_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsBuy() {
        this.isBuy_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsMapFind() {
        this.isMapFind_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsOpen() {
        this.isOpen_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsQuietCall() {
        this.isQuietCall_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsShadow() {
        this.isShadow_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsSuperExposure() {
        this.isSuperExposure_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsValid() {
        this.isValid_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearKeyword() {
        this.keyword_ = MessageProtos.MessageProto.getDefaultInstance().getKeyword();
        onChanged();
        return this;
      }
      
      public Builder clearLiveId() {
        this.liveId_ = MessageProtos.MessageProto.getDefaultInstance().getLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearMsgScreenClickType() {
        this.msgScreenClickType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPhotoNum() {
        this.photoNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPhotoSource() {
        this.photoSource_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPhotoType() {
        this.photoType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPosition() {
        this.position_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearRoomId() {
        this.roomId_ = MessageProtos.MessageProto.getDefaultInstance().getRoomId();
        onChanged();
        return this;
      }
      
      public Builder clearRoomUid() {
        this.roomUid_ = MessageProtos.MessageProto.getDefaultInstance().getRoomUid();
        onChanged();
        return this;
      }
      
      public Builder clearShowType() {
        this.showType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSortType() {
        this.sortType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearStrangerSource() {
        this.strangerSource_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = MessageProtos.MessageProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clearType() {
        this.type_ = MessageProtos.MessageProto.getDefaultInstance().getType();
        onChanged();
        return this;
      }
      
      public Builder clearUrl() {
        this.url_ = MessageProtos.MessageProto.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clearWarnTime() {
        this.warnTime_ = 0;
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
      
      public String getCallFilter() {
        Object object = this.callFilter_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.callFilter_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getCallFilterBytes() {
        Object object = this.callFilter_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.callFilter_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public MessageProtos.MessageProto getDefaultInstanceForType() {
        return MessageProtos.MessageProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
      }
      
      public String getDestination() {
        Object object = this.destination_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.destination_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDestinationBytes() {
        Object object = this.destination_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.destination_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getDisturbRange() {
        Object object = this.disturbRange_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.disturbRange_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDisturbRangeBytes() {
        Object object = this.disturbRange_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.disturbRange_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getDisturbSource() {
        Object object = this.disturbSource_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.disturbSource_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDisturbSourceBytes() {
        Object object = this.disturbSource_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.disturbSource_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public MessageProtos.Event getEvent() {
        MessageProtos.Event event2 = MessageProtos.Event.valueOf(this.event_);
        MessageProtos.Event event1 = event2;
        if (event2 == null)
          event1 = MessageProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
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
      
      public String getImageId() {
        Object object = this.imageId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.imageId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getImageIdBytes() {
        Object object = this.imageId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.imageId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public boolean getIsAi() {
        return this.isAi_;
      }
      
      public boolean getIsAppreciateCall() {
        return this.isAppreciateCall_;
      }
      
      public boolean getIsBuy() {
        return this.isBuy_;
      }
      
      public boolean getIsMapFind() {
        return this.isMapFind_;
      }
      
      public boolean getIsOpen() {
        return this.isOpen_;
      }
      
      public boolean getIsQuietCall() {
        return this.isQuietCall_;
      }
      
      public boolean getIsShadow() {
        return this.isShadow_;
      }
      
      public boolean getIsSuperExposure() {
        return this.isSuperExposure_;
      }
      
      public boolean getIsValid() {
        return this.isValid_;
      }
      
      public String getKeyword() {
        Object object = this.keyword_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.keyword_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getKeywordBytes() {
        Object object = this.keyword_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.keyword_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getLiveId() {
        Object object = this.liveId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.liveId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLiveIdBytes() {
        Object object = this.liveId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.liveId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public MessageProtos.MsgScreenClickType getMsgScreenClickType() {
        MessageProtos.MsgScreenClickType msgScreenClickType2 = MessageProtos.MsgScreenClickType.valueOf(this.msgScreenClickType_);
        MessageProtos.MsgScreenClickType msgScreenClickType1 = msgScreenClickType2;
        if (msgScreenClickType2 == null)
          msgScreenClickType1 = MessageProtos.MsgScreenClickType.UNRECOGNIZED; 
        return msgScreenClickType1;
      }
      
      public int getMsgScreenClickTypeValue() {
        return this.msgScreenClickType_;
      }
      
      public int getPhotoNum() {
        return this.photoNum_;
      }
      
      public MessageProtos.SourceType getPhotoSource() {
        MessageProtos.SourceType sourceType2 = MessageProtos.SourceType.valueOf(this.photoSource_);
        MessageProtos.SourceType sourceType1 = sourceType2;
        if (sourceType2 == null)
          sourceType1 = MessageProtos.SourceType.UNRECOGNIZED; 
        return sourceType1;
      }
      
      public int getPhotoSourceValue() {
        return this.photoSource_;
      }
      
      public MessageProtos.PhotoType getPhotoType() {
        MessageProtos.PhotoType photoType2 = MessageProtos.PhotoType.valueOf(this.photoType_);
        MessageProtos.PhotoType photoType1 = photoType2;
        if (photoType2 == null)
          photoType1 = MessageProtos.PhotoType.UNRECOGNIZED; 
        return photoType1;
      }
      
      public int getPhotoTypeValue() {
        return this.photoType_;
      }
      
      public int getPosition() {
        return this.position_;
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
      
      public MessageProtos.ShowType getShowType() {
        MessageProtos.ShowType showType2 = MessageProtos.ShowType.valueOf(this.showType_);
        MessageProtos.ShowType showType1 = showType2;
        if (showType2 == null)
          showType1 = MessageProtos.ShowType.UNRECOGNIZED; 
        return showType1;
      }
      
      public int getShowTypeValue() {
        return this.showType_;
      }
      
      public MessageProtos.SortType getSortType() {
        MessageProtos.SortType sortType2 = MessageProtos.SortType.valueOf(this.sortType_);
        MessageProtos.SortType sortType1 = sortType2;
        if (sortType2 == null)
          sortType1 = MessageProtos.SortType.UNRECOGNIZED; 
        return sortType1;
      }
      
      public int getSortTypeValue() {
        return this.sortType_;
      }
      
      public MessageProtos.StrangerSource getStrangerSource() {
        MessageProtos.StrangerSource strangerSource2 = MessageProtos.StrangerSource.valueOf(this.strangerSource_);
        MessageProtos.StrangerSource strangerSource1 = strangerSource2;
        if (strangerSource2 == null)
          strangerSource1 = MessageProtos.StrangerSource.UNRECOGNIZED; 
        return strangerSource1;
      }
      
      public int getStrangerSourceValue() {
        return this.strangerSource_;
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
      
      public String getType() {
        Object object = this.type_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.type_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTypeBytes() {
        Object object = this.type_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.type_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public MessageProtos.WarnTime getWarnTime() {
        MessageProtos.WarnTime warnTime2 = MessageProtos.WarnTime.valueOf(this.warnTime_);
        MessageProtos.WarnTime warnTime1 = warnTime2;
        if (warnTime2 == null)
          warnTime1 = MessageProtos.WarnTime.UNRECOGNIZED; 
        return warnTime1;
      }
      
      public int getWarnTimeValue() {
        return this.warnTime_;
      }
      
      public MessageProtos.WarnType getWarnType() {
        MessageProtos.WarnType warnType2 = MessageProtos.WarnType.valueOf(this.warnType_);
        MessageProtos.WarnType warnType1 = warnType2;
        if (warnType2 == null)
          warnType1 = MessageProtos.WarnType.UNRECOGNIZED; 
        return warnType1;
      }
      
      public int getWarnTypeValue() {
        return this.warnType_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MessageProtos.internal_static_com_blued_das_message_MessageProto_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageProtos.MessageProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(MessageProtos.MessageProto param2MessageProto) {
        if (param2MessageProto == MessageProtos.MessageProto.getDefaultInstance())
          return this; 
        if (param2MessageProto.event_ != 0)
          setEventValue(param2MessageProto.getEventValue()); 
        if (param2MessageProto.msgScreenClickType_ != 0)
          setMsgScreenClickTypeValue(param2MessageProto.getMsgScreenClickTypeValue()); 
        if (!param2MessageProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2MessageProto.targetUid_;
          onChanged();
        } 
        if (param2MessageProto.photoSource_ != 0)
          setPhotoSourceValue(param2MessageProto.getPhotoSourceValue()); 
        if (param2MessageProto.photoType_ != 0)
          setPhotoTypeValue(param2MessageProto.getPhotoTypeValue()); 
        if (param2MessageProto.strangerSource_ != 0)
          setStrangerSourceValue(param2MessageProto.getStrangerSourceValue()); 
        if (param2MessageProto.getPhotoNum() != 0)
          setPhotoNum(param2MessageProto.getPhotoNum()); 
        if (!param2MessageProto.getDisturbSource().isEmpty()) {
          this.disturbSource_ = param2MessageProto.disturbSource_;
          onChanged();
        } 
        if (!param2MessageProto.getDisturbRange().isEmpty()) {
          this.disturbRange_ = param2MessageProto.disturbRange_;
          onChanged();
        } 
        if (param2MessageProto.getIsOpen())
          setIsOpen(param2MessageProto.getIsOpen()); 
        if (param2MessageProto.warnType_ != 0)
          setWarnTypeValue(param2MessageProto.getWarnTypeValue()); 
        if (param2MessageProto.getIsMapFind())
          setIsMapFind(param2MessageProto.getIsMapFind()); 
        if (param2MessageProto.warnTime_ != 0)
          setWarnTimeValue(param2MessageProto.getWarnTimeValue()); 
        if (param2MessageProto.getIsAppreciateCall())
          setIsAppreciateCall(param2MessageProto.getIsAppreciateCall()); 
        if (param2MessageProto.getIsQuietCall())
          setIsQuietCall(param2MessageProto.getIsQuietCall()); 
        if (param2MessageProto.getIsSuperExposure())
          setIsSuperExposure(param2MessageProto.getIsSuperExposure()); 
        if (param2MessageProto.getIsShadow())
          setIsShadow(param2MessageProto.getIsShadow()); 
        if (param2MessageProto.showType_ != 0)
          setShowTypeValue(param2MessageProto.getShowTypeValue()); 
        if (!param2MessageProto.getImageId().isEmpty()) {
          this.imageId_ = param2MessageProto.imageId_;
          onChanged();
        } 
        if (param2MessageProto.getIsValid())
          setIsValid(param2MessageProto.getIsValid()); 
        if (!param2MessageProto.getCallFilter().isEmpty()) {
          this.callFilter_ = param2MessageProto.callFilter_;
          onChanged();
        } 
        if (param2MessageProto.sortType_ != 0)
          setSortTypeValue(param2MessageProto.getSortTypeValue()); 
        if (!param2MessageProto.getUrl().isEmpty()) {
          this.url_ = param2MessageProto.url_;
          onChanged();
        } 
        if (param2MessageProto.getPosition() != 0)
          setPosition(param2MessageProto.getPosition()); 
        if (!param2MessageProto.getId().isEmpty()) {
          this.id_ = param2MessageProto.id_;
          onChanged();
        } 
        if (!param2MessageProto.getKeyword().isEmpty()) {
          this.keyword_ = param2MessageProto.keyword_;
          onChanged();
        } 
        if (!param2MessageProto.getLiveId().isEmpty()) {
          this.liveId_ = param2MessageProto.liveId_;
          onChanged();
        } 
        if (!param2MessageProto.getDestination().isEmpty()) {
          this.destination_ = param2MessageProto.destination_;
          onChanged();
        } 
        if (!param2MessageProto.getType().isEmpty()) {
          this.type_ = param2MessageProto.type_;
          onChanged();
        } 
        if (param2MessageProto.getIsAi())
          setIsAi(param2MessageProto.getIsAi()); 
        if (!param2MessageProto.getRoomId().isEmpty()) {
          this.roomId_ = param2MessageProto.roomId_;
          onChanged();
        } 
        if (!param2MessageProto.getRoomUid().isEmpty()) {
          this.roomUid_ = param2MessageProto.roomUid_;
          onChanged();
        } 
        if (param2MessageProto.getIsBuy())
          setIsBuy(param2MessageProto.getIsBuy()); 
        mergeUnknownFields(param2MessageProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          MessageProtos.MessageProto messageProto = (MessageProtos.MessageProto)MessageProtos.MessageProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          MessageProtos.MessageProto messageProto = (MessageProtos.MessageProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((MessageProtos.MessageProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof MessageProtos.MessageProto)
          return mergeFrom((MessageProtos.MessageProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCallFilter(String param2String) {
        if (param2String != null) {
          this.callFilter_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCallFilterBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.callFilter_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDestination(String param2String) {
        if (param2String != null) {
          this.destination_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDestinationBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.destination_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDisturbRange(String param2String) {
        if (param2String != null) {
          this.disturbRange_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDisturbRangeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.disturbRange_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDisturbSource(String param2String) {
        if (param2String != null) {
          this.disturbSource_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDisturbSourceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.disturbSource_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEvent(MessageProtos.Event param2Event) {
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
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.id_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setImageId(String param2String) {
        if (param2String != null) {
          this.imageId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setImageIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.imageId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIsAi(boolean param2Boolean) {
        this.isAi_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsAppreciateCall(boolean param2Boolean) {
        this.isAppreciateCall_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsBuy(boolean param2Boolean) {
        this.isBuy_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsMapFind(boolean param2Boolean) {
        this.isMapFind_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsOpen(boolean param2Boolean) {
        this.isOpen_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsQuietCall(boolean param2Boolean) {
        this.isQuietCall_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsShadow(boolean param2Boolean) {
        this.isShadow_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsSuperExposure(boolean param2Boolean) {
        this.isSuperExposure_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsValid(boolean param2Boolean) {
        this.isValid_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setKeyword(String param2String) {
        if (param2String != null) {
          this.keyword_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setKeywordBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.keyword_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveId(String param2String) {
        if (param2String != null) {
          this.liveId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.liveId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMsgScreenClickType(MessageProtos.MsgScreenClickType param2MsgScreenClickType) {
        if (param2MsgScreenClickType != null) {
          this.msgScreenClickType_ = param2MsgScreenClickType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMsgScreenClickTypeValue(int param2Int) {
        this.msgScreenClickType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPhotoNum(int param2Int) {
        this.photoNum_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPhotoSource(MessageProtos.SourceType param2SourceType) {
        if (param2SourceType != null) {
          this.photoSource_ = param2SourceType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPhotoSourceValue(int param2Int) {
        this.photoSource_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPhotoType(MessageProtos.PhotoType param2PhotoType) {
        if (param2PhotoType != null) {
          this.photoType_ = param2PhotoType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPhotoTypeValue(int param2Int) {
        this.photoType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPosition(int param2Int) {
        this.position_ = param2Int;
        onChanged();
        return this;
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
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.roomId_ = param2ByteString;
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
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.roomUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setShowType(MessageProtos.ShowType param2ShowType) {
        if (param2ShowType != null) {
          this.showType_ = param2ShowType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setShowTypeValue(int param2Int) {
        this.showType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSortType(MessageProtos.SortType param2SortType) {
        if (param2SortType != null) {
          this.sortType_ = param2SortType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSortTypeValue(int param2Int) {
        this.sortType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setStrangerSource(MessageProtos.StrangerSource param2StrangerSource) {
        if (param2StrangerSource != null) {
          this.strangerSource_ = param2StrangerSource.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setStrangerSourceValue(int param2Int) {
        this.strangerSource_ = param2Int;
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
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setType(String param2String) {
        if (param2String != null) {
          this.type_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.type_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          MessageProtos.MessageProto.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setWarnTime(MessageProtos.WarnTime param2WarnTime) {
        if (param2WarnTime != null) {
          this.warnTime_ = param2WarnTime.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setWarnTimeValue(int param2Int) {
        this.warnTime_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setWarnType(MessageProtos.WarnType param2WarnType) {
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
  
  static final class null extends AbstractParser<MessageProto> {
    public MessageProtos.MessageProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new MessageProtos.MessageProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<MessageProto.Builder> implements MessageProtoOrBuilder {
    private Object callFilter_ = "";
    
    private Object destination_ = "";
    
    private Object disturbRange_ = "";
    
    private Object disturbSource_ = "";
    
    private int event_ = 0;
    
    private Object id_ = "";
    
    private Object imageId_ = "";
    
    private boolean isAi_;
    
    private boolean isAppreciateCall_;
    
    private boolean isBuy_;
    
    private boolean isMapFind_;
    
    private boolean isOpen_;
    
    private boolean isQuietCall_;
    
    private boolean isShadow_;
    
    private boolean isSuperExposure_;
    
    private boolean isValid_;
    
    private Object keyword_ = "";
    
    private Object liveId_ = "";
    
    private int msgScreenClickType_ = 0;
    
    private int photoNum_;
    
    private int photoSource_ = 0;
    
    private int photoType_ = 0;
    
    private int position_;
    
    private Object roomId_ = "";
    
    private Object roomUid_ = "";
    
    private int showType_ = 0;
    
    private int sortType_ = 0;
    
    private int strangerSource_ = 0;
    
    private Object targetUid_ = "";
    
    private Object type_ = "";
    
    private Object url_ = "";
    
    private int warnTime_ = 0;
    
    private int warnType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      MessageProtos.MessageProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public MessageProtos.MessageProto build() {
      MessageProtos.MessageProto messageProto = buildPartial();
      if (messageProto.isInitialized())
        return messageProto; 
      throw newUninitializedMessageException(messageProto);
    }
    
    public MessageProtos.MessageProto buildPartial() {
      MessageProtos.MessageProto messageProto = new MessageProtos.MessageProto(this);
      MessageProtos.MessageProto.access$602(messageProto, this.event_);
      MessageProtos.MessageProto.access$702(messageProto, this.msgScreenClickType_);
      MessageProtos.MessageProto.access$802(messageProto, this.targetUid_);
      MessageProtos.MessageProto.access$902(messageProto, this.photoSource_);
      MessageProtos.MessageProto.access$1002(messageProto, this.photoType_);
      MessageProtos.MessageProto.access$1102(messageProto, this.strangerSource_);
      MessageProtos.MessageProto.access$1202(messageProto, this.photoNum_);
      MessageProtos.MessageProto.access$1302(messageProto, this.disturbSource_);
      MessageProtos.MessageProto.access$1402(messageProto, this.disturbRange_);
      MessageProtos.MessageProto.access$1502(messageProto, this.isOpen_);
      MessageProtos.MessageProto.access$1602(messageProto, this.warnType_);
      MessageProtos.MessageProto.access$1702(messageProto, this.isMapFind_);
      MessageProtos.MessageProto.access$1802(messageProto, this.warnTime_);
      MessageProtos.MessageProto.access$1902(messageProto, this.isAppreciateCall_);
      MessageProtos.MessageProto.access$2002(messageProto, this.isQuietCall_);
      MessageProtos.MessageProto.access$2102(messageProto, this.isSuperExposure_);
      MessageProtos.MessageProto.access$2202(messageProto, this.isShadow_);
      MessageProtos.MessageProto.access$2302(messageProto, this.showType_);
      MessageProtos.MessageProto.access$2402(messageProto, this.imageId_);
      MessageProtos.MessageProto.access$2502(messageProto, this.isValid_);
      MessageProtos.MessageProto.access$2602(messageProto, this.callFilter_);
      MessageProtos.MessageProto.access$2702(messageProto, this.sortType_);
      MessageProtos.MessageProto.access$2802(messageProto, this.url_);
      MessageProtos.MessageProto.access$2902(messageProto, this.position_);
      MessageProtos.MessageProto.access$3002(messageProto, this.id_);
      MessageProtos.MessageProto.access$3102(messageProto, this.keyword_);
      MessageProtos.MessageProto.access$3202(messageProto, this.liveId_);
      MessageProtos.MessageProto.access$3302(messageProto, this.destination_);
      MessageProtos.MessageProto.access$3402(messageProto, this.type_);
      MessageProtos.MessageProto.access$3502(messageProto, this.isAi_);
      MessageProtos.MessageProto.access$3602(messageProto, this.roomId_);
      MessageProtos.MessageProto.access$3702(messageProto, this.roomUid_);
      MessageProtos.MessageProto.access$3802(messageProto, this.isBuy_);
      onBuilt();
      return messageProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.msgScreenClickType_ = 0;
      this.targetUid_ = "";
      this.photoSource_ = 0;
      this.photoType_ = 0;
      this.strangerSource_ = 0;
      this.photoNum_ = 0;
      this.disturbSource_ = "";
      this.disturbRange_ = "";
      this.isOpen_ = false;
      this.warnType_ = 0;
      this.isMapFind_ = false;
      this.warnTime_ = 0;
      this.isAppreciateCall_ = false;
      this.isQuietCall_ = false;
      this.isSuperExposure_ = false;
      this.isShadow_ = false;
      this.showType_ = 0;
      this.imageId_ = "";
      this.isValid_ = false;
      this.callFilter_ = "";
      this.sortType_ = 0;
      this.url_ = "";
      this.position_ = 0;
      this.id_ = "";
      this.keyword_ = "";
      this.liveId_ = "";
      this.destination_ = "";
      this.type_ = "";
      this.isAi_ = false;
      this.roomId_ = "";
      this.roomUid_ = "";
      this.isBuy_ = false;
      return this;
    }
    
    public Builder clearCallFilter() {
      this.callFilter_ = MessageProtos.MessageProto.getDefaultInstance().getCallFilter();
      onChanged();
      return this;
    }
    
    public Builder clearDestination() {
      this.destination_ = MessageProtos.MessageProto.getDefaultInstance().getDestination();
      onChanged();
      return this;
    }
    
    public Builder clearDisturbRange() {
      this.disturbRange_ = MessageProtos.MessageProto.getDefaultInstance().getDisturbRange();
      onChanged();
      return this;
    }
    
    public Builder clearDisturbSource() {
      this.disturbSource_ = MessageProtos.MessageProto.getDefaultInstance().getDisturbSource();
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
    
    public Builder clearId() {
      this.id_ = MessageProtos.MessageProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearImageId() {
      this.imageId_ = MessageProtos.MessageProto.getDefaultInstance().getImageId();
      onChanged();
      return this;
    }
    
    public Builder clearIsAi() {
      this.isAi_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsAppreciateCall() {
      this.isAppreciateCall_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsBuy() {
      this.isBuy_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsMapFind() {
      this.isMapFind_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsOpen() {
      this.isOpen_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsQuietCall() {
      this.isQuietCall_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsShadow() {
      this.isShadow_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsSuperExposure() {
      this.isSuperExposure_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsValid() {
      this.isValid_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearKeyword() {
      this.keyword_ = MessageProtos.MessageProto.getDefaultInstance().getKeyword();
      onChanged();
      return this;
    }
    
    public Builder clearLiveId() {
      this.liveId_ = MessageProtos.MessageProto.getDefaultInstance().getLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearMsgScreenClickType() {
      this.msgScreenClickType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPhotoNum() {
      this.photoNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPhotoSource() {
      this.photoSource_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPhotoType() {
      this.photoType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPosition() {
      this.position_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearRoomId() {
      this.roomId_ = MessageProtos.MessageProto.getDefaultInstance().getRoomId();
      onChanged();
      return this;
    }
    
    public Builder clearRoomUid() {
      this.roomUid_ = MessageProtos.MessageProto.getDefaultInstance().getRoomUid();
      onChanged();
      return this;
    }
    
    public Builder clearShowType() {
      this.showType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSortType() {
      this.sortType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearStrangerSource() {
      this.strangerSource_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = MessageProtos.MessageProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clearType() {
      this.type_ = MessageProtos.MessageProto.getDefaultInstance().getType();
      onChanged();
      return this;
    }
    
    public Builder clearUrl() {
      this.url_ = MessageProtos.MessageProto.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clearWarnTime() {
      this.warnTime_ = 0;
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
    
    public String getCallFilter() {
      Object object = this.callFilter_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.callFilter_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCallFilterBytes() {
      Object object = this.callFilter_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.callFilter_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public MessageProtos.MessageProto getDefaultInstanceForType() {
      return MessageProtos.MessageProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
    }
    
    public String getDestination() {
      Object object = this.destination_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.destination_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDestinationBytes() {
      Object object = this.destination_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.destination_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getDisturbRange() {
      Object object = this.disturbRange_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.disturbRange_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDisturbRangeBytes() {
      Object object = this.disturbRange_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.disturbRange_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getDisturbSource() {
      Object object = this.disturbSource_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.disturbSource_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDisturbSourceBytes() {
      Object object = this.disturbSource_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.disturbSource_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public MessageProtos.Event getEvent() {
      MessageProtos.Event event2 = MessageProtos.Event.valueOf(this.event_);
      MessageProtos.Event event1 = event2;
      if (event2 == null)
        event1 = MessageProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
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
    
    public String getImageId() {
      Object object = this.imageId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.imageId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getImageIdBytes() {
      Object object = this.imageId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.imageId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean getIsAi() {
      return this.isAi_;
    }
    
    public boolean getIsAppreciateCall() {
      return this.isAppreciateCall_;
    }
    
    public boolean getIsBuy() {
      return this.isBuy_;
    }
    
    public boolean getIsMapFind() {
      return this.isMapFind_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsQuietCall() {
      return this.isQuietCall_;
    }
    
    public boolean getIsShadow() {
      return this.isShadow_;
    }
    
    public boolean getIsSuperExposure() {
      return this.isSuperExposure_;
    }
    
    public boolean getIsValid() {
      return this.isValid_;
    }
    
    public String getKeyword() {
      Object object = this.keyword_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.keyword_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getKeywordBytes() {
      Object object = this.keyword_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.keyword_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLiveId() {
      Object object = this.liveId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.liveId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLiveIdBytes() {
      Object object = this.liveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public MessageProtos.MsgScreenClickType getMsgScreenClickType() {
      MessageProtos.MsgScreenClickType msgScreenClickType2 = MessageProtos.MsgScreenClickType.valueOf(this.msgScreenClickType_);
      MessageProtos.MsgScreenClickType msgScreenClickType1 = msgScreenClickType2;
      if (msgScreenClickType2 == null)
        msgScreenClickType1 = MessageProtos.MsgScreenClickType.UNRECOGNIZED; 
      return msgScreenClickType1;
    }
    
    public int getMsgScreenClickTypeValue() {
      return this.msgScreenClickType_;
    }
    
    public int getPhotoNum() {
      return this.photoNum_;
    }
    
    public MessageProtos.SourceType getPhotoSource() {
      MessageProtos.SourceType sourceType2 = MessageProtos.SourceType.valueOf(this.photoSource_);
      MessageProtos.SourceType sourceType1 = sourceType2;
      if (sourceType2 == null)
        sourceType1 = MessageProtos.SourceType.UNRECOGNIZED; 
      return sourceType1;
    }
    
    public int getPhotoSourceValue() {
      return this.photoSource_;
    }
    
    public MessageProtos.PhotoType getPhotoType() {
      MessageProtos.PhotoType photoType2 = MessageProtos.PhotoType.valueOf(this.photoType_);
      MessageProtos.PhotoType photoType1 = photoType2;
      if (photoType2 == null)
        photoType1 = MessageProtos.PhotoType.UNRECOGNIZED; 
      return photoType1;
    }
    
    public int getPhotoTypeValue() {
      return this.photoType_;
    }
    
    public int getPosition() {
      return this.position_;
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
    
    public MessageProtos.ShowType getShowType() {
      MessageProtos.ShowType showType2 = MessageProtos.ShowType.valueOf(this.showType_);
      MessageProtos.ShowType showType1 = showType2;
      if (showType2 == null)
        showType1 = MessageProtos.ShowType.UNRECOGNIZED; 
      return showType1;
    }
    
    public int getShowTypeValue() {
      return this.showType_;
    }
    
    public MessageProtos.SortType getSortType() {
      MessageProtos.SortType sortType2 = MessageProtos.SortType.valueOf(this.sortType_);
      MessageProtos.SortType sortType1 = sortType2;
      if (sortType2 == null)
        sortType1 = MessageProtos.SortType.UNRECOGNIZED; 
      return sortType1;
    }
    
    public int getSortTypeValue() {
      return this.sortType_;
    }
    
    public MessageProtos.StrangerSource getStrangerSource() {
      MessageProtos.StrangerSource strangerSource2 = MessageProtos.StrangerSource.valueOf(this.strangerSource_);
      MessageProtos.StrangerSource strangerSource1 = strangerSource2;
      if (strangerSource2 == null)
        strangerSource1 = MessageProtos.StrangerSource.UNRECOGNIZED; 
      return strangerSource1;
    }
    
    public int getStrangerSourceValue() {
      return this.strangerSource_;
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
    
    public String getType() {
      Object object = this.type_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.type_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTypeBytes() {
      Object object = this.type_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.type_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public MessageProtos.WarnTime getWarnTime() {
      MessageProtos.WarnTime warnTime2 = MessageProtos.WarnTime.valueOf(this.warnTime_);
      MessageProtos.WarnTime warnTime1 = warnTime2;
      if (warnTime2 == null)
        warnTime1 = MessageProtos.WarnTime.UNRECOGNIZED; 
      return warnTime1;
    }
    
    public int getWarnTimeValue() {
      return this.warnTime_;
    }
    
    public MessageProtos.WarnType getWarnType() {
      MessageProtos.WarnType warnType2 = MessageProtos.WarnType.valueOf(this.warnType_);
      MessageProtos.WarnType warnType1 = warnType2;
      if (warnType2 == null)
        warnType1 = MessageProtos.WarnType.UNRECOGNIZED; 
      return warnType1;
    }
    
    public int getWarnTypeValue() {
      return this.warnType_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MessageProtos.internal_static_com_blued_das_message_MessageProto_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageProtos.MessageProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(MessageProtos.MessageProto param1MessageProto) {
      if (param1MessageProto == MessageProtos.MessageProto.getDefaultInstance())
        return this; 
      if (param1MessageProto.event_ != 0)
        setEventValue(param1MessageProto.getEventValue()); 
      if (param1MessageProto.msgScreenClickType_ != 0)
        setMsgScreenClickTypeValue(param1MessageProto.getMsgScreenClickTypeValue()); 
      if (!param1MessageProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1MessageProto.targetUid_;
        onChanged();
      } 
      if (param1MessageProto.photoSource_ != 0)
        setPhotoSourceValue(param1MessageProto.getPhotoSourceValue()); 
      if (param1MessageProto.photoType_ != 0)
        setPhotoTypeValue(param1MessageProto.getPhotoTypeValue()); 
      if (param1MessageProto.strangerSource_ != 0)
        setStrangerSourceValue(param1MessageProto.getStrangerSourceValue()); 
      if (param1MessageProto.getPhotoNum() != 0)
        setPhotoNum(param1MessageProto.getPhotoNum()); 
      if (!param1MessageProto.getDisturbSource().isEmpty()) {
        this.disturbSource_ = param1MessageProto.disturbSource_;
        onChanged();
      } 
      if (!param1MessageProto.getDisturbRange().isEmpty()) {
        this.disturbRange_ = param1MessageProto.disturbRange_;
        onChanged();
      } 
      if (param1MessageProto.getIsOpen())
        setIsOpen(param1MessageProto.getIsOpen()); 
      if (param1MessageProto.warnType_ != 0)
        setWarnTypeValue(param1MessageProto.getWarnTypeValue()); 
      if (param1MessageProto.getIsMapFind())
        setIsMapFind(param1MessageProto.getIsMapFind()); 
      if (param1MessageProto.warnTime_ != 0)
        setWarnTimeValue(param1MessageProto.getWarnTimeValue()); 
      if (param1MessageProto.getIsAppreciateCall())
        setIsAppreciateCall(param1MessageProto.getIsAppreciateCall()); 
      if (param1MessageProto.getIsQuietCall())
        setIsQuietCall(param1MessageProto.getIsQuietCall()); 
      if (param1MessageProto.getIsSuperExposure())
        setIsSuperExposure(param1MessageProto.getIsSuperExposure()); 
      if (param1MessageProto.getIsShadow())
        setIsShadow(param1MessageProto.getIsShadow()); 
      if (param1MessageProto.showType_ != 0)
        setShowTypeValue(param1MessageProto.getShowTypeValue()); 
      if (!param1MessageProto.getImageId().isEmpty()) {
        this.imageId_ = param1MessageProto.imageId_;
        onChanged();
      } 
      if (param1MessageProto.getIsValid())
        setIsValid(param1MessageProto.getIsValid()); 
      if (!param1MessageProto.getCallFilter().isEmpty()) {
        this.callFilter_ = param1MessageProto.callFilter_;
        onChanged();
      } 
      if (param1MessageProto.sortType_ != 0)
        setSortTypeValue(param1MessageProto.getSortTypeValue()); 
      if (!param1MessageProto.getUrl().isEmpty()) {
        this.url_ = param1MessageProto.url_;
        onChanged();
      } 
      if (param1MessageProto.getPosition() != 0)
        setPosition(param1MessageProto.getPosition()); 
      if (!param1MessageProto.getId().isEmpty()) {
        this.id_ = param1MessageProto.id_;
        onChanged();
      } 
      if (!param1MessageProto.getKeyword().isEmpty()) {
        this.keyword_ = param1MessageProto.keyword_;
        onChanged();
      } 
      if (!param1MessageProto.getLiveId().isEmpty()) {
        this.liveId_ = param1MessageProto.liveId_;
        onChanged();
      } 
      if (!param1MessageProto.getDestination().isEmpty()) {
        this.destination_ = param1MessageProto.destination_;
        onChanged();
      } 
      if (!param1MessageProto.getType().isEmpty()) {
        this.type_ = param1MessageProto.type_;
        onChanged();
      } 
      if (param1MessageProto.getIsAi())
        setIsAi(param1MessageProto.getIsAi()); 
      if (!param1MessageProto.getRoomId().isEmpty()) {
        this.roomId_ = param1MessageProto.roomId_;
        onChanged();
      } 
      if (!param1MessageProto.getRoomUid().isEmpty()) {
        this.roomUid_ = param1MessageProto.roomUid_;
        onChanged();
      } 
      if (param1MessageProto.getIsBuy())
        setIsBuy(param1MessageProto.getIsBuy()); 
      mergeUnknownFields(param1MessageProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        MessageProtos.MessageProto messageProto = (MessageProtos.MessageProto)MessageProtos.MessageProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        MessageProtos.MessageProto messageProto = (MessageProtos.MessageProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((MessageProtos.MessageProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof MessageProtos.MessageProto)
        return mergeFrom((MessageProtos.MessageProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCallFilter(String param1String) {
      if (param1String != null) {
        this.callFilter_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCallFilterBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.callFilter_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDestination(String param1String) {
      if (param1String != null) {
        this.destination_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDestinationBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.destination_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisturbRange(String param1String) {
      if (param1String != null) {
        this.disturbRange_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisturbRangeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.disturbRange_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisturbSource(String param1String) {
      if (param1String != null) {
        this.disturbSource_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDisturbSourceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.disturbSource_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEvent(MessageProtos.Event param1Event) {
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
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setImageId(String param1String) {
      if (param1String != null) {
        this.imageId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setImageIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.imageId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIsAi(boolean param1Boolean) {
      this.isAi_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsAppreciateCall(boolean param1Boolean) {
      this.isAppreciateCall_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsBuy(boolean param1Boolean) {
      this.isBuy_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsMapFind(boolean param1Boolean) {
      this.isMapFind_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsOpen(boolean param1Boolean) {
      this.isOpen_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsQuietCall(boolean param1Boolean) {
      this.isQuietCall_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsShadow(boolean param1Boolean) {
      this.isShadow_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsSuperExposure(boolean param1Boolean) {
      this.isSuperExposure_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsValid(boolean param1Boolean) {
      this.isValid_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setKeyword(String param1String) {
      if (param1String != null) {
        this.keyword_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setKeywordBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.keyword_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveId(String param1String) {
      if (param1String != null) {
        this.liveId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.liveId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMsgScreenClickType(MessageProtos.MsgScreenClickType param1MsgScreenClickType) {
      if (param1MsgScreenClickType != null) {
        this.msgScreenClickType_ = param1MsgScreenClickType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMsgScreenClickTypeValue(int param1Int) {
      this.msgScreenClickType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPhotoNum(int param1Int) {
      this.photoNum_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPhotoSource(MessageProtos.SourceType param1SourceType) {
      if (param1SourceType != null) {
        this.photoSource_ = param1SourceType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPhotoSourceValue(int param1Int) {
      this.photoSource_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPhotoType(MessageProtos.PhotoType param1PhotoType) {
      if (param1PhotoType != null) {
        this.photoType_ = param1PhotoType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPhotoTypeValue(int param1Int) {
      this.photoType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPosition(int param1Int) {
      this.position_ = param1Int;
      onChanged();
      return this;
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
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.roomId_ = param1ByteString;
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
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.roomUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setShowType(MessageProtos.ShowType param1ShowType) {
      if (param1ShowType != null) {
        this.showType_ = param1ShowType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setShowTypeValue(int param1Int) {
      this.showType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSortType(MessageProtos.SortType param1SortType) {
      if (param1SortType != null) {
        this.sortType_ = param1SortType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSortTypeValue(int param1Int) {
      this.sortType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setStrangerSource(MessageProtos.StrangerSource param1StrangerSource) {
      if (param1StrangerSource != null) {
        this.strangerSource_ = param1StrangerSource.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setStrangerSourceValue(int param1Int) {
      this.strangerSource_ = param1Int;
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
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setType(String param1String) {
      if (param1String != null) {
        this.type_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.type_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        MessageProtos.MessageProto.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setWarnTime(MessageProtos.WarnTime param1WarnTime) {
      if (param1WarnTime != null) {
        this.warnTime_ = param1WarnTime.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setWarnTimeValue(int param1Int) {
      this.warnTime_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setWarnType(MessageProtos.WarnType param1WarnType) {
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
  
  public static interface MessageProtoOrBuilder extends MessageOrBuilder {
    String getCallFilter();
    
    ByteString getCallFilterBytes();
    
    String getDestination();
    
    ByteString getDestinationBytes();
    
    String getDisturbRange();
    
    ByteString getDisturbRangeBytes();
    
    String getDisturbSource();
    
    ByteString getDisturbSourceBytes();
    
    MessageProtos.Event getEvent();
    
    int getEventValue();
    
    String getId();
    
    ByteString getIdBytes();
    
    String getImageId();
    
    ByteString getImageIdBytes();
    
    boolean getIsAi();
    
    boolean getIsAppreciateCall();
    
    boolean getIsBuy();
    
    boolean getIsMapFind();
    
    boolean getIsOpen();
    
    boolean getIsQuietCall();
    
    boolean getIsShadow();
    
    boolean getIsSuperExposure();
    
    boolean getIsValid();
    
    String getKeyword();
    
    ByteString getKeywordBytes();
    
    String getLiveId();
    
    ByteString getLiveIdBytes();
    
    MessageProtos.MsgScreenClickType getMsgScreenClickType();
    
    int getMsgScreenClickTypeValue();
    
    int getPhotoNum();
    
    MessageProtos.SourceType getPhotoSource();
    
    int getPhotoSourceValue();
    
    MessageProtos.PhotoType getPhotoType();
    
    int getPhotoTypeValue();
    
    int getPosition();
    
    String getRoomId();
    
    ByteString getRoomIdBytes();
    
    String getRoomUid();
    
    ByteString getRoomUidBytes();
    
    MessageProtos.ShowType getShowType();
    
    int getShowTypeValue();
    
    MessageProtos.SortType getSortType();
    
    int getSortTypeValue();
    
    MessageProtos.StrangerSource getStrangerSource();
    
    int getStrangerSourceValue();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
    
    String getType();
    
    ByteString getTypeBytes();
    
    String getUrl();
    
    ByteString getUrlBytes();
    
    MessageProtos.WarnTime getWarnTime();
    
    int getWarnTimeValue();
    
    MessageProtos.WarnType getWarnType();
    
    int getWarnTypeValue();
  }
  
  public enum MsgScreenClickType implements ProtocolMessageEnum {
    MSG_SCREEN_CLICK_TYPE_CLOSE(0),
    MSG_SCREEN_CLICK_TYPE_OPEN(0),
    UNKNOWN_MSG_SCREEN_CLICK_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int MSG_SCREEN_CLICK_TYPE_CLOSE_VALUE = 2;
    
    public static final int MSG_SCREEN_CLICK_TYPE_OPEN_VALUE = 1;
    
    public static final int UNKNOWN_MSG_SCREEN_CLICK_TYPE_VALUE = 0;
    
    private static final MsgScreenClickType[] VALUES;
    
    private static final Internal.EnumLiteMap<MsgScreenClickType> internalValueMap;
    
    private final int value;
    
    static {
      MSG_SCREEN_CLICK_TYPE_CLOSE = new MsgScreenClickType("MSG_SCREEN_CLICK_TYPE_CLOSE", 2, 2);
      UNRECOGNIZED = new MsgScreenClickType("UNRECOGNIZED", 3, -1);
      $VALUES = new MsgScreenClickType[] { UNKNOWN_MSG_SCREEN_CLICK_TYPE, MSG_SCREEN_CLICK_TYPE_OPEN, MSG_SCREEN_CLICK_TYPE_CLOSE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<MsgScreenClickType>() {
          public MessageProtos.MsgScreenClickType findValueByNumber(int param2Int) {
            return MessageProtos.MsgScreenClickType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    MsgScreenClickType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static MsgScreenClickType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : MSG_SCREEN_CLICK_TYPE_CLOSE) : MSG_SCREEN_CLICK_TYPE_OPEN) : UNKNOWN_MSG_SCREEN_CLICK_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<MsgScreenClickType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<MsgScreenClickType> {
    public MessageProtos.MsgScreenClickType findValueByNumber(int param1Int) {
      return MessageProtos.MsgScreenClickType.forNumber(param1Int);
    }
  }
  
  public enum PhotoType implements ProtocolMessageEnum {
    BURN_AFTER_READ(0),
    NORMAL_PHOTO(0),
    UNKNOWN_PHOTO_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int BURN_AFTER_READ_VALUE = 2;
    
    public static final int NORMAL_PHOTO_VALUE = 1;
    
    public static final int UNKNOWN_PHOTO_TYPE_VALUE = 0;
    
    private static final PhotoType[] VALUES;
    
    private static final Internal.EnumLiteMap<PhotoType> internalValueMap;
    
    private final int value;
    
    static {
      BURN_AFTER_READ = new PhotoType("BURN_AFTER_READ", 2, 2);
      UNRECOGNIZED = new PhotoType("UNRECOGNIZED", 3, -1);
      $VALUES = new PhotoType[] { UNKNOWN_PHOTO_TYPE, NORMAL_PHOTO, BURN_AFTER_READ, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PhotoType>() {
          public MessageProtos.PhotoType findValueByNumber(int param2Int) {
            return MessageProtos.PhotoType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PhotoType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PhotoType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : BURN_AFTER_READ) : NORMAL_PHOTO) : UNKNOWN_PHOTO_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<PhotoType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PhotoType> {
    public MessageProtos.PhotoType findValueByNumber(int param1Int) {
      return MessageProtos.PhotoType.forNumber(param1Int);
    }
  }
  
  public enum ShowType implements ProtocolMessageEnum {
    LIST_SHOW(0),
    PALACE_SHOW(0),
    UNKNOWN_SHOW_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int LIST_SHOW_VALUE = 2;
    
    public static final int PALACE_SHOW_VALUE = 1;
    
    public static final int UNKNOWN_SHOW_TYPE_VALUE = 0;
    
    private static final ShowType[] VALUES;
    
    private static final Internal.EnumLiteMap<ShowType> internalValueMap;
    
    private final int value;
    
    static {
      LIST_SHOW = new ShowType("LIST_SHOW", 2, 2);
      UNRECOGNIZED = new ShowType("UNRECOGNIZED", 3, -1);
      $VALUES = new ShowType[] { UNKNOWN_SHOW_TYPE, PALACE_SHOW, LIST_SHOW, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ShowType>() {
          public MessageProtos.ShowType findValueByNumber(int param2Int) {
            return MessageProtos.ShowType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    ShowType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ShowType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : LIST_SHOW) : PALACE_SHOW) : UNKNOWN_SHOW_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(7);
    }
    
    public static Internal.EnumLiteMap<ShowType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<ShowType> {
    public MessageProtos.ShowType findValueByNumber(int param1Int) {
      return MessageProtos.ShowType.forNumber(param1Int);
    }
  }
  
  public enum SortType implements ProtocolMessageEnum {
    AI_SORT_TYPE(0),
    DISTANCE_SORT_TYPE(0),
    UNKNOWN_SORT_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int AI_SORT_TYPE_VALUE = 1;
    
    public static final int DISTANCE_SORT_TYPE_VALUE = 2;
    
    public static final int UNKNOWN_SORT_TYPE_VALUE = 0;
    
    private static final SortType[] VALUES;
    
    private static final Internal.EnumLiteMap<SortType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new SortType[] { UNKNOWN_SORT_TYPE, AI_SORT_TYPE, DISTANCE_SORT_TYPE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<SortType>() {
          public MessageProtos.SortType findValueByNumber(int param2Int) {
            return MessageProtos.SortType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    SortType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static SortType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : DISTANCE_SORT_TYPE) : AI_SORT_TYPE) : UNKNOWN_SORT_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(8);
    }
    
    public static Internal.EnumLiteMap<SortType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<SortType> {
    public MessageProtos.SortType findValueByNumber(int param1Int) {
      return MessageProtos.SortType.forNumber(param1Int);
    }
  }
  
  public enum SourceType implements ProtocolMessageEnum {
    COMPLETE_PHOTO(0),
    RECENT_PHOTO(0),
    UNKNOWN_SOURCE_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int COMPLETE_PHOTO_VALUE = 2;
    
    public static final int RECENT_PHOTO_VALUE = 1;
    
    public static final int UNKNOWN_SOURCE_TYPE_VALUE = 0;
    
    private static final SourceType[] VALUES;
    
    private static final Internal.EnumLiteMap<SourceType> internalValueMap;
    
    private final int value;
    
    static {
      COMPLETE_PHOTO = new SourceType("COMPLETE_PHOTO", 2, 2);
      UNRECOGNIZED = new SourceType("UNRECOGNIZED", 3, -1);
      $VALUES = new SourceType[] { UNKNOWN_SOURCE_TYPE, RECENT_PHOTO, COMPLETE_PHOTO, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<SourceType>() {
          public MessageProtos.SourceType findValueByNumber(int param2Int) {
            return MessageProtos.SourceType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    SourceType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static SourceType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : COMPLETE_PHOTO) : RECENT_PHOTO) : UNKNOWN_SOURCE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(3);
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
    public MessageProtos.SourceType findValueByNumber(int param1Int) {
      return MessageProtos.SourceType.forNumber(param1Int);
    }
  }
  
  public enum StrangerSource implements ProtocolMessageEnum {
    APPRECIATE_CALL_COMPLEX(0),
    APPRECIATE_CALL_ONLINE(0),
    APPRECIATE_CALL_SHORT(0),
    APPRECIATE_CALL_TOTAL(0),
    APPRECIATE_FIND(0),
    APPRECIATE_NEARBY(0),
    APPRECIATE_SUPER_EXPOSURE(0),
    CHAT_ROOM(0),
    CIRCLE_DETAIL_NOTE_HOT(0),
    CIRCLE_DETAIL_NOTE_NEW(0),
    CIRCLE_NOTE_DETAIL(0),
    CIRCLE_USERS(0),
    COMPLEX_SORT(0),
    DISTANCE_SORT(0),
    FEED_COMMENT(0),
    FEED_DETAIL(0),
    FEED_FIND_PHOTO(0),
    FEED_FIND_PLAZA(0),
    FEED_NEARBY(0),
    FEED_NOT_SUPER_EXPOSURE(0),
    FEED_PERSONAL_TOPIC(0),
    FIND_PLAZA_FLASH(0),
    FIND_PLAZA_FLASH_DETAIL(0),
    FIND_PLAZA_FOLLOW(0),
    FIND_PLAZA_IMAGE(0),
    FIND_PLAZA_NEARBY(0),
    FIND_PLAZA_RECOMMEND(0),
    FIND_PLAZA_RECOMMEND_USER(0),
    FOLLOW_ATTENTION(0),
    FRIEND_NEARBY_NEARBY(0),
    FRIEND_NEARBY_NEW_FACE(0),
    FRIEND_NEARBY_ONLINE(0),
    FRIEND_NEARBY_PERSONAL_NEARBY(0),
    FRIEND_NEARBY_VIEW(0),
    FRIEND_NEARBY_VISIT(0),
    GROUP_CHAT(0),
    LIVE(0),
    MAP_FIND(0),
    MINE_FAN(0),
    MINE_FOLLOW(0),
    MINE_FRIEND(0),
    NEARBY_FEATURED(0),
    NEW_FACE(0),
    ONE_CITY(0),
    ONLINE_TIME_SORT(0),
    PAGE_FEED_DETAIL_MORE(0),
    PAGE_FEED_LIKE(0),
    PAGE_FEED_MINE(0),
    SHADOW_SOURCE(0),
    SUPER_TOPIC_DETAIL(0),
    UNKNOWN_STRANGER_SOURCE(0),
    UNRECOGNIZED(0);
    
    public static final int APPRECIATE_CALL_COMPLEX_VALUE = 22;
    
    public static final int APPRECIATE_CALL_ONLINE_VALUE = 23;
    
    public static final int APPRECIATE_CALL_SHORT_VALUE = 13;
    
    public static final int APPRECIATE_CALL_TOTAL_VALUE = 14;
    
    public static final int APPRECIATE_FIND_VALUE = 16;
    
    public static final int APPRECIATE_NEARBY_VALUE = 15;
    
    public static final int APPRECIATE_SUPER_EXPOSURE_VALUE = 17;
    
    public static final int CHAT_ROOM_VALUE = 50;
    
    public static final int CIRCLE_DETAIL_NOTE_HOT_VALUE = 46;
    
    public static final int CIRCLE_DETAIL_NOTE_NEW_VALUE = 45;
    
    public static final int CIRCLE_NOTE_DETAIL_VALUE = 44;
    
    public static final int CIRCLE_USERS_VALUE = 47;
    
    public static final int COMPLEX_SORT_VALUE = 26;
    
    public static final int DISTANCE_SORT_VALUE = 28;
    
    public static final int FEED_COMMENT_VALUE = 30;
    
    public static final int FEED_DETAIL_VALUE = 40;
    
    public static final int FEED_FIND_PHOTO_VALUE = 9;
    
    public static final int FEED_FIND_PLAZA_VALUE = 10;
    
    public static final int FEED_NEARBY_VALUE = 8;
    
    public static final int FEED_NOT_SUPER_EXPOSURE_VALUE = 12;
    
    public static final int FEED_PERSONAL_TOPIC_VALUE = 11;
    
    public static final int FIND_PLAZA_FLASH_DETAIL_VALUE = 39;
    
    public static final int FIND_PLAZA_FLASH_VALUE = 38;
    
    public static final int FIND_PLAZA_FOLLOW_VALUE = 35;
    
    public static final int FIND_PLAZA_IMAGE_VALUE = 37;
    
    public static final int FIND_PLAZA_NEARBY_VALUE = 36;
    
    public static final int FIND_PLAZA_RECOMMEND_USER_VALUE = 33;
    
    public static final int FIND_PLAZA_RECOMMEND_VALUE = 34;
    
    public static final int FOLLOW_ATTENTION_VALUE = 7;
    
    public static final int FRIEND_NEARBY_NEARBY_VALUE = 3;
    
    public static final int FRIEND_NEARBY_NEW_FACE_VALUE = 5;
    
    public static final int FRIEND_NEARBY_ONLINE_VALUE = 4;
    
    public static final int FRIEND_NEARBY_PERSONAL_NEARBY_VALUE = 6;
    
    public static final int FRIEND_NEARBY_VIEW_VALUE = 2;
    
    public static final int FRIEND_NEARBY_VISIT_VALUE = 1;
    
    public static final int GROUP_CHAT_VALUE = 49;
    
    public static final int LIVE_VALUE = 18;
    
    public static final int MAP_FIND_VALUE = 21;
    
    public static final int MINE_FAN_VALUE = 20;
    
    public static final int MINE_FOLLOW_VALUE = 19;
    
    public static final int MINE_FRIEND_VALUE = 25;
    
    public static final int NEARBY_FEATURED_VALUE = 29;
    
    public static final int NEW_FACE_VALUE = 31;
    
    public static final int ONE_CITY_VALUE = 48;
    
    public static final int ONLINE_TIME_SORT_VALUE = 27;
    
    public static final int PAGE_FEED_DETAIL_MORE_VALUE = 43;
    
    public static final int PAGE_FEED_LIKE_VALUE = 42;
    
    public static final int PAGE_FEED_MINE_VALUE = 41;
    
    public static final int SHADOW_SOURCE_VALUE = 24;
    
    public static final int SUPER_TOPIC_DETAIL_VALUE = 32;
    
    public static final int UNKNOWN_STRANGER_SOURCE_VALUE = 0;
    
    private static final StrangerSource[] VALUES;
    
    private static final Internal.EnumLiteMap<StrangerSource> internalValueMap;
    
    private final int value;
    
    static {
      FRIEND_NEARBY_VIEW = new StrangerSource("FRIEND_NEARBY_VIEW", 2, 2);
      FRIEND_NEARBY_NEARBY = new StrangerSource("FRIEND_NEARBY_NEARBY", 3, 3);
      FRIEND_NEARBY_ONLINE = new StrangerSource("FRIEND_NEARBY_ONLINE", 4, 4);
      FRIEND_NEARBY_NEW_FACE = new StrangerSource("FRIEND_NEARBY_NEW_FACE", 5, 5);
      FRIEND_NEARBY_PERSONAL_NEARBY = new StrangerSource("FRIEND_NEARBY_PERSONAL_NEARBY", 6, 6);
      FOLLOW_ATTENTION = new StrangerSource("FOLLOW_ATTENTION", 7, 7);
      FEED_NEARBY = new StrangerSource("FEED_NEARBY", 8, 8);
      FEED_FIND_PHOTO = new StrangerSource("FEED_FIND_PHOTO", 9, 9);
      FEED_FIND_PLAZA = new StrangerSource("FEED_FIND_PLAZA", 10, 10);
      FEED_PERSONAL_TOPIC = new StrangerSource("FEED_PERSONAL_TOPIC", 11, 11);
      FEED_NOT_SUPER_EXPOSURE = new StrangerSource("FEED_NOT_SUPER_EXPOSURE", 12, 12);
      APPRECIATE_CALL_SHORT = new StrangerSource("APPRECIATE_CALL_SHORT", 13, 13);
      APPRECIATE_CALL_TOTAL = new StrangerSource("APPRECIATE_CALL_TOTAL", 14, 14);
      APPRECIATE_NEARBY = new StrangerSource("APPRECIATE_NEARBY", 15, 15);
      APPRECIATE_FIND = new StrangerSource("APPRECIATE_FIND", 16, 16);
      APPRECIATE_SUPER_EXPOSURE = new StrangerSource("APPRECIATE_SUPER_EXPOSURE", 17, 17);
      LIVE = new StrangerSource("LIVE", 18, 18);
      MINE_FOLLOW = new StrangerSource("MINE_FOLLOW", 19, 19);
      MINE_FAN = new StrangerSource("MINE_FAN", 20, 20);
      MAP_FIND = new StrangerSource("MAP_FIND", 21, 21);
      APPRECIATE_CALL_COMPLEX = new StrangerSource("APPRECIATE_CALL_COMPLEX", 22, 22);
      APPRECIATE_CALL_ONLINE = new StrangerSource("APPRECIATE_CALL_ONLINE", 23, 23);
      SHADOW_SOURCE = new StrangerSource("SHADOW_SOURCE", 24, 24);
      MINE_FRIEND = new StrangerSource("MINE_FRIEND", 25, 25);
      COMPLEX_SORT = new StrangerSource("COMPLEX_SORT", 26, 26);
      ONLINE_TIME_SORT = new StrangerSource("ONLINE_TIME_SORT", 27, 27);
      DISTANCE_SORT = new StrangerSource("DISTANCE_SORT", 28, 28);
      NEARBY_FEATURED = new StrangerSource("NEARBY_FEATURED", 29, 29);
      FEED_COMMENT = new StrangerSource("FEED_COMMENT", 30, 30);
      NEW_FACE = new StrangerSource("NEW_FACE", 31, 31);
      SUPER_TOPIC_DETAIL = new StrangerSource("SUPER_TOPIC_DETAIL", 32, 32);
      FIND_PLAZA_RECOMMEND_USER = new StrangerSource("FIND_PLAZA_RECOMMEND_USER", 33, 33);
      FIND_PLAZA_RECOMMEND = new StrangerSource("FIND_PLAZA_RECOMMEND", 34, 34);
      FIND_PLAZA_FOLLOW = new StrangerSource("FIND_PLAZA_FOLLOW", 35, 35);
      FIND_PLAZA_NEARBY = new StrangerSource("FIND_PLAZA_NEARBY", 36, 36);
      FIND_PLAZA_IMAGE = new StrangerSource("FIND_PLAZA_IMAGE", 37, 37);
      FIND_PLAZA_FLASH = new StrangerSource("FIND_PLAZA_FLASH", 38, 38);
      FIND_PLAZA_FLASH_DETAIL = new StrangerSource("FIND_PLAZA_FLASH_DETAIL", 39, 39);
      FEED_DETAIL = new StrangerSource("FEED_DETAIL", 40, 40);
      PAGE_FEED_MINE = new StrangerSource("PAGE_FEED_MINE", 41, 41);
      PAGE_FEED_LIKE = new StrangerSource("PAGE_FEED_LIKE", 42, 42);
      PAGE_FEED_DETAIL_MORE = new StrangerSource("PAGE_FEED_DETAIL_MORE", 43, 43);
      CIRCLE_NOTE_DETAIL = new StrangerSource("CIRCLE_NOTE_DETAIL", 44, 44);
      CIRCLE_DETAIL_NOTE_NEW = new StrangerSource("CIRCLE_DETAIL_NOTE_NEW", 45, 45);
      CIRCLE_DETAIL_NOTE_HOT = new StrangerSource("CIRCLE_DETAIL_NOTE_HOT", 46, 46);
      CIRCLE_USERS = new StrangerSource("CIRCLE_USERS", 47, 47);
      ONE_CITY = new StrangerSource("ONE_CITY", 48, 48);
      GROUP_CHAT = new StrangerSource("GROUP_CHAT", 49, 49);
      CHAT_ROOM = new StrangerSource("CHAT_ROOM", 50, 50);
      UNRECOGNIZED = new StrangerSource("UNRECOGNIZED", 51, -1);
      $VALUES = new StrangerSource[] { 
          UNKNOWN_STRANGER_SOURCE, FRIEND_NEARBY_VISIT, FRIEND_NEARBY_VIEW, FRIEND_NEARBY_NEARBY, FRIEND_NEARBY_ONLINE, FRIEND_NEARBY_NEW_FACE, FRIEND_NEARBY_PERSONAL_NEARBY, FOLLOW_ATTENTION, FEED_NEARBY, FEED_FIND_PHOTO, 
          FEED_FIND_PLAZA, FEED_PERSONAL_TOPIC, FEED_NOT_SUPER_EXPOSURE, APPRECIATE_CALL_SHORT, APPRECIATE_CALL_TOTAL, APPRECIATE_NEARBY, APPRECIATE_FIND, APPRECIATE_SUPER_EXPOSURE, LIVE, MINE_FOLLOW, 
          MINE_FAN, MAP_FIND, APPRECIATE_CALL_COMPLEX, APPRECIATE_CALL_ONLINE, SHADOW_SOURCE, MINE_FRIEND, COMPLEX_SORT, ONLINE_TIME_SORT, DISTANCE_SORT, NEARBY_FEATURED, 
          FEED_COMMENT, NEW_FACE, SUPER_TOPIC_DETAIL, FIND_PLAZA_RECOMMEND_USER, FIND_PLAZA_RECOMMEND, FIND_PLAZA_FOLLOW, FIND_PLAZA_NEARBY, FIND_PLAZA_IMAGE, FIND_PLAZA_FLASH, FIND_PLAZA_FLASH_DETAIL, 
          FEED_DETAIL, PAGE_FEED_MINE, PAGE_FEED_LIKE, PAGE_FEED_DETAIL_MORE, CIRCLE_NOTE_DETAIL, CIRCLE_DETAIL_NOTE_NEW, CIRCLE_DETAIL_NOTE_HOT, CIRCLE_USERS, ONE_CITY, GROUP_CHAT, 
          CHAT_ROOM, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<StrangerSource>() {
          public MessageProtos.StrangerSource findValueByNumber(int param2Int) {
            return MessageProtos.StrangerSource.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    StrangerSource(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static StrangerSource forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 50:
          return CHAT_ROOM;
        case 49:
          return GROUP_CHAT;
        case 48:
          return ONE_CITY;
        case 47:
          return CIRCLE_USERS;
        case 46:
          return CIRCLE_DETAIL_NOTE_HOT;
        case 45:
          return CIRCLE_DETAIL_NOTE_NEW;
        case 44:
          return CIRCLE_NOTE_DETAIL;
        case 43:
          return PAGE_FEED_DETAIL_MORE;
        case 42:
          return PAGE_FEED_LIKE;
        case 41:
          return PAGE_FEED_MINE;
        case 40:
          return FEED_DETAIL;
        case 39:
          return FIND_PLAZA_FLASH_DETAIL;
        case 38:
          return FIND_PLAZA_FLASH;
        case 37:
          return FIND_PLAZA_IMAGE;
        case 36:
          return FIND_PLAZA_NEARBY;
        case 35:
          return FIND_PLAZA_FOLLOW;
        case 34:
          return FIND_PLAZA_RECOMMEND;
        case 33:
          return FIND_PLAZA_RECOMMEND_USER;
        case 32:
          return SUPER_TOPIC_DETAIL;
        case 31:
          return NEW_FACE;
        case 30:
          return FEED_COMMENT;
        case 29:
          return NEARBY_FEATURED;
        case 28:
          return DISTANCE_SORT;
        case 27:
          return ONLINE_TIME_SORT;
        case 26:
          return COMPLEX_SORT;
        case 25:
          return MINE_FRIEND;
        case 24:
          return SHADOW_SOURCE;
        case 23:
          return APPRECIATE_CALL_ONLINE;
        case 22:
          return APPRECIATE_CALL_COMPLEX;
        case 21:
          return MAP_FIND;
        case 20:
          return MINE_FAN;
        case 19:
          return MINE_FOLLOW;
        case 18:
          return LIVE;
        case 17:
          return APPRECIATE_SUPER_EXPOSURE;
        case 16:
          return APPRECIATE_FIND;
        case 15:
          return APPRECIATE_NEARBY;
        case 14:
          return APPRECIATE_CALL_TOTAL;
        case 13:
          return APPRECIATE_CALL_SHORT;
        case 12:
          return FEED_NOT_SUPER_EXPOSURE;
        case 11:
          return FEED_PERSONAL_TOPIC;
        case 10:
          return FEED_FIND_PLAZA;
        case 9:
          return FEED_FIND_PHOTO;
        case 8:
          return FEED_NEARBY;
        case 7:
          return FOLLOW_ATTENTION;
        case 6:
          return FRIEND_NEARBY_PERSONAL_NEARBY;
        case 5:
          return FRIEND_NEARBY_NEW_FACE;
        case 4:
          return FRIEND_NEARBY_ONLINE;
        case 3:
          return FRIEND_NEARBY_NEARBY;
        case 2:
          return FRIEND_NEARBY_VIEW;
        case 1:
          return FRIEND_NEARBY_VISIT;
        case 0:
          break;
      } 
      return UNKNOWN_STRANGER_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<StrangerSource> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<StrangerSource> {
    public MessageProtos.StrangerSource findValueByNumber(int param1Int) {
      return MessageProtos.StrangerSource.forNumber(param1Int);
    }
  }
  
  public enum WarnTime implements ProtocolMessageEnum {
    CHAT_FIRST(0),
    LIVE_FIRST(0),
    TOAST_LIVE(0),
    TOAST_MSG(0),
    UNKNOWN_WARN_TIME(0),
    UNREAD_FIRST(1),
    UNRECOGNIZED(1);
    
    public static final int CHAT_FIRST_VALUE = 2;
    
    public static final int LIVE_FIRST_VALUE = 3;
    
    public static final int TOAST_LIVE_VALUE = 5;
    
    public static final int TOAST_MSG_VALUE = 4;
    
    public static final int UNKNOWN_WARN_TIME_VALUE = 0;
    
    public static final int UNREAD_FIRST_VALUE = 1;
    
    private static final WarnTime[] VALUES;
    
    private static final Internal.EnumLiteMap<WarnTime> internalValueMap;
    
    private final int value;
    
    static {
      TOAST_LIVE = new WarnTime("TOAST_LIVE", 5, 5);
      UNRECOGNIZED = new WarnTime("UNRECOGNIZED", 6, -1);
      $VALUES = new WarnTime[] { UNKNOWN_WARN_TIME, UNREAD_FIRST, CHAT_FIRST, LIVE_FIRST, TOAST_MSG, TOAST_LIVE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<WarnTime>() {
          public MessageProtos.WarnTime findValueByNumber(int param2Int) {
            return MessageProtos.WarnTime.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    WarnTime(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static WarnTime forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : TOAST_LIVE) : TOAST_MSG) : LIVE_FIRST) : CHAT_FIRST) : UNREAD_FIRST) : UNKNOWN_WARN_TIME;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(6);
    }
    
    public static Internal.EnumLiteMap<WarnTime> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<WarnTime> {
    public MessageProtos.WarnTime findValueByNumber(int param1Int) {
      return MessageProtos.WarnTime.forNumber(param1Int);
    }
  }
  
  public enum WarnType implements ProtocolMessageEnum {
    UNKNOWN_WARN_TYPE(0),
    UNRECOGNIZED(0),
    POP_PUSH(1),
    TOAST_PUSH(1),
    TOAST_PUSH_PERMANENT(1);
    
    public static final int POP_PUSH_VALUE = 2;
    
    public static final int TOAST_PUSH_PERMANENT_VALUE = 3;
    
    public static final int TOAST_PUSH_VALUE = 1;
    
    public static final int UNKNOWN_WARN_TYPE_VALUE = 0;
    
    private static final WarnType[] VALUES;
    
    private static final Internal.EnumLiteMap<WarnType> internalValueMap;
    
    private final int value;
    
    static {
      POP_PUSH = new WarnType("POP_PUSH", 2, 2);
      TOAST_PUSH_PERMANENT = new WarnType("TOAST_PUSH_PERMANENT", 3, 3);
      UNRECOGNIZED = new WarnType("UNRECOGNIZED", 4, -1);
      $VALUES = new WarnType[] { UNKNOWN_WARN_TYPE, TOAST_PUSH, POP_PUSH, TOAST_PUSH_PERMANENT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<WarnType>() {
          public MessageProtos.WarnType findValueByNumber(int param2Int) {
            return MessageProtos.WarnType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    WarnType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static WarnType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : TOAST_PUSH_PERMANENT) : POP_PUSH) : TOAST_PUSH) : UNKNOWN_WARN_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MessageProtos.getDescriptor().getEnumTypes().get(5);
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
    public MessageProtos.WarnType findValueByNumber(int param1Int) {
      return MessageProtos.WarnType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\message\MessageProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.blued.das.profile;

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

public final class PersonalProfileProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033PersonalProfileProtos.proto\022\025com.blued.das.profile\"\007\n\024PersonalProfileProto\022+\n\005event\030\001 \001(\0162\034.com.blued.das.profile.Event\022-\n\006source\030\002 \001(\0162\035.com.blued.das.profile.Source\022\022\n\ntarget_uid\030\003 \001(\t\0222\n\tshow_type\030\005 \001(\0162\037.com.blued.das.profile.ShowType\022\020\n\bdistance\030\006 \001(\t\022\023\n\013online_time\030\007 \001(\t\022\016\n\006reason\030\b \001(\005\022\r\n\005label\030\t \001(\t\022\021\n\tphoto_num\030\n \001(\005\022\032\n\022is_appreciate_call\030\013 \001(\b\022\031\n\021is_super_exposure\030\f \001(\b\022\017\n\007gift_id\030\r \001(\t\0220\n\btab_type\030\016 \001(\0162\036.com.blued.das.profile.TabType\0226\n\013vote_option\030\017 \001(\0162!.com.blued.das.profile.VoteOption\0222\n\tgift_from\030\020 \001(\0162\037.com.blued.das.profile.GiftFrom\022\020\n\blink_url\030\021 \001(\t\022\017\n\007feed_id\030\022 \001(\t\022G\n\024target_identity_type\030\023 \001(\0162).com.blued.das.profile.TargetIdentityType\022\023\n\013is_map_find\030\024 \001(\b\022\021\n\tis_shadow\030\025 \001(\b\022\025\n\ris_quiet_call\030\026 \001(\b\022\021\n\tis_follow\030\027 \001(\b\022\024\n\fidentity_num\030\030 \001(\005\022\017\n\007is_open\030\031 \001(\b\022\020\n\bis_video\030\032 \001(\b\022\016\n\006is_bag\030\033 \001(\b\022\n\n\002id\030\034 \001(\t\022\017\n\007live_id\030\035 \001(\t\022\020\n\bposition\030\036 \001(\005\022\f\n\004type\030\037 \001(\005\022\013\n\003url\030  \001(\t\022\r\n\005is_ai\030! \001(\b\0226\n\013filter_type\030\" \001(\0162!.com.blued.das.profile.FilterType*\025\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022 \n\034PERSONAL_PROFILE_MEDAL_CLICK\020\001\022'\n#PERSONAL_PROFILE_FOLLOWED_BTN_CLICK\020\002\022#\n\037PERSONAL_PROFILE_CHAT_BTN_CLICK\020\003\022\036\n\032PERSONAL_PROFILE_PAGE_SHOW\020\004\022)\n%PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK\020\005\022*\n&PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK\020\006\022*\n&PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK\020\b\022,\n(PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK\020\t\022$\n PERSONAL_PROFILE_PAGE_PHOTO_SHOW\020\n\022+\n'PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK\020\013\022\033\n\027APPLY_PHOTO_AGREE_CLICK\020\f\022\034\n\030APPLY_PHOTO_IGNORE_CLICK\020\r\022*\n&PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK\020\016\022\026\n\022GIFT_BUY_PAGE_SHOW\020\017\022\037\n\033GIFT_BUY_PAGE_BUY_BTN_CLICK\020\020\022%\n!PERSONAL_PROFILE_LOAD_DEFAULT_TAB\020\024\022\036\n\032PERSONAL_PROFILE_SHIFT_TAB\020\025\022$\n BLUED_OFFICER_CONTINUE_BTN_CLICK\020\026\022 \n\034BLUED_OFFICER_BACK_BTN_CLICK\020\027\022 \n\034BLUED_OFFICER_VOTE_BTN_CLICK\020\030\022/\n+PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW\020\031\0220\n,PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK\020\032\022\"\n\036PERSONAL_PROFILE_VIP_SHED_SHOW\020\033\022#\n\037PERSONAL_PROFILE_VIP_SHED_CLICK\020\034\022\"\n\036PERSONAL_PROFILE_VIP_ICON_SHOW\020\035\022#\n\037PERSONAL_PROFILE_VIP_ICON_CLICK\020\036\022$\n PERSONAL_PROFILE_FEED_MORE_CLICK\020\037\022(\n$PERSONAL_PROFILE_FEED_MORE_TOP_CLICK\020 \022#\n\037PERSONAL_PROFILE_MORE_BTN_CLICK\020!\022\037\n\033EDIT_NICKNAME_CONFIRM_CLICK\020\"\022 \n\034EDIT_SIGNATURE_CONFIRM_CLICK\020#\022%\n!EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK\020$\022\034\n\030PERSONAL_PHOTO_PAGE_SHOW\020%\022\"\n\036PERSONAL_PHOTO_PAGE_PHOTO_SHOW\020&\022+\n'PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK\020'\022&\n\"PERSONAL_PROFILE_MORE_FOLLOW_CLICK\020(\022(\n$PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK\020)\022#\n\037PERSONAL_FULL_SCREEN_TEXT_CLICK\020*\022#\n\037PERSONAL_FULL_SCREEN_MORE_CLICK\020+\022$\n PERSONAL_FULL_SCREEN_SHARE_CLICK\020,\022&\n\"PERSONAL_FULL_SCREEN_COMMENT_CLICK\020-\022#\n\037PERSONAL_FULL_SCREEN_LIKE_CLICK\020.\022\036\n\032PERSONAL_MORE_PROFILE_SHOW\020/\022\037\n\033PERSONAL_MORE_PROFILE_CLICK\0200\022\033\n\027GIFT_BUY_PAGE_BAG_CLICK\0201\022\033\n\027PROFILE_GIFT_LIST_CLICK\0202\022\035\n\031PERSONAL_BACKGROUND_CLICK\0204\022$\n PERSONAL_BACKGROUND_CHANGE_CLICK\0205\022)\n%PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK\0206\022\027\n\023PROFILE_LIVING_SHOW\0207\022\035\n\031GIFT_BUY_FREE_BUBBLE_SHOW\0208\022\034\n\030GIFT_BUY_NEW_BUBBLE_SHOW\0209\0222\n.PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK\020:\022'\n#PERSONAL_LIVE_YEAR_END_PENDANT_SHOW\020;\022(\n$PERSONAL_LIVE_YEAR_END_PENDANT_CLICK\020<\022\031\n\025HEALTH_INFO_PAGE_SHOW\020=\022$\n HEALTH_INFO_PAGE_SUBSCRIBE_CLICK\020>\022\037\n\033HEALTH_INFO_PAGE_MORE_CLICK\020?\022'\n#HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK\020@\022\033\n\027PERSONAL_CHAT_ROOM_SHOW\020A\022\034\n\030PERSONAL_CHAT_ROOM_CLICK\020B\022\030\n\024PERSONAL_PHOTO_CLICK\020C\022$\n PERSONAL_LOOK_PHOTO_PENDANT_SHOW\020D\022%\n!PERSONAL_LOOK_PHOTO_PENDANT_CLICK\020E\022#\n\037PERSONAL_SET_PHOTO_PENDANT_SHOW\020F\022$\n PERSONAL_SET_PHOTO_PENDANT_CLICK\020G\022\033\n\027USER_PAGE_OPTIONS_CLICK\020H\022\031\n\025FEED_FULL_SCREEN_SHOW\020I\022\031\n\025PROFILE_MAX_BLACKLIST\020J\022\034\n\030PERSONAL_GIFT_LIST_CLICK\020K\022+\n'PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK\020L\022\031\n\025PROFILE_FOLLOW_FILTER\020M\022\037\n\033PROFILE_FOLLOW_QUEIT_FILTER\020N\022\027\n\023PROFILE_FANS_FILTER\020O\022\031\n\025PROFILE_FRIEND_FILTER\020P*Ì\006\n\006Source\022\031\n\025UNKNOWN_FOLLOW_SOURCE\020\000\022\027\n\023FRIEND_NEARBY_VISIT\020\001\022\026\n\022FRIEND_NEARBY_VIEW\020\002\022\024\n\020FOLLOW_ATTENTION\020\003\022\023\n\017FEED_FIND_PHOTO\020\004\022\023\n\017FEED_FIND_PLAZA\020\005\022\031\n\025APPRECIATE_CALL_SHORT\020\006\022\031\n\025APPRECIATE_CALL_TOTAL\020\007\022\017\n\013MINE_FOLLOW\020\b\022\f\n\bMINE_FAN\020\t\022\017\n\013MINE_FRIEND\020\n\022\020\n\fCOMPLEX_SORT\020\013\022\024\n\020ONLINE_TIME_SORT\020\f\022\021\n\rDISTANCE_SORT\020\r\022\023\n\017NEARBY_FEATURED\020\016\022\020\n\fFEED_COMMENT\020\017\022\f\n\bNEW_FACE\020\020\022\026\n\022SUPER_TOPIC_DETAIL\020\021\022\035\n\031FIND_PLAZA_RECOMMEND_USER\020\022\022\030\n\024FIND_PLAZA_RECOMMEND\020\023\022\025\n\021FIND_PLAZA_FOLLOW\020\024\022\025\n\021FIND_PLAZA_NEARBY\020\025\022\024\n\020FIND_PLAZA_IMAGE\020\026\022\024\n\020FIND_PLAZA_FLASH\020\027\022\033\n\027FIND_PLAZA_FLASH_DETAIL\020\030\022\017\n\013FEED_DETAIL\020\031\022\022\n\016PAGE_FEED_MINE\020\032\022\022\n\016PAGE_FEED_LIKE\020\033\022\031\n\025PAGE_FEED_DETAIL_MORE\020\034\022\026\n\022CIRCLE_NOTE_DETAIL\020\035\022\032\n\026CIRCLE_DETAIL_NOTE_NEW\020\036\022\032\n\026CIRCLE_DETAIL_NOTE_HOT\020\037\022\020\n\fCIRCLE_USERS\020 \022\f\n\bONE_CITY\020!\022\023\n\017FIND_TOPIC_FEED\020\"\022\035\n\031CIRCLE_ACTIVE_MEMBER_LIST\020#\022 \n\034CIRCLE_ACTIVE_MEMBER_MISSION\020$*A\n\bShowType\022\025\n\021UNKNOWN_SHOW_TYPE\020\000\022\017\n\013PALACE_SHOW\020\001\022\r\n\tLIST_SHOW\020\002*P\n\007TabType\022\024\n\020UNKNOWN_TAB_TYPE\020\000\022\r\n\tFEED_LOAD\020\001\022\020\n\fPROFILE_LOAD\020\002\022\016\n\nPHOTO_LOAD\020\003*O\n\nVoteOption\022\027\n\023UNKNOWN_VOTE_OPTION\020\000\022\013\n\007IS_JUNK\020\001\022\f\n\bNOT_JUNK\020\002\022\r\n\tUNCERTAIN\020\003*F\n\bGiftFrom\022\025\n\021UNKNOWN_GIFT_FROM\020\000\022\021\n\rPERSONAL_PAGE\020\001\022\020\n\fMESSAGE_PAGE\020\002*S\n\022TargetIdentityType\022 \n\034UNKNOWN_TARGET_IDENTITY_TYPE\020\000\022\b\n\004NONE\020\001\022\007\n\003VIP\020\002\022\b\n\004SVIP\020\003*J\n\nFilterType\022\027\n\023UNKNOWN_FILTER_TYPE\020\000\022\013\n\007DEFAULT\020\001\022\f\n\bLOCATION\020\002\022\b\n\004TIME\020\003B\023¢\002\020PERSONAL_PROFILEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_profile_PersonalProfileProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_profile_PersonalProfileProto_descriptor, new String[] { 
        "Event", "Source", "TargetUid", "ShowType", "Distance", "OnlineTime", "Reason", "Label", "PhotoNum", "IsAppreciateCall", 
        "IsSuperExposure", "GiftId", "TabType", "VoteOption", "GiftFrom", "LinkUrl", "FeedId", "TargetIdentityType", "IsMapFind", "IsShadow", 
        "IsQuietCall", "IsFollow", "IdentityNum", "IsOpen", "IsVideo", "IsBag", "Id", "LiveId", "Position", "Type", 
        "Url", "IsAi", "FilterType" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    APPLY_PHOTO_AGREE_CLICK,
    APPLY_PHOTO_IGNORE_CLICK,
    BLUED_OFFICER_BACK_BTN_CLICK,
    BLUED_OFFICER_CONTINUE_BTN_CLICK,
    BLUED_OFFICER_VOTE_BTN_CLICK,
    EDIT_NICKNAME_CONFIRM_CLICK,
    EDIT_SIGNATURE_CONFIRM_CLICK,
    EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK,
    FEED_FULL_SCREEN_SHOW,
    GIFT_BUY_FREE_BUBBLE_SHOW,
    GIFT_BUY_NEW_BUBBLE_SHOW,
    GIFT_BUY_PAGE_BAG_CLICK,
    GIFT_BUY_PAGE_BUY_BTN_CLICK,
    GIFT_BUY_PAGE_SHOW,
    HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK,
    HEALTH_INFO_PAGE_MORE_CLICK,
    HEALTH_INFO_PAGE_SHOW,
    HEALTH_INFO_PAGE_SUBSCRIBE_CLICK,
    PERSONAL_BACKGROUND_CHANGE_CLICK,
    PERSONAL_BACKGROUND_CLICK,
    PERSONAL_CHAT_ROOM_CLICK,
    PERSONAL_CHAT_ROOM_SHOW,
    PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK,
    PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK,
    PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK,
    PERSONAL_FULL_SCREEN_COMMENT_CLICK,
    PERSONAL_FULL_SCREEN_LIKE_CLICK,
    PERSONAL_FULL_SCREEN_MORE_CLICK,
    PERSONAL_FULL_SCREEN_SHARE_CLICK,
    PERSONAL_FULL_SCREEN_TEXT_CLICK,
    PERSONAL_GIFT_LIST_CLICK,
    PERSONAL_LIVE_YEAR_END_PENDANT_CLICK,
    PERSONAL_LIVE_YEAR_END_PENDANT_SHOW,
    PERSONAL_LOOK_PHOTO_PENDANT_CLICK,
    PERSONAL_LOOK_PHOTO_PENDANT_SHOW,
    PERSONAL_MORE_PROFILE_CLICK,
    PERSONAL_MORE_PROFILE_SHOW,
    PERSONAL_PHOTO_CLICK,
    PERSONAL_PHOTO_PAGE_PHOTO_SHOW,
    PERSONAL_PHOTO_PAGE_SHOW,
    PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK,
    PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW,
    PERSONAL_PROFILE_CHAT_BTN_CLICK,
    PERSONAL_PROFILE_FEED_MORE_CLICK,
    PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK,
    PERSONAL_PROFILE_FEED_MORE_TOP_CLICK,
    PERSONAL_PROFILE_FOLLOWED_BTN_CLICK,
    PERSONAL_PROFILE_LOAD_DEFAULT_TAB,
    PERSONAL_PROFILE_MEDAL_CLICK,
    PERSONAL_PROFILE_MORE_BTN_CLICK,
    PERSONAL_PROFILE_MORE_FOLLOW_CLICK,
    PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK,
    PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK,
    PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK,
    PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK,
    PERSONAL_PROFILE_PAGE_PHOTO_SHOW,
    PERSONAL_PROFILE_PAGE_SHOW,
    PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK,
    PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK,
    PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK,
    PERSONAL_PROFILE_SHIFT_TAB,
    PERSONAL_PROFILE_VIP_ICON_CLICK,
    PERSONAL_PROFILE_VIP_ICON_SHOW,
    PERSONAL_PROFILE_VIP_SHED_CLICK,
    PERSONAL_PROFILE_VIP_SHED_SHOW,
    PERSONAL_SET_PHOTO_PENDANT_CLICK,
    PERSONAL_SET_PHOTO_PENDANT_SHOW,
    PROFILE_FANS_FILTER,
    PROFILE_FOLLOW_FILTER,
    PROFILE_FOLLOW_QUEIT_FILTER,
    PROFILE_FRIEND_FILTER,
    PROFILE_GIFT_LIST_CLICK,
    PROFILE_LIVING_SHOW,
    PROFILE_MAX_BLACKLIST,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0),
    USER_PAGE_OPTIONS_CLICK(0);
    
    public static final int APPLY_PHOTO_AGREE_CLICK_VALUE = 12;
    
    public static final int APPLY_PHOTO_IGNORE_CLICK_VALUE = 13;
    
    public static final int BLUED_OFFICER_BACK_BTN_CLICK_VALUE = 23;
    
    public static final int BLUED_OFFICER_CONTINUE_BTN_CLICK_VALUE = 22;
    
    public static final int BLUED_OFFICER_VOTE_BTN_CLICK_VALUE = 24;
    
    public static final int EDIT_NICKNAME_CONFIRM_CLICK_VALUE = 34;
    
    public static final int EDIT_SIGNATURE_CONFIRM_CLICK_VALUE = 35;
    
    public static final int EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK_VALUE = 36;
    
    public static final int FEED_FULL_SCREEN_SHOW_VALUE = 73;
    
    public static final int GIFT_BUY_FREE_BUBBLE_SHOW_VALUE = 56;
    
    public static final int GIFT_BUY_NEW_BUBBLE_SHOW_VALUE = 57;
    
    public static final int GIFT_BUY_PAGE_BAG_CLICK_VALUE = 49;
    
    public static final int GIFT_BUY_PAGE_BUY_BTN_CLICK_VALUE = 16;
    
    public static final int GIFT_BUY_PAGE_SHOW_VALUE = 15;
    
    public static final int HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK_VALUE = 64;
    
    public static final int HEALTH_INFO_PAGE_MORE_CLICK_VALUE = 63;
    
    public static final int HEALTH_INFO_PAGE_SHOW_VALUE = 61;
    
    public static final int HEALTH_INFO_PAGE_SUBSCRIBE_CLICK_VALUE = 62;
    
    public static final int PERSONAL_BACKGROUND_CHANGE_CLICK_VALUE = 53;
    
    public static final int PERSONAL_BACKGROUND_CLICK_VALUE = 52;
    
    public static final int PERSONAL_CHAT_ROOM_CLICK_VALUE = 66;
    
    public static final int PERSONAL_CHAT_ROOM_SHOW_VALUE = 65;
    
    public static final int PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK_VALUE = 76;
    
    public static final int PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK_VALUE = 54;
    
    public static final int PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK_VALUE = 58;
    
    public static final int PERSONAL_FULL_SCREEN_COMMENT_CLICK_VALUE = 45;
    
    public static final int PERSONAL_FULL_SCREEN_LIKE_CLICK_VALUE = 46;
    
    public static final int PERSONAL_FULL_SCREEN_MORE_CLICK_VALUE = 43;
    
    public static final int PERSONAL_FULL_SCREEN_SHARE_CLICK_VALUE = 44;
    
    public static final int PERSONAL_FULL_SCREEN_TEXT_CLICK_VALUE = 42;
    
    public static final int PERSONAL_GIFT_LIST_CLICK_VALUE = 75;
    
    public static final int PERSONAL_LIVE_YEAR_END_PENDANT_CLICK_VALUE = 60;
    
    public static final int PERSONAL_LIVE_YEAR_END_PENDANT_SHOW_VALUE = 59;
    
    public static final int PERSONAL_LOOK_PHOTO_PENDANT_CLICK_VALUE = 69;
    
    public static final int PERSONAL_LOOK_PHOTO_PENDANT_SHOW_VALUE = 68;
    
    public static final int PERSONAL_MORE_PROFILE_CLICK_VALUE = 48;
    
    public static final int PERSONAL_MORE_PROFILE_SHOW_VALUE = 47;
    
    public static final int PERSONAL_PHOTO_CLICK_VALUE = 67;
    
    public static final int PERSONAL_PHOTO_PAGE_PHOTO_SHOW_VALUE = 38;
    
    public static final int PERSONAL_PHOTO_PAGE_SHOW_VALUE = 37;
    
    public static final int PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK_VALUE = 26;
    
    public static final int PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW_VALUE = 25;
    
    public static final int PERSONAL_PROFILE_CHAT_BTN_CLICK_VALUE = 3;
    
    public static final int PERSONAL_PROFILE_FEED_MORE_CLICK_VALUE = 31;
    
    public static final int PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK_VALUE = 39;
    
    public static final int PERSONAL_PROFILE_FEED_MORE_TOP_CLICK_VALUE = 32;
    
    public static final int PERSONAL_PROFILE_FOLLOWED_BTN_CLICK_VALUE = 2;
    
    public static final int PERSONAL_PROFILE_LOAD_DEFAULT_TAB_VALUE = 20;
    
    public static final int PERSONAL_PROFILE_MEDAL_CLICK_VALUE = 1;
    
    public static final int PERSONAL_PROFILE_MORE_BTN_CLICK_VALUE = 33;
    
    public static final int PERSONAL_PROFILE_MORE_FOLLOW_CLICK_VALUE = 40;
    
    public static final int PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK_VALUE = 41;
    
    public static final int PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK_VALUE = 11;
    
    public static final int PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK_VALUE = 14;
    
    public static final int PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK_VALUE = 8;
    
    public static final int PERSONAL_PROFILE_PAGE_PHOTO_SHOW_VALUE = 10;
    
    public static final int PERSONAL_PROFILE_PAGE_SHOW_VALUE = 4;
    
    public static final int PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK_VALUE = 6;
    
    public static final int PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK_VALUE = 5;
    
    public static final int PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK_VALUE = 9;
    
    public static final int PERSONAL_PROFILE_SHIFT_TAB_VALUE = 21;
    
    public static final int PERSONAL_PROFILE_VIP_ICON_CLICK_VALUE = 30;
    
    public static final int PERSONAL_PROFILE_VIP_ICON_SHOW_VALUE = 29;
    
    public static final int PERSONAL_PROFILE_VIP_SHED_CLICK_VALUE = 28;
    
    public static final int PERSONAL_PROFILE_VIP_SHED_SHOW_VALUE = 27;
    
    public static final int PERSONAL_SET_PHOTO_PENDANT_CLICK_VALUE = 71;
    
    public static final int PERSONAL_SET_PHOTO_PENDANT_SHOW_VALUE = 70;
    
    public static final int PROFILE_FANS_FILTER_VALUE = 79;
    
    public static final int PROFILE_FOLLOW_FILTER_VALUE = 77;
    
    public static final int PROFILE_FOLLOW_QUEIT_FILTER_VALUE = 78;
    
    public static final int PROFILE_FRIEND_FILTER_VALUE = 80;
    
    public static final int PROFILE_GIFT_LIST_CLICK_VALUE = 50;
    
    public static final int PROFILE_LIVING_SHOW_VALUE = 55;
    
    public static final int PROFILE_MAX_BLACKLIST_VALUE = 74;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    public static final int USER_PAGE_OPTIONS_CLICK_VALUE = 72;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      PERSONAL_PROFILE_FOLLOWED_BTN_CLICK = new Event("PERSONAL_PROFILE_FOLLOWED_BTN_CLICK", 2, 2);
      PERSONAL_PROFILE_CHAT_BTN_CLICK = new Event("PERSONAL_PROFILE_CHAT_BTN_CLICK", 3, 3);
      PERSONAL_PROFILE_PAGE_SHOW = new Event("PERSONAL_PROFILE_PAGE_SHOW", 4, 4);
      PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK = new Event("PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK", 5, 5);
      PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK = new Event("PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK", 6, 6);
      PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK = new Event("PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK", 7, 8);
      PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK = new Event("PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK", 8, 9);
      PERSONAL_PROFILE_PAGE_PHOTO_SHOW = new Event("PERSONAL_PROFILE_PAGE_PHOTO_SHOW", 9, 10);
      PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK = new Event("PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK", 10, 11);
      APPLY_PHOTO_AGREE_CLICK = new Event("APPLY_PHOTO_AGREE_CLICK", 11, 12);
      APPLY_PHOTO_IGNORE_CLICK = new Event("APPLY_PHOTO_IGNORE_CLICK", 12, 13);
      PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK = new Event("PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK", 13, 14);
      GIFT_BUY_PAGE_SHOW = new Event("GIFT_BUY_PAGE_SHOW", 14, 15);
      GIFT_BUY_PAGE_BUY_BTN_CLICK = new Event("GIFT_BUY_PAGE_BUY_BTN_CLICK", 15, 16);
      PERSONAL_PROFILE_LOAD_DEFAULT_TAB = new Event("PERSONAL_PROFILE_LOAD_DEFAULT_TAB", 16, 20);
      PERSONAL_PROFILE_SHIFT_TAB = new Event("PERSONAL_PROFILE_SHIFT_TAB", 17, 21);
      BLUED_OFFICER_CONTINUE_BTN_CLICK = new Event("BLUED_OFFICER_CONTINUE_BTN_CLICK", 18, 22);
      BLUED_OFFICER_BACK_BTN_CLICK = new Event("BLUED_OFFICER_BACK_BTN_CLICK", 19, 23);
      BLUED_OFFICER_VOTE_BTN_CLICK = new Event("BLUED_OFFICER_VOTE_BTN_CLICK", 20, 24);
      PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW = new Event("PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW", 21, 25);
      PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK = new Event("PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK", 22, 26);
      PERSONAL_PROFILE_VIP_SHED_SHOW = new Event("PERSONAL_PROFILE_VIP_SHED_SHOW", 23, 27);
      PERSONAL_PROFILE_VIP_SHED_CLICK = new Event("PERSONAL_PROFILE_VIP_SHED_CLICK", 24, 28);
      PERSONAL_PROFILE_VIP_ICON_SHOW = new Event("PERSONAL_PROFILE_VIP_ICON_SHOW", 25, 29);
      PERSONAL_PROFILE_VIP_ICON_CLICK = new Event("PERSONAL_PROFILE_VIP_ICON_CLICK", 26, 30);
      PERSONAL_PROFILE_FEED_MORE_CLICK = new Event("PERSONAL_PROFILE_FEED_MORE_CLICK", 27, 31);
      PERSONAL_PROFILE_FEED_MORE_TOP_CLICK = new Event("PERSONAL_PROFILE_FEED_MORE_TOP_CLICK", 28, 32);
      PERSONAL_PROFILE_MORE_BTN_CLICK = new Event("PERSONAL_PROFILE_MORE_BTN_CLICK", 29, 33);
      EDIT_NICKNAME_CONFIRM_CLICK = new Event("EDIT_NICKNAME_CONFIRM_CLICK", 30, 34);
      EDIT_SIGNATURE_CONFIRM_CLICK = new Event("EDIT_SIGNATURE_CONFIRM_CLICK", 31, 35);
      EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK = new Event("EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK", 32, 36);
      PERSONAL_PHOTO_PAGE_SHOW = new Event("PERSONAL_PHOTO_PAGE_SHOW", 33, 37);
      PERSONAL_PHOTO_PAGE_PHOTO_SHOW = new Event("PERSONAL_PHOTO_PAGE_PHOTO_SHOW", 34, 38);
      PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK = new Event("PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK", 35, 39);
      PERSONAL_PROFILE_MORE_FOLLOW_CLICK = new Event("PERSONAL_PROFILE_MORE_FOLLOW_CLICK", 36, 40);
      PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK = new Event("PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK", 37, 41);
      PERSONAL_FULL_SCREEN_TEXT_CLICK = new Event("PERSONAL_FULL_SCREEN_TEXT_CLICK", 38, 42);
      PERSONAL_FULL_SCREEN_MORE_CLICK = new Event("PERSONAL_FULL_SCREEN_MORE_CLICK", 39, 43);
      PERSONAL_FULL_SCREEN_SHARE_CLICK = new Event("PERSONAL_FULL_SCREEN_SHARE_CLICK", 40, 44);
      PERSONAL_FULL_SCREEN_COMMENT_CLICK = new Event("PERSONAL_FULL_SCREEN_COMMENT_CLICK", 41, 45);
      PERSONAL_FULL_SCREEN_LIKE_CLICK = new Event("PERSONAL_FULL_SCREEN_LIKE_CLICK", 42, 46);
      PERSONAL_MORE_PROFILE_SHOW = new Event("PERSONAL_MORE_PROFILE_SHOW", 43, 47);
      PERSONAL_MORE_PROFILE_CLICK = new Event("PERSONAL_MORE_PROFILE_CLICK", 44, 48);
      GIFT_BUY_PAGE_BAG_CLICK = new Event("GIFT_BUY_PAGE_BAG_CLICK", 45, 49);
      PROFILE_GIFT_LIST_CLICK = new Event("PROFILE_GIFT_LIST_CLICK", 46, 50);
      PERSONAL_BACKGROUND_CLICK = new Event("PERSONAL_BACKGROUND_CLICK", 47, 52);
      PERSONAL_BACKGROUND_CHANGE_CLICK = new Event("PERSONAL_BACKGROUND_CHANGE_CLICK", 48, 53);
      PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK = new Event("PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK", 49, 54);
      PROFILE_LIVING_SHOW = new Event("PROFILE_LIVING_SHOW", 50, 55);
      GIFT_BUY_FREE_BUBBLE_SHOW = new Event("GIFT_BUY_FREE_BUBBLE_SHOW", 51, 56);
      GIFT_BUY_NEW_BUBBLE_SHOW = new Event("GIFT_BUY_NEW_BUBBLE_SHOW", 52, 57);
      PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK = new Event("PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK", 53, 58);
      PERSONAL_LIVE_YEAR_END_PENDANT_SHOW = new Event("PERSONAL_LIVE_YEAR_END_PENDANT_SHOW", 54, 59);
      PERSONAL_LIVE_YEAR_END_PENDANT_CLICK = new Event("PERSONAL_LIVE_YEAR_END_PENDANT_CLICK", 55, 60);
      HEALTH_INFO_PAGE_SHOW = new Event("HEALTH_INFO_PAGE_SHOW", 56, 61);
      HEALTH_INFO_PAGE_SUBSCRIBE_CLICK = new Event("HEALTH_INFO_PAGE_SUBSCRIBE_CLICK", 57, 62);
      HEALTH_INFO_PAGE_MORE_CLICK = new Event("HEALTH_INFO_PAGE_MORE_CLICK", 58, 63);
      HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK = new Event("HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK", 59, 64);
      PERSONAL_CHAT_ROOM_SHOW = new Event("PERSONAL_CHAT_ROOM_SHOW", 60, 65);
      PERSONAL_CHAT_ROOM_CLICK = new Event("PERSONAL_CHAT_ROOM_CLICK", 61, 66);
      PERSONAL_PHOTO_CLICK = new Event("PERSONAL_PHOTO_CLICK", 62, 67);
      PERSONAL_LOOK_PHOTO_PENDANT_SHOW = new Event("PERSONAL_LOOK_PHOTO_PENDANT_SHOW", 63, 68);
      PERSONAL_LOOK_PHOTO_PENDANT_CLICK = new Event("PERSONAL_LOOK_PHOTO_PENDANT_CLICK", 64, 69);
      PERSONAL_SET_PHOTO_PENDANT_SHOW = new Event("PERSONAL_SET_PHOTO_PENDANT_SHOW", 65, 70);
      PERSONAL_SET_PHOTO_PENDANT_CLICK = new Event("PERSONAL_SET_PHOTO_PENDANT_CLICK", 66, 71);
      USER_PAGE_OPTIONS_CLICK = new Event("USER_PAGE_OPTIONS_CLICK", 67, 72);
      FEED_FULL_SCREEN_SHOW = new Event("FEED_FULL_SCREEN_SHOW", 68, 73);
      PROFILE_MAX_BLACKLIST = new Event("PROFILE_MAX_BLACKLIST", 69, 74);
      PERSONAL_GIFT_LIST_CLICK = new Event("PERSONAL_GIFT_LIST_CLICK", 70, 75);
      PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK = new Event("PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK", 71, 76);
      PROFILE_FOLLOW_FILTER = new Event("PROFILE_FOLLOW_FILTER", 72, 77);
      PROFILE_FOLLOW_QUEIT_FILTER = new Event("PROFILE_FOLLOW_QUEIT_FILTER", 73, 78);
      PROFILE_FANS_FILTER = new Event("PROFILE_FANS_FILTER", 74, 79);
      PROFILE_FRIEND_FILTER = new Event("PROFILE_FRIEND_FILTER", 75, 80);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 76, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, PERSONAL_PROFILE_MEDAL_CLICK, PERSONAL_PROFILE_FOLLOWED_BTN_CLICK, PERSONAL_PROFILE_CHAT_BTN_CLICK, PERSONAL_PROFILE_PAGE_SHOW, PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK, PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK, PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK, PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK, PERSONAL_PROFILE_PAGE_PHOTO_SHOW, 
          PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK, APPLY_PHOTO_AGREE_CLICK, APPLY_PHOTO_IGNORE_CLICK, PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK, GIFT_BUY_PAGE_SHOW, GIFT_BUY_PAGE_BUY_BTN_CLICK, PERSONAL_PROFILE_LOAD_DEFAULT_TAB, PERSONAL_PROFILE_SHIFT_TAB, BLUED_OFFICER_CONTINUE_BTN_CLICK, BLUED_OFFICER_BACK_BTN_CLICK, 
          BLUED_OFFICER_VOTE_BTN_CLICK, PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW, PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK, PERSONAL_PROFILE_VIP_SHED_SHOW, PERSONAL_PROFILE_VIP_SHED_CLICK, PERSONAL_PROFILE_VIP_ICON_SHOW, PERSONAL_PROFILE_VIP_ICON_CLICK, PERSONAL_PROFILE_FEED_MORE_CLICK, PERSONAL_PROFILE_FEED_MORE_TOP_CLICK, PERSONAL_PROFILE_MORE_BTN_CLICK, 
          EDIT_NICKNAME_CONFIRM_CLICK, EDIT_SIGNATURE_CONFIRM_CLICK, EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK, PERSONAL_PHOTO_PAGE_SHOW, PERSONAL_PHOTO_PAGE_PHOTO_SHOW, PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK, PERSONAL_PROFILE_MORE_FOLLOW_CLICK, PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK, PERSONAL_FULL_SCREEN_TEXT_CLICK, PERSONAL_FULL_SCREEN_MORE_CLICK, 
          PERSONAL_FULL_SCREEN_SHARE_CLICK, PERSONAL_FULL_SCREEN_COMMENT_CLICK, PERSONAL_FULL_SCREEN_LIKE_CLICK, PERSONAL_MORE_PROFILE_SHOW, PERSONAL_MORE_PROFILE_CLICK, GIFT_BUY_PAGE_BAG_CLICK, PROFILE_GIFT_LIST_CLICK, PERSONAL_BACKGROUND_CLICK, PERSONAL_BACKGROUND_CHANGE_CLICK, PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK, 
          PROFILE_LIVING_SHOW, GIFT_BUY_FREE_BUBBLE_SHOW, GIFT_BUY_NEW_BUBBLE_SHOW, PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK, PERSONAL_LIVE_YEAR_END_PENDANT_SHOW, PERSONAL_LIVE_YEAR_END_PENDANT_CLICK, HEALTH_INFO_PAGE_SHOW, HEALTH_INFO_PAGE_SUBSCRIBE_CLICK, HEALTH_INFO_PAGE_MORE_CLICK, HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK, 
          PERSONAL_CHAT_ROOM_SHOW, PERSONAL_CHAT_ROOM_CLICK, PERSONAL_PHOTO_CLICK, PERSONAL_LOOK_PHOTO_PENDANT_SHOW, PERSONAL_LOOK_PHOTO_PENDANT_CLICK, PERSONAL_SET_PHOTO_PENDANT_SHOW, PERSONAL_SET_PHOTO_PENDANT_CLICK, USER_PAGE_OPTIONS_CLICK, FEED_FULL_SCREEN_SHOW, PROFILE_MAX_BLACKLIST, 
          PERSONAL_GIFT_LIST_CLICK, PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK, PROFILE_FOLLOW_FILTER, PROFILE_FOLLOW_QUEIT_FILTER, PROFILE_FANS_FILTER, PROFILE_FRIEND_FILTER, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public PersonalProfileProtos.Event findValueByNumber(int param2Int) {
            return PersonalProfileProtos.Event.forNumber(param2Int);
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
        case 80:
          return PROFILE_FRIEND_FILTER;
        case 79:
          return PROFILE_FANS_FILTER;
        case 78:
          return PROFILE_FOLLOW_QUEIT_FILTER;
        case 77:
          return PROFILE_FOLLOW_FILTER;
        case 76:
          return PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK;
        case 75:
          return PERSONAL_GIFT_LIST_CLICK;
        case 74:
          return PROFILE_MAX_BLACKLIST;
        case 73:
          return FEED_FULL_SCREEN_SHOW;
        case 72:
          return USER_PAGE_OPTIONS_CLICK;
        case 71:
          return PERSONAL_SET_PHOTO_PENDANT_CLICK;
        case 70:
          return PERSONAL_SET_PHOTO_PENDANT_SHOW;
        case 69:
          return PERSONAL_LOOK_PHOTO_PENDANT_CLICK;
        case 68:
          return PERSONAL_LOOK_PHOTO_PENDANT_SHOW;
        case 67:
          return PERSONAL_PHOTO_CLICK;
        case 66:
          return PERSONAL_CHAT_ROOM_CLICK;
        case 65:
          return PERSONAL_CHAT_ROOM_SHOW;
        case 64:
          return HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK;
        case 63:
          return HEALTH_INFO_PAGE_MORE_CLICK;
        case 62:
          return HEALTH_INFO_PAGE_SUBSCRIBE_CLICK;
        case 61:
          return HEALTH_INFO_PAGE_SHOW;
        case 60:
          return PERSONAL_LIVE_YEAR_END_PENDANT_CLICK;
        case 59:
          return PERSONAL_LIVE_YEAR_END_PENDANT_SHOW;
        case 58:
          return PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK;
        case 57:
          return GIFT_BUY_NEW_BUBBLE_SHOW;
        case 56:
          return GIFT_BUY_FREE_BUBBLE_SHOW;
        case 55:
          return PROFILE_LIVING_SHOW;
        case 54:
          return PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK;
        case 53:
          return PERSONAL_BACKGROUND_CHANGE_CLICK;
        case 52:
          return PERSONAL_BACKGROUND_CLICK;
        case 50:
          return PROFILE_GIFT_LIST_CLICK;
        case 49:
          return GIFT_BUY_PAGE_BAG_CLICK;
        case 48:
          return PERSONAL_MORE_PROFILE_CLICK;
        case 47:
          return PERSONAL_MORE_PROFILE_SHOW;
        case 46:
          return PERSONAL_FULL_SCREEN_LIKE_CLICK;
        case 45:
          return PERSONAL_FULL_SCREEN_COMMENT_CLICK;
        case 44:
          return PERSONAL_FULL_SCREEN_SHARE_CLICK;
        case 43:
          return PERSONAL_FULL_SCREEN_MORE_CLICK;
        case 42:
          return PERSONAL_FULL_SCREEN_TEXT_CLICK;
        case 41:
          return PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK;
        case 40:
          return PERSONAL_PROFILE_MORE_FOLLOW_CLICK;
        case 39:
          return PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK;
        case 38:
          return PERSONAL_PHOTO_PAGE_PHOTO_SHOW;
        case 37:
          return PERSONAL_PHOTO_PAGE_SHOW;
        case 36:
          return EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK;
        case 35:
          return EDIT_SIGNATURE_CONFIRM_CLICK;
        case 34:
          return EDIT_NICKNAME_CONFIRM_CLICK;
        case 33:
          return PERSONAL_PROFILE_MORE_BTN_CLICK;
        case 32:
          return PERSONAL_PROFILE_FEED_MORE_TOP_CLICK;
        case 31:
          return PERSONAL_PROFILE_FEED_MORE_CLICK;
        case 30:
          return PERSONAL_PROFILE_VIP_ICON_CLICK;
        case 29:
          return PERSONAL_PROFILE_VIP_ICON_SHOW;
        case 28:
          return PERSONAL_PROFILE_VIP_SHED_CLICK;
        case 27:
          return PERSONAL_PROFILE_VIP_SHED_SHOW;
        case 26:
          return PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK;
        case 25:
          return PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW;
        case 24:
          return BLUED_OFFICER_VOTE_BTN_CLICK;
        case 23:
          return BLUED_OFFICER_BACK_BTN_CLICK;
        case 22:
          return BLUED_OFFICER_CONTINUE_BTN_CLICK;
        case 21:
          return PERSONAL_PROFILE_SHIFT_TAB;
        case 20:
          return PERSONAL_PROFILE_LOAD_DEFAULT_TAB;
        case 16:
          return GIFT_BUY_PAGE_BUY_BTN_CLICK;
        case 15:
          return GIFT_BUY_PAGE_SHOW;
        case 14:
          return PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK;
        case 13:
          return APPLY_PHOTO_IGNORE_CLICK;
        case 12:
          return APPLY_PHOTO_AGREE_CLICK;
        case 11:
          return PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK;
        case 10:
          return PERSONAL_PROFILE_PAGE_PHOTO_SHOW;
        case 9:
          return PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK;
        case 8:
          return PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK;
        case 6:
          return PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK;
        case 5:
          return PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK;
        case 4:
          return PERSONAL_PROFILE_PAGE_SHOW;
        case 3:
          return PERSONAL_PROFILE_CHAT_BTN_CLICK;
        case 2:
          return PERSONAL_PROFILE_FOLLOWED_BTN_CLICK;
        case 1:
          return PERSONAL_PROFILE_MEDAL_CLICK;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(0);
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
    public PersonalProfileProtos.Event findValueByNumber(int param1Int) {
      return PersonalProfileProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum FilterType implements ProtocolMessageEnum {
    DEFAULT(0),
    LOCATION(0),
    TIME(0),
    UNKNOWN_FILTER_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int DEFAULT_VALUE = 1;
    
    public static final int LOCATION_VALUE = 2;
    
    public static final int TIME_VALUE = 3;
    
    public static final int UNKNOWN_FILTER_TYPE_VALUE = 0;
    
    private static final FilterType[] VALUES;
    
    private static final Internal.EnumLiteMap<FilterType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new FilterType[] { UNKNOWN_FILTER_TYPE, DEFAULT, LOCATION, TIME, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FilterType>() {
          public PersonalProfileProtos.FilterType findValueByNumber(int param2Int) {
            return PersonalProfileProtos.FilterType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FilterType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FilterType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : TIME) : LOCATION) : DEFAULT) : UNKNOWN_FILTER_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(7);
    }
    
    public static Internal.EnumLiteMap<FilterType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FilterType> {
    public PersonalProfileProtos.FilterType findValueByNumber(int param1Int) {
      return PersonalProfileProtos.FilterType.forNumber(param1Int);
    }
  }
  
  public enum GiftFrom implements ProtocolMessageEnum {
    MESSAGE_PAGE(0),
    PERSONAL_PAGE(0),
    UNKNOWN_GIFT_FROM(0),
    UNRECOGNIZED(0);
    
    public static final int MESSAGE_PAGE_VALUE = 2;
    
    public static final int PERSONAL_PAGE_VALUE = 1;
    
    public static final int UNKNOWN_GIFT_FROM_VALUE = 0;
    
    private static final GiftFrom[] VALUES;
    
    private static final Internal.EnumLiteMap<GiftFrom> internalValueMap;
    
    private final int value;
    
    static {
      MESSAGE_PAGE = new GiftFrom("MESSAGE_PAGE", 2, 2);
      UNRECOGNIZED = new GiftFrom("UNRECOGNIZED", 3, -1);
      $VALUES = new GiftFrom[] { UNKNOWN_GIFT_FROM, PERSONAL_PAGE, MESSAGE_PAGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<GiftFrom>() {
          public PersonalProfileProtos.GiftFrom findValueByNumber(int param2Int) {
            return PersonalProfileProtos.GiftFrom.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    GiftFrom(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static GiftFrom forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : MESSAGE_PAGE) : PERSONAL_PAGE) : UNKNOWN_GIFT_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(5);
    }
    
    public static Internal.EnumLiteMap<GiftFrom> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<GiftFrom> {
    public PersonalProfileProtos.GiftFrom findValueByNumber(int param1Int) {
      return PersonalProfileProtos.GiftFrom.forNumber(param1Int);
    }
  }
  
  public static final class PersonalProfileProto extends GeneratedMessageV3 implements PersonalProfileProtoOrBuilder {
    private static final PersonalProfileProto DEFAULT_INSTANCE = new PersonalProfileProto();
    
    public static final int DISTANCE_FIELD_NUMBER = 6;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FEED_ID_FIELD_NUMBER = 18;
    
    public static final int FILTER_TYPE_FIELD_NUMBER = 34;
    
    public static final int GIFT_FROM_FIELD_NUMBER = 16;
    
    public static final int GIFT_ID_FIELD_NUMBER = 13;
    
    public static final int IDENTITY_NUM_FIELD_NUMBER = 24;
    
    public static final int ID_FIELD_NUMBER = 28;
    
    public static final int IS_AI_FIELD_NUMBER = 33;
    
    public static final int IS_APPRECIATE_CALL_FIELD_NUMBER = 11;
    
    public static final int IS_BAG_FIELD_NUMBER = 27;
    
    public static final int IS_FOLLOW_FIELD_NUMBER = 23;
    
    public static final int IS_MAP_FIND_FIELD_NUMBER = 20;
    
    public static final int IS_OPEN_FIELD_NUMBER = 25;
    
    public static final int IS_QUIET_CALL_FIELD_NUMBER = 22;
    
    public static final int IS_SHADOW_FIELD_NUMBER = 21;
    
    public static final int IS_SUPER_EXPOSURE_FIELD_NUMBER = 12;
    
    public static final int IS_VIDEO_FIELD_NUMBER = 26;
    
    public static final int LABEL_FIELD_NUMBER = 9;
    
    public static final int LINK_URL_FIELD_NUMBER = 17;
    
    public static final int LIVE_ID_FIELD_NUMBER = 29;
    
    public static final int ONLINE_TIME_FIELD_NUMBER = 7;
    
    private static final Parser<PersonalProfileProto> PARSER = (Parser<PersonalProfileProto>)new AbstractParser<PersonalProfileProto>() {
        public PersonalProfileProtos.PersonalProfileProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PersonalProfileProtos.PersonalProfileProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PHOTO_NUM_FIELD_NUMBER = 10;
    
    public static final int POSITION_FIELD_NUMBER = 30;
    
    public static final int REASON_FIELD_NUMBER = 8;
    
    public static final int SHOW_TYPE_FIELD_NUMBER = 5;
    
    public static final int SOURCE_FIELD_NUMBER = 2;
    
    public static final int TAB_TYPE_FIELD_NUMBER = 14;
    
    public static final int TARGET_IDENTITY_TYPE_FIELD_NUMBER = 19;
    
    public static final int TARGET_UID_FIELD_NUMBER = 3;
    
    public static final int TYPE_FIELD_NUMBER = 31;
    
    public static final int URL_FIELD_NUMBER = 32;
    
    public static final int VOTE_OPTION_FIELD_NUMBER = 15;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object distance_;
    
    private int event_;
    
    private volatile Object feedId_;
    
    private int filterType_;
    
    private int giftFrom_;
    
    private volatile Object giftId_;
    
    private volatile Object id_;
    
    private int identityNum_;
    
    private boolean isAi_;
    
    private boolean isAppreciateCall_;
    
    private boolean isBag_;
    
    private boolean isFollow_;
    
    private boolean isMapFind_;
    
    private boolean isOpen_;
    
    private boolean isQuietCall_;
    
    private boolean isShadow_;
    
    private boolean isSuperExposure_;
    
    private boolean isVideo_;
    
    private volatile Object label_;
    
    private volatile Object linkUrl_;
    
    private volatile Object liveId_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object onlineTime_;
    
    private int photoNum_;
    
    private int position_;
    
    private int reason_;
    
    private int showType_;
    
    private int source_;
    
    private int tabType_;
    
    private int targetIdentityType_;
    
    private volatile Object targetUid_;
    
    private int type_;
    
    private volatile Object url_;
    
    private int voteOption_;
    
    private PersonalProfileProto() {
      this.event_ = 0;
      this.source_ = 0;
      this.targetUid_ = "";
      this.showType_ = 0;
      this.distance_ = "";
      this.onlineTime_ = "";
      this.label_ = "";
      this.giftId_ = "";
      this.tabType_ = 0;
      this.voteOption_ = 0;
      this.giftFrom_ = 0;
      this.linkUrl_ = "";
      this.feedId_ = "";
      this.targetIdentityType_ = 0;
      this.id_ = "";
      this.liveId_ = "";
      this.url_ = "";
      this.filterType_ = 0;
    }
    
    private PersonalProfileProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 272:
                this.filterType_ = param1CodedInputStream.readEnum();
                continue;
              case 264:
                this.isAi_ = param1CodedInputStream.readBool();
                continue;
              case 258:
                this.url_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 248:
                this.type_ = param1CodedInputStream.readInt32();
                continue;
              case 240:
                this.position_ = param1CodedInputStream.readInt32();
                continue;
              case 234:
                this.liveId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 226:
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 216:
                this.isBag_ = param1CodedInputStream.readBool();
                continue;
              case 208:
                this.isVideo_ = param1CodedInputStream.readBool();
                continue;
              case 200:
                this.isOpen_ = param1CodedInputStream.readBool();
                continue;
              case 192:
                this.identityNum_ = param1CodedInputStream.readInt32();
                continue;
              case 184:
                this.isFollow_ = param1CodedInputStream.readBool();
                continue;
              case 176:
                this.isQuietCall_ = param1CodedInputStream.readBool();
                continue;
              case 168:
                this.isShadow_ = param1CodedInputStream.readBool();
                continue;
              case 160:
                this.isMapFind_ = param1CodedInputStream.readBool();
                continue;
              case 152:
                this.targetIdentityType_ = param1CodedInputStream.readEnum();
                continue;
              case 146:
                this.feedId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 138:
                this.linkUrl_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 128:
                this.giftFrom_ = param1CodedInputStream.readEnum();
                continue;
              case 120:
                this.voteOption_ = param1CodedInputStream.readEnum();
                continue;
              case 112:
                this.tabType_ = param1CodedInputStream.readEnum();
                continue;
              case 106:
                this.giftId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 96:
                this.isSuperExposure_ = param1CodedInputStream.readBool();
                continue;
              case 88:
                this.isAppreciateCall_ = param1CodedInputStream.readBool();
                continue;
              case 80:
                this.photoNum_ = param1CodedInputStream.readInt32();
                continue;
              case 74:
                this.label_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 64:
                this.reason_ = param1CodedInputStream.readInt32();
                continue;
              case 58:
                this.onlineTime_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 50:
                this.distance_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 40:
                this.showType_ = param1CodedInputStream.readEnum();
                continue;
              case 26:
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 16:
                this.source_ = param1CodedInputStream.readEnum();
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
    
    private PersonalProfileProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static PersonalProfileProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PersonalProfileProto param1PersonalProfileProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1PersonalProfileProto);
    }
    
    public static PersonalProfileProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PersonalProfileProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static PersonalProfileProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PersonalProfileProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PersonalProfileProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PersonalProfileProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static PersonalProfileProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PersonalProfileProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PersonalProfileProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PersonalProfileProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static PersonalProfileProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PersonalProfileProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PersonalProfileProto parseFrom(InputStream param1InputStream) throws IOException {
      return (PersonalProfileProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static PersonalProfileProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PersonalProfileProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PersonalProfileProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (PersonalProfileProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static PersonalProfileProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PersonalProfileProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static PersonalProfileProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PersonalProfileProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static PersonalProfileProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PersonalProfileProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PersonalProfileProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof PersonalProfileProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((PersonalProfileProto)param1Object).event_) ? false : ((this.source_ != ((PersonalProfileProto)param1Object).source_) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : ((this.showType_ != ((PersonalProfileProto)param1Object).showType_) ? false : (!getDistance().equals(param1Object.getDistance()) ? false : (!getOnlineTime().equals(param1Object.getOnlineTime()) ? false : ((getReason() != param1Object.getReason()) ? false : (!getLabel().equals(param1Object.getLabel()) ? false : ((getPhotoNum() != param1Object.getPhotoNum()) ? false : ((getIsAppreciateCall() != param1Object.getIsAppreciateCall()) ? false : ((getIsSuperExposure() != param1Object.getIsSuperExposure()) ? false : (!getGiftId().equals(param1Object.getGiftId()) ? false : ((this.tabType_ != ((PersonalProfileProto)param1Object).tabType_) ? false : ((this.voteOption_ != ((PersonalProfileProto)param1Object).voteOption_) ? false : ((this.giftFrom_ != ((PersonalProfileProto)param1Object).giftFrom_) ? false : (!getLinkUrl().equals(param1Object.getLinkUrl()) ? false : (!getFeedId().equals(param1Object.getFeedId()) ? false : ((this.targetIdentityType_ != ((PersonalProfileProto)param1Object).targetIdentityType_) ? false : ((getIsMapFind() != param1Object.getIsMapFind()) ? false : ((getIsShadow() != param1Object.getIsShadow()) ? false : ((getIsQuietCall() != param1Object.getIsQuietCall()) ? false : ((getIsFollow() != param1Object.getIsFollow()) ? false : ((getIdentityNum() != param1Object.getIdentityNum()) ? false : ((getIsOpen() != param1Object.getIsOpen()) ? false : ((getIsVideo() != param1Object.getIsVideo()) ? false : ((getIsBag() != param1Object.getIsBag()) ? false : (!getId().equals(param1Object.getId()) ? false : (!getLiveId().equals(param1Object.getLiveId()) ? false : ((getPosition() != param1Object.getPosition()) ? false : ((getType() != param1Object.getType()) ? false : (!getUrl().equals(param1Object.getUrl()) ? false : ((getIsAi() != param1Object.getIsAi()) ? false : ((this.filterType_ != ((PersonalProfileProto)param1Object).filterType_) ? false : (!!this.unknownFields.equals(((PersonalProfileProto)param1Object).unknownFields))))))))))))))))))))))))))))))))));
    }
    
    public PersonalProfileProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDistance() {
      Object object = this.distance_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.distance_ = object;
      return (String)object;
    }
    
    public ByteString getDistanceBytes() {
      Object object = this.distance_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.distance_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PersonalProfileProtos.Event getEvent() {
      PersonalProfileProtos.Event event2 = PersonalProfileProtos.Event.valueOf(this.event_);
      PersonalProfileProtos.Event event1 = event2;
      if (event2 == null)
        event1 = PersonalProfileProtos.Event.UNRECOGNIZED; 
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
    
    public PersonalProfileProtos.FilterType getFilterType() {
      PersonalProfileProtos.FilterType filterType2 = PersonalProfileProtos.FilterType.valueOf(this.filterType_);
      PersonalProfileProtos.FilterType filterType1 = filterType2;
      if (filterType2 == null)
        filterType1 = PersonalProfileProtos.FilterType.UNRECOGNIZED; 
      return filterType1;
    }
    
    public int getFilterTypeValue() {
      return this.filterType_;
    }
    
    public PersonalProfileProtos.GiftFrom getGiftFrom() {
      PersonalProfileProtos.GiftFrom giftFrom2 = PersonalProfileProtos.GiftFrom.valueOf(this.giftFrom_);
      PersonalProfileProtos.GiftFrom giftFrom1 = giftFrom2;
      if (giftFrom2 == null)
        giftFrom1 = PersonalProfileProtos.GiftFrom.UNRECOGNIZED; 
      return giftFrom1;
    }
    
    public int getGiftFromValue() {
      return this.giftFrom_;
    }
    
    public String getGiftId() {
      Object object = this.giftId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.giftId_ = object;
      return (String)object;
    }
    
    public ByteString getGiftIdBytes() {
      Object object = this.giftId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.giftId_ = object;
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
    
    public int getIdentityNum() {
      return this.identityNum_;
    }
    
    public boolean getIsAi() {
      return this.isAi_;
    }
    
    public boolean getIsAppreciateCall() {
      return this.isAppreciateCall_;
    }
    
    public boolean getIsBag() {
      return this.isBag_;
    }
    
    public boolean getIsFollow() {
      return this.isFollow_;
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
    
    public boolean getIsVideo() {
      return this.isVideo_;
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
    
    public String getLinkUrl() {
      Object object = this.linkUrl_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.linkUrl_ = object;
      return (String)object;
    }
    
    public ByteString getLinkUrlBytes() {
      Object object = this.linkUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.linkUrl_ = object;
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
    
    public String getOnlineTime() {
      Object object = this.onlineTime_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.onlineTime_ = object;
      return (String)object;
    }
    
    public ByteString getOnlineTimeBytes() {
      Object object = this.onlineTime_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.onlineTime_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<PersonalProfileProto> getParserForType() {
      return PARSER;
    }
    
    public int getPhotoNum() {
      return this.photoNum_;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public int getReason() {
      return this.reason_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != PersonalProfileProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.source_ != PersonalProfileProtos.Source.UNKNOWN_FOLLOW_SOURCE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.source_); 
      j = i;
      if (!getTargetUidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.targetUid_); 
      i = j;
      if (this.showType_ != PersonalProfileProtos.ShowType.UNKNOWN_SHOW_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(5, this.showType_); 
      j = i;
      if (!getDistanceBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(6, this.distance_); 
      i = j;
      if (!getOnlineTimeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(7, this.onlineTime_); 
      int k = this.reason_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(8, k); 
      i = j;
      if (!getLabelBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(9, this.label_); 
      k = this.photoNum_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(10, k); 
      boolean bool = this.isAppreciateCall_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(11, bool); 
      bool = this.isSuperExposure_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(12, bool); 
      i = j;
      if (!getGiftIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(13, this.giftId_); 
      j = i;
      if (this.tabType_ != PersonalProfileProtos.TabType.UNKNOWN_TAB_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(14, this.tabType_); 
      i = j;
      if (this.voteOption_ != PersonalProfileProtos.VoteOption.UNKNOWN_VOTE_OPTION.getNumber())
        i = j + CodedOutputStream.computeEnumSize(15, this.voteOption_); 
      j = i;
      if (this.giftFrom_ != PersonalProfileProtos.GiftFrom.UNKNOWN_GIFT_FROM.getNumber())
        j = i + CodedOutputStream.computeEnumSize(16, this.giftFrom_); 
      i = j;
      if (!getLinkUrlBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(17, this.linkUrl_); 
      j = i;
      if (!getFeedIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(18, this.feedId_); 
      i = j;
      if (this.targetIdentityType_ != PersonalProfileProtos.TargetIdentityType.UNKNOWN_TARGET_IDENTITY_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(19, this.targetIdentityType_); 
      bool = this.isMapFind_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(20, bool); 
      bool = this.isShadow_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(21, bool); 
      bool = this.isQuietCall_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(22, bool); 
      bool = this.isFollow_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(23, bool); 
      k = this.identityNum_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(24, k); 
      bool = this.isOpen_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(25, bool); 
      bool = this.isVideo_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(26, bool); 
      bool = this.isBag_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(27, bool); 
      k = i;
      if (!getIdBytes().isEmpty())
        k = i + GeneratedMessageV3.computeStringSize(28, this.id_); 
      j = k;
      if (!getLiveIdBytes().isEmpty())
        j = k + GeneratedMessageV3.computeStringSize(29, this.liveId_); 
      k = this.position_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(30, k); 
      k = this.type_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(31, k); 
      i = j;
      if (!getUrlBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(32, this.url_); 
      bool = this.isAi_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(33, bool); 
      i = j;
      if (this.filterType_ != PersonalProfileProtos.FilterType.UNKNOWN_FILTER_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(34, this.filterType_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public PersonalProfileProtos.ShowType getShowType() {
      PersonalProfileProtos.ShowType showType2 = PersonalProfileProtos.ShowType.valueOf(this.showType_);
      PersonalProfileProtos.ShowType showType1 = showType2;
      if (showType2 == null)
        showType1 = PersonalProfileProtos.ShowType.UNRECOGNIZED; 
      return showType1;
    }
    
    public int getShowTypeValue() {
      return this.showType_;
    }
    
    public PersonalProfileProtos.Source getSource() {
      PersonalProfileProtos.Source source2 = PersonalProfileProtos.Source.valueOf(this.source_);
      PersonalProfileProtos.Source source1 = source2;
      if (source2 == null)
        source1 = PersonalProfileProtos.Source.UNRECOGNIZED; 
      return source1;
    }
    
    public int getSourceValue() {
      return this.source_;
    }
    
    public PersonalProfileProtos.TabType getTabType() {
      PersonalProfileProtos.TabType tabType2 = PersonalProfileProtos.TabType.valueOf(this.tabType_);
      PersonalProfileProtos.TabType tabType1 = tabType2;
      if (tabType2 == null)
        tabType1 = PersonalProfileProtos.TabType.UNRECOGNIZED; 
      return tabType1;
    }
    
    public int getTabTypeValue() {
      return this.tabType_;
    }
    
    public PersonalProfileProtos.TargetIdentityType getTargetIdentityType() {
      PersonalProfileProtos.TargetIdentityType targetIdentityType2 = PersonalProfileProtos.TargetIdentityType.valueOf(this.targetIdentityType_);
      PersonalProfileProtos.TargetIdentityType targetIdentityType1 = targetIdentityType2;
      if (targetIdentityType2 == null)
        targetIdentityType1 = PersonalProfileProtos.TargetIdentityType.UNRECOGNIZED; 
      return targetIdentityType1;
    }
    
    public int getTargetIdentityTypeValue() {
      return this.targetIdentityType_;
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
    
    public int getType() {
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
    
    public PersonalProfileProtos.VoteOption getVoteOption() {
      PersonalProfileProtos.VoteOption voteOption2 = PersonalProfileProtos.VoteOption.valueOf(this.voteOption_);
      PersonalProfileProtos.VoteOption voteOption1 = voteOption2;
      if (voteOption2 == null)
        voteOption1 = PersonalProfileProtos.VoteOption.UNRECOGNIZED; 
      return voteOption1;
    }
    
    public int getVoteOptionValue() {
      return this.voteOption_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.source_) * 37 + 3) * 53 + getTargetUid().hashCode()) * 37 + 5) * 53 + this.showType_) * 37 + 6) * 53 + getDistance().hashCode()) * 37 + 7) * 53 + getOnlineTime().hashCode()) * 37 + 8) * 53 + getReason()) * 37 + 9) * 53 + getLabel().hashCode()) * 37 + 10) * 53 + getPhotoNum()) * 37 + 11) * 53 + Internal.hashBoolean(getIsAppreciateCall())) * 37 + 12) * 53 + Internal.hashBoolean(getIsSuperExposure())) * 37 + 13) * 53 + getGiftId().hashCode()) * 37 + 14) * 53 + this.tabType_) * 37 + 15) * 53 + this.voteOption_) * 37 + 16) * 53 + this.giftFrom_) * 37 + 17) * 53 + getLinkUrl().hashCode()) * 37 + 18) * 53 + getFeedId().hashCode()) * 37 + 19) * 53 + this.targetIdentityType_) * 37 + 20) * 53 + Internal.hashBoolean(getIsMapFind())) * 37 + 21) * 53 + Internal.hashBoolean(getIsShadow())) * 37 + 22) * 53 + Internal.hashBoolean(getIsQuietCall())) * 37 + 23) * 53 + Internal.hashBoolean(getIsFollow())) * 37 + 24) * 53 + getIdentityNum()) * 37 + 25) * 53 + Internal.hashBoolean(getIsOpen())) * 37 + 26) * 53 + Internal.hashBoolean(getIsVideo())) * 37 + 27) * 53 + Internal.hashBoolean(getIsBag())) * 37 + 28) * 53 + getId().hashCode()) * 37 + 29) * 53 + getLiveId().hashCode()) * 37 + 30) * 53 + getPosition()) * 37 + 31) * 53 + getType()) * 37 + 32) * 53 + getUrl().hashCode()) * 37 + 33) * 53 + Internal.hashBoolean(getIsAi())) * 37 + 34) * 53 + this.filterType_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalProfileProto.class, Builder.class);
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
      return new PersonalProfileProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != PersonalProfileProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.source_ != PersonalProfileProtos.Source.UNKNOWN_FOLLOW_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.source_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.targetUid_); 
      if (this.showType_ != PersonalProfileProtos.ShowType.UNKNOWN_SHOW_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(5, this.showType_); 
      if (!getDistanceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.distance_); 
      if (!getOnlineTimeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 7, this.onlineTime_); 
      int i = this.reason_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(8, i); 
      if (!getLabelBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 9, this.label_); 
      i = this.photoNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(10, i); 
      boolean bool = this.isAppreciateCall_;
      if (bool)
        param1CodedOutputStream.writeBool(11, bool); 
      bool = this.isSuperExposure_;
      if (bool)
        param1CodedOutputStream.writeBool(12, bool); 
      if (!getGiftIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 13, this.giftId_); 
      if (this.tabType_ != PersonalProfileProtos.TabType.UNKNOWN_TAB_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(14, this.tabType_); 
      if (this.voteOption_ != PersonalProfileProtos.VoteOption.UNKNOWN_VOTE_OPTION.getNumber())
        param1CodedOutputStream.writeEnum(15, this.voteOption_); 
      if (this.giftFrom_ != PersonalProfileProtos.GiftFrom.UNKNOWN_GIFT_FROM.getNumber())
        param1CodedOutputStream.writeEnum(16, this.giftFrom_); 
      if (!getLinkUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 17, this.linkUrl_); 
      if (!getFeedIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 18, this.feedId_); 
      if (this.targetIdentityType_ != PersonalProfileProtos.TargetIdentityType.UNKNOWN_TARGET_IDENTITY_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(19, this.targetIdentityType_); 
      bool = this.isMapFind_;
      if (bool)
        param1CodedOutputStream.writeBool(20, bool); 
      bool = this.isShadow_;
      if (bool)
        param1CodedOutputStream.writeBool(21, bool); 
      bool = this.isQuietCall_;
      if (bool)
        param1CodedOutputStream.writeBool(22, bool); 
      bool = this.isFollow_;
      if (bool)
        param1CodedOutputStream.writeBool(23, bool); 
      i = this.identityNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(24, i); 
      bool = this.isOpen_;
      if (bool)
        param1CodedOutputStream.writeBool(25, bool); 
      bool = this.isVideo_;
      if (bool)
        param1CodedOutputStream.writeBool(26, bool); 
      bool = this.isBag_;
      if (bool)
        param1CodedOutputStream.writeBool(27, bool); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 28, this.id_); 
      if (!getLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 29, this.liveId_); 
      i = this.position_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(30, i); 
      i = this.type_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(31, i); 
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 32, this.url_); 
      bool = this.isAi_;
      if (bool)
        param1CodedOutputStream.writeBool(33, bool); 
      if (this.filterType_ != PersonalProfileProtos.FilterType.UNKNOWN_FILTER_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(34, this.filterType_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PersonalProfileProtos.PersonalProfileProtoOrBuilder {
      private Object distance_ = "";
      
      private int event_ = 0;
      
      private Object feedId_ = "";
      
      private int filterType_ = 0;
      
      private int giftFrom_ = 0;
      
      private Object giftId_ = "";
      
      private Object id_ = "";
      
      private int identityNum_;
      
      private boolean isAi_;
      
      private boolean isAppreciateCall_;
      
      private boolean isBag_;
      
      private boolean isFollow_;
      
      private boolean isMapFind_;
      
      private boolean isOpen_;
      
      private boolean isQuietCall_;
      
      private boolean isShadow_;
      
      private boolean isSuperExposure_;
      
      private boolean isVideo_;
      
      private Object label_ = "";
      
      private Object linkUrl_ = "";
      
      private Object liveId_ = "";
      
      private Object onlineTime_ = "";
      
      private int photoNum_;
      
      private int position_;
      
      private int reason_;
      
      private int showType_ = 0;
      
      private int source_ = 0;
      
      private int tabType_ = 0;
      
      private int targetIdentityType_ = 0;
      
      private Object targetUid_ = "";
      
      private int type_;
      
      private Object url_ = "";
      
      private int voteOption_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PersonalProfileProtos.PersonalProfileProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PersonalProfileProtos.PersonalProfileProto build() {
        PersonalProfileProtos.PersonalProfileProto personalProfileProto = buildPartial();
        if (personalProfileProto.isInitialized())
          return personalProfileProto; 
        throw newUninitializedMessageException(personalProfileProto);
      }
      
      public PersonalProfileProtos.PersonalProfileProto buildPartial() {
        PersonalProfileProtos.PersonalProfileProto personalProfileProto = new PersonalProfileProtos.PersonalProfileProto(this);
        PersonalProfileProtos.PersonalProfileProto.access$602(personalProfileProto, this.event_);
        PersonalProfileProtos.PersonalProfileProto.access$702(personalProfileProto, this.source_);
        PersonalProfileProtos.PersonalProfileProto.access$802(personalProfileProto, this.targetUid_);
        PersonalProfileProtos.PersonalProfileProto.access$902(personalProfileProto, this.showType_);
        PersonalProfileProtos.PersonalProfileProto.access$1002(personalProfileProto, this.distance_);
        PersonalProfileProtos.PersonalProfileProto.access$1102(personalProfileProto, this.onlineTime_);
        PersonalProfileProtos.PersonalProfileProto.access$1202(personalProfileProto, this.reason_);
        PersonalProfileProtos.PersonalProfileProto.access$1302(personalProfileProto, this.label_);
        PersonalProfileProtos.PersonalProfileProto.access$1402(personalProfileProto, this.photoNum_);
        PersonalProfileProtos.PersonalProfileProto.access$1502(personalProfileProto, this.isAppreciateCall_);
        PersonalProfileProtos.PersonalProfileProto.access$1602(personalProfileProto, this.isSuperExposure_);
        PersonalProfileProtos.PersonalProfileProto.access$1702(personalProfileProto, this.giftId_);
        PersonalProfileProtos.PersonalProfileProto.access$1802(personalProfileProto, this.tabType_);
        PersonalProfileProtos.PersonalProfileProto.access$1902(personalProfileProto, this.voteOption_);
        PersonalProfileProtos.PersonalProfileProto.access$2002(personalProfileProto, this.giftFrom_);
        PersonalProfileProtos.PersonalProfileProto.access$2102(personalProfileProto, this.linkUrl_);
        PersonalProfileProtos.PersonalProfileProto.access$2202(personalProfileProto, this.feedId_);
        PersonalProfileProtos.PersonalProfileProto.access$2302(personalProfileProto, this.targetIdentityType_);
        PersonalProfileProtos.PersonalProfileProto.access$2402(personalProfileProto, this.isMapFind_);
        PersonalProfileProtos.PersonalProfileProto.access$2502(personalProfileProto, this.isShadow_);
        PersonalProfileProtos.PersonalProfileProto.access$2602(personalProfileProto, this.isQuietCall_);
        PersonalProfileProtos.PersonalProfileProto.access$2702(personalProfileProto, this.isFollow_);
        PersonalProfileProtos.PersonalProfileProto.access$2802(personalProfileProto, this.identityNum_);
        PersonalProfileProtos.PersonalProfileProto.access$2902(personalProfileProto, this.isOpen_);
        PersonalProfileProtos.PersonalProfileProto.access$3002(personalProfileProto, this.isVideo_);
        PersonalProfileProtos.PersonalProfileProto.access$3102(personalProfileProto, this.isBag_);
        PersonalProfileProtos.PersonalProfileProto.access$3202(personalProfileProto, this.id_);
        PersonalProfileProtos.PersonalProfileProto.access$3302(personalProfileProto, this.liveId_);
        PersonalProfileProtos.PersonalProfileProto.access$3402(personalProfileProto, this.position_);
        PersonalProfileProtos.PersonalProfileProto.access$3502(personalProfileProto, this.type_);
        PersonalProfileProtos.PersonalProfileProto.access$3602(personalProfileProto, this.url_);
        PersonalProfileProtos.PersonalProfileProto.access$3702(personalProfileProto, this.isAi_);
        PersonalProfileProtos.PersonalProfileProto.access$3802(personalProfileProto, this.filterType_);
        onBuilt();
        return personalProfileProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.source_ = 0;
        this.targetUid_ = "";
        this.showType_ = 0;
        this.distance_ = "";
        this.onlineTime_ = "";
        this.reason_ = 0;
        this.label_ = "";
        this.photoNum_ = 0;
        this.isAppreciateCall_ = false;
        this.isSuperExposure_ = false;
        this.giftId_ = "";
        this.tabType_ = 0;
        this.voteOption_ = 0;
        this.giftFrom_ = 0;
        this.linkUrl_ = "";
        this.feedId_ = "";
        this.targetIdentityType_ = 0;
        this.isMapFind_ = false;
        this.isShadow_ = false;
        this.isQuietCall_ = false;
        this.isFollow_ = false;
        this.identityNum_ = 0;
        this.isOpen_ = false;
        this.isVideo_ = false;
        this.isBag_ = false;
        this.id_ = "";
        this.liveId_ = "";
        this.position_ = 0;
        this.type_ = 0;
        this.url_ = "";
        this.isAi_ = false;
        this.filterType_ = 0;
        return this;
      }
      
      public Builder clearDistance() {
        this.distance_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getDistance();
        onChanged();
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedId() {
        this.feedId_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getFeedId();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearFilterType() {
        this.filterType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearGiftFrom() {
        this.giftFrom_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearGiftId() {
        this.giftId_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getGiftId();
        onChanged();
        return this;
      }
      
      public Builder clearId() {
        this.id_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearIdentityNum() {
        this.identityNum_ = 0;
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
      
      public Builder clearIsBag() {
        this.isBag_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsFollow() {
        this.isFollow_ = false;
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
      
      public Builder clearIsVideo() {
        this.isVideo_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearLabel() {
        this.label_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getLabel();
        onChanged();
        return this;
      }
      
      public Builder clearLinkUrl() {
        this.linkUrl_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getLinkUrl();
        onChanged();
        return this;
      }
      
      public Builder clearLiveId() {
        this.liveId_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOnlineTime() {
        this.onlineTime_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getOnlineTime();
        onChanged();
        return this;
      }
      
      public Builder clearPhotoNum() {
        this.photoNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPosition() {
        this.position_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearReason() {
        this.reason_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearShowType() {
        this.showType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSource() {
        this.source_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTabType() {
        this.tabType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetIdentityType() {
        this.targetIdentityType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clearType() {
        this.type_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearUrl() {
        this.url_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clearVoteOption() {
        this.voteOption_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public PersonalProfileProtos.PersonalProfileProto getDefaultInstanceForType() {
        return PersonalProfileProtos.PersonalProfileProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
      }
      
      public String getDistance() {
        Object object = this.distance_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.distance_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDistanceBytes() {
        Object object = this.distance_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.distance_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public PersonalProfileProtos.Event getEvent() {
        PersonalProfileProtos.Event event2 = PersonalProfileProtos.Event.valueOf(this.event_);
        PersonalProfileProtos.Event event1 = event2;
        if (event2 == null)
          event1 = PersonalProfileProtos.Event.UNRECOGNIZED; 
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
      
      public PersonalProfileProtos.FilterType getFilterType() {
        PersonalProfileProtos.FilterType filterType2 = PersonalProfileProtos.FilterType.valueOf(this.filterType_);
        PersonalProfileProtos.FilterType filterType1 = filterType2;
        if (filterType2 == null)
          filterType1 = PersonalProfileProtos.FilterType.UNRECOGNIZED; 
        return filterType1;
      }
      
      public int getFilterTypeValue() {
        return this.filterType_;
      }
      
      public PersonalProfileProtos.GiftFrom getGiftFrom() {
        PersonalProfileProtos.GiftFrom giftFrom2 = PersonalProfileProtos.GiftFrom.valueOf(this.giftFrom_);
        PersonalProfileProtos.GiftFrom giftFrom1 = giftFrom2;
        if (giftFrom2 == null)
          giftFrom1 = PersonalProfileProtos.GiftFrom.UNRECOGNIZED; 
        return giftFrom1;
      }
      
      public int getGiftFromValue() {
        return this.giftFrom_;
      }
      
      public String getGiftId() {
        Object object = this.giftId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.giftId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getGiftIdBytes() {
        Object object = this.giftId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.giftId_ = object;
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
      
      public int getIdentityNum() {
        return this.identityNum_;
      }
      
      public boolean getIsAi() {
        return this.isAi_;
      }
      
      public boolean getIsAppreciateCall() {
        return this.isAppreciateCall_;
      }
      
      public boolean getIsBag() {
        return this.isBag_;
      }
      
      public boolean getIsFollow() {
        return this.isFollow_;
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
      
      public boolean getIsVideo() {
        return this.isVideo_;
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
      
      public String getLinkUrl() {
        Object object = this.linkUrl_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.linkUrl_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLinkUrlBytes() {
        Object object = this.linkUrl_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.linkUrl_ = object;
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
      
      public String getOnlineTime() {
        Object object = this.onlineTime_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.onlineTime_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getOnlineTimeBytes() {
        Object object = this.onlineTime_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.onlineTime_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getPhotoNum() {
        return this.photoNum_;
      }
      
      public int getPosition() {
        return this.position_;
      }
      
      public int getReason() {
        return this.reason_;
      }
      
      public PersonalProfileProtos.ShowType getShowType() {
        PersonalProfileProtos.ShowType showType2 = PersonalProfileProtos.ShowType.valueOf(this.showType_);
        PersonalProfileProtos.ShowType showType1 = showType2;
        if (showType2 == null)
          showType1 = PersonalProfileProtos.ShowType.UNRECOGNIZED; 
        return showType1;
      }
      
      public int getShowTypeValue() {
        return this.showType_;
      }
      
      public PersonalProfileProtos.Source getSource() {
        PersonalProfileProtos.Source source2 = PersonalProfileProtos.Source.valueOf(this.source_);
        PersonalProfileProtos.Source source1 = source2;
        if (source2 == null)
          source1 = PersonalProfileProtos.Source.UNRECOGNIZED; 
        return source1;
      }
      
      public int getSourceValue() {
        return this.source_;
      }
      
      public PersonalProfileProtos.TabType getTabType() {
        PersonalProfileProtos.TabType tabType2 = PersonalProfileProtos.TabType.valueOf(this.tabType_);
        PersonalProfileProtos.TabType tabType1 = tabType2;
        if (tabType2 == null)
          tabType1 = PersonalProfileProtos.TabType.UNRECOGNIZED; 
        return tabType1;
      }
      
      public int getTabTypeValue() {
        return this.tabType_;
      }
      
      public PersonalProfileProtos.TargetIdentityType getTargetIdentityType() {
        PersonalProfileProtos.TargetIdentityType targetIdentityType2 = PersonalProfileProtos.TargetIdentityType.valueOf(this.targetIdentityType_);
        PersonalProfileProtos.TargetIdentityType targetIdentityType1 = targetIdentityType2;
        if (targetIdentityType2 == null)
          targetIdentityType1 = PersonalProfileProtos.TargetIdentityType.UNRECOGNIZED; 
        return targetIdentityType1;
      }
      
      public int getTargetIdentityTypeValue() {
        return this.targetIdentityType_;
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
      
      public int getType() {
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
      
      public PersonalProfileProtos.VoteOption getVoteOption() {
        PersonalProfileProtos.VoteOption voteOption2 = PersonalProfileProtos.VoteOption.valueOf(this.voteOption_);
        PersonalProfileProtos.VoteOption voteOption1 = voteOption2;
        if (voteOption2 == null)
          voteOption1 = PersonalProfileProtos.VoteOption.UNRECOGNIZED; 
        return voteOption1;
      }
      
      public int getVoteOptionValue() {
        return this.voteOption_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalProfileProtos.PersonalProfileProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(PersonalProfileProtos.PersonalProfileProto param2PersonalProfileProto) {
        if (param2PersonalProfileProto == PersonalProfileProtos.PersonalProfileProto.getDefaultInstance())
          return this; 
        if (param2PersonalProfileProto.event_ != 0)
          setEventValue(param2PersonalProfileProto.getEventValue()); 
        if (param2PersonalProfileProto.source_ != 0)
          setSourceValue(param2PersonalProfileProto.getSourceValue()); 
        if (!param2PersonalProfileProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2PersonalProfileProto.targetUid_;
          onChanged();
        } 
        if (param2PersonalProfileProto.showType_ != 0)
          setShowTypeValue(param2PersonalProfileProto.getShowTypeValue()); 
        if (!param2PersonalProfileProto.getDistance().isEmpty()) {
          this.distance_ = param2PersonalProfileProto.distance_;
          onChanged();
        } 
        if (!param2PersonalProfileProto.getOnlineTime().isEmpty()) {
          this.onlineTime_ = param2PersonalProfileProto.onlineTime_;
          onChanged();
        } 
        if (param2PersonalProfileProto.getReason() != 0)
          setReason(param2PersonalProfileProto.getReason()); 
        if (!param2PersonalProfileProto.getLabel().isEmpty()) {
          this.label_ = param2PersonalProfileProto.label_;
          onChanged();
        } 
        if (param2PersonalProfileProto.getPhotoNum() != 0)
          setPhotoNum(param2PersonalProfileProto.getPhotoNum()); 
        if (param2PersonalProfileProto.getIsAppreciateCall())
          setIsAppreciateCall(param2PersonalProfileProto.getIsAppreciateCall()); 
        if (param2PersonalProfileProto.getIsSuperExposure())
          setIsSuperExposure(param2PersonalProfileProto.getIsSuperExposure()); 
        if (!param2PersonalProfileProto.getGiftId().isEmpty()) {
          this.giftId_ = param2PersonalProfileProto.giftId_;
          onChanged();
        } 
        if (param2PersonalProfileProto.tabType_ != 0)
          setTabTypeValue(param2PersonalProfileProto.getTabTypeValue()); 
        if (param2PersonalProfileProto.voteOption_ != 0)
          setVoteOptionValue(param2PersonalProfileProto.getVoteOptionValue()); 
        if (param2PersonalProfileProto.giftFrom_ != 0)
          setGiftFromValue(param2PersonalProfileProto.getGiftFromValue()); 
        if (!param2PersonalProfileProto.getLinkUrl().isEmpty()) {
          this.linkUrl_ = param2PersonalProfileProto.linkUrl_;
          onChanged();
        } 
        if (!param2PersonalProfileProto.getFeedId().isEmpty()) {
          this.feedId_ = param2PersonalProfileProto.feedId_;
          onChanged();
        } 
        if (param2PersonalProfileProto.targetIdentityType_ != 0)
          setTargetIdentityTypeValue(param2PersonalProfileProto.getTargetIdentityTypeValue()); 
        if (param2PersonalProfileProto.getIsMapFind())
          setIsMapFind(param2PersonalProfileProto.getIsMapFind()); 
        if (param2PersonalProfileProto.getIsShadow())
          setIsShadow(param2PersonalProfileProto.getIsShadow()); 
        if (param2PersonalProfileProto.getIsQuietCall())
          setIsQuietCall(param2PersonalProfileProto.getIsQuietCall()); 
        if (param2PersonalProfileProto.getIsFollow())
          setIsFollow(param2PersonalProfileProto.getIsFollow()); 
        if (param2PersonalProfileProto.getIdentityNum() != 0)
          setIdentityNum(param2PersonalProfileProto.getIdentityNum()); 
        if (param2PersonalProfileProto.getIsOpen())
          setIsOpen(param2PersonalProfileProto.getIsOpen()); 
        if (param2PersonalProfileProto.getIsVideo())
          setIsVideo(param2PersonalProfileProto.getIsVideo()); 
        if (param2PersonalProfileProto.getIsBag())
          setIsBag(param2PersonalProfileProto.getIsBag()); 
        if (!param2PersonalProfileProto.getId().isEmpty()) {
          this.id_ = param2PersonalProfileProto.id_;
          onChanged();
        } 
        if (!param2PersonalProfileProto.getLiveId().isEmpty()) {
          this.liveId_ = param2PersonalProfileProto.liveId_;
          onChanged();
        } 
        if (param2PersonalProfileProto.getPosition() != 0)
          setPosition(param2PersonalProfileProto.getPosition()); 
        if (param2PersonalProfileProto.getType() != 0)
          setType(param2PersonalProfileProto.getType()); 
        if (!param2PersonalProfileProto.getUrl().isEmpty()) {
          this.url_ = param2PersonalProfileProto.url_;
          onChanged();
        } 
        if (param2PersonalProfileProto.getIsAi())
          setIsAi(param2PersonalProfileProto.getIsAi()); 
        if (param2PersonalProfileProto.filterType_ != 0)
          setFilterTypeValue(param2PersonalProfileProto.getFilterTypeValue()); 
        mergeUnknownFields(param2PersonalProfileProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PersonalProfileProtos.PersonalProfileProto personalProfileProto = (PersonalProfileProtos.PersonalProfileProto)PersonalProfileProtos.PersonalProfileProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PersonalProfileProtos.PersonalProfileProto personalProfileProto = (PersonalProfileProtos.PersonalProfileProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PersonalProfileProtos.PersonalProfileProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PersonalProfileProtos.PersonalProfileProto)
          return mergeFrom((PersonalProfileProtos.PersonalProfileProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setDistance(String param2String) {
        if (param2String != null) {
          this.distance_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDistanceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.distance_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEvent(PersonalProfileProtos.Event param2Event) {
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
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.feedId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFilterType(PersonalProfileProtos.FilterType param2FilterType) {
        if (param2FilterType != null) {
          this.filterType_ = param2FilterType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFilterTypeValue(int param2Int) {
        this.filterType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setGiftFrom(PersonalProfileProtos.GiftFrom param2GiftFrom) {
        if (param2GiftFrom != null) {
          this.giftFrom_ = param2GiftFrom.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGiftFromValue(int param2Int) {
        this.giftFrom_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setGiftId(String param2String) {
        if (param2String != null) {
          this.giftId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGiftIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.giftId_ = param2ByteString;
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
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.id_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdentityNum(int param2Int) {
        this.identityNum_ = param2Int;
        onChanged();
        return this;
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
      
      public Builder setIsBag(boolean param2Boolean) {
        this.isBag_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsFollow(boolean param2Boolean) {
        this.isFollow_ = param2Boolean;
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
      
      public Builder setIsVideo(boolean param2Boolean) {
        this.isVideo_ = param2Boolean;
        onChanged();
        return this;
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
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.label_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLinkUrl(String param2String) {
        if (param2String != null) {
          this.linkUrl_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLinkUrlBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.linkUrl_ = param2ByteString;
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
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.liveId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOnlineTime(String param2String) {
        if (param2String != null) {
          this.onlineTime_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOnlineTimeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.onlineTime_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPhotoNum(int param2Int) {
        this.photoNum_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPosition(int param2Int) {
        this.position_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setReason(int param2Int) {
        this.reason_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setShowType(PersonalProfileProtos.ShowType param2ShowType) {
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
      
      public Builder setSource(PersonalProfileProtos.Source param2Source) {
        if (param2Source != null) {
          this.source_ = param2Source.getNumber();
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
      
      public Builder setTabType(PersonalProfileProtos.TabType param2TabType) {
        if (param2TabType != null) {
          this.tabType_ = param2TabType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTabTypeValue(int param2Int) {
        this.tabType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setTargetIdentityType(PersonalProfileProtos.TargetIdentityType param2TargetIdentityType) {
        if (param2TargetIdentityType != null) {
          this.targetIdentityType_ = param2TargetIdentityType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTargetIdentityTypeValue(int param2Int) {
        this.targetIdentityType_ = param2Int;
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
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setType(int param2Int) {
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
          PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setVoteOption(PersonalProfileProtos.VoteOption param2VoteOption) {
        if (param2VoteOption != null) {
          this.voteOption_ = param2VoteOption.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setVoteOptionValue(int param2Int) {
        this.voteOption_ = param2Int;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<PersonalProfileProto> {
    public PersonalProfileProtos.PersonalProfileProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PersonalProfileProtos.PersonalProfileProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<PersonalProfileProto.Builder> implements PersonalProfileProtoOrBuilder {
    private Object distance_ = "";
    
    private int event_ = 0;
    
    private Object feedId_ = "";
    
    private int filterType_ = 0;
    
    private int giftFrom_ = 0;
    
    private Object giftId_ = "";
    
    private Object id_ = "";
    
    private int identityNum_;
    
    private boolean isAi_;
    
    private boolean isAppreciateCall_;
    
    private boolean isBag_;
    
    private boolean isFollow_;
    
    private boolean isMapFind_;
    
    private boolean isOpen_;
    
    private boolean isQuietCall_;
    
    private boolean isShadow_;
    
    private boolean isSuperExposure_;
    
    private boolean isVideo_;
    
    private Object label_ = "";
    
    private Object linkUrl_ = "";
    
    private Object liveId_ = "";
    
    private Object onlineTime_ = "";
    
    private int photoNum_;
    
    private int position_;
    
    private int reason_;
    
    private int showType_ = 0;
    
    private int source_ = 0;
    
    private int tabType_ = 0;
    
    private int targetIdentityType_ = 0;
    
    private Object targetUid_ = "";
    
    private int type_;
    
    private Object url_ = "";
    
    private int voteOption_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PersonalProfileProtos.PersonalProfileProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PersonalProfileProtos.PersonalProfileProto build() {
      PersonalProfileProtos.PersonalProfileProto personalProfileProto = buildPartial();
      if (personalProfileProto.isInitialized())
        return personalProfileProto; 
      throw newUninitializedMessageException(personalProfileProto);
    }
    
    public PersonalProfileProtos.PersonalProfileProto buildPartial() {
      PersonalProfileProtos.PersonalProfileProto personalProfileProto = new PersonalProfileProtos.PersonalProfileProto(this);
      PersonalProfileProtos.PersonalProfileProto.access$602(personalProfileProto, this.event_);
      PersonalProfileProtos.PersonalProfileProto.access$702(personalProfileProto, this.source_);
      PersonalProfileProtos.PersonalProfileProto.access$802(personalProfileProto, this.targetUid_);
      PersonalProfileProtos.PersonalProfileProto.access$902(personalProfileProto, this.showType_);
      PersonalProfileProtos.PersonalProfileProto.access$1002(personalProfileProto, this.distance_);
      PersonalProfileProtos.PersonalProfileProto.access$1102(personalProfileProto, this.onlineTime_);
      PersonalProfileProtos.PersonalProfileProto.access$1202(personalProfileProto, this.reason_);
      PersonalProfileProtos.PersonalProfileProto.access$1302(personalProfileProto, this.label_);
      PersonalProfileProtos.PersonalProfileProto.access$1402(personalProfileProto, this.photoNum_);
      PersonalProfileProtos.PersonalProfileProto.access$1502(personalProfileProto, this.isAppreciateCall_);
      PersonalProfileProtos.PersonalProfileProto.access$1602(personalProfileProto, this.isSuperExposure_);
      PersonalProfileProtos.PersonalProfileProto.access$1702(personalProfileProto, this.giftId_);
      PersonalProfileProtos.PersonalProfileProto.access$1802(personalProfileProto, this.tabType_);
      PersonalProfileProtos.PersonalProfileProto.access$1902(personalProfileProto, this.voteOption_);
      PersonalProfileProtos.PersonalProfileProto.access$2002(personalProfileProto, this.giftFrom_);
      PersonalProfileProtos.PersonalProfileProto.access$2102(personalProfileProto, this.linkUrl_);
      PersonalProfileProtos.PersonalProfileProto.access$2202(personalProfileProto, this.feedId_);
      PersonalProfileProtos.PersonalProfileProto.access$2302(personalProfileProto, this.targetIdentityType_);
      PersonalProfileProtos.PersonalProfileProto.access$2402(personalProfileProto, this.isMapFind_);
      PersonalProfileProtos.PersonalProfileProto.access$2502(personalProfileProto, this.isShadow_);
      PersonalProfileProtos.PersonalProfileProto.access$2602(personalProfileProto, this.isQuietCall_);
      PersonalProfileProtos.PersonalProfileProto.access$2702(personalProfileProto, this.isFollow_);
      PersonalProfileProtos.PersonalProfileProto.access$2802(personalProfileProto, this.identityNum_);
      PersonalProfileProtos.PersonalProfileProto.access$2902(personalProfileProto, this.isOpen_);
      PersonalProfileProtos.PersonalProfileProto.access$3002(personalProfileProto, this.isVideo_);
      PersonalProfileProtos.PersonalProfileProto.access$3102(personalProfileProto, this.isBag_);
      PersonalProfileProtos.PersonalProfileProto.access$3202(personalProfileProto, this.id_);
      PersonalProfileProtos.PersonalProfileProto.access$3302(personalProfileProto, this.liveId_);
      PersonalProfileProtos.PersonalProfileProto.access$3402(personalProfileProto, this.position_);
      PersonalProfileProtos.PersonalProfileProto.access$3502(personalProfileProto, this.type_);
      PersonalProfileProtos.PersonalProfileProto.access$3602(personalProfileProto, this.url_);
      PersonalProfileProtos.PersonalProfileProto.access$3702(personalProfileProto, this.isAi_);
      PersonalProfileProtos.PersonalProfileProto.access$3802(personalProfileProto, this.filterType_);
      onBuilt();
      return personalProfileProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.source_ = 0;
      this.targetUid_ = "";
      this.showType_ = 0;
      this.distance_ = "";
      this.onlineTime_ = "";
      this.reason_ = 0;
      this.label_ = "";
      this.photoNum_ = 0;
      this.isAppreciateCall_ = false;
      this.isSuperExposure_ = false;
      this.giftId_ = "";
      this.tabType_ = 0;
      this.voteOption_ = 0;
      this.giftFrom_ = 0;
      this.linkUrl_ = "";
      this.feedId_ = "";
      this.targetIdentityType_ = 0;
      this.isMapFind_ = false;
      this.isShadow_ = false;
      this.isQuietCall_ = false;
      this.isFollow_ = false;
      this.identityNum_ = 0;
      this.isOpen_ = false;
      this.isVideo_ = false;
      this.isBag_ = false;
      this.id_ = "";
      this.liveId_ = "";
      this.position_ = 0;
      this.type_ = 0;
      this.url_ = "";
      this.isAi_ = false;
      this.filterType_ = 0;
      return this;
    }
    
    public Builder clearDistance() {
      this.distance_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getDistance();
      onChanged();
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedId() {
      this.feedId_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getFeedId();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFilterType() {
      this.filterType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearGiftFrom() {
      this.giftFrom_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearGiftId() {
      this.giftId_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getGiftId();
      onChanged();
      return this;
    }
    
    public Builder clearId() {
      this.id_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearIdentityNum() {
      this.identityNum_ = 0;
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
    
    public Builder clearIsBag() {
      this.isBag_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsFollow() {
      this.isFollow_ = false;
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
    
    public Builder clearIsVideo() {
      this.isVideo_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearLabel() {
      this.label_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getLabel();
      onChanged();
      return this;
    }
    
    public Builder clearLinkUrl() {
      this.linkUrl_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getLinkUrl();
      onChanged();
      return this;
    }
    
    public Builder clearLiveId() {
      this.liveId_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOnlineTime() {
      this.onlineTime_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getOnlineTime();
      onChanged();
      return this;
    }
    
    public Builder clearPhotoNum() {
      this.photoNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPosition() {
      this.position_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearReason() {
      this.reason_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearShowType() {
      this.showType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSource() {
      this.source_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTabType() {
      this.tabType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetIdentityType() {
      this.targetIdentityType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clearType() {
      this.type_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearUrl() {
      this.url_ = PersonalProfileProtos.PersonalProfileProto.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clearVoteOption() {
      this.voteOption_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public PersonalProfileProtos.PersonalProfileProto getDefaultInstanceForType() {
      return PersonalProfileProtos.PersonalProfileProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
    }
    
    public String getDistance() {
      Object object = this.distance_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.distance_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDistanceBytes() {
      Object object = this.distance_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.distance_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PersonalProfileProtos.Event getEvent() {
      PersonalProfileProtos.Event event2 = PersonalProfileProtos.Event.valueOf(this.event_);
      PersonalProfileProtos.Event event1 = event2;
      if (event2 == null)
        event1 = PersonalProfileProtos.Event.UNRECOGNIZED; 
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
    
    public PersonalProfileProtos.FilterType getFilterType() {
      PersonalProfileProtos.FilterType filterType2 = PersonalProfileProtos.FilterType.valueOf(this.filterType_);
      PersonalProfileProtos.FilterType filterType1 = filterType2;
      if (filterType2 == null)
        filterType1 = PersonalProfileProtos.FilterType.UNRECOGNIZED; 
      return filterType1;
    }
    
    public int getFilterTypeValue() {
      return this.filterType_;
    }
    
    public PersonalProfileProtos.GiftFrom getGiftFrom() {
      PersonalProfileProtos.GiftFrom giftFrom2 = PersonalProfileProtos.GiftFrom.valueOf(this.giftFrom_);
      PersonalProfileProtos.GiftFrom giftFrom1 = giftFrom2;
      if (giftFrom2 == null)
        giftFrom1 = PersonalProfileProtos.GiftFrom.UNRECOGNIZED; 
      return giftFrom1;
    }
    
    public int getGiftFromValue() {
      return this.giftFrom_;
    }
    
    public String getGiftId() {
      Object object = this.giftId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.giftId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getGiftIdBytes() {
      Object object = this.giftId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.giftId_ = object;
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
    
    public int getIdentityNum() {
      return this.identityNum_;
    }
    
    public boolean getIsAi() {
      return this.isAi_;
    }
    
    public boolean getIsAppreciateCall() {
      return this.isAppreciateCall_;
    }
    
    public boolean getIsBag() {
      return this.isBag_;
    }
    
    public boolean getIsFollow() {
      return this.isFollow_;
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
    
    public boolean getIsVideo() {
      return this.isVideo_;
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
    
    public String getLinkUrl() {
      Object object = this.linkUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.linkUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLinkUrlBytes() {
      Object object = this.linkUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.linkUrl_ = object;
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
    
    public String getOnlineTime() {
      Object object = this.onlineTime_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.onlineTime_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOnlineTimeBytes() {
      Object object = this.onlineTime_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.onlineTime_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getPhotoNum() {
      return this.photoNum_;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public int getReason() {
      return this.reason_;
    }
    
    public PersonalProfileProtos.ShowType getShowType() {
      PersonalProfileProtos.ShowType showType2 = PersonalProfileProtos.ShowType.valueOf(this.showType_);
      PersonalProfileProtos.ShowType showType1 = showType2;
      if (showType2 == null)
        showType1 = PersonalProfileProtos.ShowType.UNRECOGNIZED; 
      return showType1;
    }
    
    public int getShowTypeValue() {
      return this.showType_;
    }
    
    public PersonalProfileProtos.Source getSource() {
      PersonalProfileProtos.Source source2 = PersonalProfileProtos.Source.valueOf(this.source_);
      PersonalProfileProtos.Source source1 = source2;
      if (source2 == null)
        source1 = PersonalProfileProtos.Source.UNRECOGNIZED; 
      return source1;
    }
    
    public int getSourceValue() {
      return this.source_;
    }
    
    public PersonalProfileProtos.TabType getTabType() {
      PersonalProfileProtos.TabType tabType2 = PersonalProfileProtos.TabType.valueOf(this.tabType_);
      PersonalProfileProtos.TabType tabType1 = tabType2;
      if (tabType2 == null)
        tabType1 = PersonalProfileProtos.TabType.UNRECOGNIZED; 
      return tabType1;
    }
    
    public int getTabTypeValue() {
      return this.tabType_;
    }
    
    public PersonalProfileProtos.TargetIdentityType getTargetIdentityType() {
      PersonalProfileProtos.TargetIdentityType targetIdentityType2 = PersonalProfileProtos.TargetIdentityType.valueOf(this.targetIdentityType_);
      PersonalProfileProtos.TargetIdentityType targetIdentityType1 = targetIdentityType2;
      if (targetIdentityType2 == null)
        targetIdentityType1 = PersonalProfileProtos.TargetIdentityType.UNRECOGNIZED; 
      return targetIdentityType1;
    }
    
    public int getTargetIdentityTypeValue() {
      return this.targetIdentityType_;
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
    
    public int getType() {
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
    
    public PersonalProfileProtos.VoteOption getVoteOption() {
      PersonalProfileProtos.VoteOption voteOption2 = PersonalProfileProtos.VoteOption.valueOf(this.voteOption_);
      PersonalProfileProtos.VoteOption voteOption1 = voteOption2;
      if (voteOption2 == null)
        voteOption1 = PersonalProfileProtos.VoteOption.UNRECOGNIZED; 
      return voteOption1;
    }
    
    public int getVoteOptionValue() {
      return this.voteOption_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalProfileProtos.PersonalProfileProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(PersonalProfileProtos.PersonalProfileProto param1PersonalProfileProto) {
      if (param1PersonalProfileProto == PersonalProfileProtos.PersonalProfileProto.getDefaultInstance())
        return this; 
      if (param1PersonalProfileProto.event_ != 0)
        setEventValue(param1PersonalProfileProto.getEventValue()); 
      if (param1PersonalProfileProto.source_ != 0)
        setSourceValue(param1PersonalProfileProto.getSourceValue()); 
      if (!param1PersonalProfileProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1PersonalProfileProto.targetUid_;
        onChanged();
      } 
      if (param1PersonalProfileProto.showType_ != 0)
        setShowTypeValue(param1PersonalProfileProto.getShowTypeValue()); 
      if (!param1PersonalProfileProto.getDistance().isEmpty()) {
        this.distance_ = param1PersonalProfileProto.distance_;
        onChanged();
      } 
      if (!param1PersonalProfileProto.getOnlineTime().isEmpty()) {
        this.onlineTime_ = param1PersonalProfileProto.onlineTime_;
        onChanged();
      } 
      if (param1PersonalProfileProto.getReason() != 0)
        setReason(param1PersonalProfileProto.getReason()); 
      if (!param1PersonalProfileProto.getLabel().isEmpty()) {
        this.label_ = param1PersonalProfileProto.label_;
        onChanged();
      } 
      if (param1PersonalProfileProto.getPhotoNum() != 0)
        setPhotoNum(param1PersonalProfileProto.getPhotoNum()); 
      if (param1PersonalProfileProto.getIsAppreciateCall())
        setIsAppreciateCall(param1PersonalProfileProto.getIsAppreciateCall()); 
      if (param1PersonalProfileProto.getIsSuperExposure())
        setIsSuperExposure(param1PersonalProfileProto.getIsSuperExposure()); 
      if (!param1PersonalProfileProto.getGiftId().isEmpty()) {
        this.giftId_ = param1PersonalProfileProto.giftId_;
        onChanged();
      } 
      if (param1PersonalProfileProto.tabType_ != 0)
        setTabTypeValue(param1PersonalProfileProto.getTabTypeValue()); 
      if (param1PersonalProfileProto.voteOption_ != 0)
        setVoteOptionValue(param1PersonalProfileProto.getVoteOptionValue()); 
      if (param1PersonalProfileProto.giftFrom_ != 0)
        setGiftFromValue(param1PersonalProfileProto.getGiftFromValue()); 
      if (!param1PersonalProfileProto.getLinkUrl().isEmpty()) {
        this.linkUrl_ = param1PersonalProfileProto.linkUrl_;
        onChanged();
      } 
      if (!param1PersonalProfileProto.getFeedId().isEmpty()) {
        this.feedId_ = param1PersonalProfileProto.feedId_;
        onChanged();
      } 
      if (param1PersonalProfileProto.targetIdentityType_ != 0)
        setTargetIdentityTypeValue(param1PersonalProfileProto.getTargetIdentityTypeValue()); 
      if (param1PersonalProfileProto.getIsMapFind())
        setIsMapFind(param1PersonalProfileProto.getIsMapFind()); 
      if (param1PersonalProfileProto.getIsShadow())
        setIsShadow(param1PersonalProfileProto.getIsShadow()); 
      if (param1PersonalProfileProto.getIsQuietCall())
        setIsQuietCall(param1PersonalProfileProto.getIsQuietCall()); 
      if (param1PersonalProfileProto.getIsFollow())
        setIsFollow(param1PersonalProfileProto.getIsFollow()); 
      if (param1PersonalProfileProto.getIdentityNum() != 0)
        setIdentityNum(param1PersonalProfileProto.getIdentityNum()); 
      if (param1PersonalProfileProto.getIsOpen())
        setIsOpen(param1PersonalProfileProto.getIsOpen()); 
      if (param1PersonalProfileProto.getIsVideo())
        setIsVideo(param1PersonalProfileProto.getIsVideo()); 
      if (param1PersonalProfileProto.getIsBag())
        setIsBag(param1PersonalProfileProto.getIsBag()); 
      if (!param1PersonalProfileProto.getId().isEmpty()) {
        this.id_ = param1PersonalProfileProto.id_;
        onChanged();
      } 
      if (!param1PersonalProfileProto.getLiveId().isEmpty()) {
        this.liveId_ = param1PersonalProfileProto.liveId_;
        onChanged();
      } 
      if (param1PersonalProfileProto.getPosition() != 0)
        setPosition(param1PersonalProfileProto.getPosition()); 
      if (param1PersonalProfileProto.getType() != 0)
        setType(param1PersonalProfileProto.getType()); 
      if (!param1PersonalProfileProto.getUrl().isEmpty()) {
        this.url_ = param1PersonalProfileProto.url_;
        onChanged();
      } 
      if (param1PersonalProfileProto.getIsAi())
        setIsAi(param1PersonalProfileProto.getIsAi()); 
      if (param1PersonalProfileProto.filterType_ != 0)
        setFilterTypeValue(param1PersonalProfileProto.getFilterTypeValue()); 
      mergeUnknownFields(param1PersonalProfileProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PersonalProfileProtos.PersonalProfileProto personalProfileProto = (PersonalProfileProtos.PersonalProfileProto)PersonalProfileProtos.PersonalProfileProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PersonalProfileProtos.PersonalProfileProto personalProfileProto = (PersonalProfileProtos.PersonalProfileProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PersonalProfileProtos.PersonalProfileProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PersonalProfileProtos.PersonalProfileProto)
        return mergeFrom((PersonalProfileProtos.PersonalProfileProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDistance(String param1String) {
      if (param1String != null) {
        this.distance_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDistanceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.distance_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEvent(PersonalProfileProtos.Event param1Event) {
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
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.feedId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFilterType(PersonalProfileProtos.FilterType param1FilterType) {
      if (param1FilterType != null) {
        this.filterType_ = param1FilterType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFilterTypeValue(int param1Int) {
      this.filterType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setGiftFrom(PersonalProfileProtos.GiftFrom param1GiftFrom) {
      if (param1GiftFrom != null) {
        this.giftFrom_ = param1GiftFrom.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGiftFromValue(int param1Int) {
      this.giftFrom_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setGiftId(String param1String) {
      if (param1String != null) {
        this.giftId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGiftIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.giftId_ = param1ByteString;
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
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdentityNum(int param1Int) {
      this.identityNum_ = param1Int;
      onChanged();
      return this;
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
    
    public Builder setIsBag(boolean param1Boolean) {
      this.isBag_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsFollow(boolean param1Boolean) {
      this.isFollow_ = param1Boolean;
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
    
    public Builder setIsVideo(boolean param1Boolean) {
      this.isVideo_ = param1Boolean;
      onChanged();
      return this;
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
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.label_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLinkUrl(String param1String) {
      if (param1String != null) {
        this.linkUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLinkUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.linkUrl_ = param1ByteString;
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
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.liveId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOnlineTime(String param1String) {
      if (param1String != null) {
        this.onlineTime_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOnlineTimeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.onlineTime_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPhotoNum(int param1Int) {
      this.photoNum_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPosition(int param1Int) {
      this.position_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setReason(int param1Int) {
      this.reason_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setShowType(PersonalProfileProtos.ShowType param1ShowType) {
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
    
    public Builder setSource(PersonalProfileProtos.Source param1Source) {
      if (param1Source != null) {
        this.source_ = param1Source.getNumber();
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
    
    public Builder setTabType(PersonalProfileProtos.TabType param1TabType) {
      if (param1TabType != null) {
        this.tabType_ = param1TabType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTabTypeValue(int param1Int) {
      this.tabType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setTargetIdentityType(PersonalProfileProtos.TargetIdentityType param1TargetIdentityType) {
      if (param1TargetIdentityType != null) {
        this.targetIdentityType_ = param1TargetIdentityType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTargetIdentityTypeValue(int param1Int) {
      this.targetIdentityType_ = param1Int;
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
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setType(int param1Int) {
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
        PersonalProfileProtos.PersonalProfileProto.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setVoteOption(PersonalProfileProtos.VoteOption param1VoteOption) {
      if (param1VoteOption != null) {
        this.voteOption_ = param1VoteOption.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setVoteOptionValue(int param1Int) {
      this.voteOption_ = param1Int;
      onChanged();
      return this;
    }
  }
  
  public static interface PersonalProfileProtoOrBuilder extends MessageOrBuilder {
    String getDistance();
    
    ByteString getDistanceBytes();
    
    PersonalProfileProtos.Event getEvent();
    
    int getEventValue();
    
    String getFeedId();
    
    ByteString getFeedIdBytes();
    
    PersonalProfileProtos.FilterType getFilterType();
    
    int getFilterTypeValue();
    
    PersonalProfileProtos.GiftFrom getGiftFrom();
    
    int getGiftFromValue();
    
    String getGiftId();
    
    ByteString getGiftIdBytes();
    
    String getId();
    
    ByteString getIdBytes();
    
    int getIdentityNum();
    
    boolean getIsAi();
    
    boolean getIsAppreciateCall();
    
    boolean getIsBag();
    
    boolean getIsFollow();
    
    boolean getIsMapFind();
    
    boolean getIsOpen();
    
    boolean getIsQuietCall();
    
    boolean getIsShadow();
    
    boolean getIsSuperExposure();
    
    boolean getIsVideo();
    
    String getLabel();
    
    ByteString getLabelBytes();
    
    String getLinkUrl();
    
    ByteString getLinkUrlBytes();
    
    String getLiveId();
    
    ByteString getLiveIdBytes();
    
    String getOnlineTime();
    
    ByteString getOnlineTimeBytes();
    
    int getPhotoNum();
    
    int getPosition();
    
    int getReason();
    
    PersonalProfileProtos.ShowType getShowType();
    
    int getShowTypeValue();
    
    PersonalProfileProtos.Source getSource();
    
    int getSourceValue();
    
    PersonalProfileProtos.TabType getTabType();
    
    int getTabTypeValue();
    
    PersonalProfileProtos.TargetIdentityType getTargetIdentityType();
    
    int getTargetIdentityTypeValue();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
    
    int getType();
    
    String getUrl();
    
    ByteString getUrlBytes();
    
    PersonalProfileProtos.VoteOption getVoteOption();
    
    int getVoteOptionValue();
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
          public PersonalProfileProtos.ShowType findValueByNumber(int param2Int) {
            return PersonalProfileProtos.ShowType.forNumber(param2Int);
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
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(2);
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
    public PersonalProfileProtos.ShowType findValueByNumber(int param1Int) {
      return PersonalProfileProtos.ShowType.forNumber(param1Int);
    }
  }
  
  public enum Source implements ProtocolMessageEnum {
    APPRECIATE_CALL_SHORT(0),
    APPRECIATE_CALL_TOTAL(0),
    CIRCLE_ACTIVE_MEMBER_LIST(0),
    CIRCLE_ACTIVE_MEMBER_MISSION(0),
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
    FIND_PLAZA_FLASH(0),
    FIND_PLAZA_FLASH_DETAIL(0),
    FIND_PLAZA_FOLLOW(0),
    FIND_PLAZA_IMAGE(0),
    FIND_PLAZA_NEARBY(0),
    FIND_PLAZA_RECOMMEND(0),
    FIND_PLAZA_RECOMMEND_USER(0),
    FIND_TOPIC_FEED(0),
    FOLLOW_ATTENTION(0),
    FRIEND_NEARBY_VIEW(0),
    FRIEND_NEARBY_VISIT(0),
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
    SUPER_TOPIC_DETAIL(0),
    UNKNOWN_FOLLOW_SOURCE(0),
    UNRECOGNIZED(0);
    
    public static final int APPRECIATE_CALL_SHORT_VALUE = 6;
    
    public static final int APPRECIATE_CALL_TOTAL_VALUE = 7;
    
    public static final int CIRCLE_ACTIVE_MEMBER_LIST_VALUE = 35;
    
    public static final int CIRCLE_ACTIVE_MEMBER_MISSION_VALUE = 36;
    
    public static final int CIRCLE_DETAIL_NOTE_HOT_VALUE = 31;
    
    public static final int CIRCLE_DETAIL_NOTE_NEW_VALUE = 30;
    
    public static final int CIRCLE_NOTE_DETAIL_VALUE = 29;
    
    public static final int CIRCLE_USERS_VALUE = 32;
    
    public static final int COMPLEX_SORT_VALUE = 11;
    
    public static final int DISTANCE_SORT_VALUE = 13;
    
    public static final int FEED_COMMENT_VALUE = 15;
    
    public static final int FEED_DETAIL_VALUE = 25;
    
    public static final int FEED_FIND_PHOTO_VALUE = 4;
    
    public static final int FEED_FIND_PLAZA_VALUE = 5;
    
    public static final int FIND_PLAZA_FLASH_DETAIL_VALUE = 24;
    
    public static final int FIND_PLAZA_FLASH_VALUE = 23;
    
    public static final int FIND_PLAZA_FOLLOW_VALUE = 20;
    
    public static final int FIND_PLAZA_IMAGE_VALUE = 22;
    
    public static final int FIND_PLAZA_NEARBY_VALUE = 21;
    
    public static final int FIND_PLAZA_RECOMMEND_USER_VALUE = 18;
    
    public static final int FIND_PLAZA_RECOMMEND_VALUE = 19;
    
    public static final int FIND_TOPIC_FEED_VALUE = 34;
    
    public static final int FOLLOW_ATTENTION_VALUE = 3;
    
    public static final int FRIEND_NEARBY_VIEW_VALUE = 2;
    
    public static final int FRIEND_NEARBY_VISIT_VALUE = 1;
    
    public static final int MINE_FAN_VALUE = 9;
    
    public static final int MINE_FOLLOW_VALUE = 8;
    
    public static final int MINE_FRIEND_VALUE = 10;
    
    public static final int NEARBY_FEATURED_VALUE = 14;
    
    public static final int NEW_FACE_VALUE = 16;
    
    public static final int ONE_CITY_VALUE = 33;
    
    public static final int ONLINE_TIME_SORT_VALUE = 12;
    
    public static final int PAGE_FEED_DETAIL_MORE_VALUE = 28;
    
    public static final int PAGE_FEED_LIKE_VALUE = 27;
    
    public static final int PAGE_FEED_MINE_VALUE = 26;
    
    public static final int SUPER_TOPIC_DETAIL_VALUE = 17;
    
    public static final int UNKNOWN_FOLLOW_SOURCE_VALUE = 0;
    
    private static final Source[] VALUES;
    
    private static final Internal.EnumLiteMap<Source> internalValueMap;
    
    private final int value;
    
    static {
      FRIEND_NEARBY_VIEW = new Source("FRIEND_NEARBY_VIEW", 2, 2);
      FOLLOW_ATTENTION = new Source("FOLLOW_ATTENTION", 3, 3);
      FEED_FIND_PHOTO = new Source("FEED_FIND_PHOTO", 4, 4);
      FEED_FIND_PLAZA = new Source("FEED_FIND_PLAZA", 5, 5);
      APPRECIATE_CALL_SHORT = new Source("APPRECIATE_CALL_SHORT", 6, 6);
      APPRECIATE_CALL_TOTAL = new Source("APPRECIATE_CALL_TOTAL", 7, 7);
      MINE_FOLLOW = new Source("MINE_FOLLOW", 8, 8);
      MINE_FAN = new Source("MINE_FAN", 9, 9);
      MINE_FRIEND = new Source("MINE_FRIEND", 10, 10);
      COMPLEX_SORT = new Source("COMPLEX_SORT", 11, 11);
      ONLINE_TIME_SORT = new Source("ONLINE_TIME_SORT", 12, 12);
      DISTANCE_SORT = new Source("DISTANCE_SORT", 13, 13);
      NEARBY_FEATURED = new Source("NEARBY_FEATURED", 14, 14);
      FEED_COMMENT = new Source("FEED_COMMENT", 15, 15);
      NEW_FACE = new Source("NEW_FACE", 16, 16);
      SUPER_TOPIC_DETAIL = new Source("SUPER_TOPIC_DETAIL", 17, 17);
      FIND_PLAZA_RECOMMEND_USER = new Source("FIND_PLAZA_RECOMMEND_USER", 18, 18);
      FIND_PLAZA_RECOMMEND = new Source("FIND_PLAZA_RECOMMEND", 19, 19);
      FIND_PLAZA_FOLLOW = new Source("FIND_PLAZA_FOLLOW", 20, 20);
      FIND_PLAZA_NEARBY = new Source("FIND_PLAZA_NEARBY", 21, 21);
      FIND_PLAZA_IMAGE = new Source("FIND_PLAZA_IMAGE", 22, 22);
      FIND_PLAZA_FLASH = new Source("FIND_PLAZA_FLASH", 23, 23);
      FIND_PLAZA_FLASH_DETAIL = new Source("FIND_PLAZA_FLASH_DETAIL", 24, 24);
      FEED_DETAIL = new Source("FEED_DETAIL", 25, 25);
      PAGE_FEED_MINE = new Source("PAGE_FEED_MINE", 26, 26);
      PAGE_FEED_LIKE = new Source("PAGE_FEED_LIKE", 27, 27);
      PAGE_FEED_DETAIL_MORE = new Source("PAGE_FEED_DETAIL_MORE", 28, 28);
      CIRCLE_NOTE_DETAIL = new Source("CIRCLE_NOTE_DETAIL", 29, 29);
      CIRCLE_DETAIL_NOTE_NEW = new Source("CIRCLE_DETAIL_NOTE_NEW", 30, 30);
      CIRCLE_DETAIL_NOTE_HOT = new Source("CIRCLE_DETAIL_NOTE_HOT", 31, 31);
      CIRCLE_USERS = new Source("CIRCLE_USERS", 32, 32);
      ONE_CITY = new Source("ONE_CITY", 33, 33);
      FIND_TOPIC_FEED = new Source("FIND_TOPIC_FEED", 34, 34);
      CIRCLE_ACTIVE_MEMBER_LIST = new Source("CIRCLE_ACTIVE_MEMBER_LIST", 35, 35);
      CIRCLE_ACTIVE_MEMBER_MISSION = new Source("CIRCLE_ACTIVE_MEMBER_MISSION", 36, 36);
      UNRECOGNIZED = new Source("UNRECOGNIZED", 37, -1);
      $VALUES = new Source[] { 
          UNKNOWN_FOLLOW_SOURCE, FRIEND_NEARBY_VISIT, FRIEND_NEARBY_VIEW, FOLLOW_ATTENTION, FEED_FIND_PHOTO, FEED_FIND_PLAZA, APPRECIATE_CALL_SHORT, APPRECIATE_CALL_TOTAL, MINE_FOLLOW, MINE_FAN, 
          MINE_FRIEND, COMPLEX_SORT, ONLINE_TIME_SORT, DISTANCE_SORT, NEARBY_FEATURED, FEED_COMMENT, NEW_FACE, SUPER_TOPIC_DETAIL, FIND_PLAZA_RECOMMEND_USER, FIND_PLAZA_RECOMMEND, 
          FIND_PLAZA_FOLLOW, FIND_PLAZA_NEARBY, FIND_PLAZA_IMAGE, FIND_PLAZA_FLASH, FIND_PLAZA_FLASH_DETAIL, FEED_DETAIL, PAGE_FEED_MINE, PAGE_FEED_LIKE, PAGE_FEED_DETAIL_MORE, CIRCLE_NOTE_DETAIL, 
          CIRCLE_DETAIL_NOTE_NEW, CIRCLE_DETAIL_NOTE_HOT, CIRCLE_USERS, ONE_CITY, FIND_TOPIC_FEED, CIRCLE_ACTIVE_MEMBER_LIST, CIRCLE_ACTIVE_MEMBER_MISSION, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Source>() {
          public PersonalProfileProtos.Source findValueByNumber(int param2Int) {
            return PersonalProfileProtos.Source.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Source(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Source forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 36:
          return CIRCLE_ACTIVE_MEMBER_MISSION;
        case 35:
          return CIRCLE_ACTIVE_MEMBER_LIST;
        case 34:
          return FIND_TOPIC_FEED;
        case 33:
          return ONE_CITY;
        case 32:
          return CIRCLE_USERS;
        case 31:
          return CIRCLE_DETAIL_NOTE_HOT;
        case 30:
          return CIRCLE_DETAIL_NOTE_NEW;
        case 29:
          return CIRCLE_NOTE_DETAIL;
        case 28:
          return PAGE_FEED_DETAIL_MORE;
        case 27:
          return PAGE_FEED_LIKE;
        case 26:
          return PAGE_FEED_MINE;
        case 25:
          return FEED_DETAIL;
        case 24:
          return FIND_PLAZA_FLASH_DETAIL;
        case 23:
          return FIND_PLAZA_FLASH;
        case 22:
          return FIND_PLAZA_IMAGE;
        case 21:
          return FIND_PLAZA_NEARBY;
        case 20:
          return FIND_PLAZA_FOLLOW;
        case 19:
          return FIND_PLAZA_RECOMMEND;
        case 18:
          return FIND_PLAZA_RECOMMEND_USER;
        case 17:
          return SUPER_TOPIC_DETAIL;
        case 16:
          return NEW_FACE;
        case 15:
          return FEED_COMMENT;
        case 14:
          return NEARBY_FEATURED;
        case 13:
          return DISTANCE_SORT;
        case 12:
          return ONLINE_TIME_SORT;
        case 11:
          return COMPLEX_SORT;
        case 10:
          return MINE_FRIEND;
        case 9:
          return MINE_FAN;
        case 8:
          return MINE_FOLLOW;
        case 7:
          return APPRECIATE_CALL_TOTAL;
        case 6:
          return APPRECIATE_CALL_SHORT;
        case 5:
          return FEED_FIND_PLAZA;
        case 4:
          return FEED_FIND_PHOTO;
        case 3:
          return FOLLOW_ATTENTION;
        case 2:
          return FRIEND_NEARBY_VIEW;
        case 1:
          return FRIEND_NEARBY_VISIT;
        case 0:
          break;
      } 
      return UNKNOWN_FOLLOW_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<Source> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<Source> {
    public PersonalProfileProtos.Source findValueByNumber(int param1Int) {
      return PersonalProfileProtos.Source.forNumber(param1Int);
    }
  }
  
  public enum TabType implements ProtocolMessageEnum {
    FEED_LOAD(0),
    PHOTO_LOAD(0),
    PROFILE_LOAD(0),
    UNKNOWN_TAB_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int FEED_LOAD_VALUE = 1;
    
    public static final int PHOTO_LOAD_VALUE = 3;
    
    public static final int PROFILE_LOAD_VALUE = 2;
    
    public static final int UNKNOWN_TAB_TYPE_VALUE = 0;
    
    private static final TabType[] VALUES;
    
    private static final Internal.EnumLiteMap<TabType> internalValueMap;
    
    private final int value;
    
    static {
      PHOTO_LOAD = new TabType("PHOTO_LOAD", 3, 3);
      UNRECOGNIZED = new TabType("UNRECOGNIZED", 4, -1);
      $VALUES = new TabType[] { UNKNOWN_TAB_TYPE, FEED_LOAD, PROFILE_LOAD, PHOTO_LOAD, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TabType>() {
          public PersonalProfileProtos.TabType findValueByNumber(int param2Int) {
            return PersonalProfileProtos.TabType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    TabType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TabType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : PHOTO_LOAD) : PROFILE_LOAD) : FEED_LOAD) : UNKNOWN_TAB_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(3);
    }
    
    public static Internal.EnumLiteMap<TabType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<TabType> {
    public PersonalProfileProtos.TabType findValueByNumber(int param1Int) {
      return PersonalProfileProtos.TabType.forNumber(param1Int);
    }
  }
  
  public enum TargetIdentityType implements ProtocolMessageEnum {
    NONE(0),
    SVIP(0),
    UNKNOWN_TARGET_IDENTITY_TYPE(0),
    UNRECOGNIZED(0),
    VIP(0);
    
    public static final int NONE_VALUE = 1;
    
    public static final int SVIP_VALUE = 3;
    
    public static final int UNKNOWN_TARGET_IDENTITY_TYPE_VALUE = 0;
    
    private static final TargetIdentityType[] VALUES;
    
    public static final int VIP_VALUE = 2;
    
    private static final Internal.EnumLiteMap<TargetIdentityType> internalValueMap;
    
    private final int value;
    
    static {
      SVIP = new TargetIdentityType("SVIP", 3, 3);
      UNRECOGNIZED = new TargetIdentityType("UNRECOGNIZED", 4, -1);
      $VALUES = new TargetIdentityType[] { UNKNOWN_TARGET_IDENTITY_TYPE, NONE, VIP, SVIP, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TargetIdentityType>() {
          public PersonalProfileProtos.TargetIdentityType findValueByNumber(int param2Int) {
            return PersonalProfileProtos.TargetIdentityType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    TargetIdentityType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TargetIdentityType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : SVIP) : VIP) : NONE) : UNKNOWN_TARGET_IDENTITY_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(6);
    }
    
    public static Internal.EnumLiteMap<TargetIdentityType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<TargetIdentityType> {
    public PersonalProfileProtos.TargetIdentityType findValueByNumber(int param1Int) {
      return PersonalProfileProtos.TargetIdentityType.forNumber(param1Int);
    }
  }
  
  public enum VoteOption implements ProtocolMessageEnum {
    IS_JUNK(0),
    NOT_JUNK(0),
    UNCERTAIN(0),
    UNKNOWN_VOTE_OPTION(0),
    UNRECOGNIZED(0);
    
    public static final int IS_JUNK_VALUE = 1;
    
    public static final int NOT_JUNK_VALUE = 2;
    
    public static final int UNCERTAIN_VALUE = 3;
    
    public static final int UNKNOWN_VOTE_OPTION_VALUE = 0;
    
    private static final VoteOption[] VALUES;
    
    private static final Internal.EnumLiteMap<VoteOption> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new VoteOption[] { UNKNOWN_VOTE_OPTION, IS_JUNK, NOT_JUNK, UNCERTAIN, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<VoteOption>() {
          public PersonalProfileProtos.VoteOption findValueByNumber(int param2Int) {
            return PersonalProfileProtos.VoteOption.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    VoteOption(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static VoteOption forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : UNCERTAIN) : NOT_JUNK) : IS_JUNK) : UNKNOWN_VOTE_OPTION;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PersonalProfileProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<VoteOption> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<VoteOption> {
    public PersonalProfileProtos.VoteOption findValueByNumber(int param1Int) {
      return PersonalProfileProtos.VoteOption.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\profile\PersonalProfileProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
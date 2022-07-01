package com.blued.das.live;

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

public final class LiveProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\020LiveProtos.proto\022\022com.blued.das.live\"×\013\n\tLiveProto\022(\n\005event\030\001 \001(\0162\031.com.blued.das.live.Event\0223\n\013gift_status\030\002 \001(\0162\036.com.blued.das.live.GiftStatus\0221\n\nenter_type\030\003 \001(\0162\035.com.blued.das.live.EnterType\022*\n\006status\030\004 \001(\0162\032.com.blued.das.live.Status\022\021\n\tfilter_id\030\005 \001(\t\022\017\n\007is_auto\030\006 \001(\b\022<\n\020first_pay_status\030\007 \001(\0162\".com.blued.das.live.FirstPayStatus\0221\n\npay_status\030\b \001(\0162\035.com.blued.das.live.PayStatus\022\017\n\007live_id\030\t \001(\t\022\013\n\003url\030\n \001(\t\022\022\n\ntarget_uid\030\013 \001(\t\022\022\n\nfeature_id\030\f \001(\t\022-\n\bbox_type\030\r \001(\0162\033.com.blued.das.live.BoxType\022.\n\bTaskType\030\016 \001(\0162\034.com.blued.das.live.TaskType\0220\n\tAwardType\030\017 \001(\0162\035.com.blued.das.live.AwardType\022\r\n\005count\030\020 \001(\005\0227\n\rfollow_status\030\021 \001(\0162 .com.blued.das.live.FollowStatus\022\022\n\nis_success\030\022 \001(\b\022\024\n\flive_type_id\030\023 \001(\t\022\017\n\007is_join\030\024 \001(\b\022-\n\bbtn_type\030\025 \001(\0162\033.com.blued.das.live.BtnType\022*\n\006source\030\026 \001(\0162\032.com.blued.das.live.Source\022\017\n\007task_id\030\027 \001(\t\022/\n\tlive_type\030\030 \001(\0162\034.com.blued.das.live.LiveType\022\023\n\013beans_count\030\031 \001(\005\022\021\n\tbeans_num\030\032 \001(\005\022\022\n\nview_count\030\033 \001(\005\022\022\n\nlike_count\030\034 \001(\005\022\024\n\fonline_count\030\035 \001(\005\022\025\n\rlive_duration\030\036 \001(\005\022\020\n\bgoods_id\030\037 \001(\t\022\013\n\003num\030  \001(\005\022\021\n\tguest_uid\030! \001(\t\022\031\n\021recommend_live_id\030\" \001(\t\022\025\n\rrecommend_uid\030# \001(\t\022\020\n\bis_queue\030$ \001(\b\022/\n\tcard_from\030% \001(\0162\034.com.blued.das.live.CardFrom\022\017\n\007is_open\030& \001(\b\022\021\n\tlive_from\030' \001(\t\022\022\n\nis_mystery\030( \001(\b\022\023\n\013mystery_uid\030) \001(\t\022\020\n\bmusic_id\030* \001(\t\022\016\n\006tab_id\030+ \001(\t\022\020\n\bpassword\030, \001(\t\022\021\n\tcondition\030- \001(\005\022\020\n\blive_tab\030. \001(\t\022\020\n\bposition\030/ \001(\005\022\017\n\007tab_num\0300 \001(\005\022\020\n\bpage_num\0301 \001(\005\022\n\n\002id\0302 \001(\t\022\025\n\rlive_from_num\0303 \001(\005\022\024\n\ffollowed_uid\0304 \001(\t\022\026\n\016recommend_type\0305 \001(\t\022\f\n\004from\0306 \001(\t\022\023\n\013is_hit_time\0307 \001(\b\022\r\n\005is_pk\0308 \001(\b*½=\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\037\n\033START_LIVE_BEAUTY_BTN_CLICK\020\001\022\037\n\033LIVE_VIEWERS_GIFT_BTN_CLICK\020\002\022)\n%LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK\020\003\022#\n\037LIVE_VIEWERS_FIRST_PAY_BTN_SHOW\020\004\022&\n\"LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK\020\005\022-\n)LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK\020\006\022%\n!LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK\020\007\022\033\n\027LIVE_CLASSIFY_BTN_CLICK\020\b\022$\n LIVE_HOME_INTERACTIVE_AREA_CLICK\020\t\022!\n\035LIVE_SETTING_BEAUTY_BTN_CLICK\020\n\022 \n\034LIVE_SETTING_TITLE_BTN_CLICK\020\013\022%\n!LIVE_SETTING_TITLE_SAVE_BTN_CLICK\020\f\022\023\n\017LIVE_FILTER_USE\020\r\022$\n LIVE_VIEWERS_FIRST_PAY_BTN_CLICK\020\016\022\025\n\021LIVE_PAY_BTN_SHOW\020\017\022\026\n\022LIVE_PAY_BTN_CLICK\020\020\022&\n\"LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK\020\022\022 \n\034LIVE_POP_PAY_LAYER_BTN_CLICK\020\024\022'\n#LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW\020\025\022+\n'LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK\020\026\022\"\n\036LIVE_EXIT_GUIDE_EXIT_BTN_CLICK\020\027\022\033\n\027LIVE_RECHARGE_BTN_CLICK\020\030\022\035\n\031LIVE_GIFT_LEVEL_BAR_CLICK\020\031\022\032\n\026HOT_LIVE_H5_LINK_CLICK\020\032\022\035\n\031LIVE_EXPERIENCE_BAR_CLICK\020\033\022\030\n\024LIVE_RANK_TASK_CLICK\020\034\022\035\n\031LIVE_RANK_PRIVILEGE_CLICK\020\035\022\032\n\026LIVE_FEATURE_BOX_CLICK\020\036\022\"\n\036LIVE_FEATURE_BOX_GESTURE_CLICK\020\037\022\"\n\036LIVE_FEATURE_BOX_STICKER_CLICK\020 \022\027\n\023LIVE_TASK_BTN_CLICK\020!\022\031\n\025LIVE_TASK_AWARD_CLICK\020\"\022!\n\035LIVE_END_PAGE_FOLLOW_BTN_SHOW\020'\022\"\n\036LIVE_END_PAGE_FOLLOW_BTN_CLICK\020(\022\025\n\021LIVE_NEW_MSG_SHOW\020)\022\026\n\022LIVE_NEW_MSG_CLICK\020*\022\026\n\022LIVE_HOT_LIST_SHOW\020+\022\027\n\023LIVE_HOT_LIST_CLICK\020,\022 \n\034LIVE_HOT_LIST_GO_GOODS_CLICK\020-\022\027\n\023LIVE_SOAR_LIST_SHOW\020.\022\030\n\024LIVE_SOAR_LIST_CLICK\020/\022!\n\035LIVE_SOAR_LIST_GO_GOODS_CLICK\0200\022\037\n\033LIVE_HOT_SOAR_LIST_QA_CLICK\0201\022%\n!FLASH_VIDEO_USER_LIVE_PHOTO_CLICK\0202\022$\n LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW\0203\022%\n!LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK\0204\022\031\n\025LIVE_WANDOU_NUM_CLICK\0205\022\027\n\023LIVE_REDVERIFY_SHOW\0206\022\032\n\026LIVE_REDVERIFY_CONFIRM\0207\022%\n!LIVE_REDVERIFY_CONFIRM_RED_RESULT\0208\022\"\n\036LIVE_FAVORITE_FIRST_ROOM_CLICK\0209\022\035\n\031LIVE_HOT_FIRST_ROOM_CLICK\020:\022\037\n\033LIVE_HOME_REFRESH_WORD_SHOW\020;\022 \n\034LIVE_HOME_REFRESH_LIVE_ENTER\020<\022\034\n\030RECOMMEND_PAGE_ROOM_SHOW\020=\022\"\n\036RECOMMEND_PAGE_ENTER_BTN_CLICK\020>\022!\n\035RECOMMEND_PAGE_MORE_BTN_CLICK\020?\022\031\n\025LIVE_REPORT_BTN_CLICK\020@\022\027\n\023FANS_CLUB_PAGE_SHOW\020A\022.\n*FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW\020B\022/\n+FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK\020C\022\034\n\030LIVE_FANS_CLUB_BTN_CLICK\020D\022\"\n\036FANS_CLUB_PAGE_EDIT_NAME_CLICK\020E\022*\n&FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK\020F\022\037\n\033FANS_CLUB_PAGE_ACTIVE_CLICK\020G\022\036\n\032FANS_CLUB_PAGE_TODAY_CLICK\020H\022\034\n\030FANS_CLUB_PAGE_ALL_CLICK\020I\022\033\n\027FANS_CLUB_PAGE_QA_CLICK\020J\022)\n%FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK\020K\022(\n$FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK\020L\022&\n\"FANS_CLUB_PAGE_ALL_LIST_USER_CLICK\020M\022$\n FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW\020N\0220\n,FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK\020O\022,\n(FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK\020P\022$\n FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW\020Q\022/\n+FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK\020R\022&\n\"FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW\020S\022!\n\035FANS_CLUB_PAGE_JOIN_PAGE_SHOW\020T\022&\n\"FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK\020U\022\026\n\022FANS_CLUB_MSG_SHOW\020V\022\027\n\023FANS_CLUB_MSG_CLICK\020W\022\036\n\032LIVE_SEND_FANS_CLUB_TICKET\020X\022 \n\034LIVE_HOME_REFRESH_IMAGE_SHOW\020Y\022\036\n\032LIVE_FANS_RENEW_TOAST_SHOW\020Z\022\037\n\033LIVE_FANS_RENEW_TOAST_CLICK\020[\022!\n\035LIVE_TODAY_WELFARE_TOAST_SHOW\020\\\022\"\n\036LIVE_TODAY_WELFARE_TOAST_CLICK\020]\022\036\n\032LIVE_GLOW_STICK_TOAST_SHOW\020^\022\037\n\033LIVE_GLOW_STICK_TOAST_CLICK\020_\022\037\n\033LIVE_APPLY_ANCHOR_PAGE_SHOW\020`\022\026\n\022LIVE_HOT_PAGE_SHOW\020a\022\027\n\023LIVE_SOAR_PAGE_SHOW\020b\022\036\n\032LIVE_RECHARGE_HUABAI_CLICK\020c\022\034\n\030LIVE_RECOMMEND_PAGE_SHOW\020d\022\033\n\027LIVE_STICKERS_PAGE_SHOW\020e\022\036\n\032ANCHOR_SETTING_START_CLICK\020f\022%\n!ANCHOR_SETTING_BLIND_DATING_CLICK\020g\022 \n\034USER_CONTRIBUTION_LIST_CLICK\020h\022\036\n\032ANCHOR_MATCH_SUCCESS_CLICK\020i\022'\n#ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK\020j\022\032\n\026ANCHOR_RENEW_BTN_CLICK\020k\022\030\n\024ANCHOR_FEATURE_CLICK\020l\022\034\n\030ANCHOR_MIKE_MANAGE_CLICK\020m\022&\n\"ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK\020n\022$\n ANCHOR_MIKE_MANAGE_TO_PICK_CLICK\020o\022$\n ANCHOR_MIKE_MANAGE_CONFIRM_CLICK\020p\022#\n\037ANCHOR_MIKE_MANAGE_IGNORE_CLICK\020q\022\030\n\024ANCHOR_END_PAGE_SHOW\020r\022&\n\"ANCHOR_END_PAGE_RECORD_SHARE_CLICK\020s\022-\n)ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK\020t\022!\n\035ANCHOR_END_PAGE_CONFIRM_CLICK\020u\022\034\n\030USER_CONNECT_APPLY_CLICK\020v\022&\n\"USER_CONNECT_APPLY_BE_PICKED_CLICK\020w\022$\n USER_CONNECT_APPLY_TO_PICK_CLICK\020x\022\032\n\026USER_CANCEL_MIKE_CLICK\020y\022\031\n\025USER_START_MIKE_CLICK\020z\022 \n\034USER_ANCHOR_FOLLOW_BTN_CLICK\020{\022\024\n\020USER_SHARE_CLICK\020|\022\035\n\031GUEST_USER_KEYBOARD_CLICK\020}\022\027\n\023USER_RECHARGE_CLICK\020~\022\031\n\025GUEST_USER_GIFT_CLICK\020\022\035\n\030USER_LIVE_GIFT_BTN_CLICK\020\001\022\036\n\031USER_MIKE_USER_PHOTO_SHOW\020\001\022\037\n\032USER_MIKE_USER_PHOTO_CLICK\020\001\022&\n!USER_MIKE_USER_PHOTO_DOUBLE_CLICK\020\001\022$\n\037USER_MIKE_USER_PHOTO_CARD_CLICK\020\001\022%\n USER_CONTRIBUTION_LIST_USER_SHOW\020\001\022&\n!USER_CONTRIBUTION_LIST_USER_CLICK\020\001\022&\n!USER_END_PAGE_RECOMMEND_ROOM_SHOW\020\001\022'\n\"USER_END_PAGE_RECOMMEND_ROOM_CLICK\020\001\022.\n)USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK\020\001\022\030\n\023GUEST_HANG_UP_CLICK\020\001\022\033\n\026GUEST_CLOSE_MIKE_CLICK\020\001\022\032\n\025GUEST_LIGHT_OFF_CLICK\020\001\022\033\n\026GUEST_SHOW_PHOTO_CLICK\020\001\022\027\n\022GUEST_PHOTO_UPLOAD\020\001\022!\n\034GUEST_MATCH_SUCCESS_POP_SHOW\020\001\022)\n$GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK\020\001\022\"\n\035ANCHOR_MATCH_SUCCESS_POP_SHOW\020\001\022)\n$LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW\020\001\022(\n#LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK\020\001\022\037\n\032LIVE_PRE_TOP_CARD_POP_SHOW\020\001\022 \n\033LIVE_PRE_TOP_CARD_GET_CLICK\020\001\022\031\n\024LIVE_TASK_ENTER_SHOW\020\001\022\032\n\025LIVE_TASK_ENTER_CLICK\020\001\022\030\n\023LIVE_TASK_GET_CLICK\020\001\022\036\n\031LIVE_TASK_SEND_GIFT_CLICK\020\001\022\033\n\026LIVE_TASK_FOLLOW_CLICK\020\001\022#\n\036LIVE_TASK_COLLECTION_PAGE_SHOW\020\001\022$\n\037LIVE_TASK_COLLECTION_PAGE_CLICK\020\001\022\034\n\027LIVE_TASK_NEW_KING_SHOW\020\001\022\035\n\030LIVE_TASK_NEW_KING_CLICK\020\001\022\017\n\nLIVE_SLIDE\020\001\022\033\n\026LIVE_MYSTERY_BTN_CLICK\020 \001\022\036\n\031LIVE_MYSTERY_PROFILE_SHOW\020¡\001\022\"\n\035LIVE_MYSTERY_PROFILE_AT_CLICK\020¢\001\022'\n\"LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK\020£\001\022\032\n\025LIVE_ANSWER_WHO_CLICK\020¤\001\022\031\n\024MYSTERY_ASK_WHO_SHOW\020¥\001\022\032\n\025MYSTERY_ASK_WHO_CLICK\020¦\001\022&\n!MYSTERY_ASK_WHO_ANSWER_SEND_CLICK\020§\001\022\035\n\030LIVE_MYSTERY_ANSWER_SHOW\020¨\001\022\036\n\031LIVE_MYSTERY_ANSWER_CLICK\020©\001\022#\n\036LIVE_USER_PROFILE_MANAGE_CLICK\020ª\001\022+\n&LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK\020«\001\022,\n'LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK\020¬\001\022,\n'LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK\020­\001\022$\n\037PK_LIVE_PROFILE_FOLLOW_BTN_SHOW\020®\001\022%\n PK_LIVE_PROFILE_FOLLOW_BTN_CLICK\020¯\001\022\030\n\023LIVE_RECOMMEND_SHOW\020°\001\022\031\n\024LIVE_RECOMMEND_CLICK\020±\001\022\035\n\030LIVE_MUSIC_COLLECT_CLICK\020²\001\022\032\n\025LIVE_MUSIC_PLAY_CLICK\020³\001\022\032\n\025LIVE_MUSIC_STOP_CLICK\020´\001\022\032\n\025LIVE_MUSIC_EXIT_CLICK\020µ\001\022\035\n\030LIVE_MUSIC_TAB_PAGE_SHOW\020¶\001\022\034\n\027LIVE_MUSIC_SEARCH_CLICK\020·\001\022\032\n\025LIVE_MANAGE_BTN_CLICK\020¸\001\022\026\n\021LIVE_CONNECT_TIME\020¹\001\022&\n!LIVE_FOLLOWED_GRID_RECOMMEND_SHOW\020º\001\022'\n\"LIVE_FOLLOWED_GRID_RECOMMEND_CLICK\020»\001\022/\n*LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK\020¼\001\022\026\n\021LIVE_MUSIC_CHANGE\020½\001\022\024\n\017LIVE_MUSIC_DONE\020¾\001\022\033\n\026RED_BAG_SEND_BTN_CLICK\020¿\001\022\030\n\023RED_BAG_GET_SUCCESS\020À\001\022\031\n\024RED_BAG_GET_POP_SHOW\020Á\001\022\"\n\035RED_BAG_GET_POP_CONFIRM_CLICK\020Â\001\022!\n\034RED_BAG_GET_POP_CANCEL_CLICK\020Ã\001\022\023\n\016LIVE_ROOM_SHOW\020Ä\001\022\035\n\030LIVE_FIRST_LIKE_MSG_SEND\020Å\001\022\034\n\027LIVE_FOLLOW_GUIDE_CLICK\020Æ\001\022\021\n\fLIVE_PREPARE\020Ç\001\022\021\n\fLIVE_LOADING\020È\001\022\023\n\016LIVE_INTERRUPT\020É\001\022\027\n\022LIVE_APPLY_PREPARE\020Ê\001\022\035\n\030LIVE_ACTIVITY_LINK_CLICK\020Ë\001\022\035\n\030LIVE_START_FROM_LIVELIST\020Ì\001\022\023\n\016LIVE_GIFT_PAGE\020Í\001\022\032\n\025LIVE_START_SHARE_FEED\020Î\001\022\024\n\017LIVE_ROOM_CLICK\020Ï\001\022\035\n\030LIVE_GIFT_PAGE_GIFT_SHOW\020Ð\001\022\036\n\031LIVE_GIFT_PAGE_GIFT_CLICK\020Ñ\001\022\036\n\031LIVE_GIFT_PAGE_SEND_CLICK\020Ò\001\022\027\n\022BETTER_ID_POP_SHOW\020Ó\001\022\036\n\031BETTER_ID_POP_CLOSE_CLICK\020Ô\001\022\035\n\030BETTER_ID_POP_LOOK_CLICK\020Õ\001\022\037\n\032BETTER_ID_POP_CHOOSE_CLICK\020Ö\001\022&\n!BETTER_ID_MY_PROFILE_BATTER_CLICK\020×\001\022)\n$BETTER_ID_OTHER_PROFILE_BATTER_CLICK\020Ø\001\022&\n!BETTER_ID_ANCHOR_POP_BATTER_CLICK\020Ù\001\022(\n#BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK\020Ú\001\022$\n\037BETTER_ID_USER_POP_BATTER_CLICK\020Û\001\022&\n!BETTER_ID_USER_PHOTO_BATTER_CLICK\020Ü\001\022\"\n\035USER_PROFILE_FOLLOW_BTN_CLICK\020Ý\001\022\027\n\022LIVE_USER_MSG_SEND\020Þ\001\022 \n\033LIVE_ACTIVITY_RESOURCE_SHOW\020ß\001\022!\n\034LIVE_ACTIVITY_RESOURCE_CLICK\020à\001\022\027\n\022LIVE_ENTER_SUCCESS\020á\001\022\027\n\022LIVE_LEAVE_SUCCESS\020â\001\022/\n*BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK\020ã\001\022.\n)BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK\020ä\001\022.\n)BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK\020å\001\022*\n%BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK\020æ\001\022*\n%BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK\020ç\001\022\027\n\022LIVE_KISS_POP_SHOW\020è\001\022\030\n\023LIVE_KISS_BTN_CLICK\020é\001\022%\n LIVE_KISS_PURCHASE_COMPLETE_SHOW\020ê\001\022\033\n\026LIVE_KISS_RETURN_CLICK\020ë\001\022 \n\033LIVE_KISS_INSUFFICIENT_SHOW\020ì\001\022%\n LIVE_KISS_SURROUNDING_AREA_CLICK\020í\001\022 \n\033LIVE_KISS_AUTO_RETURN_CLICK\020î\001\022\036\n\031LIVE_PK_AUDIENCE_DURATION\020ï\001\022 \n\033LIVE_PK_AUDIENCE_SEAT_CLICK\020ð\001\022\027\n\022LIVE_PK_ICON_CLICK\020ñ\001\022\027\n\022LIVE_PK_RANK_CLICK\020ò\001*^\n\nGiftStatus\022\026\n\022UNKNOWN_BTN_STATUS\020\000\022\022\n\016NOT_PAY_REMAIN\020\001\022\024\n\020NOT_PAY_SELL_OUT\020\002\022\016\n\nPAY_REMAIN\020\003*C\n\tEnterType\022\026\n\022UNKNOWN_ENTER_TYPE\020\000\022\n\n\006FRIEND\020\001\022\006\n\002PK\020\002\022\n\n\006COMMON\020\003*G\n\006Status\022\022\n\016UNKNOWN_STATUS\020\000\022\t\n\005START\020\001\022\007\n\003END\020\002\022\n\n\006WEEKLY\020\003\022\t\n\005DAILY\020\004*D\n\016FirstPayStatus\022\034\n\030UNKNOWN_FIRST_PAY_STATUS\020\000\022\013\n\007RECEIVE\020\001\022\007\n\003PAY\020\002*\001\n\tPayStatus\022\026\n\022UNKNOWN_PAY_STATUS\020\000\022\031\n\025NOT_PAY_REMAIN_STATUS\020\001\022\025\n\021PAY_REMAIN_STATUS\020\002\022\033\n\027NOT_PAY_SELL_OUT_STATUS\020\003\022\027\n\023PAY_SELL_OUT_STATUS\020\004*É\001\n\007BoxType\022\024\n\020UNKNOWN_BOX_TYPE\020\000\022\021\n\rMAGIC_GESTURE\020\001\022\026\n\022DECORATIVE_STICKER\020\002\022\r\n\tSHOP_MALL\020\003\022\022\n\016BEAUTY_FEATURE\020\004\022\022\n\016CAMERA_FEATURE\020\005\022\022\n\016MIRROR_FEATURE\020\006\022\021\n\rTITLE_FEATURE\020\007\022\024\n\020TOP_CARD_FEATURE\020\b\022\t\n\005MUSIC\020\t*v\n\bTaskType\022\025\n\021UNKNOWN_TASK_TYPE\020\000\022\017\n\013LOGIN_DAILY\020\001\022\r\n\tWATCH_15M\020\002\022\016\n\nSEND_3_MSG\020\003\022\020\n\fRECHARGE_ANY\020\004\022\021\n\rSEND_ANY_GIFT\020\005*n\n\tAwardType\022\026\n\022UNKNOWN_AWARD_TYPE\020\000\022\n\n\006WANDOU\020\001\022\016\n\nEXPERIENCE\020\002\022\007\n\003RED\020\003\022\025\n\021EXPERIENCE_DOUBLE\020\004\022\r\n\tBLUED_BOX\020\005*Ù\001\n\fFollowStatus\022\031\n\025UNKNOWN_FOLLOW_STATUS\020\000\022\r\n\tTO_FOLLOW\020\001\022\020\n\fFOLLOWED_HIM\020\002\022\r\n\tFOLLOW_ME\020\003\022\021\n\rFOLLOWED_EACH\020\004\022\020\n\fFOLLOW_BLACK\020\005\022\024\n\020TO_FOLLOW_STATUS\020\006\022\023\n\017FOLLOWED_STATUS\020\007\022\026\n\022EACH_FOLLOW_STATUS\020\b\022\026\n\022BE_FOLLOWED_STATUS\020\t*\001\n\007BtnType\022\024\n\020UNKNOWN_BTN_TYPE\020\000\022\017\n\013SEND_WANDOU\020\001\022\r\n\tLOOK_LIVE\020\002\022\023\n\017SEND_GLOW_STICK\020\003\022\016\n\nSHARE_LIVE\020\004\022\022\n\016SEND_CLUB_GIFT\020\005\022\022\n\016GET_GLOW_STICK\020\006*?\n\006Source\022\022\n\016UNKNOWN_SOURCE\020\000\022\022\n\016FANS_CLUB_PAGE\020\001\022\r\n\tGIFT_PAGE\020\002*G\n\bLiveType\022\025\n\021UNKNOWN_LIVE_TYPE\020\000\022\025\n\021BLIND_DATING_LIVE\020\001\022\r\n\tSHOW_LIVE\020\002*J\n\bCardFrom\022\025\n\021UNKNOWN_CARD_FROM\020\000\022\021\n\rMSG_PREP_PAGE\020\001\022\024\n\020DIRECT_PREP_PAGE\020\002B\007¢\002\004LIVEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_live_LiveProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_live_LiveProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_live_LiveProto_descriptor, new String[] { 
        "Event", "GiftStatus", "EnterType", "Status", "FilterId", "IsAuto", "FirstPayStatus", "PayStatus", "LiveId", "Url", 
        "TargetUid", "FeatureId", "BoxType", "TaskType", "AwardType", "Count", "FollowStatus", "IsSuccess", "LiveTypeId", "IsJoin", 
        "BtnType", "Source", "TaskId", "LiveType", "BeansCount", "BeansNum", "ViewCount", "LikeCount", "OnlineCount", "LiveDuration", 
        "GoodsId", "Num", "GuestUid", "RecommendLiveId", "RecommendUid", "IsQueue", "CardFrom", "IsOpen", "LiveFrom", "IsMystery", 
        "MysteryUid", "MusicId", "TabId", "Password", "Condition", "LiveTab", "Position", "TabNum", "PageNum", "Id", 
        "LiveFromNum", "FollowedUid", "RecommendType", "From", "IsHitTime", "IsPk" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum AwardType implements ProtocolMessageEnum {
    BLUED_BOX,
    EXPERIENCE,
    EXPERIENCE_DOUBLE,
    RED,
    UNKNOWN_AWARD_TYPE(0),
    UNRECOGNIZED(0),
    WANDOU(1);
    
    public static final int BLUED_BOX_VALUE = 5;
    
    public static final int EXPERIENCE_DOUBLE_VALUE = 4;
    
    public static final int EXPERIENCE_VALUE = 2;
    
    public static final int RED_VALUE = 3;
    
    public static final int UNKNOWN_AWARD_TYPE_VALUE = 0;
    
    private static final AwardType[] VALUES;
    
    public static final int WANDOU_VALUE = 1;
    
    private static final Internal.EnumLiteMap<AwardType> internalValueMap;
    
    private final int value;
    
    static {
      EXPERIENCE_DOUBLE = new AwardType("EXPERIENCE_DOUBLE", 4, 4);
      BLUED_BOX = new AwardType("BLUED_BOX", 5, 5);
      UNRECOGNIZED = new AwardType("UNRECOGNIZED", 6, -1);
      $VALUES = new AwardType[] { UNKNOWN_AWARD_TYPE, WANDOU, EXPERIENCE, RED, EXPERIENCE_DOUBLE, BLUED_BOX, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<AwardType>() {
          public LiveProtos.AwardType findValueByNumber(int param2Int) {
            return LiveProtos.AwardType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    AwardType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AwardType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : BLUED_BOX) : EXPERIENCE_DOUBLE) : RED) : EXPERIENCE) : WANDOU) : UNKNOWN_AWARD_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(8);
    }
    
    public static Internal.EnumLiteMap<AwardType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<AwardType> {
    public LiveProtos.AwardType findValueByNumber(int param1Int) {
      return LiveProtos.AwardType.forNumber(param1Int);
    }
  }
  
  public enum BoxType implements ProtocolMessageEnum {
    UNKNOWN_BOX_TYPE(0),
    UNRECOGNIZED(0),
    BEAUTY_FEATURE(1),
    CAMERA_FEATURE(1),
    DECORATIVE_STICKER(1),
    MAGIC_GESTURE(1),
    MIRROR_FEATURE(1),
    MUSIC(1),
    SHOP_MALL(1),
    TITLE_FEATURE(1),
    TOP_CARD_FEATURE(1);
    
    public static final int BEAUTY_FEATURE_VALUE = 4;
    
    public static final int CAMERA_FEATURE_VALUE = 5;
    
    public static final int DECORATIVE_STICKER_VALUE = 2;
    
    public static final int MAGIC_GESTURE_VALUE = 1;
    
    public static final int MIRROR_FEATURE_VALUE = 6;
    
    public static final int MUSIC_VALUE = 9;
    
    public static final int SHOP_MALL_VALUE = 3;
    
    public static final int TITLE_FEATURE_VALUE = 7;
    
    public static final int TOP_CARD_FEATURE_VALUE = 8;
    
    public static final int UNKNOWN_BOX_TYPE_VALUE = 0;
    
    private static final BoxType[] VALUES;
    
    private static final Internal.EnumLiteMap<BoxType> internalValueMap;
    
    private final int value;
    
    static {
      DECORATIVE_STICKER = new BoxType("DECORATIVE_STICKER", 2, 2);
      SHOP_MALL = new BoxType("SHOP_MALL", 3, 3);
      BEAUTY_FEATURE = new BoxType("BEAUTY_FEATURE", 4, 4);
      CAMERA_FEATURE = new BoxType("CAMERA_FEATURE", 5, 5);
      MIRROR_FEATURE = new BoxType("MIRROR_FEATURE", 6, 6);
      TITLE_FEATURE = new BoxType("TITLE_FEATURE", 7, 7);
      TOP_CARD_FEATURE = new BoxType("TOP_CARD_FEATURE", 8, 8);
      MUSIC = new BoxType("MUSIC", 9, 9);
      UNRECOGNIZED = new BoxType("UNRECOGNIZED", 10, -1);
      $VALUES = new BoxType[] { 
          UNKNOWN_BOX_TYPE, MAGIC_GESTURE, DECORATIVE_STICKER, SHOP_MALL, BEAUTY_FEATURE, CAMERA_FEATURE, MIRROR_FEATURE, TITLE_FEATURE, TOP_CARD_FEATURE, MUSIC, 
          UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<BoxType>() {
          public LiveProtos.BoxType findValueByNumber(int param2Int) {
            return LiveProtos.BoxType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    BoxType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static BoxType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 9:
          return MUSIC;
        case 8:
          return TOP_CARD_FEATURE;
        case 7:
          return TITLE_FEATURE;
        case 6:
          return MIRROR_FEATURE;
        case 5:
          return CAMERA_FEATURE;
        case 4:
          return BEAUTY_FEATURE;
        case 3:
          return SHOP_MALL;
        case 2:
          return DECORATIVE_STICKER;
        case 1:
          return MAGIC_GESTURE;
        case 0:
          break;
      } 
      return UNKNOWN_BOX_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(6);
    }
    
    public static Internal.EnumLiteMap<BoxType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<BoxType> {
    public LiveProtos.BoxType findValueByNumber(int param1Int) {
      return LiveProtos.BoxType.forNumber(param1Int);
    }
  }
  
  public enum BtnType implements ProtocolMessageEnum {
    GET_GLOW_STICK(0),
    LOOK_LIVE(0),
    SEND_CLUB_GIFT(0),
    SEND_GLOW_STICK(0),
    SEND_WANDOU(0),
    SHARE_LIVE(0),
    UNKNOWN_BTN_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int GET_GLOW_STICK_VALUE = 6;
    
    public static final int LOOK_LIVE_VALUE = 2;
    
    public static final int SEND_CLUB_GIFT_VALUE = 5;
    
    public static final int SEND_GLOW_STICK_VALUE = 3;
    
    public static final int SEND_WANDOU_VALUE = 1;
    
    public static final int SHARE_LIVE_VALUE = 4;
    
    public static final int UNKNOWN_BTN_TYPE_VALUE = 0;
    
    private static final BtnType[] VALUES;
    
    private static final Internal.EnumLiteMap<BtnType> internalValueMap;
    
    private final int value;
    
    static {
      LOOK_LIVE = new BtnType("LOOK_LIVE", 2, 2);
      SEND_GLOW_STICK = new BtnType("SEND_GLOW_STICK", 3, 3);
      SHARE_LIVE = new BtnType("SHARE_LIVE", 4, 4);
      SEND_CLUB_GIFT = new BtnType("SEND_CLUB_GIFT", 5, 5);
      GET_GLOW_STICK = new BtnType("GET_GLOW_STICK", 6, 6);
      UNRECOGNIZED = new BtnType("UNRECOGNIZED", 7, -1);
      $VALUES = new BtnType[] { UNKNOWN_BTN_TYPE, SEND_WANDOU, LOOK_LIVE, SEND_GLOW_STICK, SHARE_LIVE, SEND_CLUB_GIFT, GET_GLOW_STICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<BtnType>() {
          public LiveProtos.BtnType findValueByNumber(int param2Int) {
            return LiveProtos.BtnType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    BtnType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static BtnType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return GET_GLOW_STICK;
        case 5:
          return SEND_CLUB_GIFT;
        case 4:
          return SHARE_LIVE;
        case 3:
          return SEND_GLOW_STICK;
        case 2:
          return LOOK_LIVE;
        case 1:
          return SEND_WANDOU;
        case 0:
          break;
      } 
      return UNKNOWN_BTN_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(10);
    }
    
    public static Internal.EnumLiteMap<BtnType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<BtnType> {
    public LiveProtos.BtnType findValueByNumber(int param1Int) {
      return LiveProtos.BtnType.forNumber(param1Int);
    }
  }
  
  public enum CardFrom implements ProtocolMessageEnum {
    DIRECT_PREP_PAGE(0),
    MSG_PREP_PAGE(0),
    UNKNOWN_CARD_FROM(0),
    UNRECOGNIZED(0);
    
    public static final int DIRECT_PREP_PAGE_VALUE = 2;
    
    public static final int MSG_PREP_PAGE_VALUE = 1;
    
    public static final int UNKNOWN_CARD_FROM_VALUE = 0;
    
    private static final CardFrom[] VALUES;
    
    private static final Internal.EnumLiteMap<CardFrom> internalValueMap;
    
    private final int value;
    
    static {
      DIRECT_PREP_PAGE = new CardFrom("DIRECT_PREP_PAGE", 2, 2);
      UNRECOGNIZED = new CardFrom("UNRECOGNIZED", 3, -1);
      $VALUES = new CardFrom[] { UNKNOWN_CARD_FROM, MSG_PREP_PAGE, DIRECT_PREP_PAGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<CardFrom>() {
          public LiveProtos.CardFrom findValueByNumber(int param2Int) {
            return LiveProtos.CardFrom.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    CardFrom(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static CardFrom forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : DIRECT_PREP_PAGE) : MSG_PREP_PAGE) : UNKNOWN_CARD_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(13);
    }
    
    public static Internal.EnumLiteMap<CardFrom> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<CardFrom> {
    public LiveProtos.CardFrom findValueByNumber(int param1Int) {
      return LiveProtos.CardFrom.forNumber(param1Int);
    }
  }
  
  public enum EnterType implements ProtocolMessageEnum {
    COMMON(0),
    FRIEND(0),
    PK(0),
    UNKNOWN_ENTER_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int COMMON_VALUE = 3;
    
    public static final int FRIEND_VALUE = 1;
    
    public static final int PK_VALUE = 2;
    
    public static final int UNKNOWN_ENTER_TYPE_VALUE = 0;
    
    private static final EnterType[] VALUES;
    
    private static final Internal.EnumLiteMap<EnterType> internalValueMap;
    
    private final int value;
    
    static {
      COMMON = new EnterType("COMMON", 3, 3);
      UNRECOGNIZED = new EnterType("UNRECOGNIZED", 4, -1);
      $VALUES = new EnterType[] { UNKNOWN_ENTER_TYPE, FRIEND, PK, COMMON, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<EnterType>() {
          public LiveProtos.EnterType findValueByNumber(int param2Int) {
            return LiveProtos.EnterType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    EnterType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static EnterType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : COMMON) : PK) : FRIEND) : UNKNOWN_ENTER_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<EnterType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<EnterType> {
    public LiveProtos.EnterType findValueByNumber(int param1Int) {
      return LiveProtos.EnterType.forNumber(param1Int);
    }
  }
  
  public enum Event implements ProtocolMessageEnum {
    ANCHOR_END_PAGE_CONFIRM_CLICK(0),
    ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK(0),
    ANCHOR_END_PAGE_RECORD_SHARE_CLICK(0),
    ANCHOR_END_PAGE_SHOW(0),
    ANCHOR_FEATURE_CLICK(0),
    ANCHOR_MATCH_SUCCESS_CLICK(0),
    ANCHOR_MATCH_SUCCESS_POP_SHOW(0),
    ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK(0),
    ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK(0),
    ANCHOR_MIKE_MANAGE_CLICK(0),
    ANCHOR_MIKE_MANAGE_CONFIRM_CLICK(0),
    ANCHOR_MIKE_MANAGE_IGNORE_CLICK(0),
    ANCHOR_MIKE_MANAGE_TO_PICK_CLICK(0),
    ANCHOR_RENEW_BTN_CLICK(0),
    ANCHOR_SETTING_BLIND_DATING_CLICK(0),
    ANCHOR_SETTING_START_CLICK(0),
    BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK(0),
    BETTER_ID_ANCHOR_POP_BATTER_CLICK(0),
    BETTER_ID_MY_PROFILE_BATTER_CLICK(0),
    BETTER_ID_OTHER_PROFILE_BATTER_CLICK(0),
    BETTER_ID_POP_CHOOSE_CLICK(0),
    BETTER_ID_POP_CLOSE_CLICK(0),
    BETTER_ID_POP_LOOK_CLICK(0),
    BETTER_ID_POP_SHOW(0),
    BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK(0),
    BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK(0),
    BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK(0),
    BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK(0),
    BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK(0),
    BETTER_ID_USER_PHOTO_BATTER_CLICK(0),
    BETTER_ID_USER_POP_BATTER_CLICK(0),
    FANS_CLUB_MSG_CLICK(0),
    FANS_CLUB_MSG_SHOW(0),
    FANS_CLUB_PAGE_ACTIVE_CLICK(0),
    FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK(0),
    FANS_CLUB_PAGE_ALL_CLICK(0),
    FANS_CLUB_PAGE_ALL_LIST_USER_CLICK(0),
    FANS_CLUB_PAGE_EDIT_NAME_CLICK(0),
    FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK(0),
    FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW(0),
    FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK(0),
    FANS_CLUB_PAGE_JOIN_PAGE_SHOW(0),
    FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK(0),
    FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW(0),
    FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK(0),
    FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK(0),
    FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW(0),
    FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK(0),
    FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW(0),
    FANS_CLUB_PAGE_QA_CLICK(0),
    FANS_CLUB_PAGE_SHOW(0),
    FANS_CLUB_PAGE_TODAY_CLICK(0),
    FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK(0),
    FLASH_VIDEO_USER_LIVE_PHOTO_CLICK(0),
    GUEST_CLOSE_MIKE_CLICK(0),
    GUEST_HANG_UP_CLICK(0),
    GUEST_LIGHT_OFF_CLICK(0),
    GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK(0),
    GUEST_MATCH_SUCCESS_POP_SHOW(0),
    GUEST_PHOTO_UPLOAD(0),
    GUEST_SHOW_PHOTO_CLICK(0),
    GUEST_USER_GIFT_CLICK(0),
    GUEST_USER_KEYBOARD_CLICK(0),
    HOT_LIVE_H5_LINK_CLICK(0),
    LIVE_ACTIVITY_LINK_CLICK(0),
    LIVE_ACTIVITY_RESOURCE_CLICK(0),
    LIVE_ACTIVITY_RESOURCE_SHOW(0),
    LIVE_ANSWER_WHO_CLICK(0),
    LIVE_APPLY_ANCHOR_PAGE_SHOW(0),
    LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK(0),
    LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK(0),
    LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK(0),
    LIVE_APPLY_PREPARE(0),
    LIVE_CLASSIFY_BTN_CLICK(0),
    LIVE_CONNECT_TIME(0),
    LIVE_END_PAGE_FOLLOW_BTN_CLICK(0),
    LIVE_END_PAGE_FOLLOW_BTN_SHOW(0),
    LIVE_ENTER_SUCCESS(0),
    LIVE_EXIT_GUIDE_EXIT_BTN_CLICK(0),
    LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK(0),
    LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW(0),
    LIVE_EXPERIENCE_BAR_CLICK(0),
    LIVE_FANS_CLUB_BTN_CLICK(0),
    LIVE_FANS_RENEW_TOAST_CLICK(0),
    LIVE_FANS_RENEW_TOAST_SHOW(0),
    LIVE_FAVORITE_FIRST_ROOM_CLICK(0),
    LIVE_FEATURE_BOX_CLICK(0),
    LIVE_FEATURE_BOX_GESTURE_CLICK(0),
    LIVE_FEATURE_BOX_STICKER_CLICK(0),
    LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW(0),
    LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK(0),
    LIVE_FILTER_USE(0),
    LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK(0),
    LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW(0),
    LIVE_FIRST_LIKE_MSG_SEND(0),
    LIVE_FOLLOWED_GRID_RECOMMEND_CLICK(0),
    LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK(0),
    LIVE_FOLLOWED_GRID_RECOMMEND_SHOW(0),
    LIVE_FOLLOW_GUIDE_CLICK(0),
    LIVE_GIFT_LEVEL_BAR_CLICK(0),
    LIVE_GIFT_PAGE(0),
    LIVE_GIFT_PAGE_GIFT_CLICK(0),
    LIVE_GIFT_PAGE_GIFT_SHOW(0),
    LIVE_GIFT_PAGE_SEND_CLICK(0),
    LIVE_GLOW_STICK_TOAST_CLICK(0),
    LIVE_GLOW_STICK_TOAST_SHOW(0),
    LIVE_HOME_INTERACTIVE_AREA_CLICK(0),
    LIVE_HOME_REFRESH_IMAGE_SHOW(0),
    LIVE_HOME_REFRESH_LIVE_ENTER(0),
    LIVE_HOME_REFRESH_WORD_SHOW(0),
    LIVE_HOT_FIRST_ROOM_CLICK(0),
    LIVE_HOT_LIST_CLICK(0),
    LIVE_HOT_LIST_GO_GOODS_CLICK(0),
    LIVE_HOT_LIST_SHOW(0),
    LIVE_HOT_PAGE_SHOW(0),
    LIVE_HOT_SOAR_LIST_QA_CLICK(0),
    LIVE_INTERRUPT(0),
    LIVE_KISS_AUTO_RETURN_CLICK(0),
    LIVE_KISS_BTN_CLICK(0),
    LIVE_KISS_INSUFFICIENT_SHOW(0),
    LIVE_KISS_POP_SHOW(0),
    LIVE_KISS_PURCHASE_COMPLETE_SHOW(0),
    LIVE_KISS_RETURN_CLICK(0),
    LIVE_KISS_SURROUNDING_AREA_CLICK(0),
    LIVE_LEAVE_SUCCESS(0),
    LIVE_LOADING(0),
    LIVE_MANAGE_BTN_CLICK(0),
    LIVE_MUSIC_CHANGE(0),
    LIVE_MUSIC_COLLECT_CLICK(0),
    LIVE_MUSIC_DONE(0),
    LIVE_MUSIC_EXIT_CLICK(0),
    LIVE_MUSIC_PLAY_CLICK(0),
    LIVE_MUSIC_SEARCH_CLICK(0),
    LIVE_MUSIC_STOP_CLICK(0),
    LIVE_MUSIC_TAB_PAGE_SHOW(0),
    LIVE_MYSTERY_ANSWER_CLICK(0),
    LIVE_MYSTERY_ANSWER_SHOW(0),
    LIVE_MYSTERY_BTN_CLICK(0),
    LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK(0),
    LIVE_MYSTERY_PROFILE_AT_CLICK(0),
    LIVE_MYSTERY_PROFILE_SHOW(0),
    LIVE_NEW_MSG_CLICK(0),
    LIVE_NEW_MSG_SHOW(0),
    LIVE_PAY_BTN_CLICK(0),
    LIVE_PAY_BTN_SHOW(0),
    LIVE_PK_AUDIENCE_DURATION(0),
    LIVE_PK_AUDIENCE_SEAT_CLICK(0),
    LIVE_PK_ICON_CLICK(0),
    LIVE_PK_RANK_CLICK(0),
    LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK(0),
    LIVE_POP_PAY_LAYER_BTN_CLICK(0),
    LIVE_PREPARE(0),
    LIVE_PRE_TOP_CARD_GET_CLICK(0),
    LIVE_PRE_TOP_CARD_POP_SHOW(0),
    LIVE_RANK_PRIVILEGE_CLICK(0),
    LIVE_RANK_TASK_CLICK(0),
    LIVE_RECHARGE_BTN_CLICK(0),
    LIVE_RECHARGE_HUABAI_CLICK(0),
    LIVE_RECOMMEND_CLICK(0),
    LIVE_RECOMMEND_PAGE_SHOW(0),
    LIVE_RECOMMEND_SHOW(0),
    LIVE_REDVERIFY_CONFIRM(0),
    LIVE_REDVERIFY_CONFIRM_RED_RESULT(0),
    LIVE_REDVERIFY_SHOW(0),
    LIVE_REPORT_BTN_CLICK(0),
    LIVE_ROOM_CLICK(0),
    LIVE_ROOM_SHOW(0),
    LIVE_SEND_FANS_CLUB_TICKET(0),
    LIVE_SETTING_BEAUTY_BTN_CLICK(0),
    LIVE_SETTING_TITLE_BTN_CLICK(0),
    LIVE_SETTING_TITLE_SAVE_BTN_CLICK(0),
    LIVE_SLIDE(0),
    LIVE_SOAR_LIST_CLICK(0),
    LIVE_SOAR_LIST_GO_GOODS_CLICK(0),
    LIVE_SOAR_LIST_SHOW(0),
    LIVE_SOAR_PAGE_SHOW(0),
    LIVE_START_FROM_LIVELIST(0),
    LIVE_START_SHARE_FEED(0),
    LIVE_STICKERS_PAGE_SHOW(0),
    LIVE_TASK_AWARD_CLICK(0),
    LIVE_TASK_BTN_CLICK(0),
    LIVE_TASK_COLLECTION_PAGE_CLICK(0),
    LIVE_TASK_COLLECTION_PAGE_SHOW(0),
    LIVE_TASK_ENTER_CLICK(0),
    LIVE_TASK_ENTER_SHOW(0),
    LIVE_TASK_FOLLOW_CLICK(0),
    LIVE_TASK_GET_CLICK(0),
    LIVE_TASK_NEW_KING_CLICK(0),
    LIVE_TASK_NEW_KING_SHOW(0),
    LIVE_TASK_SEND_GIFT_CLICK(0),
    LIVE_TODAY_WELFARE_TOAST_CLICK(0),
    LIVE_TODAY_WELFARE_TOAST_SHOW(0),
    LIVE_USER_MSG_SEND(0),
    LIVE_USER_PROFILE_MANAGE_CLICK(0),
    LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK(0),
    LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK(0),
    LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK(0),
    LIVE_VIEWERS_FIRST_PAY_BTN_CLICK(0),
    LIVE_VIEWERS_FIRST_PAY_BTN_SHOW(0),
    LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK(0),
    LIVE_VIEWERS_GIFT_BTN_CLICK(0),
    LIVE_WANDOU_NUM_CLICK(0),
    MYSTERY_ASK_WHO_ANSWER_SEND_CLICK(0),
    MYSTERY_ASK_WHO_CLICK(0),
    MYSTERY_ASK_WHO_SHOW(0),
    PK_LIVE_PROFILE_FOLLOW_BTN_CLICK(0),
    PK_LIVE_PROFILE_FOLLOW_BTN_SHOW(0),
    RECOMMEND_PAGE_ENTER_BTN_CLICK(0),
    RECOMMEND_PAGE_MORE_BTN_CLICK(0),
    RECOMMEND_PAGE_ROOM_SHOW(0),
    RED_BAG_GET_POP_CANCEL_CLICK(0),
    RED_BAG_GET_POP_CONFIRM_CLICK(0),
    RED_BAG_GET_POP_SHOW(0),
    RED_BAG_GET_SUCCESS(0),
    RED_BAG_SEND_BTN_CLICK(0),
    START_LIVE_BEAUTY_BTN_CLICK(0),
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0),
    USER_ANCHOR_FOLLOW_BTN_CLICK(0),
    USER_CANCEL_MIKE_CLICK(0),
    USER_CONNECT_APPLY_BE_PICKED_CLICK(0),
    USER_CONNECT_APPLY_CLICK(0),
    USER_CONNECT_APPLY_TO_PICK_CLICK(0),
    USER_CONTRIBUTION_LIST_CLICK(0),
    USER_CONTRIBUTION_LIST_USER_CLICK(0),
    USER_CONTRIBUTION_LIST_USER_SHOW(0),
    USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK(0),
    USER_END_PAGE_RECOMMEND_ROOM_CLICK(0),
    USER_END_PAGE_RECOMMEND_ROOM_SHOW(0),
    USER_LIVE_GIFT_BTN_CLICK(0),
    USER_MIKE_USER_PHOTO_CARD_CLICK(0),
    USER_MIKE_USER_PHOTO_CLICK(0),
    USER_MIKE_USER_PHOTO_DOUBLE_CLICK(0),
    USER_MIKE_USER_PHOTO_SHOW(0),
    USER_PROFILE_FOLLOW_BTN_CLICK(0),
    USER_RECHARGE_CLICK(0),
    USER_SHARE_CLICK(0),
    USER_START_MIKE_CLICK(0);
    
    public static final int ANCHOR_END_PAGE_CONFIRM_CLICK_VALUE = 117;
    
    public static final int ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK_VALUE = 116;
    
    public static final int ANCHOR_END_PAGE_RECORD_SHARE_CLICK_VALUE = 115;
    
    public static final int ANCHOR_END_PAGE_SHOW_VALUE = 114;
    
    public static final int ANCHOR_FEATURE_CLICK_VALUE = 108;
    
    public static final int ANCHOR_MATCH_SUCCESS_CLICK_VALUE = 105;
    
    public static final int ANCHOR_MATCH_SUCCESS_POP_SHOW_VALUE = 145;
    
    public static final int ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK_VALUE = 106;
    
    public static final int ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK_VALUE = 110;
    
    public static final int ANCHOR_MIKE_MANAGE_CLICK_VALUE = 109;
    
    public static final int ANCHOR_MIKE_MANAGE_CONFIRM_CLICK_VALUE = 112;
    
    public static final int ANCHOR_MIKE_MANAGE_IGNORE_CLICK_VALUE = 113;
    
    public static final int ANCHOR_MIKE_MANAGE_TO_PICK_CLICK_VALUE = 111;
    
    public static final int ANCHOR_RENEW_BTN_CLICK_VALUE = 107;
    
    public static final int ANCHOR_SETTING_BLIND_DATING_CLICK_VALUE = 103;
    
    public static final int ANCHOR_SETTING_START_CLICK_VALUE = 102;
    
    public static final int BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK_VALUE = 218;
    
    public static final int BETTER_ID_ANCHOR_POP_BATTER_CLICK_VALUE = 217;
    
    public static final int BETTER_ID_MY_PROFILE_BATTER_CLICK_VALUE = 215;
    
    public static final int BETTER_ID_OTHER_PROFILE_BATTER_CLICK_VALUE = 216;
    
    public static final int BETTER_ID_POP_CHOOSE_CLICK_VALUE = 214;
    
    public static final int BETTER_ID_POP_CLOSE_CLICK_VALUE = 212;
    
    public static final int BETTER_ID_POP_LOOK_CLICK_VALUE = 213;
    
    public static final int BETTER_ID_POP_SHOW_VALUE = 211;
    
    public static final int BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK_VALUE = 228;
    
    public static final int BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK_VALUE = 227;
    
    public static final int BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK_VALUE = 230;
    
    public static final int BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK_VALUE = 229;
    
    public static final int BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK_VALUE = 231;
    
    public static final int BETTER_ID_USER_PHOTO_BATTER_CLICK_VALUE = 220;
    
    public static final int BETTER_ID_USER_POP_BATTER_CLICK_VALUE = 219;
    
    public static final int FANS_CLUB_MSG_CLICK_VALUE = 87;
    
    public static final int FANS_CLUB_MSG_SHOW_VALUE = 86;
    
    public static final int FANS_CLUB_PAGE_ACTIVE_CLICK_VALUE = 71;
    
    public static final int FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK_VALUE = 75;
    
    public static final int FANS_CLUB_PAGE_ALL_CLICK_VALUE = 73;
    
    public static final int FANS_CLUB_PAGE_ALL_LIST_USER_CLICK_VALUE = 77;
    
    public static final int FANS_CLUB_PAGE_EDIT_NAME_CLICK_VALUE = 69;
    
    public static final int FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK_VALUE = 70;
    
    public static final int FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW_VALUE = 83;
    
    public static final int FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK_VALUE = 85;
    
    public static final int FANS_CLUB_PAGE_JOIN_PAGE_SHOW_VALUE = 84;
    
    public static final int FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK_VALUE = 79;
    
    public static final int FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW_VALUE = 78;
    
    public static final int FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK_VALUE = 80;
    
    public static final int FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK_VALUE = 82;
    
    public static final int FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW_VALUE = 81;
    
    public static final int FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK_VALUE = 67;
    
    public static final int FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW_VALUE = 66;
    
    public static final int FANS_CLUB_PAGE_QA_CLICK_VALUE = 74;
    
    public static final int FANS_CLUB_PAGE_SHOW_VALUE = 65;
    
    public static final int FANS_CLUB_PAGE_TODAY_CLICK_VALUE = 72;
    
    public static final int FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK_VALUE = 76;
    
    public static final int FLASH_VIDEO_USER_LIVE_PHOTO_CLICK_VALUE = 50;
    
    public static final int GUEST_CLOSE_MIKE_CLICK_VALUE = 139;
    
    public static final int GUEST_HANG_UP_CLICK_VALUE = 138;
    
    public static final int GUEST_LIGHT_OFF_CLICK_VALUE = 140;
    
    public static final int GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK_VALUE = 144;
    
    public static final int GUEST_MATCH_SUCCESS_POP_SHOW_VALUE = 143;
    
    public static final int GUEST_PHOTO_UPLOAD_VALUE = 142;
    
    public static final int GUEST_SHOW_PHOTO_CLICK_VALUE = 141;
    
    public static final int GUEST_USER_GIFT_CLICK_VALUE = 127;
    
    public static final int GUEST_USER_KEYBOARD_CLICK_VALUE = 125;
    
    public static final int HOT_LIVE_H5_LINK_CLICK_VALUE = 26;
    
    public static final int LIVE_ACTIVITY_LINK_CLICK_VALUE = 203;
    
    public static final int LIVE_ACTIVITY_RESOURCE_CLICK_VALUE = 224;
    
    public static final int LIVE_ACTIVITY_RESOURCE_SHOW_VALUE = 223;
    
    public static final int LIVE_ANSWER_WHO_CLICK_VALUE = 164;
    
    public static final int LIVE_APPLY_ANCHOR_PAGE_SHOW_VALUE = 96;
    
    public static final int LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK_VALUE = 7;
    
    public static final int LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK_VALUE = 6;
    
    public static final int LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK_VALUE = 5;
    
    public static final int LIVE_APPLY_PREPARE_VALUE = 202;
    
    public static final int LIVE_CLASSIFY_BTN_CLICK_VALUE = 8;
    
    public static final int LIVE_CONNECT_TIME_VALUE = 185;
    
    public static final int LIVE_END_PAGE_FOLLOW_BTN_CLICK_VALUE = 40;
    
    public static final int LIVE_END_PAGE_FOLLOW_BTN_SHOW_VALUE = 39;
    
    public static final int LIVE_ENTER_SUCCESS_VALUE = 225;
    
    public static final int LIVE_EXIT_GUIDE_EXIT_BTN_CLICK_VALUE = 23;
    
    public static final int LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK_VALUE = 22;
    
    public static final int LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW_VALUE = 21;
    
    public static final int LIVE_EXPERIENCE_BAR_CLICK_VALUE = 27;
    
    public static final int LIVE_FANS_CLUB_BTN_CLICK_VALUE = 68;
    
    public static final int LIVE_FANS_RENEW_TOAST_CLICK_VALUE = 91;
    
    public static final int LIVE_FANS_RENEW_TOAST_SHOW_VALUE = 90;
    
    public static final int LIVE_FAVORITE_FIRST_ROOM_CLICK_VALUE = 57;
    
    public static final int LIVE_FEATURE_BOX_CLICK_VALUE = 30;
    
    public static final int LIVE_FEATURE_BOX_GESTURE_CLICK_VALUE = 31;
    
    public static final int LIVE_FEATURE_BOX_STICKER_CLICK_VALUE = 32;
    
    public static final int LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW_VALUE = 146;
    
    public static final int LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK_VALUE = 147;
    
    public static final int LIVE_FILTER_USE_VALUE = 13;
    
    public static final int LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK_VALUE = 52;
    
    public static final int LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW_VALUE = 51;
    
    public static final int LIVE_FIRST_LIKE_MSG_SEND_VALUE = 197;
    
    public static final int LIVE_FOLLOWED_GRID_RECOMMEND_CLICK_VALUE = 187;
    
    public static final int LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK_VALUE = 188;
    
    public static final int LIVE_FOLLOWED_GRID_RECOMMEND_SHOW_VALUE = 186;
    
    public static final int LIVE_FOLLOW_GUIDE_CLICK_VALUE = 198;
    
    public static final int LIVE_GIFT_LEVEL_BAR_CLICK_VALUE = 25;
    
    public static final int LIVE_GIFT_PAGE_GIFT_CLICK_VALUE = 209;
    
    public static final int LIVE_GIFT_PAGE_GIFT_SHOW_VALUE = 208;
    
    public static final int LIVE_GIFT_PAGE_SEND_CLICK_VALUE = 210;
    
    public static final int LIVE_GIFT_PAGE_VALUE = 205;
    
    public static final int LIVE_GLOW_STICK_TOAST_CLICK_VALUE = 95;
    
    public static final int LIVE_GLOW_STICK_TOAST_SHOW_VALUE = 94;
    
    public static final int LIVE_HOME_INTERACTIVE_AREA_CLICK_VALUE = 9;
    
    public static final int LIVE_HOME_REFRESH_IMAGE_SHOW_VALUE = 89;
    
    public static final int LIVE_HOME_REFRESH_LIVE_ENTER_VALUE = 60;
    
    public static final int LIVE_HOME_REFRESH_WORD_SHOW_VALUE = 59;
    
    public static final int LIVE_HOT_FIRST_ROOM_CLICK_VALUE = 58;
    
    public static final int LIVE_HOT_LIST_CLICK_VALUE = 44;
    
    public static final int LIVE_HOT_LIST_GO_GOODS_CLICK_VALUE = 45;
    
    public static final int LIVE_HOT_LIST_SHOW_VALUE = 43;
    
    public static final int LIVE_HOT_PAGE_SHOW_VALUE = 97;
    
    public static final int LIVE_HOT_SOAR_LIST_QA_CLICK_VALUE = 49;
    
    public static final int LIVE_INTERRUPT_VALUE = 201;
    
    public static final int LIVE_KISS_AUTO_RETURN_CLICK_VALUE = 238;
    
    public static final int LIVE_KISS_BTN_CLICK_VALUE = 233;
    
    public static final int LIVE_KISS_INSUFFICIENT_SHOW_VALUE = 236;
    
    public static final int LIVE_KISS_POP_SHOW_VALUE = 232;
    
    public static final int LIVE_KISS_PURCHASE_COMPLETE_SHOW_VALUE = 234;
    
    public static final int LIVE_KISS_RETURN_CLICK_VALUE = 235;
    
    public static final int LIVE_KISS_SURROUNDING_AREA_CLICK_VALUE = 237;
    
    public static final int LIVE_LEAVE_SUCCESS_VALUE = 226;
    
    public static final int LIVE_LOADING_VALUE = 200;
    
    public static final int LIVE_MANAGE_BTN_CLICK_VALUE = 184;
    
    public static final int LIVE_MUSIC_CHANGE_VALUE = 189;
    
    public static final int LIVE_MUSIC_COLLECT_CLICK_VALUE = 178;
    
    public static final int LIVE_MUSIC_DONE_VALUE = 190;
    
    public static final int LIVE_MUSIC_EXIT_CLICK_VALUE = 181;
    
    public static final int LIVE_MUSIC_PLAY_CLICK_VALUE = 179;
    
    public static final int LIVE_MUSIC_SEARCH_CLICK_VALUE = 183;
    
    public static final int LIVE_MUSIC_STOP_CLICK_VALUE = 180;
    
    public static final int LIVE_MUSIC_TAB_PAGE_SHOW_VALUE = 182;
    
    public static final int LIVE_MYSTERY_ANSWER_CLICK_VALUE = 169;
    
    public static final int LIVE_MYSTERY_ANSWER_SHOW_VALUE = 168;
    
    public static final int LIVE_MYSTERY_BTN_CLICK_VALUE = 160;
    
    public static final int LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK_VALUE = 163;
    
    public static final int LIVE_MYSTERY_PROFILE_AT_CLICK_VALUE = 162;
    
    public static final int LIVE_MYSTERY_PROFILE_SHOW_VALUE = 161;
    
    public static final int LIVE_NEW_MSG_CLICK_VALUE = 42;
    
    public static final int LIVE_NEW_MSG_SHOW_VALUE = 41;
    
    public static final int LIVE_PAY_BTN_CLICK_VALUE = 16;
    
    public static final int LIVE_PAY_BTN_SHOW_VALUE = 15;
    
    public static final int LIVE_PK_AUDIENCE_DURATION_VALUE = 239;
    
    public static final int LIVE_PK_AUDIENCE_SEAT_CLICK_VALUE = 240;
    
    public static final int LIVE_PK_ICON_CLICK_VALUE = 241;
    
    public static final int LIVE_PK_RANK_CLICK_VALUE = 242;
    
    public static final int LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK_VALUE = 18;
    
    public static final int LIVE_POP_PAY_LAYER_BTN_CLICK_VALUE = 20;
    
    public static final int LIVE_PREPARE_VALUE = 199;
    
    public static final int LIVE_PRE_TOP_CARD_GET_CLICK_VALUE = 149;
    
    public static final int LIVE_PRE_TOP_CARD_POP_SHOW_VALUE = 148;
    
    public static final int LIVE_RANK_PRIVILEGE_CLICK_VALUE = 29;
    
    public static final int LIVE_RANK_TASK_CLICK_VALUE = 28;
    
    public static final int LIVE_RECHARGE_BTN_CLICK_VALUE = 24;
    
    public static final int LIVE_RECHARGE_HUABAI_CLICK_VALUE = 99;
    
    public static final int LIVE_RECOMMEND_CLICK_VALUE = 177;
    
    public static final int LIVE_RECOMMEND_PAGE_SHOW_VALUE = 100;
    
    public static final int LIVE_RECOMMEND_SHOW_VALUE = 176;
    
    public static final int LIVE_REDVERIFY_CONFIRM_RED_RESULT_VALUE = 56;
    
    public static final int LIVE_REDVERIFY_CONFIRM_VALUE = 55;
    
    public static final int LIVE_REDVERIFY_SHOW_VALUE = 54;
    
    public static final int LIVE_REPORT_BTN_CLICK_VALUE = 64;
    
    public static final int LIVE_ROOM_CLICK_VALUE = 207;
    
    public static final int LIVE_ROOM_SHOW_VALUE = 196;
    
    public static final int LIVE_SEND_FANS_CLUB_TICKET_VALUE = 88;
    
    public static final int LIVE_SETTING_BEAUTY_BTN_CLICK_VALUE = 10;
    
    public static final int LIVE_SETTING_TITLE_BTN_CLICK_VALUE = 11;
    
    public static final int LIVE_SETTING_TITLE_SAVE_BTN_CLICK_VALUE = 12;
    
    public static final int LIVE_SLIDE_VALUE = 159;
    
    public static final int LIVE_SOAR_LIST_CLICK_VALUE = 47;
    
    public static final int LIVE_SOAR_LIST_GO_GOODS_CLICK_VALUE = 48;
    
    public static final int LIVE_SOAR_LIST_SHOW_VALUE = 46;
    
    public static final int LIVE_SOAR_PAGE_SHOW_VALUE = 98;
    
    public static final int LIVE_START_FROM_LIVELIST_VALUE = 204;
    
    public static final int LIVE_START_SHARE_FEED_VALUE = 206;
    
    public static final int LIVE_STICKERS_PAGE_SHOW_VALUE = 101;
    
    public static final int LIVE_TASK_AWARD_CLICK_VALUE = 34;
    
    public static final int LIVE_TASK_BTN_CLICK_VALUE = 33;
    
    public static final int LIVE_TASK_COLLECTION_PAGE_CLICK_VALUE = 156;
    
    public static final int LIVE_TASK_COLLECTION_PAGE_SHOW_VALUE = 155;
    
    public static final int LIVE_TASK_ENTER_CLICK_VALUE = 151;
    
    public static final int LIVE_TASK_ENTER_SHOW_VALUE = 150;
    
    public static final int LIVE_TASK_FOLLOW_CLICK_VALUE = 154;
    
    public static final int LIVE_TASK_GET_CLICK_VALUE = 152;
    
    public static final int LIVE_TASK_NEW_KING_CLICK_VALUE = 158;
    
    public static final int LIVE_TASK_NEW_KING_SHOW_VALUE = 157;
    
    public static final int LIVE_TASK_SEND_GIFT_CLICK_VALUE = 153;
    
    public static final int LIVE_TODAY_WELFARE_TOAST_CLICK_VALUE = 93;
    
    public static final int LIVE_TODAY_WELFARE_TOAST_SHOW_VALUE = 92;
    
    public static final int LIVE_USER_MSG_SEND_VALUE = 222;
    
    public static final int LIVE_USER_PROFILE_MANAGE_CLICK_VALUE = 170;
    
    public static final int LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK_VALUE = 171;
    
    public static final int LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK_VALUE = 173;
    
    public static final int LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK_VALUE = 172;
    
    public static final int LIVE_VIEWERS_FIRST_PAY_BTN_CLICK_VALUE = 14;
    
    public static final int LIVE_VIEWERS_FIRST_PAY_BTN_SHOW_VALUE = 4;
    
    public static final int LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK_VALUE = 3;
    
    public static final int LIVE_VIEWERS_GIFT_BTN_CLICK_VALUE = 2;
    
    public static final int LIVE_WANDOU_NUM_CLICK_VALUE = 53;
    
    public static final int MYSTERY_ASK_WHO_ANSWER_SEND_CLICK_VALUE = 167;
    
    public static final int MYSTERY_ASK_WHO_CLICK_VALUE = 166;
    
    public static final int MYSTERY_ASK_WHO_SHOW_VALUE = 165;
    
    public static final int PK_LIVE_PROFILE_FOLLOW_BTN_CLICK_VALUE = 175;
    
    public static final int PK_LIVE_PROFILE_FOLLOW_BTN_SHOW_VALUE = 174;
    
    public static final int RECOMMEND_PAGE_ENTER_BTN_CLICK_VALUE = 62;
    
    public static final int RECOMMEND_PAGE_MORE_BTN_CLICK_VALUE = 63;
    
    public static final int RECOMMEND_PAGE_ROOM_SHOW_VALUE = 61;
    
    public static final int RED_BAG_GET_POP_CANCEL_CLICK_VALUE = 195;
    
    public static final int RED_BAG_GET_POP_CONFIRM_CLICK_VALUE = 194;
    
    public static final int RED_BAG_GET_POP_SHOW_VALUE = 193;
    
    public static final int RED_BAG_GET_SUCCESS_VALUE = 192;
    
    public static final int RED_BAG_SEND_BTN_CLICK_VALUE = 191;
    
    public static final int START_LIVE_BEAUTY_BTN_CLICK_VALUE = 1;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    public static final int USER_ANCHOR_FOLLOW_BTN_CLICK_VALUE = 123;
    
    public static final int USER_CANCEL_MIKE_CLICK_VALUE = 121;
    
    public static final int USER_CONNECT_APPLY_BE_PICKED_CLICK_VALUE = 119;
    
    public static final int USER_CONNECT_APPLY_CLICK_VALUE = 118;
    
    public static final int USER_CONNECT_APPLY_TO_PICK_CLICK_VALUE = 120;
    
    public static final int USER_CONTRIBUTION_LIST_CLICK_VALUE = 104;
    
    public static final int USER_CONTRIBUTION_LIST_USER_CLICK_VALUE = 134;
    
    public static final int USER_CONTRIBUTION_LIST_USER_SHOW_VALUE = 133;
    
    public static final int USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK_VALUE = 137;
    
    public static final int USER_END_PAGE_RECOMMEND_ROOM_CLICK_VALUE = 136;
    
    public static final int USER_END_PAGE_RECOMMEND_ROOM_SHOW_VALUE = 135;
    
    public static final int USER_LIVE_GIFT_BTN_CLICK_VALUE = 128;
    
    public static final int USER_MIKE_USER_PHOTO_CARD_CLICK_VALUE = 132;
    
    public static final int USER_MIKE_USER_PHOTO_CLICK_VALUE = 130;
    
    public static final int USER_MIKE_USER_PHOTO_DOUBLE_CLICK_VALUE = 131;
    
    public static final int USER_MIKE_USER_PHOTO_SHOW_VALUE = 129;
    
    public static final int USER_PROFILE_FOLLOW_BTN_CLICK_VALUE = 221;
    
    public static final int USER_RECHARGE_CLICK_VALUE = 126;
    
    public static final int USER_SHARE_CLICK_VALUE = 124;
    
    public static final int USER_START_MIKE_CLICK_VALUE = 122;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      LIVE_VIEWERS_GIFT_BTN_CLICK = new Event("LIVE_VIEWERS_GIFT_BTN_CLICK", 2, 2);
      LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK = new Event("LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK", 3, 3);
      LIVE_VIEWERS_FIRST_PAY_BTN_SHOW = new Event("LIVE_VIEWERS_FIRST_PAY_BTN_SHOW", 4, 4);
      LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK = new Event("LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK", 5, 5);
      LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK = new Event("LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK", 6, 6);
      LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK = new Event("LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK", 7, 7);
      LIVE_CLASSIFY_BTN_CLICK = new Event("LIVE_CLASSIFY_BTN_CLICK", 8, 8);
      LIVE_HOME_INTERACTIVE_AREA_CLICK = new Event("LIVE_HOME_INTERACTIVE_AREA_CLICK", 9, 9);
      LIVE_SETTING_BEAUTY_BTN_CLICK = new Event("LIVE_SETTING_BEAUTY_BTN_CLICK", 10, 10);
      LIVE_SETTING_TITLE_BTN_CLICK = new Event("LIVE_SETTING_TITLE_BTN_CLICK", 11, 11);
      LIVE_SETTING_TITLE_SAVE_BTN_CLICK = new Event("LIVE_SETTING_TITLE_SAVE_BTN_CLICK", 12, 12);
      LIVE_FILTER_USE = new Event("LIVE_FILTER_USE", 13, 13);
      LIVE_VIEWERS_FIRST_PAY_BTN_CLICK = new Event("LIVE_VIEWERS_FIRST_PAY_BTN_CLICK", 14, 14);
      LIVE_PAY_BTN_SHOW = new Event("LIVE_PAY_BTN_SHOW", 15, 15);
      LIVE_PAY_BTN_CLICK = new Event("LIVE_PAY_BTN_CLICK", 16, 16);
      LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK = new Event("LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK", 17, 18);
      LIVE_POP_PAY_LAYER_BTN_CLICK = new Event("LIVE_POP_PAY_LAYER_BTN_CLICK", 18, 20);
      LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW = new Event("LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW", 19, 21);
      LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK = new Event("LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK", 20, 22);
      LIVE_EXIT_GUIDE_EXIT_BTN_CLICK = new Event("LIVE_EXIT_GUIDE_EXIT_BTN_CLICK", 21, 23);
      LIVE_RECHARGE_BTN_CLICK = new Event("LIVE_RECHARGE_BTN_CLICK", 22, 24);
      LIVE_GIFT_LEVEL_BAR_CLICK = new Event("LIVE_GIFT_LEVEL_BAR_CLICK", 23, 25);
      HOT_LIVE_H5_LINK_CLICK = new Event("HOT_LIVE_H5_LINK_CLICK", 24, 26);
      LIVE_EXPERIENCE_BAR_CLICK = new Event("LIVE_EXPERIENCE_BAR_CLICK", 25, 27);
      LIVE_RANK_TASK_CLICK = new Event("LIVE_RANK_TASK_CLICK", 26, 28);
      LIVE_RANK_PRIVILEGE_CLICK = new Event("LIVE_RANK_PRIVILEGE_CLICK", 27, 29);
      LIVE_FEATURE_BOX_CLICK = new Event("LIVE_FEATURE_BOX_CLICK", 28, 30);
      LIVE_FEATURE_BOX_GESTURE_CLICK = new Event("LIVE_FEATURE_BOX_GESTURE_CLICK", 29, 31);
      LIVE_FEATURE_BOX_STICKER_CLICK = new Event("LIVE_FEATURE_BOX_STICKER_CLICK", 30, 32);
      LIVE_TASK_BTN_CLICK = new Event("LIVE_TASK_BTN_CLICK", 31, 33);
      LIVE_TASK_AWARD_CLICK = new Event("LIVE_TASK_AWARD_CLICK", 32, 34);
      LIVE_END_PAGE_FOLLOW_BTN_SHOW = new Event("LIVE_END_PAGE_FOLLOW_BTN_SHOW", 33, 39);
      LIVE_END_PAGE_FOLLOW_BTN_CLICK = new Event("LIVE_END_PAGE_FOLLOW_BTN_CLICK", 34, 40);
      LIVE_NEW_MSG_SHOW = new Event("LIVE_NEW_MSG_SHOW", 35, 41);
      LIVE_NEW_MSG_CLICK = new Event("LIVE_NEW_MSG_CLICK", 36, 42);
      LIVE_HOT_LIST_SHOW = new Event("LIVE_HOT_LIST_SHOW", 37, 43);
      LIVE_HOT_LIST_CLICK = new Event("LIVE_HOT_LIST_CLICK", 38, 44);
      LIVE_HOT_LIST_GO_GOODS_CLICK = new Event("LIVE_HOT_LIST_GO_GOODS_CLICK", 39, 45);
      LIVE_SOAR_LIST_SHOW = new Event("LIVE_SOAR_LIST_SHOW", 40, 46);
      LIVE_SOAR_LIST_CLICK = new Event("LIVE_SOAR_LIST_CLICK", 41, 47);
      LIVE_SOAR_LIST_GO_GOODS_CLICK = new Event("LIVE_SOAR_LIST_GO_GOODS_CLICK", 42, 48);
      LIVE_HOT_SOAR_LIST_QA_CLICK = new Event("LIVE_HOT_SOAR_LIST_QA_CLICK", 43, 49);
      FLASH_VIDEO_USER_LIVE_PHOTO_CLICK = new Event("FLASH_VIDEO_USER_LIVE_PHOTO_CLICK", 44, 50);
      LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW = new Event("LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW", 45, 51);
      LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK = new Event("LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK", 46, 52);
      LIVE_WANDOU_NUM_CLICK = new Event("LIVE_WANDOU_NUM_CLICK", 47, 53);
      LIVE_REDVERIFY_SHOW = new Event("LIVE_REDVERIFY_SHOW", 48, 54);
      LIVE_REDVERIFY_CONFIRM = new Event("LIVE_REDVERIFY_CONFIRM", 49, 55);
      LIVE_REDVERIFY_CONFIRM_RED_RESULT = new Event("LIVE_REDVERIFY_CONFIRM_RED_RESULT", 50, 56);
      LIVE_FAVORITE_FIRST_ROOM_CLICK = new Event("LIVE_FAVORITE_FIRST_ROOM_CLICK", 51, 57);
      LIVE_HOT_FIRST_ROOM_CLICK = new Event("LIVE_HOT_FIRST_ROOM_CLICK", 52, 58);
      LIVE_HOME_REFRESH_WORD_SHOW = new Event("LIVE_HOME_REFRESH_WORD_SHOW", 53, 59);
      LIVE_HOME_REFRESH_LIVE_ENTER = new Event("LIVE_HOME_REFRESH_LIVE_ENTER", 54, 60);
      RECOMMEND_PAGE_ROOM_SHOW = new Event("RECOMMEND_PAGE_ROOM_SHOW", 55, 61);
      RECOMMEND_PAGE_ENTER_BTN_CLICK = new Event("RECOMMEND_PAGE_ENTER_BTN_CLICK", 56, 62);
      RECOMMEND_PAGE_MORE_BTN_CLICK = new Event("RECOMMEND_PAGE_MORE_BTN_CLICK", 57, 63);
      LIVE_REPORT_BTN_CLICK = new Event("LIVE_REPORT_BTN_CLICK", 58, 64);
      FANS_CLUB_PAGE_SHOW = new Event("FANS_CLUB_PAGE_SHOW", 59, 65);
      FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW = new Event("FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW", 60, 66);
      FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK = new Event("FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK", 61, 67);
      LIVE_FANS_CLUB_BTN_CLICK = new Event("LIVE_FANS_CLUB_BTN_CLICK", 62, 68);
      FANS_CLUB_PAGE_EDIT_NAME_CLICK = new Event("FANS_CLUB_PAGE_EDIT_NAME_CLICK", 63, 69);
      FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK = new Event("FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK", 64, 70);
      FANS_CLUB_PAGE_ACTIVE_CLICK = new Event("FANS_CLUB_PAGE_ACTIVE_CLICK", 65, 71);
      FANS_CLUB_PAGE_TODAY_CLICK = new Event("FANS_CLUB_PAGE_TODAY_CLICK", 66, 72);
      FANS_CLUB_PAGE_ALL_CLICK = new Event("FANS_CLUB_PAGE_ALL_CLICK", 67, 73);
      FANS_CLUB_PAGE_QA_CLICK = new Event("FANS_CLUB_PAGE_QA_CLICK", 68, 74);
      FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK = new Event("FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK", 69, 75);
      FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK = new Event("FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK", 70, 76);
      FANS_CLUB_PAGE_ALL_LIST_USER_CLICK = new Event("FANS_CLUB_PAGE_ALL_LIST_USER_CLICK", 71, 77);
      FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW = new Event("FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW", 72, 78);
      FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK = new Event("FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK", 73, 79);
      FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK = new Event("FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK", 74, 80);
      FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW = new Event("FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW", 75, 81);
      FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK = new Event("FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK", 76, 82);
      FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW = new Event("FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW", 77, 83);
      FANS_CLUB_PAGE_JOIN_PAGE_SHOW = new Event("FANS_CLUB_PAGE_JOIN_PAGE_SHOW", 78, 84);
      FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK = new Event("FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK", 79, 85);
      FANS_CLUB_MSG_SHOW = new Event("FANS_CLUB_MSG_SHOW", 80, 86);
      FANS_CLUB_MSG_CLICK = new Event("FANS_CLUB_MSG_CLICK", 81, 87);
      LIVE_SEND_FANS_CLUB_TICKET = new Event("LIVE_SEND_FANS_CLUB_TICKET", 82, 88);
      LIVE_HOME_REFRESH_IMAGE_SHOW = new Event("LIVE_HOME_REFRESH_IMAGE_SHOW", 83, 89);
      LIVE_FANS_RENEW_TOAST_SHOW = new Event("LIVE_FANS_RENEW_TOAST_SHOW", 84, 90);
      LIVE_FANS_RENEW_TOAST_CLICK = new Event("LIVE_FANS_RENEW_TOAST_CLICK", 85, 91);
      LIVE_TODAY_WELFARE_TOAST_SHOW = new Event("LIVE_TODAY_WELFARE_TOAST_SHOW", 86, 92);
      LIVE_TODAY_WELFARE_TOAST_CLICK = new Event("LIVE_TODAY_WELFARE_TOAST_CLICK", 87, 93);
      LIVE_GLOW_STICK_TOAST_SHOW = new Event("LIVE_GLOW_STICK_TOAST_SHOW", 88, 94);
      LIVE_GLOW_STICK_TOAST_CLICK = new Event("LIVE_GLOW_STICK_TOAST_CLICK", 89, 95);
      LIVE_APPLY_ANCHOR_PAGE_SHOW = new Event("LIVE_APPLY_ANCHOR_PAGE_SHOW", 90, 96);
      LIVE_HOT_PAGE_SHOW = new Event("LIVE_HOT_PAGE_SHOW", 91, 97);
      LIVE_SOAR_PAGE_SHOW = new Event("LIVE_SOAR_PAGE_SHOW", 92, 98);
      LIVE_RECHARGE_HUABAI_CLICK = new Event("LIVE_RECHARGE_HUABAI_CLICK", 93, 99);
      LIVE_RECOMMEND_PAGE_SHOW = new Event("LIVE_RECOMMEND_PAGE_SHOW", 94, 100);
      LIVE_STICKERS_PAGE_SHOW = new Event("LIVE_STICKERS_PAGE_SHOW", 95, 101);
      ANCHOR_SETTING_START_CLICK = new Event("ANCHOR_SETTING_START_CLICK", 96, 102);
      ANCHOR_SETTING_BLIND_DATING_CLICK = new Event("ANCHOR_SETTING_BLIND_DATING_CLICK", 97, 103);
      USER_CONTRIBUTION_LIST_CLICK = new Event("USER_CONTRIBUTION_LIST_CLICK", 98, 104);
      ANCHOR_MATCH_SUCCESS_CLICK = new Event("ANCHOR_MATCH_SUCCESS_CLICK", 99, 105);
      ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK = new Event("ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK", 100, 106);
      ANCHOR_RENEW_BTN_CLICK = new Event("ANCHOR_RENEW_BTN_CLICK", 101, 107);
      ANCHOR_FEATURE_CLICK = new Event("ANCHOR_FEATURE_CLICK", 102, 108);
      ANCHOR_MIKE_MANAGE_CLICK = new Event("ANCHOR_MIKE_MANAGE_CLICK", 103, 109);
      ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK = new Event("ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK", 104, 110);
      ANCHOR_MIKE_MANAGE_TO_PICK_CLICK = new Event("ANCHOR_MIKE_MANAGE_TO_PICK_CLICK", 105, 111);
      ANCHOR_MIKE_MANAGE_CONFIRM_CLICK = new Event("ANCHOR_MIKE_MANAGE_CONFIRM_CLICK", 106, 112);
      ANCHOR_MIKE_MANAGE_IGNORE_CLICK = new Event("ANCHOR_MIKE_MANAGE_IGNORE_CLICK", 107, 113);
      ANCHOR_END_PAGE_SHOW = new Event("ANCHOR_END_PAGE_SHOW", 108, 114);
      ANCHOR_END_PAGE_RECORD_SHARE_CLICK = new Event("ANCHOR_END_PAGE_RECORD_SHARE_CLICK", 109, 115);
      ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK = new Event("ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK", 110, 116);
      ANCHOR_END_PAGE_CONFIRM_CLICK = new Event("ANCHOR_END_PAGE_CONFIRM_CLICK", 111, 117);
      USER_CONNECT_APPLY_CLICK = new Event("USER_CONNECT_APPLY_CLICK", 112, 118);
      USER_CONNECT_APPLY_BE_PICKED_CLICK = new Event("USER_CONNECT_APPLY_BE_PICKED_CLICK", 113, 119);
      USER_CONNECT_APPLY_TO_PICK_CLICK = new Event("USER_CONNECT_APPLY_TO_PICK_CLICK", 114, 120);
      USER_CANCEL_MIKE_CLICK = new Event("USER_CANCEL_MIKE_CLICK", 115, 121);
      USER_START_MIKE_CLICK = new Event("USER_START_MIKE_CLICK", 116, 122);
      USER_ANCHOR_FOLLOW_BTN_CLICK = new Event("USER_ANCHOR_FOLLOW_BTN_CLICK", 117, 123);
      USER_SHARE_CLICK = new Event("USER_SHARE_CLICK", 118, 124);
      GUEST_USER_KEYBOARD_CLICK = new Event("GUEST_USER_KEYBOARD_CLICK", 119, 125);
      USER_RECHARGE_CLICK = new Event("USER_RECHARGE_CLICK", 120, 126);
      GUEST_USER_GIFT_CLICK = new Event("GUEST_USER_GIFT_CLICK", 121, 127);
      USER_LIVE_GIFT_BTN_CLICK = new Event("USER_LIVE_GIFT_BTN_CLICK", 122, 128);
      USER_MIKE_USER_PHOTO_SHOW = new Event("USER_MIKE_USER_PHOTO_SHOW", 123, 129);
      USER_MIKE_USER_PHOTO_CLICK = new Event("USER_MIKE_USER_PHOTO_CLICK", 124, 130);
      USER_MIKE_USER_PHOTO_DOUBLE_CLICK = new Event("USER_MIKE_USER_PHOTO_DOUBLE_CLICK", 125, 131);
      USER_MIKE_USER_PHOTO_CARD_CLICK = new Event("USER_MIKE_USER_PHOTO_CARD_CLICK", 126, 132);
      USER_CONTRIBUTION_LIST_USER_SHOW = new Event("USER_CONTRIBUTION_LIST_USER_SHOW", 127, 133);
      USER_CONTRIBUTION_LIST_USER_CLICK = new Event("USER_CONTRIBUTION_LIST_USER_CLICK", 128, 134);
      USER_END_PAGE_RECOMMEND_ROOM_SHOW = new Event("USER_END_PAGE_RECOMMEND_ROOM_SHOW", 129, 135);
      USER_END_PAGE_RECOMMEND_ROOM_CLICK = new Event("USER_END_PAGE_RECOMMEND_ROOM_CLICK", 130, 136);
      USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK = new Event("USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK", 131, 137);
      GUEST_HANG_UP_CLICK = new Event("GUEST_HANG_UP_CLICK", 132, 138);
      GUEST_CLOSE_MIKE_CLICK = new Event("GUEST_CLOSE_MIKE_CLICK", 133, 139);
      GUEST_LIGHT_OFF_CLICK = new Event("GUEST_LIGHT_OFF_CLICK", 134, 140);
      GUEST_SHOW_PHOTO_CLICK = new Event("GUEST_SHOW_PHOTO_CLICK", 135, 141);
      GUEST_PHOTO_UPLOAD = new Event("GUEST_PHOTO_UPLOAD", 136, 142);
      GUEST_MATCH_SUCCESS_POP_SHOW = new Event("GUEST_MATCH_SUCCESS_POP_SHOW", 137, 143);
      GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK = new Event("GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK", 138, 144);
      ANCHOR_MATCH_SUCCESS_POP_SHOW = new Event("ANCHOR_MATCH_SUCCESS_POP_SHOW", 139, 145);
      LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW = new Event("LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW", 140, 146);
      LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK = new Event("LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK", 141, 147);
      LIVE_PRE_TOP_CARD_POP_SHOW = new Event("LIVE_PRE_TOP_CARD_POP_SHOW", 142, 148);
      LIVE_PRE_TOP_CARD_GET_CLICK = new Event("LIVE_PRE_TOP_CARD_GET_CLICK", 143, 149);
      LIVE_TASK_ENTER_SHOW = new Event("LIVE_TASK_ENTER_SHOW", 144, 150);
      LIVE_TASK_ENTER_CLICK = new Event("LIVE_TASK_ENTER_CLICK", 145, 151);
      LIVE_TASK_GET_CLICK = new Event("LIVE_TASK_GET_CLICK", 146, 152);
      LIVE_TASK_SEND_GIFT_CLICK = new Event("LIVE_TASK_SEND_GIFT_CLICK", 147, 153);
      LIVE_TASK_FOLLOW_CLICK = new Event("LIVE_TASK_FOLLOW_CLICK", 148, 154);
      LIVE_TASK_COLLECTION_PAGE_SHOW = new Event("LIVE_TASK_COLLECTION_PAGE_SHOW", 149, 155);
      LIVE_TASK_COLLECTION_PAGE_CLICK = new Event("LIVE_TASK_COLLECTION_PAGE_CLICK", 150, 156);
      LIVE_TASK_NEW_KING_SHOW = new Event("LIVE_TASK_NEW_KING_SHOW", 151, 157);
      LIVE_TASK_NEW_KING_CLICK = new Event("LIVE_TASK_NEW_KING_CLICK", 152, 158);
      LIVE_SLIDE = new Event("LIVE_SLIDE", 153, 159);
      LIVE_MYSTERY_BTN_CLICK = new Event("LIVE_MYSTERY_BTN_CLICK", 154, 160);
      LIVE_MYSTERY_PROFILE_SHOW = new Event("LIVE_MYSTERY_PROFILE_SHOW", 155, 161);
      LIVE_MYSTERY_PROFILE_AT_CLICK = new Event("LIVE_MYSTERY_PROFILE_AT_CLICK", 156, 162);
      LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK = new Event("LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK", 157, 163);
      LIVE_ANSWER_WHO_CLICK = new Event("LIVE_ANSWER_WHO_CLICK", 158, 164);
      MYSTERY_ASK_WHO_SHOW = new Event("MYSTERY_ASK_WHO_SHOW", 159, 165);
      MYSTERY_ASK_WHO_CLICK = new Event("MYSTERY_ASK_WHO_CLICK", 160, 166);
      MYSTERY_ASK_WHO_ANSWER_SEND_CLICK = new Event("MYSTERY_ASK_WHO_ANSWER_SEND_CLICK", 161, 167);
      LIVE_MYSTERY_ANSWER_SHOW = new Event("LIVE_MYSTERY_ANSWER_SHOW", 162, 168);
      LIVE_MYSTERY_ANSWER_CLICK = new Event("LIVE_MYSTERY_ANSWER_CLICK", 163, 169);
      LIVE_USER_PROFILE_MANAGE_CLICK = new Event("LIVE_USER_PROFILE_MANAGE_CLICK", 164, 170);
      LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK = new Event("LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK", 165, 171);
      LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK = new Event("LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK", 166, 172);
      LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK = new Event("LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK", 167, 173);
      PK_LIVE_PROFILE_FOLLOW_BTN_SHOW = new Event("PK_LIVE_PROFILE_FOLLOW_BTN_SHOW", 168, 174);
      PK_LIVE_PROFILE_FOLLOW_BTN_CLICK = new Event("PK_LIVE_PROFILE_FOLLOW_BTN_CLICK", 169, 175);
      LIVE_RECOMMEND_SHOW = new Event("LIVE_RECOMMEND_SHOW", 170, 176);
      LIVE_RECOMMEND_CLICK = new Event("LIVE_RECOMMEND_CLICK", 171, 177);
      LIVE_MUSIC_COLLECT_CLICK = new Event("LIVE_MUSIC_COLLECT_CLICK", 172, 178);
      LIVE_MUSIC_PLAY_CLICK = new Event("LIVE_MUSIC_PLAY_CLICK", 173, 179);
      LIVE_MUSIC_STOP_CLICK = new Event("LIVE_MUSIC_STOP_CLICK", 174, 180);
      LIVE_MUSIC_EXIT_CLICK = new Event("LIVE_MUSIC_EXIT_CLICK", 175, 181);
      LIVE_MUSIC_TAB_PAGE_SHOW = new Event("LIVE_MUSIC_TAB_PAGE_SHOW", 176, 182);
      LIVE_MUSIC_SEARCH_CLICK = new Event("LIVE_MUSIC_SEARCH_CLICK", 177, 183);
      LIVE_MANAGE_BTN_CLICK = new Event("LIVE_MANAGE_BTN_CLICK", 178, 184);
      LIVE_CONNECT_TIME = new Event("LIVE_CONNECT_TIME", 179, 185);
      LIVE_FOLLOWED_GRID_RECOMMEND_SHOW = new Event("LIVE_FOLLOWED_GRID_RECOMMEND_SHOW", 180, 186);
      LIVE_FOLLOWED_GRID_RECOMMEND_CLICK = new Event("LIVE_FOLLOWED_GRID_RECOMMEND_CLICK", 181, 187);
      LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK = new Event("LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK", 182, 188);
      LIVE_MUSIC_CHANGE = new Event("LIVE_MUSIC_CHANGE", 183, 189);
      LIVE_MUSIC_DONE = new Event("LIVE_MUSIC_DONE", 184, 190);
      RED_BAG_SEND_BTN_CLICK = new Event("RED_BAG_SEND_BTN_CLICK", 185, 191);
      RED_BAG_GET_SUCCESS = new Event("RED_BAG_GET_SUCCESS", 186, 192);
      RED_BAG_GET_POP_SHOW = new Event("RED_BAG_GET_POP_SHOW", 187, 193);
      RED_BAG_GET_POP_CONFIRM_CLICK = new Event("RED_BAG_GET_POP_CONFIRM_CLICK", 188, 194);
      RED_BAG_GET_POP_CANCEL_CLICK = new Event("RED_BAG_GET_POP_CANCEL_CLICK", 189, 195);
      LIVE_ROOM_SHOW = new Event("LIVE_ROOM_SHOW", 190, 196);
      LIVE_FIRST_LIKE_MSG_SEND = new Event("LIVE_FIRST_LIKE_MSG_SEND", 191, 197);
      LIVE_FOLLOW_GUIDE_CLICK = new Event("LIVE_FOLLOW_GUIDE_CLICK", 192, 198);
      LIVE_PREPARE = new Event("LIVE_PREPARE", 193, 199);
      LIVE_LOADING = new Event("LIVE_LOADING", 194, 200);
      LIVE_INTERRUPT = new Event("LIVE_INTERRUPT", 195, 201);
      LIVE_APPLY_PREPARE = new Event("LIVE_APPLY_PREPARE", 196, 202);
      LIVE_ACTIVITY_LINK_CLICK = new Event("LIVE_ACTIVITY_LINK_CLICK", 197, 203);
      LIVE_START_FROM_LIVELIST = new Event("LIVE_START_FROM_LIVELIST", 198, 204);
      LIVE_GIFT_PAGE = new Event("LIVE_GIFT_PAGE", 199, 205);
      LIVE_START_SHARE_FEED = new Event("LIVE_START_SHARE_FEED", 200, 206);
      LIVE_ROOM_CLICK = new Event("LIVE_ROOM_CLICK", 201, 207);
      LIVE_GIFT_PAGE_GIFT_SHOW = new Event("LIVE_GIFT_PAGE_GIFT_SHOW", 202, 208);
      LIVE_GIFT_PAGE_GIFT_CLICK = new Event("LIVE_GIFT_PAGE_GIFT_CLICK", 203, 209);
      LIVE_GIFT_PAGE_SEND_CLICK = new Event("LIVE_GIFT_PAGE_SEND_CLICK", 204, 210);
      BETTER_ID_POP_SHOW = new Event("BETTER_ID_POP_SHOW", 205, 211);
      BETTER_ID_POP_CLOSE_CLICK = new Event("BETTER_ID_POP_CLOSE_CLICK", 206, 212);
      BETTER_ID_POP_LOOK_CLICK = new Event("BETTER_ID_POP_LOOK_CLICK", 207, 213);
      BETTER_ID_POP_CHOOSE_CLICK = new Event("BETTER_ID_POP_CHOOSE_CLICK", 208, 214);
      BETTER_ID_MY_PROFILE_BATTER_CLICK = new Event("BETTER_ID_MY_PROFILE_BATTER_CLICK", 209, 215);
      BETTER_ID_OTHER_PROFILE_BATTER_CLICK = new Event("BETTER_ID_OTHER_PROFILE_BATTER_CLICK", 210, 216);
      BETTER_ID_ANCHOR_POP_BATTER_CLICK = new Event("BETTER_ID_ANCHOR_POP_BATTER_CLICK", 211, 217);
      BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK = new Event("BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK", 212, 218);
      BETTER_ID_USER_POP_BATTER_CLICK = new Event("BETTER_ID_USER_POP_BATTER_CLICK", 213, 219);
      BETTER_ID_USER_PHOTO_BATTER_CLICK = new Event("BETTER_ID_USER_PHOTO_BATTER_CLICK", 214, 220);
      USER_PROFILE_FOLLOW_BTN_CLICK = new Event("USER_PROFILE_FOLLOW_BTN_CLICK", 215, 221);
      LIVE_USER_MSG_SEND = new Event("LIVE_USER_MSG_SEND", 216, 222);
      LIVE_ACTIVITY_RESOURCE_SHOW = new Event("LIVE_ACTIVITY_RESOURCE_SHOW", 217, 223);
      LIVE_ACTIVITY_RESOURCE_CLICK = new Event("LIVE_ACTIVITY_RESOURCE_CLICK", 218, 224);
      LIVE_ENTER_SUCCESS = new Event("LIVE_ENTER_SUCCESS", 219, 225);
      LIVE_LEAVE_SUCCESS = new Event("LIVE_LEAVE_SUCCESS", 220, 226);
      BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK = new Event("BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK", 221, 227);
      BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK = new Event("BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK", 222, 228);
      BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK = new Event("BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK", 223, 229);
      BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK = new Event("BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK", 224, 230);
      BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK = new Event("BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK", 225, 231);
      LIVE_KISS_POP_SHOW = new Event("LIVE_KISS_POP_SHOW", 226, 232);
      LIVE_KISS_BTN_CLICK = new Event("LIVE_KISS_BTN_CLICK", 227, 233);
      LIVE_KISS_PURCHASE_COMPLETE_SHOW = new Event("LIVE_KISS_PURCHASE_COMPLETE_SHOW", 228, 234);
      LIVE_KISS_RETURN_CLICK = new Event("LIVE_KISS_RETURN_CLICK", 229, 235);
      LIVE_KISS_INSUFFICIENT_SHOW = new Event("LIVE_KISS_INSUFFICIENT_SHOW", 230, 236);
      LIVE_KISS_SURROUNDING_AREA_CLICK = new Event("LIVE_KISS_SURROUNDING_AREA_CLICK", 231, 237);
      LIVE_KISS_AUTO_RETURN_CLICK = new Event("LIVE_KISS_AUTO_RETURN_CLICK", 232, 238);
      LIVE_PK_AUDIENCE_DURATION = new Event("LIVE_PK_AUDIENCE_DURATION", 233, 239);
      LIVE_PK_AUDIENCE_SEAT_CLICK = new Event("LIVE_PK_AUDIENCE_SEAT_CLICK", 234, 240);
      LIVE_PK_ICON_CLICK = new Event("LIVE_PK_ICON_CLICK", 235, 241);
      LIVE_PK_RANK_CLICK = new Event("LIVE_PK_RANK_CLICK", 236, 242);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 237, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, START_LIVE_BEAUTY_BTN_CLICK, LIVE_VIEWERS_GIFT_BTN_CLICK, LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK, LIVE_VIEWERS_FIRST_PAY_BTN_SHOW, LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK, LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK, LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK, LIVE_CLASSIFY_BTN_CLICK, LIVE_HOME_INTERACTIVE_AREA_CLICK, 
          LIVE_SETTING_BEAUTY_BTN_CLICK, LIVE_SETTING_TITLE_BTN_CLICK, LIVE_SETTING_TITLE_SAVE_BTN_CLICK, LIVE_FILTER_USE, LIVE_VIEWERS_FIRST_PAY_BTN_CLICK, LIVE_PAY_BTN_SHOW, LIVE_PAY_BTN_CLICK, LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK, LIVE_POP_PAY_LAYER_BTN_CLICK, LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW, 
          LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK, LIVE_EXIT_GUIDE_EXIT_BTN_CLICK, LIVE_RECHARGE_BTN_CLICK, LIVE_GIFT_LEVEL_BAR_CLICK, HOT_LIVE_H5_LINK_CLICK, LIVE_EXPERIENCE_BAR_CLICK, LIVE_RANK_TASK_CLICK, LIVE_RANK_PRIVILEGE_CLICK, LIVE_FEATURE_BOX_CLICK, LIVE_FEATURE_BOX_GESTURE_CLICK, 
          LIVE_FEATURE_BOX_STICKER_CLICK, LIVE_TASK_BTN_CLICK, LIVE_TASK_AWARD_CLICK, LIVE_END_PAGE_FOLLOW_BTN_SHOW, LIVE_END_PAGE_FOLLOW_BTN_CLICK, LIVE_NEW_MSG_SHOW, LIVE_NEW_MSG_CLICK, LIVE_HOT_LIST_SHOW, LIVE_HOT_LIST_CLICK, LIVE_HOT_LIST_GO_GOODS_CLICK, 
          LIVE_SOAR_LIST_SHOW, LIVE_SOAR_LIST_CLICK, LIVE_SOAR_LIST_GO_GOODS_CLICK, LIVE_HOT_SOAR_LIST_QA_CLICK, FLASH_VIDEO_USER_LIVE_PHOTO_CLICK, LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW, LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK, LIVE_WANDOU_NUM_CLICK, LIVE_REDVERIFY_SHOW, LIVE_REDVERIFY_CONFIRM, 
          LIVE_REDVERIFY_CONFIRM_RED_RESULT, LIVE_FAVORITE_FIRST_ROOM_CLICK, LIVE_HOT_FIRST_ROOM_CLICK, LIVE_HOME_REFRESH_WORD_SHOW, LIVE_HOME_REFRESH_LIVE_ENTER, RECOMMEND_PAGE_ROOM_SHOW, RECOMMEND_PAGE_ENTER_BTN_CLICK, RECOMMEND_PAGE_MORE_BTN_CLICK, LIVE_REPORT_BTN_CLICK, FANS_CLUB_PAGE_SHOW, 
          FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW, FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK, LIVE_FANS_CLUB_BTN_CLICK, FANS_CLUB_PAGE_EDIT_NAME_CLICK, FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK, FANS_CLUB_PAGE_ACTIVE_CLICK, FANS_CLUB_PAGE_TODAY_CLICK, FANS_CLUB_PAGE_ALL_CLICK, FANS_CLUB_PAGE_QA_CLICK, FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK, 
          FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK, FANS_CLUB_PAGE_ALL_LIST_USER_CLICK, FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW, FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK, FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK, FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW, FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK, FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW, FANS_CLUB_PAGE_JOIN_PAGE_SHOW, FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, 
          FANS_CLUB_MSG_SHOW, FANS_CLUB_MSG_CLICK, LIVE_SEND_FANS_CLUB_TICKET, LIVE_HOME_REFRESH_IMAGE_SHOW, LIVE_FANS_RENEW_TOAST_SHOW, LIVE_FANS_RENEW_TOAST_CLICK, LIVE_TODAY_WELFARE_TOAST_SHOW, LIVE_TODAY_WELFARE_TOAST_CLICK, LIVE_GLOW_STICK_TOAST_SHOW, LIVE_GLOW_STICK_TOAST_CLICK, 
          LIVE_APPLY_ANCHOR_PAGE_SHOW, LIVE_HOT_PAGE_SHOW, LIVE_SOAR_PAGE_SHOW, LIVE_RECHARGE_HUABAI_CLICK, LIVE_RECOMMEND_PAGE_SHOW, LIVE_STICKERS_PAGE_SHOW, ANCHOR_SETTING_START_CLICK, ANCHOR_SETTING_BLIND_DATING_CLICK, USER_CONTRIBUTION_LIST_CLICK, ANCHOR_MATCH_SUCCESS_CLICK, 
          ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK, ANCHOR_RENEW_BTN_CLICK, ANCHOR_FEATURE_CLICK, ANCHOR_MIKE_MANAGE_CLICK, ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK, ANCHOR_MIKE_MANAGE_TO_PICK_CLICK, ANCHOR_MIKE_MANAGE_CONFIRM_CLICK, ANCHOR_MIKE_MANAGE_IGNORE_CLICK, ANCHOR_END_PAGE_SHOW, ANCHOR_END_PAGE_RECORD_SHARE_CLICK, 
          ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK, ANCHOR_END_PAGE_CONFIRM_CLICK, USER_CONNECT_APPLY_CLICK, USER_CONNECT_APPLY_BE_PICKED_CLICK, USER_CONNECT_APPLY_TO_PICK_CLICK, USER_CANCEL_MIKE_CLICK, USER_START_MIKE_CLICK, USER_ANCHOR_FOLLOW_BTN_CLICK, USER_SHARE_CLICK, GUEST_USER_KEYBOARD_CLICK, 
          USER_RECHARGE_CLICK, GUEST_USER_GIFT_CLICK, USER_LIVE_GIFT_BTN_CLICK, USER_MIKE_USER_PHOTO_SHOW, USER_MIKE_USER_PHOTO_CLICK, USER_MIKE_USER_PHOTO_DOUBLE_CLICK, USER_MIKE_USER_PHOTO_CARD_CLICK, USER_CONTRIBUTION_LIST_USER_SHOW, USER_CONTRIBUTION_LIST_USER_CLICK, USER_END_PAGE_RECOMMEND_ROOM_SHOW, 
          USER_END_PAGE_RECOMMEND_ROOM_CLICK, USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK, GUEST_HANG_UP_CLICK, GUEST_CLOSE_MIKE_CLICK, GUEST_LIGHT_OFF_CLICK, GUEST_SHOW_PHOTO_CLICK, GUEST_PHOTO_UPLOAD, GUEST_MATCH_SUCCESS_POP_SHOW, GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK, ANCHOR_MATCH_SUCCESS_POP_SHOW, 
          LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW, LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK, LIVE_PRE_TOP_CARD_POP_SHOW, LIVE_PRE_TOP_CARD_GET_CLICK, LIVE_TASK_ENTER_SHOW, LIVE_TASK_ENTER_CLICK, LIVE_TASK_GET_CLICK, LIVE_TASK_SEND_GIFT_CLICK, LIVE_TASK_FOLLOW_CLICK, LIVE_TASK_COLLECTION_PAGE_SHOW, 
          LIVE_TASK_COLLECTION_PAGE_CLICK, LIVE_TASK_NEW_KING_SHOW, LIVE_TASK_NEW_KING_CLICK, LIVE_SLIDE, LIVE_MYSTERY_BTN_CLICK, LIVE_MYSTERY_PROFILE_SHOW, LIVE_MYSTERY_PROFILE_AT_CLICK, LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK, LIVE_ANSWER_WHO_CLICK, MYSTERY_ASK_WHO_SHOW, 
          MYSTERY_ASK_WHO_CLICK, MYSTERY_ASK_WHO_ANSWER_SEND_CLICK, LIVE_MYSTERY_ANSWER_SHOW, LIVE_MYSTERY_ANSWER_CLICK, LIVE_USER_PROFILE_MANAGE_CLICK, LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK, LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK, LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK, PK_LIVE_PROFILE_FOLLOW_BTN_SHOW, PK_LIVE_PROFILE_FOLLOW_BTN_CLICK, 
          LIVE_RECOMMEND_SHOW, LIVE_RECOMMEND_CLICK, LIVE_MUSIC_COLLECT_CLICK, LIVE_MUSIC_PLAY_CLICK, LIVE_MUSIC_STOP_CLICK, LIVE_MUSIC_EXIT_CLICK, LIVE_MUSIC_TAB_PAGE_SHOW, LIVE_MUSIC_SEARCH_CLICK, LIVE_MANAGE_BTN_CLICK, LIVE_CONNECT_TIME, 
          LIVE_FOLLOWED_GRID_RECOMMEND_SHOW, LIVE_FOLLOWED_GRID_RECOMMEND_CLICK, LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK, LIVE_MUSIC_CHANGE, LIVE_MUSIC_DONE, RED_BAG_SEND_BTN_CLICK, RED_BAG_GET_SUCCESS, RED_BAG_GET_POP_SHOW, RED_BAG_GET_POP_CONFIRM_CLICK, RED_BAG_GET_POP_CANCEL_CLICK, 
          LIVE_ROOM_SHOW, LIVE_FIRST_LIKE_MSG_SEND, LIVE_FOLLOW_GUIDE_CLICK, LIVE_PREPARE, LIVE_LOADING, LIVE_INTERRUPT, LIVE_APPLY_PREPARE, LIVE_ACTIVITY_LINK_CLICK, LIVE_START_FROM_LIVELIST, LIVE_GIFT_PAGE, 
          LIVE_START_SHARE_FEED, LIVE_ROOM_CLICK, LIVE_GIFT_PAGE_GIFT_SHOW, LIVE_GIFT_PAGE_GIFT_CLICK, LIVE_GIFT_PAGE_SEND_CLICK, BETTER_ID_POP_SHOW, BETTER_ID_POP_CLOSE_CLICK, BETTER_ID_POP_LOOK_CLICK, BETTER_ID_POP_CHOOSE_CLICK, BETTER_ID_MY_PROFILE_BATTER_CLICK, 
          BETTER_ID_OTHER_PROFILE_BATTER_CLICK, BETTER_ID_ANCHOR_POP_BATTER_CLICK, BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK, BETTER_ID_USER_POP_BATTER_CLICK, BETTER_ID_USER_PHOTO_BATTER_CLICK, USER_PROFILE_FOLLOW_BTN_CLICK, LIVE_USER_MSG_SEND, LIVE_ACTIVITY_RESOURCE_SHOW, LIVE_ACTIVITY_RESOURCE_CLICK, LIVE_ENTER_SUCCESS, 
          LIVE_LEAVE_SUCCESS, BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK, BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK, BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK, BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK, BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK, LIVE_KISS_POP_SHOW, LIVE_KISS_BTN_CLICK, LIVE_KISS_PURCHASE_COMPLETE_SHOW, LIVE_KISS_RETURN_CLICK, 
          LIVE_KISS_INSUFFICIENT_SHOW, LIVE_KISS_SURROUNDING_AREA_CLICK, LIVE_KISS_AUTO_RETURN_CLICK, LIVE_PK_AUDIENCE_DURATION, LIVE_PK_AUDIENCE_SEAT_CLICK, LIVE_PK_ICON_CLICK, LIVE_PK_RANK_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public LiveProtos.Event findValueByNumber(int param2Int) {
            return LiveProtos.Event.forNumber(param2Int);
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
        case 242:
          return LIVE_PK_RANK_CLICK;
        case 241:
          return LIVE_PK_ICON_CLICK;
        case 240:
          return LIVE_PK_AUDIENCE_SEAT_CLICK;
        case 239:
          return LIVE_PK_AUDIENCE_DURATION;
        case 238:
          return LIVE_KISS_AUTO_RETURN_CLICK;
        case 237:
          return LIVE_KISS_SURROUNDING_AREA_CLICK;
        case 236:
          return LIVE_KISS_INSUFFICIENT_SHOW;
        case 235:
          return LIVE_KISS_RETURN_CLICK;
        case 234:
          return LIVE_KISS_PURCHASE_COMPLETE_SHOW;
        case 233:
          return LIVE_KISS_BTN_CLICK;
        case 232:
          return LIVE_KISS_POP_SHOW;
        case 231:
          return BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK;
        case 230:
          return BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK;
        case 229:
          return BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK;
        case 228:
          return BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK;
        case 227:
          return BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK;
        case 226:
          return LIVE_LEAVE_SUCCESS;
        case 225:
          return LIVE_ENTER_SUCCESS;
        case 224:
          return LIVE_ACTIVITY_RESOURCE_CLICK;
        case 223:
          return LIVE_ACTIVITY_RESOURCE_SHOW;
        case 222:
          return LIVE_USER_MSG_SEND;
        case 221:
          return USER_PROFILE_FOLLOW_BTN_CLICK;
        case 220:
          return BETTER_ID_USER_PHOTO_BATTER_CLICK;
        case 219:
          return BETTER_ID_USER_POP_BATTER_CLICK;
        case 218:
          return BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK;
        case 217:
          return BETTER_ID_ANCHOR_POP_BATTER_CLICK;
        case 216:
          return BETTER_ID_OTHER_PROFILE_BATTER_CLICK;
        case 215:
          return BETTER_ID_MY_PROFILE_BATTER_CLICK;
        case 214:
          return BETTER_ID_POP_CHOOSE_CLICK;
        case 213:
          return BETTER_ID_POP_LOOK_CLICK;
        case 212:
          return BETTER_ID_POP_CLOSE_CLICK;
        case 211:
          return BETTER_ID_POP_SHOW;
        case 210:
          return LIVE_GIFT_PAGE_SEND_CLICK;
        case 209:
          return LIVE_GIFT_PAGE_GIFT_CLICK;
        case 208:
          return LIVE_GIFT_PAGE_GIFT_SHOW;
        case 207:
          return LIVE_ROOM_CLICK;
        case 206:
          return LIVE_START_SHARE_FEED;
        case 205:
          return LIVE_GIFT_PAGE;
        case 204:
          return LIVE_START_FROM_LIVELIST;
        case 203:
          return LIVE_ACTIVITY_LINK_CLICK;
        case 202:
          return LIVE_APPLY_PREPARE;
        case 201:
          return LIVE_INTERRUPT;
        case 200:
          return LIVE_LOADING;
        case 199:
          return LIVE_PREPARE;
        case 198:
          return LIVE_FOLLOW_GUIDE_CLICK;
        case 197:
          return LIVE_FIRST_LIKE_MSG_SEND;
        case 196:
          return LIVE_ROOM_SHOW;
        case 195:
          return RED_BAG_GET_POP_CANCEL_CLICK;
        case 194:
          return RED_BAG_GET_POP_CONFIRM_CLICK;
        case 193:
          return RED_BAG_GET_POP_SHOW;
        case 192:
          return RED_BAG_GET_SUCCESS;
        case 191:
          return RED_BAG_SEND_BTN_CLICK;
        case 190:
          return LIVE_MUSIC_DONE;
        case 189:
          return LIVE_MUSIC_CHANGE;
        case 188:
          return LIVE_FOLLOWED_GRID_RECOMMEND_REFRESH_CLICK;
        case 187:
          return LIVE_FOLLOWED_GRID_RECOMMEND_CLICK;
        case 186:
          return LIVE_FOLLOWED_GRID_RECOMMEND_SHOW;
        case 185:
          return LIVE_CONNECT_TIME;
        case 184:
          return LIVE_MANAGE_BTN_CLICK;
        case 183:
          return LIVE_MUSIC_SEARCH_CLICK;
        case 182:
          return LIVE_MUSIC_TAB_PAGE_SHOW;
        case 181:
          return LIVE_MUSIC_EXIT_CLICK;
        case 180:
          return LIVE_MUSIC_STOP_CLICK;
        case 179:
          return LIVE_MUSIC_PLAY_CLICK;
        case 178:
          return LIVE_MUSIC_COLLECT_CLICK;
        case 177:
          return LIVE_RECOMMEND_CLICK;
        case 176:
          return LIVE_RECOMMEND_SHOW;
        case 175:
          return PK_LIVE_PROFILE_FOLLOW_BTN_CLICK;
        case 174:
          return PK_LIVE_PROFILE_FOLLOW_BTN_SHOW;
        case 173:
          return LIVE_USER_PROFILE_MANAGE_MUTE_ALL_CLICK;
        case 172:
          return LIVE_USER_PROFILE_MANAGE_MUTE_ONE_CLICK;
        case 171:
          return LIVE_USER_PROFILE_MANAGE_CONTROL_CLICK;
        case 170:
          return LIVE_USER_PROFILE_MANAGE_CLICK;
        case 169:
          return LIVE_MYSTERY_ANSWER_CLICK;
        case 168:
          return LIVE_MYSTERY_ANSWER_SHOW;
        case 167:
          return MYSTERY_ASK_WHO_ANSWER_SEND_CLICK;
        case 166:
          return MYSTERY_ASK_WHO_CLICK;
        case 165:
          return MYSTERY_ASK_WHO_SHOW;
        case 164:
          return LIVE_ANSWER_WHO_CLICK;
        case 163:
          return LIVE_MYSTERY_PROFILE_ASK_WHO_CLICK;
        case 162:
          return LIVE_MYSTERY_PROFILE_AT_CLICK;
        case 161:
          return LIVE_MYSTERY_PROFILE_SHOW;
        case 160:
          return LIVE_MYSTERY_BTN_CLICK;
        case 159:
          return LIVE_SLIDE;
        case 158:
          return LIVE_TASK_NEW_KING_CLICK;
        case 157:
          return LIVE_TASK_NEW_KING_SHOW;
        case 156:
          return LIVE_TASK_COLLECTION_PAGE_CLICK;
        case 155:
          return LIVE_TASK_COLLECTION_PAGE_SHOW;
        case 154:
          return LIVE_TASK_FOLLOW_CLICK;
        case 153:
          return LIVE_TASK_SEND_GIFT_CLICK;
        case 152:
          return LIVE_TASK_GET_CLICK;
        case 151:
          return LIVE_TASK_ENTER_CLICK;
        case 150:
          return LIVE_TASK_ENTER_SHOW;
        case 149:
          return LIVE_PRE_TOP_CARD_GET_CLICK;
        case 148:
          return LIVE_PRE_TOP_CARD_POP_SHOW;
        case 147:
          return LIVE_FEATURE_BOX_TOP_CARD_USE_CLICK;
        case 146:
          return LIVE_FEATURE_BOX_TOP_CARD_TOAST_SHOW;
        case 145:
          return ANCHOR_MATCH_SUCCESS_POP_SHOW;
        case 144:
          return GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK;
        case 143:
          return GUEST_MATCH_SUCCESS_POP_SHOW;
        case 142:
          return GUEST_PHOTO_UPLOAD;
        case 141:
          return GUEST_SHOW_PHOTO_CLICK;
        case 140:
          return GUEST_LIGHT_OFF_CLICK;
        case 139:
          return GUEST_CLOSE_MIKE_CLICK;
        case 138:
          return GUEST_HANG_UP_CLICK;
        case 137:
          return USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK;
        case 136:
          return USER_END_PAGE_RECOMMEND_ROOM_CLICK;
        case 135:
          return USER_END_PAGE_RECOMMEND_ROOM_SHOW;
        case 134:
          return USER_CONTRIBUTION_LIST_USER_CLICK;
        case 133:
          return USER_CONTRIBUTION_LIST_USER_SHOW;
        case 132:
          return USER_MIKE_USER_PHOTO_CARD_CLICK;
        case 131:
          return USER_MIKE_USER_PHOTO_DOUBLE_CLICK;
        case 130:
          return USER_MIKE_USER_PHOTO_CLICK;
        case 129:
          return USER_MIKE_USER_PHOTO_SHOW;
        case 128:
          return USER_LIVE_GIFT_BTN_CLICK;
        case 127:
          return GUEST_USER_GIFT_CLICK;
        case 126:
          return USER_RECHARGE_CLICK;
        case 125:
          return GUEST_USER_KEYBOARD_CLICK;
        case 124:
          return USER_SHARE_CLICK;
        case 123:
          return USER_ANCHOR_FOLLOW_BTN_CLICK;
        case 122:
          return USER_START_MIKE_CLICK;
        case 121:
          return USER_CANCEL_MIKE_CLICK;
        case 120:
          return USER_CONNECT_APPLY_TO_PICK_CLICK;
        case 119:
          return USER_CONNECT_APPLY_BE_PICKED_CLICK;
        case 118:
          return USER_CONNECT_APPLY_CLICK;
        case 117:
          return ANCHOR_END_PAGE_CONFIRM_CLICK;
        case 116:
          return ANCHOR_END_PAGE_EXPERIENCE_QUESTION_CLICK;
        case 115:
          return ANCHOR_END_PAGE_RECORD_SHARE_CLICK;
        case 114:
          return ANCHOR_END_PAGE_SHOW;
        case 113:
          return ANCHOR_MIKE_MANAGE_IGNORE_CLICK;
        case 112:
          return ANCHOR_MIKE_MANAGE_CONFIRM_CLICK;
        case 111:
          return ANCHOR_MIKE_MANAGE_TO_PICK_CLICK;
        case 110:
          return ANCHOR_MIKE_MANAGE_BE_PICKED_CLICK;
        case 109:
          return ANCHOR_MIKE_MANAGE_CLICK;
        case 108:
          return ANCHOR_FEATURE_CLICK;
        case 107:
          return ANCHOR_RENEW_BTN_CLICK;
        case 106:
          return ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK;
        case 105:
          return ANCHOR_MATCH_SUCCESS_CLICK;
        case 104:
          return USER_CONTRIBUTION_LIST_CLICK;
        case 103:
          return ANCHOR_SETTING_BLIND_DATING_CLICK;
        case 102:
          return ANCHOR_SETTING_START_CLICK;
        case 101:
          return LIVE_STICKERS_PAGE_SHOW;
        case 100:
          return LIVE_RECOMMEND_PAGE_SHOW;
        case 99:
          return LIVE_RECHARGE_HUABAI_CLICK;
        case 98:
          return LIVE_SOAR_PAGE_SHOW;
        case 97:
          return LIVE_HOT_PAGE_SHOW;
        case 96:
          return LIVE_APPLY_ANCHOR_PAGE_SHOW;
        case 95:
          return LIVE_GLOW_STICK_TOAST_CLICK;
        case 94:
          return LIVE_GLOW_STICK_TOAST_SHOW;
        case 93:
          return LIVE_TODAY_WELFARE_TOAST_CLICK;
        case 92:
          return LIVE_TODAY_WELFARE_TOAST_SHOW;
        case 91:
          return LIVE_FANS_RENEW_TOAST_CLICK;
        case 90:
          return LIVE_FANS_RENEW_TOAST_SHOW;
        case 89:
          return LIVE_HOME_REFRESH_IMAGE_SHOW;
        case 88:
          return LIVE_SEND_FANS_CLUB_TICKET;
        case 87:
          return FANS_CLUB_MSG_CLICK;
        case 86:
          return FANS_CLUB_MSG_SHOW;
        case 85:
          return FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK;
        case 84:
          return FANS_CLUB_PAGE_JOIN_PAGE_SHOW;
        case 83:
          return FANS_CLUB_PAGE_FANS_LIST_PAGE_SHOW;
        case 82:
          return FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK;
        case 81:
          return FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW;
        case 80:
          return FANS_CLUB_PAGE_NO_FIVE_PAGE_WANDOU_CLICK;
        case 79:
          return FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK;
        case 78:
          return FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW;
        case 77:
          return FANS_CLUB_PAGE_ALL_LIST_USER_CLICK;
        case 76:
          return FANS_CLUB_PAGE_TODAY_LIST_USER_CLICK;
        case 75:
          return FANS_CLUB_PAGE_ACTIVE_LIST_USER_CLICK;
        case 74:
          return FANS_CLUB_PAGE_QA_CLICK;
        case 73:
          return FANS_CLUB_PAGE_ALL_CLICK;
        case 72:
          return FANS_CLUB_PAGE_TODAY_CLICK;
        case 71:
          return FANS_CLUB_PAGE_ACTIVE_CLICK;
        case 70:
          return FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK;
        case 69:
          return FANS_CLUB_PAGE_EDIT_NAME_CLICK;
        case 68:
          return LIVE_FANS_CLUB_BTN_CLICK;
        case 67:
          return FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK;
        case 66:
          return FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW;
        case 65:
          return FANS_CLUB_PAGE_SHOW;
        case 64:
          return LIVE_REPORT_BTN_CLICK;
        case 63:
          return RECOMMEND_PAGE_MORE_BTN_CLICK;
        case 62:
          return RECOMMEND_PAGE_ENTER_BTN_CLICK;
        case 61:
          return RECOMMEND_PAGE_ROOM_SHOW;
        case 60:
          return LIVE_HOME_REFRESH_LIVE_ENTER;
        case 59:
          return LIVE_HOME_REFRESH_WORD_SHOW;
        case 58:
          return LIVE_HOT_FIRST_ROOM_CLICK;
        case 57:
          return LIVE_FAVORITE_FIRST_ROOM_CLICK;
        case 56:
          return LIVE_REDVERIFY_CONFIRM_RED_RESULT;
        case 55:
          return LIVE_REDVERIFY_CONFIRM;
        case 54:
          return LIVE_REDVERIFY_SHOW;
        case 53:
          return LIVE_WANDOU_NUM_CLICK;
        case 52:
          return LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK;
        case 51:
          return LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW;
        case 50:
          return FLASH_VIDEO_USER_LIVE_PHOTO_CLICK;
        case 49:
          return LIVE_HOT_SOAR_LIST_QA_CLICK;
        case 48:
          return LIVE_SOAR_LIST_GO_GOODS_CLICK;
        case 47:
          return LIVE_SOAR_LIST_CLICK;
        case 46:
          return LIVE_SOAR_LIST_SHOW;
        case 45:
          return LIVE_HOT_LIST_GO_GOODS_CLICK;
        case 44:
          return LIVE_HOT_LIST_CLICK;
        case 43:
          return LIVE_HOT_LIST_SHOW;
        case 42:
          return LIVE_NEW_MSG_CLICK;
        case 41:
          return LIVE_NEW_MSG_SHOW;
        case 40:
          return LIVE_END_PAGE_FOLLOW_BTN_CLICK;
        case 39:
          return LIVE_END_PAGE_FOLLOW_BTN_SHOW;
        case 34:
          return LIVE_TASK_AWARD_CLICK;
        case 33:
          return LIVE_TASK_BTN_CLICK;
        case 32:
          return LIVE_FEATURE_BOX_STICKER_CLICK;
        case 31:
          return LIVE_FEATURE_BOX_GESTURE_CLICK;
        case 30:
          return LIVE_FEATURE_BOX_CLICK;
        case 29:
          return LIVE_RANK_PRIVILEGE_CLICK;
        case 28:
          return LIVE_RANK_TASK_CLICK;
        case 27:
          return LIVE_EXPERIENCE_BAR_CLICK;
        case 26:
          return HOT_LIVE_H5_LINK_CLICK;
        case 25:
          return LIVE_GIFT_LEVEL_BAR_CLICK;
        case 24:
          return LIVE_RECHARGE_BTN_CLICK;
        case 23:
          return LIVE_EXIT_GUIDE_EXIT_BTN_CLICK;
        case 22:
          return LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK;
        case 21:
          return LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW;
        case 20:
          return LIVE_POP_PAY_LAYER_BTN_CLICK;
        case 18:
          return LIVE_POP_FIRST_PAY_LAYER_BTN_CLICK;
        case 16:
          return LIVE_PAY_BTN_CLICK;
        case 15:
          return LIVE_PAY_BTN_SHOW;
        case 14:
          return LIVE_VIEWERS_FIRST_PAY_BTN_CLICK;
        case 13:
          return LIVE_FILTER_USE;
        case 12:
          return LIVE_SETTING_TITLE_SAVE_BTN_CLICK;
        case 11:
          return LIVE_SETTING_TITLE_BTN_CLICK;
        case 10:
          return LIVE_SETTING_BEAUTY_BTN_CLICK;
        case 9:
          return LIVE_HOME_INTERACTIVE_AREA_CLICK;
        case 8:
          return LIVE_CLASSIFY_BTN_CLICK;
        case 7:
          return LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK;
        case 6:
          return LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK;
        case 5:
          return LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK;
        case 4:
          return LIVE_VIEWERS_FIRST_PAY_BTN_SHOW;
        case 3:
          return LIVE_VIEWERS_FIRST_PAY_JOIN_BTN_CLICK;
        case 2:
          return LIVE_VIEWERS_GIFT_BTN_CLICK;
        case 1:
          return START_LIVE_BEAUTY_BTN_CLICK;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(0);
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
    public LiveProtos.Event findValueByNumber(int param1Int) {
      return LiveProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum FirstPayStatus implements ProtocolMessageEnum {
    PAY(0),
    RECEIVE(0),
    UNKNOWN_FIRST_PAY_STATUS(0),
    UNRECOGNIZED(0);
    
    public static final int PAY_VALUE = 2;
    
    public static final int RECEIVE_VALUE = 1;
    
    public static final int UNKNOWN_FIRST_PAY_STATUS_VALUE = 0;
    
    private static final FirstPayStatus[] VALUES;
    
    private static final Internal.EnumLiteMap<FirstPayStatus> internalValueMap;
    
    private final int value;
    
    static {
      PAY = new FirstPayStatus("PAY", 2, 2);
      UNRECOGNIZED = new FirstPayStatus("UNRECOGNIZED", 3, -1);
      $VALUES = new FirstPayStatus[] { UNKNOWN_FIRST_PAY_STATUS, RECEIVE, PAY, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FirstPayStatus>() {
          public LiveProtos.FirstPayStatus findValueByNumber(int param2Int) {
            return LiveProtos.FirstPayStatus.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FirstPayStatus(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FirstPayStatus forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : PAY) : RECEIVE) : UNKNOWN_FIRST_PAY_STATUS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<FirstPayStatus> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FirstPayStatus> {
    public LiveProtos.FirstPayStatus findValueByNumber(int param1Int) {
      return LiveProtos.FirstPayStatus.forNumber(param1Int);
    }
  }
  
  public enum FollowStatus implements ProtocolMessageEnum {
    BE_FOLLOWED_STATUS(0),
    EACH_FOLLOW_STATUS(0),
    FOLLOWED_EACH(0),
    FOLLOWED_HIM(0),
    FOLLOWED_STATUS(0),
    FOLLOW_BLACK(0),
    FOLLOW_ME(0),
    TO_FOLLOW(0),
    TO_FOLLOW_STATUS(0),
    UNKNOWN_FOLLOW_STATUS(0),
    UNRECOGNIZED(0);
    
    public static final int BE_FOLLOWED_STATUS_VALUE = 9;
    
    public static final int EACH_FOLLOW_STATUS_VALUE = 8;
    
    public static final int FOLLOWED_EACH_VALUE = 4;
    
    public static final int FOLLOWED_HIM_VALUE = 2;
    
    public static final int FOLLOWED_STATUS_VALUE = 7;
    
    public static final int FOLLOW_BLACK_VALUE = 5;
    
    public static final int FOLLOW_ME_VALUE = 3;
    
    public static final int TO_FOLLOW_STATUS_VALUE = 6;
    
    public static final int TO_FOLLOW_VALUE = 1;
    
    public static final int UNKNOWN_FOLLOW_STATUS_VALUE = 0;
    
    private static final FollowStatus[] VALUES;
    
    private static final Internal.EnumLiteMap<FollowStatus> internalValueMap;
    
    private final int value;
    
    static {
      FOLLOWED_HIM = new FollowStatus("FOLLOWED_HIM", 2, 2);
      FOLLOW_ME = new FollowStatus("FOLLOW_ME", 3, 3);
      FOLLOWED_EACH = new FollowStatus("FOLLOWED_EACH", 4, 4);
      FOLLOW_BLACK = new FollowStatus("FOLLOW_BLACK", 5, 5);
      TO_FOLLOW_STATUS = new FollowStatus("TO_FOLLOW_STATUS", 6, 6);
      FOLLOWED_STATUS = new FollowStatus("FOLLOWED_STATUS", 7, 7);
      EACH_FOLLOW_STATUS = new FollowStatus("EACH_FOLLOW_STATUS", 8, 8);
      BE_FOLLOWED_STATUS = new FollowStatus("BE_FOLLOWED_STATUS", 9, 9);
      UNRECOGNIZED = new FollowStatus("UNRECOGNIZED", 10, -1);
      $VALUES = new FollowStatus[] { 
          UNKNOWN_FOLLOW_STATUS, TO_FOLLOW, FOLLOWED_HIM, FOLLOW_ME, FOLLOWED_EACH, FOLLOW_BLACK, TO_FOLLOW_STATUS, FOLLOWED_STATUS, EACH_FOLLOW_STATUS, BE_FOLLOWED_STATUS, 
          UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FollowStatus>() {
          public LiveProtos.FollowStatus findValueByNumber(int param2Int) {
            return LiveProtos.FollowStatus.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FollowStatus(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FollowStatus forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 9:
          return BE_FOLLOWED_STATUS;
        case 8:
          return EACH_FOLLOW_STATUS;
        case 7:
          return FOLLOWED_STATUS;
        case 6:
          return TO_FOLLOW_STATUS;
        case 5:
          return FOLLOW_BLACK;
        case 4:
          return FOLLOWED_EACH;
        case 3:
          return FOLLOW_ME;
        case 2:
          return FOLLOWED_HIM;
        case 1:
          return TO_FOLLOW;
        case 0:
          break;
      } 
      return UNKNOWN_FOLLOW_STATUS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(9);
    }
    
    public static Internal.EnumLiteMap<FollowStatus> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FollowStatus> {
    public LiveProtos.FollowStatus findValueByNumber(int param1Int) {
      return LiveProtos.FollowStatus.forNumber(param1Int);
    }
  }
  
  public enum GiftStatus implements ProtocolMessageEnum {
    NOT_PAY_REMAIN(0),
    NOT_PAY_SELL_OUT(0),
    PAY_REMAIN(0),
    UNKNOWN_BTN_STATUS(0),
    UNRECOGNIZED(0);
    
    public static final int NOT_PAY_REMAIN_VALUE = 1;
    
    public static final int NOT_PAY_SELL_OUT_VALUE = 2;
    
    public static final int PAY_REMAIN_VALUE = 3;
    
    public static final int UNKNOWN_BTN_STATUS_VALUE = 0;
    
    private static final GiftStatus[] VALUES;
    
    private static final Internal.EnumLiteMap<GiftStatus> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new GiftStatus[] { UNKNOWN_BTN_STATUS, NOT_PAY_REMAIN, NOT_PAY_SELL_OUT, PAY_REMAIN, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<GiftStatus>() {
          public LiveProtos.GiftStatus findValueByNumber(int param2Int) {
            return LiveProtos.GiftStatus.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    GiftStatus(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static GiftStatus forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : PAY_REMAIN) : NOT_PAY_SELL_OUT) : NOT_PAY_REMAIN) : UNKNOWN_BTN_STATUS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<GiftStatus> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<GiftStatus> {
    public LiveProtos.GiftStatus findValueByNumber(int param1Int) {
      return LiveProtos.GiftStatus.forNumber(param1Int);
    }
  }
  
  public static final class LiveProto extends GeneratedMessageV3 implements LiveProtoOrBuilder {
    public static final int AWARDTYPE_FIELD_NUMBER = 15;
    
    public static final int BEANS_COUNT_FIELD_NUMBER = 25;
    
    public static final int BEANS_NUM_FIELD_NUMBER = 26;
    
    public static final int BOX_TYPE_FIELD_NUMBER = 13;
    
    public static final int BTN_TYPE_FIELD_NUMBER = 21;
    
    public static final int CARD_FROM_FIELD_NUMBER = 37;
    
    public static final int CONDITION_FIELD_NUMBER = 45;
    
    public static final int COUNT_FIELD_NUMBER = 16;
    
    private static final LiveProto DEFAULT_INSTANCE = new LiveProto();
    
    public static final int ENTER_TYPE_FIELD_NUMBER = 3;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FEATURE_ID_FIELD_NUMBER = 12;
    
    public static final int FILTER_ID_FIELD_NUMBER = 5;
    
    public static final int FIRST_PAY_STATUS_FIELD_NUMBER = 7;
    
    public static final int FOLLOWED_UID_FIELD_NUMBER = 52;
    
    public static final int FOLLOW_STATUS_FIELD_NUMBER = 17;
    
    public static final int FROM_FIELD_NUMBER = 54;
    
    public static final int GIFT_STATUS_FIELD_NUMBER = 2;
    
    public static final int GOODS_ID_FIELD_NUMBER = 31;
    
    public static final int GUEST_UID_FIELD_NUMBER = 33;
    
    public static final int ID_FIELD_NUMBER = 50;
    
    public static final int IS_AUTO_FIELD_NUMBER = 6;
    
    public static final int IS_HIT_TIME_FIELD_NUMBER = 55;
    
    public static final int IS_JOIN_FIELD_NUMBER = 20;
    
    public static final int IS_MYSTERY_FIELD_NUMBER = 40;
    
    public static final int IS_OPEN_FIELD_NUMBER = 38;
    
    public static final int IS_PK_FIELD_NUMBER = 56;
    
    public static final int IS_QUEUE_FIELD_NUMBER = 36;
    
    public static final int IS_SUCCESS_FIELD_NUMBER = 18;
    
    public static final int LIKE_COUNT_FIELD_NUMBER = 28;
    
    public static final int LIVE_DURATION_FIELD_NUMBER = 30;
    
    public static final int LIVE_FROM_FIELD_NUMBER = 39;
    
    public static final int LIVE_FROM_NUM_FIELD_NUMBER = 51;
    
    public static final int LIVE_ID_FIELD_NUMBER = 9;
    
    public static final int LIVE_TAB_FIELD_NUMBER = 46;
    
    public static final int LIVE_TYPE_FIELD_NUMBER = 24;
    
    public static final int LIVE_TYPE_ID_FIELD_NUMBER = 19;
    
    public static final int MUSIC_ID_FIELD_NUMBER = 42;
    
    public static final int MYSTERY_UID_FIELD_NUMBER = 41;
    
    public static final int NUM_FIELD_NUMBER = 32;
    
    public static final int ONLINE_COUNT_FIELD_NUMBER = 29;
    
    public static final int PAGE_NUM_FIELD_NUMBER = 49;
    
    private static final Parser<LiveProto> PARSER = (Parser<LiveProto>)new AbstractParser<LiveProto>() {
        public LiveProtos.LiveProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveProtos.LiveProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PASSWORD_FIELD_NUMBER = 44;
    
    public static final int PAY_STATUS_FIELD_NUMBER = 8;
    
    public static final int POSITION_FIELD_NUMBER = 47;
    
    public static final int RECOMMEND_LIVE_ID_FIELD_NUMBER = 34;
    
    public static final int RECOMMEND_TYPE_FIELD_NUMBER = 53;
    
    public static final int RECOMMEND_UID_FIELD_NUMBER = 35;
    
    public static final int SOURCE_FIELD_NUMBER = 22;
    
    public static final int STATUS_FIELD_NUMBER = 4;
    
    public static final int TAB_ID_FIELD_NUMBER = 43;
    
    public static final int TAB_NUM_FIELD_NUMBER = 48;
    
    public static final int TARGET_UID_FIELD_NUMBER = 11;
    
    public static final int TASKTYPE_FIELD_NUMBER = 14;
    
    public static final int TASK_ID_FIELD_NUMBER = 23;
    
    public static final int URL_FIELD_NUMBER = 10;
    
    public static final int VIEW_COUNT_FIELD_NUMBER = 27;
    
    private static final long serialVersionUID = 0L;
    
    private int awardType_;
    
    private int beansCount_;
    
    private int beansNum_;
    
    private int boxType_;
    
    private int btnType_;
    
    private int cardFrom_;
    
    private int condition_;
    
    private int count_;
    
    private int enterType_;
    
    private int event_;
    
    private volatile Object featureId_;
    
    private volatile Object filterId_;
    
    private int firstPayStatus_;
    
    private int followStatus_;
    
    private volatile Object followedUid_;
    
    private volatile Object from_;
    
    private int giftStatus_;
    
    private volatile Object goodsId_;
    
    private volatile Object guestUid_;
    
    private volatile Object id_;
    
    private boolean isAuto_;
    
    private boolean isHitTime_;
    
    private boolean isJoin_;
    
    private boolean isMystery_;
    
    private boolean isOpen_;
    
    private boolean isPk_;
    
    private boolean isQueue_;
    
    private boolean isSuccess_;
    
    private int likeCount_;
    
    private int liveDuration_;
    
    private int liveFromNum_;
    
    private volatile Object liveFrom_;
    
    private volatile Object liveId_;
    
    private volatile Object liveTab_;
    
    private volatile Object liveTypeId_;
    
    private int liveType_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object musicId_;
    
    private volatile Object mysteryUid_;
    
    private int num_;
    
    private int onlineCount_;
    
    private int pageNum_;
    
    private volatile Object password_;
    
    private int payStatus_;
    
    private int position_;
    
    private volatile Object recommendLiveId_;
    
    private volatile Object recommendType_;
    
    private volatile Object recommendUid_;
    
    private int source_;
    
    private int status_;
    
    private volatile Object tabId_;
    
    private int tabNum_;
    
    private volatile Object targetUid_;
    
    private volatile Object taskId_;
    
    private int taskType_;
    
    private volatile Object url_;
    
    private int viewCount_;
    
    private LiveProto() {
      this.event_ = 0;
      this.giftStatus_ = 0;
      this.enterType_ = 0;
      this.status_ = 0;
      this.filterId_ = "";
      this.firstPayStatus_ = 0;
      this.payStatus_ = 0;
      this.liveId_ = "";
      this.url_ = "";
      this.targetUid_ = "";
      this.featureId_ = "";
      this.boxType_ = 0;
      this.taskType_ = 0;
      this.awardType_ = 0;
      this.followStatus_ = 0;
      this.liveTypeId_ = "";
      this.btnType_ = 0;
      this.source_ = 0;
      this.taskId_ = "";
      this.liveType_ = 0;
      this.goodsId_ = "";
      this.guestUid_ = "";
      this.recommendLiveId_ = "";
      this.recommendUid_ = "";
      this.cardFrom_ = 0;
      this.liveFrom_ = "";
      this.mysteryUid_ = "";
      this.musicId_ = "";
      this.tabId_ = "";
      this.password_ = "";
      this.liveTab_ = "";
      this.id_ = "";
      this.followedUid_ = "";
      this.recommendType_ = "";
      this.from_ = "";
    }
    
    private LiveProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 448:
                this.isPk_ = param1CodedInputStream.readBool();
                continue;
              case 440:
                this.isHitTime_ = param1CodedInputStream.readBool();
                continue;
              case 434:
                this.from_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 426:
                this.recommendType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 418:
                this.followedUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 408:
                this.liveFromNum_ = param1CodedInputStream.readInt32();
                continue;
              case 402:
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 392:
                this.pageNum_ = param1CodedInputStream.readInt32();
                continue;
              case 384:
                this.tabNum_ = param1CodedInputStream.readInt32();
                continue;
              case 376:
                this.position_ = param1CodedInputStream.readInt32();
                continue;
              case 370:
                this.liveTab_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 360:
                this.condition_ = param1CodedInputStream.readInt32();
                continue;
              case 354:
                this.password_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 346:
                this.tabId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 338:
                this.musicId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 330:
                this.mysteryUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 320:
                this.isMystery_ = param1CodedInputStream.readBool();
                continue;
              case 314:
                this.liveFrom_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 304:
                this.isOpen_ = param1CodedInputStream.readBool();
                continue;
              case 296:
                this.cardFrom_ = param1CodedInputStream.readEnum();
                continue;
              case 288:
                this.isQueue_ = param1CodedInputStream.readBool();
                continue;
              case 282:
                this.recommendUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 274:
                this.recommendLiveId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 266:
                this.guestUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 256:
                this.num_ = param1CodedInputStream.readInt32();
                continue;
              case 250:
                this.goodsId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 240:
                this.liveDuration_ = param1CodedInputStream.readInt32();
                continue;
              case 232:
                this.onlineCount_ = param1CodedInputStream.readInt32();
                continue;
              case 224:
                this.likeCount_ = param1CodedInputStream.readInt32();
                continue;
              case 216:
                this.viewCount_ = param1CodedInputStream.readInt32();
                continue;
              case 208:
                this.beansNum_ = param1CodedInputStream.readInt32();
                continue;
              case 200:
                this.beansCount_ = param1CodedInputStream.readInt32();
                continue;
              case 192:
                this.liveType_ = param1CodedInputStream.readEnum();
                continue;
              case 186:
                this.taskId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 176:
                this.source_ = param1CodedInputStream.readEnum();
                continue;
              case 168:
                this.btnType_ = param1CodedInputStream.readEnum();
                continue;
              case 160:
                this.isJoin_ = param1CodedInputStream.readBool();
                continue;
              case 154:
                this.liveTypeId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 144:
                this.isSuccess_ = param1CodedInputStream.readBool();
                continue;
              case 136:
                this.followStatus_ = param1CodedInputStream.readEnum();
                continue;
              case 128:
                this.count_ = param1CodedInputStream.readInt32();
                continue;
              case 120:
                this.awardType_ = param1CodedInputStream.readEnum();
                continue;
              case 112:
                this.taskType_ = param1CodedInputStream.readEnum();
                continue;
              case 104:
                this.boxType_ = param1CodedInputStream.readEnum();
                continue;
              case 98:
                this.featureId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 90:
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 82:
                this.url_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 74:
                this.liveId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 64:
                this.payStatus_ = param1CodedInputStream.readEnum();
                continue;
              case 56:
                this.firstPayStatus_ = param1CodedInputStream.readEnum();
                continue;
              case 48:
                this.isAuto_ = param1CodedInputStream.readBool();
                continue;
              case 42:
                this.filterId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 32:
                this.status_ = param1CodedInputStream.readEnum();
                continue;
              case 24:
                this.enterType_ = param1CodedInputStream.readEnum();
                continue;
              case 16:
                this.giftStatus_ = param1CodedInputStream.readEnum();
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
    
    private LiveProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveProtos.internal_static_com_blued_das_live_LiveProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveProto param1LiveProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveProto);
    }
    
    public static LiveProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveProto parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((LiveProto)param1Object).event_) ? false : ((this.giftStatus_ != ((LiveProto)param1Object).giftStatus_) ? false : ((this.enterType_ != ((LiveProto)param1Object).enterType_) ? false : ((this.status_ != ((LiveProto)param1Object).status_) ? false : (!getFilterId().equals(param1Object.getFilterId()) ? false : ((getIsAuto() != param1Object.getIsAuto()) ? false : ((this.firstPayStatus_ != ((LiveProto)param1Object).firstPayStatus_) ? false : ((this.payStatus_ != ((LiveProto)param1Object).payStatus_) ? false : (!getLiveId().equals(param1Object.getLiveId()) ? false : (!getUrl().equals(param1Object.getUrl()) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : (!getFeatureId().equals(param1Object.getFeatureId()) ? false : ((this.boxType_ != ((LiveProto)param1Object).boxType_) ? false : ((this.taskType_ != ((LiveProto)param1Object).taskType_) ? false : ((this.awardType_ != ((LiveProto)param1Object).awardType_) ? false : ((getCount() != param1Object.getCount()) ? false : ((this.followStatus_ != ((LiveProto)param1Object).followStatus_) ? false : ((getIsSuccess() != param1Object.getIsSuccess()) ? false : (!getLiveTypeId().equals(param1Object.getLiveTypeId()) ? false : ((getIsJoin() != param1Object.getIsJoin()) ? false : ((this.btnType_ != ((LiveProto)param1Object).btnType_) ? false : ((this.source_ != ((LiveProto)param1Object).source_) ? false : (!getTaskId().equals(param1Object.getTaskId()) ? false : ((this.liveType_ != ((LiveProto)param1Object).liveType_) ? false : ((getBeansCount() != param1Object.getBeansCount()) ? false : ((getBeansNum() != param1Object.getBeansNum()) ? false : ((getViewCount() != param1Object.getViewCount()) ? false : ((getLikeCount() != param1Object.getLikeCount()) ? false : ((getOnlineCount() != param1Object.getOnlineCount()) ? false : ((getLiveDuration() != param1Object.getLiveDuration()) ? false : (!getGoodsId().equals(param1Object.getGoodsId()) ? false : ((getNum() != param1Object.getNum()) ? false : (!getGuestUid().equals(param1Object.getGuestUid()) ? false : (!getRecommendLiveId().equals(param1Object.getRecommendLiveId()) ? false : (!getRecommendUid().equals(param1Object.getRecommendUid()) ? false : ((getIsQueue() != param1Object.getIsQueue()) ? false : ((this.cardFrom_ != ((LiveProto)param1Object).cardFrom_) ? false : ((getIsOpen() != param1Object.getIsOpen()) ? false : (!getLiveFrom().equals(param1Object.getLiveFrom()) ? false : ((getIsMystery() != param1Object.getIsMystery()) ? false : (!getMysteryUid().equals(param1Object.getMysteryUid()) ? false : (!getMusicId().equals(param1Object.getMusicId()) ? false : (!getTabId().equals(param1Object.getTabId()) ? false : (!getPassword().equals(param1Object.getPassword()) ? false : ((getCondition() != param1Object.getCondition()) ? false : (!getLiveTab().equals(param1Object.getLiveTab()) ? false : ((getPosition() != param1Object.getPosition()) ? false : ((getTabNum() != param1Object.getTabNum()) ? false : ((getPageNum() != param1Object.getPageNum()) ? false : (!getId().equals(param1Object.getId()) ? false : ((getLiveFromNum() != param1Object.getLiveFromNum()) ? false : (!getFollowedUid().equals(param1Object.getFollowedUid()) ? false : (!getRecommendType().equals(param1Object.getRecommendType()) ? false : (!getFrom().equals(param1Object.getFrom()) ? false : ((getIsHitTime() != param1Object.getIsHitTime()) ? false : ((getIsPk() != param1Object.getIsPk()) ? false : (!!this.unknownFields.equals(((LiveProto)param1Object).unknownFields)))))))))))))))))))))))))))))))))))))))))))))))))))))))));
    }
    
    public LiveProtos.AwardType getAwardType() {
      LiveProtos.AwardType awardType2 = LiveProtos.AwardType.valueOf(this.awardType_);
      LiveProtos.AwardType awardType1 = awardType2;
      if (awardType2 == null)
        awardType1 = LiveProtos.AwardType.UNRECOGNIZED; 
      return awardType1;
    }
    
    public int getAwardTypeValue() {
      return this.awardType_;
    }
    
    public int getBeansCount() {
      return this.beansCount_;
    }
    
    public int getBeansNum() {
      return this.beansNum_;
    }
    
    public LiveProtos.BoxType getBoxType() {
      LiveProtos.BoxType boxType2 = LiveProtos.BoxType.valueOf(this.boxType_);
      LiveProtos.BoxType boxType1 = boxType2;
      if (boxType2 == null)
        boxType1 = LiveProtos.BoxType.UNRECOGNIZED; 
      return boxType1;
    }
    
    public int getBoxTypeValue() {
      return this.boxType_;
    }
    
    public LiveProtos.BtnType getBtnType() {
      LiveProtos.BtnType btnType2 = LiveProtos.BtnType.valueOf(this.btnType_);
      LiveProtos.BtnType btnType1 = btnType2;
      if (btnType2 == null)
        btnType1 = LiveProtos.BtnType.UNRECOGNIZED; 
      return btnType1;
    }
    
    public int getBtnTypeValue() {
      return this.btnType_;
    }
    
    public LiveProtos.CardFrom getCardFrom() {
      LiveProtos.CardFrom cardFrom2 = LiveProtos.CardFrom.valueOf(this.cardFrom_);
      LiveProtos.CardFrom cardFrom1 = cardFrom2;
      if (cardFrom2 == null)
        cardFrom1 = LiveProtos.CardFrom.UNRECOGNIZED; 
      return cardFrom1;
    }
    
    public int getCardFromValue() {
      return this.cardFrom_;
    }
    
    public int getCondition() {
      return this.condition_;
    }
    
    public int getCount() {
      return this.count_;
    }
    
    public LiveProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public LiveProtos.EnterType getEnterType() {
      LiveProtos.EnterType enterType2 = LiveProtos.EnterType.valueOf(this.enterType_);
      LiveProtos.EnterType enterType1 = enterType2;
      if (enterType2 == null)
        enterType1 = LiveProtos.EnterType.UNRECOGNIZED; 
      return enterType1;
    }
    
    public int getEnterTypeValue() {
      return this.enterType_;
    }
    
    public LiveProtos.Event getEvent() {
      LiveProtos.Event event2 = LiveProtos.Event.valueOf(this.event_);
      LiveProtos.Event event1 = event2;
      if (event2 == null)
        event1 = LiveProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getFeatureId() {
      Object object = this.featureId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.featureId_ = object;
      return (String)object;
    }
    
    public ByteString getFeatureIdBytes() {
      Object object = this.featureId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.featureId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getFilterId() {
      Object object = this.filterId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.filterId_ = object;
      return (String)object;
    }
    
    public ByteString getFilterIdBytes() {
      Object object = this.filterId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.filterId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.FirstPayStatus getFirstPayStatus() {
      LiveProtos.FirstPayStatus firstPayStatus2 = LiveProtos.FirstPayStatus.valueOf(this.firstPayStatus_);
      LiveProtos.FirstPayStatus firstPayStatus1 = firstPayStatus2;
      if (firstPayStatus2 == null)
        firstPayStatus1 = LiveProtos.FirstPayStatus.UNRECOGNIZED; 
      return firstPayStatus1;
    }
    
    public int getFirstPayStatusValue() {
      return this.firstPayStatus_;
    }
    
    public LiveProtos.FollowStatus getFollowStatus() {
      LiveProtos.FollowStatus followStatus2 = LiveProtos.FollowStatus.valueOf(this.followStatus_);
      LiveProtos.FollowStatus followStatus1 = followStatus2;
      if (followStatus2 == null)
        followStatus1 = LiveProtos.FollowStatus.UNRECOGNIZED; 
      return followStatus1;
    }
    
    public int getFollowStatusValue() {
      return this.followStatus_;
    }
    
    public String getFollowedUid() {
      Object object = this.followedUid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.followedUid_ = object;
      return (String)object;
    }
    
    public ByteString getFollowedUidBytes() {
      Object object = this.followedUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.followedUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getFrom() {
      Object object = this.from_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.from_ = object;
      return (String)object;
    }
    
    public ByteString getFromBytes() {
      Object object = this.from_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.from_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.GiftStatus getGiftStatus() {
      LiveProtos.GiftStatus giftStatus2 = LiveProtos.GiftStatus.valueOf(this.giftStatus_);
      LiveProtos.GiftStatus giftStatus1 = giftStatus2;
      if (giftStatus2 == null)
        giftStatus1 = LiveProtos.GiftStatus.UNRECOGNIZED; 
      return giftStatus1;
    }
    
    public int getGiftStatusValue() {
      return this.giftStatus_;
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
    
    public String getGuestUid() {
      Object object = this.guestUid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.guestUid_ = object;
      return (String)object;
    }
    
    public ByteString getGuestUidBytes() {
      Object object = this.guestUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.guestUid_ = object;
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
    
    public boolean getIsAuto() {
      return this.isAuto_;
    }
    
    public boolean getIsHitTime() {
      return this.isHitTime_;
    }
    
    public boolean getIsJoin() {
      return this.isJoin_;
    }
    
    public boolean getIsMystery() {
      return this.isMystery_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsPk() {
      return this.isPk_;
    }
    
    public boolean getIsQueue() {
      return this.isQueue_;
    }
    
    public boolean getIsSuccess() {
      return this.isSuccess_;
    }
    
    public int getLikeCount() {
      return this.likeCount_;
    }
    
    public int getLiveDuration() {
      return this.liveDuration_;
    }
    
    public String getLiveFrom() {
      Object object = this.liveFrom_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.liveFrom_ = object;
      return (String)object;
    }
    
    public ByteString getLiveFromBytes() {
      Object object = this.liveFrom_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveFrom_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getLiveFromNum() {
      return this.liveFromNum_;
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
    
    public String getLiveTab() {
      Object object = this.liveTab_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.liveTab_ = object;
      return (String)object;
    }
    
    public ByteString getLiveTabBytes() {
      Object object = this.liveTab_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveTab_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.LiveType getLiveType() {
      LiveProtos.LiveType liveType2 = LiveProtos.LiveType.valueOf(this.liveType_);
      LiveProtos.LiveType liveType1 = liveType2;
      if (liveType2 == null)
        liveType1 = LiveProtos.LiveType.UNRECOGNIZED; 
      return liveType1;
    }
    
    public String getLiveTypeId() {
      Object object = this.liveTypeId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.liveTypeId_ = object;
      return (String)object;
    }
    
    public ByteString getLiveTypeIdBytes() {
      Object object = this.liveTypeId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveTypeId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getLiveTypeValue() {
      return this.liveType_;
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
    
    public String getMysteryUid() {
      Object object = this.mysteryUid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.mysteryUid_ = object;
      return (String)object;
    }
    
    public ByteString getMysteryUidBytes() {
      Object object = this.mysteryUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.mysteryUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public int getOnlineCount() {
      return this.onlineCount_;
    }
    
    public int getPageNum() {
      return this.pageNum_;
    }
    
    public Parser<LiveProto> getParserForType() {
      return PARSER;
    }
    
    public String getPassword() {
      Object object = this.password_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.password_ = object;
      return (String)object;
    }
    
    public ByteString getPasswordBytes() {
      Object object = this.password_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.password_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.PayStatus getPayStatus() {
      LiveProtos.PayStatus payStatus2 = LiveProtos.PayStatus.valueOf(this.payStatus_);
      LiveProtos.PayStatus payStatus1 = payStatus2;
      if (payStatus2 == null)
        payStatus1 = LiveProtos.PayStatus.UNRECOGNIZED; 
      return payStatus1;
    }
    
    public int getPayStatusValue() {
      return this.payStatus_;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public String getRecommendLiveId() {
      Object object = this.recommendLiveId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.recommendLiveId_ = object;
      return (String)object;
    }
    
    public ByteString getRecommendLiveIdBytes() {
      Object object = this.recommendLiveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.recommendLiveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRecommendType() {
      Object object = this.recommendType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.recommendType_ = object;
      return (String)object;
    }
    
    public ByteString getRecommendTypeBytes() {
      Object object = this.recommendType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.recommendType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRecommendUid() {
      Object object = this.recommendUid_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.recommendUid_ = object;
      return (String)object;
    }
    
    public ByteString getRecommendUidBytes() {
      Object object = this.recommendUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.recommendUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != LiveProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.giftStatus_ != LiveProtos.GiftStatus.UNKNOWN_BTN_STATUS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.giftStatus_); 
      j = i;
      if (this.enterType_ != LiveProtos.EnterType.UNKNOWN_ENTER_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.enterType_); 
      i = j;
      if (this.status_ != LiveProtos.Status.UNKNOWN_STATUS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(4, this.status_); 
      j = i;
      if (!getFilterIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.filterId_); 
      boolean bool = this.isAuto_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(6, bool); 
      j = i;
      if (this.firstPayStatus_ != LiveProtos.FirstPayStatus.UNKNOWN_FIRST_PAY_STATUS.getNumber())
        j = i + CodedOutputStream.computeEnumSize(7, this.firstPayStatus_); 
      i = j;
      if (this.payStatus_ != LiveProtos.PayStatus.UNKNOWN_PAY_STATUS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(8, this.payStatus_); 
      j = i;
      if (!getLiveIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(9, this.liveId_); 
      i = j;
      if (!getUrlBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(10, this.url_); 
      j = i;
      if (!getTargetUidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(11, this.targetUid_); 
      i = j;
      if (!getFeatureIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(12, this.featureId_); 
      j = i;
      if (this.boxType_ != LiveProtos.BoxType.UNKNOWN_BOX_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(13, this.boxType_); 
      int k = j;
      if (this.taskType_ != LiveProtos.TaskType.UNKNOWN_TASK_TYPE.getNumber())
        k = j + CodedOutputStream.computeEnumSize(14, this.taskType_); 
      i = k;
      if (this.awardType_ != LiveProtos.AwardType.UNKNOWN_AWARD_TYPE.getNumber())
        i = k + CodedOutputStream.computeEnumSize(15, this.awardType_); 
      k = this.count_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(16, k); 
      i = j;
      if (this.followStatus_ != LiveProtos.FollowStatus.UNKNOWN_FOLLOW_STATUS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(17, this.followStatus_); 
      bool = this.isSuccess_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(18, bool); 
      i = j;
      if (!getLiveTypeIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(19, this.liveTypeId_); 
      bool = this.isJoin_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(20, bool); 
      i = j;
      if (this.btnType_ != LiveProtos.BtnType.UNKNOWN_BTN_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(21, this.btnType_); 
      j = i;
      if (this.source_ != LiveProtos.Source.UNKNOWN_SOURCE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(22, this.source_); 
      i = j;
      if (!getTaskIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(23, this.taskId_); 
      j = i;
      if (this.liveType_ != LiveProtos.LiveType.UNKNOWN_LIVE_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(24, this.liveType_); 
      k = this.beansCount_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(25, k); 
      k = this.beansNum_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(26, k); 
      k = this.viewCount_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(27, k); 
      k = this.likeCount_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(28, k); 
      k = this.onlineCount_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(29, k); 
      k = this.liveDuration_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(30, k); 
      i = j;
      if (!getGoodsIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(31, this.goodsId_); 
      k = this.num_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(32, k); 
      i = j;
      if (!getGuestUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(33, this.guestUid_); 
      j = i;
      if (!getRecommendLiveIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(34, this.recommendLiveId_); 
      i = j;
      if (!getRecommendUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(35, this.recommendUid_); 
      bool = this.isQueue_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(36, bool); 
      i = j;
      if (this.cardFrom_ != LiveProtos.CardFrom.UNKNOWN_CARD_FROM.getNumber())
        i = j + CodedOutputStream.computeEnumSize(37, this.cardFrom_); 
      bool = this.isOpen_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(38, bool); 
      i = j;
      if (!getLiveFromBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(39, this.liveFrom_); 
      bool = this.isMystery_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(40, bool); 
      i = j;
      if (!getMysteryUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(41, this.mysteryUid_); 
      j = i;
      if (!getMusicIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(42, this.musicId_); 
      k = j;
      if (!getTabIdBytes().isEmpty())
        k = j + GeneratedMessageV3.computeStringSize(43, this.tabId_); 
      i = k;
      if (!getPasswordBytes().isEmpty())
        i = k + GeneratedMessageV3.computeStringSize(44, this.password_); 
      k = this.condition_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(45, k); 
      k = j;
      if (!getLiveTabBytes().isEmpty())
        k = j + GeneratedMessageV3.computeStringSize(46, this.liveTab_); 
      j = this.position_;
      i = k;
      if (j != 0)
        i = k + CodedOutputStream.computeInt32Size(47, j); 
      k = this.tabNum_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(48, k); 
      k = this.pageNum_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(49, k); 
      j = i;
      if (!getIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(50, this.id_); 
      k = this.liveFromNum_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(51, k); 
      j = i;
      if (!getFollowedUidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(52, this.followedUid_); 
      i = j;
      if (!getRecommendTypeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(53, this.recommendType_); 
      j = i;
      if (!getFromBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(54, this.from_); 
      bool = this.isHitTime_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(55, bool); 
      bool = this.isPk_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(56, bool); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public LiveProtos.Source getSource() {
      LiveProtos.Source source2 = LiveProtos.Source.valueOf(this.source_);
      LiveProtos.Source source1 = source2;
      if (source2 == null)
        source1 = LiveProtos.Source.UNRECOGNIZED; 
      return source1;
    }
    
    public int getSourceValue() {
      return this.source_;
    }
    
    public LiveProtos.Status getStatus() {
      LiveProtos.Status status2 = LiveProtos.Status.valueOf(this.status_);
      LiveProtos.Status status1 = status2;
      if (status2 == null)
        status1 = LiveProtos.Status.UNRECOGNIZED; 
      return status1;
    }
    
    public int getStatusValue() {
      return this.status_;
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
    
    public String getTaskId() {
      Object object = this.taskId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.taskId_ = object;
      return (String)object;
    }
    
    public ByteString getTaskIdBytes() {
      Object object = this.taskId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.taskId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.TaskType getTaskType() {
      LiveProtos.TaskType taskType2 = LiveProtos.TaskType.valueOf(this.taskType_);
      LiveProtos.TaskType taskType1 = taskType2;
      if (taskType2 == null)
        taskType1 = LiveProtos.TaskType.UNRECOGNIZED; 
      return taskType1;
    }
    
    public int getTaskTypeValue() {
      return this.taskType_;
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
    
    public int getViewCount() {
      return this.viewCount_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.giftStatus_) * 37 + 3) * 53 + this.enterType_) * 37 + 4) * 53 + this.status_) * 37 + 5) * 53 + getFilterId().hashCode()) * 37 + 6) * 53 + Internal.hashBoolean(getIsAuto())) * 37 + 7) * 53 + this.firstPayStatus_) * 37 + 8) * 53 + this.payStatus_) * 37 + 9) * 53 + getLiveId().hashCode()) * 37 + 10) * 53 + getUrl().hashCode()) * 37 + 11) * 53 + getTargetUid().hashCode()) * 37 + 12) * 53 + getFeatureId().hashCode()) * 37 + 13) * 53 + this.boxType_) * 37 + 14) * 53 + this.taskType_) * 37 + 15) * 53 + this.awardType_) * 37 + 16) * 53 + getCount()) * 37 + 17) * 53 + this.followStatus_) * 37 + 18) * 53 + Internal.hashBoolean(getIsSuccess())) * 37 + 19) * 53 + getLiveTypeId().hashCode()) * 37 + 20) * 53 + Internal.hashBoolean(getIsJoin())) * 37 + 21) * 53 + this.btnType_) * 37 + 22) * 53 + this.source_) * 37 + 23) * 53 + getTaskId().hashCode()) * 37 + 24) * 53 + this.liveType_) * 37 + 25) * 53 + getBeansCount()) * 37 + 26) * 53 + getBeansNum()) * 37 + 27) * 53 + getViewCount()) * 37 + 28) * 53 + getLikeCount()) * 37 + 29) * 53 + getOnlineCount()) * 37 + 30) * 53 + getLiveDuration()) * 37 + 31) * 53 + getGoodsId().hashCode()) * 37 + 32) * 53 + getNum()) * 37 + 33) * 53 + getGuestUid().hashCode()) * 37 + 34) * 53 + getRecommendLiveId().hashCode()) * 37 + 35) * 53 + getRecommendUid().hashCode()) * 37 + 36) * 53 + Internal.hashBoolean(getIsQueue())) * 37 + 37) * 53 + this.cardFrom_) * 37 + 38) * 53 + Internal.hashBoolean(getIsOpen())) * 37 + 39) * 53 + getLiveFrom().hashCode()) * 37 + 40) * 53 + Internal.hashBoolean(getIsMystery())) * 37 + 41) * 53 + getMysteryUid().hashCode()) * 37 + 42) * 53 + getMusicId().hashCode()) * 37 + 43) * 53 + getTabId().hashCode()) * 37 + 44) * 53 + getPassword().hashCode()) * 37 + 45) * 53 + getCondition()) * 37 + 46) * 53 + getLiveTab().hashCode()) * 37 + 47) * 53 + getPosition()) * 37 + 48) * 53 + getTabNum()) * 37 + 49) * 53 + getPageNum()) * 37 + 50) * 53 + getId().hashCode()) * 37 + 51) * 53 + getLiveFromNum()) * 37 + 52) * 53 + getFollowedUid().hashCode()) * 37 + 53) * 53 + getRecommendType().hashCode()) * 37 + 54) * 53 + getFrom().hashCode()) * 37 + 55) * 53 + Internal.hashBoolean(getIsHitTime())) * 37 + 56) * 53 + Internal.hashBoolean(getIsPk())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveProtos.internal_static_com_blued_das_live_LiveProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveProto.class, Builder.class);
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
      return new LiveProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != LiveProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.giftStatus_ != LiveProtos.GiftStatus.UNKNOWN_BTN_STATUS.getNumber())
        param1CodedOutputStream.writeEnum(2, this.giftStatus_); 
      if (this.enterType_ != LiveProtos.EnterType.UNKNOWN_ENTER_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.enterType_); 
      if (this.status_ != LiveProtos.Status.UNKNOWN_STATUS.getNumber())
        param1CodedOutputStream.writeEnum(4, this.status_); 
      if (!getFilterIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.filterId_); 
      boolean bool = this.isAuto_;
      if (bool)
        param1CodedOutputStream.writeBool(6, bool); 
      if (this.firstPayStatus_ != LiveProtos.FirstPayStatus.UNKNOWN_FIRST_PAY_STATUS.getNumber())
        param1CodedOutputStream.writeEnum(7, this.firstPayStatus_); 
      if (this.payStatus_ != LiveProtos.PayStatus.UNKNOWN_PAY_STATUS.getNumber())
        param1CodedOutputStream.writeEnum(8, this.payStatus_); 
      if (!getLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 9, this.liveId_); 
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 10, this.url_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 11, this.targetUid_); 
      if (!getFeatureIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 12, this.featureId_); 
      if (this.boxType_ != LiveProtos.BoxType.UNKNOWN_BOX_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(13, this.boxType_); 
      if (this.taskType_ != LiveProtos.TaskType.UNKNOWN_TASK_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(14, this.taskType_); 
      if (this.awardType_ != LiveProtos.AwardType.UNKNOWN_AWARD_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(15, this.awardType_); 
      int i = this.count_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(16, i); 
      if (this.followStatus_ != LiveProtos.FollowStatus.UNKNOWN_FOLLOW_STATUS.getNumber())
        param1CodedOutputStream.writeEnum(17, this.followStatus_); 
      bool = this.isSuccess_;
      if (bool)
        param1CodedOutputStream.writeBool(18, bool); 
      if (!getLiveTypeIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 19, this.liveTypeId_); 
      bool = this.isJoin_;
      if (bool)
        param1CodedOutputStream.writeBool(20, bool); 
      if (this.btnType_ != LiveProtos.BtnType.UNKNOWN_BTN_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(21, this.btnType_); 
      if (this.source_ != LiveProtos.Source.UNKNOWN_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(22, this.source_); 
      if (!getTaskIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 23, this.taskId_); 
      if (this.liveType_ != LiveProtos.LiveType.UNKNOWN_LIVE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(24, this.liveType_); 
      i = this.beansCount_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(25, i); 
      i = this.beansNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(26, i); 
      i = this.viewCount_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(27, i); 
      i = this.likeCount_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(28, i); 
      i = this.onlineCount_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(29, i); 
      i = this.liveDuration_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(30, i); 
      if (!getGoodsIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 31, this.goodsId_); 
      i = this.num_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(32, i); 
      if (!getGuestUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 33, this.guestUid_); 
      if (!getRecommendLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 34, this.recommendLiveId_); 
      if (!getRecommendUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 35, this.recommendUid_); 
      bool = this.isQueue_;
      if (bool)
        param1CodedOutputStream.writeBool(36, bool); 
      if (this.cardFrom_ != LiveProtos.CardFrom.UNKNOWN_CARD_FROM.getNumber())
        param1CodedOutputStream.writeEnum(37, this.cardFrom_); 
      bool = this.isOpen_;
      if (bool)
        param1CodedOutputStream.writeBool(38, bool); 
      if (!getLiveFromBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 39, this.liveFrom_); 
      bool = this.isMystery_;
      if (bool)
        param1CodedOutputStream.writeBool(40, bool); 
      if (!getMysteryUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 41, this.mysteryUid_); 
      if (!getMusicIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 42, this.musicId_); 
      if (!getTabIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 43, this.tabId_); 
      if (!getPasswordBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 44, this.password_); 
      i = this.condition_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(45, i); 
      if (!getLiveTabBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 46, this.liveTab_); 
      i = this.position_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(47, i); 
      i = this.tabNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(48, i); 
      i = this.pageNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(49, i); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 50, this.id_); 
      i = this.liveFromNum_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(51, i); 
      if (!getFollowedUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 52, this.followedUid_); 
      if (!getRecommendTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 53, this.recommendType_); 
      if (!getFromBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 54, this.from_); 
      bool = this.isHitTime_;
      if (bool)
        param1CodedOutputStream.writeBool(55, bool); 
      bool = this.isPk_;
      if (bool)
        param1CodedOutputStream.writeBool(56, bool); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveProtos.LiveProtoOrBuilder {
      private int awardType_ = 0;
      
      private int beansCount_;
      
      private int beansNum_;
      
      private int boxType_ = 0;
      
      private int btnType_ = 0;
      
      private int cardFrom_ = 0;
      
      private int condition_;
      
      private int count_;
      
      private int enterType_ = 0;
      
      private int event_ = 0;
      
      private Object featureId_ = "";
      
      private Object filterId_ = "";
      
      private int firstPayStatus_ = 0;
      
      private int followStatus_ = 0;
      
      private Object followedUid_ = "";
      
      private Object from_ = "";
      
      private int giftStatus_ = 0;
      
      private Object goodsId_ = "";
      
      private Object guestUid_ = "";
      
      private Object id_ = "";
      
      private boolean isAuto_;
      
      private boolean isHitTime_;
      
      private boolean isJoin_;
      
      private boolean isMystery_;
      
      private boolean isOpen_;
      
      private boolean isPk_;
      
      private boolean isQueue_;
      
      private boolean isSuccess_;
      
      private int likeCount_;
      
      private int liveDuration_;
      
      private int liveFromNum_;
      
      private Object liveFrom_ = "";
      
      private Object liveId_ = "";
      
      private Object liveTab_ = "";
      
      private Object liveTypeId_ = "";
      
      private int liveType_ = 0;
      
      private Object musicId_ = "";
      
      private Object mysteryUid_ = "";
      
      private int num_;
      
      private int onlineCount_;
      
      private int pageNum_;
      
      private Object password_ = "";
      
      private int payStatus_ = 0;
      
      private int position_;
      
      private Object recommendLiveId_ = "";
      
      private Object recommendType_ = "";
      
      private Object recommendUid_ = "";
      
      private int source_ = 0;
      
      private int status_ = 0;
      
      private Object tabId_ = "";
      
      private int tabNum_;
      
      private Object targetUid_ = "";
      
      private Object taskId_ = "";
      
      private int taskType_ = 0;
      
      private Object url_ = "";
      
      private int viewCount_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveProtos.internal_static_com_blued_das_live_LiveProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveProtos.LiveProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveProtos.LiveProto build() {
        LiveProtos.LiveProto liveProto = buildPartial();
        if (liveProto.isInitialized())
          return liveProto; 
        throw newUninitializedMessageException(liveProto);
      }
      
      public LiveProtos.LiveProto buildPartial() {
        LiveProtos.LiveProto liveProto = new LiveProtos.LiveProto(this);
        LiveProtos.LiveProto.access$602(liveProto, this.event_);
        LiveProtos.LiveProto.access$702(liveProto, this.giftStatus_);
        LiveProtos.LiveProto.access$802(liveProto, this.enterType_);
        LiveProtos.LiveProto.access$902(liveProto, this.status_);
        LiveProtos.LiveProto.access$1002(liveProto, this.filterId_);
        LiveProtos.LiveProto.access$1102(liveProto, this.isAuto_);
        LiveProtos.LiveProto.access$1202(liveProto, this.firstPayStatus_);
        LiveProtos.LiveProto.access$1302(liveProto, this.payStatus_);
        LiveProtos.LiveProto.access$1402(liveProto, this.liveId_);
        LiveProtos.LiveProto.access$1502(liveProto, this.url_);
        LiveProtos.LiveProto.access$1602(liveProto, this.targetUid_);
        LiveProtos.LiveProto.access$1702(liveProto, this.featureId_);
        LiveProtos.LiveProto.access$1802(liveProto, this.boxType_);
        LiveProtos.LiveProto.access$1902(liveProto, this.taskType_);
        LiveProtos.LiveProto.access$2002(liveProto, this.awardType_);
        LiveProtos.LiveProto.access$2102(liveProto, this.count_);
        LiveProtos.LiveProto.access$2202(liveProto, this.followStatus_);
        LiveProtos.LiveProto.access$2302(liveProto, this.isSuccess_);
        LiveProtos.LiveProto.access$2402(liveProto, this.liveTypeId_);
        LiveProtos.LiveProto.access$2502(liveProto, this.isJoin_);
        LiveProtos.LiveProto.access$2602(liveProto, this.btnType_);
        LiveProtos.LiveProto.access$2702(liveProto, this.source_);
        LiveProtos.LiveProto.access$2802(liveProto, this.taskId_);
        LiveProtos.LiveProto.access$2902(liveProto, this.liveType_);
        LiveProtos.LiveProto.access$3002(liveProto, this.beansCount_);
        LiveProtos.LiveProto.access$3102(liveProto, this.beansNum_);
        LiveProtos.LiveProto.access$3202(liveProto, this.viewCount_);
        LiveProtos.LiveProto.access$3302(liveProto, this.likeCount_);
        LiveProtos.LiveProto.access$3402(liveProto, this.onlineCount_);
        LiveProtos.LiveProto.access$3502(liveProto, this.liveDuration_);
        LiveProtos.LiveProto.access$3602(liveProto, this.goodsId_);
        LiveProtos.LiveProto.access$3702(liveProto, this.num_);
        LiveProtos.LiveProto.access$3802(liveProto, this.guestUid_);
        LiveProtos.LiveProto.access$3902(liveProto, this.recommendLiveId_);
        LiveProtos.LiveProto.access$4002(liveProto, this.recommendUid_);
        LiveProtos.LiveProto.access$4102(liveProto, this.isQueue_);
        LiveProtos.LiveProto.access$4202(liveProto, this.cardFrom_);
        LiveProtos.LiveProto.access$4302(liveProto, this.isOpen_);
        LiveProtos.LiveProto.access$4402(liveProto, this.liveFrom_);
        LiveProtos.LiveProto.access$4502(liveProto, this.isMystery_);
        LiveProtos.LiveProto.access$4602(liveProto, this.mysteryUid_);
        LiveProtos.LiveProto.access$4702(liveProto, this.musicId_);
        LiveProtos.LiveProto.access$4802(liveProto, this.tabId_);
        LiveProtos.LiveProto.access$4902(liveProto, this.password_);
        LiveProtos.LiveProto.access$5002(liveProto, this.condition_);
        LiveProtos.LiveProto.access$5102(liveProto, this.liveTab_);
        LiveProtos.LiveProto.access$5202(liveProto, this.position_);
        LiveProtos.LiveProto.access$5302(liveProto, this.tabNum_);
        LiveProtos.LiveProto.access$5402(liveProto, this.pageNum_);
        LiveProtos.LiveProto.access$5502(liveProto, this.id_);
        LiveProtos.LiveProto.access$5602(liveProto, this.liveFromNum_);
        LiveProtos.LiveProto.access$5702(liveProto, this.followedUid_);
        LiveProtos.LiveProto.access$5802(liveProto, this.recommendType_);
        LiveProtos.LiveProto.access$5902(liveProto, this.from_);
        LiveProtos.LiveProto.access$6002(liveProto, this.isHitTime_);
        LiveProtos.LiveProto.access$6102(liveProto, this.isPk_);
        onBuilt();
        return liveProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.giftStatus_ = 0;
        this.enterType_ = 0;
        this.status_ = 0;
        this.filterId_ = "";
        this.isAuto_ = false;
        this.firstPayStatus_ = 0;
        this.payStatus_ = 0;
        this.liveId_ = "";
        this.url_ = "";
        this.targetUid_ = "";
        this.featureId_ = "";
        this.boxType_ = 0;
        this.taskType_ = 0;
        this.awardType_ = 0;
        this.count_ = 0;
        this.followStatus_ = 0;
        this.isSuccess_ = false;
        this.liveTypeId_ = "";
        this.isJoin_ = false;
        this.btnType_ = 0;
        this.source_ = 0;
        this.taskId_ = "";
        this.liveType_ = 0;
        this.beansCount_ = 0;
        this.beansNum_ = 0;
        this.viewCount_ = 0;
        this.likeCount_ = 0;
        this.onlineCount_ = 0;
        this.liveDuration_ = 0;
        this.goodsId_ = "";
        this.num_ = 0;
        this.guestUid_ = "";
        this.recommendLiveId_ = "";
        this.recommendUid_ = "";
        this.isQueue_ = false;
        this.cardFrom_ = 0;
        this.isOpen_ = false;
        this.liveFrom_ = "";
        this.isMystery_ = false;
        this.mysteryUid_ = "";
        this.musicId_ = "";
        this.tabId_ = "";
        this.password_ = "";
        this.condition_ = 0;
        this.liveTab_ = "";
        this.position_ = 0;
        this.tabNum_ = 0;
        this.pageNum_ = 0;
        this.id_ = "";
        this.liveFromNum_ = 0;
        this.followedUid_ = "";
        this.recommendType_ = "";
        this.from_ = "";
        this.isHitTime_ = false;
        this.isPk_ = false;
        return this;
      }
      
      public Builder clearAwardType() {
        this.awardType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearBeansCount() {
        this.beansCount_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearBeansNum() {
        this.beansNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearBoxType() {
        this.boxType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearBtnType() {
        this.btnType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearCardFrom() {
        this.cardFrom_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearCondition() {
        this.condition_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearCount() {
        this.count_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearEnterType() {
        this.enterType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeatureId() {
        this.featureId_ = LiveProtos.LiveProto.getDefaultInstance().getFeatureId();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearFilterId() {
        this.filterId_ = LiveProtos.LiveProto.getDefaultInstance().getFilterId();
        onChanged();
        return this;
      }
      
      public Builder clearFirstPayStatus() {
        this.firstPayStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFollowStatus() {
        this.followStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFollowedUid() {
        this.followedUid_ = LiveProtos.LiveProto.getDefaultInstance().getFollowedUid();
        onChanged();
        return this;
      }
      
      public Builder clearFrom() {
        this.from_ = LiveProtos.LiveProto.getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      
      public Builder clearGiftStatus() {
        this.giftStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearGoodsId() {
        this.goodsId_ = LiveProtos.LiveProto.getDefaultInstance().getGoodsId();
        onChanged();
        return this;
      }
      
      public Builder clearGuestUid() {
        this.guestUid_ = LiveProtos.LiveProto.getDefaultInstance().getGuestUid();
        onChanged();
        return this;
      }
      
      public Builder clearId() {
        this.id_ = LiveProtos.LiveProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearIsAuto() {
        this.isAuto_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsHitTime() {
        this.isHitTime_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsJoin() {
        this.isJoin_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsMystery() {
        this.isMystery_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsOpen() {
        this.isOpen_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsPk() {
        this.isPk_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsQueue() {
        this.isQueue_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsSuccess() {
        this.isSuccess_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearLikeCount() {
        this.likeCount_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearLiveDuration() {
        this.liveDuration_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearLiveFrom() {
        this.liveFrom_ = LiveProtos.LiveProto.getDefaultInstance().getLiveFrom();
        onChanged();
        return this;
      }
      
      public Builder clearLiveFromNum() {
        this.liveFromNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearLiveId() {
        this.liveId_ = LiveProtos.LiveProto.getDefaultInstance().getLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearLiveTab() {
        this.liveTab_ = LiveProtos.LiveProto.getDefaultInstance().getLiveTab();
        onChanged();
        return this;
      }
      
      public Builder clearLiveType() {
        this.liveType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearLiveTypeId() {
        this.liveTypeId_ = LiveProtos.LiveProto.getDefaultInstance().getLiveTypeId();
        onChanged();
        return this;
      }
      
      public Builder clearMusicId() {
        this.musicId_ = LiveProtos.LiveProto.getDefaultInstance().getMusicId();
        onChanged();
        return this;
      }
      
      public Builder clearMysteryUid() {
        this.mysteryUid_ = LiveProtos.LiveProto.getDefaultInstance().getMysteryUid();
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
      
      public Builder clearOnlineCount() {
        this.onlineCount_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPageNum() {
        this.pageNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPassword() {
        this.password_ = LiveProtos.LiveProto.getDefaultInstance().getPassword();
        onChanged();
        return this;
      }
      
      public Builder clearPayStatus() {
        this.payStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPosition() {
        this.position_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearRecommendLiveId() {
        this.recommendLiveId_ = LiveProtos.LiveProto.getDefaultInstance().getRecommendLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearRecommendType() {
        this.recommendType_ = LiveProtos.LiveProto.getDefaultInstance().getRecommendType();
        onChanged();
        return this;
      }
      
      public Builder clearRecommendUid() {
        this.recommendUid_ = LiveProtos.LiveProto.getDefaultInstance().getRecommendUid();
        onChanged();
        return this;
      }
      
      public Builder clearSource() {
        this.source_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearStatus() {
        this.status_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTabId() {
        this.tabId_ = LiveProtos.LiveProto.getDefaultInstance().getTabId();
        onChanged();
        return this;
      }
      
      public Builder clearTabNum() {
        this.tabNum_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = LiveProtos.LiveProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clearTaskId() {
        this.taskId_ = LiveProtos.LiveProto.getDefaultInstance().getTaskId();
        onChanged();
        return this;
      }
      
      public Builder clearTaskType() {
        this.taskType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearUrl() {
        this.url_ = LiveProtos.LiveProto.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clearViewCount() {
        this.viewCount_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public LiveProtos.AwardType getAwardType() {
        LiveProtos.AwardType awardType2 = LiveProtos.AwardType.valueOf(this.awardType_);
        LiveProtos.AwardType awardType1 = awardType2;
        if (awardType2 == null)
          awardType1 = LiveProtos.AwardType.UNRECOGNIZED; 
        return awardType1;
      }
      
      public int getAwardTypeValue() {
        return this.awardType_;
      }
      
      public int getBeansCount() {
        return this.beansCount_;
      }
      
      public int getBeansNum() {
        return this.beansNum_;
      }
      
      public LiveProtos.BoxType getBoxType() {
        LiveProtos.BoxType boxType2 = LiveProtos.BoxType.valueOf(this.boxType_);
        LiveProtos.BoxType boxType1 = boxType2;
        if (boxType2 == null)
          boxType1 = LiveProtos.BoxType.UNRECOGNIZED; 
        return boxType1;
      }
      
      public int getBoxTypeValue() {
        return this.boxType_;
      }
      
      public LiveProtos.BtnType getBtnType() {
        LiveProtos.BtnType btnType2 = LiveProtos.BtnType.valueOf(this.btnType_);
        LiveProtos.BtnType btnType1 = btnType2;
        if (btnType2 == null)
          btnType1 = LiveProtos.BtnType.UNRECOGNIZED; 
        return btnType1;
      }
      
      public int getBtnTypeValue() {
        return this.btnType_;
      }
      
      public LiveProtos.CardFrom getCardFrom() {
        LiveProtos.CardFrom cardFrom2 = LiveProtos.CardFrom.valueOf(this.cardFrom_);
        LiveProtos.CardFrom cardFrom1 = cardFrom2;
        if (cardFrom2 == null)
          cardFrom1 = LiveProtos.CardFrom.UNRECOGNIZED; 
        return cardFrom1;
      }
      
      public int getCardFromValue() {
        return this.cardFrom_;
      }
      
      public int getCondition() {
        return this.condition_;
      }
      
      public int getCount() {
        return this.count_;
      }
      
      public LiveProtos.LiveProto getDefaultInstanceForType() {
        return LiveProtos.LiveProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveProtos.internal_static_com_blued_das_live_LiveProto_descriptor;
      }
      
      public LiveProtos.EnterType getEnterType() {
        LiveProtos.EnterType enterType2 = LiveProtos.EnterType.valueOf(this.enterType_);
        LiveProtos.EnterType enterType1 = enterType2;
        if (enterType2 == null)
          enterType1 = LiveProtos.EnterType.UNRECOGNIZED; 
        return enterType1;
      }
      
      public int getEnterTypeValue() {
        return this.enterType_;
      }
      
      public LiveProtos.Event getEvent() {
        LiveProtos.Event event2 = LiveProtos.Event.valueOf(this.event_);
        LiveProtos.Event event1 = event2;
        if (event2 == null)
          event1 = LiveProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public String getFeatureId() {
        Object object = this.featureId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.featureId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getFeatureIdBytes() {
        Object object = this.featureId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.featureId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getFilterId() {
        Object object = this.filterId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.filterId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getFilterIdBytes() {
        Object object = this.filterId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.filterId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveProtos.FirstPayStatus getFirstPayStatus() {
        LiveProtos.FirstPayStatus firstPayStatus2 = LiveProtos.FirstPayStatus.valueOf(this.firstPayStatus_);
        LiveProtos.FirstPayStatus firstPayStatus1 = firstPayStatus2;
        if (firstPayStatus2 == null)
          firstPayStatus1 = LiveProtos.FirstPayStatus.UNRECOGNIZED; 
        return firstPayStatus1;
      }
      
      public int getFirstPayStatusValue() {
        return this.firstPayStatus_;
      }
      
      public LiveProtos.FollowStatus getFollowStatus() {
        LiveProtos.FollowStatus followStatus2 = LiveProtos.FollowStatus.valueOf(this.followStatus_);
        LiveProtos.FollowStatus followStatus1 = followStatus2;
        if (followStatus2 == null)
          followStatus1 = LiveProtos.FollowStatus.UNRECOGNIZED; 
        return followStatus1;
      }
      
      public int getFollowStatusValue() {
        return this.followStatus_;
      }
      
      public String getFollowedUid() {
        Object object = this.followedUid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.followedUid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getFollowedUidBytes() {
        Object object = this.followedUid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.followedUid_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getFrom() {
        Object object = this.from_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.from_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getFromBytes() {
        Object object = this.from_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.from_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveProtos.GiftStatus getGiftStatus() {
        LiveProtos.GiftStatus giftStatus2 = LiveProtos.GiftStatus.valueOf(this.giftStatus_);
        LiveProtos.GiftStatus giftStatus1 = giftStatus2;
        if (giftStatus2 == null)
          giftStatus1 = LiveProtos.GiftStatus.UNRECOGNIZED; 
        return giftStatus1;
      }
      
      public int getGiftStatusValue() {
        return this.giftStatus_;
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
      
      public String getGuestUid() {
        Object object = this.guestUid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.guestUid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getGuestUidBytes() {
        Object object = this.guestUid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.guestUid_ = object;
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
      
      public boolean getIsAuto() {
        return this.isAuto_;
      }
      
      public boolean getIsHitTime() {
        return this.isHitTime_;
      }
      
      public boolean getIsJoin() {
        return this.isJoin_;
      }
      
      public boolean getIsMystery() {
        return this.isMystery_;
      }
      
      public boolean getIsOpen() {
        return this.isOpen_;
      }
      
      public boolean getIsPk() {
        return this.isPk_;
      }
      
      public boolean getIsQueue() {
        return this.isQueue_;
      }
      
      public boolean getIsSuccess() {
        return this.isSuccess_;
      }
      
      public int getLikeCount() {
        return this.likeCount_;
      }
      
      public int getLiveDuration() {
        return this.liveDuration_;
      }
      
      public String getLiveFrom() {
        Object object = this.liveFrom_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.liveFrom_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLiveFromBytes() {
        Object object = this.liveFrom_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.liveFrom_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getLiveFromNum() {
        return this.liveFromNum_;
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
      
      public String getLiveTab() {
        Object object = this.liveTab_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.liveTab_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLiveTabBytes() {
        Object object = this.liveTab_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.liveTab_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveProtos.LiveType getLiveType() {
        LiveProtos.LiveType liveType2 = LiveProtos.LiveType.valueOf(this.liveType_);
        LiveProtos.LiveType liveType1 = liveType2;
        if (liveType2 == null)
          liveType1 = LiveProtos.LiveType.UNRECOGNIZED; 
        return liveType1;
      }
      
      public String getLiveTypeId() {
        Object object = this.liveTypeId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.liveTypeId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLiveTypeIdBytes() {
        Object object = this.liveTypeId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.liveTypeId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getLiveTypeValue() {
        return this.liveType_;
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
      
      public String getMysteryUid() {
        Object object = this.mysteryUid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.mysteryUid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getMysteryUidBytes() {
        Object object = this.mysteryUid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.mysteryUid_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getNum() {
        return this.num_;
      }
      
      public int getOnlineCount() {
        return this.onlineCount_;
      }
      
      public int getPageNum() {
        return this.pageNum_;
      }
      
      public String getPassword() {
        Object object = this.password_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.password_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getPasswordBytes() {
        Object object = this.password_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.password_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveProtos.PayStatus getPayStatus() {
        LiveProtos.PayStatus payStatus2 = LiveProtos.PayStatus.valueOf(this.payStatus_);
        LiveProtos.PayStatus payStatus1 = payStatus2;
        if (payStatus2 == null)
          payStatus1 = LiveProtos.PayStatus.UNRECOGNIZED; 
        return payStatus1;
      }
      
      public int getPayStatusValue() {
        return this.payStatus_;
      }
      
      public int getPosition() {
        return this.position_;
      }
      
      public String getRecommendLiveId() {
        Object object = this.recommendLiveId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.recommendLiveId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRecommendLiveIdBytes() {
        Object object = this.recommendLiveId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.recommendLiveId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRecommendType() {
        Object object = this.recommendType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.recommendType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRecommendTypeBytes() {
        Object object = this.recommendType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.recommendType_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getRecommendUid() {
        Object object = this.recommendUid_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.recommendUid_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRecommendUidBytes() {
        Object object = this.recommendUid_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.recommendUid_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveProtos.Source getSource() {
        LiveProtos.Source source2 = LiveProtos.Source.valueOf(this.source_);
        LiveProtos.Source source1 = source2;
        if (source2 == null)
          source1 = LiveProtos.Source.UNRECOGNIZED; 
        return source1;
      }
      
      public int getSourceValue() {
        return this.source_;
      }
      
      public LiveProtos.Status getStatus() {
        LiveProtos.Status status2 = LiveProtos.Status.valueOf(this.status_);
        LiveProtos.Status status1 = status2;
        if (status2 == null)
          status1 = LiveProtos.Status.UNRECOGNIZED; 
        return status1;
      }
      
      public int getStatusValue() {
        return this.status_;
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
      
      public String getTaskId() {
        Object object = this.taskId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.taskId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTaskIdBytes() {
        Object object = this.taskId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.taskId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveProtos.TaskType getTaskType() {
        LiveProtos.TaskType taskType2 = LiveProtos.TaskType.valueOf(this.taskType_);
        LiveProtos.TaskType taskType1 = taskType2;
        if (taskType2 == null)
          taskType1 = LiveProtos.TaskType.UNRECOGNIZED; 
        return taskType1;
      }
      
      public int getTaskTypeValue() {
        return this.taskType_;
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
      
      public int getViewCount() {
        return this.viewCount_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveProtos.internal_static_com_blued_das_live_LiveProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveProtos.LiveProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveProtos.LiveProto param2LiveProto) {
        if (param2LiveProto == LiveProtos.LiveProto.getDefaultInstance())
          return this; 
        if (param2LiveProto.event_ != 0)
          setEventValue(param2LiveProto.getEventValue()); 
        if (param2LiveProto.giftStatus_ != 0)
          setGiftStatusValue(param2LiveProto.getGiftStatusValue()); 
        if (param2LiveProto.enterType_ != 0)
          setEnterTypeValue(param2LiveProto.getEnterTypeValue()); 
        if (param2LiveProto.status_ != 0)
          setStatusValue(param2LiveProto.getStatusValue()); 
        if (!param2LiveProto.getFilterId().isEmpty()) {
          this.filterId_ = param2LiveProto.filterId_;
          onChanged();
        } 
        if (param2LiveProto.getIsAuto())
          setIsAuto(param2LiveProto.getIsAuto()); 
        if (param2LiveProto.firstPayStatus_ != 0)
          setFirstPayStatusValue(param2LiveProto.getFirstPayStatusValue()); 
        if (param2LiveProto.payStatus_ != 0)
          setPayStatusValue(param2LiveProto.getPayStatusValue()); 
        if (!param2LiveProto.getLiveId().isEmpty()) {
          this.liveId_ = param2LiveProto.liveId_;
          onChanged();
        } 
        if (!param2LiveProto.getUrl().isEmpty()) {
          this.url_ = param2LiveProto.url_;
          onChanged();
        } 
        if (!param2LiveProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2LiveProto.targetUid_;
          onChanged();
        } 
        if (!param2LiveProto.getFeatureId().isEmpty()) {
          this.featureId_ = param2LiveProto.featureId_;
          onChanged();
        } 
        if (param2LiveProto.boxType_ != 0)
          setBoxTypeValue(param2LiveProto.getBoxTypeValue()); 
        if (param2LiveProto.taskType_ != 0)
          setTaskTypeValue(param2LiveProto.getTaskTypeValue()); 
        if (param2LiveProto.awardType_ != 0)
          setAwardTypeValue(param2LiveProto.getAwardTypeValue()); 
        if (param2LiveProto.getCount() != 0)
          setCount(param2LiveProto.getCount()); 
        if (param2LiveProto.followStatus_ != 0)
          setFollowStatusValue(param2LiveProto.getFollowStatusValue()); 
        if (param2LiveProto.getIsSuccess())
          setIsSuccess(param2LiveProto.getIsSuccess()); 
        if (!param2LiveProto.getLiveTypeId().isEmpty()) {
          this.liveTypeId_ = param2LiveProto.liveTypeId_;
          onChanged();
        } 
        if (param2LiveProto.getIsJoin())
          setIsJoin(param2LiveProto.getIsJoin()); 
        if (param2LiveProto.btnType_ != 0)
          setBtnTypeValue(param2LiveProto.getBtnTypeValue()); 
        if (param2LiveProto.source_ != 0)
          setSourceValue(param2LiveProto.getSourceValue()); 
        if (!param2LiveProto.getTaskId().isEmpty()) {
          this.taskId_ = param2LiveProto.taskId_;
          onChanged();
        } 
        if (param2LiveProto.liveType_ != 0)
          setLiveTypeValue(param2LiveProto.getLiveTypeValue()); 
        if (param2LiveProto.getBeansCount() != 0)
          setBeansCount(param2LiveProto.getBeansCount()); 
        if (param2LiveProto.getBeansNum() != 0)
          setBeansNum(param2LiveProto.getBeansNum()); 
        if (param2LiveProto.getViewCount() != 0)
          setViewCount(param2LiveProto.getViewCount()); 
        if (param2LiveProto.getLikeCount() != 0)
          setLikeCount(param2LiveProto.getLikeCount()); 
        if (param2LiveProto.getOnlineCount() != 0)
          setOnlineCount(param2LiveProto.getOnlineCount()); 
        if (param2LiveProto.getLiveDuration() != 0)
          setLiveDuration(param2LiveProto.getLiveDuration()); 
        if (!param2LiveProto.getGoodsId().isEmpty()) {
          this.goodsId_ = param2LiveProto.goodsId_;
          onChanged();
        } 
        if (param2LiveProto.getNum() != 0)
          setNum(param2LiveProto.getNum()); 
        if (!param2LiveProto.getGuestUid().isEmpty()) {
          this.guestUid_ = param2LiveProto.guestUid_;
          onChanged();
        } 
        if (!param2LiveProto.getRecommendLiveId().isEmpty()) {
          this.recommendLiveId_ = param2LiveProto.recommendLiveId_;
          onChanged();
        } 
        if (!param2LiveProto.getRecommendUid().isEmpty()) {
          this.recommendUid_ = param2LiveProto.recommendUid_;
          onChanged();
        } 
        if (param2LiveProto.getIsQueue())
          setIsQueue(param2LiveProto.getIsQueue()); 
        if (param2LiveProto.cardFrom_ != 0)
          setCardFromValue(param2LiveProto.getCardFromValue()); 
        if (param2LiveProto.getIsOpen())
          setIsOpen(param2LiveProto.getIsOpen()); 
        if (!param2LiveProto.getLiveFrom().isEmpty()) {
          this.liveFrom_ = param2LiveProto.liveFrom_;
          onChanged();
        } 
        if (param2LiveProto.getIsMystery())
          setIsMystery(param2LiveProto.getIsMystery()); 
        if (!param2LiveProto.getMysteryUid().isEmpty()) {
          this.mysteryUid_ = param2LiveProto.mysteryUid_;
          onChanged();
        } 
        if (!param2LiveProto.getMusicId().isEmpty()) {
          this.musicId_ = param2LiveProto.musicId_;
          onChanged();
        } 
        if (!param2LiveProto.getTabId().isEmpty()) {
          this.tabId_ = param2LiveProto.tabId_;
          onChanged();
        } 
        if (!param2LiveProto.getPassword().isEmpty()) {
          this.password_ = param2LiveProto.password_;
          onChanged();
        } 
        if (param2LiveProto.getCondition() != 0)
          setCondition(param2LiveProto.getCondition()); 
        if (!param2LiveProto.getLiveTab().isEmpty()) {
          this.liveTab_ = param2LiveProto.liveTab_;
          onChanged();
        } 
        if (param2LiveProto.getPosition() != 0)
          setPosition(param2LiveProto.getPosition()); 
        if (param2LiveProto.getTabNum() != 0)
          setTabNum(param2LiveProto.getTabNum()); 
        if (param2LiveProto.getPageNum() != 0)
          setPageNum(param2LiveProto.getPageNum()); 
        if (!param2LiveProto.getId().isEmpty()) {
          this.id_ = param2LiveProto.id_;
          onChanged();
        } 
        if (param2LiveProto.getLiveFromNum() != 0)
          setLiveFromNum(param2LiveProto.getLiveFromNum()); 
        if (!param2LiveProto.getFollowedUid().isEmpty()) {
          this.followedUid_ = param2LiveProto.followedUid_;
          onChanged();
        } 
        if (!param2LiveProto.getRecommendType().isEmpty()) {
          this.recommendType_ = param2LiveProto.recommendType_;
          onChanged();
        } 
        if (!param2LiveProto.getFrom().isEmpty()) {
          this.from_ = param2LiveProto.from_;
          onChanged();
        } 
        if (param2LiveProto.getIsHitTime())
          setIsHitTime(param2LiveProto.getIsHitTime()); 
        if (param2LiveProto.getIsPk())
          setIsPk(param2LiveProto.getIsPk()); 
        mergeUnknownFields(param2LiveProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveProtos.LiveProto liveProto = (LiveProtos.LiveProto)LiveProtos.LiveProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveProtos.LiveProto liveProto = (LiveProtos.LiveProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveProtos.LiveProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveProtos.LiveProto)
          return mergeFrom((LiveProtos.LiveProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAwardType(LiveProtos.AwardType param2AwardType) {
        if (param2AwardType != null) {
          this.awardType_ = param2AwardType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAwardTypeValue(int param2Int) {
        this.awardType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setBeansCount(int param2Int) {
        this.beansCount_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setBeansNum(int param2Int) {
        this.beansNum_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setBoxType(LiveProtos.BoxType param2BoxType) {
        if (param2BoxType != null) {
          this.boxType_ = param2BoxType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBoxTypeValue(int param2Int) {
        this.boxType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setBtnType(LiveProtos.BtnType param2BtnType) {
        if (param2BtnType != null) {
          this.btnType_ = param2BtnType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBtnTypeValue(int param2Int) {
        this.btnType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setCardFrom(LiveProtos.CardFrom param2CardFrom) {
        if (param2CardFrom != null) {
          this.cardFrom_ = param2CardFrom.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCardFromValue(int param2Int) {
        this.cardFrom_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setCondition(int param2Int) {
        this.condition_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setCount(int param2Int) {
        this.count_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setEnterType(LiveProtos.EnterType param2EnterType) {
        if (param2EnterType != null) {
          this.enterType_ = param2EnterType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEnterTypeValue(int param2Int) {
        this.enterType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setEvent(LiveProtos.Event param2Event) {
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
      
      public Builder setFeatureId(String param2String) {
        if (param2String != null) {
          this.featureId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeatureIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.featureId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFilterId(String param2String) {
        if (param2String != null) {
          this.filterId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFilterIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.filterId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFirstPayStatus(LiveProtos.FirstPayStatus param2FirstPayStatus) {
        if (param2FirstPayStatus != null) {
          this.firstPayStatus_ = param2FirstPayStatus.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFirstPayStatusValue(int param2Int) {
        this.firstPayStatus_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setFollowStatus(LiveProtos.FollowStatus param2FollowStatus) {
        if (param2FollowStatus != null) {
          this.followStatus_ = param2FollowStatus.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFollowStatusValue(int param2Int) {
        this.followStatus_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setFollowedUid(String param2String) {
        if (param2String != null) {
          this.followedUid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFollowedUidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.followedUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFrom(String param2String) {
        if (param2String != null) {
          this.from_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFromBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.from_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGiftStatus(LiveProtos.GiftStatus param2GiftStatus) {
        if (param2GiftStatus != null) {
          this.giftStatus_ = param2GiftStatus.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGiftStatusValue(int param2Int) {
        this.giftStatus_ = param2Int;
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.goodsId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGuestUid(String param2String) {
        if (param2String != null) {
          this.guestUid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setGuestUidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.guestUid_ = param2ByteString;
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.id_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIsAuto(boolean param2Boolean) {
        this.isAuto_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsHitTime(boolean param2Boolean) {
        this.isHitTime_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsJoin(boolean param2Boolean) {
        this.isJoin_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsMystery(boolean param2Boolean) {
        this.isMystery_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsOpen(boolean param2Boolean) {
        this.isOpen_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsPk(boolean param2Boolean) {
        this.isPk_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsQueue(boolean param2Boolean) {
        this.isQueue_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsSuccess(boolean param2Boolean) {
        this.isSuccess_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setLikeCount(int param2Int) {
        this.likeCount_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setLiveDuration(int param2Int) {
        this.liveDuration_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setLiveFrom(String param2String) {
        if (param2String != null) {
          this.liveFrom_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveFromBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.liveFrom_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveFromNum(int param2Int) {
        this.liveFromNum_ = param2Int;
        onChanged();
        return this;
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.liveId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveTab(String param2String) {
        if (param2String != null) {
          this.liveTab_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveTabBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.liveTab_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveType(LiveProtos.LiveType param2LiveType) {
        if (param2LiveType != null) {
          this.liveType_ = param2LiveType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveTypeId(String param2String) {
        if (param2String != null) {
          this.liveTypeId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveTypeIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.liveTypeId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveTypeValue(int param2Int) {
        this.liveType_ = param2Int;
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.musicId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMysteryUid(String param2String) {
        if (param2String != null) {
          this.mysteryUid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMysteryUidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.mysteryUid_ = param2ByteString;
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
      
      public Builder setOnlineCount(int param2Int) {
        this.onlineCount_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPageNum(int param2Int) {
        this.pageNum_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPassword(String param2String) {
        if (param2String != null) {
          this.password_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPasswordBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.password_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPayStatus(LiveProtos.PayStatus param2PayStatus) {
        if (param2PayStatus != null) {
          this.payStatus_ = param2PayStatus.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPayStatusValue(int param2Int) {
        this.payStatus_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPosition(int param2Int) {
        this.position_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRecommendLiveId(String param2String) {
        if (param2String != null) {
          this.recommendLiveId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRecommendLiveIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.recommendLiveId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRecommendType(String param2String) {
        if (param2String != null) {
          this.recommendType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRecommendTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.recommendType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRecommendUid(String param2String) {
        if (param2String != null) {
          this.recommendUid_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRecommendUidBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.recommendUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSource(LiveProtos.Source param2Source) {
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
      
      public Builder setStatus(LiveProtos.Status param2Status) {
        if (param2Status != null) {
          this.status_ = param2Status.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setStatusValue(int param2Int) {
        this.status_ = param2Int;
        onChanged();
        return this;
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTaskId(String param2String) {
        if (param2String != null) {
          this.taskId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTaskIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.taskId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTaskType(LiveProtos.TaskType param2TaskType) {
        if (param2TaskType != null) {
          this.taskType_ = param2TaskType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTaskTypeValue(int param2Int) {
        this.taskType_ = param2Int;
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
          LiveProtos.LiveProto.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setViewCount(int param2Int) {
        this.viewCount_ = param2Int;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<LiveProto> {
    public LiveProtos.LiveProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveProtos.LiveProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveProto.Builder> implements LiveProtoOrBuilder {
    private int awardType_ = 0;
    
    private int beansCount_;
    
    private int beansNum_;
    
    private int boxType_ = 0;
    
    private int btnType_ = 0;
    
    private int cardFrom_ = 0;
    
    private int condition_;
    
    private int count_;
    
    private int enterType_ = 0;
    
    private int event_ = 0;
    
    private Object featureId_ = "";
    
    private Object filterId_ = "";
    
    private int firstPayStatus_ = 0;
    
    private int followStatus_ = 0;
    
    private Object followedUid_ = "";
    
    private Object from_ = "";
    
    private int giftStatus_ = 0;
    
    private Object goodsId_ = "";
    
    private Object guestUid_ = "";
    
    private Object id_ = "";
    
    private boolean isAuto_;
    
    private boolean isHitTime_;
    
    private boolean isJoin_;
    
    private boolean isMystery_;
    
    private boolean isOpen_;
    
    private boolean isPk_;
    
    private boolean isQueue_;
    
    private boolean isSuccess_;
    
    private int likeCount_;
    
    private int liveDuration_;
    
    private int liveFromNum_;
    
    private Object liveFrom_ = "";
    
    private Object liveId_ = "";
    
    private Object liveTab_ = "";
    
    private Object liveTypeId_ = "";
    
    private int liveType_ = 0;
    
    private Object musicId_ = "";
    
    private Object mysteryUid_ = "";
    
    private int num_;
    
    private int onlineCount_;
    
    private int pageNum_;
    
    private Object password_ = "";
    
    private int payStatus_ = 0;
    
    private int position_;
    
    private Object recommendLiveId_ = "";
    
    private Object recommendType_ = "";
    
    private Object recommendUid_ = "";
    
    private int source_ = 0;
    
    private int status_ = 0;
    
    private Object tabId_ = "";
    
    private int tabNum_;
    
    private Object targetUid_ = "";
    
    private Object taskId_ = "";
    
    private int taskType_ = 0;
    
    private Object url_ = "";
    
    private int viewCount_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveProtos.internal_static_com_blued_das_live_LiveProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveProtos.LiveProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveProtos.LiveProto build() {
      LiveProtos.LiveProto liveProto = buildPartial();
      if (liveProto.isInitialized())
        return liveProto; 
      throw newUninitializedMessageException(liveProto);
    }
    
    public LiveProtos.LiveProto buildPartial() {
      LiveProtos.LiveProto liveProto = new LiveProtos.LiveProto(this);
      LiveProtos.LiveProto.access$602(liveProto, this.event_);
      LiveProtos.LiveProto.access$702(liveProto, this.giftStatus_);
      LiveProtos.LiveProto.access$802(liveProto, this.enterType_);
      LiveProtos.LiveProto.access$902(liveProto, this.status_);
      LiveProtos.LiveProto.access$1002(liveProto, this.filterId_);
      LiveProtos.LiveProto.access$1102(liveProto, this.isAuto_);
      LiveProtos.LiveProto.access$1202(liveProto, this.firstPayStatus_);
      LiveProtos.LiveProto.access$1302(liveProto, this.payStatus_);
      LiveProtos.LiveProto.access$1402(liveProto, this.liveId_);
      LiveProtos.LiveProto.access$1502(liveProto, this.url_);
      LiveProtos.LiveProto.access$1602(liveProto, this.targetUid_);
      LiveProtos.LiveProto.access$1702(liveProto, this.featureId_);
      LiveProtos.LiveProto.access$1802(liveProto, this.boxType_);
      LiveProtos.LiveProto.access$1902(liveProto, this.taskType_);
      LiveProtos.LiveProto.access$2002(liveProto, this.awardType_);
      LiveProtos.LiveProto.access$2102(liveProto, this.count_);
      LiveProtos.LiveProto.access$2202(liveProto, this.followStatus_);
      LiveProtos.LiveProto.access$2302(liveProto, this.isSuccess_);
      LiveProtos.LiveProto.access$2402(liveProto, this.liveTypeId_);
      LiveProtos.LiveProto.access$2502(liveProto, this.isJoin_);
      LiveProtos.LiveProto.access$2602(liveProto, this.btnType_);
      LiveProtos.LiveProto.access$2702(liveProto, this.source_);
      LiveProtos.LiveProto.access$2802(liveProto, this.taskId_);
      LiveProtos.LiveProto.access$2902(liveProto, this.liveType_);
      LiveProtos.LiveProto.access$3002(liveProto, this.beansCount_);
      LiveProtos.LiveProto.access$3102(liveProto, this.beansNum_);
      LiveProtos.LiveProto.access$3202(liveProto, this.viewCount_);
      LiveProtos.LiveProto.access$3302(liveProto, this.likeCount_);
      LiveProtos.LiveProto.access$3402(liveProto, this.onlineCount_);
      LiveProtos.LiveProto.access$3502(liveProto, this.liveDuration_);
      LiveProtos.LiveProto.access$3602(liveProto, this.goodsId_);
      LiveProtos.LiveProto.access$3702(liveProto, this.num_);
      LiveProtos.LiveProto.access$3802(liveProto, this.guestUid_);
      LiveProtos.LiveProto.access$3902(liveProto, this.recommendLiveId_);
      LiveProtos.LiveProto.access$4002(liveProto, this.recommendUid_);
      LiveProtos.LiveProto.access$4102(liveProto, this.isQueue_);
      LiveProtos.LiveProto.access$4202(liveProto, this.cardFrom_);
      LiveProtos.LiveProto.access$4302(liveProto, this.isOpen_);
      LiveProtos.LiveProto.access$4402(liveProto, this.liveFrom_);
      LiveProtos.LiveProto.access$4502(liveProto, this.isMystery_);
      LiveProtos.LiveProto.access$4602(liveProto, this.mysteryUid_);
      LiveProtos.LiveProto.access$4702(liveProto, this.musicId_);
      LiveProtos.LiveProto.access$4802(liveProto, this.tabId_);
      LiveProtos.LiveProto.access$4902(liveProto, this.password_);
      LiveProtos.LiveProto.access$5002(liveProto, this.condition_);
      LiveProtos.LiveProto.access$5102(liveProto, this.liveTab_);
      LiveProtos.LiveProto.access$5202(liveProto, this.position_);
      LiveProtos.LiveProto.access$5302(liveProto, this.tabNum_);
      LiveProtos.LiveProto.access$5402(liveProto, this.pageNum_);
      LiveProtos.LiveProto.access$5502(liveProto, this.id_);
      LiveProtos.LiveProto.access$5602(liveProto, this.liveFromNum_);
      LiveProtos.LiveProto.access$5702(liveProto, this.followedUid_);
      LiveProtos.LiveProto.access$5802(liveProto, this.recommendType_);
      LiveProtos.LiveProto.access$5902(liveProto, this.from_);
      LiveProtos.LiveProto.access$6002(liveProto, this.isHitTime_);
      LiveProtos.LiveProto.access$6102(liveProto, this.isPk_);
      onBuilt();
      return liveProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.giftStatus_ = 0;
      this.enterType_ = 0;
      this.status_ = 0;
      this.filterId_ = "";
      this.isAuto_ = false;
      this.firstPayStatus_ = 0;
      this.payStatus_ = 0;
      this.liveId_ = "";
      this.url_ = "";
      this.targetUid_ = "";
      this.featureId_ = "";
      this.boxType_ = 0;
      this.taskType_ = 0;
      this.awardType_ = 0;
      this.count_ = 0;
      this.followStatus_ = 0;
      this.isSuccess_ = false;
      this.liveTypeId_ = "";
      this.isJoin_ = false;
      this.btnType_ = 0;
      this.source_ = 0;
      this.taskId_ = "";
      this.liveType_ = 0;
      this.beansCount_ = 0;
      this.beansNum_ = 0;
      this.viewCount_ = 0;
      this.likeCount_ = 0;
      this.onlineCount_ = 0;
      this.liveDuration_ = 0;
      this.goodsId_ = "";
      this.num_ = 0;
      this.guestUid_ = "";
      this.recommendLiveId_ = "";
      this.recommendUid_ = "";
      this.isQueue_ = false;
      this.cardFrom_ = 0;
      this.isOpen_ = false;
      this.liveFrom_ = "";
      this.isMystery_ = false;
      this.mysteryUid_ = "";
      this.musicId_ = "";
      this.tabId_ = "";
      this.password_ = "";
      this.condition_ = 0;
      this.liveTab_ = "";
      this.position_ = 0;
      this.tabNum_ = 0;
      this.pageNum_ = 0;
      this.id_ = "";
      this.liveFromNum_ = 0;
      this.followedUid_ = "";
      this.recommendType_ = "";
      this.from_ = "";
      this.isHitTime_ = false;
      this.isPk_ = false;
      return this;
    }
    
    public Builder clearAwardType() {
      this.awardType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearBeansCount() {
      this.beansCount_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearBeansNum() {
      this.beansNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearBoxType() {
      this.boxType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearBtnType() {
      this.btnType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearCardFrom() {
      this.cardFrom_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearCondition() {
      this.condition_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearCount() {
      this.count_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearEnterType() {
      this.enterType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeatureId() {
      this.featureId_ = LiveProtos.LiveProto.getDefaultInstance().getFeatureId();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFilterId() {
      this.filterId_ = LiveProtos.LiveProto.getDefaultInstance().getFilterId();
      onChanged();
      return this;
    }
    
    public Builder clearFirstPayStatus() {
      this.firstPayStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFollowStatus() {
      this.followStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFollowedUid() {
      this.followedUid_ = LiveProtos.LiveProto.getDefaultInstance().getFollowedUid();
      onChanged();
      return this;
    }
    
    public Builder clearFrom() {
      this.from_ = LiveProtos.LiveProto.getDefaultInstance().getFrom();
      onChanged();
      return this;
    }
    
    public Builder clearGiftStatus() {
      this.giftStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearGoodsId() {
      this.goodsId_ = LiveProtos.LiveProto.getDefaultInstance().getGoodsId();
      onChanged();
      return this;
    }
    
    public Builder clearGuestUid() {
      this.guestUid_ = LiveProtos.LiveProto.getDefaultInstance().getGuestUid();
      onChanged();
      return this;
    }
    
    public Builder clearId() {
      this.id_ = LiveProtos.LiveProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearIsAuto() {
      this.isAuto_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsHitTime() {
      this.isHitTime_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsJoin() {
      this.isJoin_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsMystery() {
      this.isMystery_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsOpen() {
      this.isOpen_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsPk() {
      this.isPk_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsQueue() {
      this.isQueue_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsSuccess() {
      this.isSuccess_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearLikeCount() {
      this.likeCount_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearLiveDuration() {
      this.liveDuration_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearLiveFrom() {
      this.liveFrom_ = LiveProtos.LiveProto.getDefaultInstance().getLiveFrom();
      onChanged();
      return this;
    }
    
    public Builder clearLiveFromNum() {
      this.liveFromNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearLiveId() {
      this.liveId_ = LiveProtos.LiveProto.getDefaultInstance().getLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearLiveTab() {
      this.liveTab_ = LiveProtos.LiveProto.getDefaultInstance().getLiveTab();
      onChanged();
      return this;
    }
    
    public Builder clearLiveType() {
      this.liveType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearLiveTypeId() {
      this.liveTypeId_ = LiveProtos.LiveProto.getDefaultInstance().getLiveTypeId();
      onChanged();
      return this;
    }
    
    public Builder clearMusicId() {
      this.musicId_ = LiveProtos.LiveProto.getDefaultInstance().getMusicId();
      onChanged();
      return this;
    }
    
    public Builder clearMysteryUid() {
      this.mysteryUid_ = LiveProtos.LiveProto.getDefaultInstance().getMysteryUid();
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
    
    public Builder clearOnlineCount() {
      this.onlineCount_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPageNum() {
      this.pageNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPassword() {
      this.password_ = LiveProtos.LiveProto.getDefaultInstance().getPassword();
      onChanged();
      return this;
    }
    
    public Builder clearPayStatus() {
      this.payStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPosition() {
      this.position_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearRecommendLiveId() {
      this.recommendLiveId_ = LiveProtos.LiveProto.getDefaultInstance().getRecommendLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearRecommendType() {
      this.recommendType_ = LiveProtos.LiveProto.getDefaultInstance().getRecommendType();
      onChanged();
      return this;
    }
    
    public Builder clearRecommendUid() {
      this.recommendUid_ = LiveProtos.LiveProto.getDefaultInstance().getRecommendUid();
      onChanged();
      return this;
    }
    
    public Builder clearSource() {
      this.source_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearStatus() {
      this.status_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTabId() {
      this.tabId_ = LiveProtos.LiveProto.getDefaultInstance().getTabId();
      onChanged();
      return this;
    }
    
    public Builder clearTabNum() {
      this.tabNum_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = LiveProtos.LiveProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clearTaskId() {
      this.taskId_ = LiveProtos.LiveProto.getDefaultInstance().getTaskId();
      onChanged();
      return this;
    }
    
    public Builder clearTaskType() {
      this.taskType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearUrl() {
      this.url_ = LiveProtos.LiveProto.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clearViewCount() {
      this.viewCount_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LiveProtos.AwardType getAwardType() {
      LiveProtos.AwardType awardType2 = LiveProtos.AwardType.valueOf(this.awardType_);
      LiveProtos.AwardType awardType1 = awardType2;
      if (awardType2 == null)
        awardType1 = LiveProtos.AwardType.UNRECOGNIZED; 
      return awardType1;
    }
    
    public int getAwardTypeValue() {
      return this.awardType_;
    }
    
    public int getBeansCount() {
      return this.beansCount_;
    }
    
    public int getBeansNum() {
      return this.beansNum_;
    }
    
    public LiveProtos.BoxType getBoxType() {
      LiveProtos.BoxType boxType2 = LiveProtos.BoxType.valueOf(this.boxType_);
      LiveProtos.BoxType boxType1 = boxType2;
      if (boxType2 == null)
        boxType1 = LiveProtos.BoxType.UNRECOGNIZED; 
      return boxType1;
    }
    
    public int getBoxTypeValue() {
      return this.boxType_;
    }
    
    public LiveProtos.BtnType getBtnType() {
      LiveProtos.BtnType btnType2 = LiveProtos.BtnType.valueOf(this.btnType_);
      LiveProtos.BtnType btnType1 = btnType2;
      if (btnType2 == null)
        btnType1 = LiveProtos.BtnType.UNRECOGNIZED; 
      return btnType1;
    }
    
    public int getBtnTypeValue() {
      return this.btnType_;
    }
    
    public LiveProtos.CardFrom getCardFrom() {
      LiveProtos.CardFrom cardFrom2 = LiveProtos.CardFrom.valueOf(this.cardFrom_);
      LiveProtos.CardFrom cardFrom1 = cardFrom2;
      if (cardFrom2 == null)
        cardFrom1 = LiveProtos.CardFrom.UNRECOGNIZED; 
      return cardFrom1;
    }
    
    public int getCardFromValue() {
      return this.cardFrom_;
    }
    
    public int getCondition() {
      return this.condition_;
    }
    
    public int getCount() {
      return this.count_;
    }
    
    public LiveProtos.LiveProto getDefaultInstanceForType() {
      return LiveProtos.LiveProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveProtos.internal_static_com_blued_das_live_LiveProto_descriptor;
    }
    
    public LiveProtos.EnterType getEnterType() {
      LiveProtos.EnterType enterType2 = LiveProtos.EnterType.valueOf(this.enterType_);
      LiveProtos.EnterType enterType1 = enterType2;
      if (enterType2 == null)
        enterType1 = LiveProtos.EnterType.UNRECOGNIZED; 
      return enterType1;
    }
    
    public int getEnterTypeValue() {
      return this.enterType_;
    }
    
    public LiveProtos.Event getEvent() {
      LiveProtos.Event event2 = LiveProtos.Event.valueOf(this.event_);
      LiveProtos.Event event1 = event2;
      if (event2 == null)
        event1 = LiveProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getFeatureId() {
      Object object = this.featureId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.featureId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFeatureIdBytes() {
      Object object = this.featureId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.featureId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getFilterId() {
      Object object = this.filterId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.filterId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFilterIdBytes() {
      Object object = this.filterId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.filterId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.FirstPayStatus getFirstPayStatus() {
      LiveProtos.FirstPayStatus firstPayStatus2 = LiveProtos.FirstPayStatus.valueOf(this.firstPayStatus_);
      LiveProtos.FirstPayStatus firstPayStatus1 = firstPayStatus2;
      if (firstPayStatus2 == null)
        firstPayStatus1 = LiveProtos.FirstPayStatus.UNRECOGNIZED; 
      return firstPayStatus1;
    }
    
    public int getFirstPayStatusValue() {
      return this.firstPayStatus_;
    }
    
    public LiveProtos.FollowStatus getFollowStatus() {
      LiveProtos.FollowStatus followStatus2 = LiveProtos.FollowStatus.valueOf(this.followStatus_);
      LiveProtos.FollowStatus followStatus1 = followStatus2;
      if (followStatus2 == null)
        followStatus1 = LiveProtos.FollowStatus.UNRECOGNIZED; 
      return followStatus1;
    }
    
    public int getFollowStatusValue() {
      return this.followStatus_;
    }
    
    public String getFollowedUid() {
      Object object = this.followedUid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.followedUid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFollowedUidBytes() {
      Object object = this.followedUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.followedUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getFrom() {
      Object object = this.from_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.from_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getFromBytes() {
      Object object = this.from_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.from_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.GiftStatus getGiftStatus() {
      LiveProtos.GiftStatus giftStatus2 = LiveProtos.GiftStatus.valueOf(this.giftStatus_);
      LiveProtos.GiftStatus giftStatus1 = giftStatus2;
      if (giftStatus2 == null)
        giftStatus1 = LiveProtos.GiftStatus.UNRECOGNIZED; 
      return giftStatus1;
    }
    
    public int getGiftStatusValue() {
      return this.giftStatus_;
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
    
    public String getGuestUid() {
      Object object = this.guestUid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.guestUid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getGuestUidBytes() {
      Object object = this.guestUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.guestUid_ = object;
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
    
    public boolean getIsAuto() {
      return this.isAuto_;
    }
    
    public boolean getIsHitTime() {
      return this.isHitTime_;
    }
    
    public boolean getIsJoin() {
      return this.isJoin_;
    }
    
    public boolean getIsMystery() {
      return this.isMystery_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsPk() {
      return this.isPk_;
    }
    
    public boolean getIsQueue() {
      return this.isQueue_;
    }
    
    public boolean getIsSuccess() {
      return this.isSuccess_;
    }
    
    public int getLikeCount() {
      return this.likeCount_;
    }
    
    public int getLiveDuration() {
      return this.liveDuration_;
    }
    
    public String getLiveFrom() {
      Object object = this.liveFrom_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.liveFrom_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLiveFromBytes() {
      Object object = this.liveFrom_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveFrom_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getLiveFromNum() {
      return this.liveFromNum_;
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
    
    public String getLiveTab() {
      Object object = this.liveTab_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.liveTab_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLiveTabBytes() {
      Object object = this.liveTab_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveTab_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.LiveType getLiveType() {
      LiveProtos.LiveType liveType2 = LiveProtos.LiveType.valueOf(this.liveType_);
      LiveProtos.LiveType liveType1 = liveType2;
      if (liveType2 == null)
        liveType1 = LiveProtos.LiveType.UNRECOGNIZED; 
      return liveType1;
    }
    
    public String getLiveTypeId() {
      Object object = this.liveTypeId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.liveTypeId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLiveTypeIdBytes() {
      Object object = this.liveTypeId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveTypeId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getLiveTypeValue() {
      return this.liveType_;
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
    
    public String getMysteryUid() {
      Object object = this.mysteryUid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.mysteryUid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMysteryUidBytes() {
      Object object = this.mysteryUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.mysteryUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public int getOnlineCount() {
      return this.onlineCount_;
    }
    
    public int getPageNum() {
      return this.pageNum_;
    }
    
    public String getPassword() {
      Object object = this.password_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.password_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPasswordBytes() {
      Object object = this.password_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.password_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.PayStatus getPayStatus() {
      LiveProtos.PayStatus payStatus2 = LiveProtos.PayStatus.valueOf(this.payStatus_);
      LiveProtos.PayStatus payStatus1 = payStatus2;
      if (payStatus2 == null)
        payStatus1 = LiveProtos.PayStatus.UNRECOGNIZED; 
      return payStatus1;
    }
    
    public int getPayStatusValue() {
      return this.payStatus_;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public String getRecommendLiveId() {
      Object object = this.recommendLiveId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.recommendLiveId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRecommendLiveIdBytes() {
      Object object = this.recommendLiveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.recommendLiveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRecommendType() {
      Object object = this.recommendType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.recommendType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRecommendTypeBytes() {
      Object object = this.recommendType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.recommendType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRecommendUid() {
      Object object = this.recommendUid_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.recommendUid_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRecommendUidBytes() {
      Object object = this.recommendUid_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.recommendUid_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.Source getSource() {
      LiveProtos.Source source2 = LiveProtos.Source.valueOf(this.source_);
      LiveProtos.Source source1 = source2;
      if (source2 == null)
        source1 = LiveProtos.Source.UNRECOGNIZED; 
      return source1;
    }
    
    public int getSourceValue() {
      return this.source_;
    }
    
    public LiveProtos.Status getStatus() {
      LiveProtos.Status status2 = LiveProtos.Status.valueOf(this.status_);
      LiveProtos.Status status1 = status2;
      if (status2 == null)
        status1 = LiveProtos.Status.UNRECOGNIZED; 
      return status1;
    }
    
    public int getStatusValue() {
      return this.status_;
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
    
    public String getTaskId() {
      Object object = this.taskId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.taskId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTaskIdBytes() {
      Object object = this.taskId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.taskId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveProtos.TaskType getTaskType() {
      LiveProtos.TaskType taskType2 = LiveProtos.TaskType.valueOf(this.taskType_);
      LiveProtos.TaskType taskType1 = taskType2;
      if (taskType2 == null)
        taskType1 = LiveProtos.TaskType.UNRECOGNIZED; 
      return taskType1;
    }
    
    public int getTaskTypeValue() {
      return this.taskType_;
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
    
    public int getViewCount() {
      return this.viewCount_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveProtos.internal_static_com_blued_das_live_LiveProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveProtos.LiveProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveProtos.LiveProto param1LiveProto) {
      if (param1LiveProto == LiveProtos.LiveProto.getDefaultInstance())
        return this; 
      if (param1LiveProto.event_ != 0)
        setEventValue(param1LiveProto.getEventValue()); 
      if (param1LiveProto.giftStatus_ != 0)
        setGiftStatusValue(param1LiveProto.getGiftStatusValue()); 
      if (param1LiveProto.enterType_ != 0)
        setEnterTypeValue(param1LiveProto.getEnterTypeValue()); 
      if (param1LiveProto.status_ != 0)
        setStatusValue(param1LiveProto.getStatusValue()); 
      if (!param1LiveProto.getFilterId().isEmpty()) {
        this.filterId_ = param1LiveProto.filterId_;
        onChanged();
      } 
      if (param1LiveProto.getIsAuto())
        setIsAuto(param1LiveProto.getIsAuto()); 
      if (param1LiveProto.firstPayStatus_ != 0)
        setFirstPayStatusValue(param1LiveProto.getFirstPayStatusValue()); 
      if (param1LiveProto.payStatus_ != 0)
        setPayStatusValue(param1LiveProto.getPayStatusValue()); 
      if (!param1LiveProto.getLiveId().isEmpty()) {
        this.liveId_ = param1LiveProto.liveId_;
        onChanged();
      } 
      if (!param1LiveProto.getUrl().isEmpty()) {
        this.url_ = param1LiveProto.url_;
        onChanged();
      } 
      if (!param1LiveProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1LiveProto.targetUid_;
        onChanged();
      } 
      if (!param1LiveProto.getFeatureId().isEmpty()) {
        this.featureId_ = param1LiveProto.featureId_;
        onChanged();
      } 
      if (param1LiveProto.boxType_ != 0)
        setBoxTypeValue(param1LiveProto.getBoxTypeValue()); 
      if (param1LiveProto.taskType_ != 0)
        setTaskTypeValue(param1LiveProto.getTaskTypeValue()); 
      if (param1LiveProto.awardType_ != 0)
        setAwardTypeValue(param1LiveProto.getAwardTypeValue()); 
      if (param1LiveProto.getCount() != 0)
        setCount(param1LiveProto.getCount()); 
      if (param1LiveProto.followStatus_ != 0)
        setFollowStatusValue(param1LiveProto.getFollowStatusValue()); 
      if (param1LiveProto.getIsSuccess())
        setIsSuccess(param1LiveProto.getIsSuccess()); 
      if (!param1LiveProto.getLiveTypeId().isEmpty()) {
        this.liveTypeId_ = param1LiveProto.liveTypeId_;
        onChanged();
      } 
      if (param1LiveProto.getIsJoin())
        setIsJoin(param1LiveProto.getIsJoin()); 
      if (param1LiveProto.btnType_ != 0)
        setBtnTypeValue(param1LiveProto.getBtnTypeValue()); 
      if (param1LiveProto.source_ != 0)
        setSourceValue(param1LiveProto.getSourceValue()); 
      if (!param1LiveProto.getTaskId().isEmpty()) {
        this.taskId_ = param1LiveProto.taskId_;
        onChanged();
      } 
      if (param1LiveProto.liveType_ != 0)
        setLiveTypeValue(param1LiveProto.getLiveTypeValue()); 
      if (param1LiveProto.getBeansCount() != 0)
        setBeansCount(param1LiveProto.getBeansCount()); 
      if (param1LiveProto.getBeansNum() != 0)
        setBeansNum(param1LiveProto.getBeansNum()); 
      if (param1LiveProto.getViewCount() != 0)
        setViewCount(param1LiveProto.getViewCount()); 
      if (param1LiveProto.getLikeCount() != 0)
        setLikeCount(param1LiveProto.getLikeCount()); 
      if (param1LiveProto.getOnlineCount() != 0)
        setOnlineCount(param1LiveProto.getOnlineCount()); 
      if (param1LiveProto.getLiveDuration() != 0)
        setLiveDuration(param1LiveProto.getLiveDuration()); 
      if (!param1LiveProto.getGoodsId().isEmpty()) {
        this.goodsId_ = param1LiveProto.goodsId_;
        onChanged();
      } 
      if (param1LiveProto.getNum() != 0)
        setNum(param1LiveProto.getNum()); 
      if (!param1LiveProto.getGuestUid().isEmpty()) {
        this.guestUid_ = param1LiveProto.guestUid_;
        onChanged();
      } 
      if (!param1LiveProto.getRecommendLiveId().isEmpty()) {
        this.recommendLiveId_ = param1LiveProto.recommendLiveId_;
        onChanged();
      } 
      if (!param1LiveProto.getRecommendUid().isEmpty()) {
        this.recommendUid_ = param1LiveProto.recommendUid_;
        onChanged();
      } 
      if (param1LiveProto.getIsQueue())
        setIsQueue(param1LiveProto.getIsQueue()); 
      if (param1LiveProto.cardFrom_ != 0)
        setCardFromValue(param1LiveProto.getCardFromValue()); 
      if (param1LiveProto.getIsOpen())
        setIsOpen(param1LiveProto.getIsOpen()); 
      if (!param1LiveProto.getLiveFrom().isEmpty()) {
        this.liveFrom_ = param1LiveProto.liveFrom_;
        onChanged();
      } 
      if (param1LiveProto.getIsMystery())
        setIsMystery(param1LiveProto.getIsMystery()); 
      if (!param1LiveProto.getMysteryUid().isEmpty()) {
        this.mysteryUid_ = param1LiveProto.mysteryUid_;
        onChanged();
      } 
      if (!param1LiveProto.getMusicId().isEmpty()) {
        this.musicId_ = param1LiveProto.musicId_;
        onChanged();
      } 
      if (!param1LiveProto.getTabId().isEmpty()) {
        this.tabId_ = param1LiveProto.tabId_;
        onChanged();
      } 
      if (!param1LiveProto.getPassword().isEmpty()) {
        this.password_ = param1LiveProto.password_;
        onChanged();
      } 
      if (param1LiveProto.getCondition() != 0)
        setCondition(param1LiveProto.getCondition()); 
      if (!param1LiveProto.getLiveTab().isEmpty()) {
        this.liveTab_ = param1LiveProto.liveTab_;
        onChanged();
      } 
      if (param1LiveProto.getPosition() != 0)
        setPosition(param1LiveProto.getPosition()); 
      if (param1LiveProto.getTabNum() != 0)
        setTabNum(param1LiveProto.getTabNum()); 
      if (param1LiveProto.getPageNum() != 0)
        setPageNum(param1LiveProto.getPageNum()); 
      if (!param1LiveProto.getId().isEmpty()) {
        this.id_ = param1LiveProto.id_;
        onChanged();
      } 
      if (param1LiveProto.getLiveFromNum() != 0)
        setLiveFromNum(param1LiveProto.getLiveFromNum()); 
      if (!param1LiveProto.getFollowedUid().isEmpty()) {
        this.followedUid_ = param1LiveProto.followedUid_;
        onChanged();
      } 
      if (!param1LiveProto.getRecommendType().isEmpty()) {
        this.recommendType_ = param1LiveProto.recommendType_;
        onChanged();
      } 
      if (!param1LiveProto.getFrom().isEmpty()) {
        this.from_ = param1LiveProto.from_;
        onChanged();
      } 
      if (param1LiveProto.getIsHitTime())
        setIsHitTime(param1LiveProto.getIsHitTime()); 
      if (param1LiveProto.getIsPk())
        setIsPk(param1LiveProto.getIsPk()); 
      mergeUnknownFields(param1LiveProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveProtos.LiveProto liveProto = (LiveProtos.LiveProto)LiveProtos.LiveProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveProtos.LiveProto liveProto = (LiveProtos.LiveProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveProtos.LiveProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveProtos.LiveProto)
        return mergeFrom((LiveProtos.LiveProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAwardType(LiveProtos.AwardType param1AwardType) {
      if (param1AwardType != null) {
        this.awardType_ = param1AwardType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAwardTypeValue(int param1Int) {
      this.awardType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setBeansCount(int param1Int) {
      this.beansCount_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setBeansNum(int param1Int) {
      this.beansNum_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setBoxType(LiveProtos.BoxType param1BoxType) {
      if (param1BoxType != null) {
        this.boxType_ = param1BoxType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBoxTypeValue(int param1Int) {
      this.boxType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setBtnType(LiveProtos.BtnType param1BtnType) {
      if (param1BtnType != null) {
        this.btnType_ = param1BtnType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBtnTypeValue(int param1Int) {
      this.btnType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setCardFrom(LiveProtos.CardFrom param1CardFrom) {
      if (param1CardFrom != null) {
        this.cardFrom_ = param1CardFrom.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCardFromValue(int param1Int) {
      this.cardFrom_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setCondition(int param1Int) {
      this.condition_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setCount(int param1Int) {
      this.count_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setEnterType(LiveProtos.EnterType param1EnterType) {
      if (param1EnterType != null) {
        this.enterType_ = param1EnterType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEnterTypeValue(int param1Int) {
      this.enterType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setEvent(LiveProtos.Event param1Event) {
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
    
    public Builder setFeatureId(String param1String) {
      if (param1String != null) {
        this.featureId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeatureIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.featureId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFilterId(String param1String) {
      if (param1String != null) {
        this.filterId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFilterIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.filterId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFirstPayStatus(LiveProtos.FirstPayStatus param1FirstPayStatus) {
      if (param1FirstPayStatus != null) {
        this.firstPayStatus_ = param1FirstPayStatus.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFirstPayStatusValue(int param1Int) {
      this.firstPayStatus_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setFollowStatus(LiveProtos.FollowStatus param1FollowStatus) {
      if (param1FollowStatus != null) {
        this.followStatus_ = param1FollowStatus.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFollowStatusValue(int param1Int) {
      this.followStatus_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setFollowedUid(String param1String) {
      if (param1String != null) {
        this.followedUid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFollowedUidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.followedUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFrom(String param1String) {
      if (param1String != null) {
        this.from_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFromBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.from_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGiftStatus(LiveProtos.GiftStatus param1GiftStatus) {
      if (param1GiftStatus != null) {
        this.giftStatus_ = param1GiftStatus.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGiftStatusValue(int param1Int) {
      this.giftStatus_ = param1Int;
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.goodsId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGuestUid(String param1String) {
      if (param1String != null) {
        this.guestUid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setGuestUidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.guestUid_ = param1ByteString;
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIsAuto(boolean param1Boolean) {
      this.isAuto_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsHitTime(boolean param1Boolean) {
      this.isHitTime_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsJoin(boolean param1Boolean) {
      this.isJoin_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsMystery(boolean param1Boolean) {
      this.isMystery_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsOpen(boolean param1Boolean) {
      this.isOpen_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsPk(boolean param1Boolean) {
      this.isPk_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsQueue(boolean param1Boolean) {
      this.isQueue_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsSuccess(boolean param1Boolean) {
      this.isSuccess_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setLikeCount(int param1Int) {
      this.likeCount_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setLiveDuration(int param1Int) {
      this.liveDuration_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setLiveFrom(String param1String) {
      if (param1String != null) {
        this.liveFrom_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveFromBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.liveFrom_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveFromNum(int param1Int) {
      this.liveFromNum_ = param1Int;
      onChanged();
      return this;
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.liveId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveTab(String param1String) {
      if (param1String != null) {
        this.liveTab_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveTabBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.liveTab_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveType(LiveProtos.LiveType param1LiveType) {
      if (param1LiveType != null) {
        this.liveType_ = param1LiveType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveTypeId(String param1String) {
      if (param1String != null) {
        this.liveTypeId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveTypeIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.liveTypeId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveTypeValue(int param1Int) {
      this.liveType_ = param1Int;
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.musicId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMysteryUid(String param1String) {
      if (param1String != null) {
        this.mysteryUid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMysteryUidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.mysteryUid_ = param1ByteString;
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
    
    public Builder setOnlineCount(int param1Int) {
      this.onlineCount_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPageNum(int param1Int) {
      this.pageNum_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPassword(String param1String) {
      if (param1String != null) {
        this.password_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPasswordBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.password_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPayStatus(LiveProtos.PayStatus param1PayStatus) {
      if (param1PayStatus != null) {
        this.payStatus_ = param1PayStatus.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPayStatusValue(int param1Int) {
      this.payStatus_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPosition(int param1Int) {
      this.position_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRecommendLiveId(String param1String) {
      if (param1String != null) {
        this.recommendLiveId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRecommendLiveIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.recommendLiveId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRecommendType(String param1String) {
      if (param1String != null) {
        this.recommendType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRecommendTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.recommendType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRecommendUid(String param1String) {
      if (param1String != null) {
        this.recommendUid_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRecommendUidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.recommendUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSource(LiveProtos.Source param1Source) {
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
    
    public Builder setStatus(LiveProtos.Status param1Status) {
      if (param1Status != null) {
        this.status_ = param1Status.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setStatusValue(int param1Int) {
      this.status_ = param1Int;
      onChanged();
      return this;
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTaskId(String param1String) {
      if (param1String != null) {
        this.taskId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTaskIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.taskId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTaskType(LiveProtos.TaskType param1TaskType) {
      if (param1TaskType != null) {
        this.taskType_ = param1TaskType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTaskTypeValue(int param1Int) {
      this.taskType_ = param1Int;
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
        LiveProtos.LiveProto.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setViewCount(int param1Int) {
      this.viewCount_ = param1Int;
      onChanged();
      return this;
    }
  }
  
  public static interface LiveProtoOrBuilder extends MessageOrBuilder {
    LiveProtos.AwardType getAwardType();
    
    int getAwardTypeValue();
    
    int getBeansCount();
    
    int getBeansNum();
    
    LiveProtos.BoxType getBoxType();
    
    int getBoxTypeValue();
    
    LiveProtos.BtnType getBtnType();
    
    int getBtnTypeValue();
    
    LiveProtos.CardFrom getCardFrom();
    
    int getCardFromValue();
    
    int getCondition();
    
    int getCount();
    
    LiveProtos.EnterType getEnterType();
    
    int getEnterTypeValue();
    
    LiveProtos.Event getEvent();
    
    int getEventValue();
    
    String getFeatureId();
    
    ByteString getFeatureIdBytes();
    
    String getFilterId();
    
    ByteString getFilterIdBytes();
    
    LiveProtos.FirstPayStatus getFirstPayStatus();
    
    int getFirstPayStatusValue();
    
    LiveProtos.FollowStatus getFollowStatus();
    
    int getFollowStatusValue();
    
    String getFollowedUid();
    
    ByteString getFollowedUidBytes();
    
    String getFrom();
    
    ByteString getFromBytes();
    
    LiveProtos.GiftStatus getGiftStatus();
    
    int getGiftStatusValue();
    
    String getGoodsId();
    
    ByteString getGoodsIdBytes();
    
    String getGuestUid();
    
    ByteString getGuestUidBytes();
    
    String getId();
    
    ByteString getIdBytes();
    
    boolean getIsAuto();
    
    boolean getIsHitTime();
    
    boolean getIsJoin();
    
    boolean getIsMystery();
    
    boolean getIsOpen();
    
    boolean getIsPk();
    
    boolean getIsQueue();
    
    boolean getIsSuccess();
    
    int getLikeCount();
    
    int getLiveDuration();
    
    String getLiveFrom();
    
    ByteString getLiveFromBytes();
    
    int getLiveFromNum();
    
    String getLiveId();
    
    ByteString getLiveIdBytes();
    
    String getLiveTab();
    
    ByteString getLiveTabBytes();
    
    LiveProtos.LiveType getLiveType();
    
    String getLiveTypeId();
    
    ByteString getLiveTypeIdBytes();
    
    int getLiveTypeValue();
    
    String getMusicId();
    
    ByteString getMusicIdBytes();
    
    String getMysteryUid();
    
    ByteString getMysteryUidBytes();
    
    int getNum();
    
    int getOnlineCount();
    
    int getPageNum();
    
    String getPassword();
    
    ByteString getPasswordBytes();
    
    LiveProtos.PayStatus getPayStatus();
    
    int getPayStatusValue();
    
    int getPosition();
    
    String getRecommendLiveId();
    
    ByteString getRecommendLiveIdBytes();
    
    String getRecommendType();
    
    ByteString getRecommendTypeBytes();
    
    String getRecommendUid();
    
    ByteString getRecommendUidBytes();
    
    LiveProtos.Source getSource();
    
    int getSourceValue();
    
    LiveProtos.Status getStatus();
    
    int getStatusValue();
    
    String getTabId();
    
    ByteString getTabIdBytes();
    
    int getTabNum();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
    
    String getTaskId();
    
    ByteString getTaskIdBytes();
    
    LiveProtos.TaskType getTaskType();
    
    int getTaskTypeValue();
    
    String getUrl();
    
    ByteString getUrlBytes();
    
    int getViewCount();
  }
  
  public enum LiveType implements ProtocolMessageEnum {
    BLIND_DATING_LIVE(0),
    SHOW_LIVE(0),
    UNKNOWN_LIVE_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int BLIND_DATING_LIVE_VALUE = 1;
    
    public static final int SHOW_LIVE_VALUE = 2;
    
    public static final int UNKNOWN_LIVE_TYPE_VALUE = 0;
    
    private static final LiveType[] VALUES;
    
    private static final Internal.EnumLiteMap<LiveType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new LiveType[] { UNKNOWN_LIVE_TYPE, BLIND_DATING_LIVE, SHOW_LIVE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<LiveType>() {
          public LiveProtos.LiveType findValueByNumber(int param2Int) {
            return LiveProtos.LiveType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    LiveType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static LiveType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : SHOW_LIVE) : BLIND_DATING_LIVE) : UNKNOWN_LIVE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(12);
    }
    
    public static Internal.EnumLiteMap<LiveType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<LiveType> {
    public LiveProtos.LiveType findValueByNumber(int param1Int) {
      return LiveProtos.LiveType.forNumber(param1Int);
    }
  }
  
  public enum PayStatus implements ProtocolMessageEnum {
    NOT_PAY_REMAIN_STATUS(0),
    NOT_PAY_SELL_OUT_STATUS(0),
    PAY_REMAIN_STATUS(0),
    PAY_SELL_OUT_STATUS(0),
    UNKNOWN_PAY_STATUS(0),
    UNRECOGNIZED(0);
    
    public static final int NOT_PAY_REMAIN_STATUS_VALUE = 1;
    
    public static final int NOT_PAY_SELL_OUT_STATUS_VALUE = 3;
    
    public static final int PAY_REMAIN_STATUS_VALUE = 2;
    
    public static final int PAY_SELL_OUT_STATUS_VALUE = 4;
    
    public static final int UNKNOWN_PAY_STATUS_VALUE = 0;
    
    private static final PayStatus[] VALUES;
    
    private static final Internal.EnumLiteMap<PayStatus> internalValueMap;
    
    private final int value;
    
    static {
      NOT_PAY_SELL_OUT_STATUS = new PayStatus("NOT_PAY_SELL_OUT_STATUS", 3, 3);
      PAY_SELL_OUT_STATUS = new PayStatus("PAY_SELL_OUT_STATUS", 4, 4);
      UNRECOGNIZED = new PayStatus("UNRECOGNIZED", 5, -1);
      $VALUES = new PayStatus[] { UNKNOWN_PAY_STATUS, NOT_PAY_REMAIN_STATUS, PAY_REMAIN_STATUS, NOT_PAY_SELL_OUT_STATUS, PAY_SELL_OUT_STATUS, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PayStatus>() {
          public LiveProtos.PayStatus findValueByNumber(int param2Int) {
            return LiveProtos.PayStatus.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PayStatus(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PayStatus forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : PAY_SELL_OUT_STATUS) : NOT_PAY_SELL_OUT_STATUS) : PAY_REMAIN_STATUS) : NOT_PAY_REMAIN_STATUS) : UNKNOWN_PAY_STATUS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(5);
    }
    
    public static Internal.EnumLiteMap<PayStatus> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PayStatus> {
    public LiveProtos.PayStatus findValueByNumber(int param1Int) {
      return LiveProtos.PayStatus.forNumber(param1Int);
    }
  }
  
  public enum Source implements ProtocolMessageEnum {
    FANS_CLUB_PAGE(0),
    GIFT_PAGE(0),
    UNKNOWN_SOURCE(0),
    UNRECOGNIZED(0);
    
    public static final int FANS_CLUB_PAGE_VALUE = 1;
    
    public static final int GIFT_PAGE_VALUE = 2;
    
    public static final int UNKNOWN_SOURCE_VALUE = 0;
    
    private static final Source[] VALUES;
    
    private static final Internal.EnumLiteMap<Source> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Source[] { UNKNOWN_SOURCE, FANS_CLUB_PAGE, GIFT_PAGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Source>() {
          public LiveProtos.Source findValueByNumber(int param2Int) {
            return LiveProtos.Source.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Source(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Source forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : GIFT_PAGE) : FANS_CLUB_PAGE) : UNKNOWN_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(11);
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
    public LiveProtos.Source findValueByNumber(int param1Int) {
      return LiveProtos.Source.forNumber(param1Int);
    }
  }
  
  public enum Status implements ProtocolMessageEnum {
    DAILY(0),
    END(0),
    START(0),
    UNKNOWN_STATUS(0),
    UNRECOGNIZED(0),
    WEEKLY(0);
    
    public static final int DAILY_VALUE = 4;
    
    public static final int END_VALUE = 2;
    
    public static final int START_VALUE = 1;
    
    public static final int UNKNOWN_STATUS_VALUE = 0;
    
    private static final Status[] VALUES;
    
    public static final int WEEKLY_VALUE = 3;
    
    private static final Internal.EnumLiteMap<Status> internalValueMap;
    
    private final int value;
    
    static {
      END = new Status("END", 2, 2);
      WEEKLY = new Status("WEEKLY", 3, 3);
      DAILY = new Status("DAILY", 4, 4);
      UNRECOGNIZED = new Status("UNRECOGNIZED", 5, -1);
      $VALUES = new Status[] { UNKNOWN_STATUS, START, END, WEEKLY, DAILY, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Status>() {
          public LiveProtos.Status findValueByNumber(int param2Int) {
            return LiveProtos.Status.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Status(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Status forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : DAILY) : WEEKLY) : END) : START) : UNKNOWN_STATUS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(3);
    }
    
    public static Internal.EnumLiteMap<Status> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<Status> {
    public LiveProtos.Status findValueByNumber(int param1Int) {
      return LiveProtos.Status.forNumber(param1Int);
    }
  }
  
  public enum TaskType implements ProtocolMessageEnum {
    LOGIN_DAILY(0),
    RECHARGE_ANY(0),
    SEND_3_MSG(0),
    SEND_ANY_GIFT(0),
    UNKNOWN_TASK_TYPE(0),
    UNRECOGNIZED(0),
    WATCH_15M(0);
    
    public static final int LOGIN_DAILY_VALUE = 1;
    
    public static final int RECHARGE_ANY_VALUE = 4;
    
    public static final int SEND_3_MSG_VALUE = 3;
    
    public static final int SEND_ANY_GIFT_VALUE = 5;
    
    public static final int UNKNOWN_TASK_TYPE_VALUE = 0;
    
    private static final TaskType[] VALUES;
    
    public static final int WATCH_15M_VALUE = 2;
    
    private static final Internal.EnumLiteMap<TaskType> internalValueMap;
    
    private final int value;
    
    static {
      SEND_3_MSG = new TaskType("SEND_3_MSG", 3, 3);
      RECHARGE_ANY = new TaskType("RECHARGE_ANY", 4, 4);
      SEND_ANY_GIFT = new TaskType("SEND_ANY_GIFT", 5, 5);
      UNRECOGNIZED = new TaskType("UNRECOGNIZED", 6, -1);
      $VALUES = new TaskType[] { UNKNOWN_TASK_TYPE, LOGIN_DAILY, WATCH_15M, SEND_3_MSG, RECHARGE_ANY, SEND_ANY_GIFT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TaskType>() {
          public LiveProtos.TaskType findValueByNumber(int param2Int) {
            return LiveProtos.TaskType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    TaskType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TaskType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : SEND_ANY_GIFT) : RECHARGE_ANY) : SEND_3_MSG) : WATCH_15M) : LOGIN_DAILY) : UNKNOWN_TASK_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveProtos.getDescriptor().getEnumTypes().get(7);
    }
    
    public static Internal.EnumLiteMap<TaskType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<TaskType> {
    public LiveProtos.TaskType findValueByNumber(int param1Int) {
      return LiveProtos.TaskType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\live\LiveProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
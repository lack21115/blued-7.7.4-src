package com.blued.das.client.feed;

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

public final class FeedProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\020FeedProtos.proto\022\031com.blued.das.client.feed\"»\017\n\tFeedProto\022/\n\005event\030\001 \001(\0162 .com.blued.das.client.feed.Event\022\020\n\btopic_id\030\002 \001(\t\0226\n\tfeed_type\030\003 \001(\0162#.com.blued.das.client.feed.FeedType\0226\n\tfeed_from\030\004 \001(\0162#.com.blued.das.client.feed.FeedFrom\022:\n\013detail_from\030\005 \001(\0162%.com.blued.das.client.feed.DetailFrom\022\017\n\007feed_id\030\006 \001(\t\022\017\n\007keyword\030\007 \001(\t\022?\n\016feed_from_page\030\b \001(\0162'.com.blued.das.client.feed.FeedFromPage\022D\n\020interactive_type\030\t \001(\0162*.com.blued.das.client.feed.InteractiveType\022\022\n\ntarget_uid\030\n \001(\t\0225\n\blocation\030\013 \001(\0162#.com.blued.das.client.feed.Location\0224\n\badd_type\030\f \001(\0162\".com.blued.das.client.feed.AddType\022B\n\017follow_location\030\r \001(\0162).com.blued.das.client.feed.FollowLocation\0228\n\nfeed_class\030\016 \001(\0162$.com.blued.das.client.feed.FeedClass\0226\n\tfeed_page\030\017 \001(\0162#.com.blued.das.client.feed.FeedPage\022\021\n\tis_follow\030\020 \001(\b\022A\n\017feed_topic_page\030\021 \001(\0162(.com.blued.das.client.feed.FeedTopicPage\022>\n\rshare_channel\030\022 \001(\0162'.com.blued.das.client.feed.ShareChannel\0226\n\tlink_from\030\023 \001(\0162#.com.blued.das.client.feed.LinkFrom\022\017\n\007is_like\030\024 \001(\b\022\017\n\007live_id\030\025 \001(\t\022:\n\013source_page\030\026 \001(\0162%.com.blued.das.client.feed.SourcePage\022\023\n\013is_exposure\030\027 \001(\b\022\022\n\ncomment_id\030\030 \001(\t\022\021\n\tcircle_id\030\031 \001(\t\022\017\n\007is_join\030\032 \001(\b\022>\n\rcircle_source\030\033 \001(\0162'.com.blued.das.client.feed.CircleSource\022\017\n\007note_id\030\034 \001(\t\022\016\n\006is_top\030\035 \001(\b\022:\n\013note_source\030\036 \001(\0162%.com.blued.das.client.feed.NoteSource\0224\n\bopt_type\030\037 \001(\0162\".com.blued.das.client.feed.OptType\022\020\n\blink_url\030  \001(\t\022\r\n\005is_at\030! \001(\b\022\017\n\007is_live\030\" \001(\b\0226\n\tnote_type\030# \001(\0162#.com.blued.das.client.feed.NoteType\022\021\n\tnote_from\030$ \001(\t\022\026\n\016recommend_type\030% \001(\t\022\020\n\bis_multi\030& \001(\b\022\020\n\bmusic_id\030' \001(\t\022\025\n\ris_circle_top\030( \001(\b\022\020\n\bis_apply\030) \001(\b\022\021\n\tis_invite\030* \001(\b\022\020\n\bimage_id\030+ \001(\t\022\034\n\024is_anonymous_publish\030, \001(\b\022\034\n\024is_anonymous_comment\030- \001(\b\0226\n\tuser_type\030. \001(\0162#.com.blued.das.client.feed.UserType\022\017\n\007task_id\030/ \001(\t\022\022\n\nis_comment\0300 \001(\b\022\013\n\003num\0301 \001(\005\022\016\n\006tab_id\0302 \001(\t\022\020\n\bposition\0303 \001(\t\0228\n\ntag_source\0304 \001(\0162$.com.blued.das.client.feed.TagSource\022\022\n\nis_essence\0305 \001(\b\0224\n\btab_type\0306 \001(\0162\".com.blued.das.client.feed.TabType\022\017\n\007room_id\0307 \001(\t\022\020\n\broom_uid\0308 \001(\t\022\n\n\002id\0309 \001(\t\022\021\n\ticon_type\030: \001(\t*ë(\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\033\n\027FIND_PLAZA_BANNER_CLICK\020\001\022\024\n\020SUPER_TOPIC_DRAW\020\002\022 \n\034SUPER_TOPIC_CREATE_BTN_CLICK\020\003\022%\n!SUPER_TOPIC_CREATE_NEXT_BTN_CLICK\020\004\022'\n#SUPER_TOPIC_CREATE_RETURN_BTN_CLICK\020\005\022\"\n\036FEED_PUBLISH_CONFIRM_BTN_CLICK\020\006\022\033\n\027SUPER_TOPIC_DETAIL_SHOW\020\007\022 \n\034SUPER_TOPIC_DETAIL_FEED_DRAW\020\b\022\036\n\032SUPER_TOPIC_MINE_BTN_CLICK\020\t\022\033\n\027SUPER_TOPIC_SEARCH_SHOW\020\n\022\036\n\032SUPER_TOPIC_SEARCH_KEYWORD\020\013\022\"\n\036SUPER_TOPIC_DETAIL_INTERACTIVE\020\f\022\033\n\027SUPER_TOPIC_INTERACTIVE\020\r\022\032\n\026FEED_PUBLISH_BTN_CLICK\020\016\022\031\n\025FEED_DETAIL_PAGE_SHOW\020\017\022\037\n\033FEED_COMMENT_LIST_USER_SHOW\020\020\022 \n\034FEED_COMMENT_LIST_USER_CLICK\020\021\022\024\n\020FEED_INTERACTIVE\020\022\022\032\n\026FEED_COMMENT_BOX_CLICK\020\023\022'\n#SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK\020\024\022\022\n\016FEED_ADD_PHOTO\020\025\022$\n PLAZA_RECOMMEND_FOLLOW_USER_SHOW\020\026\022\026\n\022OTHER_FOLLOW_CLICK\020\027\022 \n\034FEED_SUPER_TOPIC_ENTER_CLICK\020\030\022\033\n\027FEED_DETAIL_PAGE_SOURCE\020\031\022\r\n\tFEED_DRAW\020\032\022)\n%FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW\020\034\022*\n&FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK\020\035\022\022\n\016SHARE_TO_CLICK\020\036\022\032\n\026FEED_FORWARD_BTN_CLICK\020\037\022\037\n\033FEED_COMMENT_SEND_BTN_CLICK\020 \022\027\n\023FEED_LIKE_BTN_CLICK\020!\022\030\n\024FLASH_PLAY_PAGE_SHOW\020\"\022 \n\034FEED_LIKE_GO_PLAZA_BTN_CLICK\020#\022%\n!FLASH_VIDEO_USER_LIVE_PHOTO_CLICK\020$\022$\n LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW\020%\022%\n!LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK\020&\022\034\n\030FEED_DETAIL_COMMENT_DRAW\020'\022!\n\035FEED_DETAIL_COMMENT_MORE_SHOW\020(\022\"\n\036FEED_DETAIL_COMMENT_MORE_CLICK\020)\022\017\n\013CIRCLE_DRAW\020*\022\026\n\022CIRCLE_DETAIL_SHOW\020+\022\031\n\025CIRCLE_FIND_PAGE_SHOW\020,\022\031\n\025CIRCLE_JOIN_BTN_CLICK\020-\022\024\n\020CIRCLE_NOTE_DRAW\020.\022\033\n\027CIRCLE_NOTE_DETAIL_SHOW\020/\022\027\n\023CIRCLE_NOTE_COMMENT\0200\022\024\n\020CIRCLE_NOTE_LIKE\0201\022\030\n\024CIRCLE_MORE_BTN_SHOW\0202\022\034\n\030CIRCLE_NOTE_COMMENT_DRAW\0203\022\"\n\036CIRCLE_NOTE_COMMENT_GUIDE_SHOW\0204\022#\n\037CIRCLE_NOTE_COMMENT_GUIDE_CLICK\0205\022\030\n\024CIRCLE_EXIT_BOX_SHOW\0206\022\031\n\025CIRCLE_EXIT_BTN_CLICK\0207\022\034\n\030CIRCLE_PUBLISH_BTN_CLICK\0208\022\033\n\027CIRCLE_NOTE_MANAGE_SHOW\0209\022 \n\034CIRCLE_NOTE_MANAGE_BTN_CLICK\020:\022#\n\037CIRCLE_NOTE_COMMENT_IMAGE_CLICK\020;\022%\n!PLAZA_RECOMMEND_FOLLOW_USER_CLICK\020<\022\034\n\030FIND_TOP_DROP_DOWN_CLICK\020=\022\037\n\033CIRCLE_NOTE_VOTE_ICON_CLICK\020>\022\027\n\023CITY_LIVE_USER_SHOW\020?\022\037\n\033CIRCLE_NOTE_ADD_PHOTO_CLICK\020@\022\033\n\027MSG_NOTICE_COMMENT_SHOW\020A\022\034\n\030MSG_NOTICE_COMMENT_CLICK\020B\022\034\n\030MSG_NOTICE_COMMENT_REPLY\020C\022\033\n\027MSG_NOTICE_FOLLOW_CLICK\020D\022\031\n\025MSG_NOTICE_LIKE_CLICK\020E\022\031\n\025MSG_NOTICE_VOTE_CLICK\020F\022\033\n\027MSG_NOTICE_DELETE_CLICK\020G\022#\n\037PLAZA_RECOMMEND_NOTE_LIKE_CLICK\020H\022&\n\"PLAZA_RECOMMEND_NOTE_COMMENT_CLICK\020I\022$\n PLAZA_RECOMMEND_NOTE_SHARE_CLICK\020J\022\025\n\021CITY_SAY_HI_CLICK\020K\022\032\n\026FEED_MULTI_IMAGE_CLICK\020L\022\037\n\033FLASH_SCREEN_COMPLETE_CLICK\020M\022\024\n\020FEED_PHOTO_CLICK\020N\022\033\n\027SHARE_PASSWORD_POP_SHOW\020O\022\"\n\036SHARE_PASSWORD_POP_PASTE_CLICK\020P\0220\n,FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK\020Q\022,\n(FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK\020R\022\033\n\027FEED_DYNAMIC_SKIN_CLICK\020S\022 \n\034FEED_DYNAMIC_SKIN_SAVE_CLICK\020T\022'\n#CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK\020U\022\033\n\027CIRCLE_USER_MANAGE_SHOW\020V\022#\n\037CIRCLE_USER_MANAGE_INVITE_CLICK\020W\022\"\n\036CIRCLE_USER_MANAGE_INVITE_USER\020X\022\033\n\027MSG_NOTICE_CIRCLE_CLICK\020Y\022&\n\"MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK\020Z\022'\n#MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK\020[\022%\n!MSG_NOTICE_CIRCLE_JOIN_USER_CLICK\020\\\022!\n\035CIRCLE_USER_LIST_MANAGE_CLICK\020]\0222\n.CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK\020^\0227\n3CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK\020_\0225\n1CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK\020`\022:\n6CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK\020a\022-\n)CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK\020b\0222\n.CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK\020c\022+\n'CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK\020d\022!\n\035FEED_PUBLISH_SUCCESS_POP_SHOW\020e\022)\n%FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK\020f\022\031\n\025MUTE_REMOVE_BTN_CLICK\020g\022\025\n\021CIRCLE_FEED_CLICK\020h\022\035\n\031CIRCLE_JOIN_FEED_POP_SHOW\020i\022\036\n\032CIRCLE_JOIN_FEED_POP_CLICK\020j\022\021\n\rCITY_TOP_SHOW\020k\022\022\n\016CITY_TOP_CLICK\020l\022\035\n\031FLASH_PLAY_LIST_ONE_CLICK\020m\022\036\n\032FIND_CIRCLE_MINE_ALL_CLICK\020n\022$\n FIND_CIRCLE_RECOMMEND_MORE_CLICK\020o\022\037\n\033FIND_CIRCLE_NOTE_MINE_CLICK\020p\022\035\n\031CIRCLE_SETTINGS_PAGE_SHOW\020q\022#\n\037CIRCLE_SETTINGS_PAGE_INFO_CLICK\020r\022(\n$CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK\020s\022+\n'CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK\020t\022&\n\"CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK\020u\022#\n\037CIRCLE_SETTINGS_PAGE_JOIN_CLICK\020v\022'\n#CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK\020w\022)\n%CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK\020x\022/\n+FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK\020y\022\027\n\023FEED_VIEW_NUM_CLICK\020z\022\036\n\032SUPER_TOPIC_HOME_PAGE_SHOW\020{\022\032\n\026SUPER_TOPIC_MORE_CLICK\020|\022\036\n\032SUPER_TOPIC_RECOMMEND_SHOW\020}\022\032\n\026SUPER_TOPIC_VISIT_SHOW\020~\022\031\n\025SUPER_TOPIC_JOIN_SHOW\020\022\034\n\027SUPER_TOPIC_CREATE_SHOW\020\001\022\030\n\023NOTE_MORE_BTN_CLICK\020\001\022\034\n\027NOTE_MORE_DISLIKE_CLICK\020\001\022\025\n\020NOTE_IMAGE_CLICK\020\001\022\025\n\020NOTE_VIDEO_CLICK\020\001\022\035\n\030FIND_RECOMMEND_PAGE_SHOW\020\001\022$\n\037FIND_RECOMMEND_SECOND_PAGE_SHOW\020\001\022\031\n\024CITY_LIVE_USER_CLICK\020\001\022\023\n\016SV_FILTER_USED\020\001\022 \n\033FEED_DYNAMIC_SKIN_VIP_CLICK\020\001\022\027\n\022CIRCLE_BRIEF_CLICK\020\001\022\021\n\fNEW_TAG_SHOW\020\001\022\022\n\rNEW_TAG_CLICK\020\001\022\037\n\032CIRCLE_ACTIVE_MEMBER_CLICK\020\001\022\030\n\023CIRCLE_TAB_BTN_SHOW\020\001\022!\n\034MSG_NOTICE_CIRCLE_VIEW_CLICK\020\001\022\035\n\030FEED_CHATROOM_MORE_CLICK\020\001\022\027\n\022FEED_CHATROOM_SHOW\020\001\022\030\n\023FEED_CHATROOM_CLICK\020\001\022*\n%FEED_PUBLISH_STATUS_NOTIFICATION_SHOW\020\001\022+\n&FEED_PUBLISH_STATUS_NOTIFICATION_CLICK\020\001\022\036\n\031FLASH_PLAY_DOWNLOAD_CLICK\020\001\022\030\n\023CITY_CHAT_ROOM_SHOW\020\001\022\031\n\024CITY_CHAT_ROOM_CLICK\020\001\022\035\n\030FEED_PUBLISH_TOPIC_CLICK\020\001\022!\n\034FEED_PUBLISH_ADD_TOPIC_CLICK\020\001\022\026\n\021FEED_PUBLISH_SHOW\020\001\022)\n$FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK\020\001\022\034\n\027FEED_PUBLISH_TOPIC_SHOW\020\001\022!\n\034CIRCLE_HOT_POST_BANNER_CLICK\020\001\022#\n\036CIRCLE_HOT_POST_MORE_BTN_CLICK\020\001\022\024\n\017NOTE_LINK_CLICK\020 \001\022\032\n\025CIRCLE_MORE_LIST_SHOW\020¡\001\022\025\n\020FEED_BUBBLE_SHOW\020¢\001\022\026\n\021FEED_BUBBLE_CLICK\020£\001*O\n\bFeedType\022\025\n\021UNKNOWN_FEED_TYPE\020\000\022\n\n\006COMMON\020\001\022\017\n\013SUPER_TOPIC\020\002\022\017\n\013CIRCLE_NOTE\020\003*\002\n\bFeedFrom\022\025\n\021UNKNOWN_FEED_FROM\020\000\022\f\n\bPERSONAL\020\001\022\026\n\022SUPER_TOPIC_DETAIL\020\002\022\t\n\005PLAZA\020\003\022\n\n\006FOLLOW\020\004\022\t\n\005FLASH\020\005\022\033\n\027PUBLISH_PLAZA_RECOMMEND\020\006\022\030\n\024PUBLISH_PLAZA_NEARBY\020\007\022\027\n\023PUBLISH_PLAZA_IMAGE\020\b\022\030\n\024PUBLISH_FLASH_DETAIL\020\t\022\027\n\023PUBLISH_CIRCLE_NOTE\020\n\022\025\n\021CIRCLE_DETAIL_POP\020\013*¨\002\n\nDetailFrom\022\027\n\023UNKNOWN_DETAIL_FROM\020\000\022\021\n\rPERSONAL_PAGE\020\001\022\016\n\nFIND_PLAZA\020\002\022\031\n\025FIND_SUPER_TOPIC_LIST\020\003\022\024\n\020SUPER_TOPIC_JOIN\020\004\022\017\n\013FIND_FOLLOW\020\005\022\017\n\013FIND_NEARBY\020\006\022\026\n\022SUPER_TOPIC_CREATE\020\007\022\030\n\024FIND_PLAZA_RECOMMEND\020\b\022\023\n\017FIND_IMAGE_PAGE\020\t\022\022\n\016FEED_MORE_PAGE\020\n\022\031\n\025SUPER_TOPIC_RECOMMEND\020\013\022\025\n\021SUPER_TOPIC_VISIT\020\f*\001\n\fFeedFromPage\022\032\n\026UNKNOWN_FEED_FROM_PAGE\020\000\022\021\n\rPERSONAL_FROM\020\001\022\033\n\027SUPER_TOPIC_DETAIL_FROM\020\002\022\016\n\nPLAZA_FROM\020\003\022\017\n\013FOLLOW_FROM\020\004\022\017\n\013NEARBY_FROM\020\005*p\n\017InteractiveType\022\034\n\030UNKNOWN_INTERACTIVE_TYPE\020\000\022\b\n\004LIKE\020\001\022\013\n\007COMMENT\020\002\022\013\n\007FORWARD\020\003\022\016\n\nLOOK_PHOTO\020\004\022\013\n\007NO_LIKE\020\005*E\n\bLocation\022\024\n\020UNKNOWN_LOCATION\020\000\022\017\n\013FEED_DETAIL\020\001\022\022\n\016COMMENT_DETAIL\020\002*T\n\007AddType\022\024\n\020UNKNOWN_ADD_TYPE\020\000\022\007\n\003ADD\020\001\022\b\n\004ICON\020\002\022\017\n\013FULL_SCREEN\020\003\022\017\n\013HALF_SCREEN\020\004*Õ\003\n\016FollowLocation\022\033\n\027UNKNOWN_FOLLOW_LOCATION\020\000\022\033\n\027FOLLOW_SUPER_TOPIC_FEED\020\001\022\037\n\033FOLLOW_PLAZA_RECOMMEND_FEED\020\002\022\034\n\030FOLLOW_PLAZA_FEED_DETAIL\020\003\022\037\n\033FOLLOW_PLAZA_RECOMMEND_USER\020\004\022\027\n\023FOLLOW_PLAZA_NEARBY\020\005\022\026\n\022FOLLOW_PLAZA_FLASH\020\006\022\035\n\031FOLLOW_PLAZA_FLASH_DETAIL\020\007\022\026\n\022FOLLOW_PLAZA_IMAGE\020\b\022#\n\037FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND\020\t\022\032\n\026FOLLOW_LIVE_USER_PHOTO\020\n\022\017\n\013FOLLOW_MINE\020\013\022\034\n\030FOLLOW_PROFILE_FANS_LIST\020\f\022\036\n\032FOLLOW_PROFILE_FOLLOW_LIST\020\r\022\024\n\020FOLLOW_FEED_LIKE\020\016\022\033\n\027FOLLOW_FEED_DETAIL_MORE\020\017*p\n\tFeedClass\022\026\n\022UNKNOWN_FEED_CLASS\020\000\022\r\n\tFEED_WORD\020\001\022\016\n\nFEED_IMAGE\020\002\022\016\n\nFEED_VIDEO\020\003\022\r\n\tFEED_VOTE\020\004\022\r\n\tFEED_LIVE\020\005*\002\n\bFeedPage\022\025\n\021UNKNOWN_FEED_PAGE\020\000\022\023\n\017PLAZA_RECOMMEND\020\001\022\020\n\fPLAZA_FOLLOW\020\002\022\020\n\fPLAZA_NEARBY\020\003\022\020\n\fFLASH_DETAIL\020\004\022\017\n\013PLAZA_IMAGE\020\005\022\024\n\020SUPER_TOPIC_FEED\020\006\022\021\n\rPERSONAL_FEED\020\007\022\r\n\tFEED_MINE\020\b\022\r\n\tFEED_LIKE\020\t\022\024\n\020PLAZA_FLASH_LIST\020\n\022\024\n\020FEED_DETAIL_MORE\020\013\022\022\n\016PERSONAL_PHOTO\020\f\022\023\n\017FIND_TOPIC_HOME\020\r*b\n\rFeedTopicPage\022\033\n\027UNKNOWN_FEED_TOPIC_PAGE\020\000\022\032\n\026FEED_TOPIC_FEED_DETAIL\020\001\022\030\n\024FEED_TOPIC_FEED_LIST\020\002*¦\001\n\fShareChannel\022\031\n\025UNKNOWN_SHARE_CHANNEL\020\000\022\021\n\rSHARE_FORWARD\020\001\022\020\n\fSHARE_FRIEND\020\002\022\020\n\fSHARE_WECHAT\020\003\022\f\n\bSHARE_QQ\020\004\022\017\n\013SHARE_WEIBO\020\005\022\025\n\021SHARE_FRIEND_CLUB\020\006\022\016\n\nSHARE_FEED\020\007*>\n\bLinkFrom\022\025\n\021UNKNOWN_LINK_FROM\020\000\022\r\n\tFEED_LINK\020\001\022\f\n\bMSG_LINK\020\002*É\006\n\nSourcePage\022\027\n\023UNKNOWN_SOURCE_PAGE\020\000\022\030\n\024FEED_PLAZA_RECOMMEND\020\001\022\025\n\021FEED_PLAZA_FOLLOW\020\002\022\025\n\021FEED_PLAZA_NEARBY\020\003\022\024\n\020FEED_PLAZA_FLASH\020\004\022\024\n\020FEED_PLAZA_IMAGE\020\005\022\031\n\025FEED_SUPER_TOPIC_FEED\020\006\022\026\n\022FEED_PERSONAL_FEED\020\007\022\024\n\020FEED_DETAIL_PAGE\020\b\022\r\n\tFEED_PLAY\020\t\022\026\n\022FEED_PERSONAL_MORE\020\n\022\016\n\nSHARE_LIVE\020\013\022\025\n\021SHARE_MINE_DANLAN\020\f\022\023\n\017SHARE_MINE_HEER\020\r\022\023\n\017SHARE_MINE_BABY\020\016\022\024\n\020SHARE_MINE_EMOJI\020\017\022\022\n\016PAGE_FEED_MINE\020\020\022\022\n\016PAGE_FEED_LIKE\020\021\022\031\n\025PAGE_FEED_DETAIL_MORE\020\022\022\f\n\bONE_CITY\020\023\022\025\n\021NOTE_DETAIL_SHARE\020\024\022\036\n\032PLAZA_RECOMMEND_NOTE_SHARE\020\025\022\037\n\033FEED_PLAZA_RECOMMEND_DETAIL\020\026\022\034\n\030FEED_PLAZA_FOLLOW_DETAIL\020\027\022\033\n\027FEED_PLAZA_FLASH_DETAIL\020\030\022\033\n\027FEED_PLAZA_IMAGE_DETAIL\020\031\022\034\n\030FEED_PLAZA_NEARBY_DETAIL\020\032\022 \n\034FEED_SUPER_TOPIC_FEED_DETAIL\020\033\022\035\n\031FEED_PERSONAL_FEED_DETAIL\020\034\022\022\n\016CITY_NOTE_PAGE\020\035\022\030\n\024PAGE_FIND_TOPIC_HOME\020\036\022\017\n\013MINE_CIRCLE\020\037\022\031\n\025CIRCLE_HOME_RECOMMEND\020 \022\035\n\031FEED_PLAZA_RECOMMEND_MORE\020!*ö\005\n\fCircleSource\022\031\n\025UNKNOWN_CIRCLE_SOURCE\020\000\022\032\n\026PLAZA_RECOMMEND_CIRCLE\020\001\022\024\n\020FIND_CIRCLE_LIST\020\002\022\024\n\020FIND_CIRCLE_MINE\020\003\022\030\n\024FIND_CIRCLE_MINE_ALL\020\004\022\030\n\024PLAZA_RECOMMEND_NOTE\020\005\022\034\n\030FIND_CIRCLE_DISCUSS_LIST\020\006\022\033\n\027CIRCLE_NOTE_DETAIL_NAME\020\007\022\023\n\017FIND_CIRCLE_HOT\020\b\022\022\n\016MY_CIRCLE_MORE\020\t\022\021\n\rCIRCLE_DETAIL\020\n\022\031\n\025FIND_CIRCLE_RECOMMEND\020\013\022\034\n\030PLAZA_RECOMMEND_ONE_NOTE\020\f\022\026\n\022NOTE_DETAIL_CIRCLE\020\r\022\025\n\021CIRCLE_INVITE_MSG\020\016\022\032\n\026CIRCLE_APPLY_AGREE_MSG\020\017\022\033\n\027MANAGE_VICE_CAPTAIN_MSG\020\020\022\032\n\026FIND_CIRCLE_NOTE_ENTER\020\021\022\024\n\020CITY_NOTE_CIRCLE\020\022\022\r\n\tNOTICE_AT\020\023\022\025\n\021CITY_BANNER_ENTER\020\024\022\032\n\026RECOMMEND_BANNER_ENTER\020\036\022\023\n\017CITY_FEED_ENTER\020\037\022\030\n\024RECOMMEND_FEED_ENTER\020 \022\025\n\021DETAIL_FEED_ENTER\020!\022\023\n\017CIRCLE_HOT_POST\020\"\022\024\n\020CIRCLE_MORE_LIST\020#\022\033\n\027PERSONAL_PROFILE_CIRCLE\020$\022\034\n\030PUSH_NOTIFICATION_CIRCLE\020%\022\027\n\023NOTIFICATION_CIRCLE\020&*Õ\003\n\nNoteSource\022\027\n\023UNKNOWN_NOTE_SOURCE\020\000\022\031\n\025CIRCLE_RECOMMEND_LIST\020\001\022\r\n\tNOTE_LIST\020\002\022\016\n\nCIRCLE_TOP\020\003\022\016\n\nCIRCLE_NEW\020\004\022\016\n\nCIRCLE_HOT\020\005\022\017\n\013NOTE_DETAIL\020\006\022\027\n\023NOTE_COMMENT_DETAIL\020\007\022\034\n\030NOTE_DETAIL_COMMENT_LIST\020\b\022\026\n\022NOTE_DETAIL_BOTTOM\020\t\022\031\n\025CIRCLE_RECOMMEND_NOTE\020\n\022\r\n\tCITY_NOTE\020\013\022\024\n\020CITY_BANNER_NOTE\020\f\022\031\n\025RECOMMEND_BANNER_NOTE\020\r\022\025\n\021NOTICE_LIKE_ENTER\020\016\022\030\n\024NOTICE_COMMENT_ENTER\020\017\022\022\n\016CIRCLE_ESSENCE\020\020\022\024\n\020PERSONAL_PROFILE\020\022\022\025\n\021PUSH_NOTIFICATION\020\023\022\020\n\fNOTIFICATION\020\024\022\025\n\021NOTICE_COMMENT_AT\020\025*j\n\007OptType\022\024\n\020UNKNOWN_OPT_TYPE\020\000\022\013\n\007OPT_TOP\020\001\022\f\n\bOPT_FORB\020\002\022\016\n\nOPT_DELETE\020\003\022\016\n\nOPT_REPORT\020\004\022\016\n\nOPT_CANCEL\020\005*n\n\bNoteType\022\025\n\021UNKNOWN_NOTE_TYPE\020\000\022\017\n\013NOTE_COMMON\020\001\022\f\n\bNOTE_MIX\020\002\022\r\n\tVOTE_TEXT\020\003\022\016\n\nNOTE_VIDEO\020\004\022\r\n\tNOTE_LINK\020\005*\001\n\bUserType\022\025\n\021UNKNOWN_USER_TYPE\020\000\022\020\n\fVICE_CAPTAIN\020\001\022\017\n\013COMMON_USER\020\002\022\022\n\016CIRCLE_CAPTAIN\020\003\022\025\n\021CIRCLE_NOT_MEMBER\020\004\022\r\n\tTREATMENT\020\005\022\013\n\007CONTROL\020\006\022\n\n\006NORMAL\020\007*7\n\tTagSource\022\026\n\022UNKNOWN_TAG_SOURCE\020\000\022\022\n\016VOICE_CHATROOM\020\001*R\n\007TabType\022\024\n\020UNKNOWN_TAB_TYPE\020\000\022\021\n\rESSENCE_CICLE\020\001\022\016\n\nHOT_CIRCLE\020\002\022\016\n\nNEW_CIRCLE\020\003B\007¢\002\004FEEDb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_client_feed_FeedProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_feed_FeedProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_client_feed_FeedProto_descriptor, new String[] { 
        "Event", "TopicId", "FeedType", "FeedFrom", "DetailFrom", "FeedId", "Keyword", "FeedFromPage", "InteractiveType", "TargetUid", 
        "Location", "AddType", "FollowLocation", "FeedClass", "FeedPage", "IsFollow", "FeedTopicPage", "ShareChannel", "LinkFrom", "IsLike", 
        "LiveId", "SourcePage", "IsExposure", "CommentId", "CircleId", "IsJoin", "CircleSource", "NoteId", "IsTop", "NoteSource", 
        "OptType", "LinkUrl", "IsAt", "IsLive", "NoteType", "NoteFrom", "RecommendType", "IsMulti", "MusicId", "IsCircleTop", 
        "IsApply", "IsInvite", "ImageId", "IsAnonymousPublish", "IsAnonymousComment", "UserType", "TaskId", "IsComment", "Num", "TabId", 
        "Position", "TagSource", "IsEssence", "TabType", "RoomId", "RoomUid", "Id", "IconType" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum AddType implements ProtocolMessageEnum {
    ADD,
    FULL_SCREEN,
    HALF_SCREEN,
    ICON,
    UNKNOWN_ADD_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int ADD_VALUE = 1;
    
    public static final int FULL_SCREEN_VALUE = 3;
    
    public static final int HALF_SCREEN_VALUE = 4;
    
    public static final int ICON_VALUE = 2;
    
    public static final int UNKNOWN_ADD_TYPE_VALUE = 0;
    
    private static final AddType[] VALUES;
    
    private static final Internal.EnumLiteMap<AddType> internalValueMap;
    
    private final int value;
    
    static {
      FULL_SCREEN = new AddType("FULL_SCREEN", 3, 3);
      HALF_SCREEN = new AddType("HALF_SCREEN", 4, 4);
      UNRECOGNIZED = new AddType("UNRECOGNIZED", 5, -1);
      $VALUES = new AddType[] { UNKNOWN_ADD_TYPE, ADD, ICON, FULL_SCREEN, HALF_SCREEN, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<AddType>() {
          public FeedProtos.AddType findValueByNumber(int param2Int) {
            return FeedProtos.AddType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    AddType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AddType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : HALF_SCREEN) : FULL_SCREEN) : ICON) : ADD) : UNKNOWN_ADD_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(7);
    }
    
    public static Internal.EnumLiteMap<AddType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<AddType> {
    public FeedProtos.AddType findValueByNumber(int param1Int) {
      return FeedProtos.AddType.forNumber(param1Int);
    }
  }
  
  public enum CircleSource implements ProtocolMessageEnum {
    CIRCLE_APPLY_AGREE_MSG(0),
    CIRCLE_DETAIL(0),
    CIRCLE_HOT_POST(0),
    CIRCLE_INVITE_MSG(0),
    CIRCLE_MORE_LIST(0),
    CIRCLE_NOTE_DETAIL_NAME(0),
    CITY_BANNER_ENTER(0),
    CITY_FEED_ENTER(0),
    CITY_NOTE_CIRCLE(0),
    DETAIL_FEED_ENTER(0),
    FIND_CIRCLE_DISCUSS_LIST(0),
    FIND_CIRCLE_HOT(0),
    FIND_CIRCLE_LIST(0),
    FIND_CIRCLE_MINE(0),
    FIND_CIRCLE_MINE_ALL(0),
    FIND_CIRCLE_NOTE_ENTER(0),
    FIND_CIRCLE_RECOMMEND(0),
    MANAGE_VICE_CAPTAIN_MSG(0),
    MY_CIRCLE_MORE(0),
    NOTE_DETAIL_CIRCLE(0),
    NOTICE_AT(0),
    NOTIFICATION_CIRCLE(0),
    PERSONAL_PROFILE_CIRCLE(0),
    PLAZA_RECOMMEND_CIRCLE(0),
    PLAZA_RECOMMEND_NOTE(0),
    PLAZA_RECOMMEND_ONE_NOTE(0),
    PUSH_NOTIFICATION_CIRCLE(0),
    RECOMMEND_BANNER_ENTER(0),
    RECOMMEND_FEED_ENTER(0),
    UNKNOWN_CIRCLE_SOURCE(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_APPLY_AGREE_MSG_VALUE = 15;
    
    public static final int CIRCLE_DETAIL_VALUE = 10;
    
    public static final int CIRCLE_HOT_POST_VALUE = 34;
    
    public static final int CIRCLE_INVITE_MSG_VALUE = 14;
    
    public static final int CIRCLE_MORE_LIST_VALUE = 35;
    
    public static final int CIRCLE_NOTE_DETAIL_NAME_VALUE = 7;
    
    public static final int CITY_BANNER_ENTER_VALUE = 20;
    
    public static final int CITY_FEED_ENTER_VALUE = 31;
    
    public static final int CITY_NOTE_CIRCLE_VALUE = 18;
    
    public static final int DETAIL_FEED_ENTER_VALUE = 33;
    
    public static final int FIND_CIRCLE_DISCUSS_LIST_VALUE = 6;
    
    public static final int FIND_CIRCLE_HOT_VALUE = 8;
    
    public static final int FIND_CIRCLE_LIST_VALUE = 2;
    
    public static final int FIND_CIRCLE_MINE_ALL_VALUE = 4;
    
    public static final int FIND_CIRCLE_MINE_VALUE = 3;
    
    public static final int FIND_CIRCLE_NOTE_ENTER_VALUE = 17;
    
    public static final int FIND_CIRCLE_RECOMMEND_VALUE = 11;
    
    public static final int MANAGE_VICE_CAPTAIN_MSG_VALUE = 16;
    
    public static final int MY_CIRCLE_MORE_VALUE = 9;
    
    public static final int NOTE_DETAIL_CIRCLE_VALUE = 13;
    
    public static final int NOTICE_AT_VALUE = 19;
    
    public static final int NOTIFICATION_CIRCLE_VALUE = 38;
    
    public static final int PERSONAL_PROFILE_CIRCLE_VALUE = 36;
    
    public static final int PLAZA_RECOMMEND_CIRCLE_VALUE = 1;
    
    public static final int PLAZA_RECOMMEND_NOTE_VALUE = 5;
    
    public static final int PLAZA_RECOMMEND_ONE_NOTE_VALUE = 12;
    
    public static final int PUSH_NOTIFICATION_CIRCLE_VALUE = 37;
    
    public static final int RECOMMEND_BANNER_ENTER_VALUE = 30;
    
    public static final int RECOMMEND_FEED_ENTER_VALUE = 32;
    
    public static final int UNKNOWN_CIRCLE_SOURCE_VALUE = 0;
    
    private static final CircleSource[] VALUES;
    
    private static final Internal.EnumLiteMap<CircleSource> internalValueMap;
    
    private final int value;
    
    static {
      FIND_CIRCLE_LIST = new CircleSource("FIND_CIRCLE_LIST", 2, 2);
      FIND_CIRCLE_MINE = new CircleSource("FIND_CIRCLE_MINE", 3, 3);
      FIND_CIRCLE_MINE_ALL = new CircleSource("FIND_CIRCLE_MINE_ALL", 4, 4);
      PLAZA_RECOMMEND_NOTE = new CircleSource("PLAZA_RECOMMEND_NOTE", 5, 5);
      FIND_CIRCLE_DISCUSS_LIST = new CircleSource("FIND_CIRCLE_DISCUSS_LIST", 6, 6);
      CIRCLE_NOTE_DETAIL_NAME = new CircleSource("CIRCLE_NOTE_DETAIL_NAME", 7, 7);
      FIND_CIRCLE_HOT = new CircleSource("FIND_CIRCLE_HOT", 8, 8);
      MY_CIRCLE_MORE = new CircleSource("MY_CIRCLE_MORE", 9, 9);
      CIRCLE_DETAIL = new CircleSource("CIRCLE_DETAIL", 10, 10);
      FIND_CIRCLE_RECOMMEND = new CircleSource("FIND_CIRCLE_RECOMMEND", 11, 11);
      PLAZA_RECOMMEND_ONE_NOTE = new CircleSource("PLAZA_RECOMMEND_ONE_NOTE", 12, 12);
      NOTE_DETAIL_CIRCLE = new CircleSource("NOTE_DETAIL_CIRCLE", 13, 13);
      CIRCLE_INVITE_MSG = new CircleSource("CIRCLE_INVITE_MSG", 14, 14);
      CIRCLE_APPLY_AGREE_MSG = new CircleSource("CIRCLE_APPLY_AGREE_MSG", 15, 15);
      MANAGE_VICE_CAPTAIN_MSG = new CircleSource("MANAGE_VICE_CAPTAIN_MSG", 16, 16);
      FIND_CIRCLE_NOTE_ENTER = new CircleSource("FIND_CIRCLE_NOTE_ENTER", 17, 17);
      CITY_NOTE_CIRCLE = new CircleSource("CITY_NOTE_CIRCLE", 18, 18);
      NOTICE_AT = new CircleSource("NOTICE_AT", 19, 19);
      CITY_BANNER_ENTER = new CircleSource("CITY_BANNER_ENTER", 20, 20);
      RECOMMEND_BANNER_ENTER = new CircleSource("RECOMMEND_BANNER_ENTER", 21, 30);
      CITY_FEED_ENTER = new CircleSource("CITY_FEED_ENTER", 22, 31);
      RECOMMEND_FEED_ENTER = new CircleSource("RECOMMEND_FEED_ENTER", 23, 32);
      DETAIL_FEED_ENTER = new CircleSource("DETAIL_FEED_ENTER", 24, 33);
      CIRCLE_HOT_POST = new CircleSource("CIRCLE_HOT_POST", 25, 34);
      CIRCLE_MORE_LIST = new CircleSource("CIRCLE_MORE_LIST", 26, 35);
      PERSONAL_PROFILE_CIRCLE = new CircleSource("PERSONAL_PROFILE_CIRCLE", 27, 36);
      PUSH_NOTIFICATION_CIRCLE = new CircleSource("PUSH_NOTIFICATION_CIRCLE", 28, 37);
      NOTIFICATION_CIRCLE = new CircleSource("NOTIFICATION_CIRCLE", 29, 38);
      UNRECOGNIZED = new CircleSource("UNRECOGNIZED", 30, -1);
      $VALUES = new CircleSource[] { 
          UNKNOWN_CIRCLE_SOURCE, PLAZA_RECOMMEND_CIRCLE, FIND_CIRCLE_LIST, FIND_CIRCLE_MINE, FIND_CIRCLE_MINE_ALL, PLAZA_RECOMMEND_NOTE, FIND_CIRCLE_DISCUSS_LIST, CIRCLE_NOTE_DETAIL_NAME, FIND_CIRCLE_HOT, MY_CIRCLE_MORE, 
          CIRCLE_DETAIL, FIND_CIRCLE_RECOMMEND, PLAZA_RECOMMEND_ONE_NOTE, NOTE_DETAIL_CIRCLE, CIRCLE_INVITE_MSG, CIRCLE_APPLY_AGREE_MSG, MANAGE_VICE_CAPTAIN_MSG, FIND_CIRCLE_NOTE_ENTER, CITY_NOTE_CIRCLE, NOTICE_AT, 
          CITY_BANNER_ENTER, RECOMMEND_BANNER_ENTER, CITY_FEED_ENTER, RECOMMEND_FEED_ENTER, DETAIL_FEED_ENTER, CIRCLE_HOT_POST, CIRCLE_MORE_LIST, PERSONAL_PROFILE_CIRCLE, PUSH_NOTIFICATION_CIRCLE, NOTIFICATION_CIRCLE, 
          UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<CircleSource>() {
          public FeedProtos.CircleSource findValueByNumber(int param2Int) {
            return FeedProtos.CircleSource.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    CircleSource(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static CircleSource forNumber(int param1Int) {
      switch (param1Int) {
        default:
          switch (param1Int) {
            default:
              return null;
            case 38:
              return NOTIFICATION_CIRCLE;
            case 37:
              return PUSH_NOTIFICATION_CIRCLE;
            case 36:
              return PERSONAL_PROFILE_CIRCLE;
            case 35:
              return CIRCLE_MORE_LIST;
            case 34:
              return CIRCLE_HOT_POST;
            case 33:
              return DETAIL_FEED_ENTER;
            case 32:
              return RECOMMEND_FEED_ENTER;
            case 31:
              return CITY_FEED_ENTER;
            case 30:
              break;
          } 
          return RECOMMEND_BANNER_ENTER;
        case 20:
          return CITY_BANNER_ENTER;
        case 19:
          return NOTICE_AT;
        case 18:
          return CITY_NOTE_CIRCLE;
        case 17:
          return FIND_CIRCLE_NOTE_ENTER;
        case 16:
          return MANAGE_VICE_CAPTAIN_MSG;
        case 15:
          return CIRCLE_APPLY_AGREE_MSG;
        case 14:
          return CIRCLE_INVITE_MSG;
        case 13:
          return NOTE_DETAIL_CIRCLE;
        case 12:
          return PLAZA_RECOMMEND_ONE_NOTE;
        case 11:
          return FIND_CIRCLE_RECOMMEND;
        case 10:
          return CIRCLE_DETAIL;
        case 9:
          return MY_CIRCLE_MORE;
        case 8:
          return FIND_CIRCLE_HOT;
        case 7:
          return CIRCLE_NOTE_DETAIL_NAME;
        case 6:
          return FIND_CIRCLE_DISCUSS_LIST;
        case 5:
          return PLAZA_RECOMMEND_NOTE;
        case 4:
          return FIND_CIRCLE_MINE_ALL;
        case 3:
          return FIND_CIRCLE_MINE;
        case 2:
          return FIND_CIRCLE_LIST;
        case 1:
          return PLAZA_RECOMMEND_CIRCLE;
        case 0:
          break;
      } 
      return UNKNOWN_CIRCLE_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(15);
    }
    
    public static Internal.EnumLiteMap<CircleSource> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<CircleSource> {
    public FeedProtos.CircleSource findValueByNumber(int param1Int) {
      return FeedProtos.CircleSource.forNumber(param1Int);
    }
  }
  
  public enum DetailFrom implements ProtocolMessageEnum {
    FEED_MORE_PAGE(0),
    FIND_FOLLOW(0),
    FIND_IMAGE_PAGE(0),
    FIND_NEARBY(0),
    FIND_PLAZA(0),
    FIND_PLAZA_RECOMMEND(0),
    FIND_SUPER_TOPIC_LIST(0),
    PERSONAL_PAGE(0),
    SUPER_TOPIC_CREATE(0),
    SUPER_TOPIC_JOIN(0),
    SUPER_TOPIC_RECOMMEND(0),
    SUPER_TOPIC_VISIT(0),
    UNKNOWN_DETAIL_FROM(0),
    UNRECOGNIZED(0);
    
    public static final int FEED_MORE_PAGE_VALUE = 10;
    
    public static final int FIND_FOLLOW_VALUE = 5;
    
    public static final int FIND_IMAGE_PAGE_VALUE = 9;
    
    public static final int FIND_NEARBY_VALUE = 6;
    
    public static final int FIND_PLAZA_RECOMMEND_VALUE = 8;
    
    public static final int FIND_PLAZA_VALUE = 2;
    
    public static final int FIND_SUPER_TOPIC_LIST_VALUE = 3;
    
    public static final int PERSONAL_PAGE_VALUE = 1;
    
    public static final int SUPER_TOPIC_CREATE_VALUE = 7;
    
    public static final int SUPER_TOPIC_JOIN_VALUE = 4;
    
    public static final int SUPER_TOPIC_RECOMMEND_VALUE = 11;
    
    public static final int SUPER_TOPIC_VISIT_VALUE = 12;
    
    public static final int UNKNOWN_DETAIL_FROM_VALUE = 0;
    
    private static final DetailFrom[] VALUES;
    
    private static final Internal.EnumLiteMap<DetailFrom> internalValueMap;
    
    private final int value;
    
    static {
      FIND_PLAZA = new DetailFrom("FIND_PLAZA", 2, 2);
      FIND_SUPER_TOPIC_LIST = new DetailFrom("FIND_SUPER_TOPIC_LIST", 3, 3);
      SUPER_TOPIC_JOIN = new DetailFrom("SUPER_TOPIC_JOIN", 4, 4);
      FIND_FOLLOW = new DetailFrom("FIND_FOLLOW", 5, 5);
      FIND_NEARBY = new DetailFrom("FIND_NEARBY", 6, 6);
      SUPER_TOPIC_CREATE = new DetailFrom("SUPER_TOPIC_CREATE", 7, 7);
      FIND_PLAZA_RECOMMEND = new DetailFrom("FIND_PLAZA_RECOMMEND", 8, 8);
      FIND_IMAGE_PAGE = new DetailFrom("FIND_IMAGE_PAGE", 9, 9);
      FEED_MORE_PAGE = new DetailFrom("FEED_MORE_PAGE", 10, 10);
      SUPER_TOPIC_RECOMMEND = new DetailFrom("SUPER_TOPIC_RECOMMEND", 11, 11);
      SUPER_TOPIC_VISIT = new DetailFrom("SUPER_TOPIC_VISIT", 12, 12);
      UNRECOGNIZED = new DetailFrom("UNRECOGNIZED", 13, -1);
      $VALUES = new DetailFrom[] { 
          UNKNOWN_DETAIL_FROM, PERSONAL_PAGE, FIND_PLAZA, FIND_SUPER_TOPIC_LIST, SUPER_TOPIC_JOIN, FIND_FOLLOW, FIND_NEARBY, SUPER_TOPIC_CREATE, FIND_PLAZA_RECOMMEND, FIND_IMAGE_PAGE, 
          FEED_MORE_PAGE, SUPER_TOPIC_RECOMMEND, SUPER_TOPIC_VISIT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<DetailFrom>() {
          public FeedProtos.DetailFrom findValueByNumber(int param2Int) {
            return FeedProtos.DetailFrom.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    DetailFrom(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static DetailFrom forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 12:
          return SUPER_TOPIC_VISIT;
        case 11:
          return SUPER_TOPIC_RECOMMEND;
        case 10:
          return FEED_MORE_PAGE;
        case 9:
          return FIND_IMAGE_PAGE;
        case 8:
          return FIND_PLAZA_RECOMMEND;
        case 7:
          return SUPER_TOPIC_CREATE;
        case 6:
          return FIND_NEARBY;
        case 5:
          return FIND_FOLLOW;
        case 4:
          return SUPER_TOPIC_JOIN;
        case 3:
          return FIND_SUPER_TOPIC_LIST;
        case 2:
          return FIND_PLAZA;
        case 1:
          return PERSONAL_PAGE;
        case 0:
          break;
      } 
      return UNKNOWN_DETAIL_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(3);
    }
    
    public static Internal.EnumLiteMap<DetailFrom> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<DetailFrom> {
    public FeedProtos.DetailFrom findValueByNumber(int param1Int) {
      return FeedProtos.DetailFrom.forNumber(param1Int);
    }
  }
  
  public enum Event implements ProtocolMessageEnum {
    CIRCLE_ACTIVE_MEMBER_CLICK(0),
    CIRCLE_BRIEF_CLICK(0),
    CIRCLE_DETAIL_SHOW(0),
    CIRCLE_DRAW(0),
    CIRCLE_EXIT_BOX_SHOW(0),
    CIRCLE_EXIT_BTN_CLICK(0),
    CIRCLE_FEED_CLICK(0),
    CIRCLE_FIND_PAGE_SHOW(0),
    CIRCLE_HOT_POST_BANNER_CLICK(0),
    CIRCLE_HOT_POST_MORE_BTN_CLICK(0),
    CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK(0),
    CIRCLE_JOIN_BTN_CLICK(0),
    CIRCLE_JOIN_FEED_POP_CLICK(0),
    CIRCLE_JOIN_FEED_POP_SHOW(0),
    CIRCLE_MORE_BTN_SHOW(0),
    CIRCLE_MORE_LIST_SHOW(0),
    CIRCLE_NOTE_ADD_PHOTO_CLICK(0),
    CIRCLE_NOTE_COMMENT(0),
    CIRCLE_NOTE_COMMENT_DRAW(0),
    CIRCLE_NOTE_COMMENT_GUIDE_CLICK(0),
    CIRCLE_NOTE_COMMENT_GUIDE_SHOW(0),
    CIRCLE_NOTE_COMMENT_IMAGE_CLICK(0),
    CIRCLE_NOTE_DETAIL_SHOW(0),
    CIRCLE_NOTE_DRAW(0),
    CIRCLE_NOTE_LIKE(0),
    CIRCLE_NOTE_MANAGE_BTN_CLICK(0),
    CIRCLE_NOTE_MANAGE_SHOW(0),
    CIRCLE_NOTE_VOTE_ICON_CLICK(0),
    CIRCLE_PUBLISH_BTN_CLICK(0),
    CIRCLE_SETTINGS_PAGE_INFO_CLICK(0),
    CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK(0),
    CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK(0),
    CIRCLE_SETTINGS_PAGE_JOIN_CLICK(0),
    CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK(0),
    CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK(0),
    CIRCLE_SETTINGS_PAGE_SHOW(0),
    CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK(0),
    CIRCLE_TAB_BTN_SHOW(0),
    CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK(0),
    CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK(0),
    CIRCLE_USER_MANAGE_INVITE_CLICK(0),
    CIRCLE_USER_MANAGE_INVITE_USER(0),
    CIRCLE_USER_MANAGE_SHOW(0),
    CITY_CHAT_ROOM_CLICK(0),
    CITY_CHAT_ROOM_SHOW(0),
    CITY_LIVE_USER_CLICK(0),
    CITY_LIVE_USER_SHOW(0),
    CITY_SAY_HI_CLICK(0),
    CITY_TOP_CLICK(0),
    CITY_TOP_SHOW(0),
    FEED_ADD_PHOTO(0),
    FEED_BUBBLE_CLICK(0),
    FEED_BUBBLE_SHOW(0),
    FEED_CHATROOM_CLICK(0),
    FEED_CHATROOM_MORE_CLICK(0),
    FEED_CHATROOM_SHOW(0),
    FEED_COMMENT_BOX_CLICK(0),
    FEED_COMMENT_LIST_USER_CLICK(0),
    FEED_COMMENT_LIST_USER_SHOW(0),
    FEED_COMMENT_SEND_BTN_CLICK(0),
    FEED_DETAIL_COMMENT_DRAW(0),
    FEED_DETAIL_COMMENT_MORE_CLICK(0),
    FEED_DETAIL_COMMENT_MORE_SHOW(0),
    FEED_DETAIL_PAGE_SHOW(0),
    FEED_DETAIL_PAGE_SOURCE(0),
    FEED_DRAW(0),
    FEED_DYNAMIC_SKIN_CLICK(0),
    FEED_DYNAMIC_SKIN_SAVE_CLICK(0),
    FEED_DYNAMIC_SKIN_VIP_CLICK(0),
    FEED_FORWARD_BTN_CLICK(0),
    FEED_INTERACTIVE(0),
    FEED_LIKE_BTN_CLICK(0),
    FEED_LIKE_GO_PLAZA_BTN_CLICK(0),
    FEED_MULTI_IMAGE_CLICK(0),
    FEED_PHOTO_CLICK(0),
    FEED_PUBLISH_ADD_TOPIC_CLICK(0),
    FEED_PUBLISH_BTN_CLICK(0),
    FEED_PUBLISH_CONFIRM_BTN_CLICK(0),
    FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK(0),
    FEED_PUBLISH_SHOW(0),
    FEED_PUBLISH_STATUS_NOTIFICATION_CLICK(0),
    FEED_PUBLISH_STATUS_NOTIFICATION_SHOW(0),
    FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK(0),
    FEED_PUBLISH_SUCCESS_POP_SHOW(0),
    FEED_PUBLISH_TOPIC_CLICK(0),
    FEED_PUBLISH_TOPIC_SHOW(0),
    FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK(0),
    FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK(0),
    FEED_SUPER_TOPIC_ENTER_CLICK(0),
    FEED_VIEW_NUM_CLICK(0),
    FIND_CIRCLE_MINE_ALL_CLICK(0),
    FIND_CIRCLE_NOTE_MINE_CLICK(0),
    FIND_CIRCLE_RECOMMEND_MORE_CLICK(0),
    FIND_PLAZA_BANNER_CLICK(0),
    FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK(0),
    FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW(0),
    FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK(0),
    FIND_RECOMMEND_PAGE_SHOW(0),
    FIND_RECOMMEND_SECOND_PAGE_SHOW(0),
    FIND_TOP_DROP_DOWN_CLICK(0),
    FLASH_PLAY_DOWNLOAD_CLICK(0),
    FLASH_PLAY_LIST_ONE_CLICK(0),
    FLASH_PLAY_PAGE_SHOW(0),
    FLASH_SCREEN_COMPLETE_CLICK(0),
    FLASH_VIDEO_USER_LIVE_PHOTO_CLICK(0),
    LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK(0),
    LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW(0),
    MSG_NOTICE_CIRCLE_CLICK(0),
    MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK(0),
    MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK(0),
    MSG_NOTICE_CIRCLE_JOIN_USER_CLICK(0),
    MSG_NOTICE_CIRCLE_VIEW_CLICK(0),
    MSG_NOTICE_COMMENT_CLICK(0),
    MSG_NOTICE_COMMENT_REPLY(0),
    MSG_NOTICE_COMMENT_SHOW(0),
    MSG_NOTICE_DELETE_CLICK(0),
    MSG_NOTICE_FOLLOW_CLICK(0),
    MSG_NOTICE_LIKE_CLICK(0),
    MSG_NOTICE_VOTE_CLICK(0),
    MUTE_REMOVE_BTN_CLICK(0),
    NEW_TAG_CLICK(0),
    NEW_TAG_SHOW(0),
    NOTE_IMAGE_CLICK(0),
    NOTE_LINK_CLICK(0),
    NOTE_MORE_BTN_CLICK(0),
    NOTE_MORE_DISLIKE_CLICK(0),
    NOTE_VIDEO_CLICK(0),
    OTHER_FOLLOW_CLICK(0),
    PLAZA_RECOMMEND_FOLLOW_USER_CLICK(0),
    PLAZA_RECOMMEND_FOLLOW_USER_SHOW(0),
    PLAZA_RECOMMEND_NOTE_COMMENT_CLICK(0),
    PLAZA_RECOMMEND_NOTE_LIKE_CLICK(0),
    PLAZA_RECOMMEND_NOTE_SHARE_CLICK(0),
    SHARE_PASSWORD_POP_PASTE_CLICK(0),
    SHARE_PASSWORD_POP_SHOW(0),
    SHARE_TO_CLICK(0),
    SUPER_TOPIC_CREATE_BTN_CLICK(0),
    SUPER_TOPIC_CREATE_NEXT_BTN_CLICK(0),
    SUPER_TOPIC_CREATE_RETURN_BTN_CLICK(0),
    SUPER_TOPIC_CREATE_SHOW(0),
    SUPER_TOPIC_DETAIL_FEED_DRAW(0),
    SUPER_TOPIC_DETAIL_INTERACTIVE(0),
    SUPER_TOPIC_DETAIL_SHOW(0),
    SUPER_TOPIC_DRAW(0),
    SUPER_TOPIC_HOME_PAGE_SHOW(0),
    SUPER_TOPIC_INTERACTIVE(0),
    SUPER_TOPIC_JOIN_SHOW(0),
    SUPER_TOPIC_MINE_BTN_CLICK(0),
    SUPER_TOPIC_MORE_CLICK(0),
    SUPER_TOPIC_RECOMMEND_SHOW(0),
    SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK(0),
    SUPER_TOPIC_SEARCH_KEYWORD(0),
    SUPER_TOPIC_SEARCH_SHOW(0),
    SUPER_TOPIC_VISIT_SHOW(0),
    SV_FILTER_USED(0),
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_ACTIVE_MEMBER_CLICK_VALUE = 142;
    
    public static final int CIRCLE_BRIEF_CLICK_VALUE = 139;
    
    public static final int CIRCLE_DETAIL_SHOW_VALUE = 43;
    
    public static final int CIRCLE_DRAW_VALUE = 42;
    
    public static final int CIRCLE_EXIT_BOX_SHOW_VALUE = 54;
    
    public static final int CIRCLE_EXIT_BTN_CLICK_VALUE = 55;
    
    public static final int CIRCLE_FEED_CLICK_VALUE = 104;
    
    public static final int CIRCLE_FIND_PAGE_SHOW_VALUE = 44;
    
    public static final int CIRCLE_HOT_POST_BANNER_CLICK_VALUE = 158;
    
    public static final int CIRCLE_HOT_POST_MORE_BTN_CLICK_VALUE = 159;
    
    public static final int CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK_VALUE = 85;
    
    public static final int CIRCLE_JOIN_BTN_CLICK_VALUE = 45;
    
    public static final int CIRCLE_JOIN_FEED_POP_CLICK_VALUE = 106;
    
    public static final int CIRCLE_JOIN_FEED_POP_SHOW_VALUE = 105;
    
    public static final int CIRCLE_MORE_BTN_SHOW_VALUE = 50;
    
    public static final int CIRCLE_MORE_LIST_SHOW_VALUE = 161;
    
    public static final int CIRCLE_NOTE_ADD_PHOTO_CLICK_VALUE = 64;
    
    public static final int CIRCLE_NOTE_COMMENT_DRAW_VALUE = 51;
    
    public static final int CIRCLE_NOTE_COMMENT_GUIDE_CLICK_VALUE = 53;
    
    public static final int CIRCLE_NOTE_COMMENT_GUIDE_SHOW_VALUE = 52;
    
    public static final int CIRCLE_NOTE_COMMENT_IMAGE_CLICK_VALUE = 59;
    
    public static final int CIRCLE_NOTE_COMMENT_VALUE = 48;
    
    public static final int CIRCLE_NOTE_DETAIL_SHOW_VALUE = 47;
    
    public static final int CIRCLE_NOTE_DRAW_VALUE = 46;
    
    public static final int CIRCLE_NOTE_LIKE_VALUE = 49;
    
    public static final int CIRCLE_NOTE_MANAGE_BTN_CLICK_VALUE = 58;
    
    public static final int CIRCLE_NOTE_MANAGE_SHOW_VALUE = 57;
    
    public static final int CIRCLE_NOTE_VOTE_ICON_CLICK_VALUE = 62;
    
    public static final int CIRCLE_PUBLISH_BTN_CLICK_VALUE = 56;
    
    public static final int CIRCLE_SETTINGS_PAGE_INFO_CLICK_VALUE = 114;
    
    public static final int CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK_VALUE = 115;
    
    public static final int CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK_VALUE = 119;
    
    public static final int CIRCLE_SETTINGS_PAGE_JOIN_CLICK_VALUE = 118;
    
    public static final int CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK_VALUE = 120;
    
    public static final int CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK_VALUE = 116;
    
    public static final int CIRCLE_SETTINGS_PAGE_SHOW_VALUE = 113;
    
    public static final int CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK_VALUE = 117;
    
    public static final int CIRCLE_TAB_BTN_SHOW_VALUE = 143;
    
    public static final int CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK_VALUE = 94;
    
    public static final int CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK_VALUE = 95;
    
    public static final int CIRCLE_USER_LIST_MANAGE_CLICK_VALUE = 93;
    
    public static final int CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK_VALUE = 100;
    
    public static final int CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK_VALUE = 98;
    
    public static final int CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK_VALUE = 99;
    
    public static final int CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK_VALUE = 96;
    
    public static final int CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK_VALUE = 97;
    
    public static final int CIRCLE_USER_MANAGE_INVITE_CLICK_VALUE = 87;
    
    public static final int CIRCLE_USER_MANAGE_INVITE_USER_VALUE = 88;
    
    public static final int CIRCLE_USER_MANAGE_SHOW_VALUE = 86;
    
    public static final int CITY_CHAT_ROOM_CLICK_VALUE = 152;
    
    public static final int CITY_CHAT_ROOM_SHOW_VALUE = 151;
    
    public static final int CITY_LIVE_USER_CLICK_VALUE = 136;
    
    public static final int CITY_LIVE_USER_SHOW_VALUE = 63;
    
    public static final int CITY_SAY_HI_CLICK_VALUE = 75;
    
    public static final int CITY_TOP_CLICK_VALUE = 108;
    
    public static final int CITY_TOP_SHOW_VALUE = 107;
    
    public static final int FEED_ADD_PHOTO_VALUE = 21;
    
    public static final int FEED_BUBBLE_CLICK_VALUE = 163;
    
    public static final int FEED_BUBBLE_SHOW_VALUE = 162;
    
    public static final int FEED_CHATROOM_CLICK_VALUE = 147;
    
    public static final int FEED_CHATROOM_MORE_CLICK_VALUE = 145;
    
    public static final int FEED_CHATROOM_SHOW_VALUE = 146;
    
    public static final int FEED_COMMENT_BOX_CLICK_VALUE = 19;
    
    public static final int FEED_COMMENT_LIST_USER_CLICK_VALUE = 17;
    
    public static final int FEED_COMMENT_LIST_USER_SHOW_VALUE = 16;
    
    public static final int FEED_COMMENT_SEND_BTN_CLICK_VALUE = 32;
    
    public static final int FEED_DETAIL_COMMENT_DRAW_VALUE = 39;
    
    public static final int FEED_DETAIL_COMMENT_MORE_CLICK_VALUE = 41;
    
    public static final int FEED_DETAIL_COMMENT_MORE_SHOW_VALUE = 40;
    
    public static final int FEED_DETAIL_PAGE_SHOW_VALUE = 15;
    
    public static final int FEED_DETAIL_PAGE_SOURCE_VALUE = 25;
    
    public static final int FEED_DRAW_VALUE = 26;
    
    public static final int FEED_DYNAMIC_SKIN_CLICK_VALUE = 83;
    
    public static final int FEED_DYNAMIC_SKIN_SAVE_CLICK_VALUE = 84;
    
    public static final int FEED_DYNAMIC_SKIN_VIP_CLICK_VALUE = 138;
    
    public static final int FEED_FORWARD_BTN_CLICK_VALUE = 31;
    
    public static final int FEED_INTERACTIVE_VALUE = 18;
    
    public static final int FEED_LIKE_BTN_CLICK_VALUE = 33;
    
    public static final int FEED_LIKE_GO_PLAZA_BTN_CLICK_VALUE = 35;
    
    public static final int FEED_MULTI_IMAGE_CLICK_VALUE = 76;
    
    public static final int FEED_PHOTO_CLICK_VALUE = 78;
    
    public static final int FEED_PUBLISH_ADD_TOPIC_CLICK_VALUE = 154;
    
    public static final int FEED_PUBLISH_BTN_CLICK_VALUE = 14;
    
    public static final int FEED_PUBLISH_CONFIRM_BTN_CLICK_VALUE = 6;
    
    public static final int FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK_VALUE = 156;
    
    public static final int FEED_PUBLISH_SHOW_VALUE = 155;
    
    public static final int FEED_PUBLISH_STATUS_NOTIFICATION_CLICK_VALUE = 149;
    
    public static final int FEED_PUBLISH_STATUS_NOTIFICATION_SHOW_VALUE = 148;
    
    public static final int FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK_VALUE = 102;
    
    public static final int FEED_PUBLISH_SUCCESS_POP_SHOW_VALUE = 101;
    
    public static final int FEED_PUBLISH_TOPIC_CLICK_VALUE = 153;
    
    public static final int FEED_PUBLISH_TOPIC_SHOW_VALUE = 157;
    
    public static final int FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK_VALUE = 82;
    
    public static final int FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK_VALUE = 81;
    
    public static final int FEED_SUPER_TOPIC_ENTER_CLICK_VALUE = 24;
    
    public static final int FEED_VIEW_NUM_CLICK_VALUE = 122;
    
    public static final int FIND_CIRCLE_MINE_ALL_CLICK_VALUE = 110;
    
    public static final int FIND_CIRCLE_NOTE_MINE_CLICK_VALUE = 112;
    
    public static final int FIND_CIRCLE_RECOMMEND_MORE_CLICK_VALUE = 111;
    
    public static final int FIND_PLAZA_BANNER_CLICK_VALUE = 1;
    
    public static final int FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK_VALUE = 29;
    
    public static final int FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW_VALUE = 28;
    
    public static final int FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK_VALUE = 121;
    
    public static final int FIND_RECOMMEND_PAGE_SHOW_VALUE = 133;
    
    public static final int FIND_RECOMMEND_SECOND_PAGE_SHOW_VALUE = 134;
    
    public static final int FIND_TOP_DROP_DOWN_CLICK_VALUE = 61;
    
    public static final int FLASH_PLAY_DOWNLOAD_CLICK_VALUE = 150;
    
    public static final int FLASH_PLAY_LIST_ONE_CLICK_VALUE = 109;
    
    public static final int FLASH_PLAY_PAGE_SHOW_VALUE = 34;
    
    public static final int FLASH_SCREEN_COMPLETE_CLICK_VALUE = 77;
    
    public static final int FLASH_VIDEO_USER_LIVE_PHOTO_CLICK_VALUE = 36;
    
    public static final int LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK_VALUE = 38;
    
    public static final int LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW_VALUE = 37;
    
    public static final int MSG_NOTICE_CIRCLE_CLICK_VALUE = 89;
    
    public static final int MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK_VALUE = 90;
    
    public static final int MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK_VALUE = 91;
    
    public static final int MSG_NOTICE_CIRCLE_JOIN_USER_CLICK_VALUE = 92;
    
    public static final int MSG_NOTICE_CIRCLE_VIEW_CLICK_VALUE = 144;
    
    public static final int MSG_NOTICE_COMMENT_CLICK_VALUE = 66;
    
    public static final int MSG_NOTICE_COMMENT_REPLY_VALUE = 67;
    
    public static final int MSG_NOTICE_COMMENT_SHOW_VALUE = 65;
    
    public static final int MSG_NOTICE_DELETE_CLICK_VALUE = 71;
    
    public static final int MSG_NOTICE_FOLLOW_CLICK_VALUE = 68;
    
    public static final int MSG_NOTICE_LIKE_CLICK_VALUE = 69;
    
    public static final int MSG_NOTICE_VOTE_CLICK_VALUE = 70;
    
    public static final int MUTE_REMOVE_BTN_CLICK_VALUE = 103;
    
    public static final int NEW_TAG_CLICK_VALUE = 141;
    
    public static final int NEW_TAG_SHOW_VALUE = 140;
    
    public static final int NOTE_IMAGE_CLICK_VALUE = 131;
    
    public static final int NOTE_LINK_CLICK_VALUE = 160;
    
    public static final int NOTE_MORE_BTN_CLICK_VALUE = 129;
    
    public static final int NOTE_MORE_DISLIKE_CLICK_VALUE = 130;
    
    public static final int NOTE_VIDEO_CLICK_VALUE = 132;
    
    public static final int OTHER_FOLLOW_CLICK_VALUE = 23;
    
    public static final int PLAZA_RECOMMEND_FOLLOW_USER_CLICK_VALUE = 60;
    
    public static final int PLAZA_RECOMMEND_FOLLOW_USER_SHOW_VALUE = 22;
    
    public static final int PLAZA_RECOMMEND_NOTE_COMMENT_CLICK_VALUE = 73;
    
    public static final int PLAZA_RECOMMEND_NOTE_LIKE_CLICK_VALUE = 72;
    
    public static final int PLAZA_RECOMMEND_NOTE_SHARE_CLICK_VALUE = 74;
    
    public static final int SHARE_PASSWORD_POP_PASTE_CLICK_VALUE = 80;
    
    public static final int SHARE_PASSWORD_POP_SHOW_VALUE = 79;
    
    public static final int SHARE_TO_CLICK_VALUE = 30;
    
    public static final int SUPER_TOPIC_CREATE_BTN_CLICK_VALUE = 3;
    
    public static final int SUPER_TOPIC_CREATE_NEXT_BTN_CLICK_VALUE = 4;
    
    public static final int SUPER_TOPIC_CREATE_RETURN_BTN_CLICK_VALUE = 5;
    
    public static final int SUPER_TOPIC_CREATE_SHOW_VALUE = 128;
    
    public static final int SUPER_TOPIC_DETAIL_FEED_DRAW_VALUE = 8;
    
    public static final int SUPER_TOPIC_DETAIL_INTERACTIVE_VALUE = 12;
    
    public static final int SUPER_TOPIC_DETAIL_SHOW_VALUE = 7;
    
    public static final int SUPER_TOPIC_DRAW_VALUE = 2;
    
    public static final int SUPER_TOPIC_HOME_PAGE_SHOW_VALUE = 123;
    
    public static final int SUPER_TOPIC_INTERACTIVE_VALUE = 13;
    
    public static final int SUPER_TOPIC_JOIN_SHOW_VALUE = 127;
    
    public static final int SUPER_TOPIC_MINE_BTN_CLICK_VALUE = 9;
    
    public static final int SUPER_TOPIC_MORE_CLICK_VALUE = 124;
    
    public static final int SUPER_TOPIC_RECOMMEND_SHOW_VALUE = 125;
    
    public static final int SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK_VALUE = 20;
    
    public static final int SUPER_TOPIC_SEARCH_KEYWORD_VALUE = 11;
    
    public static final int SUPER_TOPIC_SEARCH_SHOW_VALUE = 10;
    
    public static final int SUPER_TOPIC_VISIT_SHOW_VALUE = 126;
    
    public static final int SV_FILTER_USED_VALUE = 137;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      SUPER_TOPIC_CREATE_BTN_CLICK = new Event("SUPER_TOPIC_CREATE_BTN_CLICK", 3, 3);
      SUPER_TOPIC_CREATE_NEXT_BTN_CLICK = new Event("SUPER_TOPIC_CREATE_NEXT_BTN_CLICK", 4, 4);
      SUPER_TOPIC_CREATE_RETURN_BTN_CLICK = new Event("SUPER_TOPIC_CREATE_RETURN_BTN_CLICK", 5, 5);
      FEED_PUBLISH_CONFIRM_BTN_CLICK = new Event("FEED_PUBLISH_CONFIRM_BTN_CLICK", 6, 6);
      SUPER_TOPIC_DETAIL_SHOW = new Event("SUPER_TOPIC_DETAIL_SHOW", 7, 7);
      SUPER_TOPIC_DETAIL_FEED_DRAW = new Event("SUPER_TOPIC_DETAIL_FEED_DRAW", 8, 8);
      SUPER_TOPIC_MINE_BTN_CLICK = new Event("SUPER_TOPIC_MINE_BTN_CLICK", 9, 9);
      SUPER_TOPIC_SEARCH_SHOW = new Event("SUPER_TOPIC_SEARCH_SHOW", 10, 10);
      SUPER_TOPIC_SEARCH_KEYWORD = new Event("SUPER_TOPIC_SEARCH_KEYWORD", 11, 11);
      SUPER_TOPIC_DETAIL_INTERACTIVE = new Event("SUPER_TOPIC_DETAIL_INTERACTIVE", 12, 12);
      SUPER_TOPIC_INTERACTIVE = new Event("SUPER_TOPIC_INTERACTIVE", 13, 13);
      FEED_PUBLISH_BTN_CLICK = new Event("FEED_PUBLISH_BTN_CLICK", 14, 14);
      FEED_DETAIL_PAGE_SHOW = new Event("FEED_DETAIL_PAGE_SHOW", 15, 15);
      FEED_COMMENT_LIST_USER_SHOW = new Event("FEED_COMMENT_LIST_USER_SHOW", 16, 16);
      FEED_COMMENT_LIST_USER_CLICK = new Event("FEED_COMMENT_LIST_USER_CLICK", 17, 17);
      FEED_INTERACTIVE = new Event("FEED_INTERACTIVE", 18, 18);
      FEED_COMMENT_BOX_CLICK = new Event("FEED_COMMENT_BOX_CLICK", 19, 19);
      SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK = new Event("SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK", 20, 20);
      FEED_ADD_PHOTO = new Event("FEED_ADD_PHOTO", 21, 21);
      PLAZA_RECOMMEND_FOLLOW_USER_SHOW = new Event("PLAZA_RECOMMEND_FOLLOW_USER_SHOW", 22, 22);
      OTHER_FOLLOW_CLICK = new Event("OTHER_FOLLOW_CLICK", 23, 23);
      FEED_SUPER_TOPIC_ENTER_CLICK = new Event("FEED_SUPER_TOPIC_ENTER_CLICK", 24, 24);
      FEED_DETAIL_PAGE_SOURCE = new Event("FEED_DETAIL_PAGE_SOURCE", 25, 25);
      FEED_DRAW = new Event("FEED_DRAW", 26, 26);
      FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW = new Event("FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW", 27, 28);
      FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK = new Event("FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK", 28, 29);
      SHARE_TO_CLICK = new Event("SHARE_TO_CLICK", 29, 30);
      FEED_FORWARD_BTN_CLICK = new Event("FEED_FORWARD_BTN_CLICK", 30, 31);
      FEED_COMMENT_SEND_BTN_CLICK = new Event("FEED_COMMENT_SEND_BTN_CLICK", 31, 32);
      FEED_LIKE_BTN_CLICK = new Event("FEED_LIKE_BTN_CLICK", 32, 33);
      FLASH_PLAY_PAGE_SHOW = new Event("FLASH_PLAY_PAGE_SHOW", 33, 34);
      FEED_LIKE_GO_PLAZA_BTN_CLICK = new Event("FEED_LIKE_GO_PLAZA_BTN_CLICK", 34, 35);
      FLASH_VIDEO_USER_LIVE_PHOTO_CLICK = new Event("FLASH_VIDEO_USER_LIVE_PHOTO_CLICK", 35, 36);
      LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW = new Event("LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW", 36, 37);
      LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK = new Event("LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK", 37, 38);
      FEED_DETAIL_COMMENT_DRAW = new Event("FEED_DETAIL_COMMENT_DRAW", 38, 39);
      FEED_DETAIL_COMMENT_MORE_SHOW = new Event("FEED_DETAIL_COMMENT_MORE_SHOW", 39, 40);
      FEED_DETAIL_COMMENT_MORE_CLICK = new Event("FEED_DETAIL_COMMENT_MORE_CLICK", 40, 41);
      CIRCLE_DRAW = new Event("CIRCLE_DRAW", 41, 42);
      CIRCLE_DETAIL_SHOW = new Event("CIRCLE_DETAIL_SHOW", 42, 43);
      CIRCLE_FIND_PAGE_SHOW = new Event("CIRCLE_FIND_PAGE_SHOW", 43, 44);
      CIRCLE_JOIN_BTN_CLICK = new Event("CIRCLE_JOIN_BTN_CLICK", 44, 45);
      CIRCLE_NOTE_DRAW = new Event("CIRCLE_NOTE_DRAW", 45, 46);
      CIRCLE_NOTE_DETAIL_SHOW = new Event("CIRCLE_NOTE_DETAIL_SHOW", 46, 47);
      CIRCLE_NOTE_COMMENT = new Event("CIRCLE_NOTE_COMMENT", 47, 48);
      CIRCLE_NOTE_LIKE = new Event("CIRCLE_NOTE_LIKE", 48, 49);
      CIRCLE_MORE_BTN_SHOW = new Event("CIRCLE_MORE_BTN_SHOW", 49, 50);
      CIRCLE_NOTE_COMMENT_DRAW = new Event("CIRCLE_NOTE_COMMENT_DRAW", 50, 51);
      CIRCLE_NOTE_COMMENT_GUIDE_SHOW = new Event("CIRCLE_NOTE_COMMENT_GUIDE_SHOW", 51, 52);
      CIRCLE_NOTE_COMMENT_GUIDE_CLICK = new Event("CIRCLE_NOTE_COMMENT_GUIDE_CLICK", 52, 53);
      CIRCLE_EXIT_BOX_SHOW = new Event("CIRCLE_EXIT_BOX_SHOW", 53, 54);
      CIRCLE_EXIT_BTN_CLICK = new Event("CIRCLE_EXIT_BTN_CLICK", 54, 55);
      CIRCLE_PUBLISH_BTN_CLICK = new Event("CIRCLE_PUBLISH_BTN_CLICK", 55, 56);
      CIRCLE_NOTE_MANAGE_SHOW = new Event("CIRCLE_NOTE_MANAGE_SHOW", 56, 57);
      CIRCLE_NOTE_MANAGE_BTN_CLICK = new Event("CIRCLE_NOTE_MANAGE_BTN_CLICK", 57, 58);
      CIRCLE_NOTE_COMMENT_IMAGE_CLICK = new Event("CIRCLE_NOTE_COMMENT_IMAGE_CLICK", 58, 59);
      PLAZA_RECOMMEND_FOLLOW_USER_CLICK = new Event("PLAZA_RECOMMEND_FOLLOW_USER_CLICK", 59, 60);
      FIND_TOP_DROP_DOWN_CLICK = new Event("FIND_TOP_DROP_DOWN_CLICK", 60, 61);
      CIRCLE_NOTE_VOTE_ICON_CLICK = new Event("CIRCLE_NOTE_VOTE_ICON_CLICK", 61, 62);
      CITY_LIVE_USER_SHOW = new Event("CITY_LIVE_USER_SHOW", 62, 63);
      CIRCLE_NOTE_ADD_PHOTO_CLICK = new Event("CIRCLE_NOTE_ADD_PHOTO_CLICK", 63, 64);
      MSG_NOTICE_COMMENT_SHOW = new Event("MSG_NOTICE_COMMENT_SHOW", 64, 65);
      MSG_NOTICE_COMMENT_CLICK = new Event("MSG_NOTICE_COMMENT_CLICK", 65, 66);
      MSG_NOTICE_COMMENT_REPLY = new Event("MSG_NOTICE_COMMENT_REPLY", 66, 67);
      MSG_NOTICE_FOLLOW_CLICK = new Event("MSG_NOTICE_FOLLOW_CLICK", 67, 68);
      MSG_NOTICE_LIKE_CLICK = new Event("MSG_NOTICE_LIKE_CLICK", 68, 69);
      MSG_NOTICE_VOTE_CLICK = new Event("MSG_NOTICE_VOTE_CLICK", 69, 70);
      MSG_NOTICE_DELETE_CLICK = new Event("MSG_NOTICE_DELETE_CLICK", 70, 71);
      PLAZA_RECOMMEND_NOTE_LIKE_CLICK = new Event("PLAZA_RECOMMEND_NOTE_LIKE_CLICK", 71, 72);
      PLAZA_RECOMMEND_NOTE_COMMENT_CLICK = new Event("PLAZA_RECOMMEND_NOTE_COMMENT_CLICK", 72, 73);
      PLAZA_RECOMMEND_NOTE_SHARE_CLICK = new Event("PLAZA_RECOMMEND_NOTE_SHARE_CLICK", 73, 74);
      CITY_SAY_HI_CLICK = new Event("CITY_SAY_HI_CLICK", 74, 75);
      FEED_MULTI_IMAGE_CLICK = new Event("FEED_MULTI_IMAGE_CLICK", 75, 76);
      FLASH_SCREEN_COMPLETE_CLICK = new Event("FLASH_SCREEN_COMPLETE_CLICK", 76, 77);
      FEED_PHOTO_CLICK = new Event("FEED_PHOTO_CLICK", 77, 78);
      SHARE_PASSWORD_POP_SHOW = new Event("SHARE_PASSWORD_POP_SHOW", 78, 79);
      SHARE_PASSWORD_POP_PASTE_CLICK = new Event("SHARE_PASSWORD_POP_PASTE_CLICK", 79, 80);
      FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK = new Event("FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK", 80, 81);
      FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK = new Event("FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK", 81, 82);
      FEED_DYNAMIC_SKIN_CLICK = new Event("FEED_DYNAMIC_SKIN_CLICK", 82, 83);
      FEED_DYNAMIC_SKIN_SAVE_CLICK = new Event("FEED_DYNAMIC_SKIN_SAVE_CLICK", 83, 84);
      CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK = new Event("CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK", 84, 85);
      CIRCLE_USER_MANAGE_SHOW = new Event("CIRCLE_USER_MANAGE_SHOW", 85, 86);
      CIRCLE_USER_MANAGE_INVITE_CLICK = new Event("CIRCLE_USER_MANAGE_INVITE_CLICK", 86, 87);
      CIRCLE_USER_MANAGE_INVITE_USER = new Event("CIRCLE_USER_MANAGE_INVITE_USER", 87, 88);
      MSG_NOTICE_CIRCLE_CLICK = new Event("MSG_NOTICE_CIRCLE_CLICK", 88, 89);
      MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK = new Event("MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK", 89, 90);
      MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK = new Event("MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK", 90, 91);
      MSG_NOTICE_CIRCLE_JOIN_USER_CLICK = new Event("MSG_NOTICE_CIRCLE_JOIN_USER_CLICK", 91, 92);
      CIRCLE_USER_LIST_MANAGE_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_CLICK", 92, 93);
      CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK", 93, 94);
      CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK", 94, 95);
      CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK", 95, 96);
      CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK", 96, 97);
      CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK", 97, 98);
      CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK", 98, 99);
      CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK = new Event("CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK", 99, 100);
      FEED_PUBLISH_SUCCESS_POP_SHOW = new Event("FEED_PUBLISH_SUCCESS_POP_SHOW", 100, 101);
      FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK = new Event("FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK", 101, 102);
      MUTE_REMOVE_BTN_CLICK = new Event("MUTE_REMOVE_BTN_CLICK", 102, 103);
      CIRCLE_FEED_CLICK = new Event("CIRCLE_FEED_CLICK", 103, 104);
      CIRCLE_JOIN_FEED_POP_SHOW = new Event("CIRCLE_JOIN_FEED_POP_SHOW", 104, 105);
      CIRCLE_JOIN_FEED_POP_CLICK = new Event("CIRCLE_JOIN_FEED_POP_CLICK", 105, 106);
      CITY_TOP_SHOW = new Event("CITY_TOP_SHOW", 106, 107);
      CITY_TOP_CLICK = new Event("CITY_TOP_CLICK", 107, 108);
      FLASH_PLAY_LIST_ONE_CLICK = new Event("FLASH_PLAY_LIST_ONE_CLICK", 108, 109);
      FIND_CIRCLE_MINE_ALL_CLICK = new Event("FIND_CIRCLE_MINE_ALL_CLICK", 109, 110);
      FIND_CIRCLE_RECOMMEND_MORE_CLICK = new Event("FIND_CIRCLE_RECOMMEND_MORE_CLICK", 110, 111);
      FIND_CIRCLE_NOTE_MINE_CLICK = new Event("FIND_CIRCLE_NOTE_MINE_CLICK", 111, 112);
      CIRCLE_SETTINGS_PAGE_SHOW = new Event("CIRCLE_SETTINGS_PAGE_SHOW", 112, 113);
      CIRCLE_SETTINGS_PAGE_INFO_CLICK = new Event("CIRCLE_SETTINGS_PAGE_INFO_CLICK", 113, 114);
      CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK = new Event("CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK", 114, 115);
      CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK = new Event("CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK", 115, 116);
      CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK = new Event("CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK", 116, 117);
      CIRCLE_SETTINGS_PAGE_JOIN_CLICK = new Event("CIRCLE_SETTINGS_PAGE_JOIN_CLICK", 117, 118);
      CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK = new Event("CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK", 118, 119);
      CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK = new Event("CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK", 119, 120);
      FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK = new Event("FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK", 120, 121);
      FEED_VIEW_NUM_CLICK = new Event("FEED_VIEW_NUM_CLICK", 121, 122);
      SUPER_TOPIC_HOME_PAGE_SHOW = new Event("SUPER_TOPIC_HOME_PAGE_SHOW", 122, 123);
      SUPER_TOPIC_MORE_CLICK = new Event("SUPER_TOPIC_MORE_CLICK", 123, 124);
      SUPER_TOPIC_RECOMMEND_SHOW = new Event("SUPER_TOPIC_RECOMMEND_SHOW", 124, 125);
      SUPER_TOPIC_VISIT_SHOW = new Event("SUPER_TOPIC_VISIT_SHOW", 125, 126);
      SUPER_TOPIC_JOIN_SHOW = new Event("SUPER_TOPIC_JOIN_SHOW", 126, 127);
      SUPER_TOPIC_CREATE_SHOW = new Event("SUPER_TOPIC_CREATE_SHOW", 127, 128);
      NOTE_MORE_BTN_CLICK = new Event("NOTE_MORE_BTN_CLICK", 128, 129);
      NOTE_MORE_DISLIKE_CLICK = new Event("NOTE_MORE_DISLIKE_CLICK", 129, 130);
      NOTE_IMAGE_CLICK = new Event("NOTE_IMAGE_CLICK", 130, 131);
      NOTE_VIDEO_CLICK = new Event("NOTE_VIDEO_CLICK", 131, 132);
      FIND_RECOMMEND_PAGE_SHOW = new Event("FIND_RECOMMEND_PAGE_SHOW", 132, 133);
      FIND_RECOMMEND_SECOND_PAGE_SHOW = new Event("FIND_RECOMMEND_SECOND_PAGE_SHOW", 133, 134);
      CITY_LIVE_USER_CLICK = new Event("CITY_LIVE_USER_CLICK", 134, 136);
      SV_FILTER_USED = new Event("SV_FILTER_USED", 135, 137);
      FEED_DYNAMIC_SKIN_VIP_CLICK = new Event("FEED_DYNAMIC_SKIN_VIP_CLICK", 136, 138);
      CIRCLE_BRIEF_CLICK = new Event("CIRCLE_BRIEF_CLICK", 137, 139);
      NEW_TAG_SHOW = new Event("NEW_TAG_SHOW", 138, 140);
      NEW_TAG_CLICK = new Event("NEW_TAG_CLICK", 139, 141);
      CIRCLE_ACTIVE_MEMBER_CLICK = new Event("CIRCLE_ACTIVE_MEMBER_CLICK", 140, 142);
      CIRCLE_TAB_BTN_SHOW = new Event("CIRCLE_TAB_BTN_SHOW", 141, 143);
      MSG_NOTICE_CIRCLE_VIEW_CLICK = new Event("MSG_NOTICE_CIRCLE_VIEW_CLICK", 142, 144);
      FEED_CHATROOM_MORE_CLICK = new Event("FEED_CHATROOM_MORE_CLICK", 143, 145);
      FEED_CHATROOM_SHOW = new Event("FEED_CHATROOM_SHOW", 144, 146);
      FEED_CHATROOM_CLICK = new Event("FEED_CHATROOM_CLICK", 145, 147);
      FEED_PUBLISH_STATUS_NOTIFICATION_SHOW = new Event("FEED_PUBLISH_STATUS_NOTIFICATION_SHOW", 146, 148);
      FEED_PUBLISH_STATUS_NOTIFICATION_CLICK = new Event("FEED_PUBLISH_STATUS_NOTIFICATION_CLICK", 147, 149);
      FLASH_PLAY_DOWNLOAD_CLICK = new Event("FLASH_PLAY_DOWNLOAD_CLICK", 148, 150);
      CITY_CHAT_ROOM_SHOW = new Event("CITY_CHAT_ROOM_SHOW", 149, 151);
      CITY_CHAT_ROOM_CLICK = new Event("CITY_CHAT_ROOM_CLICK", 150, 152);
      FEED_PUBLISH_TOPIC_CLICK = new Event("FEED_PUBLISH_TOPIC_CLICK", 151, 153);
      FEED_PUBLISH_ADD_TOPIC_CLICK = new Event("FEED_PUBLISH_ADD_TOPIC_CLICK", 152, 154);
      FEED_PUBLISH_SHOW = new Event("FEED_PUBLISH_SHOW", 153, 155);
      FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK = new Event("FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK", 154, 156);
      FEED_PUBLISH_TOPIC_SHOW = new Event("FEED_PUBLISH_TOPIC_SHOW", 155, 157);
      CIRCLE_HOT_POST_BANNER_CLICK = new Event("CIRCLE_HOT_POST_BANNER_CLICK", 156, 158);
      CIRCLE_HOT_POST_MORE_BTN_CLICK = new Event("CIRCLE_HOT_POST_MORE_BTN_CLICK", 157, 159);
      NOTE_LINK_CLICK = new Event("NOTE_LINK_CLICK", 158, 160);
      CIRCLE_MORE_LIST_SHOW = new Event("CIRCLE_MORE_LIST_SHOW", 159, 161);
      FEED_BUBBLE_SHOW = new Event("FEED_BUBBLE_SHOW", 160, 162);
      FEED_BUBBLE_CLICK = new Event("FEED_BUBBLE_CLICK", 161, 163);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 162, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, FIND_PLAZA_BANNER_CLICK, SUPER_TOPIC_DRAW, SUPER_TOPIC_CREATE_BTN_CLICK, SUPER_TOPIC_CREATE_NEXT_BTN_CLICK, SUPER_TOPIC_CREATE_RETURN_BTN_CLICK, FEED_PUBLISH_CONFIRM_BTN_CLICK, SUPER_TOPIC_DETAIL_SHOW, SUPER_TOPIC_DETAIL_FEED_DRAW, SUPER_TOPIC_MINE_BTN_CLICK, 
          SUPER_TOPIC_SEARCH_SHOW, SUPER_TOPIC_SEARCH_KEYWORD, SUPER_TOPIC_DETAIL_INTERACTIVE, SUPER_TOPIC_INTERACTIVE, FEED_PUBLISH_BTN_CLICK, FEED_DETAIL_PAGE_SHOW, FEED_COMMENT_LIST_USER_SHOW, FEED_COMMENT_LIST_USER_CLICK, FEED_INTERACTIVE, FEED_COMMENT_BOX_CLICK, 
          SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK, FEED_ADD_PHOTO, PLAZA_RECOMMEND_FOLLOW_USER_SHOW, OTHER_FOLLOW_CLICK, FEED_SUPER_TOPIC_ENTER_CLICK, FEED_DETAIL_PAGE_SOURCE, FEED_DRAW, FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK, SHARE_TO_CLICK, 
          FEED_FORWARD_BTN_CLICK, FEED_COMMENT_SEND_BTN_CLICK, FEED_LIKE_BTN_CLICK, FLASH_PLAY_PAGE_SHOW, FEED_LIKE_GO_PLAZA_BTN_CLICK, FLASH_VIDEO_USER_LIVE_PHOTO_CLICK, LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW, LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK, FEED_DETAIL_COMMENT_DRAW, FEED_DETAIL_COMMENT_MORE_SHOW, 
          FEED_DETAIL_COMMENT_MORE_CLICK, CIRCLE_DRAW, CIRCLE_DETAIL_SHOW, CIRCLE_FIND_PAGE_SHOW, CIRCLE_JOIN_BTN_CLICK, CIRCLE_NOTE_DRAW, CIRCLE_NOTE_DETAIL_SHOW, CIRCLE_NOTE_COMMENT, CIRCLE_NOTE_LIKE, CIRCLE_MORE_BTN_SHOW, 
          CIRCLE_NOTE_COMMENT_DRAW, CIRCLE_NOTE_COMMENT_GUIDE_SHOW, CIRCLE_NOTE_COMMENT_GUIDE_CLICK, CIRCLE_EXIT_BOX_SHOW, CIRCLE_EXIT_BTN_CLICK, CIRCLE_PUBLISH_BTN_CLICK, CIRCLE_NOTE_MANAGE_SHOW, CIRCLE_NOTE_MANAGE_BTN_CLICK, CIRCLE_NOTE_COMMENT_IMAGE_CLICK, PLAZA_RECOMMEND_FOLLOW_USER_CLICK, 
          FIND_TOP_DROP_DOWN_CLICK, CIRCLE_NOTE_VOTE_ICON_CLICK, CITY_LIVE_USER_SHOW, CIRCLE_NOTE_ADD_PHOTO_CLICK, MSG_NOTICE_COMMENT_SHOW, MSG_NOTICE_COMMENT_CLICK, MSG_NOTICE_COMMENT_REPLY, MSG_NOTICE_FOLLOW_CLICK, MSG_NOTICE_LIKE_CLICK, MSG_NOTICE_VOTE_CLICK, 
          MSG_NOTICE_DELETE_CLICK, PLAZA_RECOMMEND_NOTE_LIKE_CLICK, PLAZA_RECOMMEND_NOTE_COMMENT_CLICK, PLAZA_RECOMMEND_NOTE_SHARE_CLICK, CITY_SAY_HI_CLICK, FEED_MULTI_IMAGE_CLICK, FLASH_SCREEN_COMPLETE_CLICK, FEED_PHOTO_CLICK, SHARE_PASSWORD_POP_SHOW, SHARE_PASSWORD_POP_PASTE_CLICK, 
          FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK, FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK, FEED_DYNAMIC_SKIN_CLICK, FEED_DYNAMIC_SKIN_SAVE_CLICK, CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK, CIRCLE_USER_MANAGE_SHOW, CIRCLE_USER_MANAGE_INVITE_CLICK, CIRCLE_USER_MANAGE_INVITE_USER, MSG_NOTICE_CIRCLE_CLICK, MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK, 
          MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK, MSG_NOTICE_CIRCLE_JOIN_USER_CLICK, CIRCLE_USER_LIST_MANAGE_CLICK, CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK, CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK, CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK, CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK, CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK, CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK, CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK, 
          FEED_PUBLISH_SUCCESS_POP_SHOW, FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK, MUTE_REMOVE_BTN_CLICK, CIRCLE_FEED_CLICK, CIRCLE_JOIN_FEED_POP_SHOW, CIRCLE_JOIN_FEED_POP_CLICK, CITY_TOP_SHOW, CITY_TOP_CLICK, FLASH_PLAY_LIST_ONE_CLICK, FIND_CIRCLE_MINE_ALL_CLICK, 
          FIND_CIRCLE_RECOMMEND_MORE_CLICK, FIND_CIRCLE_NOTE_MINE_CLICK, CIRCLE_SETTINGS_PAGE_SHOW, CIRCLE_SETTINGS_PAGE_INFO_CLICK, CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK, CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK, CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK, CIRCLE_SETTINGS_PAGE_JOIN_CLICK, CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK, CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK, 
          FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK, FEED_VIEW_NUM_CLICK, SUPER_TOPIC_HOME_PAGE_SHOW, SUPER_TOPIC_MORE_CLICK, SUPER_TOPIC_RECOMMEND_SHOW, SUPER_TOPIC_VISIT_SHOW, SUPER_TOPIC_JOIN_SHOW, SUPER_TOPIC_CREATE_SHOW, NOTE_MORE_BTN_CLICK, NOTE_MORE_DISLIKE_CLICK, 
          NOTE_IMAGE_CLICK, NOTE_VIDEO_CLICK, FIND_RECOMMEND_PAGE_SHOW, FIND_RECOMMEND_SECOND_PAGE_SHOW, CITY_LIVE_USER_CLICK, SV_FILTER_USED, FEED_DYNAMIC_SKIN_VIP_CLICK, CIRCLE_BRIEF_CLICK, NEW_TAG_SHOW, NEW_TAG_CLICK, 
          CIRCLE_ACTIVE_MEMBER_CLICK, CIRCLE_TAB_BTN_SHOW, MSG_NOTICE_CIRCLE_VIEW_CLICK, FEED_CHATROOM_MORE_CLICK, FEED_CHATROOM_SHOW, FEED_CHATROOM_CLICK, FEED_PUBLISH_STATUS_NOTIFICATION_SHOW, FEED_PUBLISH_STATUS_NOTIFICATION_CLICK, FLASH_PLAY_DOWNLOAD_CLICK, CITY_CHAT_ROOM_SHOW, 
          CITY_CHAT_ROOM_CLICK, FEED_PUBLISH_TOPIC_CLICK, FEED_PUBLISH_ADD_TOPIC_CLICK, FEED_PUBLISH_SHOW, FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK, FEED_PUBLISH_TOPIC_SHOW, CIRCLE_HOT_POST_BANNER_CLICK, CIRCLE_HOT_POST_MORE_BTN_CLICK, NOTE_LINK_CLICK, CIRCLE_MORE_LIST_SHOW, 
          FEED_BUBBLE_SHOW, FEED_BUBBLE_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public FeedProtos.Event findValueByNumber(int param2Int) {
            return FeedProtos.Event.forNumber(param2Int);
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
        case 163:
          return FEED_BUBBLE_CLICK;
        case 162:
          return FEED_BUBBLE_SHOW;
        case 161:
          return CIRCLE_MORE_LIST_SHOW;
        case 160:
          return NOTE_LINK_CLICK;
        case 159:
          return CIRCLE_HOT_POST_MORE_BTN_CLICK;
        case 158:
          return CIRCLE_HOT_POST_BANNER_CLICK;
        case 157:
          return FEED_PUBLISH_TOPIC_SHOW;
        case 156:
          return FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK;
        case 155:
          return FEED_PUBLISH_SHOW;
        case 154:
          return FEED_PUBLISH_ADD_TOPIC_CLICK;
        case 153:
          return FEED_PUBLISH_TOPIC_CLICK;
        case 152:
          return CITY_CHAT_ROOM_CLICK;
        case 151:
          return CITY_CHAT_ROOM_SHOW;
        case 150:
          return FLASH_PLAY_DOWNLOAD_CLICK;
        case 149:
          return FEED_PUBLISH_STATUS_NOTIFICATION_CLICK;
        case 148:
          return FEED_PUBLISH_STATUS_NOTIFICATION_SHOW;
        case 147:
          return FEED_CHATROOM_CLICK;
        case 146:
          return FEED_CHATROOM_SHOW;
        case 145:
          return FEED_CHATROOM_MORE_CLICK;
        case 144:
          return MSG_NOTICE_CIRCLE_VIEW_CLICK;
        case 143:
          return CIRCLE_TAB_BTN_SHOW;
        case 142:
          return CIRCLE_ACTIVE_MEMBER_CLICK;
        case 141:
          return NEW_TAG_CLICK;
        case 140:
          return NEW_TAG_SHOW;
        case 139:
          return CIRCLE_BRIEF_CLICK;
        case 138:
          return FEED_DYNAMIC_SKIN_VIP_CLICK;
        case 137:
          return SV_FILTER_USED;
        case 136:
          return CITY_LIVE_USER_CLICK;
        case 134:
          return FIND_RECOMMEND_SECOND_PAGE_SHOW;
        case 133:
          return FIND_RECOMMEND_PAGE_SHOW;
        case 132:
          return NOTE_VIDEO_CLICK;
        case 131:
          return NOTE_IMAGE_CLICK;
        case 130:
          return NOTE_MORE_DISLIKE_CLICK;
        case 129:
          return NOTE_MORE_BTN_CLICK;
        case 128:
          return SUPER_TOPIC_CREATE_SHOW;
        case 127:
          return SUPER_TOPIC_JOIN_SHOW;
        case 126:
          return SUPER_TOPIC_VISIT_SHOW;
        case 125:
          return SUPER_TOPIC_RECOMMEND_SHOW;
        case 124:
          return SUPER_TOPIC_MORE_CLICK;
        case 123:
          return SUPER_TOPIC_HOME_PAGE_SHOW;
        case 122:
          return FEED_VIEW_NUM_CLICK;
        case 121:
          return FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK;
        case 120:
          return CIRCLE_SETTINGS_PAGE_JOIN_REPLY_CLICK;
        case 119:
          return CIRCLE_SETTINGS_PAGE_JOIN_ALL_CLICK;
        case 118:
          return CIRCLE_SETTINGS_PAGE_JOIN_CLICK;
        case 117:
          return CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK;
        case 116:
          return CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK;
        case 115:
          return CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK;
        case 114:
          return CIRCLE_SETTINGS_PAGE_INFO_CLICK;
        case 113:
          return CIRCLE_SETTINGS_PAGE_SHOW;
        case 112:
          return FIND_CIRCLE_NOTE_MINE_CLICK;
        case 111:
          return FIND_CIRCLE_RECOMMEND_MORE_CLICK;
        case 110:
          return FIND_CIRCLE_MINE_ALL_CLICK;
        case 109:
          return FLASH_PLAY_LIST_ONE_CLICK;
        case 108:
          return CITY_TOP_CLICK;
        case 107:
          return CITY_TOP_SHOW;
        case 106:
          return CIRCLE_JOIN_FEED_POP_CLICK;
        case 105:
          return CIRCLE_JOIN_FEED_POP_SHOW;
        case 104:
          return CIRCLE_FEED_CLICK;
        case 103:
          return MUTE_REMOVE_BTN_CLICK;
        case 102:
          return FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK;
        case 101:
          return FEED_PUBLISH_SUCCESS_POP_SHOW;
        case 100:
          return CIRCLE_USER_LIST_MANAGE_MUTE_USER_CLICK;
        case 99:
          return CIRCLE_USER_LIST_MANAGE_REMOVE_USER_TRUE_CLICK;
        case 98:
          return CIRCLE_USER_LIST_MANAGE_REMOVE_USER_CLICK;
        case 97:
          return CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_TRUE_CLICK;
        case 96:
          return CIRCLE_USER_LIST_MANAGE_REMOVE_VICE_CAPTAIN_CLICK;
        case 95:
          return CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_TRUE_CLICK;
        case 94:
          return CIRCLE_USER_LIST_MANAGE_ADD_VICE_CAPTAIN_CLICK;
        case 93:
          return CIRCLE_USER_LIST_MANAGE_CLICK;
        case 92:
          return MSG_NOTICE_CIRCLE_JOIN_USER_CLICK;
        case 91:
          return MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK;
        case 90:
          return MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK;
        case 89:
          return MSG_NOTICE_CIRCLE_CLICK;
        case 88:
          return CIRCLE_USER_MANAGE_INVITE_USER;
        case 87:
          return CIRCLE_USER_MANAGE_INVITE_CLICK;
        case 86:
          return CIRCLE_USER_MANAGE_SHOW;
        case 85:
          return CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK;
        case 84:
          return FEED_DYNAMIC_SKIN_SAVE_CLICK;
        case 83:
          return FEED_DYNAMIC_SKIN_CLICK;
        case 82:
          return FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK;
        case 81:
          return FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK;
        case 80:
          return SHARE_PASSWORD_POP_PASTE_CLICK;
        case 79:
          return SHARE_PASSWORD_POP_SHOW;
        case 78:
          return FEED_PHOTO_CLICK;
        case 77:
          return FLASH_SCREEN_COMPLETE_CLICK;
        case 76:
          return FEED_MULTI_IMAGE_CLICK;
        case 75:
          return CITY_SAY_HI_CLICK;
        case 74:
          return PLAZA_RECOMMEND_NOTE_SHARE_CLICK;
        case 73:
          return PLAZA_RECOMMEND_NOTE_COMMENT_CLICK;
        case 72:
          return PLAZA_RECOMMEND_NOTE_LIKE_CLICK;
        case 71:
          return MSG_NOTICE_DELETE_CLICK;
        case 70:
          return MSG_NOTICE_VOTE_CLICK;
        case 69:
          return MSG_NOTICE_LIKE_CLICK;
        case 68:
          return MSG_NOTICE_FOLLOW_CLICK;
        case 67:
          return MSG_NOTICE_COMMENT_REPLY;
        case 66:
          return MSG_NOTICE_COMMENT_CLICK;
        case 65:
          return MSG_NOTICE_COMMENT_SHOW;
        case 64:
          return CIRCLE_NOTE_ADD_PHOTO_CLICK;
        case 63:
          return CITY_LIVE_USER_SHOW;
        case 62:
          return CIRCLE_NOTE_VOTE_ICON_CLICK;
        case 61:
          return FIND_TOP_DROP_DOWN_CLICK;
        case 60:
          return PLAZA_RECOMMEND_FOLLOW_USER_CLICK;
        case 59:
          return CIRCLE_NOTE_COMMENT_IMAGE_CLICK;
        case 58:
          return CIRCLE_NOTE_MANAGE_BTN_CLICK;
        case 57:
          return CIRCLE_NOTE_MANAGE_SHOW;
        case 56:
          return CIRCLE_PUBLISH_BTN_CLICK;
        case 55:
          return CIRCLE_EXIT_BTN_CLICK;
        case 54:
          return CIRCLE_EXIT_BOX_SHOW;
        case 53:
          return CIRCLE_NOTE_COMMENT_GUIDE_CLICK;
        case 52:
          return CIRCLE_NOTE_COMMENT_GUIDE_SHOW;
        case 51:
          return CIRCLE_NOTE_COMMENT_DRAW;
        case 50:
          return CIRCLE_MORE_BTN_SHOW;
        case 49:
          return CIRCLE_NOTE_LIKE;
        case 48:
          return CIRCLE_NOTE_COMMENT;
        case 47:
          return CIRCLE_NOTE_DETAIL_SHOW;
        case 46:
          return CIRCLE_NOTE_DRAW;
        case 45:
          return CIRCLE_JOIN_BTN_CLICK;
        case 44:
          return CIRCLE_FIND_PAGE_SHOW;
        case 43:
          return CIRCLE_DETAIL_SHOW;
        case 42:
          return CIRCLE_DRAW;
        case 41:
          return FEED_DETAIL_COMMENT_MORE_CLICK;
        case 40:
          return FEED_DETAIL_COMMENT_MORE_SHOW;
        case 39:
          return FEED_DETAIL_COMMENT_DRAW;
        case 38:
          return LIVE_FIND_PLAZA_FOLLOW_ROOM_CLICK;
        case 37:
          return LIVE_FIND_PLAZA_FOLLOW_ROOM_SHOW;
        case 36:
          return FLASH_VIDEO_USER_LIVE_PHOTO_CLICK;
        case 35:
          return FEED_LIKE_GO_PLAZA_BTN_CLICK;
        case 34:
          return FLASH_PLAY_PAGE_SHOW;
        case 33:
          return FEED_LIKE_BTN_CLICK;
        case 32:
          return FEED_COMMENT_SEND_BTN_CLICK;
        case 31:
          return FEED_FORWARD_BTN_CLICK;
        case 30:
          return SHARE_TO_CLICK;
        case 29:
          return FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK;
        case 28:
          return FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW;
        case 26:
          return FEED_DRAW;
        case 25:
          return FEED_DETAIL_PAGE_SOURCE;
        case 24:
          return FEED_SUPER_TOPIC_ENTER_CLICK;
        case 23:
          return OTHER_FOLLOW_CLICK;
        case 22:
          return PLAZA_RECOMMEND_FOLLOW_USER_SHOW;
        case 21:
          return FEED_ADD_PHOTO;
        case 20:
          return SUPER_TOPIC_SEARCH_CREATE_BTN_CLICK;
        case 19:
          return FEED_COMMENT_BOX_CLICK;
        case 18:
          return FEED_INTERACTIVE;
        case 17:
          return FEED_COMMENT_LIST_USER_CLICK;
        case 16:
          return FEED_COMMENT_LIST_USER_SHOW;
        case 15:
          return FEED_DETAIL_PAGE_SHOW;
        case 14:
          return FEED_PUBLISH_BTN_CLICK;
        case 13:
          return SUPER_TOPIC_INTERACTIVE;
        case 12:
          return SUPER_TOPIC_DETAIL_INTERACTIVE;
        case 11:
          return SUPER_TOPIC_SEARCH_KEYWORD;
        case 10:
          return SUPER_TOPIC_SEARCH_SHOW;
        case 9:
          return SUPER_TOPIC_MINE_BTN_CLICK;
        case 8:
          return SUPER_TOPIC_DETAIL_FEED_DRAW;
        case 7:
          return SUPER_TOPIC_DETAIL_SHOW;
        case 6:
          return FEED_PUBLISH_CONFIRM_BTN_CLICK;
        case 5:
          return SUPER_TOPIC_CREATE_RETURN_BTN_CLICK;
        case 4:
          return SUPER_TOPIC_CREATE_NEXT_BTN_CLICK;
        case 3:
          return SUPER_TOPIC_CREATE_BTN_CLICK;
        case 2:
          return SUPER_TOPIC_DRAW;
        case 1:
          return FIND_PLAZA_BANNER_CLICK;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(0);
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
    public FeedProtos.Event findValueByNumber(int param1Int) {
      return FeedProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum FeedClass implements ProtocolMessageEnum {
    FEED_IMAGE(0),
    FEED_LIVE(0),
    FEED_VIDEO(0),
    FEED_VOTE(0),
    FEED_WORD(0),
    UNKNOWN_FEED_CLASS(0),
    UNRECOGNIZED(0);
    
    public static final int FEED_IMAGE_VALUE = 2;
    
    public static final int FEED_LIVE_VALUE = 5;
    
    public static final int FEED_VIDEO_VALUE = 3;
    
    public static final int FEED_VOTE_VALUE = 4;
    
    public static final int FEED_WORD_VALUE = 1;
    
    public static final int UNKNOWN_FEED_CLASS_VALUE = 0;
    
    private static final FeedClass[] VALUES;
    
    private static final Internal.EnumLiteMap<FeedClass> internalValueMap;
    
    private final int value;
    
    static {
      FEED_IMAGE = new FeedClass("FEED_IMAGE", 2, 2);
      FEED_VIDEO = new FeedClass("FEED_VIDEO", 3, 3);
      FEED_VOTE = new FeedClass("FEED_VOTE", 4, 4);
      FEED_LIVE = new FeedClass("FEED_LIVE", 5, 5);
      UNRECOGNIZED = new FeedClass("UNRECOGNIZED", 6, -1);
      $VALUES = new FeedClass[] { UNKNOWN_FEED_CLASS, FEED_WORD, FEED_IMAGE, FEED_VIDEO, FEED_VOTE, FEED_LIVE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedClass>() {
          public FeedProtos.FeedClass findValueByNumber(int param2Int) {
            return FeedProtos.FeedClass.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedClass(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedClass forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : FEED_LIVE) : FEED_VOTE) : FEED_VIDEO) : FEED_IMAGE) : FEED_WORD) : UNKNOWN_FEED_CLASS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(9);
    }
    
    public static Internal.EnumLiteMap<FeedClass> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeedClass> {
    public FeedProtos.FeedClass findValueByNumber(int param1Int) {
      return FeedProtos.FeedClass.forNumber(param1Int);
    }
  }
  
  public enum FeedFrom implements ProtocolMessageEnum {
    CIRCLE_DETAIL_POP(0),
    FLASH(0),
    FOLLOW(0),
    PERSONAL(0),
    PLAZA(0),
    PUBLISH_CIRCLE_NOTE(0),
    PUBLISH_FLASH_DETAIL(0),
    PUBLISH_PLAZA_IMAGE(0),
    PUBLISH_PLAZA_NEARBY(0),
    PUBLISH_PLAZA_RECOMMEND(0),
    SUPER_TOPIC_DETAIL(0),
    UNKNOWN_FEED_FROM(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_DETAIL_POP_VALUE = 11;
    
    public static final int FLASH_VALUE = 5;
    
    public static final int FOLLOW_VALUE = 4;
    
    public static final int PERSONAL_VALUE = 1;
    
    public static final int PLAZA_VALUE = 3;
    
    public static final int PUBLISH_CIRCLE_NOTE_VALUE = 10;
    
    public static final int PUBLISH_FLASH_DETAIL_VALUE = 9;
    
    public static final int PUBLISH_PLAZA_IMAGE_VALUE = 8;
    
    public static final int PUBLISH_PLAZA_NEARBY_VALUE = 7;
    
    public static final int PUBLISH_PLAZA_RECOMMEND_VALUE = 6;
    
    public static final int SUPER_TOPIC_DETAIL_VALUE = 2;
    
    public static final int UNKNOWN_FEED_FROM_VALUE = 0;
    
    private static final FeedFrom[] VALUES;
    
    private static final Internal.EnumLiteMap<FeedFrom> internalValueMap;
    
    private final int value;
    
    static {
      PLAZA = new FeedFrom("PLAZA", 3, 3);
      FOLLOW = new FeedFrom("FOLLOW", 4, 4);
      FLASH = new FeedFrom("FLASH", 5, 5);
      PUBLISH_PLAZA_RECOMMEND = new FeedFrom("PUBLISH_PLAZA_RECOMMEND", 6, 6);
      PUBLISH_PLAZA_NEARBY = new FeedFrom("PUBLISH_PLAZA_NEARBY", 7, 7);
      PUBLISH_PLAZA_IMAGE = new FeedFrom("PUBLISH_PLAZA_IMAGE", 8, 8);
      PUBLISH_FLASH_DETAIL = new FeedFrom("PUBLISH_FLASH_DETAIL", 9, 9);
      PUBLISH_CIRCLE_NOTE = new FeedFrom("PUBLISH_CIRCLE_NOTE", 10, 10);
      CIRCLE_DETAIL_POP = new FeedFrom("CIRCLE_DETAIL_POP", 11, 11);
      UNRECOGNIZED = new FeedFrom("UNRECOGNIZED", 12, -1);
      $VALUES = new FeedFrom[] { 
          UNKNOWN_FEED_FROM, PERSONAL, SUPER_TOPIC_DETAIL, PLAZA, FOLLOW, FLASH, PUBLISH_PLAZA_RECOMMEND, PUBLISH_PLAZA_NEARBY, PUBLISH_PLAZA_IMAGE, PUBLISH_FLASH_DETAIL, 
          PUBLISH_CIRCLE_NOTE, CIRCLE_DETAIL_POP, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedFrom>() {
          public FeedProtos.FeedFrom findValueByNumber(int param2Int) {
            return FeedProtos.FeedFrom.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedFrom(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedFrom forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 11:
          return CIRCLE_DETAIL_POP;
        case 10:
          return PUBLISH_CIRCLE_NOTE;
        case 9:
          return PUBLISH_FLASH_DETAIL;
        case 8:
          return PUBLISH_PLAZA_IMAGE;
        case 7:
          return PUBLISH_PLAZA_NEARBY;
        case 6:
          return PUBLISH_PLAZA_RECOMMEND;
        case 5:
          return FLASH;
        case 4:
          return FOLLOW;
        case 3:
          return PLAZA;
        case 2:
          return SUPER_TOPIC_DETAIL;
        case 1:
          return PERSONAL;
        case 0:
          break;
      } 
      return UNKNOWN_FEED_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<FeedFrom> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeedFrom> {
    public FeedProtos.FeedFrom findValueByNumber(int param1Int) {
      return FeedProtos.FeedFrom.forNumber(param1Int);
    }
  }
  
  public enum FeedFromPage implements ProtocolMessageEnum {
    FOLLOW_FROM(0),
    NEARBY_FROM(0),
    PERSONAL_FROM(0),
    PLAZA_FROM(0),
    SUPER_TOPIC_DETAIL_FROM(0),
    UNKNOWN_FEED_FROM_PAGE(0),
    UNRECOGNIZED(0);
    
    public static final int FOLLOW_FROM_VALUE = 4;
    
    public static final int NEARBY_FROM_VALUE = 5;
    
    public static final int PERSONAL_FROM_VALUE = 1;
    
    public static final int PLAZA_FROM_VALUE = 3;
    
    public static final int SUPER_TOPIC_DETAIL_FROM_VALUE = 2;
    
    public static final int UNKNOWN_FEED_FROM_PAGE_VALUE = 0;
    
    private static final FeedFromPage[] VALUES;
    
    private static final Internal.EnumLiteMap<FeedFromPage> internalValueMap;
    
    private final int value;
    
    static {
      PLAZA_FROM = new FeedFromPage("PLAZA_FROM", 3, 3);
      FOLLOW_FROM = new FeedFromPage("FOLLOW_FROM", 4, 4);
      NEARBY_FROM = new FeedFromPage("NEARBY_FROM", 5, 5);
      UNRECOGNIZED = new FeedFromPage("UNRECOGNIZED", 6, -1);
      $VALUES = new FeedFromPage[] { UNKNOWN_FEED_FROM_PAGE, PERSONAL_FROM, SUPER_TOPIC_DETAIL_FROM, PLAZA_FROM, FOLLOW_FROM, NEARBY_FROM, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedFromPage>() {
          public FeedProtos.FeedFromPage findValueByNumber(int param2Int) {
            return FeedProtos.FeedFromPage.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedFromPage(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedFromPage forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : NEARBY_FROM) : FOLLOW_FROM) : PLAZA_FROM) : SUPER_TOPIC_DETAIL_FROM) : PERSONAL_FROM) : UNKNOWN_FEED_FROM_PAGE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<FeedFromPage> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeedFromPage> {
    public FeedProtos.FeedFromPage findValueByNumber(int param1Int) {
      return FeedProtos.FeedFromPage.forNumber(param1Int);
    }
  }
  
  public enum FeedPage implements ProtocolMessageEnum {
    FEED_DETAIL_MORE(0),
    FEED_LIKE(0),
    FEED_MINE(0),
    FIND_TOPIC_HOME(0),
    FLASH_DETAIL(0),
    PERSONAL_FEED(0),
    PERSONAL_PHOTO(0),
    PLAZA_FLASH_LIST(0),
    PLAZA_FOLLOW(0),
    PLAZA_IMAGE(0),
    PLAZA_NEARBY(0),
    PLAZA_RECOMMEND(0),
    SUPER_TOPIC_FEED(0),
    UNKNOWN_FEED_PAGE(0),
    UNRECOGNIZED(0);
    
    public static final int FEED_DETAIL_MORE_VALUE = 11;
    
    public static final int FEED_LIKE_VALUE = 9;
    
    public static final int FEED_MINE_VALUE = 8;
    
    public static final int FIND_TOPIC_HOME_VALUE = 13;
    
    public static final int FLASH_DETAIL_VALUE = 4;
    
    public static final int PERSONAL_FEED_VALUE = 7;
    
    public static final int PERSONAL_PHOTO_VALUE = 12;
    
    public static final int PLAZA_FLASH_LIST_VALUE = 10;
    
    public static final int PLAZA_FOLLOW_VALUE = 2;
    
    public static final int PLAZA_IMAGE_VALUE = 5;
    
    public static final int PLAZA_NEARBY_VALUE = 3;
    
    public static final int PLAZA_RECOMMEND_VALUE = 1;
    
    public static final int SUPER_TOPIC_FEED_VALUE = 6;
    
    public static final int UNKNOWN_FEED_PAGE_VALUE = 0;
    
    private static final FeedPage[] VALUES;
    
    private static final Internal.EnumLiteMap<FeedPage> internalValueMap;
    
    private final int value;
    
    static {
      PLAZA_FOLLOW = new FeedPage("PLAZA_FOLLOW", 2, 2);
      PLAZA_NEARBY = new FeedPage("PLAZA_NEARBY", 3, 3);
      FLASH_DETAIL = new FeedPage("FLASH_DETAIL", 4, 4);
      PLAZA_IMAGE = new FeedPage("PLAZA_IMAGE", 5, 5);
      SUPER_TOPIC_FEED = new FeedPage("SUPER_TOPIC_FEED", 6, 6);
      PERSONAL_FEED = new FeedPage("PERSONAL_FEED", 7, 7);
      FEED_MINE = new FeedPage("FEED_MINE", 8, 8);
      FEED_LIKE = new FeedPage("FEED_LIKE", 9, 9);
      PLAZA_FLASH_LIST = new FeedPage("PLAZA_FLASH_LIST", 10, 10);
      FEED_DETAIL_MORE = new FeedPage("FEED_DETAIL_MORE", 11, 11);
      PERSONAL_PHOTO = new FeedPage("PERSONAL_PHOTO", 12, 12);
      FIND_TOPIC_HOME = new FeedPage("FIND_TOPIC_HOME", 13, 13);
      UNRECOGNIZED = new FeedPage("UNRECOGNIZED", 14, -1);
      $VALUES = new FeedPage[] { 
          UNKNOWN_FEED_PAGE, PLAZA_RECOMMEND, PLAZA_FOLLOW, PLAZA_NEARBY, FLASH_DETAIL, PLAZA_IMAGE, SUPER_TOPIC_FEED, PERSONAL_FEED, FEED_MINE, FEED_LIKE, 
          PLAZA_FLASH_LIST, FEED_DETAIL_MORE, PERSONAL_PHOTO, FIND_TOPIC_HOME, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedPage>() {
          public FeedProtos.FeedPage findValueByNumber(int param2Int) {
            return FeedProtos.FeedPage.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedPage(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedPage forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 13:
          return FIND_TOPIC_HOME;
        case 12:
          return PERSONAL_PHOTO;
        case 11:
          return FEED_DETAIL_MORE;
        case 10:
          return PLAZA_FLASH_LIST;
        case 9:
          return FEED_LIKE;
        case 8:
          return FEED_MINE;
        case 7:
          return PERSONAL_FEED;
        case 6:
          return SUPER_TOPIC_FEED;
        case 5:
          return PLAZA_IMAGE;
        case 4:
          return FLASH_DETAIL;
        case 3:
          return PLAZA_NEARBY;
        case 2:
          return PLAZA_FOLLOW;
        case 1:
          return PLAZA_RECOMMEND;
        case 0:
          break;
      } 
      return UNKNOWN_FEED_PAGE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(10);
    }
    
    public static Internal.EnumLiteMap<FeedPage> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeedPage> {
    public FeedProtos.FeedPage findValueByNumber(int param1Int) {
      return FeedProtos.FeedPage.forNumber(param1Int);
    }
  }
  
  public static final class FeedProto extends GeneratedMessageV3 implements FeedProtoOrBuilder {
    public static final int ADD_TYPE_FIELD_NUMBER = 12;
    
    public static final int CIRCLE_ID_FIELD_NUMBER = 25;
    
    public static final int CIRCLE_SOURCE_FIELD_NUMBER = 27;
    
    public static final int COMMENT_ID_FIELD_NUMBER = 24;
    
    private static final FeedProto DEFAULT_INSTANCE = new FeedProto();
    
    public static final int DETAIL_FROM_FIELD_NUMBER = 5;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FEED_CLASS_FIELD_NUMBER = 14;
    
    public static final int FEED_FROM_FIELD_NUMBER = 4;
    
    public static final int FEED_FROM_PAGE_FIELD_NUMBER = 8;
    
    public static final int FEED_ID_FIELD_NUMBER = 6;
    
    public static final int FEED_PAGE_FIELD_NUMBER = 15;
    
    public static final int FEED_TOPIC_PAGE_FIELD_NUMBER = 17;
    
    public static final int FEED_TYPE_FIELD_NUMBER = 3;
    
    public static final int FOLLOW_LOCATION_FIELD_NUMBER = 13;
    
    public static final int ICON_TYPE_FIELD_NUMBER = 58;
    
    public static final int ID_FIELD_NUMBER = 57;
    
    public static final int IMAGE_ID_FIELD_NUMBER = 43;
    
    public static final int INTERACTIVE_TYPE_FIELD_NUMBER = 9;
    
    public static final int IS_ANONYMOUS_COMMENT_FIELD_NUMBER = 45;
    
    public static final int IS_ANONYMOUS_PUBLISH_FIELD_NUMBER = 44;
    
    public static final int IS_APPLY_FIELD_NUMBER = 41;
    
    public static final int IS_AT_FIELD_NUMBER = 33;
    
    public static final int IS_CIRCLE_TOP_FIELD_NUMBER = 40;
    
    public static final int IS_COMMENT_FIELD_NUMBER = 48;
    
    public static final int IS_ESSENCE_FIELD_NUMBER = 53;
    
    public static final int IS_EXPOSURE_FIELD_NUMBER = 23;
    
    public static final int IS_FOLLOW_FIELD_NUMBER = 16;
    
    public static final int IS_INVITE_FIELD_NUMBER = 42;
    
    public static final int IS_JOIN_FIELD_NUMBER = 26;
    
    public static final int IS_LIKE_FIELD_NUMBER = 20;
    
    public static final int IS_LIVE_FIELD_NUMBER = 34;
    
    public static final int IS_MULTI_FIELD_NUMBER = 38;
    
    public static final int IS_TOP_FIELD_NUMBER = 29;
    
    public static final int KEYWORD_FIELD_NUMBER = 7;
    
    public static final int LINK_FROM_FIELD_NUMBER = 19;
    
    public static final int LINK_URL_FIELD_NUMBER = 32;
    
    public static final int LIVE_ID_FIELD_NUMBER = 21;
    
    public static final int LOCATION_FIELD_NUMBER = 11;
    
    public static final int MUSIC_ID_FIELD_NUMBER = 39;
    
    public static final int NOTE_FROM_FIELD_NUMBER = 36;
    
    public static final int NOTE_ID_FIELD_NUMBER = 28;
    
    public static final int NOTE_SOURCE_FIELD_NUMBER = 30;
    
    public static final int NOTE_TYPE_FIELD_NUMBER = 35;
    
    public static final int NUM_FIELD_NUMBER = 49;
    
    public static final int OPT_TYPE_FIELD_NUMBER = 31;
    
    private static final Parser<FeedProto> PARSER = (Parser<FeedProto>)new AbstractParser<FeedProto>() {
        public FeedProtos.FeedProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new FeedProtos.FeedProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int POSITION_FIELD_NUMBER = 51;
    
    public static final int RECOMMEND_TYPE_FIELD_NUMBER = 37;
    
    public static final int ROOM_ID_FIELD_NUMBER = 55;
    
    public static final int ROOM_UID_FIELD_NUMBER = 56;
    
    public static final int SHARE_CHANNEL_FIELD_NUMBER = 18;
    
    public static final int SOURCE_PAGE_FIELD_NUMBER = 22;
    
    public static final int TAB_ID_FIELD_NUMBER = 50;
    
    public static final int TAB_TYPE_FIELD_NUMBER = 54;
    
    public static final int TAG_SOURCE_FIELD_NUMBER = 52;
    
    public static final int TARGET_UID_FIELD_NUMBER = 10;
    
    public static final int TASK_ID_FIELD_NUMBER = 47;
    
    public static final int TOPIC_ID_FIELD_NUMBER = 2;
    
    public static final int USER_TYPE_FIELD_NUMBER = 46;
    
    private static final long serialVersionUID = 0L;
    
    private int addType_;
    
    private volatile Object circleId_;
    
    private int circleSource_;
    
    private volatile Object commentId_;
    
    private int detailFrom_;
    
    private int event_;
    
    private int feedClass_;
    
    private int feedFromPage_;
    
    private int feedFrom_;
    
    private volatile Object feedId_;
    
    private int feedPage_;
    
    private int feedTopicPage_;
    
    private int feedType_;
    
    private int followLocation_;
    
    private volatile Object iconType_;
    
    private volatile Object id_;
    
    private volatile Object imageId_;
    
    private int interactiveType_;
    
    private boolean isAnonymousComment_;
    
    private boolean isAnonymousPublish_;
    
    private boolean isApply_;
    
    private boolean isAt_;
    
    private boolean isCircleTop_;
    
    private boolean isComment_;
    
    private boolean isEssence_;
    
    private boolean isExposure_;
    
    private boolean isFollow_;
    
    private boolean isInvite_;
    
    private boolean isJoin_;
    
    private boolean isLike_;
    
    private boolean isLive_;
    
    private boolean isMulti_;
    
    private boolean isTop_;
    
    private volatile Object keyword_;
    
    private int linkFrom_;
    
    private volatile Object linkUrl_;
    
    private volatile Object liveId_;
    
    private int location_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object musicId_;
    
    private volatile Object noteFrom_;
    
    private volatile Object noteId_;
    
    private int noteSource_;
    
    private int noteType_;
    
    private int num_;
    
    private int optType_;
    
    private volatile Object position_;
    
    private volatile Object recommendType_;
    
    private volatile Object roomId_;
    
    private volatile Object roomUid_;
    
    private int shareChannel_;
    
    private int sourcePage_;
    
    private volatile Object tabId_;
    
    private int tabType_;
    
    private int tagSource_;
    
    private volatile Object targetUid_;
    
    private volatile Object taskId_;
    
    private volatile Object topicId_;
    
    private int userType_;
    
    private FeedProto() {
      this.event_ = 0;
      this.topicId_ = "";
      this.feedType_ = 0;
      this.feedFrom_ = 0;
      this.detailFrom_ = 0;
      this.feedId_ = "";
      this.keyword_ = "";
      this.feedFromPage_ = 0;
      this.interactiveType_ = 0;
      this.targetUid_ = "";
      this.location_ = 0;
      this.addType_ = 0;
      this.followLocation_ = 0;
      this.feedClass_ = 0;
      this.feedPage_ = 0;
      this.feedTopicPage_ = 0;
      this.shareChannel_ = 0;
      this.linkFrom_ = 0;
      this.liveId_ = "";
      this.sourcePage_ = 0;
      this.commentId_ = "";
      this.circleId_ = "";
      this.circleSource_ = 0;
      this.noteId_ = "";
      this.noteSource_ = 0;
      this.optType_ = 0;
      this.linkUrl_ = "";
      this.noteType_ = 0;
      this.noteFrom_ = "";
      this.recommendType_ = "";
      this.musicId_ = "";
      this.imageId_ = "";
      this.userType_ = 0;
      this.taskId_ = "";
      this.tabId_ = "";
      this.position_ = "";
      this.tagSource_ = 0;
      this.tabType_ = 0;
      this.roomId_ = "";
      this.roomUid_ = "";
      this.id_ = "";
      this.iconType_ = "";
    }
    
    private FeedProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 466:
                this.iconType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 458:
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 450:
                this.roomUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 442:
                this.roomId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 432:
                this.tabType_ = param1CodedInputStream.readEnum();
                continue;
              case 424:
                this.isEssence_ = param1CodedInputStream.readBool();
                continue;
              case 416:
                this.tagSource_ = param1CodedInputStream.readEnum();
                continue;
              case 410:
                this.position_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 402:
                this.tabId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 392:
                this.num_ = param1CodedInputStream.readInt32();
                continue;
              case 384:
                this.isComment_ = param1CodedInputStream.readBool();
                continue;
              case 378:
                this.taskId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 368:
                this.userType_ = param1CodedInputStream.readEnum();
                continue;
              case 360:
                this.isAnonymousComment_ = param1CodedInputStream.readBool();
                continue;
              case 352:
                this.isAnonymousPublish_ = param1CodedInputStream.readBool();
                continue;
              case 346:
                this.imageId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 336:
                this.isInvite_ = param1CodedInputStream.readBool();
                continue;
              case 328:
                this.isApply_ = param1CodedInputStream.readBool();
                continue;
              case 320:
                this.isCircleTop_ = param1CodedInputStream.readBool();
                continue;
              case 314:
                this.musicId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 304:
                this.isMulti_ = param1CodedInputStream.readBool();
                continue;
              case 298:
                this.recommendType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 290:
                this.noteFrom_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 280:
                this.noteType_ = param1CodedInputStream.readEnum();
                continue;
              case 272:
                this.isLive_ = param1CodedInputStream.readBool();
                continue;
              case 264:
                this.isAt_ = param1CodedInputStream.readBool();
                continue;
              case 258:
                this.linkUrl_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 248:
                this.optType_ = param1CodedInputStream.readEnum();
                continue;
              case 240:
                this.noteSource_ = param1CodedInputStream.readEnum();
                continue;
              case 232:
                this.isTop_ = param1CodedInputStream.readBool();
                continue;
              case 226:
                this.noteId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 216:
                this.circleSource_ = param1CodedInputStream.readEnum();
                continue;
              case 208:
                this.isJoin_ = param1CodedInputStream.readBool();
                continue;
              case 202:
                this.circleId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 194:
                this.commentId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 184:
                this.isExposure_ = param1CodedInputStream.readBool();
                continue;
              case 176:
                this.sourcePage_ = param1CodedInputStream.readEnum();
                continue;
              case 170:
                this.liveId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 160:
                this.isLike_ = param1CodedInputStream.readBool();
                continue;
              case 152:
                this.linkFrom_ = param1CodedInputStream.readEnum();
                continue;
              case 144:
                this.shareChannel_ = param1CodedInputStream.readEnum();
                continue;
              case 136:
                this.feedTopicPage_ = param1CodedInputStream.readEnum();
                continue;
              case 128:
                this.isFollow_ = param1CodedInputStream.readBool();
                continue;
              case 120:
                this.feedPage_ = param1CodedInputStream.readEnum();
                continue;
              case 112:
                this.feedClass_ = param1CodedInputStream.readEnum();
                continue;
              case 104:
                this.followLocation_ = param1CodedInputStream.readEnum();
                continue;
              case 96:
                this.addType_ = param1CodedInputStream.readEnum();
                continue;
              case 88:
                this.location_ = param1CodedInputStream.readEnum();
                continue;
              case 82:
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 72:
                this.interactiveType_ = param1CodedInputStream.readEnum();
                continue;
              case 64:
                this.feedFromPage_ = param1CodedInputStream.readEnum();
                continue;
              case 58:
                this.keyword_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 50:
                this.feedId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 40:
                this.detailFrom_ = param1CodedInputStream.readEnum();
                continue;
              case 32:
                this.feedFrom_ = param1CodedInputStream.readEnum();
                continue;
              case 24:
                this.feedType_ = param1CodedInputStream.readEnum();
                continue;
              case 18:
                this.topicId_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private FeedProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static FeedProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FeedProto param1FeedProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1FeedProto);
    }
    
    public static FeedProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FeedProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static FeedProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FeedProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FeedProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FeedProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static FeedProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FeedProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FeedProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FeedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static FeedProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FeedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FeedProto parseFrom(InputStream param1InputStream) throws IOException {
      return (FeedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static FeedProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FeedProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FeedProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (FeedProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static FeedProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FeedProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static FeedProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FeedProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static FeedProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FeedProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FeedProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof FeedProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((FeedProto)param1Object).event_) ? false : (!getTopicId().equals(param1Object.getTopicId()) ? false : ((this.feedType_ != ((FeedProto)param1Object).feedType_) ? false : ((this.feedFrom_ != ((FeedProto)param1Object).feedFrom_) ? false : ((this.detailFrom_ != ((FeedProto)param1Object).detailFrom_) ? false : (!getFeedId().equals(param1Object.getFeedId()) ? false : (!getKeyword().equals(param1Object.getKeyword()) ? false : ((this.feedFromPage_ != ((FeedProto)param1Object).feedFromPage_) ? false : ((this.interactiveType_ != ((FeedProto)param1Object).interactiveType_) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : ((this.location_ != ((FeedProto)param1Object).location_) ? false : ((this.addType_ != ((FeedProto)param1Object).addType_) ? false : ((this.followLocation_ != ((FeedProto)param1Object).followLocation_) ? false : ((this.feedClass_ != ((FeedProto)param1Object).feedClass_) ? false : ((this.feedPage_ != ((FeedProto)param1Object).feedPage_) ? false : ((getIsFollow() != param1Object.getIsFollow()) ? false : ((this.feedTopicPage_ != ((FeedProto)param1Object).feedTopicPage_) ? false : ((this.shareChannel_ != ((FeedProto)param1Object).shareChannel_) ? false : ((this.linkFrom_ != ((FeedProto)param1Object).linkFrom_) ? false : ((getIsLike() != param1Object.getIsLike()) ? false : (!getLiveId().equals(param1Object.getLiveId()) ? false : ((this.sourcePage_ != ((FeedProto)param1Object).sourcePage_) ? false : ((getIsExposure() != param1Object.getIsExposure()) ? false : (!getCommentId().equals(param1Object.getCommentId()) ? false : (!getCircleId().equals(param1Object.getCircleId()) ? false : ((getIsJoin() != param1Object.getIsJoin()) ? false : ((this.circleSource_ != ((FeedProto)param1Object).circleSource_) ? false : (!getNoteId().equals(param1Object.getNoteId()) ? false : ((getIsTop() != param1Object.getIsTop()) ? false : ((this.noteSource_ != ((FeedProto)param1Object).noteSource_) ? false : ((this.optType_ != ((FeedProto)param1Object).optType_) ? false : (!getLinkUrl().equals(param1Object.getLinkUrl()) ? false : ((getIsAt() != param1Object.getIsAt()) ? false : ((getIsLive() != param1Object.getIsLive()) ? false : ((this.noteType_ != ((FeedProto)param1Object).noteType_) ? false : (!getNoteFrom().equals(param1Object.getNoteFrom()) ? false : (!getRecommendType().equals(param1Object.getRecommendType()) ? false : ((getIsMulti() != param1Object.getIsMulti()) ? false : (!getMusicId().equals(param1Object.getMusicId()) ? false : ((getIsCircleTop() != param1Object.getIsCircleTop()) ? false : ((getIsApply() != param1Object.getIsApply()) ? false : ((getIsInvite() != param1Object.getIsInvite()) ? false : (!getImageId().equals(param1Object.getImageId()) ? false : ((getIsAnonymousPublish() != param1Object.getIsAnonymousPublish()) ? false : ((getIsAnonymousComment() != param1Object.getIsAnonymousComment()) ? false : ((this.userType_ != ((FeedProto)param1Object).userType_) ? false : (!getTaskId().equals(param1Object.getTaskId()) ? false : ((getIsComment() != param1Object.getIsComment()) ? false : ((getNum() != param1Object.getNum()) ? false : (!getTabId().equals(param1Object.getTabId()) ? false : (!getPosition().equals(param1Object.getPosition()) ? false : ((this.tagSource_ != ((FeedProto)param1Object).tagSource_) ? false : ((getIsEssence() != param1Object.getIsEssence()) ? false : ((this.tabType_ != ((FeedProto)param1Object).tabType_) ? false : (!getRoomId().equals(param1Object.getRoomId()) ? false : (!getRoomUid().equals(param1Object.getRoomUid()) ? false : (!getId().equals(param1Object.getId()) ? false : (!getIconType().equals(param1Object.getIconType()) ? false : (!!this.unknownFields.equals(((FeedProto)param1Object).unknownFields)))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
    }
    
    public FeedProtos.AddType getAddType() {
      FeedProtos.AddType addType2 = FeedProtos.AddType.valueOf(this.addType_);
      FeedProtos.AddType addType1 = addType2;
      if (addType2 == null)
        addType1 = FeedProtos.AddType.UNRECOGNIZED; 
      return addType1;
    }
    
    public int getAddTypeValue() {
      return this.addType_;
    }
    
    public String getCircleId() {
      Object object = this.circleId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.circleId_ = object;
      return (String)object;
    }
    
    public ByteString getCircleIdBytes() {
      Object object = this.circleId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.circleId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProtos.CircleSource getCircleSource() {
      FeedProtos.CircleSource circleSource2 = FeedProtos.CircleSource.valueOf(this.circleSource_);
      FeedProtos.CircleSource circleSource1 = circleSource2;
      if (circleSource2 == null)
        circleSource1 = FeedProtos.CircleSource.UNRECOGNIZED; 
      return circleSource1;
    }
    
    public int getCircleSourceValue() {
      return this.circleSource_;
    }
    
    public String getCommentId() {
      Object object = this.commentId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.commentId_ = object;
      return (String)object;
    }
    
    public ByteString getCommentIdBytes() {
      Object object = this.commentId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.commentId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public FeedProtos.DetailFrom getDetailFrom() {
      FeedProtos.DetailFrom detailFrom2 = FeedProtos.DetailFrom.valueOf(this.detailFrom_);
      FeedProtos.DetailFrom detailFrom1 = detailFrom2;
      if (detailFrom2 == null)
        detailFrom1 = FeedProtos.DetailFrom.UNRECOGNIZED; 
      return detailFrom1;
    }
    
    public int getDetailFromValue() {
      return this.detailFrom_;
    }
    
    public FeedProtos.Event getEvent() {
      FeedProtos.Event event2 = FeedProtos.Event.valueOf(this.event_);
      FeedProtos.Event event1 = event2;
      if (event2 == null)
        event1 = FeedProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public FeedProtos.FeedClass getFeedClass() {
      FeedProtos.FeedClass feedClass2 = FeedProtos.FeedClass.valueOf(this.feedClass_);
      FeedProtos.FeedClass feedClass1 = feedClass2;
      if (feedClass2 == null)
        feedClass1 = FeedProtos.FeedClass.UNRECOGNIZED; 
      return feedClass1;
    }
    
    public int getFeedClassValue() {
      return this.feedClass_;
    }
    
    public FeedProtos.FeedFrom getFeedFrom() {
      FeedProtos.FeedFrom feedFrom2 = FeedProtos.FeedFrom.valueOf(this.feedFrom_);
      FeedProtos.FeedFrom feedFrom1 = feedFrom2;
      if (feedFrom2 == null)
        feedFrom1 = FeedProtos.FeedFrom.UNRECOGNIZED; 
      return feedFrom1;
    }
    
    public FeedProtos.FeedFromPage getFeedFromPage() {
      FeedProtos.FeedFromPage feedFromPage2 = FeedProtos.FeedFromPage.valueOf(this.feedFromPage_);
      FeedProtos.FeedFromPage feedFromPage1 = feedFromPage2;
      if (feedFromPage2 == null)
        feedFromPage1 = FeedProtos.FeedFromPage.UNRECOGNIZED; 
      return feedFromPage1;
    }
    
    public int getFeedFromPageValue() {
      return this.feedFromPage_;
    }
    
    public int getFeedFromValue() {
      return this.feedFrom_;
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
    
    public FeedProtos.FeedPage getFeedPage() {
      FeedProtos.FeedPage feedPage2 = FeedProtos.FeedPage.valueOf(this.feedPage_);
      FeedProtos.FeedPage feedPage1 = feedPage2;
      if (feedPage2 == null)
        feedPage1 = FeedProtos.FeedPage.UNRECOGNIZED; 
      return feedPage1;
    }
    
    public int getFeedPageValue() {
      return this.feedPage_;
    }
    
    public FeedProtos.FeedTopicPage getFeedTopicPage() {
      FeedProtos.FeedTopicPage feedTopicPage2 = FeedProtos.FeedTopicPage.valueOf(this.feedTopicPage_);
      FeedProtos.FeedTopicPage feedTopicPage1 = feedTopicPage2;
      if (feedTopicPage2 == null)
        feedTopicPage1 = FeedProtos.FeedTopicPage.UNRECOGNIZED; 
      return feedTopicPage1;
    }
    
    public int getFeedTopicPageValue() {
      return this.feedTopicPage_;
    }
    
    public FeedProtos.FeedType getFeedType() {
      FeedProtos.FeedType feedType2 = FeedProtos.FeedType.valueOf(this.feedType_);
      FeedProtos.FeedType feedType1 = feedType2;
      if (feedType2 == null)
        feedType1 = FeedProtos.FeedType.UNRECOGNIZED; 
      return feedType1;
    }
    
    public int getFeedTypeValue() {
      return this.feedType_;
    }
    
    public FeedProtos.FollowLocation getFollowLocation() {
      FeedProtos.FollowLocation followLocation2 = FeedProtos.FollowLocation.valueOf(this.followLocation_);
      FeedProtos.FollowLocation followLocation1 = followLocation2;
      if (followLocation2 == null)
        followLocation1 = FeedProtos.FollowLocation.UNRECOGNIZED; 
      return followLocation1;
    }
    
    public int getFollowLocationValue() {
      return this.followLocation_;
    }
    
    public String getIconType() {
      Object object = this.iconType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.iconType_ = object;
      return (String)object;
    }
    
    public ByteString getIconTypeBytes() {
      Object object = this.iconType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.iconType_ = object;
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
    
    public FeedProtos.InteractiveType getInteractiveType() {
      FeedProtos.InteractiveType interactiveType2 = FeedProtos.InteractiveType.valueOf(this.interactiveType_);
      FeedProtos.InteractiveType interactiveType1 = interactiveType2;
      if (interactiveType2 == null)
        interactiveType1 = FeedProtos.InteractiveType.UNRECOGNIZED; 
      return interactiveType1;
    }
    
    public int getInteractiveTypeValue() {
      return this.interactiveType_;
    }
    
    public boolean getIsAnonymousComment() {
      return this.isAnonymousComment_;
    }
    
    public boolean getIsAnonymousPublish() {
      return this.isAnonymousPublish_;
    }
    
    public boolean getIsApply() {
      return this.isApply_;
    }
    
    public boolean getIsAt() {
      return this.isAt_;
    }
    
    public boolean getIsCircleTop() {
      return this.isCircleTop_;
    }
    
    public boolean getIsComment() {
      return this.isComment_;
    }
    
    public boolean getIsEssence() {
      return this.isEssence_;
    }
    
    public boolean getIsExposure() {
      return this.isExposure_;
    }
    
    public boolean getIsFollow() {
      return this.isFollow_;
    }
    
    public boolean getIsInvite() {
      return this.isInvite_;
    }
    
    public boolean getIsJoin() {
      return this.isJoin_;
    }
    
    public boolean getIsLike() {
      return this.isLike_;
    }
    
    public boolean getIsLive() {
      return this.isLive_;
    }
    
    public boolean getIsMulti() {
      return this.isMulti_;
    }
    
    public boolean getIsTop() {
      return this.isTop_;
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
    
    public FeedProtos.LinkFrom getLinkFrom() {
      FeedProtos.LinkFrom linkFrom2 = FeedProtos.LinkFrom.valueOf(this.linkFrom_);
      FeedProtos.LinkFrom linkFrom1 = linkFrom2;
      if (linkFrom2 == null)
        linkFrom1 = FeedProtos.LinkFrom.UNRECOGNIZED; 
      return linkFrom1;
    }
    
    public int getLinkFromValue() {
      return this.linkFrom_;
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
    
    public FeedProtos.Location getLocation() {
      FeedProtos.Location location2 = FeedProtos.Location.valueOf(this.location_);
      FeedProtos.Location location1 = location2;
      if (location2 == null)
        location1 = FeedProtos.Location.UNRECOGNIZED; 
      return location1;
    }
    
    public int getLocationValue() {
      return this.location_;
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
    
    public String getNoteFrom() {
      Object object = this.noteFrom_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.noteFrom_ = object;
      return (String)object;
    }
    
    public ByteString getNoteFromBytes() {
      Object object = this.noteFrom_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.noteFrom_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNoteId() {
      Object object = this.noteId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.noteId_ = object;
      return (String)object;
    }
    
    public ByteString getNoteIdBytes() {
      Object object = this.noteId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.noteId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProtos.NoteSource getNoteSource() {
      FeedProtos.NoteSource noteSource2 = FeedProtos.NoteSource.valueOf(this.noteSource_);
      FeedProtos.NoteSource noteSource1 = noteSource2;
      if (noteSource2 == null)
        noteSource1 = FeedProtos.NoteSource.UNRECOGNIZED; 
      return noteSource1;
    }
    
    public int getNoteSourceValue() {
      return this.noteSource_;
    }
    
    public FeedProtos.NoteType getNoteType() {
      FeedProtos.NoteType noteType2 = FeedProtos.NoteType.valueOf(this.noteType_);
      FeedProtos.NoteType noteType1 = noteType2;
      if (noteType2 == null)
        noteType1 = FeedProtos.NoteType.UNRECOGNIZED; 
      return noteType1;
    }
    
    public int getNoteTypeValue() {
      return this.noteType_;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public FeedProtos.OptType getOptType() {
      FeedProtos.OptType optType2 = FeedProtos.OptType.valueOf(this.optType_);
      FeedProtos.OptType optType1 = optType2;
      if (optType2 == null)
        optType1 = FeedProtos.OptType.UNRECOGNIZED; 
      return optType1;
    }
    
    public int getOptTypeValue() {
      return this.optType_;
    }
    
    public Parser<FeedProto> getParserForType() {
      return PARSER;
    }
    
    public String getPosition() {
      Object object = this.position_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.position_ = object;
      return (String)object;
    }
    
    public ByteString getPositionBytes() {
      Object object = this.position_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.position_ = object;
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
      if (this.event_ != FeedProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (!getTopicIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.topicId_); 
      j = i;
      if (this.feedType_ != FeedProtos.FeedType.UNKNOWN_FEED_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.feedType_); 
      i = j;
      if (this.feedFrom_ != FeedProtos.FeedFrom.UNKNOWN_FEED_FROM.getNumber())
        i = j + CodedOutputStream.computeEnumSize(4, this.feedFrom_); 
      j = i;
      if (this.detailFrom_ != FeedProtos.DetailFrom.UNKNOWN_DETAIL_FROM.getNumber())
        j = i + CodedOutputStream.computeEnumSize(5, this.detailFrom_); 
      i = j;
      if (!getFeedIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(6, this.feedId_); 
      j = i;
      if (!getKeywordBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(7, this.keyword_); 
      i = j;
      if (this.feedFromPage_ != FeedProtos.FeedFromPage.UNKNOWN_FEED_FROM_PAGE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(8, this.feedFromPage_); 
      j = i;
      if (this.interactiveType_ != FeedProtos.InteractiveType.UNKNOWN_INTERACTIVE_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(9, this.interactiveType_); 
      i = j;
      if (!getTargetUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(10, this.targetUid_); 
      j = i;
      if (this.location_ != FeedProtos.Location.UNKNOWN_LOCATION.getNumber())
        j = i + CodedOutputStream.computeEnumSize(11, this.location_); 
      i = j;
      if (this.addType_ != FeedProtos.AddType.UNKNOWN_ADD_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(12, this.addType_); 
      j = i;
      if (this.followLocation_ != FeedProtos.FollowLocation.UNKNOWN_FOLLOW_LOCATION.getNumber())
        j = i + CodedOutputStream.computeEnumSize(13, this.followLocation_); 
      i = j;
      if (this.feedClass_ != FeedProtos.FeedClass.UNKNOWN_FEED_CLASS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(14, this.feedClass_); 
      j = i;
      if (this.feedPage_ != FeedProtos.FeedPage.UNKNOWN_FEED_PAGE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(15, this.feedPage_); 
      boolean bool = this.isFollow_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(16, bool); 
      j = i;
      if (this.feedTopicPage_ != FeedProtos.FeedTopicPage.UNKNOWN_FEED_TOPIC_PAGE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(17, this.feedTopicPage_); 
      i = j;
      if (this.shareChannel_ != FeedProtos.ShareChannel.UNKNOWN_SHARE_CHANNEL.getNumber())
        i = j + CodedOutputStream.computeEnumSize(18, this.shareChannel_); 
      j = i;
      if (this.linkFrom_ != FeedProtos.LinkFrom.UNKNOWN_LINK_FROM.getNumber())
        j = i + CodedOutputStream.computeEnumSize(19, this.linkFrom_); 
      bool = this.isLike_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(20, bool); 
      j = i;
      if (!getLiveIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(21, this.liveId_); 
      i = j;
      if (this.sourcePage_ != FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(22, this.sourcePage_); 
      bool = this.isExposure_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(23, bool); 
      i = j;
      if (!getCommentIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(24, this.commentId_); 
      j = i;
      if (!getCircleIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(25, this.circleId_); 
      bool = this.isJoin_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(26, bool); 
      j = i;
      if (this.circleSource_ != FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(27, this.circleSource_); 
      i = j;
      if (!getNoteIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(28, this.noteId_); 
      bool = this.isTop_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(29, bool); 
      i = j;
      if (this.noteSource_ != FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(30, this.noteSource_); 
      j = i;
      if (this.optType_ != FeedProtos.OptType.UNKNOWN_OPT_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(31, this.optType_); 
      i = j;
      if (!getLinkUrlBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(32, this.linkUrl_); 
      bool = this.isAt_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(33, bool); 
      bool = this.isLive_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(34, bool); 
      j = i;
      if (this.noteType_ != FeedProtos.NoteType.UNKNOWN_NOTE_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(35, this.noteType_); 
      i = j;
      if (!getNoteFromBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(36, this.noteFrom_); 
      j = i;
      if (!getRecommendTypeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(37, this.recommendType_); 
      bool = this.isMulti_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(38, bool); 
      j = i;
      if (!getMusicIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(39, this.musicId_); 
      bool = this.isCircleTop_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(40, bool); 
      bool = this.isApply_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(41, bool); 
      bool = this.isInvite_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(42, bool); 
      j = i;
      if (!getImageIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(43, this.imageId_); 
      bool = this.isAnonymousPublish_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(44, bool); 
      bool = this.isAnonymousComment_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(45, bool); 
      i = j;
      if (this.userType_ != FeedProtos.UserType.UNKNOWN_USER_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(46, this.userType_); 
      j = i;
      if (!getTaskIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(47, this.taskId_); 
      bool = this.isComment_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(48, bool); 
      int k = this.num_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(49, k); 
      i = j;
      if (!getTabIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(50, this.tabId_); 
      j = i;
      if (!getPositionBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(51, this.position_); 
      i = j;
      if (this.tagSource_ != FeedProtos.TagSource.UNKNOWN_TAG_SOURCE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(52, this.tagSource_); 
      bool = this.isEssence_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(53, bool); 
      i = j;
      if (this.tabType_ != FeedProtos.TabType.UNKNOWN_TAB_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(54, this.tabType_); 
      j = i;
      if (!getRoomIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(55, this.roomId_); 
      i = j;
      if (!getRoomUidBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(56, this.roomUid_); 
      j = i;
      if (!getIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(57, this.id_); 
      i = j;
      if (!getIconTypeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(58, this.iconType_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public FeedProtos.ShareChannel getShareChannel() {
      FeedProtos.ShareChannel shareChannel2 = FeedProtos.ShareChannel.valueOf(this.shareChannel_);
      FeedProtos.ShareChannel shareChannel1 = shareChannel2;
      if (shareChannel2 == null)
        shareChannel1 = FeedProtos.ShareChannel.UNRECOGNIZED; 
      return shareChannel1;
    }
    
    public int getShareChannelValue() {
      return this.shareChannel_;
    }
    
    public FeedProtos.SourcePage getSourcePage() {
      FeedProtos.SourcePage sourcePage2 = FeedProtos.SourcePage.valueOf(this.sourcePage_);
      FeedProtos.SourcePage sourcePage1 = sourcePage2;
      if (sourcePage2 == null)
        sourcePage1 = FeedProtos.SourcePage.UNRECOGNIZED; 
      return sourcePage1;
    }
    
    public int getSourcePageValue() {
      return this.sourcePage_;
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
    
    public FeedProtos.TabType getTabType() {
      FeedProtos.TabType tabType2 = FeedProtos.TabType.valueOf(this.tabType_);
      FeedProtos.TabType tabType1 = tabType2;
      if (tabType2 == null)
        tabType1 = FeedProtos.TabType.UNRECOGNIZED; 
      return tabType1;
    }
    
    public int getTabTypeValue() {
      return this.tabType_;
    }
    
    public FeedProtos.TagSource getTagSource() {
      FeedProtos.TagSource tagSource2 = FeedProtos.TagSource.valueOf(this.tagSource_);
      FeedProtos.TagSource tagSource1 = tagSource2;
      if (tagSource2 == null)
        tagSource1 = FeedProtos.TagSource.UNRECOGNIZED; 
      return tagSource1;
    }
    
    public int getTagSourceValue() {
      return this.tagSource_;
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
    
    public String getTopicId() {
      Object object = this.topicId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.topicId_ = object;
      return (String)object;
    }
    
    public ByteString getTopicIdBytes() {
      Object object = this.topicId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.topicId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public FeedProtos.UserType getUserType() {
      FeedProtos.UserType userType2 = FeedProtos.UserType.valueOf(this.userType_);
      FeedProtos.UserType userType1 = userType2;
      if (userType2 == null)
        userType1 = FeedProtos.UserType.UNRECOGNIZED; 
      return userType1;
    }
    
    public int getUserTypeValue() {
      return this.userType_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getTopicId().hashCode()) * 37 + 3) * 53 + this.feedType_) * 37 + 4) * 53 + this.feedFrom_) * 37 + 5) * 53 + this.detailFrom_) * 37 + 6) * 53 + getFeedId().hashCode()) * 37 + 7) * 53 + getKeyword().hashCode()) * 37 + 8) * 53 + this.feedFromPage_) * 37 + 9) * 53 + this.interactiveType_) * 37 + 10) * 53 + getTargetUid().hashCode()) * 37 + 11) * 53 + this.location_) * 37 + 12) * 53 + this.addType_) * 37 + 13) * 53 + this.followLocation_) * 37 + 14) * 53 + this.feedClass_) * 37 + 15) * 53 + this.feedPage_) * 37 + 16) * 53 + Internal.hashBoolean(getIsFollow())) * 37 + 17) * 53 + this.feedTopicPage_) * 37 + 18) * 53 + this.shareChannel_) * 37 + 19) * 53 + this.linkFrom_) * 37 + 20) * 53 + Internal.hashBoolean(getIsLike())) * 37 + 21) * 53 + getLiveId().hashCode()) * 37 + 22) * 53 + this.sourcePage_) * 37 + 23) * 53 + Internal.hashBoolean(getIsExposure())) * 37 + 24) * 53 + getCommentId().hashCode()) * 37 + 25) * 53 + getCircleId().hashCode()) * 37 + 26) * 53 + Internal.hashBoolean(getIsJoin())) * 37 + 27) * 53 + this.circleSource_) * 37 + 28) * 53 + getNoteId().hashCode()) * 37 + 29) * 53 + Internal.hashBoolean(getIsTop())) * 37 + 30) * 53 + this.noteSource_) * 37 + 31) * 53 + this.optType_) * 37 + 32) * 53 + getLinkUrl().hashCode()) * 37 + 33) * 53 + Internal.hashBoolean(getIsAt())) * 37 + 34) * 53 + Internal.hashBoolean(getIsLive())) * 37 + 35) * 53 + this.noteType_) * 37 + 36) * 53 + getNoteFrom().hashCode()) * 37 + 37) * 53 + getRecommendType().hashCode()) * 37 + 38) * 53 + Internal.hashBoolean(getIsMulti())) * 37 + 39) * 53 + getMusicId().hashCode()) * 37 + 40) * 53 + Internal.hashBoolean(getIsCircleTop())) * 37 + 41) * 53 + Internal.hashBoolean(getIsApply())) * 37 + 42) * 53 + Internal.hashBoolean(getIsInvite())) * 37 + 43) * 53 + getImageId().hashCode()) * 37 + 44) * 53 + Internal.hashBoolean(getIsAnonymousPublish())) * 37 + 45) * 53 + Internal.hashBoolean(getIsAnonymousComment())) * 37 + 46) * 53 + this.userType_) * 37 + 47) * 53 + getTaskId().hashCode()) * 37 + 48) * 53 + Internal.hashBoolean(getIsComment())) * 37 + 49) * 53 + getNum()) * 37 + 50) * 53 + getTabId().hashCode()) * 37 + 51) * 53 + getPosition().hashCode()) * 37 + 52) * 53 + this.tagSource_) * 37 + 53) * 53 + Internal.hashBoolean(getIsEssence())) * 37 + 54) * 53 + this.tabType_) * 37 + 55) * 53 + getRoomId().hashCode()) * 37 + 56) * 53 + getRoomUid().hashCode()) * 37 + 57) * 53 + getId().hashCode()) * 37 + 58) * 53 + getIconType().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FeedProto.class, Builder.class);
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
      return new FeedProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != FeedProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getTopicIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.topicId_); 
      if (this.feedType_ != FeedProtos.FeedType.UNKNOWN_FEED_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.feedType_); 
      if (this.feedFrom_ != FeedProtos.FeedFrom.UNKNOWN_FEED_FROM.getNumber())
        param1CodedOutputStream.writeEnum(4, this.feedFrom_); 
      if (this.detailFrom_ != FeedProtos.DetailFrom.UNKNOWN_DETAIL_FROM.getNumber())
        param1CodedOutputStream.writeEnum(5, this.detailFrom_); 
      if (!getFeedIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.feedId_); 
      if (!getKeywordBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 7, this.keyword_); 
      if (this.feedFromPage_ != FeedProtos.FeedFromPage.UNKNOWN_FEED_FROM_PAGE.getNumber())
        param1CodedOutputStream.writeEnum(8, this.feedFromPage_); 
      if (this.interactiveType_ != FeedProtos.InteractiveType.UNKNOWN_INTERACTIVE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(9, this.interactiveType_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 10, this.targetUid_); 
      if (this.location_ != FeedProtos.Location.UNKNOWN_LOCATION.getNumber())
        param1CodedOutputStream.writeEnum(11, this.location_); 
      if (this.addType_ != FeedProtos.AddType.UNKNOWN_ADD_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(12, this.addType_); 
      if (this.followLocation_ != FeedProtos.FollowLocation.UNKNOWN_FOLLOW_LOCATION.getNumber())
        param1CodedOutputStream.writeEnum(13, this.followLocation_); 
      if (this.feedClass_ != FeedProtos.FeedClass.UNKNOWN_FEED_CLASS.getNumber())
        param1CodedOutputStream.writeEnum(14, this.feedClass_); 
      if (this.feedPage_ != FeedProtos.FeedPage.UNKNOWN_FEED_PAGE.getNumber())
        param1CodedOutputStream.writeEnum(15, this.feedPage_); 
      boolean bool = this.isFollow_;
      if (bool)
        param1CodedOutputStream.writeBool(16, bool); 
      if (this.feedTopicPage_ != FeedProtos.FeedTopicPage.UNKNOWN_FEED_TOPIC_PAGE.getNumber())
        param1CodedOutputStream.writeEnum(17, this.feedTopicPage_); 
      if (this.shareChannel_ != FeedProtos.ShareChannel.UNKNOWN_SHARE_CHANNEL.getNumber())
        param1CodedOutputStream.writeEnum(18, this.shareChannel_); 
      if (this.linkFrom_ != FeedProtos.LinkFrom.UNKNOWN_LINK_FROM.getNumber())
        param1CodedOutputStream.writeEnum(19, this.linkFrom_); 
      bool = this.isLike_;
      if (bool)
        param1CodedOutputStream.writeBool(20, bool); 
      if (!getLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 21, this.liveId_); 
      if (this.sourcePage_ != FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE.getNumber())
        param1CodedOutputStream.writeEnum(22, this.sourcePage_); 
      bool = this.isExposure_;
      if (bool)
        param1CodedOutputStream.writeBool(23, bool); 
      if (!getCommentIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 24, this.commentId_); 
      if (!getCircleIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 25, this.circleId_); 
      bool = this.isJoin_;
      if (bool)
        param1CodedOutputStream.writeBool(26, bool); 
      if (this.circleSource_ != FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(27, this.circleSource_); 
      if (!getNoteIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 28, this.noteId_); 
      bool = this.isTop_;
      if (bool)
        param1CodedOutputStream.writeBool(29, bool); 
      if (this.noteSource_ != FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(30, this.noteSource_); 
      if (this.optType_ != FeedProtos.OptType.UNKNOWN_OPT_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(31, this.optType_); 
      if (!getLinkUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 32, this.linkUrl_); 
      bool = this.isAt_;
      if (bool)
        param1CodedOutputStream.writeBool(33, bool); 
      bool = this.isLive_;
      if (bool)
        param1CodedOutputStream.writeBool(34, bool); 
      if (this.noteType_ != FeedProtos.NoteType.UNKNOWN_NOTE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(35, this.noteType_); 
      if (!getNoteFromBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 36, this.noteFrom_); 
      if (!getRecommendTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 37, this.recommendType_); 
      bool = this.isMulti_;
      if (bool)
        param1CodedOutputStream.writeBool(38, bool); 
      if (!getMusicIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 39, this.musicId_); 
      bool = this.isCircleTop_;
      if (bool)
        param1CodedOutputStream.writeBool(40, bool); 
      bool = this.isApply_;
      if (bool)
        param1CodedOutputStream.writeBool(41, bool); 
      bool = this.isInvite_;
      if (bool)
        param1CodedOutputStream.writeBool(42, bool); 
      if (!getImageIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 43, this.imageId_); 
      bool = this.isAnonymousPublish_;
      if (bool)
        param1CodedOutputStream.writeBool(44, bool); 
      bool = this.isAnonymousComment_;
      if (bool)
        param1CodedOutputStream.writeBool(45, bool); 
      if (this.userType_ != FeedProtos.UserType.UNKNOWN_USER_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(46, this.userType_); 
      if (!getTaskIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 47, this.taskId_); 
      bool = this.isComment_;
      if (bool)
        param1CodedOutputStream.writeBool(48, bool); 
      int i = this.num_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(49, i); 
      if (!getTabIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 50, this.tabId_); 
      if (!getPositionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 51, this.position_); 
      if (this.tagSource_ != FeedProtos.TagSource.UNKNOWN_TAG_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(52, this.tagSource_); 
      bool = this.isEssence_;
      if (bool)
        param1CodedOutputStream.writeBool(53, bool); 
      if (this.tabType_ != FeedProtos.TabType.UNKNOWN_TAB_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(54, this.tabType_); 
      if (!getRoomIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 55, this.roomId_); 
      if (!getRoomUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 56, this.roomUid_); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 57, this.id_); 
      if (!getIconTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 58, this.iconType_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FeedProtos.FeedProtoOrBuilder {
      private int addType_ = 0;
      
      private Object circleId_ = "";
      
      private int circleSource_ = 0;
      
      private Object commentId_ = "";
      
      private int detailFrom_ = 0;
      
      private int event_ = 0;
      
      private int feedClass_ = 0;
      
      private int feedFromPage_ = 0;
      
      private int feedFrom_ = 0;
      
      private Object feedId_ = "";
      
      private int feedPage_ = 0;
      
      private int feedTopicPage_ = 0;
      
      private int feedType_ = 0;
      
      private int followLocation_ = 0;
      
      private Object iconType_ = "";
      
      private Object id_ = "";
      
      private Object imageId_ = "";
      
      private int interactiveType_ = 0;
      
      private boolean isAnonymousComment_;
      
      private boolean isAnonymousPublish_;
      
      private boolean isApply_;
      
      private boolean isAt_;
      
      private boolean isCircleTop_;
      
      private boolean isComment_;
      
      private boolean isEssence_;
      
      private boolean isExposure_;
      
      private boolean isFollow_;
      
      private boolean isInvite_;
      
      private boolean isJoin_;
      
      private boolean isLike_;
      
      private boolean isLive_;
      
      private boolean isMulti_;
      
      private boolean isTop_;
      
      private Object keyword_ = "";
      
      private int linkFrom_ = 0;
      
      private Object linkUrl_ = "";
      
      private Object liveId_ = "";
      
      private int location_ = 0;
      
      private Object musicId_ = "";
      
      private Object noteFrom_ = "";
      
      private Object noteId_ = "";
      
      private int noteSource_ = 0;
      
      private int noteType_ = 0;
      
      private int num_;
      
      private int optType_ = 0;
      
      private Object position_ = "";
      
      private Object recommendType_ = "";
      
      private Object roomId_ = "";
      
      private Object roomUid_ = "";
      
      private int shareChannel_ = 0;
      
      private int sourcePage_ = 0;
      
      private Object tabId_ = "";
      
      private int tabType_ = 0;
      
      private int tagSource_ = 0;
      
      private Object targetUid_ = "";
      
      private Object taskId_ = "";
      
      private Object topicId_ = "";
      
      private int userType_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        FeedProtos.FeedProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public FeedProtos.FeedProto build() {
        FeedProtos.FeedProto feedProto = buildPartial();
        if (feedProto.isInitialized())
          return feedProto; 
        throw newUninitializedMessageException(feedProto);
      }
      
      public FeedProtos.FeedProto buildPartial() {
        FeedProtos.FeedProto feedProto = new FeedProtos.FeedProto(this);
        FeedProtos.FeedProto.access$602(feedProto, this.event_);
        FeedProtos.FeedProto.access$702(feedProto, this.topicId_);
        FeedProtos.FeedProto.access$802(feedProto, this.feedType_);
        FeedProtos.FeedProto.access$902(feedProto, this.feedFrom_);
        FeedProtos.FeedProto.access$1002(feedProto, this.detailFrom_);
        FeedProtos.FeedProto.access$1102(feedProto, this.feedId_);
        FeedProtos.FeedProto.access$1202(feedProto, this.keyword_);
        FeedProtos.FeedProto.access$1302(feedProto, this.feedFromPage_);
        FeedProtos.FeedProto.access$1402(feedProto, this.interactiveType_);
        FeedProtos.FeedProto.access$1502(feedProto, this.targetUid_);
        FeedProtos.FeedProto.access$1602(feedProto, this.location_);
        FeedProtos.FeedProto.access$1702(feedProto, this.addType_);
        FeedProtos.FeedProto.access$1802(feedProto, this.followLocation_);
        FeedProtos.FeedProto.access$1902(feedProto, this.feedClass_);
        FeedProtos.FeedProto.access$2002(feedProto, this.feedPage_);
        FeedProtos.FeedProto.access$2102(feedProto, this.isFollow_);
        FeedProtos.FeedProto.access$2202(feedProto, this.feedTopicPage_);
        FeedProtos.FeedProto.access$2302(feedProto, this.shareChannel_);
        FeedProtos.FeedProto.access$2402(feedProto, this.linkFrom_);
        FeedProtos.FeedProto.access$2502(feedProto, this.isLike_);
        FeedProtos.FeedProto.access$2602(feedProto, this.liveId_);
        FeedProtos.FeedProto.access$2702(feedProto, this.sourcePage_);
        FeedProtos.FeedProto.access$2802(feedProto, this.isExposure_);
        FeedProtos.FeedProto.access$2902(feedProto, this.commentId_);
        FeedProtos.FeedProto.access$3002(feedProto, this.circleId_);
        FeedProtos.FeedProto.access$3102(feedProto, this.isJoin_);
        FeedProtos.FeedProto.access$3202(feedProto, this.circleSource_);
        FeedProtos.FeedProto.access$3302(feedProto, this.noteId_);
        FeedProtos.FeedProto.access$3402(feedProto, this.isTop_);
        FeedProtos.FeedProto.access$3502(feedProto, this.noteSource_);
        FeedProtos.FeedProto.access$3602(feedProto, this.optType_);
        FeedProtos.FeedProto.access$3702(feedProto, this.linkUrl_);
        FeedProtos.FeedProto.access$3802(feedProto, this.isAt_);
        FeedProtos.FeedProto.access$3902(feedProto, this.isLive_);
        FeedProtos.FeedProto.access$4002(feedProto, this.noteType_);
        FeedProtos.FeedProto.access$4102(feedProto, this.noteFrom_);
        FeedProtos.FeedProto.access$4202(feedProto, this.recommendType_);
        FeedProtos.FeedProto.access$4302(feedProto, this.isMulti_);
        FeedProtos.FeedProto.access$4402(feedProto, this.musicId_);
        FeedProtos.FeedProto.access$4502(feedProto, this.isCircleTop_);
        FeedProtos.FeedProto.access$4602(feedProto, this.isApply_);
        FeedProtos.FeedProto.access$4702(feedProto, this.isInvite_);
        FeedProtos.FeedProto.access$4802(feedProto, this.imageId_);
        FeedProtos.FeedProto.access$4902(feedProto, this.isAnonymousPublish_);
        FeedProtos.FeedProto.access$5002(feedProto, this.isAnonymousComment_);
        FeedProtos.FeedProto.access$5102(feedProto, this.userType_);
        FeedProtos.FeedProto.access$5202(feedProto, this.taskId_);
        FeedProtos.FeedProto.access$5302(feedProto, this.isComment_);
        FeedProtos.FeedProto.access$5402(feedProto, this.num_);
        FeedProtos.FeedProto.access$5502(feedProto, this.tabId_);
        FeedProtos.FeedProto.access$5602(feedProto, this.position_);
        FeedProtos.FeedProto.access$5702(feedProto, this.tagSource_);
        FeedProtos.FeedProto.access$5802(feedProto, this.isEssence_);
        FeedProtos.FeedProto.access$5902(feedProto, this.tabType_);
        FeedProtos.FeedProto.access$6002(feedProto, this.roomId_);
        FeedProtos.FeedProto.access$6102(feedProto, this.roomUid_);
        FeedProtos.FeedProto.access$6202(feedProto, this.id_);
        FeedProtos.FeedProto.access$6302(feedProto, this.iconType_);
        onBuilt();
        return feedProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.topicId_ = "";
        this.feedType_ = 0;
        this.feedFrom_ = 0;
        this.detailFrom_ = 0;
        this.feedId_ = "";
        this.keyword_ = "";
        this.feedFromPage_ = 0;
        this.interactiveType_ = 0;
        this.targetUid_ = "";
        this.location_ = 0;
        this.addType_ = 0;
        this.followLocation_ = 0;
        this.feedClass_ = 0;
        this.feedPage_ = 0;
        this.isFollow_ = false;
        this.feedTopicPage_ = 0;
        this.shareChannel_ = 0;
        this.linkFrom_ = 0;
        this.isLike_ = false;
        this.liveId_ = "";
        this.sourcePage_ = 0;
        this.isExposure_ = false;
        this.commentId_ = "";
        this.circleId_ = "";
        this.isJoin_ = false;
        this.circleSource_ = 0;
        this.noteId_ = "";
        this.isTop_ = false;
        this.noteSource_ = 0;
        this.optType_ = 0;
        this.linkUrl_ = "";
        this.isAt_ = false;
        this.isLive_ = false;
        this.noteType_ = 0;
        this.noteFrom_ = "";
        this.recommendType_ = "";
        this.isMulti_ = false;
        this.musicId_ = "";
        this.isCircleTop_ = false;
        this.isApply_ = false;
        this.isInvite_ = false;
        this.imageId_ = "";
        this.isAnonymousPublish_ = false;
        this.isAnonymousComment_ = false;
        this.userType_ = 0;
        this.taskId_ = "";
        this.isComment_ = false;
        this.num_ = 0;
        this.tabId_ = "";
        this.position_ = "";
        this.tagSource_ = 0;
        this.isEssence_ = false;
        this.tabType_ = 0;
        this.roomId_ = "";
        this.roomUid_ = "";
        this.id_ = "";
        this.iconType_ = "";
        return this;
      }
      
      public Builder clearAddType() {
        this.addType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearCircleId() {
        this.circleId_ = FeedProtos.FeedProto.getDefaultInstance().getCircleId();
        onChanged();
        return this;
      }
      
      public Builder clearCircleSource() {
        this.circleSource_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearCommentId() {
        this.commentId_ = FeedProtos.FeedProto.getDefaultInstance().getCommentId();
        onChanged();
        return this;
      }
      
      public Builder clearDetailFrom() {
        this.detailFrom_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedClass() {
        this.feedClass_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedFrom() {
        this.feedFrom_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedFromPage() {
        this.feedFromPage_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedId() {
        this.feedId_ = FeedProtos.FeedProto.getDefaultInstance().getFeedId();
        onChanged();
        return this;
      }
      
      public Builder clearFeedPage() {
        this.feedPage_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearFeedTopicPage() {
        this.feedTopicPage_ = 0;
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
      
      public Builder clearFollowLocation() {
        this.followLocation_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearIconType() {
        this.iconType_ = FeedProtos.FeedProto.getDefaultInstance().getIconType();
        onChanged();
        return this;
      }
      
      public Builder clearId() {
        this.id_ = FeedProtos.FeedProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearImageId() {
        this.imageId_ = FeedProtos.FeedProto.getDefaultInstance().getImageId();
        onChanged();
        return this;
      }
      
      public Builder clearInteractiveType() {
        this.interactiveType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearIsAnonymousComment() {
        this.isAnonymousComment_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsAnonymousPublish() {
        this.isAnonymousPublish_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsApply() {
        this.isApply_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsAt() {
        this.isAt_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsCircleTop() {
        this.isCircleTop_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsComment() {
        this.isComment_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsEssence() {
        this.isEssence_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsExposure() {
        this.isExposure_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsFollow() {
        this.isFollow_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsInvite() {
        this.isInvite_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsJoin() {
        this.isJoin_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsLike() {
        this.isLike_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsLive() {
        this.isLive_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsMulti() {
        this.isMulti_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsTop() {
        this.isTop_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearKeyword() {
        this.keyword_ = FeedProtos.FeedProto.getDefaultInstance().getKeyword();
        onChanged();
        return this;
      }
      
      public Builder clearLinkFrom() {
        this.linkFrom_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearLinkUrl() {
        this.linkUrl_ = FeedProtos.FeedProto.getDefaultInstance().getLinkUrl();
        onChanged();
        return this;
      }
      
      public Builder clearLiveId() {
        this.liveId_ = FeedProtos.FeedProto.getDefaultInstance().getLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearLocation() {
        this.location_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearMusicId() {
        this.musicId_ = FeedProtos.FeedProto.getDefaultInstance().getMusicId();
        onChanged();
        return this;
      }
      
      public Builder clearNoteFrom() {
        this.noteFrom_ = FeedProtos.FeedProto.getDefaultInstance().getNoteFrom();
        onChanged();
        return this;
      }
      
      public Builder clearNoteId() {
        this.noteId_ = FeedProtos.FeedProto.getDefaultInstance().getNoteId();
        onChanged();
        return this;
      }
      
      public Builder clearNoteSource() {
        this.noteSource_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearNoteType() {
        this.noteType_ = 0;
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
      
      public Builder clearOptType() {
        this.optType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPosition() {
        this.position_ = FeedProtos.FeedProto.getDefaultInstance().getPosition();
        onChanged();
        return this;
      }
      
      public Builder clearRecommendType() {
        this.recommendType_ = FeedProtos.FeedProto.getDefaultInstance().getRecommendType();
        onChanged();
        return this;
      }
      
      public Builder clearRoomId() {
        this.roomId_ = FeedProtos.FeedProto.getDefaultInstance().getRoomId();
        onChanged();
        return this;
      }
      
      public Builder clearRoomUid() {
        this.roomUid_ = FeedProtos.FeedProto.getDefaultInstance().getRoomUid();
        onChanged();
        return this;
      }
      
      public Builder clearShareChannel() {
        this.shareChannel_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSourcePage() {
        this.sourcePage_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTabId() {
        this.tabId_ = FeedProtos.FeedProto.getDefaultInstance().getTabId();
        onChanged();
        return this;
      }
      
      public Builder clearTabType() {
        this.tabType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTagSource() {
        this.tagSource_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = FeedProtos.FeedProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clearTaskId() {
        this.taskId_ = FeedProtos.FeedProto.getDefaultInstance().getTaskId();
        onChanged();
        return this;
      }
      
      public Builder clearTopicId() {
        this.topicId_ = FeedProtos.FeedProto.getDefaultInstance().getTopicId();
        onChanged();
        return this;
      }
      
      public Builder clearUserType() {
        this.userType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public FeedProtos.AddType getAddType() {
        FeedProtos.AddType addType2 = FeedProtos.AddType.valueOf(this.addType_);
        FeedProtos.AddType addType1 = addType2;
        if (addType2 == null)
          addType1 = FeedProtos.AddType.UNRECOGNIZED; 
        return addType1;
      }
      
      public int getAddTypeValue() {
        return this.addType_;
      }
      
      public String getCircleId() {
        Object object = this.circleId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.circleId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getCircleIdBytes() {
        Object object = this.circleId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.circleId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public FeedProtos.CircleSource getCircleSource() {
        FeedProtos.CircleSource circleSource2 = FeedProtos.CircleSource.valueOf(this.circleSource_);
        FeedProtos.CircleSource circleSource1 = circleSource2;
        if (circleSource2 == null)
          circleSource1 = FeedProtos.CircleSource.UNRECOGNIZED; 
        return circleSource1;
      }
      
      public int getCircleSourceValue() {
        return this.circleSource_;
      }
      
      public String getCommentId() {
        Object object = this.commentId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.commentId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getCommentIdBytes() {
        Object object = this.commentId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.commentId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public FeedProtos.FeedProto getDefaultInstanceForType() {
        return FeedProtos.FeedProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_descriptor;
      }
      
      public FeedProtos.DetailFrom getDetailFrom() {
        FeedProtos.DetailFrom detailFrom2 = FeedProtos.DetailFrom.valueOf(this.detailFrom_);
        FeedProtos.DetailFrom detailFrom1 = detailFrom2;
        if (detailFrom2 == null)
          detailFrom1 = FeedProtos.DetailFrom.UNRECOGNIZED; 
        return detailFrom1;
      }
      
      public int getDetailFromValue() {
        return this.detailFrom_;
      }
      
      public FeedProtos.Event getEvent() {
        FeedProtos.Event event2 = FeedProtos.Event.valueOf(this.event_);
        FeedProtos.Event event1 = event2;
        if (event2 == null)
          event1 = FeedProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public FeedProtos.FeedClass getFeedClass() {
        FeedProtos.FeedClass feedClass2 = FeedProtos.FeedClass.valueOf(this.feedClass_);
        FeedProtos.FeedClass feedClass1 = feedClass2;
        if (feedClass2 == null)
          feedClass1 = FeedProtos.FeedClass.UNRECOGNIZED; 
        return feedClass1;
      }
      
      public int getFeedClassValue() {
        return this.feedClass_;
      }
      
      public FeedProtos.FeedFrom getFeedFrom() {
        FeedProtos.FeedFrom feedFrom2 = FeedProtos.FeedFrom.valueOf(this.feedFrom_);
        FeedProtos.FeedFrom feedFrom1 = feedFrom2;
        if (feedFrom2 == null)
          feedFrom1 = FeedProtos.FeedFrom.UNRECOGNIZED; 
        return feedFrom1;
      }
      
      public FeedProtos.FeedFromPage getFeedFromPage() {
        FeedProtos.FeedFromPage feedFromPage2 = FeedProtos.FeedFromPage.valueOf(this.feedFromPage_);
        FeedProtos.FeedFromPage feedFromPage1 = feedFromPage2;
        if (feedFromPage2 == null)
          feedFromPage1 = FeedProtos.FeedFromPage.UNRECOGNIZED; 
        return feedFromPage1;
      }
      
      public int getFeedFromPageValue() {
        return this.feedFromPage_;
      }
      
      public int getFeedFromValue() {
        return this.feedFrom_;
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
      
      public FeedProtos.FeedPage getFeedPage() {
        FeedProtos.FeedPage feedPage2 = FeedProtos.FeedPage.valueOf(this.feedPage_);
        FeedProtos.FeedPage feedPage1 = feedPage2;
        if (feedPage2 == null)
          feedPage1 = FeedProtos.FeedPage.UNRECOGNIZED; 
        return feedPage1;
      }
      
      public int getFeedPageValue() {
        return this.feedPage_;
      }
      
      public FeedProtos.FeedTopicPage getFeedTopicPage() {
        FeedProtos.FeedTopicPage feedTopicPage2 = FeedProtos.FeedTopicPage.valueOf(this.feedTopicPage_);
        FeedProtos.FeedTopicPage feedTopicPage1 = feedTopicPage2;
        if (feedTopicPage2 == null)
          feedTopicPage1 = FeedProtos.FeedTopicPage.UNRECOGNIZED; 
        return feedTopicPage1;
      }
      
      public int getFeedTopicPageValue() {
        return this.feedTopicPage_;
      }
      
      public FeedProtos.FeedType getFeedType() {
        FeedProtos.FeedType feedType2 = FeedProtos.FeedType.valueOf(this.feedType_);
        FeedProtos.FeedType feedType1 = feedType2;
        if (feedType2 == null)
          feedType1 = FeedProtos.FeedType.UNRECOGNIZED; 
        return feedType1;
      }
      
      public int getFeedTypeValue() {
        return this.feedType_;
      }
      
      public FeedProtos.FollowLocation getFollowLocation() {
        FeedProtos.FollowLocation followLocation2 = FeedProtos.FollowLocation.valueOf(this.followLocation_);
        FeedProtos.FollowLocation followLocation1 = followLocation2;
        if (followLocation2 == null)
          followLocation1 = FeedProtos.FollowLocation.UNRECOGNIZED; 
        return followLocation1;
      }
      
      public int getFollowLocationValue() {
        return this.followLocation_;
      }
      
      public String getIconType() {
        Object object = this.iconType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.iconType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getIconTypeBytes() {
        Object object = this.iconType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.iconType_ = object;
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
      
      public FeedProtos.InteractiveType getInteractiveType() {
        FeedProtos.InteractiveType interactiveType2 = FeedProtos.InteractiveType.valueOf(this.interactiveType_);
        FeedProtos.InteractiveType interactiveType1 = interactiveType2;
        if (interactiveType2 == null)
          interactiveType1 = FeedProtos.InteractiveType.UNRECOGNIZED; 
        return interactiveType1;
      }
      
      public int getInteractiveTypeValue() {
        return this.interactiveType_;
      }
      
      public boolean getIsAnonymousComment() {
        return this.isAnonymousComment_;
      }
      
      public boolean getIsAnonymousPublish() {
        return this.isAnonymousPublish_;
      }
      
      public boolean getIsApply() {
        return this.isApply_;
      }
      
      public boolean getIsAt() {
        return this.isAt_;
      }
      
      public boolean getIsCircleTop() {
        return this.isCircleTop_;
      }
      
      public boolean getIsComment() {
        return this.isComment_;
      }
      
      public boolean getIsEssence() {
        return this.isEssence_;
      }
      
      public boolean getIsExposure() {
        return this.isExposure_;
      }
      
      public boolean getIsFollow() {
        return this.isFollow_;
      }
      
      public boolean getIsInvite() {
        return this.isInvite_;
      }
      
      public boolean getIsJoin() {
        return this.isJoin_;
      }
      
      public boolean getIsLike() {
        return this.isLike_;
      }
      
      public boolean getIsLive() {
        return this.isLive_;
      }
      
      public boolean getIsMulti() {
        return this.isMulti_;
      }
      
      public boolean getIsTop() {
        return this.isTop_;
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
      
      public FeedProtos.LinkFrom getLinkFrom() {
        FeedProtos.LinkFrom linkFrom2 = FeedProtos.LinkFrom.valueOf(this.linkFrom_);
        FeedProtos.LinkFrom linkFrom1 = linkFrom2;
        if (linkFrom2 == null)
          linkFrom1 = FeedProtos.LinkFrom.UNRECOGNIZED; 
        return linkFrom1;
      }
      
      public int getLinkFromValue() {
        return this.linkFrom_;
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
      
      public FeedProtos.Location getLocation() {
        FeedProtos.Location location2 = FeedProtos.Location.valueOf(this.location_);
        FeedProtos.Location location1 = location2;
        if (location2 == null)
          location1 = FeedProtos.Location.UNRECOGNIZED; 
        return location1;
      }
      
      public int getLocationValue() {
        return this.location_;
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
      
      public String getNoteFrom() {
        Object object = this.noteFrom_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.noteFrom_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getNoteFromBytes() {
        Object object = this.noteFrom_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.noteFrom_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getNoteId() {
        Object object = this.noteId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.noteId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getNoteIdBytes() {
        Object object = this.noteId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.noteId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public FeedProtos.NoteSource getNoteSource() {
        FeedProtos.NoteSource noteSource2 = FeedProtos.NoteSource.valueOf(this.noteSource_);
        FeedProtos.NoteSource noteSource1 = noteSource2;
        if (noteSource2 == null)
          noteSource1 = FeedProtos.NoteSource.UNRECOGNIZED; 
        return noteSource1;
      }
      
      public int getNoteSourceValue() {
        return this.noteSource_;
      }
      
      public FeedProtos.NoteType getNoteType() {
        FeedProtos.NoteType noteType2 = FeedProtos.NoteType.valueOf(this.noteType_);
        FeedProtos.NoteType noteType1 = noteType2;
        if (noteType2 == null)
          noteType1 = FeedProtos.NoteType.UNRECOGNIZED; 
        return noteType1;
      }
      
      public int getNoteTypeValue() {
        return this.noteType_;
      }
      
      public int getNum() {
        return this.num_;
      }
      
      public FeedProtos.OptType getOptType() {
        FeedProtos.OptType optType2 = FeedProtos.OptType.valueOf(this.optType_);
        FeedProtos.OptType optType1 = optType2;
        if (optType2 == null)
          optType1 = FeedProtos.OptType.UNRECOGNIZED; 
        return optType1;
      }
      
      public int getOptTypeValue() {
        return this.optType_;
      }
      
      public String getPosition() {
        Object object = this.position_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.position_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getPositionBytes() {
        Object object = this.position_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.position_ = object;
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
      
      public FeedProtos.ShareChannel getShareChannel() {
        FeedProtos.ShareChannel shareChannel2 = FeedProtos.ShareChannel.valueOf(this.shareChannel_);
        FeedProtos.ShareChannel shareChannel1 = shareChannel2;
        if (shareChannel2 == null)
          shareChannel1 = FeedProtos.ShareChannel.UNRECOGNIZED; 
        return shareChannel1;
      }
      
      public int getShareChannelValue() {
        return this.shareChannel_;
      }
      
      public FeedProtos.SourcePage getSourcePage() {
        FeedProtos.SourcePage sourcePage2 = FeedProtos.SourcePage.valueOf(this.sourcePage_);
        FeedProtos.SourcePage sourcePage1 = sourcePage2;
        if (sourcePage2 == null)
          sourcePage1 = FeedProtos.SourcePage.UNRECOGNIZED; 
        return sourcePage1;
      }
      
      public int getSourcePageValue() {
        return this.sourcePage_;
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
      
      public FeedProtos.TabType getTabType() {
        FeedProtos.TabType tabType2 = FeedProtos.TabType.valueOf(this.tabType_);
        FeedProtos.TabType tabType1 = tabType2;
        if (tabType2 == null)
          tabType1 = FeedProtos.TabType.UNRECOGNIZED; 
        return tabType1;
      }
      
      public int getTabTypeValue() {
        return this.tabType_;
      }
      
      public FeedProtos.TagSource getTagSource() {
        FeedProtos.TagSource tagSource2 = FeedProtos.TagSource.valueOf(this.tagSource_);
        FeedProtos.TagSource tagSource1 = tagSource2;
        if (tagSource2 == null)
          tagSource1 = FeedProtos.TagSource.UNRECOGNIZED; 
        return tagSource1;
      }
      
      public int getTagSourceValue() {
        return this.tagSource_;
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
      
      public String getTopicId() {
        Object object = this.topicId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.topicId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTopicIdBytes() {
        Object object = this.topicId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.topicId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public FeedProtos.UserType getUserType() {
        FeedProtos.UserType userType2 = FeedProtos.UserType.valueOf(this.userType_);
        FeedProtos.UserType userType1 = userType2;
        if (userType2 == null)
          userType1 = FeedProtos.UserType.UNRECOGNIZED; 
        return userType1;
      }
      
      public int getUserTypeValue() {
        return this.userType_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FeedProtos.FeedProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(FeedProtos.FeedProto param2FeedProto) {
        if (param2FeedProto == FeedProtos.FeedProto.getDefaultInstance())
          return this; 
        if (param2FeedProto.event_ != 0)
          setEventValue(param2FeedProto.getEventValue()); 
        if (!param2FeedProto.getTopicId().isEmpty()) {
          this.topicId_ = param2FeedProto.topicId_;
          onChanged();
        } 
        if (param2FeedProto.feedType_ != 0)
          setFeedTypeValue(param2FeedProto.getFeedTypeValue()); 
        if (param2FeedProto.feedFrom_ != 0)
          setFeedFromValue(param2FeedProto.getFeedFromValue()); 
        if (param2FeedProto.detailFrom_ != 0)
          setDetailFromValue(param2FeedProto.getDetailFromValue()); 
        if (!param2FeedProto.getFeedId().isEmpty()) {
          this.feedId_ = param2FeedProto.feedId_;
          onChanged();
        } 
        if (!param2FeedProto.getKeyword().isEmpty()) {
          this.keyword_ = param2FeedProto.keyword_;
          onChanged();
        } 
        if (param2FeedProto.feedFromPage_ != 0)
          setFeedFromPageValue(param2FeedProto.getFeedFromPageValue()); 
        if (param2FeedProto.interactiveType_ != 0)
          setInteractiveTypeValue(param2FeedProto.getInteractiveTypeValue()); 
        if (!param2FeedProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2FeedProto.targetUid_;
          onChanged();
        } 
        if (param2FeedProto.location_ != 0)
          setLocationValue(param2FeedProto.getLocationValue()); 
        if (param2FeedProto.addType_ != 0)
          setAddTypeValue(param2FeedProto.getAddTypeValue()); 
        if (param2FeedProto.followLocation_ != 0)
          setFollowLocationValue(param2FeedProto.getFollowLocationValue()); 
        if (param2FeedProto.feedClass_ != 0)
          setFeedClassValue(param2FeedProto.getFeedClassValue()); 
        if (param2FeedProto.feedPage_ != 0)
          setFeedPageValue(param2FeedProto.getFeedPageValue()); 
        if (param2FeedProto.getIsFollow())
          setIsFollow(param2FeedProto.getIsFollow()); 
        if (param2FeedProto.feedTopicPage_ != 0)
          setFeedTopicPageValue(param2FeedProto.getFeedTopicPageValue()); 
        if (param2FeedProto.shareChannel_ != 0)
          setShareChannelValue(param2FeedProto.getShareChannelValue()); 
        if (param2FeedProto.linkFrom_ != 0)
          setLinkFromValue(param2FeedProto.getLinkFromValue()); 
        if (param2FeedProto.getIsLike())
          setIsLike(param2FeedProto.getIsLike()); 
        if (!param2FeedProto.getLiveId().isEmpty()) {
          this.liveId_ = param2FeedProto.liveId_;
          onChanged();
        } 
        if (param2FeedProto.sourcePage_ != 0)
          setSourcePageValue(param2FeedProto.getSourcePageValue()); 
        if (param2FeedProto.getIsExposure())
          setIsExposure(param2FeedProto.getIsExposure()); 
        if (!param2FeedProto.getCommentId().isEmpty()) {
          this.commentId_ = param2FeedProto.commentId_;
          onChanged();
        } 
        if (!param2FeedProto.getCircleId().isEmpty()) {
          this.circleId_ = param2FeedProto.circleId_;
          onChanged();
        } 
        if (param2FeedProto.getIsJoin())
          setIsJoin(param2FeedProto.getIsJoin()); 
        if (param2FeedProto.circleSource_ != 0)
          setCircleSourceValue(param2FeedProto.getCircleSourceValue()); 
        if (!param2FeedProto.getNoteId().isEmpty()) {
          this.noteId_ = param2FeedProto.noteId_;
          onChanged();
        } 
        if (param2FeedProto.getIsTop())
          setIsTop(param2FeedProto.getIsTop()); 
        if (param2FeedProto.noteSource_ != 0)
          setNoteSourceValue(param2FeedProto.getNoteSourceValue()); 
        if (param2FeedProto.optType_ != 0)
          setOptTypeValue(param2FeedProto.getOptTypeValue()); 
        if (!param2FeedProto.getLinkUrl().isEmpty()) {
          this.linkUrl_ = param2FeedProto.linkUrl_;
          onChanged();
        } 
        if (param2FeedProto.getIsAt())
          setIsAt(param2FeedProto.getIsAt()); 
        if (param2FeedProto.getIsLive())
          setIsLive(param2FeedProto.getIsLive()); 
        if (param2FeedProto.noteType_ != 0)
          setNoteTypeValue(param2FeedProto.getNoteTypeValue()); 
        if (!param2FeedProto.getNoteFrom().isEmpty()) {
          this.noteFrom_ = param2FeedProto.noteFrom_;
          onChanged();
        } 
        if (!param2FeedProto.getRecommendType().isEmpty()) {
          this.recommendType_ = param2FeedProto.recommendType_;
          onChanged();
        } 
        if (param2FeedProto.getIsMulti())
          setIsMulti(param2FeedProto.getIsMulti()); 
        if (!param2FeedProto.getMusicId().isEmpty()) {
          this.musicId_ = param2FeedProto.musicId_;
          onChanged();
        } 
        if (param2FeedProto.getIsCircleTop())
          setIsCircleTop(param2FeedProto.getIsCircleTop()); 
        if (param2FeedProto.getIsApply())
          setIsApply(param2FeedProto.getIsApply()); 
        if (param2FeedProto.getIsInvite())
          setIsInvite(param2FeedProto.getIsInvite()); 
        if (!param2FeedProto.getImageId().isEmpty()) {
          this.imageId_ = param2FeedProto.imageId_;
          onChanged();
        } 
        if (param2FeedProto.getIsAnonymousPublish())
          setIsAnonymousPublish(param2FeedProto.getIsAnonymousPublish()); 
        if (param2FeedProto.getIsAnonymousComment())
          setIsAnonymousComment(param2FeedProto.getIsAnonymousComment()); 
        if (param2FeedProto.userType_ != 0)
          setUserTypeValue(param2FeedProto.getUserTypeValue()); 
        if (!param2FeedProto.getTaskId().isEmpty()) {
          this.taskId_ = param2FeedProto.taskId_;
          onChanged();
        } 
        if (param2FeedProto.getIsComment())
          setIsComment(param2FeedProto.getIsComment()); 
        if (param2FeedProto.getNum() != 0)
          setNum(param2FeedProto.getNum()); 
        if (!param2FeedProto.getTabId().isEmpty()) {
          this.tabId_ = param2FeedProto.tabId_;
          onChanged();
        } 
        if (!param2FeedProto.getPosition().isEmpty()) {
          this.position_ = param2FeedProto.position_;
          onChanged();
        } 
        if (param2FeedProto.tagSource_ != 0)
          setTagSourceValue(param2FeedProto.getTagSourceValue()); 
        if (param2FeedProto.getIsEssence())
          setIsEssence(param2FeedProto.getIsEssence()); 
        if (param2FeedProto.tabType_ != 0)
          setTabTypeValue(param2FeedProto.getTabTypeValue()); 
        if (!param2FeedProto.getRoomId().isEmpty()) {
          this.roomId_ = param2FeedProto.roomId_;
          onChanged();
        } 
        if (!param2FeedProto.getRoomUid().isEmpty()) {
          this.roomUid_ = param2FeedProto.roomUid_;
          onChanged();
        } 
        if (!param2FeedProto.getId().isEmpty()) {
          this.id_ = param2FeedProto.id_;
          onChanged();
        } 
        if (!param2FeedProto.getIconType().isEmpty()) {
          this.iconType_ = param2FeedProto.iconType_;
          onChanged();
        } 
        mergeUnknownFields(param2FeedProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          FeedProtos.FeedProto feedProto = (FeedProtos.FeedProto)FeedProtos.FeedProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          FeedProtos.FeedProto feedProto = (FeedProtos.FeedProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((FeedProtos.FeedProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof FeedProtos.FeedProto)
          return mergeFrom((FeedProtos.FeedProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAddType(FeedProtos.AddType param2AddType) {
        if (param2AddType != null) {
          this.addType_ = param2AddType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAddTypeValue(int param2Int) {
        this.addType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setCircleId(String param2String) {
        if (param2String != null) {
          this.circleId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCircleIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.circleId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCircleSource(FeedProtos.CircleSource param2CircleSource) {
        if (param2CircleSource != null) {
          this.circleSource_ = param2CircleSource.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCircleSourceValue(int param2Int) {
        this.circleSource_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setCommentId(String param2String) {
        if (param2String != null) {
          this.commentId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCommentIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.commentId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDetailFrom(FeedProtos.DetailFrom param2DetailFrom) {
        if (param2DetailFrom != null) {
          this.detailFrom_ = param2DetailFrom.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDetailFromValue(int param2Int) {
        this.detailFrom_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setEvent(FeedProtos.Event param2Event) {
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
      
      public Builder setFeedClass(FeedProtos.FeedClass param2FeedClass) {
        if (param2FeedClass != null) {
          this.feedClass_ = param2FeedClass.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedClassValue(int param2Int) {
        this.feedClass_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setFeedFrom(FeedProtos.FeedFrom param2FeedFrom) {
        if (param2FeedFrom != null) {
          this.feedFrom_ = param2FeedFrom.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedFromPage(FeedProtos.FeedFromPage param2FeedFromPage) {
        if (param2FeedFromPage != null) {
          this.feedFromPage_ = param2FeedFromPage.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedFromPageValue(int param2Int) {
        this.feedFromPage_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setFeedFromValue(int param2Int) {
        this.feedFrom_ = param2Int;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.feedId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedPage(FeedProtos.FeedPage param2FeedPage) {
        if (param2FeedPage != null) {
          this.feedPage_ = param2FeedPage.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedPageValue(int param2Int) {
        this.feedPage_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setFeedTopicPage(FeedProtos.FeedTopicPage param2FeedTopicPage) {
        if (param2FeedTopicPage != null) {
          this.feedTopicPage_ = param2FeedTopicPage.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFeedTopicPageValue(int param2Int) {
        this.feedTopicPage_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setFeedType(FeedProtos.FeedType param2FeedType) {
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
      
      public Builder setFollowLocation(FeedProtos.FollowLocation param2FollowLocation) {
        if (param2FollowLocation != null) {
          this.followLocation_ = param2FollowLocation.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setFollowLocationValue(int param2Int) {
        this.followLocation_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIconType(String param2String) {
        if (param2String != null) {
          this.iconType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIconTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.iconType_ = param2ByteString;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.imageId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setInteractiveType(FeedProtos.InteractiveType param2InteractiveType) {
        if (param2InteractiveType != null) {
          this.interactiveType_ = param2InteractiveType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setInteractiveTypeValue(int param2Int) {
        this.interactiveType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIsAnonymousComment(boolean param2Boolean) {
        this.isAnonymousComment_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsAnonymousPublish(boolean param2Boolean) {
        this.isAnonymousPublish_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsApply(boolean param2Boolean) {
        this.isApply_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsAt(boolean param2Boolean) {
        this.isAt_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsCircleTop(boolean param2Boolean) {
        this.isCircleTop_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsComment(boolean param2Boolean) {
        this.isComment_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsEssence(boolean param2Boolean) {
        this.isEssence_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsExposure(boolean param2Boolean) {
        this.isExposure_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsFollow(boolean param2Boolean) {
        this.isFollow_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsInvite(boolean param2Boolean) {
        this.isInvite_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsJoin(boolean param2Boolean) {
        this.isJoin_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsLike(boolean param2Boolean) {
        this.isLike_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsLive(boolean param2Boolean) {
        this.isLive_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsMulti(boolean param2Boolean) {
        this.isMulti_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsTop(boolean param2Boolean) {
        this.isTop_ = param2Boolean;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.keyword_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLinkFrom(FeedProtos.LinkFrom param2LinkFrom) {
        if (param2LinkFrom != null) {
          this.linkFrom_ = param2LinkFrom.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLinkFromValue(int param2Int) {
        this.linkFrom_ = param2Int;
        onChanged();
        return this;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.liveId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLocation(FeedProtos.Location param2Location) {
        if (param2Location != null) {
          this.location_ = param2Location.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLocationValue(int param2Int) {
        this.location_ = param2Int;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.musicId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteFrom(String param2String) {
        if (param2String != null) {
          this.noteFrom_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteFromBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.noteFrom_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteId(String param2String) {
        if (param2String != null) {
          this.noteId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.noteId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteSource(FeedProtos.NoteSource param2NoteSource) {
        if (param2NoteSource != null) {
          this.noteSource_ = param2NoteSource.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteSourceValue(int param2Int) {
        this.noteSource_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setNoteType(FeedProtos.NoteType param2NoteType) {
        if (param2NoteType != null) {
          this.noteType_ = param2NoteType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNoteTypeValue(int param2Int) {
        this.noteType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setNum(int param2Int) {
        this.num_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOptType(FeedProtos.OptType param2OptType) {
        if (param2OptType != null) {
          this.optType_ = param2OptType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOptTypeValue(int param2Int) {
        this.optType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPosition(String param2String) {
        if (param2String != null) {
          this.position_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPositionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.position_ = param2ByteString;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.recommendType_ = param2ByteString;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.roomUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setShareChannel(FeedProtos.ShareChannel param2ShareChannel) {
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
      
      public Builder setSourcePage(FeedProtos.SourcePage param2SourcePage) {
        if (param2SourcePage != null) {
          this.sourcePage_ = param2SourcePage.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSourcePageValue(int param2Int) {
        this.sourcePage_ = param2Int;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.tabId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTabType(FeedProtos.TabType param2TabType) {
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
      
      public Builder setTagSource(FeedProtos.TagSource param2TagSource) {
        if (param2TagSource != null) {
          this.tagSource_ = param2TagSource.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTagSourceValue(int param2Int) {
        this.tagSource_ = param2Int;
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
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
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.taskId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTopicId(String param2String) {
        if (param2String != null) {
          this.topicId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTopicIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          FeedProtos.FeedProto.checkByteStringIsUtf8(param2ByteString);
          this.topicId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setUserType(FeedProtos.UserType param2UserType) {
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
    }
  }
  
  static final class null extends AbstractParser<FeedProto> {
    public FeedProtos.FeedProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new FeedProtos.FeedProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<FeedProto.Builder> implements FeedProtoOrBuilder {
    private int addType_ = 0;
    
    private Object circleId_ = "";
    
    private int circleSource_ = 0;
    
    private Object commentId_ = "";
    
    private int detailFrom_ = 0;
    
    private int event_ = 0;
    
    private int feedClass_ = 0;
    
    private int feedFromPage_ = 0;
    
    private int feedFrom_ = 0;
    
    private Object feedId_ = "";
    
    private int feedPage_ = 0;
    
    private int feedTopicPage_ = 0;
    
    private int feedType_ = 0;
    
    private int followLocation_ = 0;
    
    private Object iconType_ = "";
    
    private Object id_ = "";
    
    private Object imageId_ = "";
    
    private int interactiveType_ = 0;
    
    private boolean isAnonymousComment_;
    
    private boolean isAnonymousPublish_;
    
    private boolean isApply_;
    
    private boolean isAt_;
    
    private boolean isCircleTop_;
    
    private boolean isComment_;
    
    private boolean isEssence_;
    
    private boolean isExposure_;
    
    private boolean isFollow_;
    
    private boolean isInvite_;
    
    private boolean isJoin_;
    
    private boolean isLike_;
    
    private boolean isLive_;
    
    private boolean isMulti_;
    
    private boolean isTop_;
    
    private Object keyword_ = "";
    
    private int linkFrom_ = 0;
    
    private Object linkUrl_ = "";
    
    private Object liveId_ = "";
    
    private int location_ = 0;
    
    private Object musicId_ = "";
    
    private Object noteFrom_ = "";
    
    private Object noteId_ = "";
    
    private int noteSource_ = 0;
    
    private int noteType_ = 0;
    
    private int num_;
    
    private int optType_ = 0;
    
    private Object position_ = "";
    
    private Object recommendType_ = "";
    
    private Object roomId_ = "";
    
    private Object roomUid_ = "";
    
    private int shareChannel_ = 0;
    
    private int sourcePage_ = 0;
    
    private Object tabId_ = "";
    
    private int tabType_ = 0;
    
    private int tagSource_ = 0;
    
    private Object targetUid_ = "";
    
    private Object taskId_ = "";
    
    private Object topicId_ = "";
    
    private int userType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      FeedProtos.FeedProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public FeedProtos.FeedProto build() {
      FeedProtos.FeedProto feedProto = buildPartial();
      if (feedProto.isInitialized())
        return feedProto; 
      throw newUninitializedMessageException(feedProto);
    }
    
    public FeedProtos.FeedProto buildPartial() {
      FeedProtos.FeedProto feedProto = new FeedProtos.FeedProto(this);
      FeedProtos.FeedProto.access$602(feedProto, this.event_);
      FeedProtos.FeedProto.access$702(feedProto, this.topicId_);
      FeedProtos.FeedProto.access$802(feedProto, this.feedType_);
      FeedProtos.FeedProto.access$902(feedProto, this.feedFrom_);
      FeedProtos.FeedProto.access$1002(feedProto, this.detailFrom_);
      FeedProtos.FeedProto.access$1102(feedProto, this.feedId_);
      FeedProtos.FeedProto.access$1202(feedProto, this.keyword_);
      FeedProtos.FeedProto.access$1302(feedProto, this.feedFromPage_);
      FeedProtos.FeedProto.access$1402(feedProto, this.interactiveType_);
      FeedProtos.FeedProto.access$1502(feedProto, this.targetUid_);
      FeedProtos.FeedProto.access$1602(feedProto, this.location_);
      FeedProtos.FeedProto.access$1702(feedProto, this.addType_);
      FeedProtos.FeedProto.access$1802(feedProto, this.followLocation_);
      FeedProtos.FeedProto.access$1902(feedProto, this.feedClass_);
      FeedProtos.FeedProto.access$2002(feedProto, this.feedPage_);
      FeedProtos.FeedProto.access$2102(feedProto, this.isFollow_);
      FeedProtos.FeedProto.access$2202(feedProto, this.feedTopicPage_);
      FeedProtos.FeedProto.access$2302(feedProto, this.shareChannel_);
      FeedProtos.FeedProto.access$2402(feedProto, this.linkFrom_);
      FeedProtos.FeedProto.access$2502(feedProto, this.isLike_);
      FeedProtos.FeedProto.access$2602(feedProto, this.liveId_);
      FeedProtos.FeedProto.access$2702(feedProto, this.sourcePage_);
      FeedProtos.FeedProto.access$2802(feedProto, this.isExposure_);
      FeedProtos.FeedProto.access$2902(feedProto, this.commentId_);
      FeedProtos.FeedProto.access$3002(feedProto, this.circleId_);
      FeedProtos.FeedProto.access$3102(feedProto, this.isJoin_);
      FeedProtos.FeedProto.access$3202(feedProto, this.circleSource_);
      FeedProtos.FeedProto.access$3302(feedProto, this.noteId_);
      FeedProtos.FeedProto.access$3402(feedProto, this.isTop_);
      FeedProtos.FeedProto.access$3502(feedProto, this.noteSource_);
      FeedProtos.FeedProto.access$3602(feedProto, this.optType_);
      FeedProtos.FeedProto.access$3702(feedProto, this.linkUrl_);
      FeedProtos.FeedProto.access$3802(feedProto, this.isAt_);
      FeedProtos.FeedProto.access$3902(feedProto, this.isLive_);
      FeedProtos.FeedProto.access$4002(feedProto, this.noteType_);
      FeedProtos.FeedProto.access$4102(feedProto, this.noteFrom_);
      FeedProtos.FeedProto.access$4202(feedProto, this.recommendType_);
      FeedProtos.FeedProto.access$4302(feedProto, this.isMulti_);
      FeedProtos.FeedProto.access$4402(feedProto, this.musicId_);
      FeedProtos.FeedProto.access$4502(feedProto, this.isCircleTop_);
      FeedProtos.FeedProto.access$4602(feedProto, this.isApply_);
      FeedProtos.FeedProto.access$4702(feedProto, this.isInvite_);
      FeedProtos.FeedProto.access$4802(feedProto, this.imageId_);
      FeedProtos.FeedProto.access$4902(feedProto, this.isAnonymousPublish_);
      FeedProtos.FeedProto.access$5002(feedProto, this.isAnonymousComment_);
      FeedProtos.FeedProto.access$5102(feedProto, this.userType_);
      FeedProtos.FeedProto.access$5202(feedProto, this.taskId_);
      FeedProtos.FeedProto.access$5302(feedProto, this.isComment_);
      FeedProtos.FeedProto.access$5402(feedProto, this.num_);
      FeedProtos.FeedProto.access$5502(feedProto, this.tabId_);
      FeedProtos.FeedProto.access$5602(feedProto, this.position_);
      FeedProtos.FeedProto.access$5702(feedProto, this.tagSource_);
      FeedProtos.FeedProto.access$5802(feedProto, this.isEssence_);
      FeedProtos.FeedProto.access$5902(feedProto, this.tabType_);
      FeedProtos.FeedProto.access$6002(feedProto, this.roomId_);
      FeedProtos.FeedProto.access$6102(feedProto, this.roomUid_);
      FeedProtos.FeedProto.access$6202(feedProto, this.id_);
      FeedProtos.FeedProto.access$6302(feedProto, this.iconType_);
      onBuilt();
      return feedProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.topicId_ = "";
      this.feedType_ = 0;
      this.feedFrom_ = 0;
      this.detailFrom_ = 0;
      this.feedId_ = "";
      this.keyword_ = "";
      this.feedFromPage_ = 0;
      this.interactiveType_ = 0;
      this.targetUid_ = "";
      this.location_ = 0;
      this.addType_ = 0;
      this.followLocation_ = 0;
      this.feedClass_ = 0;
      this.feedPage_ = 0;
      this.isFollow_ = false;
      this.feedTopicPage_ = 0;
      this.shareChannel_ = 0;
      this.linkFrom_ = 0;
      this.isLike_ = false;
      this.liveId_ = "";
      this.sourcePage_ = 0;
      this.isExposure_ = false;
      this.commentId_ = "";
      this.circleId_ = "";
      this.isJoin_ = false;
      this.circleSource_ = 0;
      this.noteId_ = "";
      this.isTop_ = false;
      this.noteSource_ = 0;
      this.optType_ = 0;
      this.linkUrl_ = "";
      this.isAt_ = false;
      this.isLive_ = false;
      this.noteType_ = 0;
      this.noteFrom_ = "";
      this.recommendType_ = "";
      this.isMulti_ = false;
      this.musicId_ = "";
      this.isCircleTop_ = false;
      this.isApply_ = false;
      this.isInvite_ = false;
      this.imageId_ = "";
      this.isAnonymousPublish_ = false;
      this.isAnonymousComment_ = false;
      this.userType_ = 0;
      this.taskId_ = "";
      this.isComment_ = false;
      this.num_ = 0;
      this.tabId_ = "";
      this.position_ = "";
      this.tagSource_ = 0;
      this.isEssence_ = false;
      this.tabType_ = 0;
      this.roomId_ = "";
      this.roomUid_ = "";
      this.id_ = "";
      this.iconType_ = "";
      return this;
    }
    
    public Builder clearAddType() {
      this.addType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearCircleId() {
      this.circleId_ = FeedProtos.FeedProto.getDefaultInstance().getCircleId();
      onChanged();
      return this;
    }
    
    public Builder clearCircleSource() {
      this.circleSource_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearCommentId() {
      this.commentId_ = FeedProtos.FeedProto.getDefaultInstance().getCommentId();
      onChanged();
      return this;
    }
    
    public Builder clearDetailFrom() {
      this.detailFrom_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedClass() {
      this.feedClass_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedFrom() {
      this.feedFrom_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedFromPage() {
      this.feedFromPage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedId() {
      this.feedId_ = FeedProtos.FeedProto.getDefaultInstance().getFeedId();
      onChanged();
      return this;
    }
    
    public Builder clearFeedPage() {
      this.feedPage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearFeedTopicPage() {
      this.feedTopicPage_ = 0;
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
    
    public Builder clearFollowLocation() {
      this.followLocation_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearIconType() {
      this.iconType_ = FeedProtos.FeedProto.getDefaultInstance().getIconType();
      onChanged();
      return this;
    }
    
    public Builder clearId() {
      this.id_ = FeedProtos.FeedProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearImageId() {
      this.imageId_ = FeedProtos.FeedProto.getDefaultInstance().getImageId();
      onChanged();
      return this;
    }
    
    public Builder clearInteractiveType() {
      this.interactiveType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearIsAnonymousComment() {
      this.isAnonymousComment_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsAnonymousPublish() {
      this.isAnonymousPublish_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsApply() {
      this.isApply_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsAt() {
      this.isAt_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsCircleTop() {
      this.isCircleTop_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsComment() {
      this.isComment_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsEssence() {
      this.isEssence_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsExposure() {
      this.isExposure_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsFollow() {
      this.isFollow_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsInvite() {
      this.isInvite_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsJoin() {
      this.isJoin_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsLike() {
      this.isLike_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsLive() {
      this.isLive_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsMulti() {
      this.isMulti_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsTop() {
      this.isTop_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearKeyword() {
      this.keyword_ = FeedProtos.FeedProto.getDefaultInstance().getKeyword();
      onChanged();
      return this;
    }
    
    public Builder clearLinkFrom() {
      this.linkFrom_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearLinkUrl() {
      this.linkUrl_ = FeedProtos.FeedProto.getDefaultInstance().getLinkUrl();
      onChanged();
      return this;
    }
    
    public Builder clearLiveId() {
      this.liveId_ = FeedProtos.FeedProto.getDefaultInstance().getLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearLocation() {
      this.location_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearMusicId() {
      this.musicId_ = FeedProtos.FeedProto.getDefaultInstance().getMusicId();
      onChanged();
      return this;
    }
    
    public Builder clearNoteFrom() {
      this.noteFrom_ = FeedProtos.FeedProto.getDefaultInstance().getNoteFrom();
      onChanged();
      return this;
    }
    
    public Builder clearNoteId() {
      this.noteId_ = FeedProtos.FeedProto.getDefaultInstance().getNoteId();
      onChanged();
      return this;
    }
    
    public Builder clearNoteSource() {
      this.noteSource_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearNoteType() {
      this.noteType_ = 0;
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
    
    public Builder clearOptType() {
      this.optType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPosition() {
      this.position_ = FeedProtos.FeedProto.getDefaultInstance().getPosition();
      onChanged();
      return this;
    }
    
    public Builder clearRecommendType() {
      this.recommendType_ = FeedProtos.FeedProto.getDefaultInstance().getRecommendType();
      onChanged();
      return this;
    }
    
    public Builder clearRoomId() {
      this.roomId_ = FeedProtos.FeedProto.getDefaultInstance().getRoomId();
      onChanged();
      return this;
    }
    
    public Builder clearRoomUid() {
      this.roomUid_ = FeedProtos.FeedProto.getDefaultInstance().getRoomUid();
      onChanged();
      return this;
    }
    
    public Builder clearShareChannel() {
      this.shareChannel_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSourcePage() {
      this.sourcePage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTabId() {
      this.tabId_ = FeedProtos.FeedProto.getDefaultInstance().getTabId();
      onChanged();
      return this;
    }
    
    public Builder clearTabType() {
      this.tabType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTagSource() {
      this.tagSource_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = FeedProtos.FeedProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clearTaskId() {
      this.taskId_ = FeedProtos.FeedProto.getDefaultInstance().getTaskId();
      onChanged();
      return this;
    }
    
    public Builder clearTopicId() {
      this.topicId_ = FeedProtos.FeedProto.getDefaultInstance().getTopicId();
      onChanged();
      return this;
    }
    
    public Builder clearUserType() {
      this.userType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public FeedProtos.AddType getAddType() {
      FeedProtos.AddType addType2 = FeedProtos.AddType.valueOf(this.addType_);
      FeedProtos.AddType addType1 = addType2;
      if (addType2 == null)
        addType1 = FeedProtos.AddType.UNRECOGNIZED; 
      return addType1;
    }
    
    public int getAddTypeValue() {
      return this.addType_;
    }
    
    public String getCircleId() {
      Object object = this.circleId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.circleId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCircleIdBytes() {
      Object object = this.circleId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.circleId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProtos.CircleSource getCircleSource() {
      FeedProtos.CircleSource circleSource2 = FeedProtos.CircleSource.valueOf(this.circleSource_);
      FeedProtos.CircleSource circleSource1 = circleSource2;
      if (circleSource2 == null)
        circleSource1 = FeedProtos.CircleSource.UNRECOGNIZED; 
      return circleSource1;
    }
    
    public int getCircleSourceValue() {
      return this.circleSource_;
    }
    
    public String getCommentId() {
      Object object = this.commentId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.commentId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCommentIdBytes() {
      Object object = this.commentId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.commentId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProtos.FeedProto getDefaultInstanceForType() {
      return FeedProtos.FeedProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_descriptor;
    }
    
    public FeedProtos.DetailFrom getDetailFrom() {
      FeedProtos.DetailFrom detailFrom2 = FeedProtos.DetailFrom.valueOf(this.detailFrom_);
      FeedProtos.DetailFrom detailFrom1 = detailFrom2;
      if (detailFrom2 == null)
        detailFrom1 = FeedProtos.DetailFrom.UNRECOGNIZED; 
      return detailFrom1;
    }
    
    public int getDetailFromValue() {
      return this.detailFrom_;
    }
    
    public FeedProtos.Event getEvent() {
      FeedProtos.Event event2 = FeedProtos.Event.valueOf(this.event_);
      FeedProtos.Event event1 = event2;
      if (event2 == null)
        event1 = FeedProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public FeedProtos.FeedClass getFeedClass() {
      FeedProtos.FeedClass feedClass2 = FeedProtos.FeedClass.valueOf(this.feedClass_);
      FeedProtos.FeedClass feedClass1 = feedClass2;
      if (feedClass2 == null)
        feedClass1 = FeedProtos.FeedClass.UNRECOGNIZED; 
      return feedClass1;
    }
    
    public int getFeedClassValue() {
      return this.feedClass_;
    }
    
    public FeedProtos.FeedFrom getFeedFrom() {
      FeedProtos.FeedFrom feedFrom2 = FeedProtos.FeedFrom.valueOf(this.feedFrom_);
      FeedProtos.FeedFrom feedFrom1 = feedFrom2;
      if (feedFrom2 == null)
        feedFrom1 = FeedProtos.FeedFrom.UNRECOGNIZED; 
      return feedFrom1;
    }
    
    public FeedProtos.FeedFromPage getFeedFromPage() {
      FeedProtos.FeedFromPage feedFromPage2 = FeedProtos.FeedFromPage.valueOf(this.feedFromPage_);
      FeedProtos.FeedFromPage feedFromPage1 = feedFromPage2;
      if (feedFromPage2 == null)
        feedFromPage1 = FeedProtos.FeedFromPage.UNRECOGNIZED; 
      return feedFromPage1;
    }
    
    public int getFeedFromPageValue() {
      return this.feedFromPage_;
    }
    
    public int getFeedFromValue() {
      return this.feedFrom_;
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
    
    public FeedProtos.FeedPage getFeedPage() {
      FeedProtos.FeedPage feedPage2 = FeedProtos.FeedPage.valueOf(this.feedPage_);
      FeedProtos.FeedPage feedPage1 = feedPage2;
      if (feedPage2 == null)
        feedPage1 = FeedProtos.FeedPage.UNRECOGNIZED; 
      return feedPage1;
    }
    
    public int getFeedPageValue() {
      return this.feedPage_;
    }
    
    public FeedProtos.FeedTopicPage getFeedTopicPage() {
      FeedProtos.FeedTopicPage feedTopicPage2 = FeedProtos.FeedTopicPage.valueOf(this.feedTopicPage_);
      FeedProtos.FeedTopicPage feedTopicPage1 = feedTopicPage2;
      if (feedTopicPage2 == null)
        feedTopicPage1 = FeedProtos.FeedTopicPage.UNRECOGNIZED; 
      return feedTopicPage1;
    }
    
    public int getFeedTopicPageValue() {
      return this.feedTopicPage_;
    }
    
    public FeedProtos.FeedType getFeedType() {
      FeedProtos.FeedType feedType2 = FeedProtos.FeedType.valueOf(this.feedType_);
      FeedProtos.FeedType feedType1 = feedType2;
      if (feedType2 == null)
        feedType1 = FeedProtos.FeedType.UNRECOGNIZED; 
      return feedType1;
    }
    
    public int getFeedTypeValue() {
      return this.feedType_;
    }
    
    public FeedProtos.FollowLocation getFollowLocation() {
      FeedProtos.FollowLocation followLocation2 = FeedProtos.FollowLocation.valueOf(this.followLocation_);
      FeedProtos.FollowLocation followLocation1 = followLocation2;
      if (followLocation2 == null)
        followLocation1 = FeedProtos.FollowLocation.UNRECOGNIZED; 
      return followLocation1;
    }
    
    public int getFollowLocationValue() {
      return this.followLocation_;
    }
    
    public String getIconType() {
      Object object = this.iconType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.iconType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIconTypeBytes() {
      Object object = this.iconType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.iconType_ = object;
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
    
    public FeedProtos.InteractiveType getInteractiveType() {
      FeedProtos.InteractiveType interactiveType2 = FeedProtos.InteractiveType.valueOf(this.interactiveType_);
      FeedProtos.InteractiveType interactiveType1 = interactiveType2;
      if (interactiveType2 == null)
        interactiveType1 = FeedProtos.InteractiveType.UNRECOGNIZED; 
      return interactiveType1;
    }
    
    public int getInteractiveTypeValue() {
      return this.interactiveType_;
    }
    
    public boolean getIsAnonymousComment() {
      return this.isAnonymousComment_;
    }
    
    public boolean getIsAnonymousPublish() {
      return this.isAnonymousPublish_;
    }
    
    public boolean getIsApply() {
      return this.isApply_;
    }
    
    public boolean getIsAt() {
      return this.isAt_;
    }
    
    public boolean getIsCircleTop() {
      return this.isCircleTop_;
    }
    
    public boolean getIsComment() {
      return this.isComment_;
    }
    
    public boolean getIsEssence() {
      return this.isEssence_;
    }
    
    public boolean getIsExposure() {
      return this.isExposure_;
    }
    
    public boolean getIsFollow() {
      return this.isFollow_;
    }
    
    public boolean getIsInvite() {
      return this.isInvite_;
    }
    
    public boolean getIsJoin() {
      return this.isJoin_;
    }
    
    public boolean getIsLike() {
      return this.isLike_;
    }
    
    public boolean getIsLive() {
      return this.isLive_;
    }
    
    public boolean getIsMulti() {
      return this.isMulti_;
    }
    
    public boolean getIsTop() {
      return this.isTop_;
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
    
    public FeedProtos.LinkFrom getLinkFrom() {
      FeedProtos.LinkFrom linkFrom2 = FeedProtos.LinkFrom.valueOf(this.linkFrom_);
      FeedProtos.LinkFrom linkFrom1 = linkFrom2;
      if (linkFrom2 == null)
        linkFrom1 = FeedProtos.LinkFrom.UNRECOGNIZED; 
      return linkFrom1;
    }
    
    public int getLinkFromValue() {
      return this.linkFrom_;
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
    
    public FeedProtos.Location getLocation() {
      FeedProtos.Location location2 = FeedProtos.Location.valueOf(this.location_);
      FeedProtos.Location location1 = location2;
      if (location2 == null)
        location1 = FeedProtos.Location.UNRECOGNIZED; 
      return location1;
    }
    
    public int getLocationValue() {
      return this.location_;
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
    
    public String getNoteFrom() {
      Object object = this.noteFrom_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.noteFrom_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNoteFromBytes() {
      Object object = this.noteFrom_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.noteFrom_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getNoteId() {
      Object object = this.noteId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.noteId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNoteIdBytes() {
      Object object = this.noteId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.noteId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProtos.NoteSource getNoteSource() {
      FeedProtos.NoteSource noteSource2 = FeedProtos.NoteSource.valueOf(this.noteSource_);
      FeedProtos.NoteSource noteSource1 = noteSource2;
      if (noteSource2 == null)
        noteSource1 = FeedProtos.NoteSource.UNRECOGNIZED; 
      return noteSource1;
    }
    
    public int getNoteSourceValue() {
      return this.noteSource_;
    }
    
    public FeedProtos.NoteType getNoteType() {
      FeedProtos.NoteType noteType2 = FeedProtos.NoteType.valueOf(this.noteType_);
      FeedProtos.NoteType noteType1 = noteType2;
      if (noteType2 == null)
        noteType1 = FeedProtos.NoteType.UNRECOGNIZED; 
      return noteType1;
    }
    
    public int getNoteTypeValue() {
      return this.noteType_;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public FeedProtos.OptType getOptType() {
      FeedProtos.OptType optType2 = FeedProtos.OptType.valueOf(this.optType_);
      FeedProtos.OptType optType1 = optType2;
      if (optType2 == null)
        optType1 = FeedProtos.OptType.UNRECOGNIZED; 
      return optType1;
    }
    
    public int getOptTypeValue() {
      return this.optType_;
    }
    
    public String getPosition() {
      Object object = this.position_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.position_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPositionBytes() {
      Object object = this.position_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.position_ = object;
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
    
    public FeedProtos.ShareChannel getShareChannel() {
      FeedProtos.ShareChannel shareChannel2 = FeedProtos.ShareChannel.valueOf(this.shareChannel_);
      FeedProtos.ShareChannel shareChannel1 = shareChannel2;
      if (shareChannel2 == null)
        shareChannel1 = FeedProtos.ShareChannel.UNRECOGNIZED; 
      return shareChannel1;
    }
    
    public int getShareChannelValue() {
      return this.shareChannel_;
    }
    
    public FeedProtos.SourcePage getSourcePage() {
      FeedProtos.SourcePage sourcePage2 = FeedProtos.SourcePage.valueOf(this.sourcePage_);
      FeedProtos.SourcePage sourcePage1 = sourcePage2;
      if (sourcePage2 == null)
        sourcePage1 = FeedProtos.SourcePage.UNRECOGNIZED; 
      return sourcePage1;
    }
    
    public int getSourcePageValue() {
      return this.sourcePage_;
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
    
    public FeedProtos.TabType getTabType() {
      FeedProtos.TabType tabType2 = FeedProtos.TabType.valueOf(this.tabType_);
      FeedProtos.TabType tabType1 = tabType2;
      if (tabType2 == null)
        tabType1 = FeedProtos.TabType.UNRECOGNIZED; 
      return tabType1;
    }
    
    public int getTabTypeValue() {
      return this.tabType_;
    }
    
    public FeedProtos.TagSource getTagSource() {
      FeedProtos.TagSource tagSource2 = FeedProtos.TagSource.valueOf(this.tagSource_);
      FeedProtos.TagSource tagSource1 = tagSource2;
      if (tagSource2 == null)
        tagSource1 = FeedProtos.TagSource.UNRECOGNIZED; 
      return tagSource1;
    }
    
    public int getTagSourceValue() {
      return this.tagSource_;
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
    
    public String getTopicId() {
      Object object = this.topicId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.topicId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTopicIdBytes() {
      Object object = this.topicId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.topicId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public FeedProtos.UserType getUserType() {
      FeedProtos.UserType userType2 = FeedProtos.UserType.valueOf(this.userType_);
      FeedProtos.UserType userType1 = userType2;
      if (userType2 == null)
        userType1 = FeedProtos.UserType.UNRECOGNIZED; 
      return userType1;
    }
    
    public int getUserTypeValue() {
      return this.userType_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return FeedProtos.internal_static_com_blued_das_client_feed_FeedProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FeedProtos.FeedProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(FeedProtos.FeedProto param1FeedProto) {
      if (param1FeedProto == FeedProtos.FeedProto.getDefaultInstance())
        return this; 
      if (param1FeedProto.event_ != 0)
        setEventValue(param1FeedProto.getEventValue()); 
      if (!param1FeedProto.getTopicId().isEmpty()) {
        this.topicId_ = param1FeedProto.topicId_;
        onChanged();
      } 
      if (param1FeedProto.feedType_ != 0)
        setFeedTypeValue(param1FeedProto.getFeedTypeValue()); 
      if (param1FeedProto.feedFrom_ != 0)
        setFeedFromValue(param1FeedProto.getFeedFromValue()); 
      if (param1FeedProto.detailFrom_ != 0)
        setDetailFromValue(param1FeedProto.getDetailFromValue()); 
      if (!param1FeedProto.getFeedId().isEmpty()) {
        this.feedId_ = param1FeedProto.feedId_;
        onChanged();
      } 
      if (!param1FeedProto.getKeyword().isEmpty()) {
        this.keyword_ = param1FeedProto.keyword_;
        onChanged();
      } 
      if (param1FeedProto.feedFromPage_ != 0)
        setFeedFromPageValue(param1FeedProto.getFeedFromPageValue()); 
      if (param1FeedProto.interactiveType_ != 0)
        setInteractiveTypeValue(param1FeedProto.getInteractiveTypeValue()); 
      if (!param1FeedProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1FeedProto.targetUid_;
        onChanged();
      } 
      if (param1FeedProto.location_ != 0)
        setLocationValue(param1FeedProto.getLocationValue()); 
      if (param1FeedProto.addType_ != 0)
        setAddTypeValue(param1FeedProto.getAddTypeValue()); 
      if (param1FeedProto.followLocation_ != 0)
        setFollowLocationValue(param1FeedProto.getFollowLocationValue()); 
      if (param1FeedProto.feedClass_ != 0)
        setFeedClassValue(param1FeedProto.getFeedClassValue()); 
      if (param1FeedProto.feedPage_ != 0)
        setFeedPageValue(param1FeedProto.getFeedPageValue()); 
      if (param1FeedProto.getIsFollow())
        setIsFollow(param1FeedProto.getIsFollow()); 
      if (param1FeedProto.feedTopicPage_ != 0)
        setFeedTopicPageValue(param1FeedProto.getFeedTopicPageValue()); 
      if (param1FeedProto.shareChannel_ != 0)
        setShareChannelValue(param1FeedProto.getShareChannelValue()); 
      if (param1FeedProto.linkFrom_ != 0)
        setLinkFromValue(param1FeedProto.getLinkFromValue()); 
      if (param1FeedProto.getIsLike())
        setIsLike(param1FeedProto.getIsLike()); 
      if (!param1FeedProto.getLiveId().isEmpty()) {
        this.liveId_ = param1FeedProto.liveId_;
        onChanged();
      } 
      if (param1FeedProto.sourcePage_ != 0)
        setSourcePageValue(param1FeedProto.getSourcePageValue()); 
      if (param1FeedProto.getIsExposure())
        setIsExposure(param1FeedProto.getIsExposure()); 
      if (!param1FeedProto.getCommentId().isEmpty()) {
        this.commentId_ = param1FeedProto.commentId_;
        onChanged();
      } 
      if (!param1FeedProto.getCircleId().isEmpty()) {
        this.circleId_ = param1FeedProto.circleId_;
        onChanged();
      } 
      if (param1FeedProto.getIsJoin())
        setIsJoin(param1FeedProto.getIsJoin()); 
      if (param1FeedProto.circleSource_ != 0)
        setCircleSourceValue(param1FeedProto.getCircleSourceValue()); 
      if (!param1FeedProto.getNoteId().isEmpty()) {
        this.noteId_ = param1FeedProto.noteId_;
        onChanged();
      } 
      if (param1FeedProto.getIsTop())
        setIsTop(param1FeedProto.getIsTop()); 
      if (param1FeedProto.noteSource_ != 0)
        setNoteSourceValue(param1FeedProto.getNoteSourceValue()); 
      if (param1FeedProto.optType_ != 0)
        setOptTypeValue(param1FeedProto.getOptTypeValue()); 
      if (!param1FeedProto.getLinkUrl().isEmpty()) {
        this.linkUrl_ = param1FeedProto.linkUrl_;
        onChanged();
      } 
      if (param1FeedProto.getIsAt())
        setIsAt(param1FeedProto.getIsAt()); 
      if (param1FeedProto.getIsLive())
        setIsLive(param1FeedProto.getIsLive()); 
      if (param1FeedProto.noteType_ != 0)
        setNoteTypeValue(param1FeedProto.getNoteTypeValue()); 
      if (!param1FeedProto.getNoteFrom().isEmpty()) {
        this.noteFrom_ = param1FeedProto.noteFrom_;
        onChanged();
      } 
      if (!param1FeedProto.getRecommendType().isEmpty()) {
        this.recommendType_ = param1FeedProto.recommendType_;
        onChanged();
      } 
      if (param1FeedProto.getIsMulti())
        setIsMulti(param1FeedProto.getIsMulti()); 
      if (!param1FeedProto.getMusicId().isEmpty()) {
        this.musicId_ = param1FeedProto.musicId_;
        onChanged();
      } 
      if (param1FeedProto.getIsCircleTop())
        setIsCircleTop(param1FeedProto.getIsCircleTop()); 
      if (param1FeedProto.getIsApply())
        setIsApply(param1FeedProto.getIsApply()); 
      if (param1FeedProto.getIsInvite())
        setIsInvite(param1FeedProto.getIsInvite()); 
      if (!param1FeedProto.getImageId().isEmpty()) {
        this.imageId_ = param1FeedProto.imageId_;
        onChanged();
      } 
      if (param1FeedProto.getIsAnonymousPublish())
        setIsAnonymousPublish(param1FeedProto.getIsAnonymousPublish()); 
      if (param1FeedProto.getIsAnonymousComment())
        setIsAnonymousComment(param1FeedProto.getIsAnonymousComment()); 
      if (param1FeedProto.userType_ != 0)
        setUserTypeValue(param1FeedProto.getUserTypeValue()); 
      if (!param1FeedProto.getTaskId().isEmpty()) {
        this.taskId_ = param1FeedProto.taskId_;
        onChanged();
      } 
      if (param1FeedProto.getIsComment())
        setIsComment(param1FeedProto.getIsComment()); 
      if (param1FeedProto.getNum() != 0)
        setNum(param1FeedProto.getNum()); 
      if (!param1FeedProto.getTabId().isEmpty()) {
        this.tabId_ = param1FeedProto.tabId_;
        onChanged();
      } 
      if (!param1FeedProto.getPosition().isEmpty()) {
        this.position_ = param1FeedProto.position_;
        onChanged();
      } 
      if (param1FeedProto.tagSource_ != 0)
        setTagSourceValue(param1FeedProto.getTagSourceValue()); 
      if (param1FeedProto.getIsEssence())
        setIsEssence(param1FeedProto.getIsEssence()); 
      if (param1FeedProto.tabType_ != 0)
        setTabTypeValue(param1FeedProto.getTabTypeValue()); 
      if (!param1FeedProto.getRoomId().isEmpty()) {
        this.roomId_ = param1FeedProto.roomId_;
        onChanged();
      } 
      if (!param1FeedProto.getRoomUid().isEmpty()) {
        this.roomUid_ = param1FeedProto.roomUid_;
        onChanged();
      } 
      if (!param1FeedProto.getId().isEmpty()) {
        this.id_ = param1FeedProto.id_;
        onChanged();
      } 
      if (!param1FeedProto.getIconType().isEmpty()) {
        this.iconType_ = param1FeedProto.iconType_;
        onChanged();
      } 
      mergeUnknownFields(param1FeedProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        FeedProtos.FeedProto feedProto = (FeedProtos.FeedProto)FeedProtos.FeedProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        FeedProtos.FeedProto feedProto = (FeedProtos.FeedProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((FeedProtos.FeedProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof FeedProtos.FeedProto)
        return mergeFrom((FeedProtos.FeedProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAddType(FeedProtos.AddType param1AddType) {
      if (param1AddType != null) {
        this.addType_ = param1AddType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAddTypeValue(int param1Int) {
      this.addType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setCircleId(String param1String) {
      if (param1String != null) {
        this.circleId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCircleIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.circleId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCircleSource(FeedProtos.CircleSource param1CircleSource) {
      if (param1CircleSource != null) {
        this.circleSource_ = param1CircleSource.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCircleSourceValue(int param1Int) {
      this.circleSource_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setCommentId(String param1String) {
      if (param1String != null) {
        this.commentId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCommentIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.commentId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDetailFrom(FeedProtos.DetailFrom param1DetailFrom) {
      if (param1DetailFrom != null) {
        this.detailFrom_ = param1DetailFrom.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDetailFromValue(int param1Int) {
      this.detailFrom_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setEvent(FeedProtos.Event param1Event) {
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
    
    public Builder setFeedClass(FeedProtos.FeedClass param1FeedClass) {
      if (param1FeedClass != null) {
        this.feedClass_ = param1FeedClass.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedClassValue(int param1Int) {
      this.feedClass_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setFeedFrom(FeedProtos.FeedFrom param1FeedFrom) {
      if (param1FeedFrom != null) {
        this.feedFrom_ = param1FeedFrom.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedFromPage(FeedProtos.FeedFromPage param1FeedFromPage) {
      if (param1FeedFromPage != null) {
        this.feedFromPage_ = param1FeedFromPage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedFromPageValue(int param1Int) {
      this.feedFromPage_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setFeedFromValue(int param1Int) {
      this.feedFrom_ = param1Int;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.feedId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedPage(FeedProtos.FeedPage param1FeedPage) {
      if (param1FeedPage != null) {
        this.feedPage_ = param1FeedPage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedPageValue(int param1Int) {
      this.feedPage_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setFeedTopicPage(FeedProtos.FeedTopicPage param1FeedTopicPage) {
      if (param1FeedTopicPage != null) {
        this.feedTopicPage_ = param1FeedTopicPage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFeedTopicPageValue(int param1Int) {
      this.feedTopicPage_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setFeedType(FeedProtos.FeedType param1FeedType) {
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
    
    public Builder setFollowLocation(FeedProtos.FollowLocation param1FollowLocation) {
      if (param1FollowLocation != null) {
        this.followLocation_ = param1FollowLocation.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setFollowLocationValue(int param1Int) {
      this.followLocation_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIconType(String param1String) {
      if (param1String != null) {
        this.iconType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIconTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.iconType_ = param1ByteString;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.imageId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setInteractiveType(FeedProtos.InteractiveType param1InteractiveType) {
      if (param1InteractiveType != null) {
        this.interactiveType_ = param1InteractiveType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setInteractiveTypeValue(int param1Int) {
      this.interactiveType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIsAnonymousComment(boolean param1Boolean) {
      this.isAnonymousComment_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsAnonymousPublish(boolean param1Boolean) {
      this.isAnonymousPublish_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsApply(boolean param1Boolean) {
      this.isApply_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsAt(boolean param1Boolean) {
      this.isAt_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsCircleTop(boolean param1Boolean) {
      this.isCircleTop_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsComment(boolean param1Boolean) {
      this.isComment_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsEssence(boolean param1Boolean) {
      this.isEssence_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsExposure(boolean param1Boolean) {
      this.isExposure_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsFollow(boolean param1Boolean) {
      this.isFollow_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsInvite(boolean param1Boolean) {
      this.isInvite_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsJoin(boolean param1Boolean) {
      this.isJoin_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsLike(boolean param1Boolean) {
      this.isLike_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsLive(boolean param1Boolean) {
      this.isLive_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsMulti(boolean param1Boolean) {
      this.isMulti_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsTop(boolean param1Boolean) {
      this.isTop_ = param1Boolean;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.keyword_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLinkFrom(FeedProtos.LinkFrom param1LinkFrom) {
      if (param1LinkFrom != null) {
        this.linkFrom_ = param1LinkFrom.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLinkFromValue(int param1Int) {
      this.linkFrom_ = param1Int;
      onChanged();
      return this;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.liveId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLocation(FeedProtos.Location param1Location) {
      if (param1Location != null) {
        this.location_ = param1Location.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLocationValue(int param1Int) {
      this.location_ = param1Int;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.musicId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteFrom(String param1String) {
      if (param1String != null) {
        this.noteFrom_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteFromBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.noteFrom_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteId(String param1String) {
      if (param1String != null) {
        this.noteId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.noteId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteSource(FeedProtos.NoteSource param1NoteSource) {
      if (param1NoteSource != null) {
        this.noteSource_ = param1NoteSource.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteSourceValue(int param1Int) {
      this.noteSource_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setNoteType(FeedProtos.NoteType param1NoteType) {
      if (param1NoteType != null) {
        this.noteType_ = param1NoteType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNoteTypeValue(int param1Int) {
      this.noteType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setNum(int param1Int) {
      this.num_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOptType(FeedProtos.OptType param1OptType) {
      if (param1OptType != null) {
        this.optType_ = param1OptType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOptTypeValue(int param1Int) {
      this.optType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPosition(String param1String) {
      if (param1String != null) {
        this.position_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPositionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.position_ = param1ByteString;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.recommendType_ = param1ByteString;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.roomUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setShareChannel(FeedProtos.ShareChannel param1ShareChannel) {
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
    
    public Builder setSourcePage(FeedProtos.SourcePage param1SourcePage) {
      if (param1SourcePage != null) {
        this.sourcePage_ = param1SourcePage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSourcePageValue(int param1Int) {
      this.sourcePage_ = param1Int;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.tabId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTabType(FeedProtos.TabType param1TabType) {
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
    
    public Builder setTagSource(FeedProtos.TagSource param1TagSource) {
      if (param1TagSource != null) {
        this.tagSource_ = param1TagSource.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTagSourceValue(int param1Int) {
      this.tagSource_ = param1Int;
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
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
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.taskId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTopicId(String param1String) {
      if (param1String != null) {
        this.topicId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTopicIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        FeedProtos.FeedProto.checkByteStringIsUtf8(param1ByteString);
        this.topicId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUserType(FeedProtos.UserType param1UserType) {
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
  }
  
  public static interface FeedProtoOrBuilder extends MessageOrBuilder {
    FeedProtos.AddType getAddType();
    
    int getAddTypeValue();
    
    String getCircleId();
    
    ByteString getCircleIdBytes();
    
    FeedProtos.CircleSource getCircleSource();
    
    int getCircleSourceValue();
    
    String getCommentId();
    
    ByteString getCommentIdBytes();
    
    FeedProtos.DetailFrom getDetailFrom();
    
    int getDetailFromValue();
    
    FeedProtos.Event getEvent();
    
    int getEventValue();
    
    FeedProtos.FeedClass getFeedClass();
    
    int getFeedClassValue();
    
    FeedProtos.FeedFrom getFeedFrom();
    
    FeedProtos.FeedFromPage getFeedFromPage();
    
    int getFeedFromPageValue();
    
    int getFeedFromValue();
    
    String getFeedId();
    
    ByteString getFeedIdBytes();
    
    FeedProtos.FeedPage getFeedPage();
    
    int getFeedPageValue();
    
    FeedProtos.FeedTopicPage getFeedTopicPage();
    
    int getFeedTopicPageValue();
    
    FeedProtos.FeedType getFeedType();
    
    int getFeedTypeValue();
    
    FeedProtos.FollowLocation getFollowLocation();
    
    int getFollowLocationValue();
    
    String getIconType();
    
    ByteString getIconTypeBytes();
    
    String getId();
    
    ByteString getIdBytes();
    
    String getImageId();
    
    ByteString getImageIdBytes();
    
    FeedProtos.InteractiveType getInteractiveType();
    
    int getInteractiveTypeValue();
    
    boolean getIsAnonymousComment();
    
    boolean getIsAnonymousPublish();
    
    boolean getIsApply();
    
    boolean getIsAt();
    
    boolean getIsCircleTop();
    
    boolean getIsComment();
    
    boolean getIsEssence();
    
    boolean getIsExposure();
    
    boolean getIsFollow();
    
    boolean getIsInvite();
    
    boolean getIsJoin();
    
    boolean getIsLike();
    
    boolean getIsLive();
    
    boolean getIsMulti();
    
    boolean getIsTop();
    
    String getKeyword();
    
    ByteString getKeywordBytes();
    
    FeedProtos.LinkFrom getLinkFrom();
    
    int getLinkFromValue();
    
    String getLinkUrl();
    
    ByteString getLinkUrlBytes();
    
    String getLiveId();
    
    ByteString getLiveIdBytes();
    
    FeedProtos.Location getLocation();
    
    int getLocationValue();
    
    String getMusicId();
    
    ByteString getMusicIdBytes();
    
    String getNoteFrom();
    
    ByteString getNoteFromBytes();
    
    String getNoteId();
    
    ByteString getNoteIdBytes();
    
    FeedProtos.NoteSource getNoteSource();
    
    int getNoteSourceValue();
    
    FeedProtos.NoteType getNoteType();
    
    int getNoteTypeValue();
    
    int getNum();
    
    FeedProtos.OptType getOptType();
    
    int getOptTypeValue();
    
    String getPosition();
    
    ByteString getPositionBytes();
    
    String getRecommendType();
    
    ByteString getRecommendTypeBytes();
    
    String getRoomId();
    
    ByteString getRoomIdBytes();
    
    String getRoomUid();
    
    ByteString getRoomUidBytes();
    
    FeedProtos.ShareChannel getShareChannel();
    
    int getShareChannelValue();
    
    FeedProtos.SourcePage getSourcePage();
    
    int getSourcePageValue();
    
    String getTabId();
    
    ByteString getTabIdBytes();
    
    FeedProtos.TabType getTabType();
    
    int getTabTypeValue();
    
    FeedProtos.TagSource getTagSource();
    
    int getTagSourceValue();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
    
    String getTaskId();
    
    ByteString getTaskIdBytes();
    
    String getTopicId();
    
    ByteString getTopicIdBytes();
    
    FeedProtos.UserType getUserType();
    
    int getUserTypeValue();
  }
  
  public enum FeedTopicPage implements ProtocolMessageEnum {
    FEED_TOPIC_FEED_DETAIL(0),
    FEED_TOPIC_FEED_LIST(0),
    UNKNOWN_FEED_TOPIC_PAGE(0),
    UNRECOGNIZED(0);
    
    public static final int FEED_TOPIC_FEED_DETAIL_VALUE = 1;
    
    public static final int FEED_TOPIC_FEED_LIST_VALUE = 2;
    
    public static final int UNKNOWN_FEED_TOPIC_PAGE_VALUE = 0;
    
    private static final FeedTopicPage[] VALUES;
    
    private static final Internal.EnumLiteMap<FeedTopicPage> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new FeedTopicPage[] { UNKNOWN_FEED_TOPIC_PAGE, FEED_TOPIC_FEED_DETAIL, FEED_TOPIC_FEED_LIST, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedTopicPage>() {
          public FeedProtos.FeedTopicPage findValueByNumber(int param2Int) {
            return FeedProtos.FeedTopicPage.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedTopicPage(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedTopicPage forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : FEED_TOPIC_FEED_LIST) : FEED_TOPIC_FEED_DETAIL) : UNKNOWN_FEED_TOPIC_PAGE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(11);
    }
    
    public static Internal.EnumLiteMap<FeedTopicPage> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FeedTopicPage> {
    public FeedProtos.FeedTopicPage findValueByNumber(int param1Int) {
      return FeedProtos.FeedTopicPage.forNumber(param1Int);
    }
  }
  
  public enum FeedType implements ProtocolMessageEnum {
    CIRCLE_NOTE(0),
    COMMON(0),
    SUPER_TOPIC(0),
    UNKNOWN_FEED_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_NOTE_VALUE = 3;
    
    public static final int COMMON_VALUE = 1;
    
    public static final int SUPER_TOPIC_VALUE = 2;
    
    public static final int UNKNOWN_FEED_TYPE_VALUE = 0;
    
    private static final FeedType[] VALUES;
    
    private static final Internal.EnumLiteMap<FeedType> internalValueMap;
    
    private final int value;
    
    static {
      CIRCLE_NOTE = new FeedType("CIRCLE_NOTE", 3, 3);
      UNRECOGNIZED = new FeedType("UNRECOGNIZED", 4, -1);
      $VALUES = new FeedType[] { UNKNOWN_FEED_TYPE, COMMON, SUPER_TOPIC, CIRCLE_NOTE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FeedType>() {
          public FeedProtos.FeedType findValueByNumber(int param2Int) {
            return FeedProtos.FeedType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FeedType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FeedType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : CIRCLE_NOTE) : SUPER_TOPIC) : COMMON) : UNKNOWN_FEED_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(1);
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
    public FeedProtos.FeedType findValueByNumber(int param1Int) {
      return FeedProtos.FeedType.forNumber(param1Int);
    }
  }
  
  public enum FollowLocation implements ProtocolMessageEnum {
    FOLLOW_FEED_DETAIL_MORE(0),
    FOLLOW_FEED_LIKE(0),
    FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND(0),
    FOLLOW_LIVE_USER_PHOTO(0),
    FOLLOW_MINE(0),
    FOLLOW_PLAZA_FEED_DETAIL(0),
    FOLLOW_PLAZA_FLASH(0),
    FOLLOW_PLAZA_FLASH_DETAIL(0),
    FOLLOW_PLAZA_IMAGE(0),
    FOLLOW_PLAZA_NEARBY(0),
    FOLLOW_PLAZA_RECOMMEND_FEED(0),
    FOLLOW_PLAZA_RECOMMEND_USER(0),
    FOLLOW_PROFILE_FANS_LIST(0),
    FOLLOW_PROFILE_FOLLOW_LIST(0),
    FOLLOW_SUPER_TOPIC_FEED(0),
    UNKNOWN_FOLLOW_LOCATION(0),
    UNRECOGNIZED(0);
    
    public static final int FOLLOW_FEED_DETAIL_MORE_VALUE = 15;
    
    public static final int FOLLOW_FEED_LIKE_VALUE = 14;
    
    public static final int FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND_VALUE = 9;
    
    public static final int FOLLOW_LIVE_USER_PHOTO_VALUE = 10;
    
    public static final int FOLLOW_MINE_VALUE = 11;
    
    public static final int FOLLOW_PLAZA_FEED_DETAIL_VALUE = 3;
    
    public static final int FOLLOW_PLAZA_FLASH_DETAIL_VALUE = 7;
    
    public static final int FOLLOW_PLAZA_FLASH_VALUE = 6;
    
    public static final int FOLLOW_PLAZA_IMAGE_VALUE = 8;
    
    public static final int FOLLOW_PLAZA_NEARBY_VALUE = 5;
    
    public static final int FOLLOW_PLAZA_RECOMMEND_FEED_VALUE = 2;
    
    public static final int FOLLOW_PLAZA_RECOMMEND_USER_VALUE = 4;
    
    public static final int FOLLOW_PROFILE_FANS_LIST_VALUE = 12;
    
    public static final int FOLLOW_PROFILE_FOLLOW_LIST_VALUE = 13;
    
    public static final int FOLLOW_SUPER_TOPIC_FEED_VALUE = 1;
    
    public static final int UNKNOWN_FOLLOW_LOCATION_VALUE = 0;
    
    private static final FollowLocation[] VALUES;
    
    private static final Internal.EnumLiteMap<FollowLocation> internalValueMap;
    
    private final int value;
    
    static {
      FOLLOW_PLAZA_RECOMMEND_FEED = new FollowLocation("FOLLOW_PLAZA_RECOMMEND_FEED", 2, 2);
      FOLLOW_PLAZA_FEED_DETAIL = new FollowLocation("FOLLOW_PLAZA_FEED_DETAIL", 3, 3);
      FOLLOW_PLAZA_RECOMMEND_USER = new FollowLocation("FOLLOW_PLAZA_RECOMMEND_USER", 4, 4);
      FOLLOW_PLAZA_NEARBY = new FollowLocation("FOLLOW_PLAZA_NEARBY", 5, 5);
      FOLLOW_PLAZA_FLASH = new FollowLocation("FOLLOW_PLAZA_FLASH", 6, 6);
      FOLLOW_PLAZA_FLASH_DETAIL = new FollowLocation("FOLLOW_PLAZA_FLASH_DETAIL", 7, 7);
      FOLLOW_PLAZA_IMAGE = new FollowLocation("FOLLOW_PLAZA_IMAGE", 8, 8);
      FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND = new FollowLocation("FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND", 9, 9);
      FOLLOW_LIVE_USER_PHOTO = new FollowLocation("FOLLOW_LIVE_USER_PHOTO", 10, 10);
      FOLLOW_MINE = new FollowLocation("FOLLOW_MINE", 11, 11);
      FOLLOW_PROFILE_FANS_LIST = new FollowLocation("FOLLOW_PROFILE_FANS_LIST", 12, 12);
      FOLLOW_PROFILE_FOLLOW_LIST = new FollowLocation("FOLLOW_PROFILE_FOLLOW_LIST", 13, 13);
      FOLLOW_FEED_LIKE = new FollowLocation("FOLLOW_FEED_LIKE", 14, 14);
      FOLLOW_FEED_DETAIL_MORE = new FollowLocation("FOLLOW_FEED_DETAIL_MORE", 15, 15);
      UNRECOGNIZED = new FollowLocation("UNRECOGNIZED", 16, -1);
      $VALUES = new FollowLocation[] { 
          UNKNOWN_FOLLOW_LOCATION, FOLLOW_SUPER_TOPIC_FEED, FOLLOW_PLAZA_RECOMMEND_FEED, FOLLOW_PLAZA_FEED_DETAIL, FOLLOW_PLAZA_RECOMMEND_USER, FOLLOW_PLAZA_NEARBY, FOLLOW_PLAZA_FLASH, FOLLOW_PLAZA_FLASH_DETAIL, FOLLOW_PLAZA_IMAGE, FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND, 
          FOLLOW_LIVE_USER_PHOTO, FOLLOW_MINE, FOLLOW_PROFILE_FANS_LIST, FOLLOW_PROFILE_FOLLOW_LIST, FOLLOW_FEED_LIKE, FOLLOW_FEED_DETAIL_MORE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FollowLocation>() {
          public FeedProtos.FollowLocation findValueByNumber(int param2Int) {
            return FeedProtos.FollowLocation.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FollowLocation(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FollowLocation forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 15:
          return FOLLOW_FEED_DETAIL_MORE;
        case 14:
          return FOLLOW_FEED_LIKE;
        case 13:
          return FOLLOW_PROFILE_FOLLOW_LIST;
        case 12:
          return FOLLOW_PROFILE_FANS_LIST;
        case 11:
          return FOLLOW_MINE;
        case 10:
          return FOLLOW_LIVE_USER_PHOTO;
        case 9:
          return FOLLOW_LIVE_ANCHOR_PHOTO_BEHIND;
        case 8:
          return FOLLOW_PLAZA_IMAGE;
        case 7:
          return FOLLOW_PLAZA_FLASH_DETAIL;
        case 6:
          return FOLLOW_PLAZA_FLASH;
        case 5:
          return FOLLOW_PLAZA_NEARBY;
        case 4:
          return FOLLOW_PLAZA_RECOMMEND_USER;
        case 3:
          return FOLLOW_PLAZA_FEED_DETAIL;
        case 2:
          return FOLLOW_PLAZA_RECOMMEND_FEED;
        case 1:
          return FOLLOW_SUPER_TOPIC_FEED;
        case 0:
          break;
      } 
      return UNKNOWN_FOLLOW_LOCATION;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(8);
    }
    
    public static Internal.EnumLiteMap<FollowLocation> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FollowLocation> {
    public FeedProtos.FollowLocation findValueByNumber(int param1Int) {
      return FeedProtos.FollowLocation.forNumber(param1Int);
    }
  }
  
  public enum InteractiveType implements ProtocolMessageEnum {
    COMMENT(0),
    FORWARD(0),
    LIKE(0),
    LOOK_PHOTO(0),
    NO_LIKE(0),
    UNKNOWN_INTERACTIVE_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int COMMENT_VALUE = 2;
    
    public static final int FORWARD_VALUE = 3;
    
    public static final int LIKE_VALUE = 1;
    
    public static final int LOOK_PHOTO_VALUE = 4;
    
    public static final int NO_LIKE_VALUE = 5;
    
    public static final int UNKNOWN_INTERACTIVE_TYPE_VALUE = 0;
    
    private static final InteractiveType[] VALUES;
    
    private static final Internal.EnumLiteMap<InteractiveType> internalValueMap;
    
    private final int value;
    
    static {
      COMMENT = new InteractiveType("COMMENT", 2, 2);
      FORWARD = new InteractiveType("FORWARD", 3, 3);
      LOOK_PHOTO = new InteractiveType("LOOK_PHOTO", 4, 4);
      NO_LIKE = new InteractiveType("NO_LIKE", 5, 5);
      UNRECOGNIZED = new InteractiveType("UNRECOGNIZED", 6, -1);
      $VALUES = new InteractiveType[] { UNKNOWN_INTERACTIVE_TYPE, LIKE, COMMENT, FORWARD, LOOK_PHOTO, NO_LIKE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<InteractiveType>() {
          public FeedProtos.InteractiveType findValueByNumber(int param2Int) {
            return FeedProtos.InteractiveType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    InteractiveType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static InteractiveType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : NO_LIKE) : LOOK_PHOTO) : FORWARD) : COMMENT) : LIKE) : UNKNOWN_INTERACTIVE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(5);
    }
    
    public static Internal.EnumLiteMap<InteractiveType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<InteractiveType> {
    public FeedProtos.InteractiveType findValueByNumber(int param1Int) {
      return FeedProtos.InteractiveType.forNumber(param1Int);
    }
  }
  
  public enum LinkFrom implements ProtocolMessageEnum {
    FEED_LINK(0),
    MSG_LINK(0),
    UNKNOWN_LINK_FROM(0),
    UNRECOGNIZED(0);
    
    public static final int FEED_LINK_VALUE = 1;
    
    public static final int MSG_LINK_VALUE = 2;
    
    public static final int UNKNOWN_LINK_FROM_VALUE = 0;
    
    private static final LinkFrom[] VALUES;
    
    private static final Internal.EnumLiteMap<LinkFrom> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new LinkFrom[] { UNKNOWN_LINK_FROM, FEED_LINK, MSG_LINK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<LinkFrom>() {
          public FeedProtos.LinkFrom findValueByNumber(int param2Int) {
            return FeedProtos.LinkFrom.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    LinkFrom(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static LinkFrom forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : MSG_LINK) : FEED_LINK) : UNKNOWN_LINK_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(13);
    }
    
    public static Internal.EnumLiteMap<LinkFrom> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<LinkFrom> {
    public FeedProtos.LinkFrom findValueByNumber(int param1Int) {
      return FeedProtos.LinkFrom.forNumber(param1Int);
    }
  }
  
  public enum Location implements ProtocolMessageEnum {
    COMMENT_DETAIL(0),
    FEED_DETAIL(0),
    UNKNOWN_LOCATION(0),
    UNRECOGNIZED(0);
    
    public static final int COMMENT_DETAIL_VALUE = 2;
    
    public static final int FEED_DETAIL_VALUE = 1;
    
    public static final int UNKNOWN_LOCATION_VALUE = 0;
    
    private static final Location[] VALUES;
    
    private static final Internal.EnumLiteMap<Location> internalValueMap;
    
    private final int value;
    
    static {
      COMMENT_DETAIL = new Location("COMMENT_DETAIL", 2, 2);
      UNRECOGNIZED = new Location("UNRECOGNIZED", 3, -1);
      $VALUES = new Location[] { UNKNOWN_LOCATION, FEED_DETAIL, COMMENT_DETAIL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Location>() {
          public FeedProtos.Location findValueByNumber(int param2Int) {
            return FeedProtos.Location.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Location(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Location forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : COMMENT_DETAIL) : FEED_DETAIL) : UNKNOWN_LOCATION;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(6);
    }
    
    public static Internal.EnumLiteMap<Location> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<Location> {
    public FeedProtos.Location findValueByNumber(int param1Int) {
      return FeedProtos.Location.forNumber(param1Int);
    }
  }
  
  public enum NoteSource implements ProtocolMessageEnum {
    CIRCLE_ESSENCE(0),
    CIRCLE_HOT(0),
    CIRCLE_NEW(0),
    CIRCLE_RECOMMEND_LIST(0),
    CIRCLE_RECOMMEND_NOTE(0),
    CIRCLE_TOP(0),
    CITY_BANNER_NOTE(0),
    CITY_NOTE(0),
    NOTE_COMMENT_DETAIL(0),
    NOTE_DETAIL(0),
    NOTE_DETAIL_BOTTOM(0),
    NOTE_DETAIL_COMMENT_LIST(0),
    NOTE_LIST(0),
    NOTICE_COMMENT_AT(0),
    NOTICE_COMMENT_ENTER(0),
    NOTICE_LIKE_ENTER(0),
    NOTIFICATION(0),
    PERSONAL_PROFILE(0),
    PUSH_NOTIFICATION(0),
    RECOMMEND_BANNER_NOTE(0),
    UNKNOWN_NOTE_SOURCE(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_ESSENCE_VALUE = 16;
    
    public static final int CIRCLE_HOT_VALUE = 5;
    
    public static final int CIRCLE_NEW_VALUE = 4;
    
    public static final int CIRCLE_RECOMMEND_LIST_VALUE = 1;
    
    public static final int CIRCLE_RECOMMEND_NOTE_VALUE = 10;
    
    public static final int CIRCLE_TOP_VALUE = 3;
    
    public static final int CITY_BANNER_NOTE_VALUE = 12;
    
    public static final int CITY_NOTE_VALUE = 11;
    
    public static final int NOTE_COMMENT_DETAIL_VALUE = 7;
    
    public static final int NOTE_DETAIL_BOTTOM_VALUE = 9;
    
    public static final int NOTE_DETAIL_COMMENT_LIST_VALUE = 8;
    
    public static final int NOTE_DETAIL_VALUE = 6;
    
    public static final int NOTE_LIST_VALUE = 2;
    
    public static final int NOTICE_COMMENT_AT_VALUE = 21;
    
    public static final int NOTICE_COMMENT_ENTER_VALUE = 15;
    
    public static final int NOTICE_LIKE_ENTER_VALUE = 14;
    
    public static final int NOTIFICATION_VALUE = 20;
    
    public static final int PERSONAL_PROFILE_VALUE = 18;
    
    public static final int PUSH_NOTIFICATION_VALUE = 19;
    
    public static final int RECOMMEND_BANNER_NOTE_VALUE = 13;
    
    public static final int UNKNOWN_NOTE_SOURCE_VALUE = 0;
    
    private static final NoteSource[] VALUES;
    
    private static final Internal.EnumLiteMap<NoteSource> internalValueMap;
    
    private final int value;
    
    static {
      CIRCLE_TOP = new NoteSource("CIRCLE_TOP", 3, 3);
      CIRCLE_NEW = new NoteSource("CIRCLE_NEW", 4, 4);
      CIRCLE_HOT = new NoteSource("CIRCLE_HOT", 5, 5);
      NOTE_DETAIL = new NoteSource("NOTE_DETAIL", 6, 6);
      NOTE_COMMENT_DETAIL = new NoteSource("NOTE_COMMENT_DETAIL", 7, 7);
      NOTE_DETAIL_COMMENT_LIST = new NoteSource("NOTE_DETAIL_COMMENT_LIST", 8, 8);
      NOTE_DETAIL_BOTTOM = new NoteSource("NOTE_DETAIL_BOTTOM", 9, 9);
      CIRCLE_RECOMMEND_NOTE = new NoteSource("CIRCLE_RECOMMEND_NOTE", 10, 10);
      CITY_NOTE = new NoteSource("CITY_NOTE", 11, 11);
      CITY_BANNER_NOTE = new NoteSource("CITY_BANNER_NOTE", 12, 12);
      RECOMMEND_BANNER_NOTE = new NoteSource("RECOMMEND_BANNER_NOTE", 13, 13);
      NOTICE_LIKE_ENTER = new NoteSource("NOTICE_LIKE_ENTER", 14, 14);
      NOTICE_COMMENT_ENTER = new NoteSource("NOTICE_COMMENT_ENTER", 15, 15);
      CIRCLE_ESSENCE = new NoteSource("CIRCLE_ESSENCE", 16, 16);
      PERSONAL_PROFILE = new NoteSource("PERSONAL_PROFILE", 17, 18);
      PUSH_NOTIFICATION = new NoteSource("PUSH_NOTIFICATION", 18, 19);
      NOTIFICATION = new NoteSource("NOTIFICATION", 19, 20);
      NOTICE_COMMENT_AT = new NoteSource("NOTICE_COMMENT_AT", 20, 21);
      UNRECOGNIZED = new NoteSource("UNRECOGNIZED", 21, -1);
      $VALUES = new NoteSource[] { 
          UNKNOWN_NOTE_SOURCE, CIRCLE_RECOMMEND_LIST, NOTE_LIST, CIRCLE_TOP, CIRCLE_NEW, CIRCLE_HOT, NOTE_DETAIL, NOTE_COMMENT_DETAIL, NOTE_DETAIL_COMMENT_LIST, NOTE_DETAIL_BOTTOM, 
          CIRCLE_RECOMMEND_NOTE, CITY_NOTE, CITY_BANNER_NOTE, RECOMMEND_BANNER_NOTE, NOTICE_LIKE_ENTER, NOTICE_COMMENT_ENTER, CIRCLE_ESSENCE, PERSONAL_PROFILE, PUSH_NOTIFICATION, NOTIFICATION, 
          NOTICE_COMMENT_AT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<NoteSource>() {
          public FeedProtos.NoteSource findValueByNumber(int param2Int) {
            return FeedProtos.NoteSource.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    NoteSource(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static NoteSource forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 21:
          return NOTICE_COMMENT_AT;
        case 20:
          return NOTIFICATION;
        case 19:
          return PUSH_NOTIFICATION;
        case 18:
          return PERSONAL_PROFILE;
        case 16:
          return CIRCLE_ESSENCE;
        case 15:
          return NOTICE_COMMENT_ENTER;
        case 14:
          return NOTICE_LIKE_ENTER;
        case 13:
          return RECOMMEND_BANNER_NOTE;
        case 12:
          return CITY_BANNER_NOTE;
        case 11:
          return CITY_NOTE;
        case 10:
          return CIRCLE_RECOMMEND_NOTE;
        case 9:
          return NOTE_DETAIL_BOTTOM;
        case 8:
          return NOTE_DETAIL_COMMENT_LIST;
        case 7:
          return NOTE_COMMENT_DETAIL;
        case 6:
          return NOTE_DETAIL;
        case 5:
          return CIRCLE_HOT;
        case 4:
          return CIRCLE_NEW;
        case 3:
          return CIRCLE_TOP;
        case 2:
          return NOTE_LIST;
        case 1:
          return CIRCLE_RECOMMEND_LIST;
        case 0:
          break;
      } 
      return UNKNOWN_NOTE_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(16);
    }
    
    public static Internal.EnumLiteMap<NoteSource> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<NoteSource> {
    public FeedProtos.NoteSource findValueByNumber(int param1Int) {
      return FeedProtos.NoteSource.forNumber(param1Int);
    }
  }
  
  public enum NoteType implements ProtocolMessageEnum {
    NOTE_COMMON(0),
    NOTE_LINK(0),
    NOTE_MIX(0),
    NOTE_VIDEO(0),
    UNKNOWN_NOTE_TYPE(0),
    UNRECOGNIZED(0),
    VOTE_TEXT(0);
    
    public static final int NOTE_COMMON_VALUE = 1;
    
    public static final int NOTE_LINK_VALUE = 5;
    
    public static final int NOTE_MIX_VALUE = 2;
    
    public static final int NOTE_VIDEO_VALUE = 4;
    
    public static final int UNKNOWN_NOTE_TYPE_VALUE = 0;
    
    private static final NoteType[] VALUES;
    
    public static final int VOTE_TEXT_VALUE = 3;
    
    private static final Internal.EnumLiteMap<NoteType> internalValueMap;
    
    private final int value;
    
    static {
      NOTE_VIDEO = new NoteType("NOTE_VIDEO", 4, 4);
      NOTE_LINK = new NoteType("NOTE_LINK", 5, 5);
      UNRECOGNIZED = new NoteType("UNRECOGNIZED", 6, -1);
      $VALUES = new NoteType[] { UNKNOWN_NOTE_TYPE, NOTE_COMMON, NOTE_MIX, VOTE_TEXT, NOTE_VIDEO, NOTE_LINK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<NoteType>() {
          public FeedProtos.NoteType findValueByNumber(int param2Int) {
            return FeedProtos.NoteType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    NoteType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static NoteType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : NOTE_LINK) : NOTE_VIDEO) : VOTE_TEXT) : NOTE_MIX) : NOTE_COMMON) : UNKNOWN_NOTE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(18);
    }
    
    public static Internal.EnumLiteMap<NoteType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<NoteType> {
    public FeedProtos.NoteType findValueByNumber(int param1Int) {
      return FeedProtos.NoteType.forNumber(param1Int);
    }
  }
  
  public enum OptType implements ProtocolMessageEnum {
    OPT_CANCEL(0),
    OPT_DELETE(0),
    OPT_FORB(0),
    OPT_REPORT(0),
    OPT_TOP(0),
    UNKNOWN_OPT_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int OPT_CANCEL_VALUE = 5;
    
    public static final int OPT_DELETE_VALUE = 3;
    
    public static final int OPT_FORB_VALUE = 2;
    
    public static final int OPT_REPORT_VALUE = 4;
    
    public static final int OPT_TOP_VALUE = 1;
    
    public static final int UNKNOWN_OPT_TYPE_VALUE = 0;
    
    private static final OptType[] VALUES;
    
    private static final Internal.EnumLiteMap<OptType> internalValueMap;
    
    private final int value;
    
    static {
      OPT_FORB = new OptType("OPT_FORB", 2, 2);
      OPT_DELETE = new OptType("OPT_DELETE", 3, 3);
      OPT_REPORT = new OptType("OPT_REPORT", 4, 4);
      OPT_CANCEL = new OptType("OPT_CANCEL", 5, 5);
      UNRECOGNIZED = new OptType("UNRECOGNIZED", 6, -1);
      $VALUES = new OptType[] { UNKNOWN_OPT_TYPE, OPT_TOP, OPT_FORB, OPT_DELETE, OPT_REPORT, OPT_CANCEL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<OptType>() {
          public FeedProtos.OptType findValueByNumber(int param2Int) {
            return FeedProtos.OptType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    OptType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OptType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : OPT_CANCEL) : OPT_REPORT) : OPT_DELETE) : OPT_FORB) : OPT_TOP) : UNKNOWN_OPT_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(17);
    }
    
    public static Internal.EnumLiteMap<OptType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<OptType> {
    public FeedProtos.OptType findValueByNumber(int param1Int) {
      return FeedProtos.OptType.forNumber(param1Int);
    }
  }
  
  public enum ShareChannel implements ProtocolMessageEnum {
    SHARE_FEED(0),
    SHARE_FORWARD(0),
    SHARE_FRIEND(0),
    SHARE_FRIEND_CLUB(0),
    SHARE_QQ(0),
    SHARE_WECHAT(0),
    SHARE_WEIBO(0),
    UNKNOWN_SHARE_CHANNEL(0),
    UNRECOGNIZED(0);
    
    public static final int SHARE_FEED_VALUE = 7;
    
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
      SHARE_FEED = new ShareChannel("SHARE_FEED", 7, 7);
      UNRECOGNIZED = new ShareChannel("UNRECOGNIZED", 8, -1);
      $VALUES = new ShareChannel[] { UNKNOWN_SHARE_CHANNEL, SHARE_FORWARD, SHARE_FRIEND, SHARE_WECHAT, SHARE_QQ, SHARE_WEIBO, SHARE_FRIEND_CLUB, SHARE_FEED, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ShareChannel>() {
          public FeedProtos.ShareChannel findValueByNumber(int param2Int) {
            return FeedProtos.ShareChannel.forNumber(param2Int);
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
        case 7:
          return SHARE_FEED;
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
      return FeedProtos.getDescriptor().getEnumTypes().get(12);
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
    public FeedProtos.ShareChannel findValueByNumber(int param1Int) {
      return FeedProtos.ShareChannel.forNumber(param1Int);
    }
  }
  
  public enum SourcePage implements ProtocolMessageEnum {
    CIRCLE_HOME_RECOMMEND(0),
    CITY_NOTE_PAGE(0),
    FEED_DETAIL_PAGE(0),
    FEED_PERSONAL_FEED(0),
    FEED_PERSONAL_FEED_DETAIL(0),
    FEED_PERSONAL_MORE(0),
    FEED_PLAY(0),
    FEED_PLAZA_FLASH(0),
    FEED_PLAZA_FLASH_DETAIL(0),
    FEED_PLAZA_FOLLOW(0),
    FEED_PLAZA_FOLLOW_DETAIL(0),
    FEED_PLAZA_IMAGE(0),
    FEED_PLAZA_IMAGE_DETAIL(0),
    FEED_PLAZA_NEARBY(0),
    FEED_PLAZA_NEARBY_DETAIL(0),
    FEED_PLAZA_RECOMMEND(0),
    FEED_PLAZA_RECOMMEND_DETAIL(0),
    FEED_PLAZA_RECOMMEND_MORE(0),
    FEED_SUPER_TOPIC_FEED(0),
    FEED_SUPER_TOPIC_FEED_DETAIL(0),
    MINE_CIRCLE(0),
    NOTE_DETAIL_SHARE(0),
    ONE_CITY(0),
    PAGE_FEED_DETAIL_MORE(0),
    PAGE_FEED_LIKE(0),
    PAGE_FEED_MINE(0),
    PAGE_FIND_TOPIC_HOME(0),
    PLAZA_RECOMMEND_NOTE_SHARE(0),
    SHARE_LIVE(0),
    SHARE_MINE_BABY(0),
    SHARE_MINE_DANLAN(0),
    SHARE_MINE_EMOJI(0),
    SHARE_MINE_HEER(0),
    UNKNOWN_SOURCE_PAGE(0),
    UNRECOGNIZED(0);
    
    public static final int CIRCLE_HOME_RECOMMEND_VALUE = 32;
    
    public static final int CITY_NOTE_PAGE_VALUE = 29;
    
    public static final int FEED_DETAIL_PAGE_VALUE = 8;
    
    public static final int FEED_PERSONAL_FEED_DETAIL_VALUE = 28;
    
    public static final int FEED_PERSONAL_FEED_VALUE = 7;
    
    public static final int FEED_PERSONAL_MORE_VALUE = 10;
    
    public static final int FEED_PLAY_VALUE = 9;
    
    public static final int FEED_PLAZA_FLASH_DETAIL_VALUE = 24;
    
    public static final int FEED_PLAZA_FLASH_VALUE = 4;
    
    public static final int FEED_PLAZA_FOLLOW_DETAIL_VALUE = 23;
    
    public static final int FEED_PLAZA_FOLLOW_VALUE = 2;
    
    public static final int FEED_PLAZA_IMAGE_DETAIL_VALUE = 25;
    
    public static final int FEED_PLAZA_IMAGE_VALUE = 5;
    
    public static final int FEED_PLAZA_NEARBY_DETAIL_VALUE = 26;
    
    public static final int FEED_PLAZA_NEARBY_VALUE = 3;
    
    public static final int FEED_PLAZA_RECOMMEND_DETAIL_VALUE = 22;
    
    public static final int FEED_PLAZA_RECOMMEND_MORE_VALUE = 33;
    
    public static final int FEED_PLAZA_RECOMMEND_VALUE = 1;
    
    public static final int FEED_SUPER_TOPIC_FEED_DETAIL_VALUE = 27;
    
    public static final int FEED_SUPER_TOPIC_FEED_VALUE = 6;
    
    public static final int MINE_CIRCLE_VALUE = 31;
    
    public static final int NOTE_DETAIL_SHARE_VALUE = 20;
    
    public static final int ONE_CITY_VALUE = 19;
    
    public static final int PAGE_FEED_DETAIL_MORE_VALUE = 18;
    
    public static final int PAGE_FEED_LIKE_VALUE = 17;
    
    public static final int PAGE_FEED_MINE_VALUE = 16;
    
    public static final int PAGE_FIND_TOPIC_HOME_VALUE = 30;
    
    public static final int PLAZA_RECOMMEND_NOTE_SHARE_VALUE = 21;
    
    public static final int SHARE_LIVE_VALUE = 11;
    
    public static final int SHARE_MINE_BABY_VALUE = 14;
    
    public static final int SHARE_MINE_DANLAN_VALUE = 12;
    
    public static final int SHARE_MINE_EMOJI_VALUE = 15;
    
    public static final int SHARE_MINE_HEER_VALUE = 13;
    
    public static final int UNKNOWN_SOURCE_PAGE_VALUE = 0;
    
    private static final SourcePage[] VALUES;
    
    private static final Internal.EnumLiteMap<SourcePage> internalValueMap;
    
    private final int value;
    
    static {
      FEED_PLAZA_FOLLOW = new SourcePage("FEED_PLAZA_FOLLOW", 2, 2);
      FEED_PLAZA_NEARBY = new SourcePage("FEED_PLAZA_NEARBY", 3, 3);
      FEED_PLAZA_FLASH = new SourcePage("FEED_PLAZA_FLASH", 4, 4);
      FEED_PLAZA_IMAGE = new SourcePage("FEED_PLAZA_IMAGE", 5, 5);
      FEED_SUPER_TOPIC_FEED = new SourcePage("FEED_SUPER_TOPIC_FEED", 6, 6);
      FEED_PERSONAL_FEED = new SourcePage("FEED_PERSONAL_FEED", 7, 7);
      FEED_DETAIL_PAGE = new SourcePage("FEED_DETAIL_PAGE", 8, 8);
      FEED_PLAY = new SourcePage("FEED_PLAY", 9, 9);
      FEED_PERSONAL_MORE = new SourcePage("FEED_PERSONAL_MORE", 10, 10);
      SHARE_LIVE = new SourcePage("SHARE_LIVE", 11, 11);
      SHARE_MINE_DANLAN = new SourcePage("SHARE_MINE_DANLAN", 12, 12);
      SHARE_MINE_HEER = new SourcePage("SHARE_MINE_HEER", 13, 13);
      SHARE_MINE_BABY = new SourcePage("SHARE_MINE_BABY", 14, 14);
      SHARE_MINE_EMOJI = new SourcePage("SHARE_MINE_EMOJI", 15, 15);
      PAGE_FEED_MINE = new SourcePage("PAGE_FEED_MINE", 16, 16);
      PAGE_FEED_LIKE = new SourcePage("PAGE_FEED_LIKE", 17, 17);
      PAGE_FEED_DETAIL_MORE = new SourcePage("PAGE_FEED_DETAIL_MORE", 18, 18);
      ONE_CITY = new SourcePage("ONE_CITY", 19, 19);
      NOTE_DETAIL_SHARE = new SourcePage("NOTE_DETAIL_SHARE", 20, 20);
      PLAZA_RECOMMEND_NOTE_SHARE = new SourcePage("PLAZA_RECOMMEND_NOTE_SHARE", 21, 21);
      FEED_PLAZA_RECOMMEND_DETAIL = new SourcePage("FEED_PLAZA_RECOMMEND_DETAIL", 22, 22);
      FEED_PLAZA_FOLLOW_DETAIL = new SourcePage("FEED_PLAZA_FOLLOW_DETAIL", 23, 23);
      FEED_PLAZA_FLASH_DETAIL = new SourcePage("FEED_PLAZA_FLASH_DETAIL", 24, 24);
      FEED_PLAZA_IMAGE_DETAIL = new SourcePage("FEED_PLAZA_IMAGE_DETAIL", 25, 25);
      FEED_PLAZA_NEARBY_DETAIL = new SourcePage("FEED_PLAZA_NEARBY_DETAIL", 26, 26);
      FEED_SUPER_TOPIC_FEED_DETAIL = new SourcePage("FEED_SUPER_TOPIC_FEED_DETAIL", 27, 27);
      FEED_PERSONAL_FEED_DETAIL = new SourcePage("FEED_PERSONAL_FEED_DETAIL", 28, 28);
      CITY_NOTE_PAGE = new SourcePage("CITY_NOTE_PAGE", 29, 29);
      PAGE_FIND_TOPIC_HOME = new SourcePage("PAGE_FIND_TOPIC_HOME", 30, 30);
      MINE_CIRCLE = new SourcePage("MINE_CIRCLE", 31, 31);
      CIRCLE_HOME_RECOMMEND = new SourcePage("CIRCLE_HOME_RECOMMEND", 32, 32);
      FEED_PLAZA_RECOMMEND_MORE = new SourcePage("FEED_PLAZA_RECOMMEND_MORE", 33, 33);
      UNRECOGNIZED = new SourcePage("UNRECOGNIZED", 34, -1);
      $VALUES = new SourcePage[] { 
          UNKNOWN_SOURCE_PAGE, FEED_PLAZA_RECOMMEND, FEED_PLAZA_FOLLOW, FEED_PLAZA_NEARBY, FEED_PLAZA_FLASH, FEED_PLAZA_IMAGE, FEED_SUPER_TOPIC_FEED, FEED_PERSONAL_FEED, FEED_DETAIL_PAGE, FEED_PLAY, 
          FEED_PERSONAL_MORE, SHARE_LIVE, SHARE_MINE_DANLAN, SHARE_MINE_HEER, SHARE_MINE_BABY, SHARE_MINE_EMOJI, PAGE_FEED_MINE, PAGE_FEED_LIKE, PAGE_FEED_DETAIL_MORE, ONE_CITY, 
          NOTE_DETAIL_SHARE, PLAZA_RECOMMEND_NOTE_SHARE, FEED_PLAZA_RECOMMEND_DETAIL, FEED_PLAZA_FOLLOW_DETAIL, FEED_PLAZA_FLASH_DETAIL, FEED_PLAZA_IMAGE_DETAIL, FEED_PLAZA_NEARBY_DETAIL, FEED_SUPER_TOPIC_FEED_DETAIL, FEED_PERSONAL_FEED_DETAIL, CITY_NOTE_PAGE, 
          PAGE_FIND_TOPIC_HOME, MINE_CIRCLE, CIRCLE_HOME_RECOMMEND, FEED_PLAZA_RECOMMEND_MORE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<SourcePage>() {
          public FeedProtos.SourcePage findValueByNumber(int param2Int) {
            return FeedProtos.SourcePage.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    SourcePage(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static SourcePage forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 33:
          return FEED_PLAZA_RECOMMEND_MORE;
        case 32:
          return CIRCLE_HOME_RECOMMEND;
        case 31:
          return MINE_CIRCLE;
        case 30:
          return PAGE_FIND_TOPIC_HOME;
        case 29:
          return CITY_NOTE_PAGE;
        case 28:
          return FEED_PERSONAL_FEED_DETAIL;
        case 27:
          return FEED_SUPER_TOPIC_FEED_DETAIL;
        case 26:
          return FEED_PLAZA_NEARBY_DETAIL;
        case 25:
          return FEED_PLAZA_IMAGE_DETAIL;
        case 24:
          return FEED_PLAZA_FLASH_DETAIL;
        case 23:
          return FEED_PLAZA_FOLLOW_DETAIL;
        case 22:
          return FEED_PLAZA_RECOMMEND_DETAIL;
        case 21:
          return PLAZA_RECOMMEND_NOTE_SHARE;
        case 20:
          return NOTE_DETAIL_SHARE;
        case 19:
          return ONE_CITY;
        case 18:
          return PAGE_FEED_DETAIL_MORE;
        case 17:
          return PAGE_FEED_LIKE;
        case 16:
          return PAGE_FEED_MINE;
        case 15:
          return SHARE_MINE_EMOJI;
        case 14:
          return SHARE_MINE_BABY;
        case 13:
          return SHARE_MINE_HEER;
        case 12:
          return SHARE_MINE_DANLAN;
        case 11:
          return SHARE_LIVE;
        case 10:
          return FEED_PERSONAL_MORE;
        case 9:
          return FEED_PLAY;
        case 8:
          return FEED_DETAIL_PAGE;
        case 7:
          return FEED_PERSONAL_FEED;
        case 6:
          return FEED_SUPER_TOPIC_FEED;
        case 5:
          return FEED_PLAZA_IMAGE;
        case 4:
          return FEED_PLAZA_FLASH;
        case 3:
          return FEED_PLAZA_NEARBY;
        case 2:
          return FEED_PLAZA_FOLLOW;
        case 1:
          return FEED_PLAZA_RECOMMEND;
        case 0:
          break;
      } 
      return UNKNOWN_SOURCE_PAGE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(14);
    }
    
    public static Internal.EnumLiteMap<SourcePage> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<SourcePage> {
    public FeedProtos.SourcePage findValueByNumber(int param1Int) {
      return FeedProtos.SourcePage.forNumber(param1Int);
    }
  }
  
  public enum TabType implements ProtocolMessageEnum {
    ESSENCE_CICLE(0),
    HOT_CIRCLE(0),
    NEW_CIRCLE(0),
    UNKNOWN_TAB_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int ESSENCE_CICLE_VALUE = 1;
    
    public static final int HOT_CIRCLE_VALUE = 2;
    
    public static final int NEW_CIRCLE_VALUE = 3;
    
    public static final int UNKNOWN_TAB_TYPE_VALUE = 0;
    
    private static final TabType[] VALUES;
    
    private static final Internal.EnumLiteMap<TabType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new TabType[] { UNKNOWN_TAB_TYPE, ESSENCE_CICLE, HOT_CIRCLE, NEW_CIRCLE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TabType>() {
          public FeedProtos.TabType findValueByNumber(int param2Int) {
            return FeedProtos.TabType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    TabType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TabType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : NEW_CIRCLE) : HOT_CIRCLE) : ESSENCE_CICLE) : UNKNOWN_TAB_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(21);
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
    public FeedProtos.TabType findValueByNumber(int param1Int) {
      return FeedProtos.TabType.forNumber(param1Int);
    }
  }
  
  public enum TagSource implements ProtocolMessageEnum {
    UNKNOWN_TAG_SOURCE(0),
    UNRECOGNIZED(0),
    VOICE_CHATROOM(1);
    
    public static final int UNKNOWN_TAG_SOURCE_VALUE = 0;
    
    private static final TagSource[] VALUES;
    
    public static final int VOICE_CHATROOM_VALUE = 1;
    
    private static final Internal.EnumLiteMap<TagSource> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new TagSource[] { UNKNOWN_TAG_SOURCE, VOICE_CHATROOM, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TagSource>() {
          public FeedProtos.TagSource findValueByNumber(int param2Int) {
            return FeedProtos.TagSource.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    TagSource(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TagSource forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : VOICE_CHATROOM) : UNKNOWN_TAG_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(20);
    }
    
    public static Internal.EnumLiteMap<TagSource> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<TagSource> {
    public FeedProtos.TagSource findValueByNumber(int param1Int) {
      return FeedProtos.TagSource.forNumber(param1Int);
    }
  }
  
  public enum UserType implements ProtocolMessageEnum {
    UNKNOWN_USER_TYPE(0),
    UNRECOGNIZED(0),
    CIRCLE_CAPTAIN(1),
    CIRCLE_NOT_MEMBER(1),
    COMMON_USER(1),
    CONTROL(1),
    NORMAL(1),
    TREATMENT(1),
    VICE_CAPTAIN(1);
    
    public static final int CIRCLE_CAPTAIN_VALUE = 3;
    
    public static final int CIRCLE_NOT_MEMBER_VALUE = 4;
    
    public static final int COMMON_USER_VALUE = 2;
    
    public static final int CONTROL_VALUE = 6;
    
    public static final int NORMAL_VALUE = 7;
    
    public static final int TREATMENT_VALUE = 5;
    
    public static final int UNKNOWN_USER_TYPE_VALUE = 0;
    
    private static final UserType[] VALUES;
    
    public static final int VICE_CAPTAIN_VALUE = 1;
    
    private static final Internal.EnumLiteMap<UserType> internalValueMap;
    
    private final int value;
    
    static {
      CIRCLE_CAPTAIN = new UserType("CIRCLE_CAPTAIN", 3, 3);
      CIRCLE_NOT_MEMBER = new UserType("CIRCLE_NOT_MEMBER", 4, 4);
      TREATMENT = new UserType("TREATMENT", 5, 5);
      CONTROL = new UserType("CONTROL", 6, 6);
      NORMAL = new UserType("NORMAL", 7, 7);
      UNRECOGNIZED = new UserType("UNRECOGNIZED", 8, -1);
      $VALUES = new UserType[] { UNKNOWN_USER_TYPE, VICE_CAPTAIN, COMMON_USER, CIRCLE_CAPTAIN, CIRCLE_NOT_MEMBER, TREATMENT, CONTROL, NORMAL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<UserType>() {
          public FeedProtos.UserType findValueByNumber(int param2Int) {
            return FeedProtos.UserType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    UserType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static UserType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 7:
          return NORMAL;
        case 6:
          return CONTROL;
        case 5:
          return TREATMENT;
        case 4:
          return CIRCLE_NOT_MEMBER;
        case 3:
          return CIRCLE_CAPTAIN;
        case 2:
          return COMMON_USER;
        case 1:
          return VICE_CAPTAIN;
        case 0:
          break;
      } 
      return UNKNOWN_USER_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return FeedProtos.getDescriptor().getEnumTypes().get(19);
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
    public FeedProtos.UserType findValueByNumber(int param1Int) {
      return FeedProtos.UserType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\client\feed\FeedProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
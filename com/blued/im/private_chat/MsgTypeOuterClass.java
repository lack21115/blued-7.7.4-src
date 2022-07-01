package com.blued.im.private_chat;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class MsgTypeOuterClass {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\rMsgType.proto\022\031com.blued.im.private_chat*ç\005\n\007MsgType\022\024\n\020UNKNOWN_MSG_TYPE\020\000\022\b\n\004TEXT\020\001\022\t\n\005IMAGE\020\002\022\t\n\005AUDIO\020\003\022\f\n\bLOCATION\020\004\022\t\n\005VIDEO\020\005\022\017\n\013CUSTOM_FACE\020\006\022\020\n\fGROUP_INVITE\020\t\022\017\n\013GROUP_SHARE\020\n\022\016\n\nBURN_IMAGE\020\030\022\016\n\nBURN_VIDEO\020\031\022\016\n\nSCREENSHOT\020\032\022\016\n\nLIVE_SHARE\020 \022\026\n\022LIVE_SHARE_PRIVATE\020)\022\025\n\021VIDEOCHAT_CALLING\0204\022\r\n\tEND_AUDIO\0205\022\035\n\031VIDEOCHAT_SWITCH_TO_AUDIO\0206\022\023\n\017RETRACT_MESSAGE\0207\022\021\n\rPERSION_SHARE\0208\022\r\n\tWEB_SHARE\0209\022\r\n\tGIF_EMOJI\020:\022\r\n\tCHAT_FEED\020C\022\r\n\tIMAGETEXT\020D\022\016\n\nHIDENALBUM\020I\022\017\n\013UNLOCKAlBUM\020J\022\026\n\022PRIVATE_LIVE_SHARE\020K\022\016\n\nVIEW_SHARE\020W\022\016\n\nLINK_SHARE\020X\022\016\n\nPOST_SHARE\020Y\022\016\n\nUSER_SHARE\020Z\022\020\n\fVIP_OTHERPAY\020b\022\f\n\bVIP_GIVE\020c\022\017\n\013EACH_FRIEND\020i\022\024\n\020AUDIO_LIVE_SHARE\020q\022\017\n\013CHAT_SAY_HI\020|\022\t\n\004GIFT\020¤\001\022\t\n\004LIKE\020¨\001\022\016\n\tSYSNOTICE\020©\001\022\025\n\020VOICE_ROOM_SHARE\020Ë\001\022\022\n\rHELLO_EMOTION\020Í\001\022\020\n\013MT_YY_SHARE\020Ò\001\022\021\n\fDOODLE_SHARE\020Ô\001\022\021\n\fGROUP_NOTICE\020Ø\001B\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum MsgType implements ProtocolMessageEnum {
    AUDIO,
    AUDIO_LIVE_SHARE,
    BURN_IMAGE,
    BURN_VIDEO,
    CHAT_FEED,
    CHAT_SAY_HI,
    CUSTOM_FACE,
    DOODLE_SHARE,
    EACH_FRIEND,
    END_AUDIO,
    GIFT,
    GIF_EMOJI,
    GROUP_INVITE,
    GROUP_NOTICE,
    GROUP_SHARE,
    HELLO_EMOTION,
    HIDENALBUM,
    IMAGE,
    IMAGETEXT,
    LIKE,
    LINK_SHARE,
    LIVE_SHARE,
    LIVE_SHARE_PRIVATE,
    LOCATION,
    MT_YY_SHARE,
    PERSION_SHARE,
    POST_SHARE,
    PRIVATE_LIVE_SHARE,
    RETRACT_MESSAGE,
    SCREENSHOT,
    SYSNOTICE,
    TEXT,
    UNKNOWN_MSG_TYPE(0),
    UNLOCKAlBUM(0),
    UNRECOGNIZED(0),
    USER_SHARE(0),
    VIDEO(0),
    VIDEOCHAT_CALLING(0),
    VIDEOCHAT_SWITCH_TO_AUDIO(0),
    VIEW_SHARE(0),
    VIP_GIVE(0),
    VIP_OTHERPAY(0),
    VOICE_ROOM_SHARE(0),
    WEB_SHARE(0);
    
    public static final int AUDIO_LIVE_SHARE_VALUE = 113;
    
    public static final int AUDIO_VALUE = 3;
    
    public static final int BURN_IMAGE_VALUE = 24;
    
    public static final int BURN_VIDEO_VALUE = 25;
    
    public static final int CHAT_FEED_VALUE = 67;
    
    public static final int CHAT_SAY_HI_VALUE = 124;
    
    public static final int CUSTOM_FACE_VALUE = 6;
    
    public static final int DOODLE_SHARE_VALUE = 212;
    
    public static final int EACH_FRIEND_VALUE = 105;
    
    public static final int END_AUDIO_VALUE = 53;
    
    public static final int GIFT_VALUE = 164;
    
    public static final int GIF_EMOJI_VALUE = 58;
    
    public static final int GROUP_INVITE_VALUE = 9;
    
    public static final int GROUP_NOTICE_VALUE = 216;
    
    public static final int GROUP_SHARE_VALUE = 10;
    
    public static final int HELLO_EMOTION_VALUE = 205;
    
    public static final int HIDENALBUM_VALUE = 73;
    
    public static final int IMAGETEXT_VALUE = 68;
    
    public static final int IMAGE_VALUE = 2;
    
    public static final int LIKE_VALUE = 168;
    
    public static final int LINK_SHARE_VALUE = 88;
    
    public static final int LIVE_SHARE_PRIVATE_VALUE = 41;
    
    public static final int LIVE_SHARE_VALUE = 32;
    
    public static final int LOCATION_VALUE = 4;
    
    public static final int MT_YY_SHARE_VALUE = 210;
    
    public static final int PERSION_SHARE_VALUE = 56;
    
    public static final int POST_SHARE_VALUE = 89;
    
    public static final int PRIVATE_LIVE_SHARE_VALUE = 75;
    
    public static final int RETRACT_MESSAGE_VALUE = 55;
    
    public static final int SCREENSHOT_VALUE = 26;
    
    public static final int SYSNOTICE_VALUE = 169;
    
    public static final int TEXT_VALUE = 1;
    
    public static final int UNKNOWN_MSG_TYPE_VALUE = 0;
    
    public static final int UNLOCKAlBUM_VALUE = 74;
    
    public static final int USER_SHARE_VALUE = 90;
    
    private static final MsgType[] VALUES;
    
    public static final int VIDEOCHAT_CALLING_VALUE = 52;
    
    public static final int VIDEOCHAT_SWITCH_TO_AUDIO_VALUE = 54;
    
    public static final int VIDEO_VALUE = 5;
    
    public static final int VIEW_SHARE_VALUE = 87;
    
    public static final int VIP_GIVE_VALUE = 99;
    
    public static final int VIP_OTHERPAY_VALUE = 98;
    
    public static final int VOICE_ROOM_SHARE_VALUE = 203;
    
    public static final int WEB_SHARE_VALUE = 57;
    
    private static final Internal.EnumLiteMap<MsgType> internalValueMap;
    
    private final int value;
    
    static {
      IMAGE = new MsgType("IMAGE", 2, 2);
      AUDIO = new MsgType("AUDIO", 3, 3);
      LOCATION = new MsgType("LOCATION", 4, 4);
      VIDEO = new MsgType("VIDEO", 5, 5);
      CUSTOM_FACE = new MsgType("CUSTOM_FACE", 6, 6);
      GROUP_INVITE = new MsgType("GROUP_INVITE", 7, 9);
      GROUP_SHARE = new MsgType("GROUP_SHARE", 8, 10);
      BURN_IMAGE = new MsgType("BURN_IMAGE", 9, 24);
      BURN_VIDEO = new MsgType("BURN_VIDEO", 10, 25);
      SCREENSHOT = new MsgType("SCREENSHOT", 11, 26);
      LIVE_SHARE = new MsgType("LIVE_SHARE", 12, 32);
      LIVE_SHARE_PRIVATE = new MsgType("LIVE_SHARE_PRIVATE", 13, 41);
      VIDEOCHAT_CALLING = new MsgType("VIDEOCHAT_CALLING", 14, 52);
      END_AUDIO = new MsgType("END_AUDIO", 15, 53);
      VIDEOCHAT_SWITCH_TO_AUDIO = new MsgType("VIDEOCHAT_SWITCH_TO_AUDIO", 16, 54);
      RETRACT_MESSAGE = new MsgType("RETRACT_MESSAGE", 17, 55);
      PERSION_SHARE = new MsgType("PERSION_SHARE", 18, 56);
      WEB_SHARE = new MsgType("WEB_SHARE", 19, 57);
      GIF_EMOJI = new MsgType("GIF_EMOJI", 20, 58);
      CHAT_FEED = new MsgType("CHAT_FEED", 21, 67);
      IMAGETEXT = new MsgType("IMAGETEXT", 22, 68);
      HIDENALBUM = new MsgType("HIDENALBUM", 23, 73);
      UNLOCKAlBUM = new MsgType("UNLOCKAlBUM", 24, 74);
      PRIVATE_LIVE_SHARE = new MsgType("PRIVATE_LIVE_SHARE", 25, 75);
      VIEW_SHARE = new MsgType("VIEW_SHARE", 26, 87);
      LINK_SHARE = new MsgType("LINK_SHARE", 27, 88);
      POST_SHARE = new MsgType("POST_SHARE", 28, 89);
      USER_SHARE = new MsgType("USER_SHARE", 29, 90);
      VIP_OTHERPAY = new MsgType("VIP_OTHERPAY", 30, 98);
      VIP_GIVE = new MsgType("VIP_GIVE", 31, 99);
      EACH_FRIEND = new MsgType("EACH_FRIEND", 32, 105);
      AUDIO_LIVE_SHARE = new MsgType("AUDIO_LIVE_SHARE", 33, 113);
      CHAT_SAY_HI = new MsgType("CHAT_SAY_HI", 34, 124);
      GIFT = new MsgType("GIFT", 35, 164);
      LIKE = new MsgType("LIKE", 36, 168);
      SYSNOTICE = new MsgType("SYSNOTICE", 37, 169);
      VOICE_ROOM_SHARE = new MsgType("VOICE_ROOM_SHARE", 38, 203);
      HELLO_EMOTION = new MsgType("HELLO_EMOTION", 39, 205);
      MT_YY_SHARE = new MsgType("MT_YY_SHARE", 40, 210);
      DOODLE_SHARE = new MsgType("DOODLE_SHARE", 41, 212);
      GROUP_NOTICE = new MsgType("GROUP_NOTICE", 42, 216);
      UNRECOGNIZED = new MsgType("UNRECOGNIZED", 43, -1);
      $VALUES = new MsgType[] { 
          UNKNOWN_MSG_TYPE, TEXT, IMAGE, AUDIO, LOCATION, VIDEO, CUSTOM_FACE, GROUP_INVITE, GROUP_SHARE, BURN_IMAGE, 
          BURN_VIDEO, SCREENSHOT, LIVE_SHARE, LIVE_SHARE_PRIVATE, VIDEOCHAT_CALLING, END_AUDIO, VIDEOCHAT_SWITCH_TO_AUDIO, RETRACT_MESSAGE, PERSION_SHARE, WEB_SHARE, 
          GIF_EMOJI, CHAT_FEED, IMAGETEXT, HIDENALBUM, UNLOCKAlBUM, PRIVATE_LIVE_SHARE, VIEW_SHARE, LINK_SHARE, POST_SHARE, USER_SHARE, 
          VIP_OTHERPAY, VIP_GIVE, EACH_FRIEND, AUDIO_LIVE_SHARE, CHAT_SAY_HI, GIFT, LIKE, SYSNOTICE, VOICE_ROOM_SHARE, HELLO_EMOTION, 
          MT_YY_SHARE, DOODLE_SHARE, GROUP_NOTICE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<MsgType>() {
          public MsgTypeOuterClass.MsgType findValueByNumber(int param2Int) {
            return MsgTypeOuterClass.MsgType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    MsgType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static MsgType forNumber(int param1Int) {
      if (param1Int != 9) {
        if (param1Int != 10) {
          if (param1Int != 67) {
            if (param1Int != 68) {
              if (param1Int != 98) {
                if (param1Int != 99) {
                  if (param1Int != 168) {
                    if (param1Int != 169) {
                      switch (param1Int) {
                        default:
                          switch (param1Int) {
                            default:
                              switch (param1Int) {
                                default:
                                  switch (param1Int) {
                                    default:
                                      switch (param1Int) {
                                        default:
                                          switch (param1Int) {
                                            default:
                                              return null;
                                            case 90:
                                              return USER_SHARE;
                                            case 89:
                                              return POST_SHARE;
                                            case 88:
                                              return LINK_SHARE;
                                            case 87:
                                              break;
                                          } 
                                          return VIEW_SHARE;
                                        case 75:
                                          return PRIVATE_LIVE_SHARE;
                                        case 74:
                                          return UNLOCKAlBUM;
                                        case 73:
                                          break;
                                      } 
                                      return HIDENALBUM;
                                    case 58:
                                      return GIF_EMOJI;
                                    case 57:
                                      return WEB_SHARE;
                                    case 56:
                                      return PERSION_SHARE;
                                    case 55:
                                      return RETRACT_MESSAGE;
                                    case 54:
                                      return VIDEOCHAT_SWITCH_TO_AUDIO;
                                    case 53:
                                      return END_AUDIO;
                                    case 52:
                                      break;
                                  } 
                                  return VIDEOCHAT_CALLING;
                                case 216:
                                  return GROUP_NOTICE;
                                case 212:
                                  return DOODLE_SHARE;
                                case 210:
                                  return MT_YY_SHARE;
                                case 205:
                                  return HELLO_EMOTION;
                                case 203:
                                  return VOICE_ROOM_SHARE;
                                case 164:
                                  return GIFT;
                                case 124:
                                  return CHAT_SAY_HI;
                                case 113:
                                  return AUDIO_LIVE_SHARE;
                                case 105:
                                  return EACH_FRIEND;
                                case 41:
                                  return LIVE_SHARE_PRIVATE;
                                case 32:
                                  break;
                              } 
                              return LIVE_SHARE;
                            case 26:
                              return SCREENSHOT;
                            case 25:
                              return BURN_VIDEO;
                            case 24:
                              break;
                          } 
                          return BURN_IMAGE;
                        case 6:
                          return CUSTOM_FACE;
                        case 5:
                          return VIDEO;
                        case 4:
                          return LOCATION;
                        case 3:
                          return AUDIO;
                        case 2:
                          return IMAGE;
                        case 1:
                          return TEXT;
                        case 0:
                          break;
                      } 
                      return UNKNOWN_MSG_TYPE;
                    } 
                    return SYSNOTICE;
                  } 
                  return LIKE;
                } 
                return VIP_GIVE;
              } 
              return VIP_OTHERPAY;
            } 
            return IMAGETEXT;
          } 
          return CHAT_FEED;
        } 
        return GROUP_SHARE;
      } 
      return GROUP_INVITE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return MsgTypeOuterClass.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<MsgType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<MsgType> {
    public MsgTypeOuterClass.MsgType findValueByNumber(int param1Int) {
      return MsgTypeOuterClass.MsgType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\MsgTypeOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.blued.im.audio_chatroom;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class AudioMsgType {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\022AudioMsgType.proto\022\033com.blued.im.audio_chatroom*Ó\005\n\007MsgType\022\024\n\020UNKNOWN_MSG_TYPE\020\000\022\b\n\004TEXT\020\001\022\r\n\tJOIN_ROOM\020\002\022\r\n\tQUIT_ROOM\020\003\022\016\n\nCLOSE_ROOM\020\004\022\r\n\tSEND_GIFT\020\005\022\016\n\nALERT_ROOM\020\006\022\021\n\rFOLLOW_NOTICE\020\007\022\017\n\013SET_MANAGER\020\b\022\022\n\016CANCLE_MANAGER\020\t\022\b\n\004MUTE\020\n\022\n\n\006UNMUTE\020\013\022\022\n\016INVITE_UP_SEAT\020\f\022\021\n\rREFUSE_INVITE\020\r\022\023\n\017UP_SEAT_SUCCESS\020\016\022\016\n\nLEAVE_SEAT\020\017\022\027\n\023APPLY_UP_SEAT_COUNT\020\020\022\024\n\020MUTE_SEAT_STATUS\020\021\022\025\n\021CLOSE_SEAT_STATUS\020\022\022\r\n\tKICK_ROOM\020\023\022\025\n\021ROOM_NAME_INVALID\020\024\022\016\n\nOFFICE_MSG\020\025\022\023\n\017AUDIT_NAME_PASS\020\026\022\023\n\017UP_APPLY_REJECT\020\027\022\027\n\023LATE_UP_SEAT_ACCEPT\020\030\022\027\n\023LATE_UP_SEAT_REJECT\020\031\022\020\n\fANNOUNCEMENT\020\032\022\f\n\bEMOJIMSG\020\033\022\020\n\fSOUND_EFFECT\020\034\022\016\n\nVOTE_START\020\035\022\f\n\bVOTE_END\020\036\022\020\n\fTEXT_NO_NAME\020\037\022\024\n\020BLIND_DATA_START\020 \022\030\n\024BLIND_DATA_INTRODUCE\020!\022\025\n\021BLIND_DATA_CHOOSE\020\"\022\025\n\021BLIND_DATA_PULISH\020#\022\023\n\017BLIND_DATA_OVER\020$\022\024\n\020BLIND_DATA_HEART\020%B\020¢\002\rAudioChatroomb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum MsgType implements ProtocolMessageEnum {
    ALERT_ROOM,
    ANNOUNCEMENT,
    APPLY_UP_SEAT_COUNT,
    AUDIT_NAME_PASS,
    BLIND_DATA_CHOOSE,
    BLIND_DATA_HEART,
    BLIND_DATA_INTRODUCE,
    BLIND_DATA_OVER,
    BLIND_DATA_PULISH,
    BLIND_DATA_START,
    CANCLE_MANAGER,
    CLOSE_ROOM,
    CLOSE_SEAT_STATUS,
    EMOJIMSG,
    FOLLOW_NOTICE,
    INVITE_UP_SEAT,
    JOIN_ROOM,
    KICK_ROOM,
    LATE_UP_SEAT_ACCEPT,
    LATE_UP_SEAT_REJECT,
    LEAVE_SEAT,
    MUTE,
    MUTE_SEAT_STATUS,
    OFFICE_MSG,
    QUIT_ROOM,
    REFUSE_INVITE,
    ROOM_NAME_INVALID,
    SEND_GIFT,
    SET_MANAGER,
    SOUND_EFFECT,
    TEXT,
    TEXT_NO_NAME,
    UNKNOWN_MSG_TYPE(0),
    UNMUTE(0),
    UNRECOGNIZED(0),
    UP_APPLY_REJECT(0),
    UP_SEAT_SUCCESS(0),
    VOTE_END(0),
    VOTE_START(0);
    
    public static final int ALERT_ROOM_VALUE = 6;
    
    public static final int ANNOUNCEMENT_VALUE = 26;
    
    public static final int APPLY_UP_SEAT_COUNT_VALUE = 16;
    
    public static final int AUDIT_NAME_PASS_VALUE = 22;
    
    public static final int BLIND_DATA_CHOOSE_VALUE = 34;
    
    public static final int BLIND_DATA_HEART_VALUE = 37;
    
    public static final int BLIND_DATA_INTRODUCE_VALUE = 33;
    
    public static final int BLIND_DATA_OVER_VALUE = 36;
    
    public static final int BLIND_DATA_PULISH_VALUE = 35;
    
    public static final int BLIND_DATA_START_VALUE = 32;
    
    public static final int CANCLE_MANAGER_VALUE = 9;
    
    public static final int CLOSE_ROOM_VALUE = 4;
    
    public static final int CLOSE_SEAT_STATUS_VALUE = 18;
    
    public static final int EMOJIMSG_VALUE = 27;
    
    public static final int FOLLOW_NOTICE_VALUE = 7;
    
    public static final int INVITE_UP_SEAT_VALUE = 12;
    
    public static final int JOIN_ROOM_VALUE = 2;
    
    public static final int KICK_ROOM_VALUE = 19;
    
    public static final int LATE_UP_SEAT_ACCEPT_VALUE = 24;
    
    public static final int LATE_UP_SEAT_REJECT_VALUE = 25;
    
    public static final int LEAVE_SEAT_VALUE = 15;
    
    public static final int MUTE_SEAT_STATUS_VALUE = 17;
    
    public static final int MUTE_VALUE = 10;
    
    public static final int OFFICE_MSG_VALUE = 21;
    
    public static final int QUIT_ROOM_VALUE = 3;
    
    public static final int REFUSE_INVITE_VALUE = 13;
    
    public static final int ROOM_NAME_INVALID_VALUE = 20;
    
    public static final int SEND_GIFT_VALUE = 5;
    
    public static final int SET_MANAGER_VALUE = 8;
    
    public static final int SOUND_EFFECT_VALUE = 28;
    
    public static final int TEXT_NO_NAME_VALUE = 31;
    
    public static final int TEXT_VALUE = 1;
    
    public static final int UNKNOWN_MSG_TYPE_VALUE = 0;
    
    public static final int UNMUTE_VALUE = 11;
    
    public static final int UP_APPLY_REJECT_VALUE = 23;
    
    public static final int UP_SEAT_SUCCESS_VALUE = 14;
    
    private static final MsgType[] VALUES;
    
    public static final int VOTE_END_VALUE = 30;
    
    public static final int VOTE_START_VALUE = 29;
    
    private static final Internal.EnumLiteMap<MsgType> internalValueMap;
    
    private final int value;
    
    static {
      JOIN_ROOM = new MsgType("JOIN_ROOM", 2, 2);
      QUIT_ROOM = new MsgType("QUIT_ROOM", 3, 3);
      CLOSE_ROOM = new MsgType("CLOSE_ROOM", 4, 4);
      SEND_GIFT = new MsgType("SEND_GIFT", 5, 5);
      ALERT_ROOM = new MsgType("ALERT_ROOM", 6, 6);
      FOLLOW_NOTICE = new MsgType("FOLLOW_NOTICE", 7, 7);
      SET_MANAGER = new MsgType("SET_MANAGER", 8, 8);
      CANCLE_MANAGER = new MsgType("CANCLE_MANAGER", 9, 9);
      MUTE = new MsgType("MUTE", 10, 10);
      UNMUTE = new MsgType("UNMUTE", 11, 11);
      INVITE_UP_SEAT = new MsgType("INVITE_UP_SEAT", 12, 12);
      REFUSE_INVITE = new MsgType("REFUSE_INVITE", 13, 13);
      UP_SEAT_SUCCESS = new MsgType("UP_SEAT_SUCCESS", 14, 14);
      LEAVE_SEAT = new MsgType("LEAVE_SEAT", 15, 15);
      APPLY_UP_SEAT_COUNT = new MsgType("APPLY_UP_SEAT_COUNT", 16, 16);
      MUTE_SEAT_STATUS = new MsgType("MUTE_SEAT_STATUS", 17, 17);
      CLOSE_SEAT_STATUS = new MsgType("CLOSE_SEAT_STATUS", 18, 18);
      KICK_ROOM = new MsgType("KICK_ROOM", 19, 19);
      ROOM_NAME_INVALID = new MsgType("ROOM_NAME_INVALID", 20, 20);
      OFFICE_MSG = new MsgType("OFFICE_MSG", 21, 21);
      AUDIT_NAME_PASS = new MsgType("AUDIT_NAME_PASS", 22, 22);
      UP_APPLY_REJECT = new MsgType("UP_APPLY_REJECT", 23, 23);
      LATE_UP_SEAT_ACCEPT = new MsgType("LATE_UP_SEAT_ACCEPT", 24, 24);
      LATE_UP_SEAT_REJECT = new MsgType("LATE_UP_SEAT_REJECT", 25, 25);
      ANNOUNCEMENT = new MsgType("ANNOUNCEMENT", 26, 26);
      EMOJIMSG = new MsgType("EMOJIMSG", 27, 27);
      SOUND_EFFECT = new MsgType("SOUND_EFFECT", 28, 28);
      VOTE_START = new MsgType("VOTE_START", 29, 29);
      VOTE_END = new MsgType("VOTE_END", 30, 30);
      TEXT_NO_NAME = new MsgType("TEXT_NO_NAME", 31, 31);
      BLIND_DATA_START = new MsgType("BLIND_DATA_START", 32, 32);
      BLIND_DATA_INTRODUCE = new MsgType("BLIND_DATA_INTRODUCE", 33, 33);
      BLIND_DATA_CHOOSE = new MsgType("BLIND_DATA_CHOOSE", 34, 34);
      BLIND_DATA_PULISH = new MsgType("BLIND_DATA_PULISH", 35, 35);
      BLIND_DATA_OVER = new MsgType("BLIND_DATA_OVER", 36, 36);
      BLIND_DATA_HEART = new MsgType("BLIND_DATA_HEART", 37, 37);
      UNRECOGNIZED = new MsgType("UNRECOGNIZED", 38, -1);
      $VALUES = new MsgType[] { 
          UNKNOWN_MSG_TYPE, TEXT, JOIN_ROOM, QUIT_ROOM, CLOSE_ROOM, SEND_GIFT, ALERT_ROOM, FOLLOW_NOTICE, SET_MANAGER, CANCLE_MANAGER, 
          MUTE, UNMUTE, INVITE_UP_SEAT, REFUSE_INVITE, UP_SEAT_SUCCESS, LEAVE_SEAT, APPLY_UP_SEAT_COUNT, MUTE_SEAT_STATUS, CLOSE_SEAT_STATUS, KICK_ROOM, 
          ROOM_NAME_INVALID, OFFICE_MSG, AUDIT_NAME_PASS, UP_APPLY_REJECT, LATE_UP_SEAT_ACCEPT, LATE_UP_SEAT_REJECT, ANNOUNCEMENT, EMOJIMSG, SOUND_EFFECT, VOTE_START, 
          VOTE_END, TEXT_NO_NAME, BLIND_DATA_START, BLIND_DATA_INTRODUCE, BLIND_DATA_CHOOSE, BLIND_DATA_PULISH, BLIND_DATA_OVER, BLIND_DATA_HEART, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<MsgType>() {
          public AudioMsgType.MsgType findValueByNumber(int param2Int) {
            return AudioMsgType.MsgType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    MsgType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static MsgType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 37:
          return BLIND_DATA_HEART;
        case 36:
          return BLIND_DATA_OVER;
        case 35:
          return BLIND_DATA_PULISH;
        case 34:
          return BLIND_DATA_CHOOSE;
        case 33:
          return BLIND_DATA_INTRODUCE;
        case 32:
          return BLIND_DATA_START;
        case 31:
          return TEXT_NO_NAME;
        case 30:
          return VOTE_END;
        case 29:
          return VOTE_START;
        case 28:
          return SOUND_EFFECT;
        case 27:
          return EMOJIMSG;
        case 26:
          return ANNOUNCEMENT;
        case 25:
          return LATE_UP_SEAT_REJECT;
        case 24:
          return LATE_UP_SEAT_ACCEPT;
        case 23:
          return UP_APPLY_REJECT;
        case 22:
          return AUDIT_NAME_PASS;
        case 21:
          return OFFICE_MSG;
        case 20:
          return ROOM_NAME_INVALID;
        case 19:
          return KICK_ROOM;
        case 18:
          return CLOSE_SEAT_STATUS;
        case 17:
          return MUTE_SEAT_STATUS;
        case 16:
          return APPLY_UP_SEAT_COUNT;
        case 15:
          return LEAVE_SEAT;
        case 14:
          return UP_SEAT_SUCCESS;
        case 13:
          return REFUSE_INVITE;
        case 12:
          return INVITE_UP_SEAT;
        case 11:
          return UNMUTE;
        case 10:
          return MUTE;
        case 9:
          return CANCLE_MANAGER;
        case 8:
          return SET_MANAGER;
        case 7:
          return FOLLOW_NOTICE;
        case 6:
          return ALERT_ROOM;
        case 5:
          return SEND_GIFT;
        case 4:
          return CLOSE_ROOM;
        case 3:
          return QUIT_ROOM;
        case 2:
          return JOIN_ROOM;
        case 1:
          return TEXT;
        case 0:
          break;
      } 
      return UNKNOWN_MSG_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return AudioMsgType.getDescriptor().getEnumTypes().get(0);
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
    public AudioMsgType.MsgType findValueByNumber(int param1Int) {
      return AudioMsgType.MsgType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\audio_chatroom\AudioMsgType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
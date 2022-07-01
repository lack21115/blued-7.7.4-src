package com.blued.das.settings;

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

public final class SettingsProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\024SettingsProtos.proto\022\026com.blued.das.settings\"\002\n\rSettingsProto\022,\n\005event\030\001 \001(\0162\035.com.blued.das.settings.Event\022\f\n\004name\030\002 \001(\t\022\020\n\blink_url\030\003 \001(\t\0227\n\013module_type\030\004 \001(\0162\".com.blued.das.settings.ModuleType\022\021\n\tbanner_id\030\005 \001(\t\022\017\n\007is_open\030\006 \001(\b\022\017\n\007is_auto\030\007 \001(\b\022\021\n\tis_shadow\030\b \001(\b\022\013\n\003num\030\t \001(\005\022\020\n\bposition\030\n \001(\005\022\f\n\004from\030\013 \001(\005*ë\n\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\034\n\030CANCEL_ACCOUNT_BTN_CLICK\020\001\022\030\n\024CHANGE_ACCOUNT_CLICK\020\002\022$\n MINE_VIP_BANNER_COPYWRITING_SHOW\020\003\022%\n!MINE_VIP_BANNER_COPYWRITING_CLICK\020\004\022\022\n\016MINE_AREA_SHOW\020\005\022\022\n\016MINE_BTN_CLICK\020\006\022\027\n\023DARK_MODE_BTN_CLICK\020\007\022\035\n\031MINE_SETTINGS_ANTI_HARASS\020\b\022 \n\034MINE_VIP_BANNER_CENTER_CLICK\020\t\022*\n&MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK\020\n\022)\n%MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK\020\013\022-\n)MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK\020\f\022+\n'MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK\020\r\022&\n\"MINE_SETTINGS_PRIVACY_ACCESS_CLICK\020\022\022,\n(MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK\020\023\022*\n&MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK\020\024\022(\n$MINE_SETTINGS_COMMON_CHANGE_BG_CLICK\020\025\022#\n\037MINE_EDIT_PERSONALITY_BTN_CLICK\020\026\022\"\n\036MINE_EDIT_MORE_PHOTO_BTN_CLICK\020\027\022\024\n\020WORD_SIZE_CHANGE\020\030\022\035\n\031MINE_HELP_RENEW_BUY_CLICK\020\031\022\023\n\017DEEP_LINK_CLICK\020\032\022\024\n\020APP_NEARBY_CLICK\020\033\022\022\n\016APP_LIVE_CLICK\020\034\022\022\n\016APP_FIND_CLICK\020\035\022\021\n\rAPP_MSG_CLICK\020\036\022\020\n\fAPP_ME_CLICK\020\037\022\024\n\020LOGOUT_BTN_CLICK\020 \022\022\n\016UNBOUND_WECHAT\020!\022\020\n\fBOUND_WECHAT\020\"\022\025\n\021PATTERN_LOCK_OPEN\020#\022\026\n\022PATTERN_LOCK_CLOSE\020$\022\024\n\020LOGIN_PROTECTION\020%\022\031\n\025VERIFY_PHOTO_UPLOADED\020&\022\030\n\024PERSONAL_VERIFY_SHOW\020'\022\027\n\023AV_FACE_RESULT_SHOW\020(\022\031\n\025AV_IDCARD_RESULT_SHOW\020)\022\035\n\031ACCOUNT_LOCK_APPEAL_CLICK\020*\022\026\n\022PWD_SETTINGS_CLICK\020+\022\036\n\032ACCOUNT_PWD_SETTINGS_CLICK\020,\022\032\n\026PAY_PWD_SETTINGS_CLICK\020-\022\036\n\032GESTURE_PWD_SETTINGS_CLICK\020.\022\033\n\027MINE_SETTINGS_MSG_CLICK\020/\022,\n(MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK\0200\022+\n'MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK\0201*d\n\nModuleType\022\027\n\023UNKNOWN_MODULE_TYPE\020\000\022\021\n\rAGENCY_BANNER\020\001\022\n\n\006HEALTH\020\002\022\017\n\013HEER_BANNER\020\003\022\r\n\tSETTYINGS\020\004B\013¢\002\bSETTINGSb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_settings_SettingsProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_settings_SettingsProto_descriptor, new String[] { 
        "Event", "Name", "LinkUrl", "ModuleType", "BannerId", "IsOpen", "IsAuto", "IsShadow", "Num", "Position", 
        "From" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    ACCOUNT_LOCK_APPEAL_CLICK,
    ACCOUNT_PWD_SETTINGS_CLICK,
    APP_FIND_CLICK,
    APP_LIVE_CLICK,
    APP_ME_CLICK,
    APP_MSG_CLICK,
    APP_NEARBY_CLICK,
    AV_FACE_RESULT_SHOW,
    AV_IDCARD_RESULT_SHOW,
    BOUND_WECHAT,
    CANCEL_ACCOUNT_BTN_CLICK,
    CHANGE_ACCOUNT_CLICK,
    DARK_MODE_BTN_CLICK,
    DEEP_LINK_CLICK,
    GESTURE_PWD_SETTINGS_CLICK,
    LOGIN_PROTECTION,
    LOGOUT_BTN_CLICK,
    MINE_AREA_SHOW,
    MINE_BTN_CLICK,
    MINE_EDIT_MORE_PHOTO_BTN_CLICK,
    MINE_EDIT_PERSONALITY_BTN_CLICK,
    MINE_HELP_RENEW_BUY_CLICK,
    MINE_SETTINGS_ANTI_HARASS,
    MINE_SETTINGS_COMMON_CHANGE_BG_CLICK,
    MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK,
    MINE_SETTINGS_MSG_CLICK,
    MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK,
    MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK,
    MINE_SETTINGS_PRIVACY_ACCESS_CLICK,
    MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK,
    MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK,
    MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK,
    MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK,
    MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK,
    MINE_VIP_BANNER_CENTER_CLICK,
    MINE_VIP_BANNER_COPYWRITING_CLICK,
    MINE_VIP_BANNER_COPYWRITING_SHOW,
    PATTERN_LOCK_CLOSE,
    PATTERN_LOCK_OPEN,
    PAY_PWD_SETTINGS_CLICK,
    PERSONAL_VERIFY_SHOW,
    PWD_SETTINGS_CLICK,
    UNBOUND_WECHAT,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0),
    VERIFY_PHOTO_UPLOADED(0),
    WORD_SIZE_CHANGE(0);
    
    public static final int ACCOUNT_LOCK_APPEAL_CLICK_VALUE = 42;
    
    public static final int ACCOUNT_PWD_SETTINGS_CLICK_VALUE = 44;
    
    public static final int APP_FIND_CLICK_VALUE = 29;
    
    public static final int APP_LIVE_CLICK_VALUE = 28;
    
    public static final int APP_ME_CLICK_VALUE = 31;
    
    public static final int APP_MSG_CLICK_VALUE = 30;
    
    public static final int APP_NEARBY_CLICK_VALUE = 27;
    
    public static final int AV_FACE_RESULT_SHOW_VALUE = 40;
    
    public static final int AV_IDCARD_RESULT_SHOW_VALUE = 41;
    
    public static final int BOUND_WECHAT_VALUE = 34;
    
    public static final int CANCEL_ACCOUNT_BTN_CLICK_VALUE = 1;
    
    public static final int CHANGE_ACCOUNT_CLICK_VALUE = 2;
    
    public static final int DARK_MODE_BTN_CLICK_VALUE = 7;
    
    public static final int DEEP_LINK_CLICK_VALUE = 26;
    
    public static final int GESTURE_PWD_SETTINGS_CLICK_VALUE = 46;
    
    public static final int LOGIN_PROTECTION_VALUE = 37;
    
    public static final int LOGOUT_BTN_CLICK_VALUE = 32;
    
    public static final int MINE_AREA_SHOW_VALUE = 5;
    
    public static final int MINE_BTN_CLICK_VALUE = 6;
    
    public static final int MINE_EDIT_MORE_PHOTO_BTN_CLICK_VALUE = 23;
    
    public static final int MINE_EDIT_PERSONALITY_BTN_CLICK_VALUE = 22;
    
    public static final int MINE_HELP_RENEW_BUY_CLICK_VALUE = 25;
    
    public static final int MINE_SETTINGS_ANTI_HARASS_VALUE = 8;
    
    public static final int MINE_SETTINGS_COMMON_CHANGE_BG_CLICK_VALUE = 21;
    
    public static final int MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK_VALUE = 20;
    
    public static final int MINE_SETTINGS_MSG_CLICK_VALUE = 47;
    
    public static final int MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK_VALUE = 48;
    
    public static final int MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK_VALUE = 49;
    
    public static final int MINE_SETTINGS_PRIVACY_ACCESS_CLICK_VALUE = 18;
    
    public static final int MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK_VALUE = 12;
    
    public static final int MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK_VALUE = 11;
    
    public static final int MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK_VALUE = 10;
    
    public static final int MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK_VALUE = 13;
    
    public static final int MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK_VALUE = 19;
    
    public static final int MINE_VIP_BANNER_CENTER_CLICK_VALUE = 9;
    
    public static final int MINE_VIP_BANNER_COPYWRITING_CLICK_VALUE = 4;
    
    public static final int MINE_VIP_BANNER_COPYWRITING_SHOW_VALUE = 3;
    
    public static final int PATTERN_LOCK_CLOSE_VALUE = 36;
    
    public static final int PATTERN_LOCK_OPEN_VALUE = 35;
    
    public static final int PAY_PWD_SETTINGS_CLICK_VALUE = 45;
    
    public static final int PERSONAL_VERIFY_SHOW_VALUE = 39;
    
    public static final int PWD_SETTINGS_CLICK_VALUE = 43;
    
    public static final int UNBOUND_WECHAT_VALUE = 33;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    public static final int VERIFY_PHOTO_UPLOADED_VALUE = 38;
    
    public static final int WORD_SIZE_CHANGE_VALUE = 24;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      MINE_VIP_BANNER_COPYWRITING_CLICK = new Event("MINE_VIP_BANNER_COPYWRITING_CLICK", 4, 4);
      MINE_AREA_SHOW = new Event("MINE_AREA_SHOW", 5, 5);
      MINE_BTN_CLICK = new Event("MINE_BTN_CLICK", 6, 6);
      DARK_MODE_BTN_CLICK = new Event("DARK_MODE_BTN_CLICK", 7, 7);
      MINE_SETTINGS_ANTI_HARASS = new Event("MINE_SETTINGS_ANTI_HARASS", 8, 8);
      MINE_VIP_BANNER_CENTER_CLICK = new Event("MINE_VIP_BANNER_CENTER_CLICK", 9, 9);
      MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK = new Event("MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK", 10, 10);
      MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK = new Event("MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK", 11, 11);
      MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK = new Event("MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK", 12, 12);
      MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK = new Event("MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK", 13, 13);
      MINE_SETTINGS_PRIVACY_ACCESS_CLICK = new Event("MINE_SETTINGS_PRIVACY_ACCESS_CLICK", 14, 18);
      MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK = new Event("MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK", 15, 19);
      MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK = new Event("MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK", 16, 20);
      MINE_SETTINGS_COMMON_CHANGE_BG_CLICK = new Event("MINE_SETTINGS_COMMON_CHANGE_BG_CLICK", 17, 21);
      MINE_EDIT_PERSONALITY_BTN_CLICK = new Event("MINE_EDIT_PERSONALITY_BTN_CLICK", 18, 22);
      MINE_EDIT_MORE_PHOTO_BTN_CLICK = new Event("MINE_EDIT_MORE_PHOTO_BTN_CLICK", 19, 23);
      WORD_SIZE_CHANGE = new Event("WORD_SIZE_CHANGE", 20, 24);
      MINE_HELP_RENEW_BUY_CLICK = new Event("MINE_HELP_RENEW_BUY_CLICK", 21, 25);
      DEEP_LINK_CLICK = new Event("DEEP_LINK_CLICK", 22, 26);
      APP_NEARBY_CLICK = new Event("APP_NEARBY_CLICK", 23, 27);
      APP_LIVE_CLICK = new Event("APP_LIVE_CLICK", 24, 28);
      APP_FIND_CLICK = new Event("APP_FIND_CLICK", 25, 29);
      APP_MSG_CLICK = new Event("APP_MSG_CLICK", 26, 30);
      APP_ME_CLICK = new Event("APP_ME_CLICK", 27, 31);
      LOGOUT_BTN_CLICK = new Event("LOGOUT_BTN_CLICK", 28, 32);
      UNBOUND_WECHAT = new Event("UNBOUND_WECHAT", 29, 33);
      BOUND_WECHAT = new Event("BOUND_WECHAT", 30, 34);
      PATTERN_LOCK_OPEN = new Event("PATTERN_LOCK_OPEN", 31, 35);
      PATTERN_LOCK_CLOSE = new Event("PATTERN_LOCK_CLOSE", 32, 36);
      LOGIN_PROTECTION = new Event("LOGIN_PROTECTION", 33, 37);
      VERIFY_PHOTO_UPLOADED = new Event("VERIFY_PHOTO_UPLOADED", 34, 38);
      PERSONAL_VERIFY_SHOW = new Event("PERSONAL_VERIFY_SHOW", 35, 39);
      AV_FACE_RESULT_SHOW = new Event("AV_FACE_RESULT_SHOW", 36, 40);
      AV_IDCARD_RESULT_SHOW = new Event("AV_IDCARD_RESULT_SHOW", 37, 41);
      ACCOUNT_LOCK_APPEAL_CLICK = new Event("ACCOUNT_LOCK_APPEAL_CLICK", 38, 42);
      PWD_SETTINGS_CLICK = new Event("PWD_SETTINGS_CLICK", 39, 43);
      ACCOUNT_PWD_SETTINGS_CLICK = new Event("ACCOUNT_PWD_SETTINGS_CLICK", 40, 44);
      PAY_PWD_SETTINGS_CLICK = new Event("PAY_PWD_SETTINGS_CLICK", 41, 45);
      GESTURE_PWD_SETTINGS_CLICK = new Event("GESTURE_PWD_SETTINGS_CLICK", 42, 46);
      MINE_SETTINGS_MSG_CLICK = new Event("MINE_SETTINGS_MSG_CLICK", 43, 47);
      MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK = new Event("MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK", 44, 48);
      MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK = new Event("MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK", 45, 49);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 46, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, CANCEL_ACCOUNT_BTN_CLICK, CHANGE_ACCOUNT_CLICK, MINE_VIP_BANNER_COPYWRITING_SHOW, MINE_VIP_BANNER_COPYWRITING_CLICK, MINE_AREA_SHOW, MINE_BTN_CLICK, DARK_MODE_BTN_CLICK, MINE_SETTINGS_ANTI_HARASS, MINE_VIP_BANNER_CENTER_CLICK, 
          MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK, MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK, MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK, MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK, MINE_SETTINGS_PRIVACY_ACCESS_CLICK, MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK, MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK, MINE_SETTINGS_COMMON_CHANGE_BG_CLICK, MINE_EDIT_PERSONALITY_BTN_CLICK, MINE_EDIT_MORE_PHOTO_BTN_CLICK, 
          WORD_SIZE_CHANGE, MINE_HELP_RENEW_BUY_CLICK, DEEP_LINK_CLICK, APP_NEARBY_CLICK, APP_LIVE_CLICK, APP_FIND_CLICK, APP_MSG_CLICK, APP_ME_CLICK, LOGOUT_BTN_CLICK, UNBOUND_WECHAT, 
          BOUND_WECHAT, PATTERN_LOCK_OPEN, PATTERN_LOCK_CLOSE, LOGIN_PROTECTION, VERIFY_PHOTO_UPLOADED, PERSONAL_VERIFY_SHOW, AV_FACE_RESULT_SHOW, AV_IDCARD_RESULT_SHOW, ACCOUNT_LOCK_APPEAL_CLICK, PWD_SETTINGS_CLICK, 
          ACCOUNT_PWD_SETTINGS_CLICK, PAY_PWD_SETTINGS_CLICK, GESTURE_PWD_SETTINGS_CLICK, MINE_SETTINGS_MSG_CLICK, MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK, MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public SettingsProtos.Event findValueByNumber(int param2Int) {
            return SettingsProtos.Event.forNumber(param2Int);
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
        case 49:
          return MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK;
        case 48:
          return MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK;
        case 47:
          return MINE_SETTINGS_MSG_CLICK;
        case 46:
          return GESTURE_PWD_SETTINGS_CLICK;
        case 45:
          return PAY_PWD_SETTINGS_CLICK;
        case 44:
          return ACCOUNT_PWD_SETTINGS_CLICK;
        case 43:
          return PWD_SETTINGS_CLICK;
        case 42:
          return ACCOUNT_LOCK_APPEAL_CLICK;
        case 41:
          return AV_IDCARD_RESULT_SHOW;
        case 40:
          return AV_FACE_RESULT_SHOW;
        case 39:
          return PERSONAL_VERIFY_SHOW;
        case 38:
          return VERIFY_PHOTO_UPLOADED;
        case 37:
          return LOGIN_PROTECTION;
        case 36:
          return PATTERN_LOCK_CLOSE;
        case 35:
          return PATTERN_LOCK_OPEN;
        case 34:
          return BOUND_WECHAT;
        case 33:
          return UNBOUND_WECHAT;
        case 32:
          return LOGOUT_BTN_CLICK;
        case 31:
          return APP_ME_CLICK;
        case 30:
          return APP_MSG_CLICK;
        case 29:
          return APP_FIND_CLICK;
        case 28:
          return APP_LIVE_CLICK;
        case 27:
          return APP_NEARBY_CLICK;
        case 26:
          return DEEP_LINK_CLICK;
        case 25:
          return MINE_HELP_RENEW_BUY_CLICK;
        case 24:
          return WORD_SIZE_CHANGE;
        case 23:
          return MINE_EDIT_MORE_PHOTO_BTN_CLICK;
        case 22:
          return MINE_EDIT_PERSONALITY_BTN_CLICK;
        case 21:
          return MINE_SETTINGS_COMMON_CHANGE_BG_CLICK;
        case 20:
          return MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK;
        case 19:
          return MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK;
        case 18:
          return MINE_SETTINGS_PRIVACY_ACCESS_CLICK;
        case 13:
          return MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK;
        case 12:
          return MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK;
        case 11:
          return MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK;
        case 10:
          return MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK;
        case 9:
          return MINE_VIP_BANNER_CENTER_CLICK;
        case 8:
          return MINE_SETTINGS_ANTI_HARASS;
        case 7:
          return DARK_MODE_BTN_CLICK;
        case 6:
          return MINE_BTN_CLICK;
        case 5:
          return MINE_AREA_SHOW;
        case 4:
          return MINE_VIP_BANNER_COPYWRITING_CLICK;
        case 3:
          return MINE_VIP_BANNER_COPYWRITING_SHOW;
        case 2:
          return CHANGE_ACCOUNT_CLICK;
        case 1:
          return CANCEL_ACCOUNT_BTN_CLICK;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SettingsProtos.getDescriptor().getEnumTypes().get(0);
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
    public SettingsProtos.Event findValueByNumber(int param1Int) {
      return SettingsProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum ModuleType implements ProtocolMessageEnum {
    AGENCY_BANNER(0),
    HEALTH(0),
    HEER_BANNER(0),
    SETTYINGS(0),
    UNKNOWN_MODULE_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int AGENCY_BANNER_VALUE = 1;
    
    public static final int HEALTH_VALUE = 2;
    
    public static final int HEER_BANNER_VALUE = 3;
    
    public static final int SETTYINGS_VALUE = 4;
    
    public static final int UNKNOWN_MODULE_TYPE_VALUE = 0;
    
    private static final ModuleType[] VALUES;
    
    private static final Internal.EnumLiteMap<ModuleType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new ModuleType[] { UNKNOWN_MODULE_TYPE, AGENCY_BANNER, HEALTH, HEER_BANNER, SETTYINGS, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ModuleType>() {
          public SettingsProtos.ModuleType findValueByNumber(int param2Int) {
            return SettingsProtos.ModuleType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    ModuleType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ModuleType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : SETTYINGS) : HEER_BANNER) : HEALTH) : AGENCY_BANNER) : UNKNOWN_MODULE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SettingsProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<ModuleType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<ModuleType> {
    public SettingsProtos.ModuleType findValueByNumber(int param1Int) {
      return SettingsProtos.ModuleType.forNumber(param1Int);
    }
  }
  
  public static final class SettingsProto extends GeneratedMessageV3 implements SettingsProtoOrBuilder {
    public static final int BANNER_ID_FIELD_NUMBER = 5;
    
    private static final SettingsProto DEFAULT_INSTANCE = new SettingsProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FROM_FIELD_NUMBER = 11;
    
    public static final int IS_AUTO_FIELD_NUMBER = 7;
    
    public static final int IS_OPEN_FIELD_NUMBER = 6;
    
    public static final int IS_SHADOW_FIELD_NUMBER = 8;
    
    public static final int LINK_URL_FIELD_NUMBER = 3;
    
    public static final int MODULE_TYPE_FIELD_NUMBER = 4;
    
    public static final int NAME_FIELD_NUMBER = 2;
    
    public static final int NUM_FIELD_NUMBER = 9;
    
    private static final Parser<SettingsProto> PARSER = (Parser<SettingsProto>)new AbstractParser<SettingsProto>() {
        public SettingsProtos.SettingsProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new SettingsProtos.SettingsProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int POSITION_FIELD_NUMBER = 10;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object bannerId_;
    
    private int event_;
    
    private int from_;
    
    private boolean isAuto_;
    
    private boolean isOpen_;
    
    private boolean isShadow_;
    
    private volatile Object linkUrl_;
    
    private byte memoizedIsInitialized = -1;
    
    private int moduleType_;
    
    private volatile Object name_;
    
    private int num_;
    
    private int position_;
    
    private SettingsProto() {
      this.event_ = 0;
      this.name_ = "";
      this.linkUrl_ = "";
      this.moduleType_ = 0;
      this.bannerId_ = "";
    }
    
    private SettingsProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 88:
                this.from_ = param1CodedInputStream.readInt32();
                continue;
              case 80:
                this.position_ = param1CodedInputStream.readInt32();
                continue;
              case 72:
                this.num_ = param1CodedInputStream.readInt32();
                continue;
              case 64:
                this.isShadow_ = param1CodedInputStream.readBool();
                continue;
              case 56:
                this.isAuto_ = param1CodedInputStream.readBool();
                continue;
              case 48:
                this.isOpen_ = param1CodedInputStream.readBool();
                continue;
              case 42:
                this.bannerId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 32:
                this.moduleType_ = param1CodedInputStream.readEnum();
                continue;
              case 26:
                this.linkUrl_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 18:
                this.name_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private SettingsProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static SettingsProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SettingsProto param1SettingsProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1SettingsProto);
    }
    
    public static SettingsProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (SettingsProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static SettingsProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SettingsProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SettingsProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (SettingsProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static SettingsProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SettingsProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static SettingsProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (SettingsProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static SettingsProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SettingsProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static SettingsProto parseFrom(InputStream param1InputStream) throws IOException {
      return (SettingsProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static SettingsProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SettingsProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SettingsProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (SettingsProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static SettingsProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SettingsProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static SettingsProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (SettingsProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static SettingsProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SettingsProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<SettingsProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof SettingsProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((SettingsProto)param1Object).event_) ? false : (!getName().equals(param1Object.getName()) ? false : (!getLinkUrl().equals(param1Object.getLinkUrl()) ? false : ((this.moduleType_ != ((SettingsProto)param1Object).moduleType_) ? false : (!getBannerId().equals(param1Object.getBannerId()) ? false : ((getIsOpen() != param1Object.getIsOpen()) ? false : ((getIsAuto() != param1Object.getIsAuto()) ? false : ((getIsShadow() != param1Object.getIsShadow()) ? false : ((getNum() != param1Object.getNum()) ? false : ((getPosition() != param1Object.getPosition()) ? false : ((getFrom() != param1Object.getFrom()) ? false : (!!this.unknownFields.equals(((SettingsProto)param1Object).unknownFields))))))))))));
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
    
    public SettingsProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public SettingsProtos.Event getEvent() {
      SettingsProtos.Event event2 = SettingsProtos.Event.valueOf(this.event_);
      SettingsProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SettingsProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public boolean getIsAuto() {
      return this.isAuto_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsShadow() {
      return this.isShadow_;
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
    
    public SettingsProtos.ModuleType getModuleType() {
      SettingsProtos.ModuleType moduleType2 = SettingsProtos.ModuleType.valueOf(this.moduleType_);
      SettingsProtos.ModuleType moduleType1 = moduleType2;
      if (moduleType2 == null)
        moduleType1 = SettingsProtos.ModuleType.UNRECOGNIZED; 
      return moduleType1;
    }
    
    public int getModuleTypeValue() {
      return this.moduleType_;
    }
    
    public String getName() {
      Object object = this.name_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.name_ = object;
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public Parser<SettingsProto> getParserForType() {
      return PARSER;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != SettingsProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (!getNameBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.name_); 
      j = i;
      if (!getLinkUrlBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.linkUrl_); 
      i = j;
      if (this.moduleType_ != SettingsProtos.ModuleType.UNKNOWN_MODULE_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(4, this.moduleType_); 
      j = i;
      if (!getBannerIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.bannerId_); 
      boolean bool = this.isOpen_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(6, bool); 
      bool = this.isAuto_;
      int k = i;
      if (bool)
        k = i + CodedOutputStream.computeBoolSize(7, bool); 
      bool = this.isShadow_;
      j = k;
      if (bool)
        j = k + CodedOutputStream.computeBoolSize(8, bool); 
      k = this.num_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(9, k); 
      k = this.position_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(10, k); 
      k = this.from_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(11, k); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getName().hashCode()) * 37 + 3) * 53 + getLinkUrl().hashCode()) * 37 + 4) * 53 + this.moduleType_) * 37 + 5) * 53 + getBannerId().hashCode()) * 37 + 6) * 53 + Internal.hashBoolean(getIsOpen())) * 37 + 7) * 53 + Internal.hashBoolean(getIsAuto())) * 37 + 8) * 53 + Internal.hashBoolean(getIsShadow())) * 37 + 9) * 53 + getNum()) * 37 + 10) * 53 + getPosition()) * 37 + 11) * 53 + getFrom()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SettingsProto.class, Builder.class);
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
      return new SettingsProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != SettingsProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getNameBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.name_); 
      if (!getLinkUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.linkUrl_); 
      if (this.moduleType_ != SettingsProtos.ModuleType.UNKNOWN_MODULE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(4, this.moduleType_); 
      if (!getBannerIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.bannerId_); 
      boolean bool = this.isOpen_;
      if (bool)
        param1CodedOutputStream.writeBool(6, bool); 
      bool = this.isAuto_;
      if (bool)
        param1CodedOutputStream.writeBool(7, bool); 
      bool = this.isShadow_;
      if (bool)
        param1CodedOutputStream.writeBool(8, bool); 
      int i = this.num_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(9, i); 
      i = this.position_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(10, i); 
      i = this.from_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(11, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SettingsProtos.SettingsProtoOrBuilder {
      private Object bannerId_ = "";
      
      private int event_ = 0;
      
      private int from_;
      
      private boolean isAuto_;
      
      private boolean isOpen_;
      
      private boolean isShadow_;
      
      private Object linkUrl_ = "";
      
      private int moduleType_ = 0;
      
      private Object name_ = "";
      
      private int num_;
      
      private int position_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        SettingsProtos.SettingsProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public SettingsProtos.SettingsProto build() {
        SettingsProtos.SettingsProto settingsProto = buildPartial();
        if (settingsProto.isInitialized())
          return settingsProto; 
        throw newUninitializedMessageException(settingsProto);
      }
      
      public SettingsProtos.SettingsProto buildPartial() {
        SettingsProtos.SettingsProto settingsProto = new SettingsProtos.SettingsProto(this);
        SettingsProtos.SettingsProto.access$602(settingsProto, this.event_);
        SettingsProtos.SettingsProto.access$702(settingsProto, this.name_);
        SettingsProtos.SettingsProto.access$802(settingsProto, this.linkUrl_);
        SettingsProtos.SettingsProto.access$902(settingsProto, this.moduleType_);
        SettingsProtos.SettingsProto.access$1002(settingsProto, this.bannerId_);
        SettingsProtos.SettingsProto.access$1102(settingsProto, this.isOpen_);
        SettingsProtos.SettingsProto.access$1202(settingsProto, this.isAuto_);
        SettingsProtos.SettingsProto.access$1302(settingsProto, this.isShadow_);
        SettingsProtos.SettingsProto.access$1402(settingsProto, this.num_);
        SettingsProtos.SettingsProto.access$1502(settingsProto, this.position_);
        SettingsProtos.SettingsProto.access$1602(settingsProto, this.from_);
        onBuilt();
        return settingsProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.name_ = "";
        this.linkUrl_ = "";
        this.moduleType_ = 0;
        this.bannerId_ = "";
        this.isOpen_ = false;
        this.isAuto_ = false;
        this.isShadow_ = false;
        this.num_ = 0;
        this.position_ = 0;
        this.from_ = 0;
        return this;
      }
      
      public Builder clearBannerId() {
        this.bannerId_ = SettingsProtos.SettingsProto.getDefaultInstance().getBannerId();
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
      
      public Builder clearIsAuto() {
        this.isAuto_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsOpen() {
        this.isOpen_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsShadow() {
        this.isShadow_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearLinkUrl() {
        this.linkUrl_ = SettingsProtos.SettingsProto.getDefaultInstance().getLinkUrl();
        onChanged();
        return this;
      }
      
      public Builder clearModuleType() {
        this.moduleType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.name_ = SettingsProtos.SettingsProto.getDefaultInstance().getName();
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
      
      public Builder clearPosition() {
        this.position_ = 0;
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
      
      public SettingsProtos.SettingsProto getDefaultInstanceForType() {
        return SettingsProtos.SettingsProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
      }
      
      public SettingsProtos.Event getEvent() {
        SettingsProtos.Event event2 = SettingsProtos.Event.valueOf(this.event_);
        SettingsProtos.Event event1 = event2;
        if (event2 == null)
          event1 = SettingsProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public int getFrom() {
        return this.from_;
      }
      
      public boolean getIsAuto() {
        return this.isAuto_;
      }
      
      public boolean getIsOpen() {
        return this.isOpen_;
      }
      
      public boolean getIsShadow() {
        return this.isShadow_;
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
      
      public SettingsProtos.ModuleType getModuleType() {
        SettingsProtos.ModuleType moduleType2 = SettingsProtos.ModuleType.valueOf(this.moduleType_);
        SettingsProtos.ModuleType moduleType1 = moduleType2;
        if (moduleType2 == null)
          moduleType1 = SettingsProtos.ModuleType.UNRECOGNIZED; 
        return moduleType1;
      }
      
      public int getModuleTypeValue() {
        return this.moduleType_;
      }
      
      public String getName() {
        Object object = this.name_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.name_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getNameBytes() {
        Object object = this.name_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.name_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getNum() {
        return this.num_;
      }
      
      public int getPosition() {
        return this.position_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SettingsProtos.SettingsProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(SettingsProtos.SettingsProto param2SettingsProto) {
        if (param2SettingsProto == SettingsProtos.SettingsProto.getDefaultInstance())
          return this; 
        if (param2SettingsProto.event_ != 0)
          setEventValue(param2SettingsProto.getEventValue()); 
        if (!param2SettingsProto.getName().isEmpty()) {
          this.name_ = param2SettingsProto.name_;
          onChanged();
        } 
        if (!param2SettingsProto.getLinkUrl().isEmpty()) {
          this.linkUrl_ = param2SettingsProto.linkUrl_;
          onChanged();
        } 
        if (param2SettingsProto.moduleType_ != 0)
          setModuleTypeValue(param2SettingsProto.getModuleTypeValue()); 
        if (!param2SettingsProto.getBannerId().isEmpty()) {
          this.bannerId_ = param2SettingsProto.bannerId_;
          onChanged();
        } 
        if (param2SettingsProto.getIsOpen())
          setIsOpen(param2SettingsProto.getIsOpen()); 
        if (param2SettingsProto.getIsAuto())
          setIsAuto(param2SettingsProto.getIsAuto()); 
        if (param2SettingsProto.getIsShadow())
          setIsShadow(param2SettingsProto.getIsShadow()); 
        if (param2SettingsProto.getNum() != 0)
          setNum(param2SettingsProto.getNum()); 
        if (param2SettingsProto.getPosition() != 0)
          setPosition(param2SettingsProto.getPosition()); 
        if (param2SettingsProto.getFrom() != 0)
          setFrom(param2SettingsProto.getFrom()); 
        mergeUnknownFields(param2SettingsProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          SettingsProtos.SettingsProto settingsProto = (SettingsProtos.SettingsProto)SettingsProtos.SettingsProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          SettingsProtos.SettingsProto settingsProto = (SettingsProtos.SettingsProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((SettingsProtos.SettingsProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof SettingsProtos.SettingsProto)
          return mergeFrom((SettingsProtos.SettingsProto)param2Message); 
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
          SettingsProtos.SettingsProto.checkByteStringIsUtf8(param2ByteString);
          this.bannerId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEvent(SettingsProtos.Event param2Event) {
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
      
      public Builder setFrom(int param2Int) {
        this.from_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIsAuto(boolean param2Boolean) {
        this.isAuto_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsOpen(boolean param2Boolean) {
        this.isOpen_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsShadow(boolean param2Boolean) {
        this.isShadow_ = param2Boolean;
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
          SettingsProtos.SettingsProto.checkByteStringIsUtf8(param2ByteString);
          this.linkUrl_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setModuleType(SettingsProtos.ModuleType param2ModuleType) {
        if (param2ModuleType != null) {
          this.moduleType_ = param2ModuleType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setModuleTypeValue(int param2Int) {
        this.moduleType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setName(String param2String) {
        if (param2String != null) {
          this.name_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SettingsProtos.SettingsProto.checkByteStringIsUtf8(param2ByteString);
          this.name_ = param2ByteString;
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
      
      public Builder setPosition(int param2Int) {
        this.position_ = param2Int;
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
  
  static final class null extends AbstractParser<SettingsProto> {
    public SettingsProtos.SettingsProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new SettingsProtos.SettingsProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<SettingsProto.Builder> implements SettingsProtoOrBuilder {
    private Object bannerId_ = "";
    
    private int event_ = 0;
    
    private int from_;
    
    private boolean isAuto_;
    
    private boolean isOpen_;
    
    private boolean isShadow_;
    
    private Object linkUrl_ = "";
    
    private int moduleType_ = 0;
    
    private Object name_ = "";
    
    private int num_;
    
    private int position_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      SettingsProtos.SettingsProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SettingsProtos.SettingsProto build() {
      SettingsProtos.SettingsProto settingsProto = buildPartial();
      if (settingsProto.isInitialized())
        return settingsProto; 
      throw newUninitializedMessageException(settingsProto);
    }
    
    public SettingsProtos.SettingsProto buildPartial() {
      SettingsProtos.SettingsProto settingsProto = new SettingsProtos.SettingsProto(this);
      SettingsProtos.SettingsProto.access$602(settingsProto, this.event_);
      SettingsProtos.SettingsProto.access$702(settingsProto, this.name_);
      SettingsProtos.SettingsProto.access$802(settingsProto, this.linkUrl_);
      SettingsProtos.SettingsProto.access$902(settingsProto, this.moduleType_);
      SettingsProtos.SettingsProto.access$1002(settingsProto, this.bannerId_);
      SettingsProtos.SettingsProto.access$1102(settingsProto, this.isOpen_);
      SettingsProtos.SettingsProto.access$1202(settingsProto, this.isAuto_);
      SettingsProtos.SettingsProto.access$1302(settingsProto, this.isShadow_);
      SettingsProtos.SettingsProto.access$1402(settingsProto, this.num_);
      SettingsProtos.SettingsProto.access$1502(settingsProto, this.position_);
      SettingsProtos.SettingsProto.access$1602(settingsProto, this.from_);
      onBuilt();
      return settingsProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.name_ = "";
      this.linkUrl_ = "";
      this.moduleType_ = 0;
      this.bannerId_ = "";
      this.isOpen_ = false;
      this.isAuto_ = false;
      this.isShadow_ = false;
      this.num_ = 0;
      this.position_ = 0;
      this.from_ = 0;
      return this;
    }
    
    public Builder clearBannerId() {
      this.bannerId_ = SettingsProtos.SettingsProto.getDefaultInstance().getBannerId();
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
    
    public Builder clearIsAuto() {
      this.isAuto_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsOpen() {
      this.isOpen_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsShadow() {
      this.isShadow_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearLinkUrl() {
      this.linkUrl_ = SettingsProtos.SettingsProto.getDefaultInstance().getLinkUrl();
      onChanged();
      return this;
    }
    
    public Builder clearModuleType() {
      this.moduleType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = SettingsProtos.SettingsProto.getDefaultInstance().getName();
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
    
    public Builder clearPosition() {
      this.position_ = 0;
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
    
    public SettingsProtos.SettingsProto getDefaultInstanceForType() {
      return SettingsProtos.SettingsProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
    }
    
    public SettingsProtos.Event getEvent() {
      SettingsProtos.Event event2 = SettingsProtos.Event.valueOf(this.event_);
      SettingsProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SettingsProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public boolean getIsAuto() {
      return this.isAuto_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsShadow() {
      return this.isShadow_;
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
    
    public SettingsProtos.ModuleType getModuleType() {
      SettingsProtos.ModuleType moduleType2 = SettingsProtos.ModuleType.valueOf(this.moduleType_);
      SettingsProtos.ModuleType moduleType1 = moduleType2;
      if (moduleType2 == null)
        moduleType1 = SettingsProtos.ModuleType.UNRECOGNIZED; 
      return moduleType1;
    }
    
    public int getModuleTypeValue() {
      return this.moduleType_;
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.name_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getNum() {
      return this.num_;
    }
    
    public int getPosition() {
      return this.position_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SettingsProtos.SettingsProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SettingsProtos.SettingsProto param1SettingsProto) {
      if (param1SettingsProto == SettingsProtos.SettingsProto.getDefaultInstance())
        return this; 
      if (param1SettingsProto.event_ != 0)
        setEventValue(param1SettingsProto.getEventValue()); 
      if (!param1SettingsProto.getName().isEmpty()) {
        this.name_ = param1SettingsProto.name_;
        onChanged();
      } 
      if (!param1SettingsProto.getLinkUrl().isEmpty()) {
        this.linkUrl_ = param1SettingsProto.linkUrl_;
        onChanged();
      } 
      if (param1SettingsProto.moduleType_ != 0)
        setModuleTypeValue(param1SettingsProto.getModuleTypeValue()); 
      if (!param1SettingsProto.getBannerId().isEmpty()) {
        this.bannerId_ = param1SettingsProto.bannerId_;
        onChanged();
      } 
      if (param1SettingsProto.getIsOpen())
        setIsOpen(param1SettingsProto.getIsOpen()); 
      if (param1SettingsProto.getIsAuto())
        setIsAuto(param1SettingsProto.getIsAuto()); 
      if (param1SettingsProto.getIsShadow())
        setIsShadow(param1SettingsProto.getIsShadow()); 
      if (param1SettingsProto.getNum() != 0)
        setNum(param1SettingsProto.getNum()); 
      if (param1SettingsProto.getPosition() != 0)
        setPosition(param1SettingsProto.getPosition()); 
      if (param1SettingsProto.getFrom() != 0)
        setFrom(param1SettingsProto.getFrom()); 
      mergeUnknownFields(param1SettingsProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SettingsProtos.SettingsProto settingsProto = (SettingsProtos.SettingsProto)SettingsProtos.SettingsProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SettingsProtos.SettingsProto settingsProto = (SettingsProtos.SettingsProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SettingsProtos.SettingsProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SettingsProtos.SettingsProto)
        return mergeFrom((SettingsProtos.SettingsProto)param1Message); 
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
        SettingsProtos.SettingsProto.checkByteStringIsUtf8(param1ByteString);
        this.bannerId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEvent(SettingsProtos.Event param1Event) {
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
    
    public Builder setFrom(int param1Int) {
      this.from_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIsAuto(boolean param1Boolean) {
      this.isAuto_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsOpen(boolean param1Boolean) {
      this.isOpen_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsShadow(boolean param1Boolean) {
      this.isShadow_ = param1Boolean;
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
        SettingsProtos.SettingsProto.checkByteStringIsUtf8(param1ByteString);
        this.linkUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setModuleType(SettingsProtos.ModuleType param1ModuleType) {
      if (param1ModuleType != null) {
        this.moduleType_ = param1ModuleType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setModuleTypeValue(int param1Int) {
      this.moduleType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SettingsProtos.SettingsProto.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
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
    
    public Builder setPosition(int param1Int) {
      this.position_ = param1Int;
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
  
  public static interface SettingsProtoOrBuilder extends MessageOrBuilder {
    String getBannerId();
    
    ByteString getBannerIdBytes();
    
    SettingsProtos.Event getEvent();
    
    int getEventValue();
    
    int getFrom();
    
    boolean getIsAuto();
    
    boolean getIsOpen();
    
    boolean getIsShadow();
    
    String getLinkUrl();
    
    ByteString getLinkUrlBytes();
    
    SettingsProtos.ModuleType getModuleType();
    
    int getModuleTypeValue();
    
    String getName();
    
    ByteString getNameBytes();
    
    int getNum();
    
    int getPosition();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\settings\SettingsProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
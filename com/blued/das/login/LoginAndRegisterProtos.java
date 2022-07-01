package com.blued.das.login;

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

public final class LoginAndRegisterProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034LoginAndRegisterProtos.proto\022\023com.blued.das.login\"Î\003\n\025LoginAndRegisterProto\022)\n\005event\030\001 \001(\0162\032.com.blued.das.login.Event\0220\n\tunit_type\030\002 \001(\0162\035.com.blued.das.login.UnitType\0220\n\trole_type\030\003 \001(\0162\035.com.blued.das.login.RoleType\0226\n\flabel_status\030\004 \001(\0162 .com.blued.das.login.LabelStatus\022\022\n\ntarget_uid\030\005 \001(\t\022\027\n\017target_uid_list\030\006 \001(\t\022+\n\006source\030\007 \001(\0162\033.com.blued.das.login.Source\0222\n\nlabel_type\030\b \001(\0162\036.com.blued.das.login.LabelType\022\020\n\bduration\030\t \001(\005\022\026\n\016third_duration\030\n \001(\005\022\023\n\013is_callback\030\013 \001(\b\022\023\n\013ori_channel\030\f \001(\t\022\f\n\004json\030\r \001(\t*µ\t\n\005Event\022\013\n\007UNKNOWN\020\000\022\023\n\017LOGIN_BTN_CLICK\020\001\022!\n\035LOGIN_PAGE_REGISTER_BTN_CLICK\020\002\022$\n LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK\020\003\022$\n REGISTER_PAGE_REGISTER_BTN_CLICK\020\004\022'\n#REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK\020\005\022\036\n\032AUTHCODE_CONFIRM_BTN_CLICK\020\006\022\035\n\031AUTHCODE_RESEND_BTN_CLICK\020\007\022(\n$PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK\020\b\022\024\n\020REGISTER_SUCCESS\020\t\022\034\n\030REC_PAGE_ENTER_BTN_CLICK\020\n\022)\n%PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK\020\013\0221\n-PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK\020\f\022%\n!PROFILE_WRITE_PAGE_UNIT_BTN_CLICK\020\r\022%\n!PROFILE_WRITE_PAGE_ROLE_BTN_CLICK\020\016\022!\n\035PERSONAL_LABEL_NEXT_BTN_CLICK\020\017\022\035\n\031LIKE_LABEL_NEXT_BTN_CLICK\020\020\022#\n\037RECOMMEND_PAGE_GRID_AVATAR_DRAW\020\021\022\037\n\033RECOMMEND_PAGE_POP_UPS_SHOW\020\022\022'\n#RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK\020\023\022\033\n\027PROFILE_WRITE_PAGE_SHOW\020\024\022\026\n\022ONE_CLICK_POP_SHOW\020\025\022\034\n\030ONE_CLICK_POP_TRUE_CLICK\020\026\022\032\n\026LOGIN_PRIVACY_POP_SHOW\020\027\022!\n\035LOGIN_PRIVACY_POP_AGREE_CLICK\020\030\022$\n LOGIN_PRIVACY_POP_DISAGREE_CLICK\020\031\022\034\n\030LOGIN_AUTHORITY_POP_SHOW\020\032\022\"\n\036LOGIN_AUTHORITY_POP_OPEN_CLICK\020\033\022\025\n\021FIND_PWD_BY_PHONE\020\034\022\031\n\025FIND_PWD_BY_REG_EMAIL\020\035\022\032\n\026FIND_PWD_BY_SAFE_EMAIL\020\036\022\021\n\rLOGIN_SUCCESS\020\037\022\037\n\033REGISTER_APPLE_ID_BTN_CLICK\020 \022\035\n\031ONE_CLICK_LOGIN_BTN_CLICK\020!\022%\n!OPEN_PAGE_CREATE_TO_SHOW_DURATION\020\"\022\023\n\017HW_CHANNEL_DATA\020#\022\020\n\fJD_AD_TO_APP\020$\022\017\n\013JD_AD_TO_H5\020%*7\n\bUnitType\022\025\n\021UNKNOWN_UNIT_TYPE\020\000\022\t\n\005FT_LB\020\001\022\t\n\005CM_KG\020\002*I\n\bRoleType\022\025\n\021UNKNOWN_ROLE_TYPE\020\000\022\007\n\003ONE\020\001\022\b\n\004ZERO\020\002\022\b\n\004HARF\020\003\022\t\n\005OTHER\020\004*\\\n\013LabelStatus\022\030\n\024UNKNOWN_LABEL_STATUS\020\000\022\021\n\rINITIATIVE_NO\020\001\022\023\n\017INITIATIVE_HAVE\020\002\022\013\n\007DEFAULT\020\003*D\n\tLabelType\022\026\n\022UNKNOWN_LABEL_TYPE\020\000\022\b\n\004BODY\020\001\022\013\n\007FEATURE\020\002\022\b\n\004WANT\020\003*h\n\006Source\022\022\n\016UNKNOWN_SOURCE\020\000\022\t\n\005PHONE\020\001\022\n\n\006WECHAT\020\002\022\t\n\005APPLE\020\003\022\r\n\tONE_CLICK\020\004\022\t\n\005EMAIL\020\005\022\016\n\nPHONE_CODE\020\006B\025¢\002\022LOGIN_AND_REGISTERb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor, new String[] { 
        "Event", "UnitType", "RoleType", "LabelStatus", "TargetUid", "TargetUidList", "Source", "LabelType", "Duration", "ThirdDuration", 
        "IsCallback", "OriChannel", "Json" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    AUTHCODE_CONFIRM_BTN_CLICK,
    AUTHCODE_RESEND_BTN_CLICK,
    FIND_PWD_BY_PHONE,
    FIND_PWD_BY_REG_EMAIL,
    FIND_PWD_BY_SAFE_EMAIL,
    HW_CHANNEL_DATA,
    JD_AD_TO_APP,
    JD_AD_TO_H5,
    LIKE_LABEL_NEXT_BTN_CLICK,
    LOGIN_AUTHORITY_POP_OPEN_CLICK,
    LOGIN_AUTHORITY_POP_SHOW,
    LOGIN_BTN_CLICK,
    LOGIN_PAGE_REGISTER_BTN_CLICK,
    LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK,
    LOGIN_PRIVACY_POP_AGREE_CLICK,
    LOGIN_PRIVACY_POP_DISAGREE_CLICK,
    LOGIN_PRIVACY_POP_SHOW,
    LOGIN_SUCCESS,
    ONE_CLICK_LOGIN_BTN_CLICK,
    ONE_CLICK_POP_SHOW,
    ONE_CLICK_POP_TRUE_CLICK,
    OPEN_PAGE_CREATE_TO_SHOW_DURATION,
    PERSONAL_LABEL_NEXT_BTN_CLICK,
    PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK,
    PROFILE_WRITE_PAGE_ROLE_BTN_CLICK,
    PROFILE_WRITE_PAGE_SHOW,
    PROFILE_WRITE_PAGE_UNIT_BTN_CLICK,
    PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK,
    PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK,
    RECOMMEND_PAGE_GRID_AVATAR_DRAW,
    RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK,
    RECOMMEND_PAGE_POP_UPS_SHOW,
    REC_PAGE_ENTER_BTN_CLICK,
    REGISTER_APPLE_ID_BTN_CLICK,
    REGISTER_PAGE_REGISTER_BTN_CLICK,
    REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK,
    REGISTER_SUCCESS,
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int AUTHCODE_CONFIRM_BTN_CLICK_VALUE = 6;
    
    public static final int AUTHCODE_RESEND_BTN_CLICK_VALUE = 7;
    
    public static final int FIND_PWD_BY_PHONE_VALUE = 28;
    
    public static final int FIND_PWD_BY_REG_EMAIL_VALUE = 29;
    
    public static final int FIND_PWD_BY_SAFE_EMAIL_VALUE = 30;
    
    public static final int HW_CHANNEL_DATA_VALUE = 35;
    
    public static final int JD_AD_TO_APP_VALUE = 36;
    
    public static final int JD_AD_TO_H5_VALUE = 37;
    
    public static final int LIKE_LABEL_NEXT_BTN_CLICK_VALUE = 16;
    
    public static final int LOGIN_AUTHORITY_POP_OPEN_CLICK_VALUE = 27;
    
    public static final int LOGIN_AUTHORITY_POP_SHOW_VALUE = 26;
    
    public static final int LOGIN_BTN_CLICK_VALUE = 1;
    
    public static final int LOGIN_PAGE_REGISTER_BTN_CLICK_VALUE = 2;
    
    public static final int LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK_VALUE = 3;
    
    public static final int LOGIN_PRIVACY_POP_AGREE_CLICK_VALUE = 24;
    
    public static final int LOGIN_PRIVACY_POP_DISAGREE_CLICK_VALUE = 25;
    
    public static final int LOGIN_PRIVACY_POP_SHOW_VALUE = 23;
    
    public static final int LOGIN_SUCCESS_VALUE = 31;
    
    public static final int ONE_CLICK_LOGIN_BTN_CLICK_VALUE = 33;
    
    public static final int ONE_CLICK_POP_SHOW_VALUE = 21;
    
    public static final int ONE_CLICK_POP_TRUE_CLICK_VALUE = 22;
    
    public static final int OPEN_PAGE_CREATE_TO_SHOW_DURATION_VALUE = 34;
    
    public static final int PERSONAL_LABEL_NEXT_BTN_CLICK_VALUE = 15;
    
    public static final int PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK_VALUE = 8;
    
    public static final int PROFILE_WRITE_PAGE_ROLE_BTN_CLICK_VALUE = 14;
    
    public static final int PROFILE_WRITE_PAGE_SHOW_VALUE = 20;
    
    public static final int PROFILE_WRITE_PAGE_UNIT_BTN_CLICK_VALUE = 13;
    
    public static final int PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK_VALUE = 11;
    
    public static final int PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK_VALUE = 12;
    
    public static final int RECOMMEND_PAGE_GRID_AVATAR_DRAW_VALUE = 17;
    
    public static final int RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK_VALUE = 19;
    
    public static final int RECOMMEND_PAGE_POP_UPS_SHOW_VALUE = 18;
    
    public static final int REC_PAGE_ENTER_BTN_CLICK_VALUE = 10;
    
    public static final int REGISTER_APPLE_ID_BTN_CLICK_VALUE = 32;
    
    public static final int REGISTER_PAGE_REGISTER_BTN_CLICK_VALUE = 4;
    
    public static final int REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK_VALUE = 5;
    
    public static final int REGISTER_SUCCESS_VALUE = 9;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      AUTHCODE_CONFIRM_BTN_CLICK = new Event("AUTHCODE_CONFIRM_BTN_CLICK", 6, 6);
      AUTHCODE_RESEND_BTN_CLICK = new Event("AUTHCODE_RESEND_BTN_CLICK", 7, 7);
      PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK = new Event("PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK", 8, 8);
      REGISTER_SUCCESS = new Event("REGISTER_SUCCESS", 9, 9);
      REC_PAGE_ENTER_BTN_CLICK = new Event("REC_PAGE_ENTER_BTN_CLICK", 10, 10);
      PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK = new Event("PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK", 11, 11);
      PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK = new Event("PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK", 12, 12);
      PROFILE_WRITE_PAGE_UNIT_BTN_CLICK = new Event("PROFILE_WRITE_PAGE_UNIT_BTN_CLICK", 13, 13);
      PROFILE_WRITE_PAGE_ROLE_BTN_CLICK = new Event("PROFILE_WRITE_PAGE_ROLE_BTN_CLICK", 14, 14);
      PERSONAL_LABEL_NEXT_BTN_CLICK = new Event("PERSONAL_LABEL_NEXT_BTN_CLICK", 15, 15);
      LIKE_LABEL_NEXT_BTN_CLICK = new Event("LIKE_LABEL_NEXT_BTN_CLICK", 16, 16);
      RECOMMEND_PAGE_GRID_AVATAR_DRAW = new Event("RECOMMEND_PAGE_GRID_AVATAR_DRAW", 17, 17);
      RECOMMEND_PAGE_POP_UPS_SHOW = new Event("RECOMMEND_PAGE_POP_UPS_SHOW", 18, 18);
      RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK = new Event("RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK", 19, 19);
      PROFILE_WRITE_PAGE_SHOW = new Event("PROFILE_WRITE_PAGE_SHOW", 20, 20);
      ONE_CLICK_POP_SHOW = new Event("ONE_CLICK_POP_SHOW", 21, 21);
      ONE_CLICK_POP_TRUE_CLICK = new Event("ONE_CLICK_POP_TRUE_CLICK", 22, 22);
      LOGIN_PRIVACY_POP_SHOW = new Event("LOGIN_PRIVACY_POP_SHOW", 23, 23);
      LOGIN_PRIVACY_POP_AGREE_CLICK = new Event("LOGIN_PRIVACY_POP_AGREE_CLICK", 24, 24);
      LOGIN_PRIVACY_POP_DISAGREE_CLICK = new Event("LOGIN_PRIVACY_POP_DISAGREE_CLICK", 25, 25);
      LOGIN_AUTHORITY_POP_SHOW = new Event("LOGIN_AUTHORITY_POP_SHOW", 26, 26);
      LOGIN_AUTHORITY_POP_OPEN_CLICK = new Event("LOGIN_AUTHORITY_POP_OPEN_CLICK", 27, 27);
      FIND_PWD_BY_PHONE = new Event("FIND_PWD_BY_PHONE", 28, 28);
      FIND_PWD_BY_REG_EMAIL = new Event("FIND_PWD_BY_REG_EMAIL", 29, 29);
      FIND_PWD_BY_SAFE_EMAIL = new Event("FIND_PWD_BY_SAFE_EMAIL", 30, 30);
      LOGIN_SUCCESS = new Event("LOGIN_SUCCESS", 31, 31);
      REGISTER_APPLE_ID_BTN_CLICK = new Event("REGISTER_APPLE_ID_BTN_CLICK", 32, 32);
      ONE_CLICK_LOGIN_BTN_CLICK = new Event("ONE_CLICK_LOGIN_BTN_CLICK", 33, 33);
      OPEN_PAGE_CREATE_TO_SHOW_DURATION = new Event("OPEN_PAGE_CREATE_TO_SHOW_DURATION", 34, 34);
      HW_CHANNEL_DATA = new Event("HW_CHANNEL_DATA", 35, 35);
      JD_AD_TO_APP = new Event("JD_AD_TO_APP", 36, 36);
      JD_AD_TO_H5 = new Event("JD_AD_TO_H5", 37, 37);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 38, -1);
      $VALUES = new Event[] { 
          UNKNOWN, LOGIN_BTN_CLICK, LOGIN_PAGE_REGISTER_BTN_CLICK, LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK, REGISTER_PAGE_REGISTER_BTN_CLICK, REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK, AUTHCODE_CONFIRM_BTN_CLICK, AUTHCODE_RESEND_BTN_CLICK, PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK, REGISTER_SUCCESS, 
          REC_PAGE_ENTER_BTN_CLICK, PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK, PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK, PROFILE_WRITE_PAGE_UNIT_BTN_CLICK, PROFILE_WRITE_PAGE_ROLE_BTN_CLICK, PERSONAL_LABEL_NEXT_BTN_CLICK, LIKE_LABEL_NEXT_BTN_CLICK, RECOMMEND_PAGE_GRID_AVATAR_DRAW, RECOMMEND_PAGE_POP_UPS_SHOW, RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK, 
          PROFILE_WRITE_PAGE_SHOW, ONE_CLICK_POP_SHOW, ONE_CLICK_POP_TRUE_CLICK, LOGIN_PRIVACY_POP_SHOW, LOGIN_PRIVACY_POP_AGREE_CLICK, LOGIN_PRIVACY_POP_DISAGREE_CLICK, LOGIN_AUTHORITY_POP_SHOW, LOGIN_AUTHORITY_POP_OPEN_CLICK, FIND_PWD_BY_PHONE, FIND_PWD_BY_REG_EMAIL, 
          FIND_PWD_BY_SAFE_EMAIL, LOGIN_SUCCESS, REGISTER_APPLE_ID_BTN_CLICK, ONE_CLICK_LOGIN_BTN_CLICK, OPEN_PAGE_CREATE_TO_SHOW_DURATION, HW_CHANNEL_DATA, JD_AD_TO_APP, JD_AD_TO_H5, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public LoginAndRegisterProtos.Event findValueByNumber(int param2Int) {
            return LoginAndRegisterProtos.Event.forNumber(param2Int);
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
        case 37:
          return JD_AD_TO_H5;
        case 36:
          return JD_AD_TO_APP;
        case 35:
          return HW_CHANNEL_DATA;
        case 34:
          return OPEN_PAGE_CREATE_TO_SHOW_DURATION;
        case 33:
          return ONE_CLICK_LOGIN_BTN_CLICK;
        case 32:
          return REGISTER_APPLE_ID_BTN_CLICK;
        case 31:
          return LOGIN_SUCCESS;
        case 30:
          return FIND_PWD_BY_SAFE_EMAIL;
        case 29:
          return FIND_PWD_BY_REG_EMAIL;
        case 28:
          return FIND_PWD_BY_PHONE;
        case 27:
          return LOGIN_AUTHORITY_POP_OPEN_CLICK;
        case 26:
          return LOGIN_AUTHORITY_POP_SHOW;
        case 25:
          return LOGIN_PRIVACY_POP_DISAGREE_CLICK;
        case 24:
          return LOGIN_PRIVACY_POP_AGREE_CLICK;
        case 23:
          return LOGIN_PRIVACY_POP_SHOW;
        case 22:
          return ONE_CLICK_POP_TRUE_CLICK;
        case 21:
          return ONE_CLICK_POP_SHOW;
        case 20:
          return PROFILE_WRITE_PAGE_SHOW;
        case 19:
          return RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK;
        case 18:
          return RECOMMEND_PAGE_POP_UPS_SHOW;
        case 17:
          return RECOMMEND_PAGE_GRID_AVATAR_DRAW;
        case 16:
          return LIKE_LABEL_NEXT_BTN_CLICK;
        case 15:
          return PERSONAL_LABEL_NEXT_BTN_CLICK;
        case 14:
          return PROFILE_WRITE_PAGE_ROLE_BTN_CLICK;
        case 13:
          return PROFILE_WRITE_PAGE_UNIT_BTN_CLICK;
        case 12:
          return PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK;
        case 11:
          return PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK;
        case 10:
          return REC_PAGE_ENTER_BTN_CLICK;
        case 9:
          return REGISTER_SUCCESS;
        case 8:
          return PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK;
        case 7:
          return AUTHCODE_RESEND_BTN_CLICK;
        case 6:
          return AUTHCODE_CONFIRM_BTN_CLICK;
        case 5:
          return REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK;
        case 4:
          return REGISTER_PAGE_REGISTER_BTN_CLICK;
        case 3:
          return LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK;
        case 2:
          return LOGIN_PAGE_REGISTER_BTN_CLICK;
        case 1:
          return LOGIN_BTN_CLICK;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(0);
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
    public LoginAndRegisterProtos.Event findValueByNumber(int param1Int) {
      return LoginAndRegisterProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum LabelStatus implements ProtocolMessageEnum {
    DEFAULT(0),
    INITIATIVE_HAVE(0),
    INITIATIVE_NO(0),
    UNKNOWN_LABEL_STATUS(0),
    UNRECOGNIZED(0);
    
    public static final int DEFAULT_VALUE = 3;
    
    public static final int INITIATIVE_HAVE_VALUE = 2;
    
    public static final int INITIATIVE_NO_VALUE = 1;
    
    public static final int UNKNOWN_LABEL_STATUS_VALUE = 0;
    
    private static final LabelStatus[] VALUES;
    
    private static final Internal.EnumLiteMap<LabelStatus> internalValueMap;
    
    private final int value;
    
    static {
      INITIATIVE_HAVE = new LabelStatus("INITIATIVE_HAVE", 2, 2);
      DEFAULT = new LabelStatus("DEFAULT", 3, 3);
      UNRECOGNIZED = new LabelStatus("UNRECOGNIZED", 4, -1);
      $VALUES = new LabelStatus[] { UNKNOWN_LABEL_STATUS, INITIATIVE_NO, INITIATIVE_HAVE, DEFAULT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<LabelStatus>() {
          public LoginAndRegisterProtos.LabelStatus findValueByNumber(int param2Int) {
            return LoginAndRegisterProtos.LabelStatus.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    LabelStatus(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static LabelStatus forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : DEFAULT) : INITIATIVE_HAVE) : INITIATIVE_NO) : UNKNOWN_LABEL_STATUS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(3);
    }
    
    public static Internal.EnumLiteMap<LabelStatus> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<LabelStatus> {
    public LoginAndRegisterProtos.LabelStatus findValueByNumber(int param1Int) {
      return LoginAndRegisterProtos.LabelStatus.forNumber(param1Int);
    }
  }
  
  public enum LabelType implements ProtocolMessageEnum {
    BODY(0),
    FEATURE(0),
    UNKNOWN_LABEL_TYPE(0),
    UNRECOGNIZED(0),
    WANT(0);
    
    public static final int BODY_VALUE = 1;
    
    public static final int FEATURE_VALUE = 2;
    
    public static final int UNKNOWN_LABEL_TYPE_VALUE = 0;
    
    private static final LabelType[] VALUES;
    
    public static final int WANT_VALUE = 3;
    
    private static final Internal.EnumLiteMap<LabelType> internalValueMap;
    
    private final int value;
    
    static {
      UNRECOGNIZED = new LabelType("UNRECOGNIZED", 4, -1);
      $VALUES = new LabelType[] { UNKNOWN_LABEL_TYPE, BODY, FEATURE, WANT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<LabelType>() {
          public LoginAndRegisterProtos.LabelType findValueByNumber(int param2Int) {
            return LoginAndRegisterProtos.LabelType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    LabelType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static LabelType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : WANT) : FEATURE) : BODY) : UNKNOWN_LABEL_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<LabelType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<LabelType> {
    public LoginAndRegisterProtos.LabelType findValueByNumber(int param1Int) {
      return LoginAndRegisterProtos.LabelType.forNumber(param1Int);
    }
  }
  
  public static final class LoginAndRegisterProto extends GeneratedMessageV3 implements LoginAndRegisterProtoOrBuilder {
    private static final LoginAndRegisterProto DEFAULT_INSTANCE = new LoginAndRegisterProto();
    
    public static final int DURATION_FIELD_NUMBER = 9;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int IS_CALLBACK_FIELD_NUMBER = 11;
    
    public static final int JSON_FIELD_NUMBER = 13;
    
    public static final int LABEL_STATUS_FIELD_NUMBER = 4;
    
    public static final int LABEL_TYPE_FIELD_NUMBER = 8;
    
    public static final int ORI_CHANNEL_FIELD_NUMBER = 12;
    
    private static final Parser<LoginAndRegisterProto> PARSER = (Parser<LoginAndRegisterProto>)new AbstractParser<LoginAndRegisterProto>() {
        public LoginAndRegisterProtos.LoginAndRegisterProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LoginAndRegisterProtos.LoginAndRegisterProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int ROLE_TYPE_FIELD_NUMBER = 3;
    
    public static final int SOURCE_FIELD_NUMBER = 7;
    
    public static final int TARGET_UID_FIELD_NUMBER = 5;
    
    public static final int TARGET_UID_LIST_FIELD_NUMBER = 6;
    
    public static final int THIRD_DURATION_FIELD_NUMBER = 10;
    
    public static final int UNIT_TYPE_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private int duration_;
    
    private int event_;
    
    private boolean isCallback_;
    
    private volatile Object json_;
    
    private int labelStatus_;
    
    private int labelType_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object oriChannel_;
    
    private int roleType_;
    
    private int source_;
    
    private volatile Object targetUidList_;
    
    private volatile Object targetUid_;
    
    private int thirdDuration_;
    
    private int unitType_;
    
    private LoginAndRegisterProto() {
      this.event_ = 0;
      this.unitType_ = 0;
      this.roleType_ = 0;
      this.labelStatus_ = 0;
      this.targetUid_ = "";
      this.targetUidList_ = "";
      this.source_ = 0;
      this.labelType_ = 0;
      this.oriChannel_ = "";
      this.json_ = "";
    }
    
    private LoginAndRegisterProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 106:
                this.json_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 98:
                this.oriChannel_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 88:
                this.isCallback_ = param1CodedInputStream.readBool();
                continue;
              case 80:
                this.thirdDuration_ = param1CodedInputStream.readInt32();
                continue;
              case 72:
                this.duration_ = param1CodedInputStream.readInt32();
                continue;
              case 64:
                this.labelType_ = param1CodedInputStream.readEnum();
                continue;
              case 56:
                this.source_ = param1CodedInputStream.readEnum();
                continue;
              case 50:
                this.targetUidList_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 42:
                this.targetUid_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 32:
                this.labelStatus_ = param1CodedInputStream.readEnum();
                continue;
              case 24:
                this.roleType_ = param1CodedInputStream.readEnum();
                continue;
              case 16:
                this.unitType_ = param1CodedInputStream.readEnum();
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
    
    private LoginAndRegisterProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LoginAndRegisterProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LoginAndRegisterProto param1LoginAndRegisterProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LoginAndRegisterProto);
    }
    
    public static LoginAndRegisterProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LoginAndRegisterProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LoginAndRegisterProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoginAndRegisterProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoginAndRegisterProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LoginAndRegisterProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static LoginAndRegisterProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoginAndRegisterProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LoginAndRegisterProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LoginAndRegisterProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LoginAndRegisterProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoginAndRegisterProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LoginAndRegisterProto parseFrom(InputStream param1InputStream) throws IOException {
      return (LoginAndRegisterProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LoginAndRegisterProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoginAndRegisterProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoginAndRegisterProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LoginAndRegisterProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LoginAndRegisterProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoginAndRegisterProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LoginAndRegisterProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LoginAndRegisterProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LoginAndRegisterProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoginAndRegisterProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LoginAndRegisterProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LoginAndRegisterProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((LoginAndRegisterProto)param1Object).event_) ? false : ((this.unitType_ != ((LoginAndRegisterProto)param1Object).unitType_) ? false : ((this.roleType_ != ((LoginAndRegisterProto)param1Object).roleType_) ? false : ((this.labelStatus_ != ((LoginAndRegisterProto)param1Object).labelStatus_) ? false : (!getTargetUid().equals(param1Object.getTargetUid()) ? false : (!getTargetUidList().equals(param1Object.getTargetUidList()) ? false : ((this.source_ != ((LoginAndRegisterProto)param1Object).source_) ? false : ((this.labelType_ != ((LoginAndRegisterProto)param1Object).labelType_) ? false : ((getDuration() != param1Object.getDuration()) ? false : ((getThirdDuration() != param1Object.getThirdDuration()) ? false : ((getIsCallback() != param1Object.getIsCallback()) ? false : (!getOriChannel().equals(param1Object.getOriChannel()) ? false : (!getJson().equals(param1Object.getJson()) ? false : (!!this.unknownFields.equals(((LoginAndRegisterProto)param1Object).unknownFields))))))))))))));
    }
    
    public LoginAndRegisterProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getDuration() {
      return this.duration_;
    }
    
    public LoginAndRegisterProtos.Event getEvent() {
      LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.valueOf(this.event_);
      LoginAndRegisterProtos.Event event1 = event2;
      if (event2 == null)
        event1 = LoginAndRegisterProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public boolean getIsCallback() {
      return this.isCallback_;
    }
    
    public String getJson() {
      Object object = this.json_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.json_ = object;
      return (String)object;
    }
    
    public ByteString getJsonBytes() {
      Object object = this.json_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.json_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LoginAndRegisterProtos.LabelStatus getLabelStatus() {
      LoginAndRegisterProtos.LabelStatus labelStatus2 = LoginAndRegisterProtos.LabelStatus.valueOf(this.labelStatus_);
      LoginAndRegisterProtos.LabelStatus labelStatus1 = labelStatus2;
      if (labelStatus2 == null)
        labelStatus1 = LoginAndRegisterProtos.LabelStatus.UNRECOGNIZED; 
      return labelStatus1;
    }
    
    public int getLabelStatusValue() {
      return this.labelStatus_;
    }
    
    public LoginAndRegisterProtos.LabelType getLabelType() {
      LoginAndRegisterProtos.LabelType labelType2 = LoginAndRegisterProtos.LabelType.valueOf(this.labelType_);
      LoginAndRegisterProtos.LabelType labelType1 = labelType2;
      if (labelType2 == null)
        labelType1 = LoginAndRegisterProtos.LabelType.UNRECOGNIZED; 
      return labelType1;
    }
    
    public int getLabelTypeValue() {
      return this.labelType_;
    }
    
    public String getOriChannel() {
      Object object = this.oriChannel_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.oriChannel_ = object;
      return (String)object;
    }
    
    public ByteString getOriChannelBytes() {
      Object object = this.oriChannel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.oriChannel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<LoginAndRegisterProto> getParserForType() {
      return PARSER;
    }
    
    public LoginAndRegisterProtos.RoleType getRoleType() {
      LoginAndRegisterProtos.RoleType roleType2 = LoginAndRegisterProtos.RoleType.valueOf(this.roleType_);
      LoginAndRegisterProtos.RoleType roleType1 = roleType2;
      if (roleType2 == null)
        roleType1 = LoginAndRegisterProtos.RoleType.UNRECOGNIZED; 
      return roleType1;
    }
    
    public int getRoleTypeValue() {
      return this.roleType_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != LoginAndRegisterProtos.Event.UNKNOWN.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.unitType_ != LoginAndRegisterProtos.UnitType.UNKNOWN_UNIT_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.unitType_); 
      j = i;
      if (this.roleType_ != LoginAndRegisterProtos.RoleType.UNKNOWN_ROLE_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.roleType_); 
      i = j;
      if (this.labelStatus_ != LoginAndRegisterProtos.LabelStatus.UNKNOWN_LABEL_STATUS.getNumber())
        i = j + CodedOutputStream.computeEnumSize(4, this.labelStatus_); 
      j = i;
      if (!getTargetUidBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.targetUid_); 
      i = j;
      if (!getTargetUidListBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(6, this.targetUidList_); 
      int k = i;
      if (this.source_ != LoginAndRegisterProtos.Source.UNKNOWN_SOURCE.getNumber())
        k = i + CodedOutputStream.computeEnumSize(7, this.source_); 
      j = k;
      if (this.labelType_ != LoginAndRegisterProtos.LabelType.UNKNOWN_LABEL_TYPE.getNumber())
        j = k + CodedOutputStream.computeEnumSize(8, this.labelType_); 
      k = this.duration_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(9, k); 
      k = this.thirdDuration_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(10, k); 
      boolean bool = this.isCallback_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(11, bool); 
      j = i;
      if (!getOriChannelBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(12, this.oriChannel_); 
      i = j;
      if (!getJsonBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(13, this.json_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public LoginAndRegisterProtos.Source getSource() {
      LoginAndRegisterProtos.Source source2 = LoginAndRegisterProtos.Source.valueOf(this.source_);
      LoginAndRegisterProtos.Source source1 = source2;
      if (source2 == null)
        source1 = LoginAndRegisterProtos.Source.UNRECOGNIZED; 
      return source1;
    }
    
    public int getSourceValue() {
      return this.source_;
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
    
    public String getTargetUidList() {
      Object object = this.targetUidList_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.targetUidList_ = object;
      return (String)object;
    }
    
    public ByteString getTargetUidListBytes() {
      Object object = this.targetUidList_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.targetUidList_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getThirdDuration() {
      return this.thirdDuration_;
    }
    
    public LoginAndRegisterProtos.UnitType getUnitType() {
      LoginAndRegisterProtos.UnitType unitType2 = LoginAndRegisterProtos.UnitType.valueOf(this.unitType_);
      LoginAndRegisterProtos.UnitType unitType1 = unitType2;
      if (unitType2 == null)
        unitType1 = LoginAndRegisterProtos.UnitType.UNRECOGNIZED; 
      return unitType1;
    }
    
    public int getUnitTypeValue() {
      return this.unitType_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.unitType_) * 37 + 3) * 53 + this.roleType_) * 37 + 4) * 53 + this.labelStatus_) * 37 + 5) * 53 + getTargetUid().hashCode()) * 37 + 6) * 53 + getTargetUidList().hashCode()) * 37 + 7) * 53 + this.source_) * 37 + 8) * 53 + this.labelType_) * 37 + 9) * 53 + getDuration()) * 37 + 10) * 53 + getThirdDuration()) * 37 + 11) * 53 + Internal.hashBoolean(getIsCallback())) * 37 + 12) * 53 + getOriChannel().hashCode()) * 37 + 13) * 53 + getJson().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProto.class, Builder.class);
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
      return new LoginAndRegisterProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != LoginAndRegisterProtos.Event.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.unitType_ != LoginAndRegisterProtos.UnitType.UNKNOWN_UNIT_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.unitType_); 
      if (this.roleType_ != LoginAndRegisterProtos.RoleType.UNKNOWN_ROLE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.roleType_); 
      if (this.labelStatus_ != LoginAndRegisterProtos.LabelStatus.UNKNOWN_LABEL_STATUS.getNumber())
        param1CodedOutputStream.writeEnum(4, this.labelStatus_); 
      if (!getTargetUidBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.targetUid_); 
      if (!getTargetUidListBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.targetUidList_); 
      if (this.source_ != LoginAndRegisterProtos.Source.UNKNOWN_SOURCE.getNumber())
        param1CodedOutputStream.writeEnum(7, this.source_); 
      if (this.labelType_ != LoginAndRegisterProtos.LabelType.UNKNOWN_LABEL_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(8, this.labelType_); 
      int i = this.duration_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(9, i); 
      i = this.thirdDuration_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(10, i); 
      boolean bool = this.isCallback_;
      if (bool)
        param1CodedOutputStream.writeBool(11, bool); 
      if (!getOriChannelBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 12, this.oriChannel_); 
      if (!getJsonBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 13, this.json_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder {
      private int duration_;
      
      private int event_ = 0;
      
      private boolean isCallback_;
      
      private Object json_ = "";
      
      private int labelStatus_ = 0;
      
      private int labelType_ = 0;
      
      private Object oriChannel_ = "";
      
      private int roleType_ = 0;
      
      private int source_ = 0;
      
      private Object targetUidList_ = "";
      
      private Object targetUid_ = "";
      
      private int thirdDuration_;
      
      private int unitType_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LoginAndRegisterProtos.LoginAndRegisterProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LoginAndRegisterProtos.LoginAndRegisterProto build() {
        LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = buildPartial();
        if (loginAndRegisterProto.isInitialized())
          return loginAndRegisterProto; 
        throw newUninitializedMessageException(loginAndRegisterProto);
      }
      
      public LoginAndRegisterProtos.LoginAndRegisterProto buildPartial() {
        LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = new LoginAndRegisterProtos.LoginAndRegisterProto(this);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$602(loginAndRegisterProto, this.event_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$702(loginAndRegisterProto, this.unitType_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$802(loginAndRegisterProto, this.roleType_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$902(loginAndRegisterProto, this.labelStatus_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1002(loginAndRegisterProto, this.targetUid_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1102(loginAndRegisterProto, this.targetUidList_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1202(loginAndRegisterProto, this.source_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1302(loginAndRegisterProto, this.labelType_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1402(loginAndRegisterProto, this.duration_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1502(loginAndRegisterProto, this.thirdDuration_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1602(loginAndRegisterProto, this.isCallback_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1702(loginAndRegisterProto, this.oriChannel_);
        LoginAndRegisterProtos.LoginAndRegisterProto.access$1802(loginAndRegisterProto, this.json_);
        onBuilt();
        return loginAndRegisterProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.unitType_ = 0;
        this.roleType_ = 0;
        this.labelStatus_ = 0;
        this.targetUid_ = "";
        this.targetUidList_ = "";
        this.source_ = 0;
        this.labelType_ = 0;
        this.duration_ = 0;
        this.thirdDuration_ = 0;
        this.isCallback_ = false;
        this.oriChannel_ = "";
        this.json_ = "";
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
      
      public Builder clearIsCallback() {
        this.isCallback_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearJson() {
        this.json_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getJson();
        onChanged();
        return this;
      }
      
      public Builder clearLabelStatus() {
        this.labelStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearLabelType() {
        this.labelType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOriChannel() {
        this.oriChannel_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getOriChannel();
        onChanged();
        return this;
      }
      
      public Builder clearRoleType() {
        this.roleType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSource() {
        this.source_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTargetUid() {
        this.targetUid_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getTargetUid();
        onChanged();
        return this;
      }
      
      public Builder clearTargetUidList() {
        this.targetUidList_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getTargetUidList();
        onChanged();
        return this;
      }
      
      public Builder clearThirdDuration() {
        this.thirdDuration_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearUnitType() {
        this.unitType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public LoginAndRegisterProtos.LoginAndRegisterProto getDefaultInstanceForType() {
        return LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
      }
      
      public int getDuration() {
        return this.duration_;
      }
      
      public LoginAndRegisterProtos.Event getEvent() {
        LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.valueOf(this.event_);
        LoginAndRegisterProtos.Event event1 = event2;
        if (event2 == null)
          event1 = LoginAndRegisterProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public boolean getIsCallback() {
        return this.isCallback_;
      }
      
      public String getJson() {
        Object object = this.json_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.json_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getJsonBytes() {
        Object object = this.json_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.json_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LoginAndRegisterProtos.LabelStatus getLabelStatus() {
        LoginAndRegisterProtos.LabelStatus labelStatus2 = LoginAndRegisterProtos.LabelStatus.valueOf(this.labelStatus_);
        LoginAndRegisterProtos.LabelStatus labelStatus1 = labelStatus2;
        if (labelStatus2 == null)
          labelStatus1 = LoginAndRegisterProtos.LabelStatus.UNRECOGNIZED; 
        return labelStatus1;
      }
      
      public int getLabelStatusValue() {
        return this.labelStatus_;
      }
      
      public LoginAndRegisterProtos.LabelType getLabelType() {
        LoginAndRegisterProtos.LabelType labelType2 = LoginAndRegisterProtos.LabelType.valueOf(this.labelType_);
        LoginAndRegisterProtos.LabelType labelType1 = labelType2;
        if (labelType2 == null)
          labelType1 = LoginAndRegisterProtos.LabelType.UNRECOGNIZED; 
        return labelType1;
      }
      
      public int getLabelTypeValue() {
        return this.labelType_;
      }
      
      public String getOriChannel() {
        Object object = this.oriChannel_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.oriChannel_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getOriChannelBytes() {
        Object object = this.oriChannel_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.oriChannel_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LoginAndRegisterProtos.RoleType getRoleType() {
        LoginAndRegisterProtos.RoleType roleType2 = LoginAndRegisterProtos.RoleType.valueOf(this.roleType_);
        LoginAndRegisterProtos.RoleType roleType1 = roleType2;
        if (roleType2 == null)
          roleType1 = LoginAndRegisterProtos.RoleType.UNRECOGNIZED; 
        return roleType1;
      }
      
      public int getRoleTypeValue() {
        return this.roleType_;
      }
      
      public LoginAndRegisterProtos.Source getSource() {
        LoginAndRegisterProtos.Source source2 = LoginAndRegisterProtos.Source.valueOf(this.source_);
        LoginAndRegisterProtos.Source source1 = source2;
        if (source2 == null)
          source1 = LoginAndRegisterProtos.Source.UNRECOGNIZED; 
        return source1;
      }
      
      public int getSourceValue() {
        return this.source_;
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
      
      public String getTargetUidList() {
        Object object = this.targetUidList_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.targetUidList_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getTargetUidListBytes() {
        Object object = this.targetUidList_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.targetUidList_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getThirdDuration() {
        return this.thirdDuration_;
      }
      
      public LoginAndRegisterProtos.UnitType getUnitType() {
        LoginAndRegisterProtos.UnitType unitType2 = LoginAndRegisterProtos.UnitType.valueOf(this.unitType_);
        LoginAndRegisterProtos.UnitType unitType1 = unitType2;
        if (unitType2 == null)
          unitType1 = LoginAndRegisterProtos.UnitType.UNRECOGNIZED; 
        return unitType1;
      }
      
      public int getUnitTypeValue() {
        return this.unitType_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProtos.LoginAndRegisterProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LoginAndRegisterProtos.LoginAndRegisterProto param2LoginAndRegisterProto) {
        if (param2LoginAndRegisterProto == LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance())
          return this; 
        if (param2LoginAndRegisterProto.event_ != 0)
          setEventValue(param2LoginAndRegisterProto.getEventValue()); 
        if (param2LoginAndRegisterProto.unitType_ != 0)
          setUnitTypeValue(param2LoginAndRegisterProto.getUnitTypeValue()); 
        if (param2LoginAndRegisterProto.roleType_ != 0)
          setRoleTypeValue(param2LoginAndRegisterProto.getRoleTypeValue()); 
        if (param2LoginAndRegisterProto.labelStatus_ != 0)
          setLabelStatusValue(param2LoginAndRegisterProto.getLabelStatusValue()); 
        if (!param2LoginAndRegisterProto.getTargetUid().isEmpty()) {
          this.targetUid_ = param2LoginAndRegisterProto.targetUid_;
          onChanged();
        } 
        if (!param2LoginAndRegisterProto.getTargetUidList().isEmpty()) {
          this.targetUidList_ = param2LoginAndRegisterProto.targetUidList_;
          onChanged();
        } 
        if (param2LoginAndRegisterProto.source_ != 0)
          setSourceValue(param2LoginAndRegisterProto.getSourceValue()); 
        if (param2LoginAndRegisterProto.labelType_ != 0)
          setLabelTypeValue(param2LoginAndRegisterProto.getLabelTypeValue()); 
        if (param2LoginAndRegisterProto.getDuration() != 0)
          setDuration(param2LoginAndRegisterProto.getDuration()); 
        if (param2LoginAndRegisterProto.getThirdDuration() != 0)
          setThirdDuration(param2LoginAndRegisterProto.getThirdDuration()); 
        if (param2LoginAndRegisterProto.getIsCallback())
          setIsCallback(param2LoginAndRegisterProto.getIsCallback()); 
        if (!param2LoginAndRegisterProto.getOriChannel().isEmpty()) {
          this.oriChannel_ = param2LoginAndRegisterProto.oriChannel_;
          onChanged();
        } 
        if (!param2LoginAndRegisterProto.getJson().isEmpty()) {
          this.json_ = param2LoginAndRegisterProto.json_;
          onChanged();
        } 
        mergeUnknownFields(param2LoginAndRegisterProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = (LoginAndRegisterProtos.LoginAndRegisterProto)LoginAndRegisterProtos.LoginAndRegisterProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = (LoginAndRegisterProtos.LoginAndRegisterProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LoginAndRegisterProtos.LoginAndRegisterProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LoginAndRegisterProtos.LoginAndRegisterProto)
          return mergeFrom((LoginAndRegisterProtos.LoginAndRegisterProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setDuration(int param2Int) {
        this.duration_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setEvent(LoginAndRegisterProtos.Event param2Event) {
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
      
      public Builder setIsCallback(boolean param2Boolean) {
        this.isCallback_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setJson(String param2String) {
        if (param2String != null) {
          this.json_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setJsonBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param2ByteString);
          this.json_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLabelStatus(LoginAndRegisterProtos.LabelStatus param2LabelStatus) {
        if (param2LabelStatus != null) {
          this.labelStatus_ = param2LabelStatus.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLabelStatusValue(int param2Int) {
        this.labelStatus_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setLabelType(LoginAndRegisterProtos.LabelType param2LabelType) {
        if (param2LabelType != null) {
          this.labelType_ = param2LabelType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLabelTypeValue(int param2Int) {
        this.labelType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOriChannel(String param2String) {
        if (param2String != null) {
          this.oriChannel_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOriChannelBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param2ByteString);
          this.oriChannel_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setRoleType(LoginAndRegisterProtos.RoleType param2RoleType) {
        if (param2RoleType != null) {
          this.roleType_ = param2RoleType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRoleTypeValue(int param2Int) {
        this.roleType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSource(LoginAndRegisterProtos.Source param2Source) {
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
          LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUid_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTargetUidList(String param2String) {
        if (param2String != null) {
          this.targetUidList_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setTargetUidListBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param2ByteString);
          this.targetUidList_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setThirdDuration(int param2Int) {
        this.thirdDuration_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setUnitType(LoginAndRegisterProtos.UnitType param2UnitType) {
        if (param2UnitType != null) {
          this.unitType_ = param2UnitType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUnitTypeValue(int param2Int) {
        this.unitType_ = param2Int;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<LoginAndRegisterProto> {
    public LoginAndRegisterProtos.LoginAndRegisterProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LoginAndRegisterProtos.LoginAndRegisterProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LoginAndRegisterProto.Builder> implements LoginAndRegisterProtoOrBuilder {
    private int duration_;
    
    private int event_ = 0;
    
    private boolean isCallback_;
    
    private Object json_ = "";
    
    private int labelStatus_ = 0;
    
    private int labelType_ = 0;
    
    private Object oriChannel_ = "";
    
    private int roleType_ = 0;
    
    private int source_ = 0;
    
    private Object targetUidList_ = "";
    
    private Object targetUid_ = "";
    
    private int thirdDuration_;
    
    private int unitType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LoginAndRegisterProtos.LoginAndRegisterProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LoginAndRegisterProtos.LoginAndRegisterProto build() {
      LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = buildPartial();
      if (loginAndRegisterProto.isInitialized())
        return loginAndRegisterProto; 
      throw newUninitializedMessageException(loginAndRegisterProto);
    }
    
    public LoginAndRegisterProtos.LoginAndRegisterProto buildPartial() {
      LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = new LoginAndRegisterProtos.LoginAndRegisterProto(this);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$602(loginAndRegisterProto, this.event_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$702(loginAndRegisterProto, this.unitType_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$802(loginAndRegisterProto, this.roleType_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$902(loginAndRegisterProto, this.labelStatus_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1002(loginAndRegisterProto, this.targetUid_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1102(loginAndRegisterProto, this.targetUidList_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1202(loginAndRegisterProto, this.source_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1302(loginAndRegisterProto, this.labelType_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1402(loginAndRegisterProto, this.duration_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1502(loginAndRegisterProto, this.thirdDuration_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1602(loginAndRegisterProto, this.isCallback_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1702(loginAndRegisterProto, this.oriChannel_);
      LoginAndRegisterProtos.LoginAndRegisterProto.access$1802(loginAndRegisterProto, this.json_);
      onBuilt();
      return loginAndRegisterProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.unitType_ = 0;
      this.roleType_ = 0;
      this.labelStatus_ = 0;
      this.targetUid_ = "";
      this.targetUidList_ = "";
      this.source_ = 0;
      this.labelType_ = 0;
      this.duration_ = 0;
      this.thirdDuration_ = 0;
      this.isCallback_ = false;
      this.oriChannel_ = "";
      this.json_ = "";
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
    
    public Builder clearIsCallback() {
      this.isCallback_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearJson() {
      this.json_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getJson();
      onChanged();
      return this;
    }
    
    public Builder clearLabelStatus() {
      this.labelStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearLabelType() {
      this.labelType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOriChannel() {
      this.oriChannel_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getOriChannel();
      onChanged();
      return this;
    }
    
    public Builder clearRoleType() {
      this.roleType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSource() {
      this.source_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTargetUid() {
      this.targetUid_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getTargetUid();
      onChanged();
      return this;
    }
    
    public Builder clearTargetUidList() {
      this.targetUidList_ = LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance().getTargetUidList();
      onChanged();
      return this;
    }
    
    public Builder clearThirdDuration() {
      this.thirdDuration_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearUnitType() {
      this.unitType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LoginAndRegisterProtos.LoginAndRegisterProto getDefaultInstanceForType() {
      return LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
    }
    
    public int getDuration() {
      return this.duration_;
    }
    
    public LoginAndRegisterProtos.Event getEvent() {
      LoginAndRegisterProtos.Event event2 = LoginAndRegisterProtos.Event.valueOf(this.event_);
      LoginAndRegisterProtos.Event event1 = event2;
      if (event2 == null)
        event1 = LoginAndRegisterProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public boolean getIsCallback() {
      return this.isCallback_;
    }
    
    public String getJson() {
      Object object = this.json_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.json_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getJsonBytes() {
      Object object = this.json_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.json_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LoginAndRegisterProtos.LabelStatus getLabelStatus() {
      LoginAndRegisterProtos.LabelStatus labelStatus2 = LoginAndRegisterProtos.LabelStatus.valueOf(this.labelStatus_);
      LoginAndRegisterProtos.LabelStatus labelStatus1 = labelStatus2;
      if (labelStatus2 == null)
        labelStatus1 = LoginAndRegisterProtos.LabelStatus.UNRECOGNIZED; 
      return labelStatus1;
    }
    
    public int getLabelStatusValue() {
      return this.labelStatus_;
    }
    
    public LoginAndRegisterProtos.LabelType getLabelType() {
      LoginAndRegisterProtos.LabelType labelType2 = LoginAndRegisterProtos.LabelType.valueOf(this.labelType_);
      LoginAndRegisterProtos.LabelType labelType1 = labelType2;
      if (labelType2 == null)
        labelType1 = LoginAndRegisterProtos.LabelType.UNRECOGNIZED; 
      return labelType1;
    }
    
    public int getLabelTypeValue() {
      return this.labelType_;
    }
    
    public String getOriChannel() {
      Object object = this.oriChannel_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.oriChannel_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOriChannelBytes() {
      Object object = this.oriChannel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.oriChannel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LoginAndRegisterProtos.RoleType getRoleType() {
      LoginAndRegisterProtos.RoleType roleType2 = LoginAndRegisterProtos.RoleType.valueOf(this.roleType_);
      LoginAndRegisterProtos.RoleType roleType1 = roleType2;
      if (roleType2 == null)
        roleType1 = LoginAndRegisterProtos.RoleType.UNRECOGNIZED; 
      return roleType1;
    }
    
    public int getRoleTypeValue() {
      return this.roleType_;
    }
    
    public LoginAndRegisterProtos.Source getSource() {
      LoginAndRegisterProtos.Source source2 = LoginAndRegisterProtos.Source.valueOf(this.source_);
      LoginAndRegisterProtos.Source source1 = source2;
      if (source2 == null)
        source1 = LoginAndRegisterProtos.Source.UNRECOGNIZED; 
      return source1;
    }
    
    public int getSourceValue() {
      return this.source_;
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
    
    public String getTargetUidList() {
      Object object = this.targetUidList_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.targetUidList_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTargetUidListBytes() {
      Object object = this.targetUidList_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.targetUidList_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getThirdDuration() {
      return this.thirdDuration_;
    }
    
    public LoginAndRegisterProtos.UnitType getUnitType() {
      LoginAndRegisterProtos.UnitType unitType2 = LoginAndRegisterProtos.UnitType.valueOf(this.unitType_);
      LoginAndRegisterProtos.UnitType unitType1 = unitType2;
      if (unitType2 == null)
        unitType1 = LoginAndRegisterProtos.UnitType.UNRECOGNIZED; 
      return unitType1;
    }
    
    public int getUnitTypeValue() {
      return this.unitType_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProtos.LoginAndRegisterProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LoginAndRegisterProtos.LoginAndRegisterProto param1LoginAndRegisterProto) {
      if (param1LoginAndRegisterProto == LoginAndRegisterProtos.LoginAndRegisterProto.getDefaultInstance())
        return this; 
      if (param1LoginAndRegisterProto.event_ != 0)
        setEventValue(param1LoginAndRegisterProto.getEventValue()); 
      if (param1LoginAndRegisterProto.unitType_ != 0)
        setUnitTypeValue(param1LoginAndRegisterProto.getUnitTypeValue()); 
      if (param1LoginAndRegisterProto.roleType_ != 0)
        setRoleTypeValue(param1LoginAndRegisterProto.getRoleTypeValue()); 
      if (param1LoginAndRegisterProto.labelStatus_ != 0)
        setLabelStatusValue(param1LoginAndRegisterProto.getLabelStatusValue()); 
      if (!param1LoginAndRegisterProto.getTargetUid().isEmpty()) {
        this.targetUid_ = param1LoginAndRegisterProto.targetUid_;
        onChanged();
      } 
      if (!param1LoginAndRegisterProto.getTargetUidList().isEmpty()) {
        this.targetUidList_ = param1LoginAndRegisterProto.targetUidList_;
        onChanged();
      } 
      if (param1LoginAndRegisterProto.source_ != 0)
        setSourceValue(param1LoginAndRegisterProto.getSourceValue()); 
      if (param1LoginAndRegisterProto.labelType_ != 0)
        setLabelTypeValue(param1LoginAndRegisterProto.getLabelTypeValue()); 
      if (param1LoginAndRegisterProto.getDuration() != 0)
        setDuration(param1LoginAndRegisterProto.getDuration()); 
      if (param1LoginAndRegisterProto.getThirdDuration() != 0)
        setThirdDuration(param1LoginAndRegisterProto.getThirdDuration()); 
      if (param1LoginAndRegisterProto.getIsCallback())
        setIsCallback(param1LoginAndRegisterProto.getIsCallback()); 
      if (!param1LoginAndRegisterProto.getOriChannel().isEmpty()) {
        this.oriChannel_ = param1LoginAndRegisterProto.oriChannel_;
        onChanged();
      } 
      if (!param1LoginAndRegisterProto.getJson().isEmpty()) {
        this.json_ = param1LoginAndRegisterProto.json_;
        onChanged();
      } 
      mergeUnknownFields(param1LoginAndRegisterProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = (LoginAndRegisterProtos.LoginAndRegisterProto)LoginAndRegisterProtos.LoginAndRegisterProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = (LoginAndRegisterProtos.LoginAndRegisterProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LoginAndRegisterProtos.LoginAndRegisterProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LoginAndRegisterProtos.LoginAndRegisterProto)
        return mergeFrom((LoginAndRegisterProtos.LoginAndRegisterProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDuration(int param1Int) {
      this.duration_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setEvent(LoginAndRegisterProtos.Event param1Event) {
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
    
    public Builder setIsCallback(boolean param1Boolean) {
      this.isCallback_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setJson(String param1String) {
      if (param1String != null) {
        this.json_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setJsonBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param1ByteString);
        this.json_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLabelStatus(LoginAndRegisterProtos.LabelStatus param1LabelStatus) {
      if (param1LabelStatus != null) {
        this.labelStatus_ = param1LabelStatus.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLabelStatusValue(int param1Int) {
      this.labelStatus_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setLabelType(LoginAndRegisterProtos.LabelType param1LabelType) {
      if (param1LabelType != null) {
        this.labelType_ = param1LabelType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLabelTypeValue(int param1Int) {
      this.labelType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOriChannel(String param1String) {
      if (param1String != null) {
        this.oriChannel_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOriChannelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param1ByteString);
        this.oriChannel_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRoleType(LoginAndRegisterProtos.RoleType param1RoleType) {
      if (param1RoleType != null) {
        this.roleType_ = param1RoleType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRoleTypeValue(int param1Int) {
      this.roleType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSource(LoginAndRegisterProtos.Source param1Source) {
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
        LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUid_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTargetUidList(String param1String) {
      if (param1String != null) {
        this.targetUidList_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTargetUidListBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LoginAndRegisterProtos.LoginAndRegisterProto.checkByteStringIsUtf8(param1ByteString);
        this.targetUidList_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setThirdDuration(int param1Int) {
      this.thirdDuration_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setUnitType(LoginAndRegisterProtos.UnitType param1UnitType) {
      if (param1UnitType != null) {
        this.unitType_ = param1UnitType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUnitTypeValue(int param1Int) {
      this.unitType_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface LoginAndRegisterProtoOrBuilder extends MessageOrBuilder {
    int getDuration();
    
    LoginAndRegisterProtos.Event getEvent();
    
    int getEventValue();
    
    boolean getIsCallback();
    
    String getJson();
    
    ByteString getJsonBytes();
    
    LoginAndRegisterProtos.LabelStatus getLabelStatus();
    
    int getLabelStatusValue();
    
    LoginAndRegisterProtos.LabelType getLabelType();
    
    int getLabelTypeValue();
    
    String getOriChannel();
    
    ByteString getOriChannelBytes();
    
    LoginAndRegisterProtos.RoleType getRoleType();
    
    int getRoleTypeValue();
    
    LoginAndRegisterProtos.Source getSource();
    
    int getSourceValue();
    
    String getTargetUid();
    
    ByteString getTargetUidBytes();
    
    String getTargetUidList();
    
    ByteString getTargetUidListBytes();
    
    int getThirdDuration();
    
    LoginAndRegisterProtos.UnitType getUnitType();
    
    int getUnitTypeValue();
  }
  
  public enum RoleType implements ProtocolMessageEnum {
    HARF(0),
    ONE(0),
    OTHER(0),
    UNKNOWN_ROLE_TYPE(0),
    UNRECOGNIZED(0),
    ZERO(0);
    
    public static final int HARF_VALUE = 3;
    
    public static final int ONE_VALUE = 1;
    
    public static final int OTHER_VALUE = 4;
    
    public static final int UNKNOWN_ROLE_TYPE_VALUE = 0;
    
    private static final RoleType[] VALUES;
    
    public static final int ZERO_VALUE = 2;
    
    private static final Internal.EnumLiteMap<RoleType> internalValueMap;
    
    private final int value;
    
    static {
      HARF = new RoleType("HARF", 3, 3);
      OTHER = new RoleType("OTHER", 4, 4);
      UNRECOGNIZED = new RoleType("UNRECOGNIZED", 5, -1);
      $VALUES = new RoleType[] { UNKNOWN_ROLE_TYPE, ONE, ZERO, HARF, OTHER, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<RoleType>() {
          public LoginAndRegisterProtos.RoleType findValueByNumber(int param2Int) {
            return LoginAndRegisterProtos.RoleType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    RoleType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static RoleType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : OTHER) : HARF) : ZERO) : ONE) : UNKNOWN_ROLE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<RoleType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<RoleType> {
    public LoginAndRegisterProtos.RoleType findValueByNumber(int param1Int) {
      return LoginAndRegisterProtos.RoleType.forNumber(param1Int);
    }
  }
  
  public enum Source implements ProtocolMessageEnum {
    APPLE(0),
    EMAIL(0),
    ONE_CLICK(0),
    PHONE(0),
    PHONE_CODE(0),
    UNKNOWN_SOURCE(0),
    UNRECOGNIZED(0),
    WECHAT(0);
    
    public static final int APPLE_VALUE = 3;
    
    public static final int EMAIL_VALUE = 5;
    
    public static final int ONE_CLICK_VALUE = 4;
    
    public static final int PHONE_CODE_VALUE = 6;
    
    public static final int PHONE_VALUE = 1;
    
    public static final int UNKNOWN_SOURCE_VALUE = 0;
    
    private static final Source[] VALUES;
    
    public static final int WECHAT_VALUE = 2;
    
    private static final Internal.EnumLiteMap<Source> internalValueMap;
    
    private final int value;
    
    static {
      APPLE = new Source("APPLE", 3, 3);
      ONE_CLICK = new Source("ONE_CLICK", 4, 4);
      EMAIL = new Source("EMAIL", 5, 5);
      PHONE_CODE = new Source("PHONE_CODE", 6, 6);
      UNRECOGNIZED = new Source("UNRECOGNIZED", 7, -1);
      $VALUES = new Source[] { UNKNOWN_SOURCE, PHONE, WECHAT, APPLE, ONE_CLICK, EMAIL, PHONE_CODE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Source>() {
          public LoginAndRegisterProtos.Source findValueByNumber(int param2Int) {
            return LoginAndRegisterProtos.Source.forNumber(param2Int);
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
        case 6:
          return PHONE_CODE;
        case 5:
          return EMAIL;
        case 4:
          return ONE_CLICK;
        case 3:
          return APPLE;
        case 2:
          return WECHAT;
        case 1:
          return PHONE;
        case 0:
          break;
      } 
      return UNKNOWN_SOURCE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(5);
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
    public LoginAndRegisterProtos.Source findValueByNumber(int param1Int) {
      return LoginAndRegisterProtos.Source.forNumber(param1Int);
    }
  }
  
  public enum UnitType implements ProtocolMessageEnum {
    CM_KG(0),
    FT_LB(0),
    UNKNOWN_UNIT_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int CM_KG_VALUE = 2;
    
    public static final int FT_LB_VALUE = 1;
    
    public static final int UNKNOWN_UNIT_TYPE_VALUE = 0;
    
    private static final UnitType[] VALUES;
    
    private static final Internal.EnumLiteMap<UnitType> internalValueMap;
    
    private final int value;
    
    static {
      CM_KG = new UnitType("CM_KG", 2, 2);
      UNRECOGNIZED = new UnitType("UNRECOGNIZED", 3, -1);
      $VALUES = new UnitType[] { UNKNOWN_UNIT_TYPE, FT_LB, CM_KG, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<UnitType>() {
          public LoginAndRegisterProtos.UnitType findValueByNumber(int param2Int) {
            return LoginAndRegisterProtos.UnitType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    UnitType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static UnitType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : CM_KG) : FT_LB) : UNKNOWN_UNIT_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Internal.EnumLiteMap<UnitType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<UnitType> {
    public LoginAndRegisterProtos.UnitType findValueByNumber(int param1Int) {
      return LoginAndRegisterProtos.UnitType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\login\LoginAndRegisterProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
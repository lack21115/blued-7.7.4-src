package com.blued.das.vip;

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

public final class VipProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\017VipProtos.proto\022\021com.blued.das.vip\"\007\n\bVipProto\022'\n\005event\030\001 \001(\0162\030.com.blued.das.vip.Event\022%\n\004name\030\002 \001(\0162\027.com.blued.das.vip.Name\022)\n\004from\030\003 \001(\0162\033.com.blued.das.vip.FromType\0224\n\fstealth_type\030\004 \001(\0162\036.com.blued.das.vip.StealthType\022\020\n\bis_range\030\005 \001(\b\0226\n\rvocative_type\030\006 \001(\0162\037.com.blued.das.vip.VocativeType\0224\n\fpage_version\030\007 \001(\0162\036.com.blued.das.vip.PageVersion\0226\n\ridentity_type\030\b \001(\0162\037.com.blued.das.vip.IdentityType\022\026\n\016is_buy_success\030\t \001(\b\022\017\n\007is_open\030\n \001(\b\0220\n\npage_level\030\013 \001(\0162\034.com.blued.das.vip.PageLevel\022.\n\thide_type\030\f \001(\0162\033.com.blued.das.vip.HideType\022\023\n\013is_hide_all\030\r \001(\b\022\030\n\020is_hide_distance\030\016 \001(\b\022\024\n\fis_hide_role\030\017 \001(\b\022\023\n\013is_hide_age\030\020 \001(\b\022\022\n\nbanner_url\030\021 \001(\t\022\024\n\fprivilege_id\030\022 \001(\t\022,\n\bbtn_type\030\023 \001(\0162\032.com.blued.das.vip.BtnType\022\021\n\tbanner_id\030\024 \001(\t\0220\n\norder_type\030\025 \001(\0162\034.com.blued.das.vip.OrderType\022*\n\007ad_page\030\026 \001(\0162\031.com.blued.das.vip.AdPage\022\017\n\007ad_type\030\027 \001(\t\022\021\n\tlongitude\030\030 \001(\t\022\020\n\blatitude\030\031 \001(\t\022\020\n\bimage_id\030\032 \001(\t\022\020\n\bthird_id\030\033 \001(\t\022\021\n\tis_shadow\030\034 \001(\b\022\n\n\002id\030\035 \001(\t*\020\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022\020\n\fVIP_BUY_SHOW\020\001\022\034\n\030VIP_BUY_SWITCH_BTN_CLICK\020\002\022\032\n\026VIP_BUY_OPEN_BTN_CLICK\020\003\022\025\n\021STEALTH_BTN_CLICK\020\004\022,\n(VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW\020\005\022-\n)VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK\020\006\022\036\n\032FEATURED_FOR_YOU_PAGE_SHOW\020\007\022,\n(FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK\020\b\022\033\n\027VOCATIVE_BACK_BTN_CLICK\020\t\022\033\n\027MAP_FIND_BACK_BTN_CLICK\020\n\022\035\n\031VIP_CENTRE_BACK_BTN_CLICK\020\013\022\032\n\026VIP_BUY_BACK_BTN_CLICK\020\f\022\020\n\fVIP_BUY_SVIP\020\r\022\030\n\024VIP_CENTRE_PAGE_SHOW\020\016\022 \n\034VIP_CENTRE_VIP_UP_SVIP_CLICK\020\017\022*\n&VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW\020\020\022*\n&VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK\020\021\022,\n(VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK\020\022\022\"\n\036VIP_CENTRE_RESUME_BUY_BTN_SHOW\020\023\022#\n\037VIP_CENTRE_RESUME_BUY_BTN_CLICK\020\024\022\032\n\026VIP_CENTRE_BANNER_SHOW\020\025\022\033\n\027VIP_CENTRE_BANNER_CLICK\020\026\022\036\n\032VIP_CENTER_PRIVILEGE_CLICK\020\027\022\"\n\036VIP_CENTER_CAROUSEL_AREA_CLICK\020\030\022!\n\035VISIT_PAGE_NO_TRACE_BTN_CLICK\020\031\022\035\n\031MINE_RANGE_TIME_BTN_CLICK\020\032\022\034\n\030MINE_HIDE_TINE_BTN_CLICK\020\033\022\035\n\031MINE_HIDE_RANGE_BTN_CLICK\020\034\022\"\n\036VIP_CENTER_TOP_RENEW_NOW_CLICK\020\035\022\037\n\033MAP_FIND_SETTINGS_BTN_CLICK\020\036\022-\n)MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK\020\037\022\025\n\021ORDER_COUPON_SHOW\020 \022\026\n\022ORDER_COUPON_CLICK\020!\022\036\n\032VIP_BUY_PAGE_MORE_BTN_SHOW\020\"\022\037\n\033VIP_BUY_PAGE_MORE_BTN_CLICK\020#\022 \n\034VIP_BUY_PAGE_CANCEL_POP_SHOW\020$\022(\n$VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK\020%\022%\n!VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK\020&\022\030\n\024NO_AD_PROPAGATE_SHOW\020'\022\035\n\031NO_AD_PROPAGATE_BUY_CLICK\020(\022\036\n\032NO_AD_PROPAGATE_OPEN_CLICK\020)\022\037\n\033NO_AD_PROPAGATE_CLOSE_CLICK\020*\022\035\n\031NO_AD_PROPAGATE_BAN_CLICK\020+\022\027\n\023VIP_LEVEL_PAGE_SHOW\020,\022\"\n\036VIP_LEVEL_PAGE_UP_BLUEDX_CLICK\020-\022\"\n\036VIP_CHANGE_ICON_SAVE_BTN_CLICK\020.\022*\n&VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK\020/\022)\n%VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK\0200\022'\n#VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK\0201\022\030\n\024IOS_PAY_THIRD_STATUS\0202\022\"\n\036VIP_PRIVACY_PHOTO_EXPAND_CLICK\0203\022!\n\035VIP_PRIVACY_PHOTO_LOCKED_SHOW\0204\022\"\n\036VIP_PRIVACY_PHOTO_LOCKED_CLICK\0205\022(\n$VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK\0206\022\036\n\032VISIT_PAGE_SHADOW_BTN_SHOW\0207\022\037\n\033VISIT_PAGE_SHADOW_BTN_CLICK\0208\022\"\n\036VIP_CENTER_PHOTO_PENDANT_CLICK\0209\022!\n\035PHOTO_PENDANT_PAGE_SAVE_CLICK\020:\022 \n\034PHOTO_PENDANT_PAGE_VIP_CLICK\020;\022\031\n\025VIP_CENTER_RENEW_SHOW\020<\022\032\n\026VIP_CENTER_RENEW_CLICK\020=*G\n\007BtnType\022\024\n\020UNKNOWN_BTN_TYPE\020\000\022\013\n\007NOW_BUY\020\001\022\016\n\nNOW_RESUME\020\002\022\t\n\005RENEW\020\003*+\n\004Name\022\020\n\fUNKNOWN_NAME\020\000\022\007\n\003VIP\020\001\022\b\n\004SVIP\020\002*á\003\n\bFromType\022\020\n\fUNKNOWN_FROM\020\000\022\013\n\007HISTORY\020\001\022\026\n\022TODAY_VISIT_REMAIN\020\002\022\027\n\023FIFTEEN_VISIT_TREND\020\003\022\022\n\016VISIT_ONLY_ONE\020\004\022\016\n\nVISIT_NONE\020\005\022\r\n\tAPP_STORE\020\006\022\016\n\nMSG_BUBBLE\020\007\022\025\n\021FEED_DYNAMIC_SKIN\020\b\022\030\n\024PRIVACY_PHOTO_EXPAND\020\t\022\036\n\032PRIVACY_PHOTO_LOCKED_RENEW\020\n\022\025\n\021PHOTO_PENDANT_OWN\020\013\022\027\n\023PHOTO_PENDANT_OTHER\020\f\022\020\n\fMAP_FIND_BUY\020\r\022\034\n\030PHOTO_PENDANT_VIP_CENTER\020\016\022\034\n\030NEARBY_FRIEND_AVATAR_LOC\020\017\022%\n!NEARBY_FRIEND_MAP_FIND_NONE_TRIAL\020\020\022 \n\034NEARBY_FRIEND_MAP_FIND_TRIAL\020\021\022\020\n\fPHOTO_FILTER\020\022\022\030\n\024CONSTELLATION_FILTER\020\023*<\n\013StealthType\022\030\n\024UNKNOWN_STEALTH_TYPE\020\000\022\t\n\005WHOLE\020\001\022\b\n\004HALF\020\002*G\n\fVocativeType\022\031\n\025UNKNOWN_VOCATIVE_TYPE\020\000\022\f\n\bNO_TIMES\020\001\022\016\n\nHAVE_TIMES\020\002*?\n\013PageVersion\022\030\n\024UNKNOWN_PAGE_VERSION\020\000\022\n\n\006V_0730\020\001\022\n\n\006V_0813\020\002*s\n\fIdentityType\022\031\n\025UNKNOWN_IDENTITY_TYPE\020\000\022\b\n\004NONE\020\001\022\f\n\bVIP_TYPE\020\002\022\r\n\tSVIP_TYPE\020\003\022\017\n\013VIP_EXPIRED\020\004\022\020\n\fSVIP_EXPIRED\020\005*@\n\tPageLevel\022\026\n\022UNKNOWN_PAGE_LEVEL\020\000\022\f\n\bVIP_PAGE\020\001\022\r\n\tSVIP_PAGE\020\002*_\n\bHideType\022\025\n\021UNKNOWN_HIDE_TYPE\020\000\022\f\n\bHIDE_ALL\020\001\022\021\n\rHIDE_DISTANCE\020\002\022\r\n\tHIDE_ROLE\020\003\022\f\n\bHIDE_AGE\020\004*f\n\tOrderType\022\026\n\022UNKNOWN_ORDER_TYPE\020\000\022\r\n\tORDER_VIP\020\001\022\016\n\nORDER_SVIP\020\002\022\016\n\nORDER_CALL\020\003\022\022\n\016ORDER_EXPOSURE\020\004*\001\n\006AdPage\022\023\n\017UNKNOWN_AD_PAGE\020\000\022\f\n\bAD_VISIT\020\001\022\r\n\tAD_BANNER\020\002\022\013\n\007AD_HOME\020\003\022\017\n\013AD_HOME_POP\020\004\022\023\n\017AD_HOME_BANNER1\020\005\022\023\n\017AD_HOME_BANNER2\020\006\022\017\n\013AD_PERSONAL\020\007B\006¢\002\003VIPb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_vip_VipProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_vip_VipProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_vip_VipProto_descriptor, new String[] { 
        "Event", "Name", "From", "StealthType", "IsRange", "VocativeType", "PageVersion", "IdentityType", "IsBuySuccess", "IsOpen", 
        "PageLevel", "HideType", "IsHideAll", "IsHideDistance", "IsHideRole", "IsHideAge", "BannerUrl", "PrivilegeId", "BtnType", "BannerId", 
        "OrderType", "AdPage", "AdType", "Longitude", "Latitude", "ImageId", "ThirdId", "IsShadow", "Id" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum AdPage implements ProtocolMessageEnum {
    AD_BANNER,
    AD_HOME,
    AD_HOME_BANNER1,
    AD_HOME_BANNER2,
    AD_HOME_POP,
    AD_PERSONAL,
    AD_VISIT,
    UNKNOWN_AD_PAGE(0),
    UNRECOGNIZED(0);
    
    public static final int AD_BANNER_VALUE = 2;
    
    public static final int AD_HOME_BANNER1_VALUE = 5;
    
    public static final int AD_HOME_BANNER2_VALUE = 6;
    
    public static final int AD_HOME_POP_VALUE = 4;
    
    public static final int AD_HOME_VALUE = 3;
    
    public static final int AD_PERSONAL_VALUE = 7;
    
    public static final int AD_VISIT_VALUE = 1;
    
    public static final int UNKNOWN_AD_PAGE_VALUE = 0;
    
    private static final AdPage[] VALUES;
    
    private static final Internal.EnumLiteMap<AdPage> internalValueMap;
    
    private final int value;
    
    static {
      AD_BANNER = new AdPage("AD_BANNER", 2, 2);
      AD_HOME = new AdPage("AD_HOME", 3, 3);
      AD_HOME_POP = new AdPage("AD_HOME_POP", 4, 4);
      AD_HOME_BANNER1 = new AdPage("AD_HOME_BANNER1", 5, 5);
      AD_HOME_BANNER2 = new AdPage("AD_HOME_BANNER2", 6, 6);
      AD_PERSONAL = new AdPage("AD_PERSONAL", 7, 7);
      UNRECOGNIZED = new AdPage("UNRECOGNIZED", 8, -1);
      $VALUES = new AdPage[] { UNKNOWN_AD_PAGE, AD_VISIT, AD_BANNER, AD_HOME, AD_HOME_POP, AD_HOME_BANNER1, AD_HOME_BANNER2, AD_PERSONAL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<AdPage>() {
          public VipProtos.AdPage findValueByNumber(int param2Int) {
            return VipProtos.AdPage.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    AdPage(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AdPage forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 7:
          return AD_PERSONAL;
        case 6:
          return AD_HOME_BANNER2;
        case 5:
          return AD_HOME_BANNER1;
        case 4:
          return AD_HOME_POP;
        case 3:
          return AD_HOME;
        case 2:
          return AD_BANNER;
        case 1:
          return AD_VISIT;
        case 0:
          break;
      } 
      return UNKNOWN_AD_PAGE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(11);
    }
    
    public static Internal.EnumLiteMap<AdPage> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<AdPage> {
    public VipProtos.AdPage findValueByNumber(int param1Int) {
      return VipProtos.AdPage.forNumber(param1Int);
    }
  }
  
  public enum BtnType implements ProtocolMessageEnum {
    NOW_BUY(0),
    NOW_RESUME(0),
    RENEW(0),
    UNKNOWN_BTN_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int NOW_BUY_VALUE = 1;
    
    public static final int NOW_RESUME_VALUE = 2;
    
    public static final int RENEW_VALUE = 3;
    
    public static final int UNKNOWN_BTN_TYPE_VALUE = 0;
    
    private static final BtnType[] VALUES;
    
    private static final Internal.EnumLiteMap<BtnType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new BtnType[] { UNKNOWN_BTN_TYPE, NOW_BUY, NOW_RESUME, RENEW, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<BtnType>() {
          public VipProtos.BtnType findValueByNumber(int param2Int) {
            return VipProtos.BtnType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    BtnType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static BtnType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : RENEW) : NOW_RESUME) : NOW_BUY) : UNKNOWN_BTN_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(1);
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
    public VipProtos.BtnType findValueByNumber(int param1Int) {
      return VipProtos.BtnType.forNumber(param1Int);
    }
  }
  
  public enum Event implements ProtocolMessageEnum {
    FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK(0),
    FEATURED_FOR_YOU_PAGE_SHOW(0),
    IOS_PAY_THIRD_STATUS(0),
    MAP_FIND_BACK_BTN_CLICK(0),
    MAP_FIND_SETTINGS_BTN_CLICK(0),
    MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK(0),
    MINE_HIDE_RANGE_BTN_CLICK(0),
    MINE_HIDE_TINE_BTN_CLICK(0),
    MINE_RANGE_TIME_BTN_CLICK(0),
    NO_AD_PROPAGATE_BAN_CLICK(0),
    NO_AD_PROPAGATE_BUY_CLICK(0),
    NO_AD_PROPAGATE_CLOSE_CLICK(0),
    NO_AD_PROPAGATE_OPEN_CLICK(0),
    NO_AD_PROPAGATE_SHOW(0),
    ORDER_COUPON_CLICK(0),
    ORDER_COUPON_SHOW(0),
    PHOTO_PENDANT_PAGE_SAVE_CLICK(0),
    PHOTO_PENDANT_PAGE_VIP_CLICK(0),
    STEALTH_BTN_CLICK(0),
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0),
    VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK(0),
    VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK(0),
    VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK(0),
    VIP_BUY_BACK_BTN_CLICK(0),
    VIP_BUY_OPEN_BTN_CLICK(0),
    VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK(0),
    VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK(0),
    VIP_BUY_PAGE_CANCEL_POP_SHOW(0),
    VIP_BUY_PAGE_MORE_BTN_CLICK(0),
    VIP_BUY_PAGE_MORE_BTN_SHOW(0),
    VIP_BUY_SHOW(1),
    VIP_BUY_SVIP(1),
    VIP_BUY_SWITCH_BTN_CLICK(2),
    VIP_CENTER_CAROUSEL_AREA_CLICK(2),
    VIP_CENTER_PHOTO_PENDANT_CLICK(2),
    VIP_CENTER_PRIVILEGE_CLICK(2),
    VIP_CENTER_RENEW_CLICK(2),
    VIP_CENTER_RENEW_SHOW(2),
    VIP_CENTER_TOP_RENEW_NOW_CLICK(2),
    VIP_CENTRE_BACK_BTN_CLICK(2),
    VIP_CENTRE_BANNER_CLICK(2),
    VIP_CENTRE_BANNER_SHOW(2),
    VIP_CENTRE_PAGE_SHOW(2),
    VIP_CENTRE_RESUME_BUY_BTN_CLICK(2),
    VIP_CENTRE_RESUME_BUY_BTN_SHOW(2),
    VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK(2),
    VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK(2),
    VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW(2),
    VIP_CENTRE_VIP_UP_SVIP_CLICK(2),
    VIP_CHANGE_ICON_SAVE_BTN_CLICK(2),
    VIP_LEVEL_PAGE_SHOW(2),
    VIP_LEVEL_PAGE_UP_BLUEDX_CLICK(2),
    VIP_PRIVACY_PHOTO_EXPAND_CLICK(2),
    VIP_PRIVACY_PHOTO_LOCKED_CLICK(2),
    VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK(2),
    VIP_PRIVACY_PHOTO_LOCKED_SHOW(2),
    VISIT_PAGE_NO_TRACE_BTN_CLICK(2),
    VISIT_PAGE_SHADOW_BTN_CLICK(2),
    VISIT_PAGE_SHADOW_BTN_SHOW(2),
    VOCATIVE_BACK_BTN_CLICK(2),
    VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK(2),
    VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW(2);
    
    public static final int FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK_VALUE = 8;
    
    public static final int FEATURED_FOR_YOU_PAGE_SHOW_VALUE = 7;
    
    public static final int IOS_PAY_THIRD_STATUS_VALUE = 50;
    
    public static final int MAP_FIND_BACK_BTN_CLICK_VALUE = 10;
    
    public static final int MAP_FIND_SETTINGS_BTN_CLICK_VALUE = 30;
    
    public static final int MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK_VALUE = 31;
    
    public static final int MINE_HIDE_RANGE_BTN_CLICK_VALUE = 28;
    
    public static final int MINE_HIDE_TINE_BTN_CLICK_VALUE = 27;
    
    public static final int MINE_RANGE_TIME_BTN_CLICK_VALUE = 26;
    
    public static final int NO_AD_PROPAGATE_BAN_CLICK_VALUE = 43;
    
    public static final int NO_AD_PROPAGATE_BUY_CLICK_VALUE = 40;
    
    public static final int NO_AD_PROPAGATE_CLOSE_CLICK_VALUE = 42;
    
    public static final int NO_AD_PROPAGATE_OPEN_CLICK_VALUE = 41;
    
    public static final int NO_AD_PROPAGATE_SHOW_VALUE = 39;
    
    public static final int ORDER_COUPON_CLICK_VALUE = 33;
    
    public static final int ORDER_COUPON_SHOW_VALUE = 32;
    
    public static final int PHOTO_PENDANT_PAGE_SAVE_CLICK_VALUE = 58;
    
    public static final int PHOTO_PENDANT_PAGE_VIP_CLICK_VALUE = 59;
    
    public static final int STEALTH_BTN_CLICK_VALUE = 4;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    public static final int VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK_VALUE = 48;
    
    public static final int VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK_VALUE = 47;
    
    public static final int VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK_VALUE = 49;
    
    public static final int VIP_BUY_BACK_BTN_CLICK_VALUE = 12;
    
    public static final int VIP_BUY_OPEN_BTN_CLICK_VALUE = 3;
    
    public static final int VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK_VALUE = 38;
    
    public static final int VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK_VALUE = 37;
    
    public static final int VIP_BUY_PAGE_CANCEL_POP_SHOW_VALUE = 36;
    
    public static final int VIP_BUY_PAGE_MORE_BTN_CLICK_VALUE = 35;
    
    public static final int VIP_BUY_PAGE_MORE_BTN_SHOW_VALUE = 34;
    
    public static final int VIP_BUY_SHOW_VALUE = 1;
    
    public static final int VIP_BUY_SVIP_VALUE = 13;
    
    public static final int VIP_BUY_SWITCH_BTN_CLICK_VALUE = 2;
    
    public static final int VIP_CENTER_CAROUSEL_AREA_CLICK_VALUE = 24;
    
    public static final int VIP_CENTER_PHOTO_PENDANT_CLICK_VALUE = 57;
    
    public static final int VIP_CENTER_PRIVILEGE_CLICK_VALUE = 23;
    
    public static final int VIP_CENTER_RENEW_CLICK_VALUE = 61;
    
    public static final int VIP_CENTER_RENEW_SHOW_VALUE = 60;
    
    public static final int VIP_CENTER_TOP_RENEW_NOW_CLICK_VALUE = 29;
    
    public static final int VIP_CENTRE_BACK_BTN_CLICK_VALUE = 11;
    
    public static final int VIP_CENTRE_BANNER_CLICK_VALUE = 22;
    
    public static final int VIP_CENTRE_BANNER_SHOW_VALUE = 21;
    
    public static final int VIP_CENTRE_PAGE_SHOW_VALUE = 14;
    
    public static final int VIP_CENTRE_RESUME_BUY_BTN_CLICK_VALUE = 20;
    
    public static final int VIP_CENTRE_RESUME_BUY_BTN_SHOW_VALUE = 19;
    
    public static final int VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK_VALUE = 18;
    
    public static final int VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK_VALUE = 17;
    
    public static final int VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW_VALUE = 16;
    
    public static final int VIP_CENTRE_VIP_UP_SVIP_CLICK_VALUE = 15;
    
    public static final int VIP_CHANGE_ICON_SAVE_BTN_CLICK_VALUE = 46;
    
    public static final int VIP_LEVEL_PAGE_SHOW_VALUE = 44;
    
    public static final int VIP_LEVEL_PAGE_UP_BLUEDX_CLICK_VALUE = 45;
    
    public static final int VIP_PRIVACY_PHOTO_EXPAND_CLICK_VALUE = 51;
    
    public static final int VIP_PRIVACY_PHOTO_LOCKED_CLICK_VALUE = 53;
    
    public static final int VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK_VALUE = 54;
    
    public static final int VIP_PRIVACY_PHOTO_LOCKED_SHOW_VALUE = 52;
    
    public static final int VISIT_PAGE_NO_TRACE_BTN_CLICK_VALUE = 25;
    
    public static final int VISIT_PAGE_SHADOW_BTN_CLICK_VALUE = 56;
    
    public static final int VISIT_PAGE_SHADOW_BTN_SHOW_VALUE = 55;
    
    public static final int VOCATIVE_BACK_BTN_CLICK_VALUE = 9;
    
    public static final int VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK_VALUE = 6;
    
    public static final int VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW_VALUE = 5;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      STEALTH_BTN_CLICK = new Event("STEALTH_BTN_CLICK", 4, 4);
      VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW = new Event("VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW", 5, 5);
      VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK = new Event("VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK", 6, 6);
      FEATURED_FOR_YOU_PAGE_SHOW = new Event("FEATURED_FOR_YOU_PAGE_SHOW", 7, 7);
      FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK = new Event("FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK", 8, 8);
      VOCATIVE_BACK_BTN_CLICK = new Event("VOCATIVE_BACK_BTN_CLICK", 9, 9);
      MAP_FIND_BACK_BTN_CLICK = new Event("MAP_FIND_BACK_BTN_CLICK", 10, 10);
      VIP_CENTRE_BACK_BTN_CLICK = new Event("VIP_CENTRE_BACK_BTN_CLICK", 11, 11);
      VIP_BUY_BACK_BTN_CLICK = new Event("VIP_BUY_BACK_BTN_CLICK", 12, 12);
      VIP_BUY_SVIP = new Event("VIP_BUY_SVIP", 13, 13);
      VIP_CENTRE_PAGE_SHOW = new Event("VIP_CENTRE_PAGE_SHOW", 14, 14);
      VIP_CENTRE_VIP_UP_SVIP_CLICK = new Event("VIP_CENTRE_VIP_UP_SVIP_CLICK", 15, 15);
      VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW = new Event("VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW", 16, 16);
      VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK = new Event("VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK", 17, 17);
      VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK = new Event("VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK", 18, 18);
      VIP_CENTRE_RESUME_BUY_BTN_SHOW = new Event("VIP_CENTRE_RESUME_BUY_BTN_SHOW", 19, 19);
      VIP_CENTRE_RESUME_BUY_BTN_CLICK = new Event("VIP_CENTRE_RESUME_BUY_BTN_CLICK", 20, 20);
      VIP_CENTRE_BANNER_SHOW = new Event("VIP_CENTRE_BANNER_SHOW", 21, 21);
      VIP_CENTRE_BANNER_CLICK = new Event("VIP_CENTRE_BANNER_CLICK", 22, 22);
      VIP_CENTER_PRIVILEGE_CLICK = new Event("VIP_CENTER_PRIVILEGE_CLICK", 23, 23);
      VIP_CENTER_CAROUSEL_AREA_CLICK = new Event("VIP_CENTER_CAROUSEL_AREA_CLICK", 24, 24);
      VISIT_PAGE_NO_TRACE_BTN_CLICK = new Event("VISIT_PAGE_NO_TRACE_BTN_CLICK", 25, 25);
      MINE_RANGE_TIME_BTN_CLICK = new Event("MINE_RANGE_TIME_BTN_CLICK", 26, 26);
      MINE_HIDE_TINE_BTN_CLICK = new Event("MINE_HIDE_TINE_BTN_CLICK", 27, 27);
      MINE_HIDE_RANGE_BTN_CLICK = new Event("MINE_HIDE_RANGE_BTN_CLICK", 28, 28);
      VIP_CENTER_TOP_RENEW_NOW_CLICK = new Event("VIP_CENTER_TOP_RENEW_NOW_CLICK", 29, 29);
      MAP_FIND_SETTINGS_BTN_CLICK = new Event("MAP_FIND_SETTINGS_BTN_CLICK", 30, 30);
      MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK = new Event("MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK", 31, 31);
      ORDER_COUPON_SHOW = new Event("ORDER_COUPON_SHOW", 32, 32);
      ORDER_COUPON_CLICK = new Event("ORDER_COUPON_CLICK", 33, 33);
      VIP_BUY_PAGE_MORE_BTN_SHOW = new Event("VIP_BUY_PAGE_MORE_BTN_SHOW", 34, 34);
      VIP_BUY_PAGE_MORE_BTN_CLICK = new Event("VIP_BUY_PAGE_MORE_BTN_CLICK", 35, 35);
      VIP_BUY_PAGE_CANCEL_POP_SHOW = new Event("VIP_BUY_PAGE_CANCEL_POP_SHOW", 36, 36);
      VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK = new Event("VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK", 37, 37);
      VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK = new Event("VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK", 38, 38);
      NO_AD_PROPAGATE_SHOW = new Event("NO_AD_PROPAGATE_SHOW", 39, 39);
      NO_AD_PROPAGATE_BUY_CLICK = new Event("NO_AD_PROPAGATE_BUY_CLICK", 40, 40);
      NO_AD_PROPAGATE_OPEN_CLICK = new Event("NO_AD_PROPAGATE_OPEN_CLICK", 41, 41);
      NO_AD_PROPAGATE_CLOSE_CLICK = new Event("NO_AD_PROPAGATE_CLOSE_CLICK", 42, 42);
      NO_AD_PROPAGATE_BAN_CLICK = new Event("NO_AD_PROPAGATE_BAN_CLICK", 43, 43);
      VIP_LEVEL_PAGE_SHOW = new Event("VIP_LEVEL_PAGE_SHOW", 44, 44);
      VIP_LEVEL_PAGE_UP_BLUEDX_CLICK = new Event("VIP_LEVEL_PAGE_UP_BLUEDX_CLICK", 45, 45);
      VIP_CHANGE_ICON_SAVE_BTN_CLICK = new Event("VIP_CHANGE_ICON_SAVE_BTN_CLICK", 46, 46);
      VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK = new Event("VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK", 47, 47);
      VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK = new Event("VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK", 48, 48);
      VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK = new Event("VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK", 49, 49);
      IOS_PAY_THIRD_STATUS = new Event("IOS_PAY_THIRD_STATUS", 50, 50);
      VIP_PRIVACY_PHOTO_EXPAND_CLICK = new Event("VIP_PRIVACY_PHOTO_EXPAND_CLICK", 51, 51);
      VIP_PRIVACY_PHOTO_LOCKED_SHOW = new Event("VIP_PRIVACY_PHOTO_LOCKED_SHOW", 52, 52);
      VIP_PRIVACY_PHOTO_LOCKED_CLICK = new Event("VIP_PRIVACY_PHOTO_LOCKED_CLICK", 53, 53);
      VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK = new Event("VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK", 54, 54);
      VISIT_PAGE_SHADOW_BTN_SHOW = new Event("VISIT_PAGE_SHADOW_BTN_SHOW", 55, 55);
      VISIT_PAGE_SHADOW_BTN_CLICK = new Event("VISIT_PAGE_SHADOW_BTN_CLICK", 56, 56);
      VIP_CENTER_PHOTO_PENDANT_CLICK = new Event("VIP_CENTER_PHOTO_PENDANT_CLICK", 57, 57);
      PHOTO_PENDANT_PAGE_SAVE_CLICK = new Event("PHOTO_PENDANT_PAGE_SAVE_CLICK", 58, 58);
      PHOTO_PENDANT_PAGE_VIP_CLICK = new Event("PHOTO_PENDANT_PAGE_VIP_CLICK", 59, 59);
      VIP_CENTER_RENEW_SHOW = new Event("VIP_CENTER_RENEW_SHOW", 60, 60);
      VIP_CENTER_RENEW_CLICK = new Event("VIP_CENTER_RENEW_CLICK", 61, 61);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 62, -1);
      $VALUES = new Event[] { 
          UNKNOWN_EVENT, VIP_BUY_SHOW, VIP_BUY_SWITCH_BTN_CLICK, VIP_BUY_OPEN_BTN_CLICK, STEALTH_BTN_CLICK, VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW, VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK, FEATURED_FOR_YOU_PAGE_SHOW, FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK, VOCATIVE_BACK_BTN_CLICK, 
          MAP_FIND_BACK_BTN_CLICK, VIP_CENTRE_BACK_BTN_CLICK, VIP_BUY_BACK_BTN_CLICK, VIP_BUY_SVIP, VIP_CENTRE_PAGE_SHOW, VIP_CENTRE_VIP_UP_SVIP_CLICK, VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW, VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK, VIP_CENTRE_RESUME_BUY_BTN_SHOW, 
          VIP_CENTRE_RESUME_BUY_BTN_CLICK, VIP_CENTRE_BANNER_SHOW, VIP_CENTRE_BANNER_CLICK, VIP_CENTER_PRIVILEGE_CLICK, VIP_CENTER_CAROUSEL_AREA_CLICK, VISIT_PAGE_NO_TRACE_BTN_CLICK, MINE_RANGE_TIME_BTN_CLICK, MINE_HIDE_TINE_BTN_CLICK, MINE_HIDE_RANGE_BTN_CLICK, VIP_CENTER_TOP_RENEW_NOW_CLICK, 
          MAP_FIND_SETTINGS_BTN_CLICK, MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK, ORDER_COUPON_SHOW, ORDER_COUPON_CLICK, VIP_BUY_PAGE_MORE_BTN_SHOW, VIP_BUY_PAGE_MORE_BTN_CLICK, VIP_BUY_PAGE_CANCEL_POP_SHOW, VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK, VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK, NO_AD_PROPAGATE_SHOW, 
          NO_AD_PROPAGATE_BUY_CLICK, NO_AD_PROPAGATE_OPEN_CLICK, NO_AD_PROPAGATE_CLOSE_CLICK, NO_AD_PROPAGATE_BAN_CLICK, VIP_LEVEL_PAGE_SHOW, VIP_LEVEL_PAGE_UP_BLUEDX_CLICK, VIP_CHANGE_ICON_SAVE_BTN_CLICK, VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK, VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK, VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK, 
          IOS_PAY_THIRD_STATUS, VIP_PRIVACY_PHOTO_EXPAND_CLICK, VIP_PRIVACY_PHOTO_LOCKED_SHOW, VIP_PRIVACY_PHOTO_LOCKED_CLICK, VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK, VISIT_PAGE_SHADOW_BTN_SHOW, VISIT_PAGE_SHADOW_BTN_CLICK, VIP_CENTER_PHOTO_PENDANT_CLICK, PHOTO_PENDANT_PAGE_SAVE_CLICK, PHOTO_PENDANT_PAGE_VIP_CLICK, 
          VIP_CENTER_RENEW_SHOW, VIP_CENTER_RENEW_CLICK, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public VipProtos.Event findValueByNumber(int param2Int) {
            return VipProtos.Event.forNumber(param2Int);
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
        case 61:
          return VIP_CENTER_RENEW_CLICK;
        case 60:
          return VIP_CENTER_RENEW_SHOW;
        case 59:
          return PHOTO_PENDANT_PAGE_VIP_CLICK;
        case 58:
          return PHOTO_PENDANT_PAGE_SAVE_CLICK;
        case 57:
          return VIP_CENTER_PHOTO_PENDANT_CLICK;
        case 56:
          return VISIT_PAGE_SHADOW_BTN_CLICK;
        case 55:
          return VISIT_PAGE_SHADOW_BTN_SHOW;
        case 54:
          return VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK;
        case 53:
          return VIP_PRIVACY_PHOTO_LOCKED_CLICK;
        case 52:
          return VIP_PRIVACY_PHOTO_LOCKED_SHOW;
        case 51:
          return VIP_PRIVACY_PHOTO_EXPAND_CLICK;
        case 50:
          return IOS_PAY_THIRD_STATUS;
        case 49:
          return VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK;
        case 48:
          return VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK;
        case 47:
          return VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK;
        case 46:
          return VIP_CHANGE_ICON_SAVE_BTN_CLICK;
        case 45:
          return VIP_LEVEL_PAGE_UP_BLUEDX_CLICK;
        case 44:
          return VIP_LEVEL_PAGE_SHOW;
        case 43:
          return NO_AD_PROPAGATE_BAN_CLICK;
        case 42:
          return NO_AD_PROPAGATE_CLOSE_CLICK;
        case 41:
          return NO_AD_PROPAGATE_OPEN_CLICK;
        case 40:
          return NO_AD_PROPAGATE_BUY_CLICK;
        case 39:
          return NO_AD_PROPAGATE_SHOW;
        case 38:
          return VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK;
        case 37:
          return VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK;
        case 36:
          return VIP_BUY_PAGE_CANCEL_POP_SHOW;
        case 35:
          return VIP_BUY_PAGE_MORE_BTN_CLICK;
        case 34:
          return VIP_BUY_PAGE_MORE_BTN_SHOW;
        case 33:
          return ORDER_COUPON_CLICK;
        case 32:
          return ORDER_COUPON_SHOW;
        case 31:
          return MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK;
        case 30:
          return MAP_FIND_SETTINGS_BTN_CLICK;
        case 29:
          return VIP_CENTER_TOP_RENEW_NOW_CLICK;
        case 28:
          return MINE_HIDE_RANGE_BTN_CLICK;
        case 27:
          return MINE_HIDE_TINE_BTN_CLICK;
        case 26:
          return MINE_RANGE_TIME_BTN_CLICK;
        case 25:
          return VISIT_PAGE_NO_TRACE_BTN_CLICK;
        case 24:
          return VIP_CENTER_CAROUSEL_AREA_CLICK;
        case 23:
          return VIP_CENTER_PRIVILEGE_CLICK;
        case 22:
          return VIP_CENTRE_BANNER_CLICK;
        case 21:
          return VIP_CENTRE_BANNER_SHOW;
        case 20:
          return VIP_CENTRE_RESUME_BUY_BTN_CLICK;
        case 19:
          return VIP_CENTRE_RESUME_BUY_BTN_SHOW;
        case 18:
          return VIP_CENTRE_SUPER_HIDE_COMPLETE_BTN_CLICK;
        case 17:
          return VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK;
        case 16:
          return VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW;
        case 15:
          return VIP_CENTRE_VIP_UP_SVIP_CLICK;
        case 14:
          return VIP_CENTRE_PAGE_SHOW;
        case 13:
          return VIP_BUY_SVIP;
        case 12:
          return VIP_BUY_BACK_BTN_CLICK;
        case 11:
          return VIP_CENTRE_BACK_BTN_CLICK;
        case 10:
          return MAP_FIND_BACK_BTN_CLICK;
        case 9:
          return VOCATIVE_BACK_BTN_CLICK;
        case 8:
          return FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK;
        case 7:
          return FEATURED_FOR_YOU_PAGE_SHOW;
        case 6:
          return VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK;
        case 5:
          return VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_SHOW;
        case 4:
          return STEALTH_BTN_CLICK;
        case 3:
          return VIP_BUY_OPEN_BTN_CLICK;
        case 2:
          return VIP_BUY_SWITCH_BTN_CLICK;
        case 1:
          return VIP_BUY_SHOW;
        case 0:
          break;
      } 
      return UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(0);
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
    public VipProtos.Event findValueByNumber(int param1Int) {
      return VipProtos.Event.forNumber(param1Int);
    }
  }
  
  public enum FromType implements ProtocolMessageEnum {
    UNKNOWN_FROM(0),
    UNRECOGNIZED(0),
    VISIT_NONE(0),
    VISIT_ONLY_ONE(0),
    APP_STORE(2),
    CONSTELLATION_FILTER(2),
    FEED_DYNAMIC_SKIN(2),
    FIFTEEN_VISIT_TREND(2),
    HISTORY(2),
    MAP_FIND_BUY(2),
    MSG_BUBBLE(2),
    NEARBY_FRIEND_AVATAR_LOC(2),
    NEARBY_FRIEND_MAP_FIND_NONE_TRIAL(2),
    NEARBY_FRIEND_MAP_FIND_TRIAL(2),
    PHOTO_FILTER(2),
    PHOTO_PENDANT_OTHER(2),
    PHOTO_PENDANT_OWN(2),
    PHOTO_PENDANT_VIP_CENTER(2),
    PRIVACY_PHOTO_EXPAND(2),
    PRIVACY_PHOTO_LOCKED_RENEW(2),
    TODAY_VISIT_REMAIN(2);
    
    public static final int APP_STORE_VALUE = 6;
    
    public static final int CONSTELLATION_FILTER_VALUE = 19;
    
    public static final int FEED_DYNAMIC_SKIN_VALUE = 8;
    
    public static final int FIFTEEN_VISIT_TREND_VALUE = 3;
    
    public static final int HISTORY_VALUE = 1;
    
    public static final int MAP_FIND_BUY_VALUE = 13;
    
    public static final int MSG_BUBBLE_VALUE = 7;
    
    public static final int NEARBY_FRIEND_AVATAR_LOC_VALUE = 15;
    
    public static final int NEARBY_FRIEND_MAP_FIND_NONE_TRIAL_VALUE = 16;
    
    public static final int NEARBY_FRIEND_MAP_FIND_TRIAL_VALUE = 17;
    
    public static final int PHOTO_FILTER_VALUE = 18;
    
    public static final int PHOTO_PENDANT_OTHER_VALUE = 12;
    
    public static final int PHOTO_PENDANT_OWN_VALUE = 11;
    
    public static final int PHOTO_PENDANT_VIP_CENTER_VALUE = 14;
    
    public static final int PRIVACY_PHOTO_EXPAND_VALUE = 9;
    
    public static final int PRIVACY_PHOTO_LOCKED_RENEW_VALUE = 10;
    
    public static final int TODAY_VISIT_REMAIN_VALUE = 2;
    
    public static final int UNKNOWN_FROM_VALUE = 0;
    
    private static final FromType[] VALUES;
    
    public static final int VISIT_NONE_VALUE = 5;
    
    public static final int VISIT_ONLY_ONE_VALUE = 4;
    
    private static final Internal.EnumLiteMap<FromType> internalValueMap;
    
    private final int value;
    
    static {
      FIFTEEN_VISIT_TREND = new FromType("FIFTEEN_VISIT_TREND", 3, 3);
      VISIT_ONLY_ONE = new FromType("VISIT_ONLY_ONE", 4, 4);
      VISIT_NONE = new FromType("VISIT_NONE", 5, 5);
      APP_STORE = new FromType("APP_STORE", 6, 6);
      MSG_BUBBLE = new FromType("MSG_BUBBLE", 7, 7);
      FEED_DYNAMIC_SKIN = new FromType("FEED_DYNAMIC_SKIN", 8, 8);
      PRIVACY_PHOTO_EXPAND = new FromType("PRIVACY_PHOTO_EXPAND", 9, 9);
      PRIVACY_PHOTO_LOCKED_RENEW = new FromType("PRIVACY_PHOTO_LOCKED_RENEW", 10, 10);
      PHOTO_PENDANT_OWN = new FromType("PHOTO_PENDANT_OWN", 11, 11);
      PHOTO_PENDANT_OTHER = new FromType("PHOTO_PENDANT_OTHER", 12, 12);
      MAP_FIND_BUY = new FromType("MAP_FIND_BUY", 13, 13);
      PHOTO_PENDANT_VIP_CENTER = new FromType("PHOTO_PENDANT_VIP_CENTER", 14, 14);
      NEARBY_FRIEND_AVATAR_LOC = new FromType("NEARBY_FRIEND_AVATAR_LOC", 15, 15);
      NEARBY_FRIEND_MAP_FIND_NONE_TRIAL = new FromType("NEARBY_FRIEND_MAP_FIND_NONE_TRIAL", 16, 16);
      NEARBY_FRIEND_MAP_FIND_TRIAL = new FromType("NEARBY_FRIEND_MAP_FIND_TRIAL", 17, 17);
      PHOTO_FILTER = new FromType("PHOTO_FILTER", 18, 18);
      CONSTELLATION_FILTER = new FromType("CONSTELLATION_FILTER", 19, 19);
      UNRECOGNIZED = new FromType("UNRECOGNIZED", 20, -1);
      $VALUES = new FromType[] { 
          UNKNOWN_FROM, HISTORY, TODAY_VISIT_REMAIN, FIFTEEN_VISIT_TREND, VISIT_ONLY_ONE, VISIT_NONE, APP_STORE, MSG_BUBBLE, FEED_DYNAMIC_SKIN, PRIVACY_PHOTO_EXPAND, 
          PRIVACY_PHOTO_LOCKED_RENEW, PHOTO_PENDANT_OWN, PHOTO_PENDANT_OTHER, MAP_FIND_BUY, PHOTO_PENDANT_VIP_CENTER, NEARBY_FRIEND_AVATAR_LOC, NEARBY_FRIEND_MAP_FIND_NONE_TRIAL, NEARBY_FRIEND_MAP_FIND_TRIAL, PHOTO_FILTER, CONSTELLATION_FILTER, 
          UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<FromType>() {
          public VipProtos.FromType findValueByNumber(int param2Int) {
            return VipProtos.FromType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    FromType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FromType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 19:
          return CONSTELLATION_FILTER;
        case 18:
          return PHOTO_FILTER;
        case 17:
          return NEARBY_FRIEND_MAP_FIND_TRIAL;
        case 16:
          return NEARBY_FRIEND_MAP_FIND_NONE_TRIAL;
        case 15:
          return NEARBY_FRIEND_AVATAR_LOC;
        case 14:
          return PHOTO_PENDANT_VIP_CENTER;
        case 13:
          return MAP_FIND_BUY;
        case 12:
          return PHOTO_PENDANT_OTHER;
        case 11:
          return PHOTO_PENDANT_OWN;
        case 10:
          return PRIVACY_PHOTO_LOCKED_RENEW;
        case 9:
          return PRIVACY_PHOTO_EXPAND;
        case 8:
          return FEED_DYNAMIC_SKIN;
        case 7:
          return MSG_BUBBLE;
        case 6:
          return APP_STORE;
        case 5:
          return VISIT_NONE;
        case 4:
          return VISIT_ONLY_ONE;
        case 3:
          return FIFTEEN_VISIT_TREND;
        case 2:
          return TODAY_VISIT_REMAIN;
        case 1:
          return HISTORY;
        case 0:
          break;
      } 
      return UNKNOWN_FROM;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(3);
    }
    
    public static Internal.EnumLiteMap<FromType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<FromType> {
    public VipProtos.FromType findValueByNumber(int param1Int) {
      return VipProtos.FromType.forNumber(param1Int);
    }
  }
  
  public enum HideType implements ProtocolMessageEnum {
    HIDE_AGE(0),
    HIDE_ALL(0),
    HIDE_DISTANCE(0),
    HIDE_ROLE(0),
    UNKNOWN_HIDE_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int HIDE_AGE_VALUE = 4;
    
    public static final int HIDE_ALL_VALUE = 1;
    
    public static final int HIDE_DISTANCE_VALUE = 2;
    
    public static final int HIDE_ROLE_VALUE = 3;
    
    public static final int UNKNOWN_HIDE_TYPE_VALUE = 0;
    
    private static final HideType[] VALUES;
    
    private static final Internal.EnumLiteMap<HideType> internalValueMap;
    
    private final int value;
    
    static {
      HIDE_AGE = new HideType("HIDE_AGE", 4, 4);
      UNRECOGNIZED = new HideType("UNRECOGNIZED", 5, -1);
      $VALUES = new HideType[] { UNKNOWN_HIDE_TYPE, HIDE_ALL, HIDE_DISTANCE, HIDE_ROLE, HIDE_AGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<HideType>() {
          public VipProtos.HideType findValueByNumber(int param2Int) {
            return VipProtos.HideType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    HideType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static HideType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : HIDE_AGE) : HIDE_ROLE) : HIDE_DISTANCE) : HIDE_ALL) : UNKNOWN_HIDE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(9);
    }
    
    public static Internal.EnumLiteMap<HideType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<HideType> {
    public VipProtos.HideType findValueByNumber(int param1Int) {
      return VipProtos.HideType.forNumber(param1Int);
    }
  }
  
  public enum IdentityType implements ProtocolMessageEnum {
    NONE(0),
    SVIP_EXPIRED(0),
    SVIP_TYPE(0),
    UNKNOWN_IDENTITY_TYPE(0),
    UNRECOGNIZED(0),
    VIP_EXPIRED(0),
    VIP_TYPE(0);
    
    public static final int NONE_VALUE = 1;
    
    public static final int SVIP_EXPIRED_VALUE = 5;
    
    public static final int SVIP_TYPE_VALUE = 3;
    
    public static final int UNKNOWN_IDENTITY_TYPE_VALUE = 0;
    
    private static final IdentityType[] VALUES;
    
    public static final int VIP_EXPIRED_VALUE = 4;
    
    public static final int VIP_TYPE_VALUE = 2;
    
    private static final Internal.EnumLiteMap<IdentityType> internalValueMap;
    
    private final int value;
    
    static {
      SVIP_TYPE = new IdentityType("SVIP_TYPE", 3, 3);
      VIP_EXPIRED = new IdentityType("VIP_EXPIRED", 4, 4);
      SVIP_EXPIRED = new IdentityType("SVIP_EXPIRED", 5, 5);
      UNRECOGNIZED = new IdentityType("UNRECOGNIZED", 6, -1);
      $VALUES = new IdentityType[] { UNKNOWN_IDENTITY_TYPE, NONE, VIP_TYPE, SVIP_TYPE, VIP_EXPIRED, SVIP_EXPIRED, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<IdentityType>() {
          public VipProtos.IdentityType findValueByNumber(int param2Int) {
            return VipProtos.IdentityType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    IdentityType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static IdentityType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : SVIP_EXPIRED) : VIP_EXPIRED) : SVIP_TYPE) : VIP_TYPE) : NONE) : UNKNOWN_IDENTITY_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(7);
    }
    
    public static Internal.EnumLiteMap<IdentityType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<IdentityType> {
    public VipProtos.IdentityType findValueByNumber(int param1Int) {
      return VipProtos.IdentityType.forNumber(param1Int);
    }
  }
  
  public enum Name implements ProtocolMessageEnum {
    SVIP(0),
    UNKNOWN_NAME(0),
    UNRECOGNIZED(0),
    VIP(1);
    
    public static final int SVIP_VALUE = 2;
    
    public static final int UNKNOWN_NAME_VALUE = 0;
    
    private static final Name[] VALUES;
    
    public static final int VIP_VALUE = 1;
    
    private static final Internal.EnumLiteMap<Name> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Name[] { UNKNOWN_NAME, VIP, SVIP, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Name>() {
          public VipProtos.Name findValueByNumber(int param2Int) {
            return VipProtos.Name.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Name(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Name forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : SVIP) : VIP) : UNKNOWN_NAME;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(2);
    }
    
    public static Internal.EnumLiteMap<Name> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<Name> {
    public VipProtos.Name findValueByNumber(int param1Int) {
      return VipProtos.Name.forNumber(param1Int);
    }
  }
  
  public enum OrderType implements ProtocolMessageEnum {
    UNKNOWN_ORDER_TYPE(0),
    UNRECOGNIZED(0),
    ORDER_CALL(1),
    ORDER_EXPOSURE(1),
    ORDER_SVIP(1),
    ORDER_VIP(1);
    
    public static final int ORDER_CALL_VALUE = 3;
    
    public static final int ORDER_EXPOSURE_VALUE = 4;
    
    public static final int ORDER_SVIP_VALUE = 2;
    
    public static final int ORDER_VIP_VALUE = 1;
    
    public static final int UNKNOWN_ORDER_TYPE_VALUE = 0;
    
    private static final OrderType[] VALUES;
    
    private static final Internal.EnumLiteMap<OrderType> internalValueMap;
    
    private final int value;
    
    static {
      ORDER_SVIP = new OrderType("ORDER_SVIP", 2, 2);
      ORDER_CALL = new OrderType("ORDER_CALL", 3, 3);
      ORDER_EXPOSURE = new OrderType("ORDER_EXPOSURE", 4, 4);
      UNRECOGNIZED = new OrderType("UNRECOGNIZED", 5, -1);
      $VALUES = new OrderType[] { UNKNOWN_ORDER_TYPE, ORDER_VIP, ORDER_SVIP, ORDER_CALL, ORDER_EXPOSURE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<OrderType>() {
          public VipProtos.OrderType findValueByNumber(int param2Int) {
            return VipProtos.OrderType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    OrderType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OrderType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : ORDER_EXPOSURE) : ORDER_CALL) : ORDER_SVIP) : ORDER_VIP) : UNKNOWN_ORDER_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(10);
    }
    
    public static Internal.EnumLiteMap<OrderType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<OrderType> {
    public VipProtos.OrderType findValueByNumber(int param1Int) {
      return VipProtos.OrderType.forNumber(param1Int);
    }
  }
  
  public enum PageLevel implements ProtocolMessageEnum {
    SVIP_PAGE(0),
    UNKNOWN_PAGE_LEVEL(0),
    UNRECOGNIZED(0),
    VIP_PAGE(1);
    
    public static final int SVIP_PAGE_VALUE = 2;
    
    public static final int UNKNOWN_PAGE_LEVEL_VALUE = 0;
    
    private static final PageLevel[] VALUES;
    
    public static final int VIP_PAGE_VALUE = 1;
    
    private static final Internal.EnumLiteMap<PageLevel> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new PageLevel[] { UNKNOWN_PAGE_LEVEL, VIP_PAGE, SVIP_PAGE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PageLevel>() {
          public VipProtos.PageLevel findValueByNumber(int param2Int) {
            return VipProtos.PageLevel.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PageLevel(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PageLevel forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : SVIP_PAGE) : VIP_PAGE) : UNKNOWN_PAGE_LEVEL;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(8);
    }
    
    public static Internal.EnumLiteMap<PageLevel> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PageLevel> {
    public VipProtos.PageLevel findValueByNumber(int param1Int) {
      return VipProtos.PageLevel.forNumber(param1Int);
    }
  }
  
  public enum PageVersion implements ProtocolMessageEnum {
    UNKNOWN_PAGE_VERSION(0),
    UNRECOGNIZED(0),
    V_0730(1),
    V_0813(2);
    
    public static final int UNKNOWN_PAGE_VERSION_VALUE = 0;
    
    private static final PageVersion[] VALUES;
    
    public static final int V_0730_VALUE = 1;
    
    public static final int V_0813_VALUE = 2;
    
    private static final Internal.EnumLiteMap<PageVersion> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new PageVersion[] { UNKNOWN_PAGE_VERSION, V_0730, V_0813, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PageVersion>() {
          public VipProtos.PageVersion findValueByNumber(int param2Int) {
            return VipProtos.PageVersion.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PageVersion(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PageVersion forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : V_0813) : V_0730) : UNKNOWN_PAGE_VERSION;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(6);
    }
    
    public static Internal.EnumLiteMap<PageVersion> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<PageVersion> {
    public VipProtos.PageVersion findValueByNumber(int param1Int) {
      return VipProtos.PageVersion.forNumber(param1Int);
    }
  }
  
  public enum StealthType implements ProtocolMessageEnum {
    UNKNOWN_STEALTH_TYPE(0),
    UNRECOGNIZED(0),
    WHOLE(1),
    HALF(2);
    
    public static final int HALF_VALUE = 2;
    
    public static final int UNKNOWN_STEALTH_TYPE_VALUE = 0;
    
    private static final StealthType[] VALUES;
    
    public static final int WHOLE_VALUE = 1;
    
    private static final Internal.EnumLiteMap<StealthType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new StealthType[] { UNKNOWN_STEALTH_TYPE, WHOLE, HALF, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<StealthType>() {
          public VipProtos.StealthType findValueByNumber(int param2Int) {
            return VipProtos.StealthType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    StealthType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static StealthType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : HALF) : WHOLE) : UNKNOWN_STEALTH_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(4);
    }
    
    public static Internal.EnumLiteMap<StealthType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<StealthType> {
    public VipProtos.StealthType findValueByNumber(int param1Int) {
      return VipProtos.StealthType.forNumber(param1Int);
    }
  }
  
  public static final class VipProto extends GeneratedMessageV3 implements VipProtoOrBuilder {
    public static final int AD_PAGE_FIELD_NUMBER = 22;
    
    public static final int AD_TYPE_FIELD_NUMBER = 23;
    
    public static final int BANNER_ID_FIELD_NUMBER = 20;
    
    public static final int BANNER_URL_FIELD_NUMBER = 17;
    
    public static final int BTN_TYPE_FIELD_NUMBER = 19;
    
    private static final VipProto DEFAULT_INSTANCE = new VipProto();
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int FROM_FIELD_NUMBER = 3;
    
    public static final int HIDE_TYPE_FIELD_NUMBER = 12;
    
    public static final int IDENTITY_TYPE_FIELD_NUMBER = 8;
    
    public static final int ID_FIELD_NUMBER = 29;
    
    public static final int IMAGE_ID_FIELD_NUMBER = 26;
    
    public static final int IS_BUY_SUCCESS_FIELD_NUMBER = 9;
    
    public static final int IS_HIDE_AGE_FIELD_NUMBER = 16;
    
    public static final int IS_HIDE_ALL_FIELD_NUMBER = 13;
    
    public static final int IS_HIDE_DISTANCE_FIELD_NUMBER = 14;
    
    public static final int IS_HIDE_ROLE_FIELD_NUMBER = 15;
    
    public static final int IS_OPEN_FIELD_NUMBER = 10;
    
    public static final int IS_RANGE_FIELD_NUMBER = 5;
    
    public static final int IS_SHADOW_FIELD_NUMBER = 28;
    
    public static final int LATITUDE_FIELD_NUMBER = 25;
    
    public static final int LONGITUDE_FIELD_NUMBER = 24;
    
    public static final int NAME_FIELD_NUMBER = 2;
    
    public static final int ORDER_TYPE_FIELD_NUMBER = 21;
    
    public static final int PAGE_LEVEL_FIELD_NUMBER = 11;
    
    public static final int PAGE_VERSION_FIELD_NUMBER = 7;
    
    private static final Parser<VipProto> PARSER = (Parser<VipProto>)new AbstractParser<VipProto>() {
        public VipProtos.VipProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new VipProtos.VipProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PRIVILEGE_ID_FIELD_NUMBER = 18;
    
    public static final int STEALTH_TYPE_FIELD_NUMBER = 4;
    
    public static final int THIRD_ID_FIELD_NUMBER = 27;
    
    public static final int VOCATIVE_TYPE_FIELD_NUMBER = 6;
    
    private static final long serialVersionUID = 0L;
    
    private int adPage_;
    
    private volatile Object adType_;
    
    private volatile Object bannerId_;
    
    private volatile Object bannerUrl_;
    
    private int btnType_;
    
    private int event_;
    
    private int from_;
    
    private int hideType_;
    
    private volatile Object id_;
    
    private int identityType_;
    
    private volatile Object imageId_;
    
    private boolean isBuySuccess_;
    
    private boolean isHideAge_;
    
    private boolean isHideAll_;
    
    private boolean isHideDistance_;
    
    private boolean isHideRole_;
    
    private boolean isOpen_;
    
    private boolean isRange_;
    
    private boolean isShadow_;
    
    private volatile Object latitude_;
    
    private volatile Object longitude_;
    
    private byte memoizedIsInitialized = -1;
    
    private int name_;
    
    private int orderType_;
    
    private int pageLevel_;
    
    private int pageVersion_;
    
    private volatile Object privilegeId_;
    
    private int stealthType_;
    
    private volatile Object thirdId_;
    
    private int vocativeType_;
    
    private VipProto() {
      this.event_ = 0;
      this.name_ = 0;
      this.from_ = 0;
      this.stealthType_ = 0;
      this.vocativeType_ = 0;
      this.pageVersion_ = 0;
      this.identityType_ = 0;
      this.pageLevel_ = 0;
      this.hideType_ = 0;
      this.bannerUrl_ = "";
      this.privilegeId_ = "";
      this.btnType_ = 0;
      this.bannerId_ = "";
      this.orderType_ = 0;
      this.adPage_ = 0;
      this.adType_ = "";
      this.longitude_ = "";
      this.latitude_ = "";
      this.imageId_ = "";
      this.thirdId_ = "";
      this.id_ = "";
    }
    
    private VipProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            int i = param1CodedInputStream.readTag();
            switch (i) {
              case 234:
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 224:
                this.isShadow_ = param1CodedInputStream.readBool();
                continue;
              case 218:
                this.thirdId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 210:
                this.imageId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 202:
                this.latitude_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 194:
                this.longitude_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 186:
                this.adType_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 176:
                this.adPage_ = param1CodedInputStream.readEnum();
                continue;
              case 168:
                this.orderType_ = param1CodedInputStream.readEnum();
                continue;
              case 162:
                this.bannerId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 152:
                this.btnType_ = param1CodedInputStream.readEnum();
                continue;
              case 146:
                this.privilegeId_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 138:
                this.bannerUrl_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 128:
                this.isHideAge_ = param1CodedInputStream.readBool();
                continue;
              case 120:
                this.isHideRole_ = param1CodedInputStream.readBool();
                continue;
              case 112:
                this.isHideDistance_ = param1CodedInputStream.readBool();
                continue;
              case 104:
                this.isHideAll_ = param1CodedInputStream.readBool();
                continue;
              case 96:
                this.hideType_ = param1CodedInputStream.readEnum();
                continue;
              case 88:
                this.pageLevel_ = param1CodedInputStream.readEnum();
                continue;
              case 80:
                this.isOpen_ = param1CodedInputStream.readBool();
                continue;
              case 72:
                this.isBuySuccess_ = param1CodedInputStream.readBool();
                continue;
              case 64:
                this.identityType_ = param1CodedInputStream.readEnum();
                continue;
              case 56:
                this.pageVersion_ = param1CodedInputStream.readEnum();
                continue;
              case 48:
                this.vocativeType_ = param1CodedInputStream.readEnum();
                continue;
              case 40:
                this.isRange_ = param1CodedInputStream.readBool();
                continue;
              case 32:
                this.stealthType_ = param1CodedInputStream.readEnum();
                continue;
              case 24:
                this.from_ = param1CodedInputStream.readEnum();
                continue;
              case 16:
                this.name_ = param1CodedInputStream.readEnum();
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
    
    private VipProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static VipProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(VipProto param1VipProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1VipProto);
    }
    
    public static VipProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (VipProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static VipProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VipProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static VipProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (VipProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static VipProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VipProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static VipProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (VipProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static VipProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VipProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static VipProto parseFrom(InputStream param1InputStream) throws IOException {
      return (VipProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static VipProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VipProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static VipProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (VipProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static VipProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VipProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static VipProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (VipProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static VipProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VipProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<VipProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof VipProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((VipProto)param1Object).event_) ? false : ((this.name_ != ((VipProto)param1Object).name_) ? false : ((this.from_ != ((VipProto)param1Object).from_) ? false : ((this.stealthType_ != ((VipProto)param1Object).stealthType_) ? false : ((getIsRange() != param1Object.getIsRange()) ? false : ((this.vocativeType_ != ((VipProto)param1Object).vocativeType_) ? false : ((this.pageVersion_ != ((VipProto)param1Object).pageVersion_) ? false : ((this.identityType_ != ((VipProto)param1Object).identityType_) ? false : ((getIsBuySuccess() != param1Object.getIsBuySuccess()) ? false : ((getIsOpen() != param1Object.getIsOpen()) ? false : ((this.pageLevel_ != ((VipProto)param1Object).pageLevel_) ? false : ((this.hideType_ != ((VipProto)param1Object).hideType_) ? false : ((getIsHideAll() != param1Object.getIsHideAll()) ? false : ((getIsHideDistance() != param1Object.getIsHideDistance()) ? false : ((getIsHideRole() != param1Object.getIsHideRole()) ? false : ((getIsHideAge() != param1Object.getIsHideAge()) ? false : (!getBannerUrl().equals(param1Object.getBannerUrl()) ? false : (!getPrivilegeId().equals(param1Object.getPrivilegeId()) ? false : ((this.btnType_ != ((VipProto)param1Object).btnType_) ? false : (!getBannerId().equals(param1Object.getBannerId()) ? false : ((this.orderType_ != ((VipProto)param1Object).orderType_) ? false : ((this.adPage_ != ((VipProto)param1Object).adPage_) ? false : (!getAdType().equals(param1Object.getAdType()) ? false : (!getLongitude().equals(param1Object.getLongitude()) ? false : (!getLatitude().equals(param1Object.getLatitude()) ? false : (!getImageId().equals(param1Object.getImageId()) ? false : (!getThirdId().equals(param1Object.getThirdId()) ? false : ((getIsShadow() != param1Object.getIsShadow()) ? false : (!getId().equals(param1Object.getId()) ? false : (!!this.unknownFields.equals(((VipProto)param1Object).unknownFields))))))))))))))))))))))))))))));
    }
    
    public VipProtos.AdPage getAdPage() {
      VipProtos.AdPage adPage2 = VipProtos.AdPage.valueOf(this.adPage_);
      VipProtos.AdPage adPage1 = adPage2;
      if (adPage2 == null)
        adPage1 = VipProtos.AdPage.UNRECOGNIZED; 
      return adPage1;
    }
    
    public int getAdPageValue() {
      return this.adPage_;
    }
    
    public String getAdType() {
      Object object = this.adType_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.adType_ = object;
      return (String)object;
    }
    
    public ByteString getAdTypeBytes() {
      Object object = this.adType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.adType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getBannerUrl() {
      Object object = this.bannerUrl_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.bannerUrl_ = object;
      return (String)object;
    }
    
    public ByteString getBannerUrlBytes() {
      Object object = this.bannerUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.bannerUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VipProtos.BtnType getBtnType() {
      VipProtos.BtnType btnType2 = VipProtos.BtnType.valueOf(this.btnType_);
      VipProtos.BtnType btnType1 = btnType2;
      if (btnType2 == null)
        btnType1 = VipProtos.BtnType.UNRECOGNIZED; 
      return btnType1;
    }
    
    public int getBtnTypeValue() {
      return this.btnType_;
    }
    
    public VipProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public VipProtos.Event getEvent() {
      VipProtos.Event event2 = VipProtos.Event.valueOf(this.event_);
      VipProtos.Event event1 = event2;
      if (event2 == null)
        event1 = VipProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public VipProtos.FromType getFrom() {
      VipProtos.FromType fromType2 = VipProtos.FromType.valueOf(this.from_);
      VipProtos.FromType fromType1 = fromType2;
      if (fromType2 == null)
        fromType1 = VipProtos.FromType.UNRECOGNIZED; 
      return fromType1;
    }
    
    public int getFromValue() {
      return this.from_;
    }
    
    public VipProtos.HideType getHideType() {
      VipProtos.HideType hideType2 = VipProtos.HideType.valueOf(this.hideType_);
      VipProtos.HideType hideType1 = hideType2;
      if (hideType2 == null)
        hideType1 = VipProtos.HideType.UNRECOGNIZED; 
      return hideType1;
    }
    
    public int getHideTypeValue() {
      return this.hideType_;
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
    
    public VipProtos.IdentityType getIdentityType() {
      VipProtos.IdentityType identityType2 = VipProtos.IdentityType.valueOf(this.identityType_);
      VipProtos.IdentityType identityType1 = identityType2;
      if (identityType2 == null)
        identityType1 = VipProtos.IdentityType.UNRECOGNIZED; 
      return identityType1;
    }
    
    public int getIdentityTypeValue() {
      return this.identityType_;
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
    
    public boolean getIsBuySuccess() {
      return this.isBuySuccess_;
    }
    
    public boolean getIsHideAge() {
      return this.isHideAge_;
    }
    
    public boolean getIsHideAll() {
      return this.isHideAll_;
    }
    
    public boolean getIsHideDistance() {
      return this.isHideDistance_;
    }
    
    public boolean getIsHideRole() {
      return this.isHideRole_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsRange() {
      return this.isRange_;
    }
    
    public boolean getIsShadow() {
      return this.isShadow_;
    }
    
    public String getLatitude() {
      Object object = this.latitude_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.latitude_ = object;
      return (String)object;
    }
    
    public ByteString getLatitudeBytes() {
      Object object = this.latitude_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.latitude_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLongitude() {
      Object object = this.longitude_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.longitude_ = object;
      return (String)object;
    }
    
    public ByteString getLongitudeBytes() {
      Object object = this.longitude_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.longitude_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VipProtos.Name getName() {
      VipProtos.Name name2 = VipProtos.Name.valueOf(this.name_);
      VipProtos.Name name1 = name2;
      if (name2 == null)
        name1 = VipProtos.Name.UNRECOGNIZED; 
      return name1;
    }
    
    public int getNameValue() {
      return this.name_;
    }
    
    public VipProtos.OrderType getOrderType() {
      VipProtos.OrderType orderType2 = VipProtos.OrderType.valueOf(this.orderType_);
      VipProtos.OrderType orderType1 = orderType2;
      if (orderType2 == null)
        orderType1 = VipProtos.OrderType.UNRECOGNIZED; 
      return orderType1;
    }
    
    public int getOrderTypeValue() {
      return this.orderType_;
    }
    
    public VipProtos.PageLevel getPageLevel() {
      VipProtos.PageLevel pageLevel2 = VipProtos.PageLevel.valueOf(this.pageLevel_);
      VipProtos.PageLevel pageLevel1 = pageLevel2;
      if (pageLevel2 == null)
        pageLevel1 = VipProtos.PageLevel.UNRECOGNIZED; 
      return pageLevel1;
    }
    
    public int getPageLevelValue() {
      return this.pageLevel_;
    }
    
    public VipProtos.PageVersion getPageVersion() {
      VipProtos.PageVersion pageVersion2 = VipProtos.PageVersion.valueOf(this.pageVersion_);
      VipProtos.PageVersion pageVersion1 = pageVersion2;
      if (pageVersion2 == null)
        pageVersion1 = VipProtos.PageVersion.UNRECOGNIZED; 
      return pageVersion1;
    }
    
    public int getPageVersionValue() {
      return this.pageVersion_;
    }
    
    public Parser<VipProto> getParserForType() {
      return PARSER;
    }
    
    public String getPrivilegeId() {
      Object object = this.privilegeId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.privilegeId_ = object;
      return (String)object;
    }
    
    public ByteString getPrivilegeIdBytes() {
      Object object = this.privilegeId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.privilegeId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != VipProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (this.name_ != VipProtos.Name.UNKNOWN_NAME.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.name_); 
      j = i;
      if (this.from_ != VipProtos.FromType.UNKNOWN_FROM.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.from_); 
      i = j;
      if (this.stealthType_ != VipProtos.StealthType.UNKNOWN_STEALTH_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(4, this.stealthType_); 
      boolean bool = this.isRange_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(5, bool); 
      i = j;
      if (this.vocativeType_ != VipProtos.VocativeType.UNKNOWN_VOCATIVE_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(6, this.vocativeType_); 
      j = i;
      if (this.pageVersion_ != VipProtos.PageVersion.UNKNOWN_PAGE_VERSION.getNumber())
        j = i + CodedOutputStream.computeEnumSize(7, this.pageVersion_); 
      i = j;
      if (this.identityType_ != VipProtos.IdentityType.UNKNOWN_IDENTITY_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(8, this.identityType_); 
      bool = this.isBuySuccess_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(9, bool); 
      bool = this.isOpen_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(10, bool); 
      j = i;
      if (this.pageLevel_ != VipProtos.PageLevel.UNKNOWN_PAGE_LEVEL.getNumber())
        j = i + CodedOutputStream.computeEnumSize(11, this.pageLevel_); 
      i = j;
      if (this.hideType_ != VipProtos.HideType.UNKNOWN_HIDE_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(12, this.hideType_); 
      bool = this.isHideAll_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(13, bool); 
      bool = this.isHideDistance_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(14, bool); 
      bool = this.isHideRole_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(15, bool); 
      bool = this.isHideAge_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(16, bool); 
      j = i;
      if (!getBannerUrlBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(17, this.bannerUrl_); 
      i = j;
      if (!getPrivilegeIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(18, this.privilegeId_); 
      j = i;
      if (this.btnType_ != VipProtos.BtnType.UNKNOWN_BTN_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(19, this.btnType_); 
      i = j;
      if (!getBannerIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(20, this.bannerId_); 
      j = i;
      if (this.orderType_ != VipProtos.OrderType.UNKNOWN_ORDER_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(21, this.orderType_); 
      i = j;
      if (this.adPage_ != VipProtos.AdPage.UNKNOWN_AD_PAGE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(22, this.adPage_); 
      j = i;
      if (!getAdTypeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(23, this.adType_); 
      i = j;
      if (!getLongitudeBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(24, this.longitude_); 
      j = i;
      if (!getLatitudeBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(25, this.latitude_); 
      i = j;
      if (!getImageIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(26, this.imageId_); 
      j = i;
      if (!getThirdIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(27, this.thirdId_); 
      bool = this.isShadow_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(28, bool); 
      j = i;
      if (!getIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(29, this.id_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public VipProtos.StealthType getStealthType() {
      VipProtos.StealthType stealthType2 = VipProtos.StealthType.valueOf(this.stealthType_);
      VipProtos.StealthType stealthType1 = stealthType2;
      if (stealthType2 == null)
        stealthType1 = VipProtos.StealthType.UNRECOGNIZED; 
      return stealthType1;
    }
    
    public int getStealthTypeValue() {
      return this.stealthType_;
    }
    
    public String getThirdId() {
      Object object = this.thirdId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.thirdId_ = object;
      return (String)object;
    }
    
    public ByteString getThirdIdBytes() {
      Object object = this.thirdId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.thirdId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public VipProtos.VocativeType getVocativeType() {
      VipProtos.VocativeType vocativeType2 = VipProtos.VocativeType.valueOf(this.vocativeType_);
      VipProtos.VocativeType vocativeType1 = vocativeType2;
      if (vocativeType2 == null)
        vocativeType1 = VipProtos.VocativeType.UNRECOGNIZED; 
      return vocativeType1;
    }
    
    public int getVocativeTypeValue() {
      return this.vocativeType_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + this.name_) * 37 + 3) * 53 + this.from_) * 37 + 4) * 53 + this.stealthType_) * 37 + 5) * 53 + Internal.hashBoolean(getIsRange())) * 37 + 6) * 53 + this.vocativeType_) * 37 + 7) * 53 + this.pageVersion_) * 37 + 8) * 53 + this.identityType_) * 37 + 9) * 53 + Internal.hashBoolean(getIsBuySuccess())) * 37 + 10) * 53 + Internal.hashBoolean(getIsOpen())) * 37 + 11) * 53 + this.pageLevel_) * 37 + 12) * 53 + this.hideType_) * 37 + 13) * 53 + Internal.hashBoolean(getIsHideAll())) * 37 + 14) * 53 + Internal.hashBoolean(getIsHideDistance())) * 37 + 15) * 53 + Internal.hashBoolean(getIsHideRole())) * 37 + 16) * 53 + Internal.hashBoolean(getIsHideAge())) * 37 + 17) * 53 + getBannerUrl().hashCode()) * 37 + 18) * 53 + getPrivilegeId().hashCode()) * 37 + 19) * 53 + this.btnType_) * 37 + 20) * 53 + getBannerId().hashCode()) * 37 + 21) * 53 + this.orderType_) * 37 + 22) * 53 + this.adPage_) * 37 + 23) * 53 + getAdType().hashCode()) * 37 + 24) * 53 + getLongitude().hashCode()) * 37 + 25) * 53 + getLatitude().hashCode()) * 37 + 26) * 53 + getImageId().hashCode()) * 37 + 27) * 53 + getThirdId().hashCode()) * 37 + 28) * 53 + Internal.hashBoolean(getIsShadow())) * 37 + 29) * 53 + getId().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return VipProtos.internal_static_com_blued_das_vip_VipProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VipProto.class, Builder.class);
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
      return new VipProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != VipProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (this.name_ != VipProtos.Name.UNKNOWN_NAME.getNumber())
        param1CodedOutputStream.writeEnum(2, this.name_); 
      if (this.from_ != VipProtos.FromType.UNKNOWN_FROM.getNumber())
        param1CodedOutputStream.writeEnum(3, this.from_); 
      if (this.stealthType_ != VipProtos.StealthType.UNKNOWN_STEALTH_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(4, this.stealthType_); 
      boolean bool = this.isRange_;
      if (bool)
        param1CodedOutputStream.writeBool(5, bool); 
      if (this.vocativeType_ != VipProtos.VocativeType.UNKNOWN_VOCATIVE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(6, this.vocativeType_); 
      if (this.pageVersion_ != VipProtos.PageVersion.UNKNOWN_PAGE_VERSION.getNumber())
        param1CodedOutputStream.writeEnum(7, this.pageVersion_); 
      if (this.identityType_ != VipProtos.IdentityType.UNKNOWN_IDENTITY_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(8, this.identityType_); 
      bool = this.isBuySuccess_;
      if (bool)
        param1CodedOutputStream.writeBool(9, bool); 
      bool = this.isOpen_;
      if (bool)
        param1CodedOutputStream.writeBool(10, bool); 
      if (this.pageLevel_ != VipProtos.PageLevel.UNKNOWN_PAGE_LEVEL.getNumber())
        param1CodedOutputStream.writeEnum(11, this.pageLevel_); 
      if (this.hideType_ != VipProtos.HideType.UNKNOWN_HIDE_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(12, this.hideType_); 
      bool = this.isHideAll_;
      if (bool)
        param1CodedOutputStream.writeBool(13, bool); 
      bool = this.isHideDistance_;
      if (bool)
        param1CodedOutputStream.writeBool(14, bool); 
      bool = this.isHideRole_;
      if (bool)
        param1CodedOutputStream.writeBool(15, bool); 
      bool = this.isHideAge_;
      if (bool)
        param1CodedOutputStream.writeBool(16, bool); 
      if (!getBannerUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 17, this.bannerUrl_); 
      if (!getPrivilegeIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 18, this.privilegeId_); 
      if (this.btnType_ != VipProtos.BtnType.UNKNOWN_BTN_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(19, this.btnType_); 
      if (!getBannerIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 20, this.bannerId_); 
      if (this.orderType_ != VipProtos.OrderType.UNKNOWN_ORDER_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(21, this.orderType_); 
      if (this.adPage_ != VipProtos.AdPage.UNKNOWN_AD_PAGE.getNumber())
        param1CodedOutputStream.writeEnum(22, this.adPage_); 
      if (!getAdTypeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 23, this.adType_); 
      if (!getLongitudeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 24, this.longitude_); 
      if (!getLatitudeBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 25, this.latitude_); 
      if (!getImageIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 26, this.imageId_); 
      if (!getThirdIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 27, this.thirdId_); 
      bool = this.isShadow_;
      if (bool)
        param1CodedOutputStream.writeBool(28, bool); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 29, this.id_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VipProtos.VipProtoOrBuilder {
      private int adPage_ = 0;
      
      private Object adType_ = "";
      
      private Object bannerId_ = "";
      
      private Object bannerUrl_ = "";
      
      private int btnType_ = 0;
      
      private int event_ = 0;
      
      private int from_ = 0;
      
      private int hideType_ = 0;
      
      private Object id_ = "";
      
      private int identityType_ = 0;
      
      private Object imageId_ = "";
      
      private boolean isBuySuccess_;
      
      private boolean isHideAge_;
      
      private boolean isHideAll_;
      
      private boolean isHideDistance_;
      
      private boolean isHideRole_;
      
      private boolean isOpen_;
      
      private boolean isRange_;
      
      private boolean isShadow_;
      
      private Object latitude_ = "";
      
      private Object longitude_ = "";
      
      private int name_ = 0;
      
      private int orderType_ = 0;
      
      private int pageLevel_ = 0;
      
      private int pageVersion_ = 0;
      
      private Object privilegeId_ = "";
      
      private int stealthType_ = 0;
      
      private Object thirdId_ = "";
      
      private int vocativeType_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        VipProtos.VipProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public VipProtos.VipProto build() {
        VipProtos.VipProto vipProto = buildPartial();
        if (vipProto.isInitialized())
          return vipProto; 
        throw newUninitializedMessageException(vipProto);
      }
      
      public VipProtos.VipProto buildPartial() {
        VipProtos.VipProto vipProto = new VipProtos.VipProto(this);
        VipProtos.VipProto.access$602(vipProto, this.event_);
        VipProtos.VipProto.access$702(vipProto, this.name_);
        VipProtos.VipProto.access$802(vipProto, this.from_);
        VipProtos.VipProto.access$902(vipProto, this.stealthType_);
        VipProtos.VipProto.access$1002(vipProto, this.isRange_);
        VipProtos.VipProto.access$1102(vipProto, this.vocativeType_);
        VipProtos.VipProto.access$1202(vipProto, this.pageVersion_);
        VipProtos.VipProto.access$1302(vipProto, this.identityType_);
        VipProtos.VipProto.access$1402(vipProto, this.isBuySuccess_);
        VipProtos.VipProto.access$1502(vipProto, this.isOpen_);
        VipProtos.VipProto.access$1602(vipProto, this.pageLevel_);
        VipProtos.VipProto.access$1702(vipProto, this.hideType_);
        VipProtos.VipProto.access$1802(vipProto, this.isHideAll_);
        VipProtos.VipProto.access$1902(vipProto, this.isHideDistance_);
        VipProtos.VipProto.access$2002(vipProto, this.isHideRole_);
        VipProtos.VipProto.access$2102(vipProto, this.isHideAge_);
        VipProtos.VipProto.access$2202(vipProto, this.bannerUrl_);
        VipProtos.VipProto.access$2302(vipProto, this.privilegeId_);
        VipProtos.VipProto.access$2402(vipProto, this.btnType_);
        VipProtos.VipProto.access$2502(vipProto, this.bannerId_);
        VipProtos.VipProto.access$2602(vipProto, this.orderType_);
        VipProtos.VipProto.access$2702(vipProto, this.adPage_);
        VipProtos.VipProto.access$2802(vipProto, this.adType_);
        VipProtos.VipProto.access$2902(vipProto, this.longitude_);
        VipProtos.VipProto.access$3002(vipProto, this.latitude_);
        VipProtos.VipProto.access$3102(vipProto, this.imageId_);
        VipProtos.VipProto.access$3202(vipProto, this.thirdId_);
        VipProtos.VipProto.access$3302(vipProto, this.isShadow_);
        VipProtos.VipProto.access$3402(vipProto, this.id_);
        onBuilt();
        return vipProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.name_ = 0;
        this.from_ = 0;
        this.stealthType_ = 0;
        this.isRange_ = false;
        this.vocativeType_ = 0;
        this.pageVersion_ = 0;
        this.identityType_ = 0;
        this.isBuySuccess_ = false;
        this.isOpen_ = false;
        this.pageLevel_ = 0;
        this.hideType_ = 0;
        this.isHideAll_ = false;
        this.isHideDistance_ = false;
        this.isHideRole_ = false;
        this.isHideAge_ = false;
        this.bannerUrl_ = "";
        this.privilegeId_ = "";
        this.btnType_ = 0;
        this.bannerId_ = "";
        this.orderType_ = 0;
        this.adPage_ = 0;
        this.adType_ = "";
        this.longitude_ = "";
        this.latitude_ = "";
        this.imageId_ = "";
        this.thirdId_ = "";
        this.isShadow_ = false;
        this.id_ = "";
        return this;
      }
      
      public Builder clearAdPage() {
        this.adPage_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearAdType() {
        this.adType_ = VipProtos.VipProto.getDefaultInstance().getAdType();
        onChanged();
        return this;
      }
      
      public Builder clearBannerId() {
        this.bannerId_ = VipProtos.VipProto.getDefaultInstance().getBannerId();
        onChanged();
        return this;
      }
      
      public Builder clearBannerUrl() {
        this.bannerUrl_ = VipProtos.VipProto.getDefaultInstance().getBannerUrl();
        onChanged();
        return this;
      }
      
      public Builder clearBtnType() {
        this.btnType_ = 0;
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
      
      public Builder clearHideType() {
        this.hideType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearId() {
        this.id_ = VipProtos.VipProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearIdentityType() {
        this.identityType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearImageId() {
        this.imageId_ = VipProtos.VipProto.getDefaultInstance().getImageId();
        onChanged();
        return this;
      }
      
      public Builder clearIsBuySuccess() {
        this.isBuySuccess_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsHideAge() {
        this.isHideAge_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsHideAll() {
        this.isHideAll_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsHideDistance() {
        this.isHideDistance_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsHideRole() {
        this.isHideRole_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsOpen() {
        this.isOpen_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsRange() {
        this.isRange_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsShadow() {
        this.isShadow_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearLatitude() {
        this.latitude_ = VipProtos.VipProto.getDefaultInstance().getLatitude();
        onChanged();
        return this;
      }
      
      public Builder clearLongitude() {
        this.longitude_ = VipProtos.VipProto.getDefaultInstance().getLongitude();
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.name_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOrderType() {
        this.orderType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPageLevel() {
        this.pageLevel_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPageVersion() {
        this.pageVersion_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearPrivilegeId() {
        this.privilegeId_ = VipProtos.VipProto.getDefaultInstance().getPrivilegeId();
        onChanged();
        return this;
      }
      
      public Builder clearStealthType() {
        this.stealthType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearThirdId() {
        this.thirdId_ = VipProtos.VipProto.getDefaultInstance().getThirdId();
        onChanged();
        return this;
      }
      
      public Builder clearVocativeType() {
        this.vocativeType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public VipProtos.AdPage getAdPage() {
        VipProtos.AdPage adPage2 = VipProtos.AdPage.valueOf(this.adPage_);
        VipProtos.AdPage adPage1 = adPage2;
        if (adPage2 == null)
          adPage1 = VipProtos.AdPage.UNRECOGNIZED; 
        return adPage1;
      }
      
      public int getAdPageValue() {
        return this.adPage_;
      }
      
      public String getAdType() {
        Object object = this.adType_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.adType_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getAdTypeBytes() {
        Object object = this.adType_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.adType_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public String getBannerUrl() {
        Object object = this.bannerUrl_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.bannerUrl_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getBannerUrlBytes() {
        Object object = this.bannerUrl_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.bannerUrl_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public VipProtos.BtnType getBtnType() {
        VipProtos.BtnType btnType2 = VipProtos.BtnType.valueOf(this.btnType_);
        VipProtos.BtnType btnType1 = btnType2;
        if (btnType2 == null)
          btnType1 = VipProtos.BtnType.UNRECOGNIZED; 
        return btnType1;
      }
      
      public int getBtnTypeValue() {
        return this.btnType_;
      }
      
      public VipProtos.VipProto getDefaultInstanceForType() {
        return VipProtos.VipProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
      }
      
      public VipProtos.Event getEvent() {
        VipProtos.Event event2 = VipProtos.Event.valueOf(this.event_);
        VipProtos.Event event1 = event2;
        if (event2 == null)
          event1 = VipProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public VipProtos.FromType getFrom() {
        VipProtos.FromType fromType2 = VipProtos.FromType.valueOf(this.from_);
        VipProtos.FromType fromType1 = fromType2;
        if (fromType2 == null)
          fromType1 = VipProtos.FromType.UNRECOGNIZED; 
        return fromType1;
      }
      
      public int getFromValue() {
        return this.from_;
      }
      
      public VipProtos.HideType getHideType() {
        VipProtos.HideType hideType2 = VipProtos.HideType.valueOf(this.hideType_);
        VipProtos.HideType hideType1 = hideType2;
        if (hideType2 == null)
          hideType1 = VipProtos.HideType.UNRECOGNIZED; 
        return hideType1;
      }
      
      public int getHideTypeValue() {
        return this.hideType_;
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
      
      public VipProtos.IdentityType getIdentityType() {
        VipProtos.IdentityType identityType2 = VipProtos.IdentityType.valueOf(this.identityType_);
        VipProtos.IdentityType identityType1 = identityType2;
        if (identityType2 == null)
          identityType1 = VipProtos.IdentityType.UNRECOGNIZED; 
        return identityType1;
      }
      
      public int getIdentityTypeValue() {
        return this.identityType_;
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
      
      public boolean getIsBuySuccess() {
        return this.isBuySuccess_;
      }
      
      public boolean getIsHideAge() {
        return this.isHideAge_;
      }
      
      public boolean getIsHideAll() {
        return this.isHideAll_;
      }
      
      public boolean getIsHideDistance() {
        return this.isHideDistance_;
      }
      
      public boolean getIsHideRole() {
        return this.isHideRole_;
      }
      
      public boolean getIsOpen() {
        return this.isOpen_;
      }
      
      public boolean getIsRange() {
        return this.isRange_;
      }
      
      public boolean getIsShadow() {
        return this.isShadow_;
      }
      
      public String getLatitude() {
        Object object = this.latitude_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.latitude_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLatitudeBytes() {
        Object object = this.latitude_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.latitude_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getLongitude() {
        Object object = this.longitude_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.longitude_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLongitudeBytes() {
        Object object = this.longitude_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.longitude_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public VipProtos.Name getName() {
        VipProtos.Name name2 = VipProtos.Name.valueOf(this.name_);
        VipProtos.Name name1 = name2;
        if (name2 == null)
          name1 = VipProtos.Name.UNRECOGNIZED; 
        return name1;
      }
      
      public int getNameValue() {
        return this.name_;
      }
      
      public VipProtos.OrderType getOrderType() {
        VipProtos.OrderType orderType2 = VipProtos.OrderType.valueOf(this.orderType_);
        VipProtos.OrderType orderType1 = orderType2;
        if (orderType2 == null)
          orderType1 = VipProtos.OrderType.UNRECOGNIZED; 
        return orderType1;
      }
      
      public int getOrderTypeValue() {
        return this.orderType_;
      }
      
      public VipProtos.PageLevel getPageLevel() {
        VipProtos.PageLevel pageLevel2 = VipProtos.PageLevel.valueOf(this.pageLevel_);
        VipProtos.PageLevel pageLevel1 = pageLevel2;
        if (pageLevel2 == null)
          pageLevel1 = VipProtos.PageLevel.UNRECOGNIZED; 
        return pageLevel1;
      }
      
      public int getPageLevelValue() {
        return this.pageLevel_;
      }
      
      public VipProtos.PageVersion getPageVersion() {
        VipProtos.PageVersion pageVersion2 = VipProtos.PageVersion.valueOf(this.pageVersion_);
        VipProtos.PageVersion pageVersion1 = pageVersion2;
        if (pageVersion2 == null)
          pageVersion1 = VipProtos.PageVersion.UNRECOGNIZED; 
        return pageVersion1;
      }
      
      public int getPageVersionValue() {
        return this.pageVersion_;
      }
      
      public String getPrivilegeId() {
        Object object = this.privilegeId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.privilegeId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getPrivilegeIdBytes() {
        Object object = this.privilegeId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.privilegeId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public VipProtos.StealthType getStealthType() {
        VipProtos.StealthType stealthType2 = VipProtos.StealthType.valueOf(this.stealthType_);
        VipProtos.StealthType stealthType1 = stealthType2;
        if (stealthType2 == null)
          stealthType1 = VipProtos.StealthType.UNRECOGNIZED; 
        return stealthType1;
      }
      
      public int getStealthTypeValue() {
        return this.stealthType_;
      }
      
      public String getThirdId() {
        Object object = this.thirdId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.thirdId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getThirdIdBytes() {
        Object object = this.thirdId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.thirdId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public VipProtos.VocativeType getVocativeType() {
        VipProtos.VocativeType vocativeType2 = VipProtos.VocativeType.valueOf(this.vocativeType_);
        VipProtos.VocativeType vocativeType1 = vocativeType2;
        if (vocativeType2 == null)
          vocativeType1 = VipProtos.VocativeType.UNRECOGNIZED; 
        return vocativeType1;
      }
      
      public int getVocativeTypeValue() {
        return this.vocativeType_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return VipProtos.internal_static_com_blued_das_vip_VipProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VipProtos.VipProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(VipProtos.VipProto param2VipProto) {
        if (param2VipProto == VipProtos.VipProto.getDefaultInstance())
          return this; 
        if (param2VipProto.event_ != 0)
          setEventValue(param2VipProto.getEventValue()); 
        if (param2VipProto.name_ != 0)
          setNameValue(param2VipProto.getNameValue()); 
        if (param2VipProto.from_ != 0)
          setFromValue(param2VipProto.getFromValue()); 
        if (param2VipProto.stealthType_ != 0)
          setStealthTypeValue(param2VipProto.getStealthTypeValue()); 
        if (param2VipProto.getIsRange())
          setIsRange(param2VipProto.getIsRange()); 
        if (param2VipProto.vocativeType_ != 0)
          setVocativeTypeValue(param2VipProto.getVocativeTypeValue()); 
        if (param2VipProto.pageVersion_ != 0)
          setPageVersionValue(param2VipProto.getPageVersionValue()); 
        if (param2VipProto.identityType_ != 0)
          setIdentityTypeValue(param2VipProto.getIdentityTypeValue()); 
        if (param2VipProto.getIsBuySuccess())
          setIsBuySuccess(param2VipProto.getIsBuySuccess()); 
        if (param2VipProto.getIsOpen())
          setIsOpen(param2VipProto.getIsOpen()); 
        if (param2VipProto.pageLevel_ != 0)
          setPageLevelValue(param2VipProto.getPageLevelValue()); 
        if (param2VipProto.hideType_ != 0)
          setHideTypeValue(param2VipProto.getHideTypeValue()); 
        if (param2VipProto.getIsHideAll())
          setIsHideAll(param2VipProto.getIsHideAll()); 
        if (param2VipProto.getIsHideDistance())
          setIsHideDistance(param2VipProto.getIsHideDistance()); 
        if (param2VipProto.getIsHideRole())
          setIsHideRole(param2VipProto.getIsHideRole()); 
        if (param2VipProto.getIsHideAge())
          setIsHideAge(param2VipProto.getIsHideAge()); 
        if (!param2VipProto.getBannerUrl().isEmpty()) {
          this.bannerUrl_ = param2VipProto.bannerUrl_;
          onChanged();
        } 
        if (!param2VipProto.getPrivilegeId().isEmpty()) {
          this.privilegeId_ = param2VipProto.privilegeId_;
          onChanged();
        } 
        if (param2VipProto.btnType_ != 0)
          setBtnTypeValue(param2VipProto.getBtnTypeValue()); 
        if (!param2VipProto.getBannerId().isEmpty()) {
          this.bannerId_ = param2VipProto.bannerId_;
          onChanged();
        } 
        if (param2VipProto.orderType_ != 0)
          setOrderTypeValue(param2VipProto.getOrderTypeValue()); 
        if (param2VipProto.adPage_ != 0)
          setAdPageValue(param2VipProto.getAdPageValue()); 
        if (!param2VipProto.getAdType().isEmpty()) {
          this.adType_ = param2VipProto.adType_;
          onChanged();
        } 
        if (!param2VipProto.getLongitude().isEmpty()) {
          this.longitude_ = param2VipProto.longitude_;
          onChanged();
        } 
        if (!param2VipProto.getLatitude().isEmpty()) {
          this.latitude_ = param2VipProto.latitude_;
          onChanged();
        } 
        if (!param2VipProto.getImageId().isEmpty()) {
          this.imageId_ = param2VipProto.imageId_;
          onChanged();
        } 
        if (!param2VipProto.getThirdId().isEmpty()) {
          this.thirdId_ = param2VipProto.thirdId_;
          onChanged();
        } 
        if (param2VipProto.getIsShadow())
          setIsShadow(param2VipProto.getIsShadow()); 
        if (!param2VipProto.getId().isEmpty()) {
          this.id_ = param2VipProto.id_;
          onChanged();
        } 
        mergeUnknownFields(param2VipProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          VipProtos.VipProto vipProto = (VipProtos.VipProto)VipProtos.VipProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          VipProtos.VipProto vipProto = (VipProtos.VipProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((VipProtos.VipProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof VipProtos.VipProto)
          return mergeFrom((VipProtos.VipProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAdPage(VipProtos.AdPage param2AdPage) {
        if (param2AdPage != null) {
          this.adPage_ = param2AdPage.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAdPageValue(int param2Int) {
        this.adPage_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setAdType(String param2String) {
        if (param2String != null) {
          this.adType_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAdTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.adType_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
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
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.bannerId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBannerUrl(String param2String) {
        if (param2String != null) {
          this.bannerUrl_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBannerUrlBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.bannerUrl_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setBtnType(VipProtos.BtnType param2BtnType) {
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
      
      public Builder setEvent(VipProtos.Event param2Event) {
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
      
      public Builder setFrom(VipProtos.FromType param2FromType) {
        if (param2FromType != null) {
          this.from_ = param2FromType.getNumber();
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
      
      public Builder setHideType(VipProtos.HideType param2HideType) {
        if (param2HideType != null) {
          this.hideType_ = param2HideType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setHideTypeValue(int param2Int) {
        this.hideType_ = param2Int;
        onChanged();
        return this;
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
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.id_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdentityType(VipProtos.IdentityType param2IdentityType) {
        if (param2IdentityType != null) {
          this.identityType_ = param2IdentityType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdentityTypeValue(int param2Int) {
        this.identityType_ = param2Int;
        onChanged();
        return this;
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
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.imageId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIsBuySuccess(boolean param2Boolean) {
        this.isBuySuccess_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsHideAge(boolean param2Boolean) {
        this.isHideAge_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsHideAll(boolean param2Boolean) {
        this.isHideAll_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsHideDistance(boolean param2Boolean) {
        this.isHideDistance_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsHideRole(boolean param2Boolean) {
        this.isHideRole_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsOpen(boolean param2Boolean) {
        this.isOpen_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsRange(boolean param2Boolean) {
        this.isRange_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsShadow(boolean param2Boolean) {
        this.isShadow_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setLatitude(String param2String) {
        if (param2String != null) {
          this.latitude_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLatitudeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.latitude_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLongitude(String param2String) {
        if (param2String != null) {
          this.longitude_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLongitudeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.longitude_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setName(VipProtos.Name param2Name) {
        if (param2Name != null) {
          this.name_ = param2Name.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameValue(int param2Int) {
        this.name_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOrderType(VipProtos.OrderType param2OrderType) {
        if (param2OrderType != null) {
          this.orderType_ = param2OrderType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOrderTypeValue(int param2Int) {
        this.orderType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPageLevel(VipProtos.PageLevel param2PageLevel) {
        if (param2PageLevel != null) {
          this.pageLevel_ = param2PageLevel.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPageLevelValue(int param2Int) {
        this.pageLevel_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPageVersion(VipProtos.PageVersion param2PageVersion) {
        if (param2PageVersion != null) {
          this.pageVersion_ = param2PageVersion.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPageVersionValue(int param2Int) {
        this.pageVersion_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPrivilegeId(String param2String) {
        if (param2String != null) {
          this.privilegeId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPrivilegeIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.privilegeId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setStealthType(VipProtos.StealthType param2StealthType) {
        if (param2StealthType != null) {
          this.stealthType_ = param2StealthType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setStealthTypeValue(int param2Int) {
        this.stealthType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setThirdId(String param2String) {
        if (param2String != null) {
          this.thirdId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setThirdIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          VipProtos.VipProto.checkByteStringIsUtf8(param2ByteString);
          this.thirdId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setVocativeType(VipProtos.VocativeType param2VocativeType) {
        if (param2VocativeType != null) {
          this.vocativeType_ = param2VocativeType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setVocativeTypeValue(int param2Int) {
        this.vocativeType_ = param2Int;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<VipProto> {
    public VipProtos.VipProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new VipProtos.VipProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<VipProto.Builder> implements VipProtoOrBuilder {
    private int adPage_ = 0;
    
    private Object adType_ = "";
    
    private Object bannerId_ = "";
    
    private Object bannerUrl_ = "";
    
    private int btnType_ = 0;
    
    private int event_ = 0;
    
    private int from_ = 0;
    
    private int hideType_ = 0;
    
    private Object id_ = "";
    
    private int identityType_ = 0;
    
    private Object imageId_ = "";
    
    private boolean isBuySuccess_;
    
    private boolean isHideAge_;
    
    private boolean isHideAll_;
    
    private boolean isHideDistance_;
    
    private boolean isHideRole_;
    
    private boolean isOpen_;
    
    private boolean isRange_;
    
    private boolean isShadow_;
    
    private Object latitude_ = "";
    
    private Object longitude_ = "";
    
    private int name_ = 0;
    
    private int orderType_ = 0;
    
    private int pageLevel_ = 0;
    
    private int pageVersion_ = 0;
    
    private Object privilegeId_ = "";
    
    private int stealthType_ = 0;
    
    private Object thirdId_ = "";
    
    private int vocativeType_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      VipProtos.VipProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public VipProtos.VipProto build() {
      VipProtos.VipProto vipProto = buildPartial();
      if (vipProto.isInitialized())
        return vipProto; 
      throw newUninitializedMessageException(vipProto);
    }
    
    public VipProtos.VipProto buildPartial() {
      VipProtos.VipProto vipProto = new VipProtos.VipProto(this);
      VipProtos.VipProto.access$602(vipProto, this.event_);
      VipProtos.VipProto.access$702(vipProto, this.name_);
      VipProtos.VipProto.access$802(vipProto, this.from_);
      VipProtos.VipProto.access$902(vipProto, this.stealthType_);
      VipProtos.VipProto.access$1002(vipProto, this.isRange_);
      VipProtos.VipProto.access$1102(vipProto, this.vocativeType_);
      VipProtos.VipProto.access$1202(vipProto, this.pageVersion_);
      VipProtos.VipProto.access$1302(vipProto, this.identityType_);
      VipProtos.VipProto.access$1402(vipProto, this.isBuySuccess_);
      VipProtos.VipProto.access$1502(vipProto, this.isOpen_);
      VipProtos.VipProto.access$1602(vipProto, this.pageLevel_);
      VipProtos.VipProto.access$1702(vipProto, this.hideType_);
      VipProtos.VipProto.access$1802(vipProto, this.isHideAll_);
      VipProtos.VipProto.access$1902(vipProto, this.isHideDistance_);
      VipProtos.VipProto.access$2002(vipProto, this.isHideRole_);
      VipProtos.VipProto.access$2102(vipProto, this.isHideAge_);
      VipProtos.VipProto.access$2202(vipProto, this.bannerUrl_);
      VipProtos.VipProto.access$2302(vipProto, this.privilegeId_);
      VipProtos.VipProto.access$2402(vipProto, this.btnType_);
      VipProtos.VipProto.access$2502(vipProto, this.bannerId_);
      VipProtos.VipProto.access$2602(vipProto, this.orderType_);
      VipProtos.VipProto.access$2702(vipProto, this.adPage_);
      VipProtos.VipProto.access$2802(vipProto, this.adType_);
      VipProtos.VipProto.access$2902(vipProto, this.longitude_);
      VipProtos.VipProto.access$3002(vipProto, this.latitude_);
      VipProtos.VipProto.access$3102(vipProto, this.imageId_);
      VipProtos.VipProto.access$3202(vipProto, this.thirdId_);
      VipProtos.VipProto.access$3302(vipProto, this.isShadow_);
      VipProtos.VipProto.access$3402(vipProto, this.id_);
      onBuilt();
      return vipProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.name_ = 0;
      this.from_ = 0;
      this.stealthType_ = 0;
      this.isRange_ = false;
      this.vocativeType_ = 0;
      this.pageVersion_ = 0;
      this.identityType_ = 0;
      this.isBuySuccess_ = false;
      this.isOpen_ = false;
      this.pageLevel_ = 0;
      this.hideType_ = 0;
      this.isHideAll_ = false;
      this.isHideDistance_ = false;
      this.isHideRole_ = false;
      this.isHideAge_ = false;
      this.bannerUrl_ = "";
      this.privilegeId_ = "";
      this.btnType_ = 0;
      this.bannerId_ = "";
      this.orderType_ = 0;
      this.adPage_ = 0;
      this.adType_ = "";
      this.longitude_ = "";
      this.latitude_ = "";
      this.imageId_ = "";
      this.thirdId_ = "";
      this.isShadow_ = false;
      this.id_ = "";
      return this;
    }
    
    public Builder clearAdPage() {
      this.adPage_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearAdType() {
      this.adType_ = VipProtos.VipProto.getDefaultInstance().getAdType();
      onChanged();
      return this;
    }
    
    public Builder clearBannerId() {
      this.bannerId_ = VipProtos.VipProto.getDefaultInstance().getBannerId();
      onChanged();
      return this;
    }
    
    public Builder clearBannerUrl() {
      this.bannerUrl_ = VipProtos.VipProto.getDefaultInstance().getBannerUrl();
      onChanged();
      return this;
    }
    
    public Builder clearBtnType() {
      this.btnType_ = 0;
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
    
    public Builder clearHideType() {
      this.hideType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearId() {
      this.id_ = VipProtos.VipProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearIdentityType() {
      this.identityType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearImageId() {
      this.imageId_ = VipProtos.VipProto.getDefaultInstance().getImageId();
      onChanged();
      return this;
    }
    
    public Builder clearIsBuySuccess() {
      this.isBuySuccess_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsHideAge() {
      this.isHideAge_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsHideAll() {
      this.isHideAll_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsHideDistance() {
      this.isHideDistance_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsHideRole() {
      this.isHideRole_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsOpen() {
      this.isOpen_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsRange() {
      this.isRange_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsShadow() {
      this.isShadow_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearLatitude() {
      this.latitude_ = VipProtos.VipProto.getDefaultInstance().getLatitude();
      onChanged();
      return this;
    }
    
    public Builder clearLongitude() {
      this.longitude_ = VipProtos.VipProto.getDefaultInstance().getLongitude();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOrderType() {
      this.orderType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPageLevel() {
      this.pageLevel_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPageVersion() {
      this.pageVersion_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearPrivilegeId() {
      this.privilegeId_ = VipProtos.VipProto.getDefaultInstance().getPrivilegeId();
      onChanged();
      return this;
    }
    
    public Builder clearStealthType() {
      this.stealthType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearThirdId() {
      this.thirdId_ = VipProtos.VipProto.getDefaultInstance().getThirdId();
      onChanged();
      return this;
    }
    
    public Builder clearVocativeType() {
      this.vocativeType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public VipProtos.AdPage getAdPage() {
      VipProtos.AdPage adPage2 = VipProtos.AdPage.valueOf(this.adPage_);
      VipProtos.AdPage adPage1 = adPage2;
      if (adPage2 == null)
        adPage1 = VipProtos.AdPage.UNRECOGNIZED; 
      return adPage1;
    }
    
    public int getAdPageValue() {
      return this.adPage_;
    }
    
    public String getAdType() {
      Object object = this.adType_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.adType_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAdTypeBytes() {
      Object object = this.adType_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.adType_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public String getBannerUrl() {
      Object object = this.bannerUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.bannerUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getBannerUrlBytes() {
      Object object = this.bannerUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.bannerUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VipProtos.BtnType getBtnType() {
      VipProtos.BtnType btnType2 = VipProtos.BtnType.valueOf(this.btnType_);
      VipProtos.BtnType btnType1 = btnType2;
      if (btnType2 == null)
        btnType1 = VipProtos.BtnType.UNRECOGNIZED; 
      return btnType1;
    }
    
    public int getBtnTypeValue() {
      return this.btnType_;
    }
    
    public VipProtos.VipProto getDefaultInstanceForType() {
      return VipProtos.VipProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return VipProtos.internal_static_com_blued_das_vip_VipProto_descriptor;
    }
    
    public VipProtos.Event getEvent() {
      VipProtos.Event event2 = VipProtos.Event.valueOf(this.event_);
      VipProtos.Event event1 = event2;
      if (event2 == null)
        event1 = VipProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public VipProtos.FromType getFrom() {
      VipProtos.FromType fromType2 = VipProtos.FromType.valueOf(this.from_);
      VipProtos.FromType fromType1 = fromType2;
      if (fromType2 == null)
        fromType1 = VipProtos.FromType.UNRECOGNIZED; 
      return fromType1;
    }
    
    public int getFromValue() {
      return this.from_;
    }
    
    public VipProtos.HideType getHideType() {
      VipProtos.HideType hideType2 = VipProtos.HideType.valueOf(this.hideType_);
      VipProtos.HideType hideType1 = hideType2;
      if (hideType2 == null)
        hideType1 = VipProtos.HideType.UNRECOGNIZED; 
      return hideType1;
    }
    
    public int getHideTypeValue() {
      return this.hideType_;
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
    
    public VipProtos.IdentityType getIdentityType() {
      VipProtos.IdentityType identityType2 = VipProtos.IdentityType.valueOf(this.identityType_);
      VipProtos.IdentityType identityType1 = identityType2;
      if (identityType2 == null)
        identityType1 = VipProtos.IdentityType.UNRECOGNIZED; 
      return identityType1;
    }
    
    public int getIdentityTypeValue() {
      return this.identityType_;
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
    
    public boolean getIsBuySuccess() {
      return this.isBuySuccess_;
    }
    
    public boolean getIsHideAge() {
      return this.isHideAge_;
    }
    
    public boolean getIsHideAll() {
      return this.isHideAll_;
    }
    
    public boolean getIsHideDistance() {
      return this.isHideDistance_;
    }
    
    public boolean getIsHideRole() {
      return this.isHideRole_;
    }
    
    public boolean getIsOpen() {
      return this.isOpen_;
    }
    
    public boolean getIsRange() {
      return this.isRange_;
    }
    
    public boolean getIsShadow() {
      return this.isShadow_;
    }
    
    public String getLatitude() {
      Object object = this.latitude_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.latitude_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLatitudeBytes() {
      Object object = this.latitude_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.latitude_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLongitude() {
      Object object = this.longitude_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.longitude_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLongitudeBytes() {
      Object object = this.longitude_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.longitude_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VipProtos.Name getName() {
      VipProtos.Name name2 = VipProtos.Name.valueOf(this.name_);
      VipProtos.Name name1 = name2;
      if (name2 == null)
        name1 = VipProtos.Name.UNRECOGNIZED; 
      return name1;
    }
    
    public int getNameValue() {
      return this.name_;
    }
    
    public VipProtos.OrderType getOrderType() {
      VipProtos.OrderType orderType2 = VipProtos.OrderType.valueOf(this.orderType_);
      VipProtos.OrderType orderType1 = orderType2;
      if (orderType2 == null)
        orderType1 = VipProtos.OrderType.UNRECOGNIZED; 
      return orderType1;
    }
    
    public int getOrderTypeValue() {
      return this.orderType_;
    }
    
    public VipProtos.PageLevel getPageLevel() {
      VipProtos.PageLevel pageLevel2 = VipProtos.PageLevel.valueOf(this.pageLevel_);
      VipProtos.PageLevel pageLevel1 = pageLevel2;
      if (pageLevel2 == null)
        pageLevel1 = VipProtos.PageLevel.UNRECOGNIZED; 
      return pageLevel1;
    }
    
    public int getPageLevelValue() {
      return this.pageLevel_;
    }
    
    public VipProtos.PageVersion getPageVersion() {
      VipProtos.PageVersion pageVersion2 = VipProtos.PageVersion.valueOf(this.pageVersion_);
      VipProtos.PageVersion pageVersion1 = pageVersion2;
      if (pageVersion2 == null)
        pageVersion1 = VipProtos.PageVersion.UNRECOGNIZED; 
      return pageVersion1;
    }
    
    public int getPageVersionValue() {
      return this.pageVersion_;
    }
    
    public String getPrivilegeId() {
      Object object = this.privilegeId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.privilegeId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPrivilegeIdBytes() {
      Object object = this.privilegeId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.privilegeId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VipProtos.StealthType getStealthType() {
      VipProtos.StealthType stealthType2 = VipProtos.StealthType.valueOf(this.stealthType_);
      VipProtos.StealthType stealthType1 = stealthType2;
      if (stealthType2 == null)
        stealthType1 = VipProtos.StealthType.UNRECOGNIZED; 
      return stealthType1;
    }
    
    public int getStealthTypeValue() {
      return this.stealthType_;
    }
    
    public String getThirdId() {
      Object object = this.thirdId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.thirdId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getThirdIdBytes() {
      Object object = this.thirdId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.thirdId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public VipProtos.VocativeType getVocativeType() {
      VipProtos.VocativeType vocativeType2 = VipProtos.VocativeType.valueOf(this.vocativeType_);
      VipProtos.VocativeType vocativeType1 = vocativeType2;
      if (vocativeType2 == null)
        vocativeType1 = VipProtos.VocativeType.UNRECOGNIZED; 
      return vocativeType1;
    }
    
    public int getVocativeTypeValue() {
      return this.vocativeType_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return VipProtos.internal_static_com_blued_das_vip_VipProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VipProtos.VipProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(VipProtos.VipProto param1VipProto) {
      if (param1VipProto == VipProtos.VipProto.getDefaultInstance())
        return this; 
      if (param1VipProto.event_ != 0)
        setEventValue(param1VipProto.getEventValue()); 
      if (param1VipProto.name_ != 0)
        setNameValue(param1VipProto.getNameValue()); 
      if (param1VipProto.from_ != 0)
        setFromValue(param1VipProto.getFromValue()); 
      if (param1VipProto.stealthType_ != 0)
        setStealthTypeValue(param1VipProto.getStealthTypeValue()); 
      if (param1VipProto.getIsRange())
        setIsRange(param1VipProto.getIsRange()); 
      if (param1VipProto.vocativeType_ != 0)
        setVocativeTypeValue(param1VipProto.getVocativeTypeValue()); 
      if (param1VipProto.pageVersion_ != 0)
        setPageVersionValue(param1VipProto.getPageVersionValue()); 
      if (param1VipProto.identityType_ != 0)
        setIdentityTypeValue(param1VipProto.getIdentityTypeValue()); 
      if (param1VipProto.getIsBuySuccess())
        setIsBuySuccess(param1VipProto.getIsBuySuccess()); 
      if (param1VipProto.getIsOpen())
        setIsOpen(param1VipProto.getIsOpen()); 
      if (param1VipProto.pageLevel_ != 0)
        setPageLevelValue(param1VipProto.getPageLevelValue()); 
      if (param1VipProto.hideType_ != 0)
        setHideTypeValue(param1VipProto.getHideTypeValue()); 
      if (param1VipProto.getIsHideAll())
        setIsHideAll(param1VipProto.getIsHideAll()); 
      if (param1VipProto.getIsHideDistance())
        setIsHideDistance(param1VipProto.getIsHideDistance()); 
      if (param1VipProto.getIsHideRole())
        setIsHideRole(param1VipProto.getIsHideRole()); 
      if (param1VipProto.getIsHideAge())
        setIsHideAge(param1VipProto.getIsHideAge()); 
      if (!param1VipProto.getBannerUrl().isEmpty()) {
        this.bannerUrl_ = param1VipProto.bannerUrl_;
        onChanged();
      } 
      if (!param1VipProto.getPrivilegeId().isEmpty()) {
        this.privilegeId_ = param1VipProto.privilegeId_;
        onChanged();
      } 
      if (param1VipProto.btnType_ != 0)
        setBtnTypeValue(param1VipProto.getBtnTypeValue()); 
      if (!param1VipProto.getBannerId().isEmpty()) {
        this.bannerId_ = param1VipProto.bannerId_;
        onChanged();
      } 
      if (param1VipProto.orderType_ != 0)
        setOrderTypeValue(param1VipProto.getOrderTypeValue()); 
      if (param1VipProto.adPage_ != 0)
        setAdPageValue(param1VipProto.getAdPageValue()); 
      if (!param1VipProto.getAdType().isEmpty()) {
        this.adType_ = param1VipProto.adType_;
        onChanged();
      } 
      if (!param1VipProto.getLongitude().isEmpty()) {
        this.longitude_ = param1VipProto.longitude_;
        onChanged();
      } 
      if (!param1VipProto.getLatitude().isEmpty()) {
        this.latitude_ = param1VipProto.latitude_;
        onChanged();
      } 
      if (!param1VipProto.getImageId().isEmpty()) {
        this.imageId_ = param1VipProto.imageId_;
        onChanged();
      } 
      if (!param1VipProto.getThirdId().isEmpty()) {
        this.thirdId_ = param1VipProto.thirdId_;
        onChanged();
      } 
      if (param1VipProto.getIsShadow())
        setIsShadow(param1VipProto.getIsShadow()); 
      if (!param1VipProto.getId().isEmpty()) {
        this.id_ = param1VipProto.id_;
        onChanged();
      } 
      mergeUnknownFields(param1VipProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        VipProtos.VipProto vipProto = (VipProtos.VipProto)VipProtos.VipProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        VipProtos.VipProto vipProto = (VipProtos.VipProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((VipProtos.VipProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof VipProtos.VipProto)
        return mergeFrom((VipProtos.VipProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAdPage(VipProtos.AdPage param1AdPage) {
      if (param1AdPage != null) {
        this.adPage_ = param1AdPage.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAdPageValue(int param1Int) {
      this.adPage_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setAdType(String param1String) {
      if (param1String != null) {
        this.adType_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAdTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.adType_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
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
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.bannerId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBannerUrl(String param1String) {
      if (param1String != null) {
        this.bannerUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBannerUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.bannerUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setBtnType(VipProtos.BtnType param1BtnType) {
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
    
    public Builder setEvent(VipProtos.Event param1Event) {
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
    
    public Builder setFrom(VipProtos.FromType param1FromType) {
      if (param1FromType != null) {
        this.from_ = param1FromType.getNumber();
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
    
    public Builder setHideType(VipProtos.HideType param1HideType) {
      if (param1HideType != null) {
        this.hideType_ = param1HideType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setHideTypeValue(int param1Int) {
      this.hideType_ = param1Int;
      onChanged();
      return this;
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
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdentityType(VipProtos.IdentityType param1IdentityType) {
      if (param1IdentityType != null) {
        this.identityType_ = param1IdentityType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdentityTypeValue(int param1Int) {
      this.identityType_ = param1Int;
      onChanged();
      return this;
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
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.imageId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIsBuySuccess(boolean param1Boolean) {
      this.isBuySuccess_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsHideAge(boolean param1Boolean) {
      this.isHideAge_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsHideAll(boolean param1Boolean) {
      this.isHideAll_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsHideDistance(boolean param1Boolean) {
      this.isHideDistance_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsHideRole(boolean param1Boolean) {
      this.isHideRole_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsOpen(boolean param1Boolean) {
      this.isOpen_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsRange(boolean param1Boolean) {
      this.isRange_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsShadow(boolean param1Boolean) {
      this.isShadow_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setLatitude(String param1String) {
      if (param1String != null) {
        this.latitude_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLatitudeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.latitude_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLongitude(String param1String) {
      if (param1String != null) {
        this.longitude_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLongitudeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.longitude_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setName(VipProtos.Name param1Name) {
      if (param1Name != null) {
        this.name_ = param1Name.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameValue(int param1Int) {
      this.name_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOrderType(VipProtos.OrderType param1OrderType) {
      if (param1OrderType != null) {
        this.orderType_ = param1OrderType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOrderTypeValue(int param1Int) {
      this.orderType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPageLevel(VipProtos.PageLevel param1PageLevel) {
      if (param1PageLevel != null) {
        this.pageLevel_ = param1PageLevel.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPageLevelValue(int param1Int) {
      this.pageLevel_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPageVersion(VipProtos.PageVersion param1PageVersion) {
      if (param1PageVersion != null) {
        this.pageVersion_ = param1PageVersion.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPageVersionValue(int param1Int) {
      this.pageVersion_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPrivilegeId(String param1String) {
      if (param1String != null) {
        this.privilegeId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPrivilegeIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.privilegeId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setStealthType(VipProtos.StealthType param1StealthType) {
      if (param1StealthType != null) {
        this.stealthType_ = param1StealthType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setStealthTypeValue(int param1Int) {
      this.stealthType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setThirdId(String param1String) {
      if (param1String != null) {
        this.thirdId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setThirdIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        VipProtos.VipProto.checkByteStringIsUtf8(param1ByteString);
        this.thirdId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setVocativeType(VipProtos.VocativeType param1VocativeType) {
      if (param1VocativeType != null) {
        this.vocativeType_ = param1VocativeType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setVocativeTypeValue(int param1Int) {
      this.vocativeType_ = param1Int;
      onChanged();
      return this;
    }
  }
  
  public static interface VipProtoOrBuilder extends MessageOrBuilder {
    VipProtos.AdPage getAdPage();
    
    int getAdPageValue();
    
    String getAdType();
    
    ByteString getAdTypeBytes();
    
    String getBannerId();
    
    ByteString getBannerIdBytes();
    
    String getBannerUrl();
    
    ByteString getBannerUrlBytes();
    
    VipProtos.BtnType getBtnType();
    
    int getBtnTypeValue();
    
    VipProtos.Event getEvent();
    
    int getEventValue();
    
    VipProtos.FromType getFrom();
    
    int getFromValue();
    
    VipProtos.HideType getHideType();
    
    int getHideTypeValue();
    
    String getId();
    
    ByteString getIdBytes();
    
    VipProtos.IdentityType getIdentityType();
    
    int getIdentityTypeValue();
    
    String getImageId();
    
    ByteString getImageIdBytes();
    
    boolean getIsBuySuccess();
    
    boolean getIsHideAge();
    
    boolean getIsHideAll();
    
    boolean getIsHideDistance();
    
    boolean getIsHideRole();
    
    boolean getIsOpen();
    
    boolean getIsRange();
    
    boolean getIsShadow();
    
    String getLatitude();
    
    ByteString getLatitudeBytes();
    
    String getLongitude();
    
    ByteString getLongitudeBytes();
    
    VipProtos.Name getName();
    
    int getNameValue();
    
    VipProtos.OrderType getOrderType();
    
    int getOrderTypeValue();
    
    VipProtos.PageLevel getPageLevel();
    
    int getPageLevelValue();
    
    VipProtos.PageVersion getPageVersion();
    
    int getPageVersionValue();
    
    String getPrivilegeId();
    
    ByteString getPrivilegeIdBytes();
    
    VipProtos.StealthType getStealthType();
    
    int getStealthTypeValue();
    
    String getThirdId();
    
    ByteString getThirdIdBytes();
    
    VipProtos.VocativeType getVocativeType();
    
    int getVocativeTypeValue();
  }
  
  public enum VocativeType implements ProtocolMessageEnum {
    UNKNOWN_VOCATIVE_TYPE(0),
    UNRECOGNIZED(0),
    HAVE_TIMES(1),
    NO_TIMES(1);
    
    public static final int HAVE_TIMES_VALUE = 2;
    
    public static final int NO_TIMES_VALUE = 1;
    
    public static final int UNKNOWN_VOCATIVE_TYPE_VALUE = 0;
    
    private static final VocativeType[] VALUES;
    
    private static final Internal.EnumLiteMap<VocativeType> internalValueMap;
    
    private final int value;
    
    static {
      HAVE_TIMES = new VocativeType("HAVE_TIMES", 2, 2);
      UNRECOGNIZED = new VocativeType("UNRECOGNIZED", 3, -1);
      $VALUES = new VocativeType[] { UNKNOWN_VOCATIVE_TYPE, NO_TIMES, HAVE_TIMES, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<VocativeType>() {
          public VipProtos.VocativeType findValueByNumber(int param2Int) {
            return VipProtos.VocativeType.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    VocativeType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static VocativeType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : HAVE_TIMES) : NO_TIMES) : UNKNOWN_VOCATIVE_TYPE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return VipProtos.getDescriptor().getEnumTypes().get(5);
    }
    
    public static Internal.EnumLiteMap<VocativeType> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<VocativeType> {
    public VipProtos.VocativeType findValueByNumber(int param1Int) {
      return VipProtos.VocativeType.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\vip\VipProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
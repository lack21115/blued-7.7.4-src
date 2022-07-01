package com.blued.im.private_chat;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class CodeOuterClass {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\nCode.proto\022\031com.blued.im.private_chat*ð\003\n\004Code\022\023\n\017PRIVATE_SUCCESS\020\000\022 \n\034PRIVATE_ERROR_PROTOCOL_ERROR\020\001\022\037\n\033PRIVATE_ERROR_CONTENT_EMPTY\020\002\022!\n\035PRIVATE_ERROR_CONTENT_ILLEGAL\020\003\022 \n\034PRIVATE_ERROR_USER_FORBIDDEN\020\004\022\"\n\036PRIVATE_ERROR_IN_HIS_BLACKLIST\020\005\022!\n\035PRIVATE_ERROR_IN_MY_BLACKLIST\020\006\022\032\n\026PRIVATE_ERROR_TOO_FAST\020\007\022!\n\035PRIVATE_ERROR_ACOUNT_NOT_AUTH\020\b\022#\n\037PRIVATE_ERROR_NOT_EACH_FOLLOWED\020\t\022 \n\034PRIVATE_ERROR_FORBIDEDTOTALK\020\n\022\034\n\030PRIVATE_ERROR_BIND_PHONE\020\013\022\035\n\031PRIVATE_ERROR_NOT_DISTRUB\020\f\022!\n\035PRIVATE_ERROR_DELETE_OUT_TIME\020\r\022\036\n\032PRIVATE_ERROR_NOT_IN_GROUP\020\016B\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Code implements ProtocolMessageEnum {
    PRIVATE_ERROR_ACOUNT_NOT_AUTH,
    PRIVATE_ERROR_BIND_PHONE,
    PRIVATE_ERROR_CONTENT_EMPTY,
    PRIVATE_ERROR_CONTENT_ILLEGAL,
    PRIVATE_ERROR_DELETE_OUT_TIME,
    PRIVATE_ERROR_FORBIDEDTOTALK,
    PRIVATE_ERROR_IN_HIS_BLACKLIST,
    PRIVATE_ERROR_IN_MY_BLACKLIST,
    PRIVATE_ERROR_NOT_DISTRUB,
    PRIVATE_ERROR_NOT_EACH_FOLLOWED,
    PRIVATE_ERROR_NOT_IN_GROUP,
    PRIVATE_ERROR_PROTOCOL_ERROR,
    PRIVATE_ERROR_TOO_FAST,
    PRIVATE_ERROR_USER_FORBIDDEN,
    PRIVATE_SUCCESS(0),
    UNRECOGNIZED(0);
    
    public static final int PRIVATE_ERROR_ACOUNT_NOT_AUTH_VALUE = 8;
    
    public static final int PRIVATE_ERROR_BIND_PHONE_VALUE = 11;
    
    public static final int PRIVATE_ERROR_CONTENT_EMPTY_VALUE = 2;
    
    public static final int PRIVATE_ERROR_CONTENT_ILLEGAL_VALUE = 3;
    
    public static final int PRIVATE_ERROR_DELETE_OUT_TIME_VALUE = 13;
    
    public static final int PRIVATE_ERROR_FORBIDEDTOTALK_VALUE = 10;
    
    public static final int PRIVATE_ERROR_IN_HIS_BLACKLIST_VALUE = 5;
    
    public static final int PRIVATE_ERROR_IN_MY_BLACKLIST_VALUE = 6;
    
    public static final int PRIVATE_ERROR_NOT_DISTRUB_VALUE = 12;
    
    public static final int PRIVATE_ERROR_NOT_EACH_FOLLOWED_VALUE = 9;
    
    public static final int PRIVATE_ERROR_NOT_IN_GROUP_VALUE = 14;
    
    public static final int PRIVATE_ERROR_PROTOCOL_ERROR_VALUE = 1;
    
    public static final int PRIVATE_ERROR_TOO_FAST_VALUE = 7;
    
    public static final int PRIVATE_ERROR_USER_FORBIDDEN_VALUE = 4;
    
    public static final int PRIVATE_SUCCESS_VALUE = 0;
    
    private static final Code[] VALUES;
    
    private static final Internal.EnumLiteMap<Code> internalValueMap;
    
    private final int value;
    
    static {
      PRIVATE_ERROR_CONTENT_EMPTY = new Code("PRIVATE_ERROR_CONTENT_EMPTY", 2, 2);
      PRIVATE_ERROR_CONTENT_ILLEGAL = new Code("PRIVATE_ERROR_CONTENT_ILLEGAL", 3, 3);
      PRIVATE_ERROR_USER_FORBIDDEN = new Code("PRIVATE_ERROR_USER_FORBIDDEN", 4, 4);
      PRIVATE_ERROR_IN_HIS_BLACKLIST = new Code("PRIVATE_ERROR_IN_HIS_BLACKLIST", 5, 5);
      PRIVATE_ERROR_IN_MY_BLACKLIST = new Code("PRIVATE_ERROR_IN_MY_BLACKLIST", 6, 6);
      PRIVATE_ERROR_TOO_FAST = new Code("PRIVATE_ERROR_TOO_FAST", 7, 7);
      PRIVATE_ERROR_ACOUNT_NOT_AUTH = new Code("PRIVATE_ERROR_ACOUNT_NOT_AUTH", 8, 8);
      PRIVATE_ERROR_NOT_EACH_FOLLOWED = new Code("PRIVATE_ERROR_NOT_EACH_FOLLOWED", 9, 9);
      PRIVATE_ERROR_FORBIDEDTOTALK = new Code("PRIVATE_ERROR_FORBIDEDTOTALK", 10, 10);
      PRIVATE_ERROR_BIND_PHONE = new Code("PRIVATE_ERROR_BIND_PHONE", 11, 11);
      PRIVATE_ERROR_NOT_DISTRUB = new Code("PRIVATE_ERROR_NOT_DISTRUB", 12, 12);
      PRIVATE_ERROR_DELETE_OUT_TIME = new Code("PRIVATE_ERROR_DELETE_OUT_TIME", 13, 13);
      PRIVATE_ERROR_NOT_IN_GROUP = new Code("PRIVATE_ERROR_NOT_IN_GROUP", 14, 14);
      UNRECOGNIZED = new Code("UNRECOGNIZED", 15, -1);
      $VALUES = new Code[] { 
          PRIVATE_SUCCESS, PRIVATE_ERROR_PROTOCOL_ERROR, PRIVATE_ERROR_CONTENT_EMPTY, PRIVATE_ERROR_CONTENT_ILLEGAL, PRIVATE_ERROR_USER_FORBIDDEN, PRIVATE_ERROR_IN_HIS_BLACKLIST, PRIVATE_ERROR_IN_MY_BLACKLIST, PRIVATE_ERROR_TOO_FAST, PRIVATE_ERROR_ACOUNT_NOT_AUTH, PRIVATE_ERROR_NOT_EACH_FOLLOWED, 
          PRIVATE_ERROR_FORBIDEDTOTALK, PRIVATE_ERROR_BIND_PHONE, PRIVATE_ERROR_NOT_DISTRUB, PRIVATE_ERROR_DELETE_OUT_TIME, PRIVATE_ERROR_NOT_IN_GROUP, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Code>() {
          public CodeOuterClass.Code findValueByNumber(int param2Int) {
            return CodeOuterClass.Code.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Code(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Code forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 14:
          return PRIVATE_ERROR_NOT_IN_GROUP;
        case 13:
          return PRIVATE_ERROR_DELETE_OUT_TIME;
        case 12:
          return PRIVATE_ERROR_NOT_DISTRUB;
        case 11:
          return PRIVATE_ERROR_BIND_PHONE;
        case 10:
          return PRIVATE_ERROR_FORBIDEDTOTALK;
        case 9:
          return PRIVATE_ERROR_NOT_EACH_FOLLOWED;
        case 8:
          return PRIVATE_ERROR_ACOUNT_NOT_AUTH;
        case 7:
          return PRIVATE_ERROR_TOO_FAST;
        case 6:
          return PRIVATE_ERROR_IN_MY_BLACKLIST;
        case 5:
          return PRIVATE_ERROR_IN_HIS_BLACKLIST;
        case 4:
          return PRIVATE_ERROR_USER_FORBIDDEN;
        case 3:
          return PRIVATE_ERROR_CONTENT_ILLEGAL;
        case 2:
          return PRIVATE_ERROR_CONTENT_EMPTY;
        case 1:
          return PRIVATE_ERROR_PROTOCOL_ERROR;
        case 0:
          break;
      } 
      return PRIVATE_SUCCESS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return CodeOuterClass.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<Code> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<Code> {
    public CodeOuterClass.Code findValueByNumber(int param1Int) {
      return CodeOuterClass.Code.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\CodeOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
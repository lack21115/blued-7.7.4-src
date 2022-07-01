package com.blued.im.audio_chatroom;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class AudioCode {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\017AudioCode.proto\022\033com.blued.im.audio_chatroom*Â\001\n\004Code\022\026\n\022AUDIO_SEND_SUCCESS\020\000\022#\n\037AUDIO_SEND_ERROR_PROTOCOL_ERROR\020\001\022\031\n\025AUDIO_SEND_USER_ERROR\020\002\022\"\n\036AUDIO_SEND_ERROR_CONTENT_EMPTY\020\003\022$\n AUDIO_SEND_ERROR_CONTENT_ILLEGAL\020\004\022\030\n\024AUDIO_SEND_USER_MUTE\020\005B\020¢\002\rAudioChatroomb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Code implements ProtocolMessageEnum {
    AUDIO_SEND_ERROR_CONTENT_EMPTY,
    AUDIO_SEND_ERROR_CONTENT_ILLEGAL,
    AUDIO_SEND_ERROR_PROTOCOL_ERROR,
    AUDIO_SEND_SUCCESS(0),
    AUDIO_SEND_USER_ERROR(0),
    AUDIO_SEND_USER_MUTE(0),
    UNRECOGNIZED(0);
    
    public static final int AUDIO_SEND_ERROR_CONTENT_EMPTY_VALUE = 3;
    
    public static final int AUDIO_SEND_ERROR_CONTENT_ILLEGAL_VALUE = 4;
    
    public static final int AUDIO_SEND_ERROR_PROTOCOL_ERROR_VALUE = 1;
    
    public static final int AUDIO_SEND_SUCCESS_VALUE = 0;
    
    public static final int AUDIO_SEND_USER_ERROR_VALUE = 2;
    
    public static final int AUDIO_SEND_USER_MUTE_VALUE = 5;
    
    private static final Code[] VALUES;
    
    private static final Internal.EnumLiteMap<Code> internalValueMap;
    
    private final int value;
    
    static {
      AUDIO_SEND_ERROR_CONTENT_EMPTY = new Code("AUDIO_SEND_ERROR_CONTENT_EMPTY", 3, 3);
      AUDIO_SEND_ERROR_CONTENT_ILLEGAL = new Code("AUDIO_SEND_ERROR_CONTENT_ILLEGAL", 4, 4);
      AUDIO_SEND_USER_MUTE = new Code("AUDIO_SEND_USER_MUTE", 5, 5);
      UNRECOGNIZED = new Code("UNRECOGNIZED", 6, -1);
      $VALUES = new Code[] { AUDIO_SEND_SUCCESS, AUDIO_SEND_ERROR_PROTOCOL_ERROR, AUDIO_SEND_USER_ERROR, AUDIO_SEND_ERROR_CONTENT_EMPTY, AUDIO_SEND_ERROR_CONTENT_ILLEGAL, AUDIO_SEND_USER_MUTE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Code>() {
          public AudioCode.Code findValueByNumber(int param2Int) {
            return AudioCode.Code.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Code(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Code forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : AUDIO_SEND_USER_MUTE) : AUDIO_SEND_ERROR_CONTENT_ILLEGAL) : AUDIO_SEND_ERROR_CONTENT_EMPTY) : AUDIO_SEND_USER_ERROR) : AUDIO_SEND_ERROR_PROTOCOL_ERROR) : AUDIO_SEND_SUCCESS;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return AudioCode.getDescriptor().getEnumTypes().get(0);
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
    public AudioCode.Code findValueByNumber(int param1Int) {
      return AudioCode.Code.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\audio_chatroom\AudioCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
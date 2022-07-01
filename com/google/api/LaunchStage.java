package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum LaunchStage implements ProtocolMessageEnum {
  ALPHA,
  BETA,
  DEPRECATED,
  EARLY_ACCESS,
  GA,
  LAUNCH_STAGE_UNSPECIFIED(0),
  UNRECOGNIZED(0);
  
  public static final int ALPHA_VALUE = 2;
  
  public static final int BETA_VALUE = 3;
  
  public static final int DEPRECATED_VALUE = 5;
  
  public static final int EARLY_ACCESS_VALUE = 1;
  
  public static final int GA_VALUE = 4;
  
  public static final int LAUNCH_STAGE_UNSPECIFIED_VALUE = 0;
  
  private static final LaunchStage[] VALUES;
  
  private static final Internal.EnumLiteMap<LaunchStage> internalValueMap;
  
  private final int value;
  
  static {
    EARLY_ACCESS = new LaunchStage("EARLY_ACCESS", 1, 1);
    ALPHA = new LaunchStage("ALPHA", 2, 2);
    BETA = new LaunchStage("BETA", 3, 3);
    GA = new LaunchStage("GA", 4, 4);
    DEPRECATED = new LaunchStage("DEPRECATED", 5, 5);
    UNRECOGNIZED = new LaunchStage("UNRECOGNIZED", 6, -1);
    $VALUES = new LaunchStage[] { LAUNCH_STAGE_UNSPECIFIED, EARLY_ACCESS, ALPHA, BETA, GA, DEPRECATED, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<LaunchStage>() {
        public LaunchStage a(int param1Int) {
          return LaunchStage.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  LaunchStage(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static LaunchStage forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 5) ? null : DEPRECATED) : GA) : BETA) : ALPHA) : EARLY_ACCESS) : LAUNCH_STAGE_UNSPECIFIED;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return LaunchStageProto.a().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<LaunchStage> internalGetValueMap() {
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
    return getDescriptor().getValues().get(ordinal());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LaunchStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
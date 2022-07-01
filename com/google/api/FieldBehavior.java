package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum FieldBehavior implements ProtocolMessageEnum {
  FIELD_BEHAVIOR_UNSPECIFIED(0),
  IMMUTABLE(0),
  INPUT_ONLY(0),
  OPTIONAL(1),
  OUTPUT_ONLY(1),
  REQUIRED(2),
  UNRECOGNIZED(2);
  
  public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
  
  public static final int IMMUTABLE_VALUE = 5;
  
  public static final int INPUT_ONLY_VALUE = 4;
  
  public static final int OPTIONAL_VALUE = 1;
  
  public static final int OUTPUT_ONLY_VALUE = 3;
  
  public static final int REQUIRED_VALUE = 2;
  
  private static final FieldBehavior[] VALUES;
  
  private static final Internal.EnumLiteMap<FieldBehavior> internalValueMap;
  
  private final int value;
  
  static {
    OUTPUT_ONLY = new FieldBehavior("OUTPUT_ONLY", 3, 3);
    INPUT_ONLY = new FieldBehavior("INPUT_ONLY", 4, 4);
    IMMUTABLE = new FieldBehavior("IMMUTABLE", 5, 5);
    UNRECOGNIZED = new FieldBehavior("UNRECOGNIZED", 6, -1);
    $VALUES = new FieldBehavior[] { FIELD_BEHAVIOR_UNSPECIFIED, OPTIONAL, REQUIRED, OUTPUT_ONLY, INPUT_ONLY, IMMUTABLE, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<FieldBehavior>() {
        public FieldBehavior a(int param1Int) {
          return FieldBehavior.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  FieldBehavior(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static FieldBehavior forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 5) ? null : IMMUTABLE) : INPUT_ONLY) : OUTPUT_ONLY) : REQUIRED) : OPTIONAL) : FIELD_BEHAVIOR_UNSPECIFIED;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return FieldBehaviorProto.a().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<FieldBehavior> internalGetValueMap() {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\FieldBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
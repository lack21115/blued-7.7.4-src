package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum ChangeType implements ProtocolMessageEnum {
  ADDED,
  CHANGE_TYPE_UNSPECIFIED(0),
  MODIFIED(0),
  REMOVED(0),
  UNRECOGNIZED(0);
  
  public static final int ADDED_VALUE = 1;
  
  public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
  
  public static final int MODIFIED_VALUE = 3;
  
  public static final int REMOVED_VALUE = 2;
  
  private static final ChangeType[] VALUES;
  
  private static final Internal.EnumLiteMap<ChangeType> internalValueMap;
  
  private final int value;
  
  static {
    ADDED = new ChangeType("ADDED", 1, 1);
    REMOVED = new ChangeType("REMOVED", 2, 2);
    MODIFIED = new ChangeType("MODIFIED", 3, 3);
    UNRECOGNIZED = new ChangeType("UNRECOGNIZED", 4, -1);
    $VALUES = new ChangeType[] { CHANGE_TYPE_UNSPECIFIED, ADDED, REMOVED, MODIFIED, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<ChangeType>() {
        public ChangeType a(int param1Int) {
          return ChangeType.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  ChangeType(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static ChangeType forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? null : MODIFIED) : REMOVED) : ADDED) : CHANGE_TYPE_UNSPECIFIED;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return ConfigChangeProto.a().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ChangeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
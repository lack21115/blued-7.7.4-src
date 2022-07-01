package com.google.protobuf;

public enum Syntax implements ProtocolMessageEnum {
  SYNTAX_PROTO2(0),
  SYNTAX_PROTO3(1),
  UNRECOGNIZED(-1);
  
  public static final int SYNTAX_PROTO2_VALUE = 0;
  
  public static final int SYNTAX_PROTO3_VALUE = 1;
  
  private static final Syntax[] VALUES;
  
  private static final Internal.EnumLiteMap<Syntax> internalValueMap;
  
  private final int value;
  
  static {
    $VALUES = new Syntax[] { SYNTAX_PROTO2, SYNTAX_PROTO3, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<Syntax>() {
        public Syntax findValueByNumber(int param1Int) {
          return Syntax.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  Syntax(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static Syntax forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? null : SYNTAX_PROTO3) : SYNTAX_PROTO2;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return TypeProto.getDescriptor().getEnumTypes().get(0);
  }
  
  public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Syntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
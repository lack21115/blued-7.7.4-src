package com.google.rpc;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum Code implements ProtocolMessageEnum {
  ABORTED,
  ALREADY_EXISTS,
  CANCELLED,
  DATA_LOSS,
  DEADLINE_EXCEEDED,
  FAILED_PRECONDITION,
  INTERNAL,
  INVALID_ARGUMENT,
  NOT_FOUND,
  OK(0),
  OUT_OF_RANGE(0),
  PERMISSION_DENIED(0),
  RESOURCE_EXHAUSTED(0),
  UNAUTHENTICATED(0),
  UNAVAILABLE(0),
  UNIMPLEMENTED(0),
  UNKNOWN(0),
  UNRECOGNIZED(0);
  
  public static final int ABORTED_VALUE = 10;
  
  public static final int ALREADY_EXISTS_VALUE = 6;
  
  public static final int CANCELLED_VALUE = 1;
  
  public static final int DATA_LOSS_VALUE = 15;
  
  public static final int DEADLINE_EXCEEDED_VALUE = 4;
  
  public static final int FAILED_PRECONDITION_VALUE = 9;
  
  public static final int INTERNAL_VALUE = 13;
  
  public static final int INVALID_ARGUMENT_VALUE = 3;
  
  public static final int NOT_FOUND_VALUE = 5;
  
  public static final int OK_VALUE = 0;
  
  public static final int OUT_OF_RANGE_VALUE = 11;
  
  public static final int PERMISSION_DENIED_VALUE = 7;
  
  public static final int RESOURCE_EXHAUSTED_VALUE = 8;
  
  public static final int UNAUTHENTICATED_VALUE = 16;
  
  public static final int UNAVAILABLE_VALUE = 14;
  
  public static final int UNIMPLEMENTED_VALUE = 12;
  
  public static final int UNKNOWN_VALUE = 2;
  
  private static final Code[] VALUES;
  
  private static final Internal.EnumLiteMap<Code> internalValueMap;
  
  private final int value;
  
  static {
    CANCELLED = new Code("CANCELLED", 1, 1);
    UNKNOWN = new Code("UNKNOWN", 2, 2);
    INVALID_ARGUMENT = new Code("INVALID_ARGUMENT", 3, 3);
    DEADLINE_EXCEEDED = new Code("DEADLINE_EXCEEDED", 4, 4);
    NOT_FOUND = new Code("NOT_FOUND", 5, 5);
    ALREADY_EXISTS = new Code("ALREADY_EXISTS", 6, 6);
    PERMISSION_DENIED = new Code("PERMISSION_DENIED", 7, 7);
    UNAUTHENTICATED = new Code("UNAUTHENTICATED", 8, 16);
    RESOURCE_EXHAUSTED = new Code("RESOURCE_EXHAUSTED", 9, 8);
    FAILED_PRECONDITION = new Code("FAILED_PRECONDITION", 10, 9);
    ABORTED = new Code("ABORTED", 11, 10);
    OUT_OF_RANGE = new Code("OUT_OF_RANGE", 12, 11);
    UNIMPLEMENTED = new Code("UNIMPLEMENTED", 13, 12);
    INTERNAL = new Code("INTERNAL", 14, 13);
    UNAVAILABLE = new Code("UNAVAILABLE", 15, 14);
    DATA_LOSS = new Code("DATA_LOSS", 16, 15);
    UNRECOGNIZED = new Code("UNRECOGNIZED", 17, -1);
    $VALUES = new Code[] { 
        OK, CANCELLED, UNKNOWN, INVALID_ARGUMENT, DEADLINE_EXCEEDED, NOT_FOUND, ALREADY_EXISTS, PERMISSION_DENIED, UNAUTHENTICATED, RESOURCE_EXHAUSTED, 
        FAILED_PRECONDITION, ABORTED, OUT_OF_RANGE, UNIMPLEMENTED, INTERNAL, UNAVAILABLE, DATA_LOSS, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<Code>() {
        public Code a(int param1Int) {
          return Code.forNumber(param1Int);
        }
      };
    VALUES = values();
  }
  
  Code(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static Code forNumber(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 16:
        return UNAUTHENTICATED;
      case 15:
        return DATA_LOSS;
      case 14:
        return UNAVAILABLE;
      case 13:
        return INTERNAL;
      case 12:
        return UNIMPLEMENTED;
      case 11:
        return OUT_OF_RANGE;
      case 10:
        return ABORTED;
      case 9:
        return FAILED_PRECONDITION;
      case 8:
        return RESOURCE_EXHAUSTED;
      case 7:
        return PERMISSION_DENIED;
      case 6:
        return ALREADY_EXISTS;
      case 5:
        return NOT_FOUND;
      case 4:
        return DEADLINE_EXCEEDED;
      case 3:
        return INVALID_ARGUMENT;
      case 2:
        return UNKNOWN;
      case 1:
        return CANCELLED;
      case 0:
        break;
    } 
    return OK;
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor() {
    return CodeProto.a().getEnumTypes().get(0);
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
    return getDescriptor().getValues().get(ordinal());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\Code.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
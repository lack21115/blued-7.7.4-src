package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class FieldSet {
  final SmallSortedMap fields = SmallSortedMap.newFieldMap(16);
  
  boolean hasLazyField = false;
  
  private boolean isImmutable;
  
  static {
    new FieldSet((byte)0);
    throw new VerifyError("bad dex opcode");
  }
  
  private FieldSet() {}
  
  private FieldSet(byte paramByte) {
    if (!this.isImmutable) {
      this.fields.makeImmutable();
      this.isImmutable = true;
    } 
  }
  
  public static FieldSet newFieldSet() {
    return new FieldSet();
  }
  
  private void setField(FieldSet$FieldDescriptorLite paramFieldSet$FieldDescriptorLite, Object paramObject) {
    if (paramFieldSet$FieldDescriptorLite.isRepeated()) {
      if (paramObject instanceof List) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((List)paramObject);
        paramObject = arrayList.iterator();
        while (paramObject.hasNext()) {
          Object object = paramObject.next();
          verifyType(paramFieldSet$FieldDescriptorLite.getLiteType(), object);
        } 
        paramObject = arrayList;
      } else {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      } 
    } else {
      verifyType(paramFieldSet$FieldDescriptorLite.getLiteType(), paramObject);
    } 
    if (paramObject instanceof LazyField)
      this.hasLazyField = true; 
    this.fields.put(paramFieldSet$FieldDescriptorLite, paramObject);
  }
  
  private static void verifyType(WireFormat$FieldType paramWireFormat$FieldType, Object paramObject) {
    Internal.checkNotNull(paramObject);
    int i = FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[paramWireFormat$FieldType.javaType.ordinal()];
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    switch (i) {
      default:
        bool1 = bool3;
        break;
      case 9:
        if (paramObject instanceof MessageLite || paramObject instanceof LazyField) {
          bool1 = true;
          break;
        } 
        bool1 = bool3;
        break;
      case 8:
        if (paramObject instanceof Integer || paramObject instanceof Internal$EnumLite)
          bool1 = true; 
        break;
      case 7:
        if (paramObject instanceof ByteString || paramObject instanceof byte[]) {
          bool1 = true;
          break;
        } 
        bool1 = bool2;
        break;
      case 6:
        bool1 = paramObject instanceof String;
        break;
      case 5:
        bool1 = paramObject instanceof Boolean;
        break;
      case 4:
        bool1 = paramObject instanceof Double;
        break;
      case 3:
        bool1 = paramObject instanceof Float;
        break;
      case 2:
        bool1 = paramObject instanceof Long;
        break;
      case 1:
        bool1 = paramObject instanceof Integer;
        break;
    } 
    if (bool1)
      return; 
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof FieldSet))
      return false; 
    paramObject = paramObject;
    return this.fields.equals(((FieldSet)paramObject).fields);
  }
  
  public final int hashCode() {
    return this.fields.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\FieldSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
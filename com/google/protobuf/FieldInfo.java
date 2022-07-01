package com.google.protobuf;

import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {
  private final Field cachedSizeField;
  
  private final boolean enforceUtf8;
  
  private final Internal.EnumVerifier enumVerifier;
  
  private final Field field;
  
  private final int fieldNumber;
  
  private final Object mapDefaultEntry;
  
  private final Class<?> messageClass;
  
  private final OneofInfo oneof;
  
  private final Class<?> oneofStoredType;
  
  private final Field presenceField;
  
  private final int presenceMask;
  
  private final boolean required;
  
  private final FieldType type;
  
  private FieldInfo(Field paramField1, int paramInt1, FieldType paramFieldType, Class<?> paramClass1, Field paramField2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, OneofInfo paramOneofInfo, Class<?> paramClass2, Object paramObject, Internal.EnumVerifier paramEnumVerifier, Field paramField3) {
    this.field = paramField1;
    this.type = paramFieldType;
    this.messageClass = paramClass1;
    this.fieldNumber = paramInt1;
    this.presenceField = paramField2;
    this.presenceMask = paramInt2;
    this.required = paramBoolean1;
    this.enforceUtf8 = paramBoolean2;
    this.oneof = paramOneofInfo;
    this.oneofStoredType = paramClass2;
    this.mapDefaultEntry = paramObject;
    this.enumVerifier = paramEnumVerifier;
    this.cachedSizeField = paramField3;
  }
  
  private static void checkFieldNumber(int paramInt) {
    if (paramInt > 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("fieldNumber must be positive: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static FieldInfo forField(Field paramField, int paramInt, FieldType paramFieldType, boolean paramBoolean) {
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramField, "field");
    Internal.checkNotNull(paramFieldType, "fieldType");
    if (paramFieldType != FieldType.MESSAGE_LIST && paramFieldType != FieldType.GROUP_LIST)
      return new FieldInfo(paramField, paramInt, paramFieldType, null, null, 0, false, paramBoolean, null, null, null, null, null); 
    throw new IllegalStateException("Shouldn't be called for repeated message fields.");
  }
  
  public static FieldInfo forFieldWithEnumVerifier(Field paramField, int paramInt, FieldType paramFieldType, Internal.EnumVerifier paramEnumVerifier) {
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramField, "field");
    return new FieldInfo(paramField, paramInt, paramFieldType, null, null, 0, false, false, null, null, null, paramEnumVerifier, null);
  }
  
  public static FieldInfo forMapField(Field paramField, int paramInt, Object paramObject, Internal.EnumVerifier paramEnumVerifier) {
    Internal.checkNotNull(paramObject, "mapDefaultEntry");
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramField, "field");
    return new FieldInfo(paramField, paramInt, FieldType.MAP, null, null, 0, false, true, null, null, paramObject, paramEnumVerifier, null);
  }
  
  public static FieldInfo forOneofMemberField(int paramInt, FieldType paramFieldType, OneofInfo paramOneofInfo, Class<?> paramClass, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier) {
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramFieldType, "fieldType");
    Internal.checkNotNull(paramOneofInfo, "oneof");
    Internal.checkNotNull(paramClass, "oneofStoredType");
    if (paramFieldType.isScalar())
      return new FieldInfo(null, paramInt, paramFieldType, null, null, 0, false, paramBoolean, paramOneofInfo, paramClass, null, paramEnumVerifier, null); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Oneof is only supported for scalar fields. Field ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" is of type ");
    stringBuilder.append(paramFieldType);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static FieldInfo forPackedField(Field paramField1, int paramInt, FieldType paramFieldType, Field paramField2) {
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramField1, "field");
    Internal.checkNotNull(paramFieldType, "fieldType");
    if (paramFieldType != FieldType.MESSAGE_LIST && paramFieldType != FieldType.GROUP_LIST)
      return new FieldInfo(paramField1, paramInt, paramFieldType, null, null, 0, false, false, null, null, null, null, paramField2); 
    throw new IllegalStateException("Shouldn't be called for repeated message fields.");
  }
  
  public static FieldInfo forPackedFieldWithEnumVerifier(Field paramField1, int paramInt, FieldType paramFieldType, Internal.EnumVerifier paramEnumVerifier, Field paramField2) {
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramField1, "field");
    return new FieldInfo(paramField1, paramInt, paramFieldType, null, null, 0, false, false, null, null, null, paramEnumVerifier, paramField2);
  }
  
  public static FieldInfo forProto2OptionalField(Field paramField1, int paramInt1, FieldType paramFieldType, Field paramField2, int paramInt2, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier) {
    checkFieldNumber(paramInt1);
    Internal.checkNotNull(paramField1, "field");
    Internal.checkNotNull(paramFieldType, "fieldType");
    Internal.checkNotNull(paramField2, "presenceField");
    if (paramField2 == null || isExactlyOneBitSet(paramInt2))
      return new FieldInfo(paramField1, paramInt1, paramFieldType, null, paramField2, paramInt2, false, paramBoolean, null, null, null, paramEnumVerifier, null); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("presenceMask must have exactly one bit set: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static FieldInfo forProto2RequiredField(Field paramField1, int paramInt1, FieldType paramFieldType, Field paramField2, int paramInt2, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier) {
    checkFieldNumber(paramInt1);
    Internal.checkNotNull(paramField1, "field");
    Internal.checkNotNull(paramFieldType, "fieldType");
    Internal.checkNotNull(paramField2, "presenceField");
    if (paramField2 == null || isExactlyOneBitSet(paramInt2))
      return new FieldInfo(paramField1, paramInt1, paramFieldType, null, paramField2, paramInt2, true, paramBoolean, null, null, null, paramEnumVerifier, null); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("presenceMask must have exactly one bit set: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static FieldInfo forRepeatedMessageField(Field paramField, int paramInt, FieldType paramFieldType, Class<?> paramClass) {
    checkFieldNumber(paramInt);
    Internal.checkNotNull(paramField, "field");
    Internal.checkNotNull(paramFieldType, "fieldType");
    Internal.checkNotNull(paramClass, "messageClass");
    return new FieldInfo(paramField, paramInt, paramFieldType, paramClass, null, 0, false, false, null, null, null, null, null);
  }
  
  private static boolean isExactlyOneBitSet(int paramInt) {
    return (paramInt != 0 && (paramInt & paramInt - 1) == 0);
  }
  
  public static Builder newBuilder() {
    return new Builder();
  }
  
  public int compareTo(FieldInfo paramFieldInfo) {
    return this.fieldNumber - paramFieldInfo.fieldNumber;
  }
  
  public Field getCachedSizeField() {
    return this.cachedSizeField;
  }
  
  public Internal.EnumVerifier getEnumVerifier() {
    return this.enumVerifier;
  }
  
  public Field getField() {
    return this.field;
  }
  
  public int getFieldNumber() {
    return this.fieldNumber;
  }
  
  public Class<?> getListElementType() {
    return this.messageClass;
  }
  
  public Object getMapDefaultEntry() {
    return this.mapDefaultEntry;
  }
  
  public Class<?> getMessageFieldClass() {
    int i = null.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
    if (i != 1 && i != 2)
      return (i != 3 && i != 4) ? null : this.messageClass; 
    Field field = this.field;
    return (field != null) ? field.getType() : this.oneofStoredType;
  }
  
  public OneofInfo getOneof() {
    return this.oneof;
  }
  
  public Class<?> getOneofStoredType() {
    return this.oneofStoredType;
  }
  
  public Field getPresenceField() {
    return this.presenceField;
  }
  
  public int getPresenceMask() {
    return this.presenceMask;
  }
  
  public FieldType getType() {
    return this.type;
  }
  
  public boolean isEnforceUtf8() {
    return this.enforceUtf8;
  }
  
  public boolean isRequired() {
    return this.required;
  }
  
  public static final class Builder {
    private Field cachedSizeField;
    
    private boolean enforceUtf8;
    
    private Internal.EnumVerifier enumVerifier;
    
    private Field field;
    
    private int fieldNumber;
    
    private Object mapDefaultEntry;
    
    private OneofInfo oneof;
    
    private Class<?> oneofStoredType;
    
    private Field presenceField;
    
    private int presenceMask;
    
    private boolean required;
    
    private FieldType type;
    
    private Builder() {}
    
    public FieldInfo build() {
      OneofInfo oneofInfo = this.oneof;
      if (oneofInfo != null)
        return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, oneofInfo, this.oneofStoredType, this.enforceUtf8, this.enumVerifier); 
      Object object = this.mapDefaultEntry;
      if (object != null)
        return FieldInfo.forMapField(this.field, this.fieldNumber, object, this.enumVerifier); 
      object = this.presenceField;
      if (object != null)
        return this.required ? FieldInfo.forProto2RequiredField(this.field, this.fieldNumber, this.type, (Field)object, this.presenceMask, this.enforceUtf8, this.enumVerifier) : FieldInfo.forProto2OptionalField(this.field, this.fieldNumber, this.type, (Field)object, this.presenceMask, this.enforceUtf8, this.enumVerifier); 
      object = this.enumVerifier;
      if (object != null) {
        Field field = this.cachedSizeField;
        return (field == null) ? FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, (Internal.EnumVerifier)object) : FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, (Internal.EnumVerifier)object, field);
      } 
      object = this.cachedSizeField;
      return (object == null) ? FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8) : FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, (Field)object);
    }
    
    public Builder withCachedSizeField(Field param1Field) {
      this.cachedSizeField = param1Field;
      return this;
    }
    
    public Builder withEnforceUtf8(boolean param1Boolean) {
      this.enforceUtf8 = param1Boolean;
      return this;
    }
    
    public Builder withEnumVerifier(Internal.EnumVerifier param1EnumVerifier) {
      this.enumVerifier = param1EnumVerifier;
      return this;
    }
    
    public Builder withField(Field param1Field) {
      if (this.oneof == null) {
        this.field = param1Field;
        return this;
      } 
      throw new IllegalStateException("Cannot set field when building a oneof.");
    }
    
    public Builder withFieldNumber(int param1Int) {
      this.fieldNumber = param1Int;
      return this;
    }
    
    public Builder withMapDefaultEntry(Object param1Object) {
      this.mapDefaultEntry = param1Object;
      return this;
    }
    
    public Builder withOneof(OneofInfo param1OneofInfo, Class<?> param1Class) {
      if (this.field == null && this.presenceField == null) {
        this.oneof = param1OneofInfo;
        this.oneofStoredType = param1Class;
        return this;
      } 
      throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
    }
    
    public Builder withPresence(Field param1Field, int param1Int) {
      this.presenceField = Internal.<Field>checkNotNull(param1Field, "presenceField");
      this.presenceMask = param1Int;
      return this;
    }
    
    public Builder withRequired(boolean param1Boolean) {
      this.required = param1Boolean;
      return this;
    }
    
    public Builder withType(FieldType param1FieldType) {
      this.type = param1FieldType;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\FieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
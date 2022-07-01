package com.alibaba.fastjson.serializer;

public enum SerializerFeature {
  BeanToArray, BrowserCompatible, BrowserSecure, DisableCheckSpecialChar, DisableCircularReferenceDetect, IgnoreNonFieldGetter, NotWriteDefaultValue, NotWriteRootClassName, PrettyFormat, QuoteFieldNames, SkipTransientField, SortField, UseISO8601DateFormat, UseSingleQuotes, WriteClassName, WriteDateUseDateFormat, WriteEnumUsingName, WriteEnumUsingToString, WriteMapNullValue, WriteNonStringKeyAsString, WriteNonStringValueAsString, WriteNullBooleanAsFalse, WriteNullListAsEmpty, WriteNullNumberAsZero, WriteNullStringAsEmpty, WriteSlashAsSpecial, WriteTabAsSpecial;
  
  public static final SerializerFeature[] EMPTY;
  
  public final int mask = 1 << ordinal();
  
  static {
    WriteEnumUsingToString = new SerializerFeature("WriteEnumUsingToString", 3);
    WriteEnumUsingName = new SerializerFeature("WriteEnumUsingName", 4);
    UseISO8601DateFormat = new SerializerFeature("UseISO8601DateFormat", 5);
    WriteNullListAsEmpty = new SerializerFeature("WriteNullListAsEmpty", 6);
    WriteNullStringAsEmpty = new SerializerFeature("WriteNullStringAsEmpty", 7);
    WriteNullNumberAsZero = new SerializerFeature("WriteNullNumberAsZero", 8);
    WriteNullBooleanAsFalse = new SerializerFeature("WriteNullBooleanAsFalse", 9);
    SkipTransientField = new SerializerFeature("SkipTransientField", 10);
    SortField = new SerializerFeature("SortField", 11);
    WriteTabAsSpecial = new SerializerFeature("WriteTabAsSpecial", 12);
    PrettyFormat = new SerializerFeature("PrettyFormat", 13);
    WriteClassName = new SerializerFeature("WriteClassName", 14);
    DisableCircularReferenceDetect = new SerializerFeature("DisableCircularReferenceDetect", 15);
    WriteSlashAsSpecial = new SerializerFeature("WriteSlashAsSpecial", 16);
    BrowserCompatible = new SerializerFeature("BrowserCompatible", 17);
    WriteDateUseDateFormat = new SerializerFeature("WriteDateUseDateFormat", 18);
    NotWriteRootClassName = new SerializerFeature("NotWriteRootClassName", 19);
    DisableCheckSpecialChar = new SerializerFeature("DisableCheckSpecialChar", 20);
    BeanToArray = new SerializerFeature("BeanToArray", 21);
    WriteNonStringKeyAsString = new SerializerFeature("WriteNonStringKeyAsString", 22);
    NotWriteDefaultValue = new SerializerFeature("NotWriteDefaultValue", 23);
    BrowserSecure = new SerializerFeature("BrowserSecure", 24);
    IgnoreNonFieldGetter = new SerializerFeature("IgnoreNonFieldGetter", 25);
    WriteNonStringValueAsString = new SerializerFeature("WriteNonStringValueAsString", 26);
    $VALUES = new SerializerFeature[] { 
        QuoteFieldNames, UseSingleQuotes, WriteMapNullValue, WriteEnumUsingToString, WriteEnumUsingName, UseISO8601DateFormat, WriteNullListAsEmpty, WriteNullStringAsEmpty, WriteNullNumberAsZero, WriteNullBooleanAsFalse, 
        SkipTransientField, SortField, WriteTabAsSpecial, PrettyFormat, WriteClassName, DisableCircularReferenceDetect, WriteSlashAsSpecial, BrowserCompatible, WriteDateUseDateFormat, NotWriteRootClassName, 
        DisableCheckSpecialChar, BeanToArray, WriteNonStringKeyAsString, NotWriteDefaultValue, BrowserSecure, IgnoreNonFieldGetter, WriteNonStringValueAsString };
    EMPTY = new SerializerFeature[0];
  }
  
  public static int config(int paramInt, SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    return paramBoolean ? (paramInt | paramSerializerFeature.mask) : (paramInt & paramSerializerFeature.mask);
  }
  
  public static boolean isEnabled(int paramInt1, int paramInt2, SerializerFeature paramSerializerFeature) {
    int i = paramSerializerFeature.mask;
    return ((paramInt1 & i) != 0 || (paramInt2 & i) != 0);
  }
  
  public static boolean isEnabled(int paramInt, SerializerFeature paramSerializerFeature) {
    return ((paramInt & paramSerializerFeature.mask) != 0);
  }
  
  public static int of(SerializerFeature[] paramArrayOfSerializerFeature) {
    int i = 0;
    if (paramArrayOfSerializerFeature == null)
      return 0; 
    int k = paramArrayOfSerializerFeature.length;
    int j = 0;
    while (i < k) {
      j |= (paramArrayOfSerializerFeature[i]).mask;
      i++;
    } 
    return j;
  }
  
  public final int getMask() {
    return this.mask;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializerFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
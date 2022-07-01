package com.alibaba.fastjson.parser;

public enum Feature {
  AllowArbitraryCommas, AllowComment, AllowISO8601DateFormat, AllowSingleQuotes, AllowUnQuotedFieldNames, AutoCloseSource, DisableASM, DisableCircularReferenceDetect, DisableSpecialKeyDetect, IgnoreNotMatch, InitStringFieldAsEmpty, InternFieldNames, OrderedField, SortFeidFastMatch, SupportArrayToBean, UseBigDecimal, UseObjectArray;
  
  public final int mask = 1 << ordinal();
  
  static {
    AllowComment = new Feature("AllowComment", 1);
    AllowUnQuotedFieldNames = new Feature("AllowUnQuotedFieldNames", 2);
    AllowSingleQuotes = new Feature("AllowSingleQuotes", 3);
    InternFieldNames = new Feature("InternFieldNames", 4);
    AllowISO8601DateFormat = new Feature("AllowISO8601DateFormat", 5);
    AllowArbitraryCommas = new Feature("AllowArbitraryCommas", 6);
    UseBigDecimal = new Feature("UseBigDecimal", 7);
    IgnoreNotMatch = new Feature("IgnoreNotMatch", 8);
    SortFeidFastMatch = new Feature("SortFeidFastMatch", 9);
    DisableASM = new Feature("DisableASM", 10);
    DisableCircularReferenceDetect = new Feature("DisableCircularReferenceDetect", 11);
    InitStringFieldAsEmpty = new Feature("InitStringFieldAsEmpty", 12);
    SupportArrayToBean = new Feature("SupportArrayToBean", 13);
    OrderedField = new Feature("OrderedField", 14);
    DisableSpecialKeyDetect = new Feature("DisableSpecialKeyDetect", 15);
    UseObjectArray = new Feature("UseObjectArray", 16);
    $VALUES = new Feature[] { 
        AutoCloseSource, AllowComment, AllowUnQuotedFieldNames, AllowSingleQuotes, InternFieldNames, AllowISO8601DateFormat, AllowArbitraryCommas, UseBigDecimal, IgnoreNotMatch, SortFeidFastMatch, 
        DisableASM, DisableCircularReferenceDetect, InitStringFieldAsEmpty, SupportArrayToBean, OrderedField, DisableSpecialKeyDetect, UseObjectArray };
  }
  
  public static int config(int paramInt, Feature paramFeature, boolean paramBoolean) {
    return paramBoolean ? (paramInt | paramFeature.mask) : (paramInt & paramFeature.mask);
  }
  
  public static boolean isEnabled(int paramInt, Feature paramFeature) {
    return ((paramInt & paramFeature.mask) != 0);
  }
  
  public static int of(Feature[] paramArrayOfFeature) {
    int i = 0;
    if (paramArrayOfFeature == null)
      return 0; 
    int k = paramArrayOfFeature.length;
    int j = 0;
    while (i < k) {
      j |= (paramArrayOfFeature[i]).mask;
      i++;
    } 
    return j;
  }
  
  public final int getMask() {
    return this.mask;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
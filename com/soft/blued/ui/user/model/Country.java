package com.soft.blued.ui.user.model;

import com.soft.blued.utils.StringUtils;

public class Country {
  public String abbr = "";
  
  public String code = "";
  
  public String continent = "";
  
  public String group_by = "";
  
  public String has_child = "";
  
  public String nation = "";
  
  public String nation_code = "";
  
  public Country(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {
    this.code = paramString3;
    this.nation = paramString1;
    this.nation_code = paramString2;
    this.code = paramString3;
    this.abbr = paramString4;
    this.continent = paramString5;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    this.has_child = stringBuilder.toString();
    if (!StringUtils.e(paramString4) && paramString4.length() >= 1)
      this.group_by = paramString4.substring(1, 1); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\Country.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.sina.weibo.sdk.register.mobile;

import android.text.TextUtils;
import java.io.Serializable;

public class Country implements Serializable, Comparable<Country> {
  public static final String CHINA_CODE = "0086";
  
  private static final long serialVersionUID = 0L;
  
  private String code;
  
  private String[] mccs;
  
  private String name;
  
  private String pinyin;
  
  public Country() {}
  
  public Country(String paramString1, String paramString2) {
    this.name = paramString1;
    this.code = paramString2;
  }
  
  public int compareTo(Country paramCountry) {
    return TextUtils.isEmpty(this.pinyin) ? -1 : ((paramCountry == null || TextUtils.isEmpty(paramCountry.pinyin)) ? 1 : this.pinyin.compareTo(paramCountry.pinyin));
  }
  
  public String getCode() {
    return this.code;
  }
  
  public String[] getMccs() {
    return this.mccs;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPinyin() {
    return PinyinUtils.getObject().getPinyin(this.name).toLowerCase();
  }
  
  public void setCode(String paramString) {
    this.code = paramString;
  }
  
  public void setMccs(String[] paramArrayOfString) {
    this.mccs = paramArrayOfString;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setPinyin(String paramString) {
    this.pinyin = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\Country.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
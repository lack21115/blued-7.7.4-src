package com.soft.blued.model;

public class AreaCode implements Comparable {
  private String abbr;
  
  private String code;
  
  private String name;
  
  private String sort;
  
  public int compareTo(Object paramObject) {
    if (paramObject == null || !(paramObject instanceof AreaCode))
      return -1; 
    paramObject = ((AreaCode)paramObject).getSort();
    if (paramObject.length() == 1)
      return this.sort.compareTo((String)paramObject); 
    String str = this.sort;
    return Integer.valueOf(str.substring(0, str.length() - 1)).compareTo(Integer.valueOf(paramObject.substring(0, paramObject.length() - 1)));
  }
  
  public String getAbbr() {
    return this.abbr;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSort() {
    return this.sort;
  }
  
  public void setAbbr(String paramString) {
    this.abbr = paramString;
  }
  
  public void setCode(String paramString) {
    this.code = paramString;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setSort(String paramString) {
    this.sort = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\model\AreaCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
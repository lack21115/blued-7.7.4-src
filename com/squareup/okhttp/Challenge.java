package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;

public final class Challenge {
  private final String realm;
  
  private final String scheme;
  
  public Challenge(String paramString1, String paramString2) {
    this.scheme = paramString1;
    this.realm = paramString2;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Challenge) {
      String str = this.scheme;
      paramObject = paramObject;
      if (Util.equal(str, ((Challenge)paramObject).scheme) && Util.equal(this.realm, ((Challenge)paramObject).realm))
        return true; 
    } 
    return false;
  }
  
  public String getRealm() {
    return this.realm;
  }
  
  public String getScheme() {
    return this.scheme;
  }
  
  public int hashCode() {
    byte b;
    String str = this.realm;
    int i = 0;
    if (str != null) {
      b = str.hashCode();
    } else {
      b = 0;
    } 
    str = this.scheme;
    if (str != null)
      i = str.hashCode(); 
    return (899 + b) * 31 + i;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.scheme);
    stringBuilder.append(" realm=\"");
    stringBuilder.append(this.realm);
    stringBuilder.append("\"");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Challenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
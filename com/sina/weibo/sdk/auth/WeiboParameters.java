package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.ArrayList;

public class WeiboParameters {
  private ArrayList<String> mKeys = new ArrayList<String>();
  
  private ArrayList<String> mValues = new ArrayList<String>();
  
  private int getLocation(String paramString) {
    return this.mKeys.contains(paramString) ? this.mKeys.indexOf(paramString) : -1;
  }
  
  public void add(String paramString, int paramInt) {
    this.mKeys.add(paramString);
    this.mValues.add(String.valueOf(paramInt));
  }
  
  public void add(String paramString, long paramLong) {
    this.mKeys.add(paramString);
    this.mValues.add(String.valueOf(paramLong));
  }
  
  public void add(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      this.mKeys.add(paramString1);
      this.mValues.add(paramString2);
    } 
  }
  
  public void addAll(WeiboParameters paramWeiboParameters) {
    for (int i = 0;; i++) {
      if (i >= paramWeiboParameters.size())
        return; 
      add(paramWeiboParameters.getKey(i), paramWeiboParameters.getValue(i));
    } 
  }
  
  public void clear() {
    this.mKeys.clear();
    this.mValues.clear();
  }
  
  public String getKey(int paramInt) {
    return (paramInt >= 0 && paramInt < this.mKeys.size()) ? this.mKeys.get(paramInt) : "";
  }
  
  public String getValue(int paramInt) {
    return (paramInt >= 0 && paramInt < this.mKeys.size()) ? this.mValues.get(paramInt) : null;
  }
  
  public String getValue(String paramString) {
    int i = getLocation(paramString);
    return (i >= 0 && i < this.mKeys.size()) ? this.mValues.get(i) : null;
  }
  
  public void remove(int paramInt) {
    if (paramInt < this.mKeys.size()) {
      this.mKeys.remove(paramInt);
      this.mValues.remove(paramInt);
    } 
  }
  
  public void remove(String paramString) {
    int i = this.mKeys.indexOf(paramString);
    if (i >= 0) {
      this.mKeys.remove(i);
      this.mValues.remove(i);
    } 
  }
  
  public int size() {
    return this.mKeys.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\auth\WeiboParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
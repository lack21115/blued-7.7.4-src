package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ad {
  private static Map<String, ad> a = new HashMap<String, ad>();
  
  private SharedPreferences b;
  
  private ad(String paramString, Context paramContext) {
    if (paramContext != null)
      this.b = paramContext.getApplicationContext().getSharedPreferences(paramString, 0); 
  }
  
  public static ad a(String paramString, Context paramContext) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "tt_ad_sdk_sp"; 
    ad ad2 = a.get(str);
    ad ad1 = ad2;
    if (ad2 == null) {
      ad1 = new ad(str, paramContext);
      a.put(str, ad1);
    } 
    return ad1;
  }
  
  public String a(String paramString) {
    try {
      return b(paramString, "");
    } finally {
      paramString = null;
    } 
  }
  
  public void a(String paramString, int paramInt) {
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public void a(String paramString, long paramLong) {
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  public void a(String paramString, Set<String> paramSet) {
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public int b(String paramString, int paramInt) {
    try {
      return this.b.getInt(paramString, paramInt);
    } finally {
      paramString = null;
    } 
  }
  
  public long b(String paramString, long paramLong) {
    try {
      return this.b.getLong(paramString, paramLong);
    } finally {
      paramString = null;
    } 
  }
  
  public String b(String paramString1, String paramString2) {
    try {
      return this.b.getString(paramString1, paramString2);
    } finally {
      paramString1 = null;
    } 
  }
  
  public Set<String> b(String paramString, Set<String> paramSet) {
    try {
      return this.b.getStringSet(paramString, paramSet);
    } finally {
      paramString = null;
    } 
  }
  
  public void b(String paramString) {
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
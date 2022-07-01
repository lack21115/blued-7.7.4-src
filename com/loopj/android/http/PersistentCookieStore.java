package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class PersistentCookieStore implements CookieStore {
  private static final String COOKIE_NAME_PREFIX = "cookie_";
  
  private static final String COOKIE_NAME_STORE = "names";
  
  private static final String COOKIE_PREFS = "CookiePrefsFile";
  
  private static final String LOG_TAG = "PersistentCookieStore";
  
  private final SharedPreferences cookiePrefs;
  
  private final ConcurrentHashMap<String, Cookie> cookies;
  
  private boolean omitNonPersistentCookies;
  
  public PersistentCookieStore(Context paramContext) {
    int i = 0;
    this.omitNonPersistentCookies = false;
    this.cookiePrefs = paramContext.getSharedPreferences("CookiePrefsFile", 0);
    this.cookies = new ConcurrentHashMap<String, Cookie>();
    String str = this.cookiePrefs.getString("names", null);
    if (str != null) {
      String[] arrayOfString = TextUtils.split(str, ",");
      int j = arrayOfString.length;
      while (i < j) {
        String str1 = arrayOfString[i];
        SharedPreferences sharedPreferences = this.cookiePrefs;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cookie_");
        stringBuilder.append(str1);
        String str2 = sharedPreferences.getString(stringBuilder.toString(), null);
        if (str2 != null) {
          Cookie cookie = decodeCookie(str2);
          if (cookie != null)
            this.cookies.put(str1, cookie); 
        } 
        i++;
      } 
      clearExpired(new Date());
    } 
  }
  
  public void addCookie(Cookie paramCookie) {
    if (this.omitNonPersistentCookies && !paramCookie.isPersistent())
      return; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramCookie.getName());
    stringBuilder1.append(paramCookie.getDomain());
    String str = stringBuilder1.toString();
    if (!paramCookie.isExpired(new Date())) {
      this.cookies.put(str, paramCookie);
    } else {
      this.cookies.remove(str);
    } 
    SharedPreferences.Editor editor = this.cookiePrefs.edit();
    editor.putString("names", TextUtils.join(",", this.cookies.keySet()));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("cookie_");
    stringBuilder2.append(str);
    editor.putString(stringBuilder2.toString(), encodeCookie(new SerializableCookie(paramCookie)));
    editor.commit();
  }
  
  protected String byteArrayToHexString(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      int k = paramArrayOfbyte[i] & 0xFF;
      if (k < 16)
        stringBuilder.append('0'); 
      stringBuilder.append(Integer.toHexString(k));
    } 
    return stringBuilder.toString().toUpperCase(Locale.US);
  }
  
  public void clear() {
    SharedPreferences.Editor editor = this.cookiePrefs.edit();
    for (String str : this.cookies.keySet()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cookie_");
      stringBuilder.append(str);
      editor.remove(stringBuilder.toString());
    } 
    editor.remove("names");
    editor.commit();
    this.cookies.clear();
  }
  
  public boolean clearExpired(Date paramDate) {
    SharedPreferences.Editor editor = this.cookiePrefs.edit();
    Iterator<Map.Entry> iterator = this.cookies.entrySet().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      String str = (String)entry.getKey();
      if (((Cookie)entry.getValue()).isExpired(paramDate)) {
        this.cookies.remove(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cookie_");
        stringBuilder.append(str);
        editor.remove(stringBuilder.toString());
        bool = true;
      } 
    } 
    if (bool)
      editor.putString("names", TextUtils.join(",", this.cookies.keySet())); 
    editor.commit();
    return bool;
  }
  
  protected Cookie decodeCookie(String paramString) {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(hexStringToByteArray(paramString));
    try {
      return ((SerializableCookie)(new ObjectInputStream(byteArrayInputStream)).readObject()).getCookie();
    } catch (IOException iOException) {
      Log.d("PersistentCookieStore", "IOException in decodeCookie", iOException);
    } catch (ClassNotFoundException classNotFoundException) {
      Log.d("PersistentCookieStore", "ClassNotFoundException in decodeCookie", classNotFoundException);
    } 
    return null;
  }
  
  public void deleteCookie(Cookie paramCookie) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramCookie.getName());
    stringBuilder1.append(paramCookie.getDomain());
    String str = stringBuilder1.toString();
    this.cookies.remove(str);
    SharedPreferences.Editor editor = this.cookiePrefs.edit();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("cookie_");
    stringBuilder2.append(str);
    editor.remove(stringBuilder2.toString());
    editor.commit();
  }
  
  protected String encodeCookie(SerializableCookie paramSerializableCookie) {
    if (paramSerializableCookie == null)
      return null; 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      (new ObjectOutputStream(byteArrayOutputStream)).writeObject(paramSerializableCookie);
      return byteArrayToHexString(byteArrayOutputStream.toByteArray());
    } catch (IOException iOException) {
      Log.d("PersistentCookieStore", "IOException in encodeCookie", iOException);
      return null;
    } 
  }
  
  public List<Cookie> getCookies() {
    return new ArrayList<Cookie>(this.cookies.values());
  }
  
  protected byte[] hexStringToByteArray(String paramString) {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    for (int i = 0; i < j; i += 2)
      arrayOfByte[i / 2] = (byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)); 
    return arrayOfByte;
  }
  
  public void setOmitNonPersistentCookies(boolean paramBoolean) {
    this.omitNonPersistentCookies = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\PersistentCookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
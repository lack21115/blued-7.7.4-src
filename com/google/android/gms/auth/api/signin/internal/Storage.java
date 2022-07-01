package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class Storage {
  private static final Lock zaa = new ReentrantLock();
  
  private static Storage zab;
  
  private final Lock zac = new ReentrantLock();
  
  private final SharedPreferences zad;
  
  private Storage(Context paramContext) {
    this.zad = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static Storage getInstance(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    zaa.lock();
    try {
      if (zab == null)
        zab = new Storage(paramContext.getApplicationContext()); 
      return zab;
    } finally {
      zaa.unlock();
    } 
  }
  
  private final GoogleSignInAccount zaa(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    paramString = zac(zab("googleSignInAccount", paramString));
    if (paramString != null)
      try {
        return GoogleSignInAccount.zaa(paramString);
      } catch (JSONException jSONException) {
        return null;
      }  
    return null;
  }
  
  private final void zaa(String paramString1, String paramString2) {
    this.zac.lock();
    try {
      this.zad.edit().putString(paramString1, paramString2).apply();
      return;
    } finally {
      this.zac.unlock();
    } 
  }
  
  private final GoogleSignInOptions zab(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    paramString = zac(zab("googleSignInOptions", paramString));
    if (paramString != null)
      try {
        return GoogleSignInOptions.zaa(paramString);
      } catch (JSONException jSONException) {
        return null;
      }  
    return null;
  }
  
  private static String zab(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length());
    stringBuilder.append(paramString1);
    stringBuilder.append(":");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  private final String zac(String paramString) {
    this.zac.lock();
    try {
      paramString = this.zad.getString(paramString, null);
      return paramString;
    } finally {
      this.zac.unlock();
    } 
  }
  
  private final void zad(String paramString) {
    this.zac.lock();
    try {
      this.zad.edit().remove(paramString).apply();
      return;
    } finally {
      this.zac.unlock();
    } 
  }
  
  public void clear() {
    this.zac.lock();
    try {
      this.zad.edit().clear().apply();
      return;
    } finally {
      this.zac.unlock();
    } 
  }
  
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
    return zaa(zac("defaultGoogleSignInAccount"));
  }
  
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
    return zab(zac("defaultGoogleSignInAccount"));
  }
  
  public String getSavedRefreshToken() {
    return zac("refreshToken");
  }
  
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions) {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    zaa("defaultGoogleSignInAccount", paramGoogleSignInAccount.zaa());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zaa();
    zaa(zab("googleSignInAccount", str), paramGoogleSignInAccount.zab());
    zaa(zab("googleSignInOptions", str), paramGoogleSignInOptions.zaa());
  }
  
  public final void zaa() {
    String str = zac("defaultGoogleSignInAccount");
    zad("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str)) {
      zad(zab("googleSignInAccount", str));
      zad(zab("googleSignInOptions", str));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\Storage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
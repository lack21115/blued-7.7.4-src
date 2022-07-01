package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class zzaa {
  private static final Lock zzeok = new ReentrantLock();
  
  private static zzaa zzeol;
  
  private final Lock zzeom = new ReentrantLock();
  
  private final SharedPreferences zzeon;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private zzaa(Context paramContext) {
    this.zzeon = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static zzaa zzbs(Context paramContext) {
    zzbq.checkNotNull(paramContext);
    zzeok.lock();
    try {
      if (zzeol == null)
        zzeol = new zzaa(paramContext.getApplicationContext()); 
      return zzeol;
    } finally {
      zzeok.unlock();
    } 
  }
  
  public final GoogleSignInAccount zzfe(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf("googleSignInAccount").length() + 1 + String.valueOf(paramString).length());
    stringBuilder.append("googleSignInAccount");
    stringBuilder.append(":");
    stringBuilder.append(paramString);
    paramString = zzfg(stringBuilder.toString());
    if (paramString != null)
      try {
        return GoogleSignInAccount.zzfa(paramString);
      } catch (JSONException jSONException) {} 
    return null;
  }
  
  public final String zzfg(String paramString) {
    this.zzeom.lock();
    try {
      paramString = this.zzeon.getString(paramString, null);
      return paramString;
    } finally {
      this.zzeom.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
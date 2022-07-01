package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends zzbgl implements ReflectedParcelable {
  public static final Parcelable.Creator CREATOR = new zzb();
  
  private static zze zzemg = zzi.zzanq();
  
  private int versionCode;
  
  private String zzbzd;
  
  private List zzeie;
  
  private String zzekq;
  
  private String zzekr;
  
  private String zzelh;
  
  public String zzemh;
  
  private String zzemi;
  
  private Uri zzemj;
  
  private String zzemk;
  
  private long zzeml;
  
  private String zzemm;
  
  private Set zzemn = new HashSet();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List paramList, String paramString7, String paramString8) {
    this.versionCode = paramInt;
    this.zzbzd = paramString1;
    this.zzelh = paramString2;
    this.zzemh = paramString3;
    this.zzemi = paramString4;
    this.zzemj = paramUri;
    this.zzemk = paramString5;
    this.zzeml = paramLong;
    this.zzemm = paramString6;
    this.zzeie = paramList;
    this.zzekq = paramString7;
    this.zzekr = paramString8;
  }
  
  public static GoogleSignInAccount zzfa(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {
      Uri uri = Uri.parse(paramString);
    } else {
      paramString = null;
    } 
    long l = Long.parseLong(jSONObject.getString("expirationTime"));
    HashSet<Scope> hashSet = new HashSet();
    JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
    int j = jSONArray.length();
    for (int i = 0; i < j; i++)
      hashSet.add(new Scope(jSONArray.getString(i))); 
    String str1 = jSONObject.optString("id");
    String str2 = jSONObject.optString("tokenId", null);
    String str3 = jSONObject.optString("email", null);
    String str4 = jSONObject.optString("displayName", null);
    String str5 = jSONObject.optString("givenName", null);
    String str6 = jSONObject.optString("familyName", null);
    Long long_2 = Long.valueOf(l);
    String str7 = jSONObject.getString("obfuscatedIdentifier");
    Long long_1 = long_2;
    if (long_2 == null)
      long_1 = Long.valueOf(zzemg.currentTimeMillis() / 1000L); 
    GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, str1, str2, str3, str4, (Uri)paramString, null, long_1.longValue(), zzbq.zzgv(str7), new ArrayList((Collection)zzbq.checkNotNull(hashSet)), str5, str6);
    googleSignInAccount.zzemk = jSONObject.optString("serverAuthCode", null);
    return googleSignInAccount;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof GoogleSignInAccount))
      return false; 
    paramObject = paramObject;
    return (((GoogleSignInAccount)paramObject).zzemm.equals(this.zzemm) && paramObject.zzacf().equals(zzacf()));
  }
  
  public int hashCode() {
    return (this.zzemm.hashCode() + 527) * 31 + zzacf().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.versionCode);
    zzbgo.zza(paramParcel, 2, this.zzbzd, false);
    zzbgo.zza(paramParcel, 3, this.zzelh, false);
    zzbgo.zza(paramParcel, 4, this.zzemh, false);
    zzbgo.zza(paramParcel, 5, this.zzemi, false);
    zzbgo.zza(paramParcel, 6, (Parcelable)this.zzemj, paramInt, false);
    zzbgo.zza(paramParcel, 7, this.zzemk, false);
    zzbgo.zza(paramParcel, 8, this.zzeml);
    zzbgo.zza(paramParcel, 9, this.zzemm, false);
    zzbgo.zzc(paramParcel, 10, this.zzeie, false);
    zzbgo.zza(paramParcel, 11, this.zzekq, false);
    zzbgo.zza(paramParcel, 12, this.zzekr, false);
    zzbgo.zzah(paramParcel, i);
  }
  
  public final Set zzacf() {
    HashSet hashSet = new HashSet(this.zzeie);
    hashSet.addAll(this.zzemn);
    return hashSet;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
  
  private static Clock zaa = DefaultClock.getInstance();
  
  private final int zab;
  
  private String zac;
  
  private String zad;
  
  private String zae;
  
  private String zaf;
  
  private Uri zag;
  
  private String zah;
  
  private long zai;
  
  private String zaj;
  
  private List<Scope> zak;
  
  private String zal;
  
  private String zam;
  
  private Set<Scope> zan = new HashSet<Scope>();
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8) {
    this.zab = paramInt;
    this.zac = paramString1;
    this.zad = paramString2;
    this.zae = paramString3;
    this.zaf = paramString4;
    this.zag = paramUri;
    this.zah = paramString5;
    this.zai = paramLong;
    this.zaj = paramString6;
    this.zak = paramList;
    this.zal = paramString7;
    this.zam = paramString8;
  }
  
  public static GoogleSignInAccount createDefault() {
    Account account = new Account("<<default account>>", "com.google");
    HashSet<Scope> hashSet = new HashSet();
    return zaa(null, null, account.name, null, null, null, null, Long.valueOf(0L), account.name, hashSet);
  }
  
  public static GoogleSignInAccount zaa(String paramString) throws JSONException {
    String str1;
    String str2;
    String str3;
    String str4;
    boolean bool = TextUtils.isEmpty(paramString);
    String str5 = null;
    if (bool)
      return null; 
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("photoUrl");
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
    String str6 = jSONObject.optString("id");
    if (jSONObject.has("tokenId")) {
      String str = jSONObject.optString("tokenId");
    } else {
      jSONArray = null;
    } 
    if (jSONObject.has("email")) {
      str1 = jSONObject.optString("email");
    } else {
      str1 = null;
    } 
    if (jSONObject.has("displayName")) {
      str2 = jSONObject.optString("displayName");
    } else {
      str2 = null;
    } 
    if (jSONObject.has("givenName")) {
      str3 = jSONObject.optString("givenName");
    } else {
      str3 = null;
    } 
    if (jSONObject.has("familyName")) {
      str4 = jSONObject.optString("familyName");
    } else {
      str4 = null;
    } 
    GoogleSignInAccount googleSignInAccount = zaa(str6, (String)jSONArray, str1, str2, str3, str4, (Uri)paramString, Long.valueOf(l), jSONObject.getString("obfuscatedIdentifier"), hashSet);
    paramString = str5;
    if (jSONObject.has("serverAuthCode"))
      paramString = jSONObject.optString("serverAuthCode"); 
    googleSignInAccount.zah = paramString;
    return googleSignInAccount;
  }
  
  private static GoogleSignInAccount zaa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri, Long paramLong, String paramString7, Set<Scope> paramSet) {
    if (paramLong == null)
      paramLong = Long.valueOf(zaa.currentTimeMillis() / 1000L); 
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, paramLong.longValue(), Preconditions.checkNotEmpty(paramString7), new ArrayList<Scope>((Collection<? extends Scope>)Preconditions.checkNotNull(paramSet)), paramString5, paramString6);
  }
  
  private final JSONObject zac() {
    JSONObject jSONObject = new JSONObject();
    try {
      if (getId() != null)
        jSONObject.put("id", getId()); 
      if (getIdToken() != null)
        jSONObject.put("tokenId", getIdToken()); 
      if (getEmail() != null)
        jSONObject.put("email", getEmail()); 
      if (getDisplayName() != null)
        jSONObject.put("displayName", getDisplayName()); 
      if (getGivenName() != null)
        jSONObject.put("givenName", getGivenName()); 
      if (getFamilyName() != null)
        jSONObject.put("familyName", getFamilyName()); 
      Uri uri = getPhotoUrl();
      if (uri != null)
        jSONObject.put("photoUrl", uri.toString()); 
      if (getServerAuthCode() != null)
        jSONObject.put("serverAuthCode", getServerAuthCode()); 
      jSONObject.put("expirationTime", this.zai);
      jSONObject.put("obfuscatedIdentifier", this.zaj);
      JSONArray jSONArray = new JSONArray();
      Scope[] arrayOfScope = this.zak.<Scope>toArray(new Scope[this.zak.size()]);
      Arrays.sort(arrayOfScope, zaa.zaa);
      int j = arrayOfScope.length;
      for (int i = 0; i < j; i++)
        jSONArray.put(arrayOfScope[i].getScopeUri()); 
      jSONObject.put("grantedScopes", jSONArray);
      return jSONObject;
    } catch (JSONException jSONException) {
      throw new RuntimeException(jSONException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof GoogleSignInAccount))
      return false; 
    paramObject = paramObject;
    return (((GoogleSignInAccount)paramObject).zaj.equals(this.zaj) && paramObject.getRequestedScopes().equals(getRequestedScopes()));
  }
  
  public Account getAccount() {
    String str = this.zae;
    return (str == null) ? null : new Account(str, "com.google");
  }
  
  public String getDisplayName() {
    return this.zaf;
  }
  
  public String getEmail() {
    return this.zae;
  }
  
  public String getFamilyName() {
    return this.zam;
  }
  
  public String getGivenName() {
    return this.zal;
  }
  
  public Set<Scope> getGrantedScopes() {
    return new HashSet<Scope>(this.zak);
  }
  
  public String getId() {
    return this.zac;
  }
  
  public String getIdToken() {
    return this.zad;
  }
  
  public Uri getPhotoUrl() {
    return this.zag;
  }
  
  public Set<Scope> getRequestedScopes() {
    HashSet<Scope> hashSet = new HashSet<Scope>(this.zak);
    hashSet.addAll(this.zan);
    return hashSet;
  }
  
  public String getServerAuthCode() {
    return this.zah;
  }
  
  public int hashCode() {
    return (this.zaj.hashCode() + 527) * 31 + getRequestedScopes().hashCode();
  }
  
  public boolean isExpired() {
    return (zaa.currentTimeMillis() / 1000L >= this.zai - 300L);
  }
  
  public GoogleSignInAccount requestExtraScopes(Scope... paramVarArgs) {
    if (paramVarArgs != null)
      Collections.addAll(this.zan, paramVarArgs); 
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zab);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDisplayName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, (Parcelable)getPhotoUrl(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, getServerAuthCode(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zai);
    SafeParcelWriter.writeString(paramParcel, 9, this.zaj, false);
    SafeParcelWriter.writeTypedList(paramParcel, 10, this.zak, false);
    SafeParcelWriter.writeString(paramParcel, 11, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 12, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zaa() {
    return this.zaj;
  }
  
  public final String zab() {
    JSONObject jSONObject = zac();
    jSONObject.remove("serverAuthCode");
    return jSONObject.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
  
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  
  public static final Scope zaa = new Scope("profile");
  
  public static final Scope zab = new Scope("email");
  
  public static final Scope zac = new Scope("openid");
  
  public static final Scope zad = new Scope("https://www.googleapis.com/auth/games_lite");
  
  public static final Scope zae = new Scope("https://www.googleapis.com/auth/games");
  
  private static Comparator<Scope> zaq;
  
  private final int zaf;
  
  private final ArrayList<Scope> zag;
  
  private Account zah;
  
  private boolean zai;
  
  private final boolean zaj;
  
  private final boolean zak;
  
  private String zal;
  
  private String zam;
  
  private ArrayList<GoogleSignInOptionsExtensionParcelable> zan;
  
  private String zao;
  
  private Map<Integer, GoogleSignInOptionsExtensionParcelable> zap;
  
  static {
    DEFAULT_SIGN_IN = (new Builder()).requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = (new Builder()).requestScopes(zad, new Scope[0]).build();
    CREATOR = new zad();
    zaq = new zac();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<GoogleSignInOptionsExtensionParcelable> paramArrayList1, String paramString3) {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, zab(paramArrayList1), paramString3);
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, GoogleSignInOptionsExtensionParcelable> paramMap, String paramString3) {
    this.zaf = paramInt;
    this.zag = paramArrayList;
    this.zah = paramAccount;
    this.zai = paramBoolean1;
    this.zaj = paramBoolean2;
    this.zak = paramBoolean3;
    this.zal = paramString1;
    this.zam = paramString2;
    this.zan = new ArrayList<GoogleSignInOptionsExtensionParcelable>(paramMap.values());
    this.zap = paramMap;
    this.zao = paramString3;
  }
  
  public static GoogleSignInOptions zaa(String paramString) throws JSONException {
    boolean bool1 = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool1)
      return null; 
    JSONObject jSONObject = new JSONObject(paramString);
    HashSet<Scope> hashSet = new HashSet();
    JSONArray jSONArray = jSONObject.getJSONArray("scopes");
    int j = jSONArray.length();
    for (int i = 0; i < j; i++)
      hashSet.add(new Scope(jSONArray.getString(i))); 
    if (jSONObject.has("accountName")) {
      String str1 = jSONObject.optString("accountName");
    } else {
      jSONArray = null;
    } 
    if (!TextUtils.isEmpty((CharSequence)jSONArray)) {
      Account account = new Account((String)jSONArray, "com.google");
    } else {
      jSONArray = null;
    } 
    ArrayList<Scope> arrayList = new ArrayList<Scope>(hashSet);
    bool1 = jSONObject.getBoolean("idTokenRequested");
    boolean bool2 = jSONObject.getBoolean("serverAuthRequested");
    boolean bool3 = jSONObject.getBoolean("forceCodeForRefreshToken");
    if (jSONObject.has("serverClientId")) {
      String str1 = jSONObject.optString("serverClientId");
    } else {
      hashSet = null;
    } 
    if (jSONObject.has("hostedDomain"))
      str = jSONObject.optString("hostedDomain"); 
    return new GoogleSignInOptions(3, arrayList, (Account)jSONArray, bool1, bool2, bool3, (String)hashSet, str, new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>(), null);
  }
  
  private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zab(List<GoogleSignInOptionsExtensionParcelable> paramList) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramList == null)
      return (Map)hashMap; 
    for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : paramList)
      hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable); 
    return (Map)hashMap;
  }
  
  private final JSONObject zab() {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONArray jSONArray = new JSONArray();
      Collections.sort(this.zag, zaq);
      ArrayList<Scope> arrayList = this.zag;
      int j = arrayList.size();
      int i = 0;
      while (i < j) {
        Scope scope = (Scope)arrayList.get(i);
        i++;
        jSONArray.put(((Scope)scope).getScopeUri());
      } 
      jSONObject.put("scopes", jSONArray);
      if (this.zah != null)
        jSONObject.put("accountName", this.zah.name); 
      jSONObject.put("idTokenRequested", this.zai);
      jSONObject.put("forceCodeForRefreshToken", this.zak);
      jSONObject.put("serverAuthRequested", this.zaj);
      if (!TextUtils.isEmpty(this.zal))
        jSONObject.put("serverClientId", this.zal); 
      if (!TextUtils.isEmpty(this.zam))
        jSONObject.put("hostedDomain", this.zam); 
      return jSONObject;
    } catch (JSONException jSONException) {
      throw new RuntimeException(jSONException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    try {
      paramObject = paramObject;
      if (this.zan.size() <= 0) {
        if (((GoogleSignInOptions)paramObject).zan.size() > 0)
          return false; 
        if (this.zag.size() == paramObject.getScopes().size()) {
          if (!this.zag.containsAll(paramObject.getScopes()))
            return false; 
          if (((this.zah == null) ? (paramObject.getAccount() == null) : this.zah.equals(paramObject.getAccount())) && (TextUtils.isEmpty(this.zal) ? TextUtils.isEmpty(paramObject.getServerClientId()) : this.zal.equals(paramObject.getServerClientId())) && this.zak == paramObject.isForceCodeForRefreshToken() && this.zai == paramObject.isIdTokenRequested() && this.zaj == paramObject.isServerAuthCodeRequested()) {
            boolean bool = TextUtils.equals(this.zao, paramObject.getLogSessionId());
            if (bool)
              return true; 
          } 
        } 
      } 
      return false;
    } catch (ClassCastException classCastException) {
      return false;
    } 
  }
  
  public Account getAccount() {
    return this.zah;
  }
  
  public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
    return this.zan;
  }
  
  public String getLogSessionId() {
    return this.zao;
  }
  
  public Scope[] getScopeArray() {
    ArrayList<Scope> arrayList = this.zag;
    return arrayList.<Scope>toArray(new Scope[arrayList.size()]);
  }
  
  public ArrayList<Scope> getScopes() {
    return new ArrayList<Scope>(this.zag);
  }
  
  public String getServerClientId() {
    return this.zal;
  }
  
  public int hashCode() {
    ArrayList<String> arrayList = new ArrayList();
    ArrayList<Scope> arrayList1 = this.zag;
    int j = arrayList1.size();
    int i = 0;
    while (i < j) {
      Scope scope = (Scope)arrayList1.get(i);
      i++;
      arrayList.add(((Scope)scope).getScopeUri());
    } 
    Collections.sort(arrayList);
    return (new HashAccumulator()).addObject(arrayList).addObject(this.zah).addObject(this.zal).zaa(this.zak).zaa(this.zai).zaa(this.zaj).addObject(this.zao).hash();
  }
  
  public boolean isForceCodeForRefreshToken() {
    return this.zak;
  }
  
  public boolean isIdTokenRequested() {
    return this.zai;
  }
  
  public boolean isServerAuthCodeRequested() {
    return this.zaj;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaf);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getScopes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getAccount(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, isIdTokenRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isServerAuthCodeRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isForceCodeForRefreshToken());
    SafeParcelWriter.writeString(paramParcel, 7, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zam, false);
    SafeParcelWriter.writeTypedList(paramParcel, 9, getExtensions(), false);
    SafeParcelWriter.writeString(paramParcel, 10, getLogSessionId(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zaa() {
    return zab().toString();
  }
  
  public static final class Builder {
    private Set<Scope> zaa = new HashSet<Scope>();
    
    private boolean zab;
    
    private boolean zac;
    
    private boolean zad;
    
    private String zae;
    
    private Account zaf;
    
    private String zag;
    
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zah = new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>();
    
    private String zai;
    
    public Builder() {}
    
    public Builder(GoogleSignInOptions param1GoogleSignInOptions) {
      Preconditions.checkNotNull(param1GoogleSignInOptions);
      this.zaa = new HashSet<Scope>(GoogleSignInOptions.zaa(param1GoogleSignInOptions));
      this.zab = GoogleSignInOptions.zab(param1GoogleSignInOptions);
      this.zac = GoogleSignInOptions.zac(param1GoogleSignInOptions);
      this.zad = GoogleSignInOptions.zad(param1GoogleSignInOptions);
      this.zae = GoogleSignInOptions.zae(param1GoogleSignInOptions);
      this.zaf = GoogleSignInOptions.zaf(param1GoogleSignInOptions);
      this.zag = GoogleSignInOptions.zag(param1GoogleSignInOptions);
      this.zah = GoogleSignInOptions.zaa(GoogleSignInOptions.zah(param1GoogleSignInOptions));
      this.zai = GoogleSignInOptions.zai(param1GoogleSignInOptions);
    }
    
    private final String zaa(String param1String) {
      Preconditions.checkNotEmpty(param1String);
      String str = this.zae;
      if (str == null || str.equals(param1String)) {
        boolean bool1 = true;
        Preconditions.checkArgument(bool1, "two different server client ids provided");
        return param1String;
      } 
      boolean bool = false;
      Preconditions.checkArgument(bool, "two different server client ids provided");
      return param1String;
    }
    
    public final Builder addExtension(GoogleSignInOptionsExtension param1GoogleSignInOptionsExtension) {
      if (!this.zah.containsKey(Integer.valueOf(param1GoogleSignInOptionsExtension.getExtensionType()))) {
        List<Scope> list = param1GoogleSignInOptionsExtension.getImpliedScopes();
        if (list != null)
          this.zaa.addAll(list); 
        this.zah.put(Integer.valueOf(param1GoogleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(param1GoogleSignInOptionsExtension));
        return this;
      } 
      throw new IllegalStateException("Only one extension per type may be added");
    }
    
    public final GoogleSignInOptions build() {
      if (this.zaa.contains(GoogleSignInOptions.zae) && this.zaa.contains(GoogleSignInOptions.zad))
        this.zaa.remove(GoogleSignInOptions.zad); 
      if (this.zad && (this.zaf == null || !this.zaa.isEmpty()))
        requestId(); 
      return new GoogleSignInOptions(3, new ArrayList<Scope>(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
    }
    
    public final Builder requestEmail() {
      this.zaa.add(GoogleSignInOptions.zab);
      return this;
    }
    
    public final Builder requestId() {
      this.zaa.add(GoogleSignInOptions.zac);
      return this;
    }
    
    public final Builder requestIdToken(String param1String) {
      this.zad = true;
      this.zae = zaa(param1String);
      return this;
    }
    
    public final Builder requestProfile() {
      this.zaa.add(GoogleSignInOptions.zaa);
      return this;
    }
    
    public final Builder requestScopes(Scope param1Scope, Scope... param1VarArgs) {
      this.zaa.add(param1Scope);
      this.zaa.addAll(Arrays.asList(param1VarArgs));
      return this;
    }
    
    public final Builder requestServerAuthCode(String param1String) {
      return requestServerAuthCode(param1String, false);
    }
    
    public final Builder requestServerAuthCode(String param1String, boolean param1Boolean) {
      this.zab = true;
      this.zae = zaa(param1String);
      this.zac = param1Boolean;
      return this;
    }
    
    public final Builder setAccountName(String param1String) {
      this.zaf = new Account(Preconditions.checkNotEmpty(param1String), "com.google");
      return this;
    }
    
    public final Builder setHostedDomain(String param1String) {
      this.zag = Preconditions.checkNotEmpty(param1String);
      return this;
    }
    
    public final Builder setLogSessionId(String param1String) {
      this.zai = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
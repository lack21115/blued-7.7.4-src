package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class ClientSettings {
  @Nullable
  private final Account zaa;
  
  private final Set<Scope> zab;
  
  private final Set<Scope> zac;
  
  private final Map<Api<?>, zaa> zad;
  
  private final int zae;
  
  private final View zaf;
  
  private final String zag;
  
  private final String zah;
  
  private final SignInOptions zai;
  
  private final boolean zaj;
  
  private Integer zak;
  
  public ClientSettings(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zaa> paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions) {
    this(paramAccount, paramSet, paramMap, paramInt, paramView, paramString1, paramString2, paramSignInOptions, false);
  }
  
  public ClientSettings(@Nullable Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zaa> paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions, boolean paramBoolean) {
    Set<Scope> set;
    this.zaa = paramAccount;
    if (paramSet == null) {
      set = Collections.emptySet();
    } else {
      set = Collections.unmodifiableSet(paramSet);
    } 
    this.zab = set;
    Map<Api<?>, zaa> map = paramMap;
    if (paramMap == null)
      map = Collections.emptyMap(); 
    this.zad = map;
    this.zaf = paramView;
    this.zae = paramInt;
    this.zag = paramString1;
    this.zah = paramString2;
    this.zai = paramSignInOptions;
    this.zaj = false;
    HashSet<Scope> hashSet = new HashSet<Scope>(this.zab);
    Iterator iterator = this.zad.values().iterator();
    while (iterator.hasNext())
      hashSet.addAll(((zaa)iterator.next()).zaa); 
    this.zac = Collections.unmodifiableSet(hashSet);
  }
  
  public static ClientSettings createDefault(Context paramContext) {
    return (new GoogleApiClient.Builder(paramContext)).buildClientSettings();
  }
  
  @Nullable
  public final Account getAccount() {
    return this.zaa;
  }
  
  @Deprecated
  @Nullable
  public final String getAccountName() {
    Account account = this.zaa;
    return (account != null) ? account.name : null;
  }
  
  public final Account getAccountOrDefault() {
    Account account = this.zaa;
    return (account != null) ? account : new Account("<<default account>>", "com.google");
  }
  
  public final Set<Scope> getAllRequestedScopes() {
    return this.zac;
  }
  
  public final Set<Scope> getApplicableScopes(Api<?> paramApi) {
    zaa zaa = this.zad.get(paramApi);
    if (zaa == null || zaa.zaa.isEmpty())
      return this.zab; 
    HashSet<Scope> hashSet = new HashSet<Scope>(this.zab);
    hashSet.addAll(zaa.zaa);
    return hashSet;
  }
  
  public final int getGravityForPopups() {
    return this.zae;
  }
  
  @Nullable
  public final String getRealClientPackageName() {
    return this.zag;
  }
  
  public final Set<Scope> getRequiredScopes() {
    return this.zab;
  }
  
  @Nullable
  public final View getViewForPopups() {
    return this.zaf;
  }
  
  public final Map<Api<?>, zaa> zaa() {
    return this.zad;
  }
  
  public final void zaa(Integer paramInteger) {
    this.zak = paramInteger;
  }
  
  @Nullable
  public final String zab() {
    return this.zah;
  }
  
  public final SignInOptions zac() {
    return this.zai;
  }
  
  @Nullable
  public final Integer zad() {
    return this.zak;
  }
  
  public final boolean zae() {
    return this.zaj;
  }
  
  public static final class Builder {
    @Nullable
    private Account zaa;
    
    private ArraySet<Scope> zab;
    
    private int zac = 0;
    
    private String zad;
    
    private String zae;
    
    private SignInOptions zaf = SignInOptions.zaa;
    
    public final ClientSettings build() {
      return new ClientSettings(this.zaa, (Set<Scope>)this.zab, null, 0, null, this.zad, this.zae, this.zaf, false);
    }
    
    public final Builder setRealClientPackageName(String param1String) {
      this.zad = param1String;
      return this;
    }
    
    public final Builder zaa(@Nullable Account param1Account) {
      this.zaa = param1Account;
      return this;
    }
    
    public final Builder zaa(String param1String) {
      this.zae = param1String;
      return this;
    }
    
    public final Builder zaa(Collection<Scope> param1Collection) {
      if (this.zab == null)
        this.zab = new ArraySet(); 
      this.zab.addAll(param1Collection);
      return this;
    }
  }
  
  public static final class zaa {
    public final Set<Scope> zaa;
    
    public zaa(Set<Scope> param1Set) {
      Preconditions.checkNotNull(param1Set);
      this.zaa = Collections.unmodifiableSet(param1Set);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\ClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
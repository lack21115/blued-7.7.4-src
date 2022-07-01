package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker {
  @Deprecated
  public static Intent newChooseAccountIntent(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle) {
    Intent intent = new Intent();
    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    intent.setPackage("com.google.android.gms");
    intent.putExtra("allowableAccounts", paramArrayList);
    intent.putExtra("allowableAccountTypes", paramArrayOfString1);
    intent.putExtra("addAccountOptions", paramBundle);
    intent.putExtra("selectedAccount", (Parcelable)paramAccount);
    intent.putExtra("alwaysPromptForAccount", paramBoolean);
    intent.putExtra("descriptionTextOverride", paramString1);
    intent.putExtra("authTokenType", paramString2);
    intent.putExtra("addAccountRequiredFeatures", paramArrayOfString2);
    intent.putExtra("setGmsCoreAccount", false);
    intent.putExtra("overrideTheme", 0);
    intent.putExtra("overrideCustomTheme", 0);
    intent.putExtra("hostedDomainFilter", null);
    return intent;
  }
  
  public static Intent newChooseAccountIntent(AccountChooserOptions paramAccountChooserOptions) {
    String str;
    Intent intent = new Intent();
    boolean bool = AccountChooserOptions.zza(paramAccountChooserOptions);
    byte b = 0;
    if (!bool) {
      if (AccountChooserOptions.zzb(paramAccountChooserOptions) == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "We only support hostedDomain filter for account chip styled account picker");
      if (AccountChooserOptions.zzc(paramAccountChooserOptions) == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Consent is only valid for account chip styled account picker");
    } 
    if (AccountChooserOptions.zza(paramAccountChooserOptions)) {
      str = "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE";
    } else {
      str = "com.google.android.gms.common.account.CHOOSE_ACCOUNT";
    } 
    intent.setAction(str);
    intent.setPackage("com.google.android.gms");
    intent.putExtra("allowableAccounts", AccountChooserOptions.zzd(paramAccountChooserOptions));
    if (AccountChooserOptions.zze(paramAccountChooserOptions) != null)
      intent.putExtra("allowableAccountTypes", (String[])AccountChooserOptions.zze(paramAccountChooserOptions).toArray((Object[])new String[0])); 
    intent.putExtra("addAccountOptions", AccountChooserOptions.zzf(paramAccountChooserOptions));
    intent.putExtra("selectedAccount", (Parcelable)AccountChooserOptions.zzg(paramAccountChooserOptions));
    intent.putExtra("alwaysPromptForAccount", AccountChooserOptions.zzh(paramAccountChooserOptions));
    intent.putExtra("descriptionTextOverride", AccountChooserOptions.zzi(paramAccountChooserOptions));
    intent.putExtra("setGmsCoreAccount", AccountChooserOptions.zzj(paramAccountChooserOptions));
    intent.putExtra("realClientPackage", AccountChooserOptions.zzk(paramAccountChooserOptions));
    intent.putExtra("overrideTheme", AccountChooserOptions.zzl(paramAccountChooserOptions));
    if (AccountChooserOptions.zza(paramAccountChooserOptions))
      b = 2; 
    intent.putExtra("overrideCustomTheme", b);
    intent.putExtra("hostedDomainFilter", AccountChooserOptions.zzb(paramAccountChooserOptions));
    Bundle bundle = new Bundle();
    if (AccountChooserOptions.zza(paramAccountChooserOptions) && !TextUtils.isEmpty(AccountChooserOptions.zzi(paramAccountChooserOptions)))
      bundle.putString("title", AccountChooserOptions.zzi(paramAccountChooserOptions)); 
    if (AccountChooserOptions.zzc(paramAccountChooserOptions) != null) {
      bundle.putBoolean("should_show_consent", true);
      bundle.putString("privacy_policy_url", null);
      bundle.putString("terms_of_service_url", null);
    } 
    if (AccountChooserOptions.zzm(paramAccountChooserOptions))
      bundle.putBoolean("exclude_add_account", true); 
    if (!bundle.isEmpty())
      intent.putExtra("first_party_options_bundle", bundle); 
    return intent;
  }
  
  public static class AccountChooserOptions {
    private Account zza;
    
    private ArrayList<Account> zzb;
    
    private ArrayList<String> zzc;
    
    private boolean zzd;
    
    private String zze;
    
    private Bundle zzf;
    
    private boolean zzg;
    
    private int zzh;
    
    private String zzi;
    
    private boolean zzj;
    
    private zza zzk;
    
    private String zzl;
    
    private boolean zzm;
    
    public static class Builder {
      private Account zza;
      
      private ArrayList<Account> zzb;
      
      private ArrayList<String> zzc;
      
      private boolean zzd = false;
      
      private String zze;
      
      private Bundle zzf;
      
      private boolean zzg = false;
      
      private int zzh = 0;
      
      private boolean zzi = false;
      
      public AccountPicker.AccountChooserOptions build() {
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        AccountPicker.AccountChooserOptions accountChooserOptions = new AccountPicker.AccountChooserOptions();
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zzc);
        AccountPicker.AccountChooserOptions.zzb(accountChooserOptions, this.zzb);
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zzd);
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, (AccountPicker.AccountChooserOptions.zza)null);
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, (String)null);
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zzf);
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zza);
        AccountPicker.AccountChooserOptions.zzb(accountChooserOptions, false);
        AccountPicker.AccountChooserOptions.zzb(accountChooserOptions, (String)null);
        AccountPicker.AccountChooserOptions.zza(accountChooserOptions, 0);
        AccountPicker.AccountChooserOptions.zzc(accountChooserOptions, this.zze);
        AccountPicker.AccountChooserOptions.zzc(accountChooserOptions, false);
        AccountPicker.AccountChooserOptions.zzd(accountChooserOptions, false);
        return accountChooserOptions;
      }
      
      public Builder setAllowableAccounts(List<Account> param2List) {
        if (param2List == null) {
          param2List = null;
        } else {
          param2List = new ArrayList<Account>(param2List);
        } 
        this.zzb = (ArrayList<Account>)param2List;
        return this;
      }
      
      public Builder setAllowableAccountsTypes(List<String> param2List) {
        if (param2List == null) {
          param2List = null;
        } else {
          param2List = new ArrayList<String>(param2List);
        } 
        this.zzc = (ArrayList<String>)param2List;
        return this;
      }
      
      public Builder setAlwaysShowAccountPicker(boolean param2Boolean) {
        this.zzd = param2Boolean;
        return this;
      }
      
      public Builder setOptionsForAddingAccount(Bundle param2Bundle) {
        this.zzf = param2Bundle;
        return this;
      }
      
      public Builder setSelectedAccount(Account param2Account) {
        this.zza = param2Account;
        return this;
      }
      
      public Builder setTitleOverrideText(String param2String) {
        this.zze = param2String;
        return this;
      }
    }
    
    public static final class zza {}
  }
  
  public static class Builder {
    private Account zza;
    
    private ArrayList<Account> zzb;
    
    private ArrayList<String> zzc;
    
    private boolean zzd = false;
    
    private String zze;
    
    private Bundle zzf;
    
    private boolean zzg = false;
    
    private int zzh = 0;
    
    private boolean zzi = false;
    
    public AccountPicker.AccountChooserOptions build() {
      Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
      Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
      AccountPicker.AccountChooserOptions accountChooserOptions = new AccountPicker.AccountChooserOptions();
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zzc);
      AccountPicker.AccountChooserOptions.zzb(accountChooserOptions, this.zzb);
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zzd);
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, (AccountPicker.AccountChooserOptions.zza)null);
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, (String)null);
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zzf);
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, this.zza);
      AccountPicker.AccountChooserOptions.zzb(accountChooserOptions, false);
      AccountPicker.AccountChooserOptions.zzb(accountChooserOptions, (String)null);
      AccountPicker.AccountChooserOptions.zza(accountChooserOptions, 0);
      AccountPicker.AccountChooserOptions.zzc(accountChooserOptions, this.zze);
      AccountPicker.AccountChooserOptions.zzc(accountChooserOptions, false);
      AccountPicker.AccountChooserOptions.zzd(accountChooserOptions, false);
      return accountChooserOptions;
    }
    
    public Builder setAllowableAccounts(List<Account> param1List) {
      if (param1List == null) {
        param1List = null;
      } else {
        param1List = new ArrayList<Account>(param1List);
      } 
      this.zzb = (ArrayList<Account>)param1List;
      return this;
    }
    
    public Builder setAllowableAccountsTypes(List<String> param1List) {
      if (param1List == null) {
        param1List = null;
      } else {
        param1List = new ArrayList<String>(param1List);
      } 
      this.zzc = (ArrayList<String>)param1List;
      return this;
    }
    
    public Builder setAlwaysShowAccountPicker(boolean param1Boolean) {
      this.zzd = param1Boolean;
      return this;
    }
    
    public Builder setOptionsForAddingAccount(Bundle param1Bundle) {
      this.zzf = param1Bundle;
      return this;
    }
    
    public Builder setSelectedAccount(Account param1Account) {
      this.zza = param1Account;
      return this;
    }
    
    public Builder setTitleOverrideText(String param1String) {
      this.zze = param1String;
      return this;
    }
  }
  
  public static final class zza {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\AccountPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
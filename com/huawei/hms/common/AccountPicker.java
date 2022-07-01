package com.huawei.hms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

public final class AccountPicker {
  public static final String CHOOSE_ACCOUNT = "com.huawei.hms.common.account.CHOOSE_ACCOUNT";
  
  public static final int CUSTOM_THEME_ACCOUNT_CHIPS = 2;
  
  public static final int CUSTOM_THEME_GAMES = 1;
  
  public static final int CUSTOM_THEME_NONE = 0;
  
  public static final String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
  
  public static final String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
  
  public static final String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
  
  public static final String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
  
  public static final String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
  
  public static final String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
  
  public static final String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
  
  public static final String EXTRA_HOSTED_DOMAIN_FILTER = "hostedDomainFilter";
  
  public static final String EXTRA_IS_ACCOUNT_CHIPS_ACCOUNT_PICKER = "pickedFromAccountChips";
  
  public static final String EXTRA_OVERRIDE_CUSTOM_THEME = "overrideCustomTheme";
  
  public static final String EXTRA_OVERRIDE_THEME = "overrideTheme";
  
  public static final String EXTRA_REAL_CLIENT_PACKAGE = "realClientPackage";
  
  public static final String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
  
  public static final String EXTRA_SET_HMS_CORE_ACCOUNT = "setHmsCoreAccount";
  
  private static final String HMS_PACKAGE = "com.huawei.hms";
  
  public static final int THEME_DEFAULT = 0;
  
  public static final int THEME_LIGHT = 1;
  
  public static Intent newChooseAccountIntent(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle) {
    Intent intent = new Intent();
    intent.setAction("com.huawei.hms.common.account.CHOOSE_ACCOUNT");
    intent.setPackage("com.huawei.hms");
    intent.putExtra("allowableAccounts", paramArrayList);
    intent.putExtra("allowableAccountTypes", paramArrayOfString1);
    intent.putExtra("addAccountOptions", paramBundle);
    intent.putExtra("selectedAccount", (Parcelable)paramAccount);
    intent.putExtra("alwaysPromptForAccount", paramBoolean);
    intent.putExtra("descriptionTextOverride", paramString1);
    intent.putExtra("authTokenType", paramString2);
    intent.putExtra("addAccountRequiredFeatures", paramArrayOfString2);
    intent.putExtra("setHmsCoreAccount", false);
    intent.putExtra("overrideTheme", 0);
    intent.putExtra("overrideCustomTheme", 0);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\AccountPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
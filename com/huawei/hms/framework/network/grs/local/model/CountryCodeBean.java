package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import java.util.Locale;

public class CountryCodeBean {
  private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
  
  private static final int COUNTRYCODE_SIZE = 2;
  
  private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
  
  private static final String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
  
  private static final String SPECIAL_COUNTRYCODE_CN = "cn";
  
  private static final String SPECIAL_COUNTRYCODE_EU = "eu";
  
  private static final String SPECIAL_COUNTRYCODE_LA = "la";
  
  private static final String TAG = "CountryCodeBean";
  
  private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
  
  private String countryCode = "UNKNOWN";
  
  private String countrySource = "UNKNOWN";
  
  public CountryCodeBean(Context paramContext, boolean paramBoolean) {
    init(paramContext, paramBoolean);
    this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
  }
  
  private void checkCodeLenth() {
    String str = this.countryCode;
    if (str == null || str.length() != 2) {
      this.countryCode = "UNKNOWN";
      this.countrySource = "UNKNOWN";
    } 
  }
  
  private void getLocaleCountryCode() {
    if (CreateFileUtil.isPVersion()) {
      getRegionSettingCountryCode();
    } else {
      getProductCountryCode();
    } 
    this.countrySource = "LOCALE_INFO";
  }
  
  private void getProductCountryCode() {
    this.countryCode = SystemPropUtils.getProperty("get", "ro.product.locale.region", "android.os.SystemProperties", "UNKNOWN");
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("countryCode by ro.product.locale.region is:");
    stringBuilder.append(this.countryCode);
    Logger.i(str, stringBuilder.toString());
    if (TextUtils.isEmpty(this.countryCode) || "UNKNOWN".equals(this.countryCode)) {
      str = SystemPropUtils.getProperty("get", "ro.product.locale", "android.os.SystemProperties", "UNKNOWN");
      if (!TextUtils.isEmpty(str)) {
        int i = str.lastIndexOf("-");
        if (i != -1) {
          this.countryCode = str.substring(i + 1);
          str = TAG;
          stringBuilder = new StringBuilder();
          stringBuilder.append("countryCode by ro.product.locale is:");
          stringBuilder.append(this.countryCode);
          Logger.i(str, stringBuilder.toString());
        } 
      } 
    } 
    if (!"cn".equalsIgnoreCase(this.countryCode))
      this.countryCode = "UNKNOWN"; 
  }
  
  private void getRegionSettingCountryCode() {
    this.countryCode = Locale.getDefault().getCountry();
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("countryCode by system's region setting is: ");
    stringBuilder.append(this.countryCode);
    Logger.i(str, stringBuilder.toString());
    if (TextUtils.isEmpty(this.countryCode))
      this.countryCode = "UNKNOWN"; 
  }
  
  private void getSimCountryCode(Context paramContext) {
    getSimCountryCode(paramContext, false);
  }
  
  private void getSimCountryCode(Context paramContext, boolean paramBoolean) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (telephonyManager != null) {
      String str1;
      String str2;
      StringBuilder stringBuilder;
      if (paramBoolean && telephonyManager.getPhoneType() != 2) {
        this.countryCode = telephonyManager.getNetworkCountryIso();
        this.countrySource = "NETWORK_COUNTRY";
        str2 = TAG;
        stringBuilder = new StringBuilder();
        str1 = "countryCode by NetworkCountryIso is: ";
      } else {
        this.countryCode = str1.getSimCountryIso();
        this.countrySource = "SIM_COUNTRY";
        str2 = TAG;
        stringBuilder = new StringBuilder();
        str1 = "countryCode by SimCountryIso is: ";
      } 
      stringBuilder.append(str1);
      stringBuilder.append(this.countryCode);
      Logger.i(str2, stringBuilder.toString());
    } 
    checkCodeLenth();
  }
  
  private void getVendorCountryCode() {
    this.countrySource = "VENDOR_COUNTRY";
    this.countryCode = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("countryCode by ro.hw.country is: ");
    stringBuilder.append(this.countryCode);
    Logger.i(str, stringBuilder.toString());
    if ("eu".equalsIgnoreCase(this.countryCode) || "la".equalsIgnoreCase(this.countryCode)) {
      this.countryCode = "UNKNOWN";
      this.countrySource = "UNKNOWN";
      return;
    } 
    checkCodeLenth();
  }
  
  private void init(Context paramContext, boolean paramBoolean) {
    if (paramContext != null) {
      try {
        String str;
        getVendorCountryCode();
        if (isCodeValidate()) {
          str = TAG;
          Logger.i(str, "get issue_country code from VENDOR_COUNTRY");
          return;
        } 
        getSimCountryCode((Context)str);
        if (isCodeValidate()) {
          str = TAG;
          Logger.i(str, "get issue_country code from SIM_COUNTRY");
          return;
        } 
        getLocaleCountryCode();
        if (isCodeValidate()) {
          str = TAG;
          Logger.i(str, "get issue_country code from LOCALE_INFO");
          return;
        } 
      } catch (Exception exception) {
        Logger.w(TAG, "get CountryCode error");
      } 
      return;
    } 
    throw new NullPointerException("context must be not null.Please provide app's Context");
  }
  
  private boolean isCodeValidate() {
    return "UNKNOWN".equals(this.countryCode) ^ true;
  }
  
  public String getCountryCode() {
    return this.countryCode;
  }
  
  public String getCountrySource() {
    return this.countrySource;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\local\model\CountryCodeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
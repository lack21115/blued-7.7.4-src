package com.geetest.onelogin.config;

import android.graphics.Typeface;
import com.geetest.onelogin.a.a;

public class OneLoginThemeConfig extends a {
  private String authBGImgPath;
  
  private String authBgVideoUri;
  
  private boolean authNavGone;
  
  private int authNavHeight;
  
  private boolean authNavTransparent;
  
  private int baseClauseColor;
  
  private String checkedImgPath;
  
  private int clauseColor;
  
  private String clause_name;
  
  private String clause_name_three;
  
  private String clause_name_two;
  
  private String clause_url;
  
  private String clause_url_three;
  
  private String clause_url_two;
  
  private int dialogHeight;
  
  private int dialogWidth;
  
  private int dialogX;
  
  private int dialogY;
  
  private boolean disableBtnIfUnChecked;
  
  private boolean isDialogBottom;
  
  private boolean isDialogTheme;
  
  private boolean isLightColor;
  
  private boolean isUseNormalWebActivity;
  
  private boolean isWebViewDialogTheme;
  
  private String loadingView;
  
  private boolean loadingViewCenterInVertical;
  
  private int loadingViewHeight;
  
  private int loadingViewOffsetRight;
  
  private int loadingViewOffsetY;
  
  private int loadingViewWidth;
  
  private int logBtnHeight;
  
  private int logBtnOffsetX;
  
  private int logBtnOffsetY;
  
  private int logBtnOffsetY_B;
  
  private int logBtnTextSize;
  
  private Typeface logBtnTextViewTypeface;
  
  private int logBtnWidth;
  
  private int loginButtonColor;
  
  private String loginButtonText;
  
  private String loginImgPath;
  
  private int logoHeight;
  
  private boolean logoHidden;
  
  private String logoImgPath;
  
  private int logoOffsetX;
  
  private int logoOffsetY;
  
  private int logoOffsetY_B;
  
  private int logoWidth;
  
  private int navColor;
  
  private boolean navReturnImgHidden;
  
  private String navReturnImgPath;
  
  private String navText;
  
  private int navTextColor;
  
  private boolean navTextNormal;
  
  private int navTextSize;
  
  private Typeface navTextTypeface;
  
  private String navWebViewText;
  
  private int navWebViewTextColor;
  
  private int navWebViewTextSize;
  
  private Typeface navWebViewTextTypeface;
  
  private int navigationBarColor;
  
  private int numFieldOffsetX;
  
  private int numFieldOffsetY;
  
  private int numFieldOffsetY_B;
  
  private int numberColor;
  
  private int numberSize;
  
  private Typeface numberViewTypeface;
  
  private boolean privacyAddFrenchQuotes;
  
  private int privacyCheckBoxHeight;
  
  private int privacyCheckBoxOffsetY;
  
  private int privacyCheckBoxWidth;
  
  private Typeface privacyClauseBaseTextViewTypeface;
  
  private int privacyClauseTextSize;
  
  private String[] privacyClauseTextStrings;
  
  private Typeface privacyClauseTextViewTypeface;
  
  private int privacyLayoutWidth;
  
  private int privacyOffsetX;
  
  private int privacyOffsetY;
  
  private int privacyOffsetY_B;
  
  private boolean privacyState;
  
  private int privacyTextGravity;
  
  private String privacyTextViewTv1;
  
  private String privacyTextViewTv2;
  
  private String privacyTextViewTv3;
  
  private String privacyTextViewTv4;
  
  private String privacyUnCheckedToastText;
  
  private boolean returnImgCenterInVertical;
  
  private int returnImgHeight;
  
  private int returnImgOffsetX;
  
  private int returnImgOffsetY;
  
  private int returnImgWidth;
  
  private int sloganColor;
  
  private int sloganOffsetX;
  
  private int sloganOffsetY;
  
  private int sloganOffsetY_B;
  
  private int sloganSize;
  
  private Typeface sloganViewTypeface;
  
  private int statusBarColor;
  
  private boolean switchAccHidden;
  
  private int switchAccOffsetY;
  
  private int switchColor;
  
  private int switchHeight;
  
  private String switchImgPath;
  
  private int switchOffsetX;
  
  private int switchOffsetY_B;
  
  private int switchSize;
  
  private String switchText;
  
  private Typeface switchViewTypeface;
  
  private int switchWidth;
  
  private String unCheckedImgPath;
  
  private OneLoginThemeConfig(Builder paramBuilder) {
    this.navColor = paramBuilder.navColor;
    this.clause_name = paramBuilder.clause_name;
    this.clause_url = paramBuilder.clause_url;
    this.clause_name_two = paramBuilder.clause_name_two;
    this.clause_url_two = paramBuilder.clause_url_two;
    this.privacyOffsetY = paramBuilder.privacyOffsetY;
    this.privacyOffsetY_B = paramBuilder.privacyOffsetY_B;
    this.switchText = paramBuilder.switchText;
    this.switchSize = paramBuilder.switchSize;
    this.switchOffsetX = paramBuilder.switchOffsetX;
    this.switchAccHidden = paramBuilder.switchAccHidden;
    this.switchAccOffsetY = paramBuilder.switchAccOffsetY;
    this.switchOffsetY_B = paramBuilder.switchOffsetY_B;
    this.switchImgPath = paramBuilder.switchImgPath;
    this.switchWidth = paramBuilder.switchWidth;
    this.switchHeight = paramBuilder.switchHeight;
    this.logBtnOffsetY = paramBuilder.logBtnOffsetY;
    this.logBtnOffsetY_B = paramBuilder.logBtnOffsetY_B;
    this.sloganOffsetY = paramBuilder.sloganOffsetY;
    this.sloganOffsetY_B = paramBuilder.sloganOffsetY_B;
    this.numberSize = paramBuilder.numberSize;
    this.numFieldOffsetY = paramBuilder.numFieldOffsetY;
    this.numFieldOffsetY_B = paramBuilder.numFieldOffsetY_B;
    this.logoHidden = paramBuilder.logoHidden;
    this.navText = paramBuilder.navText;
    this.navTextColor = paramBuilder.navTextColor;
    this.logoImgPath = paramBuilder.logoImgPath;
    this.logoWidth = paramBuilder.logoWidth;
    this.logoHeight = paramBuilder.logoHeight;
    this.navReturnImgPath = paramBuilder.navReturnImgPath;
    this.logoOffsetY = paramBuilder.logoOffsetY;
    this.logoOffsetY_B = paramBuilder.logoOffsetY_B;
    this.numberColor = paramBuilder.numberColor;
    this.sloganColor = paramBuilder.sloganColor;
    this.switchColor = paramBuilder.switchColor;
    this.loginButtonText = paramBuilder.loginButtonText;
    this.loginButtonColor = paramBuilder.loginButtonColor;
    this.loginImgPath = paramBuilder.loginImgPath;
    this.baseClauseColor = paramBuilder.baseClauseColor;
    this.clauseColor = paramBuilder.clauseColor;
    this.unCheckedImgPath = paramBuilder.unCheckedImgPath;
    this.checkedImgPath = paramBuilder.checkedImgPath;
    this.authNavTransparent = paramBuilder.authNavTransparent;
    this.authBGImgPath = paramBuilder.authBGImgPath;
    this.authBgVideoUri = paramBuilder.authBgVideoUri;
    this.privacyState = paramBuilder.privacyState;
    this.isDialogTheme = paramBuilder.isDialogTheme;
    this.dialogWidth = paramBuilder.dialogWidth;
    this.dialogHeight = paramBuilder.dialogHeight;
    this.dialogX = paramBuilder.dialogX;
    this.dialogY = paramBuilder.dialogY;
    this.isDialogBottom = paramBuilder.isDialogBottom;
    this.loadingView = paramBuilder.loadingView;
    this.loadingViewWidth = paramBuilder.loadingViewWidth;
    this.loadingViewHeight = paramBuilder.loadingViewHeight;
    this.statusBarColor = paramBuilder.statusBarColor;
    this.isLightColor = paramBuilder.isLightColor;
    this.returnImgWidth = paramBuilder.returnImgWidth;
    this.returnImgHeight = paramBuilder.returnImgHeight;
    this.navReturnImgHidden = paramBuilder.navReturnImgHidden;
    this.navTextSize = paramBuilder.navTextSize;
    this.authNavGone = paramBuilder.authNavGone;
    this.authNavHeight = paramBuilder.authNavHeight;
    this.returnImgOffsetX = paramBuilder.returnImgOffsetX;
    this.returnImgCenterInVertical = paramBuilder.returnImgCenterInVertical;
    this.returnImgOffsetY = paramBuilder.returnImgOffsetY;
    this.logoOffsetX = paramBuilder.logoOffsetX;
    this.numFieldOffsetX = paramBuilder.numFieldOffsetX;
    this.logBtnWidth = paramBuilder.logBtnWidth;
    this.logBtnHeight = paramBuilder.logBtnHeight;
    this.logBtnTextSize = paramBuilder.logBtnTextSize;
    this.logBtnOffsetX = paramBuilder.logBtnOffsetX;
    this.disableBtnIfUnChecked = paramBuilder.disableBtnIfUnChecked;
    this.loadingViewOffsetRight = paramBuilder.loadingViewOffsetRight;
    this.loadingViewCenterInVertical = paramBuilder.loadingViewCenterInVertical;
    this.loadingViewOffsetY = paramBuilder.loadingViewOffsetY;
    this.sloganSize = paramBuilder.sloganSize;
    this.sloganOffsetX = paramBuilder.sloganOffsetX;
    this.privacyLayoutWidth = paramBuilder.privacyLayoutWidth;
    this.privacyOffsetX = paramBuilder.privacyOffsetX;
    this.privacyCheckBoxWidth = paramBuilder.privacyCheckBoxWidth;
    this.privacyCheckBoxHeight = paramBuilder.privacyCheckBoxHeight;
    this.privacyCheckBoxOffsetY = paramBuilder.privacyCheckBoxOffsetY;
    this.privacyClauseTextSize = paramBuilder.privacyClauseTextSize;
    this.privacyTextViewTv1 = paramBuilder.privacyTextViewTv1;
    this.privacyTextViewTv2 = paramBuilder.privacyTextViewTv2;
    this.privacyTextViewTv3 = paramBuilder.privacyTextViewTv3;
    this.privacyTextViewTv4 = paramBuilder.privacyTextViewTv4;
    this.clause_name_three = paramBuilder.clause_name_three;
    this.clause_url_three = paramBuilder.clause_url_three;
    this.isWebViewDialogTheme = paramBuilder.isWebViewDialogTheme;
    this.navWebViewTextSize = paramBuilder.navWebViewTextSize;
    this.navTextNormal = paramBuilder.navTextNormal;
    this.navWebViewText = paramBuilder.navWebViewText;
    this.navWebViewTextColor = paramBuilder.navWebViewTextColor;
    this.navigationBarColor = paramBuilder.navigationBarColor;
    this.isUseNormalWebActivity = paramBuilder.isUseNormalWebActivity;
    this.navTextTypeface = paramBuilder.navTextTypeface;
    this.navWebViewTextTypeface = paramBuilder.navWebViewTextTypeface;
    this.numberViewTypeface = paramBuilder.numberViewTypeface;
    this.switchViewTypeface = paramBuilder.switchViewTypeface;
    this.logBtnTextViewTypeface = paramBuilder.logBtnTextViewTypeface;
    this.sloganViewTypeface = paramBuilder.sloganViewTypeface;
    this.privacyClauseBaseTextViewTypeface = paramBuilder.privacyClauseBaseTextViewTypeface;
    this.privacyClauseTextViewTypeface = paramBuilder.privacyClauseTextViewTypeface;
    this.privacyTextGravity = paramBuilder.privacyTextGravity;
    this.privacyUnCheckedToastText = paramBuilder.privacyUnCheckedToastText;
    this.privacyClauseTextStrings = paramBuilder.privacyClauseTextStrings;
    this.privacyAddFrenchQuotes = paramBuilder.privacyAddFrenchQuotes;
  }
  
  public String getAuthBGImgPath() {
    return this.authBGImgPath;
  }
  
  public String getAuthBgVideoUri() {
    return this.authBgVideoUri;
  }
  
  public int getAuthNavHeight() {
    return this.authNavHeight;
  }
  
  public int getBaseClauseColor() {
    return this.baseClauseColor;
  }
  
  public String getCheckedImgPath() {
    return this.checkedImgPath;
  }
  
  public int getClauseColor() {
    return this.clauseColor;
  }
  
  public String getClause_name() {
    return this.clause_name;
  }
  
  public String getClause_name_three() {
    return this.clause_name_three;
  }
  
  public String getClause_name_two() {
    return this.clause_name_two;
  }
  
  public String getClause_url() {
    return this.clause_url;
  }
  
  public String getClause_url_three() {
    return this.clause_url_three;
  }
  
  public String getClause_url_two() {
    return this.clause_url_two;
  }
  
  public int getDialogHeight() {
    return this.dialogHeight;
  }
  
  public int getDialogWidth() {
    return this.dialogWidth;
  }
  
  public int getDialogX() {
    return this.dialogX;
  }
  
  public int getDialogY() {
    return this.dialogY;
  }
  
  public String getLoadingView() {
    return this.loadingView;
  }
  
  public int getLoadingViewHeight() {
    return this.loadingViewHeight;
  }
  
  public int getLoadingViewOffsetRight() {
    return this.loadingViewOffsetRight;
  }
  
  public int getLoadingViewOffsetY() {
    return this.loadingViewOffsetY;
  }
  
  public int getLoadingViewWidth() {
    return this.loadingViewWidth;
  }
  
  public int getLogBtnHeight() {
    return this.logBtnHeight;
  }
  
  public int getLogBtnOffsetX() {
    return this.logBtnOffsetX;
  }
  
  public int getLogBtnOffsetY() {
    return this.logBtnOffsetY;
  }
  
  public int getLogBtnOffsetY_B() {
    return this.logBtnOffsetY_B;
  }
  
  public int getLogBtnTextSize() {
    return this.logBtnTextSize;
  }
  
  public Typeface getLogBtnTextViewTypeface() {
    return this.logBtnTextViewTypeface;
  }
  
  public int getLogBtnWidth() {
    return this.logBtnWidth;
  }
  
  public int getLoginButtonColor() {
    return this.loginButtonColor;
  }
  
  public String getLoginButtonText() {
    return this.loginButtonText;
  }
  
  public String getLoginImgPath() {
    return this.loginImgPath;
  }
  
  public int getLogoHeight() {
    return this.logoHeight;
  }
  
  public String getLogoImgPath() {
    return this.logoImgPath;
  }
  
  public int getLogoOffsetX() {
    return this.logoOffsetX;
  }
  
  public int getLogoOffsetY() {
    return this.logoOffsetY;
  }
  
  public int getLogoOffsetY_B() {
    return this.logoOffsetY_B;
  }
  
  public int getLogoWidth() {
    return this.logoWidth;
  }
  
  public int getNavColor() {
    return this.navColor;
  }
  
  public String getNavReturnImgPath() {
    return this.navReturnImgPath;
  }
  
  public String getNavText() {
    return this.navText;
  }
  
  public int getNavTextColor() {
    return this.navTextColor;
  }
  
  public int getNavTextSize() {
    return this.navTextSize;
  }
  
  public Typeface getNavTextTypeface() {
    return this.navTextTypeface;
  }
  
  public String getNavWebViewText() {
    return this.navWebViewText;
  }
  
  public int getNavWebViewTextColor() {
    return this.navWebViewTextColor;
  }
  
  public int getNavWebViewTextSize() {
    return this.navWebViewTextSize;
  }
  
  public Typeface getNavWebViewTextTypeface() {
    return this.navWebViewTextTypeface;
  }
  
  public int getNavigationBarColor() {
    return this.navigationBarColor;
  }
  
  public int getNumFieldOffsetX() {
    return this.numFieldOffsetX;
  }
  
  public int getNumFieldOffsetY() {
    return this.numFieldOffsetY;
  }
  
  public int getNumFieldOffsetY_B() {
    return this.numFieldOffsetY_B;
  }
  
  public int getNumberColor() {
    return this.numberColor;
  }
  
  public int getNumberSize() {
    return this.numberSize;
  }
  
  public Typeface getNumberViewTypeface() {
    return this.numberViewTypeface;
  }
  
  public int getPrivacyCheckBoxHeight() {
    return this.privacyCheckBoxHeight;
  }
  
  public int getPrivacyCheckBoxOffsetY() {
    return this.privacyCheckBoxOffsetY;
  }
  
  public int getPrivacyCheckBoxWidth() {
    return this.privacyCheckBoxWidth;
  }
  
  public Typeface getPrivacyClauseBaseTextViewTypeface() {
    return this.privacyClauseBaseTextViewTypeface;
  }
  
  public int getPrivacyClauseTextSize() {
    return this.privacyClauseTextSize;
  }
  
  public String[] getPrivacyClauseTextStrings() {
    return this.privacyClauseTextStrings;
  }
  
  public Typeface getPrivacyClauseTextViewTypeface() {
    return this.privacyClauseTextViewTypeface;
  }
  
  public int getPrivacyLayoutWidth() {
    return this.privacyLayoutWidth;
  }
  
  public int getPrivacyOffsetX() {
    return this.privacyOffsetX;
  }
  
  public int getPrivacyOffsetY() {
    return this.privacyOffsetY;
  }
  
  public int getPrivacyOffsetY_B() {
    return this.privacyOffsetY_B;
  }
  
  public int getPrivacyTextGravity() {
    return this.privacyTextGravity;
  }
  
  public String getPrivacyTextViewTv1() {
    return this.privacyTextViewTv1;
  }
  
  public String getPrivacyTextViewTv2() {
    return this.privacyTextViewTv2;
  }
  
  public String getPrivacyTextViewTv3() {
    return this.privacyTextViewTv3;
  }
  
  public String getPrivacyTextViewTv4() {
    return this.privacyTextViewTv4;
  }
  
  public String getPrivacyUnCheckedToastText() {
    return this.privacyUnCheckedToastText;
  }
  
  public int getReturnImgHeight() {
    return this.returnImgHeight;
  }
  
  public int getReturnImgOffsetX() {
    return this.returnImgOffsetX;
  }
  
  public int getReturnImgOffsetY() {
    return this.returnImgOffsetY;
  }
  
  public int getReturnImgWidth() {
    return this.returnImgWidth;
  }
  
  public int getSloganColor() {
    return this.sloganColor;
  }
  
  public int getSloganOffsetX() {
    return this.sloganOffsetX;
  }
  
  public int getSloganOffsetY() {
    return this.sloganOffsetY;
  }
  
  public int getSloganOffsetY_B() {
    return this.sloganOffsetY_B;
  }
  
  public int getSloganSize() {
    return this.sloganSize;
  }
  
  public Typeface getSloganViewTypeface() {
    return this.sloganViewTypeface;
  }
  
  public int getStatusBarColor() {
    return this.statusBarColor;
  }
  
  public int getSwitchAccOffsetY() {
    return this.switchAccOffsetY;
  }
  
  public int getSwitchColor() {
    return this.switchColor;
  }
  
  public int getSwitchHeight() {
    return this.switchHeight;
  }
  
  public String getSwitchImgPath() {
    return this.switchImgPath;
  }
  
  public int getSwitchOffsetX() {
    return this.switchOffsetX;
  }
  
  public int getSwitchOffsetY_B() {
    return this.switchOffsetY_B;
  }
  
  public int getSwitchSize() {
    return this.switchSize;
  }
  
  public String getSwitchText() {
    return this.switchText;
  }
  
  public Typeface getSwitchViewTypeface() {
    return this.switchViewTypeface;
  }
  
  public int getSwitchWidth() {
    return this.switchWidth;
  }
  
  public String getUnCheckedImgPath() {
    return this.unCheckedImgPath;
  }
  
  public boolean isAuthNavGone() {
    return this.authNavGone;
  }
  
  public boolean isAuthNavTransparent() {
    return this.authNavTransparent;
  }
  
  public boolean isDialogBottom() {
    return this.isDialogBottom;
  }
  
  public boolean isDialogTheme() {
    return this.isDialogTheme;
  }
  
  public boolean isDisableBtnIfUnChecked() {
    return this.disableBtnIfUnChecked;
  }
  
  public boolean isLightColor() {
    return this.isLightColor;
  }
  
  public boolean isLoadingViewCenterInVertical() {
    return this.loadingViewCenterInVertical;
  }
  
  public boolean isLogoHidden() {
    return this.logoHidden;
  }
  
  public boolean isNavReturnImgHidden() {
    return this.navReturnImgHidden;
  }
  
  public boolean isNavTextNormal() {
    return this.navTextNormal;
  }
  
  public boolean isPrivacyAddFrenchQuotes() {
    return this.privacyAddFrenchQuotes;
  }
  
  public boolean isPrivacyState() {
    return this.privacyState;
  }
  
  public boolean isReturnImgCenterInVertical() {
    return this.returnImgCenterInVertical;
  }
  
  public boolean isSwitchAccHidden() {
    return this.switchAccHidden;
  }
  
  public boolean isUseNormalWebActivity() {
    return this.isUseNormalWebActivity;
  }
  
  public boolean isWebViewDialogTheme() {
    return this.isWebViewDialogTheme;
  }
  
  public static class Builder {
    private String authBGImgPath = "gt_one_login_bg";
    
    private String authBgVideoUri = null;
    
    private boolean authNavGone = false;
    
    private int authNavHeight = 49;
    
    private boolean authNavTransparent = true;
    
    private int baseClauseColor = -5723992;
    
    private String checkedImgPath = "gt_one_login_checked";
    
    private int clauseColor = -13011969;
    
    private String clause_name = "";
    
    private String clause_name_three = "";
    
    private String clause_name_two = "";
    
    private String clause_url = "";
    
    private String clause_url_three = "";
    
    private String clause_url_two = "";
    
    private int dialogHeight = 500;
    
    private int dialogWidth = 300;
    
    private int dialogX = 0;
    
    private int dialogY = 0;
    
    private boolean disableBtnIfUnChecked = false;
    
    private boolean isDialogBottom = false;
    
    private boolean isDialogTheme = false;
    
    private boolean isLightColor = false;
    
    private boolean isUseNormalWebActivity = true;
    
    private boolean isWebViewDialogTheme = false;
    
    private String loadingView = "umcsdk_load_dot_white";
    
    private boolean loadingViewCenterInVertical = true;
    
    private int loadingViewHeight = 20;
    
    private int loadingViewOffsetRight = 12;
    
    private int loadingViewOffsetY = 0;
    
    private int loadingViewWidth = 20;
    
    private int logBtnHeight = 36;
    
    private int logBtnOffsetX = 0;
    
    private int logBtnOffsetY = 324;
    
    private int logBtnOffsetY_B = 0;
    
    private int logBtnTextSize = 15;
    
    private Typeface logBtnTextViewTypeface = Typeface.DEFAULT;
    
    private int logBtnWidth = 268;
    
    private int loginButtonColor = -1;
    
    private String loginButtonText = "一键登录";
    
    private String loginImgPath = "gt_one_login_btn_normal";
    
    private int logoHeight = 71;
    
    private boolean logoHidden = false;
    
    private String logoImgPath = "gt_one_login_logo";
    
    private int logoOffsetX = 0;
    
    private int logoOffsetY = 125;
    
    private int logoOffsetY_B = 0;
    
    private int logoWidth = 71;
    
    private int navColor = -13011969;
    
    private boolean navReturnImgHidden = false;
    
    private String navReturnImgPath = "gt_one_login_ic_chevron_left_black";
    
    private String navText = "一键登录";
    
    private int navTextColor = -1;
    
    private boolean navTextNormal = false;
    
    private int navTextSize = 17;
    
    private Typeface navTextTypeface = Typeface.DEFAULT;
    
    private String navWebViewText = "服务条款";
    
    private int navWebViewTextColor = -16777216;
    
    private int navWebViewTextSize = 17;
    
    private Typeface navWebViewTextTypeface = Typeface.DEFAULT;
    
    private int navigationBarColor = 0;
    
    private int numFieldOffsetX = 0;
    
    private int numFieldOffsetY = 200;
    
    private int numFieldOffsetY_B = 0;
    
    private int numberColor = -12762548;
    
    private int numberSize = 24;
    
    private Typeface numberViewTypeface = Typeface.DEFAULT;
    
    private boolean privacyAddFrenchQuotes = false;
    
    private int privacyCheckBoxHeight = 9;
    
    private int privacyCheckBoxOffsetY = 2;
    
    private int privacyCheckBoxWidth = 9;
    
    private Typeface privacyClauseBaseTextViewTypeface = Typeface.DEFAULT;
    
    private int privacyClauseTextSize = 10;
    
    private String[] privacyClauseTextStrings;
    
    private Typeface privacyClauseTextViewTypeface = Typeface.DEFAULT;
    
    private int privacyLayoutWidth = 256;
    
    private int privacyOffsetX = 0;
    
    private int privacyOffsetY = 0;
    
    private int privacyOffsetY_B = 18;
    
    private boolean privacyState = true;
    
    private int privacyTextGravity = 8388659;
    
    private String privacyTextViewTv1 = "登录即同意";
    
    private String privacyTextViewTv2 = "和";
    
    private String privacyTextViewTv3 = "、";
    
    private String privacyTextViewTv4 = "并使用本机号码登录";
    
    private String privacyUnCheckedToastText = "请同意服务条款";
    
    private boolean returnImgCenterInVertical = true;
    
    private int returnImgHeight = 24;
    
    private int returnImgOffsetX = 12;
    
    private int returnImgOffsetY = 0;
    
    private int returnImgWidth = 24;
    
    private int sloganColor = -5723992;
    
    private int sloganOffsetX = 0;
    
    private int sloganOffsetY = 382;
    
    private int sloganOffsetY_B = 0;
    
    private int sloganSize = 10;
    
    private Typeface sloganViewTypeface = Typeface.DEFAULT;
    
    private int statusBarColor = 0;
    
    private boolean switchAccHidden = false;
    
    private int switchAccOffsetY = 249;
    
    private int switchColor = -13011969;
    
    private int switchHeight = 25;
    
    private String switchImgPath = "";
    
    private int switchOffsetX = 0;
    
    private int switchOffsetY_B = 0;
    
    private int switchSize = 14;
    
    private String switchText = "切换账号";
    
    private Typeface switchViewTypeface = Typeface.DEFAULT;
    
    private int switchWidth = 80;
    
    private String unCheckedImgPath = "gt_one_login_unchecked";
    
    public OneLoginThemeConfig build() {
      return new OneLoginThemeConfig(this);
    }
    
    public Builder setAuthBGImgPath(String param1String) {
      this.authBGImgPath = param1String;
      return this;
    }
    
    public Builder setAuthBgVideoUri(String param1String) {
      this.authBgVideoUri = param1String;
      return this;
    }
    
    public Builder setAuthNavLayout(int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2) {
      this.navColor = param1Int1;
      this.authNavHeight = param1Int2;
      this.authNavTransparent = param1Boolean1;
      this.authNavGone = param1Boolean2;
      return this;
    }
    
    public Builder setAuthNavReturnImgView(String param1String, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      this.navReturnImgPath = param1String;
      this.returnImgWidth = param1Int1;
      this.returnImgHeight = param1Int2;
      this.navReturnImgHidden = param1Boolean;
      this.returnImgOffsetX = param1Int3;
      this.returnImgCenterInVertical = true;
      this.returnImgOffsetY = 0;
      return this;
    }
    
    public Builder setAuthNavReturnImgView(String param1String, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3, int param1Int4) {
      this.navReturnImgPath = param1String;
      this.returnImgWidth = param1Int1;
      this.returnImgHeight = param1Int2;
      this.navReturnImgHidden = param1Boolean;
      this.returnImgOffsetX = param1Int3;
      this.returnImgCenterInVertical = false;
      this.returnImgOffsetY = param1Int4;
      return this;
    }
    
    public Builder setAuthNavTextView(String param1String1, int param1Int1, int param1Int2, boolean param1Boolean, String param1String2, int param1Int3, int param1Int4) {
      this.navText = param1String1;
      this.navTextColor = param1Int1;
      this.navTextSize = param1Int2;
      this.navTextNormal = param1Boolean;
      this.navWebViewText = param1String2;
      this.navWebViewTextColor = param1Int3;
      this.navWebViewTextSize = param1Int4;
      return this;
    }
    
    public Builder setAuthNavTextViewTypeface(Typeface param1Typeface1, Typeface param1Typeface2) {
      this.navTextTypeface = param1Typeface1;
      this.navWebViewTextTypeface = param1Typeface2;
      return this;
    }
    
    public Builder setDialogTheme(boolean param1Boolean1, int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean2, boolean param1Boolean3) {
      this.isDialogTheme = param1Boolean1;
      this.dialogWidth = param1Int1;
      this.dialogHeight = param1Int2;
      this.dialogX = param1Int3;
      this.dialogY = param1Int4;
      this.isDialogBottom = param1Boolean2;
      this.isWebViewDialogTheme = param1Boolean3;
      return this;
    }
    
    public Builder setLogBtnDisableIfUnChecked(boolean param1Boolean) {
      this.disableBtnIfUnChecked = param1Boolean;
      return this;
    }
    
    public Builder setLogBtnLayout(String param1String, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      this.loginImgPath = param1String;
      this.logBtnWidth = param1Int1;
      this.logBtnHeight = param1Int2;
      this.logBtnOffsetY = param1Int3;
      this.logBtnOffsetY_B = param1Int4;
      this.logBtnOffsetX = param1Int5;
      return this;
    }
    
    public Builder setLogBtnLoadingView(String param1String, int param1Int1, int param1Int2, int param1Int3) {
      this.loadingView = param1String;
      this.loadingViewWidth = param1Int1;
      this.loadingViewHeight = param1Int2;
      this.loadingViewOffsetRight = param1Int3;
      this.loadingViewCenterInVertical = true;
      this.loadingViewOffsetY = 0;
      return this;
    }
    
    public Builder setLogBtnLoadingView(String param1String, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.loadingView = param1String;
      this.loadingViewWidth = param1Int1;
      this.loadingViewHeight = param1Int2;
      this.loadingViewOffsetRight = param1Int3;
      this.loadingViewCenterInVertical = false;
      this.loadingViewOffsetY = param1Int4;
      return this;
    }
    
    public Builder setLogBtnTextView(String param1String, int param1Int1, int param1Int2) {
      this.loginButtonText = param1String;
      this.loginButtonColor = param1Int1;
      this.logBtnTextSize = param1Int2;
      return this;
    }
    
    public Builder setLogBtnTextViewTypeface(Typeface param1Typeface) {
      this.logBtnTextViewTypeface = param1Typeface;
      return this;
    }
    
    public Builder setLogoImgView(String param1String, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3, int param1Int4, int param1Int5) {
      this.logoImgPath = param1String;
      this.logoWidth = param1Int1;
      this.logoHeight = param1Int2;
      this.logoHidden = param1Boolean;
      this.logoOffsetY = param1Int3;
      this.logoOffsetY_B = param1Int4;
      this.logoOffsetX = param1Int5;
      return this;
    }
    
    public Builder setNumberView(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      this.numberColor = param1Int1;
      this.numberSize = param1Int2;
      this.numFieldOffsetY = param1Int3;
      this.numFieldOffsetY_B = param1Int4;
      this.numFieldOffsetX = param1Int5;
      return this;
    }
    
    public Builder setNumberViewTypeface(Typeface param1Typeface) {
      this.numberViewTypeface = param1Typeface;
      return this;
    }
    
    public Builder setPrivacyAddFrenchQuotes(boolean param1Boolean) {
      this.privacyAddFrenchQuotes = param1Boolean;
      return this;
    }
    
    public Builder setPrivacyCheckBox(String param1String1, String param1String2, boolean param1Boolean, int param1Int1, int param1Int2) {
      this.unCheckedImgPath = param1String1;
      this.checkedImgPath = param1String2;
      this.privacyState = param1Boolean;
      this.privacyCheckBoxWidth = param1Int1;
      this.privacyCheckBoxHeight = param1Int2;
      return this;
    }
    
    public Builder setPrivacyCheckBox(String param1String1, String param1String2, boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3) {
      this.unCheckedImgPath = param1String1;
      this.checkedImgPath = param1String2;
      this.privacyState = param1Boolean;
      this.privacyCheckBoxWidth = param1Int1;
      this.privacyCheckBoxHeight = param1Int2;
      this.privacyCheckBoxOffsetY = param1Int3;
      return this;
    }
    
    public Builder setPrivacyClauseText(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6) {
      this.clause_name = param1String1;
      this.clause_url = param1String2;
      this.clause_name_two = param1String3;
      this.clause_url_two = param1String4;
      this.clause_name_three = param1String5;
      this.clause_url_three = param1String6;
      return this;
    }
    
    public Builder setPrivacyClauseTextStrings(String... param1VarArgs) {
      this.privacyClauseTextStrings = param1VarArgs;
      return this;
    }
    
    public Builder setPrivacyClauseView(int param1Int1, int param1Int2, int param1Int3) {
      this.baseClauseColor = param1Int1;
      this.clauseColor = param1Int2;
      this.privacyClauseTextSize = param1Int3;
      return this;
    }
    
    public Builder setPrivacyClauseViewTypeface(Typeface param1Typeface1, Typeface param1Typeface2) {
      this.privacyClauseBaseTextViewTypeface = param1Typeface1;
      this.privacyClauseTextViewTypeface = param1Typeface2;
      return this;
    }
    
    public Builder setPrivacyLayout(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      this.privacyLayoutWidth = param1Int1;
      this.privacyOffsetY = param1Int2;
      this.privacyOffsetY_B = param1Int3;
      this.privacyOffsetX = param1Int4;
      this.isUseNormalWebActivity = param1Boolean;
      return this;
    }
    
    public Builder setPrivacyTextGravity(int param1Int) {
      this.privacyTextGravity = param1Int;
      return this;
    }
    
    public Builder setPrivacyTextView(String param1String1, String param1String2, String param1String3, String param1String4) {
      this.privacyTextViewTv1 = param1String1;
      this.privacyTextViewTv2 = param1String2;
      this.privacyTextViewTv3 = param1String3;
      this.privacyTextViewTv4 = param1String4;
      return this;
    }
    
    public Builder setPrivacyUnCheckedToastText(String param1String) {
      this.privacyUnCheckedToastText = param1String;
      return this;
    }
    
    public Builder setSloganView(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      this.sloganColor = param1Int1;
      this.sloganSize = param1Int2;
      this.sloganOffsetY = param1Int3;
      this.sloganOffsetY_B = param1Int4;
      this.sloganOffsetX = param1Int5;
      return this;
    }
    
    public Builder setSloganViewTypeface(Typeface param1Typeface) {
      this.sloganViewTypeface = param1Typeface;
      return this;
    }
    
    public Builder setStatusBar(int param1Int1, int param1Int2, boolean param1Boolean) {
      this.statusBarColor = param1Int1;
      this.navigationBarColor = param1Int2;
      this.isLightColor = param1Boolean;
      return this;
    }
    
    public Builder setSwitchView(String param1String, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3, int param1Int4, int param1Int5) {
      this.switchText = param1String;
      this.switchColor = param1Int1;
      this.switchSize = param1Int2;
      this.switchAccHidden = param1Boolean;
      this.switchAccOffsetY = param1Int3;
      this.switchOffsetY_B = param1Int4;
      this.switchOffsetX = param1Int5;
      return this;
    }
    
    public Builder setSwitchViewLayout(String param1String, int param1Int1, int param1Int2) {
      this.switchImgPath = param1String;
      this.switchWidth = param1Int1;
      this.switchHeight = param1Int2;
      return this;
    }
    
    public Builder setSwitchViewTypeface(Typeface param1Typeface) {
      this.switchViewTypeface = param1Typeface;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\config\OneLoginThemeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.cmic.sso.sdk;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.cmic.sso.sdk.auth.BackPressedListener;
import com.cmic.sso.sdk.auth.LoginClickListener;
import java.util.regex.Pattern;

public class AuthThemeConfig {
  public static final String PLACEHOLDER = "$$运营商条款$$";
  
  public static final String PLACEHOLDER2 = "$$《运营商条款》$$";
  
  private String activityIn;
  
  private String activityOut;
  
  private String authPageActIn;
  
  private String authPageActOut;
  
  private BackPressedListener backPressedListener;
  
  private int checkedImgHeight;
  
  private String checkedImgPath;
  
  private int checkedImgWidth;
  
  private int clauseBaseColor;
  
  private int clauseColor;
  
  private int clauseLayoutResID;
  
  private String clauseName;
  
  private String clauseName2;
  
  private String clauseUrl;
  
  private String clauseUrl2;
  
  private View contentView;
  
  private boolean isLightColor;
  
  private boolean isPrivacyTextGravityCenter;
  
  private int layoutResID;
  
  private String logBtnBackgroundPath;
  
  private int logBtnHeight;
  
  private int logBtnMarginLeft;
  
  private int logBtnMarginRight;
  
  private int logBtnOffsetY;
  
  private int logBtnOffsetY_B;
  
  private String logBtnText;
  
  private int logBtnTextColor;
  
  private int logBtnTextSize;
  
  private int logBtnWidth;
  
  private LoginClickListener loginClickListener;
  
  private int navReturnImgHeight;
  
  private String navReturnImgPath;
  
  private ImageView.ScaleType navReturnImgScaleType;
  
  private int navReturnImgWidth;
  
  private int navTextColor;
  
  private int navTextSize;
  
  private int numFieldOffsetY;
  
  private int numFieldOffsetY_B;
  
  private int numberColor;
  
  private int numberOffsetX;
  
  private int numberSize;
  
  private String privacy;
  
  private int privacyMarginLeft;
  
  private int privacyMarginRight;
  
  private int privacyOffsetY;
  
  private int privacyOffsetY_B;
  
  private boolean privacyState;
  
  private int privacyTextSize;
  
  private int statusBarColor;
  
  private int themeId;
  
  private String uncheckedImgPath;
  
  private int windowBottom;
  
  private int windowHeight;
  
  private int windowWidth;
  
  private int windowX;
  
  private int windowY;
  
  private AuthThemeConfig(Builder paramBuilder) {
    this.statusBarColor = paramBuilder.statusBarColor;
    this.isLightColor = paramBuilder.isLightColor;
    this.contentView = paramBuilder.contentView;
    this.layoutResID = paramBuilder.layoutResID;
    this.clauseLayoutResID = paramBuilder.clauseLayoutResID;
    this.navTextSize = paramBuilder.navTextSize;
    this.navTextColor = paramBuilder.navTextColor;
    this.navReturnImgPath = paramBuilder.navReturnImgPath;
    this.navReturnImgWidth = paramBuilder.navReturnImgWidth;
    this.navReturnImgHeight = paramBuilder.navReturnImgHeight;
    this.navReturnImgScaleType = paramBuilder.navReturnImgScaleType;
    this.numberSize = paramBuilder.numberSize;
    this.numberColor = paramBuilder.numberColor;
    this.numberOffsetX = paramBuilder.numberOffsetX;
    this.numFieldOffsetY = paramBuilder.numFieldOffsetY;
    this.numFieldOffsetY_B = paramBuilder.numFieldOffsetY_B;
    this.logBtnText = paramBuilder.logBtnText;
    this.logBtnTextSize = paramBuilder.logBtnTextSize;
    this.logBtnTextColor = paramBuilder.logBtnTextColor;
    this.logBtnBackgroundPath = paramBuilder.logBtnBackgroundPath;
    this.logBtnWidth = paramBuilder.logBtnWidth;
    this.logBtnHeight = paramBuilder.logBtnHeight;
    this.logBtnMarginLeft = paramBuilder.logBtnMarginLeft;
    this.logBtnMarginRight = paramBuilder.logBtnMarginRight;
    this.logBtnOffsetY = paramBuilder.logBtnOffsetY;
    this.logBtnOffsetY_B = paramBuilder.logBtnOffsetY_B;
    this.backPressedListener = paramBuilder.backPressedListener;
    this.loginClickListener = paramBuilder.loginClickListener;
    this.checkedImgPath = paramBuilder.checkedImgPath;
    this.uncheckedImgPath = paramBuilder.uncheckedImgPath;
    this.checkedImgWidth = paramBuilder.checkBoxImgWidth;
    this.checkedImgHeight = paramBuilder.checkBoxImgHeight;
    this.privacyState = paramBuilder.privacyState;
    this.privacy = paramBuilder.privacy;
    this.clauseName = paramBuilder.clauseName;
    this.clauseUrl = paramBuilder.clauseUrl;
    this.clauseName2 = paramBuilder.clauseName2;
    this.clauseUrl2 = paramBuilder.clauseUrl2;
    this.privacyTextSize = paramBuilder.privacyTextSize;
    this.clauseBaseColor = paramBuilder.clauseBaseColor;
    this.clauseColor = paramBuilder.clauseColor;
    this.isPrivacyTextGravityCenter = paramBuilder.isPrivacyTextGravityCenter;
    this.privacyMarginLeft = paramBuilder.privacyMarginLeft;
    this.privacyMarginRight = paramBuilder.privacyMarginRight;
    this.privacyOffsetY = paramBuilder.privacyOffsetY;
    this.privacyOffsetY_B = paramBuilder.privacyOffsetY_B;
    this.authPageActIn = paramBuilder.authPageActIn;
    this.activityOut = paramBuilder.activityOut;
    this.authPageActOut = paramBuilder.authPageActOut;
    this.activityIn = paramBuilder.activityIn;
    this.windowWidth = paramBuilder.windowWidth;
    this.windowHeight = paramBuilder.windowHeight;
    this.windowX = paramBuilder.windowX;
    this.windowY = paramBuilder.windowY;
    this.windowBottom = paramBuilder.windowBottom;
    this.themeId = paramBuilder.themeId;
  }
  
  public String getActivityIn() {
    return this.activityIn;
  }
  
  public String getActivityOut() {
    return this.activityOut;
  }
  
  public String getAuthPageActIn() {
    return this.authPageActIn;
  }
  
  public String getAuthPageActOut() {
    return this.authPageActOut;
  }
  
  public BackPressedListener getBackPressedListener() {
    return this.backPressedListener;
  }
  
  public int getCheckedImgHeight() {
    return this.checkedImgHeight;
  }
  
  public String getCheckedImgPath() {
    return this.checkedImgPath;
  }
  
  public int getCheckedImgWidth() {
    return this.checkedImgWidth;
  }
  
  public int getClauseBaseColor() {
    return this.clauseBaseColor;
  }
  
  public int getClauseColor() {
    return this.clauseColor;
  }
  
  public int getClauseLayoutResID() {
    return this.clauseLayoutResID;
  }
  
  public String getClauseName() {
    return this.clauseName;
  }
  
  public String getClauseName2() {
    return this.clauseName2;
  }
  
  public String getClauseUrl() {
    return this.clauseUrl;
  }
  
  public String getClauseUrl2() {
    return this.clauseUrl2;
  }
  
  public View getContentView() {
    return this.contentView;
  }
  
  public int getLayoutResID() {
    return this.layoutResID;
  }
  
  public String getLogBtnBackgroundPath() {
    return this.logBtnBackgroundPath;
  }
  
  public int getLogBtnHeight() {
    return this.logBtnHeight;
  }
  
  public int getLogBtnMarginLeft() {
    return this.logBtnMarginLeft;
  }
  
  public int getLogBtnMarginRight() {
    return this.logBtnMarginRight;
  }
  
  public int getLogBtnOffsetY() {
    return this.logBtnOffsetY;
  }
  
  public int getLogBtnOffsetY_B() {
    return this.logBtnOffsetY_B;
  }
  
  public String getLogBtnText() {
    return this.logBtnText;
  }
  
  public int getLogBtnTextColor() {
    return this.logBtnTextColor;
  }
  
  public int getLogBtnTextSize() {
    return this.logBtnTextSize;
  }
  
  public int getLogBtnWidth() {
    return this.logBtnWidth;
  }
  
  public LoginClickListener getLoginClickListener() {
    return this.loginClickListener;
  }
  
  public int getNavReturnImgHeight() {
    return this.navReturnImgHeight;
  }
  
  public String getNavReturnImgPath() {
    return this.navReturnImgPath;
  }
  
  public ImageView.ScaleType getNavReturnImgScaleType() {
    return this.navReturnImgScaleType;
  }
  
  public int getNavReturnImgWidth() {
    return this.navReturnImgWidth;
  }
  
  public int getNavTextColor() {
    return this.navTextColor;
  }
  
  public int getNavTextSize() {
    return this.navTextSize;
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
  
  public int getNumberOffsetX() {
    return this.numberOffsetX;
  }
  
  public int getNumberSize() {
    return this.numberSize;
  }
  
  public String getPrivacy() {
    return this.privacy;
  }
  
  public int getPrivacyMarginLeft() {
    return this.privacyMarginLeft;
  }
  
  public int getPrivacyMarginRight() {
    return this.privacyMarginRight;
  }
  
  public int getPrivacyOffsetY() {
    return this.privacyOffsetY;
  }
  
  public int getPrivacyOffsetY_B() {
    return this.privacyOffsetY_B;
  }
  
  public int getPrivacyTextSize() {
    return this.privacyTextSize;
  }
  
  public int getStatusBarColor() {
    return this.statusBarColor;
  }
  
  public int getThemeId() {
    return this.themeId;
  }
  
  public String getUncheckedImgPath() {
    return this.uncheckedImgPath;
  }
  
  public int getWindowBottom() {
    return this.windowBottom;
  }
  
  public int getWindowHeight() {
    return this.windowHeight;
  }
  
  public int getWindowWidth() {
    return this.windowWidth;
  }
  
  public int getWindowX() {
    return this.windowX;
  }
  
  public int getWindowY() {
    return this.windowY;
  }
  
  public boolean isLightColor() {
    return this.isLightColor;
  }
  
  public boolean isPrivacyState() {
    return this.privacyState;
  }
  
  public boolean isPrivacyTextGravityCenter() {
    return this.isPrivacyTextGravityCenter;
  }
  
  public static class Builder {
    private String activityIn;
    
    private String activityOut;
    
    private String authPageActIn;
    
    private String authPageActOut;
    
    private BackPressedListener backPressedListener;
    
    private int checkBoxImgHeight = 9;
    
    private int checkBoxImgWidth = 9;
    
    private String checkedImgPath = "umcsdk_check_image";
    
    private int clauseBaseColor = -10066330;
    
    private int clauseColor = -16007674;
    
    private int clauseLayoutResID = -1;
    
    private String clauseName = null;
    
    private String clauseName2 = null;
    
    private String clauseUrl = null;
    
    private String clauseUrl2 = null;
    
    private View contentView = null;
    
    private boolean isLightColor = false;
    
    private boolean isPrivacyTextGravityCenter = false;
    
    private int layoutResID = -1;
    
    private String logBtnBackgroundPath = "umcsdk_login_btn_bg";
    
    private int logBtnHeight = 36;
    
    private int logBtnMarginLeft = 46;
    
    private int logBtnMarginRight = 46;
    
    private int logBtnOffsetY = 254;
    
    private int logBtnOffsetY_B = 0;
    
    private String logBtnText = "本机号码一键登录";
    
    private int logBtnTextColor = -1;
    
    private int logBtnTextSize = 15;
    
    private int logBtnWidth = -1;
    
    private LoginClickListener loginClickListener;
    
    private int navReturnImgHeight = -2;
    
    private String navReturnImgPath = "return_bg";
    
    private ImageView.ScaleType navReturnImgScaleType = ImageView.ScaleType.CENTER;
    
    private int navReturnImgWidth = -2;
    
    private int navTextColor = -1;
    
    private int navTextSize = 17;
    
    private int numFieldOffsetY = 184;
    
    private int numFieldOffsetY_B = 0;
    
    private int numberColor = -16742704;
    
    private int numberOffsetX = 0;
    
    private int numberSize = 18;
    
    private String privacy = "登录即同意$$运营商条款$$并使用本机号码登录";
    
    private int privacyMarginLeft = 52;
    
    private int privacyMarginRight = 52;
    
    private int privacyOffsetY = 0;
    
    private int privacyOffsetY_B = 30;
    
    private boolean privacyState = false;
    
    private int privacyTextSize = 10;
    
    private int statusBarColor = 0;
    
    private int themeId = -1;
    
    private String uncheckedImgPath = "umcsdk_uncheck_image";
    
    private int windowBottom = 0;
    
    private int windowHeight;
    
    private int windowWidth;
    
    private int windowX;
    
    private int windowY;
    
    public AuthThemeConfig build() {
      return new AuthThemeConfig(this);
    }
    
    public Builder setAuthContentView(View param1View) {
      this.contentView = param1View;
      this.layoutResID = -1;
      return this;
    }
    
    public Builder setAuthLayoutResID(int param1Int) {
      this.layoutResID = param1Int;
      this.contentView = null;
      return this;
    }
    
    public Builder setAuthPageActIn(String param1String1, String param1String2) {
      this.authPageActIn = param1String1;
      this.activityOut = param1String2;
      return this;
    }
    
    public Builder setAuthPageActOut(String param1String1, String param1String2) {
      this.authPageActOut = param1String1;
      this.activityIn = param1String2;
      return this;
    }
    
    public Builder setAuthPageWindowMode(int param1Int1, int param1Int2) {
      this.windowWidth = param1Int1;
      this.windowHeight = param1Int2;
      return this;
    }
    
    public Builder setAuthPageWindowOffset(int param1Int1, int param1Int2) {
      this.windowX = param1Int1;
      this.windowY = param1Int2;
      return this;
    }
    
    public Builder setBackPressedListener(BackPressedListener param1BackPressedListener) {
      this.backPressedListener = param1BackPressedListener;
      return this;
    }
    
    public Builder setCheckBoxImgPath(String param1String1, String param1String2, int param1Int1, int param1Int2) {
      this.checkedImgPath = param1String1;
      this.uncheckedImgPath = param1String2;
      this.checkBoxImgWidth = param1Int1;
      this.checkBoxImgHeight = param1Int2;
      return this;
    }
    
    public Builder setCheckedImgPath(String param1String) {
      this.checkedImgPath = param1String;
      return this;
    }
    
    public Builder setClauseColor(int param1Int1, int param1Int2) {
      this.clauseBaseColor = param1Int1;
      this.clauseColor = param1Int2;
      return this;
    }
    
    public Builder setClauseLayoutResID(int param1Int) {
      this.clauseLayoutResID = param1Int;
      return this;
    }
    
    public Builder setLogBtn(int param1Int1, int param1Int2) {
      this.logBtnWidth = param1Int1;
      this.logBtnHeight = param1Int2;
      return this;
    }
    
    public Builder setLogBtnClickListener(LoginClickListener param1LoginClickListener) {
      this.loginClickListener = param1LoginClickListener;
      return this;
    }
    
    public Builder setLogBtnImgPath(String param1String) {
      this.logBtnBackgroundPath = param1String;
      return this;
    }
    
    public Builder setLogBtnMargin(int param1Int1, int param1Int2) {
      this.logBtnMarginLeft = param1Int1;
      this.logBtnMarginRight = param1Int2;
      return this;
    }
    
    public Builder setLogBtnOffsetY(int param1Int) {
      this.logBtnOffsetY = param1Int;
      this.logBtnOffsetY_B = 0;
      return this;
    }
    
    public Builder setLogBtnOffsetY_B(int param1Int) {
      this.logBtnOffsetY_B = param1Int;
      this.logBtnOffsetY = 0;
      return this;
    }
    
    public Builder setLogBtnText(String param1String) {
      if (!TextUtils.isEmpty(param1String) && !Pattern.compile("^\\s*\\n*$").matcher(param1String).matches())
        this.logBtnText = param1String; 
      return this;
    }
    
    public Builder setLogBtnText(String param1String, int param1Int1, int param1Int2) {
      if (!TextUtils.isEmpty(param1String) && !Pattern.compile("^\\s*\\n*$").matcher(param1String).matches())
        this.logBtnText = param1String; 
      this.logBtnTextColor = param1Int1;
      this.logBtnTextSize = param1Int2;
      return this;
    }
    
    public Builder setLogBtnTextColor(int param1Int) {
      this.logBtnTextColor = param1Int;
      return this;
    }
    
    public Builder setNavTextColor(int param1Int) {
      this.navTextColor = param1Int;
      return this;
    }
    
    public Builder setNavTextSize(int param1Int) {
      this.navTextSize = param1Int;
      return this;
    }
    
    public Builder setNumFieldOffsetY(int param1Int) {
      this.numFieldOffsetY = param1Int;
      this.numFieldOffsetY_B = 0;
      return this;
    }
    
    public Builder setNumFieldOffsetY_B(int param1Int) {
      this.numFieldOffsetY_B = param1Int;
      this.numFieldOffsetY = 0;
      return this;
    }
    
    public Builder setNumberColor(int param1Int) {
      this.numberColor = param1Int;
      return this;
    }
    
    public Builder setNumberOffsetX(int param1Int) {
      this.numberOffsetX = param1Int;
      return this;
    }
    
    public Builder setNumberSize(int param1Int) {
      if (param1Int > 8)
        this.numberSize = param1Int; 
      return this;
    }
    
    public Builder setPrivacyAlignment(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      if (param1String1.contains("$$运营商条款$$") || param1String1.contains("$$《运营商条款》$$")) {
        this.privacy = param1String1;
        this.clauseName = param1String2;
        this.clauseUrl = param1String3;
        this.clauseName2 = param1String4;
        this.clauseUrl2 = param1String5;
      } 
      return this;
    }
    
    public Builder setPrivacyMargin(int param1Int1, int param1Int2) {
      this.privacyMarginLeft = param1Int1;
      this.privacyMarginRight = param1Int2;
      return this;
    }
    
    public Builder setPrivacyOffsetY(int param1Int) {
      this.privacyOffsetY = param1Int;
      this.privacyOffsetY_B = 0;
      return this;
    }
    
    public Builder setPrivacyOffsetY_B(int param1Int) {
      this.privacyOffsetY_B = param1Int;
      this.privacyOffsetY = 0;
      return this;
    }
    
    public Builder setPrivacyState(boolean param1Boolean) {
      this.privacyState = param1Boolean;
      return this;
    }
    
    public Builder setPrivacyText(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      this.privacyTextSize = param1Int1;
      this.clauseBaseColor = param1Int2;
      this.clauseColor = param1Int3;
      this.isPrivacyTextGravityCenter = param1Boolean;
      return this;
    }
    
    public Builder setStatusBar(int param1Int, boolean param1Boolean) {
      this.statusBarColor = param1Int;
      this.isLightColor = param1Boolean;
      return this;
    }
    
    public Builder setThemeId(int param1Int) {
      this.themeId = param1Int;
      return this;
    }
    
    public Builder setUncheckedImgPath(String param1String) {
      this.uncheckedImgPath = param1String;
      return this;
    }
    
    public Builder setWindowBottom(int param1Int) {
      this.windowBottom = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\AuthThemeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
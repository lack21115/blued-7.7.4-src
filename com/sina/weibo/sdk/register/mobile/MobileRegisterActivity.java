package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.view.ResizeableLayout;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import java.util.Locale;
import org.json.JSONObject;

public class MobileRegisterActivity extends Activity implements View.OnClickListener, View.OnFocusChangeListener, ResizeableLayout.SizeChangeListener {
  private static final String APPKEY_NOT_SET_CN = "您的app_key没有设置";
  
  private static final String APPKEY_NOT_SET_EN = "your appkey not set";
  
  private static final String APPKEY_NOT_SET_TW = "您的app_key沒有設置";
  
  private static final String CANCEL_EN = "Cancel";
  
  private static final String CANCEL_ZH_CN = "取消";
  
  private static final String CANCEL_ZH_TW = "取消";
  
  private static final String CHINA_CN = "中国";
  
  private static final String CHINA_EN = "China";
  
  private static final String CHINA_TW = "中國";
  
  private static final String CODE_LENGTH_CN = "你的验证码不是6位数";
  
  private static final String CODE_LENGTH_EN = "Your code isn’t 6-digit long";
  
  private static final String CODE_LENGTH_TW = "你的驗證碼不是6位數";
  
  private static final int DEFAULT_BG_COLOR = -855310;
  
  private static final int DEFAULT_CLEAR_BTN = 22;
  
  private static final int DEFAULT_TEXT_PADDING = 12;
  
  private static final int DEFAULT_TIPS_TEXT_SIZE = 13;
  
  private static final int DEFAULT__RIGHT_TRIANGLE = 13;
  
  private static final int EMPTY_VIEW_TEXT_COLOR = -4342339;
  
  private static final int GET_CODE_BTN_ID = 3;
  
  private static final String GET_CODE_CN = "获取验证码";
  
  private static final String GET_CODE_EN = "Get code";
  
  private static final String GET_CODE_TW = "獲取驗證碼";
  
  private static final String HELP_INFO_CN = "请确认国家和地区并填写手机号码";
  
  private static final String HELP_INFO_EN = "Confirm your country/region and enter your mobile number";
  
  private static final String HELP_INFO_TW = "請確認國家和地區并填寫手機號";
  
  private static final String INPUT_AUTH_CODE_CN = "请输入验证码";
  
  private static final String INPUT_AUTH_CODE_EN = "Verification code";
  
  private static final String INPUT_AUTH_CODE_TW = "請輸入驗證碼";
  
  private static final String INPUT_PHONE_NUM_CN = "请输入手机号码";
  
  private static final String INPUT_PHONE_NUM_EN = "Your mobile number";
  
  private static final String INPUT_PHONE_NUM_TW = "請輸入手機號";
  
  private static final int LINK_TEXT_COLOR = -8224126;
  
  private static final int MIAN_LINK_TEXT_COLOR = -11502161;
  
  private static final String NETWORK_ERROR_CN = "您的网络不可用，请稍后";
  
  private static final String NETWORK_ERROR_EN = "your network is  disabled  try again later";
  
  private static final String NETWORK_ERROR_TW = "您的網絡不可用，請稍後";
  
  private static final String OK_EN = "OK";
  
  private static final String OK_ZH_CN = "确定";
  
  private static final String OK_ZH_TW = "確定";
  
  private static final String PHONE_ERROR_CN = "您的手机号不是11位数";
  
  private static final String PHONE_ERROR_EN = "Your phone number isn’t 11-digit long";
  
  private static final String PHONE_ERROR_TW = "您的手機號不是11位數";
  
  private static final int PHONE_NUM_CLEAR_BTN_ID = 4;
  
  public static final String REGISTER_TITLE = "register_title";
  
  private static final int RESIZEABLE_INPUTMETHODHIDE = 0;
  
  private static final int RESIZEABLE_INPUTMETHODSHOW = 1;
  
  public static final String RESPONSE_EXPIRES = "expires";
  
  public static final String RESPONSE_OAUTH_TOKEN = "oauth_token";
  
  private static final int SELECT_COUNTRY_REQUEST_CODE = 0;
  
  private static final String SEND_MSG = "http://api.weibo.com/oauth2/sms_authorize/send";
  
  private static final String SEND_SUBMIT = "http://api.weibo.com/oauth2/sms_authorize/submit";
  
  private static final String SERVER_ERROR_CN = "服务器忙,请稍后再试";
  
  private static final String SERVER_ERROR_EN = "the server is busy, please  wait";
  
  private static final String SERVER_ERROR_TW = "服務器忙,請稍後再試";
  
  private static final String SINA_NOTICE_EN = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy";
  
  private static final String SINA_NOTICE_ZH_CN = "点击“确定”表示你同意服务使用协议和隐私条款。";
  
  private static final String SINA_NOTICE_ZH_TW = "點擊“確定”標示你同意服務使用協議和隱私條款。";
  
  private static final String SINA_PRIVATE_URL = "http://m.weibo.cn/reg/privacyagreement?from=h5&wm=3349";
  
  private static final String SINA_PROTOCOL_URL = "http://weibo.cn/dpool/ttt/h5/regagreement.php?from=h5";
  
  private static final String SINA_SERVICE_EN = "Service By Sina WeiBo";
  
  private static final String SINA_SERVICE_ZH_CN = "此服务由微博提供";
  
  private static final String SINA_SERVICE_ZH_TW = "此服務由微博提供";
  
  private static final String TAG = MobileRegisterActivity.class.getName();
  
  private static final int TITLE_BAR_ID = 1;
  
  private static final String TITLE_CN = "验证码登录";
  
  private static final String TITLE_EN = "Login";
  
  private static final String TITLE_TW = "驗證碼登錄";
  
  private static final int TRIANGLE_ID = 2;
  
  private static final String WAIT_CN = "正在处理中.....";
  
  private static final String WAIT_EN = "please wait .... ";
  
  private static final String WAIT_TW = "正在處理中.....";
  
  private String cfrom;
  
  private String mAppkey;
  
  private Button mBtnRegist;
  
  private EditText mCheckCode;
  
  private CountDownTimer mCountDownTimer;
  
  private TextView mCountryCode;
  
  private String mCountryCodeStr;
  
  private RelativeLayout mCountryLayout;
  
  private TextView mCountryName;
  
  private String mCountryNameStr;
  
  private Button mGetCodeBtn;
  
  private TextView mInfoText;
  
  private InputHandler mInputHandler = new InputHandler(null);
  
  private String mKeyHash;
  
  private ProgressDialog mLoadingDlg;
  
  private int mMaxHeight = 0;
  
  private String mPackageName;
  
  private EditText mPhoneNum;
  
  private ImageView mPhoneNumClearBtn;
  
  private ScrollView mRegistScrollview;
  
  private LinearLayout mRegiter_llt;
  
  private String mSpecifyTitle;
  
  private TextView mTips;
  
  private TitleBar titleBar;
  
  private void disableGetCodeBtn() {
    this.mGetCodeBtn.setEnabled(false);
    this.mGetCodeBtn.setTextColor(-4342339);
  }
  
  private void disableRegisterBtn() {
    this.mBtnRegist.setTextColor(1308622847);
    this.mBtnRegist.setEnabled(false);
  }
  
  private boolean doCheckOnGetMsg(String paramString) {
    if (!NetworkHelper.isNetworkAvailable((Context)this)) {
      showNetFail();
      return false;
    } 
    if (!verifyPhoneNum(paramString)) {
      this.mTips.setVisibility(0);
      this.mTips.setText(ResourceManager.getString(getApplicationContext(), "Your phone number isn’t 11-digit long", "您的手机号不是11位数", "您的手機號不是11位數"));
      return false;
    } 
    this.mTips.setVisibility(4);
    return true;
  }
  
  private boolean doCheckOnSubmit(String paramString) {
    if (!NetworkHelper.isNetworkAvailable((Context)this)) {
      showNetFail();
      return false;
    } 
    if (verifyCheckCode(paramString)) {
      this.mTips.setVisibility(4);
      return true;
    } 
    this.mTips.setVisibility(0);
    this.mTips.setText(ResourceManager.getString(getApplicationContext(), "Your code isn’t 6-digit long", "你的验证码不是6位数", "你的驗證碼不是6位數"));
    UIUtils.showToast(getApplicationContext(), ResourceManager.getString(getApplicationContext(), "Your code isn’t 6-digit long", "你的验证码不是6位数", "你的驗證碼不是6位數"), 0);
    return false;
  }
  
  private void enableGetCodeBtn() {
    this.mGetCodeBtn.setEnabled(true);
    this.mGetCodeBtn.setTextColor(-11502161);
  }
  
  private void enableRegisterBtn() {
    this.mBtnRegist.setEnabled(true);
    this.mBtnRegist.setTextColor(-1);
  }
  
  private Button genOKBtn() {
    Button button = new Button((Context)this);
    button.setBackgroundDrawable((Drawable)ResourceManager.createStateListDrawable((Context)this, "common_button_big_blue.9.png", "common_button_big_blue_highlighted.9.png", "common_button_big_blue_disable.9.png"));
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 46));
    int i = ResourceManager.dp2px((Context)this, 12);
    layoutParams.rightMargin = i;
    layoutParams.leftMargin = i;
    button.setText(ResourceManager.getString((Context)this, "OK", "确定", "確定"));
    button.setTextSize(17.0F);
    button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    return button;
  }
  
  private TextView genProtocalInfoTv() {
    String str1;
    String str2;
    TextView textView = new TextView((Context)this);
    textView.setTextSize(2, 13.0F);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.topMargin = ResourceManager.dp2px((Context)this, 8);
    layoutParams.leftMargin = ResourceManager.dp2px((Context)this, 12);
    layoutParams.rightMargin = ResourceManager.dp2px((Context)this, 12);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    textView.setTextSize(13.0F);
    textView.setGravity(3);
    textView.setTextColor(-8224126);
    Locale locale = ResourceManager.getLanguage();
    boolean bool = Locale.SIMPLIFIED_CHINESE.equals(locale);
    byte b1 = 22;
    byte b2 = 18;
    byte b3 = 17;
    byte b4 = 11;
    if (bool) {
      str1 = "zh_CN";
      str2 = "点击“确定”表示你同意服务使用协议和隐私条款。";
    } else if (Locale.TRADITIONAL_CHINESE.equals(str1)) {
      str2 = "點擊“確定”標示你同意服務使用協議和隱私條款。";
      str1 = "zh_HK";
    } else {
      b4 = 49;
      b3 = 66;
      b2 = 71;
      b1 = 85;
      str2 = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy";
      str1 = "en_US";
    } 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
    if (b4 != -1 && b3 != -1) {
      StringBuilder stringBuilder = new StringBuilder("http://weibo.cn/dpool/ttt/h5/regagreement.php?from=h5&lang=");
      stringBuilder.append(str1);
      spannableStringBuilder.setSpan(new WBSdkUrlClickSpan((Context)this, stringBuilder.toString()), b4, b3, 33);
    } 
    if (b2 != -1 && b1 != -1) {
      StringBuilder stringBuilder = new StringBuilder("http://m.weibo.cn/reg/privacyagreement?from=h5&wm=3349&lang=");
      stringBuilder.append(str1);
      spannableStringBuilder.setSpan(new WBSdkUrlClickSpan((Context)this, stringBuilder.toString()), b2, b1, 33);
    } 
    textView.setText((CharSequence)spannableStringBuilder);
    textView.setMovementMethod(LinkMovementMethod.getInstance());
    textView.setFocusable(false);
    return textView;
  }
  
  private TextView genSinaServiceTv() {
    TextView textView = new TextView((Context)this);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.topMargin = ResourceManager.dp2px((Context)this, 12);
    layoutParams.leftMargin = ResourceManager.dp2px((Context)this, 12);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    textView.setTextSize(13.0F);
    textView.setGravity(3);
    textView.setTextColor(-8224126);
    textView.setText(ResourceManager.getString((Context)this, "Service By Sina WeiBo", "此服务由微博提供", "此服務由微博提供"));
    return textView;
  }
  
  private void initLoadingDlg() {
    this.mLoadingDlg = new ProgressDialog((Context)this);
    this.mLoadingDlg.setCanceledOnTouchOutside(false);
    this.mLoadingDlg.requestWindowFeature(1);
    this.mLoadingDlg.setMessage(ResourceManager.getString((Context)this, "please wait .... ", "正在处理中.....", "正在處理中....."));
  }
  
  private void initView() {
    ResizeableLayout resizeableLayout = new ResizeableLayout((Context)this);
    resizeableLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    resizeableLayout.setBackgroundColor(-855310);
    this.titleBar = new TitleBar((Context)this);
    this.titleBar.setId(1);
    this.titleBar.setLeftBtnText(ResourceManager.getString((Context)this, "Cancel", "取消", "取消"));
    this.titleBar.setTitleBarText(this.mSpecifyTitle);
    this.titleBar.setTitleBarClickListener(new TitleBar.ListenerOnTitleBtnClicked() {
          public void onLeftBtnClicked() {
            MobileRegisterActivity.this.setResult(0);
            MobileRegisterActivity.this.finish();
          }
        });
    resizeableLayout.addView((View)this.titleBar);
    View view = new View((Context)this);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 2));
    view.setBackgroundDrawable(ResourceManager.getNinePatchDrawable((Context)this, "weibosdk_common_shadow_top.9.png"));
    layoutParams6.addRule(3, 1);
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    resizeableLayout.addView(view);
    this.mRegistScrollview = new ScrollView((Context)this);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams4.topMargin = ResourceManager.dp2px((Context)this, 47);
    this.mRegistScrollview.setBackgroundColor(-855310);
    this.mRegistScrollview.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.mRegiter_llt = new LinearLayout((Context)this);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
    this.mRegiter_llt.setOrientation(1);
    this.mRegiter_llt.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.mInfoText = new TextView((Context)this);
    this.mInfoText.setTextSize(2, 13.0F);
    this.mInfoText.setHeight(ResourceManager.dp2px((Context)this, 44));
    this.mInfoText.setGravity(17);
    this.mInfoText.setTextColor(-8224126);
    this.mInfoText.setText(ResourceManager.getString((Context)this, "Confirm your country/region and enter your mobile number", "请确认国家和地区并填写手机号码", "請確認國家和地區并填寫手機號"));
    this.mInfoText.setFocusable(true);
    this.mInfoText.setFocusableInTouchMode(true);
    this.mRegiter_llt.addView((View)this.mInfoText);
    this.mCountryLayout = new RelativeLayout((Context)this);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 48));
    this.mCountryLayout.setBackgroundDrawable((Drawable)ResourceManager.createStateListDrawable((Context)this, "login_country_background.9.png", "login_country_background_highlighted.9.png"));
    this.mCountryLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.mCountryCode = new TextView((Context)this);
    this.mCountryCode.setTextSize(2, 17.0F);
    this.mCountryCode.setText("0086");
    this.mCountryCode.setTextColor(-11382190);
    this.mCountryCode.setGravity(3);
    this.mCountryCode.setGravity(16);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, ResourceManager.dp2px((Context)this, 48));
    layoutParams2.leftMargin = ResourceManager.dp2px((Context)this, 15);
    layoutParams2.addRule(9);
    this.mCountryCode.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    ImageView imageView = new ImageView((Context)this);
    imageView.setId(2);
    imageView.setImageDrawable(ResourceManager.getDrawable((Context)this, "triangle.png"));
    layoutParams6 = new RelativeLayout.LayoutParams(ResourceManager.dp2px((Context)this, 13), ResourceManager.dp2px((Context)this, 13));
    layoutParams6.rightMargin = ResourceManager.dp2px((Context)this, 15);
    layoutParams6.addRule(11);
    layoutParams6.addRule(15);
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    this.mCountryName = new TextView((Context)this);
    this.mCountryName.setTextSize(2, 17.0F);
    this.mCountryName.setTextColor(-11382190);
    this.mCountryName.setText(this.mCountryNameStr);
    this.mCountryName.setGravity(16);
    layoutParams6 = new RelativeLayout.LayoutParams(-2, ResourceManager.dp2px((Context)this, 48));
    layoutParams6.rightMargin = ResourceManager.dp2px((Context)this, 118);
    layoutParams6.addRule(0, 2);
    layoutParams6.addRule(15);
    this.mCountryName.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    this.mCountryLayout.addView((View)this.mCountryCode);
    this.mCountryLayout.addView((View)this.mCountryName);
    this.mCountryLayout.addView((View)imageView);
    this.mRegiter_llt.addView((View)this.mCountryLayout);
    LinearLayout linearLayout = new LinearLayout((Context)this);
    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams5.topMargin = ResourceManager.dp2px((Context)this, 10);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    linearLayout.setOrientation(1);
    RelativeLayout relativeLayout1 = new RelativeLayout((Context)this);
    LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 50));
    layoutParams8.gravity = 16;
    relativeLayout1.setBackgroundDrawable(ResourceManager.getNinePatchDrawable((Context)this, "login_top_background.9.png"));
    relativeLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams8);
    this.mPhoneNumClearBtn = new ImageView((Context)this);
    this.mPhoneNumClearBtn.setId(4);
    this.mPhoneNumClearBtn.setImageDrawable((Drawable)ResourceManager.createStateListDrawable((Context)this, "search_clear_btn_normal.png", "search_clear_btn_down.png"));
    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(ResourceManager.dp2px((Context)this, 22), ResourceManager.dp2px((Context)this, 22));
    layoutParams7.rightMargin = ResourceManager.dp2px((Context)this, 15);
    layoutParams7.addRule(11);
    layoutParams7.addRule(15);
    this.mPhoneNumClearBtn.setVisibility(4);
    this.mPhoneNumClearBtn.setLayoutParams((ViewGroup.LayoutParams)layoutParams7);
    relativeLayout1.addView((View)this.mPhoneNumClearBtn);
    this.mPhoneNum = new EditText((Context)this);
    this.mPhoneNum.setTextSize(2, 16.0F);
    this.mPhoneNum.setTextColor(-16777216);
    this.mPhoneNum.setHint(ResourceManager.getString((Context)this, "Your mobile number", "请输入手机号码", "請輸入手機號"));
    this.mPhoneNum.setHintTextColor(-4342339);
    this.mPhoneNum.setBackgroundDrawable(null);
    this.mPhoneNum.setSelected(false);
    layoutParams7 = new RelativeLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 50));
    layoutParams7.topMargin = ResourceManager.dp2px((Context)this, 0);
    layoutParams7.bottomMargin = ResourceManager.dp2px((Context)this, 0);
    layoutParams7.leftMargin = ResourceManager.dp2px((Context)this, 0);
    layoutParams7.rightMargin = ResourceManager.dp2px((Context)this, 0);
    layoutParams7.addRule(0, 4);
    this.mPhoneNum.setLayoutParams((ViewGroup.LayoutParams)layoutParams7);
    relativeLayout1.addView((View)this.mPhoneNum);
    RelativeLayout relativeLayout2 = new RelativeLayout((Context)this);
    RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 50));
    relativeLayout2.setBackgroundDrawable(ResourceManager.getNinePatchDrawable((Context)this, "login_bottom_background.9.png"));
    relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams9);
    this.mGetCodeBtn = new Button((Context)this);
    this.mGetCodeBtn.setId(3);
    this.mGetCodeBtn.setBackgroundDrawable((Drawable)ResourceManager.createStateListDrawable((Context)this, "get_code_button.9.png", "get_code_button_highlighted.9.png"));
    layoutParams9 = new RelativeLayout.LayoutParams(-2, ResourceManager.dp2px((Context)this, 29));
    layoutParams9.rightMargin = ResourceManager.dp2px((Context)this, 12);
    layoutParams9.addRule(11);
    layoutParams9.addRule(15);
    this.mGetCodeBtn.setPadding(18, 0, 18, 0);
    this.mGetCodeBtn.setLayoutParams((ViewGroup.LayoutParams)layoutParams9);
    this.mGetCodeBtn.setText(ResourceManager.getString((Context)this, "Get code", "获取验证码", "獲取驗證碼"));
    this.mGetCodeBtn.setTextSize(15.0F);
    enableGetCodeBtn();
    relativeLayout2.addView((View)this.mGetCodeBtn);
    this.mCheckCode = new EditText((Context)this);
    this.mCheckCode.setTextSize(2, 16.0F);
    this.mCheckCode.setTextColor(-16777216);
    this.mCheckCode.setHintTextColor(-4342339);
    this.mCheckCode.setHint(ResourceManager.getString((Context)this, "Verification code", "请输入验证码", "請輸入驗證碼"));
    this.mCheckCode.setBackgroundDrawable(null);
    layoutParams9 = new RelativeLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 48));
    layoutParams9.addRule(0, 3);
    this.mCheckCode.setLayoutParams((ViewGroup.LayoutParams)layoutParams9);
    relativeLayout2.addView((View)this.mCheckCode);
    linearLayout.addView((View)relativeLayout1);
    linearLayout.addView((View)relativeLayout2);
    this.mRegiter_llt.addView((View)linearLayout);
    this.mGetCodeBtn.setOnClickListener(this);
    this.mTips = new TextView((Context)this);
    this.mTips.setTextSize(2, 13.0F);
    this.mTips.setTextColor(-2014941);
    this.mTips.setText("");
    this.mTips.setVisibility(4);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 36));
    layoutParams1.leftMargin = ResourceManager.dp2px((Context)this, 12);
    this.mTips.setGravity(16);
    this.mTips.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.mRegiter_llt.addView((View)this.mTips);
    this.mBtnRegist = genOKBtn();
    disableRegisterBtn();
    this.mRegiter_llt.addView((View)this.mBtnRegist);
    TextView textView1 = genSinaServiceTv();
    TextView textView2 = genProtocalInfoTv();
    this.mRegiter_llt.addView((View)textView1);
    this.mRegiter_llt.addView((View)textView2);
    this.mRegistScrollview.addView((View)this.mRegiter_llt);
    resizeableLayout.addView((View)this.mRegistScrollview);
    initLoadingDlg();
    this.mPhoneNum.setInputType(2);
    this.mPhoneNum.addTextChangedListener(new PhoneNumTextWatcher(null));
    this.mCheckCode.setInputType(2);
    this.mCheckCode.addTextChangedListener(new CodeTextWatcher(null));
    this.mPhoneNumClearBtn.setOnClickListener(this);
    this.mPhoneNum.setOnFocusChangeListener(this);
    this.mBtnRegist.setOnClickListener(this);
    this.mCountryLayout.setOnClickListener(this);
    resizeableLayout.setSizeChangeListener(this);
    setContentView((View)resizeableLayout);
  }
  
  private void showNetFail() {
    UIUtils.showToast(getApplicationContext(), ResourceManager.getString(getApplicationContext(), "your network is  disabled  try again later", "您的网络不可用，请稍后", "您的網絡不可用，請稍後"), 0);
  }
  
  private boolean verifyCheckCode(String paramString) {
    return (!TextUtils.isEmpty(paramString) && paramString.length() == 6);
  }
  
  private boolean verifyPhoneNum(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ("0086".equals(this.mCountryCodeStr) ? ((paramString.trim().length() == 11)) : true);
  }
  
  public void dismiss() {
    ProgressDialog progressDialog = this.mLoadingDlg;
    if (progressDialog != null && progressDialog.isShowing())
      this.mLoadingDlg.dismiss(); 
  }
  
  public void getMsg(String paramString1, String paramString2) {
    WeiboParameters weiboParameters = new WeiboParameters(this.mAppkey);
    weiboParameters.put("appkey", this.mAppkey);
    weiboParameters.put("packagename", this.mPackageName);
    weiboParameters.put("key_hash", this.mKeyHash);
    if (!"0086".equals(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2));
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
    } 
    weiboParameters.put("phone", paramString1);
    weiboParameters.put("version", "0031405000");
    NetUtils.internalHttpRequest((Context)this, "http://api.weibo.com/oauth2/sms_authorize/send", weiboParameters, "GET", new RequestListener() {
          public void onComplete(String param1String) {
            String str = MobileRegisterActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder("get onComplete : ");
            stringBuilder.append(param1String);
            LogUtil.d(str, stringBuilder.toString());
            if (param1String != null)
              try {
                JSONObject jSONObject = new JSONObject(param1String);
                MobileRegisterActivity.this.cfrom = (String)jSONObject.get("cfrom");
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public void onWeiboException(WeiboException param1WeiboException) {
            String str1;
            String str2 = MobileRegisterActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder("get onWeiboException ");
            stringBuilder.append(param1WeiboException.getMessage());
            LogUtil.d(str2, stringBuilder.toString());
            str2 = ResourceManager.getString(MobileRegisterActivity.this.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
            try {
              JSONObject jSONObject = new JSONObject(param1WeiboException.getMessage());
              str1 = str2;
              if (!TextUtils.isEmpty(jSONObject.optString("error_description")))
                str1 = jSONObject.optString("error_description"); 
            } catch (Exception exception) {
              exception.printStackTrace();
              str1 = str2;
            } 
            UIUtils.showToast(MobileRegisterActivity.this.getApplicationContext(), str1, 1);
          }
        });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 0)
      return; 
    if (paramIntent != null) {
      this.mCountryCodeStr = paramIntent.getStringExtra("code");
      this.mCountryNameStr = paramIntent.getStringExtra("name");
      this.mCountryCode.setText(this.mCountryCodeStr);
      this.mCountryName.setText(this.mCountryNameStr);
    } 
  }
  
  public void onClick(View paramView) {
    String str;
    if (paramView == this.mGetCodeBtn) {
      str = this.mPhoneNum.getText().toString();
      String str1 = this.mCountryCode.getText().toString();
      if (doCheckOnGetMsg(str)) {
        this.mCountDownTimer.start();
        disableGetCodeBtn();
        getMsg(str, str1);
        return;
      } 
    } else {
      if (str == this.mPhoneNumClearBtn) {
        this.mPhoneNum.setText("");
        return;
      } 
      if (str == this.mBtnRegist) {
        str = this.mPhoneNum.getText().toString();
        String str1 = this.mCheckCode.getText().toString();
        if (doCheckOnSubmit(str1)) {
          submit(str, str1);
          return;
        } 
      } else if (str == this.mCountryLayout) {
        this.mTips.setVisibility(4);
        Intent intent = new Intent();
        intent.setClass((Context)this, SelectCountryActivity.class);
        startActivityForResult(intent, 0);
      } 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {
      UIUtils.showToast(getApplicationContext(), "Pass wrong params!!", 0);
      finish();
    } 
    this.mAppkey = paramBundle.getString("appKey");
    this.mPackageName = paramBundle.getString("packagename");
    this.mKeyHash = paramBundle.getString("key_hash");
    if (TextUtils.isEmpty(this.mAppkey)) {
      UIUtils.showToast(getApplicationContext(), ResourceManager.getString((Context)this, "your appkey not set", "您的app_key没有设置", "您的app_key沒有設置"), 0);
      finish();
    } 
    String str2 = paramBundle.getString("register_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = ResourceManager.getString((Context)this, "Login", "验证码登录", "驗證碼登錄"); 
    this.mSpecifyTitle = str1;
    this.mCountryCodeStr = "0086";
    this.mCountryNameStr = ResourceManager.getString((Context)this, "China", "中国", "中國");
    initView();
    this.mCountDownTimer = new CountDownTimer(60000L, 1000L) {
        public void onFinish() {
          MobileRegisterActivity.this.mGetCodeBtn.setText(ResourceManager.getString(MobileRegisterActivity.this.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼"));
          MobileRegisterActivity.this.enableGetCodeBtn();
        }
        
        public void onTick(long param1Long) {
          Button button = MobileRegisterActivity.this.mGetCodeBtn;
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(ResourceManager.getString(MobileRegisterActivity.this.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼")));
          stringBuilder.append("(");
          stringBuilder.append(param1Long / 1000L);
          stringBuilder.append("s)");
          button.setText(stringBuilder.toString());
        }
      };
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    EditText editText = this.mPhoneNum;
    if (paramView == editText && !paramBoolean) {
      if (verifyPhoneNum(editText.getText().toString())) {
        this.mTips.setVisibility(4);
        return;
      } 
      this.mTips.setText(ResourceManager.getString((Context)this, "Your phone number isn’t 11-digit long", "您的手机号不是11位数", "您的手機號不是11位數"));
      this.mTips.setVisibility(0);
    } 
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      setResult(0);
      finish();
      return true;
    } 
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    if (displayMetrics.widthPixels <= displayMetrics.heightPixels) {
      paramInt3 = this.mMaxHeight;
      paramInt1 = paramInt3;
      if (paramInt3 < paramInt2)
        paramInt1 = paramInt2; 
      this.mMaxHeight = paramInt1;
      paramInt1 = 1;
      if (paramInt2 >= paramInt4 && (paramInt2 <= paramInt4 || paramInt2 >= this.mMaxHeight) && (paramInt2 != paramInt4 || paramInt2 == this.mMaxHeight))
        paramInt1 = 0; 
      this.mInputHandler.sendEmptyMessage(paramInt1);
    } 
  }
  
  public void submit(final String phoneNum, String paramString2) {
    WeiboParameters weiboParameters = new WeiboParameters(this.mAppkey);
    weiboParameters.put("appkey", this.mAppkey);
    weiboParameters.put("packagename", this.mPackageName);
    weiboParameters.put("key_hash", this.mKeyHash);
    weiboParameters.put("phone", phoneNum);
    weiboParameters.put("version", "0031405000");
    weiboParameters.put("code", paramString2);
    weiboParameters.put("cfrom", this.cfrom);
    this.mLoadingDlg.show();
    NetUtils.internalHttpRequest((Context)this, "http://api.weibo.com/oauth2/sms_authorize/submit", weiboParameters, "GET", new RequestListener() {
          public void onComplete(String param1String) {
            MobileRegisterActivity.this.dismiss();
            String str = MobileRegisterActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder("get onComplete : ");
            stringBuilder.append(param1String);
            LogUtil.d(str, stringBuilder.toString());
            if (param1String != null)
              try {
                JSONObject jSONObject = new JSONObject(param1String);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("uid", jSONObject.optString("uid"));
                bundle.putString("phone_num", phoneNum);
                bundle.putString("access_token", jSONObject.optString("oauth_token"));
                bundle.putString("expires_in", jSONObject.optString("expires"));
                intent.putExtras(bundle);
                MobileRegisterActivity.this.setResult(-1, intent);
                MobileRegisterActivity.this.finish();
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public void onWeiboException(WeiboException param1WeiboException) {
            String str1;
            String str2 = MobileRegisterActivity.TAG;
            StringBuilder stringBuilder = new StringBuilder("get onWeiboException ");
            stringBuilder.append(param1WeiboException.getMessage());
            LogUtil.d(str2, stringBuilder.toString());
            str2 = ResourceManager.getString(MobileRegisterActivity.this.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
            try {
              JSONObject jSONObject = new JSONObject(param1WeiboException.getMessage());
              str1 = str2;
              if (!TextUtils.isEmpty(jSONObject.optString("error_description")))
                str1 = jSONObject.optString("error_description"); 
            } catch (Exception exception) {
              exception.printStackTrace();
              str1 = str2;
            } 
            MobileRegisterActivity.this.mTips.setVisibility(0);
            MobileRegisterActivity.this.mTips.setText(str1);
            MobileRegisterActivity.this.dismiss();
          }
        });
  }
  
  class CodeTextWatcher implements TextWatcher {
    private CodeTextWatcher() {}
    
    public void afterTextChanged(Editable param1Editable) {
      if (TextUtils.isEmpty(MobileRegisterActivity.this.mPhoneNum.getText().toString()) || TextUtils.isEmpty(MobileRegisterActivity.this.mCheckCode.getText().toString())) {
        MobileRegisterActivity.this.disableRegisterBtn();
        return;
      } 
      MobileRegisterActivity.this.enableRegisterBtn();
    }
    
    public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
  }
  
  class InputHandler extends Handler {
    private InputHandler() {}
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 0) {
        if (i != 1)
          return; 
        MobileRegisterActivity.this.mInfoText.setVisibility(8);
        MobileRegisterActivity.this.mCountryLayout.setVisibility(8);
        return;
      } 
      MobileRegisterActivity.this.mInfoText.setVisibility(0);
      MobileRegisterActivity.this.mCountryLayout.setVisibility(0);
    }
  }
  
  class PhoneNumTextWatcher implements TextWatcher {
    private PhoneNumTextWatcher() {}
    
    public void afterTextChanged(Editable param1Editable) {
      if (TextUtils.isEmpty(MobileRegisterActivity.this.mPhoneNum.getText().toString()) || TextUtils.isEmpty(MobileRegisterActivity.this.mCheckCode.getText().toString())) {
        MobileRegisterActivity.this.disableRegisterBtn();
        return;
      } 
      MobileRegisterActivity.this.enableRegisterBtn();
    }
    
    public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
      if (TextUtils.isEmpty(MobileRegisterActivity.this.mPhoneNum.getText().toString())) {
        MobileRegisterActivity.this.mPhoneNumClearBtn.setVisibility(4);
        return;
      } 
      MobileRegisterActivity.this.mPhoneNumClearBtn.setVisibility(0);
    }
  }
  
  class WBSdkUrlClickSpan extends ClickableSpan {
    private Context context;
    
    private String url;
    
    public WBSdkUrlClickSpan(Context param1Context, String param1String) {
      this.context = param1Context;
      this.url = param1String;
    }
    
    public void onClick(View param1View) {
      Intent intent = new Intent(this.context, WeiboSdkBrowser.class);
      Bundle bundle = new Bundle();
      bundle.putString("key_url", this.url);
      intent.putExtras(bundle);
      MobileRegisterActivity.this.startActivity(intent);
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(-11502161);
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\MobileRegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
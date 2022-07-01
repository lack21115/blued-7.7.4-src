package com.soft.blued.utils.password;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

public class PasswordStatusView extends LinearLayout {
  private View a;
  
  private Context b;
  
  private ImageView c;
  
  private TextView d;
  
  public PasswordStatusView(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    a();
  }
  
  public PasswordStatusView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  public PasswordStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a();
  }
  
  private void a() {
    this.a = LayoutInflater.from(this.b).inflate(2131493787, (ViewGroup)this);
    this.c = (ImageView)this.a.findViewById(2131297544);
    this.d = (TextView)this.a.findViewById(2131301209);
    setVisibility(4);
  }
  
  public void a(EditText paramEditText1, EditText paramEditText2, String paramString, PasswordCheckUtils.PWD_CHECK_PAGE paramPWD_CHECK_PAGE, IRequestHost paramIRequestHost, OnCheckResult paramOnCheckResult) {
    if (paramEditText1 != null) {
      if (paramEditText2 == null)
        return; 
      PasswordCheckUtils.a().a(new PasswordCheckUtils.CheckCallBackListener(this, paramOnCheckResult) {
            public void a() {
              this.b.setVisibility(0);
              PasswordStatusView.a(this.b).setImageResource(2131232683);
              PasswordStatusView.c(this.b).setText(PasswordStatusView.b(this.b).getResources().getString(2131758485));
              Animation animation = AnimationUtils.loadAnimation(PasswordStatusView.b(this.b), 2130772001);
              if (animation != null) {
                PasswordStatusView.a(this.b).setAnimation(animation);
                PasswordStatusView.a(this.b).startAnimation(animation);
              } 
            }
            
            public void a(int param1Int, String param1String) {
              PasswordStatusView.c(this.b).setText(param1String);
              PasswordStatusView.a(this.b).clearAnimation();
              if (param1Int == 0) {
                PasswordStatusView.a(this.b).setImageResource(2131232684);
              } else {
                PasswordStatusView.a(this.b).setImageResource(2131232685);
              } 
              PasswordStatusView.OnCheckResult onCheckResult = this.a;
              if (onCheckResult != null) {
                boolean bool;
                if (param1Int == 0) {
                  bool = true;
                } else {
                  bool = false;
                } 
                onCheckResult.onResult(bool);
              } 
            }
          }paramIRequestHost);
      paramEditText1.addTextChangedListener(new TextWatcher(this, paramEditText2, paramEditText1, paramString, paramPWD_CHECK_PAGE) {
            public void afterTextChanged(Editable param1Editable) {
              Logger.a("pwd_check", param1Editable.toString());
              PasswordCheckUtils.a().a(PasswordStatusView.b(this.e), this.a.getText().toString(), "");
              PasswordCheckUtils.a().a(this.b.getText().toString(), this.c, this.d);
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
    } 
  }
  
  public void a(EditText paramEditText1, EditText paramEditText2, String paramString1, String paramString2, PasswordCheckUtils.PWD_CHECK_PAGE paramPWD_CHECK_PAGE, IRequestHost paramIRequestHost, OnCheckResult paramOnCheckResult) {
    if (paramEditText1 != null) {
      if (paramEditText2 == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("account:");
      stringBuilder.append(paramString1);
      stringBuilder.append(";name:");
      stringBuilder.append(paramString2);
      Logger.a("pwd_check", stringBuilder.toString());
      PasswordCheckUtils.a().a(this.b, paramString1, paramString2);
      PasswordCheckUtils.a().a(new PasswordCheckUtils.CheckCallBackListener(this, paramOnCheckResult) {
            public void a() {
              this.b.setVisibility(0);
              PasswordStatusView.a(this.b).setImageResource(2131232683);
              PasswordStatusView.c(this.b).setText(PasswordStatusView.b(this.b).getResources().getString(2131758485));
              Animation animation = AnimationUtils.loadAnimation(PasswordStatusView.b(this.b), 2130772001);
              if (animation != null) {
                PasswordStatusView.a(this.b).setAnimation(animation);
                PasswordStatusView.a(this.b).startAnimation(animation);
              } 
            }
            
            public void a(int param1Int, String param1String) {
              PasswordStatusView.c(this.b).setText(param1String);
              PasswordStatusView.a(this.b).clearAnimation();
              if (param1Int == 0) {
                PasswordStatusView.a(this.b).setImageResource(2131232684);
              } else {
                PasswordStatusView.a(this.b).setImageResource(2131232685);
              } 
              PasswordStatusView.OnCheckResult onCheckResult = this.a;
              if (onCheckResult != null) {
                boolean bool;
                if (param1Int == 0) {
                  bool = true;
                } else {
                  bool = false;
                } 
                onCheckResult.onResult(bool);
              } 
            }
          }paramIRequestHost);
      paramEditText1.addTextChangedListener(new TextWatcher(this, paramEditText1, paramEditText2, paramPWD_CHECK_PAGE) {
            public void afterTextChanged(Editable param1Editable) {
              if (!StringUtils.e(this.a.getText().toString()) && !StringUtils.e(this.b.getText().toString())) {
                if (this.a.getText().toString().equals(this.b.getText().toString())) {
                  PasswordCheckUtils.a().a(this.a.getText().toString(), UserInfo.a().d(), this.c);
                  return;
                } 
                this.d.setVisibility(0);
                PasswordStatusView.a(this.d).clearAnimation();
                PasswordStatusView.a(this.d).setImageResource(2131232684);
                PasswordStatusView.c(this.d).setText(PasswordStatusView.b(this.d).getResources().getString(2131758484));
                return;
              } 
              this.d.setVisibility(4);
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
      paramEditText2.addTextChangedListener(new TextWatcher(this, paramEditText1, paramEditText2, paramPWD_CHECK_PAGE) {
            public void afterTextChanged(Editable param1Editable) {
              if (!StringUtils.e(this.a.getText().toString()) && !StringUtils.e(this.b.getText().toString())) {
                if (this.a.getText().toString().equals(this.b.getText().toString())) {
                  PasswordCheckUtils.a().a(this.a.getText().toString(), UserInfo.a().d(), this.c);
                  return;
                } 
                this.d.setVisibility(0);
                PasswordStatusView.a(this.d).clearAnimation();
                PasswordStatusView.a(this.d).setImageResource(2131232684);
                PasswordStatusView.c(this.d).setText(PasswordStatusView.b(this.d).getResources().getString(2131758484));
                return;
              } 
              this.d.setVisibility(4);
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
    } 
  }
  
  public static interface OnCheckResult {
    void onResult(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\password\PasswordStatusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
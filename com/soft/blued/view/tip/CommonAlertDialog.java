package com.soft.blued.view.tip;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.CustomDialog;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;
import com.soft.blued.view.tip.model.DialogWith6PW;

public class CommonAlertDialog {
  public static AlertDialog a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, TextOnClickListener paramTextOnClickListener, DialogInterface.OnClickListener paramOnClickListener) {
    if (paramString5 == null)
      paramString5 = ""; 
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(0, DensityUtils.a(paramContext, 10.0F), 0, DensityUtils.a(paramContext, 10.0F));
    EditText editText = new EditText(paramContext);
    editText.setText(paramString5);
    editText.setHint(paramString6);
    editText.setSelection(paramString5.length());
    editText.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    editText.requestFocus();
    editText.setSingleLine(true);
    TextView textView = new TextView(paramContext);
    layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(0, 0, DensityUtils.a(paramContext, 3.0F), 0);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    textView.setGravity(5);
    textView.setTextColor(paramContext.getResources().getColor(2131100234));
    linearLayout.addView((View)editText);
    linearLayout.addView((View)textView);
    linearLayout.setPadding(DensityUtils.a(paramContext, 22.0F), 0, DensityUtils.a(paramContext, 27.0F), 0);
    int i = StringUtils.j(paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("/");
    stringBuilder.append(paramInt);
    textView.setText(stringBuilder.toString());
    editText.setSelection(paramString5.length());
    editText.addTextChangedListener(new TextWatcher(editText, paramInt, textView) {
          private int d;
          
          private int e;
          
          public void afterTextChanged(Editable param1Editable) {
            try {
              this.a.removeTextChangedListener(this);
              this.d = this.a.getSelectionStart();
              this.e = this.a.getSelectionEnd();
              while (StringUtils.a(param1Editable) > this.b) {
                param1Editable.delete(this.d - 1, this.e);
                this.d--;
                this.e--;
              } 
              TextView textView = this.c;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(StringUtils.a(param1Editable));
              stringBuilder.append("/");
              stringBuilder.append(this.b);
              textView.setText(stringBuilder.toString());
              this.a.setSelection(this.d);
              this.a.addTextChangedListener(this);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              this.c.setText("");
              return;
            } 
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    AlertDialog.Builder builder2 = new AlertDialog.Builder(paramContext);
    AlertDialog.Builder builder1 = builder2.setTitle(paramString1).setView((View)linearLayout);
    if (StringUtils.e(paramString4))
      paramString4 = paramContext.getResources().getString(2131755609); 
    builder1 = builder1.setPositiveButton(paramString4, new DialogInterface.OnClickListener(paramTextOnClickListener, editText) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CommonAlertDialog.TextOnClickListener textOnClickListener = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.getText());
            stringBuilder.append("");
            textOnClickListener.a(stringBuilder.toString());
          }
        });
    if (StringUtils.e(paramString3))
      paramString3 = paramContext.getResources().getString(2131755577); 
    builder1.setNegativeButton(paramString3, paramOnClickListener).setCancelable(true).setOnCancelListener(null);
    if (!TextUtils.isEmpty(paramString2))
      builder2.setMessage(paramString2); 
    AlertDialog alertDialog = builder2.create();
    alertDialog.getWindow().setSoftInputMode(5);
    alertDialog.setCanceledOnTouchOutside(true);
    alertDialog.show();
    return alertDialog;
  }
  
  @Deprecated
  public static Dialog a(Context paramContext, View paramView, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean) {
    return a(paramContext, paramView, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener, paramBoolean, true);
  }
  
  @Deprecated
  public static Dialog a(Context paramContext, View paramView, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean1, boolean paramBoolean2) {
    AlertDialog.Builder builder2 = new AlertDialog.Builder(paramContext);
    AlertDialog.Builder builder1 = builder2.setTitle(paramString1).setView(paramView);
    String str = paramString4;
    if (StringUtils.e(paramString4))
      str = paramContext.getResources().getString(2131755609); 
    builder1 = builder1.setPositiveButton(str, paramOnClickListener1);
    str = paramString3;
    if (StringUtils.e(paramString3))
      str = paramContext.getResources().getString(2131755577); 
    builder1.setNegativeButton(str, paramOnClickListener2).setCancelable(paramBoolean1).setOnCancelListener(paramOnCancelListener);
    if (!TextUtils.isEmpty(paramString2))
      builder2.setMessage(paramString2); 
    AlertDialog alertDialog = builder2.create();
    alertDialog.setCanceledOnTouchOutside(paramBoolean2);
    alertDialog.show();
    return (Dialog)alertDialog;
  }
  
  public static CustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2) {
    CustomDialog customDialog = new CustomDialog(paramContext, 2131821111);
    View view = LayoutInflater.from(paramContext).inflate(2131493743, null);
    TextView textView3 = (TextView)view.findViewById(2131301409);
    if (TextUtils.isEmpty(paramString1)) {
      textView3.setVisibility(8);
    } else {
      textView3.setText(paramString1);
    } 
    ((TextView)view.findViewById(2131300703)).setText(paramString2);
    TextView textView2 = (TextView)view.findViewById(2131300611);
    if (TextUtils.isEmpty(paramString1)) {
      textView2.setVisibility(8);
      view.findViewById(2131300719).setVisibility(8);
    } else {
      textView2.setText(paramString4);
      textView2.setOnClickListener(new View.OnClickListener(customDialog, paramOnClickListener2) {
            public void onClick(View param1View) {
              CustomDialog customDialog = this.a;
              if (customDialog != null && customDialog.isShowing())
                this.a.dismiss(); 
              View.OnClickListener onClickListener = this.b;
              if (onClickListener != null)
                onClickListener.onClick(param1View); 
            }
          });
    } 
    TextView textView1 = (TextView)view.findViewById(2131301130);
    textView1.setText(paramString3);
    textView1.setOnClickListener(new View.OnClickListener(customDialog, paramOnClickListener1) {
          public void onClick(View param1View) {
            CustomDialog customDialog = this.a;
            if (customDialog != null && customDialog.isShowing())
              this.a.dismiss(); 
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null)
              onClickListener.onClick(param1View); 
          }
        });
    customDialog.a(view, null);
    return customDialog;
  }
  
  public static BluedAlertDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, View paramView, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3) {
    BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(paramContext);
    builder.c(paramInt1).a(paramString1).b(paramString2).a(paramView).a(paramString3, paramOnClickListener1).b(paramString4, paramOnClickListener2).a(paramBoolean1).b(paramBoolean2).a(paramOnDismissListener).a(paramInt2).b(paramInt3);
    BluedAlertDialog bluedAlertDialog = builder.a();
    bluedAlertDialog.setCanceledOnTouchOutside(paramBoolean3);
    bluedAlertDialog.show();
    return bluedAlertDialog;
  }
  
  public static BluedAlertDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener) {
    if (paramString3 == null)
      paramString3 = paramContext.getString(2131755609); 
    return a(paramContext, paramInt, paramString1, paramString2, null, paramString3, paramOnClickListener, null, null, paramOnDismissListener, true, 1, 0, true, false);
  }
  
  public static BluedAlertDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt2) {
    if (paramString3 == null)
      paramString3 = paramContext.getString(2131755609); 
    if (paramString4 == null)
      paramString4 = paramContext.getString(2131755577); 
    return a(paramContext, paramInt1, paramString1, paramString2, null, paramString3, paramOnClickListener1, paramString4, paramOnClickListener2, paramOnDismissListener, true, 1, paramInt2, true, false);
  }
  
  public static BluedAlertDialog a(Context paramContext, View paramView, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener) {
    if (paramString1 == null)
      paramString1 = paramContext.getString(2131755609); 
    if (paramString2 == null)
      paramString2 = paramContext.getString(2131755577); 
    return a(paramContext, 0, "", "", paramView, paramString1, paramOnClickListener1, paramString2, paramOnClickListener2, paramOnDismissListener, false, 3, 0, true, false);
  }
  
  public static BluedAlertDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener) {
    return a(paramContext, 0, "", paramString, null, paramContext.getString(2131755609), paramOnClickListener, paramContext.getString(2131755577), null, null, false, 0, 0, true, false);
  }
  
  public static BluedAlertDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt) {
    if (paramString3 == null)
      paramString3 = paramContext.getString(2131755609); 
    return a(paramContext, 0, paramString1, paramString2, null, paramString3, paramOnClickListener, null, null, paramOnDismissListener, true, paramInt, 0, true, false);
  }
  
  public static BluedAlertDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener) {
    if (paramString3 == null)
      paramString3 = paramContext.getString(2131755609); 
    if (paramString4 == null)
      paramString4 = paramContext.getString(2131755577); 
    return a(paramContext, 0, paramString1, paramString2, null, paramString3, paramOnClickListener1, paramString4, paramOnClickListener2, paramOnDismissListener, false, 0, 0, true, false);
  }
  
  public static DialogWith6PW a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, PWDListener paramPWDListener, DialogInterface.OnCancelListener paramOnCancelListener) {
    return a(paramContext, paramString1, paramString2, paramBoolean, true, true, true, paramPWDListener, paramOnCancelListener);
  }
  
  public static DialogWith6PW a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, PWDListener paramPWDListener, DialogInterface.OnCancelListener paramOnCancelListener) {
    return a(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, true, paramPWDListener, paramOnCancelListener);
  }
  
  public static DialogWith6PW a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, PWDListener paramPWDListener, DialogInterface.OnCancelListener paramOnCancelListener) {
    DialogWith6PW dialogWith6PW = new DialogWith6PW();
    View view = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131493495, null);
    TextView textView3 = (TextView)view.findViewById(2131300656);
    GridPasswordView gridPasswordView = (GridPasswordView)view.findViewById(2131297271);
    ((ImeDelBugFixedEditText)gridPasswordView.findViewById(2131297595)).setImeOptions(33554432);
    ViewGroup viewGroup = (ViewGroup)view.findViewById(2131301594);
    CheckBox checkBox = (CheckBox)view.findViewById(2131296674);
    TextView textView1 = (TextView)view.findViewById(2131301409);
    TextView textView4 = (TextView)view.findViewById(2131301410);
    TextView textView2 = (TextView)view.findViewById(2131301056);
    if (TextUtils.isEmpty(paramString1)) {
      textView1.setVisibility(8);
      textView4.setVisibility(8);
    } else {
      textView1.setVisibility(0);
      textView4.setVisibility(0);
      textView1.setText(paramString1);
    } 
    if (TextUtils.isEmpty(paramString2)) {
      textView2.setVisibility(8);
    } else {
      textView2.setVisibility(0);
      textView2.setText(paramString2);
    } 
    if (paramBoolean1) {
      gridPasswordView.setPasswordVisibility(true);
    } else {
      gridPasswordView.setPasswordVisibility(false);
    } 
    if (paramBoolean4) {
      viewGroup.setVisibility(0);
    } else {
      viewGroup.setVisibility(8);
    } 
    textView3.setOnClickListener(null);
    gridPasswordView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener(textView3, paramPWDListener, checkBox, dialogWith6PW, paramBoolean2) {
          public void a(String param1String) {
            if (param1String.length() < 6) {
              this.a.setOnClickListener(null);
              this.a.setTextColor(Color.parseColor("#c0c0c0"));
            } 
          }
          
          public void b(String param1String) {
            this.a.setOnClickListener(new View.OnClickListener(this, param1String) {
                  public void onClick(View param2View) {
                    this.b.b.a(this.a, this.b.c.isChecked(), this.b.d);
                    if (this.b.e && this.b.d.a != null && this.b.d.a.isShowing())
                      this.b.d.a.dismiss(); 
                  }
                });
            this.a.setTextColor(Color.parseColor("#3494f4"));
          }
        });
    textView3.requestFocus();
    textView3.setTextColor(Color.parseColor("#c0c0c0"));
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    builder.setView(view).setCancelable(true).setOnCancelListener(paramOnCancelListener);
    AlertDialog alertDialog = builder.create();
    if (paramBoolean3) {
      alertDialog.getWindow().setSoftInputMode(5);
    } else {
      alertDialog.getWindow().setSoftInputMode(19);
    } 
    alertDialog.setCanceledOnTouchOutside(paramBoolean5);
    alertDialog.show();
    dialogWith6PW.a = alertDialog;
    dialogWith6PW.b = gridPasswordView;
    dialogWith6PW.d = textView2;
    dialogWith6PW.c = textView1;
    dialogWith6PW.e = (ScrollView)view.findViewById(2131299836);
    return dialogWith6PW;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, TextOnClickListener paramTextOnClickListener, DialogInterface.OnClickListener paramOnClickListener) {
    String str1 = paramActivity.getResources().getString(2131755609);
    String str2 = paramActivity.getResources().getString(2131755577);
    View view = LayoutInflater.from((Context)paramActivity).inflate(2131493496, null);
    TextView textView = (TextView)view.findViewById(2131300670);
    EditText editText = (EditText)view.findViewById(2131296970);
    editText.requestFocus();
    editText.setSingleLine(true);
    ((TextView)view.findViewById(2131300705)).setText(paramString2);
    int i = StringUtils.j(paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("/");
    stringBuilder.append(20);
    textView.setText(stringBuilder.toString());
    editText.setText(paramString1);
    editText.setHint(2131757862);
    editText.setSelection(paramString1.length());
    editText.post(new -$$Lambda$CommonAlertDialog$IFKz9OjnYOt9E_KB86wgYpiE_PI(paramActivity));
    editText.addTextChangedListener(new TextWatcher(editText, textView) {
          private int c;
          
          private int d;
          
          public void afterTextChanged(Editable param1Editable) {
            try {
              this.a.removeTextChangedListener(this);
              this.c = this.a.getSelectionStart();
              this.d = this.a.getSelectionEnd();
              while (StringUtils.a(param1Editable) > 20) {
                param1Editable.delete(this.c - 1, this.d);
                this.c--;
                this.d--;
              } 
              TextView textView = this.b;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(StringUtils.a(param1Editable));
              stringBuilder.append("/");
              stringBuilder.append(20);
              textView.setText(stringBuilder.toString());
              this.a.setSelection(this.c);
              this.a.addTextChangedListener(this);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              this.b.setText("");
              return;
            } 
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    a((Context)paramActivity, view, str1, new DialogInterface.OnClickListener(paramTextOnClickListener, editText) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CommonAlertDialog.TextOnClickListener textOnClickListener = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.getText());
            stringBuilder.append("");
            textOnClickListener.a(stringBuilder.toString());
          }
        }str2, paramOnClickListener, (DialogInterface.OnDismissListener)null);
  }
  
  private static void a(Dialog paramDialog) {
    if (paramDialog == null)
      return; 
    Window window = paramDialog.getWindow();
    if (window == null)
      return; 
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    WindowManager.LayoutParams layoutParams2 = window.getAttributes();
    WindowManager.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new WindowManager.LayoutParams(); 
    layoutParams1.width = DensityUtils.a(window.getContext(), 185.0F);
    layoutParams1.height = DensityUtils.a(window.getContext(), 70.0F);
    layoutParams1.gravity = 17;
    window.setAttributes(layoutParams1);
  }
  
  public static void a(Context paramContext, int paramInt) {
    View view = LayoutInflater.from(paramContext).inflate(2131493674, null);
    UserRelationshipUtils.a((ImageView)view.findViewById(2131297493), paramInt);
    ((TextView)view.findViewById(2131300893)).setText(StringUtils.a(paramInt));
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    builder.setView(view);
    AlertDialog alertDialog = builder.create();
    alertDialog.setCanceledOnTouchOutside(true);
    alertDialog.show();
    a((Dialog)alertDialog);
  }
  
  @Deprecated
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean) {
    AlertDialog.Builder builder2 = new AlertDialog.Builder(paramContext);
    AlertDialog.Builder builder1 = builder2.setTitle(paramString1).setView(paramView);
    String str = paramString3;
    if (StringUtils.e(paramString3))
      str = paramContext.getResources().getString(2131755609); 
    builder1.setPositiveButton(str, paramOnClickListener).setCancelable(paramBoolean).setOnCancelListener(paramOnCancelListener);
    if (!TextUtils.isEmpty(paramString2))
      builder2.setMessage(paramString2); 
    AlertDialog alertDialog = builder2.create();
    if (paramBoolean)
      alertDialog.setCanceledOnTouchOutside(true); 
    alertDialog.show();
  }
  
  public static void a(Context paramContext, String paramString, String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener) {
    a(paramContext, paramString, paramArrayOfString, paramOnClickListener, (DialogInterface.OnDismissListener)null);
  }
  
  public static void a(Context paramContext, String paramString, String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener) {
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    builder.setItems((CharSequence[])paramArrayOfString, paramOnClickListener);
    if (!StringUtils.e(paramString))
      builder.setTitle(paramString); 
    AlertDialog alertDialog = builder.create();
    alertDialog.setCanceledOnTouchOutside(true);
    if (paramOnDismissListener != null)
      alertDialog.setOnDismissListener(paramOnDismissListener); 
    alertDialog.show();
  }
  
  public static void a(Context paramContext, String paramString, String[] paramArrayOfString, TextOnClickListener paramTextOnClickListener) {
    a(paramContext, paramString, paramArrayOfString, new DialogInterface.OnClickListener(paramArrayOfString, paramTextOnClickListener) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str = this.a[param1Int];
            this.b.a(str);
          }
        });
  }
  
  public static interface PWDListener {
    void a(String param1String, boolean param1Boolean, DialogWith6PW param1DialogWith6PW);
  }
  
  public static interface TextOnClickListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\CommonAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
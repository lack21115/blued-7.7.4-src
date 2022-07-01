package com.blued.android.module.live_china.same.tip;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.blued.blued_third_library.R;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.tip.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;

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
    textView.setTextColor(paramContext.getResources().getColor(R.color.common_v4_blue_frame_font));
    linearLayout.addView((View)editText);
    linearLayout.addView((View)textView);
    linearLayout.setPadding(DensityUtils.a(paramContext, 22.0F), 0, DensityUtils.a(paramContext, 27.0F), 0);
    int i = CommonStringUtils.e(paramString5);
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
              while (CommonStringUtils.a(param1Editable) > this.b) {
                param1Editable.delete(this.d - 1, this.e);
                this.d--;
                this.e--;
              } 
              TextView textView = this.c;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(CommonStringUtils.a(param1Editable));
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
    if (TextUtils.isEmpty(paramString4))
      paramString4 = paramContext.getResources().getString(R.string.biao_v4_ok); 
    builder1 = builder1.setPositiveButton(paramString4, new DialogInterface.OnClickListener(paramTextOnClickListener, editText) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CommonAlertDialog.TextOnClickListener textOnClickListener = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.getText());
            stringBuilder.append("");
            textOnClickListener.a(stringBuilder.toString());
          }
        });
    if (TextUtils.isEmpty(paramString3))
      paramString3 = paramContext.getResources().getString(R.string.biao_v4_cancel); 
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
    if (TextUtils.isEmpty(paramString4))
      str = paramContext.getResources().getString(R.string.biao_v4_ok); 
    builder1 = builder1.setPositiveButton(str, paramOnClickListener1);
    str = paramString3;
    if (TextUtils.isEmpty(paramString3))
      str = paramContext.getResources().getString(R.string.biao_v4_cancel); 
    builder1.setNegativeButton(str, paramOnClickListener2).setCancelable(paramBoolean1).setOnCancelListener(paramOnCancelListener);
    if (!TextUtils.isEmpty(paramString2))
      builder2.setMessage(paramString2); 
    AlertDialog alertDialog = builder2.create();
    alertDialog.setCanceledOnTouchOutside(paramBoolean2);
    alertDialog.show();
    return (Dialog)alertDialog;
  }
  
  public static BluedAlertDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, View paramView, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3) {
    BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(paramContext);
    builder.c(paramInt1).a(paramString1).b(paramString2).a(paramView).a(paramString3, paramOnClickListener1).b(paramString4, paramOnClickListener2).a(paramBoolean1).b(paramBoolean2).a(paramOnDismissListener).a(paramInt2).b(paramInt3);
    BluedAlertDialog bluedAlertDialog = builder.a();
    bluedAlertDialog.setCanceledOnTouchOutside(paramBoolean3);
    bluedAlertDialog.show();
    return bluedAlertDialog;
  }
  
  public static BluedAlertDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener) {
    if (paramString3 == null)
      paramString3 = paramContext.getString(R.string.biao_v4_ok); 
    if (paramString4 == null)
      paramString4 = paramContext.getString(R.string.biao_v4_cancel); 
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
    View view = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.item_dialog_6numpw, null);
    TextView textView3 = (TextView)view.findViewById(R.id.tv_confirm);
    GridPasswordView gridPasswordView = (GridPasswordView)view.findViewById(R.id.gpv_customUi);
    ((ImeDelBugFixedEditText)gridPasswordView.findViewById(R.id.inputView)).setImeOptions(33554432);
    ViewGroup viewGroup = (ViewGroup)view.findViewById(R.id.vg_remember_check);
    CheckBox checkBox = (CheckBox)view.findViewById(R.id.cbx_need_next);
    TextView textView1 = (TextView)view.findViewById(R.id.tv_title);
    TextView textView4 = (TextView)view.findViewById(R.id.tv_title_cutline);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_msg);
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
    dialogWith6PW.e = (ScrollView)view.findViewById(R.id.scrollView);
    return dialogWith6PW;
  }
  
  @Deprecated
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean) {
    AlertDialog.Builder builder2 = new AlertDialog.Builder(paramContext);
    AlertDialog.Builder builder1 = builder2.setTitle(paramString1).setView(paramView);
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3))
      str = paramContext.getResources().getString(R.string.biao_v4_ok); 
    builder1.setPositiveButton(str, paramOnClickListener).setCancelable(paramBoolean).setOnCancelListener(paramOnCancelListener);
    if (!TextUtils.isEmpty(paramString2))
      builder2.setMessage(paramString2); 
    AlertDialog alertDialog = builder2.create();
    if (paramBoolean)
      alertDialog.setCanceledOnTouchOutside(true); 
    alertDialog.show();
  }
  
  public static interface PWDListener {
    void a(String param1String, boolean param1Boolean, DialogWith6PW param1DialogWith6PW);
  }
  
  public static interface TextOnClickListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\tip\CommonAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
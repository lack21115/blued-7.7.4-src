package com.jungly.gridpasswordview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.blued.blued_third_library.R;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;

public class GridPasswordView extends LinearLayout implements PasswordView {
  private ColorStateList a;
  
  private int b = 16;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private Drawable f;
  
  private Drawable g;
  
  private int h;
  
  private String i;
  
  private int j;
  
  private ImeDelBugFixedEditText k;
  
  private String[] l;
  
  private TextView[] m;
  
  private OnPasswordChangedListener n;
  
  private PasswordTransformationMethod o;
  
  private View.OnClickListener p = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        GridPasswordView.a(this.a);
      }
    };
  
  private ImeDelBugFixedEditText.OnDelKeyEventListener q = new ImeDelBugFixedEditText.OnDelKeyEventListener(this) {
      public void a() {
        for (int i = (GridPasswordView.b(this.a)).length - 1; i >= 0; i--) {
          if (GridPasswordView.b(this.a)[i] != null) {
            GridPasswordView.b(this.a)[i] = null;
            GridPasswordView.c(this.a)[i].setText(null);
            GridPasswordView.d(this.a);
            return;
          } 
          GridPasswordView.c(this.a)[i].setText(null);
        } 
      }
    };
  
  private TextWatcher r = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {}
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        if (param1CharSequence == null)
          return; 
        param1CharSequence = param1CharSequence.toString();
        if (param1CharSequence.length() == 1) {
          GridPasswordView.b(this.a)[0] = (String)param1CharSequence;
          GridPasswordView.d(this.a);
          return;
        } 
        if (param1CharSequence.length() == 2) {
          param1CharSequence = param1CharSequence.substring(1);
          for (param1Int1 = 0; param1Int1 < (GridPasswordView.b(this.a)).length; param1Int1++) {
            if (GridPasswordView.b(this.a)[param1Int1] == null) {
              GridPasswordView.b(this.a)[param1Int1] = (String)param1CharSequence;
              GridPasswordView.c(this.a)[param1Int1].setText(param1CharSequence);
              GridPasswordView.d(this.a);
              break;
            } 
          } 
          GridPasswordView.e(this.a).removeTextChangedListener(this);
          GridPasswordView.e(this.a).setText(GridPasswordView.b(this.a)[0]);
          if (GridPasswordView.e(this.a).getText().length() >= 1)
            GridPasswordView.e(this.a).setSelection(1); 
          GridPasswordView.e(this.a).addTextChangedListener(this);
        } 
      }
    };
  
  @Deprecated
  private View.OnKeyListener s = new View.OnKeyListener(this) {
      public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
        if (param1KeyEvent.getAction() == 0 && param1KeyEvent.getKeyCode() == 67) {
          GridPasswordView.f(this.a).a();
          return true;
        } 
        return false;
      }
    };
  
  public GridPasswordView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public GridPasswordView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridPasswordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    super.setBackgroundDrawable(this.g);
    setShowDividers(0);
    setOrientation(0);
    this.o = new CustomPasswordTransformationMethod(this.i);
    b(paramContext);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.gridPasswordView, paramInt, 0);
    this.a = typedArray.getColorStateList(R.styleable.gridPasswordView_textColorGpv);
    if (this.a == null)
      this.a = ColorStateList.valueOf(getResources().getColor(17170435)); 
    paramInt = typedArray.getDimensionPixelSize(R.styleable.gridPasswordView_textSizeGpv, -1);
    if (paramInt != -1)
      this.b = Util.a(paramContext, paramInt); 
    this.c = (int)typedArray.getDimension(R.styleable.gridPasswordView_lineWidthGpv, Util.a(getContext(), 1));
    this.d = typedArray.getColor(R.styleable.gridPasswordView_lineColorGpv, -1433892728);
    this.e = typedArray.getColor(R.styleable.gridPasswordView_gridColorGpv, -1);
    this.f = typedArray.getDrawable(R.styleable.gridPasswordView_lineColorGpv);
    if (this.f == null)
      this.f = (Drawable)new ColorDrawable(this.d); 
    this.g = (Drawable)b();
    this.h = typedArray.getInt(R.styleable.gridPasswordView_passwordLengthGpv, 6);
    this.i = typedArray.getString(R.styleable.gridPasswordView_passwordTransformationGpv);
    if (TextUtils.isEmpty(this.i))
      this.i = "●"; 
    this.j = typedArray.getInt(R.styleable.gridPasswordView_passwordTypeGpv, 0);
    typedArray.recycle();
    paramInt = this.h;
    this.l = new String[paramInt];
    this.m = new TextView[paramInt];
  }
  
  private GradientDrawable b() {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(this.e);
    gradientDrawable.setStroke(this.c, this.d);
    return gradientDrawable;
  }
  
  private void b(Context paramContext) {
    LayoutInflater layoutInflater = LayoutInflater.from(paramContext);
    layoutInflater.inflate(R.layout.gridpasswordview, (ViewGroup)this);
    this.k = (ImeDelBugFixedEditText)findViewById(R.id.inputView);
    this.k.setMaxEms(this.h);
    this.k.addTextChangedListener(this.r);
    this.k.setDelKeyEventListener(this.q);
    setCustomAttr((TextView)this.k);
    this.m[0] = (TextView)this.k;
    for (int i = 1; i < this.h; i++) {
      View view = layoutInflater.inflate(R.layout.divider, null);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.c, -1);
      view.setBackgroundDrawable(this.f);
      addView(view, (ViewGroup.LayoutParams)layoutParams);
      TextView textView = (TextView)layoutInflater.inflate(R.layout.textview, null);
      setCustomAttr(textView);
      addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, -1, 1.0F));
      this.m[i] = textView;
    } 
    setOnClickListener(this.p);
  }
  
  private void c() {
    this.k.setFocusable(true);
    this.k.setFocusableInTouchMode(true);
    this.k.requestFocus();
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)this.k, 1);
  }
  
  private void d() {
    if (this.n == null)
      return; 
    String str = getPassWord();
    this.n.a(str);
    if (str.length() == this.h)
      this.n.b(str); 
  }
  
  private boolean getPassWordVisibility() {
    TextView[] arrayOfTextView = this.m;
    boolean bool = false;
    if (arrayOfTextView[0].getTransformationMethod() == null)
      bool = true; 
    return bool;
  }
  
  private void setCustomAttr(TextView paramTextView) {
    ColorStateList colorStateList = this.a;
    if (colorStateList != null)
      paramTextView.setTextColor(colorStateList); 
    paramTextView.setTextSize(this.b);
    char c = '\022';
    int i = this.j;
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          c = 'á'; 
      } else {
        c = '';
      } 
    } else {
      c = '';
    } 
    paramTextView.setInputType(c);
    paramTextView.setTransformationMethod((TransformationMethod)this.o);
  }
  
  private void setError(String paramString) {
    this.k.setError(paramString);
  }
  
  public void a() {
    int i = 0;
    while (true) {
      String[] arrayOfString = this.l;
      if (i < arrayOfString.length) {
        arrayOfString[i] = null;
        this.m[i].setText(null);
        i++;
        continue;
      } 
      break;
    } 
  }
  
  public String getPassWord() {
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    while (true) {
      String[] arrayOfString = this.l;
      if (i < arrayOfString.length) {
        if (arrayOfString[i] != null)
          stringBuilder.append(arrayOfString[i]); 
        i++;
        continue;
      } 
      return stringBuilder.toString();
    } 
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    Parcelable parcelable = paramParcelable;
    if (paramParcelable instanceof Bundle) {
      Bundle bundle = (Bundle)paramParcelable;
      this.l = bundle.getStringArray("passwordArr");
      parcelable = bundle.getParcelable("instanceState");
      this.k.removeTextChangedListener(this.r);
      setPassword(getPassWord());
      this.k.addTextChangedListener(this.r);
    } 
    super.onRestoreInstanceState(parcelable);
  }
  
  protected Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("instanceState", super.onSaveInstanceState());
    bundle.putStringArray("passwordArr", this.l);
    return (Parcelable)bundle;
  }
  
  public void setBackground(Drawable paramDrawable) {}
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setOnPasswordChangedListener(OnPasswordChangedListener paramOnPasswordChangedListener) {
    this.n = paramOnPasswordChangedListener;
  }
  
  public void setPassword(String paramString) {
    a();
    if (TextUtils.isEmpty(paramString))
      return; 
    char[] arrayOfChar = paramString.toCharArray();
    for (int i = 0; i < arrayOfChar.length; i++) {
      String[] arrayOfString = this.l;
      if (i < arrayOfString.length) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfChar[i]);
        stringBuilder.append("");
        arrayOfString[i] = stringBuilder.toString();
        this.m[i].setText(this.l[i]);
      } 
    } 
  }
  
  public void setPasswordType(PasswordType paramPasswordType) {
    boolean bool = getPassWordVisibility();
    int i = null.a[paramPasswordType.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          i = 18;
        } else {
          i = 225;
        } 
      } else {
        i = 145;
      } 
    } else {
      i = 129;
    } 
    TextView[] arrayOfTextView = this.m;
    int k = arrayOfTextView.length;
    for (int j = 0; j < k; j++)
      arrayOfTextView[j].setInputType(i); 
    setPasswordVisibility(bool);
  }
  
  public void setPasswordVisibility(boolean paramBoolean) {
    for (TextView textView : this.m) {
      PasswordTransformationMethod passwordTransformationMethod;
      if (paramBoolean) {
        passwordTransformationMethod = null;
      } else {
        passwordTransformationMethod = this.o;
      } 
      textView.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
      if (textView instanceof EditText) {
        EditText editText = (EditText)textView;
        editText.setSelection(editText.getText().length());
      } 
    } 
  }
  
  public static interface OnPasswordChangedListener {
    void a(String param1String);
    
    void b(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jungly\gridpasswordview\GridPasswordView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
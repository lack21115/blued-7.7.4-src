package com.soft.blued.customview.gridcodeedittext;

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
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.imebugfixer.BugFixedEditText;

public class GridCodeEditText extends LinearLayout implements PasswordView {
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
  
  private int k;
  
  private String[] l;
  
  private TextView[] m;
  
  private BugFixedEditText n;
  
  private OnPasswordChangedListener o;
  
  private PasswordTransformationMethod p;
  
  private View.OnClickListener q = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        GridCodeEditText.a(this.a);
      }
    };
  
  private BugFixedEditText.OnDelKeyEventListener r = new BugFixedEditText.OnDelKeyEventListener(this) {
      public void a() {
        for (int i = (GridCodeEditText.b(this.a)).length - 1; i >= 0; i--) {
          if (GridCodeEditText.b(this.a)[i] != null) {
            GridCodeEditText.b(this.a)[i] = null;
            GridCodeEditText.c(this.a)[i].setText(null);
            GridCodeEditText.d(this.a);
            return;
          } 
          GridCodeEditText.c(this.a)[i].setText(null);
        } 
      }
    };
  
  private TextWatcher s = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {}
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        if (param1CharSequence == null)
          return; 
        param1CharSequence = param1CharSequence.toString();
        if (param1CharSequence.length() == 1) {
          GridCodeEditText.b(this.a)[0] = (String)param1CharSequence;
          GridCodeEditText.d(this.a);
          return;
        } 
        if (param1CharSequence.length() == 2) {
          param1CharSequence = param1CharSequence.substring(1);
          for (param1Int1 = 0; param1Int1 < (GridCodeEditText.b(this.a)).length; param1Int1++) {
            if (GridCodeEditText.b(this.a)[param1Int1] == null) {
              GridCodeEditText.b(this.a)[param1Int1] = (String)param1CharSequence;
              GridCodeEditText.c(this.a)[param1Int1].setText(param1CharSequence);
              GridCodeEditText.d(this.a);
              break;
            } 
          } 
          GridCodeEditText.e(this.a).removeTextChangedListener(this);
          GridCodeEditText.e(this.a).setText(GridCodeEditText.b(this.a)[0]);
          if (GridCodeEditText.e(this.a).getText().length() >= 1)
            GridCodeEditText.e(this.a).setSelection(1); 
          GridCodeEditText.e(this.a).addTextChangedListener(this);
        } 
      }
    };
  
  @Deprecated
  private View.OnKeyListener t = new View.OnKeyListener(this) {
      public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
        if (param1KeyEvent.getAction() == 0 && param1KeyEvent.getKeyCode() == 67) {
          GridCodeEditText.f(this.a).a();
          return true;
        } 
        return false;
      }
    };
  
  public GridCodeEditText(Context paramContext) {
    super(paramContext);
    a(paramContext, (AttributeSet)null, 0);
  }
  
  public GridCodeEditText(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public GridCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  public GridCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1);
  }
  
  private void a(Context paramContext) {
    setShowDividers(0);
    setOrientation(0);
    this.p = new CustomPasswordTransformationMethod(this.i);
    b(paramContext);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    b(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private GradientDrawable b() {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(this.e);
    gradientDrawable.setStroke(this.c, this.d);
    return gradientDrawable;
  }
  
  private void b(Context paramContext) {
    LayoutInflater layoutInflater = LayoutInflater.from(paramContext);
    View view = layoutInflater.inflate(2131494239, (ViewGroup)this, false);
    this.n = (BugFixedEditText)view.findViewById(2131297595);
    this.n.setMaxEms(this.h);
    this.n.addTextChangedListener(this.s);
    this.n.setDelKeyEventListener(this.r);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.k, -1);
    this.n.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    addView(view);
    setCustomAttr((TextView)this.n);
    this.m[0] = (TextView)this.n;
    for (int i = 1; i < this.h; i++) {
      addView(layoutInflater.inflate(2131494237, (ViewGroup)this, false));
      ShapeTextView shapeTextView = (ShapeTextView)layoutInflater.inflate(2131494256, (ViewGroup)this, false);
      setCustomAttr((TextView)shapeTextView);
      addView((View)shapeTextView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.k, -1));
      this.m[i] = (TextView)shapeTextView;
    } 
    setOnClickListener(this.q);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GridCodeEditText, paramInt, 0);
    if (typedArray.hasValue(6)) {
      this.a = ColorStateList.valueOf(BluedSkinUtils.a(paramContext, typedArray.getResourceId(6, 2131100838)));
    } else {
      this.a = typedArray.getColorStateList(6);
    } 
    if (this.a == null)
      this.a = ColorStateList.valueOf(getResources().getColor(17170435)); 
    paramInt = typedArray.getDimensionPixelSize(7, -1);
    if (paramInt != -1)
      this.b = DensityUtils.c(paramContext, paramInt); 
    for (paramInt = 0; paramInt < paramAttributeSet.getAttributeCount(); paramInt++) {
      if ("layout_height".equals(paramAttributeSet.getAttributeName(paramInt))) {
        String str = paramAttributeSet.getAttributeValue(paramInt);
        this.k = DensityUtils.a(paramContext, Float.parseFloat(str.substring(0, str.lastIndexOf("."))));
      } 
    } 
    this.c = (int)typedArray.getDimension(2, DensityUtils.a(getContext(), 1.0F));
    this.d = typedArray.getColor(1, -1433892728);
    this.e = typedArray.getColor(0, -1);
    this.f = typedArray.getDrawable(1);
    if (this.f == null)
      this.f = (Drawable)new ColorDrawable(this.d); 
    this.g = (Drawable)b();
    this.h = typedArray.getInt(3, 6);
    this.i = typedArray.getString(4);
    if (TextUtils.isEmpty(this.i))
      this.i = "●"; 
    this.j = typedArray.getInt(5, 0);
    typedArray.recycle();
    paramInt = this.h;
    this.l = new String[paramInt];
    this.m = new TextView[paramInt];
  }
  
  private void c() {
    this.n.setFocusable(true);
    this.n.setFocusableInTouchMode(true);
    this.n.requestFocus();
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)this.n, 1);
  }
  
  private void d() {
    if (this.o == null)
      return; 
    String str = getPassWord();
    this.o.a(str);
    if (str.length() == this.h)
      this.o.b(str); 
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
    paramTextView.setTransformationMethod((TransformationMethod)this.p);
  }
  
  private void setError(String paramString) {
    this.n.setError(paramString);
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
      this.n.removeTextChangedListener(this.s);
      setPassword(getPassWord());
      this.n.addTextChangedListener(this.s);
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
    this.o = paramOnPasswordChangedListener;
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
        passwordTransformationMethod = this.p;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\gridcodeedittext\GridCodeEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
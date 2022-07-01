package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class TextInputEditText extends AppCompatEditText {
  private final Rect a = new Rect();
  
  private boolean b;
  
  public TextInputEditText(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.TextInputEditText, paramInt, R.style.Widget_Design_TextInputEditText, new int[0]);
    setTextInputLayoutFocusedRectEnabled(typedArray.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
    typedArray.recycle();
  }
  
  private String a(TextInputLayout paramTextInputLayout) {
    Editable editable = getText();
    CharSequence charSequence3 = paramTextInputLayout.getHint();
    CharSequence charSequence1 = paramTextInputLayout.getHelperText();
    CharSequence charSequence2 = paramTextInputLayout.getError();
    boolean bool1 = TextUtils.isEmpty((CharSequence)editable);
    boolean bool2 = TextUtils.isEmpty(charSequence3);
    int i = TextUtils.isEmpty(charSequence1) ^ true;
    int j = TextUtils.isEmpty(charSequence2) ^ true;
    String str2 = "";
    if ((bool2 ^ true) != 0) {
      str1 = charSequence3.toString();
    } else {
      str1 = "";
    } 
    charSequence3 = new StringBuilder();
    charSequence3.append(str1);
    if ((j != 0 || i != 0) && !TextUtils.isEmpty(str1)) {
      str1 = ", ";
    } else {
      str1 = "";
    } 
    charSequence3.append(str1);
    String str1 = charSequence3.toString();
    charSequence3 = new StringBuilder();
    charSequence3.append(str1);
    if (j != 0) {
      CharSequence charSequence = charSequence2;
    } else if (i != 0) {
      CharSequence charSequence = charSequence1;
    } else {
      str1 = "";
    } 
    charSequence3.append(str1);
    charSequence2 = charSequence3.toString();
    if ((bool1 ^ true) != 0) {
      String str;
      charSequence1 = new StringBuilder();
      charSequence1.append(editable);
      str1 = str2;
      if (!TextUtils.isEmpty(charSequence2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", ");
        stringBuilder.append((String)charSequence2);
        str = stringBuilder.toString();
      } 
      charSequence1.append(str);
      return charSequence1.toString();
    } 
    return (String)(!TextUtils.isEmpty(charSequence2) ? charSequence2 : "");
  }
  
  private CharSequence getHintFromLayout() {
    TextInputLayout textInputLayout = getTextInputLayout();
    return (textInputLayout != null) ? textInputLayout.getHint() : null;
  }
  
  private TextInputLayout getTextInputLayout() {
    for (ViewParent viewParent = getParent(); viewParent instanceof android.view.View; viewParent = viewParent.getParent()) {
      if (viewParent instanceof TextInputLayout)
        return (TextInputLayout)viewParent; 
    } 
    return null;
  }
  
  public void getFocusedRect(Rect paramRect) {
    super.getFocusedRect(paramRect);
    TextInputLayout textInputLayout = getTextInputLayout();
    if (textInputLayout != null && this.b && paramRect != null) {
      textInputLayout.getFocusedRect(this.a);
      paramRect.bottom = this.a.bottom;
    } 
  }
  
  public boolean getGlobalVisibleRect(Rect paramRect, Point paramPoint) {
    boolean bool = super.getGlobalVisibleRect(paramRect, paramPoint);
    TextInputLayout textInputLayout = getTextInputLayout();
    if (textInputLayout != null && this.b && paramRect != null) {
      textInputLayout.getGlobalVisibleRect(this.a, paramPoint);
      paramRect.bottom = this.a.bottom;
    } 
    return bool;
  }
  
  public CharSequence getHint() {
    TextInputLayout textInputLayout = getTextInputLayout();
    return (textInputLayout != null && textInputLayout.a()) ? textInputLayout.getHint() : super.getHint();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    TextInputLayout textInputLayout = getTextInputLayout();
    if (textInputLayout != null && textInputLayout.a() && super.getHint() == null && ManufacturerUtils.a())
      setHint(""); 
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    InputConnection inputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (inputConnection != null && paramEditorInfo.hintText == null)
      paramEditorInfo.hintText = getHintFromLayout(); 
    return inputConnection;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    TextInputLayout textInputLayout = getTextInputLayout();
    if (Build.VERSION.SDK_INT < 23 && textInputLayout != null)
      paramAccessibilityNodeInfo.setText(a(textInputLayout)); 
  }
  
  public boolean requestRectangleOnScreen(Rect paramRect) {
    boolean bool = super.requestRectangleOnScreen(paramRect);
    TextInputLayout textInputLayout = getTextInputLayout();
    if (textInputLayout != null && this.b) {
      this.a.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
      textInputLayout.requestRectangleOnScreen(this.a, true);
    } 
    return bool;
  }
  
  public void setTextInputLayoutFocusedRectEnabled(boolean paramBoolean) {
    this.b = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\TextInputEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
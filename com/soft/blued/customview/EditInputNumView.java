package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.soft.blued.R;
import skin.support.widget.SkinCompatBackgroundHelper;

public class EditInputNumView extends AppCompatTextView implements BluedSkinSupportable {
  private SkinCompatBackgroundHelper a = new SkinCompatBackgroundHelper((View)this);
  
  private int b = 2131100844;
  
  private int c = 2131100837;
  
  private int d = 256;
  
  private boolean e = false;
  
  private EditText f;
  
  public EditInputNumView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public EditInputNumView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditInputNumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, 0);
    a(paramAttributeSet);
  }
  
  private int a(CharSequence paramCharSequence) {
    if (!this.e)
      return paramCharSequence.length(); 
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length()) {
      if (paramCharSequence.charAt(j) < '') {
        i++;
      } else {
        i += 2;
      } 
      j++;
    } 
    return i;
  }
  
  private void a(AttributeSet paramAttributeSet) {
    if (paramAttributeSet != null) {
      TypedArray typedArray = getResources().obtainAttributes(paramAttributeSet, R.styleable.EditInputNumView);
      this.b = typedArray.getResourceId(1, 2131100844);
      this.c = typedArray.getResourceId(2, 2131100837);
      this.d = typedArray.getInteger(0, 256);
      typedArray.recycle();
    } 
    setTextColor(BluedSkinUtils.a(getContext(), this.b));
    setInputText(0);
  }
  
  private int getEditLength() {
    EditText editText = this.f;
    return (editText == null) ? 0 : a((CharSequence)editText.getText());
  }
  
  public void a(EditText paramEditText) {
    this.f = paramEditText;
    setInputText(getEditLength());
    paramEditText.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            int i = EditInputNumView.a(this.a, (CharSequence)param1Editable);
            this.a.setInputText(i);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
  }
  
  public void a(EditText paramEditText, int paramInt) {
    a(paramEditText, paramInt, false);
  }
  
  public void a(EditText paramEditText, int paramInt, boolean paramBoolean) {
    this.d = paramInt;
    this.e = paramBoolean;
    a(paramEditText);
  }
  
  public boolean a() {
    return (getEditLength() > this.d);
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.a;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  public int getEditMaxLength() {
    return this.d;
  }
  
  public int getInTextColor() {
    return this.b;
  }
  
  public int getOutTextColor() {
    return this.c;
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.a;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setEditMaxLength(int paramInt) {
    if (paramInt > 0)
      this.d = paramInt; 
    if (this.f != null) {
      setInputText(getEditLength());
      return;
    } 
    setInputText(0);
  }
  
  public void setInTextColor(int paramInt) {
    this.b = paramInt;
  }
  
  public void setInputText(int paramInt) {
    if (a()) {
      setTextColor(getContext().getResources().getColor(this.c));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append(" / ");
      stringBuilder1.append(this.d);
      setText(stringBuilder1.toString());
      return;
    } 
    setTextColor(getContext().getResources().getColor(this.b));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(" / ");
    stringBuilder.append(this.d);
    setText(stringBuilder.toString());
  }
  
  public void setOutTextColor(int paramInt) {
    this.c = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\EditInputNumView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
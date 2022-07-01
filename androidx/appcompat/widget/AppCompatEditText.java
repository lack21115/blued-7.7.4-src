package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;

public class AppCompatEditText extends EditText implements TintableBackgroundView {
  private final AppCompatBackgroundHelper a = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatTextHelper b;
  
  private final AppCompatTextClassifierHelper c;
  
  public AppCompatEditText(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new AppCompatTextHelper((TextView)this);
    this.b.a(paramAttributeSet, paramInt);
    this.b.b();
    this.c = new AppCompatTextClassifierHelper((TextView)this);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.c(); 
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.b(); 
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  public Editable getText() {
    return (Build.VERSION.SDK_INT >= 28) ? super.getText() : getEditableText();
  }
  
  public TextClassifier getTextClassifier() {
    if (Build.VERSION.SDK_INT < 28) {
      AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.c;
      if (appCompatTextClassifierHelper != null)
        return appCompatTextClassifierHelper.getTextClassifier(); 
    } 
    return super.getTextClassifier();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return AppCompatHintHelper.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, (View)this);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, paramCallback));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramMode); 
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramContext, paramInt); 
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier) {
    if (Build.VERSION.SDK_INT < 28) {
      AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.c;
      if (appCompatTextClassifierHelper != null) {
        appCompatTextClassifierHelper.setTextClassifier(paramTextClassifier);
        return;
      } 
    } 
    super.setTextClassifier(paramTextClassifier);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
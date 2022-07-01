package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {
  private static final int[] a = new int[] { 16843126 };
  
  private final AppCompatBackgroundHelper b;
  
  private final AppCompatTextHelper c;
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, a, paramInt, 0);
    if (tintTypedArray.hasValue(0))
      setDropDownBackgroundDrawable(tintTypedArray.getDrawable(0)); 
    tintTypedArray.recycle();
    this.b = new AppCompatBackgroundHelper((View)this);
    this.b.a(paramAttributeSet, paramInt);
    this.c = new AppCompatTextHelper((TextView)this);
    this.c.a(paramAttributeSet, paramInt);
    this.c.b();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.c(); 
    AppCompatTextHelper appCompatTextHelper = this.c;
    if (appCompatTextHelper != null)
      appCompatTextHelper.b(); 
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return AppCompatHintHelper.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, (View)this);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setDropDownBackgroundResource(int paramInt) {
    setDropDownBackgroundDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramMode); 
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    AppCompatTextHelper appCompatTextHelper = this.c;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramContext, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatMultiAutoCompleteTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
  private static final int a = R.style.Widget_MaterialComponents_Tooltip;
  
  private static final int b = R.attr.tooltipStyle;
  
  private CharSequence c;
  
  private final Context d;
  
  private final Paint.FontMetrics e = new Paint.FontMetrics();
  
  private final TextDrawableHelper f = new TextDrawableHelper(this);
  
  private final View.OnLayoutChangeListener g = new View.OnLayoutChangeListener(this) {
      public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
        TooltipDrawable.a(this.a, param1View);
      }
    };
  
  private final Rect h = new Rect();
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private TooltipDrawable(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.d = paramContext;
    (this.f.a()).density = (paramContext.getResources().getDisplayMetrics()).density;
    this.f.a().setTextAlign(Paint.Align.CENTER);
  }
  
  private float a() {
    if (this.h.right - (getBounds()).right - this.n - this.l < 0) {
      int i = this.h.right - (getBounds()).right - this.n - this.l;
      return i;
    } 
    if (this.h.left - (getBounds()).left - this.n + this.l > 0) {
      int i = this.h.left - (getBounds()).left - this.n + this.l;
      return i;
    } 
    return 0.0F;
  }
  
  private float a(Rect paramRect) {
    return paramRect.centerY() - d();
  }
  
  public static TooltipDrawable a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TooltipDrawable tooltipDrawable = new TooltipDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    tooltipDrawable.a(paramAttributeSet, paramInt1, paramInt2);
    return tooltipDrawable;
  }
  
  private void a(Canvas paramCanvas) {
    if (this.c == null)
      return; 
    Rect rect = getBounds();
    int i = (int)a(rect);
    if (this.f.b() != null) {
      (this.f.a()).drawableState = getState();
      this.f.a(this.d);
    } 
    CharSequence charSequence = this.c;
    paramCanvas.drawText(charSequence, 0, charSequence.length(), rect.centerX(), i, (Paint)this.f.a());
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = ThemeEnforcement.a(this.d, paramAttributeSet, R.styleable.Tooltip, paramInt1, paramInt2, new int[0]);
    this.m = this.d.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
    setShapeAppearanceModel(getShapeAppearanceModel().n().b(b()).a());
    a(typedArray.getText(R.styleable.Tooltip_android_text));
    a(MaterialResources.c(this.d, typedArray, R.styleable.Tooltip_android_textAppearance));
    paramInt1 = MaterialColors.a(this.d, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName());
    paramInt1 = MaterialColors.a(ColorUtils.setAlphaComponent(MaterialColors.a(this.d, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(paramInt1, 153));
    g(ColorStateList.valueOf(typedArray.getColor(R.styleable.Tooltip_backgroundTint, paramInt1)));
    h(ColorStateList.valueOf(MaterialColors.a(this.d, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
    this.i = typedArray.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
    this.j = typedArray.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
    this.k = typedArray.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
    this.l = typedArray.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
    typedArray.recycle();
  }
  
  private EdgeTreatment b() {
    float f1 = -a();
    float f2 = (float)(getBounds().width() - this.m * Math.sqrt(2.0D)) / 2.0F;
    f1 = Math.min(Math.max(f1, -f2), f2);
    return (EdgeTreatment)new OffsetEdgeTreatment((EdgeTreatment)new MarkerEdgeTreatment(this.m), f1);
  }
  
  private float c() {
    CharSequence charSequence = this.c;
    return (charSequence == null) ? 0.0F : this.f.a(charSequence.toString());
  }
  
  private void c(View paramView) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.n = arrayOfInt[0];
    paramView.getWindowVisibleDisplayFrame(this.h);
  }
  
  private float d() {
    this.f.a().getFontMetrics(this.e);
    return (this.e.descent + this.e.ascent) / 2.0F;
  }
  
  public void a(View paramView) {
    if (paramView == null)
      return; 
    c(paramView);
    paramView.addOnLayoutChangeListener(this.g);
  }
  
  public void a(TextAppearance paramTextAppearance) {
    this.f.a(paramTextAppearance, this.d);
  }
  
  public void a(CharSequence paramCharSequence) {
    if (!TextUtils.equals(this.c, paramCharSequence)) {
      this.c = paramCharSequence;
      this.f.a(true);
      invalidateSelf();
    } 
  }
  
  public void b(View paramView) {
    if (paramView == null)
      return; 
    paramView.removeOnLayoutChangeListener(this.g);
  }
  
  public void draw(Canvas paramCanvas) {
    paramCanvas.save();
    paramCanvas.translate(a(), (float)-(this.m * Math.sqrt(2.0D) - this.m));
    super.draw(paramCanvas);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void e() {
    invalidateSelf();
  }
  
  public int getIntrinsicHeight() {
    return (int)Math.max(this.f.a().getTextSize(), this.k);
  }
  
  public int getIntrinsicWidth() {
    return (int)Math.max((this.i * 2) + c(), this.j);
  }
  
  public void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    setShapeAppearanceModel(getShapeAppearanceModel().n().b(b()).a());
  }
  
  public boolean onStateChange(int[] paramArrayOfint) {
    return super.onStateChange(paramArrayOfint);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\tooltip\TooltipDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
  private static final int a = R.style.Widget_MaterialComponents_Badge;
  
  private static final int b = R.attr.badgeStyle;
  
  private final WeakReference<Context> c;
  
  private final MaterialShapeDrawable d;
  
  private final TextDrawableHelper e;
  
  private final Rect f;
  
  private final float g;
  
  private final float h;
  
  private final float i;
  
  private final SavedState j;
  
  private float k;
  
  private float l;
  
  private int m;
  
  private float n;
  
  private float o;
  
  private float p;
  
  private WeakReference<View> q;
  
  private WeakReference<ViewGroup> r;
  
  private BadgeDrawable(Context paramContext) {
    this.c = new WeakReference<Context>(paramContext);
    ThemeEnforcement.b(paramContext);
    Resources resources = paramContext.getResources();
    this.f = new Rect();
    this.d = new MaterialShapeDrawable();
    this.g = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
    this.i = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
    this.h = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
    this.e = new TextDrawableHelper(this);
    this.e.a().setTextAlign(Paint.Align.CENTER);
    this.j = new SavedState(paramContext);
    h(R.style.TextAppearance_MaterialComponents_Badge);
  }
  
  private static int a(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    return MaterialResources.a(paramContext, paramTypedArray, paramInt).getDefaultColor();
  }
  
  public static BadgeDrawable a(Context paramContext) {
    return a(paramContext, (AttributeSet)null, b, a);
  }
  
  private static BadgeDrawable a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    BadgeDrawable badgeDrawable = new BadgeDrawable(paramContext);
    badgeDrawable.b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    return badgeDrawable;
  }
  
  static BadgeDrawable a(Context paramContext, SavedState paramSavedState) {
    BadgeDrawable badgeDrawable = new BadgeDrawable(paramContext);
    badgeDrawable.a(paramSavedState);
    return badgeDrawable;
  }
  
  private void a(Context paramContext, Rect paramRect, View paramView) {
    float f;
    int i = SavedState.e(this.j);
    if (i != 8388691 && i != 8388693) {
      this.l = (paramRect.top + SavedState.g(this.j));
    } else {
      this.l = (paramRect.bottom - SavedState.g(this.j));
    } 
    if (c() <= 9) {
      if (!b()) {
        f = this.g;
      } else {
        f = this.h;
      } 
      this.n = f;
      f = this.n;
      this.p = f;
      this.o = f;
    } else {
      this.n = this.h;
      this.p = this.n;
      String str = h();
      this.o = this.e.a(str) / 2.0F + this.i;
    } 
    Resources resources = paramContext.getResources();
    if (b()) {
      i = R.dimen.mtrl_badge_text_horizontal_edge_offset;
    } else {
      i = R.dimen.mtrl_badge_horizontal_edge_offset;
    } 
    i = resources.getDimensionPixelSize(i);
    int j = SavedState.e(this.j);
    if (j != 8388659 && j != 8388691) {
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        f = paramRect.right + this.o - i - SavedState.f(this.j);
      } else {
        f = paramRect.left - this.o + i + SavedState.f(this.j);
      } 
      this.k = f;
      return;
    } 
    if (ViewCompat.getLayoutDirection(paramView) == 0) {
      f = paramRect.left - this.o + i + SavedState.f(this.j);
    } else {
      f = paramRect.right + this.o - i - SavedState.f(this.j);
    } 
    this.k = f;
  }
  
  private void a(Canvas paramCanvas) {
    Rect rect = new Rect();
    String str = h();
    this.e.a().getTextBounds(str, 0, str.length(), rect);
    paramCanvas.drawText(str, this.k, this.l + (rect.height() / 2), (Paint)this.e.a());
  }
  
  private void a(SavedState paramSavedState) {
    d(SavedState.a(paramSavedState));
    if (SavedState.b(paramSavedState) != -1)
      c(SavedState.b(paramSavedState)); 
    a(SavedState.c(paramSavedState));
    b(SavedState.d(paramSavedState));
    e(SavedState.e(paramSavedState));
    f(SavedState.f(paramSavedState));
    g(SavedState.g(paramSavedState));
  }
  
  private void a(TextAppearance paramTextAppearance) {
    if (this.e.b() == paramTextAppearance)
      return; 
    Context context = this.c.get();
    if (context == null)
      return; 
    this.e.a(paramTextAppearance, context);
    g();
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.Badge, paramInt1, paramInt2, new int[0]);
    d(typedArray.getInt(R.styleable.Badge_maxCharacterCount, 4));
    if (typedArray.hasValue(R.styleable.Badge_number))
      c(typedArray.getInt(R.styleable.Badge_number, 0)); 
    a(a(paramContext, typedArray, R.styleable.Badge_backgroundColor));
    if (typedArray.hasValue(R.styleable.Badge_badgeTextColor))
      b(a(paramContext, typedArray, R.styleable.Badge_badgeTextColor)); 
    e(typedArray.getInt(R.styleable.Badge_badgeGravity, 8388661));
    f(typedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
    g(typedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
    typedArray.recycle();
  }
  
  private void g() {
    Context context = this.c.get();
    WeakReference<View> weakReference = this.q;
    ViewGroup viewGroup = null;
    if (weakReference != null) {
      View view = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (context != null) {
      if (weakReference == null)
        return; 
      Rect rect1 = new Rect();
      rect1.set(this.f);
      Rect rect2 = new Rect();
      weakReference.getDrawingRect(rect2);
      WeakReference<ViewGroup> weakReference1 = this.r;
      if (weakReference1 != null)
        viewGroup = weakReference1.get(); 
      if (viewGroup != null || BadgeUtils.a) {
        ViewGroup viewGroup1 = viewGroup;
        if (viewGroup == null)
          viewGroup1 = (ViewGroup)weakReference.getParent(); 
        viewGroup1.offsetDescendantRectToMyCoords((View)weakReference, rect2);
      } 
      a(context, rect2, (View)weakReference);
      BadgeUtils.a(this.f, this.k, this.l, this.o, this.p);
      this.d.o(this.n);
      if (!rect1.equals(this.f))
        this.d.setBounds(this.f); 
    } 
  }
  
  private String h() {
    if (c() <= this.m)
      return Integer.toString(c()); 
    Context context = this.c.get();
    return (context == null) ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[] { Integer.valueOf(this.m), "+" });
  }
  
  private void h(int paramInt) {
    Context context = this.c.get();
    if (context == null)
      return; 
    a(new TextAppearance(context, paramInt));
  }
  
  private void i() {
    this.m = (int)Math.pow(10.0D, d() - 1.0D) - 1;
  }
  
  public SavedState a() {
    return this.j;
  }
  
  public void a(int paramInt) {
    SavedState.a(this.j, paramInt);
    ColorStateList colorStateList = ColorStateList.valueOf(paramInt);
    if (this.d.M() != colorStateList) {
      this.d.g(colorStateList);
      invalidateSelf();
    } 
  }
  
  public void a(View paramView, ViewGroup paramViewGroup) {
    this.q = new WeakReference<View>(paramView);
    this.r = new WeakReference<ViewGroup>(paramViewGroup);
    g();
    invalidateSelf();
  }
  
  public void b(int paramInt) {
    SavedState.b(this.j, paramInt);
    if (this.e.a().getColor() != paramInt) {
      this.e.a().setColor(paramInt);
      invalidateSelf();
    } 
  }
  
  public boolean b() {
    return (SavedState.b(this.j) != -1);
  }
  
  public int c() {
    return !b() ? 0 : SavedState.b(this.j);
  }
  
  public void c(int paramInt) {
    paramInt = Math.max(0, paramInt);
    if (SavedState.b(this.j) != paramInt) {
      SavedState.c(this.j, paramInt);
      this.e.a(true);
      g();
      invalidateSelf();
    } 
  }
  
  public int d() {
    return SavedState.a(this.j);
  }
  
  public void d(int paramInt) {
    if (SavedState.a(this.j) != paramInt) {
      SavedState.d(this.j, paramInt);
      i();
      this.e.a(true);
      g();
      invalidateSelf();
    } 
  }
  
  public void draw(Canvas paramCanvas) {
    if (!getBounds().isEmpty() && getAlpha() != 0) {
      if (!isVisible())
        return; 
      this.d.draw(paramCanvas);
      if (b())
        a(paramCanvas); 
    } 
  }
  
  public void e() {
    invalidateSelf();
  }
  
  public void e(int paramInt) {
    if (SavedState.e(this.j) != paramInt) {
      SavedState.e(this.j, paramInt);
      WeakReference<View> weakReference = this.q;
      if (weakReference != null && weakReference.get() != null) {
        View view = this.q.get();
        WeakReference<ViewGroup> weakReference1 = this.r;
        if (weakReference1 != null) {
          ViewGroup viewGroup = weakReference1.get();
        } else {
          weakReference1 = null;
        } 
        a(view, (ViewGroup)weakReference1);
      } 
    } 
  }
  
  public CharSequence f() {
    if (!isVisible())
      return null; 
    if (b()) {
      if (SavedState.i(this.j) > 0) {
        Context context = this.c.get();
        return (context == null) ? null : ((c() <= this.m) ? context.getResources().getQuantityString(SavedState.i(this.j), c(), new Object[] { Integer.valueOf(c()) }) : context.getString(SavedState.j(this.j), new Object[] { Integer.valueOf(this.m) }));
      } 
      return null;
    } 
    return SavedState.k(this.j);
  }
  
  public void f(int paramInt) {
    SavedState.g(this.j, paramInt);
    g();
  }
  
  public void g(int paramInt) {
    SavedState.h(this.j, paramInt);
    g();
  }
  
  public int getAlpha() {
    return SavedState.h(this.j);
  }
  
  public int getIntrinsicHeight() {
    return this.f.height();
  }
  
  public int getIntrinsicWidth() {
    return this.f.width();
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean isStateful() {
    return false;
  }
  
  public boolean onStateChange(int[] paramArrayOfint) {
    return super.onStateChange(paramArrayOfint);
  }
  
  public void setAlpha(int paramInt) {
    SavedState.f(this.j, paramInt);
    this.e.a().setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BadgeGravity {}
  
  public static final class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public BadgeDrawable.SavedState a(Parcel param2Parcel) {
          return new BadgeDrawable.SavedState(param2Parcel);
        }
        
        public BadgeDrawable.SavedState[] a(int param2Int) {
          return new BadgeDrawable.SavedState[param2Int];
        }
      };
    
    private int a;
    
    private int b;
    
    private int c = 255;
    
    private int d = -1;
    
    private int e;
    
    private CharSequence f;
    
    private int g;
    
    private int h;
    
    private int i;
    
    private int j;
    
    private int k;
    
    public SavedState(Context param1Context) {
      this.b = (new TextAppearance(param1Context, R.style.TextAppearance_MaterialComponents_Badge)).b.getDefaultColor();
      this.f = param1Context.getString(R.string.mtrl_badge_numberless_content_description);
      this.g = R.plurals.mtrl_badge_content_description;
      this.h = R.string.mtrl_exceed_max_badge_number_content_description;
    }
    
    protected SavedState(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readInt();
      this.d = param1Parcel.readInt();
      this.e = param1Parcel.readInt();
      this.f = param1Parcel.readString();
      this.g = param1Parcel.readInt();
      this.i = param1Parcel.readInt();
      this.j = param1Parcel.readInt();
      this.k = param1Parcel.readInt();
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeInt(this.c);
      param1Parcel.writeInt(this.d);
      param1Parcel.writeInt(this.e);
      param1Parcel.writeString(this.f.toString());
      param1Parcel.writeInt(this.g);
      param1Parcel.writeInt(this.i);
      param1Parcel.writeInt(this.j);
      param1Parcel.writeInt(this.k);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public BadgeDrawable.SavedState a(Parcel param1Parcel) {
      return new BadgeDrawable.SavedState(param1Parcel);
    }
    
    public BadgeDrawable.SavedState[] a(int param1Int) {
      return new BadgeDrawable.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\badge\BadgeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
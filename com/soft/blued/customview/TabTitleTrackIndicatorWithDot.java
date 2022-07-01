package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.List;

public class TabTitleTrackIndicatorWithDot extends HorizontalScrollView {
  public static final int[] a = new int[] { 16842901, 16842904 };
  
  public boolean A = false;
  
  public boolean B = false;
  
  public int C = 17;
  
  private final PageListener D = new PageListener(this);
  
  public LinearLayout.LayoutParams b;
  
  public LinearLayout.LayoutParams c;
  
  public ViewPager.OnPageChangeListener d;
  
  public LinearLayout e;
  
  public ViewPager f;
  
  public int g;
  
  public int h = 0;
  
  public float i = 0.0F;
  
  public int j = 52;
  
  public int k = 0;
  
  public int l = 0;
  
  public int m = 0;
  
  public int n = 0;
  
  public int o = 15;
  
  public int p;
  
  public int q = 0;
  
  public int r = 0;
  
  public Typeface s = null;
  
  public int t = 0;
  
  public boolean u;
  
  public int v = 0;
  
  public int w;
  
  public List<ColorTrackView> x;
  
  public List<ImageView> y;
  
  public List<ImageView> z;
  
  public TabTitleTrackIndicatorWithDot(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TabTitleTrackIndicatorWithDot(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabTitleTrackIndicatorWithDot(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return; 
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    setFillViewport(true);
    setWillNotDraw(false);
    this.e = new LinearLayout(paramContext);
    this.e.setOrientation(0);
    this.e.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
    addView((View)this.e);
    setTextSize(15);
    setSelectedTextSize(15);
    setTextOriginColor(getResources().getColor(2131100543));
    setTextChangeColor(getResources().getColor(2131100527));
    displayMetrics = getResources().getDisplayMetrics();
    this.j = (int)TypedValue.applyDimension(1, this.j, displayMetrics);
    this.k = (int)TypedValue.applyDimension(1, this.k, displayMetrics);
    this.l = (int)TypedValue.applyDimension(1, this.l, displayMetrics);
    this.m = (int)TypedValue.applyDimension(1, this.m, displayMetrics);
    this.n = (int)TypedValue.applyDimension(1, this.n, displayMetrics);
    this.o = (int)TypedValue.applyDimension(2, this.o, displayMetrics);
    this.p = (int)TypedValue.applyDimension(2, this.p, displayMetrics);
    this.w = DensityUtils.a(getContext(), 7.0F);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagerSlidingTabStrip);
    this.o = typedArray.getDimensionPixelSize(15, this.o);
    this.p = typedArray.getDimensionPixelSize(14, this.p);
    this.q = typedArray.getColor(13, this.q);
    this.r = typedArray.getColor(17, this.r);
    this.k = typedArray.getDimensionPixelSize(9, this.k);
    this.l = typedArray.getDimensionPixelSize(11, this.l);
    this.m = typedArray.getDimensionPixelSize(12, this.m);
    this.n = typedArray.getDimensionPixelSize(8, this.n);
    this.j = typedArray.getDimensionPixelSize(5, this.j);
    this.u = typedArray.getBoolean(6, this.u);
    typedArray.recycle();
    if (this.p == 0)
      this.p = this.o; 
    this.b = new LinearLayout.LayoutParams(-2, -2);
    this.c = new LinearLayout.LayoutParams(0, -2, 1.0F);
  }
  
  private int a(float paramFloat) {
    return (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  private void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: iflt -> 66
    //   4: iload_1
    //   5: aload_0
    //   6: getfield e : Landroid/widget/LinearLayout;
    //   9: invokevirtual getChildCount : ()I
    //   12: if_icmplt -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield e : Landroid/widget/LinearLayout;
    //   20: iload_1
    //   21: invokevirtual getChildAt : (I)Landroid/view/View;
    //   24: invokevirtual getLeft : ()I
    //   27: iload_2
    //   28: iadd
    //   29: istore_3
    //   30: iload_1
    //   31: ifgt -> 40
    //   34: iload_3
    //   35: istore_1
    //   36: iload_2
    //   37: ifle -> 47
    //   40: iload_3
    //   41: aload_0
    //   42: getfield j : I
    //   45: isub
    //   46: istore_1
    //   47: iload_1
    //   48: aload_0
    //   49: getfield v : I
    //   52: if_icmpeq -> 66
    //   55: aload_0
    //   56: iload_1
    //   57: putfield v : I
    //   60: aload_0
    //   61: iload_1
    //   62: iconst_0
    //   63: invokevirtual scrollTo : (II)V
    //   66: return
  }
  
  private void b() {
    if (this.x != null) {
      if (this.f == null)
        return; 
      for (int i = 0; i < this.x.size(); i++) {
        if (this.f.getCurrentItem() == i) {
          ((ColorTrackView)this.x.get(i)).setProgress(1.0F);
          ((ColorTrackView)this.x.get(i)).setTextSize(this.p);
        } else {
          ((ColorTrackView)this.x.get(i)).setProgress(0.0F);
          ((ColorTrackView)this.x.get(i)).setTextSize(this.o);
        } 
      } 
      a(this.f.getCurrentItem(), 0);
    } 
  }
  
  public void a() {
    this.e.removeAllViews();
    this.g = this.f.getAdapter().getCount();
    List<ColorTrackView> list1 = this.x;
    if (list1 != null) {
      list1.clear();
    } else {
      this.x = new ArrayList<ColorTrackView>();
    } 
    List<ImageView> list = this.y;
    if (list != null) {
      list.clear();
    } else {
      this.y = new ArrayList<ImageView>();
    } 
    list = this.z;
    if (list != null) {
      list.clear();
    } else {
      this.z = new ArrayList<ImageView>();
    } 
    for (int i = 0; i < this.g; i++)
      a(i, this.f.getAdapter().getPageTitle(i).toString()); 
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            TabTitleTrackIndicatorWithDot.a(this.a);
          }
        });
  }
  
  public void a(int paramInt) {
    if (this.z != null) {
      for (int i = 0; i < this.z.size(); i++)
        ((ImageView)this.z.get(i)).setVisibility(4); 
      if (paramInt < this.z.size()) {
        ImageView imageView = this.z.get(paramInt);
        if (imageView != null)
          imageView.setVisibility(0); 
      } 
    } 
  }
  
  public void a(int paramInt, String paramString) {
    LinearLayout.LayoutParams layoutParams;
    View view = LayoutInflater.from(getContext()).inflate(2131493660, null);
    ColorTrackView colorTrackView = (ColorTrackView)view.findViewById(2131296795);
    colorTrackView.setText(paramString);
    colorTrackView.setTextSize(this.o);
    colorTrackView.setTextOriginColor(this.q);
    colorTrackView.setTextChangeColor(this.r);
    colorTrackView.setFocusable(true);
    if (paramInt == 0) {
      colorTrackView.setProgress(1.0F);
      colorTrackView.setTextSize(this.p);
    } 
    this.x.add(colorTrackView);
    LinearLayout linearLayout = (LinearLayout)view.findViewById(2131298932);
    if (this.u) {
      layoutParams = this.c;
    } else {
      layoutParams = this.b;
    } 
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.setPadding(this.k, this.m, this.l, this.n);
    linearLayout.setGravity(this.C);
    ImageView imageView = (ImageView)view.findViewById(2131297469);
    imageView.setImageResource(2131233483);
    imageView.setVisibility(4);
    List<ImageView> list2 = this.y;
    if (list2 != null)
      list2.add(imageView); 
    imageView = (ImageView)view.findViewById(2131297573);
    if (this.B) {
      imageView.setVisibility(4);
    } else {
      imageView.setVisibility(8);
    } 
    List<ImageView> list1 = this.z;
    if (list1 != null)
      list1.add(imageView); 
    linearLayout.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            TabTitleTrackIndicatorWithDot tabTitleTrackIndicatorWithDot = this.b;
            tabTitleTrackIndicatorWithDot.A = true;
            tabTitleTrackIndicatorWithDot.f.setCurrentItem(this.a);
          }
        });
    this.e.addView((View)linearLayout);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.h = savedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.h;
    return (Parcelable)savedState;
  }
  
  public void setIsShowWithUnderline(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
    this.d = paramOnPageChangeListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.k = a(paramInt1);
    this.l = a(paramInt3);
    this.m = a(paramInt2);
    this.n = a(paramInt4);
  }
  
  public void setSelectedTextSize(int paramInt) {
    this.p = paramInt;
  }
  
  public void setTabLayoutGravity(int paramInt) {
    this.C = paramInt;
  }
  
  public void setTextChangeColor(int paramInt) {
    this.r = paramInt;
  }
  
  public void setTextOriginColor(int paramInt) {
    this.q = paramInt;
  }
  
  public void setTextSize(int paramInt) {
    this.o = paramInt;
  }
  
  public void setViewPager(ViewPager paramViewPager) {
    this.f = paramViewPager;
    if (paramViewPager.getAdapter() != null) {
      paramViewPager.setOnPageChangeListener(this.D);
      a();
      return;
    } 
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  public class PageListener implements ViewPager.OnPageChangeListener {
    public PageListener(TabTitleTrackIndicatorWithDot this$0) {}
    
    public void onPageScrollStateChanged(int param1Int) {
      if (param1Int == 0) {
        TabTitleTrackIndicatorWithDot.a(this.a);
        this.a.A = false;
      } 
      if (this.a.d != null)
        this.a.d.onPageScrollStateChanged(param1Int); 
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      TabTitleTrackIndicatorWithDot tabTitleTrackIndicatorWithDot = this.a;
      tabTitleTrackIndicatorWithDot.h = param1Int1;
      tabTitleTrackIndicatorWithDot.i = param1Float;
      if (tabTitleTrackIndicatorWithDot.x.size() > 0 && this.a.e.getChildCount() > 0) {
        tabTitleTrackIndicatorWithDot = this.a;
        TabTitleTrackIndicatorWithDot.a(tabTitleTrackIndicatorWithDot, param1Int1, (int)(tabTitleTrackIndicatorWithDot.e.getChildAt(param1Int1).getWidth() * param1Float));
        if (param1Float > 0.0F && param1Int1 < this.a.x.size() - 1 && !this.a.A) {
          ColorTrackView colorTrackView1 = this.a.x.get(param1Int1);
          ColorTrackView colorTrackView2 = this.a.x.get(param1Int1 + 1);
          colorTrackView1.setDirection(1);
          colorTrackView2.setDirection(0);
          colorTrackView1.setProgress(1.0F - param1Float);
          colorTrackView2.setProgress(param1Float);
        } else if (param1Float < 0.0F && param1Int1 > 0 && !this.a.A) {
          ColorTrackView colorTrackView1 = this.a.x.get(param1Int1);
          ColorTrackView colorTrackView2 = this.a.x.get(param1Int1 - 1);
          colorTrackView1.setDirection(1);
          colorTrackView2.setDirection(0);
          colorTrackView1.setProgress(1.0F - param1Float);
          colorTrackView2.setProgress(param1Float);
        } 
      } 
      if (this.a.d != null)
        this.a.d.onPageScrolled(param1Int1, param1Float, param1Int2); 
    }
    
    public void onPageSelected(int param1Int) {
      if (this.a.A)
        TabTitleTrackIndicatorWithDot.a(this.a); 
      if (this.a.d != null)
        this.a.d.onPageSelected(param1Int); 
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public TabTitleTrackIndicatorWithDot.SavedState a(Parcel param2Parcel) {
          return new TabTitleTrackIndicatorWithDot.SavedState(param2Parcel);
        }
        
        public TabTitleTrackIndicatorWithDot.SavedState[] a(int param2Int) {
          return new TabTitleTrackIndicatorWithDot.SavedState[param2Int];
        }
      };
    
    int a;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readInt();
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public TabTitleTrackIndicatorWithDot.SavedState a(Parcel param1Parcel) {
      return new TabTitleTrackIndicatorWithDot.SavedState(param1Parcel);
    }
    
    public TabTitleTrackIndicatorWithDot.SavedState[] a(int param1Int) {
      return new TabTitleTrackIndicatorWithDot.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\TabTitleTrackIndicatorWithDot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
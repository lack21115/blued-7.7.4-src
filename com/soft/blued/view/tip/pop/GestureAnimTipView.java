package com.soft.blued.view.tip.pop;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000H\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\t\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\000\n\002\020\r\n\002\b\004\n\002\030\002\n\000\030\0002\0020\001B'\b\007\022\b\020\002\032\004\030\0010\003\022\n\b\002\020\004\032\004\030\0010\005\022\b\b\002\020\006\032\0020\007¢\006\002\020\bJ\006\020\r\032\0020\016J\020\020\r\032\0020\0162\b\020\017\032\004\030\0010\020J\b\020\021\032\0020\016H\002J\016\020\022\032\0020\0162\006\020\023\032\0020\024J\016\020\025\032\0020\0162\006\020\023\032\0020\026J\020\020\025\032\0020\0162\b\b\001\020\027\032\0020\007J\006\020\030\032\0020\016J\026\020\030\032\0020\0162\006\020\031\032\0020\0242\006\020\032\032\0020\033R\016\020\t\032\0020\nXD¢\006\002\n\000R\016\020\013\032\0020\nXD¢\006\002\n\000R\016\020\f\032\0020\nXD¢\006\002\n\000¨\006\034"}, d2 = {"Lcom/soft/blued/view/tip/pop/GestureAnimTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ALPHA_HIDE_TIME", "", "ALPHA_SHOW_TIME", "SCALE_SHOW_TIME", "hide", "", "popupWindow", "Landroid/widget/PopupWindow;", "init", "measureWidth", "text", "", "setText", "", "resid", "show", "apng", "fragmentActive", "Lcom/blued/android/core/net/IRequestHost;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class GestureAnimTipView extends LinearLayout {
  private final long a = 300L;
  
  private final long b = 160L;
  
  private final long c = 100L;
  
  private HashMap d;
  
  public GestureAnimTipView(Context paramContext) {
    this(paramContext, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
  }
  
  public GestureAnimTipView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0, 4, (DefaultConstructorMarker)null);
  }
  
  public GestureAnimTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131494238, (ViewGroup)this);
    c();
  }
  
  private final void c() {}
  
  public View a(int paramInt) {
    if (this.d == null)
      this.d = new HashMap<Object, Object>(); 
    View view2 = (View)this.d.get(Integer.valueOf(paramInt));
    View view1 = view2;
    if (view2 == null) {
      view1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), view1);
    } 
    return view1;
  }
  
  public final void a() {
    ShapeLinearLayout shapeLinearLayout1 = (ShapeLinearLayout)a(R.id.bubble);
    Intrinsics.a(shapeLinearLayout1, "bubble");
    shapeLinearLayout1.setPivotX(0.0F);
    shapeLinearLayout1 = (ShapeLinearLayout)a(R.id.bubble);
    Intrinsics.a(shapeLinearLayout1, "bubble");
    ShapeLinearLayout shapeLinearLayout2 = (ShapeLinearLayout)a(R.id.bubble);
    Intrinsics.a(shapeLinearLayout2, "bubble");
    shapeLinearLayout1.setPivotY(shapeLinearLayout2.getMeasuredHeight());
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(a(R.id.bubble), "scaleX", new float[] { 0.0F, 1.0F });
    Intrinsics.a(objectAnimator, "oaScaleX");
    objectAnimator.setDuration(this.a);
    objectAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator());
    objectAnimator.start();
    objectAnimator = ObjectAnimator.ofFloat(a(R.id.bubble), "scaleY", new float[] { 0.25F, 1.0F });
    Intrinsics.a(objectAnimator, "oaScaleY");
    objectAnimator.setDuration(this.a);
    objectAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator());
    objectAnimator.start();
    objectAnimator = ObjectAnimator.ofFloat(a(R.id.bubble), "alpha", new float[] { 0.0F, 1.0F });
    Intrinsics.a(objectAnimator, "oaAlphaBubble");
    objectAnimator.setDuration(this.b);
    objectAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator(2.0F));
    objectAnimator.start();
    objectAnimator = ObjectAnimator.ofFloat(a(R.id.arrow), "alpha", new float[] { 0.0F, 1.0F });
    Intrinsics.a(objectAnimator, "oaAlphaArrow");
    objectAnimator.setDuration(this.b);
    objectAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator(2.0F));
    objectAnimator.start();
  }
  
  public final void a(PopupWindow paramPopupWindow) {
    b();
    postDelayed(new GestureAnimTipView$hide$1(paramPopupWindow), this.c);
  }
  
  public final void a(String paramString) {
    Intrinsics.b(paramString, "text");
    Space space = (Space)a(R.id.space);
    Intrinsics.a(space, "space");
    ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
    TextView textView = (TextView)a(R.id.txt);
    Intrinsics.a(textView, "txt");
    layoutParams.width = (int)((textView.getPaint().measureText(paramString) + DensityUtils.a(getContext(), 49)) * 1.2D);
  }
  
  public final void a(String paramString, IRequestHost paramIRequestHost) {
    Intrinsics.b(paramString, "apng");
    Intrinsics.b(paramIRequestHost, "fragmentActive");
    ImageLoader.c(paramIRequestHost, paramString).g().e(-1).a((ImageView)a(R.id.img));
    a();
  }
  
  public final void b() {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(a(R.id.bubble), "alpha", new float[] { 1.0F, 0.0F });
    Intrinsics.a(objectAnimator, "oaAlphaBubble");
    objectAnimator.setDuration(this.c);
    objectAnimator.start();
    objectAnimator = ObjectAnimator.ofFloat(a(R.id.arrow), "alpha", new float[] { 1.0F, 0.0F });
    Intrinsics.a(objectAnimator, "oaAlphaArrow");
    objectAnimator.setDuration(this.c);
    objectAnimator.start();
  }
  
  public final void setText(int paramInt) {
    ((TextView)a(R.id.txt)).setText(paramInt);
    TextView textView = (TextView)a(R.id.txt);
    Intrinsics.a(textView, "txt");
    a(textView.getText().toString());
  }
  
  public final void setText(CharSequence paramCharSequence) {
    Intrinsics.b(paramCharSequence, "text");
    TextView textView2 = (TextView)a(R.id.txt);
    Intrinsics.a(textView2, "txt");
    textView2.setText(paramCharSequence);
    TextView textView1 = (TextView)a(R.id.txt);
    Intrinsics.a(textView1, "txt");
    a(textView1.getText().toString());
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
  static final class GestureAnimTipView$hide$1 implements Runnable {
    GestureAnimTipView$hide$1(PopupWindow param1PopupWindow) {}
    
    public final void run() {
      PopupWindow popupWindow = this.a;
      if (popupWindow != null)
        popupWindow.dismiss(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\pop\GestureAnimTipView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;

public class ShapeConstraintLayout extends ConstraintLayout implements BluedSkinSupportable, ShapeHelper.ShapeView {
  private ShapeModel g;
  
  public ShapeConstraintLayout(Context paramContext) {
    super(paramContext);
  }
  
  public ShapeConstraintLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ShapeConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(Context paramContext, int paramInt) {
    return isInEditMode() ? getResources().getColor(paramInt) : BluedSkinUtils.a(paramContext, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeConstraintLayout);
    this.g = new ShapeModel();
    this.g.a = typedArray.getBoolean(R.styleable.ShapeConstraintLayout_bg_default_touch, false);
    this.g.h = typedArray.getDrawable(R.styleable.ShapeConstraintLayout_bg_drawable);
    this.g.i = typedArray.getDrawable(R.styleable.ShapeConstraintLayout_bg_touch_drawable);
    this.g.j = typedArray.getDrawable(R.styleable.ShapeConstraintLayout_bg_unable_drawable);
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_solid_color)) {
      this.g.k = typedArray.getColor(R.styleable.ShapeConstraintLayout_solid_color, 0);
      this.g.U = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_solid_color, 0);
      this.g.U = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.k = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_solid_touch_color)) {
      this.g.l = typedArray.getColor(R.styleable.ShapeConstraintLayout_solid_touch_color, 0);
      this.g.V = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_solid_touch_color, 0);
      this.g.V = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.l = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_solid_unable_color)) {
      this.g.m = typedArray.getColor(R.styleable.ShapeConstraintLayout_solid_unable_color, 0);
      this.g.W = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_solid_unable_color, 0);
      this.g.W = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.m = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_stroke_color)) {
      this.g.n = typedArray.getColor(R.styleable.ShapeConstraintLayout_stroke_color, 0);
      this.g.X = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_stroke_color, 0);
      this.g.X = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.n = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_stroke_touch_color)) {
      this.g.o = typedArray.getColor(R.styleable.ShapeConstraintLayout_stroke_touch_color, 0);
      this.g.Y = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_stroke_touch_color, 0);
      this.g.Y = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.o = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_stroke_unable_color)) {
      this.g.p = typedArray.getColor(R.styleable.ShapeConstraintLayout_stroke_unable_color, 0);
      this.g.Z = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_stroke_unable_color, 0);
      this.g.Z = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.p = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_start_color)) {
      this.g.t = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_start_color, 0);
      this.g.aa = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_start_color, 0);
      this.g.aa = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.t = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_center_color)) {
      this.g.u = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_center_color, 0);
      this.g.ab = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_center_color, 0);
      this.g.ab = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("center color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.u = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_end_color)) {
      this.g.v = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_end_color, 0);
      this.g.ac = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_end_color, 0);
      this.g.ac = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.v = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_start_touch_color)) {
      this.g.w = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_start_touch_color, 0);
      this.g.ad = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_start_touch_color, 0);
      this.g.ad = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.w = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_center_touch_color)) {
      this.g.x = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_center_touch_color, 0);
      this.g.ae = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_center_touch_color, 0);
      this.g.ae = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.x = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_end_touch_color)) {
      this.g.y = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_end_touch_color, 0);
      this.g.af = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_end_touch_color, 0);
      this.g.af = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.y = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_start_unable_color)) {
      this.g.z = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_start_unable_color, 0);
      this.g.ag = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_start_unable_color, 0);
      this.g.ag = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.z = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_center_unable_color)) {
      this.g.A = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_center_unable_color, 0);
      this.g.ah = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_center_unable_color, 0);
      this.g.ah = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("center unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.A = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeConstraintLayout_gradient_end_unable_color)) {
      this.g.B = typedArray.getColor(R.styleable.ShapeConstraintLayout_gradient_end_unable_color, 0);
      this.g.ai = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeConstraintLayout_gradient_end_unable_color, 0);
      this.g.ai = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.g.B = a(paramContext, i);
    } 
    this.g.q = typedArray.getDimension(R.styleable.ShapeConstraintLayout_stroke_width, 0.0F);
    this.g.r = typedArray.getDimension(R.styleable.ShapeConstraintLayout_stroke_dash_width, 0.0F);
    this.g.s = typedArray.getDimension(R.styleable.ShapeConstraintLayout_stroke_dash_gap, 0.0F);
    this.g.H = typedArray.getDimension(R.styleable.ShapeConstraintLayout_corner_radius, 0.0F);
    this.g.I = typedArray.getDimension(R.styleable.ShapeConstraintLayout_top_left_radius, 0.0F);
    this.g.J = typedArray.getDimension(R.styleable.ShapeConstraintLayout_top_right_radius, 0.0F);
    this.g.K = typedArray.getDimension(R.styleable.ShapeConstraintLayout_bottom_left_radius, 0.0F);
    this.g.L = typedArray.getDimension(R.styleable.ShapeConstraintLayout_bottom_right_radius, 0.0F);
    this.g.C = typedArray.getInt(R.styleable.ShapeConstraintLayout_gradient_angle, 0);
    this.g.D = typedArray.getInt(R.styleable.ShapeConstraintLayout_gradient_type, 0);
    this.g.E = typedArray.getDimension(R.styleable.ShapeConstraintLayout_gradient_radius, 0.0F);
    this.g.F = typedArray.getFloat(R.styleable.ShapeConstraintLayout_gradient_center_x, 0.5F);
    this.g.G = typedArray.getFloat(R.styleable.ShapeConstraintLayout_gradient_center_y, 0.5F);
    this.g.M = typedArray.getInt(R.styleable.ShapeConstraintLayout_bg_model, 0);
    this.g.N = typedArray.getInt(R.styleable.ShapeConstraintLayout_shape_type, 0);
    this.g.O = typedArray.getFloat(R.styleable.ShapeConstraintLayout_wh_ratio, 0.0F);
    typedArray.recycle();
    b();
  }
  
  private void b() {
    ShapeHelper.a(this);
  }
  
  public void g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapeConstraintLayout apply skin solidColor = ");
    stringBuilder.append(this.g.U);
    Log.e("skin", stringBuilder.toString());
    try {
      this.g.k = BluedSkinUtils.a(getContext(), this.g.U);
      this.g.l = BluedSkinUtils.a(getContext(), this.g.V);
      this.g.m = BluedSkinUtils.a(getContext(), this.g.W);
      this.g.t = BluedSkinUtils.a(getContext(), this.g.aa);
      this.g.u = BluedSkinUtils.a(getContext(), this.g.ab);
      this.g.v = BluedSkinUtils.a(getContext(), this.g.ac);
      this.g.z = BluedSkinUtils.a(getContext(), this.g.ag);
      this.g.A = BluedSkinUtils.a(getContext(), this.g.ah);
      this.g.B = BluedSkinUtils.a(getContext(), this.g.ai);
      this.g.w = BluedSkinUtils.a(getContext(), this.g.ad);
      this.g.x = BluedSkinUtils.a(getContext(), this.g.ae);
      this.g.y = BluedSkinUtils.a(getContext(), this.g.af);
      this.g.n = BluedSkinUtils.a(getContext(), this.g.X);
      this.g.o = BluedSkinUtils.a(getContext(), this.g.Y);
      this.g.p = BluedSkinUtils.a(getContext(), this.g.Z);
      b();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public ShapeModel getShapeModel() {
    if (this.g == null)
      this.g = new ShapeModel(); 
    return this.g;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    ShapeModel shapeModel = this.g;
    int j = paramInt1;
    int i = paramInt2;
    if (shapeModel != null) {
      j = paramInt1;
      i = paramInt2;
      if (shapeModel.O != 0.0F) {
        setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
        paramInt1 = getMeasuredWidth();
        j = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        i = View.MeasureSpec.makeMeasureSpec((int)(paramInt1 / this.g.O), 1073741824);
      } 
    } 
    super.onMeasure(j, i);
  }
  
  public void setShapeModel(ShapeModel paramShapeModel) {
    this.g = paramShapeModel;
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\shape\ShapeConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
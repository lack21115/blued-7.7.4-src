package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;

public class ShapeLinearLayout extends LinearLayout implements BluedSkinSupportable, ShapeHelper.ShapeView {
  private ShapeModel a;
  
  public ShapeLinearLayout(Context paramContext) {
    super(paramContext);
  }
  
  public ShapeLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ShapeLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(Context paramContext, int paramInt) {
    return isInEditMode() ? getResources().getColor(paramInt) : BluedSkinUtils.a(paramContext, paramInt);
  }
  
  private void a() {
    ShapeHelper.a(this);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeLinearLayout);
    this.a = new ShapeModel();
    this.a.a = typedArray.getBoolean(R.styleable.ShapeLinearLayout_bg_default_touch, false);
    this.a.h = typedArray.getDrawable(R.styleable.ShapeLinearLayout_bg_drawable);
    this.a.i = typedArray.getDrawable(R.styleable.ShapeLinearLayout_bg_touch_drawable);
    this.a.j = typedArray.getDrawable(R.styleable.ShapeLinearLayout_bg_unable_drawable);
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_solid_color)) {
      this.a.k = typedArray.getColor(R.styleable.ShapeLinearLayout_solid_color, 0);
      this.a.U = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_solid_color, 0);
      this.a.U = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.k = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_solid_touch_color)) {
      this.a.l = typedArray.getColor(R.styleable.ShapeLinearLayout_solid_touch_color, 0);
      this.a.V = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_solid_touch_color, 0);
      this.a.V = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.l = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_solid_unable_color)) {
      this.a.m = typedArray.getColor(R.styleable.ShapeLinearLayout_solid_unable_color, 0);
      this.a.W = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_solid_unable_color, 0);
      this.a.W = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.m = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_stroke_color)) {
      this.a.n = typedArray.getColor(R.styleable.ShapeLinearLayout_stroke_color, 0);
      this.a.X = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_stroke_color, 0);
      this.a.X = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.n = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_stroke_touch_color)) {
      this.a.o = typedArray.getColor(R.styleable.ShapeLinearLayout_stroke_touch_color, 0);
      this.a.Y = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_stroke_touch_color, 0);
      this.a.Y = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.o = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_stroke_unable_color)) {
      this.a.p = typedArray.getColor(R.styleable.ShapeLinearLayout_stroke_unable_color, 0);
      this.a.Z = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_stroke_unable_color, 0);
      this.a.Z = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.p = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_start_color)) {
      this.a.t = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_start_color, 0);
      this.a.aa = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_start_color, 0);
      this.a.aa = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.t = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_center_color)) {
      this.a.u = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_center_color, 0);
      this.a.ab = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_center_color, 0);
      this.a.ab = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("center color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.u = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_end_color)) {
      this.a.v = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_end_color, 0);
      this.a.ac = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_end_color, 0);
      this.a.ac = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.v = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_start_touch_color)) {
      this.a.w = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_start_touch_color, 0);
      this.a.ad = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_start_touch_color, 0);
      this.a.ad = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.w = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_center_touch_color)) {
      this.a.x = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_center_touch_color, 0);
      this.a.ae = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_center_touch_color, 0);
      this.a.ae = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.x = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_end_touch_color)) {
      this.a.y = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_end_touch_color, 0);
      this.a.af = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_end_touch_color, 0);
      this.a.af = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.y = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_start_unable_color)) {
      this.a.z = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_start_unable_color, 0);
      this.a.ag = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_start_unable_color, 0);
      this.a.ag = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.z = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_center_unable_color)) {
      this.a.A = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_center_unable_color, 0);
      this.a.ah = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_center_unable_color, 0);
      this.a.ah = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("center unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.A = a(paramContext, i);
    } 
    if (!typedArray.hasValue(R.styleable.ShapeLinearLayout_gradient_end_unable_color)) {
      this.a.B = typedArray.getColor(R.styleable.ShapeLinearLayout_gradient_end_unable_color, 0);
      this.a.ai = 17170445;
    } else {
      int i = typedArray.getResourceId(R.styleable.ShapeLinearLayout_gradient_end_unable_color, 0);
      this.a.ai = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.B = a(paramContext, i);
    } 
    this.a.q = typedArray.getDimension(R.styleable.ShapeLinearLayout_stroke_width, 0.0F);
    this.a.r = typedArray.getDimension(R.styleable.ShapeLinearLayout_stroke_dash_width, 0.0F);
    this.a.s = typedArray.getDimension(R.styleable.ShapeLinearLayout_stroke_dash_gap, 0.0F);
    this.a.H = typedArray.getDimension(R.styleable.ShapeLinearLayout_corner_radius, 0.0F);
    this.a.I = typedArray.getDimension(R.styleable.ShapeLinearLayout_top_left_radius, 0.0F);
    this.a.J = typedArray.getDimension(R.styleable.ShapeLinearLayout_top_right_radius, 0.0F);
    this.a.K = typedArray.getDimension(R.styleable.ShapeLinearLayout_bottom_left_radius, 0.0F);
    this.a.L = typedArray.getDimension(R.styleable.ShapeLinearLayout_bottom_right_radius, 0.0F);
    this.a.C = typedArray.getInt(R.styleable.ShapeLinearLayout_gradient_angle, 0);
    this.a.D = typedArray.getInt(R.styleable.ShapeLinearLayout_gradient_type, 0);
    this.a.E = typedArray.getDimension(R.styleable.ShapeLinearLayout_gradient_radius, 0.0F);
    this.a.F = typedArray.getFloat(R.styleable.ShapeLinearLayout_gradient_center_x, 0.5F);
    this.a.G = typedArray.getFloat(R.styleable.ShapeLinearLayout_gradient_center_y, 0.5F);
    this.a.M = typedArray.getInt(R.styleable.ShapeLinearLayout_bg_model, 0);
    this.a.N = typedArray.getInt(R.styleable.ShapeLinearLayout_shape_type, 0);
    this.a.O = typedArray.getFloat(R.styleable.ShapeLinearLayout_wh_ratio, 0.0F);
    typedArray.recycle();
    a();
  }
  
  public void g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapeLinearLayout apply skin solidColor = ");
    stringBuilder.append(this.a.U);
    Log.e("skin", stringBuilder.toString());
    try {
      this.a.k = BluedSkinUtils.a(getContext(), this.a.U);
      this.a.l = BluedSkinUtils.a(getContext(), this.a.V);
      this.a.m = BluedSkinUtils.a(getContext(), this.a.W);
      this.a.t = BluedSkinUtils.a(getContext(), this.a.aa);
      this.a.u = BluedSkinUtils.a(getContext(), this.a.ab);
      this.a.v = BluedSkinUtils.a(getContext(), this.a.ac);
      this.a.z = BluedSkinUtils.a(getContext(), this.a.ag);
      this.a.A = BluedSkinUtils.a(getContext(), this.a.ah);
      this.a.B = BluedSkinUtils.a(getContext(), this.a.ai);
      this.a.w = BluedSkinUtils.a(getContext(), this.a.ad);
      this.a.x = BluedSkinUtils.a(getContext(), this.a.ae);
      this.a.y = BluedSkinUtils.a(getContext(), this.a.af);
      this.a.n = BluedSkinUtils.a(getContext(), this.a.X);
      this.a.o = BluedSkinUtils.a(getContext(), this.a.Y);
      this.a.p = BluedSkinUtils.a(getContext(), this.a.Z);
      a();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public ShapeModel getShapeModel() {
    if (this.a == null)
      this.a = new ShapeModel(); 
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    ShapeModel shapeModel = this.a;
    int j = paramInt1;
    int i = paramInt2;
    if (shapeModel != null) {
      j = paramInt1;
      i = paramInt2;
      if (shapeModel.O != 0.0F) {
        setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
        paramInt1 = getMeasuredWidth();
        j = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        i = View.MeasureSpec.makeMeasureSpec((int)(paramInt1 / this.a.O), 1073741824);
      } 
    } 
    super.onMeasure(j, i);
  }
  
  public void setShapeModel(ShapeModel paramShapeModel) {
    this.a = paramShapeModel;
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\shape\ShapeLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
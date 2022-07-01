package com.blued.android.framework.view.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.R;

public class ShapeTextView extends AppCompatTextView implements BluedSkinSupportable, ShapeHelper.ShapeView {
  private ShapeModel a;
  
  public ShapeTextView(Context paramContext) {
    super(paramContext);
  }
  
  public ShapeTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ShapeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
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
    ShapeModel shapeModel;
    TypedArray typedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeTextView);
    TypedArray typedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeTextAppearance);
    this.a = new ShapeModel();
    if (!typedArray1.hasValue(R.styleable.ShapeTextAppearance_android_textColor)) {
      shapeModel = this.a;
      shapeModel.P = 17170445;
      shapeModel.b = 0;
    } else {
      this.a.P = shapeModel.getResourceId(R.styleable.ShapeTextAppearance_android_textColor, this.a.P);
      shapeModel = this.a;
      shapeModel.b = a(paramContext, shapeModel.P);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_text_touch_color)) {
      shapeModel = this.a;
      shapeModel.c = shapeModel.b;
      shapeModel = this.a;
      shapeModel.Q = shapeModel.P;
    } else {
      this.a.Q = typedArray2.getResourceId(R.styleable.ShapeTextView_text_touch_color, this.a.P);
      shapeModel = this.a;
      shapeModel.c = a(paramContext, shapeModel.Q);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_text_unable_color)) {
      shapeModel = this.a;
      shapeModel.R = shapeModel.P;
      shapeModel = this.a;
      shapeModel.d = shapeModel.b;
    } else {
      this.a.R = typedArray2.getResourceId(R.styleable.ShapeTextView_text_unable_color, this.a.P);
      shapeModel = this.a;
      shapeModel.d = a(paramContext, shapeModel.R);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_text_start_color)) {
      shapeModel = this.a;
      shapeModel.S = 17170445;
      shapeModel.e = typedArray2.getColor(R.styleable.ShapeTextView_text_start_color, 0);
    } else {
      this.a.S = typedArray2.getResourceId(R.styleable.ShapeTextView_text_start_color, 17170445);
      shapeModel = this.a;
      shapeModel.e = a(paramContext, shapeModel.S);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_text_end_color)) {
      shapeModel = this.a;
      shapeModel.T = 17170445;
      shapeModel.f = typedArray2.getColor(R.styleable.ShapeTextView_text_end_color, 0);
    } else {
      this.a.T = typedArray2.getResourceId(R.styleable.ShapeTextView_text_end_color, 17170445);
      shapeModel = this.a;
      shapeModel.f = a(paramContext, shapeModel.T);
    } 
    this.a.g = typedArray2.getInt(R.styleable.ShapeTextView_text_color_angle, 0);
    this.a.a = typedArray2.getBoolean(R.styleable.ShapeTextView_bg_default_touch, true);
    this.a.h = typedArray2.getDrawable(R.styleable.ShapeTextView_bg_drawable);
    this.a.i = typedArray2.getDrawable(R.styleable.ShapeTextView_bg_touch_drawable);
    this.a.j = typedArray2.getDrawable(R.styleable.ShapeTextView_bg_unable_drawable);
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_solid_color)) {
      this.a.k = typedArray2.getColor(R.styleable.ShapeTextView_solid_color, 0);
      this.a.U = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_solid_color, 0);
      this.a.U = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.k = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_solid_touch_color)) {
      this.a.l = typedArray2.getColor(R.styleable.ShapeTextView_solid_touch_color, 0);
      this.a.V = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_solid_touch_color, 0);
      this.a.V = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.l = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_solid_unable_color)) {
      this.a.m = typedArray2.getColor(R.styleable.ShapeTextView_solid_unable_color, 0);
      this.a.W = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_solid_unable_color, 0);
      this.a.W = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.m = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_stroke_color)) {
      this.a.n = typedArray2.getColor(R.styleable.ShapeTextView_stroke_color, 0);
      this.a.X = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_stroke_color, 0);
      this.a.X = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.n = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_stroke_touch_color)) {
      this.a.o = typedArray2.getColor(R.styleable.ShapeTextView_stroke_touch_color, 0);
      this.a.Y = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_stroke_touch_color, 0);
      this.a.Y = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.o = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_stroke_unable_color)) {
      this.a.p = typedArray2.getColor(R.styleable.ShapeTextView_stroke_unable_color, 0);
      this.a.Z = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_stroke_unable_color, 0);
      this.a.Z = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("solid unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.p = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_start_color)) {
      this.a.t = typedArray2.getColor(R.styleable.ShapeTextView_gradient_start_color, 0);
      this.a.aa = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_start_color, 0);
      this.a.aa = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.t = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_center_color)) {
      this.a.u = typedArray2.getColor(R.styleable.ShapeTextView_gradient_center_color, 0);
      this.a.ab = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_center_color, 0);
      this.a.ab = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("center color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.u = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_end_color)) {
      this.a.v = typedArray2.getColor(R.styleable.ShapeTextView_gradient_end_color, 0);
      this.a.ac = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_end_color, 0);
      this.a.ac = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.v = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_start_touch_color)) {
      this.a.w = typedArray2.getColor(R.styleable.ShapeTextView_gradient_start_touch_color, 0);
      this.a.ad = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_start_touch_color, 0);
      this.a.ad = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.w = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_center_touch_color)) {
      this.a.x = typedArray2.getColor(R.styleable.ShapeTextView_gradient_center_touch_color, 0);
      this.a.ae = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_center_touch_color, 0);
      this.a.ae = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.x = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_end_touch_color)) {
      this.a.y = typedArray2.getColor(R.styleable.ShapeTextView_gradient_end_touch_color, 0);
      this.a.af = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_end_touch_color, 0);
      this.a.af = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end touch color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.y = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_start_unable_color)) {
      this.a.z = typedArray2.getColor(R.styleable.ShapeTextView_gradient_start_unable_color, 0);
      this.a.ag = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_start_unable_color, 0);
      this.a.ag = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.z = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_center_unable_color)) {
      this.a.A = typedArray2.getColor(R.styleable.ShapeTextView_gradient_center_unable_color, 0);
      this.a.ah = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_center_unable_color, 0);
      this.a.ah = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("center unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.A = a(paramContext, i);
    } 
    if (!typedArray2.hasValue(R.styleable.ShapeTextView_gradient_end_unable_color)) {
      this.a.B = typedArray2.getColor(R.styleable.ShapeTextView_gradient_end_unable_color, 0);
      this.a.ai = 17170445;
    } else {
      int i = typedArray2.getResourceId(R.styleable.ShapeTextView_gradient_end_unable_color, 0);
      this.a.ai = i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("end unable color resid = ");
      stringBuilder.append(i);
      Log.e("skin", stringBuilder.toString());
      this.a.B = a(paramContext, i);
    } 
    this.a.q = typedArray2.getDimension(R.styleable.ShapeTextView_stroke_width, 0.0F);
    this.a.r = typedArray2.getDimension(R.styleable.ShapeTextView_stroke_dash_width, 0.0F);
    this.a.s = typedArray2.getDimension(R.styleable.ShapeTextView_stroke_dash_gap, 0.0F);
    this.a.H = typedArray2.getDimension(R.styleable.ShapeTextView_corner_radius, 0.0F);
    this.a.I = typedArray2.getDimension(R.styleable.ShapeTextView_top_left_radius, 0.0F);
    this.a.J = typedArray2.getDimension(R.styleable.ShapeTextView_top_right_radius, 0.0F);
    this.a.K = typedArray2.getDimension(R.styleable.ShapeTextView_bottom_left_radius, 0.0F);
    this.a.L = typedArray2.getDimension(R.styleable.ShapeTextView_bottom_right_radius, 0.0F);
    this.a.C = typedArray2.getInt(R.styleable.ShapeTextView_gradient_angle, 0);
    this.a.D = typedArray2.getInt(R.styleable.ShapeTextView_gradient_type, 0);
    this.a.E = typedArray2.getDimension(R.styleable.ShapeTextView_gradient_radius, 0.0F);
    this.a.F = typedArray2.getFloat(R.styleable.ShapeTextView_gradient_center_x, 0.5F);
    this.a.G = typedArray2.getFloat(R.styleable.ShapeTextView_gradient_center_y, 0.5F);
    this.a.M = typedArray2.getInt(R.styleable.ShapeTextView_bg_model, 0);
    this.a.N = typedArray2.getInt(R.styleable.ShapeTextView_shape_type, 0);
    this.a.O = typedArray2.getFloat(R.styleable.ShapeTextView_wh_ratio, 0.0F);
    typedArray2.recycle();
    a();
  }
  
  public void g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapeLinearLayout apply skin solidColor = ");
    stringBuilder.append(this.a.U);
    Log.e("skin", stringBuilder.toString());
    try {
      this.a.b = BluedSkinUtils.a(getContext(), this.a.P);
      this.a.c = BluedSkinUtils.a(getContext(), this.a.Q);
      this.a.d = BluedSkinUtils.a(getContext(), this.a.R);
      this.a.e = BluedSkinUtils.a(getContext(), this.a.S);
      this.a.f = BluedSkinUtils.a(getContext(), this.a.T);
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
  
  protected void onDraw(Canvas paramCanvas) {
    ShapeModel shapeModel = this.a;
    if (shapeModel != null && shapeModel.e != 0 && this.a.f != 0) {
      LinearGradient linearGradient;
      int i = this.a.g;
      if (i != 90) {
        if (i != 180) {
          if (i != 270) {
            linearGradient = new LinearGradient(0.0F, 0.0F, getMeasuredWidth(), 0.0F, this.a.e, this.a.f, Shader.TileMode.REPEAT);
          } else {
            linearGradient = new LinearGradient(0.0F, getMeasuredHeight(), 0.0F, 0.0F, this.a.e, this.a.f, Shader.TileMode.REPEAT);
          } 
        } else {
          linearGradient = new LinearGradient(getMeasuredWidth(), 0.0F, 0.0F, 0.0F, this.a.e, this.a.f, Shader.TileMode.REPEAT);
        } 
      } else {
        linearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, getMeasuredHeight(), this.a.e, this.a.f, Shader.TileMode.REPEAT);
      } 
      getPaint().setShader((Shader)linearGradient);
    } 
    super.onDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\shape\ShapeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
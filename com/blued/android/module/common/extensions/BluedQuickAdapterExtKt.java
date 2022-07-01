package com.blued.android.module.common.extensions;

import android.view.View;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000\032\n\000\n\002\020\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\007\n\002\b\f\032\034\020\000\032\0020\001*\0020\0022\b\b\001\020\003\032\0020\0042\006\020\005\032\0020\006\0324\020\000\032\0020\001*\0020\0022\b\b\001\020\003\032\0020\0042\006\020\007\032\0020\0062\006\020\b\032\0020\0062\006\020\t\032\0020\0062\006\020\n\032\0020\006\032\036\020\013\032\0020\001*\0020\0022\b\b\001\020\003\032\0020\0042\b\b\001\020\f\032\0020\004\032\036\020\r\032\0020\001*\0020\0022\b\b\001\020\003\032\0020\0042\b\b\001\020\f\032\0020\004\032,\020\016\032\0020\001*\0020\0022\b\b\001\020\003\032\0020\0042\006\020\017\032\0020\0062\006\020\020\032\0020\0062\006\020\021\032\0020\006¨\006\022"}, d2 = {"extSetCornerRadius", "", "Lcom/chad/library/adapter/base/BaseViewHolder;", "viewId", "", "cornerRadius", "", "topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "extSetSolidColor", "color", "extSetStrokeColor", "extSetStrokeWidth", "strokeWidth", "strokeDashWidth", "strokeDashGap", "module_common_release"}, k = 2, mv = {1, 1, 16})
public final class BluedQuickAdapterExtKt {
  public static final void a(BaseViewHolder paramBaseViewHolder, int paramInt, float paramFloat) {
    Intrinsics.b(paramBaseViewHolder, "$this$extSetCornerRadius");
    View view = paramBaseViewHolder.d(paramInt);
    if (view != null) {
      ShapeHelper.a((ShapeHelper.ShapeView)view, paramFloat);
      return;
    } 
    throw new TypeCastException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
  }
  
  public static final void a(BaseViewHolder paramBaseViewHolder, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Intrinsics.b(paramBaseViewHolder, "$this$extSetCornerRadius");
    View view = paramBaseViewHolder.d(paramInt);
    if (view != null) {
      ShapeHelper.a((ShapeHelper.ShapeView)view, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      return;
    } 
    throw new TypeCastException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
  }
  
  public static final void a(BaseViewHolder paramBaseViewHolder, int paramInt1, int paramInt2) {
    Intrinsics.b(paramBaseViewHolder, "$this$extSetSolidColor");
    View view = paramBaseViewHolder.d(paramInt1);
    if (view != null) {
      ShapeHelper.b((ShapeHelper.ShapeView)view, paramInt2);
      return;
    } 
    throw new TypeCastException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\extensions\BluedQuickAdapterExtKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
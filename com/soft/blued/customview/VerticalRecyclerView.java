package com.soft.blued.customview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;

public class VerticalRecyclerView extends RecyclerView {
  public VerticalRecyclerView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public VerticalRecyclerView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
  }
  
  public void v() {
    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setShape(0);
    gradientDrawable.setColor(BluedSkinUtils.a(getContext(), 2131100852));
    gradientDrawable.setSize(AppInfo.l, DensityUtils.a(getContext(), 0.5F));
    dividerItemDecoration.setDrawable((Drawable)gradientDrawable);
    addItemDecoration((RecyclerView.ItemDecoration)dividerItemDecoration);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\VerticalRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
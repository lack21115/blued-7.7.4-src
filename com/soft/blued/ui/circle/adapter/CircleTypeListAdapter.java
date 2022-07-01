package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.text.TextPaint;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.extensions.BluedQuickAdapterExtKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.circle.model.CircleTypeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\b\n\002\b\005\n\002\020\002\n\002\b\005\030\0002\016\022\004\022\0020\002\022\004\022\0020\0030\001B\025\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\034\020\023\032\0020\0242\b\020\025\032\004\030\0010\0032\b\020\026\032\004\030\0010\002H\024J\023\020\027\032\004\030\0010\0022\006\020\030\032\0020\016H\002R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\nR\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\013\020\fR\032\020\r\032\0020\016X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022¨\006\031"}, d2 = {"Lcom/soft/blued/ui/circle/adapter/CircleTypeListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/soft/blued/ui/circle/model/CircleTypeModel$DataBean;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "context", "Landroid/content/Context;", "fragmentActive", "Lcom/blued/android/core/net/IRequestHost;", "(Landroid/content/Context;Lcom/blued/android/core/net/IRequestHost;)V", "getContext", "()Landroid/content/Context;", "getFragmentActive", "()Lcom/blued/android/core/net/IRequestHost;", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "convert", "", "helper", "item", "get", "index", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleTypeListAdapter extends BaseQuickAdapter<CircleTypeModel.DataBean, BaseViewHolder> {
  private int a;
  
  private final Context b;
  
  private final IRequestHost c;
  
  public CircleTypeListAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493488, null);
    this.b = paramContext;
    this.c = paramIRequestHost;
  }
  
  public final void a(int paramInt) {
    this.a = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, CircleTypeModel.DataBean paramDataBean) {
    if (paramBaseViewHolder != null && paramDataBean != null) {
      int i = paramBaseViewHolder.getAdapterPosition() - o();
      paramBaseViewHolder.a(2131300635, paramDataBean.name);
      TextView textView = (TextView)paramBaseViewHolder.d(2131300635);
      if (this.a == i) {
        paramBaseViewHolder.b(2131301317, true);
        textView.setTextColor(BluedSkinUtils.a(this.k, 2131100838));
        textView.setTextSize(1, 15.0F);
        Intrinsics.a(textView, "tvCircleType");
        textPaint = textView.getPaint();
        if (textPaint != null)
          textPaint.setFakeBoldText(true); 
        BluedQuickAdapterExtKt.a(paramBaseViewHolder, 2131301634, 2131100728);
        BluedQuickAdapterExtKt.a(paramBaseViewHolder, 2131301634, 0.0F);
        return;
      } 
      paramBaseViewHolder.b(2131301317, false);
      textPaint.setTextColor(this.b.getResources().getColor(2131100844));
      textPaint.setTextSize(1, 13.0F);
      Intrinsics.a(textPaint, "tvCircleType");
      TextPaint textPaint = textPaint.getPaint();
      if (textPaint != null)
        textPaint.setFakeBoldText(false); 
      BluedQuickAdapterExtKt.a(paramBaseViewHolder, 2131301634, 2131100881);
      int j = this.a;
      if (j == i + 1) {
        BluedQuickAdapterExtKt.a(paramBaseViewHolder, 2131301634, 0.0F, 0.0F, 0.0F, DensityUtils.a(this.k, 6.0F));
        return;
      } 
      if (j == i - 1) {
        BluedQuickAdapterExtKt.a(paramBaseViewHolder, 2131301634, 0.0F, DensityUtils.a(this.k, 6.0F), 0.0F, 0.0F);
        return;
      } 
      BluedQuickAdapterExtKt.a(paramBaseViewHolder, 2131301634, 0.0F);
    } 
  }
  
  public final CircleTypeModel.DataBean b(int paramInt) {
    return (n().size() > paramInt) ? n().get(paramInt) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleTypeListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
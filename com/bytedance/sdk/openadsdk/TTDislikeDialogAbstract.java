package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

public abstract class TTDislikeDialogAbstract extends Dialog {
  private View a;
  
  private k b;
  
  public TTDislikeDialogAbstract(Context paramContext) {
    super(paramContext);
  }
  
  public TTDislikeDialogAbstract(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
  }
  
  private void a() {
    if (this.b == null)
      return; 
    if (this.a == null)
      return; 
    int[] arrayOfInt = getTTDislikeListViewIds();
    if (arrayOfInt != null && arrayOfInt.length > 0) {
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j) {
        int m = arrayOfInt[i];
        View view = this.a.findViewById(m);
        if (view != null) {
          if (view instanceof TTDislikeListView) {
            ((TTDislikeListView)view).setMaterialMeta(this.b);
            i++;
            continue;
          } 
          throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
        } 
        throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
      } 
      return;
    } 
    throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
  }
  
  public abstract int getLayoutId();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract int[] getTTDislikeListViewIds();
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
    if (this.a != null) {
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      View view = this.a;
      if (layoutParams == null)
        layoutParams = new ViewGroup.LayoutParams(-1, -1); 
      setContentView(view, layoutParams);
      a();
      return;
    } 
    throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
  }
  
  public void setMaterialMeta(k paramk) {
    this.b = paramk;
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTDislikeDialogAbstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
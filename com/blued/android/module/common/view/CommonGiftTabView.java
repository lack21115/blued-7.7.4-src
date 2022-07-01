package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

public class CommonGiftTabView<T extends CommonGiftPackageModel> extends FrameLayout {
  protected Context a;
  
  protected LayoutInflater b;
  
  protected LinearLayout c;
  
  protected final List<View> d = new ArrayList<View>();
  
  protected final List<T> e = new ArrayList<T>();
  
  private int f = 0;
  
  public CommonGiftTabView(Context paramContext) {
    super(paramContext);
  }
  
  public CommonGiftTabView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.b = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.c = (LinearLayout)this.b.inflate(R.layout.common_tab_view, (ViewGroup)this).findViewById(R.id.common_tab_view_id);
  }
  
  protected void a(View paramView, CommonGiftPackageModel paramCommonGiftPackageModel) {
    ((TextView)paramView.findViewById(R.id.common_tab_view_item_name)).setText(paramCommonGiftPackageModel.name);
  }
  
  protected int getItemViewLayoutId() {
    return R.layout.common_tab_view_item_layout;
  }
  
  public void setData(List<T> paramList) {
    if (paramList == null)
      return; 
    this.e.clear();
    this.e.addAll(paramList);
    if (this.d.size() < this.e.size())
      for (int j = this.d.size(); j < this.e.size(); j++) {
        View view = this.b.inflate(getItemViewLayoutId(), null);
        this.d.add(view);
      }  
    for (View view : this.d) {
      if (view.getVisibility() != 0)
        view.setVisibility(0); 
    } 
    this.c.removeAllViews();
    for (int i = 0; i < this.e.size(); i++) {
      View view = this.d.get(i);
      this.c.addView(view, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
      view.setTag(String.valueOf(i));
      a(view, (CommonGiftPackageModel)this.e.get(i));
      view.setOnClickListener(new -$$Lambda$CommonGiftTabView$3o1XyBO-kLalEtbc3OCIB5jWXy4(this));
    } 
    if (this.f >= paramList.size())
      this.f = 0; 
    setToolBtnSelect(this.f);
  }
  
  public void setToolBtnSelect(int paramInt) {
    if (paramInt < this.d.size())
      this.f = paramInt; 
    for (int i = 0; i < this.d.size(); i++) {
      ShapeTextView shapeTextView = (ShapeTextView)((View)this.d.get(i)).findViewById(R.id.common_tab_view_item_name);
      View view = ((View)this.d.get(i)).findViewById(R.id.common_tab_view_item_indicator);
      if (i == paramInt) {
        shapeTextView.setEnabled(true);
        view.setVisibility(0);
      } else {
        shapeTextView.setEnabled(false);
        view.setVisibility(4);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\CommonGiftTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
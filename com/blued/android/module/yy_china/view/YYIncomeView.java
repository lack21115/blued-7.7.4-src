package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYRankFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.GiftBeansObserver;

public class YYIncomeView extends LinearLayout implements View.OnClickListener, GiftBeansObserver {
  private BaseYYStudioFragment a;
  
  private TextView b;
  
  private LinearLayout c;
  
  public YYIncomeView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYIncomeView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYIncomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_income_layout, (ViewGroup)this, true);
    this.c = (LinearLayout)findViewById(R.id.ll_income);
    this.b = (TextView)findViewById(R.id.tv_gold_count);
    this.c.setOnClickListener(this);
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      a(yYRoomModel.getGiftBeans()); 
  }
  
  public void a(String paramString) {
    this.a.a(new Runnable(this, paramString) {
          public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("giftObserver count: ");
            stringBuilder.append(this.a);
            Logger.e("observer", new Object[] { stringBuilder.toString() });
            YYIncomeView.a(this.b).setText(this.a);
          }
        });
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    YYObserverManager.a().a(this);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.ll_income)
      (new YYRankFragment()).show(this.a.getFragmentManager(), "RankListDialog"); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYIncomeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
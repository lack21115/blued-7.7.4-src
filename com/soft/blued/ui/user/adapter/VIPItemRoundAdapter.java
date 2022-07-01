package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.utils.StringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class VIPItemRoundAdapter extends BaseQuickAdapter<VIPBuyOption, BaseViewHolder> {
  private Context a;
  
  private int b;
  
  private onGoodClick c;
  
  public VIPItemRoundAdapter(Context paramContext, int paramInt) {
    super(2131493687, new ArrayList());
    this.a = paramContext;
    this.b = paramInt;
  }
  
  public VIPBuyOption a() {
    for (int i = 0; i < this.n.size(); i++) {
      if (((VIPBuyOption)this.n.get(i)).choosen)
        return this.n.get(i); 
    } 
    return null;
  }
  
  public void a(int paramInt) {
    if (paramInt < this.n.size()) {
      for (int i = 0; i < this.n.size(); i++)
        ((VIPBuyOption)this.n.get(i)).choosen = false; 
      ((VIPBuyOption)this.n.get(paramInt)).choosen = true;
      notifyDataSetChanged();
      onGoodClick onGoodClick1 = this.c;
      if (onGoodClick1 != null)
        onGoodClick1.onclick(this.n.get(paramInt)); 
    } 
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPBuyOption paramVIPBuyOption) {
    if (paramBaseViewHolder != null) {
      ConstraintLayout constraintLayout = (ConstraintLayout)paramBaseViewHolder.d(2131298900);
      TextView textView5 = (TextView)paramBaseViewHolder.d(2131301088);
      LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131298704);
      TextView textView1 = (TextView)paramBaseViewHolder.d(2131301539);
      TextView textView2 = (TextView)paramBaseViewHolder.d(2131300514);
      TextView textView6 = (TextView)paramBaseViewHolder.d(2131301147);
      TextView textView3 = (TextView)paramBaseViewHolder.d(2131300515);
      ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131301370);
      TextView textView4 = (TextView)paramBaseViewHolder.d(2131300754);
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)constraintLayout.getLayoutParams();
      if (paramBaseViewHolder.getAdapterPosition() == 0) {
        layoutParams.leftMargin = DensityUtils.a(this.k, 10.0F);
      } else {
        layoutParams.leftMargin = DensityUtils.a(this.k, 0.0F);
      } 
      constraintLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (paramVIPBuyOption != null) {
        if (!StringUtils.e(paramVIPBuyOption.item.title)) {
          textView4.setText(paramVIPBuyOption.item.title);
          textView4.setVisibility(0);
        } else {
          textView4.setVisibility(4);
        } 
        textView5.setText(paramVIPBuyOption.item.name);
        textView2.setText(String.valueOf(Math.round(paramVIPBuyOption.money)));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("￥");
        stringBuilder1.append(Math.round(paramVIPBuyOption.original_money));
        textView6.setText(stringBuilder1.toString());
        textView6.getPaint().setFlags(16);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("￥");
        stringBuilder2.append(decimalFormat.format(paramVIPBuyOption.money / paramVIPBuyOption.month));
        stringBuilder2.append(this.k.getResources().getString(2131758357));
        textView3.setText(stringBuilder2.toString());
        if (!StringUtils.e(paramVIPBuyOption.item.tag)) {
          shapeTextView.setText(paramVIPBuyOption.item.tag);
          shapeTextView.setVisibility(0);
        } else {
          shapeTextView.setVisibility(4);
        } 
        boolean bool = false;
        constraintLayout.setOnClickListener(new -$$Lambda$VIPItemRoundAdapter$sUKEEkegxGoPU0RRN-k9v95Ai9I(this, paramVIPBuyOption));
        if (textView4.getVisibility() == 0)
          bool = true; 
        if (paramVIPBuyOption.choosen) {
          if (bool) {
            if (this.b == 2) {
              constraintLayout.setBackground(BluedSkinUtils.b(this.k, 2131233741));
            } else {
              constraintLayout.setBackground(BluedSkinUtils.b(this.k, 2131233747));
            } 
          } else if (this.b == 2) {
            constraintLayout.setBackground(BluedSkinUtils.b(this.k, 2131233740));
          } else {
            constraintLayout.setBackground(BluedSkinUtils.b(this.k, 2131233746));
          } 
        } else if (bool) {
          constraintLayout.setBackground(BluedSkinUtils.b(this.k, 2131233743));
        } else {
          constraintLayout.setBackground(BluedSkinUtils.b(this.k, 2131233742));
        } 
        if (this.b == 2) {
          textView1.setTextColor(this.k.getResources().getColor(2131099657));
          textView2.setTextColor(this.k.getResources().getColor(2131099657));
          ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131099657);
          ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131099658);
          return;
        } 
        textView1.setTextColor(this.k.getResources().getColor(2131099662));
        textView2.setTextColor(this.k.getResources().getColor(2131099662));
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131099662);
        ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131099660);
      } 
    } 
  }
  
  public void a(onGoodClick paramonGoodClick) {
    this.c = paramonGoodClick;
  }
  
  public void a(List<VIPBuyOption> paramList) {
    if (paramList != null) {
      for (int i = 0; i < paramList.size(); i++)
        ((VIPBuyOption)paramList.get(i)).vip_grade = this.b; 
      this.n.clear();
      this.n.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public static interface onGoodClick {
    void onclick(VIPBuyOption param1VIPBuyOption);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPItemRoundAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.utils.FlutterRouter;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class VIPCenterExpLvlRightAdapter extends BaseQuickAdapter<VIPCenterForJsonParse._privilege_list, BaseViewHolder> {
  public IRequestHost a;
  
  public int b;
  
  public VIPCenterExpLvlRightAdapter(IRequestHost paramIRequestHost, List<VIPCenterForJsonParse._privilege_list> paramList, int paramInt) {
    super(2131493683, paramList);
    this.a = paramIRequestHost;
    this.b = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPCenterForJsonParse._privilege_list param_privilege_list) {
    if (paramBaseViewHolder != null) {
      if (param_privilege_list == null)
        return; 
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297463);
      TextView textView1 = (TextView)paramBaseViewHolder.d(2131297565);
      TextView textView2 = (TextView)paramBaseViewHolder.d(2131301088);
      ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131300587);
      if (this.b == 2) {
        shapeTextView.setTextColor(BluedSkinUtils.a(this.k, 2131099659));
      } else {
        shapeTextView.setTextColor(BluedSkinUtils.a(this.k, 2131099662));
      } 
      ImageLoader.a(this.a, param_privilege_list.icon).a(imageView);
      if (!StringUtils.e(param_privilege_list.corner)) {
        textView1.setText(param_privilege_list.corner);
        textView1.setVisibility(0);
      } else {
        textView1.setVisibility(8);
      } 
      if (!StringUtils.e(param_privilege_list.title)) {
        textView2.setText(param_privilege_list.title);
        textView2.setVisibility(0);
      } else {
        textView2.setVisibility(8);
      } 
      if (!StringUtils.e(param_privilege_list.unit)) {
        shapeTextView.setText(param_privilege_list.unit);
        shapeTextView.setVisibility(0);
      } else {
        shapeTextView.setVisibility(8);
      } 
      imageView.setOnClickListener(new -$$Lambda$VIPCenterExpLvlRightAdapter$GaGFlo9lGN27Z5O7nb2eie3-gSE(this));
      textView2.setOnClickListener(new -$$Lambda$VIPCenterExpLvlRightAdapter$6-P_c2ChEF8VFVZrTYfBTS9Q9OI(imageView));
      shapeTextView.setOnClickListener(new -$$Lambda$VIPCenterExpLvlRightAdapter$jDQm9U1WkXWlw6KxnYPmoIugD_Q(imageView));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPCenterExpLvlRightAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.msg.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import java.util.List;

public class RecentPhotoAdapter extends BaseQuickAdapter<MsgRecentPhotoInfo, BaseViewHolder> {
  private LoadOptions a = null;
  
  private IRecentPhotoAdapterCallback b;
  
  private double c;
  
  private IRequestHost d;
  
  public RecentPhotoAdapter(IRequestHost paramIRequestHost, IRecentPhotoAdapterCallback paramIRecentPhotoAdapterCallback) {
    super(2131494247);
    this.d = paramIRequestHost;
    this.b = paramIRecentPhotoAdapterCallback;
    if (this.b == null)
      return; 
    this.c = (KeyboardUtils.a() - DisplayUtil.a(AppInfo.d().getApplicationContext(), 50.0F));
    this.b.a(new IRecentPhotoAdapterCallback.IGetPhotoListCallback(this) {
          public void a(List<MsgRecentPhotoInfo> param1List) {
            this.a.c(param1List);
          }
        });
  }
  
  private void a() {
    notifyDataSetChanged();
    IRecentPhotoAdapterCallback iRecentPhotoAdapterCallback = this.b;
    if (iRecentPhotoAdapterCallback != null)
      iRecentPhotoAdapterCallback.R(); 
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    double d1;
    if (paramMsgRecentPhotoInfo == null)
      return; 
    ViewGroup.LayoutParams layoutParams1 = paramBaseViewHolder.itemView.getLayoutParams();
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131299287);
    ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
    int i = paramMsgRecentPhotoInfo.isNormalImg;
    double d2 = 1.7777777910232544D;
    if (i != 1) {
      if (i != 2) {
        d1 = this.c;
        d2 = (paramMsgRecentPhotoInfo.width * 1.0F / paramMsgRecentPhotoInfo.height);
      } else {
        d1 = this.c;
      } 
      d1 *= d2;
    } else {
      d1 = this.c / 1.7777777910232544D;
    } 
    i = (int)d1;
    layoutParams2.width = i;
    layoutParams2.height = (int)this.c;
    layoutParams1.width = i;
    imageView2.setLayoutParams(layoutParams2);
    paramBaseViewHolder.itemView.setLayoutParams(layoutParams1);
    ImageLoader.d(this.d, paramMsgRecentPhotoInfo.imgPath).a(imageView2);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131299290);
    imageView1.setSelected(paramMsgRecentPhotoInfo.isSelected);
    paramBaseViewHolder.c(2131299289, paramMsgRecentPhotoInfo.isPin);
    imageView1.setOnClickListener(new View.OnClickListener(this, paramMsgRecentPhotoInfo) {
          public void onClick(View param1View) {
            if (RecentPhotoAdapter.a(this.b).getScrollState() == 0 && !RecentPhotoAdapter.b(this.b).isComputingLayout()) {
              MsgRecentPhotoInfo msgRecentPhotoInfo = this.a;
              msgRecentPhotoInfo.isSelected ^= 0x1;
              RecentPhotoAdapter.c(this.b);
            } 
          }
        });
    paramBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, paramMsgRecentPhotoInfo) {
          public void onClick(View param1View) {
            if (RecentPhotoAdapter.d(this.b).getScrollState() == 0 && !RecentPhotoAdapter.e(this.b).isComputingLayout()) {
              MsgRecentPhotoInfo msgRecentPhotoInfo = this.a;
              msgRecentPhotoInfo.isSelected ^= 0x1;
              RecentPhotoAdapter.c(this.b);
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\RecentPhotoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
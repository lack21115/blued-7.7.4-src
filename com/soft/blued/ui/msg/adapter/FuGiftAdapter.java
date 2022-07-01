package com.soft.blued.ui.msg.adapter;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.model.FuGiftModel;
import java.util.List;

public class FuGiftAdapter extends BaseQuickAdapter<FuGiftModel, BaseViewHolder> {
  private IRequestHost a;
  
  public FuGiftAdapter(List<FuGiftModel> paramList, IRequestHost paramIRequestHost) {
    super(2131493530, paramList);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FuGiftModel paramFuGiftModel) {
    ImageLoader.a(this.a, paramFuGiftModel.image).a((ImageView)paramBaseViewHolder.d(2131297656));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\FuGiftAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
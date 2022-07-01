package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickApplyHandleListener;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class WaittingAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
  private BaseYYStudioFragment a;
  
  private ClickApplyHandleListener b;
  
  public WaittingAdapter(BaseYYStudioFragment paramBaseYYStudioFragment) {
    super(R.layout.item_yy_waitting_layout, new ArrayList());
    this.k = paramBaseYYStudioFragment.getContext();
    this.a = paramBaseYYStudioFragment;
  }
  
  public void a(int paramInt) {
    if (paramInt >= 0) {
      if (paramInt >= n().size())
        return; 
      n().remove(paramInt);
      notifyDataSetChanged();
    } 
  }
  
  public void a(ClickApplyHandleListener paramClickApplyHandleListener) {
    this.b = paramClickApplyHandleListener;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYAudienceModel paramYYAudienceModel) {
    ShapeTextView shapeTextView1 = (ShapeTextView)paramBaseViewHolder.d(R.id.btn_reject);
    ShapeTextView shapeTextView2 = (ShapeTextView)paramBaseViewHolder.d(R.id.btn_accept);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_name);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_seat);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    textView1.setText(paramYYAudienceModel.getName());
    ImageLoader.a((IRequestHost)this.a.w_(), paramYYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    if (paramYYAudienceModel.mic_position == 0) {
      textView2.setText(this.k.getResources().getString(R.string.yy_up_seat));
    } else {
      textView2.setText(String.format(this.k.getResources().getString(R.string.yy_mic_position), new Object[] { Integer.valueOf(paramYYAudienceModel.mic_position) }));
    } 
    shapeTextView1.setOnClickListener(new View.OnClickListener(this, paramYYAudienceModel, paramBaseViewHolder) {
          public void onClick(View param1View) {
            if (WaittingAdapter.a(this.c) != null)
              WaittingAdapter.a(this.c).a(this.a, 0, this.b.getAdapterPosition()); 
          }
        });
    shapeTextView2.setOnClickListener(new View.OnClickListener(this, paramYYAudienceModel, paramBaseViewHolder) {
          public void onClick(View param1View) {
            if (WaittingAdapter.a(this.c) != null)
              WaittingAdapter.a(this.c).a(this.a, 1, this.b.getAdapterPosition()); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\WaittingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
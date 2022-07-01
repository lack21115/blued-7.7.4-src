package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.fragment.LiveHomeFragment;
import com.soft.blued.ui.live.fragment.LiveListTabFragment;
import com.soft.blued.ui.live.model.LiveTabModel;
import java.util.ArrayList;
import java.util.List;

public class LiveCategoryAdapter extends BaseQuickAdapter<LiveTabModel, BaseViewHolder> {
  private LiveHomeFragment a;
  
  private Context b;
  
  private ImageView c;
  
  private TextView d;
  
  private ImageView e;
  
  private ImageView f;
  
  private LoadOptions g;
  
  public LiveCategoryAdapter(LiveHomeFragment paramLiveHomeFragment) {
    super(2131493816, null);
    this.a = paramLiveHomeFragment;
    this.b = paramLiveHomeFragment.getContext();
    this.g = new LoadOptions();
    c(new ArrayList());
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveTabModel paramLiveTabModel) {
    if (paramBaseViewHolder != null && paramLiveTabModel != null) {
      this.c = (ImageView)paramBaseViewHolder.d(2131297720);
      this.d = (TextView)paramBaseViewHolder.d(2131300616);
      this.d.setText(paramLiveTabModel.name);
      this.e = (ImageView)paramBaseViewHolder.d(2131297469);
      this.f = (ImageView)paramBaseViewHolder.d(2131297523);
      this.f.setVisibility(8);
      String str = "new_icon";
      if (!BluedSkinUtils.c()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("new_icon");
        stringBuilder1.append("_dark");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(".png");
      str = stringBuilder.toString();
      ImageLoader.c((IRequestHost)this.a.w_(), str).f().e(-1).a(this.e);
      boolean bool = TextUtils.equals("15", paramLiveTabModel.id);
      byte b = 0;
      if (bool) {
        this.e.setVisibility(8);
        if (this.a.h) {
          this.f.setVisibility(0);
        } else {
          this.f.setVisibility(8);
        } 
        if (this.a.g) {
          str = paramLiveTabModel.less_cate_icon;
        } else {
          str = paramLiveTabModel.more_cate_icon;
        } 
      } else {
        ImageView imageView = this.e;
        if (!paramLiveTabModel.showNew)
          b = 8; 
        imageView.setVisibility(b);
        this.f.setVisibility(8);
        str = paramLiveTabModel.icon;
      } 
      ImageLoader.a((IRequestHost)this.a.w_(), str).a(this.c);
      paramBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, paramLiveTabModel, paramBaseViewHolder) {
            public void onClick(View param1View) {
              if (TextUtils.equals("15", this.a.id)) {
                (LiveCategoryAdapter.a(this.c)).h = false;
                EventTrackLive.a(LiveProtos.Event.LIVE_CLASSIFY_BTN_CLICK);
                if ((LiveCategoryAdapter.a(this.c)).g) {
                  LiveCategoryAdapter.a(this.c).E();
                } else {
                  LiveCategoryAdapter.a(this.c).n();
                } 
                LiveCategoryAdapter.b(this.c).setVisibility(8);
                return;
              } 
              LiveCategoryAdapter.a(this.c).a(this.b.getLayoutPosition());
              this.c.notifyDataSetChanged();
              LiveListTabFragment.a(LiveCategoryAdapter.c(this.c), this.a.id, this.a.name, this.a.type);
            }
          });
    } 
  }
  
  public void a(List<LiveTabModel> paramList) {
    c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveCategoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
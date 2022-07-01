package com.soft.blued.ui.video.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.video.fragment.VideoScanFragment;

public class MusicVideoCollectAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  private String c;
  
  public MusicVideoCollectAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493606);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private boolean b(String paramString) {
    return TextUtils.isEmpty(this.c) ? false : (TextUtils.isEmpty(paramString) ? false : this.c.equals(paramString));
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBaseViewHolder != null) {
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297734);
      if (paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length > 0) {
        ImageLoader.a(this.b, paramBluedIngSelfFeed.feed_videos[0]).a(2131231369).a(new ImageLoadResult(this, this.b, imageView) {
              public void a() {
                Drawable drawable = this.a.getDrawable();
                if (drawable != null) {
                  if (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight()) {
                    this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return;
                  } 
                  this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                  return;
                } 
                this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
              }
            }).a(imageView);
      } else {
        imageView.setImageResource(2131231369);
      } 
      imageView.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
            public void onClick(View param1View) {
              VideoScanFragment.a(MusicVideoCollectAdapter.a(this.b), this.a, true, 17);
            }
          });
      if (b(paramBluedIngSelfFeed.feed_id)) {
        paramBaseViewHolder.b(2131300771, true);
        return;
      } 
      paramBaseViewHolder.b(2131300771, false);
    } 
  }
  
  public void a(String paramString) {
    this.c = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\adapter\MusicVideoCollectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.fragment.CirclePostDetailsFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.model.MyCircleTalkModel;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.utils.TimeAndDateUtils;

public class MyCircleTalkAdapter extends BaseQuickAdapter<MyCircleTalkModel, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public MyCircleTalkAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493486, null);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, MyCircleTalkModel paramMyCircleTalkModel) {
    if (paramBaseViewHolder != null) {
      if (paramMyCircleTalkModel.feed_comment > 999) {
        paramBaseViewHolder.a(2131299368, "999+");
      } else {
        paramBaseViewHolder.a(2131299368, Integer.toString(paramMyCircleTalkModel.feed_comment));
      } 
      if (!TextUtils.isEmpty(paramMyCircleTalkModel.feed_content)) {
        String str = paramMyCircleTalkModel.feed_content.replaceAll("\r|\n", "");
        paramBaseViewHolder.a(2131299369, (CharSequence)CircleMethods.addAuditing(paramMyCircleTalkModel, MarkDownLinkHelper.a(this.a, str)));
      } else {
        paramBaseViewHolder.b(2131299369, 2131755914);
      } 
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131299371);
      ImageLoader.a(this.b, paramMyCircleTalkModel.cover).a(2131231281).a(imageView);
      paramBaseViewHolder.a(2131299375, paramMyCircleTalkModel.title);
      paramBaseViewHolder.a(2131299377, TimeAndDateUtils.c(this.a, TimeAndDateUtils.b(paramMyCircleTalkModel.last_comment_time)));
      imageView = (ImageView)paramBaseViewHolder.d(2131299372);
      if (paramMyCircleTalkModel.is_video_posts == 1 && paramMyCircleTalkModel.feed_videos != null && paramMyCircleTalkModel.feed_videos.length > 0) {
        paramBaseViewHolder.b(2131297897, true);
        ImageLoader.a(this.b, paramMyCircleTalkModel.feed_videos[0]).a(imageView);
        paramBaseViewHolder.b(2131299373, true);
      } else {
        paramBaseViewHolder.b(2131297897, false);
        if (paramMyCircleTalkModel.feed_pics != null && paramMyCircleTalkModel.feed_pics.length > 0) {
          ImageLoader.a(this.b, paramMyCircleTalkModel.feed_pics[0]).a(imageView);
          paramBaseViewHolder.b(2131299373, true);
        } else {
          paramBaseViewHolder.b(2131299373, false);
        } 
      } 
      paramBaseViewHolder.a(2131299374, new View.OnClickListener(this, paramMyCircleTalkModel) {
            public void onClick(View param1View) {
              CircleDetailsFragment.a(MyCircleTalkAdapter.a(this.b), (MyCircleModel)this.a, CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE);
            }
          });
      paramBaseViewHolder.a(2131299376, new View.OnClickListener(this, paramMyCircleTalkModel) {
            public void onClick(View param1View) {
              Context context = MyCircleTalkAdapter.a(this.b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.feed_id);
              stringBuilder.append("");
              CirclePostDetailsFragment.a(context, stringBuilder.toString(), FeedProtos.NoteSource.NOTE_LIST);
            }
          });
    } 
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MyCircleTalkModel paramMyCircleTalkModel) {
    if (paramBaseViewHolder != null)
      b(paramBaseViewHolder, paramMyCircleTalkModel); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\MyCircleTalkAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
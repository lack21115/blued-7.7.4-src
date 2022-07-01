package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.fragment.SuperTopicDetailFragment;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.utils.AreaUtils;

public class RecommendTopicAdapter extends BaseQuickAdapter<BluedTopic, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public RecommendTopicAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493639, null);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private void a(BluedTopic paramBluedTopic, MyTopicViewHolder paramMyTopicViewHolder) {
    ImageLoader.a(this.b, paramBluedTopic.avatar).a(2131234240).a(6.0F).a(MyTopicViewHolder.b(paramMyTopicViewHolder));
    MyTopicViewHolder.c(paramMyTopicViewHolder).setText(paramBluedTopic.name);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AreaUtils.a(this.a, paramBluedTopic.join_total));
    stringBuilder.append(this.a.getString(2131758339));
    String str = stringBuilder.toString();
    MyTopicViewHolder.d(paramMyTopicViewHolder).setText(str);
    MyTopicViewHolder.e(paramMyTopicViewHolder).getBackground().setAlpha(15);
    MyTopicViewHolder.a(paramMyTopicViewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedTopic) {
          public void onClick(View param1View) {
            EventTrackFeed.d(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK, this.a.super_did);
            SuperTopicDetailFragment.a(RecommendTopicAdapter.a(this.b), this.a.super_did);
          }
        });
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedTopic paramBluedTopic) {
    if (paramBaseViewHolder != null) {
      MyTopicViewHolder myTopicViewHolder3 = new MyTopicViewHolder(this, paramBaseViewHolder, 0);
      MyTopicViewHolder myTopicViewHolder2 = new MyTopicViewHolder(this, paramBaseViewHolder, 1);
      MyTopicViewHolder myTopicViewHolder1 = new MyTopicViewHolder(this, paramBaseViewHolder, 2);
      MyTopicViewHolder.a(myTopicViewHolder3).setVisibility(8);
      MyTopicViewHolder.a(myTopicViewHolder2).setVisibility(8);
      MyTopicViewHolder.a(myTopicViewHolder1).setVisibility(8);
      if (paramBluedTopic.bluedTopicList.size() > 0) {
        MyTopicViewHolder.a(myTopicViewHolder3).setVisibility(0);
        BluedTopic bluedTopic = paramBluedTopic.bluedTopicList.get(0);
        a(bluedTopic, myTopicViewHolder3);
        if (!bluedTopic.isShowUrlVisited) {
          EventTrackFeed.d(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, bluedTopic.super_did);
          bluedTopic.isShowUrlVisited = true;
        } 
      } 
      if (paramBluedTopic.bluedTopicList.size() > 1) {
        MyTopicViewHolder.a(myTopicViewHolder2).setVisibility(0);
        BluedTopic bluedTopic = paramBluedTopic.bluedTopicList.get(1);
        a(bluedTopic, myTopicViewHolder2);
        if (!bluedTopic.isShowUrlVisited) {
          EventTrackFeed.d(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, bluedTopic.super_did);
          bluedTopic.isShowUrlVisited = true;
        } 
      } 
      if (paramBluedTopic.bluedTopicList.size() > 2) {
        MyTopicViewHolder.a(myTopicViewHolder1).setVisibility(0);
        paramBluedTopic = paramBluedTopic.bluedTopicList.get(2);
        a(paramBluedTopic, myTopicViewHolder1);
        if (!paramBluedTopic.isShowUrlVisited) {
          EventTrackFeed.d(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, paramBluedTopic.super_did);
          paramBluedTopic.isShowUrlVisited = true;
        } 
      } 
    } 
  }
  
  public class MyTopicViewHolder {
    private View b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private ShapeTextView f;
    
    public MyTopicViewHolder(RecommendTopicAdapter this$0, BaseViewHolder param1BaseViewHolder, int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int == 2)
            this.b = param1BaseViewHolder.d(2131297652); 
        } else {
          this.b = param1BaseViewHolder.d(2131297651);
        } 
      } else {
        this.b = param1BaseViewHolder.d(2131297650);
      } 
      this.c = (ImageView)this.b.findViewById(2131297463);
      this.d = (TextView)this.b.findViewById(2131301443);
      this.e = (TextView)this.b.findViewById(2131301441);
      this.f = (ShapeTextView)this.b.findViewById(2131300100);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\RecommendTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
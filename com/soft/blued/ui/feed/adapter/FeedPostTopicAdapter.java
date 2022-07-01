package com.soft.blued.ui.feed.adapter;

import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.model.BluedTopic;

public class FeedPostTopicAdapter extends BaseQuickAdapter<BluedTopic, BaseViewHolder> {
  public FeedPostTopicAdapter() {
    super(2131493516);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedTopic paramBluedTopic) {
    boolean bool;
    if (paramBluedTopic.is_new == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    paramBaseViewHolder.b(2131297872, bool);
    paramBaseViewHolder.a(2131301440, paramBluedTopic.name);
    paramBaseViewHolder.c(2131299752);
    if (!paramBluedTopic.isShowUrlVisited) {
      EventTrackFeed.d(FeedProtos.Event.FEED_PUBLISH_TOPIC_SHOW, paramBluedTopic.super_did);
      paramBluedTopic.isShowUrlVisited = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedPostTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
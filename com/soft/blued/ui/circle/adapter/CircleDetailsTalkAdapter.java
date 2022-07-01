package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.utils.MarkDownLinkHelper;

public class CircleDetailsTalkAdapter extends CircleTalkAdapter {
  private int e = 0;
  
  public CircleDetailsTalkAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(paramContext, paramIRequestHost);
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBaseViewHolder != null) {
      super.a(paramBaseViewHolder, paramBluedIngSelfFeed);
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131299371);
      ImageLoader.a(this.b, paramBluedIngSelfFeed.user_avatar).a(2131234356).c().a(imageView);
      int i = paramBluedIngSelfFeed.is_anonym;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      paramBaseViewHolder.b(2131297682, bool);
      paramBaseViewHolder.a(2131299375, paramBluedIngSelfFeed.user_name);
      c(paramBaseViewHolder);
    } 
  }
  
  protected void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (!paramBluedIngSelfFeed.isShowUrlVisited) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE;
      int i = this.e;
      if (i != 0) {
        if (i != 1) {
          if (i == 2)
            noteSource = FeedProtos.NoteSource.CIRCLE_ESSENCE; 
        } else {
          noteSource = FeedProtos.NoteSource.CIRCLE_HOT;
        } 
      } else {
        noteSource = FeedProtos.NoteSource.CIRCLE_NEW;
      } 
      FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_DRAW;
      String str1 = paramBluedIngSelfFeed.circle_id;
      String str2 = paramBluedIngSelfFeed.feed_id;
      if (paramBluedIngSelfFeed.is_top == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      FeedProtos.NoteType noteType = EventTrackFeed.b(paramBluedIngSelfFeed);
      String str3 = paramBluedIngSelfFeed.note_from;
      if (paramBluedIngSelfFeed.is_anonym == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (paramBluedIngSelfFeed.is_essence == 1) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      EventTrackFeed.a(event, str1, str2, noteSource, bool1, noteType, str3, bool2, bool3, MarkDownLinkHelper.a(paramBluedIngSelfFeed.feed_pure_content));
      paramBluedIngSelfFeed.isShowUrlVisited = true;
    } 
  }
  
  protected void b(BaseViewHolder paramBaseViewHolder) {
    paramBaseViewHolder.c(2131299371);
    paramBaseViewHolder.c(2131299375);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleDetailsTalkAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
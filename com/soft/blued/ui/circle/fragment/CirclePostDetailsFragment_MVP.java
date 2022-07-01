package com.soft.blued.ui.circle.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import java.util.List;

public final class CirclePostDetailsFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    CirclePostDetailsFragment circlePostDetailsFragment = (CirclePostDetailsFragment)paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      FeedComment feedComment = (FeedComment)paramList.get(0);
      if (feedComment != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 1916362443:
            if (paramString.equals("data_circle_detail")) {
              b = 1;
              break;
            } 
          case 1896880120:
            if (paramString.equals("data_scroll_to_comment")) {
              b = 3;
              break;
            } 
          case 1131936684:
            if (paramString.equals("data_add_comment")) {
              b = 5;
              break;
            } 
          case 1024790391:
            if (paramString.equals("data_add_reply")) {
              b = 2;
              break;
            } 
          case 720741084:
            if (paramString.equals("data_comment_state")) {
              b = 4;
              break;
            } 
          case -115516173:
            if (paramString.equals("data_comment_list")) {
              b = 6;
              break;
            } 
          case -1204520412:
            if (paramString.equals("data_circle_join"))
              break; 
        } 
        switch (b) {
          default:
            return;
          case 6:
            if (FeedComment.class.isInstance(feedComment)) {
              circlePostDetailsFragment.a((List)paramList);
              return;
            } 
            return;
          case 5:
            if (FeedComment.class.isInstance(feedComment)) {
              circlePostDetailsFragment.a(feedComment);
              return;
            } 
            return;
          case 4:
            if (BluedIngSelfFeed.class.isInstance(feedComment)) {
              circlePostDetailsFragment.c((BluedIngSelfFeed)feedComment);
              return;
            } 
            return;
          case 3:
            if (Boolean.class.isInstance(feedComment)) {
              circlePostDetailsFragment.a((Boolean)feedComment);
              return;
            } 
            return;
          case 2:
            if (FeedComment.class.isInstance(feedComment)) {
              circlePostDetailsFragment.b(feedComment);
              return;
            } 
            return;
          case 1:
            if (BluedIngSelfFeed.class.isInstance(feedComment)) {
              circlePostDetailsFragment.a((BluedIngSelfFeed)feedComment);
              return;
            } 
            return;
          case 0:
            break;
        } 
        if (BluedIngSelfFeed.class.isInstance(feedComment))
          circlePostDetailsFragment.b((BluedIngSelfFeed)feedComment); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CirclePostDetailsFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
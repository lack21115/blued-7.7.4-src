package com.soft.blued.ui.feed.observer;

import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;

public interface IFeedDataObserver {
  void a(int paramInt);
  
  void a(BluedIngSelfFeed paramBluedIngSelfFeed);
  
  void a(FeedComment paramFeedComment);
  
  void a(FeedRepost paramFeedRepost);
  
  void a(String paramString, int paramInt);
  
  void a(String paramString1, String paramString2);
  
  void b(int paramInt);
  
  void b(String paramString, int paramInt);
  
  void b(String paramString1, String paramString2);
  
  void c(String paramString, int paramInt);
  
  void d(String paramString);
  
  void e(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\observer\IFeedDataObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.feed.model;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedParse implements Serializable {
  private static int COMMENT_TEXT_SIZE;
  
  private static int CONTENT_TEXT_SIZE;
  
  private List<CharSequence> commentList;
  
  private String distance;
  
  private String feedComment;
  
  private CharSequence feedContent;
  
  private String feedDig;
  
  private String feedFeedShow;
  
  private int feedFrom;
  
  private CharSequence feedRepostContent;
  
  private String feedTimestamp;
  
  private int oldComment;
  
  private int oldDig;
  
  private long oldFeedShow;
  
  private String topicName;
  
  public FeedParse(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt) {
    this(paramContext, paramBluedIngSelfFeed, paramInt, "");
  }
  
  public FeedParse(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt, String paramString) {
    this.feedFrom = paramInt;
    this.topicName = paramString;
    COMMENT_TEXT_SIZE = DensityUtils.a(paramContext, 14.0F);
    CONTENT_TEXT_SIZE = DensityUtils.a(paramContext, 14.0F);
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.feed_timestamp)) {
      if (paramInt == 6 || paramInt == 14 || paramInt == 10 || paramInt == 4) {
        this.feedTimestamp = TimeAndDateUtils.b(paramContext, TimeAndDateUtils.b(paramBluedIngSelfFeed.feed_timestamp));
      } else {
        this.feedTimestamp = TimeAndDateUtils.c(paramContext, TimeAndDateUtils.b(paramBluedIngSelfFeed.feed_timestamp));
      } 
    } else {
      this.feedTimestamp = "";
    } 
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.distance)) {
      this.distance = DistanceUtils.a(paramBluedIngSelfFeed.distance, BlueAppLocal.c(), false);
    } else {
      this.distance = "";
    } 
    if (paramBluedIngSelfFeed.isRepost()) {
      this.feedRepostContent = parseContent(paramContext, paramBluedIngSelfFeed.feed_content);
      paramString = paramBluedIngSelfFeed.repost.feed_content;
      if ((paramBluedIngSelfFeed.getContentData()).feed_is_delete == 1) {
        paramString = paramContext.getResources().getString(2131756398);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.c((paramBluedIngSelfFeed.getContentData()).user_name, (paramBluedIngSelfFeed.getContentData()).feed_uid));
        stringBuilder.append(": ");
        stringBuilder.append(paramString);
        paramString = stringBuilder.toString();
      } 
      this.feedContent = parseContent(paramContext, paramString);
    } else if (!TextUtils.isEmpty((paramBluedIngSelfFeed.getContentData()).feed_content)) {
      this.feedContent = parseContent(paramContext, (paramBluedIngSelfFeed.getContentData()).feed_content);
    } 
    this.oldDig = paramBluedIngSelfFeed.feed_dig;
    this.feedDig = parseDig(paramContext, paramBluedIngSelfFeed.feed_dig);
    this.oldComment = paramBluedIngSelfFeed.feed_comment;
    this.feedComment = parseComment(paramContext, paramBluedIngSelfFeed.feed_comment);
    this.commentList = new ArrayList<CharSequence>();
    if (paramBluedIngSelfFeed.comments != null && paramBluedIngSelfFeed.comments.size() > 0) {
      if ("1".equals(((FeedComment)paramBluedIngSelfFeed.comments.get(0)).is_reply)) {
        this.commentList.add(FeedMethods.c(paramContext, COMMENT_TEXT_SIZE, paramBluedIngSelfFeed.comments.get(0), paramInt, 2131100838));
      } else {
        this.commentList.add(FeedMethods.d(paramContext, COMMENT_TEXT_SIZE, paramBluedIngSelfFeed.comments.get(0), paramInt, 2131100838));
      } 
      if (paramBluedIngSelfFeed.comments.size() >= 2)
        if ("1".equals(((FeedComment)paramBluedIngSelfFeed.comments.get(1)).is_reply)) {
          this.commentList.add(FeedMethods.c(paramContext, COMMENT_TEXT_SIZE, paramBluedIngSelfFeed.comments.get(1), paramInt, 2131100838));
        } else {
          this.commentList.add(FeedMethods.d(paramContext, COMMENT_TEXT_SIZE, paramBluedIngSelfFeed.comments.get(1), paramInt, 2131100838));
        }  
    } 
    this.oldFeedShow = paramBluedIngSelfFeed.feed_show;
    this.feedFeedShow = parseFeedShow(paramContext, paramBluedIngSelfFeed.feed_show);
  }
  
  private String parseComment(Context paramContext, int paramInt) {
    return (paramInt > 0) ? AreaUtils.a(paramContext, Integer.toString(paramInt)) : paramContext.getString(2131756043);
  }
  
  private CharSequence parseContent(Context paramContext, String paramString) {
    return StringUtils.a(StringUtils.a(MarkDownLinkHelper.a(paramContext, StringUtils.a(paramString, CONTENT_TEXT_SIZE, 0), true, 2131100849, true, null), true, true, true, FeedMethods.a(this.feedFrom, 0)), true, new boolean[0]);
  }
  
  private String parseDig(Context paramContext, int paramInt) {
    return (paramInt > 0) ? AreaUtils.a(paramContext, Integer.toString(paramInt)) : paramContext.getString(2131759525);
  }
  
  private String parseFeedShow(Context paramContext, long paramLong) {
    return AreaUtils.a(paramContext, String.valueOf(paramLong));
  }
  
  public List<CharSequence> getCommentList() {
    return this.commentList;
  }
  
  public String getDistance() {
    return this.distance;
  }
  
  public String getFeedComment(Context paramContext, int paramInt) {
    if (paramInt != this.oldComment || this.feedComment == null) {
      this.oldComment = paramInt;
      this.feedComment = parseComment(paramContext, paramInt);
    } 
    return this.feedComment;
  }
  
  public CharSequence getFeedContent() {
    return this.feedContent;
  }
  
  public String getFeedDig(Context paramContext, int paramInt) {
    if (paramInt != this.oldDig || this.feedDig == null) {
      this.oldDig = paramInt;
      this.feedDig = parseDig(paramContext, paramInt);
    } 
    return this.feedDig;
  }
  
  public String getFeedFeedShow(Context paramContext, long paramLong) {
    if (paramLong != this.oldFeedShow || this.feedFeedShow == null) {
      this.oldFeedShow = paramLong;
      this.feedFeedShow = parseFeedShow(paramContext, paramLong);
    } 
    return this.feedFeedShow;
  }
  
  public CharSequence getFeedRepostContent() {
    return this.feedRepostContent;
  }
  
  public String getFeedTimestamp() {
    return this.feedTimestamp;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\FeedParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
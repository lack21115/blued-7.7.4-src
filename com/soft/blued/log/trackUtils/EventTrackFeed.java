package com.soft.blued.log.trackUtils;

import com.blued.das.client.feed.FeedProtos;
import com.google.protobuf.Message;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.share_custom.Model.ShareEntity;

public class EventTrackFeed {
  public static FeedProtos.CircleSource a(CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE) {
    FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
    if (paramCIRCLE_FROM_PAGE == null)
      return circleSource; 
    int i = null.a[paramCIRCLE_FROM_PAGE.ordinal()];
    if (i != 1) {
      switch (i) {
        default:
          return circleSource;
        case 15:
          return FeedProtos.CircleSource.CIRCLE_MORE_LIST;
        case 14:
          return FeedProtos.CircleSource.DETAIL_FEED_ENTER;
        case 13:
          return FeedProtos.CircleSource.PERSONAL_PROFILE_CIRCLE;
        case 12:
          return FeedProtos.CircleSource.RECOMMEND_FEED_ENTER;
        case 11:
          return FeedProtos.CircleSource.CITY_FEED_ENTER;
        case 10:
          return FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND;
        case 9:
          return FeedProtos.CircleSource.CIRCLE_NOTE_DETAIL_NAME;
        case 8:
          return FeedProtos.CircleSource.FIND_CIRCLE_DISCUSS_LIST;
        case 7:
          return FeedProtos.CircleSource.FIND_CIRCLE_MINE_ALL;
        case 6:
          return FeedProtos.CircleSource.FIND_CIRCLE_MINE;
        case 5:
          return FeedProtos.CircleSource.FIND_CIRCLE_LIST;
        case 4:
          break;
      } 
      return FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE;
    } 
    return FeedProtos.CircleSource.CIRCLE_APPLY_AGREE_MSG;
  }
  
  public static FeedProtos.CircleSource a(CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE, int paramInt1, int paramInt2, int paramInt3) {
    FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
    if (paramCIRCLE_FROM_PAGE == null)
      return circleSource; 
    int i = null.a[paramCIRCLE_FROM_PAGE.ordinal()];
    return (i != 1) ? ((i != 2) ? ((i != 3) ? a(paramCIRCLE_FROM_PAGE) : i(paramInt3)) : h(paramInt2)) : ((paramInt1 != 1) ? ((paramInt1 != 2) ? ((paramInt1 != 3 && paramInt1 != 4) ? circleSource : FeedProtos.CircleSource.MANAGE_VICE_CAPTAIN_MSG) : FeedProtos.CircleSource.CIRCLE_INVITE_MSG) : FeedProtos.CircleSource.CIRCLE_APPLY_AGREE_MSG);
  }
  
  public static FeedProtos.DetailFrom a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 4) ? ((paramInt != 6) ? ((paramInt != 10) ? ((paramInt != 14) ? FeedProtos.DetailFrom.UNKNOWN_DETAIL_FROM : FeedProtos.DetailFrom.FEED_MORE_PAGE) : FeedProtos.DetailFrom.FIND_IMAGE_PAGE) : FeedProtos.DetailFrom.FIND_PLAZA) : FeedProtos.DetailFrom.FIND_NEARBY) : FeedProtos.DetailFrom.PERSONAL_PAGE) : FeedProtos.DetailFrom.FIND_FOLLOW;
  }
  
  public static FeedProtos.FeedClass a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    FeedProtos.FeedClass feedClass = FeedProtos.FeedClass.UNKNOWN_FEED_CLASS;
    if (paramBluedIngSelfFeed.feed_type == -1)
      paramBluedIngSelfFeed.feed_type = paramBluedIngSelfFeed.getItemType(); 
    int i = paramBluedIngSelfFeed.feed_type;
    return (i != 0) ? ((i != 1 && i != 2) ? ((i != 3) ? ((i != 8) ? ((i != 16) ? feedClass : FeedProtos.FeedClass.FEED_LIVE) : FeedProtos.FeedClass.FEED_VOTE) : FeedProtos.FeedClass.FEED_VIDEO) : FeedProtos.FeedClass.FEED_IMAGE) : ((paramBluedIngSelfFeed.feed_pics == null || paramBluedIngSelfFeed.feed_pics.length == 0) ? FeedProtos.FeedClass.FEED_WORD : FeedProtos.FeedClass.FEED_IMAGE);
  }
  
  public static FeedProtos.FeedClass a(FeedComment paramFeedComment) {
    return (paramFeedComment == null) ? FeedProtos.FeedClass.FEED_WORD : ((paramFeedComment.comment_pics == null || paramFeedComment.comment_pics.length == 0) ? FeedProtos.FeedClass.FEED_WORD : FeedProtos.FeedClass.FEED_IMAGE);
  }
  
  public static FeedProtos.SourcePage a(ShareEntity paramShareEntity) {
    return paramShareEntity.k ? c(paramShareEntity.l) : (paramShareEntity.m ? FeedProtos.SourcePage.FEED_PERSONAL_MORE : (paramShareEntity.n ? FeedProtos.SourcePage.SHARE_LIVE : (paramShareEntity.o ? d(paramShareEntity.l) : FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE)));
  }
  
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(FeedProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setImageId(stringBuilder.toString()).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, int paramInt, String paramString1, String paramString2) {
    if (paramEvent != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setTabId(stringBuilder.toString()).setLinkUrl(a(paramString1)).setIconType(a(paramString2)).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.AddType paramAddType, FeedProtos.FeedType paramFeedType) {
    if (paramEvent != null && paramAddType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setAddType(paramAddType).setFeedType(paramFeedType).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.CircleSource paramCircleSource) {
    if (paramEvent != null && paramCircleSource != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleSource(paramCircleSource).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.DetailFrom paramDetailFrom) {
    if (paramEvent != null && paramDetailFrom != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setDetailFrom(paramDetailFrom).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.FeedFrom paramFeedFrom) {
    if (paramEvent != null && paramFeedFrom != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedFrom(paramFeedFrom).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.FeedType paramFeedType, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null && paramFeedType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedType(paramFeedType).setTopicId(a(paramString1)).setMusicId(a(paramString2)).setIsComment(paramBoolean).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.ShareChannel paramShareChannel, FeedProtos.SourcePage paramSourcePage, String paramString) {
    a(paramEvent, paramShareChannel, "", "", "", "", "", paramSourcePage, paramString, false, "", false);
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.ShareChannel paramShareChannel, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, FeedProtos.SourcePage paramSourcePage, String paramString6, boolean paramBoolean1, String paramString7, boolean paramBoolean2) {
    if (paramEvent != null && paramShareChannel != null && paramSourcePage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setShareChannel(paramShareChannel).setTargetUid(a(paramString1)).setTopicId(a(paramString3)).setFeedId(a(paramString2)).setLiveId(a(paramString4)).setCircleId(paramString5).setSourcePage(paramSourcePage).setLinkUrl(a(paramString6)).setIsExposure(paramBoolean1).setRecommendType(a(paramString7)).setIsAnonymousPublish(paramBoolean2).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.SourcePage paramSourcePage, int paramInt) {
    if (paramEvent != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setSourcePage(paramSourcePage);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setId(a(stringBuilder.toString())).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.TabType paramTabType) {
    if (paramEvent != null && paramTabType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTabType(paramTabType).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, FeedProtos.TagSource paramTagSource) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTagSource(paramTagSource).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString, FeedProtos.CircleSource paramCircleSource, boolean paramBoolean, int paramInt) {
    if (paramEvent != null && paramCircleSource != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString)).setCircleSource(paramCircleSource).setIsApply(paramBoolean);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setId(a(stringBuilder.toString())).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString, FeedProtos.CircleSource paramCircleSource, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    if (paramEvent != null && paramCircleSource != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString)).setCircleSource(paramCircleSource).setIsJoin(paramBoolean1).setIsApply(paramBoolean2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setId(a(stringBuilder.toString())).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, FeedProtos.FeedFrom paramFeedFrom, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setFeedFrom(paramFeedFrom).setId(a(paramString2)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, FeedProtos.InteractiveType paramInteractiveType, FeedProtos.Location paramLocation, String paramString2, String paramString3) {
    if (paramEvent != null && paramInteractiveType != null && paramLocation != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setInteractiveType(paramInteractiveType).setLocation(paramLocation).setCommentId(a(paramString2)).setTargetUid(a(paramString3)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString, FeedProtos.Location paramLocation) {
    if (paramEvent != null && paramLocation != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString)).setLocation(paramLocation).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString, FeedProtos.NoteSource paramNoteSource) {
    if (paramEvent != null && paramNoteSource != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setNoteId(a(paramString)).setNoteSource(paramNoteSource).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, FeedProtos.NoteSource paramNoteSource, String paramString2, String paramString3, boolean paramBoolean1, FeedProtos.FeedClass paramFeedClass, FeedProtos.NoteType paramNoteType, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramEvent != null && paramNoteSource != null && paramNoteType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCommentId(a(paramString1)).setNoteSource(paramNoteSource).setNoteId(a(paramString2)).setCircleId(a(paramString3)).setIsAt(paramBoolean1).setFeedClass(paramFeedClass).setNoteType(paramNoteType).setIsAnonymousPublish(paramBoolean2).setIsAnonymousComment(paramBoolean3).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, FeedProtos.NoteSource paramNoteSource, String paramString2, String paramString3, boolean paramBoolean1, FeedProtos.NoteType paramNoteType, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramEvent != null && paramNoteSource != null && paramNoteType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCommentId(a(paramString1)).setNoteSource(paramNoteSource).setNoteId(a(paramString2)).setCircleId(a(paramString3)).setIsAt(paramBoolean1).setNoteType(paramNoteType).setIsAnonymousPublish(paramBoolean2).setIsAnonymousComment(paramBoolean3).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString, FeedProtos.NoteType paramNoteType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setNoteType(paramNoteType).setCircleId(paramString).setIsAnonymousPublish(paramBoolean1).setIsAnonymousComment(paramBoolean2).setIsAt(paramBoolean3).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setLiveId(a(paramString2)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.CircleSource paramCircleSource, boolean paramBoolean, int paramInt) {
    if (paramEvent != null && paramCircleSource != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setCircleSource(paramCircleSource).setIsApply(paramBoolean);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setId(a(stringBuilder.toString())).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.CircleSource paramCircleSource, boolean paramBoolean1, boolean paramBoolean2, FeedProtos.UserType paramUserType, int paramInt) {
    if (paramEvent != null && paramCircleSource != null && paramUserType != null) {
      FeedProtos.FeedProto.Builder builder = FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setCircleSource(paramCircleSource).setIsJoin(paramBoolean1).setIsApply(paramBoolean2).setUserType(paramUserType);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setId(a(stringBuilder.toString())).build());
    } 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.FeedClass paramFeedClass, FeedProtos.FeedPage paramFeedPage, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String paramString5) {
    if (paramEvent != null && paramFeedClass != null && paramFeedPage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTopicId(a(paramString2)).setFeedId(a(paramString1)).setFeedClass(paramFeedClass).setFeedPage(paramFeedPage).setTargetUid(a(paramString3)).setIsExposure(paramBoolean1).setIsMulti(paramBoolean2).setCircleId(a(paramString4)).setLiveId(a(paramString5)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.FeedPage paramFeedPage) {
    if (paramEvent != null && paramFeedPage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setCircleId(a(paramString2)).setFeedPage(paramFeedPage).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.FeedTopicPage paramFeedTopicPage) {
    if (paramEvent != null && paramFeedTopicPage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setTopicId(a(paramString2)).setFeedTopicPage(paramFeedTopicPage).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.NoteSource paramNoteSource) {
    if (paramEvent != null && paramNoteSource != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(paramString1).setNoteId(paramString2).setNoteSource(paramNoteSource).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.NoteSource paramNoteSource, boolean paramBoolean1, FeedProtos.NoteType paramNoteType, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    if (paramEvent != null && paramNoteSource != null && paramNoteType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setNoteSource(paramNoteSource).setIsTop(paramBoolean1).setNoteType(paramNoteType).setNoteFrom(a(paramString3)).setIsAnonymousPublish(paramBoolean2).setIsEssence(paramBoolean3).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.NoteSource paramNoteSource, boolean paramBoolean1, FeedProtos.NoteType paramNoteType, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
    if (paramEvent != null && paramNoteSource != null && paramNoteType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setNoteSource(paramNoteSource).setIsTop(paramBoolean1).setNoteType(paramNoteType).setIsJoin(paramBoolean2).setIsApply(paramBoolean3).setIsAnonymousPublish(paramBoolean4).setIsEssence(paramBoolean5).setIsAt(paramBoolean6).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.SourcePage paramSourcePage) {
    if (paramEvent != null && paramSourcePage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setTargetUid(a(paramString2)).setSourcePage(paramSourcePage).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.SourcePage paramSourcePage, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setTargetUid(a(paramString2)).setSourcePage(paramSourcePage).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.SourcePage paramSourcePage, String paramString3, boolean paramBoolean, String paramString4) {
    if (paramEvent != null && paramSourcePage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setTopicId(a(paramString2)).setSourcePage(paramSourcePage).setTargetUid(a(paramString3)).setIsExposure(paramBoolean).setRecommendType(a(paramString4)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, FeedProtos.UserType paramUserType) {
    if (paramEvent != null && paramUserType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setTargetUid(a(paramString2)).setUserType(paramUserType).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString2)).setFeedId(a(paramString1)).setCommentId(a(paramString3)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, FeedProtos.FollowLocation paramFollowLocation, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramEvent != null && paramFollowLocation != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setTopicId(a(paramString3)).setFeedId(a(paramString2)).setFollowLocation(paramFollowLocation).setIsFollow(paramBoolean1).setIsLive(paramBoolean2).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, FeedProtos.FollowLocation paramFollowLocation, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramEvent != null && paramFollowLocation != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setTopicId(a(paramString3)).setFeedId(a(paramString2)).setFollowLocation(paramFollowLocation).setIsFollow(paramBoolean1).setIsLive(paramBoolean2).setIsExposure(paramBoolean3).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, FeedProtos.OptType paramOptType, FeedProtos.NoteType paramNoteType, boolean paramBoolean) {
    if (paramEvent != null && paramOptType != null && paramNoteType != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setTargetUid(a(paramString3)).setOptType(paramOptType).setNoteType(paramNoteType).setIsAnonymousPublish(paramBoolean).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, FeedProtos.SourcePage paramSourcePage) {
    if (paramEvent != null && paramSourcePage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setTopicId(a(paramString2)).setLiveId(a(paramString3)).setSourcePage(paramSourcePage).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString2)).setNoteId(a(paramString3)).setTargetUid(a(paramString4)).setCommentId(a(paramString1)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString2)).setNoteId(a(paramString3)).setTargetUid(a(paramString4)).setCommentId(a(paramString1)).setIsAnonymousComment(paramBoolean).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, FeedProtos.FeedClass paramFeedClass, FeedProtos.NoteType paramNoteType, boolean paramBoolean2, boolean paramBoolean3, FeedProtos.NoteSource paramNoteSource) {
    if (paramEvent != null && paramFeedClass != null && paramNoteType != null && paramNoteSource != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setCommentId(a(paramString3)).setIsAt(paramBoolean1).setFeedClass(paramFeedClass).setNoteType(paramNoteType).setIsAnonymousPublish(paramBoolean2).setIsAnonymousComment(paramBoolean3).setNoteSource(paramNoteSource).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, FeedProtos.FeedClass paramFeedClass, FeedProtos.NoteType paramNoteType, boolean paramBoolean3, boolean paramBoolean4, FeedProtos.NoteSource paramNoteSource) {
    if (paramEvent != null && paramFeedClass != null && paramNoteType != null && paramNoteSource != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).setCommentId(a(paramString3)).setIsLike(paramBoolean1).setIsAt(paramBoolean2).setFeedClass(paramFeedClass).setNoteType(paramNoteType).setIsAnonymousPublish(paramBoolean3).setIsAnonymousComment(paramBoolean4).setNoteSource(paramNoteSource).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setTargetUid(a(paramString2)).setIsInvite(paramBoolean).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString1, String paramString2, boolean paramBoolean1, FeedProtos.SourcePage paramSourcePage, String paramString3, boolean paramBoolean2, String paramString4) {
    if (paramEvent != null && paramSourcePage != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTopicId(a(paramString2)).setFeedId(a(paramString1)).setIsLike(paramBoolean1).setSourcePage(paramSourcePage).setTargetUid(a(paramString3)).setIsExposure(paramBoolean2).setRecommendType(a(paramString4)).build()); 
  }
  
  public static void a(FeedProtos.Event paramEvent, String paramString, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setLinkUrl(a(paramString)).build()); 
  }
  
  public static FeedProtos.FeedPage b(int paramInt) {
    FeedProtos.FeedPage feedPage = FeedProtos.FeedPage.UNKNOWN_FEED_PAGE;
    switch (paramInt) {
      default:
        return FeedProtos.FeedPage.UNKNOWN_FEED_PAGE;
      case 12:
        return FeedProtos.FeedPage.FEED_LIKE;
      case 11:
        return FeedProtos.FeedPage.FEED_MINE;
      case 10:
        return FeedProtos.FeedPage.PLAZA_IMAGE;
      case 9:
        return FeedProtos.FeedPage.PERSONAL_PHOTO;
      case 8:
        return FeedProtos.FeedPage.FLASH_DETAIL;
      case 6:
        return FeedProtos.FeedPage.PLAZA_RECOMMEND;
      case 5:
        return FeedProtos.FeedPage.SUPER_TOPIC_FEED;
      case 4:
        return FeedProtos.FeedPage.PLAZA_NEARBY;
      case 2:
      case 14:
        return FeedProtos.FeedPage.FEED_DETAIL_MORE;
      case 1:
        return FeedProtos.FeedPage.PERSONAL_FEED;
      case 0:
        break;
    } 
    return FeedProtos.FeedPage.PLAZA_FOLLOW;
  }
  
  public static FeedProtos.NoteType b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed != null) {
      if (paramBluedIngSelfFeed.is_posts_vote == 1)
        return FeedProtos.NoteType.VOTE_TEXT; 
      if (paramBluedIngSelfFeed.is_markdown == 1)
        return FeedProtos.NoteType.NOTE_MIX; 
      if (paramBluedIngSelfFeed.is_video_posts == 1)
        return FeedProtos.NoteType.NOTE_VIDEO; 
    } 
    return FeedProtos.NoteType.NOTE_COMMON;
  }
  
  public static void b(FeedProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void b(FeedProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setLinkUrl(a(paramString)).build()); 
  }
  
  public static void b(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString1)).setTargetUid(a(paramString2)).build()); 
  }
  
  public static void b(FeedProtos.Event paramEvent, String paramString, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString)).setIsLive(paramBoolean).build()); 
  }
  
  public static FeedProtos.SourcePage c(int paramInt) {
    switch (paramInt) {
      default:
        return FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
      case 14:
        return FeedProtos.SourcePage.PAGE_FEED_DETAIL_MORE;
      case 12:
        return FeedProtos.SourcePage.PAGE_FEED_LIKE;
      case 11:
        return FeedProtos.SourcePage.PAGE_FEED_MINE;
      case 10:
        return FeedProtos.SourcePage.FEED_PLAZA_IMAGE;
      case 8:
        return FeedProtos.SourcePage.FEED_PLAZA_FLASH;
      case 6:
        return FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND;
      case 5:
        return FeedProtos.SourcePage.FEED_SUPER_TOPIC_FEED;
      case 4:
        return FeedProtos.SourcePage.FEED_PLAZA_NEARBY;
      case 2:
        return FeedProtos.SourcePage.FEED_DETAIL_PAGE;
      case 1:
        return FeedProtos.SourcePage.FEED_PERSONAL_FEED;
      case 0:
        break;
    } 
    return FeedProtos.SourcePage.FEED_PLAZA_FOLLOW;
  }
  
  public static void c(FeedProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString)).build()); 
  }
  
  public static void c(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setLiveId(a(paramString1)).setTargetUid(a(paramString2)).build()); 
  }
  
  public static FeedProtos.SourcePage d(int paramInt) {
    return (paramInt != 4) ? ((paramInt != 6) ? ((paramInt != 15) ? FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE : FeedProtos.SourcePage.NOTE_DETAIL_SHARE) : FeedProtos.SourcePage.PLAZA_RECOMMEND_NOTE_SHARE) : FeedProtos.SourcePage.CITY_NOTE_PAGE;
  }
  
  public static void d(FeedProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTopicId(a(paramString)).build()); 
  }
  
  public static void d(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setLiveId(a(paramString2)).setTargetUid(a(paramString1)).build()); 
  }
  
  public static FeedProtos.SourcePage e(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 4) ? ((paramInt != 5) ? ((paramInt != 6) ? ((paramInt != 8) ? ((paramInt != 10) ? c(paramInt) : FeedProtos.SourcePage.FEED_PLAZA_IMAGE_DETAIL) : FeedProtos.SourcePage.FEED_PLAZA_FLASH_DETAIL) : FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND_DETAIL) : FeedProtos.SourcePage.FEED_SUPER_TOPIC_FEED_DETAIL) : FeedProtos.SourcePage.FEED_PLAZA_NEARBY_DETAIL) : FeedProtos.SourcePage.FEED_PERSONAL_FEED_DETAIL) : FeedProtos.SourcePage.FEED_PLAZA_FOLLOW_DETAIL;
  }
  
  public static void e(FeedProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setKeyword(a(paramString)).build()); 
  }
  
  public static void e(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setTargetUid(a(paramString2)).build()); 
  }
  
  public static FeedProtos.UserType f(int paramInt) {
    FeedProtos.UserType userType = FeedProtos.UserType.UNKNOWN_USER_TYPE;
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? userType : FeedProtos.UserType.CIRCLE_NOT_MEMBER) : FeedProtos.UserType.VICE_CAPTAIN) : FeedProtos.UserType.CIRCLE_CAPTAIN) : FeedProtos.UserType.COMMON_USER;
  }
  
  public static void f(FeedProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString)).build()); 
  }
  
  public static void f(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).build()); 
  }
  
  public static FeedProtos.NoteSource g(int paramInt) {
    FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE;
    return (paramInt != 1) ? ((paramInt != 4) ? ((paramInt != 6) ? noteSource : FeedProtos.NoteSource.CIRCLE_RECOMMEND_LIST) : FeedProtos.NoteSource.CITY_NOTE) : FeedProtos.NoteSource.PERSONAL_PROFILE;
  }
  
  public static void g(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setTargetUid(a(paramString2)).build()); 
  }
  
  public static FeedProtos.CircleSource h(int paramInt) {
    FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
    return (paramInt != 1) ? ((paramInt != 4) ? ((paramInt != 6) ? circleSource : FeedProtos.CircleSource.PLAZA_RECOMMEND_NOTE) : FeedProtos.CircleSource.CITY_NOTE_CIRCLE) : FeedProtos.CircleSource.PERSONAL_PROFILE_CIRCLE;
  }
  
  public static void h(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setTaskId(a(paramString1)).setLinkUrl(a(paramString2)).build()); 
  }
  
  private static FeedProtos.CircleSource i(int paramInt) {
    FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.UNKNOWN_CIRCLE_SOURCE;
    return (paramInt != 1) ? circleSource : FeedProtos.CircleSource.CIRCLE_HOT_POST;
  }
  
  public static void i(FeedProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeedProtos.FeedProto.newBuilder().setEvent(paramEvent).setCircleId(a(paramString1)).setNoteId(a(paramString2)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
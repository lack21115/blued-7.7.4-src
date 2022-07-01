package com.soft.blued.ui.feed.model;

import android.content.Context;
import android.text.TextUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.video.model.VideoScanMusic;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BluedIngSelfFeed extends BluedADExtra implements MultiItemEntity, Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  public int a_vote_count;
  
  public int admin_level;
  
  public int age;
  
  public int allow_comments;
  
  public int allow_join;
  
  public int anchor_admin_level;
  
  public String anonym_avatar;
  
  public int anonym_comment;
  
  public int b_vote_count;
  
  public int can_promotion;
  
  public int circle_active_posting;
  
  public int circle_active_shared_posting;
  
  public String circle_id;
  
  public String circle_title;
  
  public int circle_uid;
  
  public int classify_id;
  
  public List<FeedComment> comments;
  
  public String cover;
  
  public int dataType;
  
  public boolean date_visible;
  
  public int disallow_share;
  
  public String distance;
  
  public double duration;
  
  public String[] face_point;
  
  public transient FeedParse feedParse;
  
  public int feed_comment;
  
  public String feed_content;
  
  public String feed_date;
  
  public int feed_dig;
  
  public FeedExtra feed_extras;
  
  public String feed_format_timestamp;
  
  public String feed_id;
  
  public int feed_is_delete;
  
  public String feed_month;
  
  public String feed_origin_content;
  
  public String feed_phone;
  
  public String[] feed_pics;
  
  public String[] feed_pics_height;
  
  public String[] feed_pics_width;
  
  public String feed_pure_content;
  
  public long feed_show;
  
  public String feed_status;
  
  public String feed_time;
  
  public String feed_timestamp;
  
  public int feed_type = -1;
  
  public String feed_uid;
  
  public String feed_video_size;
  
  public String[] feed_videos;
  
  public double feed_videos_duration;
  
  public String[] feed_videos_height;
  
  public String[] feed_videos_width;
  
  public int feed_views;
  
  public String feed_year;
  
  public boolean forceShowFollowedStatus;
  
  public String hash_id;
  
  public String head;
  
  public int height;
  
  public List<FeedComment> hot_comments;
  
  public int hot_comments_more;
  
  public int iliked;
  
  public ImageMogr imagemogr2_long_pic;
  
  public int in_promotion;
  
  public boolean isPlayLikeAnim;
  
  public int is_anonym;
  
  public int is_applied;
  
  public int is_disclosure;
  
  public int is_essence;
  
  public int is_followed = 0;
  
  public int is_hide_distance;
  
  public int is_hide_vip_look;
  
  public int is_join_circle;
  
  public int is_live_data;
  
  public int is_markdown;
  
  public int is_muted;
  
  public int is_posts_vote;
  
  public int is_recommend;
  
  public int is_recommend_ticktocks;
  
  public int is_repost;
  
  public int is_share_circle;
  
  public int is_share_posting;
  
  public int is_share_super_topics;
  
  public int is_show_vip_page;
  
  public int is_super_topics;
  
  public int is_top;
  
  public int is_url;
  
  public int is_video_posts;
  
  public String is_videos;
  
  public int is_vip_annual;
  
  public int is_vote;
  
  public int ivoted;
  
  public String join_circle_description;
  
  public int join_circle_id;
  
  public String join_circle_pic;
  
  public String join_circle_title;
  
  public String last_comment_time;
  
  public String lid;
  
  public int link_type;
  
  public int live;
  
  public String location;
  
  public String location_lat;
  
  public String location_lot;
  
  public int members_num;
  
  public VideoScanMusic music;
  
  public int must_anonym_reply;
  
  public String note;
  
  public String note_from;
  
  public boolean oldest_feed;
  
  public int online_state;
  
  public List<CircleTextVote> option_count;
  
  public int pk;
  
  public int point_state;
  
  public int posting_allow_delete;
  
  public String posts_vote_title;
  
  public String promotion_bubble;
  
  public int promotion_bubble_type;
  
  public int promotion_status;
  
  public String promotion_url;
  
  public String promotion_url_option;
  
  public int reading_scope;
  
  public String realtime_count;
  
  public String recommend_text;
  
  public String relationship;
  
  public BluedIngSelfFeed repost;
  
  public int repost_also_comment;
  
  public int repost_count;
  
  public String score;
  
  public String share_circle_posting_content;
  
  public String share_circle_posting_id;
  
  public String share_circle_posting_pic;
  
  public String share_circle_title;
  
  public String share_s_t_avatar;
  
  public String share_s_t_des;
  
  public String share_s_t_did;
  
  public String share_s_t_name;
  
  public String super_did;
  
  public String super_topics_name;
  
  public int super_topics_status;
  
  public int theme_id;
  
  public int theme_pendant;
  
  public String uid;
  
  public String user_avatar;
  
  public String user_name;
  
  public int vbadge;
  
  public int vip_exp_lvl;
  
  public int vip_grade;
  
  public int vote_count;
  
  public int weight;
  
  public BluedIngSelfFeed() {}
  
  public BluedIngSelfFeed(String paramString) {
    this.feed_id = paramString;
  }
  
  public Object clone() {
    try {
      BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      cloneNotSupportedException.printStackTrace();
      cloneNotSupportedException = null;
    } 
    ((BluedIngSelfFeed)cloneNotSupportedException).feed_type = -1;
    return cloneNotSupportedException;
  }
  
  public BluedIngSelfFeed getContentData() {
    return isRepost() ? this.repost : this;
  }
  
  public FeedParse getFeedParse(Context paramContext, int paramInt) {
    if (this.feedParse == null)
      this.feedParse = new FeedParse(paramContext, this, paramInt); 
    return this.feedParse;
  }
  
  public String getImageMogr(boolean paramBoolean) {
    return getImageMogr(paramBoolean, 0);
  }
  
  public String getImageMogr(boolean paramBoolean, int paramInt) {
    ImageMogr imageMogr = this.imagemogr2_long_pic;
    if (imageMogr != null)
      if (paramBoolean) {
        if (imageMogr.multiple != null && this.imagemogr2_long_pic.multiple.length > paramInt && !TextUtils.isEmpty(this.imagemogr2_long_pic.multiple[paramInt]))
          return this.imagemogr2_long_pic.multiple[paramInt]; 
      } else if (!TextUtils.isEmpty(imageMogr.single)) {
        return this.imagemogr2_long_pic.single;
      }  
    return "";
  }
  
  public int getItemType() {
    int i = this.feed_type;
    if (i != -1)
      return i; 
    i = this.dataType;
    if (i == 4) {
      this.feed_type = 9;
      return this.feed_type;
    } 
    if (i == 5) {
      this.feed_type = 14;
      return this.feed_type;
    } 
    if (i == 3) {
      this.feed_type = 6;
      return this.feed_type;
    } 
    if (this.is_live_data == 1) {
      this.feed_type = 16;
      return this.feed_type;
    } 
    if (this.is_vote == 1) {
      this.feed_type = 8;
      return this.feed_type;
    } 
    if ((getContentData()).is_url == 1 && (getContentData()).feed_extras != null) {
      this.feed_type = 4;
      return this.feed_type;
    } 
    if ("1".equals((getContentData()).is_videos)) {
      this.feed_type = 3;
      return this.feed_type;
    } 
    if (this.is_share_super_topics == 1 || (isRepost() && this.repost.is_share_super_topics == 1)) {
      this.feed_type = 10;
      return this.feed_type;
    } 
    if (this.is_share_posting == 1 || (isRepost() && this.repost.is_share_posting == 1)) {
      this.feed_type = 15;
      return this.feed_type;
    } 
    if (this.is_join_circle == 1 || (isRepost() && this.repost.is_join_circle == 1)) {
      this.feed_type = 17;
      return this.feed_type;
    } 
    if ((getContentData()).feed_pics != null && (getContentData()).feed_pics.length > 0) {
      if ((getContentData()).feed_pics.length == 1) {
        if ((getContentData()).is_ads == 1) {
          this.feed_type = 5;
        } else {
          this.feed_type = 0;
        } 
        return this.feed_type;
      } 
      if ((getContentData()).feed_pics.length == 2 || (getContentData()).feed_pics.length == 4) {
        this.feed_type = 1;
        return this.feed_type;
      } 
      this.feed_type = 2;
      return this.feed_type;
    } 
    this.feed_type = 0;
    return this.feed_type;
  }
  
  public CircleJoinState getJoinState() {
    return new CircleJoinState(this.circle_id, this.circle_title, this.cover, this.admin_level, this.allow_join, this.is_applied);
  }
  
  public boolean isCirclePost() {
    return (this.dataType <= 1 && CircleMethods.isCircle(this));
  }
  
  public boolean isFeed() {
    return (this.dataType <= 1);
  }
  
  public boolean isJoin() {
    return (this.admin_level != 3);
  }
  
  public boolean isManager() {
    return (this.admin_level == 2);
  }
  
  public boolean isMember() {
    return (this.admin_level == 0);
  }
  
  public boolean isNotMember() {
    return (this.admin_level == 3);
  }
  
  public boolean isOwner() {
    return (this.admin_level == 1);
  }
  
  public boolean isPrivateCircle() {
    return (this.allow_join == 0 && this.is_disclosure == 0);
  }
  
  public boolean isRepost() {
    return (this.is_repost == 1 && this.repost != null);
  }
  
  public void setExitJoin() {
    this.admin_level = 3;
  }
  
  public void setJoin() {
    this.admin_level = 0;
  }
  
  public void setJoinState(CircleJoinState paramCircleJoinState) {
    if (paramCircleJoinState != null && !TextUtils.isEmpty(this.circle_id) && this.circle_id.equals(paramCircleJoinState.circle_id)) {
      this.admin_level = paramCircleJoinState.admin_level;
      this.allow_join = paramCircleJoinState.allow_join;
      this.is_applied = paramCircleJoinState.is_applied;
    } 
  }
  
  public void setManager() {
    this.admin_level = 2;
  }
  
  public void setMember() {
    this.admin_level = 0;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BluedIngSelfFeed{feed_id='");
    stringBuilder.append(this.feed_id);
    stringBuilder.append('\'');
    stringBuilder.append(", feed_uid='");
    stringBuilder.append(this.feed_uid);
    stringBuilder.append('\'');
    stringBuilder.append(", feed_status='");
    stringBuilder.append(this.feed_status);
    stringBuilder.append('\'');
    stringBuilder.append(", feed_content='");
    stringBuilder.append(this.feed_content);
    stringBuilder.append('\'');
    stringBuilder.append(", feed_pics=");
    stringBuilder.append(Arrays.toString((Object[])this.feed_pics));
    stringBuilder.append(", imagemogr2_long_pic=");
    stringBuilder.append(this.imagemogr2_long_pic);
    stringBuilder.append(", feed_comment=");
    stringBuilder.append(this.feed_comment);
    stringBuilder.append(", user_name='");
    stringBuilder.append(this.user_name);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\BluedIngSelfFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
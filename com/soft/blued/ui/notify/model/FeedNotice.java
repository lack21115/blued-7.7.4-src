package com.soft.blued.ui.notify.model;

import android.text.TextUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.find.model.UserBasicModel;

public class FeedNotice extends UserBasicModel implements MultiItemEntity {
  public int admin_level;
  
  public int allow_join;
  
  public String circle_id;
  
  public String circle_title;
  
  public int comment_deleted;
  
  public String comment_id;
  
  public String content;
  
  public String cover;
  
  public String feed_content;
  
  public String feed_id;
  
  public String[] feed_pics;
  
  public String[] feed_pics_height;
  
  public String[] feed_pics_width;
  
  public String[] feed_videos;
  
  public String format_timestamp;
  
  public int from;
  
  public int from_top;
  
  public int has_read;
  
  public int id;
  
  public int is_anonym;
  
  public int is_applied;
  
  public int is_comments_liked;
  
  public int is_posts_vote;
  
  public String is_videos;
  
  public int must_anonym_reply;
  
  public long notification_id;
  
  public String time;
  
  public String timestamp;
  
  public String type;
  
  public int getItemType() {
    if (TextUtils.isEmpty(this.type))
      return 0; 
    String str = this.type;
    byte b = -1;
    int i = str.hashCode();
    if (i != 55) {
      if (i != 56) {
        if (i == 1567 && str.equals("10"))
          b = 2; 
      } else if (str.equals("8")) {
        b = 1;
      } 
    } else if (str.equals("7")) {
      b = 0;
    } 
    return (b != 0 && b != 1 && b != 2) ? 0 : 1;
  }
  
  public CircleJoinState getJoinState() {
    return new CircleJoinState(this.circle_id, this.circle_title, this.cover, this.admin_level, this.allow_join, this.is_applied);
  }
  
  public void setJoinState(CircleJoinState paramCircleJoinState) {
    if (paramCircleJoinState != null && !TextUtils.isEmpty(this.circle_id) && this.circle_id.equals(paramCircleJoinState.circle_id)) {
      this.admin_level = paramCircleJoinState.admin_level;
      this.allow_join = paramCircleJoinState.allow_join;
      this.is_applied = paramCircleJoinState.is_applied;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\model\FeedNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
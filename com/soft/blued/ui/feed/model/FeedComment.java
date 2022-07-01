package com.soft.blued.ui.feed.model;

import com.soft.blued.ui.find.model.UserBasicModel;
import java.io.Serializable;
import java.util.List;

public class FeedComment extends UserBasicModel implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public int admin_level;
  
  public int anchor_point;
  
  public int circle_active_comment;
  
  public String circle_id;
  
  public String comment_allow_delete;
  
  public String comment_content;
  
  public String comment_format_timestamp;
  
  public String comment_id;
  
  public String[] comment_pics;
  
  public String[] comment_pics_height;
  
  public String[] comment_pics_width;
  
  public String comment_status;
  
  public String comment_time;
  
  public String comment_timestamp;
  
  public String comment_uid;
  
  public List<FeedComment> comments;
  
  public int comments_count;
  
  public String feed_id;
  
  public String feed_uid;
  
  public int iliked = 0;
  
  public boolean isHasMoreHotComment = false;
  
  public boolean isLastHotComment = false;
  
  public int is_anonym;
  
  public int is_author;
  
  public int is_muted;
  
  public String is_reply;
  
  public int liked_count = 0;
  
  public String reply_avatar;
  
  public String reply_name;
  
  public String reply_uid;
  
  public int repost_also_comment;
  
  public int user_allow_mute;
  
  public String user_avatar;
  
  public String user_name;
  
  public int user_vbadge;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\FeedComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
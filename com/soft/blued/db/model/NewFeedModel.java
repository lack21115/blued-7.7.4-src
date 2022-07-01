package com.soft.blued.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;

@DatabaseTable(tableName = "NewFeedModel")
public class NewFeedModel implements Serializable {
  public static final int FORWARD_HEADER = 0;
  
  public static final int FORWARD_IMAGE = 1;
  
  @DatabaseField
  public String address;
  
  @DatabaseField
  public int allow_comments;
  
  @DatabaseField
  public int anonym_avatar;
  
  @DatabaseField
  public int anonym_comment;
  
  @DatabaseField
  public String circle_header;
  
  @DatabaseField
  public String circle_id;
  
  @DatabaseField
  public String circle_title;
  
  @DatabaseField
  private String content;
  
  @DatabaseField
  public float duration;
  
  @DatabaseField
  public String extraJSON;
  
  @DatabaseField
  public String feed_id;
  
  @DatabaseField
  public String forwardContent;
  
  @DatabaseField
  public String forwardImage;
  
  @DatabaseField
  public String forwardName;
  
  @DatabaseField
  public String frames_data;
  
  @DatabaseField(columnName = "id", generatedId = true)
  private int id;
  
  @DatabaseField
  public int isForwardHeader;
  
  public boolean isResend = false;
  
  @DatabaseField
  public int isVideo;
  
  @DatabaseField
  public int is_ads;
  
  @DatabaseField
  public int is_anonym;
  
  @DatabaseField
  public int is_attention_show_dot;
  
  @DatabaseField
  public int is_circle_comment;
  
  @DatabaseField
  public int is_join_circle;
  
  @DatabaseField
  public int is_posts_vote;
  
  @DatabaseField
  public int is_repost;
  
  @DatabaseField
  public int is_share_super_topics;
  
  @DatabaseField
  public int is_super_topics;
  
  @DatabaseField
  public int is_url;
  
  @DatabaseField
  public int is_vote;
  
  @DatabaseField
  public int join_circle_id;
  
  @DatabaseField
  public String join_circle_title;
  
  @DatabaseField
  private String lat;
  
  @DatabaseField
  private String lng;
  
  @DatabaseField(index = true)
  private long loadName;
  
  @DatabaseField
  public String localPath;
  
  @DatabaseField
  public String localVideoPath;
  
  @DatabaseField
  public String music_id;
  
  @DatabaseField
  public String option;
  
  @DatabaseField
  private String pics;
  
  @DatabaseField
  public String posts_vote_title;
  
  @DatabaseField
  private int progress;
  
  @DatabaseField
  public int reading_scope;
  
  @DatabaseField
  public int repost_also_comment;
  
  @DatabaseField
  public String share_posting_id;
  
  @DatabaseField
  public String share_s_t_did;
  
  @DatabaseField
  private int size;
  
  @DatabaseField
  private int state;
  
  @DatabaseField
  public String super_did;
  
  @DatabaseField
  public String super_topics_avatar;
  
  @DatabaseField
  public String super_topics_name;
  
  @DatabaseField
  private long time;
  
  @DatabaseField
  public String videoPath;
  
  @DatabaseField
  public long videoSize;
  
  @DatabaseField
  public String videoTaskID;
  
  public String getContent() {
    return this.content;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getLat() {
    return this.lat;
  }
  
  public String getLng() {
    return this.lng;
  }
  
  public long getLoadName() {
    return this.loadName;
  }
  
  public String getPics() {
    return this.pics;
  }
  
  public int getProgress() {
    return this.progress;
  }
  
  public int getRepostAlsoComment() {
    return this.repost_also_comment;
  }
  
  public int getSize() {
    return this.size;
  }
  
  public int getState() {
    return this.state;
  }
  
  public long getTime() {
    return this.time;
  }
  
  public long getVideoSize() {
    return this.videoSize;
  }
  
  public void setContent(String paramString) {
    this.content = paramString;
  }
  
  public void setId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setIsJoinCircle(int paramInt) {
    this.is_join_circle = paramInt;
  }
  
  public void setJoinCircleId(int paramInt) {
    this.join_circle_id = paramInt;
  }
  
  public void setJoinCircleTitle(String paramString) {
    this.join_circle_title = paramString;
  }
  
  public void setLat(String paramString) {
    this.lat = paramString;
  }
  
  public void setLng(String paramString) {
    this.lng = paramString;
  }
  
  public void setLoadName(long paramLong) {
    this.loadName = paramLong;
  }
  
  public void setPics(String paramString) {
    this.pics = paramString;
  }
  
  public void setProgress(int paramInt) {
    this.progress = paramInt;
  }
  
  public void setRepostAlsoComment(int paramInt) {
    this.repost_also_comment = paramInt;
  }
  
  public void setSize(int paramInt) {
    this.size = paramInt;
  }
  
  public void setState(int paramInt) {
    this.state = paramInt;
  }
  
  public void setTime(long paramLong) {
    this.time = paramLong;
  }
  
  public void setVideoSize(long paramLong) {
    this.videoSize = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\model\NewFeedModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
package com.soft.blued.ui.circle.model;

public class CircleConstants {
  public static @interface AdminLevel {
    public static final int LEVEL_MANAGER = 2;
    
    public static final int LEVEL_MEMBER = 0;
    
    public static final int LEVEL_NONE = 3;
    
    public static final int LEVEL_OWNER = 1;
  }
  
  public static @interface ApplyState {
    public static final int APPLIED = 1;
    
    public static final int DENIED = 2;
    
    public static final int NONE = 0;
  }
  
  public enum CIRCLE_FROM_PAGE {
    CIRCLE_HOME_RECOMMEND, CIRCLE_MORE_LIST, CIRCLE_NOTIFY, CIRCLE_POST_DETAILS, CITY_JOIN_CIRCLE_FEED, EXPLORE_MORE, FEED_DETAIL_JOIN_CIRCLE_FEED, FEED_LIST_ADAPTER, FEED_PLAZA_RECOMMEND_MORE, FIND_CIRCLE_DISCUSS_LIST, FIND_CIRCLE_MINE, GROUP, HOME_RECOMMEND_CIRCLE, HOT_CIRCLE, JOINED_CIRCLE, LINK, MANAGED_CIRCLE, MINE_CIRCLE, RECOMMEND_CIRCLE, RECOMMEND_JOIN_CIRCLE_FEED, USER_INFO_JOIN_CIRCLE_FEED;
    
    static {
      HOT_CIRCLE = new CIRCLE_FROM_PAGE("HOT_CIRCLE", 4);
      CIRCLE_POST_DETAILS = new CIRCLE_FROM_PAGE("CIRCLE_POST_DETAILS", 5);
      FIND_CIRCLE_DISCUSS_LIST = new CIRCLE_FROM_PAGE("FIND_CIRCLE_DISCUSS_LIST", 6);
      FIND_CIRCLE_MINE = new CIRCLE_FROM_PAGE("FIND_CIRCLE_MINE", 7);
      FEED_LIST_ADAPTER = new CIRCLE_FROM_PAGE("FEED_LIST_ADAPTER", 8);
      LINK = new CIRCLE_FROM_PAGE("LINK", 9);
      HOME_RECOMMEND_CIRCLE = new CIRCLE_FROM_PAGE("HOME_RECOMMEND_CIRCLE", 10);
      CIRCLE_NOTIFY = new CIRCLE_FROM_PAGE("CIRCLE_NOTIFY", 11);
      CITY_JOIN_CIRCLE_FEED = new CIRCLE_FROM_PAGE("CITY_JOIN_CIRCLE_FEED", 12);
      RECOMMEND_JOIN_CIRCLE_FEED = new CIRCLE_FROM_PAGE("RECOMMEND_JOIN_CIRCLE_FEED", 13);
      FEED_DETAIL_JOIN_CIRCLE_FEED = new CIRCLE_FROM_PAGE("FEED_DETAIL_JOIN_CIRCLE_FEED", 14);
      USER_INFO_JOIN_CIRCLE_FEED = new CIRCLE_FROM_PAGE("USER_INFO_JOIN_CIRCLE_FEED", 15);
      GROUP = new CIRCLE_FROM_PAGE("GROUP", 16);
      MINE_CIRCLE = new CIRCLE_FROM_PAGE("MINE_CIRCLE", 17);
      FEED_PLAZA_RECOMMEND_MORE = new CIRCLE_FROM_PAGE("FEED_PLAZA_RECOMMEND_MORE", 18);
      CIRCLE_HOME_RECOMMEND = new CIRCLE_FROM_PAGE("CIRCLE_HOME_RECOMMEND", 19);
      CIRCLE_MORE_LIST = new CIRCLE_FROM_PAGE("CIRCLE_MORE_LIST", 20);
      $VALUES = new CIRCLE_FROM_PAGE[] { 
          JOINED_CIRCLE, MANAGED_CIRCLE, EXPLORE_MORE, RECOMMEND_CIRCLE, HOT_CIRCLE, CIRCLE_POST_DETAILS, FIND_CIRCLE_DISCUSS_LIST, FIND_CIRCLE_MINE, FEED_LIST_ADAPTER, LINK, 
          HOME_RECOMMEND_CIRCLE, CIRCLE_NOTIFY, CITY_JOIN_CIRCLE_FEED, RECOMMEND_JOIN_CIRCLE_FEED, FEED_DETAIL_JOIN_CIRCLE_FEED, USER_INFO_JOIN_CIRCLE_FEED, GROUP, MINE_CIRCLE, FEED_PLAZA_RECOMMEND_MORE, CIRCLE_HOME_RECOMMEND, 
          CIRCLE_MORE_LIST };
    }
  }
  
  public static interface CIRCLE_LIST_DATA_TYPE {
    public static final String CIRCLE_ADMIN_COUNT = "CIRCLE_ADMIN_COUNT";
    
    public static final String CIRCLE_DATA_LIST = "CIRCLE_DATA_LIST";
  }
  
  public static @interface CircleTab {
    public static final int ESSENCE = 2;
    
    public static final int HOT = 1;
    
    public static final int NEW = 0;
  }
  
  public static @interface CommentState {
    public static final int ANONYMOUS = 1;
    
    public static final int EVERY = 0;
    
    public static final int REAL = 2;
  }
  
  public static interface DataKey {
    public static final String ADMIN_LEVEL = "admin_level";
    
    public static final String ANONYMOUS_HEADER_NUMBER = "anonymous_header_number";
    
    public static final String ANONYMOUS_HEADER_URL = "anonymous_header_url";
    
    public static final String CIRCLE_BUBBLE = "circle_bubble";
    
    public static final String CIRCLE_CLASSIFY_ID = "circle_classify_id";
    
    public static final String CIRCLE_DATA = "circle_data";
    
    public static final String CIRCLE_DETAILS_TAB = "circle_details_tab";
    
    public static final String CIRCLE_FROM_PAGE = "circle_from_page";
    
    public static final String CIRCLE_HEADER = "circle_header";
    
    public static final String CIRCLE_ID = "circle_id";
    
    public static final String CIRCLE_LIST_PAGE = "circle_list_page";
    
    public static final String CIRCLE_NAME = "circle_name";
    
    public static final String CIRCLE_NEW_LIST_FROM_PAGE = "circle_new_list_from_page";
    
    public static final String CIRCLE_VOTE_CONTENT = "circle_vote_content";
    
    public static final String CIRCLE_VOTE_TITLE = "circle_vote_title";
    
    public static final String COMMENT_CONTENT = "comment_content";
    
    public static final String COMMENT_ID = "comment_id";
    
    public static final String COMMENT_STATE = "comment_state";
    
    public static final String FEED_DATA = "feed_data";
    
    public static final String FEED_FROM = "feed_from";
    
    public static final String FEED_ID = "feed_id";
    
    public static final String H5_FROM = "h5_from";
    
    public static final String IS_ANONYMOUS = "is_anonymous";
    
    public static final String IS_CAN_ANONYMOUS = "is_can_anonymous";
    
    public static final String IS_CAN_CHANGE_ANONYMOUS = "is_can_change_anonymous";
    
    public static final String NOTIFY_FROM = "notify_from";
    
    public static final String TO_WEB_VIEW = "to_web_view";
  }
  
  public static interface EventBus {
    public static final String CIRCLE_DELETE_FEED = "circle_delete_feed";
    
    public static final String CIRCLE_INFO_MODIFY = "circle_info_modify";
    
    public static final String CIRCLE_JOIN_STATE = "circle_join_state";
  }
  
  public static @interface SetUpMember {
    public static final int APPOINT_MANAGER = 1;
    
    public static final int RELIEVE_MANAGER = 2;
    
    public static final int REMOVE_MEMBER = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\CircleConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
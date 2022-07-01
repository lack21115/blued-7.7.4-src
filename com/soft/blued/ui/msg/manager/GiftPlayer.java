package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import android.view.ViewStub;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.soft.blued.db.ChattingDao;
import com.soft.blued.db.model.ChattingModelDB;
import com.soft.blued.ui.msg.customview.GiftPlayView;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;
import java.sql.SQLException;
import java.util.List;

public class GiftPlayer {
  public static final String a = GiftPlayer.class.getSimpleName();
  
  private ViewStub b;
  
  private SessionModel c;
  
  private GiftPlayView d;
  
  private long e;
  
  public GiftPlayer(ViewStub paramViewStub, long paramLong) {
    this.b = paramViewStub;
    this.e = paramLong;
  }
  
  private void a(long paramLong) {
    this.c.unreadGiftCnt = 0;
    ChatManager.getInstance().updateSessionUnreadGiftCnt(this.c.sessionType, this.c.sessionId, 0, this.c.lastMsgId);
    ThreadManager.a().a(new ThreadExecutor(this, "findAndPlayAnimation", paramLong) {
          public void execute() {
            QueryBuilder queryBuilder = ChattingDao.a().b().queryBuilder();
            Where where = queryBuilder.where();
            try {
              where.eq("fromId", Long.valueOf((GiftPlayer.a(this.b)).sessionId)).and().eq("msgId", Long.valueOf(this.a));
              List list = queryBuilder.query();
              if (list != null && list.size() > 0) {
                AppInfo.n().post(new Runnable(this, list) {
                      public void run() {
                        if (this.b.b.b() != null) {
                          MsgExtraGift msgExtraGift = (MsgExtraGift)AppInfo.f().fromJson(((ChattingModelDB)this.a.get(0)).getMsgExtra(), MsgExtraGift.class);
                          this.b.b.b().a(msgExtraGift);
                        } 
                      }
                    });
                return;
              } 
            } catch (SQLException sQLException) {
              sQLException.printStackTrace();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("SQLException===");
              stringBuilder.append(sQLException.getMessage());
              Logger.e("GiftPlayer", new Object[] { stringBuilder.toString() });
            } 
          }
        });
  }
  
  public long a() {
    return this.e;
  }
  
  public void a(ChattingModel paramChattingModel) {
    if (b() != null) {
      MsgExtraGift msgExtraGift = (MsgExtraGift)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), MsgExtraGift.class);
      b().a(msgExtraGift);
    } 
  }
  
  public void a(SessionModel paramSessionModel) {
    this.c = paramSessionModel;
    if (paramSessionModel != null && paramSessionModel.unreadGiftCnt != 0)
      a(paramSessionModel.lastGiftMsgId); 
  }
  
  public void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    if ((paramGiftGivingOptionForJsonParse == null || b() != null) && !TextUtils.isEmpty(paramGiftGivingOptionForJsonParse.effects)) {
      MsgExtraGift msgExtraGift = new MsgExtraGift();
      msgExtraGift.gift_like = new MsgExtraGift.GiftInfo();
      msgExtraGift.gift_like.giftTye = paramGiftGivingOptionForJsonParse.type;
      msgExtraGift.gift_like.giftId = paramGiftGivingOptionForJsonParse.gift_id;
      msgExtraGift.gift_like.gift_url = paramGiftGivingOptionForJsonParse.effects;
      msgExtraGift.gift_like.gift_name_cn = paramGiftGivingOptionForJsonParse.gift_name_cn;
      msgExtraGift.gift_like.gift_name_en = paramGiftGivingOptionForJsonParse.gift_name_en;
      msgExtraGift.gift_like.gift_name_tw = paramGiftGivingOptionForJsonParse.gift_name_tw;
      msgExtraGift.gift_like.cardGift = paramGiftGivingOptionForJsonParse.extra_info;
      b().a(msgExtraGift);
    } 
  }
  
  public GiftPlayView b() {
    if (this.d == null) {
      ViewStub viewStub = this.b;
      if (viewStub != null)
        this.d = (GiftPlayView)viewStub.inflate(); 
    } 
    return this.d;
  }
  
  public void b(ChattingModel paramChattingModel) {
    a(paramChattingModel);
    SessionModel sessionModel = this.c;
    if (sessionModel != null) {
      sessionModel.unreadGiftCnt = 0;
      sessionModel.lastGiftMsgId = paramChattingModel.msgId;
      ChatManager.getInstance().updateSessionUnreadGiftCnt(this.c.sessionType, this.c.sessionId, 0, paramChattingModel.msgId);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.e == ((GiftPlayer)paramObject).e);
    } 
    return false;
  }
  
  public int hashCode() {
    return (int)this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\GiftPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
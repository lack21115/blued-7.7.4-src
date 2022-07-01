package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.same.Logger;
import com.google.gson.Gson;
import java.util.List;

public class LiveUtils {
  public static final int[] a = new int[] { 
      1, 5, 15, 30, 50, 100, 200, 400, 650, 1000, 
      1500, 2100, 2800, 3800, 5000, 8000, 12000, 17000, 23000, 30000, 
      38000, 47000, 57000, 70000, 88000, 114000, 150000, 198000, 261000, 342000, 
      453000, 606000, 783000 };
  
  public static int a(double paramDouble, float paramFloat1, float paramFloat2, float paramFloat3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getSecondProgress beans:");
    stringBuilder.append(paramDouble);
    Log.v("pk", stringBuilder.toString());
    float f = (float)(paramDouble / 100.0D);
    stringBuilder = new StringBuilder();
    stringBuilder.append("getSecondProgress giftEx:");
    stringBuilder.append(f);
    Log.v("pk", stringBuilder.toString());
    f /= paramFloat3 - paramFloat2;
    stringBuilder = new StringBuilder();
    stringBuilder.append("getSecondProgress progress1:");
    stringBuilder.append(f);
    Log.v("pk", stringBuilder.toString());
    f = (int)(f * 100.0F);
    stringBuilder = new StringBuilder();
    stringBuilder.append("getSecondProgress progress2:");
    stringBuilder.append(f);
    Log.v("pk", stringBuilder.toString());
    if (f < 1.0F)
      return a(paramFloat1, paramFloat2, paramFloat3) + 1; 
    if (a(paramFloat1, paramFloat2, paramFloat3) + f > 100.0F)
      return 100; 
    stringBuilder = new StringBuilder();
    stringBuilder.append("getSecondProgress progress3:");
    int i = (int)f;
    stringBuilder.append(i);
    stringBuilder.append(a(paramFloat1, paramFloat2, paramFloat3));
    Log.v("pk", stringBuilder.toString());
    return i + a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static int a(float paramFloat1, float paramFloat2, float paramFloat3) {
    paramFloat1 = (paramFloat1 - paramFloat2) / (paramFloat3 - paramFloat2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getCurrentProgress currentLevelEx:");
    stringBuilder.append(paramFloat2);
    stringBuilder.append(" -- nextLevelEx:");
    stringBuilder.append(paramFloat3);
    stringBuilder.append(" -- return ");
    int i = (int)(paramFloat1 * 100.0F);
    stringBuilder.append(i);
    Log.v("pk", stringBuilder.toString());
    return i;
  }
  
  public static int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramFloat1 = (paramFloat1 - paramFloat2 - paramFloat3) / (paramFloat4 - paramFloat3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getCurrentProgress currentLevelEx:");
    stringBuilder.append(paramFloat3);
    stringBuilder.append(" -- nextLevelEx:");
    stringBuilder.append(paramFloat4);
    stringBuilder.append(" -- return ");
    int i = (int)(paramFloat1 * 100.0F);
    stringBuilder.append(i);
    Log.v("pk", stringBuilder.toString());
    return i;
  }
  
  public static int a(Context paramContext, ImageView paramImageView, int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      int i = paramInt;
      if (paramInt >= 99)
        i = 99; 
      if (i < 10) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("00");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else if (i < 100) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("anchor_rich");
      stringBuilder.append(str);
      String str = stringBuilder.toString();
      paramInt = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      if (paramImageView != null) {
        paramImageView.setImageResource(paramInt);
        if (i == 0 && paramBoolean) {
          paramImageView.setVisibility(8);
          return paramInt;
        } 
        paramImageView.setVisibility(0);
      } 
      return paramInt;
    } 
    if (paramImageView != null)
      paramImageView.setVisibility(8); 
    return -1;
  }
  
  public static LiveGiftModel a(ChattingModel paramChattingModel) {
    if (paramChattingModel.msgType != 33)
      return null; 
    if (paramChattingModel.msgMapExtra != null)
      return (LiveGiftModel)paramChattingModel.msgMapExtra.get("gift_model"); 
    if (TextUtils.isEmpty(paramChattingModel.getMsgExtra()))
      return null; 
    try {
      return (LiveGiftModel)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), LiveGiftModel.class);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String a(int paramInt) {
    return c(paramInt);
  }
  
  public static String a(List<ChattingModel> paramList) {
    if (paramList == null || paramList.size() == 0)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++) {
      ChattingModel chattingModel = paramList.get(i);
      if (i == paramList.size() - 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(chattingModel.fromId);
        stringBuilder.append("][");
        stringBuilder.append(chattingModel.msgContent);
        stringBuilder.append("][");
        stringBuilder.append(chattingModel.msgTimestamp);
        stringBuilder.append("]");
        stringBuffer.append(stringBuilder.toString());
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(chattingModel.fromId);
        stringBuilder.append("][");
        stringBuilder.append(chattingModel.msgContent);
        stringBuilder.append("][");
        stringBuilder.append(chattingModel.msgTimestamp);
        stringBuilder.append("]§§§§");
        stringBuffer.append(stringBuilder.toString());
      } 
    } 
    Logger.b("TAG", new Object[] { "举报传给服务器的拼接字符串：", stringBuffer.toString() });
    return stringBuffer.toString();
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3) {
    paramFloat1 /= paramFloat3 - paramFloat2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getCurrentProgress currentLevelEx:");
    stringBuilder.append(paramFloat2);
    stringBuilder.append(" -- nextLevelEx:");
    stringBuilder.append(paramFloat3);
    stringBuilder.append(" -- return ");
    stringBuilder.append((int)(100.0F * paramFloat1));
    Log.v("pk", stringBuilder.toString());
    return paramFloat1;
  }
  
  public static LiveLiangModel b(ChattingModel paramChattingModel) {
    LiveLiangModel liveLiangModel;
    StringBuilder stringBuilder;
    if (paramChattingModel == null)
      return null; 
    if (paramChattingModel.fromId == LiveRoomInfo.a().g())
      return LiveRoomManager.a().j(); 
    LiveGiftModel liveGiftModel = a(paramChattingModel);
    if (liveGiftModel != null) {
      liveLiangModel = new LiveLiangModel();
      liveLiangModel.liang_type = liveGiftModel.liang_type;
      liveLiangModel.liang_id = liveGiftModel.liang_id;
      return liveLiangModel;
    } 
    if (((ChattingModel)liveLiangModel).msgMapExtra != null) {
      LiveLiangModel liveLiangModel1 = new LiveLiangModel();
      liveLiangModel1.liang_type = MsgPackHelper.getIntValue(((ChattingModel)liveLiangModel).msgMapExtra, "liang_type");
      liveLiangModel1.liang_id = MsgPackHelper.getStringValue(((ChattingModel)liveLiangModel).msgMapExtra, "liang_id");
      stringBuilder = new StringBuilder();
      stringBuilder.append("from map liang_info:");
      stringBuilder.append(liveLiangModel1.liang_type);
      stringBuilder.append("  : ");
      stringBuilder.append(liveLiangModel1.liang_id);
      Log.i("xpp", stringBuilder.toString());
      return liveLiangModel1;
    } 
    Gson gson = AppInfo.f();
    try {
      if (!TextUtils.isEmpty(stringBuilder.getMsgExtra()))
        return (LiveLiangModel)gson.fromJson(stringBuilder.getMsgExtra(), LiveLiangModel.class); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String b(int paramInt) {
    return c(paramInt);
  }
  
  public static float c(float paramFloat1, float paramFloat2, float paramFloat3) {
    paramFloat1 = (paramFloat1 - paramFloat2) / (paramFloat3 - paramFloat2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getCurrentProgress currentLevelEx:");
    stringBuilder.append(paramFloat2);
    stringBuilder.append(" -- nextLevelEx:");
    stringBuilder.append(paramFloat3);
    stringBuilder.append(" -- return ");
    stringBuilder.append((int)(100.0F * paramFloat1));
    Log.v("pk", stringBuilder.toString());
    return paramFloat1;
  }
  
  private static String c(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getLevelName richLevel=");
    stringBuilder.append(paramInt);
    Log.v("pk", stringBuilder.toString());
    if (paramInt == 30)
      return "男爵"; 
    if (paramInt == 31)
      return "子爵"; 
    if (paramInt == 32)
      return "伯爵"; 
    if (paramInt == 33)
      return "公爵"; 
    if (paramInt == 34)
      return "国王"; 
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\LiveUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
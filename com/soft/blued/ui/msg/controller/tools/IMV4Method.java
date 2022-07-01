package com.soft.blued.ui.msg.controller.tools;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IMV4Method {
  public static int a(long paramLong) {
    return String.valueOf(paramLong).equals(UserInfo.a().i().getUid()) ? 0 : 1;
  }
  
  public static int a(ArrayList<String> paramArrayList, String paramString) {
    Iterator<String> iterator = paramArrayList.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i++) {
      if (((String)iterator.next()).equals(paramString))
        return i; 
    } 
    return i;
  }
  
  public static String a(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramInt);
    stringBuilder.append("_");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  public static String a(ChattingModel paramChattingModel) {
    String[] arrayOfString = paramChattingModel.msgContent.split(",,");
    return (arrayOfString.length < 2) ? "" : arrayOfString[0];
  }
  
  public static String a(short paramShort, long paramLong, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AppMethods.b(a(paramShort, paramLong)));
    stringBuilder.append("/");
    stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
    return stringBuilder.toString();
  }
  
  public static ArrayList<String> a(List<ChattingModel> paramList) {
    ArrayList<String> arrayList = new ArrayList();
    for (ChattingModel chattingModel : paramList) {
      if (chattingModel.msgType == 2)
        arrayList.add(chattingModel.msgContent); 
    } 
    return arrayList;
  }
  
  public static boolean b(long paramLong) {
    return String.valueOf(paramLong).equals(UserInfo.a().i().getUid());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\IMV4Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
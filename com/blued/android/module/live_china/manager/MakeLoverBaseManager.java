package com.blued.android.module.live_china.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MakeLoverBaseManager {
  public List<LiveMakeLoverFansModel> a = new ArrayList<LiveMakeLoverFansModel>();
  
  public LiveMakeLoverFansModel a(int paramInt) {
    List<LiveMakeLoverFansModel> list = this.a;
    return (list == null) ? null : ((paramInt >= 0) ? ((paramInt >= list.size()) ? null : this.a.get(paramInt)) : null);
  }
  
  public LiveMakeLoverFansModel a(String paramString) {
    List<LiveMakeLoverFansModel> list = this.a;
    if (list == null)
      return null; 
    for (LiveMakeLoverFansModel liveMakeLoverFansModel : list) {
      if (TextUtils.equals(liveMakeLoverFansModel.uid, paramString))
        return liveMakeLoverFansModel; 
    } 
    return null;
  }
  
  public List<LiveMakeLoverFansModel> a() {
    return this.a;
  }
  
  public void a(String paramString1, String paramString2) {
    LiveMakeLoverFansModel liveMakeLoverFansModel = a(paramString1);
    if (liveMakeLoverFansModel != null) {
      liveMakeLoverFansModel.pic = paramString2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("baozhao:");
      stringBuilder.append(paramString2);
      Log.i("==makelover===", stringBuilder.toString());
    } 
  }
  
  public void a(List<LiveMakeLoverFansModel> paramList) {
    if (paramList == null)
      return; 
    ArrayList<LiveMakeLoverFansModel> arrayList = new ArrayList();
    for (LiveMakeLoverFansModel liveMakeLoverFansModel : paramList) {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!liveMakeLoverFansModel.isEmpty()) {
        Iterator<LiveMakeLoverFansModel> iterator = this.a.iterator();
        while (true) {
          bool1 = bool2;
          if (iterator.hasNext()) {
            LiveMakeLoverFansModel liveMakeLoverFansModel1 = iterator.next();
            if (TextUtils.equals(liveMakeLoverFansModel1.uid, liveMakeLoverFansModel.uid)) {
              liveMakeLoverFansModel.lamp = liveMakeLoverFansModel1.lamp;
              liveMakeLoverFansModel.pic = liveMakeLoverFansModel1.pic;
              liveMakeLoverFansModel.voice = liveMakeLoverFansModel1.voice;
              bool1 = true;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
      if (!bool1)
        liveMakeLoverFansModel.lamp = 1; 
      arrayList.add(liveMakeLoverFansModel);
    } 
    this.a.clear();
    this.a.addAll(arrayList);
  }
  
  public int b(String paramString) {
    LiveMakeLoverFansModel liveMakeLoverFansModel;
    List<LiveMakeLoverFansModel> list = this.a;
    if (list == null)
      return -1; 
    List list1 = null;
    int i = 0;
    Iterator<LiveMakeLoverFansModel> iterator = list.iterator();
    while (true) {
      list = list1;
      if (iterator.hasNext()) {
        liveMakeLoverFansModel = iterator.next();
        if (TextUtils.equals(liveMakeLoverFansModel.uid, paramString))
          break; 
        i++;
        continue;
      } 
      break;
    } 
    if (liveMakeLoverFansModel != null) {
      this.a.set(i, new LiveMakeLoverFansModel());
      return i;
    } 
    return -1;
  }
  
  public void b() {
    Iterator<LiveMakeLoverFansModel> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((LiveMakeLoverFansModel)iterator.next()).lamp = 1; 
  }
  
  public void c(String paramString) {
    LiveMakeLoverFansModel liveMakeLoverFansModel = a(paramString);
    if (liveMakeLoverFansModel != null)
      liveMakeLoverFansModel.lamp = 0; 
  }
  
  public boolean c() {
    boolean bool1;
    List<LiveMakeLoverFansModel> list = this.a;
    boolean bool3 = false;
    if (list == null)
      return false; 
    if (list.size() > 0 && !((LiveMakeLoverFansModel)this.a.get(0)).isEmpty()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int i = 0;
    while (true) {
      if (i < this.a.size()) {
        if (i != 0 && !((LiveMakeLoverFansModel)this.a.get(i)).isEmpty()) {
          i = 1;
          break;
        } 
        i++;
        continue;
      } 
      i = 0;
      break;
    } 
    boolean bool2 = bool3;
    if (bool1) {
      bool2 = bool3;
      if (i != 0)
        bool2 = true; 
    } 
    return bool2;
  }
  
  public boolean d() {
    boolean bool1;
    List<LiveMakeLoverFansModel> list = this.a;
    boolean bool2 = false;
    if (list == null)
      return false; 
    Iterator<LiveMakeLoverFansModel> iterator = list.iterator();
    while (true) {
      bool1 = bool2;
      if (iterator.hasNext()) {
        LiveMakeLoverFansModel liveMakeLoverFansModel = iterator.next();
        if (TextUtils.equals(liveMakeLoverFansModel.uid, LiveRoomInfo.a().f())) {
          bool1 = bool2;
          if (liveMakeLoverFansModel.lamp != 1)
            bool1 = true; 
          break;
        } 
        continue;
      } 
      break;
    } 
    return bool1;
  }
  
  public boolean e() {
    boolean bool2 = false;
    int i = 0;
    while (true) {
      if (i < this.a.size()) {
        if (i != 0 && !((LiveMakeLoverFansModel)this.a.get(i)).isEmpty() && ((LiveMakeLoverFansModel)this.a.get(i)).lamp == 1) {
          i = 1;
          break;
        } 
        i++;
        continue;
      } 
      i = 0;
      break;
    } 
    boolean bool1 = bool2;
    if (i != 0) {
      bool1 = bool2;
      if (c())
        bool1 = true; 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\MakeLoverBaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
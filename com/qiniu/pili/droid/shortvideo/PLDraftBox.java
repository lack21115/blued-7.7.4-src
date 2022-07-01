package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.f.b;
import com.qiniu.pili.droid.shortvideo.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PLDraftBox {
  private c mDraftBox;
  
  private PLDraftBox(c paramc) {
    this.mDraftBox = paramc;
  }
  
  public static PLDraftBox getInstance(Context paramContext) {
    return new PLDraftBox(c.a(paramContext));
  }
  
  public List<PLDraft> getAllDrafts() {
    List list = this.mDraftBox.a();
    ArrayList<PLDraft> arrayList = new ArrayList();
    Iterator<b> iterator = list.iterator();
    while (iterator.hasNext())
      arrayList.add(new PLDraft(iterator.next())); 
    return arrayList;
  }
  
  public PLDraft getDraftByTag(String paramString) {
    b b = this.mDraftBox.a(paramString);
    return (b == null) ? null : new PLDraft(b);
  }
  
  public void removeAllDrafts(boolean paramBoolean) {
    this.mDraftBox.a(paramBoolean);
  }
  
  public void removeDraftByTag(String paramString, boolean paramBoolean) {
    this.mDraftBox.a(paramString, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLDraftBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
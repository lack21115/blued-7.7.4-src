package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

public final class ba implements IInputtipsSearch {
  private Context a;
  
  private Inputtips.InputtipsListener b;
  
  private Handler c;
  
  private InputtipsQuery d;
  
  public ba(Context paramContext, Inputtips.InputtipsListener paramInputtipsListener) {
    this.a = paramContext.getApplicationContext();
    this.b = paramInputtipsListener;
    this.c = s.a();
  }
  
  public ba(Context paramContext, InputtipsQuery paramInputtipsQuery) {
    this.a = paramContext.getApplicationContext();
    this.d = paramInputtipsQuery;
    this.c = s.a();
  }
  
  private ArrayList<Tip> a(InputtipsQuery paramInputtipsQuery) throws AMapException {
    try {
      q.a(this.a);
      if (paramInputtipsQuery != null) {
        if (paramInputtipsQuery.getKeyword() != null && !paramInputtipsQuery.getKeyword().equals(""))
          return (new o(this.a, paramInputtipsQuery)).n_(); 
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
      throw new AMapException("无效的参数 - IllegalArgumentException");
    } finally {
      paramInputtipsQuery = null;
      i.a((Throwable)paramInputtipsQuery, "Inputtips", "requestInputtips");
      if (!(paramInputtipsQuery instanceof AMapException))
        return null; 
    } 
  }
  
  public final InputtipsQuery getQuery() {
    return this.d;
  }
  
  public final ArrayList<Tip> requestInputtips() throws AMapException {
    return a(this.d);
  }
  
  public final void requestInputtips(String paramString1, String paramString2) throws AMapException {
    requestInputtips(paramString1, paramString2, null);
  }
  
  public final void requestInputtips(String paramString1, String paramString2, String paramString3) throws AMapException {
    if (paramString1 != null && !paramString1.equals("")) {
      this.d = new InputtipsQuery(paramString1, paramString2);
      this.d.setType(paramString3);
      requestInputtipsAsyn();
      return;
    } 
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public final void requestInputtipsAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      i.a(exception, "Inputtips", "requestInputtipsAsynThrowable");
    } 
  }
  
  public final void setInputtipsListener(Inputtips.InputtipsListener paramInputtipsListener) {
    this.b = paramInputtipsListener;
  }
  
  public final void setQuery(InputtipsQuery paramInputtipsQuery) {
    this.d = paramInputtipsQuery;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
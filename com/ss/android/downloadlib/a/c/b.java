package com.ss.android.downloadlib.a.c;

import android.os.Environment;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d.a;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements Runnable {
  private c a;
  
  public b(c paramc) {
    this.a = paramc;
  }
  
  public void run() {
    boolean bool;
    if (this.a == null)
      return; 
    a a = c.a().a(this.a);
    if (a == null)
      return; 
    a.a().a("cleanspace_task", a);
    File file = Environment.getExternalStorageDirectory();
    long l2 = Double.valueOf((j.s() + 1.0D) * this.a.ab()).longValue();
    if (j.l() != null)
      j.l().c(); 
    c.a();
    c.b();
    long l1 = 0L;
    try {
      long l = f.c(file.toString());
      l1 = l;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    if (l1 >= l2) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      d.a().b().put(this.a.g(), "1");
      a.a().a("cleanspace_download_after_quite_clean", a);
      f.a(j.a()).e(this.a.g());
      d.a().a(this.a.j());
      return;
    } 
    if (j.l() != null) {
      if (j.l().b()) {
        if (j.l().a()) {
          j.l().a(this.a.g(), this.a.j(), l2);
          a.a().a("cleanspace_need_user_clean", a);
          return;
        } 
      } else {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.putOpt("show_dialog_result", Integer.valueOf(4));
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        a.a().a("cleanspace_window_show", jSONObject, a);
        return;
      } 
    } else {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.putOpt("show_dialog_result", Integer.valueOf(3));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      a.a().a("cleanspace_window_show", jSONObject, a);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
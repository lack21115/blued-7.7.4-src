package com.qiniu.pili.droid.shortvideo.f;

import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.core.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private String a;
  
  private List<h> b;
  
  private PLCameraSetting c;
  
  private PLMicrophoneSetting d;
  
  private PLVideoEncodeSetting e;
  
  private PLAudioEncodeSetting f;
  
  private PLFaceBeautySetting g;
  
  private PLRecordSetting h;
  
  public b() {
    this(null);
  }
  
  public b(String paramString) {
    this.a = paramString;
    this.b = new ArrayList<h>();
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(PLAudioEncodeSetting paramPLAudioEncodeSetting) {
    this.f = paramPLAudioEncodeSetting;
  }
  
  public void a(PLCameraSetting paramPLCameraSetting) {
    this.c = paramPLCameraSetting;
  }
  
  public void a(PLFaceBeautySetting paramPLFaceBeautySetting) {
    this.g = paramPLFaceBeautySetting;
  }
  
  public void a(PLMicrophoneSetting paramPLMicrophoneSetting) {
    this.d = paramPLMicrophoneSetting;
  }
  
  public void a(PLRecordSetting paramPLRecordSetting) {
    this.h = paramPLRecordSetting;
  }
  
  public void a(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.e = paramPLVideoEncodeSetting;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(Stack<h> paramStack) {
    this.b.clear();
    this.b.addAll(paramStack);
  }
  
  public Stack<h> b() {
    Stack<h> stack = new Stack();
    Iterator<h> iterator = this.b.iterator();
    while (iterator.hasNext())
      stack.push(iterator.next()); 
    return stack;
  }
  
  public PLCameraSetting c() {
    return this.c;
  }
  
  public PLMicrophoneSetting d() {
    return this.d;
  }
  
  public PLVideoEncodeSetting e() {
    return this.e;
  }
  
  public PLAudioEncodeSetting f() {
    return this.f;
  }
  
  public PLFaceBeautySetting g() {
    return this.g;
  }
  
  public PLRecordSetting h() {
    return this.h;
  }
  
  public JSONObject i() {
    List<h> list = this.b;
    if (list != null) {
      if (list.isEmpty())
        return null; 
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tag", this.a);
        if (this.c != null)
          jSONObject.put("PLCameraSetting", this.c.toJSON()); 
        if (this.d != null)
          jSONObject.put("PLMicrophoneSetting", this.d.toJSON()); 
        if (this.e != null)
          jSONObject.put("PLVideoEncodeSetting", this.e.toJSON()); 
        if (this.f != null)
          jSONObject.put("PLAudioEncodeSetting", this.f.toJSON()); 
        if (this.g != null)
          jSONObject.put("PLFaceBeautySetting", this.g.toJSON()); 
        if (this.h != null)
          jSONObject.put("PLRecordSetting", this.h.toJSON()); 
        JSONArray jSONArray = new JSONArray();
        Iterator<h> iterator = this.b.iterator();
        while (iterator.hasNext())
          jSONArray.put(((h)iterator.next()).a()); 
        jSONObject.put("sections", jSONArray);
        return jSONObject;
      } catch (JSONException jSONException) {
        e.d.e("Draft", "Error on toJSON, failed to create tag");
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
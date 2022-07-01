package a.a.a.a.a.a;

import a.a.a.a.a.e.h;
import com.qiniu.pili.droid.streaming.StreamingProfile;

public class d {
  public static final String a;
  
  public StreamingProfile.Stream b;
  
  public String c;
  
  public d(StreamingProfile.Stream paramStream, String paramString) {
    if (paramStream == null)
      this.c = paramString; 
    this.b = paramStream;
  }
  
  public String a() {
    StreamingProfile.Stream stream = this.b;
    if (stream != null)
      this.c = a(stream); 
    String str = a;
    if (str != null)
      this.c = str; 
    return this.c;
  }
  
  public final String a(StreamingProfile.Stream paramStream) {
    return "dynamic".equals(paramStream.getPublishSecurity()) ? h.b(paramStream, "rtmp") : ("static".equals(paramStream.getPublishSecurity()) ? h.a(paramStream, "rtmp") : h.b(paramStream, "rtmp"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
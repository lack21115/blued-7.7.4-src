package a.a.a.a.a.a.e;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.g.c;
import a.a.a.a.a.a.i.c;
import android.media.MediaFormat;

public class b extends a {
  public b(c paramc) {
    super(paramc);
    paramc.b((c.d)this);
    a a1 = paramc.d().j();
    MediaFormat mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", a1.b(), a1.d());
    mediaFormat.setInteger("aac-profile", 2);
    mediaFormat.setInteger("sample-rate", a1.b());
    mediaFormat.setInteger("channel-count", a1.a());
    mediaFormat.setInteger("bitrate", a1.c());
    mediaFormat.setInteger("max-input-size", 16384);
    this.b = (a.a.a.a.a.a.g.b)new c(mediaFormat, "audio/mp4a-latm", false);
    c().start();
    this.c = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
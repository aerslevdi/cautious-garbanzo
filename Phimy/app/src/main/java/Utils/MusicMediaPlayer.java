package Utils;

import android.content.Context;
import android.media.MediaPlayer;
import com.phimy.R;

public class MusicMediaPlayer extends MediaPlayer{
    private static MusicMediaPlayer instance;
    private static MediaPlayer mediaPlayer;
    public final static int APP_MUSIC_NINGUNA = 0;
    public final static int APP_MUSIC_EPIC = 1;
    public final static int APP_MUSIC_POP = 2;
    public final static int APP_MUSIC_ADVENTURE = 3;
    public final static int APP_MUSIC_CLASIC = 4;

    public static MusicMediaPlayer getInstance(){
        if (instance==null){
            instance= new MusicMediaPlayer();
        }
        return instance;
    }

    public void startMusic(Context context) {
        if (mediaPlayer == null) {
            int r = onMusic(context);
            if (r == 0){
                //mediaPlayer.stop();
            }else{
                mediaPlayer = MediaPlayer.create(context,onMusic(context));
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();}
                });
            }
        } else {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer = null;
            int r = onMusic(context);
            if (r == 0){
                //mediaPlayer.stop();
            }else{
                mediaPlayer = MediaPlayer.create(context,onMusic(context));
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.setLooping(true);
                        mediaPlayer.start();}
                });
            }
        }
    }

    public void stop(){
        mediaPlayer.stop();
    }

    public int onMusic(Context context) {
        String musicaValue= DefaultSettings.getListPrefereceMusicValue(context);
        int tm = Integer.parseInt(musicaValue);
        int mus;
        switch (tm){
            default:
            case APP_MUSIC_NINGUNA:
                mus=0;
                break;
            case APP_MUSIC_EPIC:
                mus= R.raw.epic;
                break;
            case APP_MUSIC_POP:
                mus= R.raw.pop;
                break;
            case APP_MUSIC_ADVENTURE:
                mus= R.raw.adventure;
                break;
            case APP_MUSIC_CLASIC:
                mus= R.raw.wethreekings;
                break;
        }
        return mus;
    }

    public void eliminarMedia(){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer = null;
        }
    }
}
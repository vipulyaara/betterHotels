package com.vipul.bit_hotels.reactions;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.vipul.bit_hotels.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chRyNaN on 3/3/2016.
 */
public class SoundManager implements SoundPool.OnLoadCompleteListener {
    private static final String TAG = SoundManager.class.getSimpleName();
    private static final int MAX_STREAMS = 5;

    public static final int APPEAR = 0;
    public static final int LEAVE = 1;
    public static final int SELECT = 2;
    public static final int CANCEL = 3;
    public static final int UP = 4;
    public static final int DOWN = 5;

    private static volatile SoundManager instance;
    private SoundPool soundPool;
    private Context context;
    private Map<Integer, Integer> sounds;

    private SoundManager(Context context){
        this.context = context;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            setUpSoundPoolLollipop();
        }else{
            setUpSoundPool();
        }
        soundPool.setOnLoadCompleteListener(this);
        sounds = new HashMap<>();
        sounds.put(APPEAR, soundPool.load(context, R.raw.appear, 1));
        sounds.put(LEAVE, soundPool.load(context, R.raw.leave, 1));
        sounds.put(SELECT, soundPool.load(context, R.raw.select, 1));
        sounds.put(CANCEL, soundPool.load(context, R.raw.cancel, 1));
        sounds.put(UP, soundPool.load(context, R.raw.up, 1));
        sounds.put(DOWN, soundPool.load(context, R.raw.appear, 1));
    }

    @SuppressWarnings("deprecation")
    private void setUpSoundPool(){
        soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setUpSoundPoolLollipop(){
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(new AudioAttributes.Builder().setContentType(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).build())
                .setMaxStreams(MAX_STREAMS)
                .build();
    }

    public static SoundManager getInstance(Context context){
        if(instance == null){
            instance = new SoundManager(context);
        }
        return instance;
    }

    public void release(){
        if(soundPool != null){
            soundPool.release();
        }
        instance = null;
        sounds = null;
    }


    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        //If I need to perform logic when the sounds are loaded I can put it here
    }

    public void play(int sound){
        sound = (sound < APPEAR) ? APPEAR : sound;
        sound = (sound > DOWN) ? DOWN : sound;
        soundPool.play(sounds.get(sound), 1f, 1f, 0, 0, 1);
    }

}

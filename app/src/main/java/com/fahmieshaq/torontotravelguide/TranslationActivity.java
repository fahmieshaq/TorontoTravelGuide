package com.fahmieshaq.torontotravelguide;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TranslationActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Translation> translations = new ArrayList<Translation>();
        translations.add(new Translation(R.string.translation_english_embassy,
                R.string.translation_chinese_embassy, R.raw.audio_english_embassy));
        translations.add(new Translation(R.string.translation_english_restaurant,
                R.string.translation_chinese_restaurant, R.raw.audio_english_restaurant));
        translations.add(new Translation(R.string.translation_english_taxi,
                R.string.translation_chinese_taxi, R.raw.audio_english_taxi));
        translations.add(new Translation(R.string.translation_english_train,
                R.string.translation_chinese_train, R.raw.audio_english_train));

        TranslationAdapter adapter = new TranslationAdapter(this, translations);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // Play audio of the clicked item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Translation currentTranslation = translations.get(position);
                int englishSoundFileResourceId = currentTranslation.getEnglishAudioResourceId();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(TranslationActivity.this, englishSoundFileResourceId);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;

            // This notifies the system that you no longer require focus and unregisters the associated
            // OnAudioFocusChangeListener. If you requested transient focus, this will notify an app
            // that paused or ducked that it may continue playing or restore its volume.
            // Source: https://developer.android.com/guide/topics/media-apps/volume-and-earphones.html
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}

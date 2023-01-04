package com.github.plexpt.iprecorder.music;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.io.File;

public class WindChimeMusic {
    public static void main(String[] args) {


        music2();
// Set up the music player
        Player player = new Player();

// Create the main melody pattern
        Pattern melody = new Pattern("E5h D5q C5q D5q E5h D5q C5q D5q E5h B4q C5q D5q E5h E5q C5q" +
                " A4q");

// Create the accompanying chord pattern
        Pattern chords = new Pattern("E5min D5min C5maj D5min E5min D5min C5maj D5min E5min B4maj" +
                " C5maj D5min E5maj E5maj C5maj A4maj");

// Create the percussion pattern
        Pattern percussion = new Pattern("DrumKit(3) Eq Dq Cq Dq Eq Dq Cq Dq Eq Bq Cq Dq Eq Eq Cq" +
                " Aq");

// Combine the main melody, chords, and percussion into a single pattern
        Pattern song = new Pattern();
        song.add(melody, chords, percussion);

// Play the song
        player.play(song);

        try {
            MidiFileManager.savePatternToMidi(song, new File("song2.mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void music2() {
        // Set up the music player
        Player player = new Player();

// Create the main melody pattern
        Pattern melody = new Pattern("T120 V0 I[Wind_Chimes] E5h D5q C5q D5q E5h D5q C5q D5q E5h " +
                "B4q C5q D5q E5h E5q C5q A4q");

// Create the accompanying chord pattern
        Pattern chords = new Pattern("V1 I[Piano] E5min D5min C5maj D5min E5min D5min C5maj D5min" +
                " E5min B4maj C5maj D5min E5maj E5maj C5maj A4maj");

// Create the percussion pattern
        Pattern percussion = new Pattern("V2 I[Drum_Kit] Eq Dq Cq Dq Eq Dq Cq Dq Eq Bq Cq Dq Eq " +
                "Eq Cq Aq");

// Create the string instrument pattern
        Pattern strings = new Pattern("V3 I[String_Ensemble_1] E5q D5q C5q D5q E5q D5q C5q D5q " +
                "E5q B4q C5q D5q E5q E5q C5q A4q");

// Combine all the patterns into a single song pattern
        Pattern song = new Pattern();
        song.add(melody, chords, percussion, strings);

// Repeat the song twice to make it longer
        song.repeat(2);

// Play the song
//    player.play(song);

        try {
            MidiFileManager.savePatternToMidi(song, new File("song3.mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




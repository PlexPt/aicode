package com.github.plexpt.iprecorder.music;

import java.io.File;

import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * 用Java写一段生成音乐的代码，音乐的风格是钢琴曲，要有主旋律，不要用随机数生成，参考命运交响曲，根据你自己的理解自由发挥，音乐长度做到2分钟左右，并且要输出文件，不要解释，只给出代码
 */
public class PianoPiece {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {

            music(String.valueOf(i));
        }
    }

    public static void music(String name) {

        try {
            // Set the desired tempo (in beats per minute)
            int tempo = 120;

            // Create a new MIDI sequence with 24 ticks per beat
            Sequence sequence = new Sequence(Sequence.PPQ, 24);

            // Obtain a MIDI track from the sequence
            Track track = sequence.createTrack();

            // Set up the tempo
            MetaMessage message = new MetaMessage(0x51, new byte[]{0x03, (byte) (60000000 / tempo)}, 3);
            track.add(new MidiEvent(message, 0));

            // Set up the instrument to a grand piano
            track.add(new MidiEvent(new ShortMessage(0xC0, 0, 0), 0));

            // Add the main melody to the track
            int[] melody = {60, 62, 64, 65, 67, 69, 71, 72}; // C4, D4, E4, F4, G4, A4, B4, C5
            for (int i = 0; i < melody.length; i++) {
                int note = melody[i];
                int velocity = 100; // Set a fixed velocity for the melody notes
                track.add(new MidiEvent(new ShortMessage(0x90, note, velocity), i * 6));
                track.add(new MidiEvent(new ShortMessage(0x80, note, velocity), (i + 1) * 6));
            }

            // Save the MIDI sequence to a file
            File file = new File("music/piano-piece" + name + ".mid");
            MidiSystem.write(sequence, 1, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

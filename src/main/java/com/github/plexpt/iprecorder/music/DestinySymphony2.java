package com.github.plexpt.iprecorder.music;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Intervals;
import org.jfugue.theory.Note;

import java.io.File;


/**
 * 用 Java 的jfugue写一段生成音乐的代码，音乐的风格是钢琴曲，要有主旋律和伴奏，要符合基本的音乐理论知识，不要用随机数生成，参考命运交响曲，根据你自己的理解自由发挥，音乐长度做到2
 * 分钟左右，并且要输出文件，不要解释，只给出代码
 */
public class DestinySymphony2 {
    public static void main(String[] args) {

        music();


//        m2();


    }

    private static void m2() {
        // 定义曲子的基本属性
        final int BPM = 120;
        final String INSTRUMENT = "PIANO";
        final int LENGTH = 4; // 每小节的拍数
        final String SCALE = "C";

        // 创建曲子
        Player player = new Player();
        StringBuilder score = new StringBuilder();

        // 定义主旋律
        String melody = "C4q E4q G4q C5q G4q E4q C4q C5q G4q E4q C4q C5q G4q E4q C4q G4q E4q C4q";
        score.append(INSTRUMENT).append(" ").append(melody).append(" ");

        // 定义伴奏
        String[] chords = {"C", "E", "G", "C"};
        for (String chord : chords) {
            Chord c = new Chord(new Note(SCALE + "4"), new Intervals(chord));
            score.append(c.getNotes()).append("w ");
        }

        // 设置曲子的属性
        score.insert(0, "T" + BPM + " ");
        score.append("V0 I[PIANO] ");

        // 播放曲子
        player.play(score.toString());

        // 保存曲子到 MIDI 文件
//        player.saveMidi(score.toString(), "DestinySymphony.mid");

        System.out.println("曲子已生成！");
    }

    private static void music() {
        Pattern mainMelody = new Pattern("C5q D5q E5q C5q D5q E5q C5q D5q E5q G5h");

        // Create the accompaniment pattern
        Pattern accompaniment = new Pattern("G4q G4q G4q G4q");

// Combine the main melody and accompaniment patterns
        Pattern song = new Pattern();
        song.add(mainMelody, 1);  // Add main melody on top
        song.add(accompaniment, 2);  // Add accompaniment in the background

// Play the song
        Player player = new Player();
        player.play(song);

// Save the song to a MIDI file
        try {
            MidiFileManager.savePatternToMidi(song, new File("song.mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

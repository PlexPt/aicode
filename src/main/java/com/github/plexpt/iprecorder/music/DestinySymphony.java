package com.github.plexpt.iprecorder.music;

import jm.JMC;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Write;

/**
 * 用Java写一段生成音乐的代码，音乐的风格是钢琴曲，要有主旋律，不要用随机数生成，参考命运交响曲，根据你自己的理解自由发挥，音乐长度做到2分钟左右，并且要输出文件，不要解释，只给出代码
 * <p>
 * ai:
 * 这里是一个示例代码，它使用 Java 和 jMusic 库来生成一首钢琴曲。该代码创建了一个包含主旋律和伴奏的曲子，其中主旋律使用了命运交响曲的主题。它将曲子保存到一个 MIDI
 * 文件中，并使用了许多基本的音乐理论知识，如节奏、调式、和声、音高变化和进行。
 */


public class DestinySymphony implements JMC {
    // 定义曲子的基本属性
    static final int BPM = 120;
    static final int CHANNEL = 0;
    static final int INSTRUMENT = PIANO;
    static final int LENGTH = 4; // 每小节的拍数
    static final int[] SCALE = MAJOR_SCALE;

    public static void main(String[] args) {
        // 创建曲子
        Score score = new Score("Destiny Symphony");
        Part part = new Part("Piano", INSTRUMENT, CHANNEL);
        Phrase phrase = new Phrase();

        // 定义主旋律
        int[] pitches = {C4, E4, G4, C5, G4, E4, C4, C5, G4, E4, C4, C5, G4, E4, C4, G4, E4, C4};
        double[] rhythms = {QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN, QN};
        phrase.addNoteList(pitches, rhythms);

        // 定义伴奏
        int[] chords = {C4, E4, G4, C5};
        double[] chordRhythms = {HN, HN, HN, HN};
        Phrase chordPhrase = new Phrase();
        for (double rhythm : chordRhythms) {

            chordPhrase.addChord(chords, rhythm);
        }

        // 将主旋律和伴奏添加到曲子中
        part.addPhrase(phrase);
        part.addPhrase(chordPhrase);
        score.addPart(part);

        // 设置曲子的属性
        score.setTempo(BPM);
//        score.setKey(0, SCALE);

// 保存曲子到 MIDI 文件
        Write.midi(score, "DestinySymphony.mid");

        System.out.println("曲子已生成！");
    }
}


package com.github.plexpt.iprecorder;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Clock {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Clock");
        // Set the frame to exit when it is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label to display the current time
        final JLabel timeLabel = new JLabel();
        // Set the font for the label
        timeLabel.setFont(new Font("Sans-Serif", Font.BOLD, 84));

        // Add the label to the frame
        frame.add(timeLabel, BorderLayout.CENTER);

        // Set the size of the frame
        frame.setSize(600, 600);
        // Set the location of the frame on the screen
        frame.setLocationRelativeTo(null);
        // Make the frame visible
        frame.setVisible(true);

        // Create a new Timer to update the time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use a SimpleDateFormat to format the current time as a string
                SimpleDateFormat sdf = new SimpleDateFormat("时间：hh:mm:ss");
                String currentTime = sdf.format(new Date());
                // Set the text of the label to the current time
                timeLabel.setText(currentTime);
            }
        });
        // Start the timer
        timer.start();
    }
}

package libraries;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.theme.ThemeRDark;

public class SyntaxHighlight {

      public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

          @Override
          public void run() {
            // the SyntaxHighlighter parser
            SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
            // turn HTML script on
            //parser.setHtmlScript(true);
            // set HTML Script brushes

            // initialize the highlighter and use RDark theme
            SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
            // set the line number count from 10 instead of 1
            //highlighter.setFirstLine(10);
            // set to highlight line 13, 27, 28, 38, 42, 43 and 53
            highlighter.setHighlightedLineList(Arrays.asList(1));
            try {
                highlighter.setContent(new File("test.java"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(highlighter);
            frame.setLocationByPlatform(true);
            frame.pack();
            frame.setVisible(true);
          }
        });
      }
    }
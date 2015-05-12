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
            
            SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());

            SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());

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

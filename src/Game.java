import javax.swing.*;

import java.awt.*;
import java.util.*;
public class Game
{
    void userDisplay()
    {
        JFrame window = new JFrame("Slots");    // Set up JFrame
        window.setSize(640,480);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon cherry = new ImageIcon("resources/cherry.png");   //Set up Images
        ImageIcon bar = new ImageIcon("resources/bar.png");
        ImageIcon seven = new ImageIcon("resources/seven.png");
        ImageIcon spin = new ImageIcon("resources/sping.jpg");

        JButton play = new JButton(spin);
        play.setPreferredSize(new Dimension(150,400));

        JLabel[][] images = new JLabel[3][3];   //Put images in JLabel
        for(int i = 0; i < images.length; i++)
        {
            for(int j = 0; j < images[i].length; j++)
            {
                images[i][j] = new JLabel(cherry);
            }
        }

        JPanel slotPanel = new JPanel(new GridBagLayout()); //Set up panel with constaints
        GridBagConstraints constraints = new GridBagConstraints();

        //row 1
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[0][0],constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[0][1],constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[0][2],constraints);

        //row 2
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[1][0],constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[1][1],constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[1][2],constraints);

        //row 3
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[2][0],constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[2][1],constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.insets = new Insets(0,0,10,10);
        slotPanel.add(images[2][2],constraints);

        //play
        constraints.gridx = 3;
        constraints.gridy = 1;
        slotPanel.add(play,constraints);

        window.add(slotPanel);
        window.setVisible(true);

      play.addActionListener(e -> {
          Random rand = new Random();
          int randNum = rand.nextInt(0,3);    //get random number generator
          int[][] numArray = {{11,12,13}, {14,15,16}, {17,18,19}};
          /*
          cherry = 0, bar = 1, seven = 2
           */


          for(int i = 0; i < images.length; i++)
          {
              for(int j = 0; j < images[i].length; j++)
              {
                  if(randNum == 0)
                  {
                     images[i][j].setIcon(cherry);
                     numArray[i][j] = randNum;
                  }
                  if(randNum == 1)
                  {
                      images[i][j].setIcon(bar);
                      numArray[i][j] = randNum;
                  }
                  if(randNum == 2)
                  {
                      images[i][j].setIcon(seven);
                      numArray[i][j] = randNum;
                  }
                  randNum = rand.nextInt(0,3);
              }

              if(winCheck(numArray)) JOptionPane.showMessageDialog(null, "Winner!");
          }






      });

    }

    public boolean winCheck(int[][] array)
    {
        //checkRows
        for(int i = 0; i < 3; i++)
        {
            if(array[i][0] == array[i][1] && array[i][1] == array[i][2]) return true;
        }

        //check columns
        for(int i = 0; i < 3; i++)
        {
            if(array[0][i] == array[1][i] && array[1][i] == array[2][i]) return true;
        }

        //check diagnols
        if(array[0][0] == array[1][1] && array[1][1] == array[2][2]) return true;
        return array[0][2] == array[1][1] && array[1][1] == array[2][0];
    }
}

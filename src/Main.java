import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main extends JFrame implements ActionListener
{
    JLabel lb1,lb2;
    JTextArea textArea;
    JButton update,bckGndColor,textColor,clr;

    /*
    Constructor creates different objects such as buttons, text area and labels.
    They are added to the window.
     */
    public Main()
    {
        super(" Word Count Tool ");
        lb1 = new JLabel("Characters: "); // JLabel object
        lb1.setBounds(50,50,100,20); // setBounds() takes four arguments.

        lb2 = new JLabel("Word Count: ");// JLabel object
        lb2.setBounds(50,80,100,20);// setBounds() takes four arguments.

        textArea = new JTextArea(); // JTextArea object
        textArea.setLineWrap(true); // allow wrapping of text
        textArea.setBounds(50,110,300,200);// setBounds() takes four arguments.

        update = new JButton("Update"); // JButton object
        update.setBounds(30,320, 80,30);// setBounds() takes four arguments.
        update.addActionListener(this);// check if the button update has been clicked.

        clr = new JButton("Clear");
        clr.setBounds(120,320,80,30);
        clr.addActionListener(this);


        bckGndColor = new JButton("Bckgnd Color");
        bckGndColor.setBounds(200,320, 110,30);//x,y,w,h
        bckGndColor.addActionListener(this);

        textColor = new JButton("Txt Color");
        textColor.setBounds(320,320, 80,30);//x,y,w,h
        textColor.addActionListener(this);

        add(lb1); // adding lb1 to the window
        add(lb2);
        add(textArea);
        add(update);
        add(clr);
        add(bckGndColor);
        add(textColor);

        setSize(500,500);
        setLayout(null);//using no layout manager
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//be like file chooser
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == update)
        {
            String text = textArea.getText();

            lb1.setText("Characters: " + text.length());
            if (text.length() == 0)
            {
                lb2.setText("Words: " + 0);
            }
            else
            {
                String words[] = text.split(" ");
                lb2.setText("Words: " + words.length);
            }

        }
        else if(e.getSource() == bckGndColor)
        {
            Color c = JColorChooser.showDialog(this,"Choose Color",Color.BLACK);
            textArea.setBackground(c);
        }
        else if (e.getSource() == clr)
        {
            textArea.selectAll();
            textArea.replaceSelection("");
            lb1.setText("Characters: " + "");
            lb2.setText("Words: " + "");
        }
        else if(e.getSource() == textColor){
            Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);
            textArea.setForeground(c);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        PrintStream errStream = System.err; // do not remove.
        System.setErr(new PrintStream("error.log"));  // do not remove
        new Main();
    }
}

/*
Another famous story in computer science is the tale of Grace Hopper and the "bug" in the computer. Grace Hopper was a pioneering computer scientist who worked on some of the earliest computers in the 1940s and 1950s. One day, while working on the Harvard Mark II computer, she discovered that there was a problem in the machine. When she investigated further, she found a moth trapped in one of the relays of the computer.

Hopper removed the moth and taped it to the logbook, noting that she had "debugged" the computer. From that day on, the term "bug" has been used to refer to any problem in a computer program or system. This story highlights the importance of debugging and problem-solving in computer science, as well as the creativity and ingenuity required to work with early computing technology.
 */

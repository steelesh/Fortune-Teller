import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{

    JPanel main;
    int screenHeight;
    int screenWidth;

    JPanel topPnl;
    JLabel title;
    ImageIcon image;

    JPanel displayPnl;
    JTextArea txtArea;
    JScrollPane scroller;

    JPanel controlPnl;
    JButton readBtn;
    JButton quitBtn;

    int i = -1;
    int randIndex;
    Random rnd;


    public FortuneTellerFrame(){
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(255, 255, 255));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        FortuneTellerLabel();
        main.add(topPnl, BorderLayout.NORTH);

        FortuneDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
    }
    private void FortuneTellerLabel(){
        topPnl = new JPanel();
        topPnl.setBackground(new Color(255, 255, 255));
        image = new ImageIcon("ico.jpeg");
        title = new JLabel("FORTUNE TELLER", image, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 48));
        title.setForeground(new Color(123, 50, 250));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        topPnl.add(title);
    }
    private void FortuneDisplay(){
        displayPnl = new JPanel();
        displayPnl.setBackground(new Color(255, 255, 255));
        txtArea = new JTextArea(20, 60);
        txtArea.setFont(new Font("SansSerif", Font.ITALIC, 12));
        scroller = new JScrollPane(txtArea);
        displayPnl.add(scroller);
    }
    private void ControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setBackground(new Color(255, 255, 255));
        controlPnl.setLayout(new GridLayout(1, 2));

        ArrayList<String> fortuneList = new ArrayList<>();
        fortuneList.add("Error 404: Fortune not found.");
        fortuneList.add("I see money in your future...it is not yours though.");
        fortuneList.add("You will be lucky in life...Or not, I don't know, or care.");
        fortuneList.add("This fortune won't solve your problems. Go do something productive.");
        fortuneList.add("About time this program chose me :)");
        fortuneList.add("As long as you don't sign up for anything new, you'll be fine.");
        fortuneList.add("You don't have to be faster than the bear, just faster than the slowest guy running from it.");
        fortuneList.add("It's better to keep your mouth shut and look stupid than open it and prove it.");
        fortuneList.add("The quickest way to double your money is to fold it over and put it back into your pocket.");
        fortuneList.add("An apple a day keeps anyone away, if you throw it hard enough.");
        fortuneList.add("Whatever you do, always give 100%. Unless you're donating blood.");
        fortuneList.add("My advice is to never listen to any advice, not even this one.");

        readBtn = new JButton("Read my Fortune!");
        readBtn.addActionListener((ActionEvent ae) ->{
                rnd = new Random();
                do{
                    randIndex = rnd.nextInt(11);
                }while(randIndex == i);
                String fortune = fortuneList.get(randIndex);
                i = randIndex;
                txtArea.append("Your fortune: " + fortune + "\n");
                });
        readBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        controlPnl.add(readBtn);
        controlPnl.add(quitBtn);
    }
}
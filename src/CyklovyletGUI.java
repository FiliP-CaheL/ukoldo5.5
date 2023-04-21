import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CyklovyletGUI extends JFrame{


    private JPanel panel1;
    private JTextField textField1;
    private JButton smažButton;
    private JTextArea textArea1;
    private JMenu m;
    private JMenuItem mi;
    private JMenuItem mi2;
    private JMenuBar mb;
    private JFileChooser jfc;
    private File selectedFile;
    private ArrayList<String> listDva = new ArrayList<>();
    public CyklovyletGUI(){
        setContentPane(panel1);
        m=new JMenu("Soubor");
        mb=new JMenuBar();
        mi=new JMenuItem("Načti");
        mi2=new JMenuItem("Refresh");

        m.add(mi);
        m.add(mi2);
        mb.add(m);

        setJMenuBar(mb);

        mi.addActionListener(e->nacti());
    }

    public void nacti(){
        int result=jfc.showOpenDialog(this);
        if(result==JFileChooser.APPROVE_OPTION){

            File selectedFile=jfc.getSelectedFile();
            load(selectedFile);


            textField1.setText(String.valueOf(listDva));
        }
    }
    public void load(File selectedFile){
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(selectedFile)));
            while(s.hasNextLine()){
                listDva.add(s.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        CyklovyletGUI g=new CyklovyletGUI();
        g.setSize(800, 800);
        g.setVisible(true);
        g.setTitle("Cyklovýlety");
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

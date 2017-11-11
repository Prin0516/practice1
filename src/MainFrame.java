import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpl = new JPanel(new GridLayout(3, 3, 5, 5));
    private JPanel jpl1 = new JPanel(new GridLayout(2, 1, 3, 3));
    private JButton jbtn[] = new JButton[9];
    private JButton exit = new JButton("exit");
    private JButton clear = new JButton("clear");
    private boolean flag = true, boo = true;
    private int count = 0, a = 1;
    private String result = "";

    public MainFrame() {
        init();

    }

    private void init() {
        this.setBounds(300, 200, 300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(jpl1, BorderLayout.EAST);
        jpl1.add(clear);
        jpl1.add(exit);

        for (int i = 0; i < 9; i++) {
            jbtn[i] = new JButton();
            jpl.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    if (flag) {
                        btn.setText("O");
                        flag = false;
                        btn.setEnabled(false);
                        count++;
                    } else {
                        btn.setText("X");
                        flag = true;
                        btn.setEnabled(false);
                        count++;
                    }
                    if (boo == true) {
                        reresult();
                    }
                    if (count == 9) {
                        if (!result.equals("")) {
                            JOptionPane.showMessageDialog(null, result + "win");
                        } else {
                            JOptionPane.showMessageDialog(null, "沒輸沒贏");
                        }
                    }
                }
            });
        }
        cp.add(jpl, BorderLayout.CENTER);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    jbtn[i].setText("");
                    jbtn[i].setEnabled(true);
                }
                flag = true;
                boo = true;
                count = 0;
                result = "";
                a = 1;
            }
        });
    }

    private void reresult() {
        for (int j = 0; j < 9; j += 3) {
            if (jbtn[j].getText().equals(jbtn[j + 1].getText()) && jbtn[j].getText().equals(jbtn[j + 2].getText()) && !(jbtn[j].getText()).equals("")) {
                result = jbtn[j].getText();
                boo = false;
                a = 5;
                break;
            }
        }
        if (boo == true) {
            for (int j = 0; j < 3; j++) {
                if (jbtn[j].getText().equals(jbtn[j + 3].getText()) && jbtn[j].getText().equals(jbtn[j + 6].getText()) && !(jbtn[j].getText()).equals("")) {
                    result = jbtn[j].getText();
                    boo = false;
                    a = 2;
                    break;
                }
            }
            if (jbtn[0].getText().equals(jbtn[4].getText()) && jbtn[0].getText().equals(jbtn[8].getText()) && !(jbtn[0].getText()).equals("")) {
                result = jbtn[0].getText();
                a = 3;
                boo = false;
            } else if (jbtn[2].getText().equals(jbtn[4].getText()) && jbtn[2].getText().equals(jbtn[6].getText()) && !(jbtn[2].getText()).equals("")) {
                result = jbtn[2].getText();
                a = 4;
                boo = false;
            }
        }
    }
}

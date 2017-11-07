import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpl = new JPanel(new GridLayout(3, 3, 5, 5));
    private JButton jbtn[] = new JButton[9];
    private JButton exit = new JButton("exit");
    private JButton clear = new JButton("clear");
    private boolean flag = true, boo = true;
    private int count = 0;

    public MainFrame() {
        init();
    }

    private void init() {
        this.setBounds(10, 10, 300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(exit, BorderLayout.EAST);
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
                        count++;
                        btn.setEnabled(false);
                    } else {
                        btn.setText("X");
                        flag = true;
                        count++;
                        btn.setEnabled(false);
                    }
                    if (!(btn.getText()).equals("")) {
                        for (int i = 0; i < 9; i += 3) {
                            if (jbtn[i].getText().equals(jbtn[i + 1].getText()) && jbtn[i].getText().equals(jbtn[i + 2].getText())) {
                                System.out.println(jbtn[i].getText() + "win");
                            }
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
    }
}

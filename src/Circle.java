import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Circle extends JFrame {
    private Container cp;
    private JButton jbtn[] = new JButton[9];
    private JButton jbtnexit = new JButton("exit");
    private JButton jbtnclear = new JButton("clear");
    private JPanel jpl = new JPanel(new GridLayout(3, 3, 5, 5));
    private JPanel jpl2 = new JPanel(new GridLayout(2, 1, 3, 3));
    private boolean flag = true, boo = true, boo2 = true, jud = true, result = true;
    private Random rnd = new Random();
    private int count = 0;

    public Circle() {
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(500, 250, 500, 500);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(jpl, BorderLayout.CENTER);
        cp.add(jpl2, BorderLayout.EAST);
        jpl2.add(jbtnclear);
        jpl2.add(jbtnexit);
        for (int i = 0; i < 9; i++) {
            jbtn[i] = new JButton();
            jpl.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    if (flag == true) {
                        btn.setText("O");
                        btn.setEnabled(false);
                        flag = false;
                        count++;
                        if (flag == false) {
                            count++;
                            reresult();
                            if (jbtn[4].getText().equals("")) {
                                jbtn[4].setText("X");
                                jbtn[4].setEnabled(false);
                            } else if (jbtn[4].getText().equals("O") && boo2) {
                                int a = rnd.nextInt(8);
                                while (a != 0 && a != 2 && a != 6 && a != 8) {
                                    a = rnd.nextInt(8);
                                }
                                boo2 = false;
                                jbtn[a].setText("X");
                                jbtn[a].setEnabled(false);
                            } else if (boo == true && count <= 8) {
                                judge();
                                if (jud == true) {
                                    int a = rnd.nextInt(8);
                                    int b = 0;
                                    while (b < 9) {
                                        if (a == b && !jbtn[a].getText().equals("")) {
                                            a = rnd.nextInt(8);
                                            b = 0;
                                        } else {
                                            b++;
                                        }
                                    }
                                    jbtn[a].setText("X");
                                    jbtn[a].setEnabled(false);
                                }
                            }
                            boo = true;
                            flag = true;
                            jud = true;
                        }
                    }
                    if (count == 10) {
                        if (result == false) {
                            JOptionPane.showMessageDialog(null, "電腦贏了");
                        } else {
                            JOptionPane.showMessageDialog(null, "沒輸沒贏");
                        }
                    }
                }
            });
        }
        jbtnclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    jbtn[i].setText("");
                    jbtn[i].setEnabled(true);
                }
                boo = true;
                flag = true;
                boo2 = true;
                count = 0;
                jud = true;
                result = true;
            }
        });
        jbtnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void reresult() {
        boolean x = true;
        int p = 1;
        while (p <= 2) {
            if (boo) {
                for (int i = 0; i <= 2; i++) {
                    String a = jbtn[i].getText();
                    String b = jbtn[i + 3].getText();
                    String c = jbtn[i + 6].getText();
                    if (a.equals(b) && (jbtn[i + 6].getText()).equals("")) {
                        if (a.equals("X") && x) {
                            data(i + 6, 1);
                            result = false;
                            break;
                        } else if (a.equals("O") && x == false) {
                            data(i + 6, 1);
                            break;
                        }

                    } else if (b.equals(c) && (jbtn[i].getText()).equals("")) {
                        if (b.equals("X") && x) {
                            data(i, 1);
                            result = false;
                            break;
                        } else if (b.equals("O") && x == false) {
                            data(i, 1);
                            break;
                        }
                    } else if (a.equals(c) && (jbtn[i + 3].getText()).equals("")) {
                        if (a.equals("X") && x) {
                            data(i + 3, 1);
                            result = false;
                            break;
                        } else if (a.equals("O") && x == false) {
                            data(i + 3, 1);
                            break;
                        }
                    }
                }
            }
            if (boo) {
                for (int i = 0; i <= 6; i += 3) {
                    String a = jbtn[i].getText();
                    String b = jbtn[i + 1].getText();
                    String c = jbtn[i + 2].getText();
                    if (a.equals(b) && (jbtn[i + 2].getText()).equals("")) {
                        if (a.equals("X") && x) {
                            data(i + 2, 1);
                            result = false;
                            break;
                        } else if (a.equals("O") && x == false) {
                            data(i + 2, 1);
                            break;
                        }
                    } else if (b.equals(c) && (jbtn[i].getText()).equals("")) {
                        if (b.equals("X") && x) {
                            data(i, 1);
                            result = false;
                            break;
                        } else if (b.equals("O") && x == false) {
                            data(i, 1);
                            break;
                        }
                    } else if (a.equals(c) && (jbtn[i + 1].getText()).equals("")) {
                        if (a.equals("X") && x) {
                            data(i + 1, 1);
                            result = false;
                            break;
                        } else if (a.equals("O") && x == false) {
                            data(i + 1, 1);
                            break;
                        }
                    }
                }
            }
            String a = jbtn[0].getText();
            String b = jbtn[2].getText();
            String c = jbtn[4].getText();
            String d = jbtn[6].getText();
            String e = jbtn[8].getText();

            if (a.equals(c) && boo && (jbtn[8].getText()).equals("")) {
                if (a.equals("X") && x) {
                    data(8, 1);
                    result = false;
                } else if (a.equals("O") && x == false) {
                    data(8, 1);
                }
            } else if (a.equals(e) && boo && (jbtn[4].getText()).equals("")) {
                if (a.equals("X") && x) {
                    data(4, 1);
                    result = false;
                } else if (a.equals("O") && x == false) {
                    data(4, 1);
                }
            } else if (c.equals(e) && boo && (jbtn[0].getText()).equals("")) {
                if (c.equals("X") && x) {
                    data(0, 1);
                    result = false;
                } else if (c.equals("O") && x == false) {
                    data(0, 1);
                }
            } else if (b.equals(c) && boo && (jbtn[6].getText()).equals("")) {
                if (b.equals("X") && x) {
                    data(6, 1);
                    result = false;
                } else if (b.equals("O") && x == false) {
                    data(6, 1);
                }
            } else if (b.equals(d) && boo && (jbtn[4].getText()).equals("")) {
                if (b.equals("X") && x) {
                    data(4, 1);
                    result = false;
                } else if (b.equals("O") && x == false) {
                    data(4, 1);
                }
            } else if (c.equals(d) && boo && (jbtn[2].getText()).equals("")) {
                if (c.equals("X") && x) {
                    data(2, 1);
                    result = false;
                } else if (c.equals("O") && x == false) {
                    data(2, 1);
                }
            }
            p++;
            x = false;
        }
    }

    private void judge() {
        int d = rnd.nextInt(8);
        String a = jbtn[0].getText();
        String b = jbtn[2].getText();
        String c = jbtn[4].getText();
        String e = jbtn[6].getText();
        String f = jbtn[8].getText();

        if (a.equals("X") && jud) {
            if (b.equals("")) {
                data(2, 2);
            } else if (c.equals("") && jud) {
                if (e.equals("O")) {
                    jud = true;
                } else {
                    data(4, 2);
                }
            } else if (e.equals("") && jud) {
                data(6, 2);
            }
        } else if (c.equals("X") && jud) {
            if (a.equals("")) {
                data(0, 2);
            } else if (f.equals("") && jud) {
                data(8, 2);
            } else if (e.equals("") && jud) {
                data(6, 2);
            } else if (b.equals("") && jud) {
                data(2, 2);
            }
        } else if (f.equals("X") && jud) {
            if (b.equals("")) {
                data(2, 2);
            } else if (c.equals("") && jud) {
                data(4, 2);
            } else if (e.equals("") && jud) {
                data(6, 2);
            }
        } else if (b.equals("X") && jud) {
            if (c.equals("")) {
                data(4, 2);
            } else if (a.equals("") && jud) {
                data(0, 2);
            } else if (f.equals("") && jud) {
                data(8, 2);
            }
        } else if (e.equals("X") && jud) {
            if (c.equals("")) {
                data(4, 2);
            } else if (f.equals("") && jud) {
                data(8, 2);
            } else if (a.equals("") && jud) {
                data(0, 2);
            }
        }
//        for (int i = 0; i <= 2; i++) {
//            int g = 1;
//            for (int j = i; j <= i + 6; j += 3) {
//                String l = jbtn[j].getText();
//                if (l.equals("X") && jud) {
//                    while ((d - i) % 3 != 0 || d == j || !(jbtn[d].getText()).equals("")) {
//                        d = rnd.nextInt(8);
//                        if (g == 9) {
//                            break;
//                        }
//                        g++;
//                    }
//                    jbtn[d].setText("X");
//                    jbtn[d].setEnabled(false);
//                    jud = false;
//                    break;
//                } else {
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i <= 6; i += 3) {
//            int g = 1;
//            for (int j = i; j <= i + 2; j++) {
//                String l = jbtn[j].getText();
//                if (l.equals("X") && jud) {
//                    while ((d - i) % 2 != 1 || (d - i) % 2 != 0 || d == j || !(jbtn[d].getText()).equals("")) {
//                        d = rnd.nextInt(8);
//                        if (g == 9) {
//                            break;
//                        }
//                        g++;
//                    }
//                    jbtn[d].setText("X");
//                    jbtn[d].setEnabled(false);
//                    jud = false;
//                    break;
//                } else {
//                    break;
//                }
//            }
//        }
    }
    private void data(int a, int b) {
        jbtn[a].setText("X");
        jbtn[a].setEnabled(false);
        if (b == 1) {
            boo = false;
        } else if (b == 2) {
            jud = false;
        }
    }
}



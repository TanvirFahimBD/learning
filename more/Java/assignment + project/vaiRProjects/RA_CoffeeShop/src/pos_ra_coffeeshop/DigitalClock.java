package pos_ra_coffeeshop;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DigitalClock {
    

    TestPane pane=new TestPane();


    public DigitalClock() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                
                

            }

        });
    }

    public class TestPane extends JPanel {

        private DigitPane hour;
        private DigitPane min;
        private DigitPane second;
        private JLabel[] seperator;

        private int tick = 0;

        public TestPane() {
            setLayout(new GridBagLayout());

            hour = new DigitPane();
            hour.setFont(new Font("Times New Roman", Font.BOLD, 16));
            min = new DigitPane();
            min.setFont(new Font("Times New Roman", Font.BOLD, 16));
            second = new DigitPane();
            second.setFont(new Font("Times New Roman", Font.BOLD, 16));

            seperator = new JLabel[]{new JLabel(":"), new JLabel(":")};
            seperator[0].setFont(new Font("Times New Roman", Font.BOLD, 16));
            seperator[1].setFont(new Font("Times New Roman", Font.BOLD, 16));


            add(hour);
            add(seperator[0]);
            add(min);
            add(seperator[1]);
            add(second);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Calendar cal = Calendar.getInstance();
                    //TimeZone tz=TimeZone.getTimeZone("GMT+6");
                    //cal.setTimeZone(tz);
                    hour.setValue(cal.get(Calendar.HOUR_OF_DAY));
                    min.setValue(cal.get(Calendar.MINUTE));
                    second.setValue(cal.get(Calendar.SECOND));

                    if (tick % 2 == 1) {
                        seperator[0].setText(" ");
                        seperator[1].setText(" ");
                    } else {
                        seperator[0].setText(":");
                        seperator[1].setText(":");
                    }
                    tick++;
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

    }

    public class DigitPane extends JPanel {

        private int value;

        @Override
        public Dimension getPreferredSize() {
            //Graphics2D g;
            FontMetrics fm = getFontMetrics(getFont());
            return new Dimension(fm.stringWidth("00"), fm.getHeight());
        }

        public void setValue(int aValue) {
            if (value != aValue) {
                int old = value;
                value = aValue;
                firePropertyChange("value", old, value);
                repaint();
            }
        }

        public int getValue() {
            return value;
        }

        protected String pad(int value) {
            StringBuilder sb = new StringBuilder(String.valueOf(value));
            while (sb.length() < 2) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            String text = pad(getValue());
            FontMetrics fm = getFontMetrics(g.getFont());
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight()- fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(text, x, y);
        }        
    }    
}
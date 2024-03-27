package com.channelonline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * SetValuesDialogBox.java is a 1.4 application that uses
 * these additional files:
 *   SpringUtilities.java
 *   ...
 */
public class SetValuesDialogBox extends JDialog implements ActionListener,  FocusListener {

    public JTextField col_url;

    final static int GAP = 10;
    public boolean ok=false;


    public SetValuesDialogBox(JFrame frame, boolean mode) {

        super(frame);

        this.setModal(true);

        setSize( 600, 200 );
   //     setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        JPanel leftHalf = new JPanel() {
            //Don't allow us to stretch vertically.
            public Dimension getMaximumSize() {
                Dimension pref = getPreferredSize();
                return new Dimension(Integer.MAX_VALUE, pref.height);
            }
        };

    //    leftHalf.setLayout(new BoxLayout(leftHalf, BoxLayout.LINE_AXIS));
        leftHalf.add(createEntryFields());
        leftHalf.add(createButtons());

        add(leftHalf);
   }

    protected JComponent createButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JButton button = new JButton("OK");
        button.addActionListener(this);
        button.setActionCommand("ok");
        panel.add(button);

        button = new JButton("Cancel");
        button.addActionListener(this);
        button.setActionCommand("cancel");
        panel.add(button);

        //Match the SpringLayout's gap, subtracting 5 to make
        //up for the default gap FlowLayout provides.
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, GAP-5, GAP-5));
        return panel;
    }

    /**
     * Called when the user clicks the button or presses
     * Enter in a text field.
     */
    public void actionPerformed(ActionEvent e) {
        if ("cancel".equals(e.getActionCommand())) {
           ok=false;
           setVisible(false);
        }

        if ("ok".equals(e.getActionCommand())) {
            ok=true;
            setVisible(false);
        }
    }

    /**
     * Called when one of the fields gets the focus so that
     * we can select the focused field.
     */
     public void focusGained(FocusEvent e) {
        Component c = e.getComponent();
        if (c instanceof JFormattedTextField) {
            selectItLater(c);
        } else if (c instanceof JTextField) {
            ((JTextField)c).selectAll();
        }
    }


    //Workaround for formatted text field focus side effects.
    protected void selectItLater(Component c) {
        if (c instanceof JFormattedTextField) {
            final JFormattedTextField ftf = (JFormattedTextField)c;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ftf.selectAll();
                }
            });
        }
    }

    //Needed for FocusListener interface.
    public void focusLost(FocusEvent e) { } //ignore

    protected JComponent createEntryFields() {
        JPanel panel = new JPanel(new SpringLayout());

        String[] labelStrings = {
            "COL URL: "
        };

        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;

        //Create the text field and set it up.
        col_url = new JTextField();
        col_url.setColumns(40);
        fields[fieldNum++] = col_url;

        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);

            //Add listeners to each field.
            JTextField tf = null;

            tf = (JTextField)fields[i];
            tf.addActionListener(this);
            tf.addFocusListener(this);
        }
        SpringUtilities.makeCompactGrid(panel, labelStrings.length, 2, GAP, GAP, GAP, GAP/2);
        return panel;
    }



}

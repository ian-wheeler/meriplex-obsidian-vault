package com.channelonline;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.log4j.*;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.*;
import java.net.URL;

import javax.swing.*;

import javax.swing.filechooser.FileFilter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;




/**
 * @author Igor Merkeev
 *         XMLConnector sends XML requests to ChannelOnline and receives responses.
 */

public class XMLConnector extends JFrame implements ActionListener, ItemListener {
    static final int BUFFER = 2048;
    static JTextArea requestPane;
    static JTextArea errorPane;
    static JTextArea responsePane;

    static final int MAX_CHARACTERS = 300;

    String newline = "\n";
    HashMap actions;
    static Properties properties = new Properties();
    static JMenu fileMenu;
    static JMenu sendMenu;
    static JMenu settingsMenu;
    static JMenuItem settingsMenuItem;
    static String errorMessage = null;
    static File propsFile = null;
    static String currentDirectory = null;

    static String responseText="";

    public XMLConnector() {
        super("XMLConnector");

        JPanel requestPanel = createRequestPanel();

        JPanel errorPanel = createErrorPanel();

        JPanel responsePanel = createResponsePanel();

        JSplitPane splitPane1ErrorResponse = new JSplitPane(JSplitPane.VERTICAL_SPLIT, errorPanel, responsePanel);
        splitPane1ErrorResponse.setOneTouchExpandable(true);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, requestPanel, splitPane1ErrorResponse);
        splitPane.setOneTouchExpandable(true);

        getContentPane().add(splitPane, BorderLayout.CENTER);

    }

    public JPanel createErrorPanel() {
        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(new GridBagLayout());

        JLabel label = new JLabel(" Errors and Warnings");
        JLabel label1 = new JLabel("");

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 0;
        constraints.weighty = 0;

        addToGrid(label, constraints, errorPanel, 0, 0, 1, 1);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.EAST;

        addToGrid(label1, constraints, errorPanel, 1, 0, 1, 1);

        errorPane = new JTextArea(5, 30);
        errorPane.setEditable(false);

        JScrollPane errorScrollPane = new JScrollPane(errorPane);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100;
        constraints.weighty = 100;

        addToGrid(errorScrollPane, constraints, errorPanel, 0, 1, 2, 1);

        return errorPanel;
    }

    public JPanel createResponsePanel() {
        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(new GridBagLayout());

        JLabel label = new JLabel(" Response");
        JLabel label1 = new JLabel("");

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 0;
        constraints.weighty = 0;

        addToGrid(label, constraints, responsePanel, 0, 0, 1, 1);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.EAST;

        addToGrid(label1, constraints, responsePanel, 1, 0, 1, 1);

        responsePane = new JTextArea(5, 30);
        responsePane.setEditable(false);

        JScrollPane responseScrollPane = new JScrollPane(responsePane);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100;
        constraints.weighty = 100;

        addToGrid(responseScrollPane, constraints, responsePanel, 0, 1, 2, 1);

        return responsePanel;
    }

    public JPanel createRequestPanel() {
        JPanel requestPanel = new JPanel();
        requestPanel.setLayout(new GridBagLayout());

        JLabel label = new JLabel(" Request");
        JLabel label1 = new JLabel("");

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 0;
        constraints.weighty = 0;

        addToGrid(label, constraints, requestPanel, 0, 0, 1, 1);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.EAST;

        addToGrid(label1, constraints, requestPanel, 1, 0, 1, 1);

        requestPane = new JTextArea();
        requestPane.setCaretPosition(0);
        requestPane.setMargin(new Insets(5, 5, 5, 5));

        JScrollPane requestScrollPane = new JScrollPane(requestPane);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100;
        constraints.weighty = 100;

        addToGrid(requestScrollPane, constraints, requestPanel, 0, 1, 2, 1);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        JLabel emptyLabelLeft = new JLabel();
        JButton validateButton = new JButton("Validate");
        validateButton.addActionListener(this);
        JLabel emptyLabelBetween = new JLabel("   ");
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        JLabel emptyLabelRight = new JLabel("   ");

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 100;
        constraints.weighty = 0;
        addToGrid(emptyLabelLeft, constraints, buttonPanel, 0, 0, 1, 1);

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 0;
        constraints.weighty = 0;

        addToGrid(validateButton, constraints, buttonPanel, 1, 0, 1, 1);
        addToGrid(emptyLabelBetween, constraints, buttonPanel, 2, 0, 1, 1);
        addToGrid(sendButton, constraints, buttonPanel, 3, 0, 1, 1);
        addToGrid(emptyLabelRight, constraints, buttonPanel, 4, 0, 1, 1);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100;
        constraints.weighty = 0;

        addToGrid(buttonPanel, constraints, requestPanel, 0, 2, 2, 1);

        return requestPanel;
    }


    public void addToGrid(Component c, GridBagConstraints constraints, Container container, int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        container.add(c, constraints);
    }


    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.getAccessibleContext().setAccessibleDescription("Read/Save files");
        menuBar.add(fileMenu);

        //a group of JMenuItems
        menuItem = new JMenuItem("Open request file", KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Open request file");
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);

        menuItem = new JMenuItem("Save request", KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Save request");
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);

        menuItem = new JMenuItem("Save response", KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Save response");
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);

        menuItem = new JMenuItem("Save as Zip", KeyEvent.VK_Z);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Save as Zip");
        menuItem.addActionListener(this);
        fileMenu.add(menuItem);

        //Build second menu in the menu bar.
        sendMenu = new JMenu("Send");
        sendMenu.setMnemonic(KeyEvent.VK_D);
        sendMenu.getAccessibleContext().setAccessibleDescription("Send XML request");
        menuBar.add(sendMenu);

        //a group of JMenuItems
        menuItem = new JMenuItem("Send XML request", KeyEvent.VK_X);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Send XML request");
        menuItem.addActionListener(this);
        sendMenu.add(menuItem);

        //Build fourth menu in the menu bar.
        settingsMenu = new JMenu("Settings");
        settingsMenu.setMnemonic(KeyEvent.VK_T);
        settingsMenu.getAccessibleContext().setAccessibleDescription("Open file with settings");
        menuBar.add(settingsMenu);


        settingsMenuItem = new JMenuItem("Edit settings", KeyEvent.VK_G);
        settingsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
        settingsMenuItem.getAccessibleContext().setAccessibleDescription("Edit settings");
        settingsMenuItem.addActionListener(this);
        settingsMenu.add(settingsMenuItem);

        return menuBar;
    }


    public void actionPerformed(ActionEvent e) {
     //   errorPane.setText("");
     //   responsePane.setText("");

        String actionText = "";

        if (e.getSource() instanceof JMenuItem) {
            JMenuItem source = (JMenuItem) (e.getSource());
            actionText = source.getText();
        } else {
            JButton source = (JButton) (e.getSource());
            actionText = source.getText();
        }

        if (actionText.equals("Open request file")) {
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new XMLConnectorFileFilter("xml", "XML request file");
            chooser.setFileFilter(filter);
            int returnValue = chooser.showOpenDialog(this);
            Reader is;
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    is = new FileReader(chooser.getSelectedFile().getPath());
                    requestPane.setText(Utilities.readerToString(is));
                }
                catch (Exception ex) {
                    Logger logger = Logger.getLogger("XMLConnector");
                    logger.error("Error: " + ex.getMessage());
                    errorPane.setText(ex.getMessage());
                }

            }
        }

        if (actionText.equals("Save request") || actionText.equals("Save response")) {
            JFileChooser chooser = new JFileChooser();

            int returnValue = chooser.showSaveDialog(this);
            Writer os;
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    os = new FileWriter(chooser.getSelectedFile().getPath());
                    if (actionText.equals("Save request")) {
                        os.write(requestPane.getText());
                    } else {
                        os.write(requestPane.getText());
                    }
                    os.close();
                }
                catch (Exception ex) {
                    Logger logger = Logger.getLogger("XMLConnector");
                    logger.error("Error: " + ex.getMessage());
                    errorPane.setText(ex.getMessage());
                }

            }
        }

        if (actionText.equals("Save as Zip")) {
            Utilities.CreateZipFile();
        }

        if (actionText.equals("Edit settings")) {
            SetValuesDialogBox testDialog = new SetValuesDialogBox(this, true);
            testDialog.col_url.setText(properties.getProperty("col.url"));
            testDialog.setModal(true);
            testDialog.setVisible(true);
            if (testDialog.ok == true) {
                properties.setProperty("col.url", testDialog.col_url.getText());
                try {
                    properties.store(new FileOutputStream(propsFile), "");
                }
                catch (Exception ex) {
                    Logger logger = Logger.getLogger("XMLConnector");
                    logger.error("Error: " + ex.getMessage());
                    errorPane.setText(ex.getMessage());
                }
            }
        }


        if (actionText.equals("Send XML request") || actionText.equals("Send") || actionText.equals("Validate")) {
            PostMethod post = new PostMethod(properties.getProperty("col.url"));
            try {
                DocumentBuilderFactory factoryBuilder = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factoryBuilder.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(requestPane.getText())));
                Element root = document.getDocumentElement();
                String tagName = root.getTagName();
                String schemaAttribute = root.getAttribute("schemaVersion");

                File schemaDir = new File(currentDirectory + "/" + schemaAttribute);
                if (!schemaDir.exists()) {
                    updateSchema(schemaAttribute);
                }
                Utilities.Validate(requestPane.getText());

                if (actionText.equals("Send XML request") || actionText.equals("Send")) {
                    HttpClient client = new HttpClient();
                    post.setRequestHeader("Content-type", "text/xml");
                    String request = requestPane.getText();
                    post.setRequestBody(request);
                    Utilities.LogRequest(request);
                    Utilities.LogRAWRequest(post, request);
                    Logger logger = Logger.getLogger("XMLConnector");
                    logger.info("Sent XML request: " + request);
                    int result = client.executeMethod(post);
                    String response = post.getResponseBodyAsString();
                    Utilities.LogResponse(response);
                    Utilities.LogRawResponse(post, response);
                    logger.info("Received XML response: " + response);
                    responsePane.setText(response);
                    Utilities.Validate(response);
                } else {
                    errorPane.setText("It is valid");
                }
            }
            catch (Exception ex) {
                Logger logger = Logger.getLogger("XMLConnector");
                logger.error("Error: " + ex.getMessage());
                errorPane.setText(ex.getMessage() + " " + errorMessage);
                errorMessage = "";
            } finally {
                post.releaseConnection();
            }
        }
    }


    public void itemStateChanged(ItemEvent e) {

    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        final XMLConnector frame = new XMLConnector();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CustomWindowAdapter windowAdapter = new CustomWindowAdapter();
        frame.addWindowListener(windowAdapter);

        Dimension dim = new Dimension(600, 600);
        frame.setPreferredSize(dim);

        frame.setJMenuBar(frame.createMenuBar());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        //Read properties file
        File currentDir = new File(".");

        try {
            currentDirectory = currentDir.getCanonicalPath();
            propsFile = new File(currentDirectory + "/xmlconnector.properties");
            properties.load(new FileInputStream(propsFile));
            sendMenu.setEnabled(true);
            fileMenu.setEnabled(true);
            settingsMenuItem.setEnabled(true);

            ImageIcon imageIcon = new ImageIcon(currentDirectory + "/col.gif");

            frame.setIconImage(imageIcon.getImage());

            File propertiesFile = new File(currentDirectory + "/log4j.properties");
            PropertyConfigurator.configure(propertiesFile.toString());

            Logger logger = Logger.getLogger("XMLConnector");
            logger.info("XML Connector started");

        }
        catch (Exception ex) {
            errorPane.setText(ex.getMessage());
        }

        // updateSchema("4.5");
    }


    static void updateSchema(String schemaVersion) throws Exception {
        StringBuffer out = new StringBuffer();

        BufferedOutputStream dest = null;
        URL requestURL = new URL(properties.getProperty("col.url"));
        String colHost = requestURL.getHost();

        URL schemaURL = new URL("https://" + colHost + "/schema/" + schemaVersion + "/schema.zip");
        InputStream in = schemaURL.openStream();
        ZipInputStream zis = new ZipInputStream(in);
        ZipEntry entry;

        int firstTime = 0;
        while ((entry = zis.getNextEntry()) != null) {
            int count = 0;
            byte data[] = new byte[BUFFER];
            // write the files to the disk
            if (entry.getName().indexOf(".xsd") != -1) {
                out.append("Extracting: " + entry + "\n");
                responsePane.setText(out.toString());
                if (firstTime == 0) {
                    firstTime++;
                    StringTokenizer st = new StringTokenizer(entry.getName(), "/");
                    String version = st.nextToken();
                    File newDir = new File(currentDirectory + "/" + version);
                    Utilities.deleteDir(newDir);
                    newDir.mkdirs();
                }


                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    byteArray.write(data, 0, count);
                }
                String str = byteArray.toString();
                String change = "<xs:include schemaLocation=\"";
                String newCurrent = currentDirectory.replace('\\', '/');
                String newName = change + newCurrent + "/" + schemaVersion + "/";
                str = str.replaceAll(change, newName);

                BufferedWriter output = new BufferedWriter(new FileWriter(currentDirectory + "/" + entry.getName()));
                output.write(str);
                output.close();
            }
        }
        zis.close();

        Logger logger = Logger.getLogger("XMLConnector");
        logger.info("Schema of version " + schemaVersion + " was updated");
    }

//The standard main method.

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //System.setProperty("javax.net.ssl.trustStore", "c:/igorkeystore");
        //System.out.println("javax.net.ssl.trustStore");


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    static class CustomWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            File current = new File(currentDirectory);
            String[] files = current.list();
            for (int i = 0; i < files.length; i++) {
                File file = new File(currentDirectory, files[i]);
                if (file.isDirectory()) {
                   Utilities.deleteDir(file);
                }
            }
            System.exit(0);
        }
    }
}

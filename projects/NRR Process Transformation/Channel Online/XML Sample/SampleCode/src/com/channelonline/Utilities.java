package com.channelonline;

import org.apache.log4j.Logger;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.StatusLine;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.*;
import java.io.*;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;


public class Utilities {
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
    }

    public static String readerToString(Reader is) throws IOException {

        StringBuffer sb = new StringBuffer();
        char[] b = new char[1024];
        int n;
        while ((n = is.read(b)) > 0) {
            sb.append(b, 0, n);
        }
        return sb.toString();
    }


    public static void LogRequest(String request) {
        File file = new File(XMLConnector.currentDirectory, "request.log");
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(file));
            out.print(request);
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger("XMLConnector");
            logger.error("ERROR in writeToFile: " + file);
        }
        finally {
            out.close();
        }


    }

    public static void LogResponse(String response) {
        File file = new File(XMLConnector.currentDirectory, "response.log");
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(file));
            out.print(response);
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger("XMLConnector");
            logger.error("ERROR in writeToFile: " + file);
        }
        finally {
            out.close();
        }


    }

    public static void LogRAWRequest(PostMethod pm, String request) {
        StringBuffer sb = new StringBuffer();
        StatusLine sl = pm.getStatusLine();
        if (sl != null) {
            sb.append(sl.toString());
            sb.append("\r");
        }
        String qs = pm.getQueryString();
        if (qs != null) {
            sb.append(qs);
            sb.append("\r");
        }
        Header[] headers = pm.getRequestHeaders();
        for (Header header : headers) {
            sb.append(header.getName());
            sb.append(":");
            sb.append(header.getValue());
            sb.append("\r");
        }
        sb.append("\r");
        sb.append(request.replaceAll(" ", ""));
        File file = new File(XMLConnector.currentDirectory, "rawrequest.log");
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(file));
            out.print(sb.toString());
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger("XMLConnector");
            logger.error("ERROR in writeToFile: " + file);
        }
        finally {
            out.close();
        }
    }

    public static void LogRawResponse(PostMethod pm, String response) {
        StringBuffer sb = new StringBuffer();
        StatusLine sl = pm.getStatusLine();
        sb.append(sl.toString());
        sb.append("\r");
        Header[] headers = pm.getResponseHeaders();
        for (Header header : headers) {
            sb.append(header.getName());
            sb.append(":");
            sb.append(header.getValue());
            sb.append("\r");
        }
        sb.append("\r");
        sb.append(response.replaceAll(" ", ""));
        File file = new File(XMLConnector.currentDirectory, "rawresponse.log");
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(file));
            out.print(sb.toString());
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger("XMLConnector");
            logger.error("ERROR in writeToFile: " + file);
        }
        finally {
            out.close();
        }
    }

    public static void Validate(String xml) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factoryBuilder = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoryBuilder.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));
        Element root = document.getDocumentElement();
        String tagName = root.getTagName();
        String schemaAttribute = root.getAttribute("schemaVersion");

        final String s1 = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(s1);
        StreamSource ss = new StreamSource(XMLConnector.currentDirectory + "/" + schemaAttribute + "/" + tagName + ".xsd");
        Schema schema = factory.newSchema(ss);
        Validator v = schema.newValidator();
        v.setErrorHandler(new XMLConnectorErrorHandler());
        v.validate(new StreamSource(new StringReader(xml)));
    }

    public static void CreateZipFile() {

        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(XMLConnector.currentDirectory + "/xmlconnector.zip"));
            zipDir(XMLConnector.currentDirectory, zos);
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger("XMLConnector");
            logger.error("ERROR in creating the zip file: " + e);
        }
        finally {
            try {
                zos.close();
            }
            catch (Exception e) {
                Logger logger = Logger.getLogger("XMLConnector");
                logger.error("ERROR in creating the zip file: " + e);
                XMLConnector.errorPane.setText("ERROR in creating the zip file: " + e);
            }

        }
        Logger logger = Logger.getLogger("XMLConnector");
        logger.info("Created zip file: " + XMLConnector.currentDirectory + "/xmlconnector.zip");
        String str = "Zip file: " + XMLConnector.currentDirectory + "/xmlconnector.zip was created. Please send this file to the CNET technical support";
        XMLConnector.errorPane.setText(str);
    }

    public static void zipDir(String dir2zip, ZipOutputStream zos) {
        try {
            File zipDir = new File(dir2zip);
            String[] dirList = zipDir.list();
            byte[] readBuffer = new byte[1024];
            int bytesIn = 0;

            for (int i = 0; i < dirList.length; i++) {
                File f = new File(zipDir, dirList[i]);

                boolean prp = dirList[i].endsWith(".properties");
                boolean log = dirList[i].endsWith(".log");

                if ((prp || log) == false) {
                    continue;
                }

                FileInputStream fis = new FileInputStream(f);
                ZipEntry anEntry = new ZipEntry(f.getName());
                zos.putNextEntry(anEntry);

                while ((bytesIn = fis.read(readBuffer)) != -1) {
                    zos.write(readBuffer, 0, bytesIn);
                }
                fis.close();
            }
        }
        catch (Exception e) {
            Logger logger = Logger.getLogger("XMLConnector");
            logger.error("ERROR in zipDir: " + e);
            XMLConnector.errorPane.setText("ERROR in zipDir: " + e);
        }


    }

}
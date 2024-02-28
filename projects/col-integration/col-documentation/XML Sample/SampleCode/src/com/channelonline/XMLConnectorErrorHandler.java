package com.channelonline;


public class XMLConnectorErrorHandler implements org.xml.sax.ErrorHandler {

    public XMLConnectorErrorHandler() {
    }


    public void error(org.xml.sax.SAXParseException sAXParseException) throws org.xml.sax.SAXException {
        XMLConnector.errorMessage = sAXParseException.toString();
        throw sAXParseException;
    }

    public void fatalError(org.xml.sax.SAXParseException sAXParseException) throws org.xml.sax.SAXException {
        XMLConnector.errorMessage = sAXParseException.toString();
        throw sAXParseException;

    }

    public void warning(org.xml.sax.SAXParseException sAXParseException) throws org.xml.sax.SAXException {
        XMLConnector.errorMessage = sAXParseException.toString();
        throw sAXParseException;

    }

}

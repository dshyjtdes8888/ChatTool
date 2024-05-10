package com.example.chat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Signup {

    public String filePath = "src/main/resources/Data.xml";

    public boolean registerUser(String username, String password) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);

            Element userElement = createUserElement(doc, username, password);
            Element root = doc.getDocumentElement();
            root.appendChild(userElement);

            //写回xml文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Element createUserElement(Document doc, String username, String password) {
        Element user = doc.createElement("user");

        Element usernameElement = doc.createElement("username");
        usernameElement.appendChild(doc.createTextNode(username));

        Element passwordElement = doc.createElement("password");
        passwordElement.appendChild(doc.createTextNode(password));

        user.appendChild(usernameElement);
        user.appendChild(passwordElement);

        return user;
    }
}

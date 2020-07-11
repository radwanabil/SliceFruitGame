package com.company;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class Save {
    private static Save save;
    int score,lives,seconds;
    private Save() {
        score =0;
        lives = 0;
        seconds =0;
    }
    public static  Save getSave()
    {
        if(save == null)
            save = new Save();
        return save;
    }

    public void save(int lives, int score, int time, int min, int max){


        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("save");
            doc.appendChild(rootElement);

            // supercars element
            Element supercar = doc.createElement("save");
            rootElement.appendChild(supercar);

            // setting attribute to element
            Attr attr = doc.createAttribute("save");
            attr.setValue("Ferrari");
            supercar.setAttributeNode(attr);

            // carname element
            Element carname = doc.createElement("lives");
            Attr attrType = doc.createAttribute("lives");
            attrType.setValue("lives");
            carname.setAttributeNode(attrType);
            carname.appendChild(doc.createTextNode(String.valueOf(lives)));
            supercar.appendChild(carname);

            Element carname1 = doc.createElement("score");
            Attr attrType1 = doc.createAttribute("score");
            attrType1.setValue("score");
            carname1.setAttributeNode(attrType1);
            carname1.appendChild(doc.createTextNode(String.valueOf(score)));
            supercar.appendChild(carname1);

            Element carname2 = doc.createElement("time");
            Attr attrType2 = doc.createAttribute("time");
            attrType2.setValue("score");
            carname2.setAttributeNode(attrType2);
            carname2.appendChild(doc.createTextNode(String.valueOf(time)));
            supercar.appendChild(carname2);

            Element carname3 = doc.createElement("min");
            Attr attrType3 = doc.createAttribute("min");
            attrType3.setValue("min");
            carname3.setAttributeNode(attrType3);
            carname3.appendChild(doc.createTextNode(String.valueOf(min)));
            supercar.appendChild(carname3);

            Element carname4 = doc.createElement("max");
            Attr attrType4 = doc.createAttribute("max");
            attrType4.setValue("score");
            carname4.setAttributeNode(attrType4);
            carname4.appendChild(doc.createTextNode(String.valueOf(max)));
            supercar.appendChild(carname4);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Save.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int load(){
        int lives=6,score=0,time=0,min=0,max=0,i=0;
        try {
            File inputFile = new File("Save.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Root element: ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("save");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Student roll no : "
                            + eElement.getAttribute("save"));
                    System.out.println("Lives : "
                            + eElement.getElementsByTagName("lives").item(0).getTextContent());
                    lives=Integer.parseInt(eElement.getElementsByTagName("lives").item(0).getTextContent());
                    System.out.println("Score : "
                            + eElement
                            .getElementsByTagName("score")
                            .item(0)
                            .getTextContent());
                    score=Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent());
                    System.out.println("time : "
                            + eElement
                            .getElementsByTagName("time")
                            .item(0)
                            .getTextContent());
                    time=Integer.parseInt(eElement.getElementsByTagName("time").item(0).getTextContent());
                    System.out.println("min : "
                            + eElement
                            .getElementsByTagName("min")
                            .item(0)
                            .getTextContent());
                    min=Integer.parseInt(eElement.getElementsByTagName("min").item(0).getTextContent());
                    System.out.println("max : "
                            + eElement
                            .getElementsByTagName("max")
                            .item(0)
                            .getTextContent());
                    max=Integer.parseInt(eElement.getElementsByTagName("max").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lives==7)
        {
            if(min==1&&max==2)
            {
             i=1;
            }
            else if(min==3&&max==4)
            {
             i=2;
            }
            else
            {
                i=3;
            }
        }
        else
        {
            if(min==1&&max==2)
            {
                i=4;
            }
            else if(min==3&&max==4)
            {
                i=5;
            }
            else
            {
             i=6;
            }
        }
        this.score = score;
        this.seconds = time;
        this.lives = lives;
        return i;
    }
}

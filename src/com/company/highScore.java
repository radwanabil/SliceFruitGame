package com.company;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.*;

public class highScore {
    private static highScore highscore;
    private highScore()
    {
    }
    public static highScore getHighscore()
    {
        if(highscore == null)
            highscore = new highScore();
        return highscore;
    }
    int high1,high2,high3,high4,high5;
    public void save(int score) throws IOException {
        File f = new File("highScoresClassic.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
       int  x=0,i=0,count=0;
        String line=reader.readLine();
        high1=Integer.parseInt(line);
        line=reader.readLine();
        high2=Integer.parseInt(line);
        line=reader.readLine();
        high3=Integer.parseInt(line);
        line=reader.readLine();
        high4=Integer.parseInt(line);
        line=reader.readLine();
        high5=Integer.parseInt(line);
        if(score==high1||score==high2||score==high3||score==high4||score==high5)
        {
            i=1;
        }
       else if (score>high1) {

            high5=high4;
            high4=high3;
            high3=high2;
            high2=high1;
            high1=score;

        }
      else if (score>high2) {
            high5=high4;
            high4=high3;
            high3=high2;
            high2=score;
        }
        else if (score>high3) {
            high5=high4;
            high4=high3;
            high3=score;
        }
        else if (score>high4) {
            high5=high4;
            high4=score;
        }
       else if (score>high5) {
            high5=score;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(f,false));
        writer.write(high1+"\n"+high2+"\n"+high3+"\n"+high4+"\n"+high5);
        writer.close();

    }
    public String load() throws IOException {
        String str = null; File f = new File("highScoresClassic.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        //int  x=0,i=0,count=0;
        //String line =null;
        String line=reader.readLine();
        high1=Integer.parseInt(line);
        line=reader.readLine();
        high2=Integer.parseInt(line);
        line=reader.readLine();
        high3=Integer.parseInt(line);
        line=reader.readLine();
        high4=Integer.parseInt(line);
        line=reader.readLine();
        high5=Integer.parseInt(line);
        str=high1+"  "+high2+"  "+high3+"  "+high4+"  "+high5;
    return  str;
    }
    public String loadHighClassic() throws IOException {
        String str = null;
        File f = new File("highScoresClassic.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        int x = 0, i = 0, count = 0;
        String line = null;
        line = reader.readLine();
                high1 = Integer.parseInt(line);
            str = " " + high1;
        return str;
    }
    public void saveArcade(int score) throws IOException {
        File f = new File("highScoresArcade.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        int  x=0,i=0,count=0;
        String line=reader.readLine();
        high1=Integer.parseInt(line);
        line=reader.readLine();
        high2=Integer.parseInt(line);
        line=reader.readLine();
        high3=Integer.parseInt(line);
        line=reader.readLine();
        high4=Integer.parseInt(line);
        line=reader.readLine();
        high5=Integer.parseInt(line);
        if(score==high1||score==high2||score==high3||score==high4||score==high5)
        {
            i=1;
        }
       else if (score>high1) {

            high5=high4;
            high4=high3;
            high3=high2;
            high2=high1;
            high1=score;

        }
        else if (score>high2) {
            high5=high4;
            high4=high3;
            high3=high2;
            high2=score;


        }
        else if (score>high3) {
            high5=high4;
            high4=high3;
            high3=score;


        }
        else if (score>high4) {
            high5=high4;
            high4=score;

        }
        else if (score>high5) {
            high5=score;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(f,false));
        writer.write(high1+"\n"+high2+"\n"+high3+"\n"+high4+"\n"+high5);
        writer.close();

    }
    public String loadArcade() throws IOException {
        String str = null; File f = new File("highScoresArcade.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        //int  x=0,i=0,count=0;
        //String line =null;
        String line=reader.readLine();
        high1=Integer.parseInt(line);
        line=reader.readLine();
        high2=Integer.parseInt(line);
        line=reader.readLine();
        high3=Integer.parseInt(line);
        line=reader.readLine();
        high4=Integer.parseInt(line);
        line=reader.readLine();
        high5=Integer.parseInt(line);
        str=high1+"  "+high2+"  "+high3+"  "+high4+"  "+high5;
        return  str;
    }
    public String loadHighArcade() throws IOException {
        String str = null;
        File f = new File("highScoresArcade.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        int x = 0, i = 0, count = 0;
        String line = null;
        line = reader.readLine();
        high1 = Integer.parseInt(line);
        str = " " + high1;
        return str;
    }

}

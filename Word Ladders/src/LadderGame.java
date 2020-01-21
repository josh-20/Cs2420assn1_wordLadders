import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;
public class LadderGame <E>{
    static int MaxWordSize = 15;
    ArrayList<String>[] allList;
    Random random;
    LinkedList lList = new LinkedList();



    public LadderGame(String file){
        random = new Random();
        allList = new ArrayList[MaxWordSize];
        for( int i = 0; i < MaxWordSize; i++)
            allList[i] = new ArrayList<String>();
        try{
            Scanner reader = new Scanner(new File(file));
            while(reader.hasNext()){
                String word = reader.next();
                if (word.length()< MaxWordSize) allList[word.length()].add(word);
           }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void play(String a, String b){
        if (a.length() != b.length()){
            System.out.println("Words are not the same length");
            return;
        }
        if (a.length() >= MaxWordSize) return;
        ArrayList list = new ArrayList();
        ArrayList<String> l = allList[a.length()];
        list = (ArrayList) l.clone();
        for (String i : allList[a.length()])
            lList.addNode(i);
       lList.display();
        System.out.println("Seeking a solution from " + a + " ->" + b + " Size of List " + list.size());

    }
    public void play(int len){
        if (len >= MaxWordSize) return;
        ArrayList<String> list = allList[len];
        String a = list.get(random.nextInt(list.size()));
        String b = list.get(random.nextInt(list.size()));
        play(a, b);
    }

    public void listwords(int words, int length){
        int count = 0;
        for(String i : allList[length]){
            if (count < words){
                System.out.println(i);
                count++;
            }
        }
    }
    public void findLadder(String start, String end){
        lList.addNode(start);

    }
}

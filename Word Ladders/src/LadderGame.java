
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.ArrayList;

public class LadderGame<E> {
    static int MaxWordSize = 15;
    ArrayList<String>[] allList;
    Random random;
    LinkedList foundList = new LinkedList();

    public LadderGame(String file) {
        random = new Random();
        allList = new ArrayList[MaxWordSize];
        for (int i = 0; i < MaxWordSize; i++)
            allList[i] = new ArrayList<String>();
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNext()) {
                String word = reader.next();
                if (word.length() < MaxWordSize) allList[word.length()].add(word);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(String a, String b) {
        LinkedList lList = new LinkedList();
        if (a.length() != b.length()) {
            System.out.println("Words are not the same length");
            return;
        }
        if (a.length() >= MaxWordSize) return;
        ArrayList list = new ArrayList();
        ArrayList<String> l = allList[a.length()];
        list = (ArrayList) l.clone();
        System.out.println("Seeking a solution from " + a + " ->" + b + " Size of List " + l.size());
        find(a,b,list,lList);
    }

        public void play ( int len){
            if (len >= MaxWordSize) return;
            ArrayList<String> list = allList[len];
            String a = list.get(random.nextInt(list.size()));
            String b = list.get(random.nextInt(list.size()));
            play(a, b);
        }
        public void find(String a, String b, ArrayList l,LinkedList lList){

            lList.enqueue(new WordInfo(a,0,a));
            boolean found = false;
            try {
                while (!found) {
                    for (int i = 0; i < l.size(); i++) {

                        if (letterCheck(lList.head.word.word, l.get(i).toString()) && !lList.head.word.history.contains(l.get(i).toString())) {
                            WordInfo newWord = new WordInfo(l.get(i).toString(), lList.head.word.moves + 1, lList.head.word.history + " " + l.get(i).toString());
                            lList.enqueue(newWord);
                            if (l.get(i).toString().equals(b)) {
                                found = true;
                                break;
                            }
                            l.remove(l.get(i).toString());
                            i--;
                        }

                    }
                    lList.dequeue();

                }
                WordInfo fin = new WordInfo(lList.tail.word.word, lList.tail.word.moves, lList.tail.word.history);
                System.out.println(fin);
            }catch (NullPointerException ex){
                System.out.println("Not a word ladder");

            }


        }

        public boolean letterCheck (String a, String b){
            int numbOffLetters = 0;
            char[] secondWord = b.toCharArray();
            char[] firstWord = a.toCharArray();
            for (int i = 0; i < firstWord.length; ++i) {
                if (firstWord[i] == secondWord[i]) {
                    continue;
                } else {
                    numbOffLetters += 1;
                }
            }
            if (numbOffLetters > 1) {
                return false;
            }
            return true;
        }
        public void listwords ( int words, int length){
            int count = 0;
            for (String i : allList[length]) {
                if (count < words) {
                    System.out.println(i);
                    count++;
                }
            }
        }
    }

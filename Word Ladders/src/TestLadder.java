public class TestLadder{
    public static void main(String[] args) {
        int RANDOMCT = 7;

        LadderGame g = new LadderGame("dictionary.txt");


       g.listwords(10, 6);
       g.play("oops", "tots");
        g.play("ride", "ands");
        g.play("happily", "angrily");
        g.play("slow", "fast");
        g.play("stone", "money");
        g.play("biff", "axal");
        for (int i = 3; i < RANDOMCT; i++)
            g.play(i);
    }
}

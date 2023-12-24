import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class untitled {
    public static void main(String[] args) throws IOException {
        Scanner user = new Scanner(System.in);
        String fileName="word.txt";
        System.out.println("Welcome! This program will test your vocabulary knowledge.");
        System.out.println("Please be sure all your text files correct.");

        System.out.println("How many word do you want to test? Please write as integer.(be sure number is less than " +
                "word number.");
        int questionCount= user.nextInt();

        System.out.println("Please select your skip word:");
        String keyword= user.next();
        String answer="";
        String[][] words = randomQuestion(questionCount,fileName);
        String[][] skippedWords= new String[0][0];
        int skipCounter =0;
        for (int i =0;i<questionCount;i++){
            while(!words[i][1].equals(answer) && !answer.equals(keyword)) {
                System.out.println("What is the Turkish word for "+ words[i][0]+" ?" );
                answer=user.nextLine();
                if (answer.equals(words[i][1]))
                    System.out.println("Correct.");
                else if (answer.equals(keyword)){
                    System.out.println("added list.");
                    skippedWords= Arrays.copyOf(skippedWords,skippedWords.length+1);
                    skippedWords[skipCounter++]=words[i];
                }
                else {
                    System.out.println("Wrong.");
                }
            }
        }
        if (!(skippedWords.length ==0))
            for (String[] skippedWord : skippedWords) System.out.println(skippedWord[0] + " " + skippedWord[1]);
        else {
            System.out.println("You finished the test perfectly. Well done!");
        }
    }


    //collect words in file
    public static List<String> readLinesFromFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    //crates randomized array for questions
    public static String[][] randomQuestion(int questionCount,String fileName)throws IOException{
        String [][] questions = new String[questionCount][2];
        List<String>lines =readLinesFromFile(fileName);
        int[] randomized = random(questionCount, lines.size());

        for (int i =0;i<questionCount;i++){
            questions[i][0]= lines.get(randomized[i]);
            questions[i][1]= lines.get(randomized[i]+1);
        }
        return questions;
    }
    public static int[] random(int questionCount,int lineCount){
        int[] arr = new int[questionCount];
        HashSet<Integer> set = new HashSet<>();

        Random rand = new Random();
        int i = 0;
        while (i < questionCount) {
            int num = rand.nextInt(lineCount-1)+1 ;
            if (set.contains(num)) {
                continue;
            }
            if (num%2==0){
                arr[i] = num;
                set.add(num);
                i++;
            }
        }
        return arr;
    }
}

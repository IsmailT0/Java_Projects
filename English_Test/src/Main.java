import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner user = new Scanner(System.in);
        System.out.println("Welcome! This program will test your vocabulary knowledge.");
        System.out.println("Please be sure all your text files correct.");

        System.out.println("How many word do you want to test? Please write as integer.(be sure number is less than " +
                "word number.");
        int questionCount= user.nextInt();

        System.out.println("Please select your skip word:");
        String keyword= user.next();
        String answer;

        String [][] words = wordList("word.txt",random(questionCount,countLines("word.txt")));
        String[][] skippedWords= new String[0][0];
        int skipCounter =0;
        for (int i =0;i<questionCount;i++){
            do {
                System.out.println("What is the Turkish word for "+ words[i][0]+" ?" );
                answer=user.next();
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
            }while(!words[i][1].equals(answer) && !answer.equals(keyword));
        }
        if (!(skippedWords.length ==0))
            for (String[] skippedWord : skippedWords) System.out.println(skippedWord[0] + " " + skippedWord[1]);
        else {
            System.out.println("You finished the test perfectly. Well done!");
        }

    }
    public static String [][] wordList (String fileName,int[] wordsNumber)throws Exception{
        String[][] wordlist= new String[wordsNumber.length][2] ;
        Scanner wordFile= new Scanner(new File(fileName));
        sortIntArray(wordsNumber);
        for (int i = 0; i<wordsNumber.length;i++){
            if (i<1){
                for (int j =0;j<wordsNumber[i];j++) {
                    wordlist[i][0] =wordFile.next();
                    wordlist[i][1] = wordFile.next();
                }
            }else {
                for (int j =wordsNumber[i-1];j<wordsNumber[i];j++){
                    wordlist[i][0] = wordFile.next();
                    wordlist[i][1] = wordFile.next();
                }
            }

        }
        return wordlist;
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
            arr[i] = num;
            set.add(num);
            i++;
        }
        return arr;
    }
    public static int countLines(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        return lineCount;
    }
    public static void sortIntArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


}
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome the minefield game. In this game you will " +
                "try to unlock everywhere without touching mine.");
        System.out.print("For decide the field length please give a int number for the length of a edge: ");
        int length = sc.nextInt();

        System.out.println("Alright! Now have many bomb you want?\n (Remember, the game will get " +
                "harder as the number of mines increases. ) ");
        int mineCount= sc.nextInt();

        char[][] field =  generateField(length);
        int[][] mineCoordinates=mineCoordinates(mineCount,length);

        int x;
        int y;
        boolean gameController;
        int moveCounter=(length*length)-mineCount;
        do {
            displayField(field);

            System.out.print("(start from 0) Enter your x coordinate: ");
            x = sc.nextInt();
            System.out.print("(start from 0) Enter your y coordinate: ");
            y = sc.nextInt();

            gameController=isTrue(x,y,mineCoordinates);

            changeField(x,y,gameController,field);

            moveCounter--;



        }while (gameController && moveCounter !=0);

        if (moveCounter!=0){
            displayField(field);
            System.out.printf("You lost in %d. move.",(length*length-moveCounter));
        }
        else {
            displayField(field);
            System.out.println("You win well done");
        }

    }



    public static boolean isTrue(int x,int y,int[][] mineCoordinates){
        boolean p=true;
        for (int[] mineCoordinate : mineCoordinates) {
            p = x != mineCoordinate[0] && y != mineCoordinate[1];
        }
        return p;
    }

    public static char[][] generateField(int n){
        char[][] field = new char[2*n][2*n];

        for (int i =0;i<2*n;i++){
            if (i % 2 == 0) {
                for (int j=0;j<2*n;j++){
                    if (j%2==0)
                        field[i][j]=' ';
                    else
                        field[i][j]='|';
                }
            }
            else {
                for (int j=0;j<2*n;j++){
                    field[i][j]='-';
                }
            }
        }

        return field;
    }


    //displays the fields array
    public static void displayField(char[][] field){
        for (char[] chars : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }


    public static void changeField(int x, int y,boolean p,char[][] field){
        if(p){
            field[2*x][2*y]='X';
        }
        else {
            field[2*x][2*y]='O';
        }

    }

    //generates two dimension array for bomb coordinates
    public static int[][] mineCoordinates(int mineCount,int length){
        int [][] arr = new int[mineCount][2];
        Random rd= new Random();

        for (int i =0;i< arr.length;i++){
            arr[i][0]= rd.nextInt(length);
            arr[i][1]= rd.nextInt(length);
        }

        return arr;
    }
}
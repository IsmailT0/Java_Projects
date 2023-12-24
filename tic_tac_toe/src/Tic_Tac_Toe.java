import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        game();

    }
    public static void game(){
        System.out.println("Welcome tho this game");
        char [][] board = new char[5][5];
        int [] inputs = new int[9];//for x =0 ; 0-2 x=1; 3-5 x=2
        beforeGame(board);
        Scanner sc= new Scanner(System.in);

        System.out.println();
        displayBoard(board);

        int counter=0;
        char Player;
        do {
            Player=counter%2==0 ? 'X':'O';
            System.out.print("Enter a row (0, 1, or 2) for player "+Player+": ");
            int x= sc.nextInt();
            System.out.print("Enter a column (0, 1, or 2) for player "+Player+": ");
            int y=sc.nextInt();

            updateBoard(board,Player,x,y,inputs);
            displayBoard(board);
            counter++;
        }while (check(board));

        System.out.printf("Player %c wins",Player);
    }

    public static boolean inputCheck(int[] arr, int x,int y){
        switch (x) {
            case 0 -> {
                for (int i = 0; i < 3; i++) {
                    if (arr[i] == y)
                        return false;
                }
            }
            case 1 -> {
                for (int i = 3; i < 6; i++) {
                    if (arr[i] == y)
                        return false;
                }
            }
            case 2 -> {
                for (int i = 6; i < 9; i++) {
                    if (arr[i] == y)
                        return false;
                }
            }
            case default -> {
                System.out.println("You must enter between zero and two");
                return false;
            }
        }
        return 0 <= y && y <= 2;
    }

    public  static void updateBoard(char [][] board,char Player, int x,int y, int[] inputs){

        if (inputCheck(inputs,x,y)){
            inputs[2*x+y]=y;
            board[2*x][2*y]=Player;
        }else {
            System.out.println("Wrong entry!");
        }

    }


    public static void displayBoard(char [][] board){
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
    public static boolean check(char [][] board){
        boolean row= true;
        boolean col = true;
        boolean dio= true;

        //row check
        for (int i = 0; i < board.length; i+=2) {
            if ((board[i][0]==board[i][2])&&(board[i][4]==board[i][0])){
                if (!((board[i][0]==' ')&&(board[i][2]==' ')&&(board[i][4]==' '))){
                    row=false;
                    break;
                }
            }
        }
        for (int i = 0; i < board.length; i+=2) {
            if ((board[0][i]==board[2][i])&&(board[4][i]==board[0][i])){
                if (!((board[0][i]==' ')&&(board[2][i]==' ')&&(board[4][i]==' '))){
                    col=false;
                    break;
                }
            }
        }

        if (board[0][0]==board[2][2])
            if (board[0][0]==board[4][4])
                if (!(board[0][0]==' '))
                    dio=false;

        if (board[0][4]==board[2][2])
            if (board[0][0]==board[4][0])
                if (!(board[0][4]==' '))
                    dio=false;


        return col&&row&&dio;
    }


    public static void beforeGame(char[][] board){
        for (int i = 0; i < board.length; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < board.length; j ++) {
                    if (j%2==0)
                        board[i][j]=' ';
                    else
                        board[i][j] = '|';
                }
            } else {
                for (int j = 0; j < board.length; j++) {
                    board[i][j]='-';
                }
            }
        }

    }

}
//first condition second replacement
//third character
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args){
//        Scanner sc= new Scanner(System.in);
//        char [][] table = new char[7][7];
//        for (int i =0;i<table.length;i++){
//            if (i%2==0){
//                Arrays.fill(table[i], '_');
//            }
//            else {
//                for (int j=0;j< table[i].length;j++){
//                    if (j%2==0)
//                        table[i][j]='|';
//                    else
//                        table[i][j]=' ';
//                }
//            }
//        }int i =0;
//        do {
//            int row;
//            int col;
//            display2D(table);
//            if (i%2==0) {
//                System.out.println("Enter a row (0, 1, or 2) for player X: ");
//                row=sc.nextInt();
//                System.out.println("Enter a column (0, 1, or 2) for player X: ");
//                col=sc.nextInt();
//                update(table,row,col,'X');
//            }
//            else {
//                System.out.println("Enter a row (0, 1, or 2) for player O: ");
//                row=sc.nextInt();
//                System.out.println("Enter a column (0, 1, or 2) for player O: ");
//                col=sc.nextInt();
//                update(table,row,col,'O');
//            }
//            i++;
//        }while(rowCheck(table)&&diagonalCheck(table)&&colCheck(table));
//        System.out.println(rowCheck(table));
//        System.out.println(colCheck(table));
//        System.out.println(diagonalCheck(table));
//        display2D(table);
//        if (i%2==1)
//            System.out.println("X player won");
//        else
//            System.out.println("O player won");
//
//
//    }
//    /*kontrol eden methodlar yap
//     * kontrol edecek methodlar array alacak o arrayler methdoların içinde stringe çevirelecek
//     * scannerla aldığın noktalara göre tabloyu depiştiren bir method yaz (((1 3 5 )))
//     * toplamda 4 method ve bir main class olacak*/
//    public static boolean rowCheck(char[][] table){
//        boolean x= true;
//        for (int i =0;i<table.length-1;i++) {
//            if (table[i][1]==(table[i][3])&&table[i][5]==(table[i][1])){
//                x= false;
//            }
//            if (table[i][1]==' ' &&table[i][3]==' '&&table[i][5]==' '){
//                x= true;
//            }
//
//        }
//        return x;
//    }
//
//    public static boolean colCheck(char[][] table){
//        boolean x= true;
//        for (int i=1;i< table.length;i+=2){
//            for (int j=1;j< table.length;j+=2){
//
//            }
//        }
//    }
//    public static boolean diagonalCheck(char[][] table){
//        boolean x= true;
//        if (table[1][1]==(table[3][3])&&table[5][5]==(table[1][1]))
//            x= false;
//        if (table[1][1]==' '&& table[3][3]==' '&& table[5][5]==' ')
//            x= true;
//        if (table[1][5] != (table[3][3]) || table[5][1] != (table[1][5]))
//            x=false;
//        if (table[1][5]==' '&& table[3][3]==' '&& table[5][1]==' ')
//            x= true;
//        return x;
//    }
//    public static void display2D(char[][] arr){
//        for (char[] chars : arr) {
//            for (char aChar : chars) System.out.print(aChar);
//            System.out.println();
//        }
//    }
//    public static void update(char[][] table,int a,int b,char x){
//        a=(2*a+1);
//        b=(2*b+1);
//        table[a][b]=x;
//    }
//
//}

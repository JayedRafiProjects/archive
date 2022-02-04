import java.util.Scanner;
class Main {
  public static void main(String[] args) {
          Scanner scan = new Scanner(System.in);
          boolean conditionOne = false;//row & column check
          boolean conditionTwo = false;//Entries check
          int x = 0; //row
          int y = 0; //column
        boolean analysisHorizontal = true;
        boolean analysisVertical = true;

        //First input
          while(!conditionOne){
                  String firstln = scan.nextLine();
                  String[]container = firstln.split(" ");
                  if(container.length==2){
                          x = Integer.parseInt(container[0]);
                          y = Integer.parseInt(container[1]);
                          if(x>1 && x<100 && y> 1 && y<100)
                                conditionOne = true;
                  }
          }
        
        //Second input
          while(!conditionTwo){
                String firstln = scan.nextLine();
                String[]container = firstln.split(" ");
                int totalEntry = x*y;
                String[][] matrix = new String[x][y];
                int currentIndex = 0;


                if(container.length==totalEntry){
                        //Creating the matrix
                        for(int i=0; i<x; i++){
                                for(int j=0; j<y; j++){
                                        matrix[i][j]=container[currentIndex++];
                                }
                        }

                        //Symmetric analysis horizontal
                        for(int i=0; i<x; i++){
                                for(int j=0; j<y; j++){
                                        if(!(matrix[i][j].equals(matrix[i][(y-1)-j])))
                                                analysisHorizontal = false;
                                }
                        }

                        //Symmetric analysis vertical
                        for(int i=0; i<x; i++){
                                for(int j=0; j<y; j++){
                                        if(!(matrix[i][j].equals(matrix[(x-1)-i][j])))
                                                analysisVertical = false;
                                }
                        }

                        conditionTwo = true;
                }
          }

          if(conditionTwo){
                if(analysisHorizontal || analysisVertical)
                        System.out.print("Symmetric");
                else
                        System.out.println("Non-symmetric");
          }
  }
}

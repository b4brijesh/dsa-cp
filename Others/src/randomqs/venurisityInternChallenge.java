package randomqs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.util.Vector;

public class venurisityInternChallenge {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter size of grid: ");
        int grid_size=3;
        try {
            grid_size = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException e){
            System.out.println("Error: Input should be an integer");
            return;
        }
        if(grid_size<3 || grid_size>10){
            System.out.println("Error: Grid size should be between 3 and 10");
            return;
        }
        System.out.print("Enter where to hide the Ceryneian Hind: ");
        int act_pos=0;
        try{
            act_pos=Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException e){
            System.out.println("Error: Input should be an integer");
            return;
        }
        int act_row=((act_pos-1)/grid_size)+1,act_col=((act_pos-1)%grid_size)+1;
        Vector<Integer> prev_guesses=new Vector<>();
        outer:for(int i=1;i<=3;i++){
            System.out.print("Enter guess "+i+": ");
            int guess_pos=0;
            try {
                guess_pos=Integer.parseInt(br.readLine());
            }
            catch (NumberFormatException e){
                System.out.println("Error: Input should be an integer");
                return;
            }
            for(int x:prev_guesses){
                if(x==guess_pos){
                    System.out.println("Error: Same guess twice!");
                    break outer;
                }
            }
            prev_guesses.add(guess_pos);
            System.out.print("Output: ");
            int guess_row=((guess_pos-1)/grid_size)+1,guess_col=((guess_pos-1)%grid_size)+1;
            int row_diff=guess_row-act_row,col_diff=guess_col-act_col;
            String s="";
            if(i==3 && (row_diff!=0 || col_diff!=0)){
                System.out.print("Oh no! The Ceryneian Hind escaped!");
                break;
            }
            if(row_diff==0 || col_diff==0){
                if(row_diff==0 && col_diff==0){
                    System.out.print("Congratulations! You've captured the Ceryneian Hind!");
                    break;
                }
                else if(row_diff==0){
                    if(col_diff<0)
                        s="East";
                    else s="West";
                }
                else{
                    if(row_diff<0)
                        s="South";
                    else s="North";
                }
            }
            else {
                if(row_diff<0){
                    if(col_diff<0)
                        s="South-East";
                    else s="South-West";
                }
                else {
                    if(col_diff<0)
                        s="North-East";
                    else s="North-West";
                }
            }
            System.out.println("The Ceryneian Hind is "+s+" of your position. ");
        }
    }
}

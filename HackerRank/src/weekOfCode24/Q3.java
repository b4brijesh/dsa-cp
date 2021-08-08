package weekOfCode24;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/13/16.
 */
public class Q3 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int g=Integer.parseInt(br.readLine());
        for (int i=1;i<=g;i++){
            st=new StringTokenizer(br.readLine());
            w=Integer.parseInt(br.readLine());
            b=Integer.parseInt(br.readLine());
            m=Integer.parseInt(br.readLine());
            pieces=new Piece[w+b];
            board=new String[4][4];
            for (int j=0;j<4;j++)
                Arrays.fill(board[j],"");
            for (int j=0;j<pieces.length;j++){
                st=new StringTokenizer(br.readLine());
                char t=st.nextToken().charAt(0);
                int c=st.nextToken().charAt(0)-65;
                int r=Integer.parseInt(st.nextToken())-1;
                if (j<w) {
                    pieces[j]=new Piece(t,'w',true,r,c);
                    board[r][c]="w"+t;
                }
                else {
                    pieces[j]=new Piece(t,'b',true,r,c);
                    board[r][c]="b"+t;
                }
            }
            boolean win=r$b('w',2*m-1);
        }

        System.exit(0);
    }
    private static class Piece{
        char type;
        char owner;
        boolean alive;
        int row,col;
        Piece(char type,char owner,boolean alive,int row, int col){
            this.type=type;this.owner=owner;this.alive=alive;this.row=row;this.col=col;
        }
    }
    private static Piece[] pieces;
    private static int w,b,m;
    private static String[][] board;
    private static class Pair{
        int x,y;
        Pair(int x,int y){this.x=x;this.y=y;}
    }
    private static boolean r$b(char mover,int steps_rem){
        if (steps_rem==0) return false;
        boolean ans;
        if (mover=='w'){
            ans=false;
            for (int i=0;i<w;i++){
                if (pieces[i].alive){
                    ArrayList<Pair> valid_loc=findValidLocs(pieces[i]);
                    for (int j=0;j<valid_loc.size();j++){
                        int bkp_row=pieces[i].row,bkp_col=pieces[i].col;
                        int dead_idx=-1;
                        board[pieces[i].row][pieces[i].col]="";
                        for (int k=0;k<pieces.length;k++){
                            if (pieces[k].row==valid_loc.get(j).x
                                    &&  pieces[k].col==valid_loc.get(j).y){
                                pieces[k].alive=false;
                                dead_idx=k;
                                break;
                            }
                        }
                        pieces[i].row=valid_loc.get(j).x;
                        pieces[i].col=valid_loc.get(j).y;
                        board[pieces[i].row][pieces[i].col]
                                =""+pieces[i].owner+pieces[i].type;

                        ans= ans||r$b('b',steps_rem-1);

                        board[pieces[i].row][pieces[i].col]="";
                        if (dead_idx!=-1)
                            pieces[dead_idx].alive=true;
                        pieces[i].row=bkp_row;
                        pieces[i].col=bkp_col;
                        board[pieces[i].row][pieces[i].col]
                                =""+pieces[i].owner+pieces[i].type;
                    }
                }
            }
        } else {
            ans=true;
        }
        return ans;
    }
    private static ArrayList<Pair> findValidLocs(Piece p){
        int curr_row=p.row,curr_col=p.col;
        ArrayList<Pair> pairs=new ArrayList<>();
        switch (p.type){
            case 'Q':
                for (int i=1;curr_row+i<4 && curr_col+i<4;i++){
                    int row=curr_row+i,col=curr_col+i;
                    if(board[row][col]=="") pairs.add(new Pair(row,col));
                    else if (board[row][col].charAt(0)==p.owner && p.alive)
                        break;
                    else if (board[row][col].charAt(0)!=p.owner && p.alive){
                        pairs.add(new Pair(row,col));
                        break;
                    }
                }
                for (int i=1;curr_row-i>=0 && curr_col+i<4;i++){
                    int row=curr_row-i,col=curr_col+i;
                    if(board[row][col]=="") pairs.add(new Pair(row,col));
                    else if (board[row][col].charAt(0)==p.owner)
                        break;
                    else if (board[row][col].charAt(0)!=p.owner && p.alive){
                        pairs.add(new Pair(row,col));
                        break;
                    }
                }
                for (int i=1;curr_row+i<4 && curr_col-i>=0;i++){
                    int row=curr_row+i,col=curr_col-i;
                    if(board[row][col]=="") pairs.add(new Pair(row,col));
                    else if (board[row][col].charAt(0)==p.owner)
                        break;
                    else if (board[row][col].charAt(0)!=p.owner && p.alive){
                        pairs.add(new Pair(row,col));
                        break;
                    }
                }
                for (int i=1;curr_row-i>=0 && curr_col-i>=0;i++){
                    int row=curr_row-i,col=curr_col-i;
                    if(board[row][col]=="") pairs.add(new Pair(row,col));
                    else if (board[row][col].charAt(0)==p.owner)
                        break;
                    else if (board[row][col].charAt(0)!=p.owner && p.alive){
                        pairs.add(new Pair(row,col));
                        break;
                    }
                }
                break;
            case 'N':
                break;
            case 'B':
                break;
            case 'R':
                break;
            default: break;
        }
        return pairs;
    }
}

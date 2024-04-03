package com.leetcode.daily.april;

public class WordSearch {
    int dx[]={1,0,-1,0};
    int dy[]={0,1,0,-1};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited =new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(search(0,i,j,visited,board,word))
                    return true;
            }
        }
        return false;

    }

    private boolean search(int index, int currRow, int currCol, boolean[][] visited, char[][] board, String word) {
        if(index==word.length())
            return true;
        if(isSafe(index,currRow,currCol,visited,board,word))
        {
            visited[currRow][currCol]=true;
            for(int i=0;i<4;i++) {
                if (search(index + 1, currRow + dx[i], currCol + dy[i], visited, board, word))
                    return true;
            }
            visited[currRow][currCol]=false;
        }
        return false;
    }

    private boolean isSafe(int index, int currRow, int currCol, boolean[][] visited, char[][] board, String word) {
        if(currRow<0|| currCol<0 || currRow>=board.length || currCol>=board[0].length)
            return false;
        if(board[currRow][currCol]!=word.charAt(index))
            return false;
        if(visited[currRow][currCol])
            return false;
        return true;
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        WordSearch wordSearch=new WordSearch();
        System.out.println(wordSearch.exist(board,word));
    }
}

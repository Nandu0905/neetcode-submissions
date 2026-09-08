class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTrack(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backTrack(
        char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean found = backTrack(board, visited, word, row + 1, col, index + 1)
            || backTrack(board, visited, word, row, col + 1, index + 1)
            || backTrack(board, visited, word, row - 1, col, index + 1)
            || backTrack(board, visited, word, row, col - 1, index + 1);
        visited[row][col] = false;
        return found;
    }
}

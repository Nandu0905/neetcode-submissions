/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node construct(int[][] grid, int rowStart, int rowEnd,
                           int colStart, int colEnd) {

        boolean same = true;
        int first = grid[rowStart][colStart];

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] != first) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                break;
            }
        }

        if (same) {
            return new Node(first == 1, true);
        }

        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;

        Node topLeft = construct(
            grid, rowStart, midRow, colStart, midCol
        );

        Node topRight = construct(
            grid, rowStart, midRow, midCol + 1, colEnd
        );

        Node bottomLeft = construct(
            grid, midRow + 1, rowEnd, colStart, midCol
        );

        Node bottomRight = construct(
            grid, midRow + 1, rowEnd, midCol + 1, colEnd
        );

        return new Node(false, false,
                        topLeft, topRight,
                        bottomLeft, bottomRight);
    }
}
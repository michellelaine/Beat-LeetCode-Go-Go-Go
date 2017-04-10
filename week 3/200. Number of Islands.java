public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0){
        return 0;
    }
    
    //mark and count the no of island
    int num = 0;
    for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == '0') {
                continue;
            }
            //markd the island to '0'
            //nums of accesssing helper function = nums of island
            helper(grid, i, j);
            num++;
        }
      return num; 
    }

private void helper(char[][] grid, int x, int y) {
    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
        return ;
    }
    grid[x][y] = '0';
    //scan in four directions
    helper(grid, x - 1, y);
    helper(grid, x + 1, y);
    helper(grid, x, y - 1);
    helper(grid, x, y + 1);
    
    return ;

}

#include <bits/stdc++.h>

bool isSafe(int x, int y, std::vector<std::vector<int>> &visited, int n, std::vector<std::vector<int>> arr) {
    if ((x >= 0 && x <= n - 1) && (y >= 0 && y <= n - 1) && visited[x][y] == 0 && arr[x][y] == 1) {
        return true;
    } else {
        return false;
    }
}

void solve(std::vector<std::vector<int>> arr, int n, std::vector<std::string> &ans, int x, int y, std::vector<std::vector<int>> &visited, std::string path) {
    if (x == n - 1 && y == n - 1) {
        ans.push_back(path);
        return;
    }
    visited[x][y] = 1;
    int newx = x + 1;
    int newy = y;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('D');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }
    newx = x;
    newy = y - 1;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('L');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }
    newx = x;
    newy = y + 1;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('R');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }
    newx = x - 1;
    newy = y;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('U');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }
    visited[x][y] = 0;
}

std::vector<std::string> searchMaze(std::vector<std::vector<int>> &arr, int n) {
    std::vector<std::string> ans;
    if (arr[0][0] == 0) {
        return ans;
    }
    int srcx = 0, srcy = 0;
    std::vector<std::vector<int>> visited = arr;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            visited[i][j] = 0;
        }
    }
    std::string path;
    solve(arr, n, ans, srcx, srcy, visited, path);
    std::sort(ans.begin(), ans.end());
    return ans;
}

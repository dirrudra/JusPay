package questions;
#include <bits/stdc++.h>
using namespace std;

bool isSafe(int x, int y, vector<vector<int>> &visited, int n, vector<vector<int>> &arr) {
    if ((x >= 0 && x <= n - 1) && (y >= 0 && y <= n - 1) && visited[x][y] == 0 && arr[x][y] == 1) {
        return true;
    } else {
        return false;
    }
}

void solve(vector<vector<int>> &arr, int n, vector<string> &ans, int x, int y, vector<vector<int>> &visited, string path) {
    if (x == n - 1 && y == n - 1) {
        ans.push_back(path);
        return;
    }

    visited[x][y] = 1;

    // Down
    int newx = x + 1;
    int newy = y;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('D');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }

    // Left
    newx = x;
    newy = y - 1;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('L');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }

    // Right
    newx = x;
    newy = y + 1;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('R');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }

    // Up
    newx = x - 1;
    newy = y;
    if (isSafe(newx, newy, visited, n, arr)) {
        path.push_back('U');
        solve(arr, n, ans, newx, newy, visited, path);
        path.pop_back();
    }

    visited[x][y] = 0;
}

vector<string> searchMaze(vector<vector<int>> &arr, int n) {
    vector<string> ans;
    if (arr[0][0] == 0) {
        return ans;
    }

    int srcx = 0, srcy = 0;
    vector<vector<int>> visited(n, vector<int>(n, 0));

    string path;
    solve(arr, n, ans, srcx, srcy, visited, path);

    sort(ans.begin(), ans.end());
    return ans;
}

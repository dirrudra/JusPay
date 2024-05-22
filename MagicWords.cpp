#include <bits/stdc++.h>
using namespace std;

string findOrderOfCharacters(vector<string>& words, int numWords, int numChars) {
    vector<vector<int>> adjacencyList(numChars);
    for (int i = 0; i < numWords - 1; ++i) {
        string currentWord = words[i];
        string nextWord = words[i + 1];
        int minLength = min(currentWord.length(), nextWord.length());
        for (int j = 0; j < minLength; ++j) {
            if (currentWord[j] != nextWord[j]) {
                adjacencyList[currentWord[j] - 'a'].push_back(nextWord[j] - 'a');
                break;
            }
        }
    }
    vector<int> inDegree(numChars, 0);
    for (const auto& neighbors : adjacencyList) {
        for (int neighbor : neighbors) {
            inDegree[neighbor]++;
        }
    }
    queue<int> zeroInDegreeQueue;
    for (int i = 0; i < numChars; ++i) {
        if (inDegree[i] == 0) {
            zeroInDegreeQueue.push(i);
        }
    }
    string result;
    while (!zeroInDegreeQueue.empty()) {
        int current = zeroInDegreeQueue.front();
        zeroInDegreeQueue.pop();
        result += (char)(current + 'a');
        for (int neighbor : adjacencyList[current]) {
            inDegree[neighbor]--;
            if (inDegree[neighbor] == 0) {
                zeroInDegreeQueue.push(neighbor);
            }
        }
    }
    if (result.length() == numChars) {
        return result;
    } else {
        return "";
    }
}

int main() {
    int numWords, numChars;
    cin >> numWords >> numChars;
    vector<string> words(numWords);
    for (int i = 0; i < numWords; ++i) {
        cin >> words[i];
    }
    cout << findOrderOfCharacters(words, numWords, numChars) << endl;
    return 0;
}

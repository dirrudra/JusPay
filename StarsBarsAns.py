str = input()
n = int(input())
startIndex = []
endIndex = []
for i in range(n):
    startIndex.append(int(input()))
for i in range(n):
    endIndex.append(int(input()))

len_str = len(str)
counter = [-1] * len_str
count = 0
lastIdx = -1

st = []
for i in range(len_str):
    ch = str[i]
    if ch == '|':
        while st:
            idx = st.pop()
            counter[idx] = i
    st.append(i)

ansArr = []
for i in range(n):
    sIndex = startIndex[i]
    eIndex = endIndex[i]
    sCount = 0
    if str[sIndex] != '|':
        sIndex = counter[sIndex]
    if sIndex == -1 or counter[sIndex] == -1:
        ansArr.append(0)
        continue
    while sIndex < eIndex:
        nextIdx = counter[sIndex]
        if nextIdx != -1 and nextIdx <= eIndex:
            sCount += nextIdx - sIndex - 1
        sIndex = nextIdx
    ansArr.append(sCount)

for ele in ansArr:
    print(ele, end=" ")
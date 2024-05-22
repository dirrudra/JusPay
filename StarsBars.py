s= input()
n = int(input())

stInd= []
endInd= []

for i in range(n):
    stInd.append(int(input()))
                

for i in range(n):
    endInd.append(int(input()))

len_str = len(s)
count = 0

# last = -1

# st = []
# for i in range(len_str):
#     ch = str[i]
#     if ch == '|':
#         while st:
#             ind = st.pop()
#             counter[ind] = i
#     st.append(i)

ansArr = [] 

for i in range(n):
    line = s[stInd[i] : endInd[i]+1]
    print(line)
    print(stInd[i] , endInd[i])

    for char in line:
        if char == '|':
            count += 1
    if(count == 1 ): ansArr.append(0)
    else: ansArr.append(count)
    count = 0
print(ansArr)



                 
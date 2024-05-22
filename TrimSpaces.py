n = input()

print(*n.split(),sep="")

# n = input()
# l = len(n)-1
# for i in range(l):
#     if n[i] == ' ':
#         n = n[0:i] + n[i+1:]
#         l -= 1
# print(n)
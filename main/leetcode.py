def printList(x:list) -> list:
    length = len(x)
    print(length)
    return x

print("Hello world")

a=[]


num=19

while num>0:
    digit=num%10
    num=int(num/10)
    a.append(digit)

print(a)
# for even
for i in range(0,len(a),1):
    for j in range(i,len(a),1):
        oddflag = a[i]%2
        if oddflag==0:
            if a[j]%2==0 and a[i] > a[j]:
                temp = a[i]
                a[i]=a[j]
                a[j]=temp
        else :
            if a[j]%2==1 and a[i] > a[j]:
                temp = a[i]
                a[i]=a[j]
                a[j]=temp

print(a)
#
# for i in range(1,len(a),2):
#     for j in range(i,len(a),2):
#         if (a[i] > a[j]):
#             temp = a[i]
#             a[i]=a[j]
#             a[j]=temp
# #
# print(a)
# #
a.reverse()
newnum=0
for d in a:
    newnum = newnum*10+d
#
print(newnum)
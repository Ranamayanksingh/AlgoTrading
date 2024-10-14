import sys
import random
sys.setrecursionlimit(10**8)
class Solution:
    def kthSmallest(self,arr, l, r, k):
        '''
        arr : given array
        l : starting index of the array i.e 0
        r : ending index of the array i.e size-1
        k : find kth smallest element and return using this function
        '''
        if k > 0 and  k<= r-l+1:
            pos = self.randomPartition(arr,l,r)
            if (pos -l == k-1):
                return arr[pos]
            if pos -l > k-1:
                return self.kthSmallest(arr,l,pos-1,k)
            return self.kthSmallest(arr,pos+1,r,k-1-pos+l)

        return -1


    def swap(self,arr,i,j):
        arr[i],arr[j]=arr[j],arr[i]

    def randomPartition(self,arr,l,r):
        n = r-l+1
        pivot = int(random.random()%n)
        self.swap(arr,l+pivot,r)
        return self.partition(arr,l,r)

    def partition(self,arr,l,r):
        x = arr[r]
        i = l
        for j in range(l,r):
            if(arr[j] <=x):
                self.swap(arr,j,i)
                i += 1

        self.swap(arr,i,r)
        return i

if __name__  == "__main__":
    arr = [10,44,1,12,56,13]
    sol = Solution()
    kthSmallest = sol.kthSmallest(arr,0,5,3)
    print(kthSmallest)
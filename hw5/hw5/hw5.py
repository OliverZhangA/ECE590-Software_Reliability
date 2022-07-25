"""
SelectionSort
"""
def acceptance_test(listToTest):
    if listToTest == []:
        return True
    else:
        for index in range(len(listToTest) - 1):
            if(listToTest[index] > listToTest[index + 1]):
                return False
        return True
def SelectionSort(listToSort):
    for index in range(len(listToSort)):
        min = listToSort[index]
        minindex = index
        for index1 in range(index, len(listToSort)):
            #bug inserted here
            if min > listToSort[index1]:
                min = listToSort[index1]
                minindex = index1
        temp = listToSort[index]
        listToSort[index] = listToSort[minindex]
        listToSort[minindex] = temp
    return listToSort

"""
InsertionSort
"""
def InsertionSort(listToSort):
    isswap = 0
    for index in range(len(listToSort)):
        isswap = 0
        for index1 in range(index, 0, -1):
            if listToSort[index1] < listToSort[index1 - 1]:
                temp = listToSort[index1]
                listToSort[index1] = listToSort[index1 - 1]
                listToSort[index1 - 1] = temp
                isswap = 1
            if isswap == 0:
                break
            isswap = 0
    return listToSort

if __name__ == "__main__":
    input_string = input("Enter a list element separated by space ")
    listToSort = input_string.split()
    for num in range(len(listToSort)):
        listToSort[num] = int(listToSort[num])
    print("calling selection sort")
    result = SelectionSort(listToSort)
    t = acceptance_test(result)
    if t == False:
        print('first block(slection sort) is wrong! now try second block(insertion sort)')
        result = InsertionSort(listToSort)
        t = acceptance_test(result)
        if t==False:
            raise Exception('Can not get the right sorting result!')
    print('the right sorting result is')
    print(result)

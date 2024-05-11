The bubble sort is the sorting algorithm that makes the elements "float" to a side of an array by constantly comparing it to the adjacent element

### Implementation

Let's assume we have an index i that will be iterate through the whole array but the last element

```
for (i = 0; i < array.length - 1; i++)
```

and an inner loop of j where j will loop from the first element until the (length - i - 1)-th element. 

```
for (i = 0; i < array.length - 1; i++)
	for (j = 0; j < array.length - i - 1; j++)
```

The reason why we're only looping until  (length - i - 1) is that due that the nature of bubble sort, that we have made the sorted element "floated" to one side of the array. And this effect has already cascaded since the first iteration, causing our first sorted element to already being in the last position. Since this holds, we just need to check from 0 until **(length - i - 1)** as we know the part between (**array.length - i - 1**; **array.length**) is sorted already.

The next step is to compare and swap. This will implemented based on whether we want the sorted array to be in ascending or descending order

```Java
public void sort(ArrayList<Integer> array, boolean isAsc) {  
    int arrayLength = array.size();  
  
    // The inner for loop only loops to len - 1 to prevent overflow as we compare 
    // the element and its forward neighbor  
    for (int i = 0; i < arrayLength; i++){  
        for (int j = 0; j < arrayLength - i -  1; j++){  
  
            // Here's the "bubble part", by comparing two adjacent elements, we 
            // make sure the the smaller / largest value will  
            // "float" to either sides of the array one by one            
            if (compareFunction(array.get(j), array.get(j + 1), isAsc)){  
                // compareFunction is an util function that checks whether this
                // swapping operation should be performed  
		        // check its source code at the base class (Sorting.java) 
		        swap(array, j, j + 1);  
            }  
        }  
    }  
}
```

### Note
#### Stable:

Bubble sort **IS** a stable sorting algorithm
The main reason why this matter is when we want to preserve this sorted attribute when sorting two or more value of a whole data type. For example, consider this table of a database representing a withdraw history from a bank:

Note that this table contains 2 duplicate username records. In a normal stable sort visualizer, this would be represent with duplicate numbers.

| Username   | Credit |
| ---------- | ------ |
| John Doe   | 2      |
| Elise Hans | 4      |
| Tom Platt  | 3      |
| **Peter Pan**  | **5**      |
| Luna Ngo   | 0      |
| **Peter Pan**  | **1**      |
Let's try sorting based on the **Credit**:

| Username   | Credit |
| ---------- | ------ |
| Luna Ngo   | 0      |
| **Peter Pan**  | **1**      |
| John Doe   | 2      |
| Tom Platt  | 3      |
| Elise Hans | 4      |
| **Peter Pan**  | **5**      |
And now, based on the **Username**:

| Username   | Credit |
| ---------- | ------ |
| Elise Hans | 4      |
| John Doe   | 2      |
| Luna Ngo   | 0      |
| **Peter Pan**  | **1**      |
| **Peter Pan**  | **5**      |
| Tom Platt  | 3      |
Did you catch it ? Since our sort is **stable**, the records where "Peter Pan" is duplicated still preserved its credit column to be sorted (the order used to be 5 and 1, after this first search is 1 and 5, and after the second search is still 1 and 5)
